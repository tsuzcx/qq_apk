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
  long jdField_a_of_type_Long = 0L;
  Context jdField_a_of_type_AndroidContentContext;
  Resources jdField_a_of_type_AndroidContentResResources;
  MayknowRecommendManager jdField_a_of_type_ComTencentMobileqqAppMayknowRecommendManager;
  QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private AbsListView.OnScrollListener jdField_a_of_type_ComTencentWidgetAbsListView$OnScrollListener = new MayknowRecommendsAdapter.1(this);
  XListView jdField_a_of_type_ComTencentWidgetXListView;
  protected Runnable a;
  List<MayKnowRecommend> jdField_a_of_type_JavaUtilList = new ArrayList();
  
  public MayknowRecommendsAdapter(Context paramContext, QQAppInterface paramQQAppInterface, XListView paramXListView, int paramInt, boolean paramBoolean)
  {
    super(paramContext, paramQQAppInterface, paramXListView, paramInt, paramBoolean);
    this.jdField_a_of_type_JavaLangRunnable = new MayknowRecommendsAdapter.2(this);
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_AndroidContentResResources = this.jdField_a_of_type_AndroidContentContext.getResources();
    this.jdField_a_of_type_ComTencentWidgetXListView = paramXListView;
    this.jdField_a_of_type_ComTencentMobileqqAppMayknowRecommendManager = ((MayknowRecommendManager)paramQQAppInterface.getManager(QQManagerFactory.MAYKNOW_RECOMMEND_MANAGER));
    a(this.jdField_a_of_type_ComTencentWidgetAbsListView$OnScrollListener);
  }
  
  private void a(MayknowRecommendsAdapter.RecFriendViewHolder paramRecFriendViewHolder)
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
  
  private void a(MayKnowRecommend paramMayKnowRecommend)
  {
    if (paramMayKnowRecommend != null)
    {
      Object localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
      if ((localObject != null) && (this.jdField_a_of_type_AndroidContentContext != null))
      {
        localObject = (FriendsManager)((QQAppInterface)localObject).getManager(QQManagerFactory.FRIENDS_MANAGER);
        if ((!((FriendsManager)localObject).b(paramMayKnowRecommend.uin)) && (!((FriendsManager)localObject).d(paramMayKnowRecommend.uin)))
        {
          boolean bool2 = ((Activity)this.jdField_a_of_type_AndroidContentContext).getIntent().getBooleanExtra("from_babyq", false);
          localObject = this.jdField_a_of_type_ComTencentMobileqqAppMayknowRecommendManager;
          boolean bool1;
          if (localObject != null) {
            bool1 = ((MayknowRecommendManager)localObject).a();
          } else {
            bool1 = false;
          }
          localObject = paramMayKnowRecommend.getDisplayName(bool1);
          int i;
          int j;
          if (bool2)
          {
            i = 3083;
            j = 1;
          }
          else
          {
            i = 3045;
            j = 24;
          }
          localObject = ((IAddFriendApi)QRoute.api(IAddFriendApi.class)).startAddFriend(this.jdField_a_of_type_AndroidContentContext, 1, paramMayKnowRecommend.uin, null, i, j, (String)localObject, null, null, this.jdField_a_of_type_AndroidContentContext.getString(2131689589), null);
          ((Intent)localObject).putExtra("key_param_age_area", ProfileCardUtil.a(this.jdField_a_of_type_AndroidContentContext, paramMayKnowRecommend.gender, paramMayKnowRecommend.age, paramMayKnowRecommend.country, paramMayKnowRecommend.province, paramMayKnowRecommend.city));
          ((Intent)localObject).putExtra("from_babyq", bool2);
          ((IAddFriendApi)QRoute.api(IAddFriendApi.class)).launchAddFriend((Activity)this.jdField_a_of_type_AndroidContentContext, (Intent)localObject);
        }
        else if (((FriendsManager)localObject).b(paramMayKnowRecommend.uin))
        {
          paramMayKnowRecommend.friendStatus = 2;
          notifyDataSetChanged();
        }
        else
        {
          paramMayKnowRecommend.friendStatus = 1;
          notifyDataSetChanged();
        }
        localObject = this.jdField_a_of_type_ComTencentMobileqqAppMayknowRecommendManager;
        if (localObject != null) {
          ((MayknowRecommendManager)localObject).a(paramMayKnowRecommend, 24, 0, 3);
        }
        ContactReportUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramMayKnowRecommend.uin, "frd_list_add", 24, 1, paramMayKnowRecommend.recommendReason, this.jdField_a_of_type_JavaUtilList.indexOf(paramMayKnowRecommend), paramMayKnowRecommend.algBuffer, 0, "1");
      }
    }
  }
  
  public void a()
  {
    super.c();
    a(null);
    List localList = this.jdField_a_of_type_JavaUtilList;
    if (localList != null) {
      localList.clear();
    }
    this.jdField_a_of_type_ComTencentWidgetXListView = null;
    this.jdField_a_of_type_ComTencentMobileqqAppMayknowRecommendManager = null;
    this.jdField_a_of_type_AndroidContentContext = null;
    this.jdField_a_of_type_AndroidContentResResources = null;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = null;
  }
  
  public void a(QQAppInterface paramQQAppInterface)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != paramQQAppInterface) {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
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
      ((StringBuilder)localObject).append(this.jdField_a_of_type_ComTencentWidgetXListView.getFirstVisiblePosition());
      ((StringBuilder)localObject).append(" lastvisible: ");
      ((StringBuilder)localObject).append(this.jdField_a_of_type_ComTencentWidgetXListView.getLastVisiblePosition());
      QLog.d("contacts.RecommendsAdapter", 2, ((StringBuilder)localObject).toString());
    }
    if ((getCount() > 0) && (this.jdField_a_of_type_ComTencentWidgetXListView.isShown()))
    {
      localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
      if (localObject != null)
      {
        localObject = (MayknowRecommendManager)((QQAppInterface)localObject).getManager(QQManagerFactory.MAYKNOW_RECOMMEND_MANAGER);
        int i = this.jdField_a_of_type_ComTencentWidgetXListView.getFirstVisiblePosition();
        while (i <= this.jdField_a_of_type_ComTencentWidgetXListView.getLastVisiblePosition())
        {
          if ((i >= 0) && (i < getCount())) {
            ((MayknowRecommendManager)localObject).a((MayKnowRecommend)getItem(i), 24, 0, 1);
          }
          i += 1;
        }
      }
    }
    Object localObject = this.jdField_a_of_type_ComTencentWidgetXListView;
    if (localObject != null)
    {
      ((XListView)localObject).removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
      this.jdField_a_of_type_ComTencentWidgetXListView.postDelayed(this.jdField_a_of_type_JavaLangRunnable, 1000L);
    }
  }
  
  public void e()
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
      localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
      if (localObject != null)
      {
        localObject = (MayknowRecommendManager)((QQAppInterface)localObject).getManager(QQManagerFactory.MAYKNOW_RECOMMEND_MANAGER);
        int i = this.jdField_a_of_type_ComTencentWidgetXListView.getFirstVisiblePosition();
        while (i <= this.jdField_a_of_type_ComTencentWidgetXListView.getLastVisiblePosition())
        {
          if ((i >= 0) && (i < getCount())) {
            ((MayknowRecommendManager)localObject).b((MayKnowRecommend)getItem(i), 24, 0, 1);
          }
          i += 1;
        }
      }
    }
    Object localObject = this.jdField_a_of_type_ComTencentWidgetXListView;
    if (localObject != null) {
      ((XListView)localObject).removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
    }
  }
  
  public void f()
  {
    Object localObject1 = this.jdField_a_of_type_ComTencentWidgetXListView;
    if ((localObject1 != null) && (((XListView)localObject1).isShown()) && (!this.jdField_a_of_type_JavaUtilList.isEmpty()))
    {
      this.jdField_a_of_type_ComTencentWidgetXListView.removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
      int j = this.jdField_a_of_type_ComTencentWidgetXListView.getFirstVisiblePosition();
      int k = this.jdField_a_of_type_ComTencentWidgetXListView.getLastVisiblePosition();
      localObject1 = new ArrayList();
      ArrayList localArrayList1 = new ArrayList();
      ArrayList localArrayList2 = new ArrayList();
      ArrayList localArrayList3 = new ArrayList();
      int i = j;
      while (i <= k)
      {
        if ((i >= 0) && (i < this.jdField_a_of_type_JavaUtilList.size()) && (this.jdField_a_of_type_JavaUtilList.get(i) != null))
        {
          ((ArrayList)localObject1).add(((MayKnowRecommend)this.jdField_a_of_type_JavaUtilList.get(i)).uin);
          localArrayList1.add(((MayKnowRecommend)this.jdField_a_of_type_JavaUtilList.get(i)).recommendReason);
          localArrayList2.add(Integer.valueOf(i));
          localArrayList3.add(((MayKnowRecommend)this.jdField_a_of_type_JavaUtilList.get(i)).algBuffer);
        }
        i += 1;
      }
      Object localObject2;
      if (QLog.isColorLevel())
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("reportRecommendFrdExpose firstVisibleItem: ");
        ((StringBuilder)localObject2).append(j);
        ((StringBuilder)localObject2).append(" lastVisibleItem: ");
        ((StringBuilder)localObject2).append(k);
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
        localObject2 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
        if (localObject2 != null) {
          ContactReportUtils.b((QQAppInterface)localObject2, 24, (ArrayList)localObject1, localArrayList1, localArrayList2, localArrayList3, 0, "1");
        }
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
    Object localObject1 = paramView;
    if (this.jdField_a_of_type_AndroidContentResResources != null)
    {
      localObject1 = paramView;
      if (this.jdField_a_of_type_AndroidContentContext != null) {
        if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null)
        {
          localObject1 = paramView;
        }
        else
        {
          if (paramView == null)
          {
            localObject2 = new MayknowRecommendsAdapter.RecFriendViewHolder();
            localObject3 = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131558934, paramViewGroup, false);
            ((MayknowRecommendsAdapter.RecFriendViewHolder)localObject2).c = ((ImageView)((View)localObject3).findViewById(2131361799));
            ((MayknowRecommendsAdapter.RecFriendViewHolder)localObject2).jdField_a_of_type_ComTencentWidgetSingleLineTextView = ((SingleLineTextView)((View)localObject3).findViewById(2131371877));
            ((MayknowRecommendsAdapter.RecFriendViewHolder)localObject2).b = ((SingleLineTextView)((View)localObject3).findViewById(2131376487));
            ((MayknowRecommendsAdapter.RecFriendViewHolder)localObject2).jdField_a_of_type_AndroidWidgetButton = ((Button)((View)localObject3).findViewById(2131376477));
            ((MayknowRecommendsAdapter.RecFriendViewHolder)localObject2).jdField_a_of_type_AndroidWidgetTextView = ((TextView)((View)localObject3).findViewById(2131376485));
            ((MayknowRecommendsAdapter.RecFriendViewHolder)localObject2).jdField_a_of_type_AndroidWidgetImageView = ((ImageView)((View)localObject3).findViewById(2131365494));
            ((View)localObject3).setTag(localObject2);
            paramView = (View)localObject3;
            localObject1 = localObject2;
            if ((((MayknowRecommendsAdapter.RecFriendViewHolder)localObject2).c instanceof ThemeImageView))
            {
              ((ThemeImageView)((MayknowRecommendsAdapter.RecFriendViewHolder)localObject2).c).setSupportMaskView(false);
              paramView = (View)localObject3;
              localObject1 = localObject2;
            }
          }
          else
          {
            localObject1 = (MayknowRecommendsAdapter.RecFriendViewHolder)paramView.getTag();
          }
          Object localObject2 = (MayKnowRecommend)getItem(paramInt);
          ((MayknowRecommendsAdapter.RecFriendViewHolder)localObject1).jdField_a_of_type_JavaLangString = ((MayKnowRecommend)localObject2).uin;
          ((MayknowRecommendsAdapter.RecFriendViewHolder)localObject1).jdField_a_of_type_ComTencentMobileqqDataMayKnowRecommend = ((MayKnowRecommend)localObject2);
          Object localObject3 = this.jdField_a_of_type_ComTencentMobileqqAppMayknowRecommendManager;
          boolean bool;
          if (localObject3 != null) {
            bool = ((MayknowRecommendManager)localObject3).a();
          } else {
            bool = false;
          }
          Object localObject4 = ((MayKnowRecommend)localObject2).getDisplayName(bool);
          localObject3 = new StringBuilder(512);
          if (!TextUtils.isEmpty((CharSequence)localObject4))
          {
            ((MayknowRecommendsAdapter.RecFriendViewHolder)localObject1).jdField_a_of_type_ComTencentWidgetSingleLineTextView.setVisibility(0);
            ((MayknowRecommendsAdapter.RecFriendViewHolder)localObject1).jdField_a_of_type_ComTencentWidgetSingleLineTextView.setText((CharSequence)localObject4);
            if (AppSetting.d) {
              ((StringBuilder)localObject3).append((String)localObject4);
            }
          }
          else
          {
            ((MayknowRecommendsAdapter.RecFriendViewHolder)localObject1).jdField_a_of_type_ComTencentWidgetSingleLineTextView.setVisibility(8);
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
            if (AppSetting.d)
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
            ((MayknowRecommendsAdapter.RecFriendViewHolder)localObject1).jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this);
            ((MayknowRecommendsAdapter.RecFriendViewHolder)localObject1).jdField_a_of_type_AndroidWidgetButton.setVisibility(0);
            ((MayknowRecommendsAdapter.RecFriendViewHolder)localObject1).jdField_a_of_type_AndroidWidgetButton.setTag(localObject2);
            ((MayknowRecommendsAdapter.RecFriendViewHolder)localObject1).jdField_a_of_type_AndroidWidgetButton.setText(HardCodeUtil.a(2131689589));
            ((MayknowRecommendsAdapter.RecFriendViewHolder)localObject1).jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
            if (AppSetting.d)
            {
              ((StringBuilder)localObject3).append(",点击添加");
              ((MayknowRecommendsAdapter.RecFriendViewHolder)localObject1).jdField_a_of_type_AndroidWidgetButton.setContentDescription(HardCodeUtil.a(2131689589));
            }
          }
          else if (((MayKnowRecommend)localObject2).friendStatus == 1)
          {
            ((MayknowRecommendsAdapter.RecFriendViewHolder)localObject1).jdField_a_of_type_AndroidWidgetButton.setVisibility(8);
            ((MayknowRecommendsAdapter.RecFriendViewHolder)localObject1).jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
            ((MayknowRecommendsAdapter.RecFriendViewHolder)localObject1).jdField_a_of_type_AndroidWidgetTextView.setText(2131718222);
            if (AppSetting.d)
            {
              ((StringBuilder)localObject3).append(",等待验证");
              ((MayknowRecommendsAdapter.RecFriendViewHolder)localObject1).jdField_a_of_type_AndroidWidgetTextView.setContentDescription(this.jdField_a_of_type_AndroidContentResResources.getString(2131718222));
            }
          }
          else
          {
            ((MayknowRecommendsAdapter.RecFriendViewHolder)localObject1).jdField_a_of_type_AndroidWidgetButton.setVisibility(8);
            ((MayknowRecommendsAdapter.RecFriendViewHolder)localObject1).jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
            ((MayknowRecommendsAdapter.RecFriendViewHolder)localObject1).jdField_a_of_type_AndroidWidgetTextView.setText(2131689988);
            if (AppSetting.d)
            {
              ((StringBuilder)localObject3).append(",已添加");
              ((MayknowRecommendsAdapter.RecFriendViewHolder)localObject1).jdField_a_of_type_AndroidWidgetTextView.setContentDescription(this.jdField_a_of_type_AndroidContentResResources.getString(2131689988));
            }
          }
          if (QLog.isColorLevel()) {
            a((MayknowRecommendsAdapter.RecFriendViewHolder)localObject1);
          }
          localObject4 = this.jdField_a_of_type_ComTencentMobileqqAppMayknowRecommendManager;
          if (localObject4 != null) {
            ((MayknowRecommendManager)localObject4).a((MayKnowRecommend)localObject2, 24, 0, 1);
          }
          if (AppSetting.d) {
            paramView.setContentDescription(((StringBuilder)localObject3).toString());
          }
          ((MayknowRecommendsAdapter.RecFriendViewHolder)localObject1).jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(this);
          ((MayknowRecommendsAdapter.RecFriendViewHolder)localObject1).jdField_a_of_type_AndroidWidgetImageView.setTag(localObject2);
          paramView.setOnClickListener(this);
          if (AppSetting.d) {
            ((MayknowRecommendsAdapter.RecFriendViewHolder)localObject1).jdField_a_of_type_AndroidWidgetImageView.setContentDescription(HardCodeUtil.a(2131706537));
          }
          ((MayknowRecommendsAdapter.RecFriendViewHolder)localObject1).c.setImageBitmap(a(1, ((MayknowRecommendsAdapter.RecFriendViewHolder)localObject1).jdField_a_of_type_JavaLangString));
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
    if (i != 2131365494)
    {
      if (i != 2131376477)
      {
        if (i == 2131376644)
        {
          localObject1 = (MayknowRecommendsAdapter.RecFriendViewHolder)paramView.getTag();
          if (localObject1 != null)
          {
            localObject1 = ((MayknowRecommendsAdapter.RecFriendViewHolder)localObject1).jdField_a_of_type_ComTencentMobileqqDataMayKnowRecommend;
            if (localObject1 != null)
            {
              localObject2 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
              if ((localObject2 != null) && (this.jdField_a_of_type_AndroidContentContext != null))
              {
                int j = 101;
                localObject2 = (FriendsManager)((QQAppInterface)localObject2).getManager(QQManagerFactory.FRIENDS_MANAGER);
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
                  bool = ((MayknowRecommendManager)localObject3).a();
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
                boolean bool = ((Activity)this.jdField_a_of_type_AndroidContentContext).getIntent().getBooleanExtra("from_babyq", false);
                localObject3 = new Bundle();
                if (bool) {
                  ((Bundle)localObject3).putBoolean("from_babyq", true);
                }
                ((Bundle)localObject3).putString("recommend_entry_type", "1");
                ((Bundle)localObject3).putString("recommend_reason", ((MayKnowRecommend)localObject1).recommendReason);
                ((Bundle)localObject3).putInt("recommend_pos", this.jdField_a_of_type_JavaUtilList.indexOf(localObject1));
                ((Bundle)localObject3).putByteArray("recommend_algh_id", ((MayKnowRecommend)localObject1).algBuffer);
                ProfileActivity.a(this.jdField_a_of_type_AndroidContentContext, (AllInOne)localObject2, (Bundle)localObject3);
                localObject2 = this.jdField_a_of_type_ComTencentMobileqqAppMayknowRecommendManager;
                if (localObject2 != null) {
                  ((MayknowRecommendManager)localObject2).a((MayKnowRecommend)localObject1, 24, 0, 2);
                }
                ContactReportUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, ((MayKnowRecommend)localObject1).uin, "frd_list_clk", 24, 0, ((MayKnowRecommend)localObject1).recommendReason, this.jdField_a_of_type_JavaUtilList.indexOf(localObject1), ((MayKnowRecommend)localObject1).algBuffer, 0, "1");
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
      if ((localObject2 != null) && (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null) && (System.currentTimeMillis() - this.jdField_a_of_type_Long > 500L))
      {
        this.jdField_a_of_type_Long = System.currentTimeMillis();
        localObject1 = (CTEntryMng)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.CTENTRY_MNG);
        if (localObject1 == null) {
          localObject1 = null;
        } else {
          localObject1 = ((CTEntryMng)localObject1).a();
        }
        if (localObject1 != null) {
          ((CardViewController)localObject1).a(((MayKnowRecommend)localObject2).uin);
        }
        if (this.jdField_a_of_type_JavaUtilList != null) {
          ContactReportUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, ((MayKnowRecommend)localObject2).uin, "frd_list_dlt", 24, 0, ((MayKnowRecommend)localObject2).recommendReason, this.jdField_a_of_type_JavaUtilList.indexOf(localObject2), ((MayKnowRecommend)localObject2).algBuffer, 0, "1");
        }
      }
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.activity.contacts.topentry.MayknowRecommendsAdapter
 * JD-Core Version:    0.7.0.1
 */