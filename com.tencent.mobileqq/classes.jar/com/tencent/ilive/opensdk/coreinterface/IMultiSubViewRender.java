package com.tencent.ilive.opensdk.coreinterface;

import android.graphics.Bitmap;
import android.graphics.Rect;
import android.view.View;
import com.tencent.ilive.opensdk.params.RenderFrame;
import com.tencent.ilive.opensdk.params.RtcRelaRect;

public abstract interface IMultiSubViewRender
{
  public abstract boolean create(IMultiSubViewRender.SubViewParam paramSubViewParam);
  
  public abstract void destroy();
  
  public abstract void destroyAll();
  
  public abstract void destroyRootView();
  
  public abstract boolean draw(RenderFrame paramRenderFrame);
  
  public abstract int getID();
  
  public abstract Rect getRect();
  
  public abstract View getRootParentView();
  
  public abstract int getRootViewType();
  
  public abstract int getVideoHeight();
  
  public abstract int getVideoWidth();
  
  public abstract int getZOrder();
  
  public abstract void pause();
  
  public abstract void resume();
  
  public abstract void setBackground(Bitmap paramBitmap);
  
  public abstract void setBackgroundColor(int paramInt);
  
  public abstract void setOnOutputListener(IStreamPacket paramIStreamPacket);
  
  public abstract void setPosition(int paramInt1, int paramInt2);
  
  public abstract void setRecordRenderCallback(IMultiSubViewRender.IRecordCallback paramIRecordCallback);
  
  public abstract void setRect(Rect paramRect);
  
  public abstract void setRectRatio(RtcRelaRect paramRtcRelaRect);
  
  public abstract void setRenderLifeListener(IGLRender.IRenderLifeListener paramIRenderLifeListener);
  
  public abstract void setRenderOESListener(IMultiSubViewRender.ISurfaceTextureRenderListener paramISurfaceTextureRenderListener);
  
  public abstract void setRootViewRecordSize(int paramInt1, int paramInt2);
  
  public abstract void setRotation(int paramInt);
  
  public abstract void setScreenOrientationPortrait(boolean paramBoolean);
  
  public abstract void setSpeedMode(int paramInt);
  
  public abstract void setVideoSize(int paramInt1, int paramInt2);
  
  public abstract void setViewPortType(int paramInt);
  
  public abstract void setVisible(boolean paramBoolean);
  
  public abstract void setZOrder(int paramInt);
  
  public abstract void setZOrderBottom();
  
  public abstract void setZOrderTop();
  
  public abstract void start();
  
  public abstract void startRecordRender();
  
  public abstract void stop();
  
  public abstract void stopRecordRender();
  
  public abstract void swapSubView(int paramInt);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.ilive.opensdk.coreinterface.IMultiSubViewRender
 * JD-Core Version:    0.7.0.1
 */