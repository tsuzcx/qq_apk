package com.tencent.mobileqq.app.handler.receivesuccess;

import android.os.Bundle;
import android.support.annotation.NonNull;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.imcore.message.UinTypeUtil;
import com.tencent.mobileqq.activity.aio.forward.ForwardOrderManager;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.MessageHandler;
import com.tencent.mobileqq.app.MessageHandlerConstants.MsgSendCostParams;
import com.tencent.mobileqq.app.MessageHandlerUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.StatictisInfo;
import com.tencent.mobileqq.app.handler.Report;
import com.tencent.mobileqq.app.message.OfflineFileMessageProcessor;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.RecommendCommonMessage;
import com.tencent.mobileqq.kandian.biz.video.playfeeds.api.IVideoReporter;
import com.tencent.mobileqq.msf.sdk.MsfSdkUtils;
import com.tencent.mobileqq.multimsg.LongTextMsgManager;
import com.tencent.mobileqq.nearby.NearbyUtils;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.service.message.MessageCache;
import com.tencent.mobileqq.service.message.MessageCache.MsgSendingInfo;
import com.tencent.mobileqq.service.message.MessageProtoCodec;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.SendMessageHandler;
import com.tencent.qidian.controller.QidianHandler;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import java.util.Arrays;
import msf.msgsvc.msg_svc.PbSendMsgResp;
import msf.msgsvc.msg_svc.TransSvrInfo;

public class SendMsgResp
{
  public static int a(QQAppInterface paramQQAppInterface, String paramString, int paramInt1, int paramInt2)
  {
    int i = paramInt2;
    int j;
    if (paramInt1 != 10002)
    {
      j = i;
      if (paramInt1 != 1001) {}
    }
    else
    {
      j = i;
      if (NearbyUtils.a(paramInt2))
      {
        if (i == 48)
        {
          if (paramInt1 == 10002)
          {
            paramQQAppInterface.getMsgCache().h(paramString, null);
            j = 1;
          }
          else
          {
            paramQQAppInterface.getMsgCache().g(paramString, null);
            j = 0;
          }
          NearbyUtils.a(paramQQAppInterface, paramString, j);
        }
        ReportController.b(paramQQAppInterface, "dc00899", "grp_lbs", "", "nearby_chat", "nearby_sig_expire", 0, 0, paramString, String.valueOf(paramInt1), String.valueOf(paramInt2), "");
        if (QLog.isColorLevel())
        {
          paramQQAppInterface = new StringBuilder();
          paramQQAppInterface.append("handleSendC2CMessageResp_PB, 部落、附近的人临时会话因为签名失败, uinType:");
          paramQQAppInterface.append(paramInt1);
          paramQQAppInterface.append("|replyCode:");
          paramQQAppInterface.append(i);
          QLog.e("Q.msg.MessageHandlerQ.nearby.nearby_sig", 2, paramQQAppInterface.toString());
        }
        j = 0;
      }
    }
    return j;
  }
  
  @NonNull
  public static msg_svc.PbSendMsgResp a(Object paramObject)
  {
    msg_svc.PbSendMsgResp localPbSendMsgResp = new msg_svc.PbSendMsgResp();
    try
    {
      localPbSendMsgResp = (msg_svc.PbSendMsgResp)localPbSendMsgResp.mergeFrom((byte[])paramObject);
      return localPbSendMsgResp;
    }
    catch (Exception localException)
    {
      if (QLog.isColorLevel())
      {
        QLog.e("Q.msg.MessageHandler", 2, "<---handleSendC2CMessageResp_PB : invalid.", localException);
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("<---handleSendC2CMessageResp_PB : data:");
        if (paramObject == null) {
          paramObject = "null";
        } else {
          paramObject = Arrays.toString((byte[])paramObject);
        }
        localStringBuilder.append(paramObject);
        QLog.e("Q.msg.MessageHandler", 2, localStringBuilder.toString());
      }
    }
    return new msg_svc.PbSendMsgResp();
  }
  
