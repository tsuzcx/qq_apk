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
  Context jdField_a_of_type_AndroidContentContext;
  Resources jdField_a_of_type_AndroidContentResResources;
  MayknowRecommendManager jdField_a_of_type_ComTencentMobileqqAppMayknowRecommendManager;
  QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private AbsListView.OnScrollListener jdField_a_of_type_ComTencentWidgetAbsListView$OnScrollListener = new RecommendsAdapter.1(this);
  XListView jdField_a_of_type_ComTencentWidgetXListView;
  protected Runnable a;
  List<MayKnowRecommend> jdField_a_of_type_JavaUtilList = new ArrayList();
  
  public RecommendsAdapter(Context paramContext, QQAppInterface paramQQAppInterface, XListView paramXListView, int paramInt, boolean paramBoolean)
  {
    super(paramContext, paramQQAppInterface, paramXListView, paramInt, paramBoolean);
    this.jdField_a_of_type_JavaLangRunnable = new RecommendsAdapter.2(this);
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_AndroidContentResResources = this.jdField_a_of_type_AndroidContentContext.getResources();
    this.jdField_a_of_type_ComTencentWidgetXListView = paramXListView;
    this.jdField_a_of_type_ComTencentMobileqqAppMayknowRecommendManager = ((MayknowRecommendManager)paramQQAppInterface.getManager(QQManagerFactory.MAYKNOW_RECOMMEND_MANAGER));
    a(this.jdField_a_of_type_ComTencentWidgetAbsListView$OnScrollListener);
  }
  
  private void a(RecommendsAdapter.RecFriendViewHolder paramRecFriendViewHolder)
  {
    Object localObject = paramRecFriendViewHolder.jdField_a_of_type_ComTencentMobileqqDataMayKnowRecommend.getRichStatus();
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
      ((StringBuilder)localObject).append(paramRecFriendViewHolder.jdField_a_of_type_ComTencentMobileqqDataMayKnowRecommend.uin);
      QLog.i("contacts.RecommendsAdapter", 2, ((StringBuilder)localObject).toString());
    }
  }
  
  public void a()
  {
    super.c();
    a(null);
    this.jdField_a_of_type_ComTencentWidgetXListView = null;
    this.jdField_a_of_type_ComTencentMobileqqAppMayknowRecommendManager = null;
  }
  
  public void a(QQAppInterface paramQQAppInterface)
  {
    if (paramQQAppInterface != this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface)
    {
      if (QLog.isColorLevel()) {
        QLog.i("contacts.RecommendsAdapter", 2, "checkResetApp, need change app!");
      }
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
      b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      this.jdField_a_of_type_ComTencentMobileqqAppMayknowRecommendManager = ((MayknowRecommendManager)paramQQAppInterface.getManager(QQManagerFactory.MAYKNOW_RECOMMEND_MANAGER));
    }
  }
  
  public void a(List<MayKnowRecommend> paramList)
  {
    this.jdField_a_of_type_JavaUtilList.clear();
    if ((paramList != null) && (paramList.size() > 0)) {
      this.jdField_a_of_type_JavaUtilList.addAll(paramList);
    }
    notifyDataSetChanged();
  }
  
  public void b()
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("onResume firstVisible: ");
      ((StringBuilder)localObject).append(this.jdField_a_of_type_ComTencentWidgetXListView.getFirstVisiblePosition());
      ((StringBuilder)localObject).append(" lastvisible: ");
      ((StringBuilder)localObject).append(this.jdField_a_of_type_ComTencentWidgetXListView.getLastVisiblePosition());
      QLog.d("contacts.RecommendsAdapter", 2, ((StringBuilder)localObject).toString());
    }
    if ((getCount() > 0) && (this.jdField_a_of_type_ComTencentWidgetXListView.isShown()))
    {
      localObject = (MayknowRecommendManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.MAYKNOW_RECOMMEND_MANAGER);
      int i = this.jdField_a_of_type_ComTencentWidgetXListView.getFirstVisiblePosition();
      while (i <= this.jdField_a_of_type_ComTencentWidgetXListView.getLastVisiblePosition())
      {
        if ((i >= 0) && (i < getCount())) {
          ((MayknowRecommendManager)localObject).a((MayKnowRecommend)getItem(i), 20, 0, 1);
        }
        i += 1;
      }
    }
    Object localObject = this.jdField_a_of_type_ComTencentWidgetXListView;
    if (localObject != null)
    {
      ((XListView)localObject).removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
      this.jdField_a_of_type_ComTencentWidgetXListView.postDelayed(this.jdField_a_of_type_JavaLangRunnable, 1000L);
    }
  }
  
  public void d()
  {
    if (this.jdField_a_of_type_ComTencentWidgetXListView == null) {
      return;
    }
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("stopVisibleExpose firstVisible: ");
      ((StringBuilder)localObject).append(this.jdField_a_of_type_ComTencentWidgetXListView.getFirstVisiblePosition());
      ((StringBuilder)localObject).append(" lastvisible: ");
      ((StringBuilder)localObject).append(this.jdField_a_of_type_ComTencentWidgetXListView.getLastVisiblePosition());
      QLog.d("contacts.RecommendsAdapter", 2, ((StringBuilder)localObject).toString());
    }
    if ((getCount() > 0) && (this.jdField_a_of_type_ComTencentWidgetXListView.isShown()))
    {
      localObject = (MayknowRecommendManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.MAYKNOW_RECOMMEND_MANAGER);
      int i = this.jdField_a_of_type_ComTencentWidgetXListView.getFirstVisiblePosition();
      while (i <= this.jdField_a_of_type_ComTencentWidgetXListView.getLastVisiblePosition())
      {
        if ((i >= 0) && (i < getCount())) {
          ((MayknowRecommendManager)localObject).b((MayKnowRecommend)getItem(i), 20, 0, 1);
        }
        i += 1;
      }
    }
    Object localObject = this.jdField_a_of_type_ComTencentWidgetXListView;
    if (localObject != null) {
      ((XListView)localObject).removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
    }
  }
  
  public void e()
  {
    Object localObject = this.jdField_a_of_type_ComTencentWidgetXListView;
    if ((localObject != null) && (((XListView)localObject).isShown()) && (!this.jdField_a_of_type_JavaUtilList.isEmpty()))
    {
      this.jdField_a_of_type_ComTencentWidgetXListView.removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
      int j = this.jdField_a_of_type_ComTencentWidgetXListView.getFirstVisiblePosition();
      int k = this.jdField_a_of_type_ComTencentWidgetXListView.getLastVisiblePosition();
      localObject = new ArrayList();
      ArrayList localArrayList1 = new ArrayList();
      ArrayList localArrayList2 = new ArrayList();
      ArrayList localArrayList3 = new ArrayList();
      int i = j;
      while (i <= k)
      {
        if ((i >= 0) && (i < this.jdField_a_of_type_JavaUtilList.size()) && (this.jdField_a_of_type_JavaUtilList.get(i) != null))
        {
          ((ArrayList)localObject).add(((MayKnowRecommend)this.jdField_a_of_type_JavaUtilList.get(i)).uin);
          localArrayList1.add(((MayKnowRecommend)this.jdField_a_of_type_JavaUtilList.get(i)).recommendReason);
          localArrayList2.add(Integer.valueOf(i));
          localArrayList3.add(((MayKnowRecommend)this.jdField_a_of_type_JavaUtilList.get(i)).algBuffer);
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
        ContactReportUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 20, (ArrayList)localObject, localArrayList1, localArrayList2, localArrayList3, 0, null);
      }
    }
  }
  
  public int getCount()
  {
    return this.jdField_a_of_type_JavaUtilList.size();
  }
  
  public Object getItem(int paramInt)
  {
    if ((paramInt >= 0) && (paramInt < this.jdField_a_of_type_JavaUtilList.size())) {
      return this.jdField_a_of_type_JavaUtilList.get(paramInt);
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
      paramView = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131558933, paramViewGroup, false);
      localRecFriendViewHolder.c = ((ImageView)paramView.findViewById(2131361799));
      localRecFriendViewHolder.jdField_a_of_type_ComTencentWidgetSingleLineTextView = ((SingleLineTextView)paramView.findViewById(2131371877));
      localRecFriendViewHolder.b = ((SingleLineTextView)paramView.findViewById(2131376487));
      localRecFriendViewHolder.jdField_a_of_type_AndroidWidgetButton = ((Button)paramView.findViewById(2131376477));
      localRecFriendViewHolder.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131376485));
      if ((localRecFriendViewHolder.c instanceof ThemeImageView)) {
        ((ThemeImageView)localRecFriendViewHolder.c).setSupportMaskView(false);
      }
      paramView.setTag(localRecFriendViewHolder);
    }
    else
    {
      localRecFriendViewHolder = (RecommendsAdapter.RecFriendViewHolder)paramView.getTag();
    }
    MayKnowRecommend localMayKnowRecommend = (MayKnowRecommend)getItem(paramInt);
    localRecFriendViewHolder.jdField_a_of_type_JavaLangString = localMayKnowRecommend.uin;
    localRecFriendViewHolder.jdField_a_of_type_ComTencentMobileqqDataMayKnowRecommend = localMayKnowRecommend;
    Object localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppMayknowRecommendManager;
    boolean bool;
    if (localObject1 != null) {
      bool = ((MayknowRecommendManager)localObject1).a();
    } else {
      bool = false;
    }
    Object localObject2 = localMayKnowRecommend.getDisplayName(bool);
    localObject1 = new StringBuilder(512);
    if (!TextUtils.isEmpty((CharSequence)localObject2))
    {
      localRecFriendViewHolder.jdField_a_of_type_ComTencentWidgetSingleLineTextView.setVisibility(0);
      localRecFriendViewHolder.jdField_a_of_type_ComTencentWidgetSingleLineTextView.setText((CharSequence)localObject2);
      if (AppSetting.d) {
        ((StringBuilder)localObject1).append((String)localObject2);
      }
    }
    else
    {
      localRecFriendViewHolder.jdField_a_of_type_ComTencentWidgetSingleLineTextView.setVisibility(8);
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
      if (AppSetting.d)
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
      localRecFriendViewHolder.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this);
      localRecFriendViewHolder.jdField_a_of_type_AndroidWidgetButton.setVisibility(0);
      localRecFriendViewHolder.jdField_a_of_type_AndroidWidgetButton.setTag(localMayKnowRecommend);
      localRecFriendViewHolder.jdField_a_of_type_AndroidWidgetButton.setText(HardCodeUtil.a(2131689589));
      localRecFriendViewHolder.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
      if (AppSetting.d)
      {
        ((StringBuilder)localObject1).append(",点击添加");
        localRecFriendViewHolder.jdField_a_of_type_AndroidWidgetButton.setContentDescription(HardCodeUtil.a(2131689589));
      }
    }
    else if (localMayKnowRecommend.friendStatus == 1)
    {
      localRecFriendViewHolder.jdField_a_of_type_AndroidWidgetButton.setVisibility(8);
      localRecFriendViewHolder.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
      localRecFriendViewHolder.jdField_a_of_type_AndroidWidgetTextView.setText(2131718222);
      if (AppSetting.d)
      {
        ((StringBuilder)localObject1).append(",等待验证");
        localRecFriendViewHolder.jdField_a_of_type_AndroidWidgetTextView.setContentDescription(this.jdField_a_of_type_AndroidContentResResources.getString(2131718222));
      }
    }
    else
    {
      localRecFriendViewHolder.jdField_a_of_type_AndroidWidgetButton.setVisibility(8);
      localRecFriendViewHolder.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
      localRecFriendViewHolder.jdField_a_of_type_AndroidWidgetTextView.setText(2131689988);
      if (AppSetting.d)
      {
        ((StringBuilder)localObject1).append(",已添加");
        localRecFriendViewHolder.jdField_a_of_type_AndroidWidgetTextView.setContentDescription(this.jdField_a_of_type_AndroidContentResResources.getString(2131689988));
      }
    }
    if (QLog.isColorLevel()) {
      a(localRecFriendViewHolder);
    }
    localObject2 = this.jdField_a_of_type_ComTencentMobileqqAppMayknowRecommendManager;
    if (localObject2 != null) {
      ((MayknowRecommendManager)localObject2).a(localMayKnowRecommend, 20, 0, 1);
    }
    if (AppSetting.d) {
      paramView.setContentDescription(((StringBuilder)localObject1).toString());
    }
    paramView.setOnClickListener(this);
    localRecFriendViewHolder.c.setImageBitmap(a(1, localRecFriendViewHolder.jdField_a_of_type_JavaLangString));
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
    if (i != 2131376477)
    {
      if (i == 2131376644)
      {
        localObject1 = (RecommendsAdapter.RecFriendViewHolder)paramView.getTag();
        if (localObject1 != null)
        {
          localObject1 = ((RecommendsAdapter.RecFriendViewHolder)localObject1).jdField_a_of_type_ComTencentMobileqqDataMayKnowRecommend;
          if (localObject1 != null)
          {
            j = 103;
            localObject2 = (FriendsManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.FRIENDS_MANAGER);
            i = j;
            if (localObject2 != null)
            {
              i = j;
              if (((FriendsManager)localObject2).b(((MayKnowRecommend)localObject1).uin)) {
                i = 1;
              }
            }
            localObject2 = new AllInOne(((MayKnowRecommend)localObject1).uin, i);
            Object localObject3 = this.jdField_a_of_type_ComTencentMobileqqAppMayknowRecommendManager;
            if (localObject3 != null) {
              bool1 = ((MayknowRecommendManager)localObject3).a();
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
            bool1 = ((Activity)this.jdField_a_of_type_AndroidContentContext).getIntent().getBooleanExtra("from_babyq", false);
            localObject3 = new Bundle();
            if (bool1) {
              ((Bundle)localObject3).putBoolean("from_babyq", true);
            }
            ((Bundle)localObject3).putString("recommend_reason", ((MayKnowRecommend)localObject1).recommendReason);
            ((Bundle)localObject3).putInt("recommend_pos", this.jdField_a_of_type_JavaUtilList.indexOf(localObject1));
            ((Bundle)localObject3).putByteArray("recommend_algh_id", ((MayKnowRecommend)localObject1).algBuffer);
            ProfileActivity.a(this.jdField_a_of_type_AndroidContentContext, (AllInOne)localObject2, (Bundle)localObject3);
            localObject2 = this.jdField_a_of_type_ComTencentMobileqqAppMayknowRecommendManager;
            if (localObject2 != null) {
              ((MayknowRecommendManager)localObject2).a((MayKnowRecommend)localObject1, 20, 0, 2);
            }
            ContactReportUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, ((MayKnowRecommend)localObject1).uin, "frd_list_clk", 20, 0, ((MayKnowRecommend)localObject1).recommendReason, this.jdField_a_of_type_JavaUtilList.indexOf(localObject1), ((MayKnowRecommend)localObject1).algBuffer, 0);
          }
        }
      }
    }
    else
    {
      localObject1 = (MayKnowRecommend)paramView.getTag();
      if (localObject1 != null)
      {
        localObject2 = (FriendsManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.FRIENDS_MANAGER);
        if ((!((FriendsManager)localObject2).b(((MayKnowRecommend)localObject1).uin)) && (!((FriendsManager)localObject2).d(((MayKnowRecommend)localObject1).uin)))
        {
          boolean bool2 = ((Activity)this.jdField_a_of_type_AndroidContentContext).getIntent().getBooleanExtra("from_babyq", false);
          localObject2 = this.jdField_a_of_type_ComTencentMobileqqAppMayknowRecommendManager;
          if (localObject2 != null) {
            bool1 = ((MayknowRecommendManager)localObject2).a();
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
          localObject2 = ((IAddFriendApi)QRoute.api(IAddFriendApi.class)).startAddFriend(this.jdField_a_of_type_AndroidContentContext, 1, ((MayKnowRecommend)localObject1).uin, null, i, j, (String)localObject2, null, null, this.jdField_a_of_type_AndroidContentContext.getString(2131689589), null);
          ((Intent)localObject2).putExtra("key_param_age_area", ProfileCardUtil.a(this.jdField_a_of_type_AndroidContentContext, ((MayKnowRecommend)localObject1).gender, ((MayKnowRecommend)localObject1).age, ((MayKnowRecommend)localObject1).country, ((MayKnowRecommend)localObject1).province, ((MayKnowRecommend)localObject1).city));
          ((Intent)localObject2).putExtra("from_babyq", bool2);
          ((IAddFriendApi)QRoute.api(IAddFriendApi.class)).launchAddFriend((Activity)this.jdField_a_of_type_AndroidContentContext, (Intent)localObject2);
        }
        else if (((FriendsManager)localObject2).b(((MayKnowRecommend)localObject1).uin))
        {
          ((MayKnowRecommend)localObject1).friendStatus = 2;
          notifyDataSetChanged();
        }
        else
        {
          ((MayKnowRecommend)localObject1).friendStatus = 1;
          notifyDataSetChanged();
        }
        localObject2 = this.jdField_a_of_type_ComTencentMobileqqAppMayknowRecommendManager;
        if (localObject2 != null) {
          ((MayknowRecommendManager)localObject2).a((MayKnowRecommend)localObject1, 20, 0, 3);
        }
        ContactReportUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, ((MayKnowRecommend)localObject1).uin, "frd_list_add", 20, 1, ((MayKnowRecommend)localObject1).recommendReason, this.jdField_a_of_type_JavaUtilList.indexOf(localObject1), ((MayKnowRecommend)localObject1).algBuffer, 0);
      }
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.activity.contacts.mayknow.RecommendsAdapter
 * JD-Core Version:    0.7.0.1
 */