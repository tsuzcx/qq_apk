package com.tencent.mobileqq.ark.debug;

import android.content.Context;
import android.text.TextUtils;
import android.util.Pair;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.ark.api.IArkConfig;
import com.tencent.mobileqq.ark.api.IArkThreadManager;
import com.tencent.mobileqq.ark.config.ArkJsdebuggerDownload;
import com.tencent.mobileqq.ark.config.bean.ArkAIKeyWordConfBean;
import com.tencent.mobileqq.ark.config.config.AiKeywordConfig;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqprotect.singleupdate.MD5FileUtil;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class JSDebuggerSoLoader
{
  private static int jdField_a_of_type_Int = 0;
  private static JSDebuggerSoLoader.StatusListener jdField_a_of_type_ComTencentMobileqqArkDebugJSDebuggerSoLoader$StatusListener = null;
  private static final Object jdField_a_of_type_JavaLangObject = new Object();
  private static final Runnable jdField_a_of_type_JavaLangRunnable = new JSDebuggerSoLoader.3();
  private static String jdField_a_of_type_JavaLangString = "";
  private static Map<String, Pair<String, String>> jdField_a_of_type_JavaUtilMap;
  private static boolean jdField_a_of_type_Boolean = false;
  private static boolean b = false;
  
  static
  {
    jdField_a_of_type_Int = 1;
    jdField_a_of_type_JavaUtilMap = new HashMap();
  }
  
  public static String a()
  {
    if (TextUtils.isEmpty(jdField_a_of_type_JavaLangString))
    {
      Object localObject = BaseApplication.getContext();
      if (localObject != null)
      {
        localObject = ((Context)localObject).getFilesDir();
        if (localObject != null)
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append(((File)localObject).getParent());
          localStringBuilder.append("/txlib/");
          localStringBuilder.append("arkdebugger/");
          jdField_a_of_type_JavaLangString = localStringBuilder.toString();
        }
      }
      else
      {
        QLog.w("JSDebuggerSoLoader", 2, "getLibDirPath but context is null");
      }
    }
    return jdField_a_of_type_JavaLangString;
  }
  
  public static void a(int paramInt, JSDebuggerSoLoader.StatusListener paramStatusListener)
  {
    try
    {
      c();
      jdField_a_of_type_ComTencentMobileqqArkDebugJSDebuggerSoLoader$StatusListener = paramStatusListener;
      jdField_a_of_type_Int = paramInt;
      ThreadManager.remove(jdField_a_of_type_JavaLangRunnable);
      ThreadManager.post(jdField_a_of_type_JavaLangRunnable, 5, null, true);
      return;
    }
    finally
    {
      paramStatusListener = finally;
      throw paramStatusListener;
    }
  }
  
  private static String b()
  {
    String str = a();
    if (!TextUtils.isEmpty(str))
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(str);
      localStringBuilder.append("temp/");
      return localStringBuilder.toString();
    }
    return "";
  }
  
  private static void b()
  {
    b = false;
  }
  
  private static void b(int paramInt)
  {
    JSDebuggerSoLoader.StatusListener localStatusListener = jdField_a_of_type_ComTencentMobileqqArkDebugJSDebuggerSoLoader$StatusListener;
    if (localStatusListener != null) {
      localStatusListener.a(paramInt);
    }
  }
  
  private static void b(String paramString)
  {
    if (!TextUtils.isEmpty(paramString)) {
      try
      {
        Object localObject = new File(paramString);
        if ((((File)localObject).exists()) && (((File)localObject).isDirectory()))
        {
          localObject = ((File)localObject).list();
          int j = localObject.length;
          int i = 0;
          while (i < j)
          {
            File localFile = new File(paramString, localObject[i]);
            if ((localFile.exists()) && (localFile.isFile())) {
              localFile.delete();
            }
            i += 1;
          }
        }
        return;
      }
      catch (Exception paramString)
      {
        QLog.e("JSDebuggerSoLoader", 1, paramString, new Object[0]);
      }
    }
  }
  
  private static void b(String paramString1, String paramString2)
  {
    if ((!TextUtils.isEmpty(paramString1)) && (!TextUtils.isEmpty(paramString2))) {
      ((IArkThreadManager)QRoute.api(IArkThreadManager.class)).postToLogicThread(new JSDebuggerSoLoader.2(paramString1, paramString2));
    }
  }
  
  /* Error */
  private static boolean b()
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: getstatic 24	com/tencent/mobileqq/ark/debug/JSDebuggerSoLoader:jdField_a_of_type_JavaLangObject	Ljava/lang/Object;
    //   6: astore_0
    //   7: aload_0
    //   8: monitorenter
    //   9: getstatic 26	com/tencent/mobileqq/ark/debug/JSDebuggerSoLoader:jdField_a_of_type_Boolean	Z
    //   12: ifeq +18 -> 30
    //   15: ldc 87
    //   17: iconst_2
    //   18: ldc 178
    //   20: invokestatic 181	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   23: aload_0
    //   24: monitorexit
    //   25: ldc 2
    //   27: monitorexit
    //   28: iconst_0
    //   29: ireturn
    //   30: aload_0
    //   31: monitorexit
    //   32: getstatic 28	com/tencent/mobileqq/ark/debug/JSDebuggerSoLoader:b	Z
    //   35: ifeq +20 -> 55
    //   38: iconst_2
    //   39: invokestatic 100	com/tencent/mobileqq/ark/debug/JSDebuggerSoLoader:b	(I)V
    //   42: ldc 87
    //   44: iconst_2
    //   45: ldc 183
    //   47: invokestatic 181	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   50: ldc 2
    //   52: monitorexit
    //   53: iconst_1
    //   54: ireturn
    //   55: iconst_0
    //   56: invokestatic 100	com/tencent/mobileqq/ark/debug/JSDebuggerSoLoader:b	(I)V
    //   59: invokestatic 129	com/tencent/mobileqq/ark/debug/JSDebuggerSoLoader:a	()Ljava/lang/String;
    //   62: astore_0
    //   63: invokestatic 185	com/tencent/mobileqq/ark/debug/JSDebuggerSoLoader:b	()Ljava/lang/String;
    //   66: astore_1
    //   67: aload_0
    //   68: invokestatic 54	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   71: ifne +381 -> 452
    //   74: aload_1
    //   75: invokestatic 54	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   78: ifeq +6 -> 84
    //   81: goto +371 -> 452
    //   84: aload_0
    //   85: invokestatic 187	com/tencent/mobileqq/ark/debug/JSDebuggerSoLoader:c	(Ljava/lang/String;)V
    //   88: new 68	java/lang/StringBuilder
    //   91: dup
    //   92: invokespecial 69	java/lang/StringBuilder:<init>	()V
    //   95: astore_2
    //   96: aload_2
    //   97: aload_0
    //   98: invokevirtual 78	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   101: pop
    //   102: aload_2
    //   103: ldc 189
    //   105: invokevirtual 78	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   108: pop
    //   109: new 71	java/io/File
    //   112: dup
    //   113: aload_2
    //   114: invokevirtual 85	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   117: invokespecial 139	java/io/File:<init>	(Ljava/lang/String;)V
    //   120: astore_2
    //   121: aload_2
    //   122: invokevirtual 142	java/io/File:exists	()Z
    //   125: ifeq +53 -> 178
    //   128: new 68	java/lang/StringBuilder
    //   131: dup
    //   132: invokespecial 69	java/lang/StringBuilder:<init>	()V
    //   135: astore_1
    //   136: aload_1
    //   137: ldc 191
    //   139: invokevirtual 78	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   142: pop
    //   143: aload_1
    //   144: aload_2
    //   145: invokevirtual 194	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   148: pop
    //   149: ldc 87
    //   151: iconst_2
    //   152: aload_1
    //   153: invokevirtual 85	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   156: invokestatic 181	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   159: aload_0
    //   160: ldc 189
    //   162: invokestatic 120	com/tencent/mobileqq/ark/debug/JSDebuggerSoLoader:b	(Ljava/lang/String;Ljava/lang/String;)V
    //   165: iconst_2
    //   166: invokestatic 100	com/tencent/mobileqq/ark/debug/JSDebuggerSoLoader:b	(I)V
    //   169: iconst_1
    //   170: putstatic 28	com/tencent/mobileqq/ark/debug/JSDebuggerSoLoader:b	Z
    //   173: ldc 2
    //   175: monitorexit
    //   176: iconst_1
    //   177: ireturn
    //   178: getstatic 35	com/tencent/mobileqq/ark/debug/JSDebuggerSoLoader:jdField_a_of_type_JavaUtilMap	Ljava/util/Map;
    //   181: ldc 13
    //   183: invokeinterface 200 2 0
    //   188: checkcast 202	android/util/Pair
    //   191: astore_2
    //   192: aload_2
    //   193: ifnull +241 -> 434
    //   196: aload_2
    //   197: getfield 205	android/util/Pair:second	Ljava/lang/Object;
    //   200: checkcast 207	java/lang/CharSequence
    //   203: invokestatic 54	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   206: ifeq +6 -> 212
    //   209: goto +225 -> 434
    //   212: aload_1
    //   213: invokestatic 187	com/tencent/mobileqq/ark/debug/JSDebuggerSoLoader:c	(Ljava/lang/String;)V
    //   216: new 68	java/lang/StringBuilder
    //   219: dup
    //   220: invokespecial 69	java/lang/StringBuilder:<init>	()V
    //   223: astore_3
    //   224: aload_3
    //   225: aload_1
    //   226: invokevirtual 78	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   229: pop
    //   230: aload_3
    //   231: aload_2
    //   232: getfield 205	android/util/Pair:second	Ljava/lang/Object;
    //   235: checkcast 209	java/lang/String
    //   238: invokevirtual 78	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   241: pop
    //   242: aload_3
    //   243: invokevirtual 85	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   246: astore 4
    //   248: new 71	java/io/File
    //   251: dup
    //   252: aload 4
    //   254: invokespecial 139	java/io/File:<init>	(Ljava/lang/String;)V
    //   257: invokevirtual 142	java/io/File:exists	()Z
    //   260: ifeq +52 -> 312
    //   263: aload_1
    //   264: aload_2
    //   265: getfield 205	android/util/Pair:second	Ljava/lang/Object;
    //   268: checkcast 209	java/lang/String
    //   271: aload_2
    //   272: getfield 205	android/util/Pair:second	Ljava/lang/Object;
    //   275: checkcast 209	java/lang/String
    //   278: aload_0
    //   279: invokestatic 126	com/tencent/mobileqq/ark/debug/JSDebuggerSoLoader:b	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Z
    //   282: ifeq +30 -> 312
    //   285: ldc 87
    //   287: iconst_2
    //   288: ldc 211
    //   290: invokestatic 181	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   293: iconst_3
    //   294: invokestatic 100	com/tencent/mobileqq/ark/debug/JSDebuggerSoLoader:b	(I)V
    //   297: aload_0
    //   298: ldc 189
    //   300: invokestatic 120	com/tencent/mobileqq/ark/debug/JSDebuggerSoLoader:b	(Ljava/lang/String;Ljava/lang/String;)V
    //   303: iconst_1
    //   304: putstatic 28	com/tencent/mobileqq/ark/debug/JSDebuggerSoLoader:b	Z
    //   307: ldc 2
    //   309: monitorexit
    //   310: iconst_1
    //   311: ireturn
    //   312: aload_2
    //   313: getfield 214	android/util/Pair:first	Ljava/lang/Object;
    //   316: checkcast 207	java/lang/CharSequence
    //   319: invokestatic 54	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   322: ifeq +21 -> 343
    //   325: bipush 7
    //   327: invokestatic 100	com/tencent/mobileqq/ark/debug/JSDebuggerSoLoader:b	(I)V
    //   330: ldc 87
    //   332: iconst_2
    //   333: ldc 216
    //   335: invokestatic 181	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   338: ldc 2
    //   340: monitorexit
    //   341: iconst_0
    //   342: ireturn
    //   343: aload_2
    //   344: getfield 205	android/util/Pair:second	Ljava/lang/Object;
    //   347: checkcast 209	java/lang/String
    //   350: astore 5
    //   352: aload_1
    //   353: invokestatic 117	com/tencent/mobileqq/ark/debug/JSDebuggerSoLoader:b	(Ljava/lang/String;)V
    //   356: getstatic 24	com/tencent/mobileqq/ark/debug/JSDebuggerSoLoader:jdField_a_of_type_JavaLangObject	Ljava/lang/Object;
    //   359: astore_3
    //   360: aload_3
    //   361: monitorenter
    //   362: getstatic 26	com/tencent/mobileqq/ark/debug/JSDebuggerSoLoader:jdField_a_of_type_Boolean	Z
    //   365: ifne +57 -> 422
    //   368: iconst_1
    //   369: invokestatic 100	com/tencent/mobileqq/ark/debug/JSDebuggerSoLoader:b	(I)V
    //   372: getstatic 222	mqq/app/MobileQQ:sMobileQQ	Lmqq/app/MobileQQ;
    //   375: aconst_null
    //   376: invokevirtual 226	mqq/app/MobileQQ:waitAppRuntime	(Lmqq/app/BaseActivity;)Lmqq/app/AppRuntime;
    //   379: aload_2
    //   380: getfield 214	android/util/Pair:first	Ljava/lang/Object;
    //   383: checkcast 209	java/lang/String
    //   386: aconst_null
    //   387: aload 4
    //   389: new 228	com/tencent/mobileqq/ark/debug/JSDebuggerSoLoader$1
    //   392: dup
    //   393: aload_1
    //   394: aload 5
    //   396: aload_0
    //   397: invokespecial 231	com/tencent/mobileqq/ark/debug/JSDebuggerSoLoader$1:<init>	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   400: invokestatic 236	com/tencent/mobileqq/ark/util/NetUtil:a	(Lmqq/app/AppRuntime;Ljava/lang/String;Ljava/util/Map;Ljava/lang/String;Lcom/tencent/mobileqq/ark/delegate/IHTTPDownloadCallback;)V
    //   403: iconst_1
    //   404: putstatic 26	com/tencent/mobileqq/ark/debug/JSDebuggerSoLoader:jdField_a_of_type_Boolean	Z
    //   407: ldc 87
    //   409: iconst_2
    //   410: ldc 238
    //   412: invokestatic 181	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   415: aload_3
    //   416: monitorexit
    //   417: ldc 2
    //   419: monitorexit
    //   420: iconst_1
    //   421: ireturn
    //   422: aload_3
    //   423: monitorexit
    //   424: ldc 2
    //   426: monitorexit
    //   427: iconst_0
    //   428: ireturn
    //   429: astore_0
    //   430: aload_3
    //   431: monitorexit
    //   432: aload_0
    //   433: athrow
    //   434: bipush 7
    //   436: invokestatic 100	com/tencent/mobileqq/ark/debug/JSDebuggerSoLoader:b	(I)V
    //   439: ldc 87
    //   441: iconst_2
    //   442: ldc 240
    //   444: invokestatic 181	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   447: ldc 2
    //   449: monitorexit
    //   450: iconst_0
    //   451: ireturn
    //   452: bipush 9
    //   454: invokestatic 100	com/tencent/mobileqq/ark/debug/JSDebuggerSoLoader:b	(I)V
    //   457: ldc 87
    //   459: iconst_2
    //   460: ldc 242
    //   462: invokestatic 181	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   465: ldc 2
    //   467: monitorexit
    //   468: iconst_0
    //   469: ireturn
    //   470: astore_1
    //   471: aload_0
    //   472: monitorexit
    //   473: aload_1
    //   474: athrow
    //   475: astore_0
    //   476: ldc 2
    //   478: monitorexit
    //   479: aload_0
    //   480: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   429	43	0	localObject2	Object
    //   475	5	0	localObject3	Object
    //   66	328	1	localObject4	Object
    //   470	4	1	localObject5	Object
    //   95	285	2	localObject6	Object
    //   246	142	4	str1	String
    //   350	45	5	str2	String
    // Exception table:
    //   from	to	target	type
    //   362	417	429	finally
    //   422	424	429	finally
    //   430	432	429	finally
    //   9	25	470	finally
    //   30	32	470	finally
    //   471	473	470	finally
    //   3	9	475	finally
    //   32	50	475	finally
    //   55	81	475	finally
    //   84	173	475	finally
    //   178	192	475	finally
    //   196	209	475	finally
    //   212	307	475	finally
    //   312	338	475	finally
    //   343	362	475	finally
    //   432	434	475	finally
    //   434	447	475	finally
    //   452	465	475	finally
    //   473	475	475	finally
  }
  
  private static boolean b(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    if ((!TextUtils.isEmpty(paramString1)) && (!TextUtils.isEmpty(paramString2)) && (!TextUtils.isEmpty(paramString3)) && (!TextUtils.isEmpty(paramString4))) {}
    for (;;)
    {
      try
      {
        b(paramString4);
        Object localObject = new StringBuilder();
        ((StringBuilder)localObject).append(paramString1);
        ((StringBuilder)localObject).append(paramString2);
        paramString2 = new File(((StringBuilder)localObject).toString());
        if (paramString2.exists())
        {
          localObject = MD5FileUtil.a(paramString2);
          if ((!TextUtils.isEmpty((CharSequence)localObject)) && (((String)localObject).equals(paramString3)))
          {
            FileUtils.uncompressZip(paramString2.getAbsolutePath(), paramString1, false);
            paramString2 = new StringBuilder();
            paramString2.append(paramString1);
            paramString2.append("libarkDebuggerJSImpl.so");
            boolean bool = new File(paramString2.toString()).exists();
            if (!bool) {
              break label476;
            }
            paramString2 = new StringBuilder();
            paramString2.append(paramString1);
            paramString2.append("libarkDebuggerJSImpl.so");
            paramString2 = paramString2.toString();
            paramString3 = new StringBuilder();
            paramString3.append(paramString4);
            paramString3.append("libarkDebuggerJSImpl.so");
            if (FileUtils.copyFile(paramString2, paramString3.toString()))
            {
              paramString2 = new StringBuilder();
              paramString2.append("testZipAndUnzip.copyFile succeed:");
              paramString2.append("libarkDebuggerJSImpl.so");
              QLog.i("JSDebuggerSoLoader", 2, paramString2.toString());
              break label476;
            }
            paramString2 = new StringBuilder();
            paramString2.append("testZipAndUnzip.copyFile failed:");
            paramString2.append("libarkDebuggerJSImpl.so");
            QLog.i("JSDebuggerSoLoader", 2, paramString2.toString());
            i = 1;
            paramString2 = new StringBuilder();
            paramString2.append(paramString1);
            paramString2.append("libjsc_ark.so");
            if (new File(paramString2.toString()).exists())
            {
              paramString2 = new StringBuilder();
              paramString2.append(paramString1);
              paramString2.append("libjsc_ark.so");
              paramString1 = paramString2.toString();
              paramString2 = new StringBuilder();
              paramString2.append(paramString4);
              paramString2.append("libjsc_ark.so");
              if (FileUtils.copyFile(paramString1, paramString2.toString()))
              {
                paramString1 = new StringBuilder();
                paramString1.append("testZipAndUnzip.copyFile succeed:");
                paramString1.append("libjsc_ark.so");
                QLog.i("JSDebuggerSoLoader", 2, paramString1.toString());
              }
              else
              {
                paramString1 = new StringBuilder();
                paramString1.append("testZipAndUnzip.copyFile failed:");
                paramString1.append("libjsc_ark.so");
                QLog.i("JSDebuggerSoLoader", 2, paramString1.toString());
                i = 1;
              }
              if (i == 0) {
                return true;
              }
            }
          }
        }
      }
      catch (Exception paramString1)
      {
        QLog.e("JSDebuggerSoLoader", 1, paramString1, new Object[0]);
      }
      return false;
      label476:
      int i = 0;
    }
  }
  
  private static void c()
  {
    Object localObject1 = (ArkAIKeyWordConfBean)((IArkConfig)QRoute.api(IArkConfig.class)).loadConfig(ArkAIKeyWordConfBean.class);
    if (localObject1 == null)
    {
      QLog.i("JSDebuggerSoLoader", 1, "updateJSDebuggerConfig, confBean is null");
      return;
    }
    localObject1 = ((ArkAIKeyWordConfBean)localObject1).a();
    if (localObject1 == null)
    {
      QLog.i("JSDebuggerSoLoader", 1, "updateJSDebuggerConfig, aiKeywordConfig is null");
      return;
    }
    localObject1 = ((AiKeywordConfig)localObject1).c;
    if (localObject1 != null)
    {
      jdField_a_of_type_JavaUtilMap.clear();
      localObject1 = ((ArrayList)localObject1).iterator();
      while (((Iterator)localObject1).hasNext())
      {
        Object localObject2 = (ArkJsdebuggerDownload)((Iterator)localObject1).next();
        if (localObject2 != null)
        {
          String str1 = ((ArkJsdebuggerDownload)localObject2).jdField_a_of_type_JavaLangString;
          String str2 = ((ArkJsdebuggerDownload)localObject2).b;
          localObject2 = ((ArkJsdebuggerDownload)localObject2).c;
          if ((str1 != null) && (!TextUtils.isEmpty((CharSequence)localObject2)) && (!TextUtils.isEmpty(str2))) {
            jdField_a_of_type_JavaUtilMap.put(str1, new Pair(str2, localObject2));
          }
        }
      }
      QLog.i("JSDebuggerSoLoader", 1, String.format("updateJSDebuggerConfig success.", new Object[0]));
    }
  }
  
  private static void c(String paramString)
  {
    if (!TextUtils.isEmpty(paramString)) {
      try
      {
        paramString = new File(paramString);
        if (!paramString.exists())
        {
          paramString.mkdirs();
          return;
        }
      }
      catch (Exception paramString)
      {
        QLog.e("JSDebuggerSoLoader", 1, paramString, new Object[0]);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.ark.debug.JSDebuggerSoLoader
 * JD-Core Version:    0.7.0.1
 */