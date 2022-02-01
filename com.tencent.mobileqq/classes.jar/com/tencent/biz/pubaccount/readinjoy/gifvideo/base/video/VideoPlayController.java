package com.tencent.biz.pubaccount.readinjoy.gifvideo.base.video;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import com.tencent.aladdin.config.Aladdin;
import com.tencent.aladdin.config.AladdinConfig;
import com.tencent.biz.pubaccount.readinjoy.decoupling.accesslayer.util.RIJThreadHandler;
import com.tencent.biz.pubaccount.readinjoy.gifvideo.base.video.statemachine.VideoState;
import com.tencent.biz.pubaccount.readinjoy.gifvideo.base.video.statemachine.VideoState.Companion;
import com.tencent.biz.pubaccount.readinjoy.gifvideo.utils.IStrategy;
import com.tencent.biz.pubaccount.readinjoy.gifvideo.utils.IStrategy.URLCallback;
import com.tencent.biz.pubaccount.readinjoy.gifvideo.utils.ReadInJoyVideoStrategy;
import com.tencent.biz.pubaccount.readinjoy.struct.BaseArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.video.CodecReuseHelper;
import com.tencent.biz.pubaccount.readinjoy.video.CodecReuseHelper.Companion;
import com.tencent.biz.pubaccount.readinjoy.video.VideoPluginInstall;
import com.tencent.biz.pubaccount.readinjoy.video.VideoPluginInstall.OnVideoPluginInstallListener;
import com.tencent.biz.pubaccount.readinjoy.video.player.wrapper.IEventListener;
import com.tencent.biz.pubaccount.readinjoy.video.player.wrapper.IPlayer;
import com.tencent.biz.pubaccount.readinjoy.video.player.wrapper.IPlayerFactory;
import com.tencent.biz.pubaccount.readinjoy.video.player.wrapper.IVideoView;
import com.tencent.biz.pubaccount.readinjoy.video.player.wrapper.PlayerHelper;
import com.tencent.biz.pubaccount.readinjoy.video.player.wrapper.PlayerHelper.Companion;
import com.tencent.biz.pubaccount.readinjoy.video.player.wrapper.PlayerVideoInfo;
import com.tencent.biz.pubaccount.readinjoy.video.videourl.ThirdVideoManager;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;
import com.tencent.superplayer.api.SuperPlayerOption;
import com.tencent.tmediacodec.util.LogUtils;
import com.tencent.util.VersionUtils;
import cooperation.readinjoy.ReadInJoyHelper;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import mqq.os.MqqHandler;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/biz/pubaccount/readinjoy/gifvideo/base/video/VideoPlayController;", "", "ptsVideoView", "Lcom/tencent/biz/pubaccount/readinjoy/gifvideo/base/video/VideoView;", "curState", "Ljava/util/concurrent/atomic/AtomicInteger;", "curAction", "(Lcom/tencent/biz/pubaccount/readinjoy/gifvideo/base/video/VideoView;Ljava/util/concurrent/atomic/AtomicInteger;Ljava/util/concurrent/atomic/AtomicInteger;)V", "TAG", "", "getTAG", "()Ljava/lang/String;", "setTAG", "(Ljava/lang/String;)V", "value", "Lcom/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo;", "articleInfo", "getArticleInfo", "()Lcom/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo;", "setArticleInfo", "(Lcom/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo;)V", "getCurAction", "()Ljava/util/concurrent/atomic/AtomicInteger;", "setCurAction", "(Ljava/util/concurrent/atomic/AtomicInteger;)V", "getCurState", "setCurState", "eventListener", "Lcom/tencent/biz/pubaccount/readinjoy/video/player/wrapper/IEventListener;", "getEventListener", "()Lcom/tencent/biz/pubaccount/readinjoy/video/player/wrapper/IEventListener;", "setEventListener", "(Lcom/tencent/biz/pubaccount/readinjoy/video/player/wrapper/IEventListener;)V", "", "isLoop", "()Z", "setLoop", "(Z)V", "isManualPause", "setManualPause", "isMute", "setMute", "mBusiType", "", "getMBusiType", "()I", "setMBusiType", "(I)V", "mFactory", "Lcom/tencent/biz/pubaccount/readinjoy/video/player/wrapper/IPlayerFactory;", "mVid", "getMVid", "setMVid", "mVideoPlayer", "Lcom/tencent/biz/pubaccount/readinjoy/video/player/wrapper/IPlayer;", "getMVideoPlayer", "()Lcom/tencent/biz/pubaccount/readinjoy/video/player/wrapper/IPlayer;", "setMVideoPlayer", "(Lcom/tencent/biz/pubaccount/readinjoy/video/player/wrapper/IPlayer;)V", "mVideoUrl", "getMVideoUrl", "setMVideoUrl", "mVideoView", "Lcom/tencent/biz/pubaccount/readinjoy/video/player/wrapper/IVideoView;", "getMVideoView", "()Lcom/tencent/biz/pubaccount/readinjoy/video/player/wrapper/IVideoView;", "setMVideoView", "(Lcom/tencent/biz/pubaccount/readinjoy/video/player/wrapper/IVideoView;)V", "onStateChangeListeners", "Ljava/util/concurrent/CopyOnWriteArrayList;", "Lcom/tencent/biz/pubaccount/readinjoy/gifvideo/base/video/VideoPlayController$OnStateChangeListener;", "playErrorCode", "getPlayErrorCode", "setPlayErrorCode", "playErrorModule", "getPlayErrorModule", "setPlayErrorModule", "playErrorType", "getPlayErrorType", "setPlayErrorType", "getPtsVideoView", "()Lcom/tencent/biz/pubaccount/readinjoy/gifvideo/base/video/VideoView;", "setPtsVideoView", "(Lcom/tencent/biz/pubaccount/readinjoy/gifvideo/base/video/VideoView;)V", "useVid", "getUseVid", "setUseVid", "videoDtReportController", "Lcom/tencent/biz/pubaccount/readinjoy/gifvideo/base/video/VideoDtReportController;", "getVideoDtReportController", "()Lcom/tencent/biz/pubaccount/readinjoy/gifvideo/base/video/VideoDtReportController;", "setVideoDtReportController", "(Lcom/tencent/biz/pubaccount/readinjoy/gifvideo/base/video/VideoDtReportController;)V", "videoDynamicInsertController", "Lcom/tencent/biz/pubaccount/readinjoy/gifvideo/base/video/VideoDynamicInsertController;", "getVideoDynamicInsertController", "()Lcom/tencent/biz/pubaccount/readinjoy/gifvideo/base/video/VideoDynamicInsertController;", "setVideoDynamicInsertController", "(Lcom/tencent/biz/pubaccount/readinjoy/gifvideo/base/video/VideoDynamicInsertController;)V", "videoPlayListener", "Lcom/tencent/biz/pubaccount/readinjoy/gifvideo/base/video/VideoPlayListener;", "getVideoPlayListener", "()Lcom/tencent/biz/pubaccount/readinjoy/gifvideo/base/video/VideoPlayListener;", "setVideoPlayListener", "(Lcom/tencent/biz/pubaccount/readinjoy/gifvideo/base/video/VideoPlayListener;)V", "videoPluginInstall", "Lcom/tencent/biz/pubaccount/readinjoy/video/VideoPluginInstall;", "videoReportController", "Lcom/tencent/biz/pubaccount/readinjoy/gifvideo/base/video/VideoReportController;", "getVideoReportController", "()Lcom/tencent/biz/pubaccount/readinjoy/gifvideo/base/video/VideoReportController;", "setVideoReportController", "(Lcom/tencent/biz/pubaccount/readinjoy/gifvideo/base/video/VideoReportController;)V", "videoSeeLaterController", "Lcom/tencent/biz/pubaccount/readinjoy/gifvideo/base/video/VideoSeeLaterController;", "getVideoSeeLaterController", "()Lcom/tencent/biz/pubaccount/readinjoy/gifvideo/base/video/VideoSeeLaterController;", "setVideoSeeLaterController", "(Lcom/tencent/biz/pubaccount/readinjoy/gifvideo/base/video/VideoSeeLaterController;)V", "videoStrategy", "Lcom/tencent/biz/pubaccount/readinjoy/gifvideo/utils/ReadInJoyVideoStrategy;", "xyAxis", "getXyAxis", "setXyAxis", "checkVideo", "commonOptimizeConfig", "", "info", "Lcom/tencent/biz/pubaccount/readinjoy/video/player/wrapper/PlayerVideoInfo;", "commonPlayerOption", "Lcom/tencent/superplayer/api/SuperPlayerOption;", "isPrePlay", "completePlayer", "createVideoPlayer", "runnable", "Lkotlin/Function0;", "createVideoView", "destroy", "destroyPlayer", "error", "module", "errorType", "errorCode", "executeOnMainThread", "executeOnSubThread", "goToNextState", "initPlayer", "install", "videoPluginInstallListener", "Lcom/tencent/biz/pubaccount/readinjoy/video/VideoPluginInstall$OnVideoPluginInstallListener;", "installVideoPlayer", "isValidBusiType", "isValidVideo", "onStateChanged", "oldState", "newState", "open", "openVideoByUrl", "videoUrl", "openVideoByVid", "vid", "pause", "pausePlayer", "registerOnStateListener", "listener", "requestUrlByVid", "strategy", "Lcom/tencent/biz/pubaccount/readinjoy/gifvideo/utils/IStrategy;", "callback", "Lcom/tencent/biz/pubaccount/readinjoy/gifvideo/utils/IStrategy$URLCallback;", "resume", "savePlayTime", "selectUrlByVid", "setDtPgid", "dtPgid", "setDurationReportR5", "reportR5", "setTag", "suffix", "setTagOnVideoView", "start", "action", "startPlayer", "stop", "stopPlayer", "unRegisterOnStateListener", "updateProgress", "progress", "Companion", "OnStateChangeListener", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
public final class VideoPlayController
{
  public static final VideoPlayController.Companion a;
  private static int f = 1;
  private static int g = f;
  private int jdField_a_of_type_Int;
  @Nullable
  private VideoDtReportController jdField_a_of_type_ComTencentBizPubaccountReadinjoyGifvideoBaseVideoVideoDtReportController;
  @Nullable
  private VideoDynamicInsertController jdField_a_of_type_ComTencentBizPubaccountReadinjoyGifvideoBaseVideoVideoDynamicInsertController;
  @Nullable
  private VideoPlayListener jdField_a_of_type_ComTencentBizPubaccountReadinjoyGifvideoBaseVideoVideoPlayListener;
  @Nullable
  private VideoReportController jdField_a_of_type_ComTencentBizPubaccountReadinjoyGifvideoBaseVideoVideoReportController;
  @Nullable
  private VideoSeeLaterController jdField_a_of_type_ComTencentBizPubaccountReadinjoyGifvideoBaseVideoVideoSeeLaterController;
  @Nullable
  private VideoView jdField_a_of_type_ComTencentBizPubaccountReadinjoyGifvideoBaseVideoVideoView;
  private ReadInJoyVideoStrategy jdField_a_of_type_ComTencentBizPubaccountReadinjoyGifvideoUtilsReadInJoyVideoStrategy;
  @Nullable
  private BaseArticleInfo jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo;
  private VideoPluginInstall jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPluginInstall;
  @NotNull
  private IEventListener jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoPlayerWrapperIEventListener;
  @Nullable
  private IPlayer jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoPlayerWrapperIPlayer;
  private IPlayerFactory jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoPlayerWrapperIPlayerFactory;
  @Nullable
  private IVideoView jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoPlayerWrapperIVideoView;
  @NotNull
  private String jdField_a_of_type_JavaLangString;
  private final CopyOnWriteArrayList<VideoPlayController.OnStateChangeListener> jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList;
  @NotNull
  private AtomicInteger jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger;
  private boolean jdField_a_of_type_Boolean;
  private int jdField_b_of_type_Int;
  @Nullable
  private String jdField_b_of_type_JavaLangString;
  @NotNull
  private AtomicInteger jdField_b_of_type_JavaUtilConcurrentAtomicAtomicInteger;
  private boolean jdField_b_of_type_Boolean;
  private int jdField_c_of_type_Int;
  @Nullable
  private String jdField_c_of_type_JavaLangString;
  private boolean jdField_c_of_type_Boolean;
  private int jdField_d_of_type_Int;
  private boolean jdField_d_of_type_Boolean;
  private int e;
  
