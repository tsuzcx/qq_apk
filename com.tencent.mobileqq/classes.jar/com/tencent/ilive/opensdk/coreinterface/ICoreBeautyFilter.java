package com.tencent.ilive.opensdk.coreinterface;

import android.graphics.SurfaceTexture;
import com.tencent.ilive.opensdk.params.VFrame;
import java.util.Map;
import javax.microedition.khronos.opengles.GL10;

public abstract interface ICoreBeautyFilter
{
  public abstract void cut();
  
  public abstract VFrame drawFrame(GL10 paramGL10);
  
  public abstract IGLRenderThread getGlThread();
  
  public abstract SurfaceTexture getSurfaceTexture();
  
  public abstract void onCreate();
  
  public abstract void onDestroy();
  
  public abstract void onPause();
  
  public abstract void onResume();
  
  public abstract void setBeautyFilterEnable(boolean paramBoolean);
  
  public abstract void setBeautyValue(int paramInt1, int paramInt2);
  
  public abstract void setConfig(Map<String, Object> paramMap);
  
  public abstract void setFilterValue(String paramString, float paramFloat);
  
  public abstract void setGLThread(IGLRenderThread paramIGLRenderThread);
  
  public abstract boolean updateFrame(VFrame paramVFrame);
  
  public abstract void updateMaterial(String paramString);
  
  public abstract void updateVideoSize(int paramInt1, int paramInt2, int paramInt3, int paramInt4);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.ilive.opensdk.coreinterface.ICoreBeautyFilter
 * JD-Core Version:    0.7.0.1
 */