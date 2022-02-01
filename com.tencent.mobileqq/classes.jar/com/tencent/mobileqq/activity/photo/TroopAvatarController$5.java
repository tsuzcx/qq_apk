package com.tencent.mobileqq.activity.photo;

import ajpw;
import bfai;
import com.tencent.mobileqq.data.troop.TroopInfo;

public class TroopAvatarController$5
  implements Runnable
{
  public TroopAvatarController$5(ajpw paramajpw, String paramString) {}
  
  public void run()
  {
    this.this$0.mManger.a(this.this$0.mTroopInfo.troopuin);
    ajpw.b(this.this$0, null);
    this.this$0.notifyDataSetChanged();
    TroopPhotoController.showToast(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.photo.TroopAvatarController.5
 * JD-Core Version:    0.7.0.1
 */