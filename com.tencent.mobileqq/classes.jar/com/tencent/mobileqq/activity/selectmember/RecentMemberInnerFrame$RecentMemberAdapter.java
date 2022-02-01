package com.tencent.mobileqq.activity.selectmember;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.adapter.FacePreloadBaseAdapter;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.utils.ContactUtils;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;
import java.util.List;

class RecentMemberInnerFrame$RecentMemberAdapter
  extends FacePreloadBaseAdapter
{
  public RecentMemberInnerFrame$RecentMemberAdapter(RecentMemberInnerFrame paramRecentMemberInnerFrame)
  {
    super(paramRecentMemberInnerFrame.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity, paramRecentMemberInnerFrame.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, RecentMemberInnerFrame.a(paramRecentMemberInnerFrame), 1, true);
  }
  
  public int getCount()
  {
    if (RecentMemberInnerFrame.a(this.a) == null) {
      return 0;
    }
    return RecentMemberInnerFrame.a(this.a).size();
  }
  
  public Object getItem(int paramInt)
  {
    if ((paramInt >= 0) && (paramInt < RecentMemberInnerFrame.a(this.a).size())) {
      return RecentMemberInnerFrame.a(this.a).get(paramInt);
    }
    return null;
  }
  
  public long getItemId(int paramInt)
  {
    return 0L;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    Object localObject;
    View localView;
    if ((paramView != null) && (paramView.getTag() != null))
    {
      localObject = (RecentMemberInnerFrame.ViewHolder)paramView.getTag();
      localView = paramView;
      paramView = (View)localObject;
    }
    RecentUser localRecentUser;
    for (;;)
    {
      localRecentUser = (RecentUser)getItem(paramInt);
      if (localRecentUser != null) {
        break;
      }
      EventCollector.getInstance().onListGetView(paramInt, localView, paramViewGroup, getItemId(paramInt));
      return localView;
      paramView = new RecentMemberInnerFrame.ViewHolder(this.a, null);
      localView = this.a.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity.getLayoutInflater().inflate(2131562998, paramViewGroup, false);
      paramView.jdField_a_of_type_AndroidWidgetCheckBox = ((CheckBox)localView.findViewById(2131364726));
      paramView.c = ((ImageView)localView.findViewById(2131368603));
      paramView.jdField_a_of_type_AndroidWidgetTextView = ((TextView)localView.findViewById(2131372115));
      localView.setTag(paramView);
    }
    if (this.a.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity.b(localRecentUser.uin))
    {
      paramView.jdField_a_of_type_AndroidWidgetCheckBox.setChecked(true);
      label168:
      paramView.c.setImageBitmap(a(1, localRecentUser.uin));
      localObject = RecentMemberInnerFrame.a(this.a).b(localRecentUser.uin);
      if (localObject != null) {
        break label348;
      }
      localObject = "";
      label211:
      paramView.jdField_a_of_type_AndroidWidgetTextView.setText((CharSequence)localObject);
      paramView.jdField_a_of_type_JavaLangString = localRecentUser.uin;
      if ((this.a.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity.b == null) || (!this.a.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity.b.contains(localRecentUser.uin))) {
        break label358;
      }
      paramView.jdField_a_of_type_AndroidWidgetCheckBox.setEnabled(false);
      label271:
      if (AppSetting.d)
      {
        if ((!paramView.jdField_a_of_type_AndroidWidgetCheckBox.isChecked()) || (!paramView.jdField_a_of_type_AndroidWidgetCheckBox.isEnabled())) {
          break label369;
        }
        localView.setContentDescription((String)localObject + HardCodeUtil.a(2131713156));
      }
    }
    for (;;)
    {
      localView.setOnClickListener(this.a);
      break;
      paramView.jdField_a_of_type_AndroidWidgetCheckBox.setChecked(false);
      break label168;
      label348:
      localObject = ContactUtils.a((Friends)localObject);
      break label211;
      label358:
      paramView.jdField_a_of_type_AndroidWidgetCheckBox.setEnabled(true);
      break label271;
      label369:
      localView.setContentDescription((String)localObject + HardCodeUtil.a(2131713153));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.selectmember.RecentMemberInnerFrame.RecentMemberAdapter
 * JD-Core Version:    0.7.0.1
 */