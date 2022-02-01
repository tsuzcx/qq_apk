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
  private VideoLinkInfo jdField_a_of_type_ComTencentBizQqstoryModelItemVideoLinkInfo;
  private StoryPlayerVideoData jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetStoryPlayerVideoData;
  private String jdField_a_of_type_JavaLangString = "";
  private boolean c = false;
  
  private void a(QQUserUIItem paramQQUserUIItem, BannerVideoInfoWidget3.BannerViewHolder paramBannerViewHolder)
  {
    paramBannerViewHolder.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
    paramBannerViewHolder.jdField_b_of_type_AndroidWidgetImageView.setVisibility(0);
    String str = paramQQUserUIItem.headUrl;
    paramQQUserUIItem = paramQQUserUIItem.nickName;
    paramBannerViewHolder.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
    paramBannerViewHolder.jdField_a_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerwidgetBannerVideoInfoWidget3.b().getString(2131699360, new Object[] { paramQQUserUIItem }));
    paramBannerViewHolder.jdField_a_of_type_AndroidWidgetTextView.setContentDescription(null);
    paramBannerViewHolder.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
    BannerVideoInfoWidget3.a(str, paramBannerViewHolder.jdField_a_of_type_AndroidWidgetImageView, paramBannerViewHolder.jdField_a_of_type_AndroidGraphicsDrawableDrawable, paramBannerViewHolder.jdField_a_of_type_Int, paramBannerViewHolder.jdField_a_of_type_Int);
    SLog.a("VipForwardVideoInfoController", "updateUI, nickName:%s,  avatarURL:%s", paramQQUserUIItem, str);
  }
  
  public boolean a(View paramView)
  {
    VideoLinkInfo localVideoLinkInfo = this.jdField_a_of_type_ComTencentBizQqstoryModelItemVideoLinkInfo;
    if ((localVideoLinkInfo != null) && (localVideoLinkInfo.jdField_a_of_type_Int == 5) && (this.jdField_a_of_type_ComTencentBizQqstoryModelItemVideoLinkInfo.jdField_a_of_type_ComTencentBizQqstoryModelItemVideoLinkInfo$VipFrwrdLinkInfo != null))
    {
      if (!super.a(paramView)) {
        return false;
      }
      StoryPlayerLauncher.a(this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerwidgetBannerVideoInfoWidget3.b(), this.jdField_a_of_type_ComTencentBizQqstoryModelItemVideoLinkInfo.jdField_a_of_type_ComTencentBizQqstoryModelItemVideoLinkInfo$VipFrwrdLinkInfo.c, this.jdField_a_of_type_ComTencentBizQqstoryModelItemVideoLinkInfo.jdField_a_of_type_ComTencentBizQqstoryModelItemVideoLinkInfo$VipFrwrdLinkInfo.b, 1010);
      StoryReportor.a("play_video", "clk_transmit", 0, 0, new String[0]);
      return true;
    }
    this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerwidgetBannerVideoInfoWidget3.k();
    return false;
  }
  
  public void b(BannerVideoInfoWidget3.BannerViewHolder paramBannerViewHolder, StoryPlayerVideoData paramStoryPlayerVideoData)
  {
    SLog.a("VipForwardVideoInfoController", "doOnBind, forward video:%s", paramStoryPlayerVideoData.jdField_a_of_type_JavaLangString);
    this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetStoryPlayerVideoData = paramStoryPlayerVideoData;
    Object localObject = paramStoryPlayerVideoData.a().getVideoLinkInfo();
    if ((localObject != null) && (((VideoLinkInfo)localObject).jdField_a_of_type_Int == 5) && (((VideoLinkInfo)localObject).jdField_a_of_type_ComTencentBizQqstoryModelItemVideoLinkInfo$VipFrwrdLinkInfo != null))
    {
      if (TextUtils.equals(this.jdField_a_of_type_JavaLangString, paramStoryPlayerVideoData.jdField_a_of_type_JavaLangString))
      {
        this.c = false;
      }
      else
      {
        this.c = true;
        this.jdField_a_of_type_JavaLangString = paramStoryPlayerVideoData.jdField_a_of_type_JavaLangString;
      }
      this.jdField_a_of_type_ComTencentBizQqstoryModelItemVideoLinkInfo = ((VideoLinkInfo)localObject);
      paramStoryPlayerVideoData = (UserManager)SuperManager.a(2);
      localObject = paramStoryPlayerVideoData.b(this.jdField_a_of_type_ComTencentBizQqstoryModelItemVideoLinkInfo.jdField_a_of_type_ComTencentBizQqstoryModelItemVideoLinkInfo$VipFrwrdLinkInfo.jdField_a_of_type_JavaLangString);
      if ((localObject != null) && (!TextUtils.isEmpty(((QQUserUIItem)localObject).nickName)))
      {
        this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerwidgetBannerVideoInfoWidget3.j();
        a((QQUserUIItem)localObject, paramBannerViewHolder);
        return;
      }
      this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerwidgetBannerVideoInfoWidget3.k();
      paramStoryPlayerVideoData.a(this.jdField_a_of_type_ComTencentBizQqstoryModelItemVideoLinkInfo.jdField_a_of_type_ComTencentBizQqstoryModelItemVideoLinkInfo$VipFrwrdLinkInfo.jdField_a_of_type_JavaLangString, new VipForwardVideoInfoController.1(this, paramBannerViewHolder));
      return;
    }
    SLog.b("VipForwardVideoInfoController", "something error, hide()");
    this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerwidgetBannerVideoInfoWidget3.k();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.playvideo.playerwidget.VipForwardVideoInfoController
 * JD-Core Version:    0.7.0.1
 */