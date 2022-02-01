package com.tencent.mobileqq.activity;

import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.troop.api.observer.TroopObserver;
import com.tencent.mobileqq.util.Utils;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;

class TroopDisbandActivity$6
  extends TroopObserver
{
  TroopDisbandActivity$6(TroopDisbandActivity paramTroopDisbandActivity) {}
  
  public void onGetMutilTroopInfoResult(boolean paramBoolean, ArrayList<TroopInfo> paramArrayList)
  {
    if ((!paramBoolean) || (paramArrayList == null) || (paramArrayList.size() == 0)) {
      return;
    }
    TroopInfo localTroopInfo = null;
    int i = 0;
    label21:
    if ((localTroopInfo == null) && (i < paramArrayList.size()))
    {
      localTroopInfo = (TroopInfo)paramArrayList.get(i);
      if (localTroopInfo != null) {
        break label56;
      }
    }
    label56:
    while (!Utils.a(localTroopInfo.troopuin, this.a.jdField_a_of_type_JavaLangString))
    {
      i += 1;
      break label21;
      break;
    }
    this.a.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo = localTroopInfo;
    this.a.a(localTroopInfo, false);
  }
  
  public void onGetTroopInfoResult(boolean paramBoolean, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.i("Q.troopdisband.disband", 2, "onGetTroopInfoResult, isSuc=" + paramBoolean + ", groupUin : " + paramString);
    }
    TroopDisbandActivity localTroopDisbandActivity;
    if ((paramBoolean) && (Utils.a(paramString, this.a.jdField_a_of_type_JavaLangString)))
    {
      paramString = (TroopManager)this.a.app.getManager(QQManagerFactory.TROOP_MANAGER);
      localTroopDisbandActivity = this.a;
      if (paramString != null) {
        break label107;
      }
    }
    label107:
    for (paramString = null;; paramString = paramString.b(this.a.jdField_a_of_type_JavaLangString))
    {
      localTroopDisbandActivity.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo = paramString;
      this.a.a(this.a.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo, false);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.TroopDisbandActivity.6
 * JD-Core Version:    0.7.0.1
 */