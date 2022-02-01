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
import java.net.URL;
import java.net.UnknownHostException;
import java.util.HashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import org.jetbrains.annotations.Nullable;

public class bdvl
  extends bdsh
{
  private static boolean b;
  private static boolean c;
  protected AtomicBoolean a;
  protected boolean a;
  
  public bdvl()
  {
    this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean(false);
  }
  
  public bdvl(boolean paramBoolean, Object paramObject)
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
  
  public static void a(int paramInt1, String paramString1, int paramInt2, String paramString2)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put(BaseConstants.RDM_NoChangeFailCode, "");
    localHashMap.put("param_FailCode", String.valueOf(paramInt1));
    localHashMap.put("host", "" + paramString1);
    localHashMap.put("port", "" + paramInt2);
    localHashMap.put("businessType", paramString2);
    bctj.a(BaseApplication.getContext()).a(null, "actHttpsSniSupport", false, 0L, 0L, localHashMap, "");
    if (QLog.isColorLevel()) {
      QLog.e("HttpDownloader", 2, "[reportHttpsSniMethod] reflectOrNot=" + paramInt1 + " host=" + paramString1 + " " + paramInt2);
    }
  }
  
  private void a(DownloadParams paramDownloadParams, boolean paramBoolean1, URL paramURL, boolean paramBoolean2, int paramInt1, int paramInt2, IOException paramIOException)
  {
    int j = 0;
    int i = j;
    if (paramDownloadParams.mHttpDownloaderParams != null)
    {
      i = j;
      if ((paramDownloadParams.mHttpDownloaderParams instanceof bdvo)) {
        i = ((bdvo)paramDownloadParams.mHttpDownloaderParams).jdField_a_of_type_Int;
      }
    }
    QLog.d("HttpDownloader", 1, "f.businessType =  " + i + " success = " + paramBoolean1 + "config.mHttpDownloaderParams =" + paramDownloadParams.mHttpDownloaderParams);
    switch (i)
    {
    default: 
      return;
    }
    a(paramBoolean1, paramURL, paramBoolean2, paramInt1, paramInt2, paramIOException, null);
  }
  
  private void a(InputStream paramInputStream, long paramLong, OutputStream paramOutputStream, URLDrawableHandler paramURLDrawableHandler)
  {
    paramInputStream = new BufferedInputStream(paramInputStream, 4096);
    try
    {
      byte[] arrayOfByte = new byte[4096];
      long l1 = 0L;
      for (;;)
      {
        int i = paramInputStream.read(arrayOfByte);
        if (i == -1) {
          break;
        }
        paramOutputStream.write(arrayOfByte, 0, i);
        long l2 = l1 + i;
        l1 = l2;
        if (AnimationUtils.currentAnimationTimeMillis() - 0L > 100L)
        {
          paramURLDrawableHandler.publishProgress((int)((float)l2 / (float)paramLong * 9500.0F));
          l1 = l2;
        }
      }
    }
    finally
    {
      paramInputStream.close();
    }
    if (this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get()) {
      throw new IOException("cancelled");
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
        break label210;
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
      bctj.a(BaseApplication.getContext()).a(null, "actHttpsDownloadFail", false, paramInt1, paramInt3, localHashMap, "");
      if (QLog.isColorLevel()) {
        QLog.e("HttpDownloader", 2, "[reportHttpsResult] url=" + paramString + " port=" + paramInt1 + " responseCode=" + i + " " + paramInt3);
      }
      return;
      label210:
      paramInt2 += 10000;
    }
  }
  
  public static void a(String paramString, bdvo parambdvo, URLDrawableHandler paramURLDrawableHandler, int paramInt)
  {
    String str;
    if (BaseApplicationImpl.sProcessId == 1)
    {
      str = bdsh.d(paramString);
      if (!new File(str).exists()) {}
    }
    else
    {
      return;
    }
    bdvu localbdvu = ((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime()).getNetEngine(0);
    bdvs localbdvs = new bdvs();
    localbdvs.jdField_a_of_type_Boolean = true;
    localbdvs.e = true;
    localbdvs.jdField_a_of_type_Bdvw = new bdvm(paramURLDrawableHandler, paramString, parambdvo);
    localbdvs.jdField_a_of_type_JavaLangString = paramString;
    localbdvs.jdField_a_of_type_Int = 0;
    localbdvs.c = str;
    localbdvs.d = 2;
    localbdvs.h = parambdvo.jdField_a_of_type_Boolean;
    localbdvu.a(localbdvs);
  }
  
  public static void a(boolean paramBoolean1, URL paramURL, boolean paramBoolean2, int paramInt1, int paramInt2, IOException paramIOException, bdvo parambdvo)
  {
    String str2 = paramURL.toString();
    String str3 = paramURL.getHost();
    String str1 = null;
    int j = 0;
    int i = 0;
    paramURL = "0";
    int m;
    int k;
    Object localObject;
    if (parambdvo != null)
    {
      m = parambdvo.b;
      k = parambdvo.c;
      localObject = parambdvo.jdField_a_of_type_JavaLangString;
      paramURL = (URL)localObject;
      i = k;
      j = m;
      if (parambdvo.jdField_a_of_type_Boolean)
      {
        j = m;
        paramURL = "pre";
      }
    }
    for (;;)
    {
      if (!paramBoolean1)
      {
        try
        {
          InetAddress localInetAddress = InetAddress.getByName(str3);
          parambdvo = str1;
          if (localInetAddress != null) {
            parambdvo = localInetAddress.getHostAddress();
          }
        }
        catch (UnknownHostException parambdvo)
        {
          for (;;)
          {
            int n;
            parambdvo = null;
            continue;
            if (bgjq.a() < 8L)
            {
              paramInt1 = 2;
              i = 1;
              continue;
              paramInt1 = n - m;
              continue;
              throw new NullPointerException();
              paramIOException = null;
            }
            else
            {
              paramInt1 = 0;
              i = 0;
            }
          }
        }
        n = paramInt1 * 10000;
        if (paramInt1 == 200) {
          if (!bgjq.a())
          {
            paramInt1 = 1;
            i = 1;
            m = paramInt1;
            if (paramIOException != null)
            {
              str1 = paramIOException.getMessage();
              m = paramInt1;
              paramURL = str1;
              if (i == 0)
              {
                m = a(paramInt1, paramIOException, paramBoolean2);
                paramURL = str1;
              }
            }
            if (n < 0) {
              break label456;
            }
            paramInt1 = m + n;
          }
        }
      }
      for (paramIOException = parambdvo;; paramIOException = null)
      {
        parambdvo = new HashMap();
        parambdvo.put("param_FailCode", String.valueOf(paramInt1));
        parambdvo.put("param_Url", str2);
        parambdvo.put("serviceId", String.valueOf(j));
        parambdvo.put("templateId", String.valueOf(k));
        parambdvo.put("param_RetryCount", String.valueOf(paramInt2));
        parambdvo.put("param_Host", str3);
        parambdvo.put("param_Address", paramIOException);
        parambdvo.put("param_First_Direct_Host", null);
        parambdvo.put("param_First_Direct_Address", null);
        parambdvo.put("param_Last_Direct_Host", null);
        parambdvo.put("param_Last_Direct_Address", null);
        if (0 == 0)
        {
          parambdvo.put("param_DirectList", "");
          if (0 != 0) {
            break label473;
          }
          paramIOException = "";
          parambdvo.put("param_LastDirectUrl", paramIOException);
          parambdvo.put("param_ErrDesc", paramURL);
          parambdvo.put("uintype", localObject);
          if (QLog.isDevelopLevel()) {
            QLog.d("HttpDownloader", 4, "f =  " + parambdvo.toString());
          }
          bctj.a(BaseApplication.getContext()).a(null, "StructMsgPicDown", paramBoolean1, 0L, 0L, parambdvo, null);
        }
        label456:
        label473:
        paramInt1 = 0;
      }
      localObject = paramURL;
      paramURL = null;
      k = i;
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
  
  public File a(OutputStream paramOutputStream, DownloadParams paramDownloadParams, URLDrawableHandler paramURLDrawableHandler, int paramInt, URL paramURL)
  {
    boolean bool1 = paramDownloadParams.needCheckNetType;
    boolean bool2 = bdzx.a();
    boolean bool3 = bdzx.b(BaseApplicationImpl.getContext());
    if (QLog.isColorLevel()) {
      QLog.i("HttpDownloader", 2, " downloadImage url = " + paramDownloadParams.url.toString() + " needCheckNetType:" + bool1 + " isMobileNet:" + bool2 + "isAutoDownloadAbled:" + bool3);
    }
    if ((paramDownloadParams.needCheckNetType) && (bool2) && (!bool3)) {}
    do
    {
      do
      {
        return null;
      } while (a(paramDownloadParams, paramURLDrawableHandler));
      paramURLDrawableHandler.onFileDownloadStarted();
      paramURL = new bdvs();
      paramURL.jdField_a_of_type_JavaLangString = paramDownloadParams.url.toString();
      paramURL.jdField_a_of_type_Int = 0;
      paramURL.jdField_a_of_type_Boolean = this.jdField_a_of_type_Boolean;
      paramURL.jdField_a_of_type_JavaIoOutputStream = paramOutputStream;
      paramURL.b = paramDownloadParams.retryCount;
      paramURL.jdField_a_of_type_Bdvw = new bdvn(this, paramURLDrawableHandler);
      paramOutputStream = bdwv.a(paramURL);
      a(paramOutputStream, paramURLDrawableHandler);
      if (paramOutputStream != null) {
        QLog.i("HttpDownloader", 1, " resp.mResult = " + paramOutputStream.jdField_a_of_type_Int + " , resp.mErrCode = " + paramOutputStream.b + " , resp.mErrDesc = " + paramOutputStream.jdField_a_of_type_JavaLangString);
      }
      if (paramOutputStream.jdField_a_of_type_Int != 0) {
        break;
      }
    } while (paramURLDrawableHandler == null);
    paramURLDrawableHandler.onFileDownloadSucceed(paramOutputStream.jdField_a_of_type_Long);
    return null;
    if (paramURLDrawableHandler != null) {
      paramURLDrawableHandler.onFileDownloadFailed(paramOutputStream.c);
    }
    throw new IOException(paramOutputStream.jdField_a_of_type_JavaLangString);
  }
  
  @Nullable
  protected File a(OutputStream paramOutputStream, DownloadParams paramDownloadParams, URLDrawableHandler paramURLDrawableHandler, int paramInt1, boolean paramBoolean, int paramInt2, InputStream paramInputStream, long paramLong)
  {
    a(paramInputStream, paramLong, paramOutputStream, paramURLDrawableHandler);
    a(paramDownloadParams, true, paramDownloadParams.url, paramBoolean, paramInt2, paramInt1, null);
    if ("https".equals(paramDownloadParams.url.getProtocol())) {
      a(paramDownloadParams.url.getHost(), paramDownloadParams.url.getPort(), paramInt2, paramInt1, null, paramBoolean);
    }
    paramURLDrawableHandler.onFileDownloadSucceed(paramLong);
    return null;
  }
  
  public void a()
  {
    this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(true);
  }
  
  public void a(bdwt parambdwt, URLDrawableHandler paramURLDrawableHandler) {}
  
  protected void a(DownloadParams paramDownloadParams, int paramInt1, boolean paramBoolean, int paramInt2, IOException paramIOException)
  {
    a(paramDownloadParams, false, paramDownloadParams.url, paramBoolean, paramInt2, paramInt1, paramIOException);
    if ("https".equals(paramDownloadParams.url.getProtocol())) {
      a(paramDownloadParams.url.getHost(), paramDownloadParams.url.getPort(), paramInt2, paramInt1, paramIOException, paramBoolean);
    }
  }
  
  public boolean a()
  {
    return true;
  }
  
  public boolean a(DownloadParams paramDownloadParams, URLDrawableHandler paramURLDrawableHandler)
  {
    bdvo localbdvo;
    if ((paramDownloadParams.mHttpDownloaderParams != null) && ((paramDownloadParams.mHttpDownloaderParams instanceof bdvo)))
    {
      localbdvo = (bdvo)paramDownloadParams.mHttpDownloaderParams;
      if ((localbdvo.jdField_a_of_type_Int != 1001) || (!ayyp.jdField_a_of_type_Boolean)) {}
    }
    try
    {
      if (QLog.isColorLevel()) {
        QLog.i("HttpDownloader", 2, " structMsgCover download downloadImageByHttpEngine url = " + paramDownloadParams.url.toString());
      }
      label79:
      a(paramDownloadParams.url.toString(), localbdvo, paramURLDrawableHandler, 0);
      return true;
      return false;
    }
    catch (Exception localException)
    {
      break label79;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bdvl
 * JD-Core Version:    0.7.0.1
 */