package com.tencent.mobileqq.activity.recent;

import android.content.Context;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.activity.recent.config.recentlist.RecentConvertFilterDispatcher;
import com.tencent.mobileqq.activity.recent.config.recentlist.RecentDataConvertDispatcher;
import com.tencent.mobileqq.activity.recent.config.recentlist.base.RecentListConfig;
import com.tencent.mobileqq.activity.recent.data.RecentUserBaseData;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.imcore.proxy.business.ConversationDataFactoryProxy;
import com.tencent.mobileqq.utils.StartupTracker;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.TraceUtils;
import java.lang.reflect.Constructor;
import java.util.List;

public class ConversationDataFactory
{
  public static RecentBaseData a(RecentUser paramRecentUser, BaseQQAppInterface paramBaseQQAppInterface, Context paramContext)
  {
    return a(paramRecentUser, paramBaseQQAppInterface, paramContext, true);
  }
  
  public static RecentBaseData a(RecentUser paramRecentUser, BaseQQAppInterface paramBaseQQAppInterface, Context paramContext, boolean paramBoolean)
  {
    if ((paramRecentUser == null) || (paramBaseQQAppInterface == null) || (paramContext == null)) {}
    do
    {
      do
      {
        return null;
        if (!TextUtils.isEmpty(paramRecentUser.uin)) {
          break;
        }
      } while (!QLog.isColorLevel());
      QLog.i("Q.recent", 2, "buildRecentItemData, uin is null, " + paramRecentUser);
      return null;
      paramRecentUser = RecentListConfig.a().a(paramBaseQQAppInterface, paramRecentUser);
    } while (paramRecentUser == null);
    long l1 = System.currentTimeMillis();
    if (paramBoolean) {}
    try
    {
      paramRecentUser.update(paramBaseQQAppInterface, paramContext);
      if (QLog.isColorLevel())
      {
        long l2 = System.currentTimeMillis();
        if (QLog.isColorLevel()) {
          QLog.i("Q.recent.cost", 4, "[" + (l2 - l1) + ", " + paramRecentUser.getRecentUserUin() + "," + paramRecentUser.getClass().getName() + "," + paramBoolean + "]");
        }
        paramRecentUser.printDataItem();
      }
      return paramRecentUser;
    }
    catch (Throwable paramRecentUser)
    {
      RecentParcelUtil.a(paramBaseQQAppInterface.getApp(), false, paramRecentUser);
      throw new RuntimeException(paramRecentUser);
    }
  }
  
  @Nullable
  public static RecentBaseData a(Class<? extends RecentBaseData> paramClass, RecentUser paramRecentUser)
  {
    if (paramClass != null) {
      try
      {
        paramClass = (RecentBaseData)paramClass.getDeclaredConstructor(new Class[] { RecentUser.class }).newInstance(new Object[] { paramRecentUser });
        return paramClass;
      }
      catch (Exception paramClass)
      {
        QLog.e("Q.recent", 1, paramClass, new Object[0]);
      }
    }
    return null;
  }
  
  public static void a(List<RecentUser> paramList, BaseQQAppInterface paramBaseQQAppInterface, Context paramContext, List<RecentBaseData> paramList1, int paramInt)
  {
    if ((paramList == null) || (paramList1 == null)) {
      return;
    }
    for (;;)
    {
      int j;
      int i;
      try
      {
        paramList1.clear();
        j = ConversationDataFactoryProxy.a(paramBaseQQAppInterface, paramList.size());
        if (!QLog.isColorLevel()) {
          break label438;
        }
        QLog.d("Q.recent", 2, "convertToRecentBaseDataList limit:" + paramInt + ",size:" + j);
      }
      finally {}
      if ((i >= paramInt) || (i >= j)) {
        break;
      }
      Object localObject2 = (RecentUser)paramList.get(i);
      if ((localObject2 != null) && (!RecentListConfig.a().a((RecentUser)localObject2, j, paramInt)))
      {
        TraceUtils.traceBegin(((RecentUser)localObject2).uin);
        StartupTracker.a(null, "Recent_LoadData_conv_uin_record");
        String str = RecentDataListManager.a(((RecentUser)localObject2).uin, ((RecentUser)localObject2).getType());
        Object localObject1 = RecentDataListManager.a().a(str);
        if (localObject1 == null)
        {
          StartupTracker.a(null, "Recent_LoadData_build_item");
          localObject2 = a((RecentUser)localObject2, paramBaseQQAppInterface, paramContext);
          StartupTracker.a("Recent_LoadData_build_item", null);
          localObject1 = localObject2;
          if (localObject2 != null)
          {
            RecentDataListManager.a().a((RecentBaseData)localObject2, str);
            localObject1 = localObject2;
          }
          StartupTracker.a("Recent_LoadData_conv_uin_record", null);
          if (localObject1 != null) {
            paramList1.add(localObject1);
          }
          TraceUtils.traceEnd();
        }
        else
        {
          long l = System.currentTimeMillis();
          if ((localObject1 instanceof RecentUserBaseData)) {
            ((RecentUserBaseData)localObject1).a((RecentUser)localObject2);
          }
          StartupTracker.a(null, "Recent_LoadData_update");
          try
          {
            ((RecentBaseData)localObject1).update(paramBaseQQAppInterface, paramContext);
            StartupTracker.a("Recent_LoadData_update", null);
            l = System.currentTimeMillis() - l;
            if (QLog.isColorLevel())
            {
              QLog.i("Q.recent.cost", 2, "[" + l + ", " + ((RecentBaseData)localObject1).getRecentUserUin() + "," + localObject1.getClass().getName() + "]");
              ((RecentBaseData)localObject1).printDataItem();
            }
          }
          catch (Throwable paramList)
          {
            RecentParcelUtil.a(paramContext, false, paramList);
            throw new RuntimeException(paramList);
          }
          QLog.d("Q.recent.cost", 1, "[" + l + "," + localObject1.getClass().getName() + "]");
          continue;
          label438:
          i = 0;
          continue;
        }
      }
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.activity.recent.ConversationDataFactory
 * JD-Core Version:    0.7.0.1
 */