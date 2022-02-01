package com.tencent.aelight.camera.aioeditor.takevideo.doodle.layer.config;

import com.tencent.aelight.camera.aioeditor.takevideo.doodle.layer.base.DoodleStrategy;

public class DoodleConfig
{
  public int a;
  public DoodleStrategy a;
  public int b;
  
  private DoodleConfig(DoodleConfig.Builder paramBuilder)
  {
    this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleLayerBaseDoodleStrategy = DoodleConfig.Builder.a(paramBuilder);
    this.jdField_a_of_type_Int = DoodleConfig.Builder.a(paramBuilder);
    this.b = DoodleConfig.Builder.b(paramBuilder);
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("DoodleConfig{doodleStrategy=");
    localStringBuilder.append(this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleLayerBaseDoodleStrategy);
    localStringBuilder.append(", maxBitmapWidth=");
    localStringBuilder.append(this.jdField_a_of_type_Int);
    localStringBuilder.append(", maxBitmapHeight=");
    localStringBuilder.append(this.b);
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.aioeditor.takevideo.doodle.layer.config.DoodleConfig
 * JD-Core Version:    0.7.0.1
 */