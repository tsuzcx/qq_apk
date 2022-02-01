package com.tencent.mobileqq.app.automator.step;

import aeza;
import arph;
import arpm;
import bmnx;
import com.tencent.biz.pubaccount.readinjoy.config.AladdinConfigServlet;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.automator.AsyncStep;
import com.tencent.mobileqq.app.automator.Automator;
import com.tencent.mobileqq.olympic.OlympicManager;
import com.tencent.mobileqq.olympic.OlympicServlet;
import com.tencent.mobileqq.shortvideo.ShortVideoResourceManager;
import com.tencent.qphone.base.util.QLog;
import java.util.Locale;
import lui;

public class GetSplashConfig
  extends AsyncStep
{
  public int a()
  {
    Object localObject = this.a.app.getConfig(this.a.app.getCurrentAccountUin(), true);
    if (QLog.isColorLevel()) {
      QLog.i("PushBannerConfig", 2, String.format(Locale.getDefault(), "GetSplashConfig config: %s", new Object[] { localObject }));
    }
    arph.a(this.a.app, this.a.app.getCurrentAccountUin());
    arpm.a(this.a.app, this.a.app.getCurrentUin());
    ((lui)this.a.app.getManager(QQManagerFactory.AV_REDPACKET_CONFIG_MGR)).a = true;
    ShortVideoResourceManager.a(this.a.app, 1);
    arph.e(this.a.app, this.a.app.getCurrentAccountUin());
    arph.f(this.a.app, this.a.app.getCurrentAccountUin());
    localObject = (OlympicManager)this.a.app.getManager(QQManagerFactory.OLYMPIC_MANAGER);
    OlympicServlet.a(this.a.app, ((OlympicManager)localObject).b());
    AladdinConfigServlet.a(this.a.app, this.a.app.getCurrentUin());
    bmnx.a().a(this.a.app);
    this.a.app.getMessageFacade().addObserver(new aeza());
    this.a.app.getSignInInfo(1);
    return 7;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.app.automator.step.GetSplashConfig
 * JD-Core Version:    0.7.0.1
 */