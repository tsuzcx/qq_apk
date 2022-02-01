package com.tencent.mobileqq.app.message;

import OnlinePushPack.MsgInfo;
import PushNotifyPack.RequestPushNotify;
import android.content.res.Resources;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.BaseMessageHandler;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.SubAccountInfo;
import com.tencent.mobileqq.data.SubAccountMessage;
import com.tencent.mobileqq.msg.api.IConversationFacade;
import com.tencent.mobileqq.msg.api.IMessageFacade;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.service.message.DecodeProtoPkgContext;
import com.tencent.mobileqq.service.message.MessageCache;
import com.tencent.mobileqq.service.message.MessageUtils;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.subaccount.api.ISubAccountConfigApi;
import com.tencent.mobileqq.subaccount.api.ISubAccountControlService;
import com.tencent.mobileqq.subaccount.api.ISubAccountService;
import com.tencent.mobileqq.subaccount.logic.SubAccountBackProtocData;
import com.tencent.mobileqq.subaccount.logic.SubAccountThirdQQBackProtocData;
import com.tencent.mobileqq.text.QQText;
import com.tencent.mobileqq.utils.HexUtil;
import com.tencent.mobileqq.utils.TimeFormatterUtils;
import com.tencent.mobileqq.utils.api.ISubAccountMessageProcessorHelper;
import com.tencent.mobileqq.utils.httputils.PkgTools;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.SimpleAccount;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.ArrayList<Lcom.tencent.qphone.base.remote.SimpleAccount;>;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.List<Lcom.tencent.mobileqq.data.MessageRecord;>;
import java.util.List<Lmsf.msgcomm.msg_comm.Msg;>;
import mqq.app.MobileQQ;
import mqq.manager.TicketManager;
import mqq.manager.WtloginManager;
import msf.msgcomm.msg_comm.Msg;
import msf.msgcomm.msg_comm.MsgHead;
import msf.msgcomm.msg_comm.UinPairMsg;
import msf.msgsvc.msg_svc.PbBindUinGetMsgReq;
import msf.msgsvc.msg_svc.PbBindUinMsgReadedConfirmReq;
import msf.msgsvc.msg_svc.PbBindUinMsgReadedConfirmResp;
import msf.msgsvc.msg_svc.PbGetMsgResp;
import msf.msgsvc.msg_svc.PbThirdQQUnReadMsgNumReq;
import msf.msgsvc.msg_svc.PbThirdQQUnReadMsgNumReq.ThirdQQReqInfo;
import msf.msgsvc.msg_svc.PbThirdQQUnReadMsgNumResp;
import msf.msgsvc.msg_svc.PbThirdQQUnReadMsgNumResp.ThirdQQRespInfo;
import msf.msgsvc.msg_svc.PbUnReadMsgSeqReq;
import msf.msgsvc.msg_svc.PbUnReadMsgSeqResp;
import msf.onlinepush.msg_onlinepush.PbPushMsg;
import oicq.wlogin_sdk.request.Ticket;
import org.jetbrains.annotations.Nullable;
import tencent.im.msg.im_msg_body.MsgBody;
import tencent.im.msg.im_msg_body.NotOnlineFile;
import tencent.im.msg.im_msg_body.RichText;
import tencent.im.oidb.cmd0x5d0.Oidb_0x5d0.ReqBody;
import tencent.im.oidb.cmd0x5d0.Oidb_0x5d0.RspBody;
import tencent.im.oidb.oidb_sso.OIDBSSOPkg;

