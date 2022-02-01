import android.content.Intent;
import com.tencent.qphone.base.util.QLog;

class axun
  implements beuq
{
  private Intent jdField_a_of_type_AndroidContentIntent;
  private byte[] jdField_a_of_type_ArrayOfByte;
  
  public axun(axum paramaxum, Intent paramIntent, byte[] paramArrayOfByte)
  {
    this.jdField_a_of_type_AndroidContentIntent = paramIntent;
    this.jdField_a_of_type_ArrayOfByte = paramArrayOfByte;
  }
  
  public void onResp(bevm parambevm)
  {
    if (QLog.isColorLevel()) {
      QLog.i("NearbyAlumniServlet", 2, "NearbyAlumniDownloadListener.onResp()");
    }
    if ((parambevm == null) || (parambevm.jdField_a_of_type_Int != 0))
    {
      StringBuilder localStringBuilder;
      if (QLog.isColorLevel())
      {
        localStringBuilder = new StringBuilder().append("NearbyAlumniDownloadListener.onResp() | resp = ").append(parambevm).append(" | mResult=");
        if (parambevm == null) {
          break label110;
        }
      }
      label110:
      for (int i = parambevm.jdField_a_of_type_Int;; i = -1)
      {
        QLog.i("NearbyAlumniServlet", 2, i);
        axum.a(this.jdField_a_of_type_Axum, this.jdField_a_of_type_AndroidContentIntent, -10, null, new byte[1]);
        parambevm = this.jdField_a_of_type_Axum.a();
        if (parambevm != null) {
          parambevm.a();
        }
        return;
      }
    }
    axum.a(this.jdField_a_of_type_Axum, this.jdField_a_of_type_AndroidContentIntent, 0, parambevm.jdField_a_of_type_ArrayOfByte, this.jdField_a_of_type_ArrayOfByte);
  }
  
  public void onUpdateProgeress(bevl parambevl, long paramLong1, long paramLong2) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     axun
 * JD-Core Version:    0.7.0.1
 */