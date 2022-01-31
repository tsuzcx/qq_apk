import android.os.Build.VERSION;
import android.view.animation.AnimationUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.DownloadParams;
import com.tencent.image.URLDrawableHandler;
import com.tencent.mobileqq.app.DeviceProfileManager;
import com.tencent.mobileqq.app.DeviceProfileManager.DpcNames;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.BaseConstants;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.BufferedInputStream;
import java.io.EOFException;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InterruptedIOException;
import java.io.OutputStream;
import java.net.ConnectException;
import java.net.InetAddress;
import java.net.MalformedURLException;
import java.net.NoRouteToHostException;
import java.net.PortUnreachableException;
import java.net.SocketException;
import java.net.SocketTimeoutException;
import java.net.URI;
import java.net.URL;
import java.net.UnknownHostException;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import org.apache.http.HttpResponse;
import org.apache.http.conn.params.ConnManagerParams;
import org.apache.http.conn.params.ConnPerRouteBean;
import org.apache.http.conn.scheme.PlainSocketFactory;
import org.apache.http.conn.scheme.Scheme;
import org.apache.http.conn.scheme.SchemeRegistry;
import org.apache.http.conn.scheme.SocketFactory;
import org.apache.http.conn.ssl.SSLSocketFactory;
import org.apache.http.impl.conn.tsccm.ThreadSafeClientConnManager;
import org.apache.http.params.BasicHttpParams;
import org.apache.http.params.HttpConnectionParams;
import org.apache.http.params.HttpParams;
import org.apache.http.protocol.HttpContext;

