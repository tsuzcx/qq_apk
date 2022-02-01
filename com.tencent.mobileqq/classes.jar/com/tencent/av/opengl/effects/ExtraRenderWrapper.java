package com.tencent.av.opengl.effects;

import com.tencent.av.business.manager.pendant.PendantItem;
import com.tencent.av.utils.PerfRecorder;

public class ExtraRenderWrapper
{
  public int a;
  private ExtraTextureRender jdField_a_of_type_ComTencentAvOpenglEffectsExtraTextureRender = null;
  private FilterProcessRender jdField_a_of_type_ComTencentAvOpenglEffectsFilterProcessRender;
  private int b = 0;
  
  public ExtraRenderWrapper(FilterProcessRender paramFilterProcessRender)
  {
    this.jdField_a_of_type_Int = 0;
    this.jdField_a_of_type_ComTencentAvOpenglEffectsFilterProcessRender = paramFilterProcessRender;
  }
  
  public int a(CameraFrame paramCameraFrame, RenderParams paramRenderParams)
  {
    int j = 0;
    int i = j;
    if (paramRenderParams.jdField_a_of_type_ComTencentAvBusinessManagerPendantPendantItem != null)
    {
      i = j;
      if (paramRenderParams.jdField_a_of_type_ComTencentTtpicOpenapiModelVideoMaterial != null)
      {
        i = j;
        if (paramRenderParams.jdField_a_of_type_ComTencentAvBusinessManagerPendantPendantItem.needHMirror) {
          i = 1;
        }
      }
    }
    return i;
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_ComTencentAvOpenglEffectsExtraTextureRender == null) {
      this.jdField_a_of_type_ComTencentAvOpenglEffectsExtraTextureRender = new ExtraTextureRender();
    }
  }
  
  public void a(CameraFrame paramCameraFrame, RenderParams paramRenderParams)
  {
    this.b = a(paramCameraFrame, paramRenderParams);
  }
  
  public void a(CameraFrame paramCameraFrame, RenderParams paramRenderParams, GLTexture paramGLTexture, int paramInt1, int paramInt2)
  {
    if (this.jdField_a_of_type_ComTencentAvOpenglEffectsExtraTextureRender == null) {}
    do
    {
      do
      {
        return;
        this.jdField_a_of_type_Int = a(paramCameraFrame, paramRenderParams);
        this.jdField_a_of_type_ComTencentAvOpenglEffectsExtraTextureRender.a(this.jdField_a_of_type_Int);
      } while (!this.jdField_a_of_type_ComTencentAvOpenglEffectsExtraTextureRender.a());
      if (this.jdField_a_of_type_ComTencentAvOpenglEffectsFilterProcessRender.a != null) {
        this.jdField_a_of_type_ComTencentAvOpenglEffectsFilterProcessRender.a.a("extraRenderIn");
      }
      paramCameraFrame = this.jdField_a_of_type_ComTencentAvOpenglEffectsExtraTextureRender.a(paramGLTexture, paramInt1, paramInt2);
      if (paramCameraFrame != null)
      {
        this.jdField_a_of_type_ComTencentAvOpenglEffectsFilterProcessRender.a(11, paramGLTexture, paramCameraFrame);
        paramGLTexture.jdField_a_of_type_Int = paramCameraFrame.jdField_a_of_type_Int;
        paramGLTexture.b = paramCameraFrame.b;
        paramCameraFrame.a();
      }
    } while (this.jdField_a_of_type_ComTencentAvOpenglEffectsFilterProcessRender.a == null);
    this.jdField_a_of_type_ComTencentAvOpenglEffectsFilterProcessRender.a.b("extraRenderIn");
  }
  
  public void a(GLTexture paramGLTexture, boolean paramBoolean1, boolean paramBoolean2, int paramInt1, int paramInt2)
  {
    int j = 0;
    if (this.jdField_a_of_type_ComTencentAvOpenglEffectsExtraTextureRender == null) {
      return;
    }
    if ((!paramBoolean1) && (!paramBoolean2))
    {
      i = j;
      label23:
      if (i == 0) {
        break label201;
      }
    }
    label201:
    for (int i = this.b;; i = this.jdField_a_of_type_Int)
    {
      this.jdField_a_of_type_ComTencentAvOpenglEffectsExtraTextureRender.a(i);
      if (!this.jdField_a_of_type_ComTencentAvOpenglEffectsExtraTextureRender.a()) {
        break;
      }
      if (this.jdField_a_of_type_ComTencentAvOpenglEffectsFilterProcessRender.a != null) {
        this.jdField_a_of_type_ComTencentAvOpenglEffectsFilterProcessRender.a.a("extraRenderOut");
      }
      GLTexture localGLTexture = this.jdField_a_of_type_ComTencentAvOpenglEffectsExtraTextureRender.a(paramGLTexture, paramInt1, paramInt2);
      if (localGLTexture != null)
      {
        this.jdField_a_of_type_ComTencentAvOpenglEffectsFilterProcessRender.a(12, paramGLTexture, localGLTexture);
        paramGLTexture.jdField_a_of_type_Int = localGLTexture.jdField_a_of_type_Int;
        paramGLTexture.b = localGLTexture.b;
        localGLTexture.a();
      }
      if (this.jdField_a_of_type_ComTencentAvOpenglEffectsFilterProcessRender.a == null) {
        break;
      }
      this.jdField_a_of_type_ComTencentAvOpenglEffectsFilterProcessRender.a.b("extraRenderOut");
      return;
      if ((paramBoolean1) && (paramBoolean2))
      {
        i = 1;
        break label23;
      }
      if (!paramBoolean1)
      {
        i = j;
        if (paramBoolean2) {
          break label23;
        }
      }
      i = j;
      if (!paramBoolean1) {
        break label23;
      }
      i = j;
      if (paramBoolean2) {
        break label23;
      }
      i = j;
      break label23;
    }
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_ComTencentAvOpenglEffectsExtraTextureRender != null)
    {
      this.jdField_a_of_type_ComTencentAvOpenglEffectsExtraTextureRender.a();
      this.jdField_a_of_type_ComTencentAvOpenglEffectsExtraTextureRender = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.av.opengl.effects.ExtraRenderWrapper
 * JD-Core Version:    0.7.0.1
 */