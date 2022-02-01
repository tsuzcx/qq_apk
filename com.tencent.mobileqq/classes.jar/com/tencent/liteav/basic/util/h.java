package com.tencent.liteav.basic.util;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;

public class h
  extends Handler
{
  private int a;
  private boolean b = false;
  private h.a c;
  
  public h(Looper paramLooper, h.a parama)
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
      paramMessage.a();
    }
    if (this.b) {
      sendEmptyMessageDelayed(0, this.a);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.liteav.basic.util.h
 * JD-Core Version:    0.7.0.1
 */