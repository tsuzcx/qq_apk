package com.tencent.mobileqq.app;

import android.content.Context;
import android.content.res.Resources;
import android.os.Looper;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.transfile.dns.InnerDns;
import com.tencent.mobileqq.util.FaceInfo;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.qphone.base.util.QLog;
import java.net.HttpURLConnection;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.concurrent.atomic.AtomicInteger;
import mqq.os.MqqHandler;
import zjz;
import zka;
import zkb;

public abstract class FaceDownloader
{
  private static String jdField_a_of_type_JavaLangString;
  private static boolean jdField_a_of_type_Boolean;
  private static int e = 1;
  protected byte a;
  public int a;
  protected AppInterface a;
  private FaceDownloader.FaceDownloadThreadInfo jdField_a_of_type_ComTencentMobileqqAppFaceDownloader$FaceDownloadThreadInfo;
  public ArrayList a;
  public HashSet a;
  public LinkedList a;
  public AtomicInteger a;
  protected MqqHandler a;
  private Thread[] jdField_a_of_type_ArrayOfJavaLangThread;
  private zkb[] jdField_a_of_type_ArrayOfZkb;
  protected int b;
  public ArrayList b;
  public AtomicInteger b;
  private int c = 2;
  private int d = 10;
  
  public FaceDownloader(AppInterface paramAppInterface)
  {
    this.jdField_a_of_type_Int = 6;
    this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger = new AtomicInteger(0);
    this.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicInteger = new AtomicInteger(0);
    this.jdField_a_of_type_JavaUtilLinkedList = new LinkedList();
    this.jdField_b_of_type_JavaUtilArrayList = new ArrayList(100);
    b();
    c();
    if (this.jdField_a_of_type_ComTencentMobileqqAppFaceDownloader$FaceDownloadThreadInfo.jdField_a_of_type_Int != -2147483648) {
      this.jdField_a_of_type_Int = this.jdField_a_of_type_ComTencentMobileqqAppFaceDownloader$FaceDownloadThreadInfo.jdField_a_of_type_Int;
    }
    String str = BaseApplicationImpl.processName;
    if ((!TextUtils.isEmpty(str)) && (str.equals("com.tencent.mobileqq"))) {
      this.jdField_a_of_type_Int = 4;
    }
    this.jdField_a_of_type_ComTencentCommonAppAppInterface = paramAppInterface;
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
    this.jdField_a_of_type_JavaUtilHashSet = new HashSet();
    this.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicInteger.set(this.jdField_a_of_type_Int);
    this.jdField_a_of_type_ArrayOfJavaLangThread = new Thread[this.jdField_a_of_type_Int];
    this.jdField_a_of_type_ArrayOfZkb = new zkb[this.jdField_a_of_type_Int];
    int i = 0;
    while (i < this.jdField_a_of_type_ArrayOfJavaLangThread.length)
    {
      this.jdField_a_of_type_ArrayOfZkb[i] = new zkb(this, i);
      this.jdField_a_of_type_ArrayOfJavaLangThread[i] = ThreadManager.newFreeThread(this.jdField_a_of_type_ArrayOfZkb[i], "FaceDownloadThread", 5);
      if (ThreadOptimizer.a().c()) {
        this.jdField_a_of_type_ArrayOfJavaLangThread[i].setPriority(1);
      }
      this.jdField_a_of_type_ArrayOfJavaLangThread[i].start();
      i += 1;
    }
    this.jdField_b_of_type_Int = a();
    switch (this.jdField_b_of_type_Int)
    {
    }
    for (;;)
    {
      this.jdField_a_of_type_MqqOsMqqHandler = new zjz(this, Looper.getMainLooper());
      return;
      this.jdField_a_of_type_Byte = 3;
      continue;
      this.jdField_a_of_type_Byte = 2;
      continue;
      this.jdField_a_of_type_Byte = 0;
    }
  }
  
  public static String a(int paramInt)
  {
    if ((paramInt == 4) || (paramInt == 8)) {
      return "";
    }
    String str2 = b(paramInt);
    paramInt = NetworkUtil.a(BaseApplicationImpl.getApplication().getApplicationContext());
    String str1;
    if (paramInt == 1) {
      str1 = "WIFI";
    }
    for (;;)
    {
      return str2 + str1;
      if (paramInt == 2) {
        str1 = "2G";
      } else if (paramInt == 3) {
        str1 = "3G";
      } else if (paramInt == 4) {
        str1 = "4G";
      } else {
        str1 = "Unknown";
      }
    }
  }
  
  public static String a(String paramString, byte paramByte)
  {
    String str = InnerDns.a().a("q.qlogo.cn", 1003);
    if (QLog.isColorLevel()) {
      QLog.i("InnerDns", 2, "get640QQHeandDownLoadUrl.choosedIp=" + str);
    }
    StringBuilder localStringBuilder = new StringBuilder("http://");
    if (!TextUtils.isEmpty(str)) {
      localStringBuilder.append(str);
    }
    for (;;)
    {
      int i = paramString.indexOf("/", 8);
      str = paramString;
      if (i > 8)
      {
        localStringBuilder.append(paramString.substring(i));
        str = localStringBuilder.toString();
      }
      i = 0;
      if ((paramByte & 0x10) != 0) {
        i = 640;
      }
      if (i == 0) {
        break;
      }
      return str + i;
      localStringBuilder.append("q.qlogo.cn");
    }
    return "";
  }
  
  private void a(HttpURLConnection paramHttpURLConnection, FaceInfo paramFaceInfo)
  {
    if ((paramHttpURLConnection == null) || (paramFaceInfo == null) || (paramFaceInfo.jdField_a_of_type_AvatarInfoQQHeadInfo == null)) {
      return;
    }
    try
    {
      QLog.i("Q.qqhead.FaceDownloader", 2, "headInfo=" + paramHttpURLConnection.getResponseCode() + "," + paramHttpURLConnection.getContentType() + "," + paramHttpURLConnection.getContentLength() + "," + paramHttpURLConnection.getHeaderField("Server") + "," + paramHttpURLConnection.getHeaderField("X-ErrNo") + "," + paramHttpURLConnection.getHeaderField("X-RtFlag") + "," + paramHttpURLConnection.getHeaderField("X-BCheck") + "," + paramHttpURLConnection.getHeaderField("X-BCheck") + "," + paramFaceInfo);
      return;
    }
    catch (Throwable paramHttpURLConnection) {}
  }
  
