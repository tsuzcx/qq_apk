import android.annotation.TargetApi;
import android.opengl.EGL14;
import android.opengl.Matrix;
import com.tencent.ttpic.video.AEEncoder;

@TargetApi(17)
public class baee
  implements bagj, AEEncoder
{
  private bafx jdField_a_of_type_Bafx;
  private bagl jdField_a_of_type_Bagl = new bagl();
  private final Object jdField_a_of_type_JavaLangObject = new Object();
  private boolean jdField_a_of_type_Boolean;
  private float[] jdField_a_of_type_ArrayOfFloat = new float[16];
  
  public baee(String paramString, int paramInt1, int paramInt2)
  {
    this.jdField_a_of_type_Bafx = new bafx(paramString, paramInt1, paramInt2, 5242880, 1, false, 0);
    Matrix.setIdentityM(this.jdField_a_of_type_ArrayOfFloat, 0);
    Matrix.setRotateM(this.jdField_a_of_type_ArrayOfFloat, 0, 180.0F, 1.0F, 0.0F, 0.0F);
  }
  
  public void onEncodeError(int paramInt, Throwable paramThrowable) {}
  
  public void onEncodeFinish(String arg1)
  {
    this.jdField_a_of_type_Bagl.c();
    this.jdField_a_of_type_Boolean = false;
    synchronized (this.jdField_a_of_type_JavaLangObject)
    {
      this.jdField_a_of_type_JavaLangObject.notifyAll();
      return;
    }
  }
  
  public void onEncodeFrame() {}
  
  public void onEncodeStart() {}
  
  public void release()
  {
    this.jdField_a_of_type_Bagl.b();
    try
    {
      synchronized (this.jdField_a_of_type_JavaLangObject)
      {
        this.jdField_a_of_type_JavaLangObject.wait();
        label21:
        return;
      }
    }
    catch (InterruptedException localInterruptedException)
    {
      break label21;
    }
  }
  
  public int writeFrame(int paramInt, long paramLong)
  {
    if (!this.jdField_a_of_type_Boolean)
    {
      this.jdField_a_of_type_Bafx.a(EGL14.eglGetCurrentContext());
      this.jdField_a_of_type_Bagl.a(this.jdField_a_of_type_Bafx, this);
      this.jdField_a_of_type_Boolean = true;
    }
    this.jdField_a_of_type_Bagl.a(3553, paramInt, null, this.jdField_a_of_type_ArrayOfFloat, 1000000L * paramLong);
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     baee
 * JD-Core Version:    0.7.0.1
 */