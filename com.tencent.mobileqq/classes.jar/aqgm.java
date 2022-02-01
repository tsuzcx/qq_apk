import android.support.v4.util.SparseArrayCompat;

public class aqgm
{
  private static final aqgm jdField_a_of_type_Aqgm = new aqgm();
  private int jdField_a_of_type_Int;
  private final SparseArrayCompat<aqfy> jdField_a_of_type_AndroidSupportV4UtilSparseArrayCompat = new SparseArrayCompat();
  
  public static aqgm a()
  {
    return jdField_a_of_type_Aqgm;
  }
  
  public int a(aqfy paramaqfy)
  {
    synchronized (this.jdField_a_of_type_AndroidSupportV4UtilSparseArrayCompat)
    {
      do
      {
        this.jdField_a_of_type_Int += 1;
      } while ((this.jdField_a_of_type_AndroidSupportV4UtilSparseArrayCompat.get(this.jdField_a_of_type_Int) != null) || (this.jdField_a_of_type_Int == 0));
      this.jdField_a_of_type_AndroidSupportV4UtilSparseArrayCompat.put(this.jdField_a_of_type_Int, paramaqfy);
      int i = this.jdField_a_of_type_Int;
      return i;
    }
  }
  
  public void a(int paramInt)
  {
    synchronized (this.jdField_a_of_type_AndroidSupportV4UtilSparseArrayCompat)
    {
      this.jdField_a_of_type_AndroidSupportV4UtilSparseArrayCompat.delete(paramInt);
      return;
    }
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    synchronized (this.jdField_a_of_type_AndroidSupportV4UtilSparseArrayCompat)
    {
      aqfy localaqfy = (aqfy)this.jdField_a_of_type_AndroidSupportV4UtilSparseArrayCompat.get(paramInt1);
      if (localaqfy != null) {
        localaqfy.a(paramInt1, paramInt2);
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aqgm
 * JD-Core Version:    0.7.0.1
 */