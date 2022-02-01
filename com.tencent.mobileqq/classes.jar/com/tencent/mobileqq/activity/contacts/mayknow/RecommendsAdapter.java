package com.tencent.mobileqq.activity.contacts.mayknow;

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
import com.tencent.mobileqq.adapter.FacePreloadBaseAdapter;
import com.tencent.mobileqq.addfriend.api.IAddFriendApi;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.MayknowRecommendManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.data.MayKnowRecommend;
import com.tencent.mobileqq.profilecard.data.AllInOne;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.richstatus.RichStatus;
import com.tencent.mobileqq.util.ProfileCardUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.AbsListView.OnScrollListener;
import com.tencent.widget.SingleLineTextView;
import com.tencent.widget.ThemeImageView;
import com.tencent.widget.XListView;
import java.util.ArrayList;
import java.util.List;

public class RecommendsAdapter
  extends FacePreloadBaseAdapter
  implements View.OnClickListener
{
  List<MayKnowRecommend> a = new ArrayList();
  Context b;
  QQAppInterface c;
  Resources d;
  XListView e;
  MayknowRecommendManager f;
  protected Runnable g = new RecommendsAdapter.2(this);
  private AbsListView.OnScrollListener h = new RecommendsAdapter.1(this);
  
  public RecommendsAdapter(Context paramContext, QQAppInterface paramQQAppInterface, XListView paramXListView, int paramInt, boolean paramBoolean)
  {
    super(paramContext, paramQQAppInterface, paramXListView, paramInt, paramBoolean);
    this.b = paramContext;
    this.c = paramQQAppInterface;
    this.d = this.b.getResources();
    this.e = paramXListView;
    this.f = ((MayknowRecommendManager)paramQQAppInterface.getManager(QQManagerFactory.MAYKNOW_RECOMMEND_MANAGER));
    a(this.h);
  }
  
  private void a(RecommendsAdapter.RecFriendViewHolder paramRecFriendViewHolder)
  {
    Object localObject = paramRecFriendViewHolder.e.getRichStatus();
    StringBuilder localStringBuilder = new StringBuilder();
    if (((RichStatus)localObject).actionText != null)
    {
      localStringBuilder.append("actionText:");
      localStringBuilder.append(((RichStatus)localObject).actionText);
    }
    if (((RichStatus)localObject).dataText != null)
    {
      localStringBuilder.append("dataText:");
      localStringBuilder.append(((RichStatus)localObject).dataText);
    }
    localStringBuilder.append("plainText:");
    localObject = ((RichStatus)localObject).getPlainText();
    if (!TextUtils.isEmpty((CharSequence)localObject)) {
      localStringBuilder.append((String)localObject);
    }
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("updateRichStatus, content=");
      ((StringBuilder)localObject).append(localStringBuilder);
      ((StringBuilder)localObject).append("  uin:");
      ((StringBuilder)localObject).append(paramRecFriendViewHolder.e.uin);
      QLog.i("contacts.RecommendsAdapter", 2, ((StringBuilder)localObject).toString());
    }
  }
  
  public void a()
  {
    super.c();
    a(null);
    this.e = null;
    this.f = null;
  }
  
  public void a(QQAppInterface paramQQAppInterface)
  {
    if (paramQQAppInterface != this.c)
    {
      if (QLog.isColorLevel()) {
        QLog.i("contacts.RecommendsAdapter", 2, "checkResetApp, need change app!");
      }
      this.c = paramQQAppInterface;
      b(this.c);
      this.f = ((MayknowRecommendManager)paramQQAppInterface.getManager(QQManagerFactory.MAYKNOW_RECOMMEND_MANAGER));
    }
  }
  
  public void a(List<MayKnowRecommend> paramList)
  {
    this.a.clear();
    if ((paramList != null) && (paramList.size() > 0)) {
      this.a.addAll(paramList);
    }
    notifyDataSetChanged();
  }
  
  public void b()
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("onResume firstVisible: ");
      ((StringBuilder)localObject).append(this.e.getFirstVisiblePosition());
      ((StringBuilder)localObject).append(" lastvisible: ");
      ((StringBuilder)localObject).append(this.e.getLastVisiblePosition());
      QLog.d("contacts.RecommendsAdapter", 2, ((StringBuilder)localObject).toString());
    }
    if ((getCount() > 0) && (this.e.isShown()))
    {
      localObject = (MayknowRecommendManager)this.c.getManager(QQManagerFactory.MAYKNOW_RECOMMEND_MANAGER);
      int i = this.e.getFirstVisiblePosition();
      while (i <= this.e.getLastVisiblePosition())
      {
        if ((i >= 0) && (i < getCount())) {
          ((MayknowRecommendManager)localObject).a((MayKnowRecommend)getItem(i), 20, 0, 1);
        }
        i += 1;
      }
    }
    Object localObject = this.e;
    if (localObject != null)
    {
      ((XListView)localObject).removeCallbacks(this.g);
      this.e.postDelayed(this.g, 1000L);
    }
  }
  
  public void d()
  {
    if (this.e == null) {
      return;
    }
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("stopVisibleExpose firstVisible: ");
      ((StringBuilder)localObject).append(this.e.getFirstVisiblePosition());
      ((StringBuilder)localObject).append(" lastvisible: ");
      ((StringBuilder)localObject).append(this.e.getLastVisiblePosition());
      QLog.d("contacts.RecommendsAdapter", 2, ((StringBuilder)localObject).toString());
    }
    if ((getCount() > 0) && (this.e.isShown()))
    {
      localObject = (MayknowRecommendManager)this.c.getManager(QQManagerFactory.MAYKNOW_RECOMMEND_MANAGER);
      int i = this.e.getFirstVisiblePosition();
      while (i <= this.e.getLastVisiblePosition())
      {
        if ((i >= 0) && (i < getCount())) {
          ((MayknowRecommendManager)localObject).b((MayKnowRecommend)getItem(i), 20, 0, 1);
        }
        i += 1;
      }
    }
    Object localObject = this.e;
    if (localObject != null) {
      ((XListView)localObject).removeCallbacks(this.g);
    }
  }
  
  public void e()
  {
    Object localObject = this.e;
    if ((localObject != null) && (((XListView)localObject).isShown()) && (!this.a.isEmpty()))
    {
      this.e.removeCallbacks(this.g);
      int j = this.e.getFirstVisiblePosition();
      int k = this.e.getLastVisiblePosition();
      localObject = new ArrayList();
      ArrayList localArrayList1 = new ArrayList();
      ArrayList localArrayList2 = new ArrayList();
      ArrayList localArrayList3 = new ArrayList();
      int i = j;
      while (i <= k)
      {
        if ((i >= 0) && (i < this.a.size()) && (this.a.get(i) != null))
        {
          ((ArrayList)localObject).add(((MayKnowRecommend)this.a.get(i)).uin);
          localArrayList1.add(((MayKnowRecommend)this.a.get(i)).recommendReason);
          localArrayList2.add(Integer.valueOf(i));
          localArrayList3.add(((MayKnowRecommend)this.a.get(i)).algBuffer);
        }
        i += 1;
      }
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("reportRecommendFrdExpose firstVisibleItem: ");
        localStringBuilder.append(j);
        localStringBuilder.append(" lastVisibleItem: ");
        localStringBuilder.append(k);
        localStringBuilder.append(" exp_uins: ");
        localStringBuilder.append(localObject);
        localStringBuilder.append(" exp_reasons:");
        localStringBuilder.append(localArrayList1);
        localStringBuilder.append(" exp_positions:");
        localStringBuilder.append(localArrayList2);
        localStringBuilder.append(" algh_ids:");
        localStringBuilder.append(localArrayList3);
        QLog.d("contacts.RecommendsAdapter", 2, localStringBuilder.toString());
      }
      if (!((ArrayList)localObject).isEmpty()) {
        ContactReportUtils.a(this.c, 20, (ArrayList)localObject, localArrayList1, localArrayList2, localArrayList3, 0, null);
      }
    }
  }
  
  public int getCount()
  {
    return this.a.size();
  }
  
  public Object getItem(int paramInt)
  {
    if ((paramInt >= 0) && (paramInt < this.a.size())) {
      return this.a.get(paramInt);
    }
    return new MayKnowRecommend();
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    RecommendsAdapter.RecFriendViewHolder localRecFriendViewHolder;
    if (paramView == null)
    {
      localRecFriendViewHolder = new RecommendsAdapter.RecFriendViewHolder();
      paramView = LayoutInflater.from(this.b).inflate(2131624563, paramViewGroup, false);
      localRecFriendViewHolder.A = ((ImageView)paramView.findViewById(2131427337));
      localRecFriendViewHolder.a = ((SingleLineTextView)paramView.findViewById(2131439320));
      localRecFriendViewHolder.b = ((SingleLineTextView)paramView.findViewById(2131444728));
      localRecFriendViewHolder.c = ((Button)paramView.findViewById(2131444718));
      localRecFriendViewHolder.d = ((TextView)paramView.findViewById(2131444726));
      if ((localRecFriendViewHolder.A instanceof ThemeImageView)) {
        ((ThemeImageView)localRecFriendViewHolder.A).setSupportMaskView(false);
      }
      paramView.setTag(localRecFriendViewHolder);
    }
    else
    {
      localRecFriendViewHolder = (RecommendsAdapter.RecFriendViewHolder)paramView.getTag();
    }
    MayKnowRecommend localMayKnowRecommend = (MayKnowRecommend)getItem(paramInt);
    localRecFriendViewHolder.y = localMayKnowRecommend.uin;
    localRecFriendViewHolder.e = localMayKnowRecommend;
    Object localObject1 = this.f;
    boolean bool;
    if (localObject1 != null) {
      bool = ((MayknowRecommendManager)localObject1).m();
    } else {
      bool = false;
    }
    Object localObject2 = localMayKnowRecommend.getDisplayName(bool);
    localObject1 = new StringBuilder(512);
    if (!TextUtils.isEmpty((CharSequence)localObject2))
    {
      localRecFriendViewHolder.a.setVisibility(0);
      localRecFriendViewHolder.a.setText((CharSequence)localObject2);
      if (AppSetting.e) {
        ((StringBuilder)localObject1).append((String)localObject2);
      }
    }
    else
    {
      localRecFriendViewHolder.a.setVisibility(8);
    }
    localObject2 = new StringBuilder();
    if (!TextUtils.isEmpty(localMayKnowRecommend.category))
    {
      ((StringBuilder)localObject2).append(localMayKnowRecommend.category);
      ((StringBuilder)localObject2).append(" ");
    }
    if (!TextUtils.isEmpty(localMayKnowRecommend.recommendReason)) {
      ((StringBuilder)localObject2).append(localMayKnowRecommend.recommendReason);
    }
    localObject2 = ((StringBuilder)localObject2).toString();
    if (!TextUtils.isEmpty((CharSequence)localObject2))
    {
      localRecFriendViewHolder.b.setVisibility(0);
      localRecFriendViewHolder.b.setText((CharSequence)localObject2);
      if (AppSetting.e)
      {
        ((StringBuilder)localObject1).append(",");
        ((StringBuilder)localObject1).append((String)localObject2);
      }
    }
    else
    {
      localRecFriendViewHolder.b.setVisibility(8);
    }
    if (localMayKnowRecommend.friendStatus == 0)
    {
      localRecFriendViewHolder.c.setOnClickListener(this);
      localRecFriendViewHolder.c.setVisibility(0);
      localRecFriendViewHolder.c.setTag(localMayKnowRecommend);
      localRecFriendViewHolder.c.setText(HardCodeUtil.a(2131886199));
      localRecFriendViewHolder.d.setVisibility(8);
      if (AppSetting.e)
      {
        ((StringBuilder)localObject1).append(",点击添加");
        localRecFriendViewHolder.c.setContentDescription(HardCodeUtil.a(2131886199));
      }
    }
    else if (localMayKnowRecommend.friendStatus == 1)
    {
      localRecFriendViewHolder.c.setVisibility(8);
      localRecFriendViewHolder.d.setVisibility(0);
      localRecFriendViewHolder.d.setText(2131915704);
      if (AppSetting.e)
      {
        ((StringBuilder)localObject1).append(",等待验证");
        localRecFriendViewHolder.d.setContentDescription(this.d.getString(2131915704));
      }
    }
    else
    {
      localRecFriendViewHolder.c.setVisibility(8);
      localRecFriendViewHolder.d.setVisibility(0);
      localRecFriendViewHolder.d.setText(2131886630);
      if (AppSetting.e)
      {
        ((StringBuilder)localObject1).append(",已添加");
        localRecFriendViewHolder.d.setContentDescription(this.d.getString(2131886630));
      }
    }
    if (QLog.isColorLevel()) {
      a(localRecFriendViewHolder);
    }
    localObject2 = this.f;
    if (localObject2 != null) {
      ((MayknowRecommendManager)localObject2).a(localMayKnowRecommend, 20, 0, 1);
    }
    if (AppSetting.e) {
      paramView.setContentDescription(((StringBuilder)localObject1).toString());
    }
    paramView.setOnClickListener(this);
    localRecFriendViewHolder.A.setImageBitmap(a(1, localRecFriendViewHolder.y));
    EventCollector.getInstance().onListGetView(paramInt, paramView, paramViewGroup, getItemId(paramInt));
    return paramView;
  }
  
  public void onClick(View paramView)
  {
    int i = paramView.getId();
    Object localObject1;
    int j;
    Object localObject2;
    boolean bool1;
    if (i != 2131444718)
    {
      if (i == 2131444905)
      {
        localObject1 = (RecommendsAdapter.RecFriendViewHolder)paramView.getTag();
        if (localObject1 != null)
        {
          localObject1 = ((RecommendsAdapter.RecFriendViewHolder)localObject1).e;
          if (localObject1 != null)
          {
            j = 103;
            localObject2 = (FriendsManager)this.c.getManager(QQManagerFactory.FRIENDS_MANAGER);
            i = j;
            if (localObject2 != null)
            {
              i = j;
              if (((FriendsManager)localObject2).n(((MayKnowRecommend)localObject1).uin)) {
                i = 1;
              }
            }
            localObject2 = new AllInOne(((MayKnowRecommend)localObject1).uin, i);
            Object localObject3 = this.f;
            if (localObject3 != null) {
              bool1 = ((MayknowRecommendManager)localObject3).m();
            } else {
              bool1 = false;
            }
            localObject3 = ((MayKnowRecommend)localObject1).getRecommendName(bool1);
            if (!TextUtils.isEmpty((CharSequence)localObject3)) {
              ((AllInOne)localObject2).recommendName = ((String)localObject3);
            }
            if (!TextUtils.isEmpty(((MayKnowRecommend)localObject1).nick)) {
              ((AllInOne)localObject2).nickname = ((MayKnowRecommend)localObject1).nick;
            }
            ((AllInOne)localObject2).profileEntryType = 88;
            bool1 = ((Activity)this.b).getIntent().getBooleanExtra("from_babyq", false);
            localObject3 = new Bundle();
            if (bool1) {
              ((Bundle)localObject3).putBoolean("from_babyq", true);
            }
            ((Bundle)localObject3).putString("recommend_reason", ((MayKnowRecommend)localObject1).recommendReason);
            ((Bundle)localObject3).putInt("recommend_pos", this.a.indexOf(localObject1));
            ((Bundle)localObject3).putByteArray("recommend_algh_id", ((MayKnowRecommend)localObject1).algBuffer);
            ProfileActivity.a(this.b, (AllInOne)localObject2, (Bundle)localObject3);
            localObject2 = this.f;
            if (localObject2 != null) {
              ((MayknowRecommendManager)localObject2).a((MayKnowRecommend)localObject1, 20, 0, 2);
            }
            ContactReportUtils.a(this.c, ((MayKnowRecommend)localObject1).uin, "frd_list_clk", 20, 0, ((MayKnowRecommend)localObject1).recommendReason, this.a.indexOf(localObject1), ((MayKnowRecommend)localObject1).algBuffer, 0);
          }
        }
      }
    }
    else
    {
      localObject1 = (MayKnowRecommend)paramView.getTag();
      if (localObject1 != null)
      {
        localObject2 = (FriendsManager)this.c.getManager(QQManagerFactory.FRIENDS_MANAGER);
        if ((!((FriendsManager)localObject2).n(((MayKnowRecommend)localObject1).uin)) && (!((FriendsManager)localObject2).v(((MayKnowRecommend)localObject1).uin)))
        {
          boolean bool2 = ((Activity)this.b).getIntent().getBooleanExtra("from_babyq", false);
          localObject2 = this.f;
          if (localObject2 != null) {
            bool1 = ((MayknowRecommendManager)localObject2).m();
          } else {
            bool1 = false;
          }
          localObject2 = ((MayKnowRecommend)localObject1).getDisplayName(bool1);
          if (bool2)
          {
            i = 3083;
            j = 1;
          }
          else
          {
            i = 3045;
            j = 20;
          }
          localObject2 = ((IAddFriendApi)QRoute.api(IAddFriendApi.class)).startAddFriend(this.b, 1, ((MayKnowRecommend)localObject1).uin, null, i, j, (String)localObject2, null, null, this.b.getString(2131886199), null);
          ((Intent)localObject2).putExtra("key_param_age_area", ProfileCardUtil.a(this.b, ((MayKnowRecommend)localObject1).gender, ((MayKnowRecommend)localObject1).age, ((MayKnowRecommend)localObject1).country, ((MayKnowRecommend)localObject1).province, ((MayKnowRecommend)localObject1).city));
          ((Intent)localObject2).putExtra("from_babyq", bool2);
          ((IAddFriendApi)QRoute.api(IAddFriendApi.class)).launchAddFriend((Activity)this.b, (Intent)localObject2);
        }
        else if (((FriendsManager)localObject2).n(((MayKnowRecommend)localObject1).uin))
        {
          ((MayKnowRecommend)localObject1).friendStatus = 2;
          notifyDataSetChanged();
        }
        else
        {
          ((MayKnowRecommend)localObject1).friendStatus = 1;
          notifyDataSetChanged();
        }
        localObject2 = this.f;
        if (localObject2 != null) {
          ((MayknowRecommendManager)localObject2).a((MayKnowRecommend)localObject1, 20, 0, 3);
        }
        ContactReportUtils.a(this.c, ((MayKnowRecommend)localObject1).uin, "frd_list_add", 20, 1, ((MayKnowRecommend)localObject1).recommendReason, this.a.indexOf(localObject1), ((MayKnowRecommend)localObject1).algBuffer, 0);
      }
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.contacts.mayknow.RecommendsAdapter
 * JD-Core Version:    0.7.0.1
 */