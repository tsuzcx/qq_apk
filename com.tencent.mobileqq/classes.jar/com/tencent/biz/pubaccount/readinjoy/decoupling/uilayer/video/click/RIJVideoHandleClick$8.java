package com.tencent.biz.pubaccount.readinjoy.decoupling.uilayer.video.click;

import android.app.Activity;
import android.view.View;
import com.tencent.biz.pubaccount.api.IPublicAccountReportUtils;
import com.tencent.biz.pubaccount.readinjoy.decoupling.accesslayer.data.RIJDataManager;
import com.tencent.biz.pubaccount.readinjoy.decoupling.accesslayer.data.RIJDataManager.Builder;
import com.tencent.biz.pubaccount.readinjoy.decoupling.accesslayer.util.RIJQQAppInterfaceUtil;
import com.tencent.biz.pubaccount.readinjoy.decoupling.uilayer.framewrok.ClickHandler;
import com.tencent.biz.pubaccount.readinjoy.handlers.VideoHandler;
import com.tencent.biz.pubaccount.readinjoy.handlers.VideoHandler.PlayableItem;
import com.tencent.biz.pubaccount.readinjoy.struct.AdvertisementInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.BaseArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.video.VideoAutoPlayController;
import com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsHelper;
import com.tencent.biz.pubaccount.readinjoy.video.VideoPlayManager;
import com.tencent.biz.pubaccount.readinjoy.video.VideoUIManager;
import com.tencent.biz.pubaccount.readinjoy.video.report.VideoR5;
import com.tencent.biz.pubaccount.readinjoy.video.report.VideoR5.Builder;
import com.tencent.biz.pubaccount.readinjoy.video.viewholder.VideoFeedsViewHolder;
import com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyBaseAdapter;
import com.tencent.biz.pubaccount.readinjoyAd.ad.view.ReadInJoyPatchAdView;
import com.tencent.biz.pubaccount.util.ReadinJoyActionUtil;
import com.tencent.mobileqq.qroute.QRoute;
import cooperation.readinjoy.ReadInJoyHelper;

class RIJVideoHandleClick$8
  implements ClickHandler
{
  RIJVideoHandleClick$8(RIJVideoHandleClick paramRIJVideoHandleClick) {}
  
  public void onClick(View paramView)
  {
    VideoFeedsViewHolder localVideoFeedsViewHolder = (VideoFeedsViewHolder)paramView.getTag();
    BaseArticleInfo localBaseArticleInfo = RIJVideoHandleClick.a(this.a).a(localVideoFeedsViewHolder.a());
    if ((RIJVideoHandleClick.a(this.a).a().a().a() != null) && (RIJVideoHandleClick.a(this.a).a().a().a().a() != null) && (RIJVideoHandleClick.a(this.a).a().a().a().a().a())) {
      RIJVideoHandleClick.a(this.a).a().a().a().a().a(5);
    }
    int i;
    do
    {
      return;
      if (VideoFeedsHelper.a(localBaseArticleInfo, RIJVideoHandleClick.a(this.a).a().a())) {
        break;
      }
      if (AdvertisementInfo.isAdvertisementInfo(localBaseArticleInfo))
      {
        ReadinJoyActionUtil.a(RIJVideoHandleClick.a(this.a).a().a(), (ArticleInfo)localBaseArticleInfo, RIJVideoHandleClick.a(this.a).a().a(), 56, false);
        ReadinJoyActionUtil.a((Activity)RIJVideoHandleClick.a(this.a).a().a(), (ArticleInfo)localBaseArticleInfo, RIJVideoHandleClick.a(this.a).a().a(), 56, false, null);
        return;
      }
      if ((!VideoFeedsHelper.d()) || (AdvertisementInfo.isAdvertisementInfo(localBaseArticleInfo))) {
        break label400;
      }
      i = 1;
      if (((RIJVideoHandleClick.a(this.a).a().a().a()) || (ReadInJoyHelper.a(RIJQQAppInterfaceUtil.b()) <= 0)) && (i == 0)) {
        break label405;
      }
    } while (localBaseArticleInfo == null);
    if (i != 0)
    {
      String str = new VideoR5.Builder(null, null, localBaseArticleInfo.mVideoVid, localBaseArticleInfo.innerUniqueID).a((int)localBaseArticleInfo.mChannelID).N((int)RIJVideoHandleClick.a(this.a).a().a()).R(1).a().a();
      ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEvent(null, "", "0X8008E28", "0X8008E28", 0, 0, "", "", "", str, false);
    }
    RIJVideoHandleClick.a(this.a).a().a().a(localVideoFeedsViewHolder.a(), localBaseArticleInfo, false, true);
    for (;;)
    {
      VideoHandler.a(paramView);
      return;
      label400:
      i = 0;
      break;
      label405:
      RIJVideoHandleClick.a(this.a).a().a().a().c(paramView);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.decoupling.uilayer.video.click.RIJVideoHandleClick.8
 * JD-Core Version:    0.7.0.1
 */