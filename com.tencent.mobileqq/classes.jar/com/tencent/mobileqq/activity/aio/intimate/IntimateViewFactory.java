package com.tencent.mobileqq.activity.aio.intimate;

import android.content.Context;
import android.support.v4.app.FragmentActivity;
import com.tencent.mobileqq.activity.aio.IntimateInfoView;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.qphone.base.util.QLog;

public class IntimateViewFactory
{
  public static BaseIntimateView a(QQAppInterface paramQQAppInterface, FragmentActivity paramFragmentActivity, Context paramContext, String paramString)
  {
    boolean bool = true;
    FriendsManager localFriendsManager = (FriendsManager)paramQQAppInterface.getManager(QQManagerFactory.FRIENDS_MANAGER);
    if (localFriendsManager != null) {
      bool = localFriendsManager.b(paramString);
    }
    if (bool)
    {
      paramQQAppInterface = new IntimateInfoView(paramQQAppInterface, paramFragmentActivity, paramContext, paramString);
      if (QLog.isColorLevel())
      {
        paramContext = new StringBuilder().append("getIntimateView bFriend = ").append(bool).append(" IntimateView ");
        if (paramQQAppInterface != null) {
          break label112;
        }
      }
    }
    label112:
    for (paramFragmentActivity = "null";; paramFragmentActivity = "created")
    {
      QLog.i("IntimateViewFactory", 2, paramFragmentActivity);
      return paramQQAppInterface;
      paramQQAppInterface = new StrangerIntimateView(paramQQAppInterface, paramFragmentActivity, paramContext, paramString);
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.intimate.IntimateViewFactory
 * JD-Core Version:    0.7.0.1
 */