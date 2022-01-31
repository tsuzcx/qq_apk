import android.graphics.Color;
import android.util.SparseArray;

public class bbrt
{
  public byte a;
  public int a;
  public long a;
  public SparseArray<bbrt> a;
  public boolean a;
  public int b;
  public long b;
  public long c;
  
  public static bbrt a()
  {
    return new bbrt();
  }
  
  public static bbrt a(int paramInt, byte paramByte)
  {
    bbrt localbbrt = new bbrt();
    localbbrt.jdField_b_of_type_Int = paramInt;
    localbbrt.jdField_a_of_type_Byte = paramByte;
    return localbbrt;
  }
  
  public int a()
  {
    return Color.rgb((int)this.jdField_a_of_type_Long, (int)this.jdField_b_of_type_Long, (int)this.c);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     bbrt
 * JD-Core Version:    0.7.0.1
 */