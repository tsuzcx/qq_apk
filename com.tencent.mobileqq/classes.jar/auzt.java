import android.annotation.TargetApi;
import android.media.MediaFormat;
import android.opengl.EGL14;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.support.annotation.NonNull;
import com.tencent.qphone.base.util.QLog;

@TargetApi(18)
public class auzt
{
  private HandlerThread jdField_a_of_type_AndroidOsHandlerThread = new HandlerThread("recode_thread");
  private auzf jdField_a_of_type_Auzf;
  private auzg jdField_a_of_type_Auzg;
  private auzh jdField_a_of_type_Auzh;
  private auzr jdField_a_of_type_Auzr;
  private auzs jdField_a_of_type_Auzs;
  protected auzv a;
  private auzx jdField_a_of_type_Auzx;
  private String jdField_a_of_type_JavaLangString;
  private volatile boolean jdField_a_of_type_Boolean;
  private boolean b;
  private boolean c;
  private boolean d;
  
  public auzt()
  {
    this.jdField_a_of_type_AndroidOsHandlerThread.start();
    this.jdField_a_of_type_Auzv = a(this.jdField_a_of_type_AndroidOsHandlerThread.getLooper());
    this.jdField_a_of_type_Auzh = new auzh();
    this.jdField_a_of_type_Auzg = new auzg();
    this.jdField_a_of_type_Auzx = new auzx();
  }
  
  private void a(auzw paramauzw)
  {
    this.jdField_a_of_type_Auzr = paramauzw.jdField_a_of_type_Auzr;
    this.jdField_a_of_type_Auzs = paramauzw.jdField_a_of_type_Auzs;
    paramauzw = paramauzw.jdField_a_of_type_Auzf;
    if (QLog.isColorLevel()) {
      QLog.w("HWVideoRecorder", 2, "handleStartRecording EGLContext = " + paramauzw.a());
    }
    if (this.jdField_a_of_type_Boolean) {
      d();
    }
    this.jdField_a_of_type_Boolean = true;
    this.jdField_a_of_type_Auzf = paramauzw;
    this.jdField_a_of_type_JavaLangString = paramauzw.jdField_a_of_type_JavaLangString;
    try
    {
      this.jdField_a_of_type_Auzh.a(paramauzw);
      this.jdField_a_of_type_Auzg.a(paramauzw, this.jdField_a_of_type_Auzh.a());
      if (this.jdField_a_of_type_Auzr != null) {
        this.jdField_a_of_type_Auzr.a();
      }
      this.b = true;
      this.c = false;
      return;
    }
    catch (Throwable localThrowable)
    {
      localThrowable.printStackTrace();
      if (QLog.isColorLevel()) {
        QLog.w("HWVideoRecorder", 2, "handleStartRecording: exception at start. encodeConfig = " + paramauzw, localThrowable);
      }
      if (this.jdField_a_of_type_Auzr != null) {
        this.jdField_a_of_type_Auzr.a_(1, localThrowable);
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
        this.jdField_a_of_type_Auzh.b();
        if (QLog.isColorLevel()) {
          QLog.w("HWVideoRecorder", 2, "handleStopRecording complete");
        }
        if ((this.jdField_a_of_type_Auzr != null) && (this.jdField_a_of_type_Auzf.jdField_a_of_type_Auzy == null))
        {
          this.jdField_a_of_type_Auzr.a(this.jdField_a_of_type_JavaLangString);
          this.jdField_a_of_type_Auzr = null;
        }
        this.jdField_a_of_type_Auzg.a();
        this.jdField_a_of_type_Auzs = null;
        return;
      }
      catch (Exception localException)
      {
        if (QLog.isColorLevel()) {
          QLog.e("HWVideoRecorder", 2, "handleStopRecording: exception. config = " + this.jdField_a_of_type_Auzf);
        }
        if (this.jdField_a_of_type_Auzr != null) {
          this.jdField_a_of_type_Auzr.a_(2, localException);
        }
        this.jdField_a_of_type_Auzh.c();
        this.jdField_a_of_type_Auzg.a();
        return;
      }
    }
    QLog.w("HWVideoRecorder", 2, "handleStopRecording: is not recording.");
  }
  
