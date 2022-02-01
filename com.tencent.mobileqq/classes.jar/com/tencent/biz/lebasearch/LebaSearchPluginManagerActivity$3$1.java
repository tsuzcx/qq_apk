package com.tencent.biz.lebasearch;

import android.os.Handler;
import android.os.Message;
import android.widget.TextView;
import com.tencent.biz.lebasearch.widget.LebaSearchBounceScrollView;

class LebaSearchPluginManagerActivity$3$1
  extends Handler
{
  LebaSearchPluginManagerActivity$3$1(LebaSearchPluginManagerActivity.3 param3) {}
  
  public void handleMessage(Message paramMessage)
  {
    super.handleMessage(paramMessage);
    if (this.a.jdField_a_of_type_Int == this.a.jdField_a_of_type_ComTencentBizLebasearchLebaSearchPluginManagerActivity.jdField_a_of_type_ComTencentBizLebasearchWidgetLebaSearchBounceScrollView.getScrollY())
    {
      if ((this.a.jdField_a_of_type_Int > 0) && (!this.a.jdField_a_of_type_ComTencentBizLebasearchLebaSearchPluginManagerActivity.jdField_a_of_type_ComTencentBizLebasearchWidgetLebaSearchBounceScrollView.a()))
      {
        int i = this.a.jdField_a_of_type_Int;
        double d1 = this.a.jdField_a_of_type_ComTencentBizLebasearchLebaSearchPluginManagerActivity.jdField_b_of_type_Int;
        double d2 = LebaSearchPluginManagerActivity.jdField_a_of_type_Double;
        Double.isNaN(d1);
        double d3 = this.a.jdField_a_of_type_Int;
        Double.isNaN(d3);
        i = (int)(d1 * (1.0D - d2) + d3);
        d1 = this.a.jdField_a_of_type_Int;
        d2 = this.a.jdField_a_of_type_ComTencentBizLebasearchLebaSearchPluginManagerActivity.jdField_b_of_type_AndroidWidgetTextView.getHeight() + this.a.jdField_a_of_type_ComTencentBizLebasearchLebaSearchPluginManagerActivity.jdField_a_of_type_Float * 56.0F;
        d3 = this.a.jdField_a_of_type_ComTencentBizLebasearchLebaSearchPluginManagerActivity.jdField_b_of_type_Int;
        double d4 = LebaSearchPluginManagerActivity.jdField_a_of_type_Double;
        Double.isNaN(d3);
        Double.isNaN(d2);
        Double.isNaN(d1);
        int j = (int)(d1 - (d2 - d3 * (1.0D - d4)));
        if ((i > this.a.jdField_a_of_type_ComTencentBizLebasearchLebaSearchPluginManagerActivity.jdField_b_of_type_AndroidWidgetTextView.getHeight() + this.a.jdField_a_of_type_ComTencentBizLebasearchLebaSearchPluginManagerActivity.jdField_a_of_type_Float * 56.0F) || (i > this.a.jdField_a_of_type_ComTencentBizLebasearchLebaSearchPluginManagerActivity.jdField_b_of_type_AndroidWidgetTextView.getHeight())) {
          this.a.jdField_a_of_type_ComTencentBizLebasearchLebaSearchPluginManagerActivity.jdField_a_of_type_ComTencentBizLebasearchWidgetLebaSearchBounceScrollView.scrollBy(0, -j);
        }
      }
    }
    else
    {
      paramMessage = this.a;
      paramMessage.jdField_a_of_type_Int = paramMessage.jdField_a_of_type_ComTencentBizLebasearchLebaSearchPluginManagerActivity.jdField_a_of_type_ComTencentBizLebasearchWidgetLebaSearchBounceScrollView.getScrollY();
      this.a.jdField_a_of_type_AndroidOsHandler.sendMessageDelayed(this.a.jdField_a_of_type_AndroidOsHandler.obtainMessage(), 5L);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.biz.lebasearch.LebaSearchPluginManagerActivity.3.1
 * JD-Core Version:    0.7.0.1
 */