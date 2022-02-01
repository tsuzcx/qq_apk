package com.tencent.avgame.util;

import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.utils.QQAudioHelper;
import com.tencent.qphone.base.util.QLog;
import mqq.app.QQPermissionCallback;

final class AvGameEntranceUtils$2
  implements QQPermissionCallback
{
  AvGameEntranceUtils$2(DialogInterface.OnClickListener paramOnClickListener) {}
  
  public void deny(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    String str = AvGameEntranceUtils.a;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("checkQAVPermission, deny, i[");
    localStringBuilder.append(paramInt);
    localStringBuilder.append("], permissions[");
    localStringBuilder.append(QQAudioHelper.a(paramArrayOfString));
    localStringBuilder.append("], grantResults[");
    localStringBuilder.append(QQAudioHelper.a(paramArrayOfInt));
    localStringBuilder.append("]");
    QLog.w(str, 1, localStringBuilder.toString());
    this.a.onClick(null, 0);
  }
  
  public void grant(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    String str = AvGameEntranceUtils.a;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("checkQAVPermission, grant, i[");
    localStringBuilder.append(paramInt);
    localStringBuilder.append("], permissions[");
    localStringBuilder.append(QQAudioHelper.a(paramArrayOfString));
    localStringBuilder.append("], grantResults[");
    localStringBuilder.append(QQAudioHelper.a(paramArrayOfInt));
    localStringBuilder.append("]");
    QLog.w(str, 1, localStringBuilder.toString());
    this.a.onClick(null, 1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.avgame.util.AvGameEntranceUtils.2
 * JD-Core Version:    0.7.0.1
 */