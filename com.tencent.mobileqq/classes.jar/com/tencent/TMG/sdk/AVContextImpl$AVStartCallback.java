package com.tencent.TMG.sdk;

import android.util.Log;
import com.tencent.TMG.opengl.GraphicRendererMgr;

class AVContextImpl$AVStartCallback
  implements AVCallback
{
  final AVCallback mCallback;
  final AVContext.StartParam mStartParam;
  
  AVContextImpl$AVStartCallback(AVContextImpl paramAVContextImpl, AVContext.StartParam paramStartParam, AVCallback paramAVCallback)
  {
    this.mStartParam = paramStartParam;
    this.mCallback = paramAVCallback;
    Log.e("SdkJni", "mStartParam.useSurfaceTexture = " + this.mStartParam.useSurfaceTexture);
  }
  
  public void onComplete(int paramInt, String paramString)
  {
    Log.e("SdkJni", "mStartParam.useSurfaceTexture = " + this.mStartParam.useSurfaceTexture + paramInt + paramString);
    if (paramInt == 0)
    {
      this.this$0.getAudioCtrl();
      this.this$0.getVideoCtrl();
      if (AVContextImpl.access$000(this.this$0) != null) {
        AVContextImpl.access$000(this.this$0).setUseSurfaceTexture(this.mStartParam.useSurfaceTexture);
      }
      this.this$0.setRenderMgr(GraphicRendererMgr.getInstance());
    }
    if (this.mCallback != null) {
      this.mCallback.onComplete(paramInt, paramString);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.TMG.sdk.AVContextImpl.AVStartCallback
 * JD-Core Version:    0.7.0.1
 */