package com.tencent.biz.pubaccount.readinjoy.view.fastweb.item;

import com.tencent.pts.core.itemview.PTSItemData;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import pwx;
import pwy;
import sbx;

public class WebPtsLiteViewCreator$3
  implements Runnable
{
  public WebPtsLiteViewCreator$3(sbx paramsbx, PTSItemData paramPTSItemData) {}
  
  public void run()
  {
    if (this.a == null) {
      return;
    }
    if ((sbx.a(this.this$0).contains(this.a.getItemID())) && ((QLog.isColorLevel()) || (QLog.isDebugVersion())))
    {
      QLog.i("WebPtsLiteViewCreator", 2, "[reportItemExposure], itemId : " + this.a.getItemID() + " has exposed.");
      return;
    }
    pwx.a("0X800A9DD", "", "", "", new pwy().a("app_name", this.a.getAppName()).a("item_id", this.a.getItemID()).a());
    sbx.a(this.this$0).add(this.a.getItemID());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.view.fastweb.item.WebPtsLiteViewCreator.3
 * JD-Core Version:    0.7.0.1
 */