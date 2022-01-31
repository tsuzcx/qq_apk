import android.os.SystemClock;

public class arbl
{
  int jdField_a_of_type_Int;
  long jdField_a_of_type_Long;
  arbm jdField_a_of_type_Arbm;
  boolean jdField_a_of_type_Boolean = false;
  int b;
  int c = 100;
  
  public arbl(int paramInt, arbm paramarbm)
  {
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_Arbm = paramarbm;
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
    arbm localarbm = this.jdField_a_of_type_Arbm;
    if (this.b > this.jdField_a_of_type_Int) {}
    for (boolean bool = true;; bool = false)
    {
      localarbm.a(bool);
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
 * Qualified Name:     arbl
 * JD-Core Version:    0.7.0.1
 */