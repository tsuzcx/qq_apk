import android.os.SystemClock;
import com.tencent.mobileqq.highway.api.ITransactionCallback;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;

class basr
  implements ITransactionCallback
{
  basr(basq parambasq, long paramLong) {}
  
  public void onFailed(int paramInt, byte[] paramArrayOfByte, HashMap<String, String> paramHashMap)
  {
    long l = SystemClock.uptimeMillis();
    if (QLog.isColorLevel()) {
      QLog.d("ShareToWXUploadProcessor", 2, "<BDH_LOG> Transaction End : Failed. New : SendTotalCost:" + (l - this.jdField_a_of_type_Long) + "ms");
    }
    this.jdField_a_of_type_Basq.a(paramInt, "OnFailed.", "", this.jdField_a_of_type_Basq.b);
    this.jdField_a_of_type_Basq.d();
  }
  
  public void onSuccess(byte[] paramArrayOfByte, HashMap<String, String> paramHashMap)
  {
    long l = SystemClock.uptimeMillis();
    if (QLog.isColorLevel()) {
      QLog.d("ShareToWXUploadProcessor", 2, "<BDH_LOG> Transaction End : Success. New : SendTotalCost:" + (l - this.jdField_a_of_type_Long));
    }
    this.jdField_a_of_type_Basq.b.b();
    this.jdField_a_of_type_Basq.b.a = 1;
    this.jdField_a_of_type_Basq.s = this.jdField_a_of_type_Basq.q;
    this.jdField_a_of_type_Basq.a.a = paramArrayOfByte;
    this.jdField_a_of_type_Basq.e();
    this.jdField_a_of_type_Basq.a.a();
  }
  
  public void onSwitch2BackupChannel() {}
  
  public void onTransStart()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ShareToWXUploadProcessor", 2, "<BDH_LOG> onTransStart()");
    }
    this.jdField_a_of_type_Basq.b.a();
  }
  
  public void onUpdateProgress(int paramInt)
  {
    basq localbasq = this.jdField_a_of_type_Basq;
    baoj localbaoj = this.jdField_a_of_type_Basq.a;
    long l = paramInt;
    localbaoj.e = l;
    localbasq.s = l;
    if ((paramInt < this.jdField_a_of_type_Basq.q) && (!this.jdField_a_of_type_Basq.o) && (!this.jdField_a_of_type_Basq.k)) {
      this.jdField_a_of_type_Basq.i();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     basr
 * JD-Core Version:    0.7.0.1
 */