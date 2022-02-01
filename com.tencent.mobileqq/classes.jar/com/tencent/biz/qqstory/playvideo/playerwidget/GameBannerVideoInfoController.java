package com.tencent.biz.qqstory.playvideo.playerwidget;

import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.aelight.camera.util.api.IQIMShortVideoUtil;
import com.tencent.biz.qqstory.model.SuperManager;
import com.tencent.biz.qqstory.model.UserManager;
import com.tencent.biz.qqstory.model.item.QQUserUIItem;
import com.tencent.biz.qqstory.model.item.StoryVideoItem;
import com.tencent.biz.qqstory.model.item.VideoGameInfo;
import com.tencent.biz.qqstory.model.item.VideoLinkGameInfo;
import com.tencent.biz.qqstory.model.item.VideoLinkInfo;
import com.tencent.biz.qqstory.playvideo.lrtbwidget.ActivityLifeCycle;
import com.tencent.biz.qqstory.playvideo.lrtbwidget.StoryPlayerVideoData;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.biz.qqstory.support.report.StoryReportor;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.qroute.QRoute;
import java.util.HashSet;
import java.util.Set;

public class GameBannerVideoInfoController
  extends BannerVideoInfoWidget3.BannerVideoInfoController
{
  private StoryPlayerVideoData f;
  private String g;
  private boolean h = false;
  private String i = "";
  
  private VideoLinkGameInfo a(StoryVideoItem paramStoryVideoItem)
  {
    VideoLinkInfo localVideoLinkInfo = paramStoryVideoItem.getOALinkInfo();
    if ((localVideoLinkInfo != null) && (localVideoLinkInfo.i != null))
    {
      SLog.b("GameBannerVideoInfoBuilder", "parse game link info from oa");
      return paramStoryVideoItem.getOALinkInfo().i;
    }
    SLog.b("GameBannerVideoInfoBuilder", "parse game link info from extern");
    return paramStoryVideoItem.getVideoLinkInfo().i;
  }
  
  public boolean a(View paramView)
  {
    if (!super.a(paramView)) {
      return false;
    }
    paramView = this.f;
    if ((paramView != null) && (paramView.e().isGameVideo())) {
      StoryReportor.a("video_game", "clk_url", 0, 0, new String[] { "", "", this.g, this.f.e().mVid });
    }
    return true;
  }
  
  public Set<ActivityLifeCycle> b()
  {
    HashSet localHashSet = new HashSet(1);
    localHashSet.add(new GameBannerVideoInfoController.BannerActivityLifeCycle(this));
    return localHashSet;
  }
  
  public void b(BannerVideoInfoWidget3.BannerViewHolder paramBannerViewHolder, StoryPlayerVideoData paramStoryPlayerVideoData)
  {
    this.f = paramStoryPlayerVideoData;
    Object localObject2 = paramStoryPlayerVideoData.e();
    Object localObject1 = a((StoryVideoItem)localObject2);
    this.a.A();
    localObject2 = ((StoryVideoItem)localObject2).getVideoGameInfo();
    if (localObject2 != null) {
      this.g = ((VideoGameInfo)localObject2).b;
    }
    paramBannerViewHolder.f.setVisibility(0);
    paramBannerViewHolder.c.setVisibility(0);
    paramBannerViewHolder.b.setVisibility(0);
    paramBannerViewHolder.a.setBackgroundResource(2130840075);
    paramBannerViewHolder.a.setPadding(paramBannerViewHolder.a.getPaddingLeft(), paramBannerViewHolder.a.getPaddingTop(), paramBannerViewHolder.a.getPaddingRight(), paramBannerViewHolder.a.getPaddingBottom());
    Object localObject3 = ((UserManager)SuperManager.a(2)).b(paramStoryPlayerVideoData.e().mOwnerUid);
    String str;
    if ((localObject3 != null) && (((QQUserUIItem)localObject3).isMe()))
    {
      localObject2 = ((VideoLinkGameInfo)localObject1).d;
      str = ((VideoLinkGameInfo)localObject1).e;
      localObject1 = ((VideoLinkGameInfo)localObject1).f;
    }
    else
    {
      localObject2 = ((VideoLinkGameInfo)localObject1).a;
      str = ((VideoLinkGameInfo)localObject1).b;
      if ((localObject3 != null) && (((QQUserUIItem)localObject3).isFriend())) {
        localObject1 = ((VideoLinkGameInfo)localObject1).c;
      } else {
        localObject1 = HardCodeUtil.a(2131903006);
      }
    }
    localObject3 = paramBannerViewHolder.f;
    if (TextUtils.isEmpty((CharSequence)localObject1)) {
      localObject1 = HardCodeUtil.a(2131903005);
    }
    ((TextView)localObject3).setText((CharSequence)localObject1);
    BannerVideoInfoWidget3.a((String)localObject2, paramBannerViewHolder.b, paramBannerViewHolder.h, paramBannerViewHolder.g, paramBannerViewHolder.g);
    paramBannerViewHolder.c.setText(str);
    paramBannerViewHolder.c.setTextColor(-1);
    if (TextUtils.equals(this.i, paramStoryPlayerVideoData.b))
    {
      this.h = false;
    }
    else
    {
      this.h = true;
      if (!((IQIMShortVideoUtil)QRoute.api(IQIMShortVideoUtil.class)).isPeakAlive(this.a.y())) {
        ((IQIMShortVideoUtil)QRoute.api(IQIMShortVideoUtil.class)).preLoadPeakProcess(this.a.y());
      }
      this.i = paramStoryPlayerVideoData.b;
    }
    if (this.h) {
      StoryReportor.a("video_game", "exp_url", 0, 0, new String[] { "", "", this.g, this.f.e().mVid });
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.playvideo.playerwidget.GameBannerVideoInfoController
 * JD-Core Version:    0.7.0.1
 */