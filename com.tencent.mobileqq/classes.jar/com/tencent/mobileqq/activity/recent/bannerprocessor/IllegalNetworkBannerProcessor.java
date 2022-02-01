package com.tencent.mobileqq.activity.recent.bannerprocessor;

import android.content.res.Resources;
import android.os.Message;
import android.view.View;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.banner.Banner;
import com.tencent.mobileqq.banner.BannerManager;
import com.tencent.mobileqq.banner.BannerTypeCollections;
import com.tencent.mobileqq.banner.TipsBar;
import com.tencent.mobileqq.banner.processor.BaseBannerProcessor;
import com.tencent.mobileqq.banner.processor.IBannerLifecycle;
import com.tencent.mobileqq.managers.LoadingStateManager;
import com.tencent.mobileqq.qroute.annotation.KeepClassConstructor;
import mqq.app.AppRuntime;

@KeepClassConstructor
public class IllegalNetworkBannerProcessor
  extends BaseBannerProcessor
  implements IBannerLifecycle
{
  public static final int a;
  
  static
  {
    jdField_a_of_type_Int = BannerTypeCollections.l;
  }
  
  public IllegalNetworkBannerProcessor(QBaseActivity paramQBaseActivity)
  {
    super(paramQBaseActivity);
  }
  
  public int a()
  {
    return 4;
  }
  
  public View a(Banner paramBanner)
  {
    paramBanner = new TipsBar(this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity);
    paramBanner.setTipsText(this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity.getString(2131694427));
    paramBanner.setTipsIcon(this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity.getResources().getDrawable(2130838218));
    paramBanner.setOnClickListener(new IllegalNetworkBannerProcessor.1(this));
    paramBanner.setVisibility(8);
    return paramBanner;
  }
  
  public void a(Banner paramBanner, Message paramMessage)
  {
    paramBanner.a.setVisibility(0);
    ((TipsBar)paramBanner.a).setTipsText(this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity.getString(2131691080));
  }
  
  public void a(AppRuntime paramAppRuntime) {}
  
  public int b()
  {
    return jdField_a_of_type_Int;
  }
  
  public void b()
  {
    boolean bool = LoadingStateManager.a().d();
    BannerManager localBannerManager = BannerManager.a();
    int j = jdField_a_of_type_Int;
    int i;
    if (bool) {
      i = 2;
    } else {
      i = 0;
    }
    localBannerManager.a(j, i);
    LoadingStateManager.a().b(bool);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.activity.recent.bannerprocessor.IllegalNetworkBannerProcessor
 * JD-Core Version:    0.7.0.1
 */