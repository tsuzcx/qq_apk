package com.tencent.mobileqq.ar.ARRenderModel;

import com.tencent.qphone.base.util.QLog;
import com.tencent.superplayer.api.ISuperPlayer;

class OnlineVideoARRenderable$5
  implements Runnable
{
  OnlineVideoARRenderable$5(OnlineVideoARRenderable paramOnlineVideoARRenderable) {}
  
  public void run()
  {
    try
    {
      OnlineVideoARRenderable.a(this.this$0).stop();
    }
    catch (Exception localException1) {}
    try
    {
      if (QLog.isColorLevel()) {
        localException1.printStackTrace();
      }
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("onCompletion, stop, exception=");
      localStringBuilder.append(localException1.getMessage());
      QLog.d("AREngine_OnlineVideoARRenderable", 1, localStringBuilder.toString());
      OnlineVideoARRenderable.b(this.this$0, true);
      OnlineVideoARRenderable.a(this.this$0, OnlineVideoARRenderable.a(this.this$0));
      OnlineVideoARRenderable.h(this.this$0);
      return;
    }
    catch (Exception localException2)
    {
      if (QLog.isColorLevel()) {
        localException2.printStackTrace();
      }
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onCompletion, exception=");
      localStringBuilder.append(localException2.getMessage());
      QLog.d("AREngine_OnlineVideoARRenderable", 1, localStringBuilder.toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.ar.ARRenderModel.OnlineVideoARRenderable.5
 * JD-Core Version:    0.7.0.1
 */