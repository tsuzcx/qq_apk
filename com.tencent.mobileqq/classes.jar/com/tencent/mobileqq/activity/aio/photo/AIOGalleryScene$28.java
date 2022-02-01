package com.tencent.mobileqq.activity.aio.photo;

import ahri;

public class AIOGalleryScene$28
  implements Runnable
{
  public AIOGalleryScene$28(ahri paramahri) {}
  
  public void run()
  {
    if (this.this$0.n) {
      return;
    }
    ahri localahri = this.this$0;
    localahri.h += this.this$0.i;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.photo.AIOGalleryScene.28
 * JD-Core Version:    0.7.0.1
 */