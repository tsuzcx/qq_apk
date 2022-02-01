package com.tencent.mobileqq.activity.weather;

import android.graphics.Bitmap;
import com.tencent.mobileqq.armap.FaceObserver;
import com.tencent.qphone.base.util.QLog;

class SessionClearFragment$3
  implements FaceObserver
{
  SessionClearFragment$3(SessionClearFragment paramSessionClearFragment) {}
  
  public void a(String paramString1, String paramString2, Bitmap paramBitmap)
  {
    if (QLog.isColorLevel()) {
      QLog.i("SessionClearFragment", 4, "mHeaderLoaderForTroop onFaceUpdate uin: " + paramString1 + " -- " + paramString2 + " head:" + paramBitmap);
    }
    SessionClearFragment.a(this.a).a(paramString1, paramBitmap, paramString2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.weather.SessionClearFragment.3
 * JD-Core Version:    0.7.0.1
 */