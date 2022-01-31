package com.tencent.mobileqq.app.message;

import OnlinePushPack.DelMsgInfo;
import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Pair;
import com.tencent.av.VideoConstants;
import com.tencent.biz.bmqq.util.BmqqSegmentUtil;
import com.tencent.biz.now.NowLiveManager;
import com.tencent.biz.pubaccount.readinjoy.common.ReadInJoyUtils;
import com.tencent.biz.pubaccount.readinjoy.engine.KandianMergeManager;
import com.tencent.biz.pubaccount.util.PAReportUtil;
import com.tencent.biz.pubaccount.util.PublicAccountUtil;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.aio.XMLMessageUtils;
import com.tencent.mobileqq.activity.qwallet.QWalletSetting;
import com.tencent.mobileqq.activity.qwallet.goldmsg.GoldMsgChatHelper;
import com.tencent.mobileqq.apollo.ApolloManager;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.HotChatHandler;
import com.tencent.mobileqq.app.HotChatManager;
import com.tencent.mobileqq.app.MessageHandler;
import com.tencent.mobileqq.app.MessageHandlerUtils;
import com.tencent.mobileqq.app.MessageRoamManager;
import com.tencent.mobileqq.app.NearbyFlowerManager;
import com.tencent.mobileqq.app.PublicAccountDataManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.SVIPHandler;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.TroopHandler;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.app.asyncdb.cache.RoamDateCache;
import com.tencent.mobileqq.confess.ConfessMsgUtil;
import com.tencent.mobileqq.data.ApolloBaseInfo;
import com.tencent.mobileqq.data.ApolloMessage;
import com.tencent.mobileqq.data.HotChatInfo;
import com.tencent.mobileqq.data.MessageForApollo;
import com.tencent.mobileqq.data.MessageForGrayTips;
import com.tencent.mobileqq.data.MessageForMarketFace;
import com.tencent.mobileqq.data.MessageForPic;
import com.tencent.mobileqq.data.MessageForPoke;
import com.tencent.mobileqq.data.MessageForPtt;
import com.tencent.mobileqq.data.MessageForStructing;
import com.tencent.mobileqq.data.MessageForText;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.PAMessage;
import com.tencent.mobileqq.data.SystemMsg;
import com.tencent.mobileqq.data.TroopInfo;
import com.tencent.mobileqq.emoticon.EmojiStickerManager;
import com.tencent.mobileqq.filemanager.app.FileTransferHandler;
import com.tencent.mobileqq.model.CommercialDrainageManager;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.nearby.NearbyFlowerMessage;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.service.message.DecodeProtoPkgContext;
import com.tencent.mobileqq.service.message.MessageCache;
import com.tencent.mobileqq.service.message.MessageConstants;
import com.tencent.mobileqq.service.message.MessageProtoCodec;
import com.tencent.mobileqq.service.message.MessageRecordFactory;
import com.tencent.mobileqq.service.message.MessageUtils;
import com.tencent.mobileqq.service.message.PBDecodeContext;
import com.tencent.mobileqq.service.message.TempSessionInfo;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.streamtransfile.StreamDataManager;
import com.tencent.mobileqq.structmsg.AbsStructMsg;
import com.tencent.mobileqq.systemmsg.GroupSystemMsgController;
import com.tencent.mobileqq.transfile.PttInfoCollector;
import com.tencent.mobileqq.transfile.StructLongMessageDownloadProcessor;
import com.tencent.mobileqq.troop.data.TroopCreateLogic;
import com.tencent.mobileqq.troop.utils.TroopGagMgr;
import com.tencent.mobileqq.troop.utils.TroopTipsMsgMgr;
import com.tencent.mobileqq.util.EndianUtil;
import com.tencent.mobileqq.util.Utils;
import com.tencent.mobileqq.utils.ContactUtils;
import com.tencent.mobileqq.utils.MsgUtils;
import com.tencent.mobileqq.utils.VipUtils;
import com.tencent.mobileqq.utils.httputils.PkgTools;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.MsgAutoMonitorUtil;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import mqq.os.MqqHandler;
import msf.msgcomm.msg_comm.AppShareInfo;
import msf.msgcomm.msg_comm.C2CTmpMsgHead;
import msf.msgcomm.msg_comm.ContentHead;
import msf.msgcomm.msg_comm.Msg;
import msf.msgcomm.msg_comm.MsgHead;
import msf.msgcomm.msg_comm.UinPairMsg;
import msf.msgsvc.msg_svc.PbC2CReadedReportReq;
import msf.msgsvc.msg_svc.PbC2CReadedReportReq.UinPairReadInfo;
import msf.msgsvc.msg_svc.PbGetOneDayRoamMsgResp;
import msf.msgsvc.msg_svc.PbGetRoamMsgResp;
import msf.msgsvc.msg_svc.PbMsgReadedReportReq;
import msf.onlinepush.msg_onlinepush.PbPushMsg;
import tencent.im.msg.im_msg_body.Elem;
import tencent.im.msg.im_msg_body.ElemFlags2;
import tencent.im.msg.im_msg_body.MsgBody;
import tencent.im.msg.im_msg_body.PubAccInfo;
import tencent.im.msg.im_msg_body.RichText;
import zzd;
import zzf;
import zzg;
import zzh;
import zzj;

