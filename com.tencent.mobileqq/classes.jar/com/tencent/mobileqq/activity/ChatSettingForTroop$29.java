package com.tencent.mobileqq.activity;

import android.os.Handler;
import android.text.TextUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.data.troop.TroopMemberCardInfo;
import com.tencent.mobileqq.troop.api.observer.TroopObserver;
import com.tencent.mobileqq.troop.utils.TroopNotificationHelper;
import com.tencent.mobileqq.troopinfo.TroopInfoData;
import com.tencent.mobileqq.util.Utils;
import com.tencent.mobileqq.widget.QQProgressNotifier;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;

class ChatSettingForTroop$29
  extends TroopObserver
{
  ChatSettingForTroop$29(ChatSettingForTroop paramChatSettingForTroop) {}
  
  public void onGetMutilTroopInfoResult(boolean paramBoolean, ArrayList<TroopInfo> paramArrayList)
  {
    if (this.a.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData == null) {}
    Object localObject;
    do
    {
      do
      {
        return;
      } while ((!paramBoolean) || (paramArrayList == null) || (paramArrayList.size() == 0));
      localObject = null;
      int i = 0;
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
    this.a.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.updateForTroopChatSetting(localObject, this.a.getResources(), this.a.app.getCurrentAccountUin());
    if (QLog.isColorLevel()) {
      QLog.d("Q.chatopttroop", 2, "onGetMutilTroopInfoResult send MSG_UPDATE_INFO msg");
    }
    this.a.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(5);
    try
    {
      long l1 = Long.parseLong(this.a.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin);
      long l2 = Long.parseLong(this.a.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopCode);
      TroopNotificationHelper.a(this.a.app, 0, l2, l1, 0L, "", 0, "OidbSvc.0x852_48", (short)23, false, false);
      return;
    }
    catch (Exception paramArrayList) {}
  }
  
  public void onGetTroopInfoResult(boolean paramBoolean, String paramString)
  {
    if (this.a.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData == null) {}
    TroopInfo localTroopInfo;
    do
    {
      do
      {
        return;
      } while ((!paramBoolean) || (!Utils.a(paramString, this.a.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin)));
      localTroopInfo = ((TroopManager)this.a.app.getManager(QQManagerFactory.TROOP_MANAGER)).b(paramString);
      if (QLog.isColorLevel()) {
        QLog.i("Q.chatopttroop", 2, "onGetTroopInfoResult|uin = " + paramString + ",tmpTroop = " + localTroopInfo);
      }
    } while (localTroopInfo == null);
    this.a.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo = localTroopInfo;
    this.a.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.updateForTroopChatSetting(localTroopInfo, this.a.getResources(), this.a.app.getCurrentAccountUin());
    if (QLog.isColorLevel()) {
      QLog.d("Q.chatopttroop", 2, "onGetTroopInfoResult send MSG_UPDATE_INFO msg");
    }
    this.a.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(5);
    ChatSettingForTroop.k(this.a);
  }
  
  public void onGetTroopMemberCardInfoResult(boolean paramBoolean1, ArrayList<TroopMemberCardInfo> paramArrayList, boolean paramBoolean2)
  {
    ThreadManager.post(new ChatSettingForTroop.29.1(this), 8, null, true);
  }
  
  public void onModifyTroopInfoResult(boolean paramBoolean, ArrayList<TroopMemberCardInfo> paramArrayList, String paramString)
  {
    if (this.a.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData == null) {}
    boolean bool;
    do
    {
      return;
      if ((!paramBoolean) || (paramArrayList == null) || (paramArrayList.size() == 0)) {}
      for (bool = false;; bool = this.a.a(paramArrayList))
      {
        if (this.a.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressNotifier == null) {
          this.a.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressNotifier = new QQProgressNotifier(this.a);
        }
        if ((paramBoolean) || (TextUtils.isEmpty(paramString))) {
          break;
        }
        this.a.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressNotifier.a(2, paramString, 1000);
        return;
      }
      if ((!paramBoolean) && ((this.a.b & 0x1) == 1))
      {
        paramArrayList = this.a;
        paramArrayList.b &= 0xFFFFFFFE;
        this.a.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressNotifier.b(2, 2131694232, 1000);
        return;
      }
    } while ((!bool) || ((this.a.b & 0x1) != 1));
    paramArrayList = this.a;
    paramArrayList.b &= 0xFFFFFFFE;
    this.a.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressNotifier.b(1, 2131694233, 1000);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.ChatSettingForTroop.29
 * JD-Core Version:    0.7.0.1
 */