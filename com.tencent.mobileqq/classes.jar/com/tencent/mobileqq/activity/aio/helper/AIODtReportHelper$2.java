package com.tencent.mobileqq.activity.aio.helper;

import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.troopinfo.GroupCatalogBean;
import mqq.os.MqqHandler;

class AIODtReportHelper$2
  implements Runnable
{
  AIODtReportHelper$2(AIODtReportHelper paramAIODtReportHelper, TroopInfo paramTroopInfo) {}
  
  public void run()
  {
    GroupCatalogBean localGroupCatalogBean = AIODtReportHelper.a(this.this$0, String.valueOf(this.a.dwGroupClassExt));
    ThreadManager.getUIHandler().post(new AIODtReportHelper.2.1(this, localGroupCatalogBean));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.helper.AIODtReportHelper.2
 * JD-Core Version:    0.7.0.1
 */