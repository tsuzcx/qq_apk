package com.tencent.avcore.jni.dav;

import com.tencent.avcore.engine.dav.IDavEventListener;
import com.tencent.avcore.util.AVCoreLog;

class DavEngineJni$1
  implements Runnable
{
  DavEngineJni$1(DavEngineJni paramDavEngineJni, int paramInt1, int paramInt2) {}
  
  public void run()
  {
    if (DavEngineJni.sDisableReOpen)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("changePreviewSize, 禁止响应重开摄像头, w[");
      localStringBuilder.append(this.val$w);
      localStringBuilder.append("], h[");
      localStringBuilder.append(this.val$h);
      localStringBuilder.append("]");
      AVCoreLog.e("DavEngineJni", localStringBuilder.toString());
      return;
    }
    if (this.this$0.mEventListener != null) {
      this.this$0.mEventListener.onChangePreviewSize(this.val$w, this.val$h);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.avcore.jni.dav.DavEngineJni.1
 * JD-Core Version:    0.7.0.1
 */