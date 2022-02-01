package com.tencent.mobileqq.app.message;

import android.os.Bundle;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.imcore.message.BaseMessageProcessor;
import com.tencent.imcore.message.MsgProxyUtils;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.imcore.message.UinTypeUtil;
import com.tencent.mobileqq.activity.ChatActivityFacade.HongbaoParams;
import com.tencent.mobileqq.app.BaseMessageHandler;
import com.tencent.mobileqq.app.MessageHandler;
import com.tencent.mobileqq.app.MessageHandlerUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageForLongMsg;
import com.tencent.mobileqq.data.MessageForReplyText;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.emoticon.EmojiStickerManager.StickerRecallListener;
import com.tencent.mobileqq.filemanager.core.FileManagerDataCenter;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.revokemsg.RevokeMsgInfo;
import com.tencent.mobileqq.service.MobileQQService;
import com.tencent.mobileqq.service.message.MessageCache;
import com.tencent.mobileqq.service.message.MessageConstants;
import com.tencent.mobileqq.service.message.MessageUtils;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.utils.SendMessageHandler;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import msf.msgsvc.msg_svc.PbC2CMsgWithDrawResp;
import msf.msgsvc.msg_svc.PbDelRoamMsgReq;
import msf.msgsvc.msg_svc.PbDelRoamMsgReq.C2CMsg;
import msf.msgsvc.msg_svc.PbDelRoamMsgReq.DisMsg;
import msf.msgsvc.msg_svc.PbDelRoamMsgReq.GrpMsg;
import msf.msgsvc.msg_svc.PbDelRoamMsgResp;
import msf.msgsvc.msg_svc.PbGroupMsgWithDrawResp;
import msf.msgsvc.msg_svc.PbGroupMsgWithDrawResp.MessageResult;
import msf.msgsvc.msg_svc.PbMsgWithDrawResp;
import msf.msgsvc.msg_svc.PbSendMsgResp;
import msf.msgsvc.msg_svc.WithDrawWordingInfo;
import msg.blessing_helper.blessing_helper.msg;

