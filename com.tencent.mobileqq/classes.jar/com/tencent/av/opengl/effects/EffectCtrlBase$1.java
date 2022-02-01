package com.tencent.av.opengl.effects;

import com.tencent.av.camera.CameraObserver;
import com.tencent.mobileqq.utils.AudioHelper;
import com.tencent.qphone.base.util.QLog;

class EffectCtrlBase$1
  extends CameraObserver
{
  EffectCtrlBase$1(EffectCtrlBase paramEffectCtrlBase) {}
  
  public void a(long paramLong, boolean paramBoolean, int paramInt)
  {
    QLog.w("EffectRenderWrapper", 1, "onAfterOpenCamera, success[" + paramBoolean + "], preSessionType[" + paramInt + "], seq[" + paramLong + "]");
    if (paramBoolean) {
      this.a.b(paramLong);
    }
  }
  
  public void b(boolean paramBoolean)
  {
    long l = AudioHelper.b();
    QLog.w("EffectRenderWrapper", 1, "onAfterReopenCamera, success[" + paramBoolean + "], seq[" + l + "]");
    if (paramBoolean) {
      this.a.b(l);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.av.opengl.effects.EffectCtrlBase.1
 * JD-Core Version:    0.7.0.1
 */