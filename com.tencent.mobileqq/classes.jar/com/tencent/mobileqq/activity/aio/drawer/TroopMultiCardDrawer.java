package com.tencent.mobileqq.activity.aio.drawer;

import android.view.View;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.activity.aio.helper.TroopMultiCardHelper;
import com.tencent.mobileqq.activity.aio.navigate.TroopDNANavBar;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.multicard.MultiCardContainer;
import com.tencent.qphone.base.util.QLog;

public class TroopMultiCardDrawer
  extends BaseChatDrawer
{
  private MultiCardContainer h;
  private boolean i = false;
  
  public TroopMultiCardDrawer(BaseChatPie paramBaseChatPie)
  {
    super(paramBaseChatPie);
  }
  
  private void a(String paramString)
  {
    if (((TroopManager)this.a.getManager(QQManagerFactory.TROOP_MANAGER)).Z(paramString)) {
      c(false);
    }
  }
  
  private void p()
  {
    if (this.i) {
      return;
    }
    this.i = true;
    TroopMultiCardHelper localTroopMultiCardHelper = (TroopMultiCardHelper)this.e.q(31);
    if (localTroopMultiCardHelper != null) {
      localTroopMultiCardHelper.e();
    }
    TroopDNANavBar.h();
  }
  
  protected View b()
  {
    this.h = new TroopMultiCardDrawer.1(this, this.a, this.b, this.c, this.e.ae());
    this.h.b();
    return this.h.b();
  }
  
  public void c()
  {
    MultiCardContainer localMultiCardContainer = this.h;
    if (localMultiCardContainer != null) {
      localMultiCardContainer.c();
    }
    a(this.e.ae());
  }
  
  public boolean h()
  {
    if ((this.h != null) && (d()))
    {
      this.h.f();
      return true;
    }
    return false;
  }
  
  public void i()
  {
    super.i();
    if (QLog.isColorLevel()) {
      QLog.d("intimate_relationship", 2, String.format("onDrawerStartOpen", new Object[0]));
    }
    MultiCardContainer localMultiCardContainer = this.h;
    if (localMultiCardContainer != null) {
      localMultiCardContainer.a();
    }
    p();
  }
  
  public void l()
  {
    super.l();
    if (QLog.isColorLevel()) {
      QLog.d("intimate_relationship", 2, String.format("onDrawerClosed", new Object[0]));
    }
    MultiCardContainer localMultiCardContainer = this.h;
    if (localMultiCardContainer != null) {
      localMultiCardContainer.d();
    }
  }
  
  public void n()
  {
    MultiCardContainer localMultiCardContainer = this.h;
    if (localMultiCardContainer != null)
    {
      localMultiCardContainer.e();
      this.h = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.drawer.TroopMultiCardDrawer
 * JD-Core Version:    0.7.0.1
 */