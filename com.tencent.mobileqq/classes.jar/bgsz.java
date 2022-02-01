import android.os.Bundle;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.qphone.base.util.QLog;
import tencent.aio.video.aio_video.ErrInfo;
import tencent.aio.video.aio_video.RspGetUinByOpenId;

class bgsz
  extends nmf
{
  bgsz(bgsw parambgsw, bgtc parambgtc) {}
  
  public void a(int paramInt, byte[] paramArrayOfByte, Bundle paramBundle)
  {
    if (QLog.isColorLevel()) {
      QLog.i("urlSecMgr", 2, "receive getUinWithOpenID code=" + paramInt);
    }
    Object localObject = "";
    j = -1;
    if ((paramInt != 0) || (paramArrayOfByte == null))
    {
      i = j;
      paramBundle = (Bundle)localObject;
      if (paramArrayOfByte != null) {
        paramBundle = (Bundle)localObject;
      }
    }
    try
    {
      aio_video.RspGetUinByOpenId localRspGetUinByOpenId = new aio_video.RspGetUinByOpenId();
      paramBundle = (Bundle)localObject;
      localRspGetUinByOpenId.mergeFrom(paramArrayOfByte);
      paramBundle = (Bundle)localObject;
      localObject = localRspGetUinByOpenId.err_info.err_msg.get().toStringUtf8();
      paramBundle = (Bundle)localObject;
      i = localRspGetUinByOpenId.err_info.err_code.get();
      paramBundle = (Bundle)localObject;
    }
    catch (InvalidProtocolBufferMicroException localInvalidProtocolBufferMicroException)
    {
      for (;;)
      {
        label340:
        i = j;
        continue;
        paramArrayOfByte = "";
        paramInt = 0;
      }
    }
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder().append("getUinWithOpenID error code=").append(paramInt);
      if (paramArrayOfByte == null)
      {
        paramArrayOfByte = ", data=null";
        QLog.i("urlSecMgr", 2, paramArrayOfByte);
        paramArrayOfByte = "";
        paramInt = 0;
      }
      for (;;)
      {
        if (this.jdField_a_of_type_Bgtc != null)
        {
          localObject = new Bundle();
          if (paramInt != 0) {
            i = 0;
          }
          ((Bundle)localObject).putInt("result", i);
          ((Bundle)localObject).putString("errMsg", paramBundle);
          ((Bundle)localObject).putString("retUin", paramArrayOfByte);
          this.jdField_a_of_type_Bgtc.a((Bundle)localObject);
        }
        return;
        paramArrayOfByte = ", msg=" + paramBundle + ", errCode=" + i;
        break;
        paramBundle = new aio_video.RspGetUinByOpenId();
        try
        {
          paramBundle.mergeFrom(paramArrayOfByte);
          long l = paramBundle.uin.get();
          paramArrayOfByte = String.valueOf(l);
        }
        catch (InvalidProtocolBufferMicroException paramBundle)
        {
          try
          {
            if (QLog.isColorLevel()) {
              QLog.d("urlSecMgr", 2, new Object[] { "getUinWithOpenID uin:", Long.valueOf(paramBundle.uin.get()) });
            }
            paramInt = 1;
            i = j;
            paramBundle = (Bundle)localObject;
          }
          catch (InvalidProtocolBufferMicroException paramBundle)
          {
            break label340;
          }
          paramBundle = paramBundle;
          paramArrayOfByte = "";
          if (QLog.isColorLevel()) {
            QLog.i("urlSecMgr", 2, "parse error", paramBundle);
          }
          paramInt = 0;
          i = j;
          paramBundle = (Bundle)localObject;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bgsz
 * JD-Core Version:    0.7.0.1
 */