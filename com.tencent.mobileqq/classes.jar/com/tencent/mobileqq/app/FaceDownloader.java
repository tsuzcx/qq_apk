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
import mqq.os.MqqHandler;
import zcz;
import zda;
import zdb;

public abstract class FaceDownloader
{
  private static String jdField_a_of_type_JavaLangString;
  private static boolean jdField_a_of_type_Boolean;
  private static int g = 1;
  protected byte a;
  public int a;
  protected AppInterface a;
  private FaceDownloader.FaceDownloadThreadInfo jdField_a_of_type_ComTencentMobileqqAppFaceDownloader$FaceDownloadThreadInfo;
  public ArrayList a;
  public HashSet a;
  public LinkedList a;
  protected MqqHandler a;
  private Thread[] jdField_a_of_type_ArrayOfJavaLangThread;
  private zdb[] jdField_a_of_type_ArrayOfZdb;
  public int b;
  public ArrayList b;
  public int c;
  protected int d;
  private int e = 2;
  private int f = 10;
  
  public FaceDownloader(AppInterface paramAppInterface)
  {
    this.jdField_a_of_type_Int = 6;
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
    this.c = this.jdField_a_of_type_Int;
    this.jdField_a_of_type_ArrayOfJavaLangThread = new Thread[this.jdField_a_of_type_Int];
    this.jdField_a_of_type_ArrayOfZdb = new zdb[this.jdField_a_of_type_Int];
    int i = 0;
    while (i < this.jdField_a_of_type_ArrayOfJavaLangThread.length)
    {
      this.jdField_a_of_type_ArrayOfZdb[i] = new zdb(this, i);
      this.jdField_a_of_type_ArrayOfJavaLangThread[i] = ThreadManager.newFreeThread(this.jdField_a_of_type_ArrayOfZdb[i], "FaceDownloadThread", 5);
      if (ThreadOptimizer.a().c()) {
        this.jdField_a_of_type_ArrayOfJavaLangThread[i].setPriority(1);
      }
      this.jdField_a_of_type_ArrayOfJavaLangThread[i].start();
      i += 1;
    }
    this.d = a();
    switch (this.d)
    {
    }
    for (;;)
    {
      this.jdField_a_of_type_MqqOsMqqHandler = new zcz(this, Looper.getMainLooper());
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
    ThreadManager.post(new zda(this), 5, null, true);
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
      return this.d;
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
    //   0: invokestatic 317	com/tencent/mobileqq/msf/sdk/AppNetConnInfo:getRecentNetworkInfo	()Landroid/net/NetworkInfo;
    //   3: astore 41
    //   5: lconst_0
    //   6: lstore 25
    //   8: aload 41
    //   10: ifnonnull +24 -> 34
    //   13: invokestatic 251	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   16: ifeq +12 -> 28
    //   19: ldc 196
    //   21: iconst_2
    //   22: ldc_w 319
    //   25: invokestatic 235	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   28: iconst_1
    //   29: istore 6
    //   31: iload 6
    //   33: ireturn
    //   34: new 321	java/net/URL
    //   37: dup
    //   38: aload_1
    //   39: invokespecial 324	java/net/URL:<init>	(Ljava/lang/String;)V
    //   42: astore 39
    //   44: invokestatic 330	java/lang/System:currentTimeMillis	()J
    //   47: pop2
    //   48: new 4	java/lang/Object
    //   51: dup
    //   52: invokespecial 32	java/lang/Object:<init>	()V
    //   55: astore 38
    //   57: aload_2
    //   58: invokevirtual 336	java/io/File:getParentFile	()Ljava/io/File;
    //   61: astore 31
    //   63: aload 31
    //   65: ifnull +17 -> 82
    //   68: aload 31
    //   70: invokevirtual 339	java/io/File:exists	()Z
    //   73: ifne +9 -> 82
    //   76: aload 31
    //   78: invokevirtual 342	java/io/File:mkdirs	()Z
    //   81: pop
    //   82: aconst_null
    //   83: astore 31
    //   85: new 344	com/tencent/mobileqq/emoticon/DownloadInfo
    //   88: dup
    //   89: aload_1
    //   90: aconst_null
    //   91: iconst_0
    //   92: invokespecial 347	com/tencent/mobileqq/emoticon/DownloadInfo:<init>	(Ljava/lang/String;Ljava/io/File;I)V
    //   95: astore 42
    //   97: aload 41
    //   99: ifnonnull +40 -> 139
    //   102: ldc 196
    //   104: iconst_1
    //   105: ldc_w 349
    //   108: invokestatic 235	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   111: aload 42
    //   113: iconst_1
    //   114: putfield 350	com/tencent/mobileqq/emoticon/DownloadInfo:jdField_b_of_type_Int	I
    //   117: iconst_1
    //   118: ireturn
    //   119: astore_1
    //   120: aload_1
    //   121: invokevirtual 353	java/net/MalformedURLException:printStackTrace	()V
    //   124: bipush 13
    //   126: ireturn
    //   127: astore_1
    //   128: ldc 196
    //   130: iconst_1
    //   131: ldc_w 355
    //   134: invokestatic 357	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   137: iconst_4
    //   138: ireturn
    //   139: new 359	org/apache/http/client/methods/HttpGet
    //   142: dup
    //   143: aload_1
    //   144: invokespecial 360	org/apache/http/client/methods/HttpGet:<init>	(Ljava/lang/String;)V
    //   147: pop
    //   148: new 332	java/io/File
    //   151: dup
    //   152: new 169	java/lang/StringBuilder
    //   155: dup
    //   156: invokespecial 170	java/lang/StringBuilder:<init>	()V
    //   159: aload_2
    //   160: invokevirtual 363	java/io/File:getPath	()Ljava/lang/String;
    //   163: invokevirtual 174	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   166: ldc_w 365
    //   169: invokevirtual 174	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   172: invokevirtual 178	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   175: invokespecial 366	java/io/File:<init>	(Ljava/lang/String;)V
    //   178: astore 40
    //   180: aload 40
    //   182: invokevirtual 339	java/io/File:exists	()Z
    //   185: ifeq +9 -> 194
    //   188: aload 40
    //   190: invokevirtual 369	java/io/File:delete	()Z
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
    //   212: if_icmpeq +5728 -> 5940
    //   215: aload_3
    //   216: getfield 194	com/tencent/mobileqq/util/FaceInfo:jdField_a_of_type_AvatarInfoQQHeadInfo	LAvatarInfo/QQHeadInfo;
    //   219: astore 34
    //   221: aload 34
    //   223: ifnonnull +105 -> 328
    //   226: aload 42
    //   228: iload 5
    //   230: putfield 350	com/tencent/mobileqq/emoticon/DownloadInfo:jdField_b_of_type_Int	I
    //   233: iload 5
    //   235: istore 6
    //   237: iload 4
    //   239: ifeq -208 -> 31
    //   242: new 371	zdc
    //   245: dup
    //   246: aload_0
    //   247: invokespecial 372	zdc:<init>	(Lcom/tencent/mobileqq/app/FaceDownloader;)V
    //   250: astore_1
    //   251: aload_1
    //   252: aload_3
    //   253: putfield 375	zdc:jdField_a_of_type_ComTencentMobileqqUtilFaceInfo	Lcom/tencent/mobileqq/util/FaceInfo;
    //   256: iload 5
    //   258: ifeq +5172 -> 5430
    //   261: aload_3
    //   262: getstatic 378	com/tencent/mobileqq/util/FaceInfo:o	I
    //   265: invokevirtual 380	com/tencent/mobileqq/util/FaceInfo:a	(I)V
    //   268: aload_1
    //   269: aconst_null
    //   270: putfield 383	zdc:jdField_a_of_type_AndroidGraphicsBitmap	Landroid/graphics/Bitmap;
    //   273: aload_0
    //   274: getfield 50	com/tencent/mobileqq/app/FaceDownloader:jdField_b_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   277: aload_1
    //   278: invokevirtual 386	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   281: pop
    //   282: aload_0
    //   283: getfield 142	com/tencent/mobileqq/app/FaceDownloader:jdField_a_of_type_MqqOsMqqHandler	Lmqq/os/MqqHandler;
    //   286: bipush 100
    //   288: aload_1
    //   289: invokevirtual 392	mqq/os/MqqHandler:obtainMessage	(ILjava/lang/Object;)Landroid/os/Message;
    //   292: invokevirtual 397	android/os/Message:sendToTarget	()V
    //   295: iload 5
    //   297: ireturn
    //   298: astore 32
    //   300: aload_1
    //   301: invokestatic 401	com/tencent/mobileqq/utils/HttpDownloadUtil:a	(Ljava/lang/String;)Ljava/lang/String;
    //   304: astore_1
    //   305: goto -157 -> 148
    //   308: astore_1
    //   309: ldc 196
    //   311: iconst_1
    //   312: ldc_w 403
    //   315: invokestatic 357	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   318: aload 42
    //   320: bipush 13
    //   322: putfield 350	com/tencent/mobileqq/emoticon/DownloadInfo:jdField_b_of_type_Int	I
    //   325: bipush 13
    //   327: ireturn
    //   328: ldc_w 405
    //   331: astore 32
    //   333: aload 34
    //   335: getfield 410	AvatarInfo/QQHeadInfo:dstUsrType	B
    //   338: bipush 32
    //   340: if_icmpne +1839 -> 2179
    //   343: aload 34
    //   345: getfield 413	AvatarInfo/QQHeadInfo:originUsrType	I
    //   348: iconst_1
    //   349: if_icmpne +1812 -> 2161
    //   352: ldc_w 405
    //   355: astore 32
    //   357: new 169	java/lang/StringBuilder
    //   360: dup
    //   361: ldc_w 415
    //   364: invokespecial 416	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   367: astore 34
    //   369: aload 34
    //   371: aload 32
    //   373: invokevirtual 174	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   376: pop
    //   377: aload 33
    //   379: ldc_w 418
    //   382: bipush 8
    //   384: invokevirtual 422	java/lang/String:indexOf	(Ljava/lang/String;I)I
    //   387: istore 5
    //   389: iload 5
    //   391: bipush 8
    //   393: if_icmple +5540 -> 5933
    //   396: aload 34
    //   398: aload 33
    //   400: iload 5
    //   402: invokevirtual 425	java/lang/String:substring	(I)Ljava/lang/String;
    //   405: invokevirtual 174	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   408: pop
    //   409: aload 34
    //   411: invokevirtual 178	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   414: astore 32
    //   416: ldc 196
    //   418: iconst_1
    //   419: new 169	java/lang/StringBuilder
    //   422: dup
    //   423: invokespecial 170	java/lang/StringBuilder:<init>	()V
    //   426: ldc_w 427
    //   429: invokevirtual 174	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   432: iload 11
    //   434: invokevirtual 206	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   437: ldc_w 429
    //   440: invokevirtual 174	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   443: aload 32
    //   445: invokevirtual 174	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   448: ldc_w 431
    //   451: invokevirtual 174	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   454: aload_3
    //   455: invokevirtual 229	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   458: invokevirtual 178	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   461: invokestatic 357	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   464: aload 32
    //   466: astore 35
    //   468: iconst_5
    //   469: istore 5
    //   471: iconst_0
    //   472: istore 21
    //   474: iconst_0
    //   475: istore 22
    //   477: iconst_0
    //   478: istore 23
    //   480: iconst_0
    //   481: istore 17
    //   483: invokestatic 436	android/net/Proxy:getDefaultHost	()Ljava/lang/String;
    //   486: astore 43
    //   488: invokestatic 439	android/net/Proxy:getDefaultPort	()I
    //   491: istore 16
    //   493: aload 41
    //   495: ifnull +5429 -> 5924
    //   498: aload 41
    //   500: invokevirtual 444	android/net/NetworkInfo:getExtraInfo	()Ljava/lang/String;
    //   503: astore 32
    //   505: aload 41
    //   507: invokevirtual 447	android/net/NetworkInfo:getType	()I
    //   510: istore 12
    //   512: aload 32
    //   514: invokestatic 451	com/tencent/mobileqq/utils/httputils/PkgTools:b	(Ljava/lang/String;)Ljava/lang/String;
    //   517: astore 44
    //   519: lload 25
    //   521: lstore 27
    //   523: iload 21
    //   525: istore 19
    //   527: aload_1
    //   528: astore 36
    //   530: iload 5
    //   532: istore 7
    //   534: lload 25
    //   536: lstore 29
    //   538: iload 22
    //   540: istore 20
    //   542: aload_1
    //   543: astore 37
    //   545: iload 5
    //   547: istore 8
    //   549: aload 31
    //   551: astore 34
    //   553: iload 23
    //   555: istore 18
    //   557: aload_1
    //   558: astore 33
    //   560: iload 5
    //   562: istore 6
    //   564: aload 44
    //   566: getstatic 453	com/tencent/mobileqq/app/FaceDownloader:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   569: invokevirtual 79	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   572: ifne +164 -> 736
    //   575: iload 12
    //   577: iconst_1
    //   578: if_icmpeq +59 -> 637
    //   581: lload 25
    //   583: lstore 27
    //   585: iload 21
    //   587: istore 19
    //   589: aload_1
    //   590: astore 36
    //   592: iload 5
    //   594: istore 7
    //   596: lload 25
    //   598: lstore 29
    //   600: iload 22
    //   602: istore 20
    //   604: aload_1
    //   605: astore 37
    //   607: iload 5
    //   609: istore 8
    //   611: aload 31
    //   613: astore 34
    //   615: iload 23
    //   617: istore 18
    //   619: aload_1
    //   620: astore 33
    //   622: iload 5
    //   624: istore 6
    //   626: aload 44
    //   628: getstatic 455	com/tencent/mobileqq/utils/httputils/PkgTools:d	Ljava/lang/String;
    //   631: invokevirtual 79	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   634: ifeq +1598 -> 2232
    //   637: lload 25
    //   639: lstore 27
    //   641: iload 21
    //   643: istore 19
    //   645: aload_1
    //   646: astore 36
    //   648: iload 5
    //   650: istore 7
    //   652: lload 25
    //   654: lstore 29
    //   656: iload 22
    //   658: istore 20
    //   660: aload_1
    //   661: astore 37
    //   663: iload 5
    //   665: istore 8
    //   667: aload 31
    //   669: astore 34
    //   671: iload 23
    //   673: istore 18
    //   675: aload_1
    //   676: astore 33
    //   678: iload 5
    //   680: istore 6
    //   682: iconst_0
    //   683: putstatic 457	com/tencent/mobileqq/app/FaceDownloader:jdField_a_of_type_Boolean	Z
    //   686: lload 25
    //   688: lstore 27
    //   690: iload 21
    //   692: istore 19
    //   694: aload_1
    //   695: astore 36
    //   697: iload 5
    //   699: istore 7
    //   701: lload 25
    //   703: lstore 29
    //   705: iload 22
    //   707: istore 20
    //   709: aload_1
    //   710: astore 37
    //   712: iload 5
    //   714: istore 8
    //   716: aload 31
    //   718: astore 34
    //   720: iload 23
    //   722: istore 18
    //   724: aload_1
    //   725: astore 33
    //   727: iload 5
    //   729: istore 6
    //   731: aload 44
    //   733: putstatic 453	com/tencent/mobileqq/app/FaceDownloader:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   736: iload 12
    //   738: iconst_1
    //   739: if_icmpne +164 -> 903
    //   742: lload 25
    //   744: lstore 27
    //   746: iload 21
    //   748: istore 19
    //   750: aload_1
    //   751: astore 36
    //   753: iload 5
    //   755: istore 7
    //   757: lload 25
    //   759: lstore 29
    //   761: iload 22
    //   763: istore 20
    //   765: aload_1
    //   766: astore 37
    //   768: iload 5
    //   770: istore 8
    //   772: aload 31
    //   774: astore 34
    //   776: iload 23
    //   778: istore 18
    //   780: aload_1
    //   781: astore 33
    //   783: iload 5
    //   785: istore 6
    //   787: ldc_w 459
    //   790: aload 43
    //   792: invokevirtual 79	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   795: ifne +59 -> 854
    //   798: lload 25
    //   800: lstore 27
    //   802: iload 21
    //   804: istore 19
    //   806: aload_1
    //   807: astore 36
    //   809: iload 5
    //   811: istore 7
    //   813: lload 25
    //   815: lstore 29
    //   817: iload 22
    //   819: istore 20
    //   821: aload_1
    //   822: astore 37
    //   824: iload 5
    //   826: istore 8
    //   828: aload 31
    //   830: astore 34
    //   832: iload 23
    //   834: istore 18
    //   836: aload_1
    //   837: astore 33
    //   839: iload 5
    //   841: istore 6
    //   843: ldc_w 461
    //   846: aload 43
    //   848: invokevirtual 79	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   851: ifeq +52 -> 903
    //   854: lload 25
    //   856: lstore 27
    //   858: iload 21
    //   860: istore 19
    //   862: aload_1
    //   863: astore 36
    //   865: iload 5
    //   867: istore 7
    //   869: lload 25
    //   871: lstore 29
    //   873: iload 22
    //   875: istore 20
    //   877: aload_1
    //   878: astore 37
    //   880: iload 5
    //   882: istore 8
    //   884: aload 31
    //   886: astore 34
    //   888: iload 23
    //   890: istore 18
    //   892: aload_1
    //   893: astore 33
    //   895: iload 5
    //   897: istore 6
    //   899: iconst_1
    //   900: putstatic 457	com/tencent/mobileqq/app/FaceDownloader:jdField_a_of_type_Boolean	Z
    //   903: aload 43
    //   905: ifnull +1818 -> 2723
    //   908: iload 16
    //   910: ifle +1813 -> 2723
    //   913: lload 25
    //   915: lstore 27
    //   917: iload 21
    //   919: istore 19
    //   921: aload_1
    //   922: astore 36
    //   924: iload 5
    //   926: istore 7
    //   928: lload 25
    //   930: lstore 29
    //   932: iload 22
    //   934: istore 20
    //   936: aload_1
    //   937: astore 37
    //   939: iload 5
    //   941: istore 8
    //   943: aload 31
    //   945: astore 34
    //   947: iload 23
    //   949: istore 18
    //   951: aload_1
    //   952: astore 33
    //   954: iload 5
    //   956: istore 6
    //   958: getstatic 457	com/tencent/mobileqq/app/FaceDownloader:jdField_a_of_type_Boolean	Z
    //   961: istore 24
    //   963: iload 24
    //   965: ifne +1758 -> 2723
    //   968: iconst_1
    //   969: istore 18
    //   971: iconst_1
    //   972: istore 17
    //   974: aload 44
    //   976: getstatic 455	com/tencent/mobileqq/utils/httputils/PkgTools:d	Ljava/lang/String;
    //   979: invokevirtual 79	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   982: ifne +25 -> 1007
    //   985: aload 44
    //   987: getstatic 463	com/tencent/mobileqq/utils/httputils/PkgTools:f	Ljava/lang/String;
    //   990: invokevirtual 79	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   993: ifne +14 -> 1007
    //   996: aload 44
    //   998: getstatic 466	com/tencent/mobileqq/utils/httputils/PkgTools:h	Ljava/lang/String;
    //   1001: invokevirtual 79	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1004: ifeq +1668 -> 2672
    //   1007: iload 11
    //   1009: iconst_m1
    //   1010: if_icmpne +1645 -> 2655
    //   1013: getstatic 27	com/tencent/mobileqq/app/FaceDownloader:g	I
    //   1016: iconst_1
    //   1017: if_icmpne +1638 -> 2655
    //   1020: new 321	java/net/URL
    //   1023: dup
    //   1024: aload 35
    //   1026: invokespecial 324	java/net/URL:<init>	(Ljava/lang/String;)V
    //   1029: invokevirtual 470	java/net/URL:openConnection	()Ljava/net/URLConnection;
    //   1032: checkcast 200	java/net/HttpURLConnection
    //   1035: astore 32
    //   1037: iconst_0
    //   1038: istore 17
    //   1040: aload 32
    //   1042: astore_1
    //   1043: invokestatic 473	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   1046: ifeq +4875 -> 5921
    //   1049: ldc 196
    //   1051: iconst_4
    //   1052: new 169	java/lang/StringBuilder
    //   1055: dup
    //   1056: invokespecial 170	java/lang/StringBuilder:<init>	()V
    //   1059: ldc_w 475
    //   1062: invokevirtual 174	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1065: getstatic 27	com/tencent/mobileqq/app/FaceDownloader:g	I
    //   1068: invokevirtual 206	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1071: ldc_w 477
    //   1074: invokevirtual 174	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1077: iload 11
    //   1079: invokevirtual 206	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1082: invokevirtual 178	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1085: invokestatic 235	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   1088: lload 25
    //   1090: lstore 27
    //   1092: iload 17
    //   1094: istore 19
    //   1096: aload_1
    //   1097: astore 36
    //   1099: iload 5
    //   1101: istore 7
    //   1103: lload 25
    //   1105: lstore 29
    //   1107: iload 17
    //   1109: istore 20
    //   1111: aload_1
    //   1112: astore 37
    //   1114: iload 5
    //   1116: istore 8
    //   1118: aload 31
    //   1120: astore 34
    //   1122: iload 17
    //   1124: istore 18
    //   1126: aload_1
    //   1127: astore 33
    //   1129: iload 5
    //   1131: istore 6
    //   1133: aload_1
    //   1134: ldc_w 479
    //   1137: ldc_w 481
    //   1140: invokevirtual 485	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   1143: lload 25
    //   1145: lstore 27
    //   1147: iload 17
    //   1149: istore 19
    //   1151: aload_1
    //   1152: astore 36
    //   1154: iload 5
    //   1156: istore 7
    //   1158: lload 25
    //   1160: lstore 29
    //   1162: iload 17
    //   1164: istore 20
    //   1166: aload_1
    //   1167: astore 37
    //   1169: iload 5
    //   1171: istore 8
    //   1173: aload 31
    //   1175: astore 34
    //   1177: iload 17
    //   1179: istore 18
    //   1181: aload_1
    //   1182: astore 33
    //   1184: iload 5
    //   1186: istore 6
    //   1188: aload_1
    //   1189: sipush 30000
    //   1192: invokevirtual 488	java/net/HttpURLConnection:setConnectTimeout	(I)V
    //   1195: lload 25
    //   1197: lstore 27
    //   1199: iload 17
    //   1201: istore 19
    //   1203: aload_1
    //   1204: astore 36
    //   1206: iload 5
    //   1208: istore 7
    //   1210: lload 25
    //   1212: lstore 29
    //   1214: iload 17
    //   1216: istore 20
    //   1218: aload_1
    //   1219: astore 37
    //   1221: iload 5
    //   1223: istore 8
    //   1225: aload 31
    //   1227: astore 34
    //   1229: iload 17
    //   1231: istore 18
    //   1233: aload_1
    //   1234: astore 33
    //   1236: iload 5
    //   1238: istore 6
    //   1240: aload_1
    //   1241: sipush 30000
    //   1244: invokevirtual 491	java/net/HttpURLConnection:setReadTimeout	(I)V
    //   1247: lload 25
    //   1249: lstore 27
    //   1251: iload 17
    //   1253: istore 19
    //   1255: aload_1
    //   1256: astore 36
    //   1258: iload 5
    //   1260: istore 7
    //   1262: lload 25
    //   1264: lstore 29
    //   1266: iload 17
    //   1268: istore 20
    //   1270: aload_1
    //   1271: astore 37
    //   1273: iload 5
    //   1275: istore 8
    //   1277: aload 31
    //   1279: astore 34
    //   1281: iload 17
    //   1283: istore 18
    //   1285: aload_1
    //   1286: astore 33
    //   1288: iload 5
    //   1290: istore 6
    //   1292: aload_1
    //   1293: iconst_1
    //   1294: invokevirtual 495	java/net/HttpURLConnection:setInstanceFollowRedirects	(Z)V
    //   1297: lload 25
    //   1299: lstore 27
    //   1301: iload 17
    //   1303: istore 19
    //   1305: aload_1
    //   1306: astore 36
    //   1308: iload 5
    //   1310: istore 7
    //   1312: aload 31
    //   1314: astore 34
    //   1316: iload 17
    //   1318: istore 18
    //   1320: aload_1
    //   1321: astore 33
    //   1323: iload 5
    //   1325: istore 6
    //   1327: aload_1
    //   1328: invokevirtual 498	java/net/HttpURLConnection:connect	()V
    //   1331: lload 25
    //   1333: lstore 27
    //   1335: iload 17
    //   1337: istore 19
    //   1339: aload_1
    //   1340: astore 36
    //   1342: iload 5
    //   1344: istore 7
    //   1346: aload 31
    //   1348: astore 34
    //   1350: iload 17
    //   1352: istore 18
    //   1354: aload_1
    //   1355: astore 33
    //   1357: iload 5
    //   1359: istore 6
    //   1361: aload 42
    //   1363: aload_1
    //   1364: invokevirtual 203	java/net/HttpURLConnection:getResponseCode	()I
    //   1367: putfield 499	com/tencent/mobileqq/emoticon/DownloadInfo:c	I
    //   1370: lload 25
    //   1372: lstore 27
    //   1374: iload 17
    //   1376: istore 19
    //   1378: aload_1
    //   1379: astore 36
    //   1381: iload 5
    //   1383: istore 7
    //   1385: aload 31
    //   1387: astore 34
    //   1389: iload 17
    //   1391: istore 18
    //   1393: aload_1
    //   1394: astore 33
    //   1396: iload 5
    //   1398: istore 6
    //   1400: aload 42
    //   1402: aload_1
    //   1403: invokevirtual 214	java/net/HttpURLConnection:getContentLength	()I
    //   1406: putfield 500	com/tencent/mobileqq/emoticon/DownloadInfo:e	I
    //   1409: lload 25
    //   1411: lstore 27
    //   1413: iload 17
    //   1415: istore 19
    //   1417: aload_1
    //   1418: astore 36
    //   1420: iload 5
    //   1422: istore 7
    //   1424: aload 31
    //   1426: astore 34
    //   1428: iload 17
    //   1430: istore 18
    //   1432: aload_1
    //   1433: astore 33
    //   1435: iload 5
    //   1437: istore 6
    //   1439: aload 42
    //   1441: aload_1
    //   1442: invokevirtual 211	java/net/HttpURLConnection:getContentType	()Ljava/lang/String;
    //   1445: putfield 501	com/tencent/mobileqq/emoticon/DownloadInfo:h	Ljava/lang/String;
    //   1448: lload 25
    //   1450: lstore 27
    //   1452: iload 17
    //   1454: istore 19
    //   1456: aload_1
    //   1457: astore 36
    //   1459: iload 5
    //   1461: istore 7
    //   1463: aload 31
    //   1465: astore 34
    //   1467: iload 17
    //   1469: istore 18
    //   1471: aload_1
    //   1472: astore 33
    //   1474: iload 5
    //   1476: istore 6
    //   1478: aload 42
    //   1480: aload_1
    //   1481: invokevirtual 504	java/net/HttpURLConnection:getContentEncoding	()Ljava/lang/String;
    //   1484: putfield 506	com/tencent/mobileqq/emoticon/DownloadInfo:i	Ljava/lang/String;
    //   1487: lload 25
    //   1489: lstore 27
    //   1491: iload 17
    //   1493: istore 19
    //   1495: aload_1
    //   1496: astore 36
    //   1498: iload 5
    //   1500: istore 7
    //   1502: aload 31
    //   1504: astore 34
    //   1506: iload 17
    //   1508: istore 18
    //   1510: aload_1
    //   1511: astore 33
    //   1513: iload 5
    //   1515: istore 6
    //   1517: aload 42
    //   1519: aload_1
    //   1520: ldc 226
    //   1522: invokevirtual 220	java/net/HttpURLConnection:getHeaderField	(Ljava/lang/String;)Ljava/lang/String;
    //   1525: putfield 507	com/tencent/mobileqq/emoticon/DownloadInfo:f	Ljava/lang/String;
    //   1528: lload 25
    //   1530: lstore 27
    //   1532: iload 17
    //   1534: istore 19
    //   1536: aload_1
    //   1537: astore 36
    //   1539: iload 5
    //   1541: istore 7
    //   1543: aload 31
    //   1545: astore 34
    //   1547: iload 17
    //   1549: istore 18
    //   1551: aload_1
    //   1552: astore 33
    //   1554: iload 5
    //   1556: istore 6
    //   1558: aload_1
    //   1559: ldc 222
    //   1561: invokevirtual 220	java/net/HttpURLConnection:getHeaderField	(Ljava/lang/String;)Ljava/lang/String;
    //   1564: astore 32
    //   1566: lload 25
    //   1568: lstore 27
    //   1570: iload 17
    //   1572: istore 19
    //   1574: aload_1
    //   1575: astore 36
    //   1577: iload 5
    //   1579: istore 7
    //   1581: lload 25
    //   1583: lstore 29
    //   1585: iload 17
    //   1587: istore 20
    //   1589: aload_1
    //   1590: astore 37
    //   1592: iload 5
    //   1594: istore 8
    //   1596: aload 31
    //   1598: astore 34
    //   1600: iload 17
    //   1602: istore 18
    //   1604: aload_1
    //   1605: astore 33
    //   1607: iload 5
    //   1609: istore 6
    //   1611: aload 32
    //   1613: invokestatic 71	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   1616: ifne +1996 -> 3612
    //   1619: lload 25
    //   1621: lstore 27
    //   1623: iload 17
    //   1625: istore 19
    //   1627: aload_1
    //   1628: astore 36
    //   1630: iload 5
    //   1632: istore 7
    //   1634: lload 25
    //   1636: lstore 29
    //   1638: iload 17
    //   1640: istore 20
    //   1642: aload_1
    //   1643: astore 37
    //   1645: iload 5
    //   1647: istore 8
    //   1649: aload 31
    //   1651: astore 34
    //   1653: iload 17
    //   1655: istore 18
    //   1657: aload_1
    //   1658: astore 33
    //   1660: iload 5
    //   1662: istore 6
    //   1664: ldc 196
    //   1666: iconst_1
    //   1667: new 169	java/lang/StringBuilder
    //   1670: dup
    //   1671: invokespecial 170	java/lang/StringBuilder:<init>	()V
    //   1674: ldc_w 509
    //   1677: invokevirtual 174	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1680: aload 32
    //   1682: invokevirtual 174	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1685: invokevirtual 178	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1688: invokestatic 235	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   1691: lload 25
    //   1693: lstore 27
    //   1695: iload 17
    //   1697: istore 19
    //   1699: aload_1
    //   1700: astore 36
    //   1702: iload 5
    //   1704: istore 7
    //   1706: lload 25
    //   1708: lstore 29
    //   1710: iload 17
    //   1712: istore 20
    //   1714: aload_1
    //   1715: astore 37
    //   1717: iload 5
    //   1719: istore 8
    //   1721: aload 31
    //   1723: astore 34
    //   1725: iload 17
    //   1727: istore 18
    //   1729: aload_1
    //   1730: astore 33
    //   1732: iload 5
    //   1734: istore 6
    //   1736: aload_0
    //   1737: aload_1
    //   1738: aload_3
    //   1739: invokespecial 511	com/tencent/mobileqq/app/FaceDownloader:a	(Ljava/net/HttpURLConnection;Lcom/tencent/mobileqq/util/FaceInfo;)V
    //   1742: iconst_0
    //   1743: istore 13
    //   1745: iconst_0
    //   1746: istore 9
    //   1748: iconst_0
    //   1749: istore 14
    //   1751: iconst_0
    //   1752: istore 10
    //   1754: iconst_0
    //   1755: istore 5
    //   1757: lload 25
    //   1759: lstore 27
    //   1761: iload 17
    //   1763: istore 19
    //   1765: aload_1
    //   1766: astore 36
    //   1768: iload 5
    //   1770: istore 7
    //   1772: lload 25
    //   1774: lstore 29
    //   1776: iload 17
    //   1778: istore 20
    //   1780: aload_1
    //   1781: astore 37
    //   1783: iload 13
    //   1785: istore 8
    //   1787: aload 31
    //   1789: astore 34
    //   1791: iload 17
    //   1793: istore 18
    //   1795: aload_1
    //   1796: astore 33
    //   1798: iload 14
    //   1800: istore 6
    //   1802: sipush 200
    //   1805: aload 42
    //   1807: getfield 499	com/tencent/mobileqq/emoticon/DownloadInfo:c	I
    //   1810: if_icmpne +3163 -> 4973
    //   1813: lload 25
    //   1815: lstore 27
    //   1817: iload 17
    //   1819: istore 19
    //   1821: aload_1
    //   1822: astore 36
    //   1824: iload 5
    //   1826: istore 7
    //   1828: lload 25
    //   1830: lstore 29
    //   1832: iload 17
    //   1834: istore 20
    //   1836: aload_1
    //   1837: astore 37
    //   1839: iload 13
    //   1841: istore 8
    //   1843: aload 31
    //   1845: astore 34
    //   1847: iload 17
    //   1849: istore 18
    //   1851: aload_1
    //   1852: astore 33
    //   1854: iload 14
    //   1856: istore 6
    //   1858: aload 42
    //   1860: getfield 500	com/tencent/mobileqq/emoticon/DownloadInfo:e	I
    //   1863: istore 15
    //   1865: iload 15
    //   1867: i2l
    //   1868: lstore 25
    //   1870: iconst_0
    //   1871: istore 15
    //   1873: lload 25
    //   1875: lstore 27
    //   1877: iload 17
    //   1879: istore 19
    //   1881: aload_1
    //   1882: astore 36
    //   1884: iload 5
    //   1886: istore 7
    //   1888: lload 25
    //   1890: lstore 29
    //   1892: iload 17
    //   1894: istore 20
    //   1896: aload_1
    //   1897: astore 37
    //   1899: iload 13
    //   1901: istore 8
    //   1903: aload 31
    //   1905: astore 34
    //   1907: iload 17
    //   1909: istore 18
    //   1911: aload_1
    //   1912: astore 33
    //   1914: iload 14
    //   1916: istore 6
    //   1918: aload 40
    //   1920: invokevirtual 339	java/io/File:exists	()Z
    //   1923: ifeq +54 -> 1977
    //   1926: lload 25
    //   1928: lstore 27
    //   1930: iload 17
    //   1932: istore 19
    //   1934: aload_1
    //   1935: astore 36
    //   1937: iload 5
    //   1939: istore 7
    //   1941: lload 25
    //   1943: lstore 29
    //   1945: iload 17
    //   1947: istore 20
    //   1949: aload_1
    //   1950: astore 37
    //   1952: iload 13
    //   1954: istore 8
    //   1956: aload 31
    //   1958: astore 34
    //   1960: iload 17
    //   1962: istore 18
    //   1964: aload_1
    //   1965: astore 33
    //   1967: iload 14
    //   1969: istore 6
    //   1971: aload 40
    //   1973: invokevirtual 369	java/io/File:delete	()Z
    //   1976: pop
    //   1977: lload 25
    //   1979: lstore 27
    //   1981: iload 17
    //   1983: istore 19
    //   1985: aload_1
    //   1986: astore 36
    //   1988: iload 5
    //   1990: istore 7
    //   1992: lload 25
    //   1994: lstore 29
    //   1996: iload 17
    //   1998: istore 20
    //   2000: aload_1
    //   2001: astore 37
    //   2003: iload 13
    //   2005: istore 8
    //   2007: aload 31
    //   2009: astore 34
    //   2011: iload 17
    //   2013: istore 18
    //   2015: aload_1
    //   2016: astore 33
    //   2018: iload 14
    //   2020: istore 6
    //   2022: aload 40
    //   2024: invokevirtual 514	java/io/File:createNewFile	()Z
    //   2027: pop
    //   2028: lload 25
    //   2030: lstore 27
    //   2032: iload 17
    //   2034: istore 19
    //   2036: aload_1
    //   2037: astore 36
    //   2039: iload 5
    //   2041: istore 7
    //   2043: lload 25
    //   2045: lstore 29
    //   2047: iload 17
    //   2049: istore 20
    //   2051: aload_1
    //   2052: astore 37
    //   2054: iload 13
    //   2056: istore 8
    //   2058: aload 31
    //   2060: astore 34
    //   2062: iload 17
    //   2064: istore 18
    //   2066: aload_1
    //   2067: astore 33
    //   2069: iload 14
    //   2071: istore 6
    //   2073: new 516	java/io/BufferedOutputStream
    //   2076: dup
    //   2077: new 518	java/io/FileOutputStream
    //   2080: dup
    //   2081: aload 40
    //   2083: invokespecial 521	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   2086: invokespecial 524	java/io/BufferedOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   2089: astore 32
    //   2091: aload_1
    //   2092: invokevirtual 528	java/net/HttpURLConnection:getInputStream	()Ljava/io/InputStream;
    //   2095: astore 31
    //   2097: iload 4
    //   2099: ifeq +2743 -> 4842
    //   2102: lload 25
    //   2104: ldc2_w 529
    //   2107: lcmp
    //   2108: ifge +2734 -> 4842
    //   2111: ldc_w 531
    //   2114: newarray byte
    //   2116: astore 34
    //   2118: iconst_0
    //   2119: istore 5
    //   2121: iconst_0
    //   2122: istore 6
    //   2124: aload 31
    //   2126: aload 34
    //   2128: iload 6
    //   2130: sipush 1024
    //   2133: invokevirtual 537	java/io/InputStream:read	([BII)I
    //   2136: istore 7
    //   2138: iload 7
    //   2140: iconst_m1
    //   2141: if_icmpeq +2068 -> 4209
    //   2144: iload 6
    //   2146: iload 7
    //   2148: iadd
    //   2149: istore 6
    //   2151: iload 7
    //   2153: iload 5
    //   2155: iadd
    //   2156: istore 5
    //   2158: goto -34 -> 2124
    //   2161: aload 34
    //   2163: getfield 413	AvatarInfo/QQHeadInfo:originUsrType	I
    //   2166: bipush 32
    //   2168: if_icmpne -1811 -> 357
    //   2171: ldc_w 539
    //   2174: astore 32
    //   2176: goto -1819 -> 357
    //   2179: aload 34
    //   2181: getfield 410	AvatarInfo/QQHeadInfo:dstUsrType	B
    //   2184: bipush 16
    //   2186: if_icmpne +11 -> 2197
    //   2189: ldc_w 405
    //   2192: astore 32
    //   2194: goto -1837 -> 357
    //   2197: aload 34
    //   2199: getfield 410	AvatarInfo/QQHeadInfo:dstUsrType	B
    //   2202: iconst_4
    //   2203: if_icmpeq +13 -> 2216
    //   2206: aload 34
    //   2208: getfield 410	AvatarInfo/QQHeadInfo:dstUsrType	B
    //   2211: bipush 8
    //   2213: if_icmpne +11 -> 2224
    //   2216: ldc_w 539
    //   2219: astore 32
    //   2221: goto -1864 -> 357
    //   2224: ldc_w 405
    //   2227: astore 32
    //   2229: goto -1872 -> 357
    //   2232: lload 25
    //   2234: lstore 27
    //   2236: iload 21
    //   2238: istore 19
    //   2240: aload_1
    //   2241: astore 36
    //   2243: iload 5
    //   2245: istore 7
    //   2247: lload 25
    //   2249: lstore 29
    //   2251: iload 22
    //   2253: istore 20
    //   2255: aload_1
    //   2256: astore 37
    //   2258: iload 5
    //   2260: istore 8
    //   2262: aload 31
    //   2264: astore 34
    //   2266: iload 23
    //   2268: istore 18
    //   2270: aload_1
    //   2271: astore 33
    //   2273: iload 5
    //   2275: istore 6
    //   2277: iconst_1
    //   2278: putstatic 457	com/tencent/mobileqq/app/FaceDownloader:jdField_a_of_type_Boolean	Z
    //   2281: goto -1595 -> 686
    //   2284: astore 32
    //   2286: iload 19
    //   2288: istore 17
    //   2290: lload 27
    //   2292: lstore 25
    //   2294: aload 36
    //   2296: astore_1
    //   2297: iload 7
    //   2299: istore 5
    //   2301: iload 5
    //   2303: istore 6
    //   2305: ldc 196
    //   2307: iconst_1
    //   2308: new 169	java/lang/StringBuilder
    //   2311: dup
    //   2312: invokespecial 170	java/lang/StringBuilder:<init>	()V
    //   2315: ldc_w 541
    //   2318: invokevirtual 174	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2321: aload 39
    //   2323: invokevirtual 229	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   2326: ldc_w 431
    //   2329: invokevirtual 174	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2332: aload_3
    //   2333: invokevirtual 229	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   2336: invokevirtual 178	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2339: aload 32
    //   2341: invokestatic 544	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   2344: iload 5
    //   2346: istore 6
    //   2348: aload 32
    //   2350: instanceof 546
    //   2353: istore 18
    //   2355: iload 18
    //   2357: ifeq +2679 -> 5036
    //   2360: bipush 10
    //   2362: istore 5
    //   2364: aload_1
    //   2365: ifnull +7 -> 2372
    //   2368: aload_1
    //   2369: invokevirtual 549	java/net/HttpURLConnection:disconnect	()V
    //   2372: aload 31
    //   2374: ifnull +8 -> 2382
    //   2377: aload 31
    //   2379: invokevirtual 554	java/io/OutputStream:close	()V
    //   2382: iload 5
    //   2384: ifeq +76 -> 2460
    //   2387: aload 40
    //   2389: ifnull +71 -> 2460
    //   2392: aload 40
    //   2394: invokevirtual 336	java/io/File:getParentFile	()Ljava/io/File;
    //   2397: astore 32
    //   2399: aload 32
    //   2401: ifnull +17 -> 2418
    //   2404: aload 32
    //   2406: invokevirtual 339	java/io/File:exists	()Z
    //   2409: ifne +9 -> 2418
    //   2412: aload 32
    //   2414: invokevirtual 342	java/io/File:mkdirs	()Z
    //   2417: pop
    //   2418: aload 40
    //   2420: invokevirtual 339	java/io/File:exists	()Z
    //   2423: ifeq +37 -> 2460
    //   2426: aload 40
    //   2428: invokevirtual 369	java/io/File:delete	()Z
    //   2431: istore 18
    //   2433: ldc 196
    //   2435: iconst_1
    //   2436: new 169	java/lang/StringBuilder
    //   2439: dup
    //   2440: invokespecial 170	java/lang/StringBuilder:<init>	()V
    //   2443: ldc_w 556
    //   2446: invokevirtual 174	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2449: iload 18
    //   2451: invokevirtual 559	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   2454: invokevirtual 178	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2457: invokestatic 235	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   2460: iload 11
    //   2462: iconst_1
    //   2463: iadd
    //   2464: istore 6
    //   2466: iload 5
    //   2468: ifeq +141 -> 2609
    //   2471: ldc 196
    //   2473: iconst_1
    //   2474: new 169	java/lang/StringBuilder
    //   2477: dup
    //   2478: invokespecial 170	java/lang/StringBuilder:<init>	()V
    //   2481: ldc_w 561
    //   2484: invokevirtual 174	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2487: iload 5
    //   2489: invokevirtual 206	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   2492: ldc_w 563
    //   2495: invokevirtual 174	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2498: aload 39
    //   2500: invokevirtual 229	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   2503: ldc_w 477
    //   2506: invokevirtual 174	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2509: iload 6
    //   2511: invokevirtual 206	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   2514: ldc_w 431
    //   2517: invokevirtual 174	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2520: aload_3
    //   2521: invokevirtual 229	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   2524: ldc_w 565
    //   2527: invokevirtual 174	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2530: iload 17
    //   2532: invokevirtual 559	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   2535: ldc_w 567
    //   2538: invokevirtual 174	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2541: aload 43
    //   2543: invokevirtual 174	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2546: ldc_w 569
    //   2549: invokevirtual 174	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2552: iload 16
    //   2554: invokevirtual 206	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   2557: ldc_w 571
    //   2560: invokevirtual 174	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2563: getstatic 457	com/tencent/mobileqq/app/FaceDownloader:jdField_a_of_type_Boolean	Z
    //   2566: invokevirtual 559	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   2569: ldc_w 573
    //   2572: invokevirtual 174	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2575: iload 12
    //   2577: invokevirtual 206	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   2580: ldc_w 575
    //   2583: invokevirtual 174	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2586: aload 44
    //   2588: invokevirtual 174	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2591: ldc_w 577
    //   2594: invokevirtual 174	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2597: getstatic 27	com/tencent/mobileqq/app/FaceDownloader:g	I
    //   2600: invokevirtual 206	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   2603: invokevirtual 178	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2606: invokestatic 235	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   2609: iload 5
    //   2611: ifeq +3354 -> 5965
    //   2614: iload 6
    //   2616: iconst_2
    //   2617: if_icmpge +3348 -> 5965
    //   2620: aload 38
    //   2622: monitorenter
    //   2623: aload 38
    //   2625: ldc2_w 578
    //   2628: invokevirtual 583	java/lang/Object:wait	(J)V
    //   2631: aload 38
    //   2633: monitorexit
    //   2634: aload_1
    //   2635: astore 32
    //   2637: aload 31
    //   2639: astore 34
    //   2641: iload 5
    //   2643: ifeq +9 -> 2652
    //   2646: iload 6
    //   2648: iconst_2
    //   2649: if_icmplt +3298 -> 5947
    //   2652: goto -2426 -> 226
    //   2655: aload 35
    //   2657: aload 43
    //   2659: iload 16
    //   2661: invokestatic 586	com/tencent/mobileqq/utils/httputils/PkgTools:b	(Ljava/lang/String;Ljava/lang/String;I)Ljava/net/HttpURLConnection;
    //   2664: astore 32
    //   2666: aload 32
    //   2668: astore_1
    //   2669: goto -1626 -> 1043
    //   2672: aload 44
    //   2674: getstatic 588	com/tencent/mobileqq/utils/httputils/PkgTools:b	Ljava/lang/String;
    //   2677: invokevirtual 79	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   2680: ifeq +23 -> 2703
    //   2683: aload 35
    //   2685: aload 43
    //   2687: iload 16
    //   2689: invokestatic 590	com/tencent/mobileqq/utils/httputils/PkgTools:a	(Ljava/lang/String;Ljava/lang/String;I)Ljava/net/HttpURLConnection;
    //   2692: astore 32
    //   2694: iconst_1
    //   2695: istore 17
    //   2697: aload 32
    //   2699: astore_1
    //   2700: goto -1612 -> 1088
    //   2703: aload 35
    //   2705: aload 43
    //   2707: iload 16
    //   2709: invokestatic 590	com/tencent/mobileqq/utils/httputils/PkgTools:a	(Ljava/lang/String;Ljava/lang/String;I)Ljava/net/HttpURLConnection;
    //   2712: astore 32
    //   2714: aload 32
    //   2716: astore_1
    //   2717: iconst_1
    //   2718: istore 17
    //   2720: goto -1632 -> 1088
    //   2723: lload 25
    //   2725: lstore 27
    //   2727: iload 21
    //   2729: istore 19
    //   2731: aload_1
    //   2732: astore 36
    //   2734: iload 5
    //   2736: istore 7
    //   2738: lload 25
    //   2740: lstore 29
    //   2742: iload 22
    //   2744: istore 20
    //   2746: aload_1
    //   2747: astore 37
    //   2749: iload 5
    //   2751: istore 8
    //   2753: aload 31
    //   2755: astore 34
    //   2757: iload 23
    //   2759: istore 18
    //   2761: aload_1
    //   2762: astore 33
    //   2764: iload 5
    //   2766: istore 6
    //   2768: new 321	java/net/URL
    //   2771: dup
    //   2772: aload 35
    //   2774: invokespecial 324	java/net/URL:<init>	(Ljava/lang/String;)V
    //   2777: invokevirtual 470	java/net/URL:openConnection	()Ljava/net/URLConnection;
    //   2780: checkcast 200	java/net/HttpURLConnection
    //   2783: astore_1
    //   2784: goto -1696 -> 1088
    //   2787: astore 32
    //   2789: iload 17
    //   2791: ifeq +475 -> 3266
    //   2794: lload 25
    //   2796: lstore 27
    //   2798: iload 17
    //   2800: istore 19
    //   2802: aload_1
    //   2803: astore 36
    //   2805: iload 5
    //   2807: istore 7
    //   2809: lload 25
    //   2811: lstore 29
    //   2813: iload 17
    //   2815: istore 20
    //   2817: aload_1
    //   2818: astore 37
    //   2820: iload 5
    //   2822: istore 8
    //   2824: aload 31
    //   2826: astore 34
    //   2828: iload 17
    //   2830: istore 18
    //   2832: aload_1
    //   2833: astore 33
    //   2835: iload 5
    //   2837: istore 6
    //   2839: iconst_1
    //   2840: putstatic 457	com/tencent/mobileqq/app/FaceDownloader:jdField_a_of_type_Boolean	Z
    //   2843: lload 25
    //   2845: lstore 27
    //   2847: iload 17
    //   2849: istore 19
    //   2851: aload_1
    //   2852: astore 36
    //   2854: iload 5
    //   2856: istore 7
    //   2858: lload 25
    //   2860: lstore 29
    //   2862: iload 17
    //   2864: istore 20
    //   2866: aload_1
    //   2867: astore 37
    //   2869: iload 5
    //   2871: istore 8
    //   2873: aload 31
    //   2875: astore 34
    //   2877: iload 17
    //   2879: istore 18
    //   2881: aload_1
    //   2882: astore 33
    //   2884: iload 5
    //   2886: istore 6
    //   2888: aload 32
    //   2890: athrow
    //   2891: astore 32
    //   2893: iload 8
    //   2895: istore 5
    //   2897: aload 37
    //   2899: astore_1
    //   2900: iload 20
    //   2902: istore 17
    //   2904: lload 29
    //   2906: lstore 27
    //   2908: aload 31
    //   2910: astore 34
    //   2912: iload 17
    //   2914: istore 18
    //   2916: aload_1
    //   2917: astore 33
    //   2919: iload 5
    //   2921: istore 6
    //   2923: ldc 196
    //   2925: iconst_1
    //   2926: new 169	java/lang/StringBuilder
    //   2929: dup
    //   2930: invokespecial 170	java/lang/StringBuilder:<init>	()V
    //   2933: ldc_w 592
    //   2936: invokevirtual 174	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2939: aload 39
    //   2941: invokevirtual 229	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   2944: ldc_w 431
    //   2947: invokevirtual 174	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2950: aload_3
    //   2951: invokevirtual 229	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   2954: invokevirtual 178	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2957: aload 32
    //   2959: invokestatic 544	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   2962: iconst_5
    //   2963: istore 7
    //   2965: aload_1
    //   2966: ifnull +7 -> 2973
    //   2969: aload_1
    //   2970: invokevirtual 549	java/net/HttpURLConnection:disconnect	()V
    //   2973: aload 31
    //   2975: ifnull +8 -> 2983
    //   2978: aload 31
    //   2980: invokevirtual 554	java/io/OutputStream:close	()V
    //   2983: aload 40
    //   2985: ifnull +71 -> 3056
    //   2988: aload 40
    //   2990: invokevirtual 336	java/io/File:getParentFile	()Ljava/io/File;
    //   2993: astore 32
    //   2995: aload 32
    //   2997: ifnull +17 -> 3014
    //   3000: aload 32
    //   3002: invokevirtual 339	java/io/File:exists	()Z
    //   3005: ifne +9 -> 3014
    //   3008: aload 32
    //   3010: invokevirtual 342	java/io/File:mkdirs	()Z
    //   3013: pop
    //   3014: aload 40
    //   3016: invokevirtual 339	java/io/File:exists	()Z
    //   3019: ifeq +37 -> 3056
    //   3022: aload 40
    //   3024: invokevirtual 369	java/io/File:delete	()Z
    //   3027: istore 18
    //   3029: ldc 196
    //   3031: iconst_1
    //   3032: new 169	java/lang/StringBuilder
    //   3035: dup
    //   3036: invokespecial 170	java/lang/StringBuilder:<init>	()V
    //   3039: ldc_w 556
    //   3042: invokevirtual 174	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3045: iload 18
    //   3047: invokevirtual 559	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   3050: invokevirtual 178	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3053: invokestatic 235	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   3056: iload 11
    //   3058: iconst_1
    //   3059: iadd
    //   3060: istore 8
    //   3062: ldc 196
    //   3064: iconst_1
    //   3065: new 169	java/lang/StringBuilder
    //   3068: dup
    //   3069: invokespecial 170	java/lang/StringBuilder:<init>	()V
    //   3072: ldc_w 561
    //   3075: invokevirtual 174	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3078: iconst_5
    //   3079: invokevirtual 206	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   3082: ldc_w 563
    //   3085: invokevirtual 174	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3088: aload 39
    //   3090: invokevirtual 229	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   3093: ldc_w 477
    //   3096: invokevirtual 174	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3099: iload 8
    //   3101: invokevirtual 206	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   3104: ldc_w 431
    //   3107: invokevirtual 174	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3110: aload_3
    //   3111: invokevirtual 229	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   3114: ldc_w 565
    //   3117: invokevirtual 174	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3120: iload 17
    //   3122: invokevirtual 559	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   3125: ldc_w 567
    //   3128: invokevirtual 174	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3131: aload 43
    //   3133: invokevirtual 174	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3136: ldc_w 569
    //   3139: invokevirtual 174	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3142: iload 16
    //   3144: invokevirtual 206	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   3147: ldc_w 571
    //   3150: invokevirtual 174	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3153: getstatic 457	com/tencent/mobileqq/app/FaceDownloader:jdField_a_of_type_Boolean	Z
    //   3156: invokevirtual 559	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   3159: ldc_w 573
    //   3162: invokevirtual 174	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3165: iload 12
    //   3167: invokevirtual 206	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   3170: ldc_w 575
    //   3173: invokevirtual 174	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3176: aload 44
    //   3178: invokevirtual 174	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3181: ldc_w 577
    //   3184: invokevirtual 174	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3187: getstatic 27	com/tencent/mobileqq/app/FaceDownloader:g	I
    //   3190: invokevirtual 206	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   3193: invokevirtual 178	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3196: invokestatic 235	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   3199: iload 7
    //   3201: istore 5
    //   3203: iload 8
    //   3205: istore 6
    //   3207: lload 27
    //   3209: lstore 25
    //   3211: aload 31
    //   3213: astore 34
    //   3215: aload_1
    //   3216: astore 32
    //   3218: iload 8
    //   3220: iconst_2
    //   3221: if_icmpge -580 -> 2641
    //   3224: aload 38
    //   3226: monitorenter
    //   3227: aload 38
    //   3229: ldc2_w 578
    //   3232: invokevirtual 583	java/lang/Object:wait	(J)V
    //   3235: aload 38
    //   3237: monitorexit
    //   3238: iload 7
    //   3240: istore 5
    //   3242: iload 8
    //   3244: istore 6
    //   3246: lload 27
    //   3248: lstore 25
    //   3250: aload 31
    //   3252: astore 34
    //   3254: aload_1
    //   3255: astore 32
    //   3257: goto -616 -> 2641
    //   3260: astore_1
    //   3261: aload 38
    //   3263: monitorexit
    //   3264: aload_1
    //   3265: athrow
    //   3266: aload 43
    //   3268: ifnull -425 -> 2843
    //   3271: iload 16
    //   3273: ifle -430 -> 2843
    //   3276: lload 25
    //   3278: lstore 27
    //   3280: iload 17
    //   3282: istore 19
    //   3284: aload_1
    //   3285: astore 36
    //   3287: iload 5
    //   3289: istore 7
    //   3291: lload 25
    //   3293: lstore 29
    //   3295: iload 17
    //   3297: istore 20
    //   3299: aload_1
    //   3300: astore 37
    //   3302: iload 5
    //   3304: istore 8
    //   3306: aload 31
    //   3308: astore 34
    //   3310: iload 17
    //   3312: istore 18
    //   3314: aload_1
    //   3315: astore 33
    //   3317: iload 5
    //   3319: istore 6
    //   3321: iconst_0
    //   3322: putstatic 457	com/tencent/mobileqq/app/FaceDownloader:jdField_a_of_type_Boolean	Z
    //   3325: goto -482 -> 2843
    //   3328: astore_2
    //   3329: iload 6
    //   3331: istore 5
    //   3333: aload 33
    //   3335: astore_1
    //   3336: iload 18
    //   3338: istore 17
    //   3340: aload 34
    //   3342: astore 31
    //   3344: aload_1
    //   3345: ifnull +7 -> 3352
    //   3348: aload_1
    //   3349: invokevirtual 549	java/net/HttpURLConnection:disconnect	()V
    //   3352: aload 31
    //   3354: ifnull +8 -> 3362
    //   3357: aload 31
    //   3359: invokevirtual 554	java/io/OutputStream:close	()V
    //   3362: iload 5
    //   3364: ifeq +72 -> 3436
    //   3367: aload 40
    //   3369: ifnull +67 -> 3436
    //   3372: aload 40
    //   3374: invokevirtual 336	java/io/File:getParentFile	()Ljava/io/File;
    //   3377: astore_1
    //   3378: aload_1
    //   3379: ifnull +15 -> 3394
    //   3382: aload_1
    //   3383: invokevirtual 339	java/io/File:exists	()Z
    //   3386: ifne +8 -> 3394
    //   3389: aload_1
    //   3390: invokevirtual 342	java/io/File:mkdirs	()Z
    //   3393: pop
    //   3394: aload 40
    //   3396: invokevirtual 339	java/io/File:exists	()Z
    //   3399: ifeq +37 -> 3436
    //   3402: aload 40
    //   3404: invokevirtual 369	java/io/File:delete	()Z
    //   3407: istore 4
    //   3409: ldc 196
    //   3411: iconst_1
    //   3412: new 169	java/lang/StringBuilder
    //   3415: dup
    //   3416: invokespecial 170	java/lang/StringBuilder:<init>	()V
    //   3419: ldc_w 556
    //   3422: invokevirtual 174	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3425: iload 4
    //   3427: invokevirtual 559	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   3430: invokevirtual 178	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3433: invokestatic 235	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   3436: iload 11
    //   3438: iconst_1
    //   3439: iadd
    //   3440: istore 6
    //   3442: iload 5
    //   3444: ifeq +141 -> 3585
    //   3447: ldc 196
    //   3449: iconst_1
    //   3450: new 169	java/lang/StringBuilder
    //   3453: dup
    //   3454: invokespecial 170	java/lang/StringBuilder:<init>	()V
    //   3457: ldc_w 561
    //   3460: invokevirtual 174	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3463: iload 5
    //   3465: invokevirtual 206	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   3468: ldc_w 563
    //   3471: invokevirtual 174	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3474: aload 39
    //   3476: invokevirtual 229	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   3479: ldc_w 477
    //   3482: invokevirtual 174	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3485: iload 6
    //   3487: invokevirtual 206	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   3490: ldc_w 431
    //   3493: invokevirtual 174	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3496: aload_3
    //   3497: invokevirtual 229	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   3500: ldc_w 565
    //   3503: invokevirtual 174	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3506: iload 17
    //   3508: invokevirtual 559	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   3511: ldc_w 567
    //   3514: invokevirtual 174	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3517: aload 43
    //   3519: invokevirtual 174	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3522: ldc_w 569
    //   3525: invokevirtual 174	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3528: iload 16
    //   3530: invokevirtual 206	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   3533: ldc_w 571
    //   3536: invokevirtual 174	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3539: getstatic 457	com/tencent/mobileqq/app/FaceDownloader:jdField_a_of_type_Boolean	Z
    //   3542: invokevirtual 559	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   3545: ldc_w 573
    //   3548: invokevirtual 174	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3551: iload 12
    //   3553: invokevirtual 206	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   3556: ldc_w 575
    //   3559: invokevirtual 174	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3562: aload 44
    //   3564: invokevirtual 174	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3567: ldc_w 577
    //   3570: invokevirtual 174	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3573: getstatic 27	com/tencent/mobileqq/app/FaceDownloader:g	I
    //   3576: invokevirtual 206	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   3579: invokevirtual 178	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3582: invokestatic 235	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   3585: iload 5
    //   3587: ifeq +23 -> 3610
    //   3590: iload 6
    //   3592: iconst_2
    //   3593: if_icmpge +17 -> 3610
    //   3596: aload 38
    //   3598: monitorenter
    //   3599: aload 38
    //   3601: ldc2_w 578
    //   3604: invokevirtual 583	java/lang/Object:wait	(J)V
    //   3607: aload 38
    //   3609: monitorexit
    //   3610: aload_2
    //   3611: athrow
    //   3612: iconst_0
    //   3613: istore 9
    //   3615: lload 25
    //   3617: lstore 27
    //   3619: iload 17
    //   3621: istore 19
    //   3623: aload_1
    //   3624: astore 36
    //   3626: iload 5
    //   3628: istore 7
    //   3630: lload 25
    //   3632: lstore 29
    //   3634: iload 17
    //   3636: istore 20
    //   3638: aload_1
    //   3639: astore 37
    //   3641: iload 5
    //   3643: istore 8
    //   3645: aload 31
    //   3647: astore 34
    //   3649: iload 17
    //   3651: istore 18
    //   3653: aload_1
    //   3654: astore 33
    //   3656: iload 5
    //   3658: istore 6
    //   3660: aload 42
    //   3662: getfield 507	com/tencent/mobileqq/emoticon/DownloadInfo:f	Ljava/lang/String;
    //   3665: ifnonnull +2246 -> 5911
    //   3668: lload 25
    //   3670: lstore 27
    //   3672: iload 17
    //   3674: istore 19
    //   3676: aload_1
    //   3677: astore 36
    //   3679: iload 5
    //   3681: istore 7
    //   3683: lload 25
    //   3685: lstore 29
    //   3687: iload 17
    //   3689: istore 20
    //   3691: aload_1
    //   3692: astore 37
    //   3694: iload 5
    //   3696: istore 8
    //   3698: aload 31
    //   3700: astore 34
    //   3702: iload 17
    //   3704: istore 18
    //   3706: aload_1
    //   3707: astore 33
    //   3709: iload 5
    //   3711: istore 6
    //   3713: aload 42
    //   3715: getfield 499	com/tencent/mobileqq/emoticon/DownloadInfo:c	I
    //   3718: istore 9
    //   3720: iload 9
    //   3722: sipush 200
    //   3725: if_icmpne +423 -> 4148
    //   3728: bipush 30
    //   3730: istore 5
    //   3732: iconst_1
    //   3733: istore 7
    //   3735: iload 5
    //   3737: istore 6
    //   3739: iload 7
    //   3741: istore 13
    //   3743: iload 6
    //   3745: istore 5
    //   3747: iload 6
    //   3749: istore 8
    //   3751: iload 6
    //   3753: istore 9
    //   3755: iload 6
    //   3757: istore 10
    //   3759: aload_3
    //   3760: getfield 194	com/tencent/mobileqq/util/FaceInfo:jdField_a_of_type_AvatarInfoQQHeadInfo	LAvatarInfo/QQHeadInfo;
    //   3763: getfield 595	AvatarInfo/QQHeadInfo:headVerify	Ljava/lang/String;
    //   3766: invokestatic 71	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   3769: ifne +76 -> 3845
    //   3772: iload 7
    //   3774: istore 13
    //   3776: iload 6
    //   3778: istore 5
    //   3780: iload 6
    //   3782: istore 8
    //   3784: iload 6
    //   3786: istore 9
    //   3788: iload 6
    //   3790: istore 10
    //   3792: aload 42
    //   3794: getfield 507	com/tencent/mobileqq/emoticon/DownloadInfo:f	Ljava/lang/String;
    //   3797: ifnull +48 -> 3845
    //   3800: iload 7
    //   3802: istore 13
    //   3804: iload 6
    //   3806: istore 5
    //   3808: iload 6
    //   3810: istore 8
    //   3812: iload 6
    //   3814: istore 9
    //   3816: iload 6
    //   3818: istore 10
    //   3820: aload 42
    //   3822: getfield 507	com/tencent/mobileqq/emoticon/DownloadInfo:f	Ljava/lang/String;
    //   3825: aload_3
    //   3826: getfield 194	com/tencent/mobileqq/util/FaceInfo:jdField_a_of_type_AvatarInfoQQHeadInfo	LAvatarInfo/QQHeadInfo;
    //   3829: getfield 595	AvatarInfo/QQHeadInfo:headVerify	Ljava/lang/String;
    //   3832: invokevirtual 79	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   3835: ifne +10 -> 3845
    //   3838: bipush 31
    //   3840: istore 5
    //   3842: iconst_1
    //   3843: istore 13
    //   3845: iload 13
    //   3847: ifeq -2105 -> 1742
    //   3850: iload 5
    //   3852: istore 8
    //   3854: iload 5
    //   3856: istore 9
    //   3858: iload 5
    //   3860: istore 10
    //   3862: aload_0
    //   3863: aload_1
    //   3864: aload_3
    //   3865: invokespecial 511	com/tencent/mobileqq/app/FaceDownloader:a	(Ljava/net/HttpURLConnection;Lcom/tencent/mobileqq/util/FaceInfo;)V
    //   3868: aload_1
    //   3869: ifnull +7 -> 3876
    //   3872: aload_1
    //   3873: invokevirtual 549	java/net/HttpURLConnection:disconnect	()V
    //   3876: aload 31
    //   3878: ifnull +8 -> 3886
    //   3881: aload 31
    //   3883: invokevirtual 554	java/io/OutputStream:close	()V
    //   3886: iload 5
    //   3888: ifeq +76 -> 3964
    //   3891: aload 40
    //   3893: ifnull +71 -> 3964
    //   3896: aload 40
    //   3898: invokevirtual 336	java/io/File:getParentFile	()Ljava/io/File;
    //   3901: astore 32
    //   3903: aload 32
    //   3905: ifnull +17 -> 3922
    //   3908: aload 32
    //   3910: invokevirtual 339	java/io/File:exists	()Z
    //   3913: ifne +9 -> 3922
    //   3916: aload 32
    //   3918: invokevirtual 342	java/io/File:mkdirs	()Z
    //   3921: pop
    //   3922: aload 40
    //   3924: invokevirtual 339	java/io/File:exists	()Z
    //   3927: ifeq +37 -> 3964
    //   3930: aload 40
    //   3932: invokevirtual 369	java/io/File:delete	()Z
    //   3935: istore 18
    //   3937: ldc 196
    //   3939: iconst_1
    //   3940: new 169	java/lang/StringBuilder
    //   3943: dup
    //   3944: invokespecial 170	java/lang/StringBuilder:<init>	()V
    //   3947: ldc_w 556
    //   3950: invokevirtual 174	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3953: iload 18
    //   3955: invokevirtual 559	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   3958: invokevirtual 178	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3961: invokestatic 235	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   3964: iload 11
    //   3966: iconst_1
    //   3967: iadd
    //   3968: istore 6
    //   3970: iload 5
    //   3972: ifeq +141 -> 4113
    //   3975: ldc 196
    //   3977: iconst_1
    //   3978: new 169	java/lang/StringBuilder
    //   3981: dup
    //   3982: invokespecial 170	java/lang/StringBuilder:<init>	()V
    //   3985: ldc_w 561
    //   3988: invokevirtual 174	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3991: iload 5
    //   3993: invokevirtual 206	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   3996: ldc_w 563
    //   3999: invokevirtual 174	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4002: aload 39
    //   4004: invokevirtual 229	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   4007: ldc_w 477
    //   4010: invokevirtual 174	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4013: iload 6
    //   4015: invokevirtual 206	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   4018: ldc_w 431
    //   4021: invokevirtual 174	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4024: aload_3
    //   4025: invokevirtual 229	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   4028: ldc_w 565
    //   4031: invokevirtual 174	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4034: iload 17
    //   4036: invokevirtual 559	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   4039: ldc_w 567
    //   4042: invokevirtual 174	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4045: aload 43
    //   4047: invokevirtual 174	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4050: ldc_w 569
    //   4053: invokevirtual 174	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4056: iload 16
    //   4058: invokevirtual 206	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   4061: ldc_w 571
    //   4064: invokevirtual 174	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4067: getstatic 457	com/tencent/mobileqq/app/FaceDownloader:jdField_a_of_type_Boolean	Z
    //   4070: invokevirtual 559	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   4073: ldc_w 573
    //   4076: invokevirtual 174	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4079: iload 12
    //   4081: invokevirtual 206	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   4084: ldc_w 575
    //   4087: invokevirtual 174	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4090: aload 44
    //   4092: invokevirtual 174	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4095: ldc_w 577
    //   4098: invokevirtual 174	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4101: getstatic 27	com/tencent/mobileqq/app/FaceDownloader:g	I
    //   4104: invokevirtual 206	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   4107: invokevirtual 178	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   4110: invokestatic 235	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   4113: iload 5
    //   4115: ifeq +1786 -> 5901
    //   4118: iload 6
    //   4120: iconst_2
    //   4121: if_icmpge +1780 -> 5901
    //   4124: aload 38
    //   4126: monitorenter
    //   4127: aload 38
    //   4129: ldc2_w 578
    //   4132: invokevirtual 583	java/lang/Object:wait	(J)V
    //   4135: aload 38
    //   4137: monitorexit
    //   4138: aload 31
    //   4140: astore 34
    //   4142: aload_1
    //   4143: astore 32
    //   4145: goto -1504 -> 2641
    //   4148: lload 25
    //   4150: lstore 27
    //   4152: iload 17
    //   4154: istore 19
    //   4156: aload_1
    //   4157: astore 36
    //   4159: iload 5
    //   4161: istore 7
    //   4163: lload 25
    //   4165: lstore 29
    //   4167: iload 17
    //   4169: istore 20
    //   4171: aload_1
    //   4172: astore 37
    //   4174: iload 5
    //   4176: istore 8
    //   4178: aload 31
    //   4180: astore 34
    //   4182: iload 17
    //   4184: istore 18
    //   4186: aload_1
    //   4187: astore 33
    //   4189: iload 5
    //   4191: istore 6
    //   4193: aload 42
    //   4195: getfield 499	com/tencent/mobileqq/emoticon/DownloadInfo:c	I
    //   4198: istore 5
    //   4200: goto -468 -> 3732
    //   4203: astore_1
    //   4204: aload 38
    //   4206: monitorexit
    //   4207: aload_1
    //   4208: athrow
    //   4209: aload_3
    //   4210: getstatic 378	com/tencent/mobileqq/util/FaceInfo:o	I
    //   4213: invokevirtual 380	com/tencent/mobileqq/util/FaceInfo:a	(I)V
    //   4216: iload 5
    //   4218: i2l
    //   4219: lload 25
    //   4221: lcmp
    //   4222: ifne +206 -> 4428
    //   4225: aload_3
    //   4226: getstatic 598	com/tencent/mobileqq/util/FaceInfo:p	I
    //   4229: invokevirtual 380	com/tencent/mobileqq/util/FaceInfo:a	(I)V
    //   4232: aload 34
    //   4234: iconst_0
    //   4235: iload 5
    //   4237: invokestatic 603	com/tencent/mobileqq/util/BitmapManager:a	([BII)Landroid/graphics/Bitmap;
    //   4240: astore 33
    //   4242: aload 33
    //   4244: astore 31
    //   4246: aload 33
    //   4248: ifnull +79 -> 4327
    //   4251: aload_3
    //   4252: getfield 604	com/tencent/mobileqq/util/FaceInfo:c	I
    //   4255: tableswitch	default:+1720 -> 5975, 1:+566->4821, 2:+25->4280, 3:+573->4828
    //   4281: lload_3
    //   4282: bipush 50
    //   4284: bipush 50
    //   4286: invokestatic 609	com/tencent/mobileqq/utils/ImageUtil:c	(Landroid/graphics/Bitmap;II)Landroid/graphics/Bitmap;
    //   4289: astore 31
    //   4291: aload_0
    //   4292: getfield 81	com/tencent/mobileqq/app/FaceDownloader:jdField_a_of_type_ComTencentCommonAppAppInterface	Lcom/tencent/common/app/AppInterface;
    //   4295: sipush 215
    //   4298: invokevirtual 615	com/tencent/common/app/AppInterface:getManager	(I)Lmqq/manager/Manager;
    //   4301: checkcast 617	com/tencent/mobileqq/util/FaceManager
    //   4304: aload_3
    //   4305: invokevirtual 619	com/tencent/mobileqq/util/FaceInfo:a	()Ljava/lang/String;
    //   4308: aload 31
    //   4310: aload_3
    //   4311: getfield 620	com/tencent/mobileqq/util/FaceInfo:jdField_a_of_type_Int	I
    //   4314: invokestatic 623	com/tencent/mobileqq/util/FaceManager:a	(I)B
    //   4317: invokevirtual 626	com/tencent/mobileqq/util/FaceManager:a	(Ljava/lang/String;Landroid/graphics/Bitmap;B)V
    //   4320: aload_3
    //   4321: getstatic 629	com/tencent/mobileqq/util/FaceInfo:q	I
    //   4324: invokevirtual 380	com/tencent/mobileqq/util/FaceInfo:a	(I)V
    //   4327: invokestatic 251	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   4330: ifeq +51 -> 4381
    //   4333: ldc 196
    //   4335: iconst_2
    //   4336: new 169	java/lang/StringBuilder
    //   4339: dup
    //   4340: invokespecial 170	java/lang/StringBuilder:<init>	()V
    //   4343: ldc_w 631
    //   4346: invokevirtual 174	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4349: aload 31
    //   4351: invokevirtual 229	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   4354: ldc_w 563
    //   4357: invokevirtual 174	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4360: aload 39
    //   4362: invokevirtual 229	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   4365: ldc_w 431
    //   4368: invokevirtual 174	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4371: aload_3
    //   4372: invokevirtual 229	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   4375: invokevirtual 178	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   4378: invokestatic 235	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   4381: new 371	zdc
    //   4384: dup
    //   4385: aload_0
    //   4386: invokespecial 372	zdc:<init>	(Lcom/tencent/mobileqq/app/FaceDownloader;)V
    //   4389: astore 33
    //   4391: aload 33
    //   4393: aload_3
    //   4394: putfield 375	zdc:jdField_a_of_type_ComTencentMobileqqUtilFaceInfo	Lcom/tencent/mobileqq/util/FaceInfo;
    //   4397: aload 33
    //   4399: aload 31
    //   4401: putfield 383	zdc:jdField_a_of_type_AndroidGraphicsBitmap	Landroid/graphics/Bitmap;
    //   4404: aload_0
    //   4405: getfield 50	com/tencent/mobileqq/app/FaceDownloader:jdField_b_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   4408: aload 33
    //   4410: invokevirtual 386	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   4413: pop
    //   4414: aload_0
    //   4415: getfield 142	com/tencent/mobileqq/app/FaceDownloader:jdField_a_of_type_MqqOsMqqHandler	Lmqq/os/MqqHandler;
    //   4418: bipush 100
    //   4420: aload 33
    //   4422: invokevirtual 392	mqq/os/MqqHandler:obtainMessage	(ILjava/lang/Object;)Landroid/os/Message;
    //   4425: invokevirtual 397	android/os/Message:sendToTarget	()V
    //   4428: aload 32
    //   4430: aload 34
    //   4432: iconst_0
    //   4433: iload 5
    //   4435: invokevirtual 635	java/io/OutputStream:write	([BII)V
    //   4438: aload 32
    //   4440: invokevirtual 638	java/io/OutputStream:flush	()V
    //   4443: aload_2
    //   4444: invokevirtual 339	java/io/File:exists	()Z
    //   4447: ifeq +8 -> 4455
    //   4450: aload_2
    //   4451: invokevirtual 369	java/io/File:delete	()Z
    //   4454: pop
    //   4455: aload 40
    //   4457: aload_2
    //   4458: invokevirtual 642	java/io/File:renameTo	(Ljava/io/File;)Z
    //   4461: pop
    //   4462: aload_2
    //   4463: invokestatic 330	java/lang/System:currentTimeMillis	()J
    //   4466: invokevirtual 646	java/io/File:setLastModified	(J)Z
    //   4469: pop
    //   4470: iconst_0
    //   4471: istore 5
    //   4473: aload 32
    //   4475: astore 31
    //   4477: lload 25
    //   4479: lstore 27
    //   4481: iload 5
    //   4483: istore 7
    //   4485: aload_1
    //   4486: ifnull +7 -> 4493
    //   4489: aload_1
    //   4490: invokevirtual 549	java/net/HttpURLConnection:disconnect	()V
    //   4493: aload 31
    //   4495: ifnull +8 -> 4503
    //   4498: aload 31
    //   4500: invokevirtual 554	java/io/OutputStream:close	()V
    //   4503: iload 7
    //   4505: ifeq +76 -> 4581
    //   4508: aload 40
    //   4510: ifnull +71 -> 4581
    //   4513: aload 40
    //   4515: invokevirtual 336	java/io/File:getParentFile	()Ljava/io/File;
    //   4518: astore 32
    //   4520: aload 32
    //   4522: ifnull +17 -> 4539
    //   4525: aload 32
    //   4527: invokevirtual 339	java/io/File:exists	()Z
    //   4530: ifne +9 -> 4539
    //   4533: aload 32
    //   4535: invokevirtual 342	java/io/File:mkdirs	()Z
    //   4538: pop
    //   4539: aload 40
    //   4541: invokevirtual 339	java/io/File:exists	()Z
    //   4544: ifeq +37 -> 4581
    //   4547: aload 40
    //   4549: invokevirtual 369	java/io/File:delete	()Z
    //   4552: istore 18
    //   4554: ldc 196
    //   4556: iconst_1
    //   4557: new 169	java/lang/StringBuilder
    //   4560: dup
    //   4561: invokespecial 170	java/lang/StringBuilder:<init>	()V
    //   4564: ldc_w 556
    //   4567: invokevirtual 174	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4570: iload 18
    //   4572: invokevirtual 559	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   4575: invokevirtual 178	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   4578: invokestatic 235	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   4581: iload 11
    //   4583: iconst_1
    //   4584: iadd
    //   4585: istore 8
    //   4587: iload 7
    //   4589: ifeq +141 -> 4730
    //   4592: ldc 196
    //   4594: iconst_1
    //   4595: new 169	java/lang/StringBuilder
    //   4598: dup
    //   4599: invokespecial 170	java/lang/StringBuilder:<init>	()V
    //   4602: ldc_w 561
    //   4605: invokevirtual 174	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4608: iload 7
    //   4610: invokevirtual 206	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   4613: ldc_w 563
    //   4616: invokevirtual 174	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4619: aload 39
    //   4621: invokevirtual 229	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   4624: ldc_w 477
    //   4627: invokevirtual 174	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4630: iload 8
    //   4632: invokevirtual 206	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   4635: ldc_w 431
    //   4638: invokevirtual 174	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4641: aload_3
    //   4642: invokevirtual 229	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   4645: ldc_w 565
    //   4648: invokevirtual 174	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4651: iload 17
    //   4653: invokevirtual 559	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   4656: ldc_w 567
    //   4659: invokevirtual 174	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4662: aload 43
    //   4664: invokevirtual 174	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4667: ldc_w 569
    //   4670: invokevirtual 174	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4673: iload 16
    //   4675: invokevirtual 206	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   4678: ldc_w 571
    //   4681: invokevirtual 174	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4684: getstatic 457	com/tencent/mobileqq/app/FaceDownloader:jdField_a_of_type_Boolean	Z
    //   4687: invokevirtual 559	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   4690: ldc_w 573
    //   4693: invokevirtual 174	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4696: iload 12
    //   4698: invokevirtual 206	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   4701: ldc_w 575
    //   4704: invokevirtual 174	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4707: aload 44
    //   4709: invokevirtual 174	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4712: ldc_w 577
    //   4715: invokevirtual 174	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4718: getstatic 27	com/tencent/mobileqq/app/FaceDownloader:g	I
    //   4721: invokevirtual 206	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   4724: invokevirtual 178	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   4727: invokestatic 235	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   4730: iload 7
    //   4732: istore 5
    //   4734: iload 8
    //   4736: istore 6
    //   4738: lload 27
    //   4740: lstore 25
    //   4742: aload 31
    //   4744: astore 34
    //   4746: aload_1
    //   4747: astore 32
    //   4749: iload 7
    //   4751: ifeq -2110 -> 2641
    //   4754: iload 7
    //   4756: istore 5
    //   4758: iload 8
    //   4760: istore 6
    //   4762: lload 27
    //   4764: lstore 25
    //   4766: aload 31
    //   4768: astore 34
    //   4770: aload_1
    //   4771: astore 32
    //   4773: iload 8
    //   4775: iconst_2
    //   4776: if_icmpge -2135 -> 2641
    //   4779: aload 38
    //   4781: monitorenter
    //   4782: aload 38
    //   4784: ldc2_w 578
    //   4787: invokevirtual 583	java/lang/Object:wait	(J)V
    //   4790: aload 38
    //   4792: monitorexit
    //   4793: iload 7
    //   4795: istore 5
    //   4797: iload 8
    //   4799: istore 6
    //   4801: lload 27
    //   4803: lstore 25
    //   4805: aload 31
    //   4807: astore 34
    //   4809: aload_1
    //   4810: astore 32
    //   4812: goto -2171 -> 2641
    //   4815: astore_1
    //   4816: aload 38
    //   4818: monitorexit
    //   4819: aload_1
    //   4820: athrow
    //   4821: aload 33
    //   4823: astore 31
    //   4825: goto -534 -> 4291
    //   4828: aload 33
    //   4830: bipush 50
    //   4832: bipush 50
    //   4834: invokestatic 648	com/tencent/mobileqq/utils/ImageUtil:a	(Landroid/graphics/Bitmap;II)Landroid/graphics/Bitmap;
    //   4837: astore 31
    //   4839: goto -548 -> 4291
    //   4842: sipush 1024
    //   4845: newarray byte
    //   4847: astore 33
    //   4849: iload 15
    //   4851: istore 5
    //   4853: aload 31
    //   4855: aload 33
    //   4857: invokevirtual 651	java/io/InputStream:read	([B)I
    //   4860: istore 6
    //   4862: iload 6
    //   4864: iconst_m1
    //   4865: if_icmpeq +82 -> 4947
    //   4868: iload 5
    //   4870: iload 6
    //   4872: iadd
    //   4873: istore 5
    //   4875: aload 32
    //   4877: aload 33
    //   4879: iconst_0
    //   4880: iload 6
    //   4882: invokevirtual 635	java/io/OutputStream:write	([BII)V
    //   4885: goto -32 -> 4853
    //   4888: astore 31
    //   4890: aload 32
    //   4892: astore 31
    //   4894: ldc 196
    //   4896: iconst_1
    //   4897: new 169	java/lang/StringBuilder
    //   4900: dup
    //   4901: invokespecial 170	java/lang/StringBuilder:<init>	()V
    //   4904: ldc_w 653
    //   4907: invokevirtual 174	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4910: aload 40
    //   4912: invokevirtual 339	java/io/File:exists	()Z
    //   4915: invokevirtual 559	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   4918: ldc_w 655
    //   4921: invokevirtual 174	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4924: aload 40
    //   4926: invokevirtual 336	java/io/File:getParentFile	()Ljava/io/File;
    //   4929: invokevirtual 339	java/io/File:exists	()Z
    //   4932: invokevirtual 559	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   4935: invokevirtual 178	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   4938: invokestatic 235	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   4941: iconst_4
    //   4942: istore 5
    //   4944: goto -467 -> 4477
    //   4947: aload_3
    //   4948: getstatic 378	com/tencent/mobileqq/util/FaceInfo:o	I
    //   4951: invokevirtual 380	com/tencent/mobileqq/util/FaceInfo:a	(I)V
    //   4954: goto -516 -> 4438
    //   4957: astore 33
    //   4959: aload 32
    //   4961: astore 31
    //   4963: iconst_0
    //   4964: istore 5
    //   4966: aload 33
    //   4968: astore 32
    //   4970: goto -2669 -> 2301
    //   4973: lload 25
    //   4975: lstore 27
    //   4977: iload 17
    //   4979: istore 19
    //   4981: aload_1
    //   4982: astore 36
    //   4984: iload 5
    //   4986: istore 7
    //   4988: lload 25
    //   4990: lstore 29
    //   4992: iload 17
    //   4994: istore 20
    //   4996: aload_1
    //   4997: astore 37
    //   4999: iload 13
    //   5001: istore 8
    //   5003: aload 31
    //   5005: astore 34
    //   5007: iload 17
    //   5009: istore 18
    //   5011: aload_1
    //   5012: astore 33
    //   5014: iload 14
    //   5016: istore 6
    //   5018: aload 42
    //   5020: getfield 499	com/tencent/mobileqq/emoticon/DownloadInfo:c	I
    //   5023: istore 5
    //   5025: iload 5
    //   5027: istore 7
    //   5029: lload 25
    //   5031: lstore 27
    //   5033: goto -548 -> 4485
    //   5036: iload 5
    //   5038: istore 6
    //   5040: aload 32
    //   5042: instanceof 657
    //   5045: ifne +933 -> 5978
    //   5048: iload 5
    //   5050: istore 6
    //   5052: aload 32
    //   5054: instanceof 659
    //   5057: ifeq +6 -> 5063
    //   5060: goto +918 -> 5978
    //   5063: iload 5
    //   5065: istore 6
    //   5067: aload 32
    //   5069: instanceof 661
    //   5072: ifeq +10 -> 5082
    //   5075: bipush 11
    //   5077: istore 5
    //   5079: goto -2715 -> 2364
    //   5082: iload 5
    //   5084: istore 6
    //   5086: aload 32
    //   5088: instanceof 663
    //   5091: ifeq +10 -> 5101
    //   5094: bipush 8
    //   5096: istore 5
    //   5098: goto -2734 -> 2364
    //   5101: iload 5
    //   5103: istore 6
    //   5105: aload 32
    //   5107: instanceof 665
    //   5110: ifeq +10 -> 5120
    //   5113: bipush 17
    //   5115: istore 5
    //   5117: goto -2753 -> 2364
    //   5120: iload 5
    //   5122: istore 6
    //   5124: aload 32
    //   5126: instanceof 667
    //   5129: ifeq +10 -> 5139
    //   5132: bipush 18
    //   5134: istore 5
    //   5136: goto -2772 -> 2364
    //   5139: iload 5
    //   5141: istore 6
    //   5143: aload 32
    //   5145: instanceof 669
    //   5148: ifeq +10 -> 5158
    //   5151: bipush 19
    //   5153: istore 5
    //   5155: goto -2791 -> 2364
    //   5158: iload 5
    //   5160: istore 6
    //   5162: aload 32
    //   5164: invokevirtual 672	java/io/IOException:getMessage	()Ljava/lang/String;
    //   5167: astore 32
    //   5169: iload 5
    //   5171: istore 6
    //   5173: aload 32
    //   5175: ldc_w 674
    //   5178: invokevirtual 677	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   5181: ifne +803 -> 5984
    //   5184: iload 5
    //   5186: istore 6
    //   5188: aload 32
    //   5190: ldc_w 679
    //   5193: invokevirtual 677	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   5196: ifne +788 -> 5984
    //   5199: iload 5
    //   5201: istore 6
    //   5203: aload 32
    //   5205: ldc_w 681
    //   5208: invokevirtual 677	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   5211: ifeq +788 -> 5999
    //   5214: goto +770 -> 5984
    //   5217: iload 5
    //   5219: istore 6
    //   5221: invokestatic 685	com/tencent/mobileqq/util/SystemUtil:a	()Z
    //   5224: istore 18
    //   5226: iload 18
    //   5228: ifeq +170 -> 5398
    //   5231: iload 5
    //   5233: istore 6
    //   5235: invokestatic 687	com/tencent/mobileqq/util/SystemUtil:a	()J
    //   5238: lstore 27
    //   5240: iload 5
    //   5242: istore 6
    //   5244: new 169	java/lang/StringBuilder
    //   5247: dup
    //   5248: invokespecial 170	java/lang/StringBuilder:<init>	()V
    //   5251: ldc_w 689
    //   5254: invokevirtual 174	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5257: astore 33
    //   5259: iload 5
    //   5261: istore 6
    //   5263: aload 40
    //   5265: invokevirtual 339	java/io/File:exists	()Z
    //   5268: ifeq +737 -> 6005
    //   5271: iload 5
    //   5273: istore 6
    //   5275: aload 40
    //   5277: invokevirtual 692	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   5280: astore 32
    //   5282: iload 5
    //   5284: istore 6
    //   5286: aload 33
    //   5288: aload 32
    //   5290: invokevirtual 174	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5293: ldc_w 694
    //   5296: invokevirtual 174	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5299: astore 33
    //   5301: iload 5
    //   5303: istore 6
    //   5305: aload 40
    //   5307: invokevirtual 336	java/io/File:getParentFile	()Ljava/io/File;
    //   5310: ifnull +100 -> 5410
    //   5313: iload 5
    //   5315: istore 6
    //   5317: aload 40
    //   5319: invokevirtual 336	java/io/File:getParentFile	()Ljava/io/File;
    //   5322: invokevirtual 339	java/io/File:exists	()Z
    //   5325: ifeq +85 -> 5410
    //   5328: iload 5
    //   5330: istore 6
    //   5332: aload 40
    //   5334: invokevirtual 336	java/io/File:getParentFile	()Ljava/io/File;
    //   5337: invokevirtual 692	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   5340: astore 32
    //   5342: iload 5
    //   5344: istore 6
    //   5346: ldc 196
    //   5348: iconst_1
    //   5349: aload 33
    //   5351: aload 32
    //   5353: invokevirtual 174	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5356: ldc_w 696
    //   5359: invokevirtual 174	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5362: iload 5
    //   5364: invokevirtual 206	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   5367: ldc_w 698
    //   5370: invokevirtual 174	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5373: iload 18
    //   5375: invokevirtual 559	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   5378: ldc_w 700
    //   5381: invokevirtual 174	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5384: lload 27
    //   5386: invokevirtual 703	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   5389: invokevirtual 178	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   5392: invokestatic 235	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   5395: goto -3031 -> 2364
    //   5398: iload 5
    //   5400: istore 6
    //   5402: invokestatic 705	com/tencent/mobileqq/util/SystemUtil:b	()J
    //   5405: lstore 27
    //   5407: goto -167 -> 5240
    //   5410: ldc_w 707
    //   5413: astore 32
    //   5415: goto -73 -> 5342
    //   5418: astore_1
    //   5419: aload 38
    //   5421: monitorexit
    //   5422: aload_1
    //   5423: athrow
    //   5424: astore_1
    //   5425: aload 38
    //   5427: monitorexit
    //   5428: aload_1
    //   5429: athrow
    //   5430: iload 5
    //   5432: istore 6
    //   5434: lload 25
    //   5436: ldc2_w 529
    //   5439: lcmp
    //   5440: iflt -5409 -> 31
    //   5443: aload_3
    //   5444: getstatic 598	com/tencent/mobileqq/util/FaceInfo:p	I
    //   5447: invokevirtual 380	com/tencent/mobileqq/util/FaceInfo:a	(I)V
    //   5450: new 709	com/tencent/mobileqq/util/BitmapManager$BitmapDecodeResult
    //   5453: dup
    //   5454: invokespecial 710	com/tencent/mobileqq/util/BitmapManager$BitmapDecodeResult:<init>	()V
    //   5457: astore_2
    //   5458: new 712	android/graphics/BitmapFactory$Options
    //   5461: dup
    //   5462: invokespecial 713	android/graphics/BitmapFactory$Options:<init>	()V
    //   5465: astore 31
    //   5467: aload 31
    //   5469: getstatic 718	com/tencent/mobileqq/util/FaceConstant:a	Landroid/graphics/Bitmap$Config;
    //   5472: putfield 721	android/graphics/BitmapFactory$Options:inPreferredConfig	Landroid/graphics/Bitmap$Config;
    //   5475: aload_0
    //   5476: getfield 81	com/tencent/mobileqq/app/FaceDownloader:jdField_a_of_type_ComTencentCommonAppAppInterface	Lcom/tencent/common/app/AppInterface;
    //   5479: sipush 215
    //   5482: invokevirtual 615	com/tencent/common/app/AppInterface:getManager	(I)Lmqq/manager/Manager;
    //   5485: checkcast 617	com/tencent/mobileqq/util/FaceManager
    //   5488: astore 32
    //   5490: iconst_0
    //   5491: istore 6
    //   5493: aload 32
    //   5495: aload_3
    //   5496: invokevirtual 724	com/tencent/mobileqq/util/FaceManager:a	(Lcom/tencent/mobileqq/util/FaceInfo;)Ljava/lang/String;
    //   5499: aload 31
    //   5501: aload_2
    //   5502: invokestatic 727	com/tencent/mobileqq/util/BitmapManager:a	(Ljava/lang/String;Landroid/graphics/BitmapFactory$Options;Lcom/tencent/mobileqq/util/BitmapManager$BitmapDecodeResult;)V
    //   5505: aload_2
    //   5506: getfield 728	com/tencent/mobileqq/util/BitmapManager$BitmapDecodeResult:jdField_a_of_type_Int	I
    //   5509: iconst_1
    //   5510: if_icmpne +18 -> 5528
    //   5513: aload_0
    //   5514: getfield 81	com/tencent/mobileqq/app/FaceDownloader:jdField_a_of_type_ComTencentCommonAppAppInterface	Lcom/tencent/common/app/AppInterface;
    //   5517: checkcast 730	com/tencent/mobileqq/nearby/NearbyAppInterface
    //   5520: checkcast 730	com/tencent/mobileqq/nearby/NearbyAppInterface
    //   5523: astore 33
    //   5525: invokestatic 731	com/tencent/mobileqq/nearby/NearbyAppInterface:b	()V
    //   5528: iload 6
    //   5530: iconst_1
    //   5531: iadd
    //   5532: istore 6
    //   5534: iload 6
    //   5536: iconst_2
    //   5537: if_icmpge +11 -> 5548
    //   5540: aload_2
    //   5541: getfield 728	com/tencent/mobileqq/util/BitmapManager$BitmapDecodeResult:jdField_a_of_type_Int	I
    //   5544: iconst_1
    //   5545: if_icmpeq +353 -> 5898
    //   5548: aload_2
    //   5549: getfield 732	com/tencent/mobileqq/util/BitmapManager$BitmapDecodeResult:jdField_a_of_type_AndroidGraphicsBitmap	Landroid/graphics/Bitmap;
    //   5552: ifnull +67 -> 5619
    //   5555: aload_3
    //   5556: getfield 604	com/tencent/mobileqq/util/FaceInfo:c	I
    //   5559: tableswitch	default:+25 -> 5584, 1:+40->5599, 2:+25->5584, 3:+100->5659
    //   5585: aload_2
    //   5586: getfield 732	com/tencent/mobileqq/util/BitmapManager$BitmapDecodeResult:jdField_a_of_type_AndroidGraphicsBitmap	Landroid/graphics/Bitmap;
    //   5589: bipush 50
    //   5591: bipush 50
    //   5593: invokestatic 609	com/tencent/mobileqq/utils/ImageUtil:c	(Landroid/graphics/Bitmap;II)Landroid/graphics/Bitmap;
    //   5596: putfield 732	com/tencent/mobileqq/util/BitmapManager$BitmapDecodeResult:jdField_a_of_type_AndroidGraphicsBitmap	Landroid/graphics/Bitmap;
    //   5599: aload 32
    //   5601: aload_3
    //   5602: invokevirtual 619	com/tencent/mobileqq/util/FaceInfo:a	()Ljava/lang/String;
    //   5605: aload_2
    //   5606: getfield 732	com/tencent/mobileqq/util/BitmapManager$BitmapDecodeResult:jdField_a_of_type_AndroidGraphicsBitmap	Landroid/graphics/Bitmap;
    //   5609: aload_3
    //   5610: getfield 620	com/tencent/mobileqq/util/FaceInfo:jdField_a_of_type_Int	I
    //   5613: invokestatic 623	com/tencent/mobileqq/util/FaceManager:a	(I)B
    //   5616: invokevirtual 626	com/tencent/mobileqq/util/FaceManager:a	(Ljava/lang/String;Landroid/graphics/Bitmap;B)V
    //   5619: aload_3
    //   5620: getstatic 629	com/tencent/mobileqq/util/FaceInfo:q	I
    //   5623: invokevirtual 380	com/tencent/mobileqq/util/FaceInfo:a	(I)V
    //   5626: aload_1
    //   5627: aload_2
    //   5628: getfield 732	com/tencent/mobileqq/util/BitmapManager$BitmapDecodeResult:jdField_a_of_type_AndroidGraphicsBitmap	Landroid/graphics/Bitmap;
    //   5631: putfield 383	zdc:jdField_a_of_type_AndroidGraphicsBitmap	Landroid/graphics/Bitmap;
    //   5634: aload_0
    //   5635: getfield 50	com/tencent/mobileqq/app/FaceDownloader:jdField_b_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   5638: aload_1
    //   5639: invokevirtual 386	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   5642: pop
    //   5643: aload_0
    //   5644: getfield 142	com/tencent/mobileqq/app/FaceDownloader:jdField_a_of_type_MqqOsMqqHandler	Lmqq/os/MqqHandler;
    //   5647: bipush 100
    //   5649: aload_1
    //   5650: invokevirtual 392	mqq/os/MqqHandler:obtainMessage	(ILjava/lang/Object;)Landroid/os/Message;
    //   5653: invokevirtual 397	android/os/Message:sendToTarget	()V
    //   5656: iload 5
    //   5658: ireturn
    //   5659: aload_2
    //   5660: aload_2
    //   5661: getfield 732	com/tencent/mobileqq/util/BitmapManager$BitmapDecodeResult:jdField_a_of_type_AndroidGraphicsBitmap	Landroid/graphics/Bitmap;
    //   5664: bipush 50
    //   5666: bipush 50
    //   5668: invokestatic 648	com/tencent/mobileqq/utils/ImageUtil:a	(Landroid/graphics/Bitmap;II)Landroid/graphics/Bitmap;
    //   5671: putfield 732	com/tencent/mobileqq/util/BitmapManager$BitmapDecodeResult:jdField_a_of_type_AndroidGraphicsBitmap	Landroid/graphics/Bitmap;
    //   5674: goto -75 -> 5599
    //   5677: astore 32
    //   5679: goto -1793 -> 3886
    //   5682: astore 32
    //   5684: goto -1549 -> 4135
    //   5687: astore 32
    //   5689: goto -1186 -> 4503
    //   5692: astore 32
    //   5694: goto -904 -> 4790
    //   5697: astore 32
    //   5699: goto -3317 -> 2382
    //   5702: astore 32
    //   5704: goto -3073 -> 2631
    //   5707: astore 32
    //   5709: goto -2726 -> 2983
    //   5712: astore 32
    //   5714: goto -2479 -> 3235
    //   5717: astore_1
    //   5718: goto -2356 -> 3362
    //   5721: astore_1
    //   5722: goto -2115 -> 3607
    //   5725: astore_1
    //   5726: goto -2290 -> 3436
    //   5729: astore_2
    //   5730: aload 32
    //   5732: astore 31
    //   5734: iload 10
    //   5736: istore 5
    //   5738: goto -2394 -> 3344
    //   5741: astore_2
    //   5742: iload 10
    //   5744: istore 5
    //   5746: goto -2402 -> 3344
    //   5749: astore_2
    //   5750: iconst_1
    //   5751: istore 17
    //   5753: goto -2409 -> 3344
    //   5756: astore_2
    //   5757: goto -2413 -> 3344
    //   5760: astore_2
    //   5761: iload 8
    //   5763: istore 5
    //   5765: goto -2421 -> 3344
    //   5768: astore 32
    //   5770: goto -2714 -> 3056
    //   5773: astore 33
    //   5775: aload 32
    //   5777: astore 31
    //   5779: aload 33
    //   5781: astore 32
    //   5783: lload 25
    //   5785: lstore 27
    //   5787: iload 9
    //   5789: istore 5
    //   5791: goto -2883 -> 2908
    //   5794: astore 32
    //   5796: lload 25
    //   5798: lstore 27
    //   5800: iload 9
    //   5802: istore 5
    //   5804: goto -2896 -> 2908
    //   5807: astore 32
    //   5809: iconst_1
    //   5810: istore 17
    //   5812: lload 25
    //   5814: lstore 27
    //   5816: goto -2908 -> 2908
    //   5819: astore 32
    //   5821: lload 25
    //   5823: lstore 27
    //   5825: goto -2917 -> 2908
    //   5828: astore 32
    //   5830: iload 9
    //   5832: istore 5
    //   5834: lload 25
    //   5836: lstore 27
    //   5838: goto -2930 -> 2908
    //   5841: astore 32
    //   5843: goto -3383 -> 2460
    //   5846: astore 32
    //   5848: iconst_0
    //   5849: istore 5
    //   5851: goto -3550 -> 2301
    //   5854: astore 32
    //   5856: iconst_5
    //   5857: istore 5
    //   5859: iload 18
    //   5861: istore 17
    //   5863: goto -3562 -> 2301
    //   5866: astore 32
    //   5868: iconst_5
    //   5869: istore 5
    //   5871: goto -3570 -> 2301
    //   5874: astore 32
    //   5876: iload 10
    //   5878: istore 5
    //   5880: goto -3579 -> 2301
    //   5883: astore 32
    //   5885: goto -1304 -> 4581
    //   5888: astore 32
    //   5890: goto -996 -> 4894
    //   5893: astore 32
    //   5895: goto -1931 -> 3964
    //   5898: goto -405 -> 5493
    //   5901: aload 31
    //   5903: astore 34
    //   5905: aload_1
    //   5906: astore 32
    //   5908: goto -3267 -> 2641
    //   5911: iconst_5
    //   5912: istore 6
    //   5914: iload 9
    //   5916: istore 7
    //   5918: goto -2179 -> 3739
    //   5921: goto -4833 -> 1088
    //   5924: iconst_m1
    //   5925: istore 12
    //   5927: aconst_null
    //   5928: astore 32
    //   5930: goto -5418 -> 512
    //   5933: aload 33
    //   5935: astore 32
    //   5937: goto -5521 -> 416
    //   5940: aload 33
    //   5942: astore 35
    //   5944: goto -5476 -> 468
    //   5947: aload 35
    //   5949: astore 33
    //   5951: aload 34
    //   5953: astore 31
    //   5955: aload 32
    //   5957: astore_1
    //   5958: iload 6
    //   5960: istore 11
    //   5962: goto -5753 -> 209
    //   5965: aload 31
    //   5967: astore 34
    //   5969: aload_1
    //   5970: astore 32
    //   5972: goto -3331 -> 2641
    //   5975: goto -1695 -> 4280
    //   5978: iconst_2
    //   5979: istore 5
    //   5981: goto -3617 -> 2364
    //   5984: bipush 33
    //   5986: istore 5
    //   5988: goto -771 -> 5217
    //   5991: astore_2
    //   5992: iload 6
    //   5994: istore 5
    //   5996: goto -2652 -> 3344
    //   5999: iconst_4
    //   6000: istore 5
    //   6002: goto -785 -> 5217
    //   6005: ldc_w 707
    //   6008: astore 32
    //   6010: goto -728 -> 5282
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	6013	0	this	FaceDownloader
    //   0	6013	1	paramString	String
    //   0	6013	2	paramFile	java.io.File
    //   0	6013	3	paramFaceInfo	FaceInfo
    //   0	6013	4	paramBoolean	boolean
    //   201	5800	5	i	int
    //   29	5964	6	j	int
    //   532	5385	7	k	int
    //   547	5215	8	m	int
    //   1746	4169	9	n	int
    //   1752	4125	10	i1	int
    //   198	5763	11	i2	int
    //   510	5416	12	i3	int
    //   1743	3257	13	i4	int
    //   1749	3266	14	i5	int
    //   1863	2987	15	i6	int
    //   491	4183	16	i7	int
    //   481	5381	17	bool1	boolean
    //   555	5305	18	bool2	boolean
    //   525	4455	19	bool3	boolean
    //   540	4455	20	bool4	boolean
    //   472	2256	21	bool5	boolean
    //   475	2268	22	bool6	boolean
    //   478	2280	23	bool7	boolean
    //   961	3	24	bool8	boolean
    //   6	5829	25	l1	long
    //   521	5316	27	l2	long
    //   536	4455	29	l3	long
    //   61	4793	31	localObject1	Object
    //   4888	1	31	localFileNotFoundException1	java.io.FileNotFoundException
    //   4892	1074	31	localObject2	Object
    //   195	12	32	localObject3	Object
    //   298	1	32	localIllegalArgumentException	java.lang.IllegalArgumentException
    //   331	1897	32	localObject4	Object
    //   2284	65	32	localIOException1	java.io.IOException
    //   2397	318	32	localObject5	Object
    //   2787	102	32	localThrowable1	Throwable
    //   2891	67	32	localThrowable2	Throwable
    //   2993	2607	32	localObject6	Object
    //   5677	1	32	localIOException2	java.io.IOException
    //   5682	1	32	localInterruptedException1	java.lang.InterruptedException
    //   5687	1	32	localIOException3	java.io.IOException
    //   5692	1	32	localInterruptedException2	java.lang.InterruptedException
    //   5697	1	32	localIOException4	java.io.IOException
    //   5702	1	32	localInterruptedException3	java.lang.InterruptedException
    //   5707	1	32	localIOException5	java.io.IOException
    //   5712	19	32	localInterruptedException4	java.lang.InterruptedException
    //   5768	8	32	localException1	java.lang.Exception
    //   5781	1	32	localObject7	Object
    //   5794	1	32	localThrowable3	Throwable
    //   5807	1	32	localThrowable4	Throwable
    //   5819	1	32	localThrowable5	Throwable
    //   5828	1	32	localThrowable6	Throwable
    //   5841	1	32	localException2	java.lang.Exception
    //   5846	1	32	localIOException6	java.io.IOException
    //   5854	1	32	localIOException7	java.io.IOException
    //   5866	1	32	localIOException8	java.io.IOException
    //   5874	1	32	localIOException9	java.io.IOException
    //   5883	1	32	localException3	java.lang.Exception
    //   5888	1	32	localFileNotFoundException2	java.io.FileNotFoundException
    //   5893	1	32	localException4	java.lang.Exception
    //   5906	103	32	localObject8	Object
    //   204	4674	33	localObject9	Object
    //   4957	10	33	localIOException10	java.io.IOException
    //   5012	512	33	localObject10	Object
    //   5773	168	33	localThrowable7	Throwable
    //   5949	1	33	localObject11	Object
    //   219	5749	34	localObject12	Object
    //   466	5482	35	localObject13	Object
    //   528	4455	36	str1	String
    //   543	4455	37	str2	String
    //   55	5371	38	localObject14	Object
    //   42	4578	39	localURL	java.net.URL
    //   178	5155	40	localFile	java.io.File
    //   3	503	41	localNetworkInfo	android.net.NetworkInfo
    //   95	4924	42	localDownloadInfo	com.tencent.mobileqq.emoticon.DownloadInfo
    //   486	4177	43	str3	String
    //   517	4191	44	str4	String
    // Exception table:
    //   from	to	target	type
    //   34	44	119	java/net/MalformedURLException
    //   57	63	127	java/lang/Exception
    //   68	82	127	java/lang/Exception
    //   139	148	298	java/lang/IllegalArgumentException
    //   300	305	308	java/lang/IllegalArgumentException
    //   564	575	2284	java/io/IOException
    //   626	637	2284	java/io/IOException
    //   682	686	2284	java/io/IOException
    //   731	736	2284	java/io/IOException
    //   787	798	2284	java/io/IOException
    //   843	854	2284	java/io/IOException
    //   899	903	2284	java/io/IOException
    //   958	963	2284	java/io/IOException
    //   1133	1143	2284	java/io/IOException
    //   1188	1195	2284	java/io/IOException
    //   1240	1247	2284	java/io/IOException
    //   1292	1297	2284	java/io/IOException
    //   1327	1331	2284	java/io/IOException
    //   1361	1370	2284	java/io/IOException
    //   1400	1409	2284	java/io/IOException
    //   1439	1448	2284	java/io/IOException
    //   1478	1487	2284	java/io/IOException
    //   1517	1528	2284	java/io/IOException
    //   1558	1566	2284	java/io/IOException
    //   1611	1619	2284	java/io/IOException
    //   1664	1691	2284	java/io/IOException
    //   1736	1742	2284	java/io/IOException
    //   1802	1813	2284	java/io/IOException
    //   1858	1865	2284	java/io/IOException
    //   1918	1926	2284	java/io/IOException
    //   1971	1977	2284	java/io/IOException
    //   2022	2028	2284	java/io/IOException
    //   2073	2091	2284	java/io/IOException
    //   2277	2281	2284	java/io/IOException
    //   2768	2784	2284	java/io/IOException
    //   2839	2843	2284	java/io/IOException
    //   2888	2891	2284	java/io/IOException
    //   3321	3325	2284	java/io/IOException
    //   3660	3668	2284	java/io/IOException
    //   3713	3720	2284	java/io/IOException
    //   4193	4200	2284	java/io/IOException
    //   5018	5025	2284	java/io/IOException
    //   1327	1331	2787	java/lang/Throwable
    //   1361	1370	2787	java/lang/Throwable
    //   1400	1409	2787	java/lang/Throwable
    //   1439	1448	2787	java/lang/Throwable
    //   1478	1487	2787	java/lang/Throwable
    //   1517	1528	2787	java/lang/Throwable
    //   1558	1566	2787	java/lang/Throwable
    //   564	575	2891	java/lang/Throwable
    //   626	637	2891	java/lang/Throwable
    //   682	686	2891	java/lang/Throwable
    //   731	736	2891	java/lang/Throwable
    //   787	798	2891	java/lang/Throwable
    //   843	854	2891	java/lang/Throwable
    //   899	903	2891	java/lang/Throwable
    //   958	963	2891	java/lang/Throwable
    //   1133	1143	2891	java/lang/Throwable
    //   1188	1195	2891	java/lang/Throwable
    //   1240	1247	2891	java/lang/Throwable
    //   1292	1297	2891	java/lang/Throwable
    //   1611	1619	2891	java/lang/Throwable
    //   1664	1691	2891	java/lang/Throwable
    //   1736	1742	2891	java/lang/Throwable
    //   1802	1813	2891	java/lang/Throwable
    //   1858	1865	2891	java/lang/Throwable
    //   1918	1926	2891	java/lang/Throwable
    //   1971	1977	2891	java/lang/Throwable
    //   2022	2028	2891	java/lang/Throwable
    //   2073	2091	2891	java/lang/Throwable
    //   2277	2281	2891	java/lang/Throwable
    //   2768	2784	2891	java/lang/Throwable
    //   2839	2843	2891	java/lang/Throwable
    //   2888	2891	2891	java/lang/Throwable
    //   3321	3325	2891	java/lang/Throwable
    //   3660	3668	2891	java/lang/Throwable
    //   3713	3720	2891	java/lang/Throwable
    //   4193	4200	2891	java/lang/Throwable
    //   5018	5025	2891	java/lang/Throwable
    //   3227	3235	3260	finally
    //   3235	3238	3260	finally
    //   3261	3264	3260	finally
    //   564	575	3328	finally
    //   626	637	3328	finally
    //   682	686	3328	finally
    //   731	736	3328	finally
    //   787	798	3328	finally
    //   843	854	3328	finally
    //   899	903	3328	finally
    //   958	963	3328	finally
    //   1133	1143	3328	finally
    //   1188	1195	3328	finally
    //   1240	1247	3328	finally
    //   1292	1297	3328	finally
    //   1327	1331	3328	finally
    //   1361	1370	3328	finally
    //   1400	1409	3328	finally
    //   1439	1448	3328	finally
    //   1478	1487	3328	finally
    //   1517	1528	3328	finally
    //   1558	1566	3328	finally
    //   1611	1619	3328	finally
    //   1664	1691	3328	finally
    //   1736	1742	3328	finally
    //   1802	1813	3328	finally
    //   1858	1865	3328	finally
    //   1918	1926	3328	finally
    //   1971	1977	3328	finally
    //   2022	2028	3328	finally
    //   2073	2091	3328	finally
    //   2277	2281	3328	finally
    //   2768	2784	3328	finally
    //   2839	2843	3328	finally
    //   2888	2891	3328	finally
    //   2923	2962	3328	finally
    //   3321	3325	3328	finally
    //   3660	3668	3328	finally
    //   3713	3720	3328	finally
    //   4193	4200	3328	finally
    //   5018	5025	3328	finally
    //   4127	4135	4203	finally
    //   4135	4138	4203	finally
    //   4204	4207	4203	finally
    //   4782	4790	4815	finally
    //   4790	4793	4815	finally
    //   4816	4819	4815	finally
    //   2091	2097	4888	java/io/FileNotFoundException
    //   2111	2118	4888	java/io/FileNotFoundException
    //   2124	2138	4888	java/io/FileNotFoundException
    //   4209	4216	4888	java/io/FileNotFoundException
    //   4225	4242	4888	java/io/FileNotFoundException
    //   4251	4280	4888	java/io/FileNotFoundException
    //   4280	4291	4888	java/io/FileNotFoundException
    //   4291	4327	4888	java/io/FileNotFoundException
    //   4327	4381	4888	java/io/FileNotFoundException
    //   4381	4428	4888	java/io/FileNotFoundException
    //   4428	4438	4888	java/io/FileNotFoundException
    //   4438	4455	4888	java/io/FileNotFoundException
    //   4455	4470	4888	java/io/FileNotFoundException
    //   4828	4839	4888	java/io/FileNotFoundException
    //   4842	4849	4888	java/io/FileNotFoundException
    //   4853	4862	4888	java/io/FileNotFoundException
    //   4875	4885	4888	java/io/FileNotFoundException
    //   4947	4954	4888	java/io/FileNotFoundException
    //   2091	2097	4957	java/io/IOException
    //   2111	2118	4957	java/io/IOException
    //   2124	2138	4957	java/io/IOException
    //   4209	4216	4957	java/io/IOException
    //   4225	4242	4957	java/io/IOException
    //   4251	4280	4957	java/io/IOException
    //   4280	4291	4957	java/io/IOException
    //   4291	4327	4957	java/io/IOException
    //   4327	4381	4957	java/io/IOException
    //   4381	4428	4957	java/io/IOException
    //   4428	4438	4957	java/io/IOException
    //   4438	4455	4957	java/io/IOException
    //   4455	4470	4957	java/io/IOException
    //   4828	4839	4957	java/io/IOException
    //   4842	4849	4957	java/io/IOException
    //   4853	4862	4957	java/io/IOException
    //   4875	4885	4957	java/io/IOException
    //   4947	4954	4957	java/io/IOException
    //   2623	2631	5418	finally
    //   2631	2634	5418	finally
    //   5419	5422	5418	finally
    //   3599	3607	5424	finally
    //   3607	3610	5424	finally
    //   5425	5428	5424	finally
    //   3881	3886	5677	java/io/IOException
    //   4127	4135	5682	java/lang/InterruptedException
    //   4498	4503	5687	java/io/IOException
    //   4782	4790	5692	java/lang/InterruptedException
    //   2377	2382	5697	java/io/IOException
    //   2623	2631	5702	java/lang/InterruptedException
    //   2978	2983	5707	java/io/IOException
    //   3227	3235	5712	java/lang/InterruptedException
    //   3357	3362	5717	java/io/IOException
    //   3599	3607	5721	java/lang/InterruptedException
    //   3372	3378	5725	java/lang/Exception
    //   3382	3394	5725	java/lang/Exception
    //   3394	3436	5725	java/lang/Exception
    //   2091	2097	5729	finally
    //   2111	2118	5729	finally
    //   2124	2138	5729	finally
    //   4209	4216	5729	finally
    //   4225	4242	5729	finally
    //   4251	4280	5729	finally
    //   4280	4291	5729	finally
    //   4291	4327	5729	finally
    //   4327	4381	5729	finally
    //   4381	4428	5729	finally
    //   4428	4438	5729	finally
    //   4438	4455	5729	finally
    //   4455	4470	5729	finally
    //   4828	4839	5729	finally
    //   4842	4849	5729	finally
    //   4853	4862	5729	finally
    //   4875	4885	5729	finally
    //   4947	4954	5729	finally
    //   4894	4941	5741	finally
    //   974	1007	5749	finally
    //   1013	1037	5749	finally
    //   2655	2666	5749	finally
    //   2672	2694	5749	finally
    //   2703	2714	5749	finally
    //   1043	1088	5756	finally
    //   3759	3772	5760	finally
    //   3792	3800	5760	finally
    //   3820	3838	5760	finally
    //   3862	3868	5760	finally
    //   2988	2995	5768	java/lang/Exception
    //   3000	3014	5768	java/lang/Exception
    //   3014	3056	5768	java/lang/Exception
    //   2091	2097	5773	java/lang/Throwable
    //   2111	2118	5773	java/lang/Throwable
    //   2124	2138	5773	java/lang/Throwable
    //   4209	4216	5773	java/lang/Throwable
    //   4225	4242	5773	java/lang/Throwable
    //   4251	4280	5773	java/lang/Throwable
    //   4280	4291	5773	java/lang/Throwable
    //   4291	4327	5773	java/lang/Throwable
    //   4327	4381	5773	java/lang/Throwable
    //   4381	4428	5773	java/lang/Throwable
    //   4428	4438	5773	java/lang/Throwable
    //   4438	4455	5773	java/lang/Throwable
    //   4455	4470	5773	java/lang/Throwable
    //   4828	4839	5773	java/lang/Throwable
    //   4842	4849	5773	java/lang/Throwable
    //   4853	4862	5773	java/lang/Throwable
    //   4875	4885	5773	java/lang/Throwable
    //   4947	4954	5773	java/lang/Throwable
    //   4894	4941	5794	java/lang/Throwable
    //   974	1007	5807	java/lang/Throwable
    //   1013	1037	5807	java/lang/Throwable
    //   2655	2666	5807	java/lang/Throwable
    //   2672	2694	5807	java/lang/Throwable
    //   2703	2714	5807	java/lang/Throwable
    //   1043	1088	5819	java/lang/Throwable
    //   3759	3772	5828	java/lang/Throwable
    //   3792	3800	5828	java/lang/Throwable
    //   3820	3838	5828	java/lang/Throwable
    //   3862	3868	5828	java/lang/Throwable
    //   2392	2399	5841	java/lang/Exception
    //   2404	2418	5841	java/lang/Exception
    //   2418	2460	5841	java/lang/Exception
    //   4894	4941	5846	java/io/IOException
    //   974	1007	5854	java/io/IOException
    //   1013	1037	5854	java/io/IOException
    //   2655	2666	5854	java/io/IOException
    //   2672	2694	5854	java/io/IOException
    //   2703	2714	5854	java/io/IOException
    //   1043	1088	5866	java/io/IOException
    //   3759	3772	5874	java/io/IOException
    //   3792	3800	5874	java/io/IOException
    //   3820	3838	5874	java/io/IOException
    //   3862	3868	5874	java/io/IOException
    //   4513	4520	5883	java/lang/Exception
    //   4525	4539	5883	java/lang/Exception
    //   4539	4581	5883	java/lang/Exception
    //   1918	1926	5888	java/io/FileNotFoundException
    //   1971	1977	5888	java/io/FileNotFoundException
    //   2022	2028	5888	java/io/FileNotFoundException
    //   2073	2091	5888	java/io/FileNotFoundException
    //   3896	3903	5893	java/lang/Exception
    //   3908	3922	5893	java/lang/Exception
    //   3922	3964	5893	java/lang/Exception
    //   2305	2344	5991	finally
    //   2348	2355	5991	finally
    //   5040	5048	5991	finally
    //   5052	5060	5991	finally
    //   5067	5075	5991	finally
    //   5086	5094	5991	finally
    //   5105	5113	5991	finally
    //   5124	5132	5991	finally
    //   5143	5151	5991	finally
    //   5162	5169	5991	finally
    //   5173	5184	5991	finally
    //   5188	5199	5991	finally
    //   5203	5214	5991	finally
    //   5221	5226	5991	finally
    //   5235	5240	5991	finally
    //   5244	5259	5991	finally
    //   5263	5271	5991	finally
    //   5275	5282	5991	finally
    //   5286	5301	5991	finally
    //   5305	5313	5991	finally
    //   5317	5328	5991	finally
    //   5332	5342	5991	finally
    //   5346	5395	5991	finally
    //   5402	5407	5991	finally
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
          break label231;
        }
        localStringBuilder.append(str2);
        label97:
        int i = paramString.indexOf("/", 8);
        str1 = paramString;
        if (i > 8)
        {
          localStringBuilder.append(paramString.substring(i));
          str1 = localStringBuilder.toString();
        }
        if (paramByte2 != 32) {
          break label249;
        }
        if (paramInt != 1) {
          break label242;
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
      label231:
      localStringBuilder.append(str1);
      break label97;
      label242:
      paramByte2 = 140;
      continue;
      label249:
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
    while (i < this.jdField_a_of_type_ArrayOfZdb.length)
    {
      if (this.jdField_a_of_type_ArrayOfZdb[i] != null) {
        this.jdField_a_of_type_ArrayOfZdb[i].a();
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
    if ((paramInt == this.jdField_a_of_type_Int) && (this.c < this.jdField_a_of_type_Int) && (this.jdField_a_of_type_JavaUtilArrayList.size() >= this.jdField_b_of_type_Int))
    {
      int i = this.c + this.jdField_a_of_type_JavaUtilArrayList.size() - this.jdField_b_of_type_Int + 1;
      paramInt = i;
      if (i <= 0) {
        paramInt = 1;
      }
      if (paramInt < this.jdField_a_of_type_Int) {}
      for (;;)
      {
        i = 0;
        for (;;)
        {
          if (i >= paramInt) {
            return;
          }
          try
          {
            if (this.jdField_a_of_type_ArrayOfJavaLangThread[i] == null)
            {
              this.jdField_a_of_type_ArrayOfZdb[i] = new zdb(this, i);
              this.jdField_a_of_type_ArrayOfJavaLangThread[i] = ThreadManager.newFreeThread(this.jdField_a_of_type_ArrayOfZdb[i], "FaceDownloadThread", 5);
              this.jdField_a_of_type_ArrayOfJavaLangThread[i].start();
              this.c += 1;
            }
            i += 1;
          }
          catch (OutOfMemoryError localOutOfMemoryError)
          {
            if (!QLog.isColorLevel()) {
              return;
            }
            QLog.e("Q.qqhead.FaceDownloader", 2, "smartSetThreadCount", localOutOfMemoryError);
          }
        }
        paramInt = this.jdField_a_of_type_Int;
      }
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