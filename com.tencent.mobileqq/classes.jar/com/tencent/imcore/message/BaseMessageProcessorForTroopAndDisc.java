package com.tencent.imcore.message;

import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.BaseMessageHandler;
import com.tencent.mobileqq.app.StatictisInfo;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.troop.TroopMemberInfo;
import com.tencent.mobileqq.msg.api.IConversationFacade;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.service.message.MessageCache;
import com.tencent.mobileqq.service.message.PBDecodeContext;
import com.tencent.mobileqq.service.message.QMessageProtoCodec;
import com.tencent.mobileqq.service.message.api.IBaseMessageProcessorForTroopAndDiscService;
import com.tencent.mobileqq.service.message.api.IMessageRecordFactoryService;
import com.tencent.mobileqq.troop.data.MessageInfo;
import com.tencent.mobileqq.troop.data.MessageNavInfo;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import localpb.richMsg.SafeMsg.SafeMoreInfo;
import msf.msgcomm.msg_comm.Msg;
import msf.msgcomm.msg_comm.MsgHead;
import tencent.im.msg.hummer.resv.generalflags.ResvAttr;
import tencent.im.msg.im_msg_body.AnonymousGroupMsg;
import tencent.im.msg.im_msg_body.Elem;
import tencent.im.msg.im_msg_body.ExtraInfo;
import tencent.im.msg.im_msg_body.GeneralFlags;

