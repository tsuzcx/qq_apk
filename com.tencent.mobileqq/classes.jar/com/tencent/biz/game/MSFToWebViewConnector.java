package com.tencent.biz.game;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.mobileqq.msf.sdk.MsfSdkUtils;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import mqq.app.AppRuntime;

public class MSFToWebViewConnector
{
  protected Context a;
  protected MSFToWebViewConnector.IOnMsgReceiveListener a;
  protected String a;
  ArrayList a;
  protected String b = "";
  protected String c = "";
  
  public String a(String paramString)
  {
    if ((!TextUtils.isEmpty(this.b)) && (this.b.equals(paramString))) {
      return this.c;
    }
    return "";
  }
  
  public void a()
  {
    this.jdField_a_of_type_ComTencentBizGameMSFToWebViewConnector$IOnMsgReceiveListener = null;
    if (this.jdField_a_of_type_JavaUtilArrayList != null) {}
    synchronized (this.jdField_a_of_type_JavaUtilArrayList)
    {
      this.jdField_a_of_type_JavaUtilArrayList.clear();
      this.jdField_a_of_type_JavaUtilArrayList = null;
      return;
    }
  }
  
  /* Error */
  public void a(android.content.Intent paramIntent, com.tencent.qphone.base.remote.FromServiceMsg paramFromServiceMsg)
  {
    // Byte code:
    //   0: aload_2
    //   1: invokevirtual 55	com/tencent/qphone/base/remote/FromServiceMsg:getServiceCmd	()Ljava/lang/String;
    //   4: astore_1
    //   5: aload_1
    //   6: invokestatic 29	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   9: ifne +804 -> 813
    //   12: aload_1
    //   13: ldc 57
    //   15: invokevirtual 35	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   18: ifeq +795 -> 813
    //   21: aload_2
    //   22: invokevirtual 61	com/tencent/qphone/base/remote/FromServiceMsg:getWupBuffer	()[B
    //   25: astore_1
    //   26: aload_1
    //   27: ifnonnull +18 -> 45
    //   30: invokestatic 67	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   33: ifeq +11 -> 44
    //   36: ldc 69
    //   38: iconst_2
    //   39: ldc 71
    //   41: invokestatic 75	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   44: return
    //   45: new 77	OnlinePushPack/SvcReqPushMsg
    //   48: dup
    //   49: invokespecial 78	OnlinePushPack/SvcReqPushMsg:<init>	()V
    //   52: astore 5
    //   54: new 80	com/qq/jce/wup/UniPacket
    //   57: dup
    //   58: iconst_1
    //   59: invokespecial 83	com/qq/jce/wup/UniPacket:<init>	(Z)V
    //   62: astore 6
    //   64: aload 6
    //   66: ldc 85
    //   68: invokevirtual 89	com/qq/jce/wup/UniPacket:setEncodeName	(Ljava/lang/String;)V
    //   71: aload 6
    //   73: aload_1
    //   74: invokevirtual 93	com/qq/jce/wup/UniPacket:decode	([B)V
    //   77: aload 6
    //   79: ldc 95
    //   81: aload 5
    //   83: invokevirtual 99	com/qq/jce/wup/UniPacket:getByClass	(Ljava/lang/String;Ljava/lang/Object;)Ljava/lang/Object;
    //   86: checkcast 77	OnlinePushPack/SvcReqPushMsg
    //   89: astore_1
    //   90: aload_0
    //   91: getfield 39	com/tencent/biz/game/MSFToWebViewConnector:jdField_a_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   94: ifnonnull +14 -> 108
    //   97: aload_0
    //   98: new 41	java/util/ArrayList
    //   101: dup
    //   102: invokespecial 100	java/util/ArrayList:<init>	()V
    //   105: putfield 39	com/tencent/biz/game/MSFToWebViewConnector:jdField_a_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   108: aload_2
    //   109: invokevirtual 104	com/tencent/qphone/base/remote/FromServiceMsg:getRequestSsoSeq	()I
    //   112: istore 4
    //   114: aload_0
    //   115: getfield 39	com/tencent/biz/game/MSFToWebViewConnector:jdField_a_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   118: ifnull +737 -> 855
    //   121: aload_0
    //   122: getfield 39	com/tencent/biz/game/MSFToWebViewConnector:jdField_a_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   125: astore 5
    //   127: aload 5
    //   129: monitorenter
    //   130: aload_0
    //   131: getfield 39	com/tencent/biz/game/MSFToWebViewConnector:jdField_a_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   134: invokevirtual 108	java/util/ArrayList:iterator	()Ljava/util/Iterator;
    //   137: astore 6
    //   139: aload 6
    //   141: invokeinterface 113 1 0
    //   146: ifeq +704 -> 850
    //   149: aload 6
    //   151: invokeinterface 117 1 0
    //   156: checkcast 119	kmy
    //   159: astore 7
    //   161: aload 7
    //   163: getfield 122	kmy:jdField_a_of_type_Int	I
    //   166: iload 4
    //   168: if_icmpne -29 -> 139
    //   171: aload 7
    //   173: getfield 125	kmy:jdField_a_of_type_Long	J
    //   176: aload_1
    //   177: getfield 128	OnlinePushPack/SvcReqPushMsg:lUin	J
    //   180: lcmp
    //   181: ifne -42 -> 139
    //   184: iconst_1
    //   185: istore_3
    //   186: aload 5
    //   188: monitorexit
    //   189: aload_0
    //   190: getfield 39	com/tencent/biz/game/MSFToWebViewConnector:jdField_a_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   193: ifnull +186 -> 379
    //   196: aload_0
    //   197: getfield 39	com/tencent/biz/game/MSFToWebViewConnector:jdField_a_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   200: astore 5
    //   202: aload 5
    //   204: monitorenter
    //   205: iload_3
    //   206: ifeq +89 -> 295
    //   209: invokestatic 67	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   212: ifeq +29 -> 241
    //   215: ldc 69
    //   217: iconst_2
    //   218: new 130	java/lang/StringBuilder
    //   221: dup
    //   222: invokespecial 131	java/lang/StringBuilder:<init>	()V
    //   225: ldc 133
    //   227: invokevirtual 137	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   230: iload 4
    //   232: invokevirtual 140	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   235: invokevirtual 143	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   238: invokestatic 75	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   241: aload 5
    //   243: monitorexit
    //   244: return
    //   245: astore_1
    //   246: aload 5
    //   248: monitorexit
    //   249: aload_1
    //   250: athrow
    //   251: astore_1
    //   252: invokestatic 67	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   255: ifeq -211 -> 44
    //   258: ldc 69
    //   260: iconst_2
    //   261: aload_1
    //   262: invokevirtual 146	java/lang/RuntimeException:getMessage	()Ljava/lang/String;
    //   265: aload_1
    //   266: invokestatic 149	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   269: return
    //   270: astore_1
    //   271: invokestatic 67	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   274: ifeq -230 -> 44
    //   277: ldc 69
    //   279: iconst_2
    //   280: aload_1
    //   281: invokevirtual 150	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   284: aload_1
    //   285: invokestatic 149	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   288: return
    //   289: astore_1
    //   290: aload 5
    //   292: monitorexit
    //   293: aload_1
    //   294: athrow
    //   295: aload_0
    //   296: getfield 39	com/tencent/biz/game/MSFToWebViewConnector:jdField_a_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   299: invokevirtual 153	java/util/ArrayList:size	()I
    //   302: bipush 60
    //   304: if_icmpge +365 -> 669
    //   307: new 119	kmy
    //   310: dup
    //   311: aload_0
    //   312: aconst_null
    //   313: invokespecial 156	kmy:<init>	(Lcom/tencent/biz/game/MSFToWebViewConnector;Lkmx;)V
    //   316: astore 6
    //   318: aload 6
    //   320: iload 4
    //   322: putfield 122	kmy:jdField_a_of_type_Int	I
    //   325: aload 6
    //   327: aload_1
    //   328: getfield 128	OnlinePushPack/SvcReqPushMsg:lUin	J
    //   331: putfield 125	kmy:jdField_a_of_type_Long	J
    //   334: aload_0
    //   335: getfield 39	com/tencent/biz/game/MSFToWebViewConnector:jdField_a_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   338: aload 6
    //   340: invokevirtual 159	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   343: pop
    //   344: invokestatic 67	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   347: ifeq +29 -> 376
    //   350: ldc 69
    //   352: iconst_2
    //   353: new 130	java/lang/StringBuilder
    //   356: dup
    //   357: invokespecial 131	java/lang/StringBuilder:<init>	()V
    //   360: ldc 161
    //   362: invokevirtual 137	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   365: iload 4
    //   367: invokevirtual 140	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   370: invokevirtual 143	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   373: invokestatic 75	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   376: aload 5
    //   378: monitorexit
    //   379: new 41	java/util/ArrayList
    //   382: dup
    //   383: invokespecial 100	java/util/ArrayList:<init>	()V
    //   386: astore 5
    //   388: aload_1
    //   389: getfield 164	OnlinePushPack/SvcReqPushMsg:vMsgInfos	Ljava/util/ArrayList;
    //   392: astore 6
    //   394: aload 6
    //   396: ifnull +335 -> 731
    //   399: aload 6
    //   401: invokevirtual 153	java/util/ArrayList:size	()I
    //   404: ifle +327 -> 731
    //   407: aload 6
    //   409: invokevirtual 108	java/util/ArrayList:iterator	()Ljava/util/Iterator;
    //   412: astore 6
    //   414: aload 6
    //   416: invokeinterface 113 1 0
    //   421: ifeq +325 -> 746
    //   424: aload 6
    //   426: invokeinterface 117 1 0
    //   431: checkcast 166	OnlinePushPack/MsgInfo
    //   434: astore 7
    //   436: sipush 528
    //   439: aload 7
    //   441: getfield 170	OnlinePushPack/MsgInfo:shMsgType	S
    //   444: if_icmpne +269 -> 713
    //   447: new 172	OnlinePushPack/DelMsgInfo
    //   450: dup
    //   451: invokespecial 173	OnlinePushPack/DelMsgInfo:<init>	()V
    //   454: astore 8
    //   456: aload 8
    //   458: aload 7
    //   460: getfield 176	OnlinePushPack/MsgInfo:lFromUin	J
    //   463: putfield 177	OnlinePushPack/DelMsgInfo:lFromUin	J
    //   466: aload 8
    //   468: aload 7
    //   470: getfield 180	OnlinePushPack/MsgInfo:shMsgSeq	S
    //   473: putfield 181	OnlinePushPack/DelMsgInfo:shMsgSeq	S
    //   476: aload 8
    //   478: aload 7
    //   480: getfield 184	OnlinePushPack/MsgInfo:uMsgTime	J
    //   483: putfield 185	OnlinePushPack/DelMsgInfo:uMsgTime	J
    //   486: aload 8
    //   488: aload 7
    //   490: getfield 189	OnlinePushPack/MsgInfo:vMsgCookies	[B
    //   493: putfield 190	OnlinePushPack/DelMsgInfo:vMsgCookies	[B
    //   496: aload 5
    //   498: aload 8
    //   500: invokevirtual 159	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   503: pop
    //   504: new 192	com/qq/taf/jce/JceInputStream
    //   507: dup
    //   508: aload 7
    //   510: getfield 195	OnlinePushPack/MsgInfo:vMsg	[B
    //   513: invokespecial 197	com/qq/taf/jce/JceInputStream:<init>	([B)V
    //   516: astore 8
    //   518: aload 8
    //   520: ldc 85
    //   522: invokevirtual 201	com/qq/taf/jce/JceInputStream:setServerEncoding	(Ljava/lang/String;)I
    //   525: pop
    //   526: new 203	IMMsgBodyPack/MsgType0x210
    //   529: dup
    //   530: invokespecial 204	IMMsgBodyPack/MsgType0x210:<init>	()V
    //   533: astore 7
    //   535: aload 7
    //   537: aload 8
    //   539: invokevirtual 208	IMMsgBodyPack/MsgType0x210:readFrom	(Lcom/qq/taf/jce/JceInputStream;)V
    //   542: aload 7
    //   544: ifnull -130 -> 414
    //   547: aload 7
    //   549: getfield 211	IMMsgBodyPack/MsgType0x210:uSubMsgType	J
    //   552: ldc2_w 212
    //   555: lcmp
    //   556: ifne -142 -> 414
    //   559: aload 7
    //   561: getfield 216	IMMsgBodyPack/MsgType0x210:vProtobuf	[B
    //   564: ifnull -150 -> 414
    //   567: new 218	tencent/im/s2c/msgtype0x210/submsgtype0x42/Submsgtype0x42$GameStatusSync
    //   570: dup
    //   571: invokespecial 219	tencent/im/s2c/msgtype0x210/submsgtype0x42/Submsgtype0x42$GameStatusSync:<init>	()V
    //   574: astore 8
    //   576: aload 8
    //   578: aload 7
    //   580: getfield 216	IMMsgBodyPack/MsgType0x210:vProtobuf	[B
    //   583: invokevirtual 223	tencent/im/s2c/msgtype0x210/submsgtype0x42/Submsgtype0x42$GameStatusSync:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   586: pop
    //   587: aload 8
    //   589: getfield 227	tencent/im/s2c/msgtype0x210/submsgtype0x42/Submsgtype0x42$GameStatusSync:uint32_game_appid	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   592: invokevirtual 232	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   595: istore_3
    //   596: aload 8
    //   598: getfield 236	tencent/im/s2c/msgtype0x210/submsgtype0x42/Submsgtype0x42$GameStatusSync:bytes_data	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   601: invokevirtual 241	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   604: astore 7
    //   606: aload_0
    //   607: getfield 37	com/tencent/biz/game/MSFToWebViewConnector:jdField_a_of_type_ComTencentBizGameMSFToWebViewConnector$IOnMsgReceiveListener	Lcom/tencent/biz/game/MSFToWebViewConnector$IOnMsgReceiveListener;
    //   610: ifnull +85 -> 695
    //   613: aload 7
    //   615: ifnull +80 -> 695
    //   618: new 31	java/lang/String
    //   621: dup
    //   622: aload 7
    //   624: invokevirtual 246	com/tencent/mobileqq/pb/ByteStringMicro:toByteArray	()[B
    //   627: invokespecial 247	java/lang/String:<init>	([B)V
    //   630: astore 7
    //   632: aload_0
    //   633: getfield 37	com/tencent/biz/game/MSFToWebViewConnector:jdField_a_of_type_ComTencentBizGameMSFToWebViewConnector$IOnMsgReceiveListener	Lcom/tencent/biz/game/MSFToWebViewConnector$IOnMsgReceiveListener;
    //   636: iload_3
    //   637: aload 7
    //   639: invokeinterface 252 3 0
    //   644: goto -230 -> 414
    //   647: astore 7
    //   649: invokestatic 67	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   652: ifeq -238 -> 414
    //   655: ldc 69
    //   657: iconst_2
    //   658: aload 7
    //   660: invokevirtual 150	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   663: invokestatic 75	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   666: goto -252 -> 414
    //   669: invokestatic 67	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   672: ifeq +11 -> 683
    //   675: ldc 69
    //   677: iconst_2
    //   678: ldc 254
    //   680: invokestatic 75	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   683: aload_0
    //   684: getfield 39	com/tencent/biz/game/MSFToWebViewConnector:jdField_a_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   687: iconst_0
    //   688: invokevirtual 258	java/util/ArrayList:remove	(I)Ljava/lang/Object;
    //   691: pop
    //   692: goto -316 -> 376
    //   695: invokestatic 67	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   698: ifeq -284 -> 414
    //   701: ldc 69
    //   703: iconst_2
    //   704: ldc_w 260
    //   707: invokestatic 75	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   710: goto -296 -> 414
    //   713: invokestatic 67	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   716: ifeq -302 -> 414
    //   719: ldc 69
    //   721: iconst_2
    //   722: ldc_w 262
    //   725: invokestatic 75	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   728: goto -314 -> 414
    //   731: invokestatic 67	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   734: ifeq +12 -> 746
    //   737: ldc 69
    //   739: iconst_2
    //   740: ldc_w 264
    //   743: invokestatic 75	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   746: aload 5
    //   748: invokevirtual 153	java/util/ArrayList:size	()I
    //   751: ifle -707 -> 44
    //   754: new 266	OnlinePushPack/SvcRespPushMsg
    //   757: dup
    //   758: invokespecial 267	OnlinePushPack/SvcRespPushMsg:<init>	()V
    //   761: astore 6
    //   763: aload_2
    //   764: invokevirtual 104	com/tencent/qphone/base/remote/FromServiceMsg:getRequestSsoSeq	()I
    //   767: istore_3
    //   768: aload 6
    //   770: aload_1
    //   771: getfield 128	OnlinePushPack/SvcReqPushMsg:lUin	J
    //   774: putfield 268	OnlinePushPack/SvcRespPushMsg:lUin	J
    //   777: aload 6
    //   779: aload_1
    //   780: getfield 271	OnlinePushPack/SvcReqPushMsg:svrip	I
    //   783: putfield 272	OnlinePushPack/SvcRespPushMsg:svrip	I
    //   786: aload 6
    //   788: aload 5
    //   790: putfield 275	OnlinePushPack/SvcRespPushMsg:vDelInfos	Ljava/util/ArrayList;
    //   793: aload_0
    //   794: getfield 37	com/tencent/biz/game/MSFToWebViewConnector:jdField_a_of_type_ComTencentBizGameMSFToWebViewConnector$IOnMsgReceiveListener	Lcom/tencent/biz/game/MSFToWebViewConnector$IOnMsgReceiveListener;
    //   797: ifnull -753 -> 44
    //   800: aload_0
    //   801: getfield 37	com/tencent/biz/game/MSFToWebViewConnector:jdField_a_of_type_ComTencentBizGameMSFToWebViewConnector$IOnMsgReceiveListener	Lcom/tencent/biz/game/MSFToWebViewConnector$IOnMsgReceiveListener;
    //   804: iload_3
    //   805: aload 6
    //   807: invokeinterface 278 3 0
    //   812: return
    //   813: aload_1
    //   814: ifnull -770 -> 44
    //   817: invokestatic 67	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   820: ifeq -776 -> 44
    //   823: ldc 69
    //   825: iconst_2
    //   826: new 130	java/lang/StringBuilder
    //   829: dup
    //   830: invokespecial 131	java/lang/StringBuilder:<init>	()V
    //   833: ldc_w 280
    //   836: invokevirtual 137	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   839: aload_1
    //   840: invokevirtual 137	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   843: invokevirtual 143	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   846: invokestatic 75	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   849: return
    //   850: iconst_0
    //   851: istore_3
    //   852: goto -666 -> 186
    //   855: iconst_0
    //   856: istore_3
    //   857: goto -668 -> 189
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	860	0	this	MSFToWebViewConnector
    //   0	860	1	paramIntent	android.content.Intent
    //   0	860	2	paramFromServiceMsg	com.tencent.qphone.base.remote.FromServiceMsg
    //   185	672	3	i	int
    //   112	254	4	j	int
    //   62	744	6	localObject2	Object
    //   159	479	7	localObject3	Object
    //   647	12	7	localException	java.lang.Exception
    //   454	143	8	localObject4	Object
    // Exception table:
    //   from	to	target	type
    //   209	241	245	finally
    //   241	244	245	finally
    //   246	249	245	finally
    //   295	376	245	finally
    //   376	379	245	finally
    //   669	683	245	finally
    //   683	692	245	finally
    //   64	90	251	java/lang/RuntimeException
    //   64	90	270	java/lang/Exception
    //   130	139	289	finally
    //   139	184	289	finally
    //   186	189	289	finally
    //   290	293	289	finally
    //   504	542	647	java/lang/Exception
    //   547	613	647	java/lang/Exception
    //   618	644	647	java/lang/Exception
    //   695	710	647	java/lang/Exception
  }
  
  public void a(String paramString1, String paramString2, AppRuntime paramAppRuntime, Context paramContext, MSFToWebViewConnector.IOnMsgReceiveListener paramIOnMsgReceiveListener)
  {
    this.b = paramString1;
    this.c = paramString2;
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_ComTencentBizGameMSFToWebViewConnector$IOnMsgReceiveListener = paramIOnMsgReceiveListener;
    this.jdField_a_of_type_JavaLangString = MsfSdkUtils.getProcessName(paramContext);
    if (this.jdField_a_of_type_JavaLangString.equals("com.tencent.mobileqq:MSF")) {
      return;
    }
    a(paramAppRuntime);
  }
  
  public void a(AppRuntime paramAppRuntime)
  {
    if (paramAppRuntime.isLogin()) {
      paramAppRuntime.setCmdCallbacker();
    }
    while (!QLog.isColorLevel()) {
      return;
    }
    QLog.d("MSFToWebViewConnector", 2, "not login");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.game.MSFToWebViewConnector
 * JD-Core Version:    0.7.0.1
 */