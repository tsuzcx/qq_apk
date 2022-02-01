package com.tencent.biz.qqstory.newshare.mode;

import android.support.annotation.NonNull;
import com.tencent.biz.qqstory.newshare.mode.base.WebShareModeBase;
import com.tencent.biz.qqstory.storyHome.model.BannerFeedItem;
import com.tencent.biz.qqstory.storyHome.model.BannerFeedItem.ShareInfo;

public class BannerWebShareMode
  extends WebShareModeBase
{
  public BannerWebShareMode(@NonNull BannerFeedItem paramBannerFeedItem)
  {
    this.a = paramBannerFeedItem.shareInfo.a;
    this.b = paramBannerFeedItem.shareInfo.b;
    this.c = paramBannerFeedItem.shareInfo.d;
    this.d = paramBannerFeedItem.shareInfo.c;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.qqstory.newshare.mode.BannerWebShareMode
 * JD-Core Version:    0.7.0.1
 */