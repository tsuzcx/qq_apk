package com.tencent.mobileqq.activity;

import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.app.ConditionSearchManager;
import com.tencent.mobileqq.profilecard.base.utils.ProfileCardUtils;
import com.tencent.mobileqq.util.NearbyProfileUtil;
import com.tencent.mobileqq.widget.InterestLabelTextView;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class JobSelectionActivity$Adapter
  extends BaseAdapter
{
  private int[] jdField_a_of_type_ArrayOfInt;
  private String[] jdField_a_of_type_ArrayOfJavaLangString;
  private String[] b;
  
  private JobSelectionActivity$Adapter(JobSelectionActivity paramJobSelectionActivity)
  {
    if (JobSelectionActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityJobSelectionActivity)) {
      paramJobSelectionActivity = ConditionSearchManager.d;
    } else {
      paramJobSelectionActivity = NearbyProfileUtil.d;
    }
    this.jdField_a_of_type_ArrayOfJavaLangString = paramJobSelectionActivity;
    if (JobSelectionActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityJobSelectionActivity)) {
      paramJobSelectionActivity = ConditionSearchManager.e;
    } else {
      paramJobSelectionActivity = NearbyProfileUtil.e;
    }
    this.b = paramJobSelectionActivity;
    if (JobSelectionActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityJobSelectionActivity)) {
      paramJobSelectionActivity = ConditionSearchManager.jdField_a_of_type_ArrayOfInt;
    } else {
      paramJobSelectionActivity = NearbyProfileUtil.b;
    }
    this.jdField_a_of_type_ArrayOfInt = paramJobSelectionActivity;
  }
  
  public int getCount()
  {
    if (JobSelectionActivity.b(this.jdField_a_of_type_ComTencentMobileqqActivityJobSelectionActivity)) {
      return this.jdField_a_of_type_ArrayOfJavaLangString.length - 2;
    }
    return this.jdField_a_of_type_ArrayOfJavaLangString.length - 1;
  }
  
  public Object getItem(int paramInt)
  {
    paramInt = this.jdField_a_of_type_ComTencentMobileqqActivityJobSelectionActivity.a(paramInt);
    return this.jdField_a_of_type_ArrayOfJavaLangString[paramInt];
  }
  
  public long getItemId(int paramInt)
  {
    return 0L;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    View localView = paramView;
    if (paramView == null)
    {
      localView = this.jdField_a_of_type_ComTencentMobileqqActivityJobSelectionActivity.getLayoutInflater().inflate(2131561124, paramViewGroup, false);
      paramView = new JobSelectionActivity.ViewHolder(null);
      paramView.jdField_a_of_type_ComTencentMobileqqWidgetInterestLabelTextView = ((InterestLabelTextView)localView.findViewById(2131378259));
      paramView.jdField_a_of_type_AndroidWidgetTextView = ((TextView)localView.findViewById(2131371697));
      paramView.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)localView.findViewById(2131364606));
      localView.setTag(paramView);
    }
    paramView = (JobSelectionActivity.ViewHolder)localView.getTag();
    int i = this.jdField_a_of_type_ComTencentMobileqqActivityJobSelectionActivity.a(paramInt);
    Drawable localDrawable = this.jdField_a_of_type_ComTencentMobileqqActivityJobSelectionActivity.getResources().getDrawable(this.jdField_a_of_type_ArrayOfInt[i]);
    ProfileCardUtils.setNightModeFilterForDrawable(this.jdField_a_of_type_ComTencentMobileqqActivityJobSelectionActivity.app, localDrawable);
    paramView.jdField_a_of_type_ComTencentMobileqqWidgetInterestLabelTextView.setText(this.b[i]);
    paramView.jdField_a_of_type_ComTencentMobileqqWidgetInterestLabelTextView.setBackgroundDrawable(localDrawable);
    int j = AIOUtils.b(4.0F, JobSelectionActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityJobSelectionActivity).getResources());
    paramView.jdField_a_of_type_ComTencentMobileqqWidgetInterestLabelTextView.setPadding(j, 0, j, 0);
    if (i < this.jdField_a_of_type_ArrayOfJavaLangString.length - 1) {
      paramView.jdField_a_of_type_ComTencentMobileqqWidgetInterestLabelTextView.setVisibility(0);
    } else {
      paramView.jdField_a_of_type_ComTencentMobileqqWidgetInterestLabelTextView.setVisibility(4);
    }
    if ((JobSelectionActivity.b(this.jdField_a_of_type_ComTencentMobileqqActivityJobSelectionActivity)) && (i == 0)) {
      paramView.jdField_a_of_type_ComTencentMobileqqWidgetInterestLabelTextView.setVisibility(4);
    }
    paramView.jdField_a_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_ArrayOfJavaLangString[i]);
    if (JobSelectionActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityJobSelectionActivity) == i) {
      paramView.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
    } else {
      paramView.jdField_a_of_type_AndroidWidgetImageView.setVisibility(4);
    }
    EventCollector.getInstance().onListGetView(paramInt, localView, paramViewGroup, getItemId(paramInt));
    return localView;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.JobSelectionActivity.Adapter
 * JD-Core Version:    0.7.0.1
 */