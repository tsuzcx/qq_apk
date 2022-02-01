package com.tencent.mobileqq.activity.recent.bannerprocessor;

import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Message;
import android.text.TextUtils;
import android.view.View;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.banner.Banner;
import com.tencent.mobileqq.banner.BannerManager;
import com.tencent.mobileqq.banner.BannerTypeCollections;
import com.tencent.mobileqq.banner.TipsBar;
import com.tencent.mobileqq.banner.processor.BaseBannerProcessor;
import com.tencent.mobileqq.onlinestatus.ReportHelperKt;
import com.tencent.mobileqq.onlinestatus.config.AutoStatusItem;
import com.tencent.mobileqq.onlinestatus.constants.CommonConstants;
import com.tencent.mobileqq.qroute.annotation.KeepClassConstructor;
import com.tencent.mobileqq.widget.AdvancedTipsBar;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import mqq.app.AppRuntime;

@KeepClassConstructor
public class AutoStatusBannerProcessor
  extends BaseBannerProcessor
{
  public static final int a = BannerTypeCollections.E;
  
  public AutoStatusBannerProcessor(QBaseActivity paramQBaseActivity)
  {
    super(paramQBaseActivity);
  }
  
  public int a()
  {
    return 2;
  }
  
  public View a(Banner paramBanner)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.recent.banner", 2, "[status][banner] initAutoStatusBanner");
    }
    paramBanner = new AdvancedTipsBar(this.f);
    paramBanner.b(true);
    paramBanner.setVisibility(8);
    return paramBanner;
  }
  
  public void a(Banner paramBanner, Message paramMessage)
  {
    if ((paramMessage != null) && (paramMessage.obj != null))
    {
      paramBanner = (TipsBar)paramBanner.c;
      paramBanner.setVisibility(0);
      paramMessage = (AutoStatusItem)paramMessage.obj;
      paramBanner.setCloseListener(new AutoStatusBannerProcessor.1(this, paramMessage));
      Object localObject;
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("[status][banner] banner mgr show banner ");
        ((StringBuilder)localObject).append(paramMessage.c);
        QLog.d("Q.recent.banner", 2, ((StringBuilder)localObject).toString());
      }
      if (!TextUtils.isEmpty(paramMessage.d))
      {
        localObject = this.f.getAppRuntime().getApp().getResources().getDrawable(2130849319);
        paramBanner.setTipsIcon(URLDrawable.getDrawable(paramMessage.d, (Drawable)localObject, (Drawable)localObject));
      }
      paramBanner.setTipsText(String.format(this.f.getString(2131887166), new Object[] { paramMessage.c }));
      paramBanner.setButtonText(this.f.getString(2131887165));
      paramBanner.b(true);
      paramBanner.setOnClickListener(new AutoStatusBannerProcessor.2(this, paramMessage));
      paramBanner.setOriginalOnClickListener(new AutoStatusBannerProcessor.3(this, paramMessage));
      ReportHelperKt.a("0X800AF9E", (int)paramMessage.b);
    }
  }
  
  public int b()
  {
    return a;
  }
  
  public void c()
  {
    BannerManager.a().a(CommonConstants.a, 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.recent.bannerprocessor.AutoStatusBannerProcessor
 * JD-Core Version:    0.7.0.1
 */