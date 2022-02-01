package com.tencent.biz.pubaccount.readinjoy.rebuild.cmp;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.pubaccount.readinjoy.engine.ReadInJoyLogicEngine;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.RecommendFollowInfos;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class ComponentContentRecommend$1
  implements View.OnClickListener
{
  ComponentContentRecommend$1(ComponentContentRecommend paramComponentContentRecommend) {}
  
  public void onClick(View paramView)
  {
    this.a.a(ComponentContentRecommend.a(this.a));
    ReadInJoyLogicEngine.a().a(ComponentContentRecommend.a(this.a).mArticleID, ComponentContentRecommend.a(this.a).mRecommendFollowInfos.a);
    ComponentContentRecommend.a(this.a);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.rebuild.cmp.ComponentContentRecommend.1
 * JD-Core Version:    0.7.0.1
 */