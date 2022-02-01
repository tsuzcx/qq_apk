package com.tencent.av.ui;

import android.content.Context;
import com.tencent.mobileqq.utils.AudioHelper;
import com.tencent.qphone.base.util.QLog;

class AVActivity$VideoOrientationEventListener
  extends AbstractOrientationEventListener
{
  public AVActivity$VideoOrientationEventListener(AVActivity paramAVActivity, Context paramContext, int paramInt)
  {
    super(paramContext, paramInt);
  }
  
  public void a(int paramInt, boolean paramBoolean)
  {
    long l = AudioHelper.b();
    if (this.a.h != paramInt) {
      QLog.d(this.a.b, 1, "onVideoOrientationChanged, mRotationAngle[" + this.a.h + "->" + paramInt + "], seq[" + l + "], isFinishing[" + this.a.isFinishing() + "]");
    }
    if (this.a.isFinishing()) {
      return;
    }
    switch (paramInt)
    {
    default: 
      this.a.a(l, 270, paramBoolean);
      return;
    }
    this.a.a(l, paramInt, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.av.ui.AVActivity.VideoOrientationEventListener
 * JD-Core Version:    0.7.0.1
 */