package com.tencent.biz.pubaccount.readinjoy;

import android.view.View;
import android.view.ViewGroup;
import nia;

public class ReadInJoyChannelViewPagerController$5
  implements Runnable
{
  public ReadInJoyChannelViewPagerController$5(nia paramnia, float paramFloat, int paramInt, ViewGroup paramViewGroup, View paramView) {}
  
  public void run()
  {
    if (this.jdField_a_of_type_Float >= nia.a(this.this$0))
    {
      nia.a(this.this$0, this.jdField_a_of_type_Int);
      nia.a(this.this$0, this.jdField_a_of_type_AndroidViewViewGroup, this.jdField_a_of_type_AndroidViewView);
      return;
    }
    nia.a(this.this$0, this.jdField_a_of_type_Int - 1);
    nia.a(this.this$0, this.jdField_a_of_type_AndroidViewView, this.jdField_a_of_type_AndroidViewViewGroup);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.ReadInJoyChannelViewPagerController.5
 * JD-Core Version:    0.7.0.1
 */