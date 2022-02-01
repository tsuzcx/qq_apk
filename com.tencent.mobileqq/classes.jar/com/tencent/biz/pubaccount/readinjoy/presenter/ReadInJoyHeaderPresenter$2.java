package com.tencent.biz.pubaccount.readinjoy.presenter;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.pubaccount.readinjoy.common.ReadInJoyConstants;
import com.tencent.biz.pubaccount.readinjoy.common.ReadInJoyUtils;
import com.tencent.biz.pubaccount.readinjoy.decoupling.uilayer.framewrok.util.RIJFeedsType;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.mobileqq.utils.Base64Util;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class ReadInJoyHeaderPresenter$2
  implements View.OnClickListener
{
  ReadInJoyHeaderPresenter$2(ReadInJoyHeaderPresenter paramReadInJoyHeaderPresenter, String paramString, ArticleInfo paramArticleInfo) {}
  
  public void onClick(View paramView)
  {
    String str = ReadInJoyConstants.g + Base64Util.encodeToString(this.jdField_a_of_type_JavaLangString.getBytes(), 2);
    ReadInJoyUtils.a(ReadInJoyHeaderPresenter.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyPresenterReadInJoyHeaderPresenter), str);
    ReadInJoyHeaderPresenter.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyPresenterReadInJoyHeaderPresenter, RIJFeedsType.b(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo));
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.presenter.ReadInJoyHeaderPresenter.2
 * JD-Core Version:    0.7.0.1
 */