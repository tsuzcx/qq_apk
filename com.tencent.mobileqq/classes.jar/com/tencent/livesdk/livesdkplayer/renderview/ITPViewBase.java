package com.tencent.livesdk.livesdkplayer.renderview;

public abstract interface ITPViewBase
{
  public static final boolean IS_TV = false;
  public static final int PLAYER_SCALE_BOTH_FULLSCREEN = 1;
  public static final int PLAYER_SCALE_ORIGINAL_FULLSCREEN = 2;
  public static final int PLAYER_SCALE_ORIGINAL_RATIO = 0;
  public static final int PLAYER_SCALE_ORIGINAL_RATIO_SQUARE = 6;
  
  public abstract boolean setDegree(int paramInt);
  
  public abstract void setOpaqueInfo(boolean paramBoolean);
  
  public abstract void setRadio(int paramInt1, int paramInt2);
  
  public abstract void setScaleParam(float paramFloat);
  
  public abstract void setVideoWidthAndHeight(int paramInt1, int paramInt2);
  
  public abstract void setViewCallBack(ITPViewBase.ViewCreateCallBack paramViewCreateCallBack);
  
  public abstract void setXYAxis(int paramInt);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.livesdk.livesdkplayer.renderview.ITPViewBase
 * JD-Core Version:    0.7.0.1
 */