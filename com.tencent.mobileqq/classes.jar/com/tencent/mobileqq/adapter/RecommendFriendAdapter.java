package com.tencent.mobileqq.adapter;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.activity.ProfileActivity;
import com.tencent.mobileqq.activity.contacts.mayknow.ContactReportUtils;
import com.tencent.mobileqq.addfriend.api.IAddFriendApi;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.FriendListHandler;
import com.tencent.mobileqq.app.FriendListObserver;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.MayknowRecommendManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.face.IFaceDecoder;
import com.tencent.mobileqq.data.MayKnowRecommend;
import com.tencent.mobileqq.data.RecommendLabel;
import com.tencent.mobileqq.newfriend.api.INewFriendApi;
import com.tencent.mobileqq.newfriend.constant.INewFriendConstant.BaseBuilder;
import com.tencent.mobileqq.profilecard.data.AllInOne;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.richstatus.IIconListener;
import com.tencent.mobileqq.richstatus.StatusManager;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.troop.widget.TroopLabelLayout;
import com.tencent.mobileqq.util.ProfileCardUtil;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.vas.theme.api.ThemeUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.AbsListView;
import com.tencent.widget.AbsListView.OnScrollListener;
import com.tencent.widget.SwipListView.SwipListListener;
import com.tencent.widget.SwipRightMenuBuilder;
import com.tencent.widget.SwipRightMenuBuilder.SwipItemBaseHolder;
import com.tencent.widget.ThemeImageView;
import com.tencent.widget.XListView;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class RecommendFriendAdapter
  extends FacePreloadBaseAdapter
  implements View.OnClickListener, SwipListView.SwipListListener
{
  MayKnowAdapter.OnRecommendsCanceledListener a;
  int b;
  SwipRightMenuBuilder c;
  protected Runnable d = new RecommendFriendAdapter.2(this);
  FriendListObserver e = new RecommendFriendAdapter.3(this);
  int f = -1;
  protected Runnable g = new RecommendFriendAdapter.6(this);
  private List<MayKnowRecommend> h = new ArrayList();
  private Context j;
  private QQAppInterface k;
  private MayknowRecommendManager l;
  private XListView m;
  private int n;
  private int o;
  private StatusManager p;
  private Resources q;
  private String r = "";
  private IIconListener s = new RecommendFriendAdapter.1(this);
  private AbsListView.OnScrollListener t = new RecommendFriendAdapter.5(this);
  
  public RecommendFriendAdapter(Context paramContext, QQAppInterface paramQQAppInterface, XListView paramXListView, int paramInt, MayKnowAdapter.OnRecommendsCanceledListener paramOnRecommendsCanceledListener)
  {
    super(paramContext, paramQQAppInterface, paramXListView, 1, true);
    this.j = paramContext;
    this.k = paramQQAppInterface;
    this.q = this.j.getResources();
    this.l = ((MayknowRecommendManager)paramQQAppInterface.getManager(QQManagerFactory.MAYKNOW_RECOMMEND_MANAGER));
    paramXListView.setAdapter(this);
    this.m = paramXListView;
    this.n = paramInt;
    this.o = 3;
    paramInt = this.n;
    if (paramInt == 8) {
      this.o = 24;
    } else if ((paramInt != 3) && (paramInt != 6))
    {
      if (paramInt == 10) {
        this.o = 28;
      }
    }
    else {
      this.o = 21;
    }
    this.p = ((StatusManager)paramQQAppInterface.getManager(QQManagerFactory.STATUS_MANAGER));
    this.p.a(this.s);
    this.a = paramOnRecommendsCanceledListener;
    a(this.t);
    this.k.addObserver(this.e);
    this.c = a(paramContext);
  }
  
  public static void a(View paramView, boolean paramBoolean)
  {
    if (paramView != null)
    {
      if (paramView.findViewById(2131444905) == null) {
        return;
      }
      paramView = paramView.findViewById(2131444905);
      Object localObject = paramView.getTag(2131435571);
      if ((localObject == null) || (!(localObject instanceof Boolean)) || (((Boolean)localObject).booleanValue() != paramBoolean))
      {
        paramView.setTag(2131435571, Boolean.valueOf(paramBoolean));
        if (paramBoolean)
        {
          paramView.setBackgroundResource(2130839579);
          return;
        }
        if (ThemeUtil.isDefaultTheme())
        {
          paramView.setBackgroundResource(2130839577);
          return;
        }
        paramView.setBackgroundResource(2130839574);
      }
    }
  }
  
  private void e()
  {
    Object localObject = this.l.f();
    MayKnowAdapter.OnRecommendsCanceledListener localOnRecommendsCanceledListener = this.a;
    if ((localOnRecommendsCanceledListener != null) && ((localOnRecommendsCanceledListener instanceof MayKnowAdapter.OnRecommendsUpdateListener))) {
      ((MayKnowAdapter.OnRecommendsUpdateListener)localOnRecommendsCanceledListener).a((List)localObject);
    }
    if ((localObject != null) && (((List)localObject).size() > 0))
    {
      a((List)localObject);
      localObject = this.a;
      if (localObject != null) {
        ((MayKnowAdapter.OnRecommendsCanceledListener)localObject).b();
      }
    }
    else
    {
      a(new ArrayList());
      localObject = this.a;
      if (localObject != null) {
        ((MayKnowAdapter.OnRecommendsCanceledListener)localObject).a();
      }
    }
  }
  
  protected View a(Context paramContext, int paramInt, RecommendFriendAdapter.RecFriendViewHolder paramRecFriendViewHolder)
  {
    View localView = LayoutInflater.from(paramContext).inflate(paramInt, null);
    return this.c.createView(paramContext, localView, paramRecFriendViewHolder, -1);
  }
  
  protected SwipRightMenuBuilder a(Context paramContext)
  {
    int i = paramContext.getResources().getDimensionPixelSize(2131299607);
    int i1 = paramContext.getResources().getDimensionPixelSize(2131299608);
    paramContext = INewFriendConstant.BaseBuilder.c;
    int[] arrayOfInt1 = INewFriendConstant.BaseBuilder.a;
    int[] arrayOfInt2 = INewFriendConstant.BaseBuilder.b;
    return new RecommendFriendAdapter.4(this, 1, 2, new int[] { i, i1 }, -1, paramContext, arrayOfInt1, arrayOfInt2);
  }
  
  public void a()
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("stopVisibleExpose firstVisible: ");
      ((StringBuilder)localObject).append(this.m.getFirstVisiblePosition());
      ((StringBuilder)localObject).append(" lastvisible: ");
      ((StringBuilder)localObject).append(this.m.getLastVisiblePosition());
      QLog.d("RecommendFriendAdapter", 2, ((StringBuilder)localObject).toString());
    }
    if ((getCount() > 0) && (this.m.isShown()))
    {
      int i = this.m.getFirstVisiblePosition();
      while (i <= this.m.getLastVisiblePosition())
      {
        localObject = (MayKnowRecommend)getItem(i);
        this.l.b((MayKnowRecommend)localObject, this.o, this.n, 1);
        i += 1;
      }
    }
    Object localObject = this.m;
    if (localObject != null) {
      ((XListView)localObject).removeCallbacks(this.g);
    }
  }
  
  public void a(int paramInt)
  {
    this.b = paramInt;
  }
  
  protected void a(Context paramContext, View paramView, int paramInt, Object paramObject, SwipRightMenuBuilder.SwipItemBaseHolder paramSwipItemBaseHolder, View.OnClickListener paramOnClickListener)
  {
    SwipRightMenuBuilder localSwipRightMenuBuilder = this.c;
    int i;
    if (localSwipRightMenuBuilder != null) {
      i = localSwipRightMenuBuilder.updateRightMenuView(paramContext, paramView, paramInt, paramObject, paramSwipItemBaseHolder, paramOnClickListener);
    } else {
      i = 0;
    }
    int i1 = paramView.getScrollX();
    if ((paramInt >= 0) && (this.f == paramInt))
    {
      paramView.scrollTo(i, 0);
      return;
    }
    if (i1 != 0) {
      paramView.scrollTo(0, 0);
    }
  }
  
  public void a(String paramString)
  {
    this.r = paramString;
    if (this.r == null) {
      this.r = "";
    }
  }
  
  public void a(List<MayKnowRecommend> paramList)
  {
    if ((!TextUtils.isEmpty(this.r)) && (paramList != null) && (paramList.size() > 0))
    {
      Object localObject2 = null;
      Iterator localIterator = paramList.iterator();
      Object localObject1;
      do
      {
        localObject1 = localObject2;
        if (!localIterator.hasNext()) {
          break;
        }
        localObject1 = (MayKnowRecommend)localIterator.next();
      } while (!this.r.equals(((MayKnowRecommend)localObject1).uin));
      if (localObject1 != null)
      {
        paramList.remove(localObject1);
        paramList.add(0, localObject1);
      }
    }
    this.h = paramList;
    if (this.h == null) {
      this.h = new ArrayList();
    }
    notifyDataSetChanged();
  }
  
  public void b()
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("onResume firstVisible: ");
      ((StringBuilder)localObject).append(this.m.getFirstVisiblePosition());
      ((StringBuilder)localObject).append(" lastvisible: ");
      ((StringBuilder)localObject).append(this.m.getLastVisiblePosition());
      QLog.d("RecommendFriendAdapter", 2, ((StringBuilder)localObject).toString());
    }
    if ((getCount() > 0) && (this.m.isShown()))
    {
      int i = this.m.getFirstVisiblePosition();
      while (i <= this.m.getLastVisiblePosition())
      {
        localObject = (MayKnowRecommend)getItem(i);
        this.l.a((MayKnowRecommend)localObject, this.o, this.n, 1);
        i += 1;
      }
    }
    Object localObject = this.m;
    if (localObject != null)
    {
      ((XListView)localObject).removeCallbacks(this.g);
      this.m.postDelayed(this.g, 1000L);
    }
  }
  
  public void b(int paramInt)
  {
    this.o = paramInt;
  }
  
  public void c()
  {
    this.p.b(this.s);
    if (this.i != null) {
      this.i.destory();
    }
    a(null);
    this.k.removeObserver(this.e);
    XListView localXListView = this.m;
    if (localXListView != null) {
      localXListView.removeCallbacks(this.d);
    }
  }
  
  public void d()
  {
    Object localObject = this.m;
    if ((localObject != null) && (((XListView)localObject).isShown()) && (!this.h.isEmpty()))
    {
      this.m.removeCallbacks(this.g);
      int i1 = this.m.getFirstVisiblePosition();
      int i2 = this.m.getLastVisiblePosition();
      ArrayList localArrayList1 = new ArrayList();
      ArrayList localArrayList2 = new ArrayList();
      ArrayList localArrayList3 = new ArrayList();
      ArrayList localArrayList4 = new ArrayList();
      int i = i1;
      while (i <= i2)
      {
        if ((i >= 0) && (i < this.h.size()) && (this.h.get(i) != null))
        {
          localArrayList1.add(((MayKnowRecommend)this.h.get(i)).uin);
          localArrayList2.add(((MayKnowRecommend)this.h.get(i)).recommendReason);
          localArrayList3.add(Integer.valueOf(i));
          localArrayList4.add(((MayKnowRecommend)this.h.get(i)).algBuffer);
        }
        i += 1;
      }
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("reportRecommendFrdExpose firstVisibleItem: ");
        ((StringBuilder)localObject).append(i1);
        ((StringBuilder)localObject).append(" lastVisibleItem: ");
        ((StringBuilder)localObject).append(i2);
        ((StringBuilder)localObject).append(" exp_uins: ");
        ((StringBuilder)localObject).append(localArrayList1);
        ((StringBuilder)localObject).append(" exp_reasons:");
        ((StringBuilder)localObject).append(localArrayList2);
        ((StringBuilder)localObject).append(" exp_positions:");
        ((StringBuilder)localObject).append(localArrayList3);
        ((StringBuilder)localObject).append(" algh_ids:");
        ((StringBuilder)localObject).append(localArrayList4);
        QLog.d("RecommendFriendAdapter", 2, ((StringBuilder)localObject).toString());
      }
      if (!localArrayList1.isEmpty())
      {
        if (this.o == 21) {
          i = 2;
        } else {
          i = 0;
        }
        if (this.o == 24) {
          localObject = "2";
        } else {
          localObject = "";
        }
        ContactReportUtils.a(this.k, this.o, localArrayList1, localArrayList2, localArrayList3, localArrayList4, i, (String)localObject);
      }
    }
  }
  
  public int getCount()
  {
    return this.h.size();
  }
  
  public Object getItem(int paramInt)
  {
    if ((paramInt >= 0) && (paramInt < this.h.size())) {
      return this.h.get(paramInt);
    }
    return new MayKnowRecommend();
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    RecommendFriendAdapter.RecFriendViewHolder localRecFriendViewHolder;
    if (paramView == null)
    {
      localRecFriendViewHolder = new RecommendFriendAdapter.RecFriendViewHolder();
      paramView = a(this.j, 2131627872, localRecFriendViewHolder);
      localRecFriendViewHolder.f = ((TextView)paramView.findViewById(2131438023));
      localRecFriendViewHolder.e = ((TroopLabelLayout)paramView.findViewById(2131448010));
      localRecFriendViewHolder.e.setLabelType(1);
      localRecFriendViewHolder.A = ((ImageView)paramView.findViewById(2131427337));
      localRecFriendViewHolder.a = ((TextView)paramView.findViewById(2131439320));
      localRecFriendViewHolder.b = ((Button)paramView.findViewById(2131444718));
      localRecFriendViewHolder.c = ((TextView)paramView.findViewById(2131444726));
      paramView.setTag(localRecFriendViewHolder);
      if ((localRecFriendViewHolder.A instanceof ThemeImageView)) {
        ((ThemeImageView)localRecFriendViewHolder.A).setSupportMaskView(false);
      }
      ((INewFriendApi)QRoute.api(INewFriendApi.class)).updateItemBgKeepPadding(localRecFriendViewHolder.leftView, false);
    }
    else
    {
      localRecFriendViewHolder = (RecommendFriendAdapter.RecFriendViewHolder)paramView.getTag();
    }
    MayKnowRecommend localMayKnowRecommend = (MayKnowRecommend)getItem(paramInt);
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder(512);
      ((StringBuilder)localObject).append("getView position: ");
      ((StringBuilder)localObject).append(paramInt);
      ((StringBuilder)localObject).append(", mobile_name : ");
      ((StringBuilder)localObject).append(localMayKnowRecommend.mobile_name);
      ((StringBuilder)localObject).append(", remark : ");
      ((StringBuilder)localObject).append(localMayKnowRecommend.remark);
      ((StringBuilder)localObject).append(", nick : ");
      ((StringBuilder)localObject).append(localMayKnowRecommend.nick);
      ((StringBuilder)localObject).append(", gender : ");
      ((StringBuilder)localObject).append(localMayKnowRecommend.gender);
      ((StringBuilder)localObject).append(", age : ");
      ((StringBuilder)localObject).append(localMayKnowRecommend.age);
      ((StringBuilder)localObject).append(", category : ");
      ((StringBuilder)localObject).append(localMayKnowRecommend.category);
      ((StringBuilder)localObject).append(", recommendReason : ");
      ((StringBuilder)localObject).append(localMayKnowRecommend.recommendReason);
      ((StringBuilder)localObject).append(", hasQZoneUpdate : ");
      ((StringBuilder)localObject).append(localMayKnowRecommend.hasQZoneUpdate);
      ((StringBuilder)localObject).append(", signature : ");
      ((StringBuilder)localObject).append(localMayKnowRecommend.richSingature);
      QLog.d("RecommendFriendAdapter", 2, ((StringBuilder)localObject).toString());
    }
    localRecFriendViewHolder.y = localMayKnowRecommend.uin;
    localRecFriendViewHolder.d = localMayKnowRecommend;
    this.l.a(localMayKnowRecommend, this.o, this.n, 1);
    Object localObject = localMayKnowRecommend.getDisplayName(this.l.m());
    if (!TextUtils.isEmpty((CharSequence)localObject))
    {
      localRecFriendViewHolder.a.setVisibility(0);
      localRecFriendViewHolder.a.setText((CharSequence)localObject);
    }
    else
    {
      localRecFriendViewHolder.a.setVisibility(8);
    }
    paramView.setTag(-1, Integer.valueOf(paramInt));
    a(this.j, paramView, paramInt, localMayKnowRecommend, localRecFriendViewHolder, this);
    localRecFriendViewHolder.leftView.setTag(localMayKnowRecommend);
    localObject = new StringBuilder();
    if (!TextUtils.isEmpty(localMayKnowRecommend.category))
    {
      ((StringBuilder)localObject).append(localMayKnowRecommend.category);
      ((StringBuilder)localObject).append(" ");
    }
    if (!TextUtils.isEmpty(localMayKnowRecommend.recommendReason)) {
      ((StringBuilder)localObject).append(localMayKnowRecommend.recommendReason);
    }
    localObject = ((StringBuilder)localObject).toString();
    if (!TextUtils.isEmpty((CharSequence)localObject))
    {
      localRecFriendViewHolder.f.setVisibility(0);
      localRecFriendViewHolder.f.setText((CharSequence)localObject);
    }
    else
    {
      localRecFriendViewHolder.f.setVisibility(8);
    }
    localRecFriendViewHolder.e.a(RecommendLabel.convertToRecommendLabel(localMayKnowRecommend.msgLabel), localMayKnowRecommend.gender, localMayKnowRecommend.age);
    if (localMayKnowRecommend.friendStatus == 0)
    {
      localRecFriendViewHolder.b.setOnClickListener(this);
      localRecFriendViewHolder.b.setVisibility(0);
      localRecFriendViewHolder.b.setTag(localMayKnowRecommend);
      localRecFriendViewHolder.b.setText(HardCodeUtil.a(2131886199));
      localRecFriendViewHolder.c.setVisibility(8);
      if (AppSetting.e) {
        localRecFriendViewHolder.b.setContentDescription(HardCodeUtil.a(2131886199));
      }
    }
    else if (localMayKnowRecommend.friendStatus == 1)
    {
      localRecFriendViewHolder.b.setVisibility(8);
      localRecFriendViewHolder.c.setVisibility(0);
      localRecFriendViewHolder.c.setText(2131915704);
      if (AppSetting.e) {
        localRecFriendViewHolder.c.setContentDescription(this.j.getResources().getString(2131915704));
      }
    }
    else
    {
      localRecFriendViewHolder.b.setVisibility(8);
      localRecFriendViewHolder.c.setVisibility(0);
      localRecFriendViewHolder.c.setText(2131886630);
      if (AppSetting.e) {
        localRecFriendViewHolder.c.setContentDescription(this.j.getResources().getString(2131886630));
      }
    }
    paramView.setOnClickListener(this);
    localRecFriendViewHolder.leftView.setOnClickListener(this);
    localRecFriendViewHolder.A.setImageBitmap(a(1, localRecFriendViewHolder.y));
    a(paramView, localMayKnowRecommend.bHighLight);
    EventCollector.getInstance().onListGetView(paramInt, paramView, paramViewGroup, getItemId(paramInt));
    return paramView;
  }
  
  public void hideMenuPop() {}
  
  public void interceptTouchEvent(boolean paramBoolean) {}
  
  public void onClick(View paramView)
  {
    int i = paramView.getId();
    int i1 = 0;
    MayKnowRecommend localMayKnowRecommend;
    Object localObject1;
    Object localObject2;
    if (i != 2131438111)
    {
      boolean bool;
      if (i != 2131444718)
      {
        if (i == 2131444905)
        {
          localMayKnowRecommend = (MayKnowRecommend)paramView.getTag();
          if (localMayKnowRecommend != null)
          {
            localObject1 = (FriendsManager)this.k.getManager(QQManagerFactory.FRIENDS_MANAGER);
            if ((localObject1 != null) && (((FriendsManager)localObject1).n(localMayKnowRecommend.uin)))
            {
              i = 1;
            }
            else
            {
              i = this.n;
              if (i == 8) {
                i = 101;
              } else if ((i != 3) && (i != 4))
              {
                if (i == 10)
                {
                  i = 107;
                }
                else
                {
                  i = 83;
                  if (this.o != 21) {}
                }
              }
              else {
                i = 82;
              }
            }
            localObject2 = new AllInOne(localMayKnowRecommend.uin, i);
            localObject1 = localMayKnowRecommend.getRecommendName(this.l.m());
            if (!TextUtils.isEmpty((CharSequence)localObject1)) {
              ((AllInOne)localObject2).recommendName = ((String)localObject1);
            }
            if (!TextUtils.isEmpty(localMayKnowRecommend.nick)) {
              ((AllInOne)localObject2).nickname = localMayKnowRecommend.nick;
            }
            ((AllInOne)localObject2).profileEntryType = 88;
            bool = ((Activity)this.j).getIntent().getBooleanExtra("from_babyq", false);
            Bundle localBundle = new Bundle();
            if (bool) {
              localBundle.putBoolean("from_babyq", true);
            }
            i = i1;
            if (this.o == 21) {
              i = 2;
            }
            if (this.o == 24) {
              localObject1 = "2";
            } else {
              localObject1 = "";
            }
            localBundle.putString("recommend_entry_type", (String)localObject1);
            localBundle.putInt("key_display_type", i);
            localBundle.putString("recommend_reason", localMayKnowRecommend.recommendReason);
            localBundle.putInt("recommend_pos", this.h.indexOf(localMayKnowRecommend));
            localBundle.putByteArray("recommend_algh_id", localMayKnowRecommend.algBuffer);
            ProfileActivity.a(this.j, (AllInOne)localObject2, localBundle);
            this.l.a(localMayKnowRecommend, this.o, this.n, 2);
            if (QLog.isColorLevel())
            {
              localObject1 = new StringBuilder();
              ((StringBuilder)localObject1).append("onClick_ open profile item uin = ");
              ((StringBuilder)localObject1).append(localMayKnowRecommend.uin);
              QLog.d("RecommendFriendAdapter", 2, ((StringBuilder)localObject1).toString());
            }
            i1 = this.n;
            if (i1 != 1)
            {
              if (i1 != 2)
              {
                if (i1 != 3)
                {
                  if (i1 == 4) {
                    ReportController.b(this.k, "CliOper", "", "", "0X800678E", "0X800678E", 0, 0, "", "", "", "");
                  }
                }
                else {
                  ReportController.b(this.k, "CliOper", "", "", "0X800678D", "0X800678D", 0, 0, "", "", "", "");
                }
              }
              else {
                ReportController.b(this.k, "CliOper", "", "", "0X800678C", "0X800678C", 0, 0, "", "", "", "");
              }
            }
            else {
              ReportController.b(this.k, "CliOper", "", "", "0X800678F", "0X800678F", 0, 0, "", "", "", "");
            }
            if (this.o == 24) {
              localObject1 = "2";
            } else {
              localObject1 = "";
            }
            ContactReportUtils.a(this.k, localMayKnowRecommend.uin, "frd_list_clk", this.o, 0, localMayKnowRecommend.recommendReason, this.h.indexOf(localMayKnowRecommend), localMayKnowRecommend.algBuffer, i, (String)localObject1);
          }
        }
      }
      else
      {
        localMayKnowRecommend = (MayKnowRecommend)paramView.getTag();
        if (localMayKnowRecommend != null)
        {
          localObject1 = (FriendsManager)this.k.getManager(QQManagerFactory.FRIENDS_MANAGER);
          if ((!((FriendsManager)localObject1).n(localMayKnowRecommend.uin)) && (!((FriendsManager)localObject1).v(localMayKnowRecommend.uin)))
          {
            bool = ((Activity)this.j).getIntent().getBooleanExtra("from_babyq", false);
            localObject1 = localMayKnowRecommend.getDisplayName(this.l.m());
            i = this.n;
            if ((i != 3) && (i != 4))
            {
              if (i != 8)
              {
                if (i != 10) {
                  i = 3;
                } else {
                  i = 28;
                }
              }
              else {
                i = 24;
              }
            }
            else {
              i = 21;
            }
            if (bool)
            {
              i = 3083;
              i1 = 1;
            }
            else
            {
              int i2 = 3045;
              i1 = i;
              i = i2;
            }
            localObject1 = ((IAddFriendApi)QRoute.api(IAddFriendApi.class)).startAddFriend(this.j, 1, localMayKnowRecommend.uin, null, i, i1, (String)localObject1, null, null, this.j.getString(2131886199), null);
            ((Intent)localObject1).putExtra("key_param_age_area", ProfileCardUtil.a(this.j, localMayKnowRecommend.gender, localMayKnowRecommend.age, localMayKnowRecommend.country, localMayKnowRecommend.province, localMayKnowRecommend.city));
            ((Intent)localObject1).putExtra("from_babyq", bool);
            ((IAddFriendApi)QRoute.api(IAddFriendApi.class)).launchAddFriend((BaseActivity)this.j, (Intent)localObject1);
            i = this.n;
            if (i != 1)
            {
              if (i != 2)
              {
                if (i != 3)
                {
                  if (i == 4) {
                    ReportController.b(this.k, "CliOper", "", "", "0X8006789", "0X8006789", 0, 0, "", "", "", "");
                  }
                }
                else {
                  ReportController.b(this.k, "CliOper", "", "", "0X8006749", "0X8006749", 0, 0, "", "", "", "");
                }
              }
              else {
                ReportController.b(this.k, "CliOper", "", "", "0X8006748", "0X8006748", 0, 0, "", "", "", "");
              }
            }
            else {
              ReportController.b(this.k, "CliOper", "", "", "0X800678B", "0X800678B", 0, 0, "", "", "", "");
            }
          }
          else if (((FriendsManager)localObject1).n(localMayKnowRecommend.uin))
          {
            localMayKnowRecommend.friendStatus = 2;
            notifyDataSetChanged();
          }
          else
          {
            localMayKnowRecommend.friendStatus = 1;
            notifyDataSetChanged();
          }
          this.l.a(localMayKnowRecommend, this.o, this.n, 3);
          if (this.o == 21) {
            i = 2;
          } else {
            i = 0;
          }
          if (this.o == 24) {
            localObject1 = "2";
          } else {
            localObject1 = "";
          }
          ContactReportUtils.a(this.k, localMayKnowRecommend.uin, "frd_list_add", this.o, 1, localMayKnowRecommend.recommendReason, this.h.indexOf(localMayKnowRecommend), localMayKnowRecommend.algBuffer, i, (String)localObject1);
        }
      }
    }
    else if (!NetworkUtil.isNetworkAvailable(this.j))
    {
      localObject1 = this.j;
      QQToast.makeText((Context)localObject1, ((Context)localObject1).getResources().getString(2131889169), 0).show(this.j.getResources().getDimensionPixelSize(2131299920));
    }
    else
    {
      localMayKnowRecommend = (MayKnowRecommend)paramView.getTag();
      if (localMayKnowRecommend != null)
      {
        localObject2 = localMayKnowRecommend.uin;
        if (QLog.isColorLevel())
        {
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append("onClick_ delete item uin = ");
          ((StringBuilder)localObject1).append((String)localObject2);
          QLog.d("RecommendFriendAdapter", 2, ((StringBuilder)localObject1).toString());
        }
        ((FriendListHandler)this.k.getBusinessHandler(BusinessHandlerFactory.FRIENDLIST_HANDLER)).cancelMayKnowRecommend((String)localObject2);
        this.h.remove(localMayKnowRecommend);
        notifyDataSetChanged();
        if (this.o == 21) {
          i = 2;
        } else {
          i = 0;
        }
        if (this.o == 24) {
          localObject1 = "2";
        } else {
          localObject1 = "";
        }
        ContactReportUtils.a(this.k, (String)localObject2, "frd_list_dlt", this.o, 0, localMayKnowRecommend.recommendReason, this.h.indexOf(localMayKnowRecommend), localMayKnowRecommend.algBuffer, i, (String)localObject1);
      }
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
  
  public void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3)
  {
    super.onScroll(paramAbsListView, paramInt1, paramInt2, paramInt3);
    if (QLog.isColorLevel())
    {
      paramAbsListView = new StringBuilder();
      paramAbsListView.append("onScroll firstVisibleItem: ");
      paramAbsListView.append(paramInt1);
      paramAbsListView.append(" visibleItemCount: ");
      paramAbsListView.append(paramInt2);
      paramAbsListView.append(" totalItemCount: ");
      paramAbsListView.append(paramInt3);
      QLog.d("RecommendFriendAdapter", 2, paramAbsListView.toString());
    }
    if (paramInt1 >= 1)
    {
      paramAbsListView = (MayKnowRecommend)getItem(paramInt1 - 1);
      if (paramAbsListView != null) {
        this.l.b(paramAbsListView, this.o, this.n, 1);
      }
    }
    paramInt1 += paramInt2;
    if (paramInt1 < paramInt3)
    {
      paramAbsListView = (MayKnowRecommend)getItem(paramInt1);
      if (paramAbsListView != null) {
        this.l.b(paramAbsListView, this.o, this.n, 1);
      }
    }
  }
  
  public void updateCurShowRightView(View paramView)
  {
    int i1 = -1;
    int i = i1;
    if (paramView != null)
    {
      paramView = paramView.getTag(-1);
      i = i1;
      if ((paramView instanceof Integer)) {
        i = ((Integer)paramView).intValue();
      }
    }
    this.f = i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.adapter.RecommendFriendAdapter
 * JD-Core Version:    0.7.0.1
 */