  public static void a(MessageHandler paramMessageHandler, ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if ("MessageSvc.PbSendMsg".equalsIgnoreCase(paramFromServiceMsg.getServiceCmd()))
    {
      int i = paramToServiceMsg.extraData.getInt("ROUNTING_TYPE");
      if (MessageHandlerUtils.a(i, paramMessageHandler.a)) {
        b(paramMessageHandler, paramToServiceMsg, paramFromServiceMsg, paramObject);
      } else if (i == 9) {
        paramMessageHandler.a().a(7002, new Object[] { paramToServiceMsg, paramFromServiceMsg, paramObject });
      } else if (i == 13) {
        paramMessageHandler.a().a(7003, new Object[] { paramToServiceMsg, paramFromServiceMsg, paramObject });
      } else if (i == 4) {
        paramMessageHandler.e(paramToServiceMsg, paramFromServiceMsg, paramObject);
      } else if (i == 2) {
        paramMessageHandler.d(paramToServiceMsg, paramFromServiceMsg, paramObject);
      }
      Report.a(paramToServiceMsg, "0");
    }
  }
  
  public static void a(MessageHandler paramMessageHandler, ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, String paramString1, long paramLong1, String paramString2, long paramLong2, int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean, msg_svc.PbSendMsgResp paramPbSendMsgResp, SendMessageHandler paramSendMessageHandler)
  {
    Object localObject = paramMessageHandler.a.getMsgCache().a(paramString1, paramInt2, paramLong1);
    paramToServiceMsg.extraData.putBoolean("isJuhuaExist", MessageCache.a((MessageCache.MsgSendingInfo)localObject));
    long l1;
    if (paramPbSendMsgResp.send_time.has())
    {
      l1 = paramPbSendMsgResp.send_time.get() & 0xFFFFFFFF;
      paramMessageHandler.a(paramString1, paramInt2, paramLong1, l1, paramString2);
      if (QLog.isColorLevel())
      {
        paramString2 = new StringBuilder();
        paramString2.append("<---handleSendC2CMessageResp_PB updateSendMsgTime: sendBuddyPb: respData.uSendTime:");
        paramString2.append(l1);
        paramString2.append(",peerUin:");
        paramString2.append(paramString1);
        QLog.d("Q.msg.MessageHandler", 2, paramString2.toString());
      }
    }
    if ((paramPbSendMsgResp.trans_svr_info.has()) && (paramInt2 == 10008)) {
      paramMessageHandler.notifyUI(8046, true, paramPbSendMsgResp.trans_svr_info.get());
    }
    localObject = paramMessageHandler.a.getMessageFacade().b(paramString1, paramInt2, paramLong1);
    if (paramPbSendMsgResp.uint32_msg_info_flag.has())
    {
      int i = paramPbSendMsgResp.uint32_msg_info_flag.get();
      if (QLog.isColorLevel())
      {
        paramString2 = new StringBuilder();
        paramString2.append("C2CMessageSendFlag: ");
        paramString2.append(i);
        QLog.d("Q.msg.MessageHandler", 2, paramString2.toString());
      }
      ((MessageRecord)localObject).saveExtInfoToExtStr("key_message_extra_info_flag", String.valueOf(i));
      paramMessageHandler.a.getMessageFacade().a(((MessageRecord)localObject).frienduin, ((MessageRecord)localObject).istroop, ((MessageRecord)localObject).uniseq, "extStr", ((MessageRecord)localObject).extStr);
    }
    if ((localObject instanceof RecommendCommonMessage))
    {
      if ((paramPbSendMsgResp.text_analysis_result.has()) && (paramPbSendMsgResp.text_analysis_result.get() == 1)) {
        paramString2 = "1";
      } else {
        paramString2 = "0";
      }
      if (QLog.isColorLevel())
      {
        paramPbSendMsgResp = new StringBuilder();
        paramPbSendMsgResp.append("<---handleSendC2CMessageResp_PB text_analysis_result=");
        paramPbSendMsgResp.append(paramString2);
        QLog.d("Q.msg.MessageHandler", 2, paramPbSendMsgResp.toString());
      }
      ((MessageRecord)localObject).saveExtInfoToExtStr("ark_text_analysis_flag", paramString2);
    }
    long l3 = paramToServiceMsg.extraData.getLong("msg_request_time", 0L);
    if ((l3 > 0L) && (paramInt2 == 0))
    {
      paramString2 = paramFromServiceMsg;
      if ((paramString2.getAttribute("__timestamp_msf2net") != null) && (paramString2.getAttribute("__timestamp_net2msf") != null))
      {
        long l2 = ((Long)paramString2.getAttribute("__timestamp_net2msf")).longValue() - ((Long)paramString2.getAttribute("__timestamp_msf2net")).longValue();
        l1 = l2;
        if (l2 < 0L) {
          l1 = 0L;
        }
        if (l1 <= 2147483647L) {
          break label502;
        }
      }
      l1 = 0L;
      label502:
      paramPbSendMsgResp = new MessageHandlerConstants.MsgSendCostParams();
      paramPbSendMsgResp.jdField_c_of_type_Long = l1;
      paramPbSendMsgResp.d = System.currentTimeMillis();
      paramPbSendMsgResp.jdField_b_of_type_Long = (paramPbSendMsgResp.d - l3);
      paramPbSendMsgResp.jdField_a_of_type_Long = paramToServiceMsg.extraData.getLong("msg_send_to_request_cost", 0L);
      paramPbSendMsgResp.jdField_a_of_type_Int = 0;
      paramPbSendMsgResp.jdField_a_of_type_Boolean = ((Boolean)paramString2.getAttribute("conn_cross_oper_flag", Boolean.valueOf(false))).booleanValue();
      paramPbSendMsgResp.jdField_b_of_type_Boolean = ((Boolean)paramString2.getAttribute("attr_quick_send_by_xg", Boolean.valueOf(false))).booleanValue();
      paramPbSendMsgResp.jdField_c_of_type_Boolean = ((Boolean)paramString2.getAttribute("attr_weaknet_sent_flag", Boolean.valueOf(false))).booleanValue();
      paramString2 = new StringBuilder();
      paramString2.append(paramLong1);
      paramString2.append("");
      paramMessageHandler.notifyUI(6003, true, new Object[] { paramString1, paramString2.toString(), paramPbSendMsgResp });
    }
    else if (UinTypeUtil.a(paramInt2) == 1032)
    {
      paramMessageHandler.notifyUI(8035, true, new Object[] { paramString1, Integer.valueOf(paramInt2), Long.valueOf(paramLong1), Integer.valueOf(paramInt3) });
    }
    else
    {
      paramString2 = new StringBuilder();
      paramString2.append(paramLong1);
      paramString2.append("");
      paramMessageHandler.notifyUI(6003, true, new String[] { paramString1, paramString2.toString() });
    }
    if (paramBoolean)
    {
      paramString2 = new StatictisInfo();
      paramString2.c = (paramInt1 + 1);
      paramMessageHandler.a(paramToServiceMsg, 5006, true, new Object[] { Long.valueOf(paramLong1), paramString2 });
      paramMessageHandler.a(paramString1, paramInt2, paramLong1, true);
    }
    Report.c(paramMessageHandler, paramToServiceMsg, paramFromServiceMsg, true);
    paramMessageHandler.a(paramLong2);
    if ((paramInt2 == 1025) || (paramInt2 == 1024))
    {
      paramLong1 = paramSendMessageHandler.a(System.currentTimeMillis());
      ((QidianHandler)paramMessageHandler.a.getBusinessHandler(BusinessHandlerFactory.QIDIAN_HANDLER)).a(paramString1, paramLong1);
    }
    paramMessageHandler.a((MessageRecord)localObject);
    Report.a(paramMessageHandler.a, paramInt2, paramString1);
  }
  
