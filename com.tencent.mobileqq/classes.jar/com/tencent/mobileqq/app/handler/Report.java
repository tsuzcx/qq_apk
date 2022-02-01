package com.tencent.mobileqq.app.handler;

import android.os.Bundle;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.recent.msgbox.api.ITempMsgBoxManager;
import com.tencent.mobileqq.activity.recent.msgbox.api.ITempMsgBoxService;
import com.tencent.mobileqq.app.BaseMessageHandler;
import com.tencent.mobileqq.app.MessageHandler;
import com.tencent.mobileqq.app.MessageHandlerConstants.MsgSendCostParams;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.emoticon.EmoticonOperateReport;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.service.message.MessageConstants;
import com.tencent.mobileqq.service.message.MessageProtoCodec;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.SendMessageHandler;
import com.tencent.qphone.base.BaseConstants;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.Map;

public class Report
{
  public static void a(MessageHandler paramMessageHandler, ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, boolean paramBoolean)
  {
    if (paramToServiceMsg != null)
    {
      if (paramFromServiceMsg == null) {
        return;
      }
      int i = paramToServiceMsg.extraData.getInt("msgtype", -1);
      long l = paramToServiceMsg.extraData.getLong("msgsize", 0L);
      if (i == -1000) {
        a(paramMessageHandler, "actSendGroupProcess", paramBoolean, l, paramToServiceMsg, paramFromServiceMsg);
      }
    }
  }
  
