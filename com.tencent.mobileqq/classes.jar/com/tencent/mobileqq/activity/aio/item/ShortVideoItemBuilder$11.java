package com.tencent.mobileqq.activity.aio.item;

import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.mobileqq.data.MessageForShortVideo;

class ShortVideoItemBuilder$11
  implements Runnable
{
  ShortVideoItemBuilder$11(ShortVideoItemBuilder paramShortVideoItemBuilder, MessageForShortVideo paramMessageForShortVideo) {}
  
  public void run()
  {
    ShortVideoItemBuilder.Holder localHolder = ShortVideoItemBuilder.a(this.this$0, this.a.uniseq);
    if (localHolder != null)
    {
      localHolder.s.setVisibility(8);
      localHolder.t.setVisibility(8);
      ShortVideoItemBuilder.a(this.this$0, localHolder, 2131915835);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.item.ShortVideoItemBuilder.11
 * JD-Core Version:    0.7.0.1
 */