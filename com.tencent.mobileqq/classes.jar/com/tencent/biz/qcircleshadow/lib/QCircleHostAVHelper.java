package com.tencent.biz.qcircleshadow.lib;

import com.tencent.mobileqq.qcircle.api.impl.QCircleServiceImpl;
import com.tencent.mobileqq.qcircle.tempapi.api.IQQBaseService;

public class QCircleHostAVHelper
{
  public static int checkSupportMediaCodecFeature()
  {
    return QCircleServiceImpl.getQQService().checkSupportMediaCodecFeature();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.qcircleshadow.lib.QCircleHostAVHelper
 * JD-Core Version:    0.7.0.1
 */