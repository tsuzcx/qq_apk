package com.tencent.biz.pubaccount.readinjoy.decoupling.uilayer.video.click;

import android.app.Activity;
import android.view.View;
import com.tencent.biz.pubaccount.readinjoy.decoupling.accesslayer.data.RIJDataManager;
import com.tencent.biz.pubaccount.readinjoy.decoupling.accesslayer.data.RIJDataManager.Builder;
import com.tencent.biz.pubaccount.readinjoy.decoupling.uilayer.framewrok.ClickHandler;
import com.tencent.biz.pubaccount.readinjoy.handlers.VideoHandler;
import com.tencent.biz.pubaccount.readinjoy.struct.AdvertisementInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.BaseArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsHelper;
import com.tencent.biz.pubaccount.readinjoy.video.viewholder.VideoFeedsViewHolder;
import com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyBaseAdapter;
import com.tencent.biz.pubaccount.util.ReadinJoyActionUtil;
import com.tencent.mobileqq.app.ThreadManager;

class RIJVideoHandleClick$9
  implements ClickHandler
{
  RIJVideoHandleClick$9(RIJVideoHandleClick paramRIJVideoHandleClick) {}
  
  public void onClick(View paramView)
  {
    VideoFeedsViewHolder localVideoFeedsViewHolder = (VideoFeedsViewHolder)paramView.getTag();
    BaseArticleInfo localBaseArticleInfo = RIJVideoHandleClick.a(this.a).a(localVideoFeedsViewHolder.jdField_a_of_type_Int);
    if (localBaseArticleInfo == null) {
      return;
    }
    if (!VideoFeedsHelper.a(localBaseArticleInfo, RIJVideoHandleClick.a(this.a).a().a()))
    {
      if (AdvertisementInfo.isAdvertisementInfo(localBaseArticleInfo))
      {
        ReadinJoyActionUtil.a(RIJVideoHandleClick.a(this.a).a().a(), (ArticleInfo)localBaseArticleInfo, RIJVideoHandleClick.a(this.a).a().a(), 56);
        ReadinJoyActionUtil.a((Activity)RIJVideoHandleClick.a(this.a).a().a(), (ArticleInfo)localBaseArticleInfo, RIJVideoHandleClick.a(this.a).a().a(), 56, false, null);
        return;
      }
      RIJVideoHandleClick.a(this.a).a().a().a(localVideoFeedsViewHolder.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager$VideoPlayParam, localBaseArticleInfo, false, true);
    }
    ThreadManager.executeOnSubThread(new RIJVideoHandleClick.9.1(this, localBaseArticleInfo));
    VideoHandler.a(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.decoupling.uilayer.video.click.RIJVideoHandleClick.9
 * JD-Core Version:    0.7.0.1
 */