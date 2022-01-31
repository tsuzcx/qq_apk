import android.annotation.TargetApi;
import android.media.MediaFormat;
import android.opengl.EGL14;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.support.annotation.NonNull;
import com.tencent.qphone.base.util.QLog;

@TargetApi(18)
public class axrn
{
  private HandlerThread jdField_a_of_type_AndroidOsHandlerThread = new HandlerThread("recode_thread");
  private axqz jdField_a_of_type_Axqz;
  private axra jdField_a_of_type_Axra;
  private axrb jdField_a_of_type_Axrb;
  private axrl jdField_a_of_type_Axrl;
  private axrm jdField_a_of_type_Axrm;
  protected axrp a;
  private axrr jdField_a_of_type_Axrr;
  private String jdField_a_of_type_JavaLangString;
  private volatile boolean jdField_a_of_type_Boolean;
  private boolean b;
  private boolean c;
  private boolean d;
  
  public axrn()
  {
    this.jdField_a_of_type_AndroidOsHandlerThread.start();
    this.jdField_a_of_type_Axrp = a(this.jdField_a_of_type_AndroidOsHandlerThread.getLooper());
    this.jdField_a_of_type_Axrb = new axrb();
    this.jdField_a_of_type_Axra = new axra();
    this.jdField_a_of_type_Axrr = new axrr();
  }
  
  private void a(axrq paramaxrq)
  {
    this.jdField_a_of_type_Axrl = paramaxrq.jdField_a_of_type_Axrl;
    this.jdField_a_of_type_Axrm = paramaxrq.jdField_a_of_type_Axrm;
    paramaxrq = paramaxrq.jdField_a_of_type_Axqz;
    if (QLog.isColorLevel()) {
      QLog.w("HWVideoRecorder", 2, "handleStartRecording EGLContext = " + paramaxrq.a());
    }
    if (this.jdField_a_of_type_Boolean) {
      d();
    }
    this.jdField_a_of_type_Boolean = true;
    this.jdField_a_of_type_Axqz = paramaxrq;
    this.jdField_a_of_type_JavaLangString = paramaxrq.jdField_a_of_type_JavaLangString;
    try
    {
      this.jdField_a_of_type_Axrb.a(paramaxrq);
      this.jdField_a_of_type_Axra.a(paramaxrq, this.jdField_a_of_type_Axrb.a());
      if (this.jdField_a_of_type_Axrl != null) {
        this.jdField_a_of_type_Axrl.a();
      }
      this.b = true;
      this.c = false;
      return;
    }
    catch (Throwable localThrowable)
    {
      localThrowable.printStackTrace();
      if (QLog.isColorLevel()) {
        QLog.w("HWVideoRecorder", 2, "handleStartRecording: exception at start. encodeConfig = " + paramaxrq, localThrowable);
      }
      if (this.jdField_a_of_type_Axrl != null) {
        this.jdField_a_of_type_Axrl.a_(1, localThrowable);
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
        this.jdField_a_of_type_Axrb.b();
        if (QLog.isColorLevel()) {
          QLog.w("HWVideoRecorder", 2, "handleStopRecording complete");
        }
        if ((this.jdField_a_of_type_Axrl != null) && (this.jdField_a_of_type_Axqz.jdField_a_of_type_Axrs == null))
        {
          this.jdField_a_of_type_Axrl.a(this.jdField_a_of_type_JavaLangString);
          this.jdField_a_of_type_Axrl = null;
        }
        this.jdField_a_of_type_Axra.a();
        this.jdField_a_of_type_Axrm = null;
        return;
      }
      catch (Exception localException)
      {
        if (QLog.isColorLevel()) {
          QLog.e("HWVideoRecorder", 2, "handleStopRecording: exception. config = " + this.jdField_a_of_type_Axqz);
        }
        if (this.jdField_a_of_type_Axrl != null) {
          this.jdField_a_of_type_Axrl.a_(2, localException);
        }
        this.jdField_a_of_type_Axrb.c();
        this.jdField_a_of_type_Axra.a();
        return;
      }
    }
    QLog.w("HWVideoRecorder", 2, "handleStopRecording: is not recording.");
  }
  
  public MediaFormat a()
  {
    if (this.jdField_a_of_type_Axrb != null) {
      return this.jdField_a_of_type_Axrb.a;
    }
    return null;
  }
  
  @NonNull
  protected axrp a(Looper paramLooper)
  {
    return new axrp(this, paramLooper, this);
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
    for (boolean bool = this.jdField_a_of_type_Axrr.a(paramInt2);; bool = false)
    {
      if ((!this.d) || (bool))
      {
        Message localMessage = Message.obtain();
        localMessage.what = 2;
        localMessage.obj = new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramArrayOfFloat1, paramArrayOfFloat2, Long.valueOf(paramLong) };
        this.jdField_a_of_type_Axrp.sendMessage(localMessage);
      }
      return;
      this.jdField_a_of_type_Axrp.removeMessages(2);
    }
  }
  
  public void a(axqz paramaxqz, axrl paramaxrl)
  {
    a(paramaxqz, paramaxrl, null);
  }
  
  public void a(axqz paramaxqz, axrl paramaxrl, axrm paramaxrm)
  {
    if (QLog.isColorLevel()) {
      QLog.w("HWVideoRecorder", 2, "startRecording EGLContext = " + paramaxqz.a());
    }
    if (this.d) {
      this.jdField_a_of_type_Axrr.a(paramaxqz.jdField_a_of_type_Int, paramaxqz.b);
    }
    Message localMessage = Message.obtain();
    axrq localaxrq = new axrq(this, null);
    localaxrq.jdField_a_of_type_Axrl = paramaxrl;
    localaxrq.jdField_a_of_type_Axrm = paramaxrm;
    localaxrq.jdField_a_of_type_Axqz = paramaxqz;
    localMessage.obj = localaxrq;
    localMessage.what = 0;
    this.jdField_a_of_type_Axrp.sendMessage(localMessage);
  }
  
  public boolean a()
  {
    return !this.jdField_a_of_type_Boolean;
  }
  
  public void b()
  {
    if (this.d) {
      this.jdField_a_of_type_Axrr.a();
    }
    Message localMessage = Message.obtain();
    localMessage.what = 1;
    this.jdField_a_of_type_Axrp.sendMessage(localMessage);
  }
  
  public void b(int paramInt1, int paramInt2, float[] paramArrayOfFloat1, float[] paramArrayOfFloat2, long paramLong)
  {
    if (QLog.isColorLevel()) {
      QLog.d("HWVideoRecorder", 2, "handleFrameAvailable timestampNanos = " + paramLong + " ; textureId = " + paramInt2 + " ; EGLContext = " + this.jdField_a_of_type_Axqz.a());
    }
    if (!this.jdField_a_of_type_Boolean) {
      if (QLog.isColorLevel()) {
        QLog.d("HWVideoRecorder", 2, "handleFrameAvailable mIsRecording = " + this.jdField_a_of_type_Boolean);
      }
    }
    label304:
    do
    {
      return;
      for (;;)
      {
        try
        {
          this.jdField_a_of_type_Axrb.a();
          if ((this.b) && (this.jdField_a_of_type_Axqz.jdField_a_of_type_Boolean))
          {
            this.b = false;
            axsi.a(paramInt2, this.jdField_a_of_type_Axqz.jdField_a_of_type_Int, this.jdField_a_of_type_Axqz.b, this.jdField_a_of_type_Axqz, new axro(this));
          }
          if (this.d)
          {
            paramInt2 = this.jdField_a_of_type_Axrr.a();
            if (paramInt2 == -1) {
              break label304;
            }
            this.jdField_a_of_type_Axra.a(paramInt1, paramInt2, paramArrayOfFloat1, paramArrayOfFloat2, paramLong);
            if (this.d) {
              this.jdField_a_of_type_Axrr.a(false, 1);
            }
            if (this.jdField_a_of_type_Axrl == null) {
              break;
            }
            this.jdField_a_of_type_Axrl.b();
            return;
          }
        }
        catch (Exception paramArrayOfFloat1)
        {
          if (QLog.isColorLevel()) {
            QLog.e("HWVideoRecorder", 2, "frameAvailable: exception. config = " + this.jdField_a_of_type_Axqz, paramArrayOfFloat1);
          }
          if (this.jdField_a_of_type_Axrl != null) {
            this.jdField_a_of_type_Axrl.a_(2, paramArrayOfFloat1);
          }
          this.jdField_a_of_type_Axrb.c();
          this.jdField_a_of_type_Axra.a();
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
    this.jdField_a_of_type_Axrl = null;
    this.jdField_a_of_type_Axrm = null;
    this.jdField_a_of_type_Axqz = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     axrn
 * JD-Core Version:    0.7.0.1
 */