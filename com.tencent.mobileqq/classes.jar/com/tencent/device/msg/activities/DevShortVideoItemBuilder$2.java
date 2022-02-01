package com.tencent.device.msg.activities;

import com.tencent.mobileqq.data.MessageForShortVideo;
import com.tencent.mobileqq.shortvideo.ShortVideoBusiManager;
import com.tencent.mobileqq.shortvideo.ShortVideoReq;

class DevShortVideoItemBuilder$2
  implements Runnable
{
  DevShortVideoItemBuilder$2(DevShortVideoItemBuilder paramDevShortVideoItemBuilder, MessageForShortVideo paramMessageForShortVideo) {}
  
  public void run()
  {
    ShortVideoReq localShortVideoReq = ShortVideoBusiManager.a(1, this.this$0.c);
    localShortVideoReq.a(ShortVideoBusiManager.a(this.this$0.c, this.a, localShortVideoReq));
    ShortVideoBusiManager.a(localShortVideoReq, this.this$0.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.device.msg.activities.DevShortVideoItemBuilder.2
 * JD-Core Version:    0.7.0.1
 */