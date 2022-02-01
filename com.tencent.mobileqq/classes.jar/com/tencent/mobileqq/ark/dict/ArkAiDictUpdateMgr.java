package com.tencent.mobileqq.ark.dict;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Handler;
import android.text.TextUtils;
import com.tencent.mobileqq.ark.config.bean.ArkAIDictConfBean;
import com.tencent.mobileqq.ark.config.processor.ArkConfProcessor;
import com.tencent.mobileqq.ark.core.ArkPredownloader;
import com.tencent.mobileqq.ark.core.ArkPredownloader.Task;
import com.tencent.mobileqq.config.QStorage;
import com.tencent.mobileqq.config.QStorageInstantiateException;
import com.tencent.mobileqq.msf.sdk.AppNetConnInfo;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.security.MessageDigest;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map;
import mqq.app.AppRuntime;

public class ArkAiDictUpdateMgr
{
  private static final char[] jdField_a_of_type_ArrayOfChar = { 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 65, 66, 67, 68, 69, 70 };
  private final AppRuntime jdField_a_of_type_MqqAppAppRuntime;
  private volatile boolean jdField_a_of_type_Boolean = false;
  private volatile boolean b = false;
  
  public ArkAiDictUpdateMgr(AppRuntime paramAppRuntime)
  {
    this.jdField_a_of_type_MqqAppAppRuntime = paramAppRuntime;
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
    Iterator localIterator = ((DictConfig)localObject1).jdField_b_of_type_JavaUtilArrayList.iterator();
    while (localIterator.hasNext())
    {
      Object localObject2 = (ConditionalDict)localIterator.next();
      if (localObject2 != null)
      {
        ConditionalDict.Condition localCondition = ((ConditionalDict)localObject2).jdField_a_of_type_ComTencentMobileqqArkDictConditionalDict$Condition;
        if (localCondition != null)
        {
          localObject2 = ((ConditionalDict)localObject2).jdField_a_of_type_ComTencentMobileqqArkDictDictConfig;
          if ((localObject2 != null) && (a(localCondition)))
          {
            localObject2 = b((DictConfig)localObject2);
            if (localObject2 != null)
            {
              QLog.i("ArkDict.Update", 1, String.format("getEffectDictIdentifier, use condition dict, dict-id=%s, condition=%s", new Object[] { localObject2, localCondition.toString() }));
              return localObject2;
            }
          }
        }
      }
    }
    localObject1 = b((DictConfig)localObject1);
    QLog.i("ArkDict.Update", 1, String.format("getEffectDictIdentifier, use base dict, dict-id=%s", new Object[] { localObject1 }));
    return localObject1;
  }
  
