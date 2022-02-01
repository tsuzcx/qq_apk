package com.tencent.mobileqq.activity.aio.photo;

class AIOGalleryScene$28
  implements Runnable
{
  AIOGalleryScene$28(AIOGalleryScene paramAIOGalleryScene) {}
  
  public void run()
  {
    if (this.this$0.n) {
      return;
    }
    AIOGalleryScene localAIOGalleryScene = this.this$0;
    localAIOGalleryScene.h += this.this$0.i;
    if (this.this$0.h > 99)
    {
      localAIOGalleryScene = this.this$0;
      localAIOGalleryScene.h = 99;
      localAIOGalleryScene.b(localAIOGalleryScene.h);
      return;
    }
    localAIOGalleryScene = this.this$0;
    localAIOGalleryScene.b(localAIOGalleryScene.h);
    this.this$0.A();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.photo.AIOGalleryScene.28
 * JD-Core Version:    0.7.0.1
 */