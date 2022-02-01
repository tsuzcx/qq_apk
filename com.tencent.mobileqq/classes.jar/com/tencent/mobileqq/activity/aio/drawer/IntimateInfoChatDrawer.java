package com.tencent.mobileqq.activity.aio.drawer;

import android.content.Intent;
import android.view.View;
import com.tencent.mobileqq.activity.aio.IntimateInfoView;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.qphone.base.util.QLog;

public class IntimateInfoChatDrawer
  extends BaseChatDrawer
{
  private IntimateInfoView h;
  private boolean i = true;
  
  public IntimateInfoChatDrawer(BaseChatPie paramBaseChatPie)
  {
    super(paramBaseChatPie);
  }
  
  private void p() {}
  
  public void a(int paramInt1, int paramInt2, Intent paramIntent)
  {
    IntimateInfoView localIntimateInfoView = this.h;
    if (localIntimateInfoView != null) {
      localIntimateInfoView.a(paramInt1, paramInt2, paramIntent);
    }
  }
  
  protected View b()
  {
    this.h = new IntimateInfoChatDrawer.1(this, this.a, this.b, this.c, this.d.b);
    this.h.a();
    this.h.a(1);
    return this.h.a();
  }
  
  public void c()
  {
    IntimateInfoView localIntimateInfoView = this.h;
    if (localIntimateInfoView != null) {
      localIntimateInfoView.b();
    }
  }
  
  public void i()
  {
    super.i();
    if (QLog.isColorLevel()) {
      QLog.d("intimate_relationship", 2, String.format("onDrawerOpened, needReqIntimateInfo: %s", new Object[] { Boolean.valueOf(this.i) }));
    }
    IntimateInfoView localIntimateInfoView = this.h;
    if (localIntimateInfoView != null)
    {
      localIntimateInfoView.f = true;
      localIntimateInfoView.c();
      if (this.i)
      {
        this.i = false;
        this.h.d();
        this.h.e();
        this.h.r();
      }
    }
    p();
  }
  
  public void k()
  {
    super.k();
    IntimateInfoView localIntimateInfoView = this.h;
    if (localIntimateInfoView != null)
    {
      localIntimateInfoView.g = true;
      localIntimateInfoView.g();
    }
  }
  
  public void l()
  {
    super.l();
    IntimateInfoView localIntimateInfoView = this.h;
    if (localIntimateInfoView != null)
    {
      this.i = true;
      localIntimateInfoView.f();
    }
  }
  
  public void m()
  {
    if (this.h != null)
    {
      if (d())
      {
        this.h.d();
        this.h.r();
      }
      this.h.i();
    }
  }
  
  public void n()
  {
    IntimateInfoView localIntimateInfoView = this.h;
    if (localIntimateInfoView != null) {
      localIntimateInfoView.j();
    }
  }
  
  public void o()
  {
    IntimateInfoView localIntimateInfoView = this.h;
    if (localIntimateInfoView != null) {
      localIntimateInfoView.h();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.drawer.IntimateInfoChatDrawer
 * JD-Core Version:    0.7.0.1
 */