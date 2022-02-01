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
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.videocodec.mediacodec.encoder.EglCore;
import com.tencent.mobileqq.videocodec.mediacodec.encoder.EncodeConfig;
import com.tencent.qphone.base.util.QLog;
import com.tencent.ttpic.openapi.filter.TextureRender;
import java.io.File;

public class VideoRecordController
  implements Handler.Callback, ARVideoRecordDataSource, VideoEncoder.VideoEncoderCallback
{
  private static final Object a = new Object();
  private boolean A = false;
  private boolean B = true;
  private boolean C;
  private long D;
  private String E;
  private Context b;
  private Handler c;
  private VideoRecordController.RecordListener d;
  private VideoEncoder e;
  private Surface f;
  private VideoEncoderWindowSurface g;
  private TextureRender h;
  private ARTextureRender i;
  private int j;
  private int k = -1;
  private float[] l;
  private float[] m;
  private long n;
  private AudioRecordController o;
  private File p;
  private EncodeConfig q;
  private int r = 0;
  private boolean s;
  private boolean t;
  private boolean u;
  private long v;
  private boolean w;
  private boolean x;
  private boolean y;
  private boolean z;
  
  public VideoRecordController(Context paramContext)
  {
    QLog.d("VideoRecordController", 2, "VideoRecordController");
    this.b = paramContext;
    this.c = new Handler(this);
  }
  
  private void a(int paramInt1, int paramInt2)
  {
    QLog.d("VideoRecordController", 2, String.format("loadWaterMarkTexture screenWidth=%s screenHeight=%s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) }));
    if (this.k == -1) {
      this.k = 2130838731;
    }
    Object localObject = null;
    try
    {
      Bitmap localBitmap = BitmapFactory.decodeResource(this.b.getResources(), this.k);
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
      int i1 = arrayOfInt[0];
      if (i1 > 0)
      {
        GLES20.glBindTexture(3553, i1);
        GLES20.glTexParameterf(3553, 10241, 9729.0F);
        GLES20.glTexParameterf(3553, 10240, 9729.0F);
        GLES20.glTexParameterf(3553, 10242, 33071.0F);
        GLES20.glTexParameterf(3553, 10243, 33071.0F);
        GLUtils.texImage2D(3553, 0, localObject, 0);
        this.j = i1;
        i1 = localObject.getWidth();
        int i2 = localObject.getHeight();
        float f1 = i1;
        float f2 = paramInt1;
        f1 /= f2;
        float f4 = i2;
        float f3 = paramInt2;
        f4 /= f3;
        f2 = (paramInt1 - i1 - 40) / f2;
        f3 = (paramInt2 - i2 - 28) / f3;
        this.l = new float[16];
        Matrix.setIdentityM(this.l, 0);
        Matrix.translateM(this.l, 0, 0.0F, 0.5F, 0.0F);
        Matrix.rotateM(this.l, 0, 180.0F, 1.0F, 0.0F, 0.0F);
        Matrix.translateM(this.l, 0, 0.0F, -0.5F, 0.0F);
        this.m = new float[16];
        Matrix.setIdentityM(this.m, 0);
        Matrix.translateM(this.m, 0, -f2, -f3, 0.0F);
        Matrix.scaleM(this.m, 0, f1, f4, 1.0F);
      }
    }
  }
  
  private void a(int paramInt, long paramLong, String paramString)
  {
    QLog.d("VideoRecordController", 2, String.format("notifyRecordFinish finishType=%s", new Object[] { Integer.valueOf(paramInt) }));
    Object localObject = this.c;
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
    if (!this.x)
    {
      int i2 = 1;
      this.x = true;
      int i1 = paramInt;
      if (paramInt == 2)
      {
        if (System.currentTimeMillis() - this.v >= 1000L) {
          i2 = 0;
        }
        i1 = paramInt;
        if (i2 != 0) {
          i1 = 11;
        }
      }
      if (!this.t) {
        c(i1);
      }
      h();
    }
  }
  
  private void c(int paramInt)
  {
    QLog.d("VideoRecordController", 2, String.format("notifyRecordError errorType=%s", new Object[] { Integer.valueOf(paramInt) }));
    Object localObject = this.c;
    if (localObject != null)
    {
      localObject = ((Handler)localObject).obtainMessage(105);
      ((Message)localObject).arg1 = paramInt;
      ((Message)localObject).sendToTarget();
      ARRecordReport.a().a(paramInt);
    }
  }
  
  private boolean g()
  {
    int i1 = this.r;
    boolean bool = false;
    QLog.d("VideoRecordController", 2, String.format("startRecord mState=%s mIsRecording=%s", new Object[] { Integer.valueOf(i1), Boolean.valueOf(this.s) }));
    synchronized (a)
    {
      if (!this.s)
      {
        this.s = true;
        this.C = false;
        this.u = false;
        this.r = 1;
        this.w = false;
        this.x = false;
        this.y = false;
        this.z = false;
        this.D = 0L;
        bool = true;
      }
      return bool;
    }
  }
  
  private boolean h()
  {
    int i1 = this.r;
    boolean bool = false;
    QLog.d("VideoRecordController", 2, String.format("stopRecord mState=%s mIsRecording=%s mNotSaveRecordFile=%s mHaveErrorHappened=%s mHaveMaxRecord=%s mHaveSDCardFull=%s", new Object[] { Integer.valueOf(i1), Boolean.valueOf(this.s), Boolean.valueOf(this.w), Boolean.valueOf(this.x), Boolean.valueOf(this.y), Boolean.valueOf(this.z) }));
    synchronized (a)
    {
      if (this.s)
      {
        if (this.o != null)
        {
          this.o.c();
          this.o = null;
          this.E = null;
        }
        if (this.e != null)
        {
          this.e.b();
          this.r = 4;
          this.e = null;
        }
        else if (this.r == 1)
        {
          QLog.e("VideoRecordController", 1, "stopRecord VideoEncoder is starting.");
          if (!this.t) {
            c(11);
          }
          this.s = false;
          this.r = 0;
        }
        if (this.f != null)
        {
          this.f.release();
          this.f = null;
        }
        this.u = false;
        bool = true;
      }
      return bool;
    }
  }
  
  private File i()
  {
    Object localObject2 = null;
    Object localObject3 = null;
    Object localObject1;
    try
    {
      File localFile = new File(VideoEncoderUtils.c());
      localObject1 = localObject2;
      if (this.p != null)
      {
        localObject1 = localObject2;
        if (this.p.exists())
        {
          boolean bool = FileUtils.copyFile(this.p, localFile);
          localObject1 = localObject2;
          if (bool)
          {
            try
            {
              j();
              return localFile;
            }
            catch (Exception localException1)
            {
              localObject1 = localFile;
            }
            QLog.e("VideoRecordController", 1, "renameTempVideoFile fail.", localException2);
          }
        }
      }
    }
    catch (Exception localException2)
    {
      localObject1 = localObject3;
    }
    return localObject1;
  }
  
  private void j()
  {
    File localFile = this.p;
    if ((localFile != null) && (localFile.exists())) {
      this.p.delete();
    }
  }
  
  private void k()
  {
    QLog.d("VideoRecordController", 2, "notifyRecordStart");
    Handler localHandler = this.c;
    if (localHandler != null) {
      localHandler.sendEmptyMessage(102);
    }
  }
  
  private void l()
  {
    long l1 = System.currentTimeMillis();
    long l2 = this.v;
    long l3 = this.D;
    long l4 = FileSwapHelper.a();
    if (l1 - l2 - l3 >= 60000L)
    {
      this.y = true;
      h();
      return;
    }
    if (l4 <= 5242880L)
    {
      this.z = true;
      h();
      return;
    }
    m();
  }
  
  private void m()
  {
    Object localObject = this.c;
    if (localObject != null)
    {
      ((Handler)localObject).removeMessages(103);
      this.c.sendEmptyMessageDelayed(101, 1000L);
      localObject = this.c.obtainMessage(103);
      ((Message)localObject).arg1 = ((int)(System.currentTimeMillis() - this.v));
      File localFile = this.p;
      long l1;
      if (localFile != null) {
        l1 = localFile.length();
      } else {
        l1 = 0L;
      }
      ((Message)localObject).arg2 = ((int)l1);
      ((Message)localObject).sendToTarget();
    }
  }
  
  public void a(int paramInt)
  {
    QLog.d("VideoRecordController", 2, String.format("onEncodeError errorCode=%s", new Object[] { Integer.valueOf(paramInt) }));
    b(paramInt);
    synchronized (a)
    {
      this.s = false;
      this.t = false;
      this.r = 0;
      return;
    }
  }
  
  public void a(int paramInt1, int paramInt2, float[] paramArrayOfFloat1, float[] paramArrayOfFloat2, long paramLong)
  {
    synchronized (a)
    {
      long l1 = System.currentTimeMillis();
      if (l1 - this.n < 33L) {
        return;
      }
      this.n = l1;
      if ((this.u) && (this.s) && (this.e != null) && (!this.C))
      {
        l1 = this.D;
        paramLong -= l1;
        try
        {
          this.g.b();
          GLES20.glViewport(0, 0, this.q.c, this.q.d);
          GLES20.glClearColor(0.0F, 0.0F, 0.0F, 1.0F);
          GLES20.glClear(16640);
          GLES20.glDepthMask(false);
          GLES20.glDisable(2929);
          this.h.drawTexture(paramInt1, paramInt2, paramArrayOfFloat1, paramArrayOfFloat2);
          if (this.B)
          {
            GLES20.glEnable(3042);
            GLES20.glBlendFunc(1, 771);
            this.i.a(3553, this.j, this.l, this.m);
            GLES20.glDisable(3042);
          }
          this.g.a(paramLong);
          this.g.c();
          this.g.a();
          this.e.a(paramLong);
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
    this.d = paramRecordListener;
  }
  
  public void a(EglCore paramEglCore, int paramInt1, int paramInt2)
  {
    QLog.d("VideoRecordController", 2, String.format("doStartRecord mState=%s mIsRecording=%s", new Object[] { Integer.valueOf(this.r), Boolean.valueOf(this.s) }));
    for (;;)
    {
      synchronized (a)
      {
        boolean bool = this.s;
        if (bool) {
          try
          {
            String str = VideoEncoderUtils.b();
            this.p = new File(str);
            float f1 = 540 / paramInt1;
            paramInt2 = (int)(paramInt2 * f1) / 16;
            if (!Build.MODEL.equalsIgnoreCase("CAM-TL00")) {
              break label321;
            }
            paramInt1 = 1024000;
            this.q = new EncodeConfig(str, 540, paramInt2 * 16, paramInt1, 1, false, 0);
            this.q.a(EGL14.eglGetCurrentContext());
            this.e = new VideoEncoder();
            this.e.a(this.q, this);
            this.f = this.e.a();
            this.g = new VideoEncoderWindowSurface(paramEglCore, this.f);
            this.h = new TextureRender();
            this.i = new ARTextureRender();
            a(this.q.c, this.q.d);
            if (FileUtil.d(this.E)) {
              this.o = new PcmRecordController(this, this.E);
            } else {
              this.o = new MicRecordController(this);
            }
            this.o.b();
            k();
            this.r = 2;
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
    synchronized (a)
    {
      long l1 = this.D;
      if ((this.s) && (this.e != null) && (!this.C))
      {
        this.e.a(paramArrayOfByte, paramLong - l1);
        this.u = true;
      }
      return;
    }
  }
  
  public boolean a()
  {
    for (;;)
    {
      synchronized (a)
      {
        if ((this.s) && (!this.t))
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
    if (!ScanEntranceDPC.a().g)
    {
      QLog.w("VideoRecordController", 2, "startVideoRecord record is disable.");
      return false;
    }
    int i1 = this.r;
    boolean bool = true;
    QLog.d("VideoRecordController", 2, String.format("startVideoRecord userOperation=%s mState=%s mIsRecording=%s mIsPreRecord=%s, audioPath=%s", new Object[] { Boolean.valueOf(paramBoolean), Integer.valueOf(i1), Boolean.valueOf(this.s), Boolean.valueOf(this.t), paramString }));
    synchronized (a)
    {
      if (this.r == 4)
      {
        QLog.e("VideoRecordController", 1, "startVideoRecord VideoEncoder is stopping.");
        return false;
      }
      this.E = paramString;
      if (!paramBoolean)
      {
        if ((!this.t) && (g()))
        {
          this.t = true;
          paramString = this.c;
          if (paramString != null) {
            paramString.sendEmptyMessageDelayed(100, 4000L);
          }
          ARRecordReport.a().b();
          return true;
        }
      }
      else
      {
        if (this.t)
        {
          this.t = false;
          this.v = System.currentTimeMillis();
          k();
          m();
          ARRecordReport.a().a(true);
          return true;
        }
        if (g())
        {
          this.v = System.currentTimeMillis();
          l();
          ARRecordReport.a().a(false);
          paramString = this.c;
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
    boolean bool2 = ScanEntranceDPC.a().g;
    boolean bool1 = false;
    if (!bool2)
    {
      QLog.w("VideoRecordController", 2, "stopVideoRecord record is disable.");
      return false;
    }
    if (this.r == 4)
    {
      QLog.w("VideoRecordController", 2, "stopVideoRecord state == stopping");
      return false;
    }
    QLog.d("VideoRecordController", 2, String.format("stopVideoRecord userOperation=%s saveRecord=%s mState=%s mIsPreRecord=%s", new Object[] { Boolean.valueOf(paramBoolean1), Boolean.valueOf(paramBoolean2), Integer.valueOf(this.r), Boolean.valueOf(this.t) }));
    if ((!this.t) && ((paramBoolean1) || (paramBoolean2))) {
      paramBoolean1 = false;
    } else {
      paramBoolean1 = true;
    }
    this.w = paramBoolean1;
    paramBoolean1 = bool1;
    if (h())
    {
      Handler localHandler = this.c;
      if (localHandler != null)
      {
        localHandler.removeMessages(100);
        this.c.removeMessages(101);
      }
      paramBoolean1 = true;
    }
    return paramBoolean1;
  }
  
  public boolean b()
  {
    return this.s;
  }
  
  public void c()
  {
    QLog.d("VideoRecordController", 2, "onEncodeStart");
  }
  
  public void d()
  {
    QLog.d("VideoRecordController", 2, "onEncodeRealStart");
  }
  
  public void e()
  {
    QLog.d("VideoRecordController", 2, "onEncodeFinish");
    if (this.x)
    {
      QLog.w("VideoRecordController", 1, "onEncodeFinish error happened, delete temp file.");
      j();
    }
    else
    {
      long l1 = System.currentTimeMillis() - this.v;
      int i1;
      if (l1 < 1000L) {
        i1 = 1;
      } else {
        i1 = 0;
      }
      if ((!this.w) && (i1 == 0))
      {
        ??? = i();
        if ((??? != null) && (((File)???).exists()))
        {
          String str = ((File)???).getAbsolutePath();
          if (!this.A) {
            ARRecordUtils.a((File)???);
          }
          QLog.d("VideoRecordController", 2, String.format("onEncodeFinish filePath=%s", new Object[] { str }));
          if (this.y) {
            a(1, l1, str);
          } else if (this.z) {
            a(2, l1, str);
          } else {
            a(0, l1, str);
          }
        }
        else
        {
          QLog.e("VideoRecordController", 1, "onEncodeFinish rename file fail, delete temp file.");
          j();
          b(12);
        }
      }
      else
      {
        QLog.w("VideoRecordController", 1, "onEncodeFinish not valid record, delete temp file.");
        j();
        if (i1 != 0) {
          b(11);
        }
      }
    }
    synchronized (a)
    {
      this.s = false;
      this.t = false;
      this.r = 0;
      return;
    }
  }
  
  public void f()
  {
    QLog.d("VideoRecordController", 2, "releaseGLResource");
    Object localObject = this.g;
    if (localObject != null)
    {
      ((VideoEncoderWindowSurface)localObject).d();
      this.g = null;
    }
    localObject = this.h;
    if (localObject != null)
    {
      ((TextureRender)localObject).release();
      this.h = null;
    }
    localObject = this.i;
    if (localObject != null)
    {
      ((ARTextureRender)localObject).a();
      this.i = null;
    }
    int i1 = this.j;
    if (i1 > 0)
    {
      GLES20.glDeleteTextures(0, new int[] { i1 }, 0);
      this.j = 0;
      this.l = null;
      this.m = null;
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
      localRecordListener = this.d;
      if ((localRecordListener != null) && (!this.t))
      {
        localRecordListener.c(paramMessage.arg1);
        return true;
      }
      break;
    case 104: 
      localRecordListener = this.d;
      if ((localRecordListener != null) && (!this.t))
      {
        localRecordListener.a(paramMessage.arg1, (String)paramMessage.obj);
        return true;
      }
      break;
    case 103: 
      localRecordListener = this.d;
      if ((localRecordListener != null) && (!this.t))
      {
        localRecordListener.a(paramMessage.arg1, paramMessage.arg2);
        return true;
      }
      break;
    case 102: 
      paramMessage = this.d;
      if ((paramMessage != null) && (!this.t))
      {
        paramMessage.l();
        return true;
      }
      break;
    case 101: 
      l();
      return true;
    case 100: 
      if (this.t)
      {
        this.w = true;
        h();
      }
      break;
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ar.ARRecord.VideoRecordController
 * JD-Core Version:    0.7.0.1
 */