  private static String a(String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(ArkAiDictMgr.a(paramString));
    localStringBuilder.append("/WordData");
    return localStringBuilder.toString();
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
  
  private void a(DictConfig paramDictConfig1, DictConfig paramDictConfig2, ArkAiDictUpdateMgr.IUpdateDictCallback paramIUpdateDictCallback)
  {
    if (paramDictConfig2 == null)
    {
      QLog.i("ArkDict.Update", 1, "updateWordDict, remote dict config is empty");
      paramIUpdateDictCallback.a(false);
      return;
    }
    if (!b(paramDictConfig2))
    {
      QLog.i("ArkDict.Update", 1, "updateWordDict, canUpdateDictAtCurrentNetType is false");
      paramIUpdateDictCallback.a(false);
      return;
    }
    String str1 = b(paramDictConfig2);
    if (TextUtils.isEmpty(str1))
    {
      QLog.i("ArkDict.Update", 1, "updateWordDict, empty new dict id");
      paramIUpdateDictCallback.a(false);
      return;
    }
    String str2 = b(str1);
    if (TextUtils.isEmpty(str2))
    {
      QLog.i("ArkDict.Update", 1, String.format("updateWordDict, fail to create new dict dir, id=%s", new Object[] { str1 }));
      paramIUpdateDictCallback.a(false);
      return;
    }
    Object localObject = b(paramDictConfig2);
    if ((localObject != null) && (((Map)localObject).size() != 0))
    {
      String str3 = b(paramDictConfig1);
      paramDictConfig2 = b(paramDictConfig1);
      paramDictConfig1 = new ArkAiDictUpdateMgr.UpdateState(null);
      paramDictConfig1.jdField_a_of_type_Int = ((Map)localObject).size();
      paramDictConfig1.jdField_a_of_type_Boolean = true;
      localObject = ((Map)localObject).values().iterator();
      while (((Iterator)localObject).hasNext())
      {
        DictInfo localDictInfo = (DictInfo)((Iterator)localObject).next();
        a(str2, str3, (DictInfo)paramDictConfig2.get(localDictInfo.a), localDictInfo, new ArkAiDictUpdateMgr.2(this, paramDictConfig1, localDictInfo, str2, paramIUpdateDictCallback, str1));
      }
      return;
    }
    QLog.i("ArkDict.Update", 1, "updateWordDict, new dict list is empty");
    paramIUpdateDictCallback.a(true);
  }
  
  private void a(String paramString, DictInfo paramDictInfo, ArkAiDictUpdateMgr.IUpdateDictCallback paramIUpdateDictCallback)
  {
    a(paramDictInfo.a, paramDictInfo.jdField_b_of_type_JavaLangString, new ArkAiDictUpdateMgr.6(this, paramDictInfo, paramString, paramIUpdateDictCallback));
  }
  
  private void a(String paramString1, String paramString2, ArkAiDictUpdateMgr.IDownloadDictFileCallback paramIDownloadDictFileCallback)
  {
    paramString1 = ArkPredownloader.a(this.jdField_a_of_type_MqqAppAppRuntime, paramString1, paramString2);
    paramString1.a(new ArkAiDictUpdateMgr.8(this, paramString2, paramIDownloadDictFileCallback, paramString1));
  }
  
  private void a(String paramString1, String paramString2, DictInfo paramDictInfo1, DictInfo paramDictInfo2, ArkAiDictUpdateMgr.IUpdateDictCallback paramIUpdateDictCallback)
  {
    DictInfo localDictInfo = paramDictInfo1;
    if (!a(paramString2, paramDictInfo1)) {
      localDictInfo = null;
    }
    boolean bool = false;
    if (localDictInfo == null)
    {
      QLog.i("ArkDict.Update", 1, String.format("updateDict, local not exists, full update, name=%s", new Object[] { paramDictInfo2.a }));
      a(paramString1, paramDictInfo2, new ArkAiDictUpdateMgr.3(this, paramDictInfo2, paramIUpdateDictCallback));
      return;
    }
    if (localDictInfo.d.equals(paramDictInfo2.d))
    {
      QLog.i("ArkDict.Update", 1, String.format("updateDict, file not change, copy from origin, name=%s", new Object[] { paramDictInfo2.a }));
      paramString2 = b(paramString2, localDictInfo.a);
      paramString1 = String.format("%s/%s", new Object[] { paramString1, paramDictInfo2.a });
      if (!FileUtils.copyFile(paramString2, paramString1)) {
        QLog.i("ArkDict.Update", 1, String.format("updateDict, copy file fail, %s->%s", new Object[] { paramString2, paramString1 }));
      } else {
        bool = true;
      }
      paramIUpdateDictCallback.a(bool);
      return;
    }
    if ((paramDictInfo2.b()) && (localDictInfo.d.equals(paramDictInfo2.g)))
    {
      QLog.i("ArkDict.Update", 1, String.format("updateDict, incremental update, name=%s", new Object[] { paramDictInfo2.a }));
      b(paramString1, paramString2, localDictInfo, paramDictInfo2, new ArkAiDictUpdateMgr.4(this, paramDictInfo2, paramIUpdateDictCallback, paramString1));
      return;
    }
    QLog.i("ArkDict.Update", 1, String.format("updateDict, full update, name=%s", new Object[] { paramDictInfo2.a }));
    a(paramString1, paramDictInfo2, new ArkAiDictUpdateMgr.5(this, paramIUpdateDictCallback));
  }
  
  private static boolean a(ConditionalDict.Condition paramCondition)
  {
    if (paramCondition == null) {
      return false;
    }
    paramCondition = paramCondition.a;
    String[] arrayOfString = paramCondition.split("-");
    if (arrayOfString.length == 2) {}
    try
    {
      int i = Integer.parseInt(arrayOfString[0]);
      int j = Integer.parseInt(arrayOfString[1]);
      int k = a();
      if ((i > k) || (k > j)) {
        break label82;
      }
      return true;
    }
    catch (NumberFormatException localNumberFormatException)
    {
      label59:
      break label59;
    }
    QLog.i("ArkDict.Update", 1, String.format(Locale.CHINA, "isDictConditionEffect, invalid date, date=%s", new Object[] { paramCondition }));
    label82:
    return false;
  }
  
  private boolean a(DictConfig paramDictConfig)
  {
    if (paramDictConfig == null)
    {
      QLog.i("ArkDict.Update", 1, "checkLocalDictIntegrity, config is empty, return");
      return false;
    }
    String str = b(paramDictConfig);
    paramDictConfig = b(paramDictConfig);
    if (paramDictConfig == null)
    {
      QLog.i("ArkDict.Update", 1, "checkLocalDictIntegrity, local dict list is empty");
      return true;
    }
    Iterator localIterator = paramDictConfig.values().iterator();
    while (localIterator.hasNext()) {
      if (!a(str, (DictInfo)localIterator.next()))
      {
        i = 1;
        break label87;
      }
    }
    int i = 0;
    label87:
    if (i == 0)
    {
      QLog.i("ArkDict.Update", 1, String.format("checkLocalDictIntegrity, all files check ok, no update, dict-id=%s", new Object[] { str }));
      return true;
    }
    QLog.i("ArkDict.Update", 1, String.format(Locale.CHINA, "checkLocalDictIntegrity, %d of %d files need update", new Object[] { Integer.valueOf(i), Integer.valueOf(paramDictConfig.size()) }));
    return false;
  }
  
  private static boolean a(String paramString, DictInfo paramDictInfo)
  {
    if (paramDictInfo == null) {
      return false;
    }
    return b(b(paramString, paramDictInfo.a), paramDictInfo.d);
  }
  
  /* Error */
  public static boolean a(byte[] paramArrayOfByte, String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: ifnull +220 -> 221
    //   4: aload_1
    //   5: invokestatic 196	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   8: ifeq +5 -> 13
    //   11: iconst_0
    //   12: ireturn
    //   13: aconst_null
    //   14: astore 5
    //   16: aconst_null
    //   17: astore_2
    //   18: new 355	java/io/FileOutputStream
    //   21: dup
    //   22: aload_1
    //   23: invokespecial 358	java/io/FileOutputStream:<init>	(Ljava/lang/String;)V
    //   26: astore_3
    //   27: aload_3
    //   28: aload_0
    //   29: invokevirtual 362	java/io/FileOutputStream:write	([B)V
    //   32: aload_3
    //   33: invokevirtual 365	java/io/FileOutputStream:close	()V
    //   36: iconst_1
    //   37: ireturn
    //   38: astore_0
    //   39: ldc 125
    //   41: iconst_1
    //   42: getstatic 50	java/util/Locale:CHINA	Ljava/util/Locale;
    //   45: ldc_w 367
    //   48: iconst_2
    //   49: anewarray 4	java/lang/Object
    //   52: dup
    //   53: iconst_0
    //   54: aload_0
    //   55: invokevirtual 370	java/io/IOException:getMessage	()Ljava/lang/String;
    //   58: aastore
    //   59: dup
    //   60: iconst_1
    //   61: aload_1
    //   62: aastore
    //   63: invokestatic 76	java/lang/String:format	(Ljava/util/Locale;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   66: invokestatic 139	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   69: iconst_1
    //   70: ireturn
    //   71: astore_0
    //   72: aload_3
    //   73: astore_2
    //   74: goto +103 -> 177
    //   77: astore_2
    //   78: aload_2
    //   79: astore 4
    //   81: goto +12 -> 93
    //   84: astore_0
    //   85: goto +92 -> 177
    //   88: astore 4
    //   90: aload 5
    //   92: astore_3
    //   93: aload_3
    //   94: astore_2
    //   95: ldc 125
    //   97: iconst_1
    //   98: getstatic 50	java/util/Locale:CHINA	Ljava/util/Locale;
    //   101: ldc_w 372
    //   104: iconst_3
    //   105: anewarray 4	java/lang/Object
    //   108: dup
    //   109: iconst_0
    //   110: aload 4
    //   112: invokevirtual 370	java/io/IOException:getMessage	()Ljava/lang/String;
    //   115: aastore
    //   116: dup
    //   117: iconst_1
    //   118: aload_0
    //   119: arraylength
    //   120: invokestatic 61	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   123: aastore
    //   124: dup
    //   125: iconst_2
    //   126: aload_1
    //   127: aastore
    //   128: invokestatic 76	java/lang/String:format	(Ljava/util/Locale;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   131: invokestatic 139	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   134: aload_3
    //   135: ifnull +40 -> 175
    //   138: aload_3
    //   139: invokevirtual 365	java/io/FileOutputStream:close	()V
    //   142: iconst_0
    //   143: ireturn
    //   144: astore_0
    //   145: ldc 125
    //   147: iconst_1
    //   148: getstatic 50	java/util/Locale:CHINA	Ljava/util/Locale;
    //   151: ldc_w 367
    //   154: iconst_2
    //   155: anewarray 4	java/lang/Object
    //   158: dup
    //   159: iconst_0
    //   160: aload_0
    //   161: invokevirtual 370	java/io/IOException:getMessage	()Ljava/lang/String;
    //   164: aastore
    //   165: dup
    //   166: iconst_1
    //   167: aload_1
    //   168: aastore
    //   169: invokestatic 76	java/lang/String:format	(Ljava/util/Locale;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   172: invokestatic 139	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   175: iconst_0
    //   176: ireturn
    //   177: aload_2
    //   178: ifnull +41 -> 219
    //   181: aload_2
    //   182: invokevirtual 365	java/io/FileOutputStream:close	()V
    //   185: goto +34 -> 219
    //   188: astore_2
    //   189: ldc 125
    //   191: iconst_1
    //   192: getstatic 50	java/util/Locale:CHINA	Ljava/util/Locale;
    //   195: ldc_w 367
    //   198: iconst_2
    //   199: anewarray 4	java/lang/Object
    //   202: dup
    //   203: iconst_0
    //   204: aload_2
    //   205: invokevirtual 370	java/io/IOException:getMessage	()Ljava/lang/String;
    //   208: aastore
    //   209: dup
    //   210: iconst_1
    //   211: aload_1
    //   212: aastore
    //   213: invokestatic 76	java/lang/String:format	(Ljava/util/Locale;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   216: invokestatic 139	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   219: aload_0
    //   220: athrow
    //   221: iconst_0
    //   222: ireturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	223	0	paramArrayOfByte	byte[]
    //   0	223	1	paramString	String
    //   17	57	2	localObject1	Object
    //   77	2	2	localIOException1	java.io.IOException
    //   94	88	2	localObject2	Object
    //   188	17	2	localIOException2	java.io.IOException
    //   26	113	3	localObject3	Object
    //   79	1	4	localIOException3	java.io.IOException
    //   88	23	4	localIOException4	java.io.IOException
    //   14	77	5	localObject4	Object
    // Exception table:
    //   from	to	target	type
    //   32	36	38	java/io/IOException
    //   27	32	71	finally
    //   27	32	77	java/io/IOException
    //   18	27	84	finally
    //   95	134	84	finally
    //   18	27	88	java/io/IOException
    //   138	142	144	java/io/IOException
    //   181	185	188	java/io/IOException
  }
  
  private static String b(DictConfig paramDictConfig)
  {
    if (paramDictConfig == null) {
      return null;
    }
    String str = paramDictConfig.c;
    paramDictConfig = paramDictConfig.jdField_b_of_type_JavaLangString;
    if (!TextUtils.isEmpty(str))
    {
      if (TextUtils.isEmpty(paramDictConfig)) {
        return null;
      }
      return String.format("%s-%s", new Object[] { str, paramDictConfig });
    }
    return null;
  }
  
  private static String b(String paramString)
  {
    String str = a(String.format(Locale.CHINA, "%s%s-%d", new Object[] { "tmp-", paramString, Long.valueOf(System.currentTimeMillis()) }));
    File localFile = new File(str);
    localFile.mkdirs();
    paramString = str;
    if (!localFile.isDirectory())
    {
      QLog.i("ArkDict.Update", 1, String.format("getTmpWordDataDirectory, fail to create tmp word data directory, dir=%s", new Object[] { str }));
      paramString = null;
    }
    return paramString;
  }
  
  private static String b(String paramString1, String paramString2)
  {
    return String.format("%s/%s", new Object[] { a(paramString1), paramString2 });
  }
  
  private static Map<String, DictInfo> b(DictConfig paramDictConfig)
  {
    if (paramDictConfig == null) {
      return new HashMap();
    }
    Object localObject = paramDictConfig.a;
    if (localObject == null)
    {
      QLog.i("ArkDict.Update", 1, "getDictInfoFromConfig, 'word_dict_list' field not found");
      return new HashMap();
    }
    paramDictConfig = new HashMap();
    localObject = ((ArrayList)localObject).iterator();
    while (((Iterator)localObject).hasNext())
    {
      DictInfo localDictInfo = (DictInfo)((Iterator)localObject).next();
      if (localDictInfo != null) {
        paramDictConfig.put(localDictInfo.a, localDictInfo);
      }
    }
    return paramDictConfig;
  }
  
  private void b(String paramString1, String paramString2, DictInfo paramDictInfo1, DictInfo paramDictInfo2, ArkAiDictUpdateMgr.IUpdateDictCallback paramIUpdateDictCallback)
  {
    a(paramDictInfo2.a, paramDictInfo2.e, new ArkAiDictUpdateMgr.7(this, paramDictInfo2, paramString2, paramDictInfo1, paramString1, paramIUpdateDictCallback));
  }
  
  private static boolean b(DictConfig paramDictConfig)
  {
    if (paramDictConfig == null) {
      return false;
    }
    paramDictConfig = paramDictConfig.e;
    if ((!TextUtils.isEmpty(paramDictConfig)) && (!paramDictConfig.equalsIgnoreCase("wifi")))
    {
      QLog.i("ArkDict.Update", 1, String.format("getNetType, netType in not WIFI.", new Object[0]));
      return true;
    }
    if ((AppNetConnInfo.isNetSupport()) && (AppNetConnInfo.isWifiConn()))
    {
      QLog.i("ArkDict.Update", 1, String.format("getNetType, invalid dict info, netType=%s", new Object[] { paramDictConfig }));
      return true;
    }
    QLog.i("ArkDict.Update", 1, String.format("getNetType, not judge net Type.", new Object[0]));
    return false;
  }
  
  /* Error */
  private static boolean b(String paramString1, String paramString2)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokestatic 196	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   4: ifne +197 -> 201
    //   7: aload_1
    //   8: invokestatic 196	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   11: ifeq +5 -> 16
    //   14: iconst_0
    //   15: ireturn
    //   16: new 395	java/io/File
    //   19: dup
    //   20: aload_0
    //   21: invokespecial 396	java/io/File:<init>	(Ljava/lang/String;)V
    //   24: astore 8
    //   26: aload 8
    //   28: invokevirtual 453	java/io/File:isFile	()Z
    //   31: ifne +5 -> 36
    //   34: iconst_0
    //   35: ireturn
    //   36: sipush 4096
    //   39: newarray byte
    //   41: astore 6
    //   43: aconst_null
    //   44: astore 5
    //   46: aconst_null
    //   47: astore 4
    //   49: aload 4
    //   51: astore_0
    //   52: ldc_w 455
    //   55: invokestatic 461	java/security/MessageDigest:getInstance	(Ljava/lang/String;)Ljava/security/MessageDigest;
    //   58: astore 7
    //   60: aload 4
    //   62: astore_0
    //   63: new 463	java/io/FileInputStream
    //   66: dup
    //   67: aload 8
    //   69: invokespecial 466	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   72: astore 4
    //   74: aload 4
    //   76: aload 6
    //   78: invokevirtual 470	java/io/FileInputStream:read	([B)I
    //   81: istore_2
    //   82: iload_2
    //   83: ifgt +34 -> 117
    //   86: aload 7
    //   88: invokevirtual 474	java/security/MessageDigest:digest	()[B
    //   91: invokestatic 476	com/tencent/mobileqq/ark/dict/ArkAiDictUpdateMgr:a	([B)Ljava/lang/String;
    //   94: aload_1
    //   95: invokevirtual 434	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   98: istore_3
    //   99: iload_3
    //   100: ifeq +10 -> 110
    //   103: aload 4
    //   105: invokevirtual 477	java/io/FileInputStream:close	()V
    //   108: iconst_1
    //   109: ireturn
    //   110: aload 4
    //   112: invokevirtual 477	java/io/FileInputStream:close	()V
    //   115: iconst_0
    //   116: ireturn
    //   117: aload 7
    //   119: aload 6
    //   121: iconst_0
    //   122: iload_2
    //   123: invokevirtual 481	java/security/MessageDigest:update	([BII)V
    //   126: goto -52 -> 74
    //   129: astore_1
    //   130: aload 4
    //   132: astore_0
    //   133: goto +58 -> 191
    //   136: astore_0
    //   137: aload 4
    //   139: astore_1
    //   140: aload_0
    //   141: astore 4
    //   143: goto +12 -> 155
    //   146: astore_1
    //   147: goto +44 -> 191
    //   150: astore 4
    //   152: aload 5
    //   154: astore_1
    //   155: aload_1
    //   156: astore_0
    //   157: ldc 125
    //   159: iconst_1
    //   160: ldc_w 483
    //   163: iconst_1
    //   164: anewarray 4	java/lang/Object
    //   167: dup
    //   168: iconst_0
    //   169: aload 4
    //   171: invokevirtual 484	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   174: aastore
    //   175: invokestatic 133	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   178: invokestatic 139	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   181: aload_1
    //   182: ifnull +7 -> 189
    //   185: aload_1
    //   186: invokevirtual 477	java/io/FileInputStream:close	()V
    //   189: iconst_0
    //   190: ireturn
    //   191: aload_0
    //   192: ifnull +7 -> 199
    //   195: aload_0
    //   196: invokevirtual 477	java/io/FileInputStream:close	()V
    //   199: aload_1
    //   200: athrow
    //   201: iconst_0
    //   202: ireturn
    //   203: astore_0
    //   204: iconst_1
    //   205: ireturn
    //   206: astore_0
    //   207: iconst_0
    //   208: ireturn
    //   209: astore_0
    //   210: iconst_0
    //   211: ireturn
    //   212: astore_0
    //   213: goto -14 -> 199
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	216	0	paramString1	String
    //   0	216	1	paramString2	String
    //   81	42	2	i	int
    //   98	2	3	bool	boolean
    //   47	95	4	localObject1	Object
    //   150	20	4	localException	Exception
    //   44	109	5	localObject2	Object
    //   41	79	6	arrayOfByte	byte[]
    //   58	60	7	localMessageDigest	MessageDigest
    //   24	44	8	localFile	File
    // Exception table:
    //   from	to	target	type
    //   74	82	129	finally
    //   86	99	129	finally
    //   117	126	129	finally
    //   74	82	136	java/lang/Exception
    //   86	99	136	java/lang/Exception
    //   117	126	136	java/lang/Exception
    //   52	60	146	finally
    //   63	74	146	finally
    //   157	181	146	finally
    //   52	60	150	java/lang/Exception
    //   63	74	150	java/lang/Exception
    //   103	108	203	java/io/IOException
    //   110	115	206	java/io/IOException
    //   185	189	209	java/io/IOException
    //   195	199	212	java/io/IOException
  }
  
