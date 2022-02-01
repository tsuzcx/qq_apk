package com.tencent.biz.common.offline;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.IntentFilter;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import com.tencent.biz.common.offline.util.IOfflineDownloader;
import com.tencent.biz.common.offline.util.IThreadManager;
import com.tencent.biz.common.offline.util.OfflineDownloader;
import com.tencent.biz.common.util.QQThreadManager;
import com.tencent.biz.common.util.Util;
import com.tencent.biz.common.util.ZipUtils;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.vas.LzmaUtils;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.util.WeakReference;

public class BidDownloader
  implements Handler.Callback
{
  public static IThreadManager q = new QQThreadManager();
  public static IOfflineDownloader r = new OfflineDownloader();
  public static String s = "BidDownloader";
  public static HashMap<String, Integer> t;
  public static ArrayList<BidDownloader> u;
  public static Context v;
  public static BidDownloader.WifiListener w;
  public static boolean x = false;
  public WeakReference<AsyncBack> a;
  public String b;
  public int c = 0;
  public boolean d = true;
  public boolean e = false;
  public boolean f = false;
  public boolean g = false;
  public boolean h = false;
  public boolean i = false;
  public int j = 0;
  public String k = null;
  public AsyncBack l;
  public String m;
  public int n = 0;
  public Handler o;
  public int p;
  
  public BidDownloader(String paramString, AppRuntime paramAppRuntime, AsyncBack paramAsyncBack, boolean paramBoolean, int paramInt)
  {
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    if (u == null)
    {
      u = new ArrayList();
      t = new HashMap();
      w = new BidDownloader.WifiListener();
    }
    this.a = new WeakReference(paramAsyncBack);
    v = paramAppRuntime.getApplication().getApplicationContext();
    this.b = paramString;
    this.d = paramBoolean;
    if (paramInt == 1) {
      this.e = true;
    } else if (paramInt == 3) {
      this.g = true;
    } else if (paramInt == 4) {
      this.h = true;
    } else if (paramInt == 2) {
      this.f = true;
    }
    paramString = OfflineEnvHelper.c(this.b);
    if (!TextUtils.isEmpty(paramString)) {
      if (this.h)
      {
        paramAppRuntime = new StringBuilder();
        paramAppRuntime.append(paramString);
        paramAppRuntime.append(this.b);
        paramAppRuntime.append(".7z");
        this.k = paramAppRuntime.toString();
      }
      else if ((!this.g) && (!this.f))
      {
        QLog.e(s, 1, "do not know what format, use default zip name!");
        paramAppRuntime = new StringBuilder();
        paramAppRuntime.append(paramString);
        paramAppRuntime.append(this.b);
        paramAppRuntime.append(".zip");
        this.k = paramAppRuntime.toString();
      }
      else
      {
        paramAppRuntime = new StringBuilder();
        paramAppRuntime.append(paramString);
        paramAppRuntime.append(this.b);
        paramAppRuntime.append(".zip");
        this.k = paramAppRuntime.toString();
      }
    }
    this.o = new Handler(Looper.getMainLooper(), this);
    this.c = 0;
  }
  
  protected static void a()
  {
    if (t.size() == 0)
    {
      Object localObject = u;
      if ((localObject != null) && (!((ArrayList)localObject).isEmpty()))
      {
        localObject = (BidDownloader)u.remove(0);
        if (v != null) {
          ((BidDownloader)localObject).d();
        }
      }
    }
  }
  
  private void a(int paramInt1, int paramInt2)
  {
    if (this.a.get() != null) {
      ((AsyncBack)this.a.get()).loaded(null, paramInt1);
    }
  }
  
  public static void a(int paramInt1, String paramString1, int paramInt2, int paramInt3, String paramString2, int paramInt4)
  {
    HashMap localHashMap = new HashMap(10);
    localHashMap.put("download_cost_time", String.valueOf(paramInt1));
    localHashMap.put("business_id", String.valueOf(paramString1));
    localHashMap.put("download_code", String.valueOf(paramInt2));
    localHashMap.put("download_network", String.valueOf(NetworkUtil.getNetWorkType()));
    localHashMap.put("download_version", String.valueOf(paramInt3));
    localHashMap.put("download_main_action", paramString2);
    localHashMap.put("download_sub_action", String.valueOf(paramInt4));
    try
    {
      paramString1 = MobileQQ.sMobileQQ.waitAppRuntime(null).getAccount();
    }
    catch (Throwable paramString1)
    {
      label110:
      break label110;
    }
    QLog.e(s, 1, "getAccount faild ！！！");
    paramString1 = "";
    localHashMap.put("qq_num", paramString1);
    StatisticCollector.getInstance(MobileQQ.getContext()).collectPerformance(paramString1, "offline_report", true, 0L, 0L, localHashMap, null);
  }
  
  protected static void a(String paramString)
  {
    if (t == null) {
      t = new HashMap();
    }
    if (t.get(paramString) == null)
    {
      t.put(paramString, Integer.valueOf(1));
      if (QLog.isColorLevel())
      {
        String str = s;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("addDownloadingState:");
        localStringBuilder.append(paramString);
        QLog.i(str, 2, localStringBuilder.toString());
      }
    }
  }
  
  public static boolean a(int paramInt)
  {
    return (paramInt == 0) || (paramInt == -1);
  }
  
  protected static void b(String paramString)
  {
    Object localObject = t;
    if (localObject == null) {
      return;
    }
    StringBuilder localStringBuilder;
    if (((HashMap)localObject).get(paramString) != null)
    {
      t.remove(paramString);
      if (QLog.isColorLevel())
      {
        localObject = s;
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("removeDownloadingState:");
        localStringBuilder.append(paramString);
        QLog.d((String)localObject, 2, localStringBuilder.toString());
      }
    }
    paramString = u;
    if ((paramString != null) && (!paramString.isEmpty()))
    {
      paramString = (BidDownloader)u.get(0);
      if (v != null)
      {
        if ((paramString.i) && (NetworkUtil.getNetWorkType() != 1) && (!x))
        {
          paramString = new IntentFilter();
          paramString.addAction("android.net.conn.CONNECTIVITY_CHANGE");
          v.registerReceiver(w, paramString);
          x = true;
          return;
        }
        if (QLog.isColorLevel())
        {
          localObject = s;
          localStringBuilder = new StringBuilder();
          localStringBuilder.append("start download from queue:");
          localStringBuilder.append(paramString.b);
          QLog.i((String)localObject, 2, localStringBuilder.toString());
        }
        paramString.d();
        u.remove(0);
        if ((x) && (u.size() == 0))
        {
          v.unregisterReceiver(w);
          x = false;
        }
      }
    }
  }
  
  protected static boolean c(String paramString)
  {
    HashMap localHashMap = t;
    if (localHashMap == null) {
      return false;
    }
    return localHashMap.get(paramString) != null;
  }
  
  /* Error */
  public static String d(String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokestatic 94	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   4: istore_1
    //   5: ldc 249
    //   7: astore 6
    //   9: iload_1
    //   10: ifeq +6 -> 16
    //   13: ldc 249
    //   15: areturn
    //   16: new 318	java/io/File
    //   19: dup
    //   20: aload_0
    //   21: invokespecial 320	java/io/File:<init>	(Ljava/lang/String;)V
    //   24: astore 5
    //   26: aload 5
    //   28: invokevirtual 323	java/io/File:exists	()Z
    //   31: ifne +53 -> 84
    //   34: invokestatic 279	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   37: ifeq +44 -> 81
    //   40: getstatic 63	com/tencent/biz/common/offline/BidDownloader:s	Ljava/lang/String;
    //   43: astore 4
    //   45: new 139	java/lang/StringBuilder
    //   48: dup
    //   49: invokespecial 140	java/lang/StringBuilder:<init>	()V
    //   52: astore 5
    //   54: aload 5
    //   56: ldc_w 325
    //   59: invokevirtual 144	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   62: pop
    //   63: aload 5
    //   65: aload_0
    //   66: invokevirtual 144	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   69: pop
    //   70: aload 4
    //   72: iconst_2
    //   73: aload 5
    //   75: invokevirtual 150	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   78: invokestatic 283	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   81: ldc 249
    //   83: areturn
    //   84: aconst_null
    //   85: astore 7
    //   87: aconst_null
    //   88: astore 4
    //   90: new 327	java/io/RandomAccessFile
    //   93: dup
    //   94: aload 5
    //   96: ldc_w 328
    //   99: invokespecial 331	java/io/RandomAccessFile:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   102: astore 5
    //   104: aload 5
    //   106: lconst_0
    //   107: invokevirtual 335	java/io/RandomAccessFile:seek	(J)V
    //   110: aload 5
    //   112: invokevirtual 338	java/io/RandomAccessFile:readInt	()I
    //   115: invokestatic 342	java/lang/Integer:reverseBytes	(I)I
    //   118: i2l
    //   119: lstore_2
    //   120: lload_2
    //   121: ldc2_w 343
    //   124: lcmp
    //   125: ifne +10 -> 135
    //   128: ldc_w 346
    //   131: astore_0
    //   132: goto +18 -> 150
    //   135: aload 6
    //   137: astore_0
    //   138: lload_2
    //   139: ldc2_w 347
    //   142: lcmp
    //   143: ifne +7 -> 150
    //   146: ldc_w 350
    //   149: astore_0
    //   150: aload_0
    //   151: astore 6
    //   153: aload 5
    //   155: invokevirtual 353	java/io/RandomAccessFile:close	()V
    //   158: aload_0
    //   159: areturn
    //   160: astore_0
    //   161: aload 5
    //   163: astore 4
    //   165: goto +108 -> 273
    //   168: astore 7
    //   170: goto +17 -> 187
    //   173: astore_0
    //   174: goto +99 -> 273
    //   177: astore 4
    //   179: aload 7
    //   181: astore 5
    //   183: aload 4
    //   185: astore 7
    //   187: aload 5
    //   189: astore 4
    //   191: invokestatic 279	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   194: ifeq +66 -> 260
    //   197: aload 5
    //   199: astore 4
    //   201: getstatic 63	com/tencent/biz/common/offline/BidDownloader:s	Ljava/lang/String;
    //   204: astore 8
    //   206: aload 5
    //   208: astore 4
    //   210: new 139	java/lang/StringBuilder
    //   213: dup
    //   214: invokespecial 140	java/lang/StringBuilder:<init>	()V
    //   217: astore 9
    //   219: aload 5
    //   221: astore 4
    //   223: aload 9
    //   225: ldc_w 355
    //   228: invokevirtual 144	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   231: pop
    //   232: aload 5
    //   234: astore 4
    //   236: aload 9
    //   238: aload_0
    //   239: invokevirtual 144	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   242: pop
    //   243: aload 5
    //   245: astore 4
    //   247: aload 8
    //   249: iconst_2
    //   250: aload 9
    //   252: invokevirtual 150	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   255: aload 7
    //   257: invokestatic 358	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   260: aload 5
    //   262: ifnull +8 -> 270
    //   265: aload 5
    //   267: invokevirtual 353	java/io/RandomAccessFile:close	()V
    //   270: ldc 249
    //   272: areturn
    //   273: aload 4
    //   275: ifnull +8 -> 283
    //   278: aload 4
    //   280: invokevirtual 353	java/io/RandomAccessFile:close	()V
    //   283: aload_0
    //   284: athrow
    //   285: astore_0
    //   286: aload 6
    //   288: areturn
    //   289: astore 4
    //   291: goto -8 -> 283
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	294	0	paramString	String
    //   4	6	1	bool	boolean
    //   119	20	2	l1	long
    //   43	121	4	localObject1	Object
    //   177	7	4	localException1	java.lang.Exception
    //   189	90	4	localObject2	Object
    //   289	1	4	localException2	java.lang.Exception
    //   24	242	5	localObject3	Object
    //   7	280	6	str1	String
    //   85	1	7	localObject4	Object
    //   168	12	7	localException3	java.lang.Exception
    //   185	71	7	localException4	java.lang.Exception
    //   204	44	8	str2	String
    //   217	34	9	localStringBuilder	StringBuilder
    // Exception table:
    //   from	to	target	type
    //   104	120	160	finally
    //   104	120	168	java/lang/Exception
    //   90	104	173	finally
    //   191	197	173	finally
    //   201	206	173	finally
    //   210	219	173	finally
    //   223	232	173	finally
    //   236	243	173	finally
    //   247	260	173	finally
    //   90	104	177	java/lang/Exception
    //   153	158	285	java/lang/Exception
    //   265	270	285	java/lang/Exception
    //   278	283	289	java/lang/Exception
  }
  
  private void f()
  {
    String str;
    StringBuilder localStringBuilder;
    if (c(this.b))
    {
      if (QLog.isColorLevel())
      {
        str = s;
        localStringBuilder = new StringBuilder();
        localStringBuilder.append(this.b);
        localStringBuilder.append(" is downloading");
        QLog.i(str, 2, localStringBuilder.toString());
      }
      return;
    }
    if (QLog.isColorLevel())
    {
      str = s;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(this.b);
      localStringBuilder.append("download");
      QLog.i(str, 2, localStringBuilder.toString());
    }
    if (t.size() >= 1)
    {
      a(this);
      if (QLog.isColorLevel())
      {
        str = s;
        localStringBuilder = new StringBuilder();
        localStringBuilder.append(t);
        localStringBuilder.append(",");
        localStringBuilder.append(this.b);
        localStringBuilder.append("add to queue");
        QLog.i(str, 2, localStringBuilder.toString());
      }
    }
    else
    {
      HtmlOffline.d(v.getApplicationContext(), this.b);
      c();
      if (QLog.isColorLevel())
      {
        str = s;
        localStringBuilder = new StringBuilder();
        localStringBuilder.append(this.b);
        localStringBuilder.append(this.m);
        localStringBuilder.append(this.l);
        QLog.i(str, 2, localStringBuilder.toString());
      }
      a(this.b);
    }
  }
  
  protected void a(BidDownloader paramBidDownloader)
  {
    int i2 = u.size();
    int i1 = 0;
    while (i1 < i2)
    {
      BidDownloader localBidDownloader = (BidDownloader)u.get(i1);
      if (paramBidDownloader.b.equals(localBidDownloader.b)) {
        return;
      }
      i1 += 1;
    }
    u.add(paramBidDownloader);
  }
  
  @TargetApi(11)
  boolean b()
  {
    long l1 = System.currentTimeMillis();
    if (TextUtils.isEmpty(this.k)) {
      return false;
    }
    this.l = new BidDownloader.1(this, l1);
    this.o.sendEmptyMessage(1);
    return true;
  }
  
  public void c()
  {
    q.c(new BidDownloader.2(this));
  }
  
  public void d()
  {
    if (c(this.b))
    {
      if (QLog.isColorLevel())
      {
        String str = s;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append(this.b);
        localStringBuilder.append(" is downloading");
        QLog.i(str, 2, localStringBuilder.toString());
      }
      return;
    }
    q.c(new BidDownloader.4(this));
  }
  
  public boolean e()
  {
    try
    {
      str = this.b;
      localObject4 = this.k;
      bool1 = TextUtils.isEmpty(str);
      bool2 = false;
      if (bool1) {
        return false;
      }
      bool1 = TextUtils.isEmpty(OfflineEnvHelper.c(str));
      if (bool1) {
        return false;
      }
      localObject3 = new File((String)localObject4);
      if (!((File)localObject3).exists())
      {
        if (QLog.isColorLevel())
        {
          localObject2 = s;
          localObject3 = new StringBuilder();
          ((StringBuilder)localObject3).append("doUnzipZip: no zip ! : businessId:");
          ((StringBuilder)localObject3).append(str);
          QLog.i((String)localObject2, 2, ((StringBuilder)localObject3).toString());
        }
        return false;
      }
      l1 = System.currentTimeMillis();
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append(((File)localObject3).getParent());
      ((StringBuilder)localObject2).append(File.separator);
      ((StringBuilder)localObject2).append(str);
      localObject2 = ((StringBuilder)localObject2).toString();
      localObject5 = d((String)localObject4);
      if (QLog.isColorLevel())
      {
        localObject6 = s;
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("fileFormat: ");
        localStringBuilder.append((String)localObject5);
        localStringBuilder.append(", path: ");
        localStringBuilder.append((String)localObject4);
        QLog.i((String)localObject6, 2, localStringBuilder.toString());
      }
      if (!TextUtils.isEmpty((CharSequence)localObject5))
      {
        if (((String)localObject5).equals("zip"))
        {
          i1 = ZipUtils.unZipFolder((String)localObject4, (String)localObject2);
        }
        else
        {
          if (!((String)localObject5).equals("7z")) {
            break label886;
          }
          i1 = LzmaUtils.a(BaseApplication.getContext().getApplicationContext(), (String)localObject4, (String)localObject2);
        }
      }
      else
      {
        localObject5 = s;
        localObject6 = new StringBuilder();
        ((StringBuilder)localObject6).append("can not recognize download compress file format, ");
        ((StringBuilder)localObject6).append(this.k);
        QLog.w((String)localObject5, 1, ((StringBuilder)localObject6).toString());
        if (this.g)
        {
          i1 = ZipUtils.unZipFolder((String)localObject4, (String)localObject2);
        }
        else
        {
          if (!this.h) {
            break label886;
          }
          i1 = LzmaUtils.a(BaseApplication.getContext().getApplicationContext(), (String)localObject4, (String)localObject2);
        }
      }
    }
    finally
    {
      for (;;)
      {
        String str;
        Object localObject4;
        boolean bool1;
        boolean bool2;
        Object localObject3;
        Object localObject2;
        long l1;
        Object localObject5;
        Object localObject6;
        StringBuilder localStringBuilder;
        boolean bool3;
        for (;;)
        {
          throw localObject1;
        }
        continue;
        label886:
        int i1 = 1;
      }
    }
    if (QLog.isColorLevel())
    {
      localObject5 = s;
      localObject6 = new StringBuilder();
      ((StringBuilder)localObject6).append("now delete original download offline zip, path: ");
      ((StringBuilder)localObject6).append((String)localObject4);
      QLog.i((String)localObject5, 2, ((StringBuilder)localObject6).toString());
    }
    Util.b((String)localObject4);
    if (i1 > 0)
    {
      HtmlOffline.a(str, 13, 0L, i1, "lixian_update", "0");
      a(0, str, 13, 0, "lixian_update", i1);
      bool1 = bool2;
      if (QLog.isColorLevel())
      {
        QLog.i(s, 2, "unZipFolder fail!");
        bool1 = bool2;
      }
    }
    else
    {
      localObject4 = new StringBuilder();
      ((StringBuilder)localObject4).append((String)localObject2);
      ((StringBuilder)localObject4).append(File.separator);
      ((StringBuilder)localObject4).append(str);
      ((StringBuilder)localObject4).append(".zip");
      localObject4 = ((StringBuilder)localObject4).toString();
      localObject5 = new File((String)localObject4);
      localObject6 = new StringBuilder();
      ((StringBuilder)localObject6).append(((File)localObject3).getParent());
      ((StringBuilder)localObject6).append(File.separator);
      ((StringBuilder)localObject6).append(str);
      ((StringBuilder)localObject6).append(".zip");
      localObject3 = ((StringBuilder)localObject6).toString();
      if (QLog.isColorLevel())
      {
        localObject6 = s;
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("now move zip file to location: ");
        localStringBuilder.append((String)localObject3);
        QLog.i((String)localObject6, 2, localStringBuilder.toString());
      }
      if (((File)localObject5).exists())
      {
        bool3 = ((File)localObject5).renameTo(new File((String)localObject3));
        bool1 = bool3;
        if (!bool3) {
          bool1 = FileUtils.moveFile((String)localObject4, (String)localObject3);
        }
        if (!bool1)
        {
          HtmlOffline.a(str, 13, 0L, i1, "lixian_update", "0");
          a(0, str, 13, 0, "lixian_update", i1);
          bool1 = bool2;
        }
        else
        {
          HtmlOffline.a(str, 13, 0L, i1, "lixian_time", "0");
          a(0, str, 13, 0, "lixian_time", i1);
          bool1 = true;
        }
      }
      else
      {
        HtmlOffline.a(str, 13, 0L, i1, "lixian_update", "0");
        a(0, str, 13, 0, "lixian_update", i1);
        bool1 = bool2;
      }
    }
    Util.a((String)localObject2);
    if (QLog.isColorLevel())
    {
      str = s;
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("time of unzip zip：");
      ((StringBuilder)localObject2).append(System.currentTimeMillis() - l1);
      ((StringBuilder)localObject2).append(", isSuccess: ");
      ((StringBuilder)localObject2).append(bool1);
      QLog.i(str, 2, ((StringBuilder)localObject2).toString());
    }
    return bool1;
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    int i1 = paramMessage.what;
    if (i1 != 0)
    {
      if (i1 != 1)
      {
        if (i1 != 2)
        {
          if (i1 == 3) {
            f();
          }
        }
        else {
          a(paramMessage.arg1, paramMessage.arg2);
        }
      }
      else {
        d();
      }
    }
    else {
      b(this.b);
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.common.offline.BidDownloader
 * JD-Core Version:    0.7.0.1
 */