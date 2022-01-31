package com.tencent.TMG.opengl;

import com.tencent.TMG.opengl.texture.YUVTexture;
import com.tencent.TMG.utils.SoUtil;
import java.nio.ByteBuffer;

public class GraphicRendererMgr
{
  private static boolean mIsSoLoaded = false;
  private static GraphicRendererMgr sGraphicRenderMgr;
  
  public static GraphicRendererMgr getInstance()
  {
    if (sGraphicRenderMgr == null) {}
    try
    {
      if (sGraphicRenderMgr == null)
      {
        loadSo();
        if (mIsSoLoaded) {
          sGraphicRenderMgr = new GraphicRendererMgr();
        }
      }
      return sGraphicRenderMgr;
    }
    finally {}
  }
  
  private static void loadSo()
  {
    if (!mIsSoLoaded) {
      if ((!SoUtil.loadSo("stlport_shared")) || (!SoUtil.loadSo("qav_graphics"))) {
        break label29;
      }
    }
    label29:
    for (boolean bool = true;; bool = false)
    {
      mIsSoLoaded = bool;
      return;
    }
  }
  
  public native void flushGlRender(String paramString);
  
  public native int getRecvDecoderFrameFunctionptr();
  
  public native void sendFrame2GLRender(String paramString, byte[] paramArrayOfByte, int paramInt1, int paramInt2, int paramInt3);
  
  public native void sendFrameByteBuffer2GLRender(String paramString, ByteBuffer paramByteBuffer, int paramInt1, int paramInt2, int paramInt3);
  
  public native void setGlRender(String paramString, YUVTexture paramYUVTexture);
  
  public native void setSelfId(String paramString);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.TMG.opengl.GraphicRendererMgr
 * JD-Core Version:    0.7.0.1
 */