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

public final class AIOShortcutBarContext
{
  private IAIOShortcutBarHelper a;
  
  public AIOShortcutBarContext(IAIOShortcutBarHelper paramIAIOShortcutBarHelper)
  {
    this.a = paramIAIOShortcutBarHelper;
  }
  
  public int a()
  {
    return this.a.a();
  }
  
  public <T extends IHelper> T a(int paramInt)
  {
    return this.a.b(paramInt);
  }
  
  public void a(ViewGroup.LayoutParams paramLayoutParams)
  {
    this.a.a(paramLayoutParams);
  }
  
  public void a(DrawerFrame.TouchEventConsumer paramTouchEventConsumer)
  {
    if (paramTouchEventConsumer != null) {
      this.a.a(paramTouchEventConsumer);
    }
  }
  
  public void a(String paramString)
  {
    this.a.a(paramString);
  }
  
  public void a(String paramString1, String paramString2, boolean paramBoolean, int paramInt)
  {
    this.a.a(paramString1, paramString2, paramBoolean, paramInt);
  }
  
  public void a(boolean paramBoolean)
  {
    this.a.a(paramBoolean);
  }
  
  public void b(int paramInt)
  {
    this.a.a(paramInt);
  }
  
  public void b(DrawerFrame.TouchEventConsumer paramTouchEventConsumer)
  {
    if (paramTouchEventConsumer != null) {
      this.a.b(paramTouchEventConsumer);
    }
  }
  
  public boolean b()
  {
    return this.a.c();
  }
  
  public AppRuntime c()
  {
    return this.a.i();
  }
  
  public SessionInfo d()
  {
    return this.a.h();
  }
  
  public Context e()
  {
    return this.a.k();
  }
  
  public Activity f()
  {
    return this.a.j();
  }
  
  public void g()
  {
    this.a.l();
  }
  
  public void h()
  {
    this.a.m();
  }
  
  public ViewGroup.LayoutParams i()
  {
    return this.a.p();
  }
  
  public Drawable j()
  {
    return this.a.q();
  }
  
  public XEditTextEx k()
  {
    return this.a.r();
  }
  
  public void l()
  {
    this.a.s();
  }
  
  public boolean m()
  {
    return this.a.n();
  }
  
  public NavigateBarManager n()
  {
    return this.a.o();
  }
  
  public boolean o()
  {
    return this.a.t();
  }
  
  public void p()
  {
    this.a.f();
  }
  
  public void q()
  {
    this.a.d();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.rebuild.input.shortcutbar.AIOShortcutBarContext
 * JD-Core Version:    0.7.0.1
 */