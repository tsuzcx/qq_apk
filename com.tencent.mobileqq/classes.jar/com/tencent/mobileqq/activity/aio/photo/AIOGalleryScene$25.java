package com.tencent.mobileqq.activity.aio.photo;

import aegu;

public class AIOGalleryScene$25
  implements Runnable
{
  public AIOGalleryScene$25(aegu paramaegu) {}
  
  public void run()
  {
    if (this.this$0.n) {
      return;
    }
    aegu localaegu = this.this$0;
    localaegu.h += this.this$0.i;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.photo.AIOGalleryScene.25
 * JD-Core Version:    0.7.0.1
 */