package com.tencent.biz.pubaccount.readinjoy.struct;

import com.tencent.biz.pubaccount.readinjoy.decoupling.accesslayer.util.RIJQQAppInterfaceUtil;
import com.tencent.biz.pubaccount.readinjoy.engine.ReadInJoyLogicEngine;
import com.tencent.biz.pubaccount.readinjoy.engine.ReadInJoyLogicManager;
import com.tencent.biz.pubaccount.readinjoy.pts.util.PTSParcelableUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.pts.core.PTSComposer.IPTSUpdateDataListener;
import com.tencent.pts.core.itemview.PTSItemData;
import com.tencent.pts.core.itemview.PTSItemData.Builder;
import com.tencent.qphone.base.util.QLog;

class BaseArticleInfo$1
  implements PTSComposer.IPTSUpdateDataListener
{
  BaseArticleInfo$1(BaseArticleInfo paramBaseArticleInfo) {}
  
  public void onDataUpdated(String paramString)
  {
    QLog.i("Q.readinjoy.BaseArticleInfo", 1, "[onDataUpdated] jsonData = " + paramString);
    PTSItemData localPTSItemData = this.a.ptsItemData;
    if (localPTSItemData != null)
    {
      this.a.ptsItemData = new PTSItemData.Builder().withPageName(localPTSItemData.getPageName()).withItemID(localPTSItemData.getItemID()).withJsonData(paramString).withFrameTreeJson(localPTSItemData.getFrameTreeJson()).build();
      this.a.ptsItemDataBytes = PTSParcelableUtil.a(this.a.ptsItemData);
      paramString = RIJQQAppInterfaceUtil.a();
      if (paramString != null)
      {
        paramString = (ReadInJoyLogicManager)paramString.getManager(QQManagerFactory.READINJOY_LOGIC_MANAGER);
        if ((paramString != null) && ((this.a instanceof ArticleInfo))) {
          paramString.a().b((ArticleInfo)this.a);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.struct.BaseArticleInfo.1
 * JD-Core Version:    0.7.0.1
 */