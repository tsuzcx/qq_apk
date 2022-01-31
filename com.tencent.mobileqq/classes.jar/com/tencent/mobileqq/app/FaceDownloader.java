package com.tencent.mobileqq.app;

import ajhr;
import ajhs;
import ajht;
import ajhu;
import ajtd;
import android.content.Context;
import android.content.res.Resources;
import android.os.Looper;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import axwx;
import badq;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.util.FaceInfo;
import com.tencent.qphone.base.util.QLog;
import java.net.HttpURLConnection;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import mqq.os.MqqHandler;

public abstract class FaceDownloader
{
  private static String jdField_a_of_type_JavaLangString;
  private static boolean jdField_a_of_type_Boolean;
  private static int e = 1;
  protected byte a;
  public int a;
  private ajht jdField_a_of_type_Ajht;
  protected AppInterface a;
  protected ArrayList<FaceInfo> a;
  protected HashSet<String> a;
  public LinkedList<ajhs> a;
  protected AtomicInteger a;
  protected MqqHandler a;
  private FaceDownloader.FaceDownloadRunnable[] jdField_a_of_type_ArrayOfComTencentMobileqqAppFaceDownloader$FaceDownloadRunnable;
  private Thread[] jdField_a_of_type_ArrayOfJavaLangThread;
  protected int b;
  public ArrayList<ajhu> b;
  protected AtomicInteger b;
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
    if (this.jdField_a_of_type_Ajht.jdField_a_of_type_Int != -2147483648) {
      this.jdField_a_of_type_Int = this.jdField_a_of_type_Ajht.jdField_a_of_type_Int;
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
    this.jdField_a_of_type_ArrayOfComTencentMobileqqAppFaceDownloader$FaceDownloadRunnable = new FaceDownloader.FaceDownloadRunnable[this.jdField_a_of_type_Int];
    int i = 0;
    for (;;)
    {
      if (i < this.jdField_a_of_type_ArrayOfJavaLangThread.length)
      {
        this.jdField_a_of_type_ArrayOfComTencentMobileqqAppFaceDownloader$FaceDownloadRunnable[i] = new FaceDownloader.FaceDownloadRunnable(this, i);
        this.jdField_a_of_type_ArrayOfJavaLangThread[i] = ThreadManager.newFreeThread(this.jdField_a_of_type_ArrayOfComTencentMobileqqAppFaceDownloader$FaceDownloadRunnable[i], "FaceDownloadThread", 5);
        if (ajtd.a().c()) {
          this.jdField_a_of_type_ArrayOfJavaLangThread[i].setPriority(1);
        }
        try
        {
          this.jdField_a_of_type_ArrayOfJavaLangThread[i].start();
          i += 1;
        }
        catch (OutOfMemoryError paramAppInterface)
        {
          for (;;)
          {
            QLog.e("Q.qqhead.FaceDownloader", 1, "FaceDownloader() error, ", paramAppInterface);
          }
        }
      }
    }
    this.jdField_b_of_type_Int = a();
    switch (this.jdField_b_of_type_Int)
    {
    }
    for (;;)
    {
      this.jdField_a_of_type_MqqOsMqqHandler = new ajhr(this, Looper.getMainLooper());
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
    paramInt = badq.a(BaseApplicationImpl.getApplication().getApplicationContext());
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
    String str = axwx.a().a("q.qlogo.cn", 1003);
    if (QLog.isColorLevel()) {
      QLog.i("InnerDns", 2, "get1080QQHeadDownLoadUrl.choosedIp=" + str);
    }
    StringBuilder localStringBuilder = new StringBuilder("http://");
    if (!TextUtils.isEmpty(str))
    {
      localStringBuilder.append(str);
      int i = paramString.indexOf("/", 8);
      str = paramString;
      if (i > 8)
      {
        localStringBuilder.append(paramString.substring(i));
        str = localStringBuilder.toString();
      }
      if ((paramByte & 0x20) == 0) {
        break label141;
      }
      paramByte = 0;
    }
    for (;;)
    {
      return str + paramByte;
      localStringBuilder.append("q.qlogo.cn");
      break;
      label141:
      if ((paramByte & 0x10) != 0) {
        paramByte = 640;
      } else if ((paramByte & 0x8) != 0) {
        paramByte = 140;
      } else if ((paramByte & 0x4) != 0) {
        paramByte = 100;
      } else {
        paramByte = 40;
      }
    }
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
      for (this.jdField_a_of_type_Ajht = a(); QLog.isColorLevel(); this.jdField_a_of_type_Ajht = new ajht(this))
      {
        QLog.i("Q.qqhead.FaceDownloader", 2, "initFaceDownloadThreadInfo, maxThreadCount=" + this.jdField_a_of_type_Ajht.jdField_a_of_type_Int + ",priority=" + this.jdField_a_of_type_Ajht.jdField_b_of_type_Int);
        return;
      }
    }
  }
  
