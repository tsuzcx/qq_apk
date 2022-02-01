package com.tencent.mobileqq.apollo.utils.api.impl;

import android.content.SharedPreferences;
import com.tencent.mobileqq.apollo.persistence.api.IApolloDaoManagerService;
import com.tencent.mobileqq.apollo.persistence.api.impl.ApolloDaoManagerServiceImpl;
import com.tencent.mobileqq.apollo.res.api.IApolloResManager;
import com.tencent.mobileqq.apollo.res.api.impl.ApolloResManagerImpl;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

final class ApolloUtilImpl$10
  implements Runnable
{
  ApolloUtilImpl$10(AppRuntime paramAppRuntime) {}
  
  public void run()
  {
    if (this.a == null) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("[cmshow]ApolloUtil", 2, "[checkJsonParse]");
    }
    List localList = ((ApolloDaoManagerServiceImpl)this.a.getRuntimeService(IApolloDaoManagerService.class, "all")).getActionList();
    SharedPreferences localSharedPreferences = this.a.getApplication().getSharedPreferences("apollo_sp", 0);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("8.7.0");
    localStringBuilder.append(this.a.getCurrentAccountUin());
    boolean bool = localSharedPreferences.getBoolean(localStringBuilder.toString(), false);
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("apollo_json_version");
    localStringBuilder.append(this.a.getCurrentAccountUin());
    int i = localSharedPreferences.getInt(localStringBuilder.toString(), 0);
    int j = localSharedPreferences.getInt("apollo_json_version", 0);
    if ((localList == null) || (localList.size() == 0) || (!bool) || (i != j))
    {
      ((ApolloResManagerImpl)this.a.getRuntimeService(IApolloResManager.class, "all")).parseActionPanelJSon();
      QLog.d("[cmshow]ApolloUtil", 1, "[checkJsonParse] parse action json");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.utils.api.impl.ApolloUtilImpl.10
 * JD-Core Version:    0.7.0.1
 */