package com.tencent.biz.qqcircle.immersive.part;

import com.tencent.biz.qcircleshadow.lib.QCirclePluginInitHelper;
import mqq.app.QQPermissionCallback;

class QFSPublishFeedPart$1
  implements QQPermissionCallback
{
  QFSPublishFeedPart$1(QFSPublishFeedPart paramQFSPublishFeedPart) {}
  
  public void deny(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    QCirclePluginInitHelper.showPermissionSettingDialog2(this.a.c(), paramArrayOfString, paramArrayOfInt);
  }
  
  public void grant(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    QFSPublishFeedPart.a(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.immersive.part.QFSPublishFeedPart.1
 * JD-Core Version:    0.7.0.1
 */