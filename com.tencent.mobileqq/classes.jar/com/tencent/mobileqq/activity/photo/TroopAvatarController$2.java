package com.tencent.mobileqq.activity.photo;

import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.troop.TroopInfo;
import mqq.observer.AccountObserver;

class TroopAvatarController$2
  extends AccountObserver
{
  TroopAvatarController$2(TroopAvatarController paramTroopAvatarController) {}
  
  public void onUpdateSKey(String paramString1, String paramString2)
  {
    if (paramString1 == null)
    {
      TroopAvatarController.b(this.a, null);
      TroopAvatarController.a(this.a, null);
      this.a.notifyDataSetChanged();
      return;
    }
    this.a.startUpload(TroopAvatarController.a(this.a), this.a.mTroopInfo.troopcode, paramString1, this.a.mApp.getCurrentAccountUin());
    TroopAvatarController.a(this.a, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.photo.TroopAvatarController.2
 * JD-Core Version:    0.7.0.1
 */