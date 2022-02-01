package com.tencent.mobileqq.app.face;

import com.tencent.mobileqq.avatar.api.IQQNearbyAvatarHandlerApi;
import com.tencent.mobileqq.qroute.QRoute;

public abstract interface FaceConstant$Nearby
{
  public static final String NEAR_BY_FACE_HANDLER = ((IQQNearbyAvatarHandlerApi)QRoute.api(IQQNearbyAvatarHandlerApi.class)).getClassName();
  public static final int TYPE_FACE_DOWNLOAD_SUCCESS = 0;
  public static final int TYPE_GET_FACEINFO_FINISHED = 1;
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.app.face.FaceConstant.Nearby
 * JD-Core Version:    0.7.0.1
 */