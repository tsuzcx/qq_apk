package com.tencent.mobileqq.activity.pendant;

import com.tencent.mobileqq.activity.ProfileActivity;
import com.tencent.mobileqq.utils.DialogUtil;
import mqq.app.QQPermissionCallback;

class AvatarPendantActivity$14$3
  implements QQPermissionCallback
{
  AvatarPendantActivity$14$3(AvatarPendantActivity.14 param14) {}
  
  public void deny(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    DialogUtil.a(this.a.a, paramArrayOfString, paramArrayOfInt);
  }
  
  public void grant(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    this.a.a.a = ProfileActivity.a(this.a.a, 5);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.pendant.AvatarPendantActivity.14.3
 * JD-Core Version:    0.7.0.1
 */