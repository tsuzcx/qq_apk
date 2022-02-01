package com.tencent.mobileqq.activity.aio.item;

import android.os.Handler;
import com.tencent.mobileqq.data.MessageForShortVideo;

class ShortVideoRealItemBuilder$10
  implements Runnable
{
  ShortVideoRealItemBuilder$10(ShortVideoRealItemBuilder paramShortVideoRealItemBuilder, boolean paramBoolean1, ShortVideoRealItemBuilder.Holder paramHolder, MessageForShortVideo paramMessageForShortVideo, boolean paramBoolean2) {}
  
  public void run()
  {
    if ((this.jdField_a_of_type_Boolean) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioItemShortVideoRealItemBuilder$Holder != null) && (this.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo.progressTask == null))
    {
      this.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo.progressTask = new ShortVideoRealItemBuilder.10.1(this);
      ShortVideoRealItemBuilder.a(this.this$0).removeCallbacks(this.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo.progressTask);
      ShortVideoRealItemBuilder.a(this.this$0).post(this.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo.progressTask);
    }
    if (this.b) {
      ShortVideoRealItemBuilder.a(this.this$0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.item.ShortVideoRealItemBuilder.10
 * JD-Core Version:    0.7.0.1
 */