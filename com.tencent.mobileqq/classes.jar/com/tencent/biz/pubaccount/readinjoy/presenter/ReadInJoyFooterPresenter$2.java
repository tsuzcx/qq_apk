package com.tencent.biz.pubaccount.readinjoy.presenter;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.pubaccount.readinjoy.common.ReadInJoyConstants;
import com.tencent.biz.pubaccount.readinjoy.common.ReadInJoyUtils;
import com.tencent.biz.pubaccount.readinjoy.decoupling.uilayer.framewrok.util.RIJFeedsType;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.mobileqq.utils.Base64Util;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class ReadInJoyFooterPresenter$2
  implements View.OnClickListener
{
  ReadInJoyFooterPresenter$2(ReadInJoyFooterPresenter paramReadInJoyFooterPresenter, long paramLong, ArticleInfo paramArticleInfo) {}
  
  public void onClick(View paramView)
  {
    String str = ReadInJoyConstants.g + Base64Util.encodeToString(String.valueOf(this.jdField_a_of_type_Long).getBytes(), 2);
    ReadInJoyUtils.a(ReadInJoyFooterPresenter.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyPresenterReadInJoyFooterPresenter), str);
    ReadInJoyFooterPresenter.a(1, RIJFeedsType.b(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo));
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.presenter.ReadInJoyFooterPresenter.2
 * JD-Core Version:    0.7.0.1
 */