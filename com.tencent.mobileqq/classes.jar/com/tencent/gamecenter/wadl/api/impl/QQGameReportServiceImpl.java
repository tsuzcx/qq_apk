package com.tencent.gamecenter.wadl.api.impl;

import android.os.Build;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.gamecenter.wadl.api.IQQGameNetService;
import com.tencent.gamecenter.wadl.api.IQQGameReportService;
import com.tencent.gamecenter.wadl.api.IQQGameTrpcService;
import com.tencent.gamecenter.wadl.biz.WadlBusinessServlet;
import com.tencent.gamecenter.wadl.biz.entity.MonitReport.MonitReportReq;
import com.tencent.gamecenter.wadl.biz.entity.MonitReport.PublicAccountReq;
import com.tencent.gamecenter.wadl.biz.entity.WadlParams;
import com.tencent.gamecenter.wadl.biz.entity.WadlReportBuilder;
import com.tencent.gamecenter.wadl.biz.entity.WadlReportInfo;
import com.tencent.gamecenter.wadl.biz.entity.WebSSOAgent.UniSsoServerReq;
import com.tencent.gamecenter.wadl.biz.entity.WebSSOAgent.UniSsoServerReqComm;
import com.tencent.gamecenter.wadl.biz.ipc.WadlQIPCConnector;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.qipc.QIPCClientHelper;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.DeviceInfoUtil;
import com.tencent.qphone.base.util.QLog;
import eipc.EIPCClient;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.app.NewIntent;
import org.json.JSONObject;

