import android.os.SystemClock;
import com.tencent.mobileqq.highway.api.ITransactionCallback;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;

class ayuq
  implements ITransactionCallback
{
  ayuq(ayup paramayup, long paramLong) {}
  
  public void onFailed(int paramInt, byte[] paramArrayOfByte, HashMap<String, String> paramHashMap)
  {
    long l = SystemClock.uptimeMillis();
    if (QLog.isColorLevel()) {
      QLog.d("ShareToWXUploadProcessor", 2, "<BDH_LOG> Transaction End : Failed. New : SendTotalCost:" + (l - this.jdField_a_of_type_Long) + "ms");
    }
    this.jdField_a_of_type_Ayup.a(paramInt, "OnFailed.", "", this.jdField_a_of_type_Ayup.b);
    this.jdField_a_of_type_Ayup.d();
  }
  
  public void onSuccess(byte[] paramArrayOfByte, HashMap<String, String> paramHashMap)
  {
    long l = SystemClock.uptimeMillis();
    if (QLog.isColorLevel()) {
      QLog.d("ShareToWXUploadProcessor", 2, "<BDH_LOG> Transaction End : Success. New : SendTotalCost:" + (l - this.jdField_a_of_type_Long));
    }
    this.jdField_a_of_type_Ayup.b.b();
    this.jdField_a_of_type_Ayup.b.a = 1;
    this.jdField_a_of_type_Ayup.s = this.jdField_a_of_type_Ayup.q;
    this.jdField_a_of_type_Ayup.a.a = paramArrayOfByte;
    this.jdField_a_of_type_Ayup.e();
    this.jdField_a_of_type_Ayup.a.a();
  }
  
  public void onSwitch2BackupChannel() {}
  
  public void onTransStart()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ShareToWXUploadProcessor", 2, "<BDH_LOG> onTransStart()");
    }
    this.jdField_a_of_type_Ayup.b.a();
  }
  
  public void onUpdateProgress(int paramInt)
  {
    ayup localayup = this.jdField_a_of_type_Ayup;
    ayqm localayqm = this.jdField_a_of_type_Ayup.a;
    long l = paramInt;
    localayqm.e = l;
    localayup.s = l;
    if ((paramInt < this.jdField_a_of_type_Ayup.q) && (!this.jdField_a_of_type_Ayup.o) && (!this.jdField_a_of_type_Ayup.k)) {
      this.jdField_a_of_type_Ayup.i();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     ayuq
 * JD-Core Version:    0.7.0.1
 */