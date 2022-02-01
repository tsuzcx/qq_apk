package com.tencent.mobileqq.activity.photo;

import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.troop.TroopClipPic;
import com.tencent.mobileqq.data.troop.TroopInfo;
import java.util.ArrayList;
import java.util.List;
import mqq.observer.AccountObserver;

class TroopPhotoController$8
  extends AccountObserver
{
  TroopPhotoController$8(TroopPhotoController paramTroopPhotoController) {}
  
  public void onUpdateSKey(String paramString1, String paramString2)
  {
    int i = this.this$0.mUploadPaths.size();
    if (paramString1 == null)
    {
      for (;;)
      {
        int j = i - 1;
        if (i <= 0) {
          break;
        }
        paramString1 = TroopPhotoController.access$200(this.this$0, ((TroopClipPic)this.this$0.mUploadPaths.get(j)).ts);
        if (paramString1 == null)
        {
          i = j;
        }
        else
        {
          this.this$0.mInfos.remove(paramString1);
          this.this$0.notifyDel(paramString1);
          i = j;
        }
      }
      this.this$0.mUploadPaths.clear();
      return;
    }
    this.this$0.startUpload(this.this$0.mUploadPaths, this.this$0.mTroopInfo.troopcode, paramString1, this.this$0.mApp.getCurrentAccountUin());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.photo.TroopPhotoController.8
 * JD-Core Version:    0.7.0.1
 */