import android.os.SystemClock;
import com.tencent.mobileqq.highway.api.ITransactionCallback;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;

class beri
  implements ITransactionCallback
{
  beri(berh paramberh, long paramLong) {}
  
  public void onFailed(int paramInt, byte[] paramArrayOfByte, HashMap<String, String> paramHashMap)
  {
    long l = SystemClock.uptimeMillis();
    this.jdField_a_of_type_Berh.a(paramHashMap);
    if (QLog.isColorLevel()) {
      QLog.d("BDHCommonUploadProcessor", 2, "<BDH_LOG> Transaction End : Failed. New : SendTotalCost:" + (l - this.jdField_a_of_type_Long) + "ms");
    }
    this.jdField_a_of_type_Berh.a.jdField_a_of_type_ArrayOfByte = paramArrayOfByte;
    this.jdField_a_of_type_Berh.a(paramInt, "OnFailed.", "", this.jdField_a_of_type_Berh.b);
    this.jdField_a_of_type_Berh.d();
  }
  
  public void onSuccess(byte[] paramArrayOfByte, HashMap<String, String> paramHashMap)
  {
    long l = SystemClock.uptimeMillis();
    this.jdField_a_of_type_Berh.a(paramHashMap);
    if (QLog.isColorLevel()) {
      QLog.d("BDHCommonUploadProcessor", 2, "<BDH_LOG> Transaction End : Success. New : SendTotalCost:" + (l - this.jdField_a_of_type_Long) + "ms ,fileSize:" + this.jdField_a_of_type_Berh.a.jdField_a_of_type_Long);
    }
    this.jdField_a_of_type_Berh.b.b();
    this.jdField_a_of_type_Berh.b.a = 1;
    this.jdField_a_of_type_Berh.s = this.jdField_a_of_type_Berh.jdField_q_of_type_Long;
    this.jdField_a_of_type_Berh.a.jdField_a_of_type_ArrayOfByte = paramArrayOfByte;
    this.jdField_a_of_type_Berh.e();
    this.jdField_a_of_type_Berh.a.a();
  }
  
  public void onSwitch2BackupChannel() {}
  
  public void onTransStart()
  {
    if (QLog.isColorLevel()) {
      QLog.d("BDHCommonUploadProcessor", 2, "<BDH_LOG> onTransStart()");
    }
    this.jdField_a_of_type_Berh.b.a();
  }
  
  public void onUpdateProgress(int paramInt)
  {
    berh localberh = this.jdField_a_of_type_Berh;
    bete localbete = this.jdField_a_of_type_Berh.a;
    long l = paramInt;
    localbete.e = l;
    localberh.s = l;
    if ((paramInt < this.jdField_a_of_type_Berh.jdField_q_of_type_Long) && (!this.jdField_a_of_type_Berh.jdField_q_of_type_Boolean) && (!this.jdField_a_of_type_Berh.m)) {
      this.jdField_a_of_type_Berh.j();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     beri
 * JD-Core Version:    0.7.0.1
 */