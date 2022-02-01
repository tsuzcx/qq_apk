package com.tencent.mobileqq.activity.photo;

import com.tencent.mobileqq.app.TroopBusinessObserver;
import com.tencent.mobileqq.data.troop.TroopClipPic;
import com.tencent.mobileqq.util.Utils;
import com.tencent.qphone.base.util.QLog;
import java.util.List;

class TroopPhotoController$9
  extends TroopBusinessObserver
{
  TroopPhotoController$9(TroopPhotoController paramTroopPhotoController) {}
  
  public void onCmdTroopAvatar(boolean paramBoolean, String paramString1, int paramInt1, String paramString2, int paramInt2, List<TroopClipPic> paramList)
  {
    if (!Utils.a(paramString1, this.this$0.mTroopUin)) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.i("TroopPhotoController", 2, String.format("onCmdTroopAvatar result=%d", new Object[] { Integer.valueOf(paramInt1) }));
    }
    this.this$0.onUpdateTroopAvatarWallList(true);
  }
  
  public void onGetTroopAvatar(boolean paramBoolean, String paramString1, int paramInt1, String paramString2, int paramInt2, List<TroopClipPic> paramList)
  {
    if (this.this$0.mTroopInfoData == null) {}
    do
    {
      do
      {
        return;
      } while ((!paramBoolean) || (!Utils.a(paramString1, this.this$0.mTroopUin)));
      if (QLog.isColorLevel()) {
        QLog.i("TroopPhotoController", 2, String.format("onGetTroopAvatar result=%d", new Object[] { Integer.valueOf(paramInt1) }));
      }
    } while (paramInt1 != 0);
    this.this$0.onUpdateTroopAvatarWallList(true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.photo.TroopPhotoController.9
 * JD-Core Version:    0.7.0.1
 */