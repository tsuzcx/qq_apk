package com.tencent.biz.pubaccount.readinjoyAd.ad.video;

import android.content.Context;
import android.graphics.Rect;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import com.tencent.biz.pubaccount.NativeAd.module.AdModuleVideo;
import com.tencent.biz.pubaccount.NativeAd.report.constant.ReportConstants.VideoEndType;
import com.tencent.biz.pubaccount.readinjoy.struct.AdvertisementInfo;
import com.tencent.biz.pubaccount.readinjoyAd.ad.data.AdReportData;
import com.tencent.biz.pubaccount.readinjoyAd.ad.data.ProteusBannerVideoItemData;
import com.tencent.biz.pubaccount.readinjoyAd.ad.utils.ReadInJoyAdLog;
import com.tencent.biz.pubaccount.readinjoyAd.ad.utils.ReadInJoyAdSwitchUtil;
import com.tencent.biz.pubaccount.readinjoyAd.ad.utils.ReadInJoyBottomAdVideoUtil;
import com.tencent.mobileqq.kandian.ad.api.IRIJAdService;
import com.tencent.mobileqq.kandian.ad.api.IRIJAdUtilService;
import com.tencent.mobileqq.kandian.base.video.player.MediaPlayListenerAdapter;
import com.tencent.mobileqq.kandian.base.video.player.api.IVideoPlayerWrapper;
import com.tencent.mobileqq.kandian.base.video.player.api.MediaPlayListener;
import com.tencent.mobileqq.kandian.biz.video.api.IVideoPlayerWrapperFactory;
import com.tencent.mobileqq.msf.sdk.handler.INetInfoHandler;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.SoftReference;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/biz/pubaccount/readinjoyAd/ad/video/FastWebVideoPlayManager;", "Lcom/tencent/mobileqq/msf/sdk/handler/INetInfoHandler;", "()V", "TAG", "", "context", "Ljava/lang/ref/WeakReference;", "Landroid/content/Context;", "hasVideoPlayTaskRunning", "", "inPlayArea", "isNetChangeAutoPlaySwitchOpen", "mediaPlayListenerAdapter", "Lcom/tencent/mobileqq/kandian/base/video/player/MediaPlayListenerAdapter;", "playState", "Ljava/util/concurrent/atomic/AtomicInteger;", "rect", "Landroid/graphics/Rect;", "stateCallbackList", "Ljava/util/concurrent/ConcurrentHashMap;", "Lcom/tencent/biz/pubaccount/readinjoyAd/ad/video/VideoStateCallback;", "uiHandler", "Landroid/os/Handler;", "videoContainer", "Ljava/lang/ref/SoftReference;", "Landroid/widget/RelativeLayout;", "videoModule", "Lcom/tencent/biz/pubaccount/readinjoyAd/ad/video/FastWebVideoModule;", "videoPauseType", "Lcom/tencent/biz/pubaccount/NativeAd/report/constant/ReportConstants$VideoEndType;", "videoPlayer", "Lcom/tencent/mobileqq/kandian/base/video/player/api/IVideoPlayerWrapper;", "commentAdAreaClickReport", "", "createPlayerObserver", "doVideoReport", "state", "", "getCurrentPos", "", "getPlayState", "initVideoPlayer", "isPlaying", "isSameData", "adData", "Lcom/tencent/biz/pubaccount/readinjoyAd/ad/data/ProteusBannerVideoItemData;", "netChange", "onCreate", "onDestroy", "onInitOrBeforeReplay", "isReplay", "onNetMobile2None", "onNetMobile2Wifi", "p0", "onNetNone2Mobile", "onNetNone2Wifi", "onNetWifi2Mobile", "onNetWifi2None", "onPause", "onResume", "pauseVideo", "releasePlayer", "setStateCallback", "url", "callback", "setVideoData", "videoData", "Lcom/tencent/biz/pubaccount/NativeAd/module/AdModuleVideo;", "adInfo", "Lcom/tencent/biz/pubaccount/readinjoy/struct/AdvertisementInfo;", "setVideoPauseType", "videoEndTYpe", "startVideo", "startVideoWhenScroll", "kandian_ad_feature_impl_release"}, k=1, mv={1, 1, 16})
public final class FastWebVideoPlayManager
  implements INetInfoHandler
{
  public static final FastWebVideoPlayManager a = new FastWebVideoPlayManager();
  private static FastWebVideoModule b = new FastWebVideoModule();
  private static WeakReference<Context> c;
  private static IVideoPlayerWrapper d;
  private static SoftReference<RelativeLayout> e;
  private static Rect f = new Rect();
  private static Handler g;
  private static volatile boolean h;
  private static volatile AtomicInteger i = new AtomicInteger(0);
  private static volatile MediaPlayListenerAdapter j;
  private static ConcurrentHashMap<String, VideoStateCallback> k = new ConcurrentHashMap();
  private static boolean l;
  private static boolean m;
  private static ReportConstants.VideoEndType n = ReportConstants.VideoEndType.CLICK_PAUSE;
  
  private final void a(int paramInt)
  {
    Object localObject3 = null;
    Object localObject2 = null;
    Object localObject1 = null;
    if (paramInt != 5)
    {
      if (paramInt != 6)
      {
        if (paramInt != 7) {
          return;
        }
        localObject2 = ((IRIJAdUtilService)QRoute.api(IRIJAdUtilService.class)).getVideoInfoObject(b.c().a(), b.c().g(), b.c().c(), 1, b.c().e(), b.c().f(), b.c().g(), 1, 0, b.c().h(), ReportConstants.VideoEndType.NORMAL_COMPLETE, b.c().i(), false);
        if (b.a() != null)
        {
          localObject3 = b.a();
          if (localObject3 == null) {
            Intrinsics.throwNpe();
          }
          if (((AdvertisementInfo)localObject3).isCommentAd())
          {
            ((JSONObject)localObject2).put("videoReplayCount", b.c().h());
            ((JSONObject)localObject2).put("isClickReplay", false);
          }
        }
        localObject3 = new StringBuilder();
        ((StringBuilder)localObject3).append("complete videoJson = ");
        ((StringBuilder)localObject3).append(localObject2);
        ReadInJoyAdLog.a("VideoPlayerWrapper_AD", ((StringBuilder)localObject3).toString());
        localObject3 = (IRIJAdService)QRoute.api(IRIJAdService.class);
        localObject4 = new AdReportData();
        localObject5 = c;
        if (localObject5 != null) {
          localObject1 = (Context)((WeakReference)localObject5).get();
        }
        ((IRIJAdService)localObject3).report(((AdReportData)localObject4).a((Context)localObject1).a(6).b(1).a(b.a()).a((JSONObject)localObject2));
        b.c().a(0);
        b.c().b(b.c().g());
        b.c().d(0);
        b.c().c(1);
        return;
      }
      localObject2 = (IRIJAdService)QRoute.api(IRIJAdService.class);
      localObject4 = new AdReportData();
      localObject5 = c;
      localObject1 = localObject3;
      if (localObject5 != null) {
        localObject1 = (Context)((WeakReference)localObject5).get();
      }
      ((IRIJAdService)localObject2).report(((AdReportData)localObject4).a((Context)localObject1).a(6).b(1).a(b.a()).a(((IRIJAdUtilService)QRoute.api(IRIJAdUtilService.class)).getVideoInfoObject(0, 0, 0, 0, 0, 0, b.c().g(), 1, 2, b.c().h(), ReportConstants.VideoEndType.OTHER, b.c().i(), false)));
      return;
    }
    b.c().b((int)i());
    localObject3 = ((IRIJAdUtilService)QRoute.api(IRIJAdUtilService.class)).getVideoInfoObject(b.c().a(), b.c().b(), b.c().c(), b.c().d(), b.c().e(), b.c().f(), b.c().g(), 1, 0, b.c().h(), n, b.c().i(), false);
    if (b.a() != null)
    {
      localObject1 = b.a();
      if (localObject1 == null) {
        Intrinsics.throwNpe();
      }
      if (((AdvertisementInfo)localObject1).isCommentAd())
      {
        ((JSONObject)localObject3).put("videoReplayCount", b.c().h());
        ((JSONObject)localObject3).put("isClickReplay", false);
      }
    }
    localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("pause videoJson = ");
    ((StringBuilder)localObject1).append(localObject3);
    ReadInJoyAdLog.a("VideoPlayerWrapper_AD", ((StringBuilder)localObject1).toString());
    Object localObject4 = (IRIJAdService)QRoute.api(IRIJAdService.class);
    Object localObject5 = new AdReportData();
    WeakReference localWeakReference = c;
    localObject1 = localObject2;
    if (localWeakReference != null) {
      localObject1 = (Context)localWeakReference.get();
    }
    ((IRIJAdService)localObject4).report(((AdReportData)localObject5).a((Context)localObject1).a(6).b(1).a(b.a()).a((JSONObject)localObject3));
    b.c().a(b.c().b());
    b.c().c(0);
    n = ReportConstants.VideoEndType.CLICK_PAUSE;
  }
  
  private final void a(Context paramContext, RelativeLayout paramRelativeLayout)
  {
    if (paramContext == null) {
      return;
    }
    if (d != null) {
      m();
    }
    paramContext = ((IVideoPlayerWrapperFactory)QRoute.api(IVideoPlayerWrapperFactory.class)).createPlayer(paramContext);
    paramContext.a((ViewGroup)paramRelativeLayout, true);
    paramContext.b(2);
    if (j == null) {
      j = a.l();
    }
    paramContext.a((MediaPlayListener)j);
    paramContext.g(true);
    d = paramContext;
  }
  
  private final MediaPlayListenerAdapter l()
  {
    return (MediaPlayListenerAdapter)new FastWebVideoPlayManager.createPlayerObserver.1();
  }
  
  private final void m()
  {
    ReadInJoyAdLog.a("VideoPlayerWrapper_AD", "releasePlayer");
    IVideoPlayerWrapper localIVideoPlayerWrapper = d;
    if (localIVideoPlayerWrapper != null) {
      localIVideoPlayerWrapper.x();
    }
    localIVideoPlayerWrapper = d;
    if (localIVideoPlayerWrapper != null) {
      localIVideoPlayerWrapper.y();
    }
    localIVideoPlayerWrapper = d;
    if (localIVideoPlayerWrapper != null) {
      localIVideoPlayerWrapper.a(null);
    }
    d = (IVideoPlayerWrapper)null;
    i.set(0);
    h = false;
  }
  
  private final void n()
  {
    if (m)
    {
      e();
      return;
    }
    g();
  }
  
  public final void a()
  {
    ReadInJoyAdLog.a("VideoPlayerWrapper_AD", "onCreate");
    m();
    g = new Handler(Looper.getMainLooper());
  }
  
  public final void a(@Nullable Context paramContext, @Nullable RelativeLayout paramRelativeLayout, @Nullable AdModuleVideo paramAdModuleVideo, @Nullable AdvertisementInfo paramAdvertisementInfo, @Nullable ProteusBannerVideoItemData paramProteusBannerVideoItemData)
  {
    for (;;)
    {
      try
      {
        if (h)
        {
          QLog.d("VideoPlayerWrapper_AD", 1, "setVideoData but hasVideoPlayTaskRunning");
          return;
        }
        if (paramContext == null)
        {
          QLog.d("VideoPlayerWrapper_AD", 1, "setVideoData with empty context");
          return;
        }
        if ((paramAdModuleVideo != null) && (paramAdvertisementInfo != null) && (paramProteusBannerVideoItemData != null))
        {
          if (paramRelativeLayout == null)
          {
            QLog.d("VideoPlayerWrapper_AD", 1, "setVideoData with empty videoContainer");
            return;
          }
          boolean bool = a(paramProteusBannerVideoItemData);
          if (bool) {
            return;
          }
          c = new WeakReference(paramContext);
          b.a(paramAdModuleVideo);
          b.a(paramProteusBannerVideoItemData);
          b.a(paramAdvertisementInfo);
          paramProteusBannerVideoItemData = b.a();
          ProteusBannerVideoItemData localProteusBannerVideoItemData = b.b();
          paramAdModuleVideo = c;
          paramAdvertisementInfo = null;
          if (paramAdModuleVideo != null)
          {
            paramAdModuleVideo = (Context)paramAdModuleVideo.get();
            m = ReadInJoyAdSwitchUtil.a(paramProteusBannerVideoItemData, localProteusBannerVideoItemData, paramAdModuleVideo, 2);
            e = new SoftReference(paramRelativeLayout);
            a(paramContext, paramRelativeLayout);
            ReadInJoyAdLog.a("VideoPlayerWrapper_AD", "ready to playerStartByUrl");
            paramRelativeLayout = d;
            if (paramRelativeLayout != null)
            {
              paramAdModuleVideo = b.b();
              paramContext = paramAdvertisementInfo;
              if (paramAdModuleVideo != null) {
                paramContext = paramAdModuleVideo.G;
              }
              paramRelativeLayout.a(null, paramContext, 3, 1L, 0L, 0);
            }
            h = true;
          }
        }
        else
        {
          QLog.d("VideoPlayerWrapper_AD", 1, "setVideoData with empty data");
          return;
        }
      }
      finally {}
      paramAdModuleVideo = null;
    }
  }
  
  public final void a(@NotNull ReportConstants.VideoEndType paramVideoEndType)
  {
    Intrinsics.checkParameterIsNotNull(paramVideoEndType, "videoEndTYpe");
    n = paramVideoEndType;
  }
  
  public final void a(@Nullable String paramString, @Nullable VideoStateCallback paramVideoStateCallback)
  {
    if (paramString != null) {
      ((Map)k).put(paramString, paramVideoStateCallback);
    }
  }
  
  public final void a(boolean paramBoolean)
  {
    ReadInJoyAdLog.a("VideoPlayerWrapper_AD", "onInitOrBeforeReplay");
    m();
    b.d();
    b.c().c(1);
    b.c().d(0);
    b.c().a(paramBoolean);
    if (paramBoolean)
    {
      VideoAdReportData localVideoAdReportData = b.c();
      localVideoAdReportData.h(localVideoAdReportData.h() + 1);
      return;
    }
    b.c().h(0);
  }
  
  public final boolean a(@Nullable ProteusBannerVideoItemData paramProteusBannerVideoItemData)
  {
    Object localObject1 = b.b();
    Object localObject2 = null;
    if (localObject1 != null) {
      localObject1 = ((ProteusBannerVideoItemData)localObject1).G;
    } else {
      localObject1 = null;
    }
    if (!TextUtils.isEmpty((CharSequence)localObject1))
    {
      ProteusBannerVideoItemData localProteusBannerVideoItemData = b.b();
      localObject1 = localObject2;
      if (localProteusBannerVideoItemData != null) {
        localObject1 = localProteusBannerVideoItemData.G;
      }
      if (paramProteusBannerVideoItemData != null)
      {
        paramProteusBannerVideoItemData = paramProteusBannerVideoItemData.G;
        if (paramProteusBannerVideoItemData != null) {}
      }
      else
      {
        paramProteusBannerVideoItemData = "";
      }
      if (Intrinsics.areEqual(localObject1, paramProteusBannerVideoItemData))
      {
        QLog.d("VideoPlayerWrapper_AD", 1, "setVideoData with same data");
        return true;
      }
    }
    return false;
  }
  
  public final void b()
  {
    e();
    n = ReportConstants.VideoEndType.CLICK_PAUSE;
  }
  
  public final void c()
  {
    g();
  }
  
  public final void d()
  {
    ReadInJoyAdLog.a("VideoPlayerWrapper_AD", "onDestroy");
    m();
    j = (MediaPlayListenerAdapter)null;
    Handler localHandler = g;
    if (localHandler != null) {
      localHandler.removeCallbacksAndMessages(null);
    }
    k.clear();
    b.d();
    e = (SoftReference)null;
    l = false;
    f.set(0, 0, 0, 0);
  }
  
  public final void e()
  {
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("startVideo: inPlayArea = ");
    ((StringBuilder)localObject2).append(l);
    ((StringBuilder)localObject2).append("  isPlaying = ");
    Object localObject1 = d;
    if (localObject1 != null) {
      localObject1 = Boolean.valueOf(((IVideoPlayerWrapper)localObject1).n());
    } else {
      localObject1 = null;
    }
    ((StringBuilder)localObject2).append(localObject1);
    ((StringBuilder)localObject2).append("  playState = ");
    ((StringBuilder)localObject2).append(h());
    ReadInJoyAdLog.a("VideoPlayerWrapper_AD", ((StringBuilder)localObject2).toString());
    if (!l)
    {
      g();
      return;
    }
    localObject1 = d;
    if ((localObject1 != null) && (!((IVideoPlayerWrapper)localObject1).n()) && (h() >= 2))
    {
      localObject1 = d;
      if (localObject1 != null) {
        ((IVideoPlayerWrapper)localObject1).u();
      }
      i.set(3);
      localObject2 = ((Map)k).entrySet().iterator();
      while (((Iterator)localObject2).hasNext())
      {
        VideoStateCallback localVideoStateCallback = (VideoStateCallback)((Map.Entry)((Iterator)localObject2).next()).getValue();
        if (localVideoStateCallback != null)
        {
          localObject1 = b.b();
          if (localObject1 != null) {
            localObject1 = ((ProteusBannerVideoItemData)localObject1).G;
          } else {
            localObject1 = null;
          }
          localVideoStateCallback.a((String)localObject1);
        }
      }
      ReadInJoyAdLog.a("VideoPlayerWrapper_AD", "startVideo");
    }
  }
  
  public final void f()
  {
    Object localObject = e;
    if (localObject != null) {
      localObject = (RelativeLayout)((SoftReference)localObject).get();
    } else {
      localObject = null;
    }
    l = ReadInJoyBottomAdVideoUtil.a((View)localObject, f);
    e();
  }
  
  public final void g()
  {
    Object localObject1 = d;
    if ((localObject1 != null) && (((IVideoPlayerWrapper)localObject1).n() == true) && (i.get() != 5))
    {
      l = false;
      localObject1 = d;
      if (localObject1 != null) {
        ((IVideoPlayerWrapper)localObject1).w();
      }
      i.set(5);
      b.c().e(2);
      localObject1 = b.c();
      Object localObject2 = d;
      int i1;
      if (localObject2 != null) {
        i1 = (int)((IVideoPlayerWrapper)localObject2).C();
      } else {
        i1 = -1;
      }
      ((VideoAdReportData)localObject1).b(i1);
      localObject2 = ((Map)k).entrySet().iterator();
      while (((Iterator)localObject2).hasNext())
      {
        VideoStateCallback localVideoStateCallback = (VideoStateCallback)((Map.Entry)((Iterator)localObject2).next()).getValue();
        if (localVideoStateCallback != null)
        {
          localObject1 = b.b();
          if (localObject1 != null) {
            localObject1 = ((ProteusBannerVideoItemData)localObject1).G;
          } else {
            localObject1 = null;
          }
          localVideoStateCallback.b((String)localObject1);
        }
      }
      a(5);
      b.c().a(b.c().b());
      b.c().c(0);
      ReadInJoyAdLog.a("VideoPlayerWrapper_AD", "pauseVideo");
    }
  }
  
  public final int h()
  {
    return i.get();
  }
  
  public final long i()
  {
    IVideoPlayerWrapper localIVideoPlayerWrapper = d;
    if (localIVideoPlayerWrapper != null) {
      return localIVideoPlayerWrapper.C();
    }
    return 0L;
  }
  
  public final boolean j()
  {
    IVideoPlayerWrapper localIVideoPlayerWrapper = d;
    if (localIVideoPlayerWrapper != null) {
      return localIVideoPlayerWrapper.n();
    }
    return false;
  }
  
  public final void k()
  {
    a(ReportConstants.VideoEndType.AD_AREA_CLICK);
    a(5);
  }
  
  public void onNetMobile2None()
  {
    g();
  }
  
  public void onNetMobile2Wifi(@Nullable String paramString)
  {
    n();
  }
  
  public void onNetNone2Mobile(@Nullable String paramString)
  {
    n();
  }
  
  public void onNetNone2Wifi(@Nullable String paramString)
  {
    n();
  }
  
  public void onNetWifi2Mobile(@Nullable String paramString)
  {
    n();
  }
  
  public void onNetWifi2None()
  {
    Handler localHandler = g;
    if (localHandler != null) {
      localHandler.postDelayed((Runnable)FastWebVideoPlayManager.onNetWifi2None.1.a, 3000L);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoyAd.ad.video.FastWebVideoPlayManager
 * JD-Core Version:    0.7.0.1
 */