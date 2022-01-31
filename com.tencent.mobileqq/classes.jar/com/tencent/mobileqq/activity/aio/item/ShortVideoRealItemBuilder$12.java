package com.tencent.mobileqq.activity.aio.item;

import agbi;
import android.os.Handler;
import com.tencent.mobileqq.data.MessageForShortVideo;

class ShortVideoRealItemBuilder$12
  implements Runnable
{
  ShortVideoRealItemBuilder$12(ShortVideoRealItemBuilder paramShortVideoRealItemBuilder, boolean paramBoolean1, agbi paramagbi, MessageForShortVideo paramMessageForShortVideo, boolean paramBoolean2) {}
  
  public void run()
  {
    if ((this.jdField_a_of_type_Boolean) && (this.jdField_a_of_type_Agbi != null) && (this.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo.progressTask == null))
    {
      this.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo.progressTask = new ShortVideoRealItemBuilder.12.1(this);
      ShortVideoRealItemBuilder.a(this.this$0).removeCallbacks(this.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo.progressTask);
      ShortVideoRealItemBuilder.a(this.this$0).post(this.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo.progressTask);
    }
    if (this.b) {
      ShortVideoRealItemBuilder.a(this.this$0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.item.ShortVideoRealItemBuilder.12
 * JD-Core Version:    0.7.0.1
 */