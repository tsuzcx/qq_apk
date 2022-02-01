import android.annotation.TargetApi;
import android.media.MediaFormat;
import android.opengl.EGL14;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.support.annotation.NonNull;
import com.tencent.qphone.base.util.QLog;

@TargetApi(18)
public class batx
{
  private HandlerThread jdField_a_of_type_AndroidOsHandlerThread = new HandlerThread("recode_thread");
  private batj jdField_a_of_type_Batj;
  private batk jdField_a_of_type_Batk;
  private batl jdField_a_of_type_Batl;
  private batv jdField_a_of_type_Batv;
  private batw jdField_a_of_type_Batw;
  protected batz a;
  private baub jdField_a_of_type_Baub;
  private String jdField_a_of_type_JavaLangString;
  private volatile boolean jdField_a_of_type_Boolean;
  private boolean b;
  private boolean c;
  private boolean d;
  
  public batx()
  {
    this.jdField_a_of_type_AndroidOsHandlerThread.start();
    this.jdField_a_of_type_Batz = a(this.jdField_a_of_type_AndroidOsHandlerThread.getLooper());
    this.jdField_a_of_type_Batl = new batl();
    this.jdField_a_of_type_Batk = new batk();
    this.jdField_a_of_type_Baub = new baub();
  }
  
  private void a(baua parambaua)
  {
    this.jdField_a_of_type_Batv = parambaua.jdField_a_of_type_Batv;
    this.jdField_a_of_type_Batw = parambaua.jdField_a_of_type_Batw;
    parambaua = parambaua.jdField_a_of_type_Batj;
    if (QLog.isColorLevel()) {
      QLog.w("HWVideoRecorder", 2, "handleStartRecording EGLContext = " + parambaua.a());
    }
    if (this.jdField_a_of_type_Boolean) {
      d();
    }
    this.jdField_a_of_type_Boolean = true;
    this.jdField_a_of_type_Batj = parambaua;
    this.jdField_a_of_type_JavaLangString = parambaua.jdField_a_of_type_JavaLangString;
    try
    {
      this.jdField_a_of_type_Batl.a(parambaua);
      this.jdField_a_of_type_Batk.a(parambaua, this.jdField_a_of_type_Batl.a());
      if (this.jdField_a_of_type_Batv != null) {
        this.jdField_a_of_type_Batv.a();
      }
      this.b = true;
      this.c = false;
      return;
    }
    catch (Throwable localThrowable)
    {
      localThrowable.printStackTrace();
      if (QLog.isColorLevel()) {
        QLog.w("HWVideoRecorder", 2, "handleStartRecording: exception at start. encodeConfig = " + parambaua, localThrowable);
      }
      if (this.jdField_a_of_type_Batv != null) {
        this.jdField_a_of_type_Batv.a_(1, localThrowable);
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
        this.jdField_a_of_type_Batl.b();
        if (QLog.isColorLevel()) {
          QLog.w("HWVideoRecorder", 2, "handleStopRecording complete");
        }
        if ((this.jdField_a_of_type_Batv != null) && (this.jdField_a_of_type_Batj != null) && (this.jdField_a_of_type_Batj.jdField_a_of_type_Bauc == null))
        {
          this.jdField_a_of_type_Batv.a(this.jdField_a_of_type_JavaLangString);
          this.jdField_a_of_type_Batv = null;
        }
        this.jdField_a_of_type_Batk.a();
        this.jdField_a_of_type_Batw = null;
        return;
      }
      catch (Exception localException)
      {
        if (QLog.isColorLevel()) {
          QLog.e("HWVideoRecorder", 2, "handleStopRecording: exception. config = " + this.jdField_a_of_type_Batj);
        }
        if (this.jdField_a_of_type_Batv != null) {
          this.jdField_a_of_type_Batv.a_(2, localException);
        }
        this.jdField_a_of_type_Batl.c();
        this.jdField_a_of_type_Batk.a();
        return;
      }
    }
    QLog.w("HWVideoRecorder", 2, "handleStopRecording: is not recording.");
  }
  
  public MediaFormat a()
  {
    if (this.jdField_a_of_type_Batl != null) {
      return this.jdField_a_of_type_Batl.a;
    }
    return null;
  }
  
