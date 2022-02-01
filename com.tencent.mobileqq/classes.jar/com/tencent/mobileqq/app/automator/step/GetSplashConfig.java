package com.tencent.mobileqq.app.automator.step;

import com.tencent.av.redpacket.config.AVRedPacketConfigManager;
import com.tencent.biz.pubaccount.readinjoy.config.AladdinConfigServlet;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.activity.StructMsgObserver;
import com.tencent.mobileqq.activity.springfestival.config.SpringFestivalRedpacketConfigManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.automator.AsyncStep;
import com.tencent.mobileqq.app.automator.Automator;
import com.tencent.mobileqq.config.splashlogo.ConfigServlet;
import com.tencent.mobileqq.config.splashlogo.QQStoryConfigServlet;
import com.tencent.mobileqq.olympic.OlympicManager;
import com.tencent.mobileqq.olympic.OlympicServlet;
import com.tencent.mobileqq.shortvideo.ShortVideoResourceManager;
import com.tencent.qphone.base.util.QLog;
import cooperation.vip.manager.PackageUpdateManager;
import dov.com.qq.im.ae.download.old.AEOldShortVideoResManager;
import java.util.Locale;

public class GetSplashConfig
  extends AsyncStep
{
  public int a()
  {
    Object localObject = this.a.a.getConfig(this.a.a.getCurrentAccountUin(), true);
    if (QLog.isColorLevel()) {
      QLog.i("PushBannerConfig", 2, String.format(Locale.getDefault(), "GetSplashConfig config: %s", new Object[] { localObject }));
    }
    ConfigServlet.a(this.a.a, this.a.a.getCurrentAccountUin());
    QQStoryConfigServlet.a(this.a.a, this.a.a.getCurrentUin());
    ((AVRedPacketConfigManager)this.a.a.getManager(QQManagerFactory.AV_REDPACKET_CONFIG_MGR)).a = true;
    AEOldShortVideoResManager.a(this.a.a, 1);
    ShortVideoResourceManager.a(this.a.a, 1);
    ConfigServlet.e(this.a.a, this.a.a.getCurrentAccountUin());
    ConfigServlet.f(this.a.a, this.a.a.getCurrentAccountUin());
    localObject = (OlympicManager)this.a.a.getManager(QQManagerFactory.OLYMPIC_MANAGER);
    OlympicServlet.a(this.a.a, ((OlympicManager)localObject).b());
    AladdinConfigServlet.a(this.a.a, this.a.a.getCurrentUin());
    ((SpringFestivalRedpacketConfigManager)this.a.a.getManager(QQManagerFactory.SPRING_FESTIVAL_RED_PACKET_MANAGER)).b(this.a.a, 0);
    PackageUpdateManager.a().a(this.a.a);
    this.a.a.getMessageFacade().addObserver(new StructMsgObserver());
    this.a.a.getSignInInfo(1);
    return 7;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.app.automator.step.GetSplashConfig
 * JD-Core Version:    0.7.0.1
 */