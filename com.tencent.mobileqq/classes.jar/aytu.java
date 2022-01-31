import android.os.Bundle;
import android.os.Looper;
import com.qq.jce.wup.UniPacket;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.service.PeakJceServiceBase.1;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import mqq.app.MSFServlet;
import mqq.app.NewIntent;

public abstract class aytu
{
  public static volatile int a;
  public static HashMap<String, UniPacket> a;
  private DecimalFormat jdField_a_of_type_JavaTextDecimalFormat = new DecimalFormat("0.00");
  private ConcurrentHashMap<String, zdf> jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap;
  private volatile boolean jdField_a_of_type_Boolean;
  
  static
  {
    jdField_a_of_type_JavaUtilHashMap = new HashMap();
  }
  
  public UniPacket a(ToServiceMsg paramToServiceMsg)
  {
    if ("StreamSvr.UploadStreamMsg".equalsIgnoreCase(paramToServiceMsg.getServiceCmd()))
    {
      String str = paramToServiceMsg.extraData.getString("filepath");
      UniPacket localUniPacket = (UniPacket)jdField_a_of_type_JavaUtilHashMap.get(str);
      Object localObject;
      if (localUniPacket == null)
      {
        if (QLog.isColorLevel()) {
          QLog.d("PeakJceServiceBase", 2, "no saved packet, new one " + str);
        }
        localObject = new aytv(true);
        jdField_a_of_type_JavaUtilHashMap.clear();
        jdField_a_of_type_JavaUtilHashMap.put(str, localObject);
      }
      for (;;)
      {
        paramToServiceMsg = Short.valueOf(paramToServiceMsg.extraData.getShort("PackSeq"));
        int i = azqa.b(str);
        if (paramToServiceMsg.shortValue() <= i)
        {
          jdField_a_of_type_JavaUtilHashMap.remove(str);
          if (QLog.isColorLevel()) {
            QLog.d("PeakJceServiceBase", 2, "last stream, remove " + i + ", " + paramToServiceMsg);
          }
        }
        return localObject;
        localObject = localUniPacket;
        if (QLog.isColorLevel())
        {
          QLog.d("PeakJceServiceBase", 2, "got last packet, reuse it " + str);
          localObject = localUniPacket;
        }
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d("PeakJceServiceBase", 2, "not stream ptt");
    }
    return new UniPacket(true);
  }
  
  public abstract AppInterface a();
  
  public zdf a(String paramString)
  {
    if (!this.jdField_a_of_type_Boolean) {}
    int i;
    try
    {
      if (!this.jdField_a_of_type_Boolean) {
        a();
      }
      i = paramString.indexOf('.');
      if (i <= 1) {
        return null;
      }
    }
    finally {}
    paramString = paramString.substring(0, i);
    return (zdf)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(paramString);
  }
  
  protected void a()
  {
    try
    {
      if (this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap == null) {
        this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
      }
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  protected void a(FromServiceMsg paramFromServiceMsg) {}
  
  protected void a(ToServiceMsg paramToServiceMsg, aoct paramaoct, Class<? extends MSFServlet> paramClass)
  {
    if (paramToServiceMsg == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("PeakJceServiceBase", 2, "handleRequest request is null. ");
      }
      return;
    }
    paramToServiceMsg = new PeakJceServiceBase.1(this, paramToServiceMsg, paramaoct, paramClass);
    if (Thread.currentThread() == Looper.getMainLooper().getThread())
    {
      ThreadManager.post(paramToServiceMsg, 10, null, false);
      return;
    }
    paramToServiceMsg.run();
  }
  
  /* Error */
  public void a(boolean paramBoolean, ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Exception paramException)
  {
    // Byte code:
    //   0: aload_2
    //   1: ifnonnull +4 -> 5
    //   4: return
    //   5: aload_0
    //   6: invokevirtual 204	aytu:a	()Lcom/tencent/common/app/AppInterface;
    //   9: astore 8
    //   11: invokestatic 210	java/lang/System:currentTimeMillis	()J
    //   14: aload_2
    //   15: getfield 51	com/tencent/qphone/base/remote/ToServiceMsg:extraData	Landroid/os/Bundle;
    //   18: ldc 212
    //   20: invokevirtual 216	android/os/Bundle:getLong	(Ljava/lang/String;)J
    //   23: lsub
    //   24: l2f
    //   25: ldc 217
    //   27: fdiv
    //   28: fstore 5
    //   30: iload_1
    //   31: ifeq +220 -> 251
    //   34: invokestatic 71	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   37: ifeq +66 -> 103
    //   40: ldc 73
    //   42: iconst_2
    //   43: new 75	java/lang/StringBuilder
    //   46: dup
    //   47: invokespecial 76	java/lang/StringBuilder:<init>	()V
    //   50: ldc 219
    //   52: invokevirtual 82	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   55: aload_3
    //   56: invokevirtual 222	com/tencent/qphone/base/remote/FromServiceMsg:getServiceCmd	()Ljava/lang/String;
    //   59: invokevirtual 82	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   62: ldc 224
    //   64: invokevirtual 82	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   67: aload_3
    //   68: invokevirtual 228	com/tencent/qphone/base/remote/FromServiceMsg:getAppSeq	()I
    //   71: invokevirtual 130	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   74: ldc 230
    //   76: invokevirtual 82	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   79: aload_0
    //   80: getfield 32	aytu:jdField_a_of_type_JavaTextDecimalFormat	Ljava/text/DecimalFormat;
    //   83: fload 5
    //   85: f2d
    //   86: invokevirtual 234	java/text/DecimalFormat:format	(D)Ljava/lang/String;
    //   89: invokevirtual 82	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   92: ldc 236
    //   94: invokevirtual 82	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   97: invokevirtual 85	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   100: invokestatic 89	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   103: aload_2
    //   104: ldc 238
    //   106: invokevirtual 242	com/tencent/qphone/base/remote/ToServiceMsg:getAttribute	(Ljava/lang/String;)Ljava/lang/Object;
    //   109: checkcast 244	com/tencent/qphone/base/remote/IBaseActionListener
    //   112: astore 4
    //   114: aload 4
    //   116: ifnull +9 -> 125
    //   119: aload_2
    //   120: aload 4
    //   122: putfield 248	com/tencent/qphone/base/remote/ToServiceMsg:actionListener	Lcom/tencent/qphone/base/remote/IBaseActionListener;
    //   125: aload_0
    //   126: aload_3
    //   127: invokevirtual 222	com/tencent/qphone/base/remote/FromServiceMsg:getServiceCmd	()Ljava/lang/String;
    //   130: invokevirtual 250	aytu:a	(Ljava/lang/String;)Lzdf;
    //   133: astore 9
    //   135: iload_1
    //   136: ifeq +323 -> 459
    //   139: aload 9
    //   141: ifnull +273 -> 414
    //   144: aload 9
    //   146: aload_2
    //   147: aload_3
    //   148: invokevirtual 253	zdf:a	(Lcom/tencent/qphone/base/remote/ToServiceMsg;Lcom/tencent/qphone/base/remote/FromServiceMsg;)V
    //   151: aload 9
    //   153: aload_2
    //   154: aload_3
    //   155: invokevirtual 256	zdf:a	(Lcom/tencent/qphone/base/remote/ToServiceMsg;Lcom/tencent/qphone/base/remote/FromServiceMsg;)Ljava/lang/Object;
    //   158: astore 4
    //   160: aload_0
    //   161: aload_3
    //   162: invokevirtual 258	aytu:a	(Lcom/tencent/qphone/base/remote/FromServiceMsg;)V
    //   165: aload 9
    //   167: ifnull -163 -> 4
    //   170: invokestatic 263	allh:b	()Ljava/util/Map;
    //   173: aload_3
    //   174: invokevirtual 222	com/tencent/qphone/base/remote/FromServiceMsg:getServiceCmd	()Ljava/lang/String;
    //   177: invokeinterface 266 2 0
    //   182: checkcast 268	[I
    //   185: astore 9
    //   187: aload 9
    //   189: ifnull -185 -> 4
    //   192: aload 9
    //   194: arraylength
    //   195: ifle -191 -> 4
    //   198: aload 9
    //   200: arraylength
    //   201: istore 7
    //   203: iconst_0
    //   204: istore 6
    //   206: iload 6
    //   208: iload 7
    //   210: if_icmpge -206 -> 4
    //   213: aload 8
    //   215: aload 9
    //   217: iload 6
    //   219: iaload
    //   220: invokevirtual 274	com/tencent/common/app/AppInterface:getBusinessHandler	(I)Ljava/lang/Object;
    //   223: checkcast 276	alko
    //   226: astore 10
    //   228: aload 10
    //   230: ifnull +12 -> 242
    //   233: aload 10
    //   235: aload_2
    //   236: aload_3
    //   237: aload 4
    //   239: invokevirtual 280	alko:onReceive	(Lcom/tencent/qphone/base/remote/ToServiceMsg;Lcom/tencent/qphone/base/remote/FromServiceMsg;Ljava/lang/Object;)V
    //   242: iload 6
    //   244: iconst_1
    //   245: iadd
    //   246: istore 6
    //   248: goto -42 -> 206
    //   251: aload 4
    //   253: ifnull +88 -> 341
    //   256: new 282	java/io/ByteArrayOutputStream
    //   259: dup
    //   260: invokespecial 283	java/io/ByteArrayOutputStream:<init>	()V
    //   263: astore 9
    //   265: aload 4
    //   267: new 285	java/io/PrintStream
    //   270: dup
    //   271: aload 9
    //   273: invokespecial 288	java/io/PrintStream:<init>	(Ljava/io/OutputStream;)V
    //   276: invokevirtual 292	java/lang/Exception:printStackTrace	(Ljava/io/PrintStream;)V
    //   279: new 43	java/lang/String
    //   282: dup
    //   283: aload 9
    //   285: invokevirtual 296	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   288: invokespecial 299	java/lang/String:<init>	([B)V
    //   291: astore 4
    //   293: invokestatic 71	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   296: ifeq -193 -> 103
    //   299: ldc 73
    //   301: iconst_2
    //   302: new 75	java/lang/StringBuilder
    //   305: dup
    //   306: invokespecial 76	java/lang/StringBuilder:<init>	()V
    //   309: ldc_w 301
    //   312: invokevirtual 82	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   315: aload_3
    //   316: invokevirtual 222	com/tencent/qphone/base/remote/FromServiceMsg:getServiceCmd	()Ljava/lang/String;
    //   319: invokevirtual 82	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   322: ldc 132
    //   324: invokevirtual 82	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   327: aload 4
    //   329: invokevirtual 82	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   332: invokevirtual 85	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   335: invokestatic 89	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   338: goto -235 -> 103
    //   341: invokestatic 71	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   344: ifeq -241 -> 103
    //   347: ldc 73
    //   349: iconst_2
    //   350: new 75	java/lang/StringBuilder
    //   353: dup
    //   354: invokespecial 76	java/lang/StringBuilder:<init>	()V
    //   357: ldc 219
    //   359: invokevirtual 82	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   362: aload_3
    //   363: invokevirtual 222	com/tencent/qphone/base/remote/FromServiceMsg:getServiceCmd	()Ljava/lang/String;
    //   366: invokevirtual 82	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   369: ldc_w 303
    //   372: invokevirtual 82	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   375: aload_3
    //   376: invokevirtual 306	com/tencent/qphone/base/remote/FromServiceMsg:getResultCode	()I
    //   379: invokevirtual 130	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   382: ldc 230
    //   384: invokevirtual 82	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   387: aload_0
    //   388: getfield 32	aytu:jdField_a_of_type_JavaTextDecimalFormat	Ljava/text/DecimalFormat;
    //   391: fload 5
    //   393: f2d
    //   394: invokevirtual 234	java/text/DecimalFormat:format	(D)Ljava/lang/String;
    //   397: invokevirtual 82	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   400: ldc 236
    //   402: invokevirtual 82	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   405: invokevirtual 85	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   408: invokestatic 309	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   411: goto -308 -> 103
    //   414: invokestatic 71	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   417: ifeq +12 -> 429
    //   420: ldc 73
    //   422: iconst_2
    //   423: ldc_w 311
    //   426: invokestatic 89	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   429: aconst_null
    //   430: astore 4
    //   432: goto -272 -> 160
    //   435: astore 4
    //   437: aload 4
    //   439: invokevirtual 313	java/lang/Exception:printStackTrace	()V
    //   442: invokestatic 71	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   445: ifeq +14 -> 459
    //   448: ldc 73
    //   450: iconst_2
    //   451: ldc_w 315
    //   454: aload 4
    //   456: invokestatic 318	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   459: aconst_null
    //   460: astore 4
    //   462: goto -302 -> 160
    //   465: astore 11
    //   467: aload 11
    //   469: invokevirtual 313	java/lang/Exception:printStackTrace	()V
    //   472: invokestatic 71	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   475: ifeq -233 -> 242
    //   478: ldc 73
    //   480: iconst_2
    //   481: new 75	java/lang/StringBuilder
    //   484: dup
    //   485: invokespecial 76	java/lang/StringBuilder:<init>	()V
    //   488: aload 10
    //   490: invokevirtual 322	java/lang/Object:getClass	()Ljava/lang/Class;
    //   493: invokevirtual 327	java/lang/Class:getSimpleName	()Ljava/lang/String;
    //   496: invokevirtual 82	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   499: ldc_w 329
    //   502: invokevirtual 82	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   505: invokevirtual 85	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   508: aload 11
    //   510: invokestatic 331	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   513: goto -271 -> 242
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	516	0	this	aytu
    //   0	516	1	paramBoolean	boolean
    //   0	516	2	paramToServiceMsg	ToServiceMsg
    //   0	516	3	paramFromServiceMsg	FromServiceMsg
    //   0	516	4	paramException	Exception
    //   28	364	5	f	float
    //   204	43	6	i	int
    //   201	10	7	j	int
    //   9	205	8	localAppInterface	AppInterface
    //   133	151	9	localObject	Object
    //   226	263	10	localalko	alko
    //   465	44	11	localException	Exception
    // Exception table:
    //   from	to	target	type
    //   144	160	435	java/lang/Exception
    //   414	429	435	java/lang/Exception
    //   233	242	465	java/lang/Exception
  }
  
  protected boolean a(zdf paramzdf)
  {
    int i = 0;
    String[] arrayOfString = paramzdf.a();
    if ((arrayOfString == null) || (arrayOfString.length == 0)) {
      return false;
    }
    while (i < arrayOfString.length)
    {
      this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(arrayOfString[i], paramzdf);
      i += 1;
    }
    return true;
  }
  
  protected void b()
  {
    try
    {
      this.jdField_a_of_type_Boolean = true;
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public void b(ToServiceMsg paramToServiceMsg, aoct paramaoct, Class<? extends MSFServlet> paramClass)
  {
    int i = 1;
    AppInterface localAppInterface = a();
    Object localObject1 = paramToServiceMsg.getServiceCmd();
    zdf localzdf = a((String)localObject1);
    Object localObject2;
    int j;
    if (localzdf != null)
    {
      localObject2 = a(paramToServiceMsg);
      ((UniPacket)localObject2).setEncodeName("utf-8");
      j = jdField_a_of_type_Int;
      jdField_a_of_type_Int = j + 1;
      ((UniPacket)localObject2).setRequestId(j);
      if (localzdf.a())
      {
        localObject2 = localzdf.a(paramToServiceMsg);
        if (localObject2 == null) {
          break label314;
        }
        paramToServiceMsg.putWupBuffer((byte[])localObject2);
      }
    }
    for (;;)
    {
      if (i != 0)
      {
        paramToServiceMsg.actionListener = paramaoct;
        paramaoct = new NewIntent(localAppInterface.getApplication(), paramClass);
        paramaoct.putExtra(ToServiceMsg.class.getSimpleName(), paramToServiceMsg);
        localAppInterface.startServlet(paramaoct);
        long l = System.currentTimeMillis();
        paramToServiceMsg.extraData.putLong("sendtimekey", l);
      }
      do
      {
        do
        {
          return;
          if (!localzdf.a(paramToServiceMsg, (UniPacket)localObject2)) {
            break label314;
          }
          paramToServiceMsg.putWupBuffer(((UniPacket)localObject2).encode());
          break;
        } while (localzdf == null);
        paramaoct = new FromServiceMsg(localAppInterface.getCurrentAccountUin(), (String)localObject1);
        paramClass = (int[])allh.a().get(localObject1);
      } while ((paramClass == null) || (paramClass.length <= 0));
      j = paramClass.length;
      i = 0;
      while (i < j)
      {
        localObject1 = (alko)localAppInterface.getBusinessHandler(paramClass[i]);
        if (localObject1 != null) {}
        try
        {
          ((alko)localObject1).onReceive(paramToServiceMsg, paramaoct, null);
          i += 1;
        }
        catch (Exception localException)
        {
          for (;;)
          {
            localException.printStackTrace();
            if (QLog.isColorLevel()) {
              QLog.w("PeakJceServiceBase", 2, localObject1.getClass().getSimpleName() + " onReceive error,", localException);
            }
          }
        }
      }
      label314:
      i = 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aytu
 * JD-Core Version:    0.7.0.1
 */