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

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/biz/pubaccount/readinjoyAd/ad/video/FastWebVideoPlayManager;", "Lcom/tencent/mobileqq/msf/sdk/handler/INetInfoHandler;", "()V", "TAG", "", "context", "Ljava/lang/ref/WeakReference;", "Landroid/content/Context;", "hasVideoPlayTaskRunning", "", "inPlayArea", "isNetChangeAutoPlaySwitchOpen", "mediaPlayListenerAdapter", "Lcom/tencent/mobileqq/kandian/base/video/player/MediaPlayListenerAdapter;", "playState", "Ljava/util/concurrent/atomic/AtomicInteger;", "rect", "Landroid/graphics/Rect;", "stateCallbackList", "Ljava/util/concurrent/ConcurrentHashMap;", "Lcom/tencent/biz/pubaccount/readinjoyAd/ad/video/VideoStateCallback;", "uiHandler", "Landroid/os/Handler;", "videoContainer", "Ljava/lang/ref/SoftReference;", "Landroid/widget/RelativeLayout;", "videoModule", "Lcom/tencent/biz/pubaccount/readinjoyAd/ad/video/FastWebVideoModule;", "videoPauseType", "Lcom/tencent/biz/pubaccount/NativeAd/report/constant/ReportConstants$VideoEndType;", "videoPlayer", "Lcom/tencent/mobileqq/kandian/base/video/player/api/IVideoPlayerWrapper;", "createPlayerObserver", "doVideoReport", "", "state", "", "getCurrentPos", "", "getPlayState", "initVideoPlayer", "isPlaying", "isSameData", "adData", "Lcom/tencent/biz/pubaccount/readinjoyAd/ad/data/ProteusBannerVideoItemData;", "netChange", "onCreate", "onDestroy", "onInitOrBeforeReplay", "isReplay", "onNetMobile2None", "onNetMobile2Wifi", "p0", "onNetNone2Mobile", "onNetNone2Wifi", "onNetWifi2Mobile", "onNetWifi2None", "onPause", "onResume", "pauseVideo", "releasePlayer", "setStateCallback", "url", "callback", "setVideoData", "videoData", "Lcom/tencent/biz/pubaccount/NativeAd/module/AdModuleVideo;", "adInfo", "Lcom/tencent/biz/pubaccount/readinjoy/struct/AdvertisementInfo;", "setVideoPauseType", "videoEndTYpe", "startVideo", "startVideoWhenScroll", "kandian_ad_feature_impl_release"}, k=1, mv={1, 1, 16})
public final class FastWebVideoPlayManager
  implements INetInfoHandler
{
  private static Rect jdField_a_of_type_AndroidGraphicsRect;
  private static Handler jdField_a_of_type_AndroidOsHandler;
  private static ReportConstants.VideoEndType jdField_a_of_type_ComTencentBizPubaccountNativeAdReportConstantReportConstants$VideoEndType = ReportConstants.VideoEndType.CLICK_PAUSE;
  private static FastWebVideoModule jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdVideoFastWebVideoModule;
  public static final FastWebVideoPlayManager a;
  private static volatile MediaPlayListenerAdapter jdField_a_of_type_ComTencentMobileqqKandianBaseVideoPlayerMediaPlayListenerAdapter;
  private static IVideoPlayerWrapper jdField_a_of_type_ComTencentMobileqqKandianBaseVideoPlayerApiIVideoPlayerWrapper;
  private static SoftReference<RelativeLayout> jdField_a_of_type_JavaLangRefSoftReference;
  private static WeakReference<Context> jdField_a_of_type_JavaLangRefWeakReference;
  private static ConcurrentHashMap<String, VideoStateCallback> jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap;
  private static volatile AtomicInteger jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger;
  private static volatile boolean jdField_a_of_type_Boolean;
  private static boolean b;
  private static boolean c;
  
  static
  {
    jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdVideoFastWebVideoPlayManager = new FastWebVideoPlayManager();
    jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdVideoFastWebVideoModule = new FastWebVideoModule();
    jdField_a_of_type_AndroidGraphicsRect = new Rect();
    jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger = new AtomicInteger(0);
    jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
  }
  
  private final MediaPlayListenerAdapter a()
  {
    return (MediaPlayListenerAdapter)new FastWebVideoPlayManager.createPlayerObserver.1();
  }
  
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
        localObject2 = ((IRIJAdUtilService)QRoute.api(IRIJAdUtilService.class)).getVideoInfoObject(jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdVideoFastWebVideoModule.a().a(), jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdVideoFastWebVideoModule.a().g(), 0, 1, jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdVideoFastWebVideoModule.a().e(), jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdVideoFastWebVideoModule.a().f(), jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdVideoFastWebVideoModule.a().g(), 1, 0, jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdVideoFastWebVideoModule.a().h(), ReportConstants.VideoEndType.NORMAL_COMPLETE, jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdVideoFastWebVideoModule.a().a(), false);
        localObject3 = new StringBuilder();
        ((StringBuilder)localObject3).append("complete videoJson = ");
        ((StringBuilder)localObject3).append(localObject2);
        ReadInJoyAdLog.a("VideoPlayerWrapper_AD", ((StringBuilder)localObject3).toString());
        localObject3 = (IRIJAdService)QRoute.api(IRIJAdService.class);
        localObject4 = new AdReportData();
        localObject5 = jdField_a_of_type_JavaLangRefWeakReference;
        if (localObject5 != null) {
          localObject1 = (Context)((WeakReference)localObject5).get();
        }
        ((IRIJAdService)localObject3).report(((AdReportData)localObject4).a((Context)localObject1).a(6).b(1).a(jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdVideoFastWebVideoModule.a()).a((JSONObject)localObject2));
        jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdVideoFastWebVideoModule.a().a(0);
        jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdVideoFastWebVideoModule.a().b(jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdVideoFastWebVideoModule.a().g());
        jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdVideoFastWebVideoModule.a().d(0);
        jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdVideoFastWebVideoModule.a().c(1);
        return;
      }
      localObject2 = (IRIJAdService)QRoute.api(IRIJAdService.class);
      localObject4 = new AdReportData();
      localObject5 = jdField_a_of_type_JavaLangRefWeakReference;
      localObject1 = localObject3;
      if (localObject5 != null) {
        localObject1 = (Context)((WeakReference)localObject5).get();
      }
      ((IRIJAdService)localObject2).report(((AdReportData)localObject4).a((Context)localObject1).a(6).b(1).a(jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdVideoFastWebVideoModule.a()).a(((IRIJAdUtilService)QRoute.api(IRIJAdUtilService.class)).getVideoInfoObject(0, 0, 0, 0, 0, 0, jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdVideoFastWebVideoModule.a().g(), 1, 2, jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdVideoFastWebVideoModule.a().h(), ReportConstants.VideoEndType.OTHER, jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdVideoFastWebVideoModule.a().a(), false)));
      return;
    }
    jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdVideoFastWebVideoModule.a().b((int)a());
    localObject3 = ((IRIJAdUtilService)QRoute.api(IRIJAdUtilService.class)).getVideoInfoObject(jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdVideoFastWebVideoModule.a().a(), jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdVideoFastWebVideoModule.a().b(), jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdVideoFastWebVideoModule.a().c(), jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdVideoFastWebVideoModule.a().d(), jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdVideoFastWebVideoModule.a().e(), jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdVideoFastWebVideoModule.a().f(), jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdVideoFastWebVideoModule.a().g(), 1, 0, jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdVideoFastWebVideoModule.a().h(), jdField_a_of_type_ComTencentBizPubaccountNativeAdReportConstantReportConstants$VideoEndType, jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdVideoFastWebVideoModule.a().a(), false);
    localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("pause videoJson = ");
    ((StringBuilder)localObject1).append(localObject3);
    ReadInJoyAdLog.a("VideoPlayerWrapper_AD", ((StringBuilder)localObject1).toString());
    Object localObject4 = (IRIJAdService)QRoute.api(IRIJAdService.class);
    Object localObject5 = new AdReportData();
    WeakReference localWeakReference = jdField_a_of_type_JavaLangRefWeakReference;
    localObject1 = localObject2;
    if (localWeakReference != null) {
      localObject1 = (Context)localWeakReference.get();
    }
    ((IRIJAdService)localObject4).report(((AdReportData)localObject5).a((Context)localObject1).a(6).b(1).a(jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdVideoFastWebVideoModule.a()).a((JSONObject)localObject3));
    jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdVideoFastWebVideoModule.a().a(jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdVideoFastWebVideoModule.a().b());
    jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdVideoFastWebVideoModule.a().c(0);
    jdField_a_of_type_ComTencentBizPubaccountNativeAdReportConstantReportConstants$VideoEndType = ReportConstants.VideoEndType.CLICK_PAUSE;
  }
  
  private final void a(Context paramContext, RelativeLayout paramRelativeLayout)
  {
    if (paramContext == null) {
      return;
    }
    if (jdField_a_of_type_ComTencentMobileqqKandianBaseVideoPlayerApiIVideoPlayerWrapper != null) {
      h();
    }
    paramContext = ((IVideoPlayerWrapperFactory)QRoute.api(IVideoPlayerWrapperFactory.class)).createPlayer(paramContext);
    paramContext.a((ViewGroup)paramRelativeLayout, true);
    paramContext.b(2);
    if (jdField_a_of_type_ComTencentMobileqqKandianBaseVideoPlayerMediaPlayListenerAdapter == null) {
      jdField_a_of_type_ComTencentMobileqqKandianBaseVideoPlayerMediaPlayListenerAdapter = jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdVideoFastWebVideoPlayManager.a();
    }
    paramContext.a((MediaPlayListener)jdField_a_of_type_ComTencentMobileqqKandianBaseVideoPlayerMediaPlayListenerAdapter);
    paramContext.c(true);
    jdField_a_of_type_ComTencentMobileqqKandianBaseVideoPlayerApiIVideoPlayerWrapper = paramContext;
  }
  
  private final void h()
  {
    ReadInJoyAdLog.a("VideoPlayerWrapper_AD", "releasePlayer");
    IVideoPlayerWrapper localIVideoPlayerWrapper = jdField_a_of_type_ComTencentMobileqqKandianBaseVideoPlayerApiIVideoPlayerWrapper;
    if (localIVideoPlayerWrapper != null) {
      localIVideoPlayerWrapper.g();
    }
    localIVideoPlayerWrapper = jdField_a_of_type_ComTencentMobileqqKandianBaseVideoPlayerApiIVideoPlayerWrapper;
    if (localIVideoPlayerWrapper != null) {
      localIVideoPlayerWrapper.h();
    }
    localIVideoPlayerWrapper = jdField_a_of_type_ComTencentMobileqqKandianBaseVideoPlayerApiIVideoPlayerWrapper;
    if (localIVideoPlayerWrapper != null) {
      localIVideoPlayerWrapper.a(null);
    }
    jdField_a_of_type_ComTencentMobileqqKandianBaseVideoPlayerApiIVideoPlayerWrapper = (IVideoPlayerWrapper)null;
    jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.set(0);
    jdField_a_of_type_Boolean = false;
  }
  
  private final void i()
  {
    if (c)
    {
      e();
      return;
    }
    g();
  }
  
  public final int a()
  {
    return jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.get();
  }
  
  public final long a()
  {
    IVideoPlayerWrapper localIVideoPlayerWrapper = jdField_a_of_type_ComTencentMobileqqKandianBaseVideoPlayerApiIVideoPlayerWrapper;
    if (localIVideoPlayerWrapper != null) {
      return localIVideoPlayerWrapper.a();
    }
    return 0L;
  }
  
  public final void a()
  {
    ReadInJoyAdLog.a("VideoPlayerWrapper_AD", "onCreate");
    h();
    jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper());
  }
  
  public final void a(@Nullable Context paramContext, @Nullable RelativeLayout paramRelativeLayout, @Nullable AdModuleVideo paramAdModuleVideo, @Nullable AdvertisementInfo paramAdvertisementInfo, @Nullable ProteusBannerVideoItemData paramProteusBannerVideoItemData)
  {
    for (;;)
    {
      try
      {
        if (jdField_a_of_type_Boolean)
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
          jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramContext);
          jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdVideoFastWebVideoModule.a(paramAdModuleVideo);
          jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdVideoFastWebVideoModule.a(paramProteusBannerVideoItemData);
          jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdVideoFastWebVideoModule.a(paramAdvertisementInfo);
          paramProteusBannerVideoItemData = jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdVideoFastWebVideoModule.a();
          ProteusBannerVideoItemData localProteusBannerVideoItemData = jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdVideoFastWebVideoModule.a();
          paramAdModuleVideo = jdField_a_of_type_JavaLangRefWeakReference;
          paramAdvertisementInfo = null;
          if (paramAdModuleVideo != null)
          {
            paramAdModuleVideo = (Context)paramAdModuleVideo.get();
            c = ReadInJoyAdSwitchUtil.a(paramProteusBannerVideoItemData, localProteusBannerVideoItemData, paramAdModuleVideo, 2);
            jdField_a_of_type_JavaLangRefSoftReference = new SoftReference(paramRelativeLayout);
            a(paramContext, paramRelativeLayout);
            ReadInJoyAdLog.a("VideoPlayerWrapper_AD", "ready to playerStartByUrl");
            paramRelativeLayout = jdField_a_of_type_ComTencentMobileqqKandianBaseVideoPlayerApiIVideoPlayerWrapper;
            if (paramRelativeLayout != null)
            {
              paramAdModuleVideo = jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdVideoFastWebVideoModule.a();
              paramContext = paramAdvertisementInfo;
              if (paramAdModuleVideo != null) {
                paramContext = paramAdModuleVideo.w;
              }
              paramRelativeLayout.a(null, paramContext, 3, 1L, 0L, 0);
            }
            jdField_a_of_type_Boolean = true;
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
    jdField_a_of_type_ComTencentBizPubaccountNativeAdReportConstantReportConstants$VideoEndType = paramVideoEndType;
  }
  
  public final void a(@Nullable String paramString, @Nullable VideoStateCallback paramVideoStateCallback)
  {
    if (paramString != null) {
      ((Map)jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap).put(paramString, paramVideoStateCallback);
    }
  }
  
  public final void a(boolean paramBoolean)
  {
    ReadInJoyAdLog.a("VideoPlayerWrapper_AD", "onInitOrBeforeReplay");
    h();
    jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdVideoFastWebVideoModule.a();
    jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdVideoFastWebVideoModule.a().c(1);
    jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdVideoFastWebVideoModule.a().d(0);
    jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdVideoFastWebVideoModule.a().a(paramBoolean);
    if (paramBoolean)
    {
      VideoAdReportData localVideoAdReportData = jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdVideoFastWebVideoModule.a();
      localVideoAdReportData.h(localVideoAdReportData.h() + 1);
      return;
    }
    jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdVideoFastWebVideoModule.a().h(0);
  }
  
  public final boolean a()
  {
    IVideoPlayerWrapper localIVideoPlayerWrapper = jdField_a_of_type_ComTencentMobileqqKandianBaseVideoPlayerApiIVideoPlayerWrapper;
    if (localIVideoPlayerWrapper != null) {
      return localIVideoPlayerWrapper.f();
    }
    return false;
  }
  
  public final boolean a(@Nullable ProteusBannerVideoItemData paramProteusBannerVideoItemData)
  {
    Object localObject1 = jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdVideoFastWebVideoModule.a();
    Object localObject2 = null;
    if (localObject1 != null) {
      localObject1 = ((ProteusBannerVideoItemData)localObject1).w;
    } else {
      localObject1 = null;
    }
    if (!TextUtils.isEmpty((CharSequence)localObject1))
    {
      ProteusBannerVideoItemData localProteusBannerVideoItemData = jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdVideoFastWebVideoModule.a();
      localObject1 = localObject2;
      if (localProteusBannerVideoItemData != null) {
        localObject1 = localProteusBannerVideoItemData.w;
      }
      if (paramProteusBannerVideoItemData != null)
      {
        paramProteusBannerVideoItemData = paramProteusBannerVideoItemData.w;
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
    jdField_a_of_type_ComTencentBizPubaccountNativeAdReportConstantReportConstants$VideoEndType = ReportConstants.VideoEndType.CLICK_PAUSE;
  }
  
  public final void c()
  {
    g();
  }
  
  public final void d()
  {
    ReadInJoyAdLog.a("VideoPlayerWrapper_AD", "onDestroy");
    h();
    jdField_a_of_type_ComTencentMobileqqKandianBaseVideoPlayerMediaPlayListenerAdapter = (MediaPlayListenerAdapter)null;
    Handler localHandler = jdField_a_of_type_AndroidOsHandler;
    if (localHandler != null) {
      localHandler.removeCallbacksAndMessages(null);
    }
    jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.clear();
    jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdVideoFastWebVideoModule.a();
    jdField_a_of_type_JavaLangRefSoftReference = (SoftReference)null;
    b = false;
    jdField_a_of_type_AndroidGraphicsRect.set(0, 0, 0, 0);
  }
  
  public final void e()
  {
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("startVideo: inPlayArea = ");
    ((StringBuilder)localObject2).append(b);
    ((StringBuilder)localObject2).append("  isPlaying = ");
    Object localObject1 = jdField_a_of_type_ComTencentMobileqqKandianBaseVideoPlayerApiIVideoPlayerWrapper;
    if (localObject1 != null) {
      localObject1 = Boolean.valueOf(((IVideoPlayerWrapper)localObject1).f());
    } else {
      localObject1 = null;
    }
    ((StringBuilder)localObject2).append(localObject1);
    ((StringBuilder)localObject2).append("  playState = ");
    ((StringBuilder)localObject2).append(a());
    ReadInJoyAdLog.a("VideoPlayerWrapper_AD", ((StringBuilder)localObject2).toString());
    if (!b)
    {
      g();
      return;
    }
    localObject1 = jdField_a_of_type_ComTencentMobileqqKandianBaseVideoPlayerApiIVideoPlayerWrapper;
    if ((localObject1 != null) && (!((IVideoPlayerWrapper)localObject1).f()) && (a() >= 2))
    {
      localObject1 = jdField_a_of_type_ComTencentMobileqqKandianBaseVideoPlayerApiIVideoPlayerWrapper;
      if (localObject1 != null) {
        ((IVideoPlayerWrapper)localObject1).d();
      }
      jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.set(3);
      localObject2 = ((Map)jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap).entrySet().iterator();
      while (((Iterator)localObject2).hasNext())
      {
        VideoStateCallback localVideoStateCallback = (VideoStateCallback)((Map.Entry)((Iterator)localObject2).next()).getValue();
        if (localVideoStateCallback != null)
        {
          localObject1 = jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdVideoFastWebVideoModule.a();
          if (localObject1 != null) {
            localObject1 = ((ProteusBannerVideoItemData)localObject1).w;
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
    Object localObject = jdField_a_of_type_JavaLangRefSoftReference;
    if (localObject != null) {
      localObject = (RelativeLayout)((SoftReference)localObject).get();
    } else {
      localObject = null;
    }
    b = ReadInJoyBottomAdVideoUtil.a((View)localObject, jdField_a_of_type_AndroidGraphicsRect);
    e();
  }
  
  public final void g()
  {
    Object localObject1 = jdField_a_of_type_ComTencentMobileqqKandianBaseVideoPlayerApiIVideoPlayerWrapper;
    if ((localObject1 != null) && (((IVideoPlayerWrapper)localObject1).f() == true) && (jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.get() != 5))
    {
      b = false;
      localObject1 = jdField_a_of_type_ComTencentMobileqqKandianBaseVideoPlayerApiIVideoPlayerWrapper;
      if (localObject1 != null) {
        ((IVideoPlayerWrapper)localObject1).f();
      }
      jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.set(5);
      jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdVideoFastWebVideoModule.a().e(2);
      localObject1 = jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdVideoFastWebVideoModule.a();
      Object localObject2 = jdField_a_of_type_ComTencentMobileqqKandianBaseVideoPlayerApiIVideoPlayerWrapper;
      int i;
      if (localObject2 != null) {
        i = (int)((IVideoPlayerWrapper)localObject2).a();
      } else {
        i = -1;
      }
      ((VideoAdReportData)localObject1).b(i);
      localObject2 = ((Map)jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap).entrySet().iterator();
      while (((Iterator)localObject2).hasNext())
      {
        VideoStateCallback localVideoStateCallback = (VideoStateCallback)((Map.Entry)((Iterator)localObject2).next()).getValue();
        if (localVideoStateCallback != null)
        {
          localObject1 = jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdVideoFastWebVideoModule.a();
          if (localObject1 != null) {
            localObject1 = ((ProteusBannerVideoItemData)localObject1).w;
          } else {
            localObject1 = null;
          }
          localVideoStateCallback.b((String)localObject1);
        }
      }
      a(5);
      jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdVideoFastWebVideoModule.a().a(jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdVideoFastWebVideoModule.a().b());
      jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdVideoFastWebVideoModule.a().c(0);
      ReadInJoyAdLog.a("VideoPlayerWrapper_AD", "pauseVideo");
    }
  }
  
  public void onNetMobile2None()
  {
    g();
  }
  
  public void onNetMobile2Wifi(@Nullable String paramString)
  {
    i();
  }
  
  public void onNetNone2Mobile(@Nullable String paramString)
  {
    i();
  }
  
  public void onNetNone2Wifi(@Nullable String paramString)
  {
    i();
  }
  
  public void onNetWifi2Mobile(@Nullable String paramString)
  {
    i();
  }
  
  public void onNetWifi2None()
  {
    Handler localHandler = jdField_a_of_type_AndroidOsHandler;
    if (localHandler != null) {
      localHandler.postDelayed((Runnable)FastWebVideoPlayManager.onNetWifi2None.1.a, 3000L);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoyAd.ad.video.FastWebVideoPlayManager
 * JD-Core Version:    0.7.0.1
 */