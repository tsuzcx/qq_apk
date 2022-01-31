package com.tencent.mobileqq.app;

import android.content.SharedPreferences;
import android.os.Looper;
import com.tencent.mobileqq.app.proxy.ProxyManager;
import com.tencent.mobileqq.app.proxy.RecentUserProxy;
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
import zue;

public class StrangerHandler
  extends BusinessHandler
{
  StrangerHandler(QQAppInterface paramQQAppInterface)
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
  private void c(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    // Byte code:
    //   0: aload_1
    //   1: aload_2
    //   2: aload_3
    //   3: invokestatic 66	com/tencent/mobileqq/app/StrangerHandler:a	(Lcom/tencent/qphone/base/remote/ToServiceMsg;Lcom/tencent/qphone/base/remote/FromServiceMsg;Ljava/lang/Object;)Ltencent/im/oidb/oidb_sso$OIDBSSOPkg;
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
    //   31: invokevirtual 71	com/tencent/mobileqq/app/StrangerHandler:a	(IZLjava/lang/Object;)V
    //   34: return
    //   35: new 73	tencent/im/oidb/cmd0x5d2/oidb_0x5d2$RspBody
    //   38: dup
    //   39: invokespecial 74	tencent/im/oidb/cmd0x5d2/oidb_0x5d2$RspBody:<init>	()V
    //   42: astore_2
    //   43: aconst_null
    //   44: astore_3
    //   45: aload_2
    //   46: aload 6
    //   48: getfield 43	tencent/im/oidb/oidb_sso$OIDBSSOPkg:bytes_bodybuffer	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   51: invokevirtual 48	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   54: invokevirtual 80	com/tencent/mobileqq/pb/ByteStringMicro:toByteArray	()[B
    //   57: invokevirtual 81	tencent/im/oidb/cmd0x5d2/oidb_0x5d2$RspBody:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   60: pop
    //   61: aload_1
    //   62: ldc 83
    //   64: invokevirtual 89	com/tencent/qphone/base/remote/ToServiceMsg:getAttribute	(Ljava/lang/String;)Ljava/lang/Object;
    //   67: checkcast 91	java/lang/Integer
    //   70: invokevirtual 94	java/lang/Integer:intValue	()I
    //   73: istore 4
    //   75: aload_2
    //   76: getfield 98	tencent/im/oidb/cmd0x5d2/oidb_0x5d2$RspBody:rsp_get_list	Ltencent/im/oidb/cmd0x5d2/oidb_0x5d2$RspGetList;
    //   79: getfield 103	tencent/im/oidb/cmd0x5d2/oidb_0x5d2$RspGetList:seq	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   82: invokevirtual 39	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   85: istore 5
    //   87: invokestatic 54	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   90: ifeq +39 -> 129
    //   93: ldc 56
    //   95: iconst_2
    //   96: new 105	java/lang/StringBuilder
    //   99: dup
    //   100: invokespecial 106	java/lang/StringBuilder:<init>	()V
    //   103: ldc 108
    //   105: invokevirtual 112	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   108: iload 4
    //   110: invokevirtual 115	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   113: ldc 117
    //   115: invokevirtual 112	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   118: iload 5
    //   120: invokevirtual 115	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   123: invokevirtual 121	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   126: invokestatic 62	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   129: iload 4
    //   131: iload 5
    //   133: if_icmpeq +473 -> 606
    //   136: aload_2
    //   137: getfield 98	tencent/im/oidb/cmd0x5d2/oidb_0x5d2$RspBody:rsp_get_list	Ltencent/im/oidb/cmd0x5d2/oidb_0x5d2$RspGetList;
    //   140: getfield 125	tencent/im/oidb/cmd0x5d2/oidb_0x5d2$RspGetList:list	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   143: invokevirtual 130	com/tencent/mobileqq/pb/PBRepeatMessageField:get	()Ljava/util/List;
    //   146: astore_1
    //   147: invokestatic 54	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   150: ifeq +53 -> 203
    //   153: ldc 56
    //   155: iconst_2
    //   156: new 105	java/lang/StringBuilder
    //   159: dup
    //   160: invokespecial 106	java/lang/StringBuilder:<init>	()V
    //   163: ldc 108
    //   165: invokevirtual 112	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   168: iload 4
    //   170: invokevirtual 115	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   173: ldc 117
    //   175: invokevirtual 112	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   178: iload 5
    //   180: invokevirtual 115	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   183: ldc 132
    //   185: invokevirtual 112	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   188: aload_1
    //   189: invokeinterface 137 1 0
    //   194: invokevirtual 115	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   197: invokevirtual 121	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   200: invokestatic 62	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   203: aload_0
    //   204: getfield 141	com/tencent/mobileqq/app/StrangerHandler:b	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   207: invokevirtual 147	com/tencent/mobileqq/app/QQAppInterface:getEntityManagerFactory	()Lcom/tencent/mobileqq/persistence/EntityManagerFactory;
    //   210: invokevirtual 153	com/tencent/mobileqq/persistence/EntityManagerFactory:createEntityManager	()Lcom/tencent/mobileqq/persistence/EntityManager;
    //   213: astore_2
    //   214: aload_2
    //   215: ldc 155
    //   217: invokevirtual 160	com/tencent/mobileqq/persistence/EntityManager:a	(Ljava/lang/Class;)Ljava/util/List;
    //   220: astore 6
    //   222: aload 6
    //   224: ifnonnull +432 -> 656
    //   227: new 162	java/util/ArrayList
    //   230: dup
    //   231: invokespecial 163	java/util/ArrayList:<init>	()V
    //   234: astore 6
    //   236: aload_1
    //   237: invokeinterface 167 1 0
    //   242: astore 8
    //   244: aconst_null
    //   245: astore_1
    //   246: aload 8
    //   248: invokeinterface 172 1 0
    //   253: ifeq +193 -> 446
    //   256: aload 8
    //   258: invokeinterface 176 1 0
    //   263: checkcast 178	tencent/im/oidb/cmd0x5d2/oidb_0x5d2$FriendList
    //   266: astore_3
    //   267: aload_3
    //   268: getfield 182	tencent/im/oidb/cmd0x5d2/oidb_0x5d2$FriendList:uin	Lcom/tencent/mobileqq/pb/PBUInt64Field;
    //   271: invokevirtual 187	com/tencent/mobileqq/pb/PBUInt64Field:get	()J
    //   274: invokestatic 193	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   277: astore 9
    //   279: aload_3
    //   280: getfield 196	tencent/im/oidb/cmd0x5d2/oidb_0x5d2$FriendList:nick	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   283: invokevirtual 48	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   286: invokevirtual 199	com/tencent/mobileqq/pb/ByteStringMicro:toStringUtf8	()Ljava/lang/String;
    //   289: astore 10
    //   291: aload_2
    //   292: ldc 155
    //   294: aload 9
    //   296: invokevirtual 202	com/tencent/mobileqq/persistence/EntityManager:a	(Ljava/lang/Class;Ljava/lang/String;)Lcom/tencent/mobileqq/persistence/Entity;
    //   299: checkcast 155	com/tencent/mobileqq/data/Stranger
    //   302: astore 7
    //   304: aload 7
    //   306: ifnonnull +62 -> 368
    //   309: new 155	com/tencent/mobileqq/data/Stranger
    //   312: dup
    //   313: invokespecial 203	com/tencent/mobileqq/data/Stranger:<init>	()V
    //   316: astore_3
    //   317: aload_3
    //   318: aload 9
    //   320: putfield 206	com/tencent/mobileqq/data/Stranger:uin	Ljava/lang/String;
    //   323: aload_3
    //   324: aload 10
    //   326: putfield 209	com/tencent/mobileqq/data/Stranger:name	Ljava/lang/String;
    //   329: aload_2
    //   330: aload_3
    //   331: invokevirtual 212	com/tencent/mobileqq/persistence/EntityManager:a	(Lcom/tencent/mobileqq/persistence/Entity;)V
    //   334: invokestatic 54	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   337: ifeq +322 -> 659
    //   340: ldc 56
    //   342: iconst_2
    //   343: new 105	java/lang/StringBuilder
    //   346: dup
    //   347: invokespecial 106	java/lang/StringBuilder:<init>	()V
    //   350: ldc 214
    //   352: invokevirtual 112	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   355: aload_3
    //   356: invokevirtual 217	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   359: invokevirtual 121	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   362: invokestatic 62	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   365: goto +294 -> 659
    //   368: aload 7
    //   370: aload 10
    //   372: putfield 209	com/tencent/mobileqq/data/Stranger:name	Ljava/lang/String;
    //   375: aload_2
    //   376: aload 7
    //   378: invokevirtual 220	com/tencent/mobileqq/persistence/EntityManager:a	(Lcom/tencent/mobileqq/persistence/Entity;)Z
    //   381: pop
    //   382: aload 6
    //   384: invokeinterface 167 1 0
    //   389: astore 9
    //   391: aload_1
    //   392: astore_3
    //   393: aload 9
    //   395: invokeinterface 172 1 0
    //   400: ifeq +29 -> 429
    //   403: aload 9
    //   405: invokeinterface 176 1 0
    //   410: checkcast 155	com/tencent/mobileqq/data/Stranger
    //   413: astore_3
    //   414: aload_3
    //   415: getfield 206	com/tencent/mobileqq/data/Stranger:uin	Ljava/lang/String;
    //   418: aload 7
    //   420: getfield 206	com/tencent/mobileqq/data/Stranger:uin	Ljava/lang/String;
    //   423: invokestatic 226	android/text/TextUtils:equals	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Z
    //   426: ifeq -35 -> 391
    //   429: aload 6
    //   431: aload_3
    //   432: invokeinterface 230 2 0
    //   437: pop
    //   438: aload_3
    //   439: astore_1
    //   440: aload 7
    //   442: astore_3
    //   443: goto -109 -> 334
    //   446: aload 6
    //   448: invokeinterface 167 1 0
    //   453: astore_3
    //   454: aload_3
    //   455: invokeinterface 172 1 0
    //   460: ifeq +78 -> 538
    //   463: aload_3
    //   464: invokeinterface 176 1 0
    //   469: checkcast 155	com/tencent/mobileqq/data/Stranger
    //   472: astore_1
    //   473: invokestatic 54	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   476: ifeq +28 -> 504
    //   479: ldc 56
    //   481: iconst_2
    //   482: new 105	java/lang/StringBuilder
    //   485: dup
    //   486: invokespecial 106	java/lang/StringBuilder:<init>	()V
    //   489: ldc 232
    //   491: invokevirtual 112	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   494: aload_1
    //   495: invokevirtual 217	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   498: invokevirtual 121	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   501: invokestatic 62	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   504: aload_2
    //   505: aload_1
    //   506: invokevirtual 234	com/tencent/mobileqq/persistence/EntityManager:b	(Lcom/tencent/mobileqq/persistence/Entity;)Z
    //   509: pop
    //   510: goto -56 -> 454
    //   513: astore_3
    //   514: aload_2
    //   515: astore_1
    //   516: aload_3
    //   517: astore_2
    //   518: aload_2
    //   519: invokevirtual 237	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException:printStackTrace	()V
    //   522: aload_1
    //   523: ifnull +7 -> 530
    //   526: aload_1
    //   527: invokevirtual 239	com/tencent/mobileqq/persistence/EntityManager:a	()V
    //   530: aload_0
    //   531: iconst_2
    //   532: iconst_0
    //   533: aconst_null
    //   534: invokevirtual 71	com/tencent/mobileqq/app/StrangerHandler:a	(IZLjava/lang/Object;)V
    //   537: return
    //   538: aload_0
    //   539: getfield 141	com/tencent/mobileqq/app/StrangerHandler:b	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   542: invokevirtual 243	com/tencent/mobileqq/app/QQAppInterface:getPreferences	()Landroid/content/SharedPreferences;
    //   545: invokeinterface 249 1 0
    //   550: astore_1
    //   551: aload_1
    //   552: ldc 251
    //   554: iload 5
    //   556: invokeinterface 257 3 0
    //   561: pop
    //   562: aload_1
    //   563: invokeinterface 260 1 0
    //   568: pop
    //   569: aload_2
    //   570: ldc 155
    //   572: invokevirtual 160	com/tencent/mobileqq/persistence/EntityManager:a	(Ljava/lang/Class;)Ljava/util/List;
    //   575: astore_3
    //   576: aload_3
    //   577: astore_1
    //   578: aload_3
    //   579: ifnonnull +11 -> 590
    //   582: new 162	java/util/ArrayList
    //   585: dup
    //   586: invokespecial 163	java/util/ArrayList:<init>	()V
    //   589: astore_1
    //   590: aload_0
    //   591: iconst_2
    //   592: iconst_1
    //   593: aload_1
    //   594: invokevirtual 71	com/tencent/mobileqq/app/StrangerHandler:a	(IZLjava/lang/Object;)V
    //   597: aload_2
    //   598: ifnull -564 -> 34
    //   601: aload_2
    //   602: invokevirtual 239	com/tencent/mobileqq/persistence/EntityManager:a	()V
    //   605: return
    //   606: aload_0
    //   607: iconst_2
    //   608: iconst_1
    //   609: aconst_null
    //   610: invokevirtual 71	com/tencent/mobileqq/app/StrangerHandler:a	(IZLjava/lang/Object;)V
    //   613: iconst_0
    //   614: ifeq -580 -> 34
    //   617: new 262	java/lang/NullPointerException
    //   620: dup
    //   621: invokespecial 263	java/lang/NullPointerException:<init>	()V
    //   624: athrow
    //   625: astore_1
    //   626: aconst_null
    //   627: astore_2
    //   628: aload_2
    //   629: ifnull +7 -> 636
    //   632: aload_2
    //   633: invokevirtual 239	com/tencent/mobileqq/persistence/EntityManager:a	()V
    //   636: aload_1
    //   637: athrow
    //   638: astore_1
    //   639: goto -11 -> 628
    //   642: astore_3
    //   643: aload_1
    //   644: astore_2
    //   645: aload_3
    //   646: astore_1
    //   647: goto -19 -> 628
    //   650: astore_2
    //   651: aload_3
    //   652: astore_1
    //   653: goto -135 -> 518
    //   656: goto -420 -> 236
    //   659: goto -413 -> 246
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	662	0	this	StrangerHandler
    //   0	662	1	paramToServiceMsg	ToServiceMsg
    //   0	662	2	paramFromServiceMsg	FromServiceMsg
    //   0	662	3	paramObject	Object
    //   73	96	4	i	int
    //   85	470	5	j	int
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
    //   538	576	513	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   582	590	513	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   590	597	513	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   45	129	625	finally
    //   136	203	625	finally
    //   203	214	625	finally
    //   606	613	625	finally
    //   214	222	638	finally
    //   227	236	638	finally
    //   236	244	638	finally
    //   246	304	638	finally
    //   309	334	638	finally
    //   334	365	638	finally
    //   368	391	638	finally
    //   393	429	638	finally
    //   429	438	638	finally
    //   446	454	638	finally
    //   454	504	638	finally
    //   504	510	638	finally
    //   538	576	638	finally
    //   582	590	638	finally
    //   590	597	638	finally
    //   518	522	642	finally
    //   45	129	650	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   136	203	650	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   203	214	650	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   606	613	650	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
  }
  
  protected Class a()
  {
    return StrangerObserver.class;
  }
  
  public void a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    String str = paramToServiceMsg.getServiceCmd();
    if ("OidbSvc.0x5d4_0".equalsIgnoreCase(str)) {
      b(paramToServiceMsg, paramFromServiceMsg, paramObject);
    }
    while ((!"OidbSvc.0x5d2_0".equalsIgnoreCase(str)) || (((Integer)paramToServiceMsg.getAttribute("StrangerHandlerSubCmd", Integer.valueOf(1))).intValue() != 1)) {
      return;
    }
    c(paramToServiceMsg, paramFromServiceMsg, paramObject);
  }
  
  public boolean a(List paramList)
  {
    Object localObject = new oidb_0x5d4.ReqBody();
    ((oidb_0x5d4.ReqBody)localObject).uin_list.set(paramList);
    paramList = new oidb_sso.OIDBSSOPkg();
    paramList.uint32_command.set(1492);
    paramList.uint32_result.set(0);
    paramList.uint32_service_type.set(0);
    paramList.bytes_bodybuffer.set(ByteStringMicro.copyFrom(((oidb_0x5d4.ReqBody)localObject).toByteArray()));
    localObject = a("OidbSvc.0x5d4_0");
    ((ToServiceMsg)localObject).putWupBuffer(paramList.toByteArray());
    ((ToServiceMsg)localObject).setTimeout(60000L);
    QLog.d("StrangerHandler", 2, "deleteStrangers request = " + ((ToServiceMsg)localObject).toString());
    b((ToServiceMsg)localObject);
    return true;
  }
  
  public boolean a(boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("StrangerHandler", 2, "getListRemote force = " + paramBoolean);
    }
    int i = this.b.getPreferences().getInt("strange_oidb_get_list_seq_id", 0);
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
    localObject = a("OidbSvc.0x5d2_0");
    ((ToServiceMsg)localObject).addAttribute("StrangerHandlerSubCmd", Integer.valueOf(1));
    ((ToServiceMsg)localObject).addAttribute("StrangerHandlerSeqId", Integer.valueOf(i));
    ((ToServiceMsg)localObject).putWupBuffer(localOIDBSSOPkg.toByteArray());
    ((ToServiceMsg)localObject).setTimeout(60000L);
    QLog.d("StrangerHandler", 2, "getListRemote request = " + ((ToServiceMsg)localObject).toString());
    b((ToServiceMsg)localObject);
    return true;
  }
  
  public void b()
  {
    if (QLog.isColorLevel()) {
      QLog.d("StrangerHandler", 2, "getListLocal ");
    }
    zue localzue = new zue(this);
    if (Thread.currentThread() == Looper.getMainLooper().getThread())
    {
      this.b.a(localzue);
      return;
    }
    localzue.run();
  }
  
  public void b(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    paramFromServiceMsg = a(paramToServiceMsg, paramFromServiceMsg, paramObject);
    if (paramFromServiceMsg == null)
    {
      a(4, false, null);
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
        paramObject = this.b.a().a();
        paramFromServiceMsg = paramToServiceMsg.result.get().iterator();
        while (paramFromServiceMsg.hasNext())
        {
          Object localObject = (oidb_0x5d4.DelResult)paramFromServiceMsg.next();
          if (((oidb_0x5d4.DelResult)localObject).res.get() == 0)
          {
            localObject = paramObject.b(String.valueOf(((oidb_0x5d4.DelResult)localObject).uin.get()), 0);
            if (localObject != null) {
              paramObject.b((RecentUser)localObject);
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
        a(4, false, null);
        return;
        a(4, true, paramToServiceMsg.result);
      }
      finally
      {
        if (0 != 0) {
          throw new NullPointerException();
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.app.StrangerHandler
 * JD-Core Version:    0.7.0.1
 */