package com.tencent.biz.qqstory.takevideo.doodle.layer.config;

import com.tencent.biz.qqstory.takevideo.doodle.layer.base.DoodleStrategy;

public class DoodleConfig
{
  public int a;
  public DoodleStrategy a;
  public int b;
  
  private DoodleConfig(DoodleConfig.Builder paramBuilder)
  {
    this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleLayerBaseDoodleStrategy = DoodleConfig.Builder.a(paramBuilder);
    this.jdField_a_of_type_Int = DoodleConfig.Builder.a(paramBuilder);
    this.b = DoodleConfig.Builder.b(paramBuilder);
  }
  
  public String toString()
  {
    return "DoodleConfig{doodleStrategy=" + this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleLayerBaseDoodleStrategy + ", maxBitmapWidth=" + this.jdField_a_of_type_Int + ", maxBitmapHeight=" + this.b + '}';
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.qqstory.takevideo.doodle.layer.config.DoodleConfig
 * JD-Core Version:    0.7.0.1
 */