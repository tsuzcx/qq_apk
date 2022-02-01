package com.tencent.biz.pubaccount.readinjoy.video;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.net.Uri;
import android.view.View;
import com.tencent.biz.pubaccount.readinjoy.decoupling.uilayer.framewrok.util.RIJJumpUtils;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.MessageForShortVideo;
import com.tencent.mobileqq.shortvideo.ShortVideoUtils.VideoFileSaveRunnable;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheet.OnButtonClickListener;
import cooperation.qzone.QZoneHelper;
import cooperation.qzone.QZoneHelper.UserInfo;
import mqq.os.MqqHandler;

class VideoFeedsShareController$3
  implements ActionSheet.OnButtonClickListener
{
  VideoFeedsShareController$3(VideoFeedsShareController paramVideoFeedsShareController, ActionSheet paramActionSheet, String paramString1, MessageForShortVideo paramMessageForShortVideo, String paramString2, boolean paramBoolean, String paramString3, String paramString4, String paramString5) {}
  
  public void OnClick(View paramView, int paramInt)
  {
    this.jdField_a_of_type_ComTencentWidgetActionSheet.dismiss();
    paramView = this.jdField_a_of_type_ComTencentWidgetActionSheet.getContent(paramInt);
    if (paramView != null)
    {
      if (!paramView.equals(this.jdField_a_of_type_JavaLangString)) {
        break label91;
      }
      if (VideoFeedsShareController.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsShareController) != null) {
        VideoFeedsShareController.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsShareController, VideoFeedsShareController.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsShareController));
      }
      VideoFeedsShareController.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsShareController, "0", "0", "0", this.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo.getMd5(), "0", this.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo.videoFileTime, 0L, 0, -1, 0, null, true);
    }
    label91:
    do
    {
      return;
      if (paramView.equals(this.b))
      {
        VideoFeedsShareController.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsShareController, "click menu to share to qzone, finalVideoExists=" + this.jdField_a_of_type_Boolean);
        if (this.jdField_a_of_type_Boolean)
        {
          paramView = QZoneHelper.UserInfo.getInstance();
          QZoneHelper.forwardToPublishMood(VideoFeedsShareController.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsShareController), paramView, this.c, 10001);
          VideoFeedsShareController.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsShareController).b(VideoFeedsShareController.b(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsShareController));
        }
        for (;;)
        {
          VideoFeedsShareController.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsShareController, "0", "1", "0", this.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo.getMd5(), "0", this.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo.videoFileTime, 0L, 0, -1, 0, null, true);
          return;
          QQToast.a(VideoFeedsShareController.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsShareController), 0, 2131719349, 0).b(VideoFeedsShareController.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsShareController).getResources().getDimensionPixelSize(2131299166));
        }
      }
      if (paramView.equals(this.d))
      {
        if (!this.jdField_a_of_type_Boolean)
        {
          QQToast.a(VideoFeedsShareController.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsShareController), 0, 2131719349, 0).b(VideoFeedsShareController.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsShareController).getResources().getDimensionPixelSize(2131299166));
          return;
        }
        ThreadManager.getFileThreadHandler().post(new ShortVideoUtils.VideoFileSaveRunnable(this.c, VideoFeedsShareController.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsShareController), this.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo.getMd5() + ".mp4", false));
        return;
      }
    } while (!paramView.equals(this.e));
    if (!this.jdField_a_of_type_Boolean)
    {
      QQToast.a(VideoFeedsShareController.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsShareController), 0, 2131719349, 0).b(VideoFeedsShareController.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsShareController).getResources().getDimensionPixelSize(2131299166));
      return;
    }
    paramView = new Intent("android.intent.action.VIEW");
    paramView.setDataAndType(Uri.parse("file://" + this.c), "video/*");
    paramView.putExtra("big_brother_source_key", RIJJumpUtils.a(0));
    VideoFeedsShareController.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsShareController).startActivity(paramView);
    VideoFeedsShareController.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsShareController).b(VideoFeedsShareController.b(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsShareController));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsShareController.3
 * JD-Core Version:    0.7.0.1
 */