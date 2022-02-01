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
  public static final int a;
  
  static
  {
    jdField_a_of_type_Int = BannerTypeCollections.D;
  }
  
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
    paramBanner = new AdvancedTipsBar(this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity);
    paramBanner.b(true);
    paramBanner.setVisibility(8);
    return paramBanner;
  }
  
  public void a()
  {
    BannerManager.a().a(CommonConstants.jdField_a_of_type_Int, 0);
  }
  
  public void a(Banner paramBanner, Message paramMessage)
  {
    if ((paramMessage != null) && (paramMessage.obj != null))
    {
      paramBanner = (TipsBar)paramBanner.a;
      paramBanner.setVisibility(0);
      paramMessage = (AutoStatusItem)paramMessage.obj;
      paramBanner.setCloseListener(new AutoStatusBannerProcessor.1(this, paramMessage));
      Object localObject;
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("[status][banner] banner mgr show banner ");
        ((StringBuilder)localObject).append(paramMessage.b);
        QLog.d("Q.recent.banner", 2, ((StringBuilder)localObject).toString());
      }
      if (!TextUtils.isEmpty(paramMessage.c))
      {
        localObject = this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity.getAppRuntime().getApp().getResources().getDrawable(2130847659);
        paramBanner.setTipsIcon(URLDrawable.getDrawable(paramMessage.c, (Drawable)localObject, (Drawable)localObject));
      }
      paramBanner.setTipsText(String.format(this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity.getString(2131690255), new Object[] { paramMessage.b }));
      paramBanner.setButtonText(this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity.getString(2131690254));
      paramBanner.b(true);
      paramBanner.setOnClickListener(new AutoStatusBannerProcessor.2(this, paramMessage));
      paramBanner.setOriginalOnClickListener(new AutoStatusBannerProcessor.3(this, paramMessage));
      ReportHelperKt.a("0X800AF9E", (int)paramMessage.a);
    }
  }
  
  public int b()
  {
    return jdField_a_of_type_Int;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.activity.recent.bannerprocessor.AutoStatusBannerProcessor
 * JD-Core Version:    0.7.0.1
 */