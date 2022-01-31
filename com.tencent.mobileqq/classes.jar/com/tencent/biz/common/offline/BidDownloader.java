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
import com.tencent.biz.common.util.NetworkUtil;
import com.tencent.biz.common.util.QQThreadManager;
import com.tencent.biz.common.util.Util;
import com.tencent.biz.common.util.ZipUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.vas.LzmaUtils;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import klq;
import kls;
import klt;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

public class BidDownloader
  implements Handler.Callback
{
  public static Context a;
  public static BidDownloader.WifiListener a;
  public static IOfflineDownloader a;
  public static IThreadManager a;
  public static ArrayList a;
  public static HashMap a;
  public static String d;
  public static boolean g;
  public int a;
  public Handler a;
  public AsyncBack a;
  public String a;
  public boolean a;
  public int b;
  public AsyncBack b;
  public String b;
  public boolean b;
  public int c;
  public String c;
  public boolean c;
  public int d;
  public boolean d;
  public boolean e;
  public boolean f;
  
  static
  {
    jdField_a_of_type_ComTencentBizCommonOfflineUtilIThreadManager = new QQThreadManager();
    jdField_a_of_type_ComTencentBizCommonOfflineUtilIOfflineDownloader = new OfflineDownloader();
    jdField_d_of_type_JavaLangString = "BidDownloader";
  }
  
  BidDownloader(String paramString, AppRuntime paramAppRuntime, AsyncBack paramAsyncBack, boolean paramBoolean, int paramInt)
  {
    this.jdField_a_of_type_Boolean = true;
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    if (jdField_a_of_type_JavaUtilArrayList == null)
    {
      jdField_a_of_type_JavaUtilArrayList = new ArrayList();
      jdField_a_of_type_JavaUtilHashMap = new HashMap();
      jdField_a_of_type_ComTencentBizCommonOfflineBidDownloader$WifiListener = new BidDownloader.WifiListener();
    }
    this.jdField_a_of_type_ComTencentBizCommonOfflineAsyncBack = paramAsyncBack;
    jdField_a_of_type_AndroidContentContext = paramAppRuntime.getApplication().getApplicationContext();
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_Boolean = paramBoolean;
    if (paramInt == 1)
    {
      this.jdField_b_of_type_Boolean = true;
      paramString = OfflineEnvHelper.b(this.jdField_a_of_type_JavaLangString);
      if (!TextUtils.isEmpty(paramString))
      {
        if (!this.e) {
          break label205;
        }
        this.jdField_b_of_type_JavaLangString = (paramString + this.jdField_a_of_type_JavaLangString + ".7z");
      }
    }
    for (;;)
    {
      this.jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper(), this);
      this.jdField_a_of_type_Int = 0;
      return;
      if (paramInt == 3)
      {
        this.jdField_d_of_type_Boolean = true;
        break;
      }
      if (paramInt == 4)
      {
        this.e = true;
        break;
      }
      if (paramInt != 2) {
        break;
      }
      this.jdField_c_of_type_Boolean = true;
      break;
      label205:
      if ((this.jdField_d_of_type_Boolean) || (this.jdField_c_of_type_Boolean))
      {
        this.jdField_b_of_type_JavaLangString = (paramString + this.jdField_a_of_type_JavaLangString + ".zip");
      }
      else
      {
        QLog.e(jdField_d_of_type_JavaLangString, 1, "do not know what format, use default zip name!");
        this.jdField_b_of_type_JavaLangString = (paramString + this.jdField_a_of_type_JavaLangString + ".zip");
      }
    }
  }
  
  /* Error */
  public static String a(String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokestatic 53	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   4: ifeq +8 -> 12
    //   7: ldc 142
    //   9: astore_2
    //   10: aload_2
    //   11: areturn
    //   12: new 144	java/io/File
    //   15: dup
    //   16: aload_0
    //   17: invokespecial 147	java/io/File:<init>	(Ljava/lang/String;)V
    //   20: astore_2
    //   21: aload_2
    //   22: invokevirtual 151	java/io/File:exists	()Z
    //   25: ifne +38 -> 63
    //   28: invokestatic 154	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   31: ifeq +29 -> 60
    //   34: getstatic 42	com/tencent/biz/common/offline/BidDownloader:jdField_d_of_type_JavaLangString	Ljava/lang/String;
    //   37: iconst_2
    //   38: new 97	java/lang/StringBuilder
    //   41: dup
    //   42: invokespecial 98	java/lang/StringBuilder:<init>	()V
    //   45: ldc 156
    //   47: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   50: aload_0
    //   51: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   54: invokevirtual 108	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   57: invokestatic 159	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   60: ldc 142
    //   62: areturn
    //   63: ldc 142
    //   65: astore 4
    //   67: new 161	java/io/RandomAccessFile
    //   70: dup
    //   71: aload_2
    //   72: ldc 163
    //   74: invokespecial 166	java/io/RandomAccessFile:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   77: astore_3
    //   78: aload_3
    //   79: astore_2
    //   80: aload_3
    //   81: lconst_0
    //   82: invokevirtual 170	java/io/RandomAccessFile:seek	(J)V
    //   85: aload_3
    //   86: astore_2
    //   87: aload_3
    //   88: invokevirtual 174	java/io/RandomAccessFile:readInt	()I
    //   91: invokestatic 180	java/lang/Integer:reverseBytes	(I)I
    //   94: istore_1
    //   95: iload_1
    //   96: i2l
    //   97: ldc2_w 181
    //   100: lcmp
    //   101: ifne +21 -> 122
    //   104: ldc 184
    //   106: astore_0
    //   107: aload_0
    //   108: astore_2
    //   109: aload_3
    //   110: ifnull -100 -> 10
    //   113: aload_3
    //   114: invokevirtual 187	java/io/RandomAccessFile:close	()V
    //   117: aload_0
    //   118: areturn
    //   119: astore_2
    //   120: aload_0
    //   121: areturn
    //   122: aload 4
    //   124: astore_0
    //   125: iload_1
    //   126: i2l
    //   127: ldc2_w 188
    //   130: lcmp
    //   131: ifne -24 -> 107
    //   134: ldc 191
    //   136: astore_0
    //   137: goto -30 -> 107
    //   140: astore 5
    //   142: aconst_null
    //   143: astore_3
    //   144: aload_3
    //   145: astore_2
    //   146: invokestatic 154	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   149: ifeq +33 -> 182
    //   152: aload_3
    //   153: astore_2
    //   154: getstatic 42	com/tencent/biz/common/offline/BidDownloader:jdField_d_of_type_JavaLangString	Ljava/lang/String;
    //   157: iconst_2
    //   158: new 97	java/lang/StringBuilder
    //   161: dup
    //   162: invokespecial 98	java/lang/StringBuilder:<init>	()V
    //   165: ldc 193
    //   167: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   170: aload_0
    //   171: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   174: invokevirtual 108	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   177: aload 5
    //   179: invokestatic 196	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   182: aload 4
    //   184: astore_2
    //   185: aload_3
    //   186: ifnull -176 -> 10
    //   189: aload_3
    //   190: invokevirtual 187	java/io/RandomAccessFile:close	()V
    //   193: ldc 142
    //   195: areturn
    //   196: astore_0
    //   197: ldc 142
    //   199: areturn
    //   200: astore_0
    //   201: aconst_null
    //   202: astore_2
    //   203: aload_2
    //   204: ifnull +7 -> 211
    //   207: aload_2
    //   208: invokevirtual 187	java/io/RandomAccessFile:close	()V
    //   211: aload_0
    //   212: athrow
    //   213: astore_2
    //   214: goto -3 -> 211
    //   217: astore_0
    //   218: goto -15 -> 203
    //   221: astore 5
    //   223: goto -79 -> 144
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	226	0	paramString	String
    //   94	32	1	i	int
    //   9	100	2	localObject1	Object
    //   119	1	2	localException1	java.lang.Exception
    //   145	63	2	localObject2	Object
    //   213	1	2	localException2	java.lang.Exception
    //   77	113	3	localRandomAccessFile	java.io.RandomAccessFile
    //   65	118	4	str	String
    //   140	38	5	localException3	java.lang.Exception
    //   221	1	5	localException4	java.lang.Exception
    // Exception table:
    //   from	to	target	type
    //   113	117	119	java/lang/Exception
    //   67	78	140	java/lang/Exception
    //   189	193	196	java/lang/Exception
    //   67	78	200	finally
    //   207	211	213	java/lang/Exception
    //   80	85	217	finally
    //   87	95	217	finally
    //   146	152	217	finally
    //   154	182	217	finally
    //   80	85	221	java/lang/Exception
    //   87	95	221	java/lang/Exception
  }
  
  protected static void a()
  {
    if ((jdField_a_of_type_JavaUtilHashMap.size() == 0) && (jdField_a_of_type_JavaUtilArrayList != null) && (!jdField_a_of_type_JavaUtilArrayList.isEmpty()))
    {
      BidDownloader localBidDownloader = (BidDownloader)jdField_a_of_type_JavaUtilArrayList.remove(0);
      if (jdField_a_of_type_AndroidContentContext != null) {
        localBidDownloader.c();
      }
    }
  }
  
  private void a(int paramInt1, int paramInt2)
  {
    if (this.jdField_a_of_type_ComTencentBizCommonOfflineAsyncBack != null) {
      this.jdField_a_of_type_ComTencentBizCommonOfflineAsyncBack.a(null, paramInt1);
    }
  }
  
  protected static void a(String paramString)
  {
    if (jdField_a_of_type_JavaUtilHashMap == null) {
      jdField_a_of_type_JavaUtilHashMap = new HashMap();
    }
    if (jdField_a_of_type_JavaUtilHashMap.get(paramString) == null)
    {
      jdField_a_of_type_JavaUtilHashMap.put(paramString, Integer.valueOf(1));
      if (QLog.isColorLevel()) {
        QLog.i(jdField_d_of_type_JavaLangString, 2, "addDownloadingState:" + paramString);
      }
    }
  }
  
  public static boolean a(int paramInt)
  {
    return (paramInt == 0) || (paramInt == -1);
  }
  
  protected static boolean a(String paramString)
  {
    if (jdField_a_of_type_JavaUtilHashMap == null) {}
    while (jdField_a_of_type_JavaUtilHashMap.get(paramString) == null) {
      return false;
    }
    return true;
  }
  
  public static void b(String paramString)
  {
    if (jdField_a_of_type_JavaUtilHashMap == null) {}
    do
    {
      do
      {
        do
        {
          return;
          if (jdField_a_of_type_JavaUtilHashMap.get(paramString) != null) {
            jdField_a_of_type_JavaUtilHashMap.remove(paramString);
          }
        } while ((jdField_a_of_type_JavaUtilArrayList == null) || (jdField_a_of_type_JavaUtilArrayList.isEmpty()));
        paramString = (BidDownloader)jdField_a_of_type_JavaUtilArrayList.get(0);
      } while (jdField_a_of_type_AndroidContentContext == null);
      if ((paramString.f) && (NetworkUtil.a(jdField_a_of_type_AndroidContentContext) != 1) && (!g))
      {
        paramString = new IntentFilter();
        paramString.addAction("android.net.conn.CONNECTIVITY_CHANGE");
        jdField_a_of_type_AndroidContentContext.registerReceiver(jdField_a_of_type_ComTencentBizCommonOfflineBidDownloader$WifiListener, paramString);
        g = true;
        return;
      }
      if (QLog.isColorLevel()) {
        QLog.i(jdField_d_of_type_JavaLangString, 2, "start download from queue:" + paramString.jdField_a_of_type_JavaLangString);
      }
      paramString.c();
      jdField_a_of_type_JavaUtilArrayList.remove(0);
    } while ((!g) || (jdField_a_of_type_JavaUtilArrayList.size() != 0));
    jdField_a_of_type_AndroidContentContext.unregisterReceiver(jdField_a_of_type_ComTencentBizCommonOfflineBidDownloader$WifiListener);
    g = false;
  }
  
  private void d()
  {
    if (a(this.jdField_a_of_type_JavaLangString)) {
      if (QLog.isColorLevel()) {
        QLog.i(jdField_d_of_type_JavaLangString, 2, this.jdField_a_of_type_JavaLangString + " is downloading");
      }
    }
    do
    {
      return;
      if (QLog.isColorLevel()) {
        QLog.i(jdField_d_of_type_JavaLangString, 2, this.jdField_a_of_type_JavaLangString + "download");
      }
      if (jdField_a_of_type_JavaUtilHashMap.size() < 1) {
        break;
      }
      a(this);
    } while (!QLog.isColorLevel());
    QLog.i(jdField_d_of_type_JavaLangString, 2, jdField_a_of_type_JavaUtilHashMap.get(Integer.valueOf(0)) + "," + this.jdField_a_of_type_JavaLangString + "add to queue");
    return;
    HtmlOffline.a(jdField_a_of_type_AndroidContentContext.getApplicationContext(), this.jdField_a_of_type_JavaLangString);
    b();
    if (QLog.isColorLevel()) {
      QLog.i(jdField_d_of_type_JavaLangString, 2, this.jdField_a_of_type_JavaLangString + this.jdField_c_of_type_JavaLangString + this.jdField_b_of_type_ComTencentBizCommonOfflineAsyncBack);
    }
    a(this.jdField_a_of_type_JavaLangString);
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
  public boolean a()
  {
    long l = System.currentTimeMillis();
    if (TextUtils.isEmpty(this.jdField_b_of_type_JavaLangString)) {
      return false;
    }
    this.jdField_b_of_type_ComTencentBizCommonOfflineAsyncBack = new klq(this, l);
    this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(1);
    return true;
  }
  
  public void b()
  {
    jdField_a_of_type_ComTencentBizCommonOfflineUtilIThreadManager.c(new kls(this));
  }
  
  public boolean b()
  {
    boolean bool3 = false;
    boolean bool1 = false;
    String str4;
    boolean bool2;
    Object localObject1;
    try
    {
      String str1 = this.jdField_a_of_type_JavaLangString;
      str4 = this.jdField_b_of_type_JavaLangString;
      bool2 = TextUtils.isEmpty(str1);
      if (bool2) {
        bool2 = bool1;
      }
      for (;;)
      {
        return bool2;
        bool2 = bool1;
        if (!TextUtils.isEmpty(OfflineEnvHelper.b(str1)))
        {
          localObject1 = new File(str4);
          if (((File)localObject1).exists()) {
            break;
          }
          bool2 = bool1;
          if (QLog.isColorLevel())
          {
            QLog.i(jdField_d_of_type_JavaLangString, 2, "doUnzipZip: no zip ! : businessId:" + str1);
            bool2 = bool1;
          }
        }
      }
      l = System.currentTimeMillis();
    }
    finally {}
    long l;
    String str3 = ((File)localObject1).getParent() + File.separator + str2;
    Object localObject2 = a(str4);
    if (QLog.isColorLevel()) {
      QLog.i(jdField_d_of_type_JavaLangString, 2, "fileFormat: " + (String)localObject2 + ", path: " + str4);
    }
    int i;
    if (!TextUtils.isEmpty((CharSequence)localObject2)) {
      if (((String)localObject2).equals("zip"))
      {
        i = ZipUtils.a(str4, str3);
        label229:
        if (QLog.isColorLevel()) {
          QLog.i(jdField_d_of_type_JavaLangString, 2, "now delete original download offline zip, path: " + str4);
        }
        Util.b(str4);
        if (i <= 0) {
          break label470;
        }
        HtmlOffline.a(str2, 13, 0L, i, "lixian_update", "0");
        bool1 = bool3;
        if (QLog.isColorLevel())
        {
          QLog.i(jdField_d_of_type_JavaLangString, 2, "unZipFolder fail!");
          bool1 = bool3;
        }
      }
    }
    label691:
    for (;;)
    {
      Util.a(str3);
      bool2 = bool1;
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.i(jdField_d_of_type_JavaLangString, 2, "time of unzip zip：" + (System.currentTimeMillis() - l) + ", isSuccess: " + bool1);
      bool2 = bool1;
      break;
      if (((String)localObject2).equals("7z"))
      {
        i = LzmaUtils.a(BaseApplicationImpl.getApplication().getApplicationContext(), str4, str3);
        break label229;
        QLog.w(jdField_d_of_type_JavaLangString, 1, "can not recognize download compress file format, " + this.jdField_b_of_type_JavaLangString);
        if (this.jdField_d_of_type_Boolean)
        {
          i = ZipUtils.a(str4, str3);
          break label229;
        }
        if (this.e)
        {
          i = LzmaUtils.a(BaseApplicationImpl.getApplication().getApplicationContext(), str4, str3);
          break label229;
          label470:
          str4 = str3 + File.separator + str2 + ".zip";
          localObject2 = new File(str4);
          localObject1 = ((File)localObject1).getParent() + File.separator + str2 + ".zip";
          if (QLog.isColorLevel()) {
            QLog.i(jdField_d_of_type_JavaLangString, 2, "now move zip file to location: " + (String)localObject1);
          }
          if (((File)localObject2).exists())
          {
            bool2 = ((File)localObject2).renameTo(new File((String)localObject1));
            bool1 = bool2;
            if (!bool2) {
              bool1 = FileUtils.b(str4, (String)localObject1);
            }
            if (!bool1)
            {
              HtmlOffline.a(str2, 13, 0L, i, "lixian_update", "0");
              bool1 = false;
              break label691;
            }
            HtmlOffline.a(str2, 13, 0L, i, "lixian_time", "0");
            bool1 = true;
            break label691;
          }
          HtmlOffline.a(str2, 13, 0L, i, "lixian_update", "0");
          bool1 = bool3;
          continue;
        }
      }
      i = 1;
      break label229;
    }
  }
  
  public void c()
  {
    if (a(this.jdField_a_of_type_JavaLangString))
    {
      if (QLog.isColorLevel()) {
        QLog.i(jdField_d_of_type_JavaLangString, 2, this.jdField_a_of_type_JavaLangString + " is downloading");
      }
      return;
    }
    jdField_a_of_type_ComTencentBizCommonOfflineUtilIThreadManager.c(new klt(this));
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    }
    for (;;)
    {
      return false;
      b(this.jdField_a_of_type_JavaLangString);
      continue;
      c();
      continue;
      a(paramMessage.arg1, paramMessage.arg2);
      continue;
      d();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.common.offline.BidDownloader
 * JD-Core Version:    0.7.0.1
 */