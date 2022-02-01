package com.tencent.mobileqq.activity;

import android.content.res.Resources;
import android.support.v4.view.ViewCompat;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.data.DiscussionInfo;
import com.tencent.mobileqq.data.DiscussionMemberInfo;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.utils.ContactUtils;
import com.tencent.mobileqq.utils.ImageUtil;
import com.tencent.mobileqq.utils.QAVHrMeeting;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.List;

class DiscussionInfoCardActivity$ListAdapter
  extends BaseAdapter
{
  private FriendsManager jdField_a_of_type_ComTencentMobileqqAppFriendsManager = null;
  
  public DiscussionInfoCardActivity$ListAdapter(DiscussionInfoCardActivity paramDiscussionInfoCardActivity)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppFriendsManager = ((FriendsManager)paramDiscussionInfoCardActivity.app.getManager(QQManagerFactory.FRIENDS_MANAGER));
  }
  
  public int getCount()
  {
    if (DiscussionInfoCardActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityDiscussionInfoCardActivity) == null) {
      return 1;
    }
    return 1 + DiscussionInfoCardActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityDiscussionInfoCardActivity).size();
  }
  
  public Object getItem(int paramInt)
  {
    if ((DiscussionInfoCardActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityDiscussionInfoCardActivity) != null) && (paramInt < DiscussionInfoCardActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityDiscussionInfoCardActivity).size())) {
      return DiscussionInfoCardActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityDiscussionInfoCardActivity).get(paramInt);
    }
    return null;
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    View localView;
    DiscussionInfoCardActivity.ViewHolder localViewHolder;
    if (paramView == null)
    {
      localView = this.jdField_a_of_type_ComTencentMobileqqActivityDiscussionInfoCardActivity.getLayoutInflater().inflate(2131558841, null);
      localViewHolder = new DiscussionInfoCardActivity.ViewHolder();
      localViewHolder.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)localView.findViewById(2131368343));
      localViewHolder.jdField_a_of_type_AndroidWidgetTextView = ((TextView)localView.findViewById(2131371697));
      localView.setTag(localViewHolder);
    }
    else
    {
      localViewHolder = (DiscussionInfoCardActivity.ViewHolder)paramView.getTag();
      localView = paramView;
    }
    localView.setVisibility(0);
    localView.setFocusable(false);
    TextView localTextView = localViewHolder.jdField_a_of_type_AndroidWidgetTextView;
    ImageView localImageView = localViewHolder.jdField_a_of_type_AndroidWidgetImageView;
    Object localObject1;
    if (paramInt == getCount() - 1)
    {
      localObject1 = this.jdField_a_of_type_ComTencentMobileqqActivityDiscussionInfoCardActivity.getString(2131693478);
      localTextView.setText((CharSequence)localObject1);
      localTextView.setTextColor(this.jdField_a_of_type_ComTencentMobileqqActivityDiscussionInfoCardActivity.getResources().getColor(2131167064));
      localImageView.setBackgroundDrawable(null);
      localImageView.setImageResource(2130839166);
      localImageView.setTag(localObject1);
      if ((this.jdField_a_of_type_ComTencentMobileqqActivityDiscussionInfoCardActivity.a.isDiscussHrMeeting()) && (QAVHrMeeting.a(this.jdField_a_of_type_ComTencentMobileqqActivityDiscussionInfoCardActivity.a.mSelfRight))) {
        localImageView.setEnabled(false);
      } else {
        localImageView.setEnabled(true);
      }
    }
    else
    {
      int i = getCount();
      Object localObject2 = "";
      if (paramInt > i - 1)
      {
        localTextView.setText("");
        localImageView.setBackgroundDrawable(null);
        localImageView.setImageDrawable(null);
      }
      else
      {
        localImageView.setImageResource(2130844956);
        localTextView.setTextColor(this.jdField_a_of_type_ComTencentMobileqqActivityDiscussionInfoCardActivity.getResources().getColor(2131167056));
        String str = ((DiscussionMemberInfo)DiscussionInfoCardActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityDiscussionInfoCardActivity).get(paramInt)).memberUin;
        localViewHolder.jdField_a_of_type_JavaLangString = str;
        localObject1 = ContactUtils.a(this.jdField_a_of_type_ComTencentMobileqqActivityDiscussionInfoCardActivity.app, DiscussionInfoCardActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityDiscussionInfoCardActivity), str);
        if (TextUtils.isEmpty(str))
        {
          if (localObject1 == null) {
            localObject1 = localObject2;
          }
          localTextView.setText((CharSequence)localObject1);
          localImageView.setImageDrawable(ImageUtil.e());
        }
        else
        {
          if (TextUtils.isEmpty((CharSequence)localObject1))
          {
            localObject2 = this.jdField_a_of_type_ComTencentMobileqqAppFriendsManager;
            if (localObject2 != null)
            {
              localObject2 = ((FriendsManager)localObject2).e(str);
              if ((localObject2 != null) && (((Friends)localObject2).isFriend())) {
                localObject1 = ContactUtils.a(this.jdField_a_of_type_ComTencentMobileqqActivityDiscussionInfoCardActivity.app, str);
              }
            }
          }
          localObject2 = localObject1;
          if (TextUtils.isEmpty((CharSequence)localObject1)) {
            localObject2 = str;
          }
          localTextView.setText((CharSequence)localObject2);
          this.jdField_a_of_type_ComTencentMobileqqActivityDiscussionInfoCardActivity.a(localViewHolder, null, true);
          localImageView.setTag(str);
          localImageView.setTag(2131378298, localObject2);
        }
      }
    }
    if (AppSetting.d) {
      ViewCompat.setImportantForAccessibility(localImageView, 2);
    }
    localImageView.setOnClickListener(this.jdField_a_of_type_ComTencentMobileqqActivityDiscussionInfoCardActivity);
    EventCollector.getInstance().onListGetView(paramInt, paramView, paramViewGroup, getItemId(paramInt));
    return localView;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.DiscussionInfoCardActivity.ListAdapter
 * JD-Core Version:    0.7.0.1
 */