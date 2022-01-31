import android.content.Intent;
import com.tencent.qphone.base.util.QLog;

class aszd
  implements aysc
{
  private Intent jdField_a_of_type_AndroidContentIntent;
  private byte[] jdField_a_of_type_ArrayOfByte;
  
  public aszd(aszc paramaszc, Intent paramIntent, byte[] paramArrayOfByte)
  {
    this.jdField_a_of_type_AndroidContentIntent = paramIntent;
    this.jdField_a_of_type_ArrayOfByte = paramArrayOfByte;
  }
  
  public void onResp(aysz paramaysz)
  {
    if (QLog.isColorLevel()) {
      QLog.i("NearbyAlumniServlet", 2, "NearbyAlumniDownloadListener.onResp()");
    }
    if ((paramaysz == null) || (paramaysz.jdField_a_of_type_Int != 0))
    {
      StringBuilder localStringBuilder;
      if (QLog.isColorLevel())
      {
        localStringBuilder = new StringBuilder().append("NearbyAlumniDownloadListener.onResp() | resp = ").append(paramaysz).append(" | mResult=");
        if (paramaysz == null) {
          break label110;
        }
      }
      label110:
      for (int i = paramaysz.jdField_a_of_type_Int;; i = -1)
      {
        QLog.i("NearbyAlumniServlet", 2, i);
        aszc.a(this.jdField_a_of_type_Aszc, this.jdField_a_of_type_AndroidContentIntent, -10, null, new byte[1]);
        paramaysz = this.jdField_a_of_type_Aszc.a();
        if (paramaysz != null) {
          paramaysz.a();
        }
        return;
      }
    }
    aszc.a(this.jdField_a_of_type_Aszc, this.jdField_a_of_type_AndroidContentIntent, 0, paramaysz.jdField_a_of_type_ArrayOfByte, this.jdField_a_of_type_ArrayOfByte);
  }
  
  public void onUpdateProgeress(aysy paramaysy, long paramLong1, long paramLong2) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aszd
 * JD-Core Version:    0.7.0.1
 */