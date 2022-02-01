package com.tencent.mobileqq.activity;

import android.text.TextUtils;
import com.tencent.mobileqq.app.BizTroopObserver;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.troop.utils.TroopUtils;
import com.tencent.mobileqq.troopinfo.TroopInfoData;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.List;

class TroopInfoActivity$23
  extends BizTroopObserver
{
  TroopInfoActivity$23(TroopInfoActivity paramTroopInfoActivity) {}
  
  public void onModifyTroopName(boolean paramBoolean, String paramString1, String paramString2, String paramString3, int paramInt)
  {
    super.onModifyTroopName(paramBoolean, paramString1, paramString2, paramString3, paramInt);
    if (TextUtils.equals(this.a.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin, paramString1))
    {
      this.a.p();
      if (!paramBoolean) {
        break label238;
      }
      this.a.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.hasSetNewTroopName = true;
      this.a.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopName = paramString2;
      if ((!this.a.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.isNewTroop) || (this.a.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.hasSetNewTroopName)) {
        this.a.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.newTroopName = paramString2;
      }
      this.a.c();
      this.a.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.hasSetNewTroopName = true;
      if (this.a.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.hasSetNewTroopHead) {
        this.a.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.isNewTroop = false;
      }
      if (this.a.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo != null)
      {
        this.a.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo.troopname = this.a.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopName;
        this.a.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo.hasSetNewTroopName = this.a.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.hasSetNewTroopName;
        this.a.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo.isNewTroop = this.a.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.isNewTroop;
        TroopUtils.a(this.a.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo, this.a.app, this.a.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.isMember);
      }
    }
    label238:
    do
    {
      return;
      paramString1 = paramString3;
      if (TextUtils.isEmpty(paramString3)) {
        paramString1 = HardCodeUtil.a(2131701819);
      }
      QQToast.a(this.a, 1, paramString1, 0).b(this.a.getTitleBarHeight());
      if (this.a.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo != null)
      {
        this.a.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopName = this.a.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo.getTroopDisplayName();
        this.a.c();
      }
    } while (!QLog.isColorLevel());
    QLog.d("Q.troopinfo", 2, paramString1);
  }
  
  public void onTroopInfoModifyBy0X89A(boolean paramBoolean, long paramLong, String paramString)
  {
    if ((this.a.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo != null) && (paramBoolean))
    {
      if (this.a.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopTypeExt == 2) {}
      TroopManager localTroopManager;
      TroopInfo localTroopInfo;
      StringBuffer localStringBuffer;
      for (this.a.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo.troopTypeExt = 3;; this.a.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo.troopTypeExt = this.a.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopTypeExt)
      {
        localTroopManager = (TroopManager)this.a.app.getManager(QQManagerFactory.TROOP_MANAGER);
        localTroopInfo = localTroopManager.c(this.a.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin);
        if (localTroopInfo == null) {
          break label405;
        }
        localTroopInfo.troopname = this.a.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopName;
        localTroopInfo.dwGroupClassExt = this.a.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.dwGroupClassExt;
        localTroopInfo.mGroupClassExtText = this.a.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.mTroopClassExtText;
        localTroopInfo.mRichFingerMemo = this.a.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.mRichFingerMemo;
        localTroopInfo.hasSetNewTroopName = this.a.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.hasSetNewTroopName;
        localTroopInfo.strLocation = this.a.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopLocation;
        localTroopInfo.troopLat = this.a.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopLat;
        localTroopInfo.troopLon = this.a.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopLon;
        localTroopInfo.location = this.a.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.location;
        localTroopInfo.grade = this.a.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.grade;
        localTroopInfo.school = this.a.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.school;
        if ((this.a.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopTags == null) || (this.a.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopTags.size() <= 0)) {
          break label398;
        }
        localStringBuffer = new StringBuffer();
        Iterator localIterator = this.a.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopTags.iterator();
        while (localIterator.hasNext())
        {
          String str = (String)localIterator.next();
          localStringBuffer.append(str + "\n");
        }
      }
      localStringBuffer.deleteCharAt(localStringBuffer.length() - 1);
      localTroopInfo.mTags = localStringBuffer.toString();
      label398:
      localTroopManager.b(localTroopInfo);
    }
    label405:
    if ((this.a.jdField_a_of_type_Int == 0) || (1 == this.a.jdField_a_of_type_Int)) {
      ReportController.b(this.a.app, "P_CliOper", "Grp_create", "", "edit_data", "ordinary_suc", 0, 0, this.a.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin, this.a.jdField_b_of_type_JavaLangString, "", "");
    }
    TroopInfoActivity.a(this.a, paramBoolean, paramLong, paramString, 0L, this.a.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.dwGroupClassExt);
  }
  
  public void onTroopInfoModifyExamine(long paramLong1, long paramLong2, long paramLong3, String paramString)
  {
    if (paramLong1 != 0L) {}
    this.a.jdField_a_of_type_Long = paramLong2;
    this.a.jdField_b_of_type_Long = paramLong3;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.TroopInfoActivity.23
 * JD-Core Version:    0.7.0.1
 */