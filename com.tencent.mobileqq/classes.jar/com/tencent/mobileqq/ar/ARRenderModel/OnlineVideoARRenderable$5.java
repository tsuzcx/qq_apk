package com.tencent.mobileqq.ar.ARRenderModel;

import apio;
import com.tencent.qphone.base.util.QLog;
import com.tencent.superplayer.api.ISuperPlayer;

public class OnlineVideoARRenderable$5
  implements Runnable
{
  public OnlineVideoARRenderable$5(apio paramapio) {}
  
  public void run()
  {
    try
    {
      apio.a(this.this$0).stop();
    }
    catch (Exception localException1)
    {
      for (;;)
      {
        try
        {
          apio.b(this.this$0, true);
          apio.a(this.this$0, apio.a(this.this$0));
          apio.h(this.this$0);
          return;
        }
        catch (Exception localException2)
        {
          if (!QLog.isColorLevel()) {
            continue;
          }
          localException2.printStackTrace();
          QLog.d("AREngine_OnlineVideoARRenderable", 1, "onCompletion, exception=" + localException2.getMessage());
        }
        localException1 = localException1;
        if (QLog.isColorLevel()) {
          localException1.printStackTrace();
        }
        QLog.d("AREngine_OnlineVideoARRenderable", 1, "onCompletion, stop, exception=" + localException1.getMessage());
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ar.ARRenderModel.OnlineVideoARRenderable.5
 * JD-Core Version:    0.7.0.1
 */