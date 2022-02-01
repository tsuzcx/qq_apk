package com.tencent.biz.subscribe.utils;

import android.content.Context;
import android.content.res.Resources;
import android.text.TextUtils;
import com.tencent.biz.pubaccount.api.IPublicAccountObserver;
import com.tencent.biz.pubaccount.util.api.IPublicAccountUtil;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.ActionSheet;

public class SubscribeFollowUserUtil
{
  private static boolean a = false;
  
  public static void a(Context paramContext, String paramString, SubscribeFollowUserUtil.ResultListener paramResultListener)
  {
    if (TextUtils.isEmpty(paramString))
    {
      QLog.e("SubscribeFollowUserUtil", 2, "follow user failed! user is null");
      return;
    }
    Object localObject = BaseApplicationImpl.getApplication().getRuntime();
    if ((localObject instanceof QQAppInterface))
    {
      localObject = (QQAppInterface)localObject;
      IPublicAccountObserver localIPublicAccountObserver = (IPublicAccountObserver)QRoute.api(IPublicAccountObserver.class);
      localIPublicAccountObserver.setOnCallback(new SubscribeFollowUserUtil.PublicAccountFollowObserver(paramResultListener));
      ((IPublicAccountUtil)QRoute.api(IPublicAccountUtil.class)).followUin((AppInterface)localObject, paramContext, paramString, localIPublicAccountObserver, false, 0, true);
      return;
    }
    if (paramResultListener != null) {
      paramResultListener.a(false, paramString, false);
    }
  }
  
  public static void a(Context paramContext, String paramString1, String paramString2, SubscribeFollowUserUtil.ResultListener paramResultListener)
  {
    a(paramContext, paramString1, true, paramString2, 2131696446, paramResultListener);
  }
  
  public static void a(Context paramContext, String paramString1, boolean paramBoolean, String paramString2, int paramInt, SubscribeFollowUserUtil.ResultListener paramResultListener)
  {
    if (paramContext == null) {
      return;
    }
    ActionSheet localActionSheet = ActionSheet.create(paramContext);
    if (paramBoolean) {
      localActionSheet.setMainTitle(String.format(paramContext.getResources().getString(2131695273), new Object[] { paramString2 }));
    }
    localActionSheet.addButton(paramInt, 3);
    localActionSheet.addCancelButton(2131690728);
    localActionSheet.setOnDismissListener(new SubscribeFollowUserUtil.1());
    localActionSheet.setOnBottomCancelListener(new SubscribeFollowUserUtil.2(paramResultListener, paramString1, localActionSheet));
    localActionSheet.setOnButtonClickListener(new SubscribeFollowUserUtil.3(paramContext, paramString1, paramResultListener, localActionSheet));
    if (!localActionSheet.isShowing())
    {
      a = false;
      localActionSheet.show();
    }
  }
  
  public static void b(Context paramContext, String paramString, SubscribeFollowUserUtil.ResultListener paramResultListener)
  {
    a(paramContext, paramString, false, "", 2131695271, paramResultListener);
  }
  
  public static void c(Context paramContext, String paramString, SubscribeFollowUserUtil.ResultListener paramResultListener)
  {
    if (TextUtils.isEmpty(paramString))
    {
      QLog.e("SubscribeFollowUserUtil", 2, "unfollow user failed! user is null");
      return;
    }
    Object localObject = BaseApplicationImpl.getApplication().getRuntime();
    if ((localObject instanceof QQAppInterface))
    {
      localObject = (QQAppInterface)localObject;
      IPublicAccountObserver localIPublicAccountObserver = (IPublicAccountObserver)QRoute.api(IPublicAccountObserver.class);
      localIPublicAccountObserver.setOnCallback(new SubscribeFollowUserUtil.PublicAccountUnFollowObserver(paramResultListener));
      ((IPublicAccountUtil)QRoute.api(IPublicAccountUtil.class)).unfollowUin((AppInterface)localObject, paramContext, paramString, false, localIPublicAccountObserver, true);
      return;
    }
    if (paramResultListener != null) {
      paramResultListener.a(false, paramString, false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.subscribe.utils.SubscribeFollowUserUtil
 * JD-Core Version:    0.7.0.1
 */