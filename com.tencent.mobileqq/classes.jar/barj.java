import com.tencent.mobileqq.highway.api.ITransactionCallback;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import pttcenterservice.PttShortVideo.PttShortVideoUploadResp;

class barj
  implements ITransactionCallback
{
  barj(bari parambari) {}
  
  public void onFailed(int paramInt, byte[] paramArrayOfByte, HashMap<String, String> paramHashMap)
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.a.a, 2, "upload onFailed errn:" + paramInt);
    }
    this.a.e();
  }
  
  public void onSuccess(byte[] paramArrayOfByte, HashMap<String, String> paramHashMap)
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.a.a, 2, "upload onSuccess");
    }
    paramHashMap = new PttShortVideo.PttShortVideoUploadResp();
    try
    {
      paramArrayOfByte = (PttShortVideo.PttShortVideoUploadResp)paramHashMap.mergeFrom(paramArrayOfByte);
      if (paramArrayOfByte.str_fileid.has()) {
        this.a.c = paramArrayOfByte.str_fileid.get();
      }
      this.a.b = true;
      this.a.b();
      return;
    }
    catch (InvalidProtocolBufferMicroException paramArrayOfByte)
    {
      for (;;)
      {
        paramArrayOfByte.printStackTrace();
      }
    }
  }
  
  public void onSwitch2BackupChannel() {}
  
  public void onTransStart() {}
  
  public void onUpdateProgress(int paramInt) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     barj
 * JD-Core Version:    0.7.0.1
 */