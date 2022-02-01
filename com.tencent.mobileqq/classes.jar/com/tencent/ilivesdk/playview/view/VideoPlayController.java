package com.tencent.ilivesdk.playview.view;

public abstract interface VideoPlayController
{
  public abstract boolean getContentVisible();
  
  public abstract void initDecodeType(boolean paramBoolean);
  
  public abstract void playAssetsFile(String paramString);
  
  public abstract void playFile(String paramString);
  
  public abstract void setContentVisible(boolean paramBoolean);
  
  public abstract void setPlayListener(VideoPLayListener paramVideoPLayListener);
  
  public abstract void stop();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.ilivesdk.playview.view.VideoPlayController
 * JD-Core Version:    0.7.0.1
 */