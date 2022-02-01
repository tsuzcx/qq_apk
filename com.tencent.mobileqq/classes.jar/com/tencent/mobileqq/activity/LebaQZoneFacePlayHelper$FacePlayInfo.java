package com.tencent.mobileqq.activity;

import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.face.FaceDrawable;
import com.tencent.qphone.base.util.QLog;

class LebaQZoneFacePlayHelper$FacePlayInfo
{
  private static final Object d = new Object();
  private static FacePlayInfo e;
  private static int g = 0;
  String a;
  volatile boolean b;
  FaceDrawable c;
  private FacePlayInfo f;
  
  static FacePlayInfo a()
  {
    synchronized (d)
    {
      if (e != null)
      {
        FacePlayInfo localFacePlayInfo = e;
        e = localFacePlayInfo.f;
        localFacePlayInfo.f = null;
        g -= 1;
        return localFacePlayInfo;
      }
      return new FacePlayInfo();
    }
  }
  
  static FacePlayInfo a(String paramString, QQAppInterface paramQQAppInterface)
  {
    if (QLog.isColorLevel()) {
      QLog.d("UndealCount.Q.lebatab.lebaLebaQZoneFacePlayHelper", 2, new Object[] { "obtain FacePlayInfo:", paramString });
    }
    FacePlayInfo localFacePlayInfo = a();
    localFacePlayInfo.a = paramString;
    FaceDrawable localFaceDrawable = localFacePlayInfo.b();
    if (localFaceDrawable != null) {
      localFaceDrawable.cancel();
    }
    localFacePlayInfo.c = FaceDrawable.getUserFaceDrawable(paramQQAppInterface, String.valueOf(paramString), (byte)4);
    localFacePlayInfo.b = false;
    return localFacePlayInfo;
  }
  
  boolean a(String paramString)
  {
    return (!this.b) && (paramString != null) && (paramString.equals(this.a));
  }
  
  FaceDrawable b()
  {
    FaceDrawable localFaceDrawable2 = this.c;
    FaceDrawable localFaceDrawable1 = localFaceDrawable2;
    if (localFaceDrawable2 == null) {
      localFaceDrawable1 = null;
    }
    return localFaceDrawable1;
  }
  
  void c()
  {
    if (QLog.isColorLevel()) {
      QLog.d("UndealCount.Q.lebatab.lebaLebaQZoneFacePlayHelper", 2, new Object[] { "recycle FacePlayInfo:", this.a });
    }
    this.b = true;
    ??? = b();
    if (??? != null) {
      ((FaceDrawable)???).cancel();
    }
    this.a = null;
    synchronized (d)
    {
      if (g < 3)
      {
        this.f = e;
        e = this;
      }
      return;
    }
  }
  
  public boolean d()
  {
    return this.b;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.LebaQZoneFacePlayHelper.FacePlayInfo
 * JD-Core Version:    0.7.0.1
 */