package com.tencent.av.core;

import com.tencent.qphone.base.util.QLog;
import lns;

class VcControllerImpl$2
  implements Runnable
{
  VcControllerImpl$2(VcControllerImpl paramVcControllerImpl, int paramInt1, int paramInt2) {}
  
  public void run()
  {
    if (VcControllerImpl.mDisableReOpen) {
      QLog.w("VcControllerImpl", 1, "changePreviewSize, 禁止响应重开摄像头, w[" + this.a + "], h[" + this.b + "]");
    }
    while (this.this$0.mEventListener == null) {
      return;
    }
    this.this$0.mEventListener.a(this.a, this.b);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.av.core.VcControllerImpl.2
 * JD-Core Version:    0.7.0.1
 */