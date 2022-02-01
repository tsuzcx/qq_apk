package com.tencent.aelight.camera.aeeditor.module.params;

import com.tencent.qcircle.tavcut.bean.Size;
import common.config.service.QzoneConfig;

class DefaultVideoParamStrategy
  implements VideoParamStrategy
{
  public int a()
  {
    return ((Integer)ParamsUtil.a(Integer.valueOf(QzoneConfig.getAELowSize()), Integer.valueOf(QzoneConfig.getAEMiddleSize()), Integer.valueOf(QzoneConfig.getAEHighSize()))).intValue();
  }
  
  public Size a(Size paramSize)
  {
    int i = ((Integer)ParamsUtil.a(Integer.valueOf(QzoneConfig.getAELowSize()), Integer.valueOf(QzoneConfig.getAEMiddleSize()), Integer.valueOf(QzoneConfig.getAEHighSize()))).intValue();
    Size localSize = new Size(0, 0);
    double d1 = paramSize.getWidth();
    double d2 = paramSize.getHeight();
    Double.isNaN(d1);
    Double.isNaN(d2);
    d1 /= d2;
    if (paramSize.getWidth() > paramSize.getHeight())
    {
      localSize.setWidth(Math.min(paramSize.getWidth(), i));
      d2 = localSize.getWidth();
      Double.isNaN(d2);
      localSize.setHeight(ParamsUtil.a(d2 / d1));
      return localSize;
    }
    localSize.setHeight(Math.min(paramSize.getHeight(), i));
    d2 = localSize.getHeight();
    Double.isNaN(d2);
    localSize.setWidth(ParamsUtil.a(d2 * d1));
    return localSize;
  }
  
  public int b()
  {
    return ((Integer)ParamsUtil.a(Integer.valueOf(QzoneConfig.getAELowBitRate() * 1048576), Integer.valueOf(QzoneConfig.getAEMiddleBitRate() * 1048576), Integer.valueOf(QzoneConfig.getAEHighBitRate() * 1048576))).intValue();
  }
  
  public int c()
  {
    return QzoneConfig.getAEExportFrameRate();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.aeeditor.module.params.DefaultVideoParamStrategy
 * JD-Core Version:    0.7.0.1
 */