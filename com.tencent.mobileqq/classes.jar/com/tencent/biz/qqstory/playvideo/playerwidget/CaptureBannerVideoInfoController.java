package com.tencent.biz.qqstory.playvideo.playerwidget;

import android.app.Activity;
import android.content.Intent;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.biz.qqstory.app.QQStoryContext;
import com.tencent.biz.qqstory.model.QQStoryActivityManager;
import com.tencent.biz.qqstory.model.SuperManager;
import com.tencent.biz.qqstory.model.item.StoryVideoItem;
import com.tencent.biz.qqstory.model.item.VideoCaptureInfo;
import com.tencent.biz.qqstory.model.item.VideoLinkInfo;
import com.tencent.biz.qqstory.playvideo.lrtbwidget.ActivityLifeCycle;
import com.tencent.biz.qqstory.playvideo.lrtbwidget.StoryPlayerVideoData;
import com.tencent.biz.qqstory.storyHome.QQStoryMainActivity;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.activity.home.impl.FrameControllerUtil;
import com.tencent.mobileqq.utils.JumpAction;
import com.tencent.mobileqq.utils.JumpParser;
import java.util.HashSet;
import java.util.Set;

public class CaptureBannerVideoInfoController
  extends BannerVideoInfoWidget3.BannerVideoInfoController
{
  private VideoLinkInfo f;
  
  private VideoLinkInfo a(StoryVideoItem paramStoryVideoItem)
  {
    VideoLinkInfo localVideoLinkInfo = paramStoryVideoItem.getOALinkInfo();
    if ((localVideoLinkInfo != null) && (localVideoLinkInfo.l != null))
    {
      SLog.b("CaptureBannerVideoInfoController", "getVideoCaptureInfo from oa");
      return localVideoLinkInfo;
    }
    paramStoryVideoItem = paramStoryVideoItem.getVideoLinkInfo();
    if ((paramStoryVideoItem != null) && (paramStoryVideoItem.l != null)) {
      SLog.b("CaptureBannerVideoInfoController", "getVideoCaptureInfo from extern");
    }
    return paramStoryVideoItem;
  }
  
  public boolean a(View paramView)
  {
    if (this.f == null) {
      return false;
    }
    if (!super.a(paramView)) {
      return false;
    }
    if (this.f.l == null)
    {
      SLog.e("CaptureBannerVideoInfoController", "mLinkInfo.captureInfo = null!");
      return false;
    }
    Object localObject = this.f.l.a;
    paramView = this.f.l.b;
    if (!TextUtils.isEmpty(paramView))
    {
      localObject = new Intent(this.a.y(), QQBrowserActivity.class);
      ((Intent)localObject).putExtra("url", paramView);
      this.a.y().startActivity((Intent)localObject);
      return true;
    }
    if ((!TextUtils.isEmpty((CharSequence)localObject)) && (((String)localObject).startsWith("mqqapi:")))
    {
      paramView = JumpParser.a(QQStoryContext.j(), this.a.y(), (String)localObject);
      if (paramView != null) {
        paramView.a();
      }
      return true;
    }
    SLog.e("CaptureBannerVideoInfoController", "mLinkInfo.captureInfo.mqqapiUrl and jumpH5Url = null!");
    return false;
  }
  
  public Set<ActivityLifeCycle> b()
  {
    HashSet localHashSet = new HashSet(1);
    localHashSet.add(new CaptureBannerVideoInfoController.BannerActivityLifeCycle(this));
    return localHashSet;
  }
  
  public void b(BannerVideoInfoWidget3.BannerViewHolder paramBannerViewHolder, StoryPlayerVideoData paramStoryPlayerVideoData)
  {
    paramStoryPlayerVideoData = a(paramStoryPlayerVideoData.e());
    if (paramStoryPlayerVideoData == null)
    {
      this.a.A();
      return;
    }
    this.f = paramStoryPlayerVideoData;
    this.a.z();
    paramBannerViewHolder.d.setVisibility(0);
    paramBannerViewHolder.c.setVisibility(0);
    paramBannerViewHolder.b.setVisibility(0);
    if (!TextUtils.isEmpty(paramStoryPlayerVideoData.f)) {
      paramBannerViewHolder.d.setText(paramStoryPlayerVideoData.f);
    } else {
      paramBannerViewHolder.d.setVisibility(8);
    }
    paramBannerViewHolder.c.setText(paramStoryPlayerVideoData.b());
    paramBannerViewHolder.c.setContentDescription(null);
    if (TextUtils.isEmpty(paramStoryPlayerVideoData.e))
    {
      paramBannerViewHolder.b.setImageResource(2130840079);
      return;
    }
    BannerVideoInfoWidget3.a(paramStoryPlayerVideoData.e, paramBannerViewHolder.b, paramBannerViewHolder.h, paramBannerViewHolder.g, paramBannerViewHolder.g);
  }
  
  void d()
  {
    Activity localActivity = this.a.y();
    Intent localIntent = new Intent(localActivity, SplashActivity.class);
    localIntent.putExtra("fragment_id", 1);
    localIntent.putExtra("tab_index", FrameControllerUtil.a);
    localIntent.putExtra("show_story_msg_tab", true);
    localIntent.setFlags(67108864);
    localActivity.startActivity(localIntent);
  }
  
  void e()
  {
    Activity localActivity = this.a.y();
    ((QQStoryActivityManager)SuperManager.a(18)).c();
    Intent localIntent = new Intent(localActivity, QQStoryMainActivity.class);
    localIntent.setFlags(67108864);
    localActivity.startActivity(localIntent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.playvideo.playerwidget.CaptureBannerVideoInfoController
 * JD-Core Version:    0.7.0.1
 */