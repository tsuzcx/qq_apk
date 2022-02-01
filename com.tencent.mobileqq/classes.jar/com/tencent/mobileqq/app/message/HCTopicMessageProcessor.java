package com.tencent.mobileqq.app.message;

import android.util.Pair;
import com.tencent.common.app.AppInterface;
import com.tencent.imcore.message.BaseMessageManagerForTroopAndDisc;
import com.tencent.imcore.message.BaseMessageProcessorForTroopAndDisc;
import com.tencent.imcore.message.MsgProxyUtils;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.app.BaseMessageHandler;
import com.tencent.mobileqq.app.BaseMessageHandlerUtils;
import com.tencent.mobileqq.app.HotChatManager;
import com.tencent.mobileqq.app.MessageHandler;
import com.tencent.mobileqq.app.MessageHandlerUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.handler.PreDownloadMsg;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.hotchat.PttShowRoomMng;
import com.tencent.mobileqq.msg.api.IMessageFacade;
import com.tencent.mobileqq.nearby.NearbyUtils;
import com.tencent.mobileqq.nearby.api.IHotChatUtil;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.service.message.MessageCache;
import com.tencent.mobileqq.service.message.MessageCacheItem;
import com.tencent.mobileqq.service.message.PBDecodeContext;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import msf.msgcomm.msg_comm.GroupInfo;
import msf.msgcomm.msg_comm.Msg;
import msf.msgcomm.msg_comm.MsgHead;
import msf.msgsvc.msg_svc.PbGroupReadedReportReq;
import msf.msgsvc.msg_svc.PbMsgReadedReportReq;

