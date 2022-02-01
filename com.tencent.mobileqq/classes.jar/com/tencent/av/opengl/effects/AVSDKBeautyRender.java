package com.tencent.av.opengl.effects;

import com.tencent.av.AVLog;
import com.tencent.av.AVPathUtil;
import com.tencent.av.camera.AndroidCamera;
import com.tencent.av.opengl.GraphicRenderMgr;
import com.tencent.av.utils.FramePerfData;
import com.tencent.av.utils.PerfRecorder;
import com.tencent.av.video.effect.beauty.Beauty20Render;
import com.tencent.av.video.effect.beauty.BeautyRender;
import com.tencent.av.video.effect.core.BeautyNative;
import com.tencent.av.video.effect.core.EffectFrame;
import com.tencent.av.video.effect.core.EffectTexture;
import com.tencent.av.video.effect.utils.ColorFormat;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.richmedia.capture.data.FilterDesc;
import com.tencent.mobileqq.utils.AudioHelper;
import com.tencent.qphone.base.util.QLog;

public class AVSDKBeautyRender
{
  int jdField_a_of_type_Int = 0;
  Beauty20Render jdField_a_of_type_ComTencentAvVideoEffectBeautyBeauty20Render = null;
  BeautyRender jdField_a_of_type_ComTencentAvVideoEffectBeautyBeautyRender = null;
  int b = 0;
  
  public AVSDKBeautyRender()
  {
    if (QLog.isColorLevel()) {
      QLog.i("AVSDKBeautyRender", 2, "AVSDKBeautyRender");
    }
  }
  
  public GLTexture a(int paramInt1, int paramInt2, GLTexture paramGLTexture, FilterDesc paramFilterDesc, int paramInt3)
  {
    if (!EffectBeautyTools.a()) {}
    BeautyRender localBeautyRender;
    do
    {
      do
      {
        return paramGLTexture;
      } while ((paramFilterDesc != null) && (paramFilterDesc.id == 3));
      localBeautyRender = a(paramInt3);
    } while (localBeautyRender == null);
    GraphicRenderMgr.getInstance().setBeautyFlag(2);
    if ((paramFilterDesc != null) && ((paramFilterDesc.id == 1) || (paramFilterDesc.id == 2))) {
      localBeautyRender.setNeedSkinColor(false);
    }
    for (;;)
    {
      paramGLTexture = localBeautyRender.process(paramGLTexture.b, paramGLTexture.jdField_a_of_type_Int, paramInt1, paramInt2);
      return GLTexture.a(paramGLTexture.getFbo(), paramGLTexture.getTextureId());
      localBeautyRender.setNeedSkinColor(true);
    }
  }
  
  public Beauty20Render a(int paramInt)
  {
    if (paramInt == 0)
    {
      this.b = 0;
      return null;
    }
    if (this.jdField_a_of_type_ComTencentAvVideoEffectBeautyBeauty20Render == null) {
      this.jdField_a_of_type_ComTencentAvVideoEffectBeautyBeauty20Render = new Beauty20Render(BaseApplicationImpl.getContext());
    }
    if (paramInt == this.b) {
      return this.jdField_a_of_type_ComTencentAvVideoEffectBeautyBeauty20Render;
    }
    this.jdField_a_of_type_ComTencentAvVideoEffectBeautyBeauty20Render.setBeautyLevel(paramInt * 1.0F / 100.0F);
    this.b = paramInt;
    return this.jdField_a_of_type_ComTencentAvVideoEffectBeautyBeauty20Render;
  }
  
