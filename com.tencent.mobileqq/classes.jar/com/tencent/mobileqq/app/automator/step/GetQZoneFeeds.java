package com.tencent.mobileqq.app.automator.step;

import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.automator.AsyncStep;
import com.tencent.mobileqq.app.automator.Automator;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qzonestatus.QzoneContactsFeedManager;
import com.tencent.mobileqq.startup.step.InstallPlugins;
import com.tencent.qzonehub.api.IQzonePatchApi;

public class GetQZoneFeeds
  extends AsyncStep
{
  public static boolean a = false;
  
  protected int doStep()
  {
    a = true;
    ((QzoneContactsFeedManager)this.mAutomator.k.getManager(QQManagerFactory.QZONE_CONTACTS_FEED_MANAGER)).a();
    ((IQzonePatchApi)QRoute.api(IQzonePatchApi.class)).getPatchList();
    InstallPlugins.a(1);
    InstallPlugins.a();
    return super.doStep();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.app.automator.step.GetQZoneFeeds
 * JD-Core Version:    0.7.0.1
 */