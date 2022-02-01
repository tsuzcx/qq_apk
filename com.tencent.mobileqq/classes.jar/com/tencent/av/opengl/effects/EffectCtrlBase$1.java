package com.tencent.av.opengl.effects;

import com.tencent.av.camera.CameraObserver;
import com.tencent.av.utils.AudioHelper;
import com.tencent.qphone.base.util.QLog;

class EffectCtrlBase$1
  extends CameraObserver
{
  EffectCtrlBase$1(EffectCtrlBase paramEffectCtrlBase) {}
  
  protected void a(long paramLong, boolean paramBoolean, int paramInt)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onAfterOpenCamera, success[");
    localStringBuilder.append(paramBoolean);
    localStringBuilder.append("], preSessionType[");
    localStringBuilder.append(paramInt);
    localStringBuilder.append("], seq[");
    localStringBuilder.append(paramLong);
    localStringBuilder.append("]");
    QLog.w("EffectRenderWrapper", 1, localStringBuilder.toString());
    if (paramBoolean) {
      this.a.b(paramLong);
    }
  }
  
  protected void b(boolean paramBoolean)
  {
    long l = AudioHelper.b();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onAfterReopenCamera, success[");
    localStringBuilder.append(paramBoolean);
    localStringBuilder.append("], seq[");
    localStringBuilder.append(l);
    localStringBuilder.append("]");
    QLog.w("EffectRenderWrapper", 1, localStringBuilder.toString());
    if (paramBoolean) {
      this.a.b(l);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.opengl.effects.EffectCtrlBase.1
 * JD-Core Version:    0.7.0.1
 */