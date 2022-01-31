import android.os.SystemClock;

public class arbn
{
  int jdField_a_of_type_Int;
  long jdField_a_of_type_Long;
  arbo jdField_a_of_type_Arbo;
  boolean jdField_a_of_type_Boolean = false;
  int b;
  int c = 100;
  
  public arbn(int paramInt, arbo paramarbo)
  {
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_Arbo = paramarbo;
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
    arbo localarbo = this.jdField_a_of_type_Arbo;
    if (this.b > this.jdField_a_of_type_Int) {}
    for (boolean bool = true;; bool = false)
    {
      localarbo.a(bool);
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
 * Qualified Name:     arbn
 * JD-Core Version:    0.7.0.1
 */