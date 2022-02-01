package com.tencent.biz.pubaccount.readinjoy.ugc.selectmember.search;

import android.view.View;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.search.adapter.BaseMvpAdapter;
import com.tencent.mobileqq.search.fragment.BaseSearchFragment;
import com.tencent.mobileqq.search.model.ISearchResultModel;
import com.tencent.mobileqq.search.presenter.ContactSearchResultPresenter.OnActionListener;
import com.tencent.mobileqq.search.searchengine.ContactSearchEngine;
import com.tencent.mobileqq.search.searchengine.ISearchEngine;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class HybridSearchFragment
  extends BaseSearchFragment
  implements ContactSearchResultPresenter.OnActionListener
{
  private HybridSearchFragment.OnSearchResultClickListener jdField_a_of_type_ComTencentBizPubaccountReadinjoyUgcSelectmemberSearchHybridSearchFragment$OnSearchResultClickListener;
  private Set<String> jdField_a_of_type_JavaUtilSet = new HashSet();
  
  public static HybridSearchFragment a()
  {
    return new HybridSearchFragment();
  }
  
  public BaseMvpAdapter a()
  {
    return new HybridSearchFragment.1(this, this.jdField_a_of_type_ComTencentWidgetListView, this.jdField_a_of_type_ComTencentMobileqqAppFaceIFaceDecoder);
  }
  
  public ISearchEngine a()
  {
    ArrayList localArrayList = new ArrayList();
    HashSet localHashSet = new HashSet();
    localHashSet.add(AppConstants.BABY_Q_UIN);
    localArrayList.add(new ContactSearchEngine(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, -1, 1, null, localHashSet));
    localArrayList.add(new FollowingSearchEngine());
    return new SelectMemberHybridSearchEngine(localArrayList);
  }
  
  public void a(View paramView)
  {
    paramView = (ISearchResultModel)paramView.getTag(2131381651);
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyUgcSelectmemberSearchHybridSearchFragment$OnSearchResultClickListener != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyUgcSelectmemberSearchHybridSearchFragment$OnSearchResultClickListener.a(paramView);
    }
  }
  
  public void a(HybridSearchFragment.OnSearchResultClickListener paramOnSearchResultClickListener)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyUgcSelectmemberSearchHybridSearchFragment$OnSearchResultClickListener = paramOnSearchResultClickListener;
  }
  
  public boolean a()
  {
    return false;
  }
  
  public void b_(List<String> paramList)
  {
    this.jdField_a_of_type_JavaUtilSet.clear();
    if (paramList != null) {
      this.jdField_a_of_type_JavaUtilSet.addAll(paramList);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.ugc.selectmember.search.HybridSearchFragment
 * JD-Core Version:    0.7.0.1
 */