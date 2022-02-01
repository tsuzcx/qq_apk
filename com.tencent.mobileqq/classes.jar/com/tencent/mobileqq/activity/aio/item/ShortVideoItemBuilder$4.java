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
      this.d.b(this.a, this.b, this.c);
      com.tencent.mobileqq.shortvideo.SVBusiUtil.b = true;
      return;
    }
    if ((paramInt == 3) || (paramInt == 1)) {
      com.tencent.mobileqq.shortvideo.SVBusiUtil.a = 0L;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.item.ShortVideoItemBuilder.4
 * JD-Core Version:    0.7.0.1
 */