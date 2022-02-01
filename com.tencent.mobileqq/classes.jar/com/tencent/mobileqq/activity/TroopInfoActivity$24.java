package com.tencent.mobileqq.activity;

import android.os.Handler;
import android.text.TextUtils;
import com.tencent.biz.common.util.HttpUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.troop.api.observer.TroopObserver;
import com.tencent.mobileqq.troopinfo.TroopInfoData;
import com.tencent.mobileqq.util.Utils;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;

class TroopInfoActivity$24
  extends TroopObserver
{
  TroopInfoActivity$24(TroopInfoActivity paramTroopInfoActivity) {}
  
  public void onGetMutilTroopInfoResult(boolean paramBoolean, ArrayList<TroopInfo> paramArrayList)
  {
    if ((!paramBoolean) || (paramArrayList == null) || (paramArrayList.size() == 0)) {}
    Object localObject;
    do
    {
      return;
      int i = 0;
      localObject = null;
      if ((localObject == null) && (i < paramArrayList.size()))
      {
        TroopInfo localTroopInfo = (TroopInfo)paramArrayList.get(i);
        if (localTroopInfo == null) {
          localObject = localTroopInfo;
        }
        for (;;)
        {
          i += 1;
          break;
          localObject = localTroopInfo;
          if (!Utils.a(localTroopInfo.troopuin, this.a.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin)) {
            localObject = null;
          }
        }
      }
    } while (localObject == null);
    this.a.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo = localObject;
    this.a.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.updateForTroopInfo(localObject, this.a.app.getCurrentAccountUin());
    this.a.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(4);
  }
  
  public void onGetSimpleTroopInfoResult(boolean paramBoolean, TroopInfo paramTroopInfo, String paramString)
  {
    if ((paramBoolean) && (paramTroopInfo != null) && (this.a.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo != null) && (this.a.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo.troopuin != null) && (this.a.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo.troopuin.equals(paramTroopInfo.troopuin)))
    {
      this.a.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo.troopowneruin = paramTroopInfo.troopowneruin;
      this.a.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo.troopname = paramTroopInfo.troopname;
      this.a.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo.troopface = paramTroopInfo.troopface;
      this.a.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo.troopmemo = paramTroopInfo.troopmemo;
      this.a.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo.fingertroopmemo = paramTroopInfo.fingertroopmemo;
      this.a.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo.mRichFingerMemo = paramTroopInfo.mRichFingerMemo;
      this.a.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo.location = paramTroopInfo.location;
      this.a.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo.grade = paramTroopInfo.grade;
      this.a.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo.school = paramTroopInfo.school;
      this.a.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo.strLocation = paramTroopInfo.strLocation;
      this.a.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo.troopLat = paramTroopInfo.troopLat;
      this.a.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo.troopLon = paramTroopInfo.troopLon;
      this.a.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo.dwGroupFlagExt = paramTroopInfo.dwGroupFlagExt;
      this.a.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo.troopAuthenticateInfo = paramTroopInfo.troopAuthenticateInfo;
      this.a.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo.troopTypeExt = paramTroopInfo.troopTypeExt;
      this.a.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo.dwGroupClassExt = paramTroopInfo.dwGroupClassExt;
      this.a.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo.isNewTroop = paramTroopInfo.isNewTroop;
      this.a.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo.hasSetNewTroopName = paramTroopInfo.hasSetNewTroopName;
      this.a.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo.hasSetNewTroopHead = paramTroopInfo.hasSetNewTroopHead;
      this.a.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo.mTags = paramTroopInfo.mTags;
      if (!TextUtils.isEmpty(this.a.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo.mRichFingerMemo)) {
        break label535;
      }
    }
    for (this.a.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo.mRichFingerMemo = this.a.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo.fingertroopmemo;; this.a.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo.mRichFingerMemo = HttpUtil.unEscape(this.a.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo.mRichFingerMemo))
    {
      this.a.jdField_a_of_type_Int = this.a.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo.troopTypeExt;
      this.a.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.updateForTroopInfo(this.a.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo, this.a.app.getCurrentAccountUin());
      if (this.a.jdField_a_of_type_Int != this.a.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopTypeExt) {
        this.a.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(8);
      }
      if ((this.a.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo != null) && (this.a.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.isMember))
      {
        if (QLog.isDevelopLevel()) {
          QLog.i("Q.troopinfo", 4, "updateTroopInfoToDB");
        }
        ThreadManager.post(new TroopInfoActivity.24.1(this, this.a.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo), 8, null, true);
      }
      this.a.jdField_a_of_type_AndroidOsHandler.post(new TroopInfoActivity.24.2(this));
      this.a.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(4);
      return;
      label535:
      this.a.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo.mRichFingerMemo = HttpUtil.removeHtmlTags(this.a.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo.mRichFingerMemo);
    }
  }
  
  public void onGetTroopInfoResult(boolean paramBoolean, String paramString)
  {
    if ((!paramBoolean) || (!Utils.a(paramString, this.a.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin))) {}
    do
    {
      return;
      if (QLog.isColorLevel()) {
        QLog.i("Q.troopinfo", 2, "onGetTroopInfoResult|uin = " + paramString);
      }
      paramString = ((TroopManager)this.a.app.getManager(QQManagerFactory.TROOP_MANAGER)).b(paramString);
    } while (paramString == null);
    this.a.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo = paramString;
    this.a.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.updateForTroopInfo(paramString, this.a.app.getCurrentAccountUin());
    this.a.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(4);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.TroopInfoActivity.24
 * JD-Core Version:    0.7.0.1
 */