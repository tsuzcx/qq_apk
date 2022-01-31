import android.graphics.Color;
import android.util.SparseArray;

public class bdqn
{
  public byte a;
  public int a;
  public long a;
  public SparseArray<bdqn> a;
  public boolean a;
  public int b;
  public long b;
  public long c;
  
  public static bdqn a()
  {
    return new bdqn();
  }
  
  public static bdqn a(int paramInt, byte paramByte)
  {
    bdqn localbdqn = new bdqn();
    localbdqn.jdField_b_of_type_Int = paramInt;
    localbdqn.jdField_a_of_type_Byte = paramByte;
    return localbdqn;
  }
  
  public int a()
  {
    return Color.rgb((int)this.jdField_a_of_type_Long, (int)this.jdField_b_of_type_Long, (int)this.c);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bdqn
 * JD-Core Version:    0.7.0.1
 */