  public static void a(MessageHandler paramMessageHandler, String paramString, boolean paramBoolean, long paramLong, ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg)
  {
    HashMap localHashMap = new HashMap();
    long l2 = paramFromServiceMsg.getResultCode();
    Object localObject = paramFromServiceMsg.extraData;
    long l3 = 0L;
    long l4 = ((Bundle)localObject).getLong("ServerReplyCode", 0L);
    String str = "";
    long l1 = l2;
    if (l4 != 0L)
    {
      l1 = l2;
      if (l4 != 241L)
      {
        l1 = 2900L;
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append(paramFromServiceMsg.extraData.getLong("ServerReplyCode"));
        ((StringBuilder)localObject).append("");
        localHashMap.put("param_ServerReplyCode", ((StringBuilder)localObject).toString());
      }
    }
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append(l1);
    ((StringBuilder)localObject).append("");
    localHashMap.put("param_FailCode", ((StringBuilder)localObject).toString());
    long l5 = paramToServiceMsg.extraData.getInt("retryIndex", 0);
    localHashMap.put("param_retryIndex", Long.toString(l5));
    l1 = paramToServiceMsg.extraData.getLong("startTime", 0L);
    l4 = System.currentTimeMillis();
    if (l1 < 1L) {
      l1 = 0L;
    } else {
      l1 = l4 - l1;
    }
    l2 = l1;
    localObject = str;
    if (paramToServiceMsg.extraData.containsKey("msgSeq"))
    {
      SendMessageHandler localSendMessageHandler = paramMessageHandler.b(paramToServiceMsg.extraData.getLong("msgSeq"));
      l2 = l1;
      localObject = str;
      if (localSendMessageHandler != null)
      {
        localObject = localSendMessageHandler.toString();
        localHashMap.put("param_retryInfo", localObject);
        l2 = localSendMessageHandler.a(l4);
      }
    }
    str = BaseMessageHandler.a(paramFromServiceMsg);
    if (str != null) {
      localHashMap.put("param_reason", str);
    }
    if ((paramFromServiceMsg.getAttribute("__timestamp_msf2net") != null) && (paramFromServiceMsg.getAttribute("__timestamp_net2msf") != null))
    {
      l4 = ((Long)paramFromServiceMsg.getAttribute("__timestamp_net2msf")).longValue() - ((Long)paramFromServiceMsg.getAttribute("__timestamp_msf2net")).longValue();
      l1 = l4;
      if (l4 < 0L) {
        l1 = 0L;
      }
      if (l1 <= 2147483647L) {
        break label401;
      }
    }
    l1 = 0L;
    label401:
    int i = paramToServiceMsg.extraData.getInt("msg_signal_sum");
    int j = paramToServiceMsg.extraData.getInt("msg_signal_count");
    boolean bool1 = paramToServiceMsg.extraData.getBoolean("msg_signal_open");
    int k = paramToServiceMsg.extraData.getInt("msgtype", -1);
    int m = paramToServiceMsg.extraData.getInt("msg_signal_net_type", -1);
    localHashMap.put("pm_signal_sum", String.valueOf(i));
    localHashMap.put("pm_signal_count", String.valueOf(j));
    localHashMap.put("pm_signal_open", String.valueOf(bool1));
    localHashMap.put("pm_msgtype", String.valueOf(k));
    localHashMap.put("pm_nettype", String.valueOf(m));
    localHashMap.put("pm_msftime", String.valueOf(l1));
    int n = paramToServiceMsg.extraData.getInt("send_msg_req_size", 0);
    boolean bool2 = paramToServiceMsg.extraData.getBoolean("isJuhuaExist");
    localHashMap.put("pm_req_size", String.valueOf(n));
    localHashMap.put("isJuhuaExist", String.valueOf(bool2));
    bool2 = ((Boolean)paramFromServiceMsg.getAttribute("conn_cross_oper_flag", Boolean.valueOf(false))).booleanValue();
    boolean bool3 = ((Boolean)paramFromServiceMsg.getAttribute("attr_quick_send_by_xg", Boolean.valueOf(false))).booleanValue();
    boolean bool4 = ((Boolean)paramFromServiceMsg.getAttribute("attr_weaknet_sent_flag", Boolean.valueOf(false))).booleanValue();
    localHashMap.put("isCrossOper", String.valueOf(bool2));
    localHashMap.put("isSentByXG", String.valueOf(bool3));
    localHashMap.put("isWeaknet", String.valueOf(bool4));
    l4 = paramFromServiceMsg.extraData.getLong(MessageConstants.b, 0L);
    int i1 = paramFromServiceMsg.extraData.getInt(MessageConstants.a, 0);
    if (l4 != 0L) {
      l3 = System.currentTimeMillis() - l4;
    }
    localHashMap.put("pm_queueTime", String.valueOf(l3));
    localHashMap.put("pm_respLen", String.valueOf(i1));
    StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance(paramMessageHandler.n.getCurrentAccountUin(), paramString, paramBoolean, l2, paramLong, localHashMap, "");
    if (QLog.isColorLevel()) {
      QLog.d("Q.msg.MessageHandler", 2, String.format("Statistics TAG:%s, success:%s, duration:%dms, retryNum:%d, detail:%s, msgSignal [Sum:%d Count:%d, Open:%s msgType:%d netType:%d msfTime:%d reqSize:%d queueHandleTime:%d respWaitLen:%d]", new Object[] { paramString, Boolean.valueOf(paramBoolean), Long.valueOf(l2), Long.valueOf(l5), localObject, Integer.valueOf(i), Integer.valueOf(j), Boolean.valueOf(bool1), Integer.valueOf(k), Integer.valueOf(m), Long.valueOf(l1), Integer.valueOf(n), Long.valueOf(l3), Integer.valueOf(i1) }));
    }
  }
  
