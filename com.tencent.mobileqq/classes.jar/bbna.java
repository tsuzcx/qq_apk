import android.annotation.TargetApi;
import android.media.MediaFormat;
import android.opengl.EGL14;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.support.annotation.NonNull;
import com.tencent.qphone.base.util.QLog;

@TargetApi(18)
public class bbna
{
  private HandlerThread jdField_a_of_type_AndroidOsHandlerThread = new HandlerThread("recode_thread");
  private bbmm jdField_a_of_type_Bbmm;
  private bbmn jdField_a_of_type_Bbmn;
  private bbmo jdField_a_of_type_Bbmo;
  private bbmy jdField_a_of_type_Bbmy;
  private bbmz jdField_a_of_type_Bbmz;
  protected bbnc a;
  private bbne jdField_a_of_type_Bbne;
  private String jdField_a_of_type_JavaLangString;
  private volatile boolean jdField_a_of_type_Boolean;
  private boolean b;
  private boolean c;
  private boolean d;
  
  public bbna()
  {
    this.jdField_a_of_type_AndroidOsHandlerThread.start();
    this.jdField_a_of_type_Bbnc = a(this.jdField_a_of_type_AndroidOsHandlerThread.getLooper());
    this.jdField_a_of_type_Bbmo = new bbmo();
    this.jdField_a_of_type_Bbmn = new bbmn();
    this.jdField_a_of_type_Bbne = new bbne();
  }
  
  private void a(bbnd parambbnd)
  {
    this.jdField_a_of_type_Bbmy = parambbnd.jdField_a_of_type_Bbmy;
    this.jdField_a_of_type_Bbmz = parambbnd.jdField_a_of_type_Bbmz;
    parambbnd = parambbnd.jdField_a_of_type_Bbmm;
    if (QLog.isColorLevel()) {
      QLog.w("HWVideoRecorder", 2, "handleStartRecording EGLContext = " + parambbnd.a());
    }
    if (this.jdField_a_of_type_Boolean) {
      d();
    }
    this.jdField_a_of_type_Boolean = true;
    this.jdField_a_of_type_Bbmm = parambbnd;
    this.jdField_a_of_type_JavaLangString = parambbnd.jdField_a_of_type_JavaLangString;
    try
    {
      this.jdField_a_of_type_Bbmo.a(parambbnd);
      this.jdField_a_of_type_Bbmn.a(parambbnd, this.jdField_a_of_type_Bbmo.a());
      if (this.jdField_a_of_type_Bbmy != null) {
        this.jdField_a_of_type_Bbmy.onEncodeStart();
      }
      this.b = true;
      this.c = false;
      return;
    }
    catch (Throwable localThrowable)
    {
      localThrowable.printStackTrace();
      if (QLog.isColorLevel()) {
        QLog.w("HWVideoRecorder", 2, "handleStartRecording: exception at start. encodeConfig = " + parambbnd, localThrowable);
      }
      if (this.jdField_a_of_type_Bbmy != null) {
        this.jdField_a_of_type_Bbmy.onEncodeError(1, localThrowable);
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
        this.jdField_a_of_type_Bbmo.b();
        if (QLog.isColorLevel()) {
          QLog.w("HWVideoRecorder", 2, "handleStopRecording complete");
        }
        if ((this.jdField_a_of_type_Bbmy != null) && (this.jdField_a_of_type_Bbmm != null) && (this.jdField_a_of_type_Bbmm.jdField_a_of_type_Bbnf == null))
        {
          this.jdField_a_of_type_Bbmy.onEncodeFinish(this.jdField_a_of_type_JavaLangString);
          this.jdField_a_of_type_Bbmy = null;
        }
        this.jdField_a_of_type_Bbmn.a();
        this.jdField_a_of_type_Bbmz = null;
        return;
      }
      catch (Exception localException)
      {
        if (QLog.isColorLevel()) {
          QLog.e("HWVideoRecorder", 2, "handleStopRecording: exception. config = " + this.jdField_a_of_type_Bbmm);
        }
        if (this.jdField_a_of_type_Bbmy != null) {
          this.jdField_a_of_type_Bbmy.onEncodeError(2, localException);
        }
        this.jdField_a_of_type_Bbmo.c();
        this.jdField_a_of_type_Bbmn.a();
        return;
      }
    }
    QLog.w("HWVideoRecorder", 2, "handleStopRecording: is not recording.");
  }
  
  public MediaFormat a()
  {
    if (this.jdField_a_of_type_Bbmo != null) {
      return this.jdField_a_of_type_Bbmo.a;
    }
    return null;
  }
  
