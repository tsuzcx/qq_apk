import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.config.AppSetting;
import com.tencent.mfsdk.config.QConfigAPMProcessor;
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

public class aran
{
  public static final int[] a;
  private static final Object[] jdField_a_of_type_ArrayOfJavaLangObject = { new Object(), new Object(), new Object(), new Object(), new Object() };
  private final Object jdField_a_of_type_JavaLangObject = new Object();
  private final String jdField_a_of_type_JavaLangString;
  private final Map<Integer, arac> jdField_a_of_type_JavaUtilMap = new ConcurrentHashMap();
  private final Object jdField_b_of_type_JavaLangObject = new Object();
  private final Map<Integer, arao> jdField_b_of_type_JavaUtilMap = new ConcurrentHashMap();
  private final Object jdField_c_of_type_JavaLangObject = new Object();
  private final Map<Long, SharedPreferences> jdField_c_of_type_JavaUtilMap = new HashMap();
  private final Object jdField_d_of_type_JavaLangObject = new Object();
  private final Map<Long, SharedPreferences> jdField_d_of_type_JavaUtilMap = new HashMap();
  private final Map<Long, SharedPreferences> e = new HashMap();
  
  static
  {
    jdField_a_of_type_ArrayOfInt = new int[] { 390, 26, 76, 95, 455, 524, 409, 469, 412, 359, 413, 563, 648, 667, 427, 428, 465, 477, 491, 542, 414, 419, 416, 445, 418, 424, 411, 423, 406, 417, 425, 426, 613, 675, 632, 67, 430, 68, 526, 612, 463, 595, 627, 671, 380, 159, 170, 186, 250, 92, 368, 158, 361, 207, 585, 292, 168, 433, 432, 434, 456, 460, 435, 438, 441, 106, 132, 172, 176, 192, 216, 249, 263, 270, 276, 287, 367, 370, 382, 298, 431, 543, 591, 623, 439, 442, 488, 444, 362, 396, 637, 449, 626, 625, 85, 606, 645, 32, 35, 70, 81, 383, 346, 294, 334, 335, 338, 342, 344, 348, 377, 429, 437, 440, 525, 569, 164, 325, 252, 304, 305, 306, 307, 309, 310, 446, 447, 15, 458, 572, 453, 454, 452, 457, 547, 462, 451, 261, 467, 466, 490, 470, 478, 479, 473, 474, 485, 483, 484, 487, 489, 486, 492, 498, 493, 500, 251, 616, 587, 521, 495, 496, 502, 503, 504, 505, 506, 507, 508, 560, 509, 520, 516, 515, 519, 518, 517, 514, 512, 511, 513, 510, 600, 641, 493, 500, 251, 616, 587, 521, 482, 501, 497, 522, 529, 499, 528, 527, 541, 562, 628, 580, 534, 532, 535, 537, 538, 545, 546, 544, 590, 609, 664, 659, 669, 673, 550, 530, 561, 575, 551, 607, 552, 553, 531, 549, 554, 555, 556, 557, 559, 564, 581, 566, 578, 567, 568, 576, 579, 583, 574, 573, 586, 577, 589, 592, 593, 598, 614, 597, 605, 617, 649, 608, 610, 615, 611, 619, 634, 638, 652, 624, 643, 630, 618, 651, 662, 621, 620, 622, 631, 633, 635, 255, 640, 642, 654, 647, 660, 657, 661, 655, 653, 663, 665, 670, 672, 668 };
  }
  
  public aran()
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
  
