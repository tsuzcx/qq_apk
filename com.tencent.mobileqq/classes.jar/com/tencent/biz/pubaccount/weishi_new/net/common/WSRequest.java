package com.tencent.biz.pubaccount.weishi_new.net.common;

import QMF_PROTOCAL.RetryInfo;
import android.os.Bundle;
import com.qq.jce.wup.UniAttribute;
import com.qq.taf.jce.JceStruct;
import com.tencent.biz.pubaccount.weishi_new.config.experiment.WSExpABTestManager;
import com.tencent.biz.pubaccount.weishi_new.net.RspHeaderBean;
import com.tencent.biz.pubaccount.weishi_new.util.WSLog;
import com.tencent.mobileqq.utils.WupUtil;
import com.tencent.qphone.base.remote.FromServiceMsg;
import java.util.HashMap;
import java.util.Map;
import mqq.observer.BusinessObserver;

public abstract class WSRequest<Rsp extends JceStruct>
  implements WSResponseDecoder.DecodeCallback<Rsp>, BusinessObserver
{
  private static final String DEFAULT_COMMAND_PREFIX = "QzoneNewService.";
  private static final String TAG = "[WSService][Request]";
  private static final String TIMESTAMP_MSF2NET_M = "timestamp_msf2net_atMsfSite";
  public static final long TIME_OUT = 30000L;
  public static final String TIME_OUT_KEY = "timeout";
  private static final String WS_PREFIX = "WeishiGZH.";
  public static Map<Integer, Map<String, String>> pageTypeExtMap = new HashMap();
  protected volatile boolean isRetry = false;
  private final boolean mCanRetry;
  private String mCmd;
  private String mCommandPrefix = "QzoneNewService.";
  private final WSGzipCompressInfo mCompressInfo;
  public boolean mIsFirst;
  private boolean mIsGzipCompress;
  public boolean mIsRefresh;
  private boolean mIsRemoveWns;
  protected transient IWSProtocolListener<Rsp, UniAttribute> mListener;
  private long mLoginUserId = 0L;
  private final boolean mNeedRetry = false;
  private final long mPkgId;
  protected int mReqScene;
  public String mRequestId;
  protected String mRequestSubId;
  private int mRetryCount;
  private final WSServiceTimeRecord mTimeRecord;
  public final long mTimeout = 30000L;
  protected boolean needCompress = false;
  private final String onlyCmd;
  protected HashMap<Object, Object> params = new HashMap();
  public JceStruct req;
  public long reqSize;
  public int requestId = 100000;
  public long respSize;
  public JceStruct rsp;
  
  public WSRequest(JceStruct paramJceStruct, String paramString)
  {
    this("WeishiGZH.", paramString, true);
    this.req = paramJceStruct;
  }
  
  public WSRequest(String paramString)
  {
    this("WeishiGZH.", paramString, false);
  }
  
  public WSRequest(String paramString, int paramInt)
  {
    this("WeishiGZH.", paramString, false);
    this.mReqScene = paramInt;
  }
  
  public WSRequest(String paramString1, String paramString2, boolean paramBoolean)
  {
    this.onlyCmd = paramString2;
    this.mCmd = (paramString1 + paramString2);
    this.mCanRetry = paramBoolean;
    this.mPkgId = System.currentTimeMillis();
    this.mTimeRecord = new WSServiceTimeRecord(getRequestCmd());
    this.mCompressInfo = new WSGzipCompressInfo();
    getTimeRecord().a();
  }
  
  private long getTimestamp(Bundle paramBundle, String paramString)
  {
    if ((paramBundle == null) || (paramString == null)) {}
    while (!paramBundle.containsKey(paramString)) {
      return 0L;
    }
    return paramBundle.getLong(paramString);
  }
  
  private void onDataResponse(FromServiceMsg paramFromServiceMsg)
  {
    Object localObject1 = null;
    getTimeRecord().e();
    if (paramFromServiceMsg == null)
    {
      WSLog.d("[WSService][Request]", "[onDataResponse]" + getReqUniKey() + "MSF response is null");
      doFailCallback(null, 1000000, "response is null");
      return;
    }
    saveServiceInfo(paramFromServiceMsg);
    if (paramFromServiceMsg.getResultCode() == 1000)
    {
      localObject2 = paramFromServiceMsg.getWupBuffer();
      if (localObject2 != null) {
        this.respSize = localObject2.length;
      }
      WSLog.a("[WSService][Request]", "[onDataResponse]cmd=" + getRequestCmd() + ",response size=" + this.respSize + ",request size=" + this.reqSize + "，cost=" + getTimeRecord().c());
      if (localObject2 != null) {
        localObject1 = WupUtil.b((byte[])localObject2);
      }
      WSResponseDecoder.a(this, (byte[])localObject1, paramFromServiceMsg, this);
      return;
    }
    localObject1 = paramFromServiceMsg.extraData;
    Object localObject2 = paramFromServiceMsg.getBusinessFailMsg();
    WSLog.d("[WSService][Request]", "[onDataResponse]errMsg:" + (String)localObject2);
    addParameter("key_report_detail_msg", "errMsg:" + (String)localObject2);
    if ((!this.isRetry) && (needClientRetry()) && (localObject1 != null)) {
      if ((getTimestamp((Bundle)localObject1, "timestamp_msf2net_atMsfSite") <= 0L) || ((paramFromServiceMsg.getResultCode() != 1002) && (paramFromServiceMsg.getResultCode() != 1013))) {
        break label367;
      }
    }
    label367:
    for (boolean bool = true;; bool = false)
    {
      this.isRetry = bool;
      WSLog.a("[WSService][Request]", "[onDataResponse]cmd=" + getReqUniKey() + ", appSeq:" + paramFromServiceMsg.getAppSeq() + ", resultcode:" + paramFromServiceMsg.getResultCode() + " need retry send request");
      doFailCallback(null, paramFromServiceMsg.getResultCode() + 300000, null);
      return;
    }
  }
  
  private void saveServiceInfo(FromServiceMsg paramFromServiceMsg)
  {
    paramFromServiceMsg = paramFromServiceMsg.getAttribute("_tag_socket");
    if (paramFromServiceMsg == null) {}
    do
    {
      return;
      paramFromServiceMsg = paramFromServiceMsg.toString().split(":");
    } while ((paramFromServiceMsg == null) || (paramFromServiceMsg.length <= 1));
    this.params.put("key_request_server_ip", paramFromServiceMsg[0]);
    this.params.put("key_request_server_port", paramFromServiceMsg[1]);
  }
  
  public void addParameter(Object paramObject1, Object paramObject2)
  {
    this.params.put(paramObject1, paramObject2);
  }
  
  public boolean canRequestRetry()
  {
    return this.mCanRetry;
  }
  
  public void decodeFailure(UniAttribute paramUniAttribute, int paramInt, String paramString)
  {
    doFailCallback(paramUniAttribute, paramInt, paramString);
  }
  
  public void decodeSuccess(Rsp paramRsp, int paramInt, String paramString, RspHeaderBean paramRspHeaderBean)
  {
    WSLog.a("[WSService][Request]", "[doSuccessCallback]");
    if (this.mListener != null) {
      this.mListener.a(paramRsp, paramInt, paramString, false, paramRspHeaderBean);
    }
  }
  
  protected void doFailCallback(UniAttribute paramUniAttribute, int paramInt, String paramString)
  {
    WSLog.a("[WSService][Request]", "[doFailCallback]resultCode:" + paramInt + ", msg:" + paramString);
    if (this.mListener != null) {
      this.mListener.b(paramUniAttribute, paramInt, paramString, false, null);
    }
  }
  
  public byte[] encode()
  {
    byte[] arrayOfByte = WSRequestEncoder.a(this);
    getTimeRecord().c();
    return arrayOfByte;
  }
  
  public String getCmdString()
  {
    return this.mCommandPrefix + this.mCmd;
  }
  
  public WSGzipCompressInfo getCompressInfo()
  {
    return this.mCompressInfo;
  }
  
  public String getExpABTestDataStr()
  {
    if (isHeaderNeedExpABTestData())
    {
      String str = WSExpABTestManager.a().a();
      if (str != null) {
        return str;
      }
      return "";
    }
    return "";
  }
  
  public long getLoginUserId()
  {
    return this.mLoginUserId;
  }
  
  public String getOnlyCmd()
  {
    return this.onlyCmd;
  }
  
  public Object getParameter(Object paramObject)
  {
    return this.params.get(paramObject);
  }
  
  public JceStruct getReq()
  {
    return this.req;
  }
  
  public String getReqUniKey()
  {
    return "st" + getOnlyCmd() + "Req";
  }
  
  public String getRequestCmd()
  {
    return this.mCmd;
  }
  
  public long getRequestPkgId()
  {
    return this.mPkgId;
  }
  
  public int getRequestRetryCount()
  {
    return this.mRetryCount;
  }
  
  public int getRequestScene()
  {
    return this.mReqScene;
  }
  
  public String getRequestSubId()
  {
    return this.mRequestSubId;
  }
  
  public String getRequestType()
  {
    return "";
  }
  
  public Object getRetryInfo()
  {
    if (canRequestRetry()) {}
    for (int i = 1;; i = 0) {
      return new RetryInfo((short)i, (short)getRequestRetryCount(), getRequestPkgId());
    }
  }
  
  public abstract Class<Rsp> getRspClass();
  
  public String getRspUinKey()
  {
    return "st" + getOnlyCmd() + "Rsp";
  }
  
  public WSServiceTimeRecord getTimeRecord()
  {
    return this.mTimeRecord;
  }
  
  public boolean isFirst()
  {
    return this.mIsFirst;
  }
  
  public boolean isGzipCompress()
  {
    return this.mIsGzipCompress;
  }
  
  public boolean isHeaderNeedExpABTestData()
  {
    return true;
  }
  
  public boolean isNeedCompress()
  {
    return this.needCompress;
  }
  
  public boolean isRefresh()
  {
    return this.mIsRefresh;
  }
  
  public boolean isRemoveWns()
  {
    return this.mIsRemoveWns;
  }
  
  public boolean isReportPerformance()
  {
    return true;
  }
  
  public boolean isShouldStartQQAuth()
  {
    return true;
  }
  
  protected boolean needClientRetry()
  {
    return false;
  }
  
  public void onReceive(int paramInt, boolean paramBoolean, Bundle paramBundle)
  {
    onDataResponse((FromServiceMsg)paramBundle.get("response"));
  }
  
  public void setCmdString(String paramString)
  {
    this.mCmd = paramString;
  }
  
  public void setCommandPrefix(String paramString)
  {
    this.mCommandPrefix = paramString;
  }
  
  public void setGzipCompress(boolean paramBoolean)
  {
    this.mIsGzipCompress = paramBoolean;
  }
  
  public void setListener(IWSProtocolListener<Rsp, UniAttribute> paramIWSProtocolListener)
  {
    this.mListener = paramIWSProtocolListener;
  }
  
  public void setLoginUserId(long paramLong)
  {
    this.mLoginUserId = paramLong;
  }
  
  public void setRemoveWns(boolean paramBoolean)
  {
    this.mIsRemoveWns = paramBoolean;
  }
  
  public void setRequestRetryCount(int paramInt)
  {
    this.mRetryCount = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.net.common.WSRequest
 * JD-Core Version:    0.7.0.1
 */