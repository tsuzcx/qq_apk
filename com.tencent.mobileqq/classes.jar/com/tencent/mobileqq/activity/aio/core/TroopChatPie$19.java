package com.tencent.mobileqq.activity.aio.core;

import android.content.Intent;
import android.support.v4.app.FragmentActivity;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.aio.ChatAdapter1;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.BizTroopObserver;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.troop.utils.TroopGagMgr.GagStatus;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;

class TroopChatPie$19
  extends BizTroopObserver
{
  TroopChatPie$19(TroopChatPie paramTroopChatPie) {}
  
  public void onModifyTroopName(boolean paramBoolean, String paramString1, String paramString2, String paramString3, int paramInt)
  {
    if (TextUtils.isEmpty(paramString1)) {
      break label7;
    }
    for (;;)
    {
      label7:
      return;
      if (paramString1.equals(this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString))
      {
        TroopManager localTroopManager = (TroopManager)this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.TROOP_MANAGER);
        TroopInfo localTroopInfo = localTroopManager.c(this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
        if (localTroopInfo == null) {
          break;
        }
        if (!paramBoolean) {
          if (!TextUtils.isEmpty(paramString3)) {
            QQToast.a(BaseApplicationImpl.getContext(), 1, paramString3, 0).a();
          }
        }
        while ((this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString.equals(paramString1)) && (localTroopInfo != null))
        {
          this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.d = localTroopInfo.getTroopDisplayName();
          paramString1 = this.a.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getIntent();
          paramString1.putExtra("uinname", localTroopInfo.getTroopDisplayName());
          this.a.b(paramString1);
          return;
          localTroopInfo.troopname = paramString2;
          localTroopInfo.hasSetNewTroopName = true;
          if ((this.a.t()) && (localTroopInfo.isNewTroop) && (localTroopInfo.hasSetNewTroopName) && (localTroopInfo.hasSetNewTroopHead)) {
            localTroopInfo.isNewTroop = false;
          }
          localTroopManager.b(localTroopInfo);
          this.a.bz();
        }
      }
    }
  }
  
  public void onShareLbsInTroop(boolean paramBoolean1, boolean paramBoolean2)
  {
    if (!this.a.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.isResume()) {
      return;
    }
    if (paramBoolean1)
    {
      if (paramBoolean2) {}
      for (String str = this.a.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getString(2131696183);; str = this.a.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getString(2131696094))
      {
        QQToast.a(this.a.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getApplicationContext(), 2, str, 1).b(this.a.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getTitleBarHeight());
        return;
      }
    }
    QQToast.a(this.a.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getApplicationContext(), 1, 2131696182, 1).b(this.a.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getTitleBarHeight());
  }
  
  public void onTroopFileStatusUpdate(Object paramObject)
  {
    if (this.a.jdField_a_of_type_ComTencentMobileqqActivityAioChatAdapter1 != null) {
      this.a.jdField_a_of_type_ComTencentMobileqqActivityAioChatAdapter1.notifyDataSetChanged();
    }
  }
  
  public void onTroopGagStatusChange(TroopGagMgr.GagStatus paramGagStatus)
  {
    if ((paramGagStatus.jdField_a_of_type_Int == 2) && (paramGagStatus.jdField_a_of_type_ComTencentMobileqqTroopDataSelfGagInfo != null))
    {
      if (QLog.isColorLevel()) {
        QLog.d("troop_gag", 2, "onTroopGagStatusChange:" + paramGagStatus.jdField_a_of_type_JavaLangString);
      }
      if ((!TextUtils.isEmpty(this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString)) && (!TextUtils.isEmpty(paramGagStatus.jdField_a_of_type_JavaLangString))) {
        break label76;
      }
    }
    label76:
    while (!this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString.equals(paramGagStatus.jdField_a_of_type_JavaLangString)) {
      return;
    }
    this.a.a(paramGagStatus.jdField_a_of_type_ComTencentMobileqqTroopDataSelfGagInfo, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.core.TroopChatPie.19
 * JD-Core Version:    0.7.0.1
 */