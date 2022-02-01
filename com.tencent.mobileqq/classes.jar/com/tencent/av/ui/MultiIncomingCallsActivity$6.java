package com.tencent.av.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class MultiIncomingCallsActivity$6
  implements View.OnClickListener
{
  MultiIncomingCallsActivity$6(MultiIncomingCallsActivity paramMultiIncomingCallsActivity, long paramLong) {}
  
  public void onClick(View paramView)
  {
    this.jdField_a_of_type_ComTencentAvUiMultiIncomingCallsActivity.b(2);
    this.jdField_a_of_type_ComTencentAvUiMultiIncomingCallsActivity.a(this.jdField_a_of_type_Long, "onClickIgnore", true, null, -1);
    this.jdField_a_of_type_ComTencentAvUiMultiIncomingCallsActivity.b("onClickIgnore");
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.av.ui.MultiIncomingCallsActivity.6
 * JD-Core Version:    0.7.0.1
 */