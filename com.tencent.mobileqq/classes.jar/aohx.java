import android.content.SharedPreferences;
import android.os.Looper;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.StrangerHandler.1;
import com.tencent.mobileqq.app.proxy.ProxyManager;
import com.tencent.mobileqq.data.BaseRecentUser;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.List;
import tencent.im.oidb.cmd0x5d2.oidb_0x5d2.ReqBody;
import tencent.im.oidb.cmd0x5d2.oidb_0x5d2.ReqGetList;
import tencent.im.oidb.cmd0x5d4.oidb_0x5d4.DelResult;
import tencent.im.oidb.cmd0x5d4.oidb_0x5d4.ReqBody;
import tencent.im.oidb.cmd0x5d4.oidb_0x5d4.RspBody;
import tencent.im.oidb.oidb_sso.OIDBSSOPkg;

public class aohx
  extends anud
{
  aohx(QQAppInterface paramQQAppInterface)
  {
    super(paramQQAppInterface);
  }
  
  private static oidb_sso.OIDBSSOPkg a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if ((paramToServiceMsg == null) || (paramFromServiceMsg == null) || (paramFromServiceMsg.getResultCode() != 1000)) {
      paramToServiceMsg = null;
    }
    for (;;)
    {
      return paramToServiceMsg;
      paramFromServiceMsg = new oidb_sso.OIDBSSOPkg();
      try
      {
        paramFromServiceMsg.mergeFrom((byte[])paramObject);
        if ((paramFromServiceMsg != null) && (paramFromServiceMsg.uint32_result.get() == 0))
        {
          paramToServiceMsg = paramFromServiceMsg;
          if (paramFromServiceMsg.bytes_bodybuffer.get() != null) {
            continue;
          }
        }
        return null;
      }
      catch (InvalidProtocolBufferMicroException paramToServiceMsg)
      {
        for (;;)
        {
          if (QLog.isColorLevel()) {
            QLog.d("StrangerHandler", 2, "parseSSOPkg: oidb_sso parseFrom byte InvalidProtocolBufferMicroException ");
          }
        }
      }
    }
  }
  
  /* Error */
  private void b(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    // Byte code:
    //   0: aload_1
    //   1: aload_2
    //   2: aload_3
    //   3: invokestatic 66	aohx:a	(Lcom/tencent/qphone/base/remote/ToServiceMsg;Lcom/tencent/qphone/base/remote/FromServiceMsg;Ljava/lang/Object;)Ltencent/im/oidb/oidb_sso$OIDBSSOPkg;
    //   6: astore 6
    //   8: aload 6
    //   10: ifnonnull +25 -> 35
    //   13: invokestatic 54	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   16: ifeq +11 -> 27
    //   19: ldc 56
    //   21: iconst_2
    //   22: ldc 68
    //   24: invokestatic 62	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   27: aload_0
    //   28: iconst_2
    //   29: iconst_0
    //   30: aconst_null
    //   31: invokevirtual 72	aohx:notifyUI	(IZLjava/lang/Object;)V
    //   34: return
    //   35: new 74	tencent/im/oidb/cmd0x5d2/oidb_0x5d2$RspBody
    //   38: dup
    //   39: invokespecial 75	tencent/im/oidb/cmd0x5d2/oidb_0x5d2$RspBody:<init>	()V
    //   42: astore_2
    //   43: aconst_null
    //   44: astore_3
    //   45: aload_2
    //   46: aload 6
    //   48: getfield 43	tencent/im/oidb/oidb_sso$OIDBSSOPkg:bytes_bodybuffer	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   51: invokevirtual 48	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   54: invokevirtual 81	com/tencent/mobileqq/pb/ByteStringMicro:toByteArray	()[B
    //   57: invokevirtual 82	tencent/im/oidb/cmd0x5d2/oidb_0x5d2$RspBody:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   60: pop
    //   61: aload_1
    //   62: ldc 84
    //   64: invokevirtual 90	com/tencent/qphone/base/remote/ToServiceMsg:getAttribute	(Ljava/lang/String;)Ljava/lang/Object;
    //   67: checkcast 92	java/lang/Integer
    //   70: invokevirtual 95	java/lang/Integer:intValue	()I
    //   73: istore 4
    //   75: aload_2
    //   76: getfield 99	tencent/im/oidb/cmd0x5d2/oidb_0x5d2$RspBody:rsp_get_list	Ltencent/im/oidb/cmd0x5d2/oidb_0x5d2$RspGetList;
    //   79: getfield 104	tencent/im/oidb/cmd0x5d2/oidb_0x5d2$RspGetList:seq	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   82: invokevirtual 39	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   85: istore 5
    //   87: invokestatic 54	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   90: ifeq +39 -> 129
    //   93: ldc 56
    //   95: iconst_2
    //   96: new 106	java/lang/StringBuilder
    //   99: dup
    //   100: invokespecial 107	java/lang/StringBuilder:<init>	()V
    //   103: ldc 109
    //   105: invokevirtual 113	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   108: iload 4
    //   110: invokevirtual 116	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   113: ldc 118
    //   115: invokevirtual 113	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   118: iload 5
    //   120: invokevirtual 116	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   123: invokevirtual 122	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   126: invokestatic 62	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   129: iload 4
    //   131: iload 5
    //   133: if_icmpeq +474 -> 607
    //   136: aload_2
    //   137: getfield 99	tencent/im/oidb/cmd0x5d2/oidb_0x5d2$RspBody:rsp_get_list	Ltencent/im/oidb/cmd0x5d2/oidb_0x5d2$RspGetList;
    //   140: getfield 126	tencent/im/oidb/cmd0x5d2/oidb_0x5d2$RspGetList:list	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   143: invokevirtual 131	com/tencent/mobileqq/pb/PBRepeatMessageField:get	()Ljava/util/List;
    //   146: astore_1
    //   147: invokestatic 54	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   150: ifeq +53 -> 203
    //   153: ldc 56
    //   155: iconst_2
    //   156: new 106	java/lang/StringBuilder
    //   159: dup
    //   160: invokespecial 107	java/lang/StringBuilder:<init>	()V
    //   163: ldc 109
    //   165: invokevirtual 113	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   168: iload 4
    //   170: invokevirtual 116	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   173: ldc 118
    //   175: invokevirtual 113	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   178: iload 5
    //   180: invokevirtual 116	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   183: ldc 133
    //   185: invokevirtual 113	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   188: aload_1
    //   189: invokeinterface 138 1 0
    //   194: invokevirtual 116	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   197: invokevirtual 122	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   200: invokestatic 62	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   203: aload_0
    //   204: getfield 142	aohx:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   207: invokevirtual 147	com/tencent/mobileqq/app/QQAppInterface:a	()Lcom/tencent/mobileqq/data/QQEntityManagerFactory;
    //   210: invokevirtual 153	com/tencent/mobileqq/data/QQEntityManagerFactory:createEntityManager	()Lcom/tencent/mobileqq/persistence/EntityManager;
    //   213: astore_2
    //   214: aload_2
    //   215: ldc 155
    //   217: invokevirtual 161	com/tencent/mobileqq/persistence/EntityManager:query	(Ljava/lang/Class;)Ljava/util/List;
    //   220: astore 6
    //   222: aload 6
    //   224: ifnonnull +433 -> 657
    //   227: new 163	java/util/ArrayList
    //   230: dup
    //   231: invokespecial 164	java/util/ArrayList:<init>	()V
    //   234: astore 6
    //   236: aload_1
    //   237: invokeinterface 168 1 0
    //   242: astore 8
    //   244: aconst_null
    //   245: astore_1
    //   246: aload 8
    //   248: invokeinterface 173 1 0
    //   253: ifeq +193 -> 446
    //   256: aload 8
    //   258: invokeinterface 177 1 0
    //   263: checkcast 179	tencent/im/oidb/cmd0x5d2/oidb_0x5d2$FriendList
    //   266: astore_3
    //   267: aload_3
    //   268: getfield 183	tencent/im/oidb/cmd0x5d2/oidb_0x5d2$FriendList:uin	Lcom/tencent/mobileqq/pb/PBUInt64Field;
    //   271: invokevirtual 188	com/tencent/mobileqq/pb/PBUInt64Field:get	()J
    //   274: invokestatic 194	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   277: astore 9
    //   279: aload_3
    //   280: getfield 197	tencent/im/oidb/cmd0x5d2/oidb_0x5d2$FriendList:nick	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   283: invokevirtual 48	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   286: invokevirtual 200	com/tencent/mobileqq/pb/ByteStringMicro:toStringUtf8	()Ljava/lang/String;
    //   289: astore 10
    //   291: aload_2
    //   292: ldc 155
    //   294: aload 9
    //   296: invokevirtual 204	com/tencent/mobileqq/persistence/EntityManager:find	(Ljava/lang/Class;Ljava/lang/String;)Lcom/tencent/mobileqq/persistence/Entity;
    //   299: checkcast 155	com/tencent/mobileqq/data/Stranger
    //   302: astore 7
    //   304: aload 7
    //   306: ifnonnull +62 -> 368
    //   309: new 155	com/tencent/mobileqq/data/Stranger
    //   312: dup
    //   313: invokespecial 205	com/tencent/mobileqq/data/Stranger:<init>	()V
    //   316: astore_3
    //   317: aload_3
    //   318: aload 9
    //   320: putfield 208	com/tencent/mobileqq/data/Stranger:uin	Ljava/lang/String;
    //   323: aload_3
    //   324: aload 10
    //   326: putfield 211	com/tencent/mobileqq/data/Stranger:name	Ljava/lang/String;
    //   329: aload_2
    //   330: aload_3
    //   331: invokevirtual 215	com/tencent/mobileqq/persistence/EntityManager:persist	(Lcom/tencent/mobileqq/persistence/Entity;)V
    //   334: invokestatic 54	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   337: ifeq +323 -> 660
    //   340: ldc 56
    //   342: iconst_2
    //   343: new 106	java/lang/StringBuilder
    //   346: dup
    //   347: invokespecial 107	java/lang/StringBuilder:<init>	()V
    //   350: ldc 217
    //   352: invokevirtual 113	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   355: aload_3
    //   356: invokevirtual 220	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   359: invokevirtual 122	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   362: invokestatic 62	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   365: goto +295 -> 660
    //   368: aload 7
    //   370: aload 10
    //   372: putfield 211	com/tencent/mobileqq/data/Stranger:name	Ljava/lang/String;
    //   375: aload_2
    //   376: aload 7
    //   378: invokevirtual 224	com/tencent/mobileqq/persistence/EntityManager:update	(Lcom/tencent/mobileqq/persistence/Entity;)Z
    //   381: pop
    //   382: aload 6
    //   384: invokeinterface 168 1 0
    //   389: astore 9
    //   391: aload_1
    //   392: astore_3
    //   393: aload 9
    //   395: invokeinterface 173 1 0
    //   400: ifeq +29 -> 429
    //   403: aload 9
    //   405: invokeinterface 177 1 0
    //   410: checkcast 155	com/tencent/mobileqq/data/Stranger
    //   413: astore_3
    //   414: aload_3
    //   415: getfield 208	com/tencent/mobileqq/data/Stranger:uin	Ljava/lang/String;
    //   418: aload 7
    //   420: getfield 208	com/tencent/mobileqq/data/Stranger:uin	Ljava/lang/String;
    //   423: invokestatic 230	android/text/TextUtils:equals	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Z
    //   426: ifeq -35 -> 391
    //   429: aload 6
    //   431: aload_3
    //   432: invokeinterface 234 2 0
    //   437: pop
    //   438: aload_3
    //   439: astore_1
    //   440: aload 7
    //   442: astore_3
    //   443: goto -109 -> 334
    //   446: aload 6
    //   448: invokeinterface 168 1 0
    //   453: astore_1
    //   454: aload_1
    //   455: invokeinterface 173 1 0
    //   460: ifeq +78 -> 538
    //   463: aload_1
    //   464: invokeinterface 177 1 0
    //   469: checkcast 155	com/tencent/mobileqq/data/Stranger
    //   472: astore_3
    //   473: invokestatic 54	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   476: ifeq +28 -> 504
    //   479: ldc 56
    //   481: iconst_2
    //   482: new 106	java/lang/StringBuilder
    //   485: dup
    //   486: invokespecial 107	java/lang/StringBuilder:<init>	()V
    //   489: ldc 236
    //   491: invokevirtual 113	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   494: aload_3
    //   495: invokevirtual 220	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   498: invokevirtual 122	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   501: invokestatic 62	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   504: aload_2
    //   505: aload_3
    //   506: invokevirtual 238	com/tencent/mobileqq/persistence/EntityManager:remove	(Lcom/tencent/mobileqq/persistence/Entity;)Z
    //   509: pop
    //   510: goto -56 -> 454
    //   513: astore_3
    //   514: aload_2
    //   515: astore_1
    //   516: aload_3
    //   517: astore_2
    //   518: aload_2
    //   519: invokevirtual 241	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException:printStackTrace	()V
    //   522: aload_1
    //   523: ifnull +7 -> 530
    //   526: aload_1
    //   527: invokevirtual 244	com/tencent/mobileqq/persistence/EntityManager:close	()V
    //   530: aload_0
    //   531: iconst_2
    //   532: iconst_0
    //   533: aconst_null
    //   534: invokevirtual 72	aohx:notifyUI	(IZLjava/lang/Object;)V
    //   537: return
    //   538: aload_0
    //   539: getfield 142	aohx:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   542: invokevirtual 248	com/tencent/mobileqq/app/QQAppInterface:getPreferences	()Landroid/content/SharedPreferences;
    //   545: invokeinterface 254 1 0
    //   550: astore_1
    //   551: aload_1
    //   552: ldc_w 256
    //   555: iload 5
    //   557: invokeinterface 262 3 0
    //   562: pop
    //   563: aload_1
    //   564: invokeinterface 265 1 0
    //   569: pop
    //   570: aload_2
    //   571: ldc 155
    //   573: invokevirtual 161	com/tencent/mobileqq/persistence/EntityManager:query	(Ljava/lang/Class;)Ljava/util/List;
    //   576: astore_3
    //   577: aload_3
    //   578: astore_1
    //   579: aload_3
    //   580: ifnonnull +11 -> 591
    //   583: new 163	java/util/ArrayList
    //   586: dup
    //   587: invokespecial 164	java/util/ArrayList:<init>	()V
    //   590: astore_1
    //   591: aload_0
    //   592: iconst_2
    //   593: iconst_1
    //   594: aload_1
    //   595: invokevirtual 72	aohx:notifyUI	(IZLjava/lang/Object;)V
    //   598: aload_2
    //   599: ifnull -565 -> 34
    //   602: aload_2
    //   603: invokevirtual 244	com/tencent/mobileqq/persistence/EntityManager:close	()V
    //   606: return
    //   607: aload_0
    //   608: iconst_2
    //   609: iconst_1
    //   610: aconst_null
    //   611: invokevirtual 72	aohx:notifyUI	(IZLjava/lang/Object;)V
    //   614: iconst_0
    //   615: ifeq -581 -> 34
    //   618: new 267	java/lang/NullPointerException
    //   621: dup
    //   622: invokespecial 268	java/lang/NullPointerException:<init>	()V
    //   625: athrow
    //   626: astore_1
    //   627: aconst_null
    //   628: astore_2
    //   629: aload_2
    //   630: ifnull +7 -> 637
    //   633: aload_2
    //   634: invokevirtual 244	com/tencent/mobileqq/persistence/EntityManager:close	()V
    //   637: aload_1
    //   638: athrow
    //   639: astore_1
    //   640: goto -11 -> 629
    //   643: astore_3
    //   644: aload_1
    //   645: astore_2
    //   646: aload_3
    //   647: astore_1
    //   648: goto -19 -> 629
    //   651: astore_2
    //   652: aload_3
    //   653: astore_1
    //   654: goto -136 -> 518
    //   657: goto -421 -> 236
    //   660: goto -414 -> 246
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	663	0	this	aohx
    //   0	663	1	paramToServiceMsg	ToServiceMsg
    //   0	663	2	paramFromServiceMsg	FromServiceMsg
    //   0	663	3	paramObject	Object
    //   73	96	4	i	int
    //   85	471	5	j	int
    //   6	441	6	localObject1	Object
    //   302	139	7	localStranger	com.tencent.mobileqq.data.Stranger
    //   242	15	8	localIterator	Iterator
    //   277	127	9	localObject2	Object
    //   289	82	10	str	String
    // Exception table:
    //   from	to	target	type
    //   214	222	513	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   227	236	513	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   236	244	513	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   246	304	513	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   309	334	513	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   334	365	513	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   368	391	513	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   393	429	513	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   429	438	513	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   446	454	513	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   454	504	513	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   504	510	513	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   538	577	513	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   583	591	513	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   591	598	513	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   45	129	626	finally
    //   136	203	626	finally
    //   203	214	626	finally
    //   607	614	626	finally
    //   214	222	639	finally
    //   227	236	639	finally
    //   236	244	639	finally
    //   246	304	639	finally
    //   309	334	639	finally
    //   334	365	639	finally
    //   368	391	639	finally
    //   393	429	639	finally
    //   429	438	639	finally
    //   446	454	639	finally
    //   454	504	639	finally
    //   504	510	639	finally
    //   538	577	639	finally
    //   583	591	639	finally
    //   591	598	639	finally
    //   518	522	643	finally
    //   45	129	651	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   136	203	651	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   203	214	651	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   607	614	651	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
  }
  
  public void a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("StrangerHandler", 2, "getListLocal ");
    }
    StrangerHandler.1 local1 = new StrangerHandler.1(this);
    if (Thread.currentThread() == Looper.getMainLooper().getThread())
    {
      this.app.a(local1);
      return;
    }
    local1.run();
  }
  
  public void a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    paramFromServiceMsg = a(paramToServiceMsg, paramFromServiceMsg, paramObject);
    if (paramFromServiceMsg == null)
    {
      notifyUI(4, false, null);
      if (QLog.isColorLevel()) {
        QLog.d("StrangerHandler", 2, "handleDeleteStranger: ssoPkg parse failed");
      }
    }
    for (;;)
    {
      return;
      paramToServiceMsg = new oidb_0x5d4.RspBody();
      try
      {
        paramToServiceMsg.mergeFrom(paramFromServiceMsg.bytes_bodybuffer.get().toByteArray());
        paramObject = this.app.a().a();
        paramFromServiceMsg = paramToServiceMsg.result.get().iterator();
        while (paramFromServiceMsg.hasNext())
        {
          Object localObject = (oidb_0x5d4.DelResult)paramFromServiceMsg.next();
          if (((oidb_0x5d4.DelResult)localObject).res.get() == 0)
          {
            localObject = (RecentUser)paramObject.findRecentUser(String.valueOf(((oidb_0x5d4.DelResult)localObject).uin.get()), 0);
            if (localObject != null) {
              paramObject.delRecentUser((BaseRecentUser)localObject);
            }
          }
        }
      }
      catch (Exception paramToServiceMsg)
      {
        paramToServiceMsg.printStackTrace();
        if (0 != 0) {
          throw new NullPointerException();
        }
        notifyUI(4, false, null);
        return;
        notifyUI(4, true, paramToServiceMsg.result);
      }
      finally
      {
        if (0 != 0) {
          throw new NullPointerException();
        }
      }
    }
  }
  
  public boolean a(List<Long> paramList)
  {
    Object localObject = new oidb_0x5d4.ReqBody();
    ((oidb_0x5d4.ReqBody)localObject).uin_list.set(paramList);
    paramList = new oidb_sso.OIDBSSOPkg();
    paramList.uint32_command.set(1492);
    paramList.uint32_result.set(0);
    paramList.uint32_service_type.set(0);
    paramList.bytes_bodybuffer.set(ByteStringMicro.copyFrom(((oidb_0x5d4.ReqBody)localObject).toByteArray()));
    localObject = createToServiceMsg("OidbSvc.0x5d4_0");
    ((ToServiceMsg)localObject).putWupBuffer(paramList.toByteArray());
    ((ToServiceMsg)localObject).setTimeout(60000L);
    QLog.d("StrangerHandler", 2, "deleteStrangers request = " + ((ToServiceMsg)localObject).toString());
    sendPbReq((ToServiceMsg)localObject);
    return true;
  }
  
  public boolean a(boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("StrangerHandler", 2, "getListRemote force = " + paramBoolean);
    }
    int i = this.app.getPreferences().getInt("strange_oidb_get_list_seq_id", 0);
    if (paramBoolean) {
      i = 0;
    }
    Object localObject = new oidb_0x5d2.ReqBody();
    ((oidb_0x5d2.ReqBody)localObject).sub_cmd.set(1);
    ((oidb_0x5d2.ReqBody)localObject).req_get_list.setHasFlag(true);
    ((oidb_0x5d2.ReqBody)localObject).req_get_list.seq.set(i);
    oidb_sso.OIDBSSOPkg localOIDBSSOPkg = new oidb_sso.OIDBSSOPkg();
    localOIDBSSOPkg.uint32_command.set(1490);
    localOIDBSSOPkg.uint32_service_type.set(0);
    localOIDBSSOPkg.bytes_bodybuffer.set(ByteStringMicro.copyFrom(((oidb_0x5d2.ReqBody)localObject).toByteArray()));
    localObject = createToServiceMsg("OidbSvc.0x5d2_0");
    ((ToServiceMsg)localObject).addAttribute("StrangerHandlerSubCmd", Integer.valueOf(1));
    ((ToServiceMsg)localObject).addAttribute("StrangerHandlerSeqId", Integer.valueOf(i));
    ((ToServiceMsg)localObject).putWupBuffer(localOIDBSSOPkg.toByteArray());
    ((ToServiceMsg)localObject).setTimeout(60000L);
    QLog.d("StrangerHandler", 2, "getListRemote request = " + ((ToServiceMsg)localObject).toString());
    sendPbReq((ToServiceMsg)localObject);
    return true;
  }
  
  protected Class<? extends anui> observerClass()
  {
    return aohy.class;
  }
  
  public void onReceive(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    String str = paramToServiceMsg.getServiceCmd();
    if ("OidbSvc.0x5d4_0".equalsIgnoreCase(str)) {
      a(paramToServiceMsg, paramFromServiceMsg, paramObject);
    }
    while ((!"OidbSvc.0x5d2_0".equalsIgnoreCase(str)) || (((Integer)paramToServiceMsg.getAttribute("StrangerHandlerSubCmd", Integer.valueOf(1))).intValue() != 1)) {
      return;
    }
    b(paramToServiceMsg, paramFromServiceMsg, paramObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aohx
 * JD-Core Version:    0.7.0.1
 */