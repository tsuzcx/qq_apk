package com.tencent.biz.qqcircle.requests;

import NS_COMM.COMM.Entry;
import NS_QWEB_PROTOCAL.PROTOCAL.StQWebReq;
import NS_QWEB_PROTOCAL.PROTOCAL.StQWebRsp;
import android.text.TextUtils;
import com.tencent.biz.qqcircle.QCirclePluginGlobalInfo;
import com.tencent.biz.qqcircle.debug.mocklbs.data.MockLbsInfo;
import com.tencent.biz.richframework.network.request.VSBaseRequest;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.qcircle.api.constant.QCircleAlphaUserReportDataBuilder;
import com.tencent.mobileqq.soso.location.data.SosoLbsInfo;
import com.tencent.qcircle.application.QCircleApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.richframework.common.RFWCommonGlobalInfo;
import cooperation.qqcircle.report.QCircleAlphaUserReporter;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public abstract class QCircleBaseRequest
  extends VSBaseRequest
{
  private String a(PROTOCAL.StQWebRsp paramStQWebRsp)
  {
    if (paramStQWebRsp != null)
    {
      if (paramStQWebRsp.Extinfo.isEmpty()) {
        return null;
      }
      paramStQWebRsp = paramStQWebRsp.Extinfo.get().iterator();
      while (paramStQWebRsp.hasNext())
      {
        COMM.Entry localEntry = (COMM.Entry)paramStQWebRsp.next();
        if ((localEntry != null) && ("gwRPTransfer".equals(localEntry.key.get()))) {
          return localEntry.value.get();
        }
      }
    }
    return null;
  }
  
  protected String getAttachInfo()
  {
    return null;
  }
  
  protected int getCount()
  {
    return 0;
  }
  
  protected HashMap<String, String> getExtras()
  {
    return null;
  }
  
  protected String getFeedId()
  {
    return null;
  }
  
  protected String getInfo()
  {
    return null;
  }
  
  protected String getLatitude(SosoLbsInfo paramSosoLbsInfo)
  {
    if ((QCircleApplication.isRDMVersion()) && (QCirclePluginGlobalInfo.j() != null) && (!TextUtils.isEmpty(QCirclePluginGlobalInfo.j().latitude))) {
      return QCirclePluginGlobalInfo.j().latitude;
    }
    return super.getLatitude(paramSosoLbsInfo);
  }
  
  protected String getLongitude(SosoLbsInfo paramSosoLbsInfo)
  {
    if ((QCircleApplication.isRDMVersion()) && (QCirclePluginGlobalInfo.j() != null) && (!TextUtils.isEmpty(QCirclePluginGlobalInfo.j().longitude))) {
      return QCirclePluginGlobalInfo.j().longitude;
    }
    return super.getLongitude(paramSosoLbsInfo);
  }
  
  protected double getRate()
  {
    return 0.0D;
  }
  
  protected String getRefer()
  {
    return null;
  }
  
  protected byte[] getRequestWrapper(ByteStringMicro paramByteStringMicro)
  {
    PROTOCAL.StQWebReq localStQWebReq = new PROTOCAL.StQWebReq();
    try
    {
      localStQWebReq.mergeFrom(super.getRequestWrapper(paramByteStringMicro));
    }
    catch (InvalidProtocolBufferMicroException paramByteStringMicro)
    {
      paramByteStringMicro.printStackTrace();
    }
    paramByteStringMicro = new COMM.Entry();
    paramByteStringMicro.key.set("fc-appid");
    paramByteStringMicro.value.set("92");
    localStQWebReq.Extinfo.add(paramByteStringMicro);
    paramByteStringMicro = new COMM.Entry();
    paramByteStringMicro.key.set("sw-plugin-qua");
    paramByteStringMicro.value.set(QCirclePluginGlobalInfo.l());
    localStQWebReq.Extinfo.add(paramByteStringMicro);
    paramByteStringMicro = new COMM.Entry();
    paramByteStringMicro.key.set("environment_id");
    paramByteStringMicro.value.set(RFWCommonGlobalInfo.a());
    localStQWebReq.Extinfo.add(paramByteStringMicro);
    return localStQWebReq.toByteArray();
  }
  
  protected String getRetCode()
  {
    return null;
  }
  
  public long[] getRetryRetCodes()
  {
    return null;
  }
  
  protected String getState()
  {
    return null;
  }
  
  protected String getType()
  {
    return null;
  }
  
  protected String getUrl()
  {
    return null;
  }
  
  protected String getUser()
  {
    return null;
  }
  
  public boolean isNeedRetry(long paramLong)
  {
    boolean bool1;
    if (paramLong == -2L) {
      bool1 = false;
    } else {
      bool1 = true;
    }
    Object localObject = getRetryRetCodes();
    boolean bool2 = bool1;
    if (localObject != null)
    {
      bool2 = bool1;
      if (localObject.length > 0)
      {
        int j = localObject.length;
        int i = 0;
        while (i < j)
        {
          if (localObject[i] == paramLong)
          {
            bool2 = true;
            break label80;
          }
          i += 1;
        }
        bool2 = false;
      }
    }
    label80:
    localObject = getCmdName();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("isNeedRetry:");
    localStringBuilder.append(bool2);
    QLog.d("VSBaseRequest", 1, new Object[] { "CmdName:", localObject, ",retCode:", Long.valueOf(paramLong), localStringBuilder.toString() });
    return bool2;
  }
  
  public void reportCmdSuccessRate(PROTOCAL.StQWebRsp paramStQWebRsp)
  {
    long l;
    String str;
    if (getSsoResultCode() == 1000)
    {
      l = paramStQWebRsp.retCode.get();
      str = paramStQWebRsp.errMsg.get().toStringUtf8();
    }
    else
    {
      l = getSsoResultCode();
      str = getSsoFailMsg();
    }
    QCircleAlphaUserReporter.reportCmdSuccessRateEvent(new QCircleAlphaUserReportDataBuilder().setCmd(getCmdName()).setSvrRetCode(String.valueOf(l)).setRetCode(getRetCode()).setInfo(getInfo()).setMsg(str).setTimeCost(getNetworkTimeCost()).setUrl(getUrl()).setRate(getRate()).setType(getType()).setRefer(getRefer()).setAttachInfo(getAttachInfo()).setExtraInfo(getTraceId()).setCount(getCount()).setState(getState()).setFeedId(getFeedId()).setUser(getUser()).setExtras(getExtras()).setGwRpTransfer(a(paramStQWebRsp)));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.requests.QCircleBaseRequest
 * JD-Core Version:    0.7.0.1
 */