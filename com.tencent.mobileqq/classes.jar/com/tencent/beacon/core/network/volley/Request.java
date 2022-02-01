package com.tencent.beacon.core.network.volley;

import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import java.util.Collections;
import java.util.Map;

public abstract class Request<T>
  implements Comparable<Request<T>>
{
  private static final String DEFAULT_PARAMS_ENCODING = "UTF-8";
  private Cache.Entry mCacheEntry;
  private boolean mCanceled;
  private final int mDefaultTrafficStatsTag;
  private Response.ErrorListener mErrorListener;
  private final VolleyLog.MarkerLog mEventLog;
  private final Object mLock;
  private final int mMethod;
  private Request.NetworkRequestCompleteListener mRequestCompleteListener;
  private RequestQueue mRequestQueue;
  private boolean mResponseDelivered;
  private RetryPolicy mRetryPolicy;
  private Integer mSequence;
  private boolean mShouldCache;
  private boolean mShouldRetryServerErrors;
  private Object mTag;
  private final String mUrl;
  
  public Request(int paramInt, String paramString, Response.ErrorListener paramErrorListener)
  {
    if (VolleyLog.MarkerLog.ENABLED) {}
    for (VolleyLog.MarkerLog localMarkerLog = new VolleyLog.MarkerLog();; localMarkerLog = null)
    {
      this.mEventLog = localMarkerLog;
      this.mLock = new Object();
      this.mShouldCache = true;
      this.mCanceled = false;
      this.mResponseDelivered = false;
      this.mShouldRetryServerErrors = false;
      this.mCacheEntry = null;
      this.mMethod = paramInt;
      this.mUrl = paramString;
      this.mErrorListener = paramErrorListener;
      setRetryPolicy(new DefaultRetryPolicy());
      this.mDefaultTrafficStatsTag = findDefaultTrafficStatsTag(paramString);
      return;
    }
  }
  
  @Deprecated
  public Request(String paramString, Response.ErrorListener paramErrorListener)
  {
    this(-1, paramString, paramErrorListener);
  }
  
  /* Error */
  private byte[] encodeParameters(Map<String, String> paramMap, String paramString)
  {
    // Byte code:
    //   0: new 95	java/lang/StringBuilder
    //   3: dup
    //   4: invokespecial 96	java/lang/StringBuilder:<init>	()V
    //   7: astore_3
    //   8: aload_1
    //   9: invokeinterface 102 1 0
    //   14: invokeinterface 108 1 0
    //   19: astore_1
    //   20: aload_1
    //   21: invokeinterface 114 1 0
    //   26: ifeq +155 -> 181
    //   29: aload_1
    //   30: invokeinterface 118 1 0
    //   35: checkcast 120	java/util/Map$Entry
    //   38: astore 4
    //   40: aload 4
    //   42: invokeinterface 123 1 0
    //   47: ifnull +97 -> 144
    //   50: aload 4
    //   52: invokeinterface 126 1 0
    //   57: ifnull +87 -> 144
    //   60: aload_3
    //   61: aload 4
    //   63: invokeinterface 123 1 0
    //   68: checkcast 128	java/lang/String
    //   71: aload_2
    //   72: invokestatic 134	java/net/URLEncoder:encode	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   75: invokevirtual 138	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   78: pop
    //   79: aload_3
    //   80: bipush 61
    //   82: invokevirtual 141	java/lang/StringBuilder:append	(C)Ljava/lang/StringBuilder;
    //   85: pop
    //   86: aload_3
    //   87: aload 4
    //   89: invokeinterface 126 1 0
    //   94: checkcast 128	java/lang/String
    //   97: aload_2
    //   98: invokestatic 134	java/net/URLEncoder:encode	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   101: invokevirtual 138	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   104: pop
    //   105: aload_3
    //   106: bipush 38
    //   108: invokevirtual 141	java/lang/StringBuilder:append	(C)Ljava/lang/StringBuilder;
    //   111: pop
    //   112: goto -92 -> 20
    //   115: astore_1
    //   116: new 143	java/lang/RuntimeException
    //   119: dup
    //   120: new 95	java/lang/StringBuilder
    //   123: dup
    //   124: invokespecial 96	java/lang/StringBuilder:<init>	()V
    //   127: ldc 145
    //   129: invokevirtual 138	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   132: aload_2
    //   133: invokevirtual 138	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   136: invokevirtual 149	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   139: aload_1
    //   140: invokespecial 152	java/lang/RuntimeException:<init>	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   143: athrow
    //   144: new 154	java/lang/IllegalArgumentException
    //   147: dup
    //   148: ldc 156
    //   150: iconst_2
    //   151: anewarray 5	java/lang/Object
    //   154: dup
    //   155: iconst_0
    //   156: aload 4
    //   158: invokeinterface 123 1 0
    //   163: aastore
    //   164: dup
    //   165: iconst_1
    //   166: aload 4
    //   168: invokeinterface 126 1 0
    //   173: aastore
    //   174: invokestatic 160	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   177: invokespecial 163	java/lang/IllegalArgumentException:<init>	(Ljava/lang/String;)V
    //   180: athrow
    //   181: aload_3
    //   182: invokevirtual 149	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   185: aload_2
    //   186: invokevirtual 167	java/lang/String:getBytes	(Ljava/lang/String;)[B
    //   189: astore_1
    //   190: aload_1
    //   191: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	192	0	this	Request
    //   0	192	1	paramMap	Map<String, String>
    //   0	192	2	paramString	String
    //   7	175	3	localStringBuilder	StringBuilder
    //   38	129	4	localEntry	java.util.Map.Entry
    // Exception table:
    //   from	to	target	type
    //   8	20	115	java/io/UnsupportedEncodingException
    //   20	112	115	java/io/UnsupportedEncodingException
    //   144	181	115	java/io/UnsupportedEncodingException
    //   181	190	115	java/io/UnsupportedEncodingException
  }
  
  private static int findDefaultTrafficStatsTag(String paramString)
  {
    if (!TextUtils.isEmpty(paramString))
    {
      paramString = Uri.parse(paramString);
      if (paramString != null)
      {
        paramString = paramString.getHost();
        if (paramString != null) {
          return paramString.hashCode();
        }
      }
    }
    return 0;
  }
  
  public void addMarker(String paramString)
  {
    if (VolleyLog.MarkerLog.ENABLED) {
      this.mEventLog.add(paramString, Thread.currentThread().getId());
    }
  }
  
  public void cancel()
  {
    synchronized (this.mLock)
    {
      this.mCanceled = true;
      this.mErrorListener = null;
      return;
    }
  }
  
  public int compareTo(Request<T> paramRequest)
  {
    Request.Priority localPriority1 = getPriority();
    Request.Priority localPriority2 = paramRequest.getPriority();
    if (localPriority1 == localPriority2) {
      return this.mSequence.intValue() - paramRequest.mSequence.intValue();
    }
    return localPriority2.ordinal() - localPriority1.ordinal();
  }
  
  public void deliverError(VolleyError paramVolleyError)
  {
    synchronized (this.mLock)
    {
      Response.ErrorListener localErrorListener = this.mErrorListener;
      if (localErrorListener != null) {
        localErrorListener.onErrorResponse(paramVolleyError);
      }
      return;
    }
  }
  
  protected abstract void deliverResponse(T paramT);
  
  void finish(String paramString)
  {
    RequestQueue localRequestQueue = this.mRequestQueue;
    if (localRequestQueue != null) {
      localRequestQueue.finish(this);
    }
    long l;
    if (VolleyLog.MarkerLog.ENABLED)
    {
      l = Thread.currentThread().getId();
      if (Looper.myLooper() != Looper.getMainLooper()) {
        new Handler(Looper.getMainLooper()).post(new Request.1(this, paramString, l));
      }
    }
    else
    {
      return;
    }
    this.mEventLog.add(paramString, l);
    this.mEventLog.finish(toString());
  }
  
  public byte[] getBody()
  {
    Map localMap = getParams();
    if ((localMap != null) && (localMap.size() > 0)) {
      return encodeParameters(localMap, getParamsEncoding());
    }
    return null;
  }
  
  public String getBodyContentType()
  {
    return "application/x-www-form-urlencoded; charset=" + getParamsEncoding();
  }
  
  public Cache.Entry getCacheEntry()
  {
    return this.mCacheEntry;
  }
  
  public String getCacheKey()
  {
    String str = getUrl();
    int i = getMethod();
    if ((i == 0) || (i == -1)) {
      return str;
    }
    return Integer.toString(i) + '-' + str;
  }
  
  public Response.ErrorListener getErrorListener()
  {
    synchronized (this.mLock)
    {
      Response.ErrorListener localErrorListener = this.mErrorListener;
      return localErrorListener;
    }
  }
  
  public Map<String, String> getHeaders()
  {
    return Collections.emptyMap();
  }
  
  public int getMethod()
  {
    return this.mMethod;
  }
  
  protected Map<String, String> getParams()
  {
    return null;
  }
  
  protected String getParamsEncoding()
  {
    return "UTF-8";
  }
  
  @Deprecated
  public byte[] getPostBody()
  {
    Map localMap = getPostParams();
    if ((localMap != null) && (localMap.size() > 0)) {
      return encodeParameters(localMap, getPostParamsEncoding());
    }
    return null;
  }
  
  @Deprecated
  public String getPostBodyContentType()
  {
    return getBodyContentType();
  }
  
  @Deprecated
  protected Map<String, String> getPostParams()
  {
    return getParams();
  }
  
  @Deprecated
  protected String getPostParamsEncoding()
  {
    return getParamsEncoding();
  }
  
  public Request.Priority getPriority()
  {
    return Request.Priority.NORMAL;
  }
  
  public RetryPolicy getRetryPolicy()
  {
    return this.mRetryPolicy;
  }
  
  public final int getSequence()
  {
    Integer localInteger = this.mSequence;
    if (localInteger != null) {
      return localInteger.intValue();
    }
    throw new IllegalStateException("getSequence called before setSequence");
  }
  
  public Object getTag()
  {
    return this.mTag;
  }
  
  public final int getTimeoutMs()
  {
    return getRetryPolicy().getCurrentTimeout();
  }
  
  public int getTrafficStatsTag()
  {
    return this.mDefaultTrafficStatsTag;
  }
  
  public String getUrl()
  {
    return this.mUrl;
  }
  
  public boolean hasHadResponseDelivered()
  {
    synchronized (this.mLock)
    {
      boolean bool = this.mResponseDelivered;
      return bool;
    }
  }
  
  public boolean isCanceled()
  {
    synchronized (this.mLock)
    {
      boolean bool = this.mCanceled;
      return bool;
    }
  }
  
  public void markDelivered()
  {
    synchronized (this.mLock)
    {
      this.mResponseDelivered = true;
      return;
    }
  }
  
  void notifyListenerResponseNotUsable()
  {
    synchronized (this.mLock)
    {
      Request.NetworkRequestCompleteListener localNetworkRequestCompleteListener = this.mRequestCompleteListener;
      if (localNetworkRequestCompleteListener != null) {
        localNetworkRequestCompleteListener.onNoUsableResponseReceived(this);
      }
      return;
    }
  }
  
  void notifyListenerResponseReceived(Response<?> paramResponse)
  {
    synchronized (this.mLock)
    {
      Request.NetworkRequestCompleteListener localNetworkRequestCompleteListener = this.mRequestCompleteListener;
      if (localNetworkRequestCompleteListener != null) {
        localNetworkRequestCompleteListener.onResponseReceived(this, paramResponse);
      }
      return;
    }
  }
  
  protected VolleyError parseNetworkError(VolleyError paramVolleyError)
  {
    return paramVolleyError;
  }
  
  protected abstract Response<T> parseNetworkResponse(NetworkResponse paramNetworkResponse);
  
  void sendEvent(int paramInt)
  {
    RequestQueue localRequestQueue = this.mRequestQueue;
    if (localRequestQueue != null) {
      localRequestQueue.sendRequestEvent(this, paramInt);
    }
  }
  
  public Request<?> setCacheEntry(Cache.Entry paramEntry)
  {
    this.mCacheEntry = paramEntry;
    return this;
  }
  
  void setNetworkRequestCompleteListener(Request.NetworkRequestCompleteListener paramNetworkRequestCompleteListener)
  {
    synchronized (this.mLock)
    {
      this.mRequestCompleteListener = paramNetworkRequestCompleteListener;
      return;
    }
  }
  
  public Request<?> setRequestQueue(RequestQueue paramRequestQueue)
  {
    this.mRequestQueue = paramRequestQueue;
    return this;
  }
  
  public Request<?> setRetryPolicy(RetryPolicy paramRetryPolicy)
  {
    this.mRetryPolicy = paramRetryPolicy;
    return this;
  }
  
  public final Request<?> setSequence(int paramInt)
  {
    this.mSequence = Integer.valueOf(paramInt);
    return this;
  }
  
  public final Request<?> setShouldCache(boolean paramBoolean)
  {
    this.mShouldCache = paramBoolean;
    return this;
  }
  
  public final Request<?> setShouldRetryServerErrors(boolean paramBoolean)
  {
    this.mShouldRetryServerErrors = paramBoolean;
    return this;
  }
  
  public Request<?> setTag(Object paramObject)
  {
    this.mTag = paramObject;
    return this;
  }
  
  public final boolean shouldCache()
  {
    return this.mShouldCache;
  }
  
  public final boolean shouldRetryServerErrors()
  {
    return this.mShouldRetryServerErrors;
  }
  
  public String toString()
  {
    String str2 = "0x" + Integer.toHexString(getTrafficStatsTag());
    StringBuilder localStringBuilder = new StringBuilder();
    if (isCanceled()) {}
    for (String str1 = "[X] ";; str1 = "[ ] ") {
      return str1 + getUrl() + " " + str2 + " " + getPriority() + " " + this.mSequence;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.beacon.core.network.volley.Request
 * JD-Core Version:    0.7.0.1
 */