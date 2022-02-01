package com.tencent.aelight.camera.aioeditor.takevideo.doodle.layer.config;

import com.tencent.aelight.camera.aioeditor.takevideo.doodle.layer.base.DefaultDoodleStrategy;
import com.tencent.aelight.camera.aioeditor.takevideo.doodle.layer.base.DoodleStrategy;

public class DoodleConfig$Builder
{
  private DoodleStrategy a = new DefaultDoodleStrategy();
  private int b = 0;
  private int c = 0;
  
  public Builder a(int paramInt)
  {
    if (paramInt > 0) {
      this.b = paramInt;
    }
    return this;
  }
  
  public Builder a(DoodleStrategy paramDoodleStrategy)
  {
    if (paramDoodleStrategy != null) {
      this.a = paramDoodleStrategy;
    }
    return this;
  }
  
  public DoodleConfig a()
  {
    return new DoodleConfig(this, null);
  }
  
  public Builder b(int paramInt)
  {
    if (paramInt > 0) {
      this.c = paramInt;
    }
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.aioeditor.takevideo.doodle.layer.config.DoodleConfig.Builder
 * JD-Core Version:    0.7.0.1
 */