public class bapk
  extends bame
{
  private static bapn jdField_a_of_type_Bapn = ;
  private static boolean b;
  private static boolean c;
  protected AtomicBoolean a;
  private boolean jdField_a_of_type_Boolean;
  
  public bapk()
  {
    this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean(false);
  }
  
  public bapk(boolean paramBoolean, Object paramObject)
  {
    this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean(false);
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
  
  private static int a(int paramInt, Exception paramException, boolean paramBoolean)
  {
    String str = paramException.getMessage();
    if ((paramException instanceof SocketException))
    {
      if ((paramException instanceof ConnectException)) {
        return paramInt + 10;
      }
      if ((paramException instanceof NoRouteToHostException)) {
        return paramInt + 11;
      }
      if ((paramException instanceof PortUnreachableException)) {
        return paramInt + 12;
      }
      return paramInt + 13;
    }
    if ((paramException instanceof InterruptedIOException))
    {
      if ((paramException instanceof SocketTimeoutException))
      {
        if (paramBoolean) {
          return paramInt + 100;
        }
        return paramInt + 101;
      }
      return paramInt + 102;
    }
    if ((paramException instanceof IOException))
    {
      if ((paramException instanceof MalformedURLException)) {
        return paramInt + 200;
      }
      if ((paramException instanceof UnknownHostException)) {
        return paramInt + 201;
      }
      if ((paramException instanceof EOFException)) {
        return paramInt + 202;
      }
      if (str == null) {
        return paramInt + 307;
      }
      if (str.contains("unreachable)")) {
        return paramInt + 300;
      }
      if (str.contains("Connection refused")) {
        return paramInt + 301;
      }
      if (str.contains("No route to host"))
      {
        if (str.contains("SocketException")) {
          return paramInt + 302;
        }
        return paramInt + 303;
      }
      if (str.contains("unexpected end of stream")) {
        return paramInt + 304;
      }
      if (str.contains("Connection timed out")) {
        return paramInt + 305;
      }
      if (str.contains("unaccpet content type")) {
        return paramInt + 306;
      }
      return paramInt + 307;
    }
    return paramInt + 400;
  }
  
  private static bapn a()
  {
    Object localObject1 = new SchemeRegistry();
    ((SchemeRegistry)localObject1).register(new Scheme("http", PlainSocketFactory.getSocketFactory(), 80));
    for (;;)
    {
      try
      {
        if ((Build.VERSION.SDK_INT < 23) && (!c())) {
          continue;
        }
        localObject2 = SSLSocketFactory.getSocketFactory();
        ((SSLSocketFactory)localObject2).setHostnameVerifier(SSLSocketFactory.STRICT_HOSTNAME_VERIFIER);
        ((SchemeRegistry)localObject1).register(new Scheme("https", (SocketFactory)localObject2, 443));
      }
      catch (Exception localException)
      {
        Object localObject2;
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.e("URLDrawable_", 2, "createHttpClient():Can't support https on this devices.", localException);
        continue;
      }
      localObject2 = new BasicHttpParams();
      ConnManagerParams.setTimeout((HttpParams)localObject2, 20000L);
      ConnManagerParams.setMaxConnectionsPerRoute((HttpParams)localObject2, new ConnPerRouteBean(10));
      ConnManagerParams.setMaxTotalConnections((HttpParams)localObject2, 10);
      HttpConnectionParams.setSocketBufferSize((HttpParams)localObject2, 8192);
      localObject1 = new bapn(new ThreadSafeClientConnManager((HttpParams)localObject2, (SchemeRegistry)localObject1), (HttpParams)localObject2);
      ((bapn)localObject1).setRedirectHandler(new bapm());
      return localObject1;
      ((SchemeRegistry)localObject1).register(new Scheme("https", new batt(bapk.class.getSimpleName()), 443));
    }
  }
  
  public static void a(int paramInt1, String paramString1, int paramInt2, String paramString2)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put(BaseConstants.RDM_NoChangeFailCode, "");
    localHashMap.put("param_FailCode", String.valueOf(paramInt1));
    localHashMap.put("host", "" + paramString1);
    localHashMap.put("port", "" + paramInt2);
    localHashMap.put("businessType", paramString2);
    azmz.a(BaseApplication.getContext()).a(null, "actHttpsSniSupport", false, 0L, 0L, localHashMap, "");
    if (QLog.isColorLevel()) {
      QLog.e("HttpDownloader", 2, "[reportHttpsSniMethod] reflectOrNot=" + paramInt1 + " host=" + paramString1 + " " + paramInt2);
    }
  }
  
  private void a(DownloadParams paramDownloadParams, boolean paramBoolean1, URL paramURL, HttpContext paramHttpContext, boolean paramBoolean2, int paramInt1, int paramInt2, IOException paramIOException)
  {
    int j = 0;
    int i = j;
    if (paramDownloadParams.mHttpDownloaderParams != null)
    {
      i = j;
      if ((paramDownloadParams.mHttpDownloaderParams instanceof bapo))
      {
        j = ((bapo)paramDownloadParams.mHttpDownloaderParams).jdField_a_of_type_Int;
        i = j;
        if (paramHttpContext != null)
        {
          paramHttpContext.setAttribute("mobileqq_report_extra", paramDownloadParams.mHttpDownloaderParams);
          i = j;
        }
      }
    }
    if (QLog.isDevelopLevel()) {
      QLog.d("HttpDownloader", 4, "f.businessType =  " + i + " success = " + paramBoolean1 + "config.mHttpDownloaderParams =" + paramDownloadParams.mHttpDownloaderParams);
    }
    switch (i)
    {
    default: 
      return;
    }
    a(paramBoolean1, paramURL, paramHttpContext, paramBoolean2, paramInt1, paramInt2, paramIOException, null);
  }
  
  private void a(InputStream paramInputStream, long paramLong, OutputStream paramOutputStream, URLDrawableHandler paramURLDrawableHandler)
  {
    paramInputStream = new BufferedInputStream(paramInputStream, 4096);
    byte[] arrayOfByte;
    try
    {
      arrayOfByte = new byte[4096];
      if (!this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get()) {
        break label145;
      }
      throw new IOException("cancelled");
    }
    finally
    {
      paramInputStream.close();
    }
    int i;
    paramOutputStream.write(arrayOfByte, 0, i);
    Object localObject;
    long l2 = localObject + i;
    long l1 = l2;
    if (AnimationUtils.currentAnimationTimeMillis() - 0L > 100L) {
      paramURLDrawableHandler.publishProgress((int)((float)l2 / (float)paramLong * 9500.0F));
    }
    label145:
    for (l1 = l2;; l1 = 0L)
    {
      i = paramInputStream.read(arrayOfByte);
      if (i != -1)
      {
        if (!this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get()) {
          break;
        }
        throw new IOException("cancelled");
      }
      paramInputStream.close();
      return;
    }
  }
  
  public static void a(String paramString, int paramInt1, int paramInt2, int paramInt3, Exception paramException, boolean paramBoolean)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put(BaseConstants.RDM_NoChangeFailCode, "");
    int i = paramInt2;
    if (paramException != null)
    {
      if (paramInt2 != -1) {
        break label218;
      }
      paramInt2 = a(20000, paramException, paramBoolean);
    }
    for (;;)
    {
      localHashMap.put("ERROR_MSG", paramException.getMessage());
      i = paramInt2;
      localHashMap.put("param_FailCode", String.valueOf(i));
      localHashMap.put("url", "" + paramString);
      localHashMap.put("API_LEVEL", "" + Build.VERSION.SDK_INT);
      azmz.a(BaseApplication.getContext()).a(null, "actHttpsDownloadFail", false, paramInt1, paramInt3, localHashMap, "");
      if (QLog.isColorLevel()) {
        QLog.e("HttpDownloader", 2, "[reportHttpsResult] url=" + paramString + " port=" + paramInt1 + " responseCode=" + i + " " + paramInt3);
      }
      return;
      label218:
      paramInt2 += 10000;
    }
  }
  
  public static void a(String paramString, bapo parambapo, URLDrawableHandler paramURLDrawableHandler, int paramInt)
  {
    String str;
    if (BaseApplicationImpl.sProcessId == 1)
    {
      str = bame.d(paramString);
      if (!new File(str).exists()) {}
    }
    else
    {
      return;
    }
    bapv localbapv = ((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime()).getNetEngine(0);
    baps localbaps = new baps();
    localbaps.jdField_a_of_type_Boolean = true;
    localbaps.jdField_e_of_type_Boolean = true;
    localbaps.jdField_a_of_type_Bapx = new bapl(paramURLDrawableHandler, paramString, parambapo);
    localbaps.jdField_a_of_type_JavaLangString = paramString;
    localbaps.jdField_a_of_type_Int = 0;
    localbaps.c = str;
    localbaps.jdField_e_of_type_Int = 2;
    localbaps.h = parambapo.jdField_a_of_type_Boolean;
    localbapv.a(localbaps);
  }
  
  public static void a(boolean paramBoolean1, URL paramURL, HttpContext paramHttpContext, boolean paramBoolean2, int paramInt1, int paramInt2, IOException paramIOException, bapo parambapo)
  {
    String str1 = paramURL.toString();
    String str2 = paramURL.getHost();
    Object localObject9 = null;
    Object localObject8 = null;
    Object localObject5 = null;
    int j;
    int i;
    int k;
    int m;
    Object localObject6;
    Object localObject4;
    Object localObject2;
    Object localObject3;
    Object localObject1;
    if (parambapo != null)
    {
      j = parambapo.b;
      i = parambapo.c;
      paramURL = parambapo.jdField_a_of_type_JavaLangString;
      paramHttpContext = paramURL;
      k = i;
      m = j;
      if (!parambapo.jdField_a_of_type_Boolean) {
        break label895;
      }
      localObject6 = "pre";
      localObject4 = null;
      localObject5 = null;
      localObject2 = null;
      parambapo = paramURL;
      paramHttpContext = null;
      localObject3 = null;
      localObject1 = null;
      paramURL = (URL)localObject6;
    }
    for (;;)
    {
      if (!paramBoolean1)
      {
        try
        {
          localObject6 = InetAddress.getByName(str2);
          if (localObject6 == null) {
            break label836;
          }
          localObject6 = ((InetAddress)localObject6).getHostAddress();
        }
        catch (UnknownHostException localUnknownHostException)
        {
          for (;;)
          {
            int n;
            label196:
            label346:
            label364:
            localObject7 = localObject8;
            continue;
            k = 0;
            paramInt1 = 0;
            continue;
            localObject7 = null;
          }
        }
        n = paramInt1 * 10000;
        if (paramInt1 == 200) {
          if (!bdag.a())
          {
            k = 1;
            paramInt1 = 1;
            m = paramInt1;
            if (paramIOException != null)
            {
              localObject8 = paramIOException.getMessage();
              m = paramInt1;
              paramURL = (URL)localObject8;
              if (k == 0)
              {
                m = a(paramInt1, paramIOException, paramBoolean2);
                paramURL = (URL)localObject8;
              }
            }
            if (n < 0) {
              break label786;
            }
            paramInt1 = m + n;
            localObject8 = new HashMap();
            ((HashMap)localObject8).put("param_FailCode", String.valueOf(paramInt1));
            ((HashMap)localObject8).put("param_Url", str1);
            ((HashMap)localObject8).put("serviceId", String.valueOf(j));
            ((HashMap)localObject8).put("templateId", String.valueOf(i));
            ((HashMap)localObject8).put("param_RetryCount", String.valueOf(paramInt2));
            ((HashMap)localObject8).put("param_Host", str2);
            ((HashMap)localObject8).put("param_Address", localObject6);
            ((HashMap)localObject8).put("param_First_Direct_Host", localObject5);
            ((HashMap)localObject8).put("param_First_Direct_Address", localObject4);
            ((HashMap)localObject8).put("param_Last_Direct_Host", localObject3);
            ((HashMap)localObject8).put("param_Last_Direct_Address", localObject2);
            if (localObject1 != null) {
              break label796;
            }
            paramIOException = "";
            ((HashMap)localObject8).put("param_DirectList", paramIOException);
            if (paramHttpContext != null) {
              break label806;
            }
            paramHttpContext = "";
            ((HashMap)localObject8).put("param_LastDirectUrl", paramHttpContext);
            ((HashMap)localObject8).put("param_ErrDesc", paramURL);
            ((HashMap)localObject8).put("uintype", parambapo);
            if (QLog.isDevelopLevel()) {
              QLog.d("HttpDownloader", 4, "f =  " + ((HashMap)localObject8).toString());
            }
            azmz.a(BaseApplication.getContext()).a(null, "StructMsgPicDown", paramBoolean1, 0L, 0L, (HashMap)localObject8, null);
            return;
            if (paramHttpContext == null) {
              break label941;
            }
            paramURL = paramHttpContext.getAttribute("mobileqq_report_extra");
            if ((paramURL == null) || (!(paramURL instanceof bapo))) {
              break label928;
            }
            paramURL = (bapo)paramURL;
            j = paramURL.b;
            i = paramURL.c;
          }
        }
      }
      for (paramURL = paramURL.jdField_a_of_type_JavaLangString;; paramURL = "0")
      {
        parambapo = paramHttpContext.getAttribute("mobileqq_direct_uri");
        paramHttpContext = paramURL;
        k = i;
        m = j;
        if (parambapo != null)
        {
          paramHttpContext = paramURL;
          k = i;
          m = j;
          if ((parambapo instanceof List))
          {
            List localList = (List)parambapo;
            StringBuilder localStringBuilder = new StringBuilder();
            localObject1 = null;
            localObject3 = null;
            localObject2 = null;
            localObject4 = null;
            k = 0;
            paramHttpContext = (HttpContext)localObject5;
            label576:
            if (k < localList.size())
            {
              URI localURI = (URI)localList.get(k);
              localStringBuilder.append(localURI.getHost()).append("|");
              localObject5 = null;
              try
              {
                localObject6 = InetAddress.getByName(localURI.getHost());
                parambapo = (bapo)localObject5;
                if (localObject6 != null) {
                  parambapo = ((InetAddress)localObject6).getHostAddress();
                }
              }
              catch (UnknownHostException parambapo)
              {
                for (;;)
                {
                  parambapo = (bapo)localObject5;
                }
              }
              if (parambapo != null) {
                localStringBuilder.append(parambapo);
              }
              localStringBuilder.append("|");
              if (k == 0)
              {
                localObject5 = localURI.getHost();
                localObject6 = parambapo;
                if (k != localList.size() - 1) {
                  break label852;
                }
                paramHttpContext = localURI.toString();
              }
              label836:
              label852:
              for (;;)
              {
                k += 1;
                localObject3 = localObject6;
                localObject1 = localObject5;
                break label576;
                localObject6 = localObject3;
                localObject5 = localObject1;
                if (k != localList.size() - 1) {
                  break label686;
                }
                localObject2 = localURI.getHost();
                localObject4 = parambapo;
                localObject6 = localObject3;
                localObject5 = localObject1;
                break label686;
                if (bdag.a() < 8L)
                {
                  k = 1;
                  paramInt1 = 2;
                  break;
                  paramInt1 = n - m;
                  break label196;
                  paramIOException = localObject1.toString();
                  break label346;
                  break label364;
                }
                paramInt1 = 0;
                localObject7 = localObject9;
                break label196;
              }
            }
            label686:
            localList = null;
            label786:
            label796:
            label806:
            localObject5 = localObject3;
            parambapo = paramURL;
            Object localObject7 = localObject1;
            localObject3 = localObject2;
            localObject1 = localStringBuilder;
            paramURL = localList;
            localObject2 = localObject4;
            localObject4 = localObject5;
            localObject5 = localObject7;
            break;
          }
        }
        label895:
        paramURL = null;
        localObject4 = null;
        localObject5 = null;
        localObject2 = null;
        j = m;
        parambapo = paramHttpContext;
        paramHttpContext = null;
        i = k;
        localObject1 = null;
        localObject3 = null;
        break;
        label928:
        j = 0;
        i = 0;
      }
      label941:
      parambapo = "0";
      localObject4 = null;
      paramURL = null;
      localObject5 = null;
      localObject2 = null;
      j = 0;
      i = 0;
      paramHttpContext = null;
      localObject1 = null;
      localObject3 = null;
    }
  }
  
  public static boolean c()
  {
    if (!b) {
      b = true;
    }
    try
    {
      Object localObject = DeviceProfileManager.a().a(DeviceProfileManager.DpcNames.aio_config.name(), "");
      if (QLog.isColorLevel()) {
        QLog.d("HttpDownloader", 2, "shutdownSniSupport:" + (String)localObject);
      }
      localObject = ((String)localObject).split("\\|");
      if (localObject.length > 15) {
        c = localObject[15].equals("1");
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.d("HttpDownloader", 2, "shutdownSniSupport e:" + localException.toString());
        }
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d("HttpDownloader", 2, "shutdownSniSupport " + c);
    }
    return c;
  }
  
  public File a(OutputStream paramOutputStream, DownloadParams paramDownloadParams, URLDrawableHandler paramURLDrawableHandler)
  {
    return a(paramOutputStream, paramDownloadParams, paramURLDrawableHandler, 0, null);
  }
  
  /* Error */
  public File a(OutputStream paramOutputStream, DownloadParams paramDownloadParams, URLDrawableHandler paramURLDrawableHandler, int paramInt, URL paramURL)
  {
    // Byte code:
    //   0: aload_2
    //   1: getfield 552	com/tencent/image/DownloadParams:needCheckNetType	Z
    //   4: istore 10
    //   6: invokestatic 555	baul:a	()Z
    //   9: istore 11
    //   11: invokestatic 556	com/tencent/common/app/BaseApplicationImpl:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   14: invokestatic 559	baul:b	(Landroid/content/Context;)Z
    //   17: istore 12
    //   19: invokestatic 183	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   22: ifeq +68 -> 90
    //   25: ldc 250
    //   27: iconst_2
    //   28: new 217	java/lang/StringBuilder
    //   31: dup
    //   32: invokespecial 218	java/lang/StringBuilder:<init>	()V
    //   35: ldc_w 561
    //   38: invokevirtual 222	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   41: aload_2
    //   42: getfield 564	com/tencent/image/DownloadParams:url	Ljava/net/URL;
    //   45: invokevirtual 419	java/net/URL:toString	()Ljava/lang/String;
    //   48: invokevirtual 222	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   51: ldc_w 566
    //   54: invokevirtual 222	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   57: iload 10
    //   59: invokevirtual 288	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   62: ldc_w 568
    //   65: invokevirtual 222	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   68: iload 11
    //   70: invokevirtual 288	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   73: ldc_w 570
    //   76: invokevirtual 222	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   79: iload 12
    //   81: invokevirtual 288	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   84: invokevirtual 225	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   87: invokestatic 573	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   90: aload_2
    //   91: getfield 552	com/tencent/image/DownloadParams:needCheckNetType	Z
    //   94: ifeq +15 -> 109
    //   97: iload 11
    //   99: ifeq +10 -> 109
    //   102: iload 12
    //   104: ifne +5 -> 109
    //   107: aconst_null
    //   108: areturn
    //   109: aload_2
    //   110: getfield 266	com/tencent/image/DownloadParams:mHttpDownloaderParams	Ljava/lang/Object;
    //   113: ifnull +1302 -> 1415
    //   116: aload_2
    //   117: getfield 266	com/tencent/image/DownloadParams:mHttpDownloaderParams	Ljava/lang/Object;
    //   120: instanceof 268
    //   123: ifeq +1292 -> 1415
    //   126: aload_2
    //   127: getfield 266	com/tencent/image/DownloadParams:mHttpDownloaderParams	Ljava/lang/Object;
    //   130: checkcast 268	bapo
    //   133: astore 13
    //   135: aload 13
    //   137: getfield 270	bapo:jdField_a_of_type_Int	I
    //   140: istore 7
    //   142: iload 7
    //   144: sipush 1001
    //   147: if_icmpne +63 -> 210
    //   150: getstatic 576	awfu:jdField_a_of_type_Boolean	Z
    //   153: ifeq +57 -> 210
    //   156: invokestatic 183	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   159: ifeq +35 -> 194
    //   162: ldc 250
    //   164: iconst_2
    //   165: new 217	java/lang/StringBuilder
    //   168: dup
    //   169: invokespecial 218	java/lang/StringBuilder:<init>	()V
    //   172: ldc_w 578
    //   175: invokevirtual 222	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   178: aload_2
    //   179: getfield 564	com/tencent/image/DownloadParams:url	Ljava/net/URL;
    //   182: invokevirtual 419	java/net/URL:toString	()Ljava/lang/String;
    //   185: invokevirtual 222	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   188: invokevirtual 225	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   191: invokestatic 573	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   194: aload_2
    //   195: getfield 564	com/tencent/image/DownloadParams:url	Ljava/net/URL;
    //   198: invokevirtual 419	java/net/URL:toString	()Ljava/lang/String;
    //   201: aload 13
    //   203: aload_3
    //   204: iconst_0
    //   205: invokestatic 580	bapk:a	(Ljava/lang/String;Lbapo;Lcom/tencent/image/URLDrawableHandler;I)V
    //   208: aconst_null
    //   209: areturn
    //   210: iconst_0
    //   211: istore 11
    //   213: aload_2
    //   214: getfield 564	com/tencent/image/DownloadParams:url	Ljava/net/URL;
    //   217: astore 13
    //   219: aload 5
    //   221: ifnull +7 -> 228
    //   224: aload 5
    //   226: astore 13
    //   228: invokestatic 183	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   231: ifeq +33 -> 264
    //   234: ldc 250
    //   236: iconst_2
    //   237: new 217	java/lang/StringBuilder
    //   240: dup
    //   241: invokespecial 218	java/lang/StringBuilder:<init>	()V
    //   244: ldc_w 582
    //   247: invokevirtual 222	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   250: aload 13
    //   252: invokevirtual 419	java/net/URL:toString	()Ljava/lang/String;
    //   255: invokevirtual 222	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   258: invokevirtual 225	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   261: invokestatic 296	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   264: aload_0
    //   265: getfield 31	bapk:jdField_a_of_type_Boolean	Z
    //   268: ifeq +1137 -> 1405
    //   271: iload 4
    //   273: ifne +1132 -> 1405
    //   276: ldc 85
    //   278: aload 13
    //   280: invokevirtual 585	java/net/URL:getProtocol	()Ljava/lang/String;
    //   283: invokevirtual 536	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   286: ifeq +1119 -> 1405
    //   289: aload 13
    //   291: invokevirtual 422	java/net/URL:getHost	()Ljava/lang/String;
    //   294: astore 14
    //   296: aload 14
    //   298: invokestatic 590	bdje:a	(Ljava/lang/String;)Z
    //   301: ifne +1104 -> 1405
    //   304: invokestatic 595	bavf:a	()Lbavf;
    //   307: aload 14
    //   309: sipush 1010
    //   312: invokevirtual 598	bavf:a	(Ljava/lang/String;I)Ljava/lang/String;
    //   315: astore 15
    //   317: aload 14
    //   319: aload 15
    //   321: invokevirtual 536	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   324: ifne +1081 -> 1405
    //   327: aload 15
    //   329: invokestatic 590	bdje:a	(Ljava/lang/String;)Z
    //   332: ifne +1073 -> 1405
    //   335: aload 13
    //   337: invokevirtual 419	java/net/URL:toString	()Ljava/lang/String;
    //   340: aload 15
    //   342: invokestatic 599	bavf:a	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   345: astore 13
    //   347: new 418	java/net/URL
    //   350: dup
    //   351: aload 13
    //   353: invokespecial 600	java/net/URL:<init>	(Ljava/lang/String;)V
    //   356: astore 15
    //   358: invokestatic 183	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   361: ifeq +1060 -> 1421
    //   364: ldc 250
    //   366: iconst_2
    //   367: new 217	java/lang/StringBuilder
    //   370: dup
    //   371: invokespecial 218	java/lang/StringBuilder:<init>	()V
    //   374: ldc_w 602
    //   377: invokevirtual 222	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   380: aload 13
    //   382: invokevirtual 222	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   385: invokevirtual 225	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   388: invokestatic 296	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   391: goto +1030 -> 1421
    //   394: aload_0
    //   395: getfield 28	bapk:jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   398: invokevirtual 308	java/util/concurrent/atomic/AtomicBoolean:get	()Z
    //   401: ifeq +59 -> 460
    //   404: new 52	java/io/IOException
    //   407: dup
    //   408: ldc_w 310
    //   411: invokespecial 311	java/io/IOException:<init>	(Ljava/lang/String;)V
    //   414: athrow
    //   415: astore_1
    //   416: aload_0
    //   417: aconst_null
    //   418: aload_1
    //   419: invokevirtual 603	java/net/URISyntaxException:toString	()Ljava/lang/String;
    //   422: aload_3
    //   423: invokevirtual 606	bapk:a	(Lorg/apache/http/HttpResponse;Ljava/lang/String;Lcom/tencent/image/URLDrawableHandler;)V
    //   426: new 608	java/lang/IllegalArgumentException
    //   429: dup
    //   430: new 217	java/lang/StringBuilder
    //   433: dup
    //   434: invokespecial 218	java/lang/StringBuilder:<init>	()V
    //   437: ldc_w 610
    //   440: invokevirtual 222	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   443: aload_2
    //   444: getfield 564	com/tencent/image/DownloadParams:url	Ljava/net/URL;
    //   447: invokevirtual 419	java/net/URL:toString	()Ljava/lang/String;
    //   450: invokevirtual 222	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   453: invokevirtual 225	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   456: invokespecial 611	java/lang/IllegalArgumentException:<init>	(Ljava/lang/String;)V
    //   459: athrow
    //   460: new 613	org/apache/http/client/methods/HttpGet
    //   463: dup
    //   464: aload 15
    //   466: invokevirtual 617	java/net/URL:toURI	()Ljava/net/URI;
    //   469: invokespecial 620	org/apache/http/client/methods/HttpGet:<init>	(Ljava/net/URI;)V
    //   472: astore 14
    //   474: aload_2
    //   475: getfield 624	com/tencent/image/DownloadParams:cookies	Lorg/apache/http/client/CookieStore;
    //   478: ifnull +106 -> 584
    //   481: getstatic 17	bapk:jdField_a_of_type_Bapn	Lbapn;
    //   484: invokevirtual 628	bapn:getCookieSpecs	()Lorg/apache/http/cookie/CookieSpecRegistry;
    //   487: ldc_w 630
    //   490: invokevirtual 636	org/apache/http/cookie/CookieSpecRegistry:getCookieSpec	(Ljava/lang/String;)Lorg/apache/http/cookie/CookieSpec;
    //   493: aload_2
    //   494: getfield 624	com/tencent/image/DownloadParams:cookies	Lorg/apache/http/client/CookieStore;
    //   497: invokeinterface 642 1 0
    //   502: invokeinterface 648 2 0
    //   507: invokeinterface 652 1 0
    //   512: astore 13
    //   514: aload 13
    //   516: invokeinterface 657 1 0
    //   521: ifeq +63 -> 584
    //   524: aload 14
    //   526: aload 13
    //   528: invokeinterface 661 1 0
    //   533: checkcast 663	org/apache/http/Header
    //   536: invokevirtual 667	org/apache/http/client/methods/HttpGet:addHeader	(Lorg/apache/http/Header;)V
    //   539: goto -25 -> 514
    //   542: astore 13
    //   544: new 613	org/apache/http/client/methods/HttpGet
    //   547: dup
    //   548: new 493	java/net/URI
    //   551: dup
    //   552: aload 15
    //   554: invokevirtual 585	java/net/URL:getProtocol	()Ljava/lang/String;
    //   557: aload 15
    //   559: invokevirtual 422	java/net/URL:getHost	()Ljava/lang/String;
    //   562: aload 15
    //   564: invokevirtual 670	java/net/URL:getPath	()Ljava/lang/String;
    //   567: aload 15
    //   569: invokevirtual 673	java/net/URL:getQuery	()Ljava/lang/String;
    //   572: aconst_null
    //   573: invokespecial 676	java/net/URI:<init>	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   576: invokespecial 620	org/apache/http/client/methods/HttpGet:<init>	(Ljava/net/URI;)V
    //   579: astore 14
    //   581: goto -107 -> 474
    //   584: aload_2
    //   585: getfield 680	com/tencent/image/DownloadParams:headers	[Lorg/apache/http/Header;
    //   588: ifnull +51 -> 639
    //   591: aload_2
    //   592: getfield 680	com/tencent/image/DownloadParams:headers	[Lorg/apache/http/Header;
    //   595: arraylength
    //   596: ifle +43 -> 639
    //   599: aload_2
    //   600: getfield 680	com/tencent/image/DownloadParams:headers	[Lorg/apache/http/Header;
    //   603: astore 13
    //   605: aload 13
    //   607: arraylength
    //   608: istore 9
    //   610: iconst_0
    //   611: istore 8
    //   613: iload 8
    //   615: iload 9
    //   617: if_icmpge +22 -> 639
    //   620: aload 14
    //   622: aload 13
    //   624: iload 8
    //   626: aaload
    //   627: invokevirtual 667	org/apache/http/client/methods/HttpGet:addHeader	(Lorg/apache/http/Header;)V
    //   630: iload 8
    //   632: iconst_1
    //   633: iadd
    //   634: istore 8
    //   636: goto -23 -> 613
    //   639: iload 6
    //   641: ifeq +17 -> 658
    //   644: aload 14
    //   646: ldc 215
    //   648: aload_2
    //   649: getfield 564	com/tencent/image/DownloadParams:url	Ljava/net/URL;
    //   652: invokevirtual 422	java/net/URL:getHost	()Ljava/lang/String;
    //   655: invokevirtual 683	org/apache/http/client/methods/HttpGet:addHeader	(Ljava/lang/String;Ljava/lang/String;)V
    //   658: getstatic 17	bapk:jdField_a_of_type_Bapn	Lbapn;
    //   661: invokevirtual 687	bapn:getParams	()Lorg/apache/http/params/HttpParams;
    //   664: astore 13
    //   666: aload 13
    //   668: ifnonnull +734 -> 1402
    //   671: new 124	org/apache/http/params/BasicHttpParams
    //   674: dup
    //   675: invokespecial 125	org/apache/http/params/BasicHttpParams:<init>	()V
    //   678: astore 13
    //   680: goto +747 -> 1427
    //   683: aload 13
    //   685: ldc_w 689
    //   688: iload 10
    //   690: invokestatic 694	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   693: invokeinterface 700 3 0
    //   698: pop
    //   699: aload 13
    //   701: ldc_w 702
    //   704: sipush 10000
    //   707: invokestatic 707	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   710: invokeinterface 700 3 0
    //   715: pop
    //   716: aload 13
    //   718: ldc_w 709
    //   721: sipush 20000
    //   724: invokestatic 707	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   727: invokeinterface 700 3 0
    //   732: pop
    //   733: getstatic 17	bapk:jdField_a_of_type_Bapn	Lbapn;
    //   736: aload 13
    //   738: invokevirtual 713	bapn:setParams	(Lorg/apache/http/params/HttpParams;)V
    //   741: aload_3
    //   742: invokeinterface 716 1 0
    //   747: aload_0
    //   748: getfield 28	bapk:jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   751: invokevirtual 308	java/util/concurrent/atomic/AtomicBoolean:get	()Z
    //   754: ifeq +108 -> 862
    //   757: new 52	java/io/IOException
    //   760: dup
    //   761: ldc_w 310
    //   764: invokespecial 311	java/io/IOException:<init>	(Ljava/lang/String;)V
    //   767: athrow
    //   768: astore 13
    //   770: iconst_m1
    //   771: istore 6
    //   773: iconst_0
    //   774: istore 10
    //   776: aconst_null
    //   777: astore 5
    //   779: aconst_null
    //   780: astore_1
    //   781: aload_1
    //   782: ifnonnull +63 -> 845
    //   785: aload_0
    //   786: aload_2
    //   787: iconst_0
    //   788: aload_2
    //   789: getfield 564	com/tencent/image/DownloadParams:url	Ljava/net/URL;
    //   792: aload 5
    //   794: iload 10
    //   796: iload 6
    //   798: iload 4
    //   800: aload 13
    //   802: invokespecial 718	bapk:a	(Lcom/tencent/image/DownloadParams;ZLjava/net/URL;Lorg/apache/http/protocol/HttpContext;ZIILjava/io/IOException;)V
    //   805: ldc 122
    //   807: aload_2
    //   808: getfield 564	com/tencent/image/DownloadParams:url	Ljava/net/URL;
    //   811: invokevirtual 585	java/net/URL:getProtocol	()Ljava/lang/String;
    //   814: invokevirtual 536	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   817: ifeq +28 -> 845
    //   820: aload_2
    //   821: getfield 564	com/tencent/image/DownloadParams:url	Ljava/net/URL;
    //   824: invokevirtual 422	java/net/URL:getHost	()Ljava/lang/String;
    //   827: aload_2
    //   828: getfield 564	com/tencent/image/DownloadParams:url	Ljava/net/URL;
    //   831: invokevirtual 721	java/net/URL:getPort	()I
    //   834: iload 6
    //   836: iload 4
    //   838: aload 13
    //   840: iload 10
    //   842: invokestatic 723	bapk:a	(Ljava/lang/String;IIILjava/lang/Exception;Z)V
    //   845: aload 13
    //   847: athrow
    //   848: astore_1
    //   849: aload 14
    //   851: invokevirtual 726	org/apache/http/client/methods/HttpGet:abort	()V
    //   854: aload_1
    //   855: athrow
    //   856: iconst_0
    //   857: istore 10
    //   859: goto -176 -> 683
    //   862: getstatic 17	bapk:jdField_a_of_type_Bapn	Lbapn;
    //   865: invokevirtual 730	bapn:createHttpContext	()Lorg/apache/http/protocol/HttpContext;
    //   868: astore 13
    //   870: iload 7
    //   872: sipush 1001
    //   875: if_icmpne +220 -> 1095
    //   878: iconst_1
    //   879: istore 7
    //   881: iload 11
    //   883: istore 10
    //   885: aload 13
    //   887: ldc_w 732
    //   890: iload 7
    //   892: invokestatic 707	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   895: invokeinterface 278 3 0
    //   900: iload 11
    //   902: istore 10
    //   904: getstatic 17	bapk:jdField_a_of_type_Bapn	Lbapn;
    //   907: aload 14
    //   909: aload 13
    //   911: invokevirtual 736	bapn:execute	(Lorg/apache/http/client/methods/HttpUriRequest;Lorg/apache/http/protocol/HttpContext;)Lorg/apache/http/HttpResponse;
    //   914: astore 17
    //   916: iconst_1
    //   917: istore 10
    //   919: aload 17
    //   921: invokeinterface 742 1 0
    //   926: invokeinterface 747 1 0
    //   931: istore 7
    //   933: invokestatic 183	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   936: ifne +11 -> 947
    //   939: iload 7
    //   941: sipush 200
    //   944: if_icmpeq +494 -> 1438
    //   947: ldc 250
    //   949: iconst_1
    //   950: new 217	java/lang/StringBuilder
    //   953: dup
    //   954: invokespecial 218	java/lang/StringBuilder:<init>	()V
    //   957: ldc_w 749
    //   960: invokevirtual 222	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   963: iload 7
    //   965: invokevirtual 230	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   968: ldc_w 751
    //   971: invokevirtual 222	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   974: aload 15
    //   976: invokevirtual 293	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   979: invokevirtual 225	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   982: invokestatic 259	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   985: goto +453 -> 1438
    //   988: aload 17
    //   990: ldc_w 753
    //   993: invokeinterface 757 2 0
    //   998: astore 15
    //   1000: aload 15
    //   1002: ifnull +140 -> 1142
    //   1005: aload 15
    //   1007: invokeinterface 760 1 0
    //   1012: astore 16
    //   1014: aload 16
    //   1016: invokestatic 765	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   1019: istore 10
    //   1021: iload 10
    //   1023: ifne +119 -> 1142
    //   1026: new 418	java/net/URL
    //   1029: dup
    //   1030: aload 16
    //   1032: invokespecial 600	java/net/URL:<init>	(Ljava/lang/String;)V
    //   1035: astore 15
    //   1037: aload 15
    //   1039: astore 5
    //   1041: invokestatic 183	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1044: ifeq +30 -> 1074
    //   1047: ldc 250
    //   1049: iconst_2
    //   1050: new 217	java/lang/StringBuilder
    //   1053: dup
    //   1054: invokespecial 218	java/lang/StringBuilder:<init>	()V
    //   1057: ldc_w 767
    //   1060: invokevirtual 222	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1063: aload 16
    //   1065: invokevirtual 222	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1068: invokevirtual 225	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1071: invokestatic 259	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   1074: aload_0
    //   1075: aload_1
    //   1076: aload_2
    //   1077: aload_3
    //   1078: iload 4
    //   1080: iconst_1
    //   1081: iadd
    //   1082: aload 5
    //   1084: invokevirtual 547	bapk:a	(Ljava/io/OutputStream;Lcom/tencent/image/DownloadParams;Lcom/tencent/image/URLDrawableHandler;ILjava/net/URL;)Ljava/io/File;
    //   1087: astore_1
    //   1088: aload 14
    //   1090: invokevirtual 726	org/apache/http/client/methods/HttpGet:abort	()V
    //   1093: aload_1
    //   1094: areturn
    //   1095: iconst_0
    //   1096: istore 7
    //   1098: goto -217 -> 881
    //   1101: astore 15
    //   1103: invokestatic 183	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1106: ifeq +380 -> 1486
    //   1109: ldc 250
    //   1111: iconst_2
    //   1112: ldc_w 769
    //   1115: invokestatic 259	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   1118: goto +368 -> 1486
    //   1121: invokestatic 595	bavf:a	()Lbavf;
    //   1124: aload_2
    //   1125: getfield 564	com/tencent/image/DownloadParams:url	Ljava/net/URL;
    //   1128: invokevirtual 422	java/net/URL:getHost	()Ljava/lang/String;
    //   1131: aload 15
    //   1133: invokevirtual 422	java/net/URL:getHost	()Ljava/lang/String;
    //   1136: sipush 1010
    //   1139: invokevirtual 772	bavf:a	(Ljava/lang/String;Ljava/lang/String;I)V
    //   1142: iload 4
    //   1144: aload_2
    //   1145: getfield 775	com/tencent/image/DownloadParams:retryCount	I
    //   1148: if_icmpge +23 -> 1171
    //   1151: aload_0
    //   1152: aload_1
    //   1153: aload_2
    //   1154: aload_3
    //   1155: iload 4
    //   1157: iconst_1
    //   1158: iadd
    //   1159: aconst_null
    //   1160: invokevirtual 547	bapk:a	(Ljava/io/OutputStream;Lcom/tencent/image/DownloadParams;Lcom/tencent/image/URLDrawableHandler;ILjava/net/URL;)Ljava/io/File;
    //   1163: astore_1
    //   1164: aload 14
    //   1166: invokevirtual 726	org/apache/http/client/methods/HttpGet:abort	()V
    //   1169: aload_1
    //   1170: areturn
    //   1171: aload_3
    //   1172: iload 7
    //   1174: invokeinterface 778 2 0
    //   1179: new 52	java/io/IOException
    //   1182: dup
    //   1183: new 217	java/lang/StringBuilder
    //   1186: dup
    //   1187: invokespecial 218	java/lang/StringBuilder:<init>	()V
    //   1190: ldc_w 780
    //   1193: invokevirtual 222	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1196: iload 7
    //   1198: invokevirtual 230	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1201: ldc_w 782
    //   1204: invokevirtual 222	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1207: aload_2
    //   1208: getfield 564	com/tencent/image/DownloadParams:url	Ljava/net/URL;
    //   1211: invokevirtual 293	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   1214: ldc_w 784
    //   1217: invokevirtual 222	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1220: aload 17
    //   1222: invokeinterface 742 1 0
    //   1227: invokeinterface 787 1 0
    //   1232: invokevirtual 222	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1235: invokevirtual 225	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1238: invokespecial 311	java/io/IOException:<init>	(Ljava/lang/String;)V
    //   1241: athrow
    //   1242: aload_0
    //   1243: aload 17
    //   1245: aconst_null
    //   1246: aload_3
    //   1247: invokevirtual 606	bapk:a	(Lorg/apache/http/HttpResponse;Ljava/lang/String;Lcom/tencent/image/URLDrawableHandler;)V
    //   1250: aload 17
    //   1252: invokeinterface 791 1 0
    //   1257: astore 5
    //   1259: aload_0
    //   1260: aload 5
    //   1262: invokeinterface 797 1 0
    //   1267: aload 5
    //   1269: invokeinterface 800 1 0
    //   1274: aload_1
    //   1275: aload_3
    //   1276: invokespecial 802	bapk:a	(Ljava/io/InputStream;JLjava/io/OutputStream;Lcom/tencent/image/URLDrawableHandler;)V
    //   1279: aload_0
    //   1280: aload_2
    //   1281: iconst_1
    //   1282: aload_2
    //   1283: getfield 564	com/tencent/image/DownloadParams:url	Ljava/net/URL;
    //   1286: aload 13
    //   1288: iconst_1
    //   1289: iload 7
    //   1291: iload 4
    //   1293: aconst_null
    //   1294: invokespecial 718	bapk:a	(Lcom/tencent/image/DownloadParams;ZLjava/net/URL;Lorg/apache/http/protocol/HttpContext;ZIILjava/io/IOException;)V
    //   1297: ldc 122
    //   1299: aload_2
    //   1300: getfield 564	com/tencent/image/DownloadParams:url	Ljava/net/URL;
    //   1303: invokevirtual 585	java/net/URL:getProtocol	()Ljava/lang/String;
    //   1306: invokevirtual 536	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1309: ifeq +26 -> 1335
    //   1312: aload_2
    //   1313: getfield 564	com/tencent/image/DownloadParams:url	Ljava/net/URL;
    //   1316: invokevirtual 422	java/net/URL:getHost	()Ljava/lang/String;
    //   1319: aload_2
    //   1320: getfield 564	com/tencent/image/DownloadParams:url	Ljava/net/URL;
    //   1323: invokevirtual 721	java/net/URL:getPort	()I
    //   1326: iload 7
    //   1328: iload 4
    //   1330: aconst_null
    //   1331: iconst_1
    //   1332: invokestatic 723	bapk:a	(Ljava/lang/String;IIILjava/lang/Exception;Z)V
    //   1335: aload_3
    //   1336: aload 5
    //   1338: invokeinterface 800 1 0
    //   1343: invokeinterface 806 3 0
    //   1348: aload 14
    //   1350: invokevirtual 726	org/apache/http/client/methods/HttpGet:abort	()V
    //   1353: aconst_null
    //   1354: areturn
    //   1355: astore 15
    //   1357: iconst_m1
    //   1358: istore 6
    //   1360: aload 13
    //   1362: astore 5
    //   1364: aconst_null
    //   1365: astore_1
    //   1366: aload 15
    //   1368: astore 13
    //   1370: goto -589 -> 781
    //   1373: astore 15
    //   1375: iconst_1
    //   1376: istore 10
    //   1378: aload 13
    //   1380: astore 5
    //   1382: iconst_1
    //   1383: invokestatic 694	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   1386: astore_1
    //   1387: iload 7
    //   1389: istore 6
    //   1391: aload 15
    //   1393: astore 13
    //   1395: goto -614 -> 781
    //   1398: astore_1
    //   1399: goto -1205 -> 194
    //   1402: goto +25 -> 1427
    //   1405: iconst_0
    //   1406: istore 6
    //   1408: aload 13
    //   1410: astore 15
    //   1412: goto -1018 -> 394
    //   1415: iconst_0
    //   1416: istore 7
    //   1418: goto -1208 -> 210
    //   1421: iconst_1
    //   1422: istore 6
    //   1424: goto -1030 -> 394
    //   1427: iload 6
    //   1429: ifne -573 -> 856
    //   1432: iconst_1
    //   1433: istore 10
    //   1435: goto -752 -> 683
    //   1438: iload 7
    //   1440: sipush 200
    //   1443: if_icmpeq -201 -> 1242
    //   1446: iload 6
    //   1448: ifeq -306 -> 1142
    //   1451: iload 7
    //   1453: sipush 301
    //   1456: if_icmpeq -468 -> 988
    //   1459: iload 7
    //   1461: sipush 302
    //   1464: if_icmpeq -476 -> 988
    //   1467: iload 7
    //   1469: sipush 303
    //   1472: if_icmpeq -484 -> 988
    //   1475: iload 7
    //   1477: sipush 307
    //   1480: if_icmpne -359 -> 1121
    //   1483: goto -495 -> 988
    //   1486: goto -445 -> 1041
    //   1489: astore 15
    //   1491: iconst_1
    //   1492: istore 10
    //   1494: aload 13
    //   1496: astore 5
    //   1498: aconst_null
    //   1499: astore_1
    //   1500: iload 7
    //   1502: istore 6
    //   1504: aload 15
    //   1506: astore 13
    //   1508: goto -727 -> 781
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1511	0	this	bapk
    //   0	1511	1	paramOutputStream	OutputStream
    //   0	1511	2	paramDownloadParams	DownloadParams
    //   0	1511	3	paramURLDrawableHandler	URLDrawableHandler
    //   0	1511	4	paramInt	int
    //   0	1511	5	paramURL	URL
    //   639	864	6	i	int
    //   140	1361	7	j	int
    //   611	24	8	k	int
    //   608	10	9	m	int
    //   4	1489	10	bool1	boolean
    //   9	892	11	bool2	boolean
    //   17	86	12	bool3	boolean
    //   133	394	13	localObject1	Object
    //   542	1	13	localURISyntaxException	java.net.URISyntaxException
    //   603	134	13	localObject2	Object
    //   768	78	13	localIOException1	IOException
    //   868	639	13	localObject3	Object
    //   294	1055	14	localObject4	Object
    //   315	723	15	localObject5	Object
    //   1101	31	15	localException	Exception
    //   1355	12	15	localIOException2	IOException
    //   1373	19	15	localIOException3	IOException
    //   1410	1	15	localObject6	Object
    //   1489	16	15	localIOException4	IOException
    //   1012	52	16	str	String
    //   914	337	17	localHttpResponse	HttpResponse
    // Exception table:
    //   from	to	target	type
    //   213	219	415	java/net/URISyntaxException
    //   228	264	415	java/net/URISyntaxException
    //   264	271	415	java/net/URISyntaxException
    //   276	391	415	java/net/URISyntaxException
    //   394	415	415	java/net/URISyntaxException
    //   474	514	415	java/net/URISyntaxException
    //   514	539	415	java/net/URISyntaxException
    //   544	581	415	java/net/URISyntaxException
    //   584	610	415	java/net/URISyntaxException
    //   620	630	415	java/net/URISyntaxException
    //   644	658	415	java/net/URISyntaxException
    //   658	666	415	java/net/URISyntaxException
    //   671	680	415	java/net/URISyntaxException
    //   683	741	415	java/net/URISyntaxException
    //   849	856	415	java/net/URISyntaxException
    //   1088	1093	415	java/net/URISyntaxException
    //   1164	1169	415	java/net/URISyntaxException
    //   1348	1353	415	java/net/URISyntaxException
    //   460	474	542	java/net/URISyntaxException
    //   741	768	768	java/io/IOException
    //   862	870	768	java/io/IOException
    //   741	768	848	finally
    //   785	845	848	finally
    //   845	848	848	finally
    //   862	870	848	finally
    //   885	900	848	finally
    //   904	916	848	finally
    //   919	933	848	finally
    //   933	939	848	finally
    //   947	985	848	finally
    //   988	1000	848	finally
    //   1005	1021	848	finally
    //   1026	1037	848	finally
    //   1041	1074	848	finally
    //   1074	1088	848	finally
    //   1103	1118	848	finally
    //   1121	1142	848	finally
    //   1142	1164	848	finally
    //   1171	1242	848	finally
    //   1242	1279	848	finally
    //   1279	1335	848	finally
    //   1335	1348	848	finally
    //   1026	1037	1101	java/lang/Exception
    //   885	900	1355	java/io/IOException
    //   904	916	1355	java/io/IOException
    //   919	933	1355	java/io/IOException
    //   1279	1335	1373	java/io/IOException
    //   1335	1348	1373	java/io/IOException
    //   156	194	1398	java/lang/Exception
    //   933	939	1489	java/io/IOException
    //   947	985	1489	java/io/IOException
    //   988	1000	1489	java/io/IOException
    //   1005	1021	1489	java/io/IOException
    //   1026	1037	1489	java/io/IOException
    //   1041	1074	1489	java/io/IOException
    //   1074	1088	1489	java/io/IOException
    //   1103	1118	1489	java/io/IOException
    //   1121	1142	1489	java/io/IOException
    //   1142	1164	1489	java/io/IOException
    //   1171	1242	1489	java/io/IOException
    //   1242	1279	1489	java/io/IOException
  }
  
  public void a()
  {
    this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(true);
  }
  
  protected void a(HttpResponse paramHttpResponse, String paramString, URLDrawableHandler paramURLDrawableHandler) {}
  
  public boolean a()
  {
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bapk
 * JD-Core Version:    0.7.0.1
 */