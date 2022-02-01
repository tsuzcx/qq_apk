package com.tencent.mobileqq.activity.selectmember;

import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.proxy.RecentUserProxy;
import com.tencent.mobileqq.data.DiscussionInfo;
import com.tencent.mobileqq.troop.api.IDiscussionService;
import com.tencent.mobileqq.troop.api.ITroopInfoService;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import mqq.os.MqqHandler;

class TroopListBaseAdapter$3
  implements Runnable
{
  TroopListBaseAdapter$3(TroopListBaseAdapter paramTroopListBaseAdapter, RecentUserProxy paramRecentUserProxy) {}
  
  public void run()
  {
    ArrayList localArrayList1 = ((ITroopInfoService)this.this$0.a.getRuntimeService(ITroopInfoService.class, "")).getUiTroopListWithoutBlockedTroop();
    ArrayList localArrayList2 = (ArrayList)((IDiscussionService)this.this$0.a.getRuntimeService(IDiscussionService.class, "")).getDiscussList();
    ArrayList localArrayList3 = new ArrayList();
    Object localObject = localArrayList2.iterator();
    int i = 0;
    while (((Iterator)localObject).hasNext())
    {
      DiscussionInfo localDiscussionInfo = (DiscussionInfo)((Iterator)localObject).next();
      if ((localDiscussionInfo != null) && (!TextUtils.isEmpty(localDiscussionInfo.uin)))
      {
        StringBuilder localStringBuilder;
        if (QLog.isColorLevel())
        {
          localStringBuilder = new StringBuilder();
          localStringBuilder.append("load data asyncLoadTroopListAndNotifyUi discussion : ");
          localStringBuilder.append(localDiscussionInfo);
          QLog.d("TroopListBaseAdapter", 2, localStringBuilder.toString());
        }
        if (!TextUtils.isEmpty(localDiscussionInfo.discussionName))
        {
          localArrayList3.add(localDiscussionInfo);
        }
        else if (i >= 40)
        {
          localArrayList3.add(localDiscussionInfo);
        }
        else if (((IDiscussionService)this.this$0.a.getRuntimeService(IDiscussionService.class, "")).getDiscussionMemberNum(localDiscussionInfo.uin) > 0)
        {
          localArrayList3.add(localDiscussionInfo);
          i += 1;
        }
        else
        {
          i += 1;
          localStringBuilder = new StringBuilder();
          localStringBuilder.append("load data asyncLoadTroopListAndNotifyUi discussion skiped : ");
          localStringBuilder.append(localDiscussionInfo);
          QLog.d("TroopListBaseAdapter", 1, localStringBuilder.toString());
        }
      }
    }
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("load data asyncLoadTroopListAndNotifyUi count: ");
    ((StringBuilder)localObject).append(i);
    ((StringBuilder)localObject).append("  org_discussions.size:");
    ((StringBuilder)localObject).append(localArrayList2.size());
    ((StringBuilder)localObject).append("  discussions.size:");
    ((StringBuilder)localObject).append(localArrayList3.size());
    QLog.d("TroopListBaseAdapter", 1, ((StringBuilder)localObject).toString());
    ThreadManager.getUIHandler().post(new TroopListBaseAdapter.3.1(this, localArrayList1, localArrayList3));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.activity.selectmember.TroopListBaseAdapter.3
 * JD-Core Version:    0.7.0.1
 */