public class BaseMessageProcessorForTroopAndDisc
  extends BaseMessageProcessor
{
  protected Comparator t = new BaseMessageProcessorForTroopAndDisc.1(this);
  
  static {}
  
  public BaseMessageProcessorForTroopAndDisc(AppInterface paramAppInterface, BaseMessageHandler paramBaseMessageHandler)
  {
    super(paramAppInterface, paramBaseMessageHandler);
  }
  
  private byte a(msg_comm.MsgHead paramMsgHead, long paramLong, MessageInfo paramMessageInfo, byte paramByte, MessageRecord paramMessageRecord)
  {
    byte b = paramByte;
    if (paramMsgHead.msg_flag.has())
    {
      b = paramByte;
      if ((paramMsgHead.msg_flag.get() & 1L) == 1L)
      {
        b = paramByte;
        if (paramMessageRecord.msgtype != -2058)
        {
          paramByte = 1;
          paramMessageInfo.c.a(17, paramLong, paramMessageRecord.uniseq);
          b = paramByte;
          if (QLog.isColorLevel())
          {
            QLog.d("Q.msg.BaseMessageProcessorForTroopAndDisc", 2, "receive the TroopMsg from TroopSpecialAttention!");
            b = paramByte;
          }
        }
      }
    }
    return b;
  }
  
  public static long a(int paramInt1, int paramInt2)
  {
    long l = paramInt2;
    return paramInt1 | l << 32;
  }
  
  private BaseMessageProcessorForTroopAndDisc.QTroopHotChatTopicHandler a(ArrayList<MessageRecord> paramArrayList, PBDecodeContext paramPBDecodeContext, boolean paramBoolean, MessageInfo paramMessageInfo1, msg_comm.MsgHead paramMsgHead, long paramLong1, long paramLong2, long paramLong3, long paramLong4, long paramLong5, String paramString1, int paramInt1, int paramInt2, int paramInt3, List<MessageRecord> paramList, List<im_msg_body.Elem> paramList1, MessageInfo paramMessageInfo2, byte paramByte, String paramString2)
  {
    Object localObject = paramArrayList;
    Iterator localIterator = paramList.iterator();
    String str = paramString2;
    paramString2 = (String)localObject;
    for (;;)
    {
      localObject = paramPBDecodeContext;
      long l2 = paramLong2;
      long l1 = paramLong3;
      if (!localIterator.hasNext()) {
        break;
      }
      MessageRecord localMessageRecord = (MessageRecord)localIterator.next();
      localMessageRecord.time = l1;
      localMessageRecord.msgseq = l1;
      localMessageRecord.shmsgseq = l2;
      localMessageRecord.msgUid = paramLong4;
      localMessageRecord.selfuin = paramString1;
      localMessageRecord.istroop = ((PBDecodeContext)localObject).w;
      localMessageRecord.senderuin = String.valueOf(paramLong1);
      localMessageRecord.frienduin = String.valueOf(((PBDecodeContext)localObject).x);
      localMessageRecord.longMsgId = paramInt1;
      localMessageRecord.longMsgCount = paramInt2;
      localMessageRecord.longMsgIndex = paramInt3;
      if (((PBDecodeContext)localObject).y == 127)
      {
        localMessageRecord.msg = "PTT_URL";
        localMessageRecord.msgtype = -2006;
        localMessageRecord.isread = true;
      }
      b(localMessageRecord);
      paramByte = a(paramMsgHead, paramLong2, paramMessageInfo2, paramByte, localMessageRecord);
      a(paramPBDecodeContext, paramLong2, paramList1, paramMessageInfo2, localMessageRecord);
      a(l2, paramMessageInfo2, localMessageRecord);
      a(paramString2, (PBDecodeContext)localObject, paramList1, localMessageRecord);
      str = c().decodeTroopMsg(localMessageRecord, paramArrayList, paramPBDecodeContext, paramBoolean, paramMessageInfo1, paramMsgHead, paramLong1, paramLong2, paramLong3, paramLong4, paramLong5, paramString1, paramInt1, paramInt2, paramInt3, paramList, paramList1, paramMessageInfo2, paramByte, str);
      a(paramPBDecodeContext, paramMessageInfo1, paramLong2, paramMessageInfo2, localMessageRecord);
      paramString2.add(localMessageRecord);
    }
    return c().getQTroopHotChatTopicHandler(paramArrayList, paramPBDecodeContext, paramBoolean, paramMsgHead, paramLong1, paramLong2, paramLong3, paramLong5, paramList1, paramByte, str).j();
  }
  
  private TroopMemberInfo a(msg_comm.Msg paramMsg, ArrayList<MessageRecord> paramArrayList, int paramInt, BaseMessageProcessorForTroopAndDisc.QTroopHotChatTopicHandler paramQTroopHotChatTopicHandler)
  {
    int k = paramQTroopHotChatTopicHandler.a();
    int m = paramQTroopHotChatTopicHandler.b();
    int n = paramQTroopHotChatTopicHandler.c();
    int i1 = paramQTroopHotChatTopicHandler.d();
    int i2 = paramQTroopHotChatTopicHandler.e();
    int i3 = paramQTroopHotChatTopicHandler.f();
    int i = paramQTroopHotChatTopicHandler.g();
    int j = paramQTroopHotChatTopicHandler.h();
    paramQTroopHotChatTopicHandler = paramQTroopHotChatTopicHandler.i();
    int i4 = QMessageProtoCodec.b(paramMsg);
    int i5 = QMessageProtoCodec.c(paramMsg);
    int i6 = QMessageProtoCodec.d(paramMsg);
    int i7 = QMessageProtoCodec.e(paramMsg);
    int i8 = QMessageProtoCodec.f(paramMsg);
    paramArrayList = paramArrayList.iterator();
    paramMsg = paramQTroopHotChatTopicHandler;
    while (paramArrayList.hasNext())
    {
      paramQTroopHotChatTopicHandler = (MessageRecord)paramArrayList.next();
      paramQTroopHotChatTopicHandler.vipBubbleDiyTextId = i4;
      paramQTroopHotChatTopicHandler.vipBubbleID = a(paramInt, i4);
      paramQTroopHotChatTopicHandler.vipSubBubbleId = i5;
      ((MessageCache)this.q.getMsgCache()).f(paramQTroopHotChatTopicHandler.time);
      if (i5 != 0) {
        paramQTroopHotChatTopicHandler.saveExtInfoToExtStr("bubble_sub_id", String.valueOf(i5));
      }
      if (i6 > 0) {
        paramQTroopHotChatTopicHandler.saveExtInfoToExtStr("vip_pendant_diy_id", String.valueOf(i6));
      }
      if (i8 >= 0) {
        paramQTroopHotChatTopicHandler.saveExtInfoToExtStr("vip_face_id", String.valueOf(i8));
      }
      if (i7 >= 0) {
        paramQTroopHotChatTopicHandler.saveExtInfoToExtStr("vip_font_effect_id", String.valueOf(i7));
      }
      if (k > 0) {
        paramQTroopHotChatTopicHandler.saveExtInfoToExtStr("vip_type", String.valueOf(k));
      }
      if (m > 0) {
        paramQTroopHotChatTopicHandler.saveExtInfoToExtStr("vip_level", String.valueOf(m));
      }
      if (n > 0) {
        paramQTroopHotChatTopicHandler.saveExtInfoToExtStr("bigClub_type", String.valueOf(n));
      }
      if (i1 > 0) {
        paramQTroopHotChatTopicHandler.saveExtInfoToExtStr("bigClub_level", String.valueOf(i1));
      }
      if (i2 > 0) {
        paramQTroopHotChatTopicHandler.saveExtInfoToExtStr("vip_card_id", String.valueOf(i2));
      }
      if (i3 > 0) {
        paramQTroopHotChatTopicHandler.saveExtInfoToExtStr("vip_ext_card_id", String.valueOf(i3));
      }
      if (i > 0) {
        paramQTroopHotChatTopicHandler.saveExtInfoToExtStr("game_card_id", String.valueOf(i));
      }
      if (j > 0) {
        paramQTroopHotChatTopicHandler.saveExtInfoToExtStr("vip_diy_font_id", String.valueOf(j));
      }
    }
    return paramMsg;
  }
  
  private void a(int paramInt, List<MessageRecord> paramList)
  {
    if ((paramList.size() == 0) && (paramInt > 1))
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.msg.BaseMessageProcessorForTroopAndDisc", 2, "<---decodeSinglePbMsg_GroupDis, empty long msg fragment");
      }
      MessageRecord localMessageRecord = ((IMessageRecordFactoryService)QRoute.api(IMessageRecordFactoryService.class)).createMsgRecordByMsgType(-1000);
      localMessageRecord.msgtype = -1000;
      localMessageRecord.msg = "";
      paramList.add(localMessageRecord);
    }
  }
  
  private void a(long paramLong, MessageInfo paramMessageInfo, MessageRecord paramMessageRecord)
  {
    if (paramMessageRecord.msgtype == -5015) {
      paramMessageInfo.c.a(6, paramLong, paramMessageRecord.uniseq);
    }
  }
  
  private void a(PBDecodeContext paramPBDecodeContext, long paramLong, List<im_msg_body.Elem> paramList, MessageInfo paramMessageInfo, MessageRecord paramMessageRecord)
  {
    if (((paramPBDecodeContext.w == 1) || (paramPBDecodeContext.w == 1026)) && (paramList != null))
    {
      paramPBDecodeContext = paramList.iterator();
      while (paramPBDecodeContext.hasNext())
      {
        paramList = (im_msg_body.Elem)paramPBDecodeContext.next();
        if ((paramList.general_flags.has()) && (paramList.general_flags.bytes_pb_reserve.has()))
        {
          generalflags.ResvAttr localResvAttr = new generalflags.ResvAttr();
          localResvAttr.mergeFrom(paramList.general_flags.bytes_pb_reserve.get().toByteArray());
          if ((localResvAttr.uint32_group_savedb_flag.has()) && ((localResvAttr.uint32_group_savedb_flag.get() & 0x1) == 1))
          {
            paramMessageInfo.c.a(23, paramLong, paramMessageRecord.uniseq);
            if (QLog.isColorLevel()) {
              QLog.d("Q.msg.BaseMessageProcessorForTroopAndDisc", 2, "decodeSinglePbMsg_GroupDis, should show shop ark");
            }
          }
        }
      }
    }
  }
  
  private void a(PBDecodeContext paramPBDecodeContext, MessageInfo paramMessageInfo1, long paramLong, MessageInfo paramMessageInfo2, MessageRecord paramMessageRecord)
  {
    if (paramMessageInfo1 != null)
    {
      paramMessageInfo2.c.b(13, paramMessageRecord.uniseq);
      paramMessageInfo2.c.b(24, paramMessageRecord.uniseq);
      if ((paramLong > ((IConversationFacade)this.q.getRuntimeService(IConversationFacade.class, "")).getLastRead(String.valueOf(paramPBDecodeContext.x), paramPBDecodeContext.w)) && (paramMessageInfo2.e()))
      {
        paramMessageInfo1.a(paramMessageInfo2);
        paramMessageRecord.mMessageInfo = paramMessageInfo2;
      }
    }
  }
  
  private void a(ArrayList<MessageRecord> paramArrayList, PBDecodeContext paramPBDecodeContext, List<im_msg_body.Elem> paramList, MessageRecord paramMessageRecord)
  {
    if (((paramPBDecodeContext.w == 1) || (paramPBDecodeContext.w == 1026) || (paramPBDecodeContext.w == 3000)) && (paramList != null) && (!TextUtils.equals(paramMessageRecord.selfuin, paramMessageRecord.senderuin)))
    {
      boolean bool = false;
      paramPBDecodeContext = paramList.iterator();
      while (paramPBDecodeContext.hasNext()) {
        if (((im_msg_body.Elem)paramPBDecodeContext.next()).anon_group_msg.has()) {
          bool = true;
        }
      }
      a(paramArrayList, paramList, paramMessageRecord, bool);
    }
  }
  
  private void a(ArrayList<MessageRecord> paramArrayList, List<im_msg_body.Elem> paramList, MessageRecord paramMessageRecord, boolean paramBoolean)
  {
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      Object localObject = (im_msg_body.Elem)paramList.next();
      if ((!paramBoolean) && (((im_msg_body.Elem)localObject).extra_info.has()))
      {
        localObject = (im_msg_body.ExtraInfo)((im_msg_body.Elem)localObject).extra_info.get();
        if (((im_msg_body.ExtraInfo)localObject).uint32_msg_tail_id.has())
        {
          int i = ((im_msg_body.ExtraInfo)localObject).uint32_msg_tail_id.get();
          if (i > 0)
          {
            localObject = ((IMessageRecordFactoryService)QRoute.api(IMessageRecordFactoryService.class)).createMsgRecordByMsgType(-1002);
            if (localObject != null)
            {
              String str = Integer.toString(i);
              SafeMsg.SafeMoreInfo localSafeMoreInfo = new SafeMsg.SafeMoreInfo();
              localSafeMoreInfo.strMsgTxt.set(str);
              ((MessageRecord)localObject).init(paramMessageRecord.selfuin, paramMessageRecord.frienduin, paramMessageRecord.senderuin, str, paramMessageRecord.time, -1002, paramMessageRecord.istroop, paramMessageRecord.msgseq);
              ((MessageRecord)localObject).isread = true;
              ((MessageRecord)localObject).shmsgseq = paramMessageRecord.shmsgseq;
              ((MessageRecord)localObject).msgData = localSafeMoreInfo.toByteArray();
              paramArrayList.add(localObject);
            }
          }
        }
      }
    }
  }
  
  private void b(MessageRecord paramMessageRecord)
  {
    if (paramMessageRecord.msgtype == -1035) {
      ((ChatMessage)paramMessageRecord).parse();
    }
  }
  
  private IBaseMessageProcessorForTroopAndDiscService c()
  {
    return (IBaseMessageProcessorForTroopAndDiscService)this.q.getRuntimeService(IBaseMessageProcessorForTroopAndDiscService.class, "");
  }
  
  /* Error */
  protected TroopMemberInfo a(msg_comm.Msg paramMsg, ArrayList<MessageRecord> paramArrayList, PBDecodeContext paramPBDecodeContext, boolean paramBoolean, MessageInfo paramMessageInfo)
  {
    // Byte code:
    //   0: invokestatic 449	java/lang/System:currentTimeMillis	()J
    //   3: lstore 15
    //   5: aload_3
    //   6: ifnull +537 -> 543
    //   9: aload_1
    //   10: ifnull +533 -> 543
    //   13: aload_2
    //   14: ifnonnull +6 -> 20
    //   17: goto +526 -> 543
    //   20: aload_1
    //   21: getfield 455	msf/msgcomm/msg_comm$Msg:msg_head	Lmsf/msgcomm/msg_comm$MsgHead;
    //   24: invokevirtual 456	msf/msgcomm/msg_comm$MsgHead:get	()Lcom/tencent/mobileqq/pb/MessageMicro;
    //   27: checkcast 28	msf/msgcomm/msg_comm$MsgHead
    //   30: astore 30
    //   32: aload 30
    //   34: getfield 460	msf/msgcomm/msg_comm$MsgHead:from_uin	Lcom/tencent/mobileqq/pb/PBUInt64Field;
    //   37: invokevirtual 464	com/tencent/mobileqq/pb/PBUInt64Field:get	()J
    //   40: lstore 17
    //   42: aload 30
    //   44: getfield 467	msf/msgcomm/msg_comm$MsgHead:to_uin	Lcom/tencent/mobileqq/pb/PBUInt64Field;
    //   47: invokevirtual 464	com/tencent/mobileqq/pb/PBUInt64Field:get	()J
    //   50: pop2
    //   51: aload 30
    //   53: getfield 470	msf/msgcomm/msg_comm$MsgHead:msg_seq	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   56: invokevirtual 42	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   59: i2l
    //   60: lstore 11
    //   62: aload 30
    //   64: getfield 473	msf/msgcomm/msg_comm$MsgHead:msg_time	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   67: invokevirtual 42	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   70: i2l
    //   71: lstore 13
    //   73: lconst_0
    //   74: lstore 9
    //   76: aload_0
    //   77: getfield 252	com/tencent/imcore/message/BaseMessageProcessorForTroopAndDisc:q	Lcom/tencent/common/app/AppInterface;
    //   80: invokevirtual 476	com/tencent/common/app/AppInterface:getLongAccountUin	()J
    //   83: lstore 19
    //   85: aload_0
    //   86: getfield 252	com/tencent/imcore/message/BaseMessageProcessorForTroopAndDisc:q	Lcom/tencent/common/app/AppInterface;
    //   89: invokevirtual 480	com/tencent/common/app/AppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   92: astore 31
    //   94: aload_3
    //   95: getfield 114	com/tencent/mobileqq/service/message/PBDecodeContext:w	I
    //   98: sipush 1026
    //   101: if_icmpne +29 -> 130
    //   104: aload 30
    //   106: getfield 470	msf/msgcomm/msg_comm$MsgHead:msg_seq	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   109: invokevirtual 42	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   112: invokestatic 485	com/tencent/mobileqq/util/Utils:a	(I)J
    //   115: lstore 11
    //   117: aload 30
    //   119: getfield 473	msf/msgcomm/msg_comm$MsgHead:msg_time	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   122: invokevirtual 42	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   125: invokestatic 485	com/tencent/mobileqq/util/Utils:a	(I)J
    //   128: lstore 13
    //   130: aload_1
    //   131: getfield 489	msf/msgcomm/msg_comm$Msg:content_head	Lmsf/msgcomm/msg_comm$ContentHead;
    //   134: invokevirtual 492	msf/msgcomm/msg_comm$ContentHead:has	()Z
    //   137: ifeq +433 -> 570
    //   140: aload_1
    //   141: getfield 489	msf/msgcomm/msg_comm$Msg:content_head	Lmsf/msgcomm/msg_comm$ContentHead;
    //   144: invokevirtual 493	msf/msgcomm/msg_comm$ContentHead:get	()Lcom/tencent/mobileqq/pb/MessageMicro;
    //   147: checkcast 491	msf/msgcomm/msg_comm$ContentHead
    //   150: astore 25
    //   152: aload 25
    //   154: getfield 496	msf/msgcomm/msg_comm$ContentHead:div_seq	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   157: invokevirtual 42	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   160: istore 7
    //   162: aload 25
    //   164: getfield 499	msf/msgcomm/msg_comm$ContentHead:pkg_num	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   167: invokevirtual 42	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   170: istore 6
    //   172: aload 25
    //   174: getfield 502	msf/msgcomm/msg_comm$ContentHead:pkg_index	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   177: invokevirtual 42	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   180: istore 8
    //   182: goto +3 -> 185
    //   185: aload_0
    //   186: getfield 506	com/tencent/imcore/message/BaseMessageProcessorForTroopAndDisc:r	Lcom/tencent/mobileqq/app/BaseMessageHandler;
    //   189: aload_1
    //   190: lload 17
    //   192: invokestatic 123	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   195: lload 17
    //   197: invokestatic 123	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   200: invokestatic 509	com/tencent/mobileqq/service/message/QMessageProtoCodec:a	(Lcom/tencent/mobileqq/app/BaseMessageHandler;Lmsf/msgcomm/msg_comm$Msg;Ljava/lang/String;Ljava/lang/String;)J
    //   203: lstore 21
    //   205: new 182	java/util/ArrayList
    //   208: dup
    //   209: invokespecial 510	java/util/ArrayList:<init>	()V
    //   212: astore 26
    //   214: new 50	com/tencent/mobileqq/troop/data/MessageInfo
    //   217: dup
    //   218: invokespecial 511	com/tencent/mobileqq/troop/data/MessageInfo:<init>	()V
    //   221: astore 25
    //   223: aload_1
    //   224: getfield 515	msf/msgcomm/msg_comm$Msg:appshare_info	Lmsf/msgcomm/msg_comm$AppShareInfo;
    //   227: invokevirtual 518	msf/msgcomm/msg_comm$AppShareInfo:has	()Z
    //   230: ifeq +29 -> 259
    //   233: aload_0
    //   234: invokespecial 171	com/tencent/imcore/message/BaseMessageProcessorForTroopAndDisc:c	()Lcom/tencent/mobileqq/service/message/api/IBaseMessageProcessorForTroopAndDiscService;
    //   237: aload_0
    //   238: getfield 506	com/tencent/imcore/message/BaseMessageProcessorForTroopAndDisc:r	Lcom/tencent/mobileqq/app/BaseMessageHandler;
    //   241: aload 26
    //   243: aload_1
    //   244: aload_3
    //   245: getfield 129	com/tencent/mobileqq/service/message/PBDecodeContext:x	J
    //   248: lload 13
    //   250: iconst_0
    //   251: invokeinterface 522 9 0
    //   256: goto +333 -> 589
    //   259: aload 25
    //   261: astore 27
    //   263: aload 26
    //   265: astore 28
    //   267: aload_1
    //   268: getfield 526	msf/msgcomm/msg_comm$Msg:msg_body	Ltencent/im/msg/im_msg_body$MsgBody;
    //   271: invokevirtual 529	tencent/im/msg/im_msg_body$MsgBody:has	()Z
    //   274: ifeq +315 -> 589
    //   277: aload_1
    //   278: getfield 526	msf/msgcomm/msg_comm$Msg:msg_body	Ltencent/im/msg/im_msg_body$MsgBody;
    //   281: invokevirtual 530	tencent/im/msg/im_msg_body$MsgBody:get	()Lcom/tencent/mobileqq/pb/MessageMicro;
    //   284: checkcast 528	tencent/im/msg/im_msg_body$MsgBody
    //   287: astore 29
    //   289: aload 29
    //   291: getfield 534	tencent/im/msg/im_msg_body$MsgBody:rich_text	Ltencent/im/msg/im_msg_body$RichText;
    //   294: invokevirtual 537	tencent/im/msg/im_msg_body$RichText:has	()Z
    //   297: ifeq +292 -> 589
    //   300: aload 29
    //   302: getfield 534	tencent/im/msg/im_msg_body$MsgBody:rich_text	Ltencent/im/msg/im_msg_body$RichText;
    //   305: invokevirtual 538	tencent/im/msg/im_msg_body$RichText:get	()Lcom/tencent/mobileqq/pb/MessageMicro;
    //   308: checkcast 536	tencent/im/msg/im_msg_body$RichText
    //   311: astore 32
    //   313: aload 32
    //   315: getfield 542	tencent/im/msg/im_msg_body$RichText:attr	Ltencent/im/msg/im_msg_body$Attr;
    //   318: invokevirtual 545	tencent/im/msg/im_msg_body$Attr:has	()Z
    //   321: ifeq +25 -> 346
    //   324: aload 32
    //   326: getfield 542	tencent/im/msg/im_msg_body$RichText:attr	Ltencent/im/msg/im_msg_body$Attr;
    //   329: invokevirtual 546	tencent/im/msg/im_msg_body$Attr:get	()Lcom/tencent/mobileqq/pb/MessageMicro;
    //   332: checkcast 544	tencent/im/msg/im_msg_body$Attr
    //   335: getfield 549	tencent/im/msg/im_msg_body$Attr:random	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   338: invokevirtual 42	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   341: invokestatic 552	com/tencent/mobileqq/service/message/MessageUtils:a	(I)J
    //   344: lstore 9
    //   346: aload 32
    //   348: getfield 556	tencent/im/msg/im_msg_body$RichText:elems	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   351: invokevirtual 561	com/tencent/mobileqq/pb/PBRepeatMessageField:get	()Ljava/util/List;
    //   354: astore 29
    //   356: aload 32
    //   358: getfield 565	tencent/im/msg/im_msg_body$RichText:ptt	Ltencent/im/msg/im_msg_body$Ptt;
    //   361: invokevirtual 568	tencent/im/msg/im_msg_body$Ptt:has	()Z
    //   364: ifeq +31 -> 395
    //   367: aload_0
    //   368: invokevirtual 571	com/tencent/imcore/message/BaseMessageProcessorForTroopAndDisc:b	()Lcom/tencent/imcore/message/IGrpDisPTTDecoder;
    //   371: astore 27
    //   373: aload_0
    //   374: getfield 506	com/tencent/imcore/message/BaseMessageProcessorForTroopAndDisc:r	Lcom/tencent/mobileqq/app/BaseMessageHandler;
    //   377: astore 32
    //   379: aload 27
    //   381: aload 32
    //   383: aload_1
    //   384: aload 28
    //   386: aconst_null
    //   387: invokeinterface 576 5 0
    //   392: goto +190 -> 582
    //   395: aload_3
    //   396: getfield 129	com/tencent/mobileqq/service/message/PBDecodeContext:x	J
    //   399: lstore 23
    //   401: aload 27
    //   403: lload 23
    //   405: invokestatic 123	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   408: putfield 578	com/tencent/mobileqq/troop/data/MessageInfo:a	Ljava/lang/String;
    //   411: aload 27
    //   413: aload_3
    //   414: getfield 114	com/tencent/mobileqq/service/message/PBDecodeContext:w	I
    //   417: putfield 580	com/tencent/mobileqq/troop/data/MessageInfo:b	I
    //   420: aload_0
    //   421: getfield 506	com/tencent/imcore/message/BaseMessageProcessorForTroopAndDisc:r	Lcom/tencent/mobileqq/app/BaseMessageHandler;
    //   424: invokevirtual 585	com/tencent/mobileqq/app/BaseMessageHandler:b	()Lcom/tencent/common/app/AppInterface;
    //   427: aload 28
    //   429: aload_1
    //   430: iconst_0
    //   431: iconst_0
    //   432: aload 27
    //   434: invokestatic 588	com/tencent/mobileqq/service/message/QMessageProtoCodec:a	(Lmqq/app/AppRuntime;Ljava/util/List;Lmsf/msgcomm/msg_comm$Msg;ZZLcom/tencent/mobileqq/troop/data/MessageInfo;)V
    //   437: goto +145 -> 582
    //   440: aload 26
    //   442: astore 28
    //   444: aload_0
    //   445: iload 6
    //   447: aload 28
    //   449: invokespecial 590	com/tencent/imcore/message/BaseMessageProcessorForTroopAndDisc:a	(ILjava/util/List;)V
    //   452: aconst_null
    //   453: astore 26
    //   455: aload_0
    //   456: aload_2
    //   457: aload_3
    //   458: iload 4
    //   460: aload 5
    //   462: aload 30
    //   464: lload 17
    //   466: lload 11
    //   468: lload 13
    //   470: lload 9
    //   472: lload 19
    //   474: aload 31
    //   476: iload 7
    //   478: iload 6
    //   480: iload 8
    //   482: aload 28
    //   484: aload 27
    //   486: aload 25
    //   488: iconst_0
    //   489: aconst_null
    //   490: invokespecial 592	com/tencent/imcore/message/BaseMessageProcessorForTroopAndDisc:a	(Ljava/util/ArrayList;Lcom/tencent/mobileqq/service/message/PBDecodeContext;ZLcom/tencent/mobileqq/troop/data/MessageInfo;Lmsf/msgcomm/msg_comm$MsgHead;JJJJJLjava/lang/String;IIILjava/util/List;Ljava/util/List;Lcom/tencent/mobileqq/troop/data/MessageInfo;BLjava/lang/String;)Lcom/tencent/imcore/message/BaseMessageProcessorForTroopAndDisc$QTroopHotChatTopicHandler;
    //   493: astore_3
    //   494: lload 21
    //   496: l2i
    //   497: istore 6
    //   499: aload_0
    //   500: aload_1
    //   501: aload_2
    //   502: iload 6
    //   504: aload_3
    //   505: invokespecial 594	com/tencent/imcore/message/BaseMessageProcessorForTroopAndDisc:a	(Lmsf/msgcomm/msg_comm$Msg;Ljava/util/ArrayList;ILcom/tencent/imcore/message/BaseMessageProcessorForTroopAndDisc$QTroopHotChatTopicHandler;)Lcom/tencent/mobileqq/data/troop/TroopMemberInfo;
    //   508: astore_1
    //   509: invokestatic 600	com/tencent/util/MsgAutoMonitorUtil:getInstance	()Lcom/tencent/util/MsgAutoMonitorUtil;
    //   512: invokestatic 449	java/lang/System:currentTimeMillis	()J
    //   515: lload 15
    //   517: lsub
    //   518: invokevirtual 603	com/tencent/util/MsgAutoMonitorUtil:addDecodeGrpDisMsgTime	(J)V
    //   521: aload_1
    //   522: areturn
    //   523: astore_1
    //   524: aload 26
    //   526: astore_2
    //   527: goto +21 -> 548
    //   530: astore_1
    //   531: aload 26
    //   533: astore_2
    //   534: goto +14 -> 548
    //   537: astore_1
    //   538: aconst_null
    //   539: astore_2
    //   540: goto +8 -> 548
    //   543: aconst_null
    //   544: areturn
    //   545: astore_1
    //   546: aconst_null
    //   547: astore_2
    //   548: aload_1
    //   549: invokevirtual 606	java/lang/Throwable:printStackTrace	()V
    //   552: invokestatic 68	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   555: ifeq +13 -> 568
    //   558: ldc 70
    //   560: iconst_2
    //   561: ldc_w 608
    //   564: aload_1
    //   565: invokestatic 611	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   568: aload_2
    //   569: areturn
    //   570: iconst_0
    //   571: istore 6
    //   573: iconst_0
    //   574: istore 7
    //   576: iconst_0
    //   577: istore 8
    //   579: goto -394 -> 185
    //   582: aload 29
    //   584: astore 27
    //   586: goto -146 -> 440
    //   589: aconst_null
    //   590: astore 27
    //   592: goto -152 -> 440
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	595	0	this	BaseMessageProcessorForTroopAndDisc
    //   0	595	1	paramMsg	msg_comm.Msg
    //   0	595	2	paramArrayList	ArrayList<MessageRecord>
    //   0	595	3	paramPBDecodeContext	PBDecodeContext
    //   0	595	4	paramBoolean	boolean
    //   0	595	5	paramMessageInfo	MessageInfo
    //   170	402	6	i	int
    //   160	415	7	j	int
    //   180	398	8	k	int
    //   74	397	9	l1	long
    //   60	407	11	l2	long
    //   71	398	13	l3	long
    //   3	513	15	l4	long
    //   40	425	17	l5	long
    //   83	390	19	l6	long
    //   203	292	21	l7	long
    //   399	5	23	l8	long
    //   150	337	25	localObject1	Object
    //   212	320	26	localArrayList1	ArrayList
    //   261	330	27	localObject2	Object
    //   265	218	28	localArrayList2	ArrayList
    //   287	296	29	localObject3	Object
    //   30	433	30	localMsgHead	msg_comm.MsgHead
    //   92	383	31	str	String
    //   311	71	32	localObject4	Object
    // Exception table:
    //   from	to	target	type
    //   499	521	523	java/lang/Throwable
    //   455	494	530	java/lang/Throwable
    //   379	392	537	java/lang/Throwable
    //   395	401	537	java/lang/Throwable
    //   401	437	537	java/lang/Throwable
    //   444	452	537	java/lang/Throwable
    //   0	5	545	java/lang/Throwable
    //   20	73	545	java/lang/Throwable
    //   76	94	545	java/lang/Throwable
    //   94	130	545	java/lang/Throwable
    //   130	182	545	java/lang/Throwable
    //   185	256	545	java/lang/Throwable
    //   267	313	545	java/lang/Throwable
    //   313	346	545	java/lang/Throwable
    //   346	379	545	java/lang/Throwable
  }
  
  protected String a(msg_comm.Msg paramMsg)
  {
    long l = ((msg_comm.MsgHead)paramMsg.msg_head.get()).msg_seq.get();
    paramMsg = new StringBuilder(64);
    paramMsg.append("key_seq_");
    paramMsg.append(l);
    return paramMsg.toString();
  }
  
  public List<MessageRecord> a(msg_comm.Msg paramMsg, PBDecodeContext paramPBDecodeContext)
  {
    return null;
  }
  
  public void a(int paramInt, Object... paramVarArgs) {}
  
  public void a(MessageRecord paramMessageRecord)
  {
    if (((MessageCache)this.q.getMsgCache()).f(paramMessageRecord))
    {
      Object localObject;
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("handle push . notifySendMessageSuccessful");
        ((StringBuilder)localObject).append(paramMessageRecord.toString());
        QLog.d("Q.msg.BaseMessageProcessorForTroopAndDisc", 2, ((StringBuilder)localObject).toString());
      }
      ((MessageCache)this.q.getMsgCache()).b(paramMessageRecord.frienduin, paramMessageRecord.istroop, paramMessageRecord.uniseq);
      a(6003, true, new Object[] { paramMessageRecord.frienduin, String.valueOf(paramMessageRecord.uniseq) });
      this.r.c(paramMessageRecord.msgseq);
      if (MsgProxyUtils.i(paramMessageRecord.msgtype))
      {
        localObject = new StatictisInfo();
        ((StatictisInfo)localObject).b = 1000;
        ((StatictisInfo)localObject).c = 0;
        this.r.notifyUI(5006, true, new Object[] { Long.valueOf(paramMessageRecord.uniseq), localObject });
      }
    }
  }
  
  public IGrpDisPTTDecoder<BaseMessageHandler> b()
  {
    return c().getGrpDisPTTDecoder();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.imcore.message.BaseMessageProcessorForTroopAndDisc
 * JD-Core Version:    0.7.0.1
 */