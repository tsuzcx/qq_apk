package com.tencent.biz.pubaccount.readinjoy.config.handlers;

import cooperation.readinjoy.ReadInJoyHelper;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.text.StringsKt;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/biz/pubaccount/readinjoy/config/handlers/ViolaVideoFeedsConfigHandler$Companion;", "", "()V", "KEY_FROM_SOURCE", "", "KEY_VIDEO_FEEDS_VERSION", "KEY_VIDEO_IGNORE_NATIVE", "NEW_STYLE_BID", "NEW_STYLE_BUNDLE_NAME", "NEW_STYLE_HOST_NAME", "OLD_STYLE_BID", "OLD_STYLE_BUNDLE_NAME", "OLD_STYLE_HOST_NAME", "TAG", "detectConfigInDebug", "", "getVideoFeedsDebugUrl", "getVideoFeedsReleaseUrl", "isNewVideoFeedsStyle", "isViolaVideoFeeds", "videoFromType", "", "notIgnoreNative", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
public final class ViolaVideoFeedsConfigHandler$Companion
{
  private final boolean b()
  {
    return "0".equals(ReadInJoyHelper.a("viola_video_feeds_version", "0"));
  }
  
  @JvmStatic
  @NotNull
  public final String a()
  {
    if (((Companion)this).b()) {
      return "https://viola.qq.com/js/VShortVideo.js?_rij_violaUrl=1&v_tid=15&v_bundleName=VShortVideo&hideNav=1&v_nav_immer=1&statusColor=1&v_bid=3811&statusBarStyle=1&_cache_bunle=1&v_bg_color=000000&v_content_full=1&statusColor=1&supportNV=1&supportColorBall=1&v_present_title_alpha=1&v_present_gray_float=1&v_present_top=123";
    }
    return StringsKt.replace$default(StringsKt.replace$default(StringsKt.replace$default("https://viola.qq.com/js/VShortVideo.js?_rij_violaUrl=1&v_tid=15&v_bundleName=VShortVideo&hideNav=1&v_nav_immer=1&statusColor=1&v_bid=3811&statusBarStyle=1&_cache_bunle=1&v_bg_color=000000&v_content_full=1&statusColor=1&supportNV=1&supportColorBall=1&v_present_title_alpha=1&v_present_gray_float=1&v_present_top=123", "3811", "3192", false, 4, null), "VShortVideo", "OriginalVideoFeeds", false, 4, null), "viola.qq.com", "sqimg.qq.com", false, 4, null);
  }
  
  @JvmStatic
  public final boolean a()
  {
    return !"1".equals(ReadInJoyHelper.a("viola_video_ingore_native", "0"));
  }
  
  @JvmStatic
  public final boolean a(int paramInt)
  {
    if ("all".equals((String)ReadInJoyHelper.a("viola_video_feeds_config", ""))) {
      return true;
    }
    return ReadInJoyHelper.b(paramInt, "\\|", "viola_video_feeds_config");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.config.handlers.ViolaVideoFeedsConfigHandler.Companion
 * JD-Core Version:    0.7.0.1
 */