  public MediaFormat a()
  {
    if (this.jdField_a_of_type_Auzh != null) {
      return this.jdField_a_of_type_Auzh.a;
    }
    return null;
  }
  
  @NonNull
  protected auzv a(Looper paramLooper)
  {
    return new auzv(this, paramLooper, this);
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
    for (boolean bool = this.jdField_a_of_type_Auzx.a(paramInt2);; bool = false)
    {
      if ((!this.d) || (bool))
      {
        Message localMessage = Message.obtain();
        localMessage.what = 2;
        localMessage.obj = new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramArrayOfFloat1, paramArrayOfFloat2, Long.valueOf(paramLong) };
        this.jdField_a_of_type_Auzv.sendMessage(localMessage);
      }
      return;
      this.jdField_a_of_type_Auzv.removeMessages(2);
    }
  }
  
  public void a(auzf paramauzf, auzr paramauzr)
  {
    a(paramauzf, paramauzr, null);
  }
  
  public void a(auzf paramauzf, auzr paramauzr, auzs paramauzs)
  {
    if (QLog.isColorLevel()) {
      QLog.w("HWVideoRecorder", 2, "startRecording EGLContext = " + paramauzf.a());
    }
    if (this.d) {
      this.jdField_a_of_type_Auzx.a(paramauzf.jdField_a_of_type_Int, paramauzf.b);
    }
    Message localMessage = Message.obtain();
    auzw localauzw = new auzw(this, null);
    localauzw.jdField_a_of_type_Auzr = paramauzr;
    localauzw.jdField_a_of_type_Auzs = paramauzs;
    localauzw.jdField_a_of_type_Auzf = paramauzf;
    localMessage.obj = localauzw;
    localMessage.what = 0;
    this.jdField_a_of_type_Auzv.sendMessage(localMessage);
  }
  
  public boolean a()
  {
    return !this.jdField_a_of_type_Boolean;
  }
  
  public void b()
  {
    if (this.d) {
      this.jdField_a_of_type_Auzx.a();
    }
    Message localMessage = Message.obtain();
    localMessage.what = 1;
    this.jdField_a_of_type_Auzv.sendMessage(localMessage);
  }
  
  public void b(int paramInt1, int paramInt2, float[] paramArrayOfFloat1, float[] paramArrayOfFloat2, long paramLong)
  {
    if (QLog.isColorLevel()) {
      QLog.d("HWVideoRecorder", 2, "handleFrameAvailable timestampNanos = " + paramLong + " ; textureId = " + paramInt2 + " ; EGLContext = " + this.jdField_a_of_type_Auzf.a());
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
          this.jdField_a_of_type_Auzh.a();
          if ((this.b) && (this.jdField_a_of_type_Auzf.jdField_a_of_type_Boolean))
          {
            this.b = false;
            avao.a(paramInt2, this.jdField_a_of_type_Auzf.jdField_a_of_type_Int, this.jdField_a_of_type_Auzf.b, this.jdField_a_of_type_Auzf, new auzu(this));
          }
          if (this.d)
          {
            paramInt2 = this.jdField_a_of_type_Auzx.a();
            if (paramInt2 == -1) {
              break label304;
            }
            this.jdField_a_of_type_Auzg.a(paramInt1, paramInt2, paramArrayOfFloat1, paramArrayOfFloat2, paramLong);
            if (this.d) {
              this.jdField_a_of_type_Auzx.a(false, 1);
            }
            if (this.jdField_a_of_type_Auzr == null) {
              break;
            }
            this.jdField_a_of_type_Auzr.b();
            return;
          }
        }
        catch (Exception paramArrayOfFloat1)
        {
          if (QLog.isColorLevel()) {
            QLog.e("HWVideoRecorder", 2, "frameAvailable: exception. config = " + this.jdField_a_of_type_Auzf, paramArrayOfFloat1);
          }
          if (this.jdField_a_of_type_Auzr != null) {
            this.jdField_a_of_type_Auzr.a_(2, paramArrayOfFloat1);
          }
          this.jdField_a_of_type_Auzh.c();
          this.jdField_a_of_type_Auzg.a();
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
    this.jdField_a_of_type_Auzr = null;
    this.jdField_a_of_type_Auzs = null;
    this.jdField_a_of_type_Auzf = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     auzt
 * JD-Core Version:    0.7.0.1
 */