  @NonNull
  protected batz a(Looper paramLooper)
  {
    return new batz(this, paramLooper, this);
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
    for (boolean bool = this.jdField_a_of_type_Baub.a(paramInt2);; bool = false)
    {
      if ((!this.d) || (bool))
      {
        Message localMessage = Message.obtain();
        localMessage.what = 2;
        localMessage.obj = new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramArrayOfFloat1, paramArrayOfFloat2, Long.valueOf(paramLong) };
        this.jdField_a_of_type_Batz.sendMessage(localMessage);
      }
      return;
      this.jdField_a_of_type_Batz.removeMessages(2);
    }
  }
  
  public void a(batj parambatj, batv parambatv)
  {
    a(parambatj, parambatv, null);
  }
  
  public void a(batj parambatj, batv parambatv, batw parambatw)
  {
    if (QLog.isColorLevel()) {
      QLog.w("HWVideoRecorder", 2, "startRecording EGLContext = " + parambatj.a());
    }
    if (this.d) {
      this.jdField_a_of_type_Baub.a(parambatj.jdField_a_of_type_Int, parambatj.b);
    }
    Message localMessage = Message.obtain();
    baua localbaua = new baua(this, null);
    localbaua.jdField_a_of_type_Batv = parambatv;
    localbaua.jdField_a_of_type_Batw = parambatw;
    localbaua.jdField_a_of_type_Batj = parambatj;
    localMessage.obj = localbaua;
    localMessage.what = 0;
    this.jdField_a_of_type_Batz.sendMessage(localMessage);
  }
  
  public boolean a()
  {
    return !this.jdField_a_of_type_Boolean;
  }
  
  public void b()
  {
    if (this.d) {
      this.jdField_a_of_type_Baub.a();
    }
    Message localMessage = Message.obtain();
    localMessage.what = 1;
    this.jdField_a_of_type_Batz.sendMessage(localMessage);
  }
  
  public void b(int paramInt1, int paramInt2, float[] paramArrayOfFloat1, float[] paramArrayOfFloat2, long paramLong)
  {
    if (this.jdField_a_of_type_Batj == null) {
      QLog.d("HWVideoRecorder", 1, "handleFrameAvailable fail, encodeConfig null");
    }
    label324:
    do
    {
      do
      {
        return;
        if (QLog.isColorLevel()) {
          QLog.d("HWVideoRecorder", 2, new Object[] { "handleFrameAvailable timestampNanos = ", Long.valueOf(paramLong), "; textureId = ", Integer.valueOf(paramInt2), "; EGLContext = ", this.jdField_a_of_type_Batj.a() });
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
          this.jdField_a_of_type_Batl.a();
          if ((this.b) && (this.jdField_a_of_type_Batj.jdField_a_of_type_Boolean))
          {
            this.b = false;
            baus.a(paramInt2, this.jdField_a_of_type_Batj.jdField_a_of_type_Int, this.jdField_a_of_type_Batj.b, this.jdField_a_of_type_Batj, new baty(this));
          }
          if (this.d)
          {
            paramInt2 = this.jdField_a_of_type_Baub.a();
            if (paramInt2 == -1) {
              break label324;
            }
            this.jdField_a_of_type_Batk.a(paramInt1, paramInt2, paramArrayOfFloat1, paramArrayOfFloat2, paramLong);
            if (this.d) {
              this.jdField_a_of_type_Baub.a(false, 1);
            }
            if (this.jdField_a_of_type_Batv == null) {
              break;
            }
            this.jdField_a_of_type_Batv.b();
            return;
          }
        }
        catch (Exception paramArrayOfFloat1)
        {
          if (QLog.isColorLevel()) {
            QLog.e("HWVideoRecorder", 2, "frameAvailable: exception. config = " + this.jdField_a_of_type_Batj, paramArrayOfFloat1);
          }
          if (this.jdField_a_of_type_Batv != null) {
            this.jdField_a_of_type_Batv.a_(2, paramArrayOfFloat1);
          }
          this.jdField_a_of_type_Batl.c();
          this.jdField_a_of_type_Batk.a();
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
    this.jdField_a_of_type_Batv = null;
    this.jdField_a_of_type_Batw = null;
    this.jdField_a_of_type_Batj = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     batx
 * JD-Core Version:    0.7.0.1
 */