  public BeautyRender a(int paramInt)
  {
    if (paramInt == 0)
    {
      this.jdField_a_of_type_Int = 0;
      return null;
    }
    if (this.jdField_a_of_type_ComTencentAvVideoEffectBeautyBeautyRender == null) {
      this.jdField_a_of_type_ComTencentAvVideoEffectBeautyBeautyRender = new BeautyRender(BaseApplicationImpl.getContext(), AVPathUtil.i());
    }
    if (paramInt == this.jdField_a_of_type_Int) {
      return this.jdField_a_of_type_ComTencentAvVideoEffectBeautyBeautyRender;
    }
    this.jdField_a_of_type_ComTencentAvVideoEffectBeautyBeautyRender.setBeautyLevel(paramInt * 1.0F / 100.0F * EffectBeautyTools.a());
    this.jdField_a_of_type_Int = paramInt;
    return this.jdField_a_of_type_ComTencentAvVideoEffectBeautyBeautyRender;
  }
  
  public void a()
  {
    b();
    if (this.jdField_a_of_type_ComTencentAvVideoEffectBeautyBeautyRender != null)
    {
      this.jdField_a_of_type_ComTencentAvVideoEffectBeautyBeautyRender.destroy();
      this.jdField_a_of_type_ComTencentAvVideoEffectBeautyBeautyRender = null;
    }
    if (this.jdField_a_of_type_ComTencentAvVideoEffectBeautyBeauty20Render != null)
    {
      this.jdField_a_of_type_ComTencentAvVideoEffectBeautyBeauty20Render.destroy();
      this.jdField_a_of_type_ComTencentAvVideoEffectBeautyBeauty20Render = null;
    }
    if (QLog.isColorLevel()) {
      QLog.i("AVSDKBeautyRender", 2, "destroy");
    }
  }
  
  public void a(int paramInt)
  {
    if (paramInt == 0) {}
    try
    {
      GraphicRenderMgr.getInstance().setBeautyFlag(0);
      return;
    }
    catch (UnsatisfiedLinkError localUnsatisfiedLinkError)
    {
      if (!AudioHelper.e()) {
        return;
      }
      QLog.w("AVSDKBeautyRender", 1, "setBeautyLevel, UnsatisfiedLinkError");
      return;
      GraphicRenderMgr.getInstance().setBeautyFlag(1);
    }
    if (EffectBeautyTools.a())
    {
      GraphicRenderMgr.getInstance().setBeautyFlag(2);
      return;
    }
  }
  
  public void a(FilterProcessRender paramFilterProcessRender, PerfRecorder paramPerfRecorder, CameraFrame paramCameraFrame, FramePerfData paramFramePerfData, RenderParams paramRenderParams, int paramInt1, int paramInt2, int paramInt3)
  {
    if (!paramCameraFrame.b()) {
      return;
    }
    if (paramPerfRecorder != null) {
      paramPerfRecorder.a("applyBeauty20");
    }
    byte[] arrayOfByte = paramCameraFrame.a;
    paramCameraFrame.a = a(paramInt1, paramInt2, paramCameraFrame.a, paramRenderParams.a, paramInt3);
    if (paramCameraFrame.a != arrayOfByte) {
      paramFilterProcessRender.a(8);
    }
    if (paramFramePerfData != null) {
      if (paramCameraFrame.a == arrayOfByte) {
        break label116;
      }
    }
    label116:
    for (boolean bool = true;; bool = false)
    {
      paramFramePerfData.a(bool);
      if (paramPerfRecorder != null) {
        paramPerfRecorder.b("applyBeauty20");
      }
      if (paramFilterProcessRender.jdField_a_of_type_ComTencentAvOpenglEffectsFilterProcessTest == null) {
        break;
      }
      paramFilterProcessRender.jdField_a_of_type_ComTencentAvOpenglEffectsFilterProcessTest.a(paramFilterProcessRender, 10, paramCameraFrame, null);
      return;
    }
  }
  