  @NonNull
  protected bbnc a(Looper paramLooper)
  {
    return new bbnc(this, paramLooper, this);
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
    for (boolean bool = this.jdField_a_of_type_Bbne.a(paramInt2);; bool = false)
    {
      if ((!this.d) || (bool))
      {
        Message localMessage = Message.obtain();
        localMessage.what = 2;
        localMessage.obj = new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramArrayOfFloat1, paramArrayOfFloat2, Long.valueOf(paramLong) };
        this.jdField_a_of_type_Bbnc.sendMessage(localMessage);
      }
      return;
      this.jdField_a_of_type_Bbnc.removeMessages(2);
    }
  }
  
  public void a(bbmm parambbmm, bbmy parambbmy)
  {
    a(parambbmm, parambbmy, null);
  }
  
  public void a(bbmm parambbmm, bbmy parambbmy, bbmz parambbmz)
  {
    if (QLog.isColorLevel()) {
      QLog.w("HWVideoRecorder", 2, "startRecording EGLContext = " + parambbmm.a());
    }
    if (this.d) {
      this.jdField_a_of_type_Bbne.a(parambbmm.jdField_a_of_type_Int, parambbmm.b);
    }
    Message localMessage = Message.obtain();
    bbnd localbbnd = new bbnd(this, null);
    localbbnd.jdField_a_of_type_Bbmy = parambbmy;
    localbbnd.jdField_a_of_type_Bbmz = parambbmz;
    localbbnd.jdField_a_of_type_Bbmm = parambbmm;
    localMessage.obj = localbbnd;
    localMessage.what = 0;
    this.jdField_a_of_type_Bbnc.sendMessage(localMessage);
  }
  
  public boolean a()
  {
    return !this.jdField_a_of_type_Boolean;
  }
  
  public void b()
  {
    if (this.d) {
      this.jdField_a_of_type_Bbne.a();
    }
    Message localMessage = Message.obtain();
    localMessage.what = 1;
    this.jdField_a_of_type_Bbnc.sendMessage(localMessage);
  }
  
  public void b(int paramInt1, int paramInt2, float[] paramArrayOfFloat1, float[] paramArrayOfFloat2, long paramLong)
  {
    if (this.jdField_a_of_type_Bbmm == null) {
      QLog.d("HWVideoRecorder", 1, "handleFrameAvailable fail, encodeConfig null");
    }
    label324:
    do
    {
      do
      {
        return;
        if (QLog.isColorLevel()) {
          QLog.d("HWVideoRecorder", 2, new Object[] { "handleFrameAvailable timestampNanos = ", Long.valueOf(paramLong), "; textureId = ", Integer.valueOf(paramInt2), "; EGLContext = ", this.jdField_a_of_type_Bbmm.a() });
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
          this.jdField_a_of_type_Bbmo.a();
          if ((this.b) && (this.jdField_a_of_type_Bbmm.jdField_a_of_type_Boolean))
          {
            this.b = false;
            bbnv.a(paramInt2, this.jdField_a_of_type_Bbmm.jdField_a_of_type_Int, this.jdField_a_of_type_Bbmm.b, this.jdField_a_of_type_Bbmm, new bbnb(this));
          }
          if (this.d)
          {
            paramInt2 = this.jdField_a_of_type_Bbne.a();
            if (paramInt2 == -1) {
              break label324;
            }
            this.jdField_a_of_type_Bbmn.a(paramInt1, paramInt2, paramArrayOfFloat1, paramArrayOfFloat2, paramLong);
            if (this.d) {
              this.jdField_a_of_type_Bbne.a(false, 1);
            }
            if (this.jdField_a_of_type_Bbmy == null) {
              break;
            }
            this.jdField_a_of_type_Bbmy.onEncodeFrame();
            return;
          }
        }
        catch (Exception paramArrayOfFloat1)
        {
          if (QLog.isColorLevel()) {
            QLog.e("HWVideoRecorder", 2, "frameAvailable: exception. config = " + this.jdField_a_of_type_Bbmm, paramArrayOfFloat1);
          }
          if (this.jdField_a_of_type_Bbmy != null) {
            this.jdField_a_of_type_Bbmy.onEncodeError(2, paramArrayOfFloat1);
          }
          this.jdField_a_of_type_Bbmo.c();
          this.jdField_a_of_type_Bbmn.a();
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
    this.jdField_a_of_type_Bbmy = null;
    this.jdField_a_of_type_Bbmz = null;
    this.jdField_a_of_type_Bbmm = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bbna
 * JD-Core Version:    0.7.0.1
 */