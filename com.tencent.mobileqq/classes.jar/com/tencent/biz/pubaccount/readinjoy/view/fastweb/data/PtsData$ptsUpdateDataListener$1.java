package com.tencent.biz.pubaccount.readinjoy.view.fastweb.data;

import com.tencent.pts.core.PTSComposer.IPTSUpdateDataListener;
import com.tencent.pts.core.itemview.PTSItemData;
import com.tencent.pts.core.itemview.PTSItemData.Builder;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "jsonData", "", "kotlin.jvm.PlatformType", "onDataUpdated"}, k=3, mv={1, 1, 16})
final class PtsData$ptsUpdateDataListener$1
  implements PTSComposer.IPTSUpdateDataListener
{
  PtsData$ptsUpdateDataListener$1(PtsData paramPtsData) {}
  
  public final void onDataUpdated(String paramString)
  {
    QLog.i("PtsData", 1, "[onDataUpdated] jsonData = " + paramString);
    PTSItemData localPTSItemData = this.a.a();
    if (localPTSItemData != null)
    {
      paramString = new PTSItemData.Builder().withPageName(localPTSItemData.getPageName()).withItemID(localPTSItemData.getItemID()).withFrameTreeJson(localPTSItemData.getFrameTreeJson()).withJsonData(paramString).build();
      this.a.a(paramString);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.view.fastweb.data.PtsData.ptsUpdateDataListener.1
 * JD-Core Version:    0.7.0.1
 */