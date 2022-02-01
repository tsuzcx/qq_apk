package com.tencent.av.ui;

import android.view.View;
import com.tencent.av.utils.AudioHelper;
import com.tencent.qphone.base.util.QLog;
import mqq.app.QQPermissionCallback;

class VideoControlUI$13
  implements QQPermissionCallback
{
  VideoControlUI$13(VideoControlUI paramVideoControlUI, QQPermissionCallback paramQQPermissionCallback, String paramString, long paramLong, View paramView) {}
  
  public void deny(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    Object localObject1 = this.e.X;
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("onClick_Camera, deny, i[");
    ((StringBuilder)localObject2).append(paramInt);
    ((StringBuilder)localObject2).append("], mRequestPermissionIng[");
    ((StringBuilder)localObject2).append(this.e.bw);
    ((StringBuilder)localObject2).append("], permissions[");
    ((StringBuilder)localObject2).append(AudioHelper.a(paramArrayOfString));
    ((StringBuilder)localObject2).append("], grantResults[");
    ((StringBuilder)localObject2).append(AudioHelper.a(paramArrayOfInt));
    ((StringBuilder)localObject2).append("]");
    QLog.w((String)localObject1, 1, ((StringBuilder)localObject2).toString());
    localObject1 = this.e;
    ((VideoControlUI)localObject1).bw = false;
    localObject2 = this.a;
    if (localObject2 != null)
    {
      ((QQPermissionCallback)localObject2).deny(paramInt, paramArrayOfString, paramArrayOfInt);
      return;
    }
    ((VideoControlUI)localObject1).e(this.c, this.b);
  }
  
  public void grant(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    Object localObject = this.e.X;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onClick_Camera, grant, i[");
    localStringBuilder.append(paramInt);
    localStringBuilder.append("], mRequestPermissionIng[");
    localStringBuilder.append(this.e.bw);
    localStringBuilder.append("], permissions[");
    localStringBuilder.append(AudioHelper.a(paramArrayOfString));
    localStringBuilder.append("], grantResults[");
    localStringBuilder.append(AudioHelper.a(paramArrayOfInt));
    localStringBuilder.append("]");
    QLog.w((String)localObject, 1, localStringBuilder.toString());
    this.e.bw = false;
    localObject = this.a;
    if (localObject != null)
    {
      ((QQPermissionCallback)localObject).grant(paramInt, paramArrayOfString, paramArrayOfInt);
      return;
    }
    if ("android.permission.CAMERA".equals(this.b))
    {
      this.e.e(this.c, this.d);
      return;
    }
    if ("android.permission.RECORD_AUDIO".equals(this.b))
    {
      this.e.d(this.c, this.d);
      return;
    }
    if ("android.permission.WRITE_EXTERNAL_STORAGE".equals(this.b)) {
      this.e.g(this.c);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.ui.VideoControlUI.13
 * JD-Core Version:    0.7.0.1
 */