package com.tencent.mobileqq.activity.qqsettingme;

import com.tencent.mobileqq.profilecard.bussiness.anonymous.handler.AnonymousObserver;
import com.tencent.qphone.base.util.QLog;

class DrawerBizFacade$4
  extends AnonymousObserver
{
  DrawerBizFacade$4(DrawerBizFacade paramDrawerBizFacade) {}
  
  public void onAnonymousSettingMeRedPoint(boolean paramBoolean1, boolean paramBoolean2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QQSettingRedesign", 2, String.format("onAnonymousSettingMeRedPoint success=%s enable=%s", new Object[] { Boolean.valueOf(paramBoolean1), Boolean.valueOf(paramBoolean2) }));
    }
    if ((paramBoolean1) && (DrawerBizFacade.a(this.a))) {
      this.a.a("d_avatar").a(false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.activity.qqsettingme.DrawerBizFacade.4
 * JD-Core Version:    0.7.0.1
 */