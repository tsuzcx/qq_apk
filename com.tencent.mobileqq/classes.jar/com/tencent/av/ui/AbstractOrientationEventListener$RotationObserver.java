package com.tencent.av.ui;

import android.content.ContentResolver;
import android.content.Context;
import android.database.ContentObserver;
import android.os.Handler;
import android.provider.Settings.System;
import com.tencent.av.utils.PhoneStatusTools;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qphone.base.util.QLog;

class AbstractOrientationEventListener$RotationObserver
  extends ContentObserver
{
  private ContentResolver b;
  
  public AbstractOrientationEventListener$RotationObserver(AbstractOrientationEventListener paramAbstractOrientationEventListener, Handler paramHandler)
  {
    super(paramHandler);
    paramAbstractOrientationEventListener = BaseApplicationImpl.getContext();
    if (paramAbstractOrientationEventListener == null)
    {
      QLog.e("RotationObserver", 2, "RotationObserver construct context as null, the auto-rotation listener when flat placed wont work!!");
      return;
    }
    this.b = paramAbstractOrientationEventListener.getContentResolver();
  }
  
  public void a()
  {
    ContentResolver localContentResolver = this.b;
    if (localContentResolver != null) {
      localContentResolver.registerContentObserver(Settings.System.getUriFor("accelerometer_rotation"), false, this);
    }
  }
  
  public void onChange(boolean paramBoolean)
  {
    super.onChange(paramBoolean);
    if (PhoneStatusTools.d())
    {
      QLog.d("RotationObserver", 2, "onChange onOrientationChanged when detect auto-rotation locked.");
      this.a.onOrientationChanged(-2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.ui.AbstractOrientationEventListener.RotationObserver
 * JD-Core Version:    0.7.0.1
 */