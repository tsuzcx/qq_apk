import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Handler;
import android.text.TextUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.ark.ArkAiDictUpdateMgr.1;
import com.tencent.mobileqq.ark.ArkAiDictUpdateMgr.8;
import com.tencent.mobileqq.ark.ArkAppCenter;
import com.tencent.mobileqq.ark.ArkRecommendLogic;
import com.tencent.mobileqq.config.QStorageInstantiateException;
import com.tencent.mobileqq.msf.sdk.AppNetConnInfo;
import com.tencent.qphone.base.util.BaseApplication;
import java.io.File;
import java.security.MessageDigest;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map;

public class anmm
{
  private static final char[] jdField_a_of_type_ArrayOfChar = { 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 65, 66, 67, 68, 69, 70 };
  private java.lang.ref.WeakReference<QQAppInterface> jdField_a_of_type_JavaLangRefWeakReference;
  private volatile boolean jdField_a_of_type_Boolean;
  private volatile boolean b;
  
  anmm(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_JavaLangRefWeakReference = new mqq.util.WeakReference(paramQQAppInterface);
  }
  
  private static int a()
  {
    Date localDate = new Date();
    return Integer.parseInt(String.format(Locale.CHINA, "%04d%02d%02d%02d", new Object[] { Integer.valueOf(localDate.getYear() + 1900), Integer.valueOf(localDate.getMonth() + 1), Integer.valueOf(localDate.getDate()), Integer.valueOf(localDate.getHours()) }));
  }
  
  public static String a()
  {
    Object localObject1 = c();
    if (localObject1 == null) {
      return null;
    }
    Iterator localIterator = ((aomj)localObject1).a.iterator();
    while (localIterator.hasNext())
    {
      Object localObject2 = (aomt)localIterator.next();
      if (localObject2 != null)
      {
        aoms localaoms = ((aomt)localObject2).jdField_a_of_type_Aoms;
        if (localaoms != null)
        {
          localObject2 = ((aomt)localObject2).jdField_a_of_type_Aomv;
          if ((localObject2 != null) && (a(localaoms)))
          {
            localObject2 = b((aomv)localObject2);
            if (localObject2 != null)
            {
              ArkAppCenter.c("ArkApp.Dict.Update", String.format("getEffectDictIdentifier, use condition dict, dict-id=%s, condition=%s", new Object[] { localObject2, localaoms.toString() }));
              return localObject2;
            }
          }
        }
      }
    }
    localObject1 = b((aomv)localObject1);
    ArkAppCenter.c("ArkApp.Dict.Update", String.format("getEffectDictIdentifier, use base dict, dict-id=%s", new Object[] { localObject1 }));
    return localObject1;
  }
  
  private static String a(String paramString)
  {
    return anmj.a(paramString) + "/WordData";
  }
  
