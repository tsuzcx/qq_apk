package com.tencent.biz.pubaccount.weishi_new.net.common;

import NS_KING_PUBLIC.stReqHeader;
import QMF_PROTOCAL.RetryInfo;
import UserGrowth.stReportItem;
import UserGrowth.stWeishiReportReq;
import android.text.TextUtils;
import com.qq.taf.jce.JceStruct;
import com.tencent.biz.pubaccount.weishi_new.WSQQConnectAuthManager;
import com.tencent.biz.pubaccount.weishi_new.net.WSUniPacket;
import com.tencent.biz.pubaccount.weishi_new.net.WeishiHeaderConst;
import com.tencent.biz.pubaccount.weishi_new.report.UserActionReportPresenter;
import com.tencent.biz.pubaccount.weishi_new.util.WSDeviceUtils;
import com.tencent.biz.pubaccount.weishi_new.util.WSLog;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.msf.sdk.MsfSdkUtils;
import com.tencent.mobileqq.utils.WupUtil;
import cooperation.qzone.QUA;
import cooperation.qzone.WNSStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import mqq.app.AppRuntime;
import mqq.manager.TicketManager;
import org.jetbrains.annotations.NotNull;

public class WSRequestEncoder
{
  @NotNull
  private static <T extends JceStruct> stReqHeader a(WSRequest<T> paramWSRequest)
  {
    stReqHeader localstReqHeader = new stReqHeader();
    Object localObject1 = BaseApplicationImpl.getApplication().getRuntime();
    String str = ((AppRuntime)localObject1).getAccount();
    Object localObject2 = (TicketManager)((AppRuntime)localObject1).getManager(2);
    if ((localObject2 != null) && (!TextUtils.isEmpty(((AppRuntime)localObject1).getAccount())))
    {
      localObject1 = ((TicketManager)localObject2).getSkey(str);
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("[getHeader]session key:");
      ((StringBuilder)localObject2).append((String)localObject1);
      WSLog.d("[WSService][Encoder]", ((StringBuilder)localObject2).toString());
    }
    else
    {
      localObject1 = "test-key";
    }
    localstReqHeader.authInfo = WSQQConnectAuthManager.a().a(str, (String)localObject1, paramWSRequest.isShouldStartQQAuth());
    localstReqHeader.iChid = 0;
    localstReqHeader.person_id = WeishiHeaderConst.a;
    localstReqHeader.platform = "Android";
    localstReqHeader.appversion = WSDeviceUtils.a(BaseApplicationImpl.getContext());
    localstReqHeader.user_ip = WSDeviceUtils.a();
    localstReqHeader.strQua = QUA.getQUA3();
    localstReqHeader.device_info = WSDeviceUtils.b();
    localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("[getHeader]device_info:");
    ((StringBuilder)localObject2).append(localstReqHeader.device_info);
    WSLog.b("[WSService][Encoder]", ((StringBuilder)localObject2).toString());
    localstReqHeader.h265key = WSDeviceUtils.d();
    localstReqHeader.appid = 1101083114;
    a(paramWSRequest, localstReqHeader, str, (String)localObject1);
    localstReqHeader.iAppVersion = WSDeviceUtils.a();
    return localstReqHeader;
  }
  
  @NotNull
  private static <T extends JceStruct> Map<String, String> a(@NotNull WSRequest<T> paramWSRequest)
  {
    Object localObject1 = paramWSRequest.req;
    if (!(localObject1 instanceof stWeishiReportReq)) {
      return new HashMap();
    }
    localObject1 = ((stWeishiReportReq)localObject1).report_list;
    if (((ArrayList)localObject1).size() <= 0) {
      return new HashMap();
    }
    localObject1 = (stReportItem)((ArrayList)localObject1).get(0);
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("[getCacheMapExt]上报取 pageType: ");
    ((StringBuilder)localObject2).append(((stReportItem)localObject1).pagetype);
    WSLog.a("[WSService][Encoder]", ((StringBuilder)localObject2).toString());
    localObject2 = (Map)WSRequest.pageTypeExtMap.get(Integer.valueOf(((stReportItem)localObject1).pagetype));
    if ((localObject2 != null) && (((Map)localObject2).size() > 0))
    {
      Iterator localIterator = ((Map)localObject2).entrySet().iterator();
      while (localIterator.hasNext())
      {
        Map.Entry localEntry = (Map.Entry)localIterator.next();
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("getCacheMapExt取出来");
        localStringBuilder.append(paramWSRequest.getReqUniKey());
        localStringBuilder.append(" --- key: ");
        localStringBuilder.append((String)localEntry.getKey());
        localStringBuilder.append(", value: ");
        localStringBuilder.append((String)localEntry.getValue());
        WSLog.a("[WSService][Encoder]", localStringBuilder.toString());
        if (("qq_abtest".equals(localEntry.getKey())) && (((stReportItem)localObject1).optype == 121))
        {
          localEntry.setValue("");
          WSLog.c("[WSService][Encoder]", "初始化上报，qq_abtest 清空qq_abtest");
        }
      }
      return localObject2;
    }
    paramWSRequest = new StringBuilder();
    paramWSRequest.append("[getCacheMapExt]没有pageType为");
    paramWSRequest.append(((stReportItem)localObject1).pagetype);
    paramWSRequest.append("的extMap");
    WSLog.a("[WSService][Encoder]", paramWSRequest.toString());
    return new HashMap();
  }
  
