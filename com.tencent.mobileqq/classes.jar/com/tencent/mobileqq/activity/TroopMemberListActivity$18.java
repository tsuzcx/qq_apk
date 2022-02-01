package com.tencent.mobileqq.activity;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.data.troop.TroopMemberInfo;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.troop.api.ITroopMemberInfoService;
import com.tencent.mobileqq.troop.api.troopmemberlist.ITroopMemberListActivityApi;
import com.tencent.mobileqq.troop.data.TroopInfoData;
import com.tencent.mobileqq.utils.TroopReportor;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

class TroopMemberListActivity$18
  implements View.OnClickListener
{
  TroopMemberListActivity$18(TroopMemberListActivity paramTroopMemberListActivity) {}
  
  public void onClick(View paramView)
  {
    Object localObject = (List)this.a.mAdapter.a.get(TroopMemberListActivity.access$600(this.a));
    ArrayList localArrayList = new ArrayList();
    int i = 0;
    while (i < ((List)localObject).size())
    {
      localArrayList.add(((TroopMemberListActivity.ATroopMember)((List)localObject).get(i)).a);
      i += 1;
    }
    ((ITroopMemberListActivityApi)QRoute.api(ITroopMemberListActivityApi.class)).startTroopMemberHistoryFragment(paramView.getContext(), this.a.mTroopUin, localArrayList);
    localObject = ((ITroopMemberInfoService)this.a.app.getRuntimeService(ITroopMemberInfoService.class, "")).getTroopMember(this.a.mTroopInfoData.troopUin, this.a.app.getCurrentAccountUin());
    TroopReportor.a("Grp_edu", "teachermsg", "showall", 0, 0, new String[] { this.a.mTroopInfoData.troopUin, TroopReportor.a((TroopMemberInfo)localObject) });
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.TroopMemberListActivity.18
 * JD-Core Version:    0.7.0.1
 */