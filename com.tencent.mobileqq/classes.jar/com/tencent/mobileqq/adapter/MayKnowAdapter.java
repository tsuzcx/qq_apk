package com.tencent.mobileqq.adapter;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.activity.ProfileActivity;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.contacts.mayknow.ContactReportUtils;
import com.tencent.mobileqq.addfriend.api.IAddFriendApi;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.FriendListHandler;
import com.tencent.mobileqq.app.FriendListObserver;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.MayknowRecommendManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.face.IFaceDecoder;
import com.tencent.mobileqq.avatar.api.IQQAvatarService;
import com.tencent.mobileqq.avatar.listener.DecodeTaskCompletionListener;
import com.tencent.mobileqq.data.MayKnowRecommend;
import com.tencent.mobileqq.profilecard.data.AllInOne;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.util.ProfileCardUtil;
import com.tencent.mobileqq.utils.ImageUtil;
import com.tencent.mobileqq.vas.theme.api.ThemeUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.HorizontalListView;
import com.tencent.widget.HorizontalListView.OnItemScrollEventListener;
import com.tencent.widget.HorizontalListView.OnScrollStateChangedListener;
import com.tencent.widget.ThemeImageView;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;
import mqq.app.AppRuntime;

public class MayKnowAdapter
  extends BaseAdapter
  implements View.OnClickListener, DecodeTaskCompletionListener, HorizontalListView.OnItemScrollEventListener
{
  FriendsManager a;
  MayknowRecommendManager b;
  Activity c;
  protected IFaceDecoder d;
  View.OnTouchListener e = new MayKnowAdapter.1(this);
  View.OnTouchListener f = new MayKnowAdapter.2(this);
  MayKnowAdapter.OnRecommendsCanceledListener g;
  protected Runnable h = new MayKnowAdapter.5(this);
  FriendListObserver i = new MayKnowAdapter.MyFriendListObserver(this);
  private List<MayKnowRecommend> j = new ArrayList();
  private HorizontalListView k;
  private int l;
  private int m;
  private int n = 0;
  private Hashtable<String, Bitmap> o = new Hashtable();
  private QQAppInterface p;
  private int q;
  private HorizontalListView.OnScrollStateChangedListener r = new MayKnowAdapter.6(this);
  private Runnable s = new MayKnowAdapter.7(this);
  
  public MayKnowAdapter(Activity paramActivity, QQAppInterface paramQQAppInterface, HorizontalListView paramHorizontalListView, MayKnowAdapter.OnRecommendsCanceledListener paramOnRecommendsCanceledListener, int paramInt1, int paramInt2)
  {
    paramHorizontalListView.setAdapter(this);
    this.k = paramHorizontalListView;
    this.g = paramOnRecommendsCanceledListener;
    this.c = paramActivity;
    this.p = paramQQAppInterface;
    this.a = ((FriendsManager)paramQQAppInterface.getManager(QQManagerFactory.FRIENDS_MANAGER));
    this.b = ((MayknowRecommendManager)paramQQAppInterface.getManager(QQManagerFactory.MAYKNOW_RECOMMEND_MANAGER));
    this.d = ((IQQAvatarService)paramQQAppInterface.getRuntimeService(IQQAvatarService.class, "")).getInstance(paramQQAppInterface);
    this.d.setDecodeTaskCompletionListener(this);
    this.l = paramInt1;
    this.m = paramInt2;
    this.n = AIOUtils.b(12.0F, this.c.getResources());
    this.k.setOnItemScollEventListener(this);
    paramQQAppInterface.addObserver(this.i);
    h();
    this.q = MayknowRecommendManager.d;
    paramActivity = this.j;
    if ((paramActivity != null) && (paramActivity.size() > 0))
    {
      paramActivity = this.p;
      if (paramActivity != null)
      {
        paramInt1 = this.m;
        if (paramInt1 != 1)
        {
          if (paramInt1 != 2)
          {
            if (paramInt1 != 3)
            {
              if (paramInt1 == 4) {
                ReportController.b(paramActivity, "CliOper", "", "", "0X8006773", "0X8006773", 0, 0, "", "", "", "");
              }
            }
            else {
              ReportController.b(paramActivity, "CliOper", "", "", "0X800673F", "0X800673F", 0, 0, "", "", "", "");
            }
          }
          else {
            ReportController.b(paramActivity, "CliOper", "", "", "0X800673E", "0X800673E", 0, 0, "", "", "", "");
          }
        }
        else {
          ReportController.b(paramActivity, "CliOper", "", "", "0X800674D", "0X800674D", 0, 0, "", "", "", "");
        }
      }
    }
    this.k.setOnScrollStateChangedListener(this.r);
    if (QLog.isColorLevel())
    {
      paramActivity = new StringBuilder();
      paramActivity.append("MayKnowAdapter ,mFriendObserver = ");
      paramActivity.append(this.i);
      QLog.d("MayKnowAdapter", 2, paramActivity.toString());
    }
    this.k.postDelayed(this.s, 1000L);
  }
  
  private View a(String paramString)
  {
    int i1 = 0;
    Object localObject;
    while (i1 < this.k.getChildCount())
    {
      localView = this.k.getChildAt(i1);
      if ((localView != null) && ((localView.getTag() instanceof MayKnowAdapter.MKRViewHolder)))
      {
        localObject = (MayKnowAdapter.MKRViewHolder)localView.getTag();
        if ((localObject != null) && (((MayKnowAdapter.MKRViewHolder)localObject).i != null) && (TextUtils.equals(((MayKnowAdapter.MKRViewHolder)localObject).i.uin, paramString))) {
          break label85;
        }
      }
      i1 += 1;
    }
    View localView = null;
    label85:
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("findTargetDeleteView view:");
      ((StringBuilder)localObject).append(localView);
      ((StringBuilder)localObject).append("   uin:");
      ((StringBuilder)localObject).append(paramString);
      QLog.d("MayKnowAdapter", 2, ((StringBuilder)localObject).toString());
    }
    return localView;
  }
  
  private void a(View paramView)
  {
    a(paramView, new MayKnowAdapter.3(this, paramView));
  }
  
  private void a(View paramView, Animation.AnimationListener paramAnimationListener)
  {
    MayKnowAdapter.4 local4 = new MayKnowAdapter.4(this, paramView, paramView.getMeasuredWidth());
    if (paramAnimationListener != null) {
      local4.setAnimationListener(paramAnimationListener);
    }
    local4.setDuration(240L);
    paramView.startAnimation(local4);
  }
  
  private View f()
  {
    int i1 = 0;
    Object localObject;
    while (i1 < this.k.getChildCount())
    {
      localView = this.k.getChildAt(i1);
      if ((localView != null) && ((localView.getTag() instanceof MayKnowAdapter.MKRViewHolder)))
      {
        localObject = (MayKnowAdapter.MKRViewHolder)localView.getTag();
        if ((localObject != null) && (((MayKnowAdapter.MKRViewHolder)localObject).i != null) && (((MayKnowAdapter.MKRViewHolder)localObject).i.friendStatus != 0)) {
          break label77;
        }
      }
      i1 += 1;
    }
    View localView = null;
    label77:
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("findTargetChangeStatusView view:");
      ((StringBuilder)localObject).append(localView);
      QLog.d("MayKnowAdapter", 2, ((StringBuilder)localObject).toString());
    }
    return localView;
  }
  
  private void g()
  {
    c();
    Object localObject = this.b;
    if (localObject != null) {
      this.j = ((MayknowRecommendManager)localObject).f();
    }
    notifyDataSetChanged();
    localObject = this.j;
    if ((localObject != null) && (((List)localObject).size() != 0))
    {
      localObject = this.g;
      if (localObject != null) {
        ((MayKnowAdapter.OnRecommendsCanceledListener)localObject).b();
      }
    }
    else
    {
      localObject = this.g;
      if (localObject != null) {
        ((MayKnowAdapter.OnRecommendsCanceledListener)localObject).a();
      }
    }
  }
  
  private void h()
  {
    Object localObject = this.b;
    if (localObject != null) {
      this.j = ((MayknowRecommendManager)localObject).f();
    }
    notifyDataSetChanged();
    localObject = this.j;
    if ((localObject != null) && (((List)localObject).size() != 0))
    {
      localObject = this.g;
      if (localObject != null) {
        ((MayKnowAdapter.OnRecommendsCanceledListener)localObject).b();
      }
    }
    else
    {
      localObject = this.g;
      if (localObject != null) {
        ((MayKnowAdapter.OnRecommendsCanceledListener)localObject).a();
      }
    }
  }
  
  protected Bitmap a(int paramInt, String paramString)
  {
    Bitmap localBitmap = this.d.getBitmapFromCache(paramInt, paramString);
    if (localBitmap != null) {
      return localBitmap;
    }
    if (!this.d.isPausing()) {
      this.d.requestDecodeFace(paramString, paramInt, true, (byte)0);
    }
    return ImageUtil.k();
  }
  
  public MayKnowRecommend a(int paramInt)
  {
    Object localObject = this.j;
    if ((localObject != null) && (paramInt >= 0) && (paramInt < ((List)localObject).size())) {
      return (MayKnowRecommend)this.j.get(paramInt);
    }
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("getItem Illegal Adapter with overflowed data,position =  ");
      ((StringBuilder)localObject).append(paramInt);
      QLog.d("MayKnowAdapter", 2, ((StringBuilder)localObject).toString());
    }
    return new MayKnowRecommend();
  }
  
  public void a()
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("startVisibleExpose firstVisible: ");
      localStringBuilder.append(this.k.getFirstVisiblePosition());
      localStringBuilder.append(" lastvisible: ");
      localStringBuilder.append(this.k.getLastVisiblePosition());
      QLog.d("MayKnowAdapter", 2, localStringBuilder.toString());
    }
    if ((getCount() > 0) && (this.k.isShown()) && (this.b != null))
    {
      int i1 = this.k.getFirstVisiblePosition();
      while (i1 <= this.k.getLastVisiblePosition())
      {
        if (i1 < 0) {
          return;
        }
        this.b.a(a(i1), this.l, this.m, 1);
        i1 += 1;
      }
    }
  }
  
  public void b() {}
  
  public void c()
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("stopVisibleExpose firstVisible: ");
      localStringBuilder.append(this.k.getFirstVisiblePosition());
      localStringBuilder.append(" lastvisible: ");
      localStringBuilder.append(this.k.getLastVisiblePosition());
      QLog.d("MayKnowAdapter", 2, localStringBuilder.toString());
    }
    if ((getCount() > 0) && (this.k.isShown()) && (this.b != null))
    {
      int i1 = this.k.getFirstVisiblePosition();
      while (i1 <= this.k.getLastVisiblePosition())
      {
        if (i1 < 0) {
          return;
        }
        this.b.b(a(i1), this.l, this.m, 1);
        i1 += 1;
      }
    }
  }
  
  public void d()
  {
    if (QLog.isColorLevel()) {
      QLog.d("MayKnowAdapter", 2, "destroy");
    }
    Object localObject = this.d;
    if (localObject != null) {
      ((IFaceDecoder)localObject).destory();
    }
    localObject = this.p;
    if (localObject != null)
    {
      ((QQAppInterface)localObject).removeObserver(this.i);
    }
    else
    {
      localObject = BaseApplicationImpl.getApplication().getRuntime();
      if ((localObject instanceof QQAppInterface)) {
        ((QQAppInterface)localObject).removeObserver(this.i);
      }
    }
    localObject = this.k;
    if (localObject != null)
    {
      ((HorizontalListView)localObject).setOnScrollStateChangedListener(null);
      this.k.removeCallbacks(this.s);
    }
    this.a = null;
    this.b = null;
    this.p = null;
  }
  
  public void e()
  {
    Object localObject1 = this.k;
    if ((localObject1 != null) && (((HorizontalListView)localObject1).isShown()))
    {
      localObject1 = this.j;
      if ((localObject1 != null) && (!((List)localObject1).isEmpty()))
      {
        int i2 = this.k.getFirstVisiblePosition();
        int i3 = this.k.getLastVisiblePosition();
        localObject1 = new ArrayList();
        ArrayList localArrayList1 = new ArrayList();
        ArrayList localArrayList2 = new ArrayList();
        ArrayList localArrayList3 = new ArrayList();
        int i1 = i2;
        while (i1 <= i3)
        {
          if ((i1 >= 0) && (i1 < this.j.size()) && (this.j.get(i1) != null))
          {
            ((ArrayList)localObject1).add(((MayKnowRecommend)this.j.get(i1)).uin);
            localArrayList1.add(((MayKnowRecommend)this.j.get(i1)).recommendReason);
            localArrayList2.add(Integer.valueOf(i1));
            localArrayList3.add(((MayKnowRecommend)this.j.get(i1)).algBuffer);
          }
          i1 += 1;
        }
        Object localObject2;
        if (QLog.isColorLevel())
        {
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append("reportRecommendFrdExpose firstVisibleItem: ");
          ((StringBuilder)localObject2).append(i2);
          ((StringBuilder)localObject2).append(" lastVisibleItem: ");
          ((StringBuilder)localObject2).append(i3);
          ((StringBuilder)localObject2).append(" exp_uins: ");
          ((StringBuilder)localObject2).append(localObject1);
          ((StringBuilder)localObject2).append(" exp_reasons:");
          ((StringBuilder)localObject2).append(localArrayList1);
          ((StringBuilder)localObject2).append(" exp_positions:");
          ((StringBuilder)localObject2).append(localArrayList2);
          ((StringBuilder)localObject2).append(" algh_ids:");
          ((StringBuilder)localObject2).append(localArrayList3);
          QLog.d("MayKnowAdapter", 2, ((StringBuilder)localObject2).toString());
        }
        if (!((ArrayList)localObject1).isEmpty())
        {
          localObject2 = this.p;
          if (localObject2 != null) {
            ContactReportUtils.a((QQAppInterface)localObject2, this.l, (ArrayList)localObject1, localArrayList1, localArrayList2, localArrayList3, 1, null);
          }
        }
      }
    }
  }
  
  public int getCount()
  {
    List localList = this.j;
    if (localList == null) {
      return 0;
    }
    int i1 = localList.size();
    int i2 = this.q;
    if (i1 > i2) {
      return i2;
    }
    return this.j.size();
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("getView position: ");
      ((StringBuilder)localObject1).append(paramInt);
      QLog.d("MayKnowAdapter", 2, ((StringBuilder)localObject1).toString());
    }
    Object localObject1 = null;
    if (paramView != null) {
      localObject1 = (MayKnowAdapter.MKRViewHolder)paramView.getTag();
    }
    Object localObject2;
    if ((paramView != null) && (localObject1 != null) && (!((MayKnowAdapter.MKRViewHolder)localObject1).j))
    {
      localObject2 = localObject1;
      if (TextUtils.equals(((MayKnowAdapter.MKRViewHolder)localObject1).k, ThemeUtil.curThemeId)) {}
    }
    else
    {
      paramView = LayoutInflater.from(this.c).inflate(2131624054, paramViewGroup, false);
      localObject2 = new MayKnowAdapter.MKRViewHolder();
      ((MayKnowAdapter.MKRViewHolder)localObject2).c = ((ImageView)paramView.findViewById(2131434916));
      ((MayKnowAdapter.MKRViewHolder)localObject2).e = ((TextView)paramView.findViewById(2131439319));
      ((MayKnowAdapter.MKRViewHolder)localObject2).e.getPaint();
      ((MayKnowAdapter.MKRViewHolder)localObject2).f = ((TextView)paramView.findViewById(2131433835));
      ((MayKnowAdapter.MKRViewHolder)localObject2).g = ((TextView)paramView.findViewById(2131427507));
      ((MayKnowAdapter.MKRViewHolder)localObject2).h = ((TextView)paramView.findViewById(2131427775));
      ((MayKnowAdapter.MKRViewHolder)localObject2).d = paramView.findViewById(2131430806);
      ((MayKnowAdapter.MKRViewHolder)localObject2).d.setOnClickListener(this);
      ((MayKnowAdapter.MKRViewHolder)localObject2).d.setOnTouchListener(this.e);
      ((MayKnowAdapter.MKRViewHolder)localObject2).c.setOnClickListener(this);
      ((MayKnowAdapter.MKRViewHolder)localObject2).c.setOnTouchListener(this.f);
      if ((((MayKnowAdapter.MKRViewHolder)localObject2).c instanceof ThemeImageView)) {
        ((ThemeImageView)((MayKnowAdapter.MKRViewHolder)localObject2).c).setSupportMaskView(false);
      }
      ((MayKnowAdapter.MKRViewHolder)localObject2).e.setOnClickListener(this);
      ((MayKnowAdapter.MKRViewHolder)localObject2).e.setOnTouchListener(this.e);
      paramView.setTag(localObject2);
      if (this.l != 25)
      {
        ((MayKnowAdapter.MKRViewHolder)localObject2).e.setTextColor(this.c.getResources().getColor(2131167993));
        ((MayKnowAdapter.MKRViewHolder)localObject2).f.setTextColor(this.c.getResources().getColor(2131168133));
      }
      ((MayKnowAdapter.MKRViewHolder)localObject2).k = ThemeUtil.curThemeId;
    }
    localObject1 = a(paramInt);
    Object localObject3 = this.b;
    if (localObject3 != null) {
      ((MayknowRecommendManager)localObject3).a((MayKnowRecommend)localObject1, this.l, this.m, 1);
    }
    localObject3 = new StringBuilder();
    ((MayKnowAdapter.MKRViewHolder)localObject2).a = ((MayKnowRecommend)localObject1).uin;
    ((MayKnowAdapter.MKRViewHolder)localObject2).i = ((MayKnowRecommend)localObject1);
    ((MayKnowAdapter.MKRViewHolder)localObject2).d.setTag(localObject1);
    ((MayKnowAdapter.MKRViewHolder)localObject2).c.setTag(localObject2);
    ((MayKnowAdapter.MKRViewHolder)localObject2).e.setTag(localObject2);
    ((MayKnowAdapter.MKRViewHolder)localObject2).c.setImageBitmap(a(1, ((MayKnowAdapter.MKRViewHolder)localObject2).a));
    Object localObject4 = this.b;
    boolean bool;
    if (localObject4 != null) {
      bool = ((MayknowRecommendManager)localObject4).m();
    } else {
      bool = false;
    }
    localObject4 = ((MayKnowRecommend)localObject1).getDisplayName(bool);
    ((MayKnowAdapter.MKRViewHolder)localObject2).e.setText((CharSequence)localObject4);
    if ((AppSetting.e) && (!TextUtils.isEmpty((CharSequence)localObject4))) {
      ((StringBuilder)localObject3).append((String)localObject4);
    }
    if (!TextUtils.isEmpty(((MayKnowRecommend)localObject1).recommendReason))
    {
      ((MayKnowAdapter.MKRViewHolder)localObject2).f.setText(((MayKnowRecommend)localObject1).recommendReason);
      if (AppSetting.e)
      {
        ((StringBuilder)localObject3).append(",你们有");
        ((StringBuilder)localObject3).append(((MayKnowRecommend)localObject1).recommendReason);
      }
    }
    else
    {
      ((MayKnowAdapter.MKRViewHolder)localObject2).f.setText("");
    }
    if (((MayKnowRecommend)localObject1).friendStatus == 0)
    {
      ((MayKnowAdapter.MKRViewHolder)localObject2).g.setVisibility(0);
      ((MayKnowAdapter.MKRViewHolder)localObject2).g.setTag(localObject1);
      ((MayKnowAdapter.MKRViewHolder)localObject2).h.setVisibility(8);
      ((MayKnowAdapter.MKRViewHolder)localObject2).g.setOnClickListener(this);
      if (AppSetting.e)
      {
        ((MayKnowAdapter.MKRViewHolder)localObject2).g.setContentDescription(HardCodeUtil.a(2131886199));
        ((StringBuilder)localObject3).append(",添加他为好友");
      }
    }
    else if (((MayKnowRecommend)localObject1).friendStatus == 1)
    {
      ((MayKnowAdapter.MKRViewHolder)localObject2).g.setVisibility(8);
      ((MayKnowAdapter.MKRViewHolder)localObject2).h.setVisibility(0);
      ((MayKnowAdapter.MKRViewHolder)localObject2).h.setText(2131915704);
      if (AppSetting.e)
      {
        ((MayKnowAdapter.MKRViewHolder)localObject2).h.setContentDescription(this.c.getResources().getString(2131915704));
        ((StringBuilder)localObject3).append(",等待验证");
      }
    }
    else
    {
      ((MayKnowAdapter.MKRViewHolder)localObject2).g.setVisibility(8);
      ((MayKnowAdapter.MKRViewHolder)localObject2).h.setVisibility(0);
      ((MayKnowAdapter.MKRViewHolder)localObject2).h.setText(2131886630);
      if (AppSetting.e)
      {
        ((MayKnowAdapter.MKRViewHolder)localObject2).h.setContentDescription(this.c.getResources().getString(2131886630));
        ((StringBuilder)localObject3).append(",已添加");
      }
    }
    if (paramInt == getCount() - 1) {
      paramView.setPadding(0, 0, this.n, 0);
    } else {
      paramView.setPadding(0, 0, 0, 0);
    }
    if (AppSetting.e) {
      paramView.setContentDescription(((StringBuilder)localObject3).toString());
    }
    EventCollector.getInstance().onListGetView(paramInt, paramView, paramViewGroup, getItemId(paramInt));
    return paramView;
  }
  
  public void onClick(View paramView)
  {
    int i1 = paramView.getId();
    boolean bool2 = false;
    boolean bool1 = false;
    Object localObject1;
    Object localObject2;
    switch (i1)
    {
    default: 
      break;
    case 2131434916: 
    case 2131439319: 
      localObject1 = (MayKnowAdapter.MKRViewHolder)paramView.getTag();
      if (localObject1 != null)
      {
        localObject1 = ((MayKnowAdapter.MKRViewHolder)localObject1).i;
        if (localObject1 != null)
        {
          i1 = 84;
          int i2 = this.l;
          if (i2 != 3)
          {
            if (i2 != 21)
            {
              if (i2 != 23)
              {
                if (i2 != 25)
                {
                  if (i2 == 28) {
                    i1 = 107;
                  }
                }
                else {
                  i1 = 102;
                }
              }
              else {
                i1 = 81;
              }
            }
            else {
              i1 = 82;
            }
          }
          else {
            i1 = 83;
          }
          localObject2 = this.a;
          i2 = i1;
          if (localObject2 != null)
          {
            i2 = i1;
            if (((FriendsManager)localObject2).n(((MayKnowRecommend)localObject1).uin)) {
              i2 = 1;
            }
          }
          localObject2 = new AllInOne(((MayKnowRecommend)localObject1).uin, i2);
          Object localObject3 = this.b;
          if (localObject3 != null) {
            bool1 = ((MayknowRecommendManager)localObject3).m();
          }
          localObject3 = ((MayKnowRecommend)localObject1).getRecommendName(bool1);
          if (!TextUtils.isEmpty((CharSequence)localObject3)) {
            ((AllInOne)localObject2).recommendName = ((String)localObject3);
          }
          if (!TextUtils.isEmpty(((MayKnowRecommend)localObject1).nick)) {
            ((AllInOne)localObject2).nickname = ((MayKnowRecommend)localObject1).nick;
          }
          ((AllInOne)localObject2).profileEntryType = 88;
          localObject3 = new Bundle();
          ((Bundle)localObject3).putString("recommend_reason", ((MayKnowRecommend)localObject1).recommendReason);
          List localList = this.j;
          if (localList != null) {
            ((Bundle)localObject3).putInt("recommend_pos", localList.indexOf(localObject1));
          }
          ((Bundle)localObject3).putByteArray("recommend_algh_id", ((MayKnowRecommend)localObject1).algBuffer);
          ((Bundle)localObject3).putInt("key_display_type", 1);
          ProfileActivity.a(this.c, (AllInOne)localObject2, (Bundle)localObject3);
          localObject2 = this.b;
          if (localObject2 != null) {
            ((MayknowRecommendManager)localObject2).a((MayKnowRecommend)localObject1, this.l, this.m, 2);
          }
          localObject2 = this.p;
          if (localObject2 != null)
          {
            i1 = this.m;
            if (i1 != 1)
            {
              if (i1 != 2)
              {
                if (i1 != 3)
                {
                  if (i1 == 4) {
                    ReportController.b((AppRuntime)localObject2, "CliOper", "", "", "0X800678A", "0X800678A", 0, 0, "", "", "", "");
                  }
                }
                else {
                  ReportController.b((AppRuntime)localObject2, "CliOper", "", "", "0X8006741", "0X8006741", 0, 0, "", "", "", "");
                }
              }
              else {
                ReportController.b((AppRuntime)localObject2, "CliOper", "", "", "0X8006740", "0X8006740", 0, 0, "", "", "", "");
              }
            }
            else {
              ReportController.b((AppRuntime)localObject2, "CliOper", "", "", "0X800674E", "0X800674E", 0, 0, "", "", "", "");
            }
          }
          if (this.j != null)
          {
            localObject2 = this.p;
            if (localObject2 != null) {
              ContactReportUtils.a((QQAppInterface)localObject2, ((MayKnowRecommend)localObject1).uin, "frd_list_clk", this.l, 0, ((MayKnowRecommend)localObject1).recommendReason, this.j.indexOf(localObject1), ((MayKnowRecommend)localObject1).algBuffer, 1);
            }
          }
        }
      }
      break;
    case 2131430806: 
      localObject1 = (MayKnowRecommend)paramView.getTag();
      if (localObject1 != null)
      {
        localObject2 = this.p;
        if (localObject2 != null)
        {
          ((FriendListHandler)((QQAppInterface)localObject2).getBusinessHandler(BusinessHandlerFactory.FRIENDLIST_HANDLER)).cancelMayKnowRecommend(((MayKnowRecommend)localObject1).uin);
          i1 = this.m;
          if (i1 != 1)
          {
            if (i1 != 2)
            {
              if (i1 != 3)
              {
                if (i1 == 4) {
                  ReportController.b(this.p, "CliOper", "", "", "0X8006772", "0X8006772", 0, 0, "", "", "", "");
                }
              }
              else {
                ReportController.b(this.p, "CliOper", "", "", "0X8006743", "0X8006743", 0, 0, "", "", "", "");
              }
            }
            else {
              ReportController.b(this.p, "CliOper", "", "", "0X8006742", "0X8006742", 0, 0, "", "", "", "");
            }
          }
          else {
            ReportController.b(this.p, "CliOper", "", "", "0X800674F", "0X800674F", 0, 0, "", "", "", "");
          }
          if (this.j != null)
          {
            localObject2 = this.p;
            if (localObject2 != null) {
              ContactReportUtils.a((QQAppInterface)localObject2, ((MayKnowRecommend)localObject1).uin, "frd_list_dlt", this.l, 0, ((MayKnowRecommend)localObject1).recommendReason, this.j.indexOf(localObject1), ((MayKnowRecommend)localObject1).algBuffer, 1);
            }
          }
        }
      }
      break;
    case 2131427507: 
      localObject1 = (MayKnowRecommend)paramView.getTag();
      if (localObject1 != null)
      {
        localObject2 = this.a;
        if ((localObject2 != null) && (!((FriendsManager)localObject2).n(((MayKnowRecommend)localObject1).uin)) && (!this.a.v(((MayKnowRecommend)localObject1).uin)))
        {
          localObject2 = this.b;
          bool1 = bool2;
          if (localObject2 != null) {
            bool1 = ((MayknowRecommendManager)localObject2).m();
          }
          localObject2 = ((MayKnowRecommend)localObject1).getDisplayName(bool1);
          localObject2 = ((IAddFriendApi)QRoute.api(IAddFriendApi.class)).startAddFriend(this.c, 1, ((MayKnowRecommend)localObject1).uin, null, 3045, this.l, (String)localObject2, null, null, this.c.getString(2131886199), null);
          ((Intent)localObject2).putExtra("key_param_age_area", ProfileCardUtil.a(this.c, ((MayKnowRecommend)localObject1).gender, ((MayKnowRecommend)localObject1).age, ((MayKnowRecommend)localObject1).country, ((MayKnowRecommend)localObject1).province, ((MayKnowRecommend)localObject1).city));
          ((IAddFriendApi)QRoute.api(IAddFriendApi.class)).launchAddFriend(this.c, (Intent)localObject2);
          localObject2 = this.p;
          if (localObject2 != null)
          {
            i1 = this.m;
            if (i1 != 1)
            {
              if (i1 != 2)
              {
                if (i1 != 3)
                {
                  if (i1 == 4) {
                    ReportController.b((AppRuntime)localObject2, "CliOper", "", "", "0X8006771", "0X8006771", 0, 0, "", "", "", "");
                  }
                }
                else {
                  ReportController.b((AppRuntime)localObject2, "CliOper", "", "", "0X8006745", "0X8006745", 0, 0, "", "", "", "");
                }
              }
              else {
                ReportController.b((AppRuntime)localObject2, "CliOper", "", "", "0X8006744", "0X8006744", 0, 0, "", "", "", "");
              }
            }
            else {
              ReportController.b((AppRuntime)localObject2, "CliOper", "", "", "0X8006750", "0X8006750", 0, 0, "", "", "", "");
            }
          }
        }
        else
        {
          localObject2 = this.a;
          if ((localObject2 != null) && (((FriendsManager)localObject2).n(((MayKnowRecommend)localObject1).uin)))
          {
            ((MayKnowRecommend)localObject1).friendStatus = 2;
            notifyDataSetChanged();
          }
          else
          {
            ((MayKnowRecommend)localObject1).friendStatus = 1;
            notifyDataSetChanged();
          }
        }
        localObject2 = this.b;
        if (localObject2 != null) {
          ((MayknowRecommendManager)localObject2).a((MayKnowRecommend)localObject1, this.l, this.m, 3);
        }
        if (this.j != null)
        {
          localObject2 = this.p;
          if (localObject2 != null) {
            ContactReportUtils.a((QQAppInterface)localObject2, ((MayKnowRecommend)localObject1).uin, "frd_list_add", this.l, 1, ((MayKnowRecommend)localObject1).recommendReason, this.j.indexOf(localObject1), ((MayKnowRecommend)localObject1).algBuffer, 1);
          }
        }
      }
      break;
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
  
  public void onDecodeTaskCompleted(int paramInt1, int paramInt2, String paramString, Bitmap paramBitmap)
  {
    if (paramBitmap != null) {
      this.o.put(paramString, paramBitmap);
    }
    if (paramInt1 <= 0)
    {
      paramInt2 = this.k.getChildCount();
      paramInt1 = 0;
      while (paramInt1 < paramInt2)
      {
        paramString = this.k.getChildAt(paramInt1).getTag();
        if ((paramString != null) && ((paramString instanceof MayKnowAdapter.MKRViewHolder)))
        {
          paramString = (MayKnowAdapter.MKRViewHolder)paramString;
          if ((paramString != null) && (paramString.a != null) && (paramString.a.length() > 0))
          {
            paramBitmap = (Bitmap)this.o.get(paramString.a);
            if (paramBitmap != null) {
              paramString.c.setImageBitmap(paramBitmap);
            }
          }
        }
        paramInt1 += 1;
      }
      this.o.clear();
    }
  }
  
  public void onItemScrollNonVisible(int paramInt, boolean paramBoolean)
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("onItemScrollNonVisible ");
      ((StringBuilder)localObject).append(paramInt);
      ((StringBuilder)localObject).append(" fromLeft=");
      ((StringBuilder)localObject).append(paramBoolean);
      QLog.d("MayKnowAdapter", 2, ((StringBuilder)localObject).toString());
    }
    Object localObject = this.b;
    if (localObject != null) {
      ((MayknowRecommendManager)localObject).b(a(paramInt), this.l, this.m, 1);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.adapter.MayKnowAdapter
 * JD-Core Version:    0.7.0.1
 */