  public static void a(MessageHandlerConstants.MsgSendCostParams paramMsgSendCostParams, QQAppInterface paramQQAppInterface)
  {
    Object localObject = new StringBuilder(256);
    if (QLog.isColorLevel())
    {
      ((StringBuilder)localObject).append("msg send cost per phase--->>");
      ((StringBuilder)localObject).append("send_request:");
      ((StringBuilder)localObject).append(paramMsgSendCostParams.a);
      ((StringBuilder)localObject).append(" ,request_reponse:");
      ((StringBuilder)localObject).append(paramMsgSendCostParams.b);
      ((StringBuilder)localObject).append(" ,netSend_netRecv:");
      ((StringBuilder)localObject).append(paramMsgSendCostParams.c);
      ((StringBuilder)localObject).append(" ,notifyUi_reflash:");
      ((StringBuilder)localObject).append(paramMsgSendCostParams.e);
      ((StringBuilder)localObject).append(" ,mUinType:");
      ((StringBuilder)localObject).append(paramMsgSendCostParams.f);
      ((StringBuilder)localObject).append(" ,isCrossOper:");
      ((StringBuilder)localObject).append(paramMsgSendCostParams.h);
      QLog.d("Q.msg.MessageHandler", 2, ((StringBuilder)localObject).toString());
    }
    localObject = new HashMap();
    long l = paramMsgSendCostParams.a;
    ((HashMap)localObject).put("param_net", String.valueOf(NetworkUtil.getSystemNetwork(BaseApplication.getContext())));
    ((HashMap)localObject).put("param_send_req", String.valueOf(paramMsgSendCostParams.a));
    ((HashMap)localObject).put("param_req_resp", String.valueOf(paramMsgSendCostParams.b));
    ((HashMap)localObject).put("param_netSend_netRecv", String.valueOf(paramMsgSendCostParams.c));
    ((HashMap)localObject).put("param_notifyUi_reflash", String.valueOf(paramMsgSendCostParams.e));
    ((HashMap)localObject).put("param_uin_type", String.valueOf(paramMsgSendCostParams.f));
    ((HashMap)localObject).put("param_msg_tag", paramMsgSendCostParams.k);
    ((HashMap)localObject).put("param_msg_type", String.valueOf(paramMsgSendCostParams.g));
    if (paramMsgSendCostParams.h) {
      ((HashMap)localObject).put("param_cross_oper", String.valueOf(paramMsgSendCostParams.h));
    }
    if (paramMsgSendCostParams.i) {
      ((HashMap)localObject).put("param_sent_by_xg", String.valueOf(paramMsgSendCostParams.i));
    }
    if (paramMsgSendCostParams.j) {
      ((HashMap)localObject).put("param_weaknet", String.valueOf(paramMsgSendCostParams.j));
    }
    int i = 0;
    if (paramMsgSendCostParams.h) {
      i = 2;
    }
    if (paramMsgSendCostParams.i) {
      i = 4;
    }
    if (paramMsgSendCostParams.j) {
      i = 8;
    }
    ((HashMap)localObject).put("param_FailCode", String.valueOf(i));
    ((HashMap)localObject).put(BaseConstants.RDM_NoChangeFailCode, "");
    StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance(paramQQAppInterface.getCurrentAccountUin(), "msgSendCostPerPhase", true, l, 0L, (HashMap)localObject, "");
  }
  
