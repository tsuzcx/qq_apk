package com.tencent.mobileqq.apollo.store.webview;

import android.net.Uri;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.widget.Toast;
import com.tencent.biz.pubaccount.CustomWebView;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.qphone.base.util.QLog;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.InputStream;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.os.MqqHandler;
import zbh;
import zbi;
import zbj;
import zbk;
import zbm;

public class ApolloUrlInterceptor
  implements Handler.Callback, BridgeStream.IBridgeStreamCallback
{
  public static String a;
  private static long jdField_b_of_type_Long = new Random().nextInt(263167);
  public final long a;
  private final Handler jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper(), this);
  private Message jdField_a_of_type_AndroidOsMessage;
  private volatile CustomWebView jdField_a_of_type_ComTencentBizPubaccountCustomWebView;
  private ApolloWebStatistics jdField_a_of_type_ComTencentMobileqqApolloStoreWebviewApolloWebStatistics = new ApolloWebStatistics();
  private volatile InputStream jdField_a_of_type_JavaIoInputStream;
  private final AtomicBoolean jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean(false);
  private final AtomicInteger jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger = new AtomicInteger(0);
  private volatile zbk jdField_a_of_type_Zbk;
  private volatile boolean jdField_a_of_type_Boolean;
  public final String b;
  private final AtomicBoolean jdField_b_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean(false);
  private boolean jdField_b_of_type_Boolean = true;
  private final String jdField_c_of_type_JavaLangString;
  private final AtomicBoolean jdField_c_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean(false);
  private boolean jdField_c_of_type_Boolean;
  private String jdField_d_of_type_JavaLangString;
  private final AtomicBoolean jdField_d_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean(false);
  private boolean jdField_d_of_type_Boolean;
  private String jdField_e_of_type_JavaLangString;
  private final AtomicBoolean jdField_e_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean(false);
  private String jdField_f_of_type_JavaLangString;
  private final AtomicBoolean jdField_f_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean(false);
  private String jdField_g_of_type_JavaLangString;
  private final AtomicBoolean jdField_g_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean(false);
  
  static
  {
    jdField_a_of_type_JavaLangString = "当前网络不可用，请检查你的网络设置";
  }
  
  public ApolloUrlInterceptor(String paramString1, String paramString2, String paramString3)
  {
    this.jdField_c_of_type_JavaLangString = paramString3;
    this.jdField_b_of_type_JavaLangString = paramString1;
    long l = jdField_b_of_type_Long;
    jdField_b_of_type_Long = 1L + l;
    this.jdField_a_of_type_Long = l;
    this.jdField_d_of_type_JavaLangString = ApolloClientUtil.a(paramString2, "session_id", String.valueOf(this.jdField_a_of_type_Long));
    this.jdField_e_of_type_JavaLangString = this.jdField_d_of_type_JavaLangString;
    if (QLog.isColorLevel()) {
      QLog.d("apollo_client_ApolloUrlInterceptor", 2, "session(" + this.jdField_a_of_type_Long + ") create:id=" + paramString1 + ", url = " + paramString2);
    }
  }
  
  public static ApolloUrlInterceptor a(boolean paramBoolean, String paramString)
  {
    long l = System.currentTimeMillis();
    if (!TextUtils.isEmpty(paramString))
    {
      String str = ApolloWebDataHandler.a().a(paramString);
      if (ApolloWebDataHandler.a().a(str))
      {
        paramString = new ApolloUrlInterceptor(paramString, paramString, str);
        if (QLog.isColorLevel()) {
          QLog.d("apollo_client_ApolloUrlInterceptor", 2, "createInterceptor startSessionNewThread:" + paramBoolean + ",use:" + (System.currentTimeMillis() - l));
        }
        paramString.a(paramBoolean);
        return paramString;
      }
    }
    return null;
  }
  
  private boolean a(int paramInt1, int paramInt2, boolean paramBoolean)
  {
    if (this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.compareAndSet(paramInt1, paramInt2))
    {
      if (paramBoolean) {
        synchronized (this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger)
        {
          this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.notify();
        }
      }
    }
    else {
      return false;
    }
    return true;
  }
  
  private void b()
  {
    long l = System.currentTimeMillis();
    AppInterface localAppInterface = (AppInterface)MobileQQ.sMobileQQ.waitAppRuntime(null).getAppRuntime("modular_web");
    if ((localAppInterface != null) && (!TextUtils.isEmpty(this.jdField_c_of_type_JavaLangString))) {
      ApolloWebDataHandler.a().a(BaseApplicationImpl.getContext(), this.jdField_c_of_type_JavaLangString, this.jdField_e_of_type_JavaLangString, localAppInterface, this.jdField_a_of_type_ComTencentMobileqqApolloStoreWebviewApolloWebStatistics);
    }
    if (QLog.isColorLevel()) {
      QLog.d("apollo_client_ApolloUrlInterceptor", 2, "preloadSSOData use:" + (System.currentTimeMillis() - l));
    }
  }
  
  private void b(boolean paramBoolean)
  {
    int i = this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.get();
    if (3 != i)
    {
      this.jdField_a_of_type_ComTencentBizPubaccountCustomWebView = null;
      this.jdField_a_of_type_JavaIoInputStream = null;
      this.jdField_g_of_type_JavaLangString = null;
      if (this.jdField_a_of_type_AndroidOsMessage != null) {
        this.jdField_a_of_type_AndroidOsMessage = null;
      }
      if ((!paramBoolean) && (!c())) {
        break label183;
      }
      if ((this.jdField_a_of_type_Zbk != null) && (!paramBoolean))
      {
        this.jdField_a_of_type_Zbk.a();
        this.jdField_a_of_type_Zbk = null;
      }
      this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.set(3);
    }
    label183:
    do
    {
      do
      {
        synchronized (this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger)
        {
          this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.notify();
          this.jdField_a_of_type_AndroidOsHandler.removeMessages(10);
          this.jdField_f_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(false);
          if (QLog.isColorLevel()) {
            QLog.d("apollo_client_ApolloUrlInterceptor", 2, "session(" + this.jdField_a_of_type_Long + ") final destroy, force=" + paramBoolean + ".");
          }
          this.jdField_a_of_type_AndroidOsHandler.removeMessages(255);
          return;
        }
        this.jdField_a_of_type_AndroidOsHandler.removeMessages(255);
      } while (!this.jdField_f_of_type_JavaUtilConcurrentAtomicAtomicBoolean.compareAndSet(false, true));
      this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(10, 6000L);
    } while (!QLog.isColorLevel());
    QLog.d("apollo_client_ApolloUrlInterceptor", 2, "session(" + this.jdField_a_of_type_Long + ") waiting for destroy, current state =" + i + ".");
  }
  
  private boolean b()
  {
    return (3 == this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.get()) || (this.jdField_f_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get());
  }
  
  private void c()
  {
    ThreadManager.postImmediately(new zbh(this), null, true);
  }
  
  private boolean c()
  {
    if ((this.jdField_g_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get()) || (this.jdField_e_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get()))
    {
      if (QLog.isColorLevel()) {
        QLog.d("apollo_client_ApolloUrlInterceptor", 2, "session(" + this.jdField_a_of_type_Long + ") canDestroy:false, isWaitingForSessionThread=" + this.jdField_g_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get() + ", isWaitingForBlinkCloseStream=" + this.jdField_e_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get() + " isWaitingForDestroy:" + this.jdField_f_of_type_JavaUtilConcurrentAtomicAtomicBoolean);
      }
      return false;
    }
    return true;
  }
  
  private void d()
  {
    if (1 != this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.get())
    {
      if (QLog.isColorLevel()) {
        QLog.d("apollo_client_ApolloUrlInterceptor", 2, "session(" + this.jdField_a_of_type_Long + ") runSonicFlow error:sessionState=" + this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.get() + ".");
      }
      this.jdField_c_of_type_Boolean = true;
      this.jdField_g_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(false);
      this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(3);
      return;
    }
    this.jdField_a_of_type_AndroidOsHandler.removeMessages(255);
    long l1 = System.currentTimeMillis();
    this.jdField_f_of_type_JavaLangString = ApolloClientUtil.e(this.jdField_e_of_type_JavaLangString);
    if (TextUtils.isEmpty(this.jdField_f_of_type_JavaLangString))
    {
      if (QLog.isColorLevel()) {
        QLog.d("apollo_client_ApolloUrlInterceptor", 2, "session(" + this.jdField_a_of_type_Long + ") runSonicFlow error:fileName is null");
      }
      this.jdField_c_of_type_Boolean = true;
      this.jdField_g_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(false);
      this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(3);
      return;
    }
    Object localObject1 = ApolloClientUtil.d(this.jdField_f_of_type_JavaLangString);
    if (QLog.isColorLevel()) {
      QLog.d("apollo_client_ApolloUrlInterceptor", 2, "session(" + this.jdField_a_of_type_Long + ") runSonicFlow url is " + this.jdField_e_of_type_JavaLangString + " filePath is " + (String)localObject1);
    }
    Object localObject2 = new File((String)localObject1);
    localObject1 = ApolloClientUtil.a((File)localObject2);
    this.jdField_a_of_type_ComTencentMobileqqApolloStoreWebviewApolloWebStatistics.e = (System.currentTimeMillis() - l1);
    boolean bool1;
    label296:
    boolean bool2;
    if (!TextUtils.isEmpty((CharSequence)localObject1))
    {
      bool1 = true;
      if (!bool1) {
        break label663;
      }
      long l2 = System.currentTimeMillis();
      if (ApolloWebDataHandler.a().a(this.jdField_c_of_type_JavaLangString, (String)localObject1)) {
        break label652;
      }
      localObject1 = null;
      ((File)localObject2).delete();
      if (QLog.isColorLevel()) {
        QLog.d("apollo_client_ApolloUrlInterceptor", 2, "session(" + this.jdField_a_of_type_Long + ") runSonicFlow md5 not match delete localFile! url is " + this.jdField_e_of_type_JavaLangString);
      }
      this.jdField_a_of_type_ComTencentMobileqqApolloStoreWebviewApolloWebStatistics.a = 1;
      bool1 = false;
      label387:
      this.jdField_a_of_type_ComTencentMobileqqApolloStoreWebviewApolloWebStatistics.f = (System.currentTimeMillis() - l2);
      localObject2 = localObject1;
      bool2 = bool1;
      if (QLog.isColorLevel())
      {
        QLog.d("apollo_client_ApolloUrlInterceptor", 2, "verify use:" + (System.currentTimeMillis() - l2));
        bool2 = bool1;
        localObject2 = localObject1;
      }
      label451:
      if (QLog.isColorLevel()) {
        QLog.d("apollo_client_ApolloUrlInterceptor", 2, "get LocalFile use:" + (System.currentTimeMillis() - l1));
      }
      localObject1 = this.jdField_a_of_type_AndroidOsHandler.obtainMessage(1);
      this.jdField_a_of_type_AndroidOsMessage = ((Message)localObject1);
      if (!bool2) {
        break label682;
      }
      ((Message)localObject1).arg1 = 2;
      ((Message)localObject1).obj = localObject2;
      this.jdField_a_of_type_AndroidOsHandler.sendMessage((Message)localObject1);
      if (QLog.isColorLevel()) {
        QLog.d("apollo_client_ApolloUrlInterceptor", 2, "session(" + this.jdField_a_of_type_Long + ") runSonicFlow hasHtmlCache:" + bool2);
      }
      this.jdField_g_of_type_JavaLangString = ((String)localObject2);
    }
    for (;;)
    {
      a(1, 2, true);
      this.jdField_g_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(false);
      if ((!d()) || (!QLog.isColorLevel())) {
        break;
      }
      QLog.d("apollo_client_ApolloUrlInterceptor", 4, "session(" + this.jdField_a_of_type_Long + ") runSonicFlow:send force destroy message.");
      return;
      bool1 = false;
      break label296;
      label652:
      this.jdField_a_of_type_ComTencentMobileqqApolloStoreWebviewApolloWebStatistics.a = 2;
      break label387;
      label663:
      this.jdField_a_of_type_ComTencentMobileqqApolloStoreWebviewApolloWebStatistics.a = 0;
      localObject2 = localObject1;
      bool2 = bool1;
      break label451;
      label682:
      if (QLog.isColorLevel()) {
        QLog.d("apollo_client_ApolloUrlInterceptor", 2, "session(" + this.jdField_a_of_type_Long + ") runSonicFlow has no cache, do first load flow.");
      }
      ((Message)localObject1).arg1 = 1;
      this.jdField_a_of_type_AndroidOsHandler.sendMessage((Message)localObject1);
      if (!NetworkUtil.g(BaseApplicationImpl.getContext()))
      {
        if (!TextUtils.isEmpty(jdField_a_of_type_JavaLangString)) {
          this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(255, 1500L);
        }
        if (QLog.isColorLevel()) {
          QLog.d("apollo_client_ApolloUrlInterceptor", 1, "session(" + this.jdField_a_of_type_Long + ") runSonicFlow error:network is not valid!");
        }
      }
      else
      {
        e();
      }
    }
  }
  
  private boolean d()
  {
    if ((this.jdField_f_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get()) && (c()))
    {
      this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(10);
      return true;
    }
    return false;
  }
  
  private void e()
  {
    long l1 = System.currentTimeMillis();
    this.jdField_a_of_type_Zbk = new zbk(this.jdField_e_of_type_JavaLangString, false);
    long l2 = System.currentTimeMillis();
    int j = this.jdField_a_of_type_Zbk.a();
    int i = j;
    Map localMap;
    Object localObject;
    if (j == 0)
    {
      if (QLog.isColorLevel()) {
        QLog.d("apollo_client_ApolloUrlInterceptor", 2, "session(" + this.jdField_a_of_type_Long + ") connection connect cost = " + (System.currentTimeMillis() - l2) + " ms.");
      }
      l2 = System.currentTimeMillis();
      i = this.jdField_a_of_type_Zbk.b();
      if (QLog.isColorLevel()) {
        QLog.d("apollo_client_ApolloUrlInterceptor", 2, "session(" + this.jdField_a_of_type_Long + ") connection response cost = " + (System.currentTimeMillis() - l2) + " ms.");
      }
      l2 = System.currentTimeMillis();
      localMap = this.jdField_a_of_type_Zbk.a();
      if (QLog.isColorLevel()) {
        QLog.d("apollo_client_ApolloUrlInterceptor", 2, "session(" + this.jdField_a_of_type_Long + ") connection get header fields cost = " + (System.currentTimeMillis() - l2) + " ms.");
      }
      if (localMap != null)
      {
        localObject = null;
        if (!localMap.containsKey("Set-Cookie")) {
          break label402;
        }
        localObject = "Set-Cookie";
      }
    }
    label402:
    do
    {
      for (;;)
      {
        if (!TextUtils.isEmpty((CharSequence)localObject))
        {
          localObject = (List)localMap.get(localObject);
          ApolloClientUtil.a(this.jdField_e_of_type_JavaLangString, (List)localObject);
        }
        if (QLog.isColorLevel()) {
          QLog.d("apollo_client_ApolloUrlInterceptor", 4, "session(" + this.jdField_a_of_type_Long + ") handleFlow_Connection: respCode = " + i + ", cost " + (System.currentTimeMillis() - l1) + " ms.");
        }
        if (!b()) {
          break;
        }
        if (QLog.isColorLevel()) {
          QLog.d("apollo_client_ApolloUrlInterceptor", 6, "session(" + this.jdField_a_of_type_Long + ") handleFlow_Connection: destroy before server response.");
        }
        return;
        if (localMap.containsKey("set-cookie")) {
          localObject = "set-cookie";
        }
      }
      if (200 == i) {
        break;
      }
      if (this.jdField_b_of_type_Boolean)
      {
        this.jdField_a_of_type_AndroidOsHandler.removeMessages(1);
        localObject = this.jdField_a_of_type_AndroidOsHandler.obtainMessage(5);
        ((Message)localObject).arg1 = i;
        this.jdField_a_of_type_AndroidOsHandler.sendMessage((Message)localObject);
      }
    } while (!QLog.isColorLevel());
    QLog.d("apollo_client_ApolloUrlInterceptor", 4, "session(" + this.jdField_a_of_type_Long + ") handleFlow_Connection: response code not 200, response code = " + i);
    return;
    f();
  }
  
  private void f()
  {
    int i = 2;
    Object localObject1 = this.jdField_a_of_type_Zbk.a(this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean, null);
    if (localObject1 == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("apollo_client_ApolloUrlInterceptor", 2, "session(" + this.jdField_a_of_type_Long + ") handleFlow_FirstLoad error:responseDataTuple is null!");
      }
      this.jdField_c_of_type_Boolean = true;
      this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(3);
      return;
    }
    this.jdField_a_of_type_JavaIoInputStream = new BridgeStream(this, ((zbm)localObject1).jdField_a_of_type_JavaIoByteArrayOutputStream, ((zbm)localObject1).jdField_a_of_type_JavaIoBufferedInputStream);
    if (((zbm)localObject1).jdField_a_of_type_Boolean) {}
    for (;;)
    {
      try
      {
        localObject1 = ((zbm)localObject1).jdField_a_of_type_JavaIoByteArrayOutputStream.toString("UTF-8");
      }
      catch (Throwable localThrowable1)
      {
        try
        {
          this.jdField_g_of_type_JavaLangString = ((String)localObject1);
          if (TextUtils.isEmpty((CharSequence)localObject1)) {
            break label399;
          }
          bool = true;
          if (QLog.isColorLevel()) {
            QLog.d("apollo_client_ApolloUrlInterceptor", 4, "session(" + this.jdField_a_of_type_Long + ") handleFlow_FirstLoad:hasCacheData=" + bool + ".");
          }
          this.jdField_a_of_type_AndroidOsHandler.removeMessages(1);
          localObject2 = this.jdField_a_of_type_AndroidOsHandler.obtainMessage(2);
          ((Message)localObject2).obj = localObject1;
          if (!bool) {
            break label404;
          }
          ((Message)localObject2).arg1 = i;
          this.jdField_a_of_type_AndroidOsMessage = ((Message)localObject2);
          this.jdField_a_of_type_AndroidOsHandler.sendMessage((Message)localObject2);
          if ((!bool) || (this.jdField_a_of_type_Boolean)) {
            break;
          }
          long l = System.currentTimeMillis();
          ApolloWebDataHandler.a().b(this.jdField_e_of_type_JavaLangString, (String)localObject1);
          this.jdField_a_of_type_Boolean = true;
          if (!QLog.isColorLevel()) {
            break;
          }
          QLog.d("apollo_client_ApolloUrlInterceptor", 4, "session(" + this.jdField_a_of_type_Long + ") handleFlow_FirstLoad :save htmlString " + (System.currentTimeMillis() - l) + " ms.");
          return;
        }
        catch (Throwable localThrowable2)
        {
          for (;;)
          {
            boolean bool;
            Object localObject2 = localObject1;
          }
        }
        localThrowable1 = localThrowable1;
        localObject2 = null;
      }
      this.jdField_a_of_type_JavaIoInputStream = null;
      localObject1 = localObject2;
      if (QLog.isColorLevel())
      {
        QLog.d("apollo_client_ApolloUrlInterceptor", 2, "session(" + this.jdField_a_of_type_Long + ") handleFlow_FirstLoad error:" + localThrowable1.getMessage() + ".");
        localObject1 = localObject2;
        continue;
        label399:
        bool = false;
        continue;
        label404:
        i = 1;
        continue;
        localObject1 = null;
      }
    }
  }
  
  public ApolloWebStatistics a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqApolloStoreWebviewApolloWebStatistics;
  }
  
  /* Error */
  public Object a(String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 306	com/tencent/mobileqq/apollo/store/webview/ApolloUrlInterceptor:jdField_c_of_type_Boolean	Z
    //   4: ifeq +5 -> 9
    //   7: aconst_null
    //   8: areturn
    //   9: aload_0
    //   10: getfield 239	com/tencent/mobileqq/apollo/store/webview/ApolloUrlInterceptor:jdField_a_of_type_ComTencentBizPubaccountCustomWebView	Lcom/tencent/biz/pubaccount/CustomWebView;
    //   13: ifnull +66 -> 79
    //   16: invokestatic 165	com/tencent/mobileqq/apollo/store/webview/ApolloWebDataHandler:a	()Lcom/tencent/mobileqq/apollo/store/webview/ApolloWebDataHandler;
    //   19: aload_1
    //   20: invokevirtual 475	com/tencent/mobileqq/apollo/store/webview/ApolloWebDataHandler:b	(Ljava/lang/String;)Z
    //   23: ifeq +56 -> 79
    //   26: invokestatic 122	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   29: ifeq +29 -> 58
    //   32: ldc 124
    //   34: iconst_2
    //   35: new 126	java/lang/StringBuilder
    //   38: dup
    //   39: invokespecial 127	java/lang/StringBuilder:<init>	()V
    //   42: ldc_w 477
    //   45: invokevirtual 133	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   48: aload_1
    //   49: invokevirtual 133	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   52: invokevirtual 144	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   55: invokestatic 147	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   58: invokestatic 165	com/tencent/mobileqq/apollo/store/webview/ApolloWebDataHandler:a	()Lcom/tencent/mobileqq/apollo/store/webview/ApolloWebDataHandler;
    //   61: aload_1
    //   62: aload_0
    //   63: getfield 95	com/tencent/mobileqq/apollo/store/webview/ApolloUrlInterceptor:jdField_c_of_type_JavaLangString	Ljava/lang/String;
    //   66: invokevirtual 480	com/tencent/mobileqq/apollo/store/webview/ApolloWebDataHandler:a	(Ljava/lang/String;Ljava/lang/String;)Lcom/tencent/smtt/export/external/interfaces/WebResourceResponse;
    //   69: astore 5
    //   71: aload 5
    //   73: ifnull +6 -> 79
    //   76: aload 5
    //   78: areturn
    //   79: aload_0
    //   80: aload_1
    //   81: invokevirtual 481	com/tencent/mobileqq/apollo/store/webview/ApolloUrlInterceptor:a	(Ljava/lang/String;)Z
    //   84: ifne +49 -> 133
    //   87: invokestatic 122	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   90: ifeq -83 -> 7
    //   93: ldc 124
    //   95: iconst_2
    //   96: new 126	java/lang/StringBuilder
    //   99: dup
    //   100: invokespecial 127	java/lang/StringBuilder:<init>	()V
    //   103: ldc 129
    //   105: invokevirtual 133	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   108: aload_0
    //   109: getfield 99	com/tencent/mobileqq/apollo/store/webview/ApolloUrlInterceptor:jdField_a_of_type_Long	J
    //   112: invokevirtual 136	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   115: ldc_w 483
    //   118: invokevirtual 133	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   121: aload_1
    //   122: invokevirtual 133	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   125: invokevirtual 144	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   128: invokestatic 147	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   131: aconst_null
    //   132: areturn
    //   133: aload_0
    //   134: getfield 61	com/tencent/mobileqq/apollo/store/webview/ApolloUrlInterceptor:jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   137: invokevirtual 281	java/util/concurrent/atomic/AtomicBoolean:get	()Z
    //   140: ifeq +47 -> 187
    //   143: invokestatic 122	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   146: ifeq +41 -> 187
    //   149: ldc 124
    //   151: iconst_2
    //   152: new 126	java/lang/StringBuilder
    //   155: dup
    //   156: invokespecial 127	java/lang/StringBuilder:<init>	()V
    //   159: ldc 129
    //   161: invokevirtual 133	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   164: aload_0
    //   165: getfield 99	com/tencent/mobileqq/apollo/store/webview/ApolloUrlInterceptor:jdField_a_of_type_Long	J
    //   168: invokevirtual 136	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   171: ldc_w 485
    //   174: invokevirtual 133	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   177: aload_1
    //   178: invokevirtual 133	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   181: invokevirtual 144	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   184: invokestatic 147	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   187: aload_0
    //   188: getfield 61	com/tencent/mobileqq/apollo/store/webview/ApolloUrlInterceptor:jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   191: iconst_0
    //   192: iconst_1
    //   193: invokevirtual 268	java/util/concurrent/atomic/AtomicBoolean:compareAndSet	(ZZ)Z
    //   196: ifne +47 -> 243
    //   199: invokestatic 122	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   202: ifeq +41 -> 243
    //   205: ldc 124
    //   207: iconst_2
    //   208: new 126	java/lang/StringBuilder
    //   211: dup
    //   212: invokespecial 127	java/lang/StringBuilder:<init>	()V
    //   215: ldc 129
    //   217: invokevirtual 133	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   220: aload_0
    //   221: getfield 99	com/tencent/mobileqq/apollo/store/webview/ApolloUrlInterceptor:jdField_a_of_type_Long	J
    //   224: invokevirtual 136	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   227: ldc_w 487
    //   230: invokevirtual 133	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   233: aload_1
    //   234: invokevirtual 133	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   237: invokevirtual 144	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   240: invokestatic 147	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   243: invokestatic 122	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   246: ifeq +41 -> 287
    //   249: ldc 124
    //   251: iconst_2
    //   252: new 126	java/lang/StringBuilder
    //   255: dup
    //   256: invokespecial 127	java/lang/StringBuilder:<init>	()V
    //   259: ldc 129
    //   261: invokevirtual 133	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   264: aload_0
    //   265: getfield 99	com/tencent/mobileqq/apollo/store/webview/ApolloUrlInterceptor:jdField_a_of_type_Long	J
    //   268: invokevirtual 136	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   271: ldc_w 489
    //   274: invokevirtual 133	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   277: aload_1
    //   278: invokevirtual 133	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   281: invokevirtual 144	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   284: invokestatic 147	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   287: invokestatic 154	java/lang/System:currentTimeMillis	()J
    //   290: lstore_2
    //   291: aload_0
    //   292: getfield 54	com/tencent/mobileqq/apollo/store/webview/ApolloUrlInterceptor:jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger	Ljava/util/concurrent/atomic/AtomicInteger;
    //   295: invokevirtual 237	java/util/concurrent/atomic/AtomicInteger:get	()I
    //   298: iconst_1
    //   299: if_icmpne +361 -> 660
    //   302: aload_0
    //   303: getfield 54	com/tencent/mobileqq/apollo/store/webview/ApolloUrlInterceptor:jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger	Ljava/util/concurrent/atomic/AtomicInteger;
    //   306: astore_1
    //   307: aload_1
    //   308: monitorenter
    //   309: aload_0
    //   310: getfield 54	com/tencent/mobileqq/apollo/store/webview/ApolloUrlInterceptor:jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger	Ljava/util/concurrent/atomic/AtomicInteger;
    //   313: invokevirtual 237	java/util/concurrent/atomic/AtomicInteger:get	()I
    //   316: iconst_1
    //   317: if_icmpne +53 -> 370
    //   320: invokestatic 122	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   323: ifeq +37 -> 360
    //   326: ldc 124
    //   328: iconst_2
    //   329: new 126	java/lang/StringBuilder
    //   332: dup
    //   333: invokespecial 127	java/lang/StringBuilder:<init>	()V
    //   336: ldc 129
    //   338: invokevirtual 133	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   341: aload_0
    //   342: getfield 99	com/tencent/mobileqq/apollo/store/webview/ApolloUrlInterceptor:jdField_a_of_type_Long	J
    //   345: invokevirtual 136	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   348: ldc_w 491
    //   351: invokevirtual 133	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   354: invokevirtual 144	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   357: invokestatic 147	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   360: aload_0
    //   361: getfield 54	com/tencent/mobileqq/apollo/store/webview/ApolloUrlInterceptor:jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger	Ljava/util/concurrent/atomic/AtomicInteger;
    //   364: ldc2_w 492
    //   367: invokevirtual 497	java/lang/Object:wait	(J)V
    //   370: aload_1
    //   371: monitorexit
    //   372: invokestatic 122	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   375: ifeq +74 -> 449
    //   378: new 126	java/lang/StringBuilder
    //   381: dup
    //   382: invokespecial 127	java/lang/StringBuilder:<init>	()V
    //   385: ldc 129
    //   387: invokevirtual 133	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   390: aload_0
    //   391: getfield 99	com/tencent/mobileqq/apollo/store/webview/ApolloUrlInterceptor:jdField_a_of_type_Long	J
    //   394: invokevirtual 136	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   397: ldc_w 499
    //   400: invokevirtual 133	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   403: astore_1
    //   404: aload_0
    //   405: getfield 241	com/tencent/mobileqq/apollo/store/webview/ApolloUrlInterceptor:jdField_a_of_type_JavaIoInputStream	Ljava/io/InputStream;
    //   408: ifnull +302 -> 710
    //   411: iconst_1
    //   412: istore 4
    //   414: ldc 124
    //   416: iconst_2
    //   417: aload_1
    //   418: iload 4
    //   420: invokevirtual 178	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   423: ldc_w 423
    //   426: invokevirtual 133	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   429: invokestatic 154	java/lang/System:currentTimeMillis	()J
    //   432: lload_2
    //   433: lsub
    //   434: invokevirtual 136	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   437: ldc_w 501
    //   440: invokevirtual 133	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   443: invokevirtual 144	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   446: invokestatic 147	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   449: aload_0
    //   450: getfield 241	com/tencent/mobileqq/apollo/store/webview/ApolloUrlInterceptor:jdField_a_of_type_JavaIoInputStream	Ljava/io/InputStream;
    //   453: ifnonnull +54 -> 507
    //   456: aload_0
    //   457: getfield 243	com/tencent/mobileqq/apollo/store/webview/ApolloUrlInterceptor:jdField_g_of_type_JavaLangString	Ljava/lang/String;
    //   460: invokestatic 160	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   463: ifne +44 -> 507
    //   466: aload_0
    //   467: new 503	java/io/ByteArrayInputStream
    //   470: dup
    //   471: aload_0
    //   472: getfield 243	com/tencent/mobileqq/apollo/store/webview/ApolloUrlInterceptor:jdField_g_of_type_JavaLangString	Ljava/lang/String;
    //   475: ldc_w 456
    //   478: invokevirtual 507	java/lang/String:getBytes	(Ljava/lang/String;)[B
    //   481: invokespecial 510	java/io/ByteArrayInputStream:<init>	([B)V
    //   484: putfield 241	com/tencent/mobileqq/apollo/store/webview/ApolloUrlInterceptor:jdField_a_of_type_JavaIoInputStream	Ljava/io/InputStream;
    //   487: aload_0
    //   488: iconst_1
    //   489: putfield 512	com/tencent/mobileqq/apollo/store/webview/ApolloUrlInterceptor:jdField_d_of_type_Boolean	Z
    //   492: invokestatic 122	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   495: ifeq +12 -> 507
    //   498: ldc 124
    //   500: iconst_2
    //   501: ldc_w 514
    //   504: invokestatic 147	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   507: aload_0
    //   508: getfield 241	com/tencent/mobileqq/apollo/store/webview/ApolloUrlInterceptor:jdField_a_of_type_JavaIoInputStream	Ljava/io/InputStream;
    //   511: ifnull +240 -> 751
    //   514: aload_0
    //   515: invokespecial 425	com/tencent/mobileqq/apollo/store/webview/ApolloUrlInterceptor:b	()Z
    //   518: ifne +213 -> 731
    //   521: new 516	com/tencent/smtt/export/external/interfaces/WebResourceResponse
    //   524: dup
    //   525: aload_0
    //   526: getfield 116	com/tencent/mobileqq/apollo/store/webview/ApolloUrlInterceptor:jdField_e_of_type_JavaLangString	Ljava/lang/String;
    //   529: invokestatic 517	com/tencent/mobileqq/apollo/store/webview/ApolloClientUtil:a	(Ljava/lang/String;)Ljava/lang/String;
    //   532: ldc_w 519
    //   535: aload_0
    //   536: getfield 241	com/tencent/mobileqq/apollo/store/webview/ApolloUrlInterceptor:jdField_a_of_type_JavaIoInputStream	Ljava/io/InputStream;
    //   539: invokespecial 522	com/tencent/smtt/export/external/interfaces/WebResourceResponse:<init>	(Ljava/lang/String;Ljava/lang/String;Ljava/io/InputStream;)V
    //   542: astore_1
    //   543: aload_0
    //   544: getfield 69	com/tencent/mobileqq/apollo/store/webview/ApolloUrlInterceptor:jdField_e_of_type_JavaUtilConcurrentAtomicAtomicBoolean	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   547: iconst_1
    //   548: invokevirtual 261	java/util/concurrent/atomic/AtomicBoolean:set	(Z)V
    //   551: aload_0
    //   552: getfield 512	com/tencent/mobileqq/apollo/store/webview/ApolloUrlInterceptor:jdField_d_of_type_Boolean	Z
    //   555: ifeq +12 -> 567
    //   558: aload_0
    //   559: invokespecial 524	com/tencent/mobileqq/apollo/store/webview/ApolloUrlInterceptor:c	()V
    //   562: aload_0
    //   563: iconst_0
    //   564: putfield 512	com/tencent/mobileqq/apollo/store/webview/ApolloUrlInterceptor:jdField_d_of_type_Boolean	Z
    //   567: invokestatic 122	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   570: ifeq +29 -> 599
    //   573: ldc 124
    //   575: iconst_2
    //   576: new 126	java/lang/StringBuilder
    //   579: dup
    //   580: invokespecial 127	java/lang/StringBuilder:<init>	()V
    //   583: ldc_w 526
    //   586: invokevirtual 133	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   589: aload_1
    //   590: invokevirtual 302	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   593: invokevirtual 144	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   596: invokestatic 147	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   599: aload_0
    //   600: aconst_null
    //   601: putfield 241	com/tencent/mobileqq/apollo/store/webview/ApolloUrlInterceptor:jdField_a_of_type_JavaIoInputStream	Ljava/io/InputStream;
    //   604: aload_1
    //   605: areturn
    //   606: astore 5
    //   608: ldc 124
    //   610: iconst_2
    //   611: new 126	java/lang/StringBuilder
    //   614: dup
    //   615: invokespecial 127	java/lang/StringBuilder:<init>	()V
    //   618: ldc 129
    //   620: invokevirtual 133	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   623: aload_0
    //   624: getfield 99	com/tencent/mobileqq/apollo/store/webview/ApolloUrlInterceptor:jdField_a_of_type_Long	J
    //   627: invokevirtual 136	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   630: ldc_w 528
    //   633: invokevirtual 133	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   636: aload 5
    //   638: invokevirtual 471	java/lang/Throwable:getMessage	()Ljava/lang/String;
    //   641: invokevirtual 133	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   644: invokevirtual 144	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   647: invokestatic 530	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   650: goto -280 -> 370
    //   653: astore 5
    //   655: aload_1
    //   656: monitorexit
    //   657: aload 5
    //   659: athrow
    //   660: invokestatic 122	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   663: ifeq -291 -> 372
    //   666: ldc 124
    //   668: iconst_2
    //   669: new 126	java/lang/StringBuilder
    //   672: dup
    //   673: invokespecial 127	java/lang/StringBuilder:<init>	()V
    //   676: ldc 129
    //   678: invokevirtual 133	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   681: aload_0
    //   682: getfield 99	com/tencent/mobileqq/apollo/store/webview/ApolloUrlInterceptor:jdField_a_of_type_Long	J
    //   685: invokevirtual 136	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   688: ldc_w 532
    //   691: invokevirtual 133	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   694: aload_0
    //   695: getfield 54	com/tencent/mobileqq/apollo/store/webview/ApolloUrlInterceptor:jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger	Ljava/util/concurrent/atomic/AtomicInteger;
    //   698: invokevirtual 302	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   701: invokevirtual 144	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   704: invokestatic 147	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   707: goto -335 -> 372
    //   710: iconst_0
    //   711: istore 4
    //   713: goto -299 -> 414
    //   716: astore_1
    //   717: ldc 124
    //   719: iconst_2
    //   720: aload_1
    //   721: iconst_0
    //   722: anewarray 4	java/lang/Object
    //   725: invokestatic 535	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/Throwable;[Ljava/lang/Object;)V
    //   728: goto -236 -> 492
    //   731: invokestatic 122	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   734: ifeq +12 -> 746
    //   737: ldc 124
    //   739: iconst_2
    //   740: ldc_w 537
    //   743: invokestatic 147	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   746: aconst_null
    //   747: astore_1
    //   748: goto -197 -> 551
    //   751: invokestatic 122	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   754: ifeq -747 -> 7
    //   757: ldc 124
    //   759: iconst_2
    //   760: ldc_w 539
    //   763: invokestatic 147	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   766: aconst_null
    //   767: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	768	0	this	ApolloUrlInterceptor
    //   0	768	1	paramString	String
    //   290	143	2	l	long
    //   412	300	4	bool	boolean
    //   69	8	5	localWebResourceResponse	com.tencent.smtt.export.external.interfaces.WebResourceResponse
    //   606	31	5	localThrowable	Throwable
    //   653	5	5	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   309	360	606	java/lang/Throwable
    //   360	370	606	java/lang/Throwable
    //   309	360	653	finally
    //   360	370	653	finally
    //   370	372	653	finally
    //   608	650	653	finally
    //   655	657	653	finally
    //   466	492	716	java/lang/Throwable
  }
  
  public void a()
  {
    b(false);
  }
  
  public void a(boolean paramBoolean)
  {
    if (!this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.compareAndSet(0, 1))
    {
      if (QLog.isColorLevel()) {
        QLog.d("apollo_client_ApolloUrlInterceptor", 2, "session(" + this.jdField_a_of_type_Long + ") start error:sessionState=" + this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.get() + ".");
      }
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("apollo_client_ApolloUrlInterceptor", 2, "session(" + this.jdField_a_of_type_Long + ") now post sonic flow task.");
    }
    this.jdField_g_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(true);
    if (paramBoolean)
    {
      ThreadManager.postImmediately(new zbi(this), null, true);
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("apollo_client_ApolloUrlInterceptor", 2, "runSonicFlow in AsyncThread start!");
    }
    ApolloWebStatistics localApolloWebStatistics = this.jdField_a_of_type_ComTencentMobileqqApolloStoreWebviewApolloWebStatistics;
    long l = System.currentTimeMillis();
    localApolloWebStatistics.g = l;
    b();
    d();
    if (QLog.isColorLevel()) {
      QLog.d("apollo_client_ApolloUrlInterceptor", 2, "runSonicFlow use:" + (System.currentTimeMillis() - l));
    }
    this.jdField_a_of_type_ComTencentMobileqqApolloStoreWebviewApolloWebStatistics.h = System.currentTimeMillis();
  }
  
  public void a(boolean paramBoolean, ByteArrayOutputStream paramByteArrayOutputStream)
  {
    boolean bool = true;
    if (this.jdField_a_of_type_JavaIoInputStream != null) {
      this.jdField_a_of_type_JavaIoInputStream = null;
    }
    if (QLog.isColorLevel()) {
      QLog.d("apollo_client_ApolloUrlInterceptor", 1, "session(" + this.jdField_a_of_type_Long + ") onClose:readComplete:" + paramBoolean);
    }
    long l = System.currentTimeMillis();
    if ((paramBoolean) && (paramByteArrayOutputStream != null))
    {
      ThreadManager.getSubThreadHandler().postDelayed(new zbj(this, paramByteArrayOutputStream), 3000L);
      return;
    }
    StringBuilder localStringBuilder;
    if (QLog.isColorLevel())
    {
      localStringBuilder = new StringBuilder().append("session(").append(this.jdField_a_of_type_Long).append(") onClose error:readComplete =").append(paramBoolean).append(", outputStream is null -> ");
      if (paramByteArrayOutputStream != null) {
        break label262;
      }
    }
    label262:
    for (paramBoolean = bool;; paramBoolean = false)
    {
      QLog.e("apollo_client_ApolloUrlInterceptor", 6, paramBoolean);
      this.jdField_e_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(false);
      if (d()) {
        QLog.d("apollo_client_ApolloUrlInterceptor", 2, "session(" + this.jdField_a_of_type_Long + ") onClose: postForceDestroyIfNeed send destroy message in chromium_io thread.");
      }
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d("apollo_client_ApolloUrlInterceptor", 6, "session(" + this.jdField_a_of_type_Long + ") onClose cost " + (System.currentTimeMillis() - l) + " ms.");
      return;
    }
  }
  
  public boolean a()
  {
    return !this.jdField_c_of_type_Boolean;
  }
  
  public boolean a(CustomWebView paramCustomWebView)
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountCustomWebView == null)
    {
      this.jdField_a_of_type_ComTencentBizPubaccountCustomWebView = paramCustomWebView;
      QLog.d("apollo_client_ApolloUrlInterceptor", 2, "session(" + this.jdField_a_of_type_Long + ") bind client.");
      return true;
    }
    return false;
  }
  
  public boolean a(String paramString)
  {
    try
    {
      Uri localUri = Uri.parse(this.jdField_e_of_type_JavaLangString);
      paramString = Uri.parse(paramString);
      Object localObject = localUri.getHost() + localUri.getPath();
      String str = paramString.getHost() + paramString.getPath();
      if (localUri.getHost().equalsIgnoreCase(paramString.getHost()))
      {
        paramString = (String)localObject;
        if (!((String)localObject).endsWith("/")) {
          paramString = (String)localObject + "/";
        }
        localObject = str;
        if (!str.endsWith("/")) {
          localObject = str + "/";
        }
        boolean bool = paramString.equalsIgnoreCase((String)localObject);
        return bool;
      }
    }
    catch (Throwable paramString)
    {
      QLog.e("apollo_client_ApolloUrlInterceptor", 2, "isMatchCurrentUrl error:" + paramString.getMessage());
    }
    return false;
  }
  
  public boolean b(String paramString)
  {
    boolean bool = false;
    if ((!this.jdField_c_of_type_Boolean) && (a(paramString)) && (this.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicBoolean.compareAndSet(false, true)))
    {
      this.jdField_e_of_type_JavaLangString = ApolloClientUtil.a(paramString, "session_id", String.valueOf(this.jdField_a_of_type_Long));
      this.jdField_a_of_type_ComTencentMobileqqApolloStoreWebviewApolloWebStatistics.i = System.currentTimeMillis();
      if (QLog.isColorLevel())
      {
        paramString = new StringBuilder().append("session(").append(this.jdField_a_of_type_Long).append(") onWebViewInited: mPendingClientCoreMessage not null:");
        if (this.jdField_a_of_type_AndroidOsMessage != null) {
          bool = true;
        }
        QLog.d("apollo_client_ApolloUrlInterceptor", 2, bool + ",currUrl:" + this.jdField_e_of_type_JavaLangString);
      }
      if (this.jdField_a_of_type_AndroidOsMessage != null)
      {
        paramString = this.jdField_a_of_type_AndroidOsMessage;
        this.jdField_a_of_type_AndroidOsMessage = null;
        handleMessage(paramString);
      }
      while (this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.get() != 0) {
        return true;
      }
      a(true);
      return true;
    }
    return false;
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    boolean bool = false;
    if (10 == paramMessage.what)
    {
      b(true);
      if (QLog.isColorLevel()) {
        QLog.d("apollo_client_ApolloUrlInterceptor", 2, "session(" + this.jdField_a_of_type_Long + ") handleMessage:force destroy.");
      }
      bool = true;
    }
    do
    {
      do
      {
        return bool;
        if (!b()) {
          break;
        }
      } while (!QLog.isColorLevel());
      QLog.d("apollo_client_ApolloUrlInterceptor", 2, "session(" + this.jdField_a_of_type_Long + ") handleMessage error: is destroyed or waiting for destroy.");
      return false;
      if (QLog.isColorLevel()) {
        QLog.d("apollo_client_ApolloUrlInterceptor", 2, "session(" + this.jdField_a_of_type_Long + ") handleMessage: msg what = " + paramMessage.what + ".");
      }
      if ((paramMessage.what > 0) && (paramMessage.what < 7) && (!this.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get()))
      {
        this.jdField_a_of_type_AndroidOsMessage = Message.obtain(paramMessage);
        if (QLog.isColorLevel()) {
          QLog.d("apollo_client_ApolloUrlInterceptor", 2, "session(" + this.jdField_a_of_type_Long + ") handleMessage: client not ready, core msg = " + paramMessage.what + ".");
        }
        return true;
      }
      if (paramMessage == this.jdField_a_of_type_AndroidOsMessage) {
        this.jdField_a_of_type_AndroidOsMessage = null;
      }
      switch (paramMessage.what)
      {
      }
    } while (!QLog.isColorLevel());
    QLog.d("apollo_client_ApolloUrlInterceptor", 2, "msg.what " + paramMessage.what);
    return false;
    if (paramMessage.arg1 == 1) {
      if (this.jdField_c_of_type_JavaUtilConcurrentAtomicAtomicBoolean.compareAndSet(false, true))
      {
        if (QLog.isColorLevel()) {
          QLog.d("apollo_client_ApolloUrlInterceptor", 2, "session(" + this.jdField_a_of_type_Long + ") handleClientCoreMessage_PreLoad:PRE_LOAD_NO_CACHE load url.");
        }
        this.jdField_a_of_type_ComTencentMobileqqApolloStoreWebviewApolloWebStatistics.j = System.currentTimeMillis();
        if (this.jdField_a_of_type_ComTencentBizPubaccountCustomWebView != null) {
          this.jdField_a_of_type_ComTencentBizPubaccountCustomWebView.a(this.jdField_e_of_type_JavaLangString);
        }
      }
    }
    for (;;)
    {
      return true;
      if (QLog.isColorLevel())
      {
        QLog.d("apollo_client_ApolloUrlInterceptor", 2, "session(" + this.jdField_a_of_type_Long + ") handleClientCoreMessage_PreLoad:wasLoadUrlInvoked = true.");
        continue;
        if (paramMessage.arg1 == 2) {
          if (this.jdField_d_of_type_JavaUtilConcurrentAtomicAtomicBoolean.compareAndSet(false, true))
          {
            if (QLog.isColorLevel()) {
              QLog.d("apollo_client_ApolloUrlInterceptor", 2, "session(" + this.jdField_a_of_type_Long + ") handleClientCoreMessage_PreLoad:PRE_LOAD_WITH_CACHE load data.");
            }
            paramMessage = (String)paramMessage.obj;
            this.jdField_a_of_type_ComTencentMobileqqApolloStoreWebviewApolloWebStatistics.j = System.currentTimeMillis();
            if (this.jdField_a_of_type_ComTencentBizPubaccountCustomWebView != null) {
              this.jdField_a_of_type_ComTencentBizPubaccountCustomWebView.loadDataWithBaseURL(this.jdField_e_of_type_JavaLangString, paramMessage, "text/html", "utf-8", this.jdField_e_of_type_JavaLangString);
            }
          }
          else if (QLog.isColorLevel())
          {
            QLog.d("apollo_client_ApolloUrlInterceptor", 2, "session(" + this.jdField_a_of_type_Long + ") handleClientCoreMessage_PreLoad:wasLoadDataInvoked = true.");
            continue;
            if (paramMessage.arg1 == 1)
            {
              if (this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get())
              {
                if (QLog.isColorLevel()) {
                  QLog.d("apollo_client_ApolloUrlInterceptor", 2, "session(" + this.jdField_a_of_type_Long + ") handleClientCoreMessage_FirstLoad:FIRST_LOAD_NO_CACHE.");
                }
              }
              else if (QLog.isColorLevel()) {
                QLog.d("apollo_client_ApolloUrlInterceptor", 2, "session(" + this.jdField_a_of_type_Long + ") handleClientCoreMessage_FirstLoad:url was not invoked.");
              }
            }
            else if (paramMessage.arg1 == 2) {
              if (this.jdField_c_of_type_JavaUtilConcurrentAtomicAtomicBoolean.compareAndSet(false, true))
              {
                if (QLog.isColorLevel()) {
                  QLog.d("apollo_client_ApolloUrlInterceptor", 2, "session(\" + sId + \") handleClientCoreMessage_FirstLoad with cache, url:" + this.jdField_e_of_type_JavaLangString);
                }
                this.jdField_d_of_type_Boolean = true;
                this.jdField_a_of_type_ComTencentMobileqqApolloStoreWebviewApolloWebStatistics.j = System.currentTimeMillis();
                if (this.jdField_a_of_type_ComTencentBizPubaccountCustomWebView != null) {
                  this.jdField_a_of_type_ComTencentBizPubaccountCustomWebView.loadDataWithBaseURL(this.jdField_e_of_type_JavaLangString, (String)paramMessage.obj, "text/html", "utf-8", this.jdField_e_of_type_JavaLangString);
                }
              }
              else if (QLog.isColorLevel())
              {
                QLog.d("apollo_client_ApolloUrlInterceptor", 2, "session(" + this.jdField_a_of_type_Long + ") FIRST_LOAD_WITH_CACHE load url was invoked.");
                continue;
                if (this.jdField_c_of_type_JavaUtilConcurrentAtomicAtomicBoolean.compareAndSet(false, true))
                {
                  if (QLog.isColorLevel()) {
                    QLog.d("apollo_client_ApolloUrlInterceptor", 2, "handleClientCoreMessage_ConnectionError: load src url.");
                  }
                  if (this.jdField_a_of_type_ComTencentBizPubaccountCustomWebView != null)
                  {
                    this.jdField_a_of_type_ComTencentBizPubaccountCustomWebView.a(this.jdField_e_of_type_JavaLangString);
                    continue;
                    if ((this.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get()) && (!b()) && (!TextUtils.isEmpty(jdField_a_of_type_JavaLangString))) {
                      Toast.makeText(BaseApplicationImpl.getContext(), jdField_a_of_type_JavaLangString, 1).show();
                    }
                  }
                }
              }
            }
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.store.webview.ApolloUrlInterceptor
 * JD-Core Version:    0.7.0.1
 */