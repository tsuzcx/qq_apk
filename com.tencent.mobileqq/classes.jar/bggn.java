import android.graphics.Color;
import android.util.SparseArray;

public class bggn
{
  public byte a;
  public int a;
  public long a;
  public SparseArray<bggn> a;
  public boolean a;
  public int b;
  public long b;
  public long c;
  
  public static bggn a()
  {
    return new bggn();
  }
  
  public static bggn a(int paramInt, byte paramByte)
  {
    bggn localbggn = new bggn();
    localbggn.jdField_b_of_type_Int = paramInt;
    localbggn.jdField_a_of_type_Byte = paramByte;
    return localbggn;
  }
  
  public int a()
  {
    return Color.rgb((int)this.jdField_a_of_type_Long, (int)this.jdField_b_of_type_Long, (int)this.c);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bggn
 * JD-Core Version:    0.7.0.1
 */