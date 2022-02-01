package com.tencent.mobileqq.app.handler.receivesuccess;

import android.os.Bundle;
import com.tencent.mobileqq.app.MessageHandler;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import java.util.Arrays;
import msf.msgsvc.msg_svc.PbSendMsgResp;
import tencent.im.msg.im_receipt.ReceiptInfo;
import tencent.im.msg.im_receipt.ReceiptResp;

public class MessageSvcPbReceiptRead
{
  private static void a(MessageHandler paramMessageHandler, ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.msg.MessageHandler", 2, "<PbReceiptRead><R><---handleC2CReceiptMessageResp.");
    }
    String str = paramToServiceMsg.extraData.getString("uin");
    long l1 = paramToServiceMsg.extraData.getLong("msgSeq");
    int k = paramToServiceMsg.extraData.getInt("msgtype");
    msg_svc.PbSendMsgResp localPbSendMsgResp = new msg_svc.PbSendMsgResp();
    try
    {
      localPbSendMsgResp = (msg_svc.PbSendMsgResp)localPbSendMsgResp.mergeFrom((byte[])paramObject);
      paramObject = localPbSendMsgResp;
    }
    catch (Exception localException)
    {
      if (QLog.isColorLevel())
      {
        QLog.e("Q.msg.MessageHandler", 2, "<---handleC2CReceiptMessageResp : invalid.", localException);
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("<---handleC2CReceiptMessageResp : data:");
        if (paramObject == null) {
          paramObject = "null";
        } else {
          paramObject = Arrays.toString((byte[])paramObject);
        }
        ((StringBuilder)localObject).append(paramObject);
        QLog.e("Q.msg.MessageHandler", 2, ((StringBuilder)localObject).toString());
      }
      paramObject = new msg_svc.PbSendMsgResp();
    }
    int i;
    if (!paramObject.result.has())
    {
      if (QLog.isColorLevel()) {
        QLog.e("Q.msg.MessageHandler", 2, "<---handleC2CReceiptMessageResp : server did not return a valid result code, use 4 instead.");
      }
      i = 4;
    }
    else if (paramObject.result.get() != 0)
    {
      i = paramObject.result.get();
    }
    else
    {
      i = 0;
    }
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("<PbReceiptRead><R><---handleC2CReceiptMessageResp : ---cmd:MessageSvc.PbReceiptRead----replyCode:");
      ((StringBuilder)localObject).append(i);
      ((StringBuilder)localObject).append(" ssoseq:");
      ((StringBuilder)localObject).append(paramFromServiceMsg.getRequestSsoSeq());
      ((StringBuilder)localObject).append(" appseq:");
      ((StringBuilder)localObject).append(paramFromServiceMsg.getAppSeq());
      ((StringBuilder)localObject).append(" peerUin:");
      ((StringBuilder)localObject).append(str);
      ((StringBuilder)localObject).append(" msgseq:");
      ((StringBuilder)localObject).append(l1);
      ((StringBuilder)localObject).append(" msgType:");
      ((StringBuilder)localObject).append(k);
      QLog.d("Q.msg.MessageHandler", 2, ((StringBuilder)localObject).toString());
    }
    Object localObject = paramFromServiceMsg.extraData;
    long l2 = i;
    ((Bundle)localObject).putLong("ServerReplyCode", l2);
    paramMessageHandler.b(paramToServiceMsg, paramFromServiceMsg);
    paramFromServiceMsg = paramMessageHandler.b(l1);
    if (paramFromServiceMsg == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.msg.MessageHandler", 2, "<PbReceiptRead><R><---handleC2CReceiptMessageResp : ---cmd:MessageSvc.PbReceiptRead,no SendMessageHandler found.");
      }
      return;
    }
    int j;
    if (i == 255) {
      j = 1;
    } else {
      j = 0;
    }
    if ((j != 0) && (paramMessageHandler.a(paramFromServiceMsg, "server"))) {
      return;
    }
    if ((i != 0) && (i != 241))
    {
      paramMessageHandler.a(paramToServiceMsg, paramObject);
      paramMessageHandler.a(3021, true, new Long[] { Long.valueOf(k), Long.valueOf(l1), Long.valueOf(l2) });
    }
    else if (k == 1)
    {
      paramMessageHandler.a(6015, true, new Long[] { Long.valueOf(k), Long.valueOf(l1) });
    }
    else
    {
      paramMessageHandler.a(6015, true, new Long[] { Long.valueOf(k), Long.valueOf(l1), Long.valueOf(paramObject.receipt_resp.receipt_info.uint64_read_time.get()) });
    }
    paramMessageHandler.c(l1);
  }
  
  public static void a(MessageHandler paramMessageHandler, ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject, String paramString)
  {
    if ("MessageSvc.PbReceiptRead".equalsIgnoreCase(paramString)) {
      a(paramMessageHandler, paramToServiceMsg, paramFromServiceMsg, paramObject);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.app.handler.receivesuccess.MessageSvcPbReceiptRead
 * JD-Core Version:    0.7.0.1
 */