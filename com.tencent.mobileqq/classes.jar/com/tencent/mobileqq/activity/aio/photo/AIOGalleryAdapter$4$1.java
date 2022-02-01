package com.tencent.mobileqq.activity.aio.photo;

import android.text.TextUtils;

class AIOGalleryAdapter$4$1
  implements Runnable
{
  AIOGalleryAdapter$4$1(AIOGalleryAdapter.4 param4, String paramString) {}
  
  public void run()
  {
    if (!TextUtils.isEmpty(this.a))
    {
      this.b.d.a(this.b.a, this.a, null, this.b.b, false);
      if (AIOGalleryAdapter.e(this.b.d) != null) {
        AIOGalleryAdapter.e(this.b.d).a(this.b.c, this.b.b.a());
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.photo.AIOGalleryAdapter.4.1
 * JD-Core Version:    0.7.0.1
 */