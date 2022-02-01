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
  protected int a;
  protected Context a;
  protected Handler a;
  protected View a;
  protected int b = -1;
  
  public AbsUI(Context paramContext, boolean paramBoolean)
  {
    this.jdField_a_of_type_Int = -1;
    this.jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper(), this);
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    if (paramBoolean) {
      a();
    }
  }
  
  public int a()
  {
    return this.jdField_a_of_type_Int;
  }
  
  protected Context a()
  {
    return this.jdField_a_of_type_AndroidContentContext;
  }
  
  protected Resources a()
  {
    Context localContext = this.jdField_a_of_type_AndroidContentContext;
    if (localContext != null) {
      return localContext.getResources();
    }
    return null;
  }
  
  protected abstract void a();
  
  public void a(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
  }
  
  protected final void a(Runnable paramRunnable)
  {
    if (paramRunnable == null) {
      return;
    }
    this.jdField_a_of_type_AndroidOsHandler.post(paramRunnable);
  }
  
  protected abstract void b();
  
  protected final void c()
  {
    this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(1);
  }
  
  protected abstract void d();
  
  protected abstract void e();
  
  public void f()
  {
    e();
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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.subscribe.baseUI.AbsUI
 * JD-Core Version:    0.7.0.1
 */