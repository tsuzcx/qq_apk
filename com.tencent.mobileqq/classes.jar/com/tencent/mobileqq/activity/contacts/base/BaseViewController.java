package com.tencent.mobileqq.activity.contacts.base;

import android.app.Activity;
import android.view.View;
import com.tencent.mobileqq.activity.contacts.base.tabs.InterceptListener;
import com.tencent.mobileqq.app.FrameHelperActivity;
import com.tencent.mobileqq.app.QQAppInterface;

public abstract class BaseViewController
  implements InterceptListener
{
  protected Activity a;
  
  public BaseViewController(Activity paramActivity)
  {
    this.a = paramActivity;
  }
  
  public void a(View paramView) {}
  
  public void a(QQAppInterface paramQQAppInterface) {}
  
  public void a(boolean paramBoolean) {}
  
  public Activity b()
  {
    return this.a;
  }
  
  public void b(boolean paramBoolean)
  {
    FrameHelperActivity.c(paramBoolean ^ true);
  }
  
  public void c() {}
  
  public void d() {}
  
  public void e() {}
  
  public void f() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.contacts.base.BaseViewController
 * JD-Core Version:    0.7.0.1
 */