package com.tencent.biz.pubaccount.weishi_new.verticalvideo.presenter;

import UserGrowth.stSimpleMetaFeed;
import com.tencent.biz.pubaccount.weishi_new.data.IFetchDataRspListener;
import com.tencent.biz.pubaccount.weishi_new.data.WSFeedDataManager.OnDataReceivedListener;
import java.util.List;

class WSVerticalForFollowPresenter$1
  implements WSFeedDataManager.OnDataReceivedListener<stSimpleMetaFeed>
{
  WSVerticalForFollowPresenter$1(WSVerticalForFollowPresenter paramWSVerticalForFollowPresenter, IFetchDataRspListener paramIFetchDataRspListener, boolean paramBoolean1, boolean paramBoolean2) {}
  
  public void a(boolean paramBoolean1, List<stSimpleMetaFeed> paramList, boolean paramBoolean2)
  {
    paramList = WSVerticalForFollowPresenter.a(this.d, paramList);
    IFetchDataRspListener localIFetchDataRspListener = this.a;
    if (localIFetchDataRspListener != null) {
      localIFetchDataRspListener.a(paramList, this.b, this.c, null);
    }
  }
  
  public void a(boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, Object paramObject)
  {
    if (!paramBoolean3)
    {
      paramObject = this.a;
      if (paramObject != null) {
        paramObject.a(-1, "task failed.", paramBoolean1, paramBoolean2);
      }
      this.d.a(-1, "task failed.", paramBoolean1, paramBoolean2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.verticalvideo.presenter.WSVerticalForFollowPresenter.1
 * JD-Core Version:    0.7.0.1
 */