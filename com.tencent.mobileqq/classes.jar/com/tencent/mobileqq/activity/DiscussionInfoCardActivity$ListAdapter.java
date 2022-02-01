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
    return DiscussionInfoCardActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityDiscussionInfoCardActivity).size() + 1;
  }
  
  public Object getItem(int paramInt)
  {
    if ((DiscussionInfoCardActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityDiscussionInfoCardActivity) == null) || (paramInt >= DiscussionInfoCardActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityDiscussionInfoCardActivity).size())) {
      return null;
    }
    return DiscussionInfoCardActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityDiscussionInfoCardActivity).get(paramInt);
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    View localView;
    DiscussionInfoCardActivity.ViewHolder localViewHolder;
    TextView localTextView;
    ImageView localImageView;
    Object localObject1;
    if (paramView == null)
    {
      localView = this.jdField_a_of_type_ComTencentMobileqqActivityDiscussionInfoCardActivity.getLayoutInflater().inflate(2131558943, null);
      localViewHolder = new DiscussionInfoCardActivity.ViewHolder();
      localViewHolder.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)localView.findViewById(2131368603));
      localViewHolder.jdField_a_of_type_AndroidWidgetTextView = ((TextView)localView.findViewById(2131372115));
      localView.setTag(localViewHolder);
      localView.setVisibility(0);
      localView.setFocusable(false);
      localTextView = localViewHolder.jdField_a_of_type_AndroidWidgetTextView;
      localImageView = localViewHolder.jdField_a_of_type_AndroidWidgetImageView;
      if (paramInt != getCount() - 1) {
        break label253;
      }
      localObject1 = this.jdField_a_of_type_ComTencentMobileqqActivityDiscussionInfoCardActivity.getString(2131693523);
      localTextView.setText((CharSequence)localObject1);
      localTextView.setTextColor(this.jdField_a_of_type_ComTencentMobileqqActivityDiscussionInfoCardActivity.getResources().getColor(2131167041));
      localImageView.setBackgroundDrawable(null);
      localImageView.setImageResource(2130839311);
      localImageView.setTag(localObject1);
      if ((!this.jdField_a_of_type_ComTencentMobileqqActivityDiscussionInfoCardActivity.a.isDiscussHrMeeting()) || (!QAVHrMeeting.a(this.jdField_a_of_type_ComTencentMobileqqActivityDiscussionInfoCardActivity.a.mSelfRight))) {
        break label244;
      }
      localImageView.setEnabled(false);
    }
    for (;;)
    {
      if (AppSetting.d) {
        ViewCompat.setImportantForAccessibility(localImageView, 2);
      }
      localImageView.setOnClickListener(this.jdField_a_of_type_ComTencentMobileqqActivityDiscussionInfoCardActivity);
      EventCollector.getInstance().onListGetView(paramInt, paramView, paramViewGroup, getItemId(paramInt));
      return localView;
      localViewHolder = (DiscussionInfoCardActivity.ViewHolder)paramView.getTag();
      localView = paramView;
      break;
      label244:
      localImageView.setEnabled(true);
      continue;
      label253:
      if (paramInt > getCount() - 1)
      {
        localTextView.setText("");
        localImageView.setBackgroundDrawable(null);
        localImageView.setImageDrawable(null);
      }
      else
      {
        localImageView.setImageResource(2130845079);
        localTextView.setTextColor(this.jdField_a_of_type_ComTencentMobileqqActivityDiscussionInfoCardActivity.getResources().getColor(2131167033));
        String str = ((DiscussionMemberInfo)DiscussionInfoCardActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityDiscussionInfoCardActivity).get(paramInt)).memberUin;
        localViewHolder.jdField_a_of_type_JavaLangString = str;
        Object localObject2 = ContactUtils.c(this.jdField_a_of_type_ComTencentMobileqqActivityDiscussionInfoCardActivity.app, DiscussionInfoCardActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityDiscussionInfoCardActivity), str);
        if (TextUtils.isEmpty(str))
        {
          localObject1 = localObject2;
          if (localObject2 == null) {
            localObject1 = "";
          }
          localTextView.setText((CharSequence)localObject1);
          localImageView.setImageDrawable(ImageUtil.c());
        }
        else
        {
          localObject1 = localObject2;
          if (TextUtils.isEmpty((CharSequence)localObject2))
          {
            localObject1 = localObject2;
            if (this.jdField_a_of_type_ComTencentMobileqqAppFriendsManager != null)
            {
              Friends localFriends = this.jdField_a_of_type_ComTencentMobileqqAppFriendsManager.e(str);
              localObject1 = localObject2;
              if (localFriends != null)
              {
                localObject1 = localObject2;
                if (localFriends.isFriend()) {
                  localObject1 = ContactUtils.a(this.jdField_a_of_type_ComTencentMobileqqActivityDiscussionInfoCardActivity.app, str);
                }
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
          localImageView.setTag(2131378909, localObject2);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.DiscussionInfoCardActivity.ListAdapter
 * JD-Core Version:    0.7.0.1
 */