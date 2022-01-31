import android.os.Handler;
import android.os.Message;
import cooperation.qzone.QZoneLiveVideoDownLoadActivtyV2;

class amrz
  implements Runnable
{
  amrz(amry paramamry, float paramFloat) {}
  
  public void run()
  {
    if ((int)(this.jdField_a_of_type_Float * 100.0F) > 0)
    {
      this.jdField_a_of_type_Amry.a.a.removeMessages(1009);
      this.jdField_a_of_type_Amry.a.a.obtainMessage(1004, 100, 0).sendToTarget();
      this.jdField_a_of_type_Amry.a.a(false, true);
    }
    while (!this.jdField_a_of_type_Amry.a.e) {
      return;
    }
    this.jdField_a_of_type_Amry.a.a.removeMessages(1009);
    this.jdField_a_of_type_Amry.a.a(true, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     amrz
 * JD-Core Version:    0.7.0.1
 */