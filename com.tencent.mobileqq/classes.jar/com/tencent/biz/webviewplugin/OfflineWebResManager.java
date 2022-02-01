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
  public static ConcurrentLinkedQueue<String> c = new ConcurrentLinkedQueue();
  static boolean e = false;
  static boolean f = true;
  public AppInterface a;
  public EntityManager b;
  public String d = "";
  public AtomicBoolean g = new AtomicBoolean(false);
  
  public OfflineWebResManager(AppInterface paramAppInterface)
  {
    this.a = paramAppInterface;
    paramAppInterface = this.a.getEntityManagerFactory();
    if (paramAppInterface != null) {
      this.b = paramAppInterface.createEntityManager();
    }
  }
  
  private void a(File paramFile)
  {
    if (QLog.isColorLevel()) {
      QLog.i("OfflineWebResManager", 2, "cache data size exceed threshold value ");
    }
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("select * from ");
    ((StringBuilder)localObject1).append(OfflineWebRes.class.getSimpleName());
    ((StringBuilder)localObject1).append(" where hitcount=1 limit 100");
    localObject1 = ((StringBuilder)localObject1).toString();
    Object localObject2 = this.b.rawQuery(OfflineWebRes.class, (String)localObject1, null);
    if ((localObject2 != null) && (((List)localObject2).size() > 0))
    {
      localObject1 = new StringBuilder(((List)localObject2).size() * 64);
      localObject2 = ((List)localObject2).iterator();
      while (((Iterator)localObject2).hasNext())
      {
        OfflineWebRes localOfflineWebRes = (OfflineWebRes)((Iterator)localObject2).next();
        File localFile = new File(paramFile, localOfflineWebRes.hashName);
        if (localFile.exists())
        {
          if (QLog.isColorLevel())
          {
            ((StringBuilder)localObject1).append("delete file: ");
            ((StringBuilder)localObject1).append(localFile.getPath());
            ((StringBuilder)localObject1).append("\n");
          }
          localFile.delete();
        }
        this.b.remove(localOfflineWebRes);
      }
      if ((QLog.isColorLevel()) && (!TextUtils.isEmpty(((StringBuilder)localObject1).toString()))) {
        QLog.i("OfflineWebResManager", 2, ((StringBuilder)localObject1).toString());
      }
    }
  }
  
  public static void a(String paramString)
  {
    if (!c.contains(paramString)) {
      c.add(paramString);
    }
  }
  
  private boolean a(File paramFile, long paramLong)
  {
    double d1 = paramLong;
    Double.isNaN(d1);
    paramLong = (d1 - 4194304.0D);
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("cache data size exceed cache max value ");
      ((StringBuilder)localObject1).append(paramLong);
      QLog.i("OfflineWebResManager", 2, ((StringBuilder)localObject1).toString());
    }
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("select * from ");
    ((StringBuilder)localObject1).append(OfflineWebRes.class.getSimpleName());
    ((StringBuilder)localObject1).append(" order by hitcount");
    localObject1 = ((StringBuilder)localObject1).toString();
    Object localObject2 = this.b.rawQuery(OfflineWebRes.class, (String)localObject1, null);
    localObject1 = new StringBuilder("");
    long l = paramLong;
    if (localObject2 != null)
    {
      l = paramLong;
      if (((List)localObject2).size() > 0)
      {
        localObject2 = ((List)localObject2).iterator();
        for (;;)
        {
          l = paramLong;
          if (!((Iterator)localObject2).hasNext()) {
            break;
          }
          OfflineWebRes localOfflineWebRes = (OfflineWebRes)((Iterator)localObject2).next();
          if (paramLong <= 0L)
          {
            l = paramLong;
            break;
          }
          File localFile = new File(paramFile, localOfflineWebRes.hashName);
          l = paramLong;
          if (localFile.exists())
          {
            StringBuilder localStringBuilder = new StringBuilder();
            localStringBuilder.append("delete file: ");
            localStringBuilder.append(localFile.getPath());
            localStringBuilder.append("\n");
            ((StringBuilder)localObject1).append(localStringBuilder.toString());
            l = paramLong - localFile.length();
            localFile.delete();
          }
          this.b.remove(localOfflineWebRes);
          paramLong = l;
        }
      }
    }
    if (QLog.isColorLevel()) {
      QLog.i("OfflineWebResManager", 2, ((StringBuilder)localObject1).toString());
    }
    if (l > 0L)
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("cache data size still exceed cache max value ");
      ((StringBuilder)localObject1).append(l);
      ((StringBuilder)localObject1).append(", now delete folder and database!");
      QLog.w("OfflineWebResManager", 1, ((StringBuilder)localObject1).toString());
      paramFile = paramFile.listFiles();
      if (paramFile != null)
      {
        if (paramFile.length == 0) {
          return true;
        }
        int j = paramFile.length;
        int i = 0;
        while (i < j)
        {
          paramFile[i].delete();
          i += 1;
        }
        this.b.drop(OfflineWebRes.class.getSimpleName());
        return false;
      }
      return true;
    }
    return false;
  }
  
  public static void c()
  {
    try
    {
      Object localObject = new File(BaseApplication.getContext().getApplicationContext().getFilesDir(), ClubContentJsonTask.e.a);
      if (((File)localObject).exists())
      {
        localObject = new JSONObject(FileUtils.readFileContent((File)localObject));
        if (((JSONObject)localObject).has("offinePkgReadFromDataCache")) {
          f = ((JSONObject)localObject).getBoolean("offinePkgReadFromDataCache");
        }
      }
    }
    catch (Exception localException)
    {
      if (QLog.isColorLevel()) {
        QLog.e("OfflineWebResManager", 2, "parse offline globle config error!", localException);
      }
    }
    if (!f) {
      QLog.w("OfflineWebResManager", 1, "can not use offline /data cache mode!");
    }
  }
  
  /* Error */
  private JSONObject e(String paramString)
  {
    // Byte code:
    //   0: aload_1
    //   1: invokestatic 261	com/tencent/biz/common/offline/OfflineEnvHelper:b	(Ljava/lang/String;)Ljava/lang/String;
    //   4: astore_3
    //   5: aload_3
    //   6: invokestatic 157	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   9: istore_2
    //   10: aconst_null
    //   11: astore 6
    //   13: iload_2
    //   14: ifeq +5 -> 19
    //   17: aconst_null
    //   18: areturn
    //   19: new 78	java/lang/StringBuilder
    //   22: dup
    //   23: invokespecial 79	java/lang/StringBuilder:<init>	()V
    //   26: astore 4
    //   28: aload 4
    //   30: aload_3
    //   31: invokevirtual 85	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   34: pop
    //   35: aload 4
    //   37: aload_1
    //   38: invokevirtual 85	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   41: pop
    //   42: aload 4
    //   44: invokevirtual 98	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   47: astore_3
    //   48: new 128	java/io/File
    //   51: dup
    //   52: aload_3
    //   53: invokespecial 262	java/io/File:<init>	(Ljava/lang/String;)V
    //   56: invokevirtual 137	java/io/File:exists	()Z
    //   59: ifne +10 -> 69
    //   62: aload_0
    //   63: aload_1
    //   64: invokevirtual 264	com/tencent/biz/webviewplugin/OfflineWebResManager:d	(Ljava/lang/String;)V
    //   67: aconst_null
    //   68: areturn
    //   69: getstatic 269	com/tencent/biz/common/offline/HtmlOffline:g	Ljava/util/concurrent/ConcurrentHashMap;
    //   72: ifnull +28 -> 100
    //   75: getstatic 269	com/tencent/biz/common/offline/HtmlOffline:g	Ljava/util/concurrent/ConcurrentHashMap;
    //   78: aload_1
    //   79: invokevirtual 274	java/util/concurrent/ConcurrentHashMap:containsKey	(Ljava/lang/Object;)Z
    //   82: ifeq +18 -> 100
    //   85: getstatic 269	com/tencent/biz/common/offline/HtmlOffline:g	Ljava/util/concurrent/ConcurrentHashMap;
    //   88: aload_1
    //   89: invokevirtual 278	java/util/concurrent/ConcurrentHashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   92: checkcast 280	java/lang/String
    //   95: astore 4
    //   97: goto +186 -> 283
    //   100: new 78	java/lang/StringBuilder
    //   103: dup
    //   104: invokespecial 79	java/lang/StringBuilder:<init>	()V
    //   107: astore 4
    //   109: aload 4
    //   111: aload_3
    //   112: invokevirtual 85	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   115: pop
    //   116: aload 4
    //   118: ldc_w 282
    //   121: invokevirtual 85	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   124: pop
    //   125: new 284	java/io/BufferedInputStream
    //   128: dup
    //   129: new 286	java/io/FileInputStream
    //   132: dup
    //   133: aload 4
    //   135: invokevirtual 98	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   138: invokespecial 287	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   141: invokespecial 290	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   144: astore 4
    //   146: aload 4
    //   148: astore 6
    //   150: aload 4
    //   152: invokestatic 295	com/tencent/biz/common/util/OfflineSecurity:a	(Ljava/io/BufferedInputStream;)Ljava/lang/String;
    //   155: astore_3
    //   156: aload 4
    //   158: astore 6
    //   160: getstatic 269	com/tencent/biz/common/offline/HtmlOffline:g	Ljava/util/concurrent/ConcurrentHashMap;
    //   163: ifnull +16 -> 179
    //   166: aload 4
    //   168: astore 6
    //   170: getstatic 269	com/tencent/biz/common/offline/HtmlOffline:g	Ljava/util/concurrent/ConcurrentHashMap;
    //   173: aload_1
    //   174: aload_3
    //   175: invokevirtual 299	java/util/concurrent/ConcurrentHashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   178: pop
    //   179: aload_3
    //   180: astore 6
    //   182: aload 4
    //   184: invokevirtual 302	java/io/BufferedInputStream:close	()V
    //   187: aload_3
    //   188: astore 4
    //   190: goto +93 -> 283
    //   193: astore_3
    //   194: aload_3
    //   195: invokevirtual 305	java/io/IOException:printStackTrace	()V
    //   198: aload 6
    //   200: astore 4
    //   202: goto +81 -> 283
    //   205: astore 7
    //   207: aload 4
    //   209: astore 5
    //   211: goto +29 -> 240
    //   214: astore_3
    //   215: goto +11 -> 226
    //   218: astore_1
    //   219: goto +124 -> 343
    //   222: astore_3
    //   223: aconst_null
    //   224: astore 4
    //   226: ldc 36
    //   228: astore 6
    //   230: aload_3
    //   231: astore 7
    //   233: aload 4
    //   235: astore 5
    //   237: aload 6
    //   239: astore_3
    //   240: aload 5
    //   242: astore 6
    //   244: invokestatic 68	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   247: ifeq +17 -> 264
    //   250: aload 5
    //   252: astore 6
    //   254: ldc 70
    //   256: iconst_2
    //   257: ldc 36
    //   259: aload 7
    //   261: invokestatic 251	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   264: aload_3
    //   265: astore 4
    //   267: aload 5
    //   269: ifnull +14 -> 283
    //   272: aload_3
    //   273: astore 6
    //   275: aload 5
    //   277: invokevirtual 302	java/io/BufferedInputStream:close	()V
    //   280: aload_3
    //   281: astore 4
    //   283: aload 4
    //   285: invokestatic 157	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   288: ifne +33 -> 321
    //   291: new 231	org/json/JSONObject
    //   294: dup
    //   295: aload 4
    //   297: invokespecial 238	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   300: astore_1
    //   301: aload_1
    //   302: areturn
    //   303: astore_1
    //   304: invokestatic 68	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   307: ifeq +12 -> 319
    //   310: ldc 70
    //   312: iconst_2
    //   313: ldc 36
    //   315: aload_1
    //   316: invokestatic 251	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   319: aconst_null
    //   320: areturn
    //   321: aload_0
    //   322: aload_1
    //   323: invokevirtual 264	com/tencent/biz/webviewplugin/OfflineWebResManager:d	(Ljava/lang/String;)V
    //   326: getstatic 269	com/tencent/biz/common/offline/HtmlOffline:g	Ljava/util/concurrent/ConcurrentHashMap;
    //   329: ifnull +11 -> 340
    //   332: getstatic 269	com/tencent/biz/common/offline/HtmlOffline:g	Ljava/util/concurrent/ConcurrentHashMap;
    //   335: aload_1
    //   336: invokevirtual 307	java/util/concurrent/ConcurrentHashMap:remove	(Ljava/lang/Object;)Ljava/lang/Object;
    //   339: pop
    //   340: aconst_null
    //   341: areturn
    //   342: astore_1
    //   343: aload 6
    //   345: ifnull +16 -> 361
    //   348: aload 6
    //   350: invokevirtual 302	java/io/BufferedInputStream:close	()V
    //   353: goto +8 -> 361
    //   356: astore_3
    //   357: aload_3
    //   358: invokevirtual 305	java/io/IOException:printStackTrace	()V
    //   361: aload_1
    //   362: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	363	0	this	OfflineWebResManager
    //   0	363	1	paramString	String
    //   9	5	2	bool	boolean
    //   4	184	3	str	String
    //   193	2	3	localIOException1	java.io.IOException
    //   214	1	3	localException1	Exception
    //   222	9	3	localException2	Exception
    //   239	42	3	localObject1	Object
    //   356	2	3	localIOException2	java.io.IOException
    //   26	270	4	localObject2	Object
    //   209	67	5	localObject3	Object
    //   11	338	6	localObject4	Object
    //   205	1	7	localException3	Exception
    //   231	29	7	localException4	Exception
    // Exception table:
    //   from	to	target	type
    //   182	187	193	java/io/IOException
    //   275	280	193	java/io/IOException
    //   160	166	205	java/lang/Exception
    //   170	179	205	java/lang/Exception
    //   150	156	214	java/lang/Exception
    //   100	146	218	finally
    //   100	146	222	java/lang/Exception
    //   291	301	303	java/lang/Exception
    //   150	156	342	finally
    //   160	166	342	finally
    //   170	179	342	finally
    //   244	250	342	finally
    //   254	264	342	finally
    //   348	353	356	java/io/IOException
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
    if (!f) {
      return;
    }
    if ((paramInt > 0) && (this.g.get())) {
      return;
    }
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("now check update url, deley: ");
      localStringBuilder.append(paramInt);
      QLog.i("OfflineWebResManager", 2, localStringBuilder.toString());
    }
    this.g.set(true);
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
      localObject1 = OfflineEnvHelper.b(paramOfflineWebRes.bid);
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
        this.b.persistOrReplace(paramOfflineWebRes);
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
          this.b.update(paramOfflineWebRes);
          return;
        }
        this.b.remove(paramOfflineWebRes);
      }
    }
  }
  
  public void a(String paramString1, String paramString2)
  {
    Object localObject1 = this.b.query(OfflineWebRes.class, false, "bid= ? and fileName= ?", new String[] { paramString2, paramString1 }, null, null, null, null);
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
          this.b.remove((Entity)localObject2, "bid= ? and fileName= ?", new String[] { paramString2, paramString1 });
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
  
  public OfflineWebRes b(String paramString)
  {
    if (!f) {
      return null;
    }
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    return (OfflineWebRes)this.b.find(OfflineWebRes.class, paramString);
  }
  
  public void b()
  {
    if (QLog.isColorLevel()) {
      QLog.i("OfflineWebResManager", 2, "now begin check cache size!");
    }
    Object localObject = new File(BaseApplication.getContext().getFilesDir(), "WebOfflineRes");
    long l;
    if (((File)localObject).exists())
    {
      if (!((File)localObject).isDirectory()) {
        return;
      }
      if (!this.b.tabbleIsExist(OfflineWebRes.class.getSimpleName())) {
        return;
      }
      l = 0L;
    }
    for (;;)
    {
      int i;
      try
      {
        File[] arrayOfFile = ((File)localObject).listFiles();
        if (arrayOfFile != null)
        {
          if (arrayOfFile.length == 0) {
            return;
          }
          int j = arrayOfFile.length;
          i = 0;
          if (i < j)
          {
            File localFile = arrayOfFile[i];
            if (!localFile.isDirectory())
            {
              l += localFile.length();
              break label241;
            }
            localFile.delete();
            break label241;
          }
          double d1 = l;
          if (d1 < 4194304.0D)
          {
            if (!QLog.isColorLevel()) {
              break;
            }
            localObject = new StringBuilder();
            ((StringBuilder)localObject).append("now /data cache size :");
            ((StringBuilder)localObject).append(l);
            QLog.i("OfflineWebResManager", 2, ((StringBuilder)localObject).toString());
            return;
          }
          if ((d1 >= 4194304.0D) && (l < 5242880L))
          {
            a((File)localObject);
            return;
          }
          boolean bool = a((File)localObject, l);
          if (!bool) {}
        }
        else
        {
          return;
        }
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
      }
      return;
      label241:
      i += 1;
    }
  }
  
  public void c(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    long l = System.currentTimeMillis();
    Object localObject1 = Uri.parse(paramString).getQueryParameter("_bid");
    Object localObject2 = localObject1;
    if (TextUtils.isEmpty((CharSequence)localObject1)) {
      localObject2 = this.d;
    }
    if (TextUtils.isEmpty((CharSequence)localObject2)) {
      return;
    }
    localObject1 = HtmlOffline.g(paramString);
    if (TextUtils.isEmpty((CharSequence)localObject1)) {
      return;
    }
    Object localObject3 = e((String)localObject2);
    if (localObject3 == null) {
      return;
    }
    String str1 = ((JSONObject)localObject3).optString((String)localObject1);
    if (!TextUtils.isEmpty(str1))
    {
      OfflineWebRes localOfflineWebRes = b(str1);
      localObject1 = localOfflineWebRes;
      if (localOfflineWebRes == null)
      {
        String str2 = HtmlOffline.g(paramString);
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
            d((String)localObject2);
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
        ((StringBuilder)localObject1).append(HtmlOffline.g(paramString));
        ((StringBuilder)localObject1).append(", cost: ");
        ((StringBuilder)localObject1).append(System.currentTimeMillis() - l);
        QLog.i("OfflineWebResManager", 2, ((StringBuilder)localObject1).toString());
      }
      return;
    }
    paramString = HtmlOffline.g(paramString);
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("now md5 not exits, fileName:");
      ((StringBuilder)localObject1).append(paramString);
      QLog.i("OfflineWebResManager", 2, ((StringBuilder)localObject1).toString());
    }
    a(paramString, (String)localObject2);
  }
  
  public void d(String paramString)
  {
    Object localObject1 = this.b.query(OfflineWebRes.class, false, "bid=?", new String[] { paramString }, null, null, null, null);
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
          this.b.remove((Entity)localObject2, "bid=?", new String[] { paramString });
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.webviewplugin.OfflineWebResManager
 * JD-Core Version:    0.7.0.1
 */