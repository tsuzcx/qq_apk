package com.tencent.biz.pubaccount.readinjoy;

import android.view.View;
import android.view.ViewGroup;
import ntk;

public class ReadInJoyChannelViewPagerController$5
  implements Runnable
{
  public ReadInJoyChannelViewPagerController$5(ntk paramntk, float paramFloat, int paramInt, ViewGroup paramViewGroup, View paramView) {}
  
  public void run()
  {
    if (this.jdField_a_of_type_Float >= ntk.a(this.this$0))
    {
      ntk.a(this.this$0, this.jdField_a_of_type_Int);
      ntk.a(this.this$0, this.jdField_a_of_type_AndroidViewViewGroup, this.jdField_a_of_type_AndroidViewView);
      return;
    }
    ntk.a(this.this$0, this.jdField_a_of_type_Int - 1);
    ntk.a(this.this$0, this.jdField_a_of_type_AndroidViewView, this.jdField_a_of_type_AndroidViewViewGroup);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.ReadInJoyChannelViewPagerController.5
 * JD-Core Version:    0.7.0.1
 */