package com.tencent.biz.pubaccount.readinjoy.decoupling.uilayer.video.click;

import android.content.Context;
import android.content.res.Resources;
import android.text.TextUtils;
import android.view.View;
import com.tencent.biz.pubaccount.VideoReporter;
import com.tencent.biz.pubaccount.readinjoy.decoupling.accesslayer.data.RIJDataManager;
import com.tencent.biz.pubaccount.readinjoy.decoupling.accesslayer.data.RIJDataManager.Builder;
import com.tencent.biz.pubaccount.readinjoy.decoupling.uilayer.framewrok.ClickHandler;
import com.tencent.biz.pubaccount.readinjoy.decoupling.uilayer.framewrok.util.RIJJumpUtils;
import com.tencent.biz.pubaccount.readinjoy.decoupling.uilayer.video.RIJConfigVideoItem;
import com.tencent.biz.pubaccount.readinjoy.decoupling.uilayer.video.report.RIJVideoReportManager;
import com.tencent.biz.pubaccount.readinjoy.struct.BaseArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.video.VideoPlayManager;
import com.tencent.biz.pubaccount.readinjoy.video.VideoPlayManager.VideoPlayParam;
import com.tencent.biz.pubaccount.readinjoy.video.viewholder.WeishiGridTwoItemViewHolder;
import com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyBaseAdapter;
import com.tencent.biz.pubaccount.util.VideoFeedsWeiShiUtils;
import com.tencent.biz.qqstory.utils.WeishiGuideUtils;
import com.tencent.mobileqq.widget.QQToast;

class RIJVideoHandleClick$12
  implements ClickHandler
{
  RIJVideoHandleClick$12(RIJVideoHandleClick paramRIJVideoHandleClick) {}
  
  public void onClick(View paramView)
  {
    BaseArticleInfo localBaseArticleInfo;
    if (paramView.getId() == 2131368055) {
      localBaseArticleInfo = ((WeishiGridTwoItemViewHolder)paramView.getTag()).a;
    }
    VideoPlayManager.VideoPlayParam localVideoPlayParam;
    for (Object localObject = ((WeishiGridTwoItemViewHolder)paramView.getTag()).b.innerUniqueID;; localObject = ((WeishiGridTwoItemViewHolder)paramView.getTag()).a.innerUniqueID)
    {
      localVideoPlayParam = RIJConfigVideoItem.a(localBaseArticleInfo);
      localVideoPlayParam.n = ((String)localObject);
      localVideoPlayParam.l = VideoReporter.b();
      if ((RIJVideoHandleClick.a(this.a).a().a() != null) && (!TextUtils.isEmpty(RIJVideoHandleClick.a(this.a).a().a().b()))) {
        localVideoPlayParam.m = RIJVideoHandleClick.a(this.a).a().a().b();
      }
      localObject = new int[2];
      paramView.getLocationOnScreen((int[])localObject);
      localVideoPlayParam.h = localObject[0];
      localVideoPlayParam.i = localObject[1];
      localVideoPlayParam.j = paramView.getWidth();
      localVideoPlayParam.k = paramView.getHeight();
      if (!localBaseArticleInfo.isVideoItemForCommonUrlJump()) {
        break;
      }
      RIJJumpUtils.a(RIJVideoHandleClick.a(this.a).a().a(), localBaseArticleInfo.mVideoAdsJumpUrl);
      RIJVideoReportManager.a(localVideoPlayParam, localBaseArticleInfo, RIJVideoHandleClick.a(this.a));
      return;
      localBaseArticleInfo = ((WeishiGridTwoItemViewHolder)paramView.getTag()).b;
    }
    if (localBaseArticleInfo.isVideoItemForWeishiJump())
    {
      if (WeishiGuideUtils.a(RIJVideoHandleClick.a(this.a).a().a())) {
        VideoFeedsWeiShiUtils.a(RIJVideoHandleClick.a(this.a).a().a(), "video_type_videopublic");
      }
      for (;;)
      {
        RIJVideoReportManager.a(localVideoPlayParam, localBaseArticleInfo, RIJVideoHandleClick.a(this.a));
        return;
        QQToast.a(RIJVideoHandleClick.a(this.a).a().a(), -1, 2131718228, 0).b(RIJVideoHandleClick.a(this.a).a().a().getResources().getDimensionPixelSize(2131299166));
        VideoFeedsWeiShiUtils.b(RIJVideoHandleClick.a(this.a).a().a(), "video_type_videopublic");
      }
    }
    RIJVideoHandleClick.a(this.a).a().a().a(localVideoPlayParam, localBaseArticleInfo, false, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.decoupling.uilayer.video.click.RIJVideoHandleClick.12
 * JD-Core Version:    0.7.0.1
 */