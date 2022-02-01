package com.tencent.mobileqq.activity.recent.bannerprocessor;

import android.content.res.Resources;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.view.View;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.banner.Banner;
import com.tencent.mobileqq.banner.BannerManager;
import com.tencent.mobileqq.banner.TipsBar;
import com.tencent.mobileqq.banner.processor.BaseBannerProcessor;
import com.tencent.mobileqq.banner.processor.IBannerLifecycle;
import com.tencent.mobileqq.qroute.annotation.KeepClassConstructor;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.CustomHandler;
import com.tencent.qphone.base.util.QLog;
import mqq.app.AppRuntime;
import mqq.os.MqqHandler;

@KeepClassConstructor
public class ReaderBannerProcessor
  extends BaseBannerProcessor
  implements Handler.Callback, IBannerLifecycle
{
  public ReaderBannerProcessor(QBaseActivity paramQBaseActivity)
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
      QLog.d("ReaderBar", 2, "initReaderBar");
    }
    paramBanner = new TipsBar(this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity);
    paramBanner.b(true);
    paramBanner.setTipsIcon(this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity.getResources().getDrawable(2130838471));
    return paramBanner;
  }
  
  public void a()
  {
    BannerManager.a().a(32, 0);
  }
  
  public void a(Banner paramBanner, Message paramMessage)
  {
    if ((paramMessage == null) || (paramMessage.what != 3000)) {
      if (QLog.isColorLevel()) {
        QLog.d("ReaderBar", 2, "updateReaderBar msg " + paramMessage);
      }
    }
    do
    {
      do
      {
        return;
        if (QLog.isColorLevel()) {
          QLog.d("ReaderBar", 2, "updateReaderBar msg.obj = " + paramMessage.obj);
        }
      } while (!(paramMessage.obj instanceof String));
      paramMessage = ((String)paramMessage.obj).split("@#");
    } while (paramMessage.length != 3);
    String str1 = paramMessage[0];
    String str2 = paramMessage[2];
    long l = Long.parseLong(paramMessage[1]);
    ((TipsBar)paramBanner.a).setTipsText(HardCodeUtil.a(2131701004) + str1 + "》");
    paramBanner.a.setOnClickListener(new ReaderBannerProcessor.1(this, l, str2));
    ((TipsBar)paramBanner.a).setCloseListener(new ReaderBannerProcessor.2(this));
    paramBanner.a.setVisibility(0);
    this.jdField_a_of_type_MqqOsMqqHandler.removeMessages(3001);
    this.jdField_a_of_type_MqqOsMqqHandler.sendEmptyMessageDelayed(3001, 900000L);
    ReportController.a(this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity.getAppRuntime(), "dc00898", "", "", "0X8009EDF", "0X8009EDF", 1, 0, "", "", "", "");
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
      if (this.jdField_a_of_type_MqqOsMqqHandler.hasMessages(3001)) {
        this.jdField_a_of_type_MqqOsMqqHandler.removeMessages(3001);
      }
      BannerManager.a().a(32, 2, paramMessage);
    }
    for (;;)
    {
      return true;
      if (paramMessage.what == 3001) {
        BannerManager.a().a(32, 0, paramMessage);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.recent.bannerprocessor.ReaderBannerProcessor
 * JD-Core Version:    0.7.0.1
 */