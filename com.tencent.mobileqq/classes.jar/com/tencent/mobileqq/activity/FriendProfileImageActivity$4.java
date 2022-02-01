package com.tencent.mobileqq.activity;

import android.view.View;
import com.tencent.widget.AdapterView;
import com.tencent.widget.AdapterView.OnItemSelectedListener;

class FriendProfileImageActivity$4
  implements AdapterView.OnItemSelectedListener
{
  FriendProfileImageActivity$4(FriendProfileImageActivity paramFriendProfileImageActivity) {}
  
  public void onItemSelected(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    if (paramView == null) {
      return;
    }
    this.a.jdField_a_of_type_AndroidViewView = paramView;
    this.a.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileImageModel.a(paramInt);
    this.a.a(paramAdapterView, paramInt);
  }
  
  public void onNothingSelected(AdapterView<?> paramAdapterView) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.FriendProfileImageActivity.4
 * JD-Core Version:    0.7.0.1
 */