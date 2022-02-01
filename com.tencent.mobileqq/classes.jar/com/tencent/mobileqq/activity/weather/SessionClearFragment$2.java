package com.tencent.mobileqq.activity.weather;

import android.graphics.Bitmap;
import com.tencent.mobileqq.armap.FaceObserver;
import com.tencent.qphone.base.util.QLog;

class SessionClearFragment$2
  implements FaceObserver
{
  SessionClearFragment$2(SessionClearFragment paramSessionClearFragment) {}
  
  public void a(String paramString1, String paramString2, Bitmap paramBitmap)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("mHeaderLoaderForUser onFaceUpdate uin: ");
      localStringBuilder.append(paramString1);
      localStringBuilder.append(" -- ");
      localStringBuilder.append(paramString2);
      localStringBuilder.append(" head:");
      localStringBuilder.append(paramBitmap);
      QLog.i("SessionClearFragment", 4, localStringBuilder.toString());
    }
    SessionClearFragment.a(this.a).a(paramString1, paramBitmap, paramString2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.activity.weather.SessionClearFragment.2
 * JD-Core Version:    0.7.0.1
 */