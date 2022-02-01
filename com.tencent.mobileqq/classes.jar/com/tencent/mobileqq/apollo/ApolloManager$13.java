package com.tencent.mobileqq.apollo;

import alnr;
import amir;
import android.content.SharedPreferences;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.apollo.utils.ApolloGameUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import mqq.app.MobileQQ;

public final class ApolloManager$13
  implements Runnable
{
  public ApolloManager$13(AppInterface paramAppInterface) {}
  
  public void run()
  {
    if (this.a != null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ApolloManager", 2, "[checkJsonParse]");
      }
      Object localObject = (amir)this.a.getManager(155);
      alnr localalnr = (alnr)this.a.getManager(153);
      List localList = ((amir)localObject).a();
      SharedPreferences localSharedPreferences = this.a.getApplication().getSharedPreferences("apollo_sp", 0);
      boolean bool = localSharedPreferences.getBoolean("8.4.8" + this.a.getCurrentAccountUin(), false);
      int i = localSharedPreferences.getInt("apollo_json_version" + this.a.getCurrentAccountUin(), 0);
      int j = localSharedPreferences.getInt("apollo_json_version", 0);
      if ((localList == null) || (localList.size() == 0) || (!bool) || (i != j))
      {
        localalnr.b();
        QLog.d("ApolloManager", 1, "[checkJsonParse] parse action json");
      }
      localObject = ((amir)localObject).h();
      if ((localObject == null) || (((List)localObject).size() == 0))
      {
        ApolloGameUtil.a((QQAppInterface)this.a, 0L);
        QLog.d("ApolloManager", 1, "game list is null, set game request ts 0");
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.ApolloManager.13
 * JD-Core Version:    0.7.0.1
 */