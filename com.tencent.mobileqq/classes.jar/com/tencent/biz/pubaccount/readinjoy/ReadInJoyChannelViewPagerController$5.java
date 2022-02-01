package com.tencent.biz.pubaccount.readinjoy;

import android.view.View;
import android.view.ViewGroup;
import ohp;

public class ReadInJoyChannelViewPagerController$5
  implements Runnable
{
  public ReadInJoyChannelViewPagerController$5(ohp paramohp, float paramFloat, int paramInt, ViewGroup paramViewGroup, View paramView) {}
  
  public void run()
  {
    if (this.jdField_a_of_type_Float >= ohp.a(this.this$0))
    {
      ohp.a(this.this$0, this.jdField_a_of_type_Int);
      ohp.a(this.this$0, this.jdField_a_of_type_AndroidViewViewGroup, this.jdField_a_of_type_AndroidViewView);
      return;
    }
    ohp.a(this.this$0, this.jdField_a_of_type_Int - 1);
    ohp.a(this.this$0, this.jdField_a_of_type_AndroidViewView, this.jdField_a_of_type_AndroidViewViewGroup);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.ReadInJoyChannelViewPagerController.5
 * JD-Core Version:    0.7.0.1
 */