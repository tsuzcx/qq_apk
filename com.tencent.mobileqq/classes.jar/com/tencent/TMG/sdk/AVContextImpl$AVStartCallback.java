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
    paramAVContextImpl = new StringBuilder();
    paramAVContextImpl.append("mStartParam.useSurfaceTexture = ");
    paramAVContextImpl.append(this.mStartParam.useSurfaceTexture);
    Log.e("SdkJni", paramAVContextImpl.toString());
  }
  
  public void onComplete(int paramInt, String paramString)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("mStartParam.useSurfaceTexture = ");
    ((StringBuilder)localObject).append(this.mStartParam.useSurfaceTexture);
    ((StringBuilder)localObject).append(paramInt);
    ((StringBuilder)localObject).append(paramString);
    Log.e("SdkJni", ((StringBuilder)localObject).toString());
    if (paramInt == 0)
    {
      this.this$0.getAudioCtrl();
      this.this$0.getVideoCtrl();
      if (AVContextImpl.access$000(this.this$0) != null) {
        AVContextImpl.access$000(this.this$0).setUseSurfaceTexture(this.mStartParam.useSurfaceTexture);
      }
      this.this$0.setRenderMgr(GraphicRendererMgr.getInstance());
    }
    localObject = this.mCallback;
    if (localObject != null) {
      ((AVCallback)localObject).onComplete(paramInt, paramString);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.TMG.sdk.AVContextImpl.AVStartCallback
 * JD-Core Version:    0.7.0.1
 */