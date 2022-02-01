package com.tencent.biz.pubaccount.readinjoy.presenter;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.pubaccount.readinjoy.common.ReadInJoyUtils;
import com.tencent.biz.pubaccount.readinjoy.decoupling.uilayer.framewrok.util.RIJFeedsType;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class ReadInJoyFooterPresenter$1
  implements View.OnClickListener
{
  ReadInJoyFooterPresenter$1(ReadInJoyFooterPresenter paramReadInJoyFooterPresenter, String paramString, ArticleInfo paramArticleInfo) {}
  
  public void onClick(View paramView)
  {
    ReadInJoyUtils.a(ReadInJoyFooterPresenter.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyPresenterReadInJoyFooterPresenter), this.jdField_a_of_type_JavaLangString);
    ReadInJoyFooterPresenter.a(1, RIJFeedsType.b(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo));
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.presenter.ReadInJoyFooterPresenter.1
 * JD-Core Version:    0.7.0.1
 */