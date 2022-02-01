package com.tencent.biz.pubaccount.readinjoyAd.ad.video;

import com.tencent.biz.pubaccount.readinjoyAd.ad.data.ProteusBannerVideoItemData;
import com.tencent.biz.pubaccount.readinjoyAd.ad.utils.ReadInJoyAdLog;
import com.tencent.mobileqq.kandian.base.video.player.MediaPlayListenerAdapter;
import com.tencent.mobileqq.kandian.base.video.player.api.IVideoPlayerWrapper;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"com/tencent/biz/pubaccount/readinjoyAd/ad/video/FastWebVideoPlayManager$createPlayerObserver$1", "Lcom/tencent/mobileqq/kandian/base/video/player/MediaPlayListenerAdapter;", "onCompletion", "", "player", "Lcom/tencent/mobileqq/kandian/base/video/player/api/IVideoPlayerWrapper;", "onError", "", "model", "", "what", "extra", "detailInfo", "", "info", "", "onVideoPrepared", "tag", "kandian_ad_feature_impl_release"}, k=1, mv={1, 1, 16})
public final class FastWebVideoPlayManager$createPlayerObserver$1
  extends MediaPlayListenerAdapter
{
  public void a(@Nullable IVideoPlayerWrapper paramIVideoPlayerWrapper)
  {
    ReadInJoyAdLog.a("VideoPlayerWrapper_AD", "onCompletion");
    FastWebVideoPlayManager.a(FastWebVideoPlayManager.a).set(7);
    FastWebVideoPlayManager.a(FastWebVideoPlayManager.a, 7);
    Iterator localIterator = ((Map)FastWebVideoPlayManager.d(FastWebVideoPlayManager.a)).entrySet().iterator();
    while (localIterator.hasNext())
    {
      VideoStateCallback localVideoStateCallback = (VideoStateCallback)((Map.Entry)localIterator.next()).getValue();
      if (localVideoStateCallback != null)
      {
        paramIVideoPlayerWrapper = FastWebVideoPlayManager.b(FastWebVideoPlayManager.a).b();
        if (paramIVideoPlayerWrapper != null) {
          paramIVideoPlayerWrapper = paramIVideoPlayerWrapper.G;
        } else {
          paramIVideoPlayerWrapper = null;
        }
        localVideoStateCallback.d(paramIVideoPlayerWrapper);
      }
    }
    FastWebVideoPlayManager.b(FastWebVideoPlayManager.a).c().c(1);
    FastWebVideoPlayManager.a(FastWebVideoPlayManager.a, false);
  }
  
  public void a(@Nullable IVideoPlayerWrapper paramIVideoPlayerWrapper, @Nullable Object paramObject)
  {
    ReadInJoyAdLog.a("VideoPlayerWrapper_AD", "onVideoPrepared");
    FastWebVideoPlayManager.a(FastWebVideoPlayManager.a).set(2);
    paramIVideoPlayerWrapper = FastWebVideoPlayManager.b(FastWebVideoPlayManager.a).c();
    paramObject = FastWebVideoPlayManager.c(FastWebVideoPlayManager.a);
    long l;
    if (paramObject != null) {
      l = paramObject.I();
    } else {
      l = 0L;
    }
    paramIVideoPlayerWrapper.g((int)l);
    FastWebVideoPlayManager.b(FastWebVideoPlayManager.a).c().f(2);
    FastWebVideoPlayManager.a.e();
  }
  
  public boolean a(@Nullable IVideoPlayerWrapper paramIVideoPlayerWrapper, int paramInt1, int paramInt2, int paramInt3, @Nullable String paramString, @Nullable Object paramObject)
  {
    ReadInJoyAdLog.a("VideoPlayerWrapper_AD", "onError");
    FastWebVideoPlayManager.a(FastWebVideoPlayManager.a).set(6);
    FastWebVideoPlayManager.a(FastWebVideoPlayManager.a, 6);
    paramString = ((Map)FastWebVideoPlayManager.d(FastWebVideoPlayManager.a)).entrySet().iterator();
    while (paramString.hasNext())
    {
      paramObject = (VideoStateCallback)((Map.Entry)paramString.next()).getValue();
      if (paramObject != null)
      {
        paramIVideoPlayerWrapper = FastWebVideoPlayManager.b(FastWebVideoPlayManager.a).b();
        if (paramIVideoPlayerWrapper != null) {
          paramIVideoPlayerWrapper = paramIVideoPlayerWrapper.G;
        } else {
          paramIVideoPlayerWrapper = null;
        }
        paramObject.c(paramIVideoPlayerWrapper);
      }
    }
    FastWebVideoPlayManager.a(FastWebVideoPlayManager.a, false);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoyAd.ad.video.FastWebVideoPlayManager.createPlayerObserver.1
 * JD-Core Version:    0.7.0.1
 */