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

public class axvi
  extends MSFServlet
{
  public static NewIntent a(QQAppInterface paramQQAppInterface, String paramString)
  {
    NewIntent localNewIntent = new NewIntent(paramQQAppInterface.getApplication(), axvi.class);
    localNewIntent.putExtra("param_request_type", 1);
    localNewIntent.putExtra("param_constellation", paramString);
    localNewIntent.putExtra("param_today_date", axyi.b());
    localNewIntent.putExtra("param_tomorrow_date", axyi.c());
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
    //   71: ifeq +926 -> 997
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
    //   162: ifne +696 -> 858
    //   165: iload 5
    //   167: istore 4
    //   169: aload 8
    //   171: getfield 133	tencent/im/oidb/oidb_sso$OIDBSSOPkg:bytes_bodybuffer	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   174: invokevirtual 138	com/tencent/mobileqq/pb/PBBytesField:has	()Z
    //   177: ifeq +681 -> 858
    //   180: iload 5
    //   182: istore 4
    //   184: aload 8
    //   186: getfield 133	tencent/im/oidb/oidb_sso$OIDBSSOPkg:bytes_bodybuffer	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   189: invokevirtual 141	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   192: ifnull +666 -> 858
    //   195: aload 8
    //   197: getfield 133	tencent/im/oidb/oidb_sso$OIDBSSOPkg:bytes_bodybuffer	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   200: invokevirtual 141	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   203: invokevirtual 146	com/tencent/mobileqq/pb/ByteStringMicro:toByteArray	()[B
    //   206: astore 7
    //   208: aload_0
    //   209: invokevirtual 150	axvi:getAppRuntime	()Lmqq/app/AppRuntime;
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
    //   244: invokestatic 160	axyi:a	(Lcom/tencent/mobileqq/app/QQAppInterface;I)V
    //   247: aload 8
    //   249: getfield 164	tencent/im/oidb/cmd0xe84/oidb_0xe84$RspBody:msg_custom_data	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   252: invokevirtual 169	com/tencent/mobileqq/pb/PBRepeatMessageField:get	()Ljava/util/List;
    //   255: astore 8
    //   257: aload 8
    //   259: invokeinterface 174 1 0
    //   264: iconst_2
    //   265: if_icmpne +685 -> 950
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
    //   419: invokestatic 202	axyi:a	(Lcom/tencent/mobileqq/app/QQAppInterface;)Ljava/lang/String;
    //   422: astore 15
    //   424: aload 7
    //   426: aload 15
    //   428: invokevirtual 206	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   431: ifne +471 -> 902
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
    //   494: bipush 51
    //   496: invokevirtual 223	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   499: astore 8
    //   501: aload 8
    //   503: instanceof 225
    //   506: ifeq +57 -> 563
    //   509: aload 8
    //   511: checkcast 225	amsw
    //   514: astore 17
    //   516: aload 17
    //   518: aload_2
    //   519: invokevirtual 228	com/tencent/mobileqq/app/QQAppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   522: invokevirtual 231	amsw:d	(Ljava/lang/String;)Lcom/tencent/mobileqq/data/Friends;
    //   525: astore 18
    //   527: aload 18
    //   529: aload 12
    //   531: putfield 237	com/tencent/mobileqq/data/Friends:constellationIconUrl	Ljava/lang/String;
    //   534: aload 18
    //   536: aload 16
    //   538: putfield 240	com/tencent/mobileqq/data/Friends:constellationJumpUrl	Ljava/lang/String;
    //   541: aload 18
    //   543: aload 11
    //   545: putfield 243	com/tencent/mobileqq/data/Friends:constellationBgImageUrl	Ljava/lang/String;
    //   548: aload 18
    //   550: invokestatic 41	axyi:b	()Ljava/lang/String;
    //   553: putfield 246	com/tencent/mobileqq/data/Friends:constellationDateStr	Ljava/lang/String;
    //   556: aload 17
    //   558: aload 18
    //   560: invokevirtual 249	amsw:a	(Lcom/tencent/mobileqq/data/Friends;)V
    //   563: aload_2
    //   564: iload_3
    //   565: invokestatic 160	axyi:a	(Lcom/tencent/mobileqq/app/QQAppInterface;I)V
    //   568: aload_2
    //   569: aload 7
    //   571: invokestatic 252	axyi:a	(Lcom/tencent/mobileqq/app/QQAppInterface;Ljava/lang/String;)V
    //   574: aload_2
    //   575: aload 14
    //   577: invokestatic 254	axyi:b	(Lcom/tencent/mobileqq/app/QQAppInterface;Ljava/lang/String;)V
    //   580: aload 8
    //   582: instanceof 225
    //   585: ifeq +189 -> 774
    //   588: aload 8
    //   590: checkcast 225	amsw
    //   593: astore 11
    //   595: aload 11
    //   597: aload_2
    //   598: invokevirtual 228	com/tencent/mobileqq/app/QQAppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   601: invokevirtual 231	amsw:d	(Ljava/lang/String;)Lcom/tencent/mobileqq/data/Friends;
    //   604: astore 12
    //   606: aload 12
    //   608: getfield 257	com/tencent/mobileqq/data/Friends:constellationTodayTrend	Ljava/lang/String;
    //   611: astore 14
    //   613: iload 4
    //   615: ifne +19 -> 634
    //   618: aload 14
    //   620: invokestatic 263	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   623: ifne +11 -> 634
    //   626: aload 15
    //   628: invokestatic 263	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   631: ifeq +122 -> 753
    //   634: new 265	axyh
    //   637: dup
    //   638: invokespecial 266	axyh:<init>	()V
    //   641: aload 7
    //   643: invokevirtual 269	axyh:a	(Ljava/lang/String;)Laxyh;
    //   646: invokevirtual 271	axyh:a	()Ljava/lang/String;
    //   649: astore 7
    //   651: new 265	axyh
    //   654: dup
    //   655: invokespecial 266	axyh:<init>	()V
    //   658: aload 13
    //   660: invokevirtual 269	axyh:a	(Ljava/lang/String;)Laxyh;
    //   663: invokevirtual 271	axyh:a	()Ljava/lang/String;
    //   666: astore 13
    //   668: aload 7
    //   670: invokestatic 263	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   673: ifne +235 -> 908
    //   676: aload 12
    //   678: new 273	java/lang/StringBuilder
    //   681: dup
    //   682: invokespecial 274	java/lang/StringBuilder:<init>	()V
    //   685: aload 10
    //   687: invokevirtual 278	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   690: ldc_w 280
    //   693: invokevirtual 278	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   696: aload 7
    //   698: invokevirtual 278	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   701: invokevirtual 283	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   704: putfield 257	com/tencent/mobileqq/data/Friends:constellationTodayTrend	Ljava/lang/String;
    //   707: aload 13
    //   709: invokestatic 263	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   712: ifne +222 -> 934
    //   715: aload 12
    //   717: new 273	java/lang/StringBuilder
    //   720: dup
    //   721: invokespecial 274	java/lang/StringBuilder:<init>	()V
    //   724: aload 10
    //   726: invokevirtual 278	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   729: ldc_w 280
    //   732: invokevirtual 278	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   735: aload 13
    //   737: invokevirtual 278	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   740: invokevirtual 283	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   743: putfield 286	com/tencent/mobileqq/data/Friends:constellationTomorrowTrend	Ljava/lang/String;
    //   746: aload 11
    //   748: aload 12
    //   750: invokevirtual 249	amsw:a	(Lcom/tencent/mobileqq/data/Friends;)V
    //   753: aload_2
    //   754: invokevirtual 290	com/tencent/mobileqq/app/QQAppInterface:getExtOnlineStatus	()J
    //   757: ldc2_w 291
    //   760: lcmp
    //   761: ifne +13 -> 774
    //   764: getstatic 297	axyj:a	Laxyj;
    //   767: aload_2
    //   768: sipush 1040
    //   771: invokevirtual 298	axyj:a	(Lcom/tencent/mobileqq/app/QQAppInterface;I)V
    //   774: aload 8
    //   776: instanceof 225
    //   779: ifeq +76 -> 855
    //   782: aload_2
    //   783: aload_2
    //   784: invokevirtual 228	com/tencent/mobileqq/app/QQAppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   787: invokestatic 301	axyi:a	(Lcom/tencent/mobileqq/app/QQAppInterface;Ljava/lang/String;)Ljava/lang/String;
    //   790: astore 7
    //   792: aload 7
    //   794: ldc_w 303
    //   797: invokevirtual 307	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   800: astore_2
    //   801: aload_2
    //   802: arraylength
    //   803: iconst_2
    //   804: if_icmpne +139 -> 943
    //   807: aload_2
    //   808: iconst_1
    //   809: aaload
    //   810: invokevirtual 310	java/lang/String:trim	()Ljava/lang/String;
    //   813: astore_2
    //   814: aload 9
    //   816: ldc_w 312
    //   819: aload_2
    //   820: invokevirtual 316	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   823: invokestatic 56	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   826: ifeq +29 -> 855
    //   829: ldc 58
    //   831: iconst_2
    //   832: iconst_3
    //   833: anewarray 60	java/lang/Object
    //   836: dup
    //   837: iconst_0
    //   838: ldc 208
    //   840: aastore
    //   841: dup
    //   842: iconst_1
    //   843: ldc_w 318
    //   846: aastore
    //   847: dup
    //   848: iconst_2
    //   849: aload 7
    //   851: aastore
    //   852: invokestatic 68	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;I[Ljava/lang/Object;)V
    //   855: iconst_1
    //   856: istore 4
    //   858: aload_0
    //   859: aload_1
    //   860: iconst_1
    //   861: iload 4
    //   863: aload 9
    //   865: ldc_w 320
    //   868: invokevirtual 324	axvi:notifyObserver	(Landroid/content/Intent;IZLandroid/os/Bundle;Ljava/lang/Class;)V
    //   871: return
    //   872: astore 7
    //   874: aconst_null
    //   875: astore_2
    //   876: aload_2
    //   877: astore 8
    //   879: invokestatic 56	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   882: ifeq -762 -> 120
    //   885: ldc 58
    //   887: iconst_2
    //   888: ldc_w 326
    //   891: aload 7
    //   893: invokestatic 329	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   896: aload_2
    //   897: astore 8
    //   899: goto -779 -> 120
    //   902: iconst_0
    //   903: istore 4
    //   905: goto -468 -> 437
    //   908: aload 12
    //   910: aconst_null
    //   911: putfield 257	com/tencent/mobileqq/data/Friends:constellationTodayTrend	Ljava/lang/String;
    //   914: goto -207 -> 707
    //   917: astore_2
    //   918: iconst_1
    //   919: istore 4
    //   921: ldc 58
    //   923: iconst_1
    //   924: ldc_w 331
    //   927: aload_2
    //   928: invokestatic 334	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   931: goto -73 -> 858
    //   934: aload 12
    //   936: aconst_null
    //   937: putfield 286	com/tencent/mobileqq/data/Friends:constellationTomorrowTrend	Ljava/lang/String;
    //   940: goto -194 -> 746
    //   943: ldc_w 336
    //   946: astore_2
    //   947: goto -133 -> 814
    //   950: invokestatic 56	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   953: ifeq +38 -> 991
    //   956: ldc 58
    //   958: iconst_2
    //   959: iconst_3
    //   960: anewarray 60	java/lang/Object
    //   963: dup
    //   964: iconst_0
    //   965: ldc_w 338
    //   968: aastore
    //   969: dup
    //   970: iconst_1
    //   971: ldc_w 340
    //   974: aastore
    //   975: dup
    //   976: iconst_2
    //   977: aload 8
    //   979: invokeinterface 174 1 0
    //   984: invokestatic 129	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   987: aastore
    //   988: invokestatic 68	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;I[Ljava/lang/Object;)V
    //   991: iconst_0
    //   992: istore 4
    //   994: goto -136 -> 858
    //   997: invokestatic 56	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1000: ifeq +32 -> 1032
    //   1003: ldc 58
    //   1005: iconst_2
    //   1006: new 273	java/lang/StringBuilder
    //   1009: dup
    //   1010: invokespecial 274	java/lang/StringBuilder:<init>	()V
    //   1013: ldc_w 342
    //   1016: invokevirtual 278	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1019: aload_2
    //   1020: invokevirtual 345	com/tencent/qphone/base/remote/FromServiceMsg:getResultCode	()I
    //   1023: invokevirtual 348	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1026: invokevirtual 283	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1029: invokestatic 351	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1032: iconst_0
    //   1033: istore 4
    //   1035: goto -177 -> 858
    //   1038: astore_2
    //   1039: iload 6
    //   1041: istore 4
    //   1043: goto -122 -> 921
    //   1046: astore 8
    //   1048: aload 7
    //   1050: astore_2
    //   1051: aload 8
    //   1053: astore 7
    //   1055: goto -179 -> 876
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1058	0	this	axvi
    //   0	1058	1	paramIntent	Intent
    //   0	1058	2	paramFromServiceMsg	FromServiceMsg
    //   128	437	3	i	int
    //   159	883	4	bool1	boolean
    //   56	125	5	bool2	boolean
    //   53	987	6	bool3	boolean
    //   14	836	7	localObject1	Object
    //   872	177	7	localInvalidProtocolBufferMicroException1	com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException
    //   1053	1	7	localObject2	Object
    //   99	879	8	localObject3	Object
    //   1046	6	8	localInvalidProtocolBufferMicroException2	com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException
    //   65	799	9	localBundle	android.os.Bundle
    //   6	719	10	str1	String
    //   325	422	11	localObject4	Object
    //   345	590	12	localObject5	Object
    //   305	431	13	localObject6	Object
    //   279	340	14	localObject7	Object
    //   422	205	15	str2	String
    //   387	150	16	str3	String
    //   514	43	17	localamsw	amsw
    //   525	34	18	localFriends	com.tencent.mobileqq.data.Friends
    // Exception table:
    //   from	to	target	type
    //   74	83	872	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   418	434	917	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   437	493	917	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   493	563	917	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   563	613	917	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   618	634	917	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   634	707	917	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   707	746	917	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   746	753	917	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   753	774	917	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   774	814	917	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   814	855	917	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   908	914	917	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   934	940	917	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   208	418	1038	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   950	991	1038	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   83	116	1046	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
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
 * Qualified Name:     axvi
 * JD-Core Version:    0.7.0.1
 */