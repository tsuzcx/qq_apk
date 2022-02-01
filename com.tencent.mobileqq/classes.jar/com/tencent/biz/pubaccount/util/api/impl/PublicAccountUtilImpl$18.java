package com.tencent.biz.pubaccount.util.api.impl;

import com.tencent.biz.pubaccount.serviceAccountFolder.ServiceAccountFolderManager;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.statistics.ReportController;
import mqq.app.AppRuntime;

class PublicAccountUtilImpl$18
  implements Runnable
{
  PublicAccountUtilImpl$18(PublicAccountUtilImpl paramPublicAccountUtilImpl, AppInterface paramAppInterface, int paramInt) {}
  
  public void run()
  {
    Object localObject1 = ServiceAccountFolderManager.a();
    int i = ((ServiceAccountFolderManager)localObject1).h();
    int j = ((ServiceAccountFolderManager)localObject1).g((QQAppInterface)this.a);
    String str;
    if (j == 1) {
      str = "0X80067E8";
    } else if (j == 2) {
      str = "0X80067E9";
    } else {
      str = "0X80067EA";
    }
    long l = ((ServiceAccountFolderManager)localObject1).d();
    localObject1 = this.a;
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("");
    ((StringBuilder)localObject2).append(l);
    localObject2 = ((StringBuilder)localObject2).toString();
    Object localObject3 = new StringBuilder();
    ((StringBuilder)localObject3).append("");
    ((StringBuilder)localObject3).append(j);
    localObject3 = ((StringBuilder)localObject3).toString();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("");
    localStringBuilder.append(i);
    ReportController.b((AppRuntime)localObject1, "dc01160", "Pb_account_lifeservice", "", str, str, 0, 0, (String)localObject2, (String)localObject3, localStringBuilder.toString(), String.valueOf(this.b + 1));
    ReportController.b(this.a, "dc00898", "", "", "auth_entry", "clk_msg", 0, 0, "", "", "", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.biz.pubaccount.util.api.impl.PublicAccountUtilImpl.18
 * JD-Core Version:    0.7.0.1
 */