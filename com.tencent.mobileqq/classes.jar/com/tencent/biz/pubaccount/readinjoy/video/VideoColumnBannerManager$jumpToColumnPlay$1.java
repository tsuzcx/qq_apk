package com.tencent.biz.pubaccount.readinjoy.video;

import android.content.Context;
import android.os.Bundle;
import com.tencent.biz.pubaccount.VideoInfo;
import com.tencent.superplayer.seamless.SPSeamlessHelper;
import com.tencent.superplayer.seamless.SPSeamlessHelper.SeamlessCallback;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.Nullable;
import org.json.JSONException;
import rmt;
import rmw;
import roq;
import rrm;
import rwf;
import tbz;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "data", "", "invoke"}, k=3, mv={1, 1, 16})
public final class VideoColumnBannerManager$jumpToColumnPlay$1
  extends Lambda
  implements Function1<String, Unit>
{
  public VideoColumnBannerManager$jumpToColumnPlay$1(rmt paramrmt, roq paramroq, VideoInfo paramVideoInfo, int paramInt1, int paramInt2)
  {
    super(1);
  }
  
  public final void invoke(@Nullable String paramString)
  {
    try
    {
      Object localObject;
      String str;
      if (this.$playingVideoHolder.a != null)
      {
        localObject = this.$playingVideoHolder.a.a;
        if (localObject == null) {
          break label179;
        }
        str = ((rwf)localObject).c();
        label30:
        if (paramString == null) {
          break label184;
        }
        paramString = this.this$0.a(paramString, this.$videoInfo, this.$playingVideoHolder, this.$fromType);
        label55:
        SPSeamlessHelper.get().jumpScene(str, (SPSeamlessHelper.SeamlessCallback)new rmw((rwf)localObject));
        localObject = new Bundle();
        ((Bundle)localObject).putString("param", String.valueOf(paramString));
        paramString = "https://viola.qq.com/js/TopicVideo.js?_rij_violaUrl=1&v_bid=3811&v_tid=15&hideNav=1&v_bundleName=TopicVideo&v_debug_test=1&supportNV=1&v_push_animated_disable=1&v_bg_color=00ffffff&v_content_full=1&v_nav_immer=1&v_error_white=1&videoToken=" + str + "&rowkey=" + this.$videoInfo.g;
        if (this.$videoFromType != 125) {
          break label195;
        }
        paramString = paramString + "&pagetype=1";
      }
      for (;;)
      {
        tbz.a((Context)this.this$0.a(), "", paramString, (Bundle)localObject, true);
        return;
        localObject = null;
        break;
        label179:
        str = null;
        break label30;
        label184:
        paramString = null;
        break label55;
      }
    }
    catch (JSONException paramString)
    {
      paramString.printStackTrace();
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.video.VideoColumnBannerManager.jumpToColumnPlay.1
 * JD-Core Version:    0.7.0.1
 */