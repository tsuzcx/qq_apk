package com.tencent.av.opengl.effects;

import android.annotation.TargetApi;
import android.content.Context;
import android.opengl.GLES20;
import com.tencent.av.camera.CameraUtils;
import com.tencent.av.opengl.utils.AVGLUtils;
import com.tencent.av.perfstat.MemoryPerfStat;
import com.tencent.av.utils.FramePerfData;
import com.tencent.av.utils.PerfRecorder;
import com.tencent.mobileqq.utils.AudioHelper;
import com.tencent.qphone.base.util.QLog;
import com.tencent.sveffects.SvEffectSdkInitor;
import dov.com.qq.im.ae.AEKitForQQ;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;

@TargetApi(17)
public class FilterProcessRender
{
  int jdField_a_of_type_Int = 0;
  protected Context a;
  private AEFilterAVWrapper jdField_a_of_type_ComTencentAvOpenglEffectsAEFilterAVWrapper = null;
  private AVSDKBeautyRender jdField_a_of_type_ComTencentAvOpenglEffectsAVSDKBeautyRender = null;
  private BeautyConfig jdField_a_of_type_ComTencentAvOpenglEffectsBeautyConfig = null;
  private ExtraRenderWrapper jdField_a_of_type_ComTencentAvOpenglEffectsExtraRenderWrapper = null;
  final FaceData jdField_a_of_type_ComTencentAvOpenglEffectsFaceData = new FaceData();
  protected FilterProcessRender.FaceDataWatcher a;
  protected FilterProcessTest a;
  protected GLTexture a;
  private LightAndNoiseDeal jdField_a_of_type_ComTencentAvOpenglEffectsLightAndNoiseDeal = null;
  protected PostRender a;
  protected PreRender a;
  private RenderInfoLog jdField_a_of_type_ComTencentAvOpenglEffectsRenderInfoLog = new RenderInfoLog();
  protected PerfRecorder a;
  final String jdField_a_of_type_JavaLangString = "FilterProcessRender_" + AudioHelper.b();
  protected FloatBuffer a;
  protected boolean a;
  int b;
  protected GLTexture b;
  protected boolean b;
  int jdField_c_of_type_Int = -1;
  private boolean jdField_c_of_type_Boolean = false;
  int d = -1;
  private int e = 0;
  
  public FilterProcessRender(Context paramContext, FilterProcessRender.FaceDataWatcher paramFaceDataWatcher, BeautyConfig paramBeautyConfig)
  {
    this.jdField_b_of_type_Int = 0;
    this.jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_ComTencentAvOpenglEffectsFilterProcessTest = null;
    this.jdField_a_of_type_ComTencentAvUtilsPerfRecorder = null;
    this.jdField_a_of_type_ComTencentAvOpenglEffectsGLTexture = null;
    this.jdField_b_of_type_ComTencentAvOpenglEffectsGLTexture = null;
    this.jdField_a_of_type_JavaNioFloatBuffer = null;
    this.jdField_a_of_type_ComTencentAvOpenglEffectsPreRender = null;
    this.jdField_a_of_type_ComTencentAvOpenglEffectsPostRender = null;
    this.jdField_b_of_type_Boolean = false;
    if (QLog.isColorLevel()) {
      this.jdField_a_of_type_ComTencentAvUtilsPerfRecorder = new PerfRecorder();
    }
    this.jdField_a_of_type_ComTencentAvOpenglEffectsFilterProcessRender$FaceDataWatcher = paramFaceDataWatcher;
    this.jdField_a_of_type_ComTencentAvOpenglEffectsBeautyConfig = paramBeautyConfig;
    SvEffectSdkInitor.a();
    AEKitForQQ.a();
    TipsInfo.a().a();
    this.jdField_c_of_type_Int = -1;
    RenderUtil.a();
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    paramContext = CameraUtils.a(this.jdField_a_of_type_AndroidContentContext).a();
    if (paramContext != null) {}
    for (this.jdField_a_of_type_ComTencentAvOpenglEffectsPreRender = new SurfacePreRender(paramContext);; this.jdField_a_of_type_ComTencentAvOpenglEffectsPreRender = new YUVPreRender())
    {
      this.jdField_a_of_type_ComTencentAvOpenglEffectsPostRender = new YuvPostRender(this.jdField_a_of_type_JavaLangString);
      this.jdField_a_of_type_ComTencentAvOpenglEffectsExtraRenderWrapper = new ExtraRenderWrapper(this);
      return;
    }
  }
  
