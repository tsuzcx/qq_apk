import android.graphics.Color;
import android.util.SparseArray;

public class bbrf
{
  public byte a;
  public int a;
  public long a;
  public SparseArray<bbrf> a;
  public boolean a;
  public int b;
  public long b;
  public long c;
  
  public static bbrf a()
  {
    return new bbrf();
  }
  
  public static bbrf a(int paramInt, byte paramByte)
  {
    bbrf localbbrf = new bbrf();
    localbbrf.jdField_b_of_type_Int = paramInt;
    localbbrf.jdField_a_of_type_Byte = paramByte;
    return localbbrf;
  }
  
  public int a()
  {
    return Color.rgb((int)this.jdField_a_of_type_Long, (int)this.jdField_b_of_type_Long, (int)this.c);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     bbrf
 * JD-Core Version:    0.7.0.1
 */