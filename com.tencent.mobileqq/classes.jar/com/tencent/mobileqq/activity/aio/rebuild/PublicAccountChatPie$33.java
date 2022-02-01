package com.tencent.mobileqq.activity.aio.rebuild;

import com.tencent.biz.officialaccount.OfficialAccountReporter;
import com.tencent.biz.officialaccount.OfficialAccountReporter.Reporter;
import com.tencent.biz.pubaccount.api.IPublicAccountManager;
import com.tencent.biz.ui.CustomMenuBar;
import com.tencent.biz.ui.CustomMenuBar.OnMenuItemClickListener;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.applets.PublicAccountEventReport;
import com.tencent.mobileqq.mp.mobileqq_mp.ButtonInfo;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.weather.api.IWeatherCommApi;

class PublicAccountChatPie$33
  implements CustomMenuBar.OnMenuItemClickListener
{
  PublicAccountChatPie$33(PublicAccountChatPie paramPublicAccountChatPie) {}
  
  public void a(String paramString, int paramInt1, int paramInt2)
  {
    if ((((IWeatherCommApi)QRoute.api(IWeatherCommApi.class)).isWeatherPA(this.a.ah.b)) && (paramInt1 == 0))
    {
      this.a.bj.b();
    }
    else
    {
      com.tencent.mobileqq.activity.aio.AIOUtils.q = true;
      this.a.bi.handleButtonEvent(paramString, this.a.f, this.a.d, this.a.ae(), paramInt1, PublicAccountChatPie.t(this.a), PublicAccountChatPie.u(this.a), paramInt2, this.a.ah);
      PublicAccountEventReport.a(this.a.d, this.a.ah.b, PublicAccountChatPie.v(this.a), paramInt1);
    }
    paramString = this.a.bi.getButtonInfoByMenuId(this.a.d, this.a.ae(), paramInt1);
    if (paramString != null) {
      OfficialAccountReporter.a.b(this.a.ae(), paramString.id.get(), paramString.name.get());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.rebuild.PublicAccountChatPie.33
 * JD-Core Version:    0.7.0.1
 */