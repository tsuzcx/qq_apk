package com.tencent.biz.pubaccount.readinjoy.presenter;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.pubaccount.readinjoy.common.ReadInJoyUtils;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class ReadInJoyFooterPresenter$7
  implements View.OnClickListener
{
  ReadInJoyFooterPresenter$7(ReadInJoyFooterPresenter paramReadInJoyFooterPresenter, String paramString1, String paramString2) {}
  
  public void onClick(View paramView)
  {
    ReadInJoyFooterPresenter.a(2, this.jdField_a_of_type_JavaLangString);
    ReadInJoyUtils.a(ReadInJoyFooterPresenter.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyPresenterReadInJoyFooterPresenter), this.b);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.presenter.ReadInJoyFooterPresenter.7
 * JD-Core Version:    0.7.0.1
 */