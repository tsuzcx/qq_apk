import android.os.SystemClock;

class bfdt
  implements bfax
{
  long jdField_a_of_type_Long;
  
  bfdt(bfds parambfds, bfco parambfco, long paramLong) {}
  
  public void a()
  {
    if (this.jdField_a_of_type_Bfco != null) {}
    for (bfaz localbfaz = this.jdField_a_of_type_Bfco.a();; localbfaz = null)
    {
      if ((localbfaz != null) && (localbfaz == this.jdField_a_of_type_Bfco.b)) {
        this.jdField_a_of_type_Long = SystemClock.uptimeMillis();
      }
      if ((localbfaz != null) && (localbfaz == this.jdField_a_of_type_Bfco.e)) {
        this.jdField_a_of_type_Bfds.a(this.jdField_a_of_type_Bfco, this.b, SystemClock.uptimeMillis() - this.jdField_a_of_type_Long);
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     bfdt
 * JD-Core Version:    0.7.0.1
 */