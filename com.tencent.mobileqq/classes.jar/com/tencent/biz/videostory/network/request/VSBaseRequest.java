package com.tencent.biz.videostory.network.request;

import NS_QWEB_PROTOCAL.PROTOCAL.StQWebReq;
import bgxq;
import bgxr;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt64Field;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;
import mqq.app.AppRuntime;
import xgr;
import xgt;

public abstract class VSBaseRequest
  implements Serializable
{
  public static final String TAG = "VSBaseRequest";
  public static final AtomicInteger atomicInteger = new AtomicInteger(0);
  private static final long serialVersionUID = -1L;
  private boolean isEnableCache;
  private String mRequestKey;
  private int mSeq;
  private String mTraceId;
  
  private String a()
  {
    String str = BaseApplicationImpl.sApplication.getRuntime().getAccount();
    StringBuilder localStringBuilder = new StringBuilder(50);
    SimpleDateFormat localSimpleDateFormat = new SimpleDateFormat("MMddHHmmss");
    Random localRandom = new Random();
    localRandom.setSeed(System.currentTimeMillis());
    localStringBuilder.append(str).append("_").append(localSimpleDateFormat.format(new Date())).append(System.currentTimeMillis() % 1000L).append("_").append(localRandom.nextInt(90000) + 10000);
    return localStringBuilder.toString();
  }
  
  public static String concactRetCodeAndMsg(long paramLong, String paramString)
  {
    return ", retcode:" + paramLong + " | errMsg:" + paramString;
  }
  
  public static boolean isCacheExist(VSBaseRequest paramVSBaseRequest)
  {
    if ((paramVSBaseRequest == null) || (paramVSBaseRequest.getRequestByteData() == null)) {
      return false;
    }
    return xgt.a().a(BaseApplicationImpl.sApplication.getRuntime().getAccount() + bgxr.a() + new String(paramVSBaseRequest.getRequestByteData()));
  }
  
  public static void reMoveCache(VSBaseRequest paramVSBaseRequest)
  {
    if ((paramVSBaseRequest == null) || (paramVSBaseRequest.getRequestByteData() == null)) {
      return;
    }
    xgt.a().a(BaseApplicationImpl.sApplication.getRuntime().getAccount() + bgxr.a() + new String(paramVSBaseRequest.getRequestByteData()));
  }
  
  public abstract MessageMicro decode(byte[] paramArrayOfByte);
  
  public byte[] encode()
  {
    PROTOCAL.StQWebReq localStQWebReq = new PROTOCAL.StQWebReq();
    localStQWebReq.Seq.set(this.mSeq);
    localStQWebReq.qua.set(bgxr.a());
    localStQWebReq.deviceInfo.set(bgxq.a().c());
    byte[] arrayOfByte = getRequestByteData();
    localStQWebReq.busiBuff.set(ByteStringMicro.copyFrom(arrayOfByte));
    localStQWebReq.traceid.set(this.mTraceId);
    if (isEnableCache()) {
      this.mRequestKey = (getCmdName() + BaseApplicationImpl.sApplication.getRuntime().getAccount() + bgxr.a() + new String(arrayOfByte));
    }
    return localStQWebReq.toByteArray();
  }
  
  public abstract String getCmdName();
  
  public int getCurrentSeq()
  {
    return this.mSeq;
  }
  
  public int getNewSeq()
  {
    this.mSeq = atomicInteger.getAndIncrement();
    this.mTraceId = a();
    return this.mSeq;
  }
  
  protected abstract byte[] getRequestByteData();
  
  public String getRequestKey()
  {
    return this.mRequestKey;
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
  
  public void setEnableCache(boolean paramBoolean)
  {
    this.isEnableCache = paramBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.biz.videostory.network.request.VSBaseRequest
 * JD-Core Version:    0.7.0.1
 */