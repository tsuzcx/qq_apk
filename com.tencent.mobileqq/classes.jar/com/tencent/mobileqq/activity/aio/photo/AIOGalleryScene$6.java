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
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onFaceUpdate uin: ");
      localStringBuilder.append(paramString1);
      localStringBuilder.append(" -- ");
      localStringBuilder.append(paramString2);
      localStringBuilder.append(" head:");
      localStringBuilder.append(paramBitmap);
      QLog.i("AIOGalleryScene", 4, localStringBuilder.toString());
    }
    if (paramBitmap != null) {
      this.a.G.setImageDrawable(new BitmapDrawable(paramBitmap));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.photo.AIOGalleryScene.6
 * JD-Core Version:    0.7.0.1
 */