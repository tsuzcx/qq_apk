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
  
  public abstract void a(int paramInt);
  
  public abstract void a(ViewGroup.LayoutParams paramLayoutParams);
  
  public abstract void a(DrawerFrame.TouchEventConsumer paramTouchEventConsumer);
  
  public abstract void a(String paramString);
  
  public abstract void a(String paramString1, String paramString2, boolean paramBoolean, int paramInt);
  
  public abstract void a(boolean paramBoolean);
  
  public abstract <T extends IHelper> T b(int paramInt);
  
  public abstract void b(DrawerFrame.TouchEventConsumer paramTouchEventConsumer);
  
  public abstract boolean c();
  
  public abstract void d();
  
  public abstract void f();
  
  public abstract SessionInfo h();
  
  public abstract AppRuntime i();
  
  public abstract Activity j();
  
  public abstract Context k();
  
  public abstract void l();
  
  public abstract void m();
  
  public abstract boolean n();
  
  public abstract NavigateBarManager o();
  
  public abstract ViewGroup.LayoutParams p();
  
  public abstract Drawable q();
  
  public abstract XEditTextEx r();
  
  public abstract void s();
  
  public abstract boolean t();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.rebuild.input.shortcutbar.IAIOShortcutBarHelper
 * JD-Core Version:    0.7.0.1
 */