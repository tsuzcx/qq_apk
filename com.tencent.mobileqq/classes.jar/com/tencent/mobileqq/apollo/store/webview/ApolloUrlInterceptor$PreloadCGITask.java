package com.tencent.mobileqq.apollo.store.webview;

import android.text.TextUtils;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.qphone.base.util.QLog;
import com.tencent.smtt.export.external.interfaces.WebResourceResponse;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import org.json.JSONObject;

class ApolloUrlInterceptor$PreloadCGITask
{
  private long jdField_a_of_type_Long;
  private ApolloSSOConfig.CGIConfig jdField_a_of_type_ComTencentMobileqqApolloStoreWebviewApolloSSOConfig$CGIConfig;
  private ApolloUrlConnection jdField_a_of_type_ComTencentMobileqqApolloStoreWebviewApolloUrlConnection;
  private BridgeStream jdField_a_of_type_ComTencentMobileqqApolloStoreWebviewBridgeStream;
  private String jdField_a_of_type_JavaLangString;
  private HashMap<String, String> jdField_a_of_type_JavaUtilHashMap;
  private AtomicBoolean jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean;
  private AtomicInteger jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger;
  private volatile boolean jdField_a_of_type_Boolean;
  
  ApolloUrlInterceptor$PreloadCGITask(ApolloUrlInterceptor paramApolloUrlInterceptor, ApolloSSOConfig.CGIConfig paramCGIConfig)
  {
    this.jdField_a_of_type_ComTencentMobileqqApolloStoreWebviewApolloSSOConfig$CGIConfig = paramCGIConfig;
    this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean(false);
    this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger = new AtomicInteger(0);
    this.jdField_a_of_type_JavaUtilHashMap = new HashMap();
  }
  
  private void a(int paramInt, long paramLong)
  {
    try
    {
      if ((ApolloUrlInterceptor.a(this.jdField_a_of_type_ComTencentMobileqqApolloStoreWebviewApolloUrlInterceptor) != null) && (this.jdField_a_of_type_ComTencentMobileqqApolloStoreWebviewApolloSSOConfig$CGIConfig != null))
      {
        JSONObject localJSONObject = new JSONObject();
        localJSONObject.put("preloadSuccess", paramInt);
        localJSONObject.put("costTime", paramLong);
        ApolloUrlInterceptor.a(this.jdField_a_of_type_ComTencentMobileqqApolloStoreWebviewApolloUrlInterceptor).a.put(this.jdField_a_of_type_ComTencentMobileqqApolloStoreWebviewApolloSSOConfig$CGIConfig.jdField_a_of_type_JavaLangString, localJSONObject);
        return;
      }
    }
    catch (Exception localException)
    {
      QLog.e("[cmshow]Apollo_client_PreloadCGITask", 1, localException, new Object[0]);
    }
  }
  
  private void a(long paramLong)
  {
    try
    {
      if ((ApolloUrlInterceptor.a(this.jdField_a_of_type_ComTencentMobileqqApolloStoreWebviewApolloUrlInterceptor) != null) && (this.jdField_a_of_type_ComTencentMobileqqApolloStoreWebviewApolloSSOConfig$CGIConfig != null))
      {
        JSONObject localJSONObject = ApolloUrlInterceptor.a(this.jdField_a_of_type_ComTencentMobileqqApolloStoreWebviewApolloUrlInterceptor).a.optJSONObject(this.jdField_a_of_type_ComTencentMobileqqApolloStoreWebviewApolloSSOConfig$CGIConfig.jdField_a_of_type_JavaLangString);
        if (localJSONObject != null)
        {
          localJSONObject.put("costTime", paramLong);
          ApolloUrlInterceptor.a(this.jdField_a_of_type_ComTencentMobileqqApolloStoreWebviewApolloUrlInterceptor).a.put(this.jdField_a_of_type_ComTencentMobileqqApolloStoreWebviewApolloSSOConfig$CGIConfig.jdField_a_of_type_JavaLangString, localJSONObject);
          return;
        }
      }
    }
    catch (Exception localException)
    {
      QLog.e("[cmshow]Apollo_client_PreloadCGITask", 1, localException, new Object[0]);
    }
  }
  
