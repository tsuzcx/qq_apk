import android.support.annotation.NonNull;

public class bhve
  implements Comparable<bhve>
{
  public static final bhve a;
  public static final bhve b = new bhve(1);
  public static final bhve c = new bhve(2);
  public static final bhve d = new bhve(3);
  public static final bhve e = new bhve(4);
  public final int a;
  
  static
  {
    jdField_a_of_type_Bhve = new bhve(0);
  }
  
  public bhve(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public int a(@NonNull bhve parambhve)
  {
    return this.jdField_a_of_type_Int - parambhve.jdField_a_of_type_Int;
  }
  
  public boolean a(@NonNull bhve parambhve)
  {
    return a(parambhve) >= 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     bhve
 * JD-Core Version:    0.7.0.1
 */