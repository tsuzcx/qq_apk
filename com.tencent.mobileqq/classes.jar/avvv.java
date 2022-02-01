import android.os.SystemClock;

public class avvv
{
  int jdField_a_of_type_Int;
  long jdField_a_of_type_Long;
  avvw jdField_a_of_type_Avvw;
  boolean jdField_a_of_type_Boolean = false;
  int b;
  int c = 100;
  
  public avvv(int paramInt, avvw paramavvw)
  {
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_Avvw = paramavvw;
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
    avvw localavvw = this.jdField_a_of_type_Avvw;
    if (this.b > this.jdField_a_of_type_Int) {}
    for (boolean bool = true;; bool = false)
    {
      localavvw.b(bool);
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
 * Qualified Name:     avvv
 * JD-Core Version:    0.7.0.1
 */