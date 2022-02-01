package com.tencent.mobileqq.activity.aio.item;

import com.tencent.mobileqq.data.MessageForShortVideo;
import com.tencent.mobileqq.wifi.FreeWifiDialogListener;

class ShortVideoItemBuilder$4
  implements FreeWifiDialogListener
{
  ShortVideoItemBuilder$4(ShortVideoItemBuilder paramShortVideoItemBuilder, MessageForShortVideo paramMessageForShortVideo, long paramLong, boolean paramBoolean) {}
  
  public void a(int paramInt)
  {
    if (paramInt == 2)
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioItemShortVideoItemBuilder.b(this.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo, this.jdField_a_of_type_Long, this.jdField_a_of_type_Boolean);
      com.tencent.mobileqq.shortvideo.ShortVideoBusiManager.jdField_a_of_type_Boolean = true;
    }
    while ((paramInt != 3) && (paramInt != 1)) {
      return;
    }
    com.tencent.mobileqq.shortvideo.ShortVideoBusiManager.jdField_a_of_type_Long = 0L;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.item.ShortVideoItemBuilder.4
 * JD-Core Version:    0.7.0.1
 */