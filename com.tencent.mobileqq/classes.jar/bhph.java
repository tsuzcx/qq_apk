import android.graphics.Color;
import android.util.SparseArray;

public class bhph
{
  public byte a;
  public int a;
  public long a;
  public SparseArray<bhph> a;
  public boolean a;
  public int b;
  public long b;
  public long c;
  
  public static bhph a()
  {
    return new bhph();
  }
  
  public static bhph a(int paramInt, byte paramByte)
  {
    bhph localbhph = new bhph();
    localbhph.jdField_b_of_type_Int = paramInt;
    localbhph.jdField_a_of_type_Byte = paramByte;
    return localbhph;
  }
  
  public int a()
  {
    return Color.rgb((int)this.jdField_a_of_type_Long, (int)this.jdField_b_of_type_Long, (int)this.c);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bhph
 * JD-Core Version:    0.7.0.1
 */