package com.tencent.mobileqq.activity.aio.item;

import android.os.Handler;
import com.tencent.mobileqq.data.MessageForShortVideo;

class ShortVideoRealItemBuilder$10
  implements Runnable
{
  ShortVideoRealItemBuilder$10(ShortVideoRealItemBuilder paramShortVideoRealItemBuilder, boolean paramBoolean1, ShortVideoRealItemBuilder.Holder paramHolder, MessageForShortVideo paramMessageForShortVideo, boolean paramBoolean2) {}
  
  public void run()
  {
    if ((this.a) && (this.b != null) && (this.c.progressTask == null))
    {
      this.c.progressTask = new ShortVideoRealItemBuilder.10.1(this);
      ShortVideoRealItemBuilder.a(this.this$0).removeCallbacks(this.c.progressTask);
      ShortVideoRealItemBuilder.a(this.this$0).post(this.c.progressTask);
    }
    if (this.d) {
      ShortVideoRealItemBuilder.b(this.this$0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.item.ShortVideoRealItemBuilder.10
 * JD-Core Version:    0.7.0.1
 */