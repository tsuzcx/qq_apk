package com.tencent.av.smallscreen;

import android.content.Context;
import android.view.Display;
import com.tencent.av.camera.api.ICameraManagerApi;
import com.tencent.av.ui.AbstractOrientationEventListener;
import com.tencent.qphone.base.util.QLog;

class SmallScreenVideoController$VideoOrientationEventListener
  extends AbstractOrientationEventListener
{
  public SmallScreenVideoController$VideoOrientationEventListener(SmallScreenVideoController paramSmallScreenVideoController, Context paramContext, int paramInt)
  {
    super(paramContext, paramInt);
  }
  
  public void a(int paramInt, boolean paramBoolean)
  {
    int i;
    try
    {
      i = (this.a.a.getRotation() * 90 + paramInt) % 360;
    }
    catch (Exception localException)
    {
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("onVideoOrientationChanged e = ");
        localStringBuilder.append(localException);
        QLog.e("SmallScreenVideoController", 2, localStringBuilder.toString());
      }
      i = 0;
    }
    if (this.a.t != null) {
      this.a.t.d(i);
    }
    if (this.a.u != null) {
      this.a.u.a(paramInt, paramBoolean);
    }
    if (this.a.v != null) {
      this.a.v.setRotation(paramInt);
    }
    this.a.y = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.av.smallscreen.SmallScreenVideoController.VideoOrientationEventListener
 * JD-Core Version:    0.7.0.1
 */