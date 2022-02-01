package com.tencent.mobileqq.app.handler.receivesuccess;

import android.os.Bundle;
import com.tencent.mobileqq.app.HotChatHelper;
import com.tencent.mobileqq.app.HotChatManager;
import com.tencent.mobileqq.app.MessageHandler;
import com.tencent.mobileqq.app.OidbWrapper;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.handler.Report;
import com.tencent.mobileqq.app.proxy.ProxyManager;
import com.tencent.mobileqq.app.proxy.RecentUserProxy;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.service.message.MessageCache;
import com.tencent.mobileqq.utils.SendMessageHandler;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import msf.msgsvc.msg_svc.PbSendMsgResp;
import tencent.im.oidb.cmd0xa89.oidb_0xa89.RspBody;

public class SendHotchatTopicMessageRespPB
{
  public static void a(MessageHandler paramMessageHandler, ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    String str;
    long l4;
    long l5;
    int i;
    Object localObject2;
    if ("OidbSvc.0xa89".equalsIgnoreCase(paramFromServiceMsg.getServiceCmd()))
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.msg.MessageHandler", 2, "handleSendHotchatTopicMessageRespPB enter");
      }
      str = paramToServiceMsg.extraData.getString("groupuin");
      l4 = paramToServiceMsg.extraData.getLong("msgSeq");
      l5 = paramToServiceMsg.extraData.getLong("uniseq");
      try
      {
        oidb_0xa89.RspBody localRspBody = new oidb_0xa89.RspBody();
        i = OidbWrapper.parseOIDBPkg(paramFromServiceMsg, paramObject, localRspBody);
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
        localObject1 = null;
        i = 4;
      }
      if (localObject1 != null)
      {
        l1 = ((oidb_0xa89.RspBody)localObject1).uint64_msg_seq.get();
        localObject2 = ((oidb_0xa89.RspBody)localObject1).bytes_poid.get().toStringUtf8();
        ((oidb_0xa89.RspBody)localObject1).bytes_msg_error_info.get().toStringUtf8();
        if (((oidb_0xa89.RspBody)localObject1).bytes_rsp_msg_body.has()) {
          localObject1 = new msg_svc.PbSendMsgResp();
        }
      }
    }
    try
    {
      paramObject = (msg_svc.PbSendMsgResp)((msg_svc.PbSendMsgResp)localObject1).mergeFrom((byte[])paramObject);
      localObject1 = localObject2;
    }
    catch (Exception paramObject)
    {
      label176:
      int j;
      boolean bool;
      long l3;
      long l2;
      break label176;
    }
    paramObject = null;
    Object localObject1 = localObject2;
    break label193;
    paramObject = null;
    localObject1 = null;
    long l1 = 0L;
    label193:
    paramFromServiceMsg.extraData.putLong("ServerReplyCode", i);
    paramMessageHandler.a(paramToServiceMsg, paramFromServiceMsg);
    if (QLog.isColorLevel()) {
      QLog.d("Q.msg.MessageHandler", 2, String.format("%s, troopUin = %s, replycode=%d, msgSeq=%d, uniseq=%d, shmsgseq=%d, uuid=%s", new Object[] { "handleSendHotchatTopicMessageRespPB", str, Integer.valueOf(i), Long.valueOf(l4), Long.valueOf(l5), Long.valueOf(l1), localObject1 }));
    }
    localObject1 = paramMessageHandler.a(l4);
    if (localObject1 == null) {
      return;
    }
    if (i == 255) {
      j = 1;
    } else {
      j = 0;
    }
    if ((j != 0) && (paramMessageHandler.a((SendMessageHandler)localObject1, "server"))) {
      return;
    }
    localObject1 = new Object[7];
    localObject1[0] = str;
    localObject1[1] = Integer.valueOf(1026);
    localObject1[2] = Integer.valueOf(i);
    localObject1[3] = paramToServiceMsg.getAttribute("sendmsgHandler");
    localObject1[4] = Long.valueOf(paramToServiceMsg.extraData.getLong("timeOut"));
    localObject1[5] = Long.valueOf(l5);
    if (paramObject != null) {
      paramObject = paramObject.errmsg.get();
    } else {
      paramObject = "";
    }
    localObject1[6] = paramObject;
    if ((i != 108) && (i != 102)) {
      if (i == 0)
      {
        bool = true;
        break label556;
      }
    }
    for (;;)
    {
      bool = false;
      break;
      paramObject = ((HotChatManager)paramMessageHandler.a.getManager(QQManagerFactory.HOT_CHAT_MANAGER)).a(str);
      if (paramObject != null)
      {
        HotChatHelper.a(paramMessageHandler.a, paramObject);
      }
      else
      {
        paramObject = paramMessageHandler.a.getProxyManager().a();
        localObject2 = paramObject.a(str, 1);
        if (localObject2 != null) {
          paramObject.a((RecentUser)localObject2);
        }
        paramMessageHandler.a(1002, true, localObject1);
        paramMessageHandler.a(2001, true, localObject1);
        paramMessageHandler.a(2002, true, localObject1);
      }
    }
    label556:
    if (bool)
    {
      paramMessageHandler.a.getMsgCache().a(str, 1026, l5);
      l3 = paramToServiceMsg.extraData.getLong("msg_request_time", 0L);
      paramMessageHandler.notifyUI(6003, true, new String[] { str, String.valueOf(l5) });
      l2 = l3;
      if (l3 == 0L) {
        l2 = MessageCache.a();
      }
      paramMessageHandler.a(str, 1026, l5, l1, l2);
    }
    else
    {
      paramMessageHandler.a((Object[])localObject1, paramFromServiceMsg.getUin(), i);
      paramMessageHandler.a(3013, false, localObject1);
    }
    paramMessageHandler.a(paramToServiceMsg, paramFromServiceMsg, i, l5, bool);
    paramMessageHandler.a(l4);
    Report.a(paramMessageHandler.a, paramToServiceMsg, paramFromServiceMsg);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.app.handler.receivesuccess.SendHotchatTopicMessageRespPB
 * JD-Core Version:    0.7.0.1
 */