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
import com.tencent.mobileqq.apollo.api.handler.IApolloWebDataHandler;
import com.tencent.mobileqq.apollo.api.handler.impl.ApolloWebDataHandlerImpl;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.qphone.base.util.QLog;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.InputStream;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.os.MqqHandler;

public class ApolloUrlInterceptor
  implements Handler.Callback, BridgeStream.IBridgeStreamCallback
{
  private static long jdField_a_of_type_Long = new Random().nextInt(263167);
  public static String a;
  private final Handler jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper(), this);
  private Message jdField_a_of_type_AndroidOsMessage;
  private volatile CustomWebView jdField_a_of_type_ComTencentBizPubaccountCustomWebView;
  private volatile ApolloUrlConnection jdField_a_of_type_ComTencentMobileqqApolloStoreWebviewApolloUrlConnection;
  private ApolloWebStatistics jdField_a_of_type_ComTencentMobileqqApolloStoreWebviewApolloWebStatistics = new ApolloWebStatistics();
  private volatile InputStream jdField_a_of_type_JavaIoInputStream;
  private ConcurrentHashMap<String, ApolloUrlInterceptor.PreloadCGITask> jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
  private final AtomicBoolean jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean(false);
  private final AtomicInteger jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger = new AtomicInteger(0);
  private volatile boolean jdField_a_of_type_Boolean = false;
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
    jdField_a_of_type_JavaLangString = HardCodeUtil.a(2131700603);
  }
  
  public ApolloUrlInterceptor(String paramString1, String paramString2)
  {
    this.jdField_c_of_type_JavaLangString = paramString2;
    long l = jdField_a_of_type_Long;
    jdField_a_of_type_Long = 1L + l;
    this.jdField_b_of_type_JavaLangString = String.valueOf(l);
    this.jdField_d_of_type_JavaLangString = ApolloClientUtil.a(paramString1, "apollo_task_id", String.valueOf(this.jdField_b_of_type_JavaLangString));
    this.jdField_e_of_type_JavaLangString = this.jdField_d_of_type_JavaLangString;
    if (QLog.isColorLevel()) {
      QLog.d("apollo_client_ApolloUrlInterceptor", 2, "task(" + this.jdField_b_of_type_JavaLangString + ") create:id=" + this.jdField_b_of_type_JavaLangString + ", url = " + paramString1);
    }
  }
  
  public static ApolloUrlInterceptor a(boolean paramBoolean, String paramString)
  {
    long l = System.currentTimeMillis();
    if (!TextUtils.isEmpty(paramString))
    {
      ApolloWebDataHandlerImpl localApolloWebDataHandlerImpl = (ApolloWebDataHandlerImpl)QRoute.api(IApolloWebDataHandler.class);
      String str = localApolloWebDataHandlerImpl.getApolloClientId(paramString);
      if (localApolloWebDataHandlerImpl.isApolloClientId(str))
      {
        paramString = new ApolloUrlInterceptor(paramString, str);
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
    Object localObject1 = (AppInterface)MobileQQ.sMobileQQ.waitAppRuntime(null).getAppRuntime("modular_web");
    if ((localObject1 != null) && (!TextUtils.isEmpty(this.jdField_c_of_type_JavaLangString)))
    {
      Object localObject2 = (ApolloWebDataHandlerImpl)QRoute.api(IApolloWebDataHandler.class);
      ((ApolloWebDataHandlerImpl)localObject2).preLoadSSOCmd(BaseApplicationImpl.getContext(), this.jdField_c_of_type_JavaLangString, this.jdField_e_of_type_JavaLangString, (AppInterface)localObject1, this.jdField_a_of_type_ComTencentMobileqqApolloStoreWebviewApolloWebStatistics);
      localObject1 = ((ApolloWebDataHandlerImpl)localObject2).getCGIConfigs(this.jdField_c_of_type_JavaLangString);
      if ((localObject1 != null) && (!((List)localObject1).isEmpty()))
      {
        localObject1 = ((List)localObject1).iterator();
        while (((Iterator)localObject1).hasNext())
        {
          localObject2 = (ApolloSSOConfig.CGIConfig)((Iterator)localObject1).next();
          if (((ApolloSSOConfig.CGIConfig)localObject2).a())
          {
            ApolloUrlInterceptor.PreloadCGITask localPreloadCGITask = new ApolloUrlInterceptor.PreloadCGITask(this, (ApolloSSOConfig.CGIConfig)localObject2);
            this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(((ApolloSSOConfig.CGIConfig)localObject2).jdField_a_of_type_JavaLangString, localPreloadCGITask);
            localPreloadCGITask.b();
          }
        }
      }
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
        break label227;
      }
      if ((this.jdField_a_of_type_ComTencentMobileqqApolloStoreWebviewApolloUrlConnection != null) && (!paramBoolean))
      {
        this.jdField_a_of_type_ComTencentMobileqqApolloStoreWebviewApolloUrlConnection.a();
        this.jdField_a_of_type_ComTencentMobileqqApolloStoreWebviewApolloUrlConnection = null;
      }
      this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.set(3);
      synchronized (this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger)
      {
        this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.notify();
        this.jdField_a_of_type_AndroidOsHandler.removeMessages(10);
        this.jdField_f_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(false);
        if (QLog.isColorLevel()) {
          QLog.d("apollo_client_ApolloUrlInterceptor", 2, "task(" + this.jdField_b_of_type_JavaLangString + ") final destroy, force=" + paramBoolean + ".");
        }
        this.jdField_a_of_type_AndroidOsHandler.removeMessages(255);
        ??? = this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.values().iterator();
        if (((Iterator)???).hasNext()) {
          ((ApolloUrlInterceptor.PreloadCGITask)((Iterator)???).next()).a();
        }
      }
      this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.clear();
    }
    label227:
    do
    {
      do
      {
        return;
        this.jdField_a_of_type_AndroidOsHandler.removeMessages(255);
      } while (!this.jdField_f_of_type_JavaUtilConcurrentAtomicAtomicBoolean.compareAndSet(false, true));
      this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(10, 6000L);
    } while (!QLog.isColorLevel());
    QLog.d("apollo_client_ApolloUrlInterceptor", 2, "task(" + this.jdField_b_of_type_JavaLangString + ") waiting for destroy, current state =" + i + ".");
  }
  
  private boolean b()
  {
    return (3 == this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.get()) || (this.jdField_f_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get());
  }
  
  private void c()
  {
    if (1 != this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.get())
    {
      if (QLog.isColorLevel()) {
        QLog.d("apollo_client_ApolloUrlInterceptor", 2, "task(" + this.jdField_b_of_type_JavaLangString + ") runDataTask error:sessionState=" + this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.get() + ".");
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
        QLog.d("apollo_client_ApolloUrlInterceptor", 2, "task(" + this.jdField_b_of_type_JavaLangString + ") runDataTask error:fileName is null");
      }
      this.jdField_c_of_type_Boolean = true;
      this.jdField_g_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(false);
      this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(3);
      return;
    }
    Object localObject1 = ApolloClientUtil.d(this.jdField_f_of_type_JavaLangString);
    if (QLog.isColorLevel()) {
      QLog.d("apollo_client_ApolloUrlInterceptor", 2, "task(" + this.jdField_b_of_type_JavaLangString + ") runDataTask url is " + this.jdField_e_of_type_JavaLangString + " filePath is " + (String)localObject1);
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
        break label668;
      }
      long l2 = System.currentTimeMillis();
      if (((ApolloWebDataHandlerImpl)QRoute.api(IApolloWebDataHandler.class)).verifyCache(this.jdField_c_of_type_JavaLangString, (String)localObject1)) {
        break label657;
      }
      localObject1 = null;
      ((File)localObject2).delete();
      if (QLog.isColorLevel()) {
        QLog.d("apollo_client_ApolloUrlInterceptor", 2, "task(" + this.jdField_b_of_type_JavaLangString + ") runDataTask md5 not match delete localFile! url is " + this.jdField_e_of_type_JavaLangString);
      }
      this.jdField_a_of_type_ComTencentMobileqqApolloStoreWebviewApolloWebStatistics.a = 1;
      bool1 = false;
      label392:
      this.jdField_a_of_type_ComTencentMobileqqApolloStoreWebviewApolloWebStatistics.f = (System.currentTimeMillis() - l2);
      localObject2 = localObject1;
      bool2 = bool1;
      if (QLog.isColorLevel())
      {
        QLog.d("apollo_client_ApolloUrlInterceptor", 2, "verify use:" + (System.currentTimeMillis() - l2));
        bool2 = bool1;
        localObject2 = localObject1;
      }
      label456:
      if (QLog.isColorLevel()) {
        QLog.d("apollo_client_ApolloUrlInterceptor", 2, "get LocalFile use:" + (System.currentTimeMillis() - l1));
      }
      localObject1 = this.jdField_a_of_type_AndroidOsHandler.obtainMessage(1);
      this.jdField_a_of_type_AndroidOsMessage = ((Message)localObject1);
      if (!bool2) {
        break label687;
      }
      ((Message)localObject1).arg1 = 2;
      ((Message)localObject1).obj = localObject2;
      this.jdField_a_of_type_AndroidOsHandler.sendMessage((Message)localObject1);
      if (QLog.isColorLevel()) {
        QLog.d("apollo_client_ApolloUrlInterceptor", 2, "task(" + this.jdField_b_of_type_JavaLangString + ") runDataTask hasHtmlCache:" + bool2);
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
      QLog.d("apollo_client_ApolloUrlInterceptor", 4, "task(" + this.jdField_b_of_type_JavaLangString + ") runDataTask:send force destroy message.");
      return;
      bool1 = false;
      break label296;
      label657:
      this.jdField_a_of_type_ComTencentMobileqqApolloStoreWebviewApolloWebStatistics.a = 2;
      break label392;
      label668:
      this.jdField_a_of_type_ComTencentMobileqqApolloStoreWebviewApolloWebStatistics.a = 0;
      localObject2 = localObject1;
      bool2 = bool1;
      break label456;
      label687:
      if (QLog.isColorLevel()) {
        QLog.d("apollo_client_ApolloUrlInterceptor", 2, "task(" + this.jdField_b_of_type_JavaLangString + ") runDataTask has no cache, do first load flow.");
      }
      ((Message)localObject1).arg1 = 1;
      this.jdField_a_of_type_AndroidOsHandler.sendMessage((Message)localObject1);
      if (!NetworkUtil.g(BaseApplicationImpl.getContext()))
      {
        if (!TextUtils.isEmpty(jdField_a_of_type_JavaLangString)) {
          this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(255, 1500L);
        }
        if (QLog.isColorLevel()) {
          QLog.d("apollo_client_ApolloUrlInterceptor", 1, "task(" + this.jdField_b_of_type_JavaLangString + ") runDataTask error:network is not valid!");
        }
      }
      else
      {
        d();
      }
    }
  }
  
  private boolean c()
  {
    if ((this.jdField_g_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get()) || (this.jdField_e_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get()))
    {
      if (QLog.isColorLevel()) {
        QLog.d("apollo_client_ApolloUrlInterceptor", 2, "task(" + this.jdField_b_of_type_JavaLangString + ") canDestroy:false, isWaitingForSessionThread=" + this.jdField_g_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get() + ", isWaitingForBlinkCloseStream=" + this.jdField_e_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get() + " isWaitingForDestroy:" + this.jdField_f_of_type_JavaUtilConcurrentAtomicAtomicBoolean);
      }
      return false;
    }
    return true;
  }
  
  private void d()
  {
    Object localObject = null;
    long l1 = System.currentTimeMillis();
    this.jdField_a_of_type_ComTencentMobileqqApolloStoreWebviewApolloUrlConnection = new ApolloUrlConnection(this.jdField_e_of_type_JavaLangString, true, null, null);
    long l2 = System.currentTimeMillis();
    int j = this.jdField_a_of_type_ComTencentMobileqqApolloStoreWebviewApolloUrlConnection.a();
    int i = j;
    Map localMap;
    if (j == 0)
    {
      if (QLog.isColorLevel()) {
        QLog.d("apollo_client_ApolloUrlInterceptor", 2, "task(" + this.jdField_b_of_type_JavaLangString + ") connection connect cost = " + (System.currentTimeMillis() - l2) + " ms.");
      }
      l2 = System.currentTimeMillis();
      j = this.jdField_a_of_type_ComTencentMobileqqApolloStoreWebviewApolloUrlConnection.b();
      if (QLog.isColorLevel()) {
        QLog.d("apollo_client_ApolloUrlInterceptor", 2, "task(" + this.jdField_b_of_type_JavaLangString + ") connection response cost = " + (System.currentTimeMillis() - l2) + " ms.");
      }
      l2 = System.currentTimeMillis();
      localMap = this.jdField_a_of_type_ComTencentMobileqqApolloStoreWebviewApolloUrlConnection.a();
      if (QLog.isColorLevel()) {
        QLog.d("apollo_client_ApolloUrlInterceptor", 2, "task(" + this.jdField_b_of_type_JavaLangString + ") connection get header fields cost = " + (System.currentTimeMillis() - l2) + " ms.");
      }
      i = j;
      if (localMap != null)
      {
        if (!localMap.containsKey("Set-Cookie")) {
          break label410;
        }
        localObject = "Set-Cookie";
      }
    }
    label410:
    do
    {
      for (;;)
      {
        i = j;
        if (!TextUtils.isEmpty((CharSequence)localObject))
        {
          localObject = (List)localMap.get(localObject);
          ApolloClientUtil.a(this.jdField_e_of_type_JavaLangString, (List)localObject);
          i = j;
        }
        if (QLog.isColorLevel()) {
          QLog.d("apollo_client_ApolloUrlInterceptor", 4, "task(" + this.jdField_b_of_type_JavaLangString + ") handleFlow_Connection: respCode = " + i + ", cost " + (System.currentTimeMillis() - l1) + " ms.");
        }
        if (!b()) {
          break;
        }
        if (QLog.isColorLevel()) {
          QLog.d("apollo_client_ApolloUrlInterceptor", 6, "task(" + this.jdField_b_of_type_JavaLangString + ") handleFlow_Connection: destroy before server response.");
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
    QLog.d("apollo_client_ApolloUrlInterceptor", 4, "task(" + this.jdField_b_of_type_JavaLangString + ") handleFlow_Connection: response code not 200, response code = " + i);
    return;
    e();
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
    String str = null;
    int i = 2;
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqApolloStoreWebviewApolloUrlConnection.a(this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean, null);
    if (localObject == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("apollo_client_ApolloUrlInterceptor", 2, "task(" + this.jdField_b_of_type_JavaLangString + ") handleFlow_FirstLoad error:responseDataTuple is null!");
      }
      this.jdField_c_of_type_Boolean = true;
      this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(3);
      return;
    }
    this.jdField_a_of_type_JavaIoInputStream = new BridgeStream(this, ((ApolloUrlConnection.ResponseDataTuple)localObject).jdField_a_of_type_JavaIoByteArrayOutputStream, ((ApolloUrlConnection.ResponseDataTuple)localObject).jdField_a_of_type_JavaIoBufferedInputStream);
    if (((ApolloUrlConnection.ResponseDataTuple)localObject).jdField_a_of_type_Boolean) {}
    for (;;)
    {
      try
      {
        str = ((ApolloUrlConnection.ResponseDataTuple)localObject).jdField_a_of_type_JavaIoByteArrayOutputStream.toString("UTF-8");
      }
      catch (Throwable localThrowable1)
      {
        try
        {
          this.jdField_g_of_type_JavaLangString = str;
          if (TextUtils.isEmpty(str)) {
            break label399;
          }
          bool = true;
          if (QLog.isColorLevel()) {
            QLog.d("apollo_client_ApolloUrlInterceptor", 4, "task(" + this.jdField_b_of_type_JavaLangString + ") handleFlow_FirstLoad:hasCacheData=" + bool + ".");
          }
          this.jdField_a_of_type_AndroidOsHandler.removeMessages(1);
          localObject = this.jdField_a_of_type_AndroidOsHandler.obtainMessage(2);
          ((Message)localObject).obj = str;
          if (!bool) {
            break label404;
          }
          ((Message)localObject).arg1 = i;
          this.jdField_a_of_type_AndroidOsMessage = ((Message)localObject);
          this.jdField_a_of_type_AndroidOsHandler.sendMessage((Message)localObject);
          if ((!bool) || (this.jdField_a_of_type_Boolean)) {
            break;
          }
          long l = System.currentTimeMillis();
          ((ApolloWebDataHandlerImpl)QRoute.api(IApolloWebDataHandler.class)).saveHtml(this.jdField_e_of_type_JavaLangString, str);
          this.jdField_a_of_type_Boolean = true;
          if (!QLog.isColorLevel()) {
            break;
          }
          QLog.d("apollo_client_ApolloUrlInterceptor", 4, "task(" + this.jdField_b_of_type_JavaLangString + ") handleFlow_FirstLoad :save htmlString " + (System.currentTimeMillis() - l) + " ms.");
          return;
        }
        catch (Throwable localThrowable2)
        {
          boolean bool;
          break label337;
        }
        localThrowable1 = localThrowable1;
        str = null;
      }
      label337:
      this.jdField_a_of_type_JavaIoInputStream = null;
      if (QLog.isColorLevel()) {
        QLog.d("apollo_client_ApolloUrlInterceptor", 2, "task(" + this.jdField_b_of_type_JavaLangString + ") handleFlow_FirstLoad error:" + localThrowable1.getMessage() + ".");
      }
      continue;
      label399:
      bool = false;
      continue;
      label404:
      i = 1;
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
    //   1: getfield 354	com/tencent/mobileqq/apollo/store/webview/ApolloUrlInterceptor:jdField_c_of_type_Boolean	Z
    //   4: ifeq +5 -> 9
    //   7: aconst_null
    //   8: areturn
    //   9: ldc 173
    //   11: invokestatic 179	com/tencent/mobileqq/qroute/QRoute:api	(Ljava/lang/Class;)Lcom/tencent/mobileqq/qroute/QRouteApi;
    //   14: checkcast 181	com/tencent/mobileqq/apollo/api/handler/impl/ApolloWebDataHandlerImpl
    //   17: astore 5
    //   19: aload_0
    //   20: getfield 295	com/tencent/mobileqq/apollo/store/webview/ApolloUrlInterceptor:jdField_a_of_type_ComTencentBizPubaccountCustomWebView	Lcom/tencent/biz/pubaccount/CustomWebView;
    //   23: ifnull +64 -> 87
    //   26: aload 5
    //   28: aload_1
    //   29: invokevirtual 533	com/tencent/mobileqq/apollo/api/handler/impl/ApolloWebDataHandlerImpl:isCmdResourceUrl	(Ljava/lang/String;)Z
    //   32: ifeq +55 -> 87
    //   35: invokestatic 136	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   38: ifeq +29 -> 67
    //   41: ldc 138
    //   43: iconst_2
    //   44: new 140	java/lang/StringBuilder
    //   47: dup
    //   48: invokespecial 141	java/lang/StringBuilder:<init>	()V
    //   51: ldc_w 535
    //   54: invokevirtual 147	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   57: aload_1
    //   58: invokevirtual 147	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   61: invokevirtual 155	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   64: invokestatic 158	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   67: aload 5
    //   69: aload_1
    //   70: aload_0
    //   71: getfield 108	com/tencent/mobileqq/apollo/store/webview/ApolloUrlInterceptor:jdField_c_of_type_JavaLangString	Ljava/lang/String;
    //   74: invokevirtual 539	com/tencent/mobileqq/apollo/api/handler/impl/ApolloWebDataHandlerImpl:getApolloCmdResource	(Ljava/lang/String;Ljava/lang/String;)Lcom/tencent/smtt/export/external/interfaces/WebResourceResponse;
    //   77: astore 5
    //   79: aload 5
    //   81: ifnull +6 -> 87
    //   84: aload 5
    //   86: areturn
    //   87: aload_0
    //   88: getfield 295	com/tencent/mobileqq/apollo/store/webview/ApolloUrlInterceptor:jdField_a_of_type_ComTencentBizPubaccountCustomWebView	Lcom/tencent/biz/pubaccount/CustomWebView;
    //   91: ifnull +139 -> 230
    //   94: aload_0
    //   95: getfield 106	com/tencent/mobileqq/apollo/store/webview/ApolloUrlInterceptor:jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap	Ljava/util/concurrent/ConcurrentHashMap;
    //   98: invokevirtual 540	java/util/concurrent/ConcurrentHashMap:isEmpty	()Z
    //   101: ifne +129 -> 230
    //   104: aload_0
    //   105: getfield 106	com/tencent/mobileqq/apollo/store/webview/ApolloUrlInterceptor:jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap	Ljava/util/concurrent/ConcurrentHashMap;
    //   108: invokevirtual 325	java/util/concurrent/ConcurrentHashMap:values	()Ljava/util/Collection;
    //   111: invokeinterface 328 1 0
    //   116: astore 5
    //   118: aload 5
    //   120: invokeinterface 266 1 0
    //   125: ifeq +105 -> 230
    //   128: aload 5
    //   130: invokeinterface 270 1 0
    //   135: checkcast 276	com/tencent/mobileqq/apollo/store/webview/ApolloUrlInterceptor$PreloadCGITask
    //   138: astore 6
    //   140: aload_1
    //   141: aload 6
    //   143: invokestatic 543	com/tencent/mobileqq/apollo/store/webview/ApolloUrlInterceptor$PreloadCGITask:a	(Lcom/tencent/mobileqq/apollo/store/webview/ApolloUrlInterceptor$PreloadCGITask;)Lcom/tencent/mobileqq/apollo/store/webview/ApolloSSOConfig$CGIConfig;
    //   146: getfield 280	com/tencent/mobileqq/apollo/store/webview/ApolloSSOConfig$CGIConfig:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   149: invokevirtual 546	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   152: ifeq -34 -> 118
    //   155: aload 6
    //   157: aload_1
    //   158: invokevirtual 549	com/tencent/mobileqq/apollo/store/webview/ApolloUrlInterceptor$PreloadCGITask:a	(Ljava/lang/String;)Lcom/tencent/smtt/export/external/interfaces/WebResourceResponse;
    //   161: astore 7
    //   163: invokestatic 136	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   166: ifeq +40 -> 206
    //   169: ldc 138
    //   171: iconst_2
    //   172: new 140	java/lang/StringBuilder
    //   175: dup
    //   176: invokespecial 141	java/lang/StringBuilder:<init>	()V
    //   179: ldc_w 551
    //   182: invokevirtual 147	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   185: aload_1
    //   186: invokevirtual 147	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   189: ldc_w 553
    //   192: invokevirtual 147	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   195: aload 7
    //   197: invokevirtual 443	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   200: invokevirtual 155	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   203: invokestatic 158	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   206: aload_0
    //   207: getfield 106	com/tencent/mobileqq/apollo/store/webview/ApolloUrlInterceptor:jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap	Ljava/util/concurrent/ConcurrentHashMap;
    //   210: aload 6
    //   212: invokestatic 543	com/tencent/mobileqq/apollo/store/webview/ApolloUrlInterceptor$PreloadCGITask:a	(Lcom/tencent/mobileqq/apollo/store/webview/ApolloUrlInterceptor$PreloadCGITask;)Lcom/tencent/mobileqq/apollo/store/webview/ApolloSSOConfig$CGIConfig;
    //   215: getfield 280	com/tencent/mobileqq/apollo/store/webview/ApolloSSOConfig$CGIConfig:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   218: invokevirtual 556	java/util/concurrent/ConcurrentHashMap:remove	(Ljava/lang/Object;)Ljava/lang/Object;
    //   221: pop
    //   222: aload 7
    //   224: ifnull -106 -> 118
    //   227: aload 7
    //   229: areturn
    //   230: aload_0
    //   231: aload_1
    //   232: invokevirtual 558	com/tencent/mobileqq/apollo/store/webview/ApolloUrlInterceptor:a	(Ljava/lang/String;)Z
    //   235: ifne +49 -> 284
    //   238: invokestatic 136	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   241: ifeq -234 -> 7
    //   244: ldc 138
    //   246: iconst_2
    //   247: new 140	java/lang/StringBuilder
    //   250: dup
    //   251: invokespecial 141	java/lang/StringBuilder:<init>	()V
    //   254: ldc 143
    //   256: invokevirtual 147	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   259: aload_0
    //   260: getfield 116	com/tencent/mobileqq/apollo/store/webview/ApolloUrlInterceptor:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   263: invokevirtual 147	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   266: ldc_w 560
    //   269: invokevirtual 147	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   272: aload_1
    //   273: invokevirtual 147	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   276: invokevirtual 155	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   279: invokestatic 158	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   282: aconst_null
    //   283: areturn
    //   284: aload_0
    //   285: getfield 67	com/tencent/mobileqq/apollo/store/webview/ApolloUrlInterceptor:jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   288: invokevirtual 348	java/util/concurrent/atomic/AtomicBoolean:get	()Z
    //   291: ifeq +47 -> 338
    //   294: invokestatic 136	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   297: ifeq +41 -> 338
    //   300: ldc 138
    //   302: iconst_2
    //   303: new 140	java/lang/StringBuilder
    //   306: dup
    //   307: invokespecial 141	java/lang/StringBuilder:<init>	()V
    //   310: ldc 143
    //   312: invokevirtual 147	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   315: aload_0
    //   316: getfield 116	com/tencent/mobileqq/apollo/store/webview/ApolloUrlInterceptor:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   319: invokevirtual 147	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   322: ldc_w 562
    //   325: invokevirtual 147	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   328: aload_1
    //   329: invokevirtual 147	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   332: invokevirtual 155	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   335: invokestatic 158	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   338: aload_0
    //   339: getfield 67	com/tencent/mobileqq/apollo/store/webview/ApolloUrlInterceptor:jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   342: iconst_0
    //   343: iconst_1
    //   344: invokevirtual 335	java/util/concurrent/atomic/AtomicBoolean:compareAndSet	(ZZ)Z
    //   347: ifne +47 -> 394
    //   350: invokestatic 136	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   353: ifeq +41 -> 394
    //   356: ldc 138
    //   358: iconst_2
    //   359: new 140	java/lang/StringBuilder
    //   362: dup
    //   363: invokespecial 141	java/lang/StringBuilder:<init>	()V
    //   366: ldc 143
    //   368: invokevirtual 147	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   371: aload_0
    //   372: getfield 116	com/tencent/mobileqq/apollo/store/webview/ApolloUrlInterceptor:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   375: invokevirtual 147	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   378: ldc_w 564
    //   381: invokevirtual 147	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   384: aload_1
    //   385: invokevirtual 147	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   388: invokevirtual 155	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   391: invokestatic 158	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   394: invokestatic 136	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   397: ifeq +41 -> 438
    //   400: ldc 138
    //   402: iconst_2
    //   403: new 140	java/lang/StringBuilder
    //   406: dup
    //   407: invokespecial 141	java/lang/StringBuilder:<init>	()V
    //   410: ldc 143
    //   412: invokevirtual 147	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   415: aload_0
    //   416: getfield 116	com/tencent/mobileqq/apollo/store/webview/ApolloUrlInterceptor:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   419: invokevirtual 147	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   422: ldc_w 566
    //   425: invokevirtual 147	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   428: aload_1
    //   429: invokevirtual 147	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   432: invokevirtual 155	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   435: invokestatic 158	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   438: invokestatic 165	java/lang/System:currentTimeMillis	()J
    //   441: lstore_2
    //   442: aload_0
    //   443: getfield 60	com/tencent/mobileqq/apollo/store/webview/ApolloUrlInterceptor:jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger	Ljava/util/concurrent/atomic/AtomicInteger;
    //   446: invokevirtual 293	java/util/concurrent/atomic/AtomicInteger:get	()I
    //   449: iconst_1
    //   450: if_icmpne +357 -> 807
    //   453: aload_0
    //   454: getfield 60	com/tencent/mobileqq/apollo/store/webview/ApolloUrlInterceptor:jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger	Ljava/util/concurrent/atomic/AtomicInteger;
    //   457: astore_1
    //   458: aload_1
    //   459: monitorenter
    //   460: aload_0
    //   461: getfield 60	com/tencent/mobileqq/apollo/store/webview/ApolloUrlInterceptor:jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger	Ljava/util/concurrent/atomic/AtomicInteger;
    //   464: invokevirtual 293	java/util/concurrent/atomic/AtomicInteger:get	()I
    //   467: iconst_1
    //   468: if_icmpne +53 -> 521
    //   471: invokestatic 136	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   474: ifeq +37 -> 511
    //   477: ldc 138
    //   479: iconst_2
    //   480: new 140	java/lang/StringBuilder
    //   483: dup
    //   484: invokespecial 141	java/lang/StringBuilder:<init>	()V
    //   487: ldc 143
    //   489: invokevirtual 147	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   492: aload_0
    //   493: getfield 116	com/tencent/mobileqq/apollo/store/webview/ApolloUrlInterceptor:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   496: invokevirtual 147	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   499: ldc_w 568
    //   502: invokevirtual 147	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   505: invokevirtual 155	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   508: invokestatic 158	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   511: aload_0
    //   512: getfield 60	com/tencent/mobileqq/apollo/store/webview/ApolloUrlInterceptor:jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger	Ljava/util/concurrent/atomic/AtomicInteger;
    //   515: ldc2_w 569
    //   518: invokevirtual 574	java/lang/Object:wait	(J)V
    //   521: aload_1
    //   522: monitorexit
    //   523: invokestatic 136	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   526: ifeq +74 -> 600
    //   529: new 140	java/lang/StringBuilder
    //   532: dup
    //   533: invokespecial 141	java/lang/StringBuilder:<init>	()V
    //   536: ldc 143
    //   538: invokevirtual 147	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   541: aload_0
    //   542: getfield 116	com/tencent/mobileqq/apollo/store/webview/ApolloUrlInterceptor:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   545: invokevirtual 147	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   548: ldc_w 576
    //   551: invokevirtual 147	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   554: astore_1
    //   555: aload_0
    //   556: getfield 297	com/tencent/mobileqq/apollo/store/webview/ApolloUrlInterceptor:jdField_a_of_type_JavaIoInputStream	Ljava/io/InputStream;
    //   559: ifnull +298 -> 857
    //   562: iconst_1
    //   563: istore 4
    //   565: ldc 138
    //   567: iconst_2
    //   568: aload_1
    //   569: iload 4
    //   571: invokevirtual 196	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   574: ldc_w 481
    //   577: invokevirtual 147	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   580: invokestatic 165	java/lang/System:currentTimeMillis	()J
    //   583: lload_2
    //   584: lsub
    //   585: invokevirtual 201	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   588: ldc_w 578
    //   591: invokevirtual 147	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   594: invokevirtual 155	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   597: invokestatic 158	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   600: aload_0
    //   601: getfield 297	com/tencent/mobileqq/apollo/store/webview/ApolloUrlInterceptor:jdField_a_of_type_JavaIoInputStream	Ljava/io/InputStream;
    //   604: ifnonnull +54 -> 658
    //   607: aload_0
    //   608: getfield 299	com/tencent/mobileqq/apollo/store/webview/ApolloUrlInterceptor:jdField_g_of_type_JavaLangString	Ljava/lang/String;
    //   611: invokestatic 171	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   614: ifne +44 -> 658
    //   617: aload_0
    //   618: new 580	java/io/ByteArrayInputStream
    //   621: dup
    //   622: aload_0
    //   623: getfield 299	com/tencent/mobileqq/apollo/store/webview/ApolloUrlInterceptor:jdField_g_of_type_JavaLangString	Ljava/lang/String;
    //   626: ldc_w 512
    //   629: invokevirtual 584	java/lang/String:getBytes	(Ljava/lang/String;)[B
    //   632: invokespecial 587	java/io/ByteArrayInputStream:<init>	([B)V
    //   635: putfield 297	com/tencent/mobileqq/apollo/store/webview/ApolloUrlInterceptor:jdField_a_of_type_JavaIoInputStream	Ljava/io/InputStream;
    //   638: aload_0
    //   639: iconst_1
    //   640: putfield 589	com/tencent/mobileqq/apollo/store/webview/ApolloUrlInterceptor:jdField_d_of_type_Boolean	Z
    //   643: invokestatic 136	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   646: ifeq +12 -> 658
    //   649: ldc 138
    //   651: iconst_2
    //   652: ldc_w 591
    //   655: invokestatic 158	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   658: aload_0
    //   659: getfield 297	com/tencent/mobileqq/apollo/store/webview/ApolloUrlInterceptor:jdField_a_of_type_JavaIoInputStream	Ljava/io/InputStream;
    //   662: ifnull +236 -> 898
    //   665: aload_0
    //   666: invokespecial 445	com/tencent/mobileqq/apollo/store/webview/ApolloUrlInterceptor:b	()Z
    //   669: ifne +209 -> 878
    //   672: new 593	com/tencent/smtt/export/external/interfaces/WebResourceResponse
    //   675: dup
    //   676: aload_0
    //   677: getfield 130	com/tencent/mobileqq/apollo/store/webview/ApolloUrlInterceptor:jdField_e_of_type_JavaLangString	Ljava/lang/String;
    //   680: invokestatic 595	com/tencent/mobileqq/apollo/store/webview/ApolloClientUtil:a	(Ljava/lang/String;)Ljava/lang/String;
    //   683: ldc_w 597
    //   686: aload_0
    //   687: getfield 297	com/tencent/mobileqq/apollo/store/webview/ApolloUrlInterceptor:jdField_a_of_type_JavaIoInputStream	Ljava/io/InputStream;
    //   690: invokespecial 600	com/tencent/smtt/export/external/interfaces/WebResourceResponse:<init>	(Ljava/lang/String;Ljava/lang/String;Ljava/io/InputStream;)V
    //   693: astore_1
    //   694: aload_0
    //   695: getfield 75	com/tencent/mobileqq/apollo/store/webview/ApolloUrlInterceptor:jdField_e_of_type_JavaUtilConcurrentAtomicAtomicBoolean	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   698: iconst_1
    //   699: invokevirtual 317	java/util/concurrent/atomic/AtomicBoolean:set	(Z)V
    //   702: aload_0
    //   703: getfield 589	com/tencent/mobileqq/apollo/store/webview/ApolloUrlInterceptor:jdField_d_of_type_Boolean	Z
    //   706: ifeq +8 -> 714
    //   709: aload_0
    //   710: iconst_0
    //   711: putfield 589	com/tencent/mobileqq/apollo/store/webview/ApolloUrlInterceptor:jdField_d_of_type_Boolean	Z
    //   714: invokestatic 136	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   717: ifeq +29 -> 746
    //   720: ldc 138
    //   722: iconst_2
    //   723: new 140	java/lang/StringBuilder
    //   726: dup
    //   727: invokespecial 141	java/lang/StringBuilder:<init>	()V
    //   730: ldc_w 602
    //   733: invokevirtual 147	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   736: aload_1
    //   737: invokevirtual 443	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   740: invokevirtual 155	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   743: invokestatic 158	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   746: aload_0
    //   747: aconst_null
    //   748: putfield 297	com/tencent/mobileqq/apollo/store/webview/ApolloUrlInterceptor:jdField_a_of_type_JavaIoInputStream	Ljava/io/InputStream;
    //   751: aload_1
    //   752: areturn
    //   753: astore 5
    //   755: ldc 138
    //   757: iconst_2
    //   758: new 140	java/lang/StringBuilder
    //   761: dup
    //   762: invokespecial 141	java/lang/StringBuilder:<init>	()V
    //   765: ldc 143
    //   767: invokevirtual 147	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   770: aload_0
    //   771: getfield 116	com/tencent/mobileqq/apollo/store/webview/ApolloUrlInterceptor:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   774: invokevirtual 147	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   777: ldc_w 604
    //   780: invokevirtual 147	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   783: aload 5
    //   785: invokevirtual 528	java/lang/Throwable:getMessage	()Ljava/lang/String;
    //   788: invokevirtual 147	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   791: invokevirtual 155	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   794: invokestatic 606	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   797: goto -276 -> 521
    //   800: astore 5
    //   802: aload_1
    //   803: monitorexit
    //   804: aload 5
    //   806: athrow
    //   807: invokestatic 136	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   810: ifeq -287 -> 523
    //   813: ldc 138
    //   815: iconst_2
    //   816: new 140	java/lang/StringBuilder
    //   819: dup
    //   820: invokespecial 141	java/lang/StringBuilder:<init>	()V
    //   823: ldc 143
    //   825: invokevirtual 147	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   828: aload_0
    //   829: getfield 116	com/tencent/mobileqq/apollo/store/webview/ApolloUrlInterceptor:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   832: invokevirtual 147	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   835: ldc_w 608
    //   838: invokevirtual 147	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   841: aload_0
    //   842: getfield 60	com/tencent/mobileqq/apollo/store/webview/ApolloUrlInterceptor:jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger	Ljava/util/concurrent/atomic/AtomicInteger;
    //   845: invokevirtual 443	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   848: invokevirtual 155	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   851: invokestatic 158	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   854: goto -331 -> 523
    //   857: iconst_0
    //   858: istore 4
    //   860: goto -295 -> 565
    //   863: astore_1
    //   864: ldc 138
    //   866: iconst_2
    //   867: aload_1
    //   868: iconst_0
    //   869: anewarray 4	java/lang/Object
    //   872: invokestatic 611	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/Throwable;[Ljava/lang/Object;)V
    //   875: goto -232 -> 643
    //   878: invokestatic 136	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   881: ifeq +12 -> 893
    //   884: ldc 138
    //   886: iconst_2
    //   887: ldc_w 613
    //   890: invokestatic 158	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   893: aconst_null
    //   894: astore_1
    //   895: goto -193 -> 702
    //   898: invokestatic 136	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   901: ifeq -894 -> 7
    //   904: ldc 138
    //   906: iconst_2
    //   907: ldc_w 615
    //   910: invokestatic 158	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   913: aconst_null
    //   914: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	915	0	this	ApolloUrlInterceptor
    //   0	915	1	paramString	String
    //   441	143	2	l	long
    //   563	296	4	bool	boolean
    //   17	112	5	localObject1	Object
    //   753	31	5	localThrowable	Throwable
    //   800	5	5	localObject2	Object
    //   138	73	6	localPreloadCGITask	ApolloUrlInterceptor.PreloadCGITask
    //   161	67	7	localWebResourceResponse	com.tencent.smtt.export.external.interfaces.WebResourceResponse
    // Exception table:
    //   from	to	target	type
    //   460	511	753	java/lang/Throwable
    //   511	521	753	java/lang/Throwable
    //   460	511	800	finally
    //   511	521	800	finally
    //   521	523	800	finally
    //   755	797	800	finally
    //   802	804	800	finally
    //   617	643	863	java/lang/Throwable
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
        QLog.d("apollo_client_ApolloUrlInterceptor", 2, "task(" + this.jdField_b_of_type_JavaLangString + ") start error:sessionState=" + this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.get() + ".");
      }
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("apollo_client_ApolloUrlInterceptor", 2, "task(" + this.jdField_b_of_type_JavaLangString + ") now post task flow task.");
    }
    this.jdField_g_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(true);
    if (paramBoolean)
    {
      ThreadManager.postImmediately(new ApolloUrlInterceptor.2(this), null, true);
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("apollo_client_ApolloUrlInterceptor", 2, "runDataTask in AsyncThread start!");
    }
    ApolloWebStatistics localApolloWebStatistics = this.jdField_a_of_type_ComTencentMobileqqApolloStoreWebviewApolloWebStatistics;
    long l = System.currentTimeMillis();
    localApolloWebStatistics.g = l;
    b();
    c();
    if (QLog.isColorLevel()) {
      QLog.d("apollo_client_ApolloUrlInterceptor", 2, "runDataTask use:" + (System.currentTimeMillis() - l));
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
      QLog.d("apollo_client_ApolloUrlInterceptor", 1, "task(" + this.jdField_b_of_type_JavaLangString + ") onClose:readComplete:" + paramBoolean);
    }
    long l = System.currentTimeMillis();
    if ((paramBoolean) && (paramByteArrayOutputStream != null))
    {
      ThreadManager.getSubThreadHandler().postDelayed(new ApolloUrlInterceptor.3(this, paramByteArrayOutputStream), 3000L);
      return;
    }
    StringBuilder localStringBuilder;
    if (QLog.isColorLevel())
    {
      localStringBuilder = new StringBuilder().append("task(").append(this.jdField_b_of_type_JavaLangString).append(") onClose error:readComplete =").append(paramBoolean).append(", outputStream is null -> ");
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
        QLog.d("apollo_client_ApolloUrlInterceptor", 2, "task(" + this.jdField_b_of_type_JavaLangString + ") onClose: postForceDestroyIfNeed send destroy message in chromium_io thread.");
      }
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d("apollo_client_ApolloUrlInterceptor", 6, "task(" + this.jdField_b_of_type_JavaLangString + ") onClose cost " + (System.currentTimeMillis() - l) + " ms.");
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
      QLog.d("apollo_client_ApolloUrlInterceptor", 2, "task(" + this.jdField_b_of_type_JavaLangString + ") bind client.");
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
      this.jdField_e_of_type_JavaLangString = ApolloClientUtil.a(paramString, "apollo_task_id", String.valueOf(this.jdField_b_of_type_JavaLangString));
      this.jdField_a_of_type_ComTencentMobileqqApolloStoreWebviewApolloWebStatistics.i = System.currentTimeMillis();
      if (QLog.isColorLevel())
      {
        paramString = new StringBuilder().append("task(").append(this.jdField_b_of_type_JavaLangString).append(") onWebViewInited: mPendingClientCoreMessage not null:");
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
        QLog.d("apollo_client_ApolloUrlInterceptor", 2, "task(" + this.jdField_b_of_type_JavaLangString + ") handleMessage:force destroy.");
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
      QLog.d("apollo_client_ApolloUrlInterceptor", 2, "task(" + this.jdField_b_of_type_JavaLangString + ") handleMessage error: is destroyed or waiting for destroy.");
      return false;
      if (QLog.isColorLevel()) {
        QLog.d("apollo_client_ApolloUrlInterceptor", 2, "task(" + this.jdField_b_of_type_JavaLangString + ") handleMessage: msg what = " + paramMessage.what + ".");
      }
      if ((paramMessage.what > 0) && (paramMessage.what < 7) && (!this.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get()))
      {
        this.jdField_a_of_type_AndroidOsMessage = Message.obtain(paramMessage);
        if (QLog.isColorLevel()) {
          QLog.d("apollo_client_ApolloUrlInterceptor", 2, "task(" + this.jdField_b_of_type_JavaLangString + ") handleMessage: client not ready, core msg = " + paramMessage.what + ".");
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
          QLog.d("apollo_client_ApolloUrlInterceptor", 2, "task(" + this.jdField_b_of_type_JavaLangString + ") handleClientCoreMessage_PreLoad:PRE_LOAD_NO_CACHE load url.");
        }
        this.jdField_a_of_type_ComTencentMobileqqApolloStoreWebviewApolloWebStatistics.j = System.currentTimeMillis();
        if (this.jdField_a_of_type_ComTencentBizPubaccountCustomWebView != null) {
          this.jdField_a_of_type_ComTencentBizPubaccountCustomWebView.loadUrlOriginal(this.jdField_e_of_type_JavaLangString);
        }
      }
    }
    for (;;)
    {
      return true;
      if (QLog.isColorLevel())
      {
        QLog.d("apollo_client_ApolloUrlInterceptor", 2, "task(" + this.jdField_b_of_type_JavaLangString + ") handleClientCoreMessage_PreLoad:wasLoadUrlInvoked = true.");
        continue;
        if (paramMessage.arg1 == 2) {
          if (this.jdField_d_of_type_JavaUtilConcurrentAtomicAtomicBoolean.compareAndSet(false, true))
          {
            if (QLog.isColorLevel()) {
              QLog.d("apollo_client_ApolloUrlInterceptor", 2, "task(" + this.jdField_b_of_type_JavaLangString + ") handleClientCoreMessage_PreLoad:PRE_LOAD_WITH_CACHE load data.");
            }
            paramMessage = (String)paramMessage.obj;
            this.jdField_a_of_type_ComTencentMobileqqApolloStoreWebviewApolloWebStatistics.j = System.currentTimeMillis();
            if (this.jdField_a_of_type_ComTencentBizPubaccountCustomWebView != null) {
              if (this.jdField_a_of_type_ComTencentBizPubaccountCustomWebView.getX5WebViewExtension() != null)
              {
                this.jdField_a_of_type_ComTencentBizPubaccountCustomWebView.loadDataWithBaseURL(this.jdField_e_of_type_JavaLangString, paramMessage, "text/html", "utf-8", this.jdField_e_of_type_JavaLangString);
              }
              else
              {
                this.jdField_a_of_type_ComTencentBizPubaccountCustomWebView.loadUrlOriginal(this.jdField_e_of_type_JavaLangString);
                QLog.e("apollo_client_ApolloUrlInterceptor", 1, "handleMessage CLIENT_CORE_MSG_PRE_LOAD PRE_LOAD_WITH_CACHE but not x5 Core");
              }
            }
          }
          else if (QLog.isColorLevel())
          {
            QLog.d("apollo_client_ApolloUrlInterceptor", 2, "task(" + this.jdField_b_of_type_JavaLangString + ") handleClientCoreMessage_PreLoad:wasLoadDataInvoked = true.");
            continue;
            if (paramMessage.arg1 == 1)
            {
              if (this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get())
              {
                if (QLog.isColorLevel()) {
                  QLog.d("apollo_client_ApolloUrlInterceptor", 2, "task(" + this.jdField_b_of_type_JavaLangString + ") handleClientCoreMessage_FirstLoad:FIRST_LOAD_NO_CACHE.");
                }
              }
              else if (QLog.isColorLevel()) {
                QLog.d("apollo_client_ApolloUrlInterceptor", 2, "task(" + this.jdField_b_of_type_JavaLangString + ") handleClientCoreMessage_FirstLoad:url was not invoked.");
              }
            }
            else if (paramMessage.arg1 == 2) {
              if (this.jdField_c_of_type_JavaUtilConcurrentAtomicAtomicBoolean.compareAndSet(false, true))
              {
                if (QLog.isColorLevel()) {
                  QLog.d("apollo_client_ApolloUrlInterceptor", 2, "task(\" + id + \") handleClientCoreMessage_FirstLoad with cache, url:" + this.jdField_e_of_type_JavaLangString);
                }
                this.jdField_d_of_type_Boolean = true;
                this.jdField_a_of_type_ComTencentMobileqqApolloStoreWebviewApolloWebStatistics.j = System.currentTimeMillis();
                if (this.jdField_a_of_type_ComTencentBizPubaccountCustomWebView != null) {
                  if (this.jdField_a_of_type_ComTencentBizPubaccountCustomWebView.getX5WebViewExtension() != null)
                  {
                    this.jdField_a_of_type_ComTencentBizPubaccountCustomWebView.loadDataWithBaseURL(this.jdField_e_of_type_JavaLangString, (String)paramMessage.obj, "text/html", "utf-8", this.jdField_e_of_type_JavaLangString);
                  }
                  else
                  {
                    this.jdField_a_of_type_ComTencentBizPubaccountCustomWebView.loadUrlOriginal(this.jdField_e_of_type_JavaLangString);
                    QLog.e("apollo_client_ApolloUrlInterceptor", 1, "handleMessage CLIENT_CORE_MSG_FIRST_LOAD PRE_LOAD_WITH_CACHE but not x5 Core");
                  }
                }
              }
              else if (QLog.isColorLevel())
              {
                QLog.d("apollo_client_ApolloUrlInterceptor", 2, "task(" + this.jdField_b_of_type_JavaLangString + ") FIRST_LOAD_WITH_CACHE load url was invoked.");
                continue;
                if (this.jdField_c_of_type_JavaUtilConcurrentAtomicAtomicBoolean.compareAndSet(false, true))
                {
                  if (QLog.isColorLevel()) {
                    QLog.d("apollo_client_ApolloUrlInterceptor", 2, "handleClientCoreMessage_ConnectionError: load src url.");
                  }
                  if (this.jdField_a_of_type_ComTencentBizPubaccountCustomWebView != null)
                  {
                    this.jdField_a_of_type_ComTencentBizPubaccountCustomWebView.loadUrlOriginal(this.jdField_e_of_type_JavaLangString);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.store.webview.ApolloUrlInterceptor
 * JD-Core Version:    0.7.0.1
 */