  private static DictConfig c()
  {
    Object localObject = BaseApplication.getContext().getSharedPreferences("SP_DICT_INFO_KEY", 0).getString("ArkAILocalDictConfig", "");
    if (TextUtils.isEmpty((CharSequence)localObject))
    {
      QLog.i("ArkDict.Update", 1, "getLocalDictConfig, configString is empty");
      return null;
    }
    try
    {
      localObject = (DictConfig)QStorage.a(localObject, AIDictConfig.class);
      return localObject;
    }
    catch (QStorageInstantiateException localQStorageInstantiateException)
    {
      QLog.i("ArkDict.Update", 1, String.format("getLocalDictConfig, fail to decode json, err=%s", new Object[] { localQStorageInstantiateException.getMessage() }));
    }
    return null;
  }
  
  private static Map<String, DictConfig> c(DictConfig paramDictConfig)
  {
    HashMap localHashMap = new HashMap();
    if (paramDictConfig == null)
    {
      QLog.i("ArkDict.Update", 1, "getDictGroupList,aIDictConfig is null");
      return localHashMap;
    }
    Object localObject1 = b(paramDictConfig);
    if (localObject1 != null) {
      localHashMap.put(localObject1, paramDictConfig);
    }
    paramDictConfig = paramDictConfig.jdField_b_of_type_JavaUtilArrayList.iterator();
    while (paramDictConfig.hasNext())
    {
      Object localObject2 = (ConditionalDict)paramDictConfig.next();
      if (localObject2 != null)
      {
        localObject1 = ((ConditionalDict)localObject2).jdField_a_of_type_ComTencentMobileqqArkDictConditionalDict$Condition;
        localObject2 = ((ConditionalDict)localObject2).jdField_a_of_type_ComTencentMobileqqArkDictDictConfig;
        if ((localObject1 != null) && (localObject2 != null))
        {
          localObject1 = b((DictConfig)localObject2);
          if (localObject1 != null) {
            localHashMap.put(localObject1, localObject2);
          }
        }
      }
    }
    return localHashMap;
  }
  
