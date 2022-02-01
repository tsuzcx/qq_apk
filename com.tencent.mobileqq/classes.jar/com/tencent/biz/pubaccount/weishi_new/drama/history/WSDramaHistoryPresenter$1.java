package com.tencent.biz.pubaccount.weishi_new.drama.history;

import com.tencent.biz.pubaccount.weishi_new.data.FetcherParams;
import com.tencent.biz.pubaccount.weishi_new.data.IFetchDataRspListener;
import java.util.List;

class WSDramaHistoryPresenter$1
  implements IFetchDataRspListener<WSDramaHistoryData>
{
  WSDramaHistoryPresenter$1(WSDramaHistoryPresenter paramWSDramaHistoryPresenter, FetcherParams paramFetcherParams) {}
  
  public void a(int paramInt, String paramString, boolean paramBoolean1, boolean paramBoolean2)
  {
    if (WSDramaHistoryPresenter.a(this.b) != null) {
      WSDramaHistoryPresenter.a(this.b).a(this.a.a(), paramInt, paramString);
    }
  }
  
  public void a(List<WSDramaHistoryData> paramList, boolean paramBoolean1, boolean paramBoolean2, Object paramObject)
  {
    if ((paramObject instanceof Boolean)) {
      WSDramaHistoryPresenter.a(this.b, ((Boolean)paramObject).booleanValue());
    }
    if (WSDramaHistoryPresenter.a(this.b) != null)
    {
      paramObject = WSDramaHistoryPresenter.a(this.b);
      if (!this.a.a()) {
        paramList = WSDramaHistoryPresenter.a(this.b, paramList);
      }
      paramObject.a(paramList, this.a.a(), WSDramaHistoryPresenter.b(this.b));
    }
    if ((this.a.a()) && (WSDramaHistoryPresenter.c(this.b) != null))
    {
      if (WSDramaHistoryPresenter.d(this.b))
      {
        paramList = this.b;
        WSDramaHistoryPresenter.a(paramList, WSDramaHistoryPresenter.c(paramList).a);
        return;
      }
      paramList = this.b;
      WSDramaHistoryPresenter.b(paramList, WSDramaHistoryPresenter.c(paramList).a);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.drama.history.WSDramaHistoryPresenter.1
 * JD-Core Version:    0.7.0.1
 */