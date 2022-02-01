package com.tencent.mobileqq.activity.photo;

import akjf;
import bgmj;
import java.util.ArrayList;
import java.util.Iterator;

class TroopPhotoController$2
  implements Runnable
{
  TroopPhotoController$2(TroopPhotoController paramTroopPhotoController, bgmj parambgmj, akjf paramakjf, int paramInt) {}
  
  public void run()
  {
    int i = this.val$state.c;
    this.val$info.jdField_a_of_type_Boolean = false;
    this.val$info.b = 1;
    this.val$info.c = false;
    this.this$0.initVerifyFlag(this.val$info);
    i &= 0x7FFFFFFF;
    if ((i < 0) || (i >= 1)) {
      this.this$0.update2DB(this.val$picId, this.val$info);
    }
    Iterator localIterator = this.this$0.mUploadPaths.iterator();
    while (localIterator.hasNext())
    {
      TroopClipPic localTroopClipPic = (TroopClipPic)localIterator.next();
      if (localTroopClipPic.ts == this.val$info.jdField_a_of_type_Long) {
        this.this$0.mUploadPaths.remove(localTroopClipPic);
      }
    }
    this.this$0.notifyUpdate(this.val$info, this.val$state);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.photo.TroopPhotoController.2
 * JD-Core Version:    0.7.0.1
 */