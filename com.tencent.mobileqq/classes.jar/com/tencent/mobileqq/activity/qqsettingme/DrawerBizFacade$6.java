package com.tencent.mobileqq.activity.qqsettingme;

import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.profilecard.observer.ProfileCardObserver;
import mqq.app.AppRuntime;

class DrawerBizFacade$6
  extends ProfileCardObserver
{
  DrawerBizFacade$6(DrawerBizFacade paramDrawerBizFacade) {}
  
  protected void onGetProfileCard(boolean paramBoolean, Object paramObject)
  {
    if (paramObject == null) {
      return;
    }
    if ((paramBoolean) && (DrawerBizFacade.a(this.a)) && (this.a.a != null) && ((paramObject instanceof Card)) && (this.a.a.getCurrentAccountUin().equals(((Card)paramObject).uin)))
    {
      this.a.b.runOnUiThread(new DrawerBizFacade.6.1(this));
      ThreadManager.excute(new DrawerBizFacade.6.2(this), 16, null, true);
      return;
    }
    if ((paramBoolean) && (this.a.a != null) && ((paramObject instanceof Card)) && (!DrawerBizFacade.a(this.a)))
    {
      String str = this.a.a.getCurrentAccountUin();
      paramObject = (Card)paramObject;
      if (str.equals(paramObject.uin)) {
        ThreadManager.excute(new DrawerBizFacade.6.3(this, paramObject), 16, null, true);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.qqsettingme.DrawerBizFacade.6
 * JD-Core Version:    0.7.0.1
 */