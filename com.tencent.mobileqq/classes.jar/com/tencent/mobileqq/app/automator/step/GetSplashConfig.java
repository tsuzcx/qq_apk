package com.tencent.mobileqq.app.automator.step;

import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.activity.StructMsgObserver;
import com.tencent.mobileqq.activity.springfestival.config.SpringFestivalRedpacketConfigManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.automator.AsyncStep;
import com.tencent.mobileqq.app.automator.Automator;
import com.tencent.mobileqq.config.Config;
import com.tencent.mobileqq.config.splashlogo.ConfigServlet;
import com.tencent.mobileqq.config.splashlogo.QQStoryConfigServlet;
import com.tencent.mobileqq.kandian.biz.config.api.IAladdinConfigServletUtil;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.shortvideo.ShortVideoResourceManager;
import com.tencent.qphone.base.util.QLog;
import cooperation.vip.manager.PackageUpdateManager;
import dov.com.qq.im.ae.download.old.AEOldShortVideoResManager;
import java.util.Locale;

public class GetSplashConfig
  extends AsyncStep
{
  protected int doStep()
  {
    Config localConfig = this.mAutomator.k.getConfig(this.mAutomator.k.getCurrentAccountUin(), true);
    if (QLog.isColorLevel()) {
      QLog.i("PushBannerConfig", 2, String.format(Locale.getDefault(), "GetSplashConfig config: %s", new Object[] { localConfig }));
    }
    ConfigServlet.a(this.mAutomator.k, this.mAutomator.k.getCurrentAccountUin());
    QQStoryConfigServlet.a(this.mAutomator.k, this.mAutomator.k.getCurrentUin());
    AEOldShortVideoResManager.a(this.mAutomator.k, 1);
    ShortVideoResourceManager.a(this.mAutomator.k, 1);
    ConfigServlet.d(this.mAutomator.k, this.mAutomator.k.getCurrentAccountUin());
    ((IAladdinConfigServletUtil)QRoute.api(IAladdinConfigServletUtil.class)).maybeGetAllConfigs();
    ((SpringFestivalRedpacketConfigManager)this.mAutomator.k.getManager(QQManagerFactory.SPRING_FESTIVAL_RED_PACKET_MANAGER)).b(this.mAutomator.k, 0);
    PackageUpdateManager.a().a(this.mAutomator.k);
    this.mAutomator.k.getMessageFacade().addObserver(new StructMsgObserver());
    this.mAutomator.k.getSignInInfo(1);
    return 7;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.app.automator.step.GetSplashConfig
 * JD-Core Version:    0.7.0.1
 */