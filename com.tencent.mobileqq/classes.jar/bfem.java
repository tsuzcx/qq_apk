import android.os.SystemClock;

class bfem
  implements bfbo
{
  long jdField_a_of_type_Long;
  
  bfem(bfel parambfel, bfdf parambfdf, long paramLong) {}
  
  public void a()
  {
    if (this.jdField_a_of_type_Bfdf != null) {}
    for (bfbq localbfbq = this.jdField_a_of_type_Bfdf.a();; localbfbq = null)
    {
      if ((localbfbq != null) && (localbfbq == this.jdField_a_of_type_Bfdf.b)) {
        this.jdField_a_of_type_Long = SystemClock.uptimeMillis();
      }
      if ((localbfbq != null) && (localbfbq == this.jdField_a_of_type_Bfdf.e)) {
        this.jdField_a_of_type_Bfel.a(this.jdField_a_of_type_Bfdf, this.b, SystemClock.uptimeMillis() - this.jdField_a_of_type_Long);
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     bfem
 * JD-Core Version:    0.7.0.1
 */