  private void c()
  {
    ThreadManager.post(new FaceDownloader.2(this), 5, null, true);
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
    //   0: invokestatic 363	com/tencent/mobileqq/msf/sdk/AppNetConnInfo:getRecentNetworkInfo	()Landroid/net/NetworkInfo;
    //   3: astore 41
    //   5: lconst_0
    //   6: lstore 25
    //   8: aload 41
    //   10: ifnonnull +24 -> 34
    //   13: invokestatic 222	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   16: ifeq +12 -> 28
    //   19: ldc 139
    //   21: iconst_2
    //   22: ldc_w 365
    //   25: invokestatic 230	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   28: iconst_1
    //   29: istore 6
    //   31: iload 6
    //   33: ireturn
    //   34: new 367	java/net/URL
    //   37: dup
    //   38: aload_1
    //   39: invokespecial 368	java/net/URL:<init>	(Ljava/lang/String;)V
    //   42: astore 39
    //   44: invokestatic 374	java/lang/System:currentTimeMillis	()J
    //   47: pop2
    //   48: new 4	java/lang/Object
    //   51: dup
    //   52: invokespecial 37	java/lang/Object:<init>	()V
    //   55: astore 38
    //   57: aload_2
    //   58: invokevirtual 380	java/io/File:getParentFile	()Ljava/io/File;
    //   61: astore 31
    //   63: aload 31
    //   65: ifnull +17 -> 82
    //   68: aload 31
    //   70: invokevirtual 383	java/io/File:exists	()Z
    //   73: ifne +9 -> 82
    //   76: aload 31
    //   78: invokevirtual 386	java/io/File:mkdirs	()Z
    //   81: pop
    //   82: aconst_null
    //   83: astore 31
    //   85: new 388	anff
    //   88: dup
    //   89: aload_1
    //   90: aconst_null
    //   91: iconst_0
    //   92: invokespecial 391	anff:<init>	(Ljava/lang/String;Ljava/io/File;I)V
    //   95: astore 42
    //   97: aload 41
    //   99: ifnonnull +40 -> 139
    //   102: ldc 139
    //   104: iconst_1
    //   105: ldc_w 393
    //   108: invokestatic 230	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   111: aload 42
    //   113: iconst_1
    //   114: putfield 394	anff:jdField_b_of_type_Int	I
    //   117: iconst_1
    //   118: ireturn
    //   119: astore_1
    //   120: aload_1
    //   121: invokevirtual 397	java/net/MalformedURLException:printStackTrace	()V
    //   124: bipush 13
    //   126: ireturn
    //   127: astore_1
    //   128: ldc 139
    //   130: iconst_1
    //   131: ldc_w 399
    //   134: invokestatic 401	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   137: iconst_4
    //   138: ireturn
    //   139: new 403	org/apache/http/client/methods/HttpGet
    //   142: dup
    //   143: aload_1
    //   144: invokespecial 404	org/apache/http/client/methods/HttpGet:<init>	(Ljava/lang/String;)V
    //   147: pop
    //   148: new 376	java/io/File
    //   151: dup
    //   152: new 191	java/lang/StringBuilder
    //   155: dup
    //   156: invokespecial 192	java/lang/StringBuilder:<init>	()V
    //   159: aload_2
    //   160: invokevirtual 407	java/io/File:getPath	()Ljava/lang/String;
    //   163: invokevirtual 196	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   166: ldc_w 409
    //   169: invokevirtual 196	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   172: invokevirtual 200	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   175: invokespecial 410	java/io/File:<init>	(Ljava/lang/String;)V
    //   178: astore 40
    //   180: aload 40
    //   182: invokevirtual 383	java/io/File:exists	()Z
    //   185: ifeq +9 -> 194
    //   188: aload 40
    //   190: invokevirtual 413	java/io/File:delete	()Z
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
    //   212: if_icmpeq +5788 -> 6000
    //   215: aload_3
    //   216: getfield 255	com/tencent/mobileqq/util/FaceInfo:jdField_a_of_type_AvatarInfoQQHeadInfo	LAvatarInfo/QQHeadInfo;
    //   219: astore 34
    //   221: aload 34
    //   223: ifnonnull +105 -> 328
    //   226: aload 42
    //   228: iload 5
    //   230: putfield 394	anff:jdField_b_of_type_Int	I
    //   233: iload 5
    //   235: istore 6
    //   237: iload 4
    //   239: ifeq -208 -> 31
    //   242: new 415	ajhu
    //   245: dup
    //   246: aload_0
    //   247: invokespecial 416	ajhu:<init>	(Lcom/tencent/mobileqq/app/FaceDownloader;)V
    //   250: astore_1
    //   251: aload_1
    //   252: aload_3
    //   253: putfield 419	ajhu:jdField_a_of_type_ComTencentMobileqqUtilFaceInfo	Lcom/tencent/mobileqq/util/FaceInfo;
    //   256: iload 5
    //   258: ifeq +5191 -> 5449
    //   261: aload_3
    //   262: getstatic 422	com/tencent/mobileqq/util/FaceInfo:o	I
    //   265: invokevirtual 424	com/tencent/mobileqq/util/FaceInfo:a	(I)V
    //   268: aload_1
    //   269: aconst_null
    //   270: putfield 427	ajhu:jdField_a_of_type_AndroidGraphicsBitmap	Landroid/graphics/Bitmap;
    //   273: aload_0
    //   274: getfield 62	com/tencent/mobileqq/app/FaceDownloader:jdField_b_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   277: aload_1
    //   278: invokevirtual 430	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   281: pop
    //   282: aload_0
    //   283: getfield 164	com/tencent/mobileqq/app/FaceDownloader:jdField_a_of_type_MqqOsMqqHandler	Lmqq/os/MqqHandler;
    //   286: bipush 100
    //   288: aload_1
    //   289: invokevirtual 436	mqq/os/MqqHandler:obtainMessage	(ILjava/lang/Object;)Landroid/os/Message;
    //   292: invokevirtual 441	android/os/Message:sendToTarget	()V
    //   295: iload 5
    //   297: ireturn
    //   298: astore 32
    //   300: aload_1
    //   301: invokestatic 445	com/tencent/mobileqq/utils/HttpDownloadUtil:a	(Ljava/lang/String;)Ljava/lang/String;
    //   304: astore_1
    //   305: goto -157 -> 148
    //   308: astore_1
    //   309: ldc 139
    //   311: iconst_1
    //   312: ldc_w 447
    //   315: invokestatic 401	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   318: aload 42
    //   320: bipush 13
    //   322: putfield 394	anff:jdField_b_of_type_Int	I
    //   325: bipush 13
    //   327: ireturn
    //   328: ldc 216
    //   330: astore 32
    //   332: aload 34
    //   334: getfield 452	AvatarInfo/QQHeadInfo:dstUsrType	B
    //   337: bipush 32
    //   339: if_icmpne +1838 -> 2177
    //   342: aload 34
    //   344: getfield 455	AvatarInfo/QQHeadInfo:originUsrType	I
    //   347: iconst_1
    //   348: if_icmpne +1811 -> 2159
    //   351: ldc 216
    //   353: astore 32
    //   355: new 191	java/lang/StringBuilder
    //   358: dup
    //   359: ldc 232
    //   361: invokespecial 235	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   364: astore 34
    //   366: aload 34
    //   368: aload 32
    //   370: invokevirtual 196	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   373: pop
    //   374: aload 33
    //   376: ldc 237
    //   378: bipush 8
    //   380: invokevirtual 241	java/lang/String:indexOf	(Ljava/lang/String;I)I
    //   383: istore 5
    //   385: iload 5
    //   387: bipush 8
    //   389: if_icmple +5604 -> 5993
    //   392: aload 34
    //   394: aload 33
    //   396: iload 5
    //   398: invokevirtual 244	java/lang/String:substring	(I)Ljava/lang/String;
    //   401: invokevirtual 196	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   404: pop
    //   405: aload 34
    //   407: invokevirtual 200	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   410: astore 32
    //   412: ldc 139
    //   414: iconst_1
    //   415: new 191	java/lang/StringBuilder
    //   418: dup
    //   419: invokespecial 192	java/lang/StringBuilder:<init>	()V
    //   422: ldc_w 457
    //   425: invokevirtual 196	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   428: iload 11
    //   430: invokevirtual 247	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   433: ldc_w 459
    //   436: invokevirtual 196	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   439: aload 32
    //   441: invokevirtual 196	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   444: ldc_w 461
    //   447: invokevirtual 196	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   450: aload_3
    //   451: invokevirtual 285	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   454: invokevirtual 200	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   457: invokestatic 401	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
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
    //   479: invokestatic 466	android/net/Proxy:getDefaultHost	()Ljava/lang/String;
    //   482: astore 43
    //   484: invokestatic 469	android/net/Proxy:getDefaultPort	()I
    //   487: istore 16
    //   489: aload 41
    //   491: ifnull +5493 -> 5984
    //   494: aload 41
    //   496: invokevirtual 474	android/net/NetworkInfo:getExtraInfo	()Ljava/lang/String;
    //   499: astore 32
    //   501: aload 41
    //   503: invokevirtual 477	android/net/NetworkInfo:getType	()I
    //   506: istore 12
    //   508: aload 32
    //   510: invokestatic 481	bakz:b	(Ljava/lang/String;)Ljava/lang/String;
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
    //   562: getstatic 483	com/tencent/mobileqq/app/FaceDownloader:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   565: invokevirtual 91	java/lang/String:equals	(Ljava/lang/Object;)Z
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
    //   624: getstatic 485	bakz:d	Ljava/lang/String;
    //   627: invokevirtual 91	java/lang/String:equals	(Ljava/lang/Object;)Z
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
    //   679: putstatic 487	com/tencent/mobileqq/app/FaceDownloader:jdField_a_of_type_Boolean	Z
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
    //   729: putstatic 483	com/tencent/mobileqq/app/FaceDownloader:jdField_a_of_type_JavaLangString	Ljava/lang/String;
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
    //   783: ldc_w 489
    //   786: aload 43
    //   788: invokevirtual 91	java/lang/String:equals	(Ljava/lang/Object;)Z
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
    //   839: ldc_w 491
    //   842: aload 43
    //   844: invokevirtual 91	java/lang/String:equals	(Ljava/lang/Object;)Z
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
    //   896: putstatic 487	com/tencent/mobileqq/app/FaceDownloader:jdField_a_of_type_Boolean	Z
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
    //   954: getstatic 487	com/tencent/mobileqq/app/FaceDownloader:jdField_a_of_type_Boolean	Z
    //   957: istore 24
    //   959: iload 24
    //   961: ifne +1758 -> 2719
    //   964: iconst_1
    //   965: istore 18
    //   967: iconst_1
    //   968: istore 17
    //   970: aload 44
    //   972: getstatic 485	bakz:d	Ljava/lang/String;
    //   975: invokevirtual 91	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   978: ifne +25 -> 1003
    //   981: aload 44
    //   983: getstatic 494	bakz:f	Ljava/lang/String;
    //   986: invokevirtual 91	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   989: ifne +14 -> 1003
    //   992: aload 44
    //   994: getstatic 497	bakz:h	Ljava/lang/String;
    //   997: invokevirtual 91	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1000: ifeq +1668 -> 2668
    //   1003: iload 11
    //   1005: iconst_m1
    //   1006: if_icmpne +1645 -> 2651
    //   1009: getstatic 30	com/tencent/mobileqq/app/FaceDownloader:e	I
    //   1012: iconst_1
    //   1013: if_icmpne +1638 -> 2651
    //   1016: new 367	java/net/URL
    //   1019: dup
    //   1020: aload 35
    //   1022: invokespecial 368	java/net/URL:<init>	(Ljava/lang/String;)V
    //   1025: invokevirtual 501	java/net/URL:openConnection	()Ljava/net/URLConnection;
    //   1028: checkcast 259	java/net/HttpURLConnection
    //   1031: astore 32
    //   1033: iconst_0
    //   1034: istore 17
    //   1036: aload 32
    //   1038: astore_1
    //   1039: invokestatic 504	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   1042: ifeq +4939 -> 5981
    //   1045: ldc 139
    //   1047: iconst_4
    //   1048: new 191	java/lang/StringBuilder
    //   1051: dup
    //   1052: invokespecial 192	java/lang/StringBuilder:<init>	()V
    //   1055: ldc_w 506
    //   1058: invokevirtual 196	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1061: getstatic 30	com/tencent/mobileqq/app/FaceDownloader:e	I
    //   1064: invokevirtual 247	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1067: ldc_w 508
    //   1070: invokevirtual 196	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1073: iload 11
    //   1075: invokevirtual 247	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1078: invokevirtual 200	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1081: invokestatic 230	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
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
    //   1130: ldc_w 510
    //   1133: ldc_w 512
    //   1136: invokevirtual 516	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
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
    //   1188: invokevirtual 519	java/net/HttpURLConnection:setConnectTimeout	(I)V
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
    //   1240: invokevirtual 522	java/net/HttpURLConnection:setReadTimeout	(I)V
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
    //   1290: invokevirtual 526	java/net/HttpURLConnection:setInstanceFollowRedirects	(Z)V
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
    //   1324: invokevirtual 529	java/net/HttpURLConnection:connect	()V
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
    //   1360: invokevirtual 262	java/net/HttpURLConnection:getResponseCode	()I
    //   1363: putfield 530	anff:c	I
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
    //   1399: invokevirtual 270	java/net/HttpURLConnection:getContentLength	()I
    //   1402: putfield 531	anff:e	I
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
    //   1438: invokevirtual 267	java/net/HttpURLConnection:getContentType	()Ljava/lang/String;
    //   1441: putfield 532	anff:h	Ljava/lang/String;
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
    //   1477: invokevirtual 535	java/net/HttpURLConnection:getContentEncoding	()Ljava/lang/String;
    //   1480: putfield 537	anff:i	Ljava/lang/String;
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
    //   1516: ldc_w 282
    //   1519: invokevirtual 276	java/net/HttpURLConnection:getHeaderField	(Ljava/lang/String;)Ljava/lang/String;
    //   1522: putfield 538	anff:f	Ljava/lang/String;
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
    //   1556: ldc_w 278
    //   1559: invokevirtual 276	java/net/HttpURLConnection:getHeaderField	(Ljava/lang/String;)Ljava/lang/String;
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
    //   1611: invokestatic 83	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
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
    //   1662: ldc 139
    //   1664: iconst_1
    //   1665: new 191	java/lang/StringBuilder
    //   1668: dup
    //   1669: invokespecial 192	java/lang/StringBuilder:<init>	()V
    //   1672: ldc_w 540
    //   1675: invokevirtual 196	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1678: aload 32
    //   1680: invokevirtual 196	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1683: invokevirtual 200	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1686: invokestatic 230	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
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
    //   1737: invokespecial 542	com/tencent/mobileqq/app/FaceDownloader:a	(Ljava/net/HttpURLConnection;Lcom/tencent/mobileqq/util/FaceInfo;)V
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
    //   1805: getfield 530	anff:c	I
    //   1808: if_icmpne +3184 -> 4992
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
    //   1858: getfield 531	anff:e	I
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
    //   1918: invokevirtual 383	java/io/File:exists	()Z
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
    //   1971: invokevirtual 413	java/io/File:delete	()Z
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
    //   2022: invokevirtual 545	java/io/File:createNewFile	()Z
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
    //   2071: new 547	java/io/BufferedOutputStream
    //   2074: dup
    //   2075: new 549	java/io/FileOutputStream
    //   2078: dup
    //   2079: aload 40
    //   2081: invokespecial 552	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   2084: invokespecial 555	java/io/BufferedOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   2087: astore 32
    //   2089: aload_1
    //   2090: invokevirtual 559	java/net/HttpURLConnection:getInputStream	()Ljava/io/InputStream;
    //   2093: astore 31
    //   2095: iload 4
    //   2097: ifeq +2764 -> 4861
    //   2100: lload 25
    //   2102: ldc2_w 560
    //   2105: lcmp
    //   2106: ifge +2755 -> 4861
    //   2109: ldc_w 562
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
    //   2131: invokevirtual 568	java/io/InputStream:read	([BII)I
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
    //   2161: getfield 455	AvatarInfo/QQHeadInfo:originUsrType	I
    //   2164: bipush 32
    //   2166: if_icmpne -1811 -> 355
    //   2169: ldc_w 570
    //   2172: astore 32
    //   2174: goto -1819 -> 355
    //   2177: aload 34
    //   2179: getfield 452	AvatarInfo/QQHeadInfo:dstUsrType	B
    //   2182: bipush 16
    //   2184: if_icmpne +10 -> 2194
    //   2187: ldc 216
    //   2189: astore 32
    //   2191: goto -1836 -> 355
    //   2194: aload 34
    //   2196: getfield 452	AvatarInfo/QQHeadInfo:dstUsrType	B
    //   2199: iconst_4
    //   2200: if_icmpeq +13 -> 2213
    //   2203: aload 34
    //   2205: getfield 452	AvatarInfo/QQHeadInfo:dstUsrType	B
    //   2208: bipush 8
    //   2210: if_icmpne +11 -> 2221
    //   2213: ldc_w 570
    //   2216: astore 32
    //   2218: goto -1863 -> 355
    //   2221: ldc 216
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
    //   2274: putstatic 487	com/tencent/mobileqq/app/FaceDownloader:jdField_a_of_type_Boolean	Z
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
    //   2301: ldc 139
    //   2303: iconst_1
    //   2304: new 191	java/lang/StringBuilder
    //   2307: dup
    //   2308: invokespecial 192	java/lang/StringBuilder:<init>	()V
    //   2311: ldc_w 572
    //   2314: invokevirtual 196	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2317: aload 39
    //   2319: invokevirtual 285	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   2322: ldc_w 461
    //   2325: invokevirtual 196	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2328: aload_3
    //   2329: invokevirtual 285	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   2332: invokevirtual 200	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2335: aload 32
    //   2337: invokestatic 574	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   2340: iload 5
    //   2342: istore 6
    //   2344: aload 32
    //   2346: instanceof 576
    //   2349: istore 18
    //   2351: iload 18
    //   2353: ifeq +2702 -> 5055
    //   2356: bipush 10
    //   2358: istore 5
    //   2360: aload_1
    //   2361: ifnull +7 -> 2368
    //   2364: aload_1
    //   2365: invokevirtual 579	java/net/HttpURLConnection:disconnect	()V
    //   2368: aload 31
    //   2370: ifnull +8 -> 2378
    //   2373: aload 31
    //   2375: invokevirtual 584	java/io/OutputStream:close	()V
    //   2378: iload 5
    //   2380: ifeq +76 -> 2456
    //   2383: aload 40
    //   2385: ifnull +71 -> 2456
    //   2388: aload 40
    //   2390: invokevirtual 380	java/io/File:getParentFile	()Ljava/io/File;
    //   2393: astore 32
    //   2395: aload 32
    //   2397: ifnull +17 -> 2414
    //   2400: aload 32
    //   2402: invokevirtual 383	java/io/File:exists	()Z
    //   2405: ifne +9 -> 2414
    //   2408: aload 32
    //   2410: invokevirtual 386	java/io/File:mkdirs	()Z
    //   2413: pop
    //   2414: aload 40
    //   2416: invokevirtual 383	java/io/File:exists	()Z
    //   2419: ifeq +37 -> 2456
    //   2422: aload 40
    //   2424: invokevirtual 413	java/io/File:delete	()Z
    //   2427: istore 18
    //   2429: ldc 139
    //   2431: iconst_1
    //   2432: new 191	java/lang/StringBuilder
    //   2435: dup
    //   2436: invokespecial 192	java/lang/StringBuilder:<init>	()V
    //   2439: ldc_w 586
    //   2442: invokevirtual 196	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2445: iload 18
    //   2447: invokevirtual 589	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   2450: invokevirtual 200	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2453: invokestatic 230	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   2456: iload 11
    //   2458: iconst_1
    //   2459: iadd
    //   2460: istore 6
    //   2462: iload 5
    //   2464: ifeq +141 -> 2605
    //   2467: ldc 139
    //   2469: iconst_1
    //   2470: new 191	java/lang/StringBuilder
    //   2473: dup
    //   2474: invokespecial 192	java/lang/StringBuilder:<init>	()V
    //   2477: ldc_w 591
    //   2480: invokevirtual 196	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2483: iload 5
    //   2485: invokevirtual 247	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   2488: ldc_w 593
    //   2491: invokevirtual 196	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2494: aload 39
    //   2496: invokevirtual 285	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   2499: ldc_w 508
    //   2502: invokevirtual 196	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2505: iload 6
    //   2507: invokevirtual 247	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   2510: ldc_w 461
    //   2513: invokevirtual 196	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2516: aload_3
    //   2517: invokevirtual 285	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   2520: ldc_w 595
    //   2523: invokevirtual 196	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2526: iload 17
    //   2528: invokevirtual 589	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   2531: ldc_w 597
    //   2534: invokevirtual 196	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2537: aload 43
    //   2539: invokevirtual 196	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2542: ldc_w 599
    //   2545: invokevirtual 196	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2548: iload 16
    //   2550: invokevirtual 247	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   2553: ldc_w 601
    //   2556: invokevirtual 196	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2559: getstatic 487	com/tencent/mobileqq/app/FaceDownloader:jdField_a_of_type_Boolean	Z
    //   2562: invokevirtual 589	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   2565: ldc_w 603
    //   2568: invokevirtual 196	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2571: iload 12
    //   2573: invokevirtual 247	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   2576: ldc_w 605
    //   2579: invokevirtual 196	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2582: aload 44
    //   2584: invokevirtual 196	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2587: ldc_w 607
    //   2590: invokevirtual 196	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2593: getstatic 30	com/tencent/mobileqq/app/FaceDownloader:e	I
    //   2596: invokevirtual 247	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   2599: invokevirtual 200	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2602: invokestatic 230	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   2605: iload 5
    //   2607: ifeq +3418 -> 6025
    //   2610: iload 6
    //   2612: iconst_2
    //   2613: if_icmpge +3412 -> 6025
    //   2616: aload 38
    //   2618: monitorenter
    //   2619: aload 38
    //   2621: ldc2_w 608
    //   2624: invokevirtual 613	java/lang/Object:wait	(J)V
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
    //   2645: if_icmplt +3362 -> 6007
    //   2648: goto -2422 -> 226
    //   2651: aload 35
    //   2653: aload 43
    //   2655: iload 16
    //   2657: invokestatic 616	bakz:b	(Ljava/lang/String;Ljava/lang/String;I)Ljava/net/HttpURLConnection;
    //   2660: astore 32
    //   2662: aload 32
    //   2664: astore_1
    //   2665: goto -1626 -> 1039
    //   2668: aload 44
    //   2670: getstatic 618	bakz:b	Ljava/lang/String;
    //   2673: invokevirtual 91	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   2676: ifeq +23 -> 2699
    //   2679: aload 35
    //   2681: aload 43
    //   2683: iload 16
    //   2685: invokestatic 620	bakz:a	(Ljava/lang/String;Ljava/lang/String;I)Ljava/net/HttpURLConnection;
    //   2688: astore 32
    //   2690: iconst_1
    //   2691: istore 17
    //   2693: aload 32
    //   2695: astore_1
    //   2696: goto -1612 -> 1084
    //   2699: aload 35
    //   2701: aload 43
    //   2703: iload 16
    //   2705: invokestatic 620	bakz:a	(Ljava/lang/String;Ljava/lang/String;I)Ljava/net/HttpURLConnection;
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
    //   2764: new 367	java/net/URL
    //   2767: dup
    //   2768: aload 35
    //   2770: invokespecial 368	java/net/URL:<init>	(Ljava/lang/String;)V
    //   2773: invokevirtual 501	java/net/URL:openConnection	()Ljava/net/URLConnection;
    //   2776: checkcast 259	java/net/HttpURLConnection
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
    //   2836: putstatic 487	com/tencent/mobileqq/app/FaceDownloader:jdField_a_of_type_Boolean	Z
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
    //   2919: ldc 139
    //   2921: iconst_1
    //   2922: new 191	java/lang/StringBuilder
    //   2925: dup
    //   2926: invokespecial 192	java/lang/StringBuilder:<init>	()V
    //   2929: ldc_w 622
    //   2932: invokevirtual 196	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2935: aload 39
    //   2937: invokevirtual 285	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   2940: ldc_w 461
    //   2943: invokevirtual 196	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2946: aload_3
    //   2947: invokevirtual 285	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   2950: invokevirtual 200	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2953: aload 32
    //   2955: invokestatic 574	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   2958: iconst_5
    //   2959: istore 7
    //   2961: aload_1
    //   2962: ifnull +7 -> 2969
    //   2965: aload_1
    //   2966: invokevirtual 579	java/net/HttpURLConnection:disconnect	()V
    //   2969: aload 31
    //   2971: ifnull +8 -> 2979
    //   2974: aload 31
    //   2976: invokevirtual 584	java/io/OutputStream:close	()V
    //   2979: aload 40
    //   2981: ifnull +71 -> 3052
    //   2984: aload 40
    //   2986: invokevirtual 380	java/io/File:getParentFile	()Ljava/io/File;
    //   2989: astore 32
    //   2991: aload 32
    //   2993: ifnull +17 -> 3010
    //   2996: aload 32
    //   2998: invokevirtual 383	java/io/File:exists	()Z
    //   3001: ifne +9 -> 3010
    //   3004: aload 32
    //   3006: invokevirtual 386	java/io/File:mkdirs	()Z
    //   3009: pop
    //   3010: aload 40
    //   3012: invokevirtual 383	java/io/File:exists	()Z
    //   3015: ifeq +37 -> 3052
    //   3018: aload 40
    //   3020: invokevirtual 413	java/io/File:delete	()Z
    //   3023: istore 18
    //   3025: ldc 139
    //   3027: iconst_1
    //   3028: new 191	java/lang/StringBuilder
    //   3031: dup
    //   3032: invokespecial 192	java/lang/StringBuilder:<init>	()V
    //   3035: ldc_w 586
    //   3038: invokevirtual 196	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3041: iload 18
    //   3043: invokevirtual 589	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   3046: invokevirtual 200	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3049: invokestatic 230	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   3052: iload 11
    //   3054: iconst_1
    //   3055: iadd
    //   3056: istore 8
    //   3058: ldc 139
    //   3060: iconst_1
    //   3061: new 191	java/lang/StringBuilder
    //   3064: dup
    //   3065: invokespecial 192	java/lang/StringBuilder:<init>	()V
    //   3068: ldc_w 591
    //   3071: invokevirtual 196	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3074: iconst_5
    //   3075: invokevirtual 247	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   3078: ldc_w 593
    //   3081: invokevirtual 196	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3084: aload 39
    //   3086: invokevirtual 285	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   3089: ldc_w 508
    //   3092: invokevirtual 196	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3095: iload 8
    //   3097: invokevirtual 247	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   3100: ldc_w 461
    //   3103: invokevirtual 196	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3106: aload_3
    //   3107: invokevirtual 285	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   3110: ldc_w 595
    //   3113: invokevirtual 196	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3116: iload 17
    //   3118: invokevirtual 589	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   3121: ldc_w 597
    //   3124: invokevirtual 196	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3127: aload 43
    //   3129: invokevirtual 196	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3132: ldc_w 599
    //   3135: invokevirtual 196	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3138: iload 16
    //   3140: invokevirtual 247	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   3143: ldc_w 601
    //   3146: invokevirtual 196	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3149: getstatic 487	com/tencent/mobileqq/app/FaceDownloader:jdField_a_of_type_Boolean	Z
    //   3152: invokevirtual 589	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   3155: ldc_w 603
    //   3158: invokevirtual 196	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3161: iload 12
    //   3163: invokevirtual 247	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   3166: ldc_w 605
    //   3169: invokevirtual 196	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3172: aload 44
    //   3174: invokevirtual 196	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3177: ldc_w 607
    //   3180: invokevirtual 196	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3183: getstatic 30	com/tencent/mobileqq/app/FaceDownloader:e	I
    //   3186: invokevirtual 247	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   3189: invokevirtual 200	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3192: invokestatic 230	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
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
    //   3225: ldc2_w 608
    //   3228: invokevirtual 613	java/lang/Object:wait	(J)V
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
    //   3318: putstatic 487	com/tencent/mobileqq/app/FaceDownloader:jdField_a_of_type_Boolean	Z
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
    //   3345: invokevirtual 579	java/net/HttpURLConnection:disconnect	()V
    //   3348: aload 31
    //   3350: ifnull +8 -> 3358
    //   3353: aload 31
    //   3355: invokevirtual 584	java/io/OutputStream:close	()V
    //   3358: iload 5
    //   3360: ifeq +72 -> 3432
    //   3363: aload 40
    //   3365: ifnull +67 -> 3432
    //   3368: aload 40
    //   3370: invokevirtual 380	java/io/File:getParentFile	()Ljava/io/File;
    //   3373: astore_1
    //   3374: aload_1
    //   3375: ifnull +15 -> 3390
    //   3378: aload_1
    //   3379: invokevirtual 383	java/io/File:exists	()Z
    //   3382: ifne +8 -> 3390
    //   3385: aload_1
    //   3386: invokevirtual 386	java/io/File:mkdirs	()Z
    //   3389: pop
    //   3390: aload 40
    //   3392: invokevirtual 383	java/io/File:exists	()Z
    //   3395: ifeq +37 -> 3432
    //   3398: aload 40
    //   3400: invokevirtual 413	java/io/File:delete	()Z
    //   3403: istore 4
    //   3405: ldc 139
    //   3407: iconst_1
    //   3408: new 191	java/lang/StringBuilder
    //   3411: dup
    //   3412: invokespecial 192	java/lang/StringBuilder:<init>	()V
    //   3415: ldc_w 586
    //   3418: invokevirtual 196	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3421: iload 4
    //   3423: invokevirtual 589	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   3426: invokevirtual 200	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3429: invokestatic 230	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   3432: iload 11
    //   3434: iconst_1
    //   3435: iadd
    //   3436: istore 6
    //   3438: iload 5
    //   3440: ifeq +141 -> 3581
    //   3443: ldc 139
    //   3445: iconst_1
    //   3446: new 191	java/lang/StringBuilder
    //   3449: dup
    //   3450: invokespecial 192	java/lang/StringBuilder:<init>	()V
    //   3453: ldc_w 591
    //   3456: invokevirtual 196	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3459: iload 5
    //   3461: invokevirtual 247	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   3464: ldc_w 593
    //   3467: invokevirtual 196	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3470: aload 39
    //   3472: invokevirtual 285	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   3475: ldc_w 508
    //   3478: invokevirtual 196	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3481: iload 6
    //   3483: invokevirtual 247	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   3486: ldc_w 461
    //   3489: invokevirtual 196	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3492: aload_3
    //   3493: invokevirtual 285	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   3496: ldc_w 595
    //   3499: invokevirtual 196	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3502: iload 17
    //   3504: invokevirtual 589	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   3507: ldc_w 597
    //   3510: invokevirtual 196	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3513: aload 43
    //   3515: invokevirtual 196	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3518: ldc_w 599
    //   3521: invokevirtual 196	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3524: iload 16
    //   3526: invokevirtual 247	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   3529: ldc_w 601
    //   3532: invokevirtual 196	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3535: getstatic 487	com/tencent/mobileqq/app/FaceDownloader:jdField_a_of_type_Boolean	Z
    //   3538: invokevirtual 589	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   3541: ldc_w 603
    //   3544: invokevirtual 196	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3547: iload 12
    //   3549: invokevirtual 247	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   3552: ldc_w 605
    //   3555: invokevirtual 196	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3558: aload 44
    //   3560: invokevirtual 196	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3563: ldc_w 607
    //   3566: invokevirtual 196	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3569: getstatic 30	com/tencent/mobileqq/app/FaceDownloader:e	I
    //   3572: invokevirtual 247	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   3575: invokevirtual 200	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3578: invokestatic 230	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   3581: iload 5
    //   3583: ifeq +23 -> 3606
    //   3586: iload 6
    //   3588: iconst_2
    //   3589: if_icmpge +17 -> 3606
    //   3592: aload 38
    //   3594: monitorenter
    //   3595: aload 38
    //   3597: ldc2_w 608
    //   3600: invokevirtual 613	java/lang/Object:wait	(J)V
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
    //   3658: getfield 538	anff:f	Ljava/lang/String;
    //   3661: ifnonnull +2310 -> 5971
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
    //   3711: getfield 530	anff:c	I
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
    //   3756: getfield 255	com/tencent/mobileqq/util/FaceInfo:jdField_a_of_type_AvatarInfoQQHeadInfo	LAvatarInfo/QQHeadInfo;
    //   3759: getfield 625	AvatarInfo/QQHeadInfo:headVerify	Ljava/lang/String;
    //   3762: invokestatic 83	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
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
    //   3790: getfield 538	anff:f	Ljava/lang/String;
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
    //   3818: getfield 538	anff:f	Ljava/lang/String;
    //   3821: aload_3
    //   3822: getfield 255	com/tencent/mobileqq/util/FaceInfo:jdField_a_of_type_AvatarInfoQQHeadInfo	LAvatarInfo/QQHeadInfo;
    //   3825: getfield 625	AvatarInfo/QQHeadInfo:headVerify	Ljava/lang/String;
    //   3828: invokevirtual 91	java/lang/String:equals	(Ljava/lang/Object;)Z
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
    //   3861: invokespecial 542	com/tencent/mobileqq/app/FaceDownloader:a	(Ljava/net/HttpURLConnection;Lcom/tencent/mobileqq/util/FaceInfo;)V
    //   3864: aload_1
    //   3865: ifnull +7 -> 3872
    //   3868: aload_1
    //   3869: invokevirtual 579	java/net/HttpURLConnection:disconnect	()V
    //   3872: aload 31
    //   3874: ifnull +8 -> 3882
    //   3877: aload 31
    //   3879: invokevirtual 584	java/io/OutputStream:close	()V
    //   3882: iload 5
    //   3884: ifeq +76 -> 3960
    //   3887: aload 40
    //   3889: ifnull +71 -> 3960
    //   3892: aload 40
    //   3894: invokevirtual 380	java/io/File:getParentFile	()Ljava/io/File;
    //   3897: astore 32
    //   3899: aload 32
    //   3901: ifnull +17 -> 3918
    //   3904: aload 32
    //   3906: invokevirtual 383	java/io/File:exists	()Z
    //   3909: ifne +9 -> 3918
    //   3912: aload 32
    //   3914: invokevirtual 386	java/io/File:mkdirs	()Z
    //   3917: pop
    //   3918: aload 40
    //   3920: invokevirtual 383	java/io/File:exists	()Z
    //   3923: ifeq +37 -> 3960
    //   3926: aload 40
    //   3928: invokevirtual 413	java/io/File:delete	()Z
    //   3931: istore 18
    //   3933: ldc 139
    //   3935: iconst_1
    //   3936: new 191	java/lang/StringBuilder
    //   3939: dup
    //   3940: invokespecial 192	java/lang/StringBuilder:<init>	()V
    //   3943: ldc_w 586
    //   3946: invokevirtual 196	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3949: iload 18
    //   3951: invokevirtual 589	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   3954: invokevirtual 200	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3957: invokestatic 230	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   3960: iload 11
    //   3962: iconst_1
    //   3963: iadd
    //   3964: istore 6
    //   3966: iload 5
    //   3968: ifeq +141 -> 4109
    //   3971: ldc 139
    //   3973: iconst_1
    //   3974: new 191	java/lang/StringBuilder
    //   3977: dup
    //   3978: invokespecial 192	java/lang/StringBuilder:<init>	()V
    //   3981: ldc_w 591
    //   3984: invokevirtual 196	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3987: iload 5
    //   3989: invokevirtual 247	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   3992: ldc_w 593
    //   3995: invokevirtual 196	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3998: aload 39
    //   4000: invokevirtual 285	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   4003: ldc_w 508
    //   4006: invokevirtual 196	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4009: iload 6
    //   4011: invokevirtual 247	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   4014: ldc_w 461
    //   4017: invokevirtual 196	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4020: aload_3
    //   4021: invokevirtual 285	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   4024: ldc_w 595
    //   4027: invokevirtual 196	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4030: iload 17
    //   4032: invokevirtual 589	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   4035: ldc_w 597
    //   4038: invokevirtual 196	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4041: aload 43
    //   4043: invokevirtual 196	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4046: ldc_w 599
    //   4049: invokevirtual 196	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4052: iload 16
    //   4054: invokevirtual 247	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   4057: ldc_w 601
    //   4060: invokevirtual 196	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4063: getstatic 487	com/tencent/mobileqq/app/FaceDownloader:jdField_a_of_type_Boolean	Z
    //   4066: invokevirtual 589	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   4069: ldc_w 603
    //   4072: invokevirtual 196	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4075: iload 12
    //   4077: invokevirtual 247	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   4080: ldc_w 605
    //   4083: invokevirtual 196	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4086: aload 44
    //   4088: invokevirtual 196	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4091: ldc_w 607
    //   4094: invokevirtual 196	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4097: getstatic 30	com/tencent/mobileqq/app/FaceDownloader:e	I
    //   4100: invokevirtual 247	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   4103: invokevirtual 200	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   4106: invokestatic 230	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   4109: iload 5
    //   4111: ifeq +1850 -> 5961
    //   4114: iload 6
    //   4116: iconst_2
    //   4117: if_icmpge +1844 -> 5961
    //   4120: aload 38
    //   4122: monitorenter
    //   4123: aload 38
    //   4125: ldc2_w 608
    //   4128: invokevirtual 613	java/lang/Object:wait	(J)V
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
    //   4191: getfield 530	anff:c	I
    //   4194: istore 5
    //   4196: goto -468 -> 3728
    //   4199: astore_1
    //   4200: aload 38
    //   4202: monitorexit
    //   4203: aload_1
    //   4204: athrow
    //   4205: aload_3
    //   4206: getstatic 422	com/tencent/mobileqq/util/FaceInfo:o	I
    //   4209: invokevirtual 424	com/tencent/mobileqq/util/FaceInfo:a	(I)V
    //   4212: iload 5
    //   4214: i2l
    //   4215: lload 25
    //   4217: lcmp
    //   4218: ifne +214 -> 4432
    //   4221: aload_3
    //   4222: getstatic 628	com/tencent/mobileqq/util/FaceInfo:p	I
    //   4225: invokevirtual 424	com/tencent/mobileqq/util/FaceInfo:a	(I)V
    //   4228: aload 34
    //   4230: iconst_0
    //   4231: iload 5
    //   4233: invokestatic 633	azvq:a	([BII)Landroid/graphics/Bitmap;
    //   4236: astore 33
    //   4238: aload 33
    //   4240: astore 31
    //   4242: aload 33
    //   4244: ifnull +87 -> 4331
    //   4247: aload_3
    //   4248: getfield 634	com/tencent/mobileqq/util/FaceInfo:c	I
    //   4251: tableswitch	default:+1784 -> 6035, 1:+574->4825, 2:+33->4284, 3:+596->4847, 4:+596->4847, 5:+1787->6038
    //   4285: lload_3
    //   4286: bipush 50
    //   4288: bipush 50
    //   4290: invokestatic 639	bacm:c	(Landroid/graphics/Bitmap;II)Landroid/graphics/Bitmap;
    //   4293: astore 31
    //   4295: aload_0
    //   4296: getfield 93	com/tencent/mobileqq/app/FaceDownloader:jdField_a_of_type_ComTencentCommonAppAppInterface	Lcom/tencent/common/app/AppInterface;
    //   4299: sipush 216
    //   4302: invokevirtual 645	com/tencent/common/app/AppInterface:getManager	(I)Lmqq/manager/Manager;
    //   4305: checkcast 647	azwz
    //   4308: aload_3
    //   4309: invokevirtual 649	com/tencent/mobileqq/util/FaceInfo:a	()Ljava/lang/String;
    //   4312: aload 31
    //   4314: aload_3
    //   4315: getfield 650	com/tencent/mobileqq/util/FaceInfo:jdField_a_of_type_Int	I
    //   4318: invokestatic 653	azwz:a	(I)B
    //   4321: invokevirtual 656	azwz:a	(Ljava/lang/String;Landroid/graphics/Bitmap;B)V
    //   4324: aload_3
    //   4325: getstatic 659	com/tencent/mobileqq/util/FaceInfo:q	I
    //   4328: invokevirtual 424	com/tencent/mobileqq/util/FaceInfo:a	(I)V
    //   4331: invokestatic 222	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   4334: ifeq +51 -> 4385
    //   4337: ldc 139
    //   4339: iconst_2
    //   4340: new 191	java/lang/StringBuilder
    //   4343: dup
    //   4344: invokespecial 192	java/lang/StringBuilder:<init>	()V
    //   4347: ldc_w 661
    //   4350: invokevirtual 196	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4353: aload 31
    //   4355: invokevirtual 285	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   4358: ldc_w 593
    //   4361: invokevirtual 196	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4364: aload 39
    //   4366: invokevirtual 285	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   4369: ldc_w 461
    //   4372: invokevirtual 196	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4375: aload_3
    //   4376: invokevirtual 285	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   4379: invokevirtual 200	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   4382: invokestatic 230	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   4385: new 415	ajhu
    //   4388: dup
    //   4389: aload_0
    //   4390: invokespecial 416	ajhu:<init>	(Lcom/tencent/mobileqq/app/FaceDownloader;)V
    //   4393: astore 33
    //   4395: aload 33
    //   4397: aload_3
    //   4398: putfield 419	ajhu:jdField_a_of_type_ComTencentMobileqqUtilFaceInfo	Lcom/tencent/mobileqq/util/FaceInfo;
    //   4401: aload 33
    //   4403: aload 31
    //   4405: putfield 427	ajhu:jdField_a_of_type_AndroidGraphicsBitmap	Landroid/graphics/Bitmap;
    //   4408: aload_0
    //   4409: getfield 62	com/tencent/mobileqq/app/FaceDownloader:jdField_b_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   4412: aload 33
    //   4414: invokevirtual 430	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   4417: pop
    //   4418: aload_0
    //   4419: getfield 164	com/tencent/mobileqq/app/FaceDownloader:jdField_a_of_type_MqqOsMqqHandler	Lmqq/os/MqqHandler;
    //   4422: bipush 100
    //   4424: aload 33
    //   4426: invokevirtual 436	mqq/os/MqqHandler:obtainMessage	(ILjava/lang/Object;)Landroid/os/Message;
    //   4429: invokevirtual 441	android/os/Message:sendToTarget	()V
    //   4432: aload 32
    //   4434: aload 34
    //   4436: iconst_0
    //   4437: iload 5
    //   4439: invokevirtual 665	java/io/OutputStream:write	([BII)V
    //   4442: aload 32
    //   4444: invokevirtual 668	java/io/OutputStream:flush	()V
    //   4447: aload_2
    //   4448: invokevirtual 383	java/io/File:exists	()Z
    //   4451: ifeq +8 -> 4459
    //   4454: aload_2
    //   4455: invokevirtual 413	java/io/File:delete	()Z
    //   4458: pop
    //   4459: aload 40
    //   4461: aload_2
    //   4462: invokevirtual 672	java/io/File:renameTo	(Ljava/io/File;)Z
    //   4465: pop
    //   4466: aload_2
    //   4467: invokestatic 374	java/lang/System:currentTimeMillis	()J
    //   4470: invokevirtual 676	java/io/File:setLastModified	(J)Z
    //   4473: pop
    //   4474: iconst_0
    //   4475: istore 5
    //   4477: aload 32
    //   4479: astore 31
    //   4481: lload 25
    //   4483: lstore 27
    //   4485: iload 5
    //   4487: istore 7
    //   4489: aload_1
    //   4490: ifnull +7 -> 4497
    //   4493: aload_1
    //   4494: invokevirtual 579	java/net/HttpURLConnection:disconnect	()V
    //   4497: aload 31
    //   4499: ifnull +8 -> 4507
    //   4502: aload 31
    //   4504: invokevirtual 584	java/io/OutputStream:close	()V
    //   4507: iload 7
    //   4509: ifeq +76 -> 4585
    //   4512: aload 40
    //   4514: ifnull +71 -> 4585
    //   4517: aload 40
    //   4519: invokevirtual 380	java/io/File:getParentFile	()Ljava/io/File;
    //   4522: astore 32
    //   4524: aload 32
    //   4526: ifnull +17 -> 4543
    //   4529: aload 32
    //   4531: invokevirtual 383	java/io/File:exists	()Z
    //   4534: ifne +9 -> 4543
    //   4537: aload 32
    //   4539: invokevirtual 386	java/io/File:mkdirs	()Z
    //   4542: pop
    //   4543: aload 40
    //   4545: invokevirtual 383	java/io/File:exists	()Z
    //   4548: ifeq +37 -> 4585
    //   4551: aload 40
    //   4553: invokevirtual 413	java/io/File:delete	()Z
    //   4556: istore 18
    //   4558: ldc 139
    //   4560: iconst_1
    //   4561: new 191	java/lang/StringBuilder
    //   4564: dup
    //   4565: invokespecial 192	java/lang/StringBuilder:<init>	()V
    //   4568: ldc_w 586
    //   4571: invokevirtual 196	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4574: iload 18
    //   4576: invokevirtual 589	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   4579: invokevirtual 200	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   4582: invokestatic 230	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   4585: iload 11
    //   4587: iconst_1
    //   4588: iadd
    //   4589: istore 8
    //   4591: iload 7
    //   4593: ifeq +141 -> 4734
    //   4596: ldc 139
    //   4598: iconst_1
    //   4599: new 191	java/lang/StringBuilder
    //   4602: dup
    //   4603: invokespecial 192	java/lang/StringBuilder:<init>	()V
    //   4606: ldc_w 591
    //   4609: invokevirtual 196	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4612: iload 7
    //   4614: invokevirtual 247	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   4617: ldc_w 593
    //   4620: invokevirtual 196	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4623: aload 39
    //   4625: invokevirtual 285	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   4628: ldc_w 508
    //   4631: invokevirtual 196	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4634: iload 8
    //   4636: invokevirtual 247	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   4639: ldc_w 461
    //   4642: invokevirtual 196	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4645: aload_3
    //   4646: invokevirtual 285	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   4649: ldc_w 595
    //   4652: invokevirtual 196	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4655: iload 17
    //   4657: invokevirtual 589	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   4660: ldc_w 597
    //   4663: invokevirtual 196	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4666: aload 43
    //   4668: invokevirtual 196	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4671: ldc_w 599
    //   4674: invokevirtual 196	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4677: iload 16
    //   4679: invokevirtual 247	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   4682: ldc_w 601
    //   4685: invokevirtual 196	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4688: getstatic 487	com/tencent/mobileqq/app/FaceDownloader:jdField_a_of_type_Boolean	Z
    //   4691: invokevirtual 589	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   4694: ldc_w 603
    //   4697: invokevirtual 196	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4700: iload 12
    //   4702: invokevirtual 247	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   4705: ldc_w 605
    //   4708: invokevirtual 196	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4711: aload 44
    //   4713: invokevirtual 196	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4716: ldc_w 607
    //   4719: invokevirtual 196	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4722: getstatic 30	com/tencent/mobileqq/app/FaceDownloader:e	I
    //   4725: invokevirtual 247	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   4728: invokevirtual 200	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   4731: invokestatic 230	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   4734: iload 7
    //   4736: istore 5
    //   4738: iload 8
    //   4740: istore 6
    //   4742: lload 27
    //   4744: lstore 25
    //   4746: aload 31
    //   4748: astore 34
    //   4750: aload_1
    //   4751: astore 32
    //   4753: iload 7
    //   4755: ifeq -2118 -> 2637
    //   4758: iload 7
    //   4760: istore 5
    //   4762: iload 8
    //   4764: istore 6
    //   4766: lload 27
    //   4768: lstore 25
    //   4770: aload 31
    //   4772: astore 34
    //   4774: aload_1
    //   4775: astore 32
    //   4777: iload 8
    //   4779: iconst_2
    //   4780: if_icmpge -2143 -> 2637
    //   4783: aload 38
    //   4785: monitorenter
    //   4786: aload 38
    //   4788: ldc2_w 608
    //   4791: invokevirtual 613	java/lang/Object:wait	(J)V
    //   4794: aload 38
    //   4796: monitorexit
    //   4797: iload 7
    //   4799: istore 5
    //   4801: iload 8
    //   4803: istore 6
    //   4805: lload 27
    //   4807: lstore 25
    //   4809: aload 31
    //   4811: astore 34
    //   4813: aload_1
    //   4814: astore 32
    //   4816: goto -2179 -> 2637
    //   4819: astore_1
    //   4820: aload 38
    //   4822: monitorexit
    //   4823: aload_1
    //   4824: athrow
    //   4825: aload 33
    //   4827: aload 33
    //   4829: invokevirtual 681	android/graphics/Bitmap:getWidth	()I
    //   4832: invokestatic 683	bacm:a	(I)I
    //   4835: bipush 50
    //   4837: bipush 50
    //   4839: invokestatic 688	com/tencent/mobileqq/app/QQAppInterface:a	(Landroid/graphics/Bitmap;III)Landroid/graphics/Bitmap;
    //   4842: astore 31
    //   4844: goto -549 -> 4295
    //   4847: aload 33
    //   4849: bipush 50
    //   4851: bipush 50
    //   4853: invokestatic 690	bacm:a	(Landroid/graphics/Bitmap;II)Landroid/graphics/Bitmap;
    //   4856: astore 31
    //   4858: goto -563 -> 4295
    //   4861: sipush 1024
    //   4864: newarray byte
    //   4866: astore 33
    //   4868: iload 15
    //   4870: istore 5
    //   4872: aload 31
    //   4874: aload 33
    //   4876: invokevirtual 693	java/io/InputStream:read	([B)I
    //   4879: istore 6
    //   4881: iload 6
    //   4883: iconst_m1
    //   4884: if_icmpeq +82 -> 4966
    //   4887: iload 5
    //   4889: iload 6
    //   4891: iadd
    //   4892: istore 5
    //   4894: aload 32
    //   4896: aload 33
    //   4898: iconst_0
    //   4899: iload 6
    //   4901: invokevirtual 665	java/io/OutputStream:write	([BII)V
    //   4904: goto -32 -> 4872
    //   4907: astore 31
    //   4909: aload 32
    //   4911: astore 31
    //   4913: ldc 139
    //   4915: iconst_1
    //   4916: new 191	java/lang/StringBuilder
    //   4919: dup
    //   4920: invokespecial 192	java/lang/StringBuilder:<init>	()V
    //   4923: ldc_w 695
    //   4926: invokevirtual 196	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4929: aload 40
    //   4931: invokevirtual 383	java/io/File:exists	()Z
    //   4934: invokevirtual 589	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   4937: ldc_w 697
    //   4940: invokevirtual 196	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4943: aload 40
    //   4945: invokevirtual 380	java/io/File:getParentFile	()Ljava/io/File;
    //   4948: invokevirtual 383	java/io/File:exists	()Z
    //   4951: invokevirtual 589	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   4954: invokevirtual 200	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   4957: invokestatic 230	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   4960: iconst_4
    //   4961: istore 5
    //   4963: goto -482 -> 4481
    //   4966: aload_3
    //   4967: getstatic 422	com/tencent/mobileqq/util/FaceInfo:o	I
    //   4970: invokevirtual 424	com/tencent/mobileqq/util/FaceInfo:a	(I)V
    //   4973: goto -531 -> 4442
    //   4976: astore 33
    //   4978: aload 32
    //   4980: astore 31
    //   4982: iconst_0
    //   4983: istore 5
    //   4985: aload 33
    //   4987: astore 32
    //   4989: goto -2692 -> 2297
    //   4992: lload 25
    //   4994: lstore 27
    //   4996: iload 17
    //   4998: istore 19
    //   5000: aload_1
    //   5001: astore 36
    //   5003: iload 5
    //   5005: istore 7
    //   5007: lload 25
    //   5009: lstore 29
    //   5011: iload 17
    //   5013: istore 20
    //   5015: aload_1
    //   5016: astore 37
    //   5018: iload 13
    //   5020: istore 8
    //   5022: aload 31
    //   5024: astore 34
    //   5026: iload 17
    //   5028: istore 18
    //   5030: aload_1
    //   5031: astore 33
    //   5033: iload 14
    //   5035: istore 6
    //   5037: aload 42
    //   5039: getfield 530	anff:c	I
    //   5042: istore 5
    //   5044: iload 5
    //   5046: istore 7
    //   5048: lload 25
    //   5050: lstore 27
    //   5052: goto -563 -> 4489
    //   5055: iload 5
    //   5057: istore 6
    //   5059: aload 32
    //   5061: instanceof 699
    //   5064: ifne +981 -> 6045
    //   5067: iload 5
    //   5069: istore 6
    //   5071: aload 32
    //   5073: instanceof 701
    //   5076: ifeq +6 -> 5082
    //   5079: goto +966 -> 6045
    //   5082: iload 5
    //   5084: istore 6
    //   5086: aload 32
    //   5088: instanceof 703
    //   5091: ifeq +10 -> 5101
    //   5094: bipush 11
    //   5096: istore 5
    //   5098: goto -2738 -> 2360
    //   5101: iload 5
    //   5103: istore 6
    //   5105: aload 32
    //   5107: instanceof 705
    //   5110: ifeq +10 -> 5120
    //   5113: bipush 8
    //   5115: istore 5
    //   5117: goto -2757 -> 2360
    //   5120: iload 5
    //   5122: istore 6
    //   5124: aload 32
    //   5126: instanceof 707
    //   5129: ifeq +10 -> 5139
    //   5132: bipush 17
    //   5134: istore 5
    //   5136: goto -2776 -> 2360
    //   5139: iload 5
    //   5141: istore 6
    //   5143: aload 32
    //   5145: instanceof 709
    //   5148: ifeq +10 -> 5158
    //   5151: bipush 18
    //   5153: istore 5
    //   5155: goto -2795 -> 2360
    //   5158: iload 5
    //   5160: istore 6
    //   5162: aload 32
    //   5164: instanceof 711
    //   5167: ifeq +10 -> 5177
    //   5170: bipush 19
    //   5172: istore 5
    //   5174: goto -2814 -> 2360
    //   5177: iload 5
    //   5179: istore 6
    //   5181: aload 32
    //   5183: invokevirtual 714	java/io/IOException:getMessage	()Ljava/lang/String;
    //   5186: astore 32
    //   5188: iload 5
    //   5190: istore 6
    //   5192: aload 32
    //   5194: ldc_w 716
    //   5197: invokevirtual 719	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   5200: ifne +851 -> 6051
    //   5203: iload 5
    //   5205: istore 6
    //   5207: aload 32
    //   5209: ldc_w 721
    //   5212: invokevirtual 719	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   5215: ifne +836 -> 6051
    //   5218: iload 5
    //   5220: istore 6
    //   5222: aload 32
    //   5224: ldc_w 723
    //   5227: invokevirtual 719	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   5230: ifeq +836 -> 6066
    //   5233: goto +818 -> 6051
    //   5236: iload 5
    //   5238: istore 6
    //   5240: invokestatic 727	azzu:a	()Z
    //   5243: istore 18
    //   5245: iload 18
    //   5247: ifeq +170 -> 5417
    //   5250: iload 5
    //   5252: istore 6
    //   5254: invokestatic 729	azzu:a	()J
    //   5257: lstore 27
    //   5259: iload 5
    //   5261: istore 6
    //   5263: new 191	java/lang/StringBuilder
    //   5266: dup
    //   5267: invokespecial 192	java/lang/StringBuilder:<init>	()V
    //   5270: ldc_w 731
    //   5273: invokevirtual 196	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5276: astore 33
    //   5278: iload 5
    //   5280: istore 6
    //   5282: aload 40
    //   5284: invokevirtual 383	java/io/File:exists	()Z
    //   5287: ifeq +785 -> 6072
    //   5290: iload 5
    //   5292: istore 6
    //   5294: aload 40
    //   5296: invokevirtual 734	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   5299: astore 32
    //   5301: iload 5
    //   5303: istore 6
    //   5305: aload 33
    //   5307: aload 32
    //   5309: invokevirtual 196	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5312: ldc_w 736
    //   5315: invokevirtual 196	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5318: astore 33
    //   5320: iload 5
    //   5322: istore 6
    //   5324: aload 40
    //   5326: invokevirtual 380	java/io/File:getParentFile	()Ljava/io/File;
    //   5329: ifnull +100 -> 5429
    //   5332: iload 5
    //   5334: istore 6
    //   5336: aload 40
    //   5338: invokevirtual 380	java/io/File:getParentFile	()Ljava/io/File;
    //   5341: invokevirtual 383	java/io/File:exists	()Z
    //   5344: ifeq +85 -> 5429
    //   5347: iload 5
    //   5349: istore 6
    //   5351: aload 40
    //   5353: invokevirtual 380	java/io/File:getParentFile	()Ljava/io/File;
    //   5356: invokevirtual 734	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   5359: astore 32
    //   5361: iload 5
    //   5363: istore 6
    //   5365: ldc 139
    //   5367: iconst_1
    //   5368: aload 33
    //   5370: aload 32
    //   5372: invokevirtual 196	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5375: ldc_w 738
    //   5378: invokevirtual 196	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5381: iload 5
    //   5383: invokevirtual 247	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   5386: ldc_w 740
    //   5389: invokevirtual 196	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5392: iload 18
    //   5394: invokevirtual 589	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   5397: ldc_w 742
    //   5400: invokevirtual 196	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5403: lload 27
    //   5405: invokevirtual 745	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   5408: invokevirtual 200	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   5411: invokestatic 230	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   5414: goto -3054 -> 2360
    //   5417: iload 5
    //   5419: istore 6
    //   5421: invokestatic 747	azzu:b	()J
    //   5424: lstore 27
    //   5426: goto -167 -> 5259
    //   5429: ldc_w 749
    //   5432: astore 32
    //   5434: goto -73 -> 5361
    //   5437: astore_1
    //   5438: aload 38
    //   5440: monitorexit
    //   5441: aload_1
    //   5442: athrow
    //   5443: astore_1
    //   5444: aload 38
    //   5446: monitorexit
    //   5447: aload_1
    //   5448: athrow
    //   5449: iload 5
    //   5451: istore 6
    //   5453: lload 25
    //   5455: ldc2_w 560
    //   5458: lcmp
    //   5459: iflt -5428 -> 31
    //   5462: aload_3
    //   5463: getstatic 628	com/tencent/mobileqq/util/FaceInfo:p	I
    //   5466: invokevirtual 424	com/tencent/mobileqq/util/FaceInfo:a	(I)V
    //   5469: new 751	azvr
    //   5472: dup
    //   5473: invokespecial 752	azvr:<init>	()V
    //   5476: astore_2
    //   5477: new 754	android/graphics/BitmapFactory$Options
    //   5480: dup
    //   5481: invokespecial 755	android/graphics/BitmapFactory$Options:<init>	()V
    //   5484: astore 31
    //   5486: aload 31
    //   5488: getstatic 760	azwb:a	Landroid/graphics/Bitmap$Config;
    //   5491: putfield 763	android/graphics/BitmapFactory$Options:inPreferredConfig	Landroid/graphics/Bitmap$Config;
    //   5494: aload_0
    //   5495: getfield 93	com/tencent/mobileqq/app/FaceDownloader:jdField_a_of_type_ComTencentCommonAppAppInterface	Lcom/tencent/common/app/AppInterface;
    //   5498: sipush 216
    //   5501: invokevirtual 645	com/tencent/common/app/AppInterface:getManager	(I)Lmqq/manager/Manager;
    //   5504: checkcast 647	azwz
    //   5507: astore 32
    //   5509: iconst_0
    //   5510: istore 6
    //   5512: aload 32
    //   5514: aload_3
    //   5515: invokevirtual 766	azwz:a	(Lcom/tencent/mobileqq/util/FaceInfo;)Ljava/lang/String;
    //   5518: aload 31
    //   5520: aload_2
    //   5521: invokestatic 769	azvq:a	(Ljava/lang/String;Landroid/graphics/BitmapFactory$Options;Lazvr;)V
    //   5524: aload_2
    //   5525: getfield 770	azvr:jdField_a_of_type_Int	I
    //   5528: iconst_1
    //   5529: if_icmpne +18 -> 5547
    //   5532: aload_0
    //   5533: getfield 93	com/tencent/mobileqq/app/FaceDownloader:jdField_a_of_type_ComTencentCommonAppAppInterface	Lcom/tencent/common/app/AppInterface;
    //   5536: checkcast 772	com/tencent/mobileqq/nearby/NearbyAppInterface
    //   5539: checkcast 772	com/tencent/mobileqq/nearby/NearbyAppInterface
    //   5542: astore 33
    //   5544: invokestatic 773	com/tencent/mobileqq/nearby/NearbyAppInterface:b	()V
    //   5547: iload 6
    //   5549: iconst_1
    //   5550: iadd
    //   5551: istore 6
    //   5553: iload 6
    //   5555: iconst_2
    //   5556: if_icmpge +11 -> 5567
    //   5559: aload_2
    //   5560: getfield 770	azvr:jdField_a_of_type_Int	I
    //   5563: iconst_1
    //   5564: if_icmpeq +394 -> 5958
    //   5567: aload_2
    //   5568: getfield 774	azvr:jdField_a_of_type_AndroidGraphicsBitmap	Landroid/graphics/Bitmap;
    //   5571: ifnull +76 -> 5647
    //   5574: aload_3
    //   5575: getfield 634	com/tencent/mobileqq/util/FaceInfo:c	I
    //   5578: tableswitch	default:+34 -> 5612, 1:+109->5687, 2:+34->5612, 3:+141->5719, 4:+34->5612, 5:+49->5627
    //   5613: aload_2
    //   5614: getfield 774	azvr:jdField_a_of_type_AndroidGraphicsBitmap	Landroid/graphics/Bitmap;
    //   5617: bipush 50
    //   5619: bipush 50
    //   5621: invokestatic 639	bacm:c	(Landroid/graphics/Bitmap;II)Landroid/graphics/Bitmap;
    //   5624: putfield 774	azvr:jdField_a_of_type_AndroidGraphicsBitmap	Landroid/graphics/Bitmap;
    //   5627: aload 32
    //   5629: aload_3
    //   5630: invokevirtual 649	com/tencent/mobileqq/util/FaceInfo:a	()Ljava/lang/String;
    //   5633: aload_2
    //   5634: getfield 774	azvr:jdField_a_of_type_AndroidGraphicsBitmap	Landroid/graphics/Bitmap;
    //   5637: aload_3
    //   5638: getfield 650	com/tencent/mobileqq/util/FaceInfo:jdField_a_of_type_Int	I
    //   5641: invokestatic 653	azwz:a	(I)B
    //   5644: invokevirtual 656	azwz:a	(Ljava/lang/String;Landroid/graphics/Bitmap;B)V
    //   5647: aload_3
    //   5648: getstatic 659	com/tencent/mobileqq/util/FaceInfo:q	I
    //   5651: invokevirtual 424	com/tencent/mobileqq/util/FaceInfo:a	(I)V
    //   5654: aload_1
    //   5655: aload_2
    //   5656: getfield 774	azvr:jdField_a_of_type_AndroidGraphicsBitmap	Landroid/graphics/Bitmap;
    //   5659: putfield 427	ajhu:jdField_a_of_type_AndroidGraphicsBitmap	Landroid/graphics/Bitmap;
    //   5662: aload_0
    //   5663: getfield 62	com/tencent/mobileqq/app/FaceDownloader:jdField_b_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   5666: aload_1
    //   5667: invokevirtual 430	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   5670: pop
    //   5671: aload_0
    //   5672: getfield 164	com/tencent/mobileqq/app/FaceDownloader:jdField_a_of_type_MqqOsMqqHandler	Lmqq/os/MqqHandler;
    //   5675: bipush 100
    //   5677: aload_1
    //   5678: invokevirtual 436	mqq/os/MqqHandler:obtainMessage	(ILjava/lang/Object;)Landroid/os/Message;
    //   5681: invokevirtual 441	android/os/Message:sendToTarget	()V
    //   5684: iload 5
    //   5686: ireturn
    //   5687: aload_2
    //   5688: getfield 774	azvr:jdField_a_of_type_AndroidGraphicsBitmap	Landroid/graphics/Bitmap;
    //   5691: invokevirtual 681	android/graphics/Bitmap:getWidth	()I
    //   5694: invokestatic 683	bacm:a	(I)I
    //   5697: istore 6
    //   5699: aload_2
    //   5700: aload_2
    //   5701: getfield 774	azvr:jdField_a_of_type_AndroidGraphicsBitmap	Landroid/graphics/Bitmap;
    //   5704: iload 6
    //   5706: bipush 50
    //   5708: bipush 50
    //   5710: invokestatic 688	com/tencent/mobileqq/app/QQAppInterface:a	(Landroid/graphics/Bitmap;III)Landroid/graphics/Bitmap;
    //   5713: putfield 774	azvr:jdField_a_of_type_AndroidGraphicsBitmap	Landroid/graphics/Bitmap;
    //   5716: goto -89 -> 5627
    //   5719: aload_2
    //   5720: aload_2
    //   5721: getfield 774	azvr:jdField_a_of_type_AndroidGraphicsBitmap	Landroid/graphics/Bitmap;
    //   5724: bipush 50
    //   5726: bipush 50
    //   5728: invokestatic 690	bacm:a	(Landroid/graphics/Bitmap;II)Landroid/graphics/Bitmap;
    //   5731: putfield 774	azvr:jdField_a_of_type_AndroidGraphicsBitmap	Landroid/graphics/Bitmap;
    //   5734: goto -107 -> 5627
    //   5737: astore 32
    //   5739: goto -1857 -> 3882
    //   5742: astore 32
    //   5744: goto -1613 -> 4131
    //   5747: astore 32
    //   5749: goto -1242 -> 4507
    //   5752: astore 32
    //   5754: goto -960 -> 4794
    //   5757: astore 32
    //   5759: goto -3381 -> 2378
    //   5762: astore 32
    //   5764: goto -3137 -> 2627
    //   5767: astore 32
    //   5769: goto -2790 -> 2979
    //   5772: astore 32
    //   5774: goto -2543 -> 3231
    //   5777: astore_1
    //   5778: goto -2420 -> 3358
    //   5781: astore_1
    //   5782: goto -2179 -> 3603
    //   5785: astore_1
    //   5786: goto -2354 -> 3432
    //   5789: astore_2
    //   5790: aload 32
    //   5792: astore 31
    //   5794: iload 10
    //   5796: istore 5
    //   5798: goto -2458 -> 3340
    //   5801: astore_2
    //   5802: iload 10
    //   5804: istore 5
    //   5806: goto -2466 -> 3340
    //   5809: astore_2
    //   5810: iconst_1
    //   5811: istore 17
    //   5813: goto -2473 -> 3340
    //   5816: astore_2
    //   5817: goto -2477 -> 3340
    //   5820: astore_2
    //   5821: iload 8
    //   5823: istore 5
    //   5825: goto -2485 -> 3340
    //   5828: astore 32
    //   5830: goto -2778 -> 3052
    //   5833: astore 33
    //   5835: aload 32
    //   5837: astore 31
    //   5839: aload 33
    //   5841: astore 32
    //   5843: lload 25
    //   5845: lstore 27
    //   5847: iload 9
    //   5849: istore 5
    //   5851: goto -2947 -> 2904
    //   5854: astore 32
    //   5856: lload 25
    //   5858: lstore 27
    //   5860: iload 9
    //   5862: istore 5
    //   5864: goto -2960 -> 2904
    //   5867: astore 32
    //   5869: iconst_1
    //   5870: istore 17
    //   5872: lload 25
    //   5874: lstore 27
    //   5876: goto -2972 -> 2904
    //   5879: astore 32
    //   5881: lload 25
    //   5883: lstore 27
    //   5885: goto -2981 -> 2904
    //   5888: astore 32
    //   5890: iload 9
    //   5892: istore 5
    //   5894: lload 25
    //   5896: lstore 27
    //   5898: goto -2994 -> 2904
    //   5901: astore 32
    //   5903: goto -3447 -> 2456
    //   5906: astore 32
    //   5908: iconst_0
    //   5909: istore 5
    //   5911: goto -3614 -> 2297
    //   5914: astore 32
    //   5916: iconst_5
    //   5917: istore 5
    //   5919: iload 18
    //   5921: istore 17
    //   5923: goto -3626 -> 2297
    //   5926: astore 32
    //   5928: iconst_5
    //   5929: istore 5
    //   5931: goto -3634 -> 2297
    //   5934: astore 32
    //   5936: iload 10
    //   5938: istore 5
    //   5940: goto -3643 -> 2297
    //   5943: astore 32
    //   5945: goto -1360 -> 4585
    //   5948: astore 32
    //   5950: goto -1037 -> 4913
    //   5953: astore 32
    //   5955: goto -1995 -> 3960
    //   5958: goto -446 -> 5512
    //   5961: aload 31
    //   5963: astore 34
    //   5965: aload_1
    //   5966: astore 32
    //   5968: goto -3331 -> 2637
    //   5971: iconst_5
    //   5972: istore 6
    //   5974: iload 9
    //   5976: istore 7
    //   5978: goto -2243 -> 3735
    //   5981: goto -4897 -> 1084
    //   5984: iconst_m1
    //   5985: istore 12
    //   5987: aconst_null
    //   5988: astore 32
    //   5990: goto -5482 -> 508
    //   5993: aload 33
    //   5995: astore 32
    //   5997: goto -5585 -> 412
    //   6000: aload 33
    //   6002: astore 35
    //   6004: goto -5540 -> 464
    //   6007: aload 35
    //   6009: astore 33
    //   6011: aload 34
    //   6013: astore 31
    //   6015: aload 32
    //   6017: astore_1
    //   6018: iload 6
    //   6020: istore 11
    //   6022: goto -5813 -> 209
    //   6025: aload 31
    //   6027: astore 34
    //   6029: aload_1
    //   6030: astore 32
    //   6032: goto -3395 -> 2637
    //   6035: goto -1751 -> 4284
    //   6038: aload 33
    //   6040: astore 31
    //   6042: goto -1747 -> 4295
    //   6045: iconst_2
    //   6046: istore 5
    //   6048: goto -3688 -> 2360
    //   6051: bipush 33
    //   6053: istore 5
    //   6055: goto -819 -> 5236
    //   6058: astore_2
    //   6059: iload 6
    //   6061: istore 5
    //   6063: goto -2723 -> 3340
    //   6066: iconst_4
    //   6067: istore 5
    //   6069: goto -833 -> 5236
    //   6072: ldc_w 749
    //   6075: astore 32
    //   6077: goto -776 -> 5301
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	6080	0	this	FaceDownloader
    //   0	6080	1	paramString	String
    //   0	6080	2	paramFile	java.io.File
    //   0	6080	3	paramFaceInfo	FaceInfo
    //   0	6080	4	paramBoolean	boolean
    //   201	5867	5	i	int
    //   29	6031	6	j	int
    //   528	5449	7	k	int
    //   543	5279	8	m	int
    //   1744	4231	9	n	int
    //   1750	4187	10	i1	int
    //   198	5823	11	i2	int
    //   506	5480	12	i3	int
    //   1741	3278	13	i4	int
    //   1747	3287	14	i5	int
    //   1861	3008	15	i6	int
    //   487	4191	16	i7	int
    //   477	5445	17	bool1	boolean
    //   551	5369	18	bool2	boolean
    //   521	4478	19	bool3	boolean
    //   536	4478	20	bool4	boolean
    //   468	2256	21	bool5	boolean
    //   471	2268	22	bool6	boolean
    //   474	2280	23	bool7	boolean
    //   957	3	24	bool8	boolean
    //   6	5889	25	l1	long
    //   517	5380	27	l2	long
    //   532	4478	29	l3	long
    //   61	4812	31	localObject1	Object
    //   4907	1	31	localFileNotFoundException1	java.io.FileNotFoundException
    //   4911	1130	31	localObject2	Object
    //   195	12	32	localObject3	Object
    //   298	1	32	localIllegalArgumentException	java.lang.IllegalArgumentException
    //   330	1894	32	localObject4	Object
    //   2280	65	32	localIOException1	java.io.IOException
    //   2393	318	32	localObject5	Object
    //   2783	102	32	localThrowable1	Throwable
    //   2887	67	32	localThrowable2	Throwable
    //   2989	2639	32	localObject6	Object
    //   5737	1	32	localIOException2	java.io.IOException
    //   5742	1	32	localInterruptedException1	java.lang.InterruptedException
    //   5747	1	32	localIOException3	java.io.IOException
    //   5752	1	32	localInterruptedException2	java.lang.InterruptedException
    //   5757	1	32	localIOException4	java.io.IOException
    //   5762	1	32	localInterruptedException3	java.lang.InterruptedException
    //   5767	1	32	localIOException5	java.io.IOException
    //   5772	19	32	localInterruptedException4	java.lang.InterruptedException
    //   5828	8	32	localException1	java.lang.Exception
    //   5841	1	32	localObject7	Object
    //   5854	1	32	localThrowable3	Throwable
    //   5867	1	32	localThrowable4	Throwable
    //   5879	1	32	localThrowable5	Throwable
    //   5888	1	32	localThrowable6	Throwable
    //   5901	1	32	localException2	java.lang.Exception
    //   5906	1	32	localIOException6	java.io.IOException
    //   5914	1	32	localIOException7	java.io.IOException
    //   5926	1	32	localIOException8	java.io.IOException
    //   5934	1	32	localIOException9	java.io.IOException
    //   5943	1	32	localException3	java.lang.Exception
    //   5948	1	32	localFileNotFoundException2	java.io.FileNotFoundException
    //   5953	1	32	localException4	java.lang.Exception
    //   5966	110	32	localObject8	Object
    //   204	4693	33	localObject9	Object
    //   4976	10	33	localIOException10	java.io.IOException
    //   5031	512	33	localObject10	Object
    //   5833	168	33	localThrowable7	Throwable
    //   6009	30	33	localObject11	Object
    //   219	5809	34	localObject12	Object
    //   462	5546	35	localObject13	Object
    //   524	4478	36	str1	String
    //   539	4478	37	str2	String
    //   55	5390	38	localObject14	Object
    //   42	4582	39	localURL	java.net.URL
    //   178	5174	40	localFile	java.io.File
    //   3	499	41	localNetworkInfo	android.net.NetworkInfo
    //   95	4943	42	localanff	anff
    //   482	4185	43	str3	String
    //   513	4199	44	str4	String
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
    //   5037	5044	2280	java/io/IOException
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
    //   5037	5044	2887	java/lang/Throwable
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
    //   5037	5044	3324	finally
    //   4123	4131	4199	finally
    //   4131	4134	4199	finally
    //   4200	4203	4199	finally
    //   4786	4794	4819	finally
    //   4794	4797	4819	finally
    //   4820	4823	4819	finally
    //   2089	2095	4907	java/io/FileNotFoundException
    //   2109	2116	4907	java/io/FileNotFoundException
    //   2122	2136	4907	java/io/FileNotFoundException
    //   4205	4212	4907	java/io/FileNotFoundException
    //   4221	4238	4907	java/io/FileNotFoundException
    //   4247	4284	4907	java/io/FileNotFoundException
    //   4284	4295	4907	java/io/FileNotFoundException
    //   4295	4331	4907	java/io/FileNotFoundException
    //   4331	4385	4907	java/io/FileNotFoundException
    //   4385	4432	4907	java/io/FileNotFoundException
    //   4432	4442	4907	java/io/FileNotFoundException
    //   4442	4459	4907	java/io/FileNotFoundException
    //   4459	4474	4907	java/io/FileNotFoundException
    //   4825	4844	4907	java/io/FileNotFoundException
    //   4847	4858	4907	java/io/FileNotFoundException
    //   4861	4868	4907	java/io/FileNotFoundException
    //   4872	4881	4907	java/io/FileNotFoundException
    //   4894	4904	4907	java/io/FileNotFoundException
    //   4966	4973	4907	java/io/FileNotFoundException
    //   2089	2095	4976	java/io/IOException
    //   2109	2116	4976	java/io/IOException
    //   2122	2136	4976	java/io/IOException
    //   4205	4212	4976	java/io/IOException
    //   4221	4238	4976	java/io/IOException
    //   4247	4284	4976	java/io/IOException
    //   4284	4295	4976	java/io/IOException
    //   4295	4331	4976	java/io/IOException
    //   4331	4385	4976	java/io/IOException
    //   4385	4432	4976	java/io/IOException
    //   4432	4442	4976	java/io/IOException
    //   4442	4459	4976	java/io/IOException
    //   4459	4474	4976	java/io/IOException
    //   4825	4844	4976	java/io/IOException
    //   4847	4858	4976	java/io/IOException
    //   4861	4868	4976	java/io/IOException
    //   4872	4881	4976	java/io/IOException
    //   4894	4904	4976	java/io/IOException
    //   4966	4973	4976	java/io/IOException
    //   2619	2627	5437	finally
    //   2627	2630	5437	finally
    //   5438	5441	5437	finally
    //   3595	3603	5443	finally
    //   3603	3606	5443	finally
    //   5444	5447	5443	finally
    //   3877	3882	5737	java/io/IOException
    //   4123	4131	5742	java/lang/InterruptedException
    //   4502	4507	5747	java/io/IOException
    //   4786	4794	5752	java/lang/InterruptedException
    //   2373	2378	5757	java/io/IOException
    //   2619	2627	5762	java/lang/InterruptedException
    //   2974	2979	5767	java/io/IOException
    //   3223	3231	5772	java/lang/InterruptedException
    //   3353	3358	5777	java/io/IOException
    //   3595	3603	5781	java/lang/InterruptedException
    //   3368	3374	5785	java/lang/Exception
    //   3378	3390	5785	java/lang/Exception
    //   3390	3432	5785	java/lang/Exception
    //   2089	2095	5789	finally
    //   2109	2116	5789	finally
    //   2122	2136	5789	finally
    //   4205	4212	5789	finally
    //   4221	4238	5789	finally
    //   4247	4284	5789	finally
    //   4284	4295	5789	finally
    //   4295	4331	5789	finally
    //   4331	4385	5789	finally
    //   4385	4432	5789	finally
    //   4432	4442	5789	finally
    //   4442	4459	5789	finally
    //   4459	4474	5789	finally
    //   4825	4844	5789	finally
    //   4847	4858	5789	finally
    //   4861	4868	5789	finally
    //   4872	4881	5789	finally
    //   4894	4904	5789	finally
    //   4966	4973	5789	finally
    //   4913	4960	5801	finally
    //   970	1003	5809	finally
    //   1009	1033	5809	finally
    //   2651	2662	5809	finally
    //   2668	2690	5809	finally
    //   2699	2710	5809	finally
    //   1039	1084	5816	finally
    //   3755	3768	5820	finally
    //   3788	3796	5820	finally
    //   3816	3834	5820	finally
    //   3858	3864	5820	finally
    //   2984	2991	5828	java/lang/Exception
    //   2996	3010	5828	java/lang/Exception
    //   3010	3052	5828	java/lang/Exception
    //   2089	2095	5833	java/lang/Throwable
    //   2109	2116	5833	java/lang/Throwable
    //   2122	2136	5833	java/lang/Throwable
    //   4205	4212	5833	java/lang/Throwable
    //   4221	4238	5833	java/lang/Throwable
    //   4247	4284	5833	java/lang/Throwable
    //   4284	4295	5833	java/lang/Throwable
    //   4295	4331	5833	java/lang/Throwable
    //   4331	4385	5833	java/lang/Throwable
    //   4385	4432	5833	java/lang/Throwable
    //   4432	4442	5833	java/lang/Throwable
    //   4442	4459	5833	java/lang/Throwable
    //   4459	4474	5833	java/lang/Throwable
    //   4825	4844	5833	java/lang/Throwable
    //   4847	4858	5833	java/lang/Throwable
    //   4861	4868	5833	java/lang/Throwable
    //   4872	4881	5833	java/lang/Throwable
    //   4894	4904	5833	java/lang/Throwable
    //   4966	4973	5833	java/lang/Throwable
    //   4913	4960	5854	java/lang/Throwable
    //   970	1003	5867	java/lang/Throwable
    //   1009	1033	5867	java/lang/Throwable
    //   2651	2662	5867	java/lang/Throwable
    //   2668	2690	5867	java/lang/Throwable
    //   2699	2710	5867	java/lang/Throwable
    //   1039	1084	5879	java/lang/Throwable
    //   3755	3768	5888	java/lang/Throwable
    //   3788	3796	5888	java/lang/Throwable
    //   3816	3834	5888	java/lang/Throwable
    //   3858	3864	5888	java/lang/Throwable
    //   2388	2395	5901	java/lang/Exception
    //   2400	2414	5901	java/lang/Exception
    //   2414	2456	5901	java/lang/Exception
    //   4913	4960	5906	java/io/IOException
    //   970	1003	5914	java/io/IOException
    //   1009	1033	5914	java/io/IOException
    //   2651	2662	5914	java/io/IOException
    //   2668	2690	5914	java/io/IOException
    //   2699	2710	5914	java/io/IOException
    //   1039	1084	5926	java/io/IOException
    //   3755	3768	5934	java/io/IOException
    //   3788	3796	5934	java/io/IOException
    //   3816	3834	5934	java/io/IOException
    //   3858	3864	5934	java/io/IOException
    //   4517	4524	5943	java/lang/Exception
    //   4529	4543	5943	java/lang/Exception
    //   4543	4585	5943	java/lang/Exception
    //   1916	1924	5948	java/io/FileNotFoundException
    //   1969	1975	5948	java/io/FileNotFoundException
    //   2020	2026	5948	java/io/FileNotFoundException
    //   2071	2089	5948	java/io/FileNotFoundException
    //   3892	3899	5953	java/lang/Exception
    //   3904	3918	5953	java/lang/Exception
    //   3918	3960	5953	java/lang/Exception
    //   2301	2340	6058	finally
    //   2344	2351	6058	finally
    //   5059	5067	6058	finally
    //   5071	5079	6058	finally
    //   5086	5094	6058	finally
    //   5105	5113	6058	finally
    //   5124	5132	6058	finally
    //   5143	5151	6058	finally
    //   5162	5170	6058	finally
    //   5181	5188	6058	finally
    //   5192	5203	6058	finally
    //   5207	5218	6058	finally
    //   5222	5233	6058	finally
    //   5240	5245	6058	finally
    //   5254	5259	6058	finally
    //   5263	5278	6058	finally
    //   5282	5290	6058	finally
    //   5294	5301	6058	finally
    //   5305	5320	6058	finally
    //   5324	5332	6058	finally
    //   5336	5347	6058	finally
    //   5351	5361	6058	finally
    //   5365	5414	6058	finally
    //   5421	5426	6058	finally
  }
  
