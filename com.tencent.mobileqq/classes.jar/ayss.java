import com.tencent.mobileqq.highway.api.ITransactionCallback;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.HashMap;

class ayss
  implements ITransactionCallback
{
  ayss(aysr paramaysr) {}
  
  public void onFailed(int paramInt, byte[] paramArrayOfByte, HashMap<String, String> paramHashMap)
  {
    if (QLog.isColorLevel()) {
      QLog.i("TAG_MultiMsg", 2, "BDH.Upload fail  : result:" + paramInt);
    }
    this.a.d();
  }
  
  public void onSuccess(byte[] paramArrayOfByte, HashMap<String, String> paramHashMap)
  {
    if (QLog.isColorLevel()) {
      QLog.i("TAG_MultiMsg", 2, "Multimsg upload file by BDH and onSuccess  ");
    }
    this.a.e();
    paramArrayOfByte = new File(ayoi.d(aysr.a(this.a)));
    if (paramArrayOfByte.exists()) {
      paramArrayOfByte.delete();
    }
  }
  
  public void onSwitch2BackupChannel() {}
  
  public void onTransStart() {}
  
  public void onUpdateProgress(int paramInt) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     ayss
 * JD-Core Version:    0.7.0.1
 */