  private static void c(DictConfig paramDictConfig)
  {
    if (paramDictConfig == null)
    {
      QLog.i("ArkDict.Update", 1, "setLocalDictConfig,aIDictConfig is null");
      return;
    }
    paramDictConfig = paramDictConfig.a();
    SharedPreferences.Editor localEditor = BaseApplication.getContext().getSharedPreferences("SP_DICT_INFO_KEY", 0).edit();
    localEditor.putString("ArkAILocalDictConfig", paramDictConfig);
    localEditor.apply();
  }
  
  private static boolean c(String paramString1, String paramString2)
  {
    String str = String.format(Locale.CHINA, "%s-%d", new Object[] { paramString1, Long.valueOf(System.currentTimeMillis()) });
    if (FileUtils.rename(paramString1, str)) {
      QLog.i("ArkDict.Update", 1, String.format("did rename dict dir to tmp dir, %s->%s", new Object[] { paramString1, str }));
    }
    if (!FileUtils.rename(paramString2, paramString1))
    {
      QLog.i("ArkDict.Update", 1, String.format("fail to rename new dir to dict dir, %s->%s", new Object[] { paramString2, paramString1 }));
      return false;
    }
    FileUtils.deleteDirectory(str);
    return true;
  }
  
  private static boolean c(byte[] paramArrayOfByte, String paramString)
  {
    if ((paramArrayOfByte != null) && (paramArrayOfByte.length != 0))
    {
      if (TextUtils.isEmpty(paramString)) {
        return false;
      }
      try
      {
        boolean bool = a(MessageDigest.getInstance("MD5").digest(paramArrayOfByte)).equalsIgnoreCase(paramString);
        return bool;
      }
      catch (Exception paramArrayOfByte)
      {
        QLog.i("ArkDict.Update", 1, String.format("checkDictMd5, fail compute buffer md5, msg=%s", new Object[] { paramArrayOfByte.getMessage() }));
      }
    }
    return false;
  }
  
