package com.tencent.mobileqq.activity.aio.photo;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import com.tencent.mobileqq.armap.FaceObserver;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.RecentDynamicAvatarView;

class AIOGalleryScene$6
  implements FaceObserver
{
  public void a(String paramString1, String paramString2, Bitmap paramBitmap)
  {
    if (QLog.isColorLevel()) {
      QLog.i("AIOGalleryScene", 4, "onFaceUpdate uin: " + paramString1 + " -- " + paramString2 + " head:" + paramBitmap);
    }
    if (paramBitmap != null) {
      this.a.a.setImageDrawable(new BitmapDrawable(paramBitmap));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.photo.AIOGalleryScene.6
 * JD-Core Version:    0.7.0.1
 */