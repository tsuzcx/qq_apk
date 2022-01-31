import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.config.QConfigManager.1;
import com.tencent.mobileqq.config.struct.splashproto.ConfigurationService.Config;
import com.tencent.mobileqq.config.struct.splashproto.ConfigurationService.Content;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.qphone.base.remote.SimpleAccount;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.app.NewIntent;
import mqq.os.MqqHandler;

public class aoks
{
  public static final int[] a;
  private static final Object[] jdField_a_of_type_ArrayOfJavaLangObject = { new Object(), new Object(), new Object(), new Object(), new Object() };
  private final Object jdField_a_of_type_JavaLangObject = new Object();
  private final String jdField_a_of_type_JavaLangString;
  private final Map<Integer, aokh> jdField_a_of_type_JavaUtilMap = new ConcurrentHashMap();
  private final Object jdField_b_of_type_JavaLangObject = new Object();
  private final Map<Integer, aokt> jdField_b_of_type_JavaUtilMap = new ConcurrentHashMap();
  private final Object jdField_c_of_type_JavaLangObject = new Object();
  private final Map<Long, SharedPreferences> jdField_c_of_type_JavaUtilMap = new HashMap();
  private final Object jdField_d_of_type_JavaLangObject = new Object();
  private final Map<Long, SharedPreferences> jdField_d_of_type_JavaUtilMap = new HashMap();
  private final Map<Long, SharedPreferences> e = new HashMap();
  
  static
  {
    jdField_a_of_type_ArrayOfInt = new int[] { 390, 26, 76, 95, 455, 524, 409, 469, 412, 359, 413, 563, 427, 428, 465, 477, 491, 542, 414, 419, 416, 445, 418, 424, 411, 423, 406, 417, 425, 426, 613, 67, 430, 68, 526, 612, 463, 595, 380, 159, 170, 186, 250, 92, 368, 158, 361, 207, 585, 292, 168, 433, 432, 434, 456, 460, 435, 438, 441, 106, 132, 172, 176, 192, 216, 249, 263, 270, 276, 287, 367, 370, 382, 298, 431, 543, 591, 439, 442, 488, 444, 362, 396, 449, 85, 606, 32, 35, 70, 81, 383, 346, 294, 334, 335, 338, 342, 344, 348, 377, 429, 437, 440, 525, 569, 164, 325, 252, 304, 305, 306, 307, 309, 310, 446, 447, 15, 458, 572, 453, 454, 452, 457, 547, 462, 451, 261, 467, 466, 490, 470, 478, 479, 473, 474, 485, 483, 484, 487, 489, 486, 492, 498, 493, 500, 251, 587, 521, 495, 496, 502, 503, 504, 505, 506, 507, 508, 560, 509, 520, 516, 515, 519, 518, 517, 514, 512, 511, 513, 510, 600, 493, 500, 251, 587, 521, 482, 501, 497, 522, 529, 499, 528, 527, 541, 562, 580, 533, 534, 532, 535, 537, 538, 545, 546, 544, 590, 609, 550, 530, 561, 575, 551, 607, 552, 553, 531, 549, 554, 555, 556, 557, 559, 564, 581, 566, 578, 567, 568, 576, 579, 583, 574, 573, 586, 577, 589, 592, 593, 598, 614, 597, 605, 608, 610, 615, 611, 619 };
  }
  
  public aoks()
  {
    File localFile = BaseApplicationImpl.getApplication().getFilesDir();
    Object localObject = localFile;
    if (localFile == null) {
      localObject = BaseApplicationImpl.getApplication().getCacheDir();
    }
    if (localObject != null) {}
    for (localObject = ((File)localObject).getParent();; localObject = File.separator + "data" + File.separator + "data" + File.separator + BaseApplicationImpl.getContext().getPackageName())
    {
      this.jdField_a_of_type_JavaLangString = ((String)localObject + File.separator + "qstore");
      if (QLog.isColorLevel()) {
        QLog.d("QConfigManager", 2, "QConfigManager constructor, rootPath=" + this.jdField_a_of_type_JavaLangString);
      }
      return;
    }
  }
  
  private int a(aokh paramaokh, int paramInt, long paramLong)
  {
    int i = a(paramLong).getInt(String.valueOf(paramInt), -1);
    paramInt = i;
    if (i == -1) {
      paramInt = paramaokh.b();
    }
    return paramInt;
  }
  
  private int a(File paramFile)
  {
    try
    {
      int i = Integer.valueOf(paramFile.getName()).intValue();
      return i;
    }
    catch (NumberFormatException paramFile) {}
    return -1024;
  }
  
  private long a(String paramString, boolean paramBoolean)
  {
    long l2 = 0L;
    long l1 = l2;
    if (paramBoolean) {}
    try
    {
      l1 = Long.parseLong(paramString);
      return l1;
    }
    catch (Exception localException)
    {
      do
      {
        l1 = l2;
      } while (!QLog.isColorLevel());
      QLog.d("QConfigManager", 2, "Can not parse uin - " + paramString);
    }
    return 0L;
  }
  
  private SharedPreferences a(long paramLong)
  {
    Object localObject1 = (SharedPreferences)this.jdField_d_of_type_JavaUtilMap.get(Long.valueOf(paramLong));
    if (localObject1 == null) {
      synchronized (this.jdField_b_of_type_JavaLangObject)
      {
        SharedPreferences localSharedPreferences2 = (SharedPreferences)this.jdField_d_of_type_JavaUtilMap.get(Long.valueOf(paramLong));
        localObject1 = localSharedPreferences2;
        if (localSharedPreferences2 == null)
        {
          localObject1 = "conf_" + paramLong + "_sharepref";
          localSharedPreferences2 = BaseApplicationImpl.getApplication().getSharedPreferences((String)localObject1, 4);
          localObject1 = localSharedPreferences2;
          if (localSharedPreferences2 != null)
          {
            this.jdField_d_of_type_JavaUtilMap.put(Long.valueOf(paramLong), localSharedPreferences2);
            localObject1 = localSharedPreferences2;
          }
        }
        return localObject1;
      }
    }
    return localSharedPreferences1;
  }
  
  public static aoks a()
  {
    return aoku.a;
  }
  
  private File a(String paramString1, String paramString2)
  {
    if (a(paramString1)) {
      return new File(paramString1, paramString2);
    }
    if (QLog.isColorLevel()) {
      QLog.d("QConfigManager", 2, "mkdir dir failed, dir=" + paramString1);
    }
    return null;
  }
  
