package com.tencent.av.ui.effect.toolbar.newversion;

import android.view.ViewGroup;
import com.tencent.av.utils.AudioHelper;
import com.tencent.qphone.base.util.QLog;
import mqq.app.QQPermissionCallback;

class Avatar2dToolbarV2$2
  implements QQPermissionCallback
{
  Avatar2dToolbarV2$2(Avatar2dToolbarV2 paramAvatar2dToolbarV2) {}
  
  public void deny(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onClick_Camera, deny, i[");
    localStringBuilder.append(paramInt);
    localStringBuilder.append("], permissions[");
    localStringBuilder.append(AudioHelper.a(paramArrayOfString));
    localStringBuilder.append("], grantResults[");
    localStringBuilder.append(AudioHelper.a(paramArrayOfInt));
    localStringBuilder.append("]");
    QLog.w("Avatar2dToolbarV2", 1, localStringBuilder.toString());
  }
  
  public void grant(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onClick_Camera, grant, i[");
    localStringBuilder.append(paramInt);
    localStringBuilder.append("], permissions[");
    localStringBuilder.append(AudioHelper.a(paramArrayOfString));
    localStringBuilder.append("], grantResults[");
    localStringBuilder.append(AudioHelper.a(paramArrayOfInt));
    localStringBuilder.append("]");
    QLog.w("Avatar2dToolbarV2", 1, localStringBuilder.toString());
    Avatar2dToolbarV2.access$100(this.a).setVisibility(8);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.ui.effect.toolbar.newversion.Avatar2dToolbarV2.2
 * JD-Core Version:    0.7.0.1
 */