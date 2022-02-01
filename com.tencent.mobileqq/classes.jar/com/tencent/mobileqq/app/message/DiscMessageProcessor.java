package com.tencent.mobileqq.app.message;

import OnlinePushPack.MsgInfo;
import OnlinePushPack.SvcReqPushMsg;
import PushNotifyPack.DisMsgReadedNotify;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.util.Pair;
import com.tencent.av.gaudio.AVNotifyCenter;
import com.tencent.common.app.AppInterface;
import com.tencent.imcore.message.BaseMessageManagerForTroopAndDisc;
import com.tencent.imcore.message.BaseMessageProcessorForTroopAndDisc;
import com.tencent.imcore.message.MsgProxyUtils;
import com.tencent.imcore.message.OnLinePushParamReturnMsg;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.activity.aio.forward.ForwardOrderManager;
import com.tencent.mobileqq.activity.recent.RecentUtil;
import com.tencent.mobileqq.apollo.api.IApolloPushManager;
import com.tencent.mobileqq.app.BaseMessageHandler;
import com.tencent.mobileqq.app.BaseMessageHandlerUtils;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.DiscussionHandler;
import com.tencent.mobileqq.app.DiscussionHandler.ReqDiscussInfo;
import com.tencent.mobileqq.app.DiscussionManager;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.MessageHandler;
import com.tencent.mobileqq.app.MessageHandlerUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.automator.Automator;
import com.tencent.mobileqq.app.handler.PreDownloadMsg;
import com.tencent.mobileqq.app.handler.RegisterProxyHandler;
import com.tencent.mobileqq.app.proxy.ProxyManager;
import com.tencent.mobileqq.app.proxy.RecentUserProxy;
import com.tencent.mobileqq.data.DiscussionInfo;
import com.tencent.mobileqq.data.DiscussionMemberInfo;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.data.MessageForMarketFace;
import com.tencent.mobileqq.data.MessageForNewGrayTips;
import com.tencent.mobileqq.data.MessageForQQWalletTips;
import com.tencent.mobileqq.data.MessageForText;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.emosm.favroaming.IEmoticonFromGroupManager;
import com.tencent.mobileqq.model.CommercialDrainageManagerConstants;
import com.tencent.mobileqq.model.TroopInfoManager;
import com.tencent.mobileqq.msg.api.IMessageFacade;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBSInt32Field;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qwallet.transaction.INotifyMsgApi;
import com.tencent.mobileqq.revokemsg.RevokeMsgInfo;
import com.tencent.mobileqq.selectmember.api.ISelectMemberApi;
import com.tencent.mobileqq.service.message.MessageCache;
import com.tencent.mobileqq.service.message.MessageRecordFactory;
import com.tencent.mobileqq.service.message.PBDecodeContext;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.troop.api.handler.ITroopMngHandler;
import com.tencent.mobileqq.troop.api.observer.TroopMngObserver;
import com.tencent.mobileqq.troop.data.MessageInfo;
import com.tencent.mobileqq.util.MessageRecordUtil;
import com.tencent.mobileqq.utils.ContactUtils;
import com.tencent.mobileqq.utils.HexUtil;
import com.tencent.mobileqq.utils.QAVHrMeeting;
import com.tencent.mobileqq.utils.httputils.PkgTools;
import com.tencent.mobileqq.vas.VasExtensionManager;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import cooperation.vip.tianshu.TianShuManager;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import mqq.app.MobileQQ;
import mqq.os.MqqHandler;
import msf.msgcomm.msg_comm.AppShareInfo;
import msf.msgcomm.msg_comm.ContentHead;
import msf.msgcomm.msg_comm.DiscussInfo;
import msf.msgcomm.msg_comm.Msg;
import msf.msgcomm.msg_comm.MsgHead;
import msf.msgsvc.msg_svc.PbDiscussReadedReportReq;
import msf.msgsvc.msg_svc.PbGetDiscussMsgResp;
import msf.msgsvc.msg_svc.PbMsgReadedReportReq;
import msf.onlinepush.msg_onlinepush.PbPushMsg;
import org.jetbrains.annotations.NotNull;
import tencent.im.apollo_push_msgInfo.STPushMsgElem;
import tencent.im.conf.sysmsg_0x20c_0x20.Convert2Group;
import tencent.im.conf.sysmsg_0x20c_0x20.MemberNumRemind;
import tencent.im.conf.sysmsg_0x20c_0x20.SysMsgBody;
import tencent.im.conf.sysmsg_0x20c_0x20.UploadFileRemind;
import tencent.im.msg.im_msg_body.MsgBody;
import tencent.im.msgrevoke.msgrevoke_userdef.MsgInfoUserDef;
import tencent.im.msgrevoke.msgrevoke_userdef.MsgInfoUserDef.MsgInfoDef;
import tencent.im.oidb.cmd0x858.oidb_0x858.GoldMsgTipsElem;
import tencent.im.oidb.cmd0x858.oidb_0x858.MessageRecallReminder;
import tencent.im.oidb.cmd0x858.oidb_0x858.MessageRecallReminder.MessageMeta;
import tencent.im.oidb.cmd0x858.oidb_0x858.NotifyMsgBody;
import tencent.im.oidb.cmd0x858.oidb_0x858.RedGrayTipsInfo;

