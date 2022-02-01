package com.tencent.mobileqq.activity;

import android.os.Handler;
import android.view.View;

public abstract class ChatHistoryViewBase
{
  public ChatHistoryFileActivity a;
  boolean i = true;
  
  public abstract View a();
  
  public void a(int paramInt) {}
  
  public void a(long paramLong) {}
  
  public void b() {}
  
  public abstract boolean b();
  
  public void c() {}
  
  protected boolean c()
  {
    return this.i;
  }
  
  public void d() {}
  
  public abstract void e();
  
  public abstract void f();
  
  protected void k()
  {
    this.i = false;
    new Handler().postDelayed(new ChatHistoryViewBase.1(this), 1500L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.ChatHistoryViewBase
 * JD-Core Version:    0.7.0.1
 */