public class QQGameReportServiceImpl
  implements IQQGameReportService
{
  private static final String TAG = "Wadl_QQGameReportServiceImpl";
  private static String mCarrier;
  
  public void report(JSONObject paramJSONObject, int paramInt)
  {
    Object localObject = MobileQQ.sMobileQQ.waitAppRuntime(null);
    if (localObject != null)
    {
      if (paramInt == 0)
      {
        reportDC((AppRuntime)localObject, paramJSONObject.toString());
        return;
      }
      if (paramInt == 1) {
        ((IQQGameTrpcService)QRoute.api(IQQGameTrpcService.class)).reportAtta(paramJSONObject);
      }
      return;
    }
    WadlQIPCConnector.a().a();
    localObject = new Bundle();
    ((Bundle)localObject).putString("reportData", paramJSONObject.toString());
    QIPCClientHelper.getInstance().getClient().callServer("WadlQIPCModule", "action.report", (Bundle)localObject);
  }
  
  public void reportDC(WadlReportBuilder paramWadlReportBuilder)
  {
    if (paramWadlReportBuilder == null) {
      return;
    }
    if ("08a00036462".equals(paramWadlReportBuilder.jdField_a_of_type_JavaLangString)) {
      paramWadlReportBuilder.b = 1;
    }
    report(paramWadlReportBuilder.a(paramWadlReportBuilder.b), paramWadlReportBuilder.b);
  }
  
  public void reportDC(String paramString1, String paramString2, WadlReportInfo paramWadlReportInfo, String paramString3)
  {
    if (paramWadlReportInfo != null) {}
    for (;;)
    {
      try
      {
        if (TextUtils.isEmpty(paramString3)) {
          return;
        }
        WadlParams localWadlParams = paramWadlReportInfo.jdField_a_of_type_ComTencentGamecenterWadlBizEntityWadlParams;
        if (TextUtils.isEmpty(mCarrier)) {
          mCarrier = String.valueOf(DeviceInfoUtil.g());
        }
        WadlReportBuilder localWadlReportBuilder = new WadlReportBuilder();
        paramString1 = localWadlReportBuilder.a(paramString3).c(paramString1).h("558").j(String.valueOf(paramWadlReportInfo.jdField_a_of_type_Long)).a(paramWadlReportInfo.jdField_a_of_type_Int).a(1, "55801");
        i = 3;
        paramString1.a(3, "1").a(4, paramString2).a(11, "4").a(12, "430").a(14, Build.MODEL).a(15, Build.VERSION.RELEASE).a(16, mCarrier).a(31, paramWadlReportInfo.jdField_b_of_type_JavaLangString).a(32, paramWadlReportInfo.d).a(36, paramWadlReportInfo.a()).a(37, WadlReportInfo.jdField_a_of_type_JavaLangString).a(42, paramWadlReportInfo.f).a(43, paramWadlReportInfo.g).a(45, paramWadlReportInfo.e).a(48, paramWadlReportInfo.jdField_c_of_type_JavaLangString).a(49, String.valueOf(paramWadlReportInfo.jdField_b_of_type_Long)).a(50, paramWadlReportInfo.h);
        if (localWadlParams != null)
        {
          if (localWadlParams.jdField_a_of_type_Boolean)
          {
            if (localWadlParams.g == 1)
            {
              i = 2;
            }
            else
            {
              if (localWadlParams.g != 4) {
                break label512;
              }
              i = 5;
            }
          }
          else {
            if (localWadlParams.d != 3) {
              break label518;
            }
          }
          localWadlReportBuilder.b(localWadlParams.jdField_a_of_type_JavaLangString);
          paramWadlReportInfo = localWadlReportBuilder.a(2, String.valueOf(localWadlParams.d)).a(5, String.valueOf(i));
          boolean bool = localWadlParams.b(1);
          paramString2 = "0";
          if (bool) {
            paramString1 = "1";
          } else {
            paramString1 = "0";
          }
          paramWadlReportInfo = paramWadlReportInfo.a(10, paramString1).a(18, localWadlParams.l).a(33, localWadlParams.f).a(34, localWadlParams.e).a(35, localWadlParams.jdField_c_of_type_JavaLangString).a(38, String.valueOf(localWadlParams.jdField_c_of_type_Int)).a(39, localWadlParams.n).a(40, localWadlParams.o);
          if (!localWadlParams.a(512)) {
            break label524;
          }
          paramString1 = "1";
          paramWadlReportInfo = paramWadlReportInfo.a(41, paramString1);
          paramString1 = paramString2;
          if (localWadlParams.a(256)) {
            paramString1 = "1";
          }
          paramWadlReportInfo.a(44, paramString1).a(46, String.valueOf(localWadlParams.i)).a(47, localWadlParams.m);
        }
        localWadlReportBuilder.a();
        return;
      }
      catch (Exception paramString1)
      {
        paramString1.printStackTrace();
      }
      return;
      label512:
      int i = 4;
      continue;
      label518:
      i = 1;
      continue;
      label524:
      paramString1 = "0";
    }
  }
  
  public void reportDC(AppRuntime paramAppRuntime, String paramString)
  {
    if (paramAppRuntime == null)
    {
      QLog.w("Wadl_QQGameReportServiceImpl", 1, "reportDC fail,,appRuntime is null");
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("reportDC appRuntime=");
    localStringBuilder.append(paramAppRuntime);
    localStringBuilder.append(",reportData=");
    localStringBuilder.append(paramString);
    QLog.d("Wadl_QQGameReportServiceImpl", 1, localStringBuilder.toString());
    if (!TextUtils.isEmpty(paramString)) {
      try
      {
        paramAppRuntime = new JSONObject(paramString);
        if (!paramAppRuntime.has("report_list")) {
          return;
        }
        int i = paramAppRuntime.optInt("target", 0);
        paramAppRuntime.remove("target");
        if (i == 0)
        {
          paramString = new JSONObject();
          paramString.put("req", paramAppRuntime);
          ((IQQGameNetService)QRoute.api(IQQGameNetService.class)).requestWebSso("12934", paramString, null);
          return;
        }
        if (i == 1)
        {
          ((IQQGameTrpcService)QRoute.api(IQQGameTrpcService.class)).reportAtta(paramAppRuntime);
          return;
        }
      }
      catch (Throwable paramAppRuntime)
      {
        paramAppRuntime.printStackTrace();
      }
    }
  }
  
  public void reportGamePubAccountMsgStatus(int paramInt, String paramString1, String paramString2)
  {
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("reportGamePubAccountMsgList status:");
    ((StringBuilder)localObject1).append(paramInt);
    ((StringBuilder)localObject1).append(",msg:");
    ((StringBuilder)localObject1).append(paramString1);
    ((StringBuilder)localObject1).append(",url:");
    ((StringBuilder)localObject1).append(paramString2);
    QLog.d("Wadl_QQGameReportServiceImpl", 1, ((StringBuilder)localObject1).toString());
    Object localObject2 = new WebSSOAgent.UniSsoServerReqComm();
    ((WebSSOAgent.UniSsoServerReqComm)localObject2).platform.set(109L);
    ((WebSSOAgent.UniSsoServerReqComm)localObject2).osver.set(Build.VERSION.RELEASE);
    ((WebSSOAgent.UniSsoServerReqComm)localObject2).mqqver.set("8.7.0");
    localObject1 = new WebSSOAgent.UniSsoServerReq();
    ((WebSSOAgent.UniSsoServerReq)localObject1).comm.set((MessageMicro)localObject2);
    localObject2 = new MonitReport.MonitReportReq();
    ((MonitReport.MonitReportReq)localObject2).type.set(1);
    MonitReport.PublicAccountReq localPublicAccountReq = new MonitReport.PublicAccountReq();
    localPublicAccountReq.action.set(paramInt);
    if (TextUtils.isEmpty(paramString1)) {
      paramString1 = Long.valueOf(0L);
    } else {
      paramString1 = Long.valueOf(Long.parseLong(paramString1));
    }
    localPublicAccountReq.msgid.set(paramString1.longValue());
    localPublicAccountReq.url.set(paramString2);
    localPublicAccountReq.ts.set(NetConnInfoCenter.getServerTimeMillis());
    ((MonitReport.MonitReportReq)localObject2).public_acct_req.add(localPublicAccountReq);
    ((WebSSOAgent.UniSsoServerReq)localObject1).pbReqData.set(ByteStringMicro.copyFrom(((MonitReport.MonitReportReq)localObject2).toByteArray()));
    paramString1 = new NewIntent(MobileQQ.sMobileQQ, WadlBusinessServlet.class);
    paramString1.putExtra("cmd", "gc_monitor_report.report_public_acct_info");
    paramString1.putExtra("data", ((WebSSOAgent.UniSsoServerReq)localObject1).toByteArray());
    paramString2 = MobileQQ.sMobileQQ.waitAppRuntime(null);
    if (paramString2 == null) {
      return;
    }
    paramString2.startServlet(paramString1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.gamecenter.wadl.api.impl.QQGameReportServiceImpl
 * JD-Core Version:    0.7.0.1
 */