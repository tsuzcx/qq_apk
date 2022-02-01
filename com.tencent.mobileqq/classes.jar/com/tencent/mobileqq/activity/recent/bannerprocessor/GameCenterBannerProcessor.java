package com.tencent.mobileqq.activity.recent.bannerprocessor;

import android.content.res.Resources;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.view.View;
import com.tencent.gamecenter.wadl.api.IQQGameNoticeService;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.banner.Banner;
import com.tencent.mobileqq.banner.BannerManager;
import com.tencent.mobileqq.banner.BannerTypeCollections;
import com.tencent.mobileqq.banner.TipsBar;
import com.tencent.mobileqq.banner.processor.BaseBannerProcessor;
import com.tencent.mobileqq.banner.processor.IBannerLifecycle;
import com.tencent.mobileqq.qroute.annotation.KeepClassConstructor;
import com.tencent.mobileqq.utils.CustomHandler;
import com.tencent.qphone.base.util.QLog;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.os.MqqHandler;

@KeepClassConstructor
public class GameCenterBannerProcessor
  extends BaseBannerProcessor
  implements Handler.Callback, IBannerLifecycle
{
  public static final int a;
  
  static
  {
    jdField_a_of_type_Int = BannerTypeCollections.H;
  }
  
  public GameCenterBannerProcessor(QBaseActivity paramQBaseActivity)
  {
    super(paramQBaseActivity);
    this.jdField_a_of_type_MqqOsMqqHandler = new CustomHandler(Looper.getMainLooper(), this);
  }
  
  public int a()
  {
    return 2;
  }
  
  public View a(Banner paramBanner)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.recent.banner", 2, "initGameNoticeBar");
    }
    paramBanner = new TipsBar(this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity);
    paramBanner.setTipsIcon(this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity.getResources().getDrawable(2130838310));
    paramBanner.setVisibility(8);
    paramBanner.b(true);
    return paramBanner;
  }
  
  public void a()
  {
    BannerManager.a().a(jdField_a_of_type_Int, 0);
  }
  
  public void a(Banner paramBanner, Message paramMessage)
  {
    IQQGameNoticeService localIQQGameNoticeService = (IQQGameNoticeService)MobileQQ.sMobileQQ.waitAppRuntime(null).getRuntimeService(IQQGameNoticeService.class, "");
    if (localIQQGameNoticeService != null) {
      localIQQGameNoticeService.updateGameCenterBar(paramBanner.a, paramMessage);
    }
  }
  
  public void a(AppRuntime paramAppRuntime)
  {
    this.jdField_a_of_type_MqqOsMqqHandler.removeCallbacksAndMessages(null);
  }
  
  public int b()
  {
    return jdField_a_of_type_Int;
  }
  
  public void b()
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.recent.banner", 2, "onDelayRefreshGameNotice");
    }
    this.jdField_a_of_type_MqqOsMqqHandler.sendEmptyMessageDelayed(3000, 3000L);
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    if (paramMessage.what == 3000)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.recent.banner", 2, "onDelayRefreshGameNotice");
      }
      paramMessage = (IQQGameNoticeService)MobileQQ.sMobileQQ.waitAppRuntime(null).getRuntimeService(IQQGameNoticeService.class, "");
      if (paramMessage != null) {
        paramMessage.checkBannerFromResume();
      }
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.activity.recent.bannerprocessor.GameCenterBannerProcessor
 * JD-Core Version:    0.7.0.1
 */