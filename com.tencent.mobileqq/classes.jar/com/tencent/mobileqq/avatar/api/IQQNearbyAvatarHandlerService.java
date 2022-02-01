package com.tencent.mobileqq.avatar.api;

import com.tencent.mobileqq.app.face.FaceInfo;
import com.tencent.mobileqq.qroute.annotation.Service;
import mqq.app.api.IRuntimeService;

@Service(process={"all"})
public abstract interface IQQNearbyAvatarHandlerService
  extends IRuntimeService
{
  public abstract void getStrangerFaceInfo(FaceInfo paramFaceInfo);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.avatar.api.IQQNearbyAvatarHandlerService
 * JD-Core Version:    0.7.0.1
 */