  public static void a(QQAppInterface paramQQAppInterface, int paramInt, String paramString)
  {
    Integer localInteger = Integer.valueOf(-1);
    ITempMsgBoxManager localITempMsgBoxManager = (ITempMsgBoxManager)paramQQAppInterface.getRuntimeService(ITempMsgBoxManager.class, "");
    if (localITempMsgBoxManager.isBelongToMsgBox(paramString, paramInt)) {
      localInteger = (Integer)((ITempMsgBoxService)QRoute.api(ITempMsgBoxService.class)).getServiceIdMap().get(Integer.valueOf(paramInt));
    } else if (localITempMsgBoxManager.isBelongToFilterBox(paramString, paramInt)) {
      localInteger = Integer.valueOf(10000);
    }
    if ((localInteger != null) && (localInteger.intValue() >= 0)) {
      ReportController.b(paramQQAppInterface, "dc00898", "", "", "0X800B1C3", "0X800B1C3", localInteger.intValue(), 0, "", "", "", "");
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg)
  {
    HashMap localHashMap = new HashMap();
    paramFromServiceMsg = paramFromServiceMsg.extraData;
    long l1 = 0L;
    long l3 = paramFromServiceMsg.getLong("ServerReplyCode", 0L);
    if ((l3 == 10L) || (l3 == 34L))
    {
      int i = paramToServiceMsg.extraData.getInt("ROUNTING_TYPE");
      String str = paramToServiceMsg.extraData.getString("uin");
      paramFromServiceMsg = str;
      if (str == null) {
        paramFromServiceMsg = "0";
      }
      int j = paramToServiceMsg.extraData.getInt("send_msg_req_size", 0);
      localHashMap.put("pm_peer_uin", paramFromServiceMsg);
      localHashMap.put("pm_route_type", String.valueOf(i));
      localHashMap.put("pm_req_size", String.valueOf(j));
      localHashMap.put("pm_srv_reply", String.valueOf(l3));
      long l2 = l1;
      if (i != 13)
      {
        l2 = l1;
        if (i != 9)
        {
          l2 = paramToServiceMsg.extraData.getLong("startTime", 0L);
          long l4 = System.currentTimeMillis();
          if (l2 >= 1L) {
            l1 = l4 - l2;
          }
          int k = paramToServiceMsg.extraData.getInt("msgtype");
          int m = MessageProtoCodec.a(i, paramQQAppInterface);
          localHashMap.put("pm_msg_type", String.valueOf(k));
          localHashMap.put("pm_uin_type", String.valueOf(m));
          l2 = l1;
        }
      }
      paramQQAppInterface = (AppInterface)BaseApplicationImpl.getApplication().getRuntime();
      StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance(paramQQAppInterface.getCurrentAccountUin(), "sendMsgTooLargeErrorTag", false, l2, j, localHashMap, "");
      if (QLog.isColorLevel()) {
        QLog.d("Q.msg.MessageHandler", 2, String.format("Statistics TAG:%s, duration:%dms, peerUin:%s, replyCode:%d, routingType:%s, msgReqSize:%d", new Object[] { "sendMsgTooLargeErrorTag", Long.valueOf(l2), paramFromServiceMsg, Long.valueOf(l3), Integer.valueOf(i), Integer.valueOf(j) }));
      }
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, boolean paramBoolean)
  {
    if (paramToServiceMsg != null)
    {
      if (paramFromServiceMsg == null) {
        return;
      }
      HashMap localHashMap = new HashMap();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramFromServiceMsg.getResultCode());
      localStringBuilder.append("");
      localHashMap.put("param_FailCode", localStringBuilder.toString());
      long l2 = paramToServiceMsg.extraData.getLong("msgsize", 0L);
      long l1 = paramToServiceMsg.extraData.getLong("startTime");
      long l3 = paramToServiceMsg.extraData.getInt("retryIndex", 0);
      if (l1 < 1L) {
        l1 = 0L;
      } else {
        l1 = System.currentTimeMillis() - l1;
      }
      localHashMap.put("param_retryIndex", Long.toString(l3));
      StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance(paramQQAppInterface.getCurrentAccountUin(), "dim.actSendGrpTmpMsg", paramBoolean, l1, l2, localHashMap, "");
      if (QLog.isColorLevel())
      {
        paramQQAppInterface = new StringBuilder();
        paramQQAppInterface.append("TAG[");
        paramQQAppInterface.append("dim.actSendGrpTmpMsg");
        paramQQAppInterface.append("]  success[");
        paramQQAppInterface.append(paramBoolean);
        paramQQAppInterface.append("] duration[");
        paramQQAppInterface.append(l1);
        paramQQAppInterface.append("ms] retryNum[");
        paramQQAppInterface.append(l3);
        paramQQAppInterface.append("]");
        QLog.d("Q.msg.MessageHandler", 2, paramQQAppInterface.toString());
      }
    }
  }
  
  public static void a(ToServiceMsg paramToServiceMsg, String paramString)
  {
    if ((paramToServiceMsg.extraData != null) && (paramToServiceMsg.extraData.getInt("msgtype") == -2007))
    {
      if (paramToServiceMsg.extraData.getInt("mediaType") == 2)
      {
        EmoticonOperateReport.reportAIOEmoticonMonitorSendStatus(paramString, 7);
        return;
      }
      EmoticonOperateReport.reportAIOEmoticonMonitorSendStatus(paramString, 6);
    }
  }
  
  public static void b(MessageHandler paramMessageHandler, ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, boolean paramBoolean)
  {
    if (paramToServiceMsg != null)
    {
      if (paramFromServiceMsg == null) {
        return;
      }
      if (paramToServiceMsg.extraData.getByte("binaryPic", (byte)0).byteValue() == 1) {
        return;
      }
      a(paramMessageHandler, "actSendC2CProcess", paramBoolean, paramToServiceMsg.extraData.getLong("msgsize", 0L), paramToServiceMsg, paramFromServiceMsg);
    }
  }
  
  public static void b(QQAppInterface paramQQAppInterface, ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, boolean paramBoolean)
  {
    if (paramToServiceMsg != null)
    {
      if (paramFromServiceMsg == null) {
        return;
      }
      HashMap localHashMap = new HashMap();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramFromServiceMsg.getResultCode());
      localStringBuilder.append("");
      localHashMap.put("param_FailCode", localStringBuilder.toString());
      long l2 = paramToServiceMsg.extraData.getLong("msgsize", 0L);
      long l1 = paramToServiceMsg.extraData.getLong("startTime");
      long l3 = paramToServiceMsg.extraData.getInt("retryIndex", 0);
      if (l1 < 1L) {
        l1 = 0L;
      } else {
        l1 = System.currentTimeMillis() - l1;
      }
      localHashMap.put("param_retryIndex", Long.toString(l3));
      StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance(paramQQAppInterface.getCurrentAccountUin(), "dim.actSendWpaMsg", paramBoolean, l1, l2, localHashMap, "");
      if (QLog.isColorLevel())
      {
        paramQQAppInterface = new StringBuilder();
        paramQQAppInterface.append("TAG[");
        paramQQAppInterface.append("dim.actSendWpaMsg");
        paramQQAppInterface.append("]  success[");
        paramQQAppInterface.append(paramBoolean);
        paramQQAppInterface.append("] duration[");
        paramQQAppInterface.append(l1);
        paramQQAppInterface.append("ms] retryNum[");
        paramQQAppInterface.append(l3);
        paramQQAppInterface.append("]");
        QLog.d("Q.msg.MessageHandler", 2, paramQQAppInterface.toString());
      }
    }
  }
  
