import android.annotation.TargetApi;
import android.media.MediaFormat;
import android.opengl.EGL14;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.support.annotation.NonNull;
import com.tencent.qphone.base.util.QLog;

@TargetApi(18)
public class avzm
{
  private HandlerThread jdField_a_of_type_AndroidOsHandlerThread = new HandlerThread("recode_thread");
  private avyy jdField_a_of_type_Avyy;
  private avyz jdField_a_of_type_Avyz;
  private avza jdField_a_of_type_Avza;
  private avzk jdField_a_of_type_Avzk;
  private avzl jdField_a_of_type_Avzl;
  protected avzo a;
  private avzq jdField_a_of_type_Avzq;
  private String jdField_a_of_type_JavaLangString;
  private volatile boolean jdField_a_of_type_Boolean;
  private boolean b;
  private boolean c;
  private boolean d;
  
  public avzm()
  {
    this.jdField_a_of_type_AndroidOsHandlerThread.start();
    this.jdField_a_of_type_Avzo = a(this.jdField_a_of_type_AndroidOsHandlerThread.getLooper());
    this.jdField_a_of_type_Avza = new avza();
    this.jdField_a_of_type_Avyz = new avyz();
    this.jdField_a_of_type_Avzq = new avzq();
  }
  
  private void a(avzp paramavzp)
  {
    this.jdField_a_of_type_Avzk = paramavzp.jdField_a_of_type_Avzk;
    this.jdField_a_of_type_Avzl = paramavzp.jdField_a_of_type_Avzl;
    paramavzp = paramavzp.jdField_a_of_type_Avyy;
    if (QLog.isColorLevel()) {
      QLog.w("HWVideoRecorder", 2, "handleStartRecording EGLContext = " + paramavzp.a());
    }
    if (this.jdField_a_of_type_Boolean) {
      d();
    }
    this.jdField_a_of_type_Boolean = true;
    this.jdField_a_of_type_Avyy = paramavzp;
    this.jdField_a_of_type_JavaLangString = paramavzp.jdField_a_of_type_JavaLangString;
    try
    {
      this.jdField_a_of_type_Avza.a(paramavzp);
      this.jdField_a_of_type_Avyz.a(paramavzp, this.jdField_a_of_type_Avza.a());
      if (this.jdField_a_of_type_Avzk != null) {
        this.jdField_a_of_type_Avzk.a();
      }
      this.b = true;
      this.c = false;
      return;
    }
    catch (Throwable localThrowable)
    {
      localThrowable.printStackTrace();
      if (QLog.isColorLevel()) {
        QLog.w("HWVideoRecorder", 2, "handleStartRecording: exception at start. encodeConfig = " + paramavzp, localThrowable);
      }
      if (this.jdField_a_of_type_Avzk != null) {
        this.jdField_a_of_type_Avzk.a_(1, localThrowable);
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
        this.jdField_a_of_type_Avza.b();
        if (QLog.isColorLevel()) {
          QLog.w("HWVideoRecorder", 2, "handleStopRecording complete");
        }
        if ((this.jdField_a_of_type_Avzk != null) && (this.jdField_a_of_type_Avyy.jdField_a_of_type_Avzr == null))
        {
          this.jdField_a_of_type_Avzk.a(this.jdField_a_of_type_JavaLangString);
          this.jdField_a_of_type_Avzk = null;
        }
        this.jdField_a_of_type_Avyz.a();
        this.jdField_a_of_type_Avzl = null;
        return;
      }
      catch (Exception localException)
      {
        if (QLog.isColorLevel()) {
          QLog.e("HWVideoRecorder", 2, "handleStopRecording: exception. config = " + this.jdField_a_of_type_Avyy);
        }
        if (this.jdField_a_of_type_Avzk != null) {
          this.jdField_a_of_type_Avzk.a_(2, localException);
        }
        this.jdField_a_of_type_Avza.c();
        this.jdField_a_of_type_Avyz.a();
        return;
      }
    }
    QLog.w("HWVideoRecorder", 2, "handleStopRecording: is not recording.");
  }
  
  public MediaFormat a()
  {
    if (this.jdField_a_of_type_Avza != null) {
      return this.jdField_a_of_type_Avza.a;
    }
    return null;
  }
  
  @NonNull
  protected avzo a(Looper paramLooper)
  {
    return new avzo(this, paramLooper, this);
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
    for (boolean bool = this.jdField_a_of_type_Avzq.a(paramInt2);; bool = false)
    {
      if ((!this.d) || (bool))
      {
        Message localMessage = Message.obtain();
        localMessage.what = 2;
        localMessage.obj = new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramArrayOfFloat1, paramArrayOfFloat2, Long.valueOf(paramLong) };
        this.jdField_a_of_type_Avzo.sendMessage(localMessage);
      }
      return;
      this.jdField_a_of_type_Avzo.removeMessages(2);
    }
  }
  
  public void a(avyy paramavyy, avzk paramavzk)
  {
    a(paramavyy, paramavzk, null);
  }
  
  public void a(avyy paramavyy, avzk paramavzk, avzl paramavzl)
  {
    if (QLog.isColorLevel()) {
      QLog.w("HWVideoRecorder", 2, "startRecording EGLContext = " + paramavyy.a());
    }
    if (this.d) {
      this.jdField_a_of_type_Avzq.a(paramavyy.jdField_a_of_type_Int, paramavyy.b);
    }
    Message localMessage = Message.obtain();
    avzp localavzp = new avzp(this, null);
    localavzp.jdField_a_of_type_Avzk = paramavzk;
    localavzp.jdField_a_of_type_Avzl = paramavzl;
    localavzp.jdField_a_of_type_Avyy = paramavyy;
    localMessage.obj = localavzp;
    localMessage.what = 0;
    this.jdField_a_of_type_Avzo.sendMessage(localMessage);
  }
  
  public boolean a()
  {
    return !this.jdField_a_of_type_Boolean;
  }
  
  public void b()
  {
    if (this.d) {
      this.jdField_a_of_type_Avzq.a();
    }
    Message localMessage = Message.obtain();
    localMessage.what = 1;
    this.jdField_a_of_type_Avzo.sendMessage(localMessage);
  }
  
  public void b(int paramInt1, int paramInt2, float[] paramArrayOfFloat1, float[] paramArrayOfFloat2, long paramLong)
  {
    if (QLog.isColorLevel()) {
      QLog.d("HWVideoRecorder", 2, "handleFrameAvailable timestampNanos = " + paramLong + " ; textureId = " + paramInt2 + " ; EGLContext = " + this.jdField_a_of_type_Avyy.a());
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
          this.jdField_a_of_type_Avza.a();
          if ((this.b) && (this.jdField_a_of_type_Avyy.jdField_a_of_type_Boolean))
          {
            this.b = false;
            awah.a(paramInt2, this.jdField_a_of_type_Avyy.jdField_a_of_type_Int, this.jdField_a_of_type_Avyy.b, this.jdField_a_of_type_Avyy, new avzn(this));
          }
          if (this.d)
          {
            paramInt2 = this.jdField_a_of_type_Avzq.a();
            if (paramInt2 == -1) {
              break label304;
            }
            this.jdField_a_of_type_Avyz.a(paramInt1, paramInt2, paramArrayOfFloat1, paramArrayOfFloat2, paramLong);
            if (this.d) {
              this.jdField_a_of_type_Avzq.a(false, 1);
            }
            if (this.jdField_a_of_type_Avzk == null) {
              break;
            }
            this.jdField_a_of_type_Avzk.b();
            return;
          }
        }
        catch (Exception paramArrayOfFloat1)
        {
          if (QLog.isColorLevel()) {
            QLog.e("HWVideoRecorder", 2, "frameAvailable: exception. config = " + this.jdField_a_of_type_Avyy, paramArrayOfFloat1);
          }
          if (this.jdField_a_of_type_Avzk != null) {
            this.jdField_a_of_type_Avzk.a_(2, paramArrayOfFloat1);
          }
          this.jdField_a_of_type_Avza.c();
          this.jdField_a_of_type_Avyz.a();
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
    this.jdField_a_of_type_Avzk = null;
    this.jdField_a_of_type_Avzl = null;
    this.jdField_a_of_type_Avyy = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     avzm
 * JD-Core Version:    0.7.0.1
 */