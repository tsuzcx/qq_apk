package com.tencent.mobileqq.app.automator.step;

import aduw;
import aova;
import aovf;
import bkbz;
import com.tencent.biz.pubaccount.readinjoy.config.AladdinConfigServlet;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.automator.AsyncStep;
import com.tencent.mobileqq.app.automator.Automator;
import com.tencent.mobileqq.olympic.OlympicManager;
import com.tencent.mobileqq.olympic.OlympicServlet;
import com.tencent.mobileqq.shortvideo.ShortVideoResourceManager;
import com.tencent.qphone.base.util.QLog;
import java.util.Locale;
import lwp;

public class GetSplashConfig
  extends AsyncStep
{
  public int a()
  {
    Object localObject = this.a.app.a(this.a.app.getCurrentAccountUin(), true);
    if (QLog.isColorLevel()) {
      QLog.i("PushBannerConfig", 2, String.format(Locale.getDefault(), "GetSplashConfig config: %s", new Object[] { localObject }));
    }
    aova.a(this.a.app, this.a.app.getCurrentAccountUin());
    aovf.a(this.a.app, this.a.app.c());
    ((lwp)this.a.app.getManager(254)).a = true;
    ShortVideoResourceManager.a(this.a.app, 1);
    aova.e(this.a.app, this.a.app.getCurrentAccountUin());
    aova.f(this.a.app, this.a.app.getCurrentAccountUin());
    localObject = (OlympicManager)this.a.app.getManager(167);
    OlympicServlet.a(this.a.app, ((OlympicManager)localObject).b());
    AladdinConfigServlet.a(this.a.app, this.a.app.c());
    bkbz.a().a(this.a.app);
    this.a.app.a().addObserver(new aduw());
    this.a.app.a(1);
    return 7;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.app.automator.step.GetSplashConfig
 * JD-Core Version:    0.7.0.1
 */