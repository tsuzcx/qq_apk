package com.tencent.luggage.wxa.am;

import android.os.Handler;
import android.os.Message;

final class t$e
  extends Handler
  implements Runnable
{
  private final t.d a;
  
  public t$e(t.d paramd)
  {
    this.a = paramd;
  }
  
  public void handleMessage(Message paramMessage)
  {
    this.a.g();
  }
  
  public void run()
  {
    sendEmptyMessage(0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.am.t.e
 * JD-Core Version:    0.7.0.1
 */