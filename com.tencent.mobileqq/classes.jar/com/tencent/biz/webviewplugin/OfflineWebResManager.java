package com.tencent.biz.webviewplugin;

import android.content.Context;
import android.content.SharedPreferences;
import android.net.Uri;
import android.text.TextUtils;
import com.tencent.biz.common.offline.HtmlOffline;
import com.tencent.biz.common.offline.OfflineEnvHelper;
import com.tencent.biz.common.util.OfflineSecurity;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.OfflineWebRes;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.EntityManagerFactory;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.vas.ClubContentJsonTask;
import com.tencent.mobileqq.vas.ClubContentJsonTask.TaskInfo;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.security.MessageDigest;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONObject;

public class OfflineWebResManager
{
  public static ConcurrentLinkedQueue<String> a;
  static boolean a;
  static boolean b = true;
  public AppInterface a;
  public EntityManager a;
  public String a;
  public AtomicBoolean a;
  
  static
  {
    jdField_a_of_type_JavaUtilConcurrentConcurrentLinkedQueue = new ConcurrentLinkedQueue();
    jdField_a_of_type_Boolean = false;
  }
  
  public OfflineWebResManager(AppInterface paramAppInterface)
  {
    this.jdField_a_of_type_JavaLangString = "";
    this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean(false);
    this.jdField_a_of_type_ComTencentCommonAppAppInterface = paramAppInterface;
    paramAppInterface = this.jdField_a_of_type_ComTencentCommonAppAppInterface.getEntityManagerFactory();
    if (paramAppInterface != null) {
      this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager = paramAppInterface.createEntityManager();
    }
  }
  
