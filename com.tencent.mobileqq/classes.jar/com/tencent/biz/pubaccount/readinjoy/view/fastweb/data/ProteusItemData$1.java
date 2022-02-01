package com.tencent.biz.pubaccount.readinjoy.view.fastweb.data;

import com.tencent.pts.core.PTSComposer.IPTSUpdateDataListener;
import com.tencent.pts.core.itemview.PTSItemData;
import com.tencent.pts.core.itemview.PTSItemData.Builder;
import com.tencent.qphone.base.util.QLog;

class ProteusItemData$1
  implements PTSComposer.IPTSUpdateDataListener
{
  ProteusItemData$1(ProteusItemData paramProteusItemData) {}
  
  public void onDataUpdated(String paramString)
  {
    QLog.i("ProteusItemData", 1, "[onDataUpdated], jsonData = " + paramString);
    PTSItemData localPTSItemData = this.a.a;
    if (localPTSItemData != null) {
      this.a.a = new PTSItemData.Builder().withPageName(localPTSItemData.getPageName()).withItemID(localPTSItemData.getItemID()).withJsonData(paramString).withFrameTreeJson(localPTSItemData.getFrameTreeJson()).build();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.view.fastweb.data.ProteusItemData.1
 * JD-Core Version:    0.7.0.1
 */