import android.content.Intent;
import android.text.TextUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.onlinestatus.OnlineStatusExtInfoServlet.1;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.util.QLog;
import java.nio.ByteBuffer;
import java.util.List;
import mqq.app.MSFServlet;
import mqq.app.NewIntent;
import mqq.app.Packet;
import tencent.im.oidb.cmd0xe84.oidb_0xe84.Condition;
import tencent.im.oidb.cmd0xe84.oidb_0xe84.ReqBody;
import tencent.im.oidb.oidb_sso.OIDBSSOPkg;

public class azbt
  extends MSFServlet
{
  public static NewIntent a(QQAppInterface paramQQAppInterface, String paramString)
  {
    NewIntent localNewIntent = new NewIntent(paramQQAppInterface.getApplication(), azbt.class);
    localNewIntent.putExtra("param_request_type", 1);
    localNewIntent.putExtra("param_constellation", paramString);
    localNewIntent.putExtra("param_today_date", azeu.b());
    localNewIntent.putExtra("param_tomorrow_date", azeu.c());
    paramQQAppInterface.startServlet(localNewIntent);
    if (QLog.isColorLevel()) {
      QLog.d("OnlineStatusExtInfoServlet", 2, new Object[] { "requestConstellationTrendTwoDay: invoked. ", " constellation: ", paramString });
    }
    return localNewIntent;
  }
  
  /* Error */
  private void a(Intent paramIntent, FromServiceMsg paramFromServiceMsg)
  {
    // Byte code:
    //   0: aload_1
    //   1: ldc 30
    //   3: invokevirtual 77	android/content/Intent:getStringExtra	(Ljava/lang/String;)Ljava/lang/String;
    //   6: astore 10
    //   8: aload_1
    //   9: ldc 35
    //   11: invokevirtual 77	android/content/Intent:getStringExtra	(Ljava/lang/String;)Ljava/lang/String;
    //   14: astore 7
    //   16: invokestatic 56	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   19: ifeq +33 -> 52
    //   22: ldc 58
    //   24: iconst_2
    //   25: iconst_4
    //   26: anewarray 60	java/lang/Object
    //   29: dup
    //   30: iconst_0
    //   31: ldc 79
    //   33: aastore
    //   34: dup
    //   35: iconst_1
    //   36: aload 10
    //   38: aastore
    //   39: dup
    //   40: iconst_2
    //   41: ldc 81
    //   43: aastore
    //   44: dup
    //   45: iconst_3
    //   46: aload 7
    //   48: aastore
    //   49: invokestatic 68	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;I[Ljava/lang/Object;)V
    //   52: iconst_0
    //   53: istore 6
    //   55: iconst_0
    //   56: istore 5
    //   58: new 83	android/os/Bundle
    //   61: dup
    //   62: invokespecial 84	android/os/Bundle:<init>	()V
    //   65: astore 9
    //   67: aload_2
    //   68: invokevirtual 89	com/tencent/qphone/base/remote/FromServiceMsg:isSuccess	()Z
    //   71: ifeq +927 -> 998
    //   74: new 91	tencent/im/oidb/oidb_sso$OIDBSSOPkg
    //   77: dup
    //   78: invokespecial 92	tencent/im/oidb/oidb_sso$OIDBSSOPkg:<init>	()V
    //   81: astore 7
    //   83: aload_2
    //   84: invokevirtual 96	com/tencent/qphone/base/remote/FromServiceMsg:getWupBuffer	()[B
    //   87: invokestatic 102	java/nio/ByteBuffer:wrap	([B)Ljava/nio/ByteBuffer;
    //   90: astore_2
    //   91: aload_2
    //   92: invokevirtual 106	java/nio/ByteBuffer:getInt	()I
    //   95: iconst_4
    //   96: isub
    //   97: newarray byte
    //   99: astore 8
    //   101: aload_2
    //   102: aload 8
    //   104: invokevirtual 109	java/nio/ByteBuffer:get	([B)Ljava/nio/ByteBuffer;
    //   107: pop
    //   108: aload 7
    //   110: aload 8
    //   112: invokevirtual 113	tencent/im/oidb/oidb_sso$OIDBSSOPkg:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   115: pop
    //   116: aload 7
    //   118: astore 8
    //   120: aload 8
    //   122: getfield 117	tencent/im/oidb/oidb_sso$OIDBSSOPkg:uint32_result	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   125: invokevirtual 121	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   128: istore_3
    //   129: invokestatic 56	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   132: ifeq +25 -> 157
    //   135: ldc 58
    //   137: iconst_2
    //   138: iconst_2
    //   139: anewarray 60	java/lang/Object
    //   142: dup
    //   143: iconst_0
    //   144: ldc 123
    //   146: aastore
    //   147: dup
    //   148: iconst_1
    //   149: iload_3
    //   150: invokestatic 129	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   153: aastore
    //   154: invokestatic 68	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;I[Ljava/lang/Object;)V
    //   157: iload 5
    //   159: istore 4
    //   161: iload_3
    //   162: ifne +697 -> 859
    //   165: iload 5
    //   167: istore 4
    //   169: aload 8
    //   171: getfield 133	tencent/im/oidb/oidb_sso$OIDBSSOPkg:bytes_bodybuffer	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   174: invokevirtual 138	com/tencent/mobileqq/pb/PBBytesField:has	()Z
    //   177: ifeq +682 -> 859
    //   180: iload 5
    //   182: istore 4
    //   184: aload 8
    //   186: getfield 133	tencent/im/oidb/oidb_sso$OIDBSSOPkg:bytes_bodybuffer	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   189: invokevirtual 141	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   192: ifnull +667 -> 859
    //   195: aload 8
    //   197: getfield 133	tencent/im/oidb/oidb_sso$OIDBSSOPkg:bytes_bodybuffer	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   200: invokevirtual 141	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   203: invokevirtual 146	com/tencent/mobileqq/pb/ByteStringMicro:toByteArray	()[B
    //   206: astore 7
    //   208: aload_0
    //   209: invokevirtual 150	azbt:getAppRuntime	()Lmqq/app/AppRuntime;
    //   212: checkcast 15	com/tencent/mobileqq/app/QQAppInterface
    //   215: astore_2
    //   216: new 152	tencent/im/oidb/cmd0xe84/oidb_0xe84$RspBody
    //   219: dup
    //   220: invokespecial 153	tencent/im/oidb/cmd0xe84/oidb_0xe84$RspBody:<init>	()V
    //   223: astore 8
    //   225: aload 8
    //   227: aload 7
    //   229: invokevirtual 154	tencent/im/oidb/cmd0xe84/oidb_0xe84$RspBody:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   232: pop
    //   233: aload 8
    //   235: getfield 157	tencent/im/oidb/cmd0xe84/oidb_0xe84$RspBody:uint32_interval	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   238: invokevirtual 121	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   241: istore_3
    //   242: aload_2
    //   243: iload_3
    //   244: invokestatic 160	azeu:a	(Lcom/tencent/mobileqq/app/QQAppInterface;I)V
    //   247: aload 8
    //   249: getfield 164	tencent/im/oidb/cmd0xe84/oidb_0xe84$RspBody:msg_custom_data	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   252: invokevirtual 169	com/tencent/mobileqq/pb/PBRepeatMessageField:get	()Ljava/util/List;
    //   255: astore 8
    //   257: aload 8
    //   259: invokeinterface 174 1 0
    //   264: iconst_2
    //   265: if_icmpne +686 -> 951
    //   268: aload 8
    //   270: iconst_0
    //   271: invokeinterface 177 2 0
    //   276: checkcast 179	tencent/im/oidb/cmd0xe84/oidb_0xe84$CustomData
    //   279: astore 14
    //   281: aload 14
    //   283: getfield 182	tencent/im/oidb/cmd0xe84/oidb_0xe84$CustomData:bytes_data	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   286: invokevirtual 141	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   289: invokevirtual 146	com/tencent/mobileqq/pb/ByteStringMicro:toByteArray	()[B
    //   292: astore 7
    //   294: aload 14
    //   296: getfield 185	tencent/im/oidb/cmd0xe84/oidb_0xe84$CustomData:bytes_jump_link	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   299: invokevirtual 141	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   302: invokevirtual 146	com/tencent/mobileqq/pb/ByteStringMicro:toByteArray	()[B
    //   305: astore 13
    //   307: new 187	java/lang/String
    //   310: dup
    //   311: aload 14
    //   313: getfield 190	tencent/im/oidb/cmd0xe84/oidb_0xe84$CustomData:bytes_png_link	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   316: invokevirtual 141	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   319: invokevirtual 146	com/tencent/mobileqq/pb/ByteStringMicro:toByteArray	()[B
    //   322: invokespecial 193	java/lang/String:<init>	([B)V
    //   325: astore 11
    //   327: new 187	java/lang/String
    //   330: dup
    //   331: aload 14
    //   333: getfield 196	tencent/im/oidb/cmd0xe84/oidb_0xe84$CustomData:bytes_icon_link	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   336: invokevirtual 141	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   339: invokevirtual 146	com/tencent/mobileqq/pb/ByteStringMicro:toByteArray	()[B
    //   342: invokespecial 193	java/lang/String:<init>	([B)V
    //   345: astore 12
    //   347: new 187	java/lang/String
    //   350: dup
    //   351: aload 14
    //   353: getfield 199	tencent/im/oidb/cmd0xe84/oidb_0xe84$CustomData:bytes_text_color	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   356: invokevirtual 141	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   359: invokevirtual 146	com/tencent/mobileqq/pb/ByteStringMicro:toByteArray	()[B
    //   362: invokespecial 193	java/lang/String:<init>	([B)V
    //   365: astore 14
    //   367: new 187	java/lang/String
    //   370: dup
    //   371: aload 7
    //   373: invokespecial 193	java/lang/String:<init>	([B)V
    //   376: astore 7
    //   378: new 187	java/lang/String
    //   381: dup
    //   382: aload 13
    //   384: invokespecial 193	java/lang/String:<init>	([B)V
    //   387: astore 16
    //   389: new 187	java/lang/String
    //   392: dup
    //   393: aload 8
    //   395: iconst_1
    //   396: invokeinterface 177 2 0
    //   401: checkcast 179	tencent/im/oidb/cmd0xe84/oidb_0xe84$CustomData
    //   404: getfield 182	tencent/im/oidb/cmd0xe84/oidb_0xe84$CustomData:bytes_data	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   407: invokevirtual 141	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   410: invokevirtual 146	com/tencent/mobileqq/pb/ByteStringMicro:toByteArray	()[B
    //   413: invokespecial 193	java/lang/String:<init>	([B)V
    //   416: astore 13
    //   418: aload_2
    //   419: invokestatic 202	azeu:a	(Lcom/tencent/mobileqq/app/QQAppInterface;)Ljava/lang/String;
    //   422: astore 15
    //   424: aload 7
    //   426: aload 15
    //   428: invokevirtual 206	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   431: ifne +472 -> 903
    //   434: iconst_1
    //   435: istore 4
    //   437: invokestatic 56	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   440: ifeq +53 -> 493
    //   443: ldc 58
    //   445: iconst_2
    //   446: bipush 7
    //   448: anewarray 60	java/lang/Object
    //   451: dup
    //   452: iconst_0
    //   453: ldc 208
    //   455: aastore
    //   456: dup
    //   457: iconst_1
    //   458: ldc 210
    //   460: aastore
    //   461: dup
    //   462: iconst_2
    //   463: iload 4
    //   465: invokestatic 215	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   468: aastore
    //   469: dup
    //   470: iconst_3
    //   471: ldc 217
    //   473: aastore
    //   474: dup
    //   475: iconst_4
    //   476: aload 15
    //   478: aastore
    //   479: dup
    //   480: iconst_5
    //   481: ldc 219
    //   483: aastore
    //   484: dup
    //   485: bipush 6
    //   487: aload 7
    //   489: aastore
    //   490: invokestatic 68	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;I[Ljava/lang/Object;)V
    //   493: aload_2
    //   494: getstatic 225	com/tencent/mobileqq/app/QQManagerFactory:FRIENDS_MANAGER	I
    //   497: invokevirtual 229	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   500: astore 8
    //   502: aload 8
    //   504: instanceof 231
    //   507: ifeq +57 -> 564
    //   510: aload 8
    //   512: checkcast 231	anvk
    //   515: astore 17
    //   517: aload 17
    //   519: aload_2
    //   520: invokevirtual 234	com/tencent/mobileqq/app/QQAppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   523: invokevirtual 237	anvk:d	(Ljava/lang/String;)Lcom/tencent/mobileqq/data/Friends;
    //   526: astore 18
    //   528: aload 18
    //   530: aload 12
    //   532: putfield 243	com/tencent/mobileqq/data/Friends:constellationIconUrl	Ljava/lang/String;
    //   535: aload 18
    //   537: aload 16
    //   539: putfield 246	com/tencent/mobileqq/data/Friends:constellationJumpUrl	Ljava/lang/String;
    //   542: aload 18
    //   544: aload 11
    //   546: putfield 249	com/tencent/mobileqq/data/Friends:constellationBgImageUrl	Ljava/lang/String;
    //   549: aload 18
    //   551: invokestatic 41	azeu:b	()Ljava/lang/String;
    //   554: putfield 252	com/tencent/mobileqq/data/Friends:constellationDateStr	Ljava/lang/String;
    //   557: aload 17
    //   559: aload 18
    //   561: invokevirtual 255	anvk:a	(Lcom/tencent/mobileqq/data/Friends;)V
    //   564: aload_2
    //   565: iload_3
    //   566: invokestatic 160	azeu:a	(Lcom/tencent/mobileqq/app/QQAppInterface;I)V
    //   569: aload_2
    //   570: aload 7
    //   572: invokestatic 258	azeu:a	(Lcom/tencent/mobileqq/app/QQAppInterface;Ljava/lang/String;)V
    //   575: aload_2
    //   576: aload 14
    //   578: invokestatic 260	azeu:b	(Lcom/tencent/mobileqq/app/QQAppInterface;Ljava/lang/String;)V
    //   581: aload 8
    //   583: instanceof 231
    //   586: ifeq +189 -> 775
    //   589: aload 8
    //   591: checkcast 231	anvk
    //   594: astore 11
    //   596: aload 11
    //   598: aload_2
    //   599: invokevirtual 234	com/tencent/mobileqq/app/QQAppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   602: invokevirtual 237	anvk:d	(Ljava/lang/String;)Lcom/tencent/mobileqq/data/Friends;
    //   605: astore 12
    //   607: aload 12
    //   609: getfield 263	com/tencent/mobileqq/data/Friends:constellationTodayTrend	Ljava/lang/String;
    //   612: astore 14
    //   614: iload 4
    //   616: ifne +19 -> 635
    //   619: aload 14
    //   621: invokestatic 269	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   624: ifne +11 -> 635
    //   627: aload 15
    //   629: invokestatic 269	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   632: ifeq +122 -> 754
    //   635: new 271	azet
    //   638: dup
    //   639: invokespecial 272	azet:<init>	()V
    //   642: aload 7
    //   644: invokevirtual 275	azet:a	(Ljava/lang/String;)Lazet;
    //   647: invokevirtual 277	azet:a	()Ljava/lang/String;
    //   650: astore 7
    //   652: new 271	azet
    //   655: dup
    //   656: invokespecial 272	azet:<init>	()V
    //   659: aload 13
    //   661: invokevirtual 275	azet:a	(Ljava/lang/String;)Lazet;
    //   664: invokevirtual 277	azet:a	()Ljava/lang/String;
    //   667: astore 13
    //   669: aload 7
    //   671: invokestatic 269	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   674: ifne +235 -> 909
    //   677: aload 12
    //   679: new 279	java/lang/StringBuilder
    //   682: dup
    //   683: invokespecial 280	java/lang/StringBuilder:<init>	()V
    //   686: aload 10
    //   688: invokevirtual 284	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   691: ldc_w 286
    //   694: invokevirtual 284	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   697: aload 7
    //   699: invokevirtual 284	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   702: invokevirtual 289	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   705: putfield 263	com/tencent/mobileqq/data/Friends:constellationTodayTrend	Ljava/lang/String;
    //   708: aload 13
    //   710: invokestatic 269	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   713: ifne +222 -> 935
    //   716: aload 12
    //   718: new 279	java/lang/StringBuilder
    //   721: dup
    //   722: invokespecial 280	java/lang/StringBuilder:<init>	()V
    //   725: aload 10
    //   727: invokevirtual 284	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   730: ldc_w 286
    //   733: invokevirtual 284	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   736: aload 13
    //   738: invokevirtual 284	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   741: invokevirtual 289	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   744: putfield 292	com/tencent/mobileqq/data/Friends:constellationTomorrowTrend	Ljava/lang/String;
    //   747: aload 11
    //   749: aload 12
    //   751: invokevirtual 255	anvk:a	(Lcom/tencent/mobileqq/data/Friends;)V
    //   754: aload_2
    //   755: invokevirtual 296	com/tencent/mobileqq/app/QQAppInterface:getExtOnlineStatus	()J
    //   758: ldc2_w 297
    //   761: lcmp
    //   762: ifne +13 -> 775
    //   765: getstatic 303	azev:a	Lazev;
    //   768: aload_2
    //   769: sipush 1040
    //   772: invokevirtual 304	azev:a	(Lcom/tencent/mobileqq/app/QQAppInterface;I)V
    //   775: aload 8
    //   777: instanceof 231
    //   780: ifeq +76 -> 856
    //   783: aload_2
    //   784: aload_2
    //   785: invokevirtual 234	com/tencent/mobileqq/app/QQAppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   788: invokestatic 307	azeu:a	(Lcom/tencent/mobileqq/app/QQAppInterface;Ljava/lang/String;)Ljava/lang/String;
    //   791: astore 7
    //   793: aload 7
    //   795: ldc_w 309
    //   798: invokevirtual 313	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   801: astore_2
    //   802: aload_2
    //   803: arraylength
    //   804: iconst_2
    //   805: if_icmpne +139 -> 944
    //   808: aload_2
    //   809: iconst_1
    //   810: aaload
    //   811: invokevirtual 316	java/lang/String:trim	()Ljava/lang/String;
    //   814: astore_2
    //   815: aload 9
    //   817: ldc_w 318
    //   820: aload_2
    //   821: invokevirtual 322	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   824: invokestatic 56	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   827: ifeq +29 -> 856
    //   830: ldc 58
    //   832: iconst_2
    //   833: iconst_3
    //   834: anewarray 60	java/lang/Object
    //   837: dup
    //   838: iconst_0
    //   839: ldc 208
    //   841: aastore
    //   842: dup
    //   843: iconst_1
    //   844: ldc_w 324
    //   847: aastore
    //   848: dup
    //   849: iconst_2
    //   850: aload 7
    //   852: aastore
    //   853: invokestatic 68	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;I[Ljava/lang/Object;)V
    //   856: iconst_1
    //   857: istore 4
    //   859: aload_0
    //   860: aload_1
    //   861: iconst_1
    //   862: iload 4
    //   864: aload 9
    //   866: ldc_w 326
    //   869: invokevirtual 330	azbt:notifyObserver	(Landroid/content/Intent;IZLandroid/os/Bundle;Ljava/lang/Class;)V
    //   872: return
    //   873: astore 7
    //   875: aconst_null
    //   876: astore_2
    //   877: aload_2
    //   878: astore 8
    //   880: invokestatic 56	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   883: ifeq -763 -> 120
    //   886: ldc 58
    //   888: iconst_2
    //   889: ldc_w 332
    //   892: aload 7
    //   894: invokestatic 335	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   897: aload_2
    //   898: astore 8
    //   900: goto -780 -> 120
    //   903: iconst_0
    //   904: istore 4
    //   906: goto -469 -> 437
    //   909: aload 12
    //   911: aconst_null
    //   912: putfield 263	com/tencent/mobileqq/data/Friends:constellationTodayTrend	Ljava/lang/String;
    //   915: goto -207 -> 708
    //   918: astore_2
    //   919: iconst_1
    //   920: istore 4
    //   922: ldc 58
    //   924: iconst_1
    //   925: ldc_w 337
    //   928: aload_2
    //   929: invokestatic 340	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   932: goto -73 -> 859
    //   935: aload 12
    //   937: aconst_null
    //   938: putfield 292	com/tencent/mobileqq/data/Friends:constellationTomorrowTrend	Ljava/lang/String;
    //   941: goto -194 -> 747
    //   944: ldc_w 342
    //   947: astore_2
    //   948: goto -133 -> 815
    //   951: invokestatic 56	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   954: ifeq +38 -> 992
    //   957: ldc 58
    //   959: iconst_2
    //   960: iconst_3
    //   961: anewarray 60	java/lang/Object
    //   964: dup
    //   965: iconst_0
    //   966: ldc_w 344
    //   969: aastore
    //   970: dup
    //   971: iconst_1
    //   972: ldc_w 346
    //   975: aastore
    //   976: dup
    //   977: iconst_2
    //   978: aload 8
    //   980: invokeinterface 174 1 0
    //   985: invokestatic 129	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   988: aastore
    //   989: invokestatic 68	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;I[Ljava/lang/Object;)V
    //   992: iconst_0
    //   993: istore 4
    //   995: goto -136 -> 859
    //   998: invokestatic 56	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1001: ifeq +32 -> 1033
    //   1004: ldc 58
    //   1006: iconst_2
    //   1007: new 279	java/lang/StringBuilder
    //   1010: dup
    //   1011: invokespecial 280	java/lang/StringBuilder:<init>	()V
    //   1014: ldc_w 348
    //   1017: invokevirtual 284	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1020: aload_2
    //   1021: invokevirtual 351	com/tencent/qphone/base/remote/FromServiceMsg:getResultCode	()I
    //   1024: invokevirtual 354	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1027: invokevirtual 289	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1030: invokestatic 357	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1033: iconst_0
    //   1034: istore 4
    //   1036: goto -177 -> 859
    //   1039: astore_2
    //   1040: iload 6
    //   1042: istore 4
    //   1044: goto -122 -> 922
    //   1047: astore 8
    //   1049: aload 7
    //   1051: astore_2
    //   1052: aload 8
    //   1054: astore 7
    //   1056: goto -179 -> 877
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1059	0	this	azbt
    //   0	1059	1	paramIntent	Intent
    //   0	1059	2	paramFromServiceMsg	FromServiceMsg
    //   128	438	3	i	int
    //   159	884	4	bool1	boolean
    //   56	125	5	bool2	boolean
    //   53	988	6	bool3	boolean
    //   14	837	7	localObject1	Object
    //   873	177	7	localInvalidProtocolBufferMicroException1	com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException
    //   1054	1	7	localObject2	Object
    //   99	880	8	localObject3	Object
    //   1047	6	8	localInvalidProtocolBufferMicroException2	com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException
    //   65	800	9	localBundle	android.os.Bundle
    //   6	720	10	str1	String
    //   325	423	11	localObject4	Object
    //   345	591	12	localObject5	Object
    //   305	432	13	localObject6	Object
    //   279	341	14	localObject7	Object
    //   422	206	15	str2	String
    //   387	151	16	str3	String
    //   515	43	17	localanvk	anvk
    //   526	34	18	localFriends	com.tencent.mobileqq.data.Friends
    // Exception table:
    //   from	to	target	type
    //   74	83	873	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   418	434	918	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   437	493	918	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   493	564	918	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   564	614	918	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   619	635	918	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   635	708	918	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   708	747	918	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   747	754	918	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   754	775	918	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   775	815	918	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   815	856	918	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   909	915	918	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   935	941	918	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   208	418	1039	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   951	992	1039	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   83	116	1047	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
  }
  
  private void a(Intent paramIntent, Packet paramPacket)
  {
    Object localObject1 = paramIntent.getStringExtra("param_constellation");
    Object localObject2 = paramIntent.getStringExtra("param_today_date");
    String str = paramIntent.getStringExtra("param_tomorrow_date");
    if (TextUtils.isEmpty((CharSequence)localObject1)) {
      return;
    }
    paramIntent = new oidb_0xe84.ReqBody();
    oidb_0xe84.Condition localCondition = new oidb_0xe84.Condition();
    localCondition.bytes_key.set(ByteStringMicro.copyFromUtf8((String)localObject1));
    localCondition.bytes_date.set(ByteStringMicro.copyFromUtf8((String)localObject2));
    localObject2 = new oidb_0xe84.Condition();
    ((oidb_0xe84.Condition)localObject2).bytes_key.set(ByteStringMicro.copyFromUtf8((String)localObject1));
    ((oidb_0xe84.Condition)localObject2).bytes_date.set(ByteStringMicro.copyFromUtf8(str));
    localObject1 = new OnlineStatusExtInfoServlet.1(this, localCondition, (oidb_0xe84.Condition)localObject2);
    paramIntent.msg_condi.set((List)localObject1);
    paramIntent.uint64_appid.set(1108937847L);
    localObject1 = new oidb_sso.OIDBSSOPkg();
    ((oidb_sso.OIDBSSOPkg)localObject1).uint32_command.set(3716);
    ((oidb_sso.OIDBSSOPkg)localObject1).uint32_service_type.set(1);
    ((oidb_sso.OIDBSSOPkg)localObject1).uint32_result.set(0);
    ((oidb_sso.OIDBSSOPkg)localObject1).bytes_bodybuffer.set(ByteStringMicro.copyFrom(paramIntent.toByteArray()));
    paramIntent = ((oidb_sso.OIDBSSOPkg)localObject1).toByteArray();
    paramPacket.setSSOCommand("OidbSvc.0xe84_1");
    localObject1 = ByteBuffer.allocate(paramIntent.length + 4);
    ((ByteBuffer)localObject1).putInt(paramIntent.length + 4);
    ((ByteBuffer)localObject1).put(paramIntent);
    paramPacket.putSendData(((ByteBuffer)localObject1).array());
  }
  
  public void onReceive(Intent paramIntent, FromServiceMsg paramFromServiceMsg)
  {
    String str2 = paramFromServiceMsg.getServiceCmd();
    String str1;
    if (QLog.isColorLevel())
    {
      boolean bool = paramFromServiceMsg.isSuccess();
      StringBuilder localStringBuilder = new StringBuilder().append("onReceive:").append(str2).append(" is ");
      if (bool)
      {
        str1 = "";
        QLog.d("OnlineStatusExtInfoServlet", 2, str1 + " success");
      }
    }
    else
    {
      if ((str2 != null) && (str2.equals("OidbSvc.0xe84_1"))) {
        break label101;
      }
    }
    label101:
    int i;
    do
    {
      return;
      str1 = "not";
      break;
      i = paramIntent.getIntExtra("param_request_type", 0);
      if (QLog.isColorLevel()) {
        QLog.d("OnlineStatusExtInfoServlet", 2, new Object[] { "onReceive reqType", Integer.valueOf(i) });
      }
    } while (i != 1);
    a(paramIntent, paramFromServiceMsg);
  }
  
  public void onSend(Intent paramIntent, Packet paramPacket)
  {
    int i = paramIntent.getIntExtra("param_request_type", 0);
    if (QLog.isColorLevel()) {
      QLog.d("OnlineStatusExtInfoServlet", 2, new Object[] { " onSend reqType", Integer.valueOf(i) });
    }
    if (i == 1) {
      a(paramIntent, paramPacket);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     azbt
 * JD-Core Version:    0.7.0.1
 */