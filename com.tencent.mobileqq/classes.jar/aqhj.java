import android.os.SystemClock;

public class aqhj
{
  int jdField_a_of_type_Int;
  long jdField_a_of_type_Long;
  aqhk jdField_a_of_type_Aqhk;
  boolean jdField_a_of_type_Boolean = false;
  int b;
  int c = 100;
  
  public aqhj(int paramInt, aqhk paramaqhk)
  {
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_Aqhk = paramaqhk;
  }
  
  public void a(int paramInt)
  {
    if (!this.jdField_a_of_type_Boolean) {}
    do
    {
      return;
      this.b += paramInt;
      if (this.jdField_a_of_type_Long == 0L)
      {
        this.jdField_a_of_type_Long = SystemClock.uptimeMillis();
        return;
      }
    } while (SystemClock.uptimeMillis() - this.jdField_a_of_type_Long <= this.c);
    aqhk localaqhk = this.jdField_a_of_type_Aqhk;
    if (this.b > this.jdField_a_of_type_Int) {}
    for (boolean bool = true;; bool = false)
    {
      localaqhk.a(bool);
      this.jdField_a_of_type_Long = 0L;
      this.b = 0;
      return;
    }
  }
  
  public void a(boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
  
  public void b(int paramInt)
  {
    this.c = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     aqhj
 * JD-Core Version:    0.7.0.1
 */