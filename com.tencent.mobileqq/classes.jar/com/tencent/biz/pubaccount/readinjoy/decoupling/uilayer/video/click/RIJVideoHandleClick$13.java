package com.tencent.biz.pubaccount.readinjoy.decoupling.uilayer.video.click;

import android.view.View;
import com.tencent.biz.pubaccount.readinjoy.decoupling.accesslayer.data.RIJDataManager;
import com.tencent.biz.pubaccount.readinjoy.decoupling.accesslayer.data.RIJDataManager.Builder;
import com.tencent.biz.pubaccount.readinjoy.decoupling.uilayer.framewrok.ClickHandler;
import com.tencent.biz.pubaccount.readinjoy.decoupling.uilayer.framewrok.util.RIJAladdinUtils;
import com.tencent.biz.pubaccount.readinjoy.decoupling.uilayer.video.RIJFullVideoPlayActivity;
import com.tencent.biz.pubaccount.readinjoy.handlers.VideoHandler;
import com.tencent.biz.pubaccount.readinjoy.struct.BaseArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.video.VideoPlayManager;
import com.tencent.biz.pubaccount.readinjoy.video.share.VideoShareHelper;
import com.tencent.biz.pubaccount.readinjoy.video.viewholder.VideoFeedsViewHolder;
import com.tencent.qphone.base.util.QLog;

class RIJVideoHandleClick$13
  implements ClickHandler
{
  RIJVideoHandleClick$13(RIJVideoHandleClick paramRIJVideoHandleClick) {}
  
  public void onClick(View paramView)
  {
    VideoFeedsViewHolder localVideoFeedsViewHolder = (VideoFeedsViewHolder)paramView.getTag();
    BaseArticleInfo localBaseArticleInfo = RIJVideoHandleClick.a(this.a).a(localVideoFeedsViewHolder.jdField_a_of_type_Int);
    if (localBaseArticleInfo == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("RIJVideoHandleClick", 2, "articleInfo == null, ERROR");
      }
      return;
    }
    if ((RIJVideoHandleClick.a(this.a).a().a() != null) && (RIJVideoHandleClick.a(this.a).a().a().b()))
    {
      RIJVideoHandleClick.a(this.a).a().a().a();
      RIJVideoHandleClick.a(this.a).a().f(true);
    }
    if ((paramView.getId() == 2131368859) || (RIJAladdinUtils.d())) {}
    VideoShareHelper localVideoShareHelper;
    for (boolean bool = true;; bool = false)
    {
      localVideoShareHelper = RIJVideoHandleClick.a(this.a).a().a();
      if (localVideoShareHelper != null) {
        break;
      }
      QLog.e("RIJVideoHandleClick", 1, "handleVideoShareClick share failed for videoShareHelper is null.");
      return;
    }
    localVideoShareHelper.a(localVideoFeedsViewHolder.g, localVideoFeedsViewHolder.jdField_a_of_type_Int);
    localVideoShareHelper.a(RIJVideoHandleClick.a(this.a).a().a());
    localVideoShareHelper.a(localBaseArticleInfo, RIJFullVideoPlayActivity.a(localVideoFeedsViewHolder.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager$VideoPlayParam, localBaseArticleInfo, RIJVideoHandleClick.a(this.a).a().a(), RIJVideoHandleClick.a(this.a)), RIJVideoHandleClick.a(this.a).a().a(), new RIJVideoHandleClick.13.1(this, localBaseArticleInfo), RIJVideoHandleClick.a(this.a).a().b(), bool);
    VideoHandler.a(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.decoupling.uilayer.video.click.RIJVideoHandleClick.13
 * JD-Core Version:    0.7.0.1
 */