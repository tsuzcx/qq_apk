package com.tencent.mobileqq.activity;

import com.tencent.mobileqq.avatar.observer.AvatarObserver;
import com.tencent.mobileqq.data.Setting;
import com.tencent.qphone.base.util.QLog;

class FriendProfileImageAvatar$2
  extends AvatarObserver
{
  FriendProfileImageAvatar$2(FriendProfileImageAvatar paramFriendProfileImageAvatar) {}
  
  protected void onGetHeadInfo(boolean paramBoolean, Setting paramSetting)
  {
    if (paramSetting != null)
    {
      if (!this.a.h.equals(paramSetting.uin)) {
        return;
      }
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("onGetHeadInfo: uin=");
        localStringBuilder.append(paramSetting.uin);
        QLog.d("Q.profilecard.Avatar", 2, localStringBuilder.toString());
      }
      if ((this.a.c) && (paramSetting.url != null) && (paramSetting.url.length() > 0)) {
        this.a.a(paramSetting.uin, paramSetting.bFaceFlags, paramSetting.url);
      }
    }
  }
  
  protected void onUpdateCustomHead(boolean paramBoolean, String paramString)
  {
    if (!this.a.h.equals(paramString)) {
      return;
    }
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onUpdateCustomHead: uin=");
      localStringBuilder.append(paramString);
      QLog.d("Q.profilecard.Avatar", 2, localStringBuilder.toString());
    }
    paramString = this.a;
    paramString.b(paramString.k);
    if (paramBoolean)
    {
      paramString = this.a;
      paramString.a(paramString.k, false);
      paramString = this.a;
      paramString.c(paramString.k);
      return;
    }
    this.a.k.d = 2;
    paramString = this.a;
    paramString.c(paramString.k);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.FriendProfileImageAvatar.2
 * JD-Core Version:    0.7.0.1
 */