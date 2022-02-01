package com.tencent.biz.pubaccount.weishi_new.like;

import UserGrowth.stSchema;
import UserGrowth.stSimpleMetaFeed;
import android.text.TextPaint;
import android.text.style.ClickableSpan;
import android.view.View;
import com.tencent.biz.pubaccount.weishi_new.config.WSGlobalConfig;
import com.tencent.biz.pubaccount.weishi_new.download.WSDownloadParams;
import com.tencent.biz.pubaccount.weishi_new.jump.WSStSchemaJumpManager;
import com.tencent.biz.pubaccount.weishi_new.report.WSFollowBeaconReport;
import com.tencent.biz.pubaccount.weishi_new.util.WSLog;
import com.tencent.biz.pubaccount.weishi_new.util.WeishiUtils;

class WSFriendLikeParser$FriendClickableSpan
  extends ClickableSpan
{
  private stSchema a;
  private stSimpleMetaFeed b;
  private int c;
  
  WSFriendLikeParser$FriendClickableSpan(stSimpleMetaFeed paramstSimpleMetaFeed, stSchema paramstSchema, int paramInt)
  {
    this.b = paramstSimpleMetaFeed;
    this.a = paramstSchema;
    this.c = paramInt;
  }
  
  private static WSDownloadParams a(String paramString)
  {
    WSDownloadParams localWSDownloadParams = new WSDownloadParams();
    localWSDownloadParams.mScene = 1;
    localWSDownloadParams.mLinkStrategyType = WSGlobalConfig.a().d();
    localWSDownloadParams.mTestId = WeishiUtils.a(localWSDownloadParams.mScene);
    localWSDownloadParams.mScheme = paramString;
    return localWSDownloadParams;
  }
  
  private void a(stSimpleMetaFeed paramstSimpleMetaFeed, int paramInt)
  {
    WSFollowBeaconReport.a("friend", this.c, String.valueOf(paramInt), paramstSimpleMetaFeed);
  }
  
  public void onClick(@androidx.annotation.NonNull View paramView)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("schema = ");
    localStringBuilder.append(this.a.toString());
    WSLog.a("WSFriendLikeUtil", localStringBuilder.toString());
    if (WeishiUtils.o()) {
      return;
    }
    new WSStSchemaJumpManager(paramView.getContext()).a(this.a).a(a(this.a.schema)).a(new WSFriendLikeParser.FriendClickableSpan.1(this)).j();
  }
  
  public void updateDrawState(@android.support.annotation.NonNull TextPaint paramTextPaint)
  {
    paramTextPaint.setUnderlineText(false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.like.WSFriendLikeParser.FriendClickableSpan
 * JD-Core Version:    0.7.0.1
 */