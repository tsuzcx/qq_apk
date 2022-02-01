package com.tencent.mobileqq.activity.aio.item;

import com.tencent.mobileqq.customviews.VideoProgressView;
import com.tencent.mobileqq.data.MessageForShortVideo;

class ShortVideoItemBuilder$CompressUpdateListenerImpl$2
  implements Runnable
{
  ShortVideoItemBuilder$CompressUpdateListenerImpl$2(ShortVideoItemBuilder.CompressUpdateListenerImpl paramCompressUpdateListenerImpl, MessageForShortVideo paramMessageForShortVideo, int paramInt) {}
  
  public void run()
  {
    ShortVideoItemBuilder.Holder localHolder = ShortVideoItemBuilder.a(this.c.a, this.a);
    if (localHolder != null)
    {
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append(this.a.frienduin);
      ((StringBuilder)localObject).append(this.a.uniseq);
      localObject = ((StringBuilder)localObject).toString();
      if (this.b == 1)
      {
        localHolder.c.a((String)localObject, 1.0F);
        localHolder.c.setAnimProgress(10, (String)localObject);
        localHolder.c.setVideoCompressStatus(false);
        return;
      }
      localHolder.c.setVideoCompressPercent((String)localObject, 0.0F);
      localHolder.c.setVideoCompressStatus(true);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.item.ShortVideoItemBuilder.CompressUpdateListenerImpl.2
 * JD-Core Version:    0.7.0.1
 */