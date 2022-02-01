import android.annotation.TargetApi;
import android.media.MediaFormat;
import android.opengl.EGL14;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.support.annotation.NonNull;
import com.tencent.qphone.base.util.QLog;

@TargetApi(18)
public class bbmq
{
  private HandlerThread jdField_a_of_type_AndroidOsHandlerThread = new HandlerThread("recode_thread");
  private bbmc jdField_a_of_type_Bbmc;
  private bbmd jdField_a_of_type_Bbmd;
  private bbme jdField_a_of_type_Bbme;
  private bbmo jdField_a_of_type_Bbmo;
  private bbmp jdField_a_of_type_Bbmp;
  protected bbms a;
  private bbmu jdField_a_of_type_Bbmu;
  private String jdField_a_of_type_JavaLangString;
  private volatile boolean jdField_a_of_type_Boolean;
  private boolean b;
  private boolean c;
  private boolean d;
  
  public bbmq()
  {
    this.jdField_a_of_type_AndroidOsHandlerThread.start();
    this.jdField_a_of_type_Bbms = a(this.jdField_a_of_type_AndroidOsHandlerThread.getLooper());
    this.jdField_a_of_type_Bbme = new bbme();
    this.jdField_a_of_type_Bbmd = new bbmd();
    this.jdField_a_of_type_Bbmu = new bbmu();
  }
  
  private void a(bbmt parambbmt)
  {
    this.jdField_a_of_type_Bbmo = parambbmt.jdField_a_of_type_Bbmo;
    this.jdField_a_of_type_Bbmp = parambbmt.jdField_a_of_type_Bbmp;
    parambbmt = parambbmt.jdField_a_of_type_Bbmc;
    if (QLog.isColorLevel()) {
      QLog.w("HWVideoRecorder", 2, "handleStartRecording EGLContext = " + parambbmt.a());
    }
    if (this.jdField_a_of_type_Boolean) {
      d();
    }
    this.jdField_a_of_type_Boolean = true;
    this.jdField_a_of_type_Bbmc = parambbmt;
    this.jdField_a_of_type_JavaLangString = parambbmt.jdField_a_of_type_JavaLangString;
    try
    {
      this.jdField_a_of_type_Bbme.a(parambbmt);
      this.jdField_a_of_type_Bbmd.a(parambbmt, this.jdField_a_of_type_Bbme.a());
      if (this.jdField_a_of_type_Bbmo != null) {
        this.jdField_a_of_type_Bbmo.a();
      }
      this.b = true;
      this.c = false;
      return;
    }
    catch (Throwable localThrowable)
    {
      localThrowable.printStackTrace();
      if (QLog.isColorLevel()) {
        QLog.w("HWVideoRecorder", 2, "handleStartRecording: exception at start. encodeConfig = " + parambbmt, localThrowable);
      }
      if (this.jdField_a_of_type_Bbmo != null) {
        this.jdField_a_of_type_Bbmo.a_(1, localThrowable);
      }
      this.jdField_a_of_type_Boolean = false;
    }
  }
  
  private void d()
  {
    if (QLog.isColorLevel()) {
      QLog.w("HWVideoRecorder", 2, "handleStopRecording");
    }
    if (this.jdField_a_of_type_Boolean) {
      this.jdField_a_of_type_Boolean = false;
    }
    while (!QLog.isColorLevel()) {
      try
      {
        this.jdField_a_of_type_Bbme.b();
        if (QLog.isColorLevel()) {
          QLog.w("HWVideoRecorder", 2, "handleStopRecording complete");
        }
        if ((this.jdField_a_of_type_Bbmo != null) && (this.jdField_a_of_type_Bbmc != null) && (this.jdField_a_of_type_Bbmc.jdField_a_of_type_Bbmv == null))
        {
          this.jdField_a_of_type_Bbmo.a(this.jdField_a_of_type_JavaLangString);
          this.jdField_a_of_type_Bbmo = null;
        }
        this.jdField_a_of_type_Bbmd.a();
        this.jdField_a_of_type_Bbmp = null;
        return;
      }
      catch (Exception localException)
      {
        if (QLog.isColorLevel()) {
          QLog.e("HWVideoRecorder", 2, "handleStopRecording: exception. config = " + this.jdField_a_of_type_Bbmc);
        }
        if (this.jdField_a_of_type_Bbmo != null) {
          this.jdField_a_of_type_Bbmo.a_(2, localException);
        }
        this.jdField_a_of_type_Bbme.c();
        this.jdField_a_of_type_Bbmd.a();
        return;
      }
    }
    QLog.w("HWVideoRecorder", 2, "handleStopRecording: is not recording.");
  }
  
  public MediaFormat a()
  {
    if (this.jdField_a_of_type_Bbme != null) {
      return this.jdField_a_of_type_Bbme.a;
    }
    return null;
  }
  
  @NonNull
  protected bbms a(Looper paramLooper)
  {
    return new bbms(this, paramLooper, this);
  }
  
  public void a()
  {
    this.d = true;
  }
  
