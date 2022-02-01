package com.tencent.biz.webviewplugin;

import android.content.Context;
import android.content.SharedPreferences;
import android.net.Uri;
import android.text.TextUtils;
import com.tencent.biz.common.offline.HtmlOffline;
import com.tencent.biz.common.offline.OfflineEnvHelper;
import com.tencent.biz.common.util.OfflineSecurity;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.OfflineWebRes;
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
  static boolean jdField_b_of_type_Boolean = true;
  public final long a;
  public AppInterface a;
  public EntityManager a;
  public String a;
  public AtomicBoolean a;
  final long jdField_b_of_type_Long = 5242880L;
  
  static
  {
    jdField_a_of_type_JavaUtilConcurrentConcurrentLinkedQueue = new ConcurrentLinkedQueue();
    jdField_a_of_type_Boolean = false;
  }
  
  public OfflineWebResManager(AppInterface paramAppInterface)
  {
    this.jdField_a_of_type_Long = 86400000L;
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
    //   0: aconst_null
    //   1: astore_2
    //   2: aload_1
    //   3: invokestatic 75	com/tencent/biz/common/offline/OfflineEnvHelper:a	(Ljava/lang/String;)Ljava/lang/String;
    //   6: astore_3
    //   7: aload_3
    //   8: invokestatic 81	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   11: ifeq +5 -> 16
    //   14: aconst_null
    //   15: areturn
    //   16: new 83	java/lang/StringBuilder
    //   19: dup
    //   20: invokespecial 84	java/lang/StringBuilder:<init>	()V
    //   23: aload_3
    //   24: invokevirtual 88	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   27: aload_1
    //   28: invokevirtual 88	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   31: invokevirtual 92	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   34: astore_3
    //   35: new 94	java/io/File
    //   38: dup
    //   39: aload_3
    //   40: invokespecial 97	java/io/File:<init>	(Ljava/lang/String;)V
    //   43: invokevirtual 101	java/io/File:exists	()Z
    //   46: ifne +10 -> 56
    //   49: aload_0
    //   50: aload_1
    //   51: invokevirtual 104	com/tencent/biz/webviewplugin/OfflineWebResManager:c	(Ljava/lang/String;)V
    //   54: aconst_null
    //   55: areturn
    //   56: getstatic 109	com/tencent/biz/common/offline/HtmlOffline:a	Ljava/util/concurrent/ConcurrentHashMap;
    //   59: ifnull +42 -> 101
    //   62: getstatic 109	com/tencent/biz/common/offline/HtmlOffline:a	Ljava/util/concurrent/ConcurrentHashMap;
    //   65: aload_1
    //   66: invokevirtual 115	java/util/concurrent/ConcurrentHashMap:containsKey	(Ljava/lang/Object;)Z
    //   69: ifeq +32 -> 101
    //   72: getstatic 109	com/tencent/biz/common/offline/HtmlOffline:a	Ljava/util/concurrent/ConcurrentHashMap;
    //   75: aload_1
    //   76: invokevirtual 119	java/util/concurrent/ConcurrentHashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   79: checkcast 121	java/lang/String
    //   82: astore_3
    //   83: aload_3
    //   84: invokestatic 81	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   87: ifne +203 -> 290
    //   90: new 123	org/json/JSONObject
    //   93: dup
    //   94: aload_3
    //   95: invokespecial 124	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   98: astore_1
    //   99: aload_1
    //   100: areturn
    //   101: new 126	java/io/BufferedInputStream
    //   104: dup
    //   105: new 128	java/io/FileInputStream
    //   108: dup
    //   109: new 83	java/lang/StringBuilder
    //   112: dup
    //   113: invokespecial 84	java/lang/StringBuilder:<init>	()V
    //   116: aload_3
    //   117: invokevirtual 88	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   120: ldc 130
    //   122: invokevirtual 88	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   125: invokevirtual 92	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   128: invokespecial 131	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   131: invokespecial 134	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   134: astore 4
    //   136: aload 4
    //   138: astore_3
    //   139: aload 4
    //   141: invokestatic 139	com/tencent/biz/common/util/OfflineSecurity:a	(Ljava/io/BufferedInputStream;)Ljava/lang/String;
    //   144: astore_2
    //   145: aload 4
    //   147: astore_3
    //   148: getstatic 109	com/tencent/biz/common/offline/HtmlOffline:a	Ljava/util/concurrent/ConcurrentHashMap;
    //   151: ifnull +15 -> 166
    //   154: aload 4
    //   156: astore_3
    //   157: getstatic 109	com/tencent/biz/common/offline/HtmlOffline:a	Ljava/util/concurrent/ConcurrentHashMap;
    //   160: aload_1
    //   161: aload_2
    //   162: invokevirtual 143	java/util/concurrent/ConcurrentHashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   165: pop
    //   166: aload_2
    //   167: astore_3
    //   168: aload 4
    //   170: ifnull -87 -> 83
    //   173: aload 4
    //   175: invokevirtual 146	java/io/BufferedInputStream:close	()V
    //   178: aload_2
    //   179: astore_3
    //   180: goto -97 -> 83
    //   183: astore_3
    //   184: aload_3
    //   185: invokevirtual 149	java/io/IOException:printStackTrace	()V
    //   188: aload_2
    //   189: astore_3
    //   190: goto -107 -> 83
    //   193: astore 5
    //   195: aconst_null
    //   196: astore 4
    //   198: ldc 40
    //   200: astore_2
    //   201: aload 4
    //   203: astore_3
    //   204: invokestatic 154	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   207: ifeq +16 -> 223
    //   210: aload 4
    //   212: astore_3
    //   213: ldc 156
    //   215: iconst_2
    //   216: ldc 40
    //   218: aload 5
    //   220: invokestatic 160	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   223: aload_2
    //   224: astore_3
    //   225: aload 4
    //   227: ifnull -144 -> 83
    //   230: aload 4
    //   232: invokevirtual 146	java/io/BufferedInputStream:close	()V
    //   235: aload_2
    //   236: astore_3
    //   237: goto -154 -> 83
    //   240: astore_3
    //   241: aload_3
    //   242: invokevirtual 149	java/io/IOException:printStackTrace	()V
    //   245: aload_2
    //   246: astore_3
    //   247: goto -164 -> 83
    //   250: astore_1
    //   251: aload_2
    //   252: ifnull +7 -> 259
    //   255: aload_2
    //   256: invokevirtual 146	java/io/BufferedInputStream:close	()V
    //   259: aload_1
    //   260: athrow
    //   261: astore_2
    //   262: aload_2
    //   263: invokevirtual 149	java/io/IOException:printStackTrace	()V
    //   266: goto -7 -> 259
    //   269: astore_1
    //   270: invokestatic 154	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   273: ifeq +12 -> 285
    //   276: ldc 156
    //   278: iconst_2
    //   279: ldc 40
    //   281: aload_1
    //   282: invokestatic 160	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   285: aconst_null
    //   286: astore_1
    //   287: goto -188 -> 99
    //   290: aload_0
    //   291: aload_1
    //   292: invokevirtual 104	com/tencent/biz/webviewplugin/OfflineWebResManager:c	(Ljava/lang/String;)V
    //   295: getstatic 109	com/tencent/biz/common/offline/HtmlOffline:a	Ljava/util/concurrent/ConcurrentHashMap;
    //   298: ifnull -284 -> 14
    //   301: getstatic 109	com/tencent/biz/common/offline/HtmlOffline:a	Ljava/util/concurrent/ConcurrentHashMap;
    //   304: aload_1
    //   305: invokevirtual 163	java/util/concurrent/ConcurrentHashMap:remove	(Ljava/lang/Object;)Ljava/lang/Object;
    //   308: pop
    //   309: aconst_null
    //   310: areturn
    //   311: astore_1
    //   312: aload_3
    //   313: astore_2
    //   314: goto -63 -> 251
    //   317: astore 5
    //   319: ldc 40
    //   321: astore_2
    //   322: goto -121 -> 201
    //   325: astore 5
    //   327: goto -126 -> 201
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	330	0	this	OfflineWebResManager
    //   0	330	1	paramString	String
    //   1	255	2	str1	String
    //   261	2	2	localIOException1	java.io.IOException
    //   313	9	2	localObject1	Object
    //   6	174	3	localObject2	Object
    //   183	2	3	localIOException2	java.io.IOException
    //   189	48	3	localObject3	Object
    //   240	2	3	localIOException3	java.io.IOException
    //   246	67	3	str2	String
    //   134	97	4	localBufferedInputStream	java.io.BufferedInputStream
    //   193	26	5	localException1	Exception
    //   317	1	5	localException2	Exception
    //   325	1	5	localException3	Exception
    // Exception table:
    //   from	to	target	type
    //   173	178	183	java/io/IOException
    //   101	136	193	java/lang/Exception
    //   230	235	240	java/io/IOException
    //   101	136	250	finally
    //   255	259	261	java/io/IOException
    //   90	99	269	java/lang/Exception
    //   139	145	311	finally
    //   148	154	311	finally
    //   157	166	311	finally
    //   204	210	311	finally
    //   213	223	311	finally
    //   139	145	317	java/lang/Exception
    //   148	154	325	java/lang/Exception
    //   157	166	325	java/lang/Exception
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
      Object localObject = new File(BaseApplicationImpl.getApplication().getApplicationContext().getFilesDir(), ClubContentJsonTask.e.jdField_a_of_type_JavaLangString);
      if (((File)localObject).exists())
      {
        localObject = new JSONObject(FileUtils.a((File)localObject));
        if (((JSONObject)localObject).has("offinePkgReadFromDataCache")) {
          jdField_b_of_type_Boolean = ((JSONObject)localObject).getBoolean("offinePkgReadFromDataCache");
        }
      }
      if (!jdField_b_of_type_Boolean) {
        QLog.w("OfflineWebResManager", 1, "can not use offline /data cache mode!");
      }
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.e("OfflineWebResManager", 2, "parse offline globle config error!", localException);
        }
      }
    }
  }
  
  public OfflineWebRes a(String paramString)
  {
    if (!jdField_b_of_type_Boolean) {}
    while (TextUtils.isEmpty(paramString)) {
      return null;
    }
    return (OfflineWebRes)this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.find(OfflineWebRes.class, paramString);
  }
  
  public void a()
  {
    BaseApplicationImpl.getApplication();
    SharedPreferences localSharedPreferences = BaseApplicationImpl.getContext().getSharedPreferences("OfflineWebResManager", 4);
    long l = localSharedPreferences.getLong("Last_Check_Cache", 0L);
    if (System.currentTimeMillis() - l < 86400000L) {}
    for (int i = 1; i != 0; i = 0) {
      return;
    }
    ThreadManager.post(new OfflineWebResManager.1(this, localSharedPreferences), 5, null, false);
  }
  
  public void a(int paramInt)
  {
    if (!jdField_b_of_type_Boolean) {}
    while ((paramInt > 0) && (this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get())) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.i("OfflineWebResManager", 2, "now check update url, deley: " + paramInt);
    }
    this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(true);
    ThreadManager.post(new OfflineWebResManager.2(this, paramInt), 5, null, false);
  }
  
  public void a(OfflineWebRes paramOfflineWebRes)
  {
    if (paramOfflineWebRes == null) {}
    Object localObject1;
    do
    {
      do
      {
        return;
        if (paramOfflineWebRes.getStatus() == 1000)
        {
          localObject1 = OfflineEnvHelper.a(paramOfflineWebRes.bid);
          Object localObject2 = (String)localObject1 + paramOfflineWebRes.bid + "/" + paramOfflineWebRes.fileName;
          localObject1 = new File((String)localObject2);
          if (((File)localObject1).exists())
          {
            localObject2 = new File(BaseApplicationImpl.getContext().getFilesDir(), "WebOfflineRes");
            if (!((File)localObject2).exists()) {
              ((File)localObject2).mkdirs();
            }
            FileUtils.a((File)localObject1, new File((File)localObject2, paramOfflineWebRes.hashName));
            if (QLog.isColorLevel()) {
              QLog.i("OfflineWebResManager", 2, "now copy " + paramOfflineWebRes.fileName + " into /data");
            }
            this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.persistOrReplace(paramOfflineWebRes);
            return;
          }
          QLog.e("OfflineWebResManager", 2, "bid not exit! " + (String)localObject2);
          return;
        }
      } while ((paramOfflineWebRes.getStatus() != 1001) && (paramOfflineWebRes.getStatus() != 1002));
      localObject1 = new File(BaseApplicationImpl.getContext().getFilesDir(), "WebOfflineRes");
    } while (!((File)localObject1).exists());
    if (new File((File)localObject1, paramOfflineWebRes.hashName).exists())
    {
      paramOfflineWebRes.hitCount += 1;
      if (QLog.isColorLevel()) {
        QLog.i("OfflineWebResManager", 2, "fileName: " + paramOfflineWebRes.bid + "/" + paramOfflineWebRes.fileName + ", hitcount: " + paramOfflineWebRes.hitCount);
      }
      this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.update(paramOfflineWebRes);
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.remove(paramOfflineWebRes);
  }
  
  public void a(String paramString1, String paramString2)
  {
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.query(OfflineWebRes.class, false, "bid= ? and fileName= ?", new String[] { paramString2, paramString1 }, null, null, null, null);
    if ((localObject == null) || (((List)localObject).size() == 0)) {}
    for (;;)
    {
      return;
      File localFile1 = new File(BaseApplicationImpl.getContext().getFilesDir(), "WebOfflineRes");
      if (localFile1.exists())
      {
        localObject = ((List)localObject).iterator();
        while (((Iterator)localObject).hasNext())
        {
          OfflineWebRes localOfflineWebRes = (OfflineWebRes)((Iterator)localObject).next();
          File localFile2 = new File(localFile1, localOfflineWebRes.hashName);
          if (localFile2.exists()) {
            localFile2.delete();
          }
          this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.remove(localOfflineWebRes, "bid= ? and fileName= ?", new String[] { paramString2, paramString1 });
          if (QLog.isColorLevel()) {
            QLog.i("OfflineWebResManager", 2, "now delete  record for bid: " + paramString2 + ", fileName: " + paramString1);
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
    File localFile1 = new File(BaseApplicationImpl.getContext().getFilesDir(), "WebOfflineRes");
    if ((!localFile1.exists()) || (!localFile1.isDirectory()))
    {
      break label49;
      break label49;
      break label49;
      break label49;
    }
    label49:
    while (!this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.tabbleIsExist(OfflineWebRes.class.getSimpleName())) {
      return;
    }
    for (;;)
    {
      int j;
      int i;
      try
      {
        localObject1 = localFile1.listFiles();
        if ((localObject1 == null) || (localObject1.length == 0)) {
          break label49;
        }
        j = localObject1.length;
        i = 0;
        l1 = 0L;
        if (i < j)
        {
          localObject2 = localObject1[i];
          if (!((File)localObject2).isDirectory()) {
            l1 += ((File)localObject2).length();
          } else {
            ((File)localObject2).delete();
          }
        }
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
        return;
      }
      if (l1 < 4194304.0D)
      {
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.i("OfflineWebResManager", 2, "now /data cache size :" + l1);
        return;
      }
      OfflineWebRes localOfflineWebRes;
      File localFile2;
      if ((l1 >= 4194304.0D) && (l1 < 5242880L))
      {
        if (QLog.isColorLevel()) {
          QLog.i("OfflineWebResManager", 2, "cache data size exceed threshold value ");
        }
        localObject1 = "select * from " + OfflineWebRes.class.getSimpleName() + " where hitcount=1 limit 100";
        localObject2 = this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.rawQuery(OfflineWebRes.class, (String)localObject1, null);
        if ((localObject2 == null) || (((List)localObject2).size() <= 0)) {
          break;
        }
        localObject1 = new StringBuilder(((List)localObject2).size() * 64);
        localObject2 = ((List)localObject2).iterator();
        while (((Iterator)localObject2).hasNext())
        {
          localOfflineWebRes = (OfflineWebRes)((Iterator)localObject2).next();
          localFile2 = new File(localException, localOfflineWebRes.hashName);
          if (localFile2.exists())
          {
            if (QLog.isColorLevel()) {
              ((StringBuilder)localObject1).append("delete file: ").append(localFile2.getPath()).append("\n");
            }
            localFile2.delete();
          }
          this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.remove(localOfflineWebRes);
        }
        if ((!QLog.isColorLevel()) || (TextUtils.isEmpty(((StringBuilder)localObject1).toString()))) {
          break;
        }
        QLog.i("OfflineWebResManager", 2, ((StringBuilder)localObject1).toString());
        return;
      }
      long l2 = (l1 - 4194304.0D);
      if (QLog.isColorLevel()) {
        QLog.i("OfflineWebResManager", 2, "cache data size exceed cache max value " + l2);
      }
      Object localObject1 = "select * from " + OfflineWebRes.class.getSimpleName() + " order by hitcount";
      Object localObject2 = this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.rawQuery(OfflineWebRes.class, (String)localObject1, null);
      localObject1 = new StringBuilder("");
      long l1 = l2;
      if (localObject2 != null)
      {
        l1 = l2;
        if (((List)localObject2).size() > 0)
        {
          localObject2 = ((List)localObject2).iterator();
          l1 = l2;
          if (!((Iterator)localObject2).hasNext()) {
            break label791;
          }
          localOfflineWebRes = (OfflineWebRes)((Iterator)localObject2).next();
          if (l1 > 0L) {
            break label683;
          }
        }
      }
      label791:
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.i("OfflineWebResManager", 2, ((StringBuilder)localObject1).toString());
        }
        if (l1 <= 0L) {
          break;
        }
        QLog.w("OfflineWebResManager", 1, "cache data size still exceed cache max value " + l1 + ", now delete folder and database!");
        File[] arrayOfFile = localException.listFiles();
        if ((arrayOfFile == null) || (arrayOfFile.length == 0)) {
          break;
        }
        j = arrayOfFile.length;
        i = 0;
        for (;;)
        {
          if (i < j)
          {
            arrayOfFile[i].delete();
            i += 1;
            continue;
            label683:
            localFile2 = new File(arrayOfFile, localOfflineWebRes.hashName);
            l2 = l1;
            if (localFile2.exists())
            {
              ((StringBuilder)localObject1).append("delete file: " + localFile2.getPath() + "\n");
              l2 = l1 - localFile2.length();
              localFile2.delete();
            }
            this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.remove(localOfflineWebRes);
            l1 = l2;
            break;
          }
        }
        this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.drop(OfflineWebRes.class.getSimpleName());
        return;
      }
      i += 1;
    }
  }
  
  public void b(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    long l;
    Object localObject1;
    Object localObject2;
    Object localObject3;
    do
    {
      do
      {
        do
        {
          return;
          l = System.currentTimeMillis();
          localObject1 = Uri.parse(paramString).getQueryParameter("_bid");
          localObject2 = localObject1;
          if (TextUtils.isEmpty((CharSequence)localObject1)) {
            localObject2 = this.jdField_a_of_type_JavaLangString;
          }
        } while (TextUtils.isEmpty((CharSequence)localObject2));
        localObject1 = HtmlOffline.d(paramString);
      } while (TextUtils.isEmpty((CharSequence)localObject1));
      localObject3 = a((String)localObject2);
    } while (localObject3 == null);
    String str1 = ((JSONObject)localObject3).optString((String)localObject1);
    OfflineWebRes localOfflineWebRes;
    String str2;
    if (!TextUtils.isEmpty(str1))
    {
      localOfflineWebRes = a(str1);
      if (localOfflineWebRes != null) {
        break label441;
      }
      str2 = HtmlOffline.d(paramString);
      a(str2, (String)localObject2);
      localObject1 = str2 + String.valueOf(System.currentTimeMillis()) + str1;
    }
    for (;;)
    {
      for (;;)
      {
        try
        {
          localObject3 = MessageDigest.getInstance("SHA1");
          ((MessageDigest)localObject3).update(((String)localObject1).getBytes());
          localObject1 = OfflineSecurity.a(((MessageDigest)localObject3).digest());
          localObject3 = localObject1;
        }
        catch (Exception localException1)
        {
          localObject1 = "";
        }
        try
        {
          if (QLog.isColorLevel())
          {
            QLog.i("OfflineWebResManager", 2, "now filePath " + str2 + ", hashName: " + (String)localObject1);
            localObject3 = localObject1;
          }
          if (TextUtils.isEmpty((CharSequence)localObject3)) {
            break label441;
          }
          localObject1 = new OfflineWebRes();
          ((OfflineWebRes)localObject1).fileName = str2;
          ((OfflineWebRes)localObject1).hashName = ((String)localObject3);
          ((OfflineWebRes)localObject1).md5 = str1;
          ((OfflineWebRes)localObject1).bid = ((String)localObject2);
          a((OfflineWebRes)localObject1);
          if (!QLog.isColorLevel()) {
            break;
          }
          QLog.i("OfflineWebResManager", 2, "add or update url " + HtmlOffline.d(paramString) + ", cost: " + (System.currentTimeMillis() - l));
          return;
        }
        catch (Exception localException2)
        {
          label384:
          Object localObject4;
          break label384;
        }
      }
      paramString = HtmlOffline.d(paramString);
      if (QLog.isColorLevel()) {
        QLog.i("OfflineWebResManager", 2, "now md5 not exits, fileName:" + paramString);
      }
      a(paramString, (String)localObject2);
      return;
      QLog.e("OfflineWebResManager", 1, "add offline res error! " + paramString);
      if (!TextUtils.isEmpty((CharSequence)localObject2)) {
        c((String)localObject2);
      }
      localException1.printStackTrace();
      localObject4 = localObject1;
      continue;
      label441:
      localObject1 = localOfflineWebRes;
    }
  }
  
  public void c(String paramString)
  {
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.query(OfflineWebRes.class, false, "bid=?", new String[] { paramString }, null, null, null, null);
    if ((localObject == null) || (((List)localObject).size() == 0)) {}
    for (;;)
    {
      return;
      File localFile1 = new File(BaseApplicationImpl.getContext().getFilesDir(), "WebOfflineRes");
      if (localFile1.exists())
      {
        localObject = ((List)localObject).iterator();
        while (((Iterator)localObject).hasNext())
        {
          OfflineWebRes localOfflineWebRes = (OfflineWebRes)((Iterator)localObject).next();
          File localFile2 = new File(localFile1, localOfflineWebRes.hashName);
          if (localFile2.exists()) {
            localFile2.delete();
          }
          this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.remove(localOfflineWebRes, "bid=?", new String[] { paramString });
          if (QLog.isColorLevel()) {
            QLog.i("OfflineWebResManager", 2, "now delete all record of bid: " + paramString);
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.webviewplugin.OfflineWebResManager
 * JD-Core Version:    0.7.0.1
 */