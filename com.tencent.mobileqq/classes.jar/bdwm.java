import com.tencent.mobileqq.highway.api.ITransactionCallback;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.HashMap;
import tencent.im.longconn.multimsg.UpFileRspExtInfo;

class bdwm
  implements ITransactionCallback
{
  bdwm(bdwl parambdwl) {}
  
  public void onFailed(int paramInt, byte[] paramArrayOfByte, HashMap<String, String> paramHashMap)
  {
    if (QLog.isColorLevel()) {
      QLog.i("MultiMsg_TAG", 2, "BDH.Upload fail  : result:" + paramInt);
    }
    this.a.d();
  }
  
  public void onSuccess(byte[] paramArrayOfByte, HashMap<String, String> paramHashMap)
  {
    if (QLog.isColorLevel()) {
      QLog.i("MultiMsg_TAG", 2, "Multimsg upload file by BDH and onSuccess  ");
    }
    paramHashMap = new UpFileRspExtInfo();
    try
    {
      paramHashMap.mergeFrom(paramArrayOfByte);
      bdwl.a(this.a, paramHashMap.bytes_msg_res_id.get().toByteArray());
      if (QLog.isDevelopLevel()) {
        QLog.i("MultiMsg_TAG_opt", 2, "Multimsg upload file by BDH and onSuccess  " + new String(bdwl.a(this.a), "utf-8"));
      }
      paramArrayOfByte = new File(bdsh.d(bdwl.a(this.a)));
      if (paramArrayOfByte.exists()) {
        paramArrayOfByte.delete();
      }
      this.a.e();
      return;
    }
    catch (Exception paramArrayOfByte)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.i("MultiMsg_TAG_opt", 2, "Multimsg upload file by BDH and onSuccess but exception + " + paramArrayOfByte);
        }
        paramArrayOfByte.printStackTrace();
      }
    }
  }
  
  public void onSwitch2BackupChannel() {}
  
  public void onTransStart() {}
  
  public void onUpdateProgress(int paramInt) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bdwm
 * JD-Core Version:    0.7.0.1
 */