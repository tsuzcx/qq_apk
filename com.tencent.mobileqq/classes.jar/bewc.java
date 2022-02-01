import android.os.SystemClock;
import com.tencent.mobileqq.highway.api.ITransactionCallback;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.HashMap;

class bewc
  implements ITransactionCallback
{
  bewc(bewb parambewb, long paramLong) {}
  
  public void onFailed(int paramInt, byte[] paramArrayOfByte, HashMap<String, String> paramHashMap)
  {
    long l = SystemClock.uptimeMillis();
    if (QLog.isColorLevel()) {
      QLog.d("PttSliceUploadProcessor", 2, "<BDH_LOG> Transaction End : Failed. New : SendTotalCost:" + (l - this.jdField_a_of_type_Long) + "ms retCode=" + paramInt);
    }
    if ((bewb.a(this.jdField_a_of_type_Bewb) != null) && (bewb.a(this.jdField_a_of_type_Bewb).b != null)) {
      new File(bewb.a(this.jdField_a_of_type_Bewb).b).delete();
    }
    this.jdField_a_of_type_Bewb.d(2005);
    this.jdField_a_of_type_Bewb.a.a = paramArrayOfByte;
    this.jdField_a_of_type_Bewb.a(paramInt, "OnFailed.", "", this.jdField_a_of_type_Bewb.b);
    this.jdField_a_of_type_Bewb.d();
  }
  
  public void onSuccess(byte[] paramArrayOfByte, HashMap<String, String> paramHashMap)
  {
    long l = SystemClock.uptimeMillis();
    if (QLog.isColorLevel()) {
      QLog.d("PttSliceUploadProcessor", 2, "onSuccess SendTotalCost:" + (l - this.jdField_a_of_type_Long) + "ms");
    }
    if ((bewb.a(this.jdField_a_of_type_Bewb) != null) && (bewb.a(this.jdField_a_of_type_Bewb).b != null)) {
      new File(bewb.a(this.jdField_a_of_type_Bewb).b).delete();
    }
    bewb.a(this.jdField_a_of_type_Bewb, paramArrayOfByte);
  }
  
  public void onSwitch2BackupChannel() {}
  
  public void onTransStart()
  {
    if (QLog.isColorLevel()) {
      QLog.d("PttSliceUploadProcessor", 2, "<BDH_LOG> onTransStart()");
    }
    this.jdField_a_of_type_Bewb.b.a();
  }
  
  public void onUpdateProgress(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("PttSliceUploadProcessor", 2, "onUpdateProgress transferedSize:" + paramInt);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bewc
 * JD-Core Version:    0.7.0.1
 */