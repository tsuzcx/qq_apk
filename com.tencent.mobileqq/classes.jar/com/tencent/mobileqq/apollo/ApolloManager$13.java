package com.tencent.mobileqq.apollo;

import akji;
import aleh;
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
      Object localObject = (aleh)this.a.getManager(155);
      akji localakji = (akji)this.a.getManager(153);
      List localList = ((aleh)localObject).a();
      SharedPreferences localSharedPreferences = this.a.getApplication().getSharedPreferences("apollo_sp", 0);
      boolean bool = localSharedPreferences.getBoolean("8.3.3" + this.a.getCurrentAccountUin(), false);
      int i = localSharedPreferences.getInt("apollo_json_version" + this.a.getCurrentAccountUin(), 0);
      int j = localSharedPreferences.getInt("apollo_json_version", 0);
      if ((localList == null) || (localList.size() == 0) || (!bool) || (i != j))
      {
        localakji.b();
        QLog.d("ApolloManager", 1, "[checkJsonParse] parse action json");
      }
      localObject = ((aleh)localObject).f();
      if ((localObject == null) || (((List)localObject).size() == 0))
      {
        ApolloGameUtil.a((QQAppInterface)this.a, 0L);
        QLog.d("ApolloManager", 1, "game list is null, set game request ts 0");
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.ApolloManager.13
 * JD-Core Version:    0.7.0.1
 */