package com.tencent.mobileqq.activity;

import android.os.Handler;
import com.tencent.mobileqq.avatar.observer.AvatarObserver;
import com.tencent.mobileqq.troopinfo.TroopInfoData;
import com.tencent.mobileqq.util.Utils;

class TroopInfoActivity$21
  extends AvatarObserver
{
  TroopInfoActivity$21(TroopInfoActivity paramTroopInfoActivity) {}
  
  public void onUpdateTroopHead(boolean paramBoolean, String paramString)
  {
    if ((paramBoolean) && (Utils.a(paramString, this.a.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin))) {
      this.a.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(3);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.TroopInfoActivity.21
 * JD-Core Version:    0.7.0.1
 */