package com.tencent.mobileqq.activity.troop.config;

import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.apollo.api.IApolloManagerService;
import com.tencent.mobileqq.apollo.api.impl.ApolloManagerServiceImpl;
import com.tencent.mobileqq.apollo.api.model.ApolloBaseInfo;
import com.tencent.mobileqq.troop.api.config.AbsTroopHandlerProcessor;
import com.tencent.mobileqq.troop.api.config.IApolloInfoObserver;
import com.tencent.qphone.base.util.QLog;
import friendlist.stTroopMemberInfo;
import java.util.ArrayList;
import java.util.Iterator;

public class ApolloInfoProcessor
  extends AbsTroopHandlerProcessor
  implements IApolloInfoObserver
{
  @NonNull
  public String a()
  {
    return "ApolloInfoProcessor";
  }
  
  public void a(@NonNull AppInterface paramAppInterface, ArrayList<stTroopMemberInfo> paramArrayList)
  {
    ApolloManagerServiceImpl localApolloManagerServiceImpl = (ApolloManagerServiceImpl)paramAppInterface.getRuntimeService(IApolloManagerService.class, "all");
    ArrayList localArrayList = new ArrayList();
    paramArrayList = paramArrayList.iterator();
    while (paramArrayList.hasNext())
    {
      stTroopMemberInfo localstTroopMemberInfo = (stTroopMemberInfo)paramArrayList.next();
      if (localApolloManagerServiceImpl != null)
      {
        ApolloBaseInfo localApolloBaseInfo = localApolloManagerServiceImpl.getApolloBaseInfo(localstTroopMemberInfo.MemberUin + "");
        if ((localApolloBaseInfo != null) && ((localApolloBaseInfo.apolloStatus != localstTroopMemberInfo.cApolloFlag) || (localApolloBaseInfo.apolloServerTS != localstTroopMemberInfo.dwApolloTimestamp)))
        {
          localApolloBaseInfo.apolloStatus = localstTroopMemberInfo.cApolloFlag;
          localApolloBaseInfo.apolloServerTS = localstTroopMemberInfo.dwApolloTimestamp;
          localArrayList.add(localApolloBaseInfo);
          if ((QLog.isColorLevel()) && (!TextUtils.isEmpty(localApolloBaseInfo.uin)) && (localApolloBaseInfo.uin.equals(paramAppInterface.getAccount()))) {
            QLog.d(this.a, 2, "troop handler apollo status: " + localApolloBaseInfo.apolloStatus + ", apollo svr ts: " + localApolloBaseInfo.apolloServerTS);
          }
        }
      }
    }
    if (localApolloManagerServiceImpl != null) {
      localApolloManagerServiceImpl.bulkSaveOrUpdateApolloBaseInfos(localArrayList);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.troop.config.ApolloInfoProcessor
 * JD-Core Version:    0.7.0.1
 */