  /* Error */
  private JSONObject a(String paramString)
  {
    // Byte code:
    //   0: aload_1
    //   1: invokestatic 66	com/tencent/biz/common/offline/OfflineEnvHelper:a	(Ljava/lang/String;)Ljava/lang/String;
    //   4: astore_3
    //   5: aload_3
    //   6: invokestatic 72	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   9: istore_2
    //   10: aconst_null
    //   11: astore 6
    //   13: iload_2
    //   14: ifeq +5 -> 19
    //   17: aconst_null
    //   18: areturn
    //   19: new 74	java/lang/StringBuilder
    //   22: dup
    //   23: invokespecial 75	java/lang/StringBuilder:<init>	()V
    //   26: astore 4
    //   28: aload 4
    //   30: aload_3
    //   31: invokevirtual 79	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   34: pop
    //   35: aload 4
    //   37: aload_1
    //   38: invokevirtual 79	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   41: pop
    //   42: aload 4
    //   44: invokevirtual 83	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   47: astore_3
    //   48: new 85	java/io/File
    //   51: dup
    //   52: aload_3
    //   53: invokespecial 88	java/io/File:<init>	(Ljava/lang/String;)V
    //   56: invokevirtual 92	java/io/File:exists	()Z
    //   59: ifne +10 -> 69
    //   62: aload_0
    //   63: aload_1
    //   64: invokevirtual 95	com/tencent/biz/webviewplugin/OfflineWebResManager:c	(Ljava/lang/String;)V
    //   67: aconst_null
    //   68: areturn
    //   69: getstatic 100	com/tencent/biz/common/offline/HtmlOffline:a	Ljava/util/concurrent/ConcurrentHashMap;
    //   72: ifnull +28 -> 100
    //   75: getstatic 100	com/tencent/biz/common/offline/HtmlOffline:a	Ljava/util/concurrent/ConcurrentHashMap;
    //   78: aload_1
    //   79: invokevirtual 106	java/util/concurrent/ConcurrentHashMap:containsKey	(Ljava/lang/Object;)Z
    //   82: ifeq +18 -> 100
    //   85: getstatic 100	com/tencent/biz/common/offline/HtmlOffline:a	Ljava/util/concurrent/ConcurrentHashMap;
    //   88: aload_1
    //   89: invokevirtual 110	java/util/concurrent/ConcurrentHashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   92: checkcast 112	java/lang/String
    //   95: astore 4
    //   97: goto +185 -> 282
    //   100: new 74	java/lang/StringBuilder
    //   103: dup
    //   104: invokespecial 75	java/lang/StringBuilder:<init>	()V
    //   107: astore 4
    //   109: aload 4
    //   111: aload_3
    //   112: invokevirtual 79	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   115: pop
    //   116: aload 4
    //   118: ldc 114
    //   120: invokevirtual 79	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   123: pop
    //   124: new 116	java/io/BufferedInputStream
    //   127: dup
    //   128: new 118	java/io/FileInputStream
    //   131: dup
    //   132: aload 4
    //   134: invokevirtual 83	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   137: invokespecial 119	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   140: invokespecial 122	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   143: astore 4
    //   145: aload 4
    //   147: astore 6
    //   149: aload 4
    //   151: invokestatic 127	com/tencent/biz/common/util/OfflineSecurity:a	(Ljava/io/BufferedInputStream;)Ljava/lang/String;
    //   154: astore_3
    //   155: aload 4
    //   157: astore 6
    //   159: getstatic 100	com/tencent/biz/common/offline/HtmlOffline:a	Ljava/util/concurrent/ConcurrentHashMap;
    //   162: ifnull +16 -> 178
    //   165: aload 4
    //   167: astore 6
    //   169: getstatic 100	com/tencent/biz/common/offline/HtmlOffline:a	Ljava/util/concurrent/ConcurrentHashMap;
    //   172: aload_1
    //   173: aload_3
    //   174: invokevirtual 131	java/util/concurrent/ConcurrentHashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   177: pop
    //   178: aload_3
    //   179: astore 6
    //   181: aload 4
    //   183: invokevirtual 134	java/io/BufferedInputStream:close	()V
    //   186: aload_3
    //   187: astore 4
    //   189: goto +93 -> 282
    //   192: astore_3
    //   193: aload_3
    //   194: invokevirtual 137	java/io/IOException:printStackTrace	()V
    //   197: aload 6
    //   199: astore 4
    //   201: goto +81 -> 282
    //   204: astore 7
    //   206: aload 4
    //   208: astore 5
    //   210: goto +29 -> 239
    //   213: astore_3
    //   214: goto +11 -> 225
    //   217: astore_1
    //   218: goto +124 -> 342
    //   221: astore_3
    //   222: aconst_null
    //   223: astore 4
    //   225: ldc 31
    //   227: astore 6
    //   229: aload_3
    //   230: astore 7
    //   232: aload 4
    //   234: astore 5
    //   236: aload 6
    //   238: astore_3
    //   239: aload 5
    //   241: astore 6
    //   243: invokestatic 142	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   246: ifeq +17 -> 263
    //   249: aload 5
    //   251: astore 6
    //   253: ldc 144
    //   255: iconst_2
    //   256: ldc 31
    //   258: aload 7
    //   260: invokestatic 148	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   263: aload_3
    //   264: astore 4
    //   266: aload 5
    //   268: ifnull +14 -> 282
    //   271: aload_3
    //   272: astore 6
    //   274: aload 5
    //   276: invokevirtual 134	java/io/BufferedInputStream:close	()V
    //   279: aload_3
    //   280: astore 4
    //   282: aload 4
    //   284: invokestatic 72	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   287: ifne +33 -> 320
    //   290: new 150	org/json/JSONObject
    //   293: dup
    //   294: aload 4
    //   296: invokespecial 151	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   299: astore_1
    //   300: aload_1
    //   301: areturn
    //   302: astore_1
    //   303: invokestatic 142	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   306: ifeq +12 -> 318
    //   309: ldc 144
    //   311: iconst_2
    //   312: ldc 31
    //   314: aload_1
    //   315: invokestatic 148	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   318: aconst_null
    //   319: areturn
    //   320: aload_0
    //   321: aload_1
    //   322: invokevirtual 95	com/tencent/biz/webviewplugin/OfflineWebResManager:c	(Ljava/lang/String;)V
    //   325: getstatic 100	com/tencent/biz/common/offline/HtmlOffline:a	Ljava/util/concurrent/ConcurrentHashMap;
    //   328: ifnull +11 -> 339
    //   331: getstatic 100	com/tencent/biz/common/offline/HtmlOffline:a	Ljava/util/concurrent/ConcurrentHashMap;
    //   334: aload_1
    //   335: invokevirtual 154	java/util/concurrent/ConcurrentHashMap:remove	(Ljava/lang/Object;)Ljava/lang/Object;
    //   338: pop
    //   339: aconst_null
    //   340: areturn
    //   341: astore_1
    //   342: aload 6
    //   344: ifnull +16 -> 360
    //   347: aload 6
    //   349: invokevirtual 134	java/io/BufferedInputStream:close	()V
    //   352: goto +8 -> 360
    //   355: astore_3
    //   356: aload_3
    //   357: invokevirtual 137	java/io/IOException:printStackTrace	()V
    //   360: aload_1
    //   361: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	362	0	this	OfflineWebResManager
    //   0	362	1	paramString	String
    //   9	5	2	bool	boolean
    //   4	183	3	str	String
    //   192	2	3	localIOException1	java.io.IOException
    //   213	1	3	localException1	Exception
    //   221	9	3	localException2	Exception
    //   238	42	3	localObject1	Object
    //   355	2	3	localIOException2	java.io.IOException
    //   26	269	4	localObject2	Object
    //   208	67	5	localObject3	Object
    //   11	337	6	localObject4	Object
    //   204	1	7	localException3	Exception
    //   230	29	7	localException4	Exception
    // Exception table:
    //   from	to	target	type
    //   181	186	192	java/io/IOException
    //   274	279	192	java/io/IOException
    //   159	165	204	java/lang/Exception
    //   169	178	204	java/lang/Exception
    //   149	155	213	java/lang/Exception
    //   100	145	217	finally
    //   100	145	221	java/lang/Exception
    //   290	300	302	java/lang/Exception
    //   149	155	341	finally
    //   159	165	341	finally
    //   169	178	341	finally
    //   243	249	341	finally
    //   253	263	341	finally
    //   347	352	355	java/io/IOException
  }
  
