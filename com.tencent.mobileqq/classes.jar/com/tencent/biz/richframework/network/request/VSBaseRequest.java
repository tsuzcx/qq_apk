package com.tencent.biz.richframework.network.request;

import NS_QWEB_PROTOCAL.PROTOCAL.StQWebReq;
import NS_QWEB_PROTOCAL.PROTOCAL.StQWebRsp;
import com.tencent.biz.richframework.network.cache.Cache;
import com.tencent.biz.richframework.network.cache.CacheHelper;
import com.tencent.biz.richframework.widget.BaseVideoView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.soso.LbsManagerService;
import com.tencent.mobileqq.app.soso.SosoInterface.SosoLbsInfo;
import com.tencent.mobileqq.app.soso.SosoInterface.SosoLocation;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.PlatformInfor;
import cooperation.qzone.QUA;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;
import java.util.TimeZone;
import java.util.concurrent.atomic.AtomicInteger;
import mqq.app.AppRuntime;
import org.jetbrains.annotations.NotNull;

public abstract class VSBaseRequest
  implements Serializable
{
  public static final int RETRY_LIMIT = 5;
  public static final String TAG = "VSBaseRequest";
  public static final AtomicInteger atomicInteger = new AtomicInteger(0);
  private static final long serialVersionUID = -1L;
  private boolean isEnableCache;
  private int mContextHashCode = -1;
  private String mRequestKey;
  private int mRetryCount;
  private int mSeq;
  protected String mTraceId;
  
  public static String concactRetCodeAndMsg(long paramLong, String paramString)
  {
    return ", retcode:" + paramLong + " | errMsg:" + paramString;
  }
  
  private String generateDeviceInfo()
  {
    Object localObject2 = PlatformInfor.g().getDeviceInfor();
    Object localObject1 = localObject2;
    StringBuilder localStringBuilder;
    if (localObject2 != null)
    {
      localObject1 = localObject2;
      if (((String)localObject2).length() > 0)
      {
        localObject2 = new StringBuilder((String)localObject2);
        ((StringBuilder)localObject2).append('&');
        ((StringBuilder)localObject2).append("timezone=").append(TimeZone.getDefault().getID());
        localObject1 = LbsManagerService.getCachedLbsInfo("qqcircle");
        if ((localObject1 != null) && (((SosoInterface.SosoLbsInfo)localObject1).mLocation != null))
        {
          ((StringBuilder)localObject2).append('&');
          ((StringBuilder)localObject2).append("latitude=").append(String.valueOf(((SosoInterface.SosoLbsInfo)localObject1).mLocation.mLat02));
          ((StringBuilder)localObject2).append('&');
          ((StringBuilder)localObject2).append("longitude=").append(String.valueOf(((SosoInterface.SosoLbsInfo)localObject1).mLocation.mLon02));
        }
        ((StringBuilder)localObject2).append('&');
        localStringBuilder = ((StringBuilder)localObject2).append("vh265=");
        if (!BaseVideoView.a.equals("")) {
          break label168;
        }
      }
    }
    label168:
    for (localObject1 = Integer.valueOf(0);; localObject1 = BaseVideoView.a)
    {
      localStringBuilder.append(localObject1);
      localObject1 = ((StringBuilder)localObject2).toString();
      return localObject1;
    }
  }
  
  private String generateTraceId()
  {
    String str = BaseApplicationImpl.sApplication.getRuntime().getAccount();
    StringBuilder localStringBuilder = new StringBuilder(50);
    SimpleDateFormat localSimpleDateFormat = new SimpleDateFormat("MMddHHmmss");
    Random localRandom = new Random();
    localRandom.setSeed(System.currentTimeMillis());
    localStringBuilder.append(str).append("_").append(localSimpleDateFormat.format(new Date())).append(System.currentTimeMillis() % 1000L).append("_").append(localRandom.nextInt(90000) + 10000);
    return localStringBuilder.toString();
  }
  
  public static boolean isCacheExist(VSBaseRequest paramVSBaseRequest)
  {
    if ((paramVSBaseRequest == null) || (paramVSBaseRequest.getRequestByteData() == null)) {
      return false;
    }
    return CacheHelper.fileCache().cacheExists(paramVSBaseRequest.getCmdName() + BaseApplicationImpl.sApplication.getRuntime().getAccount() + QUA.getQUA3() + new String(paramVSBaseRequest.getRequestByteKey()));
  }
  
  public static void reMoveCache(VSBaseRequest paramVSBaseRequest)
  {
    if ((paramVSBaseRequest == null) || (paramVSBaseRequest.getRequestByteData() == null)) {
      return;
    }
    CacheHelper.fileCache().remove(paramVSBaseRequest.getCmdName() + BaseApplicationImpl.sApplication.getRuntime().getAccount() + QUA.getQUA3() + new String(paramVSBaseRequest.getRequestByteKey()));
  }
  
  public abstract MessageMicro decode(byte[] paramArrayOfByte);
  
  public byte[] encode()
  {
    Object localObject = getRequestByteData();
    if (isEnableCache()) {
      this.mRequestKey = (getCmdName() + BaseApplicationImpl.sApplication.getRuntime().getAccount() + QUA.getQUA3() + new String(getRequestByteKey()));
    }
    localObject = getRequestWrapper(ByteStringMicro.copyFrom((byte[])localObject));
    if (localObject != null) {
      return ((MessageMicro)localObject).toByteArray();
    }
    return new byte[0];
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
  
  @Deprecated
  public int getNewSeq()
  {
    this.mSeq = atomicInteger.getAndIncrement();
    this.mTraceId = generateTraceId();
    return this.mSeq;
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
  
  @NotNull
  protected MessageMicro getRequestWrapper(ByteStringMicro paramByteStringMicro)
  {
    PROTOCAL.StQWebReq localStQWebReq = new PROTOCAL.StQWebReq();
    localStQWebReq.Seq.set(getCurrentSeq());
    localStQWebReq.qua.set(QUA.getQUA3());
    localStQWebReq.deviceInfo.set(generateDeviceInfo());
    localStQWebReq.busiBuff.set(paramByteStringMicro);
    localStQWebReq.traceid.set(this.mTraceId);
    return localStQWebReq;
  }
  
  public int getRetryCount()
  {
    return this.mRetryCount;
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
      QLog.d("VSBaseRequest", 1, new Object[] { "CmdName:", getCmdName(), ",retCode:", Long.valueOf(paramLong), "isNeedRetry:" + bool });
      return bool;
    }
  }
  
  public Object[] parseResponseWrapper(byte[] paramArrayOfByte)
  {
    PROTOCAL.StQWebRsp localStQWebRsp = new PROTOCAL.StQWebRsp();
    localStQWebRsp.mergeFrom(paramArrayOfByte);
    return new Object[] { Long.valueOf(localStQWebRsp.retCode.get()), localStQWebRsp.errMsg.get().toStringUtf8(), localStQWebRsp.busiBuff.get() };
  }
  
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.richframework.network.request.VSBaseRequest
 * JD-Core Version:    0.7.0.1
 */