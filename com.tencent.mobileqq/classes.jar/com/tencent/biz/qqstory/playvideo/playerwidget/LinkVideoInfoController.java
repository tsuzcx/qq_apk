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
  private VideoLinkInfo jdField_a_of_type_ComTencentBizQqstoryModelItemVideoLinkInfo;
  private StoryPlayerVideoData jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetStoryPlayerVideoData;
  private String jdField_a_of_type_JavaLangString = "";
  private boolean c = false;
  
  public Map<Subscriber, String> a()
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put(new LinkVideoInfoController.StoryVideoPublishStatusReceiver(this), "");
    return localHashMap;
  }
  
  public boolean a(View paramView)
  {
    if ((this.jdField_a_of_type_ComTencentBizQqstoryModelItemVideoLinkInfo == null) || (this.jdField_a_of_type_ComTencentBizQqstoryModelItemVideoLinkInfo.jdField_a_of_type_Int != 1)) {
      return false;
    }
    if (!super.a(paramView)) {
      return false;
    }
    if (this.jdField_a_of_type_ComTencentBizQqstoryModelItemVideoLinkInfo.jdField_a_of_type_JavaLangString.startsWith("mqqapi:"))
    {
      paramView = JumpParser.a(QQStoryContext.a(), this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerwidgetBannerVideoInfoWidget3.b(), this.jdField_a_of_type_ComTencentBizQqstoryModelItemVideoLinkInfo.jdField_a_of_type_JavaLangString);
      if (paramView != null) {
        paramView.a();
      }
      return true;
    }
    paramView = new Intent(this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerwidgetBannerVideoInfoWidget3.b(), QQBrowserActivity.class);
    paramView.putExtra("url", this.jdField_a_of_type_ComTencentBizQqstoryModelItemVideoLinkInfo.a());
    this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerwidgetBannerVideoInfoWidget3.b().startActivity(paramView);
    if (TextUtils.isEmpty(this.jdField_a_of_type_ComTencentBizQqstoryModelItemVideoLinkInfo.d)) {}
    for (paramView = "2";; paramView = "1")
    {
      StoryReportor.a("play_video", "clk_linkbar", 0, 0, new String[] { paramView, "", "", this.jdField_a_of_type_JavaLangString });
      return true;
    }
  }
  
  public void b(BannerVideoInfoWidget3.BannerViewHolder paramBannerViewHolder, StoryPlayerVideoData paramStoryPlayerVideoData)
  {
    this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetStoryPlayerVideoData = paramStoryPlayerVideoData;
    StoryVideoItem localStoryVideoItem = paramStoryPlayerVideoData.a();
    VideoLinkInfo localVideoLinkInfo = localStoryVideoItem.getVideoLinkInfo();
    if ((localVideoLinkInfo == null) || (localVideoLinkInfo.jdField_a_of_type_Int != 1))
    {
      this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerwidgetBannerVideoInfoWidget3.k();
      this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetStoryPlayerVideoData = null;
      return;
    }
    if (TextUtils.equals(this.jdField_a_of_type_JavaLangString, paramStoryPlayerVideoData.jdField_a_of_type_JavaLangString))
    {
      this.c = false;
      this.jdField_a_of_type_ComTencentBizQqstoryModelItemVideoLinkInfo = localVideoLinkInfo;
      this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerwidgetBannerVideoInfoWidget3.j();
      paramBannerViewHolder.b.setVisibility(0);
      paramBannerViewHolder.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
      paramBannerViewHolder.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
      if (TextUtils.isEmpty(localVideoLinkInfo.e)) {
        break label184;
      }
      paramBannerViewHolder.b.setText(localVideoLinkInfo.e);
    }
    for (;;)
    {
      paramBannerViewHolder.jdField_a_of_type_AndroidWidgetTextView.setText(localVideoLinkInfo.b());
      paramBannerViewHolder.jdField_a_of_type_AndroidWidgetTextView.setContentDescription(null);
      if ((localVideoLinkInfo.b != 1) || (!localStoryVideoItem.isUploading())) {
        break label196;
      }
      paramBannerViewHolder.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130846984);
      return;
      this.c = true;
      this.jdField_a_of_type_JavaLangString = paramStoryPlayerVideoData.jdField_a_of_type_JavaLangString;
      break;
      label184:
      paramBannerViewHolder.b.setVisibility(8);
    }
    label196:
    if (TextUtils.isEmpty(localVideoLinkInfo.d))
    {
      paramBannerViewHolder.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130839756);
      return;
    }
    BannerVideoInfoWidget3.a(localVideoLinkInfo.d, paramBannerViewHolder.jdField_a_of_type_AndroidWidgetImageView, paramBannerViewHolder.jdField_a_of_type_AndroidGraphicsDrawableDrawable, paramBannerViewHolder.jdField_a_of_type_Int, paramBannerViewHolder.jdField_a_of_type_Int);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.qqstory.playvideo.playerwidget.LinkVideoInfoController
 * JD-Core Version:    0.7.0.1
 */