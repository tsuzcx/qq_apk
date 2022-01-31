package com.tencent.mobileqq.activity;

import android.os.Handler;
import android.view.View;
import sgl;

public abstract class ChatHistoryViewBase
{
  public ChatHistoryFileActivity a;
  public boolean f = true;
  
  public abstract View a();
  
  public abstract void a();
  
  public void a(int paramInt) {}
  
  public abstract boolean a();
  
  public abstract void b();
  
  protected boolean b()
  {
    return this.f;
  }
  
  public void c() {}
  
  public void d() {}
  
  public void e() {}
  
  protected void k()
  {
    this.f = false;
    new Handler().postDelayed(new sgl(this), 1500L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.ChatHistoryViewBase
 * JD-Core Version:    0.7.0.1
 */