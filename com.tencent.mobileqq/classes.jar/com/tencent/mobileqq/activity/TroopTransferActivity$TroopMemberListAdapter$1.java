package com.tencent.mobileqq.activity;

import android.text.TextUtils;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.data.troop.TroopMemberInfo;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.troop.api.handler.ITroopMemberCardHandler;
import com.tencent.mobileqq.troop.util.api.ITroopDBUtilsApi;
import com.tencent.mobileqq.utils.ChnToSpell;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;

class TroopTransferActivity$TroopMemberListAdapter$1
  implements Runnable
{
  TroopTransferActivity$TroopMemberListAdapter$1(TroopTransferActivity.TroopMemberListAdapter paramTroopMemberListAdapter, TroopTransferActivity paramTroopTransferActivity) {}
  
  public void run()
  {
    int j = this.jdField_a_of_type_ComTencentMobileqqActivityTroopTransferActivity$TroopMemberListAdapter.jdField_a_of_type_JavaUtilArrayList.size();
    TroopManager localTroopManager = (TroopManager)this.jdField_a_of_type_ComTencentMobileqqActivityTroopTransferActivity$TroopMemberListAdapter.jdField_a_of_type_ComTencentMobileqqActivityTroopTransferActivity.app.getManager(QQManagerFactory.TROOP_MANAGER);
    FriendsManager localFriendsManager = (FriendsManager)this.jdField_a_of_type_ComTencentMobileqqActivityTroopTransferActivity$TroopMemberListAdapter.jdField_a_of_type_ComTencentMobileqqActivityTroopTransferActivity.app.getManager(QQManagerFactory.FRIENDS_MANAGER);
    ArrayList localArrayList = new ArrayList();
    int i = 0;
    StringBuilder localStringBuilder;
    while (i < j)
    {
      TroopTransferActivity.TroopMemberItem localTroopMemberItem = (TroopTransferActivity.TroopMemberItem)this.jdField_a_of_type_ComTencentMobileqqActivityTroopTransferActivity$TroopMemberListAdapter.jdField_a_of_type_JavaUtilArrayList.get(i);
      if (!TextUtils.isEmpty(localTroopMemberItem.a))
      {
        localStringBuilder = null;
        if (localFriendsManager == null) {
          localObject = null;
        } else {
          localObject = localFriendsManager.e(localTroopMemberItem.a);
        }
        if ((localObject != null) && (!TextUtils.isEmpty(((Friends)localObject).name))) {
          localTroopMemberItem.g = ((Friends)localObject).name;
        }
        if ((localObject != null) && (!TextUtils.isEmpty(((Friends)localObject).remark))) {
          localTroopMemberItem.j = ((Friends)localObject).remark;
        }
        if (localTroopManager == null) {
          localObject = localStringBuilder;
        } else {
          localObject = localTroopManager.a(this.jdField_a_of_type_ComTencentMobileqqActivityTroopTransferActivity$TroopMemberListAdapter.jdField_a_of_type_ComTencentMobileqqActivityTroopTransferActivity.a, localTroopMemberItem.a);
        }
        if ((!TextUtils.isEmpty((CharSequence)localObject)) && (!((String)localObject).equals(localTroopMemberItem.a)))
        {
          localTroopMemberItem.m = ((String)localObject);
        }
        else
        {
          localObject = ((ITroopDBUtilsApi)QRoute.api(ITroopDBUtilsApi.class)).getTroopMemberInfo(this.jdField_a_of_type_ComTencentMobileqqActivityTroopTransferActivity$TroopMemberListAdapter.jdField_a_of_type_ComTencentMobileqqActivityTroopTransferActivity.app, String.valueOf(this.jdField_a_of_type_ComTencentMobileqqActivityTroopTransferActivity$TroopMemberListAdapter.jdField_a_of_type_ComTencentMobileqqActivityTroopTransferActivity.a), localTroopMemberItem.a);
          if ((localObject != null) && (!TextUtils.isEmpty(((TroopMemberInfo)localObject).troopColorNick))) {
            localTroopMemberItem.m = ((TroopMemberInfo)localObject).troopColorNick;
          }
          if ((localObject != null) && (!TextUtils.isEmpty(((TroopMemberInfo)localObject).troopremark))) {
            localTroopMemberItem.j = ((TroopMemberInfo)localObject).troopremark;
          }
        }
        if (!TextUtils.isEmpty(localTroopMemberItem.j))
        {
          localTroopMemberItem.b = localTroopMemberItem.j;
        }
        else if (!TextUtils.isEmpty(localTroopMemberItem.m))
        {
          localTroopMemberItem.b = localTroopMemberItem.m;
        }
        else if (!TextUtils.isEmpty(localTroopMemberItem.g))
        {
          localTroopMemberItem.b = localTroopMemberItem.g;
        }
        else if (!TextUtils.isEmpty(localTroopMemberItem.a))
        {
          localTroopMemberItem.b = localTroopMemberItem.a;
          localArrayList.add(localTroopMemberItem.a);
        }
        if (!TextUtils.isEmpty(localTroopMemberItem.b))
        {
          localTroopMemberItem.c = ChnToSpell.a(localTroopMemberItem.b, 2);
          localTroopMemberItem.d = ChnToSpell.a(localTroopMemberItem.b, 1);
        }
        else
        {
          localTroopMemberItem.c = "";
          localTroopMemberItem.d = "";
        }
        if (!TextUtils.isEmpty(localTroopMemberItem.g))
        {
          localTroopMemberItem.h = ChnToSpell.a(localTroopMemberItem.g, 2);
          localTroopMemberItem.i = ChnToSpell.a(localTroopMemberItem.g, 1);
        }
        else
        {
          localTroopMemberItem.h = "";
          localTroopMemberItem.i = "";
        }
        if (!TextUtils.isEmpty(localTroopMemberItem.j))
        {
          localTroopMemberItem.k = ChnToSpell.a(localTroopMemberItem.j, 2);
          localTroopMemberItem.l = ChnToSpell.a(localTroopMemberItem.j, 1);
        }
        else
        {
          localTroopMemberItem.k = "";
          localTroopMemberItem.l = "";
        }
        if (!TextUtils.isEmpty(localTroopMemberItem.m))
        {
          localTroopMemberItem.n = ChnToSpell.a(localTroopMemberItem.m, 2);
          localTroopMemberItem.o = ChnToSpell.a(localTroopMemberItem.m, 1);
        }
        else
        {
          localTroopMemberItem.n = "";
          localTroopMemberItem.o = "";
        }
      }
      i += 1;
    }
    Object localObject = (ITroopMemberCardHandler)this.jdField_a_of_type_ComTencentMobileqqActivityTroopTransferActivity$TroopMemberListAdapter.jdField_a_of_type_ComTencentMobileqqActivityTroopTransferActivity.app.getBusinessHandler(BusinessHandlerFactory.TROOP_MEMBER_CARD_HANDLER);
    if (QLog.isColorLevel())
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("init list data, size = ");
      localStringBuilder.append(localArrayList.size());
      localStringBuilder.append(", frh = ");
      localStringBuilder.append(localObject);
      QLog.i("Q.troopdisband.transfer", 2, localStringBuilder.toString());
    }
    if ((localArrayList.size() > 0) && (localObject != null)) {
      ((ITroopMemberCardHandler)localObject).a(this.jdField_a_of_type_ComTencentMobileqqActivityTroopTransferActivity$TroopMemberListAdapter.jdField_a_of_type_ComTencentMobileqqActivityTroopTransferActivity.a, this.jdField_a_of_type_ComTencentMobileqqActivityTroopTransferActivity$TroopMemberListAdapter.jdField_a_of_type_ComTencentMobileqqActivityTroopTransferActivity.b, localArrayList);
    }
    try
    {
      if ((this.jdField_a_of_type_ComTencentMobileqqActivityTroopTransferActivity$TroopMemberListAdapter.jdField_a_of_type_ComTencentMobileqqActivityTroopTransferActivity != null) && (!this.jdField_a_of_type_ComTencentMobileqqActivityTroopTransferActivity$TroopMemberListAdapter.jdField_a_of_type_ComTencentMobileqqActivityTroopTransferActivity.isFinishing()))
      {
        this.jdField_a_of_type_ComTencentMobileqqActivityTroopTransferActivity$TroopMemberListAdapter.jdField_a_of_type_ComTencentMobileqqActivityTroopTransferActivity.runOnUiThread(new TroopTransferActivity.TroopMemberListAdapter.1.1(this));
        return;
      }
    }
    catch (Exception localException)
    {
      if (QLog.isColorLevel()) {
        QLog.i("Q.troopdisband.transfer", 2, localException.toString());
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.TroopTransferActivity.TroopMemberListAdapter.1
 * JD-Core Version:    0.7.0.1
 */