public class UncommonMessageProcessor
  extends BaseMessageProcessor
{
  private EmojiStickerManager.StickerRecallListener a;
  private final int q = 12;
  private final int r = 6;
  private final int s = 1080000;
  
  public UncommonMessageProcessor(QQAppInterface paramQQAppInterface, MessageHandler paramMessageHandler)
  {
    super(paramQQAppInterface, paramMessageHandler);
  }
  
  private void a(MessageRecord paramMessageRecord, long paramLong1, long paramLong2, int paramInt)
  {
    long l = System.currentTimeMillis();
    int j = paramMessageRecord.istroop;
    int i = MessageUtils.b(paramMessageRecord.msgUid);
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("<DELMSG><S>--->deleteMsgFromServerInner : uinType:");
      ((StringBuilder)localObject1).append(paramMessageRecord.istroop);
      ((StringBuilder)localObject1).append(" peerUin:");
      ((StringBuilder)localObject1).append(paramMessageRecord.frienduin);
      ((StringBuilder)localObject1).append(" msgType:");
      ((StringBuilder)localObject1).append(paramMessageRecord.msgtype);
      ((StringBuilder)localObject1).append(" uniseq:");
      ((StringBuilder)localObject1).append(paramMessageRecord.uniseq);
      ((StringBuilder)localObject1).append(" reqSeq:");
      ((StringBuilder)localObject1).append(paramLong1);
      ((StringBuilder)localObject1).append(" msgSeq:");
      ((StringBuilder)localObject1).append(paramMessageRecord.shmsgseq);
      ((StringBuilder)localObject1).append(" random:");
      ((StringBuilder)localObject1).append(i);
      ((StringBuilder)localObject1).append(" msgTime:");
      ((StringBuilder)localObject1).append(paramMessageRecord.time);
      ((StringBuilder)localObject1).append(" msgUid:");
      ((StringBuilder)localObject1).append(paramMessageRecord.msgUid);
      ((StringBuilder)localObject1).append(" mr.longMsgCount:");
      ((StringBuilder)localObject1).append(paramMessageRecord.longMsgCount);
      ((StringBuilder)localObject1).append(" longMsgIndex:");
      ((StringBuilder)localObject1).append(paramMessageRecord.longMsgIndex);
      ((StringBuilder)localObject1).append(" longMsgId:");
      ((StringBuilder)localObject1).append(paramMessageRecord.longMsgId);
      QLog.d("Q.msg.UncommonMessageProcessor", 2, ((StringBuilder)localObject1).toString());
    }
    if (paramMessageRecord.frienduin == null)
    {
      QLog.d("Q.msg.UncommonMessageProcessor", 1, new Object[] { "deleteMsgFromServerInner error, istroop:", Integer.valueOf(paramMessageRecord.istroop), " msgtype:", Integer.valueOf(paramMessageRecord.msgtype) });
      return;
    }
    Object localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppBaseMessageHandler.createToServiceMsg("PbMessageSvc.PbDelOneRoamMsg");
    ((ToServiceMsg)localObject1).extraData.putLong("timeOut", paramLong2);
    ((ToServiceMsg)localObject1).extraData.putLong("startTime", l);
    ((ToServiceMsg)localObject1).extraData.putInt("retryIndex", paramInt);
    ((ToServiceMsg)localObject1).extraData.putInt("uintype", j);
    ((ToServiceMsg)localObject1).extraData.putString("peeruin", paramMessageRecord.frienduin);
    ((ToServiceMsg)localObject1).extraData.putLong("uniseq", paramMessageRecord.uniseq);
    ((ToServiceMsg)localObject1).extraData.putLong("seq", paramMessageRecord.shmsgseq);
    ((ToServiceMsg)localObject1).extraData.putLong("msgSeq", paramLong1);
    msg_svc.PbDelRoamMsgReq localPbDelRoamMsgReq = new msg_svc.PbDelRoamMsgReq();
    Object localObject2;
    if ((j != 0) && (j != 1000) && (j != 1004))
    {
      if (j == 1)
      {
        localObject2 = new msg_svc.PbDelRoamMsgReq.GrpMsg();
        ((msg_svc.PbDelRoamMsgReq.GrpMsg)localObject2).group_code.set(Long.valueOf(paramMessageRecord.frienduin).longValue());
        ((msg_svc.PbDelRoamMsgReq.GrpMsg)localObject2).msg_seq.set(Long.valueOf(paramMessageRecord.shmsgseq).longValue());
        if (((paramMessageRecord instanceof MessageForReplyText)) && (((MessageForReplyText)paramMessageRecord).isBarrageMsg))
        {
          ((msg_svc.PbDelRoamMsgReq.GrpMsg)localObject2).uint32_resv_flag.set(1);
          if (QLog.isColorLevel()) {
            QLog.d("Q.msg.UncommonMessageProcessor", 2, "delete single msg, isBarrageMsg");
          }
        }
        localPbDelRoamMsgReq.grp_msg.set((MessageMicro)localObject2);
      }
      else if (j == 3000)
      {
        localObject2 = new msg_svc.PbDelRoamMsgReq.DisMsg();
        ((msg_svc.PbDelRoamMsgReq.DisMsg)localObject2).discuss_uin.set(Long.valueOf(paramMessageRecord.frienduin).longValue());
        ((msg_svc.PbDelRoamMsgReq.DisMsg)localObject2).msg_seq.set(paramMessageRecord.shmsgseq);
        localPbDelRoamMsgReq.dis_msg.set((MessageMicro)localObject2);
      }
    }
    else
    {
      paramInt = (short)(int)paramMessageRecord.shmsgseq;
      ((ToServiceMsg)localObject1).extraData.putInt("msgrandom", i);
      String str = this.jdField_a_of_type_ComTencentCommonAppAppInterface.getCurrentAccountUin();
      localObject2 = new msg_svc.PbDelRoamMsgReq.C2CMsg();
      ((msg_svc.PbDelRoamMsgReq.C2CMsg)localObject2).peer_uin.set(Long.valueOf(paramMessageRecord.frienduin).longValue());
      ((msg_svc.PbDelRoamMsgReq.C2CMsg)localObject2).from_uin.set(Long.valueOf(str).longValue());
      ((msg_svc.PbDelRoamMsgReq.C2CMsg)localObject2).msg_time.set((int)paramMessageRecord.time);
      ((msg_svc.PbDelRoamMsgReq.C2CMsg)localObject2).msg_seq.set(0xFFFF & paramInt);
      ((msg_svc.PbDelRoamMsgReq.C2CMsg)localObject2).msg_random.set(i);
      localPbDelRoamMsgReq.c2c_msg.set((MessageMicro)localObject2);
      if (paramMessageRecord.msgtype == -2005)
      {
        paramMessageRecord = ((QQAppInterface)this.jdField_a_of_type_ComTencentCommonAppAppInterface).getFileManagerDataCenter().a(paramMessageRecord.uniseq, paramMessageRecord.frienduin, 0);
        if ((paramMessageRecord != null) && (paramMessageRecord.nOLfileSessionId != 0L))
        {
          ((msg_svc.PbDelRoamMsgReq.C2CMsg)localObject2).msg_time.set((int)paramMessageRecord.msgTime);
          paramInt = (short)(int)paramMessageRecord.msgSeq;
          ((msg_svc.PbDelRoamMsgReq.C2CMsg)localObject2).msg_seq.set(paramInt & 0xFFFFFFFF);
          ((msg_svc.PbDelRoamMsgReq.C2CMsg)localObject2).msg_random.set(MessageUtils.b(paramMessageRecord.msgUid));
        }
      }
    }
    ((ToServiceMsg)localObject1).putWupBuffer(localPbDelRoamMsgReq.toByteArray());
    ((ToServiceMsg)localObject1).setTimeout(paramLong2);
    ((ToServiceMsg)localObject1).setEnableFastResend(true);
    this.jdField_a_of_type_ComTencentMobileqqAppBaseMessageHandler.a((ToServiceMsg)localObject1);
  }
  
  private void a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg)
  {
    String str = paramToServiceMsg.getServiceCmd();
    long l1 = paramToServiceMsg.extraData.getLong("uniseq");
    long l2 = paramToServiceMsg.extraData.getLong("msgSeq");
    int i = paramToServiceMsg.extraData.getInt("msgtype");
    boolean bool = paramToServiceMsg.extraData.getBoolean(MessageConstants.h);
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("<---handleSendBlessMessageError: ---cmd:");
      localStringBuilder.append(str);
      localStringBuilder.append(" uniseq:");
      localStringBuilder.append(l1);
      localStringBuilder.append(" msgSeq:");
      localStringBuilder.append(l2);
      localStringBuilder.append(" msgType:");
      localStringBuilder.append(i);
      localStringBuilder.append(" ssoseq:");
      localStringBuilder.append(paramFromServiceMsg.getRequestSsoSeq());
      localStringBuilder.append(" appseq:");
      localStringBuilder.append(paramFromServiceMsg.getAppSeq());
      localStringBuilder.append(" isRedBagVideo:");
      localStringBuilder.append(bool);
      QLog.d("Q.msg.UncommonMessageProcessor", 2, localStringBuilder.toString());
    }
    int j = paramFromServiceMsg.getResultCode();
    if (j == 2901)
    {
      l2 = System.currentTimeMillis();
      long l3 = paramToServiceMsg.extraData.getLong("key_msg_info_time_start", 0L);
      l2 = paramToServiceMsg.getTimeout() - (l2 - l3);
      if (QLog.isColorLevel())
      {
        paramFromServiceMsg = new StringBuilder();
        paramFromServiceMsg.append("handleSendBlessMessageError, 2901 error, resend timeout: ");
        paramFromServiceMsg.append(l2);
        QLog.d("Q.msg.UncommonMessageProcessor", 2, paramFromServiceMsg.toString());
      }
      if (l2 > 0L)
      {
        paramFromServiceMsg = this.jdField_a_of_type_ComTencentMobileqqAppBaseMessageHandler.createToServiceMsg("MessageSvc.PbMultiMsgSend");
        paramFromServiceMsg.extraData.putLong("uniseq", l1);
        paramFromServiceMsg.extraData.putInt("msgtype", i);
        paramFromServiceMsg.extraData.putLong("key_msg_info_time_start", System.currentTimeMillis());
        paramFromServiceMsg.setTimeout(l2);
        paramFromServiceMsg.putWupBuffer(paramToServiceMsg.getWupBuffer());
        paramFromServiceMsg.setEnableFastResend(true);
        this.jdField_a_of_type_ComTencentMobileqqAppBaseMessageHandler.a(paramFromServiceMsg);
        return;
      }
    }
    this.jdField_a_of_type_ComTencentMobileqqAppBaseMessageHandler.a(8019, false, new Object[] { Integer.valueOf(j), Long.valueOf(0L), Boolean.valueOf(false) });
  }
  
  private void a(ArrayList<RevokeMsgInfo> paramArrayList, int paramInt, String paramString)
  {
    paramArrayList = paramArrayList.iterator();
    while (paramArrayList.hasNext())
    {
      RevokeMsgInfo localRevokeMsgInfo = (RevokeMsgInfo)paramArrayList.next();
      localRevokeMsgInfo.g = paramInt;
      localRevokeMsgInfo.f = paramString;
    }
  }
  
  private void b(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg)
  {
    long l = paramToServiceMsg.extraData.getLong("bless_sendreq_time");
    this.jdField_a_of_type_ComTencentMobileqqAppBaseMessageHandler.a(8018, false, new Object[] { Integer.valueOf(0) });
    if (QLog.isColorLevel()) {
      QLog.d("Q.msg.UncommonMessageProcessor", 2, String.format("handleSendDirtyBlessTextCheckError, time: %d", new Object[] { Long.valueOf(l) }));
    }
  }
  
  private void b(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    long l2 = paramToServiceMsg.extraData.getLong("uniseq");
    long l3 = paramToServiceMsg.extraData.getLong("msgSeq");
    int j = paramToServiceMsg.extraData.getInt("msgtype");
    boolean bool2 = paramToServiceMsg.extraData.getBoolean(MessageConstants.h);
    paramToServiceMsg = new msg_svc.PbSendMsgResp();
    try
    {
      paramToServiceMsg = (msg_svc.PbSendMsgResp)paramToServiceMsg.mergeFrom((byte[])paramObject);
    }
    catch (Exception paramToServiceMsg)
    {
      if (QLog.isColorLevel())
      {
        QLog.e("Q.msg.UncommonMessageProcessor", 2, "<---handleSendBlessMessageResp : invalid.", paramToServiceMsg);
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("<---handleSendBlessMessageResp : data:");
        if (paramObject == null) {
          paramToServiceMsg = "null";
        } else {
          paramToServiceMsg = Arrays.toString((byte[])paramObject);
        }
        localStringBuilder.append(paramToServiceMsg);
        QLog.e("Q.msg.UncommonMessageProcessor", 2, localStringBuilder.toString());
      }
      paramToServiceMsg = new msg_svc.PbSendMsgResp();
    }
    int i;
    if ((paramToServiceMsg != null) && (paramToServiceMsg.result.has()))
    {
      if (paramToServiceMsg.result.get() != 0) {
        i = paramToServiceMsg.result.get();
      } else {
        i = 0;
      }
    }
    else
    {
      if (QLog.isColorLevel()) {
        QLog.e("Q.msg.UncommonMessageProcessor", 2, "<---handleSendBlessMessageResp : server did not return a valid result code, use 4 instead.");
      }
      i = 4;
    }
    long l1 = 0L;
    boolean bool1;
    if ((i != 0) && (i != 241))
    {
      if (i == 67) {
        l1 = paramToServiceMsg.uint32_svrbusy_wait_time.get();
      }
      bool1 = false;
    }
    else
    {
      bool1 = true;
    }
    this.jdField_a_of_type_ComTencentMobileqqAppBaseMessageHandler.a(8019, bool1, new Object[] { Integer.valueOf(i), Long.valueOf(l1), Boolean.valueOf(bool2) });
    if (QLog.isColorLevel()) {
      QLog.d("Q.msg.UncommonMessageProcessor", 2, String.format("<---handleSendBlessMessageResp : ----replyCode: %d isSuc: %s uniseq: %d msgSeq: %d msgType: %d waitTime: %d ssoseq: %d  appseq: %d isRedBagVideo:%s", new Object[] { Integer.valueOf(i), Boolean.valueOf(bool1), Long.valueOf(l2), Long.valueOf(l3), Integer.valueOf(j), Long.valueOf(l1), Integer.valueOf(paramFromServiceMsg.getRequestSsoSeq()), Integer.valueOf(paramFromServiceMsg.getAppSeq()), Boolean.valueOf(bool2) }));
    }
  }
  
  public static void b(String paramString, int paramInt1, int paramInt2, int paramInt3)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("pm_uin", paramString);
    localHashMap.put("pm_uinType", String.valueOf(paramInt1));
    localHashMap.put("pm_errorType", String.valueOf(paramInt2));
    localHashMap.put("pm_errorSubType", String.valueOf(paramInt3));
    AppInterface localAppInterface = (AppInterface)BaseApplicationImpl.getApplication().getRuntime();
    StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance(localAppInterface.getCurrentAccountUin(), "revokeMsgErrorTag", false, 0L, 0L, localHashMap, "");
    if (QLog.isColorLevel()) {
      QLog.d("Q.msg.UncommonMessageProcessor", 2, String.format("Statistics TAG:%s, uin:%s, uinType:%d, errorType:%d, errorSubType:%d", new Object[] { "revokeMsgErrorTag", paramString, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) }));
    }
  }
  
  private void c(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg)
  {
    int i = paramToServiceMsg.extraData.getInt("MARK_REQUEST_REVOKE_OR_DELETEMULTI ");
    long l1;
    long l2;
    if (i == 1)
    {
      ArrayList localArrayList = paramToServiceMsg.extraData.getParcelableArrayList("key_msg_info_revoke");
      String str = ((RevokeMsgInfo)localArrayList.get(0)).jdField_a_of_type_JavaLangString;
      i = ((RevokeMsgInfo)localArrayList.get(0)).jdField_a_of_type_Int;
      l1 = ((RevokeMsgInfo)localArrayList.get(0)).b;
      l2 = ((RevokeMsgInfo)localArrayList.get(0)).jdField_a_of_type_Long;
      long l3 = ((RevokeMsgInfo)localArrayList.get(0)).c;
      int j = paramFromServiceMsg.getResultCode();
      if (j == 2901)
      {
        long l4 = System.currentTimeMillis();
        long l5 = paramToServiceMsg.extraData.getLong("key_msg_info_time_start", 0L);
        l4 = paramToServiceMsg.getTimeout() - (l4 - l5);
        if (QLog.isColorLevel())
        {
          paramFromServiceMsg = new StringBuilder();
          paramFromServiceMsg.append("handleRevokeMsgError, 2901 error, resend timeout: ");
          paramFromServiceMsg.append(l4);
          QLog.d("revokeMsg", 2, paramFromServiceMsg.toString());
        }
        if (l4 > 0L)
        {
          paramFromServiceMsg = this.jdField_a_of_type_ComTencentMobileqqAppBaseMessageHandler.createToServiceMsg("PbMessageSvc.PbMsgWithDraw");
          paramFromServiceMsg.setTimeout(l4);
          paramFromServiceMsg.putWupBuffer(paramToServiceMsg.getWupBuffer());
          paramFromServiceMsg.extraData.putLong("key_msg_info_time_start", System.currentTimeMillis());
          paramFromServiceMsg.extraData.putParcelableArrayList("key_msg_info_revoke", localArrayList);
          paramFromServiceMsg.extraData.putInt("MARK_REQUEST_REVOKE_OR_DELETEMULTI ", 1);
          paramFromServiceMsg.setEnableFastResend(true);
          this.jdField_a_of_type_ComTencentMobileqqAppBaseMessageHandler.a(paramFromServiceMsg);
          return;
        }
      }
      if (QLog.isColorLevel()) {
        QLog.d("revokeMsg", 2, String.format("handleRevokeMsgError,frienduin %s, istroop %s, msgUid %s, time %s, shmsgseq %s", new Object[] { str, Integer.valueOf(i), Long.valueOf(l1), Long.valueOf(l3), Long.valueOf(l2) }));
      }
      a(str, i, d, j);
      return;
    }
    if (i == 2)
    {
      l1 = paramToServiceMsg.extraData.getLong("msgSeq");
      l2 = paramToServiceMsg.extraData.getLong("timeOut");
      this.jdField_a_of_type_ComTencentMobileqqAppBaseMessageHandler.a(paramToServiceMsg, paramFromServiceMsg);
      paramToServiceMsg = this.jdField_a_of_type_ComTencentMobileqqAppBaseMessageHandler.a(l1);
      if (paramToServiceMsg != null)
      {
        if ((paramFromServiceMsg.getResultCode() == 2901) && (this.jdField_a_of_type_ComTencentMobileqqAppBaseMessageHandler.a(paramToServiceMsg, "msf"))) {
          return;
        }
        if ((1080000L == l2) || (paramToServiceMsg.a()))
        {
          if (QLog.isColorLevel()) {
            QLog.d("Q.msg.UncommonMessageProcessor", 2, "<---handleMultiDeleteMsgError : Failed at last.");
          }
          this.jdField_a_of_type_ComTencentMobileqqAppBaseMessageHandler.a(l1);
        }
      }
    }
  }
  
  private void c(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    long l = paramToServiceMsg.extraData.getLong("bless_sendreq_time");
    paramToServiceMsg = new blessing_helper.msg();
    try
    {
      i = ((blessing_helper.msg)paramToServiceMsg.mergeFrom((byte[])paramObject)).result.get();
    }
    catch (Exception paramToServiceMsg)
    {
      int i;
      label45:
      boolean bool;
      break label45;
    }
    if (QLog.isColorLevel()) {
      QLog.d("Q.msg.UncommonMessageProcessor", 2, String.format("handleSendDirtyBlessTextCheckResp, parse data error", new Object[0]));
    }
    i = -1;
    paramToServiceMsg = this.jdField_a_of_type_ComTencentMobileqqAppBaseMessageHandler;
    if (i == 0) {
      bool = true;
    } else {
      bool = false;
    }
    paramToServiceMsg.a(8018, bool, new Object[] { Integer.valueOf(i) });
    if (QLog.isColorLevel()) {
      QLog.d("Q.msg.UncommonMessageProcessor", 2, String.format("handleSendDirtyBlessTextCheckResp, time: %d, result: %d", new Object[] { Long.valueOf(l), Integer.valueOf(i) }));
    }
  }
  
  private void d(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg)
  {
    long l1 = paramToServiceMsg.extraData.getLong("seq");
    long l2 = paramToServiceMsg.extraData.getLong("uniseq");
    long l3 = paramToServiceMsg.extraData.getLong("timeOut");
    int i = paramToServiceMsg.extraData.getInt("uintype");
    int j = paramToServiceMsg.extraData.getInt("msgrandom");
    String str = paramToServiceMsg.extraData.getString("peeruin");
    long l4 = paramToServiceMsg.extraData.getLong("msgSeq");
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("<DELMSG><E><---handleDeleteMsgError : uinType :");
      localStringBuilder.append(i);
      localStringBuilder.append(" uin:");
      localStringBuilder.append(str);
      localStringBuilder.append(" seq:");
      localStringBuilder.append(l1);
      localStringBuilder.append(" uniseq:");
      localStringBuilder.append(l2);
      localStringBuilder.append(" random:");
      localStringBuilder.append(j);
      localStringBuilder.append(" timeOut:");
      localStringBuilder.append(l3);
      localStringBuilder.append(" reqSeq:");
      localStringBuilder.append(l4);
      QLog.d("Q.msg.UncommonMessageProcessor", 2, localStringBuilder.toString());
    }
    this.jdField_a_of_type_ComTencentMobileqqAppBaseMessageHandler.a(paramToServiceMsg, paramFromServiceMsg);
    paramToServiceMsg = this.jdField_a_of_type_ComTencentMobileqqAppBaseMessageHandler.a(l4);
    if (paramToServiceMsg != null)
    {
      if ((paramFromServiceMsg.getResultCode() == 2901) && (this.jdField_a_of_type_ComTencentMobileqqAppBaseMessageHandler.a(paramToServiceMsg, "msf"))) {
        return;
      }
      if ((1080000L == l3) || (paramToServiceMsg.a()))
      {
        if (QLog.isColorLevel()) {
          QLog.d("Q.msg.UncommonMessageProcessor", 2, "<---handleDeleteMsgError : Failed at last.");
        }
        this.jdField_a_of_type_ComTencentMobileqqAppBaseMessageHandler.a(l4);
      }
    }
  }
  
  private void d(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    int i = paramToServiceMsg.extraData.getInt("MARK_REQUEST_REVOKE_OR_DELETEMULTI ");
    long l;
    Object localObject1;
    if (i == 2)
    {
      l = paramToServiceMsg.extraData.getLong("msgSeq");
      localObject1 = new msg_svc.PbMsgWithDrawResp();
    }
    try
    {
      paramObject = (msg_svc.PbMsgWithDrawResp)((msg_svc.PbMsgWithDrawResp)localObject1).mergeFrom((byte[])paramObject);
      if (paramObject.c2c_with_draw.has())
      {
        paramObject = paramObject.c2c_with_draw.get();
        if ((paramObject != null) && (!paramObject.isEmpty()))
        {
          paramObject = paramObject.iterator();
          i = 1;
          while (paramObject.hasNext())
          {
            localObject1 = (msg_svc.PbC2CMsgWithDrawResp)paramObject.next();
            k = ((msg_svc.PbC2CMsgWithDrawResp)localObject1).result.get();
            localObject2 = this.jdField_a_of_type_ComTencentMobileqqAppBaseMessageHandler.a(l);
            this.jdField_a_of_type_ComTencentMobileqqAppBaseMessageHandler.a(paramToServiceMsg, paramFromServiceMsg);
            j = i;
            if (k == 255)
            {
              this.jdField_a_of_type_ComTencentMobileqqAppBaseMessageHandler.a((SendMessageHandler)localObject2, "server");
              j = 0;
            }
            localObject1 = ((msg_svc.PbC2CMsgWithDrawResp)localObject1).errmsg.get();
            i = j;
            if (QLog.isColorLevel())
            {
              QLog.d("revokeMsg", 2, String.format("handleDeleteMultiMsgResp,result: %s, errorMsg: %s", new Object[] { Integer.valueOf(k), localObject1 }));
              i = j;
            }
          }
          j = i;
          break label420;
        }
      }
      else if (paramObject.group_with_draw.has())
      {
        paramObject = paramObject.group_with_draw.get();
        if ((paramObject != null) && (!paramObject.isEmpty()))
        {
          paramObject = paramObject.iterator();
          i = 1;
          for (;;)
          {
            j = i;
            if (!paramObject.hasNext()) {
              break;
            }
            localObject1 = (msg_svc.PbGroupMsgWithDrawResp)paramObject.next();
            k = ((msg_svc.PbGroupMsgWithDrawResp)localObject1).result.get();
            this.jdField_a_of_type_ComTencentMobileqqAppBaseMessageHandler.a(paramToServiceMsg, paramFromServiceMsg);
            localObject2 = this.jdField_a_of_type_ComTencentMobileqqAppBaseMessageHandler.a(l);
            j = i;
            if (k == 255)
            {
              this.jdField_a_of_type_ComTencentMobileqqAppBaseMessageHandler.a((SendMessageHandler)localObject2, "server");
              j = 0;
            }
            localObject1 = ((msg_svc.PbGroupMsgWithDrawResp)localObject1).errmsg.get();
            i = j;
            if (QLog.isColorLevel())
            {
              QLog.d("revokeMsg", 2, String.format("handleDeleteMultiMsgResp,result: %s, errorMsg: %s", new Object[] { Integer.valueOf(k), localObject1 }));
              i = j;
            }
          }
        }
      }
      j = 1;
      label420:
      if (j == 0) {
        break label1400;
      }
      this.jdField_a_of_type_ComTencentMobileqqAppBaseMessageHandler.a(l);
      return;
    }
    catch (Exception paramToServiceMsg)
    {
      int k;
      Object localObject2;
      int j;
      label435:
      int m;
      label1400:
      break label435;
    }
    if (QLog.isColorLevel()) {
      QLog.e("Q.msg.UncommonMessageProcessor", 2, "<---handleDeleteMultiMsgResp : ParseFrom PbMsgWithDrawResp Error.");
    }
    this.jdField_a_of_type_ComTencentMobileqqAppBaseMessageHandler.a(l);
    return;
    if (i == 1)
    {
      localObject1 = paramToServiceMsg.extraData.getParcelableArrayList("key_msg_info_revoke");
      if ((localObject1 != null) && (!((ArrayList)localObject1).isEmpty()))
      {
        m = ((RevokeMsgInfo)((ArrayList)localObject1).get(0)).jdField_a_of_type_Int;
        if (QLog.isColorLevel())
        {
          paramToServiceMsg = ((ArrayList)localObject1).iterator();
          while (paramToServiceMsg.hasNext())
          {
            paramFromServiceMsg = (RevokeMsgInfo)paramToServiceMsg.next();
            localObject2 = new StringBuilder();
            ((StringBuilder)localObject2).append("handleRevokeMsgResp,");
            ((StringBuilder)localObject2).append(paramFromServiceMsg.toString());
            QLog.d("revokeMsg", 2, ((StringBuilder)localObject2).toString());
          }
        }
        paramToServiceMsg = new msg_svc.PbMsgWithDrawResp();
        for (;;)
        {
          try
          {
            localObject2 = (msg_svc.PbMsgWithDrawResp)paramToServiceMsg.mergeFrom((byte[])paramObject);
            paramToServiceMsg = null;
            paramFromServiceMsg = null;
            if (((msg_svc.PbMsgWithDrawResp)localObject2).c2c_with_draw.has())
            {
              paramObject = ((msg_svc.PbMsgWithDrawResp)localObject2).c2c_with_draw.get();
              if ((paramObject != null) && (!paramObject.isEmpty()) && (((msg_svc.PbC2CMsgWithDrawResp)paramObject.get(0)).uint32_sub_cmd.get() == 1))
              {
                paramToServiceMsg = (msg_svc.PbC2CMsgWithDrawResp)paramObject.get(0);
                if (paramToServiceMsg.msg_wording_info.has()) {
                  a((ArrayList)localObject1, paramToServiceMsg.msg_wording_info.int32_item_id.get(), paramToServiceMsg.msg_wording_info.string_item_name.get());
                }
                paramObject = paramObject.iterator();
                paramToServiceMsg = paramFromServiceMsg;
                if (paramObject.hasNext())
                {
                  paramFromServiceMsg = (msg_svc.PbC2CMsgWithDrawResp)paramObject.next();
                  i = paramFromServiceMsg.result.get();
                  if ((i >= 0) && (i <= 1000))
                  {
                    ((QQAppInterface)this.jdField_a_of_type_ComTencentCommonAppAppInterface).getMessageFacade().a((ArrayList)localObject1);
                    paramFromServiceMsg = paramToServiceMsg;
                  }
                  else
                  {
                    paramFromServiceMsg = paramFromServiceMsg.errmsg.get();
                    a(((RevokeMsgInfo)((ArrayList)localObject1).get(0)).jdField_a_of_type_JavaLangString, m, c, i);
                  }
                  paramToServiceMsg = paramFromServiceMsg;
                  if (!QLog.isColorLevel()) {
                    continue;
                  }
                  QLog.d("revokeMsg", 2, String.format("handleRevokeMsgResp,result: %s, errorMsg: %s", new Object[] { Integer.valueOf(i), paramFromServiceMsg }));
                  paramToServiceMsg = paramFromServiceMsg;
                  continue;
                }
                return;
              }
            }
            if (((msg_svc.PbMsgWithDrawResp)localObject2).group_with_draw.has())
            {
              paramFromServiceMsg = ((msg_svc.PbMsgWithDrawResp)localObject2).group_with_draw.get();
              if ((paramFromServiceMsg != null) && (!paramFromServiceMsg.isEmpty()) && (((msg_svc.PbGroupMsgWithDrawResp)paramFromServiceMsg.get(0)).uint32_sub_cmd.get() == 1))
              {
                paramObject = (msg_svc.PbGroupMsgWithDrawResp)paramFromServiceMsg.get(0);
                if (paramObject.msg_wording_info.has()) {
                  a((ArrayList)localObject1, paramObject.msg_wording_info.int32_item_id.get(), paramObject.msg_wording_info.string_item_name.get());
                }
                paramObject = paramFromServiceMsg.iterator();
                if (paramObject.hasNext())
                {
                  localObject2 = (msg_svc.PbGroupMsgWithDrawResp)paramObject.next();
                  n = ((msg_svc.PbGroupMsgWithDrawResp)localObject2).result.get();
                  if ((n != 0) && (n != 1002) && (n != 1004) && (n != 1006)) {
                    if (((msg_svc.PbGroupMsgWithDrawResp)localObject2).failed_msg_list.has())
                    {
                      localList = ((msg_svc.PbGroupMsgWithDrawResp)localObject2).failed_msg_list.get();
                      if ((localList != null) && (!localList.isEmpty()))
                      {
                        Iterator localIterator = localList.iterator();
                        j = 0;
                        i = 0;
                        if (localIterator.hasNext())
                        {
                          paramFromServiceMsg = (msg_svc.PbGroupMsgWithDrawResp.MessageResult)localIterator.next();
                          k = paramFromServiceMsg.uint32_result.get();
                          i1 = paramFromServiceMsg.uint32_msg_seq.get();
                        }
                      }
                    }
                  }
                }
              }
            }
          }
          catch (Exception paramToServiceMsg)
          {
            int n;
            List localList;
            int i1;
            continue;
          }
          try
          {
            paramFromServiceMsg = paramFromServiceMsg.bytes_err_msg.get().toStringUtf8();
          }
          catch (Exception paramFromServiceMsg)
          {
            continue;
          }
          paramFromServiceMsg = "";
          i = j;
          if (k == 4) {
            i = j + 1;
          }
          if (QLog.isColorLevel()) {
            QLog.d("revokeMsg", 2, String.format("handleRevokeMsgResp, more failInfo, shmsgseq: %s, result: %s, errorMsg: %s", new Object[] { Integer.valueOf(i1), Integer.valueOf(k), paramFromServiceMsg }));
          }
          j = i;
          i = k;
          continue;
          if (j == localList.size())
          {
            j = 1;
          }
          else
          {
            j = 0;
            continue;
            j = 0;
            i = 0;
          }
          if (j != 0)
          {
            ((QQAppInterface)this.jdField_a_of_type_ComTencentCommonAppAppInterface).getMessageFacade().a((ArrayList)localObject1);
          }
          else
          {
            paramToServiceMsg = ((msg_svc.PbGroupMsgWithDrawResp)localObject2).errmsg.get();
            a(((RevokeMsgInfo)((ArrayList)localObject1).get(0)).jdField_a_of_type_JavaLangString, m, c, i);
            continue;
            ((QQAppInterface)this.jdField_a_of_type_ComTencentCommonAppAppInterface).getMessageFacade().a((ArrayList)localObject1);
          }
          if (QLog.isColorLevel()) {
            QLog.d("revokeMsg", 2, String.format("handleRevokeMsgResp,result: %s, errorMsg: %s", new Object[] { Integer.valueOf(n), paramToServiceMsg }));
          }
        }
        return;
        if (QLog.isColorLevel()) {
          QLog.e("Q.msg.UncommonMessageProcessor", 2, "<---handleRevokeMsgResp : ParseFrom PbMsgWithDrawResp Error.");
        }
        a(((RevokeMsgInfo)((ArrayList)localObject1).get(0)).jdField_a_of_type_JavaLangString, m, c, n);
        return;
      }
      a(" ", 0, c, m);
    }
  }
  
  private void e(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    long l1 = paramToServiceMsg.extraData.getLong("seq");
    long l2 = paramToServiceMsg.extraData.getLong("uniseq");
    int i = paramToServiceMsg.extraData.getInt("uintype");
    int j = paramToServiceMsg.extraData.getInt("msgrandom");
    Object localObject = paramToServiceMsg.extraData.getString("peeruin");
    long l3 = paramToServiceMsg.extraData.getLong("msgSeq");
    long l4 = MessageUtils.a(j);
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("<DELMSG><R><---handleDeleteMsgResp : uinType :");
      localStringBuilder.append(i);
      localStringBuilder.append(" uin:");
      localStringBuilder.append((String)localObject);
      localStringBuilder.append(" seq:");
      localStringBuilder.append(l1);
      localStringBuilder.append(" uniseq:");
      localStringBuilder.append(l2);
      localStringBuilder.append(" msgUid:");
      localStringBuilder.append(l4);
      localStringBuilder.append(" random:");
      localStringBuilder.append(j);
      localStringBuilder.append(" reqSeq:");
      localStringBuilder.append(l3);
      QLog.d("Q.msg.UncommonMessageProcessor", 2, localStringBuilder.toString());
    }
    localObject = new msg_svc.PbDelRoamMsgResp();
    try
    {
      paramObject = (msg_svc.PbDelRoamMsgResp)((msg_svc.PbDelRoamMsgResp)localObject).mergeFrom((byte[])paramObject);
    }
    catch (Exception paramObject)
    {
      label243:
      break label243;
    }
    if (QLog.isColorLevel()) {
      QLog.e("Q.msg.UncommonMessageProcessor", 2, "<---handleDeleteMsgResp : ParseFrom PbDelRoamMsgResp Error.");
    }
    paramObject = null;
    this.jdField_a_of_type_ComTencentMobileqqAppBaseMessageHandler.a(paramToServiceMsg, paramFromServiceMsg);
    paramToServiceMsg = this.jdField_a_of_type_ComTencentMobileqqAppBaseMessageHandler.a(l3);
    if (paramToServiceMsg == null)
    {
      if (QLog.isColorLevel())
      {
        paramToServiceMsg = new StringBuilder();
        paramToServiceMsg.append("<DELMSG><R><---handleSendC2CMessageResp_PB : ---cmd:");
        paramToServiceMsg.append(paramFromServiceMsg.getServiceCmd());
        paramToServiceMsg.append(",no SendMessageHandler found.");
        QLog.d("Q.msg.UncommonMessageProcessor", 2, paramToServiceMsg.toString());
      }
      return;
    }
    if ((paramObject != null) && (paramObject.result.has()))
    {
      i = paramObject.result.get();
      if (QLog.isColorLevel())
      {
        paramFromServiceMsg = new StringBuilder();
        paramFromServiceMsg.append("<DELMSG><R><---handleDeleteMsgResp : result :");
        paramFromServiceMsg.append(i);
        QLog.d("Q.msg.UncommonMessageProcessor", 2, paramFromServiceMsg.toString());
      }
      if ((i != 17) && (i != -102) && (i != 255))
      {
        this.jdField_a_of_type_ComTencentMobileqqAppBaseMessageHandler.a(l3);
        return;
      }
      if (!this.jdField_a_of_type_ComTencentMobileqqAppBaseMessageHandler.a(paramToServiceMsg, "server")) {}
    }
  }
  
  public ToServiceMsg a(List<MessageRecord> paramList, int paramInt)
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.copyTypes(TypeTransformer.java:311)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.fixTypes(TypeTransformer.java:226)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:207)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
  
  public void a(int paramInt, ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg)
  {
    switch (paramInt)
    {
    default: 
      return;
    case 8004: 
      b(paramToServiceMsg, paramFromServiceMsg);
      return;
    case 8003: 
      d(paramToServiceMsg, paramFromServiceMsg);
      return;
    case 8002: 
      c(paramToServiceMsg, paramFromServiceMsg);
      return;
    }
    a(paramToServiceMsg, paramFromServiceMsg);
  }
  
  public void a(int paramInt, Object... paramVarArgs)
  {
    switch (paramInt)
    {
    default: 
      return;
    case 8004: 
      if ((paramVarArgs != null) && (paramVarArgs.length == 3))
      {
        c((ToServiceMsg)paramVarArgs[0], (FromServiceMsg)paramVarArgs[1], paramVarArgs[2]);
        return;
      }
      a(getClass().getName(), paramInt);
      return;
    case 8003: 
      if ((paramVarArgs != null) && (paramVarArgs.length == 3))
      {
        e((ToServiceMsg)paramVarArgs[0], (FromServiceMsg)paramVarArgs[1], paramVarArgs[2]);
        return;
      }
      a(getClass().getName(), paramInt);
      return;
    case 8002: 
      if ((paramVarArgs != null) && (paramVarArgs.length == 3))
      {
        d((ToServiceMsg)paramVarArgs[0], (FromServiceMsg)paramVarArgs[1], paramVarArgs[2]);
        return;
      }
      a(getClass().getName(), paramInt);
      return;
    }
    if ((paramVarArgs != null) && (paramVarArgs.length == 3))
    {
      b((ToServiceMsg)paramVarArgs[0], (FromServiceMsg)paramVarArgs[1], paramVarArgs[2]);
      return;
    }
    a(getClass().getName(), paramInt);
  }
  
  public void a(MessageRecord paramMessageRecord)
  {
    Object localObject2;
    Object localObject1;
    if ((paramMessageRecord != null) && ((paramMessageRecord.istroop == 0) || (paramMessageRecord.istroop == 1) || (paramMessageRecord.istroop == 3000) || (paramMessageRecord.istroop == 1000) || (paramMessageRecord.istroop == 1004)))
    {
      if (!MsgProxyUtils.a(paramMessageRecord))
      {
        if (!UinTypeUtil.c(paramMessageRecord.msgtype)) {
          return;
        }
        localObject2 = new ArrayList();
        if ((paramMessageRecord instanceof MessageForLongMsg))
        {
          if (QLog.isColorLevel()) {
            QLog.w("Q.msg.UncommonMessageProcessor", 2, "--->deleteMsgFromServer : is long msg, sent from local, find the prepare slice to del.");
          }
          ((List)localObject2).addAll(((MessageForLongMsg)paramMessageRecord).longMsgFragmentList);
        }
        else
        {
          ((List)localObject2).add(paramMessageRecord);
        }
        int k = ((List)localObject2).size();
        int i = 0;
        while (i < k)
        {
          MessageRecord localMessageRecord = (MessageRecord)((List)localObject2).get(i);
          if (localMessageRecord.isSendFromLocal())
          {
            if (paramMessageRecord.extraflag == 32772)
            {
              if (paramMessageRecord.istroop == 0)
              {
                if (QLog.isColorLevel()) {
                  QLog.d("Q.msg.UncommonMessageProcessor", 2, "--->deleteMsgFromServer : delete a sending C2C msg, waitting for the response to complete.");
                }
                ((MessageCache)this.jdField_a_of_type_ComTencentCommonAppAppInterface.getMsgCache()).b(paramMessageRecord);
                return;
              }
              if (!QLog.isColorLevel()) {
                break;
              }
              QLog.d("Q.msg.UncommonMessageProcessor", 2, "--->deleteMsgFromServer : delete a sending group/dics msg, waitting for the push to complete.");
              return;
            }
            if (paramMessageRecord.extraflag == 32768) {
              return;
            }
          }
          int j = MobileQQService.seq;
          MobileQQService.seq = j + 1;
          long l = j;
          localObject1 = new SendMessageHandler();
          this.jdField_a_of_type_ComTencentMobileqqAppBaseMessageHandler.a(l, (SendMessageHandler)localObject1);
          j = 0;
          while (j < 12)
          {
            ((SendMessageHandler)localObject1).a(new UncommonMessageProcessor.3(this, localMessageRecord, l));
            j += 1;
          }
          j = 0;
          while (j < 6)
          {
            if (j == 0) {
              l = 1080000L;
            } else {
              l = (6 - j) * 1080000 / 6 - j * 2000;
            }
            ((SendMessageHandler)localObject1).a(1080000 * j / 6, l, "period");
            j += 1;
          }
          i += 1;
        }
      }
      return;
    }
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("<DELMSG><S>--->deleteMsgFromServerInner:");
      if (paramMessageRecord == null)
      {
        paramMessageRecord = "mr is Null.";
      }
      else
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append(" isTroop:");
        ((StringBuilder)localObject2).append(paramMessageRecord.istroop);
        paramMessageRecord = ((StringBuilder)localObject2).toString();
      }
      ((StringBuilder)localObject1).append(paramMessageRecord);
      QLog.d("Q.msg.UncommonMessageProcessor", 2, ((StringBuilder)localObject1).toString());
    }
  }
  
  public void a(MessageRecord paramMessageRecord, ArrayList<String> paramArrayList, ChatActivityFacade.HongbaoParams paramHongbaoParams)
  {
    paramArrayList = MessageHandlerUtils.a(this.jdField_a_of_type_ComTencentCommonAppAppInterface, paramMessageRecord, paramArrayList, paramHongbaoParams);
    if (paramArrayList == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.msg.UncommonMessageProcessor", 2, "sendBlessMsg error, msgReq is null!");
      }
      this.jdField_a_of_type_ComTencentMobileqqAppBaseMessageHandler.a(8019, false, new Object[] { Integer.valueOf(0), Long.valueOf(0L), Boolean.valueOf(false) });
      return;
    }
    a(false, true, true, 0L, new UncommonMessageProcessor.1(this, paramMessageRecord, paramArrayList));
  }
  
  public void a(EmojiStickerManager.StickerRecallListener paramStickerRecallListener)
  {
    this.jdField_a_of_type_ComTencentMobileqqEmoticonEmojiStickerManager$StickerRecallListener = paramStickerRecallListener;
  }
  
  public void a(String paramString, int paramInt1, int paramInt2, int paramInt3)
  {
    if (((MessageCache)this.jdField_a_of_type_ComTencentCommonAppAppInterface.getMsgCache()).e())
    {
      EmojiStickerManager.StickerRecallListener localStickerRecallListener = this.jdField_a_of_type_ComTencentMobileqqEmoticonEmojiStickerManager$StickerRecallListener;
      if (localStickerRecallListener != null) {
        localStickerRecallListener.a(false);
      }
      this.jdField_a_of_type_ComTencentMobileqqAppBaseMessageHandler.a(8016, false, null);
      b(paramString, paramInt1, paramInt2, paramInt3);
    }
  }
  
  public void a(List<MessageRecord> paramList)
  {
    int i = MobileQQService.seq;
    MobileQQService.seq = i + 1;
    long l = i;
    SendMessageHandler localSendMessageHandler = new SendMessageHandler();
    this.jdField_a_of_type_ComTencentMobileqqAppBaseMessageHandler.a(l, localSendMessageHandler);
    paramList = a(paramList, 2);
    if (paramList == null) {
      return;
    }
    paramList.extraData.putLong("msgSeq", l);
    int k = 0;
    i = 0;
    int j;
    for (;;)
    {
      j = k;
      if (i >= 12) {
        break;
      }
      localSendMessageHandler.a(new UncommonMessageProcessor.2(this, paramList));
      i += 1;
    }
    while (j < 6)
    {
      if (j == 0) {
        l = 1080000L;
      } else {
        l = (6 - j) * 1080000 / 6 - j * 2000;
      }
      localSendMessageHandler.a(1080000 * j / 6, l, "period");
      j += 1;
    }
  }
  
  public void a(List<MessageRecord> paramList, boolean paramBoolean)
  {
    EmojiStickerManager.StickerRecallListener localStickerRecallListener = this.jdField_a_of_type_ComTencentMobileqqEmoticonEmojiStickerManager$StickerRecallListener;
    if (localStickerRecallListener != null) {
      localStickerRecallListener.a(true);
    }
    this.jdField_a_of_type_ComTencentMobileqqAppBaseMessageHandler.a(8016, true, new Object[] { paramList, Boolean.valueOf(paramBoolean) });
  }
  
  public void b(int paramInt, ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg)
  {
    switch (paramInt)
    {
    default: 
      return;
    case 8004: 
      b(paramToServiceMsg, paramFromServiceMsg);
      return;
    case 8003: 
      d(paramToServiceMsg, paramFromServiceMsg);
      return;
    case 8002: 
      c(paramToServiceMsg, paramFromServiceMsg);
      return;
    }
    a(paramToServiceMsg, paramFromServiceMsg);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.app.message.UncommonMessageProcessor
 * JD-Core Version:    0.7.0.1
 */