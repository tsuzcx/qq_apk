import android.content.Context;
import com.tencent.qphone.base.util.QLog;

public class amol
  implements amrx
{
  public static int a;
  private long jdField_a_of_type_Long;
  private amom jdField_a_of_type_Amom;
  private amrv jdField_a_of_type_Amrv;
  private Context jdField_a_of_type_AndroidContentContext;
  private boolean jdField_a_of_type_Boolean;
  private int jdField_b_of_type_Int = 0;
  private boolean jdField_b_of_type_Boolean = true;
  
  static
  {
    jdField_a_of_type_Int = 8;
  }
  
  public amol(Context paramContext)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_Amrv = new amrv();
  }
  
  private void b(float paramFloat1, float paramFloat2, float paramFloat3, long paramLong)
  {
    long l;
    if (this.jdField_a_of_type_Long != 0L)
    {
      l = System.currentTimeMillis();
      if (l - this.jdField_a_of_type_Long >= 1000L) {}
    }
    label35:
    label195:
    label197:
    do
    {
      for (;;)
      {
        return;
        this.jdField_a_of_type_Long = l;
        if (paramFloat2 > jdField_a_of_type_Int) {}
        for (int i = 1;; i = 2)
        {
          if (this.jdField_b_of_type_Int == i) {
            break label195;
          }
          QLog.i("ARPhonePoseDetectManager", 1, "detectPhonePose. data = " + paramFloat1 + "," + paramFloat2 + "," + paramFloat3 + "," + paramLong + ", mPhonePose = " + this.jdField_b_of_type_Int + ", phonePose = " + i);
          if ((i == 2) && (this.jdField_b_of_type_Boolean)) {
            this.jdField_b_of_type_Boolean = false;
          }
          this.jdField_b_of_type_Int = i;
          if (this.jdField_a_of_type_Amom == null) {
            break;
          }
          if (this.jdField_b_of_type_Int != 1) {
            break label197;
          }
          this.jdField_a_of_type_Amom.a(true);
          return;
          this.jdField_a_of_type_Long = System.currentTimeMillis();
          break label35;
        }
      }
    } while (this.jdField_b_of_type_Int != 2);
    this.jdField_a_of_type_Amom.a(false);
  }
  
  public void a()
  {
    if (!this.jdField_a_of_type_Boolean)
    {
      this.jdField_a_of_type_Amrv.a(this.jdField_a_of_type_AndroidContentContext, this);
      this.jdField_a_of_type_Boolean = true;
      return;
    }
    this.jdField_a_of_type_Amrv.b();
    this.jdField_b_of_type_Int = 0;
  }
  
  public void a(float paramFloat1, float paramFloat2, float paramFloat3, long paramLong)
  {
    b(paramFloat1, paramFloat2, paramFloat3, paramLong);
  }
  
  public void a(amom paramamom)
  {
    this.jdField_a_of_type_Amom = paramamom;
  }
  
  public void a(float[] paramArrayOfFloat) {}
  
  public void b()
  {
    this.jdField_a_of_type_Amrv.c();
    this.jdField_b_of_type_Int = 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     amol
 * JD-Core Version:    0.7.0.1
 */