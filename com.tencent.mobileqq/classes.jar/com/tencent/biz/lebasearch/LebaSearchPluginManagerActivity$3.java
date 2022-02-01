package com.tencent.biz.lebasearch;

import android.os.Handler;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;

class LebaSearchPluginManagerActivity$3
  implements View.OnTouchListener
{
  int jdField_a_of_type_Int = 0;
  Handler jdField_a_of_type_AndroidOsHandler = new LebaSearchPluginManagerActivity.3.1(this);
  
  LebaSearchPluginManagerActivity$3(LebaSearchPluginManagerActivity paramLebaSearchPluginManagerActivity) {}
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    if (paramMotionEvent.getAction() == 1)
    {
      paramView = this.jdField_a_of_type_AndroidOsHandler;
      paramView.sendMessageDelayed(paramView.obtainMessage(), 5L);
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.biz.lebasearch.LebaSearchPluginManagerActivity.3
 * JD-Core Version:    0.7.0.1
 */