package com.tencent.biz.qqstory.playvideo.playerwidget;

import android.app.Activity;
import android.content.Intent;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.biz.qqstory.app.QQStoryContext;
import com.tencent.biz.qqstory.model.item.StoryVideoItem;
import com.tencent.biz.qqstory.model.item.VideoLinkInfo;
import com.tencent.biz.qqstory.playvideo.lrtbwidget.StoryPlayerVideoData;
import com.tencent.biz.qqstory.support.report.StoryReportor;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.utils.JumpAction;
import com.tencent.mobileqq.utils.JumpParser;
import com.tribe.async.dispatch.Subscriber;
import java.util.HashMap;
import java.util.Map;

public class LinkVideoInfoController
  extends BannerVideoInfoWidget3.BannerVideoInfoController
{
  private StoryPlayerVideoData f;
  private VideoLinkInfo g;
  private boolean h = false;
  private String i = "";
  
  public Map<Subscriber, String> a()
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put(new LinkVideoInfoController.StoryVideoPublishStatusReceiver(this), "");
    return localHashMap;
  }
  
  public boolean a(View paramView)
  {
    VideoLinkInfo localVideoLinkInfo = this.g;
    if (localVideoLinkInfo != null)
    {
      if (localVideoLinkInfo.a != 1) {
        return false;
      }
      if (!super.a(paramView)) {
        return false;
      }
      if (this.g.b.startsWith("mqqapi:"))
      {
        paramView = JumpParser.a(QQStoryContext.j(), this.a.y(), this.g.b);
        if (paramView != null) {
          paramView.a();
        }
        return true;
      }
      paramView = new Intent(this.a.y(), QQBrowserActivity.class);
      paramView.putExtra("url", this.g.a());
      this.a.y().startActivity(paramView);
      if (TextUtils.isEmpty(this.g.e)) {
        paramView = "2";
      } else {
        paramView = "1";
      }
      StoryReportor.a("play_video", "clk_linkbar", 0, 0, new String[] { paramView, "", "", this.i });
      return true;
    }
    return false;
  }
  
  public void b(BannerVideoInfoWidget3.BannerViewHolder paramBannerViewHolder, StoryPlayerVideoData paramStoryPlayerVideoData)
  {
    this.f = paramStoryPlayerVideoData;
    StoryVideoItem localStoryVideoItem = paramStoryPlayerVideoData.e();
    VideoLinkInfo localVideoLinkInfo = localStoryVideoItem.getVideoLinkInfo();
    if ((localVideoLinkInfo != null) && (localVideoLinkInfo.a == 1))
    {
      if (TextUtils.equals(this.i, paramStoryPlayerVideoData.b))
      {
        this.h = false;
      }
      else
      {
        this.h = true;
        this.i = paramStoryPlayerVideoData.b;
      }
      this.g = localVideoLinkInfo;
      this.a.z();
      paramBannerViewHolder.d.setVisibility(0);
      paramBannerViewHolder.c.setVisibility(0);
      paramBannerViewHolder.b.setVisibility(0);
      if (!TextUtils.isEmpty(localVideoLinkInfo.f)) {
        paramBannerViewHolder.d.setText(localVideoLinkInfo.f);
      } else {
        paramBannerViewHolder.d.setVisibility(8);
      }
      paramBannerViewHolder.c.setText(localVideoLinkInfo.b());
      paramBannerViewHolder.c.setContentDescription(null);
      if ((localVideoLinkInfo.g == 1) && (localStoryVideoItem.isUploading()))
      {
        paramBannerViewHolder.b.setImageResource(2130848414);
        return;
      }
      if (TextUtils.isEmpty(localVideoLinkInfo.e))
      {
        paramBannerViewHolder.b.setImageResource(2130840079);
        return;
      }
      BannerVideoInfoWidget3.a(localVideoLinkInfo.e, paramBannerViewHolder.b, paramBannerViewHolder.h, paramBannerViewHolder.g, paramBannerViewHolder.g);
      return;
    }
    this.a.A();
    this.f = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.playvideo.playerwidget.LinkVideoInfoController
 * JD-Core Version:    0.7.0.1
 */