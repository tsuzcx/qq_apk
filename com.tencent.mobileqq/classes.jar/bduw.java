import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.transfile.ForwardSdkShareProcessor.RichStep.1;
import com.tencent.qphone.base.util.QLog;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

public class bduw
  extends bduq
{
  private AtomicInteger a;
  public boolean a;
  private AtomicBoolean c = new AtomicBoolean(false);
  
  bduw(bdup parambdup)
  {
    super(parambdup);
    this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger = new AtomicInteger(0);
    this.jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_JavaLangString = "RichStep";
    g();
  }
  
  /* Error */
  private int a()
  {
    // Byte code:
    //   0: aload_0
    //   1: invokespecial 49	bduw:h	()V
    //   4: invokestatic 55	java/lang/System:currentTimeMillis	()J
    //   7: lstore 6
    //   9: iconst_m1
    //   10: istore_2
    //   11: aload_0
    //   12: getfield 15	bduw:jdField_b_of_type_Bdup	Lbdup;
    //   15: invokestatic 60	bdup:a	(Lbdup;)I
    //   18: istore 5
    //   20: iload_2
    //   21: istore_1
    //   22: aload_0
    //   23: getfield 15	bduw:jdField_b_of_type_Bdup	Lbdup;
    //   26: getfield 63	bdup:jdField_a_of_type_AndroidContentContext	Landroid/content/Context;
    //   29: aload_0
    //   30: getfield 15	bduw:jdField_b_of_type_Bdup	Lbdup;
    //   33: invokestatic 67	bdup:e	(Lbdup;)Ljava/lang/String;
    //   36: aload_0
    //   37: getfield 15	bduw:jdField_b_of_type_Bdup	Lbdup;
    //   40: getfield 70	bdup:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   43: invokevirtual 76	com/tencent/mobileqq/app/QQAppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   46: invokestatic 81	bitd:a	(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;)[Ljava/lang/Object;
    //   49: astore 11
    //   51: iload_2
    //   52: istore_1
    //   53: aload 11
    //   55: iconst_0
    //   56: aaload
    //   57: checkcast 83	java/lang/Integer
    //   60: invokevirtual 86	java/lang/Integer:intValue	()I
    //   63: istore_2
    //   64: iload_2
    //   65: ifne +599 -> 664
    //   68: iload_2
    //   69: istore_1
    //   70: aload 11
    //   72: iconst_1
    //   73: aaload
    //   74: checkcast 88	java/lang/String
    //   77: astore 9
    //   79: iload_2
    //   80: istore_1
    //   81: aload 11
    //   83: iconst_2
    //   84: aaload
    //   85: checkcast 88	java/lang/String
    //   88: astore 10
    //   90: iload_2
    //   91: istore_1
    //   92: aload 11
    //   94: iconst_3
    //   95: aaload
    //   96: checkcast 88	java/lang/String
    //   99: astore 11
    //   101: iload_2
    //   102: istore_1
    //   103: aload 9
    //   105: invokestatic 94	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   108: istore 8
    //   110: iload 8
    //   112: ifne +546 -> 658
    //   115: aload_0
    //   116: getfield 15	bduw:jdField_b_of_type_Bdup	Lbdup;
    //   119: invokestatic 97	bdup:d	(Lbdup;)Ljava/lang/String;
    //   122: invokestatic 94	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   125: ifeq +31 -> 156
    //   128: aload_0
    //   129: getfield 15	bduw:jdField_b_of_type_Bdup	Lbdup;
    //   132: aload_0
    //   133: getfield 15	bduw:jdField_b_of_type_Bdup	Lbdup;
    //   136: invokestatic 60	bdup:a	(Lbdup;)I
    //   139: bipush 251
    //   141: iand
    //   142: invokestatic 100	bdup:a	(Lbdup;I)I
    //   145: pop
    //   146: aload_0
    //   147: getfield 15	bduw:jdField_b_of_type_Bdup	Lbdup;
    //   150: aload 9
    //   152: invokestatic 103	bdup:a	(Lbdup;Ljava/lang/String;)Ljava/lang/String;
    //   155: pop
    //   156: iconst_4
    //   157: istore 4
    //   159: iload 4
    //   161: istore_3
    //   162: iload 4
    //   164: istore_1
    //   165: aload 10
    //   167: invokestatic 94	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   170: ifne +65 -> 235
    //   173: iload 4
    //   175: iconst_2
    //   176: ior
    //   177: istore 4
    //   179: iload 4
    //   181: istore_3
    //   182: iload 4
    //   184: istore_1
    //   185: aload_0
    //   186: getfield 15	bduw:jdField_b_of_type_Bdup	Lbdup;
    //   189: invokestatic 105	bdup:c	(Lbdup;)Ljava/lang/String;
    //   192: invokestatic 94	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   195: ifeq +40 -> 235
    //   198: iload 4
    //   200: istore_1
    //   201: aload_0
    //   202: getfield 15	bduw:jdField_b_of_type_Bdup	Lbdup;
    //   205: aload_0
    //   206: getfield 15	bduw:jdField_b_of_type_Bdup	Lbdup;
    //   209: invokestatic 60	bdup:a	(Lbdup;)I
    //   212: bipush 253
    //   214: iand
    //   215: invokestatic 100	bdup:a	(Lbdup;I)I
    //   218: pop
    //   219: iload 4
    //   221: istore_1
    //   222: aload_0
    //   223: getfield 15	bduw:jdField_b_of_type_Bdup	Lbdup;
    //   226: aload 10
    //   228: invokestatic 107	bdup:b	(Lbdup;Ljava/lang/String;)Ljava/lang/String;
    //   231: pop
    //   232: iload 4
    //   234: istore_3
    //   235: iload_3
    //   236: istore 4
    //   238: iload_3
    //   239: istore_1
    //   240: aload 11
    //   242: invokestatic 94	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   245: ifne +78 -> 323
    //   248: iload_3
    //   249: iconst_1
    //   250: ior
    //   251: istore_3
    //   252: iload_3
    //   253: istore 4
    //   255: iload_3
    //   256: istore_1
    //   257: aload_0
    //   258: getfield 15	bduw:jdField_b_of_type_Bdup	Lbdup;
    //   261: invokestatic 109	bdup:a	(Lbdup;)Ljava/lang/String;
    //   264: invokestatic 94	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   267: ifeq +56 -> 323
    //   270: iload_3
    //   271: istore 4
    //   273: iload_3
    //   274: istore_1
    //   275: aload_0
    //   276: getfield 15	bduw:jdField_b_of_type_Bdup	Lbdup;
    //   279: invokestatic 111	bdup:b	(Lbdup;)Ljava/lang/String;
    //   282: invokestatic 94	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   285: ifeq +38 -> 323
    //   288: iload_3
    //   289: istore_1
    //   290: aload_0
    //   291: getfield 15	bduw:jdField_b_of_type_Bdup	Lbdup;
    //   294: aload_0
    //   295: getfield 15	bduw:jdField_b_of_type_Bdup	Lbdup;
    //   298: invokestatic 60	bdup:a	(Lbdup;)I
    //   301: bipush 254
    //   303: iand
    //   304: invokestatic 100	bdup:a	(Lbdup;I)I
    //   307: pop
    //   308: iload_3
    //   309: istore_1
    //   310: aload_0
    //   311: getfield 15	bduw:jdField_b_of_type_Bdup	Lbdup;
    //   314: aload 11
    //   316: invokestatic 113	bdup:c	(Lbdup;Ljava/lang/String;)Ljava/lang/String;
    //   319: pop
    //   320: iload_3
    //   321: istore 4
    //   323: iload 4
    //   325: istore_1
    //   326: aload_0
    //   327: getfield 24	bduw:c	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   330: iconst_0
    //   331: invokevirtual 116	java/util/concurrent/atomic/AtomicBoolean:set	(Z)V
    //   334: iload 4
    //   336: istore_1
    //   337: aload_0
    //   338: getfield 15	bduw:jdField_b_of_type_Bdup	Lbdup;
    //   341: getfield 70	bdup:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   344: invokevirtual 119	com/tencent/mobileqq/app/QQAppInterface:a	()Lcom/tencent/imcore/message/QQMessageFacade;
    //   347: aload_0
    //   348: getfield 15	bduw:jdField_b_of_type_Bdup	Lbdup;
    //   351: getfield 122	bdup:jdField_a_of_type_Bdzn	Lbdzn;
    //   354: getfield 126	bdzn:c	Ljava/lang/String;
    //   357: aload_0
    //   358: getfield 15	bduw:jdField_b_of_type_Bdup	Lbdup;
    //   361: getfield 122	bdup:jdField_a_of_type_Bdzn	Lbdzn;
    //   364: getfield 129	bdzn:jdField_a_of_type_Int	I
    //   367: aload_0
    //   368: getfield 15	bduw:jdField_b_of_type_Bdup	Lbdup;
    //   371: getfield 122	bdup:jdField_a_of_type_Bdzn	Lbdzn;
    //   374: getfield 132	bdzn:jdField_a_of_type_Long	J
    //   377: invokevirtual 137	com/tencent/imcore/message/QQMessageFacade:b	(Ljava/lang/String;IJ)Lcom/tencent/mobileqq/data/MessageRecord;
    //   380: astore 9
    //   382: iload 4
    //   384: istore_1
    //   385: aload 9
    //   387: instanceof 139
    //   390: ifeq +185 -> 575
    //   393: iload 4
    //   395: istore_1
    //   396: aload 9
    //   398: checkcast 139	com/tencent/mobileqq/data/MessageForStructing
    //   401: getfield 143	com/tencent/mobileqq/data/MessageForStructing:structingMsg	Lcom/tencent/mobileqq/structmsg/AbsStructMsg;
    //   404: instanceof 145
    //   407: ifeq +168 -> 575
    //   410: iload 4
    //   412: istore_1
    //   413: aload 9
    //   415: checkcast 139	com/tencent/mobileqq/data/MessageForStructing
    //   418: getfield 143	com/tencent/mobileqq/data/MessageForStructing:structingMsg	Lcom/tencent/mobileqq/structmsg/AbsStructMsg;
    //   421: checkcast 145	com/tencent/mobileqq/structmsg/AbsShareMsg
    //   424: astore 9
    //   426: iload 4
    //   428: istore_1
    //   429: aload_0
    //   430: getfield 15	bduw:jdField_b_of_type_Bdup	Lbdup;
    //   433: invokestatic 97	bdup:d	(Lbdup;)Ljava/lang/String;
    //   436: ifnull +18 -> 454
    //   439: iload 4
    //   441: istore_1
    //   442: aload_0
    //   443: getfield 15	bduw:jdField_b_of_type_Bdup	Lbdup;
    //   446: invokestatic 97	bdup:d	(Lbdup;)Ljava/lang/String;
    //   449: iconst_0
    //   450: invokestatic 150	bbzj:a	(Ljava/lang/String;Z)Ljava/lang/String;
    //   453: pop
    //   454: iload 4
    //   456: istore_1
    //   457: aload_0
    //   458: getfield 15	bduw:jdField_b_of_type_Bdup	Lbdup;
    //   461: invokestatic 105	bdup:c	(Lbdup;)Ljava/lang/String;
    //   464: ifnull +18 -> 482
    //   467: iload 4
    //   469: istore_1
    //   470: aload_0
    //   471: getfield 15	bduw:jdField_b_of_type_Bdup	Lbdup;
    //   474: invokestatic 105	bdup:c	(Lbdup;)Ljava/lang/String;
    //   477: iconst_0
    //   478: invokestatic 150	bbzj:a	(Ljava/lang/String;Z)Ljava/lang/String;
    //   481: pop
    //   482: iload 4
    //   484: istore_1
    //   485: aload 9
    //   487: aload_0
    //   488: getfield 15	bduw:jdField_b_of_type_Bdup	Lbdup;
    //   491: invokestatic 97	bdup:d	(Lbdup;)Ljava/lang/String;
    //   494: aload_0
    //   495: getfield 15	bduw:jdField_b_of_type_Bdup	Lbdup;
    //   498: invokestatic 105	bdup:c	(Lbdup;)Ljava/lang/String;
    //   501: aload_0
    //   502: getfield 15	bduw:jdField_b_of_type_Bdup	Lbdup;
    //   505: invokestatic 109	bdup:a	(Lbdup;)Ljava/lang/String;
    //   508: invokevirtual 154	com/tencent/mobileqq/structmsg/AbsShareMsg:updateTitleSummaryAndCover	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   511: iload 4
    //   513: istore_1
    //   514: aload_0
    //   515: getfield 15	bduw:jdField_b_of_type_Bdup	Lbdup;
    //   518: getfield 70	bdup:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   521: invokevirtual 119	com/tencent/mobileqq/app/QQAppInterface:a	()Lcom/tencent/imcore/message/QQMessageFacade;
    //   524: aload_0
    //   525: getfield 15	bduw:jdField_b_of_type_Bdup	Lbdup;
    //   528: getfield 122	bdup:jdField_a_of_type_Bdzn	Lbdzn;
    //   531: getfield 126	bdzn:c	Ljava/lang/String;
    //   534: aload_0
    //   535: getfield 15	bduw:jdField_b_of_type_Bdup	Lbdup;
    //   538: getfield 122	bdup:jdField_a_of_type_Bdzn	Lbdzn;
    //   541: getfield 129	bdzn:jdField_a_of_type_Int	I
    //   544: aload_0
    //   545: getfield 15	bduw:jdField_b_of_type_Bdup	Lbdup;
    //   548: getfield 122	bdup:jdField_a_of_type_Bdzn	Lbdzn;
    //   551: getfield 132	bdzn:jdField_a_of_type_Long	J
    //   554: aload 9
    //   556: invokevirtual 158	com/tencent/mobileqq/structmsg/AbsShareMsg:getBytes	()[B
    //   559: invokevirtual 161	com/tencent/imcore/message/QQMessageFacade:a	(Ljava/lang/String;IJ[B)V
    //   562: iload 4
    //   564: istore_1
    //   565: aload_0
    //   566: getfield 15	bduw:jdField_b_of_type_Bdup	Lbdup;
    //   569: sipush 1002
    //   572: invokevirtual 163	bdup:d	(I)V
    //   575: iload 4
    //   577: istore_1
    //   578: iload_1
    //   579: istore_3
    //   580: iload_2
    //   581: istore 4
    //   583: aload_0
    //   584: iload 4
    //   586: invokestatic 55	java/lang/System:currentTimeMillis	()J
    //   589: lload 6
    //   591: lsub
    //   592: iload 5
    //   594: iload_3
    //   595: invokespecial 166	bduw:a	(IJII)V
    //   598: iload 4
    //   600: ireturn
    //   601: astore 9
    //   603: iconst_0
    //   604: istore_2
    //   605: iload_1
    //   606: istore 4
    //   608: iload_2
    //   609: istore_3
    //   610: invokestatic 172	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   613: ifeq -30 -> 583
    //   616: ldc 174
    //   618: iconst_4
    //   619: aload 9
    //   621: iconst_0
    //   622: anewarray 176	java/lang/Object
    //   625: invokestatic 179	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/Throwable;[Ljava/lang/Object;)V
    //   628: iload_1
    //   629: istore 4
    //   631: iload_2
    //   632: istore_3
    //   633: goto -50 -> 583
    //   636: astore 9
    //   638: iconst_4
    //   639: istore_3
    //   640: iload_2
    //   641: istore_1
    //   642: iload_3
    //   643: istore_2
    //   644: goto -39 -> 605
    //   647: astore 9
    //   649: iload_1
    //   650: istore_3
    //   651: iload_2
    //   652: istore_1
    //   653: iload_3
    //   654: istore_2
    //   655: goto -50 -> 605
    //   658: iconst_0
    //   659: istore 4
    //   661: goto -502 -> 159
    //   664: iconst_0
    //   665: istore_1
    //   666: goto -88 -> 578
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	669	0	this	bduw
    //   21	645	1	i	int
    //   10	645	2	j	int
    //   161	493	3	k	int
    //   157	503	4	m	int
    //   18	575	5	n	int
    //   7	583	6	l	long
    //   108	3	8	bool	boolean
    //   77	478	9	localObject1	Object
    //   601	19	9	localException1	java.lang.Exception
    //   636	1	9	localException2	java.lang.Exception
    //   647	1	9	localException3	java.lang.Exception
    //   88	139	10	str	String
    //   49	266	11	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   22	51	601	java/lang/Exception
    //   53	64	601	java/lang/Exception
    //   70	79	601	java/lang/Exception
    //   81	90	601	java/lang/Exception
    //   92	101	601	java/lang/Exception
    //   103	110	601	java/lang/Exception
    //   115	156	636	java/lang/Exception
    //   165	173	647	java/lang/Exception
    //   185	198	647	java/lang/Exception
    //   201	219	647	java/lang/Exception
    //   222	232	647	java/lang/Exception
    //   240	248	647	java/lang/Exception
    //   257	270	647	java/lang/Exception
    //   275	288	647	java/lang/Exception
    //   290	308	647	java/lang/Exception
    //   310	320	647	java/lang/Exception
    //   326	334	647	java/lang/Exception
    //   337	382	647	java/lang/Exception
    //   385	393	647	java/lang/Exception
    //   396	410	647	java/lang/Exception
    //   413	426	647	java/lang/Exception
    //   429	439	647	java/lang/Exception
    //   442	454	647	java/lang/Exception
    //   457	467	647	java/lang/Exception
    //   470	482	647	java/lang/Exception
    //   485	511	647	java/lang/Exception
    //   514	562	647	java/lang/Exception
    //   565	575	647	java/lang/Exception
  }
  
  private void a(int paramInt1, long paramLong, int paramInt2, int paramInt3)
  {
    Object localObject = new Bundle();
    ((Bundle)localObject).putString("report_type", "102");
    ((Bundle)localObject).putString("act_type", "13");
    ((Bundle)localObject).putString("intext_3", "0");
    StringBuilder localStringBuilder = new StringBuilder().append("");
    if (paramInt1 != 0) {}
    for (int i = 1;; i = 0)
    {
      ((Bundle)localObject).putString("intext_1", i);
      ((Bundle)localObject).putString("stringext_2", "" + paramInt1);
      ((Bundle)localObject).putString("stringext_3", "1");
      ((Bundle)localObject).putString("intext_5", "" + paramLong);
      ((Bundle)localObject).putString("intext_2", "" + paramInt2);
      ((Bundle)localObject).putString("intext_4", "" + paramInt3);
      if (paramInt1 != 0) {
        ((Bundle)localObject).putString("stringext_1", bdup.e(this.jdField_b_of_type_Bdup));
      }
      bipi.a().a((Bundle)localObject, "", this.jdField_b_of_type_Bdup.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), false);
      if (QLog.isColorLevel())
      {
        localObject = "RichStep|run|ret=" + paramInt1 + ",lack=" + bdup.a(this.jdField_b_of_type_Bdup) + ",cost=" + paramLong;
        if ((paramInt1 == 0) && (paramLong <= 3000L)) {
          break;
        }
        QLog.e("BaseTransProcessor", 2, (String)localObject);
      }
      return;
    }
    QLog.d("BaseTransProcessor", 2, (String)localObject);
  }
  
  private void h()
  {
    Bundle localBundle = new Bundle();
    localBundle.putString("report_type", "102");
    localBundle.putString("act_type", "53");
    localBundle.putString("intext_4", "1");
    localBundle.putString("intext_3", "0");
    localBundle.putString("intext_2", "" + bdup.a(this.jdField_b_of_type_Bdup));
    localBundle.putString("stringext_1", bdup.e(this.jdField_b_of_type_Bdup));
    bipi.a().a(localBundle, "", this.jdField_b_of_type_Bdup.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), false);
  }
  
  protected boolean a()
  {
    return (!this.c.get()) || (this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.get() >= 2);
  }
  
  protected void d()
  {
    QLog.d("Q.share.ForwardSdkShareProcessor", 1, "RichStep|process|neeRich=" + this.c + ",lack=" + bdup.a(this.jdField_b_of_type_Bdup));
    if (this.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get())
    {
      f();
      return;
    }
    if (this.c.get())
    {
      this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.set(0);
      ThreadManager.post(new ForwardSdkShareProcessor.RichStep.1(this), 5, null, true);
      return;
    }
    b();
  }
  
  void g()
  {
    this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.set(0);
    this.c.set(false);
    if ((TextUtils.isEmpty(bdup.a(this.jdField_b_of_type_Bdup))) && (TextUtils.isEmpty(bdup.b(this.jdField_b_of_type_Bdup)))) {
      bdup.a(this.jdField_b_of_type_Bdup, bdup.a(this.jdField_b_of_type_Bdup) | 0x1);
    }
    if (TextUtils.isEmpty(bdup.c(this.jdField_b_of_type_Bdup))) {
      bdup.a(this.jdField_b_of_type_Bdup, bdup.a(this.jdField_b_of_type_Bdup) | 0x2);
    }
    if (TextUtils.isEmpty(bdup.d(this.jdField_b_of_type_Bdup))) {
      bdup.a(this.jdField_b_of_type_Bdup, bdup.a(this.jdField_b_of_type_Bdup) | 0x4);
    }
    if (bdup.a(this.jdField_b_of_type_Bdup) > 0) {
      this.c.set(true);
    }
    if (bdup.b(this.jdField_b_of_type_Bdup) == 11) {
      this.c.set(false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bduw
 * JD-Core Version:    0.7.0.1
 */