package com.tencent.mobileqq.activity.recent.bannerprocessor;

import android.content.res.Resources;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.view.View;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.banner.Banner;
import com.tencent.mobileqq.banner.BannerManager;
import com.tencent.mobileqq.banner.TipsBar;
import com.tencent.mobileqq.banner.processor.BaseBannerProcessor;
import com.tencent.mobileqq.banner.processor.IBannerLifecycle;
import com.tencent.mobileqq.gamecenter.data.GameNoticeCenter;
import com.tencent.mobileqq.qroute.annotation.KeepClassConstructor;
import com.tencent.mobileqq.utils.CustomHandler;
import com.tencent.qphone.base.util.QLog;
import mqq.app.AppRuntime;
import mqq.os.MqqHandler;

@KeepClassConstructor
public class GameCenterBannerProcessor
  extends BaseBannerProcessor
  implements Handler.Callback, IBannerLifecycle
{
  public GameNoticeCenter a;
  
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
    paramBanner.setTipsIcon(this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity.getResources().getDrawable(2130838463));
    paramBanner.setVisibility(8);
    paramBanner.b(true);
    return paramBanner;
  }
  
  public void a()
  {
    BannerManager.a().a(35, 0);
    if (this.jdField_a_of_type_ComTencentMobileqqGamecenterDataGameNoticeCenter != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqGamecenterDataGameNoticeCenter.onDestroy();
      this.jdField_a_of_type_ComTencentMobileqqGamecenterDataGameNoticeCenter = null;
    }
  }
  
  public void a(Banner paramBanner, Message paramMessage)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqGamecenterDataGameNoticeCenter != null) {
      this.jdField_a_of_type_ComTencentMobileqqGamecenterDataGameNoticeCenter.updateGameCenterBar(paramBanner.a, paramMessage);
    }
  }
  
  public void b() {}
  
  public void b(AppRuntime paramAppRuntime)
  {
    this.jdField_a_of_type_MqqOsMqqHandler.removeCallbacksAndMessages(null);
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    if (paramMessage.what == 3000)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.recent.banner", 2, "onDelayRefreshGameNotice");
      }
      if (this.jdField_a_of_type_ComTencentMobileqqGamecenterDataGameNoticeCenter == null) {
        this.jdField_a_of_type_ComTencentMobileqqGamecenterDataGameNoticeCenter = new GameNoticeCenter((AppInterface)this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity.getAppRuntime());
      }
      this.jdField_a_of_type_ComTencentMobileqqGamecenterDataGameNoticeCenter.checkBannerFromResume();
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.recent.bannerprocessor.GameCenterBannerProcessor
 * JD-Core Version:    0.7.0.1
 */