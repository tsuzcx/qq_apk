package com.tencent.biz.pubaccount.weishi_new.verticalvideo.presenter;

import com.tencent.biz.pubaccount.weishi_new.data.IFetchDataRspListener;
import com.tencent.biz.pubaccount.weishi_new.verticalvideo.data.WSVerticalItemData;
import java.util.List;

class WSVerticalForProfilePresenter$1
  implements IFetchDataRspListener<WSVerticalItemData>
{
  WSVerticalForProfilePresenter$1(WSVerticalForProfilePresenter paramWSVerticalForProfilePresenter, IFetchDataRspListener paramIFetchDataRspListener) {}
  
  public void a(int paramInt, String paramString, boolean paramBoolean1, boolean paramBoolean2)
  {
    paramString = this.a;
    if (paramString != null) {
      paramString.a(-1, "task failed.", paramBoolean1, paramBoolean2);
    }
  }
  
  public void a(List<WSVerticalItemData> paramList, boolean paramBoolean1, boolean paramBoolean2, Object paramObject)
  {
    paramObject = this.a;
    if (paramObject != null) {
      paramObject.a(paramList, paramBoolean1, paramBoolean2, null);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.verticalvideo.presenter.WSVerticalForProfilePresenter.1
 * JD-Core Version:    0.7.0.1
 */