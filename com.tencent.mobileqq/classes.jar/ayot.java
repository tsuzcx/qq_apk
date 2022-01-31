import android.os.SystemClock;
import com.tencent.mobileqq.highway.api.ITransactionCallback;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;

class ayot
  implements ITransactionCallback
{
  ayot(ayos paramayos, long paramLong) {}
  
  public void onFailed(int paramInt, byte[] paramArrayOfByte, HashMap<String, String> paramHashMap)
  {
    long l = SystemClock.uptimeMillis();
    this.jdField_a_of_type_Ayos.a(paramHashMap);
    if (QLog.isColorLevel()) {
      QLog.d("BDHCommonUploadProcessor", 2, "<BDH_LOG> Transaction End : Failed. New : SendTotalCost:" + (l - this.jdField_a_of_type_Long) + "ms");
    }
    this.jdField_a_of_type_Ayos.a.jdField_a_of_type_ArrayOfByte = paramArrayOfByte;
    this.jdField_a_of_type_Ayos.a(paramInt, "OnFailed.", "", this.jdField_a_of_type_Ayos.b);
    this.jdField_a_of_type_Ayos.d();
  }
  
  public void onSuccess(byte[] paramArrayOfByte, HashMap<String, String> paramHashMap)
  {
    long l = SystemClock.uptimeMillis();
    this.jdField_a_of_type_Ayos.a(paramHashMap);
    if (QLog.isColorLevel()) {
      QLog.d("BDHCommonUploadProcessor", 2, "<BDH_LOG> Transaction End : Success. New : SendTotalCost:" + (l - this.jdField_a_of_type_Long) + "ms ,fileSize:" + this.jdField_a_of_type_Ayos.a.jdField_a_of_type_Long);
    }
    this.jdField_a_of_type_Ayos.b.b();
    this.jdField_a_of_type_Ayos.b.a = 1;
    this.jdField_a_of_type_Ayos.s = this.jdField_a_of_type_Ayos.q;
    this.jdField_a_of_type_Ayos.a.jdField_a_of_type_ArrayOfByte = paramArrayOfByte;
    this.jdField_a_of_type_Ayos.e();
    this.jdField_a_of_type_Ayos.a.a();
  }
  
  public void onSwitch2BackupChannel() {}
  
  public void onTransStart()
  {
    if (QLog.isColorLevel()) {
      QLog.d("BDHCommonUploadProcessor", 2, "<BDH_LOG> onTransStart()");
    }
    this.jdField_a_of_type_Ayos.b.a();
  }
  
  public void onUpdateProgress(int paramInt)
  {
    ayos localayos = this.jdField_a_of_type_Ayos;
    ayqm localayqm = this.jdField_a_of_type_Ayos.a;
    long l = paramInt;
    localayqm.e = l;
    localayos.s = l;
    if ((paramInt < this.jdField_a_of_type_Ayos.q) && (!this.jdField_a_of_type_Ayos.o) && (!this.jdField_a_of_type_Ayos.k)) {
      this.jdField_a_of_type_Ayos.i();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     ayot
 * JD-Core Version:    0.7.0.1
 */