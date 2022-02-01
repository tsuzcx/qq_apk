package com.tencent.aelight.camera.aioeditor.richmedia.mediacodec.widget;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.SurfaceTexture;
import android.graphics.SurfaceTexture.OnFrameAvailableListener;
import android.opengl.GLSurfaceView;
import android.opengl.GLSurfaceView.EGLContextFactory;
import android.opengl.GLSurfaceView.Renderer;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.SurfaceHolder;
import com.tencent.aelight.camera.aioeditor.richmedia.mediacodec.AudioDecoder;
import com.tencent.biz.qqstory.support.report.StoryReportor;
import com.tencent.biz.qqstory.utils.VideoUtils;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.editor.composite.VideoCompositeHelper;
import com.tencent.mobileqq.filter.FilterFactory;
import com.tencent.mobileqq.monitor.CaptureFreqMonitor;
import com.tencent.mobileqq.monitor.CaptureFreqMonitorItem;
import com.tencent.mobileqq.richmedia.mediacodec.utils.GlUtil;
import com.tencent.mobileqq.richmedia.mediacodec.utils.ShortVideoExceptionReporter;
import com.tencent.mobileqq.richmedia.mediacodec.videodecoder.DecodeConfig;
import com.tencent.mobileqq.richmedia.mediacodec.videodecoder.HWDecodeListener;
import com.tencent.mobileqq.richmedia.mediacodec.videodecoder.HWVideoDecoder;
import com.tencent.mobileqq.shortvideo.util.AudioEncoder;
import com.tencent.mobileqq.shortvideo.util.MediaMetadataUtils;
import com.tencent.mobileqq.shortvideo.util.MediaMetadataUtils.MetaData;
import com.tencent.mobileqq.videocodec.audio.AudioDecodeConfig;
import com.tencent.qphone.base.util.QLog;
import com.tencent.ttpic.openapi.filter.GPUBaseFilter;
import com.tencent.ttpic.openapi.filter.GPUOESBaseFilter;
import java.lang.ref.WeakReference;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;