  private <T> T a(aokh<T> paramaokh, int paramInt)
  {
    Object localObject2 = paramaokh.a(paramInt);
    Object localObject1 = localObject2;
    if (localObject2 == null) {
      localObject1 = a(paramaokh.a());
    }
    return localObject1;
  }
  
  private Object a(aokh paramaokh, long paramLong, int paramInt)
  {
    Object localObject2 = a(paramaokh.a());
    if (localObject2 != null)
    {
      int i = paramaokh.a();
      int j = a(paramaokh, i, paramLong);
      localObject1 = localObject2;
      if (paramaokh.b())
      {
        String str1 = a(i, paramLong, j);
        String str2 = a(i, paramLong, paramInt);
        localObject1 = localObject2;
        if (!TextUtils.equals(str2, str1)) {
          bdhb.a(str1, str2, false);
        }
      }
    }
    for (Object localObject1 = localObject2;; localObject1 = paramaokh.a(0))
    {
      if (QLog.isColorLevel()) {
        QLog.d("QConfigManager", 2, "loadNewConfigFailBackport, version=" + paramInt + ", type" + paramaokh.a() + ", conf=" + localObject1);
      }
      return localObject1;
    }
  }
  
  private Object a(aokh paramaokh, aoko[] paramArrayOfaoko, int paramInt)
  {
    try
    {
      Object localObject = paramaokh.b(paramArrayOfaoko);
      return localObject;
    }
    catch (Exception localException)
    {
      aokv.a().a(paramaokh, paramArrayOfaoko, paramInt, localException);
    }
    return null;
  }
  
  public static <T> T a(Class<T> paramClass)
  {
    try
    {
      Object localObject = paramClass.getDeclaredConstructor(new Class[0]);
      ((Constructor)localObject).setAccessible(true);
      localObject = ((Constructor)localObject).newInstance(new Object[0]);
      a(paramClass, localObject);
      return localObject;
    }
    catch (Exception localException)
    {
      if (QLog.isColorLevel()) {
        QLog.d("QConfigManager", 2, "newInstance failed, class=" + paramClass.getSimpleName(), localException);
      }
    }
    return null;
  }
  
  private String a(int paramInt1, long paramLong, int paramInt2)
  {
    return this.jdField_a_of_type_JavaLangString + File.separator + paramLong + File.separator + "conf" + File.separator + paramInt1 + File.separator + paramInt2;
  }
  
