package com.tencent.av.ui;

import android.content.Context;
import com.tencent.av.utils.AudioHelper;
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
    long l = AudioHelper.c();
    if (this.a.V != paramInt)
    {
      String str = this.a.i;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onVideoOrientationChanged, mRotationAngle[");
      localStringBuilder.append(this.a.V);
      localStringBuilder.append("->");
      localStringBuilder.append(paramInt);
      localStringBuilder.append("], seq[");
      localStringBuilder.append(l);
      localStringBuilder.append("], isFinishing[");
      localStringBuilder.append(this.a.isFinishing());
      localStringBuilder.append("]");
      QLog.d(str, 1, localStringBuilder.toString());
    }
    if (this.a.isFinishing()) {
      return;
    }
    if ((paramInt != 0) && (paramInt != 90) && (paramInt != 180) && (paramInt != 270))
    {
      this.a.a(l, 270, paramBoolean);
      return;
    }
    this.a.a(l, paramInt, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.ui.AVActivity.VideoOrientationEventListener
 * JD-Core Version:    0.7.0.1
 */