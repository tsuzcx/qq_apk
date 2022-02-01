import android.content.Intent;
import com.tencent.qphone.base.util.QLog;

class axbw
  implements bdvw
{
  private Intent jdField_a_of_type_AndroidContentIntent;
  private byte[] jdField_a_of_type_ArrayOfByte;
  
  public axbw(axbv paramaxbv, Intent paramIntent, byte[] paramArrayOfByte)
  {
    this.jdField_a_of_type_AndroidContentIntent = paramIntent;
    this.jdField_a_of_type_ArrayOfByte = paramArrayOfByte;
  }
  
  public void onResp(bdwt parambdwt)
  {
    if (QLog.isColorLevel()) {
      QLog.i("NearbyAlumniServlet", 2, "NearbyAlumniDownloadListener.onResp()");
    }
    if ((parambdwt == null) || (parambdwt.jdField_a_of_type_Int != 0))
    {
      StringBuilder localStringBuilder;
      if (QLog.isColorLevel())
      {
        localStringBuilder = new StringBuilder().append("NearbyAlumniDownloadListener.onResp() | resp = ").append(parambdwt).append(" | mResult=");
        if (parambdwt == null) {
          break label110;
        }
      }
      label110:
      for (int i = parambdwt.jdField_a_of_type_Int;; i = -1)
      {
        QLog.i("NearbyAlumniServlet", 2, i);
        axbv.a(this.jdField_a_of_type_Axbv, this.jdField_a_of_type_AndroidContentIntent, -10, null, new byte[1]);
        parambdwt = this.jdField_a_of_type_Axbv.a();
        if (parambdwt != null) {
          parambdwt.a();
        }
        return;
      }
    }
    axbv.a(this.jdField_a_of_type_Axbv, this.jdField_a_of_type_AndroidContentIntent, 0, parambdwt.jdField_a_of_type_ArrayOfByte, this.jdField_a_of_type_ArrayOfByte);
  }
  
  public void onUpdateProgeress(bdws parambdws, long paramLong1, long paramLong2) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     axbw
 * JD-Core Version:    0.7.0.1
 */