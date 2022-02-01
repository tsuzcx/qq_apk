import android.os.SystemClock;
import com.tencent.mobileqq.highway.api.ITransactionCallback;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;

class bdyh
  implements ITransactionCallback
{
  bdyh(bdyg parambdyg, long paramLong) {}
  
  public void onFailed(int paramInt, byte[] paramArrayOfByte, HashMap<String, String> paramHashMap)
  {
    long l = SystemClock.uptimeMillis();
    if (QLog.isColorLevel()) {
      QLog.d("ShareToWXUploadProcessor", 2, "<BDH_LOG> Transaction End : Failed. New : SendTotalCost:" + (l - this.jdField_a_of_type_Long) + "ms");
    }
    this.jdField_a_of_type_Bdyg.a(paramInt, "OnFailed.", "", this.jdField_a_of_type_Bdyg.b);
    this.jdField_a_of_type_Bdyg.d();
  }
  
  public void onSuccess(byte[] paramArrayOfByte, HashMap<String, String> paramHashMap)
  {
    long l = SystemClock.uptimeMillis();
    if (QLog.isColorLevel()) {
      QLog.d("ShareToWXUploadProcessor", 2, "<BDH_LOG> Transaction End : Success. New : SendTotalCost:" + (l - this.jdField_a_of_type_Long));
    }
    this.jdField_a_of_type_Bdyg.b.b();
    this.jdField_a_of_type_Bdyg.b.a = 1;
    this.jdField_a_of_type_Bdyg.s = this.jdField_a_of_type_Bdyg.jdField_q_of_type_Long;
    this.jdField_a_of_type_Bdyg.a.a = paramArrayOfByte;
    this.jdField_a_of_type_Bdyg.e();
    this.jdField_a_of_type_Bdyg.a.a();
  }
  
  public void onSwitch2BackupChannel() {}
  
  public void onTransStart()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ShareToWXUploadProcessor", 2, "<BDH_LOG> onTransStart()");
    }
    this.jdField_a_of_type_Bdyg.b.a();
  }
  
  public void onUpdateProgress(int paramInt)
  {
    bdyg localbdyg = this.jdField_a_of_type_Bdyg;
    bduk localbduk = this.jdField_a_of_type_Bdyg.a;
    long l = paramInt;
    localbduk.e = l;
    localbdyg.s = l;
    if ((paramInt < this.jdField_a_of_type_Bdyg.jdField_q_of_type_Long) && (!this.jdField_a_of_type_Bdyg.jdField_q_of_type_Boolean) && (!this.jdField_a_of_type_Bdyg.m)) {
      this.jdField_a_of_type_Bdyg.j();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bdyh
 * JD-Core Version:    0.7.0.1
 */