package com.tencent.android.gldrawable.api.base;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import com.tencent.android.gldrawable.api.GLDrawableApi;
import com.tencent.android.gldrawable.api.IConfigStub;

class AutoReleaseThreadHandler$AutoReleasHandler
  extends Handler
{
  private static final int WHAT_AUTO_QUIT = 1;
  private final HandlerThread decodingThread;
  private boolean isAlive = true;
  
  AutoReleaseThreadHandler$AutoReleasHandler(HandlerThread paramHandlerThread)
  {
    super(paramHandlerThread.getLooper());
    this.decodingThread = paramHandlerThread;
    GLDrawableApi.config().log("AutoReleaseHandler start thread", null);
  }
  
  public void handleMessage(Message paramMessage)
  {
    if (paramMessage.what != 1) {
      return;
    }
    if (this.isAlive)
    {
      this.isAlive = false;
      sendEmptyMessageDelayed(1, 1000L);
      GLDrawableApi.config().log("AutoReleaseHandler wait stop thread", null);
      return;
    }
    this.decodingThread.quit();
    GLDrawableApi.config().log("AutoReleaseHandler stop thread", null);
  }
  
  public void waitQuit()
  {
    removeMessages(1);
    sendEmptyMessageDelayed(1, 2000L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.android.gldrawable.api.base.AutoReleaseThreadHandler.AutoReleasHandler
 * JD-Core Version:    0.7.0.1
 */