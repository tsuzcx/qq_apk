import com.tencent.ark.ArkDispatchTask;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.app.ToolAppRuntime;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.apollo.aioChannel.ApolloCmdChannel;
import com.tencent.mobileqq.apollo.utils.ApolloGameUtil;
import com.tencent.mobileqq.apollo.utils.ApolloSoLoader.1;
import com.tencent.mobileqq.apollo.utils.ApolloSoLoader.3;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.ark.ArkAppCenter;
import com.tencent.mobileqq.soload.LoadExtResult;
import com.tencent.mobileqq.startup.step.AVSoUtils;
import com.tencent.mobileqq.startup.step.UpdateArkSo;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicBoolean;

public class anmb
{
  private static Runnable jdField_a_of_type_JavaLangRunnable = new ApolloSoLoader.1();
  private static String jdField_a_of_type_JavaLangString;
  public static StringBuilder a;
  public static CopyOnWriteArrayList<WeakReference<anmd>> a;
  private static AtomicBoolean jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean;
  public static boolean a;
  public static final String[] a;
  private static boolean b;
  private static boolean c;
  private static boolean d;
  private static boolean e;
  
  static
  {
    jdField_a_of_type_ArrayOfJavaLangString = new String[] { "tinyskia", "sava" };
    c = true;
    jdField_a_of_type_Boolean = true;
    jdField_a_of_type_JavaLangStringBuilder = new StringBuilder(100);
    jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList = new CopyOnWriteArrayList();
    jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean(false);
  }
  
  private static String a(String paramString)
  {
    return jdField_a_of_type_JavaLangString;
  }
  
