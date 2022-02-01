package com.tencent.liteav.basic.util;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;

public class j
  extends Handler
{
  private int a;
  private boolean b = false;
  private j.a c;
  
  public j(Looper paramLooper, j.a parama)
  {
    super(paramLooper);
    this.c = parama;
  }
  
  public void a()
  {
    while (hasMessages(0)) {
      removeMessages(0);
    }
    this.b = false;
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    a();
    this.a = paramInt2;
    this.b = true;
    sendEmptyMessageDelayed(0, paramInt1);
  }
  
  public void handleMessage(Message paramMessage)
  {
    paramMessage = this.c;
    if (paramMessage != null) {
      paramMessage.onTimeout();
    }
    if (this.b) {
      sendEmptyMessageDelayed(0, this.a);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.liteav.basic.util.j
 * JD-Core Version:    0.7.0.1
 */