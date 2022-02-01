package com.tencent.mobileqq.activity.photo;

import java.util.List;

class TroopPhotoController$7
  implements Runnable
{
  TroopPhotoController$7(TroopPhotoController paramTroopPhotoController, List paramList) {}
  
  public void run()
  {
    this.this$0.mInfos.clear();
    this.this$0.mInfos.addAll(this.val$infoList);
    TroopPhotoController.access$100(this.this$0);
    this.this$0.notifyDataSetChanged();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.photo.TroopPhotoController.7
 * JD-Core Version:    0.7.0.1
 */