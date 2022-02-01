package com.tencent.mobileqq.activity;

import com.tencent.biz.helper.TroopInfoActivityHelper.ISetSameCityCheckTypeInfo;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.troopinfo.TroopInfoData;

class TroopInfoActivity$13
  implements TroopInfoActivityHelper.ISetSameCityCheckTypeInfo
{
  TroopInfoActivity$13(TroopInfoActivity paramTroopInfoActivity) {}
  
  public void a()
  {
    if (this.a.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo != null) {
      this.a.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo.troopTypeExt = 4;
    }
    ReportController.b(this.a.app, "P_CliOper", "Grp_create", "", "edit_data", "local_suc", 0, 0, this.a.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin, this.a.b, "", "");
    TroopInfoActivity.a(this.a, true, 0L, "", this.a.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.dwGroupClassExt, this.a.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.dwGroupClassExt);
  }
  
  public void a(String paramString)
  {
    this.a.l();
    TroopInfoActivity.a(this.a, false, 0L, paramString, this.a.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.dwGroupClassExt, this.a.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.dwGroupClassExt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.TroopInfoActivity.13
 * JD-Core Version:    0.7.0.1
 */