  public void a(FilterProcessRender paramFilterProcessRender, PerfRecorder paramPerfRecorder, FramePerfData paramFramePerfData, RenderParams paramRenderParams, int paramInt1, int paramInt2, int paramInt3)
  {
    paramFilterProcessRender.c();
    if (paramPerfRecorder != null) {
      paramPerfRecorder.a("applyBeauty30");
    }
    paramFilterProcessRender.b = a(paramInt1, paramInt2, paramFilterProcessRender.jdField_a_of_type_ComTencentAvOpenglEffectsGLTexture, paramRenderParams.a, paramInt3);
    if (paramFilterProcessRender.b.b != paramFilterProcessRender.jdField_a_of_type_ComTencentAvOpenglEffectsGLTexture.b) {
      paramFilterProcessRender.a(8);
    }
    if (paramFramePerfData != null) {
      if (paramFilterProcessRender.b.b == paramFilterProcessRender.jdField_a_of_type_ComTencentAvOpenglEffectsGLTexture.b) {
        break label115;
      }
    }
    label115:
    for (boolean bool = true;; bool = false)
    {
      paramFramePerfData.d(bool);
      if (paramPerfRecorder != null) {
        paramPerfRecorder.b("applyBeauty30");
      }
      paramFilterProcessRender.a(8, paramFilterProcessRender.jdField_a_of_type_ComTencentAvOpenglEffectsGLTexture, paramFilterProcessRender.b);
      return;
    }
  }
  
  public boolean a(int paramInt)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (EffectBeautyTools.a())
    {
      bool1 = bool2;
      if (paramInt > 0) {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  public byte[] a(int paramInt1, int paramInt2, byte[] paramArrayOfByte, FilterDesc paramFilterDesc, int paramInt3)
  {
    if (EffectBeautyTools.a()) {}
    while ((paramFilterDesc != null) && (paramFilterDesc.id == 3)) {
      return paramArrayOfByte;
    }
    if (paramInt2 * paramInt1 * 3 / 2 != paramArrayOfByte.length)
    {
      AVLog.printErrorLog("AVSDKBeautyRender", "(mHeight * mWidth * 3 / 2) != yuvData.length");
      return paramArrayOfByte;
    }
    paramFilterDesc = a(paramInt3);
    EffectFrame localEffectFrame1;
    if (paramFilterDesc != null)
    {
      GraphicRenderMgr.getInstance().setBeautyFlag(1);
      localEffectFrame1 = new EffectFrame();
      localEffectFrame1.frameData = paramArrayOfByte;
      localEffectFrame1.frameWidth = paramInt2;
      localEffectFrame1.frameHeight = paramInt1;
      if (AndroidCamera.c == 17)
      {
        paramArrayOfByte = ColorFormat.NV21;
        localEffectFrame1.frameFormat = paramArrayOfByte;
        EffectFrame localEffectFrame2 = paramFilterDesc.processData(localEffectFrame1);
        paramFilterDesc = localEffectFrame2.frameData;
        paramArrayOfByte = paramFilterDesc;
        if (localEffectFrame2.frameFormat != ColorFormat.I420) {}
      }
    }
    for (;;)
    {
      try
      {
        if (AndroidCamera.c == 17)
        {
          paramArrayOfByte = BeautyNative.convertI420ToNV21(paramFilterDesc, paramInt2, paramInt1);
          return paramArrayOfByte;
          paramArrayOfByte = ColorFormat.NV12;
          break;
        }
        paramArrayOfByte = BeautyNative.convertI420ToNV12(paramFilterDesc, paramInt2, paramInt1);
      }
      catch (Throwable paramArrayOfByte)
      {
        AVLog.printErrorLog("AVSDKBeautyRender", "convertI420ToNV21 or convertI420ToNV12 e = " + paramArrayOfByte.getMessage());
        paramArrayOfByte = localEffectFrame1.frameData;
      }
    }
  }
  
  public void b()
  {
    GraphicRenderMgr.getInstance().setBeautyFlag(0);
    if (QLog.isColorLevel()) {
      QLog.i("AVSDKBeautyRender", 2, "clear");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.av.opengl.effects.AVSDKBeautyRender
 * JD-Core Version:    0.7.0.1
 */