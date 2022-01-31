import android.content.Intent;
import com.tencent.qphone.base.util.QLog;

class aszb
  implements aysa
{
  private Intent jdField_a_of_type_AndroidContentIntent;
  private byte[] jdField_a_of_type_ArrayOfByte;
  
  public aszb(asza paramasza, Intent paramIntent, byte[] paramArrayOfByte)
  {
    this.jdField_a_of_type_AndroidContentIntent = paramIntent;
    this.jdField_a_of_type_ArrayOfByte = paramArrayOfByte;
  }
  
  public void onResp(aysx paramaysx)
  {
    if (QLog.isColorLevel()) {
      QLog.i("NearbyAlumniServlet", 2, "NearbyAlumniDownloadListener.onResp()");
    }
    if ((paramaysx == null) || (paramaysx.jdField_a_of_type_Int != 0))
    {
      StringBuilder localStringBuilder;
      if (QLog.isColorLevel())
      {
        localStringBuilder = new StringBuilder().append("NearbyAlumniDownloadListener.onResp() | resp = ").append(paramaysx).append(" | mResult=");
        if (paramaysx == null) {
          break label110;
        }
      }
      label110:
      for (int i = paramaysx.jdField_a_of_type_Int;; i = -1)
      {
        QLog.i("NearbyAlumniServlet", 2, i);
        asza.a(this.jdField_a_of_type_Asza, this.jdField_a_of_type_AndroidContentIntent, -10, null, new byte[1]);
        paramaysx = this.jdField_a_of_type_Asza.a();
        if (paramaysx != null) {
          paramaysx.a();
        }
        return;
      }
    }
    asza.a(this.jdField_a_of_type_Asza, this.jdField_a_of_type_AndroidContentIntent, 0, paramaysx.jdField_a_of_type_ArrayOfByte, this.jdField_a_of_type_ArrayOfByte);
  }
  
  public void onUpdateProgeress(aysw paramaysw, long paramLong1, long paramLong2) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aszb
 * JD-Core Version:    0.7.0.1
 */