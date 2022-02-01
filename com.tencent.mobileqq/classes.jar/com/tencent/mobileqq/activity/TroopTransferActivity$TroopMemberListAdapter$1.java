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
import com.tencent.mobileqq.troop.handler.TroopMemberInfoHandler;
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
    if (i < j)
    {
      TroopTransferActivity.TroopMemberItem localTroopMemberItem = (TroopTransferActivity.TroopMemberItem)this.jdField_a_of_type_ComTencentMobileqqActivityTroopTransferActivity$TroopMemberListAdapter.jdField_a_of_type_JavaUtilArrayList.get(i);
      if (TextUtils.isEmpty(localTroopMemberItem.a)) {}
      for (;;)
      {
        i += 1;
        break;
        if (localFriendsManager == null)
        {
          localObject = null;
          label110:
          if ((localObject != null) && (!TextUtils.isEmpty(((Friends)localObject).name))) {
            localTroopMemberItem.g = ((Friends)localObject).name;
          }
          if ((localObject != null) && (!TextUtils.isEmpty(((Friends)localObject).remark))) {
            localTroopMemberItem.j = ((Friends)localObject).remark;
          }
          if (localTroopManager != null) {
            break label464;
          }
          localObject = null;
          label163:
          if ((!TextUtils.isEmpty((CharSequence)localObject)) && (!((String)localObject).equals(localTroopMemberItem.a))) {
            break label488;
          }
          localObject = ((ITroopDBUtilsApi)QRoute.api(ITroopDBUtilsApi.class)).getTroopMemberInfo(this.jdField_a_of_type_ComTencentMobileqqActivityTroopTransferActivity$TroopMemberListAdapter.jdField_a_of_type_ComTencentMobileqqActivityTroopTransferActivity.app, String.valueOf(this.jdField_a_of_type_ComTencentMobileqqActivityTroopTransferActivity$TroopMemberListAdapter.jdField_a_of_type_ComTencentMobileqqActivityTroopTransferActivity.a), localTroopMemberItem.a);
          if ((localObject != null) && (!TextUtils.isEmpty(((TroopMemberInfo)localObject).troopColorNick))) {
            localTroopMemberItem.m = ((TroopMemberInfo)localObject).troopColorNick;
          }
          if ((localObject != null) && (!TextUtils.isEmpty(((TroopMemberInfo)localObject).troopremark))) {
            localTroopMemberItem.j = ((TroopMemberInfo)localObject).troopremark;
          }
          label270:
          if (TextUtils.isEmpty(localTroopMemberItem.j)) {
            break label497;
          }
          localTroopMemberItem.b = localTroopMemberItem.j;
          label291:
          if (TextUtils.isEmpty(localTroopMemberItem.b)) {
            break label580;
          }
          localTroopMemberItem.c = ChnToSpell.a(localTroopMemberItem.b, 2);
          localTroopMemberItem.d = ChnToSpell.a(localTroopMemberItem.b, 1);
          label330:
          if (TextUtils.isEmpty(localTroopMemberItem.g)) {
            break label597;
          }
          localTroopMemberItem.h = ChnToSpell.a(localTroopMemberItem.g, 2);
          localTroopMemberItem.i = ChnToSpell.a(localTroopMemberItem.g, 1);
          label369:
          if (TextUtils.isEmpty(localTroopMemberItem.j)) {
            break label614;
          }
          localTroopMemberItem.k = ChnToSpell.a(localTroopMemberItem.j, 2);
        }
        for (localTroopMemberItem.l = ChnToSpell.a(localTroopMemberItem.j, 1);; localTroopMemberItem.l = "")
        {
          if (TextUtils.isEmpty(localTroopMemberItem.m)) {
            break label631;
          }
          localTroopMemberItem.n = ChnToSpell.a(localTroopMemberItem.m, 2);
          localTroopMemberItem.o = ChnToSpell.a(localTroopMemberItem.m, 1);
          break;
          localObject = localFriendsManager.e(localTroopMemberItem.a);
          break label110;
          label464:
          localObject = localTroopManager.a(this.jdField_a_of_type_ComTencentMobileqqActivityTroopTransferActivity$TroopMemberListAdapter.jdField_a_of_type_ComTencentMobileqqActivityTroopTransferActivity.a, localTroopMemberItem.a);
          break label163;
          label488:
          localTroopMemberItem.m = ((String)localObject);
          break label270;
          label497:
          if (!TextUtils.isEmpty(localTroopMemberItem.m))
          {
            localTroopMemberItem.b = localTroopMemberItem.m;
            break label291;
          }
          if (!TextUtils.isEmpty(localTroopMemberItem.g))
          {
            localTroopMemberItem.b = localTroopMemberItem.g;
            break label291;
          }
          if (TextUtils.isEmpty(localTroopMemberItem.a)) {
            break label291;
          }
          localTroopMemberItem.b = localTroopMemberItem.a;
          localArrayList.add(localTroopMemberItem.a);
          break label291;
          label580:
          localTroopMemberItem.c = "";
          localTroopMemberItem.d = "";
          break label330;
          label597:
          localTroopMemberItem.h = "";
          localTroopMemberItem.i = "";
          break label369;
          label614:
          localTroopMemberItem.k = "";
        }
        label631:
        localTroopMemberItem.n = "";
        localTroopMemberItem.o = "";
      }
    }
    Object localObject = (TroopMemberInfoHandler)this.jdField_a_of_type_ComTencentMobileqqActivityTroopTransferActivity$TroopMemberListAdapter.jdField_a_of_type_ComTencentMobileqqActivityTroopTransferActivity.app.getBusinessHandler(BusinessHandlerFactory.TROOP_MEMBER_INFO_HANDLER);
    if (QLog.isColorLevel()) {
      QLog.i("Q.troopdisband.transfer", 2, "init list data, size = " + localArrayList.size() + ", frh = " + localObject);
    }
    if ((localArrayList.size() > 0) && (localObject != null)) {
      ((TroopMemberInfoHandler)localObject).a(this.jdField_a_of_type_ComTencentMobileqqActivityTroopTransferActivity$TroopMemberListAdapter.jdField_a_of_type_ComTencentMobileqqActivityTroopTransferActivity.a, this.jdField_a_of_type_ComTencentMobileqqActivityTroopTransferActivity$TroopMemberListAdapter.jdField_a_of_type_ComTencentMobileqqActivityTroopTransferActivity.b, localArrayList);
    }
    try
    {
      if ((this.jdField_a_of_type_ComTencentMobileqqActivityTroopTransferActivity$TroopMemberListAdapter.jdField_a_of_type_ComTencentMobileqqActivityTroopTransferActivity != null) && (!this.jdField_a_of_type_ComTencentMobileqqActivityTroopTransferActivity$TroopMemberListAdapter.jdField_a_of_type_ComTencentMobileqqActivityTroopTransferActivity.isFinishing())) {
        this.jdField_a_of_type_ComTencentMobileqqActivityTroopTransferActivity$TroopMemberListAdapter.jdField_a_of_type_ComTencentMobileqqActivityTroopTransferActivity.runOnUiThread(new TroopTransferActivity.TroopMemberListAdapter.1.1(this));
      }
      return;
    }
    catch (Exception localException)
    {
      while (!QLog.isColorLevel()) {}
      QLog.i("Q.troopdisband.transfer", 2, localException.toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.TroopTransferActivity.TroopMemberListAdapter.1
 * JD-Core Version:    0.7.0.1
 */