  public static void a() {}
  
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
          localObject2 = (anmd)((WeakReference)localObject2).get();
          if (localObject2 != null) {
            ((anmd)localObject2).a(paramInt);
          }
        }
      }
    }
    finally {}
  }
  
  public static void a(anmd paramanmd)
  {
    if (paramanmd == null) {}
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
            if ((localWeakReference != null) && (paramanmd == localWeakReference.get()))
            {
              QLog.i("ApolloSoLoader", 1, "already add, cb:" + paramanmd);
              break;
            }
          }
        }
      }
      finally {}
      jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.add(new WeakReference(paramanmd));
    }
  }
  
  public static void a(String paramString)
  {
    boolean bool2 = true;
    try
    {
      QLog.i("ApolloSoLoader", 1, "[loadSo], from:" + paramString + ",sLoadEngineLibDone:" + b + ",sIsTaskRunning:" + jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get());
      bool1 = jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.getAndSet(true);
      if (bool1) {}
      for (;;)
      {
        return;
        if (!b) {
          break;
        }
        a(0);
        jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(false);
      }
      if (BaseApplicationImpl.sProcessId != 1) {
        break label183;
      }
    }
    finally {}
    boolean bool1 = true;
    label106:
    c = bool1;
    if ((c) && (amme.a(BaseApplicationImpl.getContext()))) {}
    for (bool1 = bool2;; bool1 = false)
    {
      d = bool1;
      if ((d) && (jdField_a_of_type_Boolean))
      {
        anis.a(10);
        anis.a(10, 100);
        jdField_a_of_type_Boolean = false;
      }
      ThreadManager.removeJobFromThreadPool(jdField_a_of_type_JavaLangRunnable, 192);
      ThreadManager.excute(jdField_a_of_type_JavaLangRunnable, 192, null, true);
      break;
      label183:
      bool1 = false;
      break label106;
    }
  }
  
  public static boolean a()
  {
    return b;
  }
  
  public static boolean a(String paramString)
  {
    return false;
  }
  
  /* Error */
  public static void b(anmd paramanmd)
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: aload_0
    //   4: ifnull +14 -> 18
    //   7: getstatic 45	anmb:jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList	Ljava/util/concurrent/CopyOnWriteArrayList;
    //   10: invokevirtual 177	java/util/concurrent/CopyOnWriteArrayList:size	()I
    //   13: istore_1
    //   14: iload_1
    //   15: ifne +7 -> 22
    //   18: ldc 2
    //   20: monitorexit
    //   21: return
    //   22: getstatic 45	anmb:jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList	Ljava/util/concurrent/CopyOnWriteArrayList;
    //   25: invokevirtual 66	java/util/concurrent/CopyOnWriteArrayList:iterator	()Ljava/util/Iterator;
    //   28: astore_2
    //   29: aload_2
    //   30: invokeinterface 72 1 0
    //   35: ifeq -17 -> 18
    //   38: aload_2
    //   39: invokeinterface 76 1 0
    //   44: checkcast 78	java/lang/ref/WeakReference
    //   47: astore_3
    //   48: aload_3
    //   49: ifnull -20 -> 29
    //   52: aload_0
    //   53: aload_3
    //   54: invokevirtual 81	java/lang/ref/WeakReference:get	()Ljava/lang/Object;
    //   57: if_acmpne -28 -> 29
    //   60: getstatic 45	anmb:jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList	Ljava/util/concurrent/CopyOnWriteArrayList;
    //   63: aload_3
    //   64: invokevirtual 180	java/util/concurrent/CopyOnWriteArrayList:remove	(Ljava/lang/Object;)Z
    //   67: pop
    //   68: invokestatic 183	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   71: ifeq -53 -> 18
    //   74: ldc 88
    //   76: iconst_2
    //   77: iconst_2
    //   78: anewarray 4	java/lang/Object
    //   81: dup
    //   82: iconst_0
    //   83: ldc 185
    //   85: aastore
    //   86: dup
    //   87: iconst_1
    //   88: aload_0
    //   89: aastore
    //   90: invokestatic 188	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;I[Ljava/lang/Object;)V
    //   93: goto -75 -> 18
    //   96: astore_0
    //   97: ldc 2
    //   99: monitorexit
    //   100: aload_0
    //   101: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	102	0	paramanmd	anmd
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
    for (;;)
    {
      synchronized (bkyi.a)
      {
        if (c(paramString)) {
          return true;
        }
        localObject2 = "lib" + paramString + ".so";
        str1 = bkyi.a();
        if (!a((String)localObject2)) {
          break;
        }
        str1 = str1 + "/test";
        localObject2 = new File(str1, (String)localObject2);
        l = System.currentTimeMillis();
        if ("sava".equals(paramString))
        {
          jdField_a_of_type_JavaLangString = "/sdcard/Android/data/com.tencent.mobileqq/Tencent/MobileQQ/.apollo/soTest/";
          System.load(((File)localObject2).getAbsolutePath());
          QLog.i("ApolloSoLoader", 1, "load test [" + ((File)localObject2).getAbsolutePath() + "],[size]:" + ((File)localObject2).length() + ",[duration]:" + (System.currentTimeMillis() - l));
          return true;
        }
      }
      if ("jsc".equals(paramString)) {
        bkyi.a(str1);
      }
    }
    long l = System.currentTimeMillis();
    Object localObject2 = bdgh.a().a(paramString);
    if (localObject2 == null)
    {
      QLog.i("ApolloSoLoader", 1, "load failed [" + paramString + "], result null");
      return false;
    }
    boolean bool = ((LoadExtResult)localObject2).isSucc();
    String str1 = ((LoadExtResult)localObject2).getVer();
    if (!bool)
    {
      int i = ((LoadExtResult)localObject2).getResultCode();
      QLog.i("ApolloSoLoader", 1, "load failed [" + paramString + "],[resultCode]:" + i + ", version=" + str1);
      return false;
    }
    String str2 = ((LoadExtResult)localObject2).getSoLoadPath(paramString);
    File localFile = new File(str2);
    if ("sava".equals(paramString)) {
      jdField_a_of_type_JavaLangString = ((LoadExtResult)localObject2).getRelatedFilesFolder("sava");
    }
    for (;;)
    {
      if (d) {
        anis.a(10, 300, new Object[] { "load [" + localFile.getAbsolutePath() + "]" });
      }
      QLog.i("ApolloSoLoader", 1, "load success [" + str2 + "],[size]:" + localFile.length() + ",[duration]:" + (System.currentTimeMillis() - l) + ", version=" + str1);
      return true;
      if ("jsc".equals(paramString)) {
        bkyi.a(localFile.getParent());
      }
    }
  }
  
  private static boolean c(String paramString)
  {
    if (!AppSetting.g) {}
    while (!"sava".equals(paramString)) {
      return false;
    }
    System.loadLibrary("sava");
    QLog.i("ApolloSoLoader", 1, "sava is loaded for asan test.");
    return true;
  }
  
  private static void d() {}
  
  private static void e()
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
      amme.b();
      return;
      label34:
      if ((localObject instanceof ToolAppRuntime))
      {
        localObject = amwn.a();
        if (localObject != null) {
          ((ApolloCmdChannel)localObject).checkSetNative();
        }
      }
    }
  }
  
  private static boolean f()
  {
    boolean bool2 = false;
    boolean bool1;
    try
    {
      if (ApolloGameUtil.a())
      {
        QLog.i("ApolloSoLoader", 1, "[loadAllSo], Aborting! arch=x86");
        bool1 = bool2;
        if (d)
        {
          anis.a(10, 300, 1002, new Object[] { "arch=x86" });
          return false;
        }
      }
      else if (!UpdateArkSo.a(BaseApplicationImpl.getContext(), UpdateArkSo.a()))
      {
        bool1 = bool2;
        if (!d) {
          return bool1;
        }
        anis.a(10, 300, 1003, new Object[] { "png-armeabi-v7a load failed" });
        jdField_a_of_type_Boolean = true;
        return false;
      }
    }
    catch (Throwable localThrowable)
    {
      QLog.e("ApolloSoLoader", 1, "[loadAllSo], Something unexpected happened." + localThrowable);
      bool1 = bool2;
      if (d)
      {
        anis.a(10, 300, 1004, new Object[] { "[loadAllSo], Something unexpected happened.", localThrowable });
        jdField_a_of_type_Boolean = true;
        return false;
        if (d) {
          anis.a(10, 300, new Object[] { "" });
        }
        Object localObject;
        if (!e)
        {
          QLog.i("ApolloSoLoader", 1, "[loadAllSo] predownload so");
          localObject = jdField_a_of_type_ArrayOfJavaLangString[0];
          String str = jdField_a_of_type_ArrayOfJavaLangString[1];
          bdgh localbdgh = bdgh.a();
          anmc localanmc = new anmc();
          localbdgh.b(new String[] { "jsc", localObject, str, "apng_encoder" }, localanmc);
          e = true;
        }
        if ((BaseApplicationImpl.sProcessId == 2) || (BaseApplicationImpl.sProcessId == 8))
        {
          bool1 = bool2;
          if (!b("jsc")) {}
        }
        else
        {
          for (;;)
          {
            localObject = jdField_a_of_type_ArrayOfJavaLangString;
            int j = localObject.length;
            int i = 0;
            while (i < j)
            {
              bool1 = bool2;
              if (!b(localObject[i])) {
                return bool1;
              }
              i += 1;
            }
            bool1 = bool2;
            if (!b("jsc")) {
              return bool1;
            }
            anis.a(10, 299);
            if (!AVSoUtils.a())
            {
              QLog.e("ApolloSoLoader", 1, "[loadAllSo] sharpp load error");
              anis.a(10, 299, 1005, new Object[] { "sharpp load fail" });
              return false;
            }
            anis.a(10, 299, 0, new Object[0]);
          }
          localObject = BaseApplicationImpl.getApplication().getRuntime();
          if ((localObject != null) && ((localObject instanceof QQAppInterface)))
          {
            ArkAppCenter.a().postToMainThread(new ApolloSoLoader.3());
            QLog.e("ApolloSoLoader", 1, "[loadAllSo], Notify ark jsc has loaded.");
          }
          if (d) {
            anis.a(10, 300, 0, new Object[] { "loadAllSo success" });
          }
          bool1 = true;
        }
      }
    }
    return bool1;
  }
  
  private static boolean g()
  {
    long l1 = System.currentTimeMillis();
    try
    {
      String[] arrayOfString = amme.jdField_a_of_type_ArrayOfJavaLangString;
      int j = arrayOfString.length;
      int i = 0;
      while (i < j)
      {
        String str1 = arrayOfString[i];
        String str2 = FileUtils.readFileToString(new File(a(str1), str1));
        amme.jdField_a_of_type_JavaUtilMap.put(str1, str2);
        i += 1;
      }
      return true;
    }
    catch (Throwable localThrowable)
    {
      QLog.e("ApolloSoLoader", 1, "[initScriptLib]," + localThrowable);
      if (d) {
        anis.a(10, 100, new Object[] { "[initScriptLib], th:", localThrowable });
      }
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
 * Qualified Name:     anmb
 * JD-Core Version:    0.7.0.1
 */