package com.tencent.mobileqq.activity.richmedia.view;

import alps;
import alrr;
import alsj;
import alsl;
import alte;
import aluo;
import alup;
import aluq;
import alur;
import alus;
import alut;
import aluu;
import alvd;
import alvi;
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
import anvx;
import bdaf;
import bdbs;
import bdcg;
import bdcj;
import bdcs;
import bddo;
import bddp;
import bddq;
import bddr;
import bddy;
import bddz;
import bdeh;
import bdei;
import bden;
import bdeo;
import bdep;
import bdeq;
import bmwb;
import com.tencent.aekit.api.standard.filter.AESticker;
import com.tencent.av.opengl.GraphicRenderMgr;
import com.tencent.common.app.AppInterface;
import com.tencent.maxvideo.common.AVIOStruct;
import com.tencent.mobileqq.activity.richmedia.state.RMVideoStateMgr;
import com.tencent.mobileqq.ar.FramePerformanceMonitor;
import com.tencent.mobileqq.shortvideo.PtvTemplateManager;
import com.tencent.mobileqq.shortvideo.ShortVideoUtils;
import com.tencent.mobileqq.shortvideo.VideoEnvironment;
import com.tencent.mobileqq.shortvideo.hwcodec.SVHwEncoder;
import com.tencent.mobileqq.shortvideo.mediadevice.PreviewContext;
import com.tencent.mobileqq.shortvideo.ptvfilter.gesture.GestureFilterManager;
import com.tencent.mobileqq.shortvideo.ptvfilter.material.QQTemplateParser;
import com.tencent.mobileqq.shortvideo.util.PtvFilterUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.ttpic.openapi.PTFaceAttr.PTExpression;
import com.tencent.ttpic.openapi.cache.VideoMemoryManager;
import com.tencent.ttpic.openapi.filter.RenderBuffer;
import com.tencent.ttpic.openapi.filter.TextureRender;
import com.tencent.ttpic.openapi.model.VideoMaterial;
import com.tencent.ttpic.openapi.util.VideoMaterialUtil;
import com.tencent.ttpic.openapi.util.VideoMaterialUtil.SHADER_TYPE;
import com.tencent.ttpic.openapi.util.VideoPrefsUtil;
import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;

