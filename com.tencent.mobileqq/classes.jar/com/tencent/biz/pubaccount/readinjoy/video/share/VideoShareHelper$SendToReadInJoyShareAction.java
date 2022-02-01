package com.tencent.biz.pubaccount.readinjoy.video.share;

import android.app.Activity;
import android.content.Intent;
import com.tencent.biz.pubaccount.readinjoy.biu.ReadInJoyDeliverBiuActivity;
import com.tencent.biz.pubaccount.readinjoy.model.RIJUserLevelModule;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.BaseArticleInfo;
import com.tencent.mobileqq.utils.ShareActionSheetBuilder.ActionSheetItem;

class VideoShareHelper$SendToReadInJoyShareAction
  extends ShareAction
{
  VideoShareHelper$SendToReadInJoyShareAction(VideoShareHelper paramVideoShareHelper) {}
  
  private void b(int paramInt, BaseArticleInfo paramBaseArticleInfo, String paramString, ShareActionSheetBuilder.ActionSheetItem paramActionSheetItem)
  {
    paramString = new Intent(VideoShareHelper.a(this.a), ReadInJoyDeliverBiuActivity.class);
    if (paramBaseArticleInfo.busiType == 6) {
      paramString.putExtra("feedsType", VideoShareHelper.a(this.a).mFeedType);
    }
    paramString.putExtra("ARG_VIDEO_ARTICLE_ID", VideoShareHelper.a(this.a).mArticleID);
    paramString.putExtra("biu_src", 2);
    paramString.putExtra("arg_from_type", 8);
    paramString.putExtra("arg_article_info", (ArticleInfo)paramBaseArticleInfo);
    VideoShareHelper.a(this.a).startActivityForResult(paramString, 102);
    VideoShareHelper.a(this.a).overridePendingTransition(0, 0);
  }
  
  public void a(int paramInt, BaseArticleInfo paramBaseArticleInfo, String paramString, ShareActionSheetBuilder.ActionSheetItem paramActionSheetItem)
  {
    RIJUserLevelModule.a().a(VideoShareHelper.a(this.a), 2, new VideoShareHelper.SendToReadInJoyShareAction.1(this, paramInt, paramBaseArticleInfo, paramString, paramActionSheetItem));
  }
  
  public int c()
  {
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.video.share.VideoShareHelper.SendToReadInJoyShareAction
 * JD-Core Version:    0.7.0.1
 */