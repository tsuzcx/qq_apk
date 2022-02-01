package com.tencent.mobileqq.activity.photo;

import com.tencent.mobileqq.utils.DialogUtil;
import mqq.app.QQPermissionCallback;

class TroopPhotoController$5$1
  implements QQPermissionCallback
{
  TroopPhotoController$5$1(TroopPhotoController.5 param5) {}
  
  public void deny(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    DialogUtil.a(this.this$1.this$0.mActivity, paramArrayOfString, paramArrayOfInt);
  }
  
  public void grant(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    TroopPhotoController.access$000(this.this$1.this$0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.photo.TroopPhotoController.5.1
 * JD-Core Version:    0.7.0.1
 */