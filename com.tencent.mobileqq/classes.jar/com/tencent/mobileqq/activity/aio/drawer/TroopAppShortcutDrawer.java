package com.tencent.mobileqq.activity.aio.drawer;

import android.content.Intent;
import android.view.View;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.activity.aio.helper.TroopAppShortcutHelper;
import com.tencent.mobileqq.activity.aio.navigate.TroopAppShortcutNavBar;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.troop.shortcutbar.TroopShortcutBarHandler;
import com.tencent.mobileqq.troop.troopapps.TroopAppShortcutContainer;
import com.tencent.mobileqq.troop.utils.TroopAppShortcutUtils;
import com.tencent.qphone.base.util.QLog;

public class TroopAppShortcutDrawer
  extends BaseChatDrawer
{
  private TroopAppShortcutContainer h;
  private boolean i = false;
  
  public TroopAppShortcutDrawer(BaseChatPie paramBaseChatPie)
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
    TroopAppShortcutHelper localTroopAppShortcutHelper = (TroopAppShortcutHelper)this.e.q(55);
    if (localTroopAppShortcutHelper != null) {
      localTroopAppShortcutHelper.e();
    }
    TroopAppShortcutNavBar.h();
  }
  
  public void a(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if ((this.h != null) && (d())) {
      this.h.a(paramInt1, paramInt2, paramIntent);
    }
  }
  
  protected View b()
  {
    this.h = new TroopAppShortcutDrawer.1(this, this.a, this.b, this.c, this.e.ah, this.e.ae(), 1);
    this.h.a();
    return this.h.a();
  }
  
  public void c()
  {
    a(this.e.ae());
  }
  
  public void c(int paramInt)
  {
    TroopAppShortcutContainer localTroopAppShortcutContainer = this.h;
    if (localTroopAppShortcutContainer != null) {
      localTroopAppShortcutContainer.a(paramInt);
    }
  }
  
  public boolean h()
  {
    if ((this.h != null) && (d()))
    {
      this.h.i();
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
    TroopAppShortcutContainer localTroopAppShortcutContainer = this.h;
    if (localTroopAppShortcutContainer != null) {
      localTroopAppShortcutContainer.b();
    }
    p();
  }
  
  public void k()
  {
    super.k();
    if (QLog.isColorLevel()) {
      QLog.d("intimate_relationship", 2, String.format("onDrawerOpened", new Object[0]));
    }
    TroopAppShortcutContainer localTroopAppShortcutContainer = this.h;
    if (localTroopAppShortcutContainer != null) {
      localTroopAppShortcutContainer.c();
    }
  }
  
  public void l()
  {
    super.l();
    if (QLog.isColorLevel()) {
      QLog.d("intimate_relationship", 2, String.format("onDrawerClosed", new Object[0]));
    }
    Object localObject1 = this.h;
    if (localObject1 != null) {
      ((TroopAppShortcutContainer)localObject1).d();
    }
    try
    {
      if ((this.e == null) || (this.e.ah == null) || (!TroopAppShortcutUtils.a(this.a, Long.parseLong(this.e.ah.b)))) {
        break label180;
      }
      localObject1 = (TroopShortcutBarHandler)this.a.getBusinessHandler(BusinessHandlerFactory.TROOP_SHORTCUTBAR_HANDLE);
      Object localObject2 = (TroopManager)this.a.getManager(QQManagerFactory.TROOP_MANAGER);
      if (localObject2 == null) {
        return;
      }
      localObject2 = ((TroopManager)localObject2).f(this.e.ah.b);
      if (localObject2 == null) {
        return;
      }
      if (localObject1 == null) {
        break label180;
      }
      ((TroopShortcutBarHandler)localObject1).a(Long.parseLong(this.e.ah.b), (int)((TroopInfo)localObject2).dwGroupClassExt, null);
      return;
    }
    catch (Exception localException)
    {
      label159:
      break label159;
    }
    if (QLog.isColorLevel()) {
      QLog.d("intimate_relationship", 2, String.format("parseLong Exception", new Object[0]));
    }
    label180:
  }
  
  public void n()
  {
    TroopAppShortcutContainer localTroopAppShortcutContainer = this.h;
    if (localTroopAppShortcutContainer != null)
    {
      localTroopAppShortcutContainer.j();
      this.h = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.drawer.TroopAppShortcutDrawer
 * JD-Core Version:    0.7.0.1
 */