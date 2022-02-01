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
import com.tencent.mobileqq.apollo.handler.api.IApolloWebDataHandler;
import com.tencent.mobileqq.apollo.handler.api.impl.ApolloWebDataHandlerImpl;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.smtt.export.external.interfaces.WebResourceResponse;
import java.io.ByteArrayInputStream;
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
    jdField_a_of_type_JavaLangString = HardCodeUtil.a(2131700744);
  }
  
  public ApolloUrlInterceptor(String paramString1, String paramString2)
  {
    this.jdField_c_of_type_JavaLangString = paramString2;
    long l = jdField_a_of_type_Long;
    jdField_a_of_type_Long = 1L + l;
    this.jdField_b_of_type_JavaLangString = String.valueOf(l);
    this.jdField_d_of_type_JavaLangString = ApolloClientUtil.a(paramString1, "apollo_task_id", String.valueOf(this.jdField_b_of_type_JavaLangString));
    this.jdField_e_of_type_JavaLangString = this.jdField_d_of_type_JavaLangString;
    if (QLog.isColorLevel())
    {
      paramString2 = new StringBuilder();
      paramString2.append("task(");
      paramString2.append(this.jdField_b_of_type_JavaLangString);
      paramString2.append(") create:id=");
      paramString2.append(this.jdField_b_of_type_JavaLangString);
      paramString2.append(", url = ");
      paramString2.append(paramString1);
      QLog.d("[cmshow]apollo_client_ApolloUrlInterceptor", 2, paramString2.toString());
    }
  }
  
  public static ApolloUrlInterceptor a(boolean paramBoolean, String paramString)
  {
    long l = System.currentTimeMillis();
    if (!TextUtils.isEmpty(paramString))
    {
      Object localObject = (ApolloWebDataHandlerImpl)QRoute.api(IApolloWebDataHandler.class);
      String str = ((ApolloWebDataHandlerImpl)localObject).getApolloClientId(paramString);
      if (((ApolloWebDataHandlerImpl)localObject).isApolloClientId(str))
      {
        paramString = new ApolloUrlInterceptor(paramString, str);
        if (QLog.isColorLevel())
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("createInterceptor startSessionNewThread:");
          ((StringBuilder)localObject).append(paramBoolean);
          ((StringBuilder)localObject).append(",use:");
          ((StringBuilder)localObject).append(System.currentTimeMillis() - l);
          QLog.d("[cmshow]apollo_client_ApolloUrlInterceptor", 2, ((StringBuilder)localObject).toString());
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
      return true;
    }
    return false;
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
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("preloadSSOData use:");
      ((StringBuilder)localObject1).append(System.currentTimeMillis() - l);
      QLog.d("[cmshow]apollo_client_ApolloUrlInterceptor", 2, ((StringBuilder)localObject1).toString());
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
      if ((!paramBoolean) && (!c()))
      {
        this.jdField_a_of_type_AndroidOsHandler.removeMessages(255);
        if (this.jdField_f_of_type_JavaUtilConcurrentAtomicAtomicBoolean.compareAndSet(false, true))
        {
          this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(10, 6000L);
          if (QLog.isColorLevel())
          {
            ??? = new StringBuilder();
            ((StringBuilder)???).append("task(");
            ((StringBuilder)???).append(this.jdField_b_of_type_JavaLangString);
            ((StringBuilder)???).append(") waiting for destroy, current state =");
            ((StringBuilder)???).append(i);
            ((StringBuilder)???).append(".");
            QLog.d("[cmshow]apollo_client_ApolloUrlInterceptor", 2, ((StringBuilder)???).toString());
          }
        }
      }
      else
      {
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
          if (QLog.isColorLevel())
          {
            ??? = new StringBuilder();
            ((StringBuilder)???).append("task(");
            ((StringBuilder)???).append(this.jdField_b_of_type_JavaLangString);
            ((StringBuilder)???).append(") final destroy, force=");
            ((StringBuilder)???).append(paramBoolean);
            ((StringBuilder)???).append(".");
            QLog.d("[cmshow]apollo_client_ApolloUrlInterceptor", 2, ((StringBuilder)???).toString());
          }
          this.jdField_a_of_type_AndroidOsHandler.removeMessages(255);
          ??? = this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.values().iterator();
          while (((Iterator)???).hasNext()) {
            ((ApolloUrlInterceptor.PreloadCGITask)((Iterator)???).next()).a();
          }
          this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.clear();
          return;
        }
      }
    }
  }
  
  private boolean b()
  {
    return (3 == this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.get()) || (this.jdField_f_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get());
  }
  
  private void c()
  {
    if (1 != this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.get())
    {
      if (QLog.isColorLevel())
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("task(");
        ((StringBuilder)localObject1).append(this.jdField_b_of_type_JavaLangString);
        ((StringBuilder)localObject1).append(") runDataTask error:sessionState=");
        ((StringBuilder)localObject1).append(this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.get());
        ((StringBuilder)localObject1).append(".");
        QLog.d("[cmshow]apollo_client_ApolloUrlInterceptor", 2, ((StringBuilder)localObject1).toString());
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
      if (QLog.isColorLevel())
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("task(");
        ((StringBuilder)localObject1).append(this.jdField_b_of_type_JavaLangString);
        ((StringBuilder)localObject1).append(") runDataTask error:fileName is null");
        QLog.d("[cmshow]apollo_client_ApolloUrlInterceptor", 2, ((StringBuilder)localObject1).toString());
      }
      this.jdField_c_of_type_Boolean = true;
      this.jdField_g_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(false);
      this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(3);
      return;
    }
    Object localObject1 = ApolloClientUtil.d(this.jdField_f_of_type_JavaLangString);
    if (QLog.isColorLevel())
    {
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("task(");
      ((StringBuilder)localObject2).append(this.jdField_b_of_type_JavaLangString);
      ((StringBuilder)localObject2).append(") runDataTask url is ");
      ((StringBuilder)localObject2).append(this.jdField_e_of_type_JavaLangString);
      ((StringBuilder)localObject2).append(" filePath is ");
      ((StringBuilder)localObject2).append((String)localObject1);
      QLog.d("[cmshow]apollo_client_ApolloUrlInterceptor", 2, ((StringBuilder)localObject2).toString());
    }
    Object localObject2 = new File((String)localObject1);
    localObject1 = ApolloClientUtil.a((File)localObject2);
    this.jdField_a_of_type_ComTencentMobileqqApolloStoreWebviewApolloWebStatistics.e = (System.currentTimeMillis() - l1);
    boolean bool1 = TextUtils.isEmpty((CharSequence)localObject1) ^ true;
    boolean bool2;
    if (bool1)
    {
      long l2 = System.currentTimeMillis();
      if (!((ApolloWebDataHandlerImpl)QRoute.api(IApolloWebDataHandler.class)).verifyCache(this.jdField_c_of_type_JavaLangString, (String)localObject1))
      {
        localObject1 = null;
        ((File)localObject2).delete();
        if (QLog.isColorLevel())
        {
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append("task(");
          ((StringBuilder)localObject2).append(this.jdField_b_of_type_JavaLangString);
          ((StringBuilder)localObject2).append(") runDataTask md5 not match delete localFile! url is ");
          ((StringBuilder)localObject2).append(this.jdField_e_of_type_JavaLangString);
          QLog.d("[cmshow]apollo_client_ApolloUrlInterceptor", 2, ((StringBuilder)localObject2).toString());
        }
        this.jdField_a_of_type_ComTencentMobileqqApolloStoreWebviewApolloWebStatistics.a = 1;
        bool1 = false;
      }
      else
      {
        this.jdField_a_of_type_ComTencentMobileqqApolloStoreWebviewApolloWebStatistics.a = 2;
      }
      this.jdField_a_of_type_ComTencentMobileqqApolloStoreWebviewApolloWebStatistics.f = (System.currentTimeMillis() - l2);
      localObject2 = localObject1;
      bool2 = bool1;
      if (QLog.isColorLevel())
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("verify use:");
        ((StringBuilder)localObject2).append(System.currentTimeMillis() - l2);
        QLog.d("[cmshow]apollo_client_ApolloUrlInterceptor", 2, ((StringBuilder)localObject2).toString());
        localObject2 = localObject1;
        bool2 = bool1;
      }
    }
    else
    {
      this.jdField_a_of_type_ComTencentMobileqqApolloStoreWebviewApolloWebStatistics.a = 0;
      bool2 = bool1;
      localObject2 = localObject1;
    }
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("get LocalFile use:");
      ((StringBuilder)localObject1).append(System.currentTimeMillis() - l1);
      QLog.d("[cmshow]apollo_client_ApolloUrlInterceptor", 2, ((StringBuilder)localObject1).toString());
    }
    localObject1 = this.jdField_a_of_type_AndroidOsHandler.obtainMessage(1);
    this.jdField_a_of_type_AndroidOsMessage = ((Message)localObject1);
    if (bool2)
    {
      ((Message)localObject1).arg1 = 2;
      ((Message)localObject1).obj = localObject2;
      this.jdField_a_of_type_AndroidOsHandler.sendMessage((Message)localObject1);
      if (QLog.isColorLevel())
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("task(");
        ((StringBuilder)localObject1).append(this.jdField_b_of_type_JavaLangString);
        ((StringBuilder)localObject1).append(") runDataTask hasHtmlCache:");
        ((StringBuilder)localObject1).append(bool2);
        QLog.d("[cmshow]apollo_client_ApolloUrlInterceptor", 2, ((StringBuilder)localObject1).toString());
      }
      this.jdField_g_of_type_JavaLangString = ((String)localObject2);
    }
    else
    {
      if (QLog.isColorLevel())
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("task(");
        ((StringBuilder)localObject2).append(this.jdField_b_of_type_JavaLangString);
        ((StringBuilder)localObject2).append(") runDataTask has no cache, do first load flow.");
        QLog.d("[cmshow]apollo_client_ApolloUrlInterceptor", 2, ((StringBuilder)localObject2).toString());
      }
      ((Message)localObject1).arg1 = 1;
      this.jdField_a_of_type_AndroidOsHandler.sendMessage((Message)localObject1);
      if (!NetworkUtil.isNetworkAvailable(BaseApplicationImpl.getContext()))
      {
        if (!TextUtils.isEmpty(jdField_a_of_type_JavaLangString)) {
          this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(255, 1500L);
        }
        if (QLog.isColorLevel())
        {
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append("task(");
          ((StringBuilder)localObject1).append(this.jdField_b_of_type_JavaLangString);
          ((StringBuilder)localObject1).append(") runDataTask error:network is not valid!");
          QLog.d("[cmshow]apollo_client_ApolloUrlInterceptor", 1, ((StringBuilder)localObject1).toString());
        }
      }
      else
      {
        d();
      }
    }
    a(1, 2, true);
    this.jdField_g_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(false);
    if ((d()) && (QLog.isColorLevel()))
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("task(");
      ((StringBuilder)localObject1).append(this.jdField_b_of_type_JavaLangString);
      ((StringBuilder)localObject1).append(") runDataTask:send force destroy message.");
      QLog.d("[cmshow]apollo_client_ApolloUrlInterceptor", 4, ((StringBuilder)localObject1).toString());
    }
  }
  
  private boolean c()
  {
    if ((!this.jdField_g_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get()) && (!this.jdField_e_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get())) {
      return true;
    }
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("task(");
      localStringBuilder.append(this.jdField_b_of_type_JavaLangString);
      localStringBuilder.append(") canDestroy:false, isWaitingForSessionThread=");
      localStringBuilder.append(this.jdField_g_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get());
      localStringBuilder.append(", isWaitingForBlinkCloseStream=");
      localStringBuilder.append(this.jdField_e_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get());
      localStringBuilder.append(" isWaitingForDestroy:");
      localStringBuilder.append(this.jdField_f_of_type_JavaUtilConcurrentAtomicAtomicBoolean);
      QLog.d("[cmshow]apollo_client_ApolloUrlInterceptor", 2, localStringBuilder.toString());
    }
    return false;
  }
  
  private void d()
  {
    long l1 = System.currentTimeMillis();
    this.jdField_a_of_type_ComTencentMobileqqApolloStoreWebviewApolloUrlConnection = new ApolloUrlConnection(this.jdField_e_of_type_JavaLangString, true, null, null);
    long l2 = System.currentTimeMillis();
    int j = this.jdField_a_of_type_ComTencentMobileqqApolloStoreWebviewApolloUrlConnection.a();
    int i = j;
    Object localObject;
    if (j == 0)
    {
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("task(");
        ((StringBuilder)localObject).append(this.jdField_b_of_type_JavaLangString);
        ((StringBuilder)localObject).append(") connection connect cost = ");
        ((StringBuilder)localObject).append(System.currentTimeMillis() - l2);
        ((StringBuilder)localObject).append(" ms.");
        QLog.d("[cmshow]apollo_client_ApolloUrlInterceptor", 2, ((StringBuilder)localObject).toString());
      }
      l2 = System.currentTimeMillis();
      j = this.jdField_a_of_type_ComTencentMobileqqApolloStoreWebviewApolloUrlConnection.b();
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("task(");
        ((StringBuilder)localObject).append(this.jdField_b_of_type_JavaLangString);
        ((StringBuilder)localObject).append(") connection response cost = ");
        ((StringBuilder)localObject).append(System.currentTimeMillis() - l2);
        ((StringBuilder)localObject).append(" ms.");
        QLog.d("[cmshow]apollo_client_ApolloUrlInterceptor", 2, ((StringBuilder)localObject).toString());
      }
      l2 = System.currentTimeMillis();
      Map localMap = this.jdField_a_of_type_ComTencentMobileqqApolloStoreWebviewApolloUrlConnection.a();
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("task(");
        ((StringBuilder)localObject).append(this.jdField_b_of_type_JavaLangString);
        ((StringBuilder)localObject).append(") connection get header fields cost = ");
        ((StringBuilder)localObject).append(System.currentTimeMillis() - l2);
        ((StringBuilder)localObject).append(" ms.");
        QLog.d("[cmshow]apollo_client_ApolloUrlInterceptor", 2, ((StringBuilder)localObject).toString());
      }
      i = j;
      if (localMap != null)
      {
        localObject = "Set-Cookie";
        if (!localMap.containsKey("Set-Cookie")) {
          if (localMap.containsKey("set-cookie")) {
            localObject = "set-cookie";
          } else {
            localObject = null;
          }
        }
        i = j;
        if (!TextUtils.isEmpty((CharSequence)localObject))
        {
          localObject = (List)localMap.get(localObject);
          ApolloClientUtil.a(this.jdField_e_of_type_JavaLangString, (List)localObject);
          i = j;
        }
      }
    }
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("task(");
      ((StringBuilder)localObject).append(this.jdField_b_of_type_JavaLangString);
      ((StringBuilder)localObject).append(") handleFlow_Connection: respCode = ");
      ((StringBuilder)localObject).append(i);
      ((StringBuilder)localObject).append(", cost ");
      ((StringBuilder)localObject).append(System.currentTimeMillis() - l1);
      ((StringBuilder)localObject).append(" ms.");
      QLog.d("[cmshow]apollo_client_ApolloUrlInterceptor", 4, ((StringBuilder)localObject).toString());
    }
    if (b())
    {
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("task(");
        ((StringBuilder)localObject).append(this.jdField_b_of_type_JavaLangString);
        ((StringBuilder)localObject).append(") handleFlow_Connection: destroy before server response.");
        QLog.d("[cmshow]apollo_client_ApolloUrlInterceptor", 6, ((StringBuilder)localObject).toString());
      }
      return;
    }
    if (200 != i)
    {
      if (this.jdField_b_of_type_Boolean)
      {
        this.jdField_a_of_type_AndroidOsHandler.removeMessages(1);
        localObject = this.jdField_a_of_type_AndroidOsHandler.obtainMessage(5);
        ((Message)localObject).arg1 = i;
        this.jdField_a_of_type_AndroidOsHandler.sendMessage((Message)localObject);
      }
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("task(");
        ((StringBuilder)localObject).append(this.jdField_b_of_type_JavaLangString);
        ((StringBuilder)localObject).append(") handleFlow_Connection: response code not 200, response code = ");
        ((StringBuilder)localObject).append(i);
        QLog.d("[cmshow]apollo_client_ApolloUrlInterceptor", 4, ((StringBuilder)localObject).toString());
      }
      return;
    }
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
    Object localObject1 = this.jdField_a_of_type_ComTencentMobileqqApolloStoreWebviewApolloUrlConnection.a(this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean, null);
    int i = 2;
    if (localObject1 == null)
    {
      if (QLog.isColorLevel())
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("task(");
        ((StringBuilder)localObject1).append(this.jdField_b_of_type_JavaLangString);
        ((StringBuilder)localObject1).append(") handleFlow_FirstLoad error:responseDataTuple is null!");
        QLog.d("[cmshow]apollo_client_ApolloUrlInterceptor", 2, ((StringBuilder)localObject1).toString());
      }
      this.jdField_c_of_type_Boolean = true;
      this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(3);
      return;
    }
    this.jdField_a_of_type_JavaIoInputStream = new BridgeStream(this, ((ApolloUrlConnection.ResponseDataTuple)localObject1).jdField_a_of_type_JavaIoByteArrayOutputStream, ((ApolloUrlConnection.ResponseDataTuple)localObject1).jdField_a_of_type_JavaIoBufferedInputStream);
    Object localObject2;
    if (((ApolloUrlConnection.ResponseDataTuple)localObject1).jdField_a_of_type_Boolean)
    {
      try
      {
        localObject1 = ((ApolloUrlConnection.ResponseDataTuple)localObject1).jdField_a_of_type_JavaIoByteArrayOutputStream.toString("UTF-8");
        try
        {
          this.jdField_g_of_type_JavaLangString = ((String)localObject1);
          localObject2 = localObject1;
        }
        catch (Throwable localThrowable1) {}
        this.jdField_a_of_type_JavaIoInputStream = null;
      }
      catch (Throwable localThrowable2)
      {
        localObject1 = null;
      }
      localObject2 = localObject1;
      if (QLog.isColorLevel())
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("task(");
        ((StringBuilder)localObject2).append(this.jdField_b_of_type_JavaLangString);
        ((StringBuilder)localObject2).append(") handleFlow_FirstLoad error:");
        ((StringBuilder)localObject2).append(localThrowable2.getMessage());
        ((StringBuilder)localObject2).append(".");
        QLog.d("[cmshow]apollo_client_ApolloUrlInterceptor", 2, ((StringBuilder)localObject2).toString());
        localObject2 = localObject1;
      }
    }
    else
    {
      localObject2 = null;
    }
    boolean bool = TextUtils.isEmpty((CharSequence)localObject2) ^ true;
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("task(");
      ((StringBuilder)localObject1).append(this.jdField_b_of_type_JavaLangString);
      ((StringBuilder)localObject1).append(") handleFlow_FirstLoad:hasCacheData=");
      ((StringBuilder)localObject1).append(bool);
      ((StringBuilder)localObject1).append(".");
      QLog.d("[cmshow]apollo_client_ApolloUrlInterceptor", 4, ((StringBuilder)localObject1).toString());
    }
    this.jdField_a_of_type_AndroidOsHandler.removeMessages(1);
    localObject1 = this.jdField_a_of_type_AndroidOsHandler.obtainMessage(2);
    ((Message)localObject1).obj = localObject2;
    if (!bool) {
      i = 1;
    }
    ((Message)localObject1).arg1 = i;
    this.jdField_a_of_type_AndroidOsMessage = ((Message)localObject1);
    this.jdField_a_of_type_AndroidOsHandler.sendMessage((Message)localObject1);
    if ((bool) && (!this.jdField_a_of_type_Boolean))
    {
      long l = System.currentTimeMillis();
      ((ApolloWebDataHandlerImpl)QRoute.api(IApolloWebDataHandler.class)).saveHtml(this.jdField_e_of_type_JavaLangString, (String)localObject2);
      this.jdField_a_of_type_Boolean = true;
      if (QLog.isColorLevel())
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("task(");
        ((StringBuilder)localObject1).append(this.jdField_b_of_type_JavaLangString);
        ((StringBuilder)localObject1).append(") handleFlow_FirstLoad :save htmlString ");
        ((StringBuilder)localObject1).append(System.currentTimeMillis() - l);
        ((StringBuilder)localObject1).append(" ms.");
        QLog.d("[cmshow]apollo_client_ApolloUrlInterceptor", 4, ((StringBuilder)localObject1).toString());
      }
    }
  }
  
  public ApolloWebStatistics a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqApolloStoreWebviewApolloWebStatistics;
  }
  
  public Object a(String arg1)
  {
    if (this.jdField_c_of_type_Boolean) {
      return null;
    }
    Object localObject1 = (ApolloWebDataHandlerImpl)QRoute.api(IApolloWebDataHandler.class);
    Object localObject3;
    if ((this.jdField_a_of_type_ComTencentBizPubaccountCustomWebView != null) && (((ApolloWebDataHandlerImpl)localObject1).isCmdResourceUrl(???)))
    {
      if (QLog.isColorLevel())
      {
        localObject3 = new StringBuilder();
        ((StringBuilder)localObject3).append("getClientResource isCmdResourceUrl url:");
        ((StringBuilder)localObject3).append(???);
        QLog.d("[cmshow]apollo_client_ApolloUrlInterceptor", 2, ((StringBuilder)localObject3).toString());
      }
      localObject1 = ((ApolloWebDataHandlerImpl)localObject1).getApolloCmdResource(???, this.jdField_c_of_type_JavaLangString);
      if (localObject1 != null) {
        return localObject1;
      }
    }
    if ((this.jdField_a_of_type_ComTencentBizPubaccountCustomWebView != null) && (!this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.isEmpty()))
    {
      localObject1 = this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.values().iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject3 = (ApolloUrlInterceptor.PreloadCGITask)((Iterator)localObject1).next();
        if (???.contains(ApolloUrlInterceptor.PreloadCGITask.a((ApolloUrlInterceptor.PreloadCGITask)localObject3).jdField_a_of_type_JavaLangString))
        {
          WebResourceResponse localWebResourceResponse = ((ApolloUrlInterceptor.PreloadCGITask)localObject3).a(???);
          if (QLog.isColorLevel())
          {
            StringBuilder localStringBuilder2 = new StringBuilder();
            localStringBuilder2.append("getClientResource getCGIResource url:");
            localStringBuilder2.append(???);
            localStringBuilder2.append(" resourceResponse:");
            localStringBuilder2.append(localWebResourceResponse);
            QLog.d("[cmshow]apollo_client_ApolloUrlInterceptor", 2, localStringBuilder2.toString());
          }
          this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.remove(ApolloUrlInterceptor.PreloadCGITask.a((ApolloUrlInterceptor.PreloadCGITask)localObject3).jdField_a_of_type_JavaLangString);
          if (localWebResourceResponse != null) {
            return localWebResourceResponse;
          }
        }
      }
    }
    if (!a(???))
    {
      if (QLog.isColorLevel())
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("task(");
        ((StringBuilder)localObject1).append(this.jdField_b_of_type_JavaLangString);
        ((StringBuilder)localObject1).append(")  getClientResource error:isMatchCurrentUrl false, url = ");
        ((StringBuilder)localObject1).append(???);
        QLog.d("[cmshow]apollo_client_ApolloUrlInterceptor", 2, ((StringBuilder)localObject1).toString());
      }
      return null;
    }
    if ((this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get()) && (QLog.isColorLevel()))
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("task(");
      ((StringBuilder)localObject1).append(this.jdField_b_of_type_JavaLangString);
      ((StringBuilder)localObject1).append(")  getClientResource error:wasInterceptInvoked true, url = ");
      ((StringBuilder)localObject1).append(???);
      QLog.d("[cmshow]apollo_client_ApolloUrlInterceptor", 2, ((StringBuilder)localObject1).toString());
    }
    if ((!this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.compareAndSet(false, true)) && (QLog.isColorLevel()))
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("task(");
      ((StringBuilder)localObject1).append(this.jdField_b_of_type_JavaLangString);
      ((StringBuilder)localObject1).append(")  onClientRequestResource error:Intercept was already invoked, url = ");
      ((StringBuilder)localObject1).append(???);
      QLog.d("[cmshow]apollo_client_ApolloUrlInterceptor", 2, ((StringBuilder)localObject1).toString());
    }
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("task(");
      ((StringBuilder)localObject1).append(this.jdField_b_of_type_JavaLangString);
      ((StringBuilder)localObject1).append(")  getClientResource:url = ");
      ((StringBuilder)localObject1).append(???);
      QLog.d("[cmshow]apollo_client_ApolloUrlInterceptor", 2, ((StringBuilder)localObject1).toString());
    }
    long l = System.currentTimeMillis();
    if (this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.get() == 1)
    {
      try
      {
        synchronized (this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger)
        {
          if (this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.get() == 1)
          {
            if (QLog.isColorLevel())
            {
              localObject1 = new StringBuilder();
              ((StringBuilder)localObject1).append("task(");
              ((StringBuilder)localObject1).append(this.jdField_b_of_type_JavaLangString);
              ((StringBuilder)localObject1).append(") now wait for pendingWebResourceStream!");
              QLog.d("[cmshow]apollo_client_ApolloUrlInterceptor", 2, ((StringBuilder)localObject1).toString());
            }
            this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.wait(30000L);
          }
        }
      }
      catch (Throwable localThrowable)
      {
        localObject3 = new StringBuilder();
        ((StringBuilder)localObject3).append("task(");
        ((StringBuilder)localObject3).append(this.jdField_b_of_type_JavaLangString);
        ((StringBuilder)localObject3).append(") wait for pendingWebResourceStream failed");
        ((StringBuilder)localObject3).append(localThrowable.getMessage());
        QLog.e("[cmshow]apollo_client_ApolloUrlInterceptor", 2, ((StringBuilder)localObject3).toString());
      }
      throw localThrowable;
    }
    else if (QLog.isColorLevel())
    {
      ??? = new StringBuilder();
      ???.append("task(");
      ???.append(this.jdField_b_of_type_JavaLangString);
      ???.append(") is not in running state: ");
      ???.append(this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger);
      QLog.d("[cmshow]apollo_client_ApolloUrlInterceptor", 2, ???.toString());
    }
    if (QLog.isColorLevel())
    {
      ??? = new StringBuilder();
      ???.append("task(");
      ???.append(this.jdField_b_of_type_JavaLangString);
      ???.append(") have pending stream? -> ");
      boolean bool;
      if (this.jdField_a_of_type_JavaIoInputStream != null) {
        bool = true;
      } else {
        bool = false;
      }
      ???.append(bool);
      ???.append(", cost ");
      ???.append(System.currentTimeMillis() - l);
      ???.append("ms.");
      QLog.d("[cmshow]apollo_client_ApolloUrlInterceptor", 2, ???.toString());
    }
    if ((this.jdField_a_of_type_JavaIoInputStream == null) && (!TextUtils.isEmpty(this.jdField_g_of_type_JavaLangString)))
    {
      try
      {
        this.jdField_a_of_type_JavaIoInputStream = new ByteArrayInputStream(this.jdField_g_of_type_JavaLangString.getBytes("UTF-8"));
        this.jdField_d_of_type_Boolean = true;
      }
      catch (Throwable ???)
      {
        QLog.e("[cmshow]apollo_client_ApolloUrlInterceptor", 2, ???, new Object[0]);
      }
      if (QLog.isColorLevel()) {
        QLog.d("[cmshow]apollo_client_ApolloUrlInterceptor", 2, "task(\" + id + \") pendingWebResourceStream is null but mHtmlContent is not null!");
      }
    }
    if (this.jdField_a_of_type_JavaIoInputStream != null)
    {
      if (!b())
      {
        ??? = new WebResourceResponse(ApolloClientUtil.a(this.jdField_e_of_type_JavaLangString), "utf-8", this.jdField_a_of_type_JavaIoInputStream);
        this.jdField_e_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(true);
      }
      else
      {
        if (QLog.isColorLevel()) {
          QLog.d("[cmshow]apollo_client_ApolloUrlInterceptor", 2, "task(\" + id + \") getClientResource error: session is destroyed!");
        }
        ??? = null;
      }
      if (this.jdField_d_of_type_Boolean) {
        this.jdField_d_of_type_Boolean = false;
      }
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder1 = new StringBuilder();
        localStringBuilder1.append("task(\" + id + \") getClientResource ret webResourceResponse:");
        localStringBuilder1.append(???);
        QLog.d("[cmshow]apollo_client_ApolloUrlInterceptor", 2, localStringBuilder1.toString());
      }
      this.jdField_a_of_type_JavaIoInputStream = null;
      return ???;
    }
    if (QLog.isColorLevel()) {
      QLog.d("[cmshow]apollo_client_ApolloUrlInterceptor", 2, "task(\" + id + \") getClientResource ret webResourceResponse:null ");
    }
    return null;
  }
  
  public void a()
  {
    b(false);
  }
  
  public void a(boolean paramBoolean)
  {
    if (!this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.compareAndSet(0, 1))
    {
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("task(");
        ((StringBuilder)localObject).append(this.jdField_b_of_type_JavaLangString);
        ((StringBuilder)localObject).append(") start error:sessionState=");
        ((StringBuilder)localObject).append(this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.get());
        ((StringBuilder)localObject).append(".");
        QLog.d("[cmshow]apollo_client_ApolloUrlInterceptor", 2, ((StringBuilder)localObject).toString());
      }
      return;
    }
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("task(");
      ((StringBuilder)localObject).append(this.jdField_b_of_type_JavaLangString);
      ((StringBuilder)localObject).append(") now post task flow task.");
      QLog.d("[cmshow]apollo_client_ApolloUrlInterceptor", 2, ((StringBuilder)localObject).toString());
    }
    this.jdField_g_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(true);
    if (paramBoolean)
    {
      ThreadManager.postImmediately(new ApolloUrlInterceptor.2(this), null, true);
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("[cmshow]apollo_client_ApolloUrlInterceptor", 2, "runDataTask in AsyncThread start!");
    }
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqApolloStoreWebviewApolloWebStatistics;
    long l = System.currentTimeMillis();
    ((ApolloWebStatistics)localObject).g = l;
    b();
    c();
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("runDataTask use:");
      ((StringBuilder)localObject).append(System.currentTimeMillis() - l);
      QLog.d("[cmshow]apollo_client_ApolloUrlInterceptor", 2, ((StringBuilder)localObject).toString());
    }
    this.jdField_a_of_type_ComTencentMobileqqApolloStoreWebviewApolloWebStatistics.h = System.currentTimeMillis();
  }
  
  public void a(boolean paramBoolean, ByteArrayOutputStream paramByteArrayOutputStream)
  {
    if (this.jdField_a_of_type_JavaIoInputStream != null) {
      this.jdField_a_of_type_JavaIoInputStream = null;
    }
    boolean bool2 = QLog.isColorLevel();
    boolean bool1 = true;
    StringBuilder localStringBuilder;
    if (bool2)
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("task(");
      localStringBuilder.append(this.jdField_b_of_type_JavaLangString);
      localStringBuilder.append(") onClose:readComplete:");
      localStringBuilder.append(paramBoolean);
      QLog.d("[cmshow]apollo_client_ApolloUrlInterceptor", 1, localStringBuilder.toString());
    }
    long l = System.currentTimeMillis();
    if ((paramBoolean) && (paramByteArrayOutputStream != null))
    {
      ThreadManager.getSubThreadHandler().postDelayed(new ApolloUrlInterceptor.3(this, paramByteArrayOutputStream), 3000L);
      return;
    }
    if (QLog.isColorLevel())
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("task(");
      localStringBuilder.append(this.jdField_b_of_type_JavaLangString);
      localStringBuilder.append(") onClose error:readComplete =");
      localStringBuilder.append(paramBoolean);
      localStringBuilder.append(", outputStream is null -> ");
      if (paramByteArrayOutputStream == null) {
        paramBoolean = bool1;
      } else {
        paramBoolean = false;
      }
      localStringBuilder.append(paramBoolean);
      QLog.e("[cmshow]apollo_client_ApolloUrlInterceptor", 6, localStringBuilder.toString());
    }
    this.jdField_e_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(false);
    if (d())
    {
      paramByteArrayOutputStream = new StringBuilder();
      paramByteArrayOutputStream.append("task(");
      paramByteArrayOutputStream.append(this.jdField_b_of_type_JavaLangString);
      paramByteArrayOutputStream.append(") onClose: postForceDestroyIfNeed send destroy message in chromium_io thread.");
      QLog.d("[cmshow]apollo_client_ApolloUrlInterceptor", 2, paramByteArrayOutputStream.toString());
    }
    if (QLog.isColorLevel())
    {
      paramByteArrayOutputStream = new StringBuilder();
      paramByteArrayOutputStream.append("task(");
      paramByteArrayOutputStream.append(this.jdField_b_of_type_JavaLangString);
      paramByteArrayOutputStream.append(") onClose cost ");
      paramByteArrayOutputStream.append(System.currentTimeMillis() - l);
      paramByteArrayOutputStream.append(" ms.");
      QLog.d("[cmshow]apollo_client_ApolloUrlInterceptor", 6, paramByteArrayOutputStream.toString());
    }
  }
  
  public boolean a()
  {
    return this.jdField_c_of_type_Boolean ^ true;
  }
  
  public boolean a(CustomWebView paramCustomWebView)
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountCustomWebView == null)
    {
      this.jdField_a_of_type_ComTencentBizPubaccountCustomWebView = paramCustomWebView;
      paramCustomWebView = new StringBuilder();
      paramCustomWebView.append("task(");
      paramCustomWebView.append(this.jdField_b_of_type_JavaLangString);
      paramCustomWebView.append(") bind client.");
      QLog.d("[cmshow]apollo_client_ApolloUrlInterceptor", 2, paramCustomWebView.toString());
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
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append(localUri.getHost());
      ((StringBuilder)localObject1).append(localUri.getPath());
      localObject1 = ((StringBuilder)localObject1).toString();
      Object localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append(paramString.getHost());
      ((StringBuilder)localObject2).append(paramString.getPath());
      localObject2 = ((StringBuilder)localObject2).toString();
      if (localUri.getHost().equalsIgnoreCase(paramString.getHost()))
      {
        paramString = (String)localObject1;
        if (!((String)localObject1).endsWith("/"))
        {
          paramString = new StringBuilder();
          paramString.append((String)localObject1);
          paramString.append("/");
          paramString = paramString.toString();
        }
        localObject1 = localObject2;
        if (!((String)localObject2).endsWith("/"))
        {
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append((String)localObject2);
          ((StringBuilder)localObject1).append("/");
          localObject1 = ((StringBuilder)localObject1).toString();
        }
        boolean bool = paramString.equalsIgnoreCase((String)localObject1);
        return bool;
      }
    }
    catch (Throwable paramString)
    {
      Object localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("isMatchCurrentUrl error:");
      ((StringBuilder)localObject1).append(paramString.getMessage());
      QLog.e("[cmshow]apollo_client_ApolloUrlInterceptor", 2, ((StringBuilder)localObject1).toString());
    }
    return false;
  }
  
  public boolean b(String paramString)
  {
    boolean bool2 = this.jdField_c_of_type_Boolean;
    boolean bool1 = false;
    if ((!bool2) && (a(paramString)) && (this.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicBoolean.compareAndSet(false, true)))
    {
      this.jdField_e_of_type_JavaLangString = ApolloClientUtil.a(paramString, "apollo_task_id", String.valueOf(this.jdField_b_of_type_JavaLangString));
      this.jdField_a_of_type_ComTencentMobileqqApolloStoreWebviewApolloWebStatistics.i = System.currentTimeMillis();
      if (QLog.isColorLevel())
      {
        paramString = new StringBuilder();
        paramString.append("task(");
        paramString.append(this.jdField_b_of_type_JavaLangString);
        paramString.append(") onWebViewInited: mPendingClientCoreMessage not null:");
        if (this.jdField_a_of_type_AndroidOsMessage != null) {
          bool1 = true;
        }
        paramString.append(bool1);
        paramString.append(",currUrl:");
        paramString.append(this.jdField_e_of_type_JavaLangString);
        QLog.d("[cmshow]apollo_client_ApolloUrlInterceptor", 2, paramString.toString());
      }
      paramString = this.jdField_a_of_type_AndroidOsMessage;
      if (paramString != null)
      {
        this.jdField_a_of_type_AndroidOsMessage = null;
        handleMessage(paramString);
        return true;
      }
      if (this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.get() == 0) {
        a(true);
      }
      return true;
    }
    return false;
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    if (10 == paramMessage.what)
    {
      b(true);
      if (QLog.isColorLevel())
      {
        paramMessage = new StringBuilder();
        paramMessage.append("task(");
        paramMessage.append(this.jdField_b_of_type_JavaLangString);
        paramMessage.append(") handleMessage:force destroy.");
        QLog.d("[cmshow]apollo_client_ApolloUrlInterceptor", 2, paramMessage.toString());
      }
      return true;
    }
    if (b())
    {
      if (QLog.isColorLevel())
      {
        paramMessage = new StringBuilder();
        paramMessage.append("task(");
        paramMessage.append(this.jdField_b_of_type_JavaLangString);
        paramMessage.append(") handleMessage error: is destroyed or waiting for destroy.");
        QLog.d("[cmshow]apollo_client_ApolloUrlInterceptor", 2, paramMessage.toString());
      }
      return false;
    }
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("task(");
      ((StringBuilder)localObject).append(this.jdField_b_of_type_JavaLangString);
      ((StringBuilder)localObject).append(") handleMessage: msg what = ");
      ((StringBuilder)localObject).append(paramMessage.what);
      ((StringBuilder)localObject).append(".");
      QLog.d("[cmshow]apollo_client_ApolloUrlInterceptor", 2, ((StringBuilder)localObject).toString());
    }
    if ((paramMessage.what > 0) && (paramMessage.what < 7) && (!this.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get()))
    {
      this.jdField_a_of_type_AndroidOsMessage = Message.obtain(paramMessage);
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("task(");
        ((StringBuilder)localObject).append(this.jdField_b_of_type_JavaLangString);
        ((StringBuilder)localObject).append(") handleMessage: client not ready, core msg = ");
        ((StringBuilder)localObject).append(paramMessage.what);
        ((StringBuilder)localObject).append(".");
        QLog.d("[cmshow]apollo_client_ApolloUrlInterceptor", 2, ((StringBuilder)localObject).toString());
      }
      return true;
    }
    if (paramMessage == this.jdField_a_of_type_AndroidOsMessage) {
      this.jdField_a_of_type_AndroidOsMessage = null;
    }
    int i = paramMessage.what;
    if (i != 1)
    {
      if (i != 2)
      {
        if ((i != 3) && (i != 5))
        {
          if (i != 255)
          {
            if (QLog.isColorLevel())
            {
              localObject = new StringBuilder();
              ((StringBuilder)localObject).append("msg.what ");
              ((StringBuilder)localObject).append(paramMessage.what);
              QLog.d("[cmshow]apollo_client_ApolloUrlInterceptor", 2, ((StringBuilder)localObject).toString());
            }
            return false;
          }
          if ((this.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get()) && (!b()) && (!TextUtils.isEmpty(jdField_a_of_type_JavaLangString)))
          {
            Toast.makeText(BaseApplicationImpl.getContext(), jdField_a_of_type_JavaLangString, 1).show();
            return true;
          }
        }
        else if (this.jdField_c_of_type_JavaUtilConcurrentAtomicAtomicBoolean.compareAndSet(false, true))
        {
          if (QLog.isColorLevel()) {
            QLog.d("[cmshow]apollo_client_ApolloUrlInterceptor", 2, "handleClientCoreMessage_ConnectionError: load src url.");
          }
          if (this.jdField_a_of_type_ComTencentBizPubaccountCustomWebView != null)
          {
            this.jdField_a_of_type_ComTencentBizPubaccountCustomWebView.loadUrlOriginal(this.jdField_e_of_type_JavaLangString);
            return true;
          }
        }
      }
      else if (paramMessage.arg1 == 1)
      {
        if (this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get())
        {
          if (QLog.isColorLevel())
          {
            paramMessage = new StringBuilder();
            paramMessage.append("task(");
            paramMessage.append(this.jdField_b_of_type_JavaLangString);
            paramMessage.append(") handleClientCoreMessage_FirstLoad:FIRST_LOAD_NO_CACHE.");
            QLog.d("[cmshow]apollo_client_ApolloUrlInterceptor", 2, paramMessage.toString());
            return true;
          }
        }
        else if (QLog.isColorLevel())
        {
          paramMessage = new StringBuilder();
          paramMessage.append("task(");
          paramMessage.append(this.jdField_b_of_type_JavaLangString);
          paramMessage.append(") handleClientCoreMessage_FirstLoad:url was not invoked.");
          QLog.d("[cmshow]apollo_client_ApolloUrlInterceptor", 2, paramMessage.toString());
          return true;
        }
      }
      else if (paramMessage.arg1 == 2) {
        if (this.jdField_c_of_type_JavaUtilConcurrentAtomicAtomicBoolean.compareAndSet(false, true))
        {
          if (QLog.isColorLevel())
          {
            localObject = new StringBuilder();
            ((StringBuilder)localObject).append("task(\" + id + \") handleClientCoreMessage_FirstLoad with cache, url:");
            ((StringBuilder)localObject).append(this.jdField_e_of_type_JavaLangString);
            QLog.d("[cmshow]apollo_client_ApolloUrlInterceptor", 2, ((StringBuilder)localObject).toString());
          }
          this.jdField_d_of_type_Boolean = true;
          this.jdField_a_of_type_ComTencentMobileqqApolloStoreWebviewApolloWebStatistics.j = System.currentTimeMillis();
          if (this.jdField_a_of_type_ComTencentBizPubaccountCustomWebView != null)
          {
            if (this.jdField_a_of_type_ComTencentBizPubaccountCustomWebView.getX5WebViewExtension() != null)
            {
              this.jdField_a_of_type_ComTencentBizPubaccountCustomWebView.loadDataWithBaseURL(this.jdField_e_of_type_JavaLangString, (String)paramMessage.obj, "text/html", "utf-8", this.jdField_e_of_type_JavaLangString);
              return true;
            }
            this.jdField_a_of_type_ComTencentBizPubaccountCustomWebView.loadUrlOriginal(this.jdField_e_of_type_JavaLangString);
            QLog.e("[cmshow]apollo_client_ApolloUrlInterceptor", 1, "handleMessage CLIENT_CORE_MSG_FIRST_LOAD PRE_LOAD_WITH_CACHE but not x5 Core");
            return true;
          }
        }
        else if (QLog.isColorLevel())
        {
          paramMessage = new StringBuilder();
          paramMessage.append("task(");
          paramMessage.append(this.jdField_b_of_type_JavaLangString);
          paramMessage.append(") FIRST_LOAD_WITH_CACHE load url was invoked.");
          QLog.d("[cmshow]apollo_client_ApolloUrlInterceptor", 2, paramMessage.toString());
          return true;
        }
      }
    }
    else if (paramMessage.arg1 == 1)
    {
      if (this.jdField_c_of_type_JavaUtilConcurrentAtomicAtomicBoolean.compareAndSet(false, true))
      {
        if (QLog.isColorLevel())
        {
          paramMessage = new StringBuilder();
          paramMessage.append("task(");
          paramMessage.append(this.jdField_b_of_type_JavaLangString);
          paramMessage.append(") handleClientCoreMessage_PreLoad:PRE_LOAD_NO_CACHE load url.");
          QLog.d("[cmshow]apollo_client_ApolloUrlInterceptor", 2, paramMessage.toString());
        }
        this.jdField_a_of_type_ComTencentMobileqqApolloStoreWebviewApolloWebStatistics.j = System.currentTimeMillis();
        if (this.jdField_a_of_type_ComTencentBizPubaccountCustomWebView != null)
        {
          this.jdField_a_of_type_ComTencentBizPubaccountCustomWebView.loadUrlOriginal(this.jdField_e_of_type_JavaLangString);
          return true;
        }
      }
      else if (QLog.isColorLevel())
      {
        paramMessage = new StringBuilder();
        paramMessage.append("task(");
        paramMessage.append(this.jdField_b_of_type_JavaLangString);
        paramMessage.append(") handleClientCoreMessage_PreLoad:wasLoadUrlInvoked = true.");
        QLog.d("[cmshow]apollo_client_ApolloUrlInterceptor", 2, paramMessage.toString());
        return true;
      }
    }
    else if (paramMessage.arg1 == 2) {
      if (this.jdField_d_of_type_JavaUtilConcurrentAtomicAtomicBoolean.compareAndSet(false, true))
      {
        if (QLog.isColorLevel())
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("task(");
          ((StringBuilder)localObject).append(this.jdField_b_of_type_JavaLangString);
          ((StringBuilder)localObject).append(") handleClientCoreMessage_PreLoad:PRE_LOAD_WITH_CACHE load data.");
          QLog.d("[cmshow]apollo_client_ApolloUrlInterceptor", 2, ((StringBuilder)localObject).toString());
        }
        paramMessage = (String)paramMessage.obj;
        this.jdField_a_of_type_ComTencentMobileqqApolloStoreWebviewApolloWebStatistics.j = System.currentTimeMillis();
        if (this.jdField_a_of_type_ComTencentBizPubaccountCustomWebView != null)
        {
          if (this.jdField_a_of_type_ComTencentBizPubaccountCustomWebView.getX5WebViewExtension() != null)
          {
            localObject = this.jdField_a_of_type_ComTencentBizPubaccountCustomWebView;
            String str = this.jdField_e_of_type_JavaLangString;
            ((CustomWebView)localObject).loadDataWithBaseURL(str, paramMessage, "text/html", "utf-8", str);
            return true;
          }
          this.jdField_a_of_type_ComTencentBizPubaccountCustomWebView.loadUrlOriginal(this.jdField_e_of_type_JavaLangString);
          QLog.e("[cmshow]apollo_client_ApolloUrlInterceptor", 1, "handleMessage CLIENT_CORE_MSG_PRE_LOAD PRE_LOAD_WITH_CACHE but not x5 Core");
          return true;
        }
      }
      else if (QLog.isColorLevel())
      {
        paramMessage = new StringBuilder();
        paramMessage.append("task(");
        paramMessage.append(this.jdField_b_of_type_JavaLangString);
        paramMessage.append(") handleClientCoreMessage_PreLoad:wasLoadDataInvoked = true.");
        QLog.d("[cmshow]apollo_client_ApolloUrlInterceptor", 2, paramMessage.toString());
      }
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.store.webview.ApolloUrlInterceptor
 * JD-Core Version:    0.7.0.1
 */