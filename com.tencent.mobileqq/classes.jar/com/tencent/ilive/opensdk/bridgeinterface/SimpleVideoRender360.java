package com.tencent.ilive.opensdk.bridgeinterface;

import android.graphics.Bitmap;
import android.view.View;
import com.tencent.ilive.opensdk.coreinterface.IGLRender;
import com.tencent.ilive.opensdk.coreinterface.IGLRender.IRenderLifeListener;
import com.tencent.ilive.opensdk.params.RenderFrame;

public class SimpleVideoRender360
  implements IGLRender
{
  public void changeVideoSize(int paramInt1, int paramInt2) {}
  
  public boolean create(View paramView)
  {
    return false;
  }
  
  public boolean destroy()
  {
    return false;
  }
  
  public boolean draw(RenderFrame paramRenderFrame)
  {
    return false;
  }
  
  public Bitmap getLastFrame()
  {
    return null;
  }
  
  public int getRenderViewType()
  {
    return 0;
  }
  
  public int getVideoHeight()
  {
    return 0;
  }
  
  public int getVideoWidth()
  {
    return 0;
  }
  
  public void setRenderLifeListener(IGLRender.IRenderLifeListener paramIRenderLifeListener) {}
  
  public void setRenderViewType(int paramInt) {}
  
  public void setRotation(int paramInt) {}
  
  public void start() {}
  
  public void startRecordRender() {}
  
  public void stop() {}
  
  public void stopRecordRender() {}
  
  public boolean switchParentView(View paramView)
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.ilive.opensdk.bridgeinterface.SimpleVideoRender360
 * JD-Core Version:    0.7.0.1
 */