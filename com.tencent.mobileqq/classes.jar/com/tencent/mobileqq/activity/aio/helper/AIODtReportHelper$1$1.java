package com.tencent.mobileqq.activity.aio.helper;

import com.tencent.mobileqq.troop.troopcatalog.GroupCatalogBean;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.PageParams;
import com.tencent.qqlive.module.videoreport.VideoReport;
import java.util.HashMap;

class AIODtReportHelper$1$1
  implements Runnable
{
  AIODtReportHelper$1$1(AIODtReportHelper.1 param1, GroupCatalogBean paramGroupCatalogBean) {}
  
  public void run()
  {
    if (this.a == null)
    {
      if (QLog.isColorLevel()) {
        QLog.i("AIODtReportHelper", 1, "fillGroupClassExParams: catalogBean == null");
      }
    }
    else
    {
      HashMap localHashMap = new HashMap();
      if (this.a.a == 1)
      {
        localHashMap.put("group_first_level", String.valueOf(this.a.c));
      }
      else
      {
        if (this.a.e != null) {
          localHashMap.put("group_first_level", String.valueOf(this.a.e.c));
        }
        localHashMap.put("group_second_level", String.valueOf(this.a.c));
      }
      VideoReport.setPageParams(this.b.this$0.d, new PageParams(localHashMap));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.helper.AIODtReportHelper.1.1
 * JD-Core Version:    0.7.0.1
 */