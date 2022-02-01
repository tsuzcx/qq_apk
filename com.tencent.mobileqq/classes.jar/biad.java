import android.graphics.Color;
import android.util.SparseArray;

public class biad
{
  public byte a;
  public int a;
  public long a;
  public SparseArray<biad> a;
  public boolean a;
  public int b;
  public long b;
  public long c;
  
  public static biad a()
  {
    return new biad();
  }
  
  public static biad a(int paramInt, byte paramByte)
  {
    biad localbiad = new biad();
    localbiad.jdField_b_of_type_Int = paramInt;
    localbiad.jdField_a_of_type_Byte = paramByte;
    return localbiad;
  }
  
  public int a()
  {
    return Color.rgb((int)this.jdField_a_of_type_Long, (int)this.jdField_b_of_type_Long, (int)this.c);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     biad
 * JD-Core Version:    0.7.0.1
 */