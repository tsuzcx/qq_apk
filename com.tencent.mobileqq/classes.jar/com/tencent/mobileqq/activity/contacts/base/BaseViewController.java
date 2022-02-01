package com.tencent.mobileqq.activity.contacts.base;

import android.app.Activity;
import android.view.View;
import com.tencent.mobileqq.activity.contacts.base.tabs.InterceptListener;
import com.tencent.mobileqq.app.FrameHelperActivity;
import com.tencent.mobileqq.app.QQAppInterface;

public abstract class BaseViewController
  implements InterceptListener
{
  public Activity a;
  
  public BaseViewController(Activity paramActivity)
  {
    this.a = paramActivity;
  }
  
  public Activity a()
  {
    return this.a;
  }
  
  public void a(View paramView) {}
  
  public void a(QQAppInterface paramQQAppInterface) {}
  
  public void b() {}
  
  public void b(boolean paramBoolean) {}
  
  public void c() {}
  
  public void c(boolean paramBoolean)
  {
    if (!paramBoolean) {}
    for (paramBoolean = true;; paramBoolean = false)
    {
      FrameHelperActivity.c(paramBoolean);
      return;
    }
  }
  
  public void d() {}
  
  public void e() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.contacts.base.BaseViewController
 * JD-Core Version:    0.7.0.1
 */