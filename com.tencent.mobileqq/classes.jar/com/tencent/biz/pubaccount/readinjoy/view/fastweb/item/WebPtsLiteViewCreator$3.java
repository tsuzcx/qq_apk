package com.tencent.biz.pubaccount.readinjoy.view.fastweb.item;

import com.tencent.pts.core.itemview.PTSItemData;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import qob;
import qoc;
import svg;

public class WebPtsLiteViewCreator$3
  implements Runnable
{
  public WebPtsLiteViewCreator$3(svg paramsvg, PTSItemData paramPTSItemData) {}
  
  public void run()
  {
    if (this.a == null) {
      return;
    }
    if ((svg.a(this.this$0).contains(this.a.getItemID())) && ((QLog.isColorLevel()) || (QLog.isDebugVersion())))
    {
      QLog.i("WebPtsLiteViewCreator", 2, "[reportItemExposure], itemId : " + this.a.getItemID() + " has exposed.");
      return;
    }
    qob.a("0X800A9DD", "", "", "", new qoc().a("page_name", this.a.getPageName()).a("item_id", this.a.getItemID()).a());
    svg.a(this.this$0).add(this.a.getItemID());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.view.fastweb.item.WebPtsLiteViewCreator.3
 * JD-Core Version:    0.7.0.1
 */