  public void a(int paramInt1, int paramInt2, float[] paramArrayOfFloat1, float[] paramArrayOfFloat2, long paramLong)
  {
    if (QLog.isColorLevel()) {
      QLog.d("HWVideoRecorder", 2, "frameAvailable timestampNanos = " + paramLong + " ; textureId = " + paramInt2 + " ; EGLContext = " + EGL14.eglGetCurrentContext());
    }
    if (this.d) {}
    for (boolean bool = this.jdField_a_of_type_Bbmu.a(paramInt2);; bool = false)
    {
      if ((!this.d) || (bool))
      {
        Message localMessage = Message.obtain();
        localMessage.what = 2;
        localMessage.obj = new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramArrayOfFloat1, paramArrayOfFloat2, Long.valueOf(paramLong) };
        this.jdField_a_of_type_Bbms.sendMessage(localMessage);
      }
      return;
      this.jdField_a_of_type_Bbms.removeMessages(2);
    }
  }
  
  public void a(bbmc parambbmc, bbmo parambbmo)
  {
    a(parambbmc, parambbmo, null);
  }
  
  public void a(bbmc parambbmc, bbmo parambbmo, bbmp parambbmp)
  {
    if (QLog.isColorLevel()) {
      QLog.w("HWVideoRecorder", 2, "startRecording EGLContext = " + parambbmc.a());
    }
    if (this.d) {
      this.jdField_a_of_type_Bbmu.a(parambbmc.jdField_a_of_type_Int, parambbmc.b);
    }
    Message localMessage = Message.obtain();
    bbmt localbbmt = new bbmt(this, null);
    localbbmt.jdField_a_of_type_Bbmo = parambbmo;
    localbbmt.jdField_a_of_type_Bbmp = parambbmp;
    localbbmt.jdField_a_of_type_Bbmc = parambbmc;
    localMessage.obj = localbbmt;
    localMessage.what = 0;
    this.jdField_a_of_type_Bbms.sendMessage(localMessage);
  }
  
  public boolean a()
  {
    return !this.jdField_a_of_type_Boolean;
  }
  
  public void b()
  {
    if (this.d) {
      this.jdField_a_of_type_Bbmu.a();
    }
    Message localMessage = Message.obtain();
    localMessage.what = 1;
    this.jdField_a_of_type_Bbms.sendMessage(localMessage);
  }
  
  public void b(int paramInt1, int paramInt2, float[] paramArrayOfFloat1, float[] paramArrayOfFloat2, long paramLong)
  {
    if (this.jdField_a_of_type_Bbmc == null) {
      QLog.d("HWVideoRecorder", 1, "handleFrameAvailable fail, encodeConfig null");
    }
    label324:
    do
    {
      do
      {
        return;
        if (QLog.isColorLevel()) {
          QLog.d("HWVideoRecorder", 2, new Object[] { "handleFrameAvailable timestampNanos = ", Long.valueOf(paramLong), "; textureId = ", Integer.valueOf(paramInt2), "; EGLContext = ", this.jdField_a_of_type_Bbmc.a() });
        }
        if (this.jdField_a_of_type_Boolean) {
          break;
        }
      } while (!QLog.isColorLevel());
      QLog.d("HWVideoRecorder", 2, "handleFrameAvailable mIsRecording = " + this.jdField_a_of_type_Boolean);
      return;
      for (;;)
      {
        try
        {
          this.jdField_a_of_type_Bbme.a();
          if ((this.b) && (this.jdField_a_of_type_Bbmc.jdField_a_of_type_Boolean))
          {
            this.b = false;
            bbnl.a(paramInt2, this.jdField_a_of_type_Bbmc.jdField_a_of_type_Int, this.jdField_a_of_type_Bbmc.b, this.jdField_a_of_type_Bbmc, new bbmr(this));
          }
          if (this.d)
          {
            paramInt2 = this.jdField_a_of_type_Bbmu.a();
            if (paramInt2 == -1) {
              break label324;
            }
            this.jdField_a_of_type_Bbmd.a(paramInt1, paramInt2, paramArrayOfFloat1, paramArrayOfFloat2, paramLong);
            if (this.d) {
              this.jdField_a_of_type_Bbmu.a(false, 1);
            }
            if (this.jdField_a_of_type_Bbmo == null) {
              break;
            }
            this.jdField_a_of_type_Bbmo.b();
            return;
          }
        }
        catch (Exception paramArrayOfFloat1)
        {
          if (QLog.isColorLevel()) {
            QLog.e("HWVideoRecorder", 2, "frameAvailable: exception. config = " + this.jdField_a_of_type_Bbmc, paramArrayOfFloat1);
          }
          if (this.jdField_a_of_type_Bbmo != null) {
            this.jdField_a_of_type_Bbmo.a_(2, paramArrayOfFloat1);
          }
          this.jdField_a_of_type_Bbme.c();
          this.jdField_a_of_type_Bbmd.a();
          this.jdField_a_of_type_Boolean = false;
          return;
        }
      }
    } while (!QLog.isColorLevel());
    QLog.d("HWVideoRecorder", 2, new Object[] { "ignore frame: ", Long.valueOf(paramLong) });
  }
  
  public void c()
  {
    if (this.jdField_a_of_type_AndroidOsHandlerThread != null)
    {
      this.jdField_a_of_type_AndroidOsHandlerThread.quitSafely();
      this.jdField_a_of_type_AndroidOsHandlerThread = null;
    }
    this.jdField_a_of_type_Bbmo = null;
    this.jdField_a_of_type_Bbmp = null;
    this.jdField_a_of_type_Bbmc = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bbmq
 * JD-Core Version:    0.7.0.1
 */