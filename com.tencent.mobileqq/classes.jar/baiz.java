import android.os.Bundle;
import com.tencent.mobileqq.data.AccountDetail;
import com.tencent.mobileqq.mp.mobileqq_mp.GetPublicAccountDetailInfoResponse;
import com.tencent.mobileqq.mp.mobileqq_mp.RetInfo;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.qphone.base.util.QLog;

public abstract class baiz
  extends mxm
{
  public void a(int paramInt, byte[] paramArrayOfByte, Bundle paramBundle)
  {
    boolean bool2 = false;
    Object localObject = null;
    long l2 = 0L;
    long l1;
    boolean bool1;
    if ((paramInt == 0) && (paramBundle != null))
    {
      l2 = paramBundle.getLong("uin");
      l1 = l2;
      if (paramArrayOfByte == null) {
        break label199;
      }
      paramBundle = new mobileqq_mp.GetPublicAccountDetailInfoResponse();
      bool1 = bool2;
    }
    for (;;)
    {
      try
      {
        paramBundle.mergeFrom(paramArrayOfByte);
        bool1 = bool2;
        if (!((mobileqq_mp.RetInfo)paramBundle.ret_info.get()).ret_code.has()) {
          break label211;
        }
        bool1 = bool2;
        if (((mobileqq_mp.RetInfo)paramBundle.ret_info.get()).ret_code.get() != 0) {
          break label211;
        }
        bool1 = true;
        paramArrayOfByte = new AccountDetail(paramBundle);
        bool1 = true;
      }
      catch (InvalidProtocolBufferMicroException paramBundle)
      {
        bool2 = bool1;
        bool1 = bool2;
        paramArrayOfByte = localObject;
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.i("TroopBindPubAccountProtocol", 2, paramBundle.toString());
        bool1 = bool2;
        paramArrayOfByte = localObject;
        continue;
      }
      a(bool1, l2, paramArrayOfByte);
      return;
      l1 = l2;
      if (QLog.isColorLevel())
      {
        QLog.i("TroopBindPubAccountProtocol", 2, "get pubAccountInfo failed, errorCode=" + paramInt);
        l1 = l2;
      }
      label199:
      bool1 = false;
      paramArrayOfByte = null;
      l2 = l1;
      continue;
      label211:
      paramArrayOfByte = null;
      bool1 = false;
    }
  }
  
  protected abstract void a(boolean paramBoolean, long paramLong, AccountDetail paramAccountDetail);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     baiz
 * JD-Core Version:    0.7.0.1
 */