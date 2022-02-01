package com.tencent.mobileqq.avatar.api;

import com.tencent.mobileqq.app.face.FaceInfo;
import com.tencent.mobileqq.data.Setting;
import com.tencent.mobileqq.qroute.annotation.Service;
import mqq.app.api.IRuntimeService;

@Service(process={"all"})
public abstract interface IQQDynamicAvatarService
  extends IRuntimeService
{
  public abstract boolean isNeed2UpdateSettingInfo(FaceInfo paramFaceInfo, Setting paramSetting, int paramInt);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.avatar.api.IQQDynamicAvatarService
 * JD-Core Version:    0.7.0.1
 */