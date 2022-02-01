package com.tencent.mobileqq.avatar.dynamicavatar;

import android.text.TextUtils;
import com.tencent.mobileqq.data.DynamicAvatar;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;

class DynamicAvatarManager$2
  extends DynamicAvatarInfoObserver
{
  DynamicAvatarManager$2(DynamicAvatarManager paramDynamicAvatarManager) {}
  
  protected void a(boolean paramBoolean1, DynamicAvatarInfo paramDynamicAvatarInfo, Long paramLong, int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean2)
  {
    String str = DynamicAvatarManager.a(paramInt2, paramInt1, String.valueOf(paramLong), paramInt3);
    if (!paramBoolean1)
    {
      if (QLog.isColorLevel())
      {
        paramDynamicAvatarInfo = new StringBuilder();
        paramDynamicAvatarInfo.append("onGetDynamicAvatarInfo not success: ");
        paramDynamicAvatarInfo.append(paramInt1);
        paramDynamicAvatarInfo.append(" ");
        paramDynamicAvatarInfo.append(paramLong);
        paramDynamicAvatarInfo.append(" ");
        paramDynamicAvatarInfo.append(paramInt2);
        QLog.i("Q.dynamicAvatar", 2, paramDynamicAvatarInfo.toString());
      }
      DynamicAvatarManager.a(this.a, str, null, null);
      return;
    }
    if ((paramDynamicAvatarInfo != null) && (paramDynamicAvatarInfo.a != null) && (!paramDynamicAvatarInfo.a.isEmpty())) {
      paramDynamicAvatarInfo = DynamicAvatar.convertFrom((DynamicAvatarInfo.OneUinHeadInfo)paramDynamicAvatarInfo.a.get(0));
    } else {
      paramDynamicAvatarInfo = null;
    }
    if (paramDynamicAvatarInfo == null)
    {
      DynamicAvatarManager.a(this.a, str, null, null);
      return;
    }
    if (QLog.isColorLevel())
    {
      paramLong = new StringBuilder();
      paramLong.append("onGetDynamicAvatarInfo: ");
      paramLong.append(paramDynamicAvatarInfo);
      QLog.d("Q.dynamicAvatar", 2, paramLong.toString());
    }
    Object localObject = DynamicAvatarManager.a(paramInt2, paramInt3, paramDynamicAvatarInfo);
    paramLong = DynamicAvatarManager.a(paramInt2, 640, paramDynamicAvatarInfo);
    if ((TextUtils.isEmpty((CharSequence)localObject)) && (paramBoolean2))
    {
      paramLong = DynamicAvatarManager.a(17, paramInt3, paramDynamicAvatarInfo);
      localObject = DynamicAvatarManager.a(17, 640, paramDynamicAvatarInfo);
      paramDynamicAvatarInfo = paramLong;
      paramLong = (Long)localObject;
      localObject = paramDynamicAvatarInfo;
    }
    else
    {
      paramDynamicAvatarInfo = paramLong;
      paramLong = paramDynamicAvatarInfo;
    }
    DynamicAvatarManager.a(this.a, str, (String)localObject, paramLong);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.avatar.dynamicavatar.DynamicAvatarManager.2
 * JD-Core Version:    0.7.0.1
 */