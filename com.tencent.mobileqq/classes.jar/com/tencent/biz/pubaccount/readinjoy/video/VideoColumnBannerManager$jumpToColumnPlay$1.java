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
import rvx;
import rwa;
import rxv;
import sar;
import sfb;
import tlg;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "data", "", "invoke"}, k=3, mv={1, 1, 16})
public final class VideoColumnBannerManager$jumpToColumnPlay$1
  extends Lambda
  implements Function1<String, Unit>
{
  public VideoColumnBannerManager$jumpToColumnPlay$1(rvx paramrvx, rxv paramrxv, VideoInfo paramVideoInfo, int paramInt)
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
          break label148;
        }
        str = ((sfb)localObject).c();
        label30:
        if (paramString == null) {
          break label153;
        }
      }
      label148:
      label153:
      for (paramString = this.this$0.a(paramString, this.$videoInfo, this.$playingVideoHolder, this.$fromType);; paramString = null)
      {
        SPSeamlessHelper.get().jumpScene(str, (SPSeamlessHelper.SeamlessCallback)new rwa((sfb)localObject));
        localObject = new Bundle();
        ((Bundle)localObject).putString("param", String.valueOf(paramString));
        tlg.a((Context)this.this$0.a(), "", "https://viola.qq.com/js/TopicVideo.js?_rij_violaUrl=1&v_bid=3811&v_tid=15&hideNav=1&v_bundleName=TopicVideo&v_debug_test=1&supportNV=1&v_push_animated_disable=1&v_bg_color=00ffffff&v_content_full=1&v_nav_immer=1&v_error_white=1&videoToken=" + str + "&rowkey=" + this.$videoInfo.g, (Bundle)localObject, true);
        return;
        localObject = null;
        break;
        str = null;
        break label30;
      }
      return;
    }
    catch (JSONException paramString)
    {
      paramString.printStackTrace();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.video.VideoColumnBannerManager.jumpToColumnPlay.1
 * JD-Core Version:    0.7.0.1
 */