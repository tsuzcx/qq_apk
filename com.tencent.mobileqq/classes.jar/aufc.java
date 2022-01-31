import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.MessageHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.proxy.ProxyManager;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForLongMsg;
import com.tencent.mobileqq.data.MessageForMixedMsg;
import com.tencent.mobileqq.data.MessageForPic;
import com.tencent.mobileqq.data.MessageForReplyText;
import com.tencent.mobileqq.data.MessageForReplyText.SourceMsgInfo;
import com.tencent.mobileqq.data.MessageForRichText;
import com.tencent.mobileqq.data.MessageForText;
import com.tencent.mobileqq.data.MessageForText.AtTroopMemberInfo;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.PicMessageExtraData;
import com.tencent.mobileqq.mixedmsg.MixedMsgManager.1;
import com.tencent.mobileqq.mqsafeedit.MD5;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import mqq.manager.Manager;
import tencent.im.msg.im_msg_body.RichText;

public class aufc
  implements Manager
{
  private static final String jdField_a_of_type_JavaLangString = alof.aX + "fight/pic_expire.png";
  private long jdField_a_of_type_Long;
  public QQAppInterface a;
  public ConcurrentHashMap<Long, ChatMessage> a;
  
  public aufc(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
  }
  
  /* Error */
  protected static final MessageForMixedMsg a(QQAppInterface paramQQAppInterface, String paramString1, int paramInt, ArrayList<String> paramArrayList, String paramString2, ArrayList<MessageForText.AtTroopMemberInfo> paramArrayList1, MessageForReplyText.SourceMsgInfo paramSourceMsgInfo)
  {
    // Byte code:
    //   0: aload_3
    //   1: ifnull +10 -> 11
    //   4: aload_3
    //   5: invokevirtual 60	java/util/ArrayList:isEmpty	()Z
    //   8: ifeq +7 -> 15
    //   11: aconst_null
    //   12: astore_0
    //   13: aload_0
    //   14: areturn
    //   15: new 56	java/util/ArrayList
    //   18: dup
    //   19: invokespecial 61	java/util/ArrayList:<init>	()V
    //   22: astore 10
    //   24: iconst_0
    //   25: istore 7
    //   27: aload 6
    //   29: ifnull +130 -> 159
    //   32: aload_0
    //   33: aload_1
    //   34: iload_2
    //   35: aload 6
    //   37: aload 4
    //   39: invokestatic 66	azaf:a	(Lcom/tencent/mobileqq/app/QQAppInterface;Ljava/lang/String;ILcom/tencent/mobileqq/data/MessageForReplyText$SourceMsgInfo;Ljava/lang/String;)Lcom/tencent/mobileqq/data/MessageForReplyText;
    //   42: astore 4
    //   44: aload 4
    //   46: aload 5
    //   48: putfield 72	com/tencent/mobileqq/data/MessageForReplyText:atInfoList	Ljava/util/ArrayList;
    //   51: aload 10
    //   53: aload 4
    //   55: invokeinterface 78 2 0
    //   60: pop
    //   61: aload_3
    //   62: invokevirtual 82	java/util/ArrayList:size	()I
    //   65: istore 9
    //   67: iconst_0
    //   68: istore 8
    //   70: iload 8
    //   72: iload 9
    //   74: if_icmpge +206 -> 280
    //   77: aload_3
    //   78: iload 8
    //   80: invokevirtual 86	java/util/ArrayList:get	(I)Ljava/lang/Object;
    //   83: checkcast 88	java/lang/String
    //   86: astore 4
    //   88: aload 4
    //   90: invokestatic 93	arso:a	(Ljava/lang/String;)Z
    //   93: ifeq +57 -> 150
    //   96: aload_0
    //   97: aload 4
    //   99: aconst_null
    //   100: aload_1
    //   101: iload_2
    //   102: invokestatic 96	aufc:a	(Lcom/tencent/mobileqq/app/QQAppInterface;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;I)Lcom/tencent/mobileqq/data/MessageForPic;
    //   105: astore 4
    //   107: aload 4
    //   109: ifnull +41 -> 150
    //   112: new 98	com/tencent/mobileqq/mixedmsg/MixedMsgManager$5
    //   115: dup
    //   116: aload 4
    //   118: invokespecial 101	com/tencent/mobileqq/mixedmsg/MixedMsgManager$5:<init>	(Lcom/tencent/mobileqq/data/MessageForPic;)V
    //   121: bipush 8
    //   123: aconst_null
    //   124: iconst_1
    //   125: invokestatic 107	com/tencent/mobileqq/app/ThreadManager:post	(Ljava/lang/Runnable;ILcom/tencent/mobileqq/app/ThreadExcutor$IThreadListener;Z)V
    //   128: aload 4
    //   130: aload 10
    //   132: invokeinterface 108 1 0
    //   137: putfield 114	com/tencent/mobileqq/data/MessageForPic:subMsgId	I
    //   140: aload 10
    //   142: aload 4
    //   144: invokeinterface 78 2 0
    //   149: pop
    //   150: iload 8
    //   152: iconst_1
    //   153: iadd
    //   154: istore 8
    //   156: goto -86 -> 70
    //   159: aload 4
    //   161: invokestatic 119	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   164: ifne -103 -> 61
    //   167: aload_0
    //   168: aload_0
    //   169: invokevirtual 124	com/tencent/mobileqq/app/QQAppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   172: aload_1
    //   173: aload_1
    //   174: iload_2
    //   175: iconst_1
    //   176: iconst_0
    //   177: iconst_0
    //   178: aload 4
    //   180: invokestatic 127	azaf:a	(Lcom/tencent/mobileqq/app/QQAppInterface;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IBBSLjava/lang/String;)Lcom/tencent/mobileqq/data/MessageForText;
    //   183: astore 4
    //   185: aload 4
    //   187: aload 5
    //   189: putfield 130	com/tencent/mobileqq/data/MessageForText:atInfoList	Ljava/util/ArrayList;
    //   192: aload 4
    //   194: getfield 130	com/tencent/mobileqq/data/MessageForText:atInfoList	Ljava/util/ArrayList;
    //   197: ifnull +442 -> 639
    //   200: aload 4
    //   202: getfield 130	com/tencent/mobileqq/data/MessageForText:atInfoList	Ljava/util/ArrayList;
    //   205: invokevirtual 60	java/util/ArrayList:isEmpty	()Z
    //   208: ifne +431 -> 639
    //   211: aload_0
    //   212: sipush 203
    //   215: invokevirtual 134	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   218: checkcast 136	bcpg
    //   221: astore 11
    //   223: aload 4
    //   225: getfield 130	com/tencent/mobileqq/data/MessageForText:atInfoList	Ljava/util/ArrayList;
    //   228: invokevirtual 140	java/util/ArrayList:iterator	()Ljava/util/Iterator;
    //   231: astore 12
    //   233: aload 12
    //   235: invokeinterface 145 1 0
    //   240: ifeq +399 -> 639
    //   243: aload 11
    //   245: aload 12
    //   247: invokeinterface 149 1 0
    //   252: checkcast 151	com/tencent/mobileqq/data/MessageForText$AtTroopMemberInfo
    //   255: getfield 154	com/tencent/mobileqq/data/MessageForText$AtTroopMemberInfo:uin	J
    //   258: invokevirtual 157	bcpg:a	(J)Z
    //   261: ifeq -28 -> 233
    //   264: iconst_1
    //   265: istore 7
    //   267: aload 10
    //   269: aload 4
    //   271: invokeinterface 78 2 0
    //   276: pop
    //   277: goto -216 -> 61
    //   280: aload 10
    //   282: invokeinterface 158 1 0
    //   287: ifeq +5 -> 292
    //   290: aconst_null
    //   291: areturn
    //   292: aload 10
    //   294: iconst_0
    //   295: invokeinterface 159 2 0
    //   300: checkcast 161	com/tencent/mobileqq/data/MessageRecord
    //   303: astore_0
    //   304: aload_0
    //   305: iconst_0
    //   306: putfield 164	com/tencent/mobileqq/data/MessageRecord:longMsgId	I
    //   309: sipush -1035
    //   312: invokestatic 167	azaf:a	(I)Lcom/tencent/mobileqq/data/MessageRecord;
    //   315: checkcast 169	com/tencent/mobileqq/data/MessageForMixedMsg
    //   318: astore_1
    //   319: aload_1
    //   320: aload_0
    //   321: invokestatic 173	com/tencent/mobileqq/data/MessageRecord:copyMessageRecordBaseField	(Lcom/tencent/mobileqq/data/MessageRecord;Lcom/tencent/mobileqq/data/MessageRecord;)V
    //   324: aload_1
    //   325: getfield 176	com/tencent/mobileqq/data/MessageForMixedMsg:istroop	I
    //   328: iconst_1
    //   329: if_icmpne +10 -> 339
    //   332: invokestatic 181	nav:a	()Lnav;
    //   335: aload_1
    //   336: invokevirtual 185	nav:b	(Lcom/tencent/mobileqq/data/MessageRecord;)V
    //   339: aload 6
    //   341: ifnull +98 -> 439
    //   344: aload 5
    //   346: ifnull +93 -> 439
    //   349: aload 5
    //   351: invokevirtual 82	java/util/ArrayList:size	()I
    //   354: ifle +85 -> 439
    //   357: new 187	org/json/JSONObject
    //   360: dup
    //   361: invokespecial 188	org/json/JSONObject:<init>	()V
    //   364: astore_0
    //   365: new 190	org/json/JSONArray
    //   368: dup
    //   369: invokespecial 191	org/json/JSONArray:<init>	()V
    //   372: astore_3
    //   373: aload 5
    //   375: invokevirtual 140	java/util/ArrayList:iterator	()Ljava/util/Iterator;
    //   378: astore 4
    //   380: iconst_0
    //   381: istore 8
    //   383: aload 4
    //   385: invokeinterface 145 1 0
    //   390: ifeq +32 -> 422
    //   393: aload_3
    //   394: iload 8
    //   396: aload 4
    //   398: invokeinterface 149 1 0
    //   403: checkcast 151	com/tencent/mobileqq/data/MessageForText$AtTroopMemberInfo
    //   406: invokevirtual 195	com/tencent/mobileqq/data/MessageForText$AtTroopMemberInfo:toJsonObject	()Lorg/json/JSONObject;
    //   409: invokevirtual 199	org/json/JSONArray:put	(ILjava/lang/Object;)Lorg/json/JSONArray;
    //   412: pop
    //   413: iload 8
    //   415: iconst_1
    //   416: iadd
    //   417: istore 8
    //   419: goto -36 -> 383
    //   422: aload_0
    //   423: ldc 201
    //   425: aload_3
    //   426: invokevirtual 204	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   429: pop
    //   430: iload_2
    //   431: aload_0
    //   432: invokevirtual 205	org/json/JSONObject:toString	()Ljava/lang/String;
    //   435: aload_1
    //   436: invokestatic 210	bciq:a	(ILjava/lang/String;Lcom/tencent/mobileqq/data/ChatMessage;)V
    //   439: aload_1
    //   440: sipush -1035
    //   443: putfield 213	com/tencent/mobileqq/data/MessageForMixedMsg:msgtype	I
    //   446: aload_1
    //   447: iconst_1
    //   448: putfield 216	com/tencent/mobileqq/data/MessageForMixedMsg:issend	I
    //   451: aload_1
    //   452: ldc 217
    //   454: putfield 220	com/tencent/mobileqq/data/MessageForMixedMsg:extraflag	I
    //   457: aload_1
    //   458: invokestatic 226	java/lang/System:currentTimeMillis	()J
    //   461: invokestatic 232	java/lang/Math:random	()D
    //   464: ldc2_w 233
    //   467: dmul
    //   468: d2l
    //   469: ladd
    //   470: putfield 237	com/tencent/mobileqq/data/MessageForMixedMsg:uniseq	J
    //   473: aload_1
    //   474: aload 10
    //   476: putfield 241	com/tencent/mobileqq/data/MessageForMixedMsg:msgElemList	Ljava/util/List;
    //   479: iload 7
    //   481: ifeq +119 -> 600
    //   484: iconst_1
    //   485: istore 7
    //   487: aload_1
    //   488: iload 7
    //   490: putfield 244	com/tencent/mobileqq/data/MessageForMixedMsg:mRobotFlag	I
    //   493: aload_1
    //   494: aload 5
    //   496: putfield 245	com/tencent/mobileqq/data/MessageForMixedMsg:atInfoList	Ljava/util/ArrayList;
    //   499: aload_1
    //   500: invokevirtual 248	com/tencent/mobileqq/data/MessageForMixedMsg:prewrite	()V
    //   503: aload_1
    //   504: astore_0
    //   505: aload 5
    //   507: ifnull -494 -> 13
    //   510: aload_1
    //   511: astore_0
    //   512: aload 5
    //   514: invokevirtual 82	java/util/ArrayList:size	()I
    //   517: ifle -504 -> 13
    //   520: new 187	org/json/JSONObject
    //   523: dup
    //   524: invokespecial 188	org/json/JSONObject:<init>	()V
    //   527: astore_0
    //   528: new 190	org/json/JSONArray
    //   531: dup
    //   532: invokespecial 191	org/json/JSONArray:<init>	()V
    //   535: astore_3
    //   536: aload 5
    //   538: invokevirtual 140	java/util/ArrayList:iterator	()Ljava/util/Iterator;
    //   541: astore 4
    //   543: iconst_0
    //   544: istore 7
    //   546: aload 4
    //   548: invokeinterface 145 1 0
    //   553: ifeq +53 -> 606
    //   556: aload_3
    //   557: iload 7
    //   559: aload 4
    //   561: invokeinterface 149 1 0
    //   566: checkcast 151	com/tencent/mobileqq/data/MessageForText$AtTroopMemberInfo
    //   569: invokevirtual 195	com/tencent/mobileqq/data/MessageForText$AtTroopMemberInfo:toJsonObject	()Lorg/json/JSONObject;
    //   572: invokevirtual 199	org/json/JSONArray:put	(ILjava/lang/Object;)Lorg/json/JSONArray;
    //   575: pop
    //   576: iload 7
    //   578: iconst_1
    //   579: iadd
    //   580: istore 7
    //   582: goto -36 -> 546
    //   585: astore_3
    //   586: ldc 250
    //   588: iconst_1
    //   589: aload_3
    //   590: iconst_0
    //   591: anewarray 4	java/lang/Object
    //   594: invokestatic 256	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/Throwable;[Ljava/lang/Object;)V
    //   597: goto -167 -> 430
    //   600: iconst_m1
    //   601: istore 7
    //   603: goto -116 -> 487
    //   606: aload_0
    //   607: ldc 201
    //   609: aload_3
    //   610: invokevirtual 204	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   613: pop
    //   614: iload_2
    //   615: aload_0
    //   616: invokevirtual 205	org/json/JSONObject:toString	()Ljava/lang/String;
    //   619: aload_1
    //   620: invokestatic 210	bciq:a	(ILjava/lang/String;Lcom/tencent/mobileqq/data/ChatMessage;)V
    //   623: aload_1
    //   624: areturn
    //   625: astore_0
    //   626: ldc 250
    //   628: iconst_1
    //   629: aload_0
    //   630: iconst_0
    //   631: anewarray 4	java/lang/Object
    //   634: invokestatic 256	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/Throwable;[Ljava/lang/Object;)V
    //   637: aload_1
    //   638: areturn
    //   639: iconst_0
    //   640: istore 7
    //   642: goto -375 -> 267
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	645	0	paramQQAppInterface	QQAppInterface
    //   0	645	1	paramString1	String
    //   0	645	2	paramInt	int
    //   0	645	3	paramArrayList	ArrayList<String>
    //   0	645	4	paramString2	String
    //   0	645	5	paramArrayList1	ArrayList<MessageForText.AtTroopMemberInfo>
    //   0	645	6	paramSourceMsgInfo	MessageForReplyText.SourceMsgInfo
    //   25	616	7	i	int
    //   68	350	8	j	int
    //   65	10	9	k	int
    //   22	453	10	localArrayList	ArrayList
    //   221	23	11	localbcpg	bcpg
    //   231	15	12	localIterator	java.util.Iterator
    // Exception table:
    //   from	to	target	type
    //   373	380	585	org/json/JSONException
    //   383	413	585	org/json/JSONException
    //   422	430	585	org/json/JSONException
    //   520	543	625	java/lang/Exception
    //   546	576	625	java/lang/Exception
    //   606	623	625	java/lang/Exception
  }
  
  protected static final MessageForPic a(QQAppInterface paramQQAppInterface, String paramString1, String paramString2, String paramString3, int paramInt)
  {
    if (paramString1 != null)
    {
      paramString2 = azaf.a(paramQQAppInterface, paramString3, paramString2, paramInt);
      paramString2.path = paramString1;
      paramString2.size = 0L;
      paramString2.uniseq = (System.currentTimeMillis() + (Math.random() * 10000.0D));
      paramString2.type = 1;
      paramString2.isRead = true;
      paramString2.localUUID = awjl.a();
      paramString2.md5 = bdhe.a(MD5.getFileMd5(paramString2.path));
      if (awkr.a(paramString1))
      {
        paramString1 = new PicMessageExtraData();
        paramString1.textSummary = paramQQAppInterface.getApp().getString(2131691343);
        paramString2.picExtraData = paramString1;
      }
      paramString2.serial();
      return paramString2;
    }
    return null;
  }
  
  protected static final void a(QQAppInterface paramQQAppInterface, MessageForPic paramMessageForPic, boolean paramBoolean, awkh paramawkh)
  {
    bayk localbayk = new bayk();
    localbayk.jdField_b_of_type_JavaLangString = paramMessageForPic.selfuin;
    localbayk.c = paramMessageForPic.frienduin;
    localbayk.jdField_a_of_type_Int = paramMessageForPic.istroop;
    localbayk.jdField_b_of_type_Int = 1;
    localbayk.jdField_a_of_type_Long = (paramMessageForPic.uniseq + paramMessageForPic.subMsgId);
    for (Object localObject = localbayk.c + localbayk.jdField_a_of_type_Long; paramQQAppInterface.a().jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.containsKey(localObject); localObject = localbayk.c + localbayk.jdField_a_of_type_Long) {
      localbayk.jdField_a_of_type_Long += 100L;
    }
    localbayk.jdField_a_of_type_Boolean = true;
    localbayk.jdField_e_of_type_Boolean = false;
    localObject = new bayo();
    ((bayo)localObject).jdField_a_of_type_Boolean = paramBoolean;
    localbayk.jdField_a_of_type_JavaLangObject = localObject;
    localbayk.i = paramMessageForPic.path;
    localbayk.jdField_a_of_type_Awkh = paramawkh;
    localbayk.jdField_a_of_type_ComTencentMobileqqDataMessageRecord = paramMessageForPic;
    paramQQAppInterface.a().a(localbayk);
  }
  
  private void a(QQAppInterface paramQQAppInterface, String paramString, int paramInt, MessageForMixedMsg paramMessageForMixedMsg, boolean paramBoolean)
  {
    im_msg_body.RichText localRichText = new im_msg_body.RichText();
    int m = paramMessageForMixedMsg.msgElemList.size();
    int j = 0;
    int i = 0;
    Object localObject;
    if (j < m)
    {
      localObject = (MessageRecord)paramMessageForMixedMsg.msgElemList.get(j);
      if ((localObject instanceof MessageForText))
      {
        localObject = azad.a((MessageForText)localObject);
        if (localObject != null) {}
      }
    }
    for (;;)
    {
      j += 1;
      break;
      int k = 0;
      while (k < ((im_msg_body.RichText)localObject).elems.size())
      {
        localRichText.elems.add(((im_msg_body.RichText)localObject).elems.get(k));
        k += 1;
      }
      continue;
      if ((localObject instanceof MessageForRichText))
      {
        localObject = ((MessageForPic)localObject).richText;
        if (localObject != null)
        {
          localRichText.elems.add(((im_msg_body.RichText)localObject).elems.get(0));
          i += 1;
        }
      }
      else if ((localObject instanceof MessageForReplyText))
      {
        localObject = azad.a((MessageForReplyText)localObject);
        if (localObject != null)
        {
          k = 0;
          while (k < ((im_msg_body.RichText)localObject).elems.size())
          {
            localRichText.elems.add(((im_msg_body.RichText)localObject).elems.get(k));
            k += 1;
            continue;
            i = localRichText.toByteArray().length;
            if (QLog.isColorLevel()) {
              QLog.d("MixedMsgManager", 2, "packAndSendMsg, richTextLength : " + i);
            }
            paramMessageForMixedMsg.mRichTextLength = i;
            a(paramString, paramInt, paramMessageForMixedMsg, paramQQAppInterface, false);
            if (QLog.isColorLevel()) {
              QLog.d("MixedMsgManager", 2, "packAndSendMsg,, send by longStruct message");
            }
            return;
          }
        }
      }
    }
  }
  
  private void a(QQAppInterface paramQQAppInterface, String paramString, int paramInt, ArrayList<awjf> paramArrayList, MessageForMixedMsg paramMessageForMixedMsg)
  {
    awjl localawjl = awjb.a(8, 7);
    localawjl.a(paramArrayList);
    localawjl.a(new aufd(this, paramMessageForMixedMsg, paramQQAppInterface, paramString, paramInt));
    awjb.a(localawjl, paramQQAppInterface);
  }
  
  private void a(MessageForMixedMsg paramMessageForMixedMsg, boolean paramBoolean)
  {
    if ((paramMessageForMixedMsg.istroop != 3000) && (paramMessageForMixedMsg.istroop != 1)) {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramMessageForMixedMsg.frienduin, paramMessageForMixedMsg.istroop, paramMessageForMixedMsg.uniseq, 32770, paramMessageForMixedMsg.sendFailCode);
    }
    b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramMessageForMixedMsg);
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.remove(paramMessageForMixedMsg);
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.remove(Long.valueOf(paramMessageForMixedMsg.mForwardFromUniSeq));
    a(true, paramBoolean, paramMessageForMixedMsg, null);
  }
  
  private void a(MessageForMixedMsg paramMessageForMixedMsg, boolean paramBoolean, String paramString)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramMessageForMixedMsg.frienduin, paramMessageForMixedMsg.istroop, paramMessageForMixedMsg.uniseq, 32768, paramMessageForMixedMsg.sendFailCode);
    a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramMessageForMixedMsg);
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.remove(Long.valueOf(paramMessageForMixedMsg.mForwardFromUniSeq));
    axwx.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramMessageForMixedMsg.frienduin, paramMessageForMixedMsg.uniseq);
    a(false, paramBoolean, paramMessageForMixedMsg, paramString);
  }
  
  private void a(boolean paramBoolean1, boolean paramBoolean2, MessageForMixedMsg paramMessageForMixedMsg, String paramString)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("param_isresend", String.valueOf(paramMessageForMixedMsg.mIsResend));
    if (!paramMessageForMixedMsg.mIsResend)
    {
      localHashMap.put("param_forwardFromUin", paramMessageForMixedMsg.mForwardFromUin);
      localHashMap.put("param_forwardFromUinType", String.valueOf(paramMessageForMixedMsg.mForwardFromIsTroop));
    }
    localHashMap.put("param_senderUin", paramMessageForMixedMsg.senderuin);
    localHashMap.put("param_toUin", paramMessageForMixedMsg.frienduin);
    localHashMap.put("param_toUinType", String.valueOf(paramMessageForMixedMsg.istroop));
    localHashMap.put("param_sendByLongStruct", String.valueOf(paramBoolean2));
    localHashMap.put("param_richTextLength", String.valueOf(paramMessageForMixedMsg.mRichTextLength));
    if (paramString != null) {
      localHashMap.put("param_errDesc", paramString);
    }
    azri.a(BaseApplication.getContext()).a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), "MixedMsgForward", paramBoolean1, 0L, 0L, localHashMap, "");
  }
  
  private boolean a(QQAppInterface paramQQAppInterface, byte[] paramArrayOfByte, String paramString1, String paramString2, String paramString3, int paramInt1, long paramLong, int paramInt2, awkh paramawkh)
  {
    if (QLog.isColorLevel()) {
      QLog.d("MixedMsgManager", 2, "[sendLongTextMsg]data.length = " + paramArrayOfByte.length);
    }
    bayk localbayk = new bayk();
    localbayk.jdField_a_of_type_Boolean = true;
    localbayk.jdField_b_of_type_Int = 131078;
    localbayk.h = 1;
    localbayk.jdField_b_of_type_ArrayOfByte = paramArrayOfByte;
    localbayk.jdField_b_of_type_JavaLangString = paramString1;
    localbayk.c = paramString2;
    localbayk.d = paramString3;
    localbayk.jdField_a_of_type_Int = paramInt1;
    localbayk.jdField_a_of_type_Long = paramLong;
    localbayk.jdField_e_of_type_Int = paramInt2;
    localbayk.jdField_a_of_type_Awkh = paramawkh;
    paramQQAppInterface.a().a(localbayk);
    return true;
  }
  
  public void a(SessionInfo paramSessionInfo, long paramLong, int paramInt)
  {
    Object localObject = (ChatMessage)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(Long.valueOf(paramLong));
    if (localObject != null) {
      if (((ChatMessage)localObject).msgtype == -1036)
      {
        localObject = (MessageForMixedMsg)((MessageForLongMsg)localObject).rebuildLongMsg();
        ((MessageForMixedMsg)localObject).mForwardFromUniSeq = paramLong;
        ((MessageForMixedMsg)localObject).forwardID = paramInt;
        axnf.a().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (MessageForMixedMsg)localObject, paramSessionInfo, paramInt);
      }
    }
    while (!QLog.isColorLevel()) {
      for (;;)
      {
        return;
        localObject = (MessageForMixedMsg)localObject;
      }
    }
    QLog.e("MixedMsgManager", 2, "forwardMixedMsg, not find in cache !");
  }
  
  public void a(SessionInfo paramSessionInfo, MessageForMixedMsg paramMessageForMixedMsg, boolean paramBoolean)
  {
    a(paramSessionInfo, paramMessageForMixedMsg, paramBoolean, 0);
  }
  
  public void a(SessionInfo paramSessionInfo, MessageForMixedMsg paramMessageForMixedMsg, boolean paramBoolean, int paramInt)
  {
    paramSessionInfo = new MixedMsgManager.1(this, paramSessionInfo, paramInt, paramMessageForMixedMsg, paramBoolean);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(paramSessionInfo);
  }
  
  protected void a(QQAppInterface paramQQAppInterface, MessageRecord paramMessageRecord)
  {
    paramMessageRecord.extraflag = 32768;
    paramQQAppInterface.a().a(paramMessageRecord.frienduin, paramMessageRecord.istroop, paramMessageRecord.uniseq);
    String str = paramMessageRecord.frienduin;
    int i = paramMessageRecord.istroop;
    long l = paramMessageRecord.uniseq;
    paramQQAppInterface.a().notifyUI(1000, false, new Object[] { str, Integer.valueOf(i), Integer.valueOf(-1), null, Long.valueOf(0L), Long.valueOf(l) });
  }
  
  public void a(QQAppInterface paramQQAppInterface, String paramString1, int paramInt, ArrayList<String> paramArrayList, boolean paramBoolean, String paramString2, ArrayList<MessageForText.AtTroopMemberInfo> paramArrayList1, MessageForReplyText.SourceMsgInfo paramSourceMsgInfo)
  {
    if (paramQQAppInterface == null) {}
    for (;;)
    {
      return;
      paramArrayList = a(paramQQAppInterface, paramString1, paramInt, paramArrayList, paramString2, paramArrayList1, paramSourceMsgInfo);
      if (paramArrayList != null)
      {
        paramString2 = new ArrayList(paramArrayList.msgElemList);
        paramSourceMsgInfo = (axwx)paramQQAppInterface.getManager(326);
        paramSourceMsgInfo.a(paramString1, paramArrayList.uniseq);
        paramSourceMsgInfo.a(paramArrayList, null);
        paramQQAppInterface.a().f(paramString1, paramInt);
        paramString1 = Collections.synchronizedMap(new HashMap());
        int i = paramString2.size();
        paramInt = 0;
        while (paramInt < i)
        {
          paramSourceMsgInfo = (MessageRecord)paramString2.get(paramInt);
          if ((paramSourceMsgInfo instanceof MessageForPic))
          {
            paramSourceMsgInfo = (MessageForPic)paramSourceMsgInfo;
            String str = paramSourceMsgInfo.path;
            if (arso.a(str))
            {
              paramString1.put(str, Integer.valueOf(paramSourceMsgInfo.subMsgId));
              a(paramQQAppInterface, paramSourceMsgInfo, paramBoolean, new aufg(this, paramArrayList, paramString1, str, paramArrayList1));
            }
          }
          paramInt += 1;
        }
      }
    }
  }
  
  public void a(MessageRecord paramMessageRecord)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("param_istroop", String.valueOf(paramMessageRecord.istroop));
    localHashMap.put("param_issend", String.valueOf(paramMessageRecord.issend));
    localHashMap.put("param_msgtype", String.valueOf(paramMessageRecord.msgtype));
    localHashMap.put("param_isAnonymous", String.valueOf(nav.a(paramMessageRecord)));
    azri.a(BaseApplication.getContext()).a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), "MixedMsgReceived", true, 0L, 0L, localHashMap, "");
  }
  
  public void a(String paramString, int paramInt, MessageForMixedMsg paramMessageForMixedMsg, QQAppInterface paramQQAppInterface, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("MixedMsgManager", 2, " sendStructLongMsg start");
    }
    if ((paramMessageForMixedMsg instanceof ChatMessage)) {
      paramMessageForMixedMsg.mPendantAnimatable = true;
    }
    if (QLog.isColorLevel()) {
      QLog.d("MixedMsgManager", 2, "step2: sendStructLongMsg saveMessage end and pack StructLongMsg start currenttime:" + System.currentTimeMillis());
    }
    byte[] arrayOfByte = paramQQAppInterface.a().a().a(paramMessageForMixedMsg);
    if (arrayOfByte == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("MixedMsgManager", 2, "step2: sendStructLongMsg pack failed! packData is null.............................");
      }
      a(paramMessageForMixedMsg, true, "sendStructLongMsg pack fail : packData is null");
    }
    do
    {
      do
      {
        return;
        this.jdField_a_of_type_Long = System.currentTimeMillis();
        paramString = new aufe(this, paramQQAppInterface, paramMessageForMixedMsg, paramString, paramInt);
        paramBoolean = a(paramQQAppInterface, arrayOfByte, paramQQAppInterface.getCurrentAccountUin(), paramMessageForMixedMsg.frienduin, paramMessageForMixedMsg.frienduin, paramMessageForMixedMsg.istroop, paramMessageForMixedMsg.uniseq, 1035, new auff(this, paramQQAppInterface, paramMessageForMixedMsg, paramString));
        if (!paramBoolean) {
          break;
        }
      } while (!QLog.isColorLevel());
      QLog.d("MixedMsgManager", 2, "sendLongTextMsg successful, uploadLongTextMsgPkg start!");
      return;
    } while (!QLog.isColorLevel());
    QLog.d("MixedMsgManager", 2, "sendLongTextMsg failed! isSuccess:" + paramBoolean);
  }
  
  public void a(boolean paramBoolean, int paramInt)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("param_uin", this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
    localHashMap.put("param_isTroop", String.valueOf(paramInt));
    if (paramBoolean)
    {
      azri.a(BaseApplication.getContext()).a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), "MixedMsgClientAutoPull", true, 0L, 0L, localHashMap, "");
      return;
    }
    azri.a(BaseApplication.getContext()).a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), "MixedMsgClientManualPull", true, 0L, 0L, localHashMap, "");
  }
  
  protected void b(QQAppInterface paramQQAppInterface, MessageRecord paramMessageRecord)
  {
    if ((paramMessageRecord.istroop != 3000) && (paramMessageRecord.istroop != 1)) {
      paramMessageRecord.extraflag = 32770;
    }
    String str = paramMessageRecord.frienduin;
    int i = paramMessageRecord.istroop;
    long l = paramMessageRecord.uniseq;
    paramQQAppInterface.a().notifyUI(1000, true, new Object[] { str, Integer.valueOf(i), Integer.valueOf(-1), null, Long.valueOf(0L), Long.valueOf(l) });
  }
  
  public void onDestroy() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aufc
 * JD-Core Version:    0.7.0.1
 */