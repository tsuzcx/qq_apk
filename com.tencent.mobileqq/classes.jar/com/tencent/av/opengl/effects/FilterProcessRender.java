package com.tencent.av.opengl.effects;

import android.annotation.TargetApi;
import android.content.Context;
import android.opengl.GLES20;
import android.text.TextUtils;
import com.tencent.aelight.camera.download.api.IAEKitForQQ;
import com.tencent.av.avatar.IAvatar2DAIDataListener;
import com.tencent.av.business.manager.avatar2d.Avatar2dItem;
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
import com.tencent.ttpic.openapi.model.VideoMaterial;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;

@TargetApi(17)
public class FilterProcessRender
{
  final String a;
  int b = 0;
  int c = 0;
  int d = -1;
  int e = -1;
  final FaceData f = new FaceData();
  protected boolean g = false;
  protected FilterProcessTest h = null;
  protected Context i;
  protected PerfRecorder j = null;
  protected GLTexture k = null;
  protected GLTexture l = null;
  protected FloatBuffer m = null;
  protected PreRender n = null;
  protected PostRender o = null;
  protected boolean p = false;
  private boolean q = false;
  private int r = 0;
  private AEFilterAVWrapper s = null;
  private final RenderInfoLog t = new RenderInfoLog();
  private BeautyConfig u = null;
  private ExtraRenderWrapper v = null;
  private boolean w = false;
  private IAvatar2DAIDataListener x = null;
  private String y = null;
  private String z = null;
  
