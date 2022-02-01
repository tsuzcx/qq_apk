package com.tencent.ilive.opensdk.bridgeinterface;

import android.graphics.Bitmap;
import android.graphics.Rect;
import android.view.View;
import com.tencent.ilive.opensdk.coreinterface.IGLRender.IRenderLifeListener;
import com.tencent.ilive.opensdk.coreinterface.IMultiSubViewRender;
import com.tencent.ilive.opensdk.coreinterface.IMultiSubViewRender.IRecordCallback;
import com.tencent.ilive.opensdk.coreinterface.IMultiSubViewRender.ISurfaceTextureRenderListener;
import com.tencent.ilive.opensdk.coreinterface.IMultiSubViewRender.SubViewParam;
import com.tencent.ilive.opensdk.coreinterface.IStreamPacket;
import com.tencent.ilive.opensdk.params.RenderFrame;
import com.tencent.ilive.opensdk.params.RtcRelaRect;

public class SimpleMultiSubViewRender
  implements IMultiSubViewRender
{
  public boolean create(IMultiSubViewRender.SubViewParam paramSubViewParam)
  {
    return false;
  }
  
  public void destroy() {}
  
  public void destroyAll() {}
  
  public void destroyRootView() {}
  
  public boolean draw(RenderFrame paramRenderFrame)
  {
    return false;
  }
  
  public int getID()
  {
    return 0;
  }
  
  public Rect getRect()
  {
    return null;
  }
  
  public View getRootParentView()
  {
    return null;
  }
  
  public int getRootViewType()
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
  
  public int getZOrder()
  {
    return 0;
  }
  
  public void pause() {}
  
  public void resume() {}
  
  public void setBackground(Bitmap paramBitmap) {}
  
  public void setBackgroundColor(int paramInt) {}
  
  public void setOnOutputListener(IStreamPacket paramIStreamPacket) {}
  
  public void setPosition(int paramInt1, int paramInt2) {}
  
  public void setRecordRenderCallback(IMultiSubViewRender.IRecordCallback paramIRecordCallback) {}
  
  public void setRect(Rect paramRect) {}
  
  public void setRectRatio(RtcRelaRect paramRtcRelaRect) {}
  
  public void setRenderLifeListener(IGLRender.IRenderLifeListener paramIRenderLifeListener) {}
  
  public void setRenderOESListener(IMultiSubViewRender.ISurfaceTextureRenderListener paramISurfaceTextureRenderListener) {}
  
  public void setRootViewRecordSize(int paramInt1, int paramInt2) {}
  
  public void setRotation(int paramInt) {}
  
  public void setScreenOrientationPortrait(boolean paramBoolean) {}
  
  public void setSpeedMode(int paramInt) {}
  
  public void setVideoSize(int paramInt1, int paramInt2) {}
  
  public void setViewPortType(int paramInt) {}
  
  public void setVisible(boolean paramBoolean) {}
  
  public void setZOrder(int paramInt) {}
  
  public void setZOrderBottom() {}
  
  public void setZOrderTop() {}
  
  public void start() {}
  
  public void startRecordRender() {}
  
  public void stop() {}
  
  public void stopRecordRender() {}
  
  public void swapSubView(int paramInt) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.ilive.opensdk.bridgeinterface.SimpleMultiSubViewRender
 * JD-Core Version:    0.7.0.1
 */