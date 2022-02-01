package com.tencent.mobileqq.activity.aio.photo;

import com.tencent.mobileqq.filemanager.util.FMDialogUtil.FMDialogInterface;
import com.tencent.widget.Gallery;

class AIOGalleryScene$1
  implements FMDialogUtil.FMDialogInterface
{
  AIOGalleryScene$1(AIOGalleryScene paramAIOGalleryScene) {}
  
  public void a()
  {
    try
    {
      this.a.c(true);
      this.a.V.a(this.a.J.a, this.a.J.b, 20);
      AIOGalleryScene.a(this.a).enableDoubleTap(true);
      AIOGalleryScene.b(this.a).enableScaleGesture(true);
      return;
    }
    catch (Exception localException) {}
  }
  
  public void b()
  {
    this.a.c(false);
    this.a.d(true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.photo.AIOGalleryScene.1
 * JD-Core Version:    0.7.0.1
 */