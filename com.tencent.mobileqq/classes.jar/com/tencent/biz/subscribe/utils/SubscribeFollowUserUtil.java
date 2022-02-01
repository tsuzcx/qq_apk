package com.tencent.biz.subscribe.utils;

import android.content.Context;
import android.content.res.Resources;
import android.text.TextUtils;
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
    if (TextUtils.isEmpty(paramString)) {
      QLog.e("SubscribeFollowUserUtil", 2, "follow user failed! user is null");
    }
    do
    {
      return;
      Object localObject = BaseApplicationImpl.getApplication().getRuntime();
      if ((localObject instanceof QQAppInterface))
      {
        localObject = (QQAppInterface)localObject;
        ((IPublicAccountUtil)QRoute.api(IPublicAccountUtil.class)).followUin((AppInterface)localObject, paramContext, paramString, new SubscribeFollowUserUtil.PublicAccountFollowObserver(paramResultListener), false, 0, true);
        return;
      }
    } while (paramResultListener == null);
    paramResultListener.a(false, paramString, false);
  }
  
  public static void a(Context paramContext, String paramString1, String paramString2, SubscribeFollowUserUtil.ResultListener paramResultListener)
  {
    a(paramContext, paramString1, true, paramString2, 2131696427, paramResultListener);
  }
  
  public static void a(Context paramContext, String paramString1, boolean paramBoolean, String paramString2, int paramInt, SubscribeFollowUserUtil.ResultListener paramResultListener)
  {
    if (paramContext == null) {}
    ActionSheet localActionSheet;
    do
    {
      return;
      localActionSheet = ActionSheet.create(paramContext);
      if (paramBoolean) {
        localActionSheet.setMainTitle(String.format(paramContext.getResources().getString(2131695270), new Object[] { paramString2 }));
      }
      localActionSheet.addButton(paramInt, 3);
      localActionSheet.addCancelButton(2131690800);
      localActionSheet.setOnDismissListener(new SubscribeFollowUserUtil.1());
      localActionSheet.setOnBottomCancelListener(new SubscribeFollowUserUtil.2(paramResultListener, paramString1, localActionSheet));
      localActionSheet.setOnButtonClickListener(new SubscribeFollowUserUtil.3(paramContext, paramString1, paramResultListener, localActionSheet));
    } while (localActionSheet.isShowing());
    a = false;
    localActionSheet.show();
  }
  
  public static void b(Context paramContext, String paramString, SubscribeFollowUserUtil.ResultListener paramResultListener)
  {
    a(paramContext, paramString, false, "", 2131695268, paramResultListener);
  }
  
  public static void c(Context paramContext, String paramString, SubscribeFollowUserUtil.ResultListener paramResultListener)
  {
    if (TextUtils.isEmpty(paramString)) {
      QLog.e("SubscribeFollowUserUtil", 2, "unfollow user failed! user is null");
    }
    do
    {
      return;
      Object localObject = BaseApplicationImpl.getApplication().getRuntime();
      if ((localObject instanceof QQAppInterface))
      {
        localObject = (QQAppInterface)localObject;
        ((IPublicAccountUtil)QRoute.api(IPublicAccountUtil.class)).unfollowUin((QQAppInterface)localObject, paramContext, paramString, false, new SubscribeFollowUserUtil.PublicAccountUnFollowObserver(paramResultListener), true);
        return;
      }
    } while (paramResultListener == null);
    paramResultListener.a(false, paramString, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.subscribe.utils.SubscribeFollowUserUtil
 * JD-Core Version:    0.7.0.1
 */