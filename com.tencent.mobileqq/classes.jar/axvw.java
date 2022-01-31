import android.annotation.TargetApi;
import android.media.MediaFormat;
import android.opengl.EGL14;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.support.annotation.NonNull;
import com.tencent.qphone.base.util.QLog;

@TargetApi(18)
public class axvw
{
  private HandlerThread jdField_a_of_type_AndroidOsHandlerThread = new HandlerThread("recode_thread");
  private axvi jdField_a_of_type_Axvi;
  private axvj jdField_a_of_type_Axvj;
  private axvk jdField_a_of_type_Axvk;
  private axvu jdField_a_of_type_Axvu;
  private axvv jdField_a_of_type_Axvv;
  protected axvy a;
  private axwa jdField_a_of_type_Axwa;
  private String jdField_a_of_type_JavaLangString;
  private volatile boolean jdField_a_of_type_Boolean;
  private boolean b;
  private boolean c;
  private boolean d;
  
  public axvw()
  {
    this.jdField_a_of_type_AndroidOsHandlerThread.start();
    this.jdField_a_of_type_Axvy = a(this.jdField_a_of_type_AndroidOsHandlerThread.getLooper());
    this.jdField_a_of_type_Axvk = new axvk();
    this.jdField_a_of_type_Axvj = new axvj();
    this.jdField_a_of_type_Axwa = new axwa();
  }
  
  private void a(axvz paramaxvz)
  {
    this.jdField_a_of_type_Axvu = paramaxvz.jdField_a_of_type_Axvu;
    this.jdField_a_of_type_Axvv = paramaxvz.jdField_a_of_type_Axvv;
    paramaxvz = paramaxvz.jdField_a_of_type_Axvi;
    if (QLog.isColorLevel()) {
      QLog.w("HWVideoRecorder", 2, "handleStartRecording EGLContext = " + paramaxvz.a());
    }
    if (this.jdField_a_of_type_Boolean) {
      d();
    }
    this.jdField_a_of_type_Boolean = true;
    this.jdField_a_of_type_Axvi = paramaxvz;
    this.jdField_a_of_type_JavaLangString = paramaxvz.jdField_a_of_type_JavaLangString;
    try
    {
      this.jdField_a_of_type_Axvk.a(paramaxvz);
      this.jdField_a_of_type_Axvj.a(paramaxvz, this.jdField_a_of_type_Axvk.a());
      if (this.jdField_a_of_type_Axvu != null) {
        this.jdField_a_of_type_Axvu.a();
      }
      this.b = true;
      this.c = false;
      return;
    }
    catch (Throwable localThrowable)
    {
      localThrowable.printStackTrace();
      if (QLog.isColorLevel()) {
        QLog.w("HWVideoRecorder", 2, "handleStartRecording: exception at start. encodeConfig = " + paramaxvz, localThrowable);
      }
      if (this.jdField_a_of_type_Axvu != null) {
        this.jdField_a_of_type_Axvu.a_(1, localThrowable);
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
        this.jdField_a_of_type_Axvk.b();
        if (QLog.isColorLevel()) {
          QLog.w("HWVideoRecorder", 2, "handleStopRecording complete");
        }
        if ((this.jdField_a_of_type_Axvu != null) && (this.jdField_a_of_type_Axvi.jdField_a_of_type_Axwb == null))
        {
          this.jdField_a_of_type_Axvu.a(this.jdField_a_of_type_JavaLangString);
          this.jdField_a_of_type_Axvu = null;
        }
        this.jdField_a_of_type_Axvj.a();
        this.jdField_a_of_type_Axvv = null;
        return;
      }
      catch (Exception localException)
      {
        if (QLog.isColorLevel()) {
          QLog.e("HWVideoRecorder", 2, "handleStopRecording: exception. config = " + this.jdField_a_of_type_Axvi);
        }
        if (this.jdField_a_of_type_Axvu != null) {
          this.jdField_a_of_type_Axvu.a_(2, localException);
        }
        this.jdField_a_of_type_Axvk.c();
        this.jdField_a_of_type_Axvj.a();
        return;
      }
    }
    QLog.w("HWVideoRecorder", 2, "handleStopRecording: is not recording.");
  }
  
  public MediaFormat a()
  {
    if (this.jdField_a_of_type_Axvk != null) {
      return this.jdField_a_of_type_Axvk.a;
    }
    return null;
  }
  
