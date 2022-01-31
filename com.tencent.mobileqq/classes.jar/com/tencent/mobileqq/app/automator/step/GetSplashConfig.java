package com.tencent.mobileqq.app.automator.step;

import com.tencent.av.redpacket.config.AVRedPacketConfigManager;
import com.tencent.mobileqq.activity.StructMsgObserver;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.automator.AsyncStep;
import com.tencent.mobileqq.app.automator.Automator;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.config.splashlogo.ConfigServlet;
import com.tencent.mobileqq.config.splashlogo.QQStoryConfigServlet;
import com.tencent.mobileqq.olympic.OlympicManager;
import com.tencent.mobileqq.olympic.OlympicServlet;
import com.tencent.mobileqq.shortvideo.ShortVideoResourceManager;
import com.tencent.qphone.base.util.QLog;
import java.util.Locale;

public class GetSplashConfig
  extends AsyncStep
{
  protected int a()
  {
    Object localObject = this.a.b.a(this.a.b.getCurrentAccountUin(), true);
    if (QLog.isColorLevel()) {
      QLog.i("PushBannerConfig", 2, String.format(Locale.getDefault(), "GetSplashConfig config: %s", new Object[] { localObject }));
    }
    ConfigServlet.a(this.a.b, this.a.b.getCurrentAccountUin());
    QQStoryConfigServlet.a(this.a.b, this.a.b.c());
    ((AVRedPacketConfigManager)this.a.b.getManager(253)).a = true;
    ShortVideoResourceManager.a(this.a.b, 1);
    ConfigServlet.e(this.a.b, this.a.b.getCurrentAccountUin());
    ConfigServlet.f(this.a.b, this.a.b.getCurrentAccountUin());
    ConfigServlet.a(0, this.a.b, this.a.b.getCurrentAccountUin());
    localObject = (OlympicManager)this.a.b.getManager(166);
    OlympicServlet.a(this.a.b, ((OlympicManager)localObject).b());
    this.a.b.a().addObserver(new StructMsgObserver());
    this.a.b.a(1);
    return 7;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.app.automator.step.GetSplashConfig
 * JD-Core Version:    0.7.0.1
 */