package com.tencent.mobileqq.activity;

import acpz;
import android.os.Handler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.troopinfo.TroopInfoData;

public class ChatSettingForTroop$4$1
  implements Runnable
{
  public ChatSettingForTroop$4$1(acpz paramacpz, String paramString1, String paramString2, int paramInt, String paramString3, String paramString4) {}
  
  public void run()
  {
    ((TroopManager)this.jdField_a_of_type_Acpz.a.app.getManager(52)).a(this.jdField_a_of_type_Acpz.a.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin, this.jdField_a_of_type_JavaLangString, this.b, this.jdField_a_of_type_Int, this.c, this.d);
    this.jdField_a_of_type_Acpz.a.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopColorNick = this.b;
    this.jdField_a_of_type_Acpz.a.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopCard = this.b;
    this.jdField_a_of_type_Acpz.a.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(6);
    if (this.jdField_a_of_type_Acpz.a.e != null) {
      this.jdField_a_of_type_Acpz.a.a(this.jdField_a_of_type_Acpz.a.e);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.ChatSettingForTroop.4.1
 * JD-Core Version:    0.7.0.1
 */