package com.tencent.mobileqq.activity.aio.tips;

import android.text.format.Time;
import com.tencent.mobileqq.activity.aio.BaseSessionInfo;
import com.tencent.mobileqq.activity.aio.core.AIOContext;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.service.message.MessageCache;
import com.tencent.mobileqq.service.message.MessageRecordFactory;
import mqq.app.MobileQQ;

public class DiscFreqPttGrayTips
  implements GrayTipsTask
{
  private AIOContext a;
  private QQAppInterface b;
  private BaseSessionInfo c;
  private TipsManager d;
  private Time e;
  
  public DiscFreqPttGrayTips(AIOContext paramAIOContext)
  {
    this.a = paramAIOContext;
    this.b = paramAIOContext.a();
    this.c = paramAIOContext.O();
    this.d = paramAIOContext.c();
  }
  
  /* Error */
  public void a(int paramInt, Object... paramVarArgs)
  {
    // Byte code:
    //   0: iload_1
    //   1: sipush 1001
    //   4: if_icmpeq +4 -> 8
    //   7: return
    //   8: invokestatic 49	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   11: ifeq +11 -> 22
    //   14: ldc 51
    //   16: iconst_2
    //   17: ldc 53
    //   19: invokestatic 56	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   22: ldc 58
    //   24: astore 14
    //   26: aload_0
    //   27: getfield 36	com/tencent/mobileqq/activity/aio/tips/DiscFreqPttGrayTips:c	Lcom/tencent/mobileqq/activity/aio/BaseSessionInfo;
    //   30: getfield 63	com/tencent/mobileqq/activity/aio/BaseSessionInfo:a	I
    //   33: istore_1
    //   34: iload_1
    //   35: sipush 3000
    //   38: if_icmpeq +47 -> 85
    //   41: invokestatic 49	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   44: ifeq +35 -> 79
    //   47: new 65	java/lang/StringBuilder
    //   50: dup
    //   51: invokespecial 66	java/lang/StringBuilder:<init>	()V
    //   54: astore_2
    //   55: aload_2
    //   56: ldc 68
    //   58: invokevirtual 72	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   61: pop
    //   62: aload_2
    //   63: ldc 74
    //   65: invokevirtual 72	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   68: pop
    //   69: ldc 51
    //   71: iconst_2
    //   72: aload_2
    //   73: invokevirtual 78	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   76: invokestatic 56	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   79: return
    //   80: astore 14
    //   82: goto +1351 -> 1433
    //   85: aload_0
    //   86: getfield 30	com/tencent/mobileqq/activity/aio/tips/DiscFreqPttGrayTips:b	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   89: invokestatic 83	com/tencent/mobileqq/config/operation/QQOperateManager:a	(Lcom/tencent/mobileqq/app/QQAppInterface;)Lcom/tencent/mobileqq/config/operation/QQOperateManager;
    //   92: astore 16
    //   94: aload 16
    //   96: aload_0
    //   97: getfield 36	com/tencent/mobileqq/activity/aio/tips/DiscFreqPttGrayTips:c	Lcom/tencent/mobileqq/activity/aio/BaseSessionInfo;
    //   100: getfield 63	com/tencent/mobileqq/activity/aio/BaseSessionInfo:a	I
    //   103: iconst_2
    //   104: invokevirtual 86	com/tencent/mobileqq/config/operation/QQOperateManager:b	(II)Z
    //   107: istore 8
    //   109: iload 8
    //   111: ifeq +42 -> 153
    //   114: invokestatic 49	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   117: ifeq +35 -> 152
    //   120: new 65	java/lang/StringBuilder
    //   123: dup
    //   124: invokespecial 66	java/lang/StringBuilder:<init>	()V
    //   127: astore_2
    //   128: aload_2
    //   129: ldc 68
    //   131: invokevirtual 72	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   134: pop
    //   135: aload_2
    //   136: ldc 88
    //   138: invokevirtual 72	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   141: pop
    //   142: ldc 51
    //   144: iconst_2
    //   145: aload_2
    //   146: invokevirtual 78	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   149: invokestatic 56	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   152: return
    //   153: aload_0
    //   154: getfield 23	com/tencent/mobileqq/activity/aio/tips/DiscFreqPttGrayTips:a	Lcom/tencent/mobileqq/activity/aio/core/AIOContext;
    //   157: invokevirtual 91	com/tencent/mobileqq/activity/aio/core/AIOContext:e	()Lcom/tencent/mobileqq/activity/aio/core/msglist/MsgList;
    //   160: invokevirtual 96	com/tencent/mobileqq/activity/aio/core/msglist/MsgList:b	()Lcom/tencent/mobileqq/activity/aio/coreui/msglist/ListUI;
    //   163: invokevirtual 101	com/tencent/mobileqq/activity/aio/coreui/msglist/ListUI:d	()Ljava/util/List;
    //   166: astore 15
    //   168: aload 15
    //   170: ifnonnull +42 -> 212
    //   173: invokestatic 49	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   176: ifeq +35 -> 211
    //   179: new 65	java/lang/StringBuilder
    //   182: dup
    //   183: invokespecial 66	java/lang/StringBuilder:<init>	()V
    //   186: astore_2
    //   187: aload_2
    //   188: ldc 68
    //   190: invokevirtual 72	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   193: pop
    //   194: aload_2
    //   195: ldc 103
    //   197: invokevirtual 72	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   200: pop
    //   201: ldc 51
    //   203: iconst_2
    //   204: aload_2
    //   205: invokevirtual 78	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   208: invokestatic 56	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   211: return
    //   212: aload_0
    //   213: getfield 30	com/tencent/mobileqq/activity/aio/tips/DiscFreqPttGrayTips:b	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   216: invokevirtual 109	com/tencent/mobileqq/app/QQAppInterface:getApplication	()Lmqq/app/MobileQQ;
    //   219: invokestatic 115	com/tencent/mobileqq/utils/NetworkUtil:isWifiConnected	(Landroid/content/Context;)Z
    //   222: istore 8
    //   224: iload 8
    //   226: ifne +42 -> 268
    //   229: invokestatic 49	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   232: ifeq +35 -> 267
    //   235: new 65	java/lang/StringBuilder
    //   238: dup
    //   239: invokespecial 66	java/lang/StringBuilder:<init>	()V
    //   242: astore_2
    //   243: aload_2
    //   244: ldc 68
    //   246: invokevirtual 72	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   249: pop
    //   250: aload_2
    //   251: ldc 117
    //   253: invokevirtual 72	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   256: pop
    //   257: ldc 51
    //   259: iconst_2
    //   260: aload_2
    //   261: invokevirtual 78	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   264: invokestatic 56	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   267: return
    //   268: aload 15
    //   270: invokeinterface 123 1 0
    //   275: istore_1
    //   276: iload_1
    //   277: iconst_5
    //   278: if_icmpge +91 -> 369
    //   281: aload 14
    //   283: astore_2
    //   284: new 65	java/lang/StringBuilder
    //   287: dup
    //   288: invokespecial 66	java/lang/StringBuilder:<init>	()V
    //   291: astore 16
    //   293: aload 14
    //   295: astore_2
    //   296: aload 16
    //   298: ldc 125
    //   300: invokevirtual 72	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   303: pop
    //   304: aload 14
    //   306: astore_2
    //   307: aload 16
    //   309: aload 15
    //   311: invokeinterface 123 1 0
    //   316: invokevirtual 128	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   319: pop
    //   320: aload 14
    //   322: astore_2
    //   323: aload 16
    //   325: invokevirtual 78	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   328: astore 14
    //   330: invokestatic 49	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   333: ifeq +35 -> 368
    //   336: new 65	java/lang/StringBuilder
    //   339: dup
    //   340: invokespecial 66	java/lang/StringBuilder:<init>	()V
    //   343: astore_2
    //   344: aload_2
    //   345: ldc 68
    //   347: invokevirtual 72	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   350: pop
    //   351: aload_2
    //   352: aload 14
    //   354: invokevirtual 72	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   357: pop
    //   358: ldc 51
    //   360: iconst_2
    //   361: aload_2
    //   362: invokevirtual 78	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   365: invokestatic 56	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   368: return
    //   369: aload_0
    //   370: getfield 36	com/tencent/mobileqq/activity/aio/tips/DiscFreqPttGrayTips:c	Lcom/tencent/mobileqq/activity/aio/BaseSessionInfo;
    //   373: getfield 131	com/tencent/mobileqq/activity/aio/BaseSessionInfo:b	Ljava/lang/String;
    //   376: invokestatic 137	java/lang/Long:valueOf	(Ljava/lang/String;)Ljava/lang/Long;
    //   379: invokevirtual 141	java/lang/Long:longValue	()J
    //   382: lstore 10
    //   384: aload_0
    //   385: getfield 36	com/tencent/mobileqq/activity/aio/tips/DiscFreqPttGrayTips:c	Lcom/tencent/mobileqq/activity/aio/BaseSessionInfo;
    //   388: getfield 63	com/tencent/mobileqq/activity/aio/BaseSessionInfo:a	I
    //   391: invokestatic 146	com/tencent/av/utils/UITools:b	(I)I
    //   394: istore_1
    //   395: aload_0
    //   396: getfield 30	com/tencent/mobileqq/activity/aio/tips/DiscFreqPttGrayTips:b	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   399: invokevirtual 150	com/tencent/mobileqq/app/QQAppInterface:getAVNotifyCenter	()Lcom/tencent/av/gaudio/AVNotifyCenter;
    //   402: iload_1
    //   403: lload 10
    //   405: invokevirtual 155	com/tencent/av/gaudio/AVNotifyCenter:a	(IJ)Z
    //   408: istore 8
    //   410: iload 8
    //   412: ifeq +42 -> 454
    //   415: invokestatic 49	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   418: ifeq +35 -> 453
    //   421: new 65	java/lang/StringBuilder
    //   424: dup
    //   425: invokespecial 66	java/lang/StringBuilder:<init>	()V
    //   428: astore_2
    //   429: aload_2
    //   430: ldc 68
    //   432: invokevirtual 72	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   435: pop
    //   436: aload_2
    //   437: ldc 157
    //   439: invokevirtual 72	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   442: pop
    //   443: ldc 51
    //   445: iconst_2
    //   446: aload_2
    //   447: invokevirtual 78	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   450: invokestatic 56	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   453: return
    //   454: aload 15
    //   456: invokeinterface 123 1 0
    //   461: istore_3
    //   462: iload_3
    //   463: iconst_1
    //   464: isub
    //   465: istore_1
    //   466: iload_1
    //   467: iflt +54 -> 521
    //   470: iload_1
    //   471: iload_3
    //   472: bipush 10
    //   474: isub
    //   475: if_icmpge +6 -> 481
    //   478: goto +43 -> 521
    //   481: aload 14
    //   483: astore_2
    //   484: aload 15
    //   486: iload_1
    //   487: invokeinterface 161 2 0
    //   492: checkcast 163	com/tencent/mobileqq/data/ChatMessage
    //   495: getfield 166	com/tencent/mobileqq/data/ChatMessage:msgtype	I
    //   498: istore 4
    //   500: iload 4
    //   502: sipush -1043
    //   505: if_icmpne +9 -> 514
    //   508: iconst_1
    //   509: istore 8
    //   511: goto +13 -> 524
    //   514: iload_1
    //   515: iconst_1
    //   516: isub
    //   517: istore_1
    //   518: goto -52 -> 466
    //   521: iconst_0
    //   522: istore 8
    //   524: invokestatic 49	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   527: istore 9
    //   529: iload 9
    //   531: ifeq +51 -> 582
    //   534: aload 14
    //   536: astore_2
    //   537: new 65	java/lang/StringBuilder
    //   540: dup
    //   541: invokespecial 66	java/lang/StringBuilder:<init>	()V
    //   544: astore 17
    //   546: aload 14
    //   548: astore_2
    //   549: aload 17
    //   551: ldc 168
    //   553: invokevirtual 72	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   556: pop
    //   557: aload 14
    //   559: astore_2
    //   560: aload 17
    //   562: iload 8
    //   564: invokevirtual 171	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   567: pop
    //   568: aload 14
    //   570: astore_2
    //   571: ldc 51
    //   573: iconst_2
    //   574: aload 17
    //   576: invokevirtual 78	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   579: invokestatic 56	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   582: iload 8
    //   584: ifeq +42 -> 626
    //   587: invokestatic 49	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   590: ifeq +35 -> 625
    //   593: new 65	java/lang/StringBuilder
    //   596: dup
    //   597: invokespecial 66	java/lang/StringBuilder:<init>	()V
    //   600: astore_2
    //   601: aload_2
    //   602: ldc 68
    //   604: invokevirtual 72	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   607: pop
    //   608: aload_2
    //   609: ldc 173
    //   611: invokevirtual 72	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   614: pop
    //   615: ldc 51
    //   617: iconst_2
    //   618: aload_2
    //   619: invokevirtual 78	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   622: invokestatic 56	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   625: return
    //   626: invokestatic 177	com/tencent/mobileqq/service/message/MessageCache:c	()J
    //   629: ldc2_w 178
    //   632: lmul
    //   633: lstore 10
    //   635: aload_0
    //   636: getfield 181	com/tencent/mobileqq/activity/aio/tips/DiscFreqPttGrayTips:e	Landroid/text/format/Time;
    //   639: astore_2
    //   640: aload_2
    //   641: ifnonnull +17 -> 658
    //   644: aload 14
    //   646: astore_2
    //   647: aload_0
    //   648: new 183	android/text/format/Time
    //   651: dup
    //   652: invokespecial 184	android/text/format/Time:<init>	()V
    //   655: putfield 181	com/tencent/mobileqq/activity/aio/tips/DiscFreqPttGrayTips:e	Landroid/text/format/Time;
    //   658: aload_0
    //   659: getfield 181	com/tencent/mobileqq/activity/aio/tips/DiscFreqPttGrayTips:e	Landroid/text/format/Time;
    //   662: lload 10
    //   664: invokevirtual 188	android/text/format/Time:set	(J)V
    //   667: aload_0
    //   668: getfield 181	com/tencent/mobileqq/activity/aio/tips/DiscFreqPttGrayTips:e	Landroid/text/format/Time;
    //   671: getfield 191	android/text/format/Time:year	I
    //   674: istore_1
    //   675: aload_0
    //   676: getfield 181	com/tencent/mobileqq/activity/aio/tips/DiscFreqPttGrayTips:e	Landroid/text/format/Time;
    //   679: getfield 194	android/text/format/Time:month	I
    //   682: istore_3
    //   683: aload_0
    //   684: getfield 181	com/tencent/mobileqq/activity/aio/tips/DiscFreqPttGrayTips:e	Landroid/text/format/Time;
    //   687: getfield 197	android/text/format/Time:monthDay	I
    //   690: istore 4
    //   692: new 65	java/lang/StringBuilder
    //   695: dup
    //   696: invokespecial 66	java/lang/StringBuilder:<init>	()V
    //   699: astore_2
    //   700: aload_2
    //   701: ldc 199
    //   703: invokevirtual 72	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   706: pop
    //   707: aload_2
    //   708: aload_0
    //   709: getfield 30	com/tencent/mobileqq/activity/aio/tips/DiscFreqPttGrayTips:b	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   712: invokevirtual 202	com/tencent/mobileqq/app/QQAppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   715: invokevirtual 72	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   718: pop
    //   719: aload_2
    //   720: invokevirtual 78	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   723: astore_2
    //   724: invokestatic 208	com/tencent/qphone/base/util/BaseApplication:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   727: ldc 210
    //   729: iconst_0
    //   730: invokevirtual 214	com/tencent/qphone/base/util/BaseApplication:getSharedPreferences	(Ljava/lang/String;I)Landroid/content/SharedPreferences;
    //   733: astore 17
    //   735: aload 17
    //   737: aload_2
    //   738: aconst_null
    //   739: invokeinterface 220 3 0
    //   744: astore 18
    //   746: invokestatic 49	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   749: ifeq +734 -> 1483
    //   752: new 65	java/lang/StringBuilder
    //   755: dup
    //   756: invokespecial 66	java/lang/StringBuilder:<init>	()V
    //   759: astore 19
    //   761: aload 19
    //   763: iload_1
    //   764: invokevirtual 128	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   767: pop
    //   768: aload 19
    //   770: ldc 222
    //   772: invokevirtual 72	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   775: pop
    //   776: aload 19
    //   778: iload_3
    //   779: invokevirtual 128	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   782: pop
    //   783: aload 19
    //   785: ldc 222
    //   787: invokevirtual 72	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   790: pop
    //   791: aload 19
    //   793: iload 4
    //   795: invokevirtual 128	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   798: pop
    //   799: aload 19
    //   801: invokevirtual 78	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   804: astore 19
    //   806: new 65	java/lang/StringBuilder
    //   809: dup
    //   810: invokespecial 66	java/lang/StringBuilder:<init>	()V
    //   813: astore 14
    //   815: aload 14
    //   817: ldc 224
    //   819: invokevirtual 72	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   822: pop
    //   823: aload 14
    //   825: aload 19
    //   827: invokevirtual 72	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   830: pop
    //   831: aload 14
    //   833: ldc 226
    //   835: invokevirtual 72	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   838: pop
    //   839: aload 14
    //   841: aload_0
    //   842: getfield 181	com/tencent/mobileqq/activity/aio/tips/DiscFreqPttGrayTips:e	Landroid/text/format/Time;
    //   845: getfield 229	android/text/format/Time:hour	I
    //   848: invokevirtual 128	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   851: pop
    //   852: aload 14
    //   854: ldc 231
    //   856: invokevirtual 72	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   859: pop
    //   860: aload 14
    //   862: aload 18
    //   864: invokevirtual 72	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   867: pop
    //   868: ldc 233
    //   870: iconst_2
    //   871: aload 14
    //   873: invokevirtual 78	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   876: invokestatic 56	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   879: goto +3 -> 882
    //   882: aload 18
    //   884: invokestatic 239	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   887: ifne +100 -> 987
    //   890: aload_0
    //   891: getfield 181	com/tencent/mobileqq/activity/aio/tips/DiscFreqPttGrayTips:e	Landroid/text/format/Time;
    //   894: aload 18
    //   896: invokestatic 243	java/lang/Long:parseLong	(Ljava/lang/String;)J
    //   899: invokevirtual 188	android/text/format/Time:set	(J)V
    //   902: aload_0
    //   903: getfield 181	com/tencent/mobileqq/activity/aio/tips/DiscFreqPttGrayTips:e	Landroid/text/format/Time;
    //   906: getfield 191	android/text/format/Time:year	I
    //   909: istore 5
    //   911: aload_0
    //   912: getfield 181	com/tencent/mobileqq/activity/aio/tips/DiscFreqPttGrayTips:e	Landroid/text/format/Time;
    //   915: getfield 194	android/text/format/Time:month	I
    //   918: istore 6
    //   920: aload_0
    //   921: getfield 181	com/tencent/mobileqq/activity/aio/tips/DiscFreqPttGrayTips:e	Landroid/text/format/Time;
    //   924: getfield 197	android/text/format/Time:monthDay	I
    //   927: istore 7
    //   929: iload_1
    //   930: iload 5
    //   932: if_icmpne +55 -> 987
    //   935: iload_3
    //   936: iload 6
    //   938: if_icmpne +49 -> 987
    //   941: iload 4
    //   943: iload 7
    //   945: if_icmpne +42 -> 987
    //   948: invokestatic 49	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   951: ifeq +35 -> 986
    //   954: new 65	java/lang/StringBuilder
    //   957: dup
    //   958: invokespecial 66	java/lang/StringBuilder:<init>	()V
    //   961: astore_2
    //   962: aload_2
    //   963: ldc 68
    //   965: invokevirtual 72	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   968: pop
    //   969: aload_2
    //   970: ldc 245
    //   972: invokevirtual 72	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   975: pop
    //   976: ldc 51
    //   978: iconst_2
    //   979: aload_2
    //   980: invokevirtual 78	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   983: invokestatic 56	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   986: return
    //   987: new 65	java/lang/StringBuilder
    //   990: dup
    //   991: invokespecial 66	java/lang/StringBuilder:<init>	()V
    //   994: astore 14
    //   996: aload 14
    //   998: ldc 247
    //   1000: invokevirtual 72	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1003: pop
    //   1004: aload 14
    //   1006: aload_0
    //   1007: getfield 30	com/tencent/mobileqq/activity/aio/tips/DiscFreqPttGrayTips:b	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   1010: invokevirtual 202	com/tencent/mobileqq/app/QQAppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   1013: invokevirtual 72	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1016: pop
    //   1017: aload 17
    //   1019: aload 14
    //   1021: invokevirtual 78	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1024: aconst_null
    //   1025: invokeinterface 220 3 0
    //   1030: astore 14
    //   1032: aload 14
    //   1034: invokestatic 239	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   1037: ifne +57 -> 1094
    //   1040: lload 10
    //   1042: aload 14
    //   1044: invokestatic 243	java/lang/Long:parseLong	(Ljava/lang/String;)J
    //   1047: lsub
    //   1048: ldc2_w 248
    //   1051: lcmp
    //   1052: ifgt +42 -> 1094
    //   1055: invokestatic 49	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1058: ifeq +35 -> 1093
    //   1061: new 65	java/lang/StringBuilder
    //   1064: dup
    //   1065: invokespecial 66	java/lang/StringBuilder:<init>	()V
    //   1068: astore_2
    //   1069: aload_2
    //   1070: ldc 68
    //   1072: invokevirtual 72	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1075: pop
    //   1076: aload_2
    //   1077: ldc 251
    //   1079: invokevirtual 72	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1082: pop
    //   1083: ldc 51
    //   1085: iconst_2
    //   1086: aload_2
    //   1087: invokevirtual 78	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1090: invokestatic 56	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1093: return
    //   1094: lload 10
    //   1096: ldc2_w 248
    //   1099: lsub
    //   1100: ldc2_w 178
    //   1103: ldiv
    //   1104: lstore 12
    //   1106: aload 15
    //   1108: invokeinterface 123 1 0
    //   1113: istore_1
    //   1114: new 253	java/util/HashSet
    //   1117: dup
    //   1118: invokespecial 254	java/util/HashSet:<init>	()V
    //   1121: astore 14
    //   1123: iload_1
    //   1124: iconst_1
    //   1125: isub
    //   1126: istore_3
    //   1127: iconst_0
    //   1128: istore_1
    //   1129: iload_3
    //   1130: iflt +74 -> 1204
    //   1133: aload 15
    //   1135: iload_3
    //   1136: invokeinterface 161 2 0
    //   1141: checkcast 163	com/tencent/mobileqq/data/ChatMessage
    //   1144: astore 18
    //   1146: iload_1
    //   1147: istore 4
    //   1149: aload 18
    //   1151: getfield 258	com/tencent/mobileqq/data/ChatMessage:time	J
    //   1154: lload 12
    //   1156: lcmp
    //   1157: iflt +329 -> 1486
    //   1160: iload_1
    //   1161: istore 4
    //   1163: aload 18
    //   1165: getfield 166	com/tencent/mobileqq/data/ChatMessage:msgtype	I
    //   1168: sipush -2002
    //   1171: if_icmpne +315 -> 1486
    //   1174: iload_1
    //   1175: istore 4
    //   1177: aload 18
    //   1179: getfield 261	com/tencent/mobileqq/data/ChatMessage:extraflag	I
    //   1182: ifne +304 -> 1486
    //   1185: iload_1
    //   1186: iconst_1
    //   1187: iadd
    //   1188: istore 4
    //   1190: aload 14
    //   1192: aload 18
    //   1194: getfield 264	com/tencent/mobileqq/data/ChatMessage:senderuin	Ljava/lang/String;
    //   1197: invokevirtual 268	java/util/HashSet:add	(Ljava/lang/Object;)Z
    //   1200: pop
    //   1201: goto +285 -> 1486
    //   1204: aload 14
    //   1206: invokevirtual 269	java/util/HashSet:size	()I
    //   1209: istore_3
    //   1210: iload_1
    //   1211: iconst_5
    //   1212: if_icmplt +121 -> 1333
    //   1215: iload_3
    //   1216: iconst_2
    //   1217: if_icmplt +116 -> 1333
    //   1220: aload_0
    //   1221: getfield 41	com/tencent/mobileqq/activity/aio/tips/DiscFreqPttGrayTips:d	Lcom/tencent/mobileqq/activity/aio/tips/TipsManager;
    //   1224: aload_0
    //   1225: iconst_0
    //   1226: anewarray 4	java/lang/Object
    //   1229: invokevirtual 274	com/tencent/mobileqq/activity/aio/tips/TipsManager:a	(Lcom/tencent/mobileqq/activity/aio/tips/GrayTipsTask;[Ljava/lang/Object;)Z
    //   1232: ifeq +95 -> 1327
    //   1235: aload 16
    //   1237: aload_0
    //   1238: getfield 30	com/tencent/mobileqq/activity/aio/tips/DiscFreqPttGrayTips:b	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   1241: aload_0
    //   1242: getfield 36	com/tencent/mobileqq/activity/aio/tips/DiscFreqPttGrayTips:c	Lcom/tencent/mobileqq/activity/aio/BaseSessionInfo;
    //   1245: getfield 63	com/tencent/mobileqq/activity/aio/BaseSessionInfo:a	I
    //   1248: iconst_2
    //   1249: invokevirtual 277	com/tencent/mobileqq/config/operation/QQOperateManager:a	(Lcom/tencent/mobileqq/app/QQAppInterface;II)V
    //   1252: aload 17
    //   1254: invokeinterface 281 1 0
    //   1259: astore 14
    //   1261: aload 14
    //   1263: aload_2
    //   1264: lload 10
    //   1266: invokestatic 286	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   1269: invokeinterface 292 3 0
    //   1274: pop
    //   1275: aload 14
    //   1277: invokeinterface 295 1 0
    //   1282: pop
    //   1283: ldc_w 297
    //   1286: astore 14
    //   1288: aload 14
    //   1290: astore_2
    //   1291: aload_0
    //   1292: getfield 30	com/tencent/mobileqq/activity/aio/tips/DiscFreqPttGrayTips:b	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   1295: ldc_w 299
    //   1298: ldc 58
    //   1300: ldc 58
    //   1302: ldc_w 301
    //   1305: ldc_w 301
    //   1308: iconst_0
    //   1309: iconst_0
    //   1310: ldc 58
    //   1312: ldc 58
    //   1314: ldc 58
    //   1316: ldc 58
    //   1318: invokestatic 306	com/tencent/mobileqq/statistics/ReportController:b	(Lmqq/app/AppRuntime;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   1321: aload 14
    //   1323: astore_2
    //   1324: goto +50 -> 1374
    //   1327: ldc 58
    //   1329: astore_2
    //   1330: goto +44 -> 1374
    //   1333: new 65	java/lang/StringBuilder
    //   1336: dup
    //   1337: invokespecial 66	java/lang/StringBuilder:<init>	()V
    //   1340: astore_2
    //   1341: aload_2
    //   1342: ldc_w 308
    //   1345: invokevirtual 72	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1348: pop
    //   1349: aload_2
    //   1350: iload_1
    //   1351: invokevirtual 128	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1354: pop
    //   1355: aload_2
    //   1356: ldc_w 310
    //   1359: invokevirtual 72	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1362: pop
    //   1363: aload_2
    //   1364: iload_3
    //   1365: invokevirtual 128	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1368: pop
    //   1369: aload_2
    //   1370: invokevirtual 78	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1373: astore_2
    //   1374: invokestatic 49	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1377: ifeq +38 -> 1415
    //   1380: new 65	java/lang/StringBuilder
    //   1383: dup
    //   1384: invokespecial 66	java/lang/StringBuilder:<init>	()V
    //   1387: astore 14
    //   1389: aload 14
    //   1391: ldc 68
    //   1393: invokevirtual 72	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1396: pop
    //   1397: aload 14
    //   1399: aload_2
    //   1400: invokevirtual 72	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1403: pop
    //   1404: ldc 51
    //   1406: iconst_2
    //   1407: aload 14
    //   1409: invokevirtual 78	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1412: invokestatic 56	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1415: return
    //   1416: astore 14
    //   1418: ldc 58
    //   1420: astore_2
    //   1421: goto +12 -> 1433
    //   1424: astore 15
    //   1426: aload 14
    //   1428: astore_2
    //   1429: aload 15
    //   1431: astore 14
    //   1433: invokestatic 49	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1436: ifeq +38 -> 1474
    //   1439: new 65	java/lang/StringBuilder
    //   1442: dup
    //   1443: invokespecial 66	java/lang/StringBuilder:<init>	()V
    //   1446: astore 15
    //   1448: aload 15
    //   1450: ldc 68
    //   1452: invokevirtual 72	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1455: pop
    //   1456: aload 15
    //   1458: aload_2
    //   1459: invokevirtual 72	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1462: pop
    //   1463: ldc 51
    //   1465: iconst_2
    //   1466: aload 15
    //   1468: invokevirtual 78	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1471: invokestatic 56	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1474: goto +6 -> 1480
    //   1477: aload 14
    //   1479: athrow
    //   1480: goto -3 -> 1477
    //   1483: goto -601 -> 882
    //   1486: iload_3
    //   1487: iconst_1
    //   1488: isub
    //   1489: istore_3
    //   1490: iload 4
    //   1492: istore_1
    //   1493: goto -364 -> 1129
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1496	0	this	DiscFreqPttGrayTips
    //   0	1496	1	paramInt	int
    //   0	1496	2	paramVarArgs	Object[]
    //   461	1029	3	i	int
    //   498	993	4	j	int
    //   909	24	5	k	int
    //   918	21	6	m	int
    //   927	19	7	n	int
    //   107	476	8	bool1	boolean
    //   527	3	9	bool2	boolean
    //   382	883	10	l1	long
    //   1104	51	12	l2	long
    //   24	1	14	str	String
    //   80	241	14	localObject1	Object
    //   328	1080	14	localObject2	Object
    //   1416	11	14	localObject3	Object
    //   1431	47	14	localObject4	Object
    //   166	968	15	localList	java.util.List
    //   1424	6	15	localObject5	Object
    //   1446	21	15	localStringBuilder	java.lang.StringBuilder
    //   92	1144	16	localObject6	Object
    //   544	709	17	localObject7	Object
    //   744	449	18	localObject8	Object
    //   759	67	19	localObject9	Object
    // Exception table:
    //   from	to	target	type
    //   284	293	80	finally
    //   296	304	80	finally
    //   307	320	80	finally
    //   323	330	80	finally
    //   484	500	80	finally
    //   537	546	80	finally
    //   549	557	80	finally
    //   560	568	80	finally
    //   571	582	80	finally
    //   647	658	80	finally
    //   1291	1321	80	finally
    //   806	879	1416	finally
    //   882	929	1416	finally
    //   987	1055	1416	finally
    //   1094	1123	1416	finally
    //   1133	1146	1416	finally
    //   1149	1160	1416	finally
    //   1163	1174	1416	finally
    //   1177	1185	1416	finally
    //   1190	1201	1416	finally
    //   1204	1210	1416	finally
    //   1220	1283	1416	finally
    //   1333	1374	1416	finally
    //   26	34	1424	finally
    //   85	109	1424	finally
    //   153	168	1424	finally
    //   212	224	1424	finally
    //   268	276	1424	finally
    //   369	410	1424	finally
    //   454	462	1424	finally
    //   524	529	1424	finally
    //   626	640	1424	finally
    //   658	806	1424	finally
  }
  
  public MessageRecord a_(Object... paramVarArgs)
  {
    paramVarArgs = MessageRecordFactory.a(-1016);
    long l = MessageCache.c();
    String str = this.b.getCurrentAccountUin();
    paramVarArgs.init(str, this.c.b, str, this.b.getApplication().getString(2131888730), l, -1017, 3000, l);
    paramVarArgs.isread = true;
    return paramVarArgs;
  }
  
  public int b()
  {
    return 1001;
  }
  
  public int[] c()
  {
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.tips.DiscFreqPttGrayTips
 * JD-Core Version:    0.7.0.1
 */