  public FilterProcessRender(Context paramContext, BeautyConfig paramBeautyConfig)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("FilterProcessRender_");
    localStringBuilder.append(AudioHelper.c());
    this.a = localStringBuilder.toString();
    if (QLog.isColorLevel()) {
      this.j = new PerfRecorder(AEFilterSupport.a());
    }
    this.u = paramBeautyConfig;
    SvEffectSdkInitor.a();
    ((IAEKitForQQ)QRoute.api(IAEKitForQQ.class)).init();
    TipsInfo.a().b();
    this.d = -1;
    RenderUtil.a();
    this.i = paramContext;
    paramContext = CameraUtils.a(this.i).getSurfaceTextureForRender();
    if (paramContext != null) {
      this.n = new SurfacePreRender(paramContext);
    } else {
      this.n = new YUVPreRender();
    }
    this.o = new YuvPostRender(this.a);
    this.v = new ExtraRenderWrapper(this);
  }
  
  private void a(long paramLong, int paramInt1, int paramInt2)
  {
    if ((paramInt1 != 0) && (paramInt2 != 0))
    {
      if ((this.b == paramInt1) && (this.c == paramInt2)) {
        return;
      }
      if (QLog.isColorLevel())
      {
        localObject = this.a;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("innerUpdatePreviewSize, width[");
        localStringBuilder.append(this.b);
        localStringBuilder.append("->");
        localStringBuilder.append(paramInt1);
        localStringBuilder.append("], height[");
        localStringBuilder.append(this.c);
        localStringBuilder.append("->");
        localStringBuilder.append(paramInt2);
        localStringBuilder.append("], seq[");
        localStringBuilder.append(paramLong);
        localStringBuilder.append("]");
        QLog.w((String)localObject, 1, localStringBuilder.toString());
      }
      this.b = paramInt1;
      this.c = paramInt2;
      this.e = AVGLUtils.initFrameBuffer(paramInt1, paramInt2, this.d);
      Object localObject = this.n;
      if (localObject != null) {
        ((PreRender)localObject).a(paramInt1, paramInt2);
      }
      localObject = this.o;
      if (localObject != null) {
        ((PostRender)localObject).a(paramInt1, paramInt2);
      }
      d();
      SvEffectSdkInitor.a();
    }
  }
  
  private void a(Avatar2dItem paramAvatar2dItem)
  {
    if (paramAvatar2dItem != null)
    {
      this.w = true;
      return;
    }
    this.w = false;
  }
  
  private void a(CameraFrame paramCameraFrame)
  {
    Object localObject = this.l;
    if (localObject == null)
    {
      this.l = GLTexture.a(this.e, this.d);
    }
    else
    {
      ((GLTexture)localObject).a = this.e;
      ((GLTexture)localObject).b = this.d;
    }
    localObject = this.n;
    if ((localObject != null) && (!((PreRender)localObject).a(paramCameraFrame)))
    {
      this.n.c();
      this.n.b();
      this.n = null;
      if (QLog.isDevelopLevel()) {
        QLog.i("SurfaceTag", 4, "preRender, not match frame.");
      }
    }
    if (this.n == null)
    {
      if (paramCameraFrame.c())
      {
        this.n = new YUVPreRender();
        this.n.a();
        this.n.a(this.b, this.c);
      }
      else if (paramCameraFrame.n != null)
      {
        this.n = new SurfacePreRender(paramCameraFrame.n);
        this.n.a();
        this.n.a(this.b, this.c);
      }
      if (QLog.isDevelopLevel()) {
        QLog.i("SurfaceTag", 4, "preRender, new render for frame.");
      }
    }
    localObject = this.n;
    if ((localObject != null) && (((PreRender)localObject).a(paramCameraFrame)))
    {
      c();
      this.l = this.n.a(this, paramCameraFrame, this.k);
    }
  }
  
  private void a(CameraFrame paramCameraFrame, RenderParams paramRenderParams, boolean paramBoolean1, FramePerfData paramFramePerfData, boolean paramBoolean2)
  {
    c();
    if ((this.s != null) && ((paramBoolean2) || (paramRenderParams.a != null) || (paramRenderParams.c != null) || (paramRenderParams.b != null) || (paramBoolean1)))
    {
      Object localObject1 = this.j;
      if (localObject1 != null) {
        ((PerfRecorder)localObject1).a("drawFrameInGL");
      }
      int i1 = this.b;
      int i2 = this.c;
      localObject1 = this.v;
      boolean bool2 = true;
      boolean bool1;
      if (localObject1 != null)
      {
        ((ExtraRenderWrapper)localObject1).a(paramCameraFrame, paramRenderParams, this.k, i1, i2);
        localObject1 = this.f;
        if (this.v.a != 0) {
          bool1 = true;
        } else {
          bool1 = false;
        }
        ((FaceData)localObject1).k = bool1;
      }
      a(paramRenderParams.d);
      this.s.b(i1, i2);
      boolean bool3 = this.s.f();
      this.s.a(paramRenderParams.a);
      this.s.a(paramRenderParams.c, paramRenderParams.b);
      this.s.a(paramBoolean1);
      this.s.c(this.e, this.d);
      this.l = GLTexture.a(this.k.a, this.k.b);
      b(paramRenderParams.d);
      this.l.b = this.s.a(this.k.b, false, this.f, paramRenderParams.f);
      if (this.w)
      {
        Object localObject2 = this.s;
        String str = paramRenderParams.b.getId();
        if (paramRenderParams.d == null) {
          localObject1 = "";
        } else {
          localObject1 = paramRenderParams.d.d();
        }
        localObject1 = Avatar2DAIDataTransformer.a((AEFilterAVWrapper)localObject2, str, (String)localObject1);
        localObject2 = this.x;
        if ((localObject2 != null) && (localObject1.length > 0)) {
          ((IAvatar2DAIDataListener)localObject2).a((byte[])localObject1);
        }
      }
      boolean bool4 = this.s.f();
      if (this.s.c()) {
        a(128);
      }
      if (paramRenderParams.a != null) {
        a(16);
      }
      if ((paramRenderParams.c != null) || (paramRenderParams.b != null)) {
        a(32);
      }
      if (this.s.e()) {
        a(64);
      }
      if (paramBoolean2) {
        a(8);
      }
      localObject1 = this.j;
      if (localObject1 != null) {
        ((PerfRecorder)localObject1).b("drawFrameInGL");
      }
      if (paramFramePerfData != null)
      {
        if (paramRenderParams.a != null) {
          bool1 = true;
        } else {
          bool1 = false;
        }
        if (paramRenderParams.b == null) {
          bool2 = false;
        }
        paramFramePerfData.a(bool1, bool2, paramBoolean1, paramBoolean2);
      }
      a(2, this.k, this.l);
      paramFramePerfData = this.v;
      if (paramFramePerfData != null) {
        paramFramePerfData.a(this.l, bool3, bool4, this.b, this.c);
      }
    }
    paramFramePerfData = this.v;
    if (paramFramePerfData != null) {
      paramFramePerfData.b(paramCameraFrame, paramRenderParams);
    }
  }
  
  private void a(CameraFrame paramCameraFrame, RenderResult paramRenderResult, long paramLong)
  {
    PostRender localPostRender = this.o;
    if (localPostRender != null) {
      localPostRender.a(this, paramCameraFrame, this.l, this.f, paramRenderResult);
    }
    this.q = false;
    if (paramRenderResult.a == null) {
      paramRenderResult.a = paramCameraFrame;
    }
    long l1 = System.currentTimeMillis();
    paramRenderResult.a.l = ((int)(l1 - paramLong));
    paramRenderResult.a.m = this.r;
    paramRenderResult = this.j;
    if (paramRenderResult != null) {
      paramRenderResult.a(paramCameraFrame.j);
    }
    MemoryPerfStat.a().a(this.r);
  }
  
  private void a(RenderParams paramRenderParams, IEffectCtrl paramIEffectCtrl, boolean paramBoolean)
  {
    if ((paramBoolean) || (paramRenderParams.b != null))
    {
      paramRenderParams = this.j;
      if (paramRenderParams != null) {
        paramRenderParams.a("faceDetect");
      }
      paramRenderParams = this.s;
      if (paramRenderParams != null) {
        paramRenderParams.a(this.f);
      }
      paramRenderParams = this.j;
      if (paramRenderParams != null) {
        paramRenderParams.b("faceDetect");
      }
    }
  }
  
  private void b(Avatar2dItem paramAvatar2dItem)
  {
    String str2 = "";
    String str1;
    if (paramAvatar2dItem != null) {
      str1 = paramAvatar2dItem.c();
    } else {
      str1 = "";
    }
    if (paramAvatar2dItem != null) {
      str2 = paramAvatar2dItem.getId();
    }
    boolean bool1 = TextUtils.isEmpty(this.y);
    boolean bool2 = TextUtils.isEmpty(str1);
    int i1;
    if ((!TextUtils.isEmpty(this.z)) && (!TextUtils.isEmpty(str2)) && (!str2.equals(this.z))) {
      i1 = 1;
    } else {
      i1 = 0;
    }
    if (((bool1 ^ bool2)) || ((!bool2) && (!str1.equals(this.y))) || (i1 != 0)) {
      this.s.a(str1);
    }
    this.y = str1;
    this.z = str2;
  }
  
  private void b(CameraFrame paramCameraFrame, RenderResult paramRenderResult, long paramLong)
  {
    paramCameraFrame.b = this.c;
    paramCameraFrame.c = this.b;
    Object localObject = this.h;
    if (localObject != null)
    {
      ((FilterProcessTest)localObject).a(this, 5, paramCameraFrame, null);
      this.h.d();
    }
    this.q = false;
    paramCameraFrame.l = ((int)(System.currentTimeMillis() - paramLong));
    paramCameraFrame.m = this.r;
    localObject = this.n;
    if (localObject != null) {
      ((PreRender)localObject).b();
    }
    localObject = this.o;
    if (localObject != null) {
      ((PostRender)localObject).b();
    }
    localObject = this.j;
    if (localObject != null) {
      ((PerfRecorder)localObject).a(paramCameraFrame.j);
    }
    MemoryPerfStat.a().a(this.r);
    paramRenderResult.a(paramCameraFrame, null, null, null, (short)0, (short)0);
  }
  
  private void d()
  {
    if (this.m != null) {
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
    this.m = localByteBuffer.asFloatBuffer();
    this.m.put(arrayOfFloat);
    this.m.position(0);
  }
  
  void a()
  {
    AEFilterAVWrapper localAEFilterAVWrapper = this.s;
    if (localAEFilterAVWrapper != null) {
      localAEFilterAVWrapper.d();
    }
  }
  
  protected void a(int paramInt)
  {
    this.r = (paramInt | this.r);
  }
  
  public void a(int paramInt, GLTexture paramGLTexture1, GLTexture paramGLTexture2)
  {
    FilterProcessTest localFilterProcessTest = this.h;
    if ((localFilterProcessTest != null) && (localFilterProcessTest.a))
    {
      this.h.a(this, paramInt, null, paramGLTexture2);
      this.h.b(paramInt, paramGLTexture2.a, paramGLTexture2.b);
      if (QLog.isDevelopLevel()) {
        QLog.i(this.a, 4, String.format("%s, fbo[%s --> %s], textureid[%s --> %s]", new Object[] { FilterProcessTest.a(paramInt), Integer.valueOf(paramGLTexture1.a), Integer.valueOf(paramGLTexture2.a), Integer.valueOf(paramGLTexture1.b), Integer.valueOf(paramGLTexture2.b) }));
      }
    }
  }
  
  void a(long paramLong)
  {
    AEFilterAVWrapper localAEFilterAVWrapper = this.s;
    if (localAEFilterAVWrapper != null)
    {
      localAEFilterAVWrapper.a(paramLong);
      return;
    }
    TipsInfo.a().a(paramLong);
  }
  
  public void a(long paramLong, int paramInt)
  {
    if (AudioHelper.e())
    {
      localObject = this.a;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("initial, szie[");
      localStringBuilder.append(this.b);
      localStringBuilder.append(", ");
      localStringBuilder.append(this.c);
      localStringBuilder.append("], id[");
      localStringBuilder.append(this.d);
      localStringBuilder.append("], seq[");
      localStringBuilder.append(paramLong);
      localStringBuilder.append("]");
      QLog.w((String)localObject, 1, localStringBuilder.toString());
    }
    Object localObject = this.h;
    if (localObject != null) {
      ((FilterProcessTest)localObject).a();
    }
    this.g = true;
    this.q = false;
    if (this.d != -1) {
      return;
    }
    if ((EffectCtrlBase.c()) && (this.s == null))
    {
      this.s = new AEFilterAVWrapperImpl(paramInt);
      this.s.a(this.b, this.c);
    }
    localObject = new int[1];
    GLES20.glGenTextures(localObject.length, (int[])localObject, 0);
    this.d = localObject[0];
    localObject = this.n;
    if (localObject != null) {
      ((PreRender)localObject).a();
    }
    localObject = this.o;
    if (localObject != null) {
      ((PostRender)localObject).a();
    }
    this.r = 0;
    localObject = this.v;
    if (localObject != null) {
      ((ExtraRenderWrapper)localObject).a();
    }
  }
  
  public void a(IAvatar2DAIDataListener paramIAvatar2DAIDataListener)
  {
    this.x = paramIAvatar2DAIDataListener;
  }
  
  public void a(CameraFrame paramCameraFrame, RenderParams paramRenderParams, IEffectCtrl paramIEffectCtrl, RenderResult paramRenderResult)
  {
    Object localObject1 = this.h;
    if (localObject1 != null) {
      ((FilterProcessTest)localObject1).a();
    }
    localObject1 = this.j;
    if (localObject1 != null) {
      ((PerfRecorder)localObject1).b();
    }
    long l1 = System.currentTimeMillis();
    paramRenderResult.a = paramCameraFrame;
    a(0L, paramCameraFrame.c, paramCameraFrame.b);
    int i1 = paramCameraFrame.b;
    int i2 = paramCameraFrame.c;
    int i3 = RenderUtil.a(paramCameraFrame.g);
    boolean bool2 = paramRenderParams.e;
    Object localObject2;
    if (this.p != bool2)
    {
      if (QLog.isDevelopLevel())
      {
        localObject1 = this.a;
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("render, needFaceData[");
        ((StringBuilder)localObject2).append(bool2);
        ((StringBuilder)localObject2).append("]");
        QLog.i((String)localObject1, 4, ((StringBuilder)localObject2).toString());
      }
      this.p = bool2;
    }
    int i4 = this.u.b("BEAUTY_SKIN");
    this.t.a(this.a, paramCameraFrame.j, i1, i2, paramCameraFrame.e, paramRenderParams.e, paramRenderParams.a, paramRenderParams.b, paramRenderParams.c, paramCameraFrame, i4);
    if ((this.b != 0) && (this.c != 0) && (!paramCameraFrame.a()) && (this.e != -1))
    {
      if (!this.g) {
        return;
      }
      this.q = true;
      localObject2 = paramCameraFrame.k;
      if (localObject2 != null) {
        ((FramePerfData)localObject2).a(i3);
      }
      this.f.a(i1, i2);
      if (paramCameraFrame.c())
      {
        localObject1 = this.h;
        if (localObject1 != null)
        {
          ((FilterProcessTest)localObject1).c();
          this.h.a(this, 0, paramCameraFrame, null);
        }
      }
      localObject1 = this.s;
      boolean bool1;
      if (localObject1 != null) {
        bool1 = ((AEFilterAVWrapper)localObject1).a(this.u);
      } else {
        bool1 = false;
      }
      localObject1 = paramRenderParams;
      if ((((RenderParams)localObject1).a == null) && (((RenderParams)localObject1).b == null)) {
        i1 = 0;
      } else {
        i1 = 1;
      }
      if ((i1 == 0) && (!bool2) && (!bool1)) {
        i1 = 0;
      } else {
        i1 = 1;
      }
      if ((((RenderParams)localObject1).g) && (i1 != 0))
      {
        PerfReporter.a("prerender_time", 0);
        a(paramCameraFrame);
        PerfReporter.a("prerender_time", 1);
        PerfReporter.a("aefilter_time", 0);
        a(paramCameraFrame, paramRenderParams, bool2, (FramePerfData)localObject2, bool1);
        PerfReporter.a("aefilter_time", 1);
        a((RenderParams)localObject1, paramIEffectCtrl, bool2);
        PerfReporter.a("postrender_time", 0);
        a(paramCameraFrame, paramRenderResult, l1);
        PerfReporter.a("postrender_time", 1);
        return;
      }
      if (paramCameraFrame.c())
      {
        b(paramCameraFrame, paramRenderResult, l1);
        return;
      }
      PerfReporter.a("prerender_time", 0);
      a(paramCameraFrame);
      PerfReporter.a("prerender_time", 1);
      PerfReporter.a("postrender_time", 0);
      a(paramCameraFrame, paramRenderResult, l1);
      PerfReporter.a("postrender_time", 1);
    }
  }
  
  void b()
  {
    long l1 = AudioHelper.c();
    Object localObject = this.a;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("uninit, mIsInited[");
    localStringBuilder.append(this.g);
    localStringBuilder.append("], mIsRendering[");
    localStringBuilder.append(this.q);
    localStringBuilder.append("], seq[");
    localStringBuilder.append(l1);
    localStringBuilder.append("]");
    QLog.w((String)localObject, 1, localStringBuilder.toString());
    if (!this.g) {
      return;
    }
    this.g = false;
    localObject = this.h;
    if (localObject != null) {
      ((FilterProcessTest)localObject).b();
    }
    localObject = this.o;
    if (localObject != null) {
      ((PostRender)localObject).b();
    }
    localObject = this.n;
    if (localObject != null) {
      ((PreRender)localObject).b();
    }
    a(l1);
    localObject = this.s;
    if (localObject != null) {
      ((AEFilterAVWrapper)localObject).a();
    }
    localObject = this.j;
    if (localObject != null) {
      ((PerfRecorder)localObject).a();
    }
    TipsInfo.a().b();
  }
  
  public void b(long paramLong)
  {
    Object localObject = this.a;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("clear, seq[");
    localStringBuilder.append(paramLong);
    localStringBuilder.append("]");
    QLog.w((String)localObject, 1, localStringBuilder.toString());
    localObject = this.n;
    if (localObject != null)
    {
      ((PreRender)localObject).b();
      this.n.c();
    }
    int i1 = this.e;
    if (i1 != -1)
    {
      GLES20.glDeleteFramebuffers(1, new int[] { i1 }, 0);
      this.e = -1;
    }
    i1 = this.d;
    if (i1 != -1)
    {
      localObject = new int[1];
      localObject[0] = i1;
      GLES20.glDeleteTextures(localObject.length, (int[])localObject, 0);
      this.d = -1;
    }
    localObject = this.o;
    if (localObject != null) {
      ((PostRender)localObject).c();
    }
    localObject = this.s;
    if (localObject != null)
    {
      ((AEFilterAVWrapper)localObject).b();
      this.s = null;
    }
    localObject = this.v;
    if (localObject != null) {
      ((ExtraRenderWrapper)localObject).b();
    }
    TipsInfo.a().a(paramLong);
  }
  
  protected void c()
  {
    GLTexture localGLTexture = this.k;
    if ((localGLTexture != this.l) && (localGLTexture != null))
    {
      localGLTexture.a();
      this.k = null;
    }
    this.k = this.l;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.opengl.effects.FilterProcessRender
 * JD-Core Version:    0.7.0.1
 */