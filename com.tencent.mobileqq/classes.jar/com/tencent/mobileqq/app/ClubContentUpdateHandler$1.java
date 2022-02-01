package com.tencent.mobileqq.app;

import com.tencent.mobileqq.apollo.api.IApolloManagerService;
import com.tencent.mobileqq.apollo.api.uitls.IApolloUtil;
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
      IApolloManagerService localIApolloManagerService = (IApolloManagerService)this.this$0.a.getRuntimeService(IApolloManagerService.class, "all");
      int i = ((IApolloUtil)QRoute.api(IApolloUtil.class)).getApolloPanelJsonVer(1);
      if (i != this.jdField_a_of_type_Int) {
        localIApolloManagerService.downloadJson(1);
      }
      QLog.i("ClubContentUpdateHandler", 1, "handleApolloPanelRelTimeUpdate name: " + this.jdField_a_of_type_JavaLangString + ", ver: " + this.jdField_a_of_type_Int + ", locver: " + i);
      return;
    }
    catch (Exception localException)
    {
      QLog.e("ClubContentUpdateHandler", 1, "handleApolloPanelRealTimeUpdate failed" + localException);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.app.ClubContentUpdateHandler.1
 * JD-Core Version:    0.7.0.1
 */