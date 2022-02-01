package com.gyailib.library;

public class SegmentSmoothConfig
{
  public float blur_radius = 9.0F;
  public boolean enable_blur_threshold;
  public boolean enable_frames;
  public boolean enable_guide_smooth;
  public boolean enable_line_smooth;
  public boolean enable_sigmod;
  public boolean enable_smooth;
  public boolean enable_threshold;
  public String face_feature_key;
  public int mask_resize_height = 480;
  public int mask_resize_width = 480;
  public float post_process_max_threshold = 0.6F;
  public float post_process_min_threshold = 0.4F;
  public float pre_process_max_threshold = 0.6F;
  public float pre_process_min_threshold = 0.4F;
  
  public float getBlurRadius()
  {
    return this.blur_radius;
  }
  
  public boolean getEnableBlurThreshold()
  {
    return this.enable_blur_threshold;
  }
  
  public boolean getEnableFrames()
  {
    return this.enable_frames;
  }
  
  public boolean getEnableGuideSmooth()
  {
    return this.enable_guide_smooth;
  }
  
  public boolean getEnableLineSmooth()
  {
    return this.enable_line_smooth;
  }
  
  public boolean getEnableSigmod()
  {
    return this.enable_sigmod;
  }
  
  public boolean getEnableSmooth()
  {
    return this.enable_smooth;
  }
  
  public boolean getEnableThreshold()
  {
    return this.enable_threshold;
  }
  
  public String getFaceFeatureKey()
  {
    return this.face_feature_key;
  }
  
  public int getMaskResizeHeight()
  {
    return this.mask_resize_height;
  }
  
  public int getMaskResizeWidth()
  {
    return this.mask_resize_width;
  }
  
  public float getPostProcessMaxThreshold()
  {
    return this.post_process_max_threshold;
  }
  
  public float getPostProcessMinThreshold()
  {
    return this.post_process_min_threshold;
  }
  
  public float getPreProcessMaxThreshold()
  {
    return this.pre_process_max_threshold;
  }
  
  public float getPreProcessMinThreshold()
  {
    return this.pre_process_min_threshold;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.gyailib.library.SegmentSmoothConfig
 * JD-Core Version:    0.7.0.1
 */