public class CameraFilterGLView
  extends GLSurfaceView
  implements alsl, GLSurfaceView.Renderer
{
  private static final bddp jdField_a_of_type_Bddp = new bddp();
  private static bddy jdField_a_of_type_Bddy;
  private int jdField_a_of_type_Int = 240;
  private alup jdField_a_of_type_Alup;
  private aluq jdField_a_of_type_Aluq = new aluq(null);
  private alur jdField_a_of_type_Alur = new alur(null);
  private alus jdField_a_of_type_Alus = new alus(this, null);
  private alut jdField_a_of_type_Alut = new alut(null);
  public aluu a;
  private Handler jdField_a_of_type_AndroidOsHandler;
  public bdbs a;
  public bdcg a;
  private bdeh jdField_a_of_type_Bdeh = new bdeh();
  private bdep jdField_a_of_type_Bdep = new aluo(this);
  public AppInterface a;
  public FramePerformanceMonitor a;
  private PreviewContext jdField_a_of_type_ComTencentMobileqqShortvideoMediadevicePreviewContext;
  private RenderBuffer jdField_a_of_type_ComTencentTtpicOpenapiFilterRenderBuffer;
  private TextureRender jdField_a_of_type_ComTencentTtpicOpenapiFilterTextureRender;
  private final Object jdField_a_of_type_JavaLangObject = new Object();
  private String jdField_a_of_type_JavaLangString;
  public AtomicReference<SVHwEncoder> a;
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
    bmwb.a();
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
    this.jdField_a_of_type_Bdcg = new bdcg();
    this.jdField_a_of_type_Aluu = new aluu();
    this.jdField_a_of_type_Bdbs = new bdbs();
    this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicReference = new AtomicReference(null);
    h();
  }
  
  private Handler a()
  {
    Handler localHandler1 = null;
    if (jdField_a_of_type_Bddy != null) {
      localHandler1 = jdField_a_of_type_Bddy.a();
    }
    Handler localHandler2 = localHandler1;
    if (localHandler1 == null) {
      localHandler2 = this.jdField_a_of_type_ComTencentMobileqqShortvideoMediadevicePreviewContext.mMsghandler;
    }
    return localHandler2;
  }
  
  private bdei a(int paramInt)
  {
    return a(paramInt, null);
  }
  
  private bdei a(int paramInt, AVIOStruct paramAVIOStruct)
  {
    bdei localbdei = this.jdField_a_of_type_Bdeh.a();
    if (localbdei == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("PtvFilterUtils", 2, "PtvFilterUtils_onDrawFrame[writeSharedMemtoFileDegree]memoryCache=null");
      }
      return null;
    }
    if (localbdei.a(this.jdField_c_of_type_Int, this.jdField_d_of_type_Int, 4))
    {
      PtvFilterUtils.a(paramInt, this.jdField_c_of_type_Int, this.jdField_d_of_type_Int, 4, localbdei.a, paramAVIOStruct);
      return localbdei;
    }
    localbdei.a();
    return null;
  }
  
  private String a(int paramInt)
  {
    if (paramInt == PTFaceAttr.PTExpression.MOUTH_OPEN.value) {
      return anvx.a(2131700812);
    }
    if (paramInt == PTFaceAttr.PTExpression.EYEBROWS_RAISE.value) {
      return anvx.a(2131700818);
    }
    if (paramInt == PTFaceAttr.PTExpression.BLINK.value) {
      return anvx.a(2131700817);
    }
    if (paramInt == PTFaceAttr.PTExpression.HEAD_SHAKE.value) {
      return anvx.a(2131700811);
    }
    if (paramInt == PTFaceAttr.PTExpression.KISS.value) {
      return anvx.a(2131700816);
    }
    if (paramInt == PTFaceAttr.PTExpression.HEAD_NOD.value) {
      return anvx.a(2131700814);
    }
    return null;
  }
  
  public static void a()
  {
    jdField_a_of_type_Bddy = null;
  }
  
  private void a(int paramInt)
  {
    this.j = false;
    this.jdField_a_of_type_ComTencentTtpicOpenapiFilterRenderBuffer.bind();
    this.jdField_a_of_type_ComTencentTtpicOpenapiFilterTextureRender.drawTexture(3553, paramInt, null, null);
    this.jdField_a_of_type_ComTencentTtpicOpenapiFilterRenderBuffer.unbind();
    bdei localbdei = a(this.jdField_a_of_type_ComTencentTtpicOpenapiFilterRenderBuffer.getTexId());
    if (localbdei != null)
    {
      alsj.a();
      this.jdField_a_of_type_Bdeh.a(new CameraFilterGLView.3(this, localbdei));
      return;
    }
    alsj.a(1);
    QLog.e("PtvFilterUtils", 2, "Capture picture failed, cacheSuccess == null.");
  }
  
  private void a(bdei parambdei, int paramInt1, boolean paramBoolean, AVIOStruct paramAVIOStruct, int paramInt2, bdbs parambdbs)
  {
    CameraFilterGLView.SharedMemWriteFile localSharedMemWriteFile = bddp.a(parambdei);
    localSharedMemWriteFile.jdField_a_of_type_Int = this.jdField_c_of_type_Int;
    localSharedMemWriteFile.jdField_b_of_type_Int = this.jdField_d_of_type_Int;
    localSharedMemWriteFile.jdField_c_of_type_Int = paramInt1;
    localSharedMemWriteFile.jdField_a_of_type_ComTencentMaxvideoCommonAVIOStruct = paramAVIOStruct;
    localSharedMemWriteFile.jdField_a_of_type_Bdei = parambdei;
    localSharedMemWriteFile.jdField_a_of_type_Boolean = paramBoolean;
    localSharedMemWriteFile.jdField_b_of_type_Boolean = this.jdField_a_of_type_Aluu.jdField_a_of_type_Boolean;
    localSharedMemWriteFile.jdField_a_of_type_Bdeh = this.jdField_a_of_type_Bdeh;
    localSharedMemWriteFile.jdField_a_of_type_Alup = this.jdField_a_of_type_Alup;
    localSharedMemWriteFile.jdField_d_of_type_Int = paramInt2;
    localSharedMemWriteFile.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicReference = this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicReference;
    localSharedMemWriteFile.jdField_a_of_type_Bdbs = parambdbs;
    this.jdField_a_of_type_Bdeh.a(localSharedMemWriteFile);
  }
  
  private void a(bden parambden)
  {
    parambden = (AVIOStruct)parambden.jdField_a_of_type_Bdeo.jdField_a_of_type_JavaLangObject;
    if (QLog.isColorLevel()) {
      QLog.d("PtvFilterUtils", 2, "PtvFilterUtils_onDrawFrame[printSourceDataTimeStamp=" + parambden.vFrameTime + "ms]");
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
    jdField_a_of_type_Bddy.a.a(EGL14.eglGetCurrentContext());
    jdField_a_of_type_Bddy.a.a = this.jdField_a_of_type_Bdcg.a();
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
    this.jdField_a_of_type_Alup = null;
    this.jdField_a_of_type_AndroidOsHandler = null;
    i();
    b();
    jdField_a_of_type_Bddp.a();
    alsj.a(this);
  }
  
  private void i()
  {
    this.jdField_e_of_type_Boolean = false;
    this.jdField_d_of_type_Boolean = false;
    this.jdField_a_of_type_Aluq.jdField_b_of_type_Boolean = false;
    this.jdField_a_of_type_Aluq.jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_Aluq.jdField_a_of_type_Int = 0;
    this.jdField_a_of_type_Aluq.jdField_c_of_type_Boolean = false;
    this.jdField_a_of_type_Bdcg.jdField_b_of_type_Boolean = false;
    this.jdField_a_of_type_Alut.jdField_b_of_type_Boolean = false;
    this.jdField_a_of_type_Alut.jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_Alut.jdField_a_of_type_Int = 0;
    this.jdField_a_of_type_Alut.jdField_c_of_type_Boolean = false;
    this.jdField_a_of_type_Bdcg.jdField_f_of_type_Boolean = false;
    this.jdField_a_of_type_Alur.a();
    GestureFilterManager.sGestureType = "";
    GestureFilterManager.sGestureTips = "";
  }
  
  private void j()
  {
    if (jdField_a_of_type_Bddy != null) {
      jdField_a_of_type_Bddy.a(this.jdField_a_of_type_ComTencentMobileqqShortvideoMediadevicePreviewContext);
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
    this.jdField_a_of_type_Bdcg.a(this.jdField_c_of_type_Int, this.jdField_d_of_type_Int);
    jdField_a_of_type_Bddp.a.a(EGL14.eglGetCurrentContext(), this.jdField_c_of_type_Int, this.jdField_d_of_type_Int);
    Message localMessage = Message.obtain();
    localMessage.what = 57379;
    jdField_a_of_type_Bddp.a(localMessage);
    k();
    this.jdField_a_of_type_Bdcg.b(this.jdField_c_of_type_Int, this.jdField_d_of_type_Int);
  }
  
  private void m()
  {
    if (this.jdField_a_of_type_Boolean) {
      this.jdField_b_of_type_Boolean = true;
    }
    this.jdField_a_of_type_Bdcg.e();
    super.requestRender();
  }
  
  private void n()
  {
    Handler localHandler = null;
    if (jdField_a_of_type_Bddy != null)
    {
      localHandler = jdField_a_of_type_Bddy.a();
      jdField_a_of_type_Bddy.a.a();
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
    if (jdField_a_of_type_Bddy != null) {
      jdField_a_of_type_Bddy.b();
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
    if ((!this.jdField_a_of_type_Alut.jdField_a_of_type_Boolean) || (this.jdField_a_of_type_Alur.jdField_a_of_type_Int == 0)) {
      return;
    }
    queueEvent(new CameraFilterGLView.4(this));
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_Bdeh.a();
  }
  
  public void b()
  {
    if (QLog.isColorLevel()) {
      QLog.d("PtvFilterUtils", 2, "createInputSurface inputSurface=" + jdField_a_of_type_Bddy + "  preViewContext=" + this.jdField_a_of_type_ComTencentMobileqqShortvideoMediadevicePreviewContext);
    }
    if (jdField_a_of_type_Bddy == null)
    {
      jdField_a_of_type_Bddy = new bddy();
      jdField_a_of_type_Bddy.a();
    }
  }
  
  public void c()
  {
    if ((jdField_a_of_type_Bddy != null) && (jdField_a_of_type_Bddy.a.a != null)) {
      jdField_a_of_type_Bddy.a.a.b();
    }
    if (jdField_a_of_type_Bddp != null) {
      jdField_a_of_type_Bddp.b();
    }
    if (this.jdField_a_of_type_Bdeh != null)
    {
      this.jdField_a_of_type_Bdeh.c();
      this.jdField_a_of_type_Bdeh.a();
    }
  }
  
  public void d()
  {
    if (this.jdField_a_of_type_Bdcg != null) {
      this.jdField_a_of_type_Bdcg.g = true;
    }
  }
  
  public void e()
  {
    if (QLog.isColorLevel()) {
      QLog.d("CameraFilterGLView", 2, "sendOffScreenGLSurfaceEGLFinish:mHasSendSurfaceFinishMsg=" + this.jdField_a_of_type_Alus.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean);
    }
    if (!this.jdField_a_of_type_Alus.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.getAndSet(true)) {
      n();
    }
    if (QLog.isColorLevel()) {
      QLog.d("CameraFilterGLView", 2, "sendOffScreenGLSurfaceEGLFinish:mHasSendSurfaceFinishMsg2=" + this.jdField_a_of_type_Alus.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean);
    }
  }
  
  public void f()
  {
    o();
  }
  
  public void g()
  {
    jdField_a_of_type_Bddp.c();
  }
  
  @TargetApi(17)
  public void onDrawFrame(GL10 paramGL10)
  {
    if (this.jdField_b_of_type_Boolean) {
      if (this.jdField_a_of_type_Bdcg != null) {
        if (jdField_a_of_type_Bddy.a.a == null) {
          break label1446;
        }
      }
    }
    label153:
    label1052:
    label1058:
    label1446:
    for (paramGL10 = jdField_a_of_type_Bddy.a.a.c();; paramGL10 = null)
    {
      if (paramGL10 != null) {
        paramGL10.f();
      }
      int m = 90;
      if (this.jdField_a_of_type_Alup != null) {
        m = this.jdField_a_of_type_Alup.c();
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
        localObject1 = bdcj.a();
        if ((this.jdField_a_of_type_Alur.jdField_a_of_type_Int != 0) && (this.jdField_a_of_type_Alur.jdField_a_of_type_Int != 2)) {
          break label1052;
        }
        bool1 = true;
        if ((this.jdField_a_of_type_Alur.jdField_a_of_type_Int != 1) && (this.jdField_a_of_type_Alur.jdField_a_of_type_Int != 2)) {
          break label1058;
        }
        bool2 = true;
        ((bdcj)localObject1).a(bool1, bool2);
        bdcj.a().a();
        if (this.jdField_a_of_type_ComTencentTtpicOpenapiFilterTextureRender == null) {
          break label1064;
        }
        m = this.jdField_a_of_type_Bdcg.a(this.jdField_a_of_type_Int, this.jdField_b_of_type_Int, paramGL10.jdField_a_of_type_Int, true, paramGL10.jdField_a_of_type_Bdeo.jdField_b_of_type_Boolean, this.jdField_a_of_type_ComTencentMobileqqArFramePerformanceMonitor, false);
        GLES20.glBindFramebuffer(36160, 0);
        GLES20.glViewport(0, 0, this.jdField_a_of_type_Int, this.jdField_b_of_type_Int);
        this.jdField_a_of_type_ComTencentTtpicOpenapiFilterTextureRender.drawTexture(3553, m, null, null);
        l1 = (PtvFilterUtils.a() - l1) / 1000L;
        bdcj.a().b();
        if (QLog.isColorLevel()) {
          QLog.d("PtvFilterUtils", 2, "PtvFilterUtils_onDrawFrame[showPreview=" + l1 / 1000.0D + "ms]");
        }
        if ((!this.jdField_e_of_type_Boolean) && (this.jdField_a_of_type_Alup != null))
        {
          this.jdField_a_of_type_Alup.L();
          this.jdField_e_of_type_Boolean = true;
        }
        if ((this.jdField_a_of_type_Aluq.jdField_a_of_type_Boolean) && (this.jdField_a_of_type_Alup != null) && (this.jdField_a_of_type_Bdcg.jdField_d_of_type_Boolean))
        {
          if (!this.jdField_a_of_type_Bdcg.jdField_b_of_type_Boolean) {
            break label1100;
          }
          if ((!this.jdField_a_of_type_Aluq.jdField_b_of_type_Boolean) && ((this.jdField_a_of_type_Alur.jdField_a_of_type_Int == 0) || (this.jdField_a_of_type_Alur.jdField_a_of_type_Int == 2)))
          {
            this.jdField_a_of_type_Alup.a(true, 0);
            this.jdField_f_of_type_Boolean = false;
            this.jdField_a_of_type_Aluq.jdField_b_of_type_Boolean = true;
            if (QLog.isColorLevel()) {
              QLog.d("PtvFilterUtils", 2, "GestureTest test call mFaceDetectedCtrl.mHaveNotifyDetectedFace 1 = true;");
            }
            this.jdField_a_of_type_Aluq.jdField_a_of_type_Int = 0;
            this.jdField_a_of_type_Aluq.jdField_c_of_type_Boolean = false;
            if (!this.jdField_a_of_type_Bdcg.jdField_f_of_type_Boolean)
            {
              this.jdField_a_of_type_Alut.jdField_c_of_type_Boolean = false;
              this.jdField_a_of_type_Alut.jdField_b_of_type_Boolean = false;
            }
          }
        }
        label477:
        if ((this.jdField_a_of_type_Alut.jdField_a_of_type_Boolean) && (this.jdField_a_of_type_Alup != null) && (this.jdField_a_of_type_Bdcg.jdField_e_of_type_Boolean))
        {
          if (!this.jdField_a_of_type_Bdcg.jdField_f_of_type_Boolean) {
            break label1221;
          }
          if ((!this.jdField_a_of_type_Alut.jdField_b_of_type_Boolean) && ((this.jdField_a_of_type_Alur.jdField_a_of_type_Int == 1) || (this.jdField_a_of_type_Alur.jdField_a_of_type_Int == 2)))
          {
            this.jdField_a_of_type_Alup.a(true, 1);
            this.jdField_f_of_type_Boolean = false;
            this.jdField_a_of_type_Aluq.jdField_b_of_type_Boolean = true;
            if (QLog.isColorLevel()) {
              QLog.d("PtvFilterUtils", 2, "GestureTest test call mFaceDetectedCtrl.mHaveNotifyDetectedFace2 = true;");
            }
            this.jdField_a_of_type_Aluq.jdField_a_of_type_Int = 0;
            this.jdField_a_of_type_Aluq.jdField_c_of_type_Boolean = false;
            this.jdField_a_of_type_Alut.jdField_b_of_type_Boolean = true;
            this.jdField_a_of_type_Alut.jdField_a_of_type_Int = 0;
            this.jdField_a_of_type_Alut.jdField_c_of_type_Boolean = false;
          }
        }
        label625:
        if (this.jdField_a_of_type_Alup != null) {
          this.jdField_a_of_type_Alup.d(this.jdField_a_of_type_Bdcg.b());
        }
        long l2 = SystemClock.elapsedRealtime();
        if (!paramGL10.jdField_a_of_type_Bdeo.jdField_a_of_type_Boolean) {
          break label1391;
        }
        localObject1 = (AVIOStruct)paramGL10.jdField_a_of_type_Bdeo.jdField_a_of_type_JavaLangObject;
        ((AVIOStruct)localObject1).vFrameTime = l2;
        alvd.a("handleMessage:requestRender  renderTime=" + l2);
        if (((AVIOStruct)localObject1).pFrameIndex == 0)
        {
          this.jdField_a_of_type_Aluu.jdField_a_of_type_Boolean = true;
          this.jdField_a_of_type_Aluu.jdField_a_of_type_Int = 0;
          if (this.jdField_a_of_type_Alup != null)
          {
            localObject2 = this.jdField_a_of_type_Aluu;
            aluu localaluu = this.jdField_a_of_type_Aluu;
            ((aluu)localObject2).jdField_a_of_type_Int = aluu.a(this.jdField_a_of_type_Alup.c());
          }
          this.jdField_a_of_type_Bdbs.a();
        }
        ((AVIOStruct)localObject1).pFrameIndex = this.jdField_a_of_type_Bdbs.a();
        if (this.jdField_c_of_type_Boolean) {
          break label1365;
        }
        l2 = PtvFilterUtils.a();
        if (!jdField_a_of_type_Bddp.a()) {
          break label1290;
        }
        localObject2 = new bddq();
        ((bddq)localObject2).jdField_a_of_type_Int = this.jdField_c_of_type_Int;
        ((bddq)localObject2).jdField_b_of_type_Int = this.jdField_d_of_type_Int;
        ((bddq)localObject2).jdField_c_of_type_Int = m;
        ((bddq)localObject2).jdField_a_of_type_ComTencentMaxvideoCommonAVIOStruct = ((AVIOStruct)localObject1);
        ((bddq)localObject2).jdField_d_of_type_Int = this.jdField_a_of_type_Aluu.jdField_a_of_type_Int;
        ((bddq)localObject2).jdField_a_of_type_Bdeh = this.jdField_a_of_type_Bdeh;
        ((bddq)localObject2).jdField_e_of_type_Int = 4;
        ((bddq)localObject2).jdField_a_of_type_Boolean = this.jdField_a_of_type_Aluu.jdField_a_of_type_Boolean;
        ((bddq)localObject2).jdField_a_of_type_JavaUtilConcurrentAtomicAtomicReference = this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicReference;
        ((bddq)localObject2).jdField_a_of_type_Bdbs = this.jdField_a_of_type_Bdbs;
        localObject1 = Message.obtain();
        ((Message)localObject1).what = 57380;
        ((Message)localObject1).obj = localObject2;
        jdField_a_of_type_Bddp.a((Message)localObject1);
        paramGL10.c();
        label938:
        l2 = (PtvFilterUtils.a() - l2) / 1000L;
        if (QLog.isColorLevel()) {
          QLog.d("PtvFilterUtils", 2, "PtvFilterUtils_onDrawFrame[recordToFile=" + l2 / 1000.0D + "ms]");
        }
        bdcs.c(l2 + (0L + l1));
      }
      for (;;)
      {
        localObject1 = null;
        paramGL10 = (GL10)localObject1;
        if (jdField_a_of_type_Bddy != null)
        {
          paramGL10 = (GL10)localObject1;
          if (jdField_a_of_type_Bddy.a.a != null) {
            paramGL10 = jdField_a_of_type_Bddy.a.a.c();
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
        m = this.jdField_a_of_type_Bdcg.a(this.jdField_a_of_type_Int, this.jdField_b_of_type_Int, paramGL10.jdField_a_of_type_Int, true, paramGL10.jdField_a_of_type_Bdeo.jdField_b_of_type_Boolean, this.jdField_a_of_type_ComTencentMobileqqArFramePerformanceMonitor, true);
        break label241;
        label1100:
        localObject1 = this.jdField_a_of_type_Aluq;
        ((aluq)localObject1).jdField_a_of_type_Int += 1;
        if ((this.jdField_a_of_type_Aluq.jdField_c_of_type_Boolean) || (this.jdField_a_of_type_Aluq.jdField_a_of_type_Int < 4) || ((this.jdField_a_of_type_Alur.jdField_a_of_type_Int != 0) && (this.jdField_a_of_type_Alur.jdField_a_of_type_Int != 2)) || (this.jdField_a_of_type_Bdcg.jdField_f_of_type_Boolean)) {
          break label477;
        }
        this.jdField_a_of_type_Alup.a(false, 0);
        this.jdField_f_of_type_Boolean = true;
        this.jdField_a_of_type_Aluq.jdField_c_of_type_Boolean = true;
        this.jdField_a_of_type_Aluq.jdField_b_of_type_Boolean = false;
        this.jdField_a_of_type_Alut.jdField_c_of_type_Boolean = false;
        this.jdField_a_of_type_Alut.jdField_b_of_type_Boolean = false;
        break label477;
        label1221:
        if ((this.jdField_a_of_type_Alut.jdField_c_of_type_Boolean) || ((this.jdField_a_of_type_Alur.jdField_a_of_type_Int != 1) && (this.jdField_a_of_type_Alur.jdField_a_of_type_Int != 2)) || (this.jdField_f_of_type_Boolean)) {
          break label625;
        }
        this.jdField_a_of_type_Alup.a(false, 1);
        this.jdField_a_of_type_Alut.jdField_c_of_type_Boolean = true;
        this.jdField_a_of_type_Alut.jdField_b_of_type_Boolean = false;
        break label625;
        localObject2 = a(m, (AVIOStruct)localObject1);
        paramGL10.c();
        if (localObject2 == null) {
          break label938;
        }
        if (this.jdField_a_of_type_Aluu.jdField_a_of_type_Int == 180)
        {
          a((bdei)localObject2, 0, false, (AVIOStruct)localObject1, 0, this.jdField_a_of_type_Bdbs);
          break label938;
        }
        a((bdei)localObject2, 180, true, (AVIOStruct)localObject1, this.jdField_a_of_type_Aluu.jdField_a_of_type_Int, this.jdField_a_of_type_Bdbs);
        break label938;
        label1365:
        paramGL10.c();
        RMVideoStateMgr.a().a(3553, m, null, null, SystemClock.elapsedRealtimeNanos(), this.jdField_a_of_type_Bdbs);
        continue;
        label1391:
        if ((this.j) && (this.jdField_a_of_type_JavaLangString != null))
        {
          alrr.a("capture");
          a(m);
          alrr.a("frame captured;");
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
    this.jdField_a_of_type_Bdcg.d();
  }
  
  public void onResume()
  {
    super.onResume();
    j();
    this.g = true;
    alsj.a(this);
  }
  
  public void onSurfaceChanged(GL10 paramGL10, int paramInt1, int paramInt2)
  {
    this.jdField_a_of_type_Int = paramInt1;
    this.jdField_b_of_type_Int = paramInt2;
    if (this.jdField_a_of_type_Bdcg != null) {
      this.jdField_a_of_type_Bdcg.c(this.jdField_c_of_type_Int, this.jdField_d_of_type_Int);
    }
    if ((!this.jdField_d_of_type_Boolean) && (this.jdField_a_of_type_Alup != null))
    {
      this.jdField_a_of_type_Alup.K();
      this.jdField_d_of_type_Boolean = true;
    }
    if ((!this.jdField_a_of_type_Alus.jdField_a_of_type_Boolean) && (this.jdField_a_of_type_Bdcg != null))
    {
      b();
      this.jdField_a_of_type_Alus.jdField_a_of_type_Boolean = true;
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
    this.jdField_a_of_type_Bdcg.jdField_a_of_type_Boolean = paramBoolean;
  }
  
  public void setFilterListener(alup paramalup)
  {
    this.jdField_a_of_type_Alup = paramalup;
    if ((paramalup instanceof Handler.Callback)) {
      this.jdField_a_of_type_AndroidOsHandler = new Handler((Handler.Callback)this.jdField_a_of_type_Alup);
    }
  }
  
  public void setNeedWrite(boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("faceuu", 2, "setNeedWrite isRecord" + paramBoolean);
    }
    this.jdField_a_of_type_Aluu.jdField_a_of_type_Boolean = paramBoolean;
  }
  
  public void setPreviewSize(int paramInt1, int paramInt2, alte arg3)
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
    this.jdField_a_of_type_Alus.jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_Alus.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.getAndSet(false);
    this.jdField_a_of_type_Boolean = true;
    this.jdField_c_of_type_Boolean = RMVideoStateMgr.a().b(5);
    this.jdField_a_of_type_Bdcg.c();
    this.jdField_a_of_type_Bdcg.b();
    this.jdField_a_of_type_Bdeh.b();
    this.jdField_a_of_type_Alus.jdField_a_of_type_Boolean = b();
    this.jdField_a_of_type_Bdcg.a().a(this.jdField_a_of_type_Bdep);
    this.jdField_a_of_type_Bdcg.g();
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
    jdField_a_of_type_Bddp.a.a(null, -1, -1);
    Message localMessage = Message.obtain();
    localMessage.what = 57381;
    jdField_a_of_type_Bddp.a(localMessage);
    this.jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_Bdeh.d();
    e();
    i();
    this.jdField_b_of_type_Boolean = false;
    super.queueEvent(new CameraFilterGLView.6(this));
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
    if (this.jdField_a_of_type_Alur.jdField_a_of_type_Int == 0)
    {
      this.jdField_f_of_type_Boolean = false;
      this.jdField_a_of_type_Aluq.jdField_b_of_type_Boolean = false;
      this.jdField_a_of_type_Aluq.jdField_a_of_type_Int = 0;
      this.jdField_a_of_type_Aluq.jdField_c_of_type_Boolean = false;
      this.jdField_a_of_type_Alut.jdField_b_of_type_Boolean = false;
      this.jdField_a_of_type_Alut.jdField_c_of_type_Boolean = false;
    }
    this.jdField_a_of_type_Alur.c = paramString1;
    this.jdField_a_of_type_Alur.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_Alur.jdField_a_of_type_JavaLangString = paramString2;
    this.jdField_a_of_type_Alur.b = paramString3;
    GestureFilterManager.sGestureType = paramString2;
    GestureFilterManager.sGestureTips = paramString3;
    this.k = true;
    paramString2 = bdaf.a() + GestureFilterManager.sGestureType + ".png";
    if (QLog.isColorLevel()) {
      QLog.d("CameraFilterGLView", 2, "mCurrentCategory:=" + this.jdField_a_of_type_Alur.jdField_a_of_type_Int + ",mCurrentgestureType:=" + this.jdField_a_of_type_Alur.jdField_a_of_type_JavaLangString + ",mGestureWording=" + this.jdField_a_of_type_Alur.b + ":path =" + paramString2 + ";frameTime is" + PtvTemplateManager.h);
    }
    setVideoFilter(paramString1, true, false);
    this.k = false;
  }
  
  public void setVideoFilter(String paramString, boolean paramBoolean1, boolean paramBoolean2)
  {
    if (((!this.k) || (paramString == null)) && ((paramString == null) || (!paramString.equalsIgnoreCase(this.jdField_a_of_type_Alur.c))))
    {
      if (((this.jdField_a_of_type_Alur.jdField_a_of_type_Int == 1) || (this.jdField_a_of_type_Alur.jdField_a_of_type_Int == 2)) && (this.jdField_a_of_type_Alup != null))
      {
        this.jdField_a_of_type_Alup.a(true, 1);
        this.jdField_f_of_type_Boolean = false;
        this.jdField_a_of_type_Aluq.jdField_b_of_type_Boolean = false;
        this.jdField_a_of_type_Aluq.jdField_a_of_type_Int = 0;
        this.jdField_a_of_type_Aluq.jdField_c_of_type_Boolean = false;
        this.jdField_a_of_type_Alut.jdField_b_of_type_Boolean = false;
        this.jdField_a_of_type_Alut.jdField_c_of_type_Boolean = false;
      }
      this.jdField_a_of_type_Alur.a();
      GestureFilterManager.sGestureType = "";
      GestureFilterManager.sGestureTips = "";
    }
    int m = PTFaceAttr.PTExpression.UNKNOW.value;
    long l = SystemClock.elapsedRealtime();
    bddo.a(1);
    Object localObject2 = new File(paramString, "paramsback" + ".json");
    boolean bool2 = ((File)localObject2).exists();
    boolean[] arrayOfBoolean = new boolean[1];
    Object localObject1;
    if ((paramString != null) && (!"".equals(paramString)))
    {
      VideoMemoryManager.getInstance().clear();
      if (QLog.isColorLevel())
      {
        localObject1 = new StringBuilder().append("parseVideoMaterial back? : ");
        if (alps.jdField_a_of_type_Int == 2)
        {
          paramBoolean2 = true;
          QLog.d("CameraFilterGLView", 2, paramBoolean2);
        }
      }
      else
      {
        if (alps.jdField_a_of_type_Int != 2) {
          break label406;
        }
        paramBoolean2 = true;
        label270:
        localObject1 = alvi.a(this.jdField_a_of_type_ComTencentCommonAppAppInterface).a(paramString, arrayOfBoolean, paramBoolean2);
        if ((localObject1 == null) || ("".equals(localObject1))) {
          break label411;
        }
        label302:
        if (this.jdField_a_of_type_Alur.jdField_a_of_type_Int != 0) {
          break label465;
        }
        localObject1 = QQTemplateParser.parseVideoMaterial(paramString, (String)localObject1);
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
          break label1163;
        }
        if (QLog.isColorLevel()) {
          QLog.d("CameraFilterGLView", 2, "parseVideoMaterial file : " + ((File)localObject2).getAbsolutePath());
        }
        if (!bool2) {
          break label1163;
        }
        localObject1 = "paramsback";
        break label302;
        label465:
        localObject2 = QQTemplateParser.parseVideoMaterial(paramString, (String)localObject1);
        ((VideoMaterial)localObject2).mHasGestureFilter = true;
        if (this.jdField_a_of_type_Alur.jdField_a_of_type_Int == 1) {
          ((VideoMaterial)localObject2).isNeedDecodeFaceFilter = false;
        }
        localObject1 = localObject2;
        if (QLog.isColorLevel())
        {
          QLog.d("CameraFilterGLView", 2, "gesture material parse here +");
          localObject1 = localObject2;
        }
      }
      label523:
      ((VideoMaterial)localObject1).setDataPath(paramString);
      if (((VideoMaterial)localObject1).getShaderType() == VideoMaterialUtil.SHADER_TYPE.SHADER_TYPE_2D_NON_FIT.value)
      {
        paramString = new ArrayList();
        localObject2 = ((VideoMaterial)localObject1).getItemList();
        List localList = ((VideoMaterial)localObject1).getNonFitItemList();
        if ((localObject2 != null) && (((List)localObject2).size() > 0)) {
          paramString.addAll((Collection)localObject2);
        }
        if ((localList != null) && (localList.size() > 0)) {
          paramString.addAll(localList);
        }
        localObject2 = new AESticker((VideoMaterial)localObject1, this.jdField_a_of_type_Bdcg.a());
        if (VideoMaterialUtil.isActionTriggerType(m)) {
          break label1153;
        }
        m = ((VideoMaterial)localObject1).getTriggerType();
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
      if ((this.jdField_a_of_type_Alup != null) && (paramString != null))
      {
        if (this.jdField_a_of_type_Alur.jdField_a_of_type_Int != 0) {
          break label912;
        }
        localObject2 = this.jdField_a_of_type_Alup;
        bool1 = paramString.mEnableFaceDetect;
        if (this.jdField_a_of_type_Bdcg != null) {
          break label896;
        }
        paramBoolean2 = false;
        label751:
        ((alup)localObject2).a(bool1, paramBoolean2, 0);
        if (this.jdField_a_of_type_Bdcg != null)
        {
          if (this.jdField_a_of_type_Bdcg.jdField_b_of_type_Boolean) {
            break label907;
          }
          paramBoolean2 = true;
          label781:
          this.jdField_f_of_type_Boolean = paramBoolean2;
        }
      }
      label786:
      int n = arrayOfBoolean[0];
      if ((this.jdField_a_of_type_Alur.jdField_a_of_type_Int == 1) || (this.jdField_a_of_type_Alur.jdField_a_of_type_Int == 2))
      {
        paramBoolean2 = true;
        label816:
        if ((this.jdField_a_of_type_Alur.jdField_a_of_type_Int != 0) && (this.jdField_a_of_type_Alur.jdField_a_of_type_Int != 2)) {
          break label1147;
        }
      }
      label896:
      label907:
      label912:
      label1088:
      label1137:
      label1147:
      for (boolean bool1 = true;; bool1 = false)
      {
        super.queueEvent(new CameraFilterGLView.5(this, (AESticker)localObject1, paramBoolean1, bool2, bool1, paramString, paramBoolean2, m, n));
        return;
        if (((VideoMaterial)localObject1).mHasGestureFilter)
        {
          VideoMemoryManager.getInstance().loadAllImages((VideoMaterial)localObject1);
          break;
        }
        VideoMemoryManager.getInstance().loadAllImages((VideoMaterial)localObject1);
        break;
        paramBoolean2 = this.jdField_a_of_type_Bdcg.jdField_b_of_type_Boolean;
        break label751;
        paramBoolean2 = false;
        break label781;
        if (this.jdField_a_of_type_Alur.jdField_a_of_type_Int == 1)
        {
          localObject2 = this.jdField_a_of_type_Alup;
          if (this.jdField_a_of_type_Bdcg == null) {}
          for (paramBoolean2 = false;; paramBoolean2 = this.jdField_a_of_type_Bdcg.jdField_f_of_type_Boolean)
          {
            ((alup)localObject2).a(true, paramBoolean2, 1);
            this.jdField_f_of_type_Boolean = false;
            break;
          }
        }
        if (this.jdField_a_of_type_Alur.jdField_a_of_type_Int != 2) {
          break label786;
        }
        if ((this.jdField_a_of_type_Bdcg != null) && (this.jdField_a_of_type_Bdcg.jdField_f_of_type_Boolean == true))
        {
          localObject2 = this.jdField_a_of_type_Alup;
          if (this.jdField_a_of_type_Bdcg == null) {}
          for (paramBoolean2 = false;; paramBoolean2 = this.jdField_a_of_type_Bdcg.jdField_f_of_type_Boolean)
          {
            ((alup)localObject2).a(true, paramBoolean2, 1);
            break;
          }
        }
        if ((this.jdField_a_of_type_Bdcg != null) && (this.jdField_a_of_type_Bdcg.jdField_b_of_type_Boolean))
        {
          this.jdField_a_of_type_Alup.a(true, false, 1);
          break label786;
        }
        localObject2 = this.jdField_a_of_type_Alup;
        bool1 = paramString.mEnableFaceDetect;
        if (this.jdField_a_of_type_Bdcg == null)
        {
          paramBoolean2 = false;
          ((alup)localObject2).a(bool1, paramBoolean2, 0);
          if (this.jdField_a_of_type_Bdcg == null) {
            break label786;
          }
          if (this.jdField_a_of_type_Bdcg.jdField_b_of_type_Boolean) {
            break label1137;
          }
        }
        for (paramBoolean2 = true;; paramBoolean2 = false)
        {
          this.jdField_f_of_type_Boolean = paramBoolean2;
          break;
          paramBoolean2 = this.jdField_a_of_type_Bdcg.jdField_b_of_type_Boolean;
          break label1088;
        }
        paramBoolean2 = false;
        break label816;
      }
      label1153:
      paramString = (String)localObject1;
      localObject1 = localObject2;
      continue;
      label1163:
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
    bdcs.b();
    super.surfaceDestroyed(paramSurfaceHolder);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.richmedia.view.CameraFilterGLView
 * JD-Core Version:    0.7.0.1
 */