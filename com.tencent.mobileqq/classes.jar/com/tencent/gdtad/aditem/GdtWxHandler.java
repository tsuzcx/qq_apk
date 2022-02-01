package com.tencent.gdtad.aditem;

import android.os.Handler;
import com.tencent.ad.tangram.protocol.link_report.LinkReport.ReportBiz;
import com.tencent.ad.tangram.statistics.AdReporterForLinkEvent;
import com.tencent.ad.tangram.util.AdClickUtil.Result;
import com.tencent.mm.opensdk.modelbiz.WXLaunchMiniProgram.Req;
import com.tencent.mm.opensdk.openapi.IWXAPI;
import com.tencent.mm.opensdk.openapi.WXAPIFactory;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;
import tencent.gdt.qq_ad_get.QQAdGetRsp.AdInfo;
import tencent.gdt.qq_ad_get.QQAdGetRsp.AdInfo.WeChatAppInfo;

public class GdtWxHandler
{
  public static AdClickUtil.Result a(Handler paramHandler, GdtAd paramGdtAd)
  {
    qq_ad_get.QQAdGetRsp.AdInfo localAdInfo = paramGdtAd.info;
    link_report.LinkReport.ReportBiz localReportBiz = new link_report.LinkReport.ReportBiz();
    localReportBiz.wx_sdk_method = 3;
    localReportBiz.preload_status_code = 0;
    paramGdtAd = BaseApplication.getContext();
    Object localObject1 = null;
    AdReporterForLinkEvent.reportAsync(paramGdtAd, 4006001, null, localReportBiz, null);
    Object localObject2 = "wxf0a80d0ac2e82aa7";
    paramGdtAd = (GdtAd)localObject2;
    try
    {
      if (localAdInfo.wechat_app_info.app_id.has())
      {
        paramGdtAd = (GdtAd)localObject2;
        if (localAdInfo.wechat_app_info.app_id.get().length() > 0) {
          paramGdtAd = localAdInfo.wechat_app_info.app_id.get();
        }
      }
      localObject2 = WXAPIFactory.createWXAPI(BaseApplication.getContext(), paramGdtAd);
      if (!((IWXAPI)localObject2).isWXAppInstalled())
      {
        a(paramHandler, 2131889981);
        AdReporterForLinkEvent.reportAsync(BaseApplication.getContext(), 4006007, null, localReportBiz, null);
        paramHandler = (Handler)localObject1;
        break label477;
      }
      if (((IWXAPI)localObject2).getWXAppSupportAPI() < 621086464)
      {
        a(paramHandler, 2131889982);
        AdReporterForLinkEvent.reportAsync(BaseApplication.getContext(), 4006007, null, localReportBiz, null);
        paramHandler = (Handler)localObject1;
        break label477;
      }
      AdReporterForLinkEvent.reportAsync(BaseApplication.getContext(), 4006006, null, localReportBiz, null);
      paramHandler = new WXLaunchMiniProgram.Req();
      paramHandler.userName = localAdInfo.wechat_app_info.app_username.get();
      paramHandler.path = localAdInfo.wechat_app_info.app_path.get();
      try
      {
        localObject1 = new JSONObject();
        ((JSONObject)localObject1).put("pathType", 2);
        JSONObject localJSONObject = new JSONObject();
        localJSONObject.put("ad_trace_data", localAdInfo.wechat_app_info.ad_trace_data.get());
        localJSONObject.put("token", localAdInfo.wechat_app_info.app_token.get());
        ((JSONObject)localObject1).put("invokeData", localJSONObject);
        paramHandler.extData = ((JSONObject)localObject1).toString();
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("navigateToMiniProgram openMiniGame, make extData json success: name = ");
        ((StringBuilder)localObject1).append(paramHandler.userName);
        ((StringBuilder)localObject1).append(",path=");
        ((StringBuilder)localObject1).append(paramHandler.path);
        ((StringBuilder)localObject1).append(",extData=");
        ((StringBuilder)localObject1).append(paramHandler.extData);
        ((StringBuilder)localObject1).append(",appId=");
        ((StringBuilder)localObject1).append(a(paramGdtAd));
        QLog.i("GdtWechatHandler", 1, ((StringBuilder)localObject1).toString());
      }
      catch (Exception paramGdtAd)
      {
        QLog.e("GdtWechatHandler", 1, "navigateToMiniProgram  openMiniGame, make extData json failed!", paramGdtAd);
      }
      paramHandler.miniprogramType = 0;
      boolean bool = ((IWXAPI)localObject2).sendReq(paramHandler);
      paramHandler = BaseApplication.getContext();
      if (!bool) {
        break label519;
      }
      i = 4006008;
    }
    catch (Exception paramHandler)
    {
      for (;;)
      {
        continue;
        int i = 4006009;
      }
    }
    AdReporterForLinkEvent.reportAsync(paramHandler, i, null, localReportBiz, null);
    paramHandler = new AdClickUtil.Result(0, 9);
    break label477;
    paramHandler = new AdClickUtil.Result(4, 9);
    label477:
    ReportController.b(null, "dc00898", "", "", "0X800AA79", "0X800AA79", 0, 0, "", "", String.valueOf(localAdInfo.wechat_app_info.pos_id.get()), "");
    return paramHandler;
  }
  
  public static String a(String paramString)
  {
    if ("wxf0a80d0ac2e82aa7".equals(paramString)) {
      return "same";
    }
    String str = paramString;
    if (paramString != null)
    {
      if (paramString.length() <= 4) {
        return paramString;
      }
      str = paramString.substring(4);
    }
    return str;
  }
  
  public static void a(Handler paramHandler, int paramInt)
  {
    paramHandler.post(new GdtWxHandler.1(paramInt));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.gdtad.aditem.GdtWxHandler
 * JD-Core Version:    0.7.0.1
 */