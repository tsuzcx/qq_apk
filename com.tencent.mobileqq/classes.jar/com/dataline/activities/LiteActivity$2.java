package com.dataline.activities;

import android.view.View;
import com.tencent.mobileqq.widget.QQBlur.BackgroundViewDirtyListener;
import com.tencent.widget.XListView;

class LiteActivity$2
  implements QQBlur.BackgroundViewDirtyListener
{
  private View jdField_a_of_type_AndroidViewView = this.jdField_a_of_type_ComDatalineActivitiesLiteActivity.findViewById(2131373454);
  
  LiteActivity$2(LiteActivity paramLiteActivity) {}
  
  public boolean isDirty()
  {
    return (this.jdField_a_of_type_ComDatalineActivitiesLiteActivity.a.isDirty()) || (this.jdField_a_of_type_AndroidViewView.isDirty());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.dataline.activities.LiteActivity.2
 * JD-Core Version:    0.7.0.1
 */