  public static void c(MessageHandler paramMessageHandler, ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, boolean paramBoolean)
  {
    int i = paramToServiceMsg.extraData.getInt("ROUNTING_TYPE");
    if (i == 1)
    {
      b(paramMessageHandler, paramToServiceMsg, paramFromServiceMsg, paramBoolean);
      return;
    }
    if ((i != 3) && (i != 14) && (i != 22))
    {
      if (i == 6) {
        b(paramMessageHandler.n, paramToServiceMsg, paramFromServiceMsg, paramBoolean);
      }
    }
    else {
      a(paramMessageHandler.n, paramToServiceMsg, paramFromServiceMsg, paramBoolean);
    }
  }
  
  public static void d(MessageHandler paramMessageHandler, ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, boolean paramBoolean)
  {
    if (paramToServiceMsg != null)
    {
      if (paramFromServiceMsg == null) {
        return;
      }
      paramToServiceMsg.extraData.getByte("cBodyType", (byte)-1).byteValue();
      if (paramToServiceMsg.extraData.getInt("msgtype", -1) == -1000) {
        a(paramMessageHandler, "actSendDiscussProcess", paramBoolean, paramToServiceMsg.extraData.getLong("msgsize", 0L), paramToServiceMsg, paramFromServiceMsg);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.app.handler.Report
 * JD-Core Version:    0.7.0.1
 */