  private void a(long paramLong, int paramInt1, int paramInt2)
  {
    if ((paramInt1 == 0) || (paramInt2 == 0) || ((this.jdField_a_of_type_Int == paramInt1) && (this.jdField_b_of_type_Int == paramInt2))) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.w(this.jdField_a_of_type_JavaLangString, 1, "innerUpdatePreviewSize, width[" + this.jdField_a_of_type_Int + "->" + paramInt1 + "], height[" + this.jdField_b_of_type_Int + "->" + paramInt2 + "], seq[" + paramLong + "]");
    }
    this.jdField_a_of_type_Int = paramInt1;
    this.jdField_b_of_type_Int = paramInt2;
    this.d = AVGLUtils.initFrameBuffer(paramInt1, paramInt2, this.jdField_c_of_type_Int);
    if (this.jdField_a_of_type_ComTencentAvOpenglEffectsPreRender != null) {
      this.jdField_a_of_type_ComTencentAvOpenglEffectsPreRender.a(paramInt1, paramInt2);
    }
    if (this.jdField_a_of_type_ComTencentAvOpenglEffectsPostRender != null) {
      this.jdField_a_of_type_ComTencentAvOpenglEffectsPostRender.a(paramInt1, paramInt2);
    }
    d();
    SvEffectSdkInitor.a();
  }
  
  private void a(CameraFrame paramCameraFrame)
  {
    if (this.jdField_b_of_type_ComTencentAvOpenglEffectsGLTexture == null)
    {
      this.jdField_b_of_type_ComTencentAvOpenglEffectsGLTexture = GLTexture.a(this.d, this.jdField_c_of_type_Int);
      if ((this.jdField_a_of_type_ComTencentAvOpenglEffectsPreRender != null) && (!this.jdField_a_of_type_ComTencentAvOpenglEffectsPreRender.a(paramCameraFrame)))
      {
        this.jdField_a_of_type_ComTencentAvOpenglEffectsPreRender.c();
        this.jdField_a_of_type_ComTencentAvOpenglEffectsPreRender.b();
        this.jdField_a_of_type_ComTencentAvOpenglEffectsPreRender = null;
        if (QLog.isDevelopLevel()) {
          QLog.i("SurfaceTag", 4, "preRender, not match frame.");
        }
      }
      if (this.jdField_a_of_type_ComTencentAvOpenglEffectsPreRender == null)
      {
        if (!paramCameraFrame.b()) {
          break label213;
        }
        this.jdField_a_of_type_ComTencentAvOpenglEffectsPreRender = new YUVPreRender();
        this.jdField_a_of_type_ComTencentAvOpenglEffectsPreRender.a();
        this.jdField_a_of_type_ComTencentAvOpenglEffectsPreRender.a(this.jdField_a_of_type_Int, this.jdField_b_of_type_Int);
      }
    }
    for (;;)
    {
      if (QLog.isDevelopLevel()) {
        QLog.i("SurfaceTag", 4, "preRender, new render for frame.");
      }
      if ((this.jdField_a_of_type_ComTencentAvOpenglEffectsPreRender != null) && (this.jdField_a_of_type_ComTencentAvOpenglEffectsPreRender.a(paramCameraFrame)))
      {
        c();
        this.jdField_b_of_type_ComTencentAvOpenglEffectsGLTexture = this.jdField_a_of_type_ComTencentAvOpenglEffectsPreRender.a(this, paramCameraFrame, this.jdField_a_of_type_ComTencentAvOpenglEffectsGLTexture);
      }
      return;
      this.jdField_b_of_type_ComTencentAvOpenglEffectsGLTexture.jdField_a_of_type_Int = this.d;
      this.jdField_b_of_type_ComTencentAvOpenglEffectsGLTexture.jdField_b_of_type_Int = this.jdField_c_of_type_Int;
      break;
      label213:
      if (paramCameraFrame.jdField_a_of_type_AndroidGraphicsSurfaceTexture != null)
      {
        this.jdField_a_of_type_ComTencentAvOpenglEffectsPreRender = new SurfacePreRender(paramCameraFrame.jdField_a_of_type_AndroidGraphicsSurfaceTexture);
        this.jdField_a_of_type_ComTencentAvOpenglEffectsPreRender.a();
        this.jdField_a_of_type_ComTencentAvOpenglEffectsPreRender.a(this.jdField_a_of_type_Int, this.jdField_b_of_type_Int);
      }
    }
  }
  
  private void a(CameraFrame paramCameraFrame, RenderParams paramRenderParams, boolean paramBoolean1, FramePerfData paramFramePerfData, boolean paramBoolean2)
  {
    boolean bool2 = true;
    c();
    boolean bool1;
    boolean bool3;
    boolean bool4;
    if ((this.jdField_a_of_type_ComTencentAvOpenglEffectsAEFilterAVWrapper != null) && ((paramBoolean2) || (paramRenderParams.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataFilterDesc != null) || (paramRenderParams.jdField_a_of_type_ComTencentAvBusinessManagerPendantPendantItem != null) || (paramRenderParams.jdField_a_of_type_ComTencentTtpicOpenapiModelVideoMaterial != null) || (paramBoolean1)))
    {
      if (this.jdField_a_of_type_ComTencentAvUtilsPerfRecorder != null) {
        this.jdField_a_of_type_ComTencentAvUtilsPerfRecorder.a("drawFrameInGL");
      }
      int i = this.jdField_a_of_type_Int;
      int j = this.jdField_b_of_type_Int;
      if (this.jdField_a_of_type_ComTencentAvOpenglEffectsExtraRenderWrapper != null)
      {
        this.jdField_a_of_type_ComTencentAvOpenglEffectsExtraRenderWrapper.a(paramCameraFrame, paramRenderParams, this.jdField_a_of_type_ComTencentAvOpenglEffectsGLTexture, this.jdField_a_of_type_Int, this.jdField_b_of_type_Int);
        FaceData localFaceData = this.jdField_a_of_type_ComTencentAvOpenglEffectsFaceData;
        if (this.jdField_a_of_type_ComTencentAvOpenglEffectsExtraRenderWrapper.jdField_a_of_type_Int == 0) {
          break label462;
        }
        bool1 = true;
        localFaceData.jdField_a_of_type_Boolean = bool1;
      }
      this.jdField_a_of_type_ComTencentAvOpenglEffectsAEFilterAVWrapper.b(i, j);
      bool3 = this.jdField_a_of_type_ComTencentAvOpenglEffectsAEFilterAVWrapper.d();
      this.jdField_a_of_type_ComTencentAvOpenglEffectsAEFilterAVWrapper.a(paramRenderParams.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataFilterDesc);
      this.jdField_a_of_type_ComTencentAvOpenglEffectsAEFilterAVWrapper.a(paramRenderParams.jdField_a_of_type_ComTencentAvBusinessManagerPendantPendantItem, paramRenderParams.jdField_a_of_type_ComTencentTtpicOpenapiModelVideoMaterial);
      this.jdField_a_of_type_ComTencentAvOpenglEffectsAEFilterAVWrapper.a(paramBoolean1);
      this.jdField_a_of_type_ComTencentAvOpenglEffectsAEFilterAVWrapper.c(this.d, this.jdField_c_of_type_Int);
      this.jdField_b_of_type_ComTencentAvOpenglEffectsGLTexture = GLTexture.a(this.jdField_a_of_type_ComTencentAvOpenglEffectsGLTexture.jdField_a_of_type_Int, this.jdField_a_of_type_ComTencentAvOpenglEffectsGLTexture.jdField_b_of_type_Int);
      this.jdField_b_of_type_ComTencentAvOpenglEffectsGLTexture.jdField_b_of_type_Int = this.jdField_a_of_type_ComTencentAvOpenglEffectsAEFilterAVWrapper.a(this.jdField_a_of_type_ComTencentAvOpenglEffectsGLTexture.jdField_b_of_type_Int, false, this.jdField_a_of_type_ComTencentAvOpenglEffectsFaceData, paramRenderParams.jdField_b_of_type_Boolean);
      bool4 = this.jdField_a_of_type_ComTencentAvOpenglEffectsAEFilterAVWrapper.d();
      if (this.jdField_a_of_type_ComTencentAvOpenglEffectsAEFilterAVWrapper.a()) {
        a(128);
      }
      if (paramRenderParams.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataFilterDesc != null) {
        a(16);
      }
      if ((paramRenderParams.jdField_a_of_type_ComTencentAvBusinessManagerPendantPendantItem != null) || (paramRenderParams.jdField_a_of_type_ComTencentTtpicOpenapiModelVideoMaterial != null)) {
        a(32);
      }
      if (this.jdField_a_of_type_ComTencentAvOpenglEffectsAEFilterAVWrapper.b()) {
        a(64);
      }
      if (paramBoolean2) {
        a(8);
      }
      if (this.jdField_a_of_type_ComTencentAvUtilsPerfRecorder != null) {
        this.jdField_a_of_type_ComTencentAvUtilsPerfRecorder.b("drawFrameInGL");
      }
      if (paramFramePerfData != null)
      {
        if (paramRenderParams.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataFilterDesc == null) {
          break label468;
        }
        bool1 = true;
        label383:
        if (paramRenderParams.jdField_a_of_type_ComTencentTtpicOpenapiModelVideoMaterial == null) {
          break label474;
        }
      }
    }
    for (;;)
    {
      paramFramePerfData.a(bool1, bool2, paramBoolean1, paramBoolean2);
      a(2, this.jdField_a_of_type_ComTencentAvOpenglEffectsGLTexture, this.jdField_b_of_type_ComTencentAvOpenglEffectsGLTexture);
      if (this.jdField_a_of_type_ComTencentAvOpenglEffectsExtraRenderWrapper != null) {
        this.jdField_a_of_type_ComTencentAvOpenglEffectsExtraRenderWrapper.a(this.jdField_b_of_type_ComTencentAvOpenglEffectsGLTexture, bool3, bool4, this.jdField_a_of_type_Int, this.jdField_b_of_type_Int);
      }
      if (this.jdField_a_of_type_ComTencentAvOpenglEffectsExtraRenderWrapper != null) {
        this.jdField_a_of_type_ComTencentAvOpenglEffectsExtraRenderWrapper.a(paramCameraFrame, paramRenderParams);
      }
      return;
      label462:
      bool1 = false;
      break;
      label468:
      bool1 = false;
      break label383;
      label474:
      bool2 = false;
    }
  }
  
  private void a(CameraFrame paramCameraFrame, RenderResult paramRenderResult, long paramLong)
  {
    if (this.jdField_a_of_type_ComTencentAvOpenglEffectsPostRender != null) {
      this.jdField_a_of_type_ComTencentAvOpenglEffectsPostRender.a(this, paramCameraFrame, this.jdField_b_of_type_ComTencentAvOpenglEffectsGLTexture, this.jdField_a_of_type_ComTencentAvOpenglEffectsFaceData, paramRenderResult);
    }
    this.jdField_c_of_type_Boolean = false;
    if (paramRenderResult.a == null) {
      paramRenderResult.a = paramCameraFrame;
    }
    long l = System.currentTimeMillis();
    paramRenderResult.a.f = ((int)(l - paramLong));
    paramRenderResult.a.g = this.e;
    if (this.jdField_a_of_type_ComTencentAvUtilsPerfRecorder != null) {
      this.jdField_a_of_type_ComTencentAvUtilsPerfRecorder.a(paramCameraFrame.c);
    }
    MemoryPerfStat.a().a(this.e);
  }
  
  private void a(RenderParams paramRenderParams, IEffectCtrl paramIEffectCtrl, boolean paramBoolean)
  {
    if ((paramBoolean) || (paramRenderParams.jdField_a_of_type_ComTencentTtpicOpenapiModelVideoMaterial != null))
    {
      if (this.jdField_a_of_type_ComTencentAvUtilsPerfRecorder != null) {
        this.jdField_a_of_type_ComTencentAvUtilsPerfRecorder.a("faceDetect");
      }
      if (this.jdField_a_of_type_ComTencentAvOpenglEffectsFilterProcessRender$FaceDataWatcher != null) {
        this.jdField_a_of_type_ComTencentAvOpenglEffectsFilterProcessRender$FaceDataWatcher.a(this.jdField_a_of_type_ComTencentAvOpenglEffectsFaceData, this.jdField_c_of_type_Int, this.jdField_a_of_type_Int, this.jdField_b_of_type_Int);
      }
      if (this.jdField_a_of_type_ComTencentAvOpenglEffectsAEFilterAVWrapper != null) {
        this.jdField_a_of_type_ComTencentAvOpenglEffectsAEFilterAVWrapper.a(this.jdField_a_of_type_ComTencentAvOpenglEffectsFaceData);
      }
      if (this.jdField_a_of_type_ComTencentAvUtilsPerfRecorder != null) {
        this.jdField_a_of_type_ComTencentAvUtilsPerfRecorder.b("faceDetect");
      }
    }
  }
  
  private void b(CameraFrame paramCameraFrame, RenderResult paramRenderResult, long paramLong)
  {
    paramCameraFrame.jdField_a_of_type_Int = this.jdField_b_of_type_Int;
    paramCameraFrame.jdField_b_of_type_Int = this.jdField_a_of_type_Int;
    if (this.jdField_a_of_type_ComTencentAvOpenglEffectsFilterProcessTest != null)
    {
      this.jdField_a_of_type_ComTencentAvOpenglEffectsFilterProcessTest.a(this, 5, paramCameraFrame, null);
      this.jdField_a_of_type_ComTencentAvOpenglEffectsFilterProcessTest.d();
    }
    this.jdField_c_of_type_Boolean = false;
    paramCameraFrame.f = ((int)(System.currentTimeMillis() - paramLong));
    paramCameraFrame.g = this.e;
    if (this.jdField_a_of_type_ComTencentAvOpenglEffectsPreRender != null) {
      this.jdField_a_of_type_ComTencentAvOpenglEffectsPreRender.b();
    }
    if (this.jdField_a_of_type_ComTencentAvOpenglEffectsPostRender != null) {
      this.jdField_a_of_type_ComTencentAvOpenglEffectsPostRender.b();
    }
    if (this.jdField_a_of_type_ComTencentAvUtilsPerfRecorder != null) {
      this.jdField_a_of_type_ComTencentAvUtilsPerfRecorder.a(paramCameraFrame.c);
    }
    MemoryPerfStat.a().a(this.e);
    paramRenderResult.a(paramCameraFrame, null, null, null, (short)0, (short)0);
  }
  
  private void d()
  {
    if (this.jdField_a_of_type_JavaNioFloatBuffer != null) {
      return;
    }
    float[] arrayOfFloat = new float[8];
    arrayOfFloat[0] = (-0.5F + 0.0F);
    arrayOfFloat[1] = (-0.5F + 0.0F);
    arrayOfFloat[2] = (0.5F + 0.0F);
    arrayOfFloat[3] = (-0.5F + 0.0F);
    arrayOfFloat[4] = (-0.5F + 0.0F);
    arrayOfFloat[5] = (0.5F + 0.0F);
    arrayOfFloat[6] = (0.5F + 0.0F);
    arrayOfFloat[7] = (0.5F + 0.0F);
    ByteBuffer localByteBuffer = ByteBuffer.allocateDirect(arrayOfFloat.length * 4);
    localByteBuffer.order(ByteOrder.nativeOrder());
    this.jdField_a_of_type_JavaNioFloatBuffer = localByteBuffer.asFloatBuffer();
    this.jdField_a_of_type_JavaNioFloatBuffer.put(arrayOfFloat);
    this.jdField_a_of_type_JavaNioFloatBuffer.position(0);
  }
  
  void a()
  {
    if (this.jdField_a_of_type_ComTencentAvOpenglEffectsAEFilterAVWrapper != null) {
      this.jdField_a_of_type_ComTencentAvOpenglEffectsAEFilterAVWrapper.c();
    }
  }
  
  protected void a(int paramInt)
  {
    this.e |= paramInt;
  }
  
  public void a(int paramInt, GLTexture paramGLTexture1, GLTexture paramGLTexture2)
  {
    if ((this.jdField_a_of_type_ComTencentAvOpenglEffectsFilterProcessTest != null) && (this.jdField_a_of_type_ComTencentAvOpenglEffectsFilterProcessTest.jdField_a_of_type_Boolean))
    {
      this.jdField_a_of_type_ComTencentAvOpenglEffectsFilterProcessTest.a(this, paramInt, null, paramGLTexture2);
      this.jdField_a_of_type_ComTencentAvOpenglEffectsFilterProcessTest.a(paramInt, paramGLTexture2.jdField_a_of_type_Int, paramGLTexture2.jdField_b_of_type_Int);
      if (QLog.isDevelopLevel()) {
        QLog.i(this.jdField_a_of_type_JavaLangString, 4, String.format("%s, fbo[%s --> %s], textureid[%s --> %s]", new Object[] { FilterProcessTest.a(paramInt), Integer.valueOf(paramGLTexture1.jdField_a_of_type_Int), Integer.valueOf(paramGLTexture2.jdField_a_of_type_Int), Integer.valueOf(paramGLTexture1.jdField_b_of_type_Int), Integer.valueOf(paramGLTexture2.jdField_b_of_type_Int) }));
      }
    }
  }
  
  void a(long paramLong)
  {
    if (this.jdField_a_of_type_ComTencentAvOpenglEffectsAEFilterAVWrapper != null)
    {
      this.jdField_a_of_type_ComTencentAvOpenglEffectsAEFilterAVWrapper.a(paramLong);
      return;
    }
    TipsInfo.a().a(paramLong);
  }
  
  public void a(long paramLong, int paramInt)
  {
    if (AudioHelper.e()) {
      QLog.w(this.jdField_a_of_type_JavaLangString, 1, "initial, szie[" + this.jdField_a_of_type_Int + ", " + this.jdField_b_of_type_Int + "], id[" + this.jdField_c_of_type_Int + "], seq[" + paramLong + "]");
    }
    if (this.jdField_a_of_type_ComTencentAvOpenglEffectsFilterProcessTest != null) {
      this.jdField_a_of_type_ComTencentAvOpenglEffectsFilterProcessTest.a();
    }
    this.jdField_a_of_type_Boolean = true;
    this.jdField_c_of_type_Boolean = false;
    if (this.jdField_c_of_type_Int != -1) {
      return;
    }
    if (EffectCtrlBase.b())
    {
      if (this.jdField_a_of_type_ComTencentAvOpenglEffectsAEFilterAVWrapper == null)
      {
        this.jdField_a_of_type_ComTencentAvOpenglEffectsAEFilterAVWrapper = new AEFilterAVWrapperImpl(paramInt);
        this.jdField_a_of_type_ComTencentAvOpenglEffectsAEFilterAVWrapper.a(this.jdField_a_of_type_Int, this.jdField_b_of_type_Int);
      }
      if (this.jdField_a_of_type_ComTencentAvOpenglEffectsAEFilterAVWrapper.c()) {
        if (this.jdField_a_of_type_ComTencentAvOpenglEffectsAVSDKBeautyRender == null) {
          this.jdField_a_of_type_ComTencentAvOpenglEffectsAVSDKBeautyRender = new AVSDKBeautyRender();
        }
      }
    }
    for (;;)
    {
      int[] arrayOfInt = new int[1];
      GLES20.glGenTextures(arrayOfInt.length, arrayOfInt, 0);
      this.jdField_c_of_type_Int = arrayOfInt[0];
      if (this.jdField_a_of_type_ComTencentAvOpenglEffectsPreRender != null) {
        this.jdField_a_of_type_ComTencentAvOpenglEffectsPreRender.a();
      }
      if (this.jdField_a_of_type_ComTencentAvOpenglEffectsPostRender != null) {
        this.jdField_a_of_type_ComTencentAvOpenglEffectsPostRender.a();
      }
      this.e = 0;
      if (this.jdField_a_of_type_ComTencentAvOpenglEffectsExtraRenderWrapper == null) {
        break;
      }
      this.jdField_a_of_type_ComTencentAvOpenglEffectsExtraRenderWrapper.a();
      return;
      if (this.jdField_a_of_type_ComTencentAvOpenglEffectsAVSDKBeautyRender != null) {
        this.jdField_a_of_type_ComTencentAvOpenglEffectsAVSDKBeautyRender.a();
      }
      this.jdField_a_of_type_ComTencentAvOpenglEffectsAVSDKBeautyRender = null;
      continue;
      this.jdField_a_of_type_ComTencentAvOpenglEffectsAVSDKBeautyRender = new AVSDKBeautyRender();
    }
  }
  
  public void a(CameraFrame paramCameraFrame, RenderParams paramRenderParams, IEffectCtrl paramIEffectCtrl, RenderResult paramRenderResult)
  {
    if (this.jdField_a_of_type_ComTencentAvOpenglEffectsFilterProcessTest != null) {
      this.jdField_a_of_type_ComTencentAvOpenglEffectsFilterProcessTest.a();
    }
    if (this.jdField_a_of_type_ComTencentAvUtilsPerfRecorder != null) {
      this.jdField_a_of_type_ComTencentAvUtilsPerfRecorder.b();
    }
    long l = System.currentTimeMillis();
    paramRenderResult.a = paramCameraFrame;
    a(0L, paramCameraFrame.jdField_b_of_type_Int, paramCameraFrame.jdField_a_of_type_Int);
    int i = paramCameraFrame.jdField_a_of_type_Int;
    int k = paramCameraFrame.jdField_b_of_type_Int;
    int m = RenderUtil.a(paramCameraFrame.jdField_a_of_type_Boolean);
    boolean bool1;
    if (this.jdField_a_of_type_ComTencentAvOpenglEffectsFilterProcessRender$FaceDataWatcher != null) {
      if ((paramRenderParams.jdField_a_of_type_Boolean) || (this.jdField_a_of_type_ComTencentAvOpenglEffectsFilterProcessRender$FaceDataWatcher.a())) {
        bool1 = true;
      }
    }
    int j;
    for (;;)
    {
      if (this.jdField_b_of_type_Boolean != bool1)
      {
        if (QLog.isDevelopLevel()) {
          QLog.i(this.jdField_a_of_type_JavaLangString, 4, "render, needFaceData[" + bool1 + "]");
        }
        this.jdField_b_of_type_Boolean = bool1;
      }
      j = this.jdField_a_of_type_ComTencentAvOpenglEffectsBeautyConfig.a("BEAUTY_SKIN");
      this.jdField_a_of_type_ComTencentAvOpenglEffectsRenderInfoLog.a(this.jdField_a_of_type_JavaLangString, paramCameraFrame.c, i, k, paramCameraFrame.d, paramRenderParams.jdField_a_of_type_Boolean, paramRenderParams.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataFilterDesc, paramRenderParams.jdField_a_of_type_ComTencentTtpicOpenapiModelVideoMaterial, paramRenderParams.jdField_a_of_type_ComTencentAvBusinessManagerPendantPendantItem, paramCameraFrame, j);
      if ((this.jdField_a_of_type_Int != 0) && (this.jdField_b_of_type_Int != 0) && (!paramCameraFrame.a()) && (this.d != -1) && (this.jdField_a_of_type_Boolean)) {
        break;
      }
      return;
      bool1 = false;
      continue;
      bool1 = paramRenderParams.jdField_a_of_type_Boolean;
    }
    this.jdField_c_of_type_Boolean = true;
    FramePerfData localFramePerfData = paramCameraFrame.jdField_a_of_type_ComTencentAvUtilsFramePerfData;
    if (localFramePerfData != null) {
      localFramePerfData.a(m);
    }
    this.jdField_a_of_type_ComTencentAvOpenglEffectsFaceData.a(i, k);
    if ((paramCameraFrame.b()) && (this.jdField_a_of_type_ComTencentAvOpenglEffectsFilterProcessTest != null))
    {
      this.jdField_a_of_type_ComTencentAvOpenglEffectsFilterProcessTest.c();
      this.jdField_a_of_type_ComTencentAvOpenglEffectsFilterProcessTest.a(this, 0, paramCameraFrame, null);
    }
    boolean bool4 = false;
    boolean bool3 = false;
    boolean bool2;
    if (this.jdField_a_of_type_ComTencentAvOpenglEffectsAVSDKBeautyRender != null)
    {
      this.jdField_a_of_type_ComTencentAvOpenglEffectsAVSDKBeautyRender.a(j);
      if (this.jdField_a_of_type_ComTencentAvOpenglEffectsAEFilterAVWrapper != null) {
        this.jdField_a_of_type_ComTencentAvOpenglEffectsAEFilterAVWrapper.a(null);
      }
      bool2 = this.jdField_a_of_type_ComTencentAvOpenglEffectsAVSDKBeautyRender.a(j);
      if ((paramRenderParams.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataFilterDesc == null) && (paramRenderParams.jdField_a_of_type_ComTencentTtpicOpenapiModelVideoMaterial == null)) {
        break label575;
      }
      i = 1;
      label397:
      boolean bool5 = false;
      bool4 = bool5;
      if (paramCameraFrame.b())
      {
        bool4 = bool5;
        if (this.jdField_a_of_type_ComTencentAvOpenglEffectsLightAndNoiseDeal != null)
        {
          this.jdField_a_of_type_ComTencentAvOpenglEffectsLightAndNoiseDeal.a(this.jdField_a_of_type_ComTencentAvUtilsPerfRecorder, paramCameraFrame, localFramePerfData);
          bool4 = this.jdField_a_of_type_ComTencentAvOpenglEffectsLightAndNoiseDeal.jdField_a_of_type_Boolean;
        }
      }
      if ((paramCameraFrame.b()) && (this.jdField_a_of_type_ComTencentAvOpenglEffectsAVSDKBeautyRender != null)) {
        this.jdField_a_of_type_ComTencentAvOpenglEffectsAVSDKBeautyRender.a(this, this.jdField_a_of_type_ComTencentAvUtilsPerfRecorder, paramCameraFrame, localFramePerfData, paramRenderParams, this.jdField_a_of_type_Int, this.jdField_b_of_type_Int, j);
      }
      if ((i == 0) && (!bool1) && (!bool2) && (!bool3) && (!bool4)) {
        break label581;
      }
      i = 1;
    }
    for (;;)
    {
      if ((!paramRenderParams.jdField_c_of_type_Boolean) || (i == 0))
      {
        if (paramCameraFrame.b())
        {
          b(paramCameraFrame, paramRenderResult, l);
          return;
          bool2 = bool4;
          if (this.jdField_a_of_type_ComTencentAvOpenglEffectsAEFilterAVWrapper == null) {
            break;
          }
          bool3 = this.jdField_a_of_type_ComTencentAvOpenglEffectsAEFilterAVWrapper.a(this.jdField_a_of_type_ComTencentAvOpenglEffectsBeautyConfig);
          bool2 = bool4;
          break;
          label575:
          i = 0;
          break label397;
          label581:
          i = 0;
          continue;
        }
        a(paramCameraFrame);
        a(paramCameraFrame, paramRenderResult, l);
        return;
      }
    }
    a(paramCameraFrame);
    if ((paramCameraFrame.b()) && (this.jdField_a_of_type_ComTencentAvOpenglEffectsLightAndNoiseDeal != null)) {
      this.jdField_a_of_type_ComTencentAvOpenglEffectsLightAndNoiseDeal.a(this.jdField_a_of_type_ComTencentAvUtilsPerfRecorder, localFramePerfData);
    }
    if ((paramCameraFrame.b()) && (this.jdField_a_of_type_ComTencentAvOpenglEffectsLightAndNoiseDeal != null)) {
      this.jdField_a_of_type_ComTencentAvOpenglEffectsLightAndNoiseDeal.b(this.jdField_a_of_type_ComTencentAvUtilsPerfRecorder, paramCameraFrame, localFramePerfData);
    }
    if ((paramCameraFrame.b()) && (this.jdField_a_of_type_ComTencentAvOpenglEffectsAVSDKBeautyRender != null)) {
      this.jdField_a_of_type_ComTencentAvOpenglEffectsAVSDKBeautyRender.a(this, this.jdField_a_of_type_ComTencentAvUtilsPerfRecorder, localFramePerfData, paramRenderParams, this.jdField_a_of_type_Int, this.jdField_b_of_type_Int, j);
    }
    a(paramCameraFrame, paramRenderParams, bool1, localFramePerfData, bool3);
    a(paramRenderParams, paramIEffectCtrl, bool1);
    a(paramCameraFrame, paramRenderResult, l);
  }
  
  void b()
  {
    long l = AudioHelper.b();
    QLog.w(this.jdField_a_of_type_JavaLangString, 1, "uninit, mIsInited[" + this.jdField_a_of_type_Boolean + "], mIsRendering[" + this.jdField_c_of_type_Boolean + "], seq[" + l + "]");
    if (!this.jdField_a_of_type_Boolean) {
      return;
    }
    this.jdField_a_of_type_Boolean = false;
    if (this.jdField_a_of_type_ComTencentAvOpenglEffectsFilterProcessTest != null) {
      this.jdField_a_of_type_ComTencentAvOpenglEffectsFilterProcessTest.b();
    }
    if (this.jdField_a_of_type_ComTencentAvOpenglEffectsPostRender != null) {
      this.jdField_a_of_type_ComTencentAvOpenglEffectsPostRender.b();
    }
    if (this.jdField_a_of_type_ComTencentAvOpenglEffectsPreRender != null) {
      this.jdField_a_of_type_ComTencentAvOpenglEffectsPreRender.b();
    }
    a(l);
    if (this.jdField_a_of_type_ComTencentAvOpenglEffectsAVSDKBeautyRender != null) {
      this.jdField_a_of_type_ComTencentAvOpenglEffectsAVSDKBeautyRender.b();
    }
    if (this.jdField_a_of_type_ComTencentAvOpenglEffectsAEFilterAVWrapper != null) {
      this.jdField_a_of_type_ComTencentAvOpenglEffectsAEFilterAVWrapper.a();
    }
    if (this.jdField_a_of_type_ComTencentAvUtilsPerfRecorder != null) {
      this.jdField_a_of_type_ComTencentAvUtilsPerfRecorder.a();
    }
    TipsInfo.a().a();
  }
  
  public void b(long paramLong)
  {
    QLog.w(this.jdField_a_of_type_JavaLangString, 1, "clear, seq[" + paramLong + "]");
    if (this.jdField_a_of_type_ComTencentAvOpenglEffectsPreRender != null)
    {
      this.jdField_a_of_type_ComTencentAvOpenglEffectsPreRender.b();
      this.jdField_a_of_type_ComTencentAvOpenglEffectsPreRender.c();
    }
    if (this.d != -1)
    {
      GLES20.glDeleteFramebuffers(1, new int[] { this.d }, 0);
      this.d = -1;
    }
    if (this.jdField_c_of_type_Int != -1)
    {
      int[] arrayOfInt = new int[1];
      arrayOfInt[0] = this.jdField_c_of_type_Int;
      GLES20.glDeleteTextures(arrayOfInt.length, arrayOfInt, 0);
      this.jdField_c_of_type_Int = -1;
    }
    if (this.jdField_a_of_type_ComTencentAvOpenglEffectsPostRender != null) {
      this.jdField_a_of_type_ComTencentAvOpenglEffectsPostRender.c();
    }
    if (this.jdField_a_of_type_ComTencentAvOpenglEffectsLightAndNoiseDeal != null)
    {
      this.jdField_a_of_type_ComTencentAvOpenglEffectsLightAndNoiseDeal.a();
      this.jdField_a_of_type_ComTencentAvOpenglEffectsLightAndNoiseDeal = null;
    }
    if (this.jdField_a_of_type_ComTencentAvOpenglEffectsAVSDKBeautyRender != null)
    {
      this.jdField_a_of_type_ComTencentAvOpenglEffectsAVSDKBeautyRender.a();
      this.jdField_a_of_type_ComTencentAvOpenglEffectsAVSDKBeautyRender = null;
    }
    if (this.jdField_a_of_type_ComTencentAvOpenglEffectsAEFilterAVWrapper != null)
    {
      this.jdField_a_of_type_ComTencentAvOpenglEffectsAEFilterAVWrapper.b();
      this.jdField_a_of_type_ComTencentAvOpenglEffectsAEFilterAVWrapper = null;
    }
    if (this.jdField_a_of_type_ComTencentAvOpenglEffectsExtraRenderWrapper != null) {
      this.jdField_a_of_type_ComTencentAvOpenglEffectsExtraRenderWrapper.b();
    }
    TipsInfo.a().a(paramLong);
  }
  
  protected void c()
  {
    if ((this.jdField_a_of_type_ComTencentAvOpenglEffectsGLTexture != this.jdField_b_of_type_ComTencentAvOpenglEffectsGLTexture) && (this.jdField_a_of_type_ComTencentAvOpenglEffectsGLTexture != null))
    {
      this.jdField_a_of_type_ComTencentAvOpenglEffectsGLTexture.a();
      this.jdField_a_of_type_ComTencentAvOpenglEffectsGLTexture = null;
    }
    this.jdField_a_of_type_ComTencentAvOpenglEffectsGLTexture = this.jdField_b_of_type_ComTencentAvOpenglEffectsGLTexture;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.av.opengl.effects.FilterProcessRender
 * JD-Core Version:    0.7.0.1
 */