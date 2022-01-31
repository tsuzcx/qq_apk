import android.content.Intent;
import com.tencent.qphone.base.util.QLog;

class ascx
  implements axrt
{
  private Intent jdField_a_of_type_AndroidContentIntent;
  private byte[] jdField_a_of_type_ArrayOfByte;
  
  public ascx(ascw paramascw, Intent paramIntent, byte[] paramArrayOfByte)
  {
    this.jdField_a_of_type_AndroidContentIntent = paramIntent;
    this.jdField_a_of_type_ArrayOfByte = paramArrayOfByte;
  }
  
  public void onResp(axsq paramaxsq)
  {
    if (QLog.isColorLevel()) {
      QLog.i("NearbyAlumniServlet", 2, "NearbyAlumniDownloadListener.onResp()");
    }
    if ((paramaxsq == null) || (paramaxsq.jdField_a_of_type_Int != 0))
    {
      StringBuilder localStringBuilder;
      if (QLog.isColorLevel())
      {
        localStringBuilder = new StringBuilder().append("NearbyAlumniDownloadListener.onResp() | resp = ").append(paramaxsq).append(" | mResult=");
        if (paramaxsq == null) {
          break label110;
        }
      }
      label110:
      for (int i = paramaxsq.jdField_a_of_type_Int;; i = -1)
      {
        QLog.i("NearbyAlumniServlet", 2, i);
        ascw.a(this.jdField_a_of_type_Ascw, this.jdField_a_of_type_AndroidContentIntent, -10, null, new byte[1]);
        paramaxsq = this.jdField_a_of_type_Ascw.a();
        if (paramaxsq != null) {
          paramaxsq.a();
        }
        return;
      }
    }
    ascw.a(this.jdField_a_of_type_Ascw, this.jdField_a_of_type_AndroidContentIntent, 0, paramaxsq.jdField_a_of_type_ArrayOfByte, this.jdField_a_of_type_ArrayOfByte);
  }
  
  public void onUpdateProgeress(axsp paramaxsp, long paramLong1, long paramLong2) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     ascx
 * JD-Core Version:    0.7.0.1
 */