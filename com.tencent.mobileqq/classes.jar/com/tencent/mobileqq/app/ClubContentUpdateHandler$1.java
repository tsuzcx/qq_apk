package com.tencent.mobileqq.app;

import com.tencent.mobileqq.apollo.res.api.IApolloResManager;
import com.tencent.mobileqq.apollo.utils.api.IApolloUtil;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;

class ClubContentUpdateHandler$1
  implements Runnable
{
  ClubContentUpdateHandler$1(ClubContentUpdateHandler paramClubContentUpdateHandler, int paramInt, String paramString) {}
  
  public void run()
  {
    try
    {
      Object localObject = (IApolloResManager)this.this$0.a.getRuntimeService(IApolloResManager.class, "all");
      int i = ((IApolloUtil)QRoute.api(IApolloUtil.class)).getApolloPanelJsonVer(1);
      if (i != this.jdField_a_of_type_Int) {
        ((IApolloResManager)localObject).downloadJson(1);
      }
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("handleApolloPanelRelTimeUpdate name: ");
      ((StringBuilder)localObject).append(this.jdField_a_of_type_JavaLangString);
      ((StringBuilder)localObject).append(", ver: ");
      ((StringBuilder)localObject).append(this.jdField_a_of_type_Int);
      ((StringBuilder)localObject).append(", locver: ");
      ((StringBuilder)localObject).append(i);
      QLog.i("ClubContentUpdateHandler", 1, ((StringBuilder)localObject).toString());
      return;
    }
    catch (Exception localException)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("handleApolloPanelRealTimeUpdate failed");
      localStringBuilder.append(localException);
      QLog.e("ClubContentUpdateHandler", 1, localStringBuilder.toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.app.ClubContentUpdateHandler.1
 * JD-Core Version:    0.7.0.1
 */