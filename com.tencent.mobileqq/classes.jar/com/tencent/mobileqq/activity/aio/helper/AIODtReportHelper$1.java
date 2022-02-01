package com.tencent.mobileqq.activity.aio.helper;

import com.tencent.mobileqq.data.troop.TroopMemberInfo;
import com.tencent.mobileqq.troop.api.ITroopMemberInfoService.ITroopMemberInfoCallBack;
import com.tencent.qqlive.module.videoreport.VideoReport;

class AIODtReportHelper$1
  implements ITroopMemberInfoService.ITroopMemberInfoCallBack
{
  AIODtReportHelper$1(AIODtReportHelper paramAIODtReportHelper) {}
  
  public void a(TroopMemberInfo paramTroopMemberInfo)
  {
    if (paramTroopMemberInfo == null) {}
    for (int i = 4;; i = 3)
    {
      if (AIODtReportHelper.a(this.a) != null) {
        VideoReport.setPageParams(AIODtReportHelper.a(this.a), "group_uin_type", String.valueOf(i));
      }
      AIODtReportHelper.a(this.a);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.helper.AIODtReportHelper.1
 * JD-Core Version:    0.7.0.1
 */