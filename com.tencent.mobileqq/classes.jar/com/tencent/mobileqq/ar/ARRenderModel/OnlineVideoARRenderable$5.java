package com.tencent.mobileqq.ar.ARRenderModel;

import aouy;
import com.tencent.qphone.base.util.QLog;
import com.tencent.superplayer.api.ISuperPlayer;

public class OnlineVideoARRenderable$5
  implements Runnable
{
  public OnlineVideoARRenderable$5(aouy paramaouy) {}
  
  public void run()
  {
    try
    {
      aouy.a(this.this$0).stop();
    }
    catch (Exception localException1)
    {
      for (;;)
      {
        try
        {
          aouy.b(this.this$0, true);
          aouy.a(this.this$0, aouy.a(this.this$0));
          aouy.h(this.this$0);
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