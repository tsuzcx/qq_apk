package com.tencent.mobileqq.activity.aio.item;

import com.tencent.mobileqq.data.MessageForShortVideo;
import com.tencent.mobileqq.wifi.FreeWifiHelper.FreeWifiDialogListener;

class ShortVideoItemBuilder$4
  implements FreeWifiHelper.FreeWifiDialogListener
{
  ShortVideoItemBuilder$4(ShortVideoItemBuilder paramShortVideoItemBuilder, MessageForShortVideo paramMessageForShortVideo, long paramLong, boolean paramBoolean) {}
  
  public void a(int paramInt)
  {
    if (paramInt == 2)
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioItemShortVideoItemBuilder.b(this.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo, this.jdField_a_of_type_Long, this.jdField_a_of_type_Boolean);
      com.tencent.mobileqq.shortvideo.SVBusiUtil.jdField_a_of_type_Boolean = true;
      return;
    }
    if ((paramInt == 3) || (paramInt == 1)) {
      com.tencent.mobileqq.shortvideo.SVBusiUtil.jdField_a_of_type_Long = 0L;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.item.ShortVideoItemBuilder.4
 * JD-Core Version:    0.7.0.1
 */