  public ajht a()
  {
    ajht localajht = new ajht(this);
    int i = Runtime.getRuntime().availableProcessors();
    if (QLog.isColorLevel()) {
      QLog.i("Q.qqhead.FaceDownloader", 2, "processor count:" + i);
    }
    if (i >= 4) {}
    do
    {
      return localajht;
      localajht.jdField_a_of_type_Int = (i + 1);
    } while (i > 2);
    localajht.jdField_b_of_type_Int = 10;
    return localajht;
  }
  
  public String a(String paramString, byte paramByte1, byte paramByte2, int paramInt)
  {
    String str;
    if (paramByte2 == 32) {
      if (paramInt == 1) {
        str = "q.qlogo.cn";
      }
    }
    for (;;)
    {
      if (a())
      {
        localObject1 = axwx.a().a(str, 1003, true, 28);
        if ((localObject1 == null) || (((List)localObject1).isEmpty())) {}
      }
      for (Object localObject1 = (String)((List)localObject1).get(0);; localObject1 = null)
      {
        Object localObject2 = localObject1;
        if (TextUtils.isEmpty((CharSequence)localObject1)) {
          localObject2 = axwx.a().a(str, 1003);
        }
        if (QLog.isColorLevel()) {
          QLog.i("InnerDns", 2, "getQQHeandDownLoadUrl.choosedIp=" + (String)localObject2);
        }
        localObject1 = new StringBuilder("http://");
        if (!TextUtils.isEmpty((CharSequence)localObject2))
        {
          ((StringBuilder)localObject1).append((String)localObject2);
          label152:
          int i = paramString.indexOf("/", 8);
          str = paramString;
          if (i > 8)
          {
            ((StringBuilder)localObject1).append(paramString.substring(i));
            str = ((StringBuilder)localObject1).toString();
          }
          if (paramByte2 != 32) {
            break label302;
          }
          if (paramInt != 1) {
            break label295;
          }
          paramByte2 = a(paramByte1);
        }
        for (;;)
        {
          return str + paramByte2;
          if (paramInt != 32) {
            break label330;
          }
          str = "p.qlogo.cn";
          break;
          if (paramByte2 == 16)
          {
            str = "p.qlogo.cn";
            break;
          }
          if ((paramByte2 == 4) || (paramByte2 == 8))
          {
            str = "p.qlogo.cn";
            break;
          }
          str = "q.qlogo.cn";
          break;
          ((StringBuilder)localObject1).append(str);
          break label152;
          label295:
          paramByte2 = 140;
          continue;
          label302:
          if (paramByte2 == 16) {
            paramByte2 = 224;
          } else {
            paramByte2 = a(paramByte1);
          }
        }
      }
      label330:
      str = "q.qlogo.cn";
    }
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_JavaUtilHashSet != null) {
      this.jdField_a_of_type_JavaUtilHashSet.clear();
    }
    int i = 0;
    while (i < this.jdField_a_of_type_ArrayOfComTencentMobileqqAppFaceDownloader$FaceDownloadRunnable.length)
    {
      if (this.jdField_a_of_type_ArrayOfComTencentMobileqqAppFaceDownloader$FaceDownloadRunnable[i] != null) {
        this.jdField_a_of_type_ArrayOfComTencentMobileqqAppFaceDownloader$FaceDownloadRunnable[i].a();
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
    int j;
    int i;
    if ((paramInt == this.jdField_a_of_type_Int) && (this.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicInteger.get() < this.jdField_a_of_type_Int) && (this.jdField_a_of_type_JavaUtilArrayList.size() >= this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.get()))
    {
      j = this.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicInteger.get() + this.jdField_a_of_type_JavaUtilArrayList.size() - this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.get() + 1;
      i = j;
      if (j <= 0) {
        i = 1;
      }
      if (i >= this.jdField_a_of_type_Int) {}
    }
    try
    {
      for (;;)
      {
        arrayOfThread = this.jdField_a_of_type_ArrayOfJavaLangThread;
        j = 0;
        for (;;)
        {
          if (j >= i) {
            break label180;
          }
          try
          {
            if (this.jdField_a_of_type_ArrayOfJavaLangThread[j] == null)
            {
              this.jdField_a_of_type_ArrayOfComTencentMobileqqAppFaceDownloader$FaceDownloadRunnable[j] = new FaceDownloader.FaceDownloadRunnable(this, j);
              this.jdField_a_of_type_ArrayOfJavaLangThread[j] = ThreadManager.newFreeThread(this.jdField_a_of_type_ArrayOfComTencentMobileqqAppFaceDownloader$FaceDownloadRunnable[j], "FaceDownloadThread", 5);
              this.jdField_a_of_type_ArrayOfJavaLangThread[j].start();
              this.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicInteger.incrementAndGet();
            }
            j += 1;
          }
          finally {}
        }
        i = this.jdField_a_of_type_Int;
      }
      label180:
      if ((this.jdField_a_of_type_ArrayOfComTencentMobileqqAppFaceDownloader$FaceDownloadRunnable == null) || (this.jdField_a_of_type_ArrayOfComTencentMobileqqAppFaceDownloader$FaceDownloadRunnable.length <= 0) || (this.jdField_a_of_type_ArrayOfComTencentMobileqqAppFaceDownloader$FaceDownloadRunnable[0] == null)) {
        QLog.e("Q.qqhead.FaceDownloader", 2, "smartSetThreadCount fail, MAX_THREAD_COUNT=" + this.jdField_a_of_type_Int + ",newThreadCount=" + paramInt + ",currThreadCount=" + this.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicInteger + ",idleThreadCount=" + this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger + ",queueSize=" + k);
      }
      return;
    }
    catch (Throwable localThrowable)
    {
      Thread[] arrayOfThread;
      QLog.e("Q.qqhead.FaceDownloader", 1, "smartSetThreadCount", localThrowable);
    }
  }
  
  public void a(ajhs paramajhs)
  {
    try
    {
      if (QLog.isColorLevel()) {
        QLog.i("Q.qqhead.FaceDownloader", 2, "addFaceDownloadListener l=" + paramajhs);
      }
      this.jdField_a_of_type_JavaUtilLinkedList.add(paramajhs);
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
  
  protected boolean a()
  {
    if (!AppSetting.a()) {}
    int i;
    do
    {
      return false;
      i = NetConnInfoCenter.getActiveNetIpFamily(true);
      if (QLog.isColorLevel()) {
        QLog.i("Q.qqhead.FaceDownloader", 2, "isIpv6, getActiveNetIpFamily = " + i);
      }
    } while ((i != 2) && (i != 3));
    if (QLog.isColorLevel()) {
      QLog.i("Q.qqhead.FaceDownloader", 2, "iisIpv6, true");
    }
    return true;
  }
  
  public void b(ajhs paramajhs)
  {
    try
    {
      if (QLog.isColorLevel()) {
        QLog.i("Q.qqhead.FaceDownloader", 2, "removeFaceDownloadListener l=" + paramajhs);
      }
      this.jdField_a_of_type_JavaUtilLinkedList.remove(paramajhs);
      return;
    }
    finally {}
  }
  
  protected abstract void b(FaceInfo paramFaceInfo);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.app.FaceDownloader
 * JD-Core Version:    0.7.0.1
 */