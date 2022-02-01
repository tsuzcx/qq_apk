package com.tencent.mobileqq.ark.api.notify;

import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.guild.api.IQQGuildClientAuthApi;
import com.tencent.mobileqq.guild.client.GuildClientParams;
import com.tencent.mobileqq.qroute.QRoute;

class GuildClientAuthNotify$1
  implements Runnable
{
  GuildClientAuthNotify$1(GuildClientAuthNotify paramGuildClientAuthNotify, String paramString1, String paramString2, String paramString3, String paramString4, QBaseActivity paramQBaseActivity) {}
  
  public void run()
  {
    GuildClientParams localGuildClientParams = new GuildClientParams().d(this.a).g(this.b).h(this.c).i(this.d).a(4).e();
    ((IQQGuildClientAuthApi)QRoute.api(IQQGuildClientAuthApi.class)).clientAuthorizationForArk(this.e, localGuildClientParams);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ark.api.notify.GuildClientAuthNotify.1
 * JD-Core Version:    0.7.0.1
 */