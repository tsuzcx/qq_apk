package com.tencent.biz.pubaccount.weishi_new.baseui;

import android.content.Context;
import android.content.res.Resources;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.support.annotation.Nullable;
import android.support.annotation.UiThread;
import android.view.View;
import com.tencent.mobileqq.app.ThreadManager;
import mqq.os.MqqHandler;

public abstract class AbsWsUI<T>
  implements Handler.Callback, IRecyclable
{
  protected Context a;
  protected View b;
  protected int c = -1;
  protected int d = -1;
  protected T e;
  
  public AbsWsUI(Context paramContext)
  {
    this.a = paramContext;
  }
  
  private void i()
  {
    AbsWsUI.1 local1 = new AbsWsUI.1(this);
    if (Looper.myLooper() != Looper.getMainLooper())
    {
      ThreadManager.getUIHandler().post(local1);
      return;
    }
    local1.run();
  }
  
  protected abstract void a();
  
  public void a(int paramInt)
  {
    View localView = this.b;
    if (localView != null) {
      localView.setVisibility(paramInt);
    }
  }
  
  protected void a(@Nullable View paramView, boolean paramBoolean)
  {
    if (paramView != null)
    {
      int i;
      if (paramBoolean) {
        i = 0;
      } else {
        i = 8;
      }
      paramView.setVisibility(i);
    }
  }
  
  public void a(T paramT)
  {
    this.e = paramT;
    a();
    i();
  }
  
  @UiThread
  protected abstract void b();
  
  public void b(int paramInt)
  {
    this.c = paramInt;
  }
  
  public T c()
  {
    return this.e;
  }
  
  protected Context d()
  {
    return this.a;
  }
  
  protected Resources e()
  {
    Context localContext = this.a;
    if (localContext != null) {
      return localContext.getResources();
    }
    return null;
  }
  
  protected abstract void f();
  
  public void g()
  {
    f();
    b(-1);
  }
  
  public int h()
  {
    return this.c;
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    if (paramMessage.what == 1)
    {
      b();
      return true;
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.baseui.AbsWsUI
 * JD-Core Version:    0.7.0.1
 */