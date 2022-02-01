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
    Object localObject = BaseApplicationImpl.getApplication().getRuntime();
    String str = ((AppRuntime)localObject).getAccount();
    TicketManager localTicketManager = (TicketManager)((AppRuntime)localObject).getManager(2);
    if ((localTicketManager != null) && (!TextUtils.isEmpty(((AppRuntime)localObject).getAccount())))
    {
      localObject = localTicketManager.getSkey(str);
      WSLog.d("[WSService][Encoder]", "[getHeader]session key:" + (String)localObject);
    }
    for (;;)
    {
      localstReqHeader.authInfo = WSQQConnectAuthManager.a().a(str, (String)localObject, paramWSRequest.isShouldStartQQAuth());
      localstReqHeader.iChid = 0;
      localstReqHeader.person_id = WeishiHeaderConst.a;
      localstReqHeader.platform = "Android";
      localstReqHeader.appversion = WSDeviceUtils.a(BaseApplicationImpl.getContext());
      localstReqHeader.user_ip = WSDeviceUtils.a();
      localstReqHeader.strQua = QUA.getQUA3();
      localstReqHeader.device_info = WSDeviceUtils.b();
      WSLog.b("[WSService][Encoder]", "[getHeader]device_info:" + localstReqHeader.device_info);
      localstReqHeader.h265key = WSDeviceUtils.d();
      localstReqHeader.appid = 1101083114;
      a(paramWSRequest, localstReqHeader, str, (String)localObject);
      localstReqHeader.iAppVersion = WSDeviceUtils.a();
      return localstReqHeader;
      localObject = "test-key";
    }
  }
  
  @NotNull
  private static <T extends JceStruct> Map<String, String> a(@NotNull WSRequest<T> paramWSRequest)
  {
    Object localObject = paramWSRequest.req;
    if (!(localObject instanceof stWeishiReportReq))
    {
      localObject = new HashMap();
      return localObject;
    }
    localObject = ((stWeishiReportReq)localObject).report_list;
    if (((ArrayList)localObject).size() <= 0) {
      return new HashMap();
    }
    stReportItem localstReportItem = (stReportItem)((ArrayList)localObject).get(0);
    WSLog.a("[WSService][Encoder]", "[getCacheMapExt]上报取 pageType: " + localstReportItem.pagetype);
    Map localMap = (Map)WSRequest.pageTypeExtMap.get(Integer.valueOf(localstReportItem.pagetype));
    if ((localMap == null) || (localMap.size() <= 0))
    {
      WSLog.a("[WSService][Encoder]", "[getCacheMapExt]没有pageType为" + localstReportItem.pagetype + "的extMap");
      return new HashMap();
    }
    Iterator localIterator = localMap.entrySet().iterator();
    for (;;)
    {
      localObject = localMap;
      if (!localIterator.hasNext()) {
        break;
      }
      localObject = (Map.Entry)localIterator.next();
      WSLog.a("[WSService][Encoder]", "getCacheMapExt取出来" + paramWSRequest.getReqUniKey() + " --- key: " + (String)((Map.Entry)localObject).getKey() + ", value: " + (String)((Map.Entry)localObject).getValue());
      if (("qq_abtest".equals(((Map.Entry)localObject).getKey())) && (localstReportItem.optype == 121))
      {
        ((Map.Entry)localObject).setValue("");
        WSLog.c("[WSService][Encoder]", "初始化上报，qq_abtest 清空qq_abtest");
      }
    }
  }
  
  private static <T extends JceStruct> void a(@NotNull WSRequest<T> paramWSRequest, stReqHeader paramstReqHeader, String paramString1, String paramString2)
  {
    if ("stWeishiReportReq".equals(paramWSRequest.getReqUniKey())) {}
    for (paramstReqHeader.mapExt = a(paramWSRequest); paramstReqHeader.mapExt != null; paramstReqHeader.mapExt = new HashMap())
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
      WSLog.e("[WSService][Encoder]", "[getHeader]mCmd:" + paramWSRequest.getRequestCmd() + ", mReqScene:" + paramWSRequest.getRequestScene() + ", header:" + paramstReqHeader.mapExt.toString());
      return;
    }
    WSLog.a("[WSService][Encoder]", "[getHeader]header mapExt is null.");
  }
  
  public static <T extends JceStruct> byte[] a(WSRequest<T> paramWSRequest)
  {
    Object localObject1 = WSDeviceUtils.e();
    Object localObject2 = QUA.getQUA3();
    long l = paramWSRequest.getLoginUserId();
    Object localObject3 = (RetryInfo)paramWSRequest.getRetryInfo();
    localObject2 = new WNSStream(1000027, (String)localObject2, l, new byte[0], (String)localObject1, (RetryInfo)localObject3);
    localObject3 = b(paramWSRequest);
    localObject1 = null;
    if (localObject3 != null) {
      localObject1 = WupUtil.a(((WNSStream)localObject2).pack(MsfSdkUtils.getNextAppSeq(), paramWSRequest.getCmdString(), (byte[])localObject3, paramWSRequest.isNeedCompress()));
    }
    return localObject1;
  }
  
  private static <T extends JceStruct> byte[] b(WSRequest<T> paramWSRequest)
  {
    stReqHeader localstReqHeader = a(paramWSRequest);
    WSUniPacket localWSUniPacket = new WSUniPacket();
    localWSUniPacket.b(paramWSRequest.requestId);
    paramWSRequest.requestId += 1;
    localWSUniPacket.a("king");
    localWSUniPacket.b(paramWSRequest.getOnlyCmd());
    localWSUniPacket.setEncodeName("UTF-8");
    localWSUniPacket.put("stReqHeader", localstReqHeader);
    localWSUniPacket.a(9999);
    if ((paramWSRequest.req != null) && (!TextUtils.isEmpty(paramWSRequest.getRequestCmd())))
    {
      localWSUniPacket.put(paramWSRequest.getReqUniKey(), paramWSRequest.req);
      WSLog.a("[WSService][Encoder]", "[getEncodedUniParameter]req名 :" + paramWSRequest.getReqUniKey());
    }
    return localWSUniPacket.encode();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.net.common.WSRequestEncoder
 * JD-Core Version:    0.7.0.1
 */