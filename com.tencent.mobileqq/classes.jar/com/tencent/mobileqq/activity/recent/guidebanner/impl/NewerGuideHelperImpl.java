package com.tencent.mobileqq.activity.recent.guidebanner.impl;

import android.content.Context;
import android.content.Intent;
import android.os.Message;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.home.Conversation;
import com.tencent.mobileqq.activity.recent.bannerprocessor.BeginnerGuideBannerProcessor;
import com.tencent.mobileqq.activity.recent.data.RecentItemMayKnowFriendData;
import com.tencent.mobileqq.activity.recent.data.RecentItemMayKnowFriendVerticalListData;
import com.tencent.mobileqq.activity.recent.guidebanner.INewerGuideHelper;
import com.tencent.mobileqq.activity.recent.guidebanner.NewerGuideBannerHandler;
import com.tencent.mobileqq.activity.recent.guidebanner.NewerGuideBannerManager;
import com.tencent.mobileqq.activity.recent.guidebanner.NewerGuideBannerViewModel;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.banner.BannerManager;
import com.tencent.qphone.base.util.QLog;
import mqq.app.AppRuntime;
import mqq.os.MqqHandler;

public class NewerGuideHelperImpl
  implements INewerGuideHelper
{
  private static final String TAG = "NewerGuideManagerHelper";
  
  public int getBannerId()
  {
    return BeginnerGuideBannerProcessor.a;
  }
  
  public NewerGuideBannerHandler getNewerGuideHandler(AppInterface paramAppInterface)
  {
    return (NewerGuideBannerHandler)paramAppInterface.getBusinessHandler(BusinessHandlerFactory.NEWER_GUIDE_BANNER_HANDLER);
  }
  
  public NewerGuideBannerManager getNewerGuideManager(AppRuntime paramAppRuntime)
  {
    return (NewerGuideBannerManager)paramAppRuntime.getManager(QQManagerFactory.NEWER_GUIDE_BANNER_MANAGER);
  }
  
  public void hideNewerGuideBanner(AppRuntime paramAppRuntime)
  {
    if (paramAppRuntime != null) {
      BannerManager.a().b(BeginnerGuideBannerProcessor.a, 3000);
    }
  }
  
  public <T> boolean isMayKnowRecentBaseData(T paramT)
  {
    return ((paramT instanceof RecentItemMayKnowFriendData)) || ((paramT instanceof RecentItemMayKnowFriendVerticalListData));
  }
  
  public void notifyClickCloseBanner(NewerGuideBannerViewModel paramNewerGuideBannerViewModel)
  {
    AppRuntime localAppRuntime = BaseApplicationImpl.getApplication().getRuntime();
    if ((localAppRuntime instanceof QQAppInterface)) {
      paramNewerGuideBannerViewModel.b(localAppRuntime);
    }
  }
  
  public void showNewerGuideBanner(AppInterface paramAppInterface, Object paramObject)
  {
    paramAppInterface = paramAppInterface.getHandlerWithoutDefault(Conversation.class);
    if (paramAppInterface != null)
    {
      Message localMessage = Message.obtain();
      localMessage.what = 1134210;
      localMessage.obj = paramObject;
      paramAppInterface.sendMessage(localMessage);
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("NewerGuideManagerHelper", 2, "showNewerGuideBanner get handler fail null");
    }
  }
  
  public void startBrowser(Context paramContext, String paramString1, String paramString2)
  {
    Intent localIntent = new Intent(paramContext, QQBrowserActivity.class);
    localIntent.putExtra("url", paramString1);
    localIntent.putExtra("source_from", paramString2);
    paramContext.startActivity(localIntent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.recent.guidebanner.impl.NewerGuideHelperImpl
 * JD-Core Version:    0.7.0.1
 */