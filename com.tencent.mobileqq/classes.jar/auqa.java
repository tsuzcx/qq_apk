import android.content.Intent;
import com.tencent.qphone.base.util.QLog;

class auqa
  implements bapx
{
  private Intent jdField_a_of_type_AndroidContentIntent;
  private byte[] jdField_a_of_type_ArrayOfByte;
  
  public auqa(aupz paramaupz, Intent paramIntent, byte[] paramArrayOfByte)
  {
    this.jdField_a_of_type_AndroidContentIntent = paramIntent;
    this.jdField_a_of_type_ArrayOfByte = paramArrayOfByte;
  }
  
  public void onResp(baqw parambaqw)
  {
    if (QLog.isColorLevel()) {
      QLog.i("NearbyAlumniServlet", 2, "NearbyAlumniDownloadListener.onResp()");
    }
    if ((parambaqw == null) || (parambaqw.jdField_a_of_type_Int != 0))
    {
      StringBuilder localStringBuilder;
      if (QLog.isColorLevel())
      {
        localStringBuilder = new StringBuilder().append("NearbyAlumniDownloadListener.onResp() | resp = ").append(parambaqw).append(" | mResult=");
        if (parambaqw == null) {
          break label110;
        }
      }
      label110:
      for (int i = parambaqw.jdField_a_of_type_Int;; i = -1)
      {
        QLog.i("NearbyAlumniServlet", 2, i);
        aupz.a(this.jdField_a_of_type_Aupz, this.jdField_a_of_type_AndroidContentIntent, -10, null, new byte[1]);
        parambaqw = this.jdField_a_of_type_Aupz.a();
        if (parambaqw != null) {
          parambaqw.a();
        }
        return;
      }
    }
    aupz.a(this.jdField_a_of_type_Aupz, this.jdField_a_of_type_AndroidContentIntent, 0, parambaqw.jdField_a_of_type_ArrayOfByte, this.jdField_a_of_type_ArrayOfByte);
  }
  
  public void onUpdateProgeress(baqv parambaqv, long paramLong1, long paramLong2) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     auqa
 * JD-Core Version:    0.7.0.1
 */