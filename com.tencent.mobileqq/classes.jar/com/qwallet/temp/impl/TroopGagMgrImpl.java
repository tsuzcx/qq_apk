package com.qwallet.temp.impl;

import com.qwallet.temp.ITroopGagMgr;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.troop.troopgag.data.SelfGagInfo;
import com.tencent.mobileqq.troop.utils.TroopGagMgr;
import mqq.app.AppRuntime;

public class TroopGagMgrImpl
  implements ITroopGagMgr
{
  private QQAppInterface mApp;
  
  private TroopGagMgr getManager()
  {
    return (TroopGagMgr)this.mApp.getManager(QQManagerFactory.TROOP_GAG_MANAGER);
  }
  
  public SelfGagInfo getSelfGagInfo(String paramString, boolean paramBoolean)
  {
    return getManager().a(paramString, paramBoolean);
  }
  
  public boolean isTroopMemberGag(String paramString1, String paramString2)
  {
    return getManager().a(paramString1, paramString2);
  }
  
  public void onCreate(AppRuntime paramAppRuntime)
  {
    if ((paramAppRuntime instanceof QQAppInterface)) {
      this.mApp = ((QQAppInterface)paramAppRuntime);
    }
  }
  
  public void onDestroy() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.qwallet.temp.impl.TroopGagMgrImpl
 * JD-Core Version:    0.7.0.1
 */