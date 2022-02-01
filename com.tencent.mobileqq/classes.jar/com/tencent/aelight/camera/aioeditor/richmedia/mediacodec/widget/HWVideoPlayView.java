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
  protected int a;
  public long a;
  protected SurfaceTexture a;
  private GLSurfaceView.EGLContextFactory jdField_a_of_type_AndroidOpenglGLSurfaceView$EGLContextFactory = new HWVideoPlayView.1(this);
  protected AudioDecoder a;
  private final DecodeConfig jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecVideodecoderDecodeConfig = new DecodeConfig();
  private HWDecodeListener jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecVideodecoderHWDecodeListener;
  protected HWVideoDecoder a;
  protected final AudioDecodeConfig a;
  private GPUOESBaseFilter jdField_a_of_type_ComTencentTtpicOpenapiFilterGPUOESBaseFilter;
  private WeakReference<HWVideoPlayView.HWVideoPlayViewListener> jdField_a_of_type_JavaLangRefWeakReference;
  public boolean a;
  protected int b;
  protected long b;
  protected boolean b;
  public int c;
  public long c;
  private boolean c;
  public int d;
  private long jdField_d_of_type_Long = 0L;
  private boolean jdField_d_of_type_Boolean = false;
  public int e;
  private boolean e;
  public int f;
  protected int g;
  protected int h = 0;
  public int i = 0;
  public int j = 0;
  private int k;
  
  public HWVideoPlayView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public HWVideoPlayView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecVideodecoderHWVideoDecoder = null;
    this.jdField_a_of_type_Long = 0L;
    this.jdField_a_of_type_Boolean = false;
    this.jdField_b_of_type_Long = 0L;
    this.jdField_c_of_type_Boolean = false;
    this.jdField_b_of_type_Boolean = false;
    this.jdField_e_of_type_Boolean = false;
    this.jdField_c_of_type_Long = 0L;
    setEGLContextFactory(this.jdField_a_of_type_AndroidOpenglGLSurfaceView$EGLContextFactory);
    setEGLContextClientVersion(2);
    this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecVideodecoderHWVideoDecoder = new HWVideoDecoder();
    this.jdField_a_of_type_ComTencentAelightCameraAioeditorRichmediaMediacodecAudioDecoder = new AudioDecoder();
    this.jdField_a_of_type_ComTencentMobileqqVideocodecAudioAudioDecodeConfig = new AudioDecodeConfig();
    setRenderer(this);
    setRenderMode(0);
  }
  
  public int a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecVideodecoderDecodeConfig.speedType;
  }
  
  public int a(int paramInt)
  {
    this.g = paramInt;
    return this.g;
  }
  
  public int a(LocalMediaInfo paramLocalMediaInfo)
  {
    if (VideoUtils.a(paramLocalMediaInfo)) {
      this.g = (paramLocalMediaInfo.rotation + 90);
    } else {
      this.g = paramLocalMediaInfo.rotation;
    }
    if (QLog.isColorLevel())
    {
      paramLocalMediaInfo = new StringBuilder();
      paramLocalMediaInfo.append("adjustRotation: mVideoRotation=");
      paramLocalMediaInfo.append(this.g);
      QLog.d("HWVideoPlayView", 2, paramLocalMediaInfo.toString());
    }
    return this.g;
  }
  
  public String a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecVideodecoderDecodeConfig.inputFilePath;
  }
  
  protected void a()
  {
    Object localObject = this.jdField_a_of_type_AndroidGraphicsSurfaceTexture;
    if (localObject != null)
    {
      ((SurfaceTexture)localObject).release();
      this.jdField_a_of_type_AndroidGraphicsSurfaceTexture = null;
    }
    this.jdField_c_of_type_Boolean = true;
    c();
    localObject = this.jdField_a_of_type_JavaLangRefWeakReference;
    if (localObject != null)
    {
      localObject = (HWVideoPlayView.HWVideoPlayViewListener)((WeakReference)localObject).get();
      if (localObject != null) {
        ((HWVideoPlayView.HWVideoPlayViewListener)localObject).g();
      }
    }
  }
  
  protected void a(float[] paramArrayOfFloat1, float[] paramArrayOfFloat2)
  {
    this.jdField_a_of_type_ComTencentTtpicOpenapiFilterGPUOESBaseFilter.drawTexture(this.k, paramArrayOfFloat1, paramArrayOfFloat2);
  }
  
  public void b()
  {
    if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecVideodecoderDecodeConfig.inputFilePath))
    {
      this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecVideodecoderHWVideoDecoder.stopDecode();
      this.h = 1;
      if (QLog.isColorLevel()) {
        QLog.d("HWVideoPlayView", 2, new Object[] { "startPlay, mCurrentStat:", Integer.valueOf(this.h) });
      }
      this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecVideodecoderHWVideoDecoder.startDecode(this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecVideodecoderDecodeConfig, this.k, this, this);
      if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqVideocodecAudioAudioDecodeConfig.jdField_a_of_type_JavaLangString)) {
        this.jdField_a_of_type_ComTencentAelightCameraAioeditorRichmediaMediacodecAudioDecoder.a(this.jdField_a_of_type_ComTencentMobileqqVideocodecAudioAudioDecodeConfig);
      }
      return;
    }
    throw new RuntimeException("startPlay failed. videoFilePath is empty.");
  }
  
  public void c()
  {
    this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecVideodecoderHWVideoDecoder.pauseDecode();
    this.jdField_a_of_type_ComTencentAelightCameraAioeditorRichmediaMediacodecAudioDecoder.c();
    this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecVideodecoderHWVideoDecoder.stopDecode();
    this.jdField_a_of_type_ComTencentAelightCameraAioeditorRichmediaMediacodecAudioDecoder.b();
    if ((this.jdField_e_of_type_Boolean) && (this.jdField_d_of_type_Long > 0L))
    {
      this.jdField_c_of_type_Long = (System.currentTimeMillis() - this.jdField_d_of_type_Long);
      this.j = (this.i - 15);
      this.jdField_d_of_type_Long = 0L;
    }
  }
  
  public void d()
  {
    this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecVideodecoderHWVideoDecoder.pauseDecode();
    this.jdField_a_of_type_ComTencentAelightCameraAioeditorRichmediaMediacodecAudioDecoder.c();
    this.h = 4;
    if (QLog.isColorLevel()) {
      QLog.d("HWVideoPlayView", 2, new Object[] { "pausePlay, mCurrentStat:", Integer.valueOf(this.h) });
    }
    if (this.jdField_d_of_type_Long != 0L)
    {
      this.jdField_c_of_type_Long += System.currentTimeMillis() - this.jdField_d_of_type_Long;
      this.j = (this.i - 15);
      this.jdField_d_of_type_Long = 0L;
    }
  }
  
  public void e()
  {
    this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecVideodecoderHWVideoDecoder.resumeDecode();
    this.jdField_a_of_type_ComTencentAelightCameraAioeditorRichmediaMediacodecAudioDecoder.d();
    this.h = 3;
    if (QLog.isColorLevel()) {
      QLog.d("HWVideoPlayView", 2, new Object[] { "resumePlay, mCurrentStat:", Integer.valueOf(this.h) });
    }
    if (this.jdField_d_of_type_Long == 0L) {
      this.jdField_d_of_type_Long = System.currentTimeMillis();
    }
  }
  
  public void f()
  {
    setPlayRange(0, 0);
  }
  
  protected void g()
  {
    if (CaptureFreqMonitor.jdField_b_of_type_Boolean)
    {
      long l1 = System.currentTimeMillis();
      CaptureFreqMonitor.jdField_b_of_type_ComTencentMobileqqMonitorCaptureFreqMonitorItem.a(2, l1);
      if (CaptureFreqMonitor.jdField_b_of_type_ComTencentMobileqqMonitorCaptureFreqMonitorItem.a())
      {
        l1 -= CaptureFreqMonitor.jdField_b_of_type_ComTencentMobileqqMonitorCaptureFreqMonitorItem.jdField_a_of_type_ArrayOfLong[0];
        long l2 = CaptureFreqMonitor.jdField_b_of_type_ComTencentMobileqqMonitorCaptureFreqMonitorItem.jdField_a_of_type_ArrayOfLong[1] - CaptureFreqMonitor.jdField_b_of_type_ComTencentMobileqqMonitorCaptureFreqMonitorItem.jdField_a_of_type_ArrayOfLong[0];
        long l3 = CaptureFreqMonitor.jdField_b_of_type_ComTencentMobileqqMonitorCaptureFreqMonitorItem.jdField_a_of_type_ArrayOfLong[2] - CaptureFreqMonitor.jdField_b_of_type_ComTencentMobileqqMonitorCaptureFreqMonitorItem.jdField_a_of_type_ArrayOfLong[1];
        if ((StoryReportor.a(l1, 0L, 10000L)) && (StoryReportor.a(l2, 0L, 10000L)) && (StoryReportor.a(l3, 0L, 10000L))) {
          StoryReportor.a("OpenEditCost", true, l1, new String[] { String.valueOf(CaptureFreqMonitor.jdField_b_of_type_ComTencentMobileqqMonitorCaptureFreqMonitorItem.jdField_a_of_type_Int), String.valueOf(l2), String.valueOf(l3) });
        }
        CaptureFreqMonitor.jdField_b_of_type_ComTencentMobileqqMonitorCaptureFreqMonitorItem.c();
      }
    }
  }
  
  public void onDecodeCancel()
  {
    if (Thread.currentThread().getId() == this.jdField_b_of_type_Long) {
      this.h = 2;
    }
    if (QLog.isColorLevel()) {
      QLog.d("HWVideoPlayView", 2, new Object[] { "onDecodeCancel, mCurrentStat:", Integer.valueOf(this.h) });
    }
    HWDecodeListener localHWDecodeListener = this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecVideodecoderHWDecodeListener;
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
    if (Thread.currentThread().getId() == this.jdField_b_of_type_Long) {
      this.h = 5;
    }
    if (QLog.isColorLevel()) {
      QLog.d("HWVideoPlayView", 2, new Object[] { "onDecodeFinish, mCurrentStat:", Integer.valueOf(this.h) });
    }
    HWDecodeListener localHWDecodeListener = this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecVideodecoderHWDecodeListener;
    if (localHWDecodeListener != null) {
      localHWDecodeListener.onDecodeFinish();
    }
  }
  
  public void onDecodeFrame(long paramLong1, long paramLong2)
  {
    HWDecodeListener localHWDecodeListener = this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecVideodecoderHWDecodeListener;
    if (localHWDecodeListener != null) {
      localHWDecodeListener.onDecodeFrame(paramLong1, paramLong2);
    }
  }
  
  public void onDecodeRepeat()
  {
    QLog.d("HWVideoPlayView", 4, "onDecodeRepeat");
    this.jdField_a_of_type_ComTencentAelightCameraAioeditorRichmediaMediacodecAudioDecoder.a();
    HWDecodeListener localHWDecodeListener = this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecVideodecoderHWDecodeListener;
    if (localHWDecodeListener != null) {
      localHWDecodeListener.onDecodeRepeat();
    }
  }
  
  public void onDecodeSeekTo(long paramLong)
  {
    this.jdField_a_of_type_ComTencentAelightCameraAioeditorRichmediaMediacodecAudioDecoder.a(paramLong);
  }
  
  public void onDecodeStart()
  {
    this.h = 3;
    this.jdField_b_of_type_Long = Thread.currentThread().getId();
    if (QLog.isColorLevel()) {
      QLog.d("HWVideoPlayView", 2, new Object[] { "onDecodeStart, mCurrentStat:", Integer.valueOf(this.h) });
    }
    HWDecodeListener localHWDecodeListener = this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecVideodecoderHWDecodeListener;
    if (localHWDecodeListener != null) {
      localHWDecodeListener.onDecodeStart();
    }
  }
  
  public void onDrawFrame(GL10 paramGL10)
  {
    try
    {
      if (this.jdField_a_of_type_AndroidGraphicsSurfaceTexture != null)
      {
        if (!this.jdField_d_of_type_Boolean)
        {
          this.jdField_d_of_type_Boolean = true;
          g();
        }
        long l1 = System.currentTimeMillis();
        if ((!this.jdField_e_of_type_Boolean) && (this.i > 15))
        {
          this.jdField_e_of_type_Boolean = true;
          this.jdField_d_of_type_Long = l1;
        }
        l1 = 0L;
        if (CaptureFreqMonitor.jdField_a_of_type_Boolean)
        {
          CaptureFreqMonitor.jdField_a_of_type_ComTencentMobileqqMonitorCaptureFreqMonitorItem.b();
          l1 = SystemClock.elapsedRealtime();
        }
        this.jdField_a_of_type_AndroidGraphicsSurfaceTexture.updateTexImage();
        paramGL10 = new float[16];
        this.jdField_a_of_type_AndroidGraphicsSurfaceTexture.getTransformMatrix(paramGL10);
        a(paramGL10, GPUBaseFilter.caculateCenterCropMvpMatrix(this.jdField_c_of_type_Int, this.jdField_d_of_type_Int, this.jdField_a_of_type_Int, this.jdField_b_of_type_Int));
        this.i += 1;
        if (CaptureFreqMonitor.jdField_a_of_type_ComTencentMobileqqMonitorCaptureFreqMonitorItem.a())
        {
          long l2 = SystemClock.elapsedRealtime();
          CaptureFreqMonitor.jdField_a_of_type_ComTencentMobileqqMonitorCaptureFreqMonitorItem.a(new Integer[] { Integer.valueOf((int)(l2 - l1)) });
          if (CaptureFreqMonitor.jdField_a_of_type_ComTencentMobileqqMonitorCaptureFreqMonitorItem.a(8000))
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
    this.jdField_a_of_type_AndroidGraphicsSurfaceTexture = paramSurfaceTexture;
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
    this.k = GlUtil.createTexture(36197);
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
    this.jdField_a_of_type_Int = paramInt1;
    this.jdField_b_of_type_Int = paramInt2;
    this.jdField_a_of_type_ComTencentTtpicOpenapiFilterGPUOESBaseFilter.onOutputSizeChanged(this.jdField_c_of_type_Int, this.jdField_d_of_type_Int);
    paramGL10 = this.jdField_a_of_type_JavaLangRefWeakReference;
    if (paramGL10 != null)
    {
      paramGL10 = (HWVideoPlayView.HWVideoPlayViewListener)paramGL10.get();
      if (paramGL10 != null) {
        paramGL10.b();
      }
    }
  }
  
  public void onSurfaceCreated(GL10 paramGL10, EGLConfig paramEGLConfig)
  {
    if (QLog.isColorLevel()) {
      QLog.d("HWVideoPlayView", 4, "onSurfaceCreated");
    }
    this.jdField_a_of_type_ComTencentTtpicOpenapiFilterGPUOESBaseFilter = ((GPUOESBaseFilter)FilterFactory.a(102));
    this.jdField_a_of_type_ComTencentTtpicOpenapiFilterGPUOESBaseFilter.init();
    this.jdField_c_of_type_Boolean = false;
  }
  
  public void setBgmFilePath(String paramString)
  {
    AudioDecodeConfig localAudioDecodeConfig = this.jdField_a_of_type_ComTencentMobileqqVideocodecAudioAudioDecodeConfig;
    localAudioDecodeConfig.jdField_b_of_type_JavaLangString = paramString;
    localAudioDecodeConfig.jdField_b_of_type_ComTencentMobileqqShortvideoUtilAudioEncoder$AudioData = AudioEncoder.a(paramString, null, 0);
  }
  
  public void setDecodeListener(HWDecodeListener paramHWDecodeListener)
  {
    this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecVideodecoderHWDecodeListener = paramHWDecodeListener;
  }
  
  public void setFilePath(String paramString1, String paramString2)
  {
    this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecVideodecoderDecodeConfig.inputFilePath = paramString1;
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqVideocodecAudioAudioDecodeConfig;
    ((AudioDecodeConfig)localObject).jdField_a_of_type_JavaLangString = paramString2;
    ((AudioDecodeConfig)localObject).jdField_a_of_type_ComTencentMobileqqShortvideoUtilAudioEncoder$AudioData = AudioEncoder.a(paramString2, null, 0);
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("setFilePath: videoFilePath = ");
      ((StringBuilder)localObject).append(this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecVideodecoderDecodeConfig.inputFilePath);
      ((StringBuilder)localObject).append(" ; audioFilePath = ");
      ((StringBuilder)localObject).append(paramString2);
      QLog.d("HWVideoPlayView", 2, ((StringBuilder)localObject).toString());
    }
    if ((this.jdField_a_of_type_Long == 0L) || (this.jdField_c_of_type_Int == 0) || (this.jdField_d_of_type_Int == 0))
    {
      this.jdField_a_of_type_Long = VideoCompositeHelper.a(this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecVideodecoderDecodeConfig.inputFilePath);
      this.jdField_a_of_type_ComTencentMobileqqVideocodecAudioAudioDecodeConfig.jdField_c_of_type_Long = this.jdField_a_of_type_Long;
      paramString2 = new MediaMetadataUtils.MetaData();
      int i2 = MediaMetadataUtils.a(paramString1, paramString2);
      int m = paramString2.a[0];
      int n = paramString2.a[1];
      int i1 = this.g;
      if ((i1 != 90) && (i1 != 270)) {
        i1 = m;
      } else {
        i1 = n;
      }
      this.jdField_c_of_type_Int = i1;
      int i3 = this.g;
      i1 = m;
      if (i3 != 90) {
        if (i3 == 270) {
          i1 = m;
        } else {
          i1 = n;
        }
      }
      this.jdField_d_of_type_Int = i1;
      this.jdField_e_of_type_Int = this.jdField_c_of_type_Int;
      this.f = this.jdField_d_of_type_Int;
      paramString1 = new StringBuilder();
      paramString1.append("setFilePath: errcode = ");
      paramString1.append(i2);
      paramString1.append(" ; videoWidth = ");
      paramString1.append(this.jdField_c_of_type_Int);
      paramString1.append(" , videoHeight=");
      paramString1.append(this.jdField_d_of_type_Int);
      paramString1.append(" , mVideoRotation=");
      paramString1.append(this.g);
      paramString1.append(" , rotation=");
      paramString1.append(paramString2.a[2]);
      paramString1.append(" videoDuration=");
      paramString1.append(this.jdField_a_of_type_Long);
      QLog.d("HWVideoPlayView", 1, paramString1.toString());
    }
  }
  
  public void setMediaInfo(LocalMediaInfo paramLocalMediaInfo)
  {
    this.jdField_a_of_type_Long = paramLocalMediaInfo.mDuration;
    this.jdField_a_of_type_ComTencentMobileqqVideocodecAudioAudioDecodeConfig.jdField_c_of_type_Long = this.jdField_a_of_type_Long;
    int m = paramLocalMediaInfo.mediaWidth;
    int n = paramLocalMediaInfo.mediaHeight;
    int i1 = this.g;
    if ((i1 != 90) && (i1 != 270)) {
      i1 = m;
    } else {
      i1 = n;
    }
    this.jdField_c_of_type_Int = i1;
    i1 = this.g;
    if ((i1 == 90) || (i1 == 270)) {
      n = m;
    }
    this.jdField_d_of_type_Int = n;
    this.jdField_e_of_type_Int = this.jdField_c_of_type_Int;
    this.f = this.jdField_d_of_type_Int;
    if (QLog.isColorLevel())
    {
      paramLocalMediaInfo = new StringBuilder();
      paramLocalMediaInfo.append("videoWidth = ");
      paramLocalMediaInfo.append(this.jdField_c_of_type_Int);
      paramLocalMediaInfo.append(" , videoHeight=");
      paramLocalMediaInfo.append(this.jdField_d_of_type_Int);
      paramLocalMediaInfo.append(" , mVideoRotation=");
      paramLocalMediaInfo.append(this.g);
      paramLocalMediaInfo.append(" videoDuration=");
      paramLocalMediaInfo.append(this.jdField_a_of_type_Long);
      QLog.d("HWVideoPlayView", 2, paramLocalMediaInfo.toString());
    }
  }
  
  public void setMuteAudio(boolean paramBoolean)
  {
    this.jdField_a_of_type_ComTencentMobileqqVideocodecAudioAudioDecodeConfig.jdField_b_of_type_Boolean = paramBoolean;
    this.jdField_a_of_type_ComTencentAelightCameraAioeditorRichmediaMediacodecAudioDecoder.a(paramBoolean);
  }
  
  public void setPlayRange(int paramInt1, int paramInt2)
  {
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecVideodecoderDecodeConfig;
    if (localObject != null)
    {
      ((DecodeConfig)localObject).startTimeMillSecond = paramInt1;
      ((DecodeConfig)localObject).endTimeMillSecond = paramInt2;
    }
    localObject = this.jdField_a_of_type_ComTencentMobileqqVideocodecAudioAudioDecodeConfig;
    if (localObject != null)
    {
      ((AudioDecodeConfig)localObject).jdField_a_of_type_Long = paramInt1;
      ((AudioDecodeConfig)localObject).jdField_b_of_type_Long = paramInt2;
    }
    localObject = this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecVideodecoderHWVideoDecoder;
    if (localObject != null) {
      ((HWVideoDecoder)localObject).setPlayRange(paramInt1, paramInt2);
    }
    localObject = this.jdField_a_of_type_ComTencentAelightCameraAioeditorRichmediaMediacodecAudioDecoder;
    if (localObject != null) {
      ((AudioDecoder)localObject).a(paramInt1, paramInt2);
    }
  }
  
  public void setPlayViewListener(HWVideoPlayView.HWVideoPlayViewListener paramHWVideoPlayViewListener)
  {
    if (paramHWVideoPlayViewListener == null)
    {
      this.jdField_a_of_type_JavaLangRefWeakReference = null;
      return;
    }
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramHWVideoPlayViewListener);
  }
  
  public void setProlong(long paramLong)
  {
    this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecVideodecoderDecodeConfig.prolongToTime = paramLong;
    this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecVideodecoderHWVideoDecoder.setProlongToTime(paramLong);
  }
  
  public void setRepeat(boolean paramBoolean)
  {
    this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecVideodecoderDecodeConfig.repeat = paramBoolean;
    this.jdField_a_of_type_ComTencentMobileqqVideocodecAudioAudioDecodeConfig.jdField_a_of_type_Boolean = paramBoolean;
  }
  
  public void setSpeedType(int paramInt)
  {
    this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecVideodecoderDecodeConfig.speedType = paramInt;
    this.jdField_a_of_type_ComTencentMobileqqVideocodecAudioAudioDecodeConfig.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecVideodecoderHWVideoDecoder.setSpeedType(paramInt);
    this.jdField_a_of_type_ComTencentAelightCameraAioeditorRichmediaMediacodecAudioDecoder.a(paramInt);
  }
  
  public void setVideoDecodeConfig(DecodeConfig paramDecodeConfig)
  {
    this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecVideodecoderDecodeConfig.copyFrom(paramDecodeConfig);
  }
  
  public void setVolume(float paramFloat)
  {
    this.jdField_a_of_type_ComTencentMobileqqVideocodecAudioAudioDecodeConfig.jdField_a_of_type_ComTencentMobileqqShortvideoUtilAudioEncoder$AudioData.a = paramFloat;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.aioeditor.richmedia.mediacodec.widget.HWVideoPlayView
 * JD-Core Version:    0.7.0.1
 */