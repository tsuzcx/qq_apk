package com.tencent.mobileqq.activity;

import android.os.Handler;
import android.view.View;

public abstract class ChatHistoryViewBase
{
  boolean C = true;
  public ChatHistoryFileActivity D;
  
  public abstract View a();
  
  public void a(int paramInt) {}
  
  public void a(long paramLong) {}
  
  public void d() {}
  
  public void e() {}
  
  public void f() {}
  
  public abstract void g();
  
  public abstract void h();
  
  public abstract boolean i();
  
  protected boolean p()
  {
    return this.C;
  }
  
  protected void q()
  {
    this.C = false;
    new Handler().postDelayed(new ChatHistoryViewBase.1(this), 1500L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.ChatHistoryViewBase
 * JD-Core Version:    0.7.0.1
 */