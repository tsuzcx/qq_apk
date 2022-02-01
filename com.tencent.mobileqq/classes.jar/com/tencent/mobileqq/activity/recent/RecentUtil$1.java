package com.tencent.mobileqq.activity.recent;

import com.tencent.biz.pubaccount.troopbarassit.TroopBarAssistantManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.statistics.ReportController;
import java.util.List;

final class RecentUtil$1
  implements Runnable
{
  RecentUtil$1(QQAppInterface paramQQAppInterface, int paramInt) {}
  
  public void run()
  {
    int i = TroopBarAssistantManager.a().h(this.a).size();
    QQAppInterface localQQAppInterface = this.a;
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("");
    ((StringBuilder)localObject).append(this.b);
    localObject = ((StringBuilder)localObject).toString();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("");
    localStringBuilder.append(i);
    ReportController.b(localQQAppInterface, "dc00899", "Pb_account_lifeservice", "0", "0X80064CB", "0X80064CB", 0, 0, (String)localObject, localStringBuilder.toString(), "", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.recent.RecentUtil.1
 * JD-Core Version:    0.7.0.1
 */