  public static String b(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return "actGetUserHead";
    case 4: 
    case 8: 
      return "actGetGroupHead";
    case 16: 
    case 32: 
      return "actGetNearbyHead";
    }
    return "actGetUserHead";
  }
  
  private void b()
  {
    if (TextUtils.isEmpty(BaseApplicationImpl.processName)) {}
    for (;;)
    {
      return;
      if (BaseApplicationImpl.processName.equals("com.tencent.mobileqq:tool")) {}
      for (this.jdField_a_of_type_ComTencentMobileqqAppFaceDownloader$FaceDownloadThreadInfo = a(); QLog.isColorLevel(); this.jdField_a_of_type_ComTencentMobileqqAppFaceDownloader$FaceDownloadThreadInfo = new FaceDownloader.FaceDownloadThreadInfo(this))
      {
        QLog.i("Q.qqhead.FaceDownloader", 2, "initFaceDownloadThreadInfo, maxThreadCount=" + this.jdField_a_of_type_ComTencentMobileqqAppFaceDownloader$FaceDownloadThreadInfo.jdField_a_of_type_Int + ",priority=" + this.jdField_a_of_type_ComTencentMobileqqAppFaceDownloader$FaceDownloadThreadInfo.jdField_b_of_type_Int);
        return;
      }
    }
  }
  
  private void c()
  {
    ThreadManager.post(new zka(this), 5, null, true);
  }
  
  protected int a()
  {
    BaseApplicationImpl localBaseApplicationImpl = BaseApplicationImpl.sApplication;
    int i = Math.min(localBaseApplicationImpl.getResources().getDisplayMetrics().widthPixels, localBaseApplicationImpl.getResources().getDisplayMetrics().heightPixels);
    if (i > 720) {}
    while (i >= 640) {
      return 140;
    }
    return 40;
  }
  
  public int a(byte paramByte)
  {
    byte b3 = paramByte;
    if (paramByte == 0) {
      b3 = 1;
    }
    paramByte = 1 << this.jdField_a_of_type_Byte;
    if ((paramByte & b3) == paramByte) {
      return this.jdField_b_of_type_Int;
    }
    byte b2 = 0;
    paramByte = this.jdField_a_of_type_Byte - 1;
    byte b1 = b2;
    if (paramByte >= 0)
    {
      b1 = (byte)(1 << paramByte);
      if ((b1 & b3) == b1) {
        b1 = 1;
      }
    }
    else
    {
      b2 = paramByte;
      if (b1 != 0) {
        break label168;
      }
      paramByte = this.jdField_a_of_type_Byte + 1;
      b2 = paramByte;
      if (paramByte >= 8) {
        break label168;
      }
      b2 = (byte)(1 << paramByte);
      if ((b2 & b3) != b2) {
        break label147;
      }
      b1 = 1;
    }
    for (;;)
    {
      if (b1 != 0) {}
      switch (paramByte)
      {
      case 1: 
      default: 
        return 140;
        paramByte -= 1;
        break;
        paramByte += 1;
        break;
      case 0: 
        return 40;
      case 2: 
        return 100;
      case 3: 
        return 140;
      case 4: 
        label147:
        return 640;
        label168:
        paramByte = b2;
      }
    }
  }
  
  /* Error */
  public int a(String paramString, java.io.File paramFile, FaceInfo paramFaceInfo, boolean paramBoolean)
  {
    // Byte code:
    //   0: invokestatic 352	com/tencent/mobileqq/msf/sdk/AppNetConnInfo:getRecentNetworkInfo	()Landroid/net/NetworkInfo;
    //   3: astore 41
    //   5: lconst_0
    //   6: lstore 25
    //   8: aload 41
    //   10: ifnonnull +24 -> 34
    //   13: invokestatic 209	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   16: ifeq +12 -> 28
    //   19: ldc 244
    //   21: iconst_2
    //   22: ldc_w 354
    //   25: invokestatic 217	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   28: iconst_1
    //   29: istore 6
    //   31: iload 6
    //   33: ireturn
    //   34: new 356	java/net/URL
    //   37: dup
    //   38: aload_1
    //   39: invokespecial 357	java/net/URL:<init>	(Ljava/lang/String;)V
    //   42: astore 39
    //   44: invokestatic 363	java/lang/System:currentTimeMillis	()J
    //   47: pop2
    //   48: new 4	java/lang/Object
    //   51: dup
    //   52: invokespecial 31	java/lang/Object:<init>	()V
    //   55: astore 38
    //   57: aload_2
    //   58: invokevirtual 369	java/io/File:getParentFile	()Ljava/io/File;
    //   61: astore 31
    //   63: aload 31
    //   65: ifnull +17 -> 82
    //   68: aload 31
    //   70: invokevirtual 372	java/io/File:exists	()Z
    //   73: ifne +9 -> 82
    //   76: aload 31
    //   78: invokevirtual 375	java/io/File:mkdirs	()Z
    //   81: pop
    //   82: aconst_null
    //   83: astore 31
    //   85: new 377	com/tencent/mobileqq/emoticon/DownloadInfo
    //   88: dup
    //   89: aload_1
    //   90: aconst_null
    //   91: iconst_0
    //   92: invokespecial 380	com/tencent/mobileqq/emoticon/DownloadInfo:<init>	(Ljava/lang/String;Ljava/io/File;I)V
    //   95: astore 42
    //   97: aload 41
    //   99: ifnonnull +40 -> 139
    //   102: ldc 244
    //   104: iconst_1
    //   105: ldc_w 382
    //   108: invokestatic 217	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   111: aload 42
    //   113: iconst_1
    //   114: putfield 383	com/tencent/mobileqq/emoticon/DownloadInfo:jdField_b_of_type_Int	I
    //   117: iconst_1
    //   118: ireturn
    //   119: astore_1
    //   120: aload_1
    //   121: invokevirtual 386	java/net/MalformedURLException:printStackTrace	()V
    //   124: bipush 13
    //   126: ireturn
    //   127: astore_1
    //   128: ldc 244
    //   130: iconst_1
    //   131: ldc_w 388
    //   134: invokestatic 390	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   137: iconst_4
    //   138: ireturn
    //   139: new 392	org/apache/http/client/methods/HttpGet
    //   142: dup
    //   143: aload_1
    //   144: invokespecial 393	org/apache/http/client/methods/HttpGet:<init>	(Ljava/lang/String;)V
    //   147: pop
    //   148: new 365	java/io/File
    //   151: dup
    //   152: new 176	java/lang/StringBuilder
    //   155: dup
    //   156: invokespecial 177	java/lang/StringBuilder:<init>	()V
    //   159: aload_2
    //   160: invokevirtual 396	java/io/File:getPath	()Ljava/lang/String;
    //   163: invokevirtual 181	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   166: ldc_w 398
    //   169: invokevirtual 181	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   172: invokevirtual 185	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   175: invokespecial 399	java/io/File:<init>	(Ljava/lang/String;)V
    //   178: astore 40
    //   180: aload 40
    //   182: invokevirtual 372	java/io/File:exists	()Z
    //   185: ifeq +9 -> 194
    //   188: aload 40
    //   190: invokevirtual 402	java/io/File:delete	()Z
    //   193: pop
    //   194: aconst_null
    //   195: astore 32
    //   197: iconst_m1
    //   198: istore 11
    //   200: iconst_5
    //   201: istore 5
    //   203: aload_1
    //   204: astore 33
    //   206: aload 32
    //   208: astore_1
    //   209: iload 11
    //   211: iconst_m1
    //   212: if_icmpeq +5724 -> 5936
    //   215: aload_3
    //   216: getfield 242	com/tencent/mobileqq/util/FaceInfo:jdField_a_of_type_AvatarInfoQQHeadInfo	LAvatarInfo/QQHeadInfo;
    //   219: astore 34
    //   221: aload 34
    //   223: ifnonnull +105 -> 328
    //   226: aload 42
    //   228: iload 5
    //   230: putfield 383	com/tencent/mobileqq/emoticon/DownloadInfo:jdField_b_of_type_Int	I
    //   233: iload 5
    //   235: istore 6
    //   237: iload 4
    //   239: ifeq -208 -> 31
    //   242: new 404	zkc
    //   245: dup
    //   246: aload_0
    //   247: invokespecial 405	zkc:<init>	(Lcom/tencent/mobileqq/app/FaceDownloader;)V
    //   250: astore_1
    //   251: aload_1
    //   252: aload_3
    //   253: putfield 408	zkc:jdField_a_of_type_ComTencentMobileqqUtilFaceInfo	Lcom/tencent/mobileqq/util/FaceInfo;
    //   256: iload 5
    //   258: ifeq +5168 -> 5426
    //   261: aload_3
    //   262: getstatic 411	com/tencent/mobileqq/util/FaceInfo:o	I
    //   265: invokevirtual 413	com/tencent/mobileqq/util/FaceInfo:a	(I)V
    //   268: aload_1
    //   269: aconst_null
    //   270: putfield 416	zkc:jdField_a_of_type_AndroidGraphicsBitmap	Landroid/graphics/Bitmap;
    //   273: aload_0
    //   274: getfield 56	com/tencent/mobileqq/app/FaceDownloader:jdField_b_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   277: aload_1
    //   278: invokevirtual 419	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   281: pop
    //   282: aload_0
    //   283: getfield 149	com/tencent/mobileqq/app/FaceDownloader:jdField_a_of_type_MqqOsMqqHandler	Lmqq/os/MqqHandler;
    //   286: bipush 100
    //   288: aload_1
    //   289: invokevirtual 425	mqq/os/MqqHandler:obtainMessage	(ILjava/lang/Object;)Landroid/os/Message;
    //   292: invokevirtual 430	android/os/Message:sendToTarget	()V
    //   295: iload 5
    //   297: ireturn
    //   298: astore 32
    //   300: aload_1
    //   301: invokestatic 434	com/tencent/mobileqq/utils/HttpDownloadUtil:a	(Ljava/lang/String;)Ljava/lang/String;
    //   304: astore_1
    //   305: goto -157 -> 148
    //   308: astore_1
    //   309: ldc 244
    //   311: iconst_1
    //   312: ldc_w 436
    //   315: invokestatic 390	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   318: aload 42
    //   320: bipush 13
    //   322: putfield 383	com/tencent/mobileqq/emoticon/DownloadInfo:jdField_b_of_type_Int	I
    //   325: bipush 13
    //   327: ireturn
    //   328: ldc 201
    //   330: astore 32
    //   332: aload 34
    //   334: getfield 441	AvatarInfo/QQHeadInfo:dstUsrType	B
    //   337: bipush 32
    //   339: if_icmpne +1838 -> 2177
    //   342: aload 34
    //   344: getfield 444	AvatarInfo/QQHeadInfo:originUsrType	I
    //   347: iconst_1
    //   348: if_icmpne +1811 -> 2159
    //   351: ldc 201
    //   353: astore 32
    //   355: new 176	java/lang/StringBuilder
    //   358: dup
    //   359: ldc 219
    //   361: invokespecial 222	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   364: astore 34
    //   366: aload 34
    //   368: aload 32
    //   370: invokevirtual 181	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   373: pop
    //   374: aload 33
    //   376: ldc 224
    //   378: bipush 8
    //   380: invokevirtual 228	java/lang/String:indexOf	(Ljava/lang/String;I)I
    //   383: istore 5
    //   385: iload 5
    //   387: bipush 8
    //   389: if_icmple +5540 -> 5929
    //   392: aload 34
    //   394: aload 33
    //   396: iload 5
    //   398: invokevirtual 231	java/lang/String:substring	(I)Ljava/lang/String;
    //   401: invokevirtual 181	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   404: pop
    //   405: aload 34
    //   407: invokevirtual 185	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   410: astore 32
    //   412: ldc 244
    //   414: iconst_1
    //   415: new 176	java/lang/StringBuilder
    //   418: dup
    //   419: invokespecial 177	java/lang/StringBuilder:<init>	()V
    //   422: ldc_w 446
    //   425: invokevirtual 181	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   428: iload 11
    //   430: invokevirtual 234	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   433: ldc_w 448
    //   436: invokevirtual 181	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   439: aload 32
    //   441: invokevirtual 181	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   444: ldc_w 450
    //   447: invokevirtual 181	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   450: aload_3
    //   451: invokevirtual 274	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   454: invokevirtual 185	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   457: invokestatic 390	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   460: aload 32
    //   462: astore 35
    //   464: iconst_5
    //   465: istore 5
    //   467: iconst_0
    //   468: istore 21
    //   470: iconst_0
    //   471: istore 22
    //   473: iconst_0
    //   474: istore 23
    //   476: iconst_0
    //   477: istore 17
    //   479: invokestatic 455	android/net/Proxy:getDefaultHost	()Ljava/lang/String;
    //   482: astore 43
    //   484: invokestatic 458	android/net/Proxy:getDefaultPort	()I
    //   487: istore 16
    //   489: aload 41
    //   491: ifnull +5429 -> 5920
    //   494: aload 41
    //   496: invokevirtual 463	android/net/NetworkInfo:getExtraInfo	()Ljava/lang/String;
    //   499: astore 32
    //   501: aload 41
    //   503: invokevirtual 466	android/net/NetworkInfo:getType	()I
    //   506: istore 12
    //   508: aload 32
    //   510: invokestatic 470	com/tencent/mobileqq/utils/httputils/PkgTools:b	(Ljava/lang/String;)Ljava/lang/String;
    //   513: astore 44
    //   515: lload 25
    //   517: lstore 27
    //   519: iload 21
    //   521: istore 19
    //   523: aload_1
    //   524: astore 36
    //   526: iload 5
    //   528: istore 7
    //   530: lload 25
    //   532: lstore 29
    //   534: iload 22
    //   536: istore 20
    //   538: aload_1
    //   539: astore 37
    //   541: iload 5
    //   543: istore 8
    //   545: aload 31
    //   547: astore 34
    //   549: iload 23
    //   551: istore 18
    //   553: aload_1
    //   554: astore 33
    //   556: iload 5
    //   558: istore 6
    //   560: aload 44
    //   562: getstatic 472	com/tencent/mobileqq/app/FaceDownloader:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   565: invokevirtual 85	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   568: ifne +164 -> 732
    //   571: iload 12
    //   573: iconst_1
    //   574: if_icmpeq +59 -> 633
    //   577: lload 25
    //   579: lstore 27
    //   581: iload 21
    //   583: istore 19
    //   585: aload_1
    //   586: astore 36
    //   588: iload 5
    //   590: istore 7
    //   592: lload 25
    //   594: lstore 29
    //   596: iload 22
    //   598: istore 20
    //   600: aload_1
    //   601: astore 37
    //   603: iload 5
    //   605: istore 8
    //   607: aload 31
    //   609: astore 34
    //   611: iload 23
    //   613: istore 18
    //   615: aload_1
    //   616: astore 33
    //   618: iload 5
    //   620: istore 6
    //   622: aload 44
    //   624: getstatic 474	com/tencent/mobileqq/utils/httputils/PkgTools:d	Ljava/lang/String;
    //   627: invokevirtual 85	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   630: ifeq +1598 -> 2228
    //   633: lload 25
    //   635: lstore 27
    //   637: iload 21
    //   639: istore 19
    //   641: aload_1
    //   642: astore 36
    //   644: iload 5
    //   646: istore 7
    //   648: lload 25
    //   650: lstore 29
    //   652: iload 22
    //   654: istore 20
    //   656: aload_1
    //   657: astore 37
    //   659: iload 5
    //   661: istore 8
    //   663: aload 31
    //   665: astore 34
    //   667: iload 23
    //   669: istore 18
    //   671: aload_1
    //   672: astore 33
    //   674: iload 5
    //   676: istore 6
    //   678: iconst_0
    //   679: putstatic 476	com/tencent/mobileqq/app/FaceDownloader:jdField_a_of_type_Boolean	Z
    //   682: lload 25
    //   684: lstore 27
    //   686: iload 21
    //   688: istore 19
    //   690: aload_1
    //   691: astore 36
    //   693: iload 5
    //   695: istore 7
    //   697: lload 25
    //   699: lstore 29
    //   701: iload 22
    //   703: istore 20
    //   705: aload_1
    //   706: astore 37
    //   708: iload 5
    //   710: istore 8
    //   712: aload 31
    //   714: astore 34
    //   716: iload 23
    //   718: istore 18
    //   720: aload_1
    //   721: astore 33
    //   723: iload 5
    //   725: istore 6
    //   727: aload 44
    //   729: putstatic 472	com/tencent/mobileqq/app/FaceDownloader:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   732: iload 12
    //   734: iconst_1
    //   735: if_icmpne +164 -> 899
    //   738: lload 25
    //   740: lstore 27
    //   742: iload 21
    //   744: istore 19
    //   746: aload_1
    //   747: astore 36
    //   749: iload 5
    //   751: istore 7
    //   753: lload 25
    //   755: lstore 29
    //   757: iload 22
    //   759: istore 20
    //   761: aload_1
    //   762: astore 37
    //   764: iload 5
    //   766: istore 8
    //   768: aload 31
    //   770: astore 34
    //   772: iload 23
    //   774: istore 18
    //   776: aload_1
    //   777: astore 33
    //   779: iload 5
    //   781: istore 6
    //   783: ldc_w 478
    //   786: aload 43
    //   788: invokevirtual 85	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   791: ifne +59 -> 850
    //   794: lload 25
    //   796: lstore 27
    //   798: iload 21
    //   800: istore 19
    //   802: aload_1
    //   803: astore 36
    //   805: iload 5
    //   807: istore 7
    //   809: lload 25
    //   811: lstore 29
    //   813: iload 22
    //   815: istore 20
    //   817: aload_1
    //   818: astore 37
    //   820: iload 5
    //   822: istore 8
    //   824: aload 31
    //   826: astore 34
    //   828: iload 23
    //   830: istore 18
    //   832: aload_1
    //   833: astore 33
    //   835: iload 5
    //   837: istore 6
    //   839: ldc_w 480
    //   842: aload 43
    //   844: invokevirtual 85	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   847: ifeq +52 -> 899
    //   850: lload 25
    //   852: lstore 27
    //   854: iload 21
    //   856: istore 19
    //   858: aload_1
    //   859: astore 36
    //   861: iload 5
    //   863: istore 7
    //   865: lload 25
    //   867: lstore 29
    //   869: iload 22
    //   871: istore 20
    //   873: aload_1
    //   874: astore 37
    //   876: iload 5
    //   878: istore 8
    //   880: aload 31
    //   882: astore 34
    //   884: iload 23
    //   886: istore 18
    //   888: aload_1
    //   889: astore 33
    //   891: iload 5
    //   893: istore 6
    //   895: iconst_1
    //   896: putstatic 476	com/tencent/mobileqq/app/FaceDownloader:jdField_a_of_type_Boolean	Z
    //   899: aload 43
    //   901: ifnull +1818 -> 2719
    //   904: iload 16
    //   906: ifle +1813 -> 2719
    //   909: lload 25
    //   911: lstore 27
    //   913: iload 21
    //   915: istore 19
    //   917: aload_1
    //   918: astore 36
    //   920: iload 5
    //   922: istore 7
    //   924: lload 25
    //   926: lstore 29
    //   928: iload 22
    //   930: istore 20
    //   932: aload_1
    //   933: astore 37
    //   935: iload 5
    //   937: istore 8
    //   939: aload 31
    //   941: astore 34
    //   943: iload 23
    //   945: istore 18
    //   947: aload_1
    //   948: astore 33
    //   950: iload 5
    //   952: istore 6
    //   954: getstatic 476	com/tencent/mobileqq/app/FaceDownloader:jdField_a_of_type_Boolean	Z
    //   957: istore 24
    //   959: iload 24
    //   961: ifne +1758 -> 2719
    //   964: iconst_1
    //   965: istore 18
    //   967: iconst_1
    //   968: istore 17
    //   970: aload 44
    //   972: getstatic 474	com/tencent/mobileqq/utils/httputils/PkgTools:d	Ljava/lang/String;
    //   975: invokevirtual 85	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   978: ifne +25 -> 1003
    //   981: aload 44
    //   983: getstatic 483	com/tencent/mobileqq/utils/httputils/PkgTools:f	Ljava/lang/String;
    //   986: invokevirtual 85	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   989: ifne +14 -> 1003
    //   992: aload 44
    //   994: getstatic 486	com/tencent/mobileqq/utils/httputils/PkgTools:h	Ljava/lang/String;
    //   997: invokevirtual 85	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1000: ifeq +1668 -> 2668
    //   1003: iload 11
    //   1005: iconst_m1
    //   1006: if_icmpne +1645 -> 2651
    //   1009: getstatic 26	com/tencent/mobileqq/app/FaceDownloader:e	I
    //   1012: iconst_1
    //   1013: if_icmpne +1638 -> 2651
    //   1016: new 356	java/net/URL
    //   1019: dup
    //   1020: aload 35
    //   1022: invokespecial 357	java/net/URL:<init>	(Ljava/lang/String;)V
    //   1025: invokevirtual 490	java/net/URL:openConnection	()Ljava/net/URLConnection;
    //   1028: checkcast 248	java/net/HttpURLConnection
    //   1031: astore 32
    //   1033: iconst_0
    //   1034: istore 17
    //   1036: aload 32
    //   1038: astore_1
    //   1039: invokestatic 493	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   1042: ifeq +4875 -> 5917
    //   1045: ldc 244
    //   1047: iconst_4
    //   1048: new 176	java/lang/StringBuilder
    //   1051: dup
    //   1052: invokespecial 177	java/lang/StringBuilder:<init>	()V
    //   1055: ldc_w 495
    //   1058: invokevirtual 181	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1061: getstatic 26	com/tencent/mobileqq/app/FaceDownloader:e	I
    //   1064: invokevirtual 234	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1067: ldc_w 497
    //   1070: invokevirtual 181	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1073: iload 11
    //   1075: invokevirtual 234	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1078: invokevirtual 185	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1081: invokestatic 217	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   1084: lload 25
    //   1086: lstore 27
    //   1088: iload 17
    //   1090: istore 19
    //   1092: aload_1
    //   1093: astore 36
    //   1095: iload 5
    //   1097: istore 7
    //   1099: lload 25
    //   1101: lstore 29
    //   1103: iload 17
    //   1105: istore 20
    //   1107: aload_1
    //   1108: astore 37
    //   1110: iload 5
    //   1112: istore 8
    //   1114: aload 31
    //   1116: astore 34
    //   1118: iload 17
    //   1120: istore 18
    //   1122: aload_1
    //   1123: astore 33
    //   1125: iload 5
    //   1127: istore 6
    //   1129: aload_1
    //   1130: ldc_w 499
    //   1133: ldc_w 501
    //   1136: invokevirtual 505	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   1139: lload 25
    //   1141: lstore 27
    //   1143: iload 17
    //   1145: istore 19
    //   1147: aload_1
    //   1148: astore 36
    //   1150: iload 5
    //   1152: istore 7
    //   1154: lload 25
    //   1156: lstore 29
    //   1158: iload 17
    //   1160: istore 20
    //   1162: aload_1
    //   1163: astore 37
    //   1165: iload 5
    //   1167: istore 8
    //   1169: aload 31
    //   1171: astore 34
    //   1173: iload 17
    //   1175: istore 18
    //   1177: aload_1
    //   1178: astore 33
    //   1180: iload 5
    //   1182: istore 6
    //   1184: aload_1
    //   1185: sipush 30000
    //   1188: invokevirtual 508	java/net/HttpURLConnection:setConnectTimeout	(I)V
    //   1191: lload 25
    //   1193: lstore 27
    //   1195: iload 17
    //   1197: istore 19
    //   1199: aload_1
    //   1200: astore 36
    //   1202: iload 5
    //   1204: istore 7
    //   1206: lload 25
    //   1208: lstore 29
    //   1210: iload 17
    //   1212: istore 20
    //   1214: aload_1
    //   1215: astore 37
    //   1217: iload 5
    //   1219: istore 8
    //   1221: aload 31
    //   1223: astore 34
    //   1225: iload 17
    //   1227: istore 18
    //   1229: aload_1
    //   1230: astore 33
    //   1232: iload 5
    //   1234: istore 6
    //   1236: aload_1
    //   1237: sipush 30000
    //   1240: invokevirtual 511	java/net/HttpURLConnection:setReadTimeout	(I)V
    //   1243: lload 25
    //   1245: lstore 27
    //   1247: iload 17
    //   1249: istore 19
    //   1251: aload_1
    //   1252: astore 36
    //   1254: iload 5
    //   1256: istore 7
    //   1258: lload 25
    //   1260: lstore 29
    //   1262: iload 17
    //   1264: istore 20
    //   1266: aload_1
    //   1267: astore 37
    //   1269: iload 5
    //   1271: istore 8
    //   1273: aload 31
    //   1275: astore 34
    //   1277: iload 17
    //   1279: istore 18
    //   1281: aload_1
    //   1282: astore 33
    //   1284: iload 5
    //   1286: istore 6
    //   1288: aload_1
    //   1289: iconst_1
    //   1290: invokevirtual 515	java/net/HttpURLConnection:setInstanceFollowRedirects	(Z)V
    //   1293: lload 25
    //   1295: lstore 27
    //   1297: iload 17
    //   1299: istore 19
    //   1301: aload_1
    //   1302: astore 36
    //   1304: iload 5
    //   1306: istore 7
    //   1308: aload 31
    //   1310: astore 34
    //   1312: iload 17
    //   1314: istore 18
    //   1316: aload_1
    //   1317: astore 33
    //   1319: iload 5
    //   1321: istore 6
    //   1323: aload_1
    //   1324: invokevirtual 518	java/net/HttpURLConnection:connect	()V
    //   1327: lload 25
    //   1329: lstore 27
    //   1331: iload 17
    //   1333: istore 19
    //   1335: aload_1
    //   1336: astore 36
    //   1338: iload 5
    //   1340: istore 7
    //   1342: aload 31
    //   1344: astore 34
    //   1346: iload 17
    //   1348: istore 18
    //   1350: aload_1
    //   1351: astore 33
    //   1353: iload 5
    //   1355: istore 6
    //   1357: aload 42
    //   1359: aload_1
    //   1360: invokevirtual 251	java/net/HttpURLConnection:getResponseCode	()I
    //   1363: putfield 519	com/tencent/mobileqq/emoticon/DownloadInfo:c	I
    //   1366: lload 25
    //   1368: lstore 27
    //   1370: iload 17
    //   1372: istore 19
    //   1374: aload_1
    //   1375: astore 36
    //   1377: iload 5
    //   1379: istore 7
    //   1381: aload 31
    //   1383: astore 34
    //   1385: iload 17
    //   1387: istore 18
    //   1389: aload_1
    //   1390: astore 33
    //   1392: iload 5
    //   1394: istore 6
    //   1396: aload 42
    //   1398: aload_1
    //   1399: invokevirtual 259	java/net/HttpURLConnection:getContentLength	()I
    //   1402: putfield 520	com/tencent/mobileqq/emoticon/DownloadInfo:e	I
    //   1405: lload 25
    //   1407: lstore 27
    //   1409: iload 17
    //   1411: istore 19
    //   1413: aload_1
    //   1414: astore 36
    //   1416: iload 5
    //   1418: istore 7
    //   1420: aload 31
    //   1422: astore 34
    //   1424: iload 17
    //   1426: istore 18
    //   1428: aload_1
    //   1429: astore 33
    //   1431: iload 5
    //   1433: istore 6
    //   1435: aload 42
    //   1437: aload_1
    //   1438: invokevirtual 256	java/net/HttpURLConnection:getContentType	()Ljava/lang/String;
    //   1441: putfield 521	com/tencent/mobileqq/emoticon/DownloadInfo:h	Ljava/lang/String;
    //   1444: lload 25
    //   1446: lstore 27
    //   1448: iload 17
    //   1450: istore 19
    //   1452: aload_1
    //   1453: astore 36
    //   1455: iload 5
    //   1457: istore 7
    //   1459: aload 31
    //   1461: astore 34
    //   1463: iload 17
    //   1465: istore 18
    //   1467: aload_1
    //   1468: astore 33
    //   1470: iload 5
    //   1472: istore 6
    //   1474: aload 42
    //   1476: aload_1
    //   1477: invokevirtual 524	java/net/HttpURLConnection:getContentEncoding	()Ljava/lang/String;
    //   1480: putfield 526	com/tencent/mobileqq/emoticon/DownloadInfo:i	Ljava/lang/String;
    //   1483: lload 25
    //   1485: lstore 27
    //   1487: iload 17
    //   1489: istore 19
    //   1491: aload_1
    //   1492: astore 36
    //   1494: iload 5
    //   1496: istore 7
    //   1498: aload 31
    //   1500: astore 34
    //   1502: iload 17
    //   1504: istore 18
    //   1506: aload_1
    //   1507: astore 33
    //   1509: iload 5
    //   1511: istore 6
    //   1513: aload 42
    //   1515: aload_1
    //   1516: ldc_w 271
    //   1519: invokevirtual 265	java/net/HttpURLConnection:getHeaderField	(Ljava/lang/String;)Ljava/lang/String;
    //   1522: putfield 527	com/tencent/mobileqq/emoticon/DownloadInfo:f	Ljava/lang/String;
    //   1525: lload 25
    //   1527: lstore 27
    //   1529: iload 17
    //   1531: istore 19
    //   1533: aload_1
    //   1534: astore 36
    //   1536: iload 5
    //   1538: istore 7
    //   1540: aload 31
    //   1542: astore 34
    //   1544: iload 17
    //   1546: istore 18
    //   1548: aload_1
    //   1549: astore 33
    //   1551: iload 5
    //   1553: istore 6
    //   1555: aload_1
    //   1556: ldc_w 267
    //   1559: invokevirtual 265	java/net/HttpURLConnection:getHeaderField	(Ljava/lang/String;)Ljava/lang/String;
    //   1562: astore 32
    //   1564: lload 25
    //   1566: lstore 27
    //   1568: iload 17
    //   1570: istore 19
    //   1572: aload_1
    //   1573: astore 36
    //   1575: iload 5
    //   1577: istore 7
    //   1579: lload 25
    //   1581: lstore 29
    //   1583: iload 17
    //   1585: istore 20
    //   1587: aload_1
    //   1588: astore 37
    //   1590: iload 5
    //   1592: istore 8
    //   1594: aload 31
    //   1596: astore 34
    //   1598: iload 17
    //   1600: istore 18
    //   1602: aload_1
    //   1603: astore 33
    //   1605: iload 5
    //   1607: istore 6
    //   1609: aload 32
    //   1611: invokestatic 77	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   1614: ifne +1994 -> 3608
    //   1617: lload 25
    //   1619: lstore 27
    //   1621: iload 17
    //   1623: istore 19
    //   1625: aload_1
    //   1626: astore 36
    //   1628: iload 5
    //   1630: istore 7
    //   1632: lload 25
    //   1634: lstore 29
    //   1636: iload 17
    //   1638: istore 20
    //   1640: aload_1
    //   1641: astore 37
    //   1643: iload 5
    //   1645: istore 8
    //   1647: aload 31
    //   1649: astore 34
    //   1651: iload 17
    //   1653: istore 18
    //   1655: aload_1
    //   1656: astore 33
    //   1658: iload 5
    //   1660: istore 6
    //   1662: ldc 244
    //   1664: iconst_1
    //   1665: new 176	java/lang/StringBuilder
    //   1668: dup
    //   1669: invokespecial 177	java/lang/StringBuilder:<init>	()V
    //   1672: ldc_w 529
    //   1675: invokevirtual 181	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1678: aload 32
    //   1680: invokevirtual 181	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1683: invokevirtual 185	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1686: invokestatic 217	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   1689: lload 25
    //   1691: lstore 27
    //   1693: iload 17
    //   1695: istore 19
    //   1697: aload_1
    //   1698: astore 36
    //   1700: iload 5
    //   1702: istore 7
    //   1704: lload 25
    //   1706: lstore 29
    //   1708: iload 17
    //   1710: istore 20
    //   1712: aload_1
    //   1713: astore 37
    //   1715: iload 5
    //   1717: istore 8
    //   1719: aload 31
    //   1721: astore 34
    //   1723: iload 17
    //   1725: istore 18
    //   1727: aload_1
    //   1728: astore 33
    //   1730: iload 5
    //   1732: istore 6
    //   1734: aload_0
    //   1735: aload_1
    //   1736: aload_3
    //   1737: invokespecial 531	com/tencent/mobileqq/app/FaceDownloader:a	(Ljava/net/HttpURLConnection;Lcom/tencent/mobileqq/util/FaceInfo;)V
    //   1740: iconst_0
    //   1741: istore 13
    //   1743: iconst_0
    //   1744: istore 9
    //   1746: iconst_0
    //   1747: istore 14
    //   1749: iconst_0
    //   1750: istore 10
    //   1752: iconst_0
    //   1753: istore 5
    //   1755: lload 25
    //   1757: lstore 27
    //   1759: iload 17
    //   1761: istore 19
    //   1763: aload_1
    //   1764: astore 36
    //   1766: iload 5
    //   1768: istore 7
    //   1770: lload 25
    //   1772: lstore 29
    //   1774: iload 17
    //   1776: istore 20
    //   1778: aload_1
    //   1779: astore 37
    //   1781: iload 13
    //   1783: istore 8
    //   1785: aload 31
    //   1787: astore 34
    //   1789: iload 17
    //   1791: istore 18
    //   1793: aload_1
    //   1794: astore 33
    //   1796: iload 14
    //   1798: istore 6
    //   1800: sipush 200
    //   1803: aload 42
    //   1805: getfield 519	com/tencent/mobileqq/emoticon/DownloadInfo:c	I
    //   1808: if_icmpne +3161 -> 4969
    //   1811: lload 25
    //   1813: lstore 27
    //   1815: iload 17
    //   1817: istore 19
    //   1819: aload_1
    //   1820: astore 36
    //   1822: iload 5
    //   1824: istore 7
    //   1826: lload 25
    //   1828: lstore 29
    //   1830: iload 17
    //   1832: istore 20
    //   1834: aload_1
    //   1835: astore 37
    //   1837: iload 13
    //   1839: istore 8
    //   1841: aload 31
    //   1843: astore 34
    //   1845: iload 17
    //   1847: istore 18
    //   1849: aload_1
    //   1850: astore 33
    //   1852: iload 14
    //   1854: istore 6
    //   1856: aload 42
    //   1858: getfield 520	com/tencent/mobileqq/emoticon/DownloadInfo:e	I
    //   1861: istore 15
    //   1863: iload 15
    //   1865: i2l
    //   1866: lstore 25
    //   1868: iconst_0
    //   1869: istore 15
    //   1871: lload 25
    //   1873: lstore 27
    //   1875: iload 17
    //   1877: istore 19
    //   1879: aload_1
    //   1880: astore 36
    //   1882: iload 5
    //   1884: istore 7
    //   1886: lload 25
    //   1888: lstore 29
    //   1890: iload 17
    //   1892: istore 20
    //   1894: aload_1
    //   1895: astore 37
    //   1897: iload 13
    //   1899: istore 8
    //   1901: aload 31
    //   1903: astore 34
    //   1905: iload 17
    //   1907: istore 18
    //   1909: aload_1
    //   1910: astore 33
    //   1912: iload 14
    //   1914: istore 6
    //   1916: aload 40
    //   1918: invokevirtual 372	java/io/File:exists	()Z
    //   1921: ifeq +54 -> 1975
    //   1924: lload 25
    //   1926: lstore 27
    //   1928: iload 17
    //   1930: istore 19
    //   1932: aload_1
    //   1933: astore 36
    //   1935: iload 5
    //   1937: istore 7
    //   1939: lload 25
    //   1941: lstore 29
    //   1943: iload 17
    //   1945: istore 20
    //   1947: aload_1
    //   1948: astore 37
    //   1950: iload 13
    //   1952: istore 8
    //   1954: aload 31
    //   1956: astore 34
    //   1958: iload 17
    //   1960: istore 18
    //   1962: aload_1
    //   1963: astore 33
    //   1965: iload 14
    //   1967: istore 6
    //   1969: aload 40
    //   1971: invokevirtual 402	java/io/File:delete	()Z
    //   1974: pop
    //   1975: lload 25
    //   1977: lstore 27
    //   1979: iload 17
    //   1981: istore 19
    //   1983: aload_1
    //   1984: astore 36
    //   1986: iload 5
    //   1988: istore 7
    //   1990: lload 25
    //   1992: lstore 29
    //   1994: iload 17
    //   1996: istore 20
    //   1998: aload_1
    //   1999: astore 37
    //   2001: iload 13
    //   2003: istore 8
    //   2005: aload 31
    //   2007: astore 34
    //   2009: iload 17
    //   2011: istore 18
    //   2013: aload_1
    //   2014: astore 33
    //   2016: iload 14
    //   2018: istore 6
    //   2020: aload 40
    //   2022: invokevirtual 534	java/io/File:createNewFile	()Z
    //   2025: pop
    //   2026: lload 25
    //   2028: lstore 27
    //   2030: iload 17
    //   2032: istore 19
    //   2034: aload_1
    //   2035: astore 36
    //   2037: iload 5
    //   2039: istore 7
    //   2041: lload 25
    //   2043: lstore 29
    //   2045: iload 17
    //   2047: istore 20
    //   2049: aload_1
    //   2050: astore 37
    //   2052: iload 13
    //   2054: istore 8
    //   2056: aload 31
    //   2058: astore 34
    //   2060: iload 17
    //   2062: istore 18
    //   2064: aload_1
    //   2065: astore 33
    //   2067: iload 14
    //   2069: istore 6
    //   2071: new 536	java/io/BufferedOutputStream
    //   2074: dup
    //   2075: new 538	java/io/FileOutputStream
    //   2078: dup
    //   2079: aload 40
    //   2081: invokespecial 541	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   2084: invokespecial 544	java/io/BufferedOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   2087: astore 32
    //   2089: aload_1
    //   2090: invokevirtual 548	java/net/HttpURLConnection:getInputStream	()Ljava/io/InputStream;
    //   2093: astore 31
    //   2095: iload 4
    //   2097: ifeq +2741 -> 4838
    //   2100: lload 25
    //   2102: ldc2_w 549
    //   2105: lcmp
    //   2106: ifge +2732 -> 4838
    //   2109: ldc_w 551
    //   2112: newarray byte
    //   2114: astore 34
    //   2116: iconst_0
    //   2117: istore 5
    //   2119: iconst_0
    //   2120: istore 6
    //   2122: aload 31
    //   2124: aload 34
    //   2126: iload 6
    //   2128: sipush 1024
    //   2131: invokevirtual 557	java/io/InputStream:read	([BII)I
    //   2134: istore 7
    //   2136: iload 7
    //   2138: iconst_m1
    //   2139: if_icmpeq +2066 -> 4205
    //   2142: iload 6
    //   2144: iload 7
    //   2146: iadd
    //   2147: istore 6
    //   2149: iload 7
    //   2151: iload 5
    //   2153: iadd
    //   2154: istore 5
    //   2156: goto -34 -> 2122
    //   2159: aload 34
    //   2161: getfield 444	AvatarInfo/QQHeadInfo:originUsrType	I
    //   2164: bipush 32
    //   2166: if_icmpne -1811 -> 355
    //   2169: ldc_w 559
    //   2172: astore 32
    //   2174: goto -1819 -> 355
    //   2177: aload 34
    //   2179: getfield 441	AvatarInfo/QQHeadInfo:dstUsrType	B
    //   2182: bipush 16
    //   2184: if_icmpne +10 -> 2194
    //   2187: ldc 201
    //   2189: astore 32
    //   2191: goto -1836 -> 355
    //   2194: aload 34
    //   2196: getfield 441	AvatarInfo/QQHeadInfo:dstUsrType	B
    //   2199: iconst_4
    //   2200: if_icmpeq +13 -> 2213
    //   2203: aload 34
    //   2205: getfield 441	AvatarInfo/QQHeadInfo:dstUsrType	B
    //   2208: bipush 8
    //   2210: if_icmpne +11 -> 2221
    //   2213: ldc_w 559
    //   2216: astore 32
    //   2218: goto -1863 -> 355
    //   2221: ldc 201
    //   2223: astore 32
    //   2225: goto -1870 -> 355
    //   2228: lload 25
    //   2230: lstore 27
    //   2232: iload 21
    //   2234: istore 19
    //   2236: aload_1
    //   2237: astore 36
    //   2239: iload 5
    //   2241: istore 7
    //   2243: lload 25
    //   2245: lstore 29
    //   2247: iload 22
    //   2249: istore 20
    //   2251: aload_1
    //   2252: astore 37
    //   2254: iload 5
    //   2256: istore 8
    //   2258: aload 31
    //   2260: astore 34
    //   2262: iload 23
    //   2264: istore 18
    //   2266: aload_1
    //   2267: astore 33
    //   2269: iload 5
    //   2271: istore 6
    //   2273: iconst_1
    //   2274: putstatic 476	com/tencent/mobileqq/app/FaceDownloader:jdField_a_of_type_Boolean	Z
    //   2277: goto -1595 -> 682
    //   2280: astore 32
    //   2282: iload 19
    //   2284: istore 17
    //   2286: lload 27
    //   2288: lstore 25
    //   2290: aload 36
    //   2292: astore_1
    //   2293: iload 7
    //   2295: istore 5
    //   2297: iload 5
    //   2299: istore 6
    //   2301: ldc 244
    //   2303: iconst_1
    //   2304: new 176	java/lang/StringBuilder
    //   2307: dup
    //   2308: invokespecial 177	java/lang/StringBuilder:<init>	()V
    //   2311: ldc_w 561
    //   2314: invokevirtual 181	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2317: aload 39
    //   2319: invokevirtual 274	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   2322: ldc_w 450
    //   2325: invokevirtual 181	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2328: aload_3
    //   2329: invokevirtual 274	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   2332: invokevirtual 185	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2335: aload 32
    //   2337: invokestatic 564	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   2340: iload 5
    //   2342: istore 6
    //   2344: aload 32
    //   2346: instanceof 566
    //   2349: istore 18
    //   2351: iload 18
    //   2353: ifeq +2679 -> 5032
    //   2356: bipush 10
    //   2358: istore 5
    //   2360: aload_1
    //   2361: ifnull +7 -> 2368
    //   2364: aload_1
    //   2365: invokevirtual 569	java/net/HttpURLConnection:disconnect	()V
    //   2368: aload 31
    //   2370: ifnull +8 -> 2378
    //   2373: aload 31
    //   2375: invokevirtual 574	java/io/OutputStream:close	()V
    //   2378: iload 5
    //   2380: ifeq +76 -> 2456
    //   2383: aload 40
    //   2385: ifnull +71 -> 2456
    //   2388: aload 40
    //   2390: invokevirtual 369	java/io/File:getParentFile	()Ljava/io/File;
    //   2393: astore 32
    //   2395: aload 32
    //   2397: ifnull +17 -> 2414
    //   2400: aload 32
    //   2402: invokevirtual 372	java/io/File:exists	()Z
    //   2405: ifne +9 -> 2414
    //   2408: aload 32
    //   2410: invokevirtual 375	java/io/File:mkdirs	()Z
    //   2413: pop
    //   2414: aload 40
    //   2416: invokevirtual 372	java/io/File:exists	()Z
    //   2419: ifeq +37 -> 2456
    //   2422: aload 40
    //   2424: invokevirtual 402	java/io/File:delete	()Z
    //   2427: istore 18
    //   2429: ldc 244
    //   2431: iconst_1
    //   2432: new 176	java/lang/StringBuilder
    //   2435: dup
    //   2436: invokespecial 177	java/lang/StringBuilder:<init>	()V
    //   2439: ldc_w 576
    //   2442: invokevirtual 181	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2445: iload 18
    //   2447: invokevirtual 579	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   2450: invokevirtual 185	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2453: invokestatic 217	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   2456: iload 11
    //   2458: iconst_1
    //   2459: iadd
    //   2460: istore 6
    //   2462: iload 5
    //   2464: ifeq +141 -> 2605
    //   2467: ldc 244
    //   2469: iconst_1
    //   2470: new 176	java/lang/StringBuilder
    //   2473: dup
    //   2474: invokespecial 177	java/lang/StringBuilder:<init>	()V
    //   2477: ldc_w 581
    //   2480: invokevirtual 181	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2483: iload 5
    //   2485: invokevirtual 234	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   2488: ldc_w 583
    //   2491: invokevirtual 181	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2494: aload 39
    //   2496: invokevirtual 274	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   2499: ldc_w 497
    //   2502: invokevirtual 181	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2505: iload 6
    //   2507: invokevirtual 234	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   2510: ldc_w 450
    //   2513: invokevirtual 181	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2516: aload_3
    //   2517: invokevirtual 274	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   2520: ldc_w 585
    //   2523: invokevirtual 181	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2526: iload 17
    //   2528: invokevirtual 579	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   2531: ldc_w 587
    //   2534: invokevirtual 181	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2537: aload 43
    //   2539: invokevirtual 181	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2542: ldc_w 589
    //   2545: invokevirtual 181	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2548: iload 16
    //   2550: invokevirtual 234	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   2553: ldc_w 591
    //   2556: invokevirtual 181	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2559: getstatic 476	com/tencent/mobileqq/app/FaceDownloader:jdField_a_of_type_Boolean	Z
    //   2562: invokevirtual 579	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   2565: ldc_w 593
    //   2568: invokevirtual 181	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2571: iload 12
    //   2573: invokevirtual 234	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   2576: ldc_w 595
    //   2579: invokevirtual 181	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2582: aload 44
    //   2584: invokevirtual 181	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2587: ldc_w 597
    //   2590: invokevirtual 181	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2593: getstatic 26	com/tencent/mobileqq/app/FaceDownloader:e	I
    //   2596: invokevirtual 234	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   2599: invokevirtual 185	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2602: invokestatic 217	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   2605: iload 5
    //   2607: ifeq +3354 -> 5961
    //   2610: iload 6
    //   2612: iconst_2
    //   2613: if_icmpge +3348 -> 5961
    //   2616: aload 38
    //   2618: monitorenter
    //   2619: aload 38
    //   2621: ldc2_w 598
    //   2624: invokevirtual 603	java/lang/Object:wait	(J)V
    //   2627: aload 38
    //   2629: monitorexit
    //   2630: aload_1
    //   2631: astore 32
    //   2633: aload 31
    //   2635: astore 34
    //   2637: iload 5
    //   2639: ifeq +9 -> 2648
    //   2642: iload 6
    //   2644: iconst_2
    //   2645: if_icmplt +3298 -> 5943
    //   2648: goto -2422 -> 226
    //   2651: aload 35
    //   2653: aload 43
    //   2655: iload 16
    //   2657: invokestatic 606	com/tencent/mobileqq/utils/httputils/PkgTools:b	(Ljava/lang/String;Ljava/lang/String;I)Ljava/net/HttpURLConnection;
    //   2660: astore 32
    //   2662: aload 32
    //   2664: astore_1
    //   2665: goto -1626 -> 1039
    //   2668: aload 44
    //   2670: getstatic 608	com/tencent/mobileqq/utils/httputils/PkgTools:b	Ljava/lang/String;
    //   2673: invokevirtual 85	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   2676: ifeq +23 -> 2699
    //   2679: aload 35
    //   2681: aload 43
    //   2683: iload 16
    //   2685: invokestatic 610	com/tencent/mobileqq/utils/httputils/PkgTools:a	(Ljava/lang/String;Ljava/lang/String;I)Ljava/net/HttpURLConnection;
    //   2688: astore 32
    //   2690: iconst_1
    //   2691: istore 17
    //   2693: aload 32
    //   2695: astore_1
    //   2696: goto -1612 -> 1084
    //   2699: aload 35
    //   2701: aload 43
    //   2703: iload 16
    //   2705: invokestatic 610	com/tencent/mobileqq/utils/httputils/PkgTools:a	(Ljava/lang/String;Ljava/lang/String;I)Ljava/net/HttpURLConnection;
    //   2708: astore 32
    //   2710: aload 32
    //   2712: astore_1
    //   2713: iconst_1
    //   2714: istore 17
    //   2716: goto -1632 -> 1084
    //   2719: lload 25
    //   2721: lstore 27
    //   2723: iload 21
    //   2725: istore 19
    //   2727: aload_1
    //   2728: astore 36
    //   2730: iload 5
    //   2732: istore 7
    //   2734: lload 25
    //   2736: lstore 29
    //   2738: iload 22
    //   2740: istore 20
    //   2742: aload_1
    //   2743: astore 37
    //   2745: iload 5
    //   2747: istore 8
    //   2749: aload 31
    //   2751: astore 34
    //   2753: iload 23
    //   2755: istore 18
    //   2757: aload_1
    //   2758: astore 33
    //   2760: iload 5
    //   2762: istore 6
    //   2764: new 356	java/net/URL
    //   2767: dup
    //   2768: aload 35
    //   2770: invokespecial 357	java/net/URL:<init>	(Ljava/lang/String;)V
    //   2773: invokevirtual 490	java/net/URL:openConnection	()Ljava/net/URLConnection;
    //   2776: checkcast 248	java/net/HttpURLConnection
    //   2779: astore_1
    //   2780: goto -1696 -> 1084
    //   2783: astore 32
    //   2785: iload 17
    //   2787: ifeq +475 -> 3262
    //   2790: lload 25
    //   2792: lstore 27
    //   2794: iload 17
    //   2796: istore 19
    //   2798: aload_1
    //   2799: astore 36
    //   2801: iload 5
    //   2803: istore 7
    //   2805: lload 25
    //   2807: lstore 29
    //   2809: iload 17
    //   2811: istore 20
    //   2813: aload_1
    //   2814: astore 37
    //   2816: iload 5
    //   2818: istore 8
    //   2820: aload 31
    //   2822: astore 34
    //   2824: iload 17
    //   2826: istore 18
    //   2828: aload_1
    //   2829: astore 33
    //   2831: iload 5
    //   2833: istore 6
    //   2835: iconst_1
    //   2836: putstatic 476	com/tencent/mobileqq/app/FaceDownloader:jdField_a_of_type_Boolean	Z
    //   2839: lload 25
    //   2841: lstore 27
    //   2843: iload 17
    //   2845: istore 19
    //   2847: aload_1
    //   2848: astore 36
    //   2850: iload 5
    //   2852: istore 7
    //   2854: lload 25
    //   2856: lstore 29
    //   2858: iload 17
    //   2860: istore 20
    //   2862: aload_1
    //   2863: astore 37
    //   2865: iload 5
    //   2867: istore 8
    //   2869: aload 31
    //   2871: astore 34
    //   2873: iload 17
    //   2875: istore 18
    //   2877: aload_1
    //   2878: astore 33
    //   2880: iload 5
    //   2882: istore 6
    //   2884: aload 32
    //   2886: athrow
    //   2887: astore 32
    //   2889: iload 8
    //   2891: istore 5
    //   2893: aload 37
    //   2895: astore_1
    //   2896: iload 20
    //   2898: istore 17
    //   2900: lload 29
    //   2902: lstore 27
    //   2904: aload 31
    //   2906: astore 34
    //   2908: iload 17
    //   2910: istore 18
    //   2912: aload_1
    //   2913: astore 33
    //   2915: iload 5
    //   2917: istore 6
    //   2919: ldc 244
    //   2921: iconst_1
    //   2922: new 176	java/lang/StringBuilder
    //   2925: dup
    //   2926: invokespecial 177	java/lang/StringBuilder:<init>	()V
    //   2929: ldc_w 612
    //   2932: invokevirtual 181	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2935: aload 39
    //   2937: invokevirtual 274	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   2940: ldc_w 450
    //   2943: invokevirtual 181	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2946: aload_3
    //   2947: invokevirtual 274	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   2950: invokevirtual 185	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2953: aload 32
    //   2955: invokestatic 564	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   2958: iconst_5
    //   2959: istore 7
    //   2961: aload_1
    //   2962: ifnull +7 -> 2969
    //   2965: aload_1
    //   2966: invokevirtual 569	java/net/HttpURLConnection:disconnect	()V
    //   2969: aload 31
    //   2971: ifnull +8 -> 2979
    //   2974: aload 31
    //   2976: invokevirtual 574	java/io/OutputStream:close	()V
    //   2979: aload 40
    //   2981: ifnull +71 -> 3052
    //   2984: aload 40
    //   2986: invokevirtual 369	java/io/File:getParentFile	()Ljava/io/File;
    //   2989: astore 32
    //   2991: aload 32
    //   2993: ifnull +17 -> 3010
    //   2996: aload 32
    //   2998: invokevirtual 372	java/io/File:exists	()Z
    //   3001: ifne +9 -> 3010
    //   3004: aload 32
    //   3006: invokevirtual 375	java/io/File:mkdirs	()Z
    //   3009: pop
    //   3010: aload 40
    //   3012: invokevirtual 372	java/io/File:exists	()Z
    //   3015: ifeq +37 -> 3052
    //   3018: aload 40
    //   3020: invokevirtual 402	java/io/File:delete	()Z
    //   3023: istore 18
    //   3025: ldc 244
    //   3027: iconst_1
    //   3028: new 176	java/lang/StringBuilder
    //   3031: dup
    //   3032: invokespecial 177	java/lang/StringBuilder:<init>	()V
    //   3035: ldc_w 576
    //   3038: invokevirtual 181	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3041: iload 18
    //   3043: invokevirtual 579	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   3046: invokevirtual 185	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3049: invokestatic 217	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   3052: iload 11
    //   3054: iconst_1
    //   3055: iadd
    //   3056: istore 8
    //   3058: ldc 244
    //   3060: iconst_1
    //   3061: new 176	java/lang/StringBuilder
    //   3064: dup
    //   3065: invokespecial 177	java/lang/StringBuilder:<init>	()V
    //   3068: ldc_w 581
    //   3071: invokevirtual 181	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3074: iconst_5
    //   3075: invokevirtual 234	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   3078: ldc_w 583
    //   3081: invokevirtual 181	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3084: aload 39
    //   3086: invokevirtual 274	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   3089: ldc_w 497
    //   3092: invokevirtual 181	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3095: iload 8
    //   3097: invokevirtual 234	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   3100: ldc_w 450
    //   3103: invokevirtual 181	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3106: aload_3
    //   3107: invokevirtual 274	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   3110: ldc_w 585
    //   3113: invokevirtual 181	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3116: iload 17
    //   3118: invokevirtual 579	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   3121: ldc_w 587
    //   3124: invokevirtual 181	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3127: aload 43
    //   3129: invokevirtual 181	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3132: ldc_w 589
    //   3135: invokevirtual 181	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3138: iload 16
    //   3140: invokevirtual 234	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   3143: ldc_w 591
    //   3146: invokevirtual 181	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3149: getstatic 476	com/tencent/mobileqq/app/FaceDownloader:jdField_a_of_type_Boolean	Z
    //   3152: invokevirtual 579	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   3155: ldc_w 593
    //   3158: invokevirtual 181	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3161: iload 12
    //   3163: invokevirtual 234	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   3166: ldc_w 595
    //   3169: invokevirtual 181	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3172: aload 44
    //   3174: invokevirtual 181	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3177: ldc_w 597
    //   3180: invokevirtual 181	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3183: getstatic 26	com/tencent/mobileqq/app/FaceDownloader:e	I
    //   3186: invokevirtual 234	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   3189: invokevirtual 185	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3192: invokestatic 217	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   3195: iload 7
    //   3197: istore 5
    //   3199: iload 8
    //   3201: istore 6
    //   3203: lload 27
    //   3205: lstore 25
    //   3207: aload 31
    //   3209: astore 34
    //   3211: aload_1
    //   3212: astore 32
    //   3214: iload 8
    //   3216: iconst_2
    //   3217: if_icmpge -580 -> 2637
    //   3220: aload 38
    //   3222: monitorenter
    //   3223: aload 38
    //   3225: ldc2_w 598
    //   3228: invokevirtual 603	java/lang/Object:wait	(J)V
    //   3231: aload 38
    //   3233: monitorexit
    //   3234: iload 7
    //   3236: istore 5
    //   3238: iload 8
    //   3240: istore 6
    //   3242: lload 27
    //   3244: lstore 25
    //   3246: aload 31
    //   3248: astore 34
    //   3250: aload_1
    //   3251: astore 32
    //   3253: goto -616 -> 2637
    //   3256: astore_1
    //   3257: aload 38
    //   3259: monitorexit
    //   3260: aload_1
    //   3261: athrow
    //   3262: aload 43
    //   3264: ifnull -425 -> 2839
    //   3267: iload 16
    //   3269: ifle -430 -> 2839
    //   3272: lload 25
    //   3274: lstore 27
    //   3276: iload 17
    //   3278: istore 19
    //   3280: aload_1
    //   3281: astore 36
    //   3283: iload 5
    //   3285: istore 7
    //   3287: lload 25
    //   3289: lstore 29
    //   3291: iload 17
    //   3293: istore 20
    //   3295: aload_1
    //   3296: astore 37
    //   3298: iload 5
    //   3300: istore 8
    //   3302: aload 31
    //   3304: astore 34
    //   3306: iload 17
    //   3308: istore 18
    //   3310: aload_1
    //   3311: astore 33
    //   3313: iload 5
    //   3315: istore 6
    //   3317: iconst_0
    //   3318: putstatic 476	com/tencent/mobileqq/app/FaceDownloader:jdField_a_of_type_Boolean	Z
    //   3321: goto -482 -> 2839
    //   3324: astore_2
    //   3325: iload 6
    //   3327: istore 5
    //   3329: aload 33
    //   3331: astore_1
    //   3332: iload 18
    //   3334: istore 17
    //   3336: aload 34
    //   3338: astore 31
    //   3340: aload_1
    //   3341: ifnull +7 -> 3348
    //   3344: aload_1
    //   3345: invokevirtual 569	java/net/HttpURLConnection:disconnect	()V
    //   3348: aload 31
    //   3350: ifnull +8 -> 3358
    //   3353: aload 31
    //   3355: invokevirtual 574	java/io/OutputStream:close	()V
    //   3358: iload 5
    //   3360: ifeq +72 -> 3432
    //   3363: aload 40
    //   3365: ifnull +67 -> 3432
    //   3368: aload 40
    //   3370: invokevirtual 369	java/io/File:getParentFile	()Ljava/io/File;
    //   3373: astore_1
    //   3374: aload_1
    //   3375: ifnull +15 -> 3390
    //   3378: aload_1
    //   3379: invokevirtual 372	java/io/File:exists	()Z
    //   3382: ifne +8 -> 3390
    //   3385: aload_1
    //   3386: invokevirtual 375	java/io/File:mkdirs	()Z
    //   3389: pop
    //   3390: aload 40
    //   3392: invokevirtual 372	java/io/File:exists	()Z
    //   3395: ifeq +37 -> 3432
    //   3398: aload 40
    //   3400: invokevirtual 402	java/io/File:delete	()Z
    //   3403: istore 4
    //   3405: ldc 244
    //   3407: iconst_1
    //   3408: new 176	java/lang/StringBuilder
    //   3411: dup
    //   3412: invokespecial 177	java/lang/StringBuilder:<init>	()V
    //   3415: ldc_w 576
    //   3418: invokevirtual 181	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3421: iload 4
    //   3423: invokevirtual 579	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   3426: invokevirtual 185	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3429: invokestatic 217	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   3432: iload 11
    //   3434: iconst_1
    //   3435: iadd
    //   3436: istore 6
    //   3438: iload 5
    //   3440: ifeq +141 -> 3581
    //   3443: ldc 244
    //   3445: iconst_1
    //   3446: new 176	java/lang/StringBuilder
    //   3449: dup
    //   3450: invokespecial 177	java/lang/StringBuilder:<init>	()V
    //   3453: ldc_w 581
    //   3456: invokevirtual 181	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3459: iload 5
    //   3461: invokevirtual 234	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   3464: ldc_w 583
    //   3467: invokevirtual 181	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3470: aload 39
    //   3472: invokevirtual 274	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   3475: ldc_w 497
    //   3478: invokevirtual 181	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3481: iload 6
    //   3483: invokevirtual 234	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   3486: ldc_w 450
    //   3489: invokevirtual 181	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3492: aload_3
    //   3493: invokevirtual 274	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   3496: ldc_w 585
    //   3499: invokevirtual 181	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3502: iload 17
    //   3504: invokevirtual 579	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   3507: ldc_w 587
    //   3510: invokevirtual 181	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3513: aload 43
    //   3515: invokevirtual 181	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3518: ldc_w 589
    //   3521: invokevirtual 181	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3524: iload 16
    //   3526: invokevirtual 234	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   3529: ldc_w 591
    //   3532: invokevirtual 181	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3535: getstatic 476	com/tencent/mobileqq/app/FaceDownloader:jdField_a_of_type_Boolean	Z
    //   3538: invokevirtual 579	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   3541: ldc_w 593
    //   3544: invokevirtual 181	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3547: iload 12
    //   3549: invokevirtual 234	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   3552: ldc_w 595
    //   3555: invokevirtual 181	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3558: aload 44
    //   3560: invokevirtual 181	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3563: ldc_w 597
    //   3566: invokevirtual 181	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3569: getstatic 26	com/tencent/mobileqq/app/FaceDownloader:e	I
    //   3572: invokevirtual 234	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   3575: invokevirtual 185	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3578: invokestatic 217	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   3581: iload 5
    //   3583: ifeq +23 -> 3606
    //   3586: iload 6
    //   3588: iconst_2
    //   3589: if_icmpge +17 -> 3606
    //   3592: aload 38
    //   3594: monitorenter
    //   3595: aload 38
    //   3597: ldc2_w 598
    //   3600: invokevirtual 603	java/lang/Object:wait	(J)V
    //   3603: aload 38
    //   3605: monitorexit
    //   3606: aload_2
    //   3607: athrow
    //   3608: iconst_0
    //   3609: istore 9
    //   3611: lload 25
    //   3613: lstore 27
    //   3615: iload 17
    //   3617: istore 19
    //   3619: aload_1
    //   3620: astore 36
    //   3622: iload 5
    //   3624: istore 7
    //   3626: lload 25
    //   3628: lstore 29
    //   3630: iload 17
    //   3632: istore 20
    //   3634: aload_1
    //   3635: astore 37
    //   3637: iload 5
    //   3639: istore 8
    //   3641: aload 31
    //   3643: astore 34
    //   3645: iload 17
    //   3647: istore 18
    //   3649: aload_1
    //   3650: astore 33
    //   3652: iload 5
    //   3654: istore 6
    //   3656: aload 42
    //   3658: getfield 527	com/tencent/mobileqq/emoticon/DownloadInfo:f	Ljava/lang/String;
    //   3661: ifnonnull +2246 -> 5907
    //   3664: lload 25
    //   3666: lstore 27
    //   3668: iload 17
    //   3670: istore 19
    //   3672: aload_1
    //   3673: astore 36
    //   3675: iload 5
    //   3677: istore 7
    //   3679: lload 25
    //   3681: lstore 29
    //   3683: iload 17
    //   3685: istore 20
    //   3687: aload_1
    //   3688: astore 37
    //   3690: iload 5
    //   3692: istore 8
    //   3694: aload 31
    //   3696: astore 34
    //   3698: iload 17
    //   3700: istore 18
    //   3702: aload_1
    //   3703: astore 33
    //   3705: iload 5
    //   3707: istore 6
    //   3709: aload 42
    //   3711: getfield 519	com/tencent/mobileqq/emoticon/DownloadInfo:c	I
    //   3714: istore 9
    //   3716: iload 9
    //   3718: sipush 200
    //   3721: if_icmpne +423 -> 4144
    //   3724: bipush 30
    //   3726: istore 5
    //   3728: iconst_1
    //   3729: istore 7
    //   3731: iload 5
    //   3733: istore 6
    //   3735: iload 7
    //   3737: istore 13
    //   3739: iload 6
    //   3741: istore 5
    //   3743: iload 6
    //   3745: istore 8
    //   3747: iload 6
    //   3749: istore 9
    //   3751: iload 6
    //   3753: istore 10
    //   3755: aload_3
    //   3756: getfield 242	com/tencent/mobileqq/util/FaceInfo:jdField_a_of_type_AvatarInfoQQHeadInfo	LAvatarInfo/QQHeadInfo;
    //   3759: getfield 615	AvatarInfo/QQHeadInfo:headVerify	Ljava/lang/String;
    //   3762: invokestatic 77	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   3765: ifne +76 -> 3841
    //   3768: iload 7
    //   3770: istore 13
    //   3772: iload 6
    //   3774: istore 5
    //   3776: iload 6
    //   3778: istore 8
    //   3780: iload 6
    //   3782: istore 9
    //   3784: iload 6
    //   3786: istore 10
    //   3788: aload 42
    //   3790: getfield 527	com/tencent/mobileqq/emoticon/DownloadInfo:f	Ljava/lang/String;
    //   3793: ifnull +48 -> 3841
    //   3796: iload 7
    //   3798: istore 13
    //   3800: iload 6
    //   3802: istore 5
    //   3804: iload 6
    //   3806: istore 8
    //   3808: iload 6
    //   3810: istore 9
    //   3812: iload 6
    //   3814: istore 10
    //   3816: aload 42
    //   3818: getfield 527	com/tencent/mobileqq/emoticon/DownloadInfo:f	Ljava/lang/String;
    //   3821: aload_3
    //   3822: getfield 242	com/tencent/mobileqq/util/FaceInfo:jdField_a_of_type_AvatarInfoQQHeadInfo	LAvatarInfo/QQHeadInfo;
    //   3825: getfield 615	AvatarInfo/QQHeadInfo:headVerify	Ljava/lang/String;
    //   3828: invokevirtual 85	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   3831: ifne +10 -> 3841
    //   3834: bipush 31
    //   3836: istore 5
    //   3838: iconst_1
    //   3839: istore 13
    //   3841: iload 13
    //   3843: ifeq -2103 -> 1740
    //   3846: iload 5
    //   3848: istore 8
    //   3850: iload 5
    //   3852: istore 9
    //   3854: iload 5
    //   3856: istore 10
    //   3858: aload_0
    //   3859: aload_1
    //   3860: aload_3
    //   3861: invokespecial 531	com/tencent/mobileqq/app/FaceDownloader:a	(Ljava/net/HttpURLConnection;Lcom/tencent/mobileqq/util/FaceInfo;)V
    //   3864: aload_1
    //   3865: ifnull +7 -> 3872
    //   3868: aload_1
    //   3869: invokevirtual 569	java/net/HttpURLConnection:disconnect	()V
    //   3872: aload 31
    //   3874: ifnull +8 -> 3882
    //   3877: aload 31
    //   3879: invokevirtual 574	java/io/OutputStream:close	()V
    //   3882: iload 5
    //   3884: ifeq +76 -> 3960
    //   3887: aload 40
    //   3889: ifnull +71 -> 3960
    //   3892: aload 40
    //   3894: invokevirtual 369	java/io/File:getParentFile	()Ljava/io/File;
    //   3897: astore 32
    //   3899: aload 32
    //   3901: ifnull +17 -> 3918
    //   3904: aload 32
    //   3906: invokevirtual 372	java/io/File:exists	()Z
    //   3909: ifne +9 -> 3918
    //   3912: aload 32
    //   3914: invokevirtual 375	java/io/File:mkdirs	()Z
    //   3917: pop
    //   3918: aload 40
    //   3920: invokevirtual 372	java/io/File:exists	()Z
    //   3923: ifeq +37 -> 3960
    //   3926: aload 40
    //   3928: invokevirtual 402	java/io/File:delete	()Z
    //   3931: istore 18
    //   3933: ldc 244
    //   3935: iconst_1
    //   3936: new 176	java/lang/StringBuilder
    //   3939: dup
    //   3940: invokespecial 177	java/lang/StringBuilder:<init>	()V
    //   3943: ldc_w 576
    //   3946: invokevirtual 181	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3949: iload 18
    //   3951: invokevirtual 579	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   3954: invokevirtual 185	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3957: invokestatic 217	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   3960: iload 11
    //   3962: iconst_1
    //   3963: iadd
    //   3964: istore 6
    //   3966: iload 5
    //   3968: ifeq +141 -> 4109
    //   3971: ldc 244
    //   3973: iconst_1
    //   3974: new 176	java/lang/StringBuilder
    //   3977: dup
    //   3978: invokespecial 177	java/lang/StringBuilder:<init>	()V
    //   3981: ldc_w 581
    //   3984: invokevirtual 181	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3987: iload 5
    //   3989: invokevirtual 234	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   3992: ldc_w 583
    //   3995: invokevirtual 181	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3998: aload 39
    //   4000: invokevirtual 274	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   4003: ldc_w 497
    //   4006: invokevirtual 181	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4009: iload 6
    //   4011: invokevirtual 234	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   4014: ldc_w 450
    //   4017: invokevirtual 181	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4020: aload_3
    //   4021: invokevirtual 274	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   4024: ldc_w 585
    //   4027: invokevirtual 181	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4030: iload 17
    //   4032: invokevirtual 579	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   4035: ldc_w 587
    //   4038: invokevirtual 181	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4041: aload 43
    //   4043: invokevirtual 181	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4046: ldc_w 589
    //   4049: invokevirtual 181	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4052: iload 16
    //   4054: invokevirtual 234	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   4057: ldc_w 591
    //   4060: invokevirtual 181	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4063: getstatic 476	com/tencent/mobileqq/app/FaceDownloader:jdField_a_of_type_Boolean	Z
    //   4066: invokevirtual 579	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   4069: ldc_w 593
    //   4072: invokevirtual 181	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4075: iload 12
    //   4077: invokevirtual 234	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   4080: ldc_w 595
    //   4083: invokevirtual 181	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4086: aload 44
    //   4088: invokevirtual 181	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4091: ldc_w 597
    //   4094: invokevirtual 181	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4097: getstatic 26	com/tencent/mobileqq/app/FaceDownloader:e	I
    //   4100: invokevirtual 234	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   4103: invokevirtual 185	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   4106: invokestatic 217	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   4109: iload 5
    //   4111: ifeq +1786 -> 5897
    //   4114: iload 6
    //   4116: iconst_2
    //   4117: if_icmpge +1780 -> 5897
    //   4120: aload 38
    //   4122: monitorenter
    //   4123: aload 38
    //   4125: ldc2_w 598
    //   4128: invokevirtual 603	java/lang/Object:wait	(J)V
    //   4131: aload 38
    //   4133: monitorexit
    //   4134: aload 31
    //   4136: astore 34
    //   4138: aload_1
    //   4139: astore 32
    //   4141: goto -1504 -> 2637
    //   4144: lload 25
    //   4146: lstore 27
    //   4148: iload 17
    //   4150: istore 19
    //   4152: aload_1
    //   4153: astore 36
    //   4155: iload 5
    //   4157: istore 7
    //   4159: lload 25
    //   4161: lstore 29
    //   4163: iload 17
    //   4165: istore 20
    //   4167: aload_1
    //   4168: astore 37
    //   4170: iload 5
    //   4172: istore 8
    //   4174: aload 31
    //   4176: astore 34
    //   4178: iload 17
    //   4180: istore 18
    //   4182: aload_1
    //   4183: astore 33
    //   4185: iload 5
    //   4187: istore 6
    //   4189: aload 42
    //   4191: getfield 519	com/tencent/mobileqq/emoticon/DownloadInfo:c	I
    //   4194: istore 5
    //   4196: goto -468 -> 3728
    //   4199: astore_1
    //   4200: aload 38
    //   4202: monitorexit
    //   4203: aload_1
    //   4204: athrow
    //   4205: aload_3
    //   4206: getstatic 411	com/tencent/mobileqq/util/FaceInfo:o	I
    //   4209: invokevirtual 413	com/tencent/mobileqq/util/FaceInfo:a	(I)V
    //   4212: iload 5
    //   4214: i2l
    //   4215: lload 25
    //   4217: lcmp
    //   4218: ifne +206 -> 4424
    //   4221: aload_3
    //   4222: getstatic 618	com/tencent/mobileqq/util/FaceInfo:p	I
    //   4225: invokevirtual 413	com/tencent/mobileqq/util/FaceInfo:a	(I)V
    //   4228: aload 34
    //   4230: iconst_0
    //   4231: iload 5
    //   4233: invokestatic 623	com/tencent/mobileqq/util/BitmapManager:a	([BII)Landroid/graphics/Bitmap;
    //   4236: astore 33
    //   4238: aload 33
    //   4240: astore 31
    //   4242: aload 33
    //   4244: ifnull +79 -> 4323
    //   4247: aload_3
    //   4248: getfield 624	com/tencent/mobileqq/util/FaceInfo:c	I
    //   4251: tableswitch	default:+1720 -> 5971, 1:+566->4817, 2:+25->4276, 3:+573->4824
    //   4277: lload_3
    //   4278: bipush 50
    //   4280: bipush 50
    //   4282: invokestatic 629	com/tencent/mobileqq/utils/ImageUtil:c	(Landroid/graphics/Bitmap;II)Landroid/graphics/Bitmap;
    //   4285: astore 31
    //   4287: aload_0
    //   4288: getfield 87	com/tencent/mobileqq/app/FaceDownloader:jdField_a_of_type_ComTencentCommonAppAppInterface	Lcom/tencent/common/app/AppInterface;
    //   4291: sipush 215
    //   4294: invokevirtual 635	com/tencent/common/app/AppInterface:getManager	(I)Lmqq/manager/Manager;
    //   4297: checkcast 637	com/tencent/mobileqq/util/FaceManager
    //   4300: aload_3
    //   4301: invokevirtual 639	com/tencent/mobileqq/util/FaceInfo:a	()Ljava/lang/String;
    //   4304: aload 31
    //   4306: aload_3
    //   4307: getfield 640	com/tencent/mobileqq/util/FaceInfo:jdField_a_of_type_Int	I
    //   4310: invokestatic 643	com/tencent/mobileqq/util/FaceManager:a	(I)B
    //   4313: invokevirtual 646	com/tencent/mobileqq/util/FaceManager:a	(Ljava/lang/String;Landroid/graphics/Bitmap;B)V
    //   4316: aload_3
    //   4317: getstatic 649	com/tencent/mobileqq/util/FaceInfo:q	I
    //   4320: invokevirtual 413	com/tencent/mobileqq/util/FaceInfo:a	(I)V
    //   4323: invokestatic 209	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   4326: ifeq +51 -> 4377
    //   4329: ldc 244
    //   4331: iconst_2
    //   4332: new 176	java/lang/StringBuilder
    //   4335: dup
    //   4336: invokespecial 177	java/lang/StringBuilder:<init>	()V
    //   4339: ldc_w 651
    //   4342: invokevirtual 181	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4345: aload 31
    //   4347: invokevirtual 274	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   4350: ldc_w 583
    //   4353: invokevirtual 181	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4356: aload 39
    //   4358: invokevirtual 274	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   4361: ldc_w 450
    //   4364: invokevirtual 181	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4367: aload_3
    //   4368: invokevirtual 274	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   4371: invokevirtual 185	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   4374: invokestatic 217	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   4377: new 404	zkc
    //   4380: dup
    //   4381: aload_0
    //   4382: invokespecial 405	zkc:<init>	(Lcom/tencent/mobileqq/app/FaceDownloader;)V
    //   4385: astore 33
    //   4387: aload 33
    //   4389: aload_3
    //   4390: putfield 408	zkc:jdField_a_of_type_ComTencentMobileqqUtilFaceInfo	Lcom/tencent/mobileqq/util/FaceInfo;
    //   4393: aload 33
    //   4395: aload 31
    //   4397: putfield 416	zkc:jdField_a_of_type_AndroidGraphicsBitmap	Landroid/graphics/Bitmap;
    //   4400: aload_0
    //   4401: getfield 56	com/tencent/mobileqq/app/FaceDownloader:jdField_b_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   4404: aload 33
    //   4406: invokevirtual 419	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   4409: pop
    //   4410: aload_0
    //   4411: getfield 149	com/tencent/mobileqq/app/FaceDownloader:jdField_a_of_type_MqqOsMqqHandler	Lmqq/os/MqqHandler;
    //   4414: bipush 100
    //   4416: aload 33
    //   4418: invokevirtual 425	mqq/os/MqqHandler:obtainMessage	(ILjava/lang/Object;)Landroid/os/Message;
    //   4421: invokevirtual 430	android/os/Message:sendToTarget	()V
    //   4424: aload 32
    //   4426: aload 34
    //   4428: iconst_0
    //   4429: iload 5
    //   4431: invokevirtual 655	java/io/OutputStream:write	([BII)V
    //   4434: aload 32
    //   4436: invokevirtual 658	java/io/OutputStream:flush	()V
    //   4439: aload_2
    //   4440: invokevirtual 372	java/io/File:exists	()Z
    //   4443: ifeq +8 -> 4451
    //   4446: aload_2
    //   4447: invokevirtual 402	java/io/File:delete	()Z
    //   4450: pop
    //   4451: aload 40
    //   4453: aload_2
    //   4454: invokevirtual 662	java/io/File:renameTo	(Ljava/io/File;)Z
    //   4457: pop
    //   4458: aload_2
    //   4459: invokestatic 363	java/lang/System:currentTimeMillis	()J
    //   4462: invokevirtual 666	java/io/File:setLastModified	(J)Z
    //   4465: pop
    //   4466: iconst_0
    //   4467: istore 5
    //   4469: aload 32
    //   4471: astore 31
    //   4473: lload 25
    //   4475: lstore 27
    //   4477: iload 5
    //   4479: istore 7
    //   4481: aload_1
    //   4482: ifnull +7 -> 4489
    //   4485: aload_1
    //   4486: invokevirtual 569	java/net/HttpURLConnection:disconnect	()V
    //   4489: aload 31
    //   4491: ifnull +8 -> 4499
    //   4494: aload 31
    //   4496: invokevirtual 574	java/io/OutputStream:close	()V
    //   4499: iload 7
    //   4501: ifeq +76 -> 4577
    //   4504: aload 40
    //   4506: ifnull +71 -> 4577
    //   4509: aload 40
    //   4511: invokevirtual 369	java/io/File:getParentFile	()Ljava/io/File;
    //   4514: astore 32
    //   4516: aload 32
    //   4518: ifnull +17 -> 4535
    //   4521: aload 32
    //   4523: invokevirtual 372	java/io/File:exists	()Z
    //   4526: ifne +9 -> 4535
    //   4529: aload 32
    //   4531: invokevirtual 375	java/io/File:mkdirs	()Z
    //   4534: pop
    //   4535: aload 40
    //   4537: invokevirtual 372	java/io/File:exists	()Z
    //   4540: ifeq +37 -> 4577
    //   4543: aload 40
    //   4545: invokevirtual 402	java/io/File:delete	()Z
    //   4548: istore 18
    //   4550: ldc 244
    //   4552: iconst_1
    //   4553: new 176	java/lang/StringBuilder
    //   4556: dup
    //   4557: invokespecial 177	java/lang/StringBuilder:<init>	()V
    //   4560: ldc_w 576
    //   4563: invokevirtual 181	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4566: iload 18
    //   4568: invokevirtual 579	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   4571: invokevirtual 185	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   4574: invokestatic 217	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   4577: iload 11
    //   4579: iconst_1
    //   4580: iadd
    //   4581: istore 8
    //   4583: iload 7
    //   4585: ifeq +141 -> 4726
    //   4588: ldc 244
    //   4590: iconst_1
    //   4591: new 176	java/lang/StringBuilder
    //   4594: dup
    //   4595: invokespecial 177	java/lang/StringBuilder:<init>	()V
    //   4598: ldc_w 581
    //   4601: invokevirtual 181	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4604: iload 7
    //   4606: invokevirtual 234	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   4609: ldc_w 583
    //   4612: invokevirtual 181	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4615: aload 39
    //   4617: invokevirtual 274	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   4620: ldc_w 497
    //   4623: invokevirtual 181	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4626: iload 8
    //   4628: invokevirtual 234	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   4631: ldc_w 450
    //   4634: invokevirtual 181	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4637: aload_3
    //   4638: invokevirtual 274	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   4641: ldc_w 585
    //   4644: invokevirtual 181	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4647: iload 17
    //   4649: invokevirtual 579	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   4652: ldc_w 587
    //   4655: invokevirtual 181	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4658: aload 43
    //   4660: invokevirtual 181	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4663: ldc_w 589
    //   4666: invokevirtual 181	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4669: iload 16
    //   4671: invokevirtual 234	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   4674: ldc_w 591
    //   4677: invokevirtual 181	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4680: getstatic 476	com/tencent/mobileqq/app/FaceDownloader:jdField_a_of_type_Boolean	Z
    //   4683: invokevirtual 579	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   4686: ldc_w 593
    //   4689: invokevirtual 181	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4692: iload 12
    //   4694: invokevirtual 234	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   4697: ldc_w 595
    //   4700: invokevirtual 181	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4703: aload 44
    //   4705: invokevirtual 181	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4708: ldc_w 597
    //   4711: invokevirtual 181	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4714: getstatic 26	com/tencent/mobileqq/app/FaceDownloader:e	I
    //   4717: invokevirtual 234	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   4720: invokevirtual 185	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   4723: invokestatic 217	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   4726: iload 7
    //   4728: istore 5
    //   4730: iload 8
    //   4732: istore 6
    //   4734: lload 27
    //   4736: lstore 25
    //   4738: aload 31
    //   4740: astore 34
    //   4742: aload_1
    //   4743: astore 32
    //   4745: iload 7
    //   4747: ifeq -2110 -> 2637
    //   4750: iload 7
    //   4752: istore 5
    //   4754: iload 8
    //   4756: istore 6
    //   4758: lload 27
    //   4760: lstore 25
    //   4762: aload 31
    //   4764: astore 34
    //   4766: aload_1
    //   4767: astore 32
    //   4769: iload 8
    //   4771: iconst_2
    //   4772: if_icmpge -2135 -> 2637
    //   4775: aload 38
    //   4777: monitorenter
    //   4778: aload 38
    //   4780: ldc2_w 598
    //   4783: invokevirtual 603	java/lang/Object:wait	(J)V
    //   4786: aload 38
    //   4788: monitorexit
    //   4789: iload 7
    //   4791: istore 5
    //   4793: iload 8
    //   4795: istore 6
    //   4797: lload 27
    //   4799: lstore 25
    //   4801: aload 31
    //   4803: astore 34
    //   4805: aload_1
    //   4806: astore 32
    //   4808: goto -2171 -> 2637
    //   4811: astore_1
    //   4812: aload 38
    //   4814: monitorexit
    //   4815: aload_1
    //   4816: athrow
    //   4817: aload 33
    //   4819: astore 31
    //   4821: goto -534 -> 4287
    //   4824: aload 33
    //   4826: bipush 50
    //   4828: bipush 50
    //   4830: invokestatic 668	com/tencent/mobileqq/utils/ImageUtil:a	(Landroid/graphics/Bitmap;II)Landroid/graphics/Bitmap;
    //   4833: astore 31
    //   4835: goto -548 -> 4287
    //   4838: sipush 1024
    //   4841: newarray byte
    //   4843: astore 33
    //   4845: iload 15
    //   4847: istore 5
    //   4849: aload 31
    //   4851: aload 33
    //   4853: invokevirtual 671	java/io/InputStream:read	([B)I
    //   4856: istore 6
    //   4858: iload 6
    //   4860: iconst_m1
    //   4861: if_icmpeq +82 -> 4943
    //   4864: iload 5
    //   4866: iload 6
    //   4868: iadd
    //   4869: istore 5
    //   4871: aload 32
    //   4873: aload 33
    //   4875: iconst_0
    //   4876: iload 6
    //   4878: invokevirtual 655	java/io/OutputStream:write	([BII)V
    //   4881: goto -32 -> 4849
    //   4884: astore 31
    //   4886: aload 32
    //   4888: astore 31
    //   4890: ldc 244
    //   4892: iconst_1
    //   4893: new 176	java/lang/StringBuilder
    //   4896: dup
    //   4897: invokespecial 177	java/lang/StringBuilder:<init>	()V
    //   4900: ldc_w 673
    //   4903: invokevirtual 181	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4906: aload 40
    //   4908: invokevirtual 372	java/io/File:exists	()Z
    //   4911: invokevirtual 579	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   4914: ldc_w 675
    //   4917: invokevirtual 181	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4920: aload 40
    //   4922: invokevirtual 369	java/io/File:getParentFile	()Ljava/io/File;
    //   4925: invokevirtual 372	java/io/File:exists	()Z
    //   4928: invokevirtual 579	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   4931: invokevirtual 185	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   4934: invokestatic 217	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   4937: iconst_4
    //   4938: istore 5
    //   4940: goto -467 -> 4473
    //   4943: aload_3
    //   4944: getstatic 411	com/tencent/mobileqq/util/FaceInfo:o	I
    //   4947: invokevirtual 413	com/tencent/mobileqq/util/FaceInfo:a	(I)V
    //   4950: goto -516 -> 4434
    //   4953: astore 33
    //   4955: aload 32
    //   4957: astore 31
    //   4959: iconst_0
    //   4960: istore 5
    //   4962: aload 33
    //   4964: astore 32
    //   4966: goto -2669 -> 2297
    //   4969: lload 25
    //   4971: lstore 27
    //   4973: iload 17
    //   4975: istore 19
    //   4977: aload_1
    //   4978: astore 36
    //   4980: iload 5
    //   4982: istore 7
    //   4984: lload 25
    //   4986: lstore 29
    //   4988: iload 17
    //   4990: istore 20
    //   4992: aload_1
    //   4993: astore 37
    //   4995: iload 13
    //   4997: istore 8
    //   4999: aload 31
    //   5001: astore 34
    //   5003: iload 17
    //   5005: istore 18
    //   5007: aload_1
    //   5008: astore 33
    //   5010: iload 14
    //   5012: istore 6
    //   5014: aload 42
    //   5016: getfield 519	com/tencent/mobileqq/emoticon/DownloadInfo:c	I
    //   5019: istore 5
    //   5021: iload 5
    //   5023: istore 7
    //   5025: lload 25
    //   5027: lstore 27
    //   5029: goto -548 -> 4481
    //   5032: iload 5
    //   5034: istore 6
    //   5036: aload 32
    //   5038: instanceof 677
    //   5041: ifne +933 -> 5974
    //   5044: iload 5
    //   5046: istore 6
    //   5048: aload 32
    //   5050: instanceof 679
    //   5053: ifeq +6 -> 5059
    //   5056: goto +918 -> 5974
    //   5059: iload 5
    //   5061: istore 6
    //   5063: aload 32
    //   5065: instanceof 681
    //   5068: ifeq +10 -> 5078
    //   5071: bipush 11
    //   5073: istore 5
    //   5075: goto -2715 -> 2360
    //   5078: iload 5
    //   5080: istore 6
    //   5082: aload 32
    //   5084: instanceof 683
    //   5087: ifeq +10 -> 5097
    //   5090: bipush 8
    //   5092: istore 5
    //   5094: goto -2734 -> 2360
    //   5097: iload 5
    //   5099: istore 6
    //   5101: aload 32
    //   5103: instanceof 685
    //   5106: ifeq +10 -> 5116
    //   5109: bipush 17
    //   5111: istore 5
    //   5113: goto -2753 -> 2360
    //   5116: iload 5
    //   5118: istore 6
    //   5120: aload 32
    //   5122: instanceof 687
    //   5125: ifeq +10 -> 5135
    //   5128: bipush 18
    //   5130: istore 5
    //   5132: goto -2772 -> 2360
    //   5135: iload 5
    //   5137: istore 6
    //   5139: aload 32
    //   5141: instanceof 689
    //   5144: ifeq +10 -> 5154
    //   5147: bipush 19
    //   5149: istore 5
    //   5151: goto -2791 -> 2360
    //   5154: iload 5
    //   5156: istore 6
    //   5158: aload 32
    //   5160: invokevirtual 692	java/io/IOException:getMessage	()Ljava/lang/String;
    //   5163: astore 32
    //   5165: iload 5
    //   5167: istore 6
    //   5169: aload 32
    //   5171: ldc_w 694
    //   5174: invokevirtual 697	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   5177: ifne +803 -> 5980
    //   5180: iload 5
    //   5182: istore 6
    //   5184: aload 32
    //   5186: ldc_w 699
    //   5189: invokevirtual 697	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   5192: ifne +788 -> 5980
    //   5195: iload 5
    //   5197: istore 6
    //   5199: aload 32
    //   5201: ldc_w 701
    //   5204: invokevirtual 697	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   5207: ifeq +788 -> 5995
    //   5210: goto +770 -> 5980
    //   5213: iload 5
    //   5215: istore 6
    //   5217: invokestatic 705	com/tencent/mobileqq/util/SystemUtil:a	()Z
    //   5220: istore 18
    //   5222: iload 18
    //   5224: ifeq +170 -> 5394
    //   5227: iload 5
    //   5229: istore 6
    //   5231: invokestatic 707	com/tencent/mobileqq/util/SystemUtil:a	()J
    //   5234: lstore 27
    //   5236: iload 5
    //   5238: istore 6
    //   5240: new 176	java/lang/StringBuilder
    //   5243: dup
    //   5244: invokespecial 177	java/lang/StringBuilder:<init>	()V
    //   5247: ldc_w 709
    //   5250: invokevirtual 181	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5253: astore 33
    //   5255: iload 5
    //   5257: istore 6
    //   5259: aload 40
    //   5261: invokevirtual 372	java/io/File:exists	()Z
    //   5264: ifeq +737 -> 6001
    //   5267: iload 5
    //   5269: istore 6
    //   5271: aload 40
    //   5273: invokevirtual 712	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   5276: astore 32
    //   5278: iload 5
    //   5280: istore 6
    //   5282: aload 33
    //   5284: aload 32
    //   5286: invokevirtual 181	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5289: ldc_w 714
    //   5292: invokevirtual 181	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5295: astore 33
    //   5297: iload 5
    //   5299: istore 6
    //   5301: aload 40
    //   5303: invokevirtual 369	java/io/File:getParentFile	()Ljava/io/File;
    //   5306: ifnull +100 -> 5406
    //   5309: iload 5
    //   5311: istore 6
    //   5313: aload 40
    //   5315: invokevirtual 369	java/io/File:getParentFile	()Ljava/io/File;
    //   5318: invokevirtual 372	java/io/File:exists	()Z
    //   5321: ifeq +85 -> 5406
    //   5324: iload 5
    //   5326: istore 6
    //   5328: aload 40
    //   5330: invokevirtual 369	java/io/File:getParentFile	()Ljava/io/File;
    //   5333: invokevirtual 712	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   5336: astore 32
    //   5338: iload 5
    //   5340: istore 6
    //   5342: ldc 244
    //   5344: iconst_1
    //   5345: aload 33
    //   5347: aload 32
    //   5349: invokevirtual 181	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5352: ldc_w 716
    //   5355: invokevirtual 181	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5358: iload 5
    //   5360: invokevirtual 234	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   5363: ldc_w 718
    //   5366: invokevirtual 181	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5369: iload 18
    //   5371: invokevirtual 579	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   5374: ldc_w 720
    //   5377: invokevirtual 181	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5380: lload 27
    //   5382: invokevirtual 723	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   5385: invokevirtual 185	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   5388: invokestatic 217	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   5391: goto -3031 -> 2360
    //   5394: iload 5
    //   5396: istore 6
    //   5398: invokestatic 725	com/tencent/mobileqq/util/SystemUtil:b	()J
    //   5401: lstore 27
    //   5403: goto -167 -> 5236
    //   5406: ldc_w 727
    //   5409: astore 32
    //   5411: goto -73 -> 5338
    //   5414: astore_1
    //   5415: aload 38
    //   5417: monitorexit
    //   5418: aload_1
    //   5419: athrow
    //   5420: astore_1
    //   5421: aload 38
    //   5423: monitorexit
    //   5424: aload_1
    //   5425: athrow
    //   5426: iload 5
    //   5428: istore 6
    //   5430: lload 25
    //   5432: ldc2_w 549
    //   5435: lcmp
    //   5436: iflt -5405 -> 31
    //   5439: aload_3
    //   5440: getstatic 618	com/tencent/mobileqq/util/FaceInfo:p	I
    //   5443: invokevirtual 413	com/tencent/mobileqq/util/FaceInfo:a	(I)V
    //   5446: new 729	com/tencent/mobileqq/util/BitmapManager$BitmapDecodeResult
    //   5449: dup
    //   5450: invokespecial 730	com/tencent/mobileqq/util/BitmapManager$BitmapDecodeResult:<init>	()V
    //   5453: astore_2
    //   5454: new 732	android/graphics/BitmapFactory$Options
    //   5457: dup
    //   5458: invokespecial 733	android/graphics/BitmapFactory$Options:<init>	()V
    //   5461: astore 31
    //   5463: aload 31
    //   5465: getstatic 738	com/tencent/mobileqq/util/FaceConstant:a	Landroid/graphics/Bitmap$Config;
    //   5468: putfield 741	android/graphics/BitmapFactory$Options:inPreferredConfig	Landroid/graphics/Bitmap$Config;
    //   5471: aload_0
    //   5472: getfield 87	com/tencent/mobileqq/app/FaceDownloader:jdField_a_of_type_ComTencentCommonAppAppInterface	Lcom/tencent/common/app/AppInterface;
    //   5475: sipush 215
    //   5478: invokevirtual 635	com/tencent/common/app/AppInterface:getManager	(I)Lmqq/manager/Manager;
    //   5481: checkcast 637	com/tencent/mobileqq/util/FaceManager
    //   5484: astore 32
    //   5486: iconst_0
    //   5487: istore 6
    //   5489: aload 32
    //   5491: aload_3
    //   5492: invokevirtual 744	com/tencent/mobileqq/util/FaceManager:a	(Lcom/tencent/mobileqq/util/FaceInfo;)Ljava/lang/String;
    //   5495: aload 31
    //   5497: aload_2
    //   5498: invokestatic 747	com/tencent/mobileqq/util/BitmapManager:a	(Ljava/lang/String;Landroid/graphics/BitmapFactory$Options;Lcom/tencent/mobileqq/util/BitmapManager$BitmapDecodeResult;)V
    //   5501: aload_2
    //   5502: getfield 748	com/tencent/mobileqq/util/BitmapManager$BitmapDecodeResult:jdField_a_of_type_Int	I
    //   5505: iconst_1
    //   5506: if_icmpne +18 -> 5524
    //   5509: aload_0
    //   5510: getfield 87	com/tencent/mobileqq/app/FaceDownloader:jdField_a_of_type_ComTencentCommonAppAppInterface	Lcom/tencent/common/app/AppInterface;
    //   5513: checkcast 750	com/tencent/mobileqq/nearby/NearbyAppInterface
    //   5516: checkcast 750	com/tencent/mobileqq/nearby/NearbyAppInterface
    //   5519: astore 33
    //   5521: invokestatic 751	com/tencent/mobileqq/nearby/NearbyAppInterface:b	()V
    //   5524: iload 6
    //   5526: iconst_1
    //   5527: iadd
    //   5528: istore 6
    //   5530: iload 6
    //   5532: iconst_2
    //   5533: if_icmpge +11 -> 5544
    //   5536: aload_2
    //   5537: getfield 748	com/tencent/mobileqq/util/BitmapManager$BitmapDecodeResult:jdField_a_of_type_Int	I
    //   5540: iconst_1
    //   5541: if_icmpeq +353 -> 5894
    //   5544: aload_2
    //   5545: getfield 752	com/tencent/mobileqq/util/BitmapManager$BitmapDecodeResult:jdField_a_of_type_AndroidGraphicsBitmap	Landroid/graphics/Bitmap;
    //   5548: ifnull +67 -> 5615
    //   5551: aload_3
    //   5552: getfield 624	com/tencent/mobileqq/util/FaceInfo:c	I
    //   5555: tableswitch	default:+25 -> 5580, 1:+40->5595, 2:+25->5580, 3:+100->5655
    //   5581: aload_2
    //   5582: getfield 752	com/tencent/mobileqq/util/BitmapManager$BitmapDecodeResult:jdField_a_of_type_AndroidGraphicsBitmap	Landroid/graphics/Bitmap;
    //   5585: bipush 50
    //   5587: bipush 50
    //   5589: invokestatic 629	com/tencent/mobileqq/utils/ImageUtil:c	(Landroid/graphics/Bitmap;II)Landroid/graphics/Bitmap;
    //   5592: putfield 752	com/tencent/mobileqq/util/BitmapManager$BitmapDecodeResult:jdField_a_of_type_AndroidGraphicsBitmap	Landroid/graphics/Bitmap;
    //   5595: aload 32
    //   5597: aload_3
    //   5598: invokevirtual 639	com/tencent/mobileqq/util/FaceInfo:a	()Ljava/lang/String;
    //   5601: aload_2
    //   5602: getfield 752	com/tencent/mobileqq/util/BitmapManager$BitmapDecodeResult:jdField_a_of_type_AndroidGraphicsBitmap	Landroid/graphics/Bitmap;
    //   5605: aload_3
    //   5606: getfield 640	com/tencent/mobileqq/util/FaceInfo:jdField_a_of_type_Int	I
    //   5609: invokestatic 643	com/tencent/mobileqq/util/FaceManager:a	(I)B
    //   5612: invokevirtual 646	com/tencent/mobileqq/util/FaceManager:a	(Ljava/lang/String;Landroid/graphics/Bitmap;B)V
    //   5615: aload_3
    //   5616: getstatic 649	com/tencent/mobileqq/util/FaceInfo:q	I
    //   5619: invokevirtual 413	com/tencent/mobileqq/util/FaceInfo:a	(I)V
    //   5622: aload_1
    //   5623: aload_2
    //   5624: getfield 752	com/tencent/mobileqq/util/BitmapManager$BitmapDecodeResult:jdField_a_of_type_AndroidGraphicsBitmap	Landroid/graphics/Bitmap;
    //   5627: putfield 416	zkc:jdField_a_of_type_AndroidGraphicsBitmap	Landroid/graphics/Bitmap;
    //   5630: aload_0
    //   5631: getfield 56	com/tencent/mobileqq/app/FaceDownloader:jdField_b_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   5634: aload_1
    //   5635: invokevirtual 419	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   5638: pop
    //   5639: aload_0
    //   5640: getfield 149	com/tencent/mobileqq/app/FaceDownloader:jdField_a_of_type_MqqOsMqqHandler	Lmqq/os/MqqHandler;
    //   5643: bipush 100
    //   5645: aload_1
    //   5646: invokevirtual 425	mqq/os/MqqHandler:obtainMessage	(ILjava/lang/Object;)Landroid/os/Message;
    //   5649: invokevirtual 430	android/os/Message:sendToTarget	()V
    //   5652: iload 5
    //   5654: ireturn
    //   5655: aload_2
    //   5656: aload_2
    //   5657: getfield 752	com/tencent/mobileqq/util/BitmapManager$BitmapDecodeResult:jdField_a_of_type_AndroidGraphicsBitmap	Landroid/graphics/Bitmap;
    //   5660: bipush 50
    //   5662: bipush 50
    //   5664: invokestatic 668	com/tencent/mobileqq/utils/ImageUtil:a	(Landroid/graphics/Bitmap;II)Landroid/graphics/Bitmap;
    //   5667: putfield 752	com/tencent/mobileqq/util/BitmapManager$BitmapDecodeResult:jdField_a_of_type_AndroidGraphicsBitmap	Landroid/graphics/Bitmap;
    //   5670: goto -75 -> 5595
    //   5673: astore 32
    //   5675: goto -1793 -> 3882
    //   5678: astore 32
    //   5680: goto -1549 -> 4131
    //   5683: astore 32
    //   5685: goto -1186 -> 4499
    //   5688: astore 32
    //   5690: goto -904 -> 4786
    //   5693: astore 32
    //   5695: goto -3317 -> 2378
    //   5698: astore 32
    //   5700: goto -3073 -> 2627
    //   5703: astore 32
    //   5705: goto -2726 -> 2979
    //   5708: astore 32
    //   5710: goto -2479 -> 3231
    //   5713: astore_1
    //   5714: goto -2356 -> 3358
    //   5717: astore_1
    //   5718: goto -2115 -> 3603
    //   5721: astore_1
    //   5722: goto -2290 -> 3432
    //   5725: astore_2
    //   5726: aload 32
    //   5728: astore 31
    //   5730: iload 10
    //   5732: istore 5
    //   5734: goto -2394 -> 3340
    //   5737: astore_2
    //   5738: iload 10
    //   5740: istore 5
    //   5742: goto -2402 -> 3340
    //   5745: astore_2
    //   5746: iconst_1
    //   5747: istore 17
    //   5749: goto -2409 -> 3340
    //   5752: astore_2
    //   5753: goto -2413 -> 3340
    //   5756: astore_2
    //   5757: iload 8
    //   5759: istore 5
    //   5761: goto -2421 -> 3340
    //   5764: astore 32
    //   5766: goto -2714 -> 3052
    //   5769: astore 33
    //   5771: aload 32
    //   5773: astore 31
    //   5775: aload 33
    //   5777: astore 32
    //   5779: lload 25
    //   5781: lstore 27
    //   5783: iload 9
    //   5785: istore 5
    //   5787: goto -2883 -> 2904
    //   5790: astore 32
    //   5792: lload 25
    //   5794: lstore 27
    //   5796: iload 9
    //   5798: istore 5
    //   5800: goto -2896 -> 2904
    //   5803: astore 32
    //   5805: iconst_1
    //   5806: istore 17
    //   5808: lload 25
    //   5810: lstore 27
    //   5812: goto -2908 -> 2904
    //   5815: astore 32
    //   5817: lload 25
    //   5819: lstore 27
    //   5821: goto -2917 -> 2904
    //   5824: astore 32
    //   5826: iload 9
    //   5828: istore 5
    //   5830: lload 25
    //   5832: lstore 27
    //   5834: goto -2930 -> 2904
    //   5837: astore 32
    //   5839: goto -3383 -> 2456
    //   5842: astore 32
    //   5844: iconst_0
    //   5845: istore 5
    //   5847: goto -3550 -> 2297
    //   5850: astore 32
    //   5852: iconst_5
    //   5853: istore 5
    //   5855: iload 18
    //   5857: istore 17
    //   5859: goto -3562 -> 2297
    //   5862: astore 32
    //   5864: iconst_5
    //   5865: istore 5
    //   5867: goto -3570 -> 2297
    //   5870: astore 32
    //   5872: iload 10
    //   5874: istore 5
    //   5876: goto -3579 -> 2297
    //   5879: astore 32
    //   5881: goto -1304 -> 4577
    //   5884: astore 32
    //   5886: goto -996 -> 4890
    //   5889: astore 32
    //   5891: goto -1931 -> 3960
    //   5894: goto -405 -> 5489
    //   5897: aload 31
    //   5899: astore 34
    //   5901: aload_1
    //   5902: astore 32
    //   5904: goto -3267 -> 2637
    //   5907: iconst_5
    //   5908: istore 6
    //   5910: iload 9
    //   5912: istore 7
    //   5914: goto -2179 -> 3735
    //   5917: goto -4833 -> 1084
    //   5920: iconst_m1
    //   5921: istore 12
    //   5923: aconst_null
    //   5924: astore 32
    //   5926: goto -5418 -> 508
    //   5929: aload 33
    //   5931: astore 32
    //   5933: goto -5521 -> 412
    //   5936: aload 33
    //   5938: astore 35
    //   5940: goto -5476 -> 464
    //   5943: aload 35
    //   5945: astore 33
    //   5947: aload 34
    //   5949: astore 31
    //   5951: aload 32
    //   5953: astore_1
    //   5954: iload 6
    //   5956: istore 11
    //   5958: goto -5749 -> 209
    //   5961: aload 31
    //   5963: astore 34
    //   5965: aload_1
    //   5966: astore 32
    //   5968: goto -3331 -> 2637
    //   5971: goto -1695 -> 4276
    //   5974: iconst_2
    //   5975: istore 5
    //   5977: goto -3617 -> 2360
    //   5980: bipush 33
    //   5982: istore 5
    //   5984: goto -771 -> 5213
    //   5987: astore_2
    //   5988: iload 6
    //   5990: istore 5
    //   5992: goto -2652 -> 3340
    //   5995: iconst_4
    //   5996: istore 5
    //   5998: goto -785 -> 5213
    //   6001: ldc_w 727
    //   6004: astore 32
    //   6006: goto -728 -> 5278
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	6009	0	this	FaceDownloader
    //   0	6009	1	paramString	String
    //   0	6009	2	paramFile	java.io.File
    //   0	6009	3	paramFaceInfo	FaceInfo
    //   0	6009	4	paramBoolean	boolean
    //   201	5796	5	i	int
    //   29	5960	6	j	int
    //   528	5385	7	k	int
    //   543	5215	8	m	int
    //   1744	4167	9	n	int
    //   1750	4123	10	i1	int
    //   198	5759	11	i2	int
    //   506	5416	12	i3	int
    //   1741	3255	13	i4	int
    //   1747	3264	14	i5	int
    //   1861	2985	15	i6	int
    //   487	4183	16	i7	int
    //   477	5381	17	bool1	boolean
    //   551	5305	18	bool2	boolean
    //   521	4455	19	bool3	boolean
    //   536	4455	20	bool4	boolean
    //   468	2256	21	bool5	boolean
    //   471	2268	22	bool6	boolean
    //   474	2280	23	bool7	boolean
    //   957	3	24	bool8	boolean
    //   6	5825	25	l1	long
    //   517	5316	27	l2	long
    //   532	4455	29	l3	long
    //   61	4789	31	localObject1	Object
    //   4884	1	31	localFileNotFoundException1	java.io.FileNotFoundException
    //   4888	1074	31	localObject2	Object
    //   195	12	32	localObject3	Object
    //   298	1	32	localIllegalArgumentException	java.lang.IllegalArgumentException
    //   330	1894	32	localObject4	Object
    //   2280	65	32	localIOException1	java.io.IOException
    //   2393	318	32	localObject5	Object
    //   2783	102	32	localThrowable1	Throwable
    //   2887	67	32	localThrowable2	Throwable
    //   2989	2607	32	localObject6	Object
    //   5673	1	32	localIOException2	java.io.IOException
    //   5678	1	32	localInterruptedException1	java.lang.InterruptedException
    //   5683	1	32	localIOException3	java.io.IOException
    //   5688	1	32	localInterruptedException2	java.lang.InterruptedException
    //   5693	1	32	localIOException4	java.io.IOException
    //   5698	1	32	localInterruptedException3	java.lang.InterruptedException
    //   5703	1	32	localIOException5	java.io.IOException
    //   5708	19	32	localInterruptedException4	java.lang.InterruptedException
    //   5764	8	32	localException1	java.lang.Exception
    //   5777	1	32	localObject7	Object
    //   5790	1	32	localThrowable3	Throwable
    //   5803	1	32	localThrowable4	Throwable
    //   5815	1	32	localThrowable5	Throwable
    //   5824	1	32	localThrowable6	Throwable
    //   5837	1	32	localException2	java.lang.Exception
    //   5842	1	32	localIOException6	java.io.IOException
    //   5850	1	32	localIOException7	java.io.IOException
    //   5862	1	32	localIOException8	java.io.IOException
    //   5870	1	32	localIOException9	java.io.IOException
    //   5879	1	32	localException3	java.lang.Exception
    //   5884	1	32	localFileNotFoundException2	java.io.FileNotFoundException
    //   5889	1	32	localException4	java.lang.Exception
    //   5902	103	32	localObject8	Object
    //   204	4670	33	localObject9	Object
    //   4953	10	33	localIOException10	java.io.IOException
    //   5008	512	33	localObject10	Object
    //   5769	168	33	localThrowable7	Throwable
    //   5945	1	33	localObject11	Object
    //   219	5745	34	localObject12	Object
    //   462	5482	35	localObject13	Object
    //   524	4455	36	str1	String
    //   539	4455	37	str2	String
    //   55	5367	38	localObject14	Object
    //   42	4574	39	localURL	java.net.URL
    //   178	5151	40	localFile	java.io.File
    //   3	499	41	localNetworkInfo	android.net.NetworkInfo
    //   95	4920	42	localDownloadInfo	com.tencent.mobileqq.emoticon.DownloadInfo
    //   482	4177	43	str3	String
    //   513	4191	44	str4	String
    // Exception table:
    //   from	to	target	type
    //   34	44	119	java/net/MalformedURLException
    //   57	63	127	java/lang/Exception
    //   68	82	127	java/lang/Exception
    //   139	148	298	java/lang/IllegalArgumentException
    //   300	305	308	java/lang/IllegalArgumentException
    //   560	571	2280	java/io/IOException
    //   622	633	2280	java/io/IOException
    //   678	682	2280	java/io/IOException
    //   727	732	2280	java/io/IOException
    //   783	794	2280	java/io/IOException
    //   839	850	2280	java/io/IOException
    //   895	899	2280	java/io/IOException
    //   954	959	2280	java/io/IOException
    //   1129	1139	2280	java/io/IOException
    //   1184	1191	2280	java/io/IOException
    //   1236	1243	2280	java/io/IOException
    //   1288	1293	2280	java/io/IOException
    //   1323	1327	2280	java/io/IOException
    //   1357	1366	2280	java/io/IOException
    //   1396	1405	2280	java/io/IOException
    //   1435	1444	2280	java/io/IOException
    //   1474	1483	2280	java/io/IOException
    //   1513	1525	2280	java/io/IOException
    //   1555	1564	2280	java/io/IOException
    //   1609	1617	2280	java/io/IOException
    //   1662	1689	2280	java/io/IOException
    //   1734	1740	2280	java/io/IOException
    //   1800	1811	2280	java/io/IOException
    //   1856	1863	2280	java/io/IOException
    //   1916	1924	2280	java/io/IOException
    //   1969	1975	2280	java/io/IOException
    //   2020	2026	2280	java/io/IOException
    //   2071	2089	2280	java/io/IOException
    //   2273	2277	2280	java/io/IOException
    //   2764	2780	2280	java/io/IOException
    //   2835	2839	2280	java/io/IOException
    //   2884	2887	2280	java/io/IOException
    //   3317	3321	2280	java/io/IOException
    //   3656	3664	2280	java/io/IOException
    //   3709	3716	2280	java/io/IOException
    //   4189	4196	2280	java/io/IOException
    //   5014	5021	2280	java/io/IOException
    //   1323	1327	2783	java/lang/Throwable
    //   1357	1366	2783	java/lang/Throwable
    //   1396	1405	2783	java/lang/Throwable
    //   1435	1444	2783	java/lang/Throwable
    //   1474	1483	2783	java/lang/Throwable
    //   1513	1525	2783	java/lang/Throwable
    //   1555	1564	2783	java/lang/Throwable
    //   560	571	2887	java/lang/Throwable
    //   622	633	2887	java/lang/Throwable
    //   678	682	2887	java/lang/Throwable
    //   727	732	2887	java/lang/Throwable
    //   783	794	2887	java/lang/Throwable
    //   839	850	2887	java/lang/Throwable
    //   895	899	2887	java/lang/Throwable
    //   954	959	2887	java/lang/Throwable
    //   1129	1139	2887	java/lang/Throwable
    //   1184	1191	2887	java/lang/Throwable
    //   1236	1243	2887	java/lang/Throwable
    //   1288	1293	2887	java/lang/Throwable
    //   1609	1617	2887	java/lang/Throwable
    //   1662	1689	2887	java/lang/Throwable
    //   1734	1740	2887	java/lang/Throwable
    //   1800	1811	2887	java/lang/Throwable
    //   1856	1863	2887	java/lang/Throwable
    //   1916	1924	2887	java/lang/Throwable
    //   1969	1975	2887	java/lang/Throwable
    //   2020	2026	2887	java/lang/Throwable
    //   2071	2089	2887	java/lang/Throwable
    //   2273	2277	2887	java/lang/Throwable
    //   2764	2780	2887	java/lang/Throwable
    //   2835	2839	2887	java/lang/Throwable
    //   2884	2887	2887	java/lang/Throwable
    //   3317	3321	2887	java/lang/Throwable
    //   3656	3664	2887	java/lang/Throwable
    //   3709	3716	2887	java/lang/Throwable
    //   4189	4196	2887	java/lang/Throwable
    //   5014	5021	2887	java/lang/Throwable
    //   3223	3231	3256	finally
    //   3231	3234	3256	finally
    //   3257	3260	3256	finally
    //   560	571	3324	finally
    //   622	633	3324	finally
    //   678	682	3324	finally
    //   727	732	3324	finally
    //   783	794	3324	finally
    //   839	850	3324	finally
    //   895	899	3324	finally
    //   954	959	3324	finally
    //   1129	1139	3324	finally
    //   1184	1191	3324	finally
    //   1236	1243	3324	finally
    //   1288	1293	3324	finally
    //   1323	1327	3324	finally
    //   1357	1366	3324	finally
    //   1396	1405	3324	finally
    //   1435	1444	3324	finally
    //   1474	1483	3324	finally
    //   1513	1525	3324	finally
    //   1555	1564	3324	finally
    //   1609	1617	3324	finally
    //   1662	1689	3324	finally
    //   1734	1740	3324	finally
    //   1800	1811	3324	finally
    //   1856	1863	3324	finally
    //   1916	1924	3324	finally
    //   1969	1975	3324	finally
    //   2020	2026	3324	finally
    //   2071	2089	3324	finally
    //   2273	2277	3324	finally
    //   2764	2780	3324	finally
    //   2835	2839	3324	finally
    //   2884	2887	3324	finally
    //   2919	2958	3324	finally
    //   3317	3321	3324	finally
    //   3656	3664	3324	finally
    //   3709	3716	3324	finally
    //   4189	4196	3324	finally
    //   5014	5021	3324	finally
    //   4123	4131	4199	finally
    //   4131	4134	4199	finally
    //   4200	4203	4199	finally
    //   4778	4786	4811	finally
    //   4786	4789	4811	finally
    //   4812	4815	4811	finally
    //   2089	2095	4884	java/io/FileNotFoundException
    //   2109	2116	4884	java/io/FileNotFoundException
    //   2122	2136	4884	java/io/FileNotFoundException
    //   4205	4212	4884	java/io/FileNotFoundException
    //   4221	4238	4884	java/io/FileNotFoundException
    //   4247	4276	4884	java/io/FileNotFoundException
    //   4276	4287	4884	java/io/FileNotFoundException
    //   4287	4323	4884	java/io/FileNotFoundException
    //   4323	4377	4884	java/io/FileNotFoundException
    //   4377	4424	4884	java/io/FileNotFoundException
    //   4424	4434	4884	java/io/FileNotFoundException
    //   4434	4451	4884	java/io/FileNotFoundException
    //   4451	4466	4884	java/io/FileNotFoundException
    //   4824	4835	4884	java/io/FileNotFoundException
    //   4838	4845	4884	java/io/FileNotFoundException
    //   4849	4858	4884	java/io/FileNotFoundException
    //   4871	4881	4884	java/io/FileNotFoundException
    //   4943	4950	4884	java/io/FileNotFoundException
    //   2089	2095	4953	java/io/IOException
    //   2109	2116	4953	java/io/IOException
    //   2122	2136	4953	java/io/IOException
    //   4205	4212	4953	java/io/IOException
    //   4221	4238	4953	java/io/IOException
    //   4247	4276	4953	java/io/IOException
    //   4276	4287	4953	java/io/IOException
    //   4287	4323	4953	java/io/IOException
    //   4323	4377	4953	java/io/IOException
    //   4377	4424	4953	java/io/IOException
    //   4424	4434	4953	java/io/IOException
    //   4434	4451	4953	java/io/IOException
    //   4451	4466	4953	java/io/IOException
    //   4824	4835	4953	java/io/IOException
    //   4838	4845	4953	java/io/IOException
    //   4849	4858	4953	java/io/IOException
    //   4871	4881	4953	java/io/IOException
    //   4943	4950	4953	java/io/IOException
    //   2619	2627	5414	finally
    //   2627	2630	5414	finally
    //   5415	5418	5414	finally
    //   3595	3603	5420	finally
    //   3603	3606	5420	finally
    //   5421	5424	5420	finally
    //   3877	3882	5673	java/io/IOException
    //   4123	4131	5678	java/lang/InterruptedException
    //   4494	4499	5683	java/io/IOException
    //   4778	4786	5688	java/lang/InterruptedException
    //   2373	2378	5693	java/io/IOException
    //   2619	2627	5698	java/lang/InterruptedException
    //   2974	2979	5703	java/io/IOException
    //   3223	3231	5708	java/lang/InterruptedException
    //   3353	3358	5713	java/io/IOException
    //   3595	3603	5717	java/lang/InterruptedException
    //   3368	3374	5721	java/lang/Exception
    //   3378	3390	5721	java/lang/Exception
    //   3390	3432	5721	java/lang/Exception
    //   2089	2095	5725	finally
    //   2109	2116	5725	finally
    //   2122	2136	5725	finally
    //   4205	4212	5725	finally
    //   4221	4238	5725	finally
    //   4247	4276	5725	finally
    //   4276	4287	5725	finally
    //   4287	4323	5725	finally
    //   4323	4377	5725	finally
    //   4377	4424	5725	finally
    //   4424	4434	5725	finally
    //   4434	4451	5725	finally
    //   4451	4466	5725	finally
    //   4824	4835	5725	finally
    //   4838	4845	5725	finally
    //   4849	4858	5725	finally
    //   4871	4881	5725	finally
    //   4943	4950	5725	finally
    //   4890	4937	5737	finally
    //   970	1003	5745	finally
    //   1009	1033	5745	finally
    //   2651	2662	5745	finally
    //   2668	2690	5745	finally
    //   2699	2710	5745	finally
    //   1039	1084	5752	finally
    //   3755	3768	5756	finally
    //   3788	3796	5756	finally
    //   3816	3834	5756	finally
    //   3858	3864	5756	finally
    //   2984	2991	5764	java/lang/Exception
    //   2996	3010	5764	java/lang/Exception
    //   3010	3052	5764	java/lang/Exception
    //   2089	2095	5769	java/lang/Throwable
    //   2109	2116	5769	java/lang/Throwable
    //   2122	2136	5769	java/lang/Throwable
    //   4205	4212	5769	java/lang/Throwable
    //   4221	4238	5769	java/lang/Throwable
    //   4247	4276	5769	java/lang/Throwable
    //   4276	4287	5769	java/lang/Throwable
    //   4287	4323	5769	java/lang/Throwable
    //   4323	4377	5769	java/lang/Throwable
    //   4377	4424	5769	java/lang/Throwable
    //   4424	4434	5769	java/lang/Throwable
    //   4434	4451	5769	java/lang/Throwable
    //   4451	4466	5769	java/lang/Throwable
    //   4824	4835	5769	java/lang/Throwable
    //   4838	4845	5769	java/lang/Throwable
    //   4849	4858	5769	java/lang/Throwable
    //   4871	4881	5769	java/lang/Throwable
    //   4943	4950	5769	java/lang/Throwable
    //   4890	4937	5790	java/lang/Throwable
    //   970	1003	5803	java/lang/Throwable
    //   1009	1033	5803	java/lang/Throwable
    //   2651	2662	5803	java/lang/Throwable
    //   2668	2690	5803	java/lang/Throwable
    //   2699	2710	5803	java/lang/Throwable
    //   1039	1084	5815	java/lang/Throwable
    //   3755	3768	5824	java/lang/Throwable
    //   3788	3796	5824	java/lang/Throwable
    //   3816	3834	5824	java/lang/Throwable
    //   3858	3864	5824	java/lang/Throwable
    //   2388	2395	5837	java/lang/Exception
    //   2400	2414	5837	java/lang/Exception
    //   2414	2456	5837	java/lang/Exception
    //   4890	4937	5842	java/io/IOException
    //   970	1003	5850	java/io/IOException
    //   1009	1033	5850	java/io/IOException
    //   2651	2662	5850	java/io/IOException
    //   2668	2690	5850	java/io/IOException
    //   2699	2710	5850	java/io/IOException
    //   1039	1084	5862	java/io/IOException
    //   3755	3768	5870	java/io/IOException
    //   3788	3796	5870	java/io/IOException
    //   3816	3834	5870	java/io/IOException
    //   3858	3864	5870	java/io/IOException
    //   4509	4516	5879	java/lang/Exception
    //   4521	4535	5879	java/lang/Exception
    //   4535	4577	5879	java/lang/Exception
    //   1916	1924	5884	java/io/FileNotFoundException
    //   1969	1975	5884	java/io/FileNotFoundException
    //   2020	2026	5884	java/io/FileNotFoundException
    //   2071	2089	5884	java/io/FileNotFoundException
    //   3892	3899	5889	java/lang/Exception
    //   3904	3918	5889	java/lang/Exception
    //   3918	3960	5889	java/lang/Exception
    //   2301	2340	5987	finally
    //   2344	2351	5987	finally
    //   5036	5044	5987	finally
    //   5048	5056	5987	finally
    //   5063	5071	5987	finally
    //   5082	5090	5987	finally
    //   5101	5109	5987	finally
    //   5120	5128	5987	finally
    //   5139	5147	5987	finally
    //   5158	5165	5987	finally
    //   5169	5180	5987	finally
    //   5184	5195	5987	finally
    //   5199	5210	5987	finally
    //   5217	5222	5987	finally
    //   5231	5236	5987	finally
    //   5240	5255	5987	finally
    //   5259	5267	5987	finally
    //   5271	5278	5987	finally
    //   5282	5297	5987	finally
    //   5301	5309	5987	finally
    //   5313	5324	5987	finally
    //   5328	5338	5987	finally
    //   5342	5391	5987	finally
    //   5398	5403	5987	finally
  }
  
  public FaceDownloader.FaceDownloadThreadInfo a()
  {
    FaceDownloader.FaceDownloadThreadInfo localFaceDownloadThreadInfo = new FaceDownloader.FaceDownloadThreadInfo(this);
    int i = Runtime.getRuntime().availableProcessors();
    if (QLog.isColorLevel()) {
      QLog.i("Q.qqhead.FaceDownloader", 2, "processor count:" + i);
    }
    if (i >= 4) {}
    do
    {
      return localFaceDownloadThreadInfo;
      localFaceDownloadThreadInfo.jdField_a_of_type_Int = (i + 1);
    } while (i > 2);
    localFaceDownloadThreadInfo.jdField_b_of_type_Int = 10;
    return localFaceDownloadThreadInfo;
  }
  
  public String a(String paramString, byte paramByte1, byte paramByte2, int paramInt)
  {
    String str1 = "q.qlogo.cn";
    StringBuilder localStringBuilder;
    if (paramByte2 == 32) {
      if (paramInt == 1)
      {
        str1 = "q.qlogo.cn";
        String str2 = InnerDns.a().a(str1, 1003);
        if (QLog.isColorLevel()) {
          QLog.i("InnerDns", 2, "getQQHeandDownLoadUrl.choosedIp=" + str2);
        }
        localStringBuilder = new StringBuilder("http://");
        if (TextUtils.isEmpty(str2)) {
          break label225;
        }
        localStringBuilder.append(str2);
        label93:
        int i = paramString.indexOf("/", 8);
        str1 = paramString;
        if (i > 8)
        {
          localStringBuilder.append(paramString.substring(i));
          str1 = localStringBuilder.toString();
        }
        if (paramByte2 != 32) {
          break label243;
        }
        if (paramInt != 1) {
          break label236;
        }
        paramByte2 = a(paramByte1);
      }
    }
    for (;;)
    {
      return str1 + paramByte2;
      if (paramInt != 32) {
        break;
      }
      str1 = "p.qlogo.cn";
      break;
      if (paramByte2 == 16)
      {
        str1 = "p.qlogo.cn";
        break;
      }
      if ((paramByte2 == 4) || (paramByte2 == 8))
      {
        str1 = "p.qlogo.cn";
        break;
      }
      str1 = "q.qlogo.cn";
      break;
      label225:
      localStringBuilder.append(str1);
      break label93;
      label236:
      paramByte2 = 140;
      continue;
      label243:
      if (paramByte2 == 16) {
        paramByte2 = 224;
      } else {
        paramByte2 = a(paramByte1);
      }
    }
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_JavaUtilHashSet != null) {
      this.jdField_a_of_type_JavaUtilHashSet.clear();
    }
    int i = 0;
    while (i < this.jdField_a_of_type_ArrayOfZkb.length)
    {
      if (this.jdField_a_of_type_ArrayOfZkb[i] != null) {
        this.jdField_a_of_type_ArrayOfZkb[i].a();
      }
      i += 1;
    }
    if (this.jdField_a_of_type_JavaUtilArrayList != null) {
      synchronized (this.jdField_a_of_type_JavaUtilArrayList)
      {
        this.jdField_a_of_type_JavaUtilArrayList.clear();
        this.jdField_a_of_type_JavaUtilArrayList.notifyAll();
        return;
      }
    }
  }
  
  public void a(int paramInt)
  {
    int k = this.jdField_a_of_type_JavaUtilArrayList.size();
    if ((paramInt == this.jdField_a_of_type_Int) && (this.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicInteger.get() < this.jdField_a_of_type_Int) && (this.jdField_a_of_type_JavaUtilArrayList.size() >= this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.get()))
    {
      int j = this.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicInteger.get() + this.jdField_a_of_type_JavaUtilArrayList.size() - this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.get() + 1;
      int i = j;
      if (j <= 0) {
        i = 1;
      }
      if (i < this.jdField_a_of_type_Int) {}
      for (;;)
      {
        try
        {
          arrayOfThread = this.jdField_a_of_type_ArrayOfJavaLangThread;
          j = 0;
          if (j >= i) {
            break;
          }
        }
        catch (OutOfMemoryError localOutOfMemoryError)
        {
          Thread[] arrayOfThread;
          if (!QLog.isColorLevel()) {
            continue;
          }
          QLog.e("Q.qqhead.FaceDownloader", 2, "smartSetThreadCount", localOutOfMemoryError);
          continue;
        }
        try
        {
          if (this.jdField_a_of_type_ArrayOfJavaLangThread[j] == null)
          {
            this.jdField_a_of_type_ArrayOfZkb[j] = new zkb(this, j);
            this.jdField_a_of_type_ArrayOfJavaLangThread[j] = ThreadManager.newFreeThread(this.jdField_a_of_type_ArrayOfZkb[j], "FaceDownloadThread", 5);
            this.jdField_a_of_type_ArrayOfJavaLangThread[j].start();
            this.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicInteger.incrementAndGet();
          }
          j += 1;
          continue;
        }
        finally {}
        i = this.jdField_a_of_type_Int;
      }
    }
    if ((this.jdField_a_of_type_ArrayOfZkb == null) || (this.jdField_a_of_type_ArrayOfZkb.length <= 0) || (this.jdField_a_of_type_ArrayOfZkb[0] == null)) {
      QLog.e("Q.qqhead.FaceDownloader", 2, "smartSetThreadCount fail, MAX_THREAD_COUNT=" + this.jdField_a_of_type_Int + ",newThreadCount=" + paramInt + ",currThreadCount=" + this.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicInteger + ",idleThreadCount=" + this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger + ",queueSize=" + k);
    }
  }
  
  public void a(FaceDownloader.FaceDownloadListener paramFaceDownloadListener)
  {
    try
    {
      if (QLog.isColorLevel()) {
        QLog.i("Q.qqhead.FaceDownloader", 2, "addFaceDownloadListener l=" + paramFaceDownloadListener);
      }
      this.jdField_a_of_type_JavaUtilLinkedList.add(paramFaceDownloadListener);
      return;
    }
    finally {}
  }
  
  public void a(FaceInfo paramFaceInfo)
  {
    a(this.jdField_a_of_type_Int);
    if (QLog.isColorLevel()) {
      QLog.d("Q.qqhead.FaceDownloader", 2, "addDownloadRequest, info=" + paramFaceInfo);
    }
    HashSet localHashSet = this.jdField_a_of_type_JavaUtilHashSet;
    if (paramFaceInfo != null) {}
    for (;;)
    {
      try
      {
        ??? = paramFaceInfo.c();
        if ((TextUtils.isEmpty((CharSequence)???)) || (this.jdField_a_of_type_JavaUtilHashSet.contains(???)))
        {
          if (QLog.isColorLevel()) {
            QLog.d("Q.qqhead.FaceDownloader", 2, "addDownloadRequest url repeat, info=" + paramFaceInfo + ",urlUniq=" + (String)???);
          }
          return;
        }
        this.jdField_a_of_type_JavaUtilHashSet.add(???);
        synchronized (this.jdField_a_of_type_JavaUtilArrayList)
        {
          this.jdField_a_of_type_JavaUtilArrayList.add(paramFaceInfo);
          this.jdField_a_of_type_JavaUtilArrayList.notify();
          return;
        }
        ??? = "";
      }
      finally {}
    }
  }
  
  public void b(FaceDownloader.FaceDownloadListener paramFaceDownloadListener)
  {
    try
    {
      if (QLog.isColorLevel()) {
        QLog.i("Q.qqhead.FaceDownloader", 2, "removeFaceDownloadListener l=" + paramFaceDownloadListener);
      }
      this.jdField_a_of_type_JavaUtilLinkedList.remove(paramFaceDownloadListener);
      return;
    }
    finally {}
  }
  
  public abstract void b(FaceInfo paramFaceInfo);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.app.FaceDownloader
 * JD-Core Version:    0.7.0.1
 */