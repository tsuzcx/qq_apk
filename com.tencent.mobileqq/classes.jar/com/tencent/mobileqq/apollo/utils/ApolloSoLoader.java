package com.tencent.mobileqq.apollo.utils;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Build;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.app.ToolAppRuntime;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.apollo.ApolloManager;
import com.tencent.mobileqq.apollo.aioChannel.ApolloCmdChannel;
import com.tencent.mobileqq.apollo.process.CmGameUtil;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.earlydownload.handler.ApolloJscHandler;
import com.tencent.mobileqq.earlydownload.handler.ApolloLibHandler;
import com.tencent.mobileqq.startup.step.UpdateArkSo;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.SOPreLoader;
import java.io.File;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicBoolean;
import ywt;

public class ApolloSoLoader
{
  public static long a;
  private static Runnable jdField_a_of_type_JavaLangRunnable = new ywt();
  public static StringBuilder a;
  public static CopyOnWriteArrayList a;
  private static AtomicBoolean jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean;
  private static boolean jdField_a_of_type_Boolean;
  public static final String[] a;
  public static long b;
  private static boolean b;
  public static final String[] b;
  public static final String[] c;
  public static final String[] d;
  
  static
  {
    jdField_a_of_type_ArrayOfJavaLangString = new String[] { "libgnustl_shared.so", "libicu_common.so", "libjsc.so", "libTcHevcDec.so" };
    jdField_b_of_type_ArrayOfJavaLangString = new String[] { "libv8.so" };
    c = new String[] { "libtinyskia.so", "libsava.so" };
    d = new String[] { "brick.js", "ticker.js", "scene.js", "game.js" };
    jdField_a_of_type_JavaLangStringBuilder = new StringBuilder(100);
    jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList = new CopyOnWriteArrayList();
    jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean(false);
  }
  
  private static String a(String paramString)
  {
    return SOPreLoader.a();
  }
  
  public static void a()
  {
    int j = 0;
    QLog.i("ApolloSoLoader", 1, "[delAllSoButJsc]");
    synchronized (SOPreLoader.a)
    {
      try
      {
        String str1 = SOPreLoader.a();
        String[] arrayOfString = c;
        int k = arrayOfString.length;
        int i = 0;
        String str2;
        while (i < k)
        {
          str2 = arrayOfString[i];
          FileUtils.d(str1 + "/" + str2);
          i += 1;
        }
        arrayOfString = d;
        k = arrayOfString.length;
        i = 0;
        while (i < k)
        {
          str2 = arrayOfString[i];
          FileUtils.d(str1 + "/" + str2);
          i += 1;
        }
        arrayOfString = jdField_b_of_type_ArrayOfJavaLangString;
        k = arrayOfString.length;
        i = j;
        while (i < k)
        {
          str2 = arrayOfString[i];
          FileUtils.d(str1 + "/" + str2);
          i += 1;
        }
        localObject2 = finally;
      }
      catch (Throwable localThrowable)
      {
        QLog.e("ApolloSoLoader", 1, localThrowable, new Object[0]);
        return;
      }
    }
  }
  
  public static void a(int paramInt)
  {
    try
    {
      Iterator localIterator = jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.iterator();
      while (localIterator.hasNext())
      {
        Object localObject2 = (WeakReference)localIterator.next();
        if (localObject2 != null)
        {
          localObject2 = (ApolloSoLoader.OnCmSoLoadCompleteCallback)((WeakReference)localObject2).get();
          if (localObject2 != null) {
            ((ApolloSoLoader.OnCmSoLoadCompleteCallback)localObject2).a(paramInt);
          }
        }
      }
    }
    finally {}
  }
  
  public static void a(ApolloSoLoader.OnCmSoLoadCompleteCallback paramOnCmSoLoadCompleteCallback)
  {
    if (paramOnCmSoLoadCompleteCallback == null) {}
    for (;;)
    {
      return;
      try
      {
        Iterator localIterator = jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.iterator();
        for (;;)
        {
          if (localIterator.hasNext())
          {
            WeakReference localWeakReference = (WeakReference)localIterator.next();
            if ((localWeakReference != null) && (paramOnCmSoLoadCompleteCallback == localWeakReference.get()))
            {
              QLog.i("ApolloSoLoader", 1, "already add, cb:" + paramOnCmSoLoadCompleteCallback);
              break;
            }
          }
        }
      }
      finally {}
      jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.add(new WeakReference(paramOnCmSoLoadCompleteCallback));
    }
  }
  
