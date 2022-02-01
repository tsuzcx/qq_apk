package com.tencent.biz.pubaccount.readinjoy.video;

import android.content.ContentResolver;
import android.content.Context;
import android.database.ContentObserver;
import android.os.Handler;
import android.provider.Settings.System;
import com.tencent.qphone.base.util.QLog;

class OrientationDetector$RotationObserver
  extends ContentObserver
{
  public OrientationDetector$RotationObserver(OrientationDetector paramOrientationDetector, Handler paramHandler)
  {
    super(paramHandler);
  }
  
  public ContentResolver a()
  {
    if (this.a.a() != null) {
      return this.a.a().getContentResolver();
    }
    return null;
  }
  
  public void a()
  {
    if (a() != null) {
      a().registerContentObserver(Settings.System.getUriFor("accelerometer_rotation"), false, this);
    }
  }
  
  public void b()
  {
    if (a() != null) {
      a().unregisterContentObserver(this);
    }
  }
  
  public void onChange(boolean paramBoolean)
  {
    super.onChange(paramBoolean);
    if (this.a.a() == null) {}
    for (;;)
    {
      return;
      int i = Settings.System.getInt(this.a.a().getContentResolver(), "accelerometer_rotation", -1);
      if (i == 1)
      {
        OrientationDetector.a(this.a, true);
        this.a.a(true);
      }
      while (QLog.isColorLevel())
      {
        QLog.d(OrientationDetector.a, 2, "RotationObserver.onChange() : rotateState=" + i);
        return;
        OrientationDetector.a(this.a, false);
        this.a.a(false);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.video.OrientationDetector.RotationObserver
 * JD-Core Version:    0.7.0.1
 */