  private static String a(byte[] paramArrayOfByte)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    if ((paramArrayOfByte != null) && (paramArrayOfByte.length > 0))
    {
      int j = paramArrayOfByte.length;
      int i = 0;
      while (i < j)
      {
        int k = paramArrayOfByte[i];
        localStringBuilder.append(jdField_a_of_type_ArrayOfChar[(k >> 4 & 0xF)]);
        localStringBuilder.append(jdField_a_of_type_ArrayOfChar[(k & 0xF)]);
        i += 1;
      }
    }
    return localStringBuilder.toString();
  }
  
  private static Map<String, anmw> a(aomv paramaomv)
  {
    if (paramaomv == null) {
      return new HashMap();
    }
    Object localObject = paramaomv.jdField_b_of_type_JavaUtilArrayList;
    if (localObject == null)
    {
      ArkAppCenter.c("ArkApp.Dict.Update", "getDictInfoFromConfig, 'word_dict_list' field not found");
      return new HashMap();
    }
    paramaomv = new HashMap();
    localObject = ((ArrayList)localObject).iterator();
    while (((Iterator)localObject).hasNext())
    {
      anmw localanmw = (anmw)((Iterator)localObject).next();
      if (localanmw != null) {
        paramaomv.put(localanmw.a, localanmw);
      }
    }
    return paramaomv;
  }
  
  private void a(aomv paramaomv1, aomv paramaomv2, anmy paramanmy)
  {
    if (paramaomv2 == null)
    {
      ArkAppCenter.c("ArkApp.Dict.Update", "updateWordDict, remote dict config is empty");
      paramanmy.a(false);
    }
    for (;;)
    {
      return;
      if (!b(paramaomv2))
      {
        ArkAppCenter.c("ArkApp.Dict.Update", "updateWordDict, canUpdateDictAtCurrentNetType is false");
        paramanmy.a(false);
        return;
      }
      String str1 = b(paramaomv2);
      if (TextUtils.isEmpty(str1))
      {
        ArkAppCenter.c("ArkApp.Dict.Update", "updateWordDict, empty new dict id");
        paramanmy.a(false);
        return;
      }
      String str2 = b(str1);
      if (TextUtils.isEmpty(str2))
      {
        ArkAppCenter.c("ArkApp.Dict.Update", String.format("updateWordDict, fail to create new dict dir, id=%s", new Object[] { str1 }));
        paramanmy.a(false);
        return;
      }
      Object localObject = a(paramaomv2);
      if ((localObject == null) || (((Map)localObject).size() == 0))
      {
        ArkAppCenter.c("ArkApp.Dict.Update", "updateWordDict, new dict list is empty");
        paramanmy.a(true);
        return;
      }
      paramaomv2 = b(paramaomv1);
      paramaomv1 = a(paramaomv1);
      anna localanna = new anna(null);
      localanna.jdField_a_of_type_Int = ((Map)localObject).size();
      localanna.jdField_a_of_type_Boolean = true;
      localObject = ((Map)localObject).values().iterator();
      while (((Iterator)localObject).hasNext())
      {
        anmw localanmw = (anmw)((Iterator)localObject).next();
        a(str2, paramaomv2, (anmw)paramaomv1.get(localanmw.a), localanmw, new anmo(this, localanna, localanmw, str2, paramanmy, str1));
      }
    }
  }
  
  private void a(String paramString, anmw paramanmw, anmy paramanmy)
  {
    a(paramanmw.a, paramanmw.jdField_b_of_type_JavaLangString, new anmt(this, paramanmw, paramString, paramanmy));
  }
  
  private void a(String paramString1, String paramString2, anmw paramanmw1, anmw paramanmw2, anmy paramanmy)
  {
    boolean bool = false;
    if (!a(paramString2, paramanmw1)) {
      paramanmw1 = null;
    }
    for (;;)
    {
      if (paramanmw1 == null)
      {
        ArkAppCenter.c("ArkApp.Dict.Update", String.format("updateDict, local not exists, full update, name=%s", new Object[] { paramanmw2.a }));
        a(paramString1, paramanmw2, new anmp(this, paramanmw2, paramanmy));
        return;
      }
      if (paramanmw1.d.equals(paramanmw2.d))
      {
        ArkAppCenter.c("ArkApp.Dict.Update", String.format("updateDict, file not change, copy from origin, name=%s", new Object[] { paramanmw2.a }));
        paramString2 = b(paramString2, paramanmw1.a);
        paramString1 = String.format("%s/%s", new Object[] { paramString1, paramanmw2.a });
        if (bdhb.d(paramString2, paramString1)) {
          break label281;
        }
        ArkAppCenter.c("ArkApp.Dict.Update", String.format("updateDict, copy file fail, %s->%s", new Object[] { paramString2, paramString1 }));
      }
      for (;;)
      {
        paramanmy.a(bool);
        return;
        if ((paramanmw2.b()) && (paramanmw1.d.equals(paramanmw2.g)))
        {
          ArkAppCenter.c("ArkApp.Dict.Update", String.format("updateDict, incremental update, name=%s", new Object[] { paramanmw2.a }));
          b(paramString1, paramString2, paramanmw1, paramanmw2, new anmq(this, paramanmw2, paramanmy, paramString1));
          return;
        }
        ArkAppCenter.c("ArkApp.Dict.Update", String.format("updateDict, full update, name=%s", new Object[] { paramanmw2.a }));
        a(paramString1, paramanmw2, new anms(this, paramanmy));
        return;
        label281:
        bool = true;
      }
    }
  }
  
  private void a(String paramString1, String paramString2, anmx paramanmx)
  {
    anmz localanmz = new anmz(null);
    QQAppInterface localQQAppInterface = (QQAppInterface)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    if (localQQAppInterface == null)
    {
      ArkAppCenter.c("ArkApp.Dict.Update", "downloadDictFile, qq app interface is null, return from download");
      return;
    }
    bbaa localbbaa = (bbaa)localQQAppInterface.getManager(193);
    localanmz.jdField_a_of_type_JavaLangRefWeakReference = new java.lang.ref.WeakReference(localbbaa);
    paramanmx = new ArkAiDictUpdateMgr.8(this, paramString2, localanmz, paramanmx);
    if (localQQAppInterface == null)
    {
      ArkAppCenter.c("ArkApp.Dict.Update", "downloadDictFile, qq app interface is null, return");
      return;
    }
    localanmz.jdField_a_of_type_Boolean = localbbaa.a();
    if (localanmz.jdField_a_of_type_Boolean)
    {
      localbbaa.a(10022, "prd", paramString1, 0, paramString2, "", 1, 0, false, new bbab(localQQAppInterface, paramString1, paramanmx, 10000L));
      return;
    }
    paramanmx.run();
    ArkAppCenter.c("ArkApp.Dict.Update", String.format("downloadDictFile, not use pre-download, name=%s, URL=%s.", new Object[] { paramString1, paramString2 }));
  }
  
  private static boolean a(aoms paramaoms)
  {
    if (paramaoms == null) {}
    for (;;)
    {
      return false;
      paramaoms = paramaoms.a;
      String[] arrayOfString = paramaoms.split("-");
      if (arrayOfString.length == 2) {
        try
        {
          int i = Integer.parseInt(arrayOfString[0]);
          int j = Integer.parseInt(arrayOfString[1]);
          int k = a();
          if ((i <= k) && (k <= j)) {
            return true;
          }
        }
        catch (NumberFormatException localNumberFormatException)
        {
          ArkAppCenter.c("ArkApp.Dict.Update", String.format(Locale.CHINA, "isDictConditionEffect, invalid date, date=%s", new Object[] { paramaoms }));
        }
      }
    }
    return false;
  }
  
  private boolean a(aomv paramaomv)
  {
    if (paramaomv == null)
    {
      ArkAppCenter.c("ArkApp.Dict.Update", "checkLocalDictIntegrity, config is empty, return");
      return false;
    }
    String str = b(paramaomv);
    paramaomv = a(paramaomv);
    if (paramaomv == null)
    {
      ArkAppCenter.c("ArkApp.Dict.Update", "checkLocalDictIntegrity, local dict list is empty");
      return true;
    }
    Iterator localIterator = paramaomv.values().iterator();
    do
    {
      if (!localIterator.hasNext()) {
        break;
      }
    } while (a(str, (anmw)localIterator.next()));
    for (int i = 1;; i = 0)
    {
      if (i == 0)
      {
        ArkAppCenter.c("ArkApp.Dict.Update", String.format("checkLocalDictIntegrity, all files check ok, no update, dict-id=%s", new Object[] { str }));
        return true;
      }
      ArkAppCenter.c("ArkApp.Dict.Update", String.format(Locale.CHINA, "checkLocalDictIntegrity, %d of %d files need update", new Object[] { Integer.valueOf(i), Integer.valueOf(paramaomv.size()) }));
      return false;
    }
  }
  
  private static boolean a(String paramString, anmw paramanmw)
  {
    if (paramanmw == null) {}
    while (!b(b(paramString, paramanmw.a), paramanmw.d)) {
      return false;
    }
    return true;
  }
  
  /* Error */
  public static boolean a(byte[] paramArrayOfByte, String paramString)
  {
    // Byte code:
    //   0: iconst_1
    //   1: istore_2
    //   2: aload_0
    //   3: ifnull +10 -> 13
    //   6: aload_1
    //   7: invokestatic 220	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   10: ifeq +7 -> 17
    //   13: iconst_0
    //   14: istore_2
    //   15: iload_2
    //   16: ireturn
    //   17: new 410	java/io/FileOutputStream
    //   20: dup
    //   21: aload_1
    //   22: invokespecial 413	java/io/FileOutputStream:<init>	(Ljava/lang/String;)V
    //   25: astore 4
    //   27: aload 4
    //   29: astore_3
    //   30: aload 4
    //   32: aload_0
    //   33: invokevirtual 417	java/io/FileOutputStream:write	([B)V
    //   36: aload 4
    //   38: ifnull -23 -> 15
    //   41: aload 4
    //   43: invokevirtual 420	java/io/FileOutputStream:close	()V
    //   46: iconst_1
    //   47: ireturn
    //   48: astore_0
    //   49: ldc 127
    //   51: getstatic 52	java/util/Locale:CHINA	Ljava/util/Locale;
    //   54: ldc_w 422
    //   57: iconst_2
    //   58: anewarray 4	java/lang/Object
    //   61: dup
    //   62: iconst_0
    //   63: aload_0
    //   64: invokevirtual 425	java/io/IOException:getMessage	()Ljava/lang/String;
    //   67: aastore
    //   68: dup
    //   69: iconst_1
    //   70: aload_1
    //   71: aastore
    //   72: invokestatic 78	java/lang/String:format	(Ljava/util/Locale;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   75: invokestatic 140	com/tencent/mobileqq/ark/ArkAppCenter:c	(Ljava/lang/String;Ljava/lang/String;)V
    //   78: iconst_1
    //   79: ireturn
    //   80: astore 5
    //   82: aconst_null
    //   83: astore 4
    //   85: aload 4
    //   87: astore_3
    //   88: ldc 127
    //   90: getstatic 52	java/util/Locale:CHINA	Ljava/util/Locale;
    //   93: ldc_w 427
    //   96: iconst_3
    //   97: anewarray 4	java/lang/Object
    //   100: dup
    //   101: iconst_0
    //   102: aload 5
    //   104: invokevirtual 425	java/io/IOException:getMessage	()Ljava/lang/String;
    //   107: aastore
    //   108: dup
    //   109: iconst_1
    //   110: aload_0
    //   111: arraylength
    //   112: invokestatic 63	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   115: aastore
    //   116: dup
    //   117: iconst_2
    //   118: aload_1
    //   119: aastore
    //   120: invokestatic 78	java/lang/String:format	(Ljava/util/Locale;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   123: invokestatic 140	com/tencent/mobileqq/ark/ArkAppCenter:c	(Ljava/lang/String;Ljava/lang/String;)V
    //   126: aload 4
    //   128: ifnull +8 -> 136
    //   131: aload 4
    //   133: invokevirtual 420	java/io/FileOutputStream:close	()V
    //   136: iconst_0
    //   137: ireturn
    //   138: astore_0
    //   139: ldc 127
    //   141: getstatic 52	java/util/Locale:CHINA	Ljava/util/Locale;
    //   144: ldc_w 422
    //   147: iconst_2
    //   148: anewarray 4	java/lang/Object
    //   151: dup
    //   152: iconst_0
    //   153: aload_0
    //   154: invokevirtual 425	java/io/IOException:getMessage	()Ljava/lang/String;
    //   157: aastore
    //   158: dup
    //   159: iconst_1
    //   160: aload_1
    //   161: aastore
    //   162: invokestatic 78	java/lang/String:format	(Ljava/util/Locale;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   165: invokestatic 140	com/tencent/mobileqq/ark/ArkAppCenter:c	(Ljava/lang/String;Ljava/lang/String;)V
    //   168: goto -32 -> 136
    //   171: astore_0
    //   172: aconst_null
    //   173: astore_3
    //   174: aload_3
    //   175: ifnull +7 -> 182
    //   178: aload_3
    //   179: invokevirtual 420	java/io/FileOutputStream:close	()V
    //   182: aload_0
    //   183: athrow
    //   184: astore_3
    //   185: ldc 127
    //   187: getstatic 52	java/util/Locale:CHINA	Ljava/util/Locale;
    //   190: ldc_w 422
    //   193: iconst_2
    //   194: anewarray 4	java/lang/Object
    //   197: dup
    //   198: iconst_0
    //   199: aload_3
    //   200: invokevirtual 425	java/io/IOException:getMessage	()Ljava/lang/String;
    //   203: aastore
    //   204: dup
    //   205: iconst_1
    //   206: aload_1
    //   207: aastore
    //   208: invokestatic 78	java/lang/String:format	(Ljava/util/Locale;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   211: invokestatic 140	com/tencent/mobileqq/ark/ArkAppCenter:c	(Ljava/lang/String;Ljava/lang/String;)V
    //   214: goto -32 -> 182
    //   217: astore_0
    //   218: goto -44 -> 174
    //   221: astore 5
    //   223: goto -138 -> 85
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	226	0	paramArrayOfByte	byte[]
    //   0	226	1	paramString	String
    //   1	15	2	bool	boolean
    //   29	150	3	localFileOutputStream1	java.io.FileOutputStream
    //   184	16	3	localIOException1	java.io.IOException
    //   25	107	4	localFileOutputStream2	java.io.FileOutputStream
    //   80	23	5	localIOException2	java.io.IOException
    //   221	1	5	localIOException3	java.io.IOException
    // Exception table:
    //   from	to	target	type
    //   41	46	48	java/io/IOException
    //   17	27	80	java/io/IOException
    //   131	136	138	java/io/IOException
    //   17	27	171	finally
    //   178	182	184	java/io/IOException
    //   30	36	217	finally
    //   88	126	217	finally
    //   30	36	221	java/io/IOException
  }
  
  private static String b(aomv paramaomv)
  {
    if (paramaomv == null) {}
    String str;
    do
    {
      return null;
      str = paramaomv.c;
      paramaomv = paramaomv.jdField_b_of_type_JavaLangString;
    } while ((TextUtils.isEmpty(str)) || (TextUtils.isEmpty(paramaomv)));
    return String.format("%s-%s", new Object[] { str, paramaomv });
  }
  
  private static String b(String paramString)
  {
    String str = a(String.format(Locale.CHINA, "%s%s-%d", new Object[] { "tmp-", paramString, Long.valueOf(System.currentTimeMillis()) }));
    File localFile = new File(str);
    localFile.mkdirs();
    paramString = str;
    if (!localFile.isDirectory())
    {
      ArkAppCenter.c("ArkApp.Dict.Update", String.format("getTmpWordDataDirectory, fail to create tmp word data directory, dir=%s", new Object[] { str }));
      paramString = null;
    }
    return paramString;
  }
  
  private static String b(String paramString1, String paramString2)
  {
    return String.format("%s/%s", new Object[] { a(paramString1), paramString2 });
  }
  
  private static Map<String, aomv> b(aomj paramaomj)
  {
    HashMap localHashMap = new HashMap();
    if (paramaomj == null)
    {
      ArkAppCenter.c("ArkApp.Dict.Update", "getDictGroupList,aIDictConfig is null");
      return localHashMap;
    }
    Object localObject1 = b(paramaomj);
    if (localObject1 != null) {
      localHashMap.put(localObject1, paramaomj);
    }
    paramaomj = paramaomj.a.iterator();
    while (paramaomj.hasNext())
    {
      Object localObject2 = (aomt)paramaomj.next();
      if (localObject2 != null)
      {
        localObject1 = ((aomt)localObject2).jdField_a_of_type_Aoms;
        localObject2 = ((aomt)localObject2).jdField_a_of_type_Aomv;
        if ((localObject1 != null) && (localObject2 != null))
        {
          localObject1 = b((aomv)localObject2);
          if (localObject1 != null) {
            localHashMap.put(localObject1, localObject2);
          }
        }
      }
    }
    return localHashMap;
  }
  
  private void b(String paramString1, String paramString2, anmw paramanmw1, anmw paramanmw2, anmy paramanmy)
  {
    a(paramanmw2.a, paramanmw2.e, new anmu(this, paramanmw2, paramString2, paramanmw1, paramString1, paramanmy));
  }
  
  private static boolean b(aomv paramaomv)
  {
    if (paramaomv == null) {
      return false;
    }
    paramaomv = paramaomv.e;
    if ((TextUtils.isEmpty(paramaomv)) || (paramaomv.equalsIgnoreCase("wifi")))
    {
      if ((AppNetConnInfo.isNetSupport()) && (AppNetConnInfo.isWifiConn()))
      {
        ArkAppCenter.c("ArkApp.Dict.Update", String.format("getNetType, invalid dict info, netType=%s", new Object[] { paramaomv }));
        return true;
      }
      ArkAppCenter.c("ArkApp.Dict.Update", String.format("getNetType, not judge net Type.", new Object[0]));
      return false;
    }
    ArkAppCenter.c("ArkApp.Dict.Update", String.format("getNetType, netType in not WIFI.", new Object[0]));
    return true;
  }
  
  /* Error */
  private static boolean b(String paramString1, String paramString2)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokestatic 220	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   4: ifne +10 -> 14
    //   7: aload_1
    //   8: invokestatic 220	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   11: ifeq +5 -> 16
    //   14: iconst_0
    //   15: ireturn
    //   16: new 450	java/io/File
    //   19: dup
    //   20: aload_0
    //   21: invokespecial 451	java/io/File:<init>	(Ljava/lang/String;)V
    //   24: astore_0
    //   25: aload_0
    //   26: invokevirtual 498	java/io/File:isFile	()Z
    //   29: ifeq -15 -> 14
    //   32: sipush 4096
    //   35: newarray byte
    //   37: astore 5
    //   39: ldc_w 500
    //   42: invokestatic 506	java/security/MessageDigest:getInstance	(Ljava/lang/String;)Ljava/security/MessageDigest;
    //   45: astore 6
    //   47: new 508	java/io/FileInputStream
    //   50: dup
    //   51: aload_0
    //   52: invokespecial 511	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   55: astore 4
    //   57: aload 4
    //   59: astore_0
    //   60: aload 4
    //   62: aload 5
    //   64: invokevirtual 515	java/io/FileInputStream:read	([B)I
    //   67: istore_2
    //   68: iload_2
    //   69: ifgt +50 -> 119
    //   72: aload 4
    //   74: astore_0
    //   75: aload 6
    //   77: invokevirtual 519	java/security/MessageDigest:digest	()[B
    //   80: invokestatic 521	anmm:a	([B)Ljava/lang/String;
    //   83: aload_1
    //   84: invokevirtual 479	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   87: istore_3
    //   88: iload_3
    //   89: ifeq +15 -> 104
    //   92: aload 4
    //   94: ifnull +8 -> 102
    //   97: aload 4
    //   99: invokevirtual 522	java/io/FileInputStream:close	()V
    //   102: iconst_1
    //   103: ireturn
    //   104: aload 4
    //   106: ifnull -92 -> 14
    //   109: aload 4
    //   111: invokevirtual 522	java/io/FileInputStream:close	()V
    //   114: iconst_0
    //   115: ireturn
    //   116: astore_0
    //   117: iconst_0
    //   118: ireturn
    //   119: aload 4
    //   121: astore_0
    //   122: aload 6
    //   124: aload 5
    //   126: iconst_0
    //   127: iload_2
    //   128: invokevirtual 526	java/security/MessageDigest:update	([BII)V
    //   131: goto -74 -> 57
    //   134: astore_0
    //   135: aload 4
    //   137: astore_1
    //   138: aload_0
    //   139: astore 4
    //   141: aload_1
    //   142: astore_0
    //   143: ldc 127
    //   145: ldc_w 528
    //   148: iconst_1
    //   149: anewarray 4	java/lang/Object
    //   152: dup
    //   153: iconst_0
    //   154: aload 4
    //   156: invokevirtual 529	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   159: aastore
    //   160: invokestatic 135	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   163: invokestatic 140	com/tencent/mobileqq/ark/ArkAppCenter:c	(Ljava/lang/String;Ljava/lang/String;)V
    //   166: aload_1
    //   167: ifnull -153 -> 14
    //   170: aload_1
    //   171: invokevirtual 522	java/io/FileInputStream:close	()V
    //   174: iconst_0
    //   175: ireturn
    //   176: astore_0
    //   177: iconst_0
    //   178: ireturn
    //   179: astore_1
    //   180: aconst_null
    //   181: astore_0
    //   182: aload_0
    //   183: ifnull +7 -> 190
    //   186: aload_0
    //   187: invokevirtual 522	java/io/FileInputStream:close	()V
    //   190: aload_1
    //   191: athrow
    //   192: astore_0
    //   193: goto -91 -> 102
    //   196: astore_0
    //   197: goto -7 -> 190
    //   200: astore_1
    //   201: goto -19 -> 182
    //   204: astore 4
    //   206: aconst_null
    //   207: astore_1
    //   208: goto -67 -> 141
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	211	0	paramString1	String
    //   0	211	1	paramString2	String
    //   67	61	2	i	int
    //   87	2	3	bool	boolean
    //   55	100	4	localObject	Object
    //   204	1	4	localException	Exception
    //   37	88	5	arrayOfByte	byte[]
    //   45	78	6	localMessageDigest	MessageDigest
    // Exception table:
    //   from	to	target	type
    //   109	114	116	java/io/IOException
    //   60	68	134	java/lang/Exception
    //   75	88	134	java/lang/Exception
    //   122	131	134	java/lang/Exception
    //   170	174	176	java/io/IOException
    //   39	57	179	finally
    //   97	102	192	java/io/IOException
    //   186	190	196	java/io/IOException
    //   60	68	200	finally
    //   75	88	200	finally
    //   122	131	200	finally
    //   143	166	200	finally
    //   39	57	204	java/lang/Exception
  }
  
  private static aomj c()
  {
    Object localObject = BaseApplication.getContext().getSharedPreferences("SP_DICT_INFO_KEY", 0).getString("ArkAILocalDictConfig", "");
    if (TextUtils.isEmpty((CharSequence)localObject))
    {
      ArkAppCenter.c("ArkApp.Dict.Update", "getLocalDictConfig, configString is empty");
      return null;
    }
    try
    {
      localObject = (aomj)aolc.a(localObject, aomj.class);
      return localObject;
    }
    catch (QStorageInstantiateException localQStorageInstantiateException)
    {
      ArkAppCenter.c("ArkApp.Dict.Update", String.format("getLocalDictConfig, fail to decode json, err=%s", new Object[] { localQStorageInstantiateException.getMessage() }));
    }
    return null;
  }
  
  private static void c(aomj paramaomj)
  {
    if (paramaomj == null)
    {
      ArkAppCenter.c("ArkApp.Dict.Update", "setLocalDictConfig,aIDictConfig is null");
      return;
    }
    paramaomj = paramaomj.a();
    SharedPreferences.Editor localEditor = BaseApplication.getContext().getSharedPreferences("SP_DICT_INFO_KEY", 0).edit();
    localEditor.putString("ArkAILocalDictConfig", paramaomj);
    localEditor.apply();
  }
  
  private static boolean c(String paramString1, String paramString2)
  {
    String str = String.format(Locale.CHINA, "%s-%d", new Object[] { paramString1, Long.valueOf(System.currentTimeMillis()) });
    if (bdhb.c(paramString1, str)) {
      ArkAppCenter.c("ArkApp.Dict.Update", String.format("did rename dict dir to tmp dir, %s->%s", new Object[] { paramString1, str }));
    }
    if (!bdhb.c(paramString2, paramString1))
    {
      ArkAppCenter.c("ArkApp.Dict.Update", String.format("fail to rename new dir to dict dir, %s->%s", new Object[] { paramString2, paramString1 }));
      return false;
    }
    bdhb.a(str);
    return true;
  }
  
  private static boolean c(byte[] paramArrayOfByte, String paramString)
  {
    boolean bool1 = true;
    if ((paramArrayOfByte == null) || (paramArrayOfByte.length == 0) || (TextUtils.isEmpty(paramString))) {
      bool1 = false;
    }
    for (;;)
    {
      return bool1;
      try
      {
        boolean bool2 = a(MessageDigest.getInstance("MD5").digest(paramArrayOfByte)).equalsIgnoreCase(paramString);
        if (!bool2) {
          return false;
        }
      }
      catch (Exception paramArrayOfByte)
      {
        ArkAppCenter.c("ArkApp.Dict.Update", String.format("checkDictMd5, fail compute buffer md5, msg=%s", new Object[] { paramArrayOfByte.getMessage() }));
      }
    }
    return false;
  }
  
  private static aomj d()
  {
    aols localaols = aolx.b(170).a();
    if (localaols == null)
    {
      ArkAppCenter.c("ArkApp.Dict.Update", "getRemoteDictConfig, config string is empty");
      return null;
    }
    return localaols.a();
  }
  
  private static void d(aomj paramaomj)
  {
    if (paramaomj == null) {
      ArkAppCenter.c("ArkApp.Dict.Update", "deleteUnusedDict, localDictConfig is null");
    }
    for (;;)
    {
      return;
      paramaomj = b(paramaomj);
      String str1 = anmj.a();
      String[] arrayOfString = new File(str1).list();
      if (arrayOfString != null)
      {
        int j = arrayOfString.length;
        int i = 0;
        while (i < j)
        {
          String str2 = arrayOfString[i];
          if (!paramaomj.containsKey(str2))
          {
            ArkAppCenter.c("ArkApp.Dict.Update", String.format("deleteUnusedDict, name=%s", new Object[] { str2 }));
            bdhb.a(str1 + "/" + str2);
          }
          i += 1;
        }
      }
    }
  }
  
  public void a()
  {
    if (ArkAppCenter.a())
    {
      ArkAppCenter.c("ArkApp.Dict.Update", "updateLocalDict, use test dict, no update, return");
      return;
    }
    ArkAppCenter.c("ArkApp.Dict.Update", "updateLocalDict, start");
    ArkRecommendLogic.a().post(new ArkAiDictUpdateMgr.1(this));
  }
  
  public boolean a(String paramString)
  {
    QQAppInterface localQQAppInterface = (QQAppInterface)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    if (localQQAppInterface == null) {
      return false;
    }
    if (!TextUtils.isEmpty(paramString))
    {
      long l1 = Long.parseLong(paramString);
      long l2 = Long.parseLong(localQQAppInterface.getCurrentAccountUin());
      ArkAppCenter.c("ArkApp.Dict.Update", String.format("getBusinessState, business_percent=%s", new Object[] { paramString }));
      if (l2 % 100L <= l1) {}
      for (boolean bool = true;; bool = false) {
        return bool;
      }
    }
    ArkAppCenter.c("ArkApp.Dict.Update", "getBusinessState, business_percent is empty");
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     anmm
 * JD-Core Version:    0.7.0.1
 */