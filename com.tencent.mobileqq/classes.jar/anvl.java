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

public class anvl
  extends anii
{
  public anvl(QQAppInterface paramQQAppInterface)
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
    //   3: invokestatic 66	anvl:a	(Lcom/tencent/qphone/base/remote/ToServiceMsg;Lcom/tencent/qphone/base/remote/FromServiceMsg;Ljava/lang/Object;)Ltencent/im/oidb/oidb_sso$OIDBSSOPkg;
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
    //   31: invokevirtual 72	anvl:notifyUI	(IZLjava/lang/Object;)V
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
    //   73: istore 5
    //   75: aload_2
    //   76: getfield 99	tencent/im/oidb/cmd0x5d2/oidb_0x5d2$RspBody:rsp_get_list	Ltencent/im/oidb/cmd0x5d2/oidb_0x5d2$RspGetList;
    //   79: getfield 104	tencent/im/oidb/cmd0x5d2/oidb_0x5d2$RspGetList:seq	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   82: invokevirtual 39	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   85: istore 4
    //   87: invokestatic 54	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   90: ifeq +39 -> 129
    //   93: ldc 56
    //   95: iconst_2
    //   96: new 106	java/lang/StringBuilder
    //   99: dup
    //   100: invokespecial 107	java/lang/StringBuilder:<init>	()V
    //   103: ldc 109
    //   105: invokevirtual 113	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   108: iload 5
    //   110: invokevirtual 116	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   113: ldc 118
    //   115: invokevirtual 113	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   118: iload 4
    //   120: invokevirtual 116	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   123: invokevirtual 122	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   126: invokestatic 62	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   129: iload 5
    //   131: iload 4
    //   133: if_icmpeq +476 -> 609
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
    //   168: iload 5
    //   170: invokevirtual 116	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   173: ldc 118
    //   175: invokevirtual 113	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   178: iload 4
    //   180: invokevirtual 116	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   183: ldc 133
    //   185: invokevirtual 113	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   188: aload_1
    //   189: invokeinterface 138 1 0
    //   194: invokevirtual 116	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   197: invokevirtual 122	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   200: invokestatic 62	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   203: aload_0
    //   204: getfield 142	anvl:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   207: invokevirtual 147	com/tencent/mobileqq/app/QQAppInterface:a	()Lcom/tencent/mobileqq/data/QQEntityManagerFactory;
    //   210: invokevirtual 153	com/tencent/mobileqq/data/QQEntityManagerFactory:createEntityManager	()Lcom/tencent/mobileqq/persistence/EntityManager;
    //   213: astore_2
    //   214: aload_2
    //   215: ldc 155
    //   217: invokevirtual 161	com/tencent/mobileqq/persistence/EntityManager:query	(Ljava/lang/Class;)Ljava/util/List;
    //   220: astore 6
    //   222: aload 6
    //   224: ifnonnull +435 -> 659
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
    //   253: ifeq +195 -> 448
    //   256: aload 8
    //   258: invokeinterface 177 1 0
    //   263: checkcast 179	tencent/im/oidb/cmd0x5d2/oidb_0x5d2$FriendList
    //   266: astore 7
    //   268: aload 7
    //   270: getfield 183	tencent/im/oidb/cmd0x5d2/oidb_0x5d2$FriendList:uin	Lcom/tencent/mobileqq/pb/PBUInt64Field;
    //   273: invokevirtual 188	com/tencent/mobileqq/pb/PBUInt64Field:get	()J
    //   276: invokestatic 194	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   279: astore_3
    //   280: aload 7
    //   282: getfield 197	tencent/im/oidb/cmd0x5d2/oidb_0x5d2$FriendList:nick	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   285: invokevirtual 48	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   288: invokevirtual 200	com/tencent/mobileqq/pb/ByteStringMicro:toStringUtf8	()Ljava/lang/String;
    //   291: astore 9
    //   293: aload_2
    //   294: ldc 155
    //   296: aload_3
    //   297: invokevirtual 204	com/tencent/mobileqq/persistence/EntityManager:find	(Ljava/lang/Class;Ljava/lang/String;)Lcom/tencent/mobileqq/persistence/Entity;
    //   300: checkcast 155	com/tencent/mobileqq/data/Stranger
    //   303: astore 7
    //   305: aload 7
    //   307: ifnonnull +66 -> 373
    //   310: new 155	com/tencent/mobileqq/data/Stranger
    //   313: dup
    //   314: invokespecial 205	com/tencent/mobileqq/data/Stranger:<init>	()V
    //   317: astore 7
    //   319: aload 7
    //   321: aload_3
    //   322: putfield 208	com/tencent/mobileqq/data/Stranger:uin	Ljava/lang/String;
    //   325: aload 7
    //   327: aload 9
    //   329: putfield 211	com/tencent/mobileqq/data/Stranger:name	Ljava/lang/String;
    //   332: aload_2
    //   333: aload 7
    //   335: invokevirtual 215	com/tencent/mobileqq/persistence/EntityManager:persist	(Lcom/tencent/mobileqq/persistence/Entity;)V
    //   338: invokestatic 54	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   341: ifeq +321 -> 662
    //   344: ldc 56
    //   346: iconst_2
    //   347: new 106	java/lang/StringBuilder
    //   350: dup
    //   351: invokespecial 107	java/lang/StringBuilder:<init>	()V
    //   354: ldc 217
    //   356: invokevirtual 113	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   359: aload 7
    //   361: invokevirtual 220	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   364: invokevirtual 122	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   367: invokestatic 62	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   370: goto +292 -> 662
    //   373: aload 7
    //   375: aload 9
    //   377: putfield 211	com/tencent/mobileqq/data/Stranger:name	Ljava/lang/String;
    //   380: aload_2
    //   381: aload 7
    //   383: invokevirtual 224	com/tencent/mobileqq/persistence/EntityManager:update	(Lcom/tencent/mobileqq/persistence/Entity;)Z
    //   386: pop
    //   387: aload 6
    //   389: invokeinterface 168 1 0
    //   394: astore 9
    //   396: aload_1
    //   397: astore_3
    //   398: aload 9
    //   400: invokeinterface 173 1 0
    //   405: ifeq +29 -> 434
    //   408: aload 9
    //   410: invokeinterface 177 1 0
    //   415: checkcast 155	com/tencent/mobileqq/data/Stranger
    //   418: astore_3
    //   419: aload_3
    //   420: getfield 208	com/tencent/mobileqq/data/Stranger:uin	Ljava/lang/String;
    //   423: aload 7
    //   425: getfield 208	com/tencent/mobileqq/data/Stranger:uin	Ljava/lang/String;
    //   428: invokestatic 230	android/text/TextUtils:equals	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Z
    //   431: ifeq -35 -> 396
    //   434: aload 6
    //   436: aload_3
    //   437: invokeinterface 234 2 0
    //   442: pop
    //   443: aload_3
    //   444: astore_1
    //   445: goto -107 -> 338
    //   448: aload 6
    //   450: invokeinterface 168 1 0
    //   455: astore_3
    //   456: aload_3
    //   457: invokeinterface 173 1 0
    //   462: ifeq +78 -> 540
    //   465: aload_3
    //   466: invokeinterface 177 1 0
    //   471: checkcast 155	com/tencent/mobileqq/data/Stranger
    //   474: astore_1
    //   475: invokestatic 54	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   478: ifeq +28 -> 506
    //   481: ldc 56
    //   483: iconst_2
    //   484: new 106	java/lang/StringBuilder
    //   487: dup
    //   488: invokespecial 107	java/lang/StringBuilder:<init>	()V
    //   491: ldc 236
    //   493: invokevirtual 113	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   496: aload_1
    //   497: invokevirtual 220	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   500: invokevirtual 122	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   503: invokestatic 62	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   506: aload_2
    //   507: aload_1
    //   508: invokevirtual 238	com/tencent/mobileqq/persistence/EntityManager:remove	(Lcom/tencent/mobileqq/persistence/Entity;)Z
    //   511: pop
    //   512: goto -56 -> 456
    //   515: astore_3
    //   516: aload_2
    //   517: astore_1
    //   518: aload_3
    //   519: astore_2
    //   520: aload_2
    //   521: invokevirtual 241	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException:printStackTrace	()V
    //   524: aload_1
    //   525: ifnull +7 -> 532
    //   528: aload_1
    //   529: invokevirtual 244	com/tencent/mobileqq/persistence/EntityManager:close	()V
    //   532: aload_0
    //   533: iconst_2
    //   534: iconst_0
    //   535: aconst_null
    //   536: invokevirtual 72	anvl:notifyUI	(IZLjava/lang/Object;)V
    //   539: return
    //   540: aload_0
    //   541: getfield 142	anvl:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   544: invokevirtual 248	com/tencent/mobileqq/app/QQAppInterface:getPreferences	()Landroid/content/SharedPreferences;
    //   547: invokeinterface 254 1 0
    //   552: astore_1
    //   553: aload_1
    //   554: ldc_w 256
    //   557: iload 4
    //   559: invokeinterface 262 3 0
    //   564: pop
    //   565: aload_1
    //   566: invokeinterface 265 1 0
    //   571: pop
    //   572: aload_2
    //   573: ldc 155
    //   575: invokevirtual 161	com/tencent/mobileqq/persistence/EntityManager:query	(Ljava/lang/Class;)Ljava/util/List;
    //   578: astore_3
    //   579: aload_3
    //   580: astore_1
    //   581: aload_3
    //   582: ifnonnull +11 -> 593
    //   585: new 163	java/util/ArrayList
    //   588: dup
    //   589: invokespecial 164	java/util/ArrayList:<init>	()V
    //   592: astore_1
    //   593: aload_0
    //   594: iconst_2
    //   595: iconst_1
    //   596: aload_1
    //   597: invokevirtual 72	anvl:notifyUI	(IZLjava/lang/Object;)V
    //   600: aload_2
    //   601: ifnull -567 -> 34
    //   604: aload_2
    //   605: invokevirtual 244	com/tencent/mobileqq/persistence/EntityManager:close	()V
    //   608: return
    //   609: aload_0
    //   610: iconst_2
    //   611: iconst_1
    //   612: aconst_null
    //   613: invokevirtual 72	anvl:notifyUI	(IZLjava/lang/Object;)V
    //   616: iconst_0
    //   617: ifeq -583 -> 34
    //   620: new 267	java/lang/NullPointerException
    //   623: dup
    //   624: invokespecial 268	java/lang/NullPointerException:<init>	()V
    //   627: athrow
    //   628: astore_1
    //   629: aconst_null
    //   630: astore_2
    //   631: aload_2
    //   632: ifnull +7 -> 639
    //   635: aload_2
    //   636: invokevirtual 244	com/tencent/mobileqq/persistence/EntityManager:close	()V
    //   639: aload_1
    //   640: athrow
    //   641: astore_1
    //   642: goto -11 -> 631
    //   645: astore_3
    //   646: aload_1
    //   647: astore_2
    //   648: aload_3
    //   649: astore_1
    //   650: goto -19 -> 631
    //   653: astore_2
    //   654: aload_3
    //   655: astore_1
    //   656: goto -136 -> 520
    //   659: goto -423 -> 236
    //   662: goto -416 -> 246
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	665	0	this	anvl
    //   0	665	1	paramToServiceMsg	ToServiceMsg
    //   0	665	2	paramFromServiceMsg	FromServiceMsg
    //   0	665	3	paramObject	Object
    //   85	473	4	i	int
    //   73	96	5	j	int
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
    //   540	579	515	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   585	593	515	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   593	600	515	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   45	129	628	finally
    //   136	203	628	finally
    //   203	214	628	finally
    //   609	616	628	finally
    //   214	222	641	finally
    //   227	236	641	finally
    //   236	244	641	finally
    //   246	305	641	finally
    //   310	338	641	finally
    //   338	370	641	finally
    //   373	396	641	finally
    //   398	434	641	finally
    //   434	443	641	finally
    //   448	456	641	finally
    //   456	506	641	finally
    //   506	512	641	finally
    //   540	579	641	finally
    //   585	593	641	finally
    //   593	600	641	finally
    //   520	524	645	finally
    //   45	129	653	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   136	203	653	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   203	214	653	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   609	616	653	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
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
  
  protected Class<? extends anil> observerClass()
  {
    return anvm.class;
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
 * Qualified Name:     anvl
 * JD-Core Version:    0.7.0.1
 */