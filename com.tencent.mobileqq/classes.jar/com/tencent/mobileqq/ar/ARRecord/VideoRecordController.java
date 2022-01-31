package com.tencent.mobileqq.ar.ARRecord;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.opengl.EGL14;
import android.opengl.GLES20;
import android.opengl.GLUtils;
import android.opengl.Matrix;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Message;
import android.os.SystemClock;
import android.text.TextUtils;
import android.view.Surface;
import com.tencent.av.ui.funchat.record.FileSwapHelper;
import com.tencent.mobileqq.ar.ARRecord.renderer.ARTextureRender;
import com.tencent.mobileqq.ar.ScanEntranceDPC;
import com.tencent.mobileqq.arcard.ARCardUtils;
import com.tencent.mobileqq.filemanager.util.FileUtil;
import com.tencent.mobileqq.richmedia.mediacodec.encoder.EncodeConfig;
import com.tencent.mobileqq.richmedia.mediacodec.renderer.TextureRender;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import javax.microedition.khronos.egl.EGLConfig;

public class VideoRecordController
  implements Handler.Callback, ARVideoRecordDataSource, VideoEncoder.VideoEncoderCallback
{
  private static final Object jdField_a_of_type_JavaLangObject = new Object();
  private int jdField_a_of_type_Int;
  private long jdField_a_of_type_Long;
  private Context jdField_a_of_type_AndroidContentContext;
  private Handler jdField_a_of_type_AndroidOsHandler;
  private Surface jdField_a_of_type_AndroidViewSurface;
  private AudioRecordController jdField_a_of_type_ComTencentMobileqqArARRecordAudioRecordController;
  private VideoEncoder jdField_a_of_type_ComTencentMobileqqArARRecordVideoEncoder;
  private VideoEncoderWindowSurface jdField_a_of_type_ComTencentMobileqqArARRecordVideoEncoderWindowSurface;
  private VideoRecordController.RecordListener jdField_a_of_type_ComTencentMobileqqArARRecordVideoRecordController$RecordListener;
  private VideoRecordController.State jdField_a_of_type_ComTencentMobileqqArARRecordVideoRecordController$State = VideoRecordController.State.IDLE;
  private ARTextureRender jdField_a_of_type_ComTencentMobileqqArARRecordRendererARTextureRender;
  private EncodeConfig jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecEncoderEncodeConfig;
  private TextureRender jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecRendererTextureRender;
  private File jdField_a_of_type_JavaIoFile;
  private String jdField_a_of_type_JavaLangString = "";
  private boolean jdField_a_of_type_Boolean;
  private float[] jdField_a_of_type_ArrayOfFloat;
  private int jdField_b_of_type_Int = -1;
  private long jdField_b_of_type_Long;
  private String jdField_b_of_type_JavaLangString;
  private boolean jdField_b_of_type_Boolean;
  private float[] jdField_b_of_type_ArrayOfFloat;
  private long jdField_c_of_type_Long;
  private boolean jdField_c_of_type_Boolean;
  private long jdField_d_of_type_Long;
  private boolean jdField_d_of_type_Boolean;
  private boolean e;
  private boolean f;
  private boolean g;
  private boolean h;
  private boolean i = true;
  private boolean j;
  
  public VideoRecordController(Context paramContext)
  {
    QLog.d("VideoRecordController", 2, "VideoRecordController");
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_AndroidOsHandler = new Handler(this);
  }
  
  private File a()
  {
    try
    {
      if (!TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) {}
      for (Object localObject = ARCardUtils.a(this.jdField_a_of_type_JavaLangString);; localObject = VideoEncoderUtils.b())
      {
        localObject = new File((String)localObject);
        if ((this.jdField_a_of_type_JavaIoFile == null) || (!this.jdField_a_of_type_JavaIoFile.exists()) || (!this.jdField_a_of_type_JavaIoFile.renameTo((File)localObject))) {
          break;
        }
        return localObject;
      }
      return null;
    }
    catch (Exception localException)
    {
      QLog.e("VideoRecordController", 1, "renameTempVideoFile fail.", localException);
    }
  }
  
  private void a(int paramInt1, int paramInt2)
  {
    QLog.d("VideoRecordController", 2, String.format("loadWaterMarkTexture screenWidth=%s screenHeight=%s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) }));
    if (this.jdField_b_of_type_Int == -1) {
      this.jdField_b_of_type_Int = 2130838182;
    }
    try
    {
      Bitmap localBitmap = BitmapFactory.decodeResource(this.jdField_a_of_type_AndroidContentContext.getResources(), this.jdField_b_of_type_Int);
      if (localBitmap != null)
      {
        int[] arrayOfInt = new int[1];
        GLES20.glGenTextures(1, arrayOfInt, 0);
        int k = arrayOfInt[0];
        if (k > 0)
        {
          GLES20.glBindTexture(3553, k);
          GLES20.glTexParameterf(3553, 10241, 9729.0F);
          GLES20.glTexParameterf(3553, 10240, 9729.0F);
          GLES20.glTexParameterf(3553, 10242, 33071.0F);
          GLES20.glTexParameterf(3553, 10243, 33071.0F);
          GLUtils.texImage2D(3553, 0, localBitmap, 0);
          this.jdField_a_of_type_Int = k;
          k = localBitmap.getWidth();
          int m = localBitmap.getHeight();
          float f1 = k / paramInt1;
          float f2 = m / paramInt2;
          float f3 = (paramInt1 - k - 40) / paramInt1;
          float f4 = (paramInt2 - m - 28) / paramInt2;
          this.jdField_a_of_type_ArrayOfFloat = new float[16];
          Matrix.setIdentityM(this.jdField_a_of_type_ArrayOfFloat, 0);
          Matrix.translateM(this.jdField_a_of_type_ArrayOfFloat, 0, 0.0F, 0.5F, 0.0F);
          Matrix.rotateM(this.jdField_a_of_type_ArrayOfFloat, 0, 180.0F, 1.0F, 0.0F, 0.0F);
          Matrix.translateM(this.jdField_a_of_type_ArrayOfFloat, 0, 0.0F, -0.5F, 0.0F);
          this.jdField_b_of_type_ArrayOfFloat = new float[16];
          Matrix.setIdentityM(this.jdField_b_of_type_ArrayOfFloat, 0);
          Matrix.translateM(this.jdField_b_of_type_ArrayOfFloat, 0, -f3, -f4, 0.0F);
          Matrix.scaleM(this.jdField_b_of_type_ArrayOfFloat, 0, f1, f2, 1.0F);
        }
      }
      return;
    }
    catch (OutOfMemoryError localOutOfMemoryError)
    {
      for (;;)
      {
        localOutOfMemoryError.printStackTrace();
        QLog.e("VideoRecordController", 1, String.format("loadWaterMarkTexture decode bitmap oom, %s", new Object[] { localOutOfMemoryError.getMessage() }));
        Object localObject = null;
      }
    }
  }
  
  private void a(int paramInt, long paramLong, String paramString)
  {
    QLog.d("VideoRecordController", 2, String.format("notifyRecordFinish finishType=%s", new Object[] { Integer.valueOf(paramInt) }));
    if (this.jdField_a_of_type_AndroidOsHandler != null)
    {
      Message localMessage = this.jdField_a_of_type_AndroidOsHandler.obtainMessage(104);
      localMessage.arg1 = paramInt;
      localMessage.obj = paramString;
      localMessage.sendToTarget();
      ARRecordReport.a().a(paramInt, paramLong);
    }
  }
  
  private void c(int paramInt)
  {
    int m = 1;
    int k;
    if (!this.e)
    {
      this.e = true;
      k = paramInt;
      if (paramInt == 2) {
        if (System.currentTimeMillis() - this.jdField_b_of_type_Long >= 1000L) {
          break label63;
        }
      }
    }
    for (;;)
    {
      k = paramInt;
      if (m != 0) {
        k = 11;
      }
      if (!this.jdField_b_of_type_Boolean) {
        d(k);
      }
      f();
      return;
      label63:
      m = 0;
    }
  }
  
  private void d(int paramInt)
  {
    QLog.d("VideoRecordController", 2, String.format("notifyRecordError errorType=%s", new Object[] { Integer.valueOf(paramInt) }));
    if (this.jdField_a_of_type_AndroidOsHandler != null)
    {
      Message localMessage = this.jdField_a_of_type_AndroidOsHandler.obtainMessage(105);
      localMessage.arg1 = paramInt;
      localMessage.sendToTarget();
      ARRecordReport.a().a(paramInt);
    }
  }
  
  private void e()
  {
    if ((this.jdField_a_of_type_JavaIoFile != null) && (this.jdField_a_of_type_JavaIoFile.exists())) {
      this.jdField_a_of_type_JavaIoFile.delete();
    }
  }
  
  private boolean e()
  {
    boolean bool = true;
    QLog.d("VideoRecordController", 2, String.format("startRecord mState=%s mIsRecording=%s", new Object[] { this.jdField_a_of_type_ComTencentMobileqqArARRecordVideoRecordController$State, Boolean.valueOf(this.jdField_a_of_type_Boolean) }));
    for (;;)
    {
      synchronized (jdField_a_of_type_JavaLangObject)
      {
        if (!this.jdField_a_of_type_Boolean)
        {
          this.jdField_a_of_type_Boolean = true;
          this.j = false;
          this.jdField_c_of_type_Boolean = false;
          this.jdField_a_of_type_ComTencentMobileqqArARRecordVideoRecordController$State = VideoRecordController.State.STARTING;
          this.jdField_d_of_type_Boolean = false;
          this.e = false;
          this.f = false;
          this.g = false;
          this.jdField_c_of_type_Long = 0L;
          return bool;
        }
      }
      bool = false;
    }
  }
  
  private void f()
  {
    QLog.d("VideoRecordController", 2, "notifyRecordStart");
    if (this.jdField_a_of_type_AndroidOsHandler != null) {
      this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(102);
    }
  }
  
  private boolean f()
  {
    boolean bool = true;
    QLog.d("VideoRecordController", 2, String.format("stopRecord mState=%s mIsRecording=%s mNotSaveRecordFile=%s mHaveErrorHappened=%s mHaveMaxRecord=%s mHaveSDCardFull=%s", new Object[] { this.jdField_a_of_type_ComTencentMobileqqArARRecordVideoRecordController$State, Boolean.valueOf(this.jdField_a_of_type_Boolean), Boolean.valueOf(this.jdField_d_of_type_Boolean), Boolean.valueOf(this.e), Boolean.valueOf(this.f), Boolean.valueOf(this.g) }));
    for (;;)
    {
      synchronized (jdField_a_of_type_JavaLangObject)
      {
        if (this.jdField_a_of_type_Boolean)
        {
          if (this.jdField_a_of_type_ComTencentMobileqqArARRecordAudioRecordController != null)
          {
            this.jdField_a_of_type_ComTencentMobileqqArARRecordAudioRecordController.c();
            this.jdField_a_of_type_ComTencentMobileqqArARRecordAudioRecordController = null;
            this.jdField_b_of_type_JavaLangString = null;
          }
          if (this.jdField_a_of_type_ComTencentMobileqqArARRecordVideoEncoder != null)
          {
            this.jdField_a_of_type_ComTencentMobileqqArARRecordVideoEncoder.a();
            this.jdField_a_of_type_ComTencentMobileqqArARRecordVideoRecordController$State = VideoRecordController.State.STOPPING;
            this.jdField_a_of_type_ComTencentMobileqqArARRecordVideoEncoder = null;
            if (this.jdField_a_of_type_AndroidViewSurface != null)
            {
              this.jdField_a_of_type_AndroidViewSurface.release();
              this.jdField_a_of_type_AndroidViewSurface = null;
            }
            this.jdField_c_of_type_Boolean = false;
            return bool;
          }
          if (this.jdField_a_of_type_ComTencentMobileqqArARRecordVideoRecordController$State != VideoRecordController.State.STARTING) {
            continue;
          }
          QLog.e("VideoRecordController", 1, "stopRecord VideoEncoder is starting.");
          if (!this.jdField_b_of_type_Boolean) {
            d(11);
          }
          this.jdField_a_of_type_Boolean = false;
          this.jdField_a_of_type_ComTencentMobileqqArARRecordVideoRecordController$State = VideoRecordController.State.IDLE;
        }
      }
      bool = false;
    }
  }
  
  private void g()
  {
    long l1 = System.currentTimeMillis();
    long l2 = this.jdField_b_of_type_Long;
    long l3 = this.jdField_c_of_type_Long;
    long l4 = FileSwapHelper.a();
    if (l1 - l2 - l3 >= 60000L)
    {
      this.f = true;
      f();
      return;
    }
    if (l4 <= 5242880L)
    {
      this.g = true;
      f();
      return;
    }
    h();
  }
  
  private void h()
  {
    Message localMessage;
    if (this.jdField_a_of_type_AndroidOsHandler != null)
    {
      this.jdField_a_of_type_AndroidOsHandler.removeMessages(103);
      this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(101, 1000L);
      localMessage = this.jdField_a_of_type_AndroidOsHandler.obtainMessage(103);
      localMessage.arg1 = ((int)(System.currentTimeMillis() - this.jdField_b_of_type_Long));
      if (this.jdField_a_of_type_JavaIoFile == null) {
        break label78;
      }
    }
    label78:
    for (long l = this.jdField_a_of_type_JavaIoFile.length();; l = 0L)
    {
      localMessage.arg2 = ((int)l);
      localMessage.sendToTarget();
      return;
    }
  }
  
  public void a()
  {
    QLog.d("VideoRecordController", 2, "onEncodeStart");
  }
  
  public void a(int paramInt)
  {
    QLog.d("VideoRecordController", 2, String.format("onEncodeError errorCode=%s", new Object[] { Integer.valueOf(paramInt) }));
    c(paramInt);
    synchronized (jdField_a_of_type_JavaLangObject)
    {
      this.jdField_a_of_type_Boolean = false;
      this.jdField_b_of_type_Boolean = false;
      this.jdField_a_of_type_ComTencentMobileqqArARRecordVideoRecordController$State = VideoRecordController.State.IDLE;
      return;
    }
  }
  
  public void a(int paramInt1, int paramInt2, float[] paramArrayOfFloat1, float[] paramArrayOfFloat2, long paramLong)
  {
    synchronized (jdField_a_of_type_JavaLangObject)
    {
      long l = System.currentTimeMillis();
      if (l - this.jdField_a_of_type_Long < 33L) {
        return;
      }
      this.jdField_a_of_type_Long = l;
      if ((this.jdField_c_of_type_Boolean) && (this.jdField_a_of_type_Boolean) && (this.jdField_a_of_type_ComTencentMobileqqArARRecordVideoEncoder != null) && (!this.j))
      {
        l = this.jdField_c_of_type_Long;
        paramLong -= l;
      }
      try
      {
        this.jdField_a_of_type_ComTencentMobileqqArARRecordVideoEncoderWindowSurface.b();
        GLES20.glViewport(0, 0, this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecEncoderEncodeConfig.jdField_a_of_type_Int, this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecEncoderEncodeConfig.jdField_b_of_type_Int);
        GLES20.glClearColor(0.0F, 0.0F, 0.0F, 1.0F);
        GLES20.glClear(16640);
        GLES20.glDepthMask(false);
        GLES20.glDisable(2929);
        this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecRendererTextureRender.a(paramInt1, paramInt2, paramArrayOfFloat1, paramArrayOfFloat2);
        if (this.i)
        {
          GLES20.glEnable(3042);
          GLES20.glBlendFunc(1, 771);
          this.jdField_a_of_type_ComTencentMobileqqArARRecordRendererARTextureRender.a(3553, this.jdField_a_of_type_Int, this.jdField_a_of_type_ArrayOfFloat, this.jdField_b_of_type_ArrayOfFloat);
          GLES20.glDisable(3042);
        }
        this.jdField_a_of_type_ComTencentMobileqqArARRecordVideoEncoderWindowSurface.a(paramLong);
        this.jdField_a_of_type_ComTencentMobileqqArARRecordVideoEncoderWindowSurface.c();
        this.jdField_a_of_type_ComTencentMobileqqArARRecordVideoEncoderWindowSurface.a();
        this.jdField_a_of_type_ComTencentMobileqqArARRecordVideoEncoder.a(paramLong);
      }
      catch (Exception paramArrayOfFloat1)
      {
        for (;;)
        {
          QLog.e("VideoRecordController", 1, "onVideoFrameAvailable render encode surface fail.", paramArrayOfFloat1);
          c(4);
        }
      }
      return;
    }
  }
  
  public void a(long paramLong) {}
  
  public void a(VideoRecordController.RecordListener paramRecordListener)
  {
    QLog.d("VideoRecordController", 2, String.format("setVideoRecordListener listener=%s", new Object[] { paramRecordListener }));
    this.jdField_a_of_type_ComTencentMobileqqArARRecordVideoRecordController$RecordListener = paramRecordListener;
  }
  
  public void a(String paramString)
  {
    if (!TextUtils.isEmpty(paramString))
    {
      this.jdField_a_of_type_JavaLangString = paramString;
      this.h = true;
    }
  }
  
  public void a(EGLConfig arg1, int paramInt1, int paramInt2)
  {
    QLog.d("VideoRecordController", 2, String.format("doStartRecord mState=%s mIsRecording=%s", new Object[] { this.jdField_a_of_type_ComTencentMobileqqArARRecordVideoRecordController$State, Boolean.valueOf(this.jdField_a_of_type_Boolean) }));
    synchronized (jdField_a_of_type_JavaLangObject)
    {
      boolean bool = this.jdField_a_of_type_Boolean;
      if (bool) {}
      try
      {
        String str = VideoEncoderUtils.a();
        this.jdField_a_of_type_JavaIoFile = new File(str);
        this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecEncoderEncodeConfig = new EncodeConfig(str, 540, (int)(540 / paramInt1 * paramInt2) / 16 * 16, 2048000, 1, false, 0);
        this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecEncoderEncodeConfig.a(EGL14.eglGetCurrentContext());
        this.jdField_a_of_type_ComTencentMobileqqArARRecordVideoEncoder = new VideoEncoder();
        this.jdField_a_of_type_ComTencentMobileqqArARRecordVideoEncoder.a(this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecEncoderEncodeConfig, this);
        this.jdField_a_of_type_AndroidViewSurface = this.jdField_a_of_type_ComTencentMobileqqArARRecordVideoEncoder.a();
        this.jdField_a_of_type_ComTencentMobileqqArARRecordVideoEncoderWindowSurface = new VideoEncoderWindowSurface(this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecEncoderEncodeConfig.a(), this.jdField_a_of_type_AndroidViewSurface);
        this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecRendererTextureRender = new TextureRender();
        this.jdField_a_of_type_ComTencentMobileqqArARRecordRendererARTextureRender = new ARTextureRender();
        a(this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecEncoderEncodeConfig.jdField_a_of_type_Int, this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecEncoderEncodeConfig.jdField_b_of_type_Int);
        if (!FileUtil.a(this.jdField_b_of_type_JavaLangString)) {
          break label260;
        }
        this.jdField_a_of_type_ComTencentMobileqqArARRecordAudioRecordController = new PcmRecordController(this, this.jdField_b_of_type_JavaLangString);
        this.jdField_a_of_type_ComTencentMobileqqArARRecordAudioRecordController.b();
        f();
        this.jdField_a_of_type_ComTencentMobileqqArARRecordVideoRecordController$State = VideoRecordController.State.STARTED;
      }
      catch (Exception localException)
      {
        for (;;)
        {
          label260:
          QLog.e("VideoRecordController", 1, "doStartRecord fail.", localException);
          c(1);
        }
      }
      return;
      this.jdField_a_of_type_ComTencentMobileqqArARRecordAudioRecordController = new MicRecordController(this);
    }
  }
  
  public void a(boolean paramBoolean)
  {
    this.i = paramBoolean;
  }
  
  public void a(byte[] paramArrayOfByte, long paramLong)
  {
    synchronized (jdField_a_of_type_JavaLangObject)
    {
      long l = this.jdField_c_of_type_Long;
      if ((this.jdField_a_of_type_Boolean) && (this.jdField_a_of_type_ComTencentMobileqqArARRecordVideoEncoder != null) && (!this.j))
      {
        this.jdField_a_of_type_ComTencentMobileqqArARRecordVideoEncoder.a(paramArrayOfByte, paramLong - l);
        this.jdField_c_of_type_Boolean = true;
      }
      return;
    }
  }
  
  public boolean a()
  {
    for (;;)
    {
      synchronized (jdField_a_of_type_JavaLangObject)
      {
        if ((this.jdField_a_of_type_Boolean) && (!this.jdField_b_of_type_Boolean))
        {
          bool = true;
          return bool;
        }
      }
      boolean bool = false;
    }
  }
  
  public boolean a(boolean paramBoolean, String paramString)
  {
    boolean bool = true;
    if (!ScanEntranceDPC.a().jdField_d_of_type_Boolean)
    {
      QLog.w("VideoRecordController", 2, "startVideoRecord record is disable.");
      return false;
    }
    QLog.d("VideoRecordController", 2, String.format("startVideoRecord userOperation=%s mState=%s mIsRecording=%s mIsPreRecord=%s, audioPath=%s", new Object[] { Boolean.valueOf(paramBoolean), this.jdField_a_of_type_ComTencentMobileqqArARRecordVideoRecordController$State, Boolean.valueOf(this.jdField_a_of_type_Boolean), Boolean.valueOf(this.jdField_b_of_type_Boolean), paramString }));
    synchronized (jdField_a_of_type_JavaLangObject)
    {
      if (this.jdField_a_of_type_ComTencentMobileqqArARRecordVideoRecordController$State == VideoRecordController.State.STOPPING)
      {
        QLog.e("VideoRecordController", 1, "startVideoRecord VideoEncoder is stopping.");
        return false;
      }
    }
    this.jdField_b_of_type_JavaLangString = paramString;
    if (!paramBoolean)
    {
      if ((this.jdField_b_of_type_Boolean) || (!e())) {
        break label262;
      }
      this.jdField_b_of_type_Boolean = true;
      if (this.jdField_a_of_type_AndroidOsHandler != null) {
        this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(100, 4000L);
      }
      ARRecordReport.a().a();
      paramBoolean = bool;
    }
    for (;;)
    {
      return paramBoolean;
      if (this.jdField_b_of_type_Boolean)
      {
        this.jdField_b_of_type_Boolean = false;
        this.jdField_b_of_type_Long = System.currentTimeMillis();
        f();
        h();
        ARRecordReport.a().a(true);
        paramBoolean = bool;
      }
      else if (e())
      {
        this.jdField_b_of_type_Long = System.currentTimeMillis();
        g();
        ARRecordReport.a().a(false);
        paramBoolean = bool;
        if (this.jdField_a_of_type_AndroidOsHandler != null)
        {
          this.jdField_a_of_type_AndroidOsHandler.removeMessages(100);
          paramBoolean = bool;
        }
      }
      else
      {
        label262:
        paramBoolean = false;
      }
    }
  }
  
  public boolean a(boolean paramBoolean1, boolean paramBoolean2)
  {
    boolean bool = true;
    if (!ScanEntranceDPC.a().jdField_d_of_type_Boolean)
    {
      QLog.w("VideoRecordController", 2, "stopVideoRecord record is disable.");
      return false;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqArARRecordVideoRecordController$State == VideoRecordController.State.STOPPING)
    {
      QLog.w("VideoRecordController", 2, "stopVideoRecord state == stopping");
      return false;
    }
    QLog.d("VideoRecordController", 2, String.format("stopVideoRecord userOperation=%s saveRecord=%s mState=%s mIsPreRecord=%s", new Object[] { Boolean.valueOf(paramBoolean1), Boolean.valueOf(paramBoolean2), this.jdField_a_of_type_ComTencentMobileqqArARRecordVideoRecordController$State, Boolean.valueOf(this.jdField_b_of_type_Boolean) }));
    if ((this.jdField_b_of_type_Boolean) || ((!paramBoolean1) && (!paramBoolean2)))
    {
      paramBoolean1 = true;
      this.jdField_d_of_type_Boolean = paramBoolean1;
      if (!f()) {
        break label155;
      }
      paramBoolean1 = bool;
      if (this.jdField_a_of_type_AndroidOsHandler != null)
      {
        this.jdField_a_of_type_AndroidOsHandler.removeMessages(100);
        this.jdField_a_of_type_AndroidOsHandler.removeMessages(101);
      }
    }
    label155:
    for (paramBoolean1 = bool;; paramBoolean1 = false)
    {
      return paramBoolean1;
      paramBoolean1 = false;
      break;
    }
  }
  
  public void b()
  {
    QLog.d("VideoRecordController", 2, "onEncodeRealStart");
  }
  
  public void b(int paramInt)
  {
    this.jdField_b_of_type_Int = paramInt;
  }
  
  public boolean b()
  {
    return this.jdField_a_of_type_Boolean;
  }
  
  public void c()
  {
    QLog.d("VideoRecordController", 2, "onEncodeFinish");
    if (this.e)
    {
      QLog.w("VideoRecordController", 1, "onEncodeFinish error happened, delete temp file.");
      e();
    }
    synchronized (jdField_a_of_type_JavaLangObject)
    {
      for (;;)
      {
        this.jdField_a_of_type_Boolean = false;
        this.jdField_b_of_type_Boolean = false;
        this.jdField_a_of_type_ComTencentMobileqqArARRecordVideoRecordController$State = VideoRecordController.State.IDLE;
        return;
        long l = System.currentTimeMillis() - this.jdField_b_of_type_Long;
        if (l < 1000L) {}
        for (int k = 1;; k = 0)
        {
          if ((!this.jdField_d_of_type_Boolean) && (k == 0)) {
            break label119;
          }
          QLog.w("VideoRecordController", 1, "onEncodeFinish not valid record, delete temp file.");
          e();
          if (k == 0) {
            break;
          }
          c(11);
          break;
        }
        label119:
        ??? = a();
        if ((??? == null) || (!((File)???).exists())) {
          break;
        }
        String str = ((File)???).getAbsolutePath();
        if (!this.h) {
          ARRecordUtils.a((File)???);
        }
        QLog.d("VideoRecordController", 2, String.format("onEncodeFinish filePath=%s", new Object[] { str }));
        if (this.f) {
          a(1, l, str);
        } else if (this.g) {
          a(2, l, str);
        } else {
          a(0, l, str);
        }
      }
      QLog.e("VideoRecordController", 1, "onEncodeFinish rename file fail, delete temp file.");
      e();
      c(12);
    }
  }
  
  public boolean c()
  {
    synchronized (jdField_a_of_type_JavaLangObject)
    {
      if ((this.jdField_a_of_type_Boolean) && (!this.j) && (this.jdField_a_of_type_ComTencentMobileqqArARRecordVideoRecordController$State == VideoRecordController.State.STARTED))
      {
        this.j = true;
        this.jdField_a_of_type_ComTencentMobileqqArARRecordVideoRecordController$State = VideoRecordController.State.PAUSE;
        if (this.jdField_a_of_type_ComTencentMobileqqArARRecordAudioRecordController != null) {
          this.jdField_a_of_type_ComTencentMobileqqArARRecordAudioRecordController.d();
        }
        this.jdField_d_of_type_Long = SystemClock.elapsedRealtimeNanos();
      }
      if (QLog.isColorLevel()) {
        QLog.d("VideoRecordController", 2, String.format("pauseRecord, isRecording: %s, isSuc: %s, mState: %s", new Object[] { Boolean.valueOf(this.jdField_a_of_type_Boolean), Boolean.valueOf(false), this.jdField_a_of_type_ComTencentMobileqqArARRecordVideoRecordController$State }));
      }
      return false;
    }
  }
  
  public void d()
  {
    QLog.d("VideoRecordController", 2, "releaseGLResource");
    if (this.jdField_a_of_type_ComTencentMobileqqArARRecordVideoEncoderWindowSurface != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqArARRecordVideoEncoderWindowSurface.d();
      this.jdField_a_of_type_ComTencentMobileqqArARRecordVideoEncoderWindowSurface = null;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecRendererTextureRender != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecRendererTextureRender.a();
      this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecRendererTextureRender = null;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqArARRecordRendererARTextureRender != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqArARRecordRendererARTextureRender.a();
      this.jdField_a_of_type_ComTencentMobileqqArARRecordRendererARTextureRender = null;
    }
    if (this.jdField_a_of_type_Int > 0)
    {
      GLES20.glDeleteTextures(0, new int[] { this.jdField_a_of_type_Int }, 0);
      this.jdField_a_of_type_Int = 0;
      this.jdField_a_of_type_ArrayOfFloat = null;
      this.jdField_b_of_type_ArrayOfFloat = null;
    }
  }
  
  public boolean d()
  {
    boolean bool2 = true;
    for (;;)
    {
      synchronized (jdField_a_of_type_JavaLangObject)
      {
        if ((this.jdField_a_of_type_Boolean) && (this.j))
        {
          this.j = false;
          this.jdField_a_of_type_ComTencentMobileqqArARRecordVideoRecordController$State = VideoRecordController.State.STARTED;
          this.jdField_c_of_type_Long += SystemClock.elapsedRealtimeNanos() - this.jdField_d_of_type_Long;
          bool1 = bool2;
          if (this.jdField_a_of_type_ComTencentMobileqqArARRecordAudioRecordController != null)
          {
            this.jdField_a_of_type_ComTencentMobileqqArARRecordAudioRecordController.e();
            bool1 = bool2;
          }
          if (QLog.isColorLevel()) {
            QLog.d("VideoRecordController", 2, String.format("continueRecord, isRecording: %s, isSuc:%s", new Object[] { Boolean.valueOf(this.jdField_a_of_type_Boolean), Boolean.valueOf(bool1) }));
          }
          return bool1;
        }
      }
      boolean bool1 = false;
    }
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    }
    do
    {
      do
      {
        do
        {
          do
          {
            do
            {
              return true;
            } while (!this.jdField_b_of_type_Boolean);
            this.jdField_d_of_type_Boolean = true;
            f();
            return true;
            g();
            return true;
          } while ((this.jdField_a_of_type_ComTencentMobileqqArARRecordVideoRecordController$RecordListener == null) || (this.jdField_b_of_type_Boolean));
          this.jdField_a_of_type_ComTencentMobileqqArARRecordVideoRecordController$RecordListener.i();
          return true;
        } while ((this.jdField_a_of_type_ComTencentMobileqqArARRecordVideoRecordController$RecordListener == null) || (this.jdField_b_of_type_Boolean));
        this.jdField_a_of_type_ComTencentMobileqqArARRecordVideoRecordController$RecordListener.a(paramMessage.arg1, paramMessage.arg2);
        return true;
      } while ((this.jdField_a_of_type_ComTencentMobileqqArARRecordVideoRecordController$RecordListener == null) || (this.jdField_b_of_type_Boolean));
      this.jdField_a_of_type_ComTencentMobileqqArARRecordVideoRecordController$RecordListener.a(paramMessage.arg1, (String)paramMessage.obj);
      return true;
    } while ((this.jdField_a_of_type_ComTencentMobileqqArARRecordVideoRecordController$RecordListener == null) || (this.jdField_b_of_type_Boolean));
    this.jdField_a_of_type_ComTencentMobileqqArARRecordVideoRecordController$RecordListener.c(paramMessage.arg1);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.ar.ARRecord.VideoRecordController
 * JD-Core Version:    0.7.0.1
 */