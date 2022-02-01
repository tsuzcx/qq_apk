package com.tencent.mobileqq.apollo.store.webview;

import android.os.Looper;
import android.text.TextUtils;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.webview.swift.utils.SwiftWebViewUtils;
import com.tencent.qphone.base.util.QLog;
import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;

public class ApolloUrlConnection
{
  public int a;
  private ApolloSSOConfig.CGIConfig jdField_a_of_type_ComTencentMobileqqApolloStoreWebviewApolloSSOConfig$CGIConfig;
  private BufferedInputStream jdField_a_of_type_JavaIoBufferedInputStream;
  private String jdField_a_of_type_JavaLangString;
  private HttpURLConnection jdField_a_of_type_JavaNetHttpURLConnection;
  private boolean jdField_a_of_type_Boolean;
  public int b;
  private String b;
  
  public ApolloUrlConnection(String paramString1, boolean paramBoolean, ApolloSSOConfig.CGIConfig paramCGIConfig, String paramString2)
  {
    this.jdField_a_of_type_Int = 5000;
    this.jdField_b_of_type_Int = 15000;
    this.jdField_a_of_type_JavaLangString = paramString1;
    this.jdField_a_of_type_Boolean = paramBoolean;
    this.jdField_a_of_type_ComTencentMobileqqApolloStoreWebviewApolloSSOConfig$CGIConfig = paramCGIConfig;
    this.jdField_b_of_type_JavaLangString = paramString2;
  }
  
