package com.tencent.biz.pubaccount.readinjoy.presenter;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.pubaccount.readinjoy.model.IReadInJoyModel;
import com.tencent.biz.pubaccount.readinjoy.model.ReadInJoyModelImpl;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyView;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.KandianNegativeWindow;

class ReadInJoyHeaderPresenter$1
  implements View.OnClickListener
{
  ReadInJoyHeaderPresenter$1(ReadInJoyHeaderPresenter paramReadInJoyHeaderPresenter, IReadInJoyModel paramIReadInJoyModel, ReadInJoyView paramReadInJoyView) {}
  
  public void onClick(View paramView)
  {
    if (ReadInJoyHeaderPresenter.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyPresenterReadInJoyHeaderPresenter) == null) {
      ReadInJoyHeaderPresenter.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyPresenterReadInJoyHeaderPresenter, new KandianNegativeWindow(ReadInJoyHeaderPresenter.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyPresenterReadInJoyHeaderPresenter)));
    }
    ReadInJoyHeaderPresenter.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyPresenterReadInJoyHeaderPresenter).a((ReadInJoyModelImpl)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelIReadInJoyModel, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelIReadInJoyModel.a().mDislikeInfos);
    ReadInJoyHeaderPresenter.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyPresenterReadInJoyHeaderPresenter).a(paramView, new ReadInJoyHeaderPresenter.1.1(this));
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.presenter.ReadInJoyHeaderPresenter.1
 * JD-Core Version:    0.7.0.1
 */