@TargetApi(11)
public class HWVideoPlayView
  extends GLSurfaceView
  implements SurfaceTexture.OnFrameAvailableListener, GLSurfaceView.Renderer, HWDecodeListener
{
  private boolean A = false;
  private boolean B = false;
  private long C = 0L;
  private GLSurfaceView.EGLContextFactory D = new HWVideoPlayView.1(this);
  protected HWVideoDecoder a = null;
  protected SurfaceTexture b;
  protected int c;
  protected int d;
  public int e;
  public int f;
  protected boolean g = false;
  public int h;
  public int i;
  protected int j;
  protected AudioDecoder k;
  protected final AudioDecodeConfig l;
  public long m = 0L;
  public boolean n = false;
  protected int o = 0;
  protected long p = 0L;
  protected boolean q = false;
  public int r = 0;
  public long s = 0L;
  public int t = 0;
  private WeakReference<HWVideoPlayView.HWVideoPlayViewListener> u;
  private int v;
  private final DecodeConfig w = new DecodeConfig();
  private HWDecodeListener x;
  private GPUOESBaseFilter y;
  private boolean z = false;
  
  public HWVideoPlayView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public HWVideoPlayView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    setEGLContextFactory(this.D);
    setEGLContextClientVersion(2);
    this.a = new HWVideoDecoder();
    this.k = new AudioDecoder();
    this.l = new AudioDecodeConfig();
    setRenderer(this);
    setRenderMode(0);
  }
  
  public int a(int paramInt)
  {
    this.j = paramInt;
    return this.j;
  }
  
  public int a(LocalMediaInfo paramLocalMediaInfo)
  {
    if (VideoUtils.a(paramLocalMediaInfo)) {
      this.j = (paramLocalMediaInfo.rotation + 90);
    } else {
      this.j = paramLocalMediaInfo.rotation;
    }
    if (QLog.isColorLevel())
    {
      paramLocalMediaInfo = new StringBuilder();
      paramLocalMediaInfo.append("adjustRotation: mVideoRotation=");
      paramLocalMediaInfo.append(this.j);
      QLog.d("HWVideoPlayView", 2, paramLocalMediaInfo.toString());
    }
    return this.j;
  }
  
  protected void a()
  {
    Object localObject = this.b;
    if (localObject != null)
    {
      ((SurfaceTexture)localObject).release();
      this.b = null;
    }
    this.z = true;
    c();
    localObject = this.u;
    if (localObject != null)
    {
      localObject = (HWVideoPlayView.HWVideoPlayViewListener)((WeakReference)localObject).get();
      if (localObject != null) {
        ((HWVideoPlayView.HWVideoPlayViewListener)localObject).d();
      }
    }
  }
  
  protected void a(float[] paramArrayOfFloat1, float[] paramArrayOfFloat2)
  {
    this.y.drawTexture(this.v, paramArrayOfFloat1, paramArrayOfFloat2);
  }
  
  public void b()
  {
    if (!TextUtils.isEmpty(this.w.inputFilePath))
    {
      this.a.stopDecode();
      this.o = 1;
      if (QLog.isColorLevel()) {
        QLog.d("HWVideoPlayView", 2, new Object[] { "startPlay, mCurrentStat:", Integer.valueOf(this.o) });
      }
      this.a.startDecode(this.w, this.v, this, this);
      if (!TextUtils.isEmpty(this.l.a)) {
        this.k.a(this.l);
      }
      return;
    }
    throw new RuntimeException("startPlay failed. videoFilePath is empty.");
  }
  
  public void c()
  {
    this.a.pauseDecode();
    this.k.c();
    this.a.stopDecode();
    this.k.b();
    if ((this.B) && (this.C > 0L))
    {
      this.s = (System.currentTimeMillis() - this.C);
      this.t = (this.r - 15);
      this.C = 0L;
    }
  }
  
  public void d()
  {
    this.a.pauseDecode();
    this.k.c();
    this.o = 4;
    if (QLog.isColorLevel()) {
      QLog.d("HWVideoPlayView", 2, new Object[] { "pausePlay, mCurrentStat:", Integer.valueOf(this.o) });
    }
    if (this.C != 0L)
    {
      this.s += System.currentTimeMillis() - this.C;
      this.t = (this.r - 15);
      this.C = 0L;
    }
  }
  
  public void e()
  {
    this.a.resumeDecode();
    this.k.d();
    this.o = 3;
    if (QLog.isColorLevel()) {
      QLog.d("HWVideoPlayView", 2, new Object[] { "resumePlay, mCurrentStat:", Integer.valueOf(this.o) });
    }
    if (this.C == 0L) {
      this.C = System.currentTimeMillis();
    }
  }
  
  public void f()
  {
    setPlayRange(0, 0);
  }
  
  protected void g()
  {
    if (CaptureFreqMonitor.d)
    {
      long l1 = System.currentTimeMillis();
      CaptureFreqMonitor.e.a(2, l1);
      if (CaptureFreqMonitor.e.b())
      {
        l1 -= CaptureFreqMonitor.e.b[0];
        long l2 = CaptureFreqMonitor.e.b[1] - CaptureFreqMonitor.e.b[0];
        long l3 = CaptureFreqMonitor.e.b[2] - CaptureFreqMonitor.e.b[1];
        if ((StoryReportor.a(l1, 0L, 10000L)) && (StoryReportor.a(l2, 0L, 10000L)) && (StoryReportor.a(l3, 0L, 10000L))) {
          StoryReportor.a("OpenEditCost", true, l1, new String[] { String.valueOf(CaptureFreqMonitor.e.c), String.valueOf(l2), String.valueOf(l3) });
        }
        CaptureFreqMonitor.e.d();
      }
    }
  }
  
  public int getSpeedType()
  {
    return this.w.speedType;
  }
  
  public String getVideoFilePath()
  {
    return this.w.inputFilePath;
  }
  
  protected void h()
  {
    int i1 = this.e;
    int i2 = this.f;
    if (i1 * i2 <= 0) {
      return;
    }
    boolean bool;
    if ((i2 * 9 != i1 * 16) && (i2 * 16 != i1 * 9)) {
      bool = false;
    } else {
      bool = true;
    }
    this.g = bool;
  }
  
  public void onDecodeCancel()
  {
    if (Thread.currentThread().getId() == this.p) {
      this.o = 2;
    }
    if (QLog.isColorLevel()) {
      QLog.d("HWVideoPlayView", 2, new Object[] { "onDecodeCancel, mCurrentStat:", Integer.valueOf(this.o) });
    }
    HWDecodeListener localHWDecodeListener = this.x;
    if (localHWDecodeListener != null) {
      localHWDecodeListener.onDecodeCancel();
    }
  }
  
  public void onDecodeError(int paramInt, Throwable paramThrowable)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onDecodeError errorCode = ");
    localStringBuilder.append(paramInt);
    QLog.e("HWVideoPlayView", 4, localStringBuilder.toString(), paramThrowable);
    ShortVideoExceptionReporter.a(paramThrowable);
  }
  
  public void onDecodeFinish()
  {
    if (Thread.currentThread().getId() == this.p) {
      this.o = 5;
    }
    if (QLog.isColorLevel()) {
      QLog.d("HWVideoPlayView", 2, new Object[] { "onDecodeFinish, mCurrentStat:", Integer.valueOf(this.o) });
    }
    HWDecodeListener localHWDecodeListener = this.x;
    if (localHWDecodeListener != null) {
      localHWDecodeListener.onDecodeFinish();
    }
  }
  
  public void onDecodeFrame(long paramLong1, long paramLong2)
  {
    HWDecodeListener localHWDecodeListener = this.x;
    if (localHWDecodeListener != null) {
      localHWDecodeListener.onDecodeFrame(paramLong1, paramLong2);
    }
  }
  
  public void onDecodeRepeat()
  {
    QLog.d("HWVideoPlayView", 4, "onDecodeRepeat");
    this.k.a();
    HWDecodeListener localHWDecodeListener = this.x;
    if (localHWDecodeListener != null) {
      localHWDecodeListener.onDecodeRepeat();
    }
  }
  
  public void onDecodeSeekTo(long paramLong)
  {
    this.k.a(paramLong);
  }
  
  public void onDecodeStart()
  {
    this.o = 3;
    this.p = Thread.currentThread().getId();
    if (QLog.isColorLevel()) {
      QLog.d("HWVideoPlayView", 2, new Object[] { "onDecodeStart, mCurrentStat:", Integer.valueOf(this.o) });
    }
    HWDecodeListener localHWDecodeListener = this.x;
    if (localHWDecodeListener != null) {
      localHWDecodeListener.onDecodeStart();
    }
  }
  
  public void onDrawFrame(GL10 paramGL10)
  {
    try
    {
      if (this.b != null)
      {
        if (!this.A)
        {
          this.A = true;
          g();
        }
        long l1 = System.currentTimeMillis();
        if ((!this.B) && (this.r > 15))
        {
          this.B = true;
          this.C = l1;
        }
        l1 = 0L;
        if (CaptureFreqMonitor.b)
        {
          CaptureFreqMonitor.c.c();
          l1 = SystemClock.elapsedRealtime();
        }
        this.b.updateTexImage();
        paramGL10 = new float[16];
        this.b.getTransformMatrix(paramGL10);
        a(paramGL10, GPUBaseFilter.caculateCenterCropMvpMatrix(this.e, this.f, this.c, this.d));
        this.r += 1;
        if (CaptureFreqMonitor.c.b())
        {
          long l2 = SystemClock.elapsedRealtime();
          CaptureFreqMonitor.c.a(new Integer[] { Integer.valueOf((int)(l2 - l1)) });
          if (CaptureFreqMonitor.c.a(8000))
          {
            CaptureFreqMonitor.a();
            return;
          }
        }
      }
    }
    catch (Throwable paramGL10)
    {
      QLog.e("HWVideoPlayView", 2, "onDrawFrame error.", paramGL10);
    }
  }
  
  public void onFrameAvailable(SurfaceTexture paramSurfaceTexture)
  {
    this.b = paramSurfaceTexture;
    requestRender();
  }
  
  public void onSurfaceChanged(GL10 paramGL10, int paramInt1, int paramInt2)
  {
    if (QLog.isColorLevel())
    {
      paramGL10 = new StringBuilder();
      paramGL10.append("onSurfaceChanged : ");
      paramGL10.append(paramInt1);
      paramGL10.append(";");
      paramGL10.append(paramInt2);
      QLog.d("HWVideoPlayView", 4, paramGL10.toString());
    }
    this.v = GlUtil.createTexture(36197);
    if ((Build.VERSION.SDK_INT == 26) && (!Build.MANUFACTURER.equals("HUAWEI")))
    {
      if (QLog.isColorLevel()) {
        QLog.d("HWVideoPlayView", 4, "onSurfaceChanged special 8.0 device. Delay play.");
      }
      postDelayed(new HWVideoPlayView.2(this), 500L);
    }
    else
    {
      b();
    }
    this.c = paramInt1;
    this.d = paramInt2;
    this.y.onOutputSizeChanged(this.e, this.f);
    paramGL10 = this.u;
    if (paramGL10 != null)
    {
      paramGL10 = (HWVideoPlayView.HWVideoPlayViewListener)paramGL10.get();
      if (paramGL10 != null) {
        paramGL10.c();
      }
    }
  }
  
  public void onSurfaceCreated(GL10 paramGL10, EGLConfig paramEGLConfig)
  {
    if (QLog.isColorLevel()) {
      QLog.d("HWVideoPlayView", 4, "onSurfaceCreated");
    }
    this.y = ((GPUOESBaseFilter)FilterFactory.a(102));
    this.y.init();
    this.z = false;
  }
  
  public void setBgmFilePath(String paramString)
  {
    AudioDecodeConfig localAudioDecodeConfig = this.l;
    localAudioDecodeConfig.i = paramString;
    localAudioDecodeConfig.j = AudioEncoder.a(paramString, null, 0);
  }
  
  public void setDecodeListener(HWDecodeListener paramHWDecodeListener)
  {
    this.x = paramHWDecodeListener;
  }
  
  public void setFilePath(String paramString1, String paramString2)
  {
    this.w.inputFilePath = paramString1;
    Object localObject = this.l;
    ((AudioDecodeConfig)localObject).a = paramString2;
    ((AudioDecodeConfig)localObject).b = AudioEncoder.a(paramString2, null, 0);
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("setFilePath: videoFilePath = ");
      ((StringBuilder)localObject).append(this.w.inputFilePath);
      ((StringBuilder)localObject).append(" ; audioFilePath = ");
      ((StringBuilder)localObject).append(paramString2);
      QLog.d("HWVideoPlayView", 2, ((StringBuilder)localObject).toString());
    }
    if ((this.m == 0L) || (this.e == 0) || (this.f == 0))
    {
      this.m = VideoCompositeHelper.b(this.w.inputFilePath);
      this.l.h = this.m;
      paramString2 = new MediaMetadataUtils.MetaData();
      int i4 = MediaMetadataUtils.a(paramString1, paramString2);
      int i1 = paramString2.a[0];
      int i2 = paramString2.a[1];
      int i3 = this.j;
      if ((i3 != 90) && (i3 != 270)) {
        i3 = i1;
      } else {
        i3 = i2;
      }
      this.e = i3;
      int i5 = this.j;
      i3 = i1;
      if (i5 != 90) {
        if (i5 == 270) {
          i3 = i1;
        } else {
          i3 = i2;
        }
      }
      this.f = i3;
      h();
      this.h = this.e;
      this.i = this.f;
      paramString1 = new StringBuilder();
      paramString1.append("setFilePath: errcode = ");
      paramString1.append(i4);
      paramString1.append(" ; videoWidth = ");
      paramString1.append(this.e);
      paramString1.append(" , videoHeight=");
      paramString1.append(this.f);
      paramString1.append(" , mVideoRotation=");
      paramString1.append(this.j);
      paramString1.append(" , rotation=");
      paramString1.append(paramString2.a[2]);
      paramString1.append(" videoDuration=");
      paramString1.append(this.m);
      QLog.d("HWVideoPlayView", 1, paramString1.toString());
    }
  }
  
  public void setMediaInfo(LocalMediaInfo paramLocalMediaInfo)
  {
    this.m = paramLocalMediaInfo.mDuration;
    this.l.h = this.m;
    int i1 = paramLocalMediaInfo.mediaWidth;
    int i2 = paramLocalMediaInfo.mediaHeight;
    int i3 = this.j;
    if ((i3 != 90) && (i3 != 270)) {
      i3 = i1;
    } else {
      i3 = i2;
    }
    this.e = i3;
    i3 = this.j;
    if ((i3 == 90) || (i3 == 270)) {
      i2 = i1;
    }
    this.f = i2;
    h();
    this.h = this.e;
    this.i = this.f;
    if (QLog.isColorLevel())
    {
      paramLocalMediaInfo = new StringBuilder();
      paramLocalMediaInfo.append("videoWidth = ");
      paramLocalMediaInfo.append(this.e);
      paramLocalMediaInfo.append(" , videoHeight=");
      paramLocalMediaInfo.append(this.f);
      paramLocalMediaInfo.append(" , mVideoRotation=");
      paramLocalMediaInfo.append(this.j);
      paramLocalMediaInfo.append(" videoDuration=");
      paramLocalMediaInfo.append(this.m);
      QLog.d("HWVideoPlayView", 2, paramLocalMediaInfo.toString());
    }
  }
  
  public void setMuteAudio(boolean paramBoolean)
  {
    this.l.e = paramBoolean;
    this.k.a(paramBoolean);
  }
  
  public void setPlayRange(int paramInt1, int paramInt2)
  {
    Object localObject = this.w;
    if (localObject != null)
    {
      ((DecodeConfig)localObject).startTimeMillSecond = paramInt1;
      ((DecodeConfig)localObject).endTimeMillSecond = paramInt2;
    }
    localObject = this.l;
    if (localObject != null)
    {
      ((AudioDecodeConfig)localObject).f = paramInt1;
      ((AudioDecodeConfig)localObject).g = paramInt2;
    }
    localObject = this.a;
    if (localObject != null) {
      ((HWVideoDecoder)localObject).setPlayRange(paramInt1, paramInt2);
    }
    localObject = this.k;
    if (localObject != null) {
      ((AudioDecoder)localObject).a(paramInt1, paramInt2);
    }
  }
  
  public void setPlayViewListener(HWVideoPlayView.HWVideoPlayViewListener paramHWVideoPlayViewListener)
  {
    if (paramHWVideoPlayViewListener == null)
    {
      this.u = null;
      return;
    }
    this.u = new WeakReference(paramHWVideoPlayViewListener);
  }
  
  public void setProlong(long paramLong)
  {
    this.w.prolongToTime = paramLong;
    this.a.setProlongToTime(paramLong);
  }
  
  public void setRepeat(boolean paramBoolean)
  {
    this.w.repeat = paramBoolean;
    this.l.c = paramBoolean;
  }
  
  public void setSpeedType(int paramInt)
  {
    this.w.speedType = paramInt;
    this.l.d = paramInt;
    this.a.setSpeedType(paramInt);
    this.k.a(paramInt);
  }
  
  public void setVideoDecodeConfig(DecodeConfig paramDecodeConfig)
  {
    this.w.copyFrom(paramDecodeConfig);
  }
  
  public void setVolume(float paramFloat)
  {
    this.l.b.h = paramFloat;
  }
  
  public void surfaceDestroyed(SurfaceHolder paramSurfaceHolder)
  {
    if (QLog.isColorLevel()) {
      QLog.d("HWVideoPlayView", 4, "surfaceDestroyed");
    }
    super.surfaceDestroyed(paramSurfaceHolder);
    c();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.aioeditor.richmedia.mediacodec.widget.HWVideoPlayView
 * JD-Core Version:    0.7.0.1
 */