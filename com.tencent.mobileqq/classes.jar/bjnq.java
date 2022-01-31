import android.support.annotation.NonNull;

public class bjnq
  implements Comparable<bjnq>
{
  public static final bjnq a;
  public static final bjnq b = new bjnq(1);
  public static final bjnq c = new bjnq(2);
  public static final bjnq d = new bjnq(3);
  public static final bjnq e = new bjnq(4);
  public final int a;
  
  static
  {
    jdField_a_of_type_Bjnq = new bjnq(0);
  }
  
  public bjnq(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public int a(@NonNull bjnq parambjnq)
  {
    return this.jdField_a_of_type_Int - parambjnq.jdField_a_of_type_Int;
  }
  
  public boolean a(@NonNull bjnq parambjnq)
  {
    return a(parambjnq) >= 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     bjnq
 * JD-Core Version:    0.7.0.1
 */