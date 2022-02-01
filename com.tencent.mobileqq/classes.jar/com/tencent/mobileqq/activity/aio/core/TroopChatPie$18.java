package com.tencent.mobileqq.activity.aio.core;

import android.content.Intent;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.troop.api.observer.TroopModifyObserver;
import com.tencent.mobileqq.widget.QQToast;

class TroopChatPie$18
  extends TroopModifyObserver
{
  TroopChatPie$18(TroopChatPie paramTroopChatPie) {}
  
  public void a(boolean paramBoolean, String paramString1, String paramString2, String paramString3, int paramInt)
  {
    if (TextUtils.isEmpty(paramString1)) {
      return;
    }
    if (!paramString1.equals(this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a)) {
      return;
    }
    TroopManager localTroopManager = (TroopManager)this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.TROOP_MANAGER);
    TroopInfo localTroopInfo = localTroopManager.c(this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a);
    if (localTroopInfo == null) {
      return;
    }
    if (!paramBoolean)
    {
      if (!TextUtils.isEmpty(paramString3)) {
        QQToast.a(BaseApplicationImpl.getContext(), 1, paramString3, 0).a();
      }
    }
    else
    {
      localTroopInfo.troopname = paramString2;
      localTroopInfo.hasSetNewTroopName = true;
      if ((this.a.l()) && (localTroopInfo.isNewTroop) && (localTroopInfo.hasSetNewTroopName) && (localTroopInfo.hasSetNewTroopHead)) {
        localTroopInfo.isNewTroop = false;
      }
      localTroopManager.b(localTroopInfo);
      this.a.aE();
    }
    if ((this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a.equals(paramString1)) && (localTroopInfo != null))
    {
      this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.d = localTroopInfo.getTroopDisplayName();
      paramString1 = this.a.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getIntent();
      paramString1.putExtra("uinname", localTroopInfo.getTroopDisplayName());
      this.a.b(paramString1);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.core.TroopChatPie.18
 * JD-Core Version:    0.7.0.1
 */