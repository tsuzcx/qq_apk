package com.tencent.biz.pubaccount.readinjoy.ugc.selectmember.search;

import android.view.ViewGroup;
import com.tencent.mobileqq.app.face.IFaceDecoder;
import com.tencent.mobileqq.search.adapter.BaseMvpFaceAdapter;
import com.tencent.mobileqq.search.model.ContactSearchModelFriend;
import com.tencent.mobileqq.search.model.ISearchResultModel;
import com.tencent.mobileqq.search.presenter.IPresenter;
import com.tencent.mobileqq.search.presenter.SelectMemberContactSearchResultPresenter;
import com.tencent.mobileqq.search.view.ContactSearchResultView;
import com.tencent.mobileqq.search.view.ISearchResultView;
import com.tencent.mobileqq.search.view.IView;
import com.tencent.widget.ListView;

class HybridSearchFragment$1
  extends BaseMvpFaceAdapter<ISearchResultModel, ISearchResultView>
{
  HybridSearchFragment$1(HybridSearchFragment paramHybridSearchFragment, ListView paramListView, IFaceDecoder paramIFaceDecoder)
  {
    super(paramListView, paramIFaceDecoder);
  }
  
  public IPresenter<ISearchResultModel, ISearchResultView> a(int paramInt)
  {
    if (((ISearchResultModel)a(paramInt) instanceof ContactSearchModelFriend)) {
      return new SelectMemberContactSearchResultPresenter(this.jdField_a_of_type_ComTencentMobileqqAppFaceIFaceDecoder, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyUgcSelectmemberSearchHybridSearchFragment, HybridSearchFragment.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyUgcSelectmemberSearchHybridSearchFragment), null);
    }
    return new FollowSearchResultPresenter(this.jdField_a_of_type_ComTencentMobileqqAppFaceIFaceDecoder, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyUgcSelectmemberSearchHybridSearchFragment, HybridSearchFragment.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyUgcSelectmemberSearchHybridSearchFragment));
  }
  
  public IView a(int paramInt, ViewGroup paramViewGroup)
  {
    return new ContactSearchResultView(paramViewGroup, 2131562971);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.ugc.selectmember.search.HybridSearchFragment.1
 * JD-Core Version:    0.7.0.1
 */