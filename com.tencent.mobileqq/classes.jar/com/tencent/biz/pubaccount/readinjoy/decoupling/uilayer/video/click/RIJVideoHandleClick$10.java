package com.tencent.biz.pubaccount.readinjoy.decoupling.uilayer.video.click;

import android.view.View;
import com.tencent.biz.pubaccount.readinjoy.decoupling.accesslayer.data.RIJDataManager;
import com.tencent.biz.pubaccount.readinjoy.decoupling.accesslayer.data.RIJDataManager.Builder;
import com.tencent.biz.pubaccount.readinjoy.decoupling.uilayer.framewrok.ClickHandler;
import com.tencent.biz.pubaccount.readinjoy.handlers.VideoHandler;
import com.tencent.biz.pubaccount.readinjoy.struct.BaseArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.video.viewholder.VideoFeedsViewHolder;
import com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyBaseAdapter;
import com.tencent.mobileqq.app.ThreadManager;

class RIJVideoHandleClick$10
  implements ClickHandler
{
  RIJVideoHandleClick$10(RIJVideoHandleClick paramRIJVideoHandleClick) {}
  
  public void onClick(View paramView)
  {
    VideoFeedsViewHolder localVideoFeedsViewHolder = (VideoFeedsViewHolder)paramView.getTag();
    BaseArticleInfo localBaseArticleInfo = RIJVideoHandleClick.a(this.a).a(localVideoFeedsViewHolder.jdField_a_of_type_Int);
    if (localBaseArticleInfo == null) {
      return;
    }
    RIJVideoHandleClick.a(this.a).a().a().a(localVideoFeedsViewHolder.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager$VideoPlayParam, localBaseArticleInfo, true, true);
    ThreadManager.executeOnSubThread(new RIJVideoHandleClick.10.1(this, localBaseArticleInfo));
    VideoHandler.a(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.decoupling.uilayer.video.click.RIJVideoHandleClick.10
 * JD-Core Version:    0.7.0.1
 */