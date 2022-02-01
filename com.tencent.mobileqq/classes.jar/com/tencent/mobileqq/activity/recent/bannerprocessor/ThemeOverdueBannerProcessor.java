package com.tencent.mobileqq.activity.recent.bannerprocessor;

import android.content.res.Resources;
import android.os.Bundle;
import android.os.Message;
import android.view.View;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.banner.Banner;
import com.tencent.mobileqq.banner.TipsBar;
import com.tencent.mobileqq.banner.processor.BaseBannerProcessor;
import com.tencent.mobileqq.qroute.annotation.KeepClassConstructor;
import com.tencent.mobileqq.statistics.ReportController;

@KeepClassConstructor
public class ThemeOverdueBannerProcessor
  extends BaseBannerProcessor
{
  public ThemeOverdueBannerProcessor(QBaseActivity paramQBaseActivity)
  {
    super(paramQBaseActivity);
  }
  
  public int a()
  {
    return 2;
  }
  
  public View a(Banner paramBanner)
  {
    paramBanner = new TipsBar(this.a);
    paramBanner.setTipsIcon(this.a.getResources().getDrawable(2130851038));
    paramBanner.setVisibility(8);
    return paramBanner;
  }
  
  public void a(Banner paramBanner, Message paramMessage)
  {
    if (this.a != null)
    {
      localObject = this.a.getAppRuntime();
      if (localObject != null) {
        break label28;
      }
    }
    label28:
    while ((paramMessage == null) || (paramMessage.obj == null))
    {
      return;
      localObject = null;
      break;
    }
    paramMessage = (Bundle)paramMessage.obj;
    paramBanner = (TipsBar)paramBanner.a;
    paramBanner.setVisibility(0);
    paramBanner.setTipsText(paramMessage.getString("expireMsg"));
    int i = paramMessage.getInt("expireType", 4);
    Object localObject = paramMessage.getString("themeId");
    int j = paramMessage.getInt("authResult");
    int k = paramMessage.getInt("sSimpleOpen");
    ReportController.b(null, "CliOper", "", "", "theme", "0X8007232", 0, 0, String.valueOf(i), "", "", "");
    ReportController.a(this.a.getAppRuntime(), "dc00898", "", "", "0X8009EDE", "0X8009EDE", 15, 0, "", "", "", "");
    paramBanner.setOnClickListener(new ThemeOverdueBannerProcessor.1(this, k, j, (String)localObject, i));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.recent.bannerprocessor.ThemeOverdueBannerProcessor
 * JD-Core Version:    0.7.0.1
 */