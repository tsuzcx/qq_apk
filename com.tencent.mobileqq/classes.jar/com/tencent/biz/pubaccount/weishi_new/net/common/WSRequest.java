package com.tencent.biz.pubaccount.weishi_new.net.common;

import android.os.Bundle;
import com.qq.jce.wup.UniAttribute;
import com.qq.taf.jce.JceStruct;
import com.tencent.biz.pubaccount.weishi_new.config.experiment.WSExpABTestManager;
import com.tencent.biz.pubaccount.weishi_new.net.RspHeaderBean;
import com.tencent.biz.pubaccount.weishi_new.report.WSLaunchDeltaTimeCalculator;
import com.tencent.biz.pubaccount.weishi_new.util.WSInitializeHelper;
import com.tencent.biz.pubaccount.weishi_new.util.WSLog;
import com.tencent.biz.pubaccount.weishi_new.util.WeishiUtils;
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
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramString1);
    localStringBuilder.append(paramString2);
    this.mCmd = localStringBuilder.toString();
    this.mCanRetry = paramBoolean;
    this.mPkgId = System.currentTimeMillis();
    this.mTimeRecord = new WSServiceTimeRecord(getRequestCmd());
    this.mCompressInfo = new WSGzipCompressInfo();
    getTimeRecord().a();
    setLoginUserId(WeishiUtils.b());
  }
  
  private long getTimestamp(Bundle paramBundle, String paramString)
  {
    if (paramBundle != null)
    {
      if (paramString == null) {
        return 0L;
      }
      if (paramBundle.containsKey(paramString)) {
        return paramBundle.getLong(paramString);
      }
    }
    return 0L;
  }
  
  private void onDataResponse(FromServiceMsg paramFromServiceMsg)
  {
    getTimeRecord().e();
    if (isNeedLaunchCalculator()) {
      WSInitializeHelper.a().h().c();
    }
    Object localObject1 = null;
    if (paramFromServiceMsg == null)
    {
      paramFromServiceMsg = new StringBuilder();
      paramFromServiceMsg.append("[onDataResponse]");
      paramFromServiceMsg.append(getReqUniKey());
      paramFromServiceMsg.append("MSF response is null");
      WSLog.d("[WSService][Request]", paramFromServiceMsg.toString());
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
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("[onDataResponse]cmd=");
      localStringBuilder.append(getRequestCmd());
      localStringBuilder.append(",response size=");
      localStringBuilder.append(this.respSize);
      localStringBuilder.append(",request size=");
      localStringBuilder.append(this.reqSize);
      localStringBuilder.append("，cost=");
      localStringBuilder.append(getTimeRecord().p());
      WSLog.a("[WSService][Request]", localStringBuilder.toString());
      if (localObject2 != null) {
        localObject1 = WupUtil.b((byte[])localObject2);
      }
      WSResponseDecoder.a(this, (byte[])localObject1, paramFromServiceMsg, this);
      return;
    }
    localObject1 = paramFromServiceMsg.extraData;
    Object localObject2 = paramFromServiceMsg.getBusinessFailMsg();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[onDataResponse]errMsg:");
    localStringBuilder.append((String)localObject2);
    WSLog.d("[WSService][Request]", localStringBuilder.toString());
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("errMsg:");
    localStringBuilder.append((String)localObject2);
    addParameter("key_report_detail_msg", localStringBuilder.toString());
    if ((!this.isRetry) && (needClientRetry()) && (localObject1 != null))
    {
      boolean bool;
      if ((getTimestamp((Bundle)localObject1, "timestamp_msf2net_atMsfSite") > 0L) && ((paramFromServiceMsg.getResultCode() == 1002) || (paramFromServiceMsg.getResultCode() == 1013))) {
        bool = true;
      } else {
        bool = false;
      }
      this.isRetry = bool;
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("[onDataResponse]cmd=");
      ((StringBuilder)localObject1).append(getReqUniKey());
      ((StringBuilder)localObject1).append(", appSeq:");
      ((StringBuilder)localObject1).append(paramFromServiceMsg.getAppSeq());
      ((StringBuilder)localObject1).append(", resultcode:");
      ((StringBuilder)localObject1).append(paramFromServiceMsg.getResultCode());
      ((StringBuilder)localObject1).append(" need retry send request");
      WSLog.a("[WSService][Request]", ((StringBuilder)localObject1).toString());
    }
    doFailCallback(null, paramFromServiceMsg.getResultCode() + 300000, null);
  }
  
  private void saveServiceInfo(FromServiceMsg paramFromServiceMsg)
  {
    paramFromServiceMsg = paramFromServiceMsg.getAttribute("_tag_socket");
    if (paramFromServiceMsg == null) {
      return;
    }
    paramFromServiceMsg = paramFromServiceMsg.toString().split(":");
    if ((paramFromServiceMsg != null) && (paramFromServiceMsg.length > 1))
    {
      this.params.put("key_request_server_ip", paramFromServiceMsg[0]);
      this.params.put("key_request_server_port", paramFromServiceMsg[1]);
    }
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
    IWSProtocolListener localIWSProtocolListener = this.mListener;
    if (localIWSProtocolListener != null) {
      localIWSProtocolListener.a(paramRsp, paramInt, paramString, false, paramRspHeaderBean);
    }
  }
  
  protected void doFailCallback(UniAttribute paramUniAttribute, int paramInt, String paramString)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("[doFailCallback]resultCode:");
    ((StringBuilder)localObject).append(paramInt);
    ((StringBuilder)localObject).append(", msg:");
    ((StringBuilder)localObject).append(paramString);
    WSLog.a("[WSService][Request]", ((StringBuilder)localObject).toString());
    localObject = this.mListener;
    if (localObject != null) {
      ((IWSProtocolListener)localObject).b(paramUniAttribute, paramInt, paramString, false, null);
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
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(this.mCommandPrefix);
    localStringBuilder.append(this.mCmd);
    return localStringBuilder.toString();
  }
  
  public WSGzipCompressInfo getCompressInfo()
  {
    return this.mCompressInfo;
  }
  
  public String getExpABTestDataStr()
  {
    if (isHeaderNeedExpABTestData())
    {
      String str = WSExpABTestManager.a().d();
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
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("st");
    localStringBuilder.append(getOnlyCmd());
    localStringBuilder.append("Req");
    return localStringBuilder.toString();
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
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.provideAs(TypeTransformer.java:780)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.enexpr(TypeTransformer.java:659)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:719)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.e1expr(TypeTransformer.java:539)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:713)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.enexpr(TypeTransformer.java:698)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:719)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.s1stmt(TypeTransformer.java:810)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.sxStmt(TypeTransformer.java:840)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:206)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
  
  public abstract Class<Rsp> getRspClass();
  
  public String getRspUinKey()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("st");
    localStringBuilder.append(getOnlyCmd());
    localStringBuilder.append("Rsp");
    return localStringBuilder.toString();
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
  
  public boolean isNeedLaunchCalculator()
  {
    return false;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.net.common.WSRequest
 * JD-Core Version:    0.7.0.1
 */