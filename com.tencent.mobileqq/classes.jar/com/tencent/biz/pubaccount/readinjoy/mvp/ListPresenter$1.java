package com.tencent.biz.pubaccount.readinjoy.mvp;

import com.tencent.qphone.base.util.QLog;
import java.util.List;

class ListPresenter$1
  implements ListContract.FirstPageCallback<BEAN>
{
  public void a(boolean paramBoolean, List<BEAN> paramList, int paramInt1, Boolean paramBoolean1, int paramInt2, String paramString)
  {
    if (ListPresenter.a(this.a) != null)
    {
      if (paramBoolean)
      {
        ListPresenter.a(this.a).setHeaderSuccess();
        this.a.a(paramInt1, paramList);
      }
    }
    else {
      return;
    }
    QLog.i("ListPresenter", 2, "refreshPage error, errorCode=" + paramInt2 + ", errorMsg= " + paramString);
    ListPresenter.a(this.a).setHeaderError(paramInt2, paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.mvp.ListPresenter.1
 * JD-Core Version:    0.7.0.1
 */