  public static void b(MessageHandler paramMessageHandler, ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.msg.MessageHandler", 2, "<PbSendMsg><R><---handleSendC2CMessageResp_PB.");
    }
    String str2 = paramToServiceMsg.getServiceCmd();
    String str1 = paramToServiceMsg.extraData.getString("uin");
    long l1 = paramToServiceMsg.extraData.getLong("uniseq");
    String str3 = paramToServiceMsg.extraData.getString("fileName");
    long l2 = paramToServiceMsg.extraData.getLong("msgSeq");
    long l3 = paramToServiceMsg.extraData.getLong("timeOut");
    int i1 = paramToServiceMsg.extraData.getInt("retryIndex", 0);
    int n = paramToServiceMsg.extraData.getInt("msgtype");
    int i2 = paramToServiceMsg.extraData.getInt("ROUNTING_TYPE");
    int i = MessageProtoCodec.a(i2, paramMessageHandler.a);
    if (i == 1024) {
      i = paramToServiceMsg.extraData.getInt("uintype", i);
    }
    boolean bool1 = false;
    int k;
    if (UinTypeUtil.a(i) == 1032) {
      k = paramToServiceMsg.extraData.getInt("key_confess_topicid", 0);
    } else {
      k = 0;
    }
    boolean bool2 = paramToServiceMsg.extraData.getBoolean("RichNotify", false);
    paramObject = a(paramObject);
    if ((paramObject != null) && (paramObject.result.has()))
    {
      if (paramObject.result.get() != 0) {
        j = paramObject.result.get();
      } else {
        j = 0;
      }
    }
    else
    {
      QLog.e("Q.msg.MessageHandler", 2, "<---handleSendC2CMessageResp_PB : server did not return a valid result code, use 4 instead.");
      j = 4;
    }
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("<PbSendMsg><R><---handleSendC2CMessageResp_PB : ---cmd:");
    ((StringBuilder)localObject).append(str2);
    ((StringBuilder)localObject).append("----replyCode:");
    ((StringBuilder)localObject).append(j);
    ((StringBuilder)localObject).append(" ssoseq:");
    ((StringBuilder)localObject).append(paramFromServiceMsg.getRequestSsoSeq());
    ((StringBuilder)localObject).append(" appseq:");
    ((StringBuilder)localObject).append(paramFromServiceMsg.getAppSeq());
    ((StringBuilder)localObject).append(" peerUin:");
    ((StringBuilder)localObject).append(MsfSdkUtils.getShortUin(str1));
    ((StringBuilder)localObject).append(" uniseq:");
    ((StringBuilder)localObject).append(l1);
    ((StringBuilder)localObject).append(" msgSeq:");
    ((StringBuilder)localObject).append(l2);
    ((StringBuilder)localObject).append(" msgType:");
    ((StringBuilder)localObject).append(n);
    ((StringBuilder)localObject).append(" uinType:");
    ((StringBuilder)localObject).append(i);
    ((StringBuilder)localObject).append(" routingType:");
    ((StringBuilder)localObject).append(i2);
    QLog.i("Q.msg.MessageHandler", 1, ((StringBuilder)localObject).toString());
    paramFromServiceMsg.extraData.putLong("ServerReplyCode", j);
    paramMessageHandler.a(paramToServiceMsg, paramFromServiceMsg);
    localObject = paramMessageHandler.a(l2);
    if (localObject == null)
    {
      paramToServiceMsg = new StringBuilder();
      paramToServiceMsg.append("<PbSendMsg><R><---handleSendC2CMessageResp_PB : ---cmd:");
      paramToServiceMsg.append(str2);
      paramToServiceMsg.append(",no SendMessageHandler found.");
      QLog.e("Q.msg.MessageHandler", 1, paramToServiceMsg.toString());
      ForwardOrderManager.a().a(paramMessageHandler.a, l1);
      return;
    }
    int m;
    if (j == 255) {
      m = 1;
    } else {
      m = 0;
    }
    if ((m != 0) && (paramMessageHandler.a((SendMessageHandler)localObject, "server"))) {
      return;
    }
    int j = a(paramMessageHandler.a, str1, i, j);
    if ((j != 0) && (j != 241))
    {
      paramFromServiceMsg = new HandleSendC2CMessageRespPBReplyBranch2(paramMessageHandler, paramToServiceMsg, paramFromServiceMsg, str1, l1, l2, l3, i1, n, i2, i, false, k, bool2, j, paramObject, (SendMessageHandler)localObject).a();
      if (paramFromServiceMsg.a()) {
        return;
      }
      bool1 = paramFromServiceMsg.b();
    }
    else
    {
      a(paramMessageHandler, paramToServiceMsg, paramFromServiceMsg, str1, l1, str3, l2, i1, i, k, bool2, paramObject, (SendMessageHandler)localObject);
    }
    ((LongTextMsgManager)paramMessageHandler.a.getManager(QQManagerFactory.LONG_TEXT_MSG_MANAGER)).a(str1, i, l1, j, System.currentTimeMillis() - paramToServiceMsg.extraData.getLong("startTime", 0L));
    ((IVideoReporter)QRoute.api(IVideoReporter.class)).reportVideoStructMsgSendSuc(paramMessageHandler.a, n, str1, i, l1);
    if (!bool1) {
      ForwardOrderManager.a().a(paramMessageHandler.a, l1);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.app.handler.receivesuccess.SendMsgResp
 * JD-Core Version:    0.7.0.1
 */