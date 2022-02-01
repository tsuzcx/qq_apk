package com.tencent.biz.richframework.network.request;

import NS_QWEB_PROTOCAL.PROTOCAL.StQWebReq;
import NS_QWEB_PROTOCAL.PROTOCAL.StQWebRsp;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.qcircle.api.data.QCircleExposeDataBean;
import com.tencent.mobileqq.qcircle.tempapi.api.IQZoneService;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.soso.location.api.ILbsManagerServiceApi;
import com.tencent.mobileqq.soso.location.data.SosoLbsInfo;
import com.tencent.mobileqq.soso.location.data.SosoLocation;
import com.tencent.mobileqq.utils.WupUtil;
import java.util.TimeZone;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

public abstract class VSBaseRequest
  extends BaseRequest
{
  private final String QUA3 = ((IQZoneService)this.mAppRuntime.getRuntimeService(IQZoneService.class, "all")).getQUA3();
  private final AppRuntime mAppRuntime = MobileQQ.sMobileQQ.waitAppRuntime(null);
  private long mNetworkTimeCost;
  private String mSsoFailMsg;
  private int mSsoResultCode;
  private int mSsoSeq;
  private final ThreadLocal<StringBuilder> mStringBuilder = new VSBaseRequest.1(this);
  
  private String generateDeviceInfo()
  {
    Object localObject = ((IQZoneService)this.mAppRuntime.getRuntimeService(IQZoneService.class, "all")).getDeviceInfo();
    StringBuilder localStringBuilder1 = (StringBuilder)this.mStringBuilder.get();
    if ((localObject != null) && (((String)localObject).length() > 0) && (localStringBuilder1 != null))
    {
      localStringBuilder1.setLength(0);
      localStringBuilder1.append((String)localObject);
      localStringBuilder1.append('&');
      localStringBuilder1.append("timezone=").append(TimeZone.getDefault().getID());
      localObject = ((ILbsManagerServiceApi)QRoute.api(ILbsManagerServiceApi.class)).getCachedLbsInfo("qqcircle");
      if ((localObject != null) && (((SosoLbsInfo)localObject).mLocation != null))
      {
        localStringBuilder1.append('&');
        localStringBuilder1.append("latitude=").append(String.valueOf(((SosoLbsInfo)localObject).mLocation.mLat02));
        localStringBuilder1.append('&');
        localStringBuilder1.append("longitude=").append(String.valueOf(((SosoLbsInfo)localObject).mLocation.mLon02));
      }
      localStringBuilder1.append('&');
      StringBuilder localStringBuilder2 = localStringBuilder1.append("vh265=");
      if ("".equals(QCircleExposeDataBean.sIsSupportHEVC)) {}
      for (localObject = Integer.valueOf(0);; localObject = QCircleExposeDataBean.sIsSupportHEVC)
      {
        localStringBuilder2.append(localObject);
        return localStringBuilder1.toString();
      }
    }
    this.mStringBuilder.remove();
    return localObject;
  }
  
  protected byte[] getFinalRequestData(byte[] paramArrayOfByte)
  {
    paramArrayOfByte = getRequestWrapper(ByteStringMicro.copyFrom(paramArrayOfByte));
    if (paramArrayOfByte != null) {
      return paramArrayOfByte;
    }
    return new byte[0];
  }
  
  public long getNetworkTimeCost()
  {
    return this.mNetworkTimeCost;
  }
  
  protected byte[] getRequestWrapper(ByteStringMicro paramByteStringMicro)
  {
    PROTOCAL.StQWebReq localStQWebReq = new PROTOCAL.StQWebReq();
    localStQWebReq.Seq.set(getCurrentSeq());
    localStQWebReq.qua.set(this.QUA3);
    localStQWebReq.deviceInfo.set(generateDeviceInfo());
    localStQWebReq.busiBuff.set(paramByteStringMicro);
    localStQWebReq.traceid.set(this.mTraceId);
    return localStQWebReq.toByteArray();
  }
  
  public String getSsoFailMsg()
  {
    return this.mSsoFailMsg;
  }
  
  public int getSsoResultCode()
  {
    return this.mSsoResultCode;
  }
  
  public int getSsoSeq()
  {
    return this.mSsoSeq;
  }
  
  public Object[] parseResponseHeadInfo(byte[] paramArrayOfByte)
  {
    PROTOCAL.StQWebRsp localStQWebRsp = new PROTOCAL.StQWebRsp();
    try
    {
      localStQWebRsp.mergeFrom(WupUtil.b(paramArrayOfByte));
      long l = localStQWebRsp.retCode.get();
      paramArrayOfByte = localStQWebRsp.errMsg.get().toStringUtf8();
      byte[] arrayOfByte = localStQWebRsp.busiBuff.get().toByteArray();
      reportCmdSuccessRate(localStQWebRsp);
      return new Object[] { Long.valueOf(l), paramArrayOfByte, arrayOfByte };
    }
    catch (InvalidProtocolBufferMicroException paramArrayOfByte)
    {
      for (;;)
      {
        paramArrayOfByte.printStackTrace();
      }
    }
  }
  
  public void reportCmdSuccessRate(PROTOCAL.StQWebRsp paramStQWebRsp) {}
  
  public void setNetworkTimeCost(long paramLong)
  {
    this.mNetworkTimeCost = paramLong;
  }
  
  public void setSsoFailMsg(String paramString)
  {
    this.mSsoFailMsg = paramString;
  }
  
  public void setSsoResultCode(int paramInt)
  {
    this.mSsoResultCode = paramInt;
  }
  
  public void setSsoSeq(int paramInt)
  {
    this.mSsoSeq = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.richframework.network.request.VSBaseRequest
 * JD-Core Version:    0.7.0.1
 */