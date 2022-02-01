package com.tencent.mobileqq.activity.qqsettingme;

import com.tencent.mobileqq.app.CardObserver;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.util.Utils;
import com.tencent.qphone.base.util.QLog;
import mqq.app.AppRuntime;
import mqq.os.MqqHandler;

class DrawerBizFacade$3
  extends CardObserver
{
  DrawerBizFacade$3(DrawerBizFacade paramDrawerBizFacade) {}
  
  protected void onGetMedal(boolean paramBoolean1, boolean paramBoolean2)
  {
    if ((paramBoolean1) && (DrawerBizFacade.a(this.a))) {
      this.a.a("d_avatar").a(false);
    }
    if (QLog.isColorLevel()) {
      QLog.d("QQSettingRedesign", 2, String.format("onGetMedal [%b, %b] medalSwitchDisable= ", new Object[] { Boolean.valueOf(paramBoolean1), Boolean.valueOf(DrawerBizFacade.a(this.a)), Boolean.valueOf(paramBoolean2) }));
    }
  }
  
  protected void onGetSignInInfo(boolean paramBoolean)
  {
    if (paramBoolean) {
      ThreadManager.getUIHandler().post(new DrawerBizFacade.3.1(this));
    }
  }
  
  protected void onSetMedal(boolean paramBoolean)
  {
    if ((paramBoolean) && (DrawerBizFacade.a(this.a)))
    {
      this.a.a("d_avatar").a(false);
      this.a.a("d_avatar").g();
    }
    if (QLog.isColorLevel()) {
      QLog.d("QQSettingRedesign", 2, String.format("onSetMedal [%b %b]", new Object[] { Boolean.valueOf(paramBoolean), Boolean.valueOf(DrawerBizFacade.a(this.a)) }));
    }
  }
  
  protected void onUpdateAvatar(boolean paramBoolean, String paramString, int paramInt)
  {
    if ((paramBoolean) && (DrawerBizFacade.a(this.a)) && (this.a.a != null) && (Utils.a(paramString, this.a.a.getCurrentAccountUin()))) {
      this.a.a("d_avatar").g();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.activity.qqsettingme.DrawerBizFacade.3
 * JD-Core Version:    0.7.0.1
 */