import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.transfile.ForwardSdkShareProcessor.RichStep.1;
import com.tencent.qphone.base.util.QLog;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

public class betq
  extends betk
{
  public AtomicInteger a;
  public boolean a;
  public AtomicBoolean c = new AtomicBoolean(false);
  
  betq(betj parambetj)
  {
    super(parambetj);
    this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger = new AtomicInteger(0);
    this.jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_JavaLangString = "RichStep";
    g();
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
        ((Bundle)localObject).putString("stringext_1", this.jdField_b_of_type_Betj.jdField_a_of_type_JavaLangString);
      }
      bjqh.a().a((Bundle)localObject, "", this.jdField_b_of_type_Betj.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), false);
      if (QLog.isColorLevel())
      {
        localObject = "RichStep|run|ret=" + paramInt1 + ",lack=" + betj.a(this.jdField_b_of_type_Betj) + ",cost=" + paramLong;
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
    localBundle.putString("intext_2", "" + betj.a(this.jdField_b_of_type_Betj));
    localBundle.putString("stringext_1", this.jdField_b_of_type_Betj.jdField_a_of_type_JavaLangString);
    bjqh.a().a(localBundle, "", this.jdField_b_of_type_Betj.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), false);
  }
  
  /* Error */
  public int a()
  {
    // Byte code:
    //   0: aload_0
    //   1: invokespecial 152	betq:h	()V
    //   4: invokestatic 158	java/lang/System:currentTimeMillis	()J
    //   7: lstore 6
    //   9: iconst_m1
    //   10: istore_2
    //   11: aload_0
    //   12: getfield 15	betq:jdField_b_of_type_Betj	Lbetj;
    //   15: invokestatic 131	betj:a	(Lbetj;)I
    //   18: istore 5
    //   20: iload_2
    //   21: istore_1
    //   22: aload_0
    //   23: getfield 15	betq:jdField_b_of_type_Betj	Lbetj;
    //   26: getfield 161	betj:jdField_a_of_type_AndroidContentContext	Landroid/content/Context;
    //   29: aload_0
    //   30: getfield 15	betq:jdField_b_of_type_Betj	Lbetj;
    //   33: getfield 102	betj:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   36: aload_0
    //   37: getfield 15	betq:jdField_b_of_type_Betj	Lbetj;
    //   40: getfield 110	betj:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   43: invokevirtual 115	com/tencent/mobileqq/app/QQAppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   46: invokestatic 166	bjuc:a	(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;)[Ljava/lang/Object;
    //   49: astore 11
    //   51: iload_2
    //   52: istore_1
    //   53: aload 11
    //   55: iconst_0
    //   56: aaload
    //   57: checkcast 168	java/lang/Integer
    //   60: invokevirtual 171	java/lang/Integer:intValue	()I
    //   63: istore_2
    //   64: iload_2
    //   65: ifne +596 -> 661
    //   68: iload_2
    //   69: istore_1
    //   70: aload 11
    //   72: iconst_1
    //   73: aaload
    //   74: checkcast 173	java/lang/String
    //   77: astore 9
    //   79: iload_2
    //   80: istore_1
    //   81: aload 11
    //   83: iconst_2
    //   84: aaload
    //   85: checkcast 173	java/lang/String
    //   88: astore 10
    //   90: iload_2
    //   91: istore_1
    //   92: aload 11
    //   94: iconst_3
    //   95: aaload
    //   96: checkcast 173	java/lang/String
    //   99: astore 11
    //   101: iload_2
    //   102: istore_1
    //   103: aload 9
    //   105: invokestatic 179	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   108: istore 8
    //   110: iload 8
    //   112: ifne +543 -> 655
    //   115: aload_0
    //   116: getfield 15	betq:jdField_b_of_type_Betj	Lbetj;
    //   119: getfield 181	betj:b	Ljava/lang/String;
    //   122: invokestatic 179	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   125: ifeq +30 -> 155
    //   128: aload_0
    //   129: getfield 15	betq:jdField_b_of_type_Betj	Lbetj;
    //   132: aload_0
    //   133: getfield 15	betq:jdField_b_of_type_Betj	Lbetj;
    //   136: invokestatic 131	betj:a	(Lbetj;)I
    //   139: bipush 251
    //   141: iand
    //   142: invokestatic 184	betj:a	(Lbetj;I)I
    //   145: pop
    //   146: aload_0
    //   147: getfield 15	betq:jdField_b_of_type_Betj	Lbetj;
    //   150: aload 9
    //   152: putfield 181	betj:b	Ljava/lang/String;
    //   155: iconst_4
    //   156: istore 4
    //   158: iload 4
    //   160: istore_3
    //   161: iload 4
    //   163: istore_1
    //   164: aload 10
    //   166: invokestatic 179	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   169: ifne +64 -> 233
    //   172: iload 4
    //   174: iconst_2
    //   175: ior
    //   176: istore 4
    //   178: iload 4
    //   180: istore_3
    //   181: iload 4
    //   183: istore_1
    //   184: aload_0
    //   185: getfield 15	betq:jdField_b_of_type_Betj	Lbetj;
    //   188: getfield 186	betj:c	Ljava/lang/String;
    //   191: invokestatic 179	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   194: ifeq +39 -> 233
    //   197: iload 4
    //   199: istore_1
    //   200: aload_0
    //   201: getfield 15	betq:jdField_b_of_type_Betj	Lbetj;
    //   204: aload_0
    //   205: getfield 15	betq:jdField_b_of_type_Betj	Lbetj;
    //   208: invokestatic 131	betj:a	(Lbetj;)I
    //   211: bipush 253
    //   213: iand
    //   214: invokestatic 184	betj:a	(Lbetj;I)I
    //   217: pop
    //   218: iload 4
    //   220: istore_1
    //   221: aload_0
    //   222: getfield 15	betq:jdField_b_of_type_Betj	Lbetj;
    //   225: aload 10
    //   227: putfield 186	betj:c	Ljava/lang/String;
    //   230: iload 4
    //   232: istore_3
    //   233: iload_3
    //   234: istore 4
    //   236: iload_3
    //   237: istore_1
    //   238: aload 11
    //   240: invokestatic 179	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   243: ifne +77 -> 320
    //   246: iload_3
    //   247: iconst_1
    //   248: ior
    //   249: istore_3
    //   250: iload_3
    //   251: istore 4
    //   253: iload_3
    //   254: istore_1
    //   255: aload_0
    //   256: getfield 15	betq:jdField_b_of_type_Betj	Lbetj;
    //   259: getfield 188	betj:e	Ljava/lang/String;
    //   262: invokestatic 179	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   265: ifeq +55 -> 320
    //   268: iload_3
    //   269: istore 4
    //   271: iload_3
    //   272: istore_1
    //   273: aload_0
    //   274: getfield 15	betq:jdField_b_of_type_Betj	Lbetj;
    //   277: getfield 190	betj:d	Ljava/lang/String;
    //   280: invokestatic 179	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   283: ifeq +37 -> 320
    //   286: iload_3
    //   287: istore_1
    //   288: aload_0
    //   289: getfield 15	betq:jdField_b_of_type_Betj	Lbetj;
    //   292: aload_0
    //   293: getfield 15	betq:jdField_b_of_type_Betj	Lbetj;
    //   296: invokestatic 131	betj:a	(Lbetj;)I
    //   299: bipush 254
    //   301: iand
    //   302: invokestatic 184	betj:a	(Lbetj;I)I
    //   305: pop
    //   306: iload_3
    //   307: istore_1
    //   308: aload_0
    //   309: getfield 15	betq:jdField_b_of_type_Betj	Lbetj;
    //   312: aload 11
    //   314: putfield 188	betj:e	Ljava/lang/String;
    //   317: iload_3
    //   318: istore 4
    //   320: iload 4
    //   322: istore_1
    //   323: aload_0
    //   324: getfield 24	betq:c	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   327: iconst_0
    //   328: invokevirtual 193	java/util/concurrent/atomic/AtomicBoolean:set	(Z)V
    //   331: iload 4
    //   333: istore_1
    //   334: aload_0
    //   335: getfield 15	betq:jdField_b_of_type_Betj	Lbetj;
    //   338: getfield 110	betj:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   341: invokevirtual 196	com/tencent/mobileqq/app/QQAppInterface:a	()Lcom/tencent/imcore/message/QQMessageFacade;
    //   344: aload_0
    //   345: getfield 15	betq:jdField_b_of_type_Betj	Lbetj;
    //   348: getfield 199	betj:jdField_a_of_type_Beyg	Lbeyg;
    //   351: getfield 202	beyg:c	Ljava/lang/String;
    //   354: aload_0
    //   355: getfield 15	betq:jdField_b_of_type_Betj	Lbetj;
    //   358: getfield 199	betj:jdField_a_of_type_Beyg	Lbeyg;
    //   361: getfield 205	beyg:jdField_a_of_type_Int	I
    //   364: aload_0
    //   365: getfield 15	betq:jdField_b_of_type_Betj	Lbetj;
    //   368: getfield 199	betj:jdField_a_of_type_Beyg	Lbeyg;
    //   371: getfield 208	beyg:jdField_a_of_type_Long	J
    //   374: invokevirtual 213	com/tencent/imcore/message/QQMessageFacade:b	(Ljava/lang/String;IJ)Lcom/tencent/mobileqq/data/MessageRecord;
    //   377: astore 9
    //   379: iload 4
    //   381: istore_1
    //   382: aload 9
    //   384: instanceof 215
    //   387: ifeq +185 -> 572
    //   390: iload 4
    //   392: istore_1
    //   393: aload 9
    //   395: checkcast 215	com/tencent/mobileqq/data/MessageForStructing
    //   398: getfield 219	com/tencent/mobileqq/data/MessageForStructing:structingMsg	Lcom/tencent/mobileqq/structmsg/AbsStructMsg;
    //   401: instanceof 221
    //   404: ifeq +168 -> 572
    //   407: iload 4
    //   409: istore_1
    //   410: aload 9
    //   412: checkcast 215	com/tencent/mobileqq/data/MessageForStructing
    //   415: getfield 219	com/tencent/mobileqq/data/MessageForStructing:structingMsg	Lcom/tencent/mobileqq/structmsg/AbsStructMsg;
    //   418: checkcast 221	com/tencent/mobileqq/structmsg/AbsShareMsg
    //   421: astore 9
    //   423: iload 4
    //   425: istore_1
    //   426: aload_0
    //   427: getfield 15	betq:jdField_b_of_type_Betj	Lbetj;
    //   430: getfield 181	betj:b	Ljava/lang/String;
    //   433: ifnull +18 -> 451
    //   436: iload 4
    //   438: istore_1
    //   439: aload_0
    //   440: getfield 15	betq:jdField_b_of_type_Betj	Lbetj;
    //   443: getfield 181	betj:b	Ljava/lang/String;
    //   446: iconst_0
    //   447: invokestatic 226	bcsa:a	(Ljava/lang/String;Z)Ljava/lang/String;
    //   450: pop
    //   451: iload 4
    //   453: istore_1
    //   454: aload_0
    //   455: getfield 15	betq:jdField_b_of_type_Betj	Lbetj;
    //   458: getfield 186	betj:c	Ljava/lang/String;
    //   461: ifnull +18 -> 479
    //   464: iload 4
    //   466: istore_1
    //   467: aload_0
    //   468: getfield 15	betq:jdField_b_of_type_Betj	Lbetj;
    //   471: getfield 186	betj:c	Ljava/lang/String;
    //   474: iconst_0
    //   475: invokestatic 226	bcsa:a	(Ljava/lang/String;Z)Ljava/lang/String;
    //   478: pop
    //   479: iload 4
    //   481: istore_1
    //   482: aload 9
    //   484: aload_0
    //   485: getfield 15	betq:jdField_b_of_type_Betj	Lbetj;
    //   488: getfield 181	betj:b	Ljava/lang/String;
    //   491: aload_0
    //   492: getfield 15	betq:jdField_b_of_type_Betj	Lbetj;
    //   495: getfield 186	betj:c	Ljava/lang/String;
    //   498: aload_0
    //   499: getfield 15	betq:jdField_b_of_type_Betj	Lbetj;
    //   502: getfield 188	betj:e	Ljava/lang/String;
    //   505: invokevirtual 230	com/tencent/mobileqq/structmsg/AbsShareMsg:updateTitleSummaryAndCover	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   508: iload 4
    //   510: istore_1
    //   511: aload_0
    //   512: getfield 15	betq:jdField_b_of_type_Betj	Lbetj;
    //   515: getfield 110	betj:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   518: invokevirtual 196	com/tencent/mobileqq/app/QQAppInterface:a	()Lcom/tencent/imcore/message/QQMessageFacade;
    //   521: aload_0
    //   522: getfield 15	betq:jdField_b_of_type_Betj	Lbetj;
    //   525: getfield 199	betj:jdField_a_of_type_Beyg	Lbeyg;
    //   528: getfield 202	beyg:c	Ljava/lang/String;
    //   531: aload_0
    //   532: getfield 15	betq:jdField_b_of_type_Betj	Lbetj;
    //   535: getfield 199	betj:jdField_a_of_type_Beyg	Lbeyg;
    //   538: getfield 205	beyg:jdField_a_of_type_Int	I
    //   541: aload_0
    //   542: getfield 15	betq:jdField_b_of_type_Betj	Lbetj;
    //   545: getfield 199	betj:jdField_a_of_type_Beyg	Lbeyg;
    //   548: getfield 208	beyg:jdField_a_of_type_Long	J
    //   551: aload 9
    //   553: invokevirtual 234	com/tencent/mobileqq/structmsg/AbsShareMsg:getBytes	()[B
    //   556: invokevirtual 237	com/tencent/imcore/message/QQMessageFacade:a	(Ljava/lang/String;IJ[B)V
    //   559: iload 4
    //   561: istore_1
    //   562: aload_0
    //   563: getfield 15	betq:jdField_b_of_type_Betj	Lbetj;
    //   566: sipush 1002
    //   569: invokevirtual 239	betj:d	(I)V
    //   572: iload 4
    //   574: istore_1
    //   575: iload_1
    //   576: istore_3
    //   577: iload_2
    //   578: istore 4
    //   580: aload_0
    //   581: iload 4
    //   583: invokestatic 158	java/lang/System:currentTimeMillis	()J
    //   586: lload 6
    //   588: lsub
    //   589: iload 5
    //   591: iload_3
    //   592: invokespecial 241	betq:a	(IJII)V
    //   595: iload 4
    //   597: ireturn
    //   598: astore 9
    //   600: iconst_0
    //   601: istore_2
    //   602: iload_1
    //   603: istore 4
    //   605: iload_2
    //   606: istore_3
    //   607: invokestatic 124	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   610: ifeq -30 -> 580
    //   613: ldc 243
    //   615: iconst_4
    //   616: aload 9
    //   618: iconst_0
    //   619: anewarray 245	java/lang/Object
    //   622: invokestatic 248	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/Throwable;[Ljava/lang/Object;)V
    //   625: iload_1
    //   626: istore 4
    //   628: iload_2
    //   629: istore_3
    //   630: goto -50 -> 580
    //   633: astore 9
    //   635: iconst_4
    //   636: istore_3
    //   637: iload_2
    //   638: istore_1
    //   639: iload_3
    //   640: istore_2
    //   641: goto -39 -> 602
    //   644: astore 9
    //   646: iload_1
    //   647: istore_3
    //   648: iload_2
    //   649: istore_1
    //   650: iload_3
    //   651: istore_2
    //   652: goto -50 -> 602
    //   655: iconst_0
    //   656: istore 4
    //   658: goto -500 -> 158
    //   661: iconst_0
    //   662: istore_1
    //   663: goto -88 -> 575
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	666	0	this	betq
    //   21	642	1	i	int
    //   10	642	2	j	int
    //   160	491	3	k	int
    //   156	501	4	m	int
    //   18	572	5	n	int
    //   7	580	6	l	long
    //   108	3	8	bool	boolean
    //   77	475	9	localObject1	Object
    //   598	19	9	localException1	java.lang.Exception
    //   633	1	9	localException2	java.lang.Exception
    //   644	1	9	localException3	java.lang.Exception
    //   88	138	10	str	String
    //   49	264	11	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   22	51	598	java/lang/Exception
    //   53	64	598	java/lang/Exception
    //   70	79	598	java/lang/Exception
    //   81	90	598	java/lang/Exception
    //   92	101	598	java/lang/Exception
    //   103	110	598	java/lang/Exception
    //   115	155	633	java/lang/Exception
    //   164	172	644	java/lang/Exception
    //   184	197	644	java/lang/Exception
    //   200	218	644	java/lang/Exception
    //   221	230	644	java/lang/Exception
    //   238	246	644	java/lang/Exception
    //   255	268	644	java/lang/Exception
    //   273	286	644	java/lang/Exception
    //   288	306	644	java/lang/Exception
    //   308	317	644	java/lang/Exception
    //   323	331	644	java/lang/Exception
    //   334	379	644	java/lang/Exception
    //   382	390	644	java/lang/Exception
    //   393	407	644	java/lang/Exception
    //   410	423	644	java/lang/Exception
    //   426	436	644	java/lang/Exception
    //   439	451	644	java/lang/Exception
    //   454	464	644	java/lang/Exception
    //   467	479	644	java/lang/Exception
    //   482	508	644	java/lang/Exception
    //   511	559	644	java/lang/Exception
    //   562	572	644	java/lang/Exception
  }
  
  protected boolean a()
  {
    return (!this.c.get()) || (this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.get() >= 2);
  }
  
  protected void d()
  {
    QLog.d("Q.share.ForwardSdkShareProcessor", 1, "RichStep|process|neeRich=" + this.c + ",lack=" + betj.a(this.jdField_b_of_type_Betj));
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
    if ((TextUtils.isEmpty(this.jdField_b_of_type_Betj.e)) && (TextUtils.isEmpty(this.jdField_b_of_type_Betj.d))) {
      betj.a(this.jdField_b_of_type_Betj, betj.a(this.jdField_b_of_type_Betj) | 0x1);
    }
    if (TextUtils.isEmpty(this.jdField_b_of_type_Betj.c)) {
      betj.a(this.jdField_b_of_type_Betj, betj.a(this.jdField_b_of_type_Betj) | 0x2);
    }
    if (TextUtils.isEmpty(this.jdField_b_of_type_Betj.b)) {
      betj.a(this.jdField_b_of_type_Betj, betj.a(this.jdField_b_of_type_Betj) | 0x4);
    }
    if (betj.a(this.jdField_b_of_type_Betj) > 0) {
      this.c.set(true);
    }
    if (this.jdField_b_of_type_Betj.jdField_a_of_type_Int == 11) {
      this.c.set(false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     betq
 * JD-Core Version:    0.7.0.1
 */