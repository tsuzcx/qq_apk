package com.tencent.device.msg.activities;

import com.tencent.device.msg.data.MessageForDevLittleVideo;
import com.tencent.mobileqq.shortvideo.SVBusiUtil;
import com.tencent.mobileqq.shortvideo.ShortVideoBusiManager;
import com.tencent.mobileqq.shortvideo.ShortVideoReq;

class DevLittleVideoItemBuilder$5
  implements Runnable
{
  DevLittleVideoItemBuilder$5(DevLittleVideoItemBuilder paramDevLittleVideoItemBuilder, MessageForDevLittleVideo paramMessageForDevLittleVideo) {}
  
  public void run()
  {
    ShortVideoReq localShortVideoReq = SVBusiUtil.a(0, 4);
    localShortVideoReq.a(ShortVideoBusiManager.a(this.a, localShortVideoReq));
    ShortVideoBusiManager.a(localShortVideoReq, this.this$0.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.device.msg.activities.DevLittleVideoItemBuilder.5
 * JD-Core Version:    0.7.0.1
 */