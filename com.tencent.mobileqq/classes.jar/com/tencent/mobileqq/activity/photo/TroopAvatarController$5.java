package com.tencent.mobileqq.activity.photo;

import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.troop.utils.TroopAvatarManger;

class TroopAvatarController$5
  implements Runnable
{
  TroopAvatarController$5(TroopAvatarController paramTroopAvatarController, String paramString) {}
  
  public void run()
  {
    this.this$0.mManger.a(this.this$0.mTroopInfo.troopuin);
    TroopAvatarController.b(this.this$0, null);
    this.this$0.notifyDataSetChanged();
    TroopPhotoController.showToast(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.photo.TroopAvatarController.5
 * JD-Core Version:    0.7.0.1
 */