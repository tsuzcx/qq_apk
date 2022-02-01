package com.tencent.gamecenter.wadl.api.impl;

import android.os.Build;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.gamecenter.wadl.api.IQQGameConfigService;
import com.tencent.gamecenter.wadl.api.IQQGameNetService;
import com.tencent.gamecenter.wadl.api.IQQGameReportService;
import com.tencent.gamecenter.wadl.api.IQQGameTrpcService;
import com.tencent.gamecenter.wadl.biz.WadlBusinessServlet;
import com.tencent.gamecenter.wadl.biz.entity.MonitReport.MonitReportReq;
import com.tencent.gamecenter.wadl.biz.entity.MonitReport.PublicAccountReq;
import com.tencent.gamecenter.wadl.biz.entity.WadlCommConfig;
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
import com.tencent.mobileqq.qqgamepub.utils.GamePubAccountHelper;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.DeviceInfoUtil;
import com.tencent.qphone.base.util.QLog;
import eipc.EIPCClient;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.app.NewIntent;
import org.json.JSONObject;

public class QQGameReportServiceImpl
  implements IQQGameReportService
{
  private static final String ATTA_ID = "0ac00055074";
  public static final String ATTA_KEY_ERROR_MSG = "error_msg";
  public static final String ATTA_KEY_ERROR_TYPE = "error_type";
  public static final String ATTA_KEY_FPS = "fps";
  public static final String ATTA_KEY_STACK = "stack";
  public static final String ATTA_REPORT_URL = "https://h.trace.qq.com/kv";
  private static final String ATTA_TOKEN = "6377279485";
  public static final String DNFLUTTER_DYNAMIC_PAGE_NAME = "qflutter_qqgame_dnflutter";
  public static final int FLUTTER_DYNAMIC_TYPE_DNFLUTTER = 1;
  public static final int FLUTTER_DYNAMIC_TYPE_NONE = 0;
  public static final String PLATFORM_TYPE_ANDROID = "1";
  public static final String QQGAME_PAGE_NAME = "qflutter_qqgame";
  private static final String TAG = "Wadl_QQGameReportServiceImpl";
  private static String mCarrier;
  
  private StringBuilder getAttaReportBody(String paramString1, String paramString2)
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.provideAs(TypeTransformer.java:780)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.enexpr(TypeTransformer.java:659)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:719)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.enexpr(TypeTransformer.java:698)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:719)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.s1stmt(TypeTransformer.java:810)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.sxStmt(TypeTransformer.java:840)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:206)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
  
  private void reportToAttaFormMap(String paramString1, String paramString2, Map<String, String> paramMap)
  {
    paramString1 = getAttaReportBody(paramString1, paramString2);
    paramString2 = paramMap.keySet().iterator();
    while (paramString2.hasNext())
    {
      String str = (String)paramString2.next();
      if ((String)paramMap.get(str) != null)
      {
        paramString1.append("&");
        paramString1.append(str);
        paramString1.append("=");
        paramString1.append(URLEncoder.encode((String)paramMap.get(str)));
      }
    }
    GamePubAccountHelper.b("https://h.trace.qq.com/kv", paramString1.toString());
  }
  
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
    WadlQIPCConnector.a().b();
    localObject = new Bundle();
    ((Bundle)localObject).putString("reportData", paramJSONObject.toString());
    QIPCClientHelper.getInstance().getClient().callServer("WadlQIPCModule", "action.report", (Bundle)localObject);
  }
  
  public void reportDC(WadlReportBuilder paramWadlReportBuilder)
  {
    if (paramWadlReportBuilder == null) {
      return;
    }
    if ("08a00036462".equals(paramWadlReportBuilder.c)) {
      paramWadlReportBuilder.b = 1;
    }
    report(paramWadlReportBuilder.b(paramWadlReportBuilder.b), paramWadlReportBuilder.b);
  }
  
  public void reportDC(String paramString1, String paramString2, WadlReportInfo paramWadlReportInfo, String paramString3)
  {
    String str = "1";
    if (paramWadlReportInfo != null) {}
    for (;;)
    {
      try
      {
        if (TextUtils.isEmpty(paramString3)) {
          return;
        }
        WadlParams localWadlParams = paramWadlReportInfo.b;
        if (TextUtils.isEmpty(mCarrier)) {
          mCarrier = String.valueOf(DeviceInfoUtil.X());
        }
        WadlReportBuilder localWadlReportBuilder = new WadlReportBuilder();
        paramString1 = localWadlReportBuilder.a(paramString3).c(paramString1).h("558").j(String.valueOf(paramWadlReportInfo.j)).a(paramWadlReportInfo.d).a(1, "55801");
        i = 3;
        paramString1.a(3, "1").a(4, paramString2).a(11, "4").a(12, "430").a(14, Build.MODEL).a(15, Build.VERSION.RELEASE).a(16, mCarrier).a(31, paramWadlReportInfo.c).a(32, paramWadlReportInfo.f).a(36, paramWadlReportInfo.b()).a(37, WadlReportInfo.a).a(42, paramWadlReportInfo.h).a(43, paramWadlReportInfo.i).a(45, paramWadlReportInfo.g).a(48, paramWadlReportInfo.e).a(49, String.valueOf(paramWadlReportInfo.l)).a(50, paramWadlReportInfo.k);
        if (localWadlParams != null)
        {
          if (localWadlParams.b)
          {
            if (localWadlParams.t == 1)
            {
              i = 2;
            }
            else
            {
              if (localWadlParams.t != 4) {
                break label555;
              }
              i = 5;
            }
          }
          else {
            if (localWadlParams.h != 3) {
              break label561;
            }
          }
          boolean bool = localWadlParams.a(256);
          if (bool)
          {
            paramString1 = "1";
          }
          else
          {
            if (!localWadlParams.a(1024)) {
              break label567;
            }
            paramString1 = "2";
          }
          localWadlReportBuilder.b(localWadlParams.e);
          paramWadlReportInfo = localWadlReportBuilder.a(2, String.valueOf(localWadlParams.h)).a(5, String.valueOf(i));
          if (!localWadlParams.f(1)) {
            break label574;
          }
          paramString2 = "1";
          paramWadlReportInfo = paramWadlReportInfo.a(10, paramString2).a(18, localWadlParams.w);
          if (!localWadlParams.a(2048)) {
            break label581;
          }
          paramString2 = "1";
          paramWadlReportInfo = paramWadlReportInfo.a(19, paramString2).a(33, localWadlParams.m).a(34, localWadlParams.k).a(35, localWadlParams.i).a(38, String.valueOf(localWadlParams.d)).a(39, localWadlParams.y).a(40, localWadlParams.z);
          if (!localWadlParams.a(512)) {
            break label588;
          }
          paramString2 = str;
          paramWadlReportInfo.a(41, paramString2).a(44, paramString1).a(46, String.valueOf(localWadlParams.D)).a(47, localWadlParams.x);
        }
        localWadlReportBuilder.a();
        return;
      }
      catch (Exception paramString1)
      {
        paramString1.printStackTrace();
      }
      return;
      label555:
      int i = 4;
      continue;
      label561:
      i = 1;
      continue;
      label567:
      paramString1 = "0";
      continue;
      label574:
      paramString2 = "0";
      continue;
      label581:
      paramString2 = "0";
      continue;
      label588:
      paramString2 = "0";
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
        paramString = new JSONObject(paramString);
        if (!paramString.has("report_list")) {
          return;
        }
        int i = paramString.optInt("target", 0);
        paramString.remove("target");
        if (i == 0)
        {
          paramAppRuntime = new JSONObject();
          paramAppRuntime.put("req", paramString);
          paramString = (WadlCommConfig)((IQQGameConfigService)QRoute.api(IQQGameConfigService.class)).getConfig("comminfo");
          if ((paramString != null) && (paramString.g == 1))
          {
            ((IQQGameTrpcService)QRoute.api(IQQGameTrpcService.class)).reportToDcByTrpc(paramAppRuntime);
            return;
          }
          ((IQQGameNetService)QRoute.api(IQQGameNetService.class)).requestWebSso("12934", paramAppRuntime, null);
          return;
        }
        if (i == 1)
        {
          ((IQQGameTrpcService)QRoute.api(IQQGameTrpcService.class)).reportAtta(paramString);
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
    ((WebSSOAgent.UniSsoServerReqComm)localObject2).mqqver.set("8.8.17");
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
    ((MonitReport.MonitReportReq)localObject2).publicAcctReq.add(localPublicAccountReq);
    ((WebSSOAgent.UniSsoServerReq)localObject1).pbReqData.set(ByteStringMicro.copyFrom(((MonitReport.MonitReportReq)localObject2).toByteArray()));
    paramString1 = new NewIntent(MobileQQ.sMobileQQ, WadlBusinessServlet.class);
    paramString1.putExtra("extra_cmd", "gc_monitor_report.report_public_acct_info");
    paramString1.putExtra("webssoReq", ((WebSSOAgent.UniSsoServerReq)localObject1).toByteArray());
    paramString1.putExtra("wadl_sso_type", 2);
    paramString2 = MobileQQ.sMobileQQ.waitAppRuntime(null);
    if (paramString2 == null) {
      return;
    }
    paramString2.startServlet(paramString1);
  }
  
  public void reportToAtta(String paramString1, String paramString2, String paramString3)
  {
    try
    {
      paramString1 = getAttaReportBody(paramString1, paramString2);
      if (!TextUtils.isEmpty(paramString3))
      {
        paramString2 = new JSONObject(paramString3);
        paramString3 = paramString2.keys();
        while (paramString3.hasNext())
        {
          String str1 = (String)paramString3.next();
          String str2 = paramString2.optString(str1);
          if (!TextUtils.isEmpty(str2))
          {
            paramString1.append("&");
            paramString1.append(str1);
            paramString1.append("=");
            paramString1.append(URLEncoder.encode(str2));
          }
        }
        GamePubAccountHelper.b("https://h.trace.qq.com/kv", paramString1.toString());
        return;
      }
    }
    catch (Throwable paramString1)
    {
      paramString1.printStackTrace();
    }
  }
  
  public void reportToAttaForException(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("reportToAttaForFps pageName=");
      ((StringBuilder)localObject).append(paramString1);
      ((StringBuilder)localObject).append(" errorType=");
      ((StringBuilder)localObject).append(paramString2);
      ((StringBuilder)localObject).append(" errorMsg=");
      ((StringBuilder)localObject).append(paramString3);
      QLog.d("Wadl_QQGameReportServiceImpl", 1, ((StringBuilder)localObject).toString());
    }
    Object localObject = new HashMap();
    ((Map)localObject).put("error_type", paramString2);
    ((Map)localObject).put("error_msg", paramString3);
    ((Map)localObject).put("stack", paramString4);
    reportToAttaFormMap(paramString1, "exception", (Map)localObject);
  }
  
  public void reportToAttaForFps(String paramString, int paramInt)
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("reportToAttaForFps pageName=");
      ((StringBuilder)localObject).append(paramString);
      ((StringBuilder)localObject).append(" fps=");
      ((StringBuilder)localObject).append(paramInt);
      QLog.d("Wadl_QQGameReportServiceImpl", 1, ((StringBuilder)localObject).toString());
    }
    Object localObject = new HashMap();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramInt);
    localStringBuilder.append("");
    ((Map)localObject).put("fps", localStringBuilder.toString());
    reportToAttaFormMap(paramString, "scrollPerfomance", (Map)localObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.gamecenter.wadl.api.impl.QQGameReportServiceImpl
 * JD-Core Version:    0.7.0.1
 */