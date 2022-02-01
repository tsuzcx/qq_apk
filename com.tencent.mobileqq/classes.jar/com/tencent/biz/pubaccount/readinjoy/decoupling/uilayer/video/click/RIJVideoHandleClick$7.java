package com.tencent.biz.pubaccount.readinjoy.decoupling.uilayer.video.click;

import android.view.View;
import com.tencent.biz.pubaccount.readinjoy.decoupling.accesslayer.data.RIJDataManager;
import com.tencent.biz.pubaccount.readinjoy.decoupling.accesslayer.data.RIJDataManager.Builder;
import com.tencent.biz.pubaccount.readinjoy.decoupling.uilayer.framewrok.ClickHandler;
import com.tencent.biz.pubaccount.readinjoy.decoupling.uilayer.video.report.RIJVideoReportManager;
import com.tencent.biz.pubaccount.readinjoy.handlers.VideoHandler;
import com.tencent.biz.pubaccount.readinjoy.struct.BaseArticleInfo;

class RIJVideoHandleClick$7
  implements ClickHandler
{
  RIJVideoHandleClick$7(RIJVideoHandleClick paramRIJVideoHandleClick) {}
  
  public void onClick(View paramView)
  {
    BaseArticleInfo localBaseArticleInfo = (BaseArticleInfo)paramView.getTag();
    if (localBaseArticleInfo == null) {
      return;
    }
    RIJVideoReportManager.a(localBaseArticleInfo, RIJVideoHandleClick.a(this.a).a().a(), RIJVideoHandleClick.a(this.a).a().b());
    VideoHandler.a(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.decoupling.uilayer.video.click.RIJVideoHandleClick.7
 * JD-Core Version:    0.7.0.1
 */