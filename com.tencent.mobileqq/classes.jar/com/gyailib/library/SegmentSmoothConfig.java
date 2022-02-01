package com.gyailib.library;

public class SegmentSmoothConfig
{
  public float blurRadius = 9.0F;
  public boolean enableBlurThreshold;
  public boolean enableFrames;
  public boolean enableGuideSmooth;
  public boolean enableLineSmooth;
  public boolean enableSigmod;
  public boolean enableSmooth;
  public boolean enableThreshold;
  public String faceFeatureKey;
  public int maskResizeHeight = 480;
  public int maskResizeWidth = 480;
  public float postProcessMaxThreshold = 0.6F;
  public float postProcessMinThreshold = 0.4F;
  public float preProcessMaxThreshold = 0.6F;
  public float preProcessMinThreshold = 0.4F;
  
  public float getBlurRadius()
  {
    return this.blurRadius;
  }
  
  public boolean getEnableBlurThreshold()
  {
    return this.enableBlurThreshold;
  }
  
  public boolean getEnableFrames()
  {
    return this.enableFrames;
  }
  
  public boolean getEnableGuideSmooth()
  {
    return this.enableGuideSmooth;
  }
  
  public boolean getEnableLineSmooth()
  {
    return this.enableLineSmooth;
  }
  
  public boolean getEnableSigmod()
  {
    return this.enableSigmod;
  }
  
  public boolean getEnableSmooth()
  {
    return this.enableSmooth;
  }
  
  public boolean getEnableThreshold()
  {
    return this.enableThreshold;
  }
  
  public String getFaceFeatureKey()
  {
    return this.faceFeatureKey;
  }
  
  public int getMaskResizeHeight()
  {
    return this.maskResizeHeight;
  }
  
  public int getMaskResizeWidth()
  {
    return this.maskResizeWidth;
  }
  
  public float getPostProcessMaxThreshold()
  {
    return this.postProcessMaxThreshold;
  }
  
  public float getPostProcessMinThreshold()
  {
    return this.postProcessMinThreshold;
  }
  
  public float getPreProcessMaxThreshold()
  {
    return this.preProcessMaxThreshold;
  }
  
  public float getPreProcessMinThreshold()
  {
    return this.preProcessMinThreshold;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.gyailib.library.SegmentSmoothConfig
 * JD-Core Version:    0.7.0.1
 */