package com.tencent.biz.subscribe.baseUI;

import android.content.Context;
import android.content.res.Resources;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.view.View;

public abstract class AbsUI<T>
  implements Handler.Callback
{
  protected Context a;
  protected View b;
  protected int c = -1;
  protected int d = -1;
  protected Handler e = new Handler(Looper.getMainLooper(), this);
  
  public AbsUI(Context paramContext, boolean paramBoolean)
  {
    this.a = paramContext;
    if (paramBoolean) {
      a();
    }
  }
  
  protected abstract void a();
  
  public void a(int paramInt)
  {
    this.c = paramInt;
  }
  
  protected final void a(Runnable paramRunnable)
  {
    if (paramRunnable == null) {
      return;
    }
    this.e.post(paramRunnable);
  }
  
  protected abstract void b();
  
  protected final void c()
  {
    this.e.sendEmptyMessage(1);
  }
  
  protected abstract void d();
  
  protected Context e()
  {
    return this.a;
  }
  
  protected Resources f()
  {
    Context localContext = this.a;
    if (localContext != null) {
      return localContext.getResources();
    }
    return null;
  }
  
  protected abstract void g();
  
  public void h()
  {
    g();
    a(-1);
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    if (paramMessage.what != 1) {
      return false;
    }
    d();
    return true;
  }
  
  public int i()
  {
    return this.c;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.subscribe.baseUI.AbsUI
 * JD-Core Version:    0.7.0.1
 */