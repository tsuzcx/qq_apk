package com.tencent.imsdk.common;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Executor;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.TrustManager;

public class HttpClient
{
  private static final int CORE_POOL_SIZE;
  private static final int CPU_COUNT = Runtime.getRuntime().availableProcessors();
  public static final int HTTP_ACTION_REQUEST = 0;
  public static final int HTTP_ACTION_RESPONSE = 1;
  private static final long KEEP_ALIVE = 5L;
  private static final int MAX_POOL_SIZE;
  private static final String TAG = "HttpClient";
  private static HostnameVerifier mHostnameVerifier = new HttpClient.2();
  private static final Executor mThreadPoolExecutor = new ThreadPoolExecutor(CORE_POOL_SIZE, MAX_POOL_SIZE, 5L, TimeUnit.SECONDS, new LinkedBlockingQueue());
  private static TrustManager[] mTrustManagers;
  
  static
  {
    int i = CPU_COUNT;
    CORE_POOL_SIZE = i + 1;
    MAX_POOL_SIZE = i * 2 + 1;
    mTrustManagers = new TrustManager[] { new HttpClient.1() };
  }
  
  private static void httpRequest(String paramString1, String paramString2, Map<String, String> paramMap, byte[] paramArrayOfByte, String paramString3, String paramString4, HttpClient.HttpRequestListener paramHttpRequestListener, String paramString5, int paramInt1, int paramInt2, int paramInt3)
  {
    paramString1 = new HttpClient.3(paramString5, paramInt1, paramString2, paramString1, paramInt2, paramInt3, paramMap, paramArrayOfByte, paramString3, paramHttpRequestListener, paramString4);
    mThreadPoolExecutor.execute(paramString1);
  }
  
  private static void httpRequest(String paramString1, String paramString2, String[] paramArrayOfString1, String[] paramArrayOfString2, byte[] paramArrayOfByte, String paramString3, String paramString4, long paramLong1, long paramLong2, String paramString5, int paramInt1, int paramInt2, int paramInt3)
  {
    if ((paramArrayOfString1 != null) && (paramArrayOfString2 != null) && (paramArrayOfString1.length == paramArrayOfString2.length))
    {
      HashMap localHashMap2 = new HashMap();
      int i = 0;
      for (;;)
      {
        localHashMap1 = localHashMap2;
        if (i >= paramArrayOfString1.length) {
          break;
        }
        localHashMap2.put(paramArrayOfString1[i], paramArrayOfString2[i]);
        i += 1;
      }
    }
    HashMap localHashMap1 = null;
    httpRequest(paramString1, paramString2, localHashMap1, paramArrayOfByte, paramString3, paramString4, new HttpClient.4(paramLong1, paramLong2), paramString5, paramInt1, paramInt2, paramInt3);
  }
  
  private static native void nativeProgressCallback(int paramInt1, int paramInt2, int paramInt3, long paramLong);
  
  private static native void nativeResponseCallback(int paramInt, String[] paramArrayOfString1, String[] paramArrayOfString2, byte[] paramArrayOfByte, long paramLong);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.imsdk.common.HttpClient
 * JD-Core Version:    0.7.0.1
 */