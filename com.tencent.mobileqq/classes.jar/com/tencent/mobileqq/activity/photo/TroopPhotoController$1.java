package com.tencent.mobileqq.activity.photo;

import com.tencent.mobileqq.troop.utils.TroopUploadingThread.UploadState;

class TroopPhotoController$1
  implements Runnable
{
  TroopPhotoController$1(TroopPhotoController paramTroopPhotoController, AvatarInfo paramAvatarInfo, TroopUploadingThread.UploadState paramUploadState) {}
  
  public void run()
  {
    this.this$0.notifyUpdate(this.val$info, this.val$state);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.photo.TroopPhotoController.1
 * JD-Core Version:    0.7.0.1
 */