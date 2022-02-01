package com.tencent.ilive.opensdk.bridgeinterface;

import android.graphics.SurfaceTexture;
import com.tencent.ilive.opensdk.coreinterface.ICoreBeautyFilter;
import com.tencent.ilive.opensdk.coreinterface.IGLRenderThread;
import com.tencent.ilive.opensdk.params.VFrame;
import java.util.Map;
import javax.microedition.khronos.opengles.GL10;

public class SimpleBeautyFilter
  implements ICoreBeautyFilter
{
  public void cut() {}
  
  public VFrame drawFrame(GL10 paramGL10)
  {
    return null;
  }
  
  public IGLRenderThread getGlThread()
  {
    return null;
  }
  
  public SurfaceTexture getSurfaceTexture()
  {
    return null;
  }
  
  public void onCreate() {}
  
  public void onDestroy() {}
  
  public void onPause() {}
  
  public void onResume() {}
  
  public void setBeautyFilterEnable(boolean paramBoolean) {}
  
  public void setBeautyValue(int paramInt1, int paramInt2) {}
  
  public void setConfig(Map<String, Object> paramMap) {}
  
  public void setFilterValue(String paramString, float paramFloat) {}
  
  public void setGLThread(IGLRenderThread paramIGLRenderThread) {}
  
  public boolean updateFrame(VFrame paramVFrame)
  {
    return false;
  }
  
  public void updateMaterial(String paramString) {}
  
  public void updateVideoSize(int paramInt1, int paramInt2, int paramInt3, int paramInt4) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.ilive.opensdk.bridgeinterface.SimpleBeautyFilter
 * JD-Core Version:    0.7.0.1
 */