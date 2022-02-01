import android.os.Bundle;
import com.tencent.mobileqq.app.FriendListHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import java.nio.ByteBuffer;
import tencent.im.oidb.oidb_sso.OIDBSSOPkg;

public class aoqs
  extends aoqf
{
  public aoqs(QQAppInterface paramQQAppInterface, FriendListHandler paramFriendListHandler)
  {
    super(paramQQAppInterface, paramFriendListHandler);
  }
  
  private int a(ToServiceMsg paramToServiceMsg)
  {
    int i = 0;
    try
    {
      Object localObject = ByteBuffer.wrap(paramToServiceMsg.getWupBuffer());
      paramToServiceMsg = new byte[((ByteBuffer)localObject).getInt() - 4];
      ((ByteBuffer)localObject).get(paramToServiceMsg);
      localObject = new oidb_sso.OIDBSSOPkg();
      ((oidb_sso.OIDBSSOPkg)localObject).mergeFrom(paramToServiceMsg);
      int j = ((oidb_sso.OIDBSSOPkg)localObject).uint32_service_type.get();
      i = j;
    }
    catch (Exception paramToServiceMsg)
    {
      while (!QLog.isColorLevel()) {}
      QLog.d("FriendListHandler.BaseHandlerReceiver", 2, "getServiceTypeFromToServiceMsg error:" + paramToServiceMsg.getMessage());
    }
    return i;
    return 0;
  }
  
  private void c(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    int i = a(paramToServiceMsg);
    Bundle localBundle = new Bundle();
    localBundle.putLong("uin", paramToServiceMsg.extraData.getLong("uin"));
    if (i == 147) {}
    for (i = 72;; i = 71)
    {
      if ((paramObject == null) || (!paramFromServiceMsg.isSuccess()))
      {
        a(i, false, localBundle);
        return;
      }
      try
      {
        paramToServiceMsg = new oidb_sso.OIDBSSOPkg();
        paramToServiceMsg.mergeFrom((byte[])paramObject);
        if ((paramToServiceMsg.uint32_result.has()) && (paramToServiceMsg.uint32_result.get() == 0))
        {
          paramToServiceMsg = ByteBuffer.wrap(paramToServiceMsg.bytes_bodybuffer.get().toByteArray());
          long l = paramToServiceMsg.getInt();
          paramToServiceMsg.getShort();
          paramFromServiceMsg = new byte[4];
          paramToServiceMsg.get(paramFromServiceMsg);
          l = bhjx.a(paramFromServiceMsg, 0);
          int j = paramToServiceMsg.get();
          localBundle.putLong("uin", l);
          localBundle.putInt("safety_flag", j & 0x1F);
          a(i, true, localBundle);
          return;
        }
      }
      catch (Exception paramToServiceMsg)
      {
        if (QLog.isColorLevel()) {
          QLog.d("FriendListHandler.BaseHandlerReceiver", 2, "handle_oidb_0x476 error:" + paramToServiceMsg.getMessage());
        }
        a(i, false, localBundle);
        return;
      }
    }
  }
  
  public boolean a(String paramString)
  {
    return ("OidbSvc.0x476_146".equals(paramString)) || ("OidbSvc.0x476_147".equals(paramString));
  }
  
  public void b(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    c(paramToServiceMsg, paramFromServiceMsg, paramObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aoqs
 * JD-Core Version:    0.7.0.1
 */