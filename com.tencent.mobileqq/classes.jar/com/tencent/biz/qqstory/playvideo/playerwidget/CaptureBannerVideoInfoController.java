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
  private VideoLinkInfo a;
  
  private VideoLinkInfo a(StoryVideoItem paramStoryVideoItem)
  {
    VideoLinkInfo localVideoLinkInfo = paramStoryVideoItem.getOALinkInfo();
    if ((localVideoLinkInfo != null) && (localVideoLinkInfo.a != null))
    {
      SLog.b("CaptureBannerVideoInfoController", "getVideoCaptureInfo from oa");
      paramStoryVideoItem = localVideoLinkInfo;
    }
    do
    {
      do
      {
        return paramStoryVideoItem;
        localVideoLinkInfo = paramStoryVideoItem.getVideoLinkInfo();
        paramStoryVideoItem = localVideoLinkInfo;
      } while (localVideoLinkInfo == null);
      paramStoryVideoItem = localVideoLinkInfo;
    } while (localVideoLinkInfo.a == null);
    SLog.b("CaptureBannerVideoInfoController", "getVideoCaptureInfo from extern");
    return localVideoLinkInfo;
  }
  
  public Set<ActivityLifeCycle> a()
  {
    HashSet localHashSet = new HashSet(1);
    localHashSet.add(new CaptureBannerVideoInfoController.BannerActivityLifeCycle(this));
    return localHashSet;
  }
  
  public boolean a(View paramView)
  {
    if (this.jdField_a_of_type_ComTencentBizQqstoryModelItemVideoLinkInfo == null) {}
    while (!super.a(paramView)) {
      return false;
    }
    if (this.jdField_a_of_type_ComTencentBizQqstoryModelItemVideoLinkInfo.a == null)
    {
      SLog.e("CaptureBannerVideoInfoController", "mLinkInfo.captureInfo = null!");
      return false;
    }
    Object localObject = this.jdField_a_of_type_ComTencentBizQqstoryModelItemVideoLinkInfo.a.a;
    paramView = this.jdField_a_of_type_ComTencentBizQqstoryModelItemVideoLinkInfo.a.b;
    if (!TextUtils.isEmpty(paramView))
    {
      localObject = new Intent(this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerwidgetBannerVideoInfoWidget3.b(), QQBrowserActivity.class);
      ((Intent)localObject).putExtra("url", paramView);
      this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerwidgetBannerVideoInfoWidget3.b().startActivity((Intent)localObject);
      return true;
    }
    if ((!TextUtils.isEmpty((CharSequence)localObject)) && (((String)localObject).startsWith("mqqapi:")))
    {
      paramView = JumpParser.a(QQStoryContext.a(), this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerwidgetBannerVideoInfoWidget3.b(), (String)localObject);
      if (paramView != null) {
        paramView.a();
      }
      return true;
    }
    SLog.e("CaptureBannerVideoInfoController", "mLinkInfo.captureInfo.mqqapiUrl and jumpH5Url = null!");
    return false;
  }
  
  void b()
  {
    Activity localActivity = this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerwidgetBannerVideoInfoWidget3.b();
    Intent localIntent = new Intent(localActivity, SplashActivity.class);
    localIntent.putExtra("fragment_id", 1);
    localIntent.putExtra("tab_index", FrameControllerUtil.jdField_a_of_type_Int);
    localIntent.putExtra("show_story_msg_tab", true);
    localIntent.setFlags(67108864);
    localActivity.startActivity(localIntent);
  }
  
  public void b(BannerVideoInfoWidget3.BannerViewHolder paramBannerViewHolder, StoryPlayerVideoData paramStoryPlayerVideoData)
  {
    paramStoryPlayerVideoData = a(paramStoryPlayerVideoData.a());
    if (paramStoryPlayerVideoData == null)
    {
      this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerwidgetBannerVideoInfoWidget3.k();
      return;
    }
    this.jdField_a_of_type_ComTencentBizQqstoryModelItemVideoLinkInfo = paramStoryPlayerVideoData;
    this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerwidgetBannerVideoInfoWidget3.j();
    paramBannerViewHolder.b.setVisibility(0);
    paramBannerViewHolder.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
    paramBannerViewHolder.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
    if (!TextUtils.isEmpty(paramStoryPlayerVideoData.e)) {
      paramBannerViewHolder.b.setText(paramStoryPlayerVideoData.e);
    }
    for (;;)
    {
      paramBannerViewHolder.jdField_a_of_type_AndroidWidgetTextView.setText(paramStoryPlayerVideoData.b());
      paramBannerViewHolder.jdField_a_of_type_AndroidWidgetTextView.setContentDescription(null);
      if (!TextUtils.isEmpty(paramStoryPlayerVideoData.d)) {
        break;
      }
      paramBannerViewHolder.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130839756);
      return;
      paramBannerViewHolder.b.setVisibility(8);
    }
    BannerVideoInfoWidget3.a(paramStoryPlayerVideoData.d, paramBannerViewHolder.jdField_a_of_type_AndroidWidgetImageView, paramBannerViewHolder.jdField_a_of_type_AndroidGraphicsDrawableDrawable, paramBannerViewHolder.jdField_a_of_type_Int, paramBannerViewHolder.jdField_a_of_type_Int);
  }
  
  void c()
  {
    Activity localActivity = this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerwidgetBannerVideoInfoWidget3.b();
    ((QQStoryActivityManager)SuperManager.a(18)).a();
    Intent localIntent = new Intent(localActivity, QQStoryMainActivity.class);
    localIntent.setFlags(67108864);
    localActivity.startActivity(localIntent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.qqstory.playvideo.playerwidget.CaptureBannerVideoInfoController
 * JD-Core Version:    0.7.0.1
 */