package com.tencent.biz.pubaccount.readinjoy.dynamicfeeds.compat;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.pubaccount.readinjoy.decoupling.uilayer.framewrok.report.RIJFrameworkReportManager;
import com.tencent.biz.pubaccount.readinjoy.engine.ReadInJoyLogicEngine;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.pull2refresh.RecyclerViewWithHeaderFooter;

class ReadInJoyDynamicChannelAdapter$1
  implements View.OnClickListener
{
  ReadInJoyDynamicChannelAdapter$1(ReadInJoyDynamicChannelAdapter paramReadInJoyDynamicChannelAdapter) {}
  
  public void onClick(View paramView)
  {
    int i = ((ReadInJoyDynamicChannelAdapter.CustomViewHolder)paramView.getTag()).getAdapterPosition() - ReadInJoyDynamicChannelAdapter.a(this.a).c();
    int j = this.a.getItemViewType(i);
    ArticleInfo localArticleInfo = (ArticleInfo)ReadInJoyDynamicChannelAdapter.a(this.a, i);
    if (localArticleInfo == null) {
      QLog.d("ReadInJoyDynamicChannelAdapter", 1, "onItemClick onClick articleInfo is null.");
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      QLog.d("ReadInJoyDynamicChannelAdapter", 2, new Object[] { "onItemClick, position = ", Integer.valueOf(i), ", itemViewType = ", Integer.valueOf(j) });
      this.a.a(i, paramView);
      localArticleInfo.invalidateProteusTemplateBean();
      com.tencent.biz.pubaccount.readinjoy.decoupling.uilayer.framewrok.util.RIJJumpUtils.a = localArticleInfo;
      ReadInJoyLogicEngine.a().a(localArticleInfo.mArticleID, System.currentTimeMillis());
      this.a.notifyItemChanged(i);
      RIJFrameworkReportManager.a(ReadInJoyDynamicChannelAdapter.a(this.a), localArticleInfo, (int)localArticleInfo.mChannelID);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.dynamicfeeds.compat.ReadInJoyDynamicChannelAdapter.1
 * JD-Core Version:    0.7.0.1
 */