package com.tencent.mobileqq.app.handler.receivesuccess;

import android.os.Bundle;
import com.tencent.mobileqq.app.MessageHandler;
import com.tencent.mobileqq.app.OidbWrapper;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import tencent.im.oidb.cmd0x9db.cmd0x9db.RspBody;

public class InsertBlackList
{
  public static void a(MessageHandler paramMessageHandler, ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if ("OidbSvc.0x9db".equals(paramFromServiceMsg.getServiceCmd()))
    {
      cmd0x9db.RspBody localRspBody = new cmd0x9db.RspBody();
      int i = OidbWrapper.parseOIDBPkg(paramFromServiceMsg, paramObject, localRspBody);
      paramFromServiceMsg = null;
      paramObject = null;
      List localList = null;
      int j = -1;
      if (localRspBody.int32_result.has()) {
        j = localRspBody.int32_result.get();
      }
      long l1;
      if ((i == 0) && (j == 0))
      {
        if (localRspBody.rpt_uint64_uin.has())
        {
          localList = localRspBody.rpt_uint64_uin.get();
          if (localList.size() > 0)
          {
            l1 = ((Long)localList.get(0)).longValue();
            break label124;
          }
        }
        l1 = 0L;
        label124:
        if (localRspBody.uint32_sequence.has())
        {
          k = localRspBody.uint32_sequence.get();
          i = 1;
          paramFromServiceMsg = paramObject;
          break label191;
        }
        i = 1;
      }
      else
      {
        paramFromServiceMsg = localList;
        if (localRspBody.str_errormessage.has()) {
          paramFromServiceMsg = localRspBody.str_errormessage.get();
        }
        l1 = 0L;
        i = 0;
      }
      int k = 0;
      label191:
      int m = paramToServiceMsg.extraData.getInt("fromType");
      if ((i != 0) && (l1 > 0L))
      {
        paramMessageHandler.b(Long.toString(l1));
        long l2 = paramToServiceMsg.extraData.getLong("insertTinnyid");
        if (QLog.isColorLevel())
        {
          paramToServiceMsg = new StringBuilder();
          paramToServiceMsg.append("handleInsertBlackList success, tinnyid:");
          paramToServiceMsg.append(l2);
          QLog.d("Q.msg.MessageHandler", 2, paramToServiceMsg.toString());
        }
        paramMessageHandler.notifyUI(8017, true, new Object[] { Integer.valueOf(m), Long.valueOf(l2), Long.toString(l1), Integer.valueOf(k) });
        return;
      }
      if (QLog.isColorLevel())
      {
        paramToServiceMsg = new StringBuilder();
        paramToServiceMsg.append("handleInsertBlackList failed :");
        paramToServiceMsg.append(paramFromServiceMsg);
        paramToServiceMsg.append(" code:");
        paramToServiceMsg.append(j);
        QLog.d("Q.msg.MessageHandler", 2, paramToServiceMsg.toString());
      }
      paramMessageHandler.notifyUI(8017, false, new Object[] { Integer.valueOf(m), Integer.valueOf(j), paramFromServiceMsg });
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.app.handler.receivesuccess.InsertBlackList
 * JD-Core Version:    0.7.0.1
 */