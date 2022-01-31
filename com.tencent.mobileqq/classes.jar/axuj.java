import android.os.SystemClock;
import com.tencent.mobileqq.highway.api.ITransactionCallback;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;

class axuj
  implements ITransactionCallback
{
  axuj(axui paramaxui, long paramLong) {}
  
  public void onFailed(int paramInt, byte[] paramArrayOfByte, HashMap<String, String> paramHashMap)
  {
    long l = SystemClock.uptimeMillis();
    if (QLog.isColorLevel()) {
      QLog.d("ShareToWXUploadProcessor", 2, "<BDH_LOG> Transaction End : Failed. New : SendTotalCost:" + (l - this.jdField_a_of_type_Long) + "ms");
    }
    this.jdField_a_of_type_Axui.a(paramInt, "OnFailed.", "", this.jdField_a_of_type_Axui.b);
    this.jdField_a_of_type_Axui.d();
  }
  
  public void onSuccess(byte[] paramArrayOfByte, HashMap<String, String> paramHashMap)
  {
    long l = SystemClock.uptimeMillis();
    if (QLog.isColorLevel()) {
      QLog.d("ShareToWXUploadProcessor", 2, "<BDH_LOG> Transaction End : Success. New : SendTotalCost:" + (l - this.jdField_a_of_type_Long));
    }
    this.jdField_a_of_type_Axui.b.b();
    this.jdField_a_of_type_Axui.b.a = 1;
    this.jdField_a_of_type_Axui.s = this.jdField_a_of_type_Axui.q;
    this.jdField_a_of_type_Axui.a.a = paramArrayOfByte;
    this.jdField_a_of_type_Axui.e();
    this.jdField_a_of_type_Axui.a.a();
  }
  
  public void onSwitch2BackupChannel() {}
  
  public void onTransStart()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ShareToWXUploadProcessor", 2, "<BDH_LOG> onTransStart()");
    }
    this.jdField_a_of_type_Axui.b.a();
  }
  
  public void onUpdateProgress(int paramInt)
  {
    axui localaxui = this.jdField_a_of_type_Axui;
    axqf localaxqf = this.jdField_a_of_type_Axui.a;
    long l = paramInt;
    localaxqf.e = l;
    localaxui.s = l;
    if ((paramInt < this.jdField_a_of_type_Axui.q) && (!this.jdField_a_of_type_Axui.o) && (!this.jdField_a_of_type_Axui.k)) {
      this.jdField_a_of_type_Axui.i();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     axuj
 * JD-Core Version:    0.7.0.1
 */