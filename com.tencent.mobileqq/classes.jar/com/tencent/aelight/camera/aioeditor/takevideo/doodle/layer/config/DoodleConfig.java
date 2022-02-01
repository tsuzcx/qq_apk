package com.tencent.aelight.camera.aioeditor.takevideo.doodle.layer.config;

import com.tencent.aelight.camera.aioeditor.takevideo.doodle.layer.base.DoodleStrategy;

public class DoodleConfig
{
  public DoodleStrategy a;
  public int b;
  public int c;
  
  private DoodleConfig(DoodleConfig.Builder paramBuilder)
  {
    this.a = DoodleConfig.Builder.a(paramBuilder);
    this.b = DoodleConfig.Builder.b(paramBuilder);
    this.c = DoodleConfig.Builder.c(paramBuilder);
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("DoodleConfig{doodleStrategy=");
    localStringBuilder.append(this.a);
    localStringBuilder.append(", maxBitmapWidth=");
    localStringBuilder.append(this.b);
    localStringBuilder.append(", maxBitmapHeight=");
    localStringBuilder.append(this.c);
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.aioeditor.takevideo.doodle.layer.config.DoodleConfig
 * JD-Core Version:    0.7.0.1
 */