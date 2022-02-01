package com.tencent.biz.qqstory.playvideo.playerwidget;

import android.app.Dialog;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.biz.qqstory.model.item.StoryVideoItem;
import com.tencent.biz.qqstory.model.item.VideoLinkInfo;
import com.tencent.biz.qqstory.playvideo.lrtbwidget.StoryPlayerGroupHolder;
import com.tencent.biz.qqstory.playvideo.lrtbwidget.StoryPlayerVideoData;
import com.tencent.biz.qqstory.playvideo.lrtbwidget.VideoViewVideoHolder;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.biz.qqstory.support.report.StoryReportor;
import com.tencent.biz.qqstory.utils.WeishiGuideUtils;
import com.tencent.biz.qqstory.view.WeShiGuideDialog;
import com.tribe.async.dispatch.Subscriber;
import java.util.HashMap;
import java.util.Map;

public class WeiShiFlowBannerVideoInfoController
  extends BannerVideoInfoWidget3.BannerVideoInfoController
{
  private StoryPlayerVideoData f;
  private VideoLinkInfo g;
  private boolean h = false;
  private String i = "";
  
  public Map<Subscriber, String> a()
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put(new WeiShiFlowBannerVideoInfoController.GetStoryTagInfoReceiver(this), "");
    return localHashMap;
  }
  
  public boolean a(View paramView)
  {
    if (!super.a(paramView)) {
      return false;
    }
    paramView = this.f;
    if (paramView == null) {
      return false;
    }
    StoryVideoItem localStoryVideoItem = paramView.e();
    paramView = WeShiGuideDialog.a(this.a.y(), localStoryVideoItem.mOwnerUid, "4", localStoryVideoItem.mVid, 3, localStoryVideoItem.mWsSchema);
    VideoViewVideoHolder localVideoViewVideoHolder = ((StoryPlayerGroupHolder)this.a.d()).r();
    if (paramView != null)
    {
      if (localVideoViewVideoHolder != null) {
        localVideoViewVideoHolder.c(true);
      }
      paramView.setOnDismissListener(new WeiShiFlowBannerVideoInfoController.1(this, localVideoViewVideoHolder));
    }
    if (WeishiGuideUtils.a(this.a.y())) {
      paramView = "1";
    } else {
      paramView = "2";
    }
    StoryReportor.a("weishi_share", "link_click", 0, 0, new String[] { paramView, localStoryVideoItem.mOwnerUid, "", localStoryVideoItem.mVid });
    return true;
  }
  
  public void b(BannerVideoInfoWidget3.BannerViewHolder paramBannerViewHolder, StoryPlayerVideoData paramStoryPlayerVideoData)
  {
    this.f = paramStoryPlayerVideoData;
    StoryVideoItem localStoryVideoItem = paramStoryPlayerVideoData.e();
    this.g = localStoryVideoItem.getOALinkInfo();
    Object localObject = this.g;
    if ((localObject != null) && (((VideoLinkInfo)localObject).a == 6))
    {
      this.a.z();
      if (TextUtils.equals(this.i, paramStoryPlayerVideoData.b))
      {
        this.h = false;
      }
      else
      {
        this.h = true;
        this.i = paramStoryPlayerVideoData.b;
      }
      paramStoryPlayerVideoData = this.g.c;
      localObject = this.g.d;
      String str = this.g.e;
      SLog.a("WeiShiFlowBannerVideoInfoController", "WeiShiFlowBannerVideoInfoController doOnBind, title:%s, body:%s, picUrl:%s", paramStoryPlayerVideoData, localObject, str);
      paramBannerViewHolder.b.setVisibility(0);
      paramBannerViewHolder.d.setVisibility(0);
      paramBannerViewHolder.d.setTypeface(null, 0);
      paramBannerViewHolder.c.setVisibility(0);
      BannerVideoInfoWidget3.a(str, paramBannerViewHolder.b, paramBannerViewHolder.h, paramBannerViewHolder.g, paramBannerViewHolder.g);
      paramBannerViewHolder.d.setText(paramStoryPlayerVideoData);
      paramBannerViewHolder.c.setText((CharSequence)localObject);
      if (this.h) {
        StoryReportor.a("weishi_share", "link_exp", 0, 0, new String[] { "", localStoryVideoItem.mOwnerUid, "", localStoryVideoItem.mVid });
      }
      return;
    }
    this.a.A();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.playvideo.playerwidget.WeiShiFlowBannerVideoInfoController
 * JD-Core Version:    0.7.0.1
 */