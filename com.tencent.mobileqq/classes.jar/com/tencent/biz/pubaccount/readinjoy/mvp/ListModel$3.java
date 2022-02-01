package com.tencent.biz.pubaccount.readinjoy.mvp;

import android.support.annotation.Nullable;
import java.util.ArrayList;
import java.util.concurrent.CopyOnWriteArrayList;

class ListModel$3
  implements ListModel.LoadDataFromNetworkCallback<BEAN, COOKIE>
{
  ListModel$3(ListModel paramListModel, ListContract.NextPageCallback paramNextPageCallback) {}
  
  public void a(boolean paramBoolean1, boolean paramBoolean2, int paramInt1, ArrayList<BEAN> paramArrayList, @Nullable COOKIE paramCOOKIE, int paramInt2, String paramString)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyMvpListModel.a.addAll(paramArrayList);
    if (paramBoolean1)
    {
      ListModel.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyMvpListModel, paramCOOKIE);
      paramArrayList = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyMvpListModel;
      if (paramBoolean2) {
        break label68;
      }
    }
    label68:
    for (paramBoolean2 = true;; paramBoolean2 = false)
    {
      ListModel.a(paramArrayList, paramBoolean2);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyMvpListContract$NextPageCallback.a(paramBoolean1, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyMvpListModel.a, paramInt2, paramString);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.mvp.ListModel.3
 * JD-Core Version:    0.7.0.1
 */