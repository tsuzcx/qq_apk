package com.tencent.mobileqq.avatar.api.impl;

import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.face.FaceInfo;
import com.tencent.mobileqq.avatar.api.IQQDynamicAvatarService;
import com.tencent.mobileqq.avatar.dynamicavatar.DynamicAvatarManager;
import com.tencent.mobileqq.data.Setting;
import mqq.app.AppRuntime;

public class QQDynamicAvatarServiceImpl
  implements IQQDynamicAvatarService
{
  protected AppRuntime mApp;
  
  public boolean isNeed2UpdateSettingInfo(FaceInfo paramFaceInfo, Setting paramSetting, int paramInt)
  {
    return ((DynamicAvatarManager)this.mApp.getManager(QQManagerFactory.DYNAMIC_AVATAR_MANAGER)).a(paramFaceInfo, paramSetting, paramInt);
  }
  
  public void onCreate(AppRuntime paramAppRuntime)
  {
    this.mApp = paramAppRuntime;
  }
  
  public void onDestroy() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.avatar.api.impl.QQDynamicAvatarServiceImpl
 * JD-Core Version:    0.7.0.1
 */