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
  private VideoLinkInfo jdField_a_of_type_ComTencentBizQqstoryModelItemVideoLinkInfo;
  private StoryPlayerVideoData jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetStoryPlayerVideoData;
  private String jdField_a_of_type_JavaLangString = "";
  private boolean c = false;
  
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
    paramView = this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetStoryPlayerVideoData;
    if (paramView == null) {
      return false;
    }
    StoryVideoItem localStoryVideoItem = paramView.a();
    paramView = WeShiGuideDialog.a(this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerwidgetBannerVideoInfoWidget3.b(), localStoryVideoItem.mOwnerUid, "4", localStoryVideoItem.mVid, 3, localStoryVideoItem.mWsSchema);
    VideoViewVideoHolder localVideoViewVideoHolder = ((StoryPlayerGroupHolder)this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerwidgetBannerVideoInfoWidget3.a()).a();
    if (paramView != null)
    {
      if (localVideoViewVideoHolder != null) {
        localVideoViewVideoHolder.c(true);
      }
      paramView.setOnDismissListener(new WeiShiFlowBannerVideoInfoController.1(this, localVideoViewVideoHolder));
    }
    if (WeishiGuideUtils.a(this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerwidgetBannerVideoInfoWidget3.b())) {
      paramView = "1";
    } else {
      paramView = "2";
    }
    StoryReportor.a("weishi_share", "link_click", 0, 0, new String[] { paramView, localStoryVideoItem.mOwnerUid, "", localStoryVideoItem.mVid });
    return true;
  }
  
  public void b(BannerVideoInfoWidget3.BannerViewHolder paramBannerViewHolder, StoryPlayerVideoData paramStoryPlayerVideoData)
  {
    this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetStoryPlayerVideoData = paramStoryPlayerVideoData;
    StoryVideoItem localStoryVideoItem = paramStoryPlayerVideoData.a();
    this.jdField_a_of_type_ComTencentBizQqstoryModelItemVideoLinkInfo = localStoryVideoItem.getOALinkInfo();
    Object localObject = this.jdField_a_of_type_ComTencentBizQqstoryModelItemVideoLinkInfo;
    if ((localObject != null) && (((VideoLinkInfo)localObject).jdField_a_of_type_Int == 6))
    {
      this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerwidgetBannerVideoInfoWidget3.j();
      if (TextUtils.equals(this.jdField_a_of_type_JavaLangString, paramStoryPlayerVideoData.jdField_a_of_type_JavaLangString))
      {
        this.c = false;
      }
      else
      {
        this.c = true;
        this.jdField_a_of_type_JavaLangString = paramStoryPlayerVideoData.jdField_a_of_type_JavaLangString;
      }
      paramStoryPlayerVideoData = this.jdField_a_of_type_ComTencentBizQqstoryModelItemVideoLinkInfo.b;
      localObject = this.jdField_a_of_type_ComTencentBizQqstoryModelItemVideoLinkInfo.c;
      String str = this.jdField_a_of_type_ComTencentBizQqstoryModelItemVideoLinkInfo.d;
      SLog.a("WeiShiFlowBannerVideoInfoController", "WeiShiFlowBannerVideoInfoController doOnBind, title:%s, body:%s, picUrl:%s", paramStoryPlayerVideoData, localObject, str);
      paramBannerViewHolder.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
      paramBannerViewHolder.b.setVisibility(0);
      paramBannerViewHolder.b.setTypeface(null, 0);
      paramBannerViewHolder.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
      BannerVideoInfoWidget3.a(str, paramBannerViewHolder.jdField_a_of_type_AndroidWidgetImageView, paramBannerViewHolder.jdField_a_of_type_AndroidGraphicsDrawableDrawable, paramBannerViewHolder.jdField_a_of_type_Int, paramBannerViewHolder.jdField_a_of_type_Int);
      paramBannerViewHolder.b.setText(paramStoryPlayerVideoData);
      paramBannerViewHolder.jdField_a_of_type_AndroidWidgetTextView.setText((CharSequence)localObject);
      if (this.c) {
        StoryReportor.a("weishi_share", "link_exp", 0, 0, new String[] { "", localStoryVideoItem.mOwnerUid, "", localStoryVideoItem.mVid });
      }
      return;
    }
    this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerwidgetBannerVideoInfoWidget3.k();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.playvideo.playerwidget.WeiShiFlowBannerVideoInfoController
 * JD-Core Version:    0.7.0.1
 */