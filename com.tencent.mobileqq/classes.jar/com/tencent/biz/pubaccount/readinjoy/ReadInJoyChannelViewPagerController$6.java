package com.tencent.biz.pubaccount.readinjoy;

import android.view.View;
import android.view.ViewGroup;

class ReadInJoyChannelViewPagerController$6
  implements Runnable
{
  ReadInJoyChannelViewPagerController$6(ReadInJoyChannelViewPagerController paramReadInJoyChannelViewPagerController, float paramFloat, int paramInt1, View paramView, ViewGroup paramViewGroup, int paramInt2) {}
  
  public void run()
  {
    if (this.jdField_a_of_type_Float >= 1.0F - ReadInJoyChannelViewPagerController.a(this.this$0))
    {
      ReadInJoyChannelViewPagerController.a(this.this$0, this.jdField_a_of_type_Int);
      ReadInJoyChannelViewPagerController.a(this.this$0, this.jdField_a_of_type_AndroidViewView, this.jdField_a_of_type_AndroidViewViewGroup);
      return;
    }
    ReadInJoyChannelViewPagerController.a(this.this$0, this.b);
    ReadInJoyChannelViewPagerController.a(this.this$0, this.jdField_a_of_type_AndroidViewViewGroup, this.jdField_a_of_type_AndroidViewView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.ReadInJoyChannelViewPagerController.6
 * JD-Core Version:    0.7.0.1
 */