package com.tencent.aelight.camera.aeeditor.module.params;

import common.config.service.QzoneConfig;

class DefaultImageParamStrategy
  implements ImageParamStrategy
{
  public int a()
  {
    return 960;
  }
  
  public int b()
  {
    return ((Integer)ParamsUtil.a(Integer.valueOf(QzoneConfig.getPreviewMaxIntermediateRenderSizeBelow2G()), Integer.valueOf(QzoneConfig.getPreviewMaxIntermediateRenderSizeAbove2G()))).intValue();
  }
  
  public int c()
  {
    double d = b();
    Double.isNaN(d);
    return (int)(d * 1.3D);
  }
  
  public int d()
  {
    return ((Integer)ParamsUtil.a(Integer.valueOf(QzoneConfig.getAEPicLowSize()), Integer.valueOf(QzoneConfig.getAEPicMiddleSize()), Integer.valueOf(QzoneConfig.getAEPicHighSize()))).intValue();
  }
  
  public int e()
  {
    return 100;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.aeeditor.module.params.DefaultImageParamStrategy
 * JD-Core Version:    0.7.0.1
 */