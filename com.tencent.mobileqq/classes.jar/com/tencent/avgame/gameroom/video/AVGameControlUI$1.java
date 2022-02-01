package com.tencent.avgame.gameroom.video;

import android.view.View;
import com.tencent.mobileqq.utils.QQAudioHelper;
import com.tencent.qphone.base.util.QLog;
import mqq.app.QQPermissionCallback;

class AVGameControlUI$1
  implements QQPermissionCallback
{
  AVGameControlUI$1(AVGameControlUI paramAVGameControlUI, String paramString, long paramLong, int paramInt, View paramView) {}
  
  public void deny(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    String str = this.e.a;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onClick_Camera, deny, i[");
    localStringBuilder.append(paramInt);
    localStringBuilder.append("], mRequestPermissionIng[");
    localStringBuilder.append(this.e.f);
    localStringBuilder.append("], permissions[");
    localStringBuilder.append(QQAudioHelper.a(paramArrayOfString));
    localStringBuilder.append("], grantResults[");
    localStringBuilder.append(QQAudioHelper.a(paramArrayOfInt));
    localStringBuilder.append("]");
    QLog.w(str, 1, localStringBuilder.toString());
    paramArrayOfString = this.e;
    paramArrayOfString.f = false;
    paramArrayOfString.a(this.b, this.a);
  }
  
  public void grant(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    String str = this.e.a;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onClick_Camera, grant, i[");
    localStringBuilder.append(paramInt);
    localStringBuilder.append("], mRequestPermissionIng[");
    localStringBuilder.append(this.e.f);
    localStringBuilder.append("], permissions[");
    localStringBuilder.append(QQAudioHelper.a(paramArrayOfString));
    localStringBuilder.append("], grantResults[");
    localStringBuilder.append(QQAudioHelper.a(paramArrayOfInt));
    localStringBuilder.append("]");
    QLog.w(str, 1, localStringBuilder.toString());
    this.e.f = false;
    if ("android.permission.CAMERA".equals(this.a))
    {
      this.e.a(this.b, this.c, this.d);
      return;
    }
    if ("android.permission.RECORD_AUDIO".equals(this.a)) {
      this.e.b(this.b, this.d);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.avgame.gameroom.video.AVGameControlUI.1
 * JD-Core Version:    0.7.0.1
 */