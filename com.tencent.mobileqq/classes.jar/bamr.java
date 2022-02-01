import android.os.SystemClock;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageForPtt;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.utils.QQRecorder;
import com.tencent.mobileqq.utils.QQRecorder.RecorderParam;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.concurrent.ConcurrentHashMap;
import mqq.manager.Manager;

public class bamr
  implements Manager
{
  private static ConcurrentHashMap<String, bams> jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
  public static boolean b;
  int jdField_a_of_type_Int = -1;
  bamp jdField_a_of_type_Bamp;
  bamq jdField_a_of_type_Bamq;
  bamt jdField_a_of_type_Bamt;
  QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  MessageRecord jdField_a_of_type_ComTencentMobileqqDataMessageRecord;
  String jdField_a_of_type_JavaLangString;
  boolean jdField_a_of_type_Boolean;
  int jdField_b_of_type_Int = 0;
  String jdField_b_of_type_JavaLangString;
  volatile boolean c = false;
  private volatile boolean d;
  
  public bamr(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
  }
  
  public static bamr a(QQAppInterface paramQQAppInterface)
  {
    paramQQAppInterface = (bamr)paramQQAppInterface.getManager(128);
    if (!paramQQAppInterface.d) {
      try
      {
        if (!paramQQAppInterface.d)
        {
          paramQQAppInterface.a();
          paramQQAppInterface.d = true;
        }
        return paramQQAppInterface;
      }
      finally {}
    }
    return paramQQAppInterface;
  }
  
  private boolean a(QQAppInterface paramQQAppInterface)
  {
    return baly.d(paramQQAppInterface) == 1;
  }
  
  public void a()
  {
    if (!jdField_b_of_type_Boolean) {
      switch (llk.f())
      {
      }
    }
    for (;;)
    {
      this.jdField_a_of_type_Bamq = new bamq(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 100000, 10000000, 86399999L);
      this.jdField_a_of_type_Bamp = new bamp(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      this.jdField_a_of_type_Bamt = new bamt();
      if (QLog.isColorLevel()) {
        QLog.d("PttPreSendManager", 2, "init manager end ");
      }
      return;
      jdField_b_of_type_Boolean = true;
    }
  }
  
  public void a(SessionInfo paramSessionInfo, QQRecorder.RecorderParam paramRecorderParam)
  {
    int i = 1;
    if (!this.c) {
      return;
    }
    int j = this.jdField_a_of_type_Bamt.a();
    this.jdField_a_of_type_Bamt.a();
    this.jdField_b_of_type_Int = ((int)new File(this.jdField_b_of_type_JavaLangString).length());
    if ((this.jdField_b_of_type_Int > 0) && (this.jdField_a_of_type_Bamq.a(this.jdField_a_of_type_Boolean, this.jdField_b_of_type_Int)))
    {
      MessageForPtt localMessageForPtt = aean.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_JavaLangString, paramSessionInfo, -2, paramRecorderParam.c);
      if (localMessageForPtt == null)
      {
        if (QLog.isColorLevel()) {
          QLog.d("PttPreSendManager", 2, "createPttMessage null");
        }
        c();
        return;
      }
      beyg localbeyg = new beyg();
      localbeyg.jdField_b_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount();
      localbeyg.c = paramSessionInfo.jdField_a_of_type_JavaLangString;
      localbeyg.jdField_a_of_type_Int = paramSessionInfo.jdField_a_of_type_Int;
      localbeyg.jdField_b_of_type_Int = 2;
      localbeyg.jdField_a_of_type_Long = localMessageForPtt.uniseq;
      localbeyg.jdField_a_of_type_Boolean = true;
      localbeyg.i = this.jdField_b_of_type_JavaLangString;
      localbeyg.e = 1002;
      localbeyg.m = true;
      localbeyg.n = 3;
      localbeyg.o = true;
      localbeyg.jdField_a_of_type_ComTencentMobileqqDataMessageRecord = localMessageForPtt;
      this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord = localMessageForPtt;
      paramSessionInfo = (MessageForPtt)this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord;
      paramSessionInfo.voiceType = paramRecorderParam.c;
      paramSessionInfo.voiceLength = QQRecorder.a(j);
      if (this.jdField_a_of_type_Int > 0) {}
      for (;;)
      {
        paramSessionInfo.voiceChangeFlag = i;
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(localbeyg);
        paramSessionInfo = localbeyg.c + localbeyg.jdField_a_of_type_Long;
        jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(paramSessionInfo, new bams(this.jdField_a_of_type_JavaLangString, this.jdField_b_of_type_JavaLangString));
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.d("PttPreSendManager", 2, "doPreSendIfIcan ：true");
        return;
        i = 0;
      }
    }
    if (QLog.isColorLevel()) {
      QLog.e("PttPreSendManager", 2, "doPreSendIfIcan : false, flow don't enough or size < 0, seiz : " + this.jdField_b_of_type_Int);
    }
    c();
  }
  
  public void a(String paramString)
  {
    paramString = (bams)jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.remove(paramString);
    if (paramString != null)
    {
      File localFile1 = new File(paramString.jdField_b_of_type_JavaLangString);
      if (localFile1.exists())
      {
        File localFile2 = new File(paramString.jdField_a_of_type_JavaLangString);
        if (localFile2.exists()) {
          localFile2.delete();
        }
        localFile1.renameTo(localFile2);
        if (QLog.isColorLevel()) {
          QLog.d("PttPreSendManager", 2, "rename presend file ! , from " + paramString.jdField_b_of_type_JavaLangString + " to " + paramString.jdField_a_of_type_JavaLangString);
        }
      }
    }
  }
  
  public void a(String paramString1, QQRecorder.RecorderParam paramRecorderParam, String paramString2)
  {
    boolean bool2 = true;
    boolean bool3 = false;
    this.c = false;
    this.jdField_a_of_type_Int = -1;
    boolean bool4 = a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    boolean bool1 = bool3;
    long l;
    if (jdField_b_of_type_Boolean)
    {
      bool1 = bool3;
      if (bool4)
      {
        this.jdField_a_of_type_Int = this.jdField_a_of_type_Bamp.a();
        l = SystemClock.uptimeMillis();
        if (bhnv.a(BaseApplicationImpl.sApplication) != 1) {
          break label310;
        }
      }
    }
    label310:
    for (bool1 = bool2;; bool1 = false)
    {
      this.jdField_a_of_type_Boolean = bool1;
      if (QLog.isDevelopLevel()) {
        QLog.d("PttPreSendManager", 4, "get network type cost " + (SystemClock.uptimeMillis() - l));
      }
      bool1 = this.jdField_a_of_type_Bamq.a(this.jdField_a_of_type_Boolean);
      if ((bool1) && (this.jdField_a_of_type_Int != -1))
      {
        this.jdField_a_of_type_JavaLangString = paramString1;
        int i = this.jdField_a_of_type_JavaLangString.lastIndexOf(".");
        this.jdField_b_of_type_JavaLangString = paramString1.substring(0, i);
        this.jdField_b_of_type_JavaLangString = this.jdField_b_of_type_JavaLangString.concat("_pre").concat(paramString1.substring(i, paramString1.length()));
        this.c = this.jdField_a_of_type_Bamt.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp(), this.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_Int, paramRecorderParam, paramString2);
      }
      if (QLog.isColorLevel()) {
        QLog.d("PttPreSendManager", 2, " startPreSendIfNeed : " + this.c + ", cpu : " + jdField_b_of_type_Boolean + ", flow enough : " + bool1 + ", type : " + this.jdField_a_of_type_Int + ", cfg : " + bool4);
      }
      return;
    }
  }
  
  public void a(byte[] paramArrayOfByte, int paramInt)
  {
    if (!this.c) {}
    while (this.jdField_a_of_type_Bamt.a(paramArrayOfByte, paramInt)) {
      return;
    }
    c();
  }
  
  /* Error */
  public boolean a(com.tencent.mobileqq.activity.BaseChatPie paramBaseChatPie, int paramInt)
  {
    // Byte code:
    //   0: getstatic 59	bamr:jdField_b_of_type_Boolean	Z
    //   3: ifeq +48 -> 51
    //   6: aload_0
    //   7: aload_0
    //   8: getfield 40	bamr:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   11: invokespecial 256	bamr:a	(Lcom/tencent/mobileqq/app/QQAppInterface;)Z
    //   14: ifeq +37 -> 51
    //   17: aload_0
    //   18: getfield 82	bamr:jdField_a_of_type_Bamp	Lbamp;
    //   21: aload_0
    //   22: getfield 40	bamr:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   25: iload_2
    //   26: invokevirtual 329	bamp:a	(Lcom/tencent/mobileqq/app/QQAppInterface;I)V
    //   29: aload_0
    //   30: getfield 34	bamr:jdField_a_of_type_Int	I
    //   33: iload_2
    //   34: if_icmpne +17 -> 51
    //   37: aload_0
    //   38: getfield 76	bamr:jdField_a_of_type_Bamq	Lbamq;
    //   41: aload_0
    //   42: getfield 117	bamr:jdField_a_of_type_Boolean	Z
    //   45: ldc2_w 330
    //   48: invokevirtual 334	bamq:a	(ZJ)V
    //   51: aload_0
    //   52: getfield 38	bamr:c	Z
    //   55: ifne +11 -> 66
    //   58: iconst_0
    //   59: istore_3
    //   60: aload_0
    //   61: invokevirtual 135	bamr:c	()V
    //   64: iload_3
    //   65: ireturn
    //   66: aload_0
    //   67: getfield 40	bamr:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   70: invokevirtual 197	com/tencent/mobileqq/app/QQAppInterface:a	()Lbeyb;
    //   73: astore 5
    //   75: new 204	java/lang/StringBuilder
    //   78: dup
    //   79: invokespecial 205	java/lang/StringBuilder:<init>	()V
    //   82: aload_0
    //   83: getfield 178	bamr:jdField_a_of_type_ComTencentMobileqqDataMessageRecord	Lcom/tencent/mobileqq/data/MessageRecord;
    //   86: getfield 337	com/tencent/mobileqq/data/MessageRecord:frienduin	Ljava/lang/String;
    //   89: invokevirtual 209	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   92: aload_0
    //   93: getfield 178	bamr:jdField_a_of_type_ComTencentMobileqqDataMessageRecord	Lcom/tencent/mobileqq/data/MessageRecord;
    //   96: getfield 157	com/tencent/mobileqq/data/MessageRecord:uniseq	J
    //   99: invokevirtual 212	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   102: invokevirtual 215	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   105: astore 6
    //   107: aload 5
    //   109: aload 6
    //   111: invokevirtual 340	beyb:a	(Ljava/lang/String;)Lbhvc;
    //   114: checkcast 342	beru
    //   117: astore 4
    //   119: aload 4
    //   121: ifnonnull +8 -> 129
    //   124: iconst_0
    //   125: istore_3
    //   126: goto -66 -> 60
    //   129: iload_2
    //   130: aload_0
    //   131: getfield 34	bamr:jdField_a_of_type_Int	I
    //   134: if_icmpeq +53 -> 187
    //   137: invokestatic 93	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   140: ifeq +12 -> 152
    //   143: ldc 95
    //   145: iconst_2
    //   146: ldc_w 344
    //   149: invokestatic 233	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   152: aload 4
    //   154: invokevirtual 345	beru:a	()I
    //   157: pop
    //   158: aload 5
    //   160: aload 6
    //   162: invokevirtual 348	beyb:a	(Ljava/lang/String;)Z
    //   165: pop
    //   166: getstatic 29	bamr:jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap	Ljava/util/concurrent/ConcurrentHashMap;
    //   169: aload 6
    //   171: invokevirtual 237	java/util/concurrent/ConcurrentHashMap:remove	(Ljava/lang/Object;)Ljava/lang/Object;
    //   174: pop
    //   175: aload_0
    //   176: getfield 87	bamr:jdField_a_of_type_Bamt	Lbamt;
    //   179: invokevirtual 350	bamt:b	()V
    //   182: iconst_0
    //   183: istore_3
    //   184: goto -124 -> 60
    //   187: invokestatic 93	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   190: ifeq +36 -> 226
    //   193: ldc 95
    //   195: iconst_2
    //   196: new 204	java/lang/StringBuilder
    //   199: dup
    //   200: invokespecial 205	java/lang/StringBuilder:<init>	()V
    //   203: ldc_w 352
    //   206: invokevirtual 209	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   209: aload 4
    //   211: getfield 355	beru:a	Lbeyg;
    //   214: getfield 358	beyg:p	Z
    //   217: invokevirtual 313	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   220: invokevirtual 215	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   223: invokestatic 100	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   226: aload_0
    //   227: getfield 76	bamr:jdField_a_of_type_Bamq	Lbamq;
    //   230: aload_0
    //   231: getfield 117	bamr:jdField_a_of_type_Boolean	Z
    //   234: aload_0
    //   235: getfield 36	bamr:jdField_b_of_type_Int	I
    //   238: i2l
    //   239: invokevirtual 334	bamq:a	(ZJ)V
    //   242: aload_0
    //   243: getfield 40	bamr:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   246: invokevirtual 361	com/tencent/mobileqq/app/QQAppInterface:a	()Lcom/tencent/imcore/message/QQMessageFacade;
    //   249: aload_0
    //   250: getfield 178	bamr:jdField_a_of_type_ComTencentMobileqqDataMessageRecord	Lcom/tencent/mobileqq/data/MessageRecord;
    //   253: aload_0
    //   254: getfield 40	bamr:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   257: invokevirtual 364	com/tencent/mobileqq/app/QQAppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   260: invokevirtual 369	com/tencent/imcore/message/QQMessageFacade:a	(Lcom/tencent/mobileqq/data/MessageRecord;Ljava/lang/String;)V
    //   263: aload_0
    //   264: getfield 40	bamr:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   267: aload_1
    //   268: getfield 374	com/tencent/mobileqq/activity/BaseChatPie:a	Lcom/tencent/mobileqq/activity/aio/SessionInfo;
    //   271: aload_0
    //   272: getfield 122	bamr:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   275: bipush 253
    //   277: aload_0
    //   278: getfield 178	bamr:jdField_a_of_type_ComTencentMobileqqDataMessageRecord	Lcom/tencent/mobileqq/data/MessageRecord;
    //   281: getfield 157	com/tencent/mobileqq/data/MessageRecord:uniseq	J
    //   284: invokestatic 377	aean:a	(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/mobileqq/activity/aio/SessionInfo;Ljava/lang/String;IJ)V
    //   287: new 379	com/tencent/mobileqq/ptt/preop/PttPreSendManager$1
    //   290: dup
    //   291: aload_0
    //   292: aload_1
    //   293: invokespecial 382	com/tencent/mobileqq/ptt/preop/PttPreSendManager$1:<init>	(Lbamr;Lcom/tencent/mobileqq/activity/BaseChatPie;)V
    //   296: aconst_null
    //   297: iconst_0
    //   298: invokestatic 388	com/tencent/mobileqq/app/ThreadManager:postImmediately	(Ljava/lang/Runnable;Lcom/tencent/mobileqq/app/ThreadExcutor$IThreadListener;Z)V
    //   301: aload 4
    //   303: invokevirtual 391	beru:q	()V
    //   306: aload 4
    //   308: monitorenter
    //   309: aload 4
    //   311: getfield 355	beru:a	Lbeyg;
    //   314: getfield 358	beyg:p	Z
    //   317: ifeq +28 -> 345
    //   320: aload 5
    //   322: aload 4
    //   324: getfield 355	beru:a	Lbeyg;
    //   327: invokevirtual 202	beyb:a	(Lbeyg;)Z
    //   330: pop
    //   331: aload_0
    //   332: aload 6
    //   334: invokevirtual 393	bamr:a	(Ljava/lang/String;)V
    //   337: aload 4
    //   339: monitorexit
    //   340: iconst_1
    //   341: istore_3
    //   342: goto -282 -> 60
    //   345: aload 4
    //   347: getfield 355	beru:a	Lbeyg;
    //   350: iconst_1
    //   351: putfield 358	beyg:p	Z
    //   354: goto -17 -> 337
    //   357: astore_1
    //   358: aload 4
    //   360: monitorexit
    //   361: aload_1
    //   362: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	363	0	this	bamr
    //   0	363	1	paramBaseChatPie	com.tencent.mobileqq.activity.BaseChatPie
    //   0	363	2	paramInt	int
    //   59	283	3	bool	boolean
    //   117	242	4	localberu	beru
    //   73	248	5	localbeyb	beyb
    //   105	228	6	str	String
    // Exception table:
    //   from	to	target	type
    //   309	337	357	finally
    //   337	340	357	finally
    //   345	354	357	finally
    //   358	361	357	finally
  }
  
  public void b()
  {
    this.jdField_a_of_type_Bamp.a(null, -1);
    if (!this.c) {
      return;
    }
    if (QLog.isDevelopLevel()) {
      QLog.e("PttPreSendManager", 4, "doOnCancelSend");
    }
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a();
    String str = this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.frienduin + this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.uniseq;
    localObject = (beru)((beyb)localObject).a(str);
    if (localObject != null) {
      ((beru)localObject).a();
    }
    jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.remove(str);
    this.jdField_a_of_type_Bamt.b();
    c();
  }
  
  public void c()
  {
    if (!this.c) {}
    do
    {
      return;
      this.c = false;
      this.jdField_a_of_type_JavaLangString = null;
      this.jdField_b_of_type_JavaLangString = null;
      this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord = null;
    } while (!QLog.isDevelopLevel());
    QLog.e("PttPreSendManager", 4, "clean up");
  }
  
  public void onDestroy()
  {
    if (this.jdField_a_of_type_Bamq != null) {
      this.jdField_a_of_type_Bamq.a();
    }
    if (this.jdField_a_of_type_Bamp != null) {
      this.jdField_a_of_type_Bamp.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bamr
 * JD-Core Version:    0.7.0.1
 */