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
    if (JobSelectionActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityJobSelectionActivity))
    {
      paramJobSelectionActivity = ConditionSearchManager.d;
      this.jdField_a_of_type_ArrayOfJavaLangString = paramJobSelectionActivity;
      if (!JobSelectionActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityJobSelectionActivity)) {
        break label74;
      }
      paramJobSelectionActivity = ConditionSearchManager.e;
      label42:
      this.b = paramJobSelectionActivity;
      if (!JobSelectionActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityJobSelectionActivity)) {
        break label81;
      }
    }
    label74:
    label81:
    for (paramJobSelectionActivity = ConditionSearchManager.jdField_a_of_type_ArrayOfInt;; paramJobSelectionActivity = NearbyProfileUtil.b)
    {
      this.jdField_a_of_type_ArrayOfInt = paramJobSelectionActivity;
      return;
      paramJobSelectionActivity = NearbyProfileUtil.d;
      break;
      paramJobSelectionActivity = NearbyProfileUtil.e;
      break label42;
    }
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
    JobSelectionActivity.ViewHolder localViewHolder;
    if (paramView == null)
    {
      paramView = this.jdField_a_of_type_ComTencentMobileqqActivityJobSelectionActivity.getLayoutInflater().inflate(2131561281, paramViewGroup, false);
      localViewHolder = new JobSelectionActivity.ViewHolder(null);
      localViewHolder.jdField_a_of_type_ComTencentMobileqqWidgetInterestLabelTextView = ((InterestLabelTextView)paramView.findViewById(2131378870));
      localViewHolder.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131372115));
      localViewHolder.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131364719));
      paramView.setTag(localViewHolder);
    }
    for (;;)
    {
      localViewHolder = (JobSelectionActivity.ViewHolder)paramView.getTag();
      int i = this.jdField_a_of_type_ComTencentMobileqqActivityJobSelectionActivity.a(paramInt);
      Drawable localDrawable = this.jdField_a_of_type_ComTencentMobileqqActivityJobSelectionActivity.getResources().getDrawable(this.jdField_a_of_type_ArrayOfInt[i]);
      ProfileActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityJobSelectionActivity.app, localDrawable);
      localViewHolder.jdField_a_of_type_ComTencentMobileqqWidgetInterestLabelTextView.setText(this.b[i]);
      localViewHolder.jdField_a_of_type_ComTencentMobileqqWidgetInterestLabelTextView.setBackgroundDrawable(localDrawable);
      int j = AIOUtils.a(4.0F, JobSelectionActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityJobSelectionActivity).getResources());
      localViewHolder.jdField_a_of_type_ComTencentMobileqqWidgetInterestLabelTextView.setPadding(j, 0, j, 0);
      if (i < this.jdField_a_of_type_ArrayOfJavaLangString.length - 1)
      {
        localViewHolder.jdField_a_of_type_ComTencentMobileqqWidgetInterestLabelTextView.setVisibility(0);
        if ((JobSelectionActivity.b(this.jdField_a_of_type_ComTencentMobileqqActivityJobSelectionActivity)) && (i == 0)) {
          localViewHolder.jdField_a_of_type_ComTencentMobileqqWidgetInterestLabelTextView.setVisibility(4);
        }
        localViewHolder.jdField_a_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_ArrayOfJavaLangString[i]);
        if (JobSelectionActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityJobSelectionActivity) != i) {
          break label292;
        }
        localViewHolder.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
      }
      for (;;)
      {
        EventCollector.getInstance().onListGetView(paramInt, paramView, paramViewGroup, getItemId(paramInt));
        return paramView;
        localViewHolder.jdField_a_of_type_ComTencentMobileqqWidgetInterestLabelTextView.setVisibility(4);
        break;
        label292:
        localViewHolder.jdField_a_of_type_AndroidWidgetImageView.setVisibility(4);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.JobSelectionActivity.Adapter
 * JD-Core Version:    0.7.0.1
 */