  private int a(arac paramarac, int paramInt, long paramLong)
  {
    int i = a(paramLong).getInt(String.valueOf(paramInt), -1);
    paramInt = i;
    if (i == -1) {
      paramInt = paramarac.migrateOldVersion();
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
  
  public static aran a()
  {
    return arap.a;
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
  
  private <T> T a(arac<T> paramarac, int paramInt)
  {
    Object localObject2 = paramarac.migrateOldOrDefaultContent(paramInt);
    Object localObject1 = localObject2;
    if (localObject2 == null) {
      localObject1 = a(paramarac.clazz());
    }
    return localObject1;
  }
  
  private Object a(arac paramarac, long paramLong, int paramInt)
  {
    Object localObject2 = a(paramarac.type());
    if (localObject2 != null)
    {
      int i = paramarac.type();
      int j = a(paramarac, i, paramLong);
      localObject1 = localObject2;
      if (paramarac.isNeedStoreLargeFile())
      {
        String str1 = a(i, paramLong, j);
        String str2 = a(i, paramLong, paramInt);
        localObject1 = localObject2;
        if (!TextUtils.equals(str2, str1)) {
          bhmi.a(str1, str2, false);
        }
      }
    }
    for (Object localObject1 = localObject2;; localObject1 = paramarac.migrateOldOrDefaultContent(0))
    {
      if (QLog.isColorLevel()) {
        QLog.d("QConfigManager", 2, "loadNewConfigFailBackport, version=" + paramInt + ", type" + paramarac.type() + ", conf=" + localObject1);
      }
      return localObject1;
    }
  }
  
  private Object a(arac paramarac, araj[] paramArrayOfaraj, int paramInt)
  {
    try
    {
      Object localObject = paramarac.onParsed(paramArrayOfaraj);
      return localObject;
    }
    catch (Exception localException)
    {
      araq.a().a(paramarac, paramArrayOfaraj, paramInt, localException);
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
    //   20: ldc_w 294
    //   23: invokestatic 100	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   26: aload 8
    //   28: astore 4
    //   30: aload 4
    //   32: areturn
    //   33: aload_1
    //   34: invokevirtual 297	java/io/File:exists	()Z
    //   37: ifeq +93 -> 130
    //   40: aload_1
    //   41: invokevirtual 300	java/io/File:isFile	()Z
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
    //   67: ldc_w 302
    //   70: invokevirtual 77	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   73: aload_1
    //   74: invokevirtual 248	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   77: invokevirtual 85	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   80: invokestatic 100	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   83: aconst_null
    //   84: areturn
    //   85: aload_1
    //   86: invokevirtual 305	java/io/File:canRead	()Z
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
    //   112: ldc_w 307
    //   115: invokevirtual 77	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   118: aload_1
    //   119: invokevirtual 248	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
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
    //   150: ldc_w 309
    //   153: invokevirtual 77	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   156: aload_1
    //   157: invokevirtual 248	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   160: invokevirtual 85	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   163: invokestatic 100	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   166: aconst_null
    //   167: areturn
    //   168: new 311	java/io/FileInputStream
    //   171: dup
    //   172: aload_1
    //   173: invokespecial 314	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   176: astore 4
    //   178: new 316	java/io/InputStreamReader
    //   181: dup
    //   182: aload 4
    //   184: ldc_w 318
    //   187: invokespecial 321	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;Ljava/lang/String;)V
    //   190: astore_3
    //   191: aload_3
    //   192: astore 6
    //   194: aload 4
    //   196: astore 5
    //   198: aload_1
    //   199: invokevirtual 325	java/io/File:length	()J
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
    //   239: invokespecial 328	java/lang/StringBuilder:<init>	(I)V
    //   242: astore 9
    //   244: aload_3
    //   245: astore 6
    //   247: aload 4
    //   249: astore 5
    //   251: aload_3
    //   252: aload 7
    //   254: invokevirtual 332	java/io/InputStreamReader:read	([C)I
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
    //   276: invokevirtual 335	java/lang/StringBuilder:append	([CII)Ljava/lang/StringBuilder;
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
    //   315: ldc_w 337
    //   318: invokevirtual 77	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   321: aload_1
    //   322: invokevirtual 248	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   325: invokevirtual 85	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   328: aload 7
    //   330: invokestatic 288	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   333: aload 4
    //   335: ifnull +8 -> 343
    //   338: aload 4
    //   340: invokevirtual 342	java/io/InputStream:close	()V
    //   343: aload 8
    //   345: astore 4
    //   347: aload_3
    //   348: ifnull -318 -> 30
    //   351: aload_3
    //   352: invokevirtual 343	java/io/InputStreamReader:close	()V
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
    //   384: invokevirtual 342	java/io/InputStream:close	()V
    //   387: aload_1
    //   388: astore 4
    //   390: aload_3
    //   391: ifnull -361 -> 30
    //   394: aload_3
    //   395: invokevirtual 343	java/io/InputStreamReader:close	()V
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
    //   432: invokevirtual 332	java/io/InputStreamReader:read	([C)I
    //   435: invokespecial 346	java/lang/String:<init>	([CII)V
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
    //   460: invokevirtual 342	java/io/InputStream:close	()V
    //   463: aload 6
    //   465: ifnull +8 -> 473
    //   468: aload 6
    //   470: invokevirtual 343	java/io/InputStreamReader:close	()V
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
    //   0	524	0	this	aran
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
  
  private void a(arac paramarac, ConfigurationService.Config paramConfig, long paramLong, String paramString, int paramInt1, int paramInt2)
  {
    int i = paramConfig.msg_content_list.size();
    if (i == 0) {
      paramConfig = paramarac.migrateOldOrDefaultContent(1);
    }
    label312:
    for (;;)
    {
      if (i == 0) {}
      for (boolean bool = true;; bool = false)
      {
        a(paramarac, paramConfig, paramInt2, paramLong, bool);
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
            localObject1 = azet.a(localContent.content.get().toByteArray());
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
                localArrayList.add(new araj(localContent.task_id.get(), (String)localObject1));
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
        Object localObject2 = new araj[localArrayList.size()];
        localArrayList.toArray((Object[])localObject2);
        paramConfig = a(paramarac, (araj[])localObject2, paramInt2);
        if (paramConfig != null)
        {
          a(paramarac, (araj[])localObject2, paramLong, paramString);
          if (!QLog.isColorLevel()) {
            break label312;
          }
          QLog.d("QConfigManager", 2, "handleNewConfig, parse success, size=" + localObject2.length);
          break;
        }
        paramConfig = a(paramarac, paramLong, paramInt2);
        break;
      }
    }
  }
  
  private void a(arac paramarac, Object paramObject, int paramInt, long paramLong, boolean paramBoolean)
  {
    if (paramObject != null)
    {
      a(paramLong).edit().putInt(String.valueOf(paramarac.type()), paramInt).putBoolean(paramarac.type() + "_" + paramInt + "_defualt", paramBoolean).apply();
      this.jdField_b_of_type_JavaUtilMap.put(Integer.valueOf(paramarac.type()), new arao(paramLong, paramInt, paramObject));
      paramarac.onUpdate(paramObject);
    }
  }
  
  private void a(arac paramarac, araj[] paramArrayOfaraj, long paramLong, String paramString)
  {
    int j = 0;
    int i = 0;
    if (paramarac.isNeedStoreLargeFile())
    {
      a(new File(paramString));
      while (i < paramArrayOfaraj.length)
      {
        paramarac = a(paramString, String.valueOf(paramArrayOfaraj[i].jdField_a_of_type_Int));
        if (paramarac != null) {
          a(paramArrayOfaraj[i].jdField_a_of_type_JavaLangString, paramarac);
        }
        i += 1;
      }
    }
    paramString = c(paramLong).edit();
    HashSet localHashSet = new HashSet();
    i = j;
    while (i < paramArrayOfaraj.length)
    {
      localHashSet.add(String.valueOf(paramArrayOfaraj[i].jdField_a_of_type_Int));
      paramString.putString(paramarac.type() + "_" + paramArrayOfaraj[i].jdField_a_of_type_Int, paramArrayOfaraj[i].jdField_a_of_type_JavaLangString);
      i += 1;
    }
    a(paramLong).edit().putStringSet(paramarac.type() + "_ids", localHashSet).apply();
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
    //   13: invokevirtual 297	java/io/File:exists	()Z
    //   16: ifne +11 -> 27
    //   19: aload_2
    //   20: invokevirtual 552	java/io/File:createNewFile	()Z
    //   23: pop
    //   24: iload 5
    //   26: istore_3
    //   27: new 554	java/io/FileOutputStream
    //   30: dup
    //   31: aload_2
    //   32: iconst_0
    //   33: invokespecial 557	java/io/FileOutputStream:<init>	(Ljava/io/File;Z)V
    //   36: astore 7
    //   38: aload 7
    //   40: astore 6
    //   42: aload 6
    //   44: ifnull +17 -> 61
    //   47: aload 6
    //   49: aload_1
    //   50: invokevirtual 560	java/lang/String:getBytes	()[B
    //   53: invokevirtual 564	java/io/FileOutputStream:write	([B)V
    //   56: aload 6
    //   58: invokevirtual 567	java/io/FileOutputStream:flush	()V
    //   61: aload 6
    //   63: ifnull +128 -> 191
    //   66: aload 6
    //   68: invokevirtual 568	java/io/FileOutputStream:close	()V
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
    //   91: ldc_w 570
    //   94: invokevirtual 77	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   97: aload_2
    //   98: invokevirtual 248	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
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
    //   136: ldc_w 572
    //   139: invokevirtual 77	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   142: aload_2
    //   143: invokevirtual 248	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   146: invokevirtual 85	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   149: aload_1
    //   150: invokestatic 288	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   153: iload 4
    //   155: istore_3
    //   156: aload 6
    //   158: ifnull -87 -> 71
    //   161: aload 6
    //   163: invokevirtual 568	java/io/FileOutputStream:close	()V
    //   166: iconst_0
    //   167: ireturn
    //   168: astore_1
    //   169: iconst_0
    //   170: ireturn
    //   171: astore_1
    //   172: aload 6
    //   174: ifnull +8 -> 182
    //   177: aload 6
    //   179: invokevirtual 568	java/io/FileOutputStream:close	()V
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
    //   0	193	0	this	aran
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
  
  private araj[] a(int paramInt, long paramLong)
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
    Object localObject = new araj[arrayOfFile.length];
    paramInt = 0;
    while (paramInt < arrayOfFile.length)
    {
      File localFile = arrayOfFile[paramInt];
      localObject[paramInt] = new araj(a(localFile), a(localFile));
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
  
  private arac b(int paramInt)
  {
    switch (paramInt)
    {
    case 16: 
    case 17: 
    case 18: 
    case 19: 
    case 20: 
    case 21: 
    case 22: 
    case 23: 
    case 24: 
    case 25: 
    case 27: 
    case 28: 
    case 29: 
    case 30: 
    case 31: 
    case 33: 
    case 34: 
    case 36: 
    case 37: 
    case 38: 
    case 39: 
    case 40: 
    case 41: 
    case 42: 
    case 43: 
    case 44: 
    case 45: 
    case 46: 
    case 47: 
    case 48: 
    case 49: 
    case 50: 
    case 51: 
    case 52: 
    case 53: 
    case 54: 
    case 55: 
    case 56: 
    case 57: 
    case 58: 
    case 59: 
    case 60: 
    case 61: 
    case 62: 
    case 63: 
    case 64: 
    case 65: 
    case 66: 
    case 69: 
    case 71: 
    case 72: 
    case 73: 
    case 74: 
    case 75: 
    case 77: 
    case 78: 
    case 79: 
    case 80: 
    case 82: 
    case 83: 
    case 84: 
    case 86: 
    case 87: 
    case 88: 
    case 89: 
    case 90: 
    case 91: 
    case 93: 
    case 94: 
    case 96: 
    case 97: 
    case 98: 
    case 99: 
    case 100: 
    case 101: 
    case 102: 
    case 103: 
    case 104: 
    case 105: 
    case 107: 
    case 108: 
    case 109: 
    case 110: 
    case 111: 
    case 112: 
    case 113: 
    case 114: 
    case 115: 
    case 116: 
    case 117: 
    case 118: 
    case 119: 
    case 120: 
    case 121: 
    case 122: 
    case 123: 
    case 124: 
    case 125: 
    case 126: 
    case 127: 
    case 128: 
    case 129: 
    case 130: 
    case 131: 
    case 133: 
    case 134: 
    case 135: 
    case 136: 
    case 137: 
    case 138: 
    case 139: 
    case 140: 
    case 141: 
    case 142: 
    case 143: 
    case 144: 
    case 145: 
    case 146: 
    case 147: 
    case 148: 
    case 149: 
    case 150: 
    case 151: 
    case 152: 
    case 153: 
    case 154: 
    case 155: 
    case 156: 
    case 157: 
    case 160: 
    case 161: 
    case 162: 
    case 163: 
    case 165: 
    case 166: 
    case 167: 
    case 169: 
    case 171: 
    case 173: 
    case 174: 
    case 175: 
    case 177: 
    case 178: 
    case 179: 
    case 180: 
    case 181: 
    case 182: 
    case 183: 
    case 184: 
    case 185: 
    case 187: 
    case 188: 
    case 190: 
    case 191: 
    case 193: 
    case 194: 
    case 195: 
    case 196: 
    case 197: 
    case 198: 
    case 199: 
    case 200: 
    case 201: 
    case 202: 
    case 203: 
    case 204: 
    case 205: 
    case 206: 
    case 208: 
    case 209: 
    case 210: 
    case 211: 
    case 212: 
    case 213: 
    case 214: 
    case 215: 
    case 217: 
    case 218: 
    case 219: 
    case 220: 
    case 221: 
    case 222: 
    case 223: 
    case 224: 
    case 225: 
    case 226: 
    case 227: 
    case 228: 
    case 229: 
    case 230: 
    case 231: 
    case 232: 
    case 233: 
    case 234: 
    case 235: 
    case 236: 
    case 237: 
    case 238: 
    case 239: 
    case 240: 
    case 241: 
    case 242: 
    case 243: 
    case 244: 
    case 245: 
    case 246: 
    case 247: 
    case 248: 
    case 253: 
    case 254: 
    case 256: 
    case 257: 
    case 258: 
    case 259: 
    case 260: 
    case 262: 
    case 264: 
    case 265: 
    case 266: 
    case 267: 
    case 268: 
    case 269: 
    case 271: 
    case 272: 
    case 273: 
    case 274: 
    case 275: 
    case 277: 
    case 278: 
    case 279: 
    case 280: 
    case 281: 
    case 282: 
    case 283: 
    case 284: 
    case 285: 
    case 286: 
    case 288: 
    case 289: 
    case 290: 
    case 291: 
    case 293: 
    case 295: 
    case 296: 
    case 297: 
    case 299: 
    case 300: 
    case 301: 
    case 302: 
    case 303: 
    case 308: 
    case 311: 
    case 312: 
    case 313: 
    case 314: 
    case 315: 
    case 316: 
    case 317: 
    case 318: 
    case 319: 
    case 320: 
    case 321: 
    case 322: 
    case 323: 
    case 324: 
    case 326: 
    case 327: 
    case 328: 
    case 329: 
    case 330: 
    case 331: 
    case 332: 
    case 333: 
    case 336: 
    case 337: 
    case 339: 
    case 340: 
    case 341: 
    case 343: 
    case 345: 
    case 347: 
    case 349: 
    case 350: 
    case 351: 
    case 352: 
    case 353: 
    case 354: 
    case 355: 
    case 356: 
    case 357: 
    case 358: 
    case 360: 
    case 363: 
    case 364: 
    case 365: 
    case 366: 
    case 369: 
    case 371: 
    case 372: 
    case 373: 
    case 374: 
    case 375: 
    case 376: 
    case 378: 
    case 379: 
    case 381: 
    case 384: 
    case 385: 
    case 386: 
    case 387: 
    case 388: 
    case 389: 
    case 391: 
    case 392: 
    case 393: 
    case 394: 
    case 395: 
    case 397: 
    case 398: 
    case 399: 
    case 400: 
    case 401: 
    case 402: 
    case 403: 
    case 404: 
    case 405: 
    case 407: 
    case 408: 
    case 415: 
    case 420: 
    case 421: 
    case 422: 
    case 436: 
    case 443: 
    case 448: 
    case 450: 
    case 459: 
    case 461: 
    case 464: 
    case 468: 
    case 471: 
    case 472: 
    case 475: 
    case 476: 
    case 480: 
    case 481: 
    case 494: 
    case 523: 
    case 533: 
    case 536: 
    case 539: 
    case 540: 
    case 548: 
    case 558: 
    case 565: 
    case 570: 
    case 571: 
    case 582: 
    case 584: 
    case 588: 
    case 594: 
    case 596: 
    case 599: 
    case 601: 
    case 602: 
    case 603: 
    case 604: 
    case 629: 
    case 636: 
    case 639: 
    case 644: 
    case 646: 
    case 650: 
    case 656: 
    case 658: 
    case 666: 
    case 674: 
    default: 
      return null;
    case 605: 
      return new bfzn();
    case 390: 
      return new arhd();
    case 26: 
      return new arny();
    case 76: 
      return new arnh();
    case 95: 
      return new armn();
    case 189: 
      return new aroe();
    case 409: 
      return new arne();
    case 469: 
      return new arnc();
    case 412: 
      return new armw();
    case 359: 
      return new aror();
    case 465: 
      return new arna();
    case 427: 
      return new armt();
    case 491: 
      return new armo();
    case 413: 
      return new arnq();
    case 563: 
      return new arns();
    case 648: 
      return new arom();
    case 667: 
      return new arnf();
    case 477: 
      return new arop();
    case 411: 
      return new abaf();
    case 414: 
      return new arel();
    case 419: 
      return new arhb();
    case 416: 
      return new aqjy();
    case 445: 
      return new avyi();
    case 418: 
      return new arjj();
    case 424: 
      return new arrx();
    case 410: 
      return new aita();
    case 423: 
      return new arnw();
    case 428: 
      return new armu();
    case 406: 
      return new abap();
    case 417: 
      return new aree();
    case 425: 
      return new arfd();
    case 426: 
      return new arfu();
    case 613: 
      return new arfw();
    case 632: 
      return new arfy();
    case 675: 
      return new arga();
    case 67: 
      return new arbp();
    case 430: 
      return new arbr();
    case 380: 
      return new arcf();
    case 159: 
      return new arce();
    case 170: 
      return new arcb();
    case 186: 
      return new arcc();
    case 250: 
      return new arcd();
    case 292: 
      return new arij();
    case 92: 
      return new arik();
    case 368: 
      return new arim();
    case 158: 
      return new arkc();
    case 361: 
      return new arke();
    case 207: 
      return new arkg();
    case 585: 
      return new arka();
    case 168: 
      return new area();
    case 453: 
      return new ards();
    case 68: 
      return new argr();
    case 526: 
      return new bdhg();
    case 612: 
      return new bdvr();
    case 456: 
      return new arpf();
    case 460: 
      return new arot();
    case 433: 
      return new arox();
    case 432: 
      return new arpa();
    case 434: 
      return new arov();
    case 435: 
      return new arjv();
    case 438: 
      return new ajvd();
    case 441: 
      return new arhv();
    case 631: 
      return new arhx();
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
    case 623: 
      return new lbx(paramInt);
    case 431: 
      return new lbp();
    case 439: 
      return new argx();
    case 442: 
      return new argt();
    case 488: 
      return new argv();
    case 444: 
      return new army();
    case 362: 
      return new arjd();
    case 164: 
      return new avtc();
    case 325: 
      return new bcwq();
    case 396: 
      return new arlj();
    case 637: 
      return new arkq();
    case 85: 
      return new arlm();
    case 81: 
      return new oef();
    case 32: 
      return new oed();
    case 35: 
      return new odz();
    case 70: 
      return new oeb();
    case 383: 
      return new arqb();
    case 346: 
      return new arrg();
    case 294: 
      return new arpv();
    case 334: 
      return new arpr();
    case 335: 
      return new arra();
    case 338: 
      return new arqj();
    case 342: 
      return new arpt();
    case 344: 
      return new arrk();
    case 348: 
      return new arrc();
    case 377: 
      return new arqn();
    case 429: 
      return new arqe();
    case 525: 
      return new arqq();
    case 569: 
      return new arqh();
    case 437: 
      return new arqw();
    case 440: 
      return new arqs();
    case 252: 
      return new ario();
    case 304: 
      return new arhl();
    case 446: 
      return new arfb();
    case 305: 
      return new arhj();
    case 306: 
      return new arhh();
    case 307: 
      return new arhn();
    case 309: 
      return new arhf();
    case 310: 
      return new arhe();
    case 457: 
      return new arba();
    case 547: 
      return new bgkb();
    case 449: 
      return new arly();
    case 626: 
      return new arlf();
    case 625: 
      return new arlh();
    case 645: 
      return new arlw();
    case 447: 
      return new ugi();
    case 458: 
      return new arfm();
    case 572: 
      return new arfo();
    case 15: 
      return new beue();
    case 454: 
      return new awwg();
    case 452: 
      return new ardm();
    case 462: 
      return new arrl();
    case 455: 
      return new arec();
    case 627: 
      return new ardj();
    case 524: 
      return new arfj();
    case 451: 
      return new arqy();
    case 261: 
      return new arpx();
    case 463: 
      return new aban();
    case 595: 
      return new abal();
    case 671: 
      return new bigl();
    case 467: 
      return new argh();
    case 466: 
      return new arge();
    case 490: 
      return new arir();
    case 470: 
      return new akle();
    case 478: 
      return new axlb();
    case 479: 
      return new armh();
    case 473: 
      return new abah();
    case 474: 
      return new abaj();
    case 485: 
      return new bbwv();
    case 483: 
      return new arql();
    case 484: 
      return new arkk();
    case 487: 
      return new arqu();
    case 489: 
      return new arff();
    case 486: 
      return new arpl();
    case 492: 
      return new aren();
    case 498: 
      return new arms();
    case 500: 
      return new arpn();
    case 493: 
      return new arkv();
    case 521: 
      return new arpp();
    case 251: 
      return new argl();
    case 616: 
      return new argn();
    case 587: 
      return new argj();
    case 496: 
      return new azrx();
    case 495: 
      return new azsy();
    case 502: 
      return new azsb();
    case 503: 
      return new azsx();
    case 504: 
      return new azsp();
    case 505: 
      return new azsk();
    case 506: 
      return new azsm();
    case 507: 
      return new azsi();
    case 508: 
      return new azsl();
    case 560: 
      return new azsu();
    case 509: 
      return new azsh();
    case 520: 
      return new azsn();
    case 516: 
      return new azsg();
    case 515: 
      return new azsw();
    case 519: 
      return new azsd();
    case 518: 
      return new azsj();
    case 517: 
      return new azsv();
    case 514: 
      return new azse();
    case 512: 
      return new azsq();
    case 511: 
      return new azso();
    case 513: 
      return new azst();
    case 510: 
      return new azsr();
    case 600: 
      return new azss();
    case 641: 
      return new azsc();
    case 482: 
      return new arrn();
    case 501: 
      return new arrp();
    case 497: 
      return new arki();
    case 522: 
      return new axje();
    case 529: 
      return new arpj();
    case 527: 
      return new armq();
    case 541: 
      return new arml();
    case 562: 
      return new aroa();
    case 628: 
      return new arol();
    case 580: 
      return new arnj();
    case 534: 
      return new arht();
    case 532: 
      return new ataz();
    case 528: 
      return new ardq();
    case 499: 
      return new arjy();
    case 535: 
      return new arjk();
    case 551: 
      return new arja();
    case 607: 
      return new arjf();
    case 542: 
      return new armp();
    case 537: 
      return new arbm();
    case 538: 
      return new ariw();
    case 545: 
      return new arhy();
    case 546: 
      return new arih();
    case 544: 
      return new bggu();
    case 550: 
      return new arjt();
    case 530: 
      return new argo();
    case 561: 
      return new ardx();
    case 552: 
      return new ares();
    case 553: 
      return new arjo();
    case 578: 
      return new arfs();
    case 652: 
      return new arfq();
    case 643: 
      return new bpdo();
    case 531: 
      return new ardn();
    case 549: 
      return new aqrc();
    case 554: 
      return new arlu();
    case 555: 
      return new arls();
    case 556: 
      return new arlo();
    case 557: 
      return new arlq();
    case 559: 
      return new arri();
    case 564: 
      return new aris();
    case 581: 
      return new arex();
    case 566: 
      return new arde();
    case 575: 
      return new arev();
    case 567: 
      return new ardg();
    case 568: 
      return new argy();
    case 576: 
      return new aqwa();
    case 579: 
      return new aqwc();
    case 583: 
      return new arkt();
    case 574: 
      return new arbg();
    case 573: 
      return new arrr();
    case 586: 
      return new aqsc();
    case 577: 
      return new bdlb();
    case 589: 
      return new arpb();
    case 592: 
      return new agsb();
    case 593: 
      return new ofw();
    case 617: 
      return new avlr();
    case 649: 
      return new arbf();
    case 590: 
      return new bgkp();
    case 673: 
      return new bfme();
    case 609: 
      return new agmm();
    case 664: 
      return new bffa();
    case 659: 
      return new bgnk();
    case 669: 
      return new bggx();
    case 597: 
      return new arbs();
    case 598: 
      return new arer();
    case 614: 
      return new arep();
    case 606: 
      return new arme();
    case 608: 
      return new arei();
    case 610: 
      return new bduw();
    case 615: 
      return new bdva();
    case 611: 
      return new azta();
    case 619: 
      return new bdvg();
    case 624: 
      return new amme();
    case 638: 
      return new amlx();
    case 634: 
      return new arbd();
    case 630: 
      return new arif();
    case 618: 
      return new arnl();
    case 651: 
      return new arnu();
    case 662: 
      return new aroc();
    case 621: 
      return new ariy();
    case 255: 
      return new QConfigAPMProcessor();
    case 620: 
      return new ardt();
    case 622: 
      return new ardv();
    case 635: 
      return new arjr();
    case 633: 
      return new arjp();
    case 640: 
      return new arfh();
    case 642: 
      return new ardc();
    case 654: 
      return bbpe.a();
    case 647: 
      return new ariu();
    case 657: 
      return new aitt();
    case 661: 
      return new arez();
    case 655: 
      return new arbk();
    case 660: 
      return new areg();
    case 653: 
      return new arko();
    case 663: 
      return new arld();
    case 665: 
      return new arnn();
    case 672: 
      return new arbi();
    case 670: 
      return new aqox();
    }
    return new bfuk();
  }
  
  private void b(arac paramarac, ConfigurationService.Config paramConfig, long paramLong, String paramString, int paramInt1, int paramInt2)
  {
    if (paramConfig.content_list.isEmpty()) {
      paramString = paramarac.migrateOldOrDefaultContent(1);
    }
    for (;;)
    {
      a(paramarac, paramString, paramInt2, paramLong, paramConfig.content_list.isEmpty());
      return;
      int i = paramConfig.content_list.size();
      araj[] arrayOfaraj = new araj[i];
      paramInt1 = 0;
      while (paramInt1 < i)
      {
        arrayOfaraj[paramInt1] = new araj(paramInt1, (String)paramConfig.content_list.get(paramInt1));
        paramInt1 += 1;
      }
      Object localObject = a(paramarac, arrayOfaraj, paramInt2);
      if (localObject != null)
      {
        a(paramarac, arrayOfaraj, paramLong, paramString);
        if (QLog.isColorLevel())
        {
          QLog.d("QConfigManager", 2, "handleOldConfig, parse success, size=" + i);
          paramString = localObject;
        }
      }
      else
      {
        paramString = a(paramarac, paramLong, paramInt2);
        continue;
      }
      paramString = localObject;
    }
  }
  
  private araj[] b(int paramInt, long paramLong)
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
    localObject1 = new araj[((Set)localObject2).size()];
    localObject2 = ((Set)localObject2).iterator();
    int i = 0;
    while (((Iterator)localObject2).hasNext())
    {
      String str = (String)((Iterator)localObject2).next();
      localObject1[i] = new araj(Integer.valueOf(str).intValue(), localSharedPreferences.getString(paramInt + "_" + str, null));
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
  
  private arac c(int paramInt)
  {
    arac localarac = a(paramInt);
    if (localarac == null) {}
    return localarac;
  }
  
  public int a(int paramInt, long paramLong)
  {
    arac localarac = a(paramInt);
    if (localarac == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("QConfigManager", 2, "getConfVersion, process is null, type=" + paramInt);
      }
      return -1;
    }
    return a(localarac, paramInt, paramLong);
  }
  
  public int a(int paramInt, String paramString)
  {
    arac localarac = a(paramInt);
    if (localarac == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("QConfigManager", 2, "getConfVersion, process is null, type=" + paramInt);
      }
      return -1;
    }
    return a(localarac, paramInt, a(paramString, localarac.isAccountRelated()));
  }
  
  public arac a(int paramInt)
  {
    Object localObject1 = (arac)this.jdField_a_of_type_JavaUtilMap.get(Integer.valueOf(paramInt));
    if (localObject1 == null) {
      synchronized (this.jdField_a_of_type_JavaLangObject)
      {
        arac localarac2 = (arac)this.jdField_a_of_type_JavaUtilMap.get(Integer.valueOf(paramInt));
        localObject1 = localarac2;
        if (localarac2 == null)
        {
          localarac2 = b(paramInt);
          localObject1 = localarac2;
          if (localarac2 != null)
          {
            this.jdField_a_of_type_JavaUtilMap.put(Integer.valueOf(paramInt), localarac2);
            localObject1 = localarac2;
          }
        }
        return localObject1;
      }
    }
    return localarac1;
  }
  
  public <T> T a(int paramInt)
  {
    arac localarac = c(paramInt);
    if (localarac == null) {
      return null;
    }
    Object localObject1;
    if (localarac.isAccountRelated())
    {
      localObject1 = MobileQQ.sMobileQQ.getFirstSimpleAccount();
      if (localObject1 == null) {}
    }
    int i;
    for (long l = a(((SimpleAccount)localObject1).getUin(), localarac.isAccountRelated());; l = 0L)
    {
      localObject1 = a(l);
      i = ((SharedPreferences)localObject1).getInt(String.valueOf(paramInt), -1);
      if (i != -1) {
        break;
      }
      return a(localarac, 0);
      if (QLog.isColorLevel()) {
        QLog.d("QConfigManager", 2, "Can not get an runtime.May be in a process of none appRuntime.");
      }
      return a(localarac, 1);
    }
    ??? = (arao)this.jdField_b_of_type_JavaUtilMap.get(Integer.valueOf(paramInt));
    if ((??? != null) && (((arao)???).jdField_a_of_type_Int == i) && (((arao)???).jdField_a_of_type_Long == l) && (((arao)???).jdField_a_of_type_JavaLangObject != null)) {
      return ((arao)???).jdField_a_of_type_JavaLangObject;
    }
    if (((SharedPreferences)localObject1).getBoolean(localarac.type() + "_" + i + "_defualt", false)) {
      return a(localarac, 0);
    }
    Object localObject3;
    for (;;)
    {
      synchronized (jdField_a_of_type_ArrayOfJavaLangObject[(paramInt % 5)])
      {
        if (localarac.isNeedStoreLargeFile())
        {
          localObject1 = a(paramInt, l);
          if (localObject1 != null) {
            break;
          }
          localObject1 = a(localarac.clazz());
          return localObject1;
        }
      }
      localObject3 = b(paramInt, l);
    }
    try
    {
      Object localObject5 = localarac.onParsed((araj[])localObject3);
      this.jdField_b_of_type_JavaUtilMap.put(Integer.valueOf(paramInt), new arao(l, i, localObject5));
      return localObject5;
    }
    catch (Exception localException)
    {
      araq.a().a(localarac, (araj[])localObject3, i, localException);
      localObject3 = a(localarac.clazz());
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
      if (((arac)localObject).isAccountRelated())
      {
        AppRuntime localAppRuntime = MobileQQ.sMobileQQ.waitAppRuntime(null);
        l1 = l2;
        if (localAppRuntime != null) {
          l1 = a(localAppRuntime.getAccount(), ((arac)localObject).isAccountRelated());
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
    arac localarac;
    do
    {
      do
      {
        return;
        if (!arak.a().a(paramInt1, paramInt2)) {
          break;
        }
      } while (!QLog.isColorLevel());
      QLog.d("QConfigManager", 2, "conf has been deleted by safemode, type=" + paramInt1 + ", version=" + paramInt2);
      return;
      localarac = c(paramInt1);
      if (localarac != null) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.d("QConfigManager", 2, "Has not define an process," + paramInt1);
    return;
    if (QLog.isColorLevel()) {
      QLog.d("QConfigManager", 2, "save config, ov=" + i + " to nv=" + paramInt2 + ", type=" + paramInt1);
    }
    long l = a(???, localarac.isAccountRelated());
    String str = a(paramInt1, l, paramInt2);
    synchronized (jdField_a_of_type_ArrayOfJavaLangObject[(paramInt1 % 5)])
    {
      if ((localarac.isNeedStoreLargeFile()) && (!a(str)))
      {
        if (QLog.isColorLevel()) {
          QLog.d("QConfigManager", 2, "create conf dir failed, dir=" + str);
        }
        return;
      }
    }
    if (localarac.isNeedCompressed()) {
      a(localarac, paramConfig, l, str, i, paramInt2);
    }
    for (;;)
    {
      arak.a().a(paramInt1, l, localarac.isNeedStoreLargeFile());
      return;
      b(localarac, paramConfig, l, str, i, paramInt2);
    }
  }
  
  public void a(int paramInt, String paramString)
  {
    arac localarac = c(paramInt);
    if (localarac == null) {
      if (QLog.isColorLevel()) {
        QLog.d("QConfigManager", 2, "noReceive method has not define an process," + paramInt);
      }
    }
    for (;;)
    {
      return;
      try
      {
        localarac.onReqNoReceive();
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
    arry.jdField_a_of_type_JavaLangString = str;
    NewIntent localNewIntent = new NewIntent(BaseApplicationImpl.getApplication(), arry.class);
    localNewIntent.putExtra("k_cmd_type", paramArrayOfInt);
    localNewIntent.putExtra("key_uin", str);
    localAppRuntime.startServlet(localNewIntent);
  }
  
  public boolean a(int paramInt)
  {
    arac localarac = a(paramInt);
    if (localarac == null) {
      return false;
    }
    return localarac.isNeedCompressed();
  }
  
  public boolean a(QQAppInterface paramQQAppInterface, int paramInt)
  {
    arac localarac = a(paramInt);
    if (localarac == null) {}
    do
    {
      do
      {
        return false;
      } while (!localarac.isNeedUpgradeReset());
      paramQQAppInterface = b(paramQQAppInterface.getLongAccountUin()).getString(String.valueOf(paramInt), "");
    } while (TextUtils.equals(AppSetting.g(), paramQQAppInterface));
    return true;
  }
  
  public int b(int paramInt, long paramLong)
  {
    int i = a().a(paramInt, paramLong);
    arac localarac = a(paramInt);
    if ((localarac != null) && (localarac.isNeedUpgradeReset()) && (i == 0)) {
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
 * Qualified Name:     aran
 * JD-Core Version:    0.7.0.1
 */