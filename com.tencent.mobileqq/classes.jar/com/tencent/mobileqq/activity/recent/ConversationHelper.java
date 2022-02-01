package com.tencent.mobileqq.activity.recent;

import android.util.Pair;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.activity.recent.config.recentlist.RecentCheckFilterDispatcher;
import com.tencent.mobileqq.activity.recent.config.recentlist.RecentSortTopDispatcher;
import com.tencent.mobileqq.activity.recent.config.recentlist.RecentSortValueDispatcher;
import com.tencent.mobileqq.activity.recent.config.recentlist.base.RecentListConfig;
import com.tencent.mobileqq.activity.recent.data.RecentUserBaseData;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.proxy.RecentUserProxy;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.imcore.proxy.business.TempMsgBoxManagerProxy;
import com.tencent.mobileqq.proxy.api.IRecentUserProxyService;
import java.util.Comparator;
import java.util.List;

public class ConversationHelper
  implements Comparator<RecentBaseData>
{
  private BaseQQAppInterface a;
  
  public ConversationHelper(BaseQQAppInterface paramBaseQQAppInterface)
  {
    this.a = paramBaseQQAppInterface;
  }
  
  private void b(List<RecentUser> paramList)
  {
    if ((this.a == null) || (!TempMsgBoxManagerProxy.a(this.a))) {}
    RecentUser localRecentUser;
    do
    {
      return;
      RecentUserProxy localRecentUserProxy = ((IRecentUserProxyService)this.a.getRuntimeService(IRecentUserProxyService.class)).getRecentUserCache();
      localRecentUser = null;
      if (localRecentUserProxy != null) {
        localRecentUser = localRecentUserProxy.b(AppConstants.TEMP_MSG_BOX_UIN, 10011);
      }
    } while (localRecentUser == null);
    paramList.add(localRecentUser);
  }
  
  public int a(RecentBaseData paramRecentBaseData1, RecentBaseData paramRecentBaseData2)
  {
    if (((paramRecentBaseData1 instanceof RecentUserBaseData)) && ((paramRecentBaseData2 instanceof RecentUserBaseData)))
    {
      paramRecentBaseData1 = (RecentUserBaseData)paramRecentBaseData1;
      paramRecentBaseData2 = (RecentUserBaseData)paramRecentBaseData2;
      long l1 = 0L;
      int i;
      int j;
      label60:
      long l2;
      label104:
      int k;
      if (RecentListConfig.a().a(this.a, paramRecentBaseData1))
      {
        i = 1;
        if (!RecentListConfig.a().a(this.a, paramRecentBaseData2)) {
          break label149;
        }
        j = 2;
        switch (i + j)
        {
        default: 
          l2 = 0L;
          i = 0;
          j = 0;
          if (l2 > l1) {
            k = 1;
          }
          break;
        }
      }
      for (;;)
      {
        l1 = (k + 2L | j) - (0x2 | i);
        if (l1 != 0L) {
          break label340;
        }
        return 0;
        i = 0;
        break;
        label149:
        j = 0;
        break label60;
        k = RecentListConfig.a().a(this.a, paramRecentBaseData1, 0);
        int m = RecentListConfig.a().a(this.a, paramRecentBaseData2, 0);
        l1 = Math.max(paramRecentBaseData1.mUser.lastmsgtime, paramRecentBaseData1.mUser.lastmsgdrafttime);
        long l3 = l1;
        if (l1 <= 0L) {
          l3 = Math.max(l1, paramRecentBaseData1.mUser.opTime);
        }
        long l4 = Math.max(paramRecentBaseData2.mUser.lastmsgtime, paramRecentBaseData2.mUser.lastmsgdrafttime);
        l2 = l3;
        l1 = l4;
        i = m;
        j = k;
        if (l4 > 0L) {
          break label104;
        }
        l1 = Math.max(l4, paramRecentBaseData2.mUser.opTime);
        l2 = l3;
        i = m;
        j = k;
        break label104;
        return -1;
        return 1;
        l2 = paramRecentBaseData1.mDisplayTime;
        l1 = paramRecentBaseData2.mDisplayTime;
        i = 0;
        j = 0;
        break label104;
        if (l2 == l1) {
          k = 0;
        } else {
          k = -1;
        }
      }
      label340:
      if (l1 < 0L) {
        return 1;
      }
      return -1;
    }
    return 0;
  }
  
  public void a(BaseQQAppInterface paramBaseQQAppInterface)
  {
    this.a = paramBaseQQAppInterface;
  }
  
  public void a(List<RecentUser> paramList)
  {
    ConversationHelper.LogBuilder localLogBuilder = new ConversationHelper.LogBuilder("Q.recent", null);
    ConversationHelper.LogBuilder.a(localLogBuilder, paramList);
    int i;
    label26:
    Object localObject;
    if (paramList == null)
    {
      i = 0;
      i -= 1;
      if (i < 0) {
        break label205;
      }
      localObject = (RecentUser)paramList.get(i);
      if (localObject != null) {
        break label72;
      }
      paramList.remove(i);
    }
    for (;;)
    {
      i -= 1;
      break label26;
      i = paramList.size();
      break;
      label72:
      if ((((RecentUser)localObject).uin == null) || (((RecentUser)localObject).uin.trim().length() == 0))
      {
        paramList.remove(i);
        ConversationHelper.LogBuilder.a(localLogBuilder, new String[] { String.valueOf(i), ",", String.valueOf(((RecentUser)localObject).getType()), ";" });
      }
      else
      {
        localObject = RecentListConfig.a().a(this.a, (RecentUser)localObject, i);
        if ((localObject != null) && (((Boolean)((Pair)localObject).second).booleanValue()))
        {
          paramList.remove(i);
          ConversationHelper.LogBuilder.a(localLogBuilder, new String[] { (String)((Pair)localObject).first });
        }
      }
    }
    label205:
    if (paramList != null) {
      b(paramList);
    }
    ConversationHelper.LogBuilder.a(localLogBuilder);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.activity.recent.ConversationHelper
 * JD-Core Version:    0.7.0.1
 */