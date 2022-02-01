package com.tencent.mobileqq.activity.aio.drawer;

import android.content.Context;
import android.content.Intent;
import android.os.Looper;
import android.os.MessageQueue;
import android.os.MessageQueue.IdleHandler;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.activity.aio.helper.ChatDrawerHelper;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.widget.DrawerFrame;
import com.tencent.mobileqq.widget.DrawerFrame.IDrawerCallbacks;
import com.tencent.mobileqq.widget.navbar.NavBarAIO;
import com.tencent.qphone.base.util.QLog;

public abstract class BaseChatDrawer
  implements DrawerFrame.IDrawerCallbacks
{
  public QQAppInterface a;
  public BaseActivity b;
  public Context c;
  public SessionInfo d;
  public BaseChatPie e;
  public ViewGroup f;
  public ViewGroup g;
  private DrawerFrame h;
  private View i;
  private boolean j;
  private MessageQueue.IdleHandler k = new BaseChatDrawer.1(this);
  private DrawerFrame.IDrawerCallbacks l = new BaseChatDrawer.3(this);
  
  public BaseChatDrawer(BaseChatPie paramBaseChatPie)
  {
    this.e = paramBaseChatPie;
    this.a = this.e.d;
    this.b = this.e.f;
    this.c = this.e.e;
    this.d = this.e.ah;
    this.f = this.e.aZ;
    this.g = this.e.ba;
    this.h = ((ChatDrawerHelper)this.e.q(124)).a;
    this.h.setDrawerEnabled(true);
    this.h.setDrawerCallbacks(this.l);
    p();
    Looper.myQueue().addIdleHandler(this.k);
  }
  
  private void p()
  {
    NavBarAIO localNavBarAIO = this.e.p;
    if (localNavBarAIO != null) {
      localNavBarAIO.addOnLayoutChangeListener(new BaseChatDrawer.2(this, localNavBarAIO));
    }
  }
  
  public void a()
  {
    if (!this.j)
    {
      try
      {
        this.i = b();
        View localView1 = this.i;
        this.j = true;
      }
      catch (OutOfMemoryError localOutOfMemoryError)
      {
        localOutOfMemoryError.printStackTrace();
        QLog.d("BaseChatDrawer", 1, "BaseChatDrawer createDrawerView oom", localOutOfMemoryError);
      }
      View localView2 = this.i;
      if (localView2 != null)
      {
        DrawerFrame localDrawerFrame = this.h;
        if (localDrawerFrame != null)
        {
          localDrawerFrame.a(localView2, 1);
          c();
        }
      }
    }
  }
  
  public void a(int paramInt) {}
  
  public void a(int paramInt, float paramFloat) {}
  
  public void a(int paramInt1, int paramInt2, Intent paramIntent) {}
  
  public void a(boolean paramBoolean)
  {
    DrawerFrame localDrawerFrame = this.h;
    if (localDrawerFrame != null) {
      localDrawerFrame.a(paramBoolean);
    }
  }
  
  protected abstract View b();
  
  public void b(int paramInt) {}
  
  public void b(boolean paramBoolean)
  {
    DrawerFrame localDrawerFrame = this.h;
    if (localDrawerFrame != null) {
      localDrawerFrame.a(1, paramBoolean);
    }
  }
  
  protected abstract void c();
  
  public void c(boolean paramBoolean)
  {
    DrawerFrame localDrawerFrame = this.h;
    if (localDrawerFrame != null) {
      localDrawerFrame.setDrawerEnabled(paramBoolean);
    }
  }
  
  public boolean d()
  {
    DrawerFrame localDrawerFrame = this.h;
    if (localDrawerFrame != null) {
      return localDrawerFrame.f();
    }
    return false;
  }
  
  public void e()
  {
    DrawerFrame localDrawerFrame = this.h;
    if (localDrawerFrame != null) {
      localDrawerFrame.f();
    }
    if (this.j) {
      m();
    }
  }
  
  public void f()
  {
    if (this.j) {
      o();
    }
  }
  
  public void g()
  {
    DrawerFrame localDrawerFrame = this.h;
    if (localDrawerFrame != null)
    {
      localDrawerFrame.a();
      this.h.setDrawerCallbacks(null);
      this.h = null;
    }
    Looper.myQueue().removeIdleHandler(this.k);
    if (this.j) {
      n();
    }
    if (QLog.isColorLevel()) {
      QLog.d("BaseChatDrawer", 2, String.format("onDestroy, mHadInflated: %s", new Object[] { Boolean.valueOf(this.j) }));
    }
  }
  
  public boolean h()
  {
    return false;
  }
  
  public void i() {}
  
  public void j() {}
  
  public void k() {}
  
  public void l() {}
  
  public void m() {}
  
  public void n() {}
  
  public void o() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.drawer.BaseChatDrawer
 * JD-Core Version:    0.7.0.1
 */