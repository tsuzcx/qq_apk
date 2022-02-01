package com.tencent.mobileqq.activity.selectmember;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.List;
import tencent.im.nearfield_discuss.nearfield_discuss.UserProfile;

class CreateFaceToFaceDiscussionActivity$GridViewAdapter
  extends BaseAdapter
{
  LayoutInflater jdField_a_of_type_AndroidViewLayoutInflater;
  CreateFaceToFaceDiscussionActivity.ViewHolder jdField_a_of_type_ComTencentMobileqqActivitySelectmemberCreateFaceToFaceDiscussionActivity$ViewHolder;
  
  public CreateFaceToFaceDiscussionActivity$GridViewAdapter(CreateFaceToFaceDiscussionActivity paramCreateFaceToFaceDiscussionActivity)
  {
    this.jdField_a_of_type_AndroidViewLayoutInflater = LayoutInflater.from(paramCreateFaceToFaceDiscussionActivity.jdField_a_of_type_AndroidContentContext);
  }
  
  public int getCount()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberCreateFaceToFaceDiscussionActivity.jdField_a_of_type_JavaUtilList == null) {
      return 0;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberCreateFaceToFaceDiscussionActivity.jdField_a_of_type_JavaUtilList.size() < 50) {
      return this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberCreateFaceToFaceDiscussionActivity.jdField_a_of_type_JavaUtilList.size() + 1;
    }
    return this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberCreateFaceToFaceDiscussionActivity.jdField_a_of_type_JavaUtilList.size();
  }
  
  public Object getItem(int paramInt)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberCreateFaceToFaceDiscussionActivity.jdField_a_of_type_JavaUtilList == null) {
      return null;
    }
    return (nearfield_discuss.UserProfile)this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberCreateFaceToFaceDiscussionActivity.jdField_a_of_type_JavaUtilList.get(paramInt);
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    if (paramView == null)
    {
      paramView = this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2131561261, null);
      this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberCreateFaceToFaceDiscussionActivity$ViewHolder = new CreateFaceToFaceDiscussionActivity.ViewHolder(this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberCreateFaceToFaceDiscussionActivity);
      this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberCreateFaceToFaceDiscussionActivity$ViewHolder.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131368603));
      this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberCreateFaceToFaceDiscussionActivity$ViewHolder.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131372115));
      paramView.setTag(this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberCreateFaceToFaceDiscussionActivity$ViewHolder);
    }
    label238:
    for (;;)
    {
      if ((paramInt == getCount() - 1) && (getCount() < 50)) {
        CreateFaceToFaceDiscussionActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberCreateFaceToFaceDiscussionActivity, paramView);
      }
      for (;;)
      {
        EventCollector.getInstance().onListGetView(paramInt, paramView, paramViewGroup, getItemId(paramInt));
        return paramView;
        this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberCreateFaceToFaceDiscussionActivity$ViewHolder = ((CreateFaceToFaceDiscussionActivity.ViewHolder)paramView.getTag());
        if (!this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberCreateFaceToFaceDiscussionActivity$ViewHolder.jdField_a_of_type_Boolean) {
          break label238;
        }
        paramView = this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2131561261, null);
        this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberCreateFaceToFaceDiscussionActivity$ViewHolder = new CreateFaceToFaceDiscussionActivity.ViewHolder(this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberCreateFaceToFaceDiscussionActivity);
        this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberCreateFaceToFaceDiscussionActivity$ViewHolder.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131368603));
        this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberCreateFaceToFaceDiscussionActivity$ViewHolder.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131372115));
        paramView.setTag(this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberCreateFaceToFaceDiscussionActivity$ViewHolder);
        this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberCreateFaceToFaceDiscussionActivity$ViewHolder.jdField_a_of_type_Boolean = false;
        break;
        CreateFaceToFaceDiscussionActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberCreateFaceToFaceDiscussionActivity, paramView, (nearfield_discuss.UserProfile)this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberCreateFaceToFaceDiscussionActivity.jdField_a_of_type_JavaUtilList.get(paramInt));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.selectmember.CreateFaceToFaceDiscussionActivity.GridViewAdapter
 * JD-Core Version:    0.7.0.1
 */