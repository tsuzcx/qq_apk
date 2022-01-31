package com.tencent.biz.pubaccount.readinjoy;

import android.view.View;
import android.view.ViewGroup;
import nwm;

public class ReadInJoyChannelViewPagerController$5
  implements Runnable
{
  public ReadInJoyChannelViewPagerController$5(nwm paramnwm, float paramFloat, int paramInt, ViewGroup paramViewGroup, View paramView) {}
  
  public void run()
  {
    if (this.jdField_a_of_type_Float >= nwm.a(this.this$0))
    {
      nwm.a(this.this$0, this.jdField_a_of_type_Int);
      nwm.a(this.this$0, this.jdField_a_of_type_AndroidViewViewGroup, this.jdField_a_of_type_AndroidViewView);
      return;
    }
    nwm.a(this.this$0, this.jdField_a_of_type_Int - 1);
    nwm.a(this.this$0, this.jdField_a_of_type_AndroidViewView, this.jdField_a_of_type_AndroidViewViewGroup);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.ReadInJoyChannelViewPagerController.5
 * JD-Core Version:    0.7.0.1
 */