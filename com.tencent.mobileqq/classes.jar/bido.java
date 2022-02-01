import android.os.Bundle;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.qphone.base.util.QLog;
import tencent.im.PasswdUrlReport.RspBody;
import tencent.im.PasswdUrlReport.UploadRespItem;

class bido
  extends ntf
{
  bido(bidm parambidm) {}
  
  public void a(int paramInt, byte[] paramArrayOfByte, Bundle paramBundle)
  {
    if (QLog.isColorLevel()) {
      QLog.i("urlSecMgr", 2, "receive PasswdUrlReport code=" + paramInt);
    }
    if ((paramInt != 0) || (paramArrayOfByte == null)) {
      if ((QLog.isColorLevel()) && (paramArrayOfByte == null)) {
        break label231;
      }
    }
    for (;;)
    {
      try
      {
        paramBundle = ((PasswdUrlReport.RspBody)new PasswdUrlReport.RspBody().mergeFrom(paramArrayOfByte)).upload_rsp_item.ret_msg.get();
        StringBuilder localStringBuilder = new StringBuilder().append("PasswdUrlReport error code=").append(paramInt);
        if (paramArrayOfByte == null)
        {
          paramArrayOfByte = ", data=null";
          QLog.i("urlSecMgr", 2, paramArrayOfByte);
          return;
        }
      }
      catch (InvalidProtocolBufferMicroException paramBundle)
      {
        paramBundle = "";
        continue;
        paramArrayOfByte = ", msg=" + paramBundle;
        continue;
      }
      paramBundle = new PasswdUrlReport.RspBody();
      try
      {
        paramBundle.mergeFrom(paramArrayOfByte);
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.d("urlSecMgr", 2, new Object[] { "parse PasswdUrlReport result res=", Integer.valueOf(paramBundle.result.get()), " retCode=", Integer.valueOf(paramBundle.upload_rsp_item.ret_code.get()) });
        return;
      }
      catch (InvalidProtocolBufferMicroException paramArrayOfByte) {}
      if (QLog.isColorLevel())
      {
        QLog.i("urlSecMgr", 2, "parse error", paramArrayOfByte);
        return;
        label231:
        paramBundle = "";
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bido
 * JD-Core Version:    0.7.0.1
 */