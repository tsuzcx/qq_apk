package com.tencent.biz.pubaccount.readinjoy.video.share;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import com.tencent.biz.pubaccount.readinjoy.decoupling.uilayer.framewrok.util.RIJJumpUtils;
import com.tencent.biz.pubaccount.readinjoy.struct.BaseArticleInfo;
import com.tencent.biz.qrcode.util.QRUtils;
import com.tencent.mobileqq.utils.ShareActionSheetBuilder.ActionSheetItem;

class VideoShareHelper$OpenInSysBrowserShareAction
  extends ShareAction
{
  VideoShareHelper$OpenInSysBrowserShareAction(VideoShareHelper paramVideoShareHelper) {}
  
  public void a(int paramInt, BaseArticleInfo paramBaseArticleInfo, String paramString, ShareActionSheetBuilder.ActionSheetItem paramActionSheetItem)
  {
    VideoShareHelper.a(this.a, false);
    paramActionSheetItem = paramString + "&sourcefrom=6";
    paramString = paramActionSheetItem;
    if (paramBaseArticleInfo.qzoneShareUrl != null)
    {
      paramString = paramActionSheetItem;
      if (paramBaseArticleInfo.qzoneShareUrl.contains("kandianshare.html5.qq.com")) {
        paramString = paramBaseArticleInfo.qzoneShareUrl;
      }
    }
    paramBaseArticleInfo = new Intent("android.intent.action.VIEW", Uri.parse(paramString));
    paramBaseArticleInfo.putExtra("big_brother_source_key", RIJJumpUtils.a(0));
    paramBaseArticleInfo.putExtra("normal", true);
    try
    {
      VideoShareHelper.a(this.a).startActivity(paramBaseArticleInfo);
      return;
    }
    catch (ActivityNotFoundException paramBaseArticleInfo)
    {
      QRUtils.a(1, 2131695226);
    }
  }
  
  public int c()
  {
    return 7;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.video.share.VideoShareHelper.OpenInSysBrowserShareAction
 * JD-Core Version:    0.7.0.1
 */