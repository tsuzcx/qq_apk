package com.tencent.mobileqq.activity.photo;

import com.tencent.mobileqq.data.troop.TroopClipPic;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.troop.utils.TroopAvatarManger;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

class TroopPhotoController$3
  implements Runnable
{
  TroopPhotoController$3(TroopPhotoController paramTroopPhotoController, AvatarInfo paramAvatarInfo, String paramString) {}
  
  public void run()
  {
    if (!this.this$0.isStillUploading(this.this$0.mTroopInfo.troopuin)) {
      this.this$0.mManger.a(this.this$0.mTroopInfo.troopuin);
    }
    Iterator localIterator = this.this$0.mUploadPaths.iterator();
    while (localIterator.hasNext())
    {
      TroopClipPic localTroopClipPic = (TroopClipPic)localIterator.next();
      if (localTroopClipPic.ts == this.val$info.a) {
        this.this$0.mUploadPaths.remove(localTroopClipPic);
      }
    }
    this.this$0.mInfos.remove(this.val$info);
    this.this$0.notifyDel(this.val$info);
    TroopPhotoController.showToast(this.val$errText);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.photo.TroopPhotoController.3
 * JD-Core Version:    0.7.0.1
 */