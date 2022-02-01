package com.tencent.biz.pubaccount.readinjoy.pts.lite;

import com.tencent.pts.core.itemview.PTSItemData;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import qmh;
import qob;
import qoc;

public class PTSLiteItemViewBuilder$2
  implements Runnable
{
  public PTSLiteItemViewBuilder$2(qmh paramqmh, PTSItemData paramPTSItemData) {}
  
  public void run()
  {
    if (this.a == null) {
      return;
    }
    if ((qmh.a(this.this$0).contains(this.a.getItemID())) && ((QLog.isColorLevel()) || (QLog.isDebugVersion())))
    {
      QLog.i("PTSLiteItemViewBuilder", 2, "[reportItemExposure], itemId : " + this.a.getItemID() + " has exposed.");
      return;
    }
    qob.a("0X800A9DD", "", "", "", new qoc().a("page_name", this.a.getPageName()).a("item_id", this.a.getItemID()).a());
    qmh.a(this.this$0).add(this.a.getItemID());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.pts.lite.PTSLiteItemViewBuilder.2
 * JD-Core Version:    0.7.0.1
 */