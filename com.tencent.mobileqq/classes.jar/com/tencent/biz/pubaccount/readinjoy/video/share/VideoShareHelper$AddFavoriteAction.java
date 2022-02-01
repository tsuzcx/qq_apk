package com.tencent.biz.pubaccount.readinjoy.video.share;

import android.app.Activity;
import android.os.Bundle;
import com.tencent.biz.pubaccount.readinjoy.logic.ReadInJoyAtlasManager;
import com.tencent.biz.pubaccount.readinjoy.struct.BaseArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsHelper;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.ShareActionSheetBuilder.ActionSheetItem;
import com.tencent.mobileqq.widget.QQToast;
import java.net.URL;
import java.util.HashSet;

class VideoShareHelper$AddFavoriteAction
  extends ShareAction
{
  VideoShareHelper$AddFavoriteAction(VideoShareHelper paramVideoShareHelper) {}
  
  public int a()
  {
    return 4;
  }
  
  public void a(int paramInt, BaseArticleInfo paramBaseArticleInfo, String paramString, ShareActionSheetBuilder.ActionSheetItem paramActionSheetItem)
  {
    if (!NetworkUtil.g(VideoShareHelper.a(this.a)))
    {
      QQToast.a(VideoShareHelper.a(this.a), 0, HardCodeUtil.a(2131716195), 0).a();
      return;
    }
    VideoFeedsHelper.a(VideoShareHelper.a(this.a), VideoShareHelper.a(this.a));
    String str1 = paramString + "&sourcefrom=6";
    paramString = VideoFeedsHelper.a(paramBaseArticleInfo);
    paramActionSheetItem = VideoFeedsHelper.a(paramBaseArticleInfo);
    Bundle localBundle = new Bundle();
    localBundle.putInt("videoDuration", paramBaseArticleInfo.getVideoDuration());
    localBundle.putLong("publishAccountUin", paramActionSheetItem.longValue());
    localBundle.putString("publishAccountName", paramString);
    localBundle.putLong("feedsId", paramBaseArticleInfo.mFeedId);
    localBundle.putInt("feedsType", paramBaseArticleInfo.mFeedType);
    label182:
    ReadInJoyAtlasManager localReadInJoyAtlasManager;
    Activity localActivity;
    String str2;
    String str3;
    String str4;
    if (paramBaseArticleInfo.busiType == 6)
    {
      paramInt = 1;
      localBundle.putInt("videoType", paramInt);
      paramString = VideoShareHelper.a(this.a);
      if (paramString == null) {
        break label267;
      }
      paramString = paramString.getCurrentUin();
      localReadInJoyAtlasManager = ReadInJoyAtlasManager.a();
      localActivity = VideoShareHelper.a(this.a);
      str2 = paramBaseArticleInfo.getInnerUniqueID();
      str3 = paramBaseArticleInfo.mTitle;
      str4 = paramBaseArticleInfo.mSummary;
      if (paramBaseArticleInfo.getVideoCoverURL() != null) {
        break label273;
      }
    }
    label267:
    label273:
    for (paramActionSheetItem = "";; paramActionSheetItem = paramBaseArticleInfo.getVideoCoverURL().getPath())
    {
      localReadInJoyAtlasManager.a(localActivity, paramString, 2, str2, str3, str4, paramActionSheetItem, str1, localBundle);
      VideoShareHelper.a(this.a).add(paramBaseArticleInfo.getInnerUniqueID());
      return;
      paramInt = 2;
      break;
      paramString = "";
      break label182;
    }
  }
  
  public int b()
  {
    return 6;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.video.share.VideoShareHelper.AddFavoriteAction
 * JD-Core Version:    0.7.0.1
 */