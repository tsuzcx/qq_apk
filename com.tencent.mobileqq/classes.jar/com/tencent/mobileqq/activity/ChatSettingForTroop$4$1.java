package com.tencent.mobileqq.activity;

import adsi;
import android.os.Handler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.troopinfo.TroopInfoData;
import com.tencent.qphone.base.util.QLog;
import java.util.List;

public class ChatSettingForTroop$4$1
  implements Runnable
{
  public ChatSettingForTroop$4$1(adsi paramadsi, String paramString1, String paramString2, int paramInt, String paramString3, String paramString4) {}
  
  public void run()
  {
    ((TroopManager)this.jdField_a_of_type_Adsi.a.app.getManager(QQManagerFactory.TROOP_MANAGER)).a(this.jdField_a_of_type_Adsi.a.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin, this.jdField_a_of_type_JavaLangString, this.b, this.jdField_a_of_type_Int, this.c, this.d);
    this.jdField_a_of_type_Adsi.a.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopColorNick = this.b;
    this.jdField_a_of_type_Adsi.a.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopCard = this.b;
    this.jdField_a_of_type_Adsi.a.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(6);
    if (this.jdField_a_of_type_Adsi.a.e != null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.chatopttroop", 2, "onReceive HW_TROOP_IDENTITY_CHANGED_EVENT,memberListForCard.size = " + this.jdField_a_of_type_Adsi.a.e.size());
      }
      this.jdField_a_of_type_Adsi.a.a(this.jdField_a_of_type_Adsi.a.e);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.ChatSettingForTroop.4.1
 * JD-Core Version:    0.7.0.1
 */