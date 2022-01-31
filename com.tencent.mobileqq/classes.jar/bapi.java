import android.graphics.Color;
import android.util.SparseArray;

public class bapi
{
  public byte a;
  public int a;
  public long a;
  public SparseArray<bapi> a;
  public boolean a;
  public int b;
  public long b;
  public long c;
  
  public static bapi a()
  {
    return new bapi();
  }
  
  public static bapi a(int paramInt, byte paramByte)
  {
    bapi localbapi = new bapi();
    localbapi.jdField_b_of_type_Int = paramInt;
    localbapi.jdField_a_of_type_Byte = paramByte;
    return localbapi;
  }
  
  public int a()
  {
    return Color.rgb((int)this.jdField_a_of_type_Long, (int)this.jdField_b_of_type_Long, (int)this.c);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     bapi
 * JD-Core Version:    0.7.0.1
 */