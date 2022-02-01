package com.tencent.mobileqq.avatar.api.impl;

import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.face.FaceConstant.Nearby;
import com.tencent.mobileqq.app.face.FaceHandler;
import com.tencent.mobileqq.app.face.FaceInfo;
import com.tencent.mobileqq.avatar.api.IQQNearbyAvatarHandlerService;
import mqq.app.AppRuntime;

public class QQNearbyAvatarHandlerServiceImpl
  implements IQQNearbyAvatarHandlerService
{
  AppInterface mApp;
  FaceHandler mNearbyAvatarHandler;
  
  public void getStrangerFaceInfo(FaceInfo paramFaceInfo)
  {
    if (this.mNearbyAvatarHandler == null) {
      initNearbyAvatarHandler();
    }
    FaceHandler localFaceHandler = this.mNearbyAvatarHandler;
    if (localFaceHandler != null) {
      localFaceHandler.a(paramFaceInfo);
    }
  }
  
  void initNearbyAvatarHandler()
  {
    AppInterface localAppInterface = this.mApp;
    if (localAppInterface != null) {
      this.mNearbyAvatarHandler = ((FaceHandler)localAppInterface.getBusinessHandler(FaceConstant.Nearby.NEAR_BY_FACE_HANDLER));
    }
  }
  
  public void onCreate(AppRuntime paramAppRuntime)
  {
    if ((paramAppRuntime instanceof AppInterface))
    {
      this.mApp = ((AppInterface)paramAppRuntime);
      initNearbyAvatarHandler();
    }
  }
  
  public void onDestroy() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.avatar.api.impl.QQNearbyAvatarHandlerServiceImpl
 * JD-Core Version:    0.7.0.1
 */