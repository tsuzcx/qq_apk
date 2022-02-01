package com.tencent.biz.pubaccount.readinjoy.mvp;

import android.support.annotation.Nullable;
import java.util.List;

public class ListPresenter<BEAN, VIEW extends ListContract.IListView<BEAN>>
  implements ListContract.IListPresenter<BEAN, VIEW>
{
  private ListContract.IListModel<BEAN> jdField_a_of_type_ComTencentBizPubaccountReadinjoyMvpListContract$IListModel;
  private ListContract.IListView<BEAN> jdField_a_of_type_ComTencentBizPubaccountReadinjoyMvpListContract$IListView = null;
  private boolean jdField_a_of_type_Boolean = false;
  
  public ListPresenter(ListContract.IListModel<BEAN> paramIListModel)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyMvpListContract$IListModel = paramIListModel;
  }
  
  private void a(List<BEAN> paramList)
  {
    if ((paramList != null) && (!paramList.isEmpty()))
    {
      if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyMvpListContract$IListView != null)
      {
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyMvpListContract$IListView.setCenterHide();
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyMvpListContract$IListView.setListData(paramList, false);
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyMvpListContract$IListView.setFooterNoMore();
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyMvpListContract$IListView.setHeaderLoading();
      }
      this.jdField_a_of_type_Boolean = true;
    }
  }
  
  private void a(boolean paramBoolean, int paramInt, List<BEAN> paramList)
  {
    if (paramBoolean)
    {
      a(paramList);
      return;
    }
    b(paramInt, paramList);
  }
  
  private void a(boolean paramBoolean, List<BEAN> paramList, int paramInt, @Nullable String paramString)
  {
    if ((this.jdField_a_of_type_Boolean) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyMvpListContract$IListView != null)) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyMvpListContract$IListView.setHeaderError(paramInt, paramString);
    }
    if ((paramList != null) && (!paramList.isEmpty()) && (paramBoolean) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyMvpListContract$IListView != null))
    {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyMvpListContract$IListView.setCenterHide();
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyMvpListContract$IListView.setListData(paramList, false);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyMvpListContract$IListView.setFooterNoMore();
    }
    while ((this.jdField_a_of_type_Boolean) || (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyMvpListContract$IListView == null)) {
      return;
    }
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyMvpListContract$IListView.setCenterError(paramInt, paramString);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyMvpListContract$IListView.setTotal(0);
  }
  
  private void b(int paramInt, List<BEAN> paramList)
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyMvpListContract$IListView != null)
    {
      if (this.jdField_a_of_type_Boolean) {
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyMvpListContract$IListView.setHeaderSuccess();
      }
      a(paramInt, paramList);
    }
  }
  
  public void a()
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyMvpListContract$IListView = null;
  }
  
  public void a(int paramInt, List<BEAN> paramList)
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyMvpListContract$IListView != null)
    {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyMvpListContract$IListView.setTotal(paramInt);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyMvpListContract$IListView.setListData(paramList, false);
      if ((paramList == null) || (paramList.isEmpty())) {
        break label82;
      }
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyMvpListContract$IListView.setCenterHide();
      if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyMvpListContract$IListModel.a()) {
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyMvpListContract$IListView.setFooterHasMore();
      }
    }
    else
    {
      return;
    }
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyMvpListContract$IListView.setFooterNoMore();
    return;
    label82:
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyMvpListContract$IListView.setCenterEmpty();
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyMvpListContract$IListView.setFooterHide();
  }
  
  public void a(VIEW paramVIEW)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyMvpListContract$IListView = paramVIEW;
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyMvpListContract$IListView != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyMvpListContract$IListView.setCenterLoading();
    }
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyMvpListContract$IListModel.a(true, new ListPresenter.2(this));
  }
  
  public void c()
  {
    if (!this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyMvpListContract$IListModel.a())
    {
      if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyMvpListContract$IListView != null) {
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyMvpListContract$IListView.setFooterNoMore();
      }
      return;
    }
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyMvpListContract$IListView != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyMvpListContract$IListView.setFooterLoading();
    }
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyMvpListContract$IListModel.a(new ListPresenter.3(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.mvp.ListPresenter
 * JD-Core Version:    0.7.0.1
 */