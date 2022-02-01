package com.peterlmeng.animate_image.renderer;

public abstract interface RenderWorker
{
  public abstract void dispose();
  
  public abstract void doStartPlay();
  
  public abstract String getUrl();
  
  public abstract boolean isResourceLoaded();
  
  public abstract void pause();
  
  public abstract void replaceImage(int paramInt, String paramString);
  
  public abstract void replay();
  
  public abstract void setOnResourceLoadListener(RenderWorker.OnResourceLoadListener paramOnResourceLoadListener);
  
  public abstract void startLoadResource();
  
  public abstract void stop();
  
  public abstract void updateFile(String paramString);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.peterlmeng.animate_image.renderer.RenderWorker
 * JD-Core Version:    0.7.0.1
 */