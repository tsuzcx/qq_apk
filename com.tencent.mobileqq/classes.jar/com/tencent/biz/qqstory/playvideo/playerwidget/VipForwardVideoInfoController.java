package com.tencent.biz.qqstory.playvideo.playerwidget;

import android.app.Activity;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.biz.qqstory.model.SuperManager;
import com.tencent.biz.qqstory.model.UserManager;
import com.tencent.biz.qqstory.model.item.QQUserUIItem;
import com.tencent.biz.qqstory.model.item.StoryVideoItem;
import com.tencent.biz.qqstory.model.item.VideoLinkInfo;
import com.tencent.biz.qqstory.model.item.VideoLinkInfo.VipFrwrdLinkInfo;
import com.tencent.biz.qqstory.playvideo.StoryPlayerLauncher;
import com.tencent.biz.qqstory.playvideo.lrtbwidget.StoryPlayerVideoData;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.biz.qqstory.support.report.StoryReportor;

public class VipForwardVideoInfoController
  extends BannerVideoInfoWidget3.BannerVideoInfoController
{
  private StoryPlayerVideoData f;
  private VideoLinkInfo g;
  private boolean h = false;
  private String i = "";
  
  private void a(QQUserUIItem paramQQUserUIItem, BannerVideoInfoWidget3.BannerViewHolder paramBannerViewHolder)
  {
    paramBannerViewHolder.d.setVisibility(8);
    paramBannerViewHolder.e.setVisibility(0);
    String str = paramQQUserUIItem.headUrl;
    paramQQUserUIItem = paramQQUserUIItem.nickName;
    paramBannerViewHolder.c.setVisibility(0);
    paramBannerViewHolder.c.setText(this.a.y().getString(2131897377, new Object[] { paramQQUserUIItem }));
    paramBannerViewHolder.c.setContentDescription(null);
    paramBannerViewHolder.b.setVisibility(0);
    BannerVideoInfoWidget3.a(str, paramBannerViewHolder.b, paramBannerViewHolder.h, paramBannerViewHolder.g, paramBannerViewHolder.g);
    SLog.a("VipForwardVideoInfoController", "updateUI, nickName:%s,  avatarURL:%s", paramQQUserUIItem, str);
  }
  
  public boolean a(View paramView)
  {
    VideoLinkInfo localVideoLinkInfo = this.g;
    if ((localVideoLinkInfo != null) && (localVideoLinkInfo.a == 5) && (this.g.h != null))
    {
      if (!super.a(paramView)) {
        return false;
      }
      StoryPlayerLauncher.a(this.a.y(), this.g.h.c, this.g.h.b, 1010);
      StoryReportor.a("play_video", "clk_transmit", 0, 0, new String[0]);
      return true;
    }
    this.a.A();
    return false;
  }
  
  public void b(BannerVideoInfoWidget3.BannerViewHolder paramBannerViewHolder, StoryPlayerVideoData paramStoryPlayerVideoData)
  {
    SLog.a("VipForwardVideoInfoController", "doOnBind, forward video:%s", paramStoryPlayerVideoData.b);
    this.f = paramStoryPlayerVideoData;
    Object localObject = paramStoryPlayerVideoData.e().getVideoLinkInfo();
    if ((localObject != null) && (((VideoLinkInfo)localObject).a == 5) && (((VideoLinkInfo)localObject).h != null))
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
      this.g = ((VideoLinkInfo)localObject);
      paramStoryPlayerVideoData = (UserManager)SuperManager.a(2);
      localObject = paramStoryPlayerVideoData.b(this.g.h.a);
      if ((localObject != null) && (!TextUtils.isEmpty(((QQUserUIItem)localObject).nickName)))
      {
        this.a.z();
        a((QQUserUIItem)localObject, paramBannerViewHolder);
        return;
      }
      this.a.A();
      paramStoryPlayerVideoData.a(this.g.h.a, new VipForwardVideoInfoController.1(this, paramBannerViewHolder));
      return;
    }
    SLog.b("VipForwardVideoInfoController", "something error, hide()");
    this.a.A();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.playvideo.playerwidget.VipForwardVideoInfoController
 * JD-Core Version:    0.7.0.1
 */