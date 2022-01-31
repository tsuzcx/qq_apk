import android.graphics.Paint;
import android.support.annotation.NonNull;

public abstract class baif
{
  private int jdField_a_of_type_Int;
  private String jdField_a_of_type_JavaLangString;
  
  public baif(int paramInt, @NonNull String paramString)
  {
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_JavaLangString = paramString;
  }
  
  abstract float a(@NonNull Paint paramPaint);
  
  int a()
  {
    return this.jdField_a_of_type_Int;
  }
  
  String a()
  {
    return this.jdField_a_of_type_JavaLangString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     baif
 * JD-Core Version:    0.7.0.1
 */