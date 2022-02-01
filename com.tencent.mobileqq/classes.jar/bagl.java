import android.annotation.TargetApi;
import android.media.MediaFormat;
import android.opengl.EGL14;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.support.annotation.NonNull;
import com.tencent.qphone.base.util.QLog;

@TargetApi(18)
public class bagl
{
  private HandlerThread jdField_a_of_type_AndroidOsHandlerThread = new HandlerThread("recode_thread");
  private bafx jdField_a_of_type_Bafx;
  private bafy jdField_a_of_type_Bafy;
  private bafz jdField_a_of_type_Bafz;
  private bagj jdField_a_of_type_Bagj;
  private bagk jdField_a_of_type_Bagk;
  protected bagn a;
  private bagp jdField_a_of_type_Bagp;
  private String jdField_a_of_type_JavaLangString;
  private volatile boolean jdField_a_of_type_Boolean;
  private boolean b;
  private boolean c;
  private boolean d;
  
  public bagl()
  {
    this.jdField_a_of_type_AndroidOsHandlerThread.start();
    this.jdField_a_of_type_Bagn = a(this.jdField_a_of_type_AndroidOsHandlerThread.getLooper());
    this.jdField_a_of_type_Bafz = new bafz();
    this.jdField_a_of_type_Bafy = new bafy();
    this.jdField_a_of_type_Bagp = new bagp();
  }
  
  private void a(bago parambago)
  {
    this.jdField_a_of_type_Bagj = parambago.jdField_a_of_type_Bagj;
    this.jdField_a_of_type_Bagk = parambago.jdField_a_of_type_Bagk;
    parambago = parambago.jdField_a_of_type_Bafx;
    if (QLog.isColorLevel()) {
      QLog.w("HWVideoRecorder", 2, "handleStartRecording EGLContext = " + parambago.a());
    }
    if (this.jdField_a_of_type_Boolean) {
      d();
    }
    this.jdField_a_of_type_Boolean = true;
    this.jdField_a_of_type_Bafx = parambago;
    this.jdField_a_of_type_JavaLangString = parambago.jdField_a_of_type_JavaLangString;
    try
    {
      this.jdField_a_of_type_Bafz.a(parambago);
      this.jdField_a_of_type_Bafy.a(parambago, this.jdField_a_of_type_Bafz.a());
      if (this.jdField_a_of_type_Bagj != null) {
        this.jdField_a_of_type_Bagj.onEncodeStart();
      }
      this.b = true;
      this.c = false;
      return;
    }
    catch (Throwable localThrowable)
    {
      localThrowable.printStackTrace();
      if (QLog.isColorLevel()) {
        QLog.w("HWVideoRecorder", 2, "handleStartRecording: exception at start. encodeConfig = " + parambago, localThrowable);
      }
      if (this.jdField_a_of_type_Bagj != null) {
        this.jdField_a_of_type_Bagj.onEncodeError(1, localThrowable);
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
        this.jdField_a_of_type_Bafz.b();
        if (QLog.isColorLevel()) {
          QLog.w("HWVideoRecorder", 2, "handleStopRecording complete");
        }
        if ((this.jdField_a_of_type_Bagj != null) && (this.jdField_a_of_type_Bafx != null) && (this.jdField_a_of_type_Bafx.jdField_a_of_type_Bagq == null))
        {
          this.jdField_a_of_type_Bagj.onEncodeFinish(this.jdField_a_of_type_JavaLangString);
          this.jdField_a_of_type_Bagj = null;
        }
        this.jdField_a_of_type_Bafy.a();
        this.jdField_a_of_type_Bagk = null;
        return;
      }
      catch (Exception localException)
      {
        if (QLog.isColorLevel()) {
          QLog.e("HWVideoRecorder", 2, "handleStopRecording: exception. config = " + this.jdField_a_of_type_Bafx);
        }
        if (this.jdField_a_of_type_Bagj != null) {
          this.jdField_a_of_type_Bagj.onEncodeError(2, localException);
        }
        this.jdField_a_of_type_Bafz.c();
        this.jdField_a_of_type_Bafy.a();
        return;
      }
    }
    QLog.w("HWVideoRecorder", 2, "handleStopRecording: is not recording.");
  }
  
  public MediaFormat a()
  {
    if (this.jdField_a_of_type_Bafz != null) {
      return this.jdField_a_of_type_Bafz.a;
    }
    return null;
  }
  