  /* Error */
  private String a(File paramFile)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 8
    //   3: aload_1
    //   4: ifnonnull +29 -> 33
    //   7: aload 8
    //   9: astore 4
    //   11: invokestatic 93	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   14: ifeq +16 -> 30
    //   17: ldc 95
    //   19: iconst_2
    //   20: ldc_w 287
    //   23: invokestatic 100	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   26: aload 8
    //   28: astore 4
    //   30: aload 4
    //   32: areturn
    //   33: aload_1
    //   34: invokevirtual 290	java/io/File:exists	()Z
    //   37: ifeq +93 -> 130
    //   40: aload_1
    //   41: invokevirtual 293	java/io/File:isFile	()Z
    //   44: ifne +41 -> 85
    //   47: aload 8
    //   49: astore 4
    //   51: invokestatic 93	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   54: ifeq -24 -> 30
    //   57: ldc 95
    //   59: iconst_2
    //   60: new 72	java/lang/StringBuilder
    //   63: dup
    //   64: invokespecial 73	java/lang/StringBuilder:<init>	()V
    //   67: ldc_w 295
    //   70: invokevirtual 77	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   73: aload_1
    //   74: invokevirtual 242	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   77: invokevirtual 85	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   80: invokestatic 100	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   83: aconst_null
    //   84: areturn
    //   85: aload_1
    //   86: invokevirtual 298	java/io/File:canRead	()Z
    //   89: ifne +79 -> 168
    //   92: aload 8
    //   94: astore 4
    //   96: invokestatic 93	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   99: ifeq -69 -> 30
    //   102: ldc 95
    //   104: iconst_2
    //   105: new 72	java/lang/StringBuilder
    //   108: dup
    //   109: invokespecial 73	java/lang/StringBuilder:<init>	()V
    //   112: ldc_w 300
    //   115: invokevirtual 77	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   118: aload_1
    //   119: invokevirtual 242	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   122: invokevirtual 85	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   125: invokestatic 100	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   128: aconst_null
    //   129: areturn
    //   130: aload 8
    //   132: astore 4
    //   134: invokestatic 93	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   137: ifeq -107 -> 30
    //   140: ldc 95
    //   142: iconst_2
    //   143: new 72	java/lang/StringBuilder
    //   146: dup
    //   147: invokespecial 73	java/lang/StringBuilder:<init>	()V
    //   150: ldc_w 302
    //   153: invokevirtual 77	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   156: aload_1
    //   157: invokevirtual 242	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   160: invokevirtual 85	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   163: invokestatic 100	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   166: aconst_null
    //   167: areturn
    //   168: new 304	java/io/FileInputStream
    //   171: dup
    //   172: aload_1
    //   173: invokespecial 307	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   176: astore 4
    //   178: new 309	java/io/InputStreamReader
    //   181: dup
    //   182: aload 4
    //   184: ldc_w 311
    //   187: invokespecial 314	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;Ljava/lang/String;)V
    //   190: astore_3
    //   191: aload_3
    //   192: astore 6
    //   194: aload 4
    //   196: astore 5
    //   198: aload_1
    //   199: invokevirtual 318	java/io/File:length	()J
    //   202: l2i
    //   203: istore_2
    //   204: iload_2
    //   205: sipush 12288
    //   208: if_icmple +195 -> 403
    //   211: aload_3
    //   212: astore 6
    //   214: aload 4
    //   216: astore 5
    //   218: sipush 4096
    //   221: newarray char
    //   223: astore 7
    //   225: aload_3
    //   226: astore 6
    //   228: aload 4
    //   230: astore 5
    //   232: new 72	java/lang/StringBuilder
    //   235: dup
    //   236: sipush 12288
    //   239: invokespecial 321	java/lang/StringBuilder:<init>	(I)V
    //   242: astore 9
    //   244: aload_3
    //   245: astore 6
    //   247: aload 4
    //   249: astore 5
    //   251: aload_3
    //   252: aload 7
    //   254: invokevirtual 325	java/io/InputStreamReader:read	([C)I
    //   257: istore_2
    //   258: iconst_m1
    //   259: iload_2
    //   260: if_icmpeq +100 -> 360
    //   263: aload_3
    //   264: astore 6
    //   266: aload 4
    //   268: astore 5
    //   270: aload 9
    //   272: aload 7
    //   274: iconst_0
    //   275: iload_2
    //   276: invokevirtual 328	java/lang/StringBuilder:append	([CII)Ljava/lang/StringBuilder;
    //   279: pop
    //   280: goto -36 -> 244
    //   283: astore 7
    //   285: aload_3
    //   286: astore 6
    //   288: aload 4
    //   290: astore 5
    //   292: invokestatic 93	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   295: ifeq +38 -> 333
    //   298: aload_3
    //   299: astore 6
    //   301: aload 4
    //   303: astore 5
    //   305: ldc 95
    //   307: iconst_2
    //   308: new 72	java/lang/StringBuilder
    //   311: dup
    //   312: invokespecial 73	java/lang/StringBuilder:<init>	()V
    //   315: ldc_w 330
    //   318: invokevirtual 77	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   321: aload_1
    //   322: invokevirtual 242	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   325: invokevirtual 85	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   328: aload 7
    //   330: invokestatic 281	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   333: aload 4
    //   335: ifnull +8 -> 343
    //   338: aload 4
    //   340: invokevirtual 335	java/io/InputStream:close	()V
    //   343: aload 8
    //   345: astore 4
    //   347: aload_3
    //   348: ifnull -318 -> 30
    //   351: aload_3
    //   352: invokevirtual 336	java/io/InputStreamReader:close	()V
    //   355: aconst_null
    //   356: areturn
    //   357: astore_1
    //   358: aconst_null
    //   359: areturn
    //   360: aload_3
    //   361: astore 6
    //   363: aload 4
    //   365: astore 5
    //   367: aload 9
    //   369: invokevirtual 85	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   372: astore 7
    //   374: aload 7
    //   376: astore_1
    //   377: aload 4
    //   379: ifnull +8 -> 387
    //   382: aload 4
    //   384: invokevirtual 335	java/io/InputStream:close	()V
    //   387: aload_1
    //   388: astore 4
    //   390: aload_3
    //   391: ifnull -361 -> 30
    //   394: aload_3
    //   395: invokevirtual 336	java/io/InputStreamReader:close	()V
    //   398: aload_1
    //   399: areturn
    //   400: astore_3
    //   401: aload_1
    //   402: areturn
    //   403: aload_3
    //   404: astore 6
    //   406: aload 4
    //   408: astore 5
    //   410: iload_2
    //   411: newarray char
    //   413: astore 7
    //   415: aload_3
    //   416: astore 6
    //   418: aload 4
    //   420: astore 5
    //   422: new 117	java/lang/String
    //   425: dup
    //   426: aload 7
    //   428: iconst_0
    //   429: aload_3
    //   430: aload 7
    //   432: invokevirtual 325	java/io/InputStreamReader:read	([C)I
    //   435: invokespecial 339	java/lang/String:<init>	([CII)V
    //   438: astore 7
    //   440: aload 7
    //   442: astore_1
    //   443: goto -66 -> 377
    //   446: astore_1
    //   447: aconst_null
    //   448: astore 6
    //   450: aconst_null
    //   451: astore 4
    //   453: aload 4
    //   455: ifnull +8 -> 463
    //   458: aload 4
    //   460: invokevirtual 335	java/io/InputStream:close	()V
    //   463: aload 6
    //   465: ifnull +8 -> 473
    //   468: aload 6
    //   470: invokevirtual 336	java/io/InputStreamReader:close	()V
    //   473: aload_1
    //   474: athrow
    //   475: astore 4
    //   477: goto -90 -> 387
    //   480: astore_1
    //   481: goto -138 -> 343
    //   484: astore_3
    //   485: goto -22 -> 463
    //   488: astore_3
    //   489: goto -16 -> 473
    //   492: astore_1
    //   493: aconst_null
    //   494: astore 6
    //   496: goto -43 -> 453
    //   499: astore_1
    //   500: aload 5
    //   502: astore 4
    //   504: goto -51 -> 453
    //   507: astore 7
    //   509: aconst_null
    //   510: astore_3
    //   511: aconst_null
    //   512: astore 4
    //   514: goto -229 -> 285
    //   517: astore 7
    //   519: aconst_null
    //   520: astore_3
    //   521: goto -236 -> 285
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	524	0	this	aoks
    //   0	524	1	paramFile	File
    //   203	208	2	i	int
    //   190	205	3	localInputStreamReader	java.io.InputStreamReader
    //   400	30	3	localException1	Exception
    //   484	1	3	localException2	Exception
    //   488	1	3	localException3	Exception
    //   510	11	3	localObject1	Object
    //   9	450	4	localObject2	Object
    //   475	1	4	localException4	Exception
    //   502	11	4	localObject3	Object
    //   196	305	5	localObject4	Object
    //   192	303	6	localObject5	Object
    //   223	50	7	arrayOfChar	char[]
    //   283	46	7	localException5	Exception
    //   372	69	7	localObject6	Object
    //   507	1	7	localException6	Exception
    //   517	1	7	localException7	Exception
    //   1	343	8	localObject7	Object
    //   242	126	9	localStringBuilder	java.lang.StringBuilder
    // Exception table:
    //   from	to	target	type
    //   198	204	283	java/lang/Exception
    //   218	225	283	java/lang/Exception
    //   232	244	283	java/lang/Exception
    //   251	258	283	java/lang/Exception
    //   270	280	283	java/lang/Exception
    //   367	374	283	java/lang/Exception
    //   410	415	283	java/lang/Exception
    //   422	440	283	java/lang/Exception
    //   351	355	357	java/lang/Exception
    //   394	398	400	java/lang/Exception
    //   168	178	446	finally
    //   382	387	475	java/lang/Exception
    //   338	343	480	java/lang/Exception
    //   458	463	484	java/lang/Exception
    //   468	473	488	java/lang/Exception
    //   178	191	492	finally
    //   198	204	499	finally
    //   218	225	499	finally
    //   232	244	499	finally
    //   251	258	499	finally
    //   270	280	499	finally
    //   292	298	499	finally
    //   305	333	499	finally
    //   367	374	499	finally
    //   410	415	499	finally
    //   422	440	499	finally
    //   168	178	507	java/lang/Exception
    //   178	191	517	java/lang/Exception
  }
  
  private void a(aokh paramaokh, ConfigurationService.Config paramConfig, long paramLong, String paramString, int paramInt1, int paramInt2)
  {
    int i = paramConfig.msg_content_list.size();
    if (i == 0) {
      paramConfig = paramaokh.a(1);
    }
    label312:
    for (;;)
    {
      if (i == 0) {}
      for (boolean bool = true;; bool = false)
      {
        a(paramaokh, paramConfig, paramInt2, paramLong, bool);
        return;
        ArrayList localArrayList = new ArrayList();
        paramInt1 = 0;
        if (paramInt1 < i)
        {
          ConfigurationService.Content localContent = (ConfigurationService.Content)paramConfig.msg_content_list.get(paramInt1);
          Object localObject1;
          if ((localContent != null) && (localContent.content.has()))
          {
            if (localContent.compress.get() != 1) {
              break label199;
            }
            localObject1 = awci.a(localContent.content.get().toByteArray());
            if (localObject1 == null) {
              break label193;
            }
          }
          for (;;)
          {
            try
            {
              localObject1 = new String((byte[])localObject1, "UTF-8");
              if (!TextUtils.isEmpty((CharSequence)localObject1)) {
                localArrayList.add(new aoko(localContent.task_id.get(), (String)localObject1));
              }
              paramInt1 += 1;
            }
            catch (UnsupportedEncodingException localUnsupportedEncodingException)
            {
              if (QLog.isColorLevel()) {
                QLog.d("QConfigManager", 2, "decompile faild.");
              }
            }
            label193:
            localObject2 = null;
            continue;
            label199:
            localObject2 = localContent.content.get().toStringUtf8();
          }
        }
        Object localObject2 = new aoko[localArrayList.size()];
        localArrayList.toArray((Object[])localObject2);
        paramConfig = a(paramaokh, (aoko[])localObject2, paramInt2);
        if (paramConfig != null)
        {
          a(paramaokh, (aoko[])localObject2, paramLong, paramString);
          if (!QLog.isColorLevel()) {
            break label312;
          }
          QLog.d("QConfigManager", 2, "handleNewConfig, parse success, size=" + localObject2.length);
          break;
        }
        paramConfig = a(paramaokh, paramLong, paramInt2);
        break;
      }
    }
  }
  
  private void a(aokh paramaokh, Object paramObject, int paramInt, long paramLong, boolean paramBoolean)
  {
    if (paramObject != null)
    {
      a(paramLong).edit().putInt(String.valueOf(paramaokh.a()), paramInt).putBoolean(paramaokh.a() + "_" + paramInt + "_defualt", paramBoolean).apply();
      this.jdField_b_of_type_JavaUtilMap.put(Integer.valueOf(paramaokh.a()), new aokt(paramLong, paramInt, paramObject));
      paramaokh.a(paramObject);
    }
  }
  
  private void a(aokh paramaokh, aoko[] paramArrayOfaoko, long paramLong, String paramString)
  {
    int j = 0;
    int i = 0;
    if (paramaokh.b())
    {
      a(new File(paramString));
      while (i < paramArrayOfaoko.length)
      {
        paramaokh = a(paramString, String.valueOf(paramArrayOfaoko[i].jdField_a_of_type_Int));
        if (paramaokh != null) {
          a(paramArrayOfaoko[i].jdField_a_of_type_JavaLangString, paramaokh);
        }
        i += 1;
      }
    }
    paramString = c(paramLong).edit();
    HashSet localHashSet = new HashSet();
    i = j;
    while (i < paramArrayOfaoko.length)
    {
      localHashSet.add(String.valueOf(paramArrayOfaoko[i].jdField_a_of_type_Int));
      paramString.putString(paramaokh.a() + "_" + paramArrayOfaoko[i].jdField_a_of_type_Int, paramArrayOfaoko[i].jdField_a_of_type_JavaLangString);
      i += 1;
    }
    a(paramLong).edit().putStringSet(paramaokh.a() + "_ids", localHashSet).apply();
    paramString.apply();
  }
  
  private void a(File paramFile)
  {
    int j;
    int i;
    if ((paramFile.exists()) && (paramFile.isDirectory()))
    {
      if (paramFile.listFiles().length != 0)
      {
        paramFile = paramFile.listFiles();
        j = paramFile.length;
        i = 0;
      }
    }
    else {
      while (i < j)
      {
        a(paramFile[i]);
        i += 1;
        continue;
        a(paramFile);
      }
    }
  }
  
  public static void a(Class paramClass, Object paramObject) {}
  
  private static void a(Exception paramException)
  {
    try
    {
      throw paramException;
    }
    catch (Exception paramException)
    {
      ThreadManager.getSubThreadHandler().post(new QConfigManager.1(paramException));
    }
  }
  
  private boolean a(File paramFile)
  {
    if (paramFile.isDirectory())
    {
      String[] arrayOfString = paramFile.list();
      if (arrayOfString != null)
      {
        int i = 0;
        while (i < arrayOfString.length)
        {
          if (!a(new File(paramFile, arrayOfString[i]))) {
            return false;
          }
          i += 1;
        }
      }
    }
    return paramFile.delete();
  }
  
  private boolean a(String paramString)
  {
    paramString = new File(paramString);
    if (paramString.exists()) {
      return true;
    }
    return paramString.mkdirs();
  }
  
  /* Error */
  private boolean a(String paramString, File paramFile)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore 4
    //   3: iconst_1
    //   4: istore 5
    //   6: aconst_null
    //   7: astore 6
    //   9: iload 5
    //   11: istore_3
    //   12: aload_2
    //   13: invokevirtual 290	java/io/File:exists	()Z
    //   16: ifne +11 -> 27
    //   19: aload_2
    //   20: invokevirtual 544	java/io/File:createNewFile	()Z
    //   23: pop
    //   24: iload 5
    //   26: istore_3
    //   27: new 546	java/io/FileOutputStream
    //   30: dup
    //   31: aload_2
    //   32: iconst_0
    //   33: invokespecial 549	java/io/FileOutputStream:<init>	(Ljava/io/File;Z)V
    //   36: astore 7
    //   38: aload 7
    //   40: astore 6
    //   42: aload 6
    //   44: ifnull +17 -> 61
    //   47: aload 6
    //   49: aload_1
    //   50: invokevirtual 552	java/lang/String:getBytes	()[B
    //   53: invokevirtual 556	java/io/FileOutputStream:write	([B)V
    //   56: aload 6
    //   58: invokevirtual 559	java/io/FileOutputStream:flush	()V
    //   61: aload 6
    //   63: ifnull +128 -> 191
    //   66: aload 6
    //   68: invokevirtual 560	java/io/FileOutputStream:close	()V
    //   71: iload_3
    //   72: ireturn
    //   73: astore 7
    //   75: invokestatic 93	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   78: ifeq +29 -> 107
    //   81: ldc 95
    //   83: iconst_2
    //   84: new 72	java/lang/StringBuilder
    //   87: dup
    //   88: invokespecial 73	java/lang/StringBuilder:<init>	()V
    //   91: ldc_w 562
    //   94: invokevirtual 77	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   97: aload_2
    //   98: invokevirtual 242	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   101: invokevirtual 85	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   104: invokestatic 100	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   107: iconst_0
    //   108: istore_3
    //   109: goto -82 -> 27
    //   112: astore 7
    //   114: iconst_0
    //   115: istore_3
    //   116: goto -74 -> 42
    //   119: astore_1
    //   120: invokestatic 93	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   123: ifeq +30 -> 153
    //   126: ldc 95
    //   128: iconst_2
    //   129: new 72	java/lang/StringBuilder
    //   132: dup
    //   133: invokespecial 73	java/lang/StringBuilder:<init>	()V
    //   136: ldc_w 564
    //   139: invokevirtual 77	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   142: aload_2
    //   143: invokevirtual 242	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   146: invokevirtual 85	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   149: aload_1
    //   150: invokestatic 281	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   153: iload 4
    //   155: istore_3
    //   156: aload 6
    //   158: ifnull -87 -> 71
    //   161: aload 6
    //   163: invokevirtual 560	java/io/FileOutputStream:close	()V
    //   166: iconst_0
    //   167: ireturn
    //   168: astore_1
    //   169: iconst_0
    //   170: ireturn
    //   171: astore_1
    //   172: aload 6
    //   174: ifnull +8 -> 182
    //   177: aload 6
    //   179: invokevirtual 560	java/io/FileOutputStream:close	()V
    //   182: aload_1
    //   183: athrow
    //   184: astore_1
    //   185: iconst_0
    //   186: ireturn
    //   187: astore_2
    //   188: goto -6 -> 182
    //   191: iload_3
    //   192: ireturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	193	0	this	aoks
    //   0	193	1	paramString	String
    //   0	193	2	paramFile	File
    //   11	181	3	bool1	boolean
    //   1	153	4	bool2	boolean
    //   4	21	5	bool3	boolean
    //   7	171	6	localObject	Object
    //   36	3	7	localFileOutputStream	java.io.FileOutputStream
    //   73	1	7	localIOException	java.io.IOException
    //   112	1	7	localFileNotFoundException	java.io.FileNotFoundException
    // Exception table:
    //   from	to	target	type
    //   19	24	73	java/io/IOException
    //   27	38	112	java/io/FileNotFoundException
    //   47	61	119	java/io/IOException
    //   161	166	168	java/io/IOException
    //   47	61	171	finally
    //   120	153	171	finally
    //   66	71	184	java/io/IOException
    //   177	182	187	java/io/IOException
  }
  
  private aoko[] a(int paramInt, long paramLong)
  {
    int i = a(paramInt, paramLong);
    if (c(paramInt) == null) {}
    File[] arrayOfFile;
    do
    {
      return null;
      localObject = new File(a(paramInt, paramLong, i));
      arrayOfFile = ((File)localObject).listFiles();
    } while ((!((File)localObject).exists()) || (arrayOfFile == null) || (arrayOfFile.length == 0));
    Object localObject = new aoko[arrayOfFile.length];
    paramInt = 0;
    while (paramInt < arrayOfFile.length)
    {
      File localFile = arrayOfFile[paramInt];
      localObject[paramInt] = new aoko(a(localFile), a(localFile));
      paramInt += 1;
    }
    return localObject;
  }
  
  private SharedPreferences b(long paramLong)
  {
    Object localObject1 = (SharedPreferences)this.e.get(Long.valueOf(paramLong));
    if (localObject1 == null) {
      synchronized (this.jdField_d_of_type_JavaLangObject)
      {
        SharedPreferences localSharedPreferences2 = (SharedPreferences)this.e.get(Long.valueOf(paramLong));
        localObject1 = localSharedPreferences2;
        if (localSharedPreferences2 == null)
        {
          localObject1 = "conf_" + paramLong + "_upgrade_pref";
          localSharedPreferences2 = BaseApplicationImpl.getApplication().getSharedPreferences((String)localObject1, 4);
          localObject1 = localSharedPreferences2;
          if (localSharedPreferences2 != null)
          {
            this.e.put(Long.valueOf(paramLong), localSharedPreferences2);
            localObject1 = localSharedPreferences2;
          }
        }
        return localObject1;
      }
    }
    return localSharedPreferences1;
  }
  
  private aokh b(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return null;
    case 605: 
      return new bbzi();
    case 390: 
      return new aoqc();
    case 26: 
      return new aovr();
    case 76: 
      return new aovg();
    case 95: 
      return new aoun();
    case 189: 
      return new aovv();
    case 409: 
      return new aove();
    case 469: 
      return new aovc();
    case 412: 
      return new aouw();
    case 359: 
      return new aowa();
    case 465: 
      return new aova();
    case 427: 
      return new aout();
    case 491: 
      return new aouo();
    case 413: 
      return new aovl();
    case 563: 
      return new aovn();
    case 477: 
      return new aovy();
    case 411: 
      return new yyy();
    case 414: 
      return new aonw();
    case 419: 
      return new aoqa();
    case 416: 
      return new anwd();
    case 445: 
      return new asyn();
    case 418: 
      return new aorv();
    case 424: 
      return new aozi();
    case 410: 
      return new agyn();
    case 423: 
      return new aovp();
    case 428: 
      return new aouu();
    case 406: 
      return new yzi();
    case 417: 
      return new aons();
    case 425: 
      return new aoom();
    case 426: 
      return new aooz();
    case 613: 
      return new aopb();
    case 67: 
      return new aolm();
    case 430: 
      return new aolo();
    case 380: 
      return new aomc();
    case 159: 
      return new aomb();
    case 170: 
      return new aoly();
    case 186: 
      return new aolz();
    case 250: 
      return new aoma();
    case 292: 
      return new aoqz();
    case 92: 
      return new aora();
    case 368: 
      return new aorc();
    case 158: 
      return new aosl();
    case 361: 
      return new aosn();
    case 207: 
      return new aosp();
    case 585: 
      return new aosj();
    case 168: 
      return new aono();
    case 453: 
      return new aonk();
    case 68: 
      return new aopq();
    case 526: 
      return new aznh();
    case 612: 
      return new babs();
    case 456: 
      return new aowo();
    case 460: 
      return new aowc();
    case 433: 
      return new aowg();
    case 432: 
      return new aowj();
    case 434: 
      return new aowe();
    case 435: 
      return new aose();
    case 438: 
      return new ahsr();
    case 441: 
      return new aoqs();
    case 106: 
    case 132: 
    case 172: 
    case 176: 
    case 192: 
    case 216: 
    case 249: 
    case 263: 
    case 270: 
    case 276: 
    case 287: 
    case 298: 
    case 367: 
    case 370: 
    case 382: 
    case 543: 
    case 591: 
      return new lex(paramInt);
    case 431: 
      return new lep();
    case 439: 
      return new aopw();
    case 442: 
      return new aops();
    case 488: 
      return new aopu();
    case 444: 
      return new aouy();
    case 362: 
      return new aorp();
    case 164: 
      return new astr();
    case 325: 
      return new azcz();
    case 396: 
      return new aotj();
    case 85: 
      return new aotm();
    case 81: 
      return new ntr();
    case 32: 
      return new ntp();
    case 35: 
      return new ntl();
    case 70: 
      return new ntn();
    case 383: 
      return new aoxk();
    case 346: 
      return new aoyr();
    case 294: 
      return new aoxe();
    case 334: 
      return new aoxa();
    case 335: 
      return new aoyl();
    case 338: 
      return new aoxs();
    case 342: 
      return new aoxc();
    case 344: 
      return new aoyv();
    case 348: 
      return new aoyn();
    case 377: 
      return new aoxw();
    case 429: 
      return new aoxn();
    case 525: 
      return new aoyb();
    case 569: 
      return new aoxq();
    case 437: 
      return new aoyh();
    case 440: 
      return new aoyd();
    case 252: 
      return new aore();
    case 304: 
      return new aoqk();
    case 446: 
      return new aook();
    case 305: 
      return new aoqi();
    case 306: 
      return new aoqg();
    case 307: 
      return new aoqm();
    case 309: 
      return new aoqe();
    case 310: 
      return new aoqd();
    case 457: 
      return new aolf();
    case 547: 
      return new bcid();
    case 449: 
      return new aoty();
    case 447: 
      return new tei();
    case 458: 
      return new aoot();
    case 572: 
      return new aoov();
    case 15: 
      return new bats();
    case 454: 
      return new atwf();
    case 452: 
      return new aone();
    case 462: 
      return new aoyw();
    case 455: 
      return new aonq();
    case 524: 
      return new aooq();
    case 451: 
      return new aoyj();
    case 261: 
      return new aoxg();
    case 463: 
      return new yzg();
    case 595: 
      return new yze();
    case 467: 
      return new aopi();
    case 466: 
      return new aopf();
    case 490: 
      return new aorh();
    case 470: 
      return new aijc();
    case 478: 
      return new aule();
    case 479: 
      return new aouh();
    case 473: 
      return new yza();
    case 474: 
      return new yzc();
    case 485: 
      return new ayfu();
    case 483: 
      return new aoxu();
    case 484: 
      return new aost();
    case 487: 
      return new aoyf();
    case 489: 
      return new aooo();
    case 486: 
      return new aowu();
    case 492: 
      return new aony();
    case 498: 
      return new aous();
    case 500: 
      return new aoww();
    case 493: 
      return new aota();
    case 521: 
      return new aowy();
    case 251: 
      return new aopm();
    case 587: 
      return new aopk();
    case 496: 
      return new awkv();
    case 495: 
      return new awlv();
    case 502: 
      return new awkz();
    case 503: 
      return new awlu();
    case 504: 
      return new awlm();
    case 505: 
      return new awlh();
    case 506: 
      return new awlj();
    case 507: 
      return new awlf();
    case 508: 
      return new awli();
    case 560: 
      return new awlr();
    case 509: 
      return new awle();
    case 520: 
      return new awlk();
    case 516: 
      return new awld();
    case 515: 
      return new awlt();
    case 519: 
      return new awla();
    case 518: 
      return new awlg();
    case 517: 
      return new awls();
    case 514: 
      return new awlb();
    case 512: 
      return new awln();
    case 511: 
      return new awll();
    case 513: 
      return new awlq();
    case 510: 
      return new awlo();
    case 600: 
      return new awlp();
    case 482: 
      return new aoyy();
    case 501: 
      return new aoza();
    case 497: 
      return new aosr();
    case 522: 
      return new auji();
    case 529: 
      return new aows();
    case 527: 
      return new aouq();
    case 541: 
      return new aoul();
    case 562: 
      return new aovt();
    case 580: 
      return new aovi();
    case 534: 
      return new aoqq();
    case 532: 
      return new aqfy();
    case 528: 
      return new aoni();
    case 499: 
      return new aosh();
    case 535: 
      return new aorw();
    case 551: 
      return new aorm();
    case 607: 
      return new aorr();
    case 533: 
      return new aots();
    case 542: 
      return new aoup();
    case 537: 
      return new aolj();
    case 538: 
      return new aork();
    case 545: 
      return new aoqt();
    case 546: 
      return new aoqx();
    case 544: 
      return new bcgm();
    case 550: 
      return new aosc();
    case 530: 
      return new aopn();
    case 561: 
      return new aonl();
    case 552: 
      return new aood();
    case 553: 
      return new aosa();
    case 578: 
      return new aoox();
    case 531: 
      return new aonf();
    case 549: 
      return new aobu();
    case 554: 
      return new aotw();
    case 555: 
      return new aotu();
    case 556: 
      return new aoto();
    case 557: 
      return new aotq();
    case 559: 
      return new aoyt();
    case 564: 
      return new aori();
    case 581: 
      return new aooi();
    case 566: 
      return new aomz();
    case 575: 
      return new aoog();
    case 567: 
      return new aonb();
    case 568: 
      return new aopx();
    case 576: 
      return new aogn();
    case 579: 
      return new aogp();
    case 583: 
      return new aosy();
    case 574: 
      return new aolh();
    case 573: 
      return new aozc();
    case 586: 
      return new aocq();
    case 577: 
      return new azqi();
    case 589: 
      return new aowk();
    case 592: 
      return new afco();
    case 593: 
      return new nvc();
    case 590: 
      return new bcil();
    case 609: 
      return new aewa();
    case 597: 
      return new aolp();
    case 598: 
      return new aooc();
    case 614: 
      return new aooa();
    case 606: 
      return new aoue();
    case 608: 
      return new aonu();
    case 610: 
      return new babb();
    case 615: 
      return new babf();
    case 611: 
      return new awlx();
    }
    return new babl();
  }
  
  private void b(aokh paramaokh, ConfigurationService.Config paramConfig, long paramLong, String paramString, int paramInt1, int paramInt2)
  {
    if (paramConfig.content_list.isEmpty()) {
      paramString = paramaokh.a(1);
    }
    for (;;)
    {
      a(paramaokh, paramString, paramInt2, paramLong, paramConfig.content_list.isEmpty());
      return;
      int i = paramConfig.content_list.size();
      aoko[] arrayOfaoko = new aoko[i];
      paramInt1 = 0;
      while (paramInt1 < i)
      {
        arrayOfaoko[paramInt1] = new aoko(paramInt1, (String)paramConfig.content_list.get(paramInt1));
        paramInt1 += 1;
      }
      Object localObject = a(paramaokh, arrayOfaoko, paramInt2);
      if (localObject != null)
      {
        a(paramaokh, arrayOfaoko, paramLong, paramString);
        if (QLog.isColorLevel())
        {
          QLog.d("QConfigManager", 2, "handleOldConfig, parse success, size=" + i);
          paramString = localObject;
        }
      }
      else
      {
        paramString = a(paramaokh, paramLong, paramInt2);
        continue;
      }
      paramString = localObject;
    }
  }
  
  private aoko[] b(int paramInt, long paramLong)
  {
    if (a(paramInt) == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("QConfigManager", 2, "getConfigFromSp, type is not support, type=" + paramInt);
      }
      return null;
    }
    Object localObject1 = a(paramLong);
    SharedPreferences localSharedPreferences = c(paramLong);
    Object localObject2 = ((SharedPreferences)localObject1).getStringSet(paramInt + "_ids", null);
    if ((localObject2 == null) || (((Set)localObject2).isEmpty())) {
      return null;
    }
    localObject1 = new aoko[((Set)localObject2).size()];
    localObject2 = ((Set)localObject2).iterator();
    int i = 0;
    while (((Iterator)localObject2).hasNext())
    {
      String str = (String)((Iterator)localObject2).next();
      localObject1[i] = new aoko(Integer.valueOf(str).intValue(), localSharedPreferences.getString(paramInt + "_" + str, null));
      i += 1;
    }
    return localObject1;
  }
  
  private SharedPreferences c(long paramLong)
  {
    Object localObject1 = (SharedPreferences)this.jdField_c_of_type_JavaUtilMap.get(Long.valueOf(paramLong));
    if (localObject1 == null) {
      synchronized (this.jdField_c_of_type_JavaLangObject)
      {
        SharedPreferences localSharedPreferences2 = (SharedPreferences)this.jdField_c_of_type_JavaUtilMap.get(Long.valueOf(paramLong));
        localObject1 = localSharedPreferences2;
        if (localSharedPreferences2 == null)
        {
          localObject1 = "conf_" + paramLong + "_content_sharepref";
          localSharedPreferences2 = BaseApplicationImpl.getApplication().getSharedPreferences((String)localObject1, 4);
          localObject1 = localSharedPreferences2;
          if (localSharedPreferences2 != null)
          {
            this.jdField_c_of_type_JavaUtilMap.put(Long.valueOf(paramLong), localSharedPreferences2);
            localObject1 = localSharedPreferences2;
          }
        }
        return localObject1;
      }
    }
    return localSharedPreferences1;
  }
  
  private aokh c(int paramInt)
  {
    aokh localaokh = a(paramInt);
    if (localaokh == null) {}
    return localaokh;
  }
  
  public int a(int paramInt, long paramLong)
  {
    aokh localaokh = a(paramInt);
    if (localaokh == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("QConfigManager", 2, "getConfVersion, process is null, type=" + paramInt);
      }
      return -1;
    }
    return a(localaokh, paramInt, paramLong);
  }
  
  public int a(int paramInt, String paramString)
  {
    aokh localaokh = a(paramInt);
    if (localaokh == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("QConfigManager", 2, "getConfVersion, process is null, type=" + paramInt);
      }
      return -1;
    }
    return a(localaokh, paramInt, a(paramString, localaokh.a()));
  }
  
  public aokh a(int paramInt)
  {
    Object localObject1 = (aokh)this.jdField_a_of_type_JavaUtilMap.get(Integer.valueOf(paramInt));
    if (localObject1 == null) {
      synchronized (this.jdField_a_of_type_JavaLangObject)
      {
        aokh localaokh2 = (aokh)this.jdField_a_of_type_JavaUtilMap.get(Integer.valueOf(paramInt));
        localObject1 = localaokh2;
        if (localaokh2 == null)
        {
          localaokh2 = b(paramInt);
          localObject1 = localaokh2;
          if (localaokh2 != null)
          {
            this.jdField_a_of_type_JavaUtilMap.put(Integer.valueOf(paramInt), localaokh2);
            localObject1 = localaokh2;
          }
        }
        return localObject1;
      }
    }
    return localaokh1;
  }
  
  public <T> T a(int paramInt)
  {
    aokh localaokh = c(paramInt);
    if (localaokh == null) {
      return null;
    }
    Object localObject1;
    if (localaokh.a())
    {
      localObject1 = MobileQQ.sMobileQQ.getFirstSimpleAccount();
      if (localObject1 == null) {}
    }
    int i;
    for (long l = a(((SimpleAccount)localObject1).getUin(), localaokh.a());; l = 0L)
    {
      localObject1 = a(l);
      i = ((SharedPreferences)localObject1).getInt(String.valueOf(paramInt), -1);
      if (i != -1) {
        break;
      }
      return a(localaokh, 0);
      if (QLog.isColorLevel()) {
        QLog.d("QConfigManager", 2, "Can not get an runtime.May be in a process of none appRuntime.");
      }
      return a(localaokh, 1);
    }
    ??? = (aokt)this.jdField_b_of_type_JavaUtilMap.get(Integer.valueOf(paramInt));
    if ((??? != null) && (((aokt)???).jdField_a_of_type_Int == i) && (((aokt)???).jdField_a_of_type_Long == l) && (((aokt)???).jdField_a_of_type_JavaLangObject != null)) {
      return ((aokt)???).jdField_a_of_type_JavaLangObject;
    }
    if (((SharedPreferences)localObject1).getBoolean(localaokh.a() + "_" + i + "_defualt", false)) {
      return a(localaokh, 0);
    }
    Object localObject3;
    for (;;)
    {
      synchronized (jdField_a_of_type_ArrayOfJavaLangObject[(paramInt % 5)])
      {
        aokp.a().a(paramInt, l, localaokh.b());
        if (localaokh.b())
        {
          localObject1 = a(paramInt, l);
          if (localObject1 != null) {
            break;
          }
          localObject1 = a(localaokh.a());
          return localObject1;
        }
      }
      localObject3 = b(paramInt, l);
    }
    try
    {
      Object localObject5 = localaokh.b((aoko[])localObject3);
      this.jdField_b_of_type_JavaUtilMap.put(Integer.valueOf(paramInt), new aokt(l, i, localObject5));
      return localObject5;
    }
    catch (Exception localException)
    {
      aokv.a().a(localaokh, (aoko[])localObject3, i, localException);
      localObject3 = a(localaokh.a());
    }
    return localObject3;
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    Object localObject = a(paramInt1);
    long l2 = 0L;
    long l1 = l2;
    if (localObject != null)
    {
      l1 = l2;
      if (((aokh)localObject).a())
      {
        AppRuntime localAppRuntime = MobileQQ.sMobileQQ.waitAppRuntime(null);
        l1 = l2;
        if (localAppRuntime != null) {
          l1 = a(localAppRuntime.getAccount(), ((aokh)localObject).a());
        }
      }
    }
    localObject = a(l1);
    int i = ((SharedPreferences)localObject).getInt(String.valueOf(paramInt1), -1);
    if ((i != -1) && (i != paramInt2))
    {
      if (QLog.isColorLevel()) {
        QLog.d("QConfigManager", 2, "setConfVersion t=" + paramInt1 + " v=" + paramInt2);
      }
      ((SharedPreferences)localObject).edit().putInt(String.valueOf(paramInt1), paramInt2).apply();
    }
  }
  
  public void a(int paramInt1, int paramInt2, ConfigurationService.Config paramConfig, String arg4)
  {
    int i = b(paramInt1, Long.valueOf(???).longValue());
    if (QLog.isColorLevel()) {
      QLog.d("QConfigManager", 2, "[OnReceive] t=" + paramInt1 + " old=" + i + ", new=" + paramInt2);
    }
    if (i == paramInt2) {}
    aokh localaokh;
    do
    {
      do
      {
        return;
        if (!aokp.a().a(paramInt1, paramInt2)) {
          break;
        }
      } while (!QLog.isColorLevel());
      QLog.d("QConfigManager", 2, "conf has been deleted by safemode, type=" + paramInt1 + ", version=" + paramInt2);
      return;
      localaokh = c(paramInt1);
      if (localaokh != null) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.d("QConfigManager", 2, "Has not define an process," + paramInt1);
    return;
    if (QLog.isColorLevel()) {
      QLog.d("QConfigManager", 2, "save config, ov=" + i + " to nv=" + paramInt2 + ", type=" + paramInt1);
    }
    long l = a(???, localaokh.a());
    String str = a(paramInt1, l, paramInt2);
    synchronized (jdField_a_of_type_ArrayOfJavaLangObject[(paramInt1 % 5)])
    {
      if ((localaokh.b()) && (!a(str)))
      {
        if (QLog.isColorLevel()) {
          QLog.d("QConfigManager", 2, "create conf dir failed, dir=" + str);
        }
        return;
      }
    }
    if (localaokh.c()) {
      a(localaokh, paramConfig, l, str, i, paramInt2);
    }
    for (;;)
    {
      aokp.a().a(paramInt1, l, localaokh.b());
      return;
      b(localaokh, paramConfig, l, str, i, paramInt2);
    }
  }
  
  public void a(int paramInt, String paramString)
  {
    aokh localaokh = c(paramInt);
    if (localaokh == null) {
      if (QLog.isColorLevel()) {
        QLog.d("QConfigManager", 2, "noReceive method has not define an process," + paramInt);
      }
    }
    for (;;)
    {
      return;
      try
      {
        localaokh.a();
        b(paramInt, Long.valueOf(paramString).longValue());
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.d("QConfigManager", 2, "noReceive config, type=" + paramInt);
        return;
      }
      catch (Exception paramString)
      {
        for (;;)
        {
          if (QLog.isColorLevel()) {
            QLog.d("QConfigManager", 2, "Handle noReceive operation exception, type=" + paramInt, paramString);
          }
        }
      }
    }
  }
  
  public void a(int[] paramArrayOfInt)
  {
    int j = paramArrayOfInt.length;
    int i = 0;
    while (i < j)
    {
      int k = paramArrayOfInt[i];
      if (!b(k)) {
        a(new IllegalStateException("QConfigManager has not support the config yet, type=" + k));
      }
      i += 1;
    }
    AppRuntime localAppRuntime = MobileQQ.sMobileQQ.waitAppRuntime(null);
    String str = localAppRuntime.getAccount();
    aozj.jdField_a_of_type_JavaLangString = str;
    NewIntent localNewIntent = new NewIntent(BaseApplicationImpl.getApplication(), aozj.class);
    localNewIntent.putExtra("k_cmd_type", paramArrayOfInt);
    localNewIntent.putExtra("key_uin", str);
    localAppRuntime.startServlet(localNewIntent);
  }
  
  public boolean a(int paramInt)
  {
    aokh localaokh = a(paramInt);
    if (localaokh == null) {
      return false;
    }
    return localaokh.c();
  }
  
  public boolean a(QQAppInterface paramQQAppInterface, int paramInt)
  {
    aokh localaokh = a(paramInt);
    if (localaokh == null) {}
    do
    {
      do
      {
        return false;
      } while (!localaokh.d());
      paramQQAppInterface = b(paramQQAppInterface.getLongAccountUin()).getString(String.valueOf(paramInt), "");
    } while (TextUtils.equals(AppSetting.g(), paramQQAppInterface));
    return true;
  }
  
  public int b(int paramInt, long paramLong)
  {
    int i = a().a(paramInt, paramLong);
    aokh localaokh = a(paramInt);
    if ((localaokh != null) && (localaokh.d()) && (i == 0)) {
      b(paramLong).edit().putString(String.valueOf(paramInt), AppSetting.g()).apply();
    }
    return i;
  }
  
  public boolean b(int paramInt)
  {
    boolean bool2 = false;
    int[] arrayOfInt = jdField_a_of_type_ArrayOfInt;
    int j = arrayOfInt.length;
    int i = 0;
    for (;;)
    {
      boolean bool1 = bool2;
      if (i < j)
      {
        if (paramInt == arrayOfInt[i]) {
          bool1 = true;
        }
      }
      else {
        return bool1;
      }
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     aoks
 * JD-Core Version:    0.7.0.1
 */