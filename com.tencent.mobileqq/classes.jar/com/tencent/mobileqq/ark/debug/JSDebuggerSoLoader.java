package com.tencent.mobileqq.ark.debug;

import android.content.Context;
import android.text.TextUtils;
import android.util.Pair;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.ark.ArkAppCGI;
import com.tencent.mobileqq.ark.ArkAppCenter;
import com.tencent.mobileqq.config.business.ArkConfBean;
import com.tencent.mobileqq.config.business.ArkConfBean.ArkAIKeyWordConfBean;
import com.tencent.mobileqq.config.business.ArkConfProcessor;
import com.tencent.mobileqq.config.business.ArkManageConfig.AiKeywordConfig;
import com.tencent.mobileqq.config.business.ArkManageConfig.ArkJsdebuggerDownload;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqprotect.singleupdate.MD5FileUtil;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class JSDebuggerSoLoader
{
  private static int jdField_a_of_type_Int;
  private static JSDebuggerSoLoader.StatusListener jdField_a_of_type_ComTencentMobileqqArkDebugJSDebuggerSoLoader$StatusListener = null;
  private static Object jdField_a_of_type_JavaLangObject;
  private static Runnable jdField_a_of_type_JavaLangRunnable = new JSDebuggerSoLoader.3();
  private static String jdField_a_of_type_JavaLangString = "";
  private static Map<String, Pair<String, String>> jdField_a_of_type_JavaUtilMap;
  private static boolean jdField_a_of_type_Boolean;
  private static boolean b;
  
  static
  {
    jdField_a_of_type_JavaLangObject = new Object();
    jdField_a_of_type_Boolean = false;
    b = false;
    jdField_a_of_type_Int = 1;
    jdField_a_of_type_JavaUtilMap = new HashMap();
  }
  
  public static String a()
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
    if (!TextUtils.isEmpty(str)) {
      return str + "temp/";
    }
    return "";
  }
  
  private static void b()
  {
    b = false;
  }
  
  private static void b(int paramInt)
  {
    if (jdField_a_of_type_ComTencentMobileqqArkDebugJSDebuggerSoLoader$StatusListener != null) {
      jdField_a_of_type_ComTencentMobileqqArkDebugJSDebuggerSoLoader$StatusListener.a(paramInt);
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
      ArkAppCenter.a(new JSDebuggerSoLoader.2(paramString1, paramString2));
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
        if (b)
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
    Object localObject5;
    if ((!TextUtils.isEmpty(str1)) && (!TextUtils.isEmpty(str2)))
    {
      c(str1);
      localObject5 = new File(str1 + "libarkDebuggerJSImpl.so");
      if (((File)localObject5).exists())
      {
        QLog.i("JSDebuggerSoLoader", 2, "tryStartDownload.js debugger so exists:" + localObject5);
        b(str1, "libarkDebuggerJSImpl.so");
        b(2);
        bool1 = bool2;
        break label565;
      }
    }
    label565:
    for (;;)
    {
      b = bool1;
      break;
      localObject5 = (Pair)jdField_a_of_type_JavaUtilMap.get("");
      if ((localObject5 != null) && (!TextUtils.isEmpty((CharSequence)((Pair)localObject5).second)))
      {
        c(str2);
        String str3 = str2 + (String)((Pair)localObject5).second;
        if ((new File(str3).exists()) && (b(str2, (String)((Pair)localObject5).second, (String)((Pair)localObject5).second, str1)))
        {
          QLog.i("JSDebuggerSoLoader", 2, "tryStartDownload.testZipAndUnzip 1 succeed");
          b(3);
          b(str1, "libarkDebuggerJSImpl.so");
          bool1 = true;
          break label568;
        }
        if (!TextUtils.isEmpty((CharSequence)((Pair)localObject5).first))
        {
          ??? = (QQAppInterface)BaseApplicationImpl.sApplication.getRuntime();
          if (??? != null)
          {
            ??? = (ArkAppCenter)((QQAppInterface)???).getManager(QQManagerFactory.ARK_APP_CENTER_MANAGER);
            if (??? != null)
            {
              ArkAppCGI localArkAppCGI = ((ArkAppCenter)???).a();
              if (localArkAppCGI != null)
              {
                String str4 = (String)((Pair)localObject5).second;
                b(str2);
                for (;;)
                {
                  synchronized (jdField_a_of_type_JavaLangObject)
                  {
                    if (!jdField_a_of_type_Boolean)
                    {
                      b(1);
                      localArkAppCGI.b((String)((Pair)localObject5).first, 0L, new JSDebuggerSoLoader.1(str3, str2, str4, str1));
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
              break label571;
            }
            QLog.i("JSDebuggerSoLoader", 2, "tryStartDownload.ArkAppCenter is null");
            break label571;
          }
          QLog.i("JSDebuggerSoLoader", 2, "tryStartDownload.QQAppInterface is null");
          break label571;
        }
        b(7);
        QLog.i("JSDebuggerSoLoader", 2, "tryStartDownload.manage URL is null");
        break label571;
      }
      b(7);
      QLog.i("JSDebuggerSoLoader", 2, "tryStartDownload.manage MD5 is null");
      bool1 = false;
      break label565;
      b(9);
      QLog.i("JSDebuggerSoLoader", 2, "tryStartDownload.necessary dir path is null");
      bool1 = bool3;
    }
    for (;;)
    {
      label568:
      break;
      label571:
      bool1 = false;
    }
  }
  
  private static boolean b(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    int i;
    if ((!TextUtils.isEmpty(paramString1)) && (!TextUtils.isEmpty(paramString2)) && (!TextUtils.isEmpty(paramString3)) && (!TextUtils.isEmpty(paramString4))) {
      try
      {
        b(paramString4);
        paramString2 = new File(paramString1 + paramString2);
        if (paramString2.exists())
        {
          String str = MD5FileUtil.a(paramString2);
          if ((!TextUtils.isEmpty(str)) && (str.equals(paramString3)))
          {
            FileUtils.a(paramString2.getAbsolutePath(), paramString1, false);
            paramString2 = new File(paramString1 + "libarkDebuggerJSImpl.so");
            if ((paramString2 == null) || (!paramString2.exists())) {
              break label406;
            }
            if (FileUtils.d(paramString1 + "libarkDebuggerJSImpl.so", paramString4 + "libarkDebuggerJSImpl.so")) {
              QLog.i("JSDebuggerSoLoader", 2, "testZipAndUnzip.copyFile succeed:" + "libarkDebuggerJSImpl.so");
            }
            for (i = 0;; i = 1)
            {
              paramString2 = new File(paramString1 + "libjsc_ark.so");
              if ((paramString2 == null) || (!paramString2.exists())) {
                break label404;
              }
              if (!FileUtils.d(paramString1 + "libjsc_ark.so", paramString4 + "libjsc_ark.so")) {
                break;
              }
              QLog.i("JSDebuggerSoLoader", 2, "testZipAndUnzip.copyFile succeed:" + "libjsc_ark.so");
              break label412;
              QLog.i("JSDebuggerSoLoader", 2, "testZipAndUnzip.copyFile failed:" + "libarkDebuggerJSImpl.so");
            }
            QLog.i("JSDebuggerSoLoader", 2, "testZipAndUnzip.copyFile failed:" + "libjsc_ark.so");
            i = 1;
          }
        }
      }
      catch (Exception paramString1)
      {
        QLog.e("JSDebuggerSoLoader", 1, paramString1, new Object[0]);
      }
    }
    label404:
    label406:
    label412:
    do
    {
      return false;
      i = 0;
      break;
    } while (i != 0);
    return true;
  }
  
  private static void c()
  {
    Object localObject1 = ArkConfProcessor.b(186).a();
    if (localObject1 == null) {
      ArkAppCenter.c("JSDebuggerSoLoader", "updateJSDebuggerConfig, confBean is null");
    }
    do
    {
      return;
      localObject1 = ((ArkConfBean.ArkAIKeyWordConfBean)localObject1).a();
      if (localObject1 == null)
      {
        ArkAppCenter.c("JSDebuggerSoLoader", String.format("updateJSDebuggerConfig, aiKeywordConfig is null", new Object[0]));
        return;
      }
      localObject1 = ((ArkManageConfig.AiKeywordConfig)localObject1).d;
    } while (localObject1 == null);
    jdField_a_of_type_JavaUtilMap.clear();
    localObject1 = ((ArrayList)localObject1).iterator();
    while (((Iterator)localObject1).hasNext())
    {
      Object localObject2 = (ArkManageConfig.ArkJsdebuggerDownload)((Iterator)localObject1).next();
      if (localObject2 != null)
      {
        String str1 = ((ArkManageConfig.ArkJsdebuggerDownload)localObject2).jdField_a_of_type_JavaLangString;
        String str2 = ((ArkManageConfig.ArkJsdebuggerDownload)localObject2).b;
        localObject2 = ((ArkManageConfig.ArkJsdebuggerDownload)localObject2).c;
        if ((str1 != null) && (!TextUtils.isEmpty((CharSequence)localObject2)) && (!TextUtils.isEmpty(str2))) {
          jdField_a_of_type_JavaUtilMap.put(str1, new Pair(str2, localObject2));
        }
      }
    }
    ArkAppCenter.c("JSDebuggerSoLoader", String.format("updateJSDebuggerConfig success.", new Object[0]));
  }
  
  private static void c(String paramString)
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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ark.debug.JSDebuggerSoLoader
 * JD-Core Version:    0.7.0.1
 */