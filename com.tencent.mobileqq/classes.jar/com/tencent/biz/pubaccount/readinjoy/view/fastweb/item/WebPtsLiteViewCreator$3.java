package com.tencent.biz.pubaccount.readinjoy.view.fastweb.item;

import com.tencent.biz.pubaccount.readinjoy.pts.util.PTSReport;
import com.tencent.biz.pubaccount.readinjoy.pts.util.PTSReport.R5Builder;
import com.tencent.pts.core.itemview.PTSItemData;
import com.tencent.qphone.base.util.QLog;
import java.util.List;

class WebPtsLiteViewCreator$3
  implements Runnable
{
  WebPtsLiteViewCreator$3(WebPtsLiteViewCreator paramWebPtsLiteViewCreator, PTSItemData paramPTSItemData) {}
  
  public void run()
  {
    if (this.a == null) {
      return;
    }
    if ((WebPtsLiteViewCreator.a(this.this$0).contains(this.a.getItemID())) && ((QLog.isColorLevel()) || (QLog.isDebugVersion())))
    {
      QLog.i("WebPtsLiteViewCreator", 2, "[reportItemExposure], itemId : " + this.a.getItemID() + " has exposed.");
      return;
    }
    PTSReport.a("0X800A9DD", "", "", "", new PTSReport.R5Builder().a("page_name", this.a.getPageName()).a("item_id", this.a.getItemID()).a());
    WebPtsLiteViewCreator.a(this.this$0).add(this.a.getItemID());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.view.fastweb.item.WebPtsLiteViewCreator.3
 * JD-Core Version:    0.7.0.1
 */