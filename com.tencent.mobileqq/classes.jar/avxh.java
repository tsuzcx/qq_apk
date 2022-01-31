import android.annotation.TargetApi;
import android.opengl.EGL14;
import android.opengl.Matrix;
import com.tencent.ttpic.video.AEEncoder;

@TargetApi(17)
public class avxh
  implements avzm, AEEncoder
{
  private avza jdField_a_of_type_Avza;
  private avzo jdField_a_of_type_Avzo = new avzo();
  private final Object jdField_a_of_type_JavaLangObject = new Object();
  private boolean jdField_a_of_type_Boolean;
  private float[] jdField_a_of_type_ArrayOfFloat = new float[16];
  
  public avxh(String paramString, int paramInt1, int paramInt2)
  {
    this.jdField_a_of_type_Avza = new avza(paramString, paramInt1, paramInt2, 5242880, 1, false, 0);
    Matrix.setIdentityM(this.jdField_a_of_type_ArrayOfFloat, 0);
    Matrix.setRotateM(this.jdField_a_of_type_ArrayOfFloat, 0, 180.0F, 1.0F, 0.0F, 0.0F);
  }
  
  public void a() {}
  
  public void a(String arg1)
  {
    this.jdField_a_of_type_Avzo.c();
    this.jdField_a_of_type_Boolean = false;
    synchronized (this.jdField_a_of_type_JavaLangObject)
    {
      this.jdField_a_of_type_JavaLangObject.notifyAll();
      return;
    }
  }
  
  public void a_(int paramInt, Throwable paramThrowable) {}
  
  public void b() {}
  
  public void release()
  {
    this.jdField_a_of_type_Avzo.b();
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
      this.jdField_a_of_type_Avza.a(EGL14.eglGetCurrentContext());
      this.jdField_a_of_type_Avzo.a(this.jdField_a_of_type_Avza, this);
      this.jdField_a_of_type_Boolean = true;
    }
    this.jdField_a_of_type_Avzo.a(3553, paramInt, null, this.jdField_a_of_type_ArrayOfFloat, 1000000L * paramLong);
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     avxh
 * JD-Core Version:    0.7.0.1
 */