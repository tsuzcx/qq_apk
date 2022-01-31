import android.graphics.Color;
import android.util.SparseArray;

public class bduw
{
  public byte a;
  public int a;
  public long a;
  public SparseArray<bduw> a;
  public boolean a;
  public int b;
  public long b;
  public long c;
  
  public static bduw a()
  {
    return new bduw();
  }
  
  public static bduw a(int paramInt, byte paramByte)
  {
    bduw localbduw = new bduw();
    localbduw.jdField_b_of_type_Int = paramInt;
    localbduw.jdField_a_of_type_Byte = paramByte;
    return localbduw;
  }
  
  public int a()
  {
    return Color.rgb((int)this.jdField_a_of_type_Long, (int)this.jdField_b_of_type_Long, (int)this.c);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bduw
 * JD-Core Version:    0.7.0.1
 */