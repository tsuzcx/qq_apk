package com.tencent.mobileqq.activity.recent.bannerprocessor;

import android.content.res.Resources;
import android.os.Message;
import android.view.View;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.banner.Banner;
import com.tencent.mobileqq.banner.BannerManager;
import com.tencent.mobileqq.banner.TipsBar;
import com.tencent.mobileqq.banner.processor.BaseBannerProcessor;
import com.tencent.mobileqq.qroute.annotation.KeepClassConstructor;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qphone.base.util.QLog;
import mqq.app.AppRuntime;

@KeepClassConstructor
public class ApolloGameBannerProcessor
  extends BaseBannerProcessor
{
  public ApolloGameBannerProcessor(QBaseActivity paramQBaseActivity)
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
      QLog.d("cmgame_process.", 2, " initApolloGameBanner");
    }
    paramBanner = new TipsBar(this.a);
    paramBanner.setTipsIcon(this.a.getResources().getDrawable(2130838637));
    paramBanner.setTipsText(HardCodeUtil.a(2131700999));
    paramBanner.setVisibility(8);
    paramBanner.b(true);
    paramBanner.setOnClickListener(new ApolloGameBannerProcessor.1(this));
    paramBanner.setCloseListener(new ApolloGameBannerProcessor.2(this));
    return paramBanner;
  }
  
  public void a()
  {
    BannerManager.a().a(38, 0);
  }
  
  public void a(Message paramMessage, long paramLong, boolean paramBoolean)
  {
    if (paramMessage.what == 3000)
    {
      int i = BannerManager.a().a(38);
      if (paramMessage.arg1 != 1) {
        i = 2;
      }
      BannerManager.a().a(38, i, paramMessage);
      if (QLog.isColorLevel()) {
        QLog.d("cmgame_process.", 2, " MSG_APOLLO_GAME_SHOW");
      }
    }
  }
  
  public void a(Banner paramBanner, Message paramMessage)
  {
    StringBuilder localStringBuilder;
    if (QLog.isColorLevel())
    {
      localStringBuilder = new StringBuilder().append("updateApolloGameBanner: ").append(paramBanner.a).append(" / ").append(paramMessage).append(" / ");
      if (paramMessage == null) {
        break label73;
      }
    }
    label73:
    for (Object localObject = paramMessage.obj;; localObject = null)
    {
      QLog.d("Q.recent.banner", 2, localObject);
      if (paramBanner.a != null) {
        break;
      }
      return;
    }
    paramBanner.a.setVisibility(0);
    if ((paramMessage != null) && ((paramMessage.obj instanceof String)))
    {
      ((TipsBar)paramBanner.a).setTipsText((String)paramMessage.obj);
      if (QLog.isColorLevel()) {
        QLog.d("cmgame_process.", 2, " updateApolloGameBanner (String) msg.obj:" + (String)paramMessage.obj);
      }
    }
    ReportController.a(this.a.getAppRuntime(), "dc00898", "", "", "0X8009EDF", "0X8009EDF", 10, 0, "", "", "", "");
  }
  
  public void a(AppRuntime paramAppRuntime)
  {
    BannerManager.a().a(38, 0, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.recent.bannerprocessor.ApolloGameBannerProcessor
 * JD-Core Version:    0.7.0.1
 */