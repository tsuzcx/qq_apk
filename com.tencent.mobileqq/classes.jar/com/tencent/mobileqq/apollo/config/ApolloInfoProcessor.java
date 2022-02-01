package com.tencent.mobileqq.apollo.config;

import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.apollo.api.IApolloManagerService;
import com.tencent.mobileqq.apollo.api.impl.ApolloManagerServiceImpl;
import com.tencent.mobileqq.apollo.model.ApolloBaseInfo;
import com.tencent.mobileqq.apollo.persistence.api.IApolloDaoManagerService;
import com.tencent.mobileqq.apollo.persistence.api.impl.ApolloDaoManagerServiceImpl;
import com.tencent.mobileqq.troop.api.config.AbsTroopMemberListHandlerProcessor;
import com.tencent.qphone.base.util.QLog;
import friendlist.stTroopMemberInfo;
import java.util.ArrayList;
import java.util.Iterator;

public class ApolloInfoProcessor
  extends AbsTroopMemberListHandlerProcessor
{
  public void a(@NonNull AppInterface paramAppInterface, String paramString, ArrayList<stTroopMemberInfo> paramArrayList)
  {
    paramString = (ApolloManagerServiceImpl)paramAppInterface.getRuntimeService(IApolloManagerService.class, "all");
    ApolloDaoManagerServiceImpl localApolloDaoManagerServiceImpl = (ApolloDaoManagerServiceImpl)paramAppInterface.getRuntimeService(IApolloDaoManagerService.class, "all");
    ArrayList localArrayList = new ArrayList();
    paramArrayList = paramArrayList.iterator();
    while (paramArrayList.hasNext())
    {
      Object localObject1 = (stTroopMemberInfo)paramArrayList.next();
      if (paramString != null)
      {
        Object localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append(((stTroopMemberInfo)localObject1).MemberUin);
        ((StringBuilder)localObject2).append("");
        localObject2 = localApolloDaoManagerServiceImpl.getApolloBaseInfo(((StringBuilder)localObject2).toString());
        if ((localObject2 != null) && ((((ApolloBaseInfo)localObject2).apolloStatus != ((stTroopMemberInfo)localObject1).cApolloFlag) || (((ApolloBaseInfo)localObject2).apolloServerTS != ((stTroopMemberInfo)localObject1).dwApolloTimestamp)))
        {
          ((ApolloBaseInfo)localObject2).apolloStatus = ((stTroopMemberInfo)localObject1).cApolloFlag;
          ((ApolloBaseInfo)localObject2).apolloServerTS = ((stTroopMemberInfo)localObject1).dwApolloTimestamp;
          localArrayList.add(localObject2);
          if ((QLog.isColorLevel()) && (!TextUtils.isEmpty(((ApolloBaseInfo)localObject2).uin)) && (((ApolloBaseInfo)localObject2).uin.equals(paramAppInterface.getAccount())))
          {
            localObject1 = new StringBuilder();
            ((StringBuilder)localObject1).append("troop handler apollo status: ");
            ((StringBuilder)localObject1).append(((ApolloBaseInfo)localObject2).apolloStatus);
            ((StringBuilder)localObject1).append(", apollo svr ts: ");
            ((StringBuilder)localObject1).append(((ApolloBaseInfo)localObject2).apolloServerTS);
            QLog.d("[cmshow]ApolloInfoProcessor", 2, ((StringBuilder)localObject1).toString());
          }
        }
      }
    }
    localApolloDaoManagerServiceImpl.bulkSaveOrUpdateApolloBaseInfos(localArrayList);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.config.ApolloInfoProcessor
 * JD-Core Version:    0.7.0.1
 */