  private static DictConfig d()
  {
    ArkAIDictConfBean localArkAIDictConfBean = (ArkAIDictConfBean)ArkConfProcessor.a(ArkAIDictConfBean.class);
    if (localArkAIDictConfBean == null)
    {
      QLog.i("ArkDict.Update", 1, "getRemoteDictConfig, config string is empty");
      return null;
    }
    return localArkAIDictConfBean.a();
  }
  
  private static void d(DictConfig paramDictConfig)
  {
    if (paramDictConfig == null)
    {
      QLog.i("ArkDict.Update", 1, "deleteUnusedDict, localDictConfig is null");
      return;
    }
    paramDictConfig = c(paramDictConfig);
    String str1 = ArkAiDictMgr.a();
    String[] arrayOfString = new File(str1).list();
    if (arrayOfString != null)
    {
      int j = arrayOfString.length;
      int i = 0;
      while (i < j)
      {
        String str2 = arrayOfString[i];
        if (!paramDictConfig.containsKey(str2))
        {
          QLog.i("ArkDict.Update", 1, String.format("deleteUnusedDict, name=%s", new Object[] { str2 }));
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append(str1);
          localStringBuilder.append("/");
          localStringBuilder.append(str2);
          FileUtils.deleteDirectory(localStringBuilder.toString());
        }
        i += 1;
      }
    }
  }
  
  public void a()
  {
    if (TestSupport.a())
    {
      QLog.i("ArkDict.Update", 1, "updateLocalDict, use test dict, no update, return");
      return;
    }
    QLog.i("ArkDict.Update", 1, "updateLocalDict, start");
    ArkRecommendLogic.a().post(new ArkAiDictUpdateMgr.1(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.ark.dict.ArkAiDictUpdateMgr
 * JD-Core Version:    0.7.0.1
 */