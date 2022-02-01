import android.support.annotation.NonNull;

public class boil
{
  public static final boil a;
  public static final boil[] a;
  public static final boil b;
  public static final boil c;
  public static final boil d;
  public final String a;
  
  static
  {
    jdField_a_of_type_Boil = new boil("STARTED");
    b = new boil("SUCCESS");
    c = new boil("ERROR");
    d = new boil("FAILURE_GESTURE_IN_PROCESS");
    jdField_a_of_type_ArrayOfBoil = new boil[] { jdField_a_of_type_Boil, b, c, d };
  }
  
  private boil(@NonNull String paramString)
  {
    this.jdField_a_of_type_JavaLangString = paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     boil
 * JD-Core Version:    0.7.0.1
 */