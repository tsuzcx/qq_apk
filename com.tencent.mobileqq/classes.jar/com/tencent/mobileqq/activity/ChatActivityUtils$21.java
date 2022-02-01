package com.tencent.mobileqq.activity;

import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.utils.AudioHelper;
import com.tencent.qphone.base.util.QLog;
import mqq.app.QQPermissionCallback;

final class ChatActivityUtils$21
  implements QQPermissionCallback
{
  ChatActivityUtils$21(DialogInterface.OnClickListener paramOnClickListener) {}
  
  public void deny(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    QLog.w("ChatActivityUtils", 1, "checkQAVPermission, deny, i[" + paramInt + "], permissions[" + AudioHelper.a(paramArrayOfString) + "], grantResults[" + AudioHelper.a(paramArrayOfInt) + "]");
    this.a.onClick(null, 0);
  }
  
  public void grant(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    QLog.w("ChatActivityUtils", 1, "checkQAVPermission, grant, i[" + paramInt + "], permissions[" + AudioHelper.a(paramArrayOfString) + "], grantResults[" + AudioHelper.a(paramArrayOfInt) + "]");
    this.a.onClick(null, 1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.ChatActivityUtils.21
 * JD-Core Version:    0.7.0.1
 */