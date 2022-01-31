import android.os.SystemClock;
import com.tencent.mobileqq.highway.api.ITransactionCallback;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;

class bamq
  implements ITransactionCallback
{
  bamq(bamp parambamp, long paramLong) {}
  
  public void onFailed(int paramInt, byte[] paramArrayOfByte, HashMap<String, String> paramHashMap)
  {
    long l = SystemClock.uptimeMillis();
    this.jdField_a_of_type_Bamp.a(paramHashMap);
    if (QLog.isColorLevel()) {
      QLog.d("BDHCommonUploadProcessor", 2, "<BDH_LOG> Transaction End : Failed. New : SendTotalCost:" + (l - this.jdField_a_of_type_Long) + "ms");
    }
    this.jdField_a_of_type_Bamp.a.jdField_a_of_type_ArrayOfByte = paramArrayOfByte;
    this.jdField_a_of_type_Bamp.a(paramInt, "OnFailed.", "", this.jdField_a_of_type_Bamp.b);
    this.jdField_a_of_type_Bamp.d();
  }
  
  public void onSuccess(byte[] paramArrayOfByte, HashMap<String, String> paramHashMap)
  {
    long l = SystemClock.uptimeMillis();
    this.jdField_a_of_type_Bamp.a(paramHashMap);
    if (QLog.isColorLevel()) {
      QLog.d("BDHCommonUploadProcessor", 2, "<BDH_LOG> Transaction End : Success. New : SendTotalCost:" + (l - this.jdField_a_of_type_Long) + "ms ,fileSize:" + this.jdField_a_of_type_Bamp.a.jdField_a_of_type_Long);
    }
    this.jdField_a_of_type_Bamp.b.b();
    this.jdField_a_of_type_Bamp.b.a = 1;
    this.jdField_a_of_type_Bamp.s = this.jdField_a_of_type_Bamp.q;
    this.jdField_a_of_type_Bamp.a.jdField_a_of_type_ArrayOfByte = paramArrayOfByte;
    this.jdField_a_of_type_Bamp.e();
    this.jdField_a_of_type_Bamp.a.a();
  }
  
  public void onSwitch2BackupChannel() {}
  
  public void onTransStart()
  {
    if (QLog.isColorLevel()) {
      QLog.d("BDHCommonUploadProcessor", 2, "<BDH_LOG> onTransStart()");
    }
    this.jdField_a_of_type_Bamp.b.a();
  }
  
  public void onUpdateProgress(int paramInt)
  {
    bamp localbamp = this.jdField_a_of_type_Bamp;
    baoj localbaoj = this.jdField_a_of_type_Bamp.a;
    long l = paramInt;
    localbaoj.e = l;
    localbamp.s = l;
    if ((paramInt < this.jdField_a_of_type_Bamp.q) && (!this.jdField_a_of_type_Bamp.o) && (!this.jdField_a_of_type_Bamp.k)) {
      this.jdField_a_of_type_Bamp.i();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bamq
 * JD-Core Version:    0.7.0.1
 */