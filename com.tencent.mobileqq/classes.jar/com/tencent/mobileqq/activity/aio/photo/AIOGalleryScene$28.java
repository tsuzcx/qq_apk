package com.tencent.mobileqq.activity.aio.photo;

class AIOGalleryScene$28
  implements Runnable
{
  AIOGalleryScene$28(AIOGalleryScene paramAIOGalleryScene) {}
  
  public void run()
  {
    if (this.this$0.ak) {
      return;
    }
    AIOGalleryScene localAIOGalleryScene = this.this$0;
    localAIOGalleryScene.aj += this.this$0.al;
    if (this.this$0.aj > 99)
    {
      localAIOGalleryScene = this.this$0;
      localAIOGalleryScene.aj = 99;
      localAIOGalleryScene.b(localAIOGalleryScene.aj);
      return;
    }
    localAIOGalleryScene = this.this$0;
    localAIOGalleryScene.b(localAIOGalleryScene.aj);
    this.this$0.N();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.photo.AIOGalleryScene.28
 * JD-Core Version:    0.7.0.1
 */