import android.os.SystemClock;
import com.tencent.mobileqq.highway.api.ITransactionCallback;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;

class ayov
  implements ITransactionCallback
{
  ayov(ayou paramayou, long paramLong) {}
  
  public void onFailed(int paramInt, byte[] paramArrayOfByte, HashMap<String, String> paramHashMap)
  {
    long l = SystemClock.uptimeMillis();
    this.jdField_a_of_type_Ayou.a(paramHashMap);
    if (QLog.isColorLevel()) {
      QLog.d("BDHCommonUploadProcessor", 2, "<BDH_LOG> Transaction End : Failed. New : SendTotalCost:" + (l - this.jdField_a_of_type_Long) + "ms");
    }
    this.jdField_a_of_type_Ayou.a.jdField_a_of_type_ArrayOfByte = paramArrayOfByte;
    this.jdField_a_of_type_Ayou.a(paramInt, "OnFailed.", "", this.jdField_a_of_type_Ayou.b);
    this.jdField_a_of_type_Ayou.d();
  }
  
  public void onSuccess(byte[] paramArrayOfByte, HashMap<String, String> paramHashMap)
  {
    long l = SystemClock.uptimeMillis();
    this.jdField_a_of_type_Ayou.a(paramHashMap);
    if (QLog.isColorLevel()) {
      QLog.d("BDHCommonUploadProcessor", 2, "<BDH_LOG> Transaction End : Success. New : SendTotalCost:" + (l - this.jdField_a_of_type_Long) + "ms ,fileSize:" + this.jdField_a_of_type_Ayou.a.jdField_a_of_type_Long);
    }
    this.jdField_a_of_type_Ayou.b.b();
    this.jdField_a_of_type_Ayou.b.a = 1;
    this.jdField_a_of_type_Ayou.s = this.jdField_a_of_type_Ayou.q;
    this.jdField_a_of_type_Ayou.a.jdField_a_of_type_ArrayOfByte = paramArrayOfByte;
    this.jdField_a_of_type_Ayou.e();
    this.jdField_a_of_type_Ayou.a.a();
  }
  
  public void onSwitch2BackupChannel() {}
  
  public void onTransStart()
  {
    if (QLog.isColorLevel()) {
      QLog.d("BDHCommonUploadProcessor", 2, "<BDH_LOG> onTransStart()");
    }
    this.jdField_a_of_type_Ayou.b.a();
  }
  
  public void onUpdateProgress(int paramInt)
  {
    ayou localayou = this.jdField_a_of_type_Ayou;
    ayqo localayqo = this.jdField_a_of_type_Ayou.a;
    long l = paramInt;
    localayqo.e = l;
    localayou.s = l;
    if ((paramInt < this.jdField_a_of_type_Ayou.q) && (!this.jdField_a_of_type_Ayou.o) && (!this.jdField_a_of_type_Ayou.k)) {
      this.jdField_a_of_type_Ayou.i();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     ayov
 * JD-Core Version:    0.7.0.1
 */