package com.tencent.av.opengl.effects;

import com.tencent.av.AVLog;
import com.tencent.av.camera.AndroidCamera;
import com.tencent.av.opengl.GraphicRenderMgr;
import com.tencent.av.utils.FramePerfData;
import com.tencent.av.utils.PerfRecorder;
import com.tencent.av.video.effect.core.EffectTexture;
import com.tencent.av.video.effect.denoise.DenoiseRender;
import com.tencent.av.video.effect.lowlight.LowLightRender;
import com.tencent.av.video.effect.utils.LowLightUtils;
import com.tencent.qphone.base.util.QLog;

public class LightAndNoiseDeal
{
  private final FilterProcessRender jdField_a_of_type_ComTencentAvOpenglEffectsFilterProcessRender;
  private DenoiseRender jdField_a_of_type_ComTencentAvVideoEffectDenoiseDenoiseRender;
  private LowLightRender jdField_a_of_type_ComTencentAvVideoEffectLowlightLowLightRender;
  private String jdField_a_of_type_JavaLangString;
  public boolean a;
  public int[] a;
  
  private GLTexture a(GLTexture paramGLTexture)
  {
    if (!LowlightAndDenoiseTools.c()) {
      this.jdField_a_of_type_ArrayOfInt[3] = 0;
    }
    do
    {
      return paramGLTexture;
      if (!this.jdField_a_of_type_Boolean)
      {
        this.jdField_a_of_type_ArrayOfInt[3] = 0;
        return paramGLTexture;
      }
      localObject = a();
    } while (localObject == null);
    this.jdField_a_of_type_ComTencentAvOpenglEffectsFilterProcessRender.a(4);
    paramGLTexture = ((DenoiseRender)localObject).process(paramGLTexture.jdField_b_of_type_Int, paramGLTexture.jdField_a_of_type_Int, this.jdField_a_of_type_ComTencentAvOpenglEffectsFilterProcessRender.jdField_a_of_type_Int, this.jdField_a_of_type_ComTencentAvOpenglEffectsFilterProcessRender.jdField_b_of_type_Int);
    paramGLTexture = GLTexture.a(paramGLTexture.getFbo(), paramGLTexture.getTextureId());
    this.jdField_a_of_type_ArrayOfInt[3] = 1;
    Object localObject = this.jdField_a_of_type_ArrayOfInt;
    localObject[5] += 1;
    return paramGLTexture;
  }
  
  private GLTexture a(GLTexture paramGLTexture, boolean paramBoolean)
  {
    if (!LowlightAndDenoiseTools.b()) {
      this.jdField_a_of_type_ArrayOfInt[0] = 0;
    }
    do
    {
      return paramGLTexture;
      if ((!this.jdField_a_of_type_Boolean) || (paramBoolean))
      {
        this.jdField_a_of_type_ArrayOfInt[0] = 0;
        return paramGLTexture;
      }
      localObject = a();
    } while (localObject == null);
    this.jdField_a_of_type_ComTencentAvOpenglEffectsFilterProcessRender.a(2);
    paramGLTexture = ((LowLightRender)localObject).process(paramGLTexture.jdField_b_of_type_Int, paramGLTexture.jdField_a_of_type_Int, this.jdField_a_of_type_ComTencentAvOpenglEffectsFilterProcessRender.jdField_a_of_type_Int, this.jdField_a_of_type_ComTencentAvOpenglEffectsFilterProcessRender.jdField_b_of_type_Int);
    paramGLTexture = GLTexture.a(paramGLTexture.getFbo(), paramGLTexture.getTextureId());
    this.jdField_a_of_type_ArrayOfInt[0] = 1;
    Object localObject = this.jdField_a_of_type_ArrayOfInt;
    localObject[2] += 1;
    return paramGLTexture;
  }
  
