package com.tencent.mobileqq.app;

import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;

public class SafeCenterPushHandler
  extends BusinessHandler
{
  SafeCenterPushHandler(QQAppInterface paramQQAppInterface)
  {
    super(paramQQAppInterface);
  }
  
  protected Class a()
  {
    return null;
  }
  
  public void a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject) {}
  
  /* Error */
  public void a(byte[] paramArrayOfByte)
  {
    // Byte code:
    //   0: iconst_2
    //   1: istore_2
    //   2: new 19	tencent/im/s2c/msgtype0x210/submsgtype0x4a/MsgBody
    //   5: dup
    //   6: invokespecial 22	tencent/im/s2c/msgtype0x210/submsgtype0x4a/MsgBody:<init>	()V
    //   9: astore_3
    //   10: aload_3
    //   11: aload_1
    //   12: invokevirtual 26	tencent/im/s2c/msgtype0x210/submsgtype0x4a/MsgBody:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   15: pop
    //   16: aload_3
    //   17: invokevirtual 30	tencent/im/s2c/msgtype0x210/submsgtype0x4a/MsgBody:has	()Z
    //   20: ifeq +13 -> 33
    //   23: aload_3
    //   24: getfield 34	tencent/im/s2c/msgtype0x210/submsgtype0x4a/MsgBody:uint32_sec_cmd	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   27: invokevirtual 37	com/tencent/mobileqq/pb/PBUInt32Field:has	()Z
    //   30: ifne +26 -> 56
    //   33: return
    //   34: astore_1
    //   35: invokestatic 42	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   38: ifeq +11 -> 49
    //   41: ldc 44
    //   43: iconst_2
    //   44: ldc 46
    //   46: invokestatic 50	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   49: aload_1
    //   50: invokevirtual 53	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException:printStackTrace	()V
    //   53: goto -37 -> 16
    //   56: aload_3
    //   57: getfield 34	tencent/im/s2c/msgtype0x210/submsgtype0x4a/MsgBody:uint32_sec_cmd	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   60: invokevirtual 57	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   63: tableswitch	default:+41 -> 104, 1:+42->105, 2:+57->120, 3:+165->228, 4:+230->293, 5:+312->375, 6:+461->524, 7:+477->540
    //   105: new 59	com/tencent/ctsz/m
    //   108: dup
    //   109: aload_0
    //   110: getfield 63	com/tencent/mobileqq/app/SafeCenterPushHandler:b	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   113: invokespecial 64	com/tencent/ctsz/m:<init>	(Lcom/tencent/mobileqq/app/QQAppInterface;)V
    //   116: invokevirtual 66	com/tencent/ctsz/m:a	()V
    //   119: return
    //   120: aload_0
    //   121: getfield 63	com/tencent/mobileqq/app/SafeCenterPushHandler:b	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   124: bipush 63
    //   126: invokevirtual 71	com/tencent/mobileqq/app/QQAppInterface:a	(I)Lcom/tencent/mobileqq/app/BusinessHandler;
    //   129: checkcast 73	com/tencent/msfmqpsdkbridge/MSFNetTransportProvider
    //   132: astore_1
    //   133: new 75	com/tencent/mqpsdk/MQPSecServiceManager
    //   136: dup
    //   137: aload_0
    //   138: getfield 63	com/tencent/mobileqq/app/SafeCenterPushHandler:b	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   141: invokevirtual 79	com/tencent/mobileqq/app/QQAppInterface:getApp	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   144: invokevirtual 85	com/tencent/qphone/base/util/BaseApplication:getApplicationContext	()Landroid/content/Context;
    //   147: aload_1
    //   148: invokespecial 88	com/tencent/mqpsdk/MQPSecServiceManager:<init>	(Landroid/content/Context;Lcom/tencent/mqpsdk/INetTransportProvider;)V
    //   151: astore_1
    //   152: aload_1
    //   153: ifnull -120 -> 33
    //   156: aload_1
    //   157: ldc 90
    //   159: invokevirtual 93	com/tencent/mqpsdk/MQPSecServiceManager:a	(Ljava/lang/String;)Ljava/lang/Object;
    //   162: checkcast 95	com/tencent/mqpsdk/secsrv/MQPIntChkService
    //   165: astore_1
    //   166: aload_1
    //   167: ifnull -134 -> 33
    //   170: aload_1
    //   171: iconst_1
    //   172: new 97	com/tencent/msfmqpsdkbridge/MSFIntChkStrike
    //   175: dup
    //   176: aload_0
    //   177: getfield 63	com/tencent/mobileqq/app/SafeCenterPushHandler:b	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   180: iconst_1
    //   181: invokespecial 100	com/tencent/msfmqpsdkbridge/MSFIntChkStrike:<init>	(Lcom/tencent/mobileqq/app/QQAppInterface;I)V
    //   184: invokevirtual 103	com/tencent/mqpsdk/secsrv/MQPIntChkService:a	(ILcom/tencent/mqpsdk/secsrv/MQPIntChkService$IIntChkStrike;)V
    //   187: aload_1
    //   188: iconst_2
    //   189: new 97	com/tencent/msfmqpsdkbridge/MSFIntChkStrike
    //   192: dup
    //   193: aload_0
    //   194: getfield 63	com/tencent/mobileqq/app/SafeCenterPushHandler:b	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   197: iconst_2
    //   198: invokespecial 100	com/tencent/msfmqpsdkbridge/MSFIntChkStrike:<init>	(Lcom/tencent/mobileqq/app/QQAppInterface;I)V
    //   201: invokevirtual 103	com/tencent/mqpsdk/secsrv/MQPIntChkService:a	(ILcom/tencent/mqpsdk/secsrv/MQPIntChkService$IIntChkStrike;)V
    //   204: aload_1
    //   205: iconst_3
    //   206: new 97	com/tencent/msfmqpsdkbridge/MSFIntChkStrike
    //   209: dup
    //   210: aload_0
    //   211: getfield 63	com/tencent/mobileqq/app/SafeCenterPushHandler:b	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   214: iconst_3
    //   215: invokespecial 100	com/tencent/msfmqpsdkbridge/MSFIntChkStrike:<init>	(Lcom/tencent/mobileqq/app/QQAppInterface;I)V
    //   218: invokevirtual 103	com/tencent/mqpsdk/secsrv/MQPIntChkService:a	(ILcom/tencent/mqpsdk/secsrv/MQPIntChkService$IIntChkStrike;)V
    //   221: aload_1
    //   222: ldc 105
    //   224: invokevirtual 108	com/tencent/mqpsdk/secsrv/MQPIntChkService:b	(Ljava/lang/String;)V
    //   227: return
    //   228: aload_0
    //   229: getfield 63	com/tencent/mobileqq/app/SafeCenterPushHandler:b	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   232: bipush 63
    //   234: invokevirtual 71	com/tencent/mobileqq/app/QQAppInterface:a	(I)Lcom/tencent/mobileqq/app/BusinessHandler;
    //   237: checkcast 73	com/tencent/msfmqpsdkbridge/MSFNetTransportProvider
    //   240: astore_1
    //   241: new 75	com/tencent/mqpsdk/MQPSecServiceManager
    //   244: dup
    //   245: aload_0
    //   246: getfield 63	com/tencent/mobileqq/app/SafeCenterPushHandler:b	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   249: invokevirtual 79	com/tencent/mobileqq/app/QQAppInterface:getApp	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   252: invokevirtual 85	com/tencent/qphone/base/util/BaseApplication:getApplicationContext	()Landroid/content/Context;
    //   255: aload_1
    //   256: invokespecial 88	com/tencent/mqpsdk/MQPSecServiceManager:<init>	(Landroid/content/Context;Lcom/tencent/mqpsdk/INetTransportProvider;)V
    //   259: astore_1
    //   260: aload_1
    //   261: ifnull -228 -> 33
    //   264: aload_1
    //   265: ldc 110
    //   267: invokevirtual 93	com/tencent/mqpsdk/MQPSecServiceManager:a	(Ljava/lang/String;)Ljava/lang/Object;
    //   270: checkcast 112	com/tencent/mqpsdk/secsrv/MQPAPPScanService
    //   273: astore_1
    //   274: aload_1
    //   275: ifnull -242 -> 33
    //   278: aload_1
    //   279: aload_3
    //   280: getfield 116	tencent/im/s2c/msgtype0x210/submsgtype0x4a/MsgBody:bytes_data	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   283: invokevirtual 121	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   286: invokevirtual 127	com/tencent/mobileqq/pb/ByteStringMicro:toByteArray	()[B
    //   289: invokevirtual 129	com/tencent/mqpsdk/secsrv/MQPAPPScanService:a	([B)V
    //   292: return
    //   293: aload_3
    //   294: getfield 116	tencent/im/s2c/msgtype0x210/submsgtype0x4a/MsgBody:bytes_data	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   297: invokevirtual 121	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   300: invokevirtual 127	com/tencent/mobileqq/pb/ByteStringMicro:toByteArray	()[B
    //   303: astore_3
    //   304: new 131	com/tencent/ims/AccountSecurityInfo$SecCheckBanner
    //   307: dup
    //   308: invokespecial 132	com/tencent/ims/AccountSecurityInfo$SecCheckBanner:<init>	()V
    //   311: astore_1
    //   312: aload_1
    //   313: aload_3
    //   314: invokevirtual 133	com/tencent/ims/AccountSecurityInfo$SecCheckBanner:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   317: pop
    //   318: aload_1
    //   319: getfield 137	com/tencent/ims/AccountSecurityInfo$SecCheckBanner:str_wording	Lcom/tencent/mobileqq/pb/PBStringField;
    //   322: invokevirtual 142	com/tencent/mobileqq/pb/PBStringField:get	()Ljava/lang/String;
    //   325: astore_3
    //   326: aload_1
    //   327: getfield 145	com/tencent/ims/AccountSecurityInfo$SecCheckBanner:u32_timeToShow	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   330: invokevirtual 57	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   333: istore_2
    //   334: new 147	android/content/Intent
    //   337: dup
    //   338: invokespecial 148	android/content/Intent:<init>	()V
    //   341: astore_1
    //   342: aload_1
    //   343: ldc 150
    //   345: aload_3
    //   346: invokevirtual 154	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   349: pop
    //   350: aload_1
    //   351: ldc 156
    //   353: iload_2
    //   354: invokevirtual 159	android/content/Intent:putExtra	(Ljava/lang/String;I)Landroid/content/Intent;
    //   357: pop
    //   358: aload_0
    //   359: getfield 63	com/tencent/mobileqq/app/SafeCenterPushHandler:b	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   362: aload_1
    //   363: invokevirtual 162	com/tencent/mobileqq/app/QQAppInterface:a	(Landroid/content/Intent;)V
    //   366: return
    //   367: astore_3
    //   368: aload_3
    //   369: invokevirtual 53	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException:printStackTrace	()V
    //   372: goto -54 -> 318
    //   375: invokestatic 165	com/tencent/qphone/base/util/BaseApplication:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   378: invokevirtual 169	com/tencent/qphone/base/util/BaseApplication:getContentResolver	()Landroid/content/ContentResolver;
    //   381: ldc 171
    //   383: invokestatic 177	android/net/Uri:parse	(Ljava/lang/String;)Landroid/net/Uri;
    //   386: iconst_3
    //   387: anewarray 179	java/lang/String
    //   390: dup
    //   391: iconst_0
    //   392: ldc 181
    //   394: aastore
    //   395: dup
    //   396: iconst_1
    //   397: ldc 183
    //   399: aastore
    //   400: dup
    //   401: iconst_2
    //   402: ldc 185
    //   404: aastore
    //   405: ldc 187
    //   407: aconst_null
    //   408: ldc 189
    //   410: invokevirtual 195	android/content/ContentResolver:query	(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   413: astore_1
    //   414: aload_1
    //   415: ifnull +69 -> 484
    //   418: aload_1
    //   419: invokeinterface 200 1 0
    //   424: ifne +60 -> 484
    //   427: aload_1
    //   428: invokeinterface 203 1 0
    //   433: ifeq +19 -> 452
    //   436: aload_1
    //   437: aload_1
    //   438: ldc 185
    //   440: invokeinterface 207 2 0
    //   445: invokeinterface 211 2 0
    //   450: l2i
    //   451: istore_2
    //   452: aload_0
    //   453: getfield 63	com/tencent/mobileqq/app/SafeCenterPushHandler:b	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   456: ldc 213
    //   458: ldc 215
    //   460: aload_0
    //   461: getfield 218	com/tencent/mobileqq/app/SafeCenterPushHandler:a	Lcom/tencent/common/app/AppInterface;
    //   464: invokevirtual 223	com/tencent/common/app/AppInterface:getAccount	()Ljava/lang/String;
    //   467: ldc 225
    //   469: ldc 225
    //   471: iconst_0
    //   472: iload_2
    //   473: ldc 227
    //   475: ldc 227
    //   477: ldc 227
    //   479: ldc 227
    //   481: invokestatic 232	com/tencent/mobileqq/statistics/ReportController:b	(Lcom/tencent/mobileqq/app/QQAppInterface;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   484: aload_1
    //   485: ifnull -452 -> 33
    //   488: aload_1
    //   489: invokeinterface 235 1 0
    //   494: return
    //   495: astore_1
    //   496: aconst_null
    //   497: astore_1
    //   498: aload_1
    //   499: ifnull -466 -> 33
    //   502: aload_1
    //   503: invokeinterface 235 1 0
    //   508: return
    //   509: astore_3
    //   510: aconst_null
    //   511: astore_1
    //   512: aload_1
    //   513: ifnull +9 -> 522
    //   516: aload_1
    //   517: invokeinterface 235 1 0
    //   522: aload_3
    //   523: athrow
    //   524: new 237	com/tencent/qqprotect/sfcfg/QPTxVerifyApkTimerTask
    //   527: dup
    //   528: aload_0
    //   529: getfield 63	com/tencent/mobileqq/app/SafeCenterPushHandler:b	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   532: iconst_1
    //   533: invokespecial 240	com/tencent/qqprotect/sfcfg/QPTxVerifyApkTimerTask:<init>	(Lcom/tencent/mobileqq/app/QQAppInterface;Z)V
    //   536: invokevirtual 241	com/tencent/qqprotect/sfcfg/QPTxVerifyApkTimerTask:a	()V
    //   539: return
    //   540: aload_3
    //   541: getfield 116	tencent/im/s2c/msgtype0x210/submsgtype0x4a/MsgBody:bytes_data	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   544: invokevirtual 121	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   547: ifnull -514 -> 33
    //   550: invokestatic 246	com/tencent/qqprotect/qsec/QSecFramework:a	()Lcom/tencent/qqprotect/qsec/QSecFramework;
    //   553: aload_3
    //   554: getfield 116	tencent/im/s2c/msgtype0x210/submsgtype0x4a/MsgBody:bytes_data	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   557: invokevirtual 121	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   560: invokevirtual 127	com/tencent/mobileqq/pb/ByteStringMicro:toByteArray	()[B
    //   563: invokevirtual 247	com/tencent/qqprotect/qsec/QSecFramework:a	([B)V
    //   566: return
    //   567: astore_3
    //   568: goto -56 -> 512
    //   571: astore_3
    //   572: goto -74 -> 498
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	575	0	this	SafeCenterPushHandler
    //   0	575	1	paramArrayOfByte	byte[]
    //   1	472	2	i	int
    //   9	337	3	localObject1	Object
    //   367	2	3	localInvalidProtocolBufferMicroException	com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException
    //   509	45	3	localObject2	Object
    //   567	1	3	localObject3	Object
    //   571	1	3	localException	java.lang.Exception
    // Exception table:
    //   from	to	target	type
    //   10	16	34	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   312	318	367	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   375	414	495	java/lang/Exception
    //   375	414	509	finally
    //   418	427	567	finally
    //   427	452	567	finally
    //   452	484	567	finally
    //   418	427	571	java/lang/Exception
    //   427	452	571	java/lang/Exception
    //   452	484	571	java/lang/Exception
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.app.SafeCenterPushHandler
 * JD-Core Version:    0.7.0.1
 */