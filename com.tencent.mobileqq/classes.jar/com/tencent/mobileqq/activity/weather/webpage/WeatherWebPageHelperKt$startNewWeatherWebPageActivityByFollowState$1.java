package com.tencent.mobileqq.activity.weather.webpage;

import android.content.Context;
import android.os.Bundle;
import com.tencent.mobileqq.app.PublicAccountHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.route.ActivityURIRequest;
import com.tencent.mobileqq.qroute.route.URIRequest;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "isFollow", "", "invoke"}, k=3, mv={1, 1, 16})
final class WeatherWebPageHelperKt$startNewWeatherWebPageActivityByFollowState$1
  extends Lambda
  implements Function1<Integer, Unit>
{
  WeatherWebPageHelperKt$startNewWeatherWebPageActivityByFollowState$1(Context paramContext, QQAppInterface paramQQAppInterface, int paramInt, String paramString)
  {
    super(1);
  }
  
  public final void invoke(int paramInt)
  {
    if (paramInt == 1)
    {
      WeatherWebPageHelperKt.b(this.$context, this.$app, this.$from, this.$url);
      return;
    }
    ActivityURIRequest localActivityURIRequest = new ActivityURIRequest(this.$context, "/pubaccount/detail");
    localActivityURIRequest.extra().putString("uin", "2658655094");
    localActivityURIRequest.extra().putString("uinname", "QQ天气");
    localActivityURIRequest.extra().putInt("uintype", 1008);
    localActivityURIRequest.extra().putString("weather_share_url", this.$url);
    localActivityURIRequest.extra().putInt("weather_outside_follow_state", paramInt);
    localActivityURIRequest.setFlags(67108864);
    QRoute.startUri((URIRequest)localActivityURIRequest, null);
    PublicAccountHandler.a(null, "2658655094", "Pb_account_lifeservice", "mp_msg_sys_2", "detail");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.weather.webpage.WeatherWebPageHelperKt.startNewWeatherWebPageActivityByFollowState.1
 * JD-Core Version:    0.7.0.1
 */