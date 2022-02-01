package com.tencent.mobileqq.activity.aio.photo;

import com.tencent.common.galleryactivity.AbstractImageListScene;

class AIOGalleryActivity$AIOGalleryManager$1$3
  implements Runnable
{
  AIOGalleryActivity$AIOGalleryManager$1$3(AIOGalleryActivity.AIOGalleryManager.1 param1, AIORichMediaData[] paramArrayOfAIORichMediaData, int paramInt) {}
  
  public void run()
  {
    if (this.a != null)
    {
      AIOImageListModel localAIOImageListModel = (AIOImageListModel)AIOGalleryActivity.AIOGalleryManager.e(this.c.a);
      if (localAIOImageListModel.a(this.a, this.b))
      {
        if (AIOGalleryActivity.AIOGalleryManager.f(this.c.a) != null) {
          ((AIOGalleryScene)AIOGalleryActivity.AIOGalleryManager.g(this.c.a)).K();
        }
      }
      else if ((this.c.a.c != null) && (this.c.a.e() == this.c.a.c))
      {
        localAIOImageListModel.h();
        if (AIOGalleryActivity.AIOGalleryManager.h(this.c.a) != null) {
          ((AIOGalleryScene)AIOGalleryActivity.AIOGalleryManager.i(this.c.a)).K();
        }
      }
    }
    if (this.c.a.c != null) {
      this.c.a.c.l();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.photo.AIOGalleryActivity.AIOGalleryManager.1.3
 * JD-Core Version:    0.7.0.1
 */