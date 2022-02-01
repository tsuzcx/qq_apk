package com.tencent.biz.pubaccount.readinjoy;

import android.view.View;
import android.view.ViewGroup;

class ReadInJoyChannelViewPagerController$5
  implements Runnable
{
  ReadInJoyChannelViewPagerController$5(ReadInJoyChannelViewPagerController paramReadInJoyChannelViewPagerController, float paramFloat, int paramInt, ViewGroup paramViewGroup, View paramView) {}
  
  public void run()
  {
    if (this.jdField_a_of_type_Float >= ReadInJoyChannelViewPagerController.a(this.this$0))
    {
      ReadInJoyChannelViewPagerController.a(this.this$0, this.jdField_a_of_type_Int);
      ReadInJoyChannelViewPagerController.a(this.this$0, this.jdField_a_of_type_AndroidViewViewGroup, this.jdField_a_of_type_AndroidViewView);
      return;
    }
    ReadInJoyChannelViewPagerController.a(this.this$0, this.jdField_a_of_type_Int - 1);
    ReadInJoyChannelViewPagerController.a(this.this$0, this.jdField_a_of_type_AndroidViewView, this.jdField_a_of_type_AndroidViewViewGroup);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.ReadInJoyChannelViewPagerController.5
 * JD-Core Version:    0.7.0.1
 */