  private void a(byte[] paramArrayOfByte, long paramLong, boolean paramBoolean)
  {
    int j = 0;
    int i = 0;
    if ((LowlightAndDenoiseTools.b()) || (LowlightAndDenoiseTools.c()))
    {
      this.jdField_a_of_type_ComTencentAvOpenglEffectsFilterProcessRender.a(1);
      paramArrayOfByte = a(this.jdField_a_of_type_JavaLangString, paramArrayOfByte, (int)paramLong);
      j = paramArrayOfByte[0];
      i = paramArrayOfByte[1];
    }
    paramArrayOfByte = this.jdField_a_of_type_ArrayOfInt;
    if (j == 1) {}
    for (boolean bool = true;; bool = false)
    {
      if ((!this.jdField_a_of_type_Boolean) && (bool))
      {
        if (!paramBoolean) {
          paramArrayOfByte[1] += 1;
        }
        paramArrayOfByte[4] += 1;
        AVLog.printDebugLog(this.jdField_a_of_type_JavaLangString, " This is the " + paramArrayOfByte[2] + " times open lowlightand the " + paramArrayOfByte[4] + " times open videodenoise");
        AVLog.printDebugLog(this.jdField_a_of_type_JavaLangString, " The LowlightInfo is: lowlight flag = " + paramArrayOfByte[0] + ", video denoise flag = " + paramArrayOfByte[3] + ", lowlight open times = " + paramArrayOfByte[1] + ", denoise open times = " + paramArrayOfByte[4] + ", average luma = " + paramArrayOfByte[6]);
      }
      paramArrayOfByte[6] = i;
      if (j == 0)
      {
        paramArrayOfByte[0] = 0;
        paramArrayOfByte[3] = 0;
        GraphicRenderMgr.getInstance().setLowlightAndVideoDenoiseInfo(paramArrayOfByte);
      }
      paramArrayOfByte[7] = ((int)paramLong);
      this.jdField_a_of_type_Boolean = bool;
      return;
    }
  }
  
  private boolean a()
  {
    if (!LowlightAndDenoiseTools.c()) {}
    while (!this.jdField_a_of_type_Boolean) {
      return false;
    }
    return true;
  }
  
  private boolean a(boolean paramBoolean)
  {
    if (!LowlightAndDenoiseTools.b()) {}
    while ((!this.jdField_a_of_type_Boolean) || (paramBoolean)) {
      return false;
    }
    return true;
  }
  
  private static int[] a(String paramString, byte[] paramArrayOfByte, int paramInt)
  {
    int[] arrayOfInt = new int[2];
    if (AndroidCamera.jdField_a_of_type_Int * AndroidCamera.jdField_b_of_type_Int * 3 / 2 != paramArrayOfByte.length)
    {
      AVLog.printErrorLog(paramString, "(AndroidCamera.PREVIEW_WIDTH * AndroidCamera.PREVIEW_HEIGHT * 3 / 2) != yuvData.length");
      return arrayOfInt;
    }
    try
    {
      paramString = LowLightUtils.DetectLowLight(paramArrayOfByte, paramInt, AndroidCamera.jdField_a_of_type_Int, AndroidCamera.jdField_b_of_type_Int, 60, 0.75F);
      return paramString;
    }
    catch (UnsatisfiedLinkError paramString)
    {
      for (;;)
      {
        QLog.i("FilterProcessRender", 1, "detectLowLightProcess", paramString);
        paramString = arrayOfInt;
      }
    }
    catch (Throwable paramString)
    {
      for (;;)
      {
        QLog.i("FilterProcessRender", 1, "detectLowLightProcess", paramString);
        paramString = arrayOfInt;
      }
    }
  }
  
  public DenoiseRender a()
  {
    if (this.jdField_a_of_type_ComTencentAvVideoEffectDenoiseDenoiseRender == null) {
      this.jdField_a_of_type_ComTencentAvVideoEffectDenoiseDenoiseRender = new DenoiseRender(this.jdField_a_of_type_ComTencentAvOpenglEffectsFilterProcessRender.jdField_a_of_type_AndroidContentContext);
    }
    this.jdField_a_of_type_ComTencentAvVideoEffectDenoiseDenoiseRender.setUpdateRate(LowlightAndDenoiseTools.a());
    return this.jdField_a_of_type_ComTencentAvVideoEffectDenoiseDenoiseRender;
  }
  