public class HCTopicMessageProcessor
  extends BaseMessageProcessorForTroopAndDisc
{
  public Comparator u = new HCTopicMessageProcessor.1(this);
  
  public HCTopicMessageProcessor(QQAppInterface paramQQAppInterface, MessageHandler paramMessageHandler)
  {
    super(paramQQAppInterface, paramMessageHandler);
  }
  
  private ArrayList<MessageRecord> a(ArrayList<msg_comm.Msg> paramArrayList, String paramString)
  {
    if ((paramArrayList != null) && (paramArrayList.size() != 0))
    {
      if (QLog.isColorLevel()) {
        NearbyUtils.a("HCTopicMsgProc", new Object[] { "<---groupMsgRecordHandle_PB", paramString, Integer.valueOf(paramArrayList.size()) });
      }
      ArrayList localArrayList1 = new ArrayList();
      ArrayList localArrayList2 = new ArrayList();
      PBDecodeContext localPBDecodeContext = new PBDecodeContext();
      localPBDecodeContext.x = Long.valueOf(paramString).longValue();
      localPBDecodeContext.w = 1026;
      paramArrayList = paramArrayList.iterator();
      while (paramArrayList.hasNext())
      {
        paramString = (msg_comm.Msg)paramArrayList.next();
        if (paramString != null)
        {
          localArrayList1.clear();
          Object localObject = (msg_comm.MsgHead)paramString.msg_head.get();
          long l = ((msg_comm.MsgHead)localObject).msg_uid.get();
          localPBDecodeContext.y = ((msg_comm.GroupInfo)((msg_comm.MsgHead)localObject).group_info.get()).group_type.get();
          try
          {
            a(paramString, localArrayList1, localPBDecodeContext, false, null);
          }
          catch (Exception paramString)
          {
            if (QLog.isColorLevel()) {
              QLog.w("HCTopicMsgProc", 2, "decodeSinglePbMsg_GroupDis error,", paramString);
            }
          }
          if (localArrayList1.size() != 0)
          {
            BaseMessageHandlerUtils.a(localArrayList1);
            if (localArrayList1.size() > 0)
            {
              paramString = localArrayList1.iterator();
              while (paramString.hasNext())
              {
                localObject = (MessageRecord)paramString.next();
                if (((MessageRecord)localObject).msgUid == 0L) {
                  ((MessageRecord)localObject).msgUid = l;
                }
              }
            }
            localArrayList2.addAll(localArrayList1);
          }
        }
      }
      a(localArrayList2);
      localArrayList1.clear();
      a(localArrayList2, localArrayList1, true);
      return localArrayList1;
    }
    return null;
  }
  
  private void b(List<msg_comm.Msg> paramList1, List<msg_comm.Msg> paramList2)
  {
    Pair localPair = super.a(paramList1, paramList2);
    if ((((Boolean)localPair.first).booleanValue()) && (QLog.isColorLevel()))
    {
      StringBuilder localStringBuilder = new StringBuilder("<---HCTopicMessagePackage:msgFilter_OnePkg ");
      localStringBuilder.append((CharSequence)localPair.second);
      localStringBuilder.append(" inListSize:");
      localStringBuilder.append(paramList1.size());
      localStringBuilder.append(" outListSize:");
      localStringBuilder.append(paramList2.size());
      QLog.d("HCTopicMsgProc", 2, localStringBuilder.toString());
    }
  }
  
  /* Error */
  public void a(int paramInt, Object... paramVarArgs)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 12
    //   3: iconst_1
    //   4: istore_3
    //   5: iload_1
    //   6: tableswitch	default:+26 -> 32, 1001:+242->248, 1002:+27->33, 1003:+27->33
    //   33: lconst_0
    //   34: lstore 4
    //   36: new 25	java/util/ArrayList
    //   39: dup
    //   40: invokespecial 55	java/util/ArrayList:<init>	()V
    //   43: astore 9
    //   45: aload_0
    //   46: aload_2
    //   47: iconst_0
    //   48: aaload
    //   49: checkcast 25	java/util/ArrayList
    //   52: aload 9
    //   54: invokespecial 214	com/tencent/mobileqq/app/message/HCTopicMessageProcessor:b	(Ljava/util/List;Ljava/util/List;)V
    //   57: aload_2
    //   58: iconst_1
    //   59: aaload
    //   60: checkcast 216	java/lang/String
    //   63: astore 11
    //   65: aload_2
    //   66: iconst_2
    //   67: aaload
    //   68: checkcast 216	java/lang/String
    //   71: astore 12
    //   73: aload_2
    //   74: iconst_3
    //   75: aaload
    //   76: checkcast 60	java/lang/Long
    //   79: invokevirtual 67	java/lang/Long:longValue	()J
    //   82: lstore 6
    //   84: iconst_1
    //   85: istore 8
    //   87: lload 6
    //   89: lstore 4
    //   91: aload 12
    //   93: astore_2
    //   94: goto +49 -> 143
    //   97: astore 10
    //   99: aload 12
    //   101: astore_2
    //   102: goto +7 -> 109
    //   105: astore 10
    //   107: aconst_null
    //   108: astore_2
    //   109: goto +26 -> 135
    //   112: astore 10
    //   114: aconst_null
    //   115: astore_2
    //   116: aload 12
    //   118: astore 11
    //   120: goto +15 -> 135
    //   123: astore 10
    //   125: aconst_null
    //   126: astore 9
    //   128: aload 9
    //   130: astore_2
    //   131: aload 12
    //   133: astore 11
    //   135: aload 10
    //   137: invokevirtual 219	java/lang/Exception:printStackTrace	()V
    //   140: iconst_0
    //   141: istore 8
    //   143: invokestatic 35	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   146: ifeq +54 -> 200
    //   149: ldc 37
    //   151: bipush 6
    //   153: anewarray 39	java/lang/Object
    //   156: dup
    //   157: iconst_0
    //   158: ldc 221
    //   160: aastore
    //   161: dup
    //   162: iconst_1
    //   163: iload 8
    //   165: invokestatic 224	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   168: aastore
    //   169: dup
    //   170: iconst_2
    //   171: aload 11
    //   173: aastore
    //   174: dup
    //   175: iconst_3
    //   176: aload_2
    //   177: aastore
    //   178: dup
    //   179: iconst_4
    //   180: lload 4
    //   182: invokestatic 227	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   185: aastore
    //   186: dup
    //   187: iconst_5
    //   188: aload 9
    //   190: invokevirtual 29	java/util/ArrayList:size	()I
    //   193: invokestatic 47	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   196: aastore
    //   197: invokestatic 52	com/tencent/mobileqq/nearby/NearbyUtils:a	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   200: iload 8
    //   202: ifeq +33 -> 235
    //   205: iload_1
    //   206: sipush 1002
    //   209: if_icmpne +9 -> 218
    //   212: iconst_1
    //   213: istore 8
    //   215: goto +6 -> 221
    //   218: iconst_0
    //   219: istore 8
    //   221: aload_0
    //   222: iload 8
    //   224: aload 11
    //   226: aload 9
    //   228: aload_2
    //   229: lload 4
    //   231: invokevirtual 230	com/tencent/mobileqq/app/message/HCTopicMessageProcessor:a	(ZLjava/lang/String;Ljava/util/ArrayList;Ljava/lang/String;J)V
    //   234: return
    //   235: aload_0
    //   236: aload_0
    //   237: invokevirtual 234	java/lang/Object:getClass	()Ljava/lang/Class;
    //   240: invokevirtual 239	java/lang/Class:getName	()Ljava/lang/String;
    //   243: iload_1
    //   244: invokevirtual 242	com/tencent/mobileqq/app/message/HCTopicMessageProcessor:a	(Ljava/lang/String;I)V
    //   247: return
    //   248: aload_2
    //   249: iconst_0
    //   250: aaload
    //   251: checkcast 90	msf/msgcomm/msg_comm$Msg
    //   254: astore 9
    //   256: aload_2
    //   257: iconst_1
    //   258: aaload
    //   259: checkcast 216	java/lang/String
    //   262: astore_2
    //   263: aload 9
    //   265: getfield 246	msf/msgcomm/msg_comm$Msg:appshare_info	Lmsf/msgcomm/msg_comm$AppShareInfo;
    //   268: iconst_0
    //   269: invokevirtual 252	msf/msgcomm/msg_comm$AppShareInfo:setHasFlag	(Z)V
    //   272: goto +30 -> 302
    //   275: astore 10
    //   277: goto +18 -> 295
    //   280: astore 10
    //   282: aconst_null
    //   283: astore_2
    //   284: goto +11 -> 295
    //   287: astore 10
    //   289: aconst_null
    //   290: astore 9
    //   292: aload 9
    //   294: astore_2
    //   295: aload 10
    //   297: invokevirtual 219	java/lang/Exception:printStackTrace	()V
    //   300: iconst_0
    //   301: istore_3
    //   302: iload_3
    //   303: ifeq +11 -> 314
    //   306: aload_0
    //   307: aload 9
    //   309: aload_2
    //   310: invokevirtual 255	com/tencent/mobileqq/app/message/HCTopicMessageProcessor:a	(Lmsf/msgcomm/msg_comm$Msg;Ljava/lang/String;)V
    //   313: return
    //   314: aload_0
    //   315: aload_0
    //   316: invokevirtual 234	java/lang/Object:getClass	()Ljava/lang/Class;
    //   319: invokevirtual 239	java/lang/Class:getName	()Ljava/lang/String;
    //   322: iload_1
    //   323: invokevirtual 242	com/tencent/mobileqq/app/message/HCTopicMessageProcessor:a	(Ljava/lang/String;I)V
    //   326: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	327	0	this	HCTopicMessageProcessor
    //   0	327	1	paramInt	int
    //   0	327	2	paramVarArgs	Object[]
    //   4	299	3	i	int
    //   34	196	4	l1	long
    //   82	6	6	l2	long
    //   85	138	8	bool	boolean
    //   43	265	9	localObject	Object
    //   97	1	10	localException1	Exception
    //   105	1	10	localException2	Exception
    //   112	1	10	localException3	Exception
    //   123	13	10	localException4	Exception
    //   275	1	10	localException5	Exception
    //   280	1	10	localException6	Exception
    //   287	9	10	localException7	Exception
    //   63	162	11	str1	String
    //   1	131	12	str2	String
    // Exception table:
    //   from	to	target	type
    //   73	84	97	java/lang/Exception
    //   65	73	105	java/lang/Exception
    //   45	65	112	java/lang/Exception
    //   36	45	123	java/lang/Exception
    //   263	272	275	java/lang/Exception
    //   256	263	280	java/lang/Exception
    //   248	256	287	java/lang/Exception
  }
  
  public void a(String paramString, int paramInt, long paramLong)
  {
    super.a(paramString, paramInt, paramLong);
    msg_svc.PbMsgReadedReportReq localPbMsgReadedReportReq = new msg_svc.PbMsgReadedReportReq();
    msg_svc.PbGroupReadedReportReq localPbGroupReadedReportReq = new msg_svc.PbGroupReadedReportReq();
    localPbGroupReadedReportReq.group_code.set(Long.valueOf(paramString).longValue());
    localPbGroupReadedReportReq.last_read_seq.set(paramLong);
    localPbMsgReadedReportReq.grp_read_report.add(localPbGroupReadedReportReq);
    a(localPbMsgReadedReportReq);
  }
  
  protected void a(List<MessageRecord> paramList)
  {
    if (paramList != null)
    {
      if (paramList.size() == 0) {
        return;
      }
      try
      {
        PttShowRoomMng localPttShowRoomMng = ((HotChatManager)this.r.b().getManager(QQManagerFactory.HOT_CHAT_MANAGER)).b(true);
        paramList = paramList.iterator();
        while (paramList.hasNext()) {
          localPttShowRoomMng.a((MessageRecord)paramList.next());
        }
        return;
      }
      catch (Exception paramList)
      {
        paramList.printStackTrace();
      }
    }
  }
  
  protected void a(msg_comm.Msg paramMsg, String paramString)
  {
    NearbyUtils.a("HCTopicMsgProc", "processPush", new Object[] { paramString, paramMsg });
    if ((paramMsg != null) && (paramMsg.msg_head.has()))
    {
      Object localObject1 = (msg_comm.MsgHead)paramMsg.msg_head.get();
      if (!((msg_comm.MsgHead)localObject1).group_info.has())
      {
        if (QLog.isColorLevel()) {
          NearbyUtils.a("HCTopicMsgProc", new Object[] { "<---handleMsgPush_PB_Group: no groupInfo." });
        }
        return;
      }
      Object localObject2 = (msg_comm.GroupInfo)((msg_comm.MsgHead)localObject1).group_info.get();
      long l1 = ((msg_comm.MsgHead)localObject1).msg_seq.get();
      long l2 = ((msg_comm.MsgHead)localObject1).msg_uid.get();
      long l3 = ((msg_comm.GroupInfo)localObject2).group_code.get();
      int j = ((msg_comm.GroupInfo)localObject2).group_type.get();
      long l4 = Long.valueOf(this.q.getCurrentAccountUin()).longValue();
      if (l3 != 0L) {
        paramString = String.valueOf(l3);
      }
      localObject2 = ((MessageCache)this.q.getMsgCache()).G();
      if (((MessageCacheItem)localObject2).a(paramString) == 2) {
        i = 1;
      } else {
        i = 0;
      }
      if (i == 0)
      {
        ((MessageCacheItem)localObject2).a(paramString, new Object[] { paramMsg, paramString });
        return;
      }
      ArrayList localArrayList = new ArrayList();
      localObject1 = new ArrayList();
      Object localObject3 = new PBDecodeContext();
      ((PBDecodeContext)localObject3).x = l3;
      ((PBDecodeContext)localObject3).w = 1026;
      ((PBDecodeContext)localObject3).y = j;
      try
      {
        a(paramMsg, localArrayList, (PBDecodeContext)localObject3, false, null);
      }
      catch (Exception paramMsg)
      {
        for (;;)
        {
          if (QLog.isColorLevel()) {
            QLog.w("HCTopicMsgProc", 2, "decodeSinglePbMsg_GroupDis error,", paramMsg);
          }
        }
      }
      a(localArrayList);
      BaseMessageHandlerUtils.a(localArrayList);
      if (localArrayList.size() == 0)
      {
        if (QLog.isColorLevel()) {
          QLog.d("HCTopicMsgProc", 2, "<---handleMsgPush_PB_Group : msg list is empty after decode.");
        }
        return;
      }
      int i = 0;
      while (i < localArrayList.size())
      {
        paramMsg = (MessageRecord)localArrayList.get(i);
        if ((paramMsg != null) && (paramMsg.senderuin != null) && (paramMsg.senderuin.equalsIgnoreCase(this.q.getCurrentAccountUin()))) {
          b(paramMsg);
        }
        i += 1;
      }
      a(localArrayList, (ArrayList)localObject1, true);
      localArrayList.clear();
      int k = ((ArrayList)localObject1).size();
      i = 0;
      paramMsg = (msg_comm.Msg)localObject1;
      while (i < k)
      {
        localObject1 = (MessageRecord)paramMsg.get(i);
        if (((MessageRecord)localObject1).msgUid == 0L) {
          ((MessageRecord)localObject1).msgUid = l2;
        }
        if (QLog.isColorLevel())
        {
          localObject3 = new StringBuilder("<---handleMsgPush_PB_Group : after analysis :");
          ((StringBuilder)localObject3).append("mr.senderuin:");
          ((StringBuilder)localObject3).append(((MessageRecord)localObject1).senderuin);
          ((StringBuilder)localObject3).append(" mr.msgtype:");
          ((StringBuilder)localObject3).append(((MessageRecord)localObject1).msgtype);
          ((StringBuilder)localObject3).append(" mr.msgUid:");
          ((StringBuilder)localObject3).append(((MessageRecord)localObject1).msgUid);
          ((StringBuilder)localObject3).append(" mr.frienduin:");
          ((StringBuilder)localObject3).append(((MessageRecord)localObject1).frienduin);
          ((StringBuilder)localObject3).append(" mr.shmsgseq:");
          ((StringBuilder)localObject3).append(((MessageRecord)localObject1).shmsgseq);
          ((StringBuilder)localObject3).append(" mr.time:");
          ((StringBuilder)localObject3).append(((MessageRecord)localObject1).time);
          ((StringBuilder)localObject3).append(" mr.msg:");
          ((StringBuilder)localObject3).append(((MessageRecord)localObject1).getLogColorContent());
          QLog.d("HCTopicMsgProc", 2, ((StringBuilder)localObject3).toString());
        }
        if ((((MessageRecord)localObject1).senderuin != null) && (((MessageRecord)localObject1).senderuin.equalsIgnoreCase(this.q.getCurrentAccountUin())))
        {
          if (b((MessageRecord)localObject1)) {
            break label728;
          }
          ((MessageRecord)localObject1).isread = true;
          ((MessageRecord)localObject1).issend = 2;
          ((IMessageFacade)this.q.getRuntimeService(IMessageFacade.class, "")).setReadFrom(((MessageRecord)localObject1).frienduin, 1026, ((MessageRecord)localObject1).shmsgseq);
        }
        localArrayList.add(localObject1);
        label728:
        i += 1;
      }
      boolean bool = MessageHandlerUtils.a(localArrayList);
      i = MsgProxyUtils.a(localArrayList, (MessageCache)this.q.getMsgCache());
      paramMsg = (IMessageFacade)this.q.getRuntimeService(IMessageFacade.class, "");
      if ((bool) && (this.q.isBackgroundPause)) {
        bool = true;
      } else {
        bool = false;
      }
      paramMsg.addMessage(localArrayList, String.valueOf(l4), bool);
      if (localArrayList.size() > 0)
      {
        ((IHotChatUtil)QRoute.api(IHotChatUtil.class)).addLocalMaxMsgSeq((MessageCacheItem)localObject2, l1, paramString, 1);
        ((MessageCacheItem)localObject2).a(1, paramString, l1, 2);
      }
      if (j == 127) {
        return;
      }
      a("handleMsgPush_PB_Group", true, i, false, false);
      PreDownloadMsg.a(localArrayList, true, this.q);
      return;
    }
    if (QLog.isColorLevel()) {
      NearbyUtils.a("HCTopicMsgProc", new Object[] { "processPush invalidate params" });
    }
  }
  
  protected void a(boolean paramBoolean, String paramString1, ArrayList<msg_comm.Msg> paramArrayList, String paramString2, long paramLong)
  {
    int k = 0;
    if (paramArrayList != null) {
      paramString2 = Integer.valueOf(paramArrayList.size());
    } else {
      paramString2 = "null";
    }
    NearbyUtils.a("HCTopicMsgProc", "processGetMsgs", new Object[] { Boolean.valueOf(paramBoolean), paramString1, paramString2 });
    paramString2 = null;
    if (paramArrayList != null) {
      paramString2 = a(paramArrayList, paramString1);
    }
    String str = this.q.getCurrentUin();
    MessageCacheItem localMessageCacheItem = ((MessageCache)this.q.getMsgCache()).G();
    if ((paramString2 != null) && (paramString2.size() > 0))
    {
      Collections.sort(paramString2, this.u);
      ArrayList localArrayList = new ArrayList();
      i = paramString2.size() - 1;
      long l2 = -9223372036854775808L;
      long l3;
      long l4;
      for (long l1 = 9223372036854775807L; i >= 0; l1 = l4)
      {
        paramArrayList = (MessageRecord)paramString2.get(i);
        l3 = l2;
        if (l2 < paramArrayList.shmsgseq) {
          l3 = paramArrayList.shmsgseq;
        }
        l4 = l1;
        if (l1 > paramArrayList.shmsgseq) {
          l4 = paramArrayList.shmsgseq;
        }
        if ((paramArrayList.senderuin == null) || (!paramArrayList.senderuin.equalsIgnoreCase(this.q.getCurrentAccountUin())) || (!b(paramArrayList))) {
          localArrayList.add(0, paramArrayList);
        }
        i -= 1;
        l2 = l3;
      }
      paramArrayList = localArrayList;
      if (localArrayList.size() > 0)
      {
        l3 = localMessageCacheItem.b(2, paramString1);
        paramArrayList = (BaseMessageManagerForTroopAndDisc)((QQAppInterface)this.q).getMessageFacade().a(1026);
        paramString2 = localArrayList.iterator();
        while (paramString2.hasNext())
        {
          MessageRecord localMessageRecord = (MessageRecord)paramString2.next();
          if (localMessageRecord != null)
          {
            if ((localMessageRecord.senderuin != null) && (localMessageRecord.senderuin.equalsIgnoreCase(this.q.getCurrentAccountUin())))
            {
              localMessageRecord.isread = true;
              localMessageRecord.issend = 2;
            }
            if (l3 >= localMessageRecord.shmsgseq) {
              localMessageRecord.isread = true;
            }
          }
        }
        paramBoolean = MessageHandlerUtils.a(localArrayList);
        int m = MsgProxyUtils.a(localArrayList, (MessageCache)this.q.getMsgCache());
        paramString2 = (IMessageFacade)this.q.getRuntimeService(IMessageFacade.class, "");
        if ((paramBoolean) && (this.q.isBackgroundPause)) {
          paramBoolean = true;
        } else {
          paramBoolean = false;
        }
        paramString2.addMessage(localArrayList, str, paramBoolean, false);
        paramArrayList.c(paramString1, 1026, l3);
        paramArrayList.a(paramString1, localArrayList);
        if (l2 != -9223372036854775808L) {
          ((IHotChatUtil)QRoute.api(IHotChatUtil.class)).addLocalMaxMsgSeq(localMessageCacheItem, l2, paramString1, 3);
        }
        j = k;
        paramArrayList = localArrayList;
        i = m;
        if (l1 == 9223372036854775807L) {
          break label593;
        }
        localMessageCacheItem.a(1, paramString1, l1, 2);
        j = k;
        paramArrayList = localArrayList;
        i = m;
        if (paramLong != 0L) {
          break label593;
        }
        localMessageCacheItem.a(3, paramString1, l1, 1);
        j = k;
        paramArrayList = localArrayList;
        i = m;
        break label593;
      }
    }
    else
    {
      paramArrayList = paramString2;
    }
    int j = 1;
    int i = 0;
    label593:
    if ((j != 0) && (localMessageCacheItem.a(paramString1) == 1))
    {
      paramLong = localMessageCacheItem.b(2, paramString1);
      ((BaseMessageManagerForTroopAndDisc)((QQAppInterface)this.q).getMessageFacade().a(1026)).c(paramString1, 1026, paramLong);
    }
    a("processGetMsgs", true, i, false, false);
    PreDownloadMsg.a(paramArrayList, true, this.q);
  }
  
  protected boolean b(MessageRecord paramMessageRecord)
  {
    Object localObject = ((IMessageFacade)this.q.getRuntimeService(IMessageFacade.class, "")).getSendingTroopMsgItem(paramMessageRecord.frienduin, 1026, paramMessageRecord);
    if (localObject != null)
    {
      if (((MessageCache)this.q.getMsgCache()).f((MessageRecord)localObject)) {
        a((MessageRecord)localObject);
      }
      if (!((MessageCache)this.q.getMsgCache()).B()) {
        ((MessageCache)this.q.getMsgCache()).b(((MessageRecord)localObject).frienduin, ((MessageRecord)localObject).istroop, ((MessageRecord)localObject).uniseq);
      }
      this.r.a(paramMessageRecord.frienduin, 1026, ((MessageRecord)localObject).uniseq, paramMessageRecord.shmsgseq, paramMessageRecord.time);
      localObject = ((MessageCache)this.q.getMsgCache()).G();
      ((IHotChatUtil)QRoute.api(IHotChatUtil.class)).addLocalMaxMsgSeq((MessageCacheItem)localObject, paramMessageRecord.shmsgseq, paramMessageRecord.frienduin, 2);
      return true;
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.app.message.HCTopicMessageProcessor
 * JD-Core Version:    0.7.0.1
 */