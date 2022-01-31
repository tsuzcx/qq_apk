import android.annotation.TargetApi;
import android.media.MediaFormat;
import android.opengl.EGL14;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.support.annotation.NonNull;
import com.tencent.qphone.base.util.QLog;

@TargetApi(18)
public class avzo
{
  private HandlerThread jdField_a_of_type_AndroidOsHandlerThread = new HandlerThread("recode_thread");
  private avza jdField_a_of_type_Avza;
  private avzb jdField_a_of_type_Avzb;
  private avzc jdField_a_of_type_Avzc;
  private avzm jdField_a_of_type_Avzm;
  private avzn jdField_a_of_type_Avzn;
  protected avzq a;
  private avzs jdField_a_of_type_Avzs;
  private String jdField_a_of_type_JavaLangString;
  private volatile boolean jdField_a_of_type_Boolean;
  private boolean b;
  private boolean c;
  private boolean d;
  
  public avzo()
  {
    this.jdField_a_of_type_AndroidOsHandlerThread.start();
    this.jdField_a_of_type_Avzq = a(this.jdField_a_of_type_AndroidOsHandlerThread.getLooper());
    this.jdField_a_of_type_Avzc = new avzc();
    this.jdField_a_of_type_Avzb = new avzb();
    this.jdField_a_of_type_Avzs = new avzs();
  }
  
  private void a(avzr paramavzr)
  {
    this.jdField_a_of_type_Avzm = paramavzr.jdField_a_of_type_Avzm;
    this.jdField_a_of_type_Avzn = paramavzr.jdField_a_of_type_Avzn;
    paramavzr = paramavzr.jdField_a_of_type_Avza;
    if (QLog.isColorLevel()) {
      QLog.w("HWVideoRecorder", 2, "handleStartRecording EGLContext = " + paramavzr.a());
    }
    if (this.jdField_a_of_type_Boolean) {
      d();
    }
    this.jdField_a_of_type_Boolean = true;
    this.jdField_a_of_type_Avza = paramavzr;
    this.jdField_a_of_type_JavaLangString = paramavzr.jdField_a_of_type_JavaLangString;
    try
    {
      this.jdField_a_of_type_Avzc.a(paramavzr);
      this.jdField_a_of_type_Avzb.a(paramavzr, this.jdField_a_of_type_Avzc.a());
      if (this.jdField_a_of_type_Avzm != null) {
        this.jdField_a_of_type_Avzm.a();
      }
      this.b = true;
      this.c = false;
      return;
    }
    catch (Throwable localThrowable)
    {
      localThrowable.printStackTrace();
      if (QLog.isColorLevel()) {
        QLog.w("HWVideoRecorder", 2, "handleStartRecording: exception at start. encodeConfig = " + paramavzr, localThrowable);
      }
      if (this.jdField_a_of_type_Avzm != null) {
        this.jdField_a_of_type_Avzm.a_(1, localThrowable);
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
        this.jdField_a_of_type_Avzc.b();
        if (QLog.isColorLevel()) {
          QLog.w("HWVideoRecorder", 2, "handleStopRecording complete");
        }
        if ((this.jdField_a_of_type_Avzm != null) && (this.jdField_a_of_type_Avza.jdField_a_of_type_Avzt == null))
        {
          this.jdField_a_of_type_Avzm.a(this.jdField_a_of_type_JavaLangString);
          this.jdField_a_of_type_Avzm = null;
        }
        this.jdField_a_of_type_Avzb.a();
        this.jdField_a_of_type_Avzn = null;
        return;
      }
      catch (Exception localException)
      {
        if (QLog.isColorLevel()) {
          QLog.e("HWVideoRecorder", 2, "handleStopRecording: exception. config = " + this.jdField_a_of_type_Avza);
        }
        if (this.jdField_a_of_type_Avzm != null) {
          this.jdField_a_of_type_Avzm.a_(2, localException);
        }
        this.jdField_a_of_type_Avzc.c();
        this.jdField_a_of_type_Avzb.a();
        return;
      }
    }
    QLog.w("HWVideoRecorder", 2, "handleStopRecording: is not recording.");
  }
  