  public static void a(String paramString)
  {
    if (!jdField_a_of_type_JavaUtilConcurrentConcurrentLinkedQueue.contains(paramString)) {
      jdField_a_of_type_JavaUtilConcurrentConcurrentLinkedQueue.add(paramString);
    }
  }
  
  public static void c()
  {
    try
    {
      Object localObject = new File(BaseApplication.getContext().getApplicationContext().getFilesDir(), ClubContentJsonTask.e.jdField_a_of_type_JavaLangString);
      if (((File)localObject).exists())
      {
        localObject = new JSONObject(FileUtils.readFileContent((File)localObject));
        if (((JSONObject)localObject).has("offinePkgReadFromDataCache")) {
          b = ((JSONObject)localObject).getBoolean("offinePkgReadFromDataCache");
        }
      }
    }
    catch (Exception localException)
    {
      if (QLog.isColorLevel()) {
        QLog.e("OfflineWebResManager", 2, "parse offline globle config error!", localException);
      }
    }
    if (!b) {
      QLog.w("OfflineWebResManager", 1, "can not use offline /data cache mode!");
    }
  }
  
  public OfflineWebRes a(String paramString)
  {
    if (!b) {
      return null;
    }
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    return (OfflineWebRes)this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.find(OfflineWebRes.class, paramString);
  }
  
  public void a()
  {
    SharedPreferences localSharedPreferences = BaseApplication.getContext().getSharedPreferences("OfflineWebResManager", 4);
    long l = localSharedPreferences.getLong("Last_Check_Cache", 0L);
    int i;
    if (System.currentTimeMillis() - l < 86400000L) {
      i = 1;
    } else {
      i = 0;
    }
    if (i != 0) {
      return;
    }
    ThreadManager.post(new OfflineWebResManager.1(this, localSharedPreferences), 5, null, false);
  }
  
