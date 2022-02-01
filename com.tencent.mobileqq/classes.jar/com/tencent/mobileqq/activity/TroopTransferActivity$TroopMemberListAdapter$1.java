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
    int j = this.b.a.size();
    TroopManager localTroopManager = (TroopManager)this.b.c.app.getManager(QQManagerFactory.TROOP_MANAGER);
    FriendsManager localFriendsManager = (FriendsManager)this.b.c.app.getManager(QQManagerFactory.FRIENDS_MANAGER);
    ArrayList localArrayList = new ArrayList();
    int i = 0;
    StringBuilder localStringBuilder;
    while (i < j)
    {
      TroopTransferActivity.TroopMemberItem localTroopMemberItem = (TroopTransferActivity.TroopMemberItem)this.b.a.get(i);
      if (!TextUtils.isEmpty(localTroopMemberItem.c))
      {
        localStringBuilder = null;
        if (localFriendsManager == null) {
          localObject = null;
        } else {
          localObject = localFriendsManager.m(localTroopMemberItem.c);
        }
        if ((localObject != null) && (!TextUtils.isEmpty(((Friends)localObject).name))) {
          localTroopMemberItem.i = ((Friends)localObject).name;
        }
        if ((localObject != null) && (!TextUtils.isEmpty(((Friends)localObject).remark))) {
          localTroopMemberItem.l = ((Friends)localObject).remark;
        }
        if (localTroopManager == null) {
          localObject = localStringBuilder;
        } else {
          localObject = localTroopManager.e(this.b.c.r, localTroopMemberItem.c);
        }
        if ((!TextUtils.isEmpty((CharSequence)localObject)) && (!((String)localObject).equals(localTroopMemberItem.c)))
        {
          localTroopMemberItem.o = ((String)localObject);
        }
        else
        {
          localObject = ((ITroopDBUtilsApi)QRoute.api(ITroopDBUtilsApi.class)).getTroopMemberInfo(this.b.c.app, String.valueOf(this.b.c.r), localTroopMemberItem.c);
          if ((localObject != null) && (!TextUtils.isEmpty(((TroopMemberInfo)localObject).troopColorNick))) {
            localTroopMemberItem.o = ((TroopMemberInfo)localObject).troopColorNick;
          }
          if ((localObject != null) && (!TextUtils.isEmpty(((TroopMemberInfo)localObject).troopremark))) {
            localTroopMemberItem.l = ((TroopMemberInfo)localObject).troopremark;
          }
        }
        if (!TextUtils.isEmpty(localTroopMemberItem.l))
        {
          localTroopMemberItem.d = localTroopMemberItem.l;
        }
        else if (!TextUtils.isEmpty(localTroopMemberItem.o))
        {
          localTroopMemberItem.d = localTroopMemberItem.o;
        }
        else if (!TextUtils.isEmpty(localTroopMemberItem.i))
        {
          localTroopMemberItem.d = localTroopMemberItem.i;
        }
        else if (!TextUtils.isEmpty(localTroopMemberItem.c))
        {
          localTroopMemberItem.d = localTroopMemberItem.c;
          localArrayList.add(localTroopMemberItem.c);
        }
        if (!TextUtils.isEmpty(localTroopMemberItem.d))
        {
          localTroopMemberItem.e = ChnToSpell.b(localTroopMemberItem.d, 2);
          localTroopMemberItem.f = ChnToSpell.b(localTroopMemberItem.d, 1);
        }
        else
        {
          localTroopMemberItem.e = "";
          localTroopMemberItem.f = "";
        }
        if (!TextUtils.isEmpty(localTroopMemberItem.i))
        {
          localTroopMemberItem.j = ChnToSpell.b(localTroopMemberItem.i, 2);
          localTroopMemberItem.k = ChnToSpell.b(localTroopMemberItem.i, 1);
        }
        else
        {
          localTroopMemberItem.j = "";
          localTroopMemberItem.k = "";
        }
        if (!TextUtils.isEmpty(localTroopMemberItem.l))
        {
          localTroopMemberItem.m = ChnToSpell.b(localTroopMemberItem.l, 2);
          localTroopMemberItem.n = ChnToSpell.b(localTroopMemberItem.l, 1);
        }
        else
        {
          localTroopMemberItem.m = "";
          localTroopMemberItem.n = "";
        }
        if (!TextUtils.isEmpty(localTroopMemberItem.o))
        {
          localTroopMemberItem.p = ChnToSpell.b(localTroopMemberItem.o, 2);
          localTroopMemberItem.q = ChnToSpell.b(localTroopMemberItem.o, 1);
        }
        else
        {
          localTroopMemberItem.p = "";
          localTroopMemberItem.q = "";
        }
      }
      i += 1;
    }
    Object localObject = (ITroopMemberCardHandler)this.b.c.app.getBusinessHandler(BusinessHandlerFactory.TROOP_MEMBER_CARD_HANDLER);
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
      ((ITroopMemberCardHandler)localObject).a(this.b.c.r, this.b.c.s, localArrayList);
    }
    try
    {
      if ((this.b.c != null) && (!this.b.c.isFinishing()))
      {
        this.b.c.runOnUiThread(new TroopTransferActivity.TroopMemberListAdapter.1.1(this));
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.TroopTransferActivity.TroopMemberListAdapter.1
 * JD-Core Version:    0.7.0.1
 */