  public static void a(String paramString)
  {
    for (;;)
    {
      try
      {
        QLog.i("ApolloSoLoader", 1, "[loadSo], from:" + paramString + ",sLoadEngineLibDone:" + jdField_a_of_type_Boolean + ",sIsTaskRunning:" + jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get());
        boolean bool = jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.getAndSet(true);
        if (bool) {
          return;
        }
        if (jdField_a_of_type_Boolean)
        {
          a(0);
          jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(false);
          continue;
        }
        ThreadManager.remove(jdField_a_of_type_JavaLangRunnable);
      }
      finally {}
      ThreadManager.post(jdField_a_of_type_JavaLangRunnable, 5, null, true);
    }
  }
  
  private static void a(String[] paramArrayOfString)
  {
    for (;;)
    {
      int i;
      synchronized (SOPreLoader.a)
      {
        int j = paramArrayOfString.length;
        i = 0;
        if (i < j)
        {
          String str3 = paramArrayOfString[i];
          if (b(str3)) {
            break label100;
          }
          String str2 = SOPreLoader.a();
          String str1 = str2;
          if (a(str3)) {
            str1 = str2 + "/test";
          }
          System.load(new File(str1, str3).getAbsolutePath());
        }
      }
      return;
      label100:
      i += 1;
    }
  }
  
  public static boolean a()
  {
    return jdField_a_of_type_Boolean;
  }
  
  public static boolean a(String paramString)
  {
    return false;
  }
  
  private static boolean a(String[] paramArrayOfString)
  {
    if ((paramArrayOfString == null) || (paramArrayOfString.length == 0)) {
      return false;
    }
    String str1 = SOPreLoader.a();
    int j = paramArrayOfString.length;
    int i = 0;
    while (i < j)
    {
      String str2 = paramArrayOfString[i];
      File localFile = new File(str1, str2);
      if ((localFile == null) || (!localFile.exists()) || (!localFile.isFile()))
      {
        QLog.w("ApolloSoLoader", 1, "lib " + str2 + " NOT exist.");
        return false;
      }
      i += 1;
    }
    return true;
  }
  
