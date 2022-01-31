import android.util.Pair;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.app.HotChatManager;
import com.tencent.mobileqq.app.MessageHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
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

public class amgg
  extends aboa
{
  public Comparator b = new amgh(this);
  
  public amgg(QQAppInterface paramQQAppInterface, MessageHandler paramMessageHandler)
  {
    super(paramQQAppInterface, paramMessageHandler);
  }
  
  private ArrayList<MessageRecord> a(ArrayList<msg_comm.Msg> paramArrayList, String paramString)
  {
    if ((paramArrayList == null) || (paramArrayList.size() == 0)) {
      return null;
    }
    if (QLog.isColorLevel()) {
      ausq.a("HCTopicMsgProc", new Object[] { "<---groupMsgRecordHandle_PB", paramString, Integer.valueOf(paramArrayList.size()) });
    }
    ArrayList localArrayList1 = new ArrayList();
    ArrayList localArrayList2 = new ArrayList();
    ayvz localayvz = new ayvz();
    localayvz.e = Long.valueOf(paramString).longValue();
    localayvz.c = 1026;
    paramArrayList = paramArrayList.iterator();
    while (paramArrayList.hasNext())
    {
      paramString = (msg_comm.Msg)paramArrayList.next();
      if (paramString != null)
      {
        localArrayList1.clear();
        Object localObject = (msg_comm.MsgHead)paramString.msg_head.get();
        long l = ((msg_comm.MsgHead)localObject).msg_uid.get();
        localayvz.d = ((msg_comm.GroupInfo)((msg_comm.MsgHead)localObject).group_info.get()).group_type.get();
        try
        {
          a(paramString, localArrayList1, localayvz, false, null);
          if (localArrayList1.size() != 0)
          {
            alsh.a(localArrayList1);
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
          }
        }
        catch (Exception paramString)
        {
          for (;;)
          {
            if (QLog.isColorLevel()) {
              QLog.w("HCTopicMsgProc", 2, "decodeSinglePbMsg_GroupDis error,", paramString);
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
  
  private void a(List<msg_comm.Msg> paramList1, List<msg_comm.Msg> paramList2)
  {
    Pair localPair = super.a(paramList1, paramList2);
    if ((((Boolean)localPair.first).booleanValue()) && (QLog.isColorLevel()))
    {
      StringBuilder localStringBuilder = new StringBuilder("<---HCTopicMessagePackage:msgFilter_OnePkg ");
      localStringBuilder.append((CharSequence)localPair.second);
      localStringBuilder.append(" inListSize:").append(paramList1.size()).append(" outListSize:").append(paramList2.size());
      QLog.d("HCTopicMsgProc", 2, localStringBuilder.toString());
    }
  }
  
  /* Error */
  public void a(int paramInt, Object... paramVarArgs)
  {
    // Byte code:
    //   0: iload_1
    //   1: tableswitch	default:+27 -> 28, 1001:+28->29, 1002:+96->97, 1003:+96->97
    //   29: aload_2
    //   30: iconst_0
    //   31: aaload
    //   32: checkcast 89	msf/msgcomm/msg_comm$Msg
    //   35: astore 9
    //   37: aload_2
    //   38: iconst_1
    //   39: aaload
    //   40: checkcast 212	java/lang/String
    //   43: astore_2
    //   44: aload 9
    //   46: getfield 216	msf/msgcomm/msg_comm$Msg:appshare_info	Lmsf/msgcomm/msg_comm$AppShareInfo;
    //   49: iconst_0
    //   50: invokevirtual 222	msf/msgcomm/msg_comm$AppShareInfo:setHasFlag	(Z)V
    //   53: iconst_1
    //   54: istore_3
    //   55: iload_3
    //   56: ifeq +28 -> 84
    //   59: aload_0
    //   60: aload 9
    //   62: aload_2
    //   63: invokevirtual 225	amgg:a	(Lmsf/msgcomm/msg_comm$Msg;Ljava/lang/String;)V
    //   66: return
    //   67: astore 10
    //   69: aconst_null
    //   70: astore 9
    //   72: aconst_null
    //   73: astore_2
    //   74: aload 10
    //   76: invokevirtual 228	java/lang/Exception:printStackTrace	()V
    //   79: iconst_0
    //   80: istore_3
    //   81: goto -26 -> 55
    //   84: aload_0
    //   85: aload_0
    //   86: invokevirtual 232	java/lang/Object:getClass	()Ljava/lang/Class;
    //   89: invokevirtual 237	java/lang/Class:getName	()Ljava/lang/String;
    //   92: iload_1
    //   93: invokevirtual 240	amgg:a	(Ljava/lang/String;I)V
    //   96: return
    //   97: aconst_null
    //   98: astore 12
    //   100: lconst_0
    //   101: lstore 4
    //   103: new 24	java/util/ArrayList
    //   106: dup
    //   107: invokespecial 54	java/util/ArrayList:<init>	()V
    //   110: astore 10
    //   112: aload_0
    //   113: aload_2
    //   114: iconst_0
    //   115: aaload
    //   116: checkcast 24	java/util/ArrayList
    //   119: aload 10
    //   121: invokespecial 242	amgg:a	(Ljava/util/List;Ljava/util/List;)V
    //   124: aload_2
    //   125: iconst_1
    //   126: aaload
    //   127: checkcast 212	java/lang/String
    //   130: astore 9
    //   132: aload_2
    //   133: iconst_2
    //   134: aaload
    //   135: checkcast 212	java/lang/String
    //   138: astore 11
    //   140: aload_2
    //   141: iconst_3
    //   142: aaload
    //   143: checkcast 59	java/lang/Long
    //   146: invokevirtual 66	java/lang/Long:longValue	()J
    //   149: lstore 6
    //   151: lload 6
    //   153: lstore 4
    //   155: iconst_1
    //   156: istore 8
    //   158: aload 9
    //   160: astore_2
    //   161: invokestatic 34	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   164: ifeq +54 -> 218
    //   167: ldc 36
    //   169: bipush 6
    //   171: anewarray 38	java/lang/Object
    //   174: dup
    //   175: iconst_0
    //   176: ldc 244
    //   178: aastore
    //   179: dup
    //   180: iconst_1
    //   181: iload 8
    //   183: invokestatic 247	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   186: aastore
    //   187: dup
    //   188: iconst_2
    //   189: aload_2
    //   190: aastore
    //   191: dup
    //   192: iconst_3
    //   193: aload 11
    //   195: aastore
    //   196: dup
    //   197: iconst_4
    //   198: lload 4
    //   200: invokestatic 250	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   203: aastore
    //   204: dup
    //   205: iconst_5
    //   206: aload 10
    //   208: invokevirtual 28	java/util/ArrayList:size	()I
    //   211: invokestatic 46	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   214: aastore
    //   215: invokestatic 51	ausq:a	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   218: iload 8
    //   220: ifeq +55 -> 275
    //   223: iload_1
    //   224: sipush 1002
    //   227: if_icmpne +42 -> 269
    //   230: iconst_1
    //   231: istore 8
    //   233: aload_0
    //   234: iload 8
    //   236: aload_2
    //   237: aload 10
    //   239: aload 11
    //   241: lload 4
    //   243: invokevirtual 253	amgg:a	(ZLjava/lang/String;Ljava/util/ArrayList;Ljava/lang/String;J)V
    //   246: return
    //   247: astore 9
    //   249: aconst_null
    //   250: astore_2
    //   251: aconst_null
    //   252: astore 10
    //   254: aload 12
    //   256: astore 11
    //   258: aload 9
    //   260: invokevirtual 228	java/lang/Exception:printStackTrace	()V
    //   263: iconst_0
    //   264: istore 8
    //   266: goto -105 -> 161
    //   269: iconst_0
    //   270: istore 8
    //   272: goto -39 -> 233
    //   275: aload_0
    //   276: aload_0
    //   277: invokevirtual 232	java/lang/Object:getClass	()Ljava/lang/Class;
    //   280: invokevirtual 237	java/lang/Class:getName	()Ljava/lang/String;
    //   283: iload_1
    //   284: invokevirtual 240	amgg:a	(Ljava/lang/String;I)V
    //   287: return
    //   288: astore 9
    //   290: aconst_null
    //   291: astore_2
    //   292: aload 12
    //   294: astore 11
    //   296: goto -38 -> 258
    //   299: astore 11
    //   301: aload 9
    //   303: astore_2
    //   304: aload 11
    //   306: astore 9
    //   308: aload 12
    //   310: astore 11
    //   312: goto -54 -> 258
    //   315: astore 12
    //   317: aload 9
    //   319: astore_2
    //   320: aload 12
    //   322: astore 9
    //   324: goto -66 -> 258
    //   327: astore 10
    //   329: aconst_null
    //   330: astore_2
    //   331: goto -257 -> 74
    //   334: astore 10
    //   336: goto -262 -> 74
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	339	0	this	amgg
    //   0	339	1	paramInt	int
    //   0	339	2	paramVarArgs	Object[]
    //   54	27	3	i	int
    //   101	141	4	l1	long
    //   149	3	6	l2	long
    //   156	115	8	bool	boolean
    //   35	124	9	localObject1	Object
    //   247	12	9	localException1	Exception
    //   288	14	9	localException2	Exception
    //   306	17	9	localObject2	Object
    //   67	8	10	localException3	Exception
    //   110	143	10	localArrayList	ArrayList
    //   327	1	10	localException4	Exception
    //   334	1	10	localException5	Exception
    //   138	157	11	localObject3	Object
    //   299	6	11	localException6	Exception
    //   310	1	11	localObject4	Object
    //   98	211	12	localObject5	Object
    //   315	6	12	localException7	Exception
    // Exception table:
    //   from	to	target	type
    //   29	37	67	java/lang/Exception
    //   103	112	247	java/lang/Exception
    //   112	132	288	java/lang/Exception
    //   132	140	299	java/lang/Exception
    //   140	151	315	java/lang/Exception
    //   37	44	327	java/lang/Exception
    //   44	53	334	java/lang/Exception
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
    if ((paramList == null) || (paramList.size() == 0)) {}
    for (;;)
    {
      return;
      try
      {
        asou localasou = this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler.app.a(true).a(true);
        paramList = paramList.iterator();
        while (paramList.hasNext()) {
          localasou.a((MessageRecord)paramList.next());
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
    ausq.a("HCTopicMsgProc", "processPush", new Object[] { paramString, paramMsg });
    if ((paramMsg == null) || (!paramMsg.msg_head.has())) {
      if (QLog.isColorLevel()) {
        ausq.a("HCTopicMsgProc", new Object[] { "processPush invalidate params" });
      }
    }
    Object localObject1;
    Object localObject2;
    long l1;
    int j;
    long l4;
    int i;
    for (;;)
    {
      return;
      localObject1 = (msg_comm.MsgHead)paramMsg.msg_head.get();
      if (!((msg_comm.MsgHead)localObject1).group_info.has())
      {
        if (QLog.isColorLevel()) {
          ausq.a("HCTopicMsgProc", new Object[] { "<---handleMsgPush_PB_Group: no groupInfo." });
        }
      }
      else
      {
        localObject2 = (msg_comm.GroupInfo)((msg_comm.MsgHead)localObject1).group_info.get();
        l1 = ((msg_comm.MsgHead)localObject1).msg_seq.get();
        long l2 = ((msg_comm.MsgHead)localObject1).msg_uid.get();
        long l3 = ((msg_comm.GroupInfo)localObject2).group_code.get();
        j = ((msg_comm.GroupInfo)localObject2).group_type.get();
        l4 = Long.valueOf(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin()).longValue();
        if (l3 != 0L) {
          paramString = String.valueOf(l3);
        }
        localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a();
        if (((ayvi)localObject1).a(paramString) == 2) {}
        for (i = 1; i == 0; i = 0)
        {
          ((ayvi)localObject1).a(paramString, new Object[] { paramMsg, paramString });
          return;
        }
        localObject2 = new ArrayList();
        ArrayList localArrayList = new ArrayList();
        Object localObject3 = new ayvz();
        ((ayvz)localObject3).e = l3;
        ((ayvz)localObject3).c = 1026;
        ((ayvz)localObject3).d = j;
        try
        {
          a(paramMsg, (ArrayList)localObject2, (ayvz)localObject3, false, null);
          a((List)localObject2);
          alsh.a((List)localObject2);
          if (((ArrayList)localObject2).size() == 0)
          {
            if (!QLog.isColorLevel()) {
              continue;
            }
            QLog.d("HCTopicMsgProc", 2, "<---handleMsgPush_PB_Group : msg list is empty after decode.");
          }
        }
        catch (Exception paramMsg)
        {
          for (;;)
          {
            if (QLog.isColorLevel()) {
              QLog.w("HCTopicMsgProc", 2, "decodeSinglePbMsg_GroupDis error,", paramMsg);
            }
          }
          i = 0;
          while (i < ((ArrayList)localObject2).size())
          {
            paramMsg = (MessageRecord)((ArrayList)localObject2).get(i);
            if ((paramMsg != null) && (paramMsg.senderuin != null) && (paramMsg.senderuin.equalsIgnoreCase(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin()))) {
              a(paramMsg);
            }
            i += 1;
          }
          a((ArrayList)localObject2, localArrayList, true);
          ((ArrayList)localObject2).clear();
          int k = localArrayList.size();
          i = 0;
          if (i < k)
          {
            paramMsg = (MessageRecord)localArrayList.get(i);
            if (paramMsg.msgUid == 0L) {
              paramMsg.msgUid = l2;
            }
            if (QLog.isColorLevel())
            {
              localObject3 = new StringBuilder("<---handleMsgPush_PB_Group : after analysis :");
              ((StringBuilder)localObject3).append("mr.senderuin:").append(paramMsg.senderuin).append(" mr.msgtype:").append(paramMsg.msgtype).append(" mr.msgUid:").append(paramMsg.msgUid).append(" mr.frienduin:").append(paramMsg.frienduin).append(" mr.shmsgseq:").append(paramMsg.shmsgseq).append(" mr.time:").append(paramMsg.time).append(" mr.msg:").append(paramMsg.getLogColorContent());
              QLog.d("HCTopicMsgProc", 2, ((StringBuilder)localObject3).toString());
            }
            if ((paramMsg.senderuin != null) && (paramMsg.senderuin.equalsIgnoreCase(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin()))) {
              if (!a(paramMsg)) {}
            }
            for (;;)
            {
              i += 1;
              break;
              paramMsg.isread = true;
              paramMsg.issend = 2;
              this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramMsg.frienduin, 1026, paramMsg.shmsgseq);
              ((ArrayList)localObject2).add(paramMsg);
            }
          }
          bool = alsh.a((ArrayList)localObject2);
          i = abot.a((List)localObject2, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
          paramMsg = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a();
          if (!bool) {
            break label785;
          }
        }
      }
    }
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.isBackground_Pause) {}
    label785:
    for (boolean bool = true;; bool = false)
    {
      paramMsg.a((ArrayList)localObject2, String.valueOf(l4), bool);
      if ((localObject2 != null) && (((ArrayList)localObject2).size() > 0))
      {
        aupu.a((ayvi)localObject1, l1, paramString, 1);
        ((ayvi)localObject1).a(1, paramString, l1, 2);
      }
      if (j == 127) {
        break;
      }
      a("handleMsgPush_PB_Group", true, i, false, false);
      this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler.b((ArrayList)localObject2);
      return;
    }
  }
  
  protected void a(boolean paramBoolean, String paramString1, ArrayList<msg_comm.Msg> paramArrayList, String paramString2, long paramLong)
  {
    if (paramArrayList != null)
    {
      paramString2 = Integer.valueOf(paramArrayList.size());
      ausq.a("HCTopicMsgProc", "processGetMsgs", new Object[] { Boolean.valueOf(paramBoolean), paramString1, paramString2 });
      if (paramArrayList == null) {
        break label599;
      }
    }
    label599:
    for (paramArrayList = a(paramArrayList, paramString1);; paramArrayList = null)
    {
      int j = 0;
      long l2 = -9223372036854775808L;
      long l1 = 9223372036854775807L;
      String str = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c();
      ayvi localayvi = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a();
      int i;
      if ((paramArrayList != null) && (paramArrayList.size() > 0))
      {
        Collections.sort(paramArrayList, this.b);
        paramString2 = new ArrayList();
        i = paramArrayList.size() - 1;
        label122:
        Object localObject;
        long l3;
        if (i >= 0)
        {
          localObject = (MessageRecord)paramArrayList.get(i);
          l3 = l2;
          if (l2 < ((MessageRecord)localObject).shmsgseq) {
            l3 = ((MessageRecord)localObject).shmsgseq;
          }
          l2 = l1;
          if (l1 > ((MessageRecord)localObject).shmsgseq) {
            l2 = ((MessageRecord)localObject).shmsgseq;
          }
          if ((((MessageRecord)localObject).senderuin != null) && (((MessageRecord)localObject).senderuin.equalsIgnoreCase(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin())) && (a((MessageRecord)localObject))) {}
          for (;;)
          {
            i -= 1;
            l1 = l2;
            l2 = l3;
            break label122;
            paramString2 = "null";
            break;
            paramString2.add(0, localObject);
          }
        }
        if (paramString2.size() > 0)
        {
          l3 = localayvi.a(2, paramString1);
          paramArrayList = (abnw)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(1026);
          localObject = paramString2.iterator();
          while (((Iterator)localObject).hasNext())
          {
            MessageRecord localMessageRecord = (MessageRecord)((Iterator)localObject).next();
            if (localMessageRecord != null)
            {
              if ((localMessageRecord.senderuin != null) && (localMessageRecord.senderuin.equalsIgnoreCase(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin())))
              {
                localMessageRecord.isread = true;
                localMessageRecord.issend = 2;
              }
              if (l3 >= localMessageRecord.shmsgseq) {
                localMessageRecord.isread = true;
              }
            }
          }
          paramBoolean = alsh.a(paramString2);
          j = abot.a(paramString2, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
          localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a();
          if ((paramBoolean) && (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.isBackground_Pause))
          {
            paramBoolean = true;
            ((QQMessageFacade)localObject).a(paramString2, str, paramBoolean, false);
            paramArrayList.b(paramString1, 1026, l3);
            paramArrayList.a(paramString1, paramString2);
            if (l2 != -9223372036854775808L) {
              aupu.a(localayvi, l2, paramString1, 3);
            }
            if (l1 != 9223372036854775807L)
            {
              localayvi.a(1, paramString1, l1, 2);
              if (paramLong == 0L) {
                localayvi.a(3, paramString1, l1, 1);
              }
            }
            i = 0;
            label506:
            paramArrayList = paramString2;
          }
        }
      }
      for (;;)
      {
        if ((i != 0) && (localayvi.a(paramString1) == 1))
        {
          paramLong = localayvi.a(2, paramString1);
          ((abnw)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(1026)).b(paramString1, 1026, paramLong);
        }
        a("processGetMsgs", true, j, false, false);
        this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler.b(paramArrayList);
        return;
        paramBoolean = false;
        break;
        i = 1;
        j = 0;
        break label506;
        i = 1;
      }
    }
  }
  
  protected boolean a(MessageRecord paramMessageRecord)
  {
    boolean bool = false;
    MessageRecord localMessageRecord = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramMessageRecord.frienduin, 1026, paramMessageRecord);
    if (localMessageRecord != null)
    {
      if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().b(localMessageRecord)) {
        a(localMessageRecord);
      }
      if (!this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().d()) {
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(localMessageRecord.frienduin, localMessageRecord.istroop, localMessageRecord.uniseq);
      }
      this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler.a(paramMessageRecord.frienduin, 1026, localMessageRecord.uniseq, paramMessageRecord.shmsgseq, paramMessageRecord.time);
      aupu.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(), paramMessageRecord.shmsgseq, paramMessageRecord.frienduin, 2);
      bool = true;
    }
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     amgg
 * JD-Core Version:    0.7.0.1
 */