package com.tencent.liteav.beauty;

import android.graphics.Bitmap;

public abstract interface TXBeautyManager
{
  public abstract void enableSharpnessEnhancement(boolean paramBoolean);
  
  public abstract void setBeautyLevel(int paramInt);
  
  public abstract void setBeautyStyle(int paramInt);
  
  public abstract void setChinLevel(int paramInt);
  
  public abstract void setEyeAngleLevel(int paramInt);
  
  public abstract void setEyeDistanceLevel(int paramInt);
  
  public abstract void setEyeLightenLevel(int paramInt);
  
  public abstract void setEyeScaleLevel(int paramInt);
  
  public abstract void setFaceBeautyLevel(int paramInt);
  
  public abstract void setFaceShortLevel(int paramInt);
  
  public abstract void setFaceSlimLevel(int paramInt);
  
  public abstract void setFaceVLevel(int paramInt);
  
  public abstract void setFilter(Bitmap paramBitmap);
  
  public abstract void setFilterStrength(float paramFloat);
  
  public abstract void setForeheadLevel(int paramInt);
  
  public abstract void setGreenScreenFile(String paramString);
  
  public abstract void setLipsThicknessLevel(int paramInt);
  
  public abstract void setMotionMute(boolean paramBoolean);
  
  public abstract void setMotionTmpl(String paramString);
  
  public abstract void setMouthShapeLevel(int paramInt);
  
  public abstract void setNosePositionLevel(int paramInt);
  
  public abstract void setNoseSlimLevel(int paramInt);
  
  public abstract void setNoseWingLevel(int paramInt);
  
  public abstract void setPounchRemoveLevel(int paramInt);
  
  public abstract void setPreprocessor(d paramd);
  
  public abstract void setRuddyLevel(int paramInt);
  
  public abstract void setSmileLinesRemoveLevel(int paramInt);
  
  public abstract void setToothWhitenLevel(int paramInt);
  
  public abstract void setWhitenessLevel(int paramInt);
  
  public abstract void setWrinkleRemoveLevel(int paramInt);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.liteav.beauty.TXBeautyManager
 * JD-Core Version:    0.7.0.1
 */