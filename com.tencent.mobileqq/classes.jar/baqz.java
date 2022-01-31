import android.os.SystemClock;
import com.tencent.mobileqq.highway.api.ITransactionCallback;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;

class baqz
  implements ITransactionCallback
{
  baqz(baqy parambaqy, long paramLong) {}
  
  public void onFailed(int paramInt, byte[] paramArrayOfByte, HashMap<String, String> paramHashMap)
  {
    long l = SystemClock.uptimeMillis();
    this.jdField_a_of_type_Baqy.a(paramHashMap);
    if (QLog.isColorLevel()) {
      QLog.d("BDHCommonUploadProcessor", 2, "<BDH_LOG> Transaction End : Failed. New : SendTotalCost:" + (l - this.jdField_a_of_type_Long) + "ms");
    }
    this.jdField_a_of_type_Baqy.a.jdField_a_of_type_ArrayOfByte = paramArrayOfByte;
    this.jdField_a_of_type_Baqy.a(paramInt, "OnFailed.", "", this.jdField_a_of_type_Baqy.b);
    this.jdField_a_of_type_Baqy.d();
  }
  
  public void onSuccess(byte[] paramArrayOfByte, HashMap<String, String> paramHashMap)
  {
    long l = SystemClock.uptimeMillis();
    this.jdField_a_of_type_Baqy.a(paramHashMap);
    if (QLog.isColorLevel()) {
      QLog.d("BDHCommonUploadProcessor", 2, "<BDH_LOG> Transaction End : Success. New : SendTotalCost:" + (l - this.jdField_a_of_type_Long) + "ms ,fileSize:" + this.jdField_a_of_type_Baqy.a.jdField_a_of_type_Long);
    }
    this.jdField_a_of_type_Baqy.b.b();
    this.jdField_a_of_type_Baqy.b.a = 1;
    this.jdField_a_of_type_Baqy.s = this.jdField_a_of_type_Baqy.q;
    this.jdField_a_of_type_Baqy.a.jdField_a_of_type_ArrayOfByte = paramArrayOfByte;
    this.jdField_a_of_type_Baqy.e();
    this.jdField_a_of_type_Baqy.a.a();
  }
  
  public void onSwitch2BackupChannel() {}
  
  public void onTransStart()
  {
    if (QLog.isColorLevel()) {
      QLog.d("BDHCommonUploadProcessor", 2, "<BDH_LOG> onTransStart()");
    }
    this.jdField_a_of_type_Baqy.b.a();
  }
  
  public void onUpdateProgress(int paramInt)
  {
    baqy localbaqy = this.jdField_a_of_type_Baqy;
    bass localbass = this.jdField_a_of_type_Baqy.a;
    long l = paramInt;
    localbass.e = l;
    localbaqy.s = l;
    if ((paramInt < this.jdField_a_of_type_Baqy.q) && (!this.jdField_a_of_type_Baqy.o) && (!this.jdField_a_of_type_Baqy.k)) {
      this.jdField_a_of_type_Baqy.i();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     baqz
 * JD-Core Version:    0.7.0.1
 */