import android.os.SystemClock;
import com.tencent.mobileqq.highway.api.ITransactionCallback;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;

class ayus
  implements ITransactionCallback
{
  ayus(ayur paramayur, long paramLong) {}
  
  public void onFailed(int paramInt, byte[] paramArrayOfByte, HashMap<String, String> paramHashMap)
  {
    long l = SystemClock.uptimeMillis();
    if (QLog.isColorLevel()) {
      QLog.d("ShareToWXUploadProcessor", 2, "<BDH_LOG> Transaction End : Failed. New : SendTotalCost:" + (l - this.jdField_a_of_type_Long) + "ms");
    }
    this.jdField_a_of_type_Ayur.a(paramInt, "OnFailed.", "", this.jdField_a_of_type_Ayur.b);
    this.jdField_a_of_type_Ayur.d();
  }
  
  public void onSuccess(byte[] paramArrayOfByte, HashMap<String, String> paramHashMap)
  {
    long l = SystemClock.uptimeMillis();
    if (QLog.isColorLevel()) {
      QLog.d("ShareToWXUploadProcessor", 2, "<BDH_LOG> Transaction End : Success. New : SendTotalCost:" + (l - this.jdField_a_of_type_Long));
    }
    this.jdField_a_of_type_Ayur.b.b();
    this.jdField_a_of_type_Ayur.b.a = 1;
    this.jdField_a_of_type_Ayur.s = this.jdField_a_of_type_Ayur.q;
    this.jdField_a_of_type_Ayur.a.a = paramArrayOfByte;
    this.jdField_a_of_type_Ayur.e();
    this.jdField_a_of_type_Ayur.a.a();
  }
  
  public void onSwitch2BackupChannel() {}
  
  public void onTransStart()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ShareToWXUploadProcessor", 2, "<BDH_LOG> onTransStart()");
    }
    this.jdField_a_of_type_Ayur.b.a();
  }
  
  public void onUpdateProgress(int paramInt)
  {
    ayur localayur = this.jdField_a_of_type_Ayur;
    ayqo localayqo = this.jdField_a_of_type_Ayur.a;
    long l = paramInt;
    localayqo.e = l;
    localayur.s = l;
    if ((paramInt < this.jdField_a_of_type_Ayur.q) && (!this.jdField_a_of_type_Ayur.o) && (!this.jdField_a_of_type_Ayur.k)) {
      this.jdField_a_of_type_Ayur.i();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     ayus
 * JD-Core Version:    0.7.0.1
 */