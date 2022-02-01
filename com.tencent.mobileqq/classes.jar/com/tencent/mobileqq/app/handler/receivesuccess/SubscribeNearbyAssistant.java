package com.tencent.mobileqq.app.handler.receivesuccess;

import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.utils.httputils.PkgTools;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import tencent.im.oidb.oidb_sso.OIDBSSOPkg;

public class SubscribeNearbyAssistant
{
  public static void a(QQAppInterface paramQQAppInterface, ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if ("OidbSvc.0x4ff_42024".equals(paramFromServiceMsg.getServiceCmd()))
    {
      if (paramFromServiceMsg.getResultCode() == 1000)
      {
        paramToServiceMsg = new oidb_sso.OIDBSSOPkg();
        try
        {
          paramFromServiceMsg = (oidb_sso.OIDBSSOPkg)paramToServiceMsg.mergeFrom(paramFromServiceMsg.getWupBuffer());
          paramToServiceMsg = paramFromServiceMsg;
        }
        catch (InvalidProtocolBufferMicroException paramFromServiceMsg)
        {
          paramFromServiceMsg.printStackTrace();
        }
        if (paramToServiceMsg.uint32_result.has())
        {
          int i = paramToServiceMsg.uint32_result.get();
          if (QLog.isColorLevel())
          {
            paramFromServiceMsg = new StringBuilder();
            paramFromServiceMsg.append("handle_oidb_0x4ff_42024 ret=");
            paramFromServiceMsg.append(i);
            QLog.i("Q.msg.MessageHandler", 2, paramFromServiceMsg.toString());
          }
          if ((i == 0) && (paramToServiceMsg.bytes_bodybuffer.has()) && (paramToServiceMsg.bytes_bodybuffer.get() != null))
          {
            paramToServiceMsg = paramToServiceMsg.bytes_bodybuffer.get().toByteArray();
            i = paramToServiceMsg.length;
            boolean bool2 = true;
            bool1 = bool2;
            if (4 > i) {
              break label202;
            }
            bool1 = bool2;
            if (String.valueOf(PkgTools.getLongData(paramToServiceMsg, 0)).equals(paramQQAppInterface.getAccount())) {
              break label202;
            }
            if (QLog.isColorLevel()) {
              QLog.w("Q.msg.MessageHandler", 2, "handle_oidb_0x4ff_42024 uin error");
            }
            return;
          }
        }
      }
      boolean bool1 = false;
      label202:
      if (QLog.isColorLevel())
      {
        paramQQAppInterface = new StringBuilder();
        paramQQAppInterface.append("handle_oidb_0x4ff_42024 suc=");
        paramQQAppInterface.append(bool1);
        QLog.i("Q.msg.MessageHandler", 2, paramQQAppInterface.toString());
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.app.handler.receivesuccess.SubscribeNearbyAssistant
 * JD-Core Version:    0.7.0.1
 */