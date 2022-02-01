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
import com.tencent.mobileqq.transfile.predownload.PreDownloadController;
import com.tencent.mobileqq.transfile.predownload.RunnableTask;
import com.tencent.mobileqq.utils.FileUtils;
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

public class aotv
{
  private static final char[] jdField_a_of_type_ArrayOfChar = { 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 65, 66, 67, 68, 69, 70 };
  private java.lang.ref.WeakReference<QQAppInterface> jdField_a_of_type_JavaLangRefWeakReference;
  private volatile boolean jdField_a_of_type_Boolean;
  private volatile boolean b;
  
  aotv(QQAppInterface paramQQAppInterface)
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
    Iterator localIterator = ((apwc)localObject1).a.iterator();
    while (localIterator.hasNext())
    {
      Object localObject2 = (apwm)localIterator.next();
      if (localObject2 != null)
      {
        apwl localapwl = ((apwm)localObject2).jdField_a_of_type_Apwl;
        if (localapwl != null)
        {
          localObject2 = ((apwm)localObject2).jdField_a_of_type_Apwo;
          if ((localObject2 != null) && (a(localapwl)))
          {
            localObject2 = b((apwo)localObject2);
            if (localObject2 != null)
            {
              ArkAppCenter.c("ArkApp.Dict.Update", String.format("getEffectDictIdentifier, use condition dict, dict-id=%s, condition=%s", new Object[] { localObject2, localapwl.toString() }));
              return localObject2;
            }
          }
        }
      }
    }
    localObject1 = b((apwo)localObject1);
    ArkAppCenter.c("ArkApp.Dict.Update", String.format("getEffectDictIdentifier, use base dict, dict-id=%s", new Object[] { localObject1 }));
    return localObject1;
  }
  
  private static String a(String paramString)
  {
    return aots.a(paramString) + "/WordData";
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
  
  private static Map<String, aouf> a(apwo paramapwo)
  {
    if (paramapwo == null) {
      return new HashMap();
    }
    Object localObject = paramapwo.jdField_b_of_type_JavaUtilArrayList;
    if (localObject == null)
    {
      ArkAppCenter.c("ArkApp.Dict.Update", "getDictInfoFromConfig, 'word_dict_list' field not found");
      return new HashMap();
    }
    paramapwo = new HashMap();
    localObject = ((ArrayList)localObject).iterator();
    while (((Iterator)localObject).hasNext())
    {
      aouf localaouf = (aouf)((Iterator)localObject).next();
      if (localaouf != null) {
        paramapwo.put(localaouf.a, localaouf);
      }
    }
    return paramapwo;
  }
  
  private void a(apwo paramapwo1, apwo paramapwo2, aouh paramaouh)
  {
    if (paramapwo2 == null)
    {
      ArkAppCenter.c("ArkApp.Dict.Update", "updateWordDict, remote dict config is empty");
      paramaouh.a(false);
    }
    for (;;)
    {
      return;
      if (!b(paramapwo2))
      {
        ArkAppCenter.c("ArkApp.Dict.Update", "updateWordDict, canUpdateDictAtCurrentNetType is false");
        paramaouh.a(false);
        return;
      }
      String str1 = b(paramapwo2);
      if (TextUtils.isEmpty(str1))
      {
        ArkAppCenter.c("ArkApp.Dict.Update", "updateWordDict, empty new dict id");
        paramaouh.a(false);
        return;
      }
      String str2 = b(str1);
      if (TextUtils.isEmpty(str2))
      {
        ArkAppCenter.c("ArkApp.Dict.Update", String.format("updateWordDict, fail to create new dict dir, id=%s", new Object[] { str1 }));
        paramaouh.a(false);
        return;
      }
      Object localObject = a(paramapwo2);
      if ((localObject == null) || (((Map)localObject).size() == 0))
      {
        ArkAppCenter.c("ArkApp.Dict.Update", "updateWordDict, new dict list is empty");
        paramaouh.a(true);
        return;
      }
      paramapwo2 = b(paramapwo1);
      paramapwo1 = a(paramapwo1);
      aouj localaouj = new aouj(null);
      localaouj.jdField_a_of_type_Int = ((Map)localObject).size();
      localaouj.jdField_a_of_type_Boolean = true;
      localObject = ((Map)localObject).values().iterator();
      while (((Iterator)localObject).hasNext())
      {
        aouf localaouf = (aouf)((Iterator)localObject).next();
        a(str2, paramapwo2, (aouf)paramapwo1.get(localaouf.a), localaouf, new aotx(this, localaouj, localaouf, str2, paramaouh, str1));
      }
    }
  }
  
  private void a(String paramString, aouf paramaouf, aouh paramaouh)
  {
    a(paramaouf.a, paramaouf.jdField_b_of_type_JavaLangString, new aouc(this, paramaouf, paramString, paramaouh));
  }
  
  private void a(String paramString1, String paramString2, aouf paramaouf1, aouf paramaouf2, aouh paramaouh)
  {
    boolean bool = false;
    if (!a(paramString2, paramaouf1)) {
      paramaouf1 = null;
    }
    for (;;)
    {
      if (paramaouf1 == null)
      {
        ArkAppCenter.c("ArkApp.Dict.Update", String.format("updateDict, local not exists, full update, name=%s", new Object[] { paramaouf2.a }));
        a(paramString1, paramaouf2, new aoty(this, paramaouf2, paramaouh));
        return;
      }
      if (paramaouf1.d.equals(paramaouf2.d))
      {
        ArkAppCenter.c("ArkApp.Dict.Update", String.format("updateDict, file not change, copy from origin, name=%s", new Object[] { paramaouf2.a }));
        paramString2 = b(paramString2, paramaouf1.a);
        paramString1 = String.format("%s/%s", new Object[] { paramString1, paramaouf2.a });
        if (FileUtils.copyFile(paramString2, paramString1)) {
          break label281;
        }
        ArkAppCenter.c("ArkApp.Dict.Update", String.format("updateDict, copy file fail, %s->%s", new Object[] { paramString2, paramString1 }));
      }
      for (;;)
      {
        paramaouh.a(bool);
        return;
        if ((paramaouf2.b()) && (paramaouf1.d.equals(paramaouf2.g)))
        {
          ArkAppCenter.c("ArkApp.Dict.Update", String.format("updateDict, incremental update, name=%s", new Object[] { paramaouf2.a }));
          b(paramString1, paramString2, paramaouf1, paramaouf2, new aotz(this, paramaouf2, paramaouh, paramString1));
          return;
        }
        ArkAppCenter.c("ArkApp.Dict.Update", String.format("updateDict, full update, name=%s", new Object[] { paramaouf2.a }));
        a(paramString1, paramaouf2, new aoub(this, paramaouh));
        return;
        label281:
        bool = true;
      }
    }
  }
  
  private void a(String paramString1, String paramString2, aoug paramaoug)
  {
    aoui localaoui = new aoui(null);
    QQAppInterface localQQAppInterface = (QQAppInterface)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    if (localQQAppInterface == null)
    {
      ArkAppCenter.c("ArkApp.Dict.Update", "downloadDictFile, qq app interface is null, return from download");
      return;
    }
    PreDownloadController localPreDownloadController = (PreDownloadController)localQQAppInterface.getManager(193);
    localaoui.jdField_a_of_type_JavaLangRefWeakReference = new java.lang.ref.WeakReference(localPreDownloadController);
    paramaoug = new ArkAiDictUpdateMgr.8(this, paramString2, localaoui, paramaoug);
    if (localQQAppInterface == null)
    {
      ArkAppCenter.c("ArkApp.Dict.Update", "downloadDictFile, qq app interface is null, return");
      return;
    }
    localaoui.jdField_a_of_type_Boolean = localPreDownloadController.isEnable();
    if (localaoui.jdField_a_of_type_Boolean)
    {
      localPreDownloadController.requestPreDownload(10022, "prd", paramString1, 0, paramString2, "", 1, 0, false, new RunnableTask(localQQAppInterface, paramString1, paramaoug, 10000L));
      return;
    }
    paramaoug.run();
    ArkAppCenter.c("ArkApp.Dict.Update", String.format("downloadDictFile, not use pre-download, name=%s, URL=%s.", new Object[] { paramString1, paramString2 }));
  }
  
  private static boolean a(apwl paramapwl)
  {
    if (paramapwl == null) {}
    for (;;)
    {
      return false;
      paramapwl = paramapwl.a;
      String[] arrayOfString = paramapwl.split("-");
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
          ArkAppCenter.c("ArkApp.Dict.Update", String.format(Locale.CHINA, "isDictConditionEffect, invalid date, date=%s", new Object[] { paramapwl }));
        }
      }
    }
    return false;
  }
  
  private boolean a(apwo paramapwo)
  {
    if (paramapwo == null)
    {
      ArkAppCenter.c("ArkApp.Dict.Update", "checkLocalDictIntegrity, config is empty, return");
      return false;
    }
    String str = b(paramapwo);
    paramapwo = a(paramapwo);
    if (paramapwo == null)
    {
      ArkAppCenter.c("ArkApp.Dict.Update", "checkLocalDictIntegrity, local dict list is empty");
      return true;
    }
    Iterator localIterator = paramapwo.values().iterator();
    do
    {
      if (!localIterator.hasNext()) {
        break;
      }
    } while (a(str, (aouf)localIterator.next()));
    for (int i = 1;; i = 0)
    {
      if (i == 0)
      {
        ArkAppCenter.c("ArkApp.Dict.Update", String.format("checkLocalDictIntegrity, all files check ok, no update, dict-id=%s", new Object[] { str }));
        return true;
      }
      ArkAppCenter.c("ArkApp.Dict.Update", String.format(Locale.CHINA, "checkLocalDictIntegrity, %d of %d files need update", new Object[] { Integer.valueOf(i), Integer.valueOf(paramapwo.size()) }));
      return false;
    }
  }
  
  private static boolean a(String paramString, aouf paramaouf)
  {
    if (paramaouf == null) {}
    while (!b(b(paramString, paramaouf.a), paramaouf.d)) {
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
    //   17: new 413	java/io/FileOutputStream
    //   20: dup
    //   21: aload_1
    //   22: invokespecial 416	java/io/FileOutputStream:<init>	(Ljava/lang/String;)V
    //   25: astore 4
    //   27: aload 4
    //   29: astore_3
    //   30: aload 4
    //   32: aload_0
    //   33: invokevirtual 420	java/io/FileOutputStream:write	([B)V
    //   36: aload 4
    //   38: ifnull -23 -> 15
    //   41: aload 4
    //   43: invokevirtual 423	java/io/FileOutputStream:close	()V
    //   46: iconst_1
    //   47: ireturn
    //   48: astore_0
    //   49: ldc 127
    //   51: getstatic 52	java/util/Locale:CHINA	Ljava/util/Locale;
    //   54: ldc_w 425
    //   57: iconst_2
    //   58: anewarray 4	java/lang/Object
    //   61: dup
    //   62: iconst_0
    //   63: aload_0
    //   64: invokevirtual 428	java/io/IOException:getMessage	()Ljava/lang/String;
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
    //   93: ldc_w 430
    //   96: iconst_3
    //   97: anewarray 4	java/lang/Object
    //   100: dup
    //   101: iconst_0
    //   102: aload 5
    //   104: invokevirtual 428	java/io/IOException:getMessage	()Ljava/lang/String;
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
    //   133: invokevirtual 423	java/io/FileOutputStream:close	()V
    //   136: iconst_0
    //   137: ireturn
    //   138: astore_0
    //   139: ldc 127
    //   141: getstatic 52	java/util/Locale:CHINA	Ljava/util/Locale;
    //   144: ldc_w 425
    //   147: iconst_2
    //   148: anewarray 4	java/lang/Object
    //   151: dup
    //   152: iconst_0
    //   153: aload_0
    //   154: invokevirtual 428	java/io/IOException:getMessage	()Ljava/lang/String;
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
    //   179: invokevirtual 423	java/io/FileOutputStream:close	()V
    //   182: aload_0
    //   183: athrow
    //   184: astore_3
    //   185: ldc 127
    //   187: getstatic 52	java/util/Locale:CHINA	Ljava/util/Locale;
    //   190: ldc_w 425
    //   193: iconst_2
    //   194: anewarray 4	java/lang/Object
    //   197: dup
    //   198: iconst_0
    //   199: aload_3
    //   200: invokevirtual 428	java/io/IOException:getMessage	()Ljava/lang/String;
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
  
  private static String b(apwo paramapwo)
  {
    if (paramapwo == null) {}
    String str;
    do
    {
      return null;
      str = paramapwo.c;
      paramapwo = paramapwo.jdField_b_of_type_JavaLangString;
    } while ((TextUtils.isEmpty(str)) || (TextUtils.isEmpty(paramapwo)));
    return String.format("%s-%s", new Object[] { str, paramapwo });
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
  
  private static Map<String, apwo> b(apwc paramapwc)
  {
    HashMap localHashMap = new HashMap();
    if (paramapwc == null)
    {
      ArkAppCenter.c("ArkApp.Dict.Update", "getDictGroupList,aIDictConfig is null");
      return localHashMap;
    }
    Object localObject1 = b(paramapwc);
    if (localObject1 != null) {
      localHashMap.put(localObject1, paramapwc);
    }
    paramapwc = paramapwc.a.iterator();
    while (paramapwc.hasNext())
    {
      Object localObject2 = (apwm)paramapwc.next();
      if (localObject2 != null)
      {
        localObject1 = ((apwm)localObject2).jdField_a_of_type_Apwl;
        localObject2 = ((apwm)localObject2).jdField_a_of_type_Apwo;
        if ((localObject1 != null) && (localObject2 != null))
        {
          localObject1 = b((apwo)localObject2);
          if (localObject1 != null) {
            localHashMap.put(localObject1, localObject2);
          }
        }
      }
    }
    return localHashMap;
  }
  
  private void b(String paramString1, String paramString2, aouf paramaouf1, aouf paramaouf2, aouh paramaouh)
  {
    a(paramaouf2.a, paramaouf2.e, new aoud(this, paramaouf2, paramString2, paramaouf1, paramString1, paramaouh));
  }
  
  private static boolean b(apwo paramapwo)
  {
    if (paramapwo == null) {
      return false;
    }
    paramapwo = paramapwo.e;
    if ((TextUtils.isEmpty(paramapwo)) || (paramapwo.equalsIgnoreCase("wifi")))
    {
      if ((AppNetConnInfo.isNetSupport()) && (AppNetConnInfo.isWifiConn()))
      {
        ArkAppCenter.c("ArkApp.Dict.Update", String.format("getNetType, invalid dict info, netType=%s", new Object[] { paramapwo }));
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
    //   16: new 453	java/io/File
    //   19: dup
    //   20: aload_0
    //   21: invokespecial 454	java/io/File:<init>	(Ljava/lang/String;)V
    //   24: astore_0
    //   25: aload_0
    //   26: invokevirtual 501	java/io/File:isFile	()Z
    //   29: ifeq -15 -> 14
    //   32: sipush 4096
    //   35: newarray byte
    //   37: astore 5
    //   39: ldc_w 503
    //   42: invokestatic 509	java/security/MessageDigest:getInstance	(Ljava/lang/String;)Ljava/security/MessageDigest;
    //   45: astore 6
    //   47: new 511	java/io/FileInputStream
    //   50: dup
    //   51: aload_0
    //   52: invokespecial 514	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   55: astore 4
    //   57: aload 4
    //   59: astore_0
    //   60: aload 4
    //   62: aload 5
    //   64: invokevirtual 518	java/io/FileInputStream:read	([B)I
    //   67: istore_2
    //   68: iload_2
    //   69: ifgt +50 -> 119
    //   72: aload 4
    //   74: astore_0
    //   75: aload 6
    //   77: invokevirtual 522	java/security/MessageDigest:digest	()[B
    //   80: invokestatic 524	aotv:a	([B)Ljava/lang/String;
    //   83: aload_1
    //   84: invokevirtual 482	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   87: istore_3
    //   88: iload_3
    //   89: ifeq +15 -> 104
    //   92: aload 4
    //   94: ifnull +8 -> 102
    //   97: aload 4
    //   99: invokevirtual 525	java/io/FileInputStream:close	()V
    //   102: iconst_1
    //   103: ireturn
    //   104: aload 4
    //   106: ifnull -92 -> 14
    //   109: aload 4
    //   111: invokevirtual 525	java/io/FileInputStream:close	()V
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
    //   128: invokevirtual 529	java/security/MessageDigest:update	([BII)V
    //   131: goto -74 -> 57
    //   134: astore_0
    //   135: aload 4
    //   137: astore_1
    //   138: aload_0
    //   139: astore 4
    //   141: aload_1
    //   142: astore_0
    //   143: ldc 127
    //   145: ldc_w 531
    //   148: iconst_1
    //   149: anewarray 4	java/lang/Object
    //   152: dup
    //   153: iconst_0
    //   154: aload 4
    //   156: invokevirtual 532	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   159: aastore
    //   160: invokestatic 135	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   163: invokestatic 140	com/tencent/mobileqq/ark/ArkAppCenter:c	(Ljava/lang/String;Ljava/lang/String;)V
    //   166: aload_1
    //   167: ifnull -153 -> 14
    //   170: aload_1
    //   171: invokevirtual 525	java/io/FileInputStream:close	()V
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
    //   187: invokevirtual 525	java/io/FileInputStream:close	()V
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
  
  private static apwc c()
  {
    Object localObject = BaseApplication.getContext().getSharedPreferences("SP_DICT_INFO_KEY", 0).getString("ArkAILocalDictConfig", "");
    if (TextUtils.isEmpty((CharSequence)localObject))
    {
      ArkAppCenter.c("ArkApp.Dict.Update", "getLocalDictConfig, configString is empty");
      return null;
    }
    try
    {
      localObject = (apwc)apul.a(localObject, apwc.class);
      return localObject;
    }
    catch (QStorageInstantiateException localQStorageInstantiateException)
    {
      ArkAppCenter.c("ArkApp.Dict.Update", String.format("getLocalDictConfig, fail to decode json, err=%s", new Object[] { localQStorageInstantiateException.getMessage() }));
    }
    return null;
  }
  
  private static void c(apwc paramapwc)
  {
    if (paramapwc == null)
    {
      ArkAppCenter.c("ArkApp.Dict.Update", "setLocalDictConfig,aIDictConfig is null");
      return;
    }
    paramapwc = paramapwc.a();
    SharedPreferences.Editor localEditor = BaseApplication.getContext().getSharedPreferences("SP_DICT_INFO_KEY", 0).edit();
    localEditor.putString("ArkAILocalDictConfig", paramapwc);
    localEditor.apply();
  }
  
  private static boolean c(String paramString1, String paramString2)
  {
    String str = String.format(Locale.CHINA, "%s-%d", new Object[] { paramString1, Long.valueOf(System.currentTimeMillis()) });
    if (FileUtils.rename(paramString1, str)) {
      ArkAppCenter.c("ArkApp.Dict.Update", String.format("did rename dict dir to tmp dir, %s->%s", new Object[] { paramString1, str }));
    }
    if (!FileUtils.rename(paramString2, paramString1))
    {
      ArkAppCenter.c("ArkApp.Dict.Update", String.format("fail to rename new dir to dict dir, %s->%s", new Object[] { paramString2, paramString1 }));
      return false;
    }
    FileUtils.deleteDirectory(str);
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
  
  private static apwc d()
  {
    apvl localapvl = apvq.b(170).a();
    if (localapvl == null)
    {
      ArkAppCenter.c("ArkApp.Dict.Update", "getRemoteDictConfig, config string is empty");
      return null;
    }
    return localapvl.a();
  }
  
  private static void d(apwc paramapwc)
  {
    if (paramapwc == null) {
      ArkAppCenter.c("ArkApp.Dict.Update", "deleteUnusedDict, localDictConfig is null");
    }
    for (;;)
    {
      return;
      paramapwc = b(paramapwc);
      String str1 = aots.a();
      String[] arrayOfString = new File(str1).list();
      if (arrayOfString != null)
      {
        int j = arrayOfString.length;
        int i = 0;
        while (i < j)
        {
          String str2 = arrayOfString[i];
          if (!paramapwc.containsKey(str2))
          {
            ArkAppCenter.c("ArkApp.Dict.Update", String.format("deleteUnusedDict, name=%s", new Object[] { str2 }));
            FileUtils.deleteDirectory(str1 + "/" + str2);
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
 * Qualified Name:     aotv
 * JD-Core Version:    0.7.0.1
 */