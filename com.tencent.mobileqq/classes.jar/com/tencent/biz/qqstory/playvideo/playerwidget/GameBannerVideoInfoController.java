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
  private StoryPlayerVideoData jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetStoryPlayerVideoData;
  private String jdField_a_of_type_JavaLangString;
  private String b = "";
  private boolean c = false;
  
  private VideoLinkGameInfo a(StoryVideoItem paramStoryVideoItem)
  {
    VideoLinkInfo localVideoLinkInfo = paramStoryVideoItem.getOALinkInfo();
    if ((localVideoLinkInfo != null) && (localVideoLinkInfo.a != null))
    {
      SLog.b("GameBannerVideoInfoBuilder", "parse game link info from oa");
      return paramStoryVideoItem.getOALinkInfo().a;
    }
    SLog.b("GameBannerVideoInfoBuilder", "parse game link info from extern");
    return paramStoryVideoItem.getVideoLinkInfo().a;
  }
  
  public Set<ActivityLifeCycle> a()
  {
    HashSet localHashSet = new HashSet(1);
    localHashSet.add(new GameBannerVideoInfoController.BannerActivityLifeCycle(this));
    return localHashSet;
  }
  
  public boolean a(View paramView)
  {
    if (!super.a(paramView)) {
      return false;
    }
    paramView = this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetStoryPlayerVideoData;
    if ((paramView != null) && (paramView.a().isGameVideo())) {
      StoryReportor.a("video_game", "clk_url", 0, 0, new String[] { "", "", this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetStoryPlayerVideoData.a().mVid });
    }
    return true;
  }
  
  public void b(BannerVideoInfoWidget3.BannerViewHolder paramBannerViewHolder, StoryPlayerVideoData paramStoryPlayerVideoData)
  {
    this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetStoryPlayerVideoData = paramStoryPlayerVideoData;
    Object localObject2 = paramStoryPlayerVideoData.a();
    Object localObject1 = a((StoryVideoItem)localObject2);
    this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerwidgetBannerVideoInfoWidget3.k();
    localObject2 = ((StoryVideoItem)localObject2).getVideoGameInfo();
    if (localObject2 != null) {
      this.jdField_a_of_type_JavaLangString = ((VideoGameInfo)localObject2).jdField_a_of_type_JavaLangString;
    }
    paramBannerViewHolder.c.setVisibility(0);
    paramBannerViewHolder.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
    paramBannerViewHolder.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
    paramBannerViewHolder.jdField_a_of_type_AndroidViewView.setBackgroundResource(2130839610);
    paramBannerViewHolder.jdField_a_of_type_AndroidViewView.setPadding(paramBannerViewHolder.jdField_a_of_type_AndroidViewView.getPaddingLeft(), paramBannerViewHolder.jdField_a_of_type_AndroidViewView.getPaddingTop(), paramBannerViewHolder.jdField_a_of_type_AndroidViewView.getPaddingRight(), paramBannerViewHolder.jdField_a_of_type_AndroidViewView.getPaddingBottom());
    Object localObject3 = ((UserManager)SuperManager.a(2)).b(paramStoryPlayerVideoData.a().mOwnerUid);
    String str;
    if ((localObject3 != null) && (((QQUserUIItem)localObject3).isMe()))
    {
      localObject2 = ((VideoLinkGameInfo)localObject1).d;
      str = ((VideoLinkGameInfo)localObject1).e;
      localObject1 = ((VideoLinkGameInfo)localObject1).f;
    }
    else
    {
      localObject2 = ((VideoLinkGameInfo)localObject1).jdField_a_of_type_JavaLangString;
      str = ((VideoLinkGameInfo)localObject1).b;
      if ((localObject3 != null) && (((QQUserUIItem)localObject3).isFriend())) {
        localObject1 = ((VideoLinkGameInfo)localObject1).c;
      } else {
        localObject1 = HardCodeUtil.a(2131705116);
      }
    }
    localObject3 = paramBannerViewHolder.c;
    if (TextUtils.isEmpty((CharSequence)localObject1)) {
      localObject1 = HardCodeUtil.a(2131705115);
    }
    ((TextView)localObject3).setText((CharSequence)localObject1);
    BannerVideoInfoWidget3.a((String)localObject2, paramBannerViewHolder.jdField_a_of_type_AndroidWidgetImageView, paramBannerViewHolder.jdField_a_of_type_AndroidGraphicsDrawableDrawable, paramBannerViewHolder.jdField_a_of_type_Int, paramBannerViewHolder.jdField_a_of_type_Int);
    paramBannerViewHolder.jdField_a_of_type_AndroidWidgetTextView.setText(str);
    paramBannerViewHolder.jdField_a_of_type_AndroidWidgetTextView.setTextColor(-1);
    if (TextUtils.equals(this.b, paramStoryPlayerVideoData.jdField_a_of_type_JavaLangString))
    {
      this.c = false;
    }
    else
    {
      this.c = true;
      if (!((IQIMShortVideoUtil)QRoute.api(IQIMShortVideoUtil.class)).isPeakAlive(this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerwidgetBannerVideoInfoWidget3.b())) {
        ((IQIMShortVideoUtil)QRoute.api(IQIMShortVideoUtil.class)).preLoadPeakProcess(this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerwidgetBannerVideoInfoWidget3.b());
      }
      this.b = paramStoryPlayerVideoData.jdField_a_of_type_JavaLangString;
    }
    if (this.c) {
      StoryReportor.a("video_game", "exp_url", 0, 0, new String[] { "", "", this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetStoryPlayerVideoData.a().mVid });
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.playvideo.playerwidget.GameBannerVideoInfoController
 * JD-Core Version:    0.7.0.1
 */