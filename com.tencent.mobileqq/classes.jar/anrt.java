import android.support.v4.util.SparseArrayCompat;

public class anrt
{
  private static final anrt jdField_a_of_type_Anrt = new anrt();
  private int jdField_a_of_type_Int;
  private final SparseArrayCompat<anrf> jdField_a_of_type_AndroidSupportV4UtilSparseArrayCompat = new SparseArrayCompat();
  
  public static anrt a()
  {
    return jdField_a_of_type_Anrt;
  }
  
  public int a(anrf paramanrf)
  {
    synchronized (this.jdField_a_of_type_AndroidSupportV4UtilSparseArrayCompat)
    {
      do
      {
        this.jdField_a_of_type_Int += 1;
      } while ((this.jdField_a_of_type_AndroidSupportV4UtilSparseArrayCompat.get(this.jdField_a_of_type_Int) != null) || (this.jdField_a_of_type_Int == 0));
      this.jdField_a_of_type_AndroidSupportV4UtilSparseArrayCompat.put(this.jdField_a_of_type_Int, paramanrf);
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
      anrf localanrf = (anrf)this.jdField_a_of_type_AndroidSupportV4UtilSparseArrayCompat.get(paramInt1);
      if (localanrf != null) {
        localanrf.a(paramInt1, paramInt2);
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     anrt
 * JD-Core Version:    0.7.0.1
 */