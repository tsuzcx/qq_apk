package com.sina.weibo.sdk.b;

import android.os.Handler;
import android.os.Looper;
import java.util.concurrent.FutureTask;

public abstract class c<Params, Progress, Result>
{
  volatile int R = c.b.aa;
  final c.d<Params, Result> S = new c.2(this);
  public final FutureTask<Result> T = new c.3(this, this.S);
  int U = 5;
  Params[] V;
  Handler y = new c.1(this, Looper.getMainLooper());
  
  protected abstract Result o();
  
  protected void onPostExecute(Result paramResult) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.sina.weibo.sdk.b.c
 * JD-Core Version:    0.7.0.1
 */