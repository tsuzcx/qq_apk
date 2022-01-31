import android.os.SystemClock;

class bhef
  implements bhay
{
  long jdField_a_of_type_Long;
  
  bhef(bhee parambhee, bhcv parambhcv, long paramLong) {}
  
  public void onStateChanged()
  {
    if (this.jdField_a_of_type_Bhcv != null) {}
    for (bhaz localbhaz = this.jdField_a_of_type_Bhcv.getCurrState();; localbhaz = null)
    {
      if ((localbhaz != null) && (localbhaz == this.jdField_a_of_type_Bhcv.b)) {
        this.jdField_a_of_type_Long = SystemClock.uptimeMillis();
      }
      if ((localbhaz != null) && (localbhaz == this.jdField_a_of_type_Bhcv.e)) {
        this.jdField_a_of_type_Bhee.a(this.jdField_a_of_type_Bhcv, this.b, SystemClock.uptimeMillis() - this.jdField_a_of_type_Long);
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bhef
 * JD-Core Version:    0.7.0.1
 */