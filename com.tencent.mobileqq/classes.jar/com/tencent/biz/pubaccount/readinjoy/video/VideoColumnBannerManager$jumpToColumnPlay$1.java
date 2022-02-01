package com.tencent.biz.pubaccount.readinjoy.video;

import android.content.Context;
import android.os.Bundle;
import com.tencent.biz.pubaccount.VideoInfo;
import com.tencent.biz.pubaccount.readinjoy.video.videofeeds.ShortVideoItemHolder;
import com.tencent.biz.pubaccount.readinjoy.viola.ViolaAccessHelper;
import com.tencent.superplayer.seamless.SPSeamlessHelper;
import com.tencent.superplayer.seamless.SPSeamlessHelper.SeamlessCallback;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.Nullable;
import org.json.JSONException;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "data", "", "invoke"}, k=3, mv={1, 1, 16})
final class VideoColumnBannerManager$jumpToColumnPlay$1
  extends Lambda
  implements Function1<String, Unit>
{
  VideoColumnBannerManager$jumpToColumnPlay$1(VideoColumnBannerManager paramVideoColumnBannerManager, ShortVideoItemHolder paramShortVideoItemHolder, VideoInfo paramVideoInfo, int paramInt1, int paramInt2)
  {
    super(1);
  }
  
  public final void invoke(@Nullable String paramString)
  {
    try
    {
      Object localObject = this.$playingVideoHolder.a;
      String str;
      if (localObject != null)
      {
        localObject = ((VideoFeedsPlayManager.VideoPlayParam)localObject).a;
        if (localObject == null) {
          break label175;
        }
        str = ((VideoPlayerWrapper)localObject).c();
        label26:
        if (paramString == null) {
          break label180;
        }
        paramString = this.this$0.a(paramString, this.$videoInfo, this.$playingVideoHolder, this.$fromType);
        label51:
        SPSeamlessHelper.get().jumpScene(str, (SPSeamlessHelper.SeamlessCallback)new VideoColumnBannerManager.jumpToColumnPlay.1.1((VideoPlayerWrapper)localObject));
        localObject = new Bundle();
        ((Bundle)localObject).putString("param", String.valueOf(paramString));
        paramString = "https://viola.qq.com/js/TopicVideo.js?_rij_violaUrl=1&v_bid=3811&v_tid=15&hideNav=1&v_bundleName=TopicVideo&supportNV=1&v_push_animated_disable=1&v_bg_color=00ffffff&v_content_full=1&v_nav_immer=1&v_error_white=1&videoToken=" + str + "&rowkey=" + this.$videoInfo.g;
        if (this.$videoFromType != 125) {
          break label191;
        }
        paramString = paramString + "&pagetype=1";
      }
      for (;;)
      {
        ViolaAccessHelper.a((Context)this.this$0.a(), "", paramString, (Bundle)localObject, true);
        return;
        localObject = null;
        break;
        label175:
        str = null;
        break label26;
        label180:
        paramString = null;
        break label51;
      }
    }
    catch (JSONException paramString)
    {
      paramString.printStackTrace();
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.video.VideoColumnBannerManager.jumpToColumnPlay.1
 * JD-Core Version:    0.7.0.1
 */