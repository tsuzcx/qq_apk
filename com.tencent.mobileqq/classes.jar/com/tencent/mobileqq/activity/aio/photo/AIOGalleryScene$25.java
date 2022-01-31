package com.tencent.mobileqq.activity.aio.photo;

import aghx;

public class AIOGalleryScene$25
  implements Runnable
{
  public AIOGalleryScene$25(aghx paramaghx) {}
  
  public void run()
  {
    if (this.this$0.n) {
      return;
    }
    aghx localaghx = this.this$0;
    localaghx.h += this.this$0.i;
    if (this.this$0.h > 99)
    {
      this.this$0.h = 99;
      this.this$0.d(this.this$0.h);
      return;
    }
    this.this$0.d(this.this$0.h);
    this.this$0.A();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.photo.AIOGalleryScene.25
 * JD-Core Version:    0.7.0.1
 */