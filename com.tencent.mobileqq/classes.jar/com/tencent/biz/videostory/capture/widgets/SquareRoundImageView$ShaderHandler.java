package com.tencent.biz.videostory.capture.widgets;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import java.lang.ref.WeakReference;

class SquareRoundImageView$ShaderHandler
  extends Handler
{
  private WeakReference<SquareRoundImageView> a;
  
  private SquareRoundImageView$ShaderHandler(Looper paramLooper, SquareRoundImageView paramSquareRoundImageView)
  {
    super(paramLooper);
    this.a = new WeakReference(paramSquareRoundImageView);
  }
  
  public void handleMessage(Message paramMessage)
  {
    if (paramMessage.what == 1)
    {
      paramMessage = (SquareRoundImageView)this.a.get();
      if (paramMessage != null) {
        SquareRoundImageView.a(paramMessage);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.videostory.capture.widgets.SquareRoundImageView.ShaderHandler
 * JD-Core Version:    0.7.0.1
 */