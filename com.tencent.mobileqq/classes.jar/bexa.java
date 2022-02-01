import android.os.SystemClock;
import com.tencent.mobileqq.highway.api.ITransactionCallback;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;

class bexa
  implements ITransactionCallback
{
  bexa(bewz parambewz, long paramLong) {}
  
  public void onFailed(int paramInt, byte[] paramArrayOfByte, HashMap<String, String> paramHashMap)
  {
    long l = SystemClock.uptimeMillis();
    if (QLog.isColorLevel()) {
      QLog.d("ShareToWXUploadProcessor", 2, "<BDH_LOG> Transaction End : Failed. New : SendTotalCost:" + (l - this.jdField_a_of_type_Long) + "ms");
    }
    this.jdField_a_of_type_Bewz.a(paramInt, "OnFailed.", "", this.jdField_a_of_type_Bewz.b);
    this.jdField_a_of_type_Bewz.d();
  }
  
  public void onSuccess(byte[] paramArrayOfByte, HashMap<String, String> paramHashMap)
  {
    long l = SystemClock.uptimeMillis();
    if (QLog.isColorLevel()) {
      QLog.d("ShareToWXUploadProcessor", 2, "<BDH_LOG> Transaction End : Success. New : SendTotalCost:" + (l - this.jdField_a_of_type_Long));
    }
    this.jdField_a_of_type_Bewz.b.b();
    this.jdField_a_of_type_Bewz.b.a = 1;
    this.jdField_a_of_type_Bewz.s = this.jdField_a_of_type_Bewz.jdField_q_of_type_Long;
    this.jdField_a_of_type_Bewz.a.a = paramArrayOfByte;
    this.jdField_a_of_type_Bewz.e();
    this.jdField_a_of_type_Bewz.a.a();
  }
  
  public void onSwitch2BackupChannel() {}
  
  public void onTransStart()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ShareToWXUploadProcessor", 2, "<BDH_LOG> onTransStart()");
    }
    this.jdField_a_of_type_Bewz.b.a();
  }
  
  public void onUpdateProgress(int paramInt)
  {
    bewz localbewz = this.jdField_a_of_type_Bewz;
    bete localbete = this.jdField_a_of_type_Bewz.a;
    long l = paramInt;
    localbete.e = l;
    localbewz.s = l;
    if ((paramInt < this.jdField_a_of_type_Bewz.jdField_q_of_type_Long) && (!this.jdField_a_of_type_Bewz.jdField_q_of_type_Boolean) && (!this.jdField_a_of_type_Bewz.m)) {
      this.jdField_a_of_type_Bewz.j();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bexa
 * JD-Core Version:    0.7.0.1
 */