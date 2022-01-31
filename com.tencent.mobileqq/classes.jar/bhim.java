import android.os.SystemClock;

class bhim
  implements bhff
{
  long jdField_a_of_type_Long;
  
  bhim(bhil parambhil, bhhc parambhhc, long paramLong) {}
  
  public void onStateChanged()
  {
    if (this.jdField_a_of_type_Bhhc != null) {}
    for (bhfg localbhfg = this.jdField_a_of_type_Bhhc.getCurrState();; localbhfg = null)
    {
      if ((localbhfg != null) && (localbhfg == this.jdField_a_of_type_Bhhc.b)) {
        this.jdField_a_of_type_Long = SystemClock.uptimeMillis();
      }
      if ((localbhfg != null) && (localbhfg == this.jdField_a_of_type_Bhhc.e)) {
        this.jdField_a_of_type_Bhil.a(this.jdField_a_of_type_Bhhc, this.b, SystemClock.uptimeMillis() - this.jdField_a_of_type_Long);
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bhim
 * JD-Core Version:    0.7.0.1
 */