package com.tencent.biz.pubaccount.readinjoy.presenter;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.pubaccount.readinjoy.common.ReadInJoyUtils;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import tencent.im.oidb.articlesummary.articlesummary.PackJumpInfo;

class ReadInJoyFooterPresenter$4
  implements View.OnClickListener
{
  ReadInJoyFooterPresenter$4(ReadInJoyFooterPresenter paramReadInJoyFooterPresenter, articlesummary.PackJumpInfo paramPackJumpInfo) {}
  
  public void onClick(View paramView)
  {
    String str = this.jdField_a_of_type_TencentImOidbArticlesummaryArticlesummary$PackJumpInfo.str_url.get();
    ReadInJoyUtils.a(ReadInJoyFooterPresenter.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyPresenterReadInJoyFooterPresenter), str);
    ReadInJoyFooterPresenter.a(2, this.jdField_a_of_type_TencentImOidbArticlesummaryArticlesummary$PackJumpInfo.str_wording.get());
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.presenter.ReadInJoyFooterPresenter.4
 * JD-Core Version:    0.7.0.1
 */