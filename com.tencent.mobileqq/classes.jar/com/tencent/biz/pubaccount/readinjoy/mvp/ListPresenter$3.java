package com.tencent.biz.pubaccount.readinjoy.mvp;

import com.tencent.qphone.base.util.QLog;
import java.util.List;

class ListPresenter$3
  implements ListContract.NextPageCallback<BEAN>
{
  ListPresenter$3(ListPresenter paramListPresenter) {}
  
  public void a(boolean paramBoolean, List<BEAN> paramList, int paramInt, String paramString)
  {
    if (ListPresenter.a(this.a) != null)
    {
      if (!paramBoolean) {
        break label69;
      }
      ListPresenter.a(this.a).setListData(paramList, true);
      if (ListPresenter.a(this.a).a()) {
        ListPresenter.a(this.a).setFooterHasMore();
      }
    }
    else
    {
      return;
    }
    ListPresenter.a(this.a).setFooterNoMore();
    return;
    label69:
    QLog.i("ListPresenter", 2, "loadNextPage error, errorCode=" + paramInt + ", errorMsg= " + paramString);
    ListPresenter.a(this.a).setFooterError(paramInt, paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.mvp.ListPresenter.3
 * JD-Core Version:    0.7.0.1
 */