package com.tencent.biz.pubaccount.weishi_new.presenter;

import UserGrowth.stPublisherRsp;
import androidx.annotation.Nullable;
import com.tencent.biz.pubaccount.weishi_new.combo.publisher.IWSPublisherRspListener;
import com.tencent.biz.pubaccount.weishi_new.presenter.view.IWSHomeView;
import com.tencent.biz.pubaccount.weishi_new.util.WSLog;

class WSHomeFragmentPresenter$4
  implements IWSPublisherRspListener
{
  WSHomeFragmentPresenter$4(WSHomeFragmentPresenter paramWSHomeFragmentPresenter) {}
  
  public void a(int paramInt, @Nullable String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("GetPublisherRequest onTaskResponse failed errorCode:");
    localStringBuilder.append(paramInt);
    localStringBuilder.append(", errMsg:");
    localStringBuilder.append(paramString);
    WSLog.d("WSHomeFragmentPresenter", localStringBuilder.toString());
  }
  
  public void a(@Nullable stPublisherRsp paramstPublisherRsp)
  {
    if (this.a.getView() != null) {
      ((IWSHomeView)this.a.getView()).a(paramstPublisherRsp);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.presenter.WSHomeFragmentPresenter.4
 * JD-Core Version:    0.7.0.1
 */