public class C2CMessageProcessor
  extends BaseMessageProcessor
{
  HashSet jdField_a_of_type_JavaUtilHashSet = null;
  private Set jdField_a_of_type_JavaUtilSet = new HashSet();
  private boolean jdField_a_of_type_Boolean;
  HashSet jdField_b_of_type_JavaUtilHashSet = null;
  private Set jdField_b_of_type_JavaUtilSet = new HashSet();
  public int d = 1;
  public int e = 3;
  public int f = 10;
  public int g = 30;
  public int h;
  public int i = 1;
  public int j = 5;
  public int k = 10;
  public int l = 50;
  public int m;
  
  public C2CMessageProcessor(QQAppInterface paramQQAppInterface, MessageHandler paramMessageHandler)
  {
    super(paramQQAppInterface, paramMessageHandler);
  }
  
  private Pair a(String paramString, msg_comm.UinPairMsg paramUinPairMsg, long paramLong, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    ArrayList localArrayList1 = new ArrayList();
    new ArrayList();
    long l6 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getLongAccountUin();
    String str = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin();
    Object localObject1 = paramUinPairMsg.msg.get();
    if ((localObject1 == null) || (((List)localObject1).size() <= 0)) {
      return new Pair(paramString, Integer.valueOf(0));
    }
    ArrayList localArrayList2 = new ArrayList();
    a((List)localObject1, localArrayList2);
    StringBuilder localStringBuilder = new StringBuilder();
    HashMap localHashMap = new HashMap();
    HashSet localHashSet = new HashSet();
    DecodeProtoPkgContext localDecodeProtoPkgContext = new DecodeProtoPkgContext(l6, Long.parseLong(paramString), true, paramBoolean2, paramBoolean3, false);
    localDecodeProtoPkgContext.jdField_e_of_type_Boolean = true;
    localDecodeProtoPkgContext.a(1000, localHashMap);
    localDecodeProtoPkgContext.a(1001, localHashSet);
    int i2 = 0;
    int n = 0;
    localObject1 = paramString;
    long l1 = -1L;
    long l2 = -1L;
    if (i2 < localArrayList2.size())
    {
      l4 = l2;
      l3 = l1;
      i1 = n;
      localObject2 = localObject1;
    }
    try
    {
      localObject4 = (msg_comm.Msg)localArrayList2.get(i2);
      l4 = l2;
      l3 = l1;
      i1 = n;
      localObject2 = localObject1;
      localObject5 = (msg_comm.MsgHead)((msg_comm.Msg)localObject4).msg_head.get();
      l4 = l2;
      l3 = l1;
      i1 = n;
      localObject2 = localObject1;
      localObject6 = (im_msg_body.MsgBody)((msg_comm.Msg)localObject4).msg_body.get();
      l4 = l2;
      l3 = l1;
      i1 = n;
      localObject2 = localObject1;
      if (!((msg_comm.Msg)localObject4).msg_head.has())
      {
        l4 = l2;
        l3 = l1;
        i1 = n;
        localObject2 = localObject1;
        if (!QLog.isColorLevel()) {
          break label3023;
        }
        l4 = l2;
        l3 = l1;
        i1 = n;
        localObject2 = localObject1;
        QLog.d("Q.msg.C2CMessageProcessor", 2, "<---decodeC2CMessagePackage: msgList[" + i2 + "] : msg doesn't has msgHead.");
        break label3023;
      }
      l4 = l2;
      l3 = l1;
      i1 = n;
      localObject2 = localObject1;
      l8 = ((msg_comm.MsgHead)localObject5).to_uin.get();
      l4 = l2;
      l3 = l1;
      i1 = n;
      localObject2 = localObject1;
      l7 = ((msg_comm.MsgHead)localObject5).from_uin.get();
      l4 = l2;
      l3 = l1;
      i1 = n;
      localObject2 = localObject1;
      l9 = ((msg_comm.MsgHead)localObject5).from_uin.get();
      l4 = l2;
      l3 = l1;
      i1 = n;
      localObject2 = localObject1;
      l5 = ((msg_comm.MsgHead)localObject5).msg_time.get();
      if (l5 <= paramLong) {
        break label3014;
      }
      paramBoolean3 = false;
      bool = false;
    }
    catch (Exception localException2)
    {
      for (;;)
      {
        Object localObject4;
        Object localObject5;
        Object localObject6;
        long l8;
        long l7;
        long l9;
        long l5;
        localObject1 = localException1;
        localObject3 = localException2;
        n = i1;
        continue;
        n = 1;
        continue;
        paramBoolean3 = true;
        boolean bool = true;
      }
      l3 = l2;
      l2 = l1;
      l1 = l3;
    }
    long l4 = l2;
    long l3 = l1;
    int i1 = n;
    Object localObject2 = localObject1;
    l8 = MessageHandlerUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, l9, l8, paramUinPairMsg.peer_uin.get());
    l4 = l2;
    l3 = l1;
    i1 = n;
    localObject2 = localObject1;
    localObject1 = String.valueOf(l8);
    l4 = l2;
    l3 = l1;
    i1 = n;
    localObject2 = localObject1;
    l9 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(String.valueOf(l8), 0);
    if ((l5 <= l9) && (bool))
    {
      l4 = l2;
      l3 = l1;
      i1 = n;
      localObject2 = localObject1;
      if (QLog.isColorLevel())
      {
        l4 = l2;
        l3 = l1;
        i1 = n;
        localObject2 = localObject1;
        localStringBuilder.setLength(0);
        l4 = l2;
        l3 = l1;
        i1 = n;
        localObject2 = localObject1;
        localStringBuilder.append("<---decodeC2CMessagePackage : msgList[").append(i2).append("] : filter msg by del time delTime =").append(l9).append(", msgTime = ").append(l5);
        l4 = l2;
        l3 = l1;
        i1 = n;
        localObject2 = localObject1;
        QLog.d("Q.msg.C2CMessageProcessor", 2, localStringBuilder.toString());
      }
    }
    else
    {
      l4 = l2;
      l3 = l1;
      i1 = n;
      localObject2 = localObject1;
      localDecodeProtoPkgContext.jdField_a_of_type_Boolean = bool;
      l4 = l2;
      l3 = l1;
      i1 = n;
      localObject2 = localObject1;
      localDecodeProtoPkgContext.jdField_e_of_type_Long = l8;
      l4 = l2;
      l3 = l1;
      i1 = n;
      localObject2 = localObject1;
      localDecodeProtoPkgContext.h = paramBoolean3;
      l4 = l2;
      l3 = l1;
      i1 = n;
      localObject2 = localObject1;
      localObject4 = a((msg_comm.Msg)localObject4, localDecodeProtoPkgContext).iterator();
      l4 = l2;
      l3 = l1;
      i1 = n;
      localObject2 = localObject1;
      if (((Iterator)localObject4).hasNext())
      {
        l4 = l2;
        l3 = l1;
        i1 = n;
        localObject2 = localObject1;
        localObject5 = (MessageRecord)((Iterator)localObject4).next();
        l4 = l2;
        l3 = l1;
        i1 = n;
        localObject2 = localObject1;
        l5 = ((MessageRecord)localObject5).vipBubbleID;
        if (l5 != -1L)
        {
          l4 = l2;
          l3 = l1;
          i1 = n;
          localObject2 = localObject1;
          paramBoolean3 = MsgUtils.a(((MessageRecord)localObject5).issend);
          if (paramBoolean3)
          {
            l2 = l1;
            l1 = l5;
          }
        }
        for (;;)
        {
          try
          {
            i1 = ((MessageRecord)localObject5).istroop;
            n = i1;
            paramBoolean3 = a((MessageRecord)localObject5, true);
            n = i1;
            bool = b((MessageRecord)localObject5);
            Object localObject7;
            if ((!paramBoolean3) && (!bool))
            {
              n = i1;
              if (((MessageRecord)localObject5).istroop == 1008)
              {
                n = i1;
                if ((localObject5 instanceof MessageForStructing))
                {
                  n = i1;
                  if (!StructLongMessageDownloadProcessor.b((MessageRecord)localObject5))
                  {
                    n = i1;
                    if (!StructLongMessageDownloadProcessor.d((MessageRecord)localObject5)) {}
                  }
                  else
                  {
                    n = i1;
                    localObject2 = ((MessageRecord)localObject5).getExtInfoFromExtStr("longMsg_State");
                    if (localObject2 == null) {
                      continue;
                    }
                    n = i1;
                    if (!String.valueOf(3).equals(localObject2)) {
                      continue;
                    }
                  }
                }
              }
              n = i1;
              if ((localObject5 instanceof MessageForMarketFace))
              {
                n = i1;
                CommercialDrainageManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (MessageForMarketFace)localObject5);
              }
              n = i1;
              if ((localObject5 instanceof MessageForStructing))
              {
                n = i1;
                localObject2 = (MessageForStructing)localObject5;
                n = i1;
                if (((MessageForStructing)localObject2).structingMsg != null)
                {
                  n = i1;
                  if (((MessageForStructing)localObject2).structingMsg.mMsgServiceID == 500)
                  {
                    n = i1;
                    if (!AppConstants.aI.equals(((MessageForStructing)localObject2).senderuin))
                    {
                      n = i1;
                      if (!ReadInJoyUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (MessageRecord)localObject5)) {
                        break label2372;
                      }
                      n = i1;
                      ((MessageRecord)localObject5).time = NetConnInfoCenter.getServerTime();
                    }
                  }
                }
              }
              n = i1;
              localArrayList1.add(localObject5);
              n = i1;
              if ((localObject5 instanceof MessageForStructing))
              {
                n = i1;
                localObject2 = (MessageForStructing)localObject5;
                n = i1;
                if (((MessageForStructing)localObject2).structingMsg != null)
                {
                  n = i1;
                  if (((MessageForStructing)localObject2).structingMsg.mMsgServiceID == 112)
                  {
                    n = i1;
                    localObject6 = ((MessageForStructing)localObject2).structingMsg.mMergeSeq;
                    n = i1;
                    l3 = ((MessageForStructing)localObject2).structingMsg.mSortKey;
                    n = i1;
                    if ((!TextUtils.isEmpty((CharSequence)localObject6)) && (l3 >= 0L))
                    {
                      n = i1;
                      if (QLog.isColorLevel())
                      {
                        n = i1;
                        QLog.d("Q.msg.C2CMessageProcessor", 2, "current message mergeSeq=" + (String)localObject6 + ", sortKey=" + l3);
                      }
                      n = i1;
                      localObject6 = "goldmsg_pay_result_mergereq_" + (String)localObject6;
                      n = i1;
                      l3 = QWalletSetting.a(str, (String)localObject6, -1L);
                      if (l3 < 0L) {
                        break label3008;
                      }
                      n = i1;
                      localObject7 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().b(((MessageForStructing)localObject2).frienduin, ((MessageForStructing)localObject2).istroop, l3);
                      n = i1;
                      if (!(localObject7 instanceof MessageForStructing)) {
                        break label3008;
                      }
                      n = i1;
                      localObject7 = (MessageForStructing)localObject7;
                      n = i1;
                      if (((MessageForStructing)localObject7).structingMsg == null) {
                        break label3008;
                      }
                      n = i1;
                      if (((MessageForStructing)localObject7).structingMsg.mMsgServiceID != 112) {
                        break label3008;
                      }
                      n = i1;
                      if (((MessageForStructing)localObject2).structingMsg.mSortKey <= ((MessageForStructing)localObject7).structingMsg.mSortKey) {
                        break label2404;
                      }
                      n = i1;
                      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a((MessageRecord)localObject7, true);
                      n = 1;
                      if (n != 0)
                      {
                        n = i1;
                        QWalletSetting.a(str, (String)localObject6, ((MessageForStructing)localObject2).uniseq);
                      }
                    }
                  }
                }
              }
              n = i1;
              int i3 = KandianMergeManager.a((MessageRecord)localObject5, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
              if ((i3 == 0) || (i3 == 1))
              {
                n = i1;
                localObject2 = ((KandianMergeManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(161)).a((MessageRecord)localObject5);
                if (localObject2 != null)
                {
                  n = i1;
                  localArrayList1.add(localObject2);
                }
              }
            }
            n = i1;
            if (((MessageRecord)localObject5).msgtype == -2002)
            {
              if (!paramBoolean3)
              {
                n = i1;
                if (StreamDataManager.a(((MessageRecord)localObject5).msgUid, ((MessageRecord)localObject5).shmsgseq) != null)
                {
                  n = i1;
                  PttInfoCollector.a(true);
                }
              }
              if (paramBoolean3)
              {
                n = i1;
                if ((localObject5 instanceof MessageForPtt))
                {
                  n = i1;
                  if (MsgProxyUtils.c(((MessageRecord)localObject5).istroop))
                  {
                    n = i1;
                    localObject2 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().b(((MessageRecord)localObject5).frienduin, ((MessageRecord)localObject5).istroop).iterator();
                    n = i1;
                    if (((Iterator)localObject2).hasNext())
                    {
                      n = i1;
                      localObject6 = (MessageRecord)((Iterator)localObject2).next();
                      n = i1;
                      if (!(localObject6 instanceof MessageForPtt)) {
                        continue;
                      }
                      n = i1;
                      if (((MessageRecord)localObject6).msgUid != ((MessageRecord)localObject5).msgUid) {
                        continue;
                      }
                      n = i1;
                      if (((MessageRecord)localObject6).shmsgseq != ((MessageRecord)localObject5).shmsgseq) {
                        continue;
                      }
                      n = i1;
                      a((MessageForPtt)localObject6, (MessageForPtt)localObject5);
                    }
                  }
                }
              }
            }
            if (!paramBoolean3)
            {
              n = i1;
              if (((MessageRecord)localObject5).istroop == 1008)
              {
                n = i1;
                if (!"1".equals(((MessageRecord)localObject5).getExtInfoFromExtStr("is_AdArrive_Msg"))) {
                  break label2422;
                }
                n = i1;
                localObject2 = ((MessageRecord)localObject5).getExtInfoFromExtStr("gdt_msgImp");
                n = i1;
                localObject6 = ((MessageRecord)localObject5).getExtInfoFromExtStr("pa_msgId");
                n = i1;
                localObject7 = ((MessageRecord)localObject5).getExtInfoFromExtStr("gdt_view_id");
                n = i1;
                ArrayList localArrayList3 = new ArrayList();
                n = i1;
                localArrayList3.add(localObject6);
                n = i1;
                PAReportUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "", "", ((MessageRecord)localObject5).senderuin, (String)localObject2, (String)localObject7, localArrayList3);
              }
            }
            l3 = l2;
            l2 = l1;
            l1 = l3;
            n = i1;
            break;
            l1 = l2;
            l2 = l5;
            continue;
            l4 = l2;
            l3 = l1;
            i1 = n;
            localObject2 = localObject1;
            if (((MessageRecord)localObject5).msgtype == -2002)
            {
              l4 = l2;
              l3 = l1;
              i1 = n;
              localObject2 = localObject1;
              if (MsgUtils.a(((MessageRecord)localObject5).issend))
              {
                if (l2 != -1L)
                {
                  l4 = l2;
                  l3 = l1;
                  i1 = n;
                  localObject2 = localObject1;
                  ((MessageRecord)localObject5).vipBubbleID = l2;
                  l3 = l1;
                  l1 = l2;
                  l2 = l3;
                  continue;
                }
                l4 = l2;
                l3 = l1;
                i1 = n;
                localObject2 = localObject1;
                ((MessageRecord)localObject5).vipBubbleID = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(String.valueOf(l8), String.valueOf(l7));
                l3 = l1;
                l1 = l2;
                l2 = l3;
                continue;
              }
              if (l1 != -1L)
              {
                l4 = l2;
                l3 = l1;
                i1 = n;
                localObject2 = localObject1;
                ((MessageRecord)localObject5).vipBubbleID = l1;
                l3 = l1;
                l1 = l2;
                l2 = l3;
                continue;
              }
              l4 = l2;
              l3 = l1;
              i1 = n;
              localObject2 = localObject1;
              ((MessageRecord)localObject5).vipBubbleID = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(String.valueOf(l8), String.valueOf(l7));
              l3 = l1;
              l1 = l2;
              l2 = l3;
              continue;
            }
            l4 = l2;
            l3 = l1;
            i1 = n;
            localObject2 = localObject1;
            ((MessageRecord)localObject5).vipBubbleID = 0L;
            l3 = l1;
            l1 = l2;
            l2 = l3;
            continue;
            n = i1;
            ((MessageRecord)localObject5).saveExtInfoToExtStr("longMsg_State", String.valueOf(1));
            n = i1;
            StructLongMessageDownloadProcessor.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (MessageForStructing)localObject5);
            continue;
            if (!QLog.isColorLevel()) {
              break label2361;
            }
          }
          catch (Exception localException1)
          {
            l3 = l2;
            l4 = l1;
          }
          QLog.w("Q.msg.C2CMessageProcessor", 2, "decodeC2CMessage error,", localException1);
          label2361:
          l1 = l4;
          l2 = l3;
          break label3035;
          label2372:
          n = i1;
          ReadInJoyUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localException1);
          l3 = l2;
          l2 = l1;
          l1 = l3;
          n = i1;
          break;
          label2404:
          n = i1;
          localArrayList1.remove(localObject5);
          n = 0;
          continue;
          label2422:
          n = i1;
          if ("2290230341".equals(((MessageRecord)localObject5).frienduin))
          {
            n = i1;
            ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X80090E1", "0X80090E1", 0, 0, "", "", "", "");
          }
        }
      }
      l3 = l1;
      l1 = l2;
      l2 = l3;
      break label3035;
      if (localObject1 != null)
      {
        paramUinPairMsg = (msg_comm.UinPairMsg)localObject1;
        if (!((String)localObject1).equals("0")) {}
      }
      else
      {
        paramUinPairMsg = paramString;
      }
      if (!localHashMap.isEmpty())
      {
        paramString = localHashSet.iterator();
        while (paramString.hasNext())
        {
          localObject1 = (Long)paramString.next();
          localHashMap.remove(localObject1);
          if (QLog.isColorLevel()) {
            QLog.d("svenxu", 2, "Discard video request because canceled: fromUin = " + localObject1);
          }
        }
        paramString = localHashMap.keySet().iterator();
        while (paramString.hasNext())
        {
          localObject1 = (msg_comm.Msg)localHashMap.get((Long)paramString.next());
          if ((((msg_comm.Msg)localObject1).msg_body.has()) && (((im_msg_body.MsgBody)((msg_comm.Msg)localObject1).msg_body.get()).msg_content.has())) {
            this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler.a(l6, ((im_msg_body.MsgBody)((msg_comm.Msg)localObject1).msg_body.get()).msg_content.get().toByteArray(), ((msg_comm.MsgHead)((msg_comm.Msg)localObject1).msg_head.get()).from_uin.get(), ((msg_comm.MsgHead)((msg_comm.Msg)localObject1).msg_head.get()).msg_time.get());
          }
        }
      }
      if (localArrayList1.size() > 0)
      {
        if (!paramBoolean2) {
          this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().b(localArrayList1);
        }
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(String.valueOf(paramUinPairMsg), 0, localArrayList1, paramBoolean1);
        paramBoolean3 = a(localArrayList1);
        i1 = MsgProxyUtils.a(localArrayList1, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
        ConfessMsgUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localArrayList1);
        paramString = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a();
        if ((!paramBoolean3) || (!this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.isBackground_Stop)) {
          break label2985;
        }
      }
      label2985:
      for (paramBoolean1 = true;; paramBoolean1 = false)
      {
        paramString.a(localArrayList1, str, paramBoolean1);
        a(localArrayList1);
        a(localArrayList1);
        a("handleGetBuddyMessageResp", true, i1, paramBoolean3, paramBoolean2);
        a(localArrayList1, paramBoolean2);
        MessageStatisticHelper.a((MessageRecord)localArrayList1.get(0), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
        if (n == 1008)
        {
          paramString = (PublicAccountDataManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(55);
          if (paramString != null) {
            paramString.a(localArrayList1, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
          }
        }
        if (QLog.isColorLevel()) {
          QLog.d("Q.msg.C2CMessageProcessor", 2, "<---decodeC2CMessagePackage : dstUin:" + paramUinPairMsg + ", pkgUinType:" + n);
        }
        return new Pair(paramUinPairMsg, Integer.valueOf(n));
      }
    }
    for (;;)
    {
      Object localObject3;
      label3008:
      label3014:
      label3023:
      label3035:
      i2 += 1;
      l3 = l2;
      l2 = l1;
      l1 = l3;
      break;
      l3 = l1;
      l1 = l2;
      l2 = l3;
    }
  }
  
  private Pair a(List paramList1, List paramList2, long paramLong1, long paramLong2, long paramLong3)
  {
    ArrayList localArrayList = new ArrayList();
    List localList = ((MessageRoamManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(91)).a(String.valueOf(paramLong1), paramLong2 - 30L, 30L + paramLong3);
    if ((localList != null) && (!localList.isEmpty()))
    {
      paramList1 = paramList1.iterator();
      Object localObject;
      int n;
      while (paramList1.hasNext())
      {
        localObject = (msg_comm.Msg)paramList1.next();
        if (!((msg_comm.Msg)localObject).msg_head.has())
        {
          paramList1.remove();
        }
        else
        {
          localObject = (msg_comm.MsgHead)((msg_comm.Msg)localObject).msg_head.get();
          paramLong1 = ((msg_comm.MsgHead)localObject).msg_uid.get();
          paramLong2 = (short)((msg_comm.MsgHead)localObject).msg_seq.get();
          n = 0;
          while (n < localList.size())
          {
            localObject = (MessageRecord)localList.get(n);
            if ((((MessageRecord)localObject).msgUid == paramLong1) && (((MessageRecord)localObject).shmsgseq == paramLong2))
            {
              if (QLog.isColorLevel()) {
                QLog.d("Q.msg.C2CMessageProcessor", 2, "filterRoamMsgFromDB duplicated " + localObject);
              }
              localArrayList.add(localObject);
              paramList1.remove();
            }
            n += 1;
          }
        }
      }
      paramList1 = paramList2.iterator();
      while (paramList1.hasNext())
      {
        localObject = (MessageRecord)paramList1.next();
        n = 0;
        while (n < localList.size())
        {
          MessageRecord localMessageRecord = (MessageRecord)localList.get(n);
          if ((localMessageRecord.msgUid == ((MessageRecord)localObject).msgUid) && (localMessageRecord.shmsgseq == ((MessageRecord)localObject).shmsgseq))
          {
            if (QLog.isColorLevel()) {
              QLog.d("Q.msg.C2CMessageProcessor", 2, "filterRoamMsgFromDB duplicated " + localObject);
            }
            paramList1.remove();
          }
          n += 1;
        }
      }
    }
    return new Pair(localArrayList, paramList2);
  }
  
  private void a(QQAppInterface paramQQAppInterface, int paramInt, String paramString1, String paramString2, long paramLong1, long paramLong2, long paramLong3, msg_comm.MsgHead paramMsgHead)
  {
    Object localObject2 = paramQQAppInterface.getCurrentAccountUin();
    Long localLong = Long.valueOf(Long.parseLong((String)localObject2));
    String str1 = String.valueOf(paramLong1);
    Object localObject1 = "" + paramMsgHead.auth_uin.get();
    paramMsgHead = paramMsgHead.auth_nick.get();
    if ((!TextUtils.isEmpty((CharSequence)localObject1)) && (!TextUtils.isEmpty(paramMsgHead)) && (((String)localObject1).equals(paramString1))) {}
    for (;;)
    {
      if ((!TextUtils.isEmpty((CharSequence)localObject2)) && (((String)localObject2).equals(paramString1))) {
        return;
      }
      if (TextUtils.isEmpty(paramMsgHead)) {
        paramMsgHead = MessageHandlerUtils.a(paramQQAppInterface, paramString1, str1);
      }
      for (;;)
      {
        Object localObject3;
        boolean bool;
        if ((paramInt == -126) || (paramInt == 2))
        {
          localObject1 = paramMsgHead + " 加入了本群";
          localObject2 = paramQQAppInterface.getApp().getApplicationContext().getString(2131433116);
          paramString2 = (String)localObject1;
          if (a(str1)) {
            paramString2 = (String)localObject1 + "，" + (String)localObject2;
          }
          localObject1 = (MessageForGrayTips)MessageRecordFactory.a(-1012);
          ((MessageForGrayTips)localObject1).init(localLong.longValue(), paramLong1, paramLong1, paramString2, paramLong2, -1012, 1, paramLong3);
          ((MessageForGrayTips)localObject1).switch2HightlightMsg();
          localObject3 = new Bundle();
          ((Bundle)localObject3).putInt("key_action", 5);
          ((Bundle)localObject3).putString("troop_mem_uin", paramString1);
          ((Bundle)localObject3).putBoolean("need_update_nick", false);
          ((MessageForGrayTips)localObject1).addHightlightItem(0, paramMsgHead.length(), (Bundle)localObject3);
          if (a(str1))
          {
            paramMsgHead = new Bundle();
            paramMsgHead.putInt("key_action", 19);
            paramMsgHead.putString("troop_mem_uin", paramString1);
            paramMsgHead.putString("troopUin", str1);
            ((MessageForGrayTips)localObject1).addHightlightItem(paramString2.length() - ((String)localObject2).length(), paramString2.length(), paramMsgHead);
          }
          ((MessageForGrayTips)localObject1).isread = true;
          paramString1 = (TroopTipsMsgMgr)paramQQAppInterface.getManager(80);
          if ((a((MessageRecord)localObject1, false)) || (paramString1.a(paramLong1 + "", paramLong3)) || (TroopInfo.isHomeworkTroop(paramQQAppInterface, str1))) {}
          for (bool = true;; bool = false)
          {
            if (!bool) {
              paramQQAppInterface.a().a((MessageRecord)localObject1, String.valueOf(localLong));
            }
            if (!QLog.isColorLevel()) {
              break;
            }
            QLog.d("Q.msg.C2CMessageProcessor", 2, "seq:" + paramLong3 + "|cOpt:" + paramInt + "|tips:" + paramString2 + "|msgFilter:" + bool);
            return;
          }
        }
        if (((paramInt != -125) && (paramInt != 3)) || (((TroopCreateLogic)paramQQAppInterface.getManager(31)).a(str1, (String)localObject1))) {
          break;
        }
        localObject1 = MessageHandlerUtils.a(paramQQAppInterface, paramString2, str1);
        int n = 0;
        if ((!TextUtils.isEmpty((CharSequence)localObject2)) && (((String)localObject2).equals(paramString2)))
        {
          n = 1;
          localObject1 = "你";
        }
        for (;;)
        {
          label624:
          Object localObject4;
          if (n != 0)
          {
            localObject3 = (String)localObject1 + "邀请 ";
            localObject4 = (String)localObject3 + paramMsgHead + " 加入群聊";
            String str2 = paramQQAppInterface.getApp().getApplicationContext().getString(2131433116);
            localObject2 = localObject4;
            if (a(str1)) {
              localObject2 = (String)localObject4 + "，" + str2;
            }
            localObject4 = (MessageForGrayTips)MessageRecordFactory.a(-1012);
            ((MessageForGrayTips)localObject4).init(localLong.longValue(), paramLong1, paramLong1, (String)localObject2, paramLong2, -1012, 1, paramLong3);
            ((MessageForGrayTips)localObject4).switch2HightlightMsg();
            if (n == 0)
            {
              Bundle localBundle = new Bundle();
              localBundle.putInt("key_action", 5);
              localBundle.putString("troop_mem_uin", paramString2);
              localBundle.putBoolean("need_update_nick", false);
              ((MessageForGrayTips)localObject4).addHightlightItem(0, ((String)localObject1).length(), localBundle);
            }
            paramString2 = new Bundle();
            paramString2.putInt("key_action", 5);
            paramString2.putString("troop_mem_uin", paramString1);
            paramString2.putBoolean("need_update_nick", false);
            ((MessageForGrayTips)localObject4).addHightlightItem(((String)localObject3).length(), ((String)localObject3).length() + paramMsgHead.length(), paramString2);
            if (a(str1))
            {
              paramString2 = new Bundle();
              paramString2.putInt("key_action", 19);
              paramString2.putString("troop_mem_uin", paramString1);
              paramString2.putString("troopUin", str1);
              ((MessageForGrayTips)localObject4).addHightlightItem(((String)localObject2).length() - str2.length(), ((String)localObject2).length(), paramString2);
            }
            ((MessageForGrayTips)localObject4).isread = true;
            paramString1 = (TroopTipsMsgMgr)paramQQAppInterface.getManager(80);
            if ((!a((MessageRecord)localObject4, false)) && (!paramString1.a(paramLong1 + "", paramLong3)) && (!TroopInfo.isHomeworkTroop(paramQQAppInterface, str1))) {
              break label1108;
            }
          }
          label1108:
          for (bool = true;; bool = false)
          {
            if (!bool) {
              paramQQAppInterface.a().a((MessageRecord)localObject4, String.valueOf(localLong));
            }
            if (!QLog.isColorLevel()) {
              break;
            }
            QLog.d("Q.msg.C2CMessageProcessor", 2, "seq:" + paramLong3 + "|cOpt:" + paramInt + "|tips:" + (String)localObject2 + "|msgFilter:" + bool);
            return;
            localObject3 = (String)localObject1 + " 邀请 ";
            break label624;
          }
        }
      }
      paramMsgHead = "";
    }
  }
  
  private void a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg)
  {
    paramFromServiceMsg = new Bundle();
    paramFromServiceMsg.putLong("BEGTIME", paramToServiceMsg.extraData.getLong("lBeginTime"));
    paramFromServiceMsg.putBoolean("FETCH_MORE", paramToServiceMsg.extraData.getBoolean("fetchMore"));
    a(1004, false, paramFromServiceMsg);
  }
  
  /* Error */
  private void a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    // Byte code:
    //   0: aload_1
    //   1: getfield 742	com/tencent/qphone/base/remote/ToServiceMsg:extraData	Landroid/os/Bundle;
    //   4: ldc_w 764
    //   7: iconst_1
    //   8: invokevirtual 767	android/os/Bundle:getBoolean	(Ljava/lang/String;Z)Z
    //   11: istore 9
    //   13: aload_1
    //   14: getfield 742	com/tencent/qphone/base/remote/ToServiceMsg:extraData	Landroid/os/Bundle;
    //   17: ldc_w 769
    //   20: iconst_1
    //   21: invokevirtual 767	android/os/Bundle:getBoolean	(Ljava/lang/String;Z)Z
    //   24: istore 11
    //   26: aload_1
    //   27: getfield 742	com/tencent/qphone/base/remote/ToServiceMsg:extraData	Landroid/os/Bundle;
    //   30: ldc_w 771
    //   33: iconst_0
    //   34: invokevirtual 767	android/os/Bundle:getBoolean	(Ljava/lang/String;Z)Z
    //   37: istore 10
    //   39: invokestatic 776	java/lang/System:currentTimeMillis	()J
    //   42: lstore 12
    //   44: new 778	msf/msgsvc/msg_svc$PbGetMsgResp
    //   47: dup
    //   48: invokespecial 779	msf/msgsvc/msg_svc$PbGetMsgResp:<init>	()V
    //   51: astore 20
    //   53: aload 20
    //   55: aload_3
    //   56: checkcast 781	[B
    //   59: checkcast 781	[B
    //   62: invokevirtual 785	msf/msgsvc/msg_svc$PbGetMsgResp:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   65: checkcast 778	msf/msgsvc/msg_svc$PbGetMsgResp
    //   68: astore 20
    //   70: aload 20
    //   72: ifnonnull +35 -> 107
    //   75: invokestatic 788	com/tencent/qphone/base/util/BaseApplication:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   78: invokestatic 793	com/tencent/mobileqq/statistics/StatisticCollector:a	(Landroid/content/Context;)Lcom/tencent/mobileqq/statistics/StatisticCollector;
    //   81: aload_0
    //   82: getfield 63	com/tencent/mobileqq/app/message/C2CMessageProcessor:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   85: invokevirtual 73	com/tencent/mobileqq/app/QQAppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   88: ldc_w 795
    //   91: iconst_0
    //   92: lconst_0
    //   93: lconst_0
    //   94: new 110	java/util/HashMap
    //   97: dup
    //   98: invokespecial 111	java/util/HashMap:<init>	()V
    //   101: ldc_w 441
    //   104: invokevirtual 798	com/tencent/mobileqq/statistics/StatisticCollector:a	(Ljava/lang/String;Ljava/lang/String;ZJJLjava/util/HashMap;Ljava/lang/String;)V
    //   107: new 107	java/lang/StringBuilder
    //   110: dup
    //   111: invokespecial 108	java/lang/StringBuilder:<init>	()V
    //   114: astore 22
    //   116: aload 20
    //   118: ifnull +25 -> 143
    //   121: aload 20
    //   123: getfield 801	msf/msgsvc/msg_svc$PbGetMsgResp:result	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   126: invokevirtual 802	com/tencent/mobileqq/pb/PBUInt32Field:has	()Z
    //   129: ifeq +14 -> 143
    //   132: aload 20
    //   134: getfield 801	msf/msgsvc/msg_svc$PbGetMsgResp:result	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   137: invokevirtual 198	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   140: ifeq +175 -> 315
    //   143: invokestatic 160	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   146: ifeq +104 -> 250
    //   149: aload 22
    //   151: iconst_0
    //   152: invokevirtual 223	java/lang/StringBuilder:setLength	(I)V
    //   155: aload 22
    //   157: ldc_w 804
    //   160: invokevirtual 168	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   163: aload_1
    //   164: invokevirtual 807	com/tencent/qphone/base/remote/ToServiceMsg:getRequestSsoSeq	()I
    //   167: invokevirtual 171	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   170: ldc_w 809
    //   173: invokevirtual 168	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   176: astore 21
    //   178: aload 20
    //   180: ifnonnull +105 -> 285
    //   183: ldc_w 811
    //   186: astore_3
    //   187: aload 21
    //   189: aload_3
    //   190: invokevirtual 495	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   193: ldc_w 813
    //   196: invokevirtual 168	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   199: astore 21
    //   201: aload 20
    //   203: ifnonnull +97 -> 300
    //   206: ldc_w 811
    //   209: astore_3
    //   210: aload 21
    //   212: aload_3
    //   213: invokevirtual 495	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   216: ldc_w 815
    //   219: invokevirtual 168	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   222: iload 9
    //   224: invokevirtual 720	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   227: ldc_w 817
    //   230: invokevirtual 168	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   233: iload 11
    //   235: invokevirtual 720	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   238: pop
    //   239: ldc 162
    //   241: iconst_2
    //   242: aload 22
    //   244: invokevirtual 176	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   247: invokestatic 819	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   250: aload_0
    //   251: getfield 515	com/tencent/mobileqq/app/message/C2CMessageProcessor:jdField_a_of_type_ComTencentMobileqqAppMessageHandler	Lcom/tencent/mobileqq/app/MessageHandler;
    //   254: aload_1
    //   255: aload_2
    //   256: invokevirtual 821	com/tencent/mobileqq/app/MessageHandler:a	(Lcom/tencent/qphone/base/remote/ToServiceMsg;Lcom/tencent/qphone/base/remote/FromServiceMsg;)V
    //   259: return
    //   260: astore 20
    //   262: invokestatic 160	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   265: ifeq +14 -> 279
    //   268: ldc 162
    //   270: iconst_2
    //   271: ldc_w 823
    //   274: aload 20
    //   276: invokestatic 825	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   279: aconst_null
    //   280: astore 20
    //   282: goto -212 -> 70
    //   285: aload 20
    //   287: getfield 801	msf/msgsvc/msg_svc$PbGetMsgResp:result	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   290: invokevirtual 198	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   293: invokestatic 99	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   296: astore_3
    //   297: goto -110 -> 187
    //   300: aload 20
    //   302: getfield 828	msf/msgsvc/msg_svc$PbGetMsgResp:sync_cookie	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   305: invokevirtual 512	com/tencent/mobileqq/pb/PBBytesField:has	()Z
    //   308: invokestatic 833	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   311: astore_3
    //   312: goto -102 -> 210
    //   315: aconst_null
    //   316: astore_2
    //   317: aload 20
    //   319: getfield 828	msf/msgsvc/msg_svc$PbGetMsgResp:sync_cookie	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   322: invokevirtual 512	com/tencent/mobileqq/pb/PBBytesField:has	()Z
    //   325: ifeq +15 -> 340
    //   328: aload 20
    //   330: getfield 828	msf/msgsvc/msg_svc$PbGetMsgResp:sync_cookie	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   333: invokevirtual 518	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   336: invokevirtual 524	com/tencent/mobileqq/pb/ByteStringMicro:toByteArray	()[B
    //   339: astore_2
    //   340: aload 20
    //   342: getfield 836	msf/msgsvc/msg_svc$PbGetMsgResp:uin_pair_msgs	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   345: invokevirtual 85	com/tencent/mobileqq/pb/PBRepeatMessageField:get	()Ljava/util/List;
    //   348: astore 23
    //   350: aload_0
    //   351: getfield 515	com/tencent/mobileqq/app/message/C2CMessageProcessor:jdField_a_of_type_ComTencentMobileqqAppMessageHandler	Lcom/tencent/mobileqq/app/MessageHandler;
    //   354: iconst_0
    //   355: putfield 837	com/tencent/mobileqq/app/MessageHandler:f	I
    //   358: aload 20
    //   360: getfield 841	msf/msgsvc/msg_svc$PbGetMsgResp:sync_flag	Lcom/tencent/mobileqq/pb/PBEnumField;
    //   363: invokevirtual 844	com/tencent/mobileqq/pb/PBEnumField:has	()Z
    //   366: ifeq +1829 -> 2195
    //   369: aload 20
    //   371: getfield 841	msf/msgsvc/msg_svc$PbGetMsgResp:sync_flag	Lcom/tencent/mobileqq/pb/PBEnumField;
    //   374: invokevirtual 845	com/tencent/mobileqq/pb/PBEnumField:get	()I
    //   377: istore 5
    //   379: iload 5
    //   381: iconst_2
    //   382: if_icmpge +1807 -> 2189
    //   385: iconst_1
    //   386: i2b
    //   387: istore 4
    //   389: aconst_null
    //   390: astore 21
    //   392: aload 20
    //   394: getfield 848	msf/msgsvc/msg_svc$PbGetMsgResp:pubaccount_cookie	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   397: invokevirtual 512	com/tencent/mobileqq/pb/PBBytesField:has	()Z
    //   400: ifeq +16 -> 416
    //   403: aload 20
    //   405: getfield 848	msf/msgsvc/msg_svc$PbGetMsgResp:pubaccount_cookie	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   408: invokevirtual 518	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   411: invokevirtual 524	com/tencent/mobileqq/pb/ByteStringMicro:toByteArray	()[B
    //   414: astore 21
    //   416: iconst_0
    //   417: istore 6
    //   419: aload 20
    //   421: getfield 851	msf/msgsvc/msg_svc$PbGetMsgResp:msg_rsp_type	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   424: invokevirtual 802	com/tencent/mobileqq/pb/PBUInt32Field:has	()Z
    //   427: ifeq +13 -> 440
    //   430: aload 20
    //   432: getfield 851	msf/msgsvc/msg_svc$PbGetMsgResp:msg_rsp_type	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   435: invokevirtual 198	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   438: istore 6
    //   440: iload 6
    //   442: tableswitch	default:+26 -> 468, 0:+906->1348, 1:+947->1389, 2:+969->1411
    //   469: istore 8
    //   471: aload_0
    //   472: getfield 515	com/tencent/mobileqq/app/message/C2CMessageProcessor:jdField_a_of_type_ComTencentMobileqqAppMessageHandler	Lcom/tencent/mobileqq/app/MessageHandler;
    //   475: invokevirtual 853	com/tencent/mobileqq/app/MessageHandler:a	()Z
    //   478: ifeq +6 -> 484
    //   481: iconst_1
    //   482: istore 8
    //   484: iload 4
    //   486: ifle +25 -> 511
    //   489: aload_0
    //   490: getfield 515	com/tencent/mobileqq/app/message/C2CMessageProcessor:jdField_a_of_type_ComTencentMobileqqAppMessageHandler	Lcom/tencent/mobileqq/app/MessageHandler;
    //   493: iload 4
    //   495: aload_2
    //   496: iload 5
    //   498: iload 9
    //   500: iload 11
    //   502: iload 8
    //   504: aconst_null
    //   505: iload 6
    //   507: aconst_null
    //   508: invokevirtual 856	com/tencent/mobileqq/app/MessageHandler:a	(B[BIZZZLjava/lang/String;ILjava/lang/Object;)V
    //   511: invokestatic 160	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   514: ifeq +154 -> 668
    //   517: aload 22
    //   519: iconst_0
    //   520: invokevirtual 223	java/lang/StringBuilder:setLength	(I)V
    //   523: aload 22
    //   525: ldc_w 804
    //   528: invokevirtual 168	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   531: aload_1
    //   532: invokevirtual 807	com/tencent/qphone/base/remote/ToServiceMsg:getRequestSsoSeq	()I
    //   535: invokevirtual 171	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   538: ldc_w 809
    //   541: invokevirtual 168	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   544: aload 20
    //   546: getfield 801	msf/msgsvc/msg_svc$PbGetMsgResp:result	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   549: invokevirtual 198	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   552: invokevirtual 171	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   555: ldc_w 858
    //   558: invokevirtual 168	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   561: aload 20
    //   563: getfield 828	msf/msgsvc/msg_svc$PbGetMsgResp:sync_cookie	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   566: invokevirtual 512	com/tencent/mobileqq/pb/PBBytesField:has	()Z
    //   569: invokevirtual 720	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   572: ldc_w 860
    //   575: invokevirtual 168	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   578: iload 4
    //   580: invokevirtual 171	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   583: ldc_w 862
    //   586: invokevirtual 168	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   589: iload 5
    //   591: invokevirtual 171	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   594: ldc_w 864
    //   597: invokevirtual 168	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   600: iload 9
    //   602: invokevirtual 720	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   605: ldc_w 817
    //   608: invokevirtual 168	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   611: iload 11
    //   613: invokevirtual 720	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   616: ldc_w 866
    //   619: invokevirtual 168	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   622: aload 23
    //   624: invokeinterface 91 1 0
    //   629: invokevirtual 171	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   632: ldc_w 868
    //   635: invokevirtual 168	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   638: aload_3
    //   639: invokevirtual 873	java/lang/Object:hashCode	()I
    //   642: invokevirtual 171	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   645: ldc_w 875
    //   648: invokevirtual 168	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   651: iload 6
    //   653: invokevirtual 171	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   656: pop
    //   657: ldc 162
    //   659: iconst_2
    //   660: aload 22
    //   662: invokevirtual 176	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   665: invokestatic 179	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   668: iconst_0
    //   669: istore 7
    //   671: iload 7
    //   673: aload 23
    //   675: invokeinterface 91 1 0
    //   680: if_icmpge +858 -> 1538
    //   683: invokestatic 776	java/lang/System:currentTimeMillis	()J
    //   686: lstore 12
    //   688: aload 23
    //   690: iload 7
    //   692: invokeinterface 600 2 0
    //   697: checkcast 75	msf/msgcomm/msg_comm$UinPairMsg
    //   700: astore 20
    //   702: aload 20
    //   704: getfield 201	msf/msgcomm/msg_comm$UinPairMsg:peer_uin	Lcom/tencent/mobileqq/pb/PBUInt64Field;
    //   707: invokevirtual 187	com/tencent/mobileqq/pb/PBUInt64Field:get	()J
    //   710: invokestatic 211	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   713: astore_2
    //   714: aload 20
    //   716: getfield 878	msf/msgcomm/msg_comm$UinPairMsg:last_read_time	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   719: invokevirtual 198	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   722: i2l
    //   723: ldc2_w 879
    //   726: land
    //   727: lstore 14
    //   729: aload 20
    //   731: getfield 79	msf/msgcomm/msg_comm$UinPairMsg:msg	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   734: invokevirtual 85	com/tencent/mobileqq/pb/PBRepeatMessageField:get	()Ljava/util/List;
    //   737: astore_3
    //   738: aload 20
    //   740: getfield 883	msf/msgcomm/msg_comm$UinPairMsg:msg_completed	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   743: invokevirtual 802	com/tencent/mobileqq/pb/PBUInt32Field:has	()Z
    //   746: ifeq +688 -> 1434
    //   749: aload 20
    //   751: getfield 883	msf/msgcomm/msg_comm$UinPairMsg:msg_completed	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   754: invokevirtual 198	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   757: ifeq +677 -> 1434
    //   760: iconst_1
    //   761: istore 8
    //   763: invokestatic 160	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   766: ifeq +77 -> 843
    //   769: aload 22
    //   771: iconst_0
    //   772: invokevirtual 223	java/lang/StringBuilder:setLength	(I)V
    //   775: aload 22
    //   777: ldc_w 885
    //   780: invokevirtual 168	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   783: aload_2
    //   784: invokevirtual 168	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   787: ldc_w 887
    //   790: invokevirtual 168	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   793: iload 8
    //   795: invokevirtual 720	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   798: ldc_w 889
    //   801: invokevirtual 168	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   804: lload 14
    //   806: invokevirtual 230	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   809: ldc_w 891
    //   812: invokevirtual 168	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   815: astore 21
    //   817: aload_3
    //   818: ifnonnull +622 -> 1440
    //   821: ldc_w 811
    //   824: astore_1
    //   825: aload 21
    //   827: aload_1
    //   828: invokevirtual 495	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   831: pop
    //   832: ldc 162
    //   834: iconst_2
    //   835: aload 22
    //   837: invokevirtual 176	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   840: invokestatic 179	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   843: aload_3
    //   844: ifnull +652 -> 1496
    //   847: aload_3
    //   848: invokeinterface 91 1 0
    //   853: ifle +643 -> 1496
    //   856: aload_3
    //   857: invokeinterface 91 1 0
    //   862: iconst_1
    //   863: if_icmple +15 -> 878
    //   866: aload_3
    //   867: new 893	zze
    //   870: dup
    //   871: aload_0
    //   872: invokespecial 896	zze:<init>	(Lcom/tencent/mobileqq/app/message/C2CMessageProcessor;)V
    //   875: invokestatic 902	java/util/Collections:sort	(Ljava/util/List;Ljava/util/Comparator;)V
    //   878: aload_0
    //   879: getfield 63	com/tencent/mobileqq/app/message/C2CMessageProcessor:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   882: bipush 50
    //   884: invokevirtual 391	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   887: checkcast 904	com/tencent/mobileqq/app/FriendsManager
    //   890: aload_3
    //   891: iconst_0
    //   892: invokeinterface 600 2 0
    //   897: checkcast 135	msf/msgcomm/msg_comm$Msg
    //   900: getfield 139	msf/msgcomm/msg_comm$Msg:msg_head	Lmsf/msgcomm/msg_comm$MsgHead;
    //   903: invokevirtual 144	msf/msgcomm/msg_comm$MsgHead:get	()Lcom/tencent/mobileqq/pb/MessageMicro;
    //   906: checkcast 141	msf/msgcomm/msg_comm$MsgHead
    //   909: getfield 190	msf/msgcomm/msg_comm$MsgHead:from_uin	Lcom/tencent/mobileqq/pb/PBUInt64Field;
    //   912: invokevirtual 187	com/tencent/mobileqq/pb/PBUInt64Field:get	()J
    //   915: invokevirtual 907	com/tencent/mobileqq/app/FriendsManager:a	(J)V
    //   918: aload_0
    //   919: getfield 515	com/tencent/mobileqq/app/message/C2CMessageProcessor:jdField_a_of_type_ComTencentMobileqqAppMessageHandler	Lcom/tencent/mobileqq/app/MessageHandler;
    //   922: aload_2
    //   923: iconst_0
    //   924: invokevirtual 910	com/tencent/mobileqq/app/MessageHandler:a	(Ljava/lang/String;I)Ljava/lang/Object;
    //   927: astore 21
    //   929: aload 21
    //   931: monitorenter
    //   932: aload_0
    //   933: aload_2
    //   934: aload 20
    //   936: lload 14
    //   938: iload 8
    //   940: iload 9
    //   942: iload 10
    //   944: invokespecial 912	com/tencent/mobileqq/app/message/C2CMessageProcessor:a	(Ljava/lang/String;Lmsf/msgcomm/msg_comm$UinPairMsg;JZZZ)Landroid/util/Pair;
    //   947: astore_2
    //   948: aload_2
    //   949: getfield 916	android/util/Pair:first	Ljava/lang/Object;
    //   952: checkcast 208	java/lang/String
    //   955: astore_1
    //   956: aload_2
    //   957: getfield 919	android/util/Pair:second	Ljava/lang/Object;
    //   960: checkcast 95	java/lang/Integer
    //   963: invokevirtual 922	java/lang/Integer:intValue	()I
    //   966: istore 5
    //   968: aload 21
    //   970: monitorexit
    //   971: iload 8
    //   973: ifne +171 -> 1144
    //   976: aload_0
    //   977: getfield 63	com/tencent/mobileqq/app/message/C2CMessageProcessor:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   980: invokevirtual 214	com/tencent/mobileqq/app/QQAppInterface:a	()Lcom/tencent/mobileqq/service/message/MessageCache;
    //   983: aload_1
    //   984: invokevirtual 924	com/tencent/mobileqq/service/message/MessageCache:f	(Ljava/lang/String;)J
    //   987: lstore 16
    //   989: aload_3
    //   990: iconst_0
    //   991: invokeinterface 600 2 0
    //   996: checkcast 135	msf/msgcomm/msg_comm$Msg
    //   999: getfield 139	msf/msgcomm/msg_comm$Msg:msg_head	Lmsf/msgcomm/msg_comm$MsgHead;
    //   1002: invokevirtual 144	msf/msgcomm/msg_comm$MsgHead:get	()Lcom/tencent/mobileqq/pb/MessageMicro;
    //   1005: checkcast 141	msf/msgcomm/msg_comm$MsgHead
    //   1008: getfield 194	msf/msgcomm/msg_comm$MsgHead:msg_time	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   1011: invokevirtual 198	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   1014: i2l
    //   1015: lstore 18
    //   1017: invokestatic 160	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1020: ifeq +62 -> 1082
    //   1023: ldc 162
    //   1025: iconst_2
    //   1026: new 107	java/lang/StringBuilder
    //   1029: dup
    //   1030: invokespecial 108	java/lang/StringBuilder:<init>	()V
    //   1033: ldc_w 926
    //   1036: invokevirtual 168	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1039: aload_1
    //   1040: invokevirtual 168	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1043: ldc_w 928
    //   1046: invokevirtual 168	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1049: lload 16
    //   1051: invokevirtual 230	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1054: ldc_w 930
    //   1057: invokevirtual 168	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1060: lload 18
    //   1062: invokevirtual 230	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1065: ldc_w 860
    //   1068: invokevirtual 168	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1071: iload 4
    //   1073: invokevirtual 171	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1076: invokevirtual 176	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1079: invokestatic 179	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1082: lload 16
    //   1084: lconst_0
    //   1085: lcmp
    //   1086: ifeq +11 -> 1097
    //   1089: lload 18
    //   1091: lload 16
    //   1093: lcmp
    //   1094: ifge +35 -> 1129
    //   1097: aload_0
    //   1098: getfield 63	com/tencent/mobileqq/app/message/C2CMessageProcessor:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   1101: invokevirtual 214	com/tencent/mobileqq/app/QQAppInterface:a	()Lcom/tencent/mobileqq/service/message/MessageCache;
    //   1104: aload_1
    //   1105: lload 18
    //   1107: lconst_0
    //   1108: invokevirtual 933	com/tencent/mobileqq/service/message/MessageCache:b	(Ljava/lang/String;JJ)V
    //   1111: iload 4
    //   1113: ifle +16 -> 1129
    //   1116: aload_0
    //   1117: getfield 63	com/tencent/mobileqq/app/message/C2CMessageProcessor:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   1120: invokevirtual 214	com/tencent/mobileqq/app/QQAppInterface:a	()Lcom/tencent/mobileqq/service/message/MessageCache;
    //   1123: aload_1
    //   1124: lload 18
    //   1126: invokevirtual 935	com/tencent/mobileqq/service/message/MessageCache:f	(Ljava/lang/String;J)V
    //   1129: iload 4
    //   1131: ifne +13 -> 1144
    //   1134: aload_0
    //   1135: getfield 63	com/tencent/mobileqq/app/message/C2CMessageProcessor:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   1138: invokevirtual 214	com/tencent/mobileqq/app/QQAppInterface:a	()Lcom/tencent/mobileqq/service/message/MessageCache;
    //   1141: invokevirtual 937	com/tencent/mobileqq/service/message/MessageCache:c	()V
    //   1144: iload 9
    //   1146: ifeq +193 -> 1339
    //   1149: iload 5
    //   1151: sipush 1006
    //   1154: if_icmpne +1032 -> 2186
    //   1157: aload_0
    //   1158: getfield 63	com/tencent/mobileqq/app/message/C2CMessageProcessor:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   1161: bipush 10
    //   1163: invokevirtual 391	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   1166: checkcast 939	com/tencent/mobileqq/model/PhoneContactManager
    //   1169: aload_1
    //   1170: invokeinterface 941 2 0
    //   1175: astore_2
    //   1176: aload_2
    //   1177: ifnull +1009 -> 2186
    //   1180: aload_2
    //   1181: astore_1
    //   1182: invokestatic 160	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1185: ifeq +51 -> 1236
    //   1188: ldc 162
    //   1190: iconst_2
    //   1191: new 107	java/lang/StringBuilder
    //   1194: dup
    //   1195: invokespecial 108	java/lang/StringBuilder:<init>	()V
    //   1198: ldc_w 943
    //   1201: invokevirtual 168	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1204: aload_1
    //   1205: invokevirtual 168	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1208: ldc_w 945
    //   1211: invokevirtual 168	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1214: iload 5
    //   1216: invokevirtual 171	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1219: ldc_w 947
    //   1222: invokevirtual 168	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1225: lload 14
    //   1227: invokevirtual 230	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1230: invokevirtual 176	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1233: invokestatic 179	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1236: iload 5
    //   1238: invokestatic 950	com/tencent/mobileqq/app/message/MsgProxyUtils:a	(I)I
    //   1241: sipush 1032
    //   1244: if_icmpne +939 -> 2183
    //   1247: iconst_0
    //   1248: istore 5
    //   1250: new 952	android/os/Message
    //   1253: dup
    //   1254: invokespecial 953	android/os/Message:<init>	()V
    //   1257: astore_2
    //   1258: aload_2
    //   1259: iconst_1
    //   1260: putfield 956	android/os/Message:what	I
    //   1263: new 662	android/os/Bundle
    //   1266: dup
    //   1267: invokespecial 663	android/os/Bundle:<init>	()V
    //   1270: astore_3
    //   1271: aload_3
    //   1272: ldc_w 958
    //   1275: lload 14
    //   1277: invokevirtual 751	android/os/Bundle:putLong	(Ljava/lang/String;J)V
    //   1280: aload_3
    //   1281: ldc_w 960
    //   1284: aload_1
    //   1285: invokevirtual 674	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   1288: aload_3
    //   1289: ldc_w 962
    //   1292: iload 5
    //   1294: invokevirtual 669	android/os/Bundle:putInt	(Ljava/lang/String;I)V
    //   1297: aload_2
    //   1298: aload_3
    //   1299: invokevirtual 966	android/os/Message:setData	(Landroid/os/Bundle;)V
    //   1302: aload_0
    //   1303: getfield 515	com/tencent/mobileqq/app/message/C2CMessageProcessor:jdField_a_of_type_ComTencentMobileqqAppMessageHandler	Lcom/tencent/mobileqq/app/MessageHandler;
    //   1306: astore_3
    //   1307: iload 4
    //   1309: ifgt +209 -> 1518
    //   1312: iconst_1
    //   1313: istore 8
    //   1315: aload_3
    //   1316: aload_2
    //   1317: iload 8
    //   1319: invokevirtual 969	com/tencent/mobileqq/app/MessageHandler:a	(Landroid/os/Message;Z)V
    //   1322: iload 6
    //   1324: iconst_2
    //   1325: if_icmpne +199 -> 1524
    //   1328: aload_0
    //   1329: getfield 33	com/tencent/mobileqq/app/message/C2CMessageProcessor:jdField_b_of_type_JavaUtilSet	Ljava/util/Set;
    //   1332: aload_1
    //   1333: invokeinterface 970 2 0
    //   1338: pop
    //   1339: iload 7
    //   1341: iconst_1
    //   1342: iadd
    //   1343: istore 7
    //   1345: goto -674 -> 671
    //   1348: aload_0
    //   1349: getfield 63	com/tencent/mobileqq/app/message/C2CMessageProcessor:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   1352: invokevirtual 214	com/tencent/mobileqq/app/QQAppInterface:a	()Lcom/tencent/mobileqq/service/message/MessageCache;
    //   1355: aload_2
    //   1356: invokevirtual 973	com/tencent/mobileqq/service/message/MessageCache:a	([B)V
    //   1359: aload_0
    //   1360: getfield 63	com/tencent/mobileqq/app/message/C2CMessageProcessor:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   1363: invokevirtual 214	com/tencent/mobileqq/app/QQAppInterface:a	()Lcom/tencent/mobileqq/service/message/MessageCache;
    //   1366: aload_2
    //   1367: invokevirtual 975	com/tencent/mobileqq/service/message/MessageCache:b	([B)V
    //   1370: aload_0
    //   1371: getfield 515	com/tencent/mobileqq/app/message/C2CMessageProcessor:jdField_a_of_type_ComTencentMobileqqAppMessageHandler	Lcom/tencent/mobileqq/app/MessageHandler;
    //   1374: iconst_0
    //   1375: invokevirtual 977	com/tencent/mobileqq/app/MessageHandler:b	(Z)V
    //   1378: aload_0
    //   1379: getfield 515	com/tencent/mobileqq/app/message/C2CMessageProcessor:jdField_a_of_type_ComTencentMobileqqAppMessageHandler	Lcom/tencent/mobileqq/app/MessageHandler;
    //   1382: iconst_0
    //   1383: invokevirtual 979	com/tencent/mobileqq/app/MessageHandler:c	(Z)V
    //   1386: goto -918 -> 468
    //   1389: aload_0
    //   1390: getfield 63	com/tencent/mobileqq/app/message/C2CMessageProcessor:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   1393: invokevirtual 214	com/tencent/mobileqq/app/QQAppInterface:a	()Lcom/tencent/mobileqq/service/message/MessageCache;
    //   1396: aload_2
    //   1397: invokevirtual 973	com/tencent/mobileqq/service/message/MessageCache:a	([B)V
    //   1400: aload_0
    //   1401: getfield 515	com/tencent/mobileqq/app/message/C2CMessageProcessor:jdField_a_of_type_ComTencentMobileqqAppMessageHandler	Lcom/tencent/mobileqq/app/MessageHandler;
    //   1404: iconst_0
    //   1405: invokevirtual 977	com/tencent/mobileqq/app/MessageHandler:b	(Z)V
    //   1408: goto -940 -> 468
    //   1411: aload_0
    //   1412: getfield 63	com/tencent/mobileqq/app/message/C2CMessageProcessor:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   1415: invokevirtual 214	com/tencent/mobileqq/app/QQAppInterface:a	()Lcom/tencent/mobileqq/service/message/MessageCache;
    //   1418: aload 21
    //   1420: invokevirtual 975	com/tencent/mobileqq/service/message/MessageCache:b	([B)V
    //   1423: aload_0
    //   1424: getfield 515	com/tencent/mobileqq/app/message/C2CMessageProcessor:jdField_a_of_type_ComTencentMobileqqAppMessageHandler	Lcom/tencent/mobileqq/app/MessageHandler;
    //   1427: iconst_0
    //   1428: invokevirtual 979	com/tencent/mobileqq/app/MessageHandler:c	(Z)V
    //   1431: goto -963 -> 468
    //   1434: iconst_0
    //   1435: istore 8
    //   1437: goto -674 -> 763
    //   1440: aload_3
    //   1441: invokeinterface 91 1 0
    //   1446: invokestatic 99	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1449: astore_1
    //   1450: goto -625 -> 825
    //   1453: astore_1
    //   1454: aload 21
    //   1456: monitorexit
    //   1457: aload_1
    //   1458: athrow
    //   1459: astore_1
    //   1460: invokestatic 160	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1463: ifeq -124 -> 1339
    //   1466: ldc 162
    //   1468: iconst_2
    //   1469: new 107	java/lang/StringBuilder
    //   1472: dup
    //   1473: invokespecial 108	java/lang/StringBuilder:<init>	()V
    //   1476: ldc_w 981
    //   1479: invokevirtual 168	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1482: aload_1
    //   1483: invokevirtual 495	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   1486: invokevirtual 176	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1489: aload_1
    //   1490: invokestatic 825	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   1493: goto -154 -> 1339
    //   1496: aload_0
    //   1497: getfield 63	com/tencent/mobileqq/app/message/C2CMessageProcessor:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   1500: invokevirtual 364	com/tencent/mobileqq/app/QQAppInterface:a	()Lcom/tencent/mobileqq/app/message/QQMessageFacade;
    //   1503: aload_2
    //   1504: iconst_0
    //   1505: invokevirtual 984	com/tencent/mobileqq/app/message/QQMessageFacade:a	(Ljava/lang/String;I)Lcom/tencent/mobileqq/app/message/QQMessageFacade$Message;
    //   1508: getfield 987	com/tencent/mobileqq/app/message/QQMessageFacade$Message:istroop	I
    //   1511: istore 5
    //   1513: aload_2
    //   1514: astore_1
    //   1515: goto -371 -> 1144
    //   1518: iconst_0
    //   1519: istore 8
    //   1521: goto -206 -> 1315
    //   1524: aload_0
    //   1525: getfield 31	com/tencent/mobileqq/app/message/C2CMessageProcessor:jdField_a_of_type_JavaUtilSet	Ljava/util/Set;
    //   1528: aload_1
    //   1529: invokeinterface 970 2 0
    //   1534: pop
    //   1535: goto -196 -> 1339
    //   1538: iload 4
    //   1540: ifgt +536 -> 2076
    //   1543: aload_0
    //   1544: getfield 515	com/tencent/mobileqq/app/message/C2CMessageProcessor:jdField_a_of_type_ComTencentMobileqqAppMessageHandler	Lcom/tencent/mobileqq/app/MessageHandler;
    //   1547: invokevirtual 989	com/tencent/mobileqq/app/MessageHandler:d	()V
    //   1550: iload 9
    //   1552: ifeq +444 -> 1996
    //   1555: aload_0
    //   1556: getfield 63	com/tencent/mobileqq/app/message/C2CMessageProcessor:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   1559: invokevirtual 992	com/tencent/mobileqq/app/QQAppInterface:a	()Lcom/tencent/mobileqq/app/message/ConversationFacade;
    //   1562: invokevirtual 996	com/tencent/mobileqq/app/message/ConversationFacade:a	()Ljava/util/Set;
    //   1565: invokeinterface 502 1 0
    //   1570: astore_1
    //   1571: aload_1
    //   1572: invokeinterface 251 1 0
    //   1577: ifeq +404 -> 1981
    //   1580: aload_1
    //   1581: invokeinterface 255 1 0
    //   1586: checkcast 998	com/tencent/mobileqq/data/ConversationInfo
    //   1589: astore_2
    //   1590: aload_2
    //   1591: getfield 1001	com/tencent/mobileqq/data/ConversationInfo:uin	Ljava/lang/String;
    //   1594: ifnull -23 -> 1571
    //   1597: aload_2
    //   1598: getfield 1004	com/tencent/mobileqq/data/ConversationInfo:type	I
    //   1601: invokestatic 950	com/tencent/mobileqq/app/message/MsgProxyUtils:a	(I)I
    //   1604: sipush 1032
    //   1607: if_icmpeq -36 -> 1571
    //   1610: iload 6
    //   1612: iconst_1
    //   1613: if_icmpne +13 -> 1626
    //   1616: aload_2
    //   1617: getfield 1004	com/tencent/mobileqq/data/ConversationInfo:type	I
    //   1620: sipush 1008
    //   1623: if_icmpeq -52 -> 1571
    //   1626: iload 6
    //   1628: iconst_2
    //   1629: if_icmpne +13 -> 1642
    //   1632: aload_2
    //   1633: getfield 1004	com/tencent/mobileqq/data/ConversationInfo:type	I
    //   1636: sipush 1008
    //   1639: if_icmpne -68 -> 1571
    //   1642: iload 6
    //   1644: iconst_2
    //   1645: if_icmpeq +31 -> 1676
    //   1648: aload_0
    //   1649: getfield 31	com/tencent/mobileqq/app/message/C2CMessageProcessor:jdField_a_of_type_JavaUtilSet	Ljava/util/Set;
    //   1652: invokeinterface 1005 1 0
    //   1657: ifle +19 -> 1676
    //   1660: aload_0
    //   1661: getfield 31	com/tencent/mobileqq/app/message/C2CMessageProcessor:jdField_a_of_type_JavaUtilSet	Ljava/util/Set;
    //   1664: aload_2
    //   1665: getfield 1001	com/tencent/mobileqq/data/ConversationInfo:uin	Ljava/lang/String;
    //   1668: invokeinterface 1008 2 0
    //   1673: ifne -102 -> 1571
    //   1676: iload 6
    //   1678: iconst_2
    //   1679: if_icmpne +31 -> 1710
    //   1682: aload_0
    //   1683: getfield 33	com/tencent/mobileqq/app/message/C2CMessageProcessor:jdField_b_of_type_JavaUtilSet	Ljava/util/Set;
    //   1686: invokeinterface 1005 1 0
    //   1691: ifle +19 -> 1710
    //   1694: aload_0
    //   1695: getfield 33	com/tencent/mobileqq/app/message/C2CMessageProcessor:jdField_b_of_type_JavaUtilSet	Ljava/util/Set;
    //   1698: aload_2
    //   1699: getfield 1001	com/tencent/mobileqq/data/ConversationInfo:uin	Ljava/lang/String;
    //   1702: invokeinterface 1008 2 0
    //   1707: ifne -136 -> 1571
    //   1710: aload_2
    //   1711: getfield 1004	com/tencent/mobileqq/data/ConversationInfo:type	I
    //   1714: invokestatic 420	com/tencent/mobileqq/app/message/MsgProxyUtils:c	(I)Z
    //   1717: ifeq -146 -> 1571
    //   1720: aload_2
    //   1721: invokestatic 1011	com/tencent/mobileqq/app/message/ConversationFacade:b	(Lcom/tencent/mobileqq/data/ConversationInfo;)I
    //   1724: ifle -153 -> 1571
    //   1727: invokestatic 160	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1730: ifeq +45 -> 1775
    //   1733: ldc 162
    //   1735: iconst_2
    //   1736: new 107	java/lang/StringBuilder
    //   1739: dup
    //   1740: invokespecial 108	java/lang/StringBuilder:<init>	()V
    //   1743: ldc_w 1013
    //   1746: invokevirtual 168	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1749: aload_2
    //   1750: getfield 1001	com/tencent/mobileqq/data/ConversationInfo:uin	Ljava/lang/String;
    //   1753: invokevirtual 168	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1756: ldc_w 1015
    //   1759: invokevirtual 168	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1762: aload_2
    //   1763: getfield 1004	com/tencent/mobileqq/data/ConversationInfo:type	I
    //   1766: invokevirtual 171	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1769: invokevirtual 176	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1772: invokestatic 179	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1775: aload_2
    //   1776: getfield 1001	com/tencent/mobileqq/data/ConversationInfo:uin	Ljava/lang/String;
    //   1779: invokevirtual 683	java/lang/String:length	()I
    //   1782: iconst_4
    //   1783: if_icmple -212 -> 1571
    //   1786: aload_2
    //   1787: getfield 1004	com/tencent/mobileqq/data/ConversationInfo:type	I
    //   1790: sipush 1001
    //   1793: if_icmpne +134 -> 1927
    //   1796: aload_0
    //   1797: getfield 63	com/tencent/mobileqq/app/message/C2CMessageProcessor:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   1800: invokevirtual 214	com/tencent/mobileqq/app/QQAppInterface:a	()Lcom/tencent/mobileqq/service/message/MessageCache;
    //   1803: aload_2
    //   1804: getfield 1001	com/tencent/mobileqq/data/ConversationInfo:uin	Ljava/lang/String;
    //   1807: invokevirtual 1018	com/tencent/mobileqq/service/message/MessageCache:m	(Ljava/lang/String;)[B
    //   1810: astore_3
    //   1811: aload_3
    //   1812: ifnull -241 -> 1571
    //   1815: aload_3
    //   1816: arraylength
    //   1817: ifle -246 -> 1571
    //   1820: invokestatic 160	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1823: ifeq +29 -> 1852
    //   1826: ldc 162
    //   1828: iconst_2
    //   1829: new 107	java/lang/StringBuilder
    //   1832: dup
    //   1833: invokespecial 108	java/lang/StringBuilder:<init>	()V
    //   1836: ldc_w 1020
    //   1839: invokevirtual 168	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1842: aload_3
    //   1843: invokevirtual 495	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   1846: invokevirtual 176	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1849: invokestatic 179	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1852: new 952	android/os/Message
    //   1855: dup
    //   1856: invokespecial 953	android/os/Message:<init>	()V
    //   1859: astore_3
    //   1860: aload_3
    //   1861: iconst_1
    //   1862: putfield 956	android/os/Message:what	I
    //   1865: new 662	android/os/Bundle
    //   1868: dup
    //   1869: invokespecial 663	android/os/Bundle:<init>	()V
    //   1872: astore 20
    //   1874: aload 20
    //   1876: ldc_w 958
    //   1879: ldc2_w 1021
    //   1882: invokevirtual 751	android/os/Bundle:putLong	(Ljava/lang/String;J)V
    //   1885: aload 20
    //   1887: ldc_w 960
    //   1890: aload_2
    //   1891: getfield 1001	com/tencent/mobileqq/data/ConversationInfo:uin	Ljava/lang/String;
    //   1894: invokevirtual 674	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   1897: aload 20
    //   1899: ldc_w 962
    //   1902: aload_2
    //   1903: getfield 1004	com/tencent/mobileqq/data/ConversationInfo:type	I
    //   1906: invokevirtual 669	android/os/Bundle:putInt	(Ljava/lang/String;I)V
    //   1909: aload_3
    //   1910: aload 20
    //   1912: invokevirtual 966	android/os/Message:setData	(Landroid/os/Bundle;)V
    //   1915: aload_0
    //   1916: getfield 515	com/tencent/mobileqq/app/message/C2CMessageProcessor:jdField_a_of_type_ComTencentMobileqqAppMessageHandler	Lcom/tencent/mobileqq/app/MessageHandler;
    //   1919: aload_3
    //   1920: iconst_1
    //   1921: invokevirtual 969	com/tencent/mobileqq/app/MessageHandler:a	(Landroid/os/Message;Z)V
    //   1924: goto -353 -> 1571
    //   1927: aload_2
    //   1928: getfield 1004	com/tencent/mobileqq/data/ConversationInfo:type	I
    //   1931: sipush 10002
    //   1934: if_icmpne +21 -> 1955
    //   1937: invokestatic 160	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1940: ifeq -88 -> 1852
    //   1943: ldc 162
    //   1945: iconst_2
    //   1946: ldc_w 1024
    //   1949: invokestatic 179	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1952: goto -100 -> 1852
    //   1955: aload_2
    //   1956: getfield 1027	com/tencent/mobileqq/data/ConversationInfo:isImax	Z
    //   1959: ifeq -107 -> 1852
    //   1962: invokestatic 160	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1965: ifeq -394 -> 1571
    //   1968: ldc_w 1029
    //   1971: iconst_2
    //   1972: ldc_w 1031
    //   1975: invokestatic 179	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1978: goto -407 -> 1571
    //   1981: iload 6
    //   1983: iconst_2
    //   1984: if_icmpne +142 -> 2126
    //   1987: aload_0
    //   1988: getfield 33	com/tencent/mobileqq/app/message/C2CMessageProcessor:jdField_b_of_type_JavaUtilSet	Ljava/util/Set;
    //   1991: invokeinterface 1034 1 0
    //   1996: invokestatic 1039	com/tencent/util/MsgAutoMonitorUtil:a	()Lcom/tencent/util/MsgAutoMonitorUtil;
    //   1999: invokevirtual 1041	com/tencent/util/MsgAutoMonitorUtil:e	()V
    //   2002: iload 6
    //   2004: tableswitch	default:+28 -> 2032, 0:+134->2138, 1:+155->2159, 2:+167->2171
    //   2033: getfield 63	com/tencent/mobileqq/app/message/C2CMessageProcessor:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   2036: invokevirtual 214	com/tencent/mobileqq/app/QQAppInterface:a	()Lcom/tencent/mobileqq/service/message/MessageCache;
    //   2039: invokevirtual 1043	com/tencent/mobileqq/service/message/MessageCache:i	()V
    //   2042: aload_0
    //   2043: getfield 515	com/tencent/mobileqq/app/message/C2CMessageProcessor:jdField_a_of_type_ComTencentMobileqqAppMessageHandler	Lcom/tencent/mobileqq/app/MessageHandler;
    //   2046: invokevirtual 853	com/tencent/mobileqq/app/MessageHandler:a	()Z
    //   2049: ifeq +27 -> 2076
    //   2052: invokestatic 160	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   2055: ifeq +12 -> 2067
    //   2058: ldc 162
    //   2060: iconst_2
    //   2061: ldc_w 1045
    //   2064: invokestatic 179	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   2067: aload_0
    //   2068: getfield 515	com/tencent/mobileqq/app/message/C2CMessageProcessor:jdField_a_of_type_ComTencentMobileqqAppMessageHandler	Lcom/tencent/mobileqq/app/MessageHandler;
    //   2071: iconst_0
    //   2072: iconst_0
    //   2073: invokevirtual 1048	com/tencent/mobileqq/app/MessageHandler:a	(ZI)V
    //   2076: invokestatic 776	java/lang/System:currentTimeMillis	()J
    //   2079: lload 12
    //   2081: lsub
    //   2082: lstore 12
    //   2084: invokestatic 160	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   2087: ifeq +30 -> 2117
    //   2090: ldc 162
    //   2092: iconst_2
    //   2093: new 107	java/lang/StringBuilder
    //   2096: dup
    //   2097: invokespecial 108	java/lang/StringBuilder:<init>	()V
    //   2100: ldc_w 1050
    //   2103: invokevirtual 168	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2106: lload 12
    //   2108: invokevirtual 230	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   2111: invokevirtual 176	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2114: invokestatic 179	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   2117: ldc_w 1052
    //   2120: lload 12
    //   2122: invokestatic 1054	com/tencent/mobileqq/app/message/MessageStatisticHelper:a	(Ljava/lang/String;J)V
    //   2125: return
    //   2126: aload_0
    //   2127: getfield 31	com/tencent/mobileqq/app/message/C2CMessageProcessor:jdField_a_of_type_JavaUtilSet	Ljava/util/Set;
    //   2130: invokeinterface 1034 1 0
    //   2135: goto -139 -> 1996
    //   2138: aload_0
    //   2139: sipush 4016
    //   2142: iconst_1
    //   2143: aconst_null
    //   2144: invokevirtual 761	com/tencent/mobileqq/app/message/C2CMessageProcessor:a	(IZLjava/lang/Object;)V
    //   2147: aload_0
    //   2148: sipush 4001
    //   2151: iconst_1
    //   2152: aconst_null
    //   2153: invokevirtual 761	com/tencent/mobileqq/app/message/C2CMessageProcessor:a	(IZLjava/lang/Object;)V
    //   2156: goto -124 -> 2032
    //   2159: aload_0
    //   2160: sipush 4001
    //   2163: iconst_1
    //   2164: aconst_null
    //   2165: invokevirtual 761	com/tencent/mobileqq/app/message/C2CMessageProcessor:a	(IZLjava/lang/Object;)V
    //   2168: goto -136 -> 2032
    //   2171: aload_0
    //   2172: sipush 4016
    //   2175: iconst_1
    //   2176: aconst_null
    //   2177: invokevirtual 761	com/tencent/mobileqq/app/message/C2CMessageProcessor:a	(IZLjava/lang/Object;)V
    //   2180: goto -148 -> 2032
    //   2183: goto -933 -> 1250
    //   2186: goto -1004 -> 1182
    //   2189: iconst_0
    //   2190: istore 4
    //   2192: goto -1803 -> 389
    //   2195: iconst_2
    //   2196: istore 5
    //   2198: goto -1819 -> 379
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	2201	0	this	C2CMessageProcessor
    //   0	2201	1	paramToServiceMsg	ToServiceMsg
    //   0	2201	2	paramFromServiceMsg	FromServiceMsg
    //   0	2201	3	paramObject	Object
    //   387	1804	4	b1	byte
    //   377	1820	5	n	int
    //   417	1586	6	i1	int
    //   669	675	7	i2	int
    //   469	1051	8	bool1	boolean
    //   11	1540	9	bool2	boolean
    //   37	906	10	bool3	boolean
    //   24	588	11	bool4	boolean
    //   42	2079	12	l1	long
    //   727	549	14	l2	long
    //   987	105	16	l3	long
    //   1015	110	18	l4	long
    //   51	151	20	localPbGetMsgResp	msf.msgsvc.msg_svc.PbGetMsgResp
    //   260	15	20	localException	Exception
    //   280	1631	20	localObject1	Object
    //   114	722	22	localStringBuilder	StringBuilder
    //   348	341	23	localList	List
    // Exception table:
    //   from	to	target	type
    //   53	70	260	java/lang/Exception
    //   932	971	1453	finally
    //   1454	1457	1453	finally
    //   918	932	1459	java/lang/Exception
    //   1457	1459	1459	java/lang/Exception
  }
  
  private void a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, boolean paramBoolean)
  {
    paramFromServiceMsg = new HashMap(1);
    paramFromServiceMsg.put("KEYWORD", paramToServiceMsg.extraData.getString("keyword"));
    paramFromServiceMsg.put("SEARCHSEQUENCE", Long.valueOf(paramToServiceMsg.extraData.getLong("sequence")));
    paramFromServiceMsg.put("LOADTYPE", Integer.valueOf(paramToServiceMsg.extraData.getInt("loadType")));
    int n = paramToServiceMsg.extraData.getInt("retryIndex");
    if ((!paramBoolean) && (n < 2))
    {
      if (QLog.isColorLevel()) {
        QLog.w("Q.msg.C2CMessageProcessor", 2, "handleSearchRoamMsgInCloudTimeOutAndError retry index:" + n);
      }
      paramToServiceMsg.extraData.putInt("retryIndex", n + 1);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().b(paramToServiceMsg);
      return;
    }
    a(8015, false, paramFromServiceMsg);
  }
  
  private void a(List paramList)
  {
    if ((paramList == null) || (paramList.size() <= 0)) {}
    for (;;)
    {
      return;
      long l1 = System.currentTimeMillis() / 1000L;
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        MessageRecord localMessageRecord = (MessageRecord)paramList.next();
        if (localMessageRecord.istroop == 1008) {
          if ((!TextUtils.isEmpty(localMessageRecord.getExtInfoFromExtStr("public_account_send_flag"))) && (!TextUtils.isEmpty(localMessageRecord.getExtInfoFromExtStr("public_account_msg_id"))) && (!TextUtils.equals(localMessageRecord.frienduin, localMessageRecord.selfuin))) {
            ThreadManager.post(new zzj(this, localMessageRecord.frienduin, localMessageRecord.selfuin, localMessageRecord.getExtInfoFromExtStr("public_account_msg_id"), localMessageRecord.time, l1, localMessageRecord.getExtInfoFromExtStr("public_account_send_flag")), 5, null, false);
          } else if (QLog.isColorLevel()) {
            QLog.d("Q.msg.C2CMessageProcessor", 2, "reportPubAccMsg exception, public_account_send_flag null || public_account_msg_id null || ");
          }
        }
      }
    }
  }
  
  private void a(List paramList1, List paramList2)
  {
    Pair localPair = super.a(paramList1, paramList2);
    if ((((Boolean)localPair.first).booleanValue()) && (QLog.isColorLevel()))
    {
      StringBuilder localStringBuilder = new StringBuilder("<---C2CMessagePackage:msgFilter_OnePkg ");
      localStringBuilder.append((CharSequence)localPair.second);
      localStringBuilder.append(" inListSize:").append(paramList1.size()).append(" outListSize:").append(paramList2.size());
      QLog.d("Q.msg.C2CMessageProcessor", 2, localStringBuilder.toString());
    }
  }
  
  private void a(msg_comm.Msg paramMsg, FromServiceMsg paramFromServiceMsg, msg_onlinepush.PbPushMsg paramPbPushMsg)
  {
    msg_comm.MsgHead localMsgHead = (msg_comm.MsgHead)paramMsg.msg_head.get();
    if (!localMsgHead.c2c_cmd.has()) {
      if (QLog.isColorLevel()) {
        QLog.d("Q.msg.C2CMessageProcessor", 2, "<---handleMsgPush_PB_C2CPush: no C2CCmd.");
      }
    }
    long l1;
    long l2;
    int n;
    int i1;
    Object localObject1;
    long l7;
    Object localObject2;
    boolean bool2;
    boolean bool3;
    for (;;)
    {
      return;
      l1 = localMsgHead.c2c_cmd.get();
      l2 = localMsgHead.from_uin.get();
      long l3 = localMsgHead.to_uin.get();
      long l4 = localMsgHead.msg_seq.get();
      long l5 = localMsgHead.msg_time.get();
      long l6 = localMsgHead.msg_uid.get();
      n = localMsgHead.user_active.get();
      i1 = localMsgHead.from_instid.get();
      if (paramFromServiceMsg.getUin() == null)
      {
        localObject1 = Long.valueOf(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
        l7 = ((Long)localObject1).longValue();
        if (QLog.isColorLevel()) {
          QLog.d("Q.msg.C2CMessageProcessor", 2, "<---handleMsgPush_PB_C2CPush:fromUin:" + l2 + ",toUin:" + l3 + ",msgTime:" + l5 + ",msgSeq:" + l4 + ",msgUid:" + l6 + ",userActive:" + n + ",fromInstid:" + i1 + ",hasAppShare:" + paramMsg.appshare_info.has() + ",hasMsgBody:" + paramMsg.msg_body.has());
        }
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.jdField_a_of_type_Int = n;
        localObject1 = new ArrayList();
      }
      try
      {
        localObject2 = new DecodeProtoPkgContext(l7, l2, true, false, false, false);
        ((DecodeProtoPkgContext)localObject2).h = true;
        paramMsg = a(paramMsg, (PBDecodeContext)localObject2);
        MessageHandlerUtils.a(paramMsg);
        if ((paramMsg != null) && (paramMsg.size() != 0))
        {
          if (localObject1 != null) {
            a(paramMsg, (ArrayList)localObject1, true);
          }
          paramMsg = new ArrayList();
          localObject2 = new ArrayList();
          if ((localObject1 != null) && (((ArrayList)localObject1).size() > 0))
          {
            i1 = ((ArrayList)localObject1).size();
            n = 0;
            for (;;)
            {
              if (n < i1)
              {
                localMessageRecord = (MessageRecord)((ArrayList)localObject1).get(n);
                if (QLog.isColorLevel()) {
                  QLog.d("Q.msg.C2CMessageProcessor", 2, "----------handleMsgPush_PB_C2CPush after analysis mr.senderuin: " + localMessageRecord.senderuin + " mr.msgtype: " + localMessageRecord.msgtype + " mr.frienduin: " + localMessageRecord.frienduin + " mr.shmsgseq: " + localMessageRecord.shmsgseq + " mr.time:" + localMessageRecord.time + " mr.msg: " + localMessageRecord.getLogColorContent());
                }
                if ((localMessageRecord.frienduin == null) || (localMessageRecord.frienduin.length() <= 2))
                {
                  n += 1;
                  continue;
                  localObject1 = Long.valueOf(paramFromServiceMsg.getUin());
                }
              }
            }
          }
        }
      }
      catch (Exception paramMsg)
      {
        for (;;)
        {
          MessageRecord localMessageRecord;
          if (QLog.isColorLevel()) {
            QLog.w("Q.msg.C2CMessageProcessor", 2, "handleMsgPush_PB_C2CPush decodeSinglePBMsg_C2C error,", paramMsg);
          }
          paramMsg = null;
          continue;
          localMessageRecord.isread = false;
          ((ArrayList)localObject2).add(localMessageRecord);
          DelMsgInfo localDelMsgInfo = new DelMsgInfo();
          localDelMsgInfo.lFromUin = Long.parseLong(localMessageRecord.senderuin);
          localDelMsgInfo.shMsgSeq = ((short)(int)localMessageRecord.shmsgseq);
          localDelMsgInfo.uMsgTime = localMessageRecord.time;
          paramMsg.add(localDelMsgInfo);
        }
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().b((List)localObject2);
        bool2 = MessageHandlerUtils.a((ArrayList)localObject2);
        bool3 = MessageHandlerUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (ArrayList)localObject2);
        n = MsgProxyUtils.a((List)localObject1, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
        localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a();
        if (!bool2) {
          break label874;
        }
      }
    }
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.isBackground_Stop) {}
    label874:
    for (boolean bool1 = true;; bool1 = false)
    {
      ((QQMessageFacade)localObject1).a((ArrayList)localObject2, String.valueOf(l7), bool1);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(localMsgHead.msg_seq.get());
      i1 = paramFromServiceMsg.getRequestSsoSeq();
      paramFromServiceMsg = paramPbPushMsg.bytes_push_token.get().toStringUtf8();
      if (QLog.isColorLevel()) {
        QLog.d("Q.msg.C2CMessageProcessor", 2, new Object[] { "----------handleMsgPush_PB_C2CPush get Push token = ", paramFromServiceMsg, " and use ", "OnlinePush.RespPush", " send back to server" });
      }
      this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler.a(l2, paramMsg, paramPbPushMsg.svrip.get(), i1, paramPbPushMsg);
      if (l1 == 127L) {
        break;
      }
      a("handleMsgPush_PB_C2CPush", true, n, this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler.a(bool2, bool3), false);
      this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler.b((ArrayList)localObject2);
      return;
    }
  }
  
  private void a(byte[] paramArrayOfByte)
  {
    long l1 = PkgTools.a(paramArrayOfByte, 0);
    String str = String.valueOf(l1);
    PkgTools.a(paramArrayOfByte, 10);
    int n = PkgTools.a(paramArrayOfByte, 16);
    Object localObject = null;
    if (n > 0) {
      localObject = PkgTools.a(paramArrayOfByte, 18, n);
    }
    if (QLog.isColorLevel()) {
      QLog.i("Q.msg.C2CMessageProcessor", 2, "----->handleHotChatAnnouncementMsg dwGroupCode = " + l1 + ", len = " + n + ", announcement = " + (String)localObject);
    }
    paramArrayOfByte = (HotChatHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(35);
    localObject = (HotChatManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(59);
    if ((paramArrayOfByte != null) && (localObject != null))
    {
      localObject = ((HotChatManager)localObject).a(str);
      if (localObject != null)
      {
        if (((HotChatInfo)localObject).userCreate != 1) {
          break label162;
        }
        paramArrayOfByte.b(str);
      }
    }
    return;
    label162:
    paramArrayOfByte.a(((HotChatInfo)localObject).uuid.getBytes(), str);
  }
  
  private void b(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg)
  {
    paramFromServiceMsg = new Bundle();
    paramFromServiceMsg.putLong("BEGTIME", paramToServiceMsg.extraData.getLong("lBeginTime"));
    paramFromServiceMsg.putBoolean("FETCH_MORE", paramToServiceMsg.extraData.getBoolean("fetchMore"));
    a(1004, false, paramFromServiceMsg);
  }
  
  private void b(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    paramFromServiceMsg = new msg_svc.PbGetRoamMsgResp();
    try
    {
      paramFromServiceMsg = (msg_svc.PbGetRoamMsgResp)paramFromServiceMsg.mergeFrom((byte[])paramObject);
      localObject4 = Long.valueOf(paramToServiceMsg.extraData.getLong("lBeginTime"));
      bool1 = paramToServiceMsg.extraData.getBoolean("fetchMore");
      i2 = paramToServiceMsg.extraData.getInt("fetchNum");
      bool2 = paramToServiceMsg.extraData.getBoolean("preloadType");
      paramObject = new Bundle();
      paramObject.putLong("BEGTIME", ((Long)localObject4).longValue());
      paramObject.putBoolean("FETCH_MORE", bool1);
      paramObject.putInt("MSG_COUNT", i2);
      paramObject.putString("PEER_UIN", paramToServiceMsg.extraData.getString("peerUin"));
      paramObject.putBoolean("IS_PRELOAD_TYPE", bool2);
      if (paramFromServiceMsg != null)
      {
        str = String.valueOf(paramFromServiceMsg.peer_uin.get());
        i1 = paramFromServiceMsg.result.get();
        localObject1 = paramFromServiceMsg.msg.get();
        if (localObject1 == null)
        {
          if (this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler.a.containsKey(str)) {
            this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler.a.remove(str);
          }
          if (QLog.isColorLevel()) {
            QLog.w("Q.msg.C2CMessageProcessor", 2, "handlePBGetRoamMsg code=" + i1 + ", msgList is null !");
          }
          a(1004, false, paramObject);
          return;
        }
      }
    }
    catch (InvalidProtocolBufferMicroException paramFromServiceMsg)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.w("Q.msg.C2CMessageProcessor", 2, "handlePBGetRoamMsg InvalidProtocolBufferMicroException ! ", paramFromServiceMsg);
        }
        paramFromServiceMsg = null;
      }
    }
    catch (OutOfMemoryError paramFromServiceMsg)
    {
      Object localObject4;
      boolean bool1;
      int i2;
      boolean bool2;
      String str;
      int i1;
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.w("Q.msg.C2CMessageProcessor", 2, "handlePBGetRoamMsg OutOfMemoryError ! ", paramFromServiceMsg);
        }
        paramFromServiceMsg = null;
      }
      ArrayList localArrayList = new ArrayList();
      a((List)localObject1, localArrayList);
      if (QLog.isColorLevel()) {
        QLog.d("Q.msg.C2CMessageProcessor", 2, "handlePBGetRoamMsg begTime: " + localObject4 + ", code=" + i1 + " ,errMsg=" + paramFromServiceMsg.errmsg.get() + ", msgList.size()=" + localArrayList.size() + ",peerUin=" + str + ",time=" + paramFromServiceMsg.last_msgtime.get() + ",fetchMore:" + bool1 + ",fetchNum: " + i2);
      }
      Object localObject1 = (MessageRoamManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(91);
      int n = 0;
      if (((i1 != 0) && (i1 != 1)) || (i1 == 0)) {}
      for (;;)
      {
        try
        {
          if (localArrayList.size() > 0)
          {
            if (!this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler.a.containsKey(str)) {
              continue;
            }
            localObject2 = (List)this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler.a.get(str);
            if (((List)localObject2).size() == 0) {
              ((List)localObject2).addAll(0, localArrayList);
            }
          }
          else
          {
            this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler.a(str, ((Long)localObject4).longValue(), paramFromServiceMsg.last_msgtime.get(), paramToServiceMsg.extraData.getLong("lEndTime"), (short)0, paramFromServiceMsg.random.get(), 1, ((MessageRoamManager)localObject1).a(), ((MessageRoamManager)localObject1).b(), paramToServiceMsg.extraData.getBoolean("fetchMore"), i2, bool2);
            return;
          }
        }
        catch (Exception paramToServiceMsg)
        {
          if (QLog.isColorLevel()) {
            QLog.w("Q.msg.C2CMessageProcessor", 2, "handlePBGetRoamMsg exception ! ", paramToServiceMsg);
          }
          n = 0;
          if (n != 0) {
            break;
          }
          if (this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler.a.containsKey(str)) {
            this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler.a.remove(str);
          }
          paramObject.putInt("SVR_CODE", i1);
          if (paramFromServiceMsg.errmsg.has()) {
            paramObject.putString("SVR_MSG", paramFromServiceMsg.errmsg.get());
          }
          a(1004, false, paramObject);
          return;
          if ((((msg_comm.MsgHead)((msg_comm.Msg)((List)localObject2).get(0)).msg_head.get()).msg_uid.get() == ((msg_comm.MsgHead)((msg_comm.Msg)localArrayList.get(0)).msg_head.get()).msg_uid.get()) && (((msg_comm.MsgHead)((msg_comm.Msg)((List)localObject2).get(0)).msg_head.get()).msg_seq.get() == ((msg_comm.MsgHead)((msg_comm.Msg)localArrayList.get(0)).msg_head.get()).msg_seq.get())) {
            continue;
          }
          ((List)localObject2).addAll(0, localArrayList);
          continue;
        }
        catch (OutOfMemoryError paramToServiceMsg)
        {
          if (QLog.isColorLevel()) {
            QLog.w("Q.msg.C2CMessageProcessor", 2, "handlePBGetRoamMsg OutOfMemoryError ! ", paramToServiceMsg);
          }
          n = 0;
          continue;
          this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler.a.put(str, localArrayList);
          continue;
        }
        localArrayList = new ArrayList(localArrayList);
        if (this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler.a.containsKey(str))
        {
          localArrayList.addAll((Collection)this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler.a.get(str));
          this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler.a.remove(str);
        }
        if (localArrayList.isEmpty())
        {
          new Object[2][0] = Boolean.valueOf(true);
          paramObject.putBoolean("NO_MSG", Boolean.TRUE.booleanValue());
          a(1004, false, paramObject);
          return;
        }
        long l1 = paramToServiceMsg.extraData.getLong("lBeginTime");
        long l2 = paramToServiceMsg.extraData.getLong("lEndTime");
        Object localObject2 = new ArrayList();
        Object localObject3 = localArrayList.iterator();
        while (((Iterator)localObject3).hasNext())
        {
          localObject5 = (msg_comm.Msg)((Iterator)localObject3).next();
          if (!((msg_comm.Msg)localObject5).msg_head.has())
          {
            if (QLog.isColorLevel()) {
              QLog.w("Q.msg.C2CMessageProcessor", 2, "handlePBGetRoamMsg msg msg_head = null");
            }
          }
          else
          {
            long l3 = ((msg_comm.MsgHead)((msg_comm.Msg)localObject5).msg_head.get()).msg_time.get();
            if ((l3 >= l1) && (l3 <= l2)) {
              ((ArrayList)localObject2).add(localObject5);
            }
          }
        }
        Object localObject5 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler, (List)localObject2, Long.valueOf(str).longValue(), true);
        localObject3 = new ArrayList();
        l1 = Long.parseLong(str);
        Object localObject6;
        if (!((ArrayList)localObject2).isEmpty())
        {
          localObject6 = (msg_comm.Msg)((ArrayList)localObject2).get(0);
          l1 = MessageHandlerUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, ((msg_comm.MsgHead)((msg_comm.Msg)localObject6).msg_head.get()).from_uin.get(), ((msg_comm.MsgHead)((msg_comm.Msg)localObject6).msg_head.get()).to_uin.get(), paramFromServiceMsg.peer_uin.get());
        }
        ((ArrayList)localObject3).addAll((Collection)a((List)localObject2, (List)localObject5, l1, ((Long)localObject4).longValue(), paramToServiceMsg.extraData.getLong("lEndTime")).second);
        localObject4 = new DecodeProtoPkgContext(Long.parseLong(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin()), l1, true, true, false, false);
        ((DecodeProtoPkgContext)localObject4).h = true;
        localObject5 = ((ArrayList)localObject2).iterator();
        while (((Iterator)localObject5).hasNext())
        {
          localObject6 = (msg_comm.Msg)((Iterator)localObject5).next();
          try
          {
            localObject6 = a((msg_comm.Msg)localObject6, (PBDecodeContext)localObject4);
            if ((localObject6 == null) || (((ArrayList)localObject6).isEmpty())) {
              continue;
            }
            ((ArrayList)localObject3).addAll((Collection)localObject6);
          }
          catch (Exception localException2) {}
          if (QLog.isColorLevel()) {
            QLog.w("Q.msg.C2CMessageProcessor", 2, "decodeSinglePBMsg_C2C error,", localException2);
          }
        }
        if ((localObject3 != null) && (((ArrayList)localObject3).size() > 0))
        {
          Collections.sort((List)localObject3, new zzf(this));
          if (localObject1 == null) {}
        }
        try
        {
          ((MessageRoamManager)localObject1).a((List)localObject3, str);
          this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler.a((ArrayList)localObject3, false);
          localObject4 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().b(String.valueOf(paramFromServiceMsg.peer_uin.get()));
          if ((localObject4 == null) || (((Long)((Pair)localObject4).first).longValue() > paramFromServiceMsg.last_msgtime.get())) {
            this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().b(String.valueOf(paramFromServiceMsg.peer_uin.get()), paramToServiceMsg.extraData.getLong("lBeginTime"), 0L);
          }
          ((MessageRoamManager)localObject1).a().b(str, paramToServiceMsg.extraData.getLong("lBeginTime"), 3);
          if (QLog.isColorLevel()) {
            QLog.w("Q.msg.C2CMessageProcessor", 2, "handlePBGetRoamMsg resList size = " + localArrayList.size() + ", dayList size = " + ((ArrayList)localObject2).size() + ", loopList size=" + ((ArrayList)localObject3).size());
          }
          paramObject.putInt("MSG_COUNT", i2 - ((ArrayList)localObject3).size());
          a(1004, true, paramObject);
          n = 1;
        }
        catch (Exception localException1)
        {
          for (;;)
          {
            if (QLog.isColorLevel()) {
              QLog.w("Q.msg.C2CMessageProcessor", 2, "handlePBGetRoamMsg exception ! ", localException1);
            }
          }
        }
        catch (OutOfMemoryError localOutOfMemoryError)
        {
          for (;;)
          {
            if (QLog.isColorLevel()) {
              QLog.w("Q.msg.C2CMessageProcessor", 2, "handlePBGetRoamMsg OutOfMemoryError ! ", localOutOfMemoryError);
            }
          }
        }
      }
      a(1004, false, paramObject);
    }
  }
  
  private void b(msg_comm.Msg paramMsg, FromServiceMsg paramFromServiceMsg, msg_onlinepush.PbPushMsg paramPbPushMsg)
  {
    msg_comm.MsgHead localMsgHead = (msg_comm.MsgHead)paramMsg.msg_head.get();
    if (!localMsgHead.c2c_cmd.has()) {
      if (QLog.isColorLevel()) {
        QLog.d("Q.msg.C2CMessageProcessor", 2, "<---handleMsgPush_PB_SlaveMaster: no C2CCmd.");
      }
    }
    long l1;
    Object localObject2;
    boolean bool;
    do
    {
      for (;;)
      {
        return;
        l1 = localMsgHead.c2c_cmd.get();
        long l2 = localMsgHead.from_uin.get();
        long l3 = localMsgHead.to_uin.get();
        long l4 = localMsgHead.msg_seq.get();
        long l5 = localMsgHead.msg_time.get();
        long l6 = localMsgHead.msg_uid.get();
        int n = localMsgHead.user_active.get();
        int i1 = localMsgHead.from_instid.get();
        Object localObject1;
        long l7;
        if (paramFromServiceMsg.getUin() == null)
        {
          localObject1 = Long.valueOf(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
          l7 = ((Long)localObject1).longValue();
          if (QLog.isColorLevel()) {
            QLog.d("Q.msg.C2CMessageProcessor", 2, "<---handleMsgPush_PB_SlaveMaster:fromUin:" + l2 + ",toUin:" + l3 + ",msgTime:" + l5 + ",msgSeq:" + l4 + ",msgUid:" + l6 + ",userActive:" + n + ",fromInstid:" + i1 + ",hasAppShare:" + paramMsg.appshare_info.has() + ",hasMsgBody:" + paramMsg.msg_body.has());
          }
          this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.jdField_a_of_type_Int = n;
          localObject1 = new ArrayList();
        }
        try
        {
          localObject2 = new DecodeProtoPkgContext(l7, l3, true, false, false, false);
          ((DecodeProtoPkgContext)localObject2).h = true;
          paramMsg = a(paramMsg, (PBDecodeContext)localObject2);
          MessageHandlerUtils.a(paramMsg);
          if ((paramMsg != null) && (paramMsg.size() != 0))
          {
            if (localObject1 != null) {
              a(paramMsg, (ArrayList)localObject1, true);
            }
            paramMsg = new ArrayList();
            localObject2 = new ArrayList();
            if ((localObject1 != null) && (((ArrayList)localObject1).size() > 0))
            {
              i1 = ((ArrayList)localObject1).size();
              n = 0;
              for (;;)
              {
                if (n < i1)
                {
                  localMessageRecord = (MessageRecord)((ArrayList)localObject1).get(n);
                  if (QLog.isColorLevel()) {
                    QLog.d("Q.msg.C2CMessageProcessor", 2, "----------handleMsgPush_PB_SlaveMaster after analysis mr.senderuin: " + localMessageRecord.senderuin + " mr.msgtype: " + localMessageRecord.msgtype + " mr.frienduin: " + localMessageRecord.frienduin + " mr.shmsgseq: " + localMessageRecord.shmsgseq + " mr.time:" + localMessageRecord.time + " mr.msg: " + localMessageRecord.getLogColorContent());
                  }
                  if ((localMessageRecord.frienduin == null) || (localMessageRecord.frienduin.length() <= 2))
                  {
                    n += 1;
                    continue;
                    localObject1 = Long.valueOf(paramFromServiceMsg.getUin());
                  }
                }
              }
            }
          }
        }
        catch (Exception paramMsg)
        {
          for (;;)
          {
            MessageRecord localMessageRecord;
            if (QLog.isColorLevel()) {
              QLog.w("Q.msg.C2CMessageProcessor", 2, "decodeSinglePBMsg_C2C error,", paramMsg);
            }
            paramMsg = null;
            continue;
            localMessageRecord.isread = true;
            localMessageRecord.issend = 2;
            this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(localMessageRecord.frienduin, localMessageRecord.istroop, localMessageRecord.time);
            ((ArrayList)localObject2).add(localMessageRecord);
            DelMsgInfo localDelMsgInfo = new DelMsgInfo();
            localDelMsgInfo.lFromUin = Long.parseLong(localMessageRecord.senderuin);
            localDelMsgInfo.shMsgSeq = ((short)(int)localMessageRecord.shmsgseq);
            localDelMsgInfo.uMsgTime = localMessageRecord.time;
            paramMsg.add(localDelMsgInfo);
          }
          this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().b((List)localObject2);
          bool = MessageHandlerUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (ArrayList)localObject2);
          this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a((ArrayList)localObject2, String.valueOf(l7), false);
          this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(localMsgHead.msg_seq.get());
          n = paramFromServiceMsg.getRequestSsoSeq();
          this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler.a(l2, paramMsg, paramPbPushMsg.svrip.get(), n, null);
        }
      }
    } while (l1 == 127L);
    a("handleMsgPush_PB_SlaveMaster", true, 0, this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler.a(false, bool), false);
    this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler.b((ArrayList)localObject2);
  }
  
  private boolean b(MessageRecord paramMessageRecord)
  {
    return this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramMessageRecord.frienduin, paramMessageRecord.msgUid, paramMessageRecord.shmsgseq);
  }
  
  private void c(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.msg.C2CMessageProcessor", 2, "handlePBGetRoamMsgInOneDay ");
    }
    paramFromServiceMsg = new msg_svc.PbGetOneDayRoamMsgResp();
    Bundle localBundle;
    long l2;
    int n;
    long l1;
    try
    {
      paramFromServiceMsg = (msg_svc.PbGetOneDayRoamMsgResp)paramFromServiceMsg.mergeFrom((byte[])paramObject);
      localBundle = paramToServiceMsg.extraData.getBundle("context");
      paramObject = null;
      l2 = 0L;
      if (paramFromServiceMsg == null) {
        break label691;
      }
      n = paramFromServiceMsg.result.get();
      Object localObject = paramFromServiceMsg.msg.get();
      paramToServiceMsg = new ArrayList();
      a((List)localObject, paramToServiceMsg);
      if (QLog.isColorLevel()) {
        QLog.d("Q.msg.C2CMessageProcessor", 2, "handlePBGetRoamMsgInOneDay code=" + n + ", complete=" + paramFromServiceMsg.iscomplete.get() + " ,respRandom:" + paramFromServiceMsg.random.get() + ", lastMsgTime:" + paramFromServiceMsg.last_msgtime.get() + ", msgList.size()=" + paramToServiceMsg.size() + ", context" + localBundle);
      }
      if (n != 0) {
        break label692;
      }
      paramObject = new ArrayList();
      try
      {
        localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler, paramToServiceMsg, paramFromServiceMsg.peer_uin.get(), true);
        if (localObject != null) {
          paramObject.addAll((Collection)localObject);
        }
      }
      catch (Exception localException1)
      {
        for (;;)
        {
          DecodeProtoPkgContext localDecodeProtoPkgContext;
          Iterator localIterator;
          if (QLog.isColorLevel()) {
            QLog.w("Q.msg.C2CMessageProcessor", 2, "FileMsg filter error,", localException1);
          }
        }
      }
      l1 = paramFromServiceMsg.peer_uin.get();
      if (!paramToServiceMsg.isEmpty())
      {
        localObject = (msg_comm.Msg)paramToServiceMsg.get(0);
        l1 = MessageHandlerUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, ((msg_comm.MsgHead)((msg_comm.Msg)localObject).msg_head.get()).from_uin.get(), ((msg_comm.MsgHead)((msg_comm.Msg)localObject).msg_head.get()).to_uin.get(), paramFromServiceMsg.peer_uin.get());
      }
      localDecodeProtoPkgContext = new DecodeProtoPkgContext(Long.parseLong(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin()), l1, true, true, false, false);
      localDecodeProtoPkgContext.h = true;
      localIterator = paramToServiceMsg.iterator();
      paramToServiceMsg = null;
      for (;;)
      {
        if (!localIterator.hasNext()) {
          break label479;
        }
        localObject = (msg_comm.Msg)localIterator.next();
        try
        {
          localObject = a((msg_comm.Msg)localObject, localDecodeProtoPkgContext);
          paramToServiceMsg = (ToServiceMsg)localObject;
        }
        catch (Exception localException2)
        {
          for (;;)
          {
            if (QLog.isColorLevel()) {
              QLog.w("Q.msg.C2CMessageProcessor", 2, "decodeSinglePBMsg_C2C error,", localException2);
            }
          }
        }
        if ((paramToServiceMsg != null) && (paramToServiceMsg.size() > 0)) {
          paramObject.addAll(paramToServiceMsg);
        }
      }
    }
    catch (InvalidProtocolBufferMicroException paramFromServiceMsg)
    {
      for (;;)
      {
        paramFromServiceMsg.printStackTrace();
        paramFromServiceMsg = null;
      }
    }
    label479:
    if (paramObject.size() > 0)
    {
      Collections.sort(paramObject, new zzg(this));
      l1 = ((MessageRecord)paramObject.get(0)).time;
    }
    for (paramToServiceMsg = paramObject;; paramToServiceMsg = null)
    {
      for (;;)
      {
        boolean bool3;
        boolean bool1;
        label563:
        boolean bool2;
        if (localBundle != null)
        {
          localBundle.getInt("size_req", 0);
          l2 = localBundle.getLong("UIN", 0L);
          bool3 = localBundle.getBoolean("canUpdateEct", true);
          if (paramFromServiceMsg.iscomplete.get() == 0) {
            break label734;
          }
          bool1 = true;
          if ((n != 0) && (n != 1) && (n != 4)) {
            break label740;
          }
          bool2 = true;
          label583:
          if ((!bool2) || (!bool3)) {
            break label783;
          }
          if (!bool1) {
            break label746;
          }
          this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().b(String.valueOf(l2), 0L, 0L);
          label615:
          localBundle.putBoolean("complete", bool1);
          localBundle.putBoolean("success", bool2);
          localBundle.putLong("lowTime", l1);
          paramObject = new ArrayList();
        }
        try
        {
          this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(String.valueOf(paramFromServiceMsg.peer_uin.get()), 0, paramToServiceMsg, paramObject, localBundle);
          if (paramToServiceMsg != null) {
            this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler.a(paramObject, false);
          }
          label691:
          return;
          label692:
          l1 = l2;
          paramToServiceMsg = paramObject;
          if (n == 1)
          {
            l1 = l2;
            paramToServiceMsg = paramObject;
            if (QLog.isColorLevel())
            {
              QLog.d("Q.msg.C2CMessageProcessor", 2, "code == 0x01");
              l1 = l2;
              paramToServiceMsg = paramObject;
              continue;
              label734:
              bool1 = false;
              break label563;
              label740:
              bool2 = false;
              break label583;
              label746:
              this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().b(String.valueOf(paramFromServiceMsg.peer_uin.get()), paramFromServiceMsg.last_msgtime.get(), paramFromServiceMsg.random.get());
              break label615;
              label783:
              if (bool3) {
                break label615;
              }
              if (bool1)
              {
                localBundle.putLong("tempEct", 0L);
                localBundle.putLong("tempRandom", 0L);
                break label615;
              }
              localBundle.putLong("tempEct", paramFromServiceMsg.last_msgtime.get());
              localBundle.putLong("tempRandom", paramFromServiceMsg.random.get());
            }
          }
        }
        catch (Exception paramFromServiceMsg)
        {
          for (;;)
          {
            paramFromServiceMsg.printStackTrace();
          }
        }
      }
      l1 = 0L;
    }
  }
  
  /* Error */
  private void d(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    // Byte code:
    //   0: aload_1
    //   1: getfield 742	com/tencent/qphone/base/remote/ToServiceMsg:extraData	Landroid/os/Bundle;
    //   4: ldc_w 1075
    //   7: invokevirtual 1079	android/os/Bundle:getInt	(Ljava/lang/String;)I
    //   10: istore 4
    //   12: new 110	java/util/HashMap
    //   15: dup
    //   16: iconst_1
    //   17: invokespecial 1057	java/util/HashMap:<init>	(I)V
    //   20: astore 14
    //   22: aload 14
    //   24: ldc_w 1059
    //   27: aload_1
    //   28: getfield 742	com/tencent/qphone/base/remote/ToServiceMsg:extraData	Landroid/os/Bundle;
    //   31: ldc_w 1061
    //   34: invokevirtual 1063	android/os/Bundle:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   37: invokevirtual 1067	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   40: pop
    //   41: aload 14
    //   43: ldc_w 1069
    //   46: aload_1
    //   47: getfield 742	com/tencent/qphone/base/remote/ToServiceMsg:extraData	Landroid/os/Bundle;
    //   50: ldc_w 1071
    //   53: invokevirtual 747	android/os/Bundle:getLong	(Ljava/lang/String;)J
    //   56: invokestatic 606	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   59: invokevirtual 1067	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   62: pop
    //   63: aload 14
    //   65: ldc_w 1073
    //   68: iload 4
    //   70: invokestatic 99	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   73: invokevirtual 1067	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   76: pop
    //   77: new 1522	msf/msgsvc/msg_svc$PbSearchRoamMsgInCloudResp
    //   80: dup
    //   81: invokespecial 1523	msf/msgsvc/msg_svc$PbSearchRoamMsgInCloudResp:<init>	()V
    //   84: astore 13
    //   86: aload 13
    //   88: aload_3
    //   89: checkcast 781	[B
    //   92: checkcast 781	[B
    //   95: invokevirtual 1524	msf/msgsvc/msg_svc$PbSearchRoamMsgInCloudResp:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   98: checkcast 1522	msf/msgsvc/msg_svc$PbSearchRoamMsgInCloudResp
    //   101: astore 13
    //   103: aload 13
    //   105: ifnull +67 -> 172
    //   108: new 1526	tencent/im/oidb/searcher/oidb_c2c_searcher$RspBody
    //   111: dup
    //   112: invokespecial 1527	tencent/im/oidb/searcher/oidb_c2c_searcher$RspBody:<init>	()V
    //   115: astore_3
    //   116: aload 13
    //   118: getfield 1530	msf/msgsvc/msg_svc$PbSearchRoamMsgInCloudResp:serialize_rspbody	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   121: invokevirtual 512	com/tencent/mobileqq/pb/PBBytesField:has	()Z
    //   124: ifeq +139 -> 263
    //   127: aload_3
    //   128: aload 13
    //   130: getfield 1530	msf/msgsvc/msg_svc$PbSearchRoamMsgInCloudResp:serialize_rspbody	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   133: invokevirtual 518	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   136: invokevirtual 524	com/tencent/mobileqq/pb/ByteStringMicro:toByteArray	()[B
    //   139: invokevirtual 1531	tencent/im/oidb/searcher/oidb_c2c_searcher$RspBody:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   142: checkcast 1526	tencent/im/oidb/searcher/oidb_c2c_searcher$RspBody
    //   145: astore_3
    //   146: aload_3
    //   147: ifnonnull +121 -> 268
    //   150: invokestatic 160	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   153: ifeq +12 -> 165
    //   156: ldc 162
    //   158: iconst_2
    //   159: ldc_w 1533
    //   162: invokestatic 1085	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   165: aload_0
    //   166: aload_1
    //   167: aload_2
    //   168: iconst_0
    //   169: invokespecial 1535	com/tencent/mobileqq/app/message/C2CMessageProcessor:a	(Lcom/tencent/qphone/base/remote/ToServiceMsg;Lcom/tencent/qphone/base/remote/FromServiceMsg;Z)V
    //   172: return
    //   173: astore_3
    //   174: invokestatic 160	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   177: ifeq +13 -> 190
    //   180: ldc 162
    //   182: iconst_2
    //   183: ldc_w 1537
    //   186: aload_3
    //   187: invokestatic 463	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   190: aconst_null
    //   191: astore 13
    //   193: goto -90 -> 103
    //   196: astore_3
    //   197: invokestatic 160	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   200: ifeq +13 -> 213
    //   203: ldc 162
    //   205: iconst_2
    //   206: ldc_w 1539
    //   209: aload_3
    //   210: invokestatic 463	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   213: aconst_null
    //   214: astore 13
    //   216: goto -113 -> 103
    //   219: astore_3
    //   220: invokestatic 160	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   223: ifeq +13 -> 236
    //   226: ldc 162
    //   228: iconst_2
    //   229: ldc_w 1541
    //   232: aload_3
    //   233: invokestatic 463	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   236: aconst_null
    //   237: astore_3
    //   238: goto -92 -> 146
    //   241: astore_3
    //   242: invokestatic 160	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   245: ifeq +13 -> 258
    //   248: ldc 162
    //   250: iconst_2
    //   251: ldc_w 1543
    //   254: aload_3
    //   255: invokestatic 463	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   258: aconst_null
    //   259: astore_3
    //   260: goto -114 -> 146
    //   263: aconst_null
    //   264: astore_3
    //   265: goto -119 -> 146
    //   268: aload_3
    //   269: getfield 1545	tencent/im/oidb/searcher/oidb_c2c_searcher$RspBody:result	Lcom/tencent/mobileqq/pb/PBEnumField;
    //   272: invokevirtual 845	com/tencent/mobileqq/pb/PBEnumField:get	()I
    //   275: istore 5
    //   277: invokestatic 160	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   280: ifeq +41 -> 321
    //   283: ldc 162
    //   285: iconst_2
    //   286: new 107	java/lang/StringBuilder
    //   289: dup
    //   290: invokespecial 108	java/lang/StringBuilder:<init>	()V
    //   293: ldc_w 1547
    //   296: invokevirtual 168	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   299: iload 5
    //   301: invokevirtual 171	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   304: ldc_w 1549
    //   307: invokevirtual 168	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   310: iload 4
    //   312: invokevirtual 171	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   315: invokevirtual 176	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   318: invokestatic 1085	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   321: iload 5
    //   323: ifeq +9 -> 332
    //   326: iload 5
    //   328: iconst_1
    //   329: if_icmpne +699 -> 1028
    //   332: aload 13
    //   334: getfield 1550	msf/msgsvc/msg_svc$PbSearchRoamMsgInCloudResp:msg	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   337: invokevirtual 85	com/tencent/mobileqq/pb/PBRepeatMessageField:get	()Ljava/util/List;
    //   340: astore 15
    //   342: aload 15
    //   344: ifnonnull +19 -> 363
    //   347: invokestatic 160	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   350: ifeq -178 -> 172
    //   353: ldc 162
    //   355: iconst_2
    //   356: ldc_w 1552
    //   359: invokestatic 1085	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   362: return
    //   363: new 59	java/util/ArrayList
    //   366: dup
    //   367: invokespecial 60	java/util/ArrayList:<init>	()V
    //   370: astore 16
    //   372: aload_0
    //   373: aload 15
    //   375: aload 16
    //   377: invokespecial 105	com/tencent/mobileqq/app/message/C2CMessageProcessor:a	(Ljava/util/List;Ljava/util/List;)V
    //   380: aload_0
    //   381: getfield 63	com/tencent/mobileqq/app/message/C2CMessageProcessor:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   384: invokevirtual 73	com/tencent/mobileqq/app/QQAppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   387: invokestatic 119	java/lang/Long:parseLong	(Ljava/lang/String;)J
    //   390: lstore 10
    //   392: new 113	com/tencent/mobileqq/service/message/DecodeProtoPkgContext
    //   395: dup
    //   396: lload 10
    //   398: lconst_0
    //   399: iconst_1
    //   400: iconst_1
    //   401: iconst_0
    //   402: iconst_0
    //   403: invokespecial 122	com/tencent/mobileqq/service/message/DecodeProtoPkgContext:<init>	(JJZZZZ)V
    //   406: astore 17
    //   408: aload 17
    //   410: iconst_1
    //   411: putfield 239	com/tencent/mobileqq/service/message/DecodeProtoPkgContext:h	Z
    //   414: new 59	java/util/ArrayList
    //   417: dup
    //   418: invokespecial 60	java/util/ArrayList:<init>	()V
    //   421: astore 13
    //   423: aload 16
    //   425: invokevirtual 246	java/util/ArrayList:iterator	()Ljava/util/Iterator;
    //   428: astore 18
    //   430: aload 18
    //   432: invokeinterface 251 1 0
    //   437: ifeq +253 -> 690
    //   440: aload 18
    //   442: invokeinterface 255 1 0
    //   447: checkcast 135	msf/msgcomm/msg_comm$Msg
    //   450: astore_2
    //   451: aload_2
    //   452: ifnull +23 -> 475
    //   455: aload_2
    //   456: getfield 139	msf/msgcomm/msg_comm$Msg:msg_head	Lmsf/msgcomm/msg_comm$MsgHead;
    //   459: invokevirtual 155	msf/msgcomm/msg_comm$MsgHead:has	()Z
    //   462: ifeq +13 -> 475
    //   465: aload_2
    //   466: getfield 148	msf/msgcomm/msg_comm$Msg:msg_body	Ltencent/im/msg/im_msg_body$MsgBody;
    //   469: invokevirtual 505	tencent/im/msg/im_msg_body$MsgBody:has	()Z
    //   472: ifne +113 -> 585
    //   475: invokestatic 160	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   478: ifeq -48 -> 430
    //   481: new 107	java/lang/StringBuilder
    //   484: dup
    //   485: invokespecial 108	java/lang/StringBuilder:<init>	()V
    //   488: ldc_w 1554
    //   491: invokevirtual 168	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   494: astore 19
    //   496: aload_2
    //   497: ifnonnull +45 -> 542
    //   500: ldc_w 1556
    //   503: astore_2
    //   504: ldc 162
    //   506: iconst_2
    //   507: aload 19
    //   509: aload_2
    //   510: invokevirtual 168	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   513: invokevirtual 176	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   516: invokestatic 179	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   519: goto -89 -> 430
    //   522: astore_2
    //   523: invokestatic 160	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   526: ifeq -96 -> 430
    //   529: ldc 162
    //   531: iconst_2
    //   532: ldc_w 1558
    //   535: aload_2
    //   536: invokestatic 463	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   539: goto -109 -> 430
    //   542: new 107	java/lang/StringBuilder
    //   545: dup
    //   546: invokespecial 108	java/lang/StringBuilder:<init>	()V
    //   549: ldc_w 1560
    //   552: invokevirtual 168	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   555: aload_2
    //   556: getfield 139	msf/msgcomm/msg_comm$Msg:msg_head	Lmsf/msgcomm/msg_comm$MsgHead;
    //   559: invokevirtual 495	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   562: ldc_w 1562
    //   565: invokevirtual 168	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   568: aload_2
    //   569: getfield 148	msf/msgcomm/msg_comm$Msg:msg_body	Ltencent/im/msg/im_msg_body$MsgBody;
    //   572: invokevirtual 505	tencent/im/msg/im_msg_body$MsgBody:has	()Z
    //   575: invokevirtual 720	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   578: invokevirtual 176	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   581: astore_2
    //   582: goto -78 -> 504
    //   585: aload_2
    //   586: getfield 139	msf/msgcomm/msg_comm$Msg:msg_head	Lmsf/msgcomm/msg_comm$MsgHead;
    //   589: invokevirtual 144	msf/msgcomm/msg_comm$MsgHead:get	()Lcom/tencent/mobileqq/pb/MessageMicro;
    //   592: checkcast 141	msf/msgcomm/msg_comm$MsgHead
    //   595: astore 19
    //   597: aload 19
    //   599: getfield 183	msf/msgcomm/msg_comm$MsgHead:to_uin	Lcom/tencent/mobileqq/pb/PBUInt64Field;
    //   602: invokevirtual 187	com/tencent/mobileqq/pb/PBUInt64Field:get	()J
    //   605: lstore 6
    //   607: aload 19
    //   609: getfield 190	msf/msgcomm/msg_comm$MsgHead:from_uin	Lcom/tencent/mobileqq/pb/PBUInt64Field;
    //   612: invokevirtual 187	com/tencent/mobileqq/pb/PBUInt64Field:get	()J
    //   615: lstore 8
    //   617: lload 6
    //   619: lload 10
    //   621: lcmp
    //   622: ifeq +414 -> 1036
    //   625: lload 8
    //   627: lload 10
    //   629: lcmp
    //   630: ifeq +406 -> 1036
    //   633: invokestatic 160	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   636: ifeq -206 -> 430
    //   639: ldc 162
    //   641: iconst_2
    //   642: ldc_w 1564
    //   645: invokestatic 179	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   648: goto -218 -> 430
    //   651: aload 17
    //   653: lload 6
    //   655: putfield 237	com/tencent/mobileqq/service/message/DecodeProtoPkgContext:jdField_e_of_type_Long	J
    //   658: aload_0
    //   659: aload_2
    //   660: aload 17
    //   662: invokevirtual 242	com/tencent/mobileqq/app/message/C2CMessageProcessor:a	(Lmsf/msgcomm/msg_comm$Msg;Lcom/tencent/mobileqq/service/message/PBDecodeContext;)Ljava/util/ArrayList;
    //   665: astore_2
    //   666: aload_2
    //   667: ifnull -237 -> 430
    //   670: aload_2
    //   671: invokevirtual 1396	java/util/ArrayList:isEmpty	()Z
    //   674: ifne -244 -> 430
    //   677: aload 13
    //   679: aload_2
    //   680: invokevirtual 1395	java/util/ArrayList:addAll	(Ljava/util/Collection;)Z
    //   683: pop
    //   684: goto -254 -> 430
    //   687: goto -36 -> 651
    //   690: aload 13
    //   692: invokevirtual 130	java/util/ArrayList:size	()I
    //   695: ifle +16 -> 711
    //   698: aload 13
    //   700: new 1566	zzi
    //   703: dup
    //   704: aload_0
    //   705: invokespecial 1567	zzi:<init>	(Lcom/tencent/mobileqq/app/message/C2CMessageProcessor;)V
    //   708: invokestatic 902	java/util/Collections:sort	(Ljava/util/List;Ljava/util/Comparator;)V
    //   711: invokestatic 160	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   714: ifeq +63 -> 777
    //   717: ldc 162
    //   719: iconst_2
    //   720: new 107	java/lang/StringBuilder
    //   723: dup
    //   724: invokespecial 108	java/lang/StringBuilder:<init>	()V
    //   727: ldc_w 1569
    //   730: invokevirtual 168	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   733: aload 15
    //   735: invokeinterface 91 1 0
    //   740: invokevirtual 171	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   743: ldc_w 1571
    //   746: invokevirtual 168	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   749: aload 16
    //   751: invokevirtual 130	java/util/ArrayList:size	()I
    //   754: invokevirtual 171	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   757: ldc_w 1573
    //   760: invokevirtual 168	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   763: aload 13
    //   765: invokevirtual 130	java/util/ArrayList:size	()I
    //   768: invokevirtual 171	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   771: invokevirtual 176	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   774: invokestatic 1085	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   777: aload_3
    //   778: getfield 1576	tencent/im/oidb/searcher/oidb_c2c_searcher$RspBody:friends	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   781: invokevirtual 1577	com/tencent/mobileqq/pb/PBRepeatMessageField:has	()Z
    //   784: ifeq +124 -> 908
    //   787: aload_3
    //   788: getfield 1576	tencent/im/oidb/searcher/oidb_c2c_searcher$RspBody:friends	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   791: invokevirtual 85	com/tencent/mobileqq/pb/PBRepeatMessageField:get	()Ljava/util/List;
    //   794: astore_2
    //   795: aload_2
    //   796: ifnull +117 -> 913
    //   799: invokestatic 160	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   802: ifeq +34 -> 836
    //   805: ldc 162
    //   807: iconst_2
    //   808: new 107	java/lang/StringBuilder
    //   811: dup
    //   812: invokespecial 108	java/lang/StringBuilder:<init>	()V
    //   815: ldc_w 1579
    //   818: invokevirtual 168	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   821: aload_2
    //   822: invokeinterface 91 1 0
    //   827: invokevirtual 171	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   830: invokevirtual 176	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   833: invokestatic 1085	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   836: aload 13
    //   838: invokevirtual 130	java/util/ArrayList:size	()I
    //   841: ifne +126 -> 967
    //   844: iload 5
    //   846: iconst_1
    //   847: if_icmpeq +120 -> 967
    //   850: aload_1
    //   851: getfield 742	com/tencent/qphone/base/remote/ToServiceMsg:extraData	Landroid/os/Bundle;
    //   854: ldc_w 1081
    //   857: invokevirtual 1079	android/os/Bundle:getInt	(Ljava/lang/String;)I
    //   860: istore 5
    //   862: iload 5
    //   864: iconst_4
    //   865: if_icmpge +66 -> 931
    //   868: aload_0
    //   869: getfield 63	com/tencent/mobileqq/app/message/C2CMessageProcessor:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   872: invokevirtual 1088	com/tencent/mobileqq/app/QQAppInterface:a	()Lcom/tencent/mobileqq/app/MessageHandler;
    //   875: iload 4
    //   877: aconst_null
    //   878: aload_1
    //   879: getfield 742	com/tencent/qphone/base/remote/ToServiceMsg:extraData	Landroid/os/Bundle;
    //   882: ldc_w 1061
    //   885: invokevirtual 1063	android/os/Bundle:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   888: aload_1
    //   889: getfield 742	com/tencent/qphone/base/remote/ToServiceMsg:extraData	Landroid/os/Bundle;
    //   892: ldc_w 1071
    //   895: invokevirtual 747	android/os/Bundle:getLong	(Ljava/lang/String;)J
    //   898: aload_2
    //   899: iload 5
    //   901: iconst_1
    //   902: iadd
    //   903: lconst_0
    //   904: invokevirtual 1582	com/tencent/mobileqq/app/MessageHandler:a	(ILjava/util/List;Ljava/lang/String;JLjava/util/List;IJ)V
    //   907: return
    //   908: aconst_null
    //   909: astore_2
    //   910: goto -115 -> 795
    //   913: invokestatic 160	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   916: ifeq -80 -> 836
    //   919: ldc 162
    //   921: iconst_2
    //   922: ldc_w 1584
    //   925: invokestatic 1085	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   928: goto -92 -> 836
    //   931: invokestatic 160	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   934: ifeq +12 -> 946
    //   937: ldc 162
    //   939: iconst_2
    //   940: ldc_w 1586
    //   943: invokestatic 1085	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   946: aload 14
    //   948: ldc_w 1588
    //   951: aload_2
    //   952: invokevirtual 1067	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   955: pop
    //   956: aload_0
    //   957: sipush 8015
    //   960: iconst_0
    //   961: aload 14
    //   963: invokevirtual 761	com/tencent/mobileqq/app/message/C2CMessageProcessor:a	(IZLjava/lang/Object;)V
    //   966: return
    //   967: aload 14
    //   969: ldc_w 1588
    //   972: aload_2
    //   973: invokevirtual 1067	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   976: pop
    //   977: aload 14
    //   979: ldc_w 1590
    //   982: aload 13
    //   984: invokevirtual 1067	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   987: pop
    //   988: iload 5
    //   990: iconst_1
    //   991: if_icmpne +31 -> 1022
    //   994: iconst_1
    //   995: istore 12
    //   997: aload 14
    //   999: ldc_w 1592
    //   1002: iload 12
    //   1004: invokestatic 833	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   1007: invokevirtual 1067	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   1010: pop
    //   1011: aload_0
    //   1012: sipush 8015
    //   1015: iconst_1
    //   1016: aload 14
    //   1018: invokevirtual 761	com/tencent/mobileqq/app/message/C2CMessageProcessor:a	(IZLjava/lang/Object;)V
    //   1021: return
    //   1022: iconst_0
    //   1023: istore 12
    //   1025: goto -28 -> 997
    //   1028: aload_0
    //   1029: aload_1
    //   1030: aload_2
    //   1031: iconst_0
    //   1032: invokespecial 1535	com/tencent/mobileqq/app/message/C2CMessageProcessor:a	(Lcom/tencent/qphone/base/remote/ToServiceMsg;Lcom/tencent/qphone/base/remote/FromServiceMsg;Z)V
    //   1035: return
    //   1036: lload 6
    //   1038: lload 10
    //   1040: lcmp
    //   1041: ifne -354 -> 687
    //   1044: lload 8
    //   1046: lstore 6
    //   1048: goto -397 -> 651
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1051	0	this	C2CMessageProcessor
    //   0	1051	1	paramToServiceMsg	ToServiceMsg
    //   0	1051	2	paramFromServiceMsg	FromServiceMsg
    //   0	1051	3	paramObject	Object
    //   10	866	4	n	int
    //   275	717	5	i1	int
    //   605	442	6	l1	long
    //   615	430	8	l2	long
    //   390	649	10	l3	long
    //   995	29	12	bool	boolean
    //   84	899	13	localObject1	Object
    //   20	997	14	localHashMap	HashMap
    //   340	394	15	localList	List
    //   370	380	16	localArrayList	ArrayList
    //   406	255	17	localDecodeProtoPkgContext	DecodeProtoPkgContext
    //   428	13	18	localIterator	Iterator
    //   494	114	19	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   86	103	173	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   86	103	196	java/lang/OutOfMemoryError
    //   127	146	219	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   127	146	241	java/lang/OutOfMemoryError
    //   455	475	522	java/lang/Exception
    //   475	496	522	java/lang/Exception
    //   504	519	522	java/lang/Exception
    //   542	582	522	java/lang/Exception
    //   585	617	522	java/lang/Exception
    //   633	648	522	java/lang/Exception
    //   651	666	522	java/lang/Exception
    //   670	684	522	java/lang/Exception
  }
  
  protected String a(msg_comm.Msg paramMsg)
  {
    long l1 = ((msg_comm.MsgHead)paramMsg.msg_head.get()).msg_uid.get();
    long l2 = ((msg_comm.MsgHead)paramMsg.msg_head.get()).msg_seq.get();
    return 64 + "key_uid_" + l1 + "_seq_" + l2;
  }
  
  public ArrayList a(msg_comm.Msg paramMsg, PBDecodeContext paramPBDecodeContext)
  {
    if (!(paramPBDecodeContext instanceof DecodeProtoPkgContext)) {
      return new ArrayList();
    }
    DecodeProtoPkgContext localDecodeProtoPkgContext = (DecodeProtoPkgContext)paramPBDecodeContext;
    long l4 = System.currentTimeMillis();
    ArrayList localArrayList = new ArrayList();
    if ((paramMsg == null) || (!paramMsg.msg_head.has()) || (!paramMsg.msg_body.has()))
    {
      if (QLog.isColorLevel())
      {
        paramPBDecodeContext = new StringBuilder().append("decodeSinglePBMsg_C2C return : ");
        if (paramMsg != null) {
          break label104;
        }
      }
      label104:
      for (paramMsg = " msg=null";; paramMsg = " msg.msg_head:" + paramMsg.msg_head + " msg.msg_body:" + paramMsg.msg_body.has())
      {
        QLog.d("Q.msg.C2CMessageProcessor", 2, paramMsg);
        return localArrayList;
      }
    }
    msg_comm.MsgHead localMsgHead = (msg_comm.MsgHead)paramMsg.msg_head.get();
    int i7 = (short)localMsgHead.msg_seq.get();
    long l2 = localMsgHead.to_uin.get();
    long l5 = localMsgHead.from_uin.get();
    long l3 = localMsgHead.msg_time.get();
    long l6 = localMsgHead.msg_uid.get();
    int i6 = localMsgHead.msg_type.get();
    int i2 = paramMsg.msg_head.c2c_cmd.get();
    int n = 0;
    int i1 = 0;
    int i5;
    int i4;
    int i3;
    if (paramMsg.content_head.has())
    {
      paramPBDecodeContext = (msg_comm.ContentHead)paramMsg.content_head.get();
      i5 = paramPBDecodeContext.div_seq.get();
      i4 = paramPBDecodeContext.pkg_num.get();
      i3 = paramPBDecodeContext.pkg_index.get();
    }
    for (;;)
    {
      long l1 = -1L;
      paramPBDecodeContext = null;
      label424:
      Object localObject1;
      Object localObject2;
      if (!localDecodeProtoPkgContext.jdField_d_of_type_Boolean)
      {
        paramPBDecodeContext = MessageProtoCodec.a(this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler, paramMsg, String.valueOf(localDecodeProtoPkgContext.jdField_e_of_type_Long), String.valueOf(l5));
        if (((Long)paramPBDecodeContext.first).longValue() != 4294967295L) {
          l1 = ((Long)paramPBDecodeContext.first).longValue();
        }
      }
      else
      {
        localDecodeProtoPkgContext.jdField_b_of_type_Long = l5;
        localDecodeProtoPkgContext.jdField_c_of_type_Long = l3;
        int i8 = MessageProtoCodec.a(paramMsg);
        localDecodeProtoPkgContext.jdField_a_of_type_Int = i8;
        localDecodeProtoPkgContext.jdField_d_of_type_Long = SVIPHandler.a((int)l1, i8);
        localDecodeProtoPkgContext.jdField_b_of_type_Int = MessageProtoCodec.f(paramMsg);
        if (l5 != localDecodeProtoPkgContext.jdField_a_of_type_Long) {
          break label1134;
        }
        localDecodeProtoPkgContext.jdField_a_of_type_Boolean = true;
        localDecodeProtoPkgContext.f = true;
        if (!QLog.isColorLevel()) {
          break label1154;
        }
        localObject1 = new StringBuilder();
        localObject2 = ((StringBuilder)localObject1).append("<---decodeSinglePBMsg_C2C : decode msg: msgTime:").append(l3).append(" shortSeq:").append(i7).append(" uint32Seq:").append(localMsgHead.msg_seq.get()).append(" msgUid:").append(l6).append(" toUin:").append(l2).append(" senderUin:").append(l5).append(" friendUin:").append(localDecodeProtoPkgContext.jdField_e_of_type_Long).append(" isReaded:").append(localDecodeProtoPkgContext.jdField_a_of_type_Boolean).append(" isSyncFromOtherTerm:").append(localDecodeProtoPkgContext.f).append(" msgType:").append(i6).append(" C2CCmd:").append(i2).append(" hasTemp:").append(localMsgHead.c2c_tmp_msg_head.has()).append(" hasShare:").append(paramMsg.appshare_info.has()).append(" pkgID:");
        if (paramPBDecodeContext != null) {
          break label1143;
        }
        paramPBDecodeContext = "nullPair";
        label626:
        ((StringBuilder)localObject2).append(paramPBDecodeContext).append(" longMsgID:").append(i5).append(" longMsgCount:").append(i4).append(" longMsgIndex:").append(i3).append("init_direction_flag").append(0);
        QLog.d("Q.msg.C2CMessageProcessor", 2, ((StringBuilder)localObject1).toString());
        label687:
        paramPBDecodeContext = new ArrayList();
        if ((i6 != 140) && (i6 != 141) && ((i6 != 529) || (localMsgHead.c2c_cmd.get() != 6))) {
          break label1238;
        }
        i1 = 1;
        localObject1 = MessageProtoCodec.a(paramMsg);
        if (((TempSessionInfo)localObject1).jdField_a_of_type_Int != -1) {
          break label1176;
        }
        n = 0;
        label752:
        if (n == 0) {
          break label1228;
        }
        i2 = ((TempSessionInfo)localObject1).jdField_b_of_type_Int;
        MessageProtoCodec.a(this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler, paramPBDecodeContext, paramMsg, (TempSessionInfo)localObject1, localDecodeProtoPkgContext);
        n = ((TempSessionInfo)localObject1).jdField_a_of_type_Int;
        if ((paramPBDecodeContext.size() <= 0) || (!ConfessMsgUtil.a((MessageRecord)paramPBDecodeContext.get(0)))) {
          break label5280;
        }
        if (!((MessageRecord)paramPBDecodeContext.get(0)).isSelfConfessor()) {
          break label1231;
        }
        n = 1033;
        label821:
        ((TempSessionInfo)localObject1).jdField_a_of_type_Int = n;
        n = ((TempSessionInfo)localObject1).jdField_a_of_type_Int;
      }
      label1154:
      label1176:
      label2200:
      label2343:
      label5042:
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.d("Q.msg.C2CMessageProcessor", 2, "friendType:" + n + ", direction_flag:" + i2);
        }
        i1 = n;
        n = i2;
        label2627:
        for (;;)
        {
          if ((paramPBDecodeContext.size() == 0) && (i4 > 1))
          {
            if (QLog.isColorLevel()) {
              QLog.d("Q.msg.C2CMessageProcessor", 2, "<---decodeSinglePBMsg_C2C, empty long msg fragment");
            }
            localObject1 = (MessageForText)MessageRecordFactory.a(-1000);
            ((MessageForText)localObject1).msgtype = -1000;
            ((MessageForText)localObject1).msg = "";
            paramPBDecodeContext.add(localObject1);
          }
          l1 = -1L;
          l2 = l1;
          for (;;)
          {
            try
            {
              localObject1 = ((im_msg_body.RichText)((im_msg_body.MsgBody)paramMsg.msg_body.get()).rich_text.get()).elems.get();
              l3 = l1;
              if (localObject1 == null) {
                continue;
              }
              l3 = l1;
              l2 = l1;
              if (((List)localObject1).size() <= 0) {
                continue;
              }
              i2 = 0;
              l3 = l1;
              l2 = l1;
              if (i2 >= ((List)localObject1).size()) {
                continue;
              }
              l2 = l1;
              localObject2 = (im_msg_body.Elem)((List)localObject1).get(i2);
              l2 = l1;
              if (!((im_msg_body.Elem)localObject2).elem_flags2.has()) {
                continue;
              }
              l2 = l1;
              if (!((im_msg_body.ElemFlags2)((im_msg_body.Elem)localObject2).elem_flags2.get()).uint64_msg_id.has()) {
                continue;
              }
              l2 = l1;
              l1 = ((im_msg_body.ElemFlags2)((im_msg_body.Elem)localObject2).elem_flags2.get()).uint64_msg_id.get();
            }
            catch (Throwable localThrowable)
            {
              boolean bool1;
              boolean bool2;
              int i9;
              Object localObject3;
              Object localObject4;
              QLog.e("Q.msg.C2CMessageProcessor", 2, "<---decodeSinglePBMsg_C2C: ", localThrowable);
              l1 = l2;
              continue;
              ((MessageRecord)localObject3).selfuin = String.valueOf(localDecodeProtoPkgContext.jdField_a_of_type_Long);
              ((MessageRecord)localObject3).frienduin = String.valueOf(localDecodeProtoPkgContext.jdField_e_of_type_Long);
              ((MessageRecord)localObject3).senderuin = String.valueOf(localDecodeProtoPkgContext.jdField_b_of_type_Long);
              ((MessageRecord)localObject3).time = localDecodeProtoPkgContext.jdField_c_of_type_Long;
              ((MessageRecord)localObject3).shmsgseq = i7;
              ((MessageRecord)localObject3).msgUid = l6;
              ((MessageRecord)localObject3).istroop = i1;
              ((MessageRecord)localObject3).longMsgId = i5;
              ((MessageRecord)localObject3).longMsgCount = i4;
              ((MessageRecord)localObject3).longMsgIndex = i3;
              if ((1 != n) || (!MsgProxyUtils.r(((MessageRecord)localObject3).istroop)) || (MsgProxyUtils.a(((MessageRecord)localObject3).istroop) == 1032) || (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(((MessageRecord)localObject3).frienduin)) || (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(((MessageRecord)localObject3).frienduin, MsgProxyUtils.a(((MessageRecord)localObject3).istroop), MsgProxyUtils.a(MsgProxyUtils.a(((MessageRecord)localObject3).istroop))))) {
                continue;
              }
              MsgProxyUtils.a((MessageRecord)localObject3, true);
              if (((MessageRecord)localObject3).msgtype != -2058) {
                continue;
              }
              EmojiStickerManager.a((MessageRecord)localObject3, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
              if ((!MsgProxyUtils.r(i1)) || (!(localObject3 instanceof MessageForStructing))) {
                continue;
              }
              i2 = GiftMessageUtils.a((MessageRecord)localObject3, 1);
              if (i2 <= 0) {
                continue;
              }
              ((MessageRecord)localObject3).saveExtInfoToExtStr("nearby_gift_msg", "1|" + String.valueOf(i2));
              paramPBDecodeContext = (MessageForStructing)localObject3;
              if ((paramPBDecodeContext.structingMsg.mMsgServiceID != 52) || ((NearbyFlowerManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(123) == null)) {
                continue;
              }
              paramPBDecodeContext = new NearbyFlowerMessage(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramPBDecodeContext);
              if (!this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c().equals(paramPBDecodeContext.sUin)) {
                continue;
              }
              ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X80060AF", "0X80060AF", 0, 0, "", "", "", "");
              if (!"4".equals(paramPBDecodeContext.version)) {
                continue;
              }
              if (!QLog.isColorLevel()) {
                continue;
              }
              QLog.d("Q.msg.C2CMessageProcessor", 2, "<---received random chat flower message, don't put it to aio");
              MessageProtoCodec.a(this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler, l5, i7, l6, i6);
              continue;
              MsgProxyUtils.a((MessageRecord)localObject3, false);
              continue;
              if (!this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c().equals(paramPBDecodeContext.rUin)) {
                continue;
              }
              ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X80060B0", "0X80060B0", 0, 0, "", "", "", "");
              continue;
              paramPBDecodeContext = (msg_comm.C2CTmpMsgHead)localMsgHead.c2c_tmp_msg_head.get();
              if ((paramPBDecodeContext == null) || (!paramPBDecodeContext.lock_display.has()) || (paramPBDecodeContext.lock_display.get() != 1)) {
                continue;
              }
              ((MessageRecord)localObject3).extLong |= 0x1;
              ((MessageRecord)localObject3).saveExtInfoToExtStr("lockDisplay", "true");
              if ((i1 != 0) || (!(localObject3 instanceof MessageForPic))) {
                continue;
              }
              ((MessageForPic)localObject3).bEnableEnc = true;
              if (i1 != 1006) {
                continue;
              }
              if (!localMsgHead.from_nick.has()) {
                continue;
              }
              ((FriendsManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(50)).b(String.valueOf(localDecodeProtoPkgContext.jdField_e_of_type_Long), localMsgHead.from_nick.get());
              ((MessageRecord)localObject3).frienduin = ContactUtils.h(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, String.valueOf(localDecodeProtoPkgContext.jdField_e_of_type_Long));
              ((MessageRecord)localObject3).senderuin = ContactUtils.h(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, String.valueOf(l5));
              if ((!TextUtils.isEmpty(((MessageRecord)localObject3).frienduin)) || (!localDecodeProtoPkgContext.jdField_d_of_type_Boolean)) {
                continue;
              }
              ((MessageRecord)localObject3).frienduin = String.valueOf(localDecodeProtoPkgContext.jdField_e_of_type_Long);
              if (((MessageRecord)localObject3).frienduin != null) {
                continue;
              }
              QLog.e("Q.msg.C2CMessageProcessor", 1, String.format("decodeMessage error, getPhoneNumByUin is null, friendUin: %d senderUin: %d uinType: %d msgType: %d", new Object[] { Long.valueOf(localDecodeProtoPkgContext.jdField_e_of_type_Long), Long.valueOf(l5), Integer.valueOf(((MessageRecord)localObject3).istroop), Integer.valueOf(((MessageRecord)localObject3).msgtype) }));
              continue;
              if (!localDecodeProtoPkgContext.f) {
                continue;
              }
              ((MessageRecord)localObject3).issend = 2;
              ((MessageRecord)localObject3).isread = true;
              if (!(localObject3 instanceof MessageForPoke)) {
                continue;
              }
              if ((((MessageRecord)localObject3).isread) || (((MessageRecord)localObject3).isSend())) {
                continue;
              }
              ((MessageForPoke)localObject3).isPlayed = false;
              ((MessageForPoke)localObject3).initMsg();
              ((MessageRecord)localObject3).vipBubbleID = localDecodeProtoPkgContext.jdField_d_of_type_Long;
              ((MessageRecord)localObject3).vipBubbleDiyTextId = localDecodeProtoPkgContext.jdField_a_of_type_Int;
              ((MessageRecord)localObject3).vipSubBubbleId = localDecodeProtoPkgContext.jdField_b_of_type_Int;
              if (localDecodeProtoPkgContext.jdField_b_of_type_Int <= 0) {
                continue;
              }
              ((MessageRecord)localObject3).saveExtInfoToExtStr("bubble_sub_id", String.valueOf(localDecodeProtoPkgContext.jdField_b_of_type_Int));
              i2 = MessageProtoCodec.c(paramMsg);
              if (i2 <= 0) {
                continue;
              }
              ((MessageRecord)localObject3).saveExtInfoToExtStr("vip_pendant_diy_id", String.valueOf(i2));
              i2 = MessageProtoCodec.b(paramMsg);
              if (i2 < 0) {
                continue;
              }
              ((MessageRecord)localObject3).saveExtInfoToExtStr("vip_font_effect_id", String.valueOf(i2));
              i2 = MessageProtoCodec.e(paramMsg);
              if (i2 <= 0) {
                continue;
              }
              ((MessageRecord)localObject3).saveExtInfoToExtStr(MessageConstants.m, String.valueOf(i2));
              if (((MessageRecord)localObject3).istroop != 1008) {
                continue;
              }
              ApolloBaseInfo localApolloBaseInfo;
              try
              {
                if (localMsgHead.public_account_group_send_flag.has()) {
                  ((MessageRecord)localObject3).saveExtInfoToExtStr("public_account_send_flag", String.valueOf(localMsgHead.public_account_group_send_flag.get()));
                }
                if (l1 != -1L) {
                  ((MessageRecord)localObject3).saveExtInfoToExtStr("public_account_msg_id", String.valueOf(l1));
                }
                if ((localObject3 instanceof MessageForStructing))
                {
                  paramPBDecodeContext = (MessageForStructing)localObject3;
                  if ((paramPBDecodeContext.structingMsg != null) && (paramPBDecodeContext.structingMsg.mMsgServiceID == 76)) {
                    ((NowLiveManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(170)).a(paramPBDecodeContext);
                  }
                }
                localArrayList.add(localObject3);
                if (((MessageRecord)localObject3).msgtype == -2039)
                {
                  localObject4 = (MessageForApollo)localObject3;
                  localApolloManager = (ApolloManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(152);
                  paramPBDecodeContext = null;
                  if (QLog.isColorLevel()) {
                    paramPBDecodeContext = new StringBuilder("decode apollo c2c msg: ").append(", id: ").append(((MessageForApollo)localObject4).mApolloMessage.id).append(", name: ").append(new String(((MessageForApollo)localObject4).mApolloMessage.name)).append(", doubleAction: ").append(((MessageForApollo)localObject4).isDoubleAction()).append(", signTS: ").append(((MessageForApollo)localObject4).signTs);
                  }
                  i9 = ((MessageForApollo)localObject4).isSend();
                  if (((MessageForApollo)localObject4).mApolloMessage.peer_uin == 0L) {
                    continue;
                  }
                  i2 = 1;
                  if (((i2 & i9) == 0) || (((MessageForApollo)localObject4).mApolloMessage.peer_uin == this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getLongAccountUin())) {
                    continue;
                  }
                  localApolloBaseInfo = localApolloManager.b(((MessageForApollo)localObject4).mApolloMessage.peer_uin + "");
                  l2 = ((MessageForApollo)localObject4).mApolloMessage.peer_ts;
                  i2 = ((MessageForApollo)localObject4).mApolloMessage.peer_status;
                  if ((QLog.isColorLevel()) && (localApolloBaseInfo != null)) {
                    paramPBDecodeContext.append("\n fuin: ").append(localApolloBaseInfo.uin).append(", msg time: ").append(((MessageRecord)localObject3).time).append(", msg ts: ").append(l2).append(", svr ts: ").append(localApolloBaseInfo.apolloServerTS).append(", update time: ").append(localApolloBaseInfo.apolloUpdateTime).append(", status: ").append(i2);
                  }
                  if ((localApolloBaseInfo == null) || (((MessageRecord)localObject3).time <= localApolloBaseInfo.apolloUpdateTime) || (localApolloBaseInfo.apolloServerTS >= l2)) {
                    continue;
                  }
                  localApolloBaseInfo.apolloStatus = i2;
                  localApolloBaseInfo.apolloServerTS = l2;
                  localApolloBaseInfo.apolloVipFlag = (((MessageForApollo)localObject4).mApolloMessage.flag >> 30 & 0x1);
                  localApolloBaseInfo.apolloUpdateTime = ((MessageRecord)localObject3).time;
                  if ((((MessageForApollo)localObject4).isSend()) || (((MessageForApollo)localObject4).signTs <= NetConnInfoCenter.getServerTime()) || (((MessageForApollo)localObject4).signTs == localApolloBaseInfo.apolloSignValidTS)) {
                    continue;
                  }
                  localApolloBaseInfo.apolloSignValidTS = ((MessageForApollo)localObject4).signTs;
                  localApolloBaseInfo.apolloSignStr = "";
                  i2 = 1;
                  if (i2 != 0)
                  {
                    localApolloManager.a(localApolloBaseInfo);
                    if (QLog.isColorLevel()) {
                      paramPBDecodeContext.append("\n save apollo info fuin: ").append(localApolloBaseInfo.uin).append("-->").append(localApolloBaseInfo.apolloVipFlag).append("|").append(localApolloBaseInfo.apolloStatus).append("|").append(localApolloBaseInfo.apolloLocalTS).append("|").append(localApolloBaseInfo.apolloServerTS).append("|").append(localApolloBaseInfo.apolloUpdateTime).append("|").append(localApolloBaseInfo.apolloSignValidTS);
                    }
                  }
                  if (QLog.isColorLevel()) {
                    QLog.d("Q.msg.C2CMessageProcessor", 2, paramPBDecodeContext.toString());
                  }
                  if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null)
                  {
                    i2 = localApolloManager.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c());
                    if (((MessageForApollo)localObject4).msgType != 0) {
                      continue;
                    }
                    paramPBDecodeContext = String.valueOf(((MessageForApollo)localObject4).mApolloMessage.id);
                    VipUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "cmshow", "Apollo", "rev_action", String.valueOf(((MessageForApollo)localObject4).mApolloMessage.peer_uin), 0, ((MessageForApollo)localObject4).msgType, new String[] { paramPBDecodeContext, Integer.toString(i2), Integer.toString(ApolloManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface)), String.valueOf(System.currentTimeMillis() / 1000L) });
                  }
                }
                if ((!GoldMsgChatHelper.c((MessageRecord)localObject3)) || (l5 == this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getLongAccountUin())) {
                  continue;
                }
                GoldMsgChatHelper.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (MessageRecord)localObject3);
                continue;
                if (((MessageRecord)localObject3).msgtype == -2037) {
                  continue;
                }
                ((MessageRecord)localObject3).isread = localDecodeProtoPkgContext.jdField_a_of_type_Boolean;
              }
              catch (Throwable paramPBDecodeContext)
              {
                ApolloManager localApolloManager;
                QLog.e("Q.msg.C2CMessageProcessor", 2, "<---decodeMessage: ", paramPBDecodeContext);
                continue;
                i2 = 0;
                continue;
                localApolloBaseInfo = localApolloManager.b(((MessageForApollo)localObject4).senderuin);
                l2 = ((MessageForApollo)localObject4).mApolloMessage.sender_ts;
                i2 = ((MessageForApollo)localObject4).mApolloMessage.sender_status;
                continue;
                if (localApolloBaseInfo == null) {
                  continue;
                }
              }
              if ((((MessageForApollo)localObject4).isSend()) || (((MessageForApollo)localObject4).signTs <= NetConnInfoCenter.getServerTime()) || (((MessageForApollo)localObject4).signTs == localApolloBaseInfo.apolloSignValidTS)) {
                continue;
              }
              localApolloBaseInfo.apolloSignValidTS = ((MessageForApollo)localObject4).signTs;
              localApolloBaseInfo.apolloSignStr = "";
              i2 = 1;
              continue;
              if (((MessageForApollo)localObject4).msgType != 2) {
                continue;
              }
              paramPBDecodeContext = "" + ((MessageForApollo)localObject4).gameId;
              continue;
              if ((i1 != 1008) || (!paramMsg.msg_body.has())) {
                continue;
              }
              paramMsg = (im_msg_body.MsgBody)paramMsg.msg_body.get();
              if (!paramMsg.rich_text.has()) {
                continue;
              }
              paramMsg = (im_msg_body.RichText)paramMsg.rich_text.get();
              if (!paramMsg.elems.has()) {
                continue;
              }
              paramMsg = paramMsg.elems.get().iterator();
              if (!paramMsg.hasNext()) {
                continue;
              }
              paramPBDecodeContext = (im_msg_body.Elem)paramMsg.next();
              if (!paramPBDecodeContext.pub_acc_info.has()) {
                continue;
              }
              n = paramPBDecodeContext.pub_acc_info.uint32_is_inter_num.get();
              paramMsg = paramPBDecodeContext.pub_acc_info.string_msg_template_id.get();
              if (n == 0) {
                continue;
              }
              paramPBDecodeContext = localArrayList.iterator();
              if (!paramPBDecodeContext.hasNext()) {
                continue;
              }
              ((MessageRecord)paramPBDecodeContext.next()).saveExtInfoToExtStr("inter_num", String.valueOf(n));
              continue;
              paramPBDecodeContext = localArrayList.iterator();
              if (!paramPBDecodeContext.hasNext()) {
                continue;
              }
              ((MessageRecord)paramPBDecodeContext.next()).saveExtInfoToExtStr("msg_template_id", paramMsg);
              continue;
              MsgAutoMonitorUtil.a().f(System.currentTimeMillis() - l4);
              return localArrayList;
              paramPBDecodeContext = "";
              continue;
              i2 = 0;
              continue;
              continue;
              continue;
              n = 0;
              continue;
            }
            i2 += 1;
          }
          l1 = ((Long)paramPBDecodeContext.second).longValue();
          break;
          label1134:
          localDecodeProtoPkgContext.f = false;
          break label424;
          label1143:
          paramPBDecodeContext = (Serializable)paramPBDecodeContext.first;
          break label626;
          if (localDecodeProtoPkgContext.jdField_e_of_type_Long != 0L) {
            break label687;
          }
          QLog.e("Q.msg.C2CMessageProcessor", 1, "<---decodeSinglePBMsg_C2C : decode msg: frienduin=0");
          break label687;
          if ((((TempSessionInfo)localObject1).jdField_a_of_type_Int != 1000) && (((TempSessionInfo)localObject1).jdField_a_of_type_Int != 1020))
          {
            n = i1;
            if (((TempSessionInfo)localObject1).jdField_a_of_type_Int != 1004) {
              break label752;
            }
          }
          localDecodeProtoPkgContext.jdField_b_of_type_Long = ((TempSessionInfo)localObject1).jdField_b_of_type_Long;
          n = i1;
          break label752;
          label1228:
          return localArrayList;
          label1231:
          n = 1034;
          break label821;
          label1238:
          if (paramMsg.appshare_info.has())
          {
            MessageProtoCodec.a(this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler, paramPBDecodeContext, paramMsg, 0L, 0L, localDecodeProtoPkgContext.jdField_d_of_type_Boolean);
            n = 0;
          }
          else
          {
            if ((MessageUtils.c(i6)) && (localMsgHead.c2c_cmd.has())) {}
            switch (i2)
            {
            default: 
              n = 0;
              break;
            case 169: 
            case 241: 
            case 242: 
            case 243: 
              localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler;
              l1 = localDecodeProtoPkgContext.jdField_e_of_type_Long;
              bool1 = localDecodeProtoPkgContext.jdField_a_of_type_Boolean;
              bool2 = localDecodeProtoPkgContext.jdField_b_of_type_Boolean;
              if (l5 == localDecodeProtoPkgContext.jdField_a_of_type_Long) {}
              for (i9 = 1;; i9 = 0)
              {
                MessageProtoCodec.a((MessageHandler)localObject1, paramPBDecodeContext, i2, paramMsg, l1, bool1, bool2, i9, localDecodeProtoPkgContext.jdField_d_of_type_Long, localDecodeProtoPkgContext.jdField_d_of_type_Boolean, localDecodeProtoPkgContext.jdField_a_of_type_Int);
                n = 0;
                break;
              }
            case 11: 
            case 175: 
              MessageProtoCodec.a(this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler, paramPBDecodeContext, paramMsg, localDecodeProtoPkgContext.jdField_e_of_type_Long, localDecodeProtoPkgContext.jdField_b_of_type_Boolean, localDecodeProtoPkgContext.jdField_a_of_type_Boolean, localDecodeProtoPkgContext.jdField_d_of_type_Boolean);
              n = 0;
              break;
            case 193: 
              n = 0;
              break;
            case 129: 
            case 131: 
            case 133: 
              MessageProtoCodec.a(this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler, paramMsg, localDecodeProtoPkgContext.jdField_e_of_type_Long, localDecodeProtoPkgContext.jdField_a_of_type_Boolean, localDecodeProtoPkgContext.jdField_b_of_type_Boolean, localDecodeProtoPkgContext.jdField_d_of_type_Long, localDecodeProtoPkgContext.jdField_a_of_type_Int);
              n = 0;
              continue;
              if (i6 == 208)
              {
                MessageProtoCodec.a(this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler, paramPBDecodeContext, paramMsg);
                n = 0;
              }
              else
              {
                if (i6 == 193)
                {
                  if (!localDecodeProtoPkgContext.jdField_d_of_type_Boolean)
                  {
                    MessageProtoCodec.c(this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler, paramMsg, localDecodeProtoPkgContext);
                    n = 0;
                  }
                }
                else
                {
                  if (i6 == 734)
                  {
                    MessageProtoCodec.a(this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler, paramMsg, localDecodeProtoPkgContext);
                    n = 0;
                    continue;
                  }
                  if (i6 == 562)
                  {
                    MessageProtoCodec.b(this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler, paramMsg, localDecodeProtoPkgContext);
                    n = 0;
                    continue;
                  }
                  if (i6 == 519)
                  {
                    if ((!localDecodeProtoPkgContext.jdField_d_of_type_Boolean) && (VideoConstants.jdField_a_of_type_Boolean))
                    {
                      MessageProtoCodec.a(this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler, paramMsg, localDecodeProtoPkgContext.jdField_a_of_type_Boolean, localDecodeProtoPkgContext.f);
                      n = 0;
                    }
                  }
                  else
                  {
                    if (SystemMsg.isSystemMessage(i6))
                    {
                      if (QLog.isColorLevel()) {
                        QLog.d("Q.systemmsg.", 2, "friend system msg notify");
                      }
                      n = 0;
                      if ((i6 == 188) || (i6 == 189)) {
                        n = 1;
                      }
                      if ((!localDecodeProtoPkgContext.jdField_c_of_type_Boolean) && (n == 0)) {
                        this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler.a().a(2);
                      }
                      localDecodeProtoPkgContext.jdField_e_of_type_Long = 9998L;
                      MessageProtoCodec.a(this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler, paramMsg, localDecodeProtoPkgContext.jdField_a_of_type_Boolean, localDecodeProtoPkgContext.f, localDecodeProtoPkgContext.jdField_d_of_type_Boolean, i7);
                      MessageProtoCodec.a(this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler, l5, i7, l6, i6);
                      return localArrayList;
                    }
                    if (a(i6))
                    {
                      a(paramPBDecodeContext, paramMsg, localDecodeProtoPkgContext.jdField_d_of_type_Boolean);
                      n = 0;
                      continue;
                    }
                    if (732 == i6)
                    {
                      a(paramPBDecodeContext, paramMsg, i7, l5, l6, i6, localDecodeProtoPkgContext.jdField_d_of_type_Boolean);
                      n = 0;
                      continue;
                    }
                    if (524 == i6)
                    {
                      if ((paramPBDecodeContext == null) || (paramMsg == null) || (!paramMsg.msg_body.has()) || (!paramMsg.msg_body.msg_content.has())) {
                        return localArrayList;
                      }
                      localObject1 = paramMsg.msg_body.msg_content.get().toByteArray();
                      PkgTools.a((byte[])localObject1, 0);
                      n = localObject1[4];
                      if (n == 25) {
                        if (!localDecodeProtoPkgContext.jdField_d_of_type_Boolean) {
                          DiscMessageProcessor.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (byte[])localObject1, 5, null, false);
                        }
                      }
                      for (;;)
                      {
                        n = 0;
                        break;
                        if (n == 35)
                        {
                          QLog.i("ApolloPushManager", 1, "[discuss.OffLine]");
                          if (!localDecodeProtoPkgContext.jdField_d_of_type_Boolean) {
                            DiscMessageProcessor.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (byte[])localObject1, 5, null, false);
                          }
                        }
                      }
                    }
                    if (SystemMsg.isTroopSystemMessage(i6))
                    {
                      n = 0;
                      if ((i6 == 85) || (i6 == 36)) {
                        n = 1;
                      }
                      if ((!localDecodeProtoPkgContext.jdField_c_of_type_Boolean) && (n == 0)) {
                        this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler.a().a(3, 1, false);
                      }
                      localDecodeProtoPkgContext.jdField_e_of_type_Long = 9998L;
                      MessageProtoCodec.a(this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler, paramMsg, localDecodeProtoPkgContext.jdField_a_of_type_Boolean, localDecodeProtoPkgContext.f, localDecodeProtoPkgContext.jdField_d_of_type_Boolean);
                      if (n == 0) {
                        GroupSystemMsgController.a().a(l5, l3, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
                      }
                      return localArrayList;
                    }
                    if (i6 == 528)
                    {
                      if (!localDecodeProtoPkgContext.jdField_d_of_type_Boolean)
                      {
                        MessageProtoCodec.a(this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler, localDecodeProtoPkgContext.jdField_a_of_type_Long, paramMsg, localDecodeProtoPkgContext.h, localDecodeProtoPkgContext.jdField_d_of_type_Boolean);
                        n = 0;
                      }
                    }
                    else
                    {
                      if (i6 == 529)
                      {
                        if (((msg_comm.MsgHead)paramMsg.msg_head.get()).c2c_tmp_msg_head.has())
                        {
                          i1 = 1;
                          localObject1 = MessageProtoCodec.a(paramMsg);
                          if (((TempSessionInfo)localObject1).jdField_a_of_type_Int == -1)
                          {
                            n = 0;
                            if (n == 0) {
                              break label5275;
                            }
                            MessageProtoCodec.a(this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler, paramPBDecodeContext, paramMsg, (TempSessionInfo)localObject1, localDecodeProtoPkgContext);
                            n = ((TempSessionInfo)localObject1).jdField_a_of_type_Int;
                            if ((paramPBDecodeContext.size() <= 0) || (!ConfessMsgUtil.a((MessageRecord)paramPBDecodeContext.get(0)))) {
                              break label5272;
                            }
                            if (!((MessageRecord)paramPBDecodeContext.get(0)).isSelfConfessor()) {
                              break label2471;
                            }
                            n = 1033;
                            label2262:
                            ((TempSessionInfo)localObject1).jdField_a_of_type_Int = n;
                            n = ((TempSessionInfo)localObject1).jdField_a_of_type_Int;
                            i1 = n;
                            if (n == 1006)
                            {
                              QLog.e("Q.msg.C2CMessageProcessor", 1, "decodeMessage FileMsg, tempInfo has Uin [" + ((msg_comm.C2CTmpMsgHead)((msg_comm.MsgHead)paramMsg.msg_head.get()).c2c_tmp_msg_head.get()).from_phone.has() + "]");
                              i1 = n;
                            }
                            localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler;
                            l1 = localDecodeProtoPkgContext.jdField_e_of_type_Long;
                            bool1 = localDecodeProtoPkgContext.jdField_a_of_type_Boolean;
                            bool2 = localDecodeProtoPkgContext.jdField_b_of_type_Boolean;
                            if (l5 != localDecodeProtoPkgContext.jdField_a_of_type_Long) {
                              break label2627;
                            }
                          }
                        }
                        for (i9 = 1;; i9 = 0)
                        {
                          MessageProtoCodec.a((MessageHandler)localObject1, paramPBDecodeContext, paramMsg, l1, bool1, bool2, i9, localDecodeProtoPkgContext.jdField_d_of_type_Long, localDecodeProtoPkgContext.jdField_d_of_type_Boolean, localDecodeProtoPkgContext.jdField_a_of_type_Int);
                          n = 0;
                          break;
                          if ((((TempSessionInfo)localObject1).jdField_a_of_type_Int != 1000) && (((TempSessionInfo)localObject1).jdField_a_of_type_Int != 1020))
                          {
                            n = i1;
                            if (((TempSessionInfo)localObject1).jdField_a_of_type_Int != 1004) {
                              break label2200;
                            }
                          }
                          localDecodeProtoPkgContext.jdField_b_of_type_Long = ((TempSessionInfo)localObject1).jdField_b_of_type_Long;
                          n = i1;
                          break label2200;
                          n = 1034;
                          break label2262;
                          localObject1 = (FriendsManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(50);
                          if (BmqqSegmentUtil.a(BaseApplicationImpl.getContext(), String.valueOf(((msg_comm.MsgHead)paramMsg.msg_head.get()).from_uin.get())))
                          {
                            i1 = n;
                            if (((FriendsManager)localObject1).b(String.valueOf(((msg_comm.MsgHead)paramMsg.msg_head.get()).from_uin.get()))) {
                              break label2343;
                            }
                            i1 = 1025;
                            break label2343;
                          }
                          i1 = n;
                          if (!BmqqSegmentUtil.a(BaseApplicationImpl.getContext(), String.valueOf(((msg_comm.MsgHead)paramMsg.msg_head.get()).to_uin.get()))) {
                            break label2343;
                          }
                          i1 = n;
                          if (((FriendsManager)localObject1).b(String.valueOf(((msg_comm.MsgHead)paramMsg.msg_head.get()).to_uin.get()))) {
                            break label2343;
                          }
                          i1 = 1025;
                          break label2343;
                        }
                      }
                      if (i6 == 38)
                      {
                        localObject1 = String.valueOf(EndianUtil.a(paramMsg.msg_body.msg_content.get().toByteArray()));
                        localObject2 = (TroopManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(51);
                        if ((localObject2 != null) && (((TroopManager)localObject2).a((String)localObject1) == null))
                        {
                          localObject3 = new TroopInfo();
                          ((TroopInfo)localObject3).troopuin = ((String)localObject1);
                          ((TroopInfo)localObject3).dwAdditionalFlag = 1L;
                          ((TroopManager)localObject2).b((TroopInfo)localObject3);
                        }
                        localObject2 = (TroopHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(20);
                        if (localObject2 != null) {
                          this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getHandler(getClass()).postDelayed(new zzd(this, (TroopHandler)localObject2, (String)localObject1), 2000L);
                        }
                        MessageProtoCodec.a(this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler, l5, i7, l6, i6);
                      }
                    }
                  }
                }
                n = 0;
              }
              break;
            }
          }
        }
        l1 = l3;
        localObject2 = paramPBDecodeContext.iterator();
        for (;;)
        {
          if (!((Iterator)localObject2).hasNext()) {
            break label5042;
          }
          localObject3 = (MessageRecord)((Iterator)localObject2).next();
          if ((localObject3 != null) && ((localDecodeProtoPkgContext.jdField_b_of_type_Long != 3338705755L) || (!PublicAccountUtil.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface))) && ((localDecodeProtoPkgContext.jdField_b_of_type_Long != 2171946401L) || (!ReadInJoyUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface))))
          {
            if (localDecodeProtoPkgContext.jdField_b_of_type_Long == 2171946401L) {
              PublicAccountUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, true);
            }
            if (((i1 != 1025) && (i1 != 1024)) || (((MessageRecord)localObject3).msgtype != -1000) || (!((MessageRecord)localObject3).msg.startsWith("default:SigT=")))
            {
              if (MsgProxyUtils.a(i1) != 1032) {
                break;
              }
              localObject1 = null;
              paramPBDecodeContext = (PBDecodeContext)localObject1;
              if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null)
              {
                localObject4 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a();
                paramPBDecodeContext = (PBDecodeContext)localObject1;
                if (localObject4 != null) {
                  paramPBDecodeContext = ((MessageCache)localObject4).a(String.valueOf(localDecodeProtoPkgContext.jdField_e_of_type_Long), String.valueOf(localDecodeProtoPkgContext.jdField_a_of_type_Long));
                }
              }
              MessageProtoCodec.a(this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler, l5, i7, l6, i6, paramPBDecodeContext);
              if (i1 != 1032) {
                break;
              }
              if (QLog.isColorLevel()) {
                QLog.i("Q.msg.C2CMessageProcessor", 2, String.format("decodeMessage discard confess msg senderUin:%s msgSeq:%d msgType:%d", new Object[] { Long.toString(l5), Integer.valueOf(i7), Integer.valueOf(i6) }));
              }
            }
          }
        }
      }
      label2471:
      i3 = 0;
      label5272:
      label5275:
      label5280:
      i4 = 0;
      i5 = 0;
    }
  }
  
  public void a(int paramInt, ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg)
  {
    switch (paramInt)
    {
    default: 
      return;
    case 2001: 
      b(paramToServiceMsg, paramFromServiceMsg);
      return;
    }
    a(paramToServiceMsg, paramFromServiceMsg, false);
  }
  
  public void a(int paramInt, Object... paramVarArgs)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.msg.C2CMessageProcessor", 2, "processType" + paramInt);
    }
    switch (paramInt)
    {
    default: 
      return;
    case 1001: 
      if ((paramVarArgs != null) && (paramVarArgs.length == 3))
      {
        a((msg_comm.Msg)paramVarArgs[0], (FromServiceMsg)paramVarArgs[1], (msg_onlinepush.PbPushMsg)paramVarArgs[2]);
        return;
      }
      a(getClass().getName(), paramInt);
      return;
    case 1002: 
      if ((paramVarArgs != null) && (paramVarArgs.length == 3))
      {
        a((ToServiceMsg)paramVarArgs[0], (FromServiceMsg)paramVarArgs[1], paramVarArgs[2]);
        return;
      }
      a(getClass().getName(), paramInt);
      return;
    case 2001: 
      if ((paramVarArgs != null) && (paramVarArgs.length == 3))
      {
        b((ToServiceMsg)paramVarArgs[0], (FromServiceMsg)paramVarArgs[1], paramVarArgs[2]);
        return;
      }
      a(getClass().getName(), paramInt);
      return;
    case 2005: 
      if ((paramVarArgs != null) && (paramVarArgs.length == 3))
      {
        d((ToServiceMsg)paramVarArgs[0], (FromServiceMsg)paramVarArgs[1], paramVarArgs[2]);
        return;
      }
      a(getClass().getName(), paramInt);
      return;
    case 1003: 
      if ((paramVarArgs != null) && (paramVarArgs.length == 3))
      {
        c((ToServiceMsg)paramVarArgs[0], (FromServiceMsg)paramVarArgs[1], paramVarArgs[2]);
        return;
      }
      a(getClass().getName(), paramInt);
      return;
    }
    if ((paramVarArgs != null) && (paramVarArgs.length == 3))
    {
      b((msg_comm.Msg)paramVarArgs[0], (FromServiceMsg)paramVarArgs[1], (msg_onlinepush.PbPushMsg)paramVarArgs[2]);
      return;
    }
    a(getClass().getName(), paramInt);
  }
  
  public void a(MessageForPtt paramMessageForPtt1, MessageForPtt paramMessageForPtt2)
  {
    bool2 = false;
    bool1 = bool2;
    if (paramMessageForPtt1.getPttStreamFlag() == 10001)
    {
      bool1 = bool2;
      if (!TextUtils.isEmpty(paramMessageForPtt2.directUrl))
      {
        bool1 = bool2;
        if (!TextUtils.isEmpty(paramMessageForPtt1.directUrl)) {}
      }
    }
    try
    {
      paramMessageForPtt1.directUrl = paramMessageForPtt2.directUrl;
      paramMessageForPtt1.serial();
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramMessageForPtt1.frienduin, paramMessageForPtt1.istroop, paramMessageForPtt1.uniseq, paramMessageForPtt1.msgData);
      bool1 = true;
    }
    catch (Exception paramMessageForPtt1)
    {
      for (;;)
      {
        paramMessageForPtt1.printStackTrace();
        bool1 = bool2;
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d("Q.msg.C2CMessageProcessor", 2, "updateStreamPttDirectUrl : " + bool1);
    }
  }
  
  public void a(ArrayList paramArrayList)
  {
    Iterator localIterator = paramArrayList.iterator();
    while (localIterator.hasNext())
    {
      MessageRecord localMessageRecord = (MessageRecord)localIterator.next();
      if ((localMessageRecord.msgtype == -3006) || (localMessageRecord.msgtype == -5004))
      {
        PAMessage localPAMessage = XMLMessageUtils.a(localMessageRecord);
        if ((localPAMessage != null) && (localPAMessage.mMsgId > 0L)) {
          ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Pb_account_lifeservice", localMessageRecord.frienduin, "mp_msg_sys_15", "msg_get", 0, 1, 0, Long.toString(localPAMessage.mMsgId), "", "", "");
        }
      }
      if ((localMessageRecord.mQidianMasterUin != 0L) && (!TextUtils.isEmpty(localMessageRecord.mQidianTipText)) && (localMessageRecord.mIsShowQidianTips == 1)) {
        ThreadManager.executeOnSubThread(new zzh(this, localMessageRecord));
      }
    }
    this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler.b(paramArrayList);
  }
  
  public void a(ArrayList paramArrayList, msg_comm.Msg paramMsg, int paramInt1, long paramLong1, long paramLong2, int paramInt2, boolean paramBoolean)
  {
    if ((paramArrayList == null) || (paramMsg == null) || (!paramMsg.msg_body.has()) || (!paramMsg.msg_body.msg_content.has())) {}
    Object localObject;
    int n;
    do
    {
      do
      {
        do
        {
          byte[] arrayOfByte1;
          do
          {
            do
            {
              return;
              arrayOfByte1 = paramMsg.msg_body.msg_content.get().toByteArray();
              localObject = new byte[arrayOfByte1.length];
              PkgTools.a((byte[])localObject, 0, arrayOfByte1, 0, localObject.length);
            } while (localObject.length < 5);
            n = localObject[4];
            if (QLog.isColorLevel()) {
              QLog.d("Q.msg.C2CMessageProcessor", 2, "<---hotchat and opentroop push  groupCode:" + PkgTools.a(arrayOfByte1, 0) + " subType:" + n);
            }
            if ((n != 12) && (n != 14)) {
              break;
            }
          } while (!((TroopGagMgr)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(47)).a((byte[])localObject, paramInt1));
          return;
          if ((n != 16) && (n != 17)) {
            break;
          }
          localObject = new C2CMessageProcessor.Parse0x2dcContext(this);
          if (arrayOfByte1.length > 7)
          {
            TroopTipsMsgMgr localTroopTipsMsgMgr = (TroopTipsMsgMgr)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(80);
            byte[] arrayOfByte2 = new byte[arrayOfByte1.length - 7];
            PkgTools.a(arrayOfByte2, 0, arrayOfByte1, 7, arrayOfByte2.length);
            paramArrayList.add(localTroopTipsMsgMgr.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, arrayOfByte2, paramInt1, paramMsg.msg_head.msg_time.get(), true, paramBoolean, (C2CMessageProcessor.Parse0x2dcContext)localObject));
          }
        } while (!((C2CMessageProcessor.Parse0x2dcContext)localObject).jdField_a_of_type_Boolean);
        MessageProtoCodec.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(), paramLong1, paramInt1, paramLong2, paramInt2);
      } while (!QLog.isColorLevel());
      QLog.d("Q.msg.C2CMessageProcessor", 2, String.format("handle0x2dcMessage==>sendDelMsgReqToServer fromUin:%d, seq:%d, msgUid:%d, msgType:%d", new Object[] { Long.valueOf(paramLong1), Integer.valueOf(paramInt1), Long.valueOf(paramLong2), Integer.valueOf(paramInt2) }));
      return;
    } while (n != 3);
    a((byte[])localObject);
  }
  
  /* Error */
  public void a(ArrayList paramArrayList, boolean paramBoolean)
  {
    // Byte code:
    //   0: aload_1
    //   1: ifnull +10 -> 11
    //   4: aload_1
    //   5: invokevirtual 130	java/util/ArrayList:size	()I
    //   8: ifne +4 -> 12
    //   11: return
    //   12: invokestatic 2331	com/tencent/common/app/BaseApplicationImpl:getApplication	()Lcom/tencent/common/app/BaseApplicationImpl;
    //   15: aload_0
    //   16: getfield 63	com/tencent/mobileqq/app/message/C2CMessageProcessor:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   19: invokevirtual 73	com/tencent/mobileqq/app/QQAppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   22: invokestatic 2334	com/tencent/mobileqq/activity/UserguideActivity:a	(Landroid/content/Context;Ljava/lang/String;)Z
    //   25: ifne -14 -> 11
    //   28: invokestatic 2331	com/tencent/common/app/BaseApplicationImpl:getApplication	()Lcom/tencent/common/app/BaseApplicationImpl;
    //   31: invokevirtual 2335	com/tencent/common/app/BaseApplicationImpl:getApplicationContext	()Landroid/content/Context;
    //   34: aload_0
    //   35: getfield 63	com/tencent/mobileqq/app/message/C2CMessageProcessor:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   38: invokestatic 2340	com/tencent/mobileqq/util/NoDisturbUtil:a	(Landroid/content/Context;Lcom/tencent/common/app/AppInterface;)Z
    //   41: ifeq -30 -> 11
    //   44: aload_1
    //   45: invokevirtual 246	java/util/ArrayList:iterator	()Ljava/util/Iterator;
    //   48: astore 7
    //   50: aload 7
    //   52: invokeinterface 251 1 0
    //   57: ifeq +1587 -> 1644
    //   60: aload 7
    //   62: invokeinterface 255 1 0
    //   67: checkcast 257	com/tencent/mobileqq/data/MessageRecord
    //   70: astore 8
    //   72: aload 8
    //   74: getfield 271	com/tencent/mobileqq/data/MessageRecord:istroop	I
    //   77: invokestatic 1957	com/tencent/mobileqq/app/message/MsgProxyUtils:r	(I)Z
    //   80: ifeq -30 -> 50
    //   83: aload 8
    //   85: invokestatic 2341	com/tencent/mobileqq/app/message/MsgProxyUtils:c	(Lcom/tencent/mobileqq/data/MessageRecord;)Z
    //   88: ifeq -38 -> 50
    //   91: aload_0
    //   92: getfield 63	com/tencent/mobileqq/app/message/C2CMessageProcessor:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   95: aload 8
    //   97: invokestatic 2343	com/tencent/mobileqq/app/message/MsgProxyUtils:c	(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/mobileqq/data/MessageRecord;)Z
    //   100: ifne -50 -> 50
    //   103: aload 8
    //   105: invokevirtual 2033	com/tencent/mobileqq/data/MessageRecord:isSend	()Z
    //   108: ifne -58 -> 50
    //   111: aload 8
    //   113: getfield 1202	com/tencent/mobileqq/data/MessageRecord:isread	Z
    //   116: ifne -66 -> 50
    //   119: iconst_1
    //   120: istore_3
    //   121: iload_3
    //   122: ifeq -111 -> 11
    //   125: aload_0
    //   126: getfield 63	com/tencent/mobileqq/app/message/C2CMessageProcessor:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   129: bipush 50
    //   131: invokevirtual 391	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   134: checkcast 904	com/tencent/mobileqq/app/FriendsManager
    //   137: aload_0
    //   138: getfield 63	com/tencent/mobileqq/app/message/C2CMessageProcessor:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   141: invokevirtual 73	com/tencent/mobileqq/app/QQAppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   144: invokevirtual 2346	com/tencent/mobileqq/app/FriendsManager:a	(Ljava/lang/String;)Lcom/tencent/mobileqq/data/Card;
    //   147: astore 7
    //   149: aload_0
    //   150: getfield 63	com/tencent/mobileqq/app/message/C2CMessageProcessor:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   153: invokevirtual 364	com/tencent/mobileqq/app/QQAppInterface:a	()Lcom/tencent/mobileqq/app/message/QQMessageFacade;
    //   156: astore 10
    //   158: aload 7
    //   160: ifnonnull +566 -> 726
    //   163: invokestatic 160	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   166: ifeq +1472 -> 1638
    //   169: ldc 162
    //   171: iconst_2
    //   172: ldc_w 2348
    //   175: invokestatic 179	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   178: iconst_1
    //   179: istore 4
    //   181: aload_0
    //   182: getfield 63	com/tencent/mobileqq/app/message/C2CMessageProcessor:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   185: bipush 105
    //   187: invokevirtual 391	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   190: checkcast 2350	com/tencent/mobileqq/nearby/NearbyCardManager
    //   193: invokevirtual 2351	com/tencent/mobileqq/nearby/NearbyCardManager:a	()Z
    //   196: istore 6
    //   198: invokestatic 160	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   201: ifeq +42 -> 243
    //   204: ldc_w 2353
    //   207: iconst_2
    //   208: new 107	java/lang/StringBuilder
    //   211: dup
    //   212: invokespecial 108	java/lang/StringBuilder:<init>	()V
    //   215: ldc_w 2355
    //   218: invokevirtual 168	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   221: iload 4
    //   223: invokevirtual 171	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   226: ldc_w 2357
    //   229: invokevirtual 168	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   232: iload 6
    //   234: invokevirtual 720	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   237: invokevirtual 176	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   240: invokestatic 179	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   243: aload_0
    //   244: getfield 2358	com/tencent/mobileqq/app/message/C2CMessageProcessor:jdField_a_of_type_Boolean	Z
    //   247: ifne +293 -> 540
    //   250: invokestatic 2363	com/tencent/mobileqq/app/DeviceProfileManager:a	()Lcom/tencent/mobileqq/app/DeviceProfileManager;
    //   253: getstatic 2369	com/tencent/mobileqq/app/DeviceProfileManager$DpcNames:OneyWayDateMsgNotifyCfg	Lcom/tencent/mobileqq/app/DeviceProfileManager$DpcNames;
    //   256: invokevirtual 2371	com/tencent/mobileqq/app/DeviceProfileManager$DpcNames:name	()Ljava/lang/String;
    //   259: invokevirtual 2373	com/tencent/mobileqq/app/DeviceProfileManager:a	(Ljava/lang/String;)Ljava/lang/String;
    //   262: astore 8
    //   264: invokestatic 2363	com/tencent/mobileqq/app/DeviceProfileManager:a	()Lcom/tencent/mobileqq/app/DeviceProfileManager;
    //   267: getstatic 2376	com/tencent/mobileqq/app/DeviceProfileManager$DpcNames:OneyWayLBSFriendMsgNotifyCfg	Lcom/tencent/mobileqq/app/DeviceProfileManager$DpcNames;
    //   270: invokevirtual 2371	com/tencent/mobileqq/app/DeviceProfileManager$DpcNames:name	()Ljava/lang/String;
    //   273: invokevirtual 2373	com/tencent/mobileqq/app/DeviceProfileManager:a	(Ljava/lang/String;)Ljava/lang/String;
    //   276: astore 7
    //   278: aload 8
    //   280: ldc_w 2378
    //   283: invokevirtual 2382	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   286: astore 8
    //   288: aload 7
    //   290: ldc_w 2378
    //   293: invokevirtual 2382	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   296: astore 7
    //   298: aload 8
    //   300: arraylength
    //   301: bipush 6
    //   303: if_icmplt +232 -> 535
    //   306: aload 7
    //   308: arraylength
    //   309: bipush 6
    //   311: if_icmplt +224 -> 535
    //   314: aload_0
    //   315: aload 8
    //   317: iconst_0
    //   318: aaload
    //   319: invokestatic 2385	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   322: putfield 35	com/tencent/mobileqq/app/message/C2CMessageProcessor:d	I
    //   325: aload_0
    //   326: aload 8
    //   328: iconst_1
    //   329: aaload
    //   330: invokestatic 2385	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   333: putfield 37	com/tencent/mobileqq/app/message/C2CMessageProcessor:e	I
    //   336: aload_0
    //   337: aload 8
    //   339: iconst_2
    //   340: aaload
    //   341: invokestatic 2385	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   344: putfield 39	com/tencent/mobileqq/app/message/C2CMessageProcessor:f	I
    //   347: aload_0
    //   348: aload 8
    //   350: iconst_3
    //   351: aaload
    //   352: invokestatic 2385	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   355: putfield 41	com/tencent/mobileqq/app/message/C2CMessageProcessor:g	I
    //   358: aload_0
    //   359: aload 7
    //   361: iconst_0
    //   362: aaload
    //   363: invokestatic 2385	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   366: putfield 43	com/tencent/mobileqq/app/message/C2CMessageProcessor:i	I
    //   369: aload_0
    //   370: aload 7
    //   372: iconst_1
    //   373: aaload
    //   374: invokestatic 2385	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   377: putfield 45	com/tencent/mobileqq/app/message/C2CMessageProcessor:j	I
    //   380: aload_0
    //   381: aload 7
    //   383: iconst_2
    //   384: aaload
    //   385: invokestatic 2385	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   388: putfield 47	com/tencent/mobileqq/app/message/C2CMessageProcessor:k	I
    //   391: aload_0
    //   392: aload 7
    //   394: iconst_3
    //   395: aaload
    //   396: invokestatic 2385	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   399: putfield 49	com/tencent/mobileqq/app/message/C2CMessageProcessor:l	I
    //   402: invokestatic 2388	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   405: ifeq +130 -> 535
    //   408: ldc_w 2390
    //   411: iconst_4
    //   412: new 107	java/lang/StringBuilder
    //   415: dup
    //   416: invokespecial 108	java/lang/StringBuilder:<init>	()V
    //   419: ldc_w 2392
    //   422: invokevirtual 168	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   425: aload_0
    //   426: getfield 35	com/tencent/mobileqq/app/message/C2CMessageProcessor:d	I
    //   429: invokevirtual 171	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   432: ldc_w 2160
    //   435: invokevirtual 168	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   438: aload_0
    //   439: getfield 37	com/tencent/mobileqq/app/message/C2CMessageProcessor:e	I
    //   442: invokevirtual 171	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   445: ldc_w 2160
    //   448: invokevirtual 168	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   451: aload_0
    //   452: getfield 39	com/tencent/mobileqq/app/message/C2CMessageProcessor:f	I
    //   455: invokevirtual 171	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   458: ldc_w 2160
    //   461: invokevirtual 168	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   464: aload_0
    //   465: getfield 41	com/tencent/mobileqq/app/message/C2CMessageProcessor:g	I
    //   468: invokevirtual 171	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   471: ldc_w 2394
    //   474: invokevirtual 168	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   477: aload_0
    //   478: getfield 43	com/tencent/mobileqq/app/message/C2CMessageProcessor:i	I
    //   481: invokevirtual 171	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   484: ldc_w 2160
    //   487: invokevirtual 168	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   490: aload_0
    //   491: getfield 45	com/tencent/mobileqq/app/message/C2CMessageProcessor:j	I
    //   494: invokevirtual 171	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   497: ldc_w 2160
    //   500: invokevirtual 168	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   503: aload_0
    //   504: getfield 47	com/tencent/mobileqq/app/message/C2CMessageProcessor:k	I
    //   507: invokevirtual 171	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   510: ldc_w 2160
    //   513: invokevirtual 168	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   516: aload_0
    //   517: getfield 49	com/tencent/mobileqq/app/message/C2CMessageProcessor:l	I
    //   520: invokevirtual 171	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   523: ldc_w 1854
    //   526: invokevirtual 168	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   529: invokevirtual 176	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   532: invokestatic 179	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   535: aload_0
    //   536: iconst_1
    //   537: putfield 2358	com/tencent/mobileqq/app/message/C2CMessageProcessor:jdField_a_of_type_Boolean	Z
    //   540: invokestatic 2331	com/tencent/common/app/BaseApplicationImpl:getApplication	()Lcom/tencent/common/app/BaseApplicationImpl;
    //   543: new 107	java/lang/StringBuilder
    //   546: dup
    //   547: invokespecial 108	java/lang/StringBuilder:<init>	()V
    //   550: aload_0
    //   551: getfield 63	com/tencent/mobileqq/app/message/C2CMessageProcessor:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   554: invokevirtual 73	com/tencent/mobileqq/app/QQAppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   557: invokevirtual 168	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   560: ldc_w 2396
    //   563: invokevirtual 168	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   566: invokevirtual 176	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   569: iconst_0
    //   570: invokevirtual 2400	com/tencent/common/app/BaseApplicationImpl:getSharedPreferences	(Ljava/lang/String;I)Landroid/content/SharedPreferences;
    //   573: astore 11
    //   575: ldc_w 441
    //   578: astore 8
    //   580: ldc_w 441
    //   583: astore 9
    //   585: aload 8
    //   587: astore 7
    //   589: aload_0
    //   590: getfield 51	com/tencent/mobileqq/app/message/C2CMessageProcessor:jdField_a_of_type_JavaUtilHashSet	Ljava/util/HashSet;
    //   593: ifnonnull +145 -> 738
    //   596: aload_0
    //   597: monitorenter
    //   598: aload 8
    //   600: astore 7
    //   602: aload_0
    //   603: getfield 51	com/tencent/mobileqq/app/message/C2CMessageProcessor:jdField_a_of_type_JavaUtilHashSet	Ljava/util/HashSet;
    //   606: ifnonnull +130 -> 736
    //   609: aload_0
    //   610: new 26	java/util/HashSet
    //   613: dup
    //   614: invokespecial 29	java/util/HashSet:<init>	()V
    //   617: putfield 51	com/tencent/mobileqq/app/message/C2CMessageProcessor:jdField_a_of_type_JavaUtilHashSet	Ljava/util/HashSet;
    //   620: aload 11
    //   622: new 107	java/lang/StringBuilder
    //   625: dup
    //   626: invokespecial 108	java/lang/StringBuilder:<init>	()V
    //   629: aload_0
    //   630: getfield 63	com/tencent/mobileqq/app/message/C2CMessageProcessor:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   633: invokevirtual 73	com/tencent/mobileqq/app/QQAppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   636: invokevirtual 168	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   639: ldc_w 2402
    //   642: invokevirtual 168	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   645: invokevirtual 176	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   648: ldc_w 441
    //   651: invokeinterface 2407 3 0
    //   656: astore 8
    //   658: aload 8
    //   660: ldc_w 2378
    //   663: invokevirtual 2382	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   666: astore 12
    //   668: aload 12
    //   670: arraylength
    //   671: istore 5
    //   673: iconst_0
    //   674: istore_3
    //   675: aload 8
    //   677: astore 7
    //   679: iload_3
    //   680: iload 5
    //   682: if_icmpge +54 -> 736
    //   685: aload 12
    //   687: iload_3
    //   688: aaload
    //   689: astore 7
    //   691: aload 7
    //   693: invokevirtual 683	java/lang/String:length	()I
    //   696: ifle +23 -> 719
    //   699: aload 7
    //   701: invokestatic 119	java/lang/Long:parseLong	(Ljava/lang/String;)J
    //   704: lconst_0
    //   705: lcmp
    //   706: ifle +13 -> 719
    //   709: aload_0
    //   710: getfield 51	com/tencent/mobileqq/app/message/C2CMessageProcessor:jdField_a_of_type_JavaUtilHashSet	Ljava/util/HashSet;
    //   713: aload 7
    //   715: invokevirtual 2408	java/util/HashSet:add	(Ljava/lang/Object;)Z
    //   718: pop
    //   719: iload_3
    //   720: iconst_1
    //   721: iadd
    //   722: istore_3
    //   723: goto -48 -> 675
    //   726: aload 7
    //   728: getfield 2413	com/tencent/mobileqq/data/Card:shGender	S
    //   731: istore 4
    //   733: goto -552 -> 181
    //   736: aload_0
    //   737: monitorexit
    //   738: aload 9
    //   740: astore 8
    //   742: aload_0
    //   743: getfield 53	com/tencent/mobileqq/app/message/C2CMessageProcessor:jdField_b_of_type_JavaUtilHashSet	Ljava/util/HashSet;
    //   746: ifnonnull +140 -> 886
    //   749: aload_0
    //   750: monitorenter
    //   751: aload 9
    //   753: astore 8
    //   755: aload_0
    //   756: getfield 53	com/tencent/mobileqq/app/message/C2CMessageProcessor:jdField_b_of_type_JavaUtilHashSet	Ljava/util/HashSet;
    //   759: ifnonnull +125 -> 884
    //   762: aload_0
    //   763: new 26	java/util/HashSet
    //   766: dup
    //   767: invokespecial 29	java/util/HashSet:<init>	()V
    //   770: putfield 53	com/tencent/mobileqq/app/message/C2CMessageProcessor:jdField_b_of_type_JavaUtilHashSet	Ljava/util/HashSet;
    //   773: aload 11
    //   775: new 107	java/lang/StringBuilder
    //   778: dup
    //   779: invokespecial 108	java/lang/StringBuilder:<init>	()V
    //   782: aload_0
    //   783: getfield 63	com/tencent/mobileqq/app/message/C2CMessageProcessor:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   786: invokevirtual 73	com/tencent/mobileqq/app/QQAppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   789: invokevirtual 168	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   792: ldc_w 2415
    //   795: invokevirtual 168	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   798: invokevirtual 176	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   801: ldc_w 441
    //   804: invokeinterface 2407 3 0
    //   809: astore 9
    //   811: aload 9
    //   813: ldc_w 2378
    //   816: invokevirtual 2382	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   819: astore 12
    //   821: aload 12
    //   823: arraylength
    //   824: istore 5
    //   826: iconst_0
    //   827: istore_3
    //   828: aload 9
    //   830: astore 8
    //   832: iload_3
    //   833: iload 5
    //   835: if_icmpge +49 -> 884
    //   838: aload 12
    //   840: iload_3
    //   841: aaload
    //   842: astore 8
    //   844: aload 8
    //   846: invokevirtual 683	java/lang/String:length	()I
    //   849: ifle +23 -> 872
    //   852: aload 8
    //   854: invokestatic 119	java/lang/Long:parseLong	(Ljava/lang/String;)J
    //   857: lconst_0
    //   858: lcmp
    //   859: ifle +13 -> 872
    //   862: aload_0
    //   863: getfield 53	com/tencent/mobileqq/app/message/C2CMessageProcessor:jdField_b_of_type_JavaUtilHashSet	Ljava/util/HashSet;
    //   866: aload 8
    //   868: invokevirtual 2408	java/util/HashSet:add	(Ljava/lang/Object;)Z
    //   871: pop
    //   872: iload_3
    //   873: iconst_1
    //   874: iadd
    //   875: istore_3
    //   876: goto -48 -> 828
    //   879: astore_1
    //   880: aload_0
    //   881: monitorexit
    //   882: aload_1
    //   883: athrow
    //   884: aload_0
    //   885: monitorexit
    //   886: aload_1
    //   887: invokevirtual 246	java/util/ArrayList:iterator	()Ljava/util/Iterator;
    //   890: astore 12
    //   892: aload 8
    //   894: astore_1
    //   895: aload 12
    //   897: invokeinterface 251 1 0
    //   902: ifeq -891 -> 11
    //   905: aload 12
    //   907: invokeinterface 255 1 0
    //   912: checkcast 257	com/tencent/mobileqq/data/MessageRecord
    //   915: astore 13
    //   917: aload_1
    //   918: astore 9
    //   920: aload_0
    //   921: aload 13
    //   923: invokevirtual 2416	com/tencent/mobileqq/app/message/C2CMessageProcessor:a	(Lcom/tencent/mobileqq/data/MessageRecord;)Z
    //   926: ifeq +641 -> 1567
    //   929: aload_1
    //   930: astore 9
    //   932: aload 10
    //   934: ifnull +633 -> 1567
    //   937: aload 13
    //   939: getfield 271	com/tencent/mobileqq/data/MessageRecord:istroop	I
    //   942: sipush 1010
    //   945: if_icmpne +340 -> 1285
    //   948: aload 7
    //   950: astore 8
    //   952: aload_0
    //   953: getfield 51	com/tencent/mobileqq/app/message/C2CMessageProcessor:jdField_a_of_type_JavaUtilHashSet	Ljava/util/HashSet;
    //   956: aload 13
    //   958: getfield 421	com/tencent/mobileqq/data/MessageRecord:frienduin	Ljava/lang/String;
    //   961: invokevirtual 2417	java/util/HashSet:contains	(Ljava/lang/Object;)Z
    //   964: ifne +89 -> 1053
    //   967: aload_0
    //   968: getfield 51	com/tencent/mobileqq/app/message/C2CMessageProcessor:jdField_a_of_type_JavaUtilHashSet	Ljava/util/HashSet;
    //   971: aload 13
    //   973: getfield 421	com/tencent/mobileqq/data/MessageRecord:frienduin	Ljava/lang/String;
    //   976: invokevirtual 2408	java/util/HashSet:add	(Ljava/lang/Object;)Z
    //   979: pop
    //   980: aload 7
    //   982: invokevirtual 683	java/lang/String:length	()I
    //   985: ifne +237 -> 1222
    //   988: aload 13
    //   990: getfield 421	com/tencent/mobileqq/data/MessageRecord:frienduin	Ljava/lang/String;
    //   993: astore 7
    //   995: aload 11
    //   997: invokeinterface 2421 1 0
    //   1002: new 107	java/lang/StringBuilder
    //   1005: dup
    //   1006: invokespecial 108	java/lang/StringBuilder:<init>	()V
    //   1009: aload_0
    //   1010: getfield 63	com/tencent/mobileqq/app/message/C2CMessageProcessor:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   1013: invokevirtual 73	com/tencent/mobileqq/app/QQAppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   1016: invokevirtual 168	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1019: ldc_w 2402
    //   1022: invokevirtual 168	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1025: invokevirtual 176	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1028: aload 7
    //   1030: invokeinterface 2426 3 0
    //   1035: pop
    //   1036: aload 11
    //   1038: invokeinterface 2421 1 0
    //   1043: invokeinterface 2429 1 0
    //   1048: pop
    //   1049: aload 7
    //   1051: astore 8
    //   1053: iload 4
    //   1055: ifne +209 -> 1264
    //   1058: iload 6
    //   1060: ifeq +196 -> 1256
    //   1063: aload_0
    //   1064: getfield 39	com/tencent/mobileqq/app/message/C2CMessageProcessor:f	I
    //   1067: istore_3
    //   1068: aload_0
    //   1069: aload_0
    //   1070: getfield 51	com/tencent/mobileqq/app/message/C2CMessageProcessor:jdField_a_of_type_JavaUtilHashSet	Ljava/util/HashSet;
    //   1073: invokevirtual 2430	java/util/HashSet:size	()I
    //   1076: putfield 2432	com/tencent/mobileqq/app/message/C2CMessageProcessor:h	I
    //   1079: aload_0
    //   1080: getfield 2432	com/tencent/mobileqq/app/message/C2CMessageProcessor:h	I
    //   1083: iload_3
    //   1084: irem
    //   1085: ifne +113 -> 1198
    //   1088: aload_0
    //   1089: getfield 63	com/tencent/mobileqq/app/message/C2CMessageProcessor:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   1092: aload 13
    //   1094: iload_2
    //   1095: invokevirtual 2433	com/tencent/mobileqq/app/QQAppInterface:a	(Lcom/tencent/mobileqq/data/MessageRecord;Z)V
    //   1098: aload_0
    //   1099: getfield 51	com/tencent/mobileqq/app/message/C2CMessageProcessor:jdField_a_of_type_JavaUtilHashSet	Ljava/util/HashSet;
    //   1102: invokevirtual 2434	java/util/HashSet:clear	()V
    //   1105: aload 11
    //   1107: invokeinterface 2421 1 0
    //   1112: new 107	java/lang/StringBuilder
    //   1115: dup
    //   1116: invokespecial 108	java/lang/StringBuilder:<init>	()V
    //   1119: aload_0
    //   1120: getfield 63	com/tencent/mobileqq/app/message/C2CMessageProcessor:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   1123: invokevirtual 73	com/tencent/mobileqq/app/QQAppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   1126: invokevirtual 168	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1129: ldc_w 2402
    //   1132: invokevirtual 168	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1135: invokevirtual 176	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1138: invokeinterface 2437 2 0
    //   1143: pop
    //   1144: aload 11
    //   1146: invokeinterface 2421 1 0
    //   1151: invokeinterface 2429 1 0
    //   1156: pop
    //   1157: iload 6
    //   1159: ifeq +39 -> 1198
    //   1162: aload_0
    //   1163: getfield 63	com/tencent/mobileqq/app/message/C2CMessageProcessor:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   1166: ldc_w 473
    //   1169: ldc_w 441
    //   1172: ldc_w 441
    //   1175: ldc_w 2439
    //   1178: ldc_w 2439
    //   1181: iconst_0
    //   1182: iconst_0
    //   1183: ldc_w 441
    //   1186: ldc_w 441
    //   1189: ldc_w 441
    //   1192: ldc_w 441
    //   1195: invokestatic 480	com/tencent/mobileqq/statistics/ReportController:b	(Lcom/tencent/mobileqq/app/QQAppInterface;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   1198: aload_1
    //   1199: astore 7
    //   1201: aload 8
    //   1203: astore_1
    //   1204: aload_1
    //   1205: astore 8
    //   1207: aload 7
    //   1209: astore_1
    //   1210: aload 8
    //   1212: astore 7
    //   1214: goto -319 -> 895
    //   1217: astore_1
    //   1218: aload_0
    //   1219: monitorexit
    //   1220: aload_1
    //   1221: athrow
    //   1222: new 107	java/lang/StringBuilder
    //   1225: dup
    //   1226: invokespecial 108	java/lang/StringBuilder:<init>	()V
    //   1229: aload 7
    //   1231: invokevirtual 168	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1234: ldc_w 2160
    //   1237: invokevirtual 168	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1240: aload 13
    //   1242: getfield 421	com/tencent/mobileqq/data/MessageRecord:frienduin	Ljava/lang/String;
    //   1245: invokevirtual 168	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1248: invokevirtual 176	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1251: astore 7
    //   1253: goto -258 -> 995
    //   1256: aload_0
    //   1257: getfield 35	com/tencent/mobileqq/app/message/C2CMessageProcessor:d	I
    //   1260: istore_3
    //   1261: goto -193 -> 1068
    //   1264: iload 6
    //   1266: ifeq +11 -> 1277
    //   1269: aload_0
    //   1270: getfield 41	com/tencent/mobileqq/app/message/C2CMessageProcessor:g	I
    //   1273: istore_3
    //   1274: goto -206 -> 1068
    //   1277: aload_0
    //   1278: getfield 37	com/tencent/mobileqq/app/message/C2CMessageProcessor:e	I
    //   1281: istore_3
    //   1282: goto -214 -> 1068
    //   1285: aload 13
    //   1287: getfield 271	com/tencent/mobileqq/data/MessageRecord:istroop	I
    //   1290: sipush 1001
    //   1293: if_icmpeq +17 -> 1310
    //   1296: aload_1
    //   1297: astore 9
    //   1299: aload 13
    //   1301: getfield 271	com/tencent/mobileqq/data/MessageRecord:istroop	I
    //   1304: sipush 10002
    //   1307: if_icmpne +260 -> 1567
    //   1310: aload_1
    //   1311: astore 8
    //   1313: aload_0
    //   1314: getfield 53	com/tencent/mobileqq/app/message/C2CMessageProcessor:jdField_b_of_type_JavaUtilHashSet	Ljava/util/HashSet;
    //   1317: aload 13
    //   1319: getfield 421	com/tencent/mobileqq/data/MessageRecord:frienduin	Ljava/lang/String;
    //   1322: invokevirtual 2417	java/util/HashSet:contains	(Ljava/lang/Object;)Z
    //   1325: ifne +85 -> 1410
    //   1328: aload_0
    //   1329: getfield 53	com/tencent/mobileqq/app/message/C2CMessageProcessor:jdField_b_of_type_JavaUtilHashSet	Ljava/util/HashSet;
    //   1332: aload 13
    //   1334: getfield 421	com/tencent/mobileqq/data/MessageRecord:frienduin	Ljava/lang/String;
    //   1337: invokevirtual 2408	java/util/HashSet:add	(Ljava/lang/Object;)Z
    //   1340: pop
    //   1341: aload_1
    //   1342: invokevirtual 683	java/lang/String:length	()I
    //   1345: ifne +232 -> 1577
    //   1348: aload 13
    //   1350: getfield 421	com/tencent/mobileqq/data/MessageRecord:frienduin	Ljava/lang/String;
    //   1353: astore_1
    //   1354: aload 11
    //   1356: invokeinterface 2421 1 0
    //   1361: new 107	java/lang/StringBuilder
    //   1364: dup
    //   1365: invokespecial 108	java/lang/StringBuilder:<init>	()V
    //   1368: aload_0
    //   1369: getfield 63	com/tencent/mobileqq/app/message/C2CMessageProcessor:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   1372: invokevirtual 73	com/tencent/mobileqq/app/QQAppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   1375: invokevirtual 168	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1378: ldc_w 2415
    //   1381: invokevirtual 168	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1384: invokevirtual 176	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1387: aload_1
    //   1388: invokeinterface 2426 3 0
    //   1393: pop
    //   1394: aload 11
    //   1396: invokeinterface 2421 1 0
    //   1401: invokeinterface 2429 1 0
    //   1406: pop
    //   1407: aload_1
    //   1408: astore 8
    //   1410: iload 4
    //   1412: ifne +205 -> 1617
    //   1415: iload 6
    //   1417: ifeq +192 -> 1609
    //   1420: aload_0
    //   1421: getfield 47	com/tencent/mobileqq/app/message/C2CMessageProcessor:k	I
    //   1424: istore_3
    //   1425: aload_0
    //   1426: aload_0
    //   1427: getfield 53	com/tencent/mobileqq/app/message/C2CMessageProcessor:jdField_b_of_type_JavaUtilHashSet	Ljava/util/HashSet;
    //   1430: invokevirtual 2430	java/util/HashSet:size	()I
    //   1433: putfield 2441	com/tencent/mobileqq/app/message/C2CMessageProcessor:m	I
    //   1436: aload 8
    //   1438: astore 9
    //   1440: aload_0
    //   1441: getfield 2441	com/tencent/mobileqq/app/message/C2CMessageProcessor:m	I
    //   1444: iload_3
    //   1445: irem
    //   1446: ifne +121 -> 1567
    //   1449: aload_0
    //   1450: getfield 63	com/tencent/mobileqq/app/message/C2CMessageProcessor:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   1453: aload 13
    //   1455: iload_2
    //   1456: invokevirtual 2433	com/tencent/mobileqq/app/QQAppInterface:a	(Lcom/tencent/mobileqq/data/MessageRecord;Z)V
    //   1459: aload_0
    //   1460: getfield 53	com/tencent/mobileqq/app/message/C2CMessageProcessor:jdField_b_of_type_JavaUtilHashSet	Ljava/util/HashSet;
    //   1463: invokevirtual 2434	java/util/HashSet:clear	()V
    //   1466: aload 11
    //   1468: invokeinterface 2421 1 0
    //   1473: new 107	java/lang/StringBuilder
    //   1476: dup
    //   1477: invokespecial 108	java/lang/StringBuilder:<init>	()V
    //   1480: aload_0
    //   1481: getfield 63	com/tencent/mobileqq/app/message/C2CMessageProcessor:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   1484: invokevirtual 73	com/tencent/mobileqq/app/QQAppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   1487: invokevirtual 168	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1490: ldc_w 2415
    //   1493: invokevirtual 168	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1496: invokevirtual 176	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1499: invokeinterface 2437 2 0
    //   1504: pop
    //   1505: aload 11
    //   1507: invokeinterface 2421 1 0
    //   1512: invokeinterface 2429 1 0
    //   1517: pop
    //   1518: aload 8
    //   1520: astore 9
    //   1522: iload 6
    //   1524: ifeq +43 -> 1567
    //   1527: aload_0
    //   1528: getfield 63	com/tencent/mobileqq/app/message/C2CMessageProcessor:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   1531: ldc_w 473
    //   1534: ldc_w 441
    //   1537: ldc_w 441
    //   1540: ldc_w 2439
    //   1543: ldc_w 2439
    //   1546: iconst_0
    //   1547: iconst_0
    //   1548: ldc_w 441
    //   1551: ldc_w 441
    //   1554: ldc_w 441
    //   1557: ldc_w 441
    //   1560: invokestatic 480	com/tencent/mobileqq/statistics/ReportController:b	(Lcom/tencent/mobileqq/app/QQAppInterface;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   1563: aload 8
    //   1565: astore 9
    //   1567: aload 7
    //   1569: astore_1
    //   1570: aload 9
    //   1572: astore 7
    //   1574: goto -370 -> 1204
    //   1577: new 107	java/lang/StringBuilder
    //   1580: dup
    //   1581: invokespecial 108	java/lang/StringBuilder:<init>	()V
    //   1584: aload_1
    //   1585: invokevirtual 168	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1588: ldc_w 2160
    //   1591: invokevirtual 168	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1594: aload 13
    //   1596: getfield 421	com/tencent/mobileqq/data/MessageRecord:frienduin	Ljava/lang/String;
    //   1599: invokevirtual 168	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1602: invokevirtual 176	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1605: astore_1
    //   1606: goto -252 -> 1354
    //   1609: aload_0
    //   1610: getfield 43	com/tencent/mobileqq/app/message/C2CMessageProcessor:i	I
    //   1613: istore_3
    //   1614: goto -189 -> 1425
    //   1617: iload 6
    //   1619: ifeq +11 -> 1630
    //   1622: aload_0
    //   1623: getfield 49	com/tencent/mobileqq/app/message/C2CMessageProcessor:l	I
    //   1626: istore_3
    //   1627: goto -202 -> 1425
    //   1630: aload_0
    //   1631: getfield 45	com/tencent/mobileqq/app/message/C2CMessageProcessor:j	I
    //   1634: istore_3
    //   1635: goto -210 -> 1425
    //   1638: iconst_1
    //   1639: istore 4
    //   1641: goto -1460 -> 181
    //   1644: iconst_0
    //   1645: istore_3
    //   1646: goto -1525 -> 121
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1649	0	this	C2CMessageProcessor
    //   0	1649	1	paramArrayList	ArrayList
    //   0	1649	2	paramBoolean	boolean
    //   120	1526	3	n	int
    //   179	1461	4	i1	int
    //   671	165	5	i2	int
    //   196	1422	6	bool	boolean
    //   48	1525	7	localObject1	Object
    //   70	1494	8	localObject2	Object
    //   583	988	9	localObject3	Object
    //   156	777	10	localQQMessageFacade	QQMessageFacade
    //   573	933	11	localSharedPreferences	android.content.SharedPreferences
    //   666	240	12	localObject4	Object
    //   915	680	13	localMessageRecord	MessageRecord
    // Exception table:
    //   from	to	target	type
    //   602	673	879	finally
    //   691	719	879	finally
    //   736	738	879	finally
    //   880	882	879	finally
    //   755	826	1217	finally
    //   844	872	1217	finally
    //   884	886	1217	finally
    //   1218	1220	1217	finally
  }
  
  public void a(List paramList, msg_comm.Msg paramMsg, boolean paramBoolean)
  {
    paramList = (msg_comm.MsgHead)paramMsg.msg_head.get();
    paramMsg = ((im_msg_body.MsgBody)paramMsg.msg_body.get()).msg_content.get().toByteArray();
    long l1 = Utils.a(paramMsg, 0);
    int n = paramMsg[4];
    String str = String.valueOf(Utils.a(paramMsg, 5));
    n = paramMsg[9];
    long l2 = Utils.a(paramMsg, 10);
    int i1 = paramMsg[14];
    try
    {
      new String(paramMsg, 15, i1, "GBK");
      if (!paramBoolean)
      {
        a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, n, str, String.valueOf(l2), l1, paramList.msg_time.get(), paramList.msg_seq.get(), paramList);
        ((TroopHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(20)).a(l1 + "", str, paramList.auth_nick.get());
        paramMsg = new ArrayList();
        paramMsg.add(new Pair(Long.valueOf(paramList.from_uin.get()), Long.valueOf(paramList.msg_time.get())));
        ((C2CMessageProcessor)this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler.a("c2c_processor")).b(paramMsg);
      }
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        new String(paramMsg, 15, i1);
      }
    }
  }
  
  public boolean a(int paramInt)
  {
    return paramInt == 33;
  }
  
  public boolean a(MessageRecord paramMessageRecord)
  {
    if ((paramMessageRecord.istroop != 1010) && (paramMessageRecord.istroop != 1001) && (paramMessageRecord.istroop != 10002)) {}
    while (((paramMessageRecord.senderuin != null) && (paramMessageRecord.senderuin.equalsIgnoreCase(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin()))) || (((paramMessageRecord.istroop == 1001) || (paramMessageRecord.istroop == 10002)) && ((paramMessageRecord.msgtype == -3001) || (!MsgProxyUtils.c(paramMessageRecord)) || (MsgProxyUtils.c(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramMessageRecord))))) {
      return false;
    }
    return true;
  }
  
  protected boolean a(String paramString)
  {
    TroopManager localTroopManager = (TroopManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(51);
    if (localTroopManager == null) {
      return false;
    }
    paramString = localTroopManager.a(paramString);
    if (paramString == null) {
      return false;
    }
    return paramString.isAdmin();
  }
  
  public boolean a(ArrayList paramArrayList)
  {
    if (paramArrayList == null) {
      return false;
    }
    paramArrayList = paramArrayList.iterator();
    MessageRecord localMessageRecord;
    do
    {
      if (!paramArrayList.hasNext()) {
        break;
      }
      localMessageRecord = (MessageRecord)paramArrayList.next();
    } while ((localMessageRecord.isSend()) || (localMessageRecord.isread) || ((MsgProxyUtils.c(localMessageRecord)) && (!MsgProxyUtils.c(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localMessageRecord))));
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
  
  public void b(int paramInt, ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg)
  {
    switch (paramInt)
    {
    default: 
      return;
    case 2001: 
      a(paramToServiceMsg, paramFromServiceMsg);
      return;
    }
    a(paramToServiceMsg, paramFromServiceMsg, true);
  }
  
  public void b(ArrayList paramArrayList)
  {
    if ((paramArrayList == null) || (paramArrayList.size() <= 0)) {
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder("-ReportList-");
    msg_svc.PbMsgReadedReportReq localPbMsgReadedReportReq = new msg_svc.PbMsgReadedReportReq();
    msg_svc.PbC2CReadedReportReq localPbC2CReadedReportReq = new msg_svc.PbC2CReadedReportReq();
    paramArrayList = paramArrayList.iterator();
    while (paramArrayList.hasNext())
    {
      Pair localPair = (Pair)paramArrayList.next();
      msg_svc.PbC2CReadedReportReq.UinPairReadInfo localUinPairReadInfo = new msg_svc.PbC2CReadedReportReq.UinPairReadInfo();
      localUinPairReadInfo.peer_uin.set(((Long)localPair.first).longValue());
      localUinPairReadInfo.last_read_time.set(((Long)localPair.second).intValue());
      localStringBuilder.append("-uin:").append(localPair.first).append("-ReadTime-").append(localPair.second);
      localPbC2CReadedReportReq.pair_info.add(localUinPairReadInfo);
    }
    paramArrayList = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a().a();
    if (paramArrayList != null) {
      localPbC2CReadedReportReq.sync_cookie.set(ByteStringMicro.copyFrom(paramArrayList));
    }
    localPbMsgReadedReportReq.c2c_read_report.set(localPbC2CReadedReportReq);
    if (QLog.isColorLevel()) {
      QLog.d("Q.msg.C2CMessageProcessor", 2, "<ReadReport><S>_C2C:" + localStringBuilder.toString());
    }
    a(localPbMsgReadedReportReq);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.app.message.C2CMessageProcessor
 * JD-Core Version:    0.7.0.1
 */