package com.tencent.mobileqq.activity.aio.rebuild.input.shortcutbar;

import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.ViewGroup.LayoutParams;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.helper.IHelper;
import com.tencent.mobileqq.activity.aio.navigate.NavigateBarManager;
import com.tencent.mobileqq.widget.DrawerFrame.TouchEventConsumer;
import com.tencent.widget.XEditTextEx;
import mqq.app.AppRuntime;

public abstract interface IAIOShortcutBarHelper
{
  public abstract int a();
  
  public abstract Activity a();
  
  public abstract Context a();
  
  public abstract Drawable a();
  
  public abstract ViewGroup.LayoutParams a();
  
  public abstract SessionInfo a();
  
  public abstract <T extends IHelper> T a(int paramInt);
  
  public abstract NavigateBarManager a();
  
  public abstract XEditTextEx a();
  
  public abstract AppRuntime a();
  
  public abstract void a();
  
  public abstract void a(int paramInt);
  
  public abstract void a(ViewGroup.LayoutParams paramLayoutParams);
  
  public abstract void a(DrawerFrame.TouchEventConsumer paramTouchEventConsumer);
  
  public abstract void a(String paramString);
  
  public abstract void a(String paramString1, String paramString2, boolean paramBoolean, int paramInt);
  
  public abstract void a(boolean paramBoolean);
  
  public abstract void b(DrawerFrame.TouchEventConsumer paramTouchEventConsumer);
  
  public abstract boolean b();
  
  public abstract void c();
  
  public abstract boolean c();
  
  public abstract boolean d();
  
  public abstract void e();
  
  public abstract void f();
  
  public abstract void g();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.rebuild.input.shortcutbar.IAIOShortcutBarHelper
 * JD-Core Version:    0.7.0.1
 */