import android.graphics.Color;
import android.util.SparseArray;

public class bgzx
{
  public byte a;
  public int a;
  public long a;
  public SparseArray<bgzx> a;
  public boolean a;
  public int b;
  public long b;
  public long c;
  
  public static bgzx a()
  {
    return new bgzx();
  }
  
  public static bgzx a(int paramInt, byte paramByte)
  {
    bgzx localbgzx = new bgzx();
    localbgzx.jdField_b_of_type_Int = paramInt;
    localbgzx.jdField_a_of_type_Byte = paramByte;
    return localbgzx;
  }
  
  public int a()
  {
    return Color.rgb((int)this.jdField_a_of_type_Long, (int)this.jdField_b_of_type_Long, (int)this.c);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bgzx
 * JD-Core Version:    0.7.0.1
 */