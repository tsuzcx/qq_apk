package com.tencent.av.opengl.effects;

import android.annotation.TargetApi;
import android.content.Context;
import android.opengl.GLES20;
import com.tencent.aelight.camera.download.api.IAEKitForQQ;
import com.tencent.av.camera.CameraUtils;
import com.tencent.av.camera.api.ICameraManagerApi;
import com.tencent.av.opengl.utils.AVGLUtils;
import com.tencent.av.perfstat.MemoryPerfStat;
import com.tencent.av.utils.AudioHelper;
import com.tencent.av.utils.FramePerfData;
import com.tencent.av.utils.PerfRecorder;
import com.tencent.av.utils.PerfReporter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import com.tencent.sveffects.SvEffectSdkInitor;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;

@TargetApi(17)
public class FilterProcessRender
{
  int jdField_a_of_type_Int = 0;
  protected Context a;
  private AEFilterAVWrapper jdField_a_of_type_ComTencentAvOpenglEffectsAEFilterAVWrapper = null;
  private BeautyConfig jdField_a_of_type_ComTencentAvOpenglEffectsBeautyConfig = null;
  private ExtraRenderWrapper jdField_a_of_type_ComTencentAvOpenglEffectsExtraRenderWrapper = null;
  final FaceData jdField_a_of_type_ComTencentAvOpenglEffectsFaceData = new FaceData();
  protected FilterProcessTest a;
  protected GLTexture a;
  protected PostRender a;
  protected PreRender a;
  private final RenderInfoLog jdField_a_of_type_ComTencentAvOpenglEffectsRenderInfoLog = new RenderInfoLog();
  protected PerfRecorder a;
  final String jdField_a_of_type_JavaLangString;
  protected FloatBuffer a;
  protected boolean a;
  int b;
  protected GLTexture b;
  protected boolean b;
  int jdField_c_of_type_Int = -1;
  private boolean jdField_c_of_type_Boolean = false;
  int d = -1;
  private int e = 0;
  
  public FilterProcessRender(Context paramContext, BeautyConfig paramBeautyConfig)
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
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("FilterProcessRender_");
    localStringBuilder.append(AudioHelper.b());
    this.jdField_a_of_type_JavaLangString = localStringBuilder.toString();
    if (QLog.isColorLevel()) {
      this.jdField_a_of_type_ComTencentAvUtilsPerfRecorder = new PerfRecorder(AEFilterSupport.a());
    }
    this.jdField_a_of_type_ComTencentAvOpenglEffectsBeautyConfig = paramBeautyConfig;
    SvEffectSdkInitor.a();
    ((IAEKitForQQ)QRoute.api(IAEKitForQQ.class)).init();
    TipsInfo.a().a();
    this.jdField_c_of_type_Int = -1;
    RenderUtil.a();
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    paramContext = CameraUtils.a(this.jdField_a_of_type_AndroidContentContext).getSurfaceTextureForRender();
    if (paramContext != null) {
      this.jdField_a_of_type_ComTencentAvOpenglEffectsPreRender = new SurfacePreRender(paramContext);
    } else {
      this.jdField_a_of_type_ComTencentAvOpenglEffectsPreRender = new YUVPreRender();
    }
    this.jdField_a_of_type_ComTencentAvOpenglEffectsPostRender = new YuvPostRender(this.jdField_a_of_type_JavaLangString);
    this.jdField_a_of_type_ComTencentAvOpenglEffectsExtraRenderWrapper = new ExtraRenderWrapper(this);
  }
  
  private void a(long paramLong, int paramInt1, int paramInt2)
  {
    if ((paramInt1 != 0) && (paramInt2 != 0))
    {
      if ((this.jdField_a_of_type_Int == paramInt1) && (this.jdField_b_of_type_Int == paramInt2)) {
        return;
      }
      if (QLog.isColorLevel())
      {
        localObject = this.jdField_a_of_type_JavaLangString;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("innerUpdatePreviewSize, width[");
        localStringBuilder.append(this.jdField_a_of_type_Int);
        localStringBuilder.append("->");
        localStringBuilder.append(paramInt1);
        localStringBuilder.append("], height[");
        localStringBuilder.append(this.jdField_b_of_type_Int);
        localStringBuilder.append("->");
        localStringBuilder.append(paramInt2);
        localStringBuilder.append("], seq[");
        localStringBuilder.append(paramLong);
        localStringBuilder.append("]");
        QLog.w((String)localObject, 1, localStringBuilder.toString());
      }
      this.jdField_a_of_type_Int = paramInt1;
      this.jdField_b_of_type_Int = paramInt2;
      this.d = AVGLUtils.initFrameBuffer(paramInt1, paramInt2, this.jdField_c_of_type_Int);
      Object localObject = this.jdField_a_of_type_ComTencentAvOpenglEffectsPreRender;
      if (localObject != null) {
        ((PreRender)localObject).a(paramInt1, paramInt2);
      }
      localObject = this.jdField_a_of_type_ComTencentAvOpenglEffectsPostRender;
      if (localObject != null) {
        ((PostRender)localObject).a(paramInt1, paramInt2);
      }
      d();
      SvEffectSdkInitor.a();
    }
  }
  
  private void a(CameraFrame paramCameraFrame)
  {
    Object localObject = this.jdField_b_of_type_ComTencentAvOpenglEffectsGLTexture;
    if (localObject == null)
    {
      this.jdField_b_of_type_ComTencentAvOpenglEffectsGLTexture = GLTexture.a(this.d, this.jdField_c_of_type_Int);
    }
    else
    {
      ((GLTexture)localObject).jdField_a_of_type_Int = this.d;
      ((GLTexture)localObject).jdField_b_of_type_Int = this.jdField_c_of_type_Int;
    }
    localObject = this.jdField_a_of_type_ComTencentAvOpenglEffectsPreRender;
    if ((localObject != null) && (!((PreRender)localObject).a(paramCameraFrame)))
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
      if (paramCameraFrame.b())
      {
        this.jdField_a_of_type_ComTencentAvOpenglEffectsPreRender = new YUVPreRender();
        this.jdField_a_of_type_ComTencentAvOpenglEffectsPreRender.a();
        this.jdField_a_of_type_ComTencentAvOpenglEffectsPreRender.a(this.jdField_a_of_type_Int, this.jdField_b_of_type_Int);
      }
      else if (paramCameraFrame.jdField_a_of_type_AndroidGraphicsSurfaceTexture != null)
      {
        this.jdField_a_of_type_ComTencentAvOpenglEffectsPreRender = new SurfacePreRender(paramCameraFrame.jdField_a_of_type_AndroidGraphicsSurfaceTexture);
        this.jdField_a_of_type_ComTencentAvOpenglEffectsPreRender.a();
        this.jdField_a_of_type_ComTencentAvOpenglEffectsPreRender.a(this.jdField_a_of_type_Int, this.jdField_b_of_type_Int);
      }
      if (QLog.isDevelopLevel()) {
        QLog.i("SurfaceTag", 4, "preRender, new render for frame.");
      }
    }
    localObject = this.jdField_a_of_type_ComTencentAvOpenglEffectsPreRender;
    if ((localObject != null) && (((PreRender)localObject).a(paramCameraFrame)))
    {
      c();
      this.jdField_b_of_type_ComTencentAvOpenglEffectsGLTexture = this.jdField_a_of_type_ComTencentAvOpenglEffectsPreRender.a(this, paramCameraFrame, this.jdField_a_of_type_ComTencentAvOpenglEffectsGLTexture);
    }
  }
  
  private void a(CameraFrame paramCameraFrame, RenderParams paramRenderParams, boolean paramBoolean1, FramePerfData paramFramePerfData, boolean paramBoolean2)
  {
    c();
    if ((this.jdField_a_of_type_ComTencentAvOpenglEffectsAEFilterAVWrapper != null) && ((paramBoolean2) || (paramRenderParams.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataFilterDesc != null) || (paramRenderParams.jdField_a_of_type_ComTencentAvBusinessManagerPendantPendantItem != null) || (paramRenderParams.jdField_a_of_type_ComTencentTtpicOpenapiModelVideoMaterial != null) || (paramBoolean1)))
    {
      Object localObject = this.jdField_a_of_type_ComTencentAvUtilsPerfRecorder;
      if (localObject != null) {
        ((PerfRecorder)localObject).a("drawFrameInGL");
      }
      int i = this.jdField_a_of_type_Int;
      int j = this.jdField_b_of_type_Int;
      localObject = this.jdField_a_of_type_ComTencentAvOpenglEffectsExtraRenderWrapper;
      boolean bool2 = true;
      boolean bool1;
      if (localObject != null)
      {
        ((ExtraRenderWrapper)localObject).a(paramCameraFrame, paramRenderParams, this.jdField_a_of_type_ComTencentAvOpenglEffectsGLTexture, i, j);
        localObject = this.jdField_a_of_type_ComTencentAvOpenglEffectsFaceData;
        if (this.jdField_a_of_type_ComTencentAvOpenglEffectsExtraRenderWrapper.jdField_a_of_type_Int != 0) {
          bool1 = true;
        } else {
          bool1 = false;
        }
        ((FaceData)localObject).jdField_a_of_type_Boolean = bool1;
      }
      this.jdField_a_of_type_ComTencentAvOpenglEffectsAEFilterAVWrapper.b(i, j);
      boolean bool3 = this.jdField_a_of_type_ComTencentAvOpenglEffectsAEFilterAVWrapper.c();
      this.jdField_a_of_type_ComTencentAvOpenglEffectsAEFilterAVWrapper.a(paramRenderParams.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataFilterDesc);
      this.jdField_a_of_type_ComTencentAvOpenglEffectsAEFilterAVWrapper.a(paramRenderParams.jdField_a_of_type_ComTencentAvBusinessManagerPendantPendantItem, paramRenderParams.jdField_a_of_type_ComTencentTtpicOpenapiModelVideoMaterial);
      this.jdField_a_of_type_ComTencentAvOpenglEffectsAEFilterAVWrapper.a(paramBoolean1);
      this.jdField_a_of_type_ComTencentAvOpenglEffectsAEFilterAVWrapper.c(this.d, this.jdField_c_of_type_Int);
      this.jdField_b_of_type_ComTencentAvOpenglEffectsGLTexture = GLTexture.a(this.jdField_a_of_type_ComTencentAvOpenglEffectsGLTexture.jdField_a_of_type_Int, this.jdField_a_of_type_ComTencentAvOpenglEffectsGLTexture.jdField_b_of_type_Int);
      this.jdField_b_of_type_ComTencentAvOpenglEffectsGLTexture.jdField_b_of_type_Int = this.jdField_a_of_type_ComTencentAvOpenglEffectsAEFilterAVWrapper.a(this.jdField_a_of_type_ComTencentAvOpenglEffectsGLTexture.jdField_b_of_type_Int, false, this.jdField_a_of_type_ComTencentAvOpenglEffectsFaceData, paramRenderParams.jdField_b_of_type_Boolean);
      boolean bool4 = this.jdField_a_of_type_ComTencentAvOpenglEffectsAEFilterAVWrapper.c();
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
      localObject = this.jdField_a_of_type_ComTencentAvUtilsPerfRecorder;
      if (localObject != null) {
        ((PerfRecorder)localObject).b("drawFrameInGL");
      }
      if (paramFramePerfData != null)
      {
        if (paramRenderParams.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataFilterDesc != null) {
          bool1 = true;
        } else {
          bool1 = false;
        }
        if (paramRenderParams.jdField_a_of_type_ComTencentTtpicOpenapiModelVideoMaterial == null) {
          bool2 = false;
        }
        paramFramePerfData.a(bool1, bool2, paramBoolean1, paramBoolean2);
      }
      a(2, this.jdField_a_of_type_ComTencentAvOpenglEffectsGLTexture, this.jdField_b_of_type_ComTencentAvOpenglEffectsGLTexture);
      paramFramePerfData = this.jdField_a_of_type_ComTencentAvOpenglEffectsExtraRenderWrapper;
      if (paramFramePerfData != null) {
        paramFramePerfData.a(this.jdField_b_of_type_ComTencentAvOpenglEffectsGLTexture, bool3, bool4, this.jdField_a_of_type_Int, this.jdField_b_of_type_Int);
      }
    }
    paramFramePerfData = this.jdField_a_of_type_ComTencentAvOpenglEffectsExtraRenderWrapper;
    if (paramFramePerfData != null) {
      paramFramePerfData.a(paramCameraFrame, paramRenderParams);
    }
  }
  
  private void a(CameraFrame paramCameraFrame, RenderResult paramRenderResult, long paramLong)
  {
    PostRender localPostRender = this.jdField_a_of_type_ComTencentAvOpenglEffectsPostRender;
    if (localPostRender != null) {
      localPostRender.a(this, paramCameraFrame, this.jdField_b_of_type_ComTencentAvOpenglEffectsGLTexture, this.jdField_a_of_type_ComTencentAvOpenglEffectsFaceData, paramRenderResult);
    }
    this.jdField_c_of_type_Boolean = false;
    if (paramRenderResult.a == null) {
      paramRenderResult.a = paramCameraFrame;
    }
    long l = System.currentTimeMillis();
    paramRenderResult.a.f = ((int)(l - paramLong));
    paramRenderResult.a.g = this.e;
    paramRenderResult = this.jdField_a_of_type_ComTencentAvUtilsPerfRecorder;
    if (paramRenderResult != null) {
      paramRenderResult.a(paramCameraFrame.c);
    }
    MemoryPerfStat.a().a(this.e);
  }
  
  private void a(RenderParams paramRenderParams, IEffectCtrl paramIEffectCtrl, boolean paramBoolean)
  {
    if ((paramBoolean) || (paramRenderParams.jdField_a_of_type_ComTencentTtpicOpenapiModelVideoMaterial != null))
    {
      paramRenderParams = this.jdField_a_of_type_ComTencentAvUtilsPerfRecorder;
      if (paramRenderParams != null) {
        paramRenderParams.a("faceDetect");
      }
      paramRenderParams = this.jdField_a_of_type_ComTencentAvOpenglEffectsAEFilterAVWrapper;
      if (paramRenderParams != null) {
        paramRenderParams.a(this.jdField_a_of_type_ComTencentAvOpenglEffectsFaceData);
      }
      paramRenderParams = this.jdField_a_of_type_ComTencentAvUtilsPerfRecorder;
      if (paramRenderParams != null) {
        paramRenderParams.b("faceDetect");
      }
    }
  }
  
  private void b(CameraFrame paramCameraFrame, RenderResult paramRenderResult, long paramLong)
  {
    paramCameraFrame.jdField_a_of_type_Int = this.jdField_b_of_type_Int;
    paramCameraFrame.jdField_b_of_type_Int = this.jdField_a_of_type_Int;
    Object localObject = this.jdField_a_of_type_ComTencentAvOpenglEffectsFilterProcessTest;
    if (localObject != null)
    {
      ((FilterProcessTest)localObject).a(this, 5, paramCameraFrame, null);
      this.jdField_a_of_type_ComTencentAvOpenglEffectsFilterProcessTest.d();
    }
    this.jdField_c_of_type_Boolean = false;
    paramCameraFrame.f = ((int)(System.currentTimeMillis() - paramLong));
    paramCameraFrame.g = this.e;
    localObject = this.jdField_a_of_type_ComTencentAvOpenglEffectsPreRender;
    if (localObject != null) {
      ((PreRender)localObject).b();
    }
    localObject = this.jdField_a_of_type_ComTencentAvOpenglEffectsPostRender;
    if (localObject != null) {
      ((PostRender)localObject).b();
    }
    localObject = this.jdField_a_of_type_ComTencentAvUtilsPerfRecorder;
    if (localObject != null) {
      ((PerfRecorder)localObject).a(paramCameraFrame.c);
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
    arrayOfFloat[0] = -0.5F;
    arrayOfFloat[1] = -0.5F;
    arrayOfFloat[2] = 0.5F;
    arrayOfFloat[3] = -0.5F;
    arrayOfFloat[4] = -0.5F;
    arrayOfFloat[5] = 0.5F;
    arrayOfFloat[6] = 0.5F;
    arrayOfFloat[7] = 0.5F;
    ByteBuffer localByteBuffer = ByteBuffer.allocateDirect(arrayOfFloat.length * 4);
    localByteBuffer.order(ByteOrder.nativeOrder());
    this.jdField_a_of_type_JavaNioFloatBuffer = localByteBuffer.asFloatBuffer();
    this.jdField_a_of_type_JavaNioFloatBuffer.put(arrayOfFloat);
    this.jdField_a_of_type_JavaNioFloatBuffer.position(0);
  }
  
  void a()
  {
    AEFilterAVWrapper localAEFilterAVWrapper = this.jdField_a_of_type_ComTencentAvOpenglEffectsAEFilterAVWrapper;
    if (localAEFilterAVWrapper != null) {
      localAEFilterAVWrapper.c();
    }
  }
  
  protected void a(int paramInt)
  {
    this.e = (paramInt | this.e);
  }
  
  public void a(int paramInt, GLTexture paramGLTexture1, GLTexture paramGLTexture2)
  {
    FilterProcessTest localFilterProcessTest = this.jdField_a_of_type_ComTencentAvOpenglEffectsFilterProcessTest;
    if ((localFilterProcessTest != null) && (localFilterProcessTest.jdField_a_of_type_Boolean))
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
    AEFilterAVWrapper localAEFilterAVWrapper = this.jdField_a_of_type_ComTencentAvOpenglEffectsAEFilterAVWrapper;
    if (localAEFilterAVWrapper != null)
    {
      localAEFilterAVWrapper.a(paramLong);
      return;
    }
    TipsInfo.a().a(paramLong);
  }
  
  public void a(long paramLong, int paramInt)
  {
    if (AudioHelper.b())
    {
      localObject = this.jdField_a_of_type_JavaLangString;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("initial, szie[");
      localStringBuilder.append(this.jdField_a_of_type_Int);
      localStringBuilder.append(", ");
      localStringBuilder.append(this.jdField_b_of_type_Int);
      localStringBuilder.append("], id[");
      localStringBuilder.append(this.jdField_c_of_type_Int);
      localStringBuilder.append("], seq[");
      localStringBuilder.append(paramLong);
      localStringBuilder.append("]");
      QLog.w((String)localObject, 1, localStringBuilder.toString());
    }
    Object localObject = this.jdField_a_of_type_ComTencentAvOpenglEffectsFilterProcessTest;
    if (localObject != null) {
      ((FilterProcessTest)localObject).a();
    }
    this.jdField_a_of_type_Boolean = true;
    this.jdField_c_of_type_Boolean = false;
    if (this.jdField_c_of_type_Int != -1) {
      return;
    }
    if ((EffectCtrlBase.b()) && (this.jdField_a_of_type_ComTencentAvOpenglEffectsAEFilterAVWrapper == null))
    {
      this.jdField_a_of_type_ComTencentAvOpenglEffectsAEFilterAVWrapper = new AEFilterAVWrapperImpl(paramInt);
      this.jdField_a_of_type_ComTencentAvOpenglEffectsAEFilterAVWrapper.a(this.jdField_a_of_type_Int, this.jdField_b_of_type_Int);
    }
    localObject = new int[1];
    GLES20.glGenTextures(localObject.length, (int[])localObject, 0);
    this.jdField_c_of_type_Int = localObject[0];
    localObject = this.jdField_a_of_type_ComTencentAvOpenglEffectsPreRender;
    if (localObject != null) {
      ((PreRender)localObject).a();
    }
    localObject = this.jdField_a_of_type_ComTencentAvOpenglEffectsPostRender;
    if (localObject != null) {
      ((PostRender)localObject).a();
    }
    this.e = 0;
    localObject = this.jdField_a_of_type_ComTencentAvOpenglEffectsExtraRenderWrapper;
    if (localObject != null) {
      ((ExtraRenderWrapper)localObject).a();
    }
  }
  
  public void a(CameraFrame paramCameraFrame, RenderParams paramRenderParams, IEffectCtrl paramIEffectCtrl, RenderResult paramRenderResult)
  {
    Object localObject1 = this.jdField_a_of_type_ComTencentAvOpenglEffectsFilterProcessTest;
    if (localObject1 != null) {
      ((FilterProcessTest)localObject1).a();
    }
    localObject1 = this.jdField_a_of_type_ComTencentAvUtilsPerfRecorder;
    if (localObject1 != null) {
      ((PerfRecorder)localObject1).b();
    }
    long l = System.currentTimeMillis();
    paramRenderResult.a = paramCameraFrame;
    a(0L, paramCameraFrame.jdField_b_of_type_Int, paramCameraFrame.jdField_a_of_type_Int);
    int i = paramCameraFrame.jdField_a_of_type_Int;
    int j = paramCameraFrame.jdField_b_of_type_Int;
    int k = RenderUtil.a(paramCameraFrame.jdField_a_of_type_Boolean);
    boolean bool2 = paramRenderParams.jdField_a_of_type_Boolean;
    Object localObject2;
    if (this.jdField_b_of_type_Boolean != bool2)
    {
      if (QLog.isDevelopLevel())
      {
        localObject1 = this.jdField_a_of_type_JavaLangString;
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("render, needFaceData[");
        ((StringBuilder)localObject2).append(bool2);
        ((StringBuilder)localObject2).append("]");
        QLog.i((String)localObject1, 4, ((StringBuilder)localObject2).toString());
      }
      this.jdField_b_of_type_Boolean = bool2;
    }
    int m = this.jdField_a_of_type_ComTencentAvOpenglEffectsBeautyConfig.a("BEAUTY_SKIN");
    this.jdField_a_of_type_ComTencentAvOpenglEffectsRenderInfoLog.a(this.jdField_a_of_type_JavaLangString, paramCameraFrame.c, i, j, paramCameraFrame.d, paramRenderParams.jdField_a_of_type_Boolean, paramRenderParams.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataFilterDesc, paramRenderParams.jdField_a_of_type_ComTencentTtpicOpenapiModelVideoMaterial, paramRenderParams.jdField_a_of_type_ComTencentAvBusinessManagerPendantPendantItem, paramCameraFrame, m);
    if ((this.jdField_a_of_type_Int != 0) && (this.jdField_b_of_type_Int != 0) && (!paramCameraFrame.a()) && (this.d != -1))
    {
      if (!this.jdField_a_of_type_Boolean) {
        return;
      }
      this.jdField_c_of_type_Boolean = true;
      localObject2 = paramCameraFrame.jdField_a_of_type_ComTencentAvUtilsFramePerfData;
      if (localObject2 != null) {
        ((FramePerfData)localObject2).a(k);
      }
      this.jdField_a_of_type_ComTencentAvOpenglEffectsFaceData.a(i, j);
      if (paramCameraFrame.b())
      {
        localObject1 = this.jdField_a_of_type_ComTencentAvOpenglEffectsFilterProcessTest;
        if (localObject1 != null)
        {
          ((FilterProcessTest)localObject1).c();
          this.jdField_a_of_type_ComTencentAvOpenglEffectsFilterProcessTest.a(this, 0, paramCameraFrame, null);
        }
      }
      localObject1 = this.jdField_a_of_type_ComTencentAvOpenglEffectsAEFilterAVWrapper;
      boolean bool1;
      if (localObject1 != null) {
        bool1 = ((AEFilterAVWrapper)localObject1).a(this.jdField_a_of_type_ComTencentAvOpenglEffectsBeautyConfig);
      } else {
        bool1 = false;
      }
      localObject1 = paramRenderParams;
      if ((((RenderParams)localObject1).jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataFilterDesc == null) && (((RenderParams)localObject1).jdField_a_of_type_ComTencentTtpicOpenapiModelVideoMaterial == null)) {
        i = 0;
      } else {
        i = 1;
      }
      if ((i == 0) && (!bool2) && (!bool1)) {
        i = 0;
      } else {
        i = 1;
      }
      if ((((RenderParams)localObject1).jdField_c_of_type_Boolean) && (i != 0))
      {
        PerfReporter.a("prerender_time", 0);
        a(paramCameraFrame);
        PerfReporter.a("prerender_time", 1);
        PerfReporter.a("aefilter_time", 0);
        a(paramCameraFrame, paramRenderParams, bool2, (FramePerfData)localObject2, bool1);
        PerfReporter.a("aefilter_time", 1);
        a((RenderParams)localObject1, paramIEffectCtrl, bool2);
        PerfReporter.a("postrender_time", 0);
        a(paramCameraFrame, paramRenderResult, l);
        PerfReporter.a("postrender_time", 1);
        return;
      }
      if (paramCameraFrame.b())
      {
        b(paramCameraFrame, paramRenderResult, l);
        return;
      }
      PerfReporter.a("prerender_time", 0);
      a(paramCameraFrame);
      PerfReporter.a("prerender_time", 1);
      PerfReporter.a("postrender_time", 0);
      a(paramCameraFrame, paramRenderResult, l);
      PerfReporter.a("postrender_time", 1);
    }
  }
  
  void b()
  {
    long l = AudioHelper.b();
    Object localObject = this.jdField_a_of_type_JavaLangString;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("uninit, mIsInited[");
    localStringBuilder.append(this.jdField_a_of_type_Boolean);
    localStringBuilder.append("], mIsRendering[");
    localStringBuilder.append(this.jdField_c_of_type_Boolean);
    localStringBuilder.append("], seq[");
    localStringBuilder.append(l);
    localStringBuilder.append("]");
    QLog.w((String)localObject, 1, localStringBuilder.toString());
    if (!this.jdField_a_of_type_Boolean) {
      return;
    }
    this.jdField_a_of_type_Boolean = false;
    localObject = this.jdField_a_of_type_ComTencentAvOpenglEffectsFilterProcessTest;
    if (localObject != null) {
      ((FilterProcessTest)localObject).b();
    }
    localObject = this.jdField_a_of_type_ComTencentAvOpenglEffectsPostRender;
    if (localObject != null) {
      ((PostRender)localObject).b();
    }
    localObject = this.jdField_a_of_type_ComTencentAvOpenglEffectsPreRender;
    if (localObject != null) {
      ((PreRender)localObject).b();
    }
    a(l);
    localObject = this.jdField_a_of_type_ComTencentAvOpenglEffectsAEFilterAVWrapper;
    if (localObject != null) {
      ((AEFilterAVWrapper)localObject).a();
    }
    localObject = this.jdField_a_of_type_ComTencentAvUtilsPerfRecorder;
    if (localObject != null) {
      ((PerfRecorder)localObject).a();
    }
    TipsInfo.a().a();
  }
  
  public void b(long paramLong)
  {
    Object localObject = this.jdField_a_of_type_JavaLangString;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("clear, seq[");
    localStringBuilder.append(paramLong);
    localStringBuilder.append("]");
    QLog.w((String)localObject, 1, localStringBuilder.toString());
    localObject = this.jdField_a_of_type_ComTencentAvOpenglEffectsPreRender;
    if (localObject != null)
    {
      ((PreRender)localObject).b();
      this.jdField_a_of_type_ComTencentAvOpenglEffectsPreRender.c();
    }
    int i = this.d;
    if (i != -1)
    {
      GLES20.glDeleteFramebuffers(1, new int[] { i }, 0);
      this.d = -1;
    }
    i = this.jdField_c_of_type_Int;
    if (i != -1)
    {
      localObject = new int[1];
      localObject[0] = i;
      GLES20.glDeleteTextures(localObject.length, (int[])localObject, 0);
      this.jdField_c_of_type_Int = -1;
    }
    localObject = this.jdField_a_of_type_ComTencentAvOpenglEffectsPostRender;
    if (localObject != null) {
      ((PostRender)localObject).c();
    }
    localObject = this.jdField_a_of_type_ComTencentAvOpenglEffectsAEFilterAVWrapper;
    if (localObject != null)
    {
      ((AEFilterAVWrapper)localObject).b();
      this.jdField_a_of_type_ComTencentAvOpenglEffectsAEFilterAVWrapper = null;
    }
    localObject = this.jdField_a_of_type_ComTencentAvOpenglEffectsExtraRenderWrapper;
    if (localObject != null) {
      ((ExtraRenderWrapper)localObject).b();
    }
    TipsInfo.a().a(paramLong);
  }
  
  protected void c()
  {
    GLTexture localGLTexture = this.jdField_a_of_type_ComTencentAvOpenglEffectsGLTexture;
    if ((localGLTexture != this.jdField_b_of_type_ComTencentAvOpenglEffectsGLTexture) && (localGLTexture != null))
    {
      localGLTexture.a();
      this.jdField_a_of_type_ComTencentAvOpenglEffectsGLTexture = null;
    }
    this.jdField_a_of_type_ComTencentAvOpenglEffectsGLTexture = this.jdField_b_of_type_ComTencentAvOpenglEffectsGLTexture;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.opengl.effects.FilterProcessRender
 * JD-Core Version:    0.7.0.1
 */