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
  private int jdField_a_of_type_Int;
  private stSchema jdField_a_of_type_UserGrowthStSchema;
  private stSimpleMetaFeed jdField_a_of_type_UserGrowthStSimpleMetaFeed;
  
  WSFriendLikeParser$FriendClickableSpan(stSimpleMetaFeed paramstSimpleMetaFeed, stSchema paramstSchema, int paramInt)
  {
    this.jdField_a_of_type_UserGrowthStSimpleMetaFeed = paramstSimpleMetaFeed;
    this.jdField_a_of_type_UserGrowthStSchema = paramstSchema;
    this.jdField_a_of_type_Int = paramInt;
  }
  
  private static WSDownloadParams a(String paramString)
  {
    WSDownloadParams localWSDownloadParams = new WSDownloadParams();
    localWSDownloadParams.mScene = 1;
    localWSDownloadParams.mLinkStrategyType = WSGlobalConfig.a().a();
    localWSDownloadParams.mTestId = WeishiUtils.a(localWSDownloadParams.mScene);
    localWSDownloadParams.mScheme = paramString;
    return localWSDownloadParams;
  }
  
  private void a(stSimpleMetaFeed paramstSimpleMetaFeed, int paramInt)
  {
    WSFollowBeaconReport.a("friend", this.jdField_a_of_type_Int, String.valueOf(paramInt), paramstSimpleMetaFeed);
  }
  
  public void onClick(@androidx.annotation.NonNull View paramView)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("schema = ");
    localStringBuilder.append(this.jdField_a_of_type_UserGrowthStSchema.toString());
    WSLog.a("WSFriendLikeUtil", localStringBuilder.toString());
    if (WeishiUtils.c()) {
      return;
    }
    new WSStSchemaJumpManager(paramView.getContext()).a(this.jdField_a_of_type_UserGrowthStSchema).a(a(this.jdField_a_of_type_UserGrowthStSchema.schema)).a(new WSFriendLikeParser.FriendClickableSpan.1(this)).c();
  }
  
  public void updateDrawState(@android.support.annotation.NonNull TextPaint paramTextPaint)
  {
    paramTextPaint.setUnderlineText(false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.like.WSFriendLikeParser.FriendClickableSpan
 * JD-Core Version:    0.7.0.1
 */