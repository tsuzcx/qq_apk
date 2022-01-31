import android.support.annotation.NonNull;

public class bmdl
  implements Comparable<bmdl>
{
  public static final bmdl a;
  public static final bmdl b = new bmdl(1);
  public static final bmdl c = new bmdl(2);
  public static final bmdl d = new bmdl(3);
  public static final bmdl e = new bmdl(4);
  public final int a;
  
  static
  {
    jdField_a_of_type_Bmdl = new bmdl(0);
  }
  
  public bmdl(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public int a(@NonNull bmdl parambmdl)
  {
    return this.jdField_a_of_type_Int - parambmdl.jdField_a_of_type_Int;
  }
  
  public boolean a(@NonNull bmdl parambmdl)
  {
    return a(parambmdl) >= 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bmdl
 * JD-Core Version:    0.7.0.1
 */