package com.tencent.mobileqq.activity.richmedia.view;

import android.annotation.TargetApi;
import android.content.Context;
import android.opengl.EGL14;
import android.opengl.GLES20;
import android.opengl.GLSurfaceView;
import android.opengl.GLSurfaceView.Renderer;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Message;
import android.os.SystemClock;
import android.util.AttributeSet;
import android.view.SurfaceHolder;
import com.tencent.av.opengl.GraphicRenderMgr;
import com.tencent.common.app.AppInterface;
import com.tencent.maxvideo.common.AVIOStruct;
import com.tencent.mobileqq.activity.richmedia.NewFlowCameraReporter;
import com.tencent.mobileqq.activity.richmedia.ShortVideoCaptureController;
import com.tencent.mobileqq.activity.richmedia.ShortVideoCaptureController.CaptureTriggerObserver;
import com.tencent.mobileqq.activity.richmedia.state.RMVideoClipSpec;
import com.tencent.mobileqq.activity.richmedia.state.RMVideoStateMgr;
import com.tencent.mobileqq.ar.FramePerformanceMonitor;
import com.tencent.mobileqq.shortvideo.PtvTemplateManager;
import com.tencent.mobileqq.shortvideo.ShortVideoUtils;
import com.tencent.mobileqq.shortvideo.VideoEnvironment;
import com.tencent.mobileqq.shortvideo.gesture.GestureUtil;
import com.tencent.mobileqq.shortvideo.hwcodec.SVHwEncoder;
import com.tencent.mobileqq.shortvideo.mediadevice.FilterPreviewContext;
import com.tencent.mobileqq.shortvideo.mediadevice.PreviewContext;
import com.tencent.mobileqq.shortvideo.ptvfilter.FilterProcessRender;
import com.tencent.mobileqq.shortvideo.ptvfilter.gesture.GestureFilterManager;
import com.tencent.mobileqq.shortvideo.ptvfilter.gesture.GestureMonitorManager;
import com.tencent.mobileqq.shortvideo.ptvfilter.test.PtvFilterTimeStatistics;
import com.tencent.mobileqq.shortvideo.util.GlPostProcessThread;
import com.tencent.mobileqq.shortvideo.util.GlPostProcessThread.FilterDrawFrameParam;
import com.tencent.mobileqq.shortvideo.util.GlPostProcessThread.FilterInitParam;
import com.tencent.mobileqq.shortvideo.util.OffScreenGLSurface;
import com.tencent.mobileqq.shortvideo.util.OffScreenGLSurface.GLSharedData;
import com.tencent.mobileqq.shortvideo.util.PtvFilterUtils;
import com.tencent.mobileqq.shortvideo.util.SVFilterEncodeDoubleCache;
import com.tencent.mobileqq.shortvideo.util.SVFilterEncodeDoubleCache.SharedMemoryCache;
import com.tencent.mobileqq.shortvideo.util.TextureDataPipe;
import com.tencent.mobileqq.shortvideo.util.TextureDataPipe.FrameMetaData;
import com.tencent.mobileqq.shortvideo.util.TextureDataPipe.OnFrameAvailableListener;
import com.tencent.mobileqq.shortvideo.util.TexturePileQueue;
import com.tencent.qphone.base.util.QLog;
import com.tencent.ttpic.openapi.filter.RenderBuffer;
import com.tencent.ttpic.openapi.filter.TextureRender;
import com.tencent.ttpic.openapi.util.VideoPrefsUtil;
import dov.com.qq.im.ae.AEKitForQQ;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;