  private void c()
  {
    ??? = this.jdField_a_of_type_ComTencentMobileqqApolloStoreWebviewApolloSSOConfig$CGIConfig;
    if (??? != null)
    {
      if (!((ApolloSSOConfig.CGIConfig)???).a()) {
        return;
      }
      long l1 = System.currentTimeMillis();
      this.jdField_a_of_type_ComTencentMobileqqApolloStoreWebviewApolloUrlConnection = new ApolloUrlConnection(this.jdField_a_of_type_ComTencentMobileqqApolloStoreWebviewApolloSSOConfig$CGIConfig.jdField_a_of_type_JavaLangString, true, this.jdField_a_of_type_ComTencentMobileqqApolloStoreWebviewApolloSSOConfig$CGIConfig, ApolloClientUtil.f(ApolloUrlInterceptor.a(this.jdField_a_of_type_ComTencentMobileqqApolloStoreWebviewApolloUrlInterceptor)));
      long l2 = System.currentTimeMillis();
      if (this.jdField_a_of_type_Boolean) {
        return;
      }
      int j = this.jdField_a_of_type_ComTencentMobileqqApolloStoreWebviewApolloUrlConnection.a();
      this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.set(1);
      int i = j;
      if (j == 0)
      {
        if (QLog.isColorLevel())
        {
          ??? = new StringBuilder();
          ((StringBuilder)???).append("task(");
          ((StringBuilder)???).append(this.jdField_a_of_type_ComTencentMobileqqApolloStoreWebviewApolloSSOConfig$CGIConfig.jdField_a_of_type_JavaLangString);
          ((StringBuilder)???).append(") connection connect cost = ");
          ((StringBuilder)???).append(System.currentTimeMillis() - l2);
          ((StringBuilder)???).append(" ms.");
          QLog.d("[cmshow]Apollo_client_PreloadCGITask", 2, ((StringBuilder)???).toString());
        }
        l2 = System.currentTimeMillis();
        j = this.jdField_a_of_type_ComTencentMobileqqApolloStoreWebviewApolloUrlConnection.b();
        if (QLog.isColorLevel())
        {
          ??? = new StringBuilder();
          ((StringBuilder)???).append("task(");
          ((StringBuilder)???).append(this.jdField_a_of_type_ComTencentMobileqqApolloStoreWebviewApolloSSOConfig$CGIConfig.jdField_a_of_type_JavaLangString);
          ((StringBuilder)???).append(") connection response cost = ");
          ((StringBuilder)???).append(System.currentTimeMillis() - l2);
          ((StringBuilder)???).append(" ms.");
          QLog.d("[cmshow]Apollo_client_PreloadCGITask", 2, ((StringBuilder)???).toString());
        }
        l2 = System.currentTimeMillis();
        Object localObject2 = this.jdField_a_of_type_ComTencentMobileqqApolloStoreWebviewApolloUrlConnection.a();
        if (QLog.isColorLevel())
        {
          ??? = new StringBuilder();
          ((StringBuilder)???).append("task(");
          ((StringBuilder)???).append(this.jdField_a_of_type_ComTencentMobileqqApolloStoreWebviewApolloSSOConfig$CGIConfig.jdField_a_of_type_JavaLangString);
          ((StringBuilder)???).append(") connection get header fields cost = ");
          ((StringBuilder)???).append(System.currentTimeMillis() - l2);
          ((StringBuilder)???).append(" ms.");
          QLog.d("[cmshow]Apollo_client_PreloadCGITask", 2, ((StringBuilder)???).toString());
        }
        i = j;
        if (localObject2 != null)
        {
          if (((Map)localObject2).containsKey("Set-Cookie")) {
            ??? = "Set-Cookie";
          } else if (((Map)localObject2).containsKey("set-cookie")) {
            ??? = "set-cookie";
          } else {
            ??? = null;
          }
          if (!TextUtils.isEmpty((CharSequence)???))
          {
            ??? = (List)((Map)localObject2).get(???);
            ApolloClientUtil.a(this.jdField_a_of_type_ComTencentMobileqqApolloStoreWebviewApolloSSOConfig$CGIConfig.jdField_a_of_type_JavaLangString, (List)???);
          }
          ??? = ((Map)localObject2).entrySet().iterator();
          while (((Iterator)???).hasNext())
          {
            Object localObject7 = (Map.Entry)((Iterator)???).next();
            localObject2 = (String)((Map.Entry)localObject7).getKey();
            localObject7 = (List)((Map.Entry)localObject7).getValue();
            if ((localObject7 != null) && (((List)localObject7).size() > 0)) {
              this.jdField_a_of_type_JavaUtilHashMap.put(localObject2, ((List)localObject7).get(0));
            }
          }
          i = j;
          if (QLog.isColorLevel())
          {
            ??? = new StringBuilder();
            ((StringBuilder)???).append("task(");
            ((StringBuilder)???).append(this.jdField_a_of_type_ComTencentMobileqqApolloStoreWebviewApolloSSOConfig$CGIConfig.jdField_a_of_type_JavaLangString);
            ((StringBuilder)???).append(") mHeaderMap:");
            ((StringBuilder)???).append(this.jdField_a_of_type_JavaUtilHashMap);
            QLog.d("[cmshow]Apollo_client_PreloadCGITask", 2, ((StringBuilder)???).toString());
            i = j;
          }
        }
      }
      if (QLog.isColorLevel())
      {
        ??? = new StringBuilder();
        ((StringBuilder)???).append("task(");
        ((StringBuilder)???).append(this.jdField_a_of_type_ComTencentMobileqqApolloStoreWebviewApolloSSOConfig$CGIConfig.jdField_a_of_type_JavaLangString);
        ((StringBuilder)???).append(") handleFlow_Connection: respCode = ");
        ((StringBuilder)???).append(i);
        ((StringBuilder)???).append(", cost ");
        ((StringBuilder)???).append(System.currentTimeMillis() - l1);
        ((StringBuilder)???).append(" ms.");
        QLog.d("[cmshow]Apollo_client_PreloadCGITask", 4, ((StringBuilder)???).toString());
      }
      if (ApolloUrlInterceptor.c(this.jdField_a_of_type_ComTencentMobileqqApolloStoreWebviewApolloUrlInterceptor))
      {
        if (QLog.isColorLevel())
        {
          ??? = new StringBuilder();
          ((StringBuilder)???).append("task(");
          ((StringBuilder)???).append(this.jdField_a_of_type_ComTencentMobileqqApolloStoreWebviewApolloSSOConfig$CGIConfig.jdField_a_of_type_JavaLangString);
          ((StringBuilder)???).append(") handleFlow_Connection: destroy before server response.");
          QLog.d("[cmshow]Apollo_client_PreloadCGITask", 6, ((StringBuilder)???).toString());
        }
        ??? = this.jdField_a_of_type_ComTencentMobileqqApolloStoreWebviewApolloUrlConnection;
        if (??? != null)
        {
          ((ApolloUrlConnection)???).a();
          this.jdField_a_of_type_ComTencentMobileqqApolloStoreWebviewApolloUrlConnection = null;
        }
        this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.set(2);
        synchronized (this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger)
        {
          this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.notifyAll();
          this.jdField_a_of_type_Long = (System.currentTimeMillis() - l1);
          a(this.jdField_a_of_type_Long);
          return;
        }
      }
      if (200 != i)
      {
        ??? = this.jdField_a_of_type_ComTencentMobileqqApolloStoreWebviewApolloUrlConnection;
        if (??? != null)
        {
          ((ApolloUrlConnection)???).a();
          this.jdField_a_of_type_ComTencentMobileqqApolloStoreWebviewApolloUrlConnection = null;
        }
        this.jdField_a_of_type_ComTencentMobileqqApolloStoreWebviewBridgeStream = null;
        if (QLog.isColorLevel())
        {
          ??? = new StringBuilder();
          ((StringBuilder)???).append("task(");
          ((StringBuilder)???).append(this.jdField_a_of_type_ComTencentMobileqqApolloStoreWebviewApolloSSOConfig$CGIConfig.jdField_a_of_type_JavaLangString);
          ((StringBuilder)???).append(") handleFlow_Connection: response code not 200, response code = ");
          ((StringBuilder)???).append(i);
          QLog.d("[cmshow]Apollo_client_PreloadCGITask", 4, ((StringBuilder)???).toString());
        }
        this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.set(2);
        synchronized (this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger)
        {
          this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.notifyAll();
          this.jdField_a_of_type_Long = (System.currentTimeMillis() - l1);
          a(this.jdField_a_of_type_Long);
          return;
        }
      }
      if (this.jdField_a_of_type_Boolean) {
        return;
      }
      ??? = this.jdField_a_of_type_ComTencentMobileqqApolloStoreWebviewApolloUrlConnection.a(this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean, null);
      if (??? == null)
      {
        if (QLog.isColorLevel())
        {
          ??? = new StringBuilder();
          ((StringBuilder)???).append("task(");
          ((StringBuilder)???).append(this.jdField_a_of_type_ComTencentMobileqqApolloStoreWebviewApolloSSOConfig$CGIConfig.jdField_a_of_type_JavaLangString);
          ((StringBuilder)???).append(") handleFlow_FirstLoad error:responseDataTuple is null!");
          QLog.d("[cmshow]Apollo_client_PreloadCGITask", 2, ((StringBuilder)???).toString());
        }
        this.jdField_a_of_type_ComTencentMobileqqApolloStoreWebviewBridgeStream = null;
        this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.set(2);
        synchronized (this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger)
        {
          this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.notifyAll();
          this.jdField_a_of_type_Long = (System.currentTimeMillis() - l1);
          a(this.jdField_a_of_type_Long);
          return;
        }
      }
      if (this.jdField_a_of_type_Boolean) {
        return;
      }
      this.jdField_a_of_type_ComTencentMobileqqApolloStoreWebviewBridgeStream = new BridgeStream(null, ((ApolloUrlConnection.ResponseDataTuple)???).jdField_a_of_type_JavaIoByteArrayOutputStream, ((ApolloUrlConnection.ResponseDataTuple)???).jdField_a_of_type_JavaIoBufferedInputStream);
      this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.set(2);
      synchronized (this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger)
      {
        this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.notifyAll();
        this.jdField_a_of_type_Long = (System.currentTimeMillis() - l1);
        a(this.jdField_a_of_type_Long);
        if (QLog.isColorLevel())
        {
          ??? = new StringBuilder();
          ((StringBuilder)???).append("task(");
          ((StringBuilder)???).append(this.jdField_a_of_type_ComTencentMobileqqApolloStoreWebviewApolloSSOConfig$CGIConfig.jdField_a_of_type_JavaLangString);
          ((StringBuilder)???).append(") mCostTime:");
          ((StringBuilder)???).append(this.jdField_a_of_type_Long);
          QLog.d("[cmshow]Apollo_client_PreloadCGITask", 2, ((StringBuilder)???).toString());
        }
        return;
      }
    }
  }
  
