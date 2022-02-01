package com.tencent.mobileqq.avatar.api.impl;

import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.face.DecodeCompletionListener;
import com.tencent.mobileqq.app.face.FaceDecodeTask;
import com.tencent.mobileqq.app.face.FaceInfo;
import com.tencent.mobileqq.avatar.api.IQQAvatarDecoderApi;

public class QQAvatarDecoderApiImpl
  implements IQQAvatarDecoderApi
{
  public void closeFaceDecodeThread() {}
  
  public void executeTask(AppInterface paramAppInterface, FaceInfo paramFaceInfo, DecodeCompletionListener paramDecodeCompletionListener)
  {
    FaceDecodeTask.executeTask(paramAppInterface, paramFaceInfo, paramDecodeCompletionListener);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.avatar.api.impl.QQAvatarDecoderApiImpl
 * JD-Core Version:    0.7.0.1
 */