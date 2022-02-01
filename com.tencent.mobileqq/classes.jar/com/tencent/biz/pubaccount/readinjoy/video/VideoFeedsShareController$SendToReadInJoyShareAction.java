package com.tencent.biz.pubaccount.readinjoy.video;

import android.app.Activity;
import android.content.Intent;
import com.tencent.biz.pubaccount.VideoInfo;
import com.tencent.biz.pubaccount.readinjoy.biu.ReadInJoyDeliverBiuActivity;
import com.tencent.biz.pubaccount.readinjoy.model.RIJUserLevelModule;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.video.share.ShareAction;
import com.tencent.mobileqq.utils.ShareActionSheetBuilder.ActionSheetItem;
import com.tencent.qphone.base.util.QLog;

class VideoFeedsShareController$SendToReadInJoyShareAction
  extends ShareAction
{
  VideoFeedsShareController$SendToReadInJoyShareAction(VideoFeedsShareController paramVideoFeedsShareController) {}
  
  private void b(int paramInt, VideoInfo paramVideoInfo, String paramString, ShareActionSheetBuilder.ActionSheetItem paramActionSheetItem)
  {
    if (paramVideoInfo != null) {}
    try
    {
      VideoFeedsShareController.a(this.a).b(VideoFeedsShareController.b(this.a));
      paramString = new Intent(VideoFeedsShareController.a(this.a), ReadInJoyDeliverBiuActivity.class);
      if ((VideoFeedsShareController.a(this.a).jdField_a_of_type_Int == 6) && (paramVideoInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo != null)) {
        paramString.putExtra("feedsType", VideoFeedsShareController.a(this.a).jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mFeedType);
      }
      paramString.putExtra("ARG_VIDEO_ARTICLE_ID", VideoFeedsShareController.a(this.a).g);
      paramString.putExtra("biu_src", 2);
      paramString.putExtra("arg_from_type", 8);
      paramString.putExtra("arg_article_info", paramVideoInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo);
      VideoFeedsShareController.a(this.a).startActivityForResult(paramString, 102);
      VideoFeedsShareController.a(this.a).overridePendingTransition(0, 0);
      return;
    }
    catch (Exception paramVideoInfo)
    {
      if (QLog.isColorLevel()) {
        QLog.e("VideoFeedsShareController", 2, "innerOpenReadInJoyBiuActivity error exception = " + paramVideoInfo.getMessage());
      }
      VideoFeedsShareController.a(this.a).b(false);
    }
  }
  
  public void a(int paramInt, VideoInfo paramVideoInfo, String paramString, ShareActionSheetBuilder.ActionSheetItem paramActionSheetItem)
  {
    RIJUserLevelModule.a().a(VideoFeedsShareController.a(this.a), 2, new VideoFeedsShareController.SendToReadInJoyShareAction.1(this, paramInt, paramVideoInfo, paramString, paramActionSheetItem));
  }
  
  public int c()
  {
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsShareController.SendToReadInJoyShareAction
 * JD-Core Version:    0.7.0.1
 */