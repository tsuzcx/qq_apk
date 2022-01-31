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
import com.tencent.mobileqq.activity.richmedia.FlowCameraConstant;
import com.tencent.mobileqq.activity.richmedia.NewFlowCameraReporter;
import com.tencent.mobileqq.activity.richmedia.ShortVideoCaptureController;
import com.tencent.mobileqq.activity.richmedia.ShortVideoCaptureController.CaptureTriggerObserver;
import com.tencent.mobileqq.activity.richmedia.state.RMVideoClipSpec;
import com.tencent.mobileqq.activity.richmedia.state.RMVideoStateMgr;
import com.tencent.mobileqq.ar.FramePerformanceMonitor;
import com.tencent.mobileqq.richmedia.mediacodec.renderer.RenderBuffer;
import com.tencent.mobileqq.richmedia.mediacodec.renderer.TextureRender;
import com.tencent.mobileqq.shortvideo.PtvTemplateManager;
import com.tencent.mobileqq.shortvideo.VideoEnvironment;
import com.tencent.mobileqq.shortvideo.gesture.GestureUtil;
import com.tencent.mobileqq.shortvideo.mediadevice.FilterPreviewContext;
import com.tencent.mobileqq.shortvideo.mediadevice.PreviewContext;
import com.tencent.mobileqq.shortvideo.ptvfilter.FilterProcessRender;
import com.tencent.mobileqq.shortvideo.ptvfilter.VideoFilterList;
import com.tencent.mobileqq.shortvideo.ptvfilter.gesture.GestureFilterManager;
import com.tencent.mobileqq.shortvideo.ptvfilter.gesture.GestureMonitorManager;
import com.tencent.mobileqq.shortvideo.ptvfilter.material.QQVideoMaterial;
import com.tencent.mobileqq.shortvideo.ptvfilter.material.TemplateParser;
import com.tencent.mobileqq.shortvideo.ptvfilter.test.PtvFilterTimeStatistics;
import com.tencent.mobileqq.shortvideo.ptvfilter.utils.VideoFilterUtil;
import com.tencent.mobileqq.shortvideo.util.FilterMemory;
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
import com.tencent.ttpic.VideoModule;
import com.tencent.ttpic.cache.ImageMemoryManager;
import com.tencent.ttpic.model.VideoMaterial;
import com.tencent.ttpic.util.VideoMaterialUtil;
import com.tencent.ttpic.util.VideoMaterialUtil.TRIGGER_TYPE;
import com.tencent.ttpic.util.VideoPrefsUtil;
import com.tencent.ttpic.util.youtu.VideoPreviewFaceOutlineDetector;
import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;
import ydj;
import ydk;
import ydl;
import ydo;
import ydp;
import ydq;
import ydr;
import yds;
import ydt;
import ydu;

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
  public CameraFilterGLView.SVRecordSessionParam a;
  public FramePerformanceMonitor a;
  private RenderBuffer jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecRendererRenderBuffer;
  private TextureRender jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecRendererTextureRender;
  public FilterPreviewContext a;
  private PreviewContext jdField_a_of_type_ComTencentMobileqqShortvideoMediadevicePreviewContext;
  public FilterProcessRender a;
  private SVFilterEncodeDoubleCache jdField_a_of_type_ComTencentMobileqqShortvideoUtilSVFilterEncodeDoubleCache = new SVFilterEncodeDoubleCache();
  private TextureDataPipe.OnFrameAvailableListener jdField_a_of_type_ComTencentMobileqqShortvideoUtilTextureDataPipe$OnFrameAvailableListener = new ydk(this);
  private final Object jdField_a_of_type_JavaLangObject = new Object();
  private String jdField_a_of_type_JavaLangString;
  public AtomicReference a;
  private ydr jdField_a_of_type_Ydr = new ydr(null);
  private yds jdField_a_of_type_Yds = new yds(null);
  private ydt jdField_a_of_type_Ydt = new ydt(this, null);
  private ydu jdField_a_of_type_Ydu = new ydu(null);
  private boolean jdField_a_of_type_Boolean;
  private int jdField_b_of_type_Int = 240;
  private boolean jdField_b_of_type_Boolean;
  private int jdField_c_of_type_Int;
  private boolean jdField_c_of_type_Boolean;
  private int jdField_d_of_type_Int;
  private boolean jdField_d_of_type_Boolean;
  private int jdField_e_of_type_Int = 90;
  private boolean jdField_e_of_type_Boolean;
  private int jdField_f_of_type_Int = 90;
  private boolean jdField_f_of_type_Boolean;
  private boolean g;
  private volatile boolean h;
  private volatile boolean i;
  private boolean j;
  private boolean k;
  
  static
  {
    VideoModule.init(VideoEnvironment.a());
    VideoPrefsUtil.init(VideoEnvironment.a());
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
  
  private String a(int paramInt)
  {
    if (paramInt == VideoMaterialUtil.TRIGGER_TYPE.MOUTH_OPEN.value) {
      return "张开你的嘴";
    }
    if (paramInt == VideoMaterialUtil.TRIGGER_TYPE.EYEBROWS_RAISE.value) {
      return "挑动你的眉毛";
    }
    if (paramInt == VideoMaterialUtil.TRIGGER_TYPE.BLINK.value) {
      return "眨眨你的眼睛";
    }
    if (paramInt == VideoMaterialUtil.TRIGGER_TYPE.HEAD_SHAKE.value) {
      return "摇一摇你的头";
    }
    if (paramInt == VideoMaterialUtil.TRIGGER_TYPE.KISS.value) {
      return "嘟起你的嘴";
    }
    if (paramInt == VideoMaterialUtil.TRIGGER_TYPE.HEAD_NOD.value) {
      return "点一点你的头";
    }
    return null;
  }
  
  public static void a()
  {
    jdField_a_of_type_ComTencentMobileqqShortvideoUtilOffScreenGLSurface = null;
  }
  
  private void a(int paramInt)
  {
    this.j = false;
    this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecRendererRenderBuffer.b();
    this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecRendererTextureRender.a(3553, paramInt, null, null);
    this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecRendererRenderBuffer.c();
    SVFilterEncodeDoubleCache.SharedMemoryCache localSharedMemoryCache = a(this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecRendererRenderBuffer.a());
    if (localSharedMemoryCache != null)
    {
      ShortVideoCaptureController.a();
      this.jdField_a_of_type_ComTencentMobileqqShortvideoUtilSVFilterEncodeDoubleCache.a(new ydl(this, localSharedMemoryCache));
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
  
  public static boolean a(int paramInt)
  {
    return paramInt == 180;
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
    this.jdField_a_of_type_Ydr.jdField_b_of_type_Boolean = false;
    this.jdField_a_of_type_Ydr.jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_Ydr.jdField_a_of_type_Int = 0;
    this.jdField_a_of_type_Ydr.jdField_c_of_type_Boolean = false;
    this.jdField_a_of_type_ComTencentMobileqqShortvideoPtvfilterFilterProcessRender.jdField_b_of_type_Boolean = false;
    this.jdField_a_of_type_Ydu.jdField_b_of_type_Boolean = false;
    this.jdField_a_of_type_Ydu.jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_Ydu.jdField_a_of_type_Int = 0;
    this.jdField_a_of_type_Ydu.jdField_c_of_type_Boolean = false;
    this.jdField_a_of_type_ComTencentMobileqqShortvideoPtvfilterFilterProcessRender.jdField_f_of_type_Boolean = false;
    this.jdField_a_of_type_Yds.a();
    GestureFilterManager.jdField_a_of_type_JavaLangString = "";
    GestureFilterManager.b = "";
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
    VideoMaterialUtil.SCALE_FACE_DETECT = (float)(i1 * 1.0D / this.jdField_c_of_type_Int);
    if (VideoMaterialUtil.SCALE_FACE_DETECT < 0.25D) {
      VideoMaterialUtil.SCALE_FACE_DETECT = 0.25D;
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
    if ((!this.jdField_a_of_type_Ydu.jdField_a_of_type_Boolean) || (this.jdField_a_of_type_Yds.jdField_a_of_type_Int == 0)) {
      return;
    }
    queueEvent(new ydo(this));
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
      QLog.d("CameraFilterGLView", 2, "sendOffScreenGLSurfaceEGLFinish:mHasSendSurfaceFinishMsg=" + this.jdField_a_of_type_Ydt.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean);
    }
    if (!this.jdField_a_of_type_Ydt.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.getAndSet(true)) {
      n();
    }
    if (QLog.isColorLevel()) {
      QLog.d("CameraFilterGLView", 2, "sendOffScreenGLSurfaceEGLFinish:mHasSendSurfaceFinishMsg2=" + this.jdField_a_of_type_Ydt.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean);
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
          break label1445;
        }
      }
    }
    label153:
    label1051:
    label1057:
    label1445:
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
        if ((this.jdField_a_of_type_Yds.jdField_a_of_type_Int != 0) && (this.jdField_a_of_type_Yds.jdField_a_of_type_Int != 2)) {
          break label1051;
        }
        bool1 = true;
        if ((this.jdField_a_of_type_Yds.jdField_a_of_type_Int != 1) && (this.jdField_a_of_type_Yds.jdField_a_of_type_Int != 2)) {
          break label1057;
        }
        bool2 = true;
        ((GestureMonitorManager)localObject1).a(bool1, bool2);
        GestureMonitorManager.a().a();
        if (this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecRendererTextureRender == null) {
          break label1063;
        }
        m = this.jdField_a_of_type_ComTencentMobileqqShortvideoPtvfilterFilterProcessRender.a(this.jdField_a_of_type_Int, this.jdField_b_of_type_Int, paramGL10.jdField_a_of_type_Int, true, paramGL10.jdField_a_of_type_ComTencentMobileqqShortvideoUtilTextureDataPipe$FrameMetaData.jdField_b_of_type_Boolean, this.jdField_a_of_type_ComTencentMobileqqArFramePerformanceMonitor, false);
        GLES20.glBindFramebuffer(36160, 0);
        GLES20.glViewport(0, 0, this.jdField_a_of_type_Int, this.jdField_b_of_type_Int);
        this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecRendererTextureRender.a(3553, m, null, null);
        l1 = (PtvFilterUtils.a() - l1) / 1000L;
        GestureMonitorManager.a().b();
        if (QLog.isColorLevel()) {
          QLog.d("PtvFilterUtils", 2, "PtvFilterUtils_onDrawFrame[showPreview=" + l1 / 1000.0D + "ms]");
        }
        if ((!this.jdField_e_of_type_Boolean) && (this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewCameraFilterGLView$CameraGlFilterListener != null))
        {
          this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewCameraFilterGLView$CameraGlFilterListener.O();
          this.jdField_e_of_type_Boolean = true;
        }
        if ((this.jdField_a_of_type_Ydr.jdField_a_of_type_Boolean) && (this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewCameraFilterGLView$CameraGlFilterListener != null) && (this.jdField_a_of_type_ComTencentMobileqqShortvideoPtvfilterFilterProcessRender.jdField_d_of_type_Boolean))
        {
          if (!this.jdField_a_of_type_ComTencentMobileqqShortvideoPtvfilterFilterProcessRender.jdField_b_of_type_Boolean) {
            break label1099;
          }
          if ((!this.jdField_a_of_type_Ydr.jdField_b_of_type_Boolean) && ((this.jdField_a_of_type_Yds.jdField_a_of_type_Int == 0) || (this.jdField_a_of_type_Yds.jdField_a_of_type_Int == 2)))
          {
            this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewCameraFilterGLView$CameraGlFilterListener.a(true, 0);
            this.jdField_f_of_type_Boolean = false;
            this.jdField_a_of_type_Ydr.jdField_b_of_type_Boolean = true;
            if (QLog.isColorLevel()) {
              QLog.d("PtvFilterUtils", 2, "GestureTest test call mFaceDetectedCtrl.mHaveNotifyDetectedFace 1 = true;");
            }
            this.jdField_a_of_type_Ydr.jdField_a_of_type_Int = 0;
            this.jdField_a_of_type_Ydr.jdField_c_of_type_Boolean = false;
            if (!this.jdField_a_of_type_ComTencentMobileqqShortvideoPtvfilterFilterProcessRender.jdField_f_of_type_Boolean)
            {
              this.jdField_a_of_type_Ydu.jdField_c_of_type_Boolean = false;
              this.jdField_a_of_type_Ydu.jdField_b_of_type_Boolean = false;
            }
          }
        }
        label477:
        if ((this.jdField_a_of_type_Ydu.jdField_a_of_type_Boolean) && (this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewCameraFilterGLView$CameraGlFilterListener != null) && (this.jdField_a_of_type_ComTencentMobileqqShortvideoPtvfilterFilterProcessRender.jdField_e_of_type_Boolean))
        {
          if (!this.jdField_a_of_type_ComTencentMobileqqShortvideoPtvfilterFilterProcessRender.jdField_f_of_type_Boolean) {
            break label1220;
          }
          if ((!this.jdField_a_of_type_Ydu.jdField_b_of_type_Boolean) && ((this.jdField_a_of_type_Yds.jdField_a_of_type_Int == 1) || (this.jdField_a_of_type_Yds.jdField_a_of_type_Int == 2)))
          {
            this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewCameraFilterGLView$CameraGlFilterListener.a(true, 1);
            this.jdField_f_of_type_Boolean = false;
            this.jdField_a_of_type_Ydr.jdField_b_of_type_Boolean = true;
            if (QLog.isColorLevel()) {
              QLog.d("PtvFilterUtils", 2, "GestureTest test call mFaceDetectedCtrl.mHaveNotifyDetectedFace2 = true;");
            }
            this.jdField_a_of_type_Ydr.jdField_a_of_type_Int = 0;
            this.jdField_a_of_type_Ydr.jdField_c_of_type_Boolean = false;
            this.jdField_a_of_type_Ydu.jdField_b_of_type_Boolean = true;
            this.jdField_a_of_type_Ydu.jdField_a_of_type_Int = 0;
            this.jdField_a_of_type_Ydu.jdField_c_of_type_Boolean = false;
          }
        }
        label625:
        if (this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewCameraFilterGLView$CameraGlFilterListener != null) {
          this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewCameraFilterGLView$CameraGlFilterListener.d(VideoPreviewFaceOutlineDetector.getInstance().getFaceCount());
        }
        long l2 = SystemClock.elapsedRealtime();
        if (!paramGL10.jdField_a_of_type_ComTencentMobileqqShortvideoUtilTextureDataPipe$FrameMetaData.jdField_a_of_type_Boolean) {
          break label1390;
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
          break label1364;
        }
        l2 = PtvFilterUtils.a();
        if (!jdField_a_of_type_ComTencentMobileqqShortvideoUtilGlPostProcessThread.a()) {
          break label1289;
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
        label937:
        l2 = (PtvFilterUtils.a() - l2) / 1000L;
        if (QLog.isColorLevel()) {
          QLog.d("PtvFilterUtils", 2, "PtvFilterUtils_onDrawFrame[recordToFile=" + l2 / 1000.0D + "ms]");
        }
        PtvFilterTimeStatistics.e(l2 + (0L + l1));
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
        label1063:
        m = this.jdField_a_of_type_ComTencentMobileqqShortvideoPtvfilterFilterProcessRender.a(this.jdField_a_of_type_Int, this.jdField_b_of_type_Int, paramGL10.jdField_a_of_type_Int, true, paramGL10.jdField_a_of_type_ComTencentMobileqqShortvideoUtilTextureDataPipe$FrameMetaData.jdField_b_of_type_Boolean, this.jdField_a_of_type_ComTencentMobileqqArFramePerformanceMonitor, true);
        break label241;
        label1099:
        localObject1 = this.jdField_a_of_type_Ydr;
        ((ydr)localObject1).jdField_a_of_type_Int += 1;
        if ((this.jdField_a_of_type_Ydr.jdField_c_of_type_Boolean) || (this.jdField_a_of_type_Ydr.jdField_a_of_type_Int < 4) || ((this.jdField_a_of_type_Yds.jdField_a_of_type_Int != 0) && (this.jdField_a_of_type_Yds.jdField_a_of_type_Int != 2)) || (this.jdField_a_of_type_ComTencentMobileqqShortvideoPtvfilterFilterProcessRender.jdField_f_of_type_Boolean)) {
          break label477;
        }
        this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewCameraFilterGLView$CameraGlFilterListener.a(false, 0);
        this.jdField_f_of_type_Boolean = true;
        this.jdField_a_of_type_Ydr.jdField_c_of_type_Boolean = true;
        this.jdField_a_of_type_Ydr.jdField_b_of_type_Boolean = false;
        this.jdField_a_of_type_Ydu.jdField_c_of_type_Boolean = false;
        this.jdField_a_of_type_Ydu.jdField_b_of_type_Boolean = false;
        break label477;
        label1220:
        if ((this.jdField_a_of_type_Ydu.jdField_c_of_type_Boolean) || ((this.jdField_a_of_type_Yds.jdField_a_of_type_Int != 1) && (this.jdField_a_of_type_Yds.jdField_a_of_type_Int != 2)) || (this.jdField_f_of_type_Boolean)) {
          break label625;
        }
        this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewCameraFilterGLView$CameraGlFilterListener.a(false, 1);
        this.jdField_a_of_type_Ydu.jdField_c_of_type_Boolean = true;
        this.jdField_a_of_type_Ydu.jdField_b_of_type_Boolean = false;
        break label625;
        localObject2 = a(m, (AVIOStruct)localObject1);
        paramGL10.c();
        if (localObject2 == null) {
          break label937;
        }
        if (this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewCameraFilterGLView$SVRecordSessionParam.jdField_a_of_type_Int == 180)
        {
          a((SVFilterEncodeDoubleCache.SharedMemoryCache)localObject2, 0, false, (AVIOStruct)localObject1, 0, this.jdField_a_of_type_ComTencentMobileqqShortvideoMediadeviceFilterPreviewContext);
          break label937;
        }
        a((SVFilterEncodeDoubleCache.SharedMemoryCache)localObject2, 180, true, (AVIOStruct)localObject1, this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewCameraFilterGLView$SVRecordSessionParam.jdField_a_of_type_Int, this.jdField_a_of_type_ComTencentMobileqqShortvideoMediadeviceFilterPreviewContext);
        break label937;
        label1364:
        paramGL10.c();
        RMVideoStateMgr.a().a(3553, m, null, null, SystemClock.elapsedRealtimeNanos(), this.jdField_a_of_type_ComTencentMobileqqShortvideoMediadeviceFilterPreviewContext);
        continue;
        label1390:
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
      this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewCameraFilterGLView$CameraGlFilterListener.N();
      this.jdField_d_of_type_Boolean = true;
    }
    if ((!this.jdField_a_of_type_Ydt.jdField_a_of_type_Boolean) && (this.jdField_a_of_type_ComTencentMobileqqShortvideoPtvfilterFilterProcessRender != null))
    {
      b();
      this.jdField_a_of_type_Ydt.jdField_a_of_type_Boolean = true;
    }
    this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecRendererRenderBuffer = new RenderBuffer(this.jdField_c_of_type_Int, this.jdField_d_of_type_Int, 33984);
  }
  
  public void onSurfaceCreated(GL10 paramGL10, EGLConfig paramEGLConfig)
  {
    if (QLog.isColorLevel()) {
      QLog.d("face", 2, "onSurfaceCreated");
    }
    setSurfaceCreated();
    try
    {
      this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecRendererTextureRender = new TextureRender();
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
          super.queueEvent(new ydj(this));
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
    this.jdField_a_of_type_Ydt.jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_Ydt.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.getAndSet(false);
    this.jdField_a_of_type_Boolean = true;
    this.jdField_c_of_type_Boolean = RMVideoStateMgr.a().b(5);
    this.jdField_a_of_type_ComTencentMobileqqShortvideoPtvfilterFilterProcessRender.c();
    this.jdField_a_of_type_ComTencentMobileqqShortvideoPtvfilterFilterProcessRender.b();
    this.jdField_a_of_type_ComTencentMobileqqShortvideoUtilSVFilterEncodeDoubleCache.b();
    this.jdField_a_of_type_Ydt.jdField_a_of_type_Boolean = b();
    this.jdField_a_of_type_ComTencentMobileqqShortvideoPtvfilterFilterProcessRender.a().a(this.jdField_a_of_type_ComTencentMobileqqShortvideoUtilTextureDataPipe$OnFrameAvailableListener);
    VideoModule.initExtensionValues();
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
    super.queueEvent(new ydq(this));
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
    if (this.jdField_a_of_type_Yds.jdField_a_of_type_Int == 0)
    {
      this.jdField_f_of_type_Boolean = false;
      this.jdField_a_of_type_Ydr.jdField_b_of_type_Boolean = false;
      this.jdField_a_of_type_Ydr.jdField_a_of_type_Int = 0;
      this.jdField_a_of_type_Ydr.jdField_c_of_type_Boolean = false;
      this.jdField_a_of_type_Ydu.jdField_b_of_type_Boolean = false;
      this.jdField_a_of_type_Ydu.jdField_c_of_type_Boolean = false;
    }
    this.jdField_a_of_type_Yds.c = paramString1;
    this.jdField_a_of_type_Yds.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_Yds.jdField_a_of_type_JavaLangString = paramString2;
    this.jdField_a_of_type_Yds.b = paramString3;
    GestureFilterManager.jdField_a_of_type_JavaLangString = paramString2;
    GestureFilterManager.b = paramString3;
    this.k = true;
    paramString2 = GestureUtil.a() + GestureFilterManager.jdField_a_of_type_JavaLangString + ".png";
    if (QLog.isColorLevel()) {
      QLog.d("CameraFilterGLView", 2, "mCurrentCategory:=" + this.jdField_a_of_type_Yds.jdField_a_of_type_Int + ",mCurrentgestureType:=" + this.jdField_a_of_type_Yds.jdField_a_of_type_JavaLangString + ",mGestureWording=" + this.jdField_a_of_type_Yds.b + ":path =" + paramString2 + ";frameTime is" + PtvTemplateManager.h);
    }
    setVideoFilter(paramString1, true, false);
    this.k = false;
  }
  
  public void setVideoFilter(String paramString, boolean paramBoolean1, boolean paramBoolean2)
  {
    if (((!this.k) || (paramString == null)) && ((paramString == null) || (!paramString.equalsIgnoreCase(this.jdField_a_of_type_Yds.c))))
    {
      if (((this.jdField_a_of_type_Yds.jdField_a_of_type_Int == 1) || (this.jdField_a_of_type_Yds.jdField_a_of_type_Int == 2)) && (this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewCameraFilterGLView$CameraGlFilterListener != null))
      {
        this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewCameraFilterGLView$CameraGlFilterListener.a(true, 1);
        this.jdField_f_of_type_Boolean = false;
        this.jdField_a_of_type_Ydr.jdField_b_of_type_Boolean = false;
        this.jdField_a_of_type_Ydr.jdField_a_of_type_Int = 0;
        this.jdField_a_of_type_Ydr.jdField_c_of_type_Boolean = false;
        this.jdField_a_of_type_Ydu.jdField_b_of_type_Boolean = false;
        this.jdField_a_of_type_Ydu.jdField_c_of_type_Boolean = false;
      }
      this.jdField_a_of_type_Yds.a();
      GestureFilterManager.jdField_a_of_type_JavaLangString = "";
      GestureFilterManager.b = "";
    }
    int m = VideoMaterialUtil.TRIGGER_TYPE.UNKNOW.value;
    long l = SystemClock.elapsedRealtime();
    FilterMemory.a(1);
    Object localObject2 = new File(paramString, "paramsback" + ".json");
    boolean bool2 = ((File)localObject2).exists();
    boolean[] arrayOfBoolean = new boolean[1];
    Object localObject1;
    if ((paramString != null) && (!"".equals(paramString)))
    {
      ImageMemoryManager.getInstance().clear();
      if (QLog.isColorLevel())
      {
        localObject1 = new StringBuilder().append("parseVideoMaterial back? : ");
        if (FlowCameraConstant.jdField_a_of_type_Int == 2)
        {
          paramBoolean2 = true;
          QLog.d("CameraFilterGLView", 2, paramBoolean2);
        }
      }
      else
      {
        if (FlowCameraConstant.jdField_a_of_type_Int != 2) {
          break label406;
        }
        paramBoolean2 = true;
        label270:
        localObject1 = LbsFilterStatusManager.a(this.jdField_a_of_type_ComTencentCommonAppAppInterface).a(paramString, arrayOfBoolean, paramBoolean2);
        if ((localObject1 == null) || ("".equals(localObject1))) {
          break label411;
        }
        label302:
        if (this.jdField_a_of_type_Yds.jdField_a_of_type_Int != 0) {
          break label465;
        }
        localObject1 = TemplateParser.a(paramString, (String)localObject1);
      }
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.d("CameraFilterGLView", 2, "current patternPath:" + paramString);
        }
        if ((localObject1 != null) && (paramString != null)) {
          break label523;
        }
        QLog.d("CameraFilterGLView", 2, "current tempMaterail = " + localObject1 + " patternPath=" + paramString);
        return;
        paramBoolean2 = false;
        break;
        label406:
        paramBoolean2 = false;
        break label270;
        label411:
        if (!paramBoolean2) {
          break label1158;
        }
        if (QLog.isColorLevel()) {
          QLog.d("CameraFilterGLView", 2, "parseVideoMaterial file : " + ((File)localObject2).getAbsolutePath());
        }
        if (!bool2) {
          break label1158;
        }
        localObject1 = "paramsback";
        break label302;
        label465:
        localObject2 = TemplateParser.a(paramString, (String)localObject1);
        ((QQVideoMaterial)localObject2).jdField_b_of_type_Boolean = true;
        if (this.jdField_a_of_type_Yds.jdField_a_of_type_Int == 1) {
          ((QQVideoMaterial)localObject2).jdField_a_of_type_Boolean = false;
        }
        localObject1 = localObject2;
        if (QLog.isColorLevel())
        {
          QLog.d("CameraFilterGLView", 2, "gesture material parse here +");
          localObject1 = localObject2;
        }
      }
      label523:
      ((QQVideoMaterial)localObject1).setDataPath(paramString);
      if (((QQVideoMaterial)localObject1).getShaderType() == 2000)
      {
        paramString = new ArrayList();
        localObject2 = ((QQVideoMaterial)localObject1).getItemList();
        List localList = ((QQVideoMaterial)localObject1).c();
        if ((localObject2 != null) && (((List)localObject2).size() > 0)) {
          paramString.addAll((Collection)localObject2);
        }
        if ((localList != null) && (localList.size() > 0)) {
          paramString.addAll(localList);
        }
        ImageMemoryManager.getInstance().loadAllItemsAppend((VideoMaterial)localObject1, paramString);
        localObject2 = VideoFilterUtil.a((QQVideoMaterial)localObject1);
        if (VideoMaterialUtil.isActionTriggerType(m)) {
          break label1148;
        }
        m = ((QQVideoMaterial)localObject1).getTriggerType();
        paramString = (String)localObject1;
        localObject1 = localObject2;
      }
    }
    for (;;)
    {
      l = (SystemClock.elapsedRealtime() - l) / 1000L;
      if (QLog.isColorLevel()) {
        QLog.d("PtvFilterUtils", 2, "PtvFilterUtils_onDrawFrame[setVideoFilter_parser=" + l / 1000.0D + "ms]");
      }
      if ((this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewCameraFilterGLView$CameraGlFilterListener != null) && (paramString != null))
      {
        if (this.jdField_a_of_type_Yds.jdField_a_of_type_Int != 0) {
          break label907;
        }
        localObject2 = this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewCameraFilterGLView$CameraGlFilterListener;
        bool1 = paramString.jdField_c_of_type_Boolean;
        if (this.jdField_a_of_type_ComTencentMobileqqShortvideoPtvfilterFilterProcessRender != null) {
          break label891;
        }
        paramBoolean2 = false;
        label746:
        ((CameraFilterGLView.CameraGlFilterListener)localObject2).a(bool1, paramBoolean2, 0);
        if (this.jdField_a_of_type_ComTencentMobileqqShortvideoPtvfilterFilterProcessRender != null)
        {
          if (this.jdField_a_of_type_ComTencentMobileqqShortvideoPtvfilterFilterProcessRender.jdField_b_of_type_Boolean) {
            break label902;
          }
          paramBoolean2 = true;
          label776:
          this.jdField_f_of_type_Boolean = paramBoolean2;
        }
      }
      label781:
      int n = arrayOfBoolean[0];
      if ((this.jdField_a_of_type_Yds.jdField_a_of_type_Int == 1) || (this.jdField_a_of_type_Yds.jdField_a_of_type_Int == 2))
      {
        paramBoolean2 = true;
        label811:
        if ((this.jdField_a_of_type_Yds.jdField_a_of_type_Int != 0) && (this.jdField_a_of_type_Yds.jdField_a_of_type_Int != 2)) {
          break label1142;
        }
      }
      label902:
      label907:
      label1083:
      label1132:
      label1142:
      for (boolean bool1 = true;; bool1 = false)
      {
        super.queueEvent(new ydp(this, (VideoFilterList)localObject1, paramBoolean1, bool2, bool1, paramString, paramBoolean2, m, n));
        return;
        if (((QQVideoMaterial)localObject1).jdField_b_of_type_Boolean)
        {
          ImageMemoryManager.getInstance().loadAllImages((VideoMaterial)localObject1);
          break;
        }
        ImageMemoryManager.getInstance().loadAllImages((VideoMaterial)localObject1);
        break;
        label891:
        paramBoolean2 = this.jdField_a_of_type_ComTencentMobileqqShortvideoPtvfilterFilterProcessRender.jdField_b_of_type_Boolean;
        break label746;
        paramBoolean2 = false;
        break label776;
        if (this.jdField_a_of_type_Yds.jdField_a_of_type_Int == 1)
        {
          localObject2 = this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewCameraFilterGLView$CameraGlFilterListener;
          if (this.jdField_a_of_type_ComTencentMobileqqShortvideoPtvfilterFilterProcessRender == null) {}
          for (paramBoolean2 = false;; paramBoolean2 = this.jdField_a_of_type_ComTencentMobileqqShortvideoPtvfilterFilterProcessRender.jdField_f_of_type_Boolean)
          {
            ((CameraFilterGLView.CameraGlFilterListener)localObject2).a(true, paramBoolean2, 1);
            this.jdField_f_of_type_Boolean = false;
            break;
          }
        }
        if (this.jdField_a_of_type_Yds.jdField_a_of_type_Int != 2) {
          break label781;
        }
        if ((this.jdField_a_of_type_ComTencentMobileqqShortvideoPtvfilterFilterProcessRender != null) && (this.jdField_a_of_type_ComTencentMobileqqShortvideoPtvfilterFilterProcessRender.jdField_f_of_type_Boolean == true))
        {
          localObject2 = this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewCameraFilterGLView$CameraGlFilterListener;
          if (this.jdField_a_of_type_ComTencentMobileqqShortvideoPtvfilterFilterProcessRender == null) {}
          for (paramBoolean2 = false;; paramBoolean2 = this.jdField_a_of_type_ComTencentMobileqqShortvideoPtvfilterFilterProcessRender.jdField_f_of_type_Boolean)
          {
            ((CameraFilterGLView.CameraGlFilterListener)localObject2).a(true, paramBoolean2, 1);
            break;
          }
        }
        if ((this.jdField_a_of_type_ComTencentMobileqqShortvideoPtvfilterFilterProcessRender != null) && (this.jdField_a_of_type_ComTencentMobileqqShortvideoPtvfilterFilterProcessRender.jdField_b_of_type_Boolean))
        {
          this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewCameraFilterGLView$CameraGlFilterListener.a(true, false, 1);
          break label781;
        }
        localObject2 = this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewCameraFilterGLView$CameraGlFilterListener;
        bool1 = paramString.jdField_c_of_type_Boolean;
        if (this.jdField_a_of_type_ComTencentMobileqqShortvideoPtvfilterFilterProcessRender == null)
        {
          paramBoolean2 = false;
          ((CameraFilterGLView.CameraGlFilterListener)localObject2).a(bool1, paramBoolean2, 0);
          if (this.jdField_a_of_type_ComTencentMobileqqShortvideoPtvfilterFilterProcessRender == null) {
            break label781;
          }
          if (this.jdField_a_of_type_ComTencentMobileqqShortvideoPtvfilterFilterProcessRender.jdField_b_of_type_Boolean) {
            break label1132;
          }
        }
        for (paramBoolean2 = true;; paramBoolean2 = false)
        {
          this.jdField_f_of_type_Boolean = paramBoolean2;
          break;
          paramBoolean2 = this.jdField_a_of_type_ComTencentMobileqqShortvideoPtvfilterFilterProcessRender.jdField_b_of_type_Boolean;
          break label1083;
        }
        paramBoolean2 = false;
        break label811;
      }
      label1148:
      paramString = (String)localObject1;
      localObject1 = localObject2;
      continue;
      label1158:
      localObject1 = "params";
      break;
      paramString = null;
      localObject1 = null;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.richmedia.view.CameraFilterGLView
 * JD-Core Version:    0.7.0.1
 */