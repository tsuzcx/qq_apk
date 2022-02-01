package com.tencent.biz.richframework.network.request;

import com.tencent.biz.richframework.delegate.impl.RFLog;
import com.tencent.biz.richframework.network.VSNetworkHelper;
import com.tencent.biz.richframework.network.cache.Cache;
import com.tencent.biz.richframework.network.cache.CacheHelper;
import com.tencent.biz.richframework.network.delegate.VSBaseNetwork;
import com.tencent.biz.richframework.network.util.StringUtils;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;

public abstract class BaseRequest
  implements Serializable
{
  public static final int RETRY_LIMIT = 5;
  public static final String TAG = "VSBaseRequest";
  public static final AtomicInteger atomicInteger = new AtomicInteger(0);
  private static final long serialVersionUID = -1L;
  private boolean isEnableCache = false;
  private int mContextHashCode = -1;
  private String mOverrideTraceId;
  private String mRequestKey;
  private int mRetryCount = 0;
  private long mSendTimeStamp;
  private int mSeq;
  protected String mTraceId;
  
  public static String concactRetCodeAndMsg(long paramLong, String paramString)
  {
    return ", retcode:" + paramLong + " | errMsg:" + paramString;
  }
  
  public static String generateTraceId()
  {
    VSNetworkHelper.getInstance();
    String str = VSNetworkHelper.getNetworkImpl().getAccountId();
    StringBuilder localStringBuilder = new StringBuilder(50);
    SimpleDateFormat localSimpleDateFormat = new SimpleDateFormat("MMddHHmmss");
    Random localRandom = new Random();
    localRandom.setSeed(System.currentTimeMillis());
    localStringBuilder.append(str).append("_").append(localSimpleDateFormat.format(new Date())).append(System.currentTimeMillis() % 1000L).append("_").append(localRandom.nextInt(90000) + 10000);
    return localStringBuilder.toString();
  }
  
  public static boolean isCacheExist(BaseRequest paramBaseRequest)
  {
    if ((paramBaseRequest == null) || (paramBaseRequest.getRequestByteData() == null)) {
      return false;
    }
    return CacheHelper.fileCache().cacheExists(paramBaseRequest.getCmdName() + VSNetworkHelper.getNetworkImpl().getAccountId() + VSNetworkHelper.getNetworkImpl().getQUA() + new String(paramBaseRequest.getRequestByteKey()));
  }
  
  public static void reMoveCache(BaseRequest paramBaseRequest)
  {
    if ((paramBaseRequest == null) || (paramBaseRequest.getRequestByteData() == null)) {
      return;
    }
    CacheHelper.fileCache().remove(paramBaseRequest.getCmdName() + VSNetworkHelper.getNetworkImpl().getAccountId() + VSNetworkHelper.getNetworkImpl().getQUA() + new String(paramBaseRequest.getRequestByteKey()));
  }
  
  public abstract <T> T decode(byte[] paramArrayOfByte);
  
  public byte[] encode()
  {
    byte[] arrayOfByte = getRequestByteData();
    if (isEnableCache()) {
      this.mRequestKey = (getCmdName() + VSNetworkHelper.getNetworkImpl().getAccountId() + VSNetworkHelper.getNetworkImpl().getQUA() + new String(getRequestByteKey()));
    }
    return getFinalRequestData(arrayOfByte);
  }
  
  public void generateSendTimeStamp()
  {
    this.mSendTimeStamp = System.currentTimeMillis();
  }
  
  public abstract String getCmdName();
  
  public int getContextHashCode()
  {
    return this.mContextHashCode;
  }
  
  public int getCurrentSeq()
  {
    return this.mSeq;
  }
  
  protected abstract byte[] getFinalRequestData(byte[] paramArrayOfByte);
  
  @Deprecated
  public int getNewSeq()
  {
    this.mSeq = atomicInteger.getAndIncrement();
    if (StringUtils.isEmpty(this.mOverrideTraceId)) {}
    for (String str = generateTraceId();; str = this.mOverrideTraceId)
    {
      this.mTraceId = str;
      return this.mSeq;
    }
  }
  
  protected abstract byte[] getRequestByteData();
  
  public byte[] getRequestByteKey()
  {
    return getRequestByteData();
  }
  
  public String getRequestKey()
  {
    return this.mRequestKey;
  }
  
  public int getRetryCount()
  {
    return this.mRetryCount;
  }
  
  public long getSendTimeStamp()
  {
    return this.mSendTimeStamp;
  }
  
  public String getTraceId()
  {
    return this.mTraceId;
  }
  
  public boolean isAsyncCallBack()
  {
    return true;
  }
  
  public boolean isEnableCache()
  {
    return this.isEnableCache;
  }
  
  public boolean isNeedRetry(long paramLong)
  {
    if (paramLong == -2L) {}
    for (boolean bool = false;; bool = true)
    {
      RFLog.d("VSBaseRequest", RFLog.USR, new Object[] { "CmdName:", getCmdName(), ",retCode:", Long.valueOf(paramLong), "isNeedRetry:" + bool });
      return bool;
    }
  }
  
  public boolean isSuccessRetCode(long paramLong)
  {
    return paramLong == 0L;
  }
  
  public void overrideTraceId(String paramString)
  {
    this.mOverrideTraceId = paramString;
  }
  
  public abstract Object[] parseResponseHeadInfo(byte[] paramArrayOfByte);
  
  public void setContextHashCode(int paramInt)
  {
    this.mContextHashCode = paramInt;
  }
  
  public void setEnableCache(boolean paramBoolean)
  {
    this.isEnableCache = paramBoolean;
  }
  
  public void setRetryCount(int paramInt)
  {
    int i = paramInt;
    if (paramInt > 5) {
      i = 5;
    }
    this.mRetryCount = i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.richframework.network.request.BaseRequest
 * JD-Core Version:    0.7.0.1
 */