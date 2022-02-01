package com.tencent.gdtad.aditem;

import android.os.Handler;
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
    Object localObject1 = "wxf0a80d0ac2e82aa7";
    paramGdtAd = (GdtAd)localObject1;
    try
    {
      if (localAdInfo.wechat_app_info.app_id.has())
      {
        paramGdtAd = (GdtAd)localObject1;
        if (localAdInfo.wechat_app_info.app_id.get().length() > 0) {
          paramGdtAd = localAdInfo.wechat_app_info.app_id.get();
        }
      }
      localObject1 = WXAPIFactory.createWXAPI(BaseApplication.getContext(), paramGdtAd);
      if (!((IWXAPI)localObject1).isWXAppInstalled())
      {
        a(paramHandler, 2131692870);
        break label400;
      }
      if (((IWXAPI)localObject1).getWXAppSupportAPI() < 621086464)
      {
        a(paramHandler, 2131692871);
        break label400;
      }
      paramHandler = new WXLaunchMiniProgram.Req();
      paramHandler.userName = localAdInfo.wechat_app_info.app_username.get();
      paramHandler.path = localAdInfo.wechat_app_info.app_path.get();
      try
      {
        Object localObject2 = new JSONObject();
        ((JSONObject)localObject2).put("pathType", 2);
        JSONObject localJSONObject = new JSONObject();
        localJSONObject.put("ad_trace_data", localAdInfo.wechat_app_info.ad_trace_data.get());
        localJSONObject.put("token", localAdInfo.wechat_app_info.app_token.get());
        ((JSONObject)localObject2).put("invokeData", localJSONObject);
        paramHandler.extData = ((JSONObject)localObject2).toString();
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("navigateToMiniProgram openMiniGame, make extData json success: name = ");
        ((StringBuilder)localObject2).append(paramHandler.userName);
        ((StringBuilder)localObject2).append(",path=");
        ((StringBuilder)localObject2).append(paramHandler.path);
        ((StringBuilder)localObject2).append(",extData=");
        ((StringBuilder)localObject2).append(paramHandler.extData);
        ((StringBuilder)localObject2).append(",appId=");
        ((StringBuilder)localObject2).append(a(paramGdtAd));
        QLog.i("GdtWechatHandler", 1, ((StringBuilder)localObject2).toString());
      }
      catch (Exception paramGdtAd)
      {
        QLog.e("GdtWechatHandler", 1, "navigateToMiniProgram  openMiniGame, make extData json failed!", paramGdtAd);
      }
      paramHandler.miniprogramType = 0;
      ((IWXAPI)localObject1).sendReq(paramHandler);
      paramHandler = new AdClickUtil.Result(0, 9);
    }
    catch (Exception paramHandler)
    {
      for (;;)
      {
        continue;
        paramHandler = null;
      }
    }
    paramHandler = new AdClickUtil.Result(4, 9);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.gdtad.aditem.GdtWxHandler
 * JD-Core Version:    0.7.0.1
 */