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
import com.tencent.biz.pubaccount.NativeAd.util.NativeAdUtils;
import com.tencent.biz.pubaccount.readinjoy.struct.AdvertisementInfo;
import com.tencent.biz.pubaccount.readinjoy.video.MediaPlayListenerAdapter;
import com.tencent.biz.pubaccount.readinjoy.video.VideoPlayerWrapper;
import com.tencent.biz.pubaccount.readinjoy.video.VideoPlayerWrapper.MediaPlayListener;
import com.tencent.biz.pubaccount.readinjoyAd.ad.data.AdReportData;
import com.tencent.biz.pubaccount.readinjoyAd.ad.data.ProteusBannerVideoItemData;
import com.tencent.biz.pubaccount.readinjoyAd.ad.utils.ReadInJoyAdLog;
import com.tencent.biz.pubaccount.readinjoyAd.ad.utils.ReadInJoyAdSwitchUtil;
import com.tencent.biz.pubaccount.readinjoyAd.ad.utils.ReadInJoyBottomAdVideoUtil;
import com.tencent.mobileqq.msf.sdk.handler.INetInfoHandler;
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

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/biz/pubaccount/readinjoyAd/ad/video/FastWebVideoPlayManager;", "Lcom/tencent/mobileqq/msf/sdk/handler/INetInfoHandler;", "()V", "TAG", "", "context", "Ljava/lang/ref/WeakReference;", "Landroid/content/Context;", "hasVideoPlayTaskRunning", "", "inPlayArea", "isNetChangeAutoPlaySwitchOpen", "mediaPlayListenerAdapter", "Lcom/tencent/biz/pubaccount/readinjoy/video/MediaPlayListenerAdapter;", "playState", "Ljava/util/concurrent/atomic/AtomicInteger;", "rect", "Landroid/graphics/Rect;", "stateCallbackList", "Ljava/util/concurrent/ConcurrentHashMap;", "Lcom/tencent/biz/pubaccount/readinjoyAd/ad/video/VideoStateCallback;", "uiHandler", "Landroid/os/Handler;", "videoContainer", "Ljava/lang/ref/SoftReference;", "Landroid/widget/RelativeLayout;", "videoModule", "Lcom/tencent/biz/pubaccount/readinjoyAd/ad/video/FastWebVideoModule;", "videoPauseType", "Lcom/tencent/biz/pubaccount/NativeAd/report/constant/ReportConstants$VideoEndType;", "videoPlayer", "Lcom/tencent/biz/pubaccount/readinjoy/video/VideoPlayerWrapper;", "createPlayerObserver", "doVideoReport", "", "state", "", "getCurrentPos", "", "getPlayState", "initVideoPlayer", "isPlaying", "isSameData", "adData", "Lcom/tencent/biz/pubaccount/readinjoyAd/ad/data/ProteusBannerVideoItemData;", "netChange", "onCreate", "onDestroy", "onInitOrBeforeReplay", "isReplay", "onNetMobile2None", "onNetMobile2Wifi", "p0", "onNetNone2Mobile", "onNetNone2Wifi", "onNetWifi2Mobile", "onNetWifi2None", "onPause", "onResume", "pauseVideo", "releasePlayer", "setStateCallback", "url", "callback", "setVideoData", "videoData", "Lcom/tencent/biz/pubaccount/NativeAd/module/AdModuleVideo;", "adInfo", "Lcom/tencent/biz/pubaccount/readinjoy/struct/AdvertisementInfo;", "setVideoPauseType", "videoEndTYpe", "startVideo", "startVideoWhenScroll", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
public final class FastWebVideoPlayManager
  implements INetInfoHandler
{
  private static Rect jdField_a_of_type_AndroidGraphicsRect;
  private static Handler jdField_a_of_type_AndroidOsHandler;
  private static ReportConstants.VideoEndType jdField_a_of_type_ComTencentBizPubaccountNativeAdReportConstantReportConstants$VideoEndType = ReportConstants.VideoEndType.CLICK_PAUSE;
  private static volatile MediaPlayListenerAdapter jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoMediaPlayListenerAdapter;
  private static VideoPlayerWrapper jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayerWrapper;
  private static FastWebVideoModule jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdVideoFastWebVideoModule;
  public static final FastWebVideoPlayManager a;
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
    AdReportData localAdReportData;
    switch (paramInt)
    {
    default: 
      return;
    case 7: 
      localObject2 = NativeAdUtils.a(jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdVideoFastWebVideoModule.a().a(), jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdVideoFastWebVideoModule.a().g(), 0, 1, jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdVideoFastWebVideoModule.a().e(), jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdVideoFastWebVideoModule.a().f(), jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdVideoFastWebVideoModule.a().g(), 1, 0, jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdVideoFastWebVideoModule.a().h(), ReportConstants.VideoEndType.NORMAL_COMPLETE, jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdVideoFastWebVideoModule.a().a(), false);
      ReadInJoyAdLog.a("VideoPlayerWrapper_AD", "complete videoJson = " + localObject2);
      localAdReportData = new AdReportData();
      localObject1 = jdField_a_of_type_JavaLangRefWeakReference;
      if (localObject1 != null) {}
      for (localObject1 = (Context)((WeakReference)localObject1).get();; localObject1 = null)
      {
        NativeAdUtils.a(localAdReportData.a((Context)localObject1).a(6).b(1).a(jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdVideoFastWebVideoModule.a()).a((JSONObject)localObject2));
        jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdVideoFastWebVideoModule.a().a(0);
        jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdVideoFastWebVideoModule.a().b(jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdVideoFastWebVideoModule.a().g());
        jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdVideoFastWebVideoModule.a().d(0);
        jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdVideoFastWebVideoModule.a().c(1);
        return;
      }
    case 5: 
      jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdVideoFastWebVideoModule.a().b((int)a());
      localObject2 = NativeAdUtils.a(jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdVideoFastWebVideoModule.a().a(), jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdVideoFastWebVideoModule.a().b(), jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdVideoFastWebVideoModule.a().c(), jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdVideoFastWebVideoModule.a().d(), jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdVideoFastWebVideoModule.a().e(), jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdVideoFastWebVideoModule.a().f(), jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdVideoFastWebVideoModule.a().g(), 1, 0, jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdVideoFastWebVideoModule.a().h(), jdField_a_of_type_ComTencentBizPubaccountNativeAdReportConstantReportConstants$VideoEndType, jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdVideoFastWebVideoModule.a().a(), false);
      ReadInJoyAdLog.a("VideoPlayerWrapper_AD", "pause videoJson = " + localObject2);
      localAdReportData = new AdReportData();
      localObject1 = jdField_a_of_type_JavaLangRefWeakReference;
      if (localObject1 != null) {}
      for (localObject1 = (Context)((WeakReference)localObject1).get();; localObject1 = null)
      {
        NativeAdUtils.a(localAdReportData.a((Context)localObject1).a(6).b(1).a(jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdVideoFastWebVideoModule.a()).a((JSONObject)localObject2));
        jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdVideoFastWebVideoModule.a().a(jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdVideoFastWebVideoModule.a().b());
        jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdVideoFastWebVideoModule.a().c(0);
        jdField_a_of_type_ComTencentBizPubaccountNativeAdReportConstantReportConstants$VideoEndType = ReportConstants.VideoEndType.CLICK_PAUSE;
        return;
      }
    }
    Object localObject2 = new AdReportData();
    Object localObject1 = jdField_a_of_type_JavaLangRefWeakReference;
    if (localObject1 != null) {}
    for (localObject1 = (Context)((WeakReference)localObject1).get();; localObject1 = null)
    {
      NativeAdUtils.a(((AdReportData)localObject2).a((Context)localObject1).a(6).b(1).a(jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdVideoFastWebVideoModule.a()).a(NativeAdUtils.a(0, 0, 0, 0, 0, 0, jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdVideoFastWebVideoModule.a().g(), 1, 2, jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdVideoFastWebVideoModule.a().h(), ReportConstants.VideoEndType.OTHER, jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdVideoFastWebVideoModule.a().a(), false)));
      return;
    }
  }
  
  private final void a(Context paramContext, RelativeLayout paramRelativeLayout)
  {
    if (paramContext == null) {
      return;
    }
    if (jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayerWrapper != null) {
      h();
    }
    paramContext = new VideoPlayerWrapper(paramContext);
    paramContext.a((ViewGroup)paramRelativeLayout, true);
    paramContext.b(2);
    if (jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoMediaPlayListenerAdapter == null) {
      jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoMediaPlayListenerAdapter = jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdVideoFastWebVideoPlayManager.a();
    }
    paramContext.a((VideoPlayerWrapper.MediaPlayListener)jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoMediaPlayListenerAdapter);
    paramContext.c(true);
    jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayerWrapper = paramContext;
  }
  
  private final void h()
  {
    ReadInJoyAdLog.a("VideoPlayerWrapper_AD", "releasePlayer");
    VideoPlayerWrapper localVideoPlayerWrapper = jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayerWrapper;
    if (localVideoPlayerWrapper != null) {
      localVideoPlayerWrapper.g();
    }
    localVideoPlayerWrapper = jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayerWrapper;
    if (localVideoPlayerWrapper != null) {
      localVideoPlayerWrapper.h();
    }
    localVideoPlayerWrapper = jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayerWrapper;
    if (localVideoPlayerWrapper != null) {
      localVideoPlayerWrapper.a(null);
    }
    jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayerWrapper = (VideoPlayerWrapper)null;
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
    VideoPlayerWrapper localVideoPlayerWrapper = jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayerWrapper;
    if (localVideoPlayerWrapper != null) {
      return localVideoPlayerWrapper.a();
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
    Object localObject = null;
    label58:
    do
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
            continue;
          }
          if (paramAdModuleVideo == null) {
            break label58;
          }
        }
        finally {}
        if ((paramAdvertisementInfo == null) || (paramProteusBannerVideoItemData == null))
        {
          QLog.d("VideoPlayerWrapper_AD", 1, "setVideoData with empty data");
        }
        else
        {
          if (paramRelativeLayout != null) {
            break;
          }
          QLog.d("VideoPlayerWrapper_AD", 1, "setVideoData with empty videoContainer");
        }
      }
    } while (a(paramProteusBannerVideoItemData));
    jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramContext);
    jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdVideoFastWebVideoModule.a(paramAdModuleVideo);
    jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdVideoFastWebVideoModule.a(paramProteusBannerVideoItemData);
    jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdVideoFastWebVideoModule.a(paramAdvertisementInfo);
    paramAdvertisementInfo = jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdVideoFastWebVideoModule.a();
    paramProteusBannerVideoItemData = jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdVideoFastWebVideoModule.a();
    paramAdModuleVideo = jdField_a_of_type_JavaLangRefWeakReference;
    if (paramAdModuleVideo != null) {}
    for (paramAdModuleVideo = (Context)paramAdModuleVideo.get();; paramAdModuleVideo = null)
    {
      c = ReadInJoyAdSwitchUtil.a(paramAdvertisementInfo, paramProteusBannerVideoItemData, paramAdModuleVideo, 2);
      jdField_a_of_type_JavaLangRefSoftReference = new SoftReference(paramRelativeLayout);
      a(paramContext, paramRelativeLayout);
      ReadInJoyAdLog.a("VideoPlayerWrapper_AD", "ready to playerStartByUrl");
      paramRelativeLayout = jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayerWrapper;
      if (paramRelativeLayout != null)
      {
        paramAdModuleVideo = jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdVideoFastWebVideoModule.a();
        paramContext = localObject;
        if (paramAdModuleVideo != null) {
          paramContext = paramAdModuleVideo.o;
        }
        paramRelativeLayout.a(null, paramContext, 3, 1L, 0L, 0);
      }
      jdField_a_of_type_Boolean = true;
      break;
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
    VideoPlayerWrapper localVideoPlayerWrapper = jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayerWrapper;
    if (localVideoPlayerWrapper != null) {
      return localVideoPlayerWrapper.f();
    }
    return false;
  }
  
  public final boolean a(@Nullable ProteusBannerVideoItemData paramProteusBannerVideoItemData)
  {
    Object localObject2 = null;
    Object localObject1 = jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdVideoFastWebVideoModule.a();
    if (localObject1 != null)
    {
      localObject1 = ((ProteusBannerVideoItemData)localObject1).o;
      if (TextUtils.isEmpty((CharSequence)localObject1)) {
        break label93;
      }
      ProteusBannerVideoItemData localProteusBannerVideoItemData = jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdVideoFastWebVideoModule.a();
      localObject1 = localObject2;
      if (localProteusBannerVideoItemData != null) {
        localObject1 = localProteusBannerVideoItemData.o;
      }
      if (paramProteusBannerVideoItemData == null) {
        break label86;
      }
      paramProteusBannerVideoItemData = paramProteusBannerVideoItemData.o;
      if (paramProteusBannerVideoItemData == null) {
        break label86;
      }
    }
    for (;;)
    {
      if (!Intrinsics.areEqual(localObject1, paramProteusBannerVideoItemData)) {
        break label93;
      }
      QLog.d("VideoPlayerWrapper_AD", 1, "setVideoData with same data");
      return true;
      localObject1 = null;
      break;
      label86:
      paramProteusBannerVideoItemData = "";
    }
    label93:
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
    jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoMediaPlayListenerAdapter = (MediaPlayListenerAdapter)null;
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
    Object localObject2 = new StringBuilder().append("startVideo: inPlayArea = ").append(b).append("  isPlaying = ");
    Object localObject1 = jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayerWrapper;
    if (localObject1 != null)
    {
      localObject1 = Boolean.valueOf(((VideoPlayerWrapper)localObject1).f());
      ReadInJoyAdLog.a("VideoPlayerWrapper_AD", localObject1 + "  playState = " + a());
      if (b) {
        break label84;
      }
      g();
    }
    label84:
    do
    {
      return;
      localObject1 = null;
      break;
      localObject1 = jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayerWrapper;
    } while ((localObject1 == null) || (((VideoPlayerWrapper)localObject1).f()) || (a() < 2));
    localObject1 = jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayerWrapper;
    if (localObject1 != null) {
      ((VideoPlayerWrapper)localObject1).d();
    }
    jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.set(3);
    localObject2 = ((Map)jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap).entrySet().iterator();
    if (((Iterator)localObject2).hasNext())
    {
      VideoStateCallback localVideoStateCallback = (VideoStateCallback)((Map.Entry)((Iterator)localObject2).next()).getValue();
      if (localVideoStateCallback != null)
      {
        localObject1 = jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdVideoFastWebVideoModule.a();
        if (localObject1 == null) {
          break label200;
        }
      }
      label200:
      for (localObject1 = ((ProteusBannerVideoItemData)localObject1).o;; localObject1 = null)
      {
        localVideoStateCallback.a((String)localObject1);
        break;
      }
    }
    ReadInJoyAdLog.a("VideoPlayerWrapper_AD", "startVideo");
  }
  
  public final void f()
  {
    Object localObject = jdField_a_of_type_JavaLangRefSoftReference;
    if (localObject != null) {}
    for (localObject = (RelativeLayout)((SoftReference)localObject).get();; localObject = null)
    {
      b = ReadInJoyBottomAdVideoUtil.a((View)localObject, jdField_a_of_type_AndroidGraphicsRect);
      e();
      return;
    }
  }
  
  public final void g()
  {
    Object localObject1 = jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayerWrapper;
    if ((localObject1 != null) && (((VideoPlayerWrapper)localObject1).f() == true) && (jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.get() != 5))
    {
      b = false;
      localObject1 = jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayerWrapper;
      if (localObject1 != null) {
        ((VideoPlayerWrapper)localObject1).f();
      }
      jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.set(5);
      jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdVideoFastWebVideoModule.a().e(2);
      localObject1 = jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdVideoFastWebVideoModule.a();
      Object localObject2 = jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayerWrapper;
      int i;
      label102:
      VideoStateCallback localVideoStateCallback;
      if (localObject2 != null)
      {
        i = (int)((VideoPlayerWrapper)localObject2).a();
        ((VideoAdReportData)localObject1).b(i);
        localObject2 = ((Map)jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap).entrySet().iterator();
        if (!((Iterator)localObject2).hasNext()) {
          break label172;
        }
        localVideoStateCallback = (VideoStateCallback)((Map.Entry)((Iterator)localObject2).next()).getValue();
        if (localVideoStateCallback != null)
        {
          localObject1 = jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdVideoFastWebVideoModule.a();
          if (localObject1 == null) {
            break label167;
          }
        }
      }
      label167:
      for (localObject1 = ((ProteusBannerVideoItemData)localObject1).o;; localObject1 = null)
      {
        localVideoStateCallback.b((String)localObject1);
        break label102;
        i = -1;
        break;
      }
      label172:
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoyAd.ad.video.FastWebVideoPlayManager
 * JD-Core Version:    0.7.0.1
 */