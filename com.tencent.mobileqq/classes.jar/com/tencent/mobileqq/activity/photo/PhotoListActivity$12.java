package com.tencent.mobileqq.activity.photo;

import cooperation.qzone.report.lp.LpReportInfo_pf00064;
import cooperation.qzone.report.lp.LpReportManager;

class PhotoListActivity$12
  implements Runnable
{
  PhotoListActivity$12(PhotoListActivity paramPhotoListActivity, int paramInt, String paramString) {}
  
  public void run()
  {
    LpReportInfo_pf00064 localLpReportInfo_pf00064 = new LpReportInfo_pf00064(723, 2, this.jdField_a_of_type_Int);
    LpReportManager.getInstance().reportToPF00064(localLpReportInfo_pf00064, false, false);
    PhotoListActivity.a(this.this$0, "aio_sync_qzone", "operation_type", this.jdField_a_of_type_JavaLangString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.photo.PhotoListActivity.12
 * JD-Core Version:    0.7.0.1
 */