  /* Error */
  public static void b(ApolloSoLoader.OnCmSoLoadCompleteCallback paramOnCmSoLoadCompleteCallback)
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: aload_0
    //   4: ifnull +14 -> 18
    //   7: getstatic 63	com/tencent/mobileqq/apollo/utils/ApolloSoLoader:jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList	Ljava/util/concurrent/CopyOnWriteArrayList;
    //   10: invokevirtual 228	java/util/concurrent/CopyOnWriteArrayList:size	()I
    //   13: istore_1
    //   14: iload_1
    //   15: ifne +7 -> 22
    //   18: ldc 2
    //   20: monitorexit
    //   21: return
    //   22: getstatic 63	com/tencent/mobileqq/apollo/utils/ApolloSoLoader:jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList	Ljava/util/concurrent/CopyOnWriteArrayList;
    //   25: invokevirtual 122	java/util/concurrent/CopyOnWriteArrayList:iterator	()Ljava/util/Iterator;
    //   28: astore_2
    //   29: aload_2
    //   30: invokeinterface 128 1 0
    //   35: ifeq -17 -> 18
    //   38: aload_2
    //   39: invokeinterface 132 1 0
    //   44: checkcast 134	java/lang/ref/WeakReference
    //   47: astore_3
    //   48: aload_3
    //   49: ifnull -20 -> 29
    //   52: aload_0
    //   53: aload_3
    //   54: invokevirtual 137	java/lang/ref/WeakReference:get	()Ljava/lang/Object;
    //   57: if_acmpne -28 -> 29
    //   60: getstatic 63	com/tencent/mobileqq/apollo/utils/ApolloSoLoader:jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList	Ljava/util/concurrent/CopyOnWriteArrayList;
    //   63: aload_3
    //   64: invokevirtual 230	java/util/concurrent/CopyOnWriteArrayList:remove	(Ljava/lang/Object;)Z
    //   67: pop
    //   68: invokestatic 233	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   71: ifeq -53 -> 18
    //   74: ldc 88
    //   76: iconst_2
    //   77: iconst_2
    //   78: anewarray 4	java/lang/Object
    //   81: dup
    //   82: iconst_0
    //   83: ldc 235
    //   85: aastore
    //   86: dup
    //   87: iconst_1
    //   88: aload_0
    //   89: aastore
    //   90: invokestatic 238	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;I[Ljava/lang/Object;)V
    //   93: goto -75 -> 18
    //   96: astore_0
    //   97: ldc 2
    //   99: monitorexit
    //   100: aload_0
    //   101: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	102	0	paramOnCmSoLoadCompleteCallback	ApolloSoLoader.OnCmSoLoadCompleteCallback
    //   13	2	1	i	int
    //   28	11	2	localIterator	Iterator
    //   47	17	3	localWeakReference	WeakReference
    // Exception table:
    //   from	to	target	type
    //   7	14	96	finally
    //   22	29	96	finally
    //   29	48	96	finally
    //   52	93	96	finally
  }
  
  private static boolean b(String paramString)
  {
    if (!AppSetting.f) {}
    while (!"libsava.so".equals(paramString)) {
      return false;
    }
    System.loadLibrary("sava");
    QLog.i("ApolloSoLoader", 1, "sava is loaded for asan test.");
    return true;
  }
  
  private static void d(int paramInt)
  {
    int i = 0;
    synchronized (SOPreLoader.a)
    {
      try
      {
        File localFile1 = new File(SOPreLoader.a(paramInt));
        String str = SOPreLoader.a();
        if (localFile1.exists())
        {
          File[] arrayOfFile = localFile1.listFiles();
          int j = arrayOfFile.length;
          while (i < j)
          {
            File localFile2 = arrayOfFile[i];
            FileUtils.d(localFile2.getAbsolutePath(), str + localFile2.getName());
            i += 1;
          }
          FileUtils.a(localFile1.getAbsolutePath());
          QLog.i("ApolloSoLoader", 1, "[tryCopyFromTmpDir], done. type:" + paramInt);
        }
      }
      catch (Throwable localThrowable)
      {
        for (;;)
        {
          QLog.e("ApolloSoLoader", 1, localThrowable, new Object[0]);
        }
      }
      return;
    }
  }
  
  private static void e()
  {
    try
    {
      File localFile = new File(BaseApplicationImpl.getContext().getFilesDir().getParent() + "/txlib/libsava.so");
      if ((localFile.exists()) && (localFile.delete())) {
        QLog.i("ApolloSoLoader", 1, "success to del old so.");
      }
      return;
    }
    catch (Throwable localThrowable)
    {
      QLog.e("ApolloSoLoader", 1, localThrowable, new Object[0]);
    }
  }
  
  private static void e(int paramInt)
  {
    QLog.i("ApolloSoLoader", 1, "[startDownload], libType:" + paramInt);
    if (paramInt == 0) {
      if (System.currentTimeMillis() - jdField_b_of_type_Long < 120000L) {
        QLog.i("ApolloSoLoader", 1, "[startDownload], it's not time for downloading jsc.");
      }
    }
    while (paramInt != 1)
    {
      return;
      jdField_b_of_type_Long = System.currentTimeMillis();
      ApolloJscHandler.a();
      return;
    }
    if (System.currentTimeMillis() - jdField_a_of_type_Long < 120000L)
    {
      QLog.i("ApolloSoLoader", 1, "[startDownload], it's not time for downloading sava.");
      return;
    }
    jdField_a_of_type_Long = System.currentTimeMillis();
    ApolloLibHandler.a();
  }
  
  private static void f()
  {
    try
    {
      File localFile = new File(AppConstants.aJ + "pddata/prd/early", "android.qq.apollo.js.760g3");
      if (!localFile.exists())
      {
        e(1);
        return;
      }
      if (!jdField_b_of_type_Boolean)
      {
        SOPreLoader.a(localFile.getAbsolutePath(), 1);
        jdField_b_of_type_Boolean = true;
        QLog.i("ApolloSoLoader", 1, "[tryUnzipFromBackup], unzip success.");
        return;
      }
    }
    catch (Throwable localThrowable)
    {
      QLog.e("ApolloSoLoader", 1, "[tryUnzipFromBackup]," + localThrowable);
    }
  }
  
  private static void g() {}
  
  private static void h()
  {
    Object localObject = BaseApplicationImpl.getApplication();
    if (localObject != null)
    {
      localObject = ((BaseApplicationImpl)localObject).getRuntime();
      if (!(localObject instanceof QQAppInterface)) {
        break label34;
      }
      ApolloCmdChannel.getChannel((QQAppInterface)localObject).checkSetNative();
    }
    for (;;)
    {
      ApolloManager.a();
      return;
      label34:
      if ((localObject instanceof ToolAppRuntime))
      {
        localObject = CmGameUtil.a();
        if (localObject != null) {
          ((ApolloCmdChannel)localObject).checkSetNative();
        }
      }
    }
  }
  
  private static boolean h()
  {
    try
    {
      SharedPreferences localSharedPreferences = BaseApplicationImpl.getApplication().getSharedPreferences("apollo_sp", 0);
      if (localSharedPreferences.getBoolean("is_handle_reinstall_7.6.3", false)) {
        return false;
      }
      String str = localSharedPreferences.getString("res_name", "nothing");
      if (!str.equals("android.qq.apollo.js.760g3"))
      {
        QLog.i("ApolloSoLoader", 1, "oldRes:" + str + ",newRes:" + "android.qq.apollo.js.760g3");
        if (i()) {}
        for (;;)
        {
          localSharedPreferences.edit().putBoolean("is_handle_reinstall_7.6.3", true).commit();
          return true;
          a();
        }
      }
      return false;
    }
    catch (Throwable localThrowable)
    {
      QLog.e("ApolloSoLoader", 1, localThrowable, new Object[0]);
      a();
    }
  }
  
  private static boolean i()
  {
    String str1 = SOPreLoader.a() + "libsava.so" + "." + "android.qq.apollo.js.760g3";
    if (new File(str1).exists())
    {
      QLog.i("ApolloSoLoader", 1, "Bingo, the latest sava has been predownloaded.");
      String str2 = SOPreLoader.a() + "libsava.so";
      FileUtils.d(str2);
      if (!FileUtils.c(str1, str2))
      {
        QLog.w("ApolloSoLoader", 1, "fail to rename.");
        return false;
      }
      return true;
    }
    QLog.i("ApolloSoLoader", 1, "It's a pity that the latest sava hasn't been predownloaded.");
    return false;
  }
  
  private static boolean j()
  {
    try
    {
      if (Build.CPU_ABI.contains("x86")) {
        return false;
      }
      if (UpdateArkSo.a(BaseApplicationImpl.getContext(), "png-armeabi-v7a"))
      {
        if (a(jdField_b_of_type_ArrayOfJavaLangString)) {
          a(jdField_b_of_type_ArrayOfJavaLangString);
        }
        for (;;)
        {
          a(c);
          SharedPreferences localSharedPreferences = BaseApplicationImpl.getApplication().getSharedPreferences("apollo_sp", 0);
          if (localSharedPreferences == null) {
            break;
          }
          localSharedPreferences.edit().putString("res_name", "android.qq.apollo.js.760g3").commit();
          break;
          a(jdField_a_of_type_ArrayOfJavaLangString);
        }
      }
      return false;
    }
    catch (Throwable localThrowable)
    {
      QLog.e("ApolloSoLoader", 1, "[loadAllSo], Something unexpected happened." + localThrowable);
      f();
    }
    return true;
  }
  
  private static boolean k()
  {
    if (!a(c)) {}
    while (!a(d)) {
      return false;
    }
    return true;
  }
  
  private static boolean l()
  {
    if (a(jdField_a_of_type_ArrayOfJavaLangString))
    {
      QLog.i("ApolloSoLoader", 1, "jsc exists at new path.");
      return true;
    }
    String str1 = BaseApplicationImpl.getContext().getFilesDir().getParent() + "/txlib/";
    ??? = jdField_a_of_type_ArrayOfJavaLangString;
    int j = ???.length;
    int i = 0;
    for (;;)
    {
      Object localObject3;
      if (i < j)
      {
        localObject3 = new File(str1, ???[i]);
        if ((localObject3 != null) && (((File)localObject3).exists()) && (((File)localObject3).isFile())) {}
      }
      else
      {
        for (i = 0;; i = 1)
        {
          if (i != 0)
          {
            localObject3 = SOPreLoader.a();
            try
            {
              synchronized (SOPreLoader.a)
              {
                String[] arrayOfString = jdField_a_of_type_ArrayOfJavaLangString;
                j = arrayOfString.length;
                i = 0;
                while (i < j)
                {
                  String str2 = arrayOfString[i];
                  FileUtils.d(str1 + "/" + str2, (String)localObject3 + str2);
                  i += 1;
                }
                QLog.i("ApolloSoLoader", 1, "copy jsc from old path.");
                return true;
              }
              QLog.i("ApolloSoLoader", 1, "jsc NOT exists at old path.");
            }
            catch (Throwable localThrowable)
            {
              QLog.e("ApolloSoLoader", 1, localThrowable, new Object[0]);
              return false;
            }
          }
          return false;
        }
      }
      i += 1;
    }
  }
  
  private static boolean m()
  {
    long l1 = System.currentTimeMillis();
    try
    {
      if (TextUtils.isEmpty(ApolloManager.g)) {
        ApolloManager.g = FileUtils.b(new File(a("brick.js"), "brick.js"));
      }
      if (TextUtils.isEmpty(ApolloManager.h)) {
        ApolloManager.h = FileUtils.b(new File(a("ticker.js"), "ticker.js"));
      }
      if (TextUtils.isEmpty(ApolloManager.i)) {
        ApolloManager.i = FileUtils.b(new File(a("scene.js"), "scene.js"));
      }
      if (TextUtils.isEmpty(ApolloManager.j)) {
        ApolloManager.j = FileUtils.b(new File(a("game.js"), "game.js"));
      }
      return true;
    }
    catch (Throwable localThrowable)
    {
      QLog.e("ApolloSoLoader", 1, "[initScriptLib]," + localThrowable);
      return false;
    }
    finally
    {
      long l2 = System.currentTimeMillis();
      QLog.i("ApolloSoLoader", 1, "[initScriptLib], costT:" + (l2 - l1));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.utils.ApolloSoLoader
 * JD-Core Version:    0.7.0.1
 */