  @NonNull
  protected axvy a(Looper paramLooper)
  {
    return new axvy(this, paramLooper, this);
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
    for (boolean bool = this.jdField_a_of_type_Axwa.a(paramInt2);; bool = false)
    {
      if ((!this.d) || (bool))
      {
        Message localMessage = Message.obtain();
        localMessage.what = 2;
        localMessage.obj = new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramArrayOfFloat1, paramArrayOfFloat2, Long.valueOf(paramLong) };
        this.jdField_a_of_type_Axvy.sendMessage(localMessage);
      }
      return;
      this.jdField_a_of_type_Axvy.removeMessages(2);
    }
  }
  
  public void a(axvi paramaxvi, axvu paramaxvu)
  {
    a(paramaxvi, paramaxvu, null);
  }
  
  public void a(axvi paramaxvi, axvu paramaxvu, axvv paramaxvv)
  {
    if (QLog.isColorLevel()) {
      QLog.w("HWVideoRecorder", 2, "startRecording EGLContext = " + paramaxvi.a());
    }
    if (this.d) {
      this.jdField_a_of_type_Axwa.a(paramaxvi.jdField_a_of_type_Int, paramaxvi.b);
    }
    Message localMessage = Message.obtain();
    axvz localaxvz = new axvz(this, null);
    localaxvz.jdField_a_of_type_Axvu = paramaxvu;
    localaxvz.jdField_a_of_type_Axvv = paramaxvv;
    localaxvz.jdField_a_of_type_Axvi = paramaxvi;
    localMessage.obj = localaxvz;
    localMessage.what = 0;
    this.jdField_a_of_type_Axvy.sendMessage(localMessage);
  }
  
  public boolean a()
  {
    return !this.jdField_a_of_type_Boolean;
  }
  
  public void b()
  {
    if (this.d) {
      this.jdField_a_of_type_Axwa.a();
    }
    Message localMessage = Message.obtain();
    localMessage.what = 1;
    this.jdField_a_of_type_Axvy.sendMessage(localMessage);
  }
  
  public void b(int paramInt1, int paramInt2, float[] paramArrayOfFloat1, float[] paramArrayOfFloat2, long paramLong)
  {
    if (QLog.isColorLevel()) {
      QLog.d("HWVideoRecorder", 2, "handleFrameAvailable timestampNanos = " + paramLong + " ; textureId = " + paramInt2 + " ; EGLContext = " + this.jdField_a_of_type_Axvi.a());
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
          this.jdField_a_of_type_Axvk.a();
          if ((this.b) && (this.jdField_a_of_type_Axvi.jdField_a_of_type_Boolean))
          {
            this.b = false;
            axwr.a(paramInt2, this.jdField_a_of_type_Axvi.jdField_a_of_type_Int, this.jdField_a_of_type_Axvi.b, this.jdField_a_of_type_Axvi, new axvx(this));
          }
          if (this.d)
          {
            paramInt2 = this.jdField_a_of_type_Axwa.a();
            if (paramInt2 == -1) {
              break label304;
            }
            this.jdField_a_of_type_Axvj.a(paramInt1, paramInt2, paramArrayOfFloat1, paramArrayOfFloat2, paramLong);
            if (this.d) {
              this.jdField_a_of_type_Axwa.a(false, 1);
            }
            if (this.jdField_a_of_type_Axvu == null) {
              break;
            }
            this.jdField_a_of_type_Axvu.b();
            return;
          }
        }
        catch (Exception paramArrayOfFloat1)
        {
          if (QLog.isColorLevel()) {
            QLog.e("HWVideoRecorder", 2, "frameAvailable: exception. config = " + this.jdField_a_of_type_Axvi, paramArrayOfFloat1);
          }
          if (this.jdField_a_of_type_Axvu != null) {
            this.jdField_a_of_type_Axvu.a_(2, paramArrayOfFloat1);
          }
          this.jdField_a_of_type_Axvk.c();
          this.jdField_a_of_type_Axvj.a();
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
    this.jdField_a_of_type_Axvu = null;
    this.jdField_a_of_type_Axvv = null;
    this.jdField_a_of_type_Axvi = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     axvw
 * JD-Core Version:    0.7.0.1
 */