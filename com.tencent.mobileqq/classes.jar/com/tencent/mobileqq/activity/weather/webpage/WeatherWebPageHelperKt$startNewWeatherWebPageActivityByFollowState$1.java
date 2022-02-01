package com.tencent.mobileqq.activity.weather.webpage;

import amfb;
import android.content.Context;
import android.content.Intent;
import com.tencent.biz.pubaccount.AccountDetailActivity;
import com.tencent.mobileqq.app.PublicAccountHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "isFollow", "", "invoke"}, k=3, mv={1, 1, 16})
public final class WeatherWebPageHelperKt$startNewWeatherWebPageActivityByFollowState$1
  extends Lambda
  implements Function1<Integer, Unit>
{
  public WeatherWebPageHelperKt$startNewWeatherWebPageActivityByFollowState$1(Context paramContext, QQAppInterface paramQQAppInterface, int paramInt, String paramString)
  {
    super(1);
  }
  
  public final void invoke(int paramInt)
  {
    if (paramInt == 1)
    {
      amfb.b(this.$context, this.$app, this.$from, this.$url);
      return;
    }
    Intent localIntent = new Intent(this.$context, AccountDetailActivity.class);
    localIntent.putExtra("uin", "2658655094");
    localIntent.putExtra("uinname", "QQ天气");
    localIntent.putExtra("uintype", 1008);
    localIntent.putExtra("weather_share_url", this.$url);
    localIntent.putExtra("weather_outside_follow_state", paramInt);
    localIntent.addFlags(67108864);
    this.$context.startActivity(localIntent);
    PublicAccountHandler.a(null, "2658655094", "Pb_account_lifeservice", "mp_msg_sys_2", "detail");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.weather.webpage.WeatherWebPageHelperKt.startNewWeatherWebPageActivityByFollowState.1
 * JD-Core Version:    0.7.0.1
 */