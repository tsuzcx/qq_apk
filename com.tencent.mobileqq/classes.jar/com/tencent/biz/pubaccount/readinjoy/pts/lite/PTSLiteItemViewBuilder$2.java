package com.tencent.biz.pubaccount.readinjoy.pts.lite;

import com.tencent.biz.pubaccount.readinjoy.pts.util.PTSReport;
import com.tencent.biz.pubaccount.readinjoy.pts.util.PTSReport.R5Builder;
import com.tencent.pts.core.itemview.PTSItemData;
import com.tencent.qphone.base.util.QLog;
import java.util.List;

class PTSLiteItemViewBuilder$2
  implements Runnable
{
  PTSLiteItemViewBuilder$2(PTSLiteItemViewBuilder paramPTSLiteItemViewBuilder, PTSItemData paramPTSItemData) {}
  
  public void run()
  {
    if (this.a == null) {
      return;
    }
    if ((PTSLiteItemViewBuilder.a(this.this$0).contains(this.a.getItemID())) && ((QLog.isColorLevel()) || (QLog.isDebugVersion())))
    {
      QLog.i("PTSLiteItemViewBuilder", 2, "[reportItemExposure], itemId : " + this.a.getItemID() + " has exposed.");
      return;
    }
    PTSReport.a("0X800A9DD", "", "", "", new PTSReport.R5Builder().a("page_name", this.a.getPageName()).a("item_id", this.a.getItemID()).a());
    PTSLiteItemViewBuilder.a(this.this$0).add(this.a.getItemID());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.pts.lite.PTSLiteItemViewBuilder.2
 * JD-Core Version:    0.7.0.1
 */