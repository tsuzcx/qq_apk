package com.tencent.mobileqq.apollo.api.uitls.impl;

import android.content.SharedPreferences;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.apollo.api.IApolloManagerService;
import com.tencent.mobileqq.apollo.api.data.IApolloDaoManagerService;
import com.tencent.mobileqq.apollo.api.data.impl.ApolloDaoManagerServiceImpl;
import com.tencent.mobileqq.apollo.api.impl.ApolloManagerServiceImpl;
import com.tencent.mobileqq.apollo.utils.ApolloGameUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import mqq.app.MobileQQ;

final class ApolloUtilImpl$11
  implements Runnable
{
  ApolloUtilImpl$11(AppInterface paramAppInterface) {}
  
  public void run()
  {
    if (this.a != null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ApolloUtil", 2, "[checkJsonParse]");
      }
      Object localObject = (ApolloDaoManagerServiceImpl)this.a.getRuntimeService(IApolloDaoManagerService.class, "all");
      ApolloManagerServiceImpl localApolloManagerServiceImpl = (ApolloManagerServiceImpl)this.a.getRuntimeService(IApolloManagerService.class, "all");
      List localList = ((ApolloDaoManagerServiceImpl)localObject).getActionList();
      SharedPreferences localSharedPreferences = this.a.getApplication().getSharedPreferences("apollo_sp", 0);
      boolean bool = localSharedPreferences.getBoolean("8.5.5" + this.a.getCurrentAccountUin(), false);
      int i = localSharedPreferences.getInt("apollo_json_version" + this.a.getCurrentAccountUin(), 0);
      int j = localSharedPreferences.getInt("apollo_json_version", 0);
      if ((localList == null) || (localList.size() == 0) || (!bool) || (i != j))
      {
        localApolloManagerServiceImpl.parseActionPanelJSon();
        QLog.d("ApolloUtil", 1, "[checkJsonParse] parse action json");
      }
      localObject = ((ApolloDaoManagerServiceImpl)localObject).getGameList();
      if ((localObject == null) || (((List)localObject).size() == 0))
      {
        ApolloGameUtil.a((QQAppInterface)this.a, 0L);
        QLog.d("ApolloUtil", 1, "game list is null, set game request ts 0");
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.api.uitls.impl.ApolloUtilImpl.11
 * JD-Core Version:    0.7.0.1
 */