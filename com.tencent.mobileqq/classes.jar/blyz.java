import android.support.annotation.NonNull;

public class blyz
  implements Comparable<blyz>
{
  public static final blyz a;
  public static final blyz b = new blyz(1);
  public static final blyz c = new blyz(2);
  public static final blyz d = new blyz(3);
  public static final blyz e = new blyz(4);
  public final int a;
  
  static
  {
    jdField_a_of_type_Blyz = new blyz(0);
  }
  
  public blyz(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public int a(@NonNull blyz paramblyz)
  {
    return this.jdField_a_of_type_Int - paramblyz.jdField_a_of_type_Int;
  }
  
  public boolean a(@NonNull blyz paramblyz)
  {
    return a(paramblyz) >= 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     blyz
 * JD-Core Version:    0.7.0.1
 */