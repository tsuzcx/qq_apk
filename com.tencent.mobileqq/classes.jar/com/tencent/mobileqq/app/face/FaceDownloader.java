package com.tencent.mobileqq.app.face;

import AvatarInfo.QQHeadInfo;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory.Options;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import anzk;
import aoim;
import aooa;
import aooo;
import aoop;
import aooq;
import aoor;
import aoos;
import aope;
import asjz;
import bhgm;
import bhgn;
import bhjr;
import bhmq;
import bhnv;
import bhvd;
import bhve;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.nearby.NearbyAppInterface;
import com.tencent.mobileqq.transfile.dns.InnerDns;
import com.tencent.qphone.base.util.QLog;
import java.io.EOFException;
import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.net.ConnectException;
import java.net.HttpRetryException;
import java.net.HttpURLConnection;
import java.net.SocketException;
import java.net.SocketTimeoutException;
import java.net.URL;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.concurrent.atomic.AtomicInteger;
import javax.net.ssl.HttpsURLConnection;
import mqq.os.MqqHandler;
import org.apache.http.ConnectionClosedException;
import org.apache.http.conn.ConnectTimeoutException;
import org.jetbrains.annotations.NotNull;

public abstract class FaceDownloader
{
  private static String jdField_a_of_type_JavaLangString;
  private static boolean jdField_a_of_type_Boolean;
  private static int e = 1;
  protected byte a;
  public int a;
  private aoor jdField_a_of_type_Aoor;
  protected AppInterface a;
  protected ArrayList<FaceInfo> a;
  protected HashSet<String> a;
  public LinkedList<aooq> a;
  protected AtomicInteger a;
  protected MqqHandler a;
  private FaceDownloader.FaceDownloadRunnable[] jdField_a_of_type_ArrayOfComTencentMobileqqAppFaceFaceDownloader$FaceDownloadRunnable;
  private Thread[] jdField_a_of_type_ArrayOfJavaLangThread;
  protected int b;
  public ArrayList<aoos> b;
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
    if (this.jdField_a_of_type_Aoor.jdField_a_of_type_Int != -2147483648) {
      this.jdField_a_of_type_Int = this.jdField_a_of_type_Aoor.jdField_a_of_type_Int;
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
    this.jdField_a_of_type_ArrayOfComTencentMobileqqAppFaceFaceDownloader$FaceDownloadRunnable = new FaceDownloader.FaceDownloadRunnable[this.jdField_a_of_type_Int];
    int i = 0;
    for (;;)
    {
      if (i < this.jdField_a_of_type_ArrayOfJavaLangThread.length)
      {
        this.jdField_a_of_type_ArrayOfComTencentMobileqqAppFaceFaceDownloader$FaceDownloadRunnable[i] = new FaceDownloader.FaceDownloadRunnable(this, i);
        this.jdField_a_of_type_ArrayOfJavaLangThread[i] = ThreadManager.newFreeThread(this.jdField_a_of_type_ArrayOfComTencentMobileqqAppFaceFaceDownloader$FaceDownloadRunnable[i], "FaceDownloadThread", 5);
        if (aoim.a().c()) {
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
      this.jdField_a_of_type_MqqOsMqqHandler = new aooo(this, Looper.getMainLooper());
      return;
      this.jdField_a_of_type_Byte = 3;
      continue;
      this.jdField_a_of_type_Byte = 2;
      continue;
      this.jdField_a_of_type_Byte = 0;
    }
  }
  
  private int a(FaceInfo paramFaceInfo, URL paramURL, File paramFile, IOException paramIOException)
  {
    QLog.i("Q.qqhead.FaceDownloader", 1, "Download fail 1. url=" + paramURL + ",faceInfo=" + paramFaceInfo, paramIOException);
    if ((paramIOException instanceof UnknownHostException)) {
      return 10;
    }
    if (((paramIOException instanceof ConnectTimeoutException)) || ((paramIOException instanceof SocketTimeoutException))) {
      return 2;
    }
    if ((paramIOException instanceof SocketException)) {
      return 11;
    }
    if ((paramIOException instanceof ConnectionClosedException)) {
      return 8;
    }
    if ((paramIOException instanceof ConnectException)) {
      return 17;
    }
    if ((paramIOException instanceof HttpRetryException)) {
      return 18;
    }
    if ((paramIOException instanceof EOFException)) {
      return 19;
    }
    paramFaceInfo = paramIOException.getMessage();
    int i;
    boolean bool;
    long l;
    if ((paramFaceInfo.contains("EACCES")) || (paramFaceInfo.contains("ENOSPC")) || (paramFaceInfo.contains("Read-only")))
    {
      i = 33;
      bool = bhjr.a();
      if (!bool) {
        break label286;
      }
      l = bhjr.a();
      label172:
      paramURL = new StringBuilder().append("Download fail 1. tmpFilePath=");
      if (!paramFile.exists()) {
        break label294;
      }
      paramFaceInfo = paramFile.getAbsolutePath();
      label197:
      paramURL = paramURL.append(paramFaceInfo).append("tmpParentFilePath=");
      if ((paramFile.getParentFile() == null) || (!paramFile.getParentFile().exists())) {
        break label301;
      }
    }
    label286:
    label294:
    label301:
    for (paramFaceInfo = paramFile.getParentFile().getAbsolutePath();; paramFaceInfo = "notExit")
    {
      QLog.i("Q.qqhead.FaceDownloader", 1, paramFaceInfo + ", result=" + i + ",isExistSDCard=" + bool + ",availableSize=" + l);
      return i;
      i = 4;
      break;
      l = bhjr.b();
      break label172;
      paramFaceInfo = "notExit";
      break label197;
    }
  }
  
  /* Error */
  private int a(String paramString, File paramFile1, FaceInfo paramFaceInfo, boolean paramBoolean, android.net.NetworkInfo paramNetworkInfo, URL paramURL, int paramInt1, Object paramObject, int paramInt2, OutputStream paramOutputStream, asjz paramasjz, File paramFile2, int paramInt3, HttpURLConnection paramHttpURLConnection)
  {
    // Byte code:
    //   0: lconst_0
    //   1: lstore 27
    //   3: aload_1
    //   4: astore 31
    //   6: aload 10
    //   8: astore_1
    //   9: iload 13
    //   11: istore 17
    //   13: aload 14
    //   15: astore 10
    //   17: aload 31
    //   19: astore 14
    //   21: aload 14
    //   23: astore 33
    //   25: iload 17
    //   27: iconst_m1
    //   28: if_icmpeq +56 -> 84
    //   31: aload_3
    //   32: getfield 275	com/tencent/mobileqq/app/face/FaceInfo:jdField_a_of_type_AvatarInfoQQHeadInfo	LAvatarInfo/QQHeadInfo;
    //   35: astore 31
    //   37: aload 31
    //   39: ifnonnull +32 -> 71
    //   42: iload 7
    //   44: istore 15
    //   46: lload 27
    //   48: lstore 29
    //   50: aload 11
    //   52: iload 15
    //   54: putfield 278	asjz:jdField_b_of_type_Int	I
    //   57: aload_0
    //   58: aload_3
    //   59: iload 4
    //   61: lload 29
    //   63: iload 15
    //   65: invokespecial 281	com/tencent/mobileqq/app/face/FaceDownloader:a	(Lcom/tencent/mobileqq/app/face/FaceInfo;ZJI)V
    //   68: iload 15
    //   70: ireturn
    //   71: aload_0
    //   72: aload 14
    //   74: aload_3
    //   75: iload 17
    //   77: aload 31
    //   79: invokespecial 284	com/tencent/mobileqq/app/face/FaceDownloader:a	(Ljava/lang/String;Lcom/tencent/mobileqq/app/face/FaceInfo;ILAvatarInfo/QQHeadInfo;)Ljava/lang/String;
    //   82: astore 33
    //   84: iconst_5
    //   85: istore 13
    //   87: invokestatic 289	android/net/Proxy:getDefaultHost	()Ljava/lang/String;
    //   90: astore 34
    //   92: invokestatic 292	android/net/Proxy:getDefaultPort	()I
    //   95: istore 23
    //   97: aload 5
    //   99: ifnull +408 -> 507
    //   102: aload 5
    //   104: invokevirtual 297	android/net/NetworkInfo:getExtraInfo	()Ljava/lang/String;
    //   107: astore 14
    //   109: aload 5
    //   111: ifnull +402 -> 513
    //   114: aload 5
    //   116: invokevirtual 300	android/net/NetworkInfo:getType	()I
    //   119: istore 18
    //   121: aload 14
    //   123: invokestatic 305	bhvd:b	(Ljava/lang/String;)Ljava/lang/String;
    //   126: astore 35
    //   128: aload_0
    //   129: aload 34
    //   131: iload 18
    //   133: aload 35
    //   135: invokespecial 307	com/tencent/mobileqq/app/face/FaceDownloader:a	(Ljava/lang/String;ILjava/lang/String;)V
    //   138: aload_0
    //   139: aload 34
    //   141: iload 23
    //   143: aload 35
    //   145: iconst_0
    //   146: iload 17
    //   148: aload 33
    //   150: invokevirtual 310	com/tencent/mobileqq/app/face/FaceDownloader:a	(Ljava/lang/String;ILjava/lang/String;ZILjava/lang/String;)[Ljava/lang/Object;
    //   153: astore 14
    //   155: aload 14
    //   157: iconst_0
    //   158: aaload
    //   159: checkcast 312	java/lang/Boolean
    //   162: invokevirtual 315	java/lang/Boolean:booleanValue	()Z
    //   165: istore 24
    //   167: aload 14
    //   169: iconst_1
    //   170: aaload
    //   171: checkcast 317	java/net/HttpURLConnection
    //   174: astore 14
    //   176: iload 13
    //   178: istore 15
    //   180: iload 24
    //   182: istore 25
    //   184: iload 13
    //   186: istore 7
    //   188: aload 14
    //   190: astore 31
    //   192: aload_1
    //   193: astore 32
    //   195: aload 14
    //   197: invokevirtual 320	java/net/HttpURLConnection:connect	()V
    //   200: iload 13
    //   202: istore 15
    //   204: iload 24
    //   206: istore 25
    //   208: iload 13
    //   210: istore 7
    //   212: aload 14
    //   214: astore 31
    //   216: aload_1
    //   217: astore 32
    //   219: aload 11
    //   221: aload 14
    //   223: invokevirtual 323	java/net/HttpURLConnection:getResponseCode	()I
    //   226: putfield 324	asjz:c	I
    //   229: iload 13
    //   231: istore 15
    //   233: iload 24
    //   235: istore 25
    //   237: iload 13
    //   239: istore 7
    //   241: aload 14
    //   243: astore 31
    //   245: aload_1
    //   246: astore 32
    //   248: aload 11
    //   250: aload 14
    //   252: invokevirtual 327	java/net/HttpURLConnection:getContentLength	()I
    //   255: putfield 328	asjz:e	I
    //   258: iload 13
    //   260: istore 15
    //   262: iload 24
    //   264: istore 25
    //   266: iload 13
    //   268: istore 7
    //   270: aload 14
    //   272: astore 31
    //   274: aload_1
    //   275: astore 32
    //   277: aload 11
    //   279: aload 14
    //   281: invokevirtual 331	java/net/HttpURLConnection:getContentType	()Ljava/lang/String;
    //   284: putfield 334	asjz:h	Ljava/lang/String;
    //   287: iload 13
    //   289: istore 15
    //   291: iload 24
    //   293: istore 25
    //   295: iload 13
    //   297: istore 7
    //   299: aload 14
    //   301: astore 31
    //   303: aload_1
    //   304: astore 32
    //   306: aload 11
    //   308: aload 14
    //   310: invokevirtual 337	java/net/HttpURLConnection:getContentEncoding	()Ljava/lang/String;
    //   313: putfield 339	asjz:i	Ljava/lang/String;
    //   316: iload 13
    //   318: istore 15
    //   320: iload 24
    //   322: istore 25
    //   324: iload 13
    //   326: istore 7
    //   328: aload 14
    //   330: astore 31
    //   332: aload_1
    //   333: astore 32
    //   335: aload 11
    //   337: aload 14
    //   339: ldc_w 341
    //   342: invokevirtual 344	java/net/HttpURLConnection:getHeaderField	(Ljava/lang/String;)Ljava/lang/String;
    //   345: putfield 347	asjz:f	Ljava/lang/String;
    //   348: iload 13
    //   350: istore 15
    //   352: iload 24
    //   354: istore 25
    //   356: iload 13
    //   358: istore 7
    //   360: aload 14
    //   362: astore 31
    //   364: aload_1
    //   365: astore 32
    //   367: aload 14
    //   369: ldc_w 349
    //   372: invokevirtual 344	java/net/HttpURLConnection:getHeaderField	(Ljava/lang/String;)Ljava/lang/String;
    //   375: astore 10
    //   377: iload 13
    //   379: istore 15
    //   381: iload 24
    //   383: istore 25
    //   385: iload 13
    //   387: istore 7
    //   389: aload 14
    //   391: astore 31
    //   393: aload_1
    //   394: astore 32
    //   396: iload 13
    //   398: istore 16
    //   400: aload_0
    //   401: aload_3
    //   402: iconst_5
    //   403: aload 11
    //   405: aload 14
    //   407: aload 10
    //   409: invokespecial 352	com/tencent/mobileqq/app/face/FaceDownloader:a	(Lcom/tencent/mobileqq/app/face/FaceInfo;ILasjz;Ljava/net/HttpURLConnection;Ljava/lang/String;)Z
    //   412: istore 26
    //   414: iload 26
    //   416: ifeq +249 -> 665
    //   419: aload_0
    //   420: aload_1
    //   421: aload 14
    //   423: invokespecial 355	com/tencent/mobileqq/app/face/FaceDownloader:a	(Ljava/io/OutputStream;Ljava/net/HttpURLConnection;)V
    //   426: aload_0
    //   427: iconst_5
    //   428: aload 12
    //   430: invokespecial 358	com/tencent/mobileqq/app/face/FaceDownloader:a	(ILjava/io/File;)V
    //   433: iload 17
    //   435: iconst_1
    //   436: iadd
    //   437: istore 13
    //   439: aload_0
    //   440: aload 33
    //   442: aload_3
    //   443: iconst_5
    //   444: aload 8
    //   446: iload 13
    //   448: iload 24
    //   450: aload 34
    //   452: iload 23
    //   454: iload 18
    //   456: aload 35
    //   458: invokespecial 361	com/tencent/mobileqq/app/face/FaceDownloader:a	(Ljava/lang/String;Lcom/tencent/mobileqq/app/face/FaceInfo;ILjava/lang/Object;IZLjava/lang/String;IILjava/lang/String;)V
    //   461: aload 14
    //   463: astore 10
    //   465: iconst_5
    //   466: istore 7
    //   468: lload 27
    //   470: lstore 29
    //   472: iload 7
    //   474: istore 15
    //   476: iload 7
    //   478: ifeq -428 -> 50
    //   481: lload 27
    //   483: lstore 29
    //   485: iload 7
    //   487: istore 15
    //   489: iload 13
    //   491: iload 9
    //   493: if_icmpge -443 -> 50
    //   496: aload 33
    //   498: astore 14
    //   500: iload 13
    //   502: istore 17
    //   504: goto -483 -> 21
    //   507: aconst_null
    //   508: astore 14
    //   510: goto -401 -> 109
    //   513: iconst_m1
    //   514: istore 18
    //   516: goto -395 -> 121
    //   519: astore 10
    //   521: iload 13
    //   523: istore 15
    //   525: iload 24
    //   527: istore 25
    //   529: iload 13
    //   531: istore 7
    //   533: aload 14
    //   535: astore 31
    //   537: aload_1
    //   538: astore 32
    //   540: iload 13
    //   542: istore 16
    //   544: aload_0
    //   545: iload 24
    //   547: aload 34
    //   549: iload 23
    //   551: invokespecial 364	com/tencent/mobileqq/app/face/FaceDownloader:a	(ZLjava/lang/String;I)V
    //   554: iload 13
    //   556: istore 15
    //   558: iload 24
    //   560: istore 25
    //   562: iload 13
    //   564: istore 7
    //   566: aload 14
    //   568: astore 31
    //   570: aload_1
    //   571: astore 32
    //   573: iload 13
    //   575: istore 16
    //   577: aload 10
    //   579: athrow
    //   580: astore 10
    //   582: iload 15
    //   584: istore 7
    //   586: iload 24
    //   588: istore 25
    //   590: aload 14
    //   592: astore 31
    //   594: aload_1
    //   595: astore 32
    //   597: aload_0
    //   598: aload_3
    //   599: aload 6
    //   601: aload 12
    //   603: aload 10
    //   605: invokespecial 366	com/tencent/mobileqq/app/face/FaceDownloader:a	(Lcom/tencent/mobileqq/app/face/FaceInfo;Ljava/net/URL;Ljava/io/File;Ljava/io/IOException;)I
    //   608: istore 15
    //   610: aload_0
    //   611: aload_1
    //   612: aload 14
    //   614: invokespecial 355	com/tencent/mobileqq/app/face/FaceDownloader:a	(Ljava/io/OutputStream;Ljava/net/HttpURLConnection;)V
    //   617: aload_0
    //   618: iload 15
    //   620: aload 12
    //   622: invokespecial 358	com/tencent/mobileqq/app/face/FaceDownloader:a	(ILjava/io/File;)V
    //   625: iload 17
    //   627: iconst_1
    //   628: iadd
    //   629: istore 13
    //   631: aload_0
    //   632: aload 33
    //   634: aload_3
    //   635: iload 15
    //   637: aload 8
    //   639: iload 13
    //   641: iload 24
    //   643: aload 34
    //   645: iload 23
    //   647: iload 18
    //   649: aload 35
    //   651: invokespecial 361	com/tencent/mobileqq/app/face/FaceDownloader:a	(Ljava/lang/String;Lcom/tencent/mobileqq/app/face/FaceInfo;ILjava/lang/Object;IZLjava/lang/String;IILjava/lang/String;)V
    //   654: aload 14
    //   656: astore 10
    //   658: iload 15
    //   660: istore 7
    //   662: goto -194 -> 468
    //   665: iconst_0
    //   666: istore 19
    //   668: iconst_0
    //   669: istore 20
    //   671: iconst_0
    //   672: istore 13
    //   674: iconst_0
    //   675: istore 22
    //   677: iconst_0
    //   678: istore 21
    //   680: iload 21
    //   682: istore 15
    //   684: iload 24
    //   686: istore 25
    //   688: iload 13
    //   690: istore 7
    //   692: aload 14
    //   694: astore 31
    //   696: aload_1
    //   697: astore 32
    //   699: iload 22
    //   701: istore 16
    //   703: sipush 200
    //   706: aload 11
    //   708: getfield 324	asjz:c	I
    //   711: if_icmpne +632 -> 1343
    //   714: iload 21
    //   716: istore 15
    //   718: iload 24
    //   720: istore 25
    //   722: iload 13
    //   724: istore 7
    //   726: aload 14
    //   728: astore 31
    //   730: aload_1
    //   731: astore 32
    //   733: iload 22
    //   735: istore 16
    //   737: aload 11
    //   739: getfield 328	asjz:e	I
    //   742: istore 21
    //   744: iload 21
    //   746: i2l
    //   747: lstore 27
    //   749: iconst_0
    //   750: istore 15
    //   752: iload 24
    //   754: istore 25
    //   756: iload 13
    //   758: istore 7
    //   760: aload 14
    //   762: astore 31
    //   764: aload_1
    //   765: astore 32
    //   767: aload 12
    //   769: invokevirtual 234	java/io/File:exists	()Z
    //   772: ifeq +24 -> 796
    //   775: iload 24
    //   777: istore 25
    //   779: iload 13
    //   781: istore 7
    //   783: aload 14
    //   785: astore 31
    //   787: aload_1
    //   788: astore 32
    //   790: aload 12
    //   792: invokevirtual 369	java/io/File:delete	()Z
    //   795: pop
    //   796: iload 24
    //   798: istore 25
    //   800: iload 13
    //   802: istore 7
    //   804: aload 14
    //   806: astore 31
    //   808: aload_1
    //   809: astore 32
    //   811: aload 12
    //   813: invokevirtual 372	java/io/File:createNewFile	()Z
    //   816: pop
    //   817: iload 24
    //   819: istore 25
    //   821: iload 13
    //   823: istore 7
    //   825: aload 14
    //   827: astore 31
    //   829: aload_1
    //   830: astore 32
    //   832: new 374	java/io/BufferedOutputStream
    //   835: dup
    //   836: new 376	java/io/FileOutputStream
    //   839: dup
    //   840: aload 12
    //   842: invokespecial 379	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   845: invokespecial 382	java/io/BufferedOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   848: astore 10
    //   850: aload 10
    //   852: astore 31
    //   854: aload 14
    //   856: invokevirtual 386	java/net/HttpURLConnection:getInputStream	()Ljava/io/InputStream;
    //   859: astore 32
    //   861: iload 4
    //   863: ifeq +335 -> 1198
    //   866: lload 27
    //   868: ldc2_w 387
    //   871: lcmp
    //   872: ifge +326 -> 1198
    //   875: aload 10
    //   877: astore 31
    //   879: ldc_w 389
    //   882: newarray byte
    //   884: astore_1
    //   885: iconst_0
    //   886: istore 7
    //   888: iconst_0
    //   889: istore 13
    //   891: aload 10
    //   893: astore 31
    //   895: aload 32
    //   897: aload_1
    //   898: iload 13
    //   900: sipush 1024
    //   903: invokevirtual 395	java/io/InputStream:read	([BII)I
    //   906: istore 15
    //   908: iload 15
    //   910: iconst_m1
    //   911: if_icmpeq +20 -> 931
    //   914: iload 13
    //   916: iload 15
    //   918: iadd
    //   919: istore 13
    //   921: iload 7
    //   923: iload 15
    //   925: iadd
    //   926: istore 7
    //   928: goto -37 -> 891
    //   931: aload 10
    //   933: astore 31
    //   935: aload_3
    //   936: getstatic 398	com/tencent/mobileqq/app/face/FaceInfo:o	I
    //   939: invokevirtual 400	com/tencent/mobileqq/app/face/FaceInfo:a	(I)V
    //   942: iload 7
    //   944: i2l
    //   945: lload 27
    //   947: lcmp
    //   948: ifne +160 -> 1108
    //   951: aload 10
    //   953: astore 31
    //   955: aload_3
    //   956: getstatic 403	com/tencent/mobileqq/app/face/FaceInfo:p	I
    //   959: invokevirtual 400	com/tencent/mobileqq/app/face/FaceInfo:a	(I)V
    //   962: aload 10
    //   964: astore 31
    //   966: aload_0
    //   967: aload_3
    //   968: aload_1
    //   969: iconst_0
    //   970: iload 7
    //   972: invokestatic 408	bhgm:a	([BII)Landroid/graphics/Bitmap;
    //   975: invokespecial 411	com/tencent/mobileqq/app/face/FaceDownloader:a	(Lcom/tencent/mobileqq/app/face/FaceInfo;Landroid/graphics/Bitmap;)Landroid/graphics/Bitmap;
    //   978: astore 32
    //   980: aload 10
    //   982: astore 31
    //   984: invokestatic 414	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   987: ifeq +54 -> 1041
    //   990: aload 10
    //   992: astore 31
    //   994: ldc 139
    //   996: iconst_2
    //   997: new 171	java/lang/StringBuilder
    //   1000: dup
    //   1001: invokespecial 172	java/lang/StringBuilder:<init>	()V
    //   1004: ldc_w 416
    //   1007: invokevirtual 178	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1010: aload 32
    //   1012: invokevirtual 181	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   1015: ldc_w 418
    //   1018: invokevirtual 178	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1021: aload 6
    //   1023: invokevirtual 181	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   1026: ldc 183
    //   1028: invokevirtual 178	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1031: aload_3
    //   1032: invokevirtual 181	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   1035: invokevirtual 187	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1038: invokestatic 261	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   1041: aload 10
    //   1043: astore 31
    //   1045: new 420	aoos
    //   1048: dup
    //   1049: aload_0
    //   1050: invokespecial 423	aoos:<init>	(Lcom/tencent/mobileqq/app/face/FaceDownloader;)V
    //   1053: astore 36
    //   1055: aload 10
    //   1057: astore 31
    //   1059: aload 36
    //   1061: aload_3
    //   1062: putfield 426	aoos:jdField_a_of_type_ComTencentMobileqqAppFaceFaceInfo	Lcom/tencent/mobileqq/app/face/FaceInfo;
    //   1065: aload 10
    //   1067: astore 31
    //   1069: aload 36
    //   1071: aload 32
    //   1073: putfield 429	aoos:jdField_a_of_type_AndroidGraphicsBitmap	Landroid/graphics/Bitmap;
    //   1076: aload 10
    //   1078: astore 31
    //   1080: aload_0
    //   1081: getfield 62	com/tencent/mobileqq/app/face/FaceDownloader:jdField_b_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   1084: aload 36
    //   1086: invokevirtual 432	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   1089: pop
    //   1090: aload 10
    //   1092: astore 31
    //   1094: aload_0
    //   1095: getfield 164	com/tencent/mobileqq/app/face/FaceDownloader:jdField_a_of_type_MqqOsMqqHandler	Lmqq/os/MqqHandler;
    //   1098: bipush 100
    //   1100: aload 36
    //   1102: invokevirtual 438	mqq/os/MqqHandler:obtainMessage	(ILjava/lang/Object;)Landroid/os/Message;
    //   1105: invokevirtual 443	android/os/Message:sendToTarget	()V
    //   1108: aload 10
    //   1110: astore 31
    //   1112: aload 10
    //   1114: aload_1
    //   1115: iconst_0
    //   1116: iload 7
    //   1118: invokevirtual 449	java/io/OutputStream:write	([BII)V
    //   1121: aload 10
    //   1123: astore 31
    //   1125: aload 10
    //   1127: invokevirtual 452	java/io/OutputStream:flush	()V
    //   1130: aload 10
    //   1132: astore 31
    //   1134: aload_0
    //   1135: aload_2
    //   1136: aload 12
    //   1138: invokespecial 455	com/tencent/mobileqq/app/face/FaceDownloader:a	(Ljava/io/File;Ljava/io/File;)V
    //   1141: iconst_0
    //   1142: istore 7
    //   1144: aload 10
    //   1146: astore_1
    //   1147: aload_0
    //   1148: aload_1
    //   1149: aload 14
    //   1151: invokespecial 355	com/tencent/mobileqq/app/face/FaceDownloader:a	(Ljava/io/OutputStream;Ljava/net/HttpURLConnection;)V
    //   1154: aload_0
    //   1155: iload 7
    //   1157: aload 12
    //   1159: invokespecial 358	com/tencent/mobileqq/app/face/FaceDownloader:a	(ILjava/io/File;)V
    //   1162: iload 17
    //   1164: iconst_1
    //   1165: iadd
    //   1166: istore 13
    //   1168: aload_0
    //   1169: aload 33
    //   1171: aload_3
    //   1172: iload 7
    //   1174: aload 8
    //   1176: iload 13
    //   1178: iload 24
    //   1180: aload 34
    //   1182: iload 23
    //   1184: iload 18
    //   1186: aload 35
    //   1188: invokespecial 361	com/tencent/mobileqq/app/face/FaceDownloader:a	(Ljava/lang/String;Lcom/tencent/mobileqq/app/face/FaceInfo;ILjava/lang/Object;IZLjava/lang/String;IILjava/lang/String;)V
    //   1191: aload 14
    //   1193: astore 10
    //   1195: goto -727 -> 468
    //   1198: aload 10
    //   1200: astore 31
    //   1202: sipush 1024
    //   1205: newarray byte
    //   1207: astore_1
    //   1208: iload 15
    //   1210: istore 7
    //   1212: aload 10
    //   1214: astore 31
    //   1216: aload 32
    //   1218: aload_1
    //   1219: invokevirtual 458	java/io/InputStream:read	([B)I
    //   1222: istore 13
    //   1224: iload 13
    //   1226: iconst_m1
    //   1227: if_icmpeq +86 -> 1313
    //   1230: iload 7
    //   1232: iload 13
    //   1234: iadd
    //   1235: istore 7
    //   1237: aload 10
    //   1239: astore 31
    //   1241: aload 10
    //   1243: aload_1
    //   1244: iconst_0
    //   1245: iload 13
    //   1247: invokevirtual 449	java/io/OutputStream:write	([BII)V
    //   1250: goto -38 -> 1212
    //   1253: astore_1
    //   1254: aload 10
    //   1256: astore_1
    //   1257: aload_1
    //   1258: astore 31
    //   1260: ldc 139
    //   1262: iconst_1
    //   1263: new 171	java/lang/StringBuilder
    //   1266: dup
    //   1267: invokespecial 172	java/lang/StringBuilder:<init>	()V
    //   1270: ldc_w 460
    //   1273: invokevirtual 178	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1276: aload 12
    //   1278: invokevirtual 234	java/io/File:exists	()Z
    //   1281: invokevirtual 253	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   1284: ldc_w 462
    //   1287: invokevirtual 178	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1290: aload 12
    //   1292: invokevirtual 243	java/io/File:getParentFile	()Ljava/io/File;
    //   1295: invokevirtual 234	java/io/File:exists	()Z
    //   1298: invokevirtual 253	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   1301: invokevirtual 187	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1304: invokestatic 261	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   1307: iconst_4
    //   1308: istore 7
    //   1310: goto -163 -> 1147
    //   1313: aload 10
    //   1315: astore 31
    //   1317: aload_3
    //   1318: getstatic 398	com/tencent/mobileqq/app/face/FaceInfo:o	I
    //   1321: invokevirtual 400	com/tencent/mobileqq/app/face/FaceInfo:a	(I)V
    //   1324: goto -203 -> 1121
    //   1327: astore 31
    //   1329: aload 10
    //   1331: astore_1
    //   1332: aload 31
    //   1334: astore 10
    //   1336: iload 19
    //   1338: istore 7
    //   1340: goto -754 -> 586
    //   1343: iload 21
    //   1345: istore 15
    //   1347: iload 24
    //   1349: istore 25
    //   1351: iload 13
    //   1353: istore 7
    //   1355: aload 14
    //   1357: astore 31
    //   1359: aload_1
    //   1360: astore 32
    //   1362: iload 22
    //   1364: istore 16
    //   1366: aload 11
    //   1368: getfield 324	asjz:c	I
    //   1371: istore 13
    //   1373: iload 13
    //   1375: istore 7
    //   1377: goto -230 -> 1147
    //   1380: astore 31
    //   1382: aload 10
    //   1384: astore_1
    //   1385: aload 31
    //   1387: astore 10
    //   1389: iload 20
    //   1391: istore 7
    //   1393: iload 24
    //   1395: istore 25
    //   1397: aload 14
    //   1399: astore 31
    //   1401: aload_1
    //   1402: astore 32
    //   1404: ldc 139
    //   1406: iconst_1
    //   1407: new 171	java/lang/StringBuilder
    //   1410: dup
    //   1411: invokespecial 172	java/lang/StringBuilder:<init>	()V
    //   1414: ldc_w 464
    //   1417: invokevirtual 178	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1420: aload 6
    //   1422: invokevirtual 181	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   1425: ldc 183
    //   1427: invokevirtual 178	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1430: aload_3
    //   1431: invokevirtual 181	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   1434: invokevirtual 187	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1437: aload 10
    //   1439: invokestatic 190	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   1442: aload_0
    //   1443: aload_1
    //   1444: aload 14
    //   1446: invokespecial 355	com/tencent/mobileqq/app/face/FaceDownloader:a	(Ljava/io/OutputStream;Ljava/net/HttpURLConnection;)V
    //   1449: aload_0
    //   1450: iconst_5
    //   1451: aload 12
    //   1453: invokespecial 358	com/tencent/mobileqq/app/face/FaceDownloader:a	(ILjava/io/File;)V
    //   1456: iload 17
    //   1458: iconst_1
    //   1459: iadd
    //   1460: istore 13
    //   1462: aload_0
    //   1463: aload 33
    //   1465: aload_3
    //   1466: iconst_5
    //   1467: aload 8
    //   1469: iload 13
    //   1471: iload 24
    //   1473: aload 34
    //   1475: iload 23
    //   1477: iload 18
    //   1479: aload 35
    //   1481: invokespecial 361	com/tencent/mobileqq/app/face/FaceDownloader:a	(Ljava/lang/String;Lcom/tencent/mobileqq/app/face/FaceInfo;ILjava/lang/Object;IZLjava/lang/String;IILjava/lang/String;)V
    //   1484: aload 14
    //   1486: astore 10
    //   1488: iconst_5
    //   1489: istore 7
    //   1491: goto -1023 -> 468
    //   1494: astore_2
    //   1495: iconst_0
    //   1496: istore 7
    //   1498: aload 31
    //   1500: astore_1
    //   1501: aload_0
    //   1502: aload_1
    //   1503: aload 14
    //   1505: invokespecial 355	com/tencent/mobileqq/app/face/FaceDownloader:a	(Ljava/io/OutputStream;Ljava/net/HttpURLConnection;)V
    //   1508: aload_0
    //   1509: iload 7
    //   1511: aload 12
    //   1513: invokespecial 358	com/tencent/mobileqq/app/face/FaceDownloader:a	(ILjava/io/File;)V
    //   1516: aload_0
    //   1517: aload 33
    //   1519: aload_3
    //   1520: iload 7
    //   1522: aload 8
    //   1524: iload 17
    //   1526: iconst_1
    //   1527: iadd
    //   1528: iload 24
    //   1530: aload 34
    //   1532: iload 23
    //   1534: iload 18
    //   1536: aload 35
    //   1538: invokespecial 361	com/tencent/mobileqq/app/face/FaceDownloader:a	(Ljava/lang/String;Lcom/tencent/mobileqq/app/face/FaceInfo;ILjava/lang/Object;IZLjava/lang/String;IILjava/lang/String;)V
    //   1541: aload_2
    //   1542: athrow
    //   1543: astore_2
    //   1544: aload 32
    //   1546: astore_1
    //   1547: iload 25
    //   1549: istore 24
    //   1551: aload 31
    //   1553: astore 14
    //   1555: goto -54 -> 1501
    //   1558: astore_2
    //   1559: iconst_0
    //   1560: istore 24
    //   1562: iconst_5
    //   1563: istore 7
    //   1565: aload 10
    //   1567: astore 14
    //   1569: goto -68 -> 1501
    //   1572: astore_2
    //   1573: iconst_5
    //   1574: istore 7
    //   1576: aload 10
    //   1578: astore 14
    //   1580: goto -79 -> 1501
    //   1583: astore 10
    //   1585: iload 20
    //   1587: istore 7
    //   1589: goto -196 -> 1393
    //   1592: astore 31
    //   1594: iconst_0
    //   1595: istore 24
    //   1597: aload 10
    //   1599: astore 14
    //   1601: aload 31
    //   1603: astore 10
    //   1605: iload 13
    //   1607: istore 7
    //   1609: goto -216 -> 1393
    //   1612: astore 31
    //   1614: aload 10
    //   1616: astore 14
    //   1618: aload 31
    //   1620: astore 10
    //   1622: iload 13
    //   1624: istore 7
    //   1626: goto -233 -> 1393
    //   1629: astore 10
    //   1631: iload 16
    //   1633: istore 7
    //   1635: goto -242 -> 1393
    //   1638: astore 10
    //   1640: iload 20
    //   1642: istore 7
    //   1644: goto -251 -> 1393
    //   1647: astore 10
    //   1649: iload 19
    //   1651: istore 7
    //   1653: goto -1067 -> 586
    //   1656: astore 31
    //   1658: iconst_0
    //   1659: istore 24
    //   1661: aload 10
    //   1663: astore 14
    //   1665: aload 31
    //   1667: astore 10
    //   1669: iload 13
    //   1671: istore 7
    //   1673: goto -1087 -> 586
    //   1676: astore 31
    //   1678: aload 10
    //   1680: astore 14
    //   1682: aload 31
    //   1684: astore 10
    //   1686: iload 13
    //   1688: istore 7
    //   1690: goto -1104 -> 586
    //   1693: astore 10
    //   1695: iload 19
    //   1697: istore 7
    //   1699: goto -1113 -> 586
    //   1702: astore 10
    //   1704: goto -447 -> 1257
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1707	0	this	FaceDownloader
    //   0	1707	1	paramString	String
    //   0	1707	2	paramFile1	File
    //   0	1707	3	paramFaceInfo	FaceInfo
    //   0	1707	4	paramBoolean	boolean
    //   0	1707	5	paramNetworkInfo	android.net.NetworkInfo
    //   0	1707	6	paramURL	URL
    //   0	1707	7	paramInt1	int
    //   0	1707	8	paramObject	Object
    //   0	1707	9	paramInt2	int
    //   0	1707	10	paramOutputStream	OutputStream
    //   0	1707	11	paramasjz	asjz
    //   0	1707	12	paramFile2	File
    //   0	1707	13	paramInt3	int
    //   0	1707	14	paramHttpURLConnection	HttpURLConnection
    //   44	1302	15	i	int
    //   398	1234	16	j	int
    //   11	1517	17	k	int
    //   119	1416	18	m	int
    //   666	1030	19	n	int
    //   669	972	20	i1	int
    //   678	666	21	i2	int
    //   675	688	22	i3	int
    //   95	1438	23	i4	int
    //   165	1495	24	bool1	boolean
    //   182	1366	25	bool2	boolean
    //   412	3	26	bool3	boolean
    //   1	945	27	l1	long
    //   48	436	29	l2	long
    //   4	1312	31	localObject1	Object
    //   1327	6	31	localIOException1	IOException
    //   1357	1	31	localHttpURLConnection1	HttpURLConnection
    //   1380	6	31	localThrowable1	Throwable
    //   1399	153	31	localHttpURLConnection2	HttpURLConnection
    //   1592	10	31	localThrowable2	Throwable
    //   1612	7	31	localThrowable3	Throwable
    //   1656	10	31	localIOException2	IOException
    //   1676	7	31	localIOException3	IOException
    //   193	1352	32	localObject2	Object
    //   23	1495	33	localObject3	Object
    //   90	1441	34	str1	String
    //   126	1411	35	str2	String
    //   1053	48	36	localaoos	aoos
    // Exception table:
    //   from	to	target	type
    //   195	200	519	java/lang/Throwable
    //   219	229	519	java/lang/Throwable
    //   248	258	519	java/lang/Throwable
    //   277	287	519	java/lang/Throwable
    //   306	316	519	java/lang/Throwable
    //   335	348	519	java/lang/Throwable
    //   367	377	519	java/lang/Throwable
    //   195	200	580	java/io/IOException
    //   219	229	580	java/io/IOException
    //   248	258	580	java/io/IOException
    //   277	287	580	java/io/IOException
    //   306	316	580	java/io/IOException
    //   335	348	580	java/io/IOException
    //   367	377	580	java/io/IOException
    //   400	414	580	java/io/IOException
    //   544	554	580	java/io/IOException
    //   577	580	580	java/io/IOException
    //   703	714	580	java/io/IOException
    //   737	744	580	java/io/IOException
    //   1366	1373	580	java/io/IOException
    //   854	861	1253	java/io/FileNotFoundException
    //   879	885	1253	java/io/FileNotFoundException
    //   895	908	1253	java/io/FileNotFoundException
    //   935	942	1253	java/io/FileNotFoundException
    //   955	962	1253	java/io/FileNotFoundException
    //   966	980	1253	java/io/FileNotFoundException
    //   984	990	1253	java/io/FileNotFoundException
    //   994	1041	1253	java/io/FileNotFoundException
    //   1045	1055	1253	java/io/FileNotFoundException
    //   1059	1065	1253	java/io/FileNotFoundException
    //   1069	1076	1253	java/io/FileNotFoundException
    //   1080	1090	1253	java/io/FileNotFoundException
    //   1094	1108	1253	java/io/FileNotFoundException
    //   1112	1121	1253	java/io/FileNotFoundException
    //   1125	1130	1253	java/io/FileNotFoundException
    //   1134	1141	1253	java/io/FileNotFoundException
    //   1202	1208	1253	java/io/FileNotFoundException
    //   1216	1224	1253	java/io/FileNotFoundException
    //   1241	1250	1253	java/io/FileNotFoundException
    //   1317	1324	1253	java/io/FileNotFoundException
    //   854	861	1327	java/io/IOException
    //   879	885	1327	java/io/IOException
    //   895	908	1327	java/io/IOException
    //   935	942	1327	java/io/IOException
    //   955	962	1327	java/io/IOException
    //   966	980	1327	java/io/IOException
    //   984	990	1327	java/io/IOException
    //   994	1041	1327	java/io/IOException
    //   1045	1055	1327	java/io/IOException
    //   1059	1065	1327	java/io/IOException
    //   1069	1076	1327	java/io/IOException
    //   1080	1090	1327	java/io/IOException
    //   1094	1108	1327	java/io/IOException
    //   1112	1121	1327	java/io/IOException
    //   1125	1130	1327	java/io/IOException
    //   1134	1141	1327	java/io/IOException
    //   1202	1208	1327	java/io/IOException
    //   1216	1224	1327	java/io/IOException
    //   1241	1250	1327	java/io/IOException
    //   1317	1324	1327	java/io/IOException
    //   854	861	1380	java/lang/Throwable
    //   879	885	1380	java/lang/Throwable
    //   895	908	1380	java/lang/Throwable
    //   935	942	1380	java/lang/Throwable
    //   955	962	1380	java/lang/Throwable
    //   966	980	1380	java/lang/Throwable
    //   984	990	1380	java/lang/Throwable
    //   994	1041	1380	java/lang/Throwable
    //   1045	1055	1380	java/lang/Throwable
    //   1059	1065	1380	java/lang/Throwable
    //   1069	1076	1380	java/lang/Throwable
    //   1080	1090	1380	java/lang/Throwable
    //   1094	1108	1380	java/lang/Throwable
    //   1112	1121	1380	java/lang/Throwable
    //   1125	1130	1380	java/lang/Throwable
    //   1134	1141	1380	java/lang/Throwable
    //   1202	1208	1380	java/lang/Throwable
    //   1216	1224	1380	java/lang/Throwable
    //   1241	1250	1380	java/lang/Throwable
    //   1317	1324	1380	java/lang/Throwable
    //   854	861	1494	finally
    //   879	885	1494	finally
    //   895	908	1494	finally
    //   935	942	1494	finally
    //   955	962	1494	finally
    //   966	980	1494	finally
    //   984	990	1494	finally
    //   994	1041	1494	finally
    //   1045	1055	1494	finally
    //   1059	1065	1494	finally
    //   1069	1076	1494	finally
    //   1080	1090	1494	finally
    //   1094	1108	1494	finally
    //   1112	1121	1494	finally
    //   1125	1130	1494	finally
    //   1134	1141	1494	finally
    //   1202	1208	1494	finally
    //   1216	1224	1494	finally
    //   1241	1250	1494	finally
    //   1260	1307	1494	finally
    //   1317	1324	1494	finally
    //   195	200	1543	finally
    //   219	229	1543	finally
    //   248	258	1543	finally
    //   277	287	1543	finally
    //   306	316	1543	finally
    //   335	348	1543	finally
    //   367	377	1543	finally
    //   400	414	1543	finally
    //   544	554	1543	finally
    //   577	580	1543	finally
    //   597	610	1543	finally
    //   703	714	1543	finally
    //   737	744	1543	finally
    //   767	775	1543	finally
    //   790	796	1543	finally
    //   811	817	1543	finally
    //   832	850	1543	finally
    //   1366	1373	1543	finally
    //   1404	1442	1543	finally
    //   128	167	1558	finally
    //   167	176	1572	finally
    //   1260	1307	1583	java/lang/Throwable
    //   128	167	1592	java/lang/Throwable
    //   167	176	1612	java/lang/Throwable
    //   400	414	1629	java/lang/Throwable
    //   544	554	1629	java/lang/Throwable
    //   577	580	1629	java/lang/Throwable
    //   703	714	1629	java/lang/Throwable
    //   737	744	1629	java/lang/Throwable
    //   1366	1373	1629	java/lang/Throwable
    //   767	775	1638	java/lang/Throwable
    //   790	796	1638	java/lang/Throwable
    //   811	817	1638	java/lang/Throwable
    //   832	850	1638	java/lang/Throwable
    //   1260	1307	1647	java/io/IOException
    //   128	167	1656	java/io/IOException
    //   167	176	1676	java/io/IOException
    //   767	775	1693	java/io/IOException
    //   790	796	1693	java/io/IOException
    //   811	817	1693	java/io/IOException
    //   832	850	1693	java/io/IOException
    //   767	775	1702	java/io/FileNotFoundException
    //   790	796	1702	java/io/FileNotFoundException
    //   811	817	1702	java/io/FileNotFoundException
    //   832	850	1702	java/io/FileNotFoundException
  }
  
  private Bitmap a(FaceInfo paramFaceInfo, Bitmap paramBitmap)
  {
    Bitmap localBitmap = paramBitmap;
    if (paramBitmap != null)
    {
      localBitmap = paramBitmap;
      switch (paramFaceInfo.c)
      {
      case 2: 
      default: 
        localBitmap = bhmq.c(paramBitmap, 50, 50);
      }
    }
    for (;;)
    {
      ((aope)this.jdField_a_of_type_ComTencentCommonAppAppInterface.getManager(216)).a(paramFaceInfo.a(), localBitmap, aope.a(paramFaceInfo.jdField_a_of_type_Int));
      paramFaceInfo.a(FaceInfo.q);
      return localBitmap;
      localBitmap = QQAppInterface.a(paramBitmap, bhmq.a(paramBitmap.getWidth()), 50, 50);
      continue;
      localBitmap = bhmq.a(paramBitmap, 50, 50);
    }
  }
  
  public static String a(int paramInt)
  {
    if ((paramInt == 4) || (paramInt == 8)) {
      return "";
    }
    String str2 = b(paramInt);
    paramInt = bhnv.a(BaseApplicationImpl.getApplication().getApplicationContext());
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
    String str = InnerDns.getInstance().reqDns("q.qlogo.cn", 1003);
    if (QLog.isColorLevel()) {
      QLog.i("InnerDns", 2, "get1080QQHeadDownLoadUrl.choosedIp=" + str);
    }
    StringBuilder localStringBuilder = new StringBuilder("https://");
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
        break label147;
      }
      paramByte = 0;
    }
    for (;;)
    {
      return str + paramByte;
      localStringBuilder.append("q.qlogo.cn");
      break;
      label147:
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
  
  @NotNull
  private String a(String paramString, FaceInfo paramFaceInfo, int paramInt, QQHeadInfo paramQQHeadInfo)
  {
    String str = "q.qlogo.cn";
    if (paramQQHeadInfo.dstUsrType == 32) {
      if (paramQQHeadInfo.originUsrType == 1) {
        str = "q.qlogo.cn";
      }
    }
    for (;;)
    {
      StringBuilder localStringBuilder = new StringBuilder("https://");
      localStringBuilder.append(str);
      int i = paramString.indexOf("/", 8);
      paramQQHeadInfo = paramString;
      if (i > 8)
      {
        localStringBuilder.append(paramString.substring(i));
        paramQQHeadInfo = localStringBuilder.toString();
      }
      QLog.d("Q.qqhead.FaceDownloader", 1, "downloadData retry tryCount =" + paramInt + ",urlString=" + paramQQHeadInfo + ",faceInfo=" + paramFaceInfo);
      return paramQQHeadInfo;
      if (paramQQHeadInfo.originUsrType == 32)
      {
        str = "p.qlogo.cn";
        continue;
        if (paramQQHeadInfo.dstUsrType == 16) {
          str = "q.qlogo.cn";
        } else if ((paramQQHeadInfo.dstUsrType == 4) || (paramQQHeadInfo.dstUsrType == 8)) {
          str = "p.qlogo.cn";
        } else {
          str = "q.qlogo.cn";
        }
      }
    }
  }
  
  private String a(String paramString, boolean paramBoolean)
  {
    int i = 28;
    boolean bool = anzk.a().a();
    int j = NetConnInfoCenter.getActiveNetIpFamily(true);
    Object localObject;
    if (j == 3)
    {
      localObject = InnerDns.getInstance();
      if (bool)
      {
        j = 28;
        localObject = ((InnerDns)localObject).reqDnsForIpList(paramString, 1003, true, j);
        if ((localObject != null) && (((ArrayList)localObject).size() != 0) && (!paramBoolean)) {
          break label215;
        }
        localObject = InnerDns.getInstance();
        if (bool) {
          i = 1;
        }
        paramString = ((InnerDns)localObject).reqDnsForIpList(paramString, 1003, true, i);
      }
    }
    for (;;)
    {
      if ((paramString != null) && (paramString.size() > 0))
      {
        if (QLog.isColorLevel()) {
          QLog.i("InnerDns", 2, "getQQHeandDownLoadUrl.choosedIp = " + (String)paramString.get(0));
        }
        return (String)paramString.get(0);
        j = 1;
        break;
        if (j == 2)
        {
          j = 1;
          label167:
          localObject = InnerDns.getInstance();
          if (j == 0) {
            break label198;
          }
        }
        for (;;)
        {
          paramString = ((InnerDns)localObject).reqDnsForIpList(paramString, 1003, true, i);
          break;
          j = 0;
          break label167;
          label198:
          i = 1;
        }
      }
      QLog.d("InnerDns", 1, "getQQHeandDownLoadUrl() ipList is null");
      return null;
      label215:
      paramString = (String)localObject;
    }
  }
  
  private void a(int paramInt, File paramFile)
  {
    if ((paramInt != 0) && (paramFile != null)) {}
    try
    {
      a(paramFile);
      if (paramFile.exists())
      {
        boolean bool = paramFile.delete();
        QLog.i("Q.qqhead.FaceDownloader", 1, "delete file in finally: " + bool);
      }
      return;
    }
    catch (Exception paramFile)
    {
      paramFile.printStackTrace();
    }
  }
  
  private void a(FaceInfo paramFaceInfo, boolean paramBoolean, long paramLong, int paramInt)
  {
    aoos localaoos;
    if (paramBoolean)
    {
      localaoos = new aoos(this);
      localaoos.jdField_a_of_type_ComTencentMobileqqAppFaceFaceInfo = paramFaceInfo;
      if (paramInt == 0) {
        break label63;
      }
      paramFaceInfo.a(FaceInfo.o);
      localaoos.jdField_a_of_type_AndroidGraphicsBitmap = null;
      this.jdField_b_of_type_JavaUtilArrayList.add(localaoos);
      this.jdField_a_of_type_MqqOsMqqHandler.obtainMessage(100, localaoos).sendToTarget();
    }
    label63:
    while (paramLong < 20480L) {
      return;
    }
    paramFaceInfo.a(FaceInfo.p);
    bhgn localbhgn = new bhgn();
    BitmapFactory.Options localOptions = new BitmapFactory.Options();
    localOptions.inPreferredConfig = aooa.a;
    aope localaope = (aope)this.jdField_a_of_type_ComTencentCommonAppAppInterface.getManager(216);
    paramInt = 0;
    for (;;)
    {
      bhgm.a(localaope.a(paramFaceInfo), localOptions, localbhgn);
      if (localbhgn.jdField_a_of_type_Int == 1)
      {
        NearbyAppInterface localNearbyAppInterface = (NearbyAppInterface)this.jdField_a_of_type_ComTencentCommonAppAppInterface;
        NearbyAppInterface.b();
      }
      paramInt += 1;
      if ((paramInt >= 2) || (localbhgn.jdField_a_of_type_Int != 1))
      {
        if (localbhgn.jdField_a_of_type_AndroidGraphicsBitmap != null) {
          switch (paramFaceInfo.c)
          {
          case 2: 
          case 4: 
          default: 
            localbhgn.jdField_a_of_type_AndroidGraphicsBitmap = bhmq.c(localbhgn.jdField_a_of_type_AndroidGraphicsBitmap, 50, 50);
          }
        }
        for (;;)
        {
          localaope.a(paramFaceInfo.a(), localbhgn.jdField_a_of_type_AndroidGraphicsBitmap, aope.a(paramFaceInfo.jdField_a_of_type_Int));
          paramFaceInfo.a(FaceInfo.q);
          localaoos.jdField_a_of_type_AndroidGraphicsBitmap = localbhgn.jdField_a_of_type_AndroidGraphicsBitmap;
          this.jdField_b_of_type_JavaUtilArrayList.add(localaoos);
          this.jdField_a_of_type_MqqOsMqqHandler.obtainMessage(100, localaoos).sendToTarget();
          return;
          paramInt = bhmq.a(localbhgn.jdField_a_of_type_AndroidGraphicsBitmap.getWidth());
          localbhgn.jdField_a_of_type_AndroidGraphicsBitmap = QQAppInterface.a(localbhgn.jdField_a_of_type_AndroidGraphicsBitmap, paramInt, 50, 50);
          continue;
          localbhgn.jdField_a_of_type_AndroidGraphicsBitmap = bhmq.a(localbhgn.jdField_a_of_type_AndroidGraphicsBitmap, 50, 50);
        }
      }
    }
  }
  
  private void a(File paramFile)
  {
    paramFile = paramFile.getParentFile();
    if ((paramFile != null) && (!paramFile.exists())) {
      paramFile.mkdirs();
    }
  }
  
  private void a(File paramFile1, File paramFile2)
  {
    if (paramFile1.exists()) {
      paramFile1.delete();
    }
    paramFile2.renameTo(paramFile1);
    paramFile1.setLastModified(System.currentTimeMillis());
  }
  
  private void a(OutputStream paramOutputStream, HttpURLConnection paramHttpURLConnection)
  {
    if (paramHttpURLConnection != null) {
      paramHttpURLConnection.disconnect();
    }
    if (paramOutputStream != null) {}
    try
    {
      paramOutputStream.close();
      return;
    }
    catch (IOException paramOutputStream) {}
  }
  
  private void a(String paramString1, int paramInt, String paramString2)
  {
    if (!paramString2.equals(jdField_a_of_type_JavaLangString)) {
      if ((paramInt != 1) && (!paramString2.equals(bhvd.d))) {
        break label63;
      }
    }
    label63:
    for (jdField_a_of_type_Boolean = false;; jdField_a_of_type_Boolean = true)
    {
      jdField_a_of_type_JavaLangString = paramString2;
      if ((paramInt == 1) && (("10.0.0.172".equals(paramString1)) || ("10.0.0.200".equals(paramString1)))) {
        jdField_a_of_type_Boolean = true;
      }
      return;
    }
  }
  
  /* Error */
  private void a(String paramString1, FaceInfo paramFaceInfo, int paramInt1, Object paramObject, int paramInt2, boolean paramBoolean, String paramString2, int paramInt3, int paramInt4, String paramString3)
  {
    // Byte code:
    //   0: iload_3
    //   1: ifeq +138 -> 139
    //   4: ldc 139
    //   6: iconst_1
    //   7: new 171	java/lang/StringBuilder
    //   10: dup
    //   11: invokespecial 172	java/lang/StringBuilder:<init>	()V
    //   14: ldc_w 680
    //   17: invokevirtual 178	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   20: iload_3
    //   21: invokevirtual 248	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   24: ldc_w 682
    //   27: invokevirtual 178	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   30: aload_1
    //   31: invokevirtual 178	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   34: ldc_w 684
    //   37: invokevirtual 178	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   40: iload 5
    //   42: invokevirtual 248	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   45: ldc 183
    //   47: invokevirtual 178	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   50: aload_2
    //   51: invokevirtual 181	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   54: ldc_w 686
    //   57: invokevirtual 178	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   60: iload 6
    //   62: invokevirtual 253	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   65: ldc_w 688
    //   68: invokevirtual 178	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   71: aload 7
    //   73: invokevirtual 178	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   76: ldc_w 690
    //   79: invokevirtual 178	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   82: iload 8
    //   84: invokevirtual 248	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   87: ldc_w 692
    //   90: invokevirtual 178	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   93: getstatic 672	com/tencent/mobileqq/app/face/FaceDownloader:jdField_a_of_type_Boolean	Z
    //   96: invokevirtual 253	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   99: ldc_w 694
    //   102: invokevirtual 178	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   105: iload 9
    //   107: invokevirtual 248	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   110: ldc_w 696
    //   113: invokevirtual 178	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   116: aload 10
    //   118: invokevirtual 178	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   121: ldc_w 698
    //   124: invokevirtual 178	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   127: getstatic 30	com/tencent/mobileqq/app/face/FaceDownloader:e	I
    //   130: invokevirtual 248	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   133: invokevirtual 187	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   136: invokestatic 261	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   139: iload_3
    //   140: ifeq +34 -> 174
    //   143: iload 5
    //   145: iconst_2
    //   146: if_icmpge +28 -> 174
    //   149: aload 4
    //   151: monitorenter
    //   152: aload 4
    //   154: ldc2_w 699
    //   157: invokevirtual 704	java/lang/Object:wait	(J)V
    //   160: aload 4
    //   162: monitorexit
    //   163: return
    //   164: astore_1
    //   165: aload 4
    //   167: monitorexit
    //   168: aload_1
    //   169: athrow
    //   170: astore_1
    //   171: goto -11 -> 160
    //   174: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	175	0	this	FaceDownloader
    //   0	175	1	paramString1	String
    //   0	175	2	paramFaceInfo	FaceInfo
    //   0	175	3	paramInt1	int
    //   0	175	4	paramObject	Object
    //   0	175	5	paramInt2	int
    //   0	175	6	paramBoolean	boolean
    //   0	175	7	paramString2	String
    //   0	175	8	paramInt3	int
    //   0	175	9	paramInt4	int
    //   0	175	10	paramString3	String
    // Exception table:
    //   from	to	target	type
    //   152	160	164	finally
    //   160	163	164	finally
    //   165	168	164	finally
    //   152	160	170	java/lang/InterruptedException
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
  
  private static void a(HttpsURLConnection paramHttpsURLConnection, URL paramURL, boolean paramBoolean)
  {
    aoop localaoop = new aoop(paramBoolean, paramURL);
    paramHttpsURLConnection.setRequestProperty("host", paramURL.getHost());
    paramHttpsURLConnection.setSSLSocketFactory(new bhve(paramURL.getHost(), localaoop));
    paramHttpsURLConnection.setHostnameVerifier(localaoop);
  }
  
  private void a(boolean paramBoolean, String paramString, int paramInt)
  {
    if (paramBoolean) {
      jdField_a_of_type_Boolean = true;
    }
    while ((paramString == null) || (paramInt <= 0)) {
      return;
    }
    jdField_a_of_type_Boolean = false;
  }
  
  private boolean a(FaceInfo paramFaceInfo, int paramInt, asjz paramasjz, HttpURLConnection paramHttpURLConnection, String paramString)
  {
    boolean bool1 = false;
    boolean bool2 = false;
    if (!TextUtils.isEmpty(paramString))
    {
      QLog.i("Q.qqhead.FaceDownloader", 1, "Download has X-ErrNo，X-ErrNo=" + paramString);
      a(paramHttpURLConnection, paramFaceInfo);
      return bool2;
    }
    bool2 = bool1;
    if (paramasjz.f == null) {
      if (paramasjz.c != 200) {
        break label146;
      }
    }
    for (;;)
    {
      bool2 = true;
      bool1 = bool2;
      if (!TextUtils.isEmpty(paramFaceInfo.jdField_a_of_type_AvatarInfoQQHeadInfo.headVerify))
      {
        bool1 = bool2;
        if (paramasjz.f != null)
        {
          bool1 = bool2;
          if (!paramasjz.f.equals(paramFaceInfo.jdField_a_of_type_AvatarInfoQQHeadInfo.headVerify)) {
            bool1 = true;
          }
        }
      }
      bool2 = bool1;
      if (!bool1) {
        break;
      }
      a(paramHttpURLConnection, paramFaceInfo);
      return bool1;
      label146:
      paramInt = paramasjz.c;
    }
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
      for (this.jdField_a_of_type_Aoor = a(); QLog.isColorLevel(); this.jdField_a_of_type_Aoor = new aoor(this))
      {
        QLog.i("Q.qqhead.FaceDownloader", 2, "initFaceDownloadThreadInfo, maxThreadCount=" + this.jdField_a_of_type_Aoor.jdField_a_of_type_Int + ",priority=" + this.jdField_a_of_type_Aoor.jdField_b_of_type_Int);
        return;
      }
    }
  }
  
  private void c()
  {
    ThreadManager.post(new FaceDownloader.3(this), 5, null, true);
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
  public int a(String paramString, File paramFile, FaceInfo paramFaceInfo, boolean paramBoolean)
  {
    // Byte code:
    //   0: invokestatic 820	com/tencent/mobileqq/msf/sdk/AppNetConnInfo:getRecentNetworkInfo	()Landroid/net/NetworkInfo;
    //   3: astore 6
    //   5: aload 6
    //   7: ifnonnull +14 -> 21
    //   10: ldc 139
    //   12: iconst_1
    //   13: ldc_w 822
    //   16: invokestatic 261	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   19: iconst_1
    //   20: ireturn
    //   21: new 723	java/net/URL
    //   24: dup
    //   25: aload_1
    //   26: invokespecial 823	java/net/URL:<init>	(Ljava/lang/String;)V
    //   29: astore 7
    //   31: invokestatic 656	java/lang/System:currentTimeMillis	()J
    //   34: pop2
    //   35: new 4	java/lang/Object
    //   38: dup
    //   39: invokespecial 37	java/lang/Object:<init>	()V
    //   42: astore 8
    //   44: aload_0
    //   45: aload_2
    //   46: invokespecial 614	com/tencent/mobileqq/app/face/FaceDownloader:a	(Ljava/io/File;)V
    //   49: new 277	asjz
    //   52: dup
    //   53: aload_1
    //   54: aconst_null
    //   55: iconst_0
    //   56: invokespecial 826	asjz:<init>	(Ljava/lang/String;Ljava/io/File;I)V
    //   59: astore 5
    //   61: new 828	org/apache/http/client/methods/HttpGet
    //   64: dup
    //   65: aload_1
    //   66: invokespecial 829	org/apache/http/client/methods/HttpGet:<init>	(Ljava/lang/String;)V
    //   69: pop
    //   70: new 231	java/io/File
    //   73: dup
    //   74: new 171	java/lang/StringBuilder
    //   77: dup
    //   78: invokespecial 172	java/lang/StringBuilder:<init>	()V
    //   81: aload_2
    //   82: invokevirtual 832	java/io/File:getPath	()Ljava/lang/String;
    //   85: invokevirtual 178	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   88: ldc_w 834
    //   91: invokevirtual 178	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   94: invokevirtual 187	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   97: invokespecial 835	java/io/File:<init>	(Ljava/lang/String;)V
    //   100: astore 9
    //   102: aload 9
    //   104: invokevirtual 234	java/io/File:exists	()Z
    //   107: ifeq +9 -> 116
    //   110: aload 9
    //   112: invokevirtual 369	java/io/File:delete	()Z
    //   115: pop
    //   116: aload_0
    //   117: aload_1
    //   118: aload_2
    //   119: aload_3
    //   120: iload 4
    //   122: aload 6
    //   124: aload 7
    //   126: iconst_5
    //   127: aload 8
    //   129: iconst_2
    //   130: aconst_null
    //   131: aload 5
    //   133: aload 9
    //   135: iconst_m1
    //   136: aconst_null
    //   137: invokespecial 837	com/tencent/mobileqq/app/face/FaceDownloader:a	(Ljava/lang/String;Ljava/io/File;Lcom/tencent/mobileqq/app/face/FaceInfo;ZLandroid/net/NetworkInfo;Ljava/net/URL;ILjava/lang/Object;ILjava/io/OutputStream;Lasjz;Ljava/io/File;ILjava/net/HttpURLConnection;)I
    //   140: ireturn
    //   141: astore_1
    //   142: aload_1
    //   143: invokevirtual 838	java/net/MalformedURLException:printStackTrace	()V
    //   146: bipush 13
    //   148: ireturn
    //   149: astore_1
    //   150: ldc 139
    //   152: iconst_1
    //   153: ldc_w 840
    //   156: invokestatic 579	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   159: iconst_4
    //   160: ireturn
    //   161: astore 9
    //   163: aload_1
    //   164: invokestatic 844	com/tencent/mobileqq/utils/HttpDownloadUtil:a	(Ljava/lang/String;)Ljava/lang/String;
    //   167: astore_1
    //   168: goto -98 -> 70
    //   171: astore_1
    //   172: ldc 139
    //   174: iconst_1
    //   175: ldc_w 846
    //   178: invokestatic 579	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   181: aload 5
    //   183: bipush 13
    //   185: putfield 278	asjz:jdField_b_of_type_Int	I
    //   188: bipush 13
    //   190: ireturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	191	0	this	FaceDownloader
    //   0	191	1	paramString	String
    //   0	191	2	paramFile	File
    //   0	191	3	paramFaceInfo	FaceInfo
    //   0	191	4	paramBoolean	boolean
    //   59	123	5	localasjz	asjz
    //   3	120	6	localNetworkInfo	android.net.NetworkInfo
    //   29	96	7	localURL	URL
    //   42	86	8	localObject	Object
    //   100	34	9	localFile	File
    //   161	1	9	localIllegalArgumentException	java.lang.IllegalArgumentException
    // Exception table:
    //   from	to	target	type
    //   21	31	141	java/net/MalformedURLException
    //   44	49	149	java/lang/Exception
    //   61	70	161	java/lang/IllegalArgumentException
    //   163	168	171	java/lang/IllegalArgumentException
  }
  
  public aoor a()
  {
    aoor localaoor = new aoor(this);
    int i = Runtime.getRuntime().availableProcessors();
    if (QLog.isColorLevel()) {
      QLog.i("Q.qqhead.FaceDownloader", 2, "processor count:" + i);
    }
    if (i >= 4) {}
    do
    {
      return localaoor;
      localaoor.jdField_a_of_type_Int = (i + 1);
    } while (i > 2);
    localaoor.jdField_b_of_type_Int = 10;
    return localaoor;
  }
  
  public String a(String paramString, byte paramByte1, byte paramByte2, int paramInt)
  {
    return a(paramString, paramByte1, paramByte2, paramInt, false);
  }
  
  public String a(String paramString, byte paramByte1, byte paramByte2, int paramInt, boolean paramBoolean)
  {
    String str1 = "q.qlogo.cn";
    StringBuilder localStringBuilder;
    if (paramByte2 == 32) {
      if (paramInt == 1)
      {
        str1 = "q.qlogo.cn";
        String str2 = a(str1, paramBoolean);
        localStringBuilder = new StringBuilder("https://");
        if (TextUtils.isEmpty(str2)) {
          break label194;
        }
        localStringBuilder.append(str2);
        label60:
        int i = paramString.indexOf("/", 8);
        str1 = paramString;
        if (i > 8)
        {
          localStringBuilder.append(paramString.substring(i));
          str1 = localStringBuilder.toString();
        }
        if (paramByte2 != 32) {
          break label212;
        }
        if (paramInt != 1) {
          break label205;
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
      label194:
      localStringBuilder.append(str1);
      break label60;
      label205:
      paramByte2 = 140;
      continue;
      label212:
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
    while (i < this.jdField_a_of_type_ArrayOfComTencentMobileqqAppFaceFaceDownloader$FaceDownloadRunnable.length)
    {
      if (this.jdField_a_of_type_ArrayOfComTencentMobileqqAppFaceFaceDownloader$FaceDownloadRunnable[i] != null) {
        this.jdField_a_of_type_ArrayOfComTencentMobileqqAppFaceFaceDownloader$FaceDownloadRunnable[i].a();
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
              this.jdField_a_of_type_ArrayOfComTencentMobileqqAppFaceFaceDownloader$FaceDownloadRunnable[j] = new FaceDownloader.FaceDownloadRunnable(this, j);
              this.jdField_a_of_type_ArrayOfJavaLangThread[j] = ThreadManager.newFreeThread(this.jdField_a_of_type_ArrayOfComTencentMobileqqAppFaceFaceDownloader$FaceDownloadRunnable[j], "FaceDownloadThread", 5);
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
      if ((this.jdField_a_of_type_ArrayOfComTencentMobileqqAppFaceFaceDownloader$FaceDownloadRunnable == null) || (this.jdField_a_of_type_ArrayOfComTencentMobileqqAppFaceFaceDownloader$FaceDownloadRunnable.length <= 0) || (this.jdField_a_of_type_ArrayOfComTencentMobileqqAppFaceFaceDownloader$FaceDownloadRunnable[0] == null)) {
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
  
  public void a(aooq paramaooq)
  {
    try
    {
      if (QLog.isColorLevel()) {
        QLog.i("Q.qqhead.FaceDownloader", 2, "addFaceDownloadListener l=" + paramaooq);
      }
      this.jdField_a_of_type_JavaUtilLinkedList.add(paramaooq);
      return;
    }
    finally {}
  }
  
  protected abstract void a(FaceInfo paramFaceInfo);
  
  public Object[] a(String paramString1, int paramInt1, String paramString2, boolean paramBoolean, int paramInt2, String paramString3)
  {
    if ((paramString1 != null) && (paramInt1 > 0) && (!jdField_a_of_type_Boolean)) {
      if ((paramString2.equals(bhvd.d)) || (paramString2.equals(bhvd.f)) || (paramString2.equals(bhvd.h))) {
        if ((Math.abs(paramInt2 % 2) == 1) && (e == 1))
        {
          paramString1 = (HttpURLConnection)new URL(paramString3).openConnection();
          paramBoolean = false;
          if (!QLog.isDevelopLevel()) {
            break label265;
          }
          QLog.i("Q.qqhead.FaceDownloader", 4, "downloadData, wapconn, DPC_WAP_DIRECT_CONNECT=" + e + ", tryCount=" + paramInt2);
        }
      }
    }
    label259:
    label265:
    for (;;)
    {
      label126:
      paramString1.setRequestProperty("Accept-Encoding", "identity");
      paramString1.setConnectTimeout(30000);
      paramString1.setReadTimeout(30000);
      paramString1.setInstanceFollowRedirects(true);
      if ((paramString1 instanceof HttpsURLConnection))
      {
        paramString2 = (HttpsURLConnection)paramString1;
        paramString3 = new URL(paramString3);
        if (paramInt2 != -1) {
          break label259;
        }
      }
      for (boolean bool = true;; bool = false)
      {
        a(paramString2, paramString3, bool);
        return new Object[] { Boolean.valueOf(paramBoolean), paramString1 };
        paramString1 = bhvd.b(paramString3, paramString1, paramInt1);
        paramBoolean = true;
        break;
        paramString1 = bhvd.a(paramString3, paramString1, paramInt1);
        paramBoolean = true;
        break label126;
        paramString1 = (HttpURLConnection)new URL(paramString3).openConnection();
        break label126;
      }
    }
  }
  
  public void b(aooq paramaooq)
  {
    try
    {
      if (QLog.isColorLevel()) {
        QLog.i("Q.qqhead.FaceDownloader", 2, "removeFaceDownloadListener l=" + paramaooq);
      }
      this.jdField_a_of_type_JavaUtilLinkedList.remove(paramaooq);
      return;
    }
    finally {}
  }
  
  public void b(FaceInfo paramFaceInfo)
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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.app.face.FaceDownloader
 * JD-Core Version:    0.7.0.1
 */