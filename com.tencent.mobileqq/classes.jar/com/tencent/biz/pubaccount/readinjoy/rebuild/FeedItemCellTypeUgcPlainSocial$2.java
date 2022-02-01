package com.tencent.biz.pubaccount.readinjoy.rebuild;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.pubaccount.readinjoy.decoupling.uilayer.framewrok.report.RIJFrameworkReportManager;
import com.tencent.biz.pubaccount.readinjoy.decoupling.uilayer.framewrok.util.RIJJumpUtils;
import com.tencent.biz.pubaccount.readinjoy.model.IReadInJoyModel;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class FeedItemCellTypeUgcPlainSocial$2
  implements View.OnClickListener
{
  FeedItemCellTypeUgcPlainSocial$2(FeedItemCellTypeUgcPlainSocial paramFeedItemCellTypeUgcPlainSocial) {}
  
  public void onClick(View paramView)
  {
    RIJJumpUtils.a(this.a.jdField_a_of_type_AndroidContentContext, ((IReadInJoyModel)this.a.jdField_a_of_type_JavaLangObject).a(), 2, false, 2, false);
    RIJFrameworkReportManager.b(((IReadInJoyModel)this.a.jdField_a_of_type_JavaLangObject).a(), ((IReadInJoyModel)this.a.jdField_a_of_type_JavaLangObject).e());
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.rebuild.FeedItemCellTypeUgcPlainSocial.2
 * JD-Core Version:    0.7.0.1
 */