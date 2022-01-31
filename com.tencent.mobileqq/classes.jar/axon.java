import android.os.SystemClock;
import com.tencent.mobileqq.highway.api.ITransactionCallback;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;

class axon
  implements ITransactionCallback
{
  axon(axom paramaxom, long paramLong) {}
  
  public void onFailed(int paramInt, byte[] paramArrayOfByte, HashMap<String, String> paramHashMap)
  {
    long l = SystemClock.uptimeMillis();
    this.jdField_a_of_type_Axom.a(paramHashMap);
    if (QLog.isColorLevel()) {
      QLog.d("BDHCommonUploadProcessor", 2, "<BDH_LOG> Transaction End : Failed. New : SendTotalCost:" + (l - this.jdField_a_of_type_Long) + "ms");
    }
    this.jdField_a_of_type_Axom.a.jdField_a_of_type_ArrayOfByte = paramArrayOfByte;
    this.jdField_a_of_type_Axom.a(paramInt, "OnFailed.", "", this.jdField_a_of_type_Axom.b);
    this.jdField_a_of_type_Axom.d();
  }
  
  public void onSuccess(byte[] paramArrayOfByte, HashMap<String, String> paramHashMap)
  {
    long l = SystemClock.uptimeMillis();
    this.jdField_a_of_type_Axom.a(paramHashMap);
    if (QLog.isColorLevel()) {
      QLog.d("BDHCommonUploadProcessor", 2, "<BDH_LOG> Transaction End : Success. New : SendTotalCost:" + (l - this.jdField_a_of_type_Long) + "ms ,fileSize:" + this.jdField_a_of_type_Axom.a.jdField_a_of_type_Long);
    }
    this.jdField_a_of_type_Axom.b.b();
    this.jdField_a_of_type_Axom.b.a = 1;
    this.jdField_a_of_type_Axom.s = this.jdField_a_of_type_Axom.q;
    this.jdField_a_of_type_Axom.a.jdField_a_of_type_ArrayOfByte = paramArrayOfByte;
    this.jdField_a_of_type_Axom.e();
    this.jdField_a_of_type_Axom.a.a();
  }
  
  public void onSwitch2BackupChannel() {}
  
  public void onTransStart()
  {
    if (QLog.isColorLevel()) {
      QLog.d("BDHCommonUploadProcessor", 2, "<BDH_LOG> onTransStart()");
    }
    this.jdField_a_of_type_Axom.b.a();
  }
  
  public void onUpdateProgress(int paramInt)
  {
    axom localaxom = this.jdField_a_of_type_Axom;
    axqf localaxqf = this.jdField_a_of_type_Axom.a;
    long l = paramInt;
    localaxqf.e = l;
    localaxom.s = l;
    if ((paramInt < this.jdField_a_of_type_Axom.q) && (!this.jdField_a_of_type_Axom.o) && (!this.jdField_a_of_type_Axom.k)) {
      this.jdField_a_of_type_Axom.i();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     axon
 * JD-Core Version:    0.7.0.1
 */