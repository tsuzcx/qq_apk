package com.tencent.mobileqq.activity.aio.intimate;

import android.content.Context;
import com.tencent.mobileqq.activity.aio.IntimateInfoView;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.qphone.base.util.QLog;

public class IntimateViewFactory
{
  public static BaseIntimateView a(QQAppInterface paramQQAppInterface, BaseActivity paramBaseActivity, Context paramContext, String paramString)
  {
    FriendsManager localFriendsManager = (FriendsManager)paramQQAppInterface.getManager(QQManagerFactory.FRIENDS_MANAGER);
    boolean bool;
    if (localFriendsManager != null) {
      bool = localFriendsManager.n(paramString);
    } else {
      bool = true;
    }
    if (bool) {
      paramQQAppInterface = new IntimateInfoView(paramQQAppInterface, paramBaseActivity, paramContext, paramString);
    } else {
      paramQQAppInterface = new StrangerIntimateView(paramQQAppInterface, paramBaseActivity, paramContext, paramString);
    }
    if (QLog.isColorLevel())
    {
      paramBaseActivity = new StringBuilder();
      paramBaseActivity.append("getIntimateView bFriend = ");
      paramBaseActivity.append(bool);
      paramBaseActivity.append(" IntimateView ");
      paramBaseActivity.append("created");
      QLog.i("IntimateViewFactory", 2, paramBaseActivity.toString());
    }
    return paramQQAppInterface;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.intimate.IntimateViewFactory
 * JD-Core Version:    0.7.0.1
 */