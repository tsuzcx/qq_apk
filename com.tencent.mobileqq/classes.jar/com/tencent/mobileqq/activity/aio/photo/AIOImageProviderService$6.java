package com.tencent.mobileqq.activity.aio.photo;

import com.tencent.biz.webviewplugin.NewReportPlugin;
import com.tencent.mobileqq.app.BaseActivity;

class AIOImageProviderService$6
  implements Runnable
{
  AIOImageProviderService$6(AIOImageProviderService paramAIOImageProviderService, boolean paramBoolean, BaseActivity paramBaseActivity, String paramString1, String paramString2, String paramString3, String paramString4, int paramInt) {}
  
  public void run()
  {
    if (this.a)
    {
      NewReportPlugin.a(this.b.app, this.c, this.d, this.e, this.f);
      return;
    }
    NewReportPlugin.a(this.b, this.d, this.c, this.e, NewReportPlugin.b(this.g), this.e);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.photo.AIOImageProviderService.6
 * JD-Core Version:    0.7.0.1
 */