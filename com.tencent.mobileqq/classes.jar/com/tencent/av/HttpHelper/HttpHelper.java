package com.tencent.av.HttpHelper;

import android.util.Log;
import java.util.Map;

public class HttpHelper
{
  private static final String TAG = "HttpHelper";
  
  public static boolean httpGetRequest(String paramString, Object paramObject, int paramInt, HttpHelper.HttpRequestListener paramHttpRequestListener)
  {
    Log.e("HttpHelper", "httpGetRequest|url = " + paramString + "|| http request timeout =" + paramInt);
    new Thread(new HttpHelper.1(paramString, paramInt, paramHttpRequestListener, paramObject)).start();
    return true;
  }
  
  public static boolean httpGetRequest(String paramString, Object paramObject, HttpHelper.HttpRequestListener paramHttpRequestListener)
  {
    return httpGetRequest(paramString, paramObject, 5000, paramHttpRequestListener);
  }
  
  public static boolean httpPostRequest(String paramString, byte[] paramArrayOfByte, Map<String, String> paramMap, Object paramObject, int paramInt, HttpHelper.HttpRequestListener paramHttpRequestListener)
  {
    Log.e("HttpHelper", "httpPostRequest|url = " + paramString + "|| http request timeout =" + paramInt);
    new Thread(new HttpHelper.2(paramString, paramInt, paramArrayOfByte, paramMap, paramHttpRequestListener, paramObject)).start();
    return true;
  }
  
  public static boolean httpPostRequest(String paramString, byte[] paramArrayOfByte, Map<String, String> paramMap, Object paramObject, HttpHelper.HttpRequestListener paramHttpRequestListener)
  {
    return httpPostRequest(paramString, paramArrayOfByte, paramMap, paramObject, 5000, paramHttpRequestListener);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.av.HttpHelper.HttpHelper
 * JD-Core Version:    0.7.0.1
 */