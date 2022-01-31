package com.tencent.mobileqq.ark.debug;

import abfr;
import abfs;
import abft;
import android.content.Context;
import android.text.TextUtils;
import android.util.Pair;
import com.tencent.ark.ArkDispatchTask;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.ark.ArkAiAppCenter;
import com.tencent.mobileqq.ark.ArkAppCGI;
import com.tencent.mobileqq.ark.ArkAppCenter;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqprotect.singleupdate.MD5FileUtil;
import com.tencent.util.SOPreLoader;
import java.io.File;
import java.util.Map;

public class JSDebuggerSoLoader
{
  private static JSDebuggerSoLoader.StatusListener jdField_a_of_type_ComTencentMobileqqArkDebugJSDebuggerSoLoader$StatusListener;
  private static Object jdField_a_of_type_JavaLangObject = new Object();
  private static Runnable jdField_a_of_type_JavaLangRunnable = new abft();
  private static String jdField_a_of_type_JavaLangString = "";
  private static boolean jdField_a_of_type_Boolean;
  private static String jdField_b_of_type_JavaLangString = "";
  private static boolean jdField_b_of_type_Boolean;
  
  private static String a()
  {
    if (TextUtils.isEmpty(jdField_a_of_type_JavaLangString))
    {
      Object localObject = BaseApplicationImpl.getContext();
      if (localObject == null) {
        break label60;
      }
      localObject = ((Context)localObject).getFilesDir();
      if (localObject != null) {
        jdField_a_of_type_JavaLangString = ((File)localObject).getParent() + "/txlib/" + "arkdebugger/";
      }
    }
    for (;;)
    {
      return jdField_a_of_type_JavaLangString;
      label60:
      QLog.w("JSDebuggerSoLoader", 2, "getLibDirPath but context is null");
    }
  }
  