  public WebResourceResponse a(String paramString)
  {
    this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(true);
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
              StringBuilder localStringBuilder1 = new StringBuilder();
              localStringBuilder1.append("getCgiResource(");
              localStringBuilder1.append(paramString);
              localStringBuilder1.append(") now wait for pendingWebResourceStream!");
              QLog.d("[cmshow]Apollo_client_PreloadCGITask", 2, localStringBuilder1.toString());
            }
            this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.wait(200L);
          }
        }
      }
      catch (Throwable localThrowable)
      {
        StringBuilder localStringBuilder2 = new StringBuilder();
        localStringBuilder2.append("getCgiResource");
        localStringBuilder2.append(localThrowable);
        QLog.e("[cmshow]Apollo_client_PreloadCGITask", 2, localStringBuilder2.toString());
      }
      throw paramString;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqApolloStoreWebviewBridgeStream != null)
    {
      if (TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) {
        this.jdField_a_of_type_JavaLangString = ApolloClientUtil.a(paramString);
      }
      paramString = new WebResourceResponse(this.jdField_a_of_type_JavaLangString, "utf-8", this.jdField_a_of_type_ComTencentMobileqqApolloStoreWebviewBridgeStream);
      if (!this.jdField_a_of_type_JavaUtilHashMap.isEmpty()) {
        paramString.setResponseHeaders(this.jdField_a_of_type_JavaUtilHashMap);
      }
      a(1, this.jdField_a_of_type_Long);
      this.jdField_a_of_type_Boolean = true;
      this.jdField_a_of_type_ComTencentMobileqqApolloStoreWebviewBridgeStream = null;
      return paramString;
    }
    this.jdField_a_of_type_Boolean = true;
    a(0, this.jdField_a_of_type_Long);
    return null;
  }
  
  public void a()
  {
    ApolloUrlConnection localApolloUrlConnection = this.jdField_a_of_type_ComTencentMobileqqApolloStoreWebviewApolloUrlConnection;
    if (localApolloUrlConnection != null)
    {
      localApolloUrlConnection.a();
      this.jdField_a_of_type_ComTencentMobileqqApolloStoreWebviewApolloUrlConnection = null;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqApolloStoreWebviewBridgeStream != null) {
      this.jdField_a_of_type_ComTencentMobileqqApolloStoreWebviewBridgeStream = null;
    }
    QLog.d("[cmshow]Apollo_client_PreloadCGITask", 1, "PreloadCGITask onDestroy ");
  }
  
  public void b()
  {
    ThreadManagerV2.excute(new ApolloUrlInterceptor.PreloadCGITask.1(this), 128, null, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.store.webview.ApolloUrlInterceptor.PreloadCGITask
 * JD-Core Version:    0.7.0.1
 */