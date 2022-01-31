import android.os.SystemClock;
import com.tencent.mobileqq.highway.api.ITransactionCallback;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;

class bamm
  implements ITransactionCallback
{
  bamm(baml parambaml) {}
  
  public void onFailed(int paramInt, byte[] paramArrayOfByte, HashMap<String, String> paramHashMap)
  {
    this.a.d = SystemClock.uptimeMillis();
    if (QLog.isColorLevel()) {
      QLog.d("ArtFilterUploadProcessor", 2, "<BDH_LOG> Transaction End : Failed. New : SendTotalCost:" + (this.a.d - this.a.c) + "ms");
    }
    this.a.jdField_a_of_type_Baoj.a = paramArrayOfByte;
    if (this.a.b != -1) {
      this.a.a(paramInt, "uploadImgError");
    }
  }
  
  public void onSuccess(byte[] paramArrayOfByte, HashMap<String, String> paramHashMap)
  {
    this.a.d = SystemClock.uptimeMillis();
    if (QLog.isColorLevel()) {
      QLog.d("ArtFilterUploadProcessor", 2, "<BDH_LOG> Transaction End : Success. New : SendTotalCost:" + (this.a.d - this.a.c) + "ms ,fileSize:" + this.a.q);
    }
    if (this.a.jdField_a_of_type_Wyp.b.equals(this.a.jdField_a_of_type_Wyr.a))
    {
      this.a.jdField_a_of_type_Wyp.a = this.a.d;
      if (this.a.b != -1) {
        this.a.aR_();
      }
    }
  }
  
  public void onSwitch2BackupChannel() {}
  
  public void onTransStart() {}
  
  public void onUpdateProgress(int paramInt) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bamm
 * JD-Core Version:    0.7.0.1
 */