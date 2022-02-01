package com.tencent.mobileqq.activity.aio.helper;

import com.tencent.mobileqq.troopinfo.GroupCatalogBean;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.PageParams;
import com.tencent.qqlive.module.videoreport.VideoReport;
import java.util.HashMap;

class AIODtReportHelper$2$1
  implements Runnable
{
  AIODtReportHelper$2$1(AIODtReportHelper.2 param2, GroupCatalogBean paramGroupCatalogBean) {}
  
  public void run()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqTroopinfoGroupCatalogBean == null) {
      if (QLog.isColorLevel()) {
        QLog.i("AIODtReportHelper", 1, "fillGroupClassExParams: catalogBean == null");
      }
    }
    label153:
    for (;;)
    {
      AIODtReportHelper.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioHelperAIODtReportHelper$2.this$0);
      return;
      HashMap localHashMap = new HashMap();
      if (this.jdField_a_of_type_ComTencentMobileqqTroopinfoGroupCatalogBean.jdField_a_of_type_Int == 1) {
        localHashMap.put("group_first_level", String.valueOf(this.jdField_a_of_type_ComTencentMobileqqTroopinfoGroupCatalogBean.b));
      }
      for (;;)
      {
        if (AIODtReportHelper.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioHelperAIODtReportHelper$2.this$0) == null) {
          break label153;
        }
        VideoReport.setPageParams(AIODtReportHelper.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioHelperAIODtReportHelper$2.this$0), new PageParams(localHashMap));
        break;
        if (this.jdField_a_of_type_ComTencentMobileqqTroopinfoGroupCatalogBean.jdField_a_of_type_ComTencentMobileqqTroopinfoGroupCatalogBean != null) {
          localHashMap.put("group_first_level", String.valueOf(this.jdField_a_of_type_ComTencentMobileqqTroopinfoGroupCatalogBean.jdField_a_of_type_ComTencentMobileqqTroopinfoGroupCatalogBean.b));
        }
        localHashMap.put("group_second_level", String.valueOf(this.jdField_a_of_type_ComTencentMobileqqTroopinfoGroupCatalogBean.b));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.helper.AIODtReportHelper.2.1
 * JD-Core Version:    0.7.0.1
 */