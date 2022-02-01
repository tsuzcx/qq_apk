package com.tencent.luggage.wxa.sm;

import android.graphics.SurfaceTexture;
import javax.microedition.khronos.opengles.GL10;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/wmpf/samelayer/recordview/LuggageSurfaceTextureRenderer;", "Lcom/tencent/wmpf/samelayer/recordview/LuggageCameraSurfaceRenderer;", "renderOutputType", "", "(I)V", "onDrawFrame", "", "gl", "Ljavax/microedition/khronos/opengles/GL10;", "luggage-camera_release"}, k=1, mv={1, 1, 16})
public abstract class h
  extends f
{
  public h(int paramInt)
  {
    super(0, 0, 0, 0, paramInt, 2);
  }
  
  public void onDrawFrame(@Nullable GL10 paramGL10)
  {
    try
    {
      SurfaceTexture localSurfaceTexture = b();
      if (localSurfaceTexture != null) {
        localSurfaceTexture.updateTexImage();
      }
    }
    catch (Exception localException)
    {
      com.tencent.luggage.wxa.f.f.a("MicroMsg.Media.LuggageCameraSurfaceRenderer", (Throwable)localException, "updateTexImage error", new Object[0]);
    }
    if (c())
    {
      a(false);
      return;
    }
    super.onDrawFrame(paramGL10);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.sm.h
 * JD-Core Version:    0.7.0.1
 */