  static
  {
    jdField_a_of_type_ComTencentBizPubaccountReadinjoyGifvideoBaseVideoVideoPlayController$Companion = new VideoPlayController.Companion(null);
  }
  
  public VideoPlayController(@Nullable VideoView paramVideoView, @NotNull AtomicInteger paramAtomicInteger1, @NotNull AtomicInteger paramAtomicInteger2)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyGifvideoBaseVideoVideoView = paramVideoView;
    this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger = paramAtomicInteger1;
    this.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicInteger = paramAtomicInteger2;
    this.jdField_a_of_type_JavaLangString = "VideoPlayController";
    this.jdField_a_of_type_Boolean = true;
    this.jdField_b_of_type_JavaLangString = "";
    this.jdField_c_of_type_JavaLangString = "";
    this.jdField_b_of_type_Boolean = true;
    this.jdField_c_of_type_Boolean = true;
    this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList = new CopyOnWriteArrayList();
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyGifvideoUtilsReadInJoyVideoStrategy = new ReadInJoyVideoStrategy();
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyGifvideoBaseVideoVideoSeeLaterController = new VideoSeeLaterController(this);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyGifvideoBaseVideoVideoReportController = new VideoReportController(this);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyGifvideoBaseVideoVideoDtReportController = new VideoDtReportController(this);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyGifvideoBaseVideoVideoDynamicInsertController = new VideoDynamicInsertController(this);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoPlayerWrapperIEventListener = ((IEventListener)new VideoPlayController.eventListener.1(this));
  }
  
  private final SuperPlayerOption a(boolean paramBoolean)
  {
    LogUtils.setLogEnable(QLog.isColorLevel());
    SuperPlayerOption localSuperPlayerOption = SuperPlayerOption.obtain();
    localSuperPlayerOption.isPrePlay = paramBoolean;
    AladdinConfig localAladdinConfig = Aladdin.getConfig(357);
    localSuperPlayerOption.bufferPacketMinTotalDurationMs = localAladdinConfig.getIntegerFromString("bufferPacketMinTotalDurationMs", 0);
    localSuperPlayerOption.preloadPacketDurationMs = localAladdinConfig.getIntegerFromString("preloadPacketDurationMs", 0);
    localSuperPlayerOption.minBufferingPacketDurationMs = localAladdinConfig.getIntegerFromString("minBufferingPacketDurationMs", 0);
    localSuperPlayerOption.enableCodecReuse = CodecReuseHelper.a.c();
    localSuperPlayerOption.enableVideoFrameCheck = CodecReuseHelper.a.e();
    if (QLog.isColorLevel()) {
      QLog.d(this.jdField_a_of_type_JavaLangString, 2, "commonPlayerOption: " + localSuperPlayerOption);
    }
    return localSuperPlayerOption;
  }
  
  private final void a(int paramInt1, int paramInt2, int paramInt3)
  {
    this.jdField_c_of_type_Int = paramInt1;
    this.jdField_d_of_type_Int = paramInt2;
    this.e = paramInt3;
    QLog.d(this.jdField_a_of_type_JavaLangString, 1, "playErrorModule:" + this.jdField_c_of_type_Int + ",playErrorType:" + this.jdField_d_of_type_Int + ",playErrorCode:" + this.e);
    VideoState.a.a(this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger, this.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicInteger, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyGifvideoBaseVideoVideoView, this).a(-1);
  }
  
  private final void a(PlayerVideoInfo paramPlayerVideoInfo)
  {
    if (paramPlayerVideoInfo != null)
    {
      paramPlayerVideoInfo.b(true);
      paramPlayerVideoInfo.a(ReadInJoyHelper.g());
    }
  }
  
  private final IVideoView b()
  {
    Object localObject2 = null;
    Object localObject3 = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyGifvideoBaseVideoVideoView;
    Object localObject1 = localObject2;
    if (localObject3 != null)
    {
      localObject3 = ((VideoView)localObject3).getContext();
      localObject1 = localObject2;
      if (localObject3 != null)
      {
        IPlayerFactory localIPlayerFactory = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoPlayerWrapperIPlayerFactory;
        localObject1 = localObject2;
        if (localIPlayerFactory != null) {
          localObject1 = localIPlayerFactory.a((Context)localObject3, VersionUtils.d());
        }
      }
    }
    return localObject1;
  }
  
  private final void b(VideoPluginInstall.OnVideoPluginInstallListener paramOnVideoPluginInstallListener)
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPluginInstall == null) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPluginInstall = new VideoPluginInstall();
    }
    VideoPluginInstall localVideoPluginInstall = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPluginInstall;
    if ((localVideoPluginInstall != null) && (localVideoPluginInstall.a() == true)) {
      if (paramOnVideoPluginInstallListener != null) {
        paramOnVideoPluginInstallListener.a(true);
      }
    }
    do
    {
      return;
      QLog.d(this.jdField_a_of_type_JavaLangString, 1, "not installed, now install");
      if (paramOnVideoPluginInstallListener != null)
      {
        localVideoPluginInstall = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPluginInstall;
        if (localVideoPluginInstall != null) {
          localVideoPluginInstall.a(paramOnVideoPluginInstallListener);
        }
      }
      paramOnVideoPluginInstallListener = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPluginInstall;
    } while (paramOnVideoPluginInstallListener == null);
    paramOnVideoPluginInstallListener.a();
  }
  
  private final boolean c()
  {
    return (this.jdField_a_of_type_Int == 2) || (this.jdField_a_of_type_Int == 6);
  }
  
  private final void h(Function0<Unit> paramFunction0)
  {
    QLog.d(this.jdField_a_of_type_JavaLangString, 1, "createVideoPlayer");
    Object localObject = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoPlayerWrapperIPlayer;
    if (localObject != null) {
      ((IPlayer)localObject).d();
    }
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoPlayerWrapperIPlayerFactory = PlayerHelper.a.a();
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoPlayerWrapperIVideoView = b();
    localObject = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyGifvideoBaseVideoVideoView;
    if (localObject != null) {
      ((VideoView)localObject).setVideoView(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoPlayerWrapperIVideoView);
    }
    localObject = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoPlayerWrapperIPlayerFactory;
    if (localObject != null) {}
    for (localObject = ((IPlayerFactory)localObject).a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoPlayerWrapperIVideoView);; localObject = null)
    {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoPlayerWrapperIPlayer = ((IPlayer)localObject);
      localObject = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoPlayerWrapperIPlayer;
      if (localObject != null) {
        ((IPlayer)localObject).a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoPlayerWrapperIVideoView);
      }
      localObject = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoPlayerWrapperIPlayer;
      if (localObject != null) {
        ((IPlayer)localObject).a(this.jdField_c_of_type_Boolean);
      }
      localObject = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoPlayerWrapperIPlayer;
      if (localObject != null) {
        ((IPlayer)localObject).b(this.jdField_b_of_type_Boolean);
      }
      localObject = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoPlayerWrapperIPlayer;
      if (localObject != null) {
        ((IPlayer)localObject).a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoPlayerWrapperIEventListener);
      }
      i();
      paramFunction0.invoke();
      return;
    }
  }
  
  private final void i()
  {
    Object localObject = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoPlayerWrapperIVideoView;
    View localView;
    if (localObject != null)
    {
      localView = ((IVideoView)localObject).a();
      if (localView != null) {
        if (TextUtils.isEmpty((CharSequence)this.jdField_c_of_type_JavaLangString)) {
          break label44;
        }
      }
    }
    label44:
    for (localObject = this.jdField_c_of_type_JavaLangString;; localObject = this.jdField_b_of_type_JavaLangString)
    {
      localView.setTag(localObject);
      return;
    }
  }
  
  private final void j()
  {
    if (c()) {
      a((IStrategy)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyGifvideoUtilsReadInJoyVideoStrategy, (IStrategy.URLCallback)new VideoPlayController.selectUrlByVid.1(this));
    }
    String str;
    do
    {
      do
      {
        return;
      } while (!this.jdField_a_of_type_Boolean);
      str = this.jdField_c_of_type_JavaLangString;
    } while (str == null);
    c(str);
  }
  
  public final int a()
  {
    return this.jdField_c_of_type_Int;
  }
  
  @Nullable
  public final VideoPlayListener a()
  {
    return this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyGifvideoBaseVideoVideoPlayListener;
  }
  
  @Nullable
  public final VideoView a()
  {
    return this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyGifvideoBaseVideoVideoView;
  }
  
  @Nullable
  public final BaseArticleInfo a()
  {
    return this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo;
  }
  
  @Nullable
  public final IPlayer a()
  {
    return this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoPlayerWrapperIPlayer;
  }
  
  @Nullable
  public final IVideoView a()
  {
    return this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoPlayerWrapperIVideoView;
  }
  
  @NotNull
  public final String a()
  {
    return this.jdField_a_of_type_JavaLangString;
  }
  
  @NotNull
  public final AtomicInteger a()
  {
    return this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger;
  }
  
  public final void a()
  {
    this.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicInteger.set(6);
    g();
  }
  
  public final void a(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public final void a(int paramInt1, int paramInt2)
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.iterator();
    while (localIterator.hasNext()) {
      ((VideoPlayController.OnStateChangeListener)localIterator.next()).onStateChanged(paramInt1, paramInt2);
    }
  }
  
  public final void a(@NotNull VideoPlayController.OnStateChangeListener paramOnStateChangeListener)
  {
    Intrinsics.checkParameterIsNotNull(paramOnStateChangeListener, "listener");
    if (!this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.contains(paramOnStateChangeListener)) {
      this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.add(paramOnStateChangeListener);
    }
  }
  
  public final void a(@Nullable VideoPlayListener paramVideoPlayListener)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyGifvideoBaseVideoVideoPlayListener = paramVideoPlayListener;
  }
  
  public final void a(@Nullable VideoView paramVideoView)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyGifvideoBaseVideoVideoView = paramVideoView;
  }
  
  public final void a(@Nullable IStrategy paramIStrategy, @Nullable IStrategy.URLCallback paramURLCallback)
  {
    if (paramIStrategy != null) {
      paramIStrategy.a(this.jdField_c_of_type_JavaLangString, paramURLCallback);
    }
  }
  
  public final void a(@Nullable BaseArticleInfo paramBaseArticleInfo)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo = paramBaseArticleInfo;
    paramBaseArticleInfo = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyGifvideoBaseVideoVideoReportController;
    if (paramBaseArticleInfo != null) {
      paramBaseArticleInfo.e();
    }
  }
  
  public final void a(@Nullable VideoPluginInstall.OnVideoPluginInstallListener paramOnVideoPluginInstallListener)
  {
    g((Function0)new VideoPlayController.install.1(this, paramOnVideoPluginInstallListener));
  }
  
  public final void a(@Nullable IPlayer paramIPlayer)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoPlayerWrapperIPlayer = paramIPlayer;
  }
  
  public final void a(@Nullable String paramString)
  {
    this.jdField_b_of_type_JavaLangString = paramString;
  }
  
  public final void a(@NotNull Function0<Unit> paramFunction0)
  {
    Intrinsics.checkParameterIsNotNull(paramFunction0, "runnable");
    f((Function0)new VideoPlayController.initPlayer.1(this, paramFunction0));
  }
  
  public final void a(boolean paramBoolean)
  {
    this.jdField_b_of_type_Boolean = paramBoolean;
    IPlayer localIPlayer = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoPlayerWrapperIPlayer;
    if (localIPlayer != null) {
      localIPlayer.c(this.jdField_b_of_type_Boolean);
    }
  }
  
  public final boolean a()
  {
    return this.jdField_c_of_type_Boolean;
  }
  
  public final int b()
  {
    return this.jdField_d_of_type_Int;
  }
  
  @Nullable
  public final String b()
  {
    return this.jdField_b_of_type_JavaLangString;
  }
  
  @NotNull
  public final AtomicInteger b()
  {
    return this.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicInteger;
  }
  
  public final void b()
  {
    this.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicInteger.set(5);
    g();
  }
  
  public final void b(int paramInt)
  {
    this.jdField_b_of_type_Int = paramInt;
    IPlayer localIPlayer = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoPlayerWrapperIPlayer;
    if (localIPlayer != null) {
      localIPlayer.a(this.jdField_b_of_type_Int);
    }
  }
  
  public final void b(@NotNull VideoPlayController.OnStateChangeListener paramOnStateChangeListener)
  {
    Intrinsics.checkParameterIsNotNull(paramOnStateChangeListener, "listener");
    this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.remove(paramOnStateChangeListener);
  }
  
  public final void b(@Nullable String paramString)
  {
    this.jdField_c_of_type_JavaLangString = paramString;
  }
  
  public final void b(@NotNull Function0<Unit> paramFunction0)
  {
    Intrinsics.checkParameterIsNotNull(paramFunction0, "runnable");
    g((Function0)new VideoPlayController.startPlayer.1(this, paramFunction0));
  }
  
  public final void b(boolean paramBoolean)
  {
    this.jdField_c_of_type_Boolean = paramBoolean;
    IPlayer localIPlayer = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoPlayerWrapperIPlayer;
    if (localIPlayer != null) {
      localIPlayer.a(this.jdField_c_of_type_Boolean);
    }
  }
  
  public final boolean b()
  {
    Object localObject = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoPlayerWrapperIVideoView;
    if (localObject != null)
    {
      localObject = ((IVideoView)localObject).a();
      if (localObject != null)
      {
        localObject = ((View)localObject).getTag();
        localObject = (CharSequence)localObject;
        if ((!TextUtils.equals((CharSequence)this.jdField_c_of_type_JavaLangString, (CharSequence)localObject)) && (!TextUtils.equals((CharSequence)this.jdField_b_of_type_JavaLangString, (CharSequence)localObject))) {
          break label95;
        }
      }
    }
    label95:
    for (boolean bool = true;; bool = false)
    {
      QLog.d(this.jdField_a_of_type_JavaLangString, 1, "checkVideo: " + bool);
      return bool;
      localObject = null;
      break;
    }
  }
  
  public final int c()
  {
    return this.e;
  }
  
  @Nullable
  public final String c()
  {
    return this.jdField_c_of_type_JavaLangString;
  }
  
  public final void c()
  {
    this.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicInteger.set(4);
    g();
  }
  
  public final void c(int paramInt)
  {
    if (!this.jdField_d_of_type_Boolean)
    {
      this.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicInteger.set(paramInt);
      g();
    }
  }
  
  public final void c(@NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "vid");
    PlayerVideoInfo localPlayerVideoInfo = new PlayerVideoInfo(1, paramString);
    a(localPlayerVideoInfo);
    Object localObject = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyGifvideoBaseVideoVideoView;
    if (localObject != null)
    {
      localObject = ((VideoView)localObject).getContext();
      if (localObject != null)
      {
        QLog.d(this.jdField_a_of_type_JavaLangString, 2, "opening " + paramString);
        if (b())
        {
          paramString = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoPlayerWrapperIPlayer;
          if (paramString != null)
          {
            SuperPlayerOption localSuperPlayerOption = a(false);
            if (localSuperPlayerOption == null) {
              Intrinsics.throwNpe();
            }
            paramString.a((Context)localObject, localPlayerVideoInfo, 0L, localSuperPlayerOption);
          }
        }
      }
    }
  }
  
  public final void c(@NotNull Function0<Unit> paramFunction0)
  {
    Intrinsics.checkParameterIsNotNull(paramFunction0, "runnable");
    g((Function0)new VideoPlayController.stopPlayer.1(this, paramFunction0));
  }
  
  public final void c(boolean paramBoolean)
  {
    this.jdField_d_of_type_Boolean = paramBoolean;
  }
  
  public final void d()
  {
    this.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicInteger.set(7);
    g();
  }
  
  public final void d(int paramInt)
  {
    VideoDynamicInsertController localVideoDynamicInsertController = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyGifvideoBaseVideoVideoDynamicInsertController;
    if (localVideoDynamicInsertController != null) {
      localVideoDynamicInsertController.a(paramInt);
    }
  }
  
  public final void d(@NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "videoUrl");
    Object localObject1;
    if ((b()) && (!TextUtils.isEmpty((CharSequence)paramString)))
    {
      localObject1 = ThirdVideoManager.a(paramString);
      if ((localObject1 != null) && (localObject1.length > 0) && (!TextUtils.isEmpty((CharSequence)localObject1[0]))) {
        break label166;
      }
      localObject1 = new String[1];
      localObject1[0] = paramString;
    }
    label166:
    for (;;)
    {
      Object localObject2 = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyGifvideoBaseVideoVideoView;
      if (localObject2 != null)
      {
        localObject2 = ((VideoView)localObject2).getContext();
        if (localObject2 != null)
        {
          localObject1 = new PlayerVideoInfo(101, "", (String[])localObject1);
          a((PlayerVideoInfo)localObject1);
          QLog.d(this.jdField_a_of_type_JavaLangString, 2, "opening " + paramString);
          if (b())
          {
            paramString = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoPlayerWrapperIPlayer;
            if (paramString != null)
            {
              SuperPlayerOption localSuperPlayerOption = a(false);
              if (localSuperPlayerOption == null) {
                Intrinsics.throwNpe();
              }
              paramString.a((Context)localObject2, (PlayerVideoInfo)localObject1, 0L, localSuperPlayerOption);
            }
          }
        }
      }
      return;
    }
  }
  
  public final void d(@NotNull Function0<Unit> paramFunction0)
  {
    Intrinsics.checkParameterIsNotNull(paramFunction0, "runnable");
    g((Function0)new VideoPlayController.pausePlayer.1(this, paramFunction0));
  }
  
  public final void e()
  {
    g((Function0)new VideoPlayController.open.1(this));
  }
  
  public final void e(@Nullable String paramString)
  {
    VideoDtReportController localVideoDtReportController = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyGifvideoBaseVideoVideoDtReportController;
    if (localVideoDtReportController != null) {
      localVideoDtReportController.b(paramString);
    }
  }
  
  public final void e(@NotNull Function0<Unit> paramFunction0)
  {
    Intrinsics.checkParameterIsNotNull(paramFunction0, "runnable");
    g((Function0)new VideoPlayController.destroyPlayer.1(this, paramFunction0));
  }
  
  public final void f()
  {
    VideoPlayListener localVideoPlayListener = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyGifvideoBaseVideoVideoPlayListener;
    if (localVideoPlayListener != null) {
      localVideoPlayListener.c();
    }
  }
  
  public final void f(@NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "reportR5");
  }
  
  public final void f(@NotNull Function0<Unit> paramFunction0)
  {
    Intrinsics.checkParameterIsNotNull(paramFunction0, "runnable");
    if (RIJThreadHandler.a())
    {
      paramFunction0.invoke();
      return;
    }
    ThreadManager.getUIHandler().post((Runnable)new VideoPlayController.executeOnMainThread.1(this, paramFunction0));
  }
  
  public final void g()
  {
    VideoView localVideoView = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyGifvideoBaseVideoVideoView;
    if (localVideoView != null) {}
    try
    {
      VideoState.a.a(this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger, this.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicInteger, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyGifvideoBaseVideoVideoView, this).a();
      Unit localUnit = Unit.INSTANCE;
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public final void g(@NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "suffix");
    this.jdField_a_of_type_JavaLangString = ("VideoPlayController." + paramString);
    Object localObject = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyGifvideoBaseVideoVideoDtReportController;
    if (localObject != null) {
      ((VideoDtReportController)localObject).a(VideoDtReportController.class.getSimpleName() + '.' + paramString);
    }
    localObject = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyGifvideoBaseVideoVideoReportController;
    if (localObject != null) {
      ((VideoReportController)localObject).a(VideoReportController.class.getSimpleName() + '.' + paramString);
    }
  }
  
  public final void g(@NotNull Function0<Unit> paramFunction0)
  {
    Intrinsics.checkParameterIsNotNull(paramFunction0, "runnable");
    ThreadManager.getFileThreadHandler().post((Runnable)new VideoPlayController.executeOnSubThread.1(this, paramFunction0));
  }
  
  public final void h()
  {
    Object localObject1 = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo;
    if (localObject1 != null)
    {
      Object localObject2 = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoPlayerWrapperIPlayer;
      long l;
      if (localObject2 != null)
      {
        l = ((IPlayer)localObject2).b();
        localObject2 = (Map)VideoDataManager.a.a();
        String str = ((BaseArticleInfo)localObject1).innerUniqueID;
        Intrinsics.checkExpressionValueIsNotNull(str, "article.innerUniqueID");
        ((Map)localObject2).put(str, Long.valueOf(l));
      }
      localObject2 = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoPlayerWrapperIPlayer;
      if (localObject2 != null)
      {
        l = ((IPlayer)localObject2).a();
        localObject2 = (Map)VideoDataManager.a.b();
        localObject1 = ((BaseArticleInfo)localObject1).innerUniqueID;
        Intrinsics.checkExpressionValueIsNotNull(localObject1, "article.innerUniqueID");
        ((Map)localObject2).put(localObject1, Long.valueOf(l));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.gifvideo.base.video.VideoPlayController
 * JD-Core Version:    0.7.0.1
 */