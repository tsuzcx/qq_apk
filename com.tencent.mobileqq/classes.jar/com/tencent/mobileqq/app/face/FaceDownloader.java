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
import annj;
import anwa;
import aobp;
import aocd;
import aoce;
import aocf;
import aocg;
import aocs;
import bggl;
import bggm;
import bgjq;
import bgmo;
import bgnt;
import bgva;
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
  private aocf jdField_a_of_type_Aocf;
  protected AppInterface a;
  protected ArrayList<FaceInfo> a;
  protected HashSet<String> a;
  public LinkedList<aoce> a;
  protected AtomicInteger a;
  protected MqqHandler a;
  private FaceDownloader.FaceDownloadRunnable[] jdField_a_of_type_ArrayOfComTencentMobileqqAppFaceFaceDownloader$FaceDownloadRunnable;
  private Thread[] jdField_a_of_type_ArrayOfJavaLangThread;
  protected int b;
  public ArrayList<aocg> b;
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
    if (this.jdField_a_of_type_Aocf.jdField_a_of_type_Int != -2147483648) {
      this.jdField_a_of_type_Int = this.jdField_a_of_type_Aocf.jdField_a_of_type_Int;
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
        if (anwa.a().c()) {
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
      this.jdField_a_of_type_MqqOsMqqHandler = new aocd(this, Looper.getMainLooper());
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
      bool = bgjq.a();
      if (!bool) {
        break label286;
      }
      l = bgjq.a();
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
      l = bgjq.b();
      break label172;
      paramFaceInfo = "notExit";
      break label197;
    }
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
        localBitmap = bgmo.c(paramBitmap, 50, 50);
      }
    }
    for (;;)
    {
      ((aocs)this.jdField_a_of_type_ComTencentCommonAppAppInterface.getManager(216)).a(paramFaceInfo.a(), localBitmap, aocs.a(paramFaceInfo.jdField_a_of_type_Int));
      paramFaceInfo.a(FaceInfo.q);
      return localBitmap;
      localBitmap = QQAppInterface.a(paramBitmap, bgmo.a(paramBitmap.getWidth()), 50, 50);
      continue;
      localBitmap = bgmo.a(paramBitmap, 50, 50);
    }
  }
  
  public static String a(int paramInt)
  {
    if ((paramInt == 4) || (paramInt == 8)) {
      return "";
    }
    String str2 = b(paramInt);
    paramInt = bgnt.a(BaseApplicationImpl.getApplication().getApplicationContext());
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
    boolean bool = annj.a().a();
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
    aocg localaocg;
    if (paramBoolean)
    {
      localaocg = new aocg(this);
      localaocg.jdField_a_of_type_ComTencentMobileqqAppFaceFaceInfo = paramFaceInfo;
      if (paramInt == 0) {
        break label63;
      }
      paramFaceInfo.a(FaceInfo.o);
      localaocg.jdField_a_of_type_AndroidGraphicsBitmap = null;
      this.jdField_b_of_type_JavaUtilArrayList.add(localaocg);
      this.jdField_a_of_type_MqqOsMqqHandler.obtainMessage(100, localaocg).sendToTarget();
    }
    label63:
    while (paramLong < 20480L) {
      return;
    }
    paramFaceInfo.a(FaceInfo.p);
    bggm localbggm = new bggm();
    BitmapFactory.Options localOptions = new BitmapFactory.Options();
    localOptions.inPreferredConfig = aobp.a;
    aocs localaocs = (aocs)this.jdField_a_of_type_ComTencentCommonAppAppInterface.getManager(216);
    paramInt = 0;
    for (;;)
    {
      bggl.a(localaocs.a(paramFaceInfo), localOptions, localbggm);
      if (localbggm.jdField_a_of_type_Int == 1)
      {
        NearbyAppInterface localNearbyAppInterface = (NearbyAppInterface)this.jdField_a_of_type_ComTencentCommonAppAppInterface;
        NearbyAppInterface.b();
      }
      paramInt += 1;
      if ((paramInt >= 2) || (localbggm.jdField_a_of_type_Int != 1))
      {
        if (localbggm.jdField_a_of_type_AndroidGraphicsBitmap != null) {
          switch (paramFaceInfo.c)
          {
          case 2: 
          case 4: 
          default: 
            localbggm.jdField_a_of_type_AndroidGraphicsBitmap = bgmo.c(localbggm.jdField_a_of_type_AndroidGraphicsBitmap, 50, 50);
          }
        }
        for (;;)
        {
          localaocs.a(paramFaceInfo.a(), localbggm.jdField_a_of_type_AndroidGraphicsBitmap, aocs.a(paramFaceInfo.jdField_a_of_type_Int));
          paramFaceInfo.a(FaceInfo.q);
          localaocg.jdField_a_of_type_AndroidGraphicsBitmap = localbggm.jdField_a_of_type_AndroidGraphicsBitmap;
          this.jdField_b_of_type_JavaUtilArrayList.add(localaocg);
          this.jdField_a_of_type_MqqOsMqqHandler.obtainMessage(100, localaocg).sendToTarget();
          return;
          paramInt = bgmo.a(localbggm.jdField_a_of_type_AndroidGraphicsBitmap.getWidth());
          localbggm.jdField_a_of_type_AndroidGraphicsBitmap = QQAppInterface.a(localbggm.jdField_a_of_type_AndroidGraphicsBitmap, paramInt, 50, 50);
          continue;
          localbggm.jdField_a_of_type_AndroidGraphicsBitmap = bgmo.a(localbggm.jdField_a_of_type_AndroidGraphicsBitmap, 50, 50);
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
      if ((paramInt != 1) && (!paramString2.equals(bgva.d))) {
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
      for (this.jdField_a_of_type_Aocf = a(); QLog.isColorLevel(); this.jdField_a_of_type_Aocf = new aocf(this))
      {
        QLog.i("Q.qqhead.FaceDownloader", 2, "initFaceDownloadThreadInfo, maxThreadCount=" + this.jdField_a_of_type_Aocf.jdField_a_of_type_Int + ",priority=" + this.jdField_a_of_type_Aocf.jdField_b_of_type_Int);
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
  public int a(String paramString, File paramFile, FaceInfo paramFaceInfo, boolean paramBoolean)
  {
    // Byte code:
    //   0: invokestatic 639	com/tencent/mobileqq/msf/sdk/AppNetConnInfo:getRecentNetworkInfo	()Landroid/net/NetworkInfo;
    //   3: astore 33
    //   5: lconst_0
    //   6: lstore 17
    //   8: aload 33
    //   10: ifnonnull +14 -> 24
    //   13: ldc 139
    //   15: iconst_1
    //   16: ldc_w 641
    //   19: invokestatic 261	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   22: iconst_1
    //   23: ireturn
    //   24: new 643	java/net/URL
    //   27: dup
    //   28: aload_1
    //   29: invokespecial 644	java/net/URL:<init>	(Ljava/lang/String;)V
    //   32: astore 30
    //   34: invokestatic 508	java/lang/System:currentTimeMillis	()J
    //   37: pop2
    //   38: iconst_5
    //   39: istore 5
    //   41: new 4	java/lang/Object
    //   44: dup
    //   45: invokespecial 37	java/lang/Object:<init>	()V
    //   48: astore 29
    //   50: aload_0
    //   51: aload_2
    //   52: invokespecial 426	com/tencent/mobileqq/app/face/FaceDownloader:a	(Ljava/io/File;)V
    //   55: aconst_null
    //   56: astore 23
    //   58: new 646	arul
    //   61: dup
    //   62: aload_1
    //   63: aconst_null
    //   64: iconst_0
    //   65: invokespecial 649	arul:<init>	(Ljava/lang/String;Ljava/io/File;I)V
    //   68: astore 32
    //   70: new 651	org/apache/http/client/methods/HttpGet
    //   73: dup
    //   74: aload_1
    //   75: invokespecial 652	org/apache/http/client/methods/HttpGet:<init>	(Ljava/lang/String;)V
    //   78: pop
    //   79: new 231	java/io/File
    //   82: dup
    //   83: new 171	java/lang/StringBuilder
    //   86: dup
    //   87: invokespecial 172	java/lang/StringBuilder:<init>	()V
    //   90: aload_2
    //   91: invokevirtual 655	java/io/File:getPath	()Ljava/lang/String;
    //   94: invokevirtual 178	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   97: ldc_w 657
    //   100: invokevirtual 178	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   103: invokevirtual 187	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   106: invokespecial 658	java/io/File:<init>	(Ljava/lang/String;)V
    //   109: astore 31
    //   111: aload 31
    //   113: invokevirtual 234	java/io/File:exists	()Z
    //   116: ifeq +9 -> 125
    //   119: aload 31
    //   121: invokevirtual 429	java/io/File:delete	()Z
    //   124: pop
    //   125: iconst_m1
    //   126: istore 12
    //   128: aconst_null
    //   129: astore 24
    //   131: aload_1
    //   132: astore 25
    //   134: aload 23
    //   136: astore_1
    //   137: aload 25
    //   139: astore 28
    //   141: iload 12
    //   143: iconst_m1
    //   144: if_icmpeq +98 -> 242
    //   147: aload_3
    //   148: getfield 541	com/tencent/mobileqq/app/face/FaceInfo:jdField_a_of_type_AvatarInfoQQHeadInfo	LAvatarInfo/QQHeadInfo;
    //   151: astore 23
    //   153: aload 23
    //   155: ifnonnull +74 -> 229
    //   158: aload 32
    //   160: iload 5
    //   162: putfield 659	arul:jdField_b_of_type_Int	I
    //   165: aload_0
    //   166: aload_3
    //   167: iload 4
    //   169: lload 17
    //   171: iload 5
    //   173: invokespecial 661	com/tencent/mobileqq/app/face/FaceDownloader:a	(Lcom/tencent/mobileqq/app/face/FaceInfo;ZJI)V
    //   176: iload 5
    //   178: ireturn
    //   179: astore_1
    //   180: aload_1
    //   181: invokevirtual 662	java/net/MalformedURLException:printStackTrace	()V
    //   184: bipush 13
    //   186: ireturn
    //   187: astore_1
    //   188: ldc 139
    //   190: iconst_1
    //   191: ldc_w 664
    //   194: invokestatic 389	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   197: iconst_4
    //   198: ireturn
    //   199: astore 24
    //   201: aload_1
    //   202: invokestatic 668	com/tencent/mobileqq/utils/HttpDownloadUtil:a	(Ljava/lang/String;)Ljava/lang/String;
    //   205: astore_1
    //   206: goto -127 -> 79
    //   209: astore_1
    //   210: ldc 139
    //   212: iconst_1
    //   213: ldc_w 670
    //   216: invokestatic 389	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   219: aload 32
    //   221: bipush 13
    //   223: putfield 659	arul:jdField_b_of_type_Int	I
    //   226: bipush 13
    //   228: ireturn
    //   229: aload_0
    //   230: aload 25
    //   232: aload_3
    //   233: iload 12
    //   235: aload 23
    //   237: invokespecial 672	com/tencent/mobileqq/app/face/FaceDownloader:a	(Ljava/lang/String;Lcom/tencent/mobileqq/app/face/FaceInfo;ILAvatarInfo/QQHeadInfo;)Ljava/lang/String;
    //   240: astore 28
    //   242: iconst_5
    //   243: istore 5
    //   245: iconst_0
    //   246: istore 15
    //   248: invokestatic 677	android/net/Proxy:getDefaultHost	()Ljava/lang/String;
    //   251: astore 34
    //   253: invokestatic 680	android/net/Proxy:getDefaultPort	()I
    //   256: istore 14
    //   258: aload 33
    //   260: ifnull +494 -> 754
    //   263: aload 33
    //   265: invokevirtual 685	android/net/NetworkInfo:getExtraInfo	()Ljava/lang/String;
    //   268: astore 23
    //   270: aload 33
    //   272: ifnull +488 -> 760
    //   275: aload 33
    //   277: invokevirtual 688	android/net/NetworkInfo:getType	()I
    //   280: istore 11
    //   282: aload 23
    //   284: invokestatic 690	bgva:b	(Ljava/lang/String;)Ljava/lang/String;
    //   287: astore 35
    //   289: aload_0
    //   290: aload 34
    //   292: iload 11
    //   294: aload 35
    //   296: invokespecial 692	com/tencent/mobileqq/app/face/FaceDownloader:a	(Ljava/lang/String;ILjava/lang/String;)V
    //   299: aload_0
    //   300: aload 34
    //   302: iload 14
    //   304: aload 35
    //   306: iconst_0
    //   307: iload 12
    //   309: aload 28
    //   311: invokevirtual 695	com/tencent/mobileqq/app/face/FaceDownloader:a	(Ljava/lang/String;ILjava/lang/String;ZILjava/lang/String;)[Ljava/lang/Object;
    //   314: astore 23
    //   316: aload 23
    //   318: iconst_0
    //   319: aaload
    //   320: checkcast 697	java/lang/Boolean
    //   323: invokevirtual 700	java/lang/Boolean:booleanValue	()Z
    //   326: istore 16
    //   328: iload 16
    //   330: istore 15
    //   332: aload 23
    //   334: iconst_1
    //   335: aaload
    //   336: checkcast 515	java/net/HttpURLConnection
    //   339: astore 23
    //   341: aload 23
    //   343: invokevirtual 703	java/net/HttpURLConnection:connect	()V
    //   346: aload 32
    //   348: aload 23
    //   350: invokevirtual 546	java/net/HttpURLConnection:getResponseCode	()I
    //   353: putfield 704	arul:c	I
    //   356: aload 32
    //   358: aload 23
    //   360: invokevirtual 554	java/net/HttpURLConnection:getContentLength	()I
    //   363: putfield 705	arul:e	I
    //   366: aload 32
    //   368: aload 23
    //   370: invokevirtual 551	java/net/HttpURLConnection:getContentType	()Ljava/lang/String;
    //   373: putfield 708	arul:h	Ljava/lang/String;
    //   376: aload 32
    //   378: aload 23
    //   380: invokevirtual 711	java/net/HttpURLConnection:getContentEncoding	()Ljava/lang/String;
    //   383: putfield 713	arul:i	Ljava/lang/String;
    //   386: aload 32
    //   388: aload 23
    //   390: ldc_w 566
    //   393: invokevirtual 560	java/net/HttpURLConnection:getHeaderField	(Ljava/lang/String;)Ljava/lang/String;
    //   396: putfield 716	arul:f	Ljava/lang/String;
    //   399: aload 23
    //   401: ldc_w 562
    //   404: invokevirtual 560	java/net/HttpURLConnection:getHeaderField	(Ljava/lang/String;)Ljava/lang/String;
    //   407: astore 24
    //   409: aload 24
    //   411: invokestatic 83	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   414: ifne +619 -> 1033
    //   417: ldc 139
    //   419: iconst_1
    //   420: new 171	java/lang/StringBuilder
    //   423: dup
    //   424: invokespecial 172	java/lang/StringBuilder:<init>	()V
    //   427: ldc_w 718
    //   430: invokevirtual 178	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   433: aload 24
    //   435: invokevirtual 178	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   438: invokevirtual 187	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   441: invokestatic 261	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   444: aload_0
    //   445: aload 23
    //   447: aload_3
    //   448: invokespecial 720	com/tencent/mobileqq/app/face/FaceDownloader:a	(Ljava/net/HttpURLConnection;Lcom/tencent/mobileqq/app/face/FaceInfo;)V
    //   451: iconst_0
    //   452: istore 10
    //   454: iconst_0
    //   455: istore 13
    //   457: iconst_0
    //   458: istore 5
    //   460: iload 5
    //   462: istore 7
    //   464: lload 17
    //   466: lstore 19
    //   468: iload 10
    //   470: istore 8
    //   472: lload 17
    //   474: lstore 21
    //   476: iload 13
    //   478: istore 9
    //   480: sipush 200
    //   483: aload 32
    //   485: getfield 704	arul:c	I
    //   488: if_icmpne +1647 -> 2135
    //   491: iload 5
    //   493: istore 7
    //   495: lload 17
    //   497: lstore 19
    //   499: iload 10
    //   501: istore 8
    //   503: lload 17
    //   505: lstore 21
    //   507: iload 13
    //   509: istore 9
    //   511: aload 32
    //   513: getfield 705	arul:e	I
    //   516: istore 6
    //   518: iload 6
    //   520: i2l
    //   521: lstore 17
    //   523: iconst_0
    //   524: istore 6
    //   526: iload 5
    //   528: istore 7
    //   530: lload 17
    //   532: lstore 19
    //   534: iload 10
    //   536: istore 8
    //   538: lload 17
    //   540: lstore 21
    //   542: iload 13
    //   544: istore 9
    //   546: aload 31
    //   548: invokevirtual 234	java/io/File:exists	()Z
    //   551: ifeq +29 -> 580
    //   554: iload 5
    //   556: istore 7
    //   558: lload 17
    //   560: lstore 19
    //   562: iload 10
    //   564: istore 8
    //   566: lload 17
    //   568: lstore 21
    //   570: iload 13
    //   572: istore 9
    //   574: aload 31
    //   576: invokevirtual 429	java/io/File:delete	()Z
    //   579: pop
    //   580: iload 5
    //   582: istore 7
    //   584: lload 17
    //   586: lstore 19
    //   588: iload 10
    //   590: istore 8
    //   592: lload 17
    //   594: lstore 21
    //   596: iload 13
    //   598: istore 9
    //   600: aload 31
    //   602: invokevirtual 723	java/io/File:createNewFile	()Z
    //   605: pop
    //   606: iload 5
    //   608: istore 7
    //   610: lload 17
    //   612: lstore 19
    //   614: iload 10
    //   616: istore 8
    //   618: lload 17
    //   620: lstore 21
    //   622: iload 13
    //   624: istore 9
    //   626: new 725	java/io/BufferedOutputStream
    //   629: dup
    //   630: new 727	java/io/FileOutputStream
    //   633: dup
    //   634: aload 31
    //   636: invokespecial 729	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   639: invokespecial 732	java/io/BufferedOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   642: astore 24
    //   644: aload 24
    //   646: astore 27
    //   648: aload 24
    //   650: astore 25
    //   652: aload 24
    //   654: astore 26
    //   656: aload 23
    //   658: invokevirtual 736	java/net/HttpURLConnection:getInputStream	()Ljava/io/InputStream;
    //   661: astore 36
    //   663: iconst_0
    //   664: istore 7
    //   666: iload 4
    //   668: ifeq +1286 -> 1954
    //   671: lload 17
    //   673: ldc2_w 464
    //   676: lcmp
    //   677: ifge +1277 -> 1954
    //   680: aload 24
    //   682: astore 27
    //   684: aload 24
    //   686: astore 25
    //   688: aload 24
    //   690: astore 26
    //   692: ldc_w 737
    //   695: newarray byte
    //   697: astore_1
    //   698: iload 6
    //   700: istore 5
    //   702: iload 7
    //   704: istore 6
    //   706: aload 24
    //   708: astore 27
    //   710: aload 24
    //   712: astore 25
    //   714: aload 24
    //   716: astore 26
    //   718: aload 36
    //   720: aload_1
    //   721: iload 6
    //   723: sipush 1024
    //   726: invokevirtual 743	java/io/InputStream:read	([BII)I
    //   729: istore 7
    //   731: iload 7
    //   733: iconst_m1
    //   734: if_icmpeq +709 -> 1443
    //   737: iload 6
    //   739: iload 7
    //   741: iadd
    //   742: istore 6
    //   744: iload 5
    //   746: iload 7
    //   748: iadd
    //   749: istore 5
    //   751: goto -45 -> 706
    //   754: aconst_null
    //   755: astore 23
    //   757: goto -487 -> 270
    //   760: iconst_m1
    //   761: istore 11
    //   763: goto -481 -> 282
    //   766: astore 24
    //   768: aload_0
    //   769: iload 15
    //   771: aload 34
    //   773: iload 14
    //   775: invokespecial 745	com/tencent/mobileqq/app/face/FaceDownloader:a	(ZLjava/lang/String;I)V
    //   778: aload 24
    //   780: athrow
    //   781: astore 24
    //   783: aload 23
    //   785: astore 25
    //   787: iconst_5
    //   788: istore 5
    //   790: aload_1
    //   791: astore 23
    //   793: aload 25
    //   795: astore_1
    //   796: aload_0
    //   797: aload_3
    //   798: aload 30
    //   800: aload 31
    //   802: aload 24
    //   804: invokespecial 747	com/tencent/mobileqq/app/face/FaceDownloader:a	(Lcom/tencent/mobileqq/app/face/FaceInfo;Ljava/net/URL;Ljava/io/File;Ljava/io/IOException;)I
    //   807: istore 6
    //   809: aload_0
    //   810: aload 23
    //   812: aload_1
    //   813: invokespecial 749	com/tencent/mobileqq/app/face/FaceDownloader:a	(Ljava/io/OutputStream;Ljava/net/HttpURLConnection;)V
    //   816: aload_0
    //   817: iload 6
    //   819: aload 31
    //   821: invokespecial 751	com/tencent/mobileqq/app/face/FaceDownloader:a	(ILjava/io/File;)V
    //   824: iload 12
    //   826: iconst_1
    //   827: iadd
    //   828: istore 5
    //   830: iload 6
    //   832: ifeq +140 -> 972
    //   835: ldc 139
    //   837: iconst_1
    //   838: new 171	java/lang/StringBuilder
    //   841: dup
    //   842: invokespecial 172	java/lang/StringBuilder:<init>	()V
    //   845: ldc_w 753
    //   848: invokevirtual 178	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   851: iload 6
    //   853: invokevirtual 248	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   856: ldc_w 755
    //   859: invokevirtual 178	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   862: aload 30
    //   864: invokevirtual 181	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   867: ldc_w 757
    //   870: invokevirtual 178	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   873: iload 5
    //   875: invokevirtual 248	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   878: ldc 183
    //   880: invokevirtual 178	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   883: aload_3
    //   884: invokevirtual 181	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   887: ldc_w 759
    //   890: invokevirtual 178	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   893: iload 15
    //   895: invokevirtual 253	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   898: ldc_w 761
    //   901: invokevirtual 178	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   904: aload 34
    //   906: invokevirtual 178	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   909: ldc_w 763
    //   912: invokevirtual 178	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   915: iload 14
    //   917: invokevirtual 248	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   920: ldc_w 765
    //   923: invokevirtual 178	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   926: getstatic 531	com/tencent/mobileqq/app/face/FaceDownloader:jdField_a_of_type_Boolean	Z
    //   929: invokevirtual 253	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   932: ldc_w 767
    //   935: invokevirtual 178	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   938: iload 11
    //   940: invokevirtual 248	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   943: ldc_w 769
    //   946: invokevirtual 178	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   949: aload 35
    //   951: invokevirtual 178	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   954: ldc_w 771
    //   957: invokevirtual 178	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   960: getstatic 30	com/tencent/mobileqq/app/face/FaceDownloader:e	I
    //   963: invokevirtual 248	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   966: invokevirtual 187	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   969: invokestatic 261	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   972: iload 6
    //   974: ifeq +1874 -> 2848
    //   977: iload 5
    //   979: iconst_2
    //   980: if_icmpge +1868 -> 2848
    //   983: aload 29
    //   985: monitorenter
    //   986: aload 29
    //   988: ldc2_w 772
    //   991: invokevirtual 777	java/lang/Object:wait	(J)V
    //   994: aload 29
    //   996: monitorexit
    //   997: iload 6
    //   999: istore 7
    //   1001: aload 23
    //   1003: astore 24
    //   1005: aload_1
    //   1006: astore 23
    //   1008: aload 24
    //   1010: astore_1
    //   1011: iload 5
    //   1013: istore 6
    //   1015: iload 7
    //   1017: istore 5
    //   1019: iload 5
    //   1021: ifeq +9 -> 1030
    //   1024: iload 6
    //   1026: iconst_2
    //   1027: if_icmplt +1796 -> 2823
    //   1030: goto -872 -> 158
    //   1033: iconst_0
    //   1034: istore 10
    //   1036: aload 32
    //   1038: getfield 716	arul:f	Ljava/lang/String;
    //   1041: ifnonnull +1776 -> 2817
    //   1044: aload 32
    //   1046: getfield 704	arul:c	I
    //   1049: istore 6
    //   1051: iload 6
    //   1053: sipush 200
    //   1056: if_icmpne +367 -> 1423
    //   1059: bipush 30
    //   1061: istore 5
    //   1063: iconst_1
    //   1064: istore 10
    //   1066: iload 5
    //   1068: istore 6
    //   1070: iload 10
    //   1072: istore 13
    //   1074: iload 6
    //   1076: istore 5
    //   1078: iload 6
    //   1080: istore 7
    //   1082: lload 17
    //   1084: lstore 19
    //   1086: iload 6
    //   1088: istore 8
    //   1090: lload 17
    //   1092: lstore 21
    //   1094: iload 6
    //   1096: istore 9
    //   1098: aload_3
    //   1099: getfield 541	com/tencent/mobileqq/app/face/FaceInfo:jdField_a_of_type_AvatarInfoQQHeadInfo	LAvatarInfo/QQHeadInfo;
    //   1102: getfield 780	AvatarInfo/QQHeadInfo:headVerify	Ljava/lang/String;
    //   1105: invokestatic 83	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   1108: ifne +92 -> 1200
    //   1111: iload 10
    //   1113: istore 13
    //   1115: iload 6
    //   1117: istore 5
    //   1119: iload 6
    //   1121: istore 7
    //   1123: lload 17
    //   1125: lstore 19
    //   1127: iload 6
    //   1129: istore 8
    //   1131: lload 17
    //   1133: lstore 21
    //   1135: iload 6
    //   1137: istore 9
    //   1139: aload 32
    //   1141: getfield 716	arul:f	Ljava/lang/String;
    //   1144: ifnull +56 -> 1200
    //   1147: iload 10
    //   1149: istore 13
    //   1151: iload 6
    //   1153: istore 5
    //   1155: iload 6
    //   1157: istore 7
    //   1159: lload 17
    //   1161: lstore 19
    //   1163: iload 6
    //   1165: istore 8
    //   1167: lload 17
    //   1169: lstore 21
    //   1171: iload 6
    //   1173: istore 9
    //   1175: aload 32
    //   1177: getfield 716	arul:f	Ljava/lang/String;
    //   1180: aload_3
    //   1181: getfield 541	com/tencent/mobileqq/app/face/FaceInfo:jdField_a_of_type_AvatarInfoQQHeadInfo	LAvatarInfo/QQHeadInfo;
    //   1184: getfield 780	AvatarInfo/QQHeadInfo:headVerify	Ljava/lang/String;
    //   1187: invokevirtual 91	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1190: ifne +10 -> 1200
    //   1193: bipush 31
    //   1195: istore 5
    //   1197: iconst_1
    //   1198: istore 13
    //   1200: iload 13
    //   1202: ifeq -751 -> 451
    //   1205: iload 5
    //   1207: istore 7
    //   1209: lload 17
    //   1211: lstore 19
    //   1213: iload 5
    //   1215: istore 8
    //   1217: lload 17
    //   1219: lstore 21
    //   1221: iload 5
    //   1223: istore 9
    //   1225: aload_0
    //   1226: aload 23
    //   1228: aload_3
    //   1229: invokespecial 720	com/tencent/mobileqq/app/face/FaceDownloader:a	(Ljava/net/HttpURLConnection;Lcom/tencent/mobileqq/app/face/FaceInfo;)V
    //   1232: aload_0
    //   1233: aload_1
    //   1234: aload 23
    //   1236: invokespecial 749	com/tencent/mobileqq/app/face/FaceDownloader:a	(Ljava/io/OutputStream;Ljava/net/HttpURLConnection;)V
    //   1239: aload_0
    //   1240: iload 5
    //   1242: aload 31
    //   1244: invokespecial 751	com/tencent/mobileqq/app/face/FaceDownloader:a	(ILjava/io/File;)V
    //   1247: iload 12
    //   1249: iconst_1
    //   1250: iadd
    //   1251: istore 6
    //   1253: iload 5
    //   1255: ifeq +140 -> 1395
    //   1258: ldc 139
    //   1260: iconst_1
    //   1261: new 171	java/lang/StringBuilder
    //   1264: dup
    //   1265: invokespecial 172	java/lang/StringBuilder:<init>	()V
    //   1268: ldc_w 753
    //   1271: invokevirtual 178	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1274: iload 5
    //   1276: invokevirtual 248	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1279: ldc_w 755
    //   1282: invokevirtual 178	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1285: aload 30
    //   1287: invokevirtual 181	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   1290: ldc_w 757
    //   1293: invokevirtual 178	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1296: iload 6
    //   1298: invokevirtual 248	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1301: ldc 183
    //   1303: invokevirtual 178	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1306: aload_3
    //   1307: invokevirtual 181	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   1310: ldc_w 759
    //   1313: invokevirtual 178	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1316: iload 15
    //   1318: invokevirtual 253	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   1321: ldc_w 761
    //   1324: invokevirtual 178	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1327: aload 34
    //   1329: invokevirtual 178	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1332: ldc_w 763
    //   1335: invokevirtual 178	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1338: iload 14
    //   1340: invokevirtual 248	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1343: ldc_w 765
    //   1346: invokevirtual 178	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1349: getstatic 531	com/tencent/mobileqq/app/face/FaceDownloader:jdField_a_of_type_Boolean	Z
    //   1352: invokevirtual 253	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   1355: ldc_w 767
    //   1358: invokevirtual 178	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1361: iload 11
    //   1363: invokevirtual 248	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1366: ldc_w 769
    //   1369: invokevirtual 178	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1372: aload 35
    //   1374: invokevirtual 178	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1377: ldc_w 771
    //   1380: invokevirtual 178	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1383: getstatic 30	com/tencent/mobileqq/app/face/FaceDownloader:e	I
    //   1386: invokevirtual 248	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1389: invokevirtual 187	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1392: invokestatic 261	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   1395: iload 5
    //   1397: ifeq +1417 -> 2814
    //   1400: iload 6
    //   1402: iconst_2
    //   1403: if_icmpge +1411 -> 2814
    //   1406: aload 29
    //   1408: monitorenter
    //   1409: aload 29
    //   1411: ldc2_w 772
    //   1414: invokevirtual 777	java/lang/Object:wait	(J)V
    //   1417: aload 29
    //   1419: monitorexit
    //   1420: goto -401 -> 1019
    //   1423: aload 32
    //   1425: getfield 704	arul:c	I
    //   1428: istore 6
    //   1430: iload 6
    //   1432: istore 5
    //   1434: goto -371 -> 1063
    //   1437: astore_1
    //   1438: aload 29
    //   1440: monitorexit
    //   1441: aload_1
    //   1442: athrow
    //   1443: aload 24
    //   1445: astore 27
    //   1447: aload 24
    //   1449: astore 25
    //   1451: aload 24
    //   1453: astore 26
    //   1455: aload_3
    //   1456: getstatic 446	com/tencent/mobileqq/app/face/FaceInfo:o	I
    //   1459: invokevirtual 296	com/tencent/mobileqq/app/face/FaceInfo:a	(I)V
    //   1462: iload 5
    //   1464: i2l
    //   1465: lload 17
    //   1467: lcmp
    //   1468: ifne +232 -> 1700
    //   1471: aload 24
    //   1473: astore 27
    //   1475: aload 24
    //   1477: astore 25
    //   1479: aload 24
    //   1481: astore 26
    //   1483: aload_3
    //   1484: getstatic 468	com/tencent/mobileqq/app/face/FaceInfo:p	I
    //   1487: invokevirtual 296	com/tencent/mobileqq/app/face/FaceInfo:a	(I)V
    //   1490: aload 24
    //   1492: astore 27
    //   1494: aload 24
    //   1496: astore 25
    //   1498: aload 24
    //   1500: astore 26
    //   1502: aload_0
    //   1503: aload_3
    //   1504: aload_1
    //   1505: iconst_0
    //   1506: iload 5
    //   1508: invokestatic 783	bggl:a	([BII)Landroid/graphics/Bitmap;
    //   1511: invokespecial 785	com/tencent/mobileqq/app/face/FaceDownloader:a	(Lcom/tencent/mobileqq/app/face/FaceInfo;Landroid/graphics/Bitmap;)Landroid/graphics/Bitmap;
    //   1514: astore 36
    //   1516: aload 24
    //   1518: astore 27
    //   1520: aload 24
    //   1522: astore 25
    //   1524: aload 24
    //   1526: astore 26
    //   1528: invokestatic 355	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1531: ifeq +62 -> 1593
    //   1534: aload 24
    //   1536: astore 27
    //   1538: aload 24
    //   1540: astore 25
    //   1542: aload 24
    //   1544: astore 26
    //   1546: ldc 139
    //   1548: iconst_2
    //   1549: new 171	java/lang/StringBuilder
    //   1552: dup
    //   1553: invokespecial 172	java/lang/StringBuilder:<init>	()V
    //   1556: ldc_w 787
    //   1559: invokevirtual 178	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1562: aload 36
    //   1564: invokevirtual 181	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   1567: ldc_w 755
    //   1570: invokevirtual 178	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1573: aload 30
    //   1575: invokevirtual 181	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   1578: ldc 183
    //   1580: invokevirtual 178	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1583: aload_3
    //   1584: invokevirtual 181	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   1587: invokevirtual 187	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1590: invokestatic 261	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   1593: aload 24
    //   1595: astore 27
    //   1597: aload 24
    //   1599: astore 25
    //   1601: aload 24
    //   1603: astore 26
    //   1605: new 437	aocg
    //   1608: dup
    //   1609: aload_0
    //   1610: invokespecial 440	aocg:<init>	(Lcom/tencent/mobileqq/app/face/FaceDownloader;)V
    //   1613: astore 37
    //   1615: aload 24
    //   1617: astore 27
    //   1619: aload 24
    //   1621: astore 25
    //   1623: aload 24
    //   1625: astore 26
    //   1627: aload 37
    //   1629: aload_3
    //   1630: putfield 443	aocg:jdField_a_of_type_ComTencentMobileqqAppFaceFaceInfo	Lcom/tencent/mobileqq/app/face/FaceInfo;
    //   1633: aload 24
    //   1635: astore 27
    //   1637: aload 24
    //   1639: astore 25
    //   1641: aload 24
    //   1643: astore 26
    //   1645: aload 37
    //   1647: aload 36
    //   1649: putfield 449	aocg:jdField_a_of_type_AndroidGraphicsBitmap	Landroid/graphics/Bitmap;
    //   1652: aload 24
    //   1654: astore 27
    //   1656: aload 24
    //   1658: astore 25
    //   1660: aload 24
    //   1662: astore 26
    //   1664: aload_0
    //   1665: getfield 62	com/tencent/mobileqq/app/face/FaceDownloader:jdField_b_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   1668: aload 37
    //   1670: invokevirtual 452	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   1673: pop
    //   1674: aload 24
    //   1676: astore 27
    //   1678: aload 24
    //   1680: astore 25
    //   1682: aload 24
    //   1684: astore 26
    //   1686: aload_0
    //   1687: getfield 164	com/tencent/mobileqq/app/face/FaceDownloader:jdField_a_of_type_MqqOsMqqHandler	Lmqq/os/MqqHandler;
    //   1690: bipush 100
    //   1692: aload 37
    //   1694: invokevirtual 458	mqq/os/MqqHandler:obtainMessage	(ILjava/lang/Object;)Landroid/os/Message;
    //   1697: invokevirtual 463	android/os/Message:sendToTarget	()V
    //   1700: aload 24
    //   1702: astore 27
    //   1704: aload 24
    //   1706: astore 25
    //   1708: aload 24
    //   1710: astore 26
    //   1712: aload 24
    //   1714: aload_1
    //   1715: iconst_0
    //   1716: iload 5
    //   1718: invokevirtual 791	java/io/OutputStream:write	([BII)V
    //   1721: aload 24
    //   1723: astore 27
    //   1725: aload 24
    //   1727: astore 25
    //   1729: aload 24
    //   1731: astore 26
    //   1733: aload 24
    //   1735: invokevirtual 794	java/io/OutputStream:flush	()V
    //   1738: aload 24
    //   1740: astore 27
    //   1742: aload 24
    //   1744: astore 25
    //   1746: aload 24
    //   1748: astore 26
    //   1750: aload_0
    //   1751: aload_2
    //   1752: aload 31
    //   1754: invokespecial 796	com/tencent/mobileqq/app/face/FaceDownloader:a	(Ljava/io/File;Ljava/io/File;)V
    //   1757: iconst_0
    //   1758: istore 5
    //   1760: aload 24
    //   1762: astore_1
    //   1763: aload_0
    //   1764: aload_1
    //   1765: aload 23
    //   1767: invokespecial 749	com/tencent/mobileqq/app/face/FaceDownloader:a	(Ljava/io/OutputStream;Ljava/net/HttpURLConnection;)V
    //   1770: aload_0
    //   1771: iload 5
    //   1773: aload 31
    //   1775: invokespecial 751	com/tencent/mobileqq/app/face/FaceDownloader:a	(ILjava/io/File;)V
    //   1778: iload 12
    //   1780: iconst_1
    //   1781: iadd
    //   1782: istore 6
    //   1784: iload 5
    //   1786: ifeq +140 -> 1926
    //   1789: ldc 139
    //   1791: iconst_1
    //   1792: new 171	java/lang/StringBuilder
    //   1795: dup
    //   1796: invokespecial 172	java/lang/StringBuilder:<init>	()V
    //   1799: ldc_w 753
    //   1802: invokevirtual 178	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1805: iload 5
    //   1807: invokevirtual 248	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1810: ldc_w 755
    //   1813: invokevirtual 178	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1816: aload 30
    //   1818: invokevirtual 181	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   1821: ldc_w 757
    //   1824: invokevirtual 178	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1827: iload 6
    //   1829: invokevirtual 248	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1832: ldc 183
    //   1834: invokevirtual 178	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1837: aload_3
    //   1838: invokevirtual 181	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   1841: ldc_w 759
    //   1844: invokevirtual 178	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1847: iload 15
    //   1849: invokevirtual 253	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   1852: ldc_w 761
    //   1855: invokevirtual 178	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1858: aload 34
    //   1860: invokevirtual 178	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1863: ldc_w 763
    //   1866: invokevirtual 178	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1869: iload 14
    //   1871: invokevirtual 248	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1874: ldc_w 765
    //   1877: invokevirtual 178	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1880: getstatic 531	com/tencent/mobileqq/app/face/FaceDownloader:jdField_a_of_type_Boolean	Z
    //   1883: invokevirtual 253	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   1886: ldc_w 767
    //   1889: invokevirtual 178	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1892: iload 11
    //   1894: invokevirtual 248	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1897: ldc_w 769
    //   1900: invokevirtual 178	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1903: aload 35
    //   1905: invokevirtual 178	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1908: ldc_w 771
    //   1911: invokevirtual 178	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1914: getstatic 30	com/tencent/mobileqq/app/face/FaceDownloader:e	I
    //   1917: invokevirtual 248	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1920: invokevirtual 187	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1923: invokestatic 261	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   1926: iload 5
    //   1928: ifeq +945 -> 2873
    //   1931: iload 6
    //   1933: iconst_2
    //   1934: if_icmpge +939 -> 2873
    //   1937: aload 29
    //   1939: monitorenter
    //   1940: aload 29
    //   1942: ldc2_w 772
    //   1945: invokevirtual 777	java/lang/Object:wait	(J)V
    //   1948: aload 29
    //   1950: monitorexit
    //   1951: goto -932 -> 1019
    //   1954: aload 24
    //   1956: astore 27
    //   1958: aload 24
    //   1960: astore 25
    //   1962: aload 24
    //   1964: astore 26
    //   1966: sipush 1024
    //   1969: newarray byte
    //   1971: astore_1
    //   1972: iconst_0
    //   1973: istore 5
    //   1975: aload 24
    //   1977: astore 27
    //   1979: aload 24
    //   1981: astore 25
    //   1983: aload 24
    //   1985: astore 26
    //   1987: aload 36
    //   1989: aload_1
    //   1990: invokevirtual 799	java/io/InputStream:read	([B)I
    //   1993: istore 6
    //   1995: iload 6
    //   1997: iconst_m1
    //   1998: if_icmpeq +100 -> 2098
    //   2001: iload 5
    //   2003: iload 6
    //   2005: iadd
    //   2006: istore 5
    //   2008: aload 24
    //   2010: astore 27
    //   2012: aload 24
    //   2014: astore 25
    //   2016: aload 24
    //   2018: astore 26
    //   2020: aload 24
    //   2022: aload_1
    //   2023: iconst_0
    //   2024: iload 6
    //   2026: invokevirtual 791	java/io/OutputStream:write	([BII)V
    //   2029: goto -54 -> 1975
    //   2032: astore_1
    //   2033: aload 24
    //   2035: astore_1
    //   2036: aload_1
    //   2037: astore 27
    //   2039: aload_1
    //   2040: astore 25
    //   2042: aload_1
    //   2043: astore 26
    //   2045: ldc 139
    //   2047: iconst_1
    //   2048: new 171	java/lang/StringBuilder
    //   2051: dup
    //   2052: invokespecial 172	java/lang/StringBuilder:<init>	()V
    //   2055: ldc_w 801
    //   2058: invokevirtual 178	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2061: aload 31
    //   2063: invokevirtual 234	java/io/File:exists	()Z
    //   2066: invokevirtual 253	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   2069: ldc_w 803
    //   2072: invokevirtual 178	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2075: aload 31
    //   2077: invokevirtual 243	java/io/File:getParentFile	()Ljava/io/File;
    //   2080: invokevirtual 234	java/io/File:exists	()Z
    //   2083: invokevirtual 253	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   2086: invokevirtual 187	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2089: invokestatic 261	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   2092: iconst_4
    //   2093: istore 5
    //   2095: goto -332 -> 1763
    //   2098: aload 24
    //   2100: astore 27
    //   2102: aload 24
    //   2104: astore 25
    //   2106: aload 24
    //   2108: astore 26
    //   2110: aload_3
    //   2111: getstatic 446	com/tencent/mobileqq/app/face/FaceInfo:o	I
    //   2114: invokevirtual 296	com/tencent/mobileqq/app/face/FaceInfo:a	(I)V
    //   2117: goto -396 -> 1721
    //   2120: astore 24
    //   2122: aload 23
    //   2124: astore_1
    //   2125: aload 27
    //   2127: astore 23
    //   2129: iconst_0
    //   2130: istore 5
    //   2132: goto -1336 -> 796
    //   2135: iload 5
    //   2137: istore 7
    //   2139: lload 17
    //   2141: lstore 19
    //   2143: iload 10
    //   2145: istore 8
    //   2147: lload 17
    //   2149: lstore 21
    //   2151: iload 13
    //   2153: istore 9
    //   2155: aload 32
    //   2157: getfield 704	arul:c	I
    //   2160: istore 5
    //   2162: goto -399 -> 1763
    //   2165: astore_1
    //   2166: aload 29
    //   2168: monitorexit
    //   2169: aload_1
    //   2170: athrow
    //   2171: astore_1
    //   2172: aload 29
    //   2174: monitorexit
    //   2175: aload_1
    //   2176: athrow
    //   2177: astore 24
    //   2179: iconst_0
    //   2180: istore 5
    //   2182: aload 25
    //   2184: astore_1
    //   2185: aload 24
    //   2187: astore 25
    //   2189: ldc 139
    //   2191: iconst_1
    //   2192: new 171	java/lang/StringBuilder
    //   2195: dup
    //   2196: invokespecial 172	java/lang/StringBuilder:<init>	()V
    //   2199: ldc_w 805
    //   2202: invokevirtual 178	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2205: aload 30
    //   2207: invokevirtual 181	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   2210: ldc 183
    //   2212: invokevirtual 178	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2215: aload_3
    //   2216: invokevirtual 181	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   2219: invokevirtual 187	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2222: aload 25
    //   2224: invokestatic 190	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   2227: aload_0
    //   2228: aload_1
    //   2229: aload 23
    //   2231: invokespecial 749	com/tencent/mobileqq/app/face/FaceDownloader:a	(Ljava/io/OutputStream;Ljava/net/HttpURLConnection;)V
    //   2234: aload_0
    //   2235: iconst_5
    //   2236: aload 31
    //   2238: invokespecial 751	com/tencent/mobileqq/app/face/FaceDownloader:a	(ILjava/io/File;)V
    //   2241: iload 12
    //   2243: iconst_1
    //   2244: iadd
    //   2245: istore 5
    //   2247: ldc 139
    //   2249: iconst_1
    //   2250: new 171	java/lang/StringBuilder
    //   2253: dup
    //   2254: invokespecial 172	java/lang/StringBuilder:<init>	()V
    //   2257: ldc_w 753
    //   2260: invokevirtual 178	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2263: iconst_5
    //   2264: invokevirtual 248	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   2267: ldc_w 755
    //   2270: invokevirtual 178	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2273: aload 30
    //   2275: invokevirtual 181	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   2278: ldc_w 757
    //   2281: invokevirtual 178	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2284: iload 5
    //   2286: invokevirtual 248	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   2289: ldc 183
    //   2291: invokevirtual 178	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2294: aload_3
    //   2295: invokevirtual 181	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   2298: ldc_w 759
    //   2301: invokevirtual 178	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2304: iload 15
    //   2306: invokevirtual 253	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   2309: ldc_w 761
    //   2312: invokevirtual 178	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2315: aload 34
    //   2317: invokevirtual 178	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2320: ldc_w 763
    //   2323: invokevirtual 178	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2326: iload 14
    //   2328: invokevirtual 248	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   2331: ldc_w 765
    //   2334: invokevirtual 178	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2337: getstatic 531	com/tencent/mobileqq/app/face/FaceDownloader:jdField_a_of_type_Boolean	Z
    //   2340: invokevirtual 253	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   2343: ldc_w 767
    //   2346: invokevirtual 178	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2349: iload 11
    //   2351: invokevirtual 248	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   2354: ldc_w 769
    //   2357: invokevirtual 178	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2360: aload 35
    //   2362: invokevirtual 178	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2365: ldc_w 771
    //   2368: invokevirtual 178	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2371: getstatic 30	com/tencent/mobileqq/app/face/FaceDownloader:e	I
    //   2374: invokevirtual 248	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   2377: invokevirtual 187	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2380: invokestatic 261	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   2383: iload 5
    //   2385: iconst_2
    //   2386: if_icmpge +452 -> 2838
    //   2389: aload 29
    //   2391: monitorenter
    //   2392: aload 29
    //   2394: ldc2_w 772
    //   2397: invokevirtual 777	java/lang/Object:wait	(J)V
    //   2400: aload 29
    //   2402: monitorexit
    //   2403: iload 5
    //   2405: istore 6
    //   2407: iconst_5
    //   2408: istore 5
    //   2410: goto -1391 -> 1019
    //   2413: astore_1
    //   2414: aload 29
    //   2416: monitorexit
    //   2417: aload_1
    //   2418: athrow
    //   2419: astore_2
    //   2420: iconst_0
    //   2421: istore 5
    //   2423: aload 26
    //   2425: astore_1
    //   2426: aload_0
    //   2427: aload_1
    //   2428: aload 23
    //   2430: invokespecial 749	com/tencent/mobileqq/app/face/FaceDownloader:a	(Ljava/io/OutputStream;Ljava/net/HttpURLConnection;)V
    //   2433: aload_0
    //   2434: iload 5
    //   2436: aload 31
    //   2438: invokespecial 751	com/tencent/mobileqq/app/face/FaceDownloader:a	(ILjava/io/File;)V
    //   2441: iload 12
    //   2443: iconst_1
    //   2444: iadd
    //   2445: istore 6
    //   2447: iload 5
    //   2449: ifeq +140 -> 2589
    //   2452: ldc 139
    //   2454: iconst_1
    //   2455: new 171	java/lang/StringBuilder
    //   2458: dup
    //   2459: invokespecial 172	java/lang/StringBuilder:<init>	()V
    //   2462: ldc_w 753
    //   2465: invokevirtual 178	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2468: iload 5
    //   2470: invokevirtual 248	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   2473: ldc_w 755
    //   2476: invokevirtual 178	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2479: aload 30
    //   2481: invokevirtual 181	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   2484: ldc_w 757
    //   2487: invokevirtual 178	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2490: iload 6
    //   2492: invokevirtual 248	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   2495: ldc 183
    //   2497: invokevirtual 178	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2500: aload_3
    //   2501: invokevirtual 181	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   2504: ldc_w 759
    //   2507: invokevirtual 178	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2510: iload 15
    //   2512: invokevirtual 253	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   2515: ldc_w 761
    //   2518: invokevirtual 178	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2521: aload 34
    //   2523: invokevirtual 178	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2526: ldc_w 763
    //   2529: invokevirtual 178	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2532: iload 14
    //   2534: invokevirtual 248	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   2537: ldc_w 765
    //   2540: invokevirtual 178	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2543: getstatic 531	com/tencent/mobileqq/app/face/FaceDownloader:jdField_a_of_type_Boolean	Z
    //   2546: invokevirtual 253	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   2549: ldc_w 767
    //   2552: invokevirtual 178	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2555: iload 11
    //   2557: invokevirtual 248	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   2560: ldc_w 769
    //   2563: invokevirtual 178	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2566: aload 35
    //   2568: invokevirtual 178	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2571: ldc_w 771
    //   2574: invokevirtual 178	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2577: getstatic 30	com/tencent/mobileqq/app/face/FaceDownloader:e	I
    //   2580: invokevirtual 248	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   2583: invokevirtual 187	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2586: invokestatic 261	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   2589: iload 5
    //   2591: ifeq +23 -> 2614
    //   2594: iload 6
    //   2596: iconst_2
    //   2597: if_icmpge +17 -> 2614
    //   2600: aload 29
    //   2602: monitorenter
    //   2603: aload 29
    //   2605: ldc2_w 772
    //   2608: invokevirtual 777	java/lang/Object:wait	(J)V
    //   2611: aload 29
    //   2613: monitorexit
    //   2614: aload_2
    //   2615: athrow
    //   2616: astore_1
    //   2617: aload 29
    //   2619: monitorexit
    //   2620: aload_1
    //   2621: athrow
    //   2622: astore 24
    //   2624: goto -1207 -> 1417
    //   2627: astore 24
    //   2629: goto -681 -> 1948
    //   2632: astore 24
    //   2634: goto -1640 -> 994
    //   2637: astore 24
    //   2639: goto -239 -> 2400
    //   2642: astore_1
    //   2643: goto -32 -> 2611
    //   2646: astore_2
    //   2647: aload_1
    //   2648: astore 24
    //   2650: aload 23
    //   2652: astore_1
    //   2653: aload 24
    //   2655: astore 23
    //   2657: goto -231 -> 2426
    //   2660: astore_2
    //   2661: goto -235 -> 2426
    //   2664: astore_2
    //   2665: iconst_0
    //   2666: istore 15
    //   2668: aload 24
    //   2670: astore 23
    //   2672: goto -246 -> 2426
    //   2675: astore_2
    //   2676: aload 24
    //   2678: astore 23
    //   2680: goto -254 -> 2426
    //   2683: astore_2
    //   2684: goto -258 -> 2426
    //   2687: astore_2
    //   2688: iload 7
    //   2690: istore 5
    //   2692: goto -266 -> 2426
    //   2695: astore 25
    //   2697: iconst_0
    //   2698: istore 15
    //   2700: aload 24
    //   2702: astore 23
    //   2704: goto -515 -> 2189
    //   2707: astore 25
    //   2709: aload 24
    //   2711: astore 23
    //   2713: goto -524 -> 2189
    //   2716: astore 25
    //   2718: goto -529 -> 2189
    //   2721: astore 25
    //   2723: iload 8
    //   2725: istore 5
    //   2727: lload 19
    //   2729: lstore 17
    //   2731: goto -542 -> 2189
    //   2734: astore 26
    //   2736: aload 24
    //   2738: astore 23
    //   2740: aload_1
    //   2741: astore 25
    //   2743: iconst_5
    //   2744: istore 5
    //   2746: aload 26
    //   2748: astore 24
    //   2750: aload 23
    //   2752: astore_1
    //   2753: aload 25
    //   2755: astore 23
    //   2757: goto -1961 -> 796
    //   2760: astore 26
    //   2762: aload 24
    //   2764: astore 23
    //   2766: aload_1
    //   2767: astore 25
    //   2769: iconst_5
    //   2770: istore 5
    //   2772: aload 26
    //   2774: astore 24
    //   2776: aload 23
    //   2778: astore_1
    //   2779: aload 25
    //   2781: astore 23
    //   2783: goto -1987 -> 796
    //   2786: astore 24
    //   2788: lload 21
    //   2790: lstore 17
    //   2792: aload_1
    //   2793: astore 25
    //   2795: iload 9
    //   2797: istore 5
    //   2799: aload 23
    //   2801: astore_1
    //   2802: aload 25
    //   2804: astore 23
    //   2806: goto -2010 -> 796
    //   2809: astore 24
    //   2811: goto -775 -> 2036
    //   2814: goto -1795 -> 1019
    //   2817: iconst_5
    //   2818: istore 6
    //   2820: goto -1750 -> 1070
    //   2823: iload 6
    //   2825: istore 12
    //   2827: aload 28
    //   2829: astore 25
    //   2831: aload 23
    //   2833: astore 24
    //   2835: goto -2698 -> 137
    //   2838: iload 5
    //   2840: istore 6
    //   2842: iconst_5
    //   2843: istore 5
    //   2845: goto -1826 -> 1019
    //   2848: iload 5
    //   2850: istore 7
    //   2852: iload 6
    //   2854: istore 5
    //   2856: aload_1
    //   2857: astore 24
    //   2859: aload 23
    //   2861: astore_1
    //   2862: iload 7
    //   2864: istore 6
    //   2866: aload 24
    //   2868: astore 23
    //   2870: goto -1851 -> 1019
    //   2873: goto -1854 -> 1019
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	2876	0	this	FaceDownloader
    //   0	2876	1	paramString	String
    //   0	2876	2	paramFile	File
    //   0	2876	3	paramFaceInfo	FaceInfo
    //   0	2876	4	paramBoolean	boolean
    //   39	2816	5	i	int
    //   516	2349	6	j	int
    //   462	2401	7	k	int
    //   470	2254	8	m	int
    //   478	2318	9	n	int
    //   452	1692	10	i1	int
    //   280	2276	11	i2	int
    //   126	2700	12	i3	int
    //   455	1697	13	i4	int
    //   256	2277	14	i5	int
    //   246	2453	15	bool1	boolean
    //   326	3	16	bool2	boolean
    //   6	2785	17	l1	long
    //   466	2262	19	l2	long
    //   474	2315	21	l3	long
    //   56	2813	23	localObject1	Object
    //   129	1	24	localObject2	Object
    //   199	1	24	localIllegalArgumentException	java.lang.IllegalArgumentException
    //   407	308	24	localObject3	Object
    //   766	13	24	localThrowable1	Throwable
    //   781	22	24	localIOException1	IOException
    //   1003	1104	24	localObject4	Object
    //   2120	1	24	localIOException2	IOException
    //   2177	9	24	localThrowable2	Throwable
    //   2622	1	24	localInterruptedException1	java.lang.InterruptedException
    //   2627	1	24	localInterruptedException2	java.lang.InterruptedException
    //   2632	1	24	localInterruptedException3	java.lang.InterruptedException
    //   2637	1	24	localInterruptedException4	java.lang.InterruptedException
    //   2648	127	24	localObject5	Object
    //   2786	1	24	localIOException3	IOException
    //   2809	1	24	localFileNotFoundException	java.io.FileNotFoundException
    //   2833	34	24	localObject6	Object
    //   132	2091	25	localObject7	Object
    //   2695	1	25	localThrowable3	Throwable
    //   2707	1	25	localThrowable4	Throwable
    //   2716	1	25	localThrowable5	Throwable
    //   2721	1	25	localThrowable6	Throwable
    //   2741	89	25	localObject8	Object
    //   654	1770	26	localObject9	Object
    //   2734	13	26	localIOException4	IOException
    //   2760	13	26	localIOException5	IOException
    //   646	1480	27	localObject10	Object
    //   139	2689	28	localObject11	Object
    //   48	2570	29	localObject12	Object
    //   32	2448	30	localURL	URL
    //   109	2328	31	localFile	File
    //   68	2088	32	localarul	arul
    //   3	273	33	localNetworkInfo	android.net.NetworkInfo
    //   251	2271	34	str1	String
    //   287	2280	35	str2	String
    //   661	1327	36	localObject13	Object
    //   1613	80	37	localaocg	aocg
    // Exception table:
    //   from	to	target	type
    //   24	34	179	java/net/MalformedURLException
    //   50	55	187	java/lang/Exception
    //   70	79	199	java/lang/IllegalArgumentException
    //   201	206	209	java/lang/IllegalArgumentException
    //   341	409	766	java/lang/Throwable
    //   341	409	781	java/io/IOException
    //   409	451	781	java/io/IOException
    //   768	781	781	java/io/IOException
    //   1036	1051	781	java/io/IOException
    //   1423	1430	781	java/io/IOException
    //   1409	1417	1437	finally
    //   1417	1420	1437	finally
    //   1438	1441	1437	finally
    //   656	663	2032	java/io/FileNotFoundException
    //   692	698	2032	java/io/FileNotFoundException
    //   718	731	2032	java/io/FileNotFoundException
    //   1455	1462	2032	java/io/FileNotFoundException
    //   1483	1490	2032	java/io/FileNotFoundException
    //   1502	1516	2032	java/io/FileNotFoundException
    //   1528	1534	2032	java/io/FileNotFoundException
    //   1546	1593	2032	java/io/FileNotFoundException
    //   1605	1615	2032	java/io/FileNotFoundException
    //   1627	1633	2032	java/io/FileNotFoundException
    //   1645	1652	2032	java/io/FileNotFoundException
    //   1664	1674	2032	java/io/FileNotFoundException
    //   1686	1700	2032	java/io/FileNotFoundException
    //   1712	1721	2032	java/io/FileNotFoundException
    //   1733	1738	2032	java/io/FileNotFoundException
    //   1750	1757	2032	java/io/FileNotFoundException
    //   1966	1972	2032	java/io/FileNotFoundException
    //   1987	1995	2032	java/io/FileNotFoundException
    //   2020	2029	2032	java/io/FileNotFoundException
    //   2110	2117	2032	java/io/FileNotFoundException
    //   656	663	2120	java/io/IOException
    //   692	698	2120	java/io/IOException
    //   718	731	2120	java/io/IOException
    //   1455	1462	2120	java/io/IOException
    //   1483	1490	2120	java/io/IOException
    //   1502	1516	2120	java/io/IOException
    //   1528	1534	2120	java/io/IOException
    //   1546	1593	2120	java/io/IOException
    //   1605	1615	2120	java/io/IOException
    //   1627	1633	2120	java/io/IOException
    //   1645	1652	2120	java/io/IOException
    //   1664	1674	2120	java/io/IOException
    //   1686	1700	2120	java/io/IOException
    //   1712	1721	2120	java/io/IOException
    //   1733	1738	2120	java/io/IOException
    //   1750	1757	2120	java/io/IOException
    //   1966	1972	2120	java/io/IOException
    //   1987	1995	2120	java/io/IOException
    //   2020	2029	2120	java/io/IOException
    //   2045	2092	2120	java/io/IOException
    //   2110	2117	2120	java/io/IOException
    //   1940	1948	2165	finally
    //   1948	1951	2165	finally
    //   2166	2169	2165	finally
    //   986	994	2171	finally
    //   994	997	2171	finally
    //   2172	2175	2171	finally
    //   656	663	2177	java/lang/Throwable
    //   692	698	2177	java/lang/Throwable
    //   718	731	2177	java/lang/Throwable
    //   1455	1462	2177	java/lang/Throwable
    //   1483	1490	2177	java/lang/Throwable
    //   1502	1516	2177	java/lang/Throwable
    //   1528	1534	2177	java/lang/Throwable
    //   1546	1593	2177	java/lang/Throwable
    //   1605	1615	2177	java/lang/Throwable
    //   1627	1633	2177	java/lang/Throwable
    //   1645	1652	2177	java/lang/Throwable
    //   1664	1674	2177	java/lang/Throwable
    //   1686	1700	2177	java/lang/Throwable
    //   1712	1721	2177	java/lang/Throwable
    //   1733	1738	2177	java/lang/Throwable
    //   1750	1757	2177	java/lang/Throwable
    //   1966	1972	2177	java/lang/Throwable
    //   1987	1995	2177	java/lang/Throwable
    //   2020	2029	2177	java/lang/Throwable
    //   2045	2092	2177	java/lang/Throwable
    //   2110	2117	2177	java/lang/Throwable
    //   2392	2400	2413	finally
    //   2400	2403	2413	finally
    //   2414	2417	2413	finally
    //   656	663	2419	finally
    //   692	698	2419	finally
    //   718	731	2419	finally
    //   1455	1462	2419	finally
    //   1483	1490	2419	finally
    //   1502	1516	2419	finally
    //   1528	1534	2419	finally
    //   1546	1593	2419	finally
    //   1605	1615	2419	finally
    //   1627	1633	2419	finally
    //   1645	1652	2419	finally
    //   1664	1674	2419	finally
    //   1686	1700	2419	finally
    //   1712	1721	2419	finally
    //   1733	1738	2419	finally
    //   1750	1757	2419	finally
    //   1966	1972	2419	finally
    //   1987	1995	2419	finally
    //   2020	2029	2419	finally
    //   2045	2092	2419	finally
    //   2110	2117	2419	finally
    //   2603	2611	2616	finally
    //   2611	2614	2616	finally
    //   2617	2620	2616	finally
    //   1409	1417	2622	java/lang/InterruptedException
    //   1940	1948	2627	java/lang/InterruptedException
    //   986	994	2632	java/lang/InterruptedException
    //   2392	2400	2637	java/lang/InterruptedException
    //   2603	2611	2642	java/lang/InterruptedException
    //   796	809	2646	finally
    //   2189	2227	2660	finally
    //   289	328	2664	finally
    //   332	341	2675	finally
    //   341	409	2683	finally
    //   409	451	2683	finally
    //   768	781	2683	finally
    //   1036	1051	2683	finally
    //   1423	1430	2683	finally
    //   480	491	2687	finally
    //   511	518	2687	finally
    //   546	554	2687	finally
    //   574	580	2687	finally
    //   600	606	2687	finally
    //   626	644	2687	finally
    //   1098	1111	2687	finally
    //   1139	1147	2687	finally
    //   1175	1193	2687	finally
    //   1225	1232	2687	finally
    //   2155	2162	2687	finally
    //   289	328	2695	java/lang/Throwable
    //   332	341	2707	java/lang/Throwable
    //   409	451	2716	java/lang/Throwable
    //   768	781	2716	java/lang/Throwable
    //   1036	1051	2716	java/lang/Throwable
    //   1423	1430	2716	java/lang/Throwable
    //   480	491	2721	java/lang/Throwable
    //   511	518	2721	java/lang/Throwable
    //   546	554	2721	java/lang/Throwable
    //   574	580	2721	java/lang/Throwable
    //   600	606	2721	java/lang/Throwable
    //   626	644	2721	java/lang/Throwable
    //   1098	1111	2721	java/lang/Throwable
    //   1139	1147	2721	java/lang/Throwable
    //   1175	1193	2721	java/lang/Throwable
    //   1225	1232	2721	java/lang/Throwable
    //   2155	2162	2721	java/lang/Throwable
    //   289	328	2734	java/io/IOException
    //   332	341	2760	java/io/IOException
    //   480	491	2786	java/io/IOException
    //   511	518	2786	java/io/IOException
    //   546	554	2786	java/io/IOException
    //   574	580	2786	java/io/IOException
    //   600	606	2786	java/io/IOException
    //   626	644	2786	java/io/IOException
    //   1098	1111	2786	java/io/IOException
    //   1139	1147	2786	java/io/IOException
    //   1175	1193	2786	java/io/IOException
    //   1225	1232	2786	java/io/IOException
    //   2155	2162	2786	java/io/IOException
    //   546	554	2809	java/io/FileNotFoundException
    //   574	580	2809	java/io/FileNotFoundException
    //   600	606	2809	java/io/FileNotFoundException
    //   626	644	2809	java/io/FileNotFoundException
  }
  
  public aocf a()
  {
    aocf localaocf = new aocf(this);
    int i = Runtime.getRuntime().availableProcessors();
    if (QLog.isColorLevel()) {
      QLog.i("Q.qqhead.FaceDownloader", 2, "processor count:" + i);
    }
    if (i >= 4) {}
    do
    {
      return localaocf;
      localaocf.jdField_a_of_type_Int = (i + 1);
    } while (i > 2);
    localaocf.jdField_b_of_type_Int = 10;
    return localaocf;
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
  
  public void a(aoce paramaoce)
  {
    try
    {
      if (QLog.isColorLevel()) {
        QLog.i("Q.qqhead.FaceDownloader", 2, "addFaceDownloadListener l=" + paramaoce);
      }
      this.jdField_a_of_type_JavaUtilLinkedList.add(paramaoce);
      return;
    }
    finally {}
  }
  
  protected abstract void a(FaceInfo paramFaceInfo);
  
  public Object[] a(String paramString1, int paramInt1, String paramString2, boolean paramBoolean, int paramInt2, String paramString3)
  {
    boolean bool;
    if ((paramString1 != null) && (paramInt1 > 0) && (!jdField_a_of_type_Boolean)) {
      if ((paramString2.equals(bgva.d)) || (paramString2.equals(bgva.f)) || (paramString2.equals(bgva.h))) {
        if ((paramInt2 == -1) && (e == 1))
        {
          paramString2 = (HttpURLConnection)new URL(paramString3).openConnection();
          bool = false;
          paramString1 = paramString2;
          paramBoolean = bool;
          if (QLog.isDevelopLevel())
          {
            QLog.i("Q.qqhead.FaceDownloader", 4, "downloadData, wapconn, DPC_WAP_DIRECT_CONNECT=" + e + ", tryCount=" + paramInt2);
            paramBoolean = bool;
            paramString1 = paramString2;
          }
        }
      }
    }
    for (;;)
    {
      paramString1.setRequestProperty("Accept-Encoding", "identity");
      paramString1.setConnectTimeout(30000);
      paramString1.setReadTimeout(30000);
      paramString1.setInstanceFollowRedirects(true);
      return new Object[] { Boolean.valueOf(paramBoolean), paramString1 };
      paramString2 = bgva.b(paramString3, paramString1, paramInt1);
      bool = true;
      break;
      if (paramString2.equals(bgva.b))
      {
        paramString1 = bgva.a(paramString3, paramString1, paramInt1);
        paramBoolean = true;
      }
      else
      {
        paramString1 = bgva.a(paramString3, paramString1, paramInt1);
        paramBoolean = true;
        continue;
        paramString1 = (HttpURLConnection)new URL(paramString3).openConnection();
      }
    }
  }
  
  public void b(aoce paramaoce)
  {
    try
    {
      if (QLog.isColorLevel()) {
        QLog.i("Q.qqhead.FaceDownloader", 2, "removeFaceDownloadListener l=" + paramaoce);
      }
      this.jdField_a_of_type_JavaUtilLinkedList.remove(paramaoce);
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