  public LowLightRender a()
  {
    if (this.jdField_a_of_type_ComTencentAvVideoEffectLowlightLowLightRender == null) {
      this.jdField_a_of_type_ComTencentAvVideoEffectLowlightLowLightRender = new LowLightRender(this.jdField_a_of_type_ComTencentAvOpenglEffectsFilterProcessRender.jdField_a_of_type_AndroidContentContext);
    }
    return this.jdField_a_of_type_ComTencentAvVideoEffectLowlightLowLightRender;
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_ComTencentAvVideoEffectDenoiseDenoiseRender != null)
    {
      this.jdField_a_of_type_ComTencentAvVideoEffectDenoiseDenoiseRender.destroy();
      this.jdField_a_of_type_ComTencentAvVideoEffectDenoiseDenoiseRender = null;
    }
    if (this.jdField_a_of_type_ComTencentAvVideoEffectLowlightLowLightRender != null)
    {
      this.jdField_a_of_type_ComTencentAvVideoEffectLowlightLowLightRender.destroy();
      this.jdField_a_of_type_ComTencentAvVideoEffectLowlightLowLightRender = null;
    }
  }
  
  public void a(PerfRecorder paramPerfRecorder, CameraFrame paramCameraFrame, FramePerfData paramFramePerfData)
  {
    if (paramPerfRecorder != null) {
      paramPerfRecorder.a("checkLowLight");
    }
    a(paramCameraFrame.jdField_a_of_type_ArrayOfByte, paramCameraFrame.jdField_a_of_type_Long, paramCameraFrame.jdField_a_of_type_Boolean);
    if (paramFramePerfData != null) {
      paramFramePerfData.e();
    }
    if (paramPerfRecorder != null) {
      paramPerfRecorder.b("checkLowLight");
    }
  }
  
  public void a(PerfRecorder paramPerfRecorder, FramePerfData paramFramePerfData)
  {
    this.jdField_a_of_type_ComTencentAvOpenglEffectsFilterProcessRender.c();
    if (a())
    {
      if (paramPerfRecorder != null) {
        paramPerfRecorder.a("appleVideoDeNoise");
      }
      this.jdField_a_of_type_ComTencentAvOpenglEffectsFilterProcessRender.jdField_b_of_type_ComTencentAvOpenglEffectsGLTexture = a(this.jdField_a_of_type_ComTencentAvOpenglEffectsFilterProcessRender.jdField_a_of_type_ComTencentAvOpenglEffectsGLTexture);
      if (paramFramePerfData != null) {
        if (this.jdField_a_of_type_ComTencentAvOpenglEffectsFilterProcessRender.jdField_b_of_type_ComTencentAvOpenglEffectsGLTexture.jdField_b_of_type_Int == this.jdField_a_of_type_ComTencentAvOpenglEffectsFilterProcessRender.jdField_a_of_type_ComTencentAvOpenglEffectsGLTexture.jdField_b_of_type_Int) {
          break label110;
        }
      }
    }
    label110:
    for (boolean bool = true;; bool = false)
    {
      paramFramePerfData.b(bool);
      if (paramPerfRecorder != null) {
        paramPerfRecorder.b("appleVideoDeNoise");
      }
      this.jdField_a_of_type_ComTencentAvOpenglEffectsFilterProcessRender.a(6, this.jdField_a_of_type_ComTencentAvOpenglEffectsFilterProcessRender.jdField_a_of_type_ComTencentAvOpenglEffectsGLTexture, this.jdField_a_of_type_ComTencentAvOpenglEffectsFilterProcessRender.jdField_b_of_type_ComTencentAvOpenglEffectsGLTexture);
      return;
    }
  }
  
  public void b(PerfRecorder paramPerfRecorder, CameraFrame paramCameraFrame, FramePerfData paramFramePerfData)
  {
    this.jdField_a_of_type_ComTencentAvOpenglEffectsFilterProcessRender.c();
    if (a(paramCameraFrame.jdField_a_of_type_Boolean))
    {
      if (paramPerfRecorder != null) {
        paramPerfRecorder.a("appleLowLightEnhance");
      }
      this.jdField_a_of_type_ComTencentAvOpenglEffectsFilterProcessRender.jdField_b_of_type_ComTencentAvOpenglEffectsGLTexture = a(this.jdField_a_of_type_ComTencentAvOpenglEffectsFilterProcessRender.jdField_a_of_type_ComTencentAvOpenglEffectsGLTexture, paramCameraFrame.jdField_a_of_type_Boolean);
      if (paramPerfRecorder != null) {
        paramPerfRecorder.b("appleLowLightEnhance");
      }
      this.jdField_a_of_type_ComTencentAvOpenglEffectsFilterProcessRender.a(7, this.jdField_a_of_type_ComTencentAvOpenglEffectsFilterProcessRender.jdField_a_of_type_ComTencentAvOpenglEffectsGLTexture, this.jdField_a_of_type_ComTencentAvOpenglEffectsFilterProcessRender.jdField_b_of_type_ComTencentAvOpenglEffectsGLTexture);
    }
    GraphicRenderMgr.getInstance().setLowlightAndVideoDenoiseInfo(this.jdField_a_of_type_ArrayOfInt);
    if (paramFramePerfData != null) {
      if (this.jdField_a_of_type_ComTencentAvOpenglEffectsFilterProcessRender.jdField_b_of_type_ComTencentAvOpenglEffectsGLTexture.jdField_b_of_type_Int == this.jdField_a_of_type_ComTencentAvOpenglEffectsFilterProcessRender.jdField_a_of_type_ComTencentAvOpenglEffectsGLTexture.jdField_b_of_type_Int) {
        break label130;
      }
    }
    label130:
    for (boolean bool = true;; bool = false)
    {
      paramFramePerfData.c(bool);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.av.opengl.effects.LightAndNoiseDeal
 * JD-Core Version:    0.7.0.1
 */