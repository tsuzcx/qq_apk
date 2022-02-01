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
  private static final String TAG = "QQGameReportServiceImpl";
  private static String mCarrier;
  
  public void report(JSONObject paramJSONObject, int paramInt)
  {
    Object localObject = MobileQQ.sMobileQQ.waitAppRuntime(null);
    if (QLog.isColorLevel()) {
      QLog.d("QQGameReportServiceImpl", 1, "report appRuntime=" + localObject + ",reportJson=" + paramJSONObject);
    }
    if (localObject != null)
    {
      if (paramInt == 0) {
        reportDC((AppRuntime)localObject, paramJSONObject.toString());
      }
      while (paramInt != 1) {
        return;
      }
      ((IQQGameTrpcService)QRoute.api(IQQGameTrpcService.class)).reportAtta(paramJSONObject);
      return;
    }
    WadlQIPCConnector.a().a();
    localObject = new Bundle();
    ((Bundle)localObject).putString("reportData", paramJSONObject.toString());
    QIPCClientHelper.getInstance().getClient().callServer("WadlQIPCModule", "action.report", (Bundle)localObject);
  }
  
  public void reportDC(WadlReportBuilder paramWadlReportBuilder)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QQGameReportServiceImpl", 1, "reportDC reportBuilder=" + paramWadlReportBuilder);
    }
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
      WadlParams localWadlParams;
      try
      {
        if (TextUtils.isEmpty(paramString3)) {
          return;
        }
        localWadlParams = paramWadlReportInfo.jdField_a_of_type_ComTencentGamecenterWadlBizEntityWadlParams;
        if (TextUtils.isEmpty(mCarrier)) {
          mCarrier = String.valueOf(DeviceInfoUtil.f());
        }
        WadlReportBuilder localWadlReportBuilder = new WadlReportBuilder();
        localWadlReportBuilder.a(paramString3).c(paramString1).g("558").i(String.valueOf(paramWadlReportInfo.jdField_a_of_type_Long)).a(paramWadlReportInfo.jdField_a_of_type_Int).a(1, "55801").a(3, "1").a(4, paramString2).a(11, "4").a(12, "430").a(14, Build.MODEL).a(15, Build.VERSION.RELEASE).a(16, mCarrier).a(31, paramWadlReportInfo.jdField_b_of_type_JavaLangString).a(32, paramWadlReportInfo.d).a(36, paramWadlReportInfo.a()).a(37, WadlReportInfo.jdField_a_of_type_JavaLangString).a(42, paramWadlReportInfo.g).a(43, paramWadlReportInfo.h).a(45, paramWadlReportInfo.f).a(48, paramWadlReportInfo.jdField_c_of_type_JavaLangString).a(49, String.valueOf(paramWadlReportInfo.jdField_b_of_type_Long)).a(50, paramWadlReportInfo.i);
        if (localWadlParams != null)
        {
          if (!localWadlParams.jdField_a_of_type_Boolean) {
            break label474;
          }
          if (localWadlParams.g == 1)
          {
            i = 2;
            localWadlReportBuilder.b(localWadlParams.jdField_a_of_type_JavaLangString);
            paramString2 = localWadlReportBuilder.a(2, String.valueOf(localWadlParams.d)).a(5, String.valueOf(i));
            if (!localWadlParams.b(1)) {
              break label509;
            }
            paramString1 = "1";
            paramString2 = paramString2.a(10, paramString1).a(18, localWadlParams.l).a(33, localWadlParams.f).a(34, localWadlParams.e).a(35, localWadlParams.jdField_c_of_type_JavaLangString).a(38, String.valueOf(localWadlParams.jdField_c_of_type_Int)).a(39, localWadlParams.n).a(40, localWadlParams.o);
            if (!localWadlParams.a(512)) {
              break label516;
            }
            paramString1 = "1";
            paramString2 = paramString2.a(41, paramString1);
            if (!localWadlParams.a(256)) {
              break label489;
            }
            paramString1 = "1";
            paramString2.a(44, paramString1).a(46, String.valueOf(localWadlParams.i)).a(47, localWadlParams.m);
          }
        }
        else
        {
          localWadlReportBuilder.a();
          return;
        }
      }
      catch (Exception paramString1)
      {
        paramString1.printStackTrace();
        return;
      }
      if (localWadlParams.g == 4)
      {
        i = 5;
        continue;
        label474:
        if (localWadlParams.d == 3)
        {
          i = 3;
          continue;
          label489:
          paramString1 = "0";
          continue;
        }
      }
      else
      {
        i = 4;
        continue;
      }
      int i = 1;
      continue;
      label509:
      paramString1 = "0";
      continue;
      label516:
      paramString1 = "0";
    }
  }
  
  public void reportDC(AppRuntime paramAppRuntime, String paramString)
  {
    if (paramAppRuntime == null) {
      if (QLog.isColorLevel()) {
        QLog.w("QQGameReportServiceImpl", 2, "reportDC fail,,appRuntime is null");
      }
    }
    int i;
    do
    {
      for (;;)
      {
        return;
        if (QLog.isColorLevel()) {
          QLog.d("QQGameReportServiceImpl", 2, "reportDC appRuntime=" + paramAppRuntime + ",reportData=" + paramString);
        }
        if (!TextUtils.isEmpty(paramString)) {
          try
          {
            paramAppRuntime = new JSONObject(paramString);
            if (paramAppRuntime.has("report_list"))
            {
              i = paramAppRuntime.optInt("target", 0);
              paramAppRuntime.remove("target");
              if (i == 0)
              {
                paramString = new JSONObject();
                paramString.put("req", paramAppRuntime);
                ((IQQGameNetService)QRoute.api(IQQGameNetService.class)).requestWebSso("12934", paramString, null);
                return;
              }
            }
          }
          catch (Throwable paramAppRuntime)
          {
            paramAppRuntime.printStackTrace();
            return;
          }
        }
      }
    } while (i != 1);
    ((IQQGameTrpcService)QRoute.api(IQQGameTrpcService.class)).reportAtta(paramAppRuntime);
  }
  
  public void reportGamePubAccountMsgStatus(int paramInt, String paramString1, String paramString2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QQGameReportServiceImpl", 2, "[reportGamePubAccountMsgList] status:" + paramInt + ",msg:" + paramString1 + ",url:" + paramString2);
    }
    Object localObject = new WebSSOAgent.UniSsoServerReqComm();
    ((WebSSOAgent.UniSsoServerReqComm)localObject).platform.set(109L);
    ((WebSSOAgent.UniSsoServerReqComm)localObject).osver.set(Build.VERSION.RELEASE);
    ((WebSSOAgent.UniSsoServerReqComm)localObject).mqqver.set("8.5.5");
    WebSSOAgent.UniSsoServerReq localUniSsoServerReq = new WebSSOAgent.UniSsoServerReq();
    localUniSsoServerReq.comm.set((MessageMicro)localObject);
    localObject = new MonitReport.MonitReportReq();
    ((MonitReport.MonitReportReq)localObject).type.set(1);
    MonitReport.PublicAccountReq localPublicAccountReq = new MonitReport.PublicAccountReq();
    localPublicAccountReq.action.set(paramInt);
    if (TextUtils.isEmpty(paramString1)) {}
    for (paramString1 = Long.valueOf(0L);; paramString1 = Long.valueOf(Long.parseLong(paramString1)))
    {
      localPublicAccountReq.msgid.set(paramString1.longValue());
      localPublicAccountReq.url.set(paramString2);
      localPublicAccountReq.ts.set(NetConnInfoCenter.getServerTimeMillis());
      ((MonitReport.MonitReportReq)localObject).public_acct_req.add(localPublicAccountReq);
      localUniSsoServerReq.pbReqData.set(ByteStringMicro.copyFrom(((MonitReport.MonitReportReq)localObject).toByteArray()));
      paramString1 = new NewIntent(MobileQQ.sMobileQQ, WadlBusinessServlet.class);
      paramString1.putExtra("cmd", "gc_monitor_report.report_public_acct_info");
      paramString1.putExtra("data", localUniSsoServerReq.toByteArray());
      paramString2 = MobileQQ.sMobileQQ.waitAppRuntime(null);
      if (paramString2 != null) {
        break;
      }
      return;
    }
    paramString2.startServlet(paramString1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.gamecenter.wadl.api.impl.QQGameReportServiceImpl
 * JD-Core Version:    0.7.0.1
 */