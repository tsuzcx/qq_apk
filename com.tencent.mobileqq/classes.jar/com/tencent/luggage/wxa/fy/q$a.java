package com.tencent.luggage.wxa.fy;

import android.os.Handler;
import android.os.Message;
import androidx.annotation.NonNull;

class q$a
  extends Handler
{
  @NonNull
  public final q a;
  @NonNull
  private final Handler b;
  
  public q$a(@NonNull Handler paramHandler, @NonNull q paramq)
  {
    super(paramHandler.getLooper());
    this.b = paramHandler;
    this.a = paramq;
  }
  
  public void handleMessage(Message paramMessage)
  {
    this.b.handleMessage(paramMessage);
    q.b(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.fy.q.a
 * JD-Core Version:    0.7.0.1
 */