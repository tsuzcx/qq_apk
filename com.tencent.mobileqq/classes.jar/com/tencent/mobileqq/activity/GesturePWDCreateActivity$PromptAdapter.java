package com.tencent.mobileqq.activity;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class GesturePWDCreateActivity$PromptAdapter
  extends BaseAdapter
{
  private LayoutInflater jdField_a_of_type_AndroidViewLayoutInflater;
  
  public int getCount()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityGesturePWDCreateActivity.a != null) {
      return this.jdField_a_of_type_ComTencentMobileqqActivityGesturePWDCreateActivity.a.length;
    }
    return 0;
  }
  
  public Object getItem(int paramInt)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityGesturePWDCreateActivity.a != null) && (paramInt < this.jdField_a_of_type_ComTencentMobileqqActivityGesturePWDCreateActivity.a.length) && (paramInt >= 0)) {
      return Integer.valueOf(this.jdField_a_of_type_ComTencentMobileqqActivityGesturePWDCreateActivity.a[paramInt]);
    }
    return null;
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    if (paramView == null) {
      paramView = this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2131559324, null);
    }
    for (;;)
    {
      View localView = paramView.findViewById(2131367855);
      if ((this.jdField_a_of_type_ComTencentMobileqqActivityGesturePWDCreateActivity.a != null) && (paramInt >= 0) && (paramInt < this.jdField_a_of_type_ComTencentMobileqqActivityGesturePWDCreateActivity.a.length) && (this.jdField_a_of_type_ComTencentMobileqqActivityGesturePWDCreateActivity.a[paramInt] > 0)) {
        localView.setBackgroundResource(2130845376);
      }
      for (;;)
      {
        EventCollector.getInstance().onListGetView(paramInt, paramView, paramViewGroup, getItemId(paramInt));
        return paramView;
        localView.setBackgroundResource(2130851162);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.GesturePWDCreateActivity.PromptAdapter
 * JD-Core Version:    0.7.0.1
 */