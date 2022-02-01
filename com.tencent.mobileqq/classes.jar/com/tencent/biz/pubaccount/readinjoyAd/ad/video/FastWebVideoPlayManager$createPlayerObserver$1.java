package com.tencent.biz.pubaccount.readinjoyAd.ad.video;

import com.tencent.biz.pubaccount.readinjoy.video.MediaPlayListenerAdapter;
import com.tencent.biz.pubaccount.readinjoy.video.VideoPlayerWrapper;
import com.tencent.biz.pubaccount.readinjoyAd.ad.data.ProteusBannerVideoItemData;
import com.tencent.biz.pubaccount.readinjoyAd.ad.utils.ReadInJoyAdLog;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"com/tencent/biz/pubaccount/readinjoyAd/ad/video/FastWebVideoPlayManager$createPlayerObserver$1", "Lcom/tencent/biz/pubaccount/readinjoy/video/MediaPlayListenerAdapter;", "onCompletion", "", "player", "Lcom/tencent/biz/pubaccount/readinjoy/video/VideoPlayerWrapper;", "onError", "", "model", "", "what", "extra", "detailInfo", "", "info", "", "onVideoPrepared", "tag", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
public final class FastWebVideoPlayManager$createPlayerObserver$1
  extends MediaPlayListenerAdapter
{
  public void a(@Nullable VideoPlayerWrapper paramVideoPlayerWrapper, @Nullable Object paramObject)
  {
    ReadInJoyAdLog.a("VideoPlayerWrapper_AD", "onVideoPrepared");
    FastWebVideoPlayManager.a(FastWebVideoPlayManager.a).set(2);
    paramVideoPlayerWrapper = FastWebVideoPlayManager.a(FastWebVideoPlayManager.a).a();
    paramObject = FastWebVideoPlayManager.a(FastWebVideoPlayManager.a);
    if (paramObject != null) {}
    for (long l = paramObject.b();; l = 0L)
    {
      paramVideoPlayerWrapper.g((int)l);
      FastWebVideoPlayManager.a(FastWebVideoPlayManager.a).a().f(2);
      FastWebVideoPlayManager.a.e();
      return;
    }
  }
  
  public boolean a(@Nullable VideoPlayerWrapper paramVideoPlayerWrapper, int paramInt1, int paramInt2, int paramInt3, @Nullable String paramString, @Nullable Object paramObject)
  {
    ReadInJoyAdLog.a("VideoPlayerWrapper_AD", "onError");
    FastWebVideoPlayManager.a(FastWebVideoPlayManager.a).set(6);
    FastWebVideoPlayManager.a(FastWebVideoPlayManager.a, 6);
    paramString = ((Map)FastWebVideoPlayManager.a(FastWebVideoPlayManager.a)).entrySet().iterator();
    if (paramString.hasNext())
    {
      paramObject = (VideoStateCallback)((Map.Entry)paramString.next()).getValue();
      if (paramObject != null)
      {
        paramVideoPlayerWrapper = FastWebVideoPlayManager.a(FastWebVideoPlayManager.a).a();
        if (paramVideoPlayerWrapper == null) {
          break label112;
        }
      }
      label112:
      for (paramVideoPlayerWrapper = paramVideoPlayerWrapper.o;; paramVideoPlayerWrapper = null)
      {
        paramObject.c(paramVideoPlayerWrapper);
        break;
      }
    }
    FastWebVideoPlayManager.a(FastWebVideoPlayManager.a, false);
    return false;
  }
  
  public void b(@Nullable VideoPlayerWrapper paramVideoPlayerWrapper)
  {
    ReadInJoyAdLog.a("VideoPlayerWrapper_AD", "onCompletion");
    FastWebVideoPlayManager.a(FastWebVideoPlayManager.a).set(7);
    FastWebVideoPlayManager.a(FastWebVideoPlayManager.a, 7);
    Iterator localIterator = ((Map)FastWebVideoPlayManager.a(FastWebVideoPlayManager.a)).entrySet().iterator();
    if (localIterator.hasNext())
    {
      VideoStateCallback localVideoStateCallback = (VideoStateCallback)((Map.Entry)localIterator.next()).getValue();
      if (localVideoStateCallback != null)
      {
        paramVideoPlayerWrapper = FastWebVideoPlayManager.a(FastWebVideoPlayManager.a).a();
        if (paramVideoPlayerWrapper == null) {
          break label106;
        }
      }
      label106:
      for (paramVideoPlayerWrapper = paramVideoPlayerWrapper.o;; paramVideoPlayerWrapper = null)
      {
        localVideoStateCallback.d(paramVideoPlayerWrapper);
        break;
      }
    }
    FastWebVideoPlayManager.a(FastWebVideoPlayManager.a).a().c(1);
    FastWebVideoPlayManager.a(FastWebVideoPlayManager.a, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoyAd.ad.video.FastWebVideoPlayManager.createPlayerObserver.1
 * JD-Core Version:    0.7.0.1
 */