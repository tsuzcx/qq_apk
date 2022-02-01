package com.tencent.mobileqq.activity.recent.msgbox;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.common.app.AppInterface;
import com.tencent.imcore.message.Message;
import com.tencent.mobileqq.activity.recent.msgbox.api.ITempMsgBoxManager;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.proxy.RecentUserProxy;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.proxy.api.IRecentUserProxyService;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

public class FilterMsgBoxUtil
{
  public static int a(AppInterface paramAppInterface, Message paramMessage)
  {
    Iterator localIterator = a(paramAppInterface).iterator();
    int i = 0;
    while (localIterator.hasNext())
    {
      RecentUser localRecentUser = (RecentUser)localIterator.next();
      if (paramMessage != null) {
        i += TempMsgBoxUtil.a.a(paramAppInterface, localRecentUser.uin, localRecentUser.getType(), i, null);
      }
    }
    return i;
  }
  
  public static long a()
  {
    return a().getLong("filter_msg_time", 0L);
  }
  
  private static SharedPreferences a()
  {
    AppRuntime localAppRuntime = MobileQQ.sMobileQQ.waitAppRuntime(null);
    String str = localAppRuntime.getAccount();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("file_filter_msg");
    localStringBuilder.append(str);
    str = localStringBuilder.toString();
    return localAppRuntime.getApp().getSharedPreferences(str, 0);
  }
  
  public static List<RecentUser> a(AppInterface paramAppInterface)
  {
    ArrayList localArrayList = new ArrayList();
    Object localObject = ((IRecentUserProxyService)paramAppInterface.getRuntimeService(IRecentUserProxyService.class, "")).getRecentUserCache();
    int i = 0;
    localObject = ((RecentUserProxy)localObject).a(true, false);
    paramAppInterface = (ITempMsgBoxManager)paramAppInterface.getRuntimeService(ITempMsgBoxManager.class, "");
    while (i < ((List)localObject).size())
    {
      RecentUser localRecentUser = (RecentUser)((List)localObject).get(i);
      if (paramAppInterface.isBelongToFilterBox(localRecentUser.uin, localRecentUser.getType())) {
        localArrayList.add(localRecentUser);
      }
      i += 1;
    }
    return localArrayList;
  }
  
  public static void a(long paramLong)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("saveUpdateTime() called with: updateTime = [");
      localStringBuilder.append(paramLong);
      localStringBuilder.append("]");
      QLog.d("FilterMsgBoxUtil", 2, localStringBuilder.toString());
    }
    a().edit().putLong("filter_msg_time", paramLong).apply();
  }
  
  public static void a(AppInterface paramAppInterface, boolean paramBoolean)
  {
    List localList = a(paramAppInterface);
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onRecentBaseDataDelete() called with: filterBoxRecentUsers = [");
      localStringBuilder.append(localList);
      localStringBuilder.append("]");
      QLog.d("FilterMsgBoxUtil", 2, localStringBuilder.toString());
    }
    if (localList.isEmpty())
    {
      paramAppInterface = ((IRecentUserProxyService)paramAppInterface.getRuntimeService(IRecentUserProxyService.class, "")).getRecentUserCache();
      paramAppInterface.a(paramAppInterface.a(AppConstants.FILTER_MSG_UIN, 10012), paramBoolean);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.activity.recent.msgbox.FilterMsgBoxUtil
 * JD-Core Version:    0.7.0.1
 */