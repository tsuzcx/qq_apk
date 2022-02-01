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
  protected int a;
  protected Context a;
  protected View a;
  protected T a;
  protected int b = -1;
  
  public AbsWsUI(Context paramContext)
  {
    this.jdField_a_of_type_Int = -1;
    this.jdField_a_of_type_AndroidContentContext = paramContext;
  }
  
  private void e()
  {
    AbsWsUI.1 local1 = new AbsWsUI.1(this);
    if (Looper.myLooper() != Looper.getMainLooper())
    {
      ThreadManager.getUIHandler().post(local1);
      return;
    }
    local1.run();
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
  
  public View a()
  {
    return this.jdField_a_of_type_AndroidViewView;
  }
  
  public T a()
  {
    return this.jdField_a_of_type_JavaLangObject;
  }
  
  protected abstract void a();
  
  public void a(int paramInt)
  {
    View localView = this.jdField_a_of_type_AndroidViewView;
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
    this.jdField_a_of_type_JavaLangObject = paramT;
    a();
    e();
  }
  
  @UiThread
  protected abstract void b();
  
  public void b(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
  }
  
  protected abstract void c();
  
  public void d()
  {
    c();
    b(-1);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.baseui.AbsWsUI
 * JD-Core Version:    0.7.0.1
 */