  public void a(int paramInt)
  {
    if (!b) {
      return;
    }
    if ((paramInt > 0) && (this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get())) {
      return;
    }
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("now check update url, deley: ");
      localStringBuilder.append(paramInt);
      QLog.i("OfflineWebResManager", 2, localStringBuilder.toString());
    }
    this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(true);
    ThreadManager.post(new OfflineWebResManager.2(this, paramInt), 5, null, false);
  }
  
  public void a(OfflineWebRes paramOfflineWebRes)
  {
    if (paramOfflineWebRes == null) {
      return;
    }
    Object localObject1;
    if (paramOfflineWebRes.getStatus() == 1000)
    {
      localObject1 = OfflineEnvHelper.a(paramOfflineWebRes.bid);
      Object localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append((String)localObject1);
      ((StringBuilder)localObject2).append(paramOfflineWebRes.bid);
      ((StringBuilder)localObject2).append("/");
      ((StringBuilder)localObject2).append(paramOfflineWebRes.fileName);
      localObject1 = ((StringBuilder)localObject2).toString();
      localObject2 = new File((String)localObject1);
      if (((File)localObject2).exists())
      {
        localObject1 = new File(BaseApplication.getContext().getFilesDir(), "WebOfflineRes");
        if (!((File)localObject1).exists()) {
          ((File)localObject1).mkdirs();
        }
        FileUtils.copyFile((File)localObject2, new File((File)localObject1, paramOfflineWebRes.hashName));
        if (QLog.isColorLevel())
        {
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append("now copy ");
          ((StringBuilder)localObject1).append(paramOfflineWebRes.fileName);
          ((StringBuilder)localObject1).append(" into /data");
          QLog.i("OfflineWebResManager", 2, ((StringBuilder)localObject1).toString());
        }
        this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.persistOrReplace(paramOfflineWebRes);
        return;
      }
      paramOfflineWebRes = new StringBuilder();
      paramOfflineWebRes.append("bid not exit! ");
      paramOfflineWebRes.append((String)localObject1);
      QLog.e("OfflineWebResManager", 2, paramOfflineWebRes.toString());
      return;
    }
    if ((paramOfflineWebRes.getStatus() == 1001) || (paramOfflineWebRes.getStatus() == 1002))
    {
      localObject1 = new File(BaseApplication.getContext().getFilesDir(), "WebOfflineRes");
      if (((File)localObject1).exists())
      {
        if (new File((File)localObject1, paramOfflineWebRes.hashName).exists())
        {
          paramOfflineWebRes.hitCount += 1;
          if (QLog.isColorLevel())
          {
            localObject1 = new StringBuilder();
            ((StringBuilder)localObject1).append("fileName: ");
            ((StringBuilder)localObject1).append(paramOfflineWebRes.bid);
            ((StringBuilder)localObject1).append("/");
            ((StringBuilder)localObject1).append(paramOfflineWebRes.fileName);
            ((StringBuilder)localObject1).append(", hitcount: ");
            ((StringBuilder)localObject1).append(paramOfflineWebRes.hitCount);
            QLog.i("OfflineWebResManager", 2, ((StringBuilder)localObject1).toString());
          }
          this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.update(paramOfflineWebRes);
          return;
        }
        this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.remove(paramOfflineWebRes);
      }
    }
  }
  
  public void a(String paramString1, String paramString2)
  {
    Object localObject1 = this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.query(OfflineWebRes.class, false, "bid= ? and fileName= ?", new String[] { paramString2, paramString1 }, null, null, null, null);
    if (localObject1 != null)
    {
      if (((List)localObject1).size() == 0) {
        return;
      }
      File localFile1 = new File(BaseApplication.getContext().getFilesDir(), "WebOfflineRes");
      if (localFile1.exists())
      {
        localObject1 = ((List)localObject1).iterator();
        while (((Iterator)localObject1).hasNext())
        {
          Object localObject2 = (OfflineWebRes)((Iterator)localObject1).next();
          File localFile2 = new File(localFile1, ((OfflineWebRes)localObject2).hashName);
          if (localFile2.exists()) {
            localFile2.delete();
          }
          this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.remove((Entity)localObject2, "bid= ? and fileName= ?", new String[] { paramString2, paramString1 });
          if (QLog.isColorLevel())
          {
            localObject2 = new StringBuilder();
            ((StringBuilder)localObject2).append("now delete  record for bid: ");
            ((StringBuilder)localObject2).append(paramString2);
            ((StringBuilder)localObject2).append(", fileName: ");
            ((StringBuilder)localObject2).append(paramString1);
            QLog.i("OfflineWebResManager", 2, ((StringBuilder)localObject2).toString());
          }
        }
      }
    }
  }
  
  public void b()
  {
    if (QLog.isColorLevel()) {
      QLog.i("OfflineWebResManager", 2, "now begin check cache size!");
    }
    Object localObject1 = new File(BaseApplication.getContext().getFilesDir(), "WebOfflineRes");
    if (((File)localObject1).exists())
    {
      if (!((File)localObject1).isDirectory()) {
        return;
      }
      if (!this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.tabbleIsExist(OfflineWebRes.class.getSimpleName())) {
        return;
      }
    }
    for (;;)
    {
      int i;
      try
      {
        Object localObject2 = ((File)localObject1).listFiles();
        if (localObject2 != null)
        {
          if (localObject2.length == 0) {
            return;
          }
          int j = localObject2.length;
          long l1 = 0L;
          i = 0;
          if (i < j)
          {
            localObject3 = localObject2[i];
            if (!((File)localObject3).isDirectory())
            {
              l1 += ((File)localObject3).length();
              break label904;
            }
            ((File)localObject3).delete();
            break label904;
          }
          double d = l1;
          if (d < 4194304.0D)
          {
            if (QLog.isColorLevel())
            {
              localObject1 = new StringBuilder();
              ((StringBuilder)localObject1).append("now /data cache size :");
              ((StringBuilder)localObject1).append(l1);
              QLog.i("OfflineWebResManager", 2, ((StringBuilder)localObject1).toString());
            }
            return;
          }
          OfflineWebRes localOfflineWebRes;
          File localFile;
          if ((d >= 4194304.0D) && (l1 < 5242880L))
          {
            if (QLog.isColorLevel()) {
              QLog.i("OfflineWebResManager", 2, "cache data size exceed threshold value ");
            }
            localObject2 = new StringBuilder();
            ((StringBuilder)localObject2).append("select * from ");
            ((StringBuilder)localObject2).append(OfflineWebRes.class.getSimpleName());
            ((StringBuilder)localObject2).append(" where hitcount=1 limit 100");
            localObject2 = ((StringBuilder)localObject2).toString();
            localObject3 = this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.rawQuery(OfflineWebRes.class, (String)localObject2, null);
            if ((localObject3 == null) || (((List)localObject3).size() <= 0)) {
              break label903;
            }
            localObject2 = new StringBuilder(((List)localObject3).size() * 64);
            localObject3 = ((List)localObject3).iterator();
            if (((Iterator)localObject3).hasNext())
            {
              localOfflineWebRes = (OfflineWebRes)((Iterator)localObject3).next();
              localFile = new File((File)localObject1, localOfflineWebRes.hashName);
              if (localFile.exists())
              {
                if (QLog.isColorLevel())
                {
                  ((StringBuilder)localObject2).append("delete file: ");
                  ((StringBuilder)localObject2).append(localFile.getPath());
                  ((StringBuilder)localObject2).append("\n");
                }
                localFile.delete();
              }
              this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.remove(localOfflineWebRes);
              continue;
            }
            if ((!QLog.isColorLevel()) || (TextUtils.isEmpty(((StringBuilder)localObject2).toString()))) {
              break label903;
            }
            QLog.i("OfflineWebResManager", 2, ((StringBuilder)localObject2).toString());
            return;
          }
          Double.isNaN(d);
          l1 = (d - 4194304.0D);
          if (QLog.isColorLevel())
          {
            localObject2 = new StringBuilder();
            ((StringBuilder)localObject2).append("cache data size exceed cache max value ");
            ((StringBuilder)localObject2).append(l1);
            QLog.i("OfflineWebResManager", 2, ((StringBuilder)localObject2).toString());
          }
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append("select * from ");
          ((StringBuilder)localObject2).append(OfflineWebRes.class.getSimpleName());
          ((StringBuilder)localObject2).append(" order by hitcount");
          localObject2 = ((StringBuilder)localObject2).toString();
          Object localObject3 = this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.rawQuery(OfflineWebRes.class, (String)localObject2, null);
          localObject2 = new StringBuilder("");
          long l2 = l1;
          if (localObject3 != null)
          {
            l2 = l1;
            if (((List)localObject3).size() > 0)
            {
              localObject3 = ((List)localObject3).iterator();
              l2 = l1;
              if (((Iterator)localObject3).hasNext())
              {
                localOfflineWebRes = (OfflineWebRes)((Iterator)localObject3).next();
                if (l1 <= 0L)
                {
                  l2 = l1;
                }
                else
                {
                  localFile = new File((File)localObject1, localOfflineWebRes.hashName);
                  l2 = l1;
                  if (localFile.exists())
                  {
                    StringBuilder localStringBuilder = new StringBuilder();
                    localStringBuilder.append("delete file: ");
                    localStringBuilder.append(localFile.getPath());
                    localStringBuilder.append("\n");
                    ((StringBuilder)localObject2).append(localStringBuilder.toString());
                    l2 = l1 - localFile.length();
                    localFile.delete();
                  }
                  this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.remove(localOfflineWebRes);
                  l1 = l2;
                  continue;
                }
              }
            }
          }
          if (QLog.isColorLevel()) {
            QLog.i("OfflineWebResManager", 2, ((StringBuilder)localObject2).toString());
          }
          if (l2 <= 0L) {
            break label903;
          }
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append("cache data size still exceed cache max value ");
          ((StringBuilder)localObject2).append(l2);
          ((StringBuilder)localObject2).append(", now delete folder and database!");
          QLog.w("OfflineWebResManager", 1, ((StringBuilder)localObject2).toString());
          localObject1 = ((File)localObject1).listFiles();
          if (localObject1 != null)
          {
            if (localObject1.length == 0) {
              return;
            }
            j = localObject1.length;
            i = 0;
            if (i < j)
            {
              localObject1[i].delete();
              i += 1;
              continue;
            }
            this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.drop(OfflineWebRes.class.getSimpleName());
            return;
          }
        }
        return;
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
      }
      label903:
      return;
      label904:
      i += 1;
    }
  }
  
  public void b(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    long l = System.currentTimeMillis();
    Object localObject1 = Uri.parse(paramString).getQueryParameter("_bid");
    Object localObject2 = localObject1;
    if (TextUtils.isEmpty((CharSequence)localObject1)) {
      localObject2 = this.jdField_a_of_type_JavaLangString;
    }
    if (TextUtils.isEmpty((CharSequence)localObject2)) {
      return;
    }
    localObject1 = HtmlOffline.d(paramString);
    if (TextUtils.isEmpty((CharSequence)localObject1)) {
      return;
    }
    Object localObject3 = a((String)localObject2);
    if (localObject3 == null) {
      return;
    }
    String str1 = ((JSONObject)localObject3).optString((String)localObject1);
    if (!TextUtils.isEmpty(str1))
    {
      OfflineWebRes localOfflineWebRes = a(str1);
      localObject1 = localOfflineWebRes;
      if (localOfflineWebRes == null)
      {
        String str2 = HtmlOffline.d(paramString);
        a(str2, (String)localObject2);
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append(str2);
        ((StringBuilder)localObject1).append(String.valueOf(System.currentTimeMillis()));
        ((StringBuilder)localObject1).append(str1);
        Object localObject5 = ((StringBuilder)localObject1).toString();
        localObject3 = "";
        localObject1 = localObject3;
        Object localObject4;
        try
        {
          MessageDigest localMessageDigest = MessageDigest.getInstance("SHA1");
          localObject1 = localObject3;
          localMessageDigest.update(((String)localObject5).getBytes());
          localObject1 = localObject3;
          localObject5 = OfflineSecurity.a(localMessageDigest.digest());
          localObject1 = localObject5;
          localObject3 = localObject5;
          if (QLog.isColorLevel())
          {
            localObject1 = localObject5;
            localObject3 = new StringBuilder();
            localObject1 = localObject5;
            ((StringBuilder)localObject3).append("now filePath ");
            localObject1 = localObject5;
            ((StringBuilder)localObject3).append(str2);
            localObject1 = localObject5;
            ((StringBuilder)localObject3).append(", hashName: ");
            localObject1 = localObject5;
            ((StringBuilder)localObject3).append((String)localObject5);
            localObject1 = localObject5;
            QLog.i("OfflineWebResManager", 2, ((StringBuilder)localObject3).toString());
            localObject3 = localObject5;
          }
        }
        catch (Exception localException)
        {
          localObject5 = new StringBuilder();
          ((StringBuilder)localObject5).append("add offline res error! ");
          ((StringBuilder)localObject5).append(paramString);
          QLog.e("OfflineWebResManager", 1, ((StringBuilder)localObject5).toString());
          if (!TextUtils.isEmpty((CharSequence)localObject2)) {
            c((String)localObject2);
          }
          localException.printStackTrace();
          localObject4 = localObject1;
        }
        localObject1 = localOfflineWebRes;
        if (!TextUtils.isEmpty(localObject4))
        {
          localObject1 = new OfflineWebRes();
          ((OfflineWebRes)localObject1).fileName = str2;
          ((OfflineWebRes)localObject1).hashName = localObject4;
          ((OfflineWebRes)localObject1).md5 = str1;
          ((OfflineWebRes)localObject1).bid = ((String)localObject2);
        }
      }
      a((OfflineWebRes)localObject1);
      if (QLog.isColorLevel())
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("add or update url ");
        ((StringBuilder)localObject1).append(HtmlOffline.d(paramString));
        ((StringBuilder)localObject1).append(", cost: ");
        ((StringBuilder)localObject1).append(System.currentTimeMillis() - l);
        QLog.i("OfflineWebResManager", 2, ((StringBuilder)localObject1).toString());
      }
      return;
    }
    paramString = HtmlOffline.d(paramString);
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("now md5 not exits, fileName:");
      ((StringBuilder)localObject1).append(paramString);
      QLog.i("OfflineWebResManager", 2, ((StringBuilder)localObject1).toString());
    }
    a(paramString, (String)localObject2);
  }
  
  public void c(String paramString)
  {
    Object localObject1 = this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.query(OfflineWebRes.class, false, "bid=?", new String[] { paramString }, null, null, null, null);
    if (localObject1 != null)
    {
      if (((List)localObject1).size() == 0) {
        return;
      }
      File localFile1 = new File(BaseApplication.getContext().getFilesDir(), "WebOfflineRes");
      if (localFile1.exists())
      {
        localObject1 = ((List)localObject1).iterator();
        while (((Iterator)localObject1).hasNext())
        {
          Object localObject2 = (OfflineWebRes)((Iterator)localObject1).next();
          File localFile2 = new File(localFile1, ((OfflineWebRes)localObject2).hashName);
          if (localFile2.exists()) {
            localFile2.delete();
          }
          this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.remove((Entity)localObject2, "bid=?", new String[] { paramString });
          if (QLog.isColorLevel())
          {
            localObject2 = new StringBuilder();
            ((StringBuilder)localObject2).append("now delete all record of bid: ");
            ((StringBuilder)localObject2).append(paramString);
            QLog.i("OfflineWebResManager", 2, ((StringBuilder)localObject2).toString());
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.webviewplugin.OfflineWebResManager
 * JD-Core Version:    0.7.0.1
 */