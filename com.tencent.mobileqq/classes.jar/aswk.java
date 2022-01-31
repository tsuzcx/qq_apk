import android.os.SystemClock;

public class aswk
{
  int jdField_a_of_type_Int;
  long jdField_a_of_type_Long;
  aswl jdField_a_of_type_Aswl;
  boolean jdField_a_of_type_Boolean = false;
  int b;
  int c = 100;
  
  public aswk(int paramInt, aswl paramaswl)
  {
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_Aswl = paramaswl;
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
    aswl localaswl = this.jdField_a_of_type_Aswl;
    if (this.b > this.jdField_a_of_type_Int) {}
    for (boolean bool = true;; bool = false)
    {
      localaswl.a(bool);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aswk
 * JD-Core Version:    0.7.0.1
 */