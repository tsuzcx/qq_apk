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

public class ayrn
  extends ayog
{
  private static ayrq jdField_a_of_type_Ayrq = ;
  private static boolean b;
  private static boolean c;
  AtomicBoolean jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean(false);
  private boolean jdField_a_of_type_Boolean;
  
  public ayrn() {}
  
  public ayrn(boolean paramBoolean, Object paramObject)
  {
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
  
  private static ayrq a()
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
      localObject1 = new ayrq(new ThreadSafeClientConnManager((HttpParams)localObject2, (SchemeRegistry)localObject1), (HttpParams)localObject2);
      ((ayrq)localObject1).setRedirectHandler(new ayrp());
      return localObject1;
      ((SchemeRegistry)localObject1).register(new Scheme("https", new ayvs(ayrn.class.getSimpleName()), 443));
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
    axrl.a(BaseApplication.getContext()).a(null, "actHttpsSniSupport", false, 0L, 0L, localHashMap, "");
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
      if ((paramDownloadParams.mHttpDownloaderParams instanceof ayrr))
      {
        j = ((ayrr)paramDownloadParams.mHttpDownloaderParams).jdField_a_of_type_Int;
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
      axrl.a(BaseApplication.getContext()).a(null, "actHttpsDownloadFail", false, paramInt1, paramInt3, localHashMap, "");
      if (QLog.isColorLevel()) {
        QLog.e("HttpDownloader", 2, "[reportHttpsResult] url=" + paramString + " port=" + paramInt1 + " responseCode=" + i + " " + paramInt3);
      }
      return;
      label218:
      paramInt2 += 10000;
    }
  }
  
  public static void a(String paramString, ayrr paramayrr, URLDrawableHandler paramURLDrawableHandler, int paramInt)
  {
    String str;
    if (BaseApplicationImpl.sProcessId == 1)
    {
      str = ayog.d(paramString);
      if (!new File(str).exists()) {}
    }
    else
    {
      return;
    }
    ayry localayry = ((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime()).getNetEngine(0);
    ayrv localayrv = new ayrv();
    localayrv.jdField_a_of_type_Boolean = true;
    localayrv.jdField_e_of_type_Boolean = true;
    localayrv.jdField_a_of_type_Aysa = new ayro(paramURLDrawableHandler, paramString, paramayrr);
    localayrv.jdField_a_of_type_JavaLangString = paramString;
    localayrv.jdField_a_of_type_Int = 0;
    localayrv.c = str;
    localayrv.jdField_e_of_type_Int = 2;
    localayrv.h = paramayrr.jdField_a_of_type_Boolean;
    localayry.a(localayrv);
  }
  
  public static void a(boolean paramBoolean1, URL paramURL, HttpContext paramHttpContext, boolean paramBoolean2, int paramInt1, int paramInt2, IOException paramIOException, ayrr paramayrr)
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
    if (paramayrr != null)
    {
      j = paramayrr.b;
      i = paramayrr.c;
      paramURL = paramayrr.jdField_a_of_type_JavaLangString;
      paramHttpContext = paramURL;
      k = i;
      m = j;
      if (!paramayrr.jdField_a_of_type_Boolean) {
        break label895;
      }
      localObject6 = "pre";
      localObject4 = null;
      localObject5 = null;
      localObject2 = null;
      paramayrr = paramURL;
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
          if (!bbay.a())
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
            ((HashMap)localObject8).put("uintype", paramayrr);
            if (QLog.isDevelopLevel()) {
              QLog.d("HttpDownloader", 4, "f =  " + ((HashMap)localObject8).toString());
            }
            axrl.a(BaseApplication.getContext()).a(null, "StructMsgPicDown", paramBoolean1, 0L, 0L, (HashMap)localObject8, null);
            return;
            if (paramHttpContext == null) {
              break label941;
            }
            paramURL = paramHttpContext.getAttribute("mobileqq_report_extra");
            if ((paramURL == null) || (!(paramURL instanceof ayrr))) {
              break label928;
            }
            paramURL = (ayrr)paramURL;
            j = paramURL.b;
            i = paramURL.c;
          }
        }
      }
      for (paramURL = paramURL.jdField_a_of_type_JavaLangString;; paramURL = "0")
      {
        paramayrr = paramHttpContext.getAttribute("mobileqq_direct_uri");
        paramHttpContext = paramURL;
        k = i;
        m = j;
        if (paramayrr != null)
        {
          paramHttpContext = paramURL;
          k = i;
          m = j;
          if ((paramayrr instanceof List))
          {
            List localList = (List)paramayrr;
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
                paramayrr = (ayrr)localObject5;
                if (localObject6 != null) {
                  paramayrr = ((InetAddress)localObject6).getHostAddress();
                }
              }
              catch (UnknownHostException paramayrr)
              {
                for (;;)
                {
                  paramayrr = (ayrr)localObject5;
                }
              }
              if (paramayrr != null) {
                localStringBuilder.append(paramayrr);
              }
              localStringBuilder.append("|");
              if (k == 0)
              {
                localObject5 = localURI.getHost();
                localObject6 = paramayrr;
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
                localObject4 = paramayrr;
                localObject6 = localObject3;
                localObject5 = localObject1;
                break label686;
                if (bbay.a() < 8L)
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
            paramayrr = paramURL;
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
        paramayrr = paramHttpContext;
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
      paramayrr = "0";
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
    //   6: invokestatic 555	aywk:a	()Z
    //   9: istore 11
    //   11: invokestatic 556	com/tencent/common/app/BaseApplicationImpl:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   14: invokestatic 559	aywk:b	(Landroid/content/Context;)Z
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
    //   113: ifnull +1283 -> 1396
    //   116: aload_2
    //   117: getfield 266	com/tencent/image/DownloadParams:mHttpDownloaderParams	Ljava/lang/Object;
    //   120: instanceof 268
    //   123: ifeq +1273 -> 1396
    //   126: aload_2
    //   127: getfield 266	com/tencent/image/DownloadParams:mHttpDownloaderParams	Ljava/lang/Object;
    //   130: checkcast 268	ayrr
    //   133: astore 13
    //   135: aload 13
    //   137: getfield 270	ayrr:jdField_a_of_type_Int	I
    //   140: istore 7
    //   142: iload 7
    //   144: sipush 1001
    //   147: if_icmpne +63 -> 210
    //   150: getstatic 576	auok:jdField_a_of_type_Boolean	Z
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
    //   205: invokestatic 580	ayrn:a	(Ljava/lang/String;Layrr;Lcom/tencent/image/URLDrawableHandler;I)V
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
    //   265: getfield 31	ayrn:jdField_a_of_type_Boolean	Z
    //   268: ifeq +1118 -> 1386
    //   271: iload 4
    //   273: ifne +1113 -> 1386
    //   276: ldc 85
    //   278: aload 13
    //   280: invokevirtual 585	java/net/URL:getProtocol	()Ljava/lang/String;
    //   283: invokevirtual 536	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   286: ifeq +1100 -> 1386
    //   289: aload 13
    //   291: invokevirtual 422	java/net/URL:getHost	()Ljava/lang/String;
    //   294: astore 14
    //   296: aload 14
    //   298: invokestatic 590	bbjw:a	(Ljava/lang/String;)Z
    //   301: ifne +1085 -> 1386
    //   304: invokestatic 595	ayxe:a	()Layxe;
    //   307: aload 14
    //   309: sipush 1010
    //   312: invokevirtual 598	ayxe:a	(Ljava/lang/String;I)Ljava/lang/String;
    //   315: astore 15
    //   317: aload 14
    //   319: aload 15
    //   321: invokevirtual 536	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   324: ifne +1062 -> 1386
    //   327: aload 15
    //   329: invokestatic 590	bbjw:a	(Ljava/lang/String;)Z
    //   332: ifne +1054 -> 1386
    //   335: aload 13
    //   337: invokevirtual 419	java/net/URL:toString	()Ljava/lang/String;
    //   340: aload 15
    //   342: invokestatic 599	ayxe:a	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   345: astore 13
    //   347: new 418	java/net/URL
    //   350: dup
    //   351: aload 13
    //   353: invokespecial 600	java/net/URL:<init>	(Ljava/lang/String;)V
    //   356: astore 15
    //   358: invokestatic 183	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   361: ifeq +1041 -> 1402
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
    //   391: goto +1011 -> 1402
    //   394: aload_0
    //   395: getfield 28	ayrn:jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean	Ljava/util/concurrent/atomic/AtomicBoolean;
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
    //   423: invokevirtual 606	ayrn:a	(Lorg/apache/http/HttpResponse;Ljava/lang/String;Lcom/tencent/image/URLDrawableHandler;)V
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
    //   481: getstatic 17	ayrn:jdField_a_of_type_Ayrq	Layrq;
    //   484: invokevirtual 628	ayrq:getCookieSpecs	()Lorg/apache/http/cookie/CookieSpecRegistry;
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
    //   658: getstatic 17	ayrn:jdField_a_of_type_Ayrq	Layrq;
    //   661: invokevirtual 687	ayrq:getParams	()Lorg/apache/http/params/HttpParams;
    //   664: astore 13
    //   666: aload 13
    //   668: ifnonnull +715 -> 1383
    //   671: new 124	org/apache/http/params/BasicHttpParams
    //   674: dup
    //   675: invokespecial 125	org/apache/http/params/BasicHttpParams:<init>	()V
    //   678: astore 13
    //   680: goto +728 -> 1408
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
    //   733: getstatic 17	ayrn:jdField_a_of_type_Ayrq	Layrq;
    //   736: aload 13
    //   738: invokevirtual 713	ayrq:setParams	(Lorg/apache/http/params/HttpParams;)V
    //   741: aload_3
    //   742: invokeinterface 716 1 0
    //   747: aload_0
    //   748: getfield 28	ayrn:jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean	Ljava/util/concurrent/atomic/AtomicBoolean;
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
    //   802: invokespecial 718	ayrn:a	(Lcom/tencent/image/DownloadParams;ZLjava/net/URL;Lorg/apache/http/protocol/HttpContext;ZIILjava/io/IOException;)V
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
    //   842: invokestatic 723	ayrn:a	(Ljava/lang/String;IIILjava/lang/Exception;Z)V
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
    //   862: getstatic 17	ayrn:jdField_a_of_type_Ayrq	Layrq;
    //   865: invokevirtual 730	ayrq:createHttpContext	()Lorg/apache/http/protocol/HttpContext;
    //   868: astore 13
    //   870: iload 7
    //   872: sipush 1001
    //   875: if_icmpne +201 -> 1076
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
    //   904: getstatic 17	ayrn:jdField_a_of_type_Ayrq	Layrq;
    //   907: aload 14
    //   909: aload 13
    //   911: invokevirtual 736	ayrq:execute	(Lorg/apache/http/client/methods/HttpUriRequest;Lorg/apache/http/protocol/HttpContext;)Lorg/apache/http/HttpResponse;
    //   914: astore 17
    //   916: iconst_1
    //   917: istore 10
    //   919: aload 17
    //   921: invokeinterface 742 1 0
    //   926: invokeinterface 747 1 0
    //   931: istore 7
    //   933: invokestatic 183	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   936: ifeq +483 -> 1419
    //   939: ldc 250
    //   941: iconst_2
    //   942: new 217	java/lang/StringBuilder
    //   945: dup
    //   946: invokespecial 218	java/lang/StringBuilder:<init>	()V
    //   949: ldc_w 749
    //   952: invokevirtual 222	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   955: iload 7
    //   957: invokevirtual 230	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   960: invokevirtual 225	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   963: invokestatic 259	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   966: goto +453 -> 1419
    //   969: aload 17
    //   971: ldc_w 751
    //   974: invokeinterface 755 2 0
    //   979: astore 15
    //   981: aload 15
    //   983: ifnull +140 -> 1123
    //   986: aload 15
    //   988: invokeinterface 758 1 0
    //   993: astore 16
    //   995: aload 16
    //   997: invokestatic 763	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   1000: istore 10
    //   1002: iload 10
    //   1004: ifne +119 -> 1123
    //   1007: new 418	java/net/URL
    //   1010: dup
    //   1011: aload 16
    //   1013: invokespecial 600	java/net/URL:<init>	(Ljava/lang/String;)V
    //   1016: astore 15
    //   1018: aload 15
    //   1020: astore 5
    //   1022: invokestatic 183	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1025: ifeq +30 -> 1055
    //   1028: ldc 250
    //   1030: iconst_2
    //   1031: new 217	java/lang/StringBuilder
    //   1034: dup
    //   1035: invokespecial 218	java/lang/StringBuilder:<init>	()V
    //   1038: ldc_w 765
    //   1041: invokevirtual 222	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1044: aload 16
    //   1046: invokevirtual 222	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1049: invokevirtual 225	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1052: invokestatic 259	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   1055: aload_0
    //   1056: aload_1
    //   1057: aload_2
    //   1058: aload_3
    //   1059: iload 4
    //   1061: iconst_1
    //   1062: iadd
    //   1063: aload 5
    //   1065: invokevirtual 547	ayrn:a	(Ljava/io/OutputStream;Lcom/tencent/image/DownloadParams;Lcom/tencent/image/URLDrawableHandler;ILjava/net/URL;)Ljava/io/File;
    //   1068: astore_1
    //   1069: aload 14
    //   1071: invokevirtual 726	org/apache/http/client/methods/HttpGet:abort	()V
    //   1074: aload_1
    //   1075: areturn
    //   1076: iconst_0
    //   1077: istore 7
    //   1079: goto -198 -> 881
    //   1082: astore 15
    //   1084: invokestatic 183	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1087: ifeq +380 -> 1467
    //   1090: ldc 250
    //   1092: iconst_2
    //   1093: ldc_w 767
    //   1096: invokestatic 259	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   1099: goto +368 -> 1467
    //   1102: invokestatic 595	ayxe:a	()Layxe;
    //   1105: aload_2
    //   1106: getfield 564	com/tencent/image/DownloadParams:url	Ljava/net/URL;
    //   1109: invokevirtual 422	java/net/URL:getHost	()Ljava/lang/String;
    //   1112: aload 15
    //   1114: invokevirtual 422	java/net/URL:getHost	()Ljava/lang/String;
    //   1117: sipush 1010
    //   1120: invokevirtual 770	ayxe:a	(Ljava/lang/String;Ljava/lang/String;I)V
    //   1123: iload 4
    //   1125: aload_2
    //   1126: getfield 773	com/tencent/image/DownloadParams:retryCount	I
    //   1129: if_icmpge +23 -> 1152
    //   1132: aload_0
    //   1133: aload_1
    //   1134: aload_2
    //   1135: aload_3
    //   1136: iload 4
    //   1138: iconst_1
    //   1139: iadd
    //   1140: aconst_null
    //   1141: invokevirtual 547	ayrn:a	(Ljava/io/OutputStream;Lcom/tencent/image/DownloadParams;Lcom/tencent/image/URLDrawableHandler;ILjava/net/URL;)Ljava/io/File;
    //   1144: astore_1
    //   1145: aload 14
    //   1147: invokevirtual 726	org/apache/http/client/methods/HttpGet:abort	()V
    //   1150: aload_1
    //   1151: areturn
    //   1152: aload_3
    //   1153: iload 7
    //   1155: invokeinterface 776 2 0
    //   1160: new 52	java/io/IOException
    //   1163: dup
    //   1164: new 217	java/lang/StringBuilder
    //   1167: dup
    //   1168: invokespecial 218	java/lang/StringBuilder:<init>	()V
    //   1171: ldc_w 778
    //   1174: invokevirtual 222	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1177: iload 7
    //   1179: invokevirtual 230	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1182: ldc_w 780
    //   1185: invokevirtual 222	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1188: aload_2
    //   1189: getfield 564	com/tencent/image/DownloadParams:url	Ljava/net/URL;
    //   1192: invokevirtual 293	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   1195: ldc_w 782
    //   1198: invokevirtual 222	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1201: aload 17
    //   1203: invokeinterface 742 1 0
    //   1208: invokeinterface 785 1 0
    //   1213: invokevirtual 222	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1216: invokevirtual 225	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1219: invokespecial 311	java/io/IOException:<init>	(Ljava/lang/String;)V
    //   1222: athrow
    //   1223: aload_0
    //   1224: aload 17
    //   1226: aconst_null
    //   1227: aload_3
    //   1228: invokevirtual 606	ayrn:a	(Lorg/apache/http/HttpResponse;Ljava/lang/String;Lcom/tencent/image/URLDrawableHandler;)V
    //   1231: aload 17
    //   1233: invokeinterface 789 1 0
    //   1238: astore 5
    //   1240: aload_0
    //   1241: aload 5
    //   1243: invokeinterface 795 1 0
    //   1248: aload 5
    //   1250: invokeinterface 798 1 0
    //   1255: aload_1
    //   1256: aload_3
    //   1257: invokespecial 800	ayrn:a	(Ljava/io/InputStream;JLjava/io/OutputStream;Lcom/tencent/image/URLDrawableHandler;)V
    //   1260: aload_0
    //   1261: aload_2
    //   1262: iconst_1
    //   1263: aload_2
    //   1264: getfield 564	com/tencent/image/DownloadParams:url	Ljava/net/URL;
    //   1267: aload 13
    //   1269: iconst_1
    //   1270: iload 7
    //   1272: iload 4
    //   1274: aconst_null
    //   1275: invokespecial 718	ayrn:a	(Lcom/tencent/image/DownloadParams;ZLjava/net/URL;Lorg/apache/http/protocol/HttpContext;ZIILjava/io/IOException;)V
    //   1278: ldc 122
    //   1280: aload_2
    //   1281: getfield 564	com/tencent/image/DownloadParams:url	Ljava/net/URL;
    //   1284: invokevirtual 585	java/net/URL:getProtocol	()Ljava/lang/String;
    //   1287: invokevirtual 536	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1290: ifeq +26 -> 1316
    //   1293: aload_2
    //   1294: getfield 564	com/tencent/image/DownloadParams:url	Ljava/net/URL;
    //   1297: invokevirtual 422	java/net/URL:getHost	()Ljava/lang/String;
    //   1300: aload_2
    //   1301: getfield 564	com/tencent/image/DownloadParams:url	Ljava/net/URL;
    //   1304: invokevirtual 721	java/net/URL:getPort	()I
    //   1307: iload 7
    //   1309: iload 4
    //   1311: aconst_null
    //   1312: iconst_1
    //   1313: invokestatic 723	ayrn:a	(Ljava/lang/String;IIILjava/lang/Exception;Z)V
    //   1316: aload_3
    //   1317: aload 5
    //   1319: invokeinterface 798 1 0
    //   1324: invokeinterface 804 3 0
    //   1329: aload 14
    //   1331: invokevirtual 726	org/apache/http/client/methods/HttpGet:abort	()V
    //   1334: aconst_null
    //   1335: areturn
    //   1336: astore 15
    //   1338: iconst_m1
    //   1339: istore 6
    //   1341: aload 13
    //   1343: astore 5
    //   1345: aconst_null
    //   1346: astore_1
    //   1347: aload 15
    //   1349: astore 13
    //   1351: goto -570 -> 781
    //   1354: astore 15
    //   1356: iconst_1
    //   1357: istore 10
    //   1359: aload 13
    //   1361: astore 5
    //   1363: iconst_1
    //   1364: invokestatic 694	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   1367: astore_1
    //   1368: iload 7
    //   1370: istore 6
    //   1372: aload 15
    //   1374: astore 13
    //   1376: goto -595 -> 781
    //   1379: astore_1
    //   1380: goto -1186 -> 194
    //   1383: goto +25 -> 1408
    //   1386: iconst_0
    //   1387: istore 6
    //   1389: aload 13
    //   1391: astore 15
    //   1393: goto -999 -> 394
    //   1396: iconst_0
    //   1397: istore 7
    //   1399: goto -1189 -> 210
    //   1402: iconst_1
    //   1403: istore 6
    //   1405: goto -1011 -> 394
    //   1408: iload 6
    //   1410: ifne -554 -> 856
    //   1413: iconst_1
    //   1414: istore 10
    //   1416: goto -733 -> 683
    //   1419: iload 7
    //   1421: sipush 200
    //   1424: if_icmpeq -201 -> 1223
    //   1427: iload 6
    //   1429: ifeq -306 -> 1123
    //   1432: iload 7
    //   1434: sipush 301
    //   1437: if_icmpeq -468 -> 969
    //   1440: iload 7
    //   1442: sipush 302
    //   1445: if_icmpeq -476 -> 969
    //   1448: iload 7
    //   1450: sipush 303
    //   1453: if_icmpeq -484 -> 969
    //   1456: iload 7
    //   1458: sipush 307
    //   1461: if_icmpne -359 -> 1102
    //   1464: goto -495 -> 969
    //   1467: goto -445 -> 1022
    //   1470: astore 15
    //   1472: iconst_1
    //   1473: istore 10
    //   1475: aload 13
    //   1477: astore 5
    //   1479: aconst_null
    //   1480: astore_1
    //   1481: iload 7
    //   1483: istore 6
    //   1485: aload 15
    //   1487: astore 13
    //   1489: goto -708 -> 781
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1492	0	this	ayrn
    //   0	1492	1	paramOutputStream	OutputStream
    //   0	1492	2	paramDownloadParams	DownloadParams
    //   0	1492	3	paramURLDrawableHandler	URLDrawableHandler
    //   0	1492	4	paramInt	int
    //   0	1492	5	paramURL	URL
    //   639	845	6	i	int
    //   140	1342	7	j	int
    //   611	24	8	k	int
    //   608	10	9	m	int
    //   4	1470	10	bool1	boolean
    //   9	892	11	bool2	boolean
    //   17	86	12	bool3	boolean
    //   133	394	13	localObject1	Object
    //   542	1	13	localURISyntaxException	java.net.URISyntaxException
    //   603	134	13	localObject2	Object
    //   768	78	13	localIOException1	IOException
    //   868	620	13	localObject3	Object
    //   294	1036	14	localObject4	Object
    //   315	704	15	localObject5	Object
    //   1082	31	15	localException	Exception
    //   1336	12	15	localIOException2	IOException
    //   1354	19	15	localIOException3	IOException
    //   1391	1	15	localObject6	Object
    //   1470	16	15	localIOException4	IOException
    //   993	52	16	str	String
    //   914	318	17	localHttpResponse	HttpResponse
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
    //   1069	1074	415	java/net/URISyntaxException
    //   1145	1150	415	java/net/URISyntaxException
    //   1329	1334	415	java/net/URISyntaxException
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
    //   933	966	848	finally
    //   969	981	848	finally
    //   986	1002	848	finally
    //   1007	1018	848	finally
    //   1022	1055	848	finally
    //   1055	1069	848	finally
    //   1084	1099	848	finally
    //   1102	1123	848	finally
    //   1123	1145	848	finally
    //   1152	1223	848	finally
    //   1223	1260	848	finally
    //   1260	1316	848	finally
    //   1316	1329	848	finally
    //   1007	1018	1082	java/lang/Exception
    //   885	900	1336	java/io/IOException
    //   904	916	1336	java/io/IOException
    //   919	933	1336	java/io/IOException
    //   1260	1316	1354	java/io/IOException
    //   1316	1329	1354	java/io/IOException
    //   156	194	1379	java/lang/Exception
    //   933	966	1470	java/io/IOException
    //   969	981	1470	java/io/IOException
    //   986	1002	1470	java/io/IOException
    //   1007	1018	1470	java/io/IOException
    //   1022	1055	1470	java/io/IOException
    //   1055	1069	1470	java/io/IOException
    //   1084	1099	1470	java/io/IOException
    //   1102	1123	1470	java/io/IOException
    //   1123	1145	1470	java/io/IOException
    //   1152	1223	1470	java/io/IOException
    //   1223	1260	1470	java/io/IOException
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     ayrn
 * JD-Core Version:    0.7.0.1
 */