package com.tencent.mobileqq.activity.aio.photo;

import com.tencent.qphone.base.util.QLog;

class AIOGalleryActivity$AIOGalleryManager$1$1
  implements Runnable
{
  AIOGalleryActivity$AIOGalleryManager$1$1(AIOGalleryActivity.AIOGalleryManager.1 param1, boolean paramBoolean, long paramLong, int paramInt1, int paramInt2, int paramInt3, String paramString) {}
  
  public void run()
  {
    if (AIOGalleryActivity.AIOGalleryManager.a(this.g.a) != null)
    {
      if (QLog.isDevelopLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("IAIOImageProviderCallBack.notifyImageResult():isPart ");
        localStringBuilder.append(this.a);
        QLog.d("peak_pgjpeg", 4, localStringBuilder.toString());
      }
      ((AIOGalleryScene)AIOGalleryActivity.AIOGalleryManager.b(this.g.a)).a(this.b, this.c, this.d, this.e, this.f, this.a);
    }
    if (this.g.a.c != null) {
      ((AIOImageListScene)this.g.a.c).a(this.b, this.c, this.d, this.e, this.f);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.photo.AIOGalleryActivity.AIOGalleryManager.1.1
 * JD-Core Version:    0.7.0.1
 */