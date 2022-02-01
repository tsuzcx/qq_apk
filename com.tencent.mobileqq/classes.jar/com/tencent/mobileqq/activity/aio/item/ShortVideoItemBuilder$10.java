package com.tencent.mobileqq.activity.aio.item;

import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;

class ShortVideoItemBuilder$10
  implements Runnable
{
  ShortVideoItemBuilder$10(ShortVideoItemBuilder paramShortVideoItemBuilder, boolean paramBoolean, ShortVideoItemBuilder.Holder paramHolder) {}
  
  public void run()
  {
    if (this.a) {
      this.b.t.setVisibility(8);
    } else {
      this.b.t.setVisibility(0);
    }
    this.this$0.a(this.b);
    this.b.s.setVisibility(0);
    this.b.d.setVisibility(8);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.item.ShortVideoItemBuilder.10
 * JD-Core Version:    0.7.0.1
 */