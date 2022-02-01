package com.tencent.mobileqq.avatar.api.impl;

import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.face.FaceDecoder;
import com.tencent.mobileqq.app.face.IFaceDecoder;
import com.tencent.mobileqq.avatar.api.IQQAvatarService;
import mqq.app.AppRuntime;

public class QQAvatarServiceImpl
  implements IQQAvatarService
{
  public IFaceDecoder getInstance(AppInterface paramAppInterface)
  {
    return new FaceDecoder(paramAppInterface);
  }
  
  public void onCreate(AppRuntime paramAppRuntime) {}
  
  public void onDestroy() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.avatar.api.impl.QQAvatarServiceImpl
 * JD-Core Version:    0.7.0.1
 */