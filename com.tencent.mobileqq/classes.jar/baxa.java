import android.os.SystemClock;
import com.tencent.mobileqq.highway.api.ITransactionCallback;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;

class baxa
  implements ITransactionCallback
{
  baxa(bawz parambawz, long paramLong) {}
  
  public void onFailed(int paramInt, byte[] paramArrayOfByte, HashMap<String, String> paramHashMap)
  {
    long l = SystemClock.uptimeMillis();
    if (QLog.isColorLevel()) {
      QLog.d("ShareToWXUploadProcessor", 2, "<BDH_LOG> Transaction End : Failed. New : SendTotalCost:" + (l - this.jdField_a_of_type_Long) + "ms");
    }
    this.jdField_a_of_type_Bawz.a(paramInt, "OnFailed.", "", this.jdField_a_of_type_Bawz.b);
    this.jdField_a_of_type_Bawz.d();
  }
  
  public void onSuccess(byte[] paramArrayOfByte, HashMap<String, String> paramHashMap)
  {
    long l = SystemClock.uptimeMillis();
    if (QLog.isColorLevel()) {
      QLog.d("ShareToWXUploadProcessor", 2, "<BDH_LOG> Transaction End : Success. New : SendTotalCost:" + (l - this.jdField_a_of_type_Long));
    }
    this.jdField_a_of_type_Bawz.b.b();
    this.jdField_a_of_type_Bawz.b.a = 1;
    this.jdField_a_of_type_Bawz.s = this.jdField_a_of_type_Bawz.q;
    this.jdField_a_of_type_Bawz.a.a = paramArrayOfByte;
    this.jdField_a_of_type_Bawz.e();
    this.jdField_a_of_type_Bawz.a.a();
  }
  
  public void onSwitch2BackupChannel() {}
  
  public void onTransStart()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ShareToWXUploadProcessor", 2, "<BDH_LOG> onTransStart()");
    }
    this.jdField_a_of_type_Bawz.b.a();
  }
  
  public void onUpdateProgress(int paramInt)
  {
    bawz localbawz = this.jdField_a_of_type_Bawz;
    bass localbass = this.jdField_a_of_type_Bawz.a;
    long l = paramInt;
    localbass.e = l;
    localbawz.s = l;
    if ((paramInt < this.jdField_a_of_type_Bawz.q) && (!this.jdField_a_of_type_Bawz.o) && (!this.jdField_a_of_type_Bawz.k)) {
      this.jdField_a_of_type_Bawz.i();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     baxa
 * JD-Core Version:    0.7.0.1
 */