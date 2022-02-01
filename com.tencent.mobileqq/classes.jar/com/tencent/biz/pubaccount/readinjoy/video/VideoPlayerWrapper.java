package com.tencent.biz.pubaccount.readinjoy.video;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.Looper;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewParent;
import com.tencent.aladdin.config.Aladdin;
import com.tencent.aladdin.config.AladdinConfig;
import com.tencent.biz.pubaccount.VideoReporter;
import com.tencent.biz.pubaccount.readinjoy.video.player.wrapper.IEventListener;
import com.tencent.biz.pubaccount.readinjoy.video.player.wrapper.IPlayer;
import com.tencent.biz.pubaccount.readinjoy.video.player.wrapper.IPlayerFactory;
import com.tencent.biz.pubaccount.readinjoy.video.player.wrapper.IVideoView;
import com.tencent.biz.pubaccount.readinjoy.video.player.wrapper.PlayerHelper;
import com.tencent.biz.pubaccount.readinjoy.video.player.wrapper.PlayerHelper.Companion;
import com.tencent.biz.pubaccount.readinjoy.video.player.wrapper.PlayerVideoInfo;
import com.tencent.biz.pubaccount.readinjoy.video.videourl.ThirdVideoManager;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.superplayer.api.SuperPlayerDownOption;
import com.tencent.superplayer.api.SuperPlayerOption;
import com.tencent.superplayer.seamless.SPSeamlessHelper;
import com.tencent.superplayer.view.ISPlayerVideoView;
import com.tencent.thumbplayer.api.TPPlayerMsg.TPMediaCodecInfo;
import com.tencent.thumbplayer.api.TPPlayerMsg.TPProtocolInfo;
import com.tencent.tmediacodec.TCodecManager;
import com.tencent.tmediacodec.util.LogUtils;
import com.tencent.util.VersionUtils;
import com.tencent.viola.utils.ViolaLogUtils;
import cooperation.readinjoy.ReadInJoyHelper;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.atomic.AtomicInteger;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class VideoPlayerWrapper
  implements VideoPlayManager.PlayState, IEventListener
{
  public int a;
  public long a;
  protected Context a;
  private ViewGroup jdField_a_of_type_AndroidViewViewGroup;
  private CodecReuseHelper.OnCodecReuseInfoUpdateCallback jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoCodecReuseHelper$OnCodecReuseInfoUpdateCallback = null;
  private CodecReuseHelper jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoCodecReuseHelper = new CodecReuseHelper();
  private QuicConfigHelper jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoQuicConfigHelper = new QuicConfigHelper();
  private VideoPlayerWrapper.MediaPlayListener jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayerWrapper$MediaPlayListener;
  @Nullable
  private IPlayer jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoPlayerWrapperIPlayer;
  @NotNull
  private IPlayerFactory jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoPlayerWrapperIPlayerFactory;
  @Nullable
  private IVideoView jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoPlayerWrapperIVideoView;
  private Object jdField_a_of_type_JavaLangObject;
  public String a;
  private AtomicInteger jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger = new AtomicInteger(0);
  public boolean a;
  public int b;
  public long b;
  private final Object jdField_b_of_type_JavaLangObject = new Object();
  private final String jdField_b_of_type_JavaLangString = "Q.readinjoy.video.VideoPlayerWrapper<" + Integer.toHexString(hashCode()) + ">";
  public boolean b;
  private int jdField_c_of_type_Int = 101;
  public long c;
  private String jdField_c_of_type_JavaLangString;
  private boolean jdField_c_of_type_Boolean = false;
  private int jdField_d_of_type_Int = 0;
  private long jdField_d_of_type_Long;
  private String jdField_d_of_type_JavaLangString;
  private boolean jdField_d_of_type_Boolean;
  private int jdField_e_of_type_Int;
  private long jdField_e_of_type_Long;
  private boolean jdField_e_of_type_Boolean = false;
  private int jdField_f_of_type_Int = 0;
  private long jdField_f_of_type_Long;
  private boolean jdField_f_of_type_Boolean;
  private long jdField_g_of_type_Long;
  private boolean jdField_g_of_type_Boolean = false;
  private long jdField_h_of_type_Long;
  private boolean jdField_h_of_type_Boolean = false;
  private long jdField_i_of_type_Long;
  private boolean jdField_i_of_type_Boolean = false;
  
  public VideoPlayerWrapper(Context paramContext)
  {
    this(paramContext, "");
  }
  
  public VideoPlayerWrapper(Context paramContext, String paramString)
  {
    this.jdField_a_of_type_Boolean = false;
    this.jdField_c_of_type_Long = 0L;
    this.jdField_b_of_type_Boolean = false;
    this.jdField_b_of_type_Int = -1;
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    c(paramString);
    this.jdField_c_of_type_JavaLangString = VideoReporter.b();
  }
  
  private int a(ViewGroup paramViewGroup)
  {
    if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoPlayerWrapperIVideoView != null) && ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoPlayerWrapperIVideoView.a() instanceof ISPlayerVideoView)))
    {
      if (QLog.isColorLevel()) {
        QLog.d(this.jdField_b_of_type_JavaLangString, 2, "seamlessAttachVideoView: ");
      }
      SPSeamlessHelper.get().attachVideoView(paramViewGroup, (ISPlayerVideoView)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoPlayerWrapperIVideoView.a(), new ViewGroup.LayoutParams(-1, -1));
      if (!this.jdField_h_of_type_Boolean) {
        return 1;
      }
      if (!r()) {
        return 2;
      }
      c();
    }
    return 0;
  }
  
  private SuperPlayerOption a(boolean paramBoolean)
  {
    boolean bool = false;
    SuperPlayerOption localSuperPlayerOption = SuperPlayerOption.obtain(104);
    localSuperPlayerOption.isPrePlay = paramBoolean;
    Object localObject = Aladdin.getConfig(357);
    localSuperPlayerOption.bufferPacketMinTotalDurationMs = ((AladdinConfig)localObject).getIntegerFromString("bufferPacketMinTotalDurationMs", 0);
    localSuperPlayerOption.preloadPacketDurationMs = ((AladdinConfig)localObject).getIntegerFromString("preloadPacketDurationMs", 0);
    localSuperPlayerOption.minBufferingPacketDurationMs = ((AladdinConfig)localObject).getIntegerFromString("minBufferingPacketDurationMs", 0);
    localObject = localSuperPlayerOption.superPlayerDownOption;
    if (Aladdin.getConfig(392).getIntegerFromString("enable_p2p", 0) == 1) {}
    for (paramBoolean = true;; paramBoolean = false)
    {
      ((SuperPlayerDownOption)localObject).enableP2P = paramBoolean;
      localObject = localSuperPlayerOption.superPlayerDownOption;
      paramBoolean = bool;
      if (Aladdin.getConfig(392).getIntegerFromString("enable_pcdn", 0) == 1) {
        paramBoolean = true;
      }
      ((SuperPlayerDownOption)localObject).enablePcdn = paramBoolean;
      localSuperPlayerOption.accurateSeekOnOpen = true;
      localSuperPlayerOption.enableVideoFrameCheck = CodecReuseHelper.a.e();
      a(localSuperPlayerOption);
      if (QLog.isColorLevel()) {
        QLog.d(this.jdField_b_of_type_JavaLangString, 2, "commonPlayerOption: " + localSuperPlayerOption);
      }
      return localSuperPlayerOption;
    }
  }
  
  private void a(PlayerVideoInfo paramPlayerVideoInfo)
  {
    if (paramPlayerVideoInfo != null)
    {
      paramPlayerVideoInfo.c(this.jdField_d_of_type_Boolean);
      paramPlayerVideoInfo.b(this.jdField_e_of_type_Boolean);
      paramPlayerVideoInfo.a(ReadInJoyHelper.g());
    }
  }
  
  private void a(SuperPlayerOption paramSuperPlayerOption)
  {
    LogUtils.setLogEnable(QLog.isColorLevel());
    if (!CodecReuseHelper.a.d())
    {
      paramSuperPlayerOption.enableCodecReuse = CodecReuseHelper.a.c();
      TCodecManager.getInstance().getReusePolicy().eraseType = CodecReuseHelper.a.a();
    }
  }
  
  private IVideoView b()
  {
    if (this.jdField_a_of_type_AndroidContentContext == null)
    {
      QLog.d(this.jdField_b_of_type_JavaLangString, 2, "createVideoView_Scroll: error, mContext null");
      return null;
    }
    return this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoPlayerWrapperIPlayerFactory.a(this.jdField_a_of_type_AndroidContentContext, VersionUtils.d());
  }
  
  private void b(String paramString1, String paramString2, int paramInt1, long paramLong1, long paramLong2, int paramInt2, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, String paramString3)
  {
    if (QLog.isColorLevel()) {
      QLog.d("VideoFeedsPlayManager.preplay", 2, "VideoFeedsPlayManager playerStartByUrl vid = " + paramString1);
    }
    if (QLog.isColorLevel()) {
      QLog.d(this.jdField_b_of_type_JavaLangString, 2, "#VideoPlayerWrapper# playerStartByUrl, url:" + paramString2 + ", fileSize:" + paramLong2 + ", videoDuration:" + paramInt2 + "，mState:" + VideoPlayUtils.a(this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.get()));
    }
    if (!s())
    {
      QLog.e(this.jdField_b_of_type_JavaLangString, 1, "not idle or complete state, should't reopen mediaplayer, vid:" + paramString1 + "，mState:" + VideoPlayUtils.a(this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.get()) + " ,mIsSeamlessPlay:" + this.jdField_h_of_type_Boolean);
      return;
    }
    n();
    Object localObject;
    if (paramBoolean2)
    {
      localObject = ThirdVideoManager.a(paramString2);
      a((String[])localObject);
      paramString1 = new PlayerVideoInfo(paramInt1, paramString1, (String[])localObject);
      paramString1.a(paramBoolean3);
      paramString1.a(paramInt2 * 1000);
      paramString1.d(paramBoolean1);
      paramString1.b(paramString3);
      a(paramString1);
      if ((this.jdField_a_of_type_AndroidContentContext != null) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoPlayerWrapperIPlayer != null))
      {
        paramString3 = a(paramBoolean3);
        if (!NetworkUtil.h(this.jdField_a_of_type_AndroidContentContext)) {
          break label437;
        }
        paramBoolean1 = QuicConfigHelper.a.a();
        label283:
        localObject = paramString3.superPlayerDownOption;
        if ((!paramBoolean1) || (!QuicConfigHelper.a.a(paramString2))) {
          break label448;
        }
      }
    }
    label437:
    label448:
    for (paramBoolean1 = true;; paramBoolean1 = false)
    {
      ((SuperPlayerDownOption)localObject).enableUseQuic = paramBoolean1;
      paramString3.superPlayerDownOption.enableQuicPlaintext = QuicConfigHelper.a.c();
      paramString3.superPlayerDownOption.enableQuicConnectionMigration = QuicConfigHelper.a.d();
      paramString3.superPlayerDownOption.quicCongestionType = QuicConfigHelper.a.a();
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoQuicConfigHelper.a(paramString3.superPlayerDownOption.enableUseQuic);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoPlayerWrapperIPlayer.a(this.jdField_a_of_type_AndroidContentContext, paramString1, paramLong1, paramString3);
      this.jdField_f_of_type_Long = 0L;
      this.jdField_e_of_type_Long = 0L;
      this.jdField_d_of_type_Long = 0L;
      this.jdField_g_of_type_Long = paramLong1;
      this.jdField_c_of_type_Int = paramInt1;
      return;
      localObject = new String[1];
      localObject[0] = paramString2;
      a((String[])localObject);
      break;
      paramBoolean1 = QuicConfigHelper.a.b();
      break label283;
    }
  }
  
  private void c(String paramString)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoPlayerWrapperIPlayerFactory = PlayerHelper.a.a();
    if (this.jdField_a_of_type_AndroidContentContext != null)
    {
      if (QLog.isColorLevel()) {
        QLog.d(this.jdField_b_of_type_JavaLangString, 2, "VideoPlayerWrapper initPlayer success!");
      }
      if (TextUtils.isEmpty(paramString)) {
        break label202;
      }
    }
    label202:
    for (boolean bool = true;; bool = false)
    {
      if (bool)
      {
        this.jdField_h_of_type_Boolean = a(paramString);
        if (!this.jdField_h_of_type_Boolean) {
          QLog.e(this.jdField_b_of_type_JavaLangString, 2, "SeamlessPlay error for that token(" + paramString + ") is not validate.");
        }
      }
      if (!this.jdField_h_of_type_Boolean)
      {
        this.jdField_f_of_type_Boolean = VideoVolumeControl.a().a();
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoPlayerWrapperIPlayer = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoPlayerWrapperIPlayerFactory.a(null);
      }
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoPlayerWrapperIPlayer.a(this);
      c(this.jdField_f_of_type_Boolean);
      d(this.jdField_g_of_type_Boolean);
      if (QLog.isColorLevel()) {
        QLog.d(this.jdField_b_of_type_JavaLangString, 2, "new VideoPlayerWrapper, needSeamlessPlay:" + bool + " ,mIsSeamlessPlay:" + this.jdField_h_of_type_Boolean);
      }
      return;
    }
  }
  
  private void q()
  {
    this.jdField_f_of_type_Int = 0;
    this.jdField_c_of_type_Long = 0L;
    this.jdField_b_of_type_Long = 0L;
  }
  
  private boolean r()
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoPlayerWrapperIPlayer == null) {}
    do
    {
      return false;
      if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoPlayerWrapperIPlayer.d()) {
        this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.set(1);
      }
      for (;;)
      {
        return true;
        if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoPlayerWrapperIPlayer.e())
        {
          this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.set(2);
        }
        else if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoPlayerWrapperIPlayer.c())
        {
          this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.set(4);
        }
        else if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoPlayerWrapperIPlayer.b())
        {
          this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.set(3);
        }
        else
        {
          if (!this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoPlayerWrapperIPlayer.f()) {
            break;
          }
          this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.set(5);
        }
      }
      this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.set(6);
    } while (!QLog.isColorLevel());
    QLog.d(this.jdField_b_of_type_JavaLangString, 2, "seamlessAttachVideoView: error state");
    return false;
  }
  
  private boolean s()
  {
    if (this.jdField_h_of_type_Boolean) {}
    do
    {
      return false;
      if (PlayerHelper.a.a()) {
        return this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.compareAndSet(0, 1);
      }
    } while ((!this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.compareAndSet(0, 1)) && (!this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.compareAndSet(7, 1)) && (!this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.compareAndSet(6, 1)));
    return true;
  }
  
  public int a()
  {
    if ((this.jdField_a_of_type_AndroidViewViewGroup == null) || (!this.jdField_h_of_type_Boolean))
    {
      QLog.e(this.jdField_b_of_type_JavaLangString, 2, "seamlessAttachVideoView failed for parent is null or not seamlessPlay. mIsSeamlessPlay:" + this.jdField_h_of_type_Boolean);
      return 1;
    }
    return a(this.jdField_a_of_type_AndroidViewViewGroup);
  }
  
  public long a()
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoPlayerWrapperIPlayer == null) {
      return 0L;
    }
    return this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoPlayerWrapperIPlayer.b();
  }
  
  public long a(boolean paramBoolean)
  {
    long l2 = this.jdField_e_of_type_Long;
    if (paramBoolean) {}
    for (long l1 = b(); l1 - this.jdField_g_of_type_Long > 0L; l1 = a()) {
      return l1 - this.jdField_g_of_type_Long + l2;
    }
    return l2;
  }
  
  public View a()
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoPlayerWrapperIVideoView != null) {
      return this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoPlayerWrapperIVideoView.a();
    }
    return null;
  }
  
  public IVideoView a()
  {
    return this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoPlayerWrapperIVideoView;
  }
  
  public Object a()
  {
    return this.jdField_a_of_type_JavaLangObject;
  }
  
  public String a()
  {
    return this.jdField_c_of_type_JavaLangString;
  }
  
  public Properties a()
  {
    return new Properties();
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoPlayerWrapperIVideoView != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoPlayerWrapperIVideoView.a();
    }
  }
  
  public void a(float paramFloat)
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoPlayerWrapperIPlayer != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoPlayerWrapperIPlayer.a(paramFloat);
    }
  }
  
  public void a(int paramInt)
  {
    ViolaLogUtils.d(this.jdField_b_of_type_JavaLangString, "test seekTo aaa" + paramInt + ",state:" + this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.get());
    if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoPlayerWrapperIPlayer != null) && (this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.get() != 0) && (this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.get() != 2) && (this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.get() != 1) && (this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.get() != 4) && (this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.get() != 8))
    {
      long l1 = a();
      if (l1 - this.jdField_g_of_type_Long > 0L)
      {
        long l2 = this.jdField_e_of_type_Long;
        this.jdField_e_of_type_Long = (l1 - this.jdField_g_of_type_Long + l2);
      }
      this.jdField_g_of_type_Long = paramInt;
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoPlayerWrapperIPlayer.a(paramInt, 1);
      this.jdField_c_of_type_Boolean = true;
    }
  }
  
  public void a(int paramInt1, int paramInt2, int paramInt3)
  {
    if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoPlayerWrapperIPlayer != null) && (paramInt1 > 0) && (paramInt2 > 0)) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoPlayerWrapperIPlayer.a(paramInt1, paramInt2, paramInt3);
    }
  }
  
  public void a(long paramLong1, long paramLong2)
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.jdField_b_of_type_JavaLangString, 2, "[IPlayer] onDownloadCallback downloadedSizeBytes: " + paramLong1 + ", totalSizeBytes=" + paramLong2);
    }
    this.jdField_b_of_type_Long = paramLong2;
    this.jdField_c_of_type_Long = Math.max(this.jdField_c_of_type_Long, paramLong1);
    if ((this.jdField_a_of_type_Int <= 0) && (this.jdField_b_of_type_Long > 0L) && (this.jdField_d_of_type_Long > 0L)) {
      this.jdField_a_of_type_Int = ((int)((float)this.jdField_b_of_type_Long / 1024.0F * 8.0F / ((float)this.jdField_d_of_type_Long / 1000.0F)));
    }
  }
  
  public void a(ViewGroup paramViewGroup)
  {
    a(paramViewGroup, false, true);
  }
  
  public void a(ViewGroup paramViewGroup, boolean paramBoolean)
  {
    a(paramViewGroup, paramBoolean, true);
  }
  
  public void a(ViewGroup paramViewGroup, boolean paramBoolean1, boolean paramBoolean2)
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.jdField_b_of_type_JavaLangString, 2, "initVideoView parent:" + paramViewGroup + " ,reUseVideoView:" + paramBoolean1 + " ,autoAttachVideoView:" + paramBoolean2);
    }
    this.jdField_a_of_type_AndroidViewViewGroup = paramViewGroup;
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoPlayerWrapperIPlayer != null) {}
    for (IVideoView localIVideoView = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoPlayerWrapperIPlayer.a();; localIVideoView = null)
    {
      int j;
      if ((paramBoolean1) && (this.jdField_h_of_type_Boolean) && (localIVideoView != null))
      {
        j = 1;
        if (j == 0) {
          break label160;
        }
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoPlayerWrapperIVideoView = localIVideoView;
      }
      for (;;)
      {
        if ((paramViewGroup != null) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoPlayerWrapperIVideoView != null) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoPlayerWrapperIVideoView.a() != null))
        {
          if (j == 0) {
            break label168;
          }
          if (paramBoolean2) {
            a(paramViewGroup);
          }
          a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoPlayerWrapperIVideoView);
        }
        return;
        j = 0;
        break;
        label160:
        b();
      }
      label168:
      paramViewGroup.addView(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoPlayerWrapperIVideoView.a(), new ViewGroup.LayoutParams(-1, -1));
      a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoPlayerWrapperIVideoView);
      return;
    }
  }
  
  public void a(VideoPlayerWrapper.MediaPlayListener paramMediaPlayListener)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayerWrapper$MediaPlayListener = paramMediaPlayListener;
  }
  
  public void a(@NotNull IPlayer paramIPlayer)
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.jdField_b_of_type_JavaLangString, 2, "[IPlayer] onVideoPrepared(): stremDumpInfo=" + paramIPlayer.a());
    }
    this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.set(2);
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayerWrapper$MediaPlayListener != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayerWrapper$MediaPlayListener.a(this, this.jdField_a_of_type_JavaLangObject);
    }
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoPlayerWrapperIPlayer != null) {
      this.jdField_d_of_type_Long = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoPlayerWrapperIPlayer.a();
    }
    if ((this.jdField_b_of_type_Long > 0L) && (this.jdField_d_of_type_Long > 0L)) {
      this.jdField_a_of_type_Int = ((int)((float)this.jdField_b_of_type_Long / 1024.0F * 8.0F / ((float)this.jdField_d_of_type_Long / 1000.0F)));
    }
    com.tencent.mobileqq.app.ThreadManager.post(new VideoPlayerWrapper.1(this, paramIPlayer), 5, null, false);
  }
  
  public void a(@NotNull IPlayer paramIPlayer, int paramInt1, int paramInt2)
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayerWrapper$MediaPlayListener != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayerWrapper$MediaPlayListener.a(this, false, paramInt2, paramInt1, null);
    }
  }
  
  public void a(@NotNull IPlayer paramIPlayer, int paramInt1, int paramInt2, int paramInt3, @Nullable Bitmap paramBitmap)
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayerWrapper$MediaPlayListener != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayerWrapper$MediaPlayListener.a(this, true, 0, paramInt1, paramBitmap);
    }
  }
  
  public void a(IVideoView paramIVideoView)
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.jdField_b_of_type_JavaLangString, 2, "attachVideoView: ");
    }
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoPlayerWrapperIPlayer == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d(this.jdField_b_of_type_JavaLangString, 2, "attachVideoView: videoplayer null");
      }
      return;
    }
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoPlayerWrapperIVideoView = paramIVideoView;
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoPlayerWrapperIPlayer.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoPlayerWrapperIVideoView);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoPlayerWrapperIPlayer.a(this.jdField_d_of_type_Int);
  }
  
  public void a(Object paramObject)
  {
    this.jdField_a_of_type_JavaLangObject = paramObject;
  }
  
  public void a(String paramString)
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoPlayerWrapperIPlayer != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoPlayerWrapperIPlayer.a(paramString);
    }
  }
  
  public void a(String paramString, int paramInt, long paramLong)
  {
    a(paramString, paramInt, paramLong, false);
  }
  
  public void a(String paramString, int paramInt, long paramLong, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("VideoFeedsPlayManager.preplay", 2, "VideoFeedsPlayManager playerStart vid = " + paramString);
    }
    if (QLog.isColorLevel()) {
      QLog.d(this.jdField_b_of_type_JavaLangString, 2, "#VideoPlayerWrapper# playerStart, vid:" + paramString + ", playType:" + paramInt + ", startPosition:" + paramLong + "，mState:" + VideoPlayUtils.a(this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.get()));
    }
    if (!s())
    {
      QLog.e(this.jdField_b_of_type_JavaLangString, 1, "not idle or complete state, should't reopen mediaplayer, vid:" + paramString + "，mState:" + VideoPlayUtils.a(this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.get()) + ", mSeamlessPlay:" + this.jdField_h_of_type_Boolean);
      return;
    }
    n();
    paramString = new PlayerVideoInfo(paramInt, paramString);
    paramString.a(paramBoolean);
    paramString.a("cache_video");
    a(paramString);
    if ((this.jdField_a_of_type_AndroidContentContext != null) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoPlayerWrapperIPlayer != null)) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoPlayerWrapperIPlayer.a(this.jdField_a_of_type_AndroidContentContext, paramString, paramLong, a(paramBoolean));
    }
    this.jdField_f_of_type_Long = 0L;
    this.jdField_e_of_type_Long = 0L;
    this.jdField_d_of_type_Long = 0L;
    this.jdField_g_of_type_Long = paramLong;
    this.jdField_c_of_type_Int = paramInt;
  }
  
  public void a(String paramString1, String paramString2, int paramInt1, long paramLong1, long paramLong2, int paramInt2)
  {
    b(paramString1, paramString2, paramInt1, paramLong1, paramLong2, paramInt2, true, true, false, null);
  }
  
  public void a(String paramString1, String paramString2, int paramInt1, long paramLong1, long paramLong2, int paramInt2, boolean paramBoolean)
  {
    b(paramString1, paramString2, paramInt1, paramLong1, paramLong2, paramInt2, paramBoolean, true, false, null);
  }
  
  public void a(String paramString1, String paramString2, int paramInt1, long paramLong1, long paramLong2, int paramInt2, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    b(paramString1, paramString2, paramInt1, paramLong1, paramLong2, paramInt2, paramBoolean1, paramBoolean2, paramBoolean3, null);
  }
  
  public void a(String paramString1, String paramString2, int paramInt1, long paramLong1, long paramLong2, int paramInt2, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, String paramString3)
  {
    b(paramString1, paramString2, paramInt1, paramLong1, paramLong2, paramInt2, paramBoolean1, paramBoolean2, paramBoolean3, paramString3);
  }
  
  public void a(Map<String, String> paramMap)
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoPlayerWrapperIPlayer != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoPlayerWrapperIPlayer.a(paramMap);
    }
  }
  
  public void a(boolean paramBoolean)
  {
    this.jdField_d_of_type_Boolean = paramBoolean;
  }
  
  public void a(String[] paramArrayOfString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    if (paramArrayOfString != null)
    {
      int j = 0;
      while (j < paramArrayOfString.length)
      {
        if (j != 0) {
          localStringBuilder.append(" ,");
        }
        localStringBuilder.append(paramArrayOfString[j]);
        j += 1;
      }
    }
    this.jdField_a_of_type_JavaLangString = localStringBuilder.toString();
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.get() == 0;
  }
  
  public boolean a(@NotNull IPlayer paramIPlayer, int paramInt1, int paramInt2, int paramInt3, @Nullable String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.jdField_b_of_type_JavaLangString, 2, "VideoPlayerWrapper onError!");
    }
    this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.set(6);
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayerWrapper$MediaPlayListener != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayerWrapper$MediaPlayListener.a(this, paramInt2, paramInt3, paramInt1, paramString, null);
    }
    return false;
  }
  
  public boolean a(@NotNull IPlayer paramIPlayer, int paramInt, @Nullable Object paramObject)
  {
    switch (paramInt)
    {
    }
    for (;;)
    {
      if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayerWrapper$MediaPlayListener != null) {
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayerWrapper$MediaPlayListener.a(this, paramInt, paramObject);
      }
      return false;
      if (QLog.isColorLevel()) {
        QLog.d(this.jdField_b_of_type_JavaLangString, 2, "VideoPlayerWrapper onInfo, start buffering ==> isSeeking = " + this.jdField_c_of_type_Boolean);
      }
      if (this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.get() != 5) {
        this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.set(4);
      }
      this.jdField_h_of_type_Long = System.currentTimeMillis();
      continue;
      if (QLog.isColorLevel()) {
        QLog.d(this.jdField_b_of_type_JavaLangString, 2, "VideoPlayerWrapper onInfo, end buffering <== isSeeking = " + this.jdField_c_of_type_Boolean);
      }
      if (this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.get() != 5) {
        this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.set(3);
      }
      if (!this.jdField_c_of_type_Boolean)
      {
        this.jdField_e_of_type_Int += 1;
        this.jdField_i_of_type_Long += System.currentTimeMillis() - this.jdField_h_of_type_Long;
        continue;
        if ((paramObject instanceof TPPlayerMsg.TPMediaCodecInfo))
        {
          paramIPlayer = (TPPlayerMsg.TPMediaCodecInfo)paramObject;
          this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoCodecReuseHelper.a(paramIPlayer);
        }
        com.tencent.qav.thread.ThreadManager.c(new VideoPlayerWrapper.2(this));
        continue;
        if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayerWrapper$MediaPlayListener != null)
        {
          this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayerWrapper$MediaPlayListener.a(this, "");
          continue;
          if ((paramObject instanceof TPPlayerMsg.TPProtocolInfo)) {
            this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoQuicConfigHelper.a((TPPlayerMsg.TPProtocolInfo)paramObject);
          }
        }
      }
    }
  }
  
  public boolean a(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.jdField_b_of_type_JavaLangString, 2, "attachVideoPlayer: ");
    }
    if (TextUtils.isEmpty(paramString))
    {
      QLog.e(this.jdField_b_of_type_JavaLangString, 2, "attachVideoPlayer failed for token is null.");
      return false;
    }
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoPlayerWrapperIPlayer = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoPlayerWrapperIPlayerFactory.a(paramString);
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoPlayerWrapperIPlayer != null)
    {
      this.jdField_i_of_type_Boolean = false;
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoPlayerWrapperIPlayer.a(this);
      return r();
    }
    QLog.e(this.jdField_b_of_type_JavaLangString, 2, "AttachVideoPlayer error for can't obtain player by token.");
    return false;
  }
  
  public int b()
  {
    return this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.get();
  }
  
  public long b()
  {
    if (this.jdField_d_of_type_Long != 0L) {
      return this.jdField_d_of_type_Long;
    }
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoPlayerWrapperIPlayer != null) {
      return this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoPlayerWrapperIPlayer.a();
    }
    return -1L;
  }
  
  public long b(boolean paramBoolean)
  {
    return this.jdField_f_of_type_Long + a(paramBoolean);
  }
  
  public View b()
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoPlayerWrapperIVideoView == null) {}
    try
    {
      if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoPlayerWrapperIVideoView == null) {
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoPlayerWrapperIVideoView = b();
      }
      if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoPlayerWrapperIVideoView == null)
      {
        if (QLog.isColorLevel()) {
          QLog.d(this.jdField_b_of_type_JavaLangString, 2, "createVideoView: null");
        }
        return null;
      }
    }
    finally {}
    View localView = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoPlayerWrapperIVideoView.a();
    if ((localView != null) && (localView.getParent() != null))
    {
      ViewParent localViewParent = localView.getParent();
      if ((localViewParent instanceof ViewGroup)) {
        ((ViewGroup)localViewParent).removeView(localView);
      }
      if (QLog.isColorLevel()) {
        QLog.d(this.jdField_b_of_type_JavaLangString, 2, "remove scroll view parents!");
      }
    }
    return localView;
  }
  
  public String b()
  {
    return this.jdField_a_of_type_JavaLangString;
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoPlayerWrapperIVideoView != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoPlayerWrapperIVideoView.b();
    }
  }
  
  public void b(int paramInt)
  {
    this.jdField_d_of_type_Int = paramInt;
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoPlayerWrapperIPlayer != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoPlayerWrapperIPlayer.a(paramInt);
    }
    if (QLog.isColorLevel()) {
      QLog.i(this.jdField_b_of_type_JavaLangString, 2, "VideoPlayerWrapper: setXYaxis value:" + paramInt);
    }
  }
  
  public void b(@NotNull IPlayer paramIPlayer)
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.jdField_b_of_type_JavaLangString, 2, "onCompletion: ");
    }
    this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.set(7);
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayerWrapper$MediaPlayListener != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayerWrapper$MediaPlayListener.b(this);
    }
  }
  
  public void b(String paramString)
  {
    this.jdField_c_of_type_JavaLangString = paramString;
  }
  
  public void b(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.get() == 8) {}
    do
    {
      return;
      this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.set(8);
      if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoPlayerWrapperIPlayer != null) {
        com.tencent.mobileqq.app.ThreadManager.executeOnSubThread(new VideoPlayerWrapper.3(this, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoPlayerWrapperIPlayer));
      }
      if ((paramBoolean) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoPlayerWrapperIVideoView != null) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoPlayerWrapperIVideoView.a() != null))
      {
        ViewParent localViewParent = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoPlayerWrapperIVideoView.a().getParent();
        if ((localViewParent instanceof ViewGroup)) {
          ((ViewGroup)localViewParent).removeView(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoPlayerWrapperIVideoView.a());
        }
      }
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayerWrapper$MediaPlayListener = null;
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoPlayerWrapperIVideoView = null;
      this.jdField_a_of_type_AndroidViewViewGroup = null;
      this.jdField_a_of_type_AndroidContentContext = null;
      this.jdField_a_of_type_Boolean = true;
      this.jdField_c_of_type_Long = 0L;
    } while (!QLog.isColorLevel());
    QLog.d(this.jdField_b_of_type_JavaLangString, 2, "VideoPlayerWrapper: destory removeView=" + paramBoolean);
  }
  
  public boolean b()
  {
    return this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.get() == 1;
  }
  
  public int c()
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoPlayerWrapperIPlayer != null) {
      return this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoPlayerWrapperIPlayer.a();
    }
    return -1;
  }
  
  public long c()
  {
    return this.jdField_i_of_type_Long;
  }
  
  public long c(boolean paramBoolean)
  {
    if (paramBoolean) {
      return b();
    }
    return a();
  }
  
  public String c()
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoPlayerWrapperIPlayer != null) {
      return this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoPlayerWrapperIPlayer.b();
    }
    return "";
  }
  
  public void c()
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayerWrapper$MediaPlayListener.a(this);
  }
  
  public void c(@NotNull IPlayer paramIPlayer)
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.jdField_b_of_type_JavaLangString, 2, "VideoPlayerWrapper: onSeekComplete， isPause=" + e());
    }
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayerWrapper$MediaPlayListener != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayerWrapper$MediaPlayListener.c(this);
    }
    this.jdField_c_of_type_Boolean = false;
  }
  
  public void c(boolean paramBoolean)
  {
    this.jdField_f_of_type_Boolean = paramBoolean;
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoPlayerWrapperIPlayer != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoPlayerWrapperIPlayer.a(paramBoolean);
    }
  }
  
  public boolean c()
  {
    return this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.get() == 2;
  }
  
  public int d()
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoPlayerWrapperIPlayer != null) {
      return this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoPlayerWrapperIPlayer.b();
    }
    return -1;
  }
  
  public long d()
  {
    return this.jdField_b_of_type_Long;
  }
  
  public void d()
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoPlayerWrapperIPlayer == null) {}
    do
    {
      return;
      if (!k())
      {
        QLog.e(this.jdField_b_of_type_JavaLangString, 1, "VideoPlayerWrapper: start failed, wrong state:" + VideoPlayUtils.a(this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.get()) + ", just return;");
        return;
      }
      this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.set(3);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoPlayerWrapperIPlayer.a();
    } while (!QLog.isColorLevel());
    QLog.d(this.jdField_b_of_type_JavaLangString, 2, "VideoPlayerWrapper: start");
  }
  
  public void d(boolean paramBoolean)
  {
    this.jdField_g_of_type_Boolean = paramBoolean;
    if (Thread.currentThread() == Looper.getMainLooper().getThread()) {
      com.tencent.mobileqq.app.ThreadManager.excute(new VideoPlayerWrapper.4(this, paramBoolean), 16, null, false);
    }
    while ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoPlayerWrapperIPlayer == null) || (this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.get() == 6) || (this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.get() == 8)) {
      return;
    }
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoPlayerWrapperIPlayer.b(paramBoolean);
  }
  
  public boolean d()
  {
    return this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.get() == 2;
  }
  
  public int e()
  {
    return this.jdField_e_of_type_Int;
  }
  
  public long e()
  {
    return this.jdField_g_of_type_Long;
  }
  
  public void e()
  {
    d();
  }
  
  public void e(boolean paramBoolean)
  {
    this.jdField_e_of_type_Boolean = paramBoolean;
  }
  
  public boolean e()
  {
    return this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.get() == 5;
  }
  
  public int f()
  {
    if ((this.jdField_c_of_type_Int == 104) || (this.jdField_c_of_type_Int == 102)) {
      return 1;
    }
    return 0;
  }
  
  public void f()
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoPlayerWrapperIPlayer != null)
    {
      if (!k()) {
        QLog.e(this.jdField_b_of_type_JavaLangString, 1, "VideoPlayerWrapper: pause failed, wrong state:" + VideoPlayUtils.a(this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.get()) + ", just return;");
      }
    }
    else {
      return;
    }
    this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.set(5);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoPlayerWrapperIPlayer.b();
  }
  
  public boolean f()
  {
    return (this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.get() == 3) || (this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.get() == 4);
  }
  
  public int g()
  {
    if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoPlayerWrapperIPlayer != null) && (this.jdField_b_of_type_Long != 0L)) {
      return Math.round((float)this.jdField_c_of_type_Long / (float)this.jdField_b_of_type_Long * (float)b() / 1000.0F);
    }
    return 0;
  }
  
  public void g()
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoPlayerWrapperIPlayer == null) {}
    do
    {
      return;
      if (this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.get() == 8)
      {
        QLog.e(this.jdField_b_of_type_JavaLangString, 1, "VideoPlayerWrapper: stop failed, because has destoryed, just return;");
        return;
      }
      this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.set(0);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoPlayerWrapperIPlayer.c();
      n();
    } while (!QLog.isColorLevel());
    QLog.d(this.jdField_b_of_type_JavaLangString, 2, "VideoPlayerWrapper: stop ");
  }
  
  public boolean g()
  {
    return this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.get() == 4;
  }
  
  public void h()
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoPlayerWrapperIPlayer == null) {
      return;
    }
    if (this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.get() == 8)
    {
      QLog.e(this.jdField_b_of_type_JavaLangString, 1, "VideoPlayerWrapper: release failed, because has destoryed, just return;");
      return;
    }
    this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.set(8);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoPlayerWrapperIPlayer.d();
  }
  
  public boolean h()
  {
    return this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.get() == 7;
  }
  
  public void i()
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoPlayerWrapperIPlayer != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoPlayerWrapperIPlayer.g();
    }
  }
  
  public boolean i()
  {
    return this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.get() == 8;
  }
  
  public void j()
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoPlayerWrapperIPlayer != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoPlayerWrapperIPlayer.e();
    }
  }
  
  public boolean j()
  {
    boolean bool = false;
    int j = this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.get();
    if (PlayerHelper.a.a()) {
      return j == 0;
    }
    if ((j == 7) || (j == 0) || (j == 6)) {
      bool = true;
    }
    return bool;
  }
  
  public void k()
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoPlayerWrapperIPlayer != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoPlayerWrapperIPlayer.f();
    }
  }
  
  public boolean k()
  {
    return (this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.get() != 0) && (this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.get() != 8) && (this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.get() != 6) && (this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.get() != 7);
  }
  
  public void l()
  {
    if (!this.jdField_i_of_type_Boolean) {}
    for (boolean bool = true;; bool = false)
    {
      b(bool);
      return;
    }
  }
  
  public boolean l()
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoPlayerWrapperIPlayer != null) {
      return this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoPlayerWrapperIPlayer.a();
    }
    return this.jdField_f_of_type_Boolean;
  }
  
  public void m()
  {
    this.jdField_f_of_type_Long += a(true);
    this.jdField_e_of_type_Long = 0L;
    this.jdField_g_of_type_Long = 0L;
  }
  
  public boolean m()
  {
    return this.jdField_g_of_type_Boolean;
  }
  
  public void n()
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.jdField_b_of_type_JavaLangString, 2, "resetVariables: ");
    }
    this.jdField_c_of_type_Int = 101;
    this.jdField_a_of_type_Boolean = false;
    this.jdField_c_of_type_Boolean = false;
    this.jdField_d_of_type_Long = 0L;
    this.jdField_e_of_type_Long = 0L;
    this.jdField_f_of_type_Long = 0L;
    this.jdField_g_of_type_Long = 0L;
    this.jdField_h_of_type_Long = 0L;
    this.jdField_i_of_type_Long = 0L;
    this.jdField_e_of_type_Int = 0;
    this.jdField_a_of_type_Long = 0L;
    this.jdField_a_of_type_Int = 0;
    this.jdField_b_of_type_Boolean = false;
    this.jdField_b_of_type_Int = -1;
    this.jdField_h_of_type_Boolean = false;
    q();
  }
  
  public boolean n()
  {
    return this.jdField_c_of_type_Boolean;
  }
  
  public void o()
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.jdField_b_of_type_JavaLangString, 2, "detachVideoPlayer: ");
    }
    this.jdField_i_of_type_Boolean = true;
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoPlayerWrapperIPlayer != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoPlayerWrapperIPlayer.a(null);
    }
    this.jdField_d_of_type_JavaLangString = c();
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoPlayerWrapperIPlayer = null;
  }
  
  public boolean o()
  {
    return a(this.jdField_d_of_type_JavaLangString);
  }
  
  public void p()
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoPlayerWrapperIPlayer != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoPlayerWrapperIPlayer.h();
    }
  }
  
  public boolean p()
  {
    return this.jdField_h_of_type_Boolean;
  }
  
  public boolean q()
  {
    return this.jdField_i_of_type_Boolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.video.VideoPlayerWrapper
 * JD-Core Version:    0.7.0.1
 */