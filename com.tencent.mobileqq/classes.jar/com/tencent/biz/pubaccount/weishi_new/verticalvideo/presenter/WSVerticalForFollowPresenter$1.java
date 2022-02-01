package com.tencent.biz.pubaccount.weishi_new.verticalvideo.presenter;

import UserGrowth.stSimpleMetaFeed;
import com.tencent.biz.pubaccount.weishi_new.data.WSFeedDataManager.OnDataReceivedListener;
import com.tencent.biz.pubaccount.weishi_new.verticalvideo.data.IVerticalRspListener;
import java.util.List;

class WSVerticalForFollowPresenter$1
  implements WSFeedDataManager.OnDataReceivedListener<stSimpleMetaFeed>
{
  WSVerticalForFollowPresenter$1(WSVerticalForFollowPresenter paramWSVerticalForFollowPresenter, IVerticalRspListener paramIVerticalRspListener, boolean paramBoolean1, boolean paramBoolean2) {}
  
  public void a(boolean paramBoolean1, List<stSimpleMetaFeed> paramList, boolean paramBoolean2)
  {
    paramList = WSVerticalForFollowPresenter.a(this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoPresenterWSVerticalForFollowPresenter, paramList);
    if (this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoDataIVerticalRspListener != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoDataIVerticalRspListener.a(paramList, this.jdField_a_of_type_Boolean, this.b, null);
    }
  }
  
  public void a(boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, Object paramObject)
  {
    if (!paramBoolean3)
    {
      if (this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoDataIVerticalRspListener != null) {
        this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoDataIVerticalRspListener.a(-1, "task failed.", paramBoolean1, paramBoolean2);
      }
      this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoPresenterWSVerticalForFollowPresenter.a(-1, "task failed.", paramBoolean1, paramBoolean2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.verticalvideo.presenter.WSVerticalForFollowPresenter.1
 * JD-Core Version:    0.7.0.1
 */