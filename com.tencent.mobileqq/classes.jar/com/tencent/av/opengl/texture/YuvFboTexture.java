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
  private static String jdField_a_of_type_JavaLangString;
  private static String b;
  private static boolean e = false;
  private static boolean f = false;
  public static int o = 480;
  private static int p = 1;
  private FrameBufferCenterTexture jdField_a_of_type_ComTencentAvOpenglTextureFrameBufferCenterTexture = null;
  private GLVideoView jdField_a_of_type_ComTencentAvUiGLVideoView;
  
  public YuvFboTexture(Context paramContext, GLVideoView paramGLVideoView, String paramString, long paramLong)
  {
    super(paramContext, paramString, paramLong);
    this.jdField_a_of_type_ComTencentAvUiGLVideoView = paramGLVideoView;
  }
  
  private static void a(Context paramContext)
  {
    if (e) {
      return;
    }
    e = true;
    if (jdField_a_of_type_JavaLangString == null) {
      jdField_a_of_type_JavaLangString = DeviceInfoUtil.c();
    }
    paramContext = RendererConfig.a();
    f = false;
    if ((paramContext != null) && (paramContext.jdField_a_of_type_Int == 1))
    {
      o = paramContext.b;
      p = paramContext.c;
      jdField_b_of_type_JavaLangString = paramContext.jdField_a_of_type_JavaLangString;
    }
    try
    {
      if ((!TextUtils.isEmpty(jdField_b_of_type_JavaLangString)) && (!TextUtils.isEmpty(jdField_a_of_type_JavaLangString)))
      {
        paramContext = jdField_b_of_type_JavaLangString.split("\\.");
        String[] arrayOfString = jdField_a_of_type_JavaLangString.split("\\.");
        int i = 0;
        while ((i < 3) && (i < paramContext.length) && (i < arrayOfString.length))
        {
          if (Integer.valueOf(arrayOfString[i]).intValue() > Integer.valueOf(paramContext[i]).intValue())
          {
            f = true;
            return;
          }
          if (Integer.valueOf(arrayOfString[i]).intValue() < Integer.valueOf(paramContext[i]).intValue())
          {
            f = false;
            return;
          }
          if (i == 2) {
            f = true;
          }
          i += 1;
        }
      }
      return;
    }
    catch (Exception paramContext) {}
  }
  
  public ShaderParameter[] a(GLCanvas paramGLCanvas)
  {
    int i;
    if (a() > b()) {
      i = a();
    } else {
      i = b();
    }
    a(this.jdField_a_of_type_AndroidContentContext);
    if ((f) && (getImgWidth() <= o) && (i > ((GLES20Canvas)paramGLCanvas).c() / 3 * 2) && (getImgWidth() < i) && (getImgWidth() != 0) && (this.jdField_a_of_type_ComTencentAvUiGLVideoView.a().size() == 0) && (VideoController.a().a().d == 2)) {
      i = 1;
    } else {
      i = 0;
    }
    if (i != 0)
    {
      if (this.jdField_a_of_type_ComTencentAvOpenglTextureFrameBufferCenterTexture == null) {
        this.jdField_a_of_type_ComTencentAvOpenglTextureFrameBufferCenterTexture = FrameBufferCenterTexture.a();
      }
      super.a(paramGLCanvas);
      if (super.a() != null)
      {
        FrameBufferCenterTexture localFrameBufferCenterTexture = this.jdField_a_of_type_ComTencentAvOpenglTextureFrameBufferCenterTexture;
        i = getImgWidth();
        int j = getImgHeight();
        GLES20Canvas localGLES20Canvas = (GLES20Canvas)paramGLCanvas;
        localFrameBufferCenterTexture.a(paramGLCanvas, i, j, localGLES20Canvas.c(), localGLES20Canvas.d(), a()[0], a()[1], a()[2], this.jdField_b_of_type_ArrayOfFloat, this.k, p);
      }
      return TextureProgramFactory.a(0).a();
    }
    return super.a(paramGLCanvas);
  }
  
  public void b()
  {
    super.b();
    FrameBufferCenterTexture localFrameBufferCenterTexture = this.jdField_a_of_type_ComTencentAvOpenglTextureFrameBufferCenterTexture;
    if (localFrameBufferCenterTexture != null) {
      localFrameBufferCenterTexture.a();
    }
    e = false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.opengl.texture.YuvFboTexture
 * JD-Core Version:    0.7.0.1
 */