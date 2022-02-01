package com.tencent.aekit.target.gl;

import android.graphics.SurfaceTexture;
import android.graphics.SurfaceTexture.OnFrameAvailableListener;

public class SurfaceTextureWrapper
  implements SurfaceTexture.OnFrameAvailableListener
{
  private volatile boolean hasImage = false;
  private int oesTextureId;
  private SurfaceTexture st;
  private Object syncObj = new Object();
  
  public SurfaceTextureWrapper(int paramInt)
  {
    this.oesTextureId = paramInt;
  }
  
  public boolean awaitImage()
  {
    return awaitImage(0L);
  }
  
  public boolean awaitImage(long paramLong)
  {
    if (!this.hasImage) {}
    try
    {
      synchronized (this.syncObj)
      {
        this.syncObj.wait(paramLong);
      }
    }
    catch (InterruptedException localInterruptedException)
    {
      label30:
      break label30;
    }
    break label40;
    throw localObject2;
    label40:
    return this.hasImage;
  }
  
  public int getOesTextureId()
  {
    return this.oesTextureId;
  }
  
  public SurfaceTexture getSt()
  {
    if (this.st == null)
    {
      this.st = new SurfaceTexture(this.oesTextureId);
      this.st.setOnFrameAvailableListener(this);
    }
    return this.st;
  }
  
  public Object getSyncObj()
  {
    return this.syncObj;
  }
  
  public boolean isHasImage()
  {
    return this.hasImage;
  }
  
  public void onFrameAvailable(SurfaceTexture arg1)
  {
    synchronized (this.syncObj)
    {
      this.hasImage = true;
      this.syncObj.notifyAll();
      return;
    }
  }
  
  public void release()
  {
    SurfaceTexture localSurfaceTexture = this.st;
    if (localSurfaceTexture != null) {
      localSurfaceTexture.release();
    }
  }
  
  public void setOesTextureId(int paramInt)
  {
    this.oesTextureId = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.aekit.target.gl.SurfaceTextureWrapper
 * JD-Core Version:    0.7.0.1
 */