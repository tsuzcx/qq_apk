package com.tencent.mobileqq.avatar.api;

import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.face.DecodeCompletionListener;
import com.tencent.mobileqq.app.face.FaceInfo;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;

@QAPI(process={"all"})
public abstract interface IQQAvatarDecoderApi
  extends QRouteApi
{
  public abstract void closeFaceDecodeThread();
  
  public abstract void executeTask(AppInterface paramAppInterface, FaceInfo paramFaceInfo, DecodeCompletionListener paramDecodeCompletionListener);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.avatar.api.IQQAvatarDecoderApi
 * JD-Core Version:    0.7.0.1
 */