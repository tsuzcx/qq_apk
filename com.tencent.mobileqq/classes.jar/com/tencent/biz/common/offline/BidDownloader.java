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
  public static Context a;
  public static BidDownloader.WifiListener a;
  public static IOfflineDownloader a;
  public static IThreadManager a;
  public static ArrayList<BidDownloader> a;
  public static HashMap<String, Integer> a;
  public static String d;
  public static boolean g = false;
  public int a;
  public Handler a;
  public AsyncBack a;
  public String a;
  public WeakReference<AsyncBack> a;
  public boolean a;
  public int b;
  public String b;
  public boolean b;
  public int c;
  public String c;
  public boolean c;
  public int d;
  public boolean d;
  public boolean e = false;
  public boolean f = false;
  
  static
  {
    jdField_a_of_type_ComTencentBizCommonOfflineUtilIThreadManager = new QQThreadManager();
    jdField_a_of_type_ComTencentBizCommonOfflineUtilIOfflineDownloader = new OfflineDownloader();
    jdField_d_of_type_JavaLangString = "BidDownloader";
  }
  
  public BidDownloader(String paramString, AppRuntime paramAppRuntime, AsyncBack paramAsyncBack, boolean paramBoolean, int paramInt)
  {
    this.jdField_a_of_type_Int = 0;
    this.jdField_a_of_type_Boolean = true;
    this.jdField_b_of_type_Boolean = false;
    this.jdField_c_of_type_Boolean = false;
    this.jdField_d_of_type_Boolean = false;
    this.jdField_b_of_type_Int = 0;
    this.jdField_b_of_type_JavaLangString = null;
    this.jdField_c_of_type_Int = 0;
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    if (jdField_a_of_type_JavaUtilArrayList == null)
    {
      jdField_a_of_type_JavaUtilArrayList = new ArrayList();
      jdField_a_of_type_JavaUtilHashMap = new HashMap();
      jdField_a_of_type_ComTencentBizCommonOfflineBidDownloader$WifiListener = new BidDownloader.WifiListener();
    }
    this.jdField_a_of_type_MqqUtilWeakReference = new WeakReference(paramAsyncBack);
    jdField_a_of_type_AndroidContentContext = paramAppRuntime.getApplication().getApplicationContext();
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_Boolean = paramBoolean;
    if (paramInt == 1) {
      this.jdField_b_of_type_Boolean = true;
    } else if (paramInt == 3) {
      this.jdField_d_of_type_Boolean = true;
    } else if (paramInt == 4) {
      this.e = true;
    } else if (paramInt == 2) {
      this.jdField_c_of_type_Boolean = true;
    }
    paramString = OfflineEnvHelper.b(this.jdField_a_of_type_JavaLangString);
    if (!TextUtils.isEmpty(paramString)) {
      if (this.e)
      {
        paramAppRuntime = new StringBuilder();
        paramAppRuntime.append(paramString);
        paramAppRuntime.append(this.jdField_a_of_type_JavaLangString);
        paramAppRuntime.append(".7z");
        this.jdField_b_of_type_JavaLangString = paramAppRuntime.toString();
      }
      else if ((!this.jdField_d_of_type_Boolean) && (!this.jdField_c_of_type_Boolean))
      {
        QLog.e(jdField_d_of_type_JavaLangString, 1, "do not know what format, use default zip name!");
        paramAppRuntime = new StringBuilder();
        paramAppRuntime.append(paramString);
        paramAppRuntime.append(this.jdField_a_of_type_JavaLangString);
        paramAppRuntime.append(".zip");
        this.jdField_b_of_type_JavaLangString = paramAppRuntime.toString();
      }
      else
      {
        paramAppRuntime = new StringBuilder();
        paramAppRuntime.append(paramString);
        paramAppRuntime.append(this.jdField_a_of_type_JavaLangString);
        paramAppRuntime.append(".zip");
        this.jdField_b_of_type_JavaLangString = paramAppRuntime.toString();
      }
    }
    this.jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper(), this);
    this.jdField_a_of_type_Int = 0;
  }
  
  /* Error */
  public static String a(String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokestatic 77	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   4: istore_1
    //   5: ldc 159
    //   7: astore 6
    //   9: iload_1
    //   10: ifeq +6 -> 16
    //   13: ldc 159
    //   15: areturn
    //   16: new 161	java/io/File
    //   19: dup
    //   20: aload_0
    //   21: invokespecial 164	java/io/File:<init>	(Ljava/lang/String;)V
    //   24: astore 5
    //   26: aload 5
    //   28: invokevirtual 168	java/io/File:exists	()Z
    //   31: ifne +52 -> 83
    //   34: invokestatic 171	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   37: ifeq +43 -> 80
    //   40: getstatic 46	com/tencent/biz/common/offline/BidDownloader:jdField_d_of_type_JavaLangString	Ljava/lang/String;
    //   43: astore 4
    //   45: new 122	java/lang/StringBuilder
    //   48: dup
    //   49: invokespecial 123	java/lang/StringBuilder:<init>	()V
    //   52: astore 5
    //   54: aload 5
    //   56: ldc 173
    //   58: invokevirtual 127	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   61: pop
    //   62: aload 5
    //   64: aload_0
    //   65: invokevirtual 127	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   68: pop
    //   69: aload 4
    //   71: iconst_2
    //   72: aload 5
    //   74: invokevirtual 133	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   77: invokestatic 176	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   80: ldc 159
    //   82: areturn
    //   83: aconst_null
    //   84: astore 7
    //   86: aconst_null
    //   87: astore 4
    //   89: new 178	java/io/RandomAccessFile
    //   92: dup
    //   93: aload 5
    //   95: ldc 180
    //   97: invokespecial 183	java/io/RandomAccessFile:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   100: astore 5
    //   102: aload 5
    //   104: lconst_0
    //   105: invokevirtual 187	java/io/RandomAccessFile:seek	(J)V
    //   108: aload 5
    //   110: invokevirtual 191	java/io/RandomAccessFile:readInt	()I
    //   113: invokestatic 197	java/lang/Integer:reverseBytes	(I)I
    //   116: i2l
    //   117: lstore_2
    //   118: lload_2
    //   119: ldc2_w 198
    //   122: lcmp
    //   123: ifne +9 -> 132
    //   126: ldc 201
    //   128: astore_0
    //   129: goto +17 -> 146
    //   132: aload 6
    //   134: astore_0
    //   135: lload_2
    //   136: ldc2_w 202
    //   139: lcmp
    //   140: ifne +6 -> 146
    //   143: ldc 205
    //   145: astore_0
    //   146: aload_0
    //   147: astore 6
    //   149: aload 5
    //   151: invokevirtual 208	java/io/RandomAccessFile:close	()V
    //   154: aload_0
    //   155: areturn
    //   156: astore_0
    //   157: aload 5
    //   159: astore 4
    //   161: goto +107 -> 268
    //   164: astore 7
    //   166: goto +17 -> 183
    //   169: astore_0
    //   170: goto +98 -> 268
    //   173: astore 4
    //   175: aload 7
    //   177: astore 5
    //   179: aload 4
    //   181: astore 7
    //   183: aload 5
    //   185: astore 4
    //   187: invokestatic 171	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   190: ifeq +65 -> 255
    //   193: aload 5
    //   195: astore 4
    //   197: getstatic 46	com/tencent/biz/common/offline/BidDownloader:jdField_d_of_type_JavaLangString	Ljava/lang/String;
    //   200: astore 8
    //   202: aload 5
    //   204: astore 4
    //   206: new 122	java/lang/StringBuilder
    //   209: dup
    //   210: invokespecial 123	java/lang/StringBuilder:<init>	()V
    //   213: astore 9
    //   215: aload 5
    //   217: astore 4
    //   219: aload 9
    //   221: ldc 210
    //   223: invokevirtual 127	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   226: pop
    //   227: aload 5
    //   229: astore 4
    //   231: aload 9
    //   233: aload_0
    //   234: invokevirtual 127	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   237: pop
    //   238: aload 5
    //   240: astore 4
    //   242: aload 8
    //   244: iconst_2
    //   245: aload 9
    //   247: invokevirtual 133	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   250: aload 7
    //   252: invokestatic 213	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   255: aload 5
    //   257: ifnull +8 -> 265
    //   260: aload 5
    //   262: invokevirtual 208	java/io/RandomAccessFile:close	()V
    //   265: ldc 159
    //   267: areturn
    //   268: aload 4
    //   270: ifnull +8 -> 278
    //   273: aload 4
    //   275: invokevirtual 208	java/io/RandomAccessFile:close	()V
    //   278: aload_0
    //   279: athrow
    //   280: astore_0
    //   281: aload 6
    //   283: areturn
    //   284: astore 4
    //   286: goto -8 -> 278
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	289	0	paramString	String
    //   4	6	1	bool	boolean
    //   117	19	2	l	long
    //   43	117	4	localObject1	Object
    //   173	7	4	localException1	java.lang.Exception
    //   185	89	4	localObject2	Object
    //   284	1	4	localException2	java.lang.Exception
    //   24	237	5	localObject3	Object
    //   7	275	6	str1	String
    //   84	1	7	localObject4	Object
    //   164	12	7	localException3	java.lang.Exception
    //   181	70	7	localException4	java.lang.Exception
    //   200	43	8	str2	String
    //   213	33	9	localStringBuilder	StringBuilder
    // Exception table:
    //   from	to	target	type
    //   102	118	156	finally
    //   102	118	164	java/lang/Exception
    //   89	102	169	finally
    //   187	193	169	finally
    //   197	202	169	finally
    //   206	215	169	finally
    //   219	227	169	finally
    //   231	238	169	finally
    //   242	255	169	finally
    //   89	102	173	java/lang/Exception
    //   149	154	280	java/lang/Exception
    //   260	265	280	java/lang/Exception
    //   273	278	284	java/lang/Exception
  }
  
  protected static void a()
  {
    if (jdField_a_of_type_JavaUtilHashMap.size() == 0)
    {
      Object localObject = jdField_a_of_type_JavaUtilArrayList;
      if ((localObject != null) && (!((ArrayList)localObject).isEmpty()))
      {
        localObject = (BidDownloader)jdField_a_of_type_JavaUtilArrayList.remove(0);
        if (jdField_a_of_type_AndroidContentContext != null) {
          ((BidDownloader)localObject).c();
        }
      }
    }
  }
  
  private void a(int paramInt1, int paramInt2)
  {
    if (this.jdField_a_of_type_MqqUtilWeakReference.get() != null) {
      ((AsyncBack)this.jdField_a_of_type_MqqUtilWeakReference.get()).loaded(null, paramInt1);
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
      label115:
      break label115;
    }
    QLog.e(jdField_d_of_type_JavaLangString, 1, "getAccount faild ！！！");
    paramString1 = "";
    localHashMap.put("qq_num", paramString1);
    StatisticCollector.getInstance(MobileQQ.getContext()).collectPerformance(paramString1, "offline_report", true, 0L, 0L, localHashMap, null);
  }
  
  protected static void a(String paramString)
  {
    if (jdField_a_of_type_JavaUtilHashMap == null) {
      jdField_a_of_type_JavaUtilHashMap = new HashMap();
    }
    if (jdField_a_of_type_JavaUtilHashMap.get(paramString) == null)
    {
      jdField_a_of_type_JavaUtilHashMap.put(paramString, Integer.valueOf(1));
      if (QLog.isColorLevel())
      {
        String str = jdField_d_of_type_JavaLangString;
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
  
  protected static boolean a(String paramString)
  {
    HashMap localHashMap = jdField_a_of_type_JavaUtilHashMap;
    if (localHashMap == null) {
      return false;
    }
    return localHashMap.get(paramString) != null;
  }
  
  protected static void b(String paramString)
  {
    Object localObject = jdField_a_of_type_JavaUtilHashMap;
    if (localObject == null) {
      return;
    }
    StringBuilder localStringBuilder;
    if (((HashMap)localObject).get(paramString) != null)
    {
      jdField_a_of_type_JavaUtilHashMap.remove(paramString);
      if (QLog.isColorLevel())
      {
        localObject = jdField_d_of_type_JavaLangString;
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("removeDownloadingState:");
        localStringBuilder.append(paramString);
        QLog.d((String)localObject, 2, localStringBuilder.toString());
      }
    }
    paramString = jdField_a_of_type_JavaUtilArrayList;
    if ((paramString != null) && (!paramString.isEmpty()))
    {
      paramString = (BidDownloader)jdField_a_of_type_JavaUtilArrayList.get(0);
      if (jdField_a_of_type_AndroidContentContext != null)
      {
        if ((paramString.f) && (NetworkUtil.getNetWorkType() != 1) && (!g))
        {
          paramString = new IntentFilter();
          paramString.addAction("android.net.conn.CONNECTIVITY_CHANGE");
          jdField_a_of_type_AndroidContentContext.registerReceiver(jdField_a_of_type_ComTencentBizCommonOfflineBidDownloader$WifiListener, paramString);
          g = true;
          return;
        }
        if (QLog.isColorLevel())
        {
          localObject = jdField_d_of_type_JavaLangString;
          localStringBuilder = new StringBuilder();
          localStringBuilder.append("start download from queue:");
          localStringBuilder.append(paramString.jdField_a_of_type_JavaLangString);
          QLog.i((String)localObject, 2, localStringBuilder.toString());
        }
        paramString.c();
        jdField_a_of_type_JavaUtilArrayList.remove(0);
        if ((g) && (jdField_a_of_type_JavaUtilArrayList.size() == 0))
        {
          jdField_a_of_type_AndroidContentContext.unregisterReceiver(jdField_a_of_type_ComTencentBizCommonOfflineBidDownloader$WifiListener);
          g = false;
        }
      }
    }
  }
  
  private void d()
  {
    String str;
    StringBuilder localStringBuilder;
    if (a(this.jdField_a_of_type_JavaLangString))
    {
      if (QLog.isColorLevel())
      {
        str = jdField_d_of_type_JavaLangString;
        localStringBuilder = new StringBuilder();
        localStringBuilder.append(this.jdField_a_of_type_JavaLangString);
        localStringBuilder.append(" is downloading");
        QLog.i(str, 2, localStringBuilder.toString());
      }
      return;
    }
    if (QLog.isColorLevel())
    {
      str = jdField_d_of_type_JavaLangString;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(this.jdField_a_of_type_JavaLangString);
      localStringBuilder.append("download");
      QLog.i(str, 2, localStringBuilder.toString());
    }
    if (jdField_a_of_type_JavaUtilHashMap.size() >= 1)
    {
      a(this);
      if (QLog.isColorLevel())
      {
        str = jdField_d_of_type_JavaLangString;
        localStringBuilder = new StringBuilder();
        localStringBuilder.append(jdField_a_of_type_JavaUtilHashMap);
        localStringBuilder.append(",");
        localStringBuilder.append(this.jdField_a_of_type_JavaLangString);
        localStringBuilder.append("add to queue");
        QLog.i(str, 2, localStringBuilder.toString());
      }
    }
    else
    {
      HtmlOffline.a(jdField_a_of_type_AndroidContentContext.getApplicationContext(), this.jdField_a_of_type_JavaLangString);
      b();
      if (QLog.isColorLevel())
      {
        str = jdField_d_of_type_JavaLangString;
        localStringBuilder = new StringBuilder();
        localStringBuilder.append(this.jdField_a_of_type_JavaLangString);
        localStringBuilder.append(this.jdField_c_of_type_JavaLangString);
        localStringBuilder.append(this.jdField_a_of_type_ComTencentBizCommonOfflineAsyncBack);
        QLog.i(str, 2, localStringBuilder.toString());
      }
      a(this.jdField_a_of_type_JavaLangString);
    }
  }
  
  protected void a(BidDownloader paramBidDownloader)
  {
    int j = jdField_a_of_type_JavaUtilArrayList.size();
    int i = 0;
    while (i < j)
    {
      BidDownloader localBidDownloader = (BidDownloader)jdField_a_of_type_JavaUtilArrayList.get(i);
      if (paramBidDownloader.jdField_a_of_type_JavaLangString.equals(localBidDownloader.jdField_a_of_type_JavaLangString)) {
        return;
      }
      i += 1;
    }
    jdField_a_of_type_JavaUtilArrayList.add(paramBidDownloader);
  }
  
  @TargetApi(11)
  boolean a()
  {
    long l = System.currentTimeMillis();
    if (TextUtils.isEmpty(this.jdField_b_of_type_JavaLangString)) {
      return false;
    }
    this.jdField_a_of_type_ComTencentBizCommonOfflineAsyncBack = new BidDownloader.1(this, l);
    this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(1);
    return true;
  }
  
  public void b()
  {
    jdField_a_of_type_ComTencentBizCommonOfflineUtilIThreadManager.c(new BidDownloader.2(this));
  }
  
  public boolean b()
  {
    try
    {
      str = this.jdField_a_of_type_JavaLangString;
      localObject4 = this.jdField_b_of_type_JavaLangString;
      bool1 = TextUtils.isEmpty(str);
      bool2 = false;
      if (bool1) {
        return false;
      }
      bool1 = TextUtils.isEmpty(OfflineEnvHelper.b(str));
      if (bool1) {
        return false;
      }
      localObject3 = new File((String)localObject4);
      if (!((File)localObject3).exists())
      {
        if (QLog.isColorLevel())
        {
          localObject2 = jdField_d_of_type_JavaLangString;
          localObject3 = new StringBuilder();
          ((StringBuilder)localObject3).append("doUnzipZip: no zip ! : businessId:");
          ((StringBuilder)localObject3).append(str);
          QLog.i((String)localObject2, 2, ((StringBuilder)localObject3).toString());
        }
        return false;
      }
      l = System.currentTimeMillis();
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append(((File)localObject3).getParent());
      ((StringBuilder)localObject2).append(File.separator);
      ((StringBuilder)localObject2).append(str);
      localObject2 = ((StringBuilder)localObject2).toString();
      localObject5 = a((String)localObject4);
      if (QLog.isColorLevel())
      {
        localObject6 = jdField_d_of_type_JavaLangString;
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
          i = ZipUtils.unZipFolder((String)localObject4, (String)localObject2);
        }
        else
        {
          if (!((String)localObject5).equals("7z")) {
            break label884;
          }
          i = LzmaUtils.a(BaseApplication.getContext().getApplicationContext(), (String)localObject4, (String)localObject2);
        }
      }
      else
      {
        localObject5 = jdField_d_of_type_JavaLangString;
        localObject6 = new StringBuilder();
        ((StringBuilder)localObject6).append("can not recognize download compress file format, ");
        ((StringBuilder)localObject6).append(this.jdField_b_of_type_JavaLangString);
        QLog.w((String)localObject5, 1, ((StringBuilder)localObject6).toString());
        if (this.jdField_d_of_type_Boolean)
        {
          i = ZipUtils.unZipFolder((String)localObject4, (String)localObject2);
        }
        else
        {
          if (!this.e) {
            break label884;
          }
          i = LzmaUtils.a(BaseApplication.getContext().getApplicationContext(), (String)localObject4, (String)localObject2);
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
        long l;
        Object localObject5;
        Object localObject6;
        StringBuilder localStringBuilder;
        boolean bool3;
        for (;;)
        {
          throw localObject1;
        }
        continue;
        label884:
        int i = 1;
      }
    }
    if (QLog.isColorLevel())
    {
      localObject5 = jdField_d_of_type_JavaLangString;
      localObject6 = new StringBuilder();
      ((StringBuilder)localObject6).append("now delete original download offline zip, path: ");
      ((StringBuilder)localObject6).append((String)localObject4);
      QLog.i((String)localObject5, 2, ((StringBuilder)localObject6).toString());
    }
    Util.b((String)localObject4);
    if (i > 0)
    {
      HtmlOffline.a(str, 13, 0L, i, "lixian_update", "0");
      a(0, str, 13, 0, "lixian_update", i);
      bool1 = bool2;
      if (QLog.isColorLevel())
      {
        QLog.i(jdField_d_of_type_JavaLangString, 2, "unZipFolder fail!");
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
        localObject6 = jdField_d_of_type_JavaLangString;
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
          HtmlOffline.a(str, 13, 0L, i, "lixian_update", "0");
          a(0, str, 13, 0, "lixian_update", i);
          bool1 = bool2;
        }
        else
        {
          HtmlOffline.a(str, 13, 0L, i, "lixian_time", "0");
          a(0, str, 13, 0, "lixian_time", i);
          bool1 = true;
        }
      }
      else
      {
        HtmlOffline.a(str, 13, 0L, i, "lixian_update", "0");
        a(0, str, 13, 0, "lixian_update", i);
        bool1 = bool2;
      }
    }
    Util.a((String)localObject2);
    if (QLog.isColorLevel())
    {
      str = jdField_d_of_type_JavaLangString;
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("time of unzip zip：");
      ((StringBuilder)localObject2).append(System.currentTimeMillis() - l);
      ((StringBuilder)localObject2).append(", isSuccess: ");
      ((StringBuilder)localObject2).append(bool1);
      QLog.i(str, 2, ((StringBuilder)localObject2).toString());
    }
    return bool1;
  }
  
  public void c()
  {
    if (a(this.jdField_a_of_type_JavaLangString))
    {
      if (QLog.isColorLevel())
      {
        String str = jdField_d_of_type_JavaLangString;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append(this.jdField_a_of_type_JavaLangString);
        localStringBuilder.append(" is downloading");
        QLog.i(str, 2, localStringBuilder.toString());
      }
      return;
    }
    jdField_a_of_type_ComTencentBizCommonOfflineUtilIThreadManager.c(new BidDownloader.4(this));
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    int i = paramMessage.what;
    if (i != 0)
    {
      if (i != 1)
      {
        if (i != 2)
        {
          if (i == 3) {
            d();
          }
        }
        else {
          a(paramMessage.arg1, paramMessage.arg2);
        }
      }
      else {
        c();
      }
    }
    else {
      b(this.jdField_a_of_type_JavaLangString);
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.biz.common.offline.BidDownloader
 * JD-Core Version:    0.7.0.1
 */