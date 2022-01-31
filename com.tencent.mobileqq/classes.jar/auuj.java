import android.content.Intent;
import com.tencent.qphone.base.util.QLog;

class auuj
  implements baug
{
  private Intent jdField_a_of_type_AndroidContentIntent;
  private byte[] jdField_a_of_type_ArrayOfByte;
  
  public auuj(auui paramauui, Intent paramIntent, byte[] paramArrayOfByte)
  {
    this.jdField_a_of_type_AndroidContentIntent = paramIntent;
    this.jdField_a_of_type_ArrayOfByte = paramArrayOfByte;
  }
  
  public void onResp(bavf parambavf)
  {
    if (QLog.isColorLevel()) {
      QLog.i("NearbyAlumniServlet", 2, "NearbyAlumniDownloadListener.onResp()");
    }
    if ((parambavf == null) || (parambavf.jdField_a_of_type_Int != 0))
    {
      StringBuilder localStringBuilder;
      if (QLog.isColorLevel())
      {
        localStringBuilder = new StringBuilder().append("NearbyAlumniDownloadListener.onResp() | resp = ").append(parambavf).append(" | mResult=");
        if (parambavf == null) {
          break label110;
        }
      }
      label110:
      for (int i = parambavf.jdField_a_of_type_Int;; i = -1)
      {
        QLog.i("NearbyAlumniServlet", 2, i);
        auui.a(this.jdField_a_of_type_Auui, this.jdField_a_of_type_AndroidContentIntent, -10, null, new byte[1]);
        parambavf = this.jdField_a_of_type_Auui.a();
        if (parambavf != null) {
          parambavf.a();
        }
        return;
      }
    }
    auui.a(this.jdField_a_of_type_Auui, this.jdField_a_of_type_AndroidContentIntent, 0, parambavf.jdField_a_of_type_ArrayOfByte, this.jdField_a_of_type_ArrayOfByte);
  }
  
  public void onUpdateProgeress(bave parambave, long paramLong1, long paramLong2) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     auuj
 * JD-Core Version:    0.7.0.1
 */