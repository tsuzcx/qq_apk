package com.tencent.ilive.opensdk.coreinterface;

import android.graphics.Bitmap;
import android.view.View;
import com.tencent.ilive.opensdk.params.RenderFrame;

public abstract interface IGLRender
{
  public abstract void changeVideoSize(int paramInt1, int paramInt2);
  
  public abstract boolean create(View paramView);
  
  public abstract boolean destroy();
  
  public abstract boolean draw(RenderFrame paramRenderFrame);
  
  public abstract Bitmap getLastFrame();
  
  public abstract int getRenderViewType();
  
  public abstract int getVideoHeight();
  
  public abstract int getVideoWidth();
  
  public abstract void setRenderLifeListener(IGLRender.IRenderLifeListener paramIRenderLifeListener);
  
  public abstract void setRenderViewType(int paramInt);
  
  public abstract void setRotation(int paramInt);
  
  public abstract void start();
  
  public abstract void startRecordRender();
  
  public abstract void stop();
  
  public abstract void stopRecordRender();
  
  public abstract boolean switchParentView(View paramView);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.ilive.opensdk.coreinterface.IGLRender
 * JD-Core Version:    0.7.0.1
 */