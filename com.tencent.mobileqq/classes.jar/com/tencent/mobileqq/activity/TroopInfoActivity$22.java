package com.tencent.mobileqq.activity;

import android.os.Handler;
import android.text.TextUtils;
import com.tencent.mobileqq.app.FriendListObserver;
import com.tencent.mobileqq.troopinfo.TroopInfoData;
import com.tencent.mobileqq.util.Utils;
import com.tencent.mobileqq.utils.ContactUtils;
import com.tencent.qphone.base.util.QLog;

class TroopInfoActivity$22
  extends FriendListObserver
{
  TroopInfoActivity$22(TroopInfoActivity paramTroopInfoActivity) {}
  
  public void onUpdateFriendInfo(String paramString, boolean paramBoolean)
  {
    if ((!paramBoolean) || (TextUtils.isEmpty(paramString)) || (!Utils.a(paramString, this.a.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopowneruin))) {}
    String str;
    do
    {
      return;
      this.a.c = false;
      str = ContactUtils.j(this.a.app, this.a.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopowneruin);
      if (!TextUtils.isEmpty(str))
      {
        this.a.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopOwnerNick = str;
        this.a.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(2);
      }
    } while (!QLog.isColorLevel());
    QLog.i("Q.troopinfo", 2, "onUpdateFriendInfo|uin = " + paramString + ", tmpNickName = " + str);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.TroopInfoActivity.22
 * JD-Core Version:    0.7.0.1
 */