  @NonNull
  protected bagn a(Looper paramLooper)
  {
    return new bagn(this, paramLooper, this);
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
    for (boolean bool = this.jdField_a_of_type_Bagp.a(paramInt2);; bool = false)
    {
      if ((!this.d) || (bool))
      {
        Message localMessage = Message.obtain();
        localMessage.what = 2;
        localMessage.obj = new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramArrayOfFloat1, paramArrayOfFloat2, Long.valueOf(paramLong) };
        this.jdField_a_of_type_Bagn.sendMessage(localMessage);
      }
      return;
      this.jdField_a_of_type_Bagn.removeMessages(2);
    }
  }
  
  public void a(bafx parambafx, bagj parambagj)
  {
    a(parambafx, parambagj, null);
  }
  
  public void a(bafx parambafx, bagj parambagj, bagk parambagk)
  {
    if (QLog.isColorLevel()) {
      QLog.w("HWVideoRecorder", 2, "startRecording EGLContext = " + parambafx.a());
    }
    if (this.d) {
      this.jdField_a_of_type_Bagp.a(parambafx.jdField_a_of_type_Int, parambafx.b);
    }
    Message localMessage = Message.obtain();
    bago localbago = new bago(this, null);
    localbago.jdField_a_of_type_Bagj = parambagj;
    localbago.jdField_a_of_type_Bagk = parambagk;
    localbago.jdField_a_of_type_Bafx = parambafx;
    localMessage.obj = localbago;
    localMessage.what = 0;
    this.jdField_a_of_type_Bagn.sendMessage(localMessage);
  }
  
  public boolean a()
  {
    return !this.jdField_a_of_type_Boolean;
  }
  
  public void b()
  {
    if (this.d) {
      this.jdField_a_of_type_Bagp.a();
    }
    Message localMessage = Message.obtain();
    localMessage.what = 1;
    this.jdField_a_of_type_Bagn.sendMessage(localMessage);
  }
  
  public void b(int paramInt1, int paramInt2, float[] paramArrayOfFloat1, float[] paramArrayOfFloat2, long paramLong)
  {
    if (this.jdField_a_of_type_Bafx == null) {
      QLog.d("HWVideoRecorder", 1, "handleFrameAvailable fail, encodeConfig null");
    }
    label324:
    do
    {
      do
      {
        return;
        if (QLog.isColorLevel()) {
          QLog.d("HWVideoRecorder", 2, new Object[] { "handleFrameAvailable timestampNanos = ", Long.valueOf(paramLong), "; textureId = ", Integer.valueOf(paramInt2), "; EGLContext = ", this.jdField_a_of_type_Bafx.a() });
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
          this.jdField_a_of_type_Bafz.a();
          if ((this.b) && (this.jdField_a_of_type_Bafx.jdField_a_of_type_Boolean))
          {
            this.b = false;
            bahg.a(paramInt2, this.jdField_a_of_type_Bafx.jdField_a_of_type_Int, this.jdField_a_of_type_Bafx.b, this.jdField_a_of_type_Bafx, new bagm(this));
          }
          if (this.d)
          {
            paramInt2 = this.jdField_a_of_type_Bagp.a();
            if (paramInt2 == -1) {
              break label324;
            }
            this.jdField_a_of_type_Bafy.a(paramInt1, paramInt2, paramArrayOfFloat1, paramArrayOfFloat2, paramLong);
            if (this.d) {
              this.jdField_a_of_type_Bagp.a(false, 1);
            }
            if (this.jdField_a_of_type_Bagj == null) {
              break;
            }
            this.jdField_a_of_type_Bagj.onEncodeFrame();
            return;
          }
        }
        catch (Exception paramArrayOfFloat1)
        {
          if (QLog.isColorLevel()) {
            QLog.e("HWVideoRecorder", 2, "frameAvailable: exception. config = " + this.jdField_a_of_type_Bafx, paramArrayOfFloat1);
          }
          if (this.jdField_a_of_type_Bagj != null) {
            this.jdField_a_of_type_Bagj.onEncodeError(2, paramArrayOfFloat1);
          }
          this.jdField_a_of_type_Bafz.c();
          this.jdField_a_of_type_Bafy.a();
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
    this.jdField_a_of_type_Bagj = null;
    this.jdField_a_of_type_Bagk = null;
    this.jdField_a_of_type_Bafx = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bagl
 * JD-Core Version:    0.7.0.1
 */