  /* Error */
  private BufferedInputStream a()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 35	com/tencent/mobileqq/apollo/store/webview/ApolloUrlConnection:jdField_a_of_type_JavaIoBufferedInputStream	Ljava/io/BufferedInputStream;
    //   6: ifnonnull +54 -> 60
    //   9: aload_0
    //   10: getfield 37	com/tencent/mobileqq/apollo/store/webview/ApolloUrlConnection:jdField_a_of_type_JavaNetHttpURLConnection	Ljava/net/HttpURLConnection;
    //   13: astore_1
    //   14: aload_1
    //   15: ifnull +45 -> 60
    //   18: aload_0
    //   19: getfield 37	com/tencent/mobileqq/apollo/store/webview/ApolloUrlConnection:jdField_a_of_type_JavaNetHttpURLConnection	Ljava/net/HttpURLConnection;
    //   22: invokevirtual 43	java/net/HttpURLConnection:getInputStream	()Ljava/io/InputStream;
    //   25: astore_1
    //   26: ldc 45
    //   28: aload_0
    //   29: getfield 37	com/tencent/mobileqq/apollo/store/webview/ApolloUrlConnection:jdField_a_of_type_JavaNetHttpURLConnection	Ljava/net/HttpURLConnection;
    //   32: invokevirtual 49	java/net/HttpURLConnection:getContentEncoding	()Ljava/lang/String;
    //   35: invokevirtual 55	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   38: ifeq +31 -> 69
    //   41: aload_0
    //   42: new 57	java/io/BufferedInputStream
    //   45: dup
    //   46: new 59	java/util/zip/GZIPInputStream
    //   49: dup
    //   50: aload_1
    //   51: invokespecial 62	java/util/zip/GZIPInputStream:<init>	(Ljava/io/InputStream;)V
    //   54: invokespecial 63	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   57: putfield 35	com/tencent/mobileqq/apollo/store/webview/ApolloUrlConnection:jdField_a_of_type_JavaIoBufferedInputStream	Ljava/io/BufferedInputStream;
    //   60: aload_0
    //   61: getfield 35	com/tencent/mobileqq/apollo/store/webview/ApolloUrlConnection:jdField_a_of_type_JavaIoBufferedInputStream	Ljava/io/BufferedInputStream;
    //   64: astore_1
    //   65: aload_0
    //   66: monitorexit
    //   67: aload_1
    //   68: areturn
    //   69: aload_0
    //   70: new 57	java/io/BufferedInputStream
    //   73: dup
    //   74: aload_1
    //   75: invokespecial 63	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   78: putfield 35	com/tencent/mobileqq/apollo/store/webview/ApolloUrlConnection:jdField_a_of_type_JavaIoBufferedInputStream	Ljava/io/BufferedInputStream;
    //   81: goto -21 -> 60
    //   84: astore_1
    //   85: ldc 65
    //   87: iconst_2
    //   88: new 67	java/lang/StringBuilder
    //   91: dup
    //   92: invokespecial 68	java/lang/StringBuilder:<init>	()V
    //   95: ldc 70
    //   97: invokevirtual 74	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   100: aload_1
    //   101: invokevirtual 77	java/lang/Throwable:getMessage	()Ljava/lang/String;
    //   104: invokevirtual 74	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   107: ldc 79
    //   109: invokevirtual 74	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   112: invokevirtual 82	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   115: invokestatic 88	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   118: goto -58 -> 60
    //   121: astore_1
    //   122: aload_0
    //   123: monitorexit
    //   124: aload_1
    //   125: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	126	0	this	ApolloUrlConnection
    //   13	62	1	localObject1	Object
    //   84	17	1	localThrowable	Throwable
    //   121	4	1	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   18	60	84	java/lang/Throwable
    //   69	81	84	java/lang/Throwable
    //   2	14	121	finally
    //   18	60	121	finally
    //   60	65	121	finally
    //   69	81	121	finally
    //   85	118	121	finally
  }
  
  int a()
  {
    char c = '?';
    for (;;)
    {
      String str2;
      try
      {
        if (this.jdField_a_of_type_JavaNetHttpURLConnection != null) {
          continue;
        }
        long l = System.currentTimeMillis();
        localObject3 = "";
        if (this.jdField_a_of_type_Boolean)
        {
          str1 = ApolloClientUtil.c(this.jdField_a_of_type_JavaLangString);
          if (QLog.isColorLevel()) {
            QLog.d("apollo_client_ApolloUrlConnection", 2, "get cookie cost: " + (System.currentTimeMillis() - l));
          }
          localObject3 = str1;
          if (TextUtils.isEmpty(str1))
          {
            localObject3 = str1;
            if (QLog.isColorLevel())
            {
              QLog.w("apollo_client_ApolloUrlConnection", 2, " cookie is null!");
              localObject3 = str1;
            }
          }
        }
        if ((this.jdField_a_of_type_ComTencentMobileqqApolloStoreWebviewApolloSSOConfig$CGIConfig == null) || (!this.jdField_a_of_type_ComTencentMobileqqApolloStoreWebviewApolloSSOConfig$CGIConfig.a()) || (TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString))) {
          break label888;
        }
        this.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqApolloStoreWebviewApolloSSOConfig$CGIConfig.jdField_a_of_type_JavaLangString;
        str2 = this.jdField_a_of_type_ComTencentMobileqqApolloStoreWebviewApolloSSOConfig$CGIConfig.a(true);
        if (QLog.isColorLevel()) {
          QLog.d("apollo_client_ApolloUrlConnection", 2, "getUrlConnection mCgiConfig.parameterStr:" + str2);
        }
        if ((TextUtils.isEmpty(str2)) || (!"get".equals(this.jdField_a_of_type_ComTencentMobileqqApolloStoreWebviewApolloSSOConfig$CGIConfig.jdField_b_of_type_JavaLangString.toLowerCase()))) {
          break label881;
        }
        i = this.jdField_a_of_type_JavaLangString.indexOf('?');
        j = this.jdField_a_of_type_JavaLangString.indexOf('#');
        if (i != -1) {
          continue;
        }
        if (j != -1) {
          continue;
        }
        str1 = this.jdField_a_of_type_JavaLangString + c;
        this.jdField_a_of_type_JavaLangString = str1;
        this.jdField_a_of_type_JavaLangString += str2;
        str1 = null;
        if (QLog.isColorLevel()) {
          QLog.d("apollo_client_ApolloUrlConnection", 2, " getUrlConnection mCurrentUrl:" + this.jdField_a_of_type_JavaLangString);
        }
        this.jdField_a_of_type_JavaNetHttpURLConnection = ((HttpURLConnection)new URL(this.jdField_a_of_type_JavaLangString).openConnection());
        if (this.jdField_a_of_type_JavaNetHttpURLConnection != null) {
          continue;
        }
        QLog.e("apollo_client_ApolloUrlConnection", 1, "getUrlConnection HttpURLConnection is null!");
        i = -1;
      }
      catch (IOException localIOException)
      {
        String str1;
        int j;
        QLog.e("apollo_client_ApolloUrlConnection", 2, "getUrlConnection connect http exception !!!!" + localIOException);
        if (this.jdField_a_of_type_JavaNetHttpURLConnection == null) {
          continue;
        }
        this.jdField_a_of_type_JavaNetHttpURLConnection.disconnect();
        i = -1;
        continue;
        if (TextUtils.isEmpty(this.jdField_b_of_type_JavaLangString)) {
          continue;
        }
        this.jdField_a_of_type_JavaNetHttpURLConnection.setRequestProperty("Origin", this.jdField_b_of_type_JavaLangString);
        this.jdField_a_of_type_JavaNetHttpURLConnection.setRequestProperty("Referer", this.jdField_b_of_type_JavaLangString);
        if ((this.jdField_a_of_type_ComTencentMobileqqApolloStoreWebviewApolloSSOConfig$CGIConfig == null) || (!this.jdField_a_of_type_ComTencentMobileqqApolloStoreWebviewApolloSSOConfig$CGIConfig.a())) {
          break label876;
        }
        if (!"get".equals(this.jdField_a_of_type_ComTencentMobileqqApolloStoreWebviewApolloSSOConfig$CGIConfig.jdField_b_of_type_JavaLangString.toLowerCase())) {
          continue;
        }
        this.jdField_a_of_type_JavaNetHttpURLConnection.setDoOutput(false);
        this.jdField_a_of_type_JavaNetHttpURLConnection.setDoInput(true);
        this.jdField_a_of_type_JavaNetHttpURLConnection.setRequestMethod("GET");
        i = 0;
        if (i != 0) {
          break label894;
        }
        this.jdField_a_of_type_JavaNetHttpURLConnection.connect();
        break label894;
        if (!"post".equals(this.jdField_a_of_type_ComTencentMobileqqApolloStoreWebviewApolloSSOConfig$CGIConfig.jdField_b_of_type_JavaLangString.toLowerCase())) {
          break label876;
        }
        this.jdField_a_of_type_JavaNetHttpURLConnection.setDoOutput(true);
        this.jdField_a_of_type_JavaNetHttpURLConnection.setDoInput(true);
        this.jdField_a_of_type_JavaNetHttpURLConnection.setRequestMethod("POST");
        if (TextUtils.isEmpty(localIOException)) {
          break label876;
        }
        Object localObject3 = new OutputStreamWriter(this.jdField_a_of_type_JavaNetHttpURLConnection.getOutputStream());
        ((OutputStreamWriter)localObject3).write(localIOException);
        ((OutputStreamWriter)localObject3).flush();
        ((OutputStreamWriter)localObject3).close();
        i = 1;
        continue;
      }
      catch (Throwable localThrowable)
      {
        QLog.e("apollo_client_ApolloUrlConnection", 2, "getUrlConnection connect http exception !!!!" + localThrowable);
        if (this.jdField_a_of_type_JavaNetHttpURLConnection == null) {
          continue;
        }
        this.jdField_a_of_type_JavaNetHttpURLConnection.disconnect();
        continue;
      }
      finally {}
      return i;
      c = '&';
      continue;
      str1 = this.jdField_a_of_type_JavaLangString.substring(0, j) + c + this.jdField_a_of_type_JavaLangString.substring(j);
      continue;
      this.jdField_a_of_type_JavaNetHttpURLConnection.setConnectTimeout(this.jdField_a_of_type_Int);
      this.jdField_a_of_type_JavaNetHttpURLConnection.setReadTimeout(this.jdField_b_of_type_Int);
      this.jdField_a_of_type_JavaNetHttpURLConnection.setInstanceFollowRedirects(false);
      this.jdField_a_of_type_JavaNetHttpURLConnection.setRequestProperty("Cookie", (String)localObject3);
      this.jdField_a_of_type_JavaNetHttpURLConnection.setRequestProperty("Accept-Encoding", "gzip");
      localObject3 = SwiftWebViewUtils.a(SwiftWebViewUtils.b("httpAsync 1.0"), "", false);
      this.jdField_a_of_type_JavaNetHttpURLConnection.setRequestProperty("User-Agent", (String)localObject3);
      if (this.jdField_a_of_type_ComTencentMobileqqApolloStoreWebviewApolloSSOConfig$CGIConfig != null)
      {
        localObject3 = this.jdField_a_of_type_ComTencentMobileqqApolloStoreWebviewApolloSSOConfig$CGIConfig.jdField_a_of_type_JavaUtilHashMap.keySet().iterator();
        if (((Iterator)localObject3).hasNext())
        {
          str2 = (String)((Iterator)localObject3).next();
          this.jdField_a_of_type_JavaNetHttpURLConnection.setRequestProperty(str2, (String)this.jdField_a_of_type_ComTencentMobileqqApolloStoreWebviewApolloSSOConfig$CGIConfig.jdField_a_of_type_JavaUtilHashMap.get(str2));
          continue;
        }
      }
      label876:
      int i = 0;
      continue;
      label881:
      Object localObject2 = str2;
      continue;
      label888:
      localObject2 = null;
      continue;
      label894:
      i = 0;
    }
  }
  
  ApolloUrlConnection.ResponseDataTuple a(AtomicBoolean paramAtomicBoolean, ByteArrayOutputStream paramByteArrayOutputStream)
  {
    boolean bool = false;
    for (;;)
    {
      BufferedInputStream localBufferedInputStream;
      ByteArrayOutputStream localByteArrayOutputStream;
      int j;
      try
      {
        localBufferedInputStream = a();
        if (localBufferedInputStream != null)
        {
          localByteArrayOutputStream = paramByteArrayOutputStream;
          if (paramByteArrayOutputStream == null) {
            localByteArrayOutputStream = new ByteArrayOutputStream();
          }
          paramByteArrayOutputStream = new byte[10240];
          int i = 0;
          j = i;
          try
          {
            if (paramAtomicBoolean.get()) {
              continue;
            }
            i = localBufferedInputStream.read(paramByteArrayOutputStream);
            j = i;
            if (-1 == i) {
              continue;
            }
            localByteArrayOutputStream.write(paramByteArrayOutputStream, 0, i);
          }
          catch (Throwable paramAtomicBoolean)
          {
            QLog.e("apollo_client_ApolloUrlConnection", 2, " getResponseData error:" + paramAtomicBoolean.getMessage());
          }
        }
        paramAtomicBoolean = null;
        return paramAtomicBoolean;
      }
      finally {}
      paramAtomicBoolean = new ApolloUrlConnection.ResponseDataTuple();
      paramAtomicBoolean.jdField_a_of_type_JavaIoBufferedInputStream = localBufferedInputStream;
      paramAtomicBoolean.jdField_a_of_type_JavaIoByteArrayOutputStream = localByteArrayOutputStream;
      if (-1 == j) {
        bool = true;
      }
      paramAtomicBoolean.jdField_a_of_type_Boolean = bool;
    }
  }
  
  Map<String, List<String>> a()
  {
    Map localMap = null;
    try
    {
      if (this.jdField_a_of_type_JavaNetHttpURLConnection != null) {
        localMap = this.jdField_a_of_type_JavaNetHttpURLConnection.getHeaderFields();
      }
      return localMap;
    }
    catch (Exception localException)
    {
      QLog.e("apollo_client_ApolloUrlConnection", 1, localException, new Object[0]);
    }
    return null;
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_JavaNetHttpURLConnection == null) {
      return;
    }
    if (Looper.myLooper() == Looper.getMainLooper())
    {
      ThreadManager.executeOnSubThread(new ApolloUrlConnection.1(this));
      return;
    }
    try
    {
      this.jdField_a_of_type_JavaNetHttpURLConnection.disconnect();
      return;
    }
    catch (Exception localException)
    {
      QLog.e("apollo_client_ApolloUrlConnection", 2, "disconnect error:" + localException.getMessage());
    }
  }
  
  public int b()
  {
    if (this.jdField_a_of_type_JavaNetHttpURLConnection != null) {
      try
      {
        int i = this.jdField_a_of_type_JavaNetHttpURLConnection.getResponseCode();
        return i;
      }
      catch (Throwable localThrowable)
      {
        QLog.e("apollo_client_ApolloUrlConnection", 2, "getResponseCode error:" + localThrowable.getMessage());
      }
    }
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.store.webview.ApolloUrlConnection
 * JD-Core Version:    0.7.0.1
 */