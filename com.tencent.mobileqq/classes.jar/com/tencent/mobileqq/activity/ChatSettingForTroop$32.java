package com.tencent.mobileqq.activity;

import android.content.Intent;
import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.TroopBusinessObserver;
import com.tencent.mobileqq.app.TroopHandler;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.troop.utils.TroopRobotInfo;
import com.tencent.mobileqq.troop.utils.TroopUtils;
import com.tencent.mobileqq.troopinfo.TroopInfoData;
import com.tencent.mobileqq.widget.QQProgressNotifier;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;

class ChatSettingForTroop$32
  extends TroopBusinessObserver
{
  ChatSettingForTroop$32(ChatSettingForTroop paramChatSettingForTroop) {}
  
  public void onGetAddTroopWebInfo(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.chatopttroop", 2, String.format("onGetAddTroopWebInfo url=%s", new Object[] { paramString }));
    }
    if (!this.a.isResume()) {
      return;
    }
    if (TextUtils.isEmpty(paramString)) {
      QQToast.a(this.a, 2, 2131718553, 1).b(this.a.getTitleBarHeight());
    }
    for (;;)
    {
      this.a.finish();
      return;
      paramString = paramString + "?_wv=1031&troopUin=" + this.a.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin + "&isVerify=" + 0;
      Intent localIntent = new Intent(this.a, QQBrowserActivity.class);
      localIntent.putExtra("url", paramString);
      localIntent.putExtra("hide_left_button", true);
      localIntent.putExtra("show_right_close_button", true);
      localIntent.putExtra("finish_animation_up_down", true);
      this.a.startActivity(localIntent);
      this.a.overridePendingTransition(2130771999, 2130771992);
    }
  }
  
  public void onGetAddedRobots(boolean paramBoolean, int paramInt, long paramLong, ArrayList<TroopRobotInfo> paramArrayList)
  {
    StringBuilder localStringBuilder;
    if (QLog.isColorLevel())
    {
      localStringBuilder = new StringBuilder().append("RobotMemberFormItem onGetAddedRobots suc:").append(paramBoolean).append(" retCode:").append(paramInt).append(" troopuin:").append(paramLong).append(" infos:");
      if (paramArrayList != null) {
        break label90;
      }
    }
    label90:
    for (String str = "null";; str = paramArrayList.toString())
    {
      QLog.d("Q.chatopttroop", 2, str);
      this.a.runOnUiThread(new ChatSettingForTroop.32.1(this, paramArrayList));
      return;
    }
  }
  
  public void onGetToopLuckyCharacterStatus(boolean paramBoolean, String paramString1, String paramString2)
  {
    if ((this.a.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData == null) || (TextUtils.isEmpty(this.a.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin)) || (TextUtils.isEmpty(paramString1)) || (!paramString1.equals(this.a.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin)) || (this.a.jdField_a_of_type_ArrayOfAndroidViewView == null)) {}
    do
    {
      do
      {
        do
        {
          return;
        } while (!paramBoolean);
        paramString1 = this.a.jdField_a_of_type_ArrayOfAndroidViewView[49];
      } while (paramString1 == null);
      paramString1 = (TextView)paramString1.findViewById(2131377063);
    } while ((paramString2 == null) || (paramString1 == null));
    paramString1.setText(paramString2);
  }
  
  public void onTroopManagerFailed(int paramInt1, int paramInt2)
  {
    boolean bool = false;
    if (QLog.isColorLevel())
    {
      if (this.a.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData != null) {
        bool = true;
      }
      QLog.d("Q.chatopttroop", 2, new Object[] { "onTroopManagerFailed. reqType=", Integer.valueOf(paramInt1), ", result=", Integer.valueOf(paramInt2), ", hasTroopInfoData=", Boolean.valueOf(bool) });
    }
    if (this.a.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData == null) {}
    do
    {
      return;
      if ((1 == paramInt1) && ((this.a.isResume()) || (this.a.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.cGroupOption == 1)))
      {
        this.a.p();
        TroopUtils.a(this.a, paramInt2);
        this.a.jdField_a_of_type_JavaLangString = null;
        return;
      }
    } while ((!this.a.isResume()) || ((paramInt1 != 2) && (paramInt1 != 9)));
    if (this.a.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressNotifier == null) {
      this.a.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressNotifier = new QQProgressNotifier(this.a);
    }
    this.a.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressNotifier.b(2, 2131692165, 1500);
    this.a.finish();
  }
  
  public void onTroopManagerSuccess(int paramInt1, int paramInt2, String paramString)
  {
    Object localObject;
    boolean bool;
    if (QLog.isColorLevel())
    {
      if (TextUtils.isEmpty(paramString))
      {
        localObject = "";
        if (this.a.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData == null) {
          break label107;
        }
        bool = true;
        label30:
        QLog.d("Q.chatopttroop", 2, new Object[] { "onTroopManagerSuccess. reqType=", Integer.valueOf(paramInt1), ", result=", Integer.valueOf(paramInt2), ", troopUin=", localObject, ", hasTroopInfoData=", Boolean.valueOf(bool) });
      }
    }
    else {
      if (this.a.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData != null) {
        break label113;
      }
    }
    label107:
    label113:
    do
    {
      for (;;)
      {
        return;
        localObject = paramString;
        break;
        bool = false;
        break label30;
        if ((1 == paramInt1) && ((this.a.isResume()) || (this.a.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.cGroupOption == 1)))
        {
          this.a.p();
          if (this.a.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressNotifier == null) {
            this.a.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressNotifier = new QQProgressNotifier(this.a);
          }
          switch (paramInt2)
          {
          case -1: 
          default: 
            this.a.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressNotifier.b(2, 2131693551, 1500);
          }
          for (;;)
          {
            this.a.jdField_a_of_type_JavaLangString = null;
            return;
            ((TroopHandler)this.a.app.getBusinessHandler(BusinessHandlerFactory.TROOP_HANDLER)).a(Long.parseLong(paramString), Long.parseLong(this.a.app.getAccount()));
            continue;
            this.a.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressNotifier.b(2, 2131693552, 1500);
            this.a.finish();
            ChatSettingForTroop.a(this.a, true);
            localObject = (TroopManager)this.a.app.getManager(QQManagerFactory.TROOP_MANAGER);
            if (localObject != null)
            {
              ((TroopManager)localObject).e(((TroopManager)localObject).b(paramString));
              continue;
              this.a.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressNotifier.b(2, 2131720199, 1500);
            }
          }
        }
        if (this.a.isResume())
        {
          if (paramInt1 != 3) {
            break label543;
          }
          if (paramInt2 == 0)
          {
            paramString = (TroopManager)this.a.app.getManager(QQManagerFactory.TROOP_MANAGER);
            if (paramString == null) {}
            for (paramString = null;; paramString = paramString.b(this.a.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin))
            {
              if ((paramString == null) || (paramString.wMemberNum == this.a.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.wMemberNum)) {
                break label541;
              }
              this.a.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.updateTroopAdmMemberNum(paramString.Administrator, paramString.wMemberNum, this.a.app.getCurrentAccountUin(), this.a.getResources());
              if (this.a.c == null) {
                break;
              }
              this.a.c.setText(HardCodeUtil.a(2131701826) + this.a.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.wMemberNum + HardCodeUtil.a(2131701828));
              return;
            }
          }
        }
      }
    } while (((paramInt1 != 2) && (paramInt1 != 9)) || (paramInt2 != 0));
    label541:
    label543:
    paramString = new Intent();
    paramString.putExtra("isNeedFinish", true);
    this.a.setResult(-1, paramString);
    this.a.finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.ChatSettingForTroop.32
 * JD-Core Version:    0.7.0.1
 */