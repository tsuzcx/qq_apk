import android.os.SystemClock;

public class biip
{
  final long a;
  public final String a;
  public final String b;
  public final String c;
  
  biip(String paramString1, String paramString2, String paramString3)
  {
    this.jdField_a_of_type_JavaLangString = paramString1;
    this.b = paramString2;
    this.c = paramString3;
    this.jdField_a_of_type_Long = SystemClock.elapsedRealtime();
  }
  
  boolean a()
  {
    return SystemClock.elapsedRealtime() - this.jdField_a_of_type_Long > 300000L;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     biip
 * JD-Core Version:    0.7.0.1
 */