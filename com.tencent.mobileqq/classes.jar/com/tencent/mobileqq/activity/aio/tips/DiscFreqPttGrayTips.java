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
  private Time jdField_a_of_type_AndroidTextFormatTime;
  private BaseSessionInfo jdField_a_of_type_ComTencentMobileqqActivityAioBaseSessionInfo;
  private AIOContext jdField_a_of_type_ComTencentMobileqqActivityAioCoreAIOContext;
  private TipsManager jdField_a_of_type_ComTencentMobileqqActivityAioTipsTipsManager;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  
  public DiscFreqPttGrayTips(AIOContext paramAIOContext)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreAIOContext = paramAIOContext;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramAIOContext.a();
    this.jdField_a_of_type_ComTencentMobileqqActivityAioBaseSessionInfo = paramAIOContext.a();
    this.jdField_a_of_type_ComTencentMobileqqActivityAioTipsTipsManager = paramAIOContext.a();
  }
  
  public MessageRecord a(Object... paramVarArgs)
  {
    paramVarArgs = MessageRecordFactory.a(-1016);
    long l = MessageCache.a();
    String str = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin();
    paramVarArgs.init(str, this.jdField_a_of_type_ComTencentMobileqqActivityAioBaseSessionInfo.jdField_a_of_type_JavaLangString, str, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().getString(2131691768), l, -1017, 3000, l);
    paramVarArgs.isread = true;
    return paramVarArgs;
  }
  
  /* Error */
  public void a(int paramInt, Object... paramVarArgs)
  {
    // Byte code:
    //   0: iload_1
    //   1: sipush 1001
    //   4: if_icmpeq +4 -> 8
    //   7: return
    //   8: invokestatic 87	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   11: ifeq +11 -> 22
    //   14: ldc 89
    //   16: iconst_2
    //   17: ldc 91
    //   19: invokestatic 95	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   22: ldc 97
    //   24: astore 14
    //   26: aload_0
    //   27: getfield 31	com/tencent/mobileqq/activity/aio/tips/DiscFreqPttGrayTips:jdField_a_of_type_ComTencentMobileqqActivityAioBaseSessionInfo	Lcom/tencent/mobileqq/activity/aio/BaseSessionInfo;
    //   30: getfield 100	com/tencent/mobileqq/activity/aio/BaseSessionInfo:jdField_a_of_type_Int	I
    //   33: istore_1
    //   34: iload_1
    //   35: sipush 3000
    //   38: if_icmpeq +47 -> 85
    //   41: invokestatic 87	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   44: ifeq +35 -> 79
    //   47: new 102	java/lang/StringBuilder
    //   50: dup
    //   51: invokespecial 103	java/lang/StringBuilder:<init>	()V
    //   54: astore_2
    //   55: aload_2
    //   56: ldc 105
    //   58: invokevirtual 109	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   61: pop
    //   62: aload_2
    //   63: ldc 111
    //   65: invokevirtual 109	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   68: pop
    //   69: ldc 89
    //   71: iconst_2
    //   72: aload_2
    //   73: invokevirtual 114	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   76: invokestatic 95	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   79: return
    //   80: astore 14
    //   82: goto +1354 -> 1436
    //   85: aload_0
    //   86: getfield 26	com/tencent/mobileqq/activity/aio/tips/DiscFreqPttGrayTips:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   89: invokestatic 119	com/tencent/mobileqq/config/operation/QQOperateManager:a	(Lcom/tencent/mobileqq/app/QQAppInterface;)Lcom/tencent/mobileqq/config/operation/QQOperateManager;
    //   92: astore 16
    //   94: aload 16
    //   96: aload_0
    //   97: getfield 31	com/tencent/mobileqq/activity/aio/tips/DiscFreqPttGrayTips:jdField_a_of_type_ComTencentMobileqqActivityAioBaseSessionInfo	Lcom/tencent/mobileqq/activity/aio/BaseSessionInfo;
    //   100: getfield 100	com/tencent/mobileqq/activity/aio/BaseSessionInfo:jdField_a_of_type_Int	I
    //   103: iconst_2
    //   104: invokevirtual 123	com/tencent/mobileqq/config/operation/QQOperateManager:b	(II)Z
    //   107: istore 8
    //   109: iload 8
    //   111: ifeq +42 -> 153
    //   114: invokestatic 87	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   117: ifeq +35 -> 152
    //   120: new 102	java/lang/StringBuilder
    //   123: dup
    //   124: invokespecial 103	java/lang/StringBuilder:<init>	()V
    //   127: astore_2
    //   128: aload_2
    //   129: ldc 105
    //   131: invokevirtual 109	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   134: pop
    //   135: aload_2
    //   136: ldc 125
    //   138: invokevirtual 109	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   141: pop
    //   142: ldc 89
    //   144: iconst_2
    //   145: aload_2
    //   146: invokevirtual 114	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   149: invokestatic 95	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   152: return
    //   153: aload_0
    //   154: getfield 19	com/tencent/mobileqq/activity/aio/tips/DiscFreqPttGrayTips:jdField_a_of_type_ComTencentMobileqqActivityAioCoreAIOContext	Lcom/tencent/mobileqq/activity/aio/core/AIOContext;
    //   157: invokevirtual 128	com/tencent/mobileqq/activity/aio/core/AIOContext:a	()Lcom/tencent/mobileqq/activity/aio/core/msglist/MsgList;
    //   160: invokevirtual 133	com/tencent/mobileqq/activity/aio/core/msglist/MsgList:a	()Lcom/tencent/mobileqq/activity/aio/coreui/msglist/ListUI;
    //   163: invokevirtual 138	com/tencent/mobileqq/activity/aio/coreui/msglist/ListUI:a	()Ljava/util/List;
    //   166: astore 15
    //   168: aload 15
    //   170: ifnonnull +42 -> 212
    //   173: invokestatic 87	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   176: ifeq +35 -> 211
    //   179: new 102	java/lang/StringBuilder
    //   182: dup
    //   183: invokespecial 103	java/lang/StringBuilder:<init>	()V
    //   186: astore_2
    //   187: aload_2
    //   188: ldc 105
    //   190: invokevirtual 109	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   193: pop
    //   194: aload_2
    //   195: ldc 140
    //   197: invokevirtual 109	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   200: pop
    //   201: ldc 89
    //   203: iconst_2
    //   204: aload_2
    //   205: invokevirtual 114	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   208: invokestatic 95	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   211: return
    //   212: aload_0
    //   213: getfield 26	com/tencent/mobileqq/activity/aio/tips/DiscFreqPttGrayTips:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   216: invokevirtual 63	com/tencent/mobileqq/app/QQAppInterface:getApplication	()Lmqq/app/MobileQQ;
    //   219: invokestatic 146	com/tencent/mobileqq/utils/NetworkUtil:isWifiConnected	(Landroid/content/Context;)Z
    //   222: istore 8
    //   224: iload 8
    //   226: ifne +42 -> 268
    //   229: invokestatic 87	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   232: ifeq +35 -> 267
    //   235: new 102	java/lang/StringBuilder
    //   238: dup
    //   239: invokespecial 103	java/lang/StringBuilder:<init>	()V
    //   242: astore_2
    //   243: aload_2
    //   244: ldc 105
    //   246: invokevirtual 109	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   249: pop
    //   250: aload_2
    //   251: ldc 148
    //   253: invokevirtual 109	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   256: pop
    //   257: ldc 89
    //   259: iconst_2
    //   260: aload_2
    //   261: invokevirtual 114	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   264: invokestatic 95	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   267: return
    //   268: aload 15
    //   270: invokeinterface 154 1 0
    //   275: istore_1
    //   276: iload_1
    //   277: iconst_5
    //   278: if_icmpge +91 -> 369
    //   281: aload 14
    //   283: astore_2
    //   284: new 102	java/lang/StringBuilder
    //   287: dup
    //   288: invokespecial 103	java/lang/StringBuilder:<init>	()V
    //   291: astore 16
    //   293: aload 14
    //   295: astore_2
    //   296: aload 16
    //   298: ldc 156
    //   300: invokevirtual 109	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   303: pop
    //   304: aload 14
    //   306: astore_2
    //   307: aload 16
    //   309: aload 15
    //   311: invokeinterface 154 1 0
    //   316: invokevirtual 159	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   319: pop
    //   320: aload 14
    //   322: astore_2
    //   323: aload 16
    //   325: invokevirtual 114	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   328: astore 14
    //   330: invokestatic 87	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   333: ifeq +35 -> 368
    //   336: new 102	java/lang/StringBuilder
    //   339: dup
    //   340: invokespecial 103	java/lang/StringBuilder:<init>	()V
    //   343: astore_2
    //   344: aload_2
    //   345: ldc 105
    //   347: invokevirtual 109	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   350: pop
    //   351: aload_2
    //   352: aload 14
    //   354: invokevirtual 109	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   357: pop
    //   358: ldc 89
    //   360: iconst_2
    //   361: aload_2
    //   362: invokevirtual 114	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   365: invokestatic 95	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   368: return
    //   369: aload_0
    //   370: getfield 31	com/tencent/mobileqq/activity/aio/tips/DiscFreqPttGrayTips:jdField_a_of_type_ComTencentMobileqqActivityAioBaseSessionInfo	Lcom/tencent/mobileqq/activity/aio/BaseSessionInfo;
    //   373: getfield 59	com/tencent/mobileqq/activity/aio/BaseSessionInfo:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   376: invokestatic 165	java/lang/Long:valueOf	(Ljava/lang/String;)Ljava/lang/Long;
    //   379: invokevirtual 168	java/lang/Long:longValue	()J
    //   382: lstore 10
    //   384: aload_0
    //   385: getfield 31	com/tencent/mobileqq/activity/aio/tips/DiscFreqPttGrayTips:jdField_a_of_type_ComTencentMobileqqActivityAioBaseSessionInfo	Lcom/tencent/mobileqq/activity/aio/BaseSessionInfo;
    //   388: getfield 100	com/tencent/mobileqq/activity/aio/BaseSessionInfo:jdField_a_of_type_Int	I
    //   391: invokestatic 173	com/tencent/av/utils/UITools:b	(I)I
    //   394: istore_1
    //   395: aload_0
    //   396: getfield 26	com/tencent/mobileqq/activity/aio/tips/DiscFreqPttGrayTips:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   399: invokevirtual 177	com/tencent/mobileqq/app/QQAppInterface:getAVNotifyCenter	()Lcom/tencent/av/gaudio/AVNotifyCenter;
    //   402: iload_1
    //   403: lload 10
    //   405: invokevirtual 182	com/tencent/av/gaudio/AVNotifyCenter:a	(IJ)Z
    //   408: istore 8
    //   410: iload 8
    //   412: ifeq +42 -> 454
    //   415: invokestatic 87	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   418: ifeq +35 -> 453
    //   421: new 102	java/lang/StringBuilder
    //   424: dup
    //   425: invokespecial 103	java/lang/StringBuilder:<init>	()V
    //   428: astore_2
    //   429: aload_2
    //   430: ldc 105
    //   432: invokevirtual 109	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   435: pop
    //   436: aload_2
    //   437: ldc 184
    //   439: invokevirtual 109	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   442: pop
    //   443: ldc 89
    //   445: iconst_2
    //   446: aload_2
    //   447: invokevirtual 114	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   450: invokestatic 95	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   453: return
    //   454: aload 15
    //   456: invokeinterface 154 1 0
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
    //   487: invokeinterface 188 2 0
    //   492: checkcast 190	com/tencent/mobileqq/data/ChatMessage
    //   495: getfield 193	com/tencent/mobileqq/data/ChatMessage:msgtype	I
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
    //   524: invokestatic 87	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   527: istore 9
    //   529: iload 9
    //   531: ifeq +51 -> 582
    //   534: aload 14
    //   536: astore_2
    //   537: new 102	java/lang/StringBuilder
    //   540: dup
    //   541: invokespecial 103	java/lang/StringBuilder:<init>	()V
    //   544: astore 17
    //   546: aload 14
    //   548: astore_2
    //   549: aload 17
    //   551: ldc 195
    //   553: invokevirtual 109	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   556: pop
    //   557: aload 14
    //   559: astore_2
    //   560: aload 17
    //   562: iload 8
    //   564: invokevirtual 198	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   567: pop
    //   568: aload 14
    //   570: astore_2
    //   571: ldc 89
    //   573: iconst_2
    //   574: aload 17
    //   576: invokevirtual 114	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   579: invokestatic 95	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   582: iload 8
    //   584: ifeq +42 -> 626
    //   587: invokestatic 87	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   590: ifeq +35 -> 625
    //   593: new 102	java/lang/StringBuilder
    //   596: dup
    //   597: invokespecial 103	java/lang/StringBuilder:<init>	()V
    //   600: astore_2
    //   601: aload_2
    //   602: ldc 105
    //   604: invokevirtual 109	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   607: pop
    //   608: aload_2
    //   609: ldc 200
    //   611: invokevirtual 109	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   614: pop
    //   615: ldc 89
    //   617: iconst_2
    //   618: aload_2
    //   619: invokevirtual 114	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   622: invokestatic 95	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   625: return
    //   626: invokestatic 48	com/tencent/mobileqq/service/message/MessageCache:a	()J
    //   629: ldc2_w 201
    //   632: lmul
    //   633: lstore 10
    //   635: aload_0
    //   636: getfield 204	com/tencent/mobileqq/activity/aio/tips/DiscFreqPttGrayTips:jdField_a_of_type_AndroidTextFormatTime	Landroid/text/format/Time;
    //   639: astore_2
    //   640: aload_2
    //   641: ifnonnull +17 -> 658
    //   644: aload 14
    //   646: astore_2
    //   647: aload_0
    //   648: new 206	android/text/format/Time
    //   651: dup
    //   652: invokespecial 207	android/text/format/Time:<init>	()V
    //   655: putfield 204	com/tencent/mobileqq/activity/aio/tips/DiscFreqPttGrayTips:jdField_a_of_type_AndroidTextFormatTime	Landroid/text/format/Time;
    //   658: aload_0
    //   659: getfield 204	com/tencent/mobileqq/activity/aio/tips/DiscFreqPttGrayTips:jdField_a_of_type_AndroidTextFormatTime	Landroid/text/format/Time;
    //   662: lload 10
    //   664: invokevirtual 211	android/text/format/Time:set	(J)V
    //   667: aload_0
    //   668: getfield 204	com/tencent/mobileqq/activity/aio/tips/DiscFreqPttGrayTips:jdField_a_of_type_AndroidTextFormatTime	Landroid/text/format/Time;
    //   671: getfield 214	android/text/format/Time:year	I
    //   674: istore_1
    //   675: aload_0
    //   676: getfield 204	com/tencent/mobileqq/activity/aio/tips/DiscFreqPttGrayTips:jdField_a_of_type_AndroidTextFormatTime	Landroid/text/format/Time;
    //   679: getfield 217	android/text/format/Time:month	I
    //   682: istore_3
    //   683: aload_0
    //   684: getfield 204	com/tencent/mobileqq/activity/aio/tips/DiscFreqPttGrayTips:jdField_a_of_type_AndroidTextFormatTime	Landroid/text/format/Time;
    //   687: getfield 220	android/text/format/Time:monthDay	I
    //   690: istore 4
    //   692: new 102	java/lang/StringBuilder
    //   695: dup
    //   696: invokespecial 103	java/lang/StringBuilder:<init>	()V
    //   699: astore_2
    //   700: aload_2
    //   701: ldc 222
    //   703: invokevirtual 109	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   706: pop
    //   707: aload_2
    //   708: aload_0
    //   709: getfield 26	com/tencent/mobileqq/activity/aio/tips/DiscFreqPttGrayTips:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   712: invokevirtual 54	com/tencent/mobileqq/app/QQAppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   715: invokevirtual 109	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   718: pop
    //   719: aload_2
    //   720: invokevirtual 114	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   723: astore_2
    //   724: invokestatic 228	com/tencent/qphone/base/util/BaseApplication:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   727: ldc 230
    //   729: iconst_0
    //   730: invokevirtual 234	com/tencent/qphone/base/util/BaseApplication:getSharedPreferences	(Ljava/lang/String;I)Landroid/content/SharedPreferences;
    //   733: astore 17
    //   735: aload 17
    //   737: aload_2
    //   738: aconst_null
    //   739: invokeinterface 239 3 0
    //   744: astore 18
    //   746: invokestatic 87	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   749: ifeq +737 -> 1486
    //   752: new 102	java/lang/StringBuilder
    //   755: dup
    //   756: invokespecial 103	java/lang/StringBuilder:<init>	()V
    //   759: astore 19
    //   761: aload 19
    //   763: iload_1
    //   764: invokevirtual 159	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   767: pop
    //   768: aload 19
    //   770: ldc 241
    //   772: invokevirtual 109	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   775: pop
    //   776: aload 19
    //   778: iload_3
    //   779: invokevirtual 159	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   782: pop
    //   783: aload 19
    //   785: ldc 241
    //   787: invokevirtual 109	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   790: pop
    //   791: aload 19
    //   793: iload 4
    //   795: invokevirtual 159	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   798: pop
    //   799: aload 19
    //   801: invokevirtual 114	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   804: astore 19
    //   806: new 102	java/lang/StringBuilder
    //   809: dup
    //   810: invokespecial 103	java/lang/StringBuilder:<init>	()V
    //   813: astore 14
    //   815: aload 14
    //   817: ldc 243
    //   819: invokevirtual 109	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   822: pop
    //   823: aload 14
    //   825: aload 19
    //   827: invokevirtual 109	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   830: pop
    //   831: aload 14
    //   833: ldc 245
    //   835: invokevirtual 109	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   838: pop
    //   839: aload 14
    //   841: aload_0
    //   842: getfield 204	com/tencent/mobileqq/activity/aio/tips/DiscFreqPttGrayTips:jdField_a_of_type_AndroidTextFormatTime	Landroid/text/format/Time;
    //   845: getfield 248	android/text/format/Time:hour	I
    //   848: invokevirtual 159	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   851: pop
    //   852: aload 14
    //   854: ldc 250
    //   856: invokevirtual 109	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   859: pop
    //   860: aload 14
    //   862: aload 18
    //   864: invokevirtual 109	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   867: pop
    //   868: ldc 252
    //   870: iconst_2
    //   871: aload 14
    //   873: invokevirtual 114	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   876: invokestatic 95	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   879: goto +3 -> 882
    //   882: aload 18
    //   884: invokestatic 258	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   887: ifne +101 -> 988
    //   890: aload_0
    //   891: getfield 204	com/tencent/mobileqq/activity/aio/tips/DiscFreqPttGrayTips:jdField_a_of_type_AndroidTextFormatTime	Landroid/text/format/Time;
    //   894: aload 18
    //   896: invokestatic 262	java/lang/Long:parseLong	(Ljava/lang/String;)J
    //   899: invokevirtual 211	android/text/format/Time:set	(J)V
    //   902: aload_0
    //   903: getfield 204	com/tencent/mobileqq/activity/aio/tips/DiscFreqPttGrayTips:jdField_a_of_type_AndroidTextFormatTime	Landroid/text/format/Time;
    //   906: getfield 214	android/text/format/Time:year	I
    //   909: istore 5
    //   911: aload_0
    //   912: getfield 204	com/tencent/mobileqq/activity/aio/tips/DiscFreqPttGrayTips:jdField_a_of_type_AndroidTextFormatTime	Landroid/text/format/Time;
    //   915: getfield 217	android/text/format/Time:month	I
    //   918: istore 6
    //   920: aload_0
    //   921: getfield 204	com/tencent/mobileqq/activity/aio/tips/DiscFreqPttGrayTips:jdField_a_of_type_AndroidTextFormatTime	Landroid/text/format/Time;
    //   924: getfield 220	android/text/format/Time:monthDay	I
    //   927: istore 7
    //   929: iload_1
    //   930: iload 5
    //   932: if_icmpne +56 -> 988
    //   935: iload_3
    //   936: iload 6
    //   938: if_icmpne +50 -> 988
    //   941: iload 4
    //   943: iload 7
    //   945: if_icmpne +43 -> 988
    //   948: invokestatic 87	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   951: ifeq +36 -> 987
    //   954: new 102	java/lang/StringBuilder
    //   957: dup
    //   958: invokespecial 103	java/lang/StringBuilder:<init>	()V
    //   961: astore_2
    //   962: aload_2
    //   963: ldc 105
    //   965: invokevirtual 109	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   968: pop
    //   969: aload_2
    //   970: ldc_w 264
    //   973: invokevirtual 109	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   976: pop
    //   977: ldc 89
    //   979: iconst_2
    //   980: aload_2
    //   981: invokevirtual 114	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   984: invokestatic 95	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   987: return
    //   988: new 102	java/lang/StringBuilder
    //   991: dup
    //   992: invokespecial 103	java/lang/StringBuilder:<init>	()V
    //   995: astore 14
    //   997: aload 14
    //   999: ldc_w 266
    //   1002: invokevirtual 109	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1005: pop
    //   1006: aload 14
    //   1008: aload_0
    //   1009: getfield 26	com/tencent/mobileqq/activity/aio/tips/DiscFreqPttGrayTips:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   1012: invokevirtual 54	com/tencent/mobileqq/app/QQAppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   1015: invokevirtual 109	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1018: pop
    //   1019: aload 17
    //   1021: aload 14
    //   1023: invokevirtual 114	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1026: aconst_null
    //   1027: invokeinterface 239 3 0
    //   1032: astore 14
    //   1034: aload 14
    //   1036: invokestatic 258	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   1039: ifne +58 -> 1097
    //   1042: lload 10
    //   1044: aload 14
    //   1046: invokestatic 262	java/lang/Long:parseLong	(Ljava/lang/String;)J
    //   1049: lsub
    //   1050: ldc2_w 267
    //   1053: lcmp
    //   1054: ifgt +43 -> 1097
    //   1057: invokestatic 87	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1060: ifeq +36 -> 1096
    //   1063: new 102	java/lang/StringBuilder
    //   1066: dup
    //   1067: invokespecial 103	java/lang/StringBuilder:<init>	()V
    //   1070: astore_2
    //   1071: aload_2
    //   1072: ldc 105
    //   1074: invokevirtual 109	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1077: pop
    //   1078: aload_2
    //   1079: ldc_w 270
    //   1082: invokevirtual 109	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1085: pop
    //   1086: ldc 89
    //   1088: iconst_2
    //   1089: aload_2
    //   1090: invokevirtual 114	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1093: invokestatic 95	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1096: return
    //   1097: lload 10
    //   1099: ldc2_w 267
    //   1102: lsub
    //   1103: ldc2_w 201
    //   1106: ldiv
    //   1107: lstore 12
    //   1109: aload 15
    //   1111: invokeinterface 154 1 0
    //   1116: istore_1
    //   1117: new 272	java/util/HashSet
    //   1120: dup
    //   1121: invokespecial 273	java/util/HashSet:<init>	()V
    //   1124: astore 14
    //   1126: iload_1
    //   1127: iconst_1
    //   1128: isub
    //   1129: istore_3
    //   1130: iconst_0
    //   1131: istore_1
    //   1132: iload_3
    //   1133: iflt +74 -> 1207
    //   1136: aload 15
    //   1138: iload_3
    //   1139: invokeinterface 188 2 0
    //   1144: checkcast 190	com/tencent/mobileqq/data/ChatMessage
    //   1147: astore 18
    //   1149: iload_1
    //   1150: istore 4
    //   1152: aload 18
    //   1154: getfield 277	com/tencent/mobileqq/data/ChatMessage:time	J
    //   1157: lload 12
    //   1159: lcmp
    //   1160: iflt +329 -> 1489
    //   1163: iload_1
    //   1164: istore 4
    //   1166: aload 18
    //   1168: getfield 193	com/tencent/mobileqq/data/ChatMessage:msgtype	I
    //   1171: sipush -2002
    //   1174: if_icmpne +315 -> 1489
    //   1177: iload_1
    //   1178: istore 4
    //   1180: aload 18
    //   1182: getfield 280	com/tencent/mobileqq/data/ChatMessage:extraflag	I
    //   1185: ifne +304 -> 1489
    //   1188: iload_1
    //   1189: iconst_1
    //   1190: iadd
    //   1191: istore 4
    //   1193: aload 14
    //   1195: aload 18
    //   1197: getfield 283	com/tencent/mobileqq/data/ChatMessage:senderuin	Ljava/lang/String;
    //   1200: invokevirtual 287	java/util/HashSet:add	(Ljava/lang/Object;)Z
    //   1203: pop
    //   1204: goto +285 -> 1489
    //   1207: aload 14
    //   1209: invokevirtual 288	java/util/HashSet:size	()I
    //   1212: istore_3
    //   1213: iload_1
    //   1214: iconst_5
    //   1215: if_icmplt +121 -> 1336
    //   1218: iload_3
    //   1219: iconst_2
    //   1220: if_icmplt +116 -> 1336
    //   1223: aload_0
    //   1224: getfield 36	com/tencent/mobileqq/activity/aio/tips/DiscFreqPttGrayTips:jdField_a_of_type_ComTencentMobileqqActivityAioTipsTipsManager	Lcom/tencent/mobileqq/activity/aio/tips/TipsManager;
    //   1227: aload_0
    //   1228: iconst_0
    //   1229: anewarray 4	java/lang/Object
    //   1232: invokevirtual 293	com/tencent/mobileqq/activity/aio/tips/TipsManager:a	(Lcom/tencent/mobileqq/activity/aio/tips/GrayTipsTask;[Ljava/lang/Object;)Z
    //   1235: ifeq +95 -> 1330
    //   1238: aload 16
    //   1240: aload_0
    //   1241: getfield 26	com/tencent/mobileqq/activity/aio/tips/DiscFreqPttGrayTips:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   1244: aload_0
    //   1245: getfield 31	com/tencent/mobileqq/activity/aio/tips/DiscFreqPttGrayTips:jdField_a_of_type_ComTencentMobileqqActivityAioBaseSessionInfo	Lcom/tencent/mobileqq/activity/aio/BaseSessionInfo;
    //   1248: getfield 100	com/tencent/mobileqq/activity/aio/BaseSessionInfo:jdField_a_of_type_Int	I
    //   1251: iconst_2
    //   1252: invokevirtual 296	com/tencent/mobileqq/config/operation/QQOperateManager:a	(Lcom/tencent/mobileqq/app/QQAppInterface;II)V
    //   1255: aload 17
    //   1257: invokeinterface 300 1 0
    //   1262: astore 14
    //   1264: aload 14
    //   1266: aload_2
    //   1267: lload 10
    //   1269: invokestatic 305	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   1272: invokeinterface 311 3 0
    //   1277: pop
    //   1278: aload 14
    //   1280: invokeinterface 314 1 0
    //   1285: pop
    //   1286: ldc_w 316
    //   1289: astore 14
    //   1291: aload 14
    //   1293: astore_2
    //   1294: aload_0
    //   1295: getfield 26	com/tencent/mobileqq/activity/aio/tips/DiscFreqPttGrayTips:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   1298: ldc_w 318
    //   1301: ldc 97
    //   1303: ldc 97
    //   1305: ldc_w 320
    //   1308: ldc_w 320
    //   1311: iconst_0
    //   1312: iconst_0
    //   1313: ldc 97
    //   1315: ldc 97
    //   1317: ldc 97
    //   1319: ldc 97
    //   1321: invokestatic 325	com/tencent/mobileqq/statistics/ReportController:b	(Lmqq/app/AppRuntime;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   1324: aload 14
    //   1326: astore_2
    //   1327: goto +50 -> 1377
    //   1330: ldc 97
    //   1332: astore_2
    //   1333: goto +44 -> 1377
    //   1336: new 102	java/lang/StringBuilder
    //   1339: dup
    //   1340: invokespecial 103	java/lang/StringBuilder:<init>	()V
    //   1343: astore_2
    //   1344: aload_2
    //   1345: ldc_w 327
    //   1348: invokevirtual 109	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1351: pop
    //   1352: aload_2
    //   1353: iload_1
    //   1354: invokevirtual 159	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1357: pop
    //   1358: aload_2
    //   1359: ldc_w 329
    //   1362: invokevirtual 109	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1365: pop
    //   1366: aload_2
    //   1367: iload_3
    //   1368: invokevirtual 159	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1371: pop
    //   1372: aload_2
    //   1373: invokevirtual 114	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1376: astore_2
    //   1377: invokestatic 87	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1380: ifeq +38 -> 1418
    //   1383: new 102	java/lang/StringBuilder
    //   1386: dup
    //   1387: invokespecial 103	java/lang/StringBuilder:<init>	()V
    //   1390: astore 14
    //   1392: aload 14
    //   1394: ldc 105
    //   1396: invokevirtual 109	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1399: pop
    //   1400: aload 14
    //   1402: aload_2
    //   1403: invokevirtual 109	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1406: pop
    //   1407: ldc 89
    //   1409: iconst_2
    //   1410: aload 14
    //   1412: invokevirtual 114	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1415: invokestatic 95	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1418: return
    //   1419: astore 14
    //   1421: ldc 97
    //   1423: astore_2
    //   1424: goto +12 -> 1436
    //   1427: astore 15
    //   1429: aload 14
    //   1431: astore_2
    //   1432: aload 15
    //   1434: astore 14
    //   1436: invokestatic 87	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1439: ifeq +38 -> 1477
    //   1442: new 102	java/lang/StringBuilder
    //   1445: dup
    //   1446: invokespecial 103	java/lang/StringBuilder:<init>	()V
    //   1449: astore 15
    //   1451: aload 15
    //   1453: ldc 105
    //   1455: invokevirtual 109	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1458: pop
    //   1459: aload 15
    //   1461: aload_2
    //   1462: invokevirtual 109	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1465: pop
    //   1466: ldc 89
    //   1468: iconst_2
    //   1469: aload 15
    //   1471: invokevirtual 114	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1474: invokestatic 95	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1477: goto +6 -> 1483
    //   1480: aload 14
    //   1482: athrow
    //   1483: goto -3 -> 1480
    //   1486: goto -604 -> 882
    //   1489: iload_3
    //   1490: iconst_1
    //   1491: isub
    //   1492: istore_3
    //   1493: iload 4
    //   1495: istore_1
    //   1496: goto -364 -> 1132
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1499	0	this	DiscFreqPttGrayTips
    //   0	1499	1	paramInt	int
    //   0	1499	2	paramVarArgs	Object[]
    //   461	1032	3	i	int
    //   498	996	4	j	int
    //   909	24	5	k	int
    //   918	21	6	m	int
    //   927	19	7	n	int
    //   107	476	8	bool1	boolean
    //   527	3	9	bool2	boolean
    //   382	886	10	l1	long
    //   1107	51	12	l2	long
    //   24	1	14	str	String
    //   80	241	14	localObject1	Object
    //   328	1083	14	localObject2	Object
    //   1419	11	14	localObject3	Object
    //   1434	47	14	localObject4	Object
    //   166	971	15	localList	java.util.List
    //   1427	6	15	localObject5	Object
    //   1449	21	15	localStringBuilder	java.lang.StringBuilder
    //   92	1147	16	localObject6	Object
    //   544	712	17	localObject7	Object
    //   744	452	18	localObject8	Object
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
    //   1294	1324	80	finally
    //   806	879	1419	finally
    //   882	929	1419	finally
    //   988	1057	1419	finally
    //   1097	1126	1419	finally
    //   1136	1149	1419	finally
    //   1152	1163	1419	finally
    //   1166	1177	1419	finally
    //   1180	1188	1419	finally
    //   1193	1204	1419	finally
    //   1207	1213	1419	finally
    //   1223	1286	1419	finally
    //   1336	1377	1419	finally
    //   26	34	1427	finally
    //   85	109	1427	finally
    //   153	168	1427	finally
    //   212	224	1427	finally
    //   268	276	1427	finally
    //   369	410	1427	finally
    //   454	462	1427	finally
    //   524	529	1427	finally
    //   626	640	1427	finally
    //   658	806	1427	finally
  }
  
  public int[] a()
  {
    return null;
  }
  
  public int b()
  {
    return 1001;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.tips.DiscFreqPttGrayTips
 * JD-Core Version:    0.7.0.1
 */