package com.tencent.mobileqq.activity;

import android.content.res.Resources;
import android.text.TextUtils;
import com.tencent.mobileqq.app.BizTroopObserver;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.troopinfo.TroopInfoData;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;

class ChatSettingForTroop$49
  extends BizTroopObserver
{
  ChatSettingForTroop$49(ChatSettingForTroop paramChatSettingForTroop) {}
  
  public void onGetFansTroopIdolInfo(boolean paramBoolean, String paramString1, String paramString2, Long paramLong)
  {
    if ((!paramBoolean) || (!TextUtils.equals(paramString1, this.a.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin))) {
      return;
    }
    ChatSettingForTroop.a(this.a, paramString2, paramLong.longValue());
  }
  
  public void onModifyTroopName(boolean paramBoolean, String paramString1, String paramString2, String paramString3, int paramInt)
  {
    boolean bool = true;
    super.onModifyTroopName(paramBoolean, paramString1, paramString2, paramString3, paramInt);
    if (TextUtils.equals(this.a.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin, paramString1))
    {
      this.a.p();
      if (!paramBoolean) {
        break label139;
      }
      this.a.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.hasSetNewTroopName = true;
      this.a.a(paramString2);
      if ((this.a.isResume()) && (this.a.e))
      {
        this.a.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo.isNewTroop = false;
        this.a.e = false;
        paramString1 = this.a;
        if (this.a.d) {
          break label134;
        }
        paramBoolean = bool;
        ChatSettingForTroop.a(paramString1, paramBoolean, this.a.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.isNewTroop);
      }
    }
    label134:
    label139:
    do
    {
      return;
      paramBoolean = false;
      break;
      if (paramInt == 1328) {
        ChatSettingForTroop.s(this.a);
      }
      paramString1 = paramString3;
      if (TextUtils.isEmpty(paramString3)) {
        paramString1 = HardCodeUtil.a(2131701819);
      }
      QQToast.a(this.a, 1, paramString1, 0).b(this.a.getTitleBarHeight());
      if (this.a.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo != null)
      {
        this.a.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopName = this.a.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo.getTroopDisplayName();
        this.a.e();
      }
    } while (!QLog.isColorLevel());
    QLog.d("Q.chatopttroop", 2, paramString1);
  }
  
  public void onSetCommonUsedTroop(String paramString1, int paramInt1, int paramInt2, String paramString2, String paramString3)
  {
    if ((paramInt2 != 0) && (TextUtils.equals(this.a.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin, paramString1)))
    {
      if ((!this.a.isFinishing()) && (this.a.isResume()))
      {
        paramString1 = paramString2;
        if (TextUtils.isEmpty(paramString2)) {
          paramString1 = this.a.getResources().getString(2131694692);
        }
        QQToast.a(this.a, 1, paramString1, 0).b(this.a.getTitleBarHeight());
      }
      ChatSettingForTroop.r(this.a);
    }
  }
  
  public void onUpdateTroopSearchApproachPageTroopInfoUpdated(boolean paramBoolean, String paramString)
  {
    if ((TextUtils.equals(this.a.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin, paramString)) && (paramBoolean))
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.chatopttroop", 2, "onUpdateTroopSearchApproachPageTroopInfoUpdated ");
      }
      this.a.n();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.ChatSettingForTroop.49
 * JD-Core Version:    0.7.0.1
 */