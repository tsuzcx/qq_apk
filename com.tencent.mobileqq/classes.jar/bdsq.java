import android.os.SystemClock;
import com.tencent.mobileqq.highway.api.ITransactionCallback;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;

class bdsq
  implements ITransactionCallback
{
  bdsq(bdsp parambdsp, long paramLong) {}
  
  public void onFailed(int paramInt, byte[] paramArrayOfByte, HashMap<String, String> paramHashMap)
  {
    long l = SystemClock.uptimeMillis();
    this.jdField_a_of_type_Bdsp.a(paramHashMap);
    if (QLog.isColorLevel()) {
      QLog.d("BDHCommonUploadProcessor", 2, "<BDH_LOG> Transaction End : Failed. New : SendTotalCost:" + (l - this.jdField_a_of_type_Long) + "ms");
    }
    this.jdField_a_of_type_Bdsp.a.jdField_a_of_type_ArrayOfByte = paramArrayOfByte;
    this.jdField_a_of_type_Bdsp.a(paramInt, "OnFailed.", "", this.jdField_a_of_type_Bdsp.b);
    this.jdField_a_of_type_Bdsp.d();
  }
  
  public void onSuccess(byte[] paramArrayOfByte, HashMap<String, String> paramHashMap)
  {
    long l = SystemClock.uptimeMillis();
    this.jdField_a_of_type_Bdsp.a(paramHashMap);
    if (QLog.isColorLevel()) {
      QLog.d("BDHCommonUploadProcessor", 2, "<BDH_LOG> Transaction End : Success. New : SendTotalCost:" + (l - this.jdField_a_of_type_Long) + "ms ,fileSize:" + this.jdField_a_of_type_Bdsp.a.jdField_a_of_type_Long);
    }
    this.jdField_a_of_type_Bdsp.b.b();
    this.jdField_a_of_type_Bdsp.b.a = 1;
    this.jdField_a_of_type_Bdsp.s = this.jdField_a_of_type_Bdsp.jdField_q_of_type_Long;
    this.jdField_a_of_type_Bdsp.a.jdField_a_of_type_ArrayOfByte = paramArrayOfByte;
    this.jdField_a_of_type_Bdsp.e();
    this.jdField_a_of_type_Bdsp.a.a();
  }
  
  public void onSwitch2BackupChannel() {}
  
  public void onTransStart()
  {
    if (QLog.isColorLevel()) {
      QLog.d("BDHCommonUploadProcessor", 2, "<BDH_LOG> onTransStart()");
    }
    this.jdField_a_of_type_Bdsp.b.a();
  }
  
  public void onUpdateProgress(int paramInt)
  {
    bdsp localbdsp = this.jdField_a_of_type_Bdsp;
    bduk localbduk = this.jdField_a_of_type_Bdsp.a;
    long l = paramInt;
    localbduk.e = l;
    localbdsp.s = l;
    if ((paramInt < this.jdField_a_of_type_Bdsp.jdField_q_of_type_Long) && (!this.jdField_a_of_type_Bdsp.jdField_q_of_type_Boolean) && (!this.jdField_a_of_type_Bdsp.m)) {
      this.jdField_a_of_type_Bdsp.j();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bdsq
 * JD-Core Version:    0.7.0.1
 */