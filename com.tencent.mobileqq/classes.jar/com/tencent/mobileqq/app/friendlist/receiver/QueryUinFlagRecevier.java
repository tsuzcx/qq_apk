package com.tencent.mobileqq.app.friendlist.receiver;

import android.os.Bundle;
import com.tencent.mobileqq.app.FriendListHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.util.Utils;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import java.nio.ByteBuffer;
import tencent.im.oidb.oidb_sso.OIDBSSOPkg;

public class QueryUinFlagRecevier
  extends BaseHandlerReceiver
{
  public QueryUinFlagRecevier(QQAppInterface paramQQAppInterface, FriendListHandler paramFriendListHandler)
  {
    super(paramQQAppInterface, paramFriendListHandler);
  }
  
  private int a(ToServiceMsg paramToServiceMsg)
  {
    try
    {
      localObject = ByteBuffer.wrap(paramToServiceMsg.getWupBuffer());
      paramToServiceMsg = new byte[((ByteBuffer)localObject).getInt() - 4];
      ((ByteBuffer)localObject).get(paramToServiceMsg);
      localObject = new oidb_sso.OIDBSSOPkg();
      ((oidb_sso.OIDBSSOPkg)localObject).mergeFrom(paramToServiceMsg);
      int i = ((oidb_sso.OIDBSSOPkg)localObject).uint32_service_type.get();
      return i;
    }
    catch (Exception paramToServiceMsg)
    {
      Object localObject;
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("getServiceTypeFromToServiceMsg error:");
        ((StringBuilder)localObject).append(paramToServiceMsg.getMessage());
        QLog.d("FriendListHandler.BaseHandlerReceiver", 2, ((StringBuilder)localObject).toString());
      }
    }
    return 0;
  }
  
  private void c(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    a(paramToServiceMsg);
    Bundle localBundle = new Bundle();
    localBundle.putLong("uin", paramToServiceMsg.extraData.getLong("uin"));
    if ((paramObject != null) && (paramFromServiceMsg.isSuccess())) {
      try
      {
        paramToServiceMsg = new oidb_sso.OIDBSSOPkg();
        paramToServiceMsg.mergeFrom((byte[])paramObject);
        if ((paramToServiceMsg.uint32_result.has()) && (paramToServiceMsg.uint32_result.get() == 0))
        {
          paramToServiceMsg = ByteBuffer.wrap(paramToServiceMsg.bytes_bodybuffer.get().toByteArray());
          paramToServiceMsg.getInt();
          paramToServiceMsg.getShort();
          paramFromServiceMsg = new byte[4];
          paramToServiceMsg.get(paramFromServiceMsg);
          long l = Utils.a(paramFromServiceMsg, 0);
          int i = paramToServiceMsg.get();
          localBundle.putLong("uin", l);
          localBundle.putInt("safety_flag", i & 0x1F);
          a(70, true, localBundle);
          return;
        }
      }
      catch (Exception paramToServiceMsg)
      {
        if (QLog.isColorLevel())
        {
          paramFromServiceMsg = new StringBuilder();
          paramFromServiceMsg.append("handle_oidb_0x476 error:");
          paramFromServiceMsg.append(paramToServiceMsg.getMessage());
          QLog.d("FriendListHandler.BaseHandlerReceiver", 2, paramFromServiceMsg.toString());
        }
        a(70, false, localBundle);
        return;
      }
    }
    a(70, false, localBundle);
  }
  
  public boolean a(String paramString)
  {
    return "OidbSvc.0x476_146".equals(paramString);
  }
  
  public void b(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    c(paramToServiceMsg, paramFromServiceMsg, paramObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.app.friendlist.receiver.QueryUinFlagRecevier
 * JD-Core Version:    0.7.0.1
 */