  public static void a(JSDebuggerSoLoader.StatusListener paramStatusListener)
  {
    try
    {
      jdField_a_of_type_ComTencentMobileqqArkDebugJSDebuggerSoLoader$StatusListener = paramStatusListener;
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
  
  private static void a(String paramString)
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
  
  private static String b()
  {
    String str = a();
    if (!TextUtils.isEmpty(str)) {
      return str + "temp/";
    }
    return "";
  }
  
  private static void b(int paramInt)
  {
    if (jdField_a_of_type_ComTencentMobileqqArkDebugJSDebuggerSoLoader$StatusListener != null) {
      jdField_a_of_type_ComTencentMobileqqArkDebugJSDebuggerSoLoader$StatusListener.a(paramInt);
    }
  }
  
  private static void b(String paramString)
  {
    if (!TextUtils.isEmpty(paramString)) {}
    try
    {
      paramString = new File(paramString);
      if (!paramString.exists()) {
        paramString.mkdirs();
      }
      return;
    }
    catch (Exception paramString)
    {
      QLog.e("JSDebuggerSoLoader", 1, paramString, new Object[0]);
    }
  }
  
  private static void b(String paramString1, String paramString2)
  {
    if ((!TextUtils.isEmpty(paramString1)) && (!TextUtils.isEmpty(paramString2))) {
      ArkAppCenter.a().post(new abfs(paramString1, paramString2));
    }
  }
  
  private static boolean b()
  {
    boolean bool3 = false;
    boolean bool1 = false;
    boolean bool2 = true;
    try
    {
      synchronized (jdField_a_of_type_JavaLangObject)
      {
        if (jdField_a_of_type_Boolean)
        {
          QLog.i("JSDebuggerSoLoader", 2, "tryStartDownload.sync failed");
          return bool1;
        }
        if (jdField_b_of_type_Boolean)
        {
          b(2);
          QLog.i("JSDebuggerSoLoader", 2, "tryStartDownload.has succeed");
          bool1 = true;
        }
      }
      b(0);
    }
    finally {}
    String str1 = a();
    String str2 = b();
    String str3;
    Object localObject5;
    if ((!TextUtils.isEmpty(str1)) && (!TextUtils.isEmpty(str2)))
    {
      b(str1);
      str3 = c();
      if (!TextUtils.isEmpty(str3))
      {
        localObject5 = new File(str1 + str3);
        if (((File)localObject5).exists())
        {
          QLog.i("JSDebuggerSoLoader", 2, "tryStartDownload.js debugger so exists:" + localObject5);
          b(str1, str3);
          b(2);
          bool1 = bool2;
          break label575;
        }
      }
    }
    for (;;)
    {
      jdField_b_of_type_Boolean = bool1;
      break;
      localObject5 = (Pair)ArkAiAppCenter.b.get(str3);
      if ((localObject5 != null) && (!TextUtils.isEmpty((CharSequence)((Pair)localObject5).second)))
      {
        b(str2);
        String str4 = str2 + str3;
        if ((new File(str4).exists()) && (b(str2, str3, (String)((Pair)localObject5).second, str1)))
        {
          QLog.i("JSDebuggerSoLoader", 2, "tryStartDownload.testZipAndUnzip 1 succeed");
          b(3);
          bool1 = true;
          break label578;
        }
        if (!TextUtils.isEmpty((CharSequence)((Pair)localObject5).first))
        {
          ??? = (QQAppInterface)BaseApplicationImpl.sApplication.getRuntime();
          if (??? != null)
          {
            ??? = (ArkAppCenter)((QQAppInterface)???).getManager(120);
            if (??? != null)
            {
              ArkAppCGI localArkAppCGI = ((ArkAppCenter)???).a();
              if (localArkAppCGI != null)
              {
                String str5 = (String)((Pair)localObject5).second;
                a(str2);
                for (;;)
                {
                  synchronized (jdField_a_of_type_JavaLangObject)
                  {
                    if (!jdField_a_of_type_Boolean)
                    {
                      b(1);
                      localArkAppCGI.b((String)((Pair)localObject5).first, 0L, new abfr(str4, str2, str3, str5, str1));
                      jdField_a_of_type_Boolean = true;
                      QLog.i("JSDebuggerSoLoader", 2, "tryStartDownload.downloadArkJSDebugger");
                      bool1 = true;
                    }
                  }
                  QLog.i("JSDebuggerSoLoader", 2, "tryStartDownload.downloadArkJSDebugger.sync failed");
                  bool1 = false;
                }
              }
              QLog.i("JSDebuggerSoLoader", 2, "tryStartDownload.ArkAppCGI is null");
              break label581;
            }
            QLog.i("JSDebuggerSoLoader", 2, "tryStartDownload.ArkAppCenter is null");
            break label581;
          }
          QLog.i("JSDebuggerSoLoader", 2, "tryStartDownload.QQAppInterface is null");
          break label581;
        }
        b(7);
        QLog.i("JSDebuggerSoLoader", 2, "tryStartDownload.manage URL is null");
        break label581;
      }
      b(7);
      QLog.i("JSDebuggerSoLoader", 2, "tryStartDownload.manage MD5 is null");
      break label586;
      b(8);
      QLog.i("JSDebuggerSoLoader", 2, "tryStartDownload.JSC MD5 is null");
      break label586;
      b(9);
      QLog.i("JSDebuggerSoLoader", 2, "tryStartDownload.necessary dir path is null");
      bool1 = bool3;
    }
    for (;;)
    {
      label575:
      break;
      for (;;)
      {
        label578:
        break;
        label581:
        bool1 = false;
      }
      label586:
      bool1 = false;
    }
  }
  
  /* Error */
  private static boolean b(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 6
    //   3: aload_0
    //   4: invokestatic 38	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   7: ifne +470 -> 477
    //   10: aload_1
    //   11: invokestatic 38	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   14: ifne +463 -> 477
    //   17: aload_2
    //   18: invokestatic 38	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   21: ifne +456 -> 477
    //   24: aload_3
    //   25: invokestatic 38	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   28: ifne +449 -> 477
    //   31: aload_3
    //   32: invokestatic 223	com/tencent/mobileqq/ark/debug/JSDebuggerSoLoader:a	(Ljava/lang/String;)V
    //   35: new 55	java/io/File
    //   38: dup
    //   39: new 52	java/lang/StringBuilder
    //   42: dup
    //   43: invokespecial 53	java/lang/StringBuilder:<init>	()V
    //   46: aload_0
    //   47: invokevirtual 62	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   50: aload_1
    //   51: invokevirtual 62	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   54: invokevirtual 69	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   57: invokespecial 100	java/io/File:<init>	(Ljava/lang/String;)V
    //   60: astore_1
    //   61: aload_1
    //   62: invokevirtual 104	java/io/File:exists	()Z
    //   65: ifeq +412 -> 477
    //   68: aload_1
    //   69: invokestatic 258	com/tencent/qqprotect/singleupdate/MD5FileUtil:a	(Ljava/io/File;)Ljava/lang/String;
    //   72: astore 5
    //   74: aload 5
    //   76: invokestatic 38	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   79: ifne +577 -> 656
    //   82: aload 5
    //   84: aload_2
    //   85: invokevirtual 262	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   88: ifeq +568 -> 656
    //   91: aload_1
    //   92: invokevirtual 265	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   95: aload_0
    //   96: iconst_0
    //   97: invokestatic 270	com/tencent/mobileqq/utils/FileUtils:a	(Ljava/lang/String;Ljava/lang/String;Z)V
    //   100: new 55	java/io/File
    //   103: dup
    //   104: new 52	java/lang/StringBuilder
    //   107: dup
    //   108: invokespecial 53	java/lang/StringBuilder:<init>	()V
    //   111: aload_0
    //   112: invokevirtual 62	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   115: ldc_w 272
    //   118: invokevirtual 62	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   121: invokevirtual 69	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   124: invokespecial 100	java/io/File:<init>	(Ljava/lang/String;)V
    //   127: astore 5
    //   129: aload 5
    //   131: invokevirtual 104	java/io/File:exists	()Z
    //   134: istore 4
    //   136: iload 4
    //   138: ifeq +506 -> 644
    //   141: new 274	java/io/FileInputStream
    //   144: dup
    //   145: aload 5
    //   147: invokespecial 277	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   150: astore_2
    //   151: aload_2
    //   152: astore_1
    //   153: aload 5
    //   155: invokevirtual 281	java/io/File:length	()J
    //   158: l2i
    //   159: newarray byte
    //   161: astore 5
    //   163: aload_2
    //   164: astore_1
    //   165: aload_2
    //   166: aload 5
    //   168: invokevirtual 285	java/io/FileInputStream:read	([B)I
    //   171: pop
    //   172: aload_2
    //   173: astore_1
    //   174: new 199	java/lang/String
    //   177: dup
    //   178: aload 5
    //   180: invokespecial 288	java/lang/String:<init>	([B)V
    //   183: astore 5
    //   185: aload 5
    //   187: astore_1
    //   188: aload_2
    //   189: ifnull +10 -> 199
    //   192: aload_2
    //   193: invokevirtual 291	java/io/FileInputStream:close	()V
    //   196: aload 5
    //   198: astore_1
    //   199: aload_1
    //   200: invokestatic 38	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   203: istore 4
    //   205: iload 4
    //   207: ifne +425 -> 632
    //   210: new 293	org/json/JSONObject
    //   213: dup
    //   214: aload_1
    //   215: invokespecial 294	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   218: ldc_w 296
    //   221: invokevirtual 300	org/json/JSONObject:optJSONObject	(Ljava/lang/String;)Lorg/json/JSONObject;
    //   224: astore_2
    //   225: aload 6
    //   227: astore_1
    //   228: aload_2
    //   229: ifnull +141 -> 370
    //   232: aload_2
    //   233: ldc_w 302
    //   236: invokevirtual 306	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   239: astore 5
    //   241: aload_2
    //   242: ldc_w 308
    //   245: invokevirtual 306	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   248: astore_2
    //   249: aload 6
    //   251: astore_1
    //   252: aload 5
    //   254: invokestatic 38	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   257: ifne +113 -> 370
    //   260: aload 6
    //   262: astore_1
    //   263: aload_2
    //   264: invokestatic 38	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   267: ifne +103 -> 370
    //   270: new 55	java/io/File
    //   273: dup
    //   274: new 52	java/lang/StringBuilder
    //   277: dup
    //   278: invokespecial 53	java/lang/StringBuilder:<init>	()V
    //   281: aload_0
    //   282: invokevirtual 62	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   285: aload 5
    //   287: invokevirtual 62	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   290: invokevirtual 69	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   293: invokespecial 100	java/io/File:<init>	(Ljava/lang/String;)V
    //   296: astore 5
    //   298: aload 6
    //   300: astore_1
    //   301: aload 5
    //   303: ifnull +67 -> 370
    //   306: aload 6
    //   308: astore_1
    //   309: aload 5
    //   311: invokevirtual 104	java/io/File:exists	()Z
    //   314: ifeq +56 -> 370
    //   317: aload 5
    //   319: invokestatic 258	com/tencent/qqprotect/singleupdate/MD5FileUtil:a	(Ljava/io/File;)Ljava/lang/String;
    //   322: astore_1
    //   323: aload_1
    //   324: invokestatic 38	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   327: ifne +228 -> 555
    //   330: aload_1
    //   331: aload_2
    //   332: invokevirtual 262	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   335: ifeq +220 -> 555
    //   338: aload 5
    //   340: invokevirtual 311	java/io/File:getName	()Ljava/lang/String;
    //   343: astore_1
    //   344: ldc 71
    //   346: iconst_2
    //   347: new 52	java/lang/StringBuilder
    //   350: dup
    //   351: invokespecial 53	java/lang/StringBuilder:<init>	()V
    //   354: ldc_w 313
    //   357: invokevirtual 62	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   360: aload_1
    //   361: invokevirtual 62	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   364: invokevirtual 69	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   367: invokestatic 163	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   370: aload_1
    //   371: invokestatic 38	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   374: ifne +246 -> 620
    //   377: new 52	java/lang/StringBuilder
    //   380: dup
    //   381: invokespecial 53	java/lang/StringBuilder:<init>	()V
    //   384: aload_0
    //   385: invokevirtual 62	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   388: aload_1
    //   389: invokevirtual 62	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   392: invokevirtual 69	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   395: new 52	java/lang/StringBuilder
    //   398: dup
    //   399: invokespecial 53	java/lang/StringBuilder:<init>	()V
    //   402: aload_3
    //   403: invokevirtual 62	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   406: aload_1
    //   407: invokevirtual 62	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   410: invokevirtual 69	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   413: invokestatic 317	com/tencent/mobileqq/utils/FileUtils:d	(Ljava/lang/String;Ljava/lang/String;)Z
    //   416: ifeq +175 -> 591
    //   419: ldc 71
    //   421: iconst_2
    //   422: new 52	java/lang/StringBuilder
    //   425: dup
    //   426: invokespecial 53	java/lang/StringBuilder:<init>	()V
    //   429: ldc_w 319
    //   432: invokevirtual 62	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   435: aload_1
    //   436: invokevirtual 62	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   439: invokevirtual 69	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   442: invokestatic 163	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   445: iconst_1
    //   446: ireturn
    //   447: astore_1
    //   448: ldc 71
    //   450: iconst_1
    //   451: aload_1
    //   452: iconst_0
    //   453: anewarray 4	java/lang/Object
    //   456: invokestatic 124	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/Throwable;[Ljava/lang/Object;)V
    //   459: aload 5
    //   461: astore_1
    //   462: goto -263 -> 199
    //   465: astore_0
    //   466: ldc 71
    //   468: iconst_1
    //   469: aload_0
    //   470: iconst_0
    //   471: anewarray 4	java/lang/Object
    //   474: invokestatic 124	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/Throwable;[Ljava/lang/Object;)V
    //   477: iconst_0
    //   478: ireturn
    //   479: astore 5
    //   481: aconst_null
    //   482: astore_2
    //   483: aload_2
    //   484: astore_1
    //   485: ldc 71
    //   487: iconst_1
    //   488: aload 5
    //   490: iconst_0
    //   491: anewarray 4	java/lang/Object
    //   494: invokestatic 124	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/Throwable;[Ljava/lang/Object;)V
    //   497: aload_2
    //   498: ifnull +7 -> 505
    //   501: aload_2
    //   502: invokevirtual 291	java/io/FileInputStream:close	()V
    //   505: aconst_null
    //   506: astore_1
    //   507: goto -308 -> 199
    //   510: astore_1
    //   511: ldc 71
    //   513: iconst_1
    //   514: aload_1
    //   515: iconst_0
    //   516: anewarray 4	java/lang/Object
    //   519: invokestatic 124	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/Throwable;[Ljava/lang/Object;)V
    //   522: aconst_null
    //   523: astore_1
    //   524: goto -325 -> 199
    //   527: astore_0
    //   528: aconst_null
    //   529: astore_1
    //   530: aload_1
    //   531: ifnull +7 -> 538
    //   534: aload_1
    //   535: invokevirtual 291	java/io/FileInputStream:close	()V
    //   538: aload_0
    //   539: athrow
    //   540: astore_1
    //   541: ldc 71
    //   543: iconst_1
    //   544: aload_1
    //   545: iconst_0
    //   546: anewarray 4	java/lang/Object
    //   549: invokestatic 124	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/Throwable;[Ljava/lang/Object;)V
    //   552: goto -14 -> 538
    //   555: ldc 71
    //   557: iconst_2
    //   558: ldc_w 321
    //   561: invokestatic 163	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   564: aload_0
    //   565: invokestatic 223	com/tencent/mobileqq/ark/debug/JSDebuggerSoLoader:a	(Ljava/lang/String;)V
    //   568: aload 6
    //   570: astore_1
    //   571: goto -201 -> 370
    //   574: astore_2
    //   575: aconst_null
    //   576: astore_1
    //   577: ldc 71
    //   579: iconst_1
    //   580: aload_2
    //   581: iconst_0
    //   582: anewarray 4	java/lang/Object
    //   585: invokestatic 124	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/Throwable;[Ljava/lang/Object;)V
    //   588: goto -218 -> 370
    //   591: ldc 71
    //   593: iconst_2
    //   594: new 52	java/lang/StringBuilder
    //   597: dup
    //   598: invokespecial 53	java/lang/StringBuilder:<init>	()V
    //   601: ldc_w 323
    //   604: invokevirtual 62	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   607: aload_1
    //   608: invokevirtual 62	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   611: invokevirtual 69	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   614: invokestatic 163	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   617: goto -140 -> 477
    //   620: ldc 71
    //   622: iconst_2
    //   623: ldc_w 325
    //   626: invokestatic 163	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   629: goto -152 -> 477
    //   632: ldc 71
    //   634: iconst_2
    //   635: ldc_w 327
    //   638: invokestatic 163	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   641: goto -164 -> 477
    //   644: ldc 71
    //   646: iconst_2
    //   647: ldc_w 329
    //   650: invokestatic 163	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   653: goto -176 -> 477
    //   656: ldc 71
    //   658: iconst_2
    //   659: ldc_w 331
    //   662: invokestatic 163	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   665: aload_1
    //   666: invokevirtual 120	java/io/File:delete	()Z
    //   669: pop
    //   670: goto -193 -> 477
    //   673: astore_2
    //   674: goto -97 -> 577
    //   677: astore_0
    //   678: goto -148 -> 530
    //   681: astore 5
    //   683: goto -200 -> 483
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	686	0	paramString1	String
    //   0	686	1	paramString2	String
    //   0	686	2	paramString3	String
    //   0	686	3	paramString4	String
    //   134	72	4	bool	boolean
    //   72	388	5	localObject1	Object
    //   479	10	5	localException1	Exception
    //   681	1	5	localException2	Exception
    //   1	568	6	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   192	196	447	java/io/IOException
    //   31	136	465	java/lang/Exception
    //   192	196	465	java/lang/Exception
    //   199	205	465	java/lang/Exception
    //   210	225	465	java/lang/Exception
    //   232	249	465	java/lang/Exception
    //   252	260	465	java/lang/Exception
    //   263	298	465	java/lang/Exception
    //   309	344	465	java/lang/Exception
    //   344	370	465	java/lang/Exception
    //   370	445	465	java/lang/Exception
    //   448	459	465	java/lang/Exception
    //   501	505	465	java/lang/Exception
    //   511	522	465	java/lang/Exception
    //   534	538	465	java/lang/Exception
    //   538	540	465	java/lang/Exception
    //   541	552	465	java/lang/Exception
    //   555	568	465	java/lang/Exception
    //   577	588	465	java/lang/Exception
    //   591	617	465	java/lang/Exception
    //   620	629	465	java/lang/Exception
    //   632	641	465	java/lang/Exception
    //   644	653	465	java/lang/Exception
    //   656	670	465	java/lang/Exception
    //   141	151	479	java/lang/Exception
    //   501	505	510	java/io/IOException
    //   141	151	527	finally
    //   534	538	540	java/io/IOException
    //   210	225	574	java/io/IOException
    //   232	249	574	java/io/IOException
    //   252	260	574	java/io/IOException
    //   263	298	574	java/io/IOException
    //   309	344	574	java/io/IOException
    //   555	568	574	java/io/IOException
    //   344	370	673	java/io/IOException
    //   153	163	677	finally
    //   165	172	677	finally
    //   174	185	677	finally
    //   485	497	677	finally
    //   153	163	681	java/lang/Exception
    //   165	172	681	java/lang/Exception
    //   174	185	681	java/lang/Exception
  }
  
  private static String c()
  {
    Object localObject;
    if (TextUtils.isEmpty(jdField_b_of_type_JavaLangString))
    {
      localObject = SOPreLoader.a();
      if (!TextUtils.isEmpty((CharSequence)localObject)) {
        localObject = (String)localObject + "libjsc.so";
      }
    }
    try
    {
      localObject = new File((String)localObject);
      if ((localObject != null) && (((File)localObject).exists()))
      {
        jdField_b_of_type_JavaLangString = MD5FileUtil.a((File)localObject);
        if (TextUtils.isEmpty(jdField_b_of_type_JavaLangString)) {
          jdField_b_of_type_JavaLangString = "";
        }
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        QLog.e("JSDebuggerSoLoader", 1, localException, new Object[0]);
      }
    }
    if (QLog.isColorLevel()) {
      QLog.i("JSDebuggerSoLoader", 2, "getCMShowJSCSoMd5:" + jdField_b_of_type_JavaLangString);
    }
    return jdField_b_of_type_JavaLangString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.ark.debug.JSDebuggerSoLoader
 * JD-Core Version:    0.7.0.1
 */