  private static <T extends JceStruct> void a(@NotNull WSRequest<T> paramWSRequest, stReqHeader paramstReqHeader, String paramString1, String paramString2)
  {
    if ("stWeishiReportReq".equals(paramWSRequest.getReqUniKey())) {
      paramstReqHeader.mapExt = a(paramWSRequest);
    } else {
      paramstReqHeader.mapExt = new HashMap();
    }
    if (paramstReqHeader.mapExt != null)
    {
      paramstReqHeader.mapExt.put("iAuthType", "2");
      Map localMap = paramstReqHeader.mapExt;
      Object localObject = paramString1;
      if (paramString1 == null) {
        localObject = "";
      }
      localMap.put("sUid", localObject);
      localObject = paramstReqHeader.mapExt;
      paramString1 = paramString2;
      if (paramString2 == null) {
        paramString1 = "";
      }
      ((Map)localObject).put("sSessionKey", paramString1);
      paramString2 = UserActionReportPresenter.a(BaseApplicationImpl.getContext());
      paramString1 = paramString2;
      if (TextUtils.isEmpty(paramString2)) {
        paramString1 = "000000000000000";
      }
      paramstReqHeader.mapExt.put("imei", paramString1);
      paramString2 = UserActionReportPresenter.b(BaseApplicationImpl.getContext());
      localObject = paramstReqHeader.mapExt;
      paramString1 = paramString2;
      if (paramString2 == null) {
        paramString1 = "";
      }
      ((Map)localObject).put("qimei", paramString1);
      paramString2 = UserActionReportPresenter.c(BaseApplicationImpl.getContext());
      localObject = paramstReqHeader.mapExt;
      paramString1 = paramString2;
      if (paramString2 == null) {
        paramString1 = "";
      }
      ((Map)localObject).put("ssid", paramString1);
      paramString2 = WSDeviceUtils.a(UserActionReportPresenter.a(BaseApplicationImpl.getContext()));
      localObject = paramstReqHeader.mapExt;
      paramString1 = paramString2;
      if (paramString2 == null) {
        paramString1 = "";
      }
      ((Map)localObject).put("ssid_ip", paramString1);
      paramstReqHeader.mapExt.put("ab_policy_info", paramWSRequest.getExpABTestDataStr());
      paramstReqHeader.mapExt.put("teen_mode", String.valueOf(WSNetUtil.a()));
      paramString1 = new StringBuilder();
      paramString1.append("[getHeader]mCmd:");
      paramString1.append(paramWSRequest.getRequestCmd());
      paramString1.append(", mReqScene:");
      paramString1.append(paramWSRequest.getRequestScene());
      paramString1.append(", header:");
      paramString1.append(paramstReqHeader.mapExt.toString());
      WSLog.e("[WSService][Encoder]", paramString1.toString());
      return;
    }
    WSLog.a("[WSService][Encoder]", "[getHeader]header mapExt is null.");
  }
  
  public static <T extends JceStruct> byte[] a(WSRequest<T> paramWSRequest)
  {
    Object localObject1 = WSDeviceUtils.e();
    Object localObject2 = QUA.getQUA3();
    long l = paramWSRequest.getLoginUserId();
    RetryInfo localRetryInfo = (RetryInfo)paramWSRequest.getRetryInfo();
    localObject1 = new WNSStream(1000027, (String)localObject2, l, new byte[0], (String)localObject1, localRetryInfo);
    localObject2 = b(paramWSRequest);
    if (localObject2 != null) {
      return WupUtil.a(((WNSStream)localObject1).pack(MsfSdkUtils.getNextAppSeq(), paramWSRequest.getCmdString(), (byte[])localObject2, paramWSRequest.isNeedCompress()));
    }
    return null;
  }
  
  private static <T extends JceStruct> byte[] b(WSRequest<T> paramWSRequest)
  {
    Object localObject = a(paramWSRequest);
    WSUniPacket localWSUniPacket = new WSUniPacket();
    localWSUniPacket.b(paramWSRequest.requestId);
    paramWSRequest.requestId += 1;
    localWSUniPacket.a("king");
    localWSUniPacket.b(paramWSRequest.getOnlyCmd());
    localWSUniPacket.setEncodeName("UTF-8");
    localWSUniPacket.put("stReqHeader", localObject);
    localWSUniPacket.a(9999);
    if ((paramWSRequest.req != null) && (!TextUtils.isEmpty(paramWSRequest.getRequestCmd())))
    {
      localWSUniPacket.put(paramWSRequest.getReqUniKey(), paramWSRequest.req);
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("[getEncodedUniParameter]req名 :");
      ((StringBuilder)localObject).append(paramWSRequest.getReqUniKey());
      WSLog.a("[WSService][Encoder]", ((StringBuilder)localObject).toString());
    }
    return localWSUniPacket.encode();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.net.common.WSRequestEncoder
 * JD-Core Version:    0.7.0.1
 */