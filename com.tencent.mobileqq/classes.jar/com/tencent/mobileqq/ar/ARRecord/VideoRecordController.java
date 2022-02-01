package com.tencent.mobileqq.ar.ARRecord;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.opengl.EGL14;
import android.opengl.GLES20;
import android.opengl.GLUtils;
import android.opengl.Matrix;
import android.os.Build;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Message;
import android.view.Surface;
import com.tencent.av.ui.funchat.record.FileSwapHelper;
import com.tencent.mobileqq.ar.ARRecord.renderer.ARTextureRender;
import com.tencent.mobileqq.ar.ScanEntranceDPC;
import com.tencent.mobileqq.filemanager.util.FileUtil;
import com.tencent.mobileqq.videocodec.mediacodec.encoder.EglCore;
import com.tencent.mobileqq.videocodec.mediacodec.encoder.EncodeConfig;
import com.tencent.qphone.base.util.QLog;
import com.tencent.ttpic.openapi.filter.TextureRender;
import java.io.File;

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
  private ARTextureRender jdField_a_of_type_ComTencentMobileqqArARRecordRendererARTextureRender;
  private EncodeConfig jdField_a_of_type_ComTencentMobileqqVideocodecMediacodecEncoderEncodeConfig;
  private TextureRender jdField_a_of_type_ComTencentTtpicOpenapiFilterTextureRender;
  private File jdField_a_of_type_JavaIoFile;
  private String jdField_a_of_type_JavaLangString;
  private boolean jdField_a_of_type_Boolean;
  private float[] jdField_a_of_type_ArrayOfFloat;
  private int jdField_b_of_type_Int = -1;
  private long jdField_b_of_type_Long;
  private boolean jdField_b_of_type_Boolean;
  private float[] jdField_b_of_type_ArrayOfFloat;
  private int jdField_c_of_type_Int = 0;
  private long jdField_c_of_type_Long;
  private boolean jdField_c_of_type_Boolean;
  private boolean d;
  private boolean e;
  private boolean f;
  private boolean g;
  private boolean h = false;
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
      File localFile = new File(VideoEncoderUtils.b());
      if ((this.jdField_a_of_type_JavaIoFile != null) && (this.jdField_a_of_type_JavaIoFile.exists()))
      {
        boolean bool = this.jdField_a_of_type_JavaIoFile.renameTo(localFile);
        if (bool) {
          return localFile;
        }
      }
    }
    catch (Exception localException)
    {
      QLog.e("VideoRecordController", 1, "renameTempVideoFile fail.", localException);
    }
    return null;
  }
  
  private void a(int paramInt1, int paramInt2)
  {
    QLog.d("VideoRecordController", 2, String.format("loadWaterMarkTexture screenWidth=%s screenHeight=%s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) }));
    if (this.jdField_b_of_type_Int == -1) {
      this.jdField_b_of_type_Int = 2130838606;
    }
    Object localObject = null;
    try
    {
      Bitmap localBitmap = BitmapFactory.decodeResource(this.jdField_a_of_type_AndroidContentContext.getResources(), this.jdField_b_of_type_Int);
      localObject = localBitmap;
    }
    catch (OutOfMemoryError localOutOfMemoryError)
    {
      localOutOfMemoryError.printStackTrace();
      QLog.e("VideoRecordController", 1, String.format("loadWaterMarkTexture decode bitmap oom, %s", new Object[] { localOutOfMemoryError.getMessage() }));
    }
    if (localObject != null)
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
        GLUtils.texImage2D(3553, 0, localObject, 0);
        this.jdField_a_of_type_Int = k;
        k = localObject.getWidth();
        int m = localObject.getHeight();
        float f1 = k;
        float f2 = paramInt1;
        f1 /= f2;
        float f4 = m;
        float f3 = paramInt2;
        f4 /= f3;
        f2 = (paramInt1 - k - 40) / f2;
        f3 = (paramInt2 - m - 28) / f3;
        this.jdField_a_of_type_ArrayOfFloat = new float[16];
        Matrix.setIdentityM(this.jdField_a_of_type_ArrayOfFloat, 0);
        Matrix.translateM(this.jdField_a_of_type_ArrayOfFloat, 0, 0.0F, 0.5F, 0.0F);
        Matrix.rotateM(this.jdField_a_of_type_ArrayOfFloat, 0, 180.0F, 1.0F, 0.0F, 0.0F);
        Matrix.translateM(this.jdField_a_of_type_ArrayOfFloat, 0, 0.0F, -0.5F, 0.0F);
        this.jdField_b_of_type_ArrayOfFloat = new float[16];
        Matrix.setIdentityM(this.jdField_b_of_type_ArrayOfFloat, 0);
        Matrix.translateM(this.jdField_b_of_type_ArrayOfFloat, 0, -f2, -f3, 0.0F);
        Matrix.scaleM(this.jdField_b_of_type_ArrayOfFloat, 0, f1, f4, 1.0F);
      }
    }
  }
  
  private void a(int paramInt, long paramLong, String paramString)
  {
    QLog.d("VideoRecordController", 2, String.format("notifyRecordFinish finishType=%s", new Object[] { Integer.valueOf(paramInt) }));
    Object localObject = this.jdField_a_of_type_AndroidOsHandler;
    if (localObject != null)
    {
      localObject = ((Handler)localObject).obtainMessage(104);
      ((Message)localObject).arg1 = paramInt;
      ((Message)localObject).obj = paramString;
      ((Message)localObject).sendToTarget();
      ARRecordReport.a().a(paramInt, paramLong);
    }
  }
  
  private void b(int paramInt)
  {
    if (!this.e)
    {
      int m = 1;
      this.e = true;
      int k = paramInt;
      if (paramInt == 2)
      {
        if (System.currentTimeMillis() - this.jdField_b_of_type_Long >= 1000L) {
          m = 0;
        }
        k = paramInt;
        if (m != 0) {
          k = 11;
        }
      }
      if (!this.jdField_b_of_type_Boolean) {
        c(k);
      }
      d();
    }
  }
  
  private void c(int paramInt)
  {
    QLog.d("VideoRecordController", 2, String.format("notifyRecordError errorType=%s", new Object[] { Integer.valueOf(paramInt) }));
    Object localObject = this.jdField_a_of_type_AndroidOsHandler;
    if (localObject != null)
    {
      localObject = ((Handler)localObject).obtainMessage(105);
      ((Message)localObject).arg1 = paramInt;
      ((Message)localObject).sendToTarget();
      ARRecordReport.a().a(paramInt);
    }
  }
  
  private boolean c()
  {
    int k = this.jdField_c_of_type_Int;
    boolean bool = false;
    QLog.d("VideoRecordController", 2, String.format("startRecord mState=%s mIsRecording=%s", new Object[] { Integer.valueOf(k), Boolean.valueOf(this.jdField_a_of_type_Boolean) }));
    synchronized (jdField_a_of_type_JavaLangObject)
    {
      if (!this.jdField_a_of_type_Boolean)
      {
        this.jdField_a_of_type_Boolean = true;
        this.j = false;
        this.jdField_c_of_type_Boolean = false;
        this.jdField_c_of_type_Int = 1;
        this.d = false;
        this.e = false;
        this.f = false;
        this.g = false;
        this.jdField_c_of_type_Long = 0L;
        bool = true;
      }
      return bool;
    }
  }
  
  private boolean d()
  {
    int k = this.jdField_c_of_type_Int;
    boolean bool = false;
    QLog.d("VideoRecordController", 2, String.format("stopRecord mState=%s mIsRecording=%s mNotSaveRecordFile=%s mHaveErrorHappened=%s mHaveMaxRecord=%s mHaveSDCardFull=%s", new Object[] { Integer.valueOf(k), Boolean.valueOf(this.jdField_a_of_type_Boolean), Boolean.valueOf(this.d), Boolean.valueOf(this.e), Boolean.valueOf(this.f), Boolean.valueOf(this.g) }));
    synchronized (jdField_a_of_type_JavaLangObject)
    {
      if (this.jdField_a_of_type_Boolean)
      {
        if (this.jdField_a_of_type_ComTencentMobileqqArARRecordAudioRecordController != null)
        {
          this.jdField_a_of_type_ComTencentMobileqqArARRecordAudioRecordController.c();
          this.jdField_a_of_type_ComTencentMobileqqArARRecordAudioRecordController = null;
          this.jdField_a_of_type_JavaLangString = null;
        }
        if (this.jdField_a_of_type_ComTencentMobileqqArARRecordVideoEncoder != null)
        {
          this.jdField_a_of_type_ComTencentMobileqqArARRecordVideoEncoder.a();
          this.jdField_c_of_type_Int = 4;
          this.jdField_a_of_type_ComTencentMobileqqArARRecordVideoEncoder = null;
        }
        else if (this.jdField_c_of_type_Int == 1)
        {
          QLog.e("VideoRecordController", 1, "stopRecord VideoEncoder is starting.");
          if (!this.jdField_b_of_type_Boolean) {
            c(11);
          }
          this.jdField_a_of_type_Boolean = false;
          this.jdField_c_of_type_Int = 0;
        }
        if (this.jdField_a_of_type_AndroidViewSurface != null)
        {
          this.jdField_a_of_type_AndroidViewSurface.release();
          this.jdField_a_of_type_AndroidViewSurface = null;
        }
        this.jdField_c_of_type_Boolean = false;
        bool = true;
      }
      return bool;
    }
  }
  
  private void e()
  {
    File localFile = this.jdField_a_of_type_JavaIoFile;
    if ((localFile != null) && (localFile.exists())) {
      this.jdField_a_of_type_JavaIoFile.delete();
    }
  }
  
  private void f()
  {
    QLog.d("VideoRecordController", 2, "notifyRecordStart");
    Handler localHandler = this.jdField_a_of_type_AndroidOsHandler;
    if (localHandler != null) {
      localHandler.sendEmptyMessage(102);
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
      d();
      return;
    }
    if (l4 <= 5242880L)
    {
      this.g = true;
      d();
      return;
    }
    h();
  }
  
  private void h()
  {
    Object localObject = this.jdField_a_of_type_AndroidOsHandler;
    if (localObject != null)
    {
      ((Handler)localObject).removeMessages(103);
      this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(101, 1000L);
      localObject = this.jdField_a_of_type_AndroidOsHandler.obtainMessage(103);
      ((Message)localObject).arg1 = ((int)(System.currentTimeMillis() - this.jdField_b_of_type_Long));
      File localFile = this.jdField_a_of_type_JavaIoFile;
      long l;
      if (localFile != null) {
        l = localFile.length();
      } else {
        l = 0L;
      }
      ((Message)localObject).arg2 = ((int)l);
      ((Message)localObject).sendToTarget();
    }
  }
  
  public void a()
  {
    QLog.d("VideoRecordController", 2, "onEncodeStart");
  }
  
  public void a(int paramInt)
  {
    QLog.d("VideoRecordController", 2, String.format("onEncodeError errorCode=%s", new Object[] { Integer.valueOf(paramInt) }));
    b(paramInt);
    synchronized (jdField_a_of_type_JavaLangObject)
    {
      this.jdField_a_of_type_Boolean = false;
      this.jdField_b_of_type_Boolean = false;
      this.jdField_c_of_type_Int = 0;
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
        try
        {
          this.jdField_a_of_type_ComTencentMobileqqArARRecordVideoEncoderWindowSurface.b();
          GLES20.glViewport(0, 0, this.jdField_a_of_type_ComTencentMobileqqVideocodecMediacodecEncoderEncodeConfig.jdField_a_of_type_Int, this.jdField_a_of_type_ComTencentMobileqqVideocodecMediacodecEncoderEncodeConfig.jdField_b_of_type_Int);
          GLES20.glClearColor(0.0F, 0.0F, 0.0F, 1.0F);
          GLES20.glClear(16640);
          GLES20.glDepthMask(false);
          GLES20.glDisable(2929);
          this.jdField_a_of_type_ComTencentTtpicOpenapiFilterTextureRender.drawTexture(paramInt1, paramInt2, paramArrayOfFloat1, paramArrayOfFloat2);
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
          QLog.e("VideoRecordController", 1, "onVideoFrameAvailable render encode surface fail.", paramArrayOfFloat1);
          b(4);
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
  
  public void a(EglCore paramEglCore, int paramInt1, int paramInt2)
  {
    QLog.d("VideoRecordController", 2, String.format("doStartRecord mState=%s mIsRecording=%s", new Object[] { Integer.valueOf(this.jdField_c_of_type_Int), Boolean.valueOf(this.jdField_a_of_type_Boolean) }));
    for (;;)
    {
      synchronized (jdField_a_of_type_JavaLangObject)
      {
        boolean bool = this.jdField_a_of_type_Boolean;
        if (bool) {
          try
          {
            String str = VideoEncoderUtils.a();
            this.jdField_a_of_type_JavaIoFile = new File(str);
            float f1 = 540 / paramInt1;
            paramInt2 = (int)(paramInt2 * f1) / 16;
            if (!Build.MODEL.equalsIgnoreCase("CAM-TL00")) {
              break label321;
            }
            paramInt1 = 1024000;
            this.jdField_a_of_type_ComTencentMobileqqVideocodecMediacodecEncoderEncodeConfig = new EncodeConfig(str, 540, paramInt2 * 16, paramInt1, 1, false, 0);
            this.jdField_a_of_type_ComTencentMobileqqVideocodecMediacodecEncoderEncodeConfig.a(EGL14.eglGetCurrentContext());
            this.jdField_a_of_type_ComTencentMobileqqArARRecordVideoEncoder = new VideoEncoder();
            this.jdField_a_of_type_ComTencentMobileqqArARRecordVideoEncoder.a(this.jdField_a_of_type_ComTencentMobileqqVideocodecMediacodecEncoderEncodeConfig, this);
            this.jdField_a_of_type_AndroidViewSurface = this.jdField_a_of_type_ComTencentMobileqqArARRecordVideoEncoder.a();
            this.jdField_a_of_type_ComTencentMobileqqArARRecordVideoEncoderWindowSurface = new VideoEncoderWindowSurface(paramEglCore, this.jdField_a_of_type_AndroidViewSurface);
            this.jdField_a_of_type_ComTencentTtpicOpenapiFilterTextureRender = new TextureRender();
            this.jdField_a_of_type_ComTencentMobileqqArARRecordRendererARTextureRender = new ARTextureRender();
            a(this.jdField_a_of_type_ComTencentMobileqqVideocodecMediacodecEncoderEncodeConfig.jdField_a_of_type_Int, this.jdField_a_of_type_ComTencentMobileqqVideocodecMediacodecEncoderEncodeConfig.jdField_b_of_type_Int);
            if (FileUtil.b(this.jdField_a_of_type_JavaLangString)) {
              this.jdField_a_of_type_ComTencentMobileqqArARRecordAudioRecordController = new PcmRecordController(this, this.jdField_a_of_type_JavaLangString);
            } else {
              this.jdField_a_of_type_ComTencentMobileqqArARRecordAudioRecordController = new MicRecordController(this);
            }
            this.jdField_a_of_type_ComTencentMobileqqArARRecordAudioRecordController.b();
            f();
            this.jdField_c_of_type_Int = 2;
          }
          catch (Exception paramEglCore)
          {
            QLog.e("VideoRecordController", 1, "doStartRecord fail.", paramEglCore);
            b(1);
          }
        } else {
          return;
        }
      }
      label321:
      paramInt1 = 5120000;
    }
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
    if (!ScanEntranceDPC.a().d)
    {
      QLog.w("VideoRecordController", 2, "startVideoRecord record is disable.");
      return false;
    }
    int k = this.jdField_c_of_type_Int;
    boolean bool = true;
    QLog.d("VideoRecordController", 2, String.format("startVideoRecord userOperation=%s mState=%s mIsRecording=%s mIsPreRecord=%s, audioPath=%s", new Object[] { Boolean.valueOf(paramBoolean), Integer.valueOf(k), Boolean.valueOf(this.jdField_a_of_type_Boolean), Boolean.valueOf(this.jdField_b_of_type_Boolean), paramString }));
    synchronized (jdField_a_of_type_JavaLangObject)
    {
      if (this.jdField_c_of_type_Int == 4)
      {
        QLog.e("VideoRecordController", 1, "startVideoRecord VideoEncoder is stopping.");
        return false;
      }
      this.jdField_a_of_type_JavaLangString = paramString;
      if (!paramBoolean)
      {
        if ((!this.jdField_b_of_type_Boolean) && (c()))
        {
          this.jdField_b_of_type_Boolean = true;
          paramString = this.jdField_a_of_type_AndroidOsHandler;
          if (paramString != null) {
            paramString.sendEmptyMessageDelayed(100, 4000L);
          }
          ARRecordReport.a().a();
          return true;
        }
      }
      else
      {
        if (this.jdField_b_of_type_Boolean)
        {
          this.jdField_b_of_type_Boolean = false;
          this.jdField_b_of_type_Long = System.currentTimeMillis();
          f();
          h();
          ARRecordReport.a().a(true);
          return true;
        }
        if (c())
        {
          this.jdField_b_of_type_Long = System.currentTimeMillis();
          g();
          ARRecordReport.a().a(false);
          paramString = this.jdField_a_of_type_AndroidOsHandler;
          paramBoolean = bool;
          if (paramString == null) {
            break label253;
          }
          paramString.removeMessages(100);
          return true;
        }
      }
      paramBoolean = false;
      label253:
      return paramBoolean;
    }
  }
  
  public boolean a(boolean paramBoolean1, boolean paramBoolean2)
  {
    boolean bool2 = ScanEntranceDPC.a().d;
    boolean bool1 = false;
    if (!bool2)
    {
      QLog.w("VideoRecordController", 2, "stopVideoRecord record is disable.");
      return false;
    }
    if (this.jdField_c_of_type_Int == 4)
    {
      QLog.w("VideoRecordController", 2, "stopVideoRecord state == stopping");
      return false;
    }
    QLog.d("VideoRecordController", 2, String.format("stopVideoRecord userOperation=%s saveRecord=%s mState=%s mIsPreRecord=%s", new Object[] { Boolean.valueOf(paramBoolean1), Boolean.valueOf(paramBoolean2), Integer.valueOf(this.jdField_c_of_type_Int), Boolean.valueOf(this.jdField_b_of_type_Boolean) }));
    if ((!this.jdField_b_of_type_Boolean) && ((paramBoolean1) || (paramBoolean2))) {
      paramBoolean1 = false;
    } else {
      paramBoolean1 = true;
    }
    this.d = paramBoolean1;
    paramBoolean1 = bool1;
    if (d())
    {
      Handler localHandler = this.jdField_a_of_type_AndroidOsHandler;
      if (localHandler != null)
      {
        localHandler.removeMessages(100);
        this.jdField_a_of_type_AndroidOsHandler.removeMessages(101);
      }
      paramBoolean1 = true;
    }
    return paramBoolean1;
  }
  
  public void b()
  {
    QLog.d("VideoRecordController", 2, "onEncodeRealStart");
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
    else
    {
      long l = System.currentTimeMillis() - this.jdField_b_of_type_Long;
      int k;
      if (l < 1000L) {
        k = 1;
      } else {
        k = 0;
      }
      if ((!this.d) && (k == 0))
      {
        ??? = a();
        if ((??? != null) && (((File)???).exists()))
        {
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
        else
        {
          QLog.e("VideoRecordController", 1, "onEncodeFinish rename file fail, delete temp file.");
          e();
          b(12);
        }
      }
      else
      {
        QLog.w("VideoRecordController", 1, "onEncodeFinish not valid record, delete temp file.");
        e();
        if (k != 0) {
          b(11);
        }
      }
    }
    synchronized (jdField_a_of_type_JavaLangObject)
    {
      this.jdField_a_of_type_Boolean = false;
      this.jdField_b_of_type_Boolean = false;
      this.jdField_c_of_type_Int = 0;
      return;
    }
  }
  
  public void d()
  {
    QLog.d("VideoRecordController", 2, "releaseGLResource");
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqArARRecordVideoEncoderWindowSurface;
    if (localObject != null)
    {
      ((VideoEncoderWindowSurface)localObject).d();
      this.jdField_a_of_type_ComTencentMobileqqArARRecordVideoEncoderWindowSurface = null;
    }
    localObject = this.jdField_a_of_type_ComTencentTtpicOpenapiFilterTextureRender;
    if (localObject != null)
    {
      ((TextureRender)localObject).release();
      this.jdField_a_of_type_ComTencentTtpicOpenapiFilterTextureRender = null;
    }
    localObject = this.jdField_a_of_type_ComTencentMobileqqArARRecordRendererARTextureRender;
    if (localObject != null)
    {
      ((ARTextureRender)localObject).a();
      this.jdField_a_of_type_ComTencentMobileqqArARRecordRendererARTextureRender = null;
    }
    int k = this.jdField_a_of_type_Int;
    if (k > 0)
    {
      GLES20.glDeleteTextures(0, new int[] { k }, 0);
      this.jdField_a_of_type_Int = 0;
      this.jdField_a_of_type_ArrayOfFloat = null;
      this.jdField_b_of_type_ArrayOfFloat = null;
    }
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    VideoRecordController.RecordListener localRecordListener;
    switch (paramMessage.what)
    {
    default: 
      return true;
    case 105: 
      localRecordListener = this.jdField_a_of_type_ComTencentMobileqqArARRecordVideoRecordController$RecordListener;
      if ((localRecordListener != null) && (!this.jdField_b_of_type_Boolean))
      {
        localRecordListener.c(paramMessage.arg1);
        return true;
      }
      break;
    case 104: 
      localRecordListener = this.jdField_a_of_type_ComTencentMobileqqArARRecordVideoRecordController$RecordListener;
      if ((localRecordListener != null) && (!this.jdField_b_of_type_Boolean))
      {
        localRecordListener.a(paramMessage.arg1, (String)paramMessage.obj);
        return true;
      }
      break;
    case 103: 
      localRecordListener = this.jdField_a_of_type_ComTencentMobileqqArARRecordVideoRecordController$RecordListener;
      if ((localRecordListener != null) && (!this.jdField_b_of_type_Boolean))
      {
        localRecordListener.a(paramMessage.arg1, paramMessage.arg2);
        return true;
      }
      break;
    case 102: 
      paramMessage = this.jdField_a_of_type_ComTencentMobileqqArARRecordVideoRecordController$RecordListener;
      if ((paramMessage != null) && (!this.jdField_b_of_type_Boolean))
      {
        paramMessage.h();
        return true;
      }
      break;
    case 101: 
      g();
      return true;
    case 100: 
      if (this.jdField_b_of_type_Boolean)
      {
        this.d = true;
        d();
      }
      break;
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.ar.ARRecord.VideoRecordController
 * JD-Core Version:    0.7.0.1
 */