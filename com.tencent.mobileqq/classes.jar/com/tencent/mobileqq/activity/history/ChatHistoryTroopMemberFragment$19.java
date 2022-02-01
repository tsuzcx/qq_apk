package com.tencent.mobileqq.activity.history;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.PublicFragmentActivity;
import com.tencent.mobileqq.activity.chathistory.TroopMemberHistoryFragment;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.data.troop.TroopMemberInfo;
import com.tencent.mobileqq.troop.data.TroopInfoData;
import com.tencent.mobileqq.utils.TroopReportor;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

class ChatHistoryTroopMemberFragment$19
  implements View.OnClickListener
{
  ChatHistoryTroopMemberFragment$19(ChatHistoryTroopMemberFragment paramChatHistoryTroopMemberFragment) {}
  
  public void onClick(View paramView)
  {
    Object localObject = new Intent();
    ((Intent)localObject).putExtra("troop_uin", this.a.c);
    List localList = (List)this.a.jdField_a_of_type_ComTencentMobileqqActivityHistoryChatHistoryTroopMemberFragment$ListAdapter.a.get(ChatHistoryTroopMemberFragment.a(this.a));
    ArrayList localArrayList = new ArrayList();
    int i = 0;
    while (i < localList.size())
    {
      localArrayList.add(((ChatHistoryTroopMemberFragment.ATroopMember)localList.get(i)).a);
      i += 1;
    }
    ((Intent)localObject).putExtra("members_uin", localArrayList);
    PublicFragmentActivity.a(paramView.getContext(), (Intent)localObject, TroopMemberHistoryFragment.class);
    localObject = ((TroopManager)this.a.getBaseActivity().app.getManager(QQManagerFactory.TROOP_MANAGER)).b(this.a.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.troopUin, this.a.b.getCurrentAccountUin());
    TroopReportor.a("Grp_edu", "teachermsg", "showall", 0, 0, new String[] { this.a.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.troopUin, TroopReportor.a((TroopMemberInfo)localObject) });
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.activity.history.ChatHistoryTroopMemberFragment.19
 * JD-Core Version:    0.7.0.1
 */