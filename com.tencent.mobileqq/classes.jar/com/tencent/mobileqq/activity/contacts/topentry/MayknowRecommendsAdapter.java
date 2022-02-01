package com.tencent.mobileqq.activity.contacts.topentry;

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

public class MayknowRecommendsAdapter
  extends FacePreloadBaseAdapter
  implements View.OnClickListener
{
  List<MayKnowRecommend> a = new ArrayList();
  Context b;
  QQAppInterface c;
  Resources d;
  XListView e;
  MayknowRecommendManager f;
  long g = 0L;
  protected Runnable h = new MayknowRecommendsAdapter.2(this);
  private AbsListView.OnScrollListener j = new MayknowRecommendsAdapter.1(this);
  
  public MayknowRecommendsAdapter(Context paramContext, QQAppInterface paramQQAppInterface, XListView paramXListView, int paramInt, boolean paramBoolean)
  {
    super(paramContext, paramQQAppInterface, paramXListView, paramInt, paramBoolean);
    this.b = paramContext;
    this.c = paramQQAppInterface;
    this.d = this.b.getResources();
    this.e = paramXListView;
    this.f = ((MayknowRecommendManager)paramQQAppInterface.getManager(QQManagerFactory.MAYKNOW_RECOMMEND_MANAGER));
    a(this.j);
  }
  
  private void a(MayknowRecommendsAdapter.RecFriendViewHolder paramRecFriendViewHolder)
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
  
  private void a(MayKnowRecommend paramMayKnowRecommend)
  {
    if (paramMayKnowRecommend != null)
    {
      Object localObject = this.c;
      if ((localObject != null) && (this.b != null))
      {
        localObject = (FriendsManager)((QQAppInterface)localObject).getManager(QQManagerFactory.FRIENDS_MANAGER);
        if ((!((FriendsManager)localObject).n(paramMayKnowRecommend.uin)) && (!((FriendsManager)localObject).v(paramMayKnowRecommend.uin)))
        {
          boolean bool2 = ((Activity)this.b).getIntent().getBooleanExtra("from_babyq", false);
          localObject = this.f;
          boolean bool1;
          if (localObject != null) {
            bool1 = ((MayknowRecommendManager)localObject).m();
          } else {
            bool1 = false;
          }
          localObject = paramMayKnowRecommend.getDisplayName(bool1);
          int i;
          int k;
          if (bool2)
          {
            i = 3083;
            k = 1;
          }
          else
          {
            i = 3045;
            k = 24;
          }
          localObject = ((IAddFriendApi)QRoute.api(IAddFriendApi.class)).startAddFriend(this.b, 1, paramMayKnowRecommend.uin, null, i, k, (String)localObject, null, null, this.b.getString(2131886199), null);
          ((Intent)localObject).putExtra("key_param_age_area", ProfileCardUtil.a(this.b, paramMayKnowRecommend.gender, paramMayKnowRecommend.age, paramMayKnowRecommend.country, paramMayKnowRecommend.province, paramMayKnowRecommend.city));
          ((Intent)localObject).putExtra("from_babyq", bool2);
          ((IAddFriendApi)QRoute.api(IAddFriendApi.class)).launchAddFriend((Activity)this.b, (Intent)localObject);
        }
        else if (((FriendsManager)localObject).n(paramMayKnowRecommend.uin))
        {
          paramMayKnowRecommend.friendStatus = 2;
          notifyDataSetChanged();
        }
        else
        {
          paramMayKnowRecommend.friendStatus = 1;
          notifyDataSetChanged();
        }
        localObject = this.f;
        if (localObject != null) {
          ((MayknowRecommendManager)localObject).a(paramMayKnowRecommend, 24, 0, 3);
        }
        ContactReportUtils.a(this.c, paramMayKnowRecommend.uin, "frd_list_add", 24, 1, paramMayKnowRecommend.recommendReason, this.a.indexOf(paramMayKnowRecommend), paramMayKnowRecommend.algBuffer, 0, "1");
      }
    }
  }
  
  public void a()
  {
    super.c();
    a(null);
    List localList = this.a;
    if (localList != null) {
      localList.clear();
    }
    this.e = null;
    this.f = null;
    this.b = null;
    this.d = null;
    this.c = null;
  }
  
  public void a(QQAppInterface paramQQAppInterface)
  {
    if (this.c != paramQQAppInterface) {
      this.c = paramQQAppInterface;
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
  
  public void a(boolean paramBoolean)
  {
    notifyDataSetChanged();
  }
  
  public void b()
  {
    e();
  }
  
  public void d()
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
      localObject = this.c;
      if (localObject != null)
      {
        localObject = (MayknowRecommendManager)((QQAppInterface)localObject).getManager(QQManagerFactory.MAYKNOW_RECOMMEND_MANAGER);
        int i = this.e.getFirstVisiblePosition();
        while (i <= this.e.getLastVisiblePosition())
        {
          if ((i >= 0) && (i < getCount())) {
            ((MayknowRecommendManager)localObject).a((MayKnowRecommend)getItem(i), 24, 0, 1);
          }
          i += 1;
        }
      }
    }
    Object localObject = this.e;
    if (localObject != null)
    {
      ((XListView)localObject).removeCallbacks(this.h);
      this.e.postDelayed(this.h, 1000L);
    }
  }
  
  public void e()
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
      localObject = this.c;
      if (localObject != null)
      {
        localObject = (MayknowRecommendManager)((QQAppInterface)localObject).getManager(QQManagerFactory.MAYKNOW_RECOMMEND_MANAGER);
        int i = this.e.getFirstVisiblePosition();
        while (i <= this.e.getLastVisiblePosition())
        {
          if ((i >= 0) && (i < getCount())) {
            ((MayknowRecommendManager)localObject).b((MayKnowRecommend)getItem(i), 24, 0, 1);
          }
          i += 1;
        }
      }
    }
    Object localObject = this.e;
    if (localObject != null) {
      ((XListView)localObject).removeCallbacks(this.h);
    }
  }
  
  public void f()
  {
    Object localObject1 = this.e;
    if ((localObject1 != null) && (((XListView)localObject1).isShown()) && (!this.a.isEmpty()))
    {
      this.e.removeCallbacks(this.h);
      int k = this.e.getFirstVisiblePosition();
      int m = this.e.getLastVisiblePosition();
      localObject1 = new ArrayList();
      ArrayList localArrayList1 = new ArrayList();
      ArrayList localArrayList2 = new ArrayList();
      ArrayList localArrayList3 = new ArrayList();
      int i = k;
      while (i <= m)
      {
        if ((i >= 0) && (i < this.a.size()) && (this.a.get(i) != null))
        {
          ((ArrayList)localObject1).add(((MayKnowRecommend)this.a.get(i)).uin);
          localArrayList1.add(((MayKnowRecommend)this.a.get(i)).recommendReason);
          localArrayList2.add(Integer.valueOf(i));
          localArrayList3.add(((MayKnowRecommend)this.a.get(i)).algBuffer);
        }
        i += 1;
      }
      Object localObject2;
      if (QLog.isColorLevel())
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("reportRecommendFrdExpose firstVisibleItem: ");
        ((StringBuilder)localObject2).append(k);
        ((StringBuilder)localObject2).append(" lastVisibleItem: ");
        ((StringBuilder)localObject2).append(m);
        ((StringBuilder)localObject2).append(" exp_uins: ");
        ((StringBuilder)localObject2).append(localObject1);
        ((StringBuilder)localObject2).append(" exp_reasons:");
        ((StringBuilder)localObject2).append(localArrayList1);
        ((StringBuilder)localObject2).append(" exp_positions:");
        ((StringBuilder)localObject2).append(localArrayList2);
        ((StringBuilder)localObject2).append(" algh_ids:");
        ((StringBuilder)localObject2).append(localArrayList3);
        QLog.d("contacts.RecommendsAdapter", 2, ((StringBuilder)localObject2).toString());
      }
      if (!((ArrayList)localObject1).isEmpty())
      {
        localObject2 = this.c;
        if (localObject2 != null) {
          ContactReportUtils.b((QQAppInterface)localObject2, 24, (ArrayList)localObject1, localArrayList1, localArrayList2, localArrayList3, 0, "1");
        }
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
    Object localObject1 = paramView;
    if (this.d != null)
    {
      localObject1 = paramView;
      if (this.b != null) {
        if (this.c == null)
        {
          localObject1 = paramView;
        }
        else
        {
          if (paramView == null)
          {
            localObject2 = new MayknowRecommendsAdapter.RecFriendViewHolder();
            localObject3 = LayoutInflater.from(this.b).inflate(2131624565, paramViewGroup, false);
            ((MayknowRecommendsAdapter.RecFriendViewHolder)localObject2).A = ((ImageView)((View)localObject3).findViewById(2131427337));
            ((MayknowRecommendsAdapter.RecFriendViewHolder)localObject2).a = ((SingleLineTextView)((View)localObject3).findViewById(2131439320));
            ((MayknowRecommendsAdapter.RecFriendViewHolder)localObject2).b = ((SingleLineTextView)((View)localObject3).findViewById(2131444728));
            ((MayknowRecommendsAdapter.RecFriendViewHolder)localObject2).c = ((Button)((View)localObject3).findViewById(2131444718));
            ((MayknowRecommendsAdapter.RecFriendViewHolder)localObject2).d = ((TextView)((View)localObject3).findViewById(2131444726));
            ((MayknowRecommendsAdapter.RecFriendViewHolder)localObject2).f = ((ImageView)((View)localObject3).findViewById(2131431708));
            ((View)localObject3).setTag(localObject2);
            paramView = (View)localObject3;
            localObject1 = localObject2;
            if ((((MayknowRecommendsAdapter.RecFriendViewHolder)localObject2).A instanceof ThemeImageView))
            {
              ((ThemeImageView)((MayknowRecommendsAdapter.RecFriendViewHolder)localObject2).A).setSupportMaskView(false);
              paramView = (View)localObject3;
              localObject1 = localObject2;
            }
          }
          else
          {
            localObject1 = (MayknowRecommendsAdapter.RecFriendViewHolder)paramView.getTag();
          }
          Object localObject2 = (MayKnowRecommend)getItem(paramInt);
          ((MayknowRecommendsAdapter.RecFriendViewHolder)localObject1).y = ((MayKnowRecommend)localObject2).uin;
          ((MayknowRecommendsAdapter.RecFriendViewHolder)localObject1).e = ((MayKnowRecommend)localObject2);
          Object localObject3 = this.f;
          boolean bool;
          if (localObject3 != null) {
            bool = ((MayknowRecommendManager)localObject3).m();
          } else {
            bool = false;
          }
          Object localObject4 = ((MayKnowRecommend)localObject2).getDisplayName(bool);
          localObject3 = new StringBuilder(512);
          if (!TextUtils.isEmpty((CharSequence)localObject4))
          {
            ((MayknowRecommendsAdapter.RecFriendViewHolder)localObject1).a.setVisibility(0);
            ((MayknowRecommendsAdapter.RecFriendViewHolder)localObject1).a.setText((CharSequence)localObject4);
            if (AppSetting.e) {
              ((StringBuilder)localObject3).append((String)localObject4);
            }
          }
          else
          {
            ((MayknowRecommendsAdapter.RecFriendViewHolder)localObject1).a.setVisibility(8);
          }
          localObject4 = new StringBuilder();
          if (!TextUtils.isEmpty(((MayKnowRecommend)localObject2).category))
          {
            ((StringBuilder)localObject4).append(((MayKnowRecommend)localObject2).category);
            ((StringBuilder)localObject4).append(" ");
          }
          if (!TextUtils.isEmpty(((MayKnowRecommend)localObject2).recommendReason)) {
            ((StringBuilder)localObject4).append(((MayKnowRecommend)localObject2).recommendReason);
          }
          localObject4 = ((StringBuilder)localObject4).toString();
          if (!TextUtils.isEmpty((CharSequence)localObject4))
          {
            ((MayknowRecommendsAdapter.RecFriendViewHolder)localObject1).b.setVisibility(0);
            ((MayknowRecommendsAdapter.RecFriendViewHolder)localObject1).b.setText((CharSequence)localObject4);
            if (AppSetting.e)
            {
              ((StringBuilder)localObject3).append(",");
              ((StringBuilder)localObject3).append((String)localObject4);
            }
          }
          else
          {
            ((MayknowRecommendsAdapter.RecFriendViewHolder)localObject1).b.setVisibility(8);
          }
          if (((MayKnowRecommend)localObject2).friendStatus == 0)
          {
            ((MayknowRecommendsAdapter.RecFriendViewHolder)localObject1).c.setOnClickListener(this);
            ((MayknowRecommendsAdapter.RecFriendViewHolder)localObject1).c.setVisibility(0);
            ((MayknowRecommendsAdapter.RecFriendViewHolder)localObject1).c.setTag(localObject2);
            ((MayknowRecommendsAdapter.RecFriendViewHolder)localObject1).c.setText(HardCodeUtil.a(2131886199));
            ((MayknowRecommendsAdapter.RecFriendViewHolder)localObject1).d.setVisibility(8);
            if (AppSetting.e)
            {
              ((StringBuilder)localObject3).append(",点击添加");
              ((MayknowRecommendsAdapter.RecFriendViewHolder)localObject1).c.setContentDescription(HardCodeUtil.a(2131886199));
            }
          }
          else if (((MayKnowRecommend)localObject2).friendStatus == 1)
          {
            ((MayknowRecommendsAdapter.RecFriendViewHolder)localObject1).c.setVisibility(8);
            ((MayknowRecommendsAdapter.RecFriendViewHolder)localObject1).d.setVisibility(0);
            ((MayknowRecommendsAdapter.RecFriendViewHolder)localObject1).d.setText(2131915704);
            if (AppSetting.e)
            {
              ((StringBuilder)localObject3).append(",等待验证");
              ((MayknowRecommendsAdapter.RecFriendViewHolder)localObject1).d.setContentDescription(this.d.getString(2131915704));
            }
          }
          else
          {
            ((MayknowRecommendsAdapter.RecFriendViewHolder)localObject1).c.setVisibility(8);
            ((MayknowRecommendsAdapter.RecFriendViewHolder)localObject1).d.setVisibility(0);
            ((MayknowRecommendsAdapter.RecFriendViewHolder)localObject1).d.setText(2131886630);
            if (AppSetting.e)
            {
              ((StringBuilder)localObject3).append(",已添加");
              ((MayknowRecommendsAdapter.RecFriendViewHolder)localObject1).d.setContentDescription(this.d.getString(2131886630));
            }
          }
          if (QLog.isColorLevel()) {
            a((MayknowRecommendsAdapter.RecFriendViewHolder)localObject1);
          }
          localObject4 = this.f;
          if (localObject4 != null) {
            ((MayknowRecommendManager)localObject4).a((MayKnowRecommend)localObject2, 24, 0, 1);
          }
          if (AppSetting.e) {
            paramView.setContentDescription(((StringBuilder)localObject3).toString());
          }
          ((MayknowRecommendsAdapter.RecFriendViewHolder)localObject1).f.setOnClickListener(this);
          ((MayknowRecommendsAdapter.RecFriendViewHolder)localObject1).f.setTag(localObject2);
          paramView.setOnClickListener(this);
          if (AppSetting.e) {
            ((MayknowRecommendsAdapter.RecFriendViewHolder)localObject1).f.setContentDescription(HardCodeUtil.a(2131904393));
          }
          ((MayknowRecommendsAdapter.RecFriendViewHolder)localObject1).A.setImageBitmap(a(1, ((MayknowRecommendsAdapter.RecFriendViewHolder)localObject1).y));
          localObject1 = paramView;
        }
      }
    }
    EventCollector.getInstance().onListGetView(paramInt, (View)localObject1, paramViewGroup, getItemId(paramInt));
    return localObject1;
  }
  
  public void onClick(View paramView)
  {
    int i = paramView.getId();
    Object localObject1;
    Object localObject2;
    if (i != 2131431708)
    {
      if (i != 2131444718)
      {
        if (i == 2131444905)
        {
          localObject1 = (MayknowRecommendsAdapter.RecFriendViewHolder)paramView.getTag();
          if (localObject1 != null)
          {
            localObject1 = ((MayknowRecommendsAdapter.RecFriendViewHolder)localObject1).e;
            if (localObject1 != null)
            {
              localObject2 = this.c;
              if ((localObject2 != null) && (this.b != null))
              {
                int k = 101;
                localObject2 = (FriendsManager)((QQAppInterface)localObject2).getManager(QQManagerFactory.FRIENDS_MANAGER);
                i = k;
                if (localObject2 != null)
                {
                  i = k;
                  if (((FriendsManager)localObject2).n(((MayKnowRecommend)localObject1).uin)) {
                    i = 1;
                  }
                }
                localObject2 = new AllInOne(((MayKnowRecommend)localObject1).uin, i);
                Object localObject3 = this.f;
                if (localObject3 != null) {
                  bool = ((MayknowRecommendManager)localObject3).m();
                } else {
                  bool = false;
                }
                localObject3 = ((MayKnowRecommend)localObject1).getRecommendName(bool);
                if (!TextUtils.isEmpty((CharSequence)localObject3)) {
                  ((AllInOne)localObject2).recommendName = ((String)localObject3);
                }
                if (!TextUtils.isEmpty(((MayKnowRecommend)localObject1).nick)) {
                  ((AllInOne)localObject2).nickname = ((MayKnowRecommend)localObject1).nick;
                }
                ((AllInOne)localObject2).profileEntryType = 88;
                boolean bool = ((Activity)this.b).getIntent().getBooleanExtra("from_babyq", false);
                localObject3 = new Bundle();
                if (bool) {
                  ((Bundle)localObject3).putBoolean("from_babyq", true);
                }
                ((Bundle)localObject3).putString("recommend_entry_type", "1");
                ((Bundle)localObject3).putString("recommend_reason", ((MayKnowRecommend)localObject1).recommendReason);
                ((Bundle)localObject3).putInt("recommend_pos", this.a.indexOf(localObject1));
                ((Bundle)localObject3).putByteArray("recommend_algh_id", ((MayKnowRecommend)localObject1).algBuffer);
                ProfileActivity.a(this.b, (AllInOne)localObject2, (Bundle)localObject3);
                localObject2 = this.f;
                if (localObject2 != null) {
                  ((MayknowRecommendManager)localObject2).a((MayKnowRecommend)localObject1, 24, 0, 2);
                }
                ContactReportUtils.a(this.c, ((MayKnowRecommend)localObject1).uin, "frd_list_clk", 24, 0, ((MayKnowRecommend)localObject1).recommendReason, this.a.indexOf(localObject1), ((MayKnowRecommend)localObject1).algBuffer, 0, "1");
              }
            }
          }
        }
      }
      else {
        a((MayKnowRecommend)paramView.getTag());
      }
    }
    else
    {
      localObject2 = (MayKnowRecommend)paramView.getTag();
      if ((localObject2 != null) && (this.c != null) && (System.currentTimeMillis() - this.g > 500L))
      {
        this.g = System.currentTimeMillis();
        localObject1 = (CTEntryMng)this.c.getManager(QQManagerFactory.CTENTRY_MNG);
        if (localObject1 == null) {
          localObject1 = null;
        } else {
          localObject1 = ((CTEntryMng)localObject1).a();
        }
        if (localObject1 != null) {
          ((CardViewController)localObject1).a(((MayKnowRecommend)localObject2).uin);
        }
        if (this.a != null) {
          ContactReportUtils.a(this.c, ((MayKnowRecommend)localObject2).uin, "frd_list_dlt", 24, 0, ((MayKnowRecommend)localObject2).recommendReason, this.a.indexOf(localObject2), ((MayKnowRecommend)localObject2).algBuffer, 0, "1");
        }
      }
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.contacts.topentry.MayknowRecommendsAdapter
 * JD-Core Version:    0.7.0.1
 */