public class DiscMessageProcessor
  extends BaseMessageProcessorForTroopAndDisc
{
  Handler a;
  public final ConcurrentHashMap<String, ArrayList<Pair<String, String>>> a;
  
  public DiscMessageProcessor(QQAppInterface paramQQAppInterface, MessageHandler paramMessageHandler)
  {
    super(paramQQAppInterface, paramMessageHandler);
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
  }
  
  private MessageRecord a(MsgInfo paramMsgInfo, long paramLong)
  {
    Object localObject3 = paramMsgInfo.vMsg;
    long l1 = paramMsgInfo.lFromUin;
    long l2 = PkgTools.getLongData((byte[])localObject3, 0);
    byte b = localObject3[4];
    ArrayList localArrayList = new ArrayList();
    DiscussionHandler localDiscussionHandler1 = (DiscussionHandler)this.jdField_a_of_type_ComTencentCommonAppAppInterface.getBusinessHandler(BusinessHandlerFactory.DISCUSSION_HANDLER);
    Object localObject5 = (FriendsManager)this.jdField_a_of_type_ComTencentCommonAppAppInterface.getManager(QQManagerFactory.FRIENDS_MANAGER);
    Object localObject4 = (DiscussionManager)this.jdField_a_of_type_ComTencentCommonAppAppInterface.getManager(QQManagerFactory.DISCUSSION_MANAGER);
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("handleDiscussionMemchangeMsg cOpType: ");
      ((StringBuilder)localObject1).append(b);
      ((StringBuilder)localObject1).append(", dwConfUin=");
      ((StringBuilder)localObject1).append(l2);
      QLog.d("Q.msg.DiscMsgPc.discuss", 2, ((StringBuilder)localObject1).toString());
    }
    if (b != 1)
    {
      if (b == 2) {
        break label728;
      }
      if (b == 3) {
        break label705;
      }
      if (b == 6) {
        break label682;
      }
      if (b == 7) {
        break label441;
      }
      if (b == 15) {
        break label428;
      }
      if (b == 22) {
        break label403;
      }
      if (b == 32) {
        break label389;
      }
      if (b == 24) {
        break label379;
      }
      if (b == 25) {
        break label361;
      }
      if (b == 34) {
        break label329;
      }
      if (b == 35) {}
    }
    else
    {
      switch (b)
      {
      default: 
        localObject1 = null;
        break;
      case 11: 
        localObject2 = null;
        break;
      case 10: 
        a(paramMsgInfo, paramLong, (byte[])localObject3, l1, 5, l2, localArrayList);
        break;
      case 9: 
        a(paramMsgInfo, paramLong, (byte[])localObject3, l1, 5, l2);
      }
    }
    for (;;)
    {
      localObject1 = null;
      break;
      if (QLog.isColorLevel()) {
        QLog.d("ApolloGameManager", 2, "recv 0x20c_0x23 online push.[Discussion]");
      }
      b((QQAppInterface)this.jdField_a_of_type_ComTencentCommonAppAppInterface, (byte[])localObject3, 5, null, true);
      continue;
      label329:
      if (QLog.isColorLevel()) {
        QLog.d("GameParty", 2, "recv 0x20c_0x22 online push");
      }
      c((QQAppInterface)this.jdField_a_of_type_ComTencentCommonAppAppInterface, (byte[])localObject3, 5, null, true);
      continue;
      label361:
      a((QQAppInterface)this.jdField_a_of_type_ComTencentCommonAppAppInterface, (byte[])localObject3, 5, null, true);
      continue;
      label379:
      return a((byte[])localObject3, l1, 5);
      label389:
      a((byte[])localObject3, 5, l2, (DiscussionManager)localObject4);
    }
    label403:
    Object localObject1 = null;
    a(paramMsgInfo, paramLong, (byte[])localObject3, l1, 5, b, l2, localArrayList, localDiscussionHandler1);
    break label788;
    label428:
    localObject1 = null;
    a((byte[])localObject3, 5);
    break label788;
    label441:
    localObject1 = null;
    long l3 = PkgTools.getLongData((byte[])localObject3, 5);
    long l4 = PkgTools.getLongData((byte[])localObject3, 9);
    if (QLog.isColorLevel())
    {
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("handleDiscussionMemchangeMsg discussionUin: ");
      ((StringBuilder)localObject2).append(l2);
      ((StringBuilder)localObject2).append(" memberUin: ");
      ((StringBuilder)localObject2).append(l3);
      QLog.d("Q.msg.DiscMsgPc.discuss", 2, ((StringBuilder)localObject2).toString());
    }
    Object localObject2 = String.valueOf(l3);
    if (a(l3, l2, paramMsgInfo.shMsgSeq)) {
      return localObject1;
    }
    if (!((String)localObject2).equals(this.jdField_a_of_type_ComTencentCommonAppAppInterface.getCurrentAccountUin()))
    {
      localObject4 = a(l2, (String)localObject2, a(paramMsgInfo));
      int i = PkgTools.getShortData((byte[])localObject3, 13);
      localObject5 = new HashSet();
      a((byte[])localObject3, 15, localArrayList, i, (HashSet)localObject5);
      localObject3 = a(l2, (HashSet)localObject5, new StringBuffer(), "");
      DiscussionHandler localDiscussionHandler2 = (DiscussionHandler)this.jdField_a_of_type_ComTencentCommonAppAppInterface.getBusinessHandler(BusinessHandlerFactory.DISCUSSION_HANDLER);
      localDiscussionHandler2.a(l2, (String)localObject2, localArrayList, 10005);
      a(paramMsgInfo, paramLong, l1, l2, localDiscussionHandler1, l4, (String)localObject4, (HashSet)localObject5, (String)localObject3, localDiscussionHandler2);
      break label788;
      label682:
      localObject1 = null;
      a(paramMsgInfo, paramLong, (byte[])localObject3, 5, b, l2, localDiscussionHandler1, (DiscussionManager)localObject4);
      break label788;
      label705:
      localObject1 = null;
      a(paramMsgInfo, paramLong, (byte[])localObject3, 5, b, l2, localArrayList, localDiscussionHandler1);
      break label788;
      label728:
      localObject2 = null;
      localObject1 = localObject2;
      if (a(paramMsgInfo, paramLong, (byte[])localObject3, l1, 5, b, l2, localArrayList, localDiscussionHandler1, (DiscussionManager)localObject4))
      {
        return localObject2;
        localObject1 = localObject2;
        if (a(paramMsgInfo, (byte[])localObject3, 5, l2, localDiscussionHandler1, (FriendsManager)localObject5, (DiscussionManager)localObject4)) {
          return localObject2;
        }
      }
    }
    label788:
    return localObject1;
  }
  
  private MessageRecord a(MsgInfo paramMsgInfo, SvcReqPushMsg paramSvcReqPushMsg)
  {
    paramMsgInfo = a(paramMsgInfo, paramSvcReqPushMsg.lUin);
    if ((paramMsgInfo != null) && (!MessageHandlerUtils.a(this.jdField_a_of_type_ComTencentCommonAppAppInterface, paramMsgInfo, true))) {
      return paramMsgInfo;
    }
    return null;
  }
  
  @NotNull
  private MessageRecord a(byte[] paramArrayOfByte, long paramLong, int paramInt)
  {
    int i = paramArrayOfByte.length - paramInt;
    Object localObject = new byte[i];
    PkgTools.getBytesData(paramArrayOfByte, paramInt, (byte[])localObject, i);
    paramArrayOfByte = new oidb_0x858.NotifyMsgBody();
    MessageForQQWalletTips localMessageForQQWalletTips = (MessageForQQWalletTips)MessageRecordFactory.a(-2029);
    try
    {
      paramArrayOfByte.mergeFrom((byte[])localObject);
      paramArrayOfByte = (oidb_0x858.RedGrayTipsInfo)paramArrayOfByte.opt_msg_redtips.get();
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(paramArrayOfByte.uint64_sender_uin.get());
      ((StringBuilder)localObject).append("");
      localMessageForQQWalletTips.senderUin = ((StringBuilder)localObject).toString();
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(paramArrayOfByte.uint64_receiver_uin.get());
      ((StringBuilder)localObject).append("");
      localMessageForQQWalletTips.reciverUin = ((StringBuilder)localObject).toString();
      localMessageForQQWalletTips.senderContent = paramArrayOfByte.bytes_sender_rich_content.get().toStringUtf8();
      localMessageForQQWalletTips.reciverContent = paramArrayOfByte.bytes_receiver_rich_content.get().toStringUtf8();
      localMessageForQQWalletTips.authKey = paramArrayOfByte.bytes_authkey.get().toStringUtf8();
      localMessageForQQWalletTips.idiomSeq = paramArrayOfByte.uint32_idiom_seq.get();
      localMessageForQQWalletTips.idiom = paramArrayOfByte.bytes_idiom.get().toStringUtf8();
      localMessageForQQWalletTips.msgType = paramArrayOfByte.sint32_msgtype.get();
      localMessageForQQWalletTips.richContent = paramArrayOfByte.bytes_broadcast_rich_content.get().toStringUtf8();
      localMessageForQQWalletTips.lastPinyin = paramArrayOfByte.bytes_idiom_alpha.get().toStringUtf8();
      localMessageForQQWalletTips.bytes_jumpurl = paramArrayOfByte.bytes_jumpurl.get().toStringUtf8();
      localMessageForQQWalletTips.subChannel = paramArrayOfByte.uint32_subchannel.get();
      try
      {
        paramArrayOfByte = this.jdField_a_of_type_ComTencentCommonAppAppInterface.getCurrentAccountUin();
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append(paramLong);
        ((StringBuilder)localObject).append("");
        localMessageForQQWalletTips.init(paramArrayOfByte, ((StringBuilder)localObject).toString(), "", "[QQWallet Tips]", MessageCache.a(), -2029, 3000, MessageCache.a());
        localMessageForQQWalletTips.isread = true;
        localMessageForQQWalletTips.getBytes();
        localMessageForQQWalletTips.onReceiveGrapTips();
        return localMessageForQQWalletTips;
      }
      catch (Exception paramArrayOfByte) {}
      paramArrayOfByte.printStackTrace();
    }
    catch (Exception paramArrayOfByte) {}
    return localMessageForQQWalletTips;
  }
  
  private String a(long paramLong1, String paramString1, byte paramByte, long paramLong2, long paramLong3, String paramString2, StringBuffer paramStringBuffer, String paramString3)
  {
    if (paramByte == 22)
    {
      if (paramLong2 == 0L) {
        return this.jdField_a_of_type_ComTencentCommonAppAppInterface.getApp().getString(2131691802);
      }
      if (paramLong2 == 1L) {
        return this.jdField_a_of_type_ComTencentCommonAppAppInterface.getApp().getString(2131691803);
      }
      if (paramLong2 == 2L) {
        return this.jdField_a_of_type_ComTencentCommonAppAppInterface.getApp().getString(2131692181, new Object[] { paramStringBuffer.toString() });
      }
    }
    else
    {
      int i;
      if (paramLong3 == paramLong1) {
        i = 1;
      } else {
        i = 0;
      }
      if (i != 0)
      {
        if (QLog.isColorLevel()) {
          paramString1 = this.jdField_a_of_type_ComTencentCommonAppAppInterface.getApp().getString(2131691783);
        } else {
          paramString1 = "";
        }
      }
      else
      {
        paramString3 = paramString2;
        if (TextUtils.isEmpty(paramString2))
        {
          if (QLog.isColorLevel())
          {
            paramString2 = new StringBuilder();
            paramString2.append("showWelcomeTips server invitorName empty cOpType:");
            paramString2.append(paramByte);
            QLog.d("Q.msg.DiscMsgPc.discuss", 2, paramString2.toString());
          }
          paramString3 = ContactUtils.a((QQAppInterface)this.jdField_a_of_type_ComTencentCommonAppAppInterface, paramString1, String.valueOf(paramLong3));
        }
        if (ContactUtils.a((QQAppInterface)this.jdField_a_of_type_ComTencentCommonAppAppInterface, paramString1)) {
          paramString3 = ContactUtils.a((QQAppInterface)this.jdField_a_of_type_ComTencentCommonAppAppInterface, paramString1, String.valueOf(paramLong3));
        }
        paramString1 = new StringBuilder();
        paramString1.append(paramString3);
        paramString1.append(this.jdField_a_of_type_ComTencentCommonAppAppInterface.getApp().getString(2131691782));
        paramString1 = paramString1.toString();
      }
      paramString2 = new StringBuilder();
      paramString2.append(paramString1);
      paramString2.append(this.jdField_a_of_type_ComTencentCommonAppAppInterface.getApp().getString(2131691795, new Object[] { paramStringBuffer.toString() }));
      paramString3 = paramString2.toString();
    }
    return paramString3;
  }
  
  private String a(long paramLong, String paramString1, String paramString2)
  {
    String str = paramString2;
    if (TextUtils.isEmpty(paramString2))
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.msg.DiscMsgPc.discuss", 2, "coptype 2 server memberName empty");
      }
      str = ContactUtils.a((QQAppInterface)this.jdField_a_of_type_ComTencentCommonAppAppInterface, String.valueOf(paramLong), paramString1);
    }
    return str;
  }
  
  private String a(long paramLong, HashSet<String> paramHashSet, StringBuffer paramStringBuffer, String paramString)
  {
    if (paramHashSet.size() > 0)
    {
      paramHashSet = paramHashSet.iterator();
      while (paramHashSet.hasNext())
      {
        String str = (String)paramHashSet.next();
        paramStringBuffer.append(ContactUtils.a((QQAppInterface)this.jdField_a_of_type_ComTencentCommonAppAppInterface, String.valueOf(paramLong), str));
        paramStringBuffer.append("、");
      }
    }
    if (paramStringBuffer.length() > 0) {
      paramString = paramStringBuffer.deleteCharAt(paramStringBuffer.toString().length() - 1).toString();
    }
    return paramString;
  }
  
  private String a(MsgInfo paramMsgInfo)
  {
    if ((paramMsgInfo.vNickName != null) && (paramMsgInfo.vNickName.size() > 0)) {
      return (String)paramMsgInfo.vNickName.get(0);
    }
    return "";
  }
  
  private void a(byte paramByte, long paramLong1, long paramLong2)
  {
    if (paramLong2 != Long.valueOf(this.jdField_a_of_type_ComTencentCommonAppAppInterface.getCurrentAccountUin()).longValue()) {
      return;
    }
    if (paramByte == 2)
    {
      MqqHandler localMqqHandler = this.jdField_a_of_type_ComTencentCommonAppAppInterface.getHandler(AVNotifyCenter.class);
      if (localMqqHandler != null)
      {
        Message localMessage = localMqqHandler.obtainMessage(10003);
        localMessage.obj = Long.valueOf(paramLong1);
        localMqqHandler.sendMessage(localMessage);
      }
    }
  }
  
  private void a(long paramLong1, long paramLong2, ArrayList<DiscussionMemberInfo> paramArrayList)
  {
    if (paramArrayList.size() > 0) {
      ((DiscussionManager)this.jdField_a_of_type_ComTencentCommonAppAppInterface.getManager(QQManagerFactory.DISCUSSION_MANAGER)).b(paramArrayList);
    }
    if (QLog.isColorLevel())
    {
      long l = System.currentTimeMillis();
      paramArrayList = new StringBuilder();
      paramArrayList.append("<---discussionMsgRecordHandle_PB saveDiscussionMemberInfoList. disUin:");
      paramArrayList.append(paramLong1);
      paramArrayList.append(", cost=");
      paramArrayList.append(l - paramLong2);
      QLog.d("Q.msg.DiscMsgPc", 2, paramArrayList.toString());
    }
  }
  
  private void a(long paramLong1, long paramLong2, ArrayList<MessageRecord> paramArrayList1, ArrayList<MessageRecord> paramArrayList2)
  {
    if (paramArrayList2 != null) {
      a(paramArrayList2, paramArrayList1, true);
    }
    if (QLog.isColorLevel())
    {
      long l = System.currentTimeMillis();
      paramArrayList1 = new StringBuilder();
      paramArrayList1.append("<---discussionMsgRecordHandle_PB msgListFilter. disUin:");
      paramArrayList1.append(paramLong1);
      paramArrayList1.append(", cost=");
      paramArrayList1.append(l - paramLong2);
      QLog.d("Q.msg.DiscMsgPc", 2, paramArrayList1.toString());
    }
  }
  
  private void a(long paramLong, DiscussionManager paramDiscussionManager, sysmsg_0x20c_0x20.SysMsgBody paramSysMsgBody, int paramInt)
  {
    if (paramInt != 2)
    {
      if (paramInt != 3)
      {
        if (paramInt != 4) {
          return;
        }
        if (paramSysMsgBody.msg_upload_file_remind.has())
        {
          paramLong = ((sysmsg_0x20c_0x20.UploadFileRemind)paramSysMsgBody.msg_upload_file_remind.get()).u64_discuss_code.get();
          if (QLog.isColorLevel()) {
            QLog.d("Q.msg.DiscMsgPc", 2, String.format("0x20(cmd=4): Discussion %d gets a file uploaded.", new Object[] { Long.valueOf(paramLong) }));
          }
        }
      }
      else if (paramSysMsgBody.msg_mem_num_remind.has())
      {
        paramDiscussionManager = (sysmsg_0x20c_0x20.MemberNumRemind)paramSysMsgBody.msg_mem_num_remind.get();
        paramInt = paramDiscussionManager.u32_mem_num.get();
        paramLong = paramDiscussionManager.u64_discuss_code.get();
        if (QLog.isColorLevel()) {
          QLog.d("Q.msg.DiscMsgPc", 2, String.format("0x20(cmd=3): Discussion %d remains %d members.", new Object[] { Long.valueOf(paramLong), Integer.valueOf(paramInt) }));
        }
      }
    }
    else if (paramSysMsgBody.msg_convert_to_group.has())
    {
      Object localObject = (sysmsg_0x20c_0x20.Convert2Group)paramSysMsgBody.msg_convert_to_group.get();
      paramSysMsgBody = String.valueOf(((sysmsg_0x20c_0x20.Convert2Group)localObject).u64_operator.get());
      String str = String.valueOf(((sysmsg_0x20c_0x20.Convert2Group)localObject).u64_group_code.get());
      localObject = String.valueOf(((sysmsg_0x20c_0x20.Convert2Group)localObject).u64_discuss_code.get());
      if (paramDiscussionManager.jdField_a_of_type_JavaUtilMap != null)
      {
        paramDiscussionManager.jdField_a_of_type_JavaUtilMap.put(localObject, new String[] { str, paramSysMsgBody });
        paramDiscussionManager.jdField_a_of_type_JavaUtilSet.add(str);
      }
      if (QLog.isColorLevel()) {
        QLog.d("Q.msg.DiscMsgPc", 2, String.format("0x20(cmd=2): Discussion %s is converted to group %s by user %s.", new Object[] { localObject, str, paramSysMsgBody }));
      }
      ((DiscussionHandler)this.jdField_a_of_type_ComTencentCommonAppAppInterface.getBusinessHandler(BusinessHandlerFactory.DISCUSSION_HANDLER)).a(String.valueOf(paramLong));
      ((ITroopMngHandler)this.jdField_a_of_type_ComTencentCommonAppAppInterface.getBusinessHandler(BusinessHandlerFactory.TROOP_MNG_HANDLER)).a(TroopMngObserver.i, true, new Object[] { Integer.valueOf(2131696140), localObject, str, Boolean.valueOf(this.jdField_a_of_type_ComTencentCommonAppAppInterface.getCurrentUin().equals(paramSysMsgBody)) });
    }
  }
  
  private void a(long paramLong, msg_comm.Msg paramMsg)
  {
    if (paramMsg.content_head.has())
    {
      paramMsg = (msg_comm.ContentHead)paramMsg.content_head.get();
      int i = paramMsg.div_seq.get();
      int j = paramMsg.pkg_index.get();
      int k = paramMsg.pkg_num.get();
      if (QLog.isColorLevel())
      {
        paramMsg = new StringBuilder();
        paramMsg.append("<---discussionMsgRecordHandle_PB ContentHead. disUin:");
        paramMsg.append(paramLong);
        paramMsg.append(", divSeq:");
        paramMsg.append(i);
        paramMsg.append(",pkgIndex:");
        paramMsg.append(j);
        paramMsg.append(",pkgNum:");
        paramMsg.append(k);
        QLog.d("Q.msg.DiscMsgPc", 2, paramMsg.toString());
      }
    }
  }
  
  private void a(MsgInfo paramMsgInfo, long paramLong1, long paramLong2, long paramLong3, DiscussionHandler paramDiscussionHandler1, long paramLong4, String paramString1, HashSet<String> paramHashSet, String paramString2, DiscussionHandler paramDiscussionHandler2)
  {
    paramString2 = this.jdField_a_of_type_ComTencentCommonAppAppInterface.getApp().getString(2131691798, new Object[] { paramString2 });
    if (paramHashSet.contains(this.jdField_a_of_type_ComTencentCommonAppAppInterface.getCurrentAccountUin()))
    {
      if ((int)paramLong4 < 0)
      {
        if (QLog.isColorLevel())
        {
          paramMsgInfo = new StringBuilder();
          paramMsgInfo.append("0x7: kicked from the disc because of converting to a group，dwCmdTime=");
          paramMsgInfo.append(paramLong4);
          QLog.d("Q.msg.DiscMsgPc", 2, paramMsgInfo.toString());
        }
      }
      else
      {
        paramDiscussionHandler2.a(String.valueOf(paramLong3));
        a(paramMsgInfo, paramLong1, paramLong2, paramLong2, HardCodeUtil.a(2131703493));
      }
    }
    else
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramString1);
      localStringBuilder.append(HardCodeUtil.a(2131703492));
      localStringBuilder.append(paramString2);
      paramString1 = localStringBuilder.toString();
      paramDiscussionHandler2.a(String.valueOf(paramLong3), paramHashSet);
      paramDiscussionHandler1.a(paramLong3);
      a(paramMsgInfo, paramLong1, paramLong2, paramLong2, paramString1);
    }
  }
  
  private void a(MsgInfo paramMsgInfo, long paramLong1, long paramLong2, long paramLong3, String paramString)
  {
    MessageRecord localMessageRecord = MessageRecordFactory.a(-1004);
    localMessageRecord.init(paramLong1, paramLong2, paramLong2, paramString, paramMsgInfo.uRealMsgTime, -1004, 3000, paramMsgInfo.uMsgTime);
    localMessageRecord.isread = true;
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("----------handleC2COnlinePushMsgResp after analysis friendUin: ");
      localStringBuilder.append(paramLong2);
      localStringBuilder.append(" msgType: ");
      localStringBuilder.append(-1004);
      localStringBuilder.append(" friendType: ");
      localStringBuilder.append(3000);
      localStringBuilder.append(" shMsgSeq: ");
      localStringBuilder.append(paramMsgInfo.shMsgSeq);
      localStringBuilder.append(" msgContent: ");
      localStringBuilder.append(MessageRecordUtil.a(paramString));
      QLog.d("Q.msg.DiscMsgPc", 2, localStringBuilder.toString());
    }
    if (!MessageHandlerUtils.a(this.jdField_a_of_type_ComTencentCommonAppAppInterface, localMessageRecord, false)) {
      ((IMessageFacade)this.jdField_a_of_type_ComTencentCommonAppAppInterface.getRuntimeService(IMessageFacade.class, "")).addMessage(localMessageRecord, String.valueOf(paramLong1));
    }
  }
  
  private void a(MsgInfo paramMsgInfo, long paramLong1, byte[] paramArrayOfByte, int paramInt, byte paramByte, long paramLong2, DiscussionHandler paramDiscussionHandler, DiscussionManager paramDiscussionManager)
  {
    long l1 = PkgTools.getLongData(paramArrayOfByte, paramInt);
    paramInt += 4;
    long l2 = PkgTools.getLongData(paramArrayOfByte, paramInt);
    paramInt += 4;
    PkgTools.getLongData(paramArrayOfByte, paramInt);
    paramInt += 4;
    int i = PkgTools.getShortData(paramArrayOfByte, paramInt);
    Object localObject = new byte[i];
    PkgTools.getBytesData(paramArrayOfByte, paramInt + 2, (byte[])localObject, i);
    localObject = new String((byte[])localObject);
    if (QLog.isColorLevel())
    {
      paramArrayOfByte = new StringBuilder();
      paramArrayOfByte.append("cOptye:");
      paramArrayOfByte.append(paramByte);
      paramArrayOfByte.append("dwCmdUin =");
      paramArrayOfByte.append(l1);
      paramArrayOfByte.append(" dwCmdTime=");
      paramArrayOfByte.append(l2);
      paramArrayOfByte.append(" strName=");
      paramArrayOfByte.append((String)localObject);
      QLog.d("Q.msg.DiscMsgPc.discuss", 2, paramArrayOfByte.toString());
    }
    if (l1 == paramLong1) {}
    for (paramArrayOfByte = this.jdField_a_of_type_ComTencentCommonAppAppInterface.getApp().getString(2131691765, new Object[] { localObject });; paramArrayOfByte = this.jdField_a_of_type_ComTencentCommonAppAppInterface.getApp().getString(2131691766, new Object[] { paramDiscussionManager, localObject }))
    {
      break;
      paramArrayOfByte = paramDiscussionManager.a(String.valueOf(paramLong2));
      if ((paramArrayOfByte != null) && (paramArrayOfByte.isDiscussHrMeeting())) {
        paramArrayOfByte = QAVHrMeeting.a(paramDiscussionManager, paramArrayOfByte.uin, String.valueOf(l1));
      } else if ((paramMsgInfo.vNickName != null) && (paramMsgInfo.vNickName.size() > 0)) {
        paramArrayOfByte = (String)paramMsgInfo.vNickName.get(0);
      } else {
        paramArrayOfByte = "";
      }
      paramDiscussionManager = paramArrayOfByte;
      if (TextUtils.isEmpty(paramArrayOfByte))
      {
        if (QLog.isColorLevel()) {
          QLog.d("Q.msg.DiscMsgPc.discuss", 2, "coptype 6 server opeaterName empty");
        }
        paramDiscussionManager = ContactUtils.a((QQAppInterface)this.jdField_a_of_type_ComTencentCommonAppAppInterface, String.valueOf(paramLong2), String.valueOf(l1));
      }
    }
    paramDiscussionHandler.a(String.valueOf(paramLong2), (String)localObject);
    a(paramMsgInfo, paramLong1, paramLong2, l1, paramArrayOfByte);
  }
  
  private void a(MsgInfo paramMsgInfo, long paramLong1, byte[] paramArrayOfByte, int paramInt, byte paramByte, long paramLong2, List<String> paramList, DiscussionHandler paramDiscussionHandler)
  {
    ArrayList localArrayList1 = paramMsgInfo.getVNickName();
    long l1 = PkgTools.getLongData(paramArrayOfByte, paramInt);
    paramInt += 8;
    int j = PkgTools.getShortData(paramArrayOfByte, paramInt);
    ArrayList localArrayList2 = new ArrayList();
    int i = paramInt + 2;
    for (paramInt = 1; paramInt < j + 1; paramInt = (short)(paramInt + 1))
    {
      String str = (String)localArrayList1.get(paramInt);
      long l2 = PkgTools.getLongData(paramArrayOfByte, i);
      i += 4;
      paramList.add(String.valueOf(l2));
      localArrayList2.add(new Pair(String.valueOf(l2), str));
    }
    paramArrayOfByte = new DiscussionHandler.ReqDiscussInfo();
    paramArrayOfByte.jdField_b_of_type_Int = localArrayList1.size();
    paramArrayOfByte.jdField_a_of_type_JavaLangString = String.valueOf(paramLong2);
    paramDiscussionHandler.a(paramArrayOfByte);
    paramDiscussionHandler.a(paramLong2, String.valueOf(l1), paramList, 10004);
    paramArrayOfByte = new Pair(Long.valueOf(l1), localArrayList1.get(0));
    paramDiscussionHandler = ((QQAppInterface)this.jdField_a_of_type_ComTencentCommonAppAppInterface).getProxyManager().a();
    if (paramDiscussionHandler.b(Long.toString(paramLong2), 3000) != null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.msg.DiscMsgPc.discuss", 2, "handleDiscussionMemchangeMsg ru alreadyintab");
      }
      if (ContactUtils.a((QQAppInterface)this.jdField_a_of_type_ComTencentCommonAppAppInterface, String.valueOf(paramLong2)))
      {
        a(paramArrayOfByte, paramMsgInfo, localArrayList2, paramLong1, String.valueOf(paramLong2), paramByte, false);
        return;
      }
      b(paramArrayOfByte, paramMsgInfo, localArrayList2, paramLong1, String.valueOf(paramLong2), paramByte, false);
      return;
    }
    paramList = paramDiscussionHandler.a(Long.toString(paramLong2), 3000);
    RecentUtil.a(paramList, ((QQAppInterface)this.jdField_a_of_type_ComTencentCommonAppAppInterface).getMessageFacade());
    paramList.uin = Long.toString(paramLong2);
    paramList.lastmsgtime = paramMsgInfo.uRealMsgTime;
    paramList.setType(3000);
    paramDiscussionHandler.b(paramList);
    if (QLog.isColorLevel())
    {
      paramDiscussionHandler = new StringBuilder();
      paramDiscussionHandler.append("handleDiscussionMemchangeMsg ru.lastmsgtime ");
      paramDiscussionHandler.append(paramMsgInfo.uRealMsgTime);
      QLog.d("Q.msg.DiscMsgPc.discuss", 2, paramDiscussionHandler.toString());
    }
    paramDiscussionHandler = this.jdField_a_of_type_ComTencentCommonAppAppInterface.getCurrentAccountUin();
    if (((ISelectMemberApi)QRoute.api(ISelectMemberApi.class)).getSelectMemberActivity_sNeedBlockDiscussSelfInviteMsg())
    {
      ((ISelectMemberApi)QRoute.api(ISelectMemberApi.class)).setSelectMemberActivity_sNeedBlockDiscussSelfInviteMsg(false);
      b(paramArrayOfByte, paramMsgInfo, localArrayList2, paramLong1, String.valueOf(paramLong2), paramByte, true);
      return;
    }
    if (TextUtils.equals(paramDiscussionHandler, String.valueOf(l1)))
    {
      a(localArrayList1, paramList.uin, paramDiscussionHandler, paramDiscussionHandler);
      ReportController.b(this.jdField_a_of_type_ComTencentCommonAppAppInterface, "CliOper", "", "", "Multi_call", "Show_discuss_tips", 0, 0, "", "", "", "");
      return;
    }
    b(paramArrayOfByte, paramMsgInfo, localArrayList2, paramLong1, String.valueOf(paramLong2), paramByte, true);
  }
  
  private void a(MsgInfo paramMsgInfo, long paramLong1, byte[] paramArrayOfByte, long paramLong2, int paramInt, byte paramByte, long paramLong3, long paramLong4, List<String> paramList, DiscussionHandler paramDiscussionHandler, boolean paramBoolean, long paramLong5, long paramLong6, Pair<Long, String> paramPair)
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.copyTypes(TypeTransformer.java:311)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.fixTypes(TypeTransformer.java:226)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:207)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
  
  private void a(MsgInfo paramMsgInfo, long paramLong1, byte[] paramArrayOfByte, long paramLong2, int paramInt, byte paramByte, long paramLong3, List<String> paramList, DiscussionHandler paramDiscussionHandler)
  {
    long l1 = PkgTools.getLongData(paramArrayOfByte, paramInt);
    paramInt += 4;
    PkgTools.getLongData(paramArrayOfByte, paramInt);
    paramInt += 4;
    long l2 = PkgTools.getLongData(paramArrayOfByte, paramInt);
    paramInt += 4;
    long l3 = PkgTools.getLongData(paramArrayOfByte, paramInt);
    boolean bool;
    if (l3 != 0L) {
      bool = true;
    } else {
      bool = false;
    }
    if ((paramMsgInfo.vNickName != null) && (paramMsgInfo.vNickName.size() >= 1)) {
      localObject = (String)paramMsgInfo.vNickName.get(0);
    } else {
      localObject = "";
    }
    Object localObject = new Pair(Long.valueOf(l1), localObject);
    int i = (int)l2;
    if ((i == 0) || (i == 1) || (i == 2)) {
      a(paramMsgInfo, paramLong1, paramArrayOfByte, paramLong2, paramInt + 4 + 4, paramByte, l1, paramLong3, paramList, paramDiscussionHandler, bool, l2, l3, (Pair)localObject);
    }
    paramArrayOfByte = ((QQAppInterface)this.jdField_a_of_type_ComTencentCommonAppAppInterface).getProxyManager().a();
    if (paramArrayOfByte.b(Long.toString(paramLong3), 3000) != null) {
      return;
    }
    paramList = paramArrayOfByte.a(Long.toString(paramLong3), 3000);
    paramList.uin = Long.toString(paramLong3);
    paramList.lastmsgtime = paramMsgInfo.uRealMsgTime;
    paramList.setType(3000);
    paramArrayOfByte.b(paramList);
  }
  
  private void a(MsgInfo paramMsgInfo, long paramLong1, byte[] paramArrayOfByte, long paramLong2, int paramInt, long paramLong3)
  {
    if (PkgTools.getShortData(paramArrayOfByte, paramInt) != 0)
    {
      paramInt += 2;
      int j = PkgTools.getShortData(paramArrayOfByte, paramInt);
      paramInt += 2;
      ArrayList localArrayList = new ArrayList();
      int i = 0;
      while (i < j)
      {
        long l = PkgTools.getLongData(paramArrayOfByte, paramInt);
        if ((paramMsgInfo.vNickName != null) && (paramMsgInfo.vNickName.size() >= j)) {
          localObject = (String)paramMsgInfo.vNickName.get(i);
        } else {
          localObject = "";
        }
        localArrayList.add(new Pair(Long.valueOf(l), localObject));
        paramInt += 4;
        i += 1;
      }
      i = PkgTools.getShortData(paramArrayOfByte, paramInt);
      Object localObject = new byte[i];
      PkgTools.getBytesData(paramArrayOfByte, paramInt + 2, (byte[])localObject, i);
      paramArrayOfByte = new String((byte[])localObject);
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("cOptye:9 +uinList.size()=");
        ((StringBuilder)localObject).append(localArrayList.size());
        QLog.d("Q.msg.DiscMsgPc.discuss", 2, ((StringBuilder)localObject).toString());
      }
      localObject = localArrayList.iterator();
      while (((Iterator)localObject).hasNext())
      {
        Pair localPair = (Pair)((Iterator)localObject).next();
        if (QLog.isColorLevel())
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("cOptye:9 +遍历uin uin=");
          localStringBuilder.append(localPair.first);
          QLog.d("Q.msg.DiscMsgPc.discuss", 2, localStringBuilder.toString());
        }
      }
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("cOptye:9 +sTips=");
        ((StringBuilder)localObject).append(paramArrayOfByte);
        ((StringBuilder)localObject).append("+lUin=");
        ((StringBuilder)localObject).append(paramLong1);
        QLog.d("Q.msg.DiscMsgPc.discuss", 2, ((StringBuilder)localObject).toString());
      }
      if (this.jdField_a_of_type_AndroidOsHandler == null) {
        this.jdField_a_of_type_AndroidOsHandler = new Handler(ThreadManager.getSubThreadLooper());
      }
      this.jdField_a_of_type_AndroidOsHandler.postDelayed(new DiscMessageProcessor.2(this, localArrayList, paramLong1, paramLong3, paramArrayOfByte, paramMsgInfo, paramLong2), 2000L);
    }
  }
  
  private void a(MsgInfo paramMsgInfo, long paramLong1, byte[] paramArrayOfByte, long paramLong2, int paramInt, long paramLong3, List<String> paramList)
  {
    long l1 = PkgTools.getLongData(paramArrayOfByte, paramInt);
    paramInt += 4;
    long l2 = PkgTools.getLongData(paramArrayOfByte, paramInt);
    int i = paramInt + 4;
    paramInt = PkgTools.getUnsignedByte(paramArrayOfByte[i]);
    i += 1;
    PkgTools.getUTFString(paramArrayOfByte, i, paramInt);
    paramInt = i + paramInt;
    int j = PkgTools.getShortData(paramArrayOfByte, paramInt);
    i = paramInt + 2;
    HashSet localHashSet = new HashSet();
    paramInt = 0;
    while (paramInt < j)
    {
      long l3 = PkgTools.getLongData(paramArrayOfByte, i);
      i += 4;
      localHashSet.add(String.valueOf(l3));
      paramList.add(String.valueOf(l3));
      paramInt += 1;
    }
    if (localHashSet.size() > 0)
    {
      paramArrayOfByte = (DiscussionHandler)this.jdField_a_of_type_ComTencentCommonAppAppInterface.getBusinessHandler(BusinessHandlerFactory.DISCUSSION_HANDLER);
      String str = String.valueOf(paramLong3);
      if (localHashSet.contains(this.jdField_a_of_type_ComTencentCommonAppAppInterface.getCurrentAccountUin()))
      {
        if ((int)l2 < 0)
        {
          if (QLog.isColorLevel())
          {
            paramMsgInfo = new StringBuilder();
            paramMsgInfo.append("0x7: kicked from the disc because of converting to a group，dwCmdTime=");
            paramMsgInfo.append(l2);
            QLog.d("Q.msg.DiscMsgPc", 2, paramMsgInfo.toString());
          }
        }
        else
        {
          paramArrayOfByte.a(str);
          a(paramMsgInfo, paramLong1, paramLong2, paramLong2, HardCodeUtil.a(2131703494));
        }
      }
      else
      {
        paramArrayOfByte.a(str, localHashSet);
        if (Long.getLong(str) != null) {
          paramLong1 = Long.getLong(str).longValue();
        } else {
          paramLong1 = 0L;
        }
        paramArrayOfByte.a(paramLong1);
      }
      paramArrayOfByte.a(paramLong3, String.valueOf(l1), paramList, 10005);
    }
  }
  
  private void a(Pair<Long, String> paramPair1, MsgInfo paramMsgInfo, long paramLong1, long paramLong2, long paramLong3, byte paramByte, long paramLong4, Pair<Long, String> paramPair2)
  {
    long l1 = ((Long)paramPair1.first).longValue();
    long l2 = ((Long)paramPair2.first).longValue();
    String str = (String)paramPair1.second;
    paramPair1 = str;
    if (TextUtils.isEmpty(str))
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.msg.DiscMsgPc.discuss", 2, "coptype 0xb server showName empty");
      }
      paramPair1 = ContactUtils.a((QQAppInterface)this.jdField_a_of_type_ComTencentCommonAppAppInterface, String.valueOf(paramLong2), String.valueOf(l1));
    }
    str = (String)paramPair2.second;
    paramPair2 = str;
    if (TextUtils.isEmpty(str))
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.msg.DiscMsgPc.discuss", 2, "coptype 0xb server shareName empty");
      }
      paramPair2 = ContactUtils.a((QQAppInterface)this.jdField_a_of_type_ComTencentCommonAppAppInterface, String.valueOf(paramLong2), String.valueOf(l2));
    }
    if (ContactUtils.a((QQAppInterface)this.jdField_a_of_type_ComTencentCommonAppAppInterface, String.valueOf(paramLong2))) {
      paramPair1 = ContactUtils.a((QQAppInterface)this.jdField_a_of_type_ComTencentCommonAppAppInterface, String.valueOf(paramLong2), String.valueOf(l1));
    }
    if (paramLong4 == 0L) {
      paramPair1 = this.jdField_a_of_type_ComTencentCommonAppAppInterface.getApp().getString(2131691799, new Object[] { paramPair1 });
    }
    for (;;)
    {
      break;
      if (paramLong4 == 1L) {
        paramPair1 = this.jdField_a_of_type_ComTencentCommonAppAppInterface.getApp().getString(2131691800, new Object[] { paramPair1, paramPair2 });
      } else if (paramLong4 == 2L) {
        paramPair1 = this.jdField_a_of_type_ComTencentCommonAppAppInterface.getApp().getString(2131692180, new Object[] { paramPair1 });
      } else {
        paramPair1 = this.jdField_a_of_type_ComTencentCommonAppAppInterface.getApp().getString(2131691795, new Object[] { paramPair1 });
      }
    }
    a(paramMsgInfo, paramLong1, paramLong2, paramLong3, paramPair1);
  }
  
  private void a(Pair<Long, String> paramPair, MsgInfo paramMsgInfo, ArrayList<Pair<String, String>> paramArrayList, long paramLong1, String paramString, byte paramByte, long paramLong2, boolean paramBoolean)
  {
    long l = ((Long)paramPair.first).longValue();
    String str = (String)paramPair.second;
    int m = paramArrayList.size();
    if (m > 50) {
      i = 50;
    } else {
      i = m;
    }
    paramPair = new StringBuffer(i * 10);
    int k = 0;
    int j = i;
    int i = k;
    while (i < j)
    {
      localObject1 = (Pair)paramArrayList.get(i);
      localObject2 = (String)((Pair)localObject1).first;
      if (Long.valueOf((String)localObject2).longValue() == paramLong1) {
        k = 1;
      } else {
        k = 0;
      }
      if (k != 0)
      {
        localObject1 = this.jdField_a_of_type_ComTencentCommonAppAppInterface.getApp().getString(2131691804);
        a(paramByte, Long.valueOf(paramString).longValue(), paramLong1);
      }
      for (;;)
      {
        break;
        localObject1 = (String)((Pair)localObject1).second;
        if ((TextUtils.isEmpty((CharSequence)localObject1)) || (ContactUtils.a((QQAppInterface)this.jdField_a_of_type_ComTencentCommonAppAppInterface, paramString)))
        {
          if (QLog.isColorLevel())
          {
            localObject1 = new StringBuilder();
            ((StringBuilder)localObject1).append("showWelcomeTips server name empty cOpType:");
            ((StringBuilder)localObject1).append(paramByte);
            QLog.d("Q.msg.DiscMsgPc.discuss", 2, ((StringBuilder)localObject1).toString());
          }
          localObject1 = ContactUtils.a((QQAppInterface)this.jdField_a_of_type_ComTencentCommonAppAppInterface, paramString, (String)localObject2);
        }
      }
      if (i == 0)
      {
        paramPair.append((String)localObject1);
      }
      else
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("、");
        ((StringBuilder)localObject2).append((String)localObject1);
        paramPair.append(((StringBuilder)localObject2).toString());
      }
      i += 1;
    }
    if (m > 50)
    {
      paramPair.append(" 等");
      paramPair.append(m - 1);
      paramPair.append("人");
    }
    if (paramBoolean) {
      i = -5001;
    } else {
      i = -1004;
    }
    Object localObject1 = new ArrayList();
    Object localObject2 = MessageRecordFactory.a(i);
    if (paramByte == 11) {
      paramArrayList = this.jdField_a_of_type_ComTencentCommonAppAppInterface.getApp().getString(2131691802);
    } else {
      paramArrayList = "";
    }
    paramPair = a(paramLong1, paramString, paramByte, paramLong2, l, str, paramPair, paramArrayList);
    ((MessageRecord)localObject2).init(paramLong1, paramMsgInfo.lFromUin, paramMsgInfo.lFromUin, paramPair, paramMsgInfo.uRealMsgTime, i, 3000, paramMsgInfo.uMsgTime);
    ((MessageRecord)localObject2).isread = true;
    if ((localObject2 instanceof MessageForNewGrayTips)) {
      ((MessageForNewGrayTips)localObject2).updateMsgData();
    }
    if (!MessageHandlerUtils.a(this.jdField_a_of_type_ComTencentCommonAppAppInterface, (MessageRecord)localObject2, false)) {
      ((ArrayList)localObject1).add(localObject2);
    }
    if (QLog.isColorLevel())
    {
      paramPair = new StringBuilder();
      paramPair.append("----------handleC2COnlinePushMsgResp after analysis(showWelcomeTips) friendUin: ");
      paramPair.append(((MessageRecord)localObject2).frienduin);
      paramPair.append(" msgType: ");
      paramPair.append(i);
      paramPair.append(" friendType: ");
      paramPair.append(3000);
      paramPair.append(" shMsgSeq: ");
      paramPair.append(paramMsgInfo.shMsgSeq);
      paramPair.append(" msgContent: ");
      paramPair.append(((MessageRecord)localObject2).getLogColorContent());
      QLog.d("Q.msg.DiscMsgPc", 2, paramPair.toString());
    }
    if (((ArrayList)localObject1).size() > 0) {
      ((IMessageFacade)this.jdField_a_of_type_ComTencentCommonAppAppInterface.getRuntimeService(IMessageFacade.class, "")).addMessage((List)localObject1, String.valueOf(paramLong1));
    }
  }
  
  private void a(Pair<Long, String> paramPair, MsgInfo paramMsgInfo, ArrayList<Pair<String, String>> paramArrayList, long paramLong, String paramString, byte paramByte, boolean paramBoolean)
  {
    if (this.jdField_a_of_type_AndroidOsHandler == null) {
      this.jdField_a_of_type_AndroidOsHandler = new Handler(ThreadManager.getSubThreadLooper());
    }
    this.jdField_a_of_type_AndroidOsHandler.postDelayed(new DiscMessageProcessor.3(this, paramPair, paramMsgInfo, paramArrayList, paramLong, paramString, paramByte, paramBoolean), 2000L);
  }
  
  public static void a(QQAppInterface paramQQAppInterface, byte[] paramArrayOfByte, int paramInt, MessageRecord paramMessageRecord, boolean paramBoolean)
  {
    paramMessageRecord = "revokeMsg";
    int i = paramArrayOfByte.length - paramInt;
    Object localObject1 = new byte[i];
    PkgTools.getBytesData(paramArrayOfByte, paramInt, (byte[])localObject1, i);
    paramArrayOfByte = new oidb_0x858.NotifyMsgBody();
    for (;;)
    {
      try
      {
        paramArrayOfByte.mergeFrom((byte[])localObject1);
        paramInt = paramArrayOfByte.opt_enum_type.get();
        l1 = paramArrayOfByte.opt_uint64_conf_uin.get();
        if ((paramInt == 7) && (paramArrayOfByte.opt_msg_recall_reminder.has()))
        {
          paramArrayOfByte = (oidb_0x858.MessageRecallReminder)paramArrayOfByte.opt_msg_recall_reminder.get();
          l2 = paramArrayOfByte.uint64_uin.get();
          l3 = paramArrayOfByte.uint64_admin_uin.get();
          localObject1 = new HashMap();
        }
      }
      catch (Exception paramQQAppInterface)
      {
        long l1;
        long l2;
        long l3;
        Object localObject2;
        Object localObject3;
        Object localObject4;
        paramQQAppInterface.printStackTrace();
        if (QLog.isColorLevel())
        {
          paramArrayOfByte = new StringBuilder();
          paramArrayOfByte.append("parse0x20c_subType0x19 Exception ");
          paramArrayOfByte.append(paramQQAppInterface.getStackTrace());
          QLog.e("Q.msg.DiscMsgPc", 2, paramArrayOfByte.toString());
        }
      }
      try
      {
        localObject2 = new msgrevoke_userdef.MsgInfoUserDef();
        ((msgrevoke_userdef.MsgInfoUserDef)localObject2).mergeFrom(paramArrayOfByte.bytes_userdef.get().toByteArray());
        paramInt = ((msgrevoke_userdef.MsgInfoUserDef)localObject2).uint32_long_message_flag.get();
        if (paramInt == 1)
        {
          localObject2 = ((ArrayList)((msgrevoke_userdef.MsgInfoUserDef)localObject2).long_msg_info.get()).iterator();
          if (((Iterator)localObject2).hasNext())
          {
            localObject3 = (msgrevoke_userdef.MsgInfoUserDef.MsgInfoDef)((Iterator)localObject2).next();
            ((HashMap)localObject1).put(Integer.valueOf(((msgrevoke_userdef.MsgInfoUserDef.MsgInfoDef)localObject3).uint32_msg_seq.get()), localObject3);
            continue;
          }
        }
        localObject2 = new ArrayList();
        localObject3 = ((ArrayList)paramArrayOfByte.uint32_recalled_msg_list.get()).iterator();
        paramArrayOfByte = paramMessageRecord;
      }
      catch (Exception paramQQAppInterface)
      {
        continue;
        continue;
      }
      if (((Iterator)localObject3).hasNext())
      {
        localObject4 = (oidb_0x858.MessageRecallReminder.MessageMeta)((Iterator)localObject3).next();
        paramMessageRecord = new RevokeMsgInfo();
        paramMessageRecord.jdField_b_of_type_JavaLangString = String.valueOf(l2);
        paramMessageRecord.jdField_c_of_type_JavaLangString = String.valueOf(l3);
        paramMessageRecord.jdField_a_of_type_JavaLangString = String.valueOf(l1);
        paramMessageRecord.jdField_a_of_type_Int = 3000;
        paramMessageRecord.jdField_a_of_type_Long = ((oidb_0x858.MessageRecallReminder.MessageMeta)localObject4).uint32_seq.get();
        paramMessageRecord.jdField_c_of_type_Long = ((oidb_0x858.MessageRecallReminder.MessageMeta)localObject4).uint32_time.get();
        paramMessageRecord.f = ((oidb_0x858.MessageRecallReminder.MessageMeta)localObject4).uint32_is_anony_msg.get();
        if (paramInt == 1)
        {
          localObject4 = (msgrevoke_userdef.MsgInfoUserDef.MsgInfoDef)((HashMap)localObject1).get(Integer.valueOf(((oidb_0x858.MessageRecallReminder.MessageMeta)localObject4).uint32_seq.get()));
          paramMessageRecord.jdField_b_of_type_Int = ((msgrevoke_userdef.MsgInfoUserDef.MsgInfoDef)localObject4).long_msg_id.get();
          paramMessageRecord.jdField_c_of_type_Int = ((msgrevoke_userdef.MsgInfoUserDef.MsgInfoDef)localObject4).long_msg_num.get();
          paramMessageRecord.d = ((msgrevoke_userdef.MsgInfoUserDef.MsgInfoDef)localObject4).long_msg_index.get();
        }
        ((ArrayList)localObject2).add(paramMessageRecord);
        if (!QLog.isColorLevel()) {
          break label546;
        }
        localObject4 = new StringBuilder();
        ((StringBuilder)localObject4).append("recv 0x20c_0x19 msg,");
        ((StringBuilder)localObject4).append(paramMessageRecord.toString());
        paramMessageRecord = ((StringBuilder)localObject4).toString();
        QLog.d(paramArrayOfByte, 2, paramMessageRecord);
      }
      else
      {
        ((IMessageFacade)paramQQAppInterface.getRuntimeService(IMessageFacade.class, "")).handleRevokedNotifyAndNotify((ArrayList)localObject2, false);
        return;
        if (QLog.isColorLevel()) {
          QLog.d("revokeMsg", 2, "recv 0x20c_0x19 msg, parse msgInfoUserDef error");
        }
        return;
      }
    }
  }
  
  private void a(ToServiceMsg paramToServiceMsg, ArrayList<msg_comm.Msg> paramArrayList, msg_svc.PbGetDiscussMsgResp paramPbGetDiscussMsgResp)
  {
    ArrayList localArrayList = new ArrayList();
    String str = String.valueOf(paramToServiceMsg.extraData.getLong("lDisUin", paramPbGetDiscussMsgResp.discuss_uin.get()));
    long l = ((MessageCache)this.jdField_a_of_type_ComTencentCommonAppAppInterface.getMsgCache()).h(str);
    StringBuilder localStringBuilder = new StringBuilder();
    if (QLog.isColorLevel())
    {
      localStringBuilder.append("<<---initGetPullDiscussionMsg discussUin: ");
      localStringBuilder.append(str);
      localStringBuilder.append(" res.cReplyCode: ");
      localStringBuilder.append(paramPbGetDiscussMsgResp.result.get());
      localStringBuilder.append(" lastSeq: ");
      localStringBuilder.append(l);
      QLog.d("Q.msg.DiscMsgPc_At_Me_DISC", 2, localStringBuilder.toString());
    }
    if (paramArrayList != null) {
      a(paramArrayList, localArrayList);
    }
    if ((paramPbGetDiscussMsgResp.result.get() == 104) && (localArrayList.size() == 0))
    {
      l = paramToServiceMsg.extraData.getLong("lEndSeq", paramPbGetDiscussMsgResp.return_end_seq.get());
      if (QLog.isColorLevel())
      {
        paramToServiceMsg = new StringBuilder();
        paramToServiceMsg.append("initGetPullDiscussionMsg reply 104 !! disUin=");
        paramToServiceMsg.append(str);
        paramToServiceMsg.append(", reqEndSeq=");
        paramToServiceMsg.append(l);
        QLog.d("Q.msg.DiscMsgPc", 2, paramToServiceMsg.toString());
      }
      ((MessageCache)this.jdField_a_of_type_ComTencentCommonAppAppInterface.getMsgCache()).c(str, l);
      i = 1;
    }
    else
    {
      i = 0;
    }
    if (localArrayList.size() > 0)
    {
      b(localArrayList);
      Collections.sort(localArrayList, this.jdField_a_of_type_JavaUtilComparator);
      paramToServiceMsg = new ArrayList();
      a(localArrayList, str, localStringBuilder, paramToServiceMsg);
      int k = localArrayList.size();
      int j = 0;
      while (j < k)
      {
        paramArrayList = (MessageRecord)localArrayList.get(j);
        if ((paramArrayList instanceof MessageForMarketFace)) {
          CommercialDrainageManagerConstants.a(this.jdField_a_of_type_ComTencentCommonAppAppInterface, (MessageForMarketFace)paramArrayList);
        }
        j += 1;
      }
      l = ((MessageCache)this.jdField_a_of_type_ComTencentCommonAppAppInterface.getMsgCache()).h(str);
      if (paramToServiceMsg.size() > 0)
      {
        a(paramToServiceMsg, str, false, 0, l);
        break label400;
      }
    }
    int i = 1;
    label400:
    if ((i != 0) && (((MessageCache)this.jdField_a_of_type_ComTencentCommonAppAppInterface.getMsgCache()).b(str) == 1))
    {
      paramToServiceMsg = ((MessageCache)this.jdField_a_of_type_ComTencentCommonAppAppInterface.getMsgCache()).a(str);
      if (paramToServiceMsg != null)
      {
        l = ((Long)paramToServiceMsg[0]).longValue();
        ((BaseMessageManagerForTroopAndDisc)((QQAppInterface)this.jdField_a_of_type_ComTencentCommonAppAppInterface).getMessageFacade().a(3000)).b(str, 3000, l);
      }
    }
  }
  
  private void a(ToServiceMsg paramToServiceMsg, ArrayList<msg_comm.Msg> paramArrayList, msg_svc.PbGetDiscussMsgResp paramPbGetDiscussMsgResp, String paramString)
  {
    ArrayList localArrayList1 = new ArrayList();
    Object localObject = new HashSet();
    ArrayList localArrayList2 = new ArrayList();
    MessageInfo localMessageInfo = new MessageInfo();
    if ((paramArrayList != null) && (paramArrayList.size() > 0))
    {
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("<---refreshDiscussionHead_PB: size:");
        localStringBuilder.append(paramArrayList.size());
        QLog.d("Q.msg.DiscMsgPc", 2, localStringBuilder.toString());
      }
      a(paramArrayList, paramString, localArrayList1, (HashSet)localObject, localArrayList2, localMessageInfo);
    }
    if (localArrayList2.size() > 0) {
      ((DiscussionManager)this.jdField_a_of_type_ComTencentCommonAppAppInterface.getManager(QQManagerFactory.DISCUSSION_MANAGER)).b(localArrayList2);
    }
    a(localArrayList1);
    Collections.sort(localArrayList1, this.jdField_a_of_type_JavaUtilComparator);
    paramToServiceMsg = paramToServiceMsg.extraData.getBundle("context");
    paramArrayList = paramPbGetDiscussMsgResp.discuss_uin.toString();
    paramString = (TroopInfoManager)this.jdField_a_of_type_ComTencentCommonAppAppInterface.getManager(QQManagerFactory.TROOPINFO_MANAGER);
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append(paramArrayList);
    ((StringBuilder)localObject).append("&");
    ((StringBuilder)localObject).append(3000);
    paramString.a(((StringBuilder)localObject).toString(), localMessageInfo);
    paramArrayList = new ArrayList();
    if (paramToServiceMsg != null)
    {
      paramToServiceMsg.putLong("beginSeq", paramPbGetDiscussMsgResp.return_begin_seq.get());
      paramToServiceMsg.putLong("endSeq", paramPbGetDiscussMsgResp.return_end_seq.get());
      paramToServiceMsg.putBoolean("success", true);
      ((IMessageFacade)this.jdField_a_of_type_ComTencentCommonAppAppInterface.getRuntimeService(IMessageFacade.class, "")).handleRefreshMessageListHeadResult(String.valueOf(paramPbGetDiscussMsgResp.discuss_uin.get()), 3000, localArrayList1, paramArrayList, paramToServiceMsg);
    }
    PreDownloadMsg.a(paramArrayList, true, this.jdField_a_of_type_ComTencentCommonAppAppInterface);
    ((VasExtensionManager)this.jdField_a_of_type_ComTencentCommonAppAppInterface.getManager(QQManagerFactory.VAS_EXTENSION_MANAGER)).a.a(localArrayList1);
  }
  
  private void a(StringBuilder paramStringBuilder, ArrayList<Pair<Long, String>> paramArrayList, long paramLong)
  {
    int i = 0;
    while (i < paramArrayList.size())
    {
      Object localObject2 = (String)((Pair)paramArrayList.get(i)).second;
      Object localObject1 = localObject2;
      if (TextUtils.isEmpty((CharSequence)localObject2))
      {
        if (QLog.isColorLevel()) {
          QLog.d("Q.msg.DiscMsgPc.discuss", 2, "coptype 9 server showName empty");
        }
        localObject1 = ContactUtils.a((QQAppInterface)this.jdField_a_of_type_ComTencentCommonAppAppInterface, String.valueOf(paramLong), String.valueOf(paramArrayList.get(i)));
      }
      if (i == 0)
      {
        paramStringBuilder.append((String)localObject1);
      }
      else
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("、");
        ((StringBuilder)localObject2).append((String)localObject1);
        paramStringBuilder.append(((StringBuilder)localObject2).toString());
      }
      i += 1;
    }
  }
  
  private void a(ArrayList<MessageRecord> paramArrayList)
  {
    DiscussionHandler localDiscussionHandler = (DiscussionHandler)this.jdField_a_of_type_ComTencentCommonAppAppInterface.getBusinessHandler(BusinessHandlerFactory.DISCUSSION_HANDLER);
    paramArrayList = paramArrayList.iterator();
    while (paramArrayList.hasNext())
    {
      MessageRecord localMessageRecord = (MessageRecord)paramArrayList.next();
      if ((localMessageRecord.senderuin != null) && (localMessageRecord.senderuin.equalsIgnoreCase(this.jdField_a_of_type_ComTencentCommonAppAppInterface.getCurrentAccountUin()))) {
        localMessageRecord.issend = 2;
      }
      localMessageRecord.isread = true;
      try
      {
        localDiscussionHandler.a(Long.parseLong(localMessageRecord.frienduin), Long.parseLong(localMessageRecord.senderuin));
      }
      catch (Exception localException)
      {
        label93:
        StringBuilder localStringBuilder;
        break label93;
      }
      if (QLog.isColorLevel())
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("processRefreshHead exception when checkAndGetDiscussionMemberExist ");
        localStringBuilder.append(localMessageRecord.frienduin);
        localStringBuilder.append(":");
        localStringBuilder.append(localMessageRecord.senderuin);
        QLog.e("Q.msg.DiscMsgPc", 2, localStringBuilder.toString());
      }
    }
  }
  
  private void a(ArrayList<String> paramArrayList, String paramString1, String paramString2, String paramString3)
  {
    MessageRecord localMessageRecord = MessageRecordFactory.a(-1016);
    long l = MessageCache.a();
    if ((paramArrayList != null) && (paramArrayList.size() > 1))
    {
      int k = paramArrayList.size();
      int i;
      if (k > 50) {
        i = 50;
      } else {
        i = k;
      }
      StringBuilder localStringBuilder = new StringBuilder(i * 10);
      int j = 1;
      while (j < i)
      {
        localStringBuilder.append((String)paramArrayList.get(j));
        if (j != i - 1) {
          localStringBuilder.append("、");
        }
        j += 1;
      }
      if (k > 50)
      {
        localStringBuilder.append(" 等");
        localStringBuilder.append(k - 1);
        localStringBuilder.append("人");
      }
      paramArrayList = this.jdField_a_of_type_ComTencentCommonAppAppInterface.getApplication().getString(2131691303, new Object[] { localStringBuilder });
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramArrayList);
      localStringBuilder.append(this.jdField_a_of_type_ComTencentCommonAppAppInterface.getApplication().getString(2131694338));
      localMessageRecord.init(paramString2, paramString1, paramString3, localStringBuilder.toString(), l, -1016, 3000, l);
      localMessageRecord.extStr = paramArrayList;
      localMessageRecord.isread = true;
      ((IMessageFacade)this.jdField_a_of_type_ComTencentCommonAppAppInterface.getRuntimeService(IMessageFacade.class, "")).addMessage(localMessageRecord, localMessageRecord.selfuin);
    }
  }
  
  private void a(ArrayList<MessageRecord> paramArrayList1, String paramString, StringBuilder paramStringBuilder, ArrayList<MessageRecord> paramArrayList2)
  {
    int i = paramArrayList1.size() - 1;
    while (i >= 0)
    {
      MessageRecord localMessageRecord = (MessageRecord)paramArrayList1.get(i);
      if (QLog.isColorLevel())
      {
        paramStringBuilder.setLength(0);
        paramStringBuilder.append("----------initGetPullDiscussionMsg update send message  mr.senderuin: ");
        paramStringBuilder.append(localMessageRecord.senderuin);
        paramStringBuilder.append(" mr.msgtype: ");
        paramStringBuilder.append(localMessageRecord.msgtype);
        paramStringBuilder.append(" mr.frienduin: ");
        paramStringBuilder.append(localMessageRecord.frienduin);
        paramStringBuilder.append(" mr.shmsgseq: ");
        paramStringBuilder.append(localMessageRecord.shmsgseq);
        paramStringBuilder.append(" mr.time:");
        paramStringBuilder.append(localMessageRecord.time);
        paramStringBuilder.append(" mr.msg: ");
        paramStringBuilder.append(localMessageRecord.getLogColorContent());
        QLog.d("Q.msg.DiscMsgPc", 2, paramStringBuilder.toString());
      }
      if (!a(paramString, localMessageRecord)) {
        paramArrayList2.add(0, localMessageRecord);
      }
      i -= 1;
    }
  }
  
  private void a(ArrayList<msg_comm.Msg> paramArrayList, String paramString, ArrayList<MessageRecord> paramArrayList1, HashSet<String> paramHashSet, ArrayList<DiscussionMemberInfo> paramArrayList2, MessageInfo paramMessageInfo)
  {
    paramArrayList = paramArrayList.iterator();
    while (paramArrayList.hasNext())
    {
      msg_comm.Msg localMsg = (msg_comm.Msg)paramArrayList.next();
      Object localObject1 = (msg_comm.MsgHead)localMsg.msg_head.get();
      if (!((msg_comm.MsgHead)localObject1).discuss_info.has())
      {
        if (QLog.isColorLevel()) {
          QLog.d("Q.msg.DiscMsgPc", 2, "<---refreshDiscussionHead_PB: no discussInfo.");
        }
      }
      else
      {
        Object localObject2 = (msg_comm.DiscussInfo)((msg_comm.MsgHead)localObject1).discuss_info.get();
        long l2 = ((msg_comm.MsgHead)localObject1).from_uin.get();
        long l4 = ((msg_comm.MsgHead)localObject1).to_uin.get();
        long l3 = ((msg_comm.MsgHead)localObject1).msg_seq.get();
        int i = ((msg_comm.MsgHead)localObject1).msg_time.get();
        long l5 = ((msg_comm.MsgHead)localObject1).msg_uid.get();
        int j = ((msg_comm.MsgHead)localObject1).user_active.get();
        int k = ((msg_comm.MsgHead)localObject1).from_instid.get();
        long l1 = ((msg_comm.DiscussInfo)localObject2).discuss_uin.get();
        int m = ((msg_comm.DiscussInfo)localObject2).discuss_type.get();
        long l6 = ((msg_comm.DiscussInfo)localObject2).discuss_info_seq.get();
        if ((((msg_comm.DiscussInfo)localObject2).discuss_remark.has()) && (((msg_comm.DiscussInfo)localObject2).discuss_remark.get() != null)) {
          localObject1 = ((msg_comm.DiscussInfo)localObject2).discuss_remark.get().toByteArray();
        } else {
          localObject1 = null;
        }
        if (QLog.isColorLevel())
        {
          localObject3 = new StringBuilder();
          ((StringBuilder)localObject3).append("<---refreshDiscussionHead_PB : fromUin:");
          ((StringBuilder)localObject3).append(l2);
          ((StringBuilder)localObject3).append(",toUin:");
          ((StringBuilder)localObject3).append(l4);
          ((StringBuilder)localObject3).append(",msgTime:");
          ((StringBuilder)localObject3).append(i);
          ((StringBuilder)localObject3).append(",msgSeq:");
          ((StringBuilder)localObject3).append(l3);
          ((StringBuilder)localObject3).append(",msgUid:");
          ((StringBuilder)localObject3).append(l5);
          ((StringBuilder)localObject3).append(",userActive:");
          ((StringBuilder)localObject3).append(j);
          ((StringBuilder)localObject3).append(",fromInstid:");
          ((StringBuilder)localObject3).append(k);
          ((StringBuilder)localObject3).append(",disUin:");
          ((StringBuilder)localObject3).append(l1);
          ((StringBuilder)localObject3).append(",disType:");
          ((StringBuilder)localObject3).append(m);
          ((StringBuilder)localObject3).append(",disSeq:");
          ((StringBuilder)localObject3).append(l6);
          ((StringBuilder)localObject3).append(",remarkSender:");
          ((StringBuilder)localObject3).append(Arrays.toString((byte[])localObject1));
          ((StringBuilder)localObject3).append(",hasAppShare:");
          localObject2 = localMsg;
          ((StringBuilder)localObject3).append(((msg_comm.Msg)localObject2).appshare_info.has());
          ((StringBuilder)localObject3).append(",hasMsgBody:");
          ((StringBuilder)localObject3).append(((msg_comm.Msg)localObject2).msg_body.has());
          QLog.d("Q.msg.DiscMsgPc", 2, ((StringBuilder)localObject3).toString());
        }
        localObject2 = new ArrayList();
        Object localObject3 = new ArrayList();
        PBDecodeContext localPBDecodeContext = new PBDecodeContext();
        localPBDecodeContext.jdField_g_of_type_Long = l1;
        localPBDecodeContext.f = 3000;
        localPBDecodeContext.jdField_g_of_type_Int = m;
        if (localMsg.content_head.has())
        {
          Object localObject4 = (msg_comm.ContentHead)localMsg.content_head.get();
          i = ((msg_comm.ContentHead)localObject4).div_seq.get();
          j = ((msg_comm.ContentHead)localObject4).pkg_index.get();
          k = ((msg_comm.ContentHead)localObject4).pkg_num.get();
          if (QLog.isColorLevel())
          {
            localObject4 = new StringBuilder();
            ((StringBuilder)localObject4).append("<---refreshDiscussionHead_PB ContentHead: divSeq:");
            ((StringBuilder)localObject4).append(i);
            ((StringBuilder)localObject4).append(",pkgIndex:");
            ((StringBuilder)localObject4).append(j);
            ((StringBuilder)localObject4).append(",pkgNum:");
            ((StringBuilder)localObject4).append(k);
            QLog.d("Q.msg.DiscMsgPc", 2, ((StringBuilder)localObject4).toString());
          }
        }
        try
        {
          a(localMsg, (ArrayList)localObject3, localPBDecodeContext, true, paramMessageInfo);
        }
        catch (Exception localException)
        {
          if (QLog.isColorLevel()) {
            QLog.w("Q.msg.DiscMsgPc", 2, "decodeSinglePbMsg_GroupDis error,", localException);
          }
        }
        if (((ArrayList)localObject3).size() > 0) {
          a((List)localObject3, (ArrayList)localObject2, true);
        }
        if (((ArrayList)localObject2).size() >= 1)
        {
          BaseMessageHandlerUtils.a((List)localObject2);
          paramArrayList1.addAll((Collection)localObject2);
          MessageHandlerUtils.a("Q.msg.DiscMsgPc", paramString, l3, this.jdField_a_of_type_ComTencentCommonAppAppInterface.getAccount(), String.valueOf(l1));
          a(paramHashSet, paramArrayList2, l2, l1, (byte[])localObject1);
        }
      }
    }
  }
  
  private void a(ArrayList<MessageRecord> paramArrayList, String paramString, boolean paramBoolean, int paramInt, long paramLong)
  {
    Object localObject1 = paramArrayList.iterator();
    Object localObject2;
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (MessageRecord)((Iterator)localObject1).next();
      if (((MessageRecord)localObject2).shmsgseq > paramLong) {
        paramLong = ((MessageRecord)localObject2).shmsgseq;
      }
    }
    localObject1 = (BaseMessageManagerForTroopAndDisc)((QQAppInterface)this.jdField_a_of_type_ComTencentCommonAppAppInterface).getMessageFacade().a(3000);
    if (!((BaseMessageManagerForTroopAndDisc)localObject1).a(paramString, 3000, paramArrayList, this.jdField_a_of_type_ComTencentCommonAppAppInterface.getCurrentAccountUin()))
    {
      localObject2 = ((MessageCache)this.jdField_a_of_type_ComTencentCommonAppAppInterface.getMsgCache()).a(paramString);
      int i = paramArrayList.size();
      paramInt = 0;
      while (paramInt < i)
      {
        if ((((MessageRecord)paramArrayList.get(paramInt)).senderuin != null) && (((MessageRecord)paramArrayList.get(paramInt)).senderuin.equalsIgnoreCase(this.jdField_a_of_type_ComTencentCommonAppAppInterface.getCurrentAccountUin())))
        {
          ((MessageRecord)paramArrayList.get(paramInt)).isread = true;
          ((MessageRecord)paramArrayList.get(paramInt)).issend = 2;
        }
        if (((Long)localObject2[0]).longValue() >= ((MessageRecord)paramArrayList.get(paramInt)).shmsgseq) {
          ((MessageRecord)paramArrayList.get(paramInt)).isread = true;
        }
        paramInt += 1;
      }
      boolean bool = MessageHandlerUtils.a(paramArrayList);
      paramInt = MsgProxyUtils.a(paramArrayList, (MessageCache)this.jdField_a_of_type_ComTencentCommonAppAppInterface.getMsgCache());
      IMessageFacade localIMessageFacade = (IMessageFacade)this.jdField_a_of_type_ComTencentCommonAppAppInterface.getRuntimeService(IMessageFacade.class, "");
      String str = this.jdField_a_of_type_ComTencentCommonAppAppInterface.getCurrentAccountUin();
      if ((bool) && (this.jdField_a_of_type_ComTencentCommonAppAppInterface.isBackgroundStop)) {
        paramBoolean = true;
      } else {
        paramBoolean = false;
      }
      localIMessageFacade.addMessage(paramArrayList, str, paramBoolean, false);
      if ((localObject2 != null) && (localObject2.length > 0)) {
        ((BaseMessageManagerForTroopAndDisc)localObject1).b(paramString, 3000, ((Long)localObject2[0]).longValue());
      }
      ((BaseMessageManagerForTroopAndDisc)localObject1).a(paramString, paramArrayList);
      paramBoolean = bool;
    }
    ((MessageCache)this.jdField_a_of_type_ComTencentCommonAppAppInterface.getMsgCache()).h(paramString, paramLong);
    if ((this.jdField_a_of_type_ComTencentMobileqqAppBaseMessageHandler.a(paramBoolean)) && (!DiscussionManager.a((QQAppInterface)this.jdField_a_of_type_ComTencentCommonAppAppInterface, paramString, 3000))) {
      paramBoolean = true;
    } else {
      paramBoolean = false;
    }
    a("initGetPullDiscussionMsg", true, paramInt, paramBoolean, false);
    PreDownloadMsg.a(paramArrayList, true, this.jdField_a_of_type_ComTencentCommonAppAppInterface);
    ((VasExtensionManager)this.jdField_a_of_type_ComTencentCommonAppAppInterface.getManager(QQManagerFactory.VAS_EXTENSION_MANAGER)).a.a(paramArrayList);
  }
  
  private void a(ArrayList<msg_comm.Msg> paramArrayList, ArrayList<MessageRecord> paramArrayList1)
  {
    String str = "Q.msg.DiscMsgPc";
    if ((paramArrayList != null) && (paramArrayList.size() > 0))
    {
      HashSet localHashSet = new HashSet();
      ArrayList localArrayList1 = new ArrayList();
      new ArrayList();
      paramArrayList = paramArrayList.iterator();
      long l1 = 0L;
      while (paramArrayList.hasNext())
      {
        msg_comm.Msg localMsg = (msg_comm.Msg)paramArrayList.next();
        MessageInfo localMessageInfo = new MessageInfo();
        Object localObject1 = (msg_comm.MsgHead)localMsg.msg_head.get();
        if ((!((msg_comm.MsgHead)localObject1).discuss_info.has()) && (QLog.isColorLevel())) {
          QLog.d(str, 2, "<---handleMsgPush_PB_Group: no groupInfo.");
        }
        Object localObject2 = (msg_comm.DiscussInfo)((msg_comm.MsgHead)localObject1).discuss_info.get();
        long l4 = ((msg_comm.MsgHead)localObject1).from_uin.get();
        long l2 = ((msg_comm.MsgHead)localObject1).to_uin.get();
        long l3 = ((msg_comm.MsgHead)localObject1).msg_seq.get();
        int i = ((msg_comm.MsgHead)localObject1).msg_time.get();
        long l5 = ((msg_comm.MsgHead)localObject1).msg_uid.get();
        int j = ((msg_comm.MsgHead)localObject1).user_active.get();
        int k = ((msg_comm.MsgHead)localObject1).from_instid.get();
        l1 = ((msg_comm.DiscussInfo)localObject2).discuss_uin.get();
        int m = ((msg_comm.DiscussInfo)localObject2).discuss_type.get();
        long l6 = ((msg_comm.DiscussInfo)localObject2).discuss_info_seq.get();
        if ((((msg_comm.DiscussInfo)localObject2).discuss_remark.has()) && (((msg_comm.DiscussInfo)localObject2).discuss_remark.get() != null)) {
          localObject1 = ((msg_comm.DiscussInfo)localObject2).discuss_remark.get().toByteArray();
        } else {
          localObject1 = null;
        }
        if (QLog.isColorLevel())
        {
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append("<---discussionMsgRecordHandle_PB : fromUin:");
          ((StringBuilder)localObject2).append(l4);
          ((StringBuilder)localObject2).append(",toUin:");
          ((StringBuilder)localObject2).append(l2);
          ((StringBuilder)localObject2).append(",msgTime:");
          ((StringBuilder)localObject2).append(i);
          ((StringBuilder)localObject2).append(",msgSeq:");
          ((StringBuilder)localObject2).append(l3);
          ((StringBuilder)localObject2).append(",msgUid:");
          ((StringBuilder)localObject2).append(l5);
          ((StringBuilder)localObject2).append(",userActive:");
          ((StringBuilder)localObject2).append(j);
          ((StringBuilder)localObject2).append(",fromInstid:");
          ((StringBuilder)localObject2).append(k);
          ((StringBuilder)localObject2).append(",disUin:");
          ((StringBuilder)localObject2).append(l1);
          ((StringBuilder)localObject2).append(",disType:");
          ((StringBuilder)localObject2).append(m);
          ((StringBuilder)localObject2).append(",disSeq:");
          ((StringBuilder)localObject2).append(l6);
          ((StringBuilder)localObject2).append(",remarkSender:");
          ((StringBuilder)localObject2).append(Arrays.toString((byte[])localObject1));
          ((StringBuilder)localObject2).append(",hasAppShare:");
          ((StringBuilder)localObject2).append(localMsg.appshare_info.has());
          ((StringBuilder)localObject2).append(",hasMsgBody:");
          ((StringBuilder)localObject2).append(localMsg.msg_body.has());
          QLog.d(str, 2, ((StringBuilder)localObject2).toString());
        }
        localObject2 = new ArrayList();
        ArrayList localArrayList2 = new ArrayList();
        PBDecodeContext localPBDecodeContext = new PBDecodeContext();
        localPBDecodeContext.jdField_g_of_type_Long = l1;
        localPBDecodeContext.f = 3000;
        localPBDecodeContext.jdField_g_of_type_Int = m;
        a(l1, localMsg);
        l2 = System.currentTimeMillis();
        try
        {
          a(localMsg, localArrayList2, localPBDecodeContext, true, localMessageInfo);
        }
        catch (Exception localException)
        {
          if (QLog.isColorLevel()) {
            QLog.w(str, 2, "decodeSinglePbMsg_GroupDis error,", localException);
          }
        }
        if (QLog.isColorLevel())
        {
          l3 = System.currentTimeMillis();
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("<---discussionMsgRecordHandle_PB decodeSinglePbMsg_Group. isUin:");
          localStringBuilder.append(l1);
          localStringBuilder.append(", cost=");
          localStringBuilder.append(l3 - l2);
          QLog.d(str, 2, localStringBuilder.toString());
          l2 = l3;
        }
        a(l1, l2, (ArrayList)localObject2, localArrayList2);
        if (((ArrayList)localObject2).size() >= 1)
        {
          BaseMessageHandlerUtils.a((List)localObject2);
          paramArrayList1.addAll((Collection)localObject2);
          a(localHashSet, localArrayList1, l4, l1, (byte[])localObject1);
        }
      }
      a(l1, System.currentTimeMillis(), localArrayList1);
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("Q.msg.DiscMsgPc", 2, "discussionMsgRecordHandle_PB msgs is null or size <= 0");
    }
  }
  
  private void a(HashSet<String> paramHashSet, ArrayList<DiscussionMemberInfo> paramArrayList, long paramLong1, long paramLong2, byte[] paramArrayOfByte)
  {
    if ((paramArrayOfByte != null) && (paramArrayOfByte.length > 0))
    {
      String str = String.valueOf(paramLong1);
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append(HexUtil.bytes2HexStr(paramArrayOfByte));
      ((StringBuilder)localObject).append(":");
      ((StringBuilder)localObject).append(str);
      localObject = ((StringBuilder)localObject).toString();
      if (!paramHashSet.contains(localObject))
      {
        paramArrayOfByte = ((DiscussionManager)this.jdField_a_of_type_ComTencentCommonAppAppInterface.getManager(QQManagerFactory.DISCUSSION_MANAGER)).a(paramArrayOfByte, String.valueOf(paramLong2), str, false);
        if (paramArrayOfByte != null)
        {
          paramArrayList.add(paramArrayOfByte);
          paramHashSet.add(localObject);
        }
      }
    }
  }
  
  private void a(List<msg_comm.Msg> paramList1, List<msg_comm.Msg> paramList2)
  {
    Pair localPair = super.a(paramList1, paramList2);
    if ((((Boolean)localPair.first).booleanValue()) && (QLog.isColorLevel()))
    {
      StringBuilder localStringBuilder = new StringBuilder("<---DiscussionMessagePackage:msgFilter_OnePkg ");
      localStringBuilder.append((CharSequence)localPair.second);
      localStringBuilder.append(" inListSize:");
      localStringBuilder.append(paramList1.size());
      localStringBuilder.append(" outListSize:");
      localStringBuilder.append(paramList2.size());
      QLog.d("Q.msg.DiscMsgPc", 2, localStringBuilder.toString());
    }
  }
  
  private void a(msg_comm.Msg paramMsg, FromServiceMsg paramFromServiceMsg, msg_onlinepush.PbPushMsg paramPbPushMsg, boolean paramBoolean)
  {
    Object localObject1 = (msg_comm.MsgHead)paramMsg.msg_head.get();
    if (!((msg_comm.MsgHead)localObject1).discuss_info.has())
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.msg.DiscMsgPc", 2, "<---handleMsgPush_PB_Group: no groupInfo.");
      }
      return;
    }
    Object localObject2 = (msg_comm.DiscussInfo)((msg_comm.MsgHead)localObject1).discuss_info.get();
    long l1 = ((msg_comm.MsgHead)localObject1).from_uin.get();
    long l4 = ((msg_comm.MsgHead)localObject1).to_uin.get();
    long l5 = ((msg_comm.MsgHead)localObject1).msg_seq.get();
    int m = ((msg_comm.MsgHead)localObject1).msg_time.get();
    long l6 = ((msg_comm.MsgHead)localObject1).msg_uid.get();
    int n = ((msg_comm.MsgHead)localObject1).user_active.get();
    int i1 = ((msg_comm.MsgHead)localObject1).from_instid.get();
    long l2 = ((msg_comm.DiscussInfo)localObject2).discuss_uin.get();
    int i2 = ((msg_comm.DiscussInfo)localObject2).discuss_type.get();
    long l7 = ((msg_comm.DiscussInfo)localObject2).discuss_info_seq.get();
    if (paramFromServiceMsg.getUin() == null) {
      localObject1 = this.jdField_a_of_type_ComTencentCommonAppAppInterface.getCurrentAccountUin();
    } else {
      localObject1 = paramFromServiceMsg.getUin();
    }
    long l3 = Long.valueOf((String)localObject1).longValue();
    if ((((msg_comm.DiscussInfo)localObject2).discuss_remark.has()) && (((msg_comm.DiscussInfo)localObject2).discuss_remark.get() != null)) {
      localObject1 = ((msg_comm.DiscussInfo)localObject2).discuss_remark.get().toByteArray();
    } else {
      localObject1 = null;
    }
    boolean bool = paramMsg.content_head.has();
    int j = 0;
    int i;
    int k;
    if (bool)
    {
      localObject2 = (msg_comm.ContentHead)paramMsg.content_head.get();
      j = ((msg_comm.ContentHead)localObject2).div_seq.get();
      i = ((msg_comm.ContentHead)localObject2).pkg_index.get();
      k = ((msg_comm.ContentHead)localObject2).pkg_num.get();
    }
    else
    {
      k = 0;
      i = 0;
    }
    ((QQAppInterface)this.jdField_a_of_type_ComTencentCommonAppAppInterface).userActiveStatus = n;
    int i3 = paramFromServiceMsg.getRequestSsoSeq();
    if (!((QQAppInterface)this.jdField_a_of_type_ComTencentCommonAppAppInterface).mAutomator.a())
    {
      this.jdField_a_of_type_ComTencentMobileqqAppBaseMessageHandler.b(l3, paramPbPushMsg.svrip.get(), i3);
      return;
    }
    if (a(paramMsg, paramFromServiceMsg, paramPbPushMsg, l2, l3, i3)) {
      return;
    }
    if (QLog.isColorLevel())
    {
      paramFromServiceMsg = new StringBuilder("<---handleMsgPush_PB_Dis ");
      paramFromServiceMsg.append(" fromUin:");
      paramFromServiceMsg.append(l1);
      paramFromServiceMsg.append(" toUin");
      paramFromServiceMsg.append(l4);
      paramFromServiceMsg.append(" msgTime:");
      paramFromServiceMsg.append(m);
      paramFromServiceMsg.append(" msgSeq:");
      paramFromServiceMsg.append(l5);
      paramFromServiceMsg.append(" msgUid:");
      paramFromServiceMsg.append(l6);
      paramFromServiceMsg.append(" userActive:");
      paramFromServiceMsg.append(n);
      paramFromServiceMsg.append(" fromInstid:");
      paramFromServiceMsg.append(i1);
      paramFromServiceMsg.append(" disUin:");
      paramFromServiceMsg.append(l2);
      paramFromServiceMsg.append(" disType:");
      paramFromServiceMsg.append(i2);
      paramFromServiceMsg.append(" disSeq:");
      paramFromServiceMsg.append(l7);
      paramFromServiceMsg.append(" remarkSender:");
      paramFromServiceMsg.append(HexUtil.bytes2HexStr((byte[])localObject1));
      paramFromServiceMsg.append(" divSeq:");
      paramFromServiceMsg.append(j);
      paramFromServiceMsg.append(" pkgIndex:");
      paramFromServiceMsg.append(i);
      paramFromServiceMsg.append(" pkgNum:");
      paramFromServiceMsg.append(k);
      paramFromServiceMsg.append(" hasShare:");
      paramFromServiceMsg.append(paramMsg.appshare_info.has());
      QLog.d("Q.msg.DiscMsgPc", 2, paramFromServiceMsg.toString());
    }
    ((DiscussionHandler)this.jdField_a_of_type_ComTencentCommonAppAppInterface.getBusinessHandler(BusinessHandlerFactory.DISCUSSION_HANDLER)).a(l2, l1);
    ((FriendsManager)this.jdField_a_of_type_ComTencentCommonAppAppInterface.getManager(QQManagerFactory.FRIENDS_MANAGER)).a(l1);
    paramFromServiceMsg = (DiscussionManager)this.jdField_a_of_type_ComTencentCommonAppAppInterface.getManager(QQManagerFactory.DISCUSSION_MANAGER);
    localObject2 = new PBDecodeContext();
    ((PBDecodeContext)localObject2).jdField_g_of_type_Long = l2;
    ((PBDecodeContext)localObject2).f = 3000;
    ((PBDecodeContext)localObject2).jdField_g_of_type_Int = i2;
    paramMsg = a(paramMsg, (PBDecodeContext)localObject2);
    HashSet localHashSet = new HashSet();
    ArrayList localArrayList = new ArrayList();
    localObject2 = new ArrayList();
    a((byte[])localObject1, paramFromServiceMsg, paramMsg, localHashSet, localArrayList, (ArrayList)localObject2);
    if (localArrayList.size() > 0) {
      paramFromServiceMsg.b(localArrayList);
    }
    paramFromServiceMsg = new ArrayList();
    if (((ArrayList)localObject2).size() > 0) {
      paramFromServiceMsg.addAll((Collection)localObject2);
    }
    b(l2, l3, (ArrayList)localObject2, paramFromServiceMsg);
    if (paramBoolean) {
      this.jdField_a_of_type_ComTencentMobileqqAppBaseMessageHandler.b(l3, paramPbPushMsg.svrip.get(), i3);
    }
    PreDownloadMsg.a(paramFromServiceMsg, true, this.jdField_a_of_type_ComTencentCommonAppAppInterface);
    ((VasExtensionManager)this.jdField_a_of_type_ComTencentCommonAppAppInterface.getManager(QQManagerFactory.VAS_EXTENSION_MANAGER)).a.a(paramMsg);
  }
  
  private void a(byte[] paramArrayOfByte, int paramInt)
  {
    PkgTools.getLongData(paramArrayOfByte, paramInt);
    paramInt += 4;
    PkgTools.getLongData(paramArrayOfByte, paramInt);
    paramInt = paramArrayOfByte[(paramInt + 4)];
  }
  
  private void a(byte[] paramArrayOfByte, int paramInt, long paramLong, DiscussionManager paramDiscussionManager)
  {
    int i = (int)PkgTools.getLongData(paramArrayOfByte, paramInt);
    byte[] arrayOfByte = new byte[i];
    PkgTools.getBytesData(paramArrayOfByte, paramInt + 4, arrayOfByte, i);
    paramArrayOfByte = new sysmsg_0x20c_0x20.SysMsgBody();
    try
    {
      paramArrayOfByte.mergeFrom(arrayOfByte);
      if (!paramArrayOfByte.u32_cmd.has()) {
        break label82;
      }
      a(paramLong, paramDiscussionManager, paramArrayOfByte, paramArrayOfByte.u32_cmd.get());
      return;
    }
    catch (Exception paramArrayOfByte)
    {
      label66:
      break label66;
    }
    if (QLog.isColorLevel()) {
      QLog.d("Q.msg.DiscMsgPc", 2, "0x20: Parsing data failed!");
    }
    label82:
  }
  
  private void a(byte[] paramArrayOfByte, int paramInt1, List<String> paramList, int paramInt2, HashSet<String> paramHashSet)
  {
    int j = 0;
    int i = paramInt1;
    paramInt1 = j;
    while (paramInt1 < paramInt2)
    {
      long l = PkgTools.getLongData(paramArrayOfByte, i);
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("handleDiscussionMemchangeMsg MSG_DISCUSSION_TYPE_KICKOUT_MEMBER uin=");
        localStringBuilder.append(l);
        QLog.d("Q.msg.DiscMsgPc.discuss", 2, localStringBuilder.toString());
      }
      i += 4;
      paramHashSet.add(String.valueOf(l));
      paramList.add(String.valueOf(l));
      paramInt1 += 1;
    }
  }
  
  private void a(byte[] paramArrayOfByte, DiscussionManager paramDiscussionManager, HashSet<String> paramHashSet, ArrayList<DiscussionMemberInfo> paramArrayList, int paramInt, MessageRecord paramMessageRecord)
  {
    if ((paramInt == 0) && (paramArrayOfByte != null) && (paramArrayOfByte.length > 0))
    {
      String str = paramMessageRecord.senderuin;
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append(HexUtil.bytes2HexStr(paramArrayOfByte));
      ((StringBuilder)localObject).append(":");
      ((StringBuilder)localObject).append(str);
      localObject = ((StringBuilder)localObject).toString();
      if (!paramHashSet.contains(localObject))
      {
        paramArrayOfByte = paramDiscussionManager.a(paramArrayOfByte, paramMessageRecord.frienduin, str, false);
        if (paramArrayOfByte != null)
        {
          paramArrayList.add(paramArrayOfByte);
          paramHashSet.add(localObject);
        }
      }
    }
  }
  
  private void a(byte[] paramArrayOfByte, DiscussionManager paramDiscussionManager, List<MessageRecord> paramList, HashSet<String> paramHashSet, ArrayList<DiscussionMemberInfo> paramArrayList, ArrayList<MessageRecord> paramArrayList1)
  {
    if ((paramList != null) && (paramList.size() > 0))
    {
      BaseMessageHandlerUtils.a(paramList);
      int j = paramList.size();
      int i = 0;
      while (i < j)
      {
        MessageRecord localMessageRecord = (MessageRecord)paramList.get(i);
        if (QLog.isColorLevel())
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("----------handleMsgPush_PB_Dis after analysis  mr.senderuin: ");
          localStringBuilder.append(localMessageRecord.senderuin);
          localStringBuilder.append(" mr.msgtype: ");
          localStringBuilder.append(localMessageRecord.msgtype);
          localStringBuilder.append(" mr.frienduin: ");
          localStringBuilder.append(localMessageRecord.frienduin);
          localStringBuilder.append(" mr.shmsgseq: ");
          localStringBuilder.append(localMessageRecord.shmsgseq);
          localStringBuilder.append(" mr.time:");
          localStringBuilder.append(localMessageRecord.time);
          localStringBuilder.append(" mr.msg: ");
          localStringBuilder.append(localMessageRecord.getLogColorContent());
          QLog.d("Q.msg.DiscMsgPc", 2, localStringBuilder.toString());
        }
        if (!a(localMessageRecord))
        {
          if ((localMessageRecord instanceof MessageForMarketFace)) {
            CommercialDrainageManagerConstants.a(this.jdField_a_of_type_ComTencentCommonAppAppInterface, (MessageForMarketFace)localMessageRecord);
          }
          paramArrayList1.add(localMessageRecord);
          a(paramArrayOfByte, paramDiscussionManager, paramHashSet, paramArrayList, i, localMessageRecord);
        }
        i += 1;
      }
    }
  }
  
  private boolean a(long paramLong1, long paramLong2, short paramShort)
  {
    try
    {
      Object localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append(paramLong1);
      ((StringBuilder)localObject1).append("|");
      ((StringBuilder)localObject1).append(paramLong2);
      ((StringBuilder)localObject1).append("|");
      ((StringBuilder)localObject1).append(paramShort);
      localObject1 = ((StringBuilder)localObject1).toString();
      if (((MessageCache)this.jdField_a_of_type_ComTencentCommonAppAppInterface.getMsgCache()).a().contains(localObject1))
      {
        if (QLog.isColorLevel())
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("memberChangeMsgFilter key: ");
          localStringBuilder.append((String)localObject1);
          QLog.w("Q.msg.DiscMsgPc", 2, localStringBuilder.toString());
        }
        return true;
      }
      ((MessageCache)this.jdField_a_of_type_ComTencentCommonAppAppInterface.getMsgCache()).a((String)localObject1);
      return false;
    }
    finally {}
  }
  
  private boolean a(MsgInfo paramMsgInfo, long paramLong1, byte[] paramArrayOfByte, long paramLong2, int paramInt, byte paramByte, long paramLong3, List<String> paramList, DiscussionHandler paramDiscussionHandler, DiscussionManager paramDiscussionManager)
  {
    long l = PkgTools.getLongData(paramArrayOfByte, paramInt);
    if (QLog.isColorLevel())
    {
      paramArrayOfByte = new StringBuilder();
      paramArrayOfByte.append("handleDiscussionMemchangeMsg discussionUin: ");
      paramArrayOfByte.append(paramLong3);
      paramArrayOfByte.append(" memberUin: ");
      paramArrayOfByte.append(l);
      QLog.d("Q.msg.DiscMsgPc.discuss", 2, paramArrayOfByte.toString());
    }
    String str = String.valueOf(l);
    if (a(l, paramLong3, paramMsgInfo.shMsgSeq)) {
      return true;
    }
    paramArrayOfByte = a(paramMsgInfo);
    if ((TextUtils.isEmpty(paramArrayOfByte)) || (ContactUtils.a((QQAppInterface)this.jdField_a_of_type_ComTencentCommonAppAppInterface, String.valueOf(paramLong3))))
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.msg.DiscMsgPc.discuss", 2, "coptype 2 server memberName empty");
      }
      paramArrayOfByte = ContactUtils.a((QQAppInterface)this.jdField_a_of_type_ComTencentCommonAppAppInterface, String.valueOf(paramLong3), str);
    }
    paramArrayOfByte = this.jdField_a_of_type_ComTencentCommonAppAppInterface.getApp().getString(2131691801, new Object[] { paramArrayOfByte });
    paramList.add(str);
    paramDiscussionHandler.a(paramLong3, str, paramList, 10009);
    if (str.equals(this.jdField_a_of_type_ComTencentCommonAppAppInterface.getCurrentAccountUin()))
    {
      paramDiscussionManager.a(String.valueOf(paramLong3), String.valueOf(l));
      a(paramByte, paramLong3, l);
      paramDiscussionHandler.a(String.valueOf(paramLong3));
      return true;
    }
    paramDiscussionHandler.a(paramLong3);
    paramDiscussionManager.a(String.valueOf(paramLong3), String.valueOf(l));
    a(paramMsgInfo, paramLong1, paramLong2, paramLong2, paramArrayOfByte);
    return false;
  }
  
  private boolean a(MsgInfo paramMsgInfo, byte[] paramArrayOfByte, int paramInt, long paramLong, DiscussionHandler paramDiscussionHandler, FriendsManager paramFriendsManager, DiscussionManager paramDiscussionManager)
  {
    long l1 = PkgTools.getLongData(paramArrayOfByte, paramInt);
    long l2 = PkgTools.getLongData(paramArrayOfByte, paramInt + 4);
    paramArrayOfByte = new StringBuilder();
    paramArrayOfByte.append(String.valueOf(paramLong));
    paramArrayOfByte.append("_");
    paramArrayOfByte.append(String.valueOf(l1));
    paramArrayOfByte.toString();
    a(paramMsgInfo);
    if ((paramMsgInfo.vNickName != null) && (paramMsgInfo.vNickName.size() > 1)) {
      paramArrayOfByte = (String)paramMsgInfo.vNickName.get(1);
    }
    if (QLog.isColorLevel())
    {
      paramArrayOfByte = new StringBuilder();
      paramArrayOfByte.append("handleDiscussionMemchangeMsg discussionUin: ");
      paramArrayOfByte.append(paramLong);
      paramArrayOfByte.append(" memberUin: ");
      paramArrayOfByte.append(l2);
      QLog.d("Q.msg.DiscMsgPc.discuss", 2, paramArrayOfByte.toString());
    }
    if (a(l2, paramLong, paramMsgInfo.shMsgSeq))
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.msg.DiscMsgPc.discuss", 2, "handleDiscussionMemchangeMsg memberChangeMsgFilter return");
      }
      return true;
    }
    paramDiscussionHandler.a(paramLong);
    paramMsgInfo = new StringBuilder();
    paramMsgInfo.append(paramLong);
    paramMsgInfo.append("");
    paramInt = paramDiscussionManager.a(paramMsgInfo.toString());
    if (!paramDiscussionManager.a(String.valueOf(paramLong), String.valueOf(l2)))
    {
      if (QLog.isColorLevel())
      {
        paramMsgInfo = new StringBuilder();
        paramMsgInfo.append("handleDiscussionUpdateMsg add discussion ");
        paramMsgInfo.append(paramLong);
        paramMsgInfo.append(" member number by 1 ");
        paramMsgInfo.append(l2);
        paramMsgInfo.append(" num: ");
        paramMsgInfo.append(paramInt);
        QLog.d("Q.msg.DiscMsgPc.discuss", 2, paramMsgInfo.toString());
      }
      paramMsgInfo = new DiscussionMemberInfo();
      paramMsgInfo.discussionUin = String.valueOf(paramLong);
      paramMsgInfo.memberUin = String.valueOf(l2);
      paramMsgInfo.flag = 0;
      paramArrayOfByte = paramFriendsManager.e(String.valueOf(l2));
      if ((paramArrayOfByte != null) && (paramArrayOfByte.name != null)) {
        paramMsgInfo.memberName = paramArrayOfByte.name;
      }
      paramDiscussionManager.a(paramMsgInfo);
      if (QLog.isColorLevel())
      {
        paramMsgInfo = new StringBuilder();
        paramMsgInfo.append("handleDiscussionMemchangeMsg setDiscussionMemberNum memnum");
        paramMsgInfo.append(paramInt);
        QLog.d("Q.msg.DiscMsgPc.discuss", 2, paramMsgInfo.toString());
      }
    }
    return false;
  }
  
  private boolean a(MessageRecord paramMessageRecord)
  {
    if ((paramMessageRecord.senderuin != null) && (paramMessageRecord.senderuin.equalsIgnoreCase(this.jdField_a_of_type_ComTencentCommonAppAppInterface.getCurrentAccountUin())))
    {
      MessageRecord localMessageRecord = ((IMessageFacade)this.jdField_a_of_type_ComTencentCommonAppAppInterface.getRuntimeService(IMessageFacade.class, "")).getSendingTroopMsgItem(paramMessageRecord.frienduin, 3000, paramMessageRecord);
      if (localMessageRecord != null)
      {
        if (((paramMessageRecord instanceof MessageForText)) && ((localMessageRecord instanceof MessageForText)) && (paramMessageRecord.getRepeatCount() > 0))
        {
          localMessageRecord.setRepeatCount(paramMessageRecord.getRepeatCount());
          if (QLog.isColorLevel())
          {
            StringBuilder localStringBuilder = new StringBuilder();
            localStringBuilder.append("<---handleMsgPush_PB_Dis ===> update findMr.repeatCount=");
            localStringBuilder.append(localMessageRecord.getRepeatCount());
            QLog.d("Q.msg.DiscMsgPc", 2, localStringBuilder.toString());
          }
        }
        this.jdField_a_of_type_ComTencentMobileqqAppBaseMessageHandler.a(paramMessageRecord.frienduin, 3000, localMessageRecord.uniseq, paramMessageRecord.shmsgseq, paramMessageRecord.time);
        this.jdField_a_of_type_ComTencentMobileqqAppBaseMessageHandler.a(paramMessageRecord, localMessageRecord);
        TianShuManager.getInstance().cacheTraceInfo(localMessageRecord.getExtInfoFromExtStr("report_key_bytes_oac_msg_extend"));
        a(localMessageRecord);
        ((MessageCache)this.jdField_a_of_type_ComTencentCommonAppAppInterface.getMsgCache()).h(paramMessageRecord.frienduin, paramMessageRecord.shmsgseq);
        ForwardOrderManager.a().a((QQAppInterface)this.jdField_a_of_type_ComTencentCommonAppAppInterface, localMessageRecord.uniseq);
        return true;
      }
      paramMessageRecord.isread = true;
      paramMessageRecord.issend = 2;
      this.jdField_a_of_type_ComTencentMobileqqMsgApiIMessageFacade.setReadFrom(paramMessageRecord.frienduin, 3000, paramMessageRecord.shmsgseq);
    }
    return false;
  }
  
  private boolean a(String paramString, MessageRecord paramMessageRecord)
  {
    if ((paramMessageRecord.senderuin != null) && (paramMessageRecord.senderuin.equalsIgnoreCase(this.jdField_a_of_type_ComTencentCommonAppAppInterface.getCurrentAccountUin())))
    {
      MessageRecord localMessageRecord = ((IMessageFacade)this.jdField_a_of_type_ComTencentCommonAppAppInterface.getRuntimeService(IMessageFacade.class, "")).getSendingTroopMsgItem(paramMessageRecord.frienduin, 3000, paramMessageRecord);
      if (localMessageRecord != null)
      {
        if (((paramMessageRecord instanceof MessageForText)) && ((localMessageRecord instanceof MessageForText)) && (paramMessageRecord.getRepeatCount() > 0))
        {
          localMessageRecord.setRepeatCount(paramMessageRecord.getRepeatCount());
          if (QLog.isColorLevel())
          {
            StringBuilder localStringBuilder = new StringBuilder();
            localStringBuilder.append("<---initGetPullDiscussionMsg_PB ===> update findMr.repeatCount=");
            localStringBuilder.append(paramMessageRecord.getRepeatCount());
            QLog.d("Q.msg.DiscMsgPc", 2, localStringBuilder.toString());
          }
        }
        if (!((MessageCache)this.jdField_a_of_type_ComTencentCommonAppAppInterface.getMsgCache()).d()) {
          ((MessageCache)this.jdField_a_of_type_ComTencentCommonAppAppInterface.getMsgCache()).a(localMessageRecord.frienduin, localMessageRecord.istroop, localMessageRecord.uniseq);
        }
        this.jdField_a_of_type_ComTencentMobileqqAppBaseMessageHandler.a(paramMessageRecord.frienduin, 3000, localMessageRecord.uniseq, paramMessageRecord.shmsgseq, paramMessageRecord.time);
        ((MessageCache)this.jdField_a_of_type_ComTencentCommonAppAppInterface.getMsgCache()).h(paramString, paramMessageRecord.shmsgseq);
        return true;
      }
    }
    return false;
  }
  
  private boolean a(msg_comm.Msg paramMsg, FromServiceMsg paramFromServiceMsg, msg_onlinepush.PbPushMsg paramPbPushMsg, long paramLong1, long paramLong2, int paramInt)
  {
    if (!RegisterProxyHandler.a)
    {
      if (((MessageCache)this.jdField_a_of_type_ComTencentCommonAppAppInterface.getMsgCache()).b(String.valueOf(paramLong1)) != 2)
      {
        ((MessageCache)this.jdField_a_of_type_ComTencentCommonAppAppInterface.getMsgCache()).d(String.valueOf(paramLong1), new Object[] { paramMsg, paramFromServiceMsg, paramPbPushMsg });
        if (QLog.isColorLevel())
        {
          paramMsg = new StringBuilder();
          paramMsg.append("handleMsgPush_PB_Dis unfinished discussionUin=");
          paramMsg.append(paramLong1);
          QLog.d("Q.msg.DiscMsgPc", 2, paramMsg.toString());
        }
        this.jdField_a_of_type_ComTencentMobileqqAppBaseMessageHandler.b(paramLong2, paramPbPushMsg.svrip.get(), paramInt);
        return true;
      }
    }
    else if (!((QQAppInterface)this.jdField_a_of_type_ComTencentCommonAppAppInterface).mAutomator.d())
    {
      ((MessageCache)this.jdField_a_of_type_ComTencentCommonAppAppInterface.getMsgCache()).d(String.valueOf(paramLong1), new Object[] { paramMsg, paramFromServiceMsg, paramPbPushMsg });
      this.jdField_a_of_type_ComTencentMobileqqAppBaseMessageHandler.b(paramLong2, paramPbPushMsg.svrip.get(), paramInt);
      return true;
    }
    return false;
  }
  
  private void b(long paramLong1, long paramLong2, ArrayList<MessageRecord> paramArrayList1, ArrayList<MessageRecord> paramArrayList2)
  {
    if (paramArrayList2.size() > 0)
    {
      ((MessageCache)this.jdField_a_of_type_ComTencentCommonAppAppInterface.getMsgCache()).b(paramArrayList1);
      boolean bool2 = MessageHandlerUtils.a(paramArrayList2);
      int i = MsgProxyUtils.a(paramArrayList2, (MessageCache)this.jdField_a_of_type_ComTencentCommonAppAppInterface.getMsgCache());
      paramArrayList1 = (IMessageFacade)this.jdField_a_of_type_ComTencentCommonAppAppInterface.getRuntimeService(IMessageFacade.class, "");
      boolean bool1;
      if ((bool2) && (this.jdField_a_of_type_ComTencentCommonAppAppInterface.isBackgroundStop)) {
        bool1 = true;
      } else {
        bool1 = false;
      }
      paramArrayList1.addMessage(paramArrayList2, String.valueOf(paramLong2), bool1);
      HashMap localHashMap = new HashMap();
      paramArrayList2 = paramArrayList2.iterator();
      while (paramArrayList2.hasNext())
      {
        paramArrayList1 = (MessageRecord)paramArrayList2.next();
        if (paramArrayList1.istroop == 3000) {
          if (localHashMap.containsKey(paramArrayList1.frienduin))
          {
            String str = paramArrayList1.frienduin;
            if (paramArrayList1.shmsgseq > ((Long)localHashMap.get(paramArrayList1.frienduin)).longValue()) {
              paramArrayList1 = Long.valueOf(paramArrayList1.shmsgseq);
            } else {
              paramArrayList1 = (Long)localHashMap.get(paramArrayList1.frienduin);
            }
            localHashMap.put(str, paramArrayList1);
          }
          else
          {
            localHashMap.put(paramArrayList1.frienduin, Long.valueOf(Math.max(paramArrayList1.shmsgseq, ((MessageCache)this.jdField_a_of_type_ComTencentCommonAppAppInterface.getMsgCache()).h(paramArrayList1.frienduin))));
          }
        }
      }
      paramArrayList1 = localHashMap.keySet().iterator();
      while (paramArrayList1.hasNext())
      {
        paramArrayList2 = (String)paramArrayList1.next();
        ((MessageCache)this.jdField_a_of_type_ComTencentCommonAppAppInterface.getMsgCache()).h(paramArrayList2, ((Long)localHashMap.get(paramArrayList2)).longValue());
      }
      if ((this.jdField_a_of_type_ComTencentMobileqqAppBaseMessageHandler.a(bool2)) && (!DiscussionManager.a((QQAppInterface)this.jdField_a_of_type_ComTencentCommonAppAppInterface, Long.toString(paramLong1), 3000))) {
        bool1 = true;
      } else {
        bool1 = false;
      }
      a("handleMsgPush_PB_Dis", true, i, bool1, false);
    }
  }
  
  private void b(Pair<Long, String> paramPair, MsgInfo paramMsgInfo, ArrayList<Pair<String, String>> paramArrayList, long paramLong, String paramString, byte paramByte, boolean paramBoolean)
  {
    a(paramPair, paramMsgInfo, paramArrayList, paramLong, paramString, paramByte, 0L, paramBoolean);
  }
  
  public static void b(QQAppInterface paramQQAppInterface, byte[] paramArrayOfByte, int paramInt, MessageRecord paramMessageRecord, boolean paramBoolean)
  {
    int i = paramArrayOfByte.length - paramInt;
    paramMessageRecord = new byte[i];
    PkgTools.getBytesData(paramArrayOfByte, paramInt, paramMessageRecord, i);
    paramArrayOfByte = new oidb_0x858.NotifyMsgBody();
    try
    {
      paramArrayOfByte.mergeFrom(paramMessageRecord);
      paramInt = paramArrayOfByte.opt_enum_type.get();
      paramArrayOfByte.opt_uint64_conf_uin.get();
      if (paramInt == 11)
      {
        if (QLog.isColorLevel()) {
          QLog.d("ApolloGameManager", 2, "apollo game status push, [Discussion].");
        }
      }
      else if (paramInt == 12)
      {
        if (QLog.isColorLevel()) {
          QLog.d("ApolloPushManager", 2, "recv action push message, [Discussion].");
        }
        if (paramArrayOfByte.apllo_msg_push.has())
        {
          paramArrayOfByte = (apollo_push_msgInfo.STPushMsgElem)paramArrayOfByte.apllo_msg_push.get();
          if (paramQQAppInterface != null) {
            ((IApolloPushManager)paramQQAppInterface.getRuntimeService(IApolloPushManager.class, "all")).onRecvActionPush(3000, paramArrayOfByte);
          }
        }
      }
      else if (paramInt == 13)
      {
        if (QLog.isColorLevel()) {
          QLog.d("Q.msg.DiscMsgPc", 2, "goldmsg push, [Discussion].");
        }
        if (paramArrayOfByte.opt_msg_goldtips.has())
        {
          paramQQAppInterface = (oidb_0x858.GoldMsgTipsElem)paramArrayOfByte.opt_msg_goldtips.get();
          if ((paramQQAppInterface.type.has()) && (paramQQAppInterface.type.get() == 3))
          {
            ((INotifyMsgApi)QRoute.api(INotifyMsgApi.class)).onReceiveAAPaySysNotify(3000, null, paramArrayOfByte.opt_msg_goldtips.get());
            return;
          }
        }
      }
    }
    catch (Exception paramQQAppInterface)
    {
      paramQQAppInterface.printStackTrace();
      paramArrayOfByte = new StringBuilder();
      paramArrayOfByte.append("parse0x20c_subType0x23 Exception ");
      paramArrayOfByte.append(paramQQAppInterface.getStackTrace());
      QLog.e("Q.msg.DiscMsgPc", 1, paramArrayOfByte.toString());
    }
  }
  
  private void b(ArrayList<MessageRecord> paramArrayList)
  {
    DiscussionHandler localDiscussionHandler = (DiscussionHandler)this.jdField_a_of_type_ComTencentCommonAppAppInterface.getBusinessHandler(BusinessHandlerFactory.DISCUSSION_HANDLER);
    paramArrayList = paramArrayList.iterator();
    while (paramArrayList.hasNext())
    {
      MessageRecord localMessageRecord = (MessageRecord)paramArrayList.next();
      if ((localMessageRecord.senderuin != null) && (localMessageRecord.senderuin.equals(this.jdField_a_of_type_ComTencentCommonAppAppInterface.getCurrentAccountUin())))
      {
        localMessageRecord.isread = true;
        localMessageRecord.issend = 2;
      }
      try
      {
        localDiscussionHandler.a(Long.parseLong(localMessageRecord.frienduin), Long.parseLong(localMessageRecord.senderuin));
      }
      catch (Exception localException)
      {
        label93:
        StringBuilder localStringBuilder;
        break label93;
      }
      if (QLog.isColorLevel())
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("processOffline exception when checkAndGetDiscussionMemberExist ");
        localStringBuilder.append(localMessageRecord.frienduin);
        localStringBuilder.append(":");
        localStringBuilder.append(localMessageRecord.senderuin);
        QLog.e("Q.msg.DiscMsgPc", 2, localStringBuilder.toString());
      }
    }
  }
  
  /* Error */
  public static void c(QQAppInterface paramQQAppInterface, byte[] paramArrayOfByte, int paramInt, MessageRecord paramMessageRecord, boolean paramBoolean)
  {
    // Byte code:
    //   0: aload_1
    //   1: arraylength
    //   2: iload_2
    //   3: isub
    //   4: istore 5
    //   6: iload 5
    //   8: newarray byte
    //   10: astore_3
    //   11: aload_1
    //   12: iload_2
    //   13: aload_3
    //   14: iload 5
    //   16: invokestatic 231	com/tencent/mobileqq/utils/httputils/PkgTools:getBytesData	([BI[BI)V
    //   19: new 233	tencent/im/oidb/cmd0x858/oidb_0x858$NotifyMsgBody
    //   22: dup
    //   23: invokespecial 234	tencent/im/oidb/cmd0x858/oidb_0x858$NotifyMsgBody:<init>	()V
    //   26: astore_1
    //   27: aload_1
    //   28: aload_3
    //   29: invokevirtual 245	tencent/im/oidb/cmd0x858/oidb_0x858$NotifyMsgBody:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   32: pop
    //   33: aload_1
    //   34: getfield 966	tencent/im/oidb/cmd0x858/oidb_0x858$NotifyMsgBody:opt_enum_type	Lcom/tencent/mobileqq/pb/PBEnumField;
    //   37: invokevirtual 969	com/tencent/mobileqq/pb/PBEnumField:get	()I
    //   40: istore_2
    //   41: aload_1
    //   42: getfield 972	tencent/im/oidb/cmd0x858/oidb_0x858$NotifyMsgBody:opt_uint64_conf_uin	Lcom/tencent/mobileqq/pb/PBUInt64Field;
    //   45: invokevirtual 264	com/tencent/mobileqq/pb/PBUInt64Field:get	()J
    //   48: pop2
    //   49: iload_2
    //   50: bipush 9
    //   52: if_icmpne +138 -> 190
    //   55: aload_1
    //   56: getfield 1850	tencent/im/oidb/cmd0x858/oidb_0x858$NotifyMsgBody:opt_msg_obj_update	Ltencent/im/oidb/cmd0x858/oidb_0x858$NotifyObjmsgUpdate;
    //   59: invokevirtual 1853	tencent/im/oidb/cmd0x858/oidb_0x858$NotifyObjmsgUpdate:has	()Z
    //   62: ifeq +128 -> 190
    //   65: aload_1
    //   66: getfield 1850	tencent/im/oidb/cmd0x858/oidb_0x858$NotifyMsgBody:opt_msg_obj_update	Ltencent/im/oidb/cmd0x858/oidb_0x858$NotifyObjmsgUpdate;
    //   69: invokevirtual 1854	tencent/im/oidb/cmd0x858/oidb_0x858$NotifyObjmsgUpdate:get	()Lcom/tencent/mobileqq/pb/MessageMicro;
    //   72: checkcast 1852	tencent/im/oidb/cmd0x858/oidb_0x858$NotifyObjmsgUpdate
    //   75: astore_3
    //   76: aload_3
    //   77: getfield 1857	tencent/im/oidb/cmd0x858/oidb_0x858$NotifyObjmsgUpdate:bytes_ext_msg	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   80: invokevirtual 1381	com/tencent/mobileqq/pb/PBBytesField:has	()Z
    //   83: ifeq +107 -> 190
    //   86: new 1859	tencent/im/s2c/msgtype0x210/submsgtype0xaa/SubMsgType0xaa$MsgBody
    //   89: dup
    //   90: invokespecial 1860	tencent/im/s2c/msgtype0x210/submsgtype0xaa/SubMsgType0xaa$MsgBody:<init>	()V
    //   93: astore_1
    //   94: aload_1
    //   95: aload_3
    //   96: getfield 1857	tencent/im/oidb/cmd0x858/oidb_0x858$NotifyObjmsgUpdate:bytes_ext_msg	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   99: invokevirtual 282	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   102: invokevirtual 998	com/tencent/mobileqq/pb/ByteStringMicro:toByteArray	()[B
    //   105: invokevirtual 1861	tencent/im/s2c/msgtype0x210/submsgtype0xaa/SubMsgType0xaa$MsgBody:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   108: pop
    //   109: goto +18 -> 127
    //   112: invokestatic 81	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   115: ifeq +12 -> 127
    //   118: ldc 126
    //   120: iconst_2
    //   121: ldc_w 1863
    //   124: invokestatic 108	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   127: aload_0
    //   128: getstatic 1866	com/tencent/mobileqq/app/QQManagerFactory:GAME_PARTY_MANAGER	I
    //   131: invokevirtual 1867	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   134: checkcast 1869	com/tencent/mobileqq/gameparty/GamePartyManager
    //   137: aload_1
    //   138: iconst_0
    //   139: invokevirtual 1872	com/tencent/mobileqq/gameparty/GamePartyManager:a	(Ltencent/im/s2c/msgtype0x210/submsgtype0xaa/SubMsgType0xaa$MsgBody;Z)V
    //   142: return
    //   143: astore_0
    //   144: aload_0
    //   145: invokevirtual 377	java/lang/Exception:printStackTrace	()V
    //   148: invokestatic 81	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   151: ifeq +39 -> 190
    //   154: new 83	java/lang/StringBuilder
    //   157: dup
    //   158: invokespecial 84	java/lang/StringBuilder:<init>	()V
    //   161: astore_1
    //   162: aload_1
    //   163: ldc_w 1874
    //   166: invokevirtual 90	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   169: pop
    //   170: aload_1
    //   171: aload_0
    //   172: invokevirtual 1081	java/lang/Exception:getStackTrace	()[Ljava/lang/StackTraceElement;
    //   175: invokevirtual 867	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   178: pop
    //   179: ldc_w 509
    //   182: iconst_2
    //   183: aload_1
    //   184: invokevirtual 104	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   187: invokestatic 1084	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   190: return
    //   191: astore_3
    //   192: goto -80 -> 112
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	195	0	paramQQAppInterface	QQAppInterface
    //   0	195	1	paramArrayOfByte	byte[]
    //   0	195	2	paramInt	int
    //   0	195	3	paramMessageRecord	MessageRecord
    //   0	195	4	paramBoolean	boolean
    //   4	11	5	i	int
    // Exception table:
    //   from	to	target	type
    //   27	49	143	java/lang/Exception
    //   55	94	143	java/lang/Exception
    //   112	127	143	java/lang/Exception
    //   127	142	143	java/lang/Exception
    //   94	109	191	java/lang/Exception
  }
  
  public OnLinePushParamReturnMsg a(int paramInt, MsgInfo paramMsgInfo, SvcReqPushMsg paramSvcReqPushMsg)
  {
    if (paramInt == 9010)
    {
      if ((paramMsgInfo != null) && (paramSvcReqPushMsg != null)) {
        return new OnLinePushParamReturnMsg(a(paramMsgInfo, paramSvcReqPushMsg), false);
      }
      a(getClass().getName(), paramInt);
    }
    return null;
  }
  
  public List<MessageRecord> a(msg_comm.Msg paramMsg, PBDecodeContext paramPBDecodeContext)
  {
    ArrayList localArrayList1 = new ArrayList();
    ArrayList localArrayList2 = new ArrayList();
    MessageInfo localMessageInfo = new MessageInfo();
    try
    {
      a(paramMsg, localArrayList1, paramPBDecodeContext, true, localMessageInfo);
      long l = paramMsg.msg_head.discuss_info.discuss_uin.get();
      paramMsg = (TroopInfoManager)this.jdField_a_of_type_ComTencentCommonAppAppInterface.getManager(QQManagerFactory.TROOPINFO_MANAGER);
      paramPBDecodeContext = new StringBuilder();
      paramPBDecodeContext.append(String.valueOf(l));
      paramPBDecodeContext.append("&");
      paramPBDecodeContext.append(3000);
      paramMsg.a(paramPBDecodeContext.toString(), localMessageInfo);
    }
    catch (Exception paramMsg)
    {
      if (QLog.isColorLevel()) {
        QLog.e("Q.msg.DiscMsgPc", 2, "decodeSinglePbMsg_GroupDis error,", paramMsg);
      }
    }
    a(localArrayList1, localArrayList2, true);
    return localArrayList2;
  }
  
  public void a()
  {
    Handler localHandler = this.jdField_a_of_type_AndroidOsHandler;
    if (localHandler != null) {
      localHandler.removeCallbacksAndMessages(null);
    }
  }
  
  public void a(int paramInt, ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg) {}
  
  public void a(int paramInt, Object... paramVarArgs)
  {
    ArrayList localArrayList;
    switch (paramInt)
    {
    default: 
      return;
    case 1003: 
      if ((paramVarArgs != null) && (paramVarArgs.length == 4))
      {
        localArrayList = new ArrayList();
        a((ArrayList)paramVarArgs[1], localArrayList);
        a((ToServiceMsg)paramVarArgs[0], localArrayList, (msg_svc.PbGetDiscussMsgResp)paramVarArgs[2], (String)paramVarArgs[3]);
        return;
      }
      a(getClass().getName(), paramInt);
      return;
    case 1002: 
      if ((paramVarArgs != null) && (paramVarArgs.length == 3))
      {
        localArrayList = new ArrayList();
        a((ArrayList)paramVarArgs[1], localArrayList);
        a((ToServiceMsg)paramVarArgs[0], localArrayList, (msg_svc.PbGetDiscussMsgResp)paramVarArgs[2]);
        return;
      }
      a(getClass().getName(), paramInt);
      return;
    }
    if ((paramVarArgs != null) && (paramVarArgs.length == 4))
    {
      a((msg_comm.Msg)paramVarArgs[0], (FromServiceMsg)paramVarArgs[1], (msg_onlinepush.PbPushMsg)paramVarArgs[2], ((Boolean)paramVarArgs[3]).booleanValue());
      return;
    }
    a(getClass().getName(), paramInt);
  }
  
  public void a(DisMsgReadedNotify paramDisMsgReadedNotify)
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("DisMsgReadedNotify lDisUin is ");
      ((StringBuilder)localObject).append(paramDisMsgReadedNotify.lDisUin);
      ((StringBuilder)localObject).append(", lMemberSeq  is ");
      ((StringBuilder)localObject).append(paramDisMsgReadedNotify.lMemberSeq);
      QLog.d("Q.msg.DiscMsgPc", 2, ((StringBuilder)localObject).toString());
    }
    Object localObject = String.valueOf(paramDisMsgReadedNotify.lDisUin);
    Object[] arrayOfObject = ((MessageCache)this.jdField_a_of_type_ComTencentCommonAppAppInterface.getMsgCache()).a((String)localObject);
    if ((arrayOfObject != null) && (arrayOfObject.length >= 2))
    {
      long l = ((Long)arrayOfObject[0]).longValue();
      ((Long)arrayOfObject[1]).longValue();
      if (l < paramDisMsgReadedNotify.lMemberSeq) {
        ((MessageCache)this.jdField_a_of_type_ComTencentCommonAppAppInterface.getMsgCache()).b((String)localObject, new Object[] { Long.valueOf(paramDisMsgReadedNotify.lMemberSeq), Long.valueOf(paramDisMsgReadedNotify.lDisMsgSeq) });
      }
    }
    ((IMessageFacade)this.jdField_a_of_type_ComTencentCommonAppAppInterface.getRuntimeService(IMessageFacade.class, "")).setReadFrom((String)localObject, 3000, paramDisMsgReadedNotify.lMemberSeq);
    if (paramDisMsgReadedNotify.lMemberSeq >= 0L) {
      ((IMessageFacade)this.jdField_a_of_type_ComTencentCommonAppAppInterface.getRuntimeService(IMessageFacade.class, "")).removeNotification((String)localObject, 3000);
    }
  }
  
  public void a(String paramString, int paramInt, long paramLong)
  {
    super.a(paramString, paramInt, paramLong);
    msg_svc.PbMsgReadedReportReq localPbMsgReadedReportReq = new msg_svc.PbMsgReadedReportReq();
    msg_svc.PbDiscussReadedReportReq localPbDiscussReadedReportReq = new msg_svc.PbDiscussReadedReportReq();
    localPbDiscussReadedReportReq.conf_uin.set(Long.valueOf(paramString).longValue());
    localPbDiscussReadedReportReq.last_read_seq.set(paramLong);
    localPbMsgReadedReportReq.dis_read_report.add(localPbDiscussReadedReportReq);
    a(localPbMsgReadedReportReq);
  }
  
  public void b(int paramInt, ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.app.message.DiscMessageProcessor
 * JD-Core Version:    0.7.0.1
 */