public class SubAccountMessageProcessor
  extends AbsSubAccountMessageProcessor
{
  public SubAccountMessageProcessor(AppInterface paramAppInterface, BaseMessageHandler paramBaseMessageHandler)
  {
    super(paramAppInterface, paramBaseMessageHandler);
  }
  
  @Nullable
  private msg_svc.PbGetMsgResp a(byte[] paramArrayOfByte, msg_svc.PbGetMsgResp paramPbGetMsgResp)
  {
    try
    {
      if (QLog.isColorLevel()) {
        QLog.d("printPBuffer", 2, HexUtil.bytes2HexStr(paramArrayOfByte));
      }
      paramArrayOfByte = (msg_svc.PbGetMsgResp)paramPbGetMsgResp.mergeFrom(paramArrayOfByte);
      return paramArrayOfByte;
    }
    catch (Exception paramArrayOfByte)
    {
      if (QLog.isColorLevel()) {
        QLog.e("SubAccountMessageProcessor", 2, "subaccount <---handleGetSubC2CMessageResp_PB : decode pb:", paramArrayOfByte);
      }
    }
    return null;
  }
  
  private void a(ISubAccountService paramISubAccountService, long paramLong1, long paramLong2, long paramLong3, int paramInt, StringBuffer paramStringBuffer, boolean paramBoolean1, MessageRecord paramMessageRecord, long paramLong4, boolean paramBoolean2, String paramString)
  {
    SubAccountMessage localSubAccountMessage = new SubAccountMessage();
    if (paramBoolean2) {
      localSubAccountMessage.frienduin = String.valueOf(AppConstants.SYSTEM_MSG_UIN);
    } else {
      localSubAccountMessage.frienduin = String.valueOf(paramLong3);
    }
    localSubAccountMessage.isread = paramBoolean1;
    localSubAccountMessage.msg = paramStringBuffer.toString();
    localSubAccountMessage.extInt = paramMessageRecord.extInt;
    localSubAccountMessage.extLong = paramMessageRecord.extLong;
    localSubAccountMessage.extraflag = paramMessageRecord.extraflag;
    localSubAccountMessage.extStr = paramMessageRecord.extStr;
    localSubAccountMessage.istroop = paramMessageRecord.istroop;
    localSubAccountMessage.isValid = paramMessageRecord.isValid;
    localSubAccountMessage.longMsgCount = paramMessageRecord.longMsgCount;
    localSubAccountMessage.longMsgId = paramMessageRecord.longMsgId;
    localSubAccountMessage.longMsgIndex = paramMessageRecord.longMsgIndex;
    localSubAccountMessage.msgUid = paramMessageRecord.msgUid;
    localSubAccountMessage.shmsgseq = paramMessageRecord.shmsgseq;
    localSubAccountMessage.uniseq = paramMessageRecord.uniseq;
    localSubAccountMessage.msgseq = paramMessageRecord.msgseq;
    if (paramBoolean1) {
      paramInt = 0;
    }
    localSubAccountMessage.unreadNum = paramInt;
    localSubAccountMessage.msgtype = -1000;
    localSubAccountMessage.selfuin = String.valueOf(paramLong1);
    if ((paramString != null) && (paramString.length() != 0)) {
      break label246;
    }
    paramString = localSubAccountMessage.frienduin;
    label246:
    localSubAccountMessage.sendername = paramString;
    localSubAccountMessage.senderuin = String.valueOf(paramLong3);
    localSubAccountMessage.subUin = Long.toString(paramLong2);
    if (paramLong4 == 0L) {
      paramLong1 = System.currentTimeMillis() / 1000L;
    } else {
      paramLong1 = paramLong4;
    }
    localSubAccountMessage.time = paramLong1;
    localSubAccountMessage.needNotify = this.q.isBackgroundPause;
    localSubAccountMessage.mTimeString = TimeFormatterUtils.a(paramLong4 * 1000L, true, ((ISubAccountControlService)this.q.getRuntimeService(ISubAccountControlService.class, "")).getDateFormate());
    localSubAccountMessage.mEmoRecentMsg = new QQText(localSubAccountMessage.msg, 3, 16);
    if (((ISubAccountMessageProcessorHelper)QRoute.api(ISubAccountMessageProcessorHelper.class)).isRedPacketMsg(paramMessageRecord)) {
      localSubAccountMessage.subExtr = "RED_PACKET";
    }
    if (((ISubAccountMessageProcessorHelper)QRoute.api(ISubAccountMessageProcessorHelper.class)).isMessageFuDai(paramMessageRecord)) {
      localSubAccountMessage.subExtr = "RED_PACKET";
    }
    if (paramISubAccountService != null) {
      paramISubAccountService.addNewMessage(localSubAccountMessage);
    }
    if (QLog.isColorLevel())
    {
      paramISubAccountService = new StringBuilder();
      paramISubAccountService.append("subaccount set msg read false hasData = false  unreadNum=");
      paramISubAccountService.append(localSubAccountMessage.unreadNum);
      QLog.d("SUB_ACCOUNT", 2, paramISubAccountService.toString());
      if (!TextUtils.isEmpty(localSubAccountMessage.msg))
      {
        paramISubAccountService = new StringBuilder();
        paramISubAccountService.append("msg=");
        paramISubAccountService.append(localSubAccountMessage.msg.charAt(0));
        QLog.d("SUB_ACCOUNT", 2, paramISubAccountService.toString());
      }
    }
  }
  
  private void a(SubAccountBackProtocData paramSubAccountBackProtocData, String paramString1, String paramString2, ISubAccountService paramISubAccountService, long paramLong1, long paramLong2, long paramLong3, List<SubAccountMessage> paramList, ArrayList<String> paramArrayList, HashMap<String, Integer> paramHashMap, long paramLong4, List<msg_comm.Msg> paramList1, int paramInt, DecodeProtoPkgContext paramDecodeProtoPkgContext)
  {
    Iterator localIterator = paramList1.iterator();
    for (;;)
    {
      SubAccountMessageProcessor localSubAccountMessageProcessor = this;
      List<SubAccountMessage> localList = paramList;
      if (!localIterator.hasNext()) {
        break;
      }
      msg_comm.Msg localMsg = (msg_comm.Msg)localIterator.next();
      if (localMsg != null)
      {
        msg_comm.MsgHead localMsgHead = (msg_comm.MsgHead)localMsg.msg_head.get();
        int i = localMsgHead.msg_type.get();
        int j = ((msg_comm.MsgHead)localMsg.msg_head.get()).c2c_cmd.get();
        Object localObject1 = null;
        String str = null;
        paramList1 = null;
        if ((193 != i) && (734 != i))
        {
          if (localSubAccountMessageProcessor.a(localMsgHead, i, j))
          {
            if (localSubAccountMessageProcessor.b(j)) {
              continue;
            }
            try
            {
              str = ((im_msg_body.NotOnlineFile)((im_msg_body.RichText)((im_msg_body.MsgBody)localMsg.msg_body.get()).rich_text.get()).not_online_file.get()).bytes_file_name.get().toStringUtf8();
              paramList1 = str;
              localObject1 = str;
              if (QLog.isColorLevel())
              {
                paramList1 = str;
                localObject1 = new StringBuilder();
                paramList1 = str;
                ((StringBuilder)localObject1).append("fileName = ");
                paramList1 = str;
                ((StringBuilder)localObject1).append(str);
                paramList1 = str;
                QLog.d("SUB_ACCOUNT", 2, ((StringBuilder)localObject1).toString());
                localObject1 = str;
              }
            }
            catch (Exception localException1)
            {
              localException1.printStackTrace();
              localObject2 = paramList1;
            }
            paramList1 = (List<msg_comm.Msg>)localObject2;
            if (TextUtils.isEmpty((CharSequence)localObject2)) {
              paramList1 = localSubAccountMessageProcessor.q.getApp().getResources().getString(2131888232);
            }
            localObject2 = ((ISubAccountMessageProcessorHelper)QRoute.api(ISubAccountMessageProcessorHelper.class)).createMsgRecordByMsgType(-2005);
            ((MessageRecord)localObject2).selfuin = String.valueOf(paramLong2);
            ((MessageRecord)localObject2).frienduin = String.valueOf(paramLong4);
            ((MessageRecord)localObject2).senderuin = String.valueOf(paramLong4);
            ((MessageRecord)localObject2).shmsgseq = localMsgHead.msg_seq.get();
            ((MessageRecord)localObject2).msgUid = localMsgHead.msg_uid.get();
            ((MessageRecord)localObject2).time = localMsgHead.msg_time.get();
            ((MessageRecord)localObject2).istroop = 0;
            ((MessageRecord)localObject2).msg = paramList1;
            ((MessageRecord)localObject2).msgtype = -2005;
            paramList1 = new ArrayList();
            paramList1.add(localObject2);
            break label653;
          }
          try
          {
            paramList1 = localSubAccountMessageProcessor.a(localMsg, paramDecodeProtoPkgContext);
            localObject2 = paramList1;
            boolean bool = localSubAccountMessageProcessor.a(paramList1);
            if (!bool) {
              break label506;
            }
          }
          catch (Exception localException2)
          {
            paramList1 = (List<msg_comm.Msg>)localObject2;
            if (!QLog.isColorLevel()) {
              break label506;
            }
          }
          QLog.w("SubAccountMessageProcessor", 2, "decodeSinglePBMsg_C2C error,", localException2);
          paramList1 = (List<msg_comm.Msg>)localObject2;
        }
        else
        {
          if (paramLong2 != paramLong4) {
            break label509;
          }
          paramList1 = localException2;
        }
        label506:
        break label653;
        label509:
        paramList1 = new ArrayList();
        Object localObject2 = ((ISubAccountMessageProcessorHelper)QRoute.api(ISubAccountMessageProcessorHelper.class)).createMsgRecordByMsgType(193);
        ((MessageRecord)localObject2).selfuin = String.valueOf(paramLong2);
        ((MessageRecord)localObject2).frienduin = String.valueOf(paramLong4);
        ((MessageRecord)localObject2).senderuin = String.valueOf(paramLong4);
        ((MessageRecord)localObject2).shmsgseq = localMsgHead.msg_seq.get();
        ((MessageRecord)localObject2).msgUid = localMsgHead.msg_uid.get();
        ((MessageRecord)localObject2).time = localMsgHead.msg_time.get();
        ((MessageRecord)localObject2).istroop = 0;
        ((MessageRecord)localObject2).msg = localSubAccountMessageProcessor.q.getApp().getResources().getString(2131917824);
        ((MessageRecord)localObject2).msgtype = 193;
        paramList1.add(localObject2);
        label653:
        if ((paramList1 != null) && (!paramList1.isEmpty()) && (localList != null) && (!paramList.isEmpty()) && (((MessageRecord)paramList1.get(0)).time < ((SubAccountMessage)localList.get(0)).time)) {
          paramList1.clear();
        }
        if ((paramList1 != null) && (paramList1.size() != 0)) {
          a(paramSubAccountBackProtocData, paramString1, paramString2, paramISubAccountService, paramLong1, paramLong3, paramList, paramArrayList, paramLong4, paramInt, localMsg, paramList1);
        } else {
          a(paramList, paramArrayList, paramHashMap, paramLong4, paramInt);
        }
      }
    }
  }
  
  private void a(SubAccountBackProtocData paramSubAccountBackProtocData, String paramString1, String paramString2, ISubAccountService paramISubAccountService, long paramLong1, long paramLong2, List<SubAccountMessage> paramList, ArrayList<String> paramArrayList, long paramLong3, int paramInt, msg_comm.Msg paramMsg, List<MessageRecord> paramList1)
  {
    StringBuffer localStringBuffer = new StringBuffer();
    MessageRecord localMessageRecord = (MessageRecord)paramList1.get(0);
    long l = localMessageRecord.time;
    Iterator localIterator = paramList1.iterator();
    boolean bool1 = false;
    while (localIterator.hasNext())
    {
      paramList1 = (MessageRecord)localIterator.next();
      Object localObject;
      if (paramList1 != null)
      {
        if (QLog.isColorLevel())
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("subaccount handleGetSubC2CMessageResp_PB mr=");
          ((StringBuilder)localObject).append(paramList1);
          QLog.d("SUB_ACCOUNT", 2, ((StringBuilder)localObject).toString());
        }
        localObject = paramList1.msg;
        if (localObject != null) {
          try
          {
            if (QLog.isColorLevel()) {
              QLog.d("SUB_ACCOUNT", 2, "subaccount handleGetSubC2CMessageResp_PB  basemsg  = ");
            }
          }
          catch (Exception localException)
          {
            localException.printStackTrace();
          }
        }
        if (paramList1.frienduin == null) {
          break;
        }
      }
      else
      {
        for (;;)
        {
          if (String.valueOf(AppConstants.SYSTEM_MSG_UIN).equalsIgnoreCase(paramList1.frienduin))
          {
            paramList1 = ((ISubAccountControlService)this.q.getRuntimeService(ISubAccountControlService.class, "")).dealSysMsgContent(this.q, (String)localObject, paramList1.msgtype, paramList1.senderuin);
            if (paramList1 != null) {
              localStringBuffer.append(paramList1);
            }
            bool2 = true;
            break;
          }
          bool2 = bool1;
          if (paramList1.msgtype == -5004)
          {
            bool2 = bool1;
            if (((ISubAccountMessageProcessorHelper)QRoute.api(ISubAccountMessageProcessorHelper.class)).isMessagePubAccount(paramList1))
            {
              bool2 = bool1;
              if ("2010741172".equals(localMessageRecord.senderuin)) {
                bool2 = true;
              }
            }
          }
          localObject = ((ISubAccountMessageProcessorHelper)QRoute.api(ISubAccountMessageProcessorHelper.class)).buildBaseMsg(this.q, paramList1, (String)localObject);
          paramList1 = (List<MessageRecord>)localObject;
          if (localObject == null) {
            paramList1 = "";
          }
          localStringBuffer.append(paramList1);
          bool1 = bool2;
        }
      }
    }
    boolean bool2 = false;
    if (localStringBuffer.length() == 0)
    {
      if (QLog.isColorLevel()) {
        QLog.d("SUB_ACCOUNT", 2, "subaccount <---handleGetSubC2CMessageResp_PB show == null || show.length() == 0; msg is not decode success.");
      }
      return;
    }
    a(paramList, paramArrayList, paramLong3, bool2);
    paramMsg = (msg_comm.MsgHead)paramMsg.msg_head.get();
    paramArrayList = null;
    paramList = paramArrayList;
    if (paramMsg != null)
    {
      paramList = paramArrayList;
      if (paramMsg.from_nick.has()) {
        paramList = paramMsg.from_nick.get();
      }
    }
    if (bool2) {
      paramList = this.q.getApp().getResources().getString(2131916963);
    }
    if (QLog.isColorLevel())
    {
      paramArrayList = new StringBuilder();
      paramArrayList.append("sub.account.msg isQQMail=");
      paramArrayList.append(bool1);
      QLog.d("SUB_ACCOUNT", 2, paramArrayList.toString());
    }
    paramSubAccountBackProtocData.l = true;
    a(paramISubAccountService, paramLong1, paramLong2, paramLong3, paramInt, localStringBuffer, bool1, localMessageRecord, l, bool2, paramList);
    ((ISubAccountControlService)this.q.getRuntimeService(ISubAccountControlService.class, "")).bindRecentItem(this.q, paramString1, 6);
    paramSubAccountBackProtocData.m = true;
    paramSubAccountBackProtocData = ((ISubAccountMessageProcessorHelper)QRoute.api(ISubAccountMessageProcessorHelper.class)).createMsgRecordByMsgType(localMessageRecord.msgtype);
    MessageRecord.copyMessageRecordBaseField(paramSubAccountBackProtocData, localMessageRecord);
    paramSubAccountBackProtocData.istroop = 7000;
    paramSubAccountBackProtocData.frienduin = paramString1;
    int i = ((IConversationFacade)this.q.getRuntimeService(IConversationFacade.class, "")).getUnreadCount(paramSubAccountBackProtocData.frienduin, paramSubAccountBackProtocData.istroop);
    if (paramISubAccountService != null) {
      paramInt = paramISubAccountService.getUnreadAllMsgNum(paramString1);
    } else {
      paramInt = 0;
    }
    int j = paramInt - i;
    if (j != 0)
    {
      ((IConversationFacade)this.q.getRuntimeService(IConversationFacade.class, "")).increaseUnread(paramSubAccountBackProtocData.frienduin, paramSubAccountBackProtocData.istroop, j);
      if (paramISubAccountService != null) {
        paramISubAccountService.updateAnotherSubAccountUnreadMsg(paramString1);
      }
    }
    if (QLog.isColorLevel())
    {
      paramISubAccountService = new StringBuilder();
      paramISubAccountService.append("sub.account.msg conversion subUin=");
      paramISubAccountService.append(paramString1);
      paramISubAccountService.append(" target=");
      paramISubAccountService.append(paramInt);
      paramISubAccountService.append(" old=");
      paramISubAccountService.append(i);
      paramISubAccountService.append(" increase=");
      paramISubAccountService.append(j);
      QLog.d("SUB_ACCOUNT", 2, paramISubAccountService.toString());
    }
    paramString1 = new ArrayList();
    paramString1.add(paramSubAccountBackProtocData);
    ((IMessageFacade)this.q.getRuntimeService(IMessageFacade.class, "")).addMessage(paramString1, paramString2, false, false, true);
    if (!bool1) {
      this.s.handleReceivedMessage(paramString1.size(), true, true);
    }
  }
  
  private void a(SubAccountBackProtocData paramSubAccountBackProtocData, String paramString1, String paramString2, msg_svc.PbGetMsgResp paramPbGetMsgResp, ISubAccountService paramISubAccountService, long paramLong1, long paramLong2, boolean paramBoolean, long paramLong3, List<SubAccountMessage> paramList, ArrayList<String> paramArrayList, HashMap<String, Integer> paramHashMap)
  {
    paramPbGetMsgResp = paramPbGetMsgResp.uin_pair_msgs.get();
    int i = 0;
    while (i < paramPbGetMsgResp.size())
    {
      Object localObject2 = (msg_comm.UinPairMsg)paramPbGetMsgResp.get(i);
      long l1 = ((msg_comm.UinPairMsg)localObject2).peer_uin.get();
      long l2 = ((msg_comm.UinPairMsg)localObject2).last_read_time.get();
      Object localObject1 = ((msg_comm.UinPairMsg)localObject2).msg.get();
      if (!paramBoolean) {
        paramArrayList.add(Long.toString(l1));
      }
      int j = ((msg_comm.UinPairMsg)localObject2).unread_msg_num.get();
      Object localObject3;
      if (QLog.isColorLevel())
      {
        localObject3 = new StringBuilder();
        ((StringBuilder)localObject3).append("subaccount <---handleGetSubC2CMessageResp_PB pkgPeerUi cc n:");
        ((StringBuilder)localObject3).append(l1);
        QLog.d("SUB_ACCOUNT", 2, ((StringBuilder)localObject3).toString());
      }
      if ((localObject1 != null) && (((List)localObject1).size() != 0) && (j != 0))
      {
        if (QLog.isColorLevel())
        {
          localObject3 = new StringBuilder();
          ((StringBuilder)localObject3).append("subaccount <---handleGetSubC2CMessageResp_PB pkgPeerUin:");
          ((StringBuilder)localObject3).append(l1);
          ((StringBuilder)localObject3).append(",msgList size:");
          ((StringBuilder)localObject3).append(((List)localObject1).size());
          QLog.d("SUB_ACCOUNT", 2, ((StringBuilder)localObject3).toString());
        }
        localObject3 = new DecodeProtoPkgContext(paramLong2, l1, false, false, false, true);
        if ((localObject1 != null) && (((List)localObject1).size() > 0))
        {
          Collections.sort((List)localObject1, new SubAccountMessageProcessor.1(this));
          boolean bool;
          if ((((msg_comm.UinPairMsg)localObject2).msg_completed.has()) && (((msg_comm.UinPairMsg)localObject2).msg_completed.get() != 0)) {
            bool = true;
          } else {
            bool = false;
          }
          if (QLog.isColorLevel())
          {
            localObject2 = new StringBuilder();
            ((StringBuilder)localObject2).append("subaccount <---handleGetSubC2CMessageResp_PB pkgPeerUin:");
            ((StringBuilder)localObject2).append(l1);
            ((StringBuilder)localObject2).append("msgList size: ");
            ((StringBuilder)localObject2).append(((List)localObject1).size());
            ((StringBuilder)localObject2).append(",uMsgCompleted:");
            ((StringBuilder)localObject2).append(bool);
            ((StringBuilder)localObject2).append(",lastReadTime:");
            ((StringBuilder)localObject2).append(l2 & 0xFFFFFFFF);
            QLog.d("SUB_ACCOUNT", 2, ((StringBuilder)localObject2).toString());
          }
          a(paramSubAccountBackProtocData, paramString1, paramString2, paramISubAccountService, paramLong1, paramLong2, paramLong3, paramList, paramArrayList, paramHashMap, l1, (List)localObject1, j, (DecodeProtoPkgContext)localObject3);
        }
      }
      else
      {
        if (QLog.isColorLevel())
        {
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append("subaccount <PbGetMsg><R><---handleGetSubC2CMessageResp_PB msgList == null || msgList.size() == 0 msg is null ");
          ((StringBuilder)localObject1).append(l1);
          QLog.d("SUB_ACCOUNT", 2, ((StringBuilder)localObject1).toString());
        }
        a(paramList, paramArrayList, paramHashMap, l1, j);
      }
      i += 1;
    }
  }
  
  private void a(SubAccountBackProtocData paramSubAccountBackProtocData, String paramString, msg_svc.PbGetMsgResp paramPbGetMsgResp, ISubAccountService paramISubAccountService, int paramInt)
  {
    paramSubAccountBackProtocData.a = 1004;
    paramSubAccountBackProtocData.i = paramInt;
    paramSubAccountBackProtocData.b = paramPbGetMsgResp.errmsg.get();
    paramSubAccountBackProtocData.l = true;
    ISubAccountControlService localISubAccountControlService = (ISubAccountControlService)this.q.getRuntimeService(ISubAccountControlService.class, "");
    localISubAccountControlService.setBindUinStatus(this.q, (byte)0, paramString);
    localISubAccountControlService.bindRecentItem(this.q, paramString, 6);
    paramSubAccountBackProtocData.m = true;
    paramISubAccountService.updateA2(paramString, null, true);
    boolean bool = paramISubAccountService.setStatus(paramString, 3);
    paramISubAccountService.updateServerError(paramString, paramInt, paramPbGetMsgResp.errmsg.get());
    paramISubAccountService.clearUnreadNum(paramString);
    if (bool)
    {
      paramInt = 1 - ((IConversationFacade)this.q.getRuntimeService(IConversationFacade.class, "")).getUnreadCount(paramString, 7000);
      if (paramInt != 0)
      {
        ((IConversationFacade)this.q.getRuntimeService(IConversationFacade.class, "")).increaseUnread(paramString, 7000, paramInt);
        ((IMessageFacade)this.q.getRuntimeService(IMessageFacade.class, "")).setChangeAndNotify(new String[] { AppConstants.SUBACCOUNT_ASSISTANT_UIN, paramString });
      }
      if (QLog.isColorLevel())
      {
        paramSubAccountBackProtocData = new StringBuilder();
        paramSubAccountBackProtocData.append("processSubAccountMessage() hint need to verify,msg num=1, subUin=");
        paramSubAccountBackProtocData.append(paramString);
        QLog.d("SUB_ACCOUNT", 2, paramSubAccountBackProtocData.toString());
      }
    }
    this.q.updateSubAccountLogin(paramString, false);
    this.q.getApplication().refreAccountList();
  }
  
  private void a(String paramString, ISubAccountService paramISubAccountService, boolean paramBoolean, long paramLong, List<SubAccountMessage> paramList, ArrayList<String> paramArrayList, HashMap<String, Integer> paramHashMap)
  {
    if ((paramList != null) && (paramList.size() > 0) && (paramBoolean))
    {
      if (QLog.isColorLevel()) {
        QLog.d("SUB_ACCOUNT", 2, "handleGetSubC2CMessageResp_PB dbSubMsgList......");
      }
      int i = 0;
      while (i < paramList.size())
      {
        SubAccountMessage localSubAccountMessage = (SubAccountMessage)paramList.get(i);
        if ((localSubAccountMessage != null) && (localSubAccountMessage.frienduin != null) && (!localSubAccountMessage.frienduin.equals(String.valueOf(AppConstants.SYSTEM_MSG_UIN))) && (!localSubAccountMessage.frienduin.equals(String.valueOf(13002L))))
        {
          Iterator localIterator = paramArrayList.iterator();
          while (localIterator.hasNext())
          {
            String str = (String)localIterator.next();
            if ((str != null) && (localSubAccountMessage.frienduin.equalsIgnoreCase(str)))
            {
              j = 1;
              break label179;
            }
          }
          int j = 0;
          label179:
          if ((j != 0) && (paramHashMap.containsKey(localSubAccountMessage.frienduin)) && (paramISubAccountService != null)) {
            paramISubAccountService.updateUnreadNum(this.q, String.valueOf(paramLong), localSubAccountMessage.frienduin, ((Integer)paramHashMap.get(localSubAccountMessage.frienduin)).intValue());
          }
          if ((j == 0) && (paramISubAccountService != null))
          {
            j = paramISubAccountService.removeMessage(String.valueOf(paramLong), localSubAccountMessage.frienduin);
            if (j != 0)
            {
              ((IConversationFacade)this.q.getRuntimeService(IConversationFacade.class, "")).increaseUnread(paramString, 7000, j);
              ((IMessageFacade)this.q.getRuntimeService(IMessageFacade.class, "")).setChangeAndNotify(new String[] { AppConstants.SUBACCOUNT_ASSISTANT_UIN, paramString });
            }
          }
        }
        i += 1;
      }
    }
  }
  
  private void a(List<SubAccountMessage> paramList, ArrayList<String> paramArrayList, long paramLong, boolean paramBoolean)
  {
    if ((paramList != null) && (!paramBoolean))
    {
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        Object localObject = (SubAccountMessage)paramList.next();
        if (localObject != null)
        {
          localObject = ((SubAccountMessage)localObject).frienduin;
          if ((localObject != null) && (((String)localObject).equalsIgnoreCase(String.valueOf(paramLong)))) {
            paramArrayList.add(String.valueOf(paramLong));
          }
        }
      }
    }
  }
  
  private void a(List<SubAccountMessage> paramList, ArrayList<String> paramArrayList, HashMap<String, Integer> paramHashMap, long paramLong, int paramInt)
  {
    if (paramList != null)
    {
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        Object localObject = (SubAccountMessage)paramList.next();
        if (localObject != null)
        {
          localObject = ((SubAccountMessage)localObject).frienduin;
          if ((localObject != null) && (((String)localObject).equalsIgnoreCase(String.valueOf(paramLong))))
          {
            paramArrayList.add(String.valueOf(paramLong));
            paramHashMap.put(String.valueOf(paramLong), Integer.valueOf(paramInt));
          }
        }
      }
    }
  }
  
  private void a(msg_comm.Msg paramMsg, FromServiceMsg paramFromServiceMsg, msg_onlinepush.PbPushMsg paramPbPushMsg)
  {
    paramMsg = (msg_comm.MsgHead)paramMsg.msg_head.get();
    long l1 = paramMsg.from_uin.get();
    long l2 = paramMsg.msg_time.get();
    long l3 = paramPbPushMsg.uint64_bind_uin.get();
    if (l1 == l3)
    {
      if (QLog.isColorLevel()) {
        QLog.d("SubAccountMessageProcessor", 2, new Object[] { "processSubAccountTroopMessage fromUin = bindUin:", Long.valueOf(l3), " fromUin:", Long.valueOf(l1), " msgTime:", Long.valueOf(l2) });
      }
      return;
    }
    paramMsg = new SubAccountMessage();
    paramMsg.frienduin = String.valueOf(13002L);
    paramMsg.unreadNum = 1;
    paramMsg.msgtype = -1000;
    paramMsg.time = l2;
    paramMsg.senderuin = String.valueOf(13002L);
    paramMsg.subUin = String.valueOf(l3);
    paramMsg.istroop = 1;
    paramMsg.sendername = HardCodeUtil.a(2131916888);
    paramMsg.msg = "";
    paramPbPushMsg = (ISubAccountService)this.q.getRuntimeService(ISubAccountService.class, "");
    if (paramPbPushMsg != null)
    {
      paramPbPushMsg.updateTroopMsgRedDot(paramMsg);
      paramPbPushMsg.addNewMessage(paramMsg);
      paramPbPushMsg.updateAnotherSubAccountUnreadMsg(paramMsg.subUin);
    }
    if (QLog.isColorLevel()) {
      QLog.d("SubAccountMessageProcessor", 2, new Object[] { "processSubAccountTroopMessage bindUin:", Long.valueOf(l3), " fromUin:", Long.valueOf(l1), " msgTime:", Long.valueOf(l2) });
    }
    paramMsg = new SubAccountBackProtocData();
    paramMsg.c = paramFromServiceMsg.getUin();
    paramMsg.d = String.valueOf(l3);
    paramMsg.l = true;
    paramMsg.m = true;
    paramMsg.a = 0;
    a(8003, true, paramMsg);
  }
  
  private void a(Oidb_0x5d0.RspBody paramRspBody, String paramString1, String paramString2, int paramInt1, int paramInt2)
  {
    new SubAccountMessageProcessor.2(this, paramRspBody, paramString2, paramString1, paramInt1, paramInt2).execute(new Void[0]);
  }
  
  private boolean a(SubAccountBackProtocData paramSubAccountBackProtocData, long paramLong)
  {
    if (paramLong == -1L)
    {
      a(8003, false, paramSubAccountBackProtocData);
      if (QLog.isColorLevel()) {
        QLog.d("SUB_ACCOUNT", 2, "subaccount <PbGetMsg><R><---handleGetSubC2CMessageResp_PB selfUin == -1 ");
      }
      paramSubAccountBackProtocData = new HashMap();
      paramSubAccountBackProtocData.put("param_FailCode", "12014");
      paramSubAccountBackProtocData.put("fail_step", "selfUin_null");
      paramSubAccountBackProtocData.put("fail_location", "MessageHandler");
      StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance(this.q.getCurrentAccountUin(), "actSBGetMsg", false, 0L, 0L, paramSubAccountBackProtocData, "");
      return true;
    }
    return false;
  }
  
  private boolean a(SubAccountBackProtocData paramSubAccountBackProtocData, String paramString)
  {
    if (paramString == null)
    {
      a(8003, false, paramSubAccountBackProtocData);
      if (QLog.isColorLevel()) {
        QLog.d("SUB_ACCOUNT", 2, "subaccount <PbGetMsg><R><---handleGetSubC2CMessageResp_PB tmpBackUin == null ");
      }
      paramSubAccountBackProtocData = new HashMap();
      paramSubAccountBackProtocData.put("param_FailCode", "12014");
      paramSubAccountBackProtocData.put("fail_step", "backuin_null");
      paramSubAccountBackProtocData.put("fail_location", "MessageHandler");
      StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance(this.q.getCurrentAccountUin(), "actSBGetMsg", false, 0L, 0L, paramSubAccountBackProtocData, "");
      return true;
    }
    return false;
  }
  
  private boolean a(SubAccountBackProtocData paramSubAccountBackProtocData, String paramString, msg_svc.PbGetMsgResp paramPbGetMsgResp, ISubAccountService paramISubAccountService)
  {
    if ((paramPbGetMsgResp.result.has()) && (paramPbGetMsgResp.result.get() == 0)) {
      return false;
    }
    int j = paramPbGetMsgResp.result.get();
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("subaccount <PbGetMsg><R><---handleGetSubC2CMessageResp_PB rspResult = ");
      ((StringBuilder)localObject).append(j);
      QLog.d("SUB_ACCOUNT", 2, ((StringBuilder)localObject).toString());
    }
    Object localObject = new HashMap();
    ((HashMap)localObject).put("param_FailCode", "12015");
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("result_");
    localStringBuilder.append(j);
    ((HashMap)localObject).put("fail_step", localStringBuilder.toString());
    ((HashMap)localObject).put("fail_location", "MessageHandler");
    StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance(this.q.getCurrentAccountUin(), "actSBGetMsg", false, 0L, 0L, (HashMap)localObject, "");
    int i = j;
    if (j > 100) {
      i = j - 100;
    }
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("subaccount <PbGetMsg><R><---handleGetSubC2CMessageResp_PB really rspResult = ");
      ((StringBuilder)localObject).append(i);
      QLog.d("SUB_ACCOUNT", 2, ((StringBuilder)localObject).toString());
    }
    localObject = (ISubAccountControlService)this.q.getRuntimeService(ISubAccountControlService.class, "");
    if (i != 1)
    {
      if (i != 1000)
      {
        if (i != 1001)
        {
          if (c(i)) {
            a(paramSubAccountBackProtocData, paramString, paramPbGetMsgResp, paramISubAccountService, i);
          } else {
            paramSubAccountBackProtocData.a = 1000;
          }
        }
        else
        {
          paramSubAccountBackProtocData.a = 1002;
          ((ISubAccountControlService)localObject).setBindUinStatus(this.q, (byte)0, paramString);
          ((ISubAccountControlService)localObject).clearAllData(this.q, paramString);
        }
      }
      else
      {
        paramSubAccountBackProtocData.a = 1008;
        ((ISubAccountControlService)localObject).clearAllData(this.q, "sub.uin.all");
      }
    }
    else {
      paramSubAccountBackProtocData.a = 1006;
    }
    a(8003, false, paramSubAccountBackProtocData);
    if (QLog.isColorLevel()) {
      QLog.d("SUB_ACCOUNT", 2, "subaccount <PbGetMsg><R><---handleGetSubC2CMessageResp_PB getMsgResp == null || !getMsgResp.result.has() || getMsgResp.result.get() != 0 ");
    }
    return true;
  }
  
  private boolean a(SubAccountBackProtocData paramSubAccountBackProtocData, msg_svc.PbGetMsgResp paramPbGetMsgResp)
  {
    if (paramPbGetMsgResp == null)
    {
      paramPbGetMsgResp = new HashMap();
      paramPbGetMsgResp.put("param_FailCode", "12014");
      paramPbGetMsgResp.put("fail_step", "getmsgresp_null");
      paramPbGetMsgResp.put("fail_location", "MessageHandler");
      StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance(this.q.getCurrentAccountUin(), "actSBGetMsg", false, 0L, 0L, paramPbGetMsgResp, "");
      a(8003, false, paramSubAccountBackProtocData);
      return true;
    }
    return false;
  }
  
  private boolean a(ToServiceMsg paramToServiceMsg, SubAccountBackProtocData paramSubAccountBackProtocData, byte paramByte, int paramInt, long paramLong, ArrayList<String> paramArrayList)
  {
    if (paramByte > 0) {
      if (paramLong > 0L)
      {
        paramToServiceMsg = paramToServiceMsg.extraData.getString("subaccount_a2");
        if (paramToServiceMsg != null)
        {
          a(paramByte, paramInt, String.valueOf(paramLong), paramToServiceMsg, paramArrayList);
          paramSubAccountBackProtocData.j = false;
          a(8003, true, paramSubAccountBackProtocData);
          return true;
        }
      }
      else if (QLog.isColorLevel())
      {
        QLog.e("SubAccountMessageProcessor", 2, "subaccount handleGetSubC2CMessageResp_PB error happen, binduin <= 0 from server");
      }
    }
    return false;
  }
  
  private boolean a(List<MessageRecord> paramList)
  {
    if ((paramList != null) && (paramList.size() > 0))
    {
      paramList = (MessageRecord)paramList.get(0);
      if ((paramList.istroop == 1033) || (paramList.istroop == 1034)) {
        return true;
      }
    }
    return false;
  }
  
  private boolean a(msg_comm.MsgHead paramMsgHead, int paramInt1, int paramInt2)
  {
    return (MessageUtils.d(paramInt1)) && (paramMsgHead.c2c_cmd.has()) && ((paramInt2 == 169) || (paramInt2 == 241) || (paramInt2 == 242) || (paramInt2 == 243) || (paramInt2 == 129) || (paramInt2 == 131) || (paramInt2 == 133));
  }
  
  private boolean a(oidb_sso.OIDBSSOPkg paramOIDBSSOPkg)
  {
    boolean bool2 = true;
    boolean bool1 = bool2;
    if (paramOIDBSSOPkg != null)
    {
      bool1 = bool2;
      if (paramOIDBSSOPkg.uint32_result.has())
      {
        bool1 = bool2;
        if (paramOIDBSSOPkg.bytes_bodybuffer.has())
        {
          bool1 = bool2;
          if (paramOIDBSSOPkg.bytes_bodybuffer.get() != null)
          {
            if (paramOIDBSSOPkg.uint32_service_type.get() != 1) {
              return true;
            }
            bool1 = false;
          }
        }
      }
    }
    return bool1;
  }
  
  private boolean b(int paramInt)
  {
    return (paramInt == 129) || (paramInt == 131) || (paramInt == 133) || (paramInt == 135) || (paramInt == 243);
  }
  
  private void c(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    String str3 = "null";
    String str1;
    if (paramToServiceMsg == null) {
      str1 = "null";
    } else {
      str1 = paramToServiceMsg.extraData.getString("nextAction");
    }
    String str2;
    if (paramToServiceMsg == null) {
      str2 = "null";
    } else {
      str2 = paramToServiceMsg.extraData.getString("subAccount");
    }
    int i = -1;
    long l = 0L;
    paramFromServiceMsg = new msg_svc.PbBindUinMsgReadedConfirmResp();
    Object localObject2 = null;
    Object localObject1 = null;
    Object localObject3 = null;
    int j = i;
    try
    {
      msg_svc.PbBindUinMsgReadedConfirmResp localPbBindUinMsgReadedConfirmResp = (msg_svc.PbBindUinMsgReadedConfirmResp)paramFromServiceMsg.mergeFrom((byte[])paramObject);
      j = i;
      i = localPbBindUinMsgReadedConfirmResp.result.get();
      j = i;
      if (localPbBindUinMsgReadedConfirmResp.sync_cookie.has())
      {
        j = i;
        paramFromServiceMsg = localPbBindUinMsgReadedConfirmResp.sync_cookie.get().toByteArray();
      }
      else
      {
        paramFromServiceMsg = null;
      }
      localObject1 = localObject2;
      try
      {
        if (localPbBindUinMsgReadedConfirmResp.bind_uin.has())
        {
          localObject1 = localObject2;
          l = localPbBindUinMsgReadedConfirmResp.bind_uin.get();
        }
        paramObject = localObject3;
        localObject1 = localObject2;
        if (localPbBindUinMsgReadedConfirmResp.errmsg.has())
        {
          localObject1 = localObject2;
          paramObject = localPbBindUinMsgReadedConfirmResp.errmsg.get();
        }
        localObject1 = paramObject;
        j = i;
        localObject2 = paramFromServiceMsg;
        localObject3 = paramObject;
        if (!QLog.isColorLevel()) {
          break label428;
        }
        localObject1 = paramObject;
        localObject3 = new StringBuilder();
        localObject1 = paramObject;
        ((StringBuilder)localObject3).append("handleConfirmSubAccountMsgNumReaded() subUin=");
        localObject1 = paramObject;
        ((StringBuilder)localObject3).append(str2);
        localObject1 = paramObject;
        ((StringBuilder)localObject3).append(" lSubUin=");
        localObject1 = paramObject;
        ((StringBuilder)localObject3).append(l);
        localObject1 = paramObject;
        ((StringBuilder)localObject3).append(" errMsg=");
        localObject1 = paramObject;
        ((StringBuilder)localObject3).append(paramObject);
        localObject1 = paramObject;
        ((StringBuilder)localObject3).append(" cookie=");
        if (paramFromServiceMsg == null)
        {
          localObject2 = "null";
        }
        else
        {
          localObject1 = paramObject;
          localObject2 = Integer.valueOf(paramFromServiceMsg.length);
        }
        localObject1 = paramObject;
        ((StringBuilder)localObject3).append(localObject2);
        localObject1 = paramObject;
        QLog.d("SUB_ACCOUNT", 2, ((StringBuilder)localObject3).toString());
        j = i;
        localObject2 = paramFromServiceMsg;
        localObject3 = paramObject;
      }
      catch (Exception paramObject) {}
      j = i;
    }
    catch (Exception paramObject)
    {
      paramFromServiceMsg = null;
      i = j;
    }
    localObject2 = paramFromServiceMsg;
    localObject3 = localObject1;
    if (QLog.isColorLevel())
    {
      QLog.e("SUB_ACCOUNT", 2, "handleConfirmSubAccountMsgNumReaded() decode pb:", paramObject);
      localObject3 = localObject1;
      localObject2 = paramFromServiceMsg;
      j = i;
    }
    label428:
    if (QLog.isColorLevel())
    {
      paramFromServiceMsg = new StringBuilder();
      paramFromServiceMsg.append("handleConfirmSubAccountMsgNumReaded() ssoSeq:");
      if (paramToServiceMsg == null) {
        paramToServiceMsg = "null";
      } else {
        paramToServiceMsg = Integer.valueOf(paramToServiceMsg.getRequestSsoSeq());
      }
      paramFromServiceMsg.append(paramToServiceMsg);
      paramFromServiceMsg.append(" result=");
      paramFromServiceMsg.append(j);
      paramFromServiceMsg.append(" syncCookie=");
      if (localObject2 == null) {
        paramToServiceMsg = str3;
      } else {
        paramToServiceMsg = Integer.toString(localObject2.length);
      }
      paramFromServiceMsg.append(paramToServiceMsg);
      paramFromServiceMsg.append(" errms=");
      paramFromServiceMsg.append(String.valueOf(localObject3));
      QLog.d("SUB_ACCOUNT", 2, paramFromServiceMsg.toString());
    }
    boolean bool;
    if (j == 0)
    {
      paramToServiceMsg = (ISubAccountService)this.q.getRuntimeService(ISubAccountService.class, "");
      if (paramToServiceMsg != null) {
        paramToServiceMsg.updateCookie(str2, (byte[])localObject2);
      }
      bool = true;
    }
    else
    {
      bool = false;
    }
    a(8011, bool, new String[] { str2, str1 });
  }
  
  private boolean c(int paramInt)
  {
    return (paramInt == 1200) || (paramInt == 1214) || (paramInt == 1215) || (paramInt == 1218) || (paramInt == 1232) || (paramInt == 1233) || (paramInt == 1240) || (paramInt == 1241) || (paramInt == 1242) || (paramInt == 1221);
  }
  
  private void d(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    SubAccountBackProtocData localSubAccountBackProtocData = new SubAccountBackProtocData();
    String str1 = paramToServiceMsg.extraData.getString("subAccount");
    String str2 = paramToServiceMsg.getUin();
    localSubAccountBackProtocData.c = str2;
    localSubAccountBackProtocData.d = str1;
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("subaccount cmd= CMD_MESSAGESERVICE_GETSUBACCOUNTMSG_PB handleGetSubC2CMessageResp_PB subUin=");
      ((StringBuilder)localObject1).append(str1);
      QLog.d("SUB_ACCOUNT", 2, ((StringBuilder)localObject1).toString());
    }
    Object localObject1 = new msg_svc.PbGetMsgResp();
    msg_svc.PbGetMsgResp localPbGetMsgResp = a((byte[])paramObject, (msg_svc.PbGetMsgResp)localObject1);
    if (QLog.isColorLevel())
    {
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("subaccount <---handleGetSubC2CMessageResp_PB ssoSeq:");
      localObject1 = "null";
      if (paramToServiceMsg == null) {
        paramObject = "null";
      } else {
        paramObject = Integer.valueOf(paramToServiceMsg.getRequestSsoSeq());
      }
      ((StringBuilder)localObject2).append(paramObject);
      ((StringBuilder)localObject2).append(" msgStruct.cReplyCode: ");
      if (localPbGetMsgResp == null) {
        paramObject = "null";
      } else {
        paramObject = Integer.valueOf(localPbGetMsgResp.result.get());
      }
      ((StringBuilder)localObject2).append(paramObject);
      ((StringBuilder)localObject2).append(",hasSyncCookie:");
      if (localPbGetMsgResp == null) {
        paramObject = "null";
      } else {
        paramObject = Boolean.valueOf(localPbGetMsgResp.sync_cookie.has());
      }
      ((StringBuilder)localObject2).append(paramObject);
      ((StringBuilder)localObject2).append(",syncFlag:");
      if (localPbGetMsgResp == null) {
        paramObject = localObject1;
      } else {
        paramObject = Integer.valueOf(localPbGetMsgResp.sync_flag.get());
      }
      ((StringBuilder)localObject2).append(paramObject);
      QLog.d("SUB_ACCOUNT", 2, ((StringBuilder)localObject2).toString());
    }
    if (a(localSubAccountBackProtocData, localPbGetMsgResp)) {
      return;
    }
    Object localObject2 = (ISubAccountService)this.q.getRuntimeService(ISubAccountService.class, "");
    if (a(localSubAccountBackProtocData, str1, localPbGetMsgResp, (ISubAccountService)localObject2)) {
      return;
    }
    ((ISubAccountService)localObject2).setStatus(str1, 1);
    paramObject = null;
    localObject1 = paramFromServiceMsg.getUin();
    long l1;
    try
    {
      l1 = Long.parseLong(str1);
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
      QLog.d("SUB_ACCOUNT", 1, "subaccount <PbGetMsg><R><---handleGetSubC2CMessageResp_PB subAccount parselong error ");
      l1 = -1L;
    }
    if (a(localSubAccountBackProtocData, (String)localObject1)) {
      return;
    }
    try
    {
      l2 = Long.valueOf(paramFromServiceMsg.getUin()).longValue();
    }
    catch (Exception paramFromServiceMsg)
    {
      long l2;
      label417:
      int i;
      byte b;
      boolean bool;
      long l3;
      List localList;
      break label417;
    }
    if (QLog.isColorLevel()) {
      QLog.d("SUB_ACCOUNT", 2, "subaccount <PbGetMsg><R><---handleGetSubC2CMessageResp_PB selfUin parselong error ");
    }
    l2 = -1L;
    if (a(localSubAccountBackProtocData, l2)) {
      return;
    }
    if (!((ISubAccountService)localObject2).getNotifySwitch())
    {
      if (QLog.isColorLevel()) {
        QLog.d("SUB_ACCOUNT", 2, "processSubAccountMessage return as notify off");
      }
      return;
    }
    paramFromServiceMsg = paramObject;
    if (localPbGetMsgResp.sync_cookie.has()) {
      paramFromServiceMsg = localPbGetMsgResp.sync_cookie.get().toByteArray();
    }
    if (localPbGetMsgResp.sync_flag.has()) {
      i = localPbGetMsgResp.sync_flag.get();
    } else {
      i = 2;
    }
    if (i < 2)
    {
      b = (byte)1;
      bool = false;
    }
    else
    {
      b = 0;
      bool = true;
    }
    l3 = 0L;
    if (localPbGetMsgResp.bind_uin.has()) {
      l3 = localPbGetMsgResp.bind_uin.get();
    }
    localList = ((ISubAccountService)localObject2).getAllMessage(Long.toString(l3));
    localObject1 = paramToServiceMsg.extraData.getStringArrayList("hadGetMsgListUin");
    paramObject = localObject1;
    if (localObject1 == null) {
      paramObject = new ArrayList();
    }
    localObject1 = new HashMap();
    a(localSubAccountBackProtocData, str1, str2, localPbGetMsgResp, (ISubAccountService)localObject2, l2, l1, bool, l3, localList, paramObject, (HashMap)localObject1);
    a(str1, (ISubAccountService)localObject2, bool, l3, localList, paramObject, (HashMap)localObject1);
    ((ISubAccountService)localObject2).updateCookie(str1, paramFromServiceMsg);
    paramFromServiceMsg = new HashMap();
    paramFromServiceMsg.put("param_FailCode", "12016");
    paramFromServiceMsg.put("fail_step", "success");
    paramFromServiceMsg.put("fail_location", "MessageHandler");
    StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance(this.q.getCurrentAccountUin(), "actSBGetMsg", true, 0L, 0L, paramFromServiceMsg, "");
    if (a(paramToServiceMsg, localSubAccountBackProtocData, b, i, l3, paramObject)) {
      return;
    }
    localSubAccountBackProtocData.a = 0;
    a(8003, true, localSubAccountBackProtocData);
    if (QLog.isColorLevel()) {
      QLog.d("SUB_ACCOUNT", 2, "subaccount <PbGetMsg><R><---handleGetSubC2CMessageResp_PB end");
    }
  }
  
  private void e(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    Object localObject;
    if ((paramToServiceMsg != null) && (paramFromServiceMsg != null) && (paramFromServiceMsg.getResultCode() == 1000))
    {
      if (paramObject == null) {
        return;
      }
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("handleGetSubAccountSpecialCare() req = ");
        ((StringBuilder)localObject).append(paramToServiceMsg);
        QLog.d("SubAccountMessageProcessor", 2, ((StringBuilder)localObject).toString());
      }
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("handleGetSubAccountSpecialCare() resultCode = ");
        ((StringBuilder)localObject).append(paramFromServiceMsg.getResultCode());
        ((StringBuilder)localObject).append(" isSuccess = ");
        ((StringBuilder)localObject).append(paramFromServiceMsg.isSuccess());
        ((StringBuilder)localObject).append(" resp = ");
        ((StringBuilder)localObject).append(paramFromServiceMsg);
        QLog.d("SubAccountMessageProcessor", 2, ((StringBuilder)localObject).toString());
      }
      localObject = new oidb_sso.OIDBSSOPkg();
    }
    try
    {
      localObject = (oidb_sso.OIDBSSOPkg)((oidb_sso.OIDBSSOPkg)localObject).mergeFrom((byte[])paramObject);
      if (a((oidb_sso.OIDBSSOPkg)localObject))
      {
        if (QLog.isColorLevel()) {
          QLog.d("SubAccountMessageProcessor", 2, "handleGetSubAccountSpecialCare ssoPkg check error");
        }
        return;
      }
      paramObject = new Oidb_0x5d0.RspBody();
      try
      {
        paramObject.mergeFrom(((oidb_sso.OIDBSSOPkg)localObject).bytes_bodybuffer.get().toByteArray());
        boolean bool = QLog.isColorLevel();
        if (bool)
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("handleGetSubAccountSpecialCare  contentItem.size=");
          ((StringBuilder)localObject).append(paramObject.rpt_msg_contentItem.size());
          QLog.d("SubAccountMessageProcessor", 2, ((StringBuilder)localObject).toString());
        }
        localObject = String.valueOf(paramObject.uint64_uin.get());
        paramToServiceMsg = String.valueOf(paramToServiceMsg.getAttribute("subaccount"));
        String str = paramFromServiceMsg.getUin();
        int i = paramObject.uint32_sys_time.get();
        int j = paramObject.uint32_advise_gap.get();
        if (QLog.isColorLevel())
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("handleGetSubAccountSpecialCare  contentItem.size=");
          localStringBuilder.append(paramObject.rpt_msg_contentItem.get().size());
          localStringBuilder.append("  rspBody.uin=");
          localStringBuilder.append(String.valueOf(paramObject.uint64_uin.get()));
          localStringBuilder.append("  resp.getUin()=");
          localStringBuilder.append(paramFromServiceMsg.getUin());
          localStringBuilder.append("  sysTime=");
          localStringBuilder.append(i);
          localStringBuilder.append(" adviseGap=");
          localStringBuilder.append(j);
          QLog.d("SubAccountMessageProcessor", 2, localStringBuilder.toString());
        }
        if ((!TextUtils.isEmpty((CharSequence)localObject)) && (!"0".equals(localObject)) && (TextUtils.equals((CharSequence)localObject, paramToServiceMsg)) && (TextUtils.equals(str, this.q.getCurrentUin())))
        {
          a(paramObject, (String)localObject, str, i, j);
          return;
        }
        QLog.d("SubAccountMessageProcessor", 2, "handleGetSubAccountSpecialCare req or resp params error");
        return;
      }
      catch (Exception paramToServiceMsg)
      {
        paramToServiceMsg.printStackTrace();
        if (QLog.isColorLevel()) {
          QLog.d("SubAccountMessageProcessor", 2, "handleGetSubAccountSpecialCare  rspBody==null");
        }
        return;
      }
    }
    catch (InvalidProtocolBufferMicroException paramToServiceMsg)
    {
      label541:
      break label541;
    }
    if (QLog.isColorLevel()) {
      QLog.d("SubAccountMessageProcessor", 2, "handleGetSubAccountSpecialCare ssoPkg.mergeFrom exception");
    }
  }
  
  public void a(byte paramByte, int paramInt, String paramString1, String paramString2, ArrayList<String> paramArrayList)
  {
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("getSubAccoundMsg_PB() start, subUin=");
      ((StringBuilder)localObject1).append(paramString1);
      QLog.d("SUB_ACCOUNT", 2, ((StringBuilder)localObject1).toString());
    }
    Object localObject1 = this.r.createToServiceMsg("MessageSvc.PbBindUinGetMsg");
    ((ToServiceMsg)localObject1).extraData.putByte("cChannel", paramByte);
    ((ToServiceMsg)localObject1).extraData.putInt("cSyncFlag", paramInt);
    ((ToServiceMsg)localObject1).extraData.putBoolean("isSubAccount", true);
    ((ToServiceMsg)localObject1).extraData.putString("subAccount", paramString1);
    ((ToServiceMsg)localObject1).extraData.putString("subaccount_a2", paramString2);
    if ((paramArrayList != null) && (paramArrayList.size() > 0)) {
      ((ToServiceMsg)localObject1).extraData.putStringArrayList("hadGetMsgListUin", paramArrayList);
    }
    paramArrayList = null;
    Object localObject2 = (ISubAccountService)this.q.getRuntimeService(ISubAccountService.class, "");
    if (localObject2 != null) {
      paramArrayList = ((ISubAccountService)localObject2).getCookie(paramString1);
    }
    localObject2 = new msg_svc.PbBindUinGetMsgReq();
    if (paramString1 != null) {
      try
      {
        ((msg_svc.PbBindUinGetMsgReq)localObject2).bind_uin.set(Long.parseLong(paramString1));
      }
      catch (Exception paramString1)
      {
        paramString1.printStackTrace();
        if (QLog.isColorLevel()) {
          QLog.e("SUB_ACCOUNT", 2, "getSubAccoundMsg_PB() subAccount is null or not a long");
        }
      }
    }
    if (paramString2 != null) {
      try
      {
        ((msg_svc.PbBindUinGetMsgReq)localObject2).bind_uin_sig.set(ByteStringMicro.copyFrom(PkgTools.hexToBytes(paramString2)));
      }
      catch (Exception paramString1)
      {
        paramString1.printStackTrace();
      }
    }
    if (paramArrayList != null)
    {
      if (QLog.isColorLevel())
      {
        paramString1 = new StringBuilder();
        paramString1.append("getSubAccoundMsg_PB() cookie=");
        paramString1.append(paramArrayList.length);
        QLog.d("SUB_ACCOUNT", 2, paramString1.toString());
      }
      ((msg_svc.PbBindUinGetMsgReq)localObject2).sync_cookie.set(ByteStringMicro.copyFrom(paramArrayList));
    }
    else if (QLog.isColorLevel())
    {
      QLog.d("SUB_ACCOUNT", 2, "getSubAccoundMsg_PB() cookie = null");
    }
    ((msg_svc.PbBindUinGetMsgReq)localObject2).sync_flag.set(paramInt);
    ((ToServiceMsg)localObject1).putWupBuffer(((msg_svc.PbBindUinGetMsgReq)localObject2).toByteArray());
    this.r.sendPbReq((ToServiceMsg)localObject1);
  }
  
  public void a(int paramInt, ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg)
  {
    if (QLog.isColorLevel()) {
      QLog.d("SUB_ACCOUNT", 2, "SubAccountMessageProcessor processError");
    }
    if (paramInt != 4001) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("SUB_ACCOUNT", 2, "subaccount cmd =  CMD_MESSAGESERVICE_GETSUBACCOUNTMSG_PB handlerGetSubAccountError end");
    }
    paramFromServiceMsg = new SubAccountBackProtocData();
    String str = paramToServiceMsg.extraData.getString("subAccount");
    paramFromServiceMsg.c = paramToServiceMsg.getUin();
    paramFromServiceMsg.d = str;
    paramFromServiceMsg.a = 1001;
    a(8003, false, paramFromServiceMsg);
  }
  
  public void a(int paramInt, Object... paramVarArgs)
  {
    if (QLog.isColorLevel()) {
      QLog.d("SUB_ACCOUNT", 2, "SubAccountMessageProcessor processResponse");
    }
    switch (paramInt)
    {
    default: 
    case 4004: 
      if (((ISubAccountConfigApi)QRoute.api(ISubAccountConfigApi.class)).getIsHideSubAccountTroopMsg()) {
        return;
      }
      if ((paramVarArgs != null) && (paramVarArgs.length == 3))
      {
        a((msg_comm.Msg)paramVarArgs[0], (FromServiceMsg)paramVarArgs[1], (msg_onlinepush.PbPushMsg)paramVarArgs[2]);
        return;
      }
      b(getClass().getName(), paramInt);
      return;
    case 4003: 
      if ((paramVarArgs != null) && (paramVarArgs.length == 3))
      {
        e((ToServiceMsg)paramVarArgs[0], (FromServiceMsg)paramVarArgs[1], paramVarArgs[2]);
        return;
      }
      if (QLog.isColorLevel())
      {
        QLog.d("SUB_ACCOUNT", 2, "subaccount cmd=CMD_MESSAGESERVICE_SUBACCOUNT_SPECIAL_CARE GetSubAccountSpecialCare error");
        return;
      }
      break;
    case 4002: 
      if ((paramVarArgs != null) && (paramVarArgs.length == 3))
      {
        c((ToServiceMsg)paramVarArgs[0], (FromServiceMsg)paramVarArgs[1], paramVarArgs[2]);
        return;
      }
      a(getClass().getName(), paramInt);
      return;
    case 4001: 
      if ((paramVarArgs != null) && (paramVarArgs.length == 3))
      {
        d((ToServiceMsg)paramVarArgs[0], (FromServiceMsg)paramVarArgs[1], paramVarArgs[2]);
        return;
      }
      a(getClass().getName(), paramInt);
    }
  }
  
  public void a(RequestPushNotify paramRequestPushNotify)
  {
    if (528 == paramRequestPushNotify.stMsgInfo.shMsgType) {
      ((ISubAccountMessageProcessorHelper)QRoute.api(ISubAccountMessageProcessorHelper.class)).processSubAccountRevokeNotify(this.q, paramRequestPushNotify);
    }
  }
  
  public void a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg)
  {
    if (QLog.isColorLevel()) {
      QLog.d("SubAccountMessageProcessor", 2, "handleGetThirdQQUnreadMsgNumTimeOut");
    }
    paramToServiceMsg = new SubAccountThirdQQBackProtocData();
    paramToServiceMsg.a = this.q.getAccount();
    paramToServiceMsg.b = 1;
    this.r.notifyUI(8024, false, paramToServiceMsg);
  }
  
  public void a(String paramString1, String paramString2)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("confirmSubAccountMsgNumReaded() subAccount=");
      localStringBuilder.append(paramString1);
      QLog.d("SUB_ACCOUNT", 2, localStringBuilder.toString());
    }
    long l1 = 0L;
    try
    {
      long l2 = Long.parseLong(paramString1);
      l1 = l2;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
    if (l1 <= 10000L)
    {
      if (QLog.isColorLevel())
      {
        paramString1 = new StringBuilder();
        paramString1.append("confirmSubAccountMsgNumReaded() return, lSubUin=");
        paramString1.append(l1);
        QLog.d("SUB_ACCOUNT", 2, paramString1.toString());
      }
      return;
    }
    byte[] arrayOfByte = null;
    Object localObject = (ISubAccountService)this.q.getRuntimeService(ISubAccountService.class, "");
    if (localObject != null) {
      arrayOfByte = ((ISubAccountService)localObject).getCookie(paramString1);
    }
    localObject = this.r.createToServiceMsg("PbMessageSvc.PbBindUinMsgReadedConfirm");
    ((ToServiceMsg)localObject).extraData.putBoolean("isSubAccount", true);
    ((ToServiceMsg)localObject).extraData.putString("subAccount", paramString1);
    ((ToServiceMsg)localObject).extraData.putString("nextAction", paramString2);
    paramString1 = new msg_svc.PbBindUinMsgReadedConfirmReq();
    paramString1.bind_uin.set(l1);
    if (arrayOfByte != null)
    {
      if (QLog.isColorLevel())
      {
        paramString2 = new StringBuilder();
        paramString2.append("confirmSubAccountMsgNumReaded() getSubAccoundMsg_PB  syncCookie=");
        paramString2.append(Integer.toString(arrayOfByte.length));
        QLog.d("SUB_ACCOUNT", 2, paramString2.toString());
      }
      paramString1.sync_cookie.set(ByteStringMicro.copyFrom(arrayOfByte));
    }
    else if (QLog.isColorLevel())
    {
      QLog.d("SUB_ACCOUNT", 2, "confirmSubAccountMsgNumReaded() getSubAccoundMsg_PB  cookie = null");
    }
    ((ToServiceMsg)localObject).putWupBuffer(paramString1.toByteArray());
    this.r.sendPbReq((ToServiceMsg)localObject);
  }
  
  public void a(boolean paramBoolean, ArrayList<SimpleAccount> paramArrayList)
  {
    boolean bool = QLog.isColorLevel();
    int j = 2;
    Object localObject1;
    int i;
    if (bool)
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("getThirdQQUnreadMsgNum_PB isCronJob = ");
      ((StringBuilder)localObject1).append(paramBoolean);
      ((StringBuilder)localObject1).append(" thirdAccount size = ");
      if (paramArrayList == null) {
        i = 0;
      } else {
        i = paramArrayList.size();
      }
      ((StringBuilder)localObject1).append(i);
      QLog.d("SubAccountMessageProcessor", 2, ((StringBuilder)localObject1).toString());
    }
    if ((paramArrayList != null) && (paramArrayList.size() != 0))
    {
      localObject1 = (TicketManager)this.q.getManager(2);
      WtloginManager localWtloginManager = (WtloginManager)this.q.getManager(1);
      msg_svc.PbUnReadMsgSeqReq localPbUnReadMsgSeqReq = new msg_svc.PbUnReadMsgSeqReq();
      msg_svc.PbThirdQQUnReadMsgNumReq localPbThirdQQUnReadMsgNumReq = new msg_svc.PbThirdQQUnReadMsgNumReq();
      long l1 = MessageCache.c();
      if ((localObject1 != null) && (localWtloginManager != null))
      {
        Iterator localIterator = paramArrayList.iterator();
        paramArrayList = (ArrayList<SimpleAccount>)localObject1;
        label473:
        while (localIterator.hasNext())
        {
          Object localObject2 = (SimpleAccount)localIterator.next();
          if (localObject2 != null)
          {
            try
            {
              localObject1 = new msg_svc.PbThirdQQUnReadMsgNumReq.ThirdQQReqInfo();
              localObject2 = ((SimpleAccount)localObject2).getUin();
              Object localObject3 = paramArrayList.getA2((String)localObject2);
              if ((TextUtils.isEmpty((CharSequence)localObject2)) || (TextUtils.isEmpty((CharSequence)localObject3))) {
                break label473;
              }
              bool = TextUtils.isEmpty(((String)localObject3).trim());
              if (bool) {
                break label473;
              }
              try
              {
                Ticket localTicket = localWtloginManager.getLocalTicket((String)localObject2, 16L, 64);
                if ((localTicket == null) || (l1 > localTicket._expire_time)) {
                  break label473;
                }
                long l2 = Long.parseLong((String)localObject2);
                ((msg_svc.PbThirdQQUnReadMsgNumReq.ThirdQQReqInfo)localObject1).third_uin.set(l2);
                ((msg_svc.PbThirdQQUnReadMsgNumReq.ThirdQQReqInfo)localObject1).third_uin_sig.set(ByteStringMicro.copyFrom(PkgTools.hexToBytes((String)localObject3)));
                localObject3 = ((ISubAccountControlService)this.q.getRuntimeService(ISubAccountControlService.class, "")).getThirdQQUnreadNumReqCookie(this.q, (String)localObject2);
                if (localObject3 != null) {
                  ((msg_svc.PbThirdQQUnReadMsgNumReq.ThirdQQReqInfo)localObject1).third_uin_cookie.set(ByteStringMicro.copyFrom((byte[])localObject3));
                }
                if (QLog.isColorLevel())
                {
                  localObject3 = new StringBuilder();
                  ((StringBuilder)localObject3).append("getThirdQQUnreadMsgNum_PB third uin = ");
                  ((StringBuilder)localObject3).append((String)localObject2);
                  QLog.d("SubAccountMessageProcessor", 2, ((StringBuilder)localObject3).toString());
                }
                localPbThirdQQUnReadMsgNumReq.thirdqq_req_info.add((MessageMicro)localObject1);
              }
              catch (NumberFormatException localNumberFormatException1) {}
              if (!QLog.isColorLevel()) {
                break label473;
              }
            }
            catch (NumberFormatException localNumberFormatException2) {}
            localObject2 = new StringBuilder();
            ((StringBuilder)localObject2).append("getThirdQQUnreadMsgNum_PB error ");
            ((StringBuilder)localObject2).append(localNumberFormatException2.getMessage());
            QLog.e("SubAccountMessageProcessor", 2, ((StringBuilder)localObject2).toString());
          }
        }
      }
      if ((localPbThirdQQUnReadMsgNumReq.thirdqq_req_info.has()) && (localPbThirdQQUnReadMsgNumReq.thirdqq_req_info.get() != null) && (localPbThirdQQUnReadMsgNumReq.thirdqq_req_info.get().size() != 0))
      {
        if (QLog.isColorLevel()) {
          QLog.d("SubAccountMessageProcessor", 2, "getThirdQQUnreadMsgNum_PB really send msg to service");
        }
        paramArrayList = localPbThirdQQUnReadMsgNumReq.source;
        i = j;
        if (paramBoolean) {
          i = 1;
        }
        paramArrayList.set(i);
        localPbUnReadMsgSeqReq.thirdqq_unread_info.set(localPbThirdQQUnReadMsgNumReq);
        paramArrayList = new ToServiceMsg("mobileqq.service", this.q.getCurrentUin(), "PbMessageSvc.PbUnReadMsgSeq");
        paramArrayList.extraData.putString("action", "getThirdQQUnreadNum");
        paramArrayList.extraData.putString("mainAccount", this.q.getAccount());
        paramArrayList.putWupBuffer(localPbUnReadMsgSeqReq.toByteArray());
        this.r.sendPbReq(paramArrayList);
        return;
      }
      paramArrayList = new SubAccountThirdQQBackProtocData();
      paramArrayList.a = this.q.getAccount();
      if (QLog.isColorLevel()) {
        QLog.e("SubAccountMessageProcessor", 2, "getThirdQQUnreadMsgNum_PB error no third qq info");
      }
      this.r.notifyUI(8024, false, paramArrayList);
      return;
    }
    paramArrayList = new SubAccountThirdQQBackProtocData();
    paramArrayList.a = this.q.getAccount();
    if (QLog.isColorLevel()) {
      QLog.e("SubAccountMessageProcessor", 2, "getThirdQQUnreadMsgNum_PB error no third account");
    }
    this.r.notifyUI(8024, false, paramArrayList);
  }
  
  public boolean a(SubAccountInfo paramSubAccountInfo)
  {
    if (QLog.isColorLevel()) {
      QLog.d("SubAccountMessageProcessor", 2, "getSubAccountSpecialCareList()");
    }
    if (paramSubAccountInfo != null)
    {
      if (TextUtils.isEmpty(paramSubAccountInfo.subuin)) {
        return false;
      }
      Object localObject1 = new Oidb_0x5d0.ReqBody();
      Object localObject2 = new ArrayList();
      ((List)localObject2).add(Integer.valueOf(9));
      ((Oidb_0x5d0.ReqBody)localObject1).rpt_uint32_fieldlist.set((List)localObject2);
      localObject2 = (ISubAccountControlService)this.q.getRuntimeService(ISubAccountControlService.class, "");
      ((Oidb_0x5d0.ReqBody)localObject1).uint32_start_time.set(((ISubAccountControlService)localObject2).getReqSubAccountSpecialCareListSysTime(this.q, this.q.getCurrentUin(), paramSubAccountInfo.subuin));
      try
      {
        long l = Long.parseLong(paramSubAccountInfo.subuin);
        ((Oidb_0x5d0.ReqBody)localObject1).uint64_bind_uin.set(l);
        localObject2 = new oidb_sso.OIDBSSOPkg();
        ((oidb_sso.OIDBSSOPkg)localObject2).uint32_command.set(1488);
        ((oidb_sso.OIDBSSOPkg)localObject2).uint32_result.set(0);
        ((oidb_sso.OIDBSSOPkg)localObject2).uint32_service_type.set(1);
        ((oidb_sso.OIDBSSOPkg)localObject2).bytes_bodybuffer.set(ByteStringMicro.copyFrom(((Oidb_0x5d0.ReqBody)localObject1).toByteArray()));
        if (QLog.isColorLevel())
        {
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append("getSubAccountSpecialCareList() uin = ");
          ((StringBuilder)localObject1).append(paramSubAccountInfo.subuin);
          QLog.d("SubAccountMessageProcessor", 2, ((StringBuilder)localObject1).toString());
        }
        localObject1 = this.r.createToServiceMsg("OidbSvc.0x5d0_1");
        ((ToServiceMsg)localObject1).putWupBuffer(((oidb_sso.OIDBSSOPkg)localObject2).toByteArray());
        ((ToServiceMsg)localObject1).setTimeout(60000L);
        ((ToServiceMsg)localObject1).addAttribute("from_where", "subaccount");
        ((ToServiceMsg)localObject1).addAttribute("subaccount", paramSubAccountInfo.subuin);
        if (QLog.isColorLevel())
        {
          paramSubAccountInfo = new StringBuilder();
          paramSubAccountInfo.append("getSubAccountSpecialCareList() before send request = ");
          paramSubAccountInfo.append(localObject1);
          QLog.d("SubAccountMessageProcessor", 2, paramSubAccountInfo.toString());
        }
        this.r.sendPbReq((ToServiceMsg)localObject1);
        if (QLog.isColorLevel())
        {
          paramSubAccountInfo = new StringBuilder();
          paramSubAccountInfo.append("getSubAccountSpecialCareList() after send request = ");
          paramSubAccountInfo.append(localObject1);
          QLog.d("SubAccountMessageProcessor", 2, paramSubAccountInfo.toString());
        }
        return true;
      }
      catch (NumberFormatException paramSubAccountInfo)
      {
        paramSubAccountInfo.printStackTrace();
        if (QLog.isColorLevel()) {
          QLog.d("SUB_ACCOUNT", 2, "getSubAccountSpecialCareList subAccount parselong error ");
        }
      }
    }
    return false;
  }
  
  public void b(int paramInt, ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg)
  {
    if (QLog.isColorLevel()) {
      QLog.d("SUB_ACCOUNT", 2, "SubAccountMessageProcessor processTimeOut");
    }
    if (paramInt != 4001) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("SUB_ACCOUNT", 2, "subaccount cmd =  CMD_MESSAGESERVICE_GETSUBACCOUNTMSG_PB handlerGetSubAccountTimeout end");
    }
    paramFromServiceMsg = new SubAccountBackProtocData();
    String str = paramToServiceMsg.extraData.getString("subAccount");
    paramFromServiceMsg.c = paramToServiceMsg.getUin();
    paramFromServiceMsg.d = str;
    paramFromServiceMsg.a = 1007;
    a(8003, false, paramFromServiceMsg);
  }
  
  public void b(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg)
  {
    if (QLog.isColorLevel()) {
      QLog.d("SubAccountMessageProcessor", 2, "handleGetThirdQQUnreadMsgNumError");
    }
    paramToServiceMsg = new SubAccountThirdQQBackProtocData();
    paramToServiceMsg.a = this.q.getAccount();
    this.r.notifyUI(8024, false, paramToServiceMsg);
  }
  
  public void b(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if (paramObject == null)
    {
      b(paramToServiceMsg, paramFromServiceMsg);
      return;
    }
    Object localObject1 = new msg_svc.PbUnReadMsgSeqResp();
    try
    {
      paramObject = (msg_svc.PbUnReadMsgSeqResp)((msg_svc.PbUnReadMsgSeqResp)localObject1).mergeFrom((byte[])paramObject);
      if ((paramObject.thirdqq_unread_info.has()) && (paramObject.thirdqq_unread_info.get() != null))
      {
        paramObject = (msg_svc.PbThirdQQUnReadMsgNumResp)paramObject.thirdqq_unread_info.get();
        if ((paramObject.result.get() == 0) && (paramObject.thirdqq_resp_info.get() != null))
        {
          localObject1 = new SubAccountThirdQQBackProtocData();
          int j = paramObject.result.get();
          paramFromServiceMsg = paramObject.errmsg.get();
          int i = paramObject.interval.get();
          ((SubAccountThirdQQBackProtocData)localObject1).e = i;
          ((SubAccountThirdQQBackProtocData)localObject1).c = paramFromServiceMsg;
          ((SubAccountThirdQQBackProtocData)localObject1).d = j;
          paramToServiceMsg = paramToServiceMsg.extraData.getString("mainAccount");
          ((SubAccountThirdQQBackProtocData)localObject1).a = paramToServiceMsg;
          if (QLog.isColorLevel())
          {
            localObject2 = new StringBuilder();
            ((StringBuilder)localObject2).append("handleGetThirdQQUnreadMsgNumResp_PB: result  interval=");
            ((StringBuilder)localObject2).append(i);
            ((StringBuilder)localObject2).append(" errmsg=");
            ((StringBuilder)localObject2).append(paramFromServiceMsg);
            ((StringBuilder)localObject2).append(" result=");
            ((StringBuilder)localObject2).append(j);
            QLog.d("SubAccountMessageProcessor", 2, ((StringBuilder)localObject2).toString());
          }
          long l = MessageCache.c();
          Object localObject2 = (ISubAccountControlService)this.q.getRuntimeService(ISubAccountControlService.class, "");
          j = 0;
          paramFromServiceMsg = paramObject;
          while (j < paramFromServiceMsg.thirdqq_resp_info.get().size())
          {
            Object localObject3 = (msg_svc.PbThirdQQUnReadMsgNumResp.ThirdQQRespInfo)paramFromServiceMsg.thirdqq_resp_info.get().get(j);
            paramObject = String.valueOf(((msg_svc.PbThirdQQUnReadMsgNumResp.ThirdQQRespInfo)localObject3).third_uin.get());
            byte[] arrayOfByte = ((msg_svc.PbThirdQQUnReadMsgNumResp.ThirdQQRespInfo)localObject3).third_uin_cookie.get().toByteArray();
            int k = ((msg_svc.PbThirdQQUnReadMsgNumResp.ThirdQQRespInfo)localObject3).msg_num.get();
            int m = ((msg_svc.PbThirdQQUnReadMsgNumResp.ThirdQQRespInfo)localObject3).msg_flag.get();
            int n = ((msg_svc.PbThirdQQUnReadMsgNumResp.ThirdQQRespInfo)localObject3).redbag_time.get();
            int i1 = ((msg_svc.PbThirdQQUnReadMsgNumResp.ThirdQQRespInfo)localObject3).status.get();
            int i2 = ((msg_svc.PbThirdQQUnReadMsgNumResp.ThirdQQRespInfo)localObject3).last_msg_time.get();
            if ((((SubAccountThirdQQBackProtocData)localObject1).f < i2) && (i2 <= l)) {
              ((SubAccountThirdQQBackProtocData)localObject1).f = i2;
            }
            if (QLog.isColorLevel())
            {
              localObject3 = new StringBuilder();
              ((StringBuilder)localObject3).append("handleGetThirdQQUnreadMsgNumResp_PB: thirdUin=");
              ((StringBuilder)localObject3).append(paramObject);
              ((StringBuilder)localObject3).append(" num=");
              ((StringBuilder)localObject3).append(k);
              ((StringBuilder)localObject3).append(" flag=");
              ((StringBuilder)localObject3).append(m);
              ((StringBuilder)localObject3).append(" redbagtime=");
              ((StringBuilder)localObject3).append(n);
              ((StringBuilder)localObject3).append(" status=");
              ((StringBuilder)localObject3).append(i1);
              ((StringBuilder)localObject3).append(" lastmsgtime=");
              ((StringBuilder)localObject3).append(i2);
              ((StringBuilder)localObject3).append("  cookie=");
              ((StringBuilder)localObject3).append(arrayOfByte);
              QLog.d("SubAccountMessageProcessor", 2, ((StringBuilder)localObject3).toString());
            }
            ((ISubAccountControlService)localObject2).storeThirdQQUnreadInfo(paramToServiceMsg, paramObject, arrayOfByte, k, m, n, i1, i2);
            j += 1;
          }
          ((ISubAccountControlService)localObject2).storeThirdQQUnreadMsgNumInterval(this.q, paramToServiceMsg, i);
          this.r.notifyUI(8024, true, localObject1);
          return;
        }
        if (QLog.isColorLevel())
        {
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append("handleGetThirdQQUnreadMsgNumResp_PB unreadNumSeqResp.result: ");
          ((StringBuilder)localObject1).append(paramObject.result.get());
          ((StringBuilder)localObject1).append(" ,unreadNumSeqResp.errmsg: ");
          ((StringBuilder)localObject1).append(paramObject.errmsg.get());
          ((StringBuilder)localObject1).append(" or thirdqq_resp_info is null");
          QLog.d("SubAccountMessageProcessor", 2, ((StringBuilder)localObject1).toString());
        }
        b(paramToServiceMsg, paramFromServiceMsg);
        return;
      }
      if (QLog.isColorLevel()) {
        QLog.e("SubAccountMessageProcessor", 2, "handleGetThirdQQUnreadMsgNumResp_PB: server did not return thirdqq_unread_info");
      }
      b(paramToServiceMsg, paramFromServiceMsg);
      return;
    }
    catch (Exception paramObject)
    {
      label717:
      break label717;
    }
    if (QLog.isColorLevel()) {
      QLog.e("SubAccountMessageProcessor", 2, "handleGetThirdQQUnreadMsgNumResp_PB: server did not return a valid response");
    }
    b(paramToServiceMsg, paramFromServiceMsg);
  }
  
  public void b(String paramString, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("SubAccountMessageProcessor", 2, "subaccount handleGetSubAccountTroop error");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.app.message.SubAccountMessageProcessor
 * JD-Core Version:    0.7.0.1
 */