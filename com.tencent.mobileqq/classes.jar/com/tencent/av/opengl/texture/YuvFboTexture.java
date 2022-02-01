package com.tencent.av.opengl.texture;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.av.VideoController;
import com.tencent.av.app.SessionInfo;
import com.tencent.av.opengl.config.RendererConfig;
import com.tencent.av.opengl.glrenderer.GLCanvas;
import com.tencent.av.opengl.glrenderer.GLES20Canvas;
import com.tencent.av.opengl.program.TextureProgram;
import com.tencent.av.opengl.program.TextureProgramFactory;
import com.tencent.av.opengl.shader.ShaderParameter;
import com.tencent.av.ui.GLVideoView;
import com.tencent.mobileqq.utils.DeviceInfoUtil;
import java.util.List;

public class YuvFboTexture
  extends YUVTexture
{
  public static int B = 480;
  private static boolean C = false;
  private static boolean D = false;
  private static int E = 1;
  private static String F;
  private static String G;
  private FrameBufferCenterTexture H = null;
  private GLVideoView I;
  
  public YuvFboTexture(Context paramContext, GLVideoView paramGLVideoView, String paramString, long paramLong)
  {
    super(paramContext, paramString, paramLong);
    this.I = paramGLVideoView;
  }
  
  private static void a(Context paramContext)
  {
    if (C) {
      return;
    }
    C = true;
    if (F == null) {
      F = DeviceInfoUtil.e();
    }
    paramContext = RendererConfig.a();
    D = false;
    if ((paramContext != null) && (paramContext.a == 1))
    {
      B = paramContext.b;
      E = paramContext.c;
      G = paramContext.d;
    }
    try
    {
      if ((!TextUtils.isEmpty(G)) && (!TextUtils.isEmpty(F)))
      {
        paramContext = G.split("\\.");
        String[] arrayOfString = F.split("\\.");
        int i = 0;
        while ((i < 3) && (i < paramContext.length) && (i < arrayOfString.length))
        {
          if (Integer.valueOf(arrayOfString[i]).intValue() > Integer.valueOf(paramContext[i]).intValue())
          {
            D = true;
            return;
          }
          if (Integer.valueOf(arrayOfString[i]).intValue() < Integer.valueOf(paramContext[i]).intValue())
          {
            D = false;
            return;
          }
          if (i == 2) {
            D = true;
          }
          i += 1;
        }
      }
      return;
    }
    catch (Exception paramContext) {}
  }
  
  public ShaderParameter[] c(GLCanvas paramGLCanvas)
  {
    int i;
    if (a() > b()) {
      i = a();
    } else {
      i = b();
    }
    a(this.o);
    if ((D) && (getImgWidth() <= B) && (i > ((GLES20Canvas)paramGLCanvas).i() / 3 * 2) && (getImgWidth() < i) && (getImgWidth() != 0) && (this.I.a().size() == 0) && (VideoController.f().k().g == 2)) {
      i = 1;
    } else {
      i = 0;
    }
    if (i != 0)
    {
      if (this.H == null) {
        this.H = FrameBufferCenterTexture.a();
      }
      super.b(paramGLCanvas);
      if (super.e() != null)
      {
        FrameBufferCenterTexture localFrameBufferCenterTexture = this.H;
        i = getImgWidth();
        int j = getImgHeight();
        GLES20Canvas localGLES20Canvas = (GLES20Canvas)paramGLCanvas;
        localFrameBufferCenterTexture.a(paramGLCanvas, i, j, localGLES20Canvas.i(), localGLES20Canvas.j(), e()[0], e()[1], e()[2], this.r, this.x, E);
      }
      return TextureProgramFactory.a(0).b();
    }
    return super.c(paramGLCanvas);
  }
  
  public void o()
  {
    super.o();
    FrameBufferCenterTexture localFrameBufferCenterTexture = this.H;
    if (localFrameBufferCenterTexture != null) {
      localFrameBufferCenterTexture.b();
    }
    C = false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.opengl.texture.YuvFboTexture
 * JD-Core Version:    0.7.0.1
 */