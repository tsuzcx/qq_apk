package com.tencent.mobileqq.activity.selectmember;

import android.content.Intent;
import android.text.TextUtils;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.data.troop.TroopMemberInfo;
import com.tencent.mobileqq.troop.api.observer.TroopObserver;
import com.tencent.mobileqq.troop.utils.TroopRobotManager;
import com.tencent.qidian.QidianManager;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

class FriendTeamListInnerFrame$5
  extends TroopObserver
{
  FriendTeamListInnerFrame$5(FriendTeamListInnerFrame paramFriendTeamListInnerFrame) {}
  
  public void onUpdateTroopGetMemberList(String paramString, boolean paramBoolean, List<TroopMemberInfo> paramList, int paramInt1, long paramLong, int paramInt2)
  {
    Object localObject1 = this.a.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity.getIntent().getStringExtra("group_uin");
    Object localObject2 = new StringBuilder().append("onUpdateTroopGetMemberList, troopUin[").append(paramString).append("], ftroopUin[").append((String)localObject1).append("], troopMemberInfoList[");
    if (paramList != null) {}
    for (paramInt1 = paramList.size();; paramInt1 = -1)
    {
      QLog.w("FriendTeamListInnerFrameNew", 1, paramInt1 + "]");
      if ((TextUtils.isEmpty((CharSequence)localObject1)) || (((String)localObject1).equals(paramString))) {
        break;
      }
      return;
    }
    paramString = this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin();
    localObject1 = new ArrayList();
    localObject2 = (TroopRobotManager)this.a.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity.app.getManager(QQManagerFactory.TROOP_ROBOT_MANAGER);
    QidianManager localQidianManager = (QidianManager)this.a.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity.app.getManager(QQManagerFactory.QIDIAN_MANAGER);
    Object localObject3 = (FriendsManager)this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.FRIENDS_MANAGER);
    if (paramList != null)
    {
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        localObject3 = (TroopMemberInfo)paramList.next();
        if (localObject3 != null)
        {
          if (QLog.isDevelopLevel()) {
            QLog.w("FriendTeamListInnerFrameNew", 1, "onUpdateTroopGetMemberList, memberuin[" + ((TroopMemberInfo)localObject3).memberuin + "]");
          }
          if (!TextUtils.equals(((TroopMemberInfo)localObject3).memberuin, paramString)) {
            if ((((TroopRobotManager)localObject2).b(((TroopMemberInfo)localObject3).memberuin)) || (localQidianManager.f(((TroopMemberInfo)localObject3).memberuin)))
            {
              if (QLog.isDevelopLevel()) {
                QLog.w("FriendTeamListInnerFrameNew", 1, "onUpdateTroopGetMemberList, isRobotUin");
              }
            }
            else {
              ((ArrayList)localObject1).add(localObject3);
            }
          }
        }
      }
    }
    this.a.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity.b((ArrayList)localObject1);
    FriendTeamListInnerFrame.a(this.a).a((ArrayList)localObject1);
    FriendTeamListInnerFrame.a(this.a).notifyDataSetChanged();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.selectmember.FriendTeamListInnerFrame.5
 * JD-Core Version:    0.7.0.1
 */