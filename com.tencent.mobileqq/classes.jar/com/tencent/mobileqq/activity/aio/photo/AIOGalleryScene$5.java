package com.tencent.mobileqq.activity.aio.photo;

import com.tencent.mobileqq.activity.photo.VideoPlayControllerForAIO;
import mqq.os.MqqHandler;

class AIOGalleryScene$5
  implements Runnable
{
  AIOGalleryScene$5(AIOGalleryScene paramAIOGalleryScene) {}
  
  public void run()
  {
    this.this$0.d(false);
    this.this$0.c(false);
    if ((this.this$0.c.c() != null) && ((this.this$0.c.c().a instanceof AIOShortVideoData))) {
      AIOGalleryScene.a(this.this$0, true);
    }
    if (this.this$0.au.p())
    {
      this.this$0.E();
      this.this$0.aE.removeCallbacks(this.this$0.aA);
      this.this$0.aE.postDelayed(this.this$0.aA, 100L);
      this.this$0.aE.post(this.this$0.az);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.photo.AIOGalleryScene.5
 * JD-Core Version:    0.7.0.1
 */