public class CameraFilterGLView
  extends GLSurfaceView
  implements GLSurfaceView.Renderer, ShortVideoCaptureController.CaptureTriggerObserver
{
  private static final GlPostProcessThread jdField_a_of_type_ComTencentMobileqqShortvideoUtilGlPostProcessThread = new GlPostProcessThread();
  private static OffScreenGLSurface jdField_a_of_type_ComTencentMobileqqShortvideoUtilOffScreenGLSurface;
  private int jdField_a_of_type_Int = 240;
  private Handler jdField_a_of_type_AndroidOsHandler;
  public AppInterface a;
  private CameraFilterGLView.CameraGlFilterListener jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewCameraFilterGLView$CameraGlFilterListener;
  private CameraFilterGLView.FaceDetectedCtrl jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewCameraFilterGLView$FaceDetectedCtrl = new CameraFilterGLView.FaceDetectedCtrl(null);
  private CameraFilterGLView.FilterStatusRecord jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewCameraFilterGLView$FilterStatusRecord = new CameraFilterGLView.FilterStatusRecord(null);
  private CameraFilterGLView.GLSurfaceEGLContextLifeCtl jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewCameraFilterGLView$GLSurfaceEGLContextLifeCtl = new CameraFilterGLView.GLSurfaceEGLContextLifeCtl(this, null);
  private CameraFilterGLView.GestureDetectedCtrl jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewCameraFilterGLView$GestureDetectedCtrl = new CameraFilterGLView.GestureDetectedCtrl(null);
  public CameraFilterGLView.SVRecordSessionParam a;
  public FramePerformanceMonitor a;
  public FilterPreviewContext a;
  private PreviewContext jdField_a_of_type_ComTencentMobileqqShortvideoMediadevicePreviewContext;
  public FilterProcessRender a;
  private SVFilterEncodeDoubleCache jdField_a_of_type_ComTencentMobileqqShortvideoUtilSVFilterEncodeDoubleCache = new SVFilterEncodeDoubleCache();
  private TextureDataPipe.OnFrameAvailableListener jdField_a_of_type_ComTencentMobileqqShortvideoUtilTextureDataPipe$OnFrameAvailableListener = new CameraFilterGLView.2(this);
  private RenderBuffer jdField_a_of_type_ComTencentTtpicOpenapiFilterRenderBuffer;
  private TextureRender jdField_a_of_type_ComTencentTtpicOpenapiFilterTextureRender;
  private final Object jdField_a_of_type_JavaLangObject = new Object();
  private String jdField_a_of_type_JavaLangString = null;
  public AtomicReference<SVHwEncoder> a;
  private boolean jdField_a_of_type_Boolean = false;
  private int jdField_b_of_type_Int = 240;
  private boolean jdField_b_of_type_Boolean = false;
  private int jdField_c_of_type_Int;
  private boolean jdField_c_of_type_Boolean = false;
  private int jdField_d_of_type_Int;
  private boolean jdField_d_of_type_Boolean;
  private int jdField_e_of_type_Int = 90;
  private boolean jdField_e_of_type_Boolean;
  private int jdField_f_of_type_Int = 90;
  private boolean jdField_f_of_type_Boolean = false;
  private boolean g;
  private volatile boolean h = false;
  private volatile boolean i = false;
  private boolean j = false;
  private boolean k = false;
  
  static
  {
    AEKitForQQ.a();
    VideoPrefsUtil.init(VideoEnvironment.getContext(), ShortVideoUtils.getPtvTemplateSDKPref());
    VideoPrefsUtil.setMaterialMute(false);
    GraphicRenderMgr.loadSo();
  }
  
  public CameraFilterGLView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public CameraFilterGLView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.jdField_a_of_type_ComTencentMobileqqShortvideoPtvfilterFilterProcessRender = new FilterProcessRender();
    this.jdField_a_of_type_ComTencentCommonAppAppInterface = null;
    this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewCameraFilterGLView$SVRecordSessionParam = new CameraFilterGLView.SVRecordSessionParam();
    this.jdField_a_of_type_ComTencentMobileqqShortvideoMediadeviceFilterPreviewContext = new FilterPreviewContext();
    this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicReference = new AtomicReference(null);
    h();
  }
  
  private Handler a()
  {
    Handler localHandler1 = null;
    if (jdField_a_of_type_ComTencentMobileqqShortvideoUtilOffScreenGLSurface != null) {
      localHandler1 = jdField_a_of_type_ComTencentMobileqqShortvideoUtilOffScreenGLSurface.a();
    }
    Handler localHandler2 = localHandler1;
    if (localHandler1 == null) {
      localHandler2 = this.jdField_a_of_type_ComTencentMobileqqShortvideoMediadevicePreviewContext.mMsghandler;
    }
    return localHandler2;
  }
  
  private SVFilterEncodeDoubleCache.SharedMemoryCache a(int paramInt)
  {
    return a(paramInt, null);
  }
  
  private SVFilterEncodeDoubleCache.SharedMemoryCache a(int paramInt, AVIOStruct paramAVIOStruct)
  {
    SVFilterEncodeDoubleCache.SharedMemoryCache localSharedMemoryCache = this.jdField_a_of_type_ComTencentMobileqqShortvideoUtilSVFilterEncodeDoubleCache.a();
    if (localSharedMemoryCache == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("PtvFilterUtils", 2, "PtvFilterUtils_onDrawFrame[writeSharedMemtoFileDegree]memoryCache=null");
      }
      return null;
    }
    if (localSharedMemoryCache.a(this.jdField_c_of_type_Int, this.jdField_d_of_type_Int, 4))
    {
      PtvFilterUtils.a(paramInt, this.jdField_c_of_type_Int, this.jdField_d_of_type_Int, 4, localSharedMemoryCache.a, paramAVIOStruct);
      return localSharedMemoryCache;
    }
    localSharedMemoryCache.a();
    return null;
  }
  
  public static void a()
  {
    jdField_a_of_type_ComTencentMobileqqShortvideoUtilOffScreenGLSurface = null;
  }
  
  private void a(int paramInt)
  {
    this.j = false;
    this.jdField_a_of_type_ComTencentTtpicOpenapiFilterRenderBuffer.bind();
    this.jdField_a_of_type_ComTencentTtpicOpenapiFilterTextureRender.drawTexture(3553, paramInt, null, null);
    this.jdField_a_of_type_ComTencentTtpicOpenapiFilterRenderBuffer.unbind();
    SVFilterEncodeDoubleCache.SharedMemoryCache localSharedMemoryCache = a(this.jdField_a_of_type_ComTencentTtpicOpenapiFilterRenderBuffer.getTexId());
    if (localSharedMemoryCache != null)
    {
      ShortVideoCaptureController.a();
      this.jdField_a_of_type_ComTencentMobileqqShortvideoUtilSVFilterEncodeDoubleCache.a(new CameraFilterGLView.3(this, localSharedMemoryCache));
      return;
    }
    ShortVideoCaptureController.a(1);
    QLog.e("PtvFilterUtils", 2, "Capture picture failed, cacheSuccess == null.");
  }
  
  private void a(SVFilterEncodeDoubleCache.SharedMemoryCache paramSharedMemoryCache, int paramInt1, boolean paramBoolean, AVIOStruct paramAVIOStruct, int paramInt2, FilterPreviewContext paramFilterPreviewContext)
  {
    CameraFilterGLView.SharedMemWriteFile localSharedMemWriteFile = GlPostProcessThread.a(paramSharedMemoryCache);
    localSharedMemWriteFile.jdField_a_of_type_Int = this.jdField_c_of_type_Int;
    localSharedMemWriteFile.jdField_b_of_type_Int = this.jdField_d_of_type_Int;
    localSharedMemWriteFile.jdField_c_of_type_Int = paramInt1;
    localSharedMemWriteFile.jdField_a_of_type_ComTencentMaxvideoCommonAVIOStruct = paramAVIOStruct;
    localSharedMemWriteFile.jdField_a_of_type_ComTencentMobileqqShortvideoUtilSVFilterEncodeDoubleCache$SharedMemoryCache = paramSharedMemoryCache;
    localSharedMemWriteFile.jdField_a_of_type_Boolean = paramBoolean;
    localSharedMemWriteFile.jdField_b_of_type_Boolean = this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewCameraFilterGLView$SVRecordSessionParam.jdField_a_of_type_Boolean;
    localSharedMemWriteFile.jdField_a_of_type_ComTencentMobileqqShortvideoUtilSVFilterEncodeDoubleCache = this.jdField_a_of_type_ComTencentMobileqqShortvideoUtilSVFilterEncodeDoubleCache;
    localSharedMemWriteFile.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewCameraFilterGLView$CameraGlFilterListener = this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewCameraFilterGLView$CameraGlFilterListener;
    localSharedMemWriteFile.jdField_d_of_type_Int = paramInt2;
    localSharedMemWriteFile.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicReference = this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicReference;
    localSharedMemWriteFile.jdField_a_of_type_ComTencentMobileqqShortvideoMediadeviceFilterPreviewContext = paramFilterPreviewContext;
    this.jdField_a_of_type_ComTencentMobileqqShortvideoUtilSVFilterEncodeDoubleCache.a(localSharedMemWriteFile);
  }
  
  private void a(TextureDataPipe paramTextureDataPipe)
  {
    paramTextureDataPipe = (AVIOStruct)paramTextureDataPipe.jdField_a_of_type_ComTencentMobileqqShortvideoUtilTextureDataPipe$FrameMetaData.jdField_a_of_type_JavaLangObject;
    if (QLog.isColorLevel()) {
      QLog.d("PtvFilterUtils", 2, "PtvFilterUtils_onDrawFrame[printSourceDataTimeStamp=" + paramTextureDataPipe.vFrameTime + "ms]");
    }
  }
  
  @TargetApi(17)
  private boolean b()
  {
    boolean bool = false;
    Handler localHandler = a();
    Message localMessage = Message.obtain(localHandler);
    localMessage.what = -16716523;
    jdField_a_of_type_ComTencentMobileqqShortvideoUtilOffScreenGLSurface.a.a(EGL14.eglGetCurrentContext());
    jdField_a_of_type_ComTencentMobileqqShortvideoUtilOffScreenGLSurface.a.a = this.jdField_a_of_type_ComTencentMobileqqShortvideoPtvfilterFilterProcessRender.a();
    if (localHandler != null)
    {
      localHandler.sendMessage(localMessage);
      bool = true;
    }
    while (!QLog.isColorLevel()) {
      return bool;
    }
    QLog.d("CameraFilterGLView", 2, "setSurfaceCreated mHandler is null=");
    return false;
  }
  
  private void h()
  {
    super.setEGLContextClientVersion(2);
    super.setEGLConfigChooser(8, 8, 8, 8, 16, 0);
    this.g = false;
    super.setRenderer(this);
    super.setRenderMode(0);
    super.getHolder().setFormat(1);
    this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewCameraFilterGLView$CameraGlFilterListener = null;
    this.jdField_a_of_type_AndroidOsHandler = null;
    i();
    b();
    jdField_a_of_type_ComTencentMobileqqShortvideoUtilGlPostProcessThread.a();
    ShortVideoCaptureController.a(this);
  }
  
  private void i()
  {
    this.jdField_e_of_type_Boolean = false;
    this.jdField_d_of_type_Boolean = false;
    this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewCameraFilterGLView$FaceDetectedCtrl.jdField_b_of_type_Boolean = false;
    this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewCameraFilterGLView$FaceDetectedCtrl.jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewCameraFilterGLView$FaceDetectedCtrl.jdField_a_of_type_Int = 0;
    this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewCameraFilterGLView$FaceDetectedCtrl.jdField_c_of_type_Boolean = false;
    this.jdField_a_of_type_ComTencentMobileqqShortvideoPtvfilterFilterProcessRender.jdField_b_of_type_Boolean = false;
    this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewCameraFilterGLView$GestureDetectedCtrl.jdField_b_of_type_Boolean = false;
    this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewCameraFilterGLView$GestureDetectedCtrl.jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewCameraFilterGLView$GestureDetectedCtrl.jdField_a_of_type_Int = 0;
    this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewCameraFilterGLView$GestureDetectedCtrl.jdField_c_of_type_Boolean = false;
    this.jdField_a_of_type_ComTencentMobileqqShortvideoPtvfilterFilterProcessRender.jdField_f_of_type_Boolean = false;
    this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewCameraFilterGLView$FilterStatusRecord.a();
    GestureFilterManager.sGestureType = "";
    GestureFilterManager.sGestureTips = "";
  }
  
  private void j()
  {
    if (jdField_a_of_type_ComTencentMobileqqShortvideoUtilOffScreenGLSurface != null) {
      jdField_a_of_type_ComTencentMobileqqShortvideoUtilOffScreenGLSurface.a(this.jdField_a_of_type_ComTencentMobileqqShortvideoMediadevicePreviewContext);
    }
  }
  
  private void k()
  {
    int i1 = this.jdField_c_of_type_Int;
    int n = this.jdField_d_of_type_Int;
    int m = i1 / 2;
    n /= 2;
    while ((m > 100) && (n > 100))
    {
      int i2 = m / 2;
      n /= 2;
      i1 = m;
      m = i2;
    }
    if (QLog.isColorLevel()) {
      QLog.d("PtvFilterUtils", 2, "PtvFilterUtils_onDrawFrame tempWidth=" + i1 + "mDrawVideoWidth=" + this.jdField_c_of_type_Int);
    }
  }
  
  @TargetApi(17)
  private void l()
  {
    this.jdField_a_of_type_ComTencentMobileqqShortvideoPtvfilterFilterProcessRender.a(this.jdField_c_of_type_Int, this.jdField_d_of_type_Int);
    jdField_a_of_type_ComTencentMobileqqShortvideoUtilGlPostProcessThread.a.a(EGL14.eglGetCurrentContext(), this.jdField_c_of_type_Int, this.jdField_d_of_type_Int);
    Message localMessage = Message.obtain();
    localMessage.what = 57379;
    jdField_a_of_type_ComTencentMobileqqShortvideoUtilGlPostProcessThread.a(localMessage);
    k();
    this.jdField_a_of_type_ComTencentMobileqqShortvideoPtvfilterFilterProcessRender.b(this.jdField_c_of_type_Int, this.jdField_d_of_type_Int);
  }
  
  private void m()
  {
    if (this.jdField_a_of_type_Boolean) {
      this.jdField_b_of_type_Boolean = true;
    }
    this.jdField_a_of_type_ComTencentMobileqqShortvideoPtvfilterFilterProcessRender.e();
    super.requestRender();
  }
  
  private void n()
  {
    Handler localHandler = null;
    if (jdField_a_of_type_ComTencentMobileqqShortvideoUtilOffScreenGLSurface != null)
    {
      localHandler = jdField_a_of_type_ComTencentMobileqqShortvideoUtilOffScreenGLSurface.a();
      jdField_a_of_type_ComTencentMobileqqShortvideoUtilOffScreenGLSurface.a.a();
    }
    if (localHandler != null)
    {
      Message localMessage = Message.obtain(localHandler);
      localMessage.what = -16716522;
      localHandler.sendMessage(localMessage);
    }
  }
  
  private void o()
  {
    if (jdField_a_of_type_ComTencentMobileqqShortvideoUtilOffScreenGLSurface != null) {
      jdField_a_of_type_ComTencentMobileqqShortvideoUtilOffScreenGLSurface.b();
    }
  }
  
  public void a(String paramString, int paramInt)
  {
    this.jdField_a_of_type_JavaLangString = paramString;
    this.j = true;
    this.jdField_f_of_type_Int = paramInt;
  }
  
  public void a(boolean paramBoolean)
  {
    if ((!this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewCameraFilterGLView$GestureDetectedCtrl.jdField_a_of_type_Boolean) || (this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewCameraFilterGLView$FilterStatusRecord.jdField_a_of_type_Int == 0)) {
      return;
    }
    queueEvent(new CameraFilterGLView.4(this));
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqShortvideoUtilSVFilterEncodeDoubleCache.a();
  }
  
  public void b()
  {
    if (QLog.isColorLevel()) {
      QLog.d("PtvFilterUtils", 2, "createInputSurface inputSurface=" + jdField_a_of_type_ComTencentMobileqqShortvideoUtilOffScreenGLSurface + "  preViewContext=" + this.jdField_a_of_type_ComTencentMobileqqShortvideoMediadevicePreviewContext);
    }
    if (jdField_a_of_type_ComTencentMobileqqShortvideoUtilOffScreenGLSurface == null)
    {
      jdField_a_of_type_ComTencentMobileqqShortvideoUtilOffScreenGLSurface = new OffScreenGLSurface();
      jdField_a_of_type_ComTencentMobileqqShortvideoUtilOffScreenGLSurface.a();
    }
  }
  
  public void c()
  {
    if ((jdField_a_of_type_ComTencentMobileqqShortvideoUtilOffScreenGLSurface != null) && (jdField_a_of_type_ComTencentMobileqqShortvideoUtilOffScreenGLSurface.a.a != null)) {
      jdField_a_of_type_ComTencentMobileqqShortvideoUtilOffScreenGLSurface.a.a.b();
    }
    if (jdField_a_of_type_ComTencentMobileqqShortvideoUtilGlPostProcessThread != null) {
      jdField_a_of_type_ComTencentMobileqqShortvideoUtilGlPostProcessThread.b();
    }
    if (this.jdField_a_of_type_ComTencentMobileqqShortvideoUtilSVFilterEncodeDoubleCache != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqShortvideoUtilSVFilterEncodeDoubleCache.c();
      this.jdField_a_of_type_ComTencentMobileqqShortvideoUtilSVFilterEncodeDoubleCache.a();
    }
  }
  
  public void d()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqShortvideoPtvfilterFilterProcessRender != null) {
      this.jdField_a_of_type_ComTencentMobileqqShortvideoPtvfilterFilterProcessRender.g = true;
    }
  }
  
  public void e()
  {
    if (QLog.isColorLevel()) {
      QLog.d("CameraFilterGLView", 2, "sendOffScreenGLSurfaceEGLFinish:mHasSendSurfaceFinishMsg=" + this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewCameraFilterGLView$GLSurfaceEGLContextLifeCtl.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean);
    }
    if (!this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewCameraFilterGLView$GLSurfaceEGLContextLifeCtl.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.getAndSet(true)) {
      n();
    }
    if (QLog.isColorLevel()) {
      QLog.d("CameraFilterGLView", 2, "sendOffScreenGLSurfaceEGLFinish:mHasSendSurfaceFinishMsg2=" + this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewCameraFilterGLView$GLSurfaceEGLContextLifeCtl.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean);
    }
  }
  
  public void f()
  {
    o();
  }
  
  public void g()
  {
    jdField_a_of_type_ComTencentMobileqqShortvideoUtilGlPostProcessThread.c();
  }
  
  @TargetApi(17)
  public void onDrawFrame(GL10 paramGL10)
  {
    if (this.jdField_b_of_type_Boolean) {
      if (this.jdField_a_of_type_ComTencentMobileqqShortvideoPtvfilterFilterProcessRender != null) {
        if (jdField_a_of_type_ComTencentMobileqqShortvideoUtilOffScreenGLSurface.a.a == null) {
          break label1446;
        }
      }
    }
    label153:
    label1052:
    label1058:
    label1446:
    for (paramGL10 = jdField_a_of_type_ComTencentMobileqqShortvideoUtilOffScreenGLSurface.a.a.c();; paramGL10 = null)
    {
      if (paramGL10 != null) {
        paramGL10.f();
      }
      int m = 90;
      if (this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewCameraFilterGLView$CameraGlFilterListener != null) {
        m = this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewCameraFilterGLView$CameraGlFilterListener.c();
      }
      if ((m == 90) || (m != this.jdField_e_of_type_Int)) {}
      this.jdField_e_of_type_Int = m;
      Object localObject1;
      boolean bool1;
      boolean bool2;
      label241:
      Object localObject2;
      if (paramGL10 != null)
      {
        a(paramGL10);
        long l1 = PtvFilterUtils.a();
        localObject1 = GestureMonitorManager.a();
        if ((this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewCameraFilterGLView$FilterStatusRecord.jdField_a_of_type_Int != 0) && (this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewCameraFilterGLView$FilterStatusRecord.jdField_a_of_type_Int != 2)) {
          break label1052;
        }
        bool1 = true;
        if ((this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewCameraFilterGLView$FilterStatusRecord.jdField_a_of_type_Int != 1) && (this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewCameraFilterGLView$FilterStatusRecord.jdField_a_of_type_Int != 2)) {
          break label1058;
        }
        bool2 = true;
        ((GestureMonitorManager)localObject1).a(bool1, bool2);
        GestureMonitorManager.a().a();
        if (this.jdField_a_of_type_ComTencentTtpicOpenapiFilterTextureRender == null) {
          break label1064;
        }
        m = this.jdField_a_of_type_ComTencentMobileqqShortvideoPtvfilterFilterProcessRender.a(this.jdField_a_of_type_Int, this.jdField_b_of_type_Int, paramGL10.jdField_a_of_type_Int, true, paramGL10.jdField_a_of_type_ComTencentMobileqqShortvideoUtilTextureDataPipe$FrameMetaData.jdField_b_of_type_Boolean, this.jdField_a_of_type_ComTencentMobileqqArFramePerformanceMonitor, false);
        GLES20.glBindFramebuffer(36160, 0);
        GLES20.glViewport(0, 0, this.jdField_a_of_type_Int, this.jdField_b_of_type_Int);
        this.jdField_a_of_type_ComTencentTtpicOpenapiFilterTextureRender.drawTexture(3553, m, null, null);
        l1 = (PtvFilterUtils.a() - l1) / 1000L;
        GestureMonitorManager.a().b();
        if (QLog.isColorLevel()) {
          QLog.d("PtvFilterUtils", 2, "PtvFilterUtils_onDrawFrame[showPreview=" + l1 / 1000.0D + "ms]");
        }
        if ((!this.jdField_e_of_type_Boolean) && (this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewCameraFilterGLView$CameraGlFilterListener != null))
        {
          this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewCameraFilterGLView$CameraGlFilterListener.L();
          this.jdField_e_of_type_Boolean = true;
        }
        if ((this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewCameraFilterGLView$FaceDetectedCtrl.jdField_a_of_type_Boolean) && (this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewCameraFilterGLView$CameraGlFilterListener != null) && (this.jdField_a_of_type_ComTencentMobileqqShortvideoPtvfilterFilterProcessRender.jdField_d_of_type_Boolean))
        {
          if (!this.jdField_a_of_type_ComTencentMobileqqShortvideoPtvfilterFilterProcessRender.jdField_b_of_type_Boolean) {
            break label1100;
          }
          if ((!this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewCameraFilterGLView$FaceDetectedCtrl.jdField_b_of_type_Boolean) && ((this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewCameraFilterGLView$FilterStatusRecord.jdField_a_of_type_Int == 0) || (this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewCameraFilterGLView$FilterStatusRecord.jdField_a_of_type_Int == 2)))
          {
            this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewCameraFilterGLView$CameraGlFilterListener.a(true, 0);
            this.jdField_f_of_type_Boolean = false;
            this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewCameraFilterGLView$FaceDetectedCtrl.jdField_b_of_type_Boolean = true;
            if (QLog.isColorLevel()) {
              QLog.d("PtvFilterUtils", 2, "GestureTest test call mFaceDetectedCtrl.mHaveNotifyDetectedFace 1 = true;");
            }
            this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewCameraFilterGLView$FaceDetectedCtrl.jdField_a_of_type_Int = 0;
            this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewCameraFilterGLView$FaceDetectedCtrl.jdField_c_of_type_Boolean = false;
            if (!this.jdField_a_of_type_ComTencentMobileqqShortvideoPtvfilterFilterProcessRender.jdField_f_of_type_Boolean)
            {
              this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewCameraFilterGLView$GestureDetectedCtrl.jdField_c_of_type_Boolean = false;
              this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewCameraFilterGLView$GestureDetectedCtrl.jdField_b_of_type_Boolean = false;
            }
          }
        }
        label477:
        if ((this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewCameraFilterGLView$GestureDetectedCtrl.jdField_a_of_type_Boolean) && (this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewCameraFilterGLView$CameraGlFilterListener != null) && (this.jdField_a_of_type_ComTencentMobileqqShortvideoPtvfilterFilterProcessRender.jdField_e_of_type_Boolean))
        {
          if (!this.jdField_a_of_type_ComTencentMobileqqShortvideoPtvfilterFilterProcessRender.jdField_f_of_type_Boolean) {
            break label1221;
          }
          if ((!this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewCameraFilterGLView$GestureDetectedCtrl.jdField_b_of_type_Boolean) && ((this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewCameraFilterGLView$FilterStatusRecord.jdField_a_of_type_Int == 1) || (this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewCameraFilterGLView$FilterStatusRecord.jdField_a_of_type_Int == 2)))
          {
            this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewCameraFilterGLView$CameraGlFilterListener.a(true, 1);
            this.jdField_f_of_type_Boolean = false;
            this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewCameraFilterGLView$FaceDetectedCtrl.jdField_b_of_type_Boolean = true;
            if (QLog.isColorLevel()) {
              QLog.d("PtvFilterUtils", 2, "GestureTest test call mFaceDetectedCtrl.mHaveNotifyDetectedFace2 = true;");
            }
            this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewCameraFilterGLView$FaceDetectedCtrl.jdField_a_of_type_Int = 0;
            this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewCameraFilterGLView$FaceDetectedCtrl.jdField_c_of_type_Boolean = false;
            this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewCameraFilterGLView$GestureDetectedCtrl.jdField_b_of_type_Boolean = true;
            this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewCameraFilterGLView$GestureDetectedCtrl.jdField_a_of_type_Int = 0;
            this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewCameraFilterGLView$GestureDetectedCtrl.jdField_c_of_type_Boolean = false;
          }
        }
        label625:
        if (this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewCameraFilterGLView$CameraGlFilterListener != null) {
          this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewCameraFilterGLView$CameraGlFilterListener.d(this.jdField_a_of_type_ComTencentMobileqqShortvideoPtvfilterFilterProcessRender.b());
        }
        long l2 = SystemClock.elapsedRealtime();
        if (!paramGL10.jdField_a_of_type_ComTencentMobileqqShortvideoUtilTextureDataPipe$FrameMetaData.jdField_a_of_type_Boolean) {
          break label1391;
        }
        localObject1 = (AVIOStruct)paramGL10.jdField_a_of_type_ComTencentMobileqqShortvideoUtilTextureDataPipe$FrameMetaData.jdField_a_of_type_JavaLangObject;
        ((AVIOStruct)localObject1).vFrameTime = l2;
        GLSurfaceUtil.a("handleMessage:requestRender  renderTime=" + l2);
        if (((AVIOStruct)localObject1).pFrameIndex == 0)
        {
          this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewCameraFilterGLView$SVRecordSessionParam.jdField_a_of_type_Boolean = true;
          this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewCameraFilterGLView$SVRecordSessionParam.jdField_a_of_type_Int = 0;
          if (this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewCameraFilterGLView$CameraGlFilterListener != null)
          {
            localObject2 = this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewCameraFilterGLView$SVRecordSessionParam;
            CameraFilterGLView.SVRecordSessionParam localSVRecordSessionParam = this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewCameraFilterGLView$SVRecordSessionParam;
            ((CameraFilterGLView.SVRecordSessionParam)localObject2).jdField_a_of_type_Int = CameraFilterGLView.SVRecordSessionParam.a(this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewCameraFilterGLView$CameraGlFilterListener.c());
          }
          this.jdField_a_of_type_ComTencentMobileqqShortvideoMediadeviceFilterPreviewContext.a();
        }
        ((AVIOStruct)localObject1).pFrameIndex = this.jdField_a_of_type_ComTencentMobileqqShortvideoMediadeviceFilterPreviewContext.a();
        if (this.jdField_c_of_type_Boolean) {
          break label1365;
        }
        l2 = PtvFilterUtils.a();
        if (!jdField_a_of_type_ComTencentMobileqqShortvideoUtilGlPostProcessThread.a()) {
          break label1290;
        }
        localObject2 = new GlPostProcessThread.FilterDrawFrameParam();
        ((GlPostProcessThread.FilterDrawFrameParam)localObject2).jdField_a_of_type_Int = this.jdField_c_of_type_Int;
        ((GlPostProcessThread.FilterDrawFrameParam)localObject2).jdField_b_of_type_Int = this.jdField_d_of_type_Int;
        ((GlPostProcessThread.FilterDrawFrameParam)localObject2).jdField_c_of_type_Int = m;
        ((GlPostProcessThread.FilterDrawFrameParam)localObject2).jdField_a_of_type_ComTencentMaxvideoCommonAVIOStruct = ((AVIOStruct)localObject1);
        ((GlPostProcessThread.FilterDrawFrameParam)localObject2).jdField_d_of_type_Int = this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewCameraFilterGLView$SVRecordSessionParam.jdField_a_of_type_Int;
        ((GlPostProcessThread.FilterDrawFrameParam)localObject2).jdField_a_of_type_ComTencentMobileqqShortvideoUtilSVFilterEncodeDoubleCache = this.jdField_a_of_type_ComTencentMobileqqShortvideoUtilSVFilterEncodeDoubleCache;
        ((GlPostProcessThread.FilterDrawFrameParam)localObject2).jdField_e_of_type_Int = 4;
        ((GlPostProcessThread.FilterDrawFrameParam)localObject2).jdField_a_of_type_Boolean = this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewCameraFilterGLView$SVRecordSessionParam.jdField_a_of_type_Boolean;
        ((GlPostProcessThread.FilterDrawFrameParam)localObject2).jdField_a_of_type_JavaUtilConcurrentAtomicAtomicReference = this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicReference;
        ((GlPostProcessThread.FilterDrawFrameParam)localObject2).jdField_a_of_type_ComTencentMobileqqShortvideoMediadeviceFilterPreviewContext = this.jdField_a_of_type_ComTencentMobileqqShortvideoMediadeviceFilterPreviewContext;
        localObject1 = Message.obtain();
        ((Message)localObject1).what = 57380;
        ((Message)localObject1).obj = localObject2;
        jdField_a_of_type_ComTencentMobileqqShortvideoUtilGlPostProcessThread.a((Message)localObject1);
        paramGL10.c();
        label938:
        l2 = (PtvFilterUtils.a() - l2) / 1000L;
        if (QLog.isColorLevel()) {
          QLog.d("PtvFilterUtils", 2, "PtvFilterUtils_onDrawFrame[recordToFile=" + l2 / 1000.0D + "ms]");
        }
        PtvFilterTimeStatistics.a(l2 + (0L + l1));
      }
      for (;;)
      {
        localObject1 = null;
        paramGL10 = (GL10)localObject1;
        if (jdField_a_of_type_ComTencentMobileqqShortvideoUtilOffScreenGLSurface != null)
        {
          paramGL10 = (GL10)localObject1;
          if (jdField_a_of_type_ComTencentMobileqqShortvideoUtilOffScreenGLSurface.a.a != null) {
            paramGL10 = jdField_a_of_type_ComTencentMobileqqShortvideoUtilOffScreenGLSurface.a.a.c();
          }
        }
        if (paramGL10 != null) {
          paramGL10.a();
        }
        return;
        bool1 = false;
        break;
        bool2 = false;
        break label153;
        label1064:
        m = this.jdField_a_of_type_ComTencentMobileqqShortvideoPtvfilterFilterProcessRender.a(this.jdField_a_of_type_Int, this.jdField_b_of_type_Int, paramGL10.jdField_a_of_type_Int, true, paramGL10.jdField_a_of_type_ComTencentMobileqqShortvideoUtilTextureDataPipe$FrameMetaData.jdField_b_of_type_Boolean, this.jdField_a_of_type_ComTencentMobileqqArFramePerformanceMonitor, true);
        break label241;
        label1100:
        localObject1 = this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewCameraFilterGLView$FaceDetectedCtrl;
        ((CameraFilterGLView.FaceDetectedCtrl)localObject1).jdField_a_of_type_Int += 1;
        if ((this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewCameraFilterGLView$FaceDetectedCtrl.jdField_c_of_type_Boolean) || (this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewCameraFilterGLView$FaceDetectedCtrl.jdField_a_of_type_Int < 4) || ((this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewCameraFilterGLView$FilterStatusRecord.jdField_a_of_type_Int != 0) && (this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewCameraFilterGLView$FilterStatusRecord.jdField_a_of_type_Int != 2)) || (this.jdField_a_of_type_ComTencentMobileqqShortvideoPtvfilterFilterProcessRender.jdField_f_of_type_Boolean)) {
          break label477;
        }
        this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewCameraFilterGLView$CameraGlFilterListener.a(false, 0);
        this.jdField_f_of_type_Boolean = true;
        this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewCameraFilterGLView$FaceDetectedCtrl.jdField_c_of_type_Boolean = true;
        this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewCameraFilterGLView$FaceDetectedCtrl.jdField_b_of_type_Boolean = false;
        this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewCameraFilterGLView$GestureDetectedCtrl.jdField_c_of_type_Boolean = false;
        this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewCameraFilterGLView$GestureDetectedCtrl.jdField_b_of_type_Boolean = false;
        break label477;
        label1221:
        if ((this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewCameraFilterGLView$GestureDetectedCtrl.jdField_c_of_type_Boolean) || ((this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewCameraFilterGLView$FilterStatusRecord.jdField_a_of_type_Int != 1) && (this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewCameraFilterGLView$FilterStatusRecord.jdField_a_of_type_Int != 2)) || (this.jdField_f_of_type_Boolean)) {
          break label625;
        }
        this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewCameraFilterGLView$CameraGlFilterListener.a(false, 1);
        this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewCameraFilterGLView$GestureDetectedCtrl.jdField_c_of_type_Boolean = true;
        this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewCameraFilterGLView$GestureDetectedCtrl.jdField_b_of_type_Boolean = false;
        break label625;
        localObject2 = a(m, (AVIOStruct)localObject1);
        paramGL10.c();
        if (localObject2 == null) {
          break label938;
        }
        if (this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewCameraFilterGLView$SVRecordSessionParam.jdField_a_of_type_Int == 180)
        {
          a((SVFilterEncodeDoubleCache.SharedMemoryCache)localObject2, 0, false, (AVIOStruct)localObject1, 0, this.jdField_a_of_type_ComTencentMobileqqShortvideoMediadeviceFilterPreviewContext);
          break label938;
        }
        a((SVFilterEncodeDoubleCache.SharedMemoryCache)localObject2, 180, true, (AVIOStruct)localObject1, this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewCameraFilterGLView$SVRecordSessionParam.jdField_a_of_type_Int, this.jdField_a_of_type_ComTencentMobileqqShortvideoMediadeviceFilterPreviewContext);
        break label938;
        label1365:
        paramGL10.c();
        RMVideoStateMgr.a().a(3553, m, null, null, SystemClock.elapsedRealtimeNanos(), this.jdField_a_of_type_ComTencentMobileqqShortvideoMediadeviceFilterPreviewContext);
        continue;
        label1391:
        if ((this.j) && (this.jdField_a_of_type_JavaLangString != null))
        {
          NewFlowCameraReporter.a("capture");
          a(m);
          NewFlowCameraReporter.a("frame captured;");
        }
        paramGL10.c();
      }
      GLES20.glClearColor(0.0F, 0.0F, 0.0F, 1.0F);
      GLES20.glClear(16384);
      GLES20.glFinish();
      return;
    }
  }
  
  public void onPause()
  {
    if (this.g)
    {
      super.onPause();
      this.g = false;
    }
    i();
    this.jdField_a_of_type_ComTencentMobileqqShortvideoPtvfilterFilterProcessRender.d();
  }
  
  public void onResume()
  {
    super.onResume();
    j();
    this.g = true;
    ShortVideoCaptureController.a(this);
  }
  
  public void onSurfaceChanged(GL10 paramGL10, int paramInt1, int paramInt2)
  {
    this.jdField_a_of_type_Int = paramInt1;
    this.jdField_b_of_type_Int = paramInt2;
    if (this.jdField_a_of_type_ComTencentMobileqqShortvideoPtvfilterFilterProcessRender != null) {
      this.jdField_a_of_type_ComTencentMobileqqShortvideoPtvfilterFilterProcessRender.c(this.jdField_c_of_type_Int, this.jdField_d_of_type_Int);
    }
    if ((!this.jdField_d_of_type_Boolean) && (this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewCameraFilterGLView$CameraGlFilterListener != null))
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewCameraFilterGLView$CameraGlFilterListener.K();
      this.jdField_d_of_type_Boolean = true;
    }
    if ((!this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewCameraFilterGLView$GLSurfaceEGLContextLifeCtl.jdField_a_of_type_Boolean) && (this.jdField_a_of_type_ComTencentMobileqqShortvideoPtvfilterFilterProcessRender != null))
    {
      b();
      this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewCameraFilterGLView$GLSurfaceEGLContextLifeCtl.jdField_a_of_type_Boolean = true;
    }
    this.jdField_a_of_type_ComTencentTtpicOpenapiFilterRenderBuffer = new RenderBuffer(this.jdField_c_of_type_Int, this.jdField_d_of_type_Int, 33984);
  }
  
  public void onSurfaceCreated(GL10 paramGL10, EGLConfig paramEGLConfig)
  {
    if (QLog.isColorLevel()) {
      QLog.d("face", 2, "onSurfaceCreated");
    }
    setSurfaceCreated();
    try
    {
      this.jdField_a_of_type_ComTencentTtpicOpenapiFilterTextureRender = new TextureRender();
      return;
    }
    catch (Exception paramGL10)
    {
      QLog.e("face", 2, paramGL10, new Object[0]);
    }
  }
  
  public void setEnableBeauty(boolean paramBoolean)
  {
    this.jdField_a_of_type_ComTencentMobileqqShortvideoPtvfilterFilterProcessRender.jdField_a_of_type_Boolean = paramBoolean;
  }
  
  public void setFilterListener(CameraFilterGLView.CameraGlFilterListener paramCameraGlFilterListener)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewCameraFilterGLView$CameraGlFilterListener = paramCameraGlFilterListener;
    if ((paramCameraGlFilterListener instanceof Handler.Callback)) {
      this.jdField_a_of_type_AndroidOsHandler = new Handler((Handler.Callback)this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewCameraFilterGLView$CameraGlFilterListener);
    }
  }
  
  public void setNeedWrite(boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("faceuu", 2, "setNeedWrite isRecord" + paramBoolean);
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewCameraFilterGLView$SVRecordSessionParam.jdField_a_of_type_Boolean = paramBoolean;
  }
  
  public void setPreviewSize(int paramInt1, int paramInt2, RMVideoClipSpec arg3)
  {
    this.jdField_c_of_type_Int = ???.jdField_c_of_type_Int;
    this.jdField_d_of_type_Int = ???.jdField_d_of_type_Int;
    if (QLog.isColorLevel()) {
      QLog.d("CameraFilterGLView", 2, "setPreviewSize preViewContext=" + this.jdField_a_of_type_ComTencentMobileqqShortvideoMediadevicePreviewContext + "  mMsghandler" + this.jdField_a_of_type_ComTencentMobileqqShortvideoMediadevicePreviewContext.mMsghandler);
    }
    Handler localHandler = a();
    Message localMessage = Message.obtain(localHandler);
    localMessage.what = -16716524;
    localMessage.arg1 = paramInt1;
    localMessage.arg2 = paramInt2;
    localMessage.obj = ???;
    if (localHandler != null) {
      localHandler.sendMessage(localMessage);
    }
    synchronized (this.jdField_a_of_type_JavaLangObject)
    {
      do
      {
        if (this.i) {
          super.queueEvent(new CameraFilterGLView.1(this));
        }
        this.h = true;
        return;
      } while (!QLog.isColorLevel());
      QLog.d("CameraFilterGLView", 2, "setPreviewSize mHandler is null=");
    }
  }
  
  @TargetApi(17)
  public void setSurfaceCreated()
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewCameraFilterGLView$GLSurfaceEGLContextLifeCtl.jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewCameraFilterGLView$GLSurfaceEGLContextLifeCtl.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.getAndSet(false);
    this.jdField_a_of_type_Boolean = true;
    this.jdField_c_of_type_Boolean = RMVideoStateMgr.a().b(5);
    this.jdField_a_of_type_ComTencentMobileqqShortvideoPtvfilterFilterProcessRender.c();
    this.jdField_a_of_type_ComTencentMobileqqShortvideoPtvfilterFilterProcessRender.b();
    this.jdField_a_of_type_ComTencentMobileqqShortvideoUtilSVFilterEncodeDoubleCache.b();
    this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewCameraFilterGLView$GLSurfaceEGLContextLifeCtl.jdField_a_of_type_Boolean = b();
    this.jdField_a_of_type_ComTencentMobileqqShortvideoPtvfilterFilterProcessRender.a().a(this.jdField_a_of_type_ComTencentMobileqqShortvideoUtilTextureDataPipe$OnFrameAvailableListener);
    this.jdField_a_of_type_ComTencentMobileqqShortvideoPtvfilterFilterProcessRender.g();
    synchronized (this.jdField_a_of_type_JavaLangObject)
    {
      if (this.h) {
        l();
      }
      this.i = true;
      return;
    }
  }
  
  public void setSurfaceDestroyed()
  {
    jdField_a_of_type_ComTencentMobileqqShortvideoUtilGlPostProcessThread.a.a(null, -1, -1);
    Message localMessage = Message.obtain();
    localMessage.what = 57381;
    jdField_a_of_type_ComTencentMobileqqShortvideoUtilGlPostProcessThread.a(localMessage);
    this.jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_ComTencentMobileqqShortvideoUtilSVFilterEncodeDoubleCache.d();
    e();
    i();
    this.jdField_b_of_type_Boolean = false;
    super.queueEvent(new CameraFilterGLView.5(this));
    PtvFilterUtils.a();
  }
  
  public void setVideoContext(PreviewContext paramPreviewContext)
  {
    this.jdField_a_of_type_ComTencentMobileqqShortvideoMediadevicePreviewContext = paramPreviewContext;
    if (this.jdField_a_of_type_ComTencentMobileqqShortvideoMediadevicePreviewContext != null) {
      this.jdField_a_of_type_ComTencentMobileqqShortvideoMediadevicePreviewContext.mPTVRealBeauty = true;
    }
    if (QLog.isColorLevel()) {
      QLog.d("CameraFilterGLView", 2, "setVideoContext preViewContext=" + this.jdField_a_of_type_ComTencentMobileqqShortvideoMediadevicePreviewContext);
    }
    j();
  }
  
  public void setVideoFilter(String paramString)
  {
    setVideoFilter(paramString, true, false);
  }
  
  public void setVideoFilter(String paramString1, int paramInt, String paramString2, String paramString3)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewCameraFilterGLView$FilterStatusRecord.jdField_a_of_type_Int == 0)
    {
      this.jdField_f_of_type_Boolean = false;
      this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewCameraFilterGLView$FaceDetectedCtrl.jdField_b_of_type_Boolean = false;
      this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewCameraFilterGLView$FaceDetectedCtrl.jdField_a_of_type_Int = 0;
      this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewCameraFilterGLView$FaceDetectedCtrl.jdField_c_of_type_Boolean = false;
      this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewCameraFilterGLView$GestureDetectedCtrl.jdField_b_of_type_Boolean = false;
      this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewCameraFilterGLView$GestureDetectedCtrl.jdField_c_of_type_Boolean = false;
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewCameraFilterGLView$FilterStatusRecord.c = paramString1;
    this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewCameraFilterGLView$FilterStatusRecord.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewCameraFilterGLView$FilterStatusRecord.jdField_a_of_type_JavaLangString = paramString2;
    this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewCameraFilterGLView$FilterStatusRecord.b = paramString3;
    GestureFilterManager.sGestureType = paramString2;
    GestureFilterManager.sGestureTips = paramString3;
    this.k = true;
    paramString2 = GestureUtil.a() + GestureFilterManager.sGestureType + ".png";
    if (QLog.isColorLevel()) {
      QLog.d("CameraFilterGLView", 2, "mCurrentCategory:=" + this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewCameraFilterGLView$FilterStatusRecord.jdField_a_of_type_Int + ",mCurrentgestureType:=" + this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewCameraFilterGLView$FilterStatusRecord.jdField_a_of_type_JavaLangString + ",mGestureWording=" + this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewCameraFilterGLView$FilterStatusRecord.b + ":path =" + paramString2 + ";frameTime is" + PtvTemplateManager.h);
    }
    setVideoFilter(paramString1, true, false);
    this.k = false;
  }
  
  public void setVideoFilter(String paramString, boolean paramBoolean1, boolean paramBoolean2)
  {
    if (((!this.k) || (paramString == null)) && ((paramString == null) || (!paramString.equalsIgnoreCase(this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewCameraFilterGLView$FilterStatusRecord.c))))
    {
      if (((this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewCameraFilterGLView$FilterStatusRecord.jdField_a_of_type_Int == 1) || (this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewCameraFilterGLView$FilterStatusRecord.jdField_a_of_type_Int == 2)) && (this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewCameraFilterGLView$CameraGlFilterListener != null))
      {
        this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewCameraFilterGLView$CameraGlFilterListener.a(true, 1);
        this.jdField_f_of_type_Boolean = false;
        this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewCameraFilterGLView$FaceDetectedCtrl.jdField_b_of_type_Boolean = false;
        this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewCameraFilterGLView$FaceDetectedCtrl.jdField_a_of_type_Int = 0;
        this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewCameraFilterGLView$FaceDetectedCtrl.jdField_c_of_type_Boolean = false;
        this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewCameraFilterGLView$GestureDetectedCtrl.jdField_b_of_type_Boolean = false;
        this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewCameraFilterGLView$GestureDetectedCtrl.jdField_c_of_type_Boolean = false;
      }
      this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewCameraFilterGLView$FilterStatusRecord.a();
      GestureFilterManager.sGestureType = "";
      GestureFilterManager.sGestureTips = "";
    }
  }
  
  public void surfaceDestroyed(SurfaceHolder paramSurfaceHolder)
  {
    if (QLog.isColorLevel()) {
      QLog.d("face", 2, "surfaceDestroyed");
    }
    setSurfaceDestroyed();
    PtvFilterTimeStatistics.b();
    super.surfaceDestroyed(paramSurfaceHolder);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.richmedia.view.CameraFilterGLView
 * JD-Core Version:    0.7.0.1
 */