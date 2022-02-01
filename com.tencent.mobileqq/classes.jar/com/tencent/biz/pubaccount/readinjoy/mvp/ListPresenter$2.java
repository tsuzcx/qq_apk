package com.tencent.biz.pubaccount.readinjoy.mvp;

import com.tencent.qphone.base.util.QLog;
import java.util.List;

class ListPresenter$2
  implements ListContract.FirstPageCallback<BEAN>
{
  ListPresenter$2(ListPresenter paramListPresenter) {}
  
  public void a(boolean paramBoolean, List<BEAN> paramList, int paramInt1, Boolean paramBoolean1, int paramInt2, String paramString)
  {
    if (paramBoolean)
    {
      ListPresenter.a(this.a, paramBoolean1.booleanValue(), paramInt1, paramList);
      return;
    }
    QLog.i("ListPresenter", 2, "loadFirstPage error, errorCode=" + paramInt2 + ", errorMsg= " + paramString);
    ListPresenter.a(this.a, paramBoolean1.booleanValue(), paramList, paramInt2, paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.mvp.ListPresenter.2
 * JD-Core Version:    0.7.0.1
 */