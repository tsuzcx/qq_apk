package com.tencent.mobileqq.activity.recent.bannerprocessor;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.qrcode.activity.QRLoginMgrActivity;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class LoginDevicesBannerProcessor$1
  implements View.OnClickListener
{
  LoginDevicesBannerProcessor$1(LoginDevicesBannerProcessor paramLoginDevicesBannerProcessor) {}
  
  public void onClick(View paramView)
  {
    if ((LoginDevicesBannerProcessor.a(this.a) != null) && ("1600000104".equals(LoginDevicesBannerProcessor.a(this.a).trim())))
    {
      this.a.b();
    }
    else
    {
      Intent localIntent = new Intent(LoginDevicesBannerProcessor.a(this.a), QRLoginMgrActivity.class);
      localIntent.putExtra("qrlogin_position", LoginDevicesBannerProcessor.b(this.a));
      localIntent.putExtra("qrlogin_appid", LoginDevicesBannerProcessor.a(this.a));
      LoginDevicesBannerProcessor.b(this.a).startActivity(localIntent);
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.activity.recent.bannerprocessor.LoginDevicesBannerProcessor.1
 * JD-Core Version:    0.7.0.1
 */