  public MediaFormat a()
  {
    if (this.jdField_a_of_type_Avzc != null) {
      return this.jdField_a_of_type_Avzc.a;
    }
    return null;
  }
  
  @NonNull
  protected avzq a(Looper paramLooper)
  {
    return new avzq(this, paramLooper, this);
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
    for (boolean bool = this.jdField_a_of_type_Avzs.a(paramInt2);; bool = false)
    {
      if ((!this.d) || (bool))
      {
        Message localMessage = Message.obtain();
        localMessage.what = 2;
        localMessage.obj = new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramArrayOfFloat1, paramArrayOfFloat2, Long.valueOf(paramLong) };
        this.jdField_a_of_type_Avzq.sendMessage(localMessage);
      }
      return;
      this.jdField_a_of_type_Avzq.removeMessages(2);
    }
  }
  
  public void a(avza paramavza, avzm paramavzm)
  {
    a(paramavza, paramavzm, null);
  }
  
  public void a(avza paramavza, avzm paramavzm, avzn paramavzn)
  {
    if (QLog.isColorLevel()) {
      QLog.w("HWVideoRecorder", 2, "startRecording EGLContext = " + paramavza.a());
    }
    if (this.d) {
      this.jdField_a_of_type_Avzs.a(paramavza.jdField_a_of_type_Int, paramavza.b);
    }
    Message localMessage = Message.obtain();
    avzr localavzr = new avzr(this, null);
    localavzr.jdField_a_of_type_Avzm = paramavzm;
    localavzr.jdField_a_of_type_Avzn = paramavzn;
    localavzr.jdField_a_of_type_Avza = paramavza;
    localMessage.obj = localavzr;
    localMessage.what = 0;
    this.jdField_a_of_type_Avzq.sendMessage(localMessage);
  }
  
  public boolean a()
  {
    return !this.jdField_a_of_type_Boolean;
  }
  
  public void b()
  {
    if (this.d) {
      this.jdField_a_of_type_Avzs.a();
    }
    Message localMessage = Message.obtain();
    localMessage.what = 1;
    this.jdField_a_of_type_Avzq.sendMessage(localMessage);
  }
  
  public void b(int paramInt1, int paramInt2, float[] paramArrayOfFloat1, float[] paramArrayOfFloat2, long paramLong)
  {
    if (QLog.isColorLevel()) {
      QLog.d("HWVideoRecorder", 2, "handleFrameAvailable timestampNanos = " + paramLong + " ; textureId = " + paramInt2 + " ; EGLContext = " + this.jdField_a_of_type_Avza.a());
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
          this.jdField_a_of_type_Avzc.a();
          if ((this.b) && (this.jdField_a_of_type_Avza.jdField_a_of_type_Boolean))
          {
            this.b = false;
            awaj.a(paramInt2, this.jdField_a_of_type_Avza.jdField_a_of_type_Int, this.jdField_a_of_type_Avza.b, this.jdField_a_of_type_Avza, new avzp(this));
          }
          if (this.d)
          {
            paramInt2 = this.jdField_a_of_type_Avzs.a();
            if (paramInt2 == -1) {
              break label304;
            }
            this.jdField_a_of_type_Avzb.a(paramInt1, paramInt2, paramArrayOfFloat1, paramArrayOfFloat2, paramLong);
            if (this.d) {
              this.jdField_a_of_type_Avzs.a(false, 1);
            }
            if (this.jdField_a_of_type_Avzm == null) {
              break;
            }
            this.jdField_a_of_type_Avzm.b();
            return;
          }
        }
        catch (Exception paramArrayOfFloat1)
        {
          if (QLog.isColorLevel()) {
            QLog.e("HWVideoRecorder", 2, "frameAvailable: exception. config = " + this.jdField_a_of_type_Avza, paramArrayOfFloat1);
          }
          if (this.jdField_a_of_type_Avzm != null) {
            this.jdField_a_of_type_Avzm.a_(2, paramArrayOfFloat1);
          }
          this.jdField_a_of_type_Avzc.c();
          this.jdField_a_of_type_Avzb.a();
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
    this.jdField_a_of_type_Avzm = null;
    this.jdField_a_of_type_Avzn = null;
    this.jdField_a_of_type_Avza = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     avzo
 * JD-Core Version:    0.7.0.1
 */