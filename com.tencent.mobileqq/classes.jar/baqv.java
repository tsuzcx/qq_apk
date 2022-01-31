import android.os.SystemClock;
import com.tencent.mobileqq.highway.api.ITransactionCallback;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;

class baqv
  implements ITransactionCallback
{
  baqv(baqu parambaqu) {}
  
  public void onFailed(int paramInt, byte[] paramArrayOfByte, HashMap<String, String> paramHashMap)
  {
    this.a.d = SystemClock.uptimeMillis();
    if (QLog.isColorLevel()) {
      QLog.d("ArtFilterUploadProcessor", 2, "<BDH_LOG> Transaction End : Failed. New : SendTotalCost:" + (this.a.d - this.a.c) + "ms");
    }
    this.a.jdField_a_of_type_Bass.a = paramArrayOfByte;
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
    if (this.a.jdField_a_of_type_Xcy.b.equals(this.a.jdField_a_of_type_Xda.a))
    {
      this.a.jdField_a_of_type_Xcy.a = this.a.d;
      if (this.a.b != -1) {
        this.a.aO_();
      }
    }
  }
  
  public void onSwitch2BackupChannel() {}
  
  public void onTransStart() {}
  
  public void onUpdateProgress(int paramInt) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     baqv
 * JD-Core Version:    0.7.0.1
 */