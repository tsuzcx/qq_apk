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
    if (this.jdField_a_of_type_ComTencentMobileqqTroopTroopcatalogGroupCatalogBean == null)
    {
      if (QLog.isColorLevel()) {
        QLog.i("AIODtReportHelper", 1, "fillGroupClassExParams: catalogBean == null");
      }
    }
    else
    {
      HashMap localHashMap = new HashMap();
      if (this.jdField_a_of_type_ComTencentMobileqqTroopTroopcatalogGroupCatalogBean.jdField_a_of_type_Int == 1)
      {
        localHashMap.put("group_first_level", String.valueOf(this.jdField_a_of_type_ComTencentMobileqqTroopTroopcatalogGroupCatalogBean.b));
      }
      else
      {
        if (this.jdField_a_of_type_ComTencentMobileqqTroopTroopcatalogGroupCatalogBean.jdField_a_of_type_ComTencentMobileqqTroopTroopcatalogGroupCatalogBean != null) {
          localHashMap.put("group_first_level", String.valueOf(this.jdField_a_of_type_ComTencentMobileqqTroopTroopcatalogGroupCatalogBean.jdField_a_of_type_ComTencentMobileqqTroopTroopcatalogGroupCatalogBean.b));
        }
        localHashMap.put("group_second_level", String.valueOf(this.jdField_a_of_type_ComTencentMobileqqTroopTroopcatalogGroupCatalogBean.b));
      }
      VideoReport.setPageParams(AIODtReportHelper.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioHelperAIODtReportHelper$1.this$0), new PageParams(localHashMap));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.helper.AIODtReportHelper.1.1
 * JD-Core Version:    0.7.0.1
 */