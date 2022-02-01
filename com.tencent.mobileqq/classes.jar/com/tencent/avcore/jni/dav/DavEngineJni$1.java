package com.tencent.avcore.jni.dav;

import com.tencent.avcore.engine.dav.IDavEventListener;
import com.tencent.avcore.util.AVCoreLog;

class DavEngineJni$1
  implements Runnable
{
  DavEngineJni$1(DavEngineJni paramDavEngineJni, int paramInt1, int paramInt2) {}
  
  public void run()
  {
    if (DavEngineJni.sDisableReOpen) {
      AVCoreLog.e("DavEngineJni", "changePreviewSize, 禁止响应重开摄像头, w[" + this.val$w + "], h[" + this.val$h + "]");
    }
    while (this.this$0.mEventListener == null) {
      return;
    }
    this.this$0.mEventListener.onChangePreviewSize(this.val$w, this.val$h);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.avcore.jni.dav.DavEngineJni.1
 * JD-Core Version:    0.7.0.1
 */