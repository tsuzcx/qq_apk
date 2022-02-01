import android.os.SystemClock;

public class auiv
{
  int jdField_a_of_type_Int;
  long jdField_a_of_type_Long;
  auiw jdField_a_of_type_Auiw;
  boolean jdField_a_of_type_Boolean = false;
  int b;
  int c = 100;
  
  public auiv(int paramInt, auiw paramauiw)
  {
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_Auiw = paramauiw;
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
    auiw localauiw = this.jdField_a_of_type_Auiw;
    if (this.b > this.jdField_a_of_type_Int) {}
    for (boolean bool = true;; bool = false)
    {
      localauiw.onCheckSpeed(bool);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     auiv
 * JD-Core Version:    0.7.0.1
 */