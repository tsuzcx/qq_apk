import android.support.annotation.NonNull;

public class bjmz
  implements Comparable<bjmz>
{
  public static final bjmz a;
  public static final bjmz b = new bjmz(1);
  public static final bjmz c = new bjmz(2);
  public static final bjmz d = new bjmz(3);
  public static final bjmz e = new bjmz(4);
  public final int a;
  
  static
  {
    jdField_a_of_type_Bjmz = new bjmz(0);
  }
  
  public bjmz(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public int a(@NonNull bjmz parambjmz)
  {
    return this.jdField_a_of_type_Int - parambjmz.jdField_a_of_type_Int;
  }
  
  public boolean a(@NonNull bjmz parambjmz)
  {
    return a(parambjmz) >= 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     bjmz
 * JD-Core Version:    0.7.0.1
 */