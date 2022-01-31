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
import zni;

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
    //   133: if_icmpeq +475 -> 608
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
    //   224: ifnonnull +434 -> 658
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
    //   253: ifeq +195 -> 448
    //   256: aload 8
    //   258: invokeinterface 176 1 0
    //   263: checkcast 178	tencent/im/oidb/cmd0x5d2/oidb_0x5d2$FriendList
    //   266: astore 7
    //   268: aload 7
    //   270: getfield 182	tencent/im/oidb/cmd0x5d2/oidb_0x5d2$FriendList:uin	Lcom/tencent/mobileqq/pb/PBUInt64Field;
    //   273: invokevirtual 187	com/tencent/mobileqq/pb/PBUInt64Field:get	()J
    //   276: invokestatic 193	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   279: astore_3
    //   280: aload 7
    //   282: getfield 196	tencent/im/oidb/cmd0x5d2/oidb_0x5d2$FriendList:nick	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   285: invokevirtual 48	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   288: invokevirtual 199	com/tencent/mobileqq/pb/ByteStringMicro:toStringUtf8	()Ljava/lang/String;
    //   291: astore 9
    //   293: aload_2
    //   294: ldc 155
    //   296: aload_3
    //   297: invokevirtual 202	com/tencent/mobileqq/persistence/EntityManager:a	(Ljava/lang/Class;Ljava/lang/String;)Lcom/tencent/mobileqq/persistence/Entity;
    //   300: checkcast 155	com/tencent/mobileqq/data/Stranger
    //   303: astore 7
    //   305: aload 7
    //   307: ifnonnull +66 -> 373
    //   310: new 155	com/tencent/mobileqq/data/Stranger
    //   313: dup
    //   314: invokespecial 203	com/tencent/mobileqq/data/Stranger:<init>	()V
    //   317: astore 7
    //   319: aload 7
    //   321: aload_3
    //   322: putfield 206	com/tencent/mobileqq/data/Stranger:uin	Ljava/lang/String;
    //   325: aload 7
    //   327: aload 9
    //   329: putfield 209	com/tencent/mobileqq/data/Stranger:name	Ljava/lang/String;
    //   332: aload_2
    //   333: aload 7
    //   335: invokevirtual 212	com/tencent/mobileqq/persistence/EntityManager:a	(Lcom/tencent/mobileqq/persistence/Entity;)V
    //   338: invokestatic 54	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   341: ifeq +320 -> 661
    //   344: ldc 56
    //   346: iconst_2
    //   347: new 105	java/lang/StringBuilder
    //   350: dup
    //   351: invokespecial 106	java/lang/StringBuilder:<init>	()V
    //   354: ldc 214
    //   356: invokevirtual 112	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   359: aload 7
    //   361: invokevirtual 217	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   364: invokevirtual 121	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   367: invokestatic 62	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   370: goto +291 -> 661
    //   373: aload 7
    //   375: aload 9
    //   377: putfield 209	com/tencent/mobileqq/data/Stranger:name	Ljava/lang/String;
    //   380: aload_2
    //   381: aload 7
    //   383: invokevirtual 220	com/tencent/mobileqq/persistence/EntityManager:a	(Lcom/tencent/mobileqq/persistence/Entity;)Z
    //   386: pop
    //   387: aload 6
    //   389: invokeinterface 167 1 0
    //   394: astore 9
    //   396: aload_1
    //   397: astore_3
    //   398: aload 9
    //   400: invokeinterface 172 1 0
    //   405: ifeq +29 -> 434
    //   408: aload 9
    //   410: invokeinterface 176 1 0
    //   415: checkcast 155	com/tencent/mobileqq/data/Stranger
    //   418: astore_3
    //   419: aload_3
    //   420: getfield 206	com/tencent/mobileqq/data/Stranger:uin	Ljava/lang/String;
    //   423: aload 7
    //   425: getfield 206	com/tencent/mobileqq/data/Stranger:uin	Ljava/lang/String;
    //   428: invokestatic 226	android/text/TextUtils:equals	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Z
    //   431: ifeq -35 -> 396
    //   434: aload 6
    //   436: aload_3
    //   437: invokeinterface 230 2 0
    //   442: pop
    //   443: aload_3
    //   444: astore_1
    //   445: goto -107 -> 338
    //   448: aload 6
    //   450: invokeinterface 167 1 0
    //   455: astore_1
    //   456: aload_1
    //   457: invokeinterface 172 1 0
    //   462: ifeq +78 -> 540
    //   465: aload_1
    //   466: invokeinterface 176 1 0
    //   471: checkcast 155	com/tencent/mobileqq/data/Stranger
    //   474: astore_3
    //   475: invokestatic 54	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   478: ifeq +28 -> 506
    //   481: ldc 56
    //   483: iconst_2
    //   484: new 105	java/lang/StringBuilder
    //   487: dup
    //   488: invokespecial 106	java/lang/StringBuilder:<init>	()V
    //   491: ldc 232
    //   493: invokevirtual 112	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   496: aload_3
    //   497: invokevirtual 217	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   500: invokevirtual 121	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   503: invokestatic 62	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   506: aload_2
    //   507: aload_3
    //   508: invokevirtual 234	com/tencent/mobileqq/persistence/EntityManager:b	(Lcom/tencent/mobileqq/persistence/Entity;)Z
    //   511: pop
    //   512: goto -56 -> 456
    //   515: astore_3
    //   516: aload_2
    //   517: astore_1
    //   518: aload_3
    //   519: astore_2
    //   520: aload_2
    //   521: invokevirtual 237	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException:printStackTrace	()V
    //   524: aload_1
    //   525: ifnull +7 -> 532
    //   528: aload_1
    //   529: invokevirtual 239	com/tencent/mobileqq/persistence/EntityManager:a	()V
    //   532: aload_0
    //   533: iconst_2
    //   534: iconst_0
    //   535: aconst_null
    //   536: invokevirtual 71	com/tencent/mobileqq/app/StrangerHandler:a	(IZLjava/lang/Object;)V
    //   539: return
    //   540: aload_0
    //   541: getfield 141	com/tencent/mobileqq/app/StrangerHandler:b	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   544: invokevirtual 243	com/tencent/mobileqq/app/QQAppInterface:getPreferences	()Landroid/content/SharedPreferences;
    //   547: invokeinterface 249 1 0
    //   552: astore_1
    //   553: aload_1
    //   554: ldc 251
    //   556: iload 5
    //   558: invokeinterface 257 3 0
    //   563: pop
    //   564: aload_1
    //   565: invokeinterface 260 1 0
    //   570: pop
    //   571: aload_2
    //   572: ldc 155
    //   574: invokevirtual 160	com/tencent/mobileqq/persistence/EntityManager:a	(Ljava/lang/Class;)Ljava/util/List;
    //   577: astore_3
    //   578: aload_3
    //   579: astore_1
    //   580: aload_3
    //   581: ifnonnull +11 -> 592
    //   584: new 162	java/util/ArrayList
    //   587: dup
    //   588: invokespecial 163	java/util/ArrayList:<init>	()V
    //   591: astore_1
    //   592: aload_0
    //   593: iconst_2
    //   594: iconst_1
    //   595: aload_1
    //   596: invokevirtual 71	com/tencent/mobileqq/app/StrangerHandler:a	(IZLjava/lang/Object;)V
    //   599: aload_2
    //   600: ifnull -566 -> 34
    //   603: aload_2
    //   604: invokevirtual 239	com/tencent/mobileqq/persistence/EntityManager:a	()V
    //   607: return
    //   608: aload_0
    //   609: iconst_2
    //   610: iconst_1
    //   611: aconst_null
    //   612: invokevirtual 71	com/tencent/mobileqq/app/StrangerHandler:a	(IZLjava/lang/Object;)V
    //   615: iconst_0
    //   616: ifeq -582 -> 34
    //   619: new 262	java/lang/NullPointerException
    //   622: dup
    //   623: invokespecial 263	java/lang/NullPointerException:<init>	()V
    //   626: athrow
    //   627: astore_1
    //   628: aconst_null
    //   629: astore_2
    //   630: aload_2
    //   631: ifnull +7 -> 638
    //   634: aload_2
    //   635: invokevirtual 239	com/tencent/mobileqq/persistence/EntityManager:a	()V
    //   638: aload_1
    //   639: athrow
    //   640: astore_1
    //   641: goto -11 -> 630
    //   644: astore_3
    //   645: aload_1
    //   646: astore_2
    //   647: aload_3
    //   648: astore_1
    //   649: goto -19 -> 630
    //   652: astore_2
    //   653: aload_3
    //   654: astore_1
    //   655: goto -135 -> 520
    //   658: goto -422 -> 236
    //   661: goto -415 -> 246
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	664	0	this	StrangerHandler
    //   0	664	1	paramToServiceMsg	ToServiceMsg
    //   0	664	2	paramFromServiceMsg	FromServiceMsg
    //   0	664	3	paramObject	Object
    //   73	96	4	i	int
    //   85	472	5	j	int
    //   6	443	6	localObject1	Object
    //   266	158	7	localObject2	Object
    //   242	15	8	localIterator	Iterator
    //   291	118	9	localObject3	Object
    // Exception table:
    //   from	to	target	type
    //   214	222	515	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   227	236	515	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   236	244	515	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   246	305	515	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   310	338	515	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   338	370	515	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   373	396	515	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   398	434	515	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   434	443	515	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   448	456	515	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   456	506	515	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   506	512	515	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   540	578	515	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   584	592	515	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   592	599	515	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   45	129	627	finally
    //   136	203	627	finally
    //   203	214	627	finally
    //   608	615	627	finally
    //   214	222	640	finally
    //   227	236	640	finally
    //   236	244	640	finally
    //   246	305	640	finally
    //   310	338	640	finally
    //   338	370	640	finally
    //   373	396	640	finally
    //   398	434	640	finally
    //   434	443	640	finally
    //   448	456	640	finally
    //   456	506	640	finally
    //   506	512	640	finally
    //   540	578	640	finally
    //   584	592	640	finally
    //   592	599	640	finally
    //   520	524	644	finally
    //   45	129	652	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   136	203	652	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   203	214	652	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   608	615	652	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
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
    zni localzni = new zni(this);
    if (Thread.currentThread() == Looper.getMainLooper().getThread())
    {
      this.b.a(localzni);
      return;
    }
    localzni.run();
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
        paramFromServiceMsg = this.b.a().a();
        paramObject = paramToServiceMsg.result.get().iterator();
        while (paramObject.hasNext())
        {
          Object localObject = (oidb_0x5d4.DelResult)paramObject.next();
          if (((oidb_0x5d4.DelResult)localObject).res.get() == 0)
          {
            localObject = paramFromServiceMsg.b(String.valueOf(((oidb_0x5d4.DelResult)localObject).uin.get()), 0);
            if (localObject != null) {
              paramFromServiceMsg.b((RecentUser)localObject);
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