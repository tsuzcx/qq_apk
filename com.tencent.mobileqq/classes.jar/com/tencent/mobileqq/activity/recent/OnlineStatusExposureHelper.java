package com.tencent.mobileqq.activity.recent;

import android.graphics.drawable.Drawable;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.onlinestatus.OnlineStatusItem;
import com.tencent.mobileqq.onlinestatus.api.IOnLineStatueHelperApi;
import com.tencent.mobileqq.onlinestatus.api.IOnlineStatusService;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.abtest.ABTestController;
import com.tencent.mobileqq.utils.abtest.ExpEntityInfo;
import mqq.app.AppRuntime;
import mqq.app.AppRuntime.Status;
import mqq.app.Foreground;

public class OnlineStatusExposureHelper
{
  public static long a(AppRuntime paramAppRuntime, String paramString)
  {
    if (paramAppRuntime.getCurrentUin().equals(paramString)) {
      return ((IOnLineStatueHelperApi)QRoute.api(IOnLineStatueHelperApi.class)).getSelfExtOnlineStatus(paramAppRuntime);
    }
    return ((FriendsManager)paramAppRuntime.getManager(QQManagerFactory.FRIENDS_MANAGER)).e(paramString).uExtOnlineStatus;
  }
  
  public static boolean a()
  {
    ExpEntityInfo localExpEntityInfo = ABTestController.a().a("exp_status_new");
    return (localExpEntityInfo.i()) && (localExpEntityInfo.a("exp_status_new_C"));
  }
  
  public static boolean b()
  {
    return Foreground.getTopActivity() instanceof SplashActivity;
  }
  
  public static boolean b(AppRuntime paramAppRuntime, String paramString)
  {
    return f(paramAppRuntime, paramString).f == 2;
  }
  
  public static Drawable c(AppRuntime paramAppRuntime, String paramString)
  {
    Friends localFriends = ((FriendsManager)paramAppRuntime.getManager(QQManagerFactory.FRIENDS_MANAGER)).e(paramString);
    if (paramAppRuntime.getCurrentUin().equals(paramString))
    {
      paramString = ((IOnlineStatusService)paramAppRuntime.getRuntimeService(IOnlineStatusService.class, "")).getOnlineStatus();
      long l = ((IOnLineStatueHelperApi)QRoute.api(IOnLineStatueHelperApi.class)).getSelfExtOnlineStatus(paramAppRuntime);
      return ((IOnLineStatueHelperApi)QRoute.api(IOnLineStatueHelperApi.class)).getSelfStatusDrawable(l, paramString, 2, localFriends, 5);
    }
    return ((IOnLineStatueHelperApi)QRoute.api(IOnLineStatueHelperApi.class)).getStatusDrawableWithBigType(localFriends, localFriends.uExtOnlineStatus);
  }
  
  public static boolean d(AppRuntime paramAppRuntime, String paramString)
  {
    if (paramAppRuntime.getCurrentUin().equals(paramString)) {
      return true;
    }
    return ((IOnLineStatueHelperApi)QRoute.api(IOnLineStatueHelperApi.class)).hasPermission(paramString);
  }
  
  public static boolean e(AppRuntime paramAppRuntime, String paramString)
  {
    long l = a(paramAppRuntime, paramString);
    return (l == 1030L) || (l > 40000L);
  }
  
  private static OnlineStatusItem f(AppRuntime paramAppRuntime, String paramString)
  {
    Object localObject;
    if (paramAppRuntime.getCurrentUin().equals(paramString))
    {
      localObject = ((IOnlineStatusService)paramAppRuntime.getRuntimeService(IOnlineStatusService.class, "")).getOnlineStatus();
    }
    else
    {
      localObject = ((FriendsManager)paramAppRuntime.getManager(QQManagerFactory.FRIENDS_MANAGER)).e(paramString);
      localObject = ((IOnLineStatueHelperApi)QRoute.api(IOnLineStatueHelperApi.class)).translate((Friends)localObject);
    }
    return ((IOnLineStatueHelperApi)QRoute.api(IOnLineStatueHelperApi.class)).getOnlineStatusItem((AppRuntime.Status)localObject, a(paramAppRuntime, paramString), false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.recent.OnlineStatusExposureHelper
 * JD-Core Version:    0.7.0.1
 */