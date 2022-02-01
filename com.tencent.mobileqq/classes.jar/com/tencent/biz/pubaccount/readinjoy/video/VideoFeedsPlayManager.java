package com.tencent.biz.pubaccount.readinjoy.video;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.aladdin.config.Aladdin;
import com.tencent.aladdin.config.AladdinConfig;
import com.tencent.biz.pubaccount.NativeAd.report.constant.ReportConstants.VideoEndType;
import com.tencent.biz.pubaccount.NativeAd.util.NativeAdUtils;
import com.tencent.biz.pubaccount.VideoAdInfo;
import com.tencent.biz.pubaccount.VideoInfo;
import com.tencent.biz.pubaccount.VideoReporter;
import com.tencent.biz.pubaccount.readinjoy.struct.AdvertisementInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.ReadinjoyAdVideoReportData;
import com.tencent.biz.pubaccount.readinjoy.struct.ReadinjoyVideoReportData;
import com.tencent.biz.pubaccount.readinjoy.video.bandwidth.BandwidthPredictor;
import com.tencent.biz.pubaccount.readinjoy.video.bandwidth.VideoBufferRangeController;
import com.tencent.biz.pubaccount.readinjoy.video.player.wrapper.IVideoView;
import com.tencent.biz.pubaccount.readinjoy.video.player.wrapper.PlayerHelper;
import com.tencent.biz.pubaccount.readinjoy.video.player.wrapper.PlayerHelper.Companion;
import com.tencent.biz.pubaccount.readinjoyAd.ad.data.AdReportData;
import com.tencent.biz.pubaccount.readinjoyAd.ad.utils.ReadInJoyAdUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;
import cooperation.readinjoy.ReadInJoyHelper;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import mqq.os.MqqHandler;
import org.json.JSONObject;

public class VideoFeedsPlayManager
  implements VideoPluginInstall.OnVideoPluginInstallListener, VideoVolumeController.EventListener
{
  private static List<VideoFeedsPlayManager> jdField_a_of_type_JavaUtilList = new ArrayList();
  private int jdField_a_of_type_Int;
  private Context jdField_a_of_type_AndroidContentContext;
  private Handler jdField_a_of_type_AndroidOsHandler = new VideoFeedsPlayManager.1(this, Looper.getMainLooper());
  private ReportConstants.VideoEndType jdField_a_of_type_ComTencentBizPubaccountNativeAdReportConstantReportConstants$VideoEndType;
  private VideoAutoPlayController jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoAutoPlayController;
  private VideoFeedsPlayManager.MediaPlayListenerAdapterImpl jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager$MediaPlayListenerAdapterImpl = new VideoFeedsPlayManager.MediaPlayListenerAdapterImpl(this, null);
  private VideoFeedsPlayManager.VideoPlayParam jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager$VideoPlayParam;
  private VideoFeedsPlayManager.VideoPlayProgressListener jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager$VideoPlayProgressListener;
  private VideoFeedsRecommendManager jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecommendManager;
  private VideoPluginInstall jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPluginInstall;
  private VideoPreDownloadMgr jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPreDownloadMgr;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private Object jdField_a_of_type_JavaLangObject = new Object();
  private String jdField_a_of_type_JavaLangString;
  private ArrayList<VideoFeedsPlayManager.VideoStatusListener> jdField_a_of_type_JavaUtilArrayList = null;
  private Set<String> jdField_a_of_type_JavaUtilSet = new HashSet();
  private ConcurrentHashMap<VideoPlayerWrapper, Object> jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
  private boolean jdField_a_of_type_Boolean = false;
  private int jdField_b_of_type_Int;
  private VideoFeedsPlayManager.VideoPlayParam jdField_b_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager$VideoPlayParam;
  private volatile boolean jdField_b_of_type_Boolean = false;
  private int jdField_c_of_type_Int = -1;
  private boolean jdField_c_of_type_Boolean = false;
  private boolean d;
  private boolean e = false;
  private boolean f;
  private boolean g;
  private boolean h;
  private boolean i;
  private boolean j = false;
  private boolean k = false;
  private boolean l;
  private boolean m = false;
  private boolean n = false;
  private boolean o = false;
  
  public VideoFeedsPlayManager(Context paramContext, QQAppInterface paramQQAppInterface)
  {
    this(paramContext, paramQQAppInterface, 0);
  }
  
  public VideoFeedsPlayManager(Context paramContext, QQAppInterface paramQQAppInterface, int paramInt)
  {
    this.jdField_d_of_type_Boolean = false;
    this.jdField_f_of_type_Boolean = true;
    this.jdField_g_of_type_Boolean = false;
    this.jdField_l_of_type_Boolean = false;
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPluginInstall = new VideoPluginInstall();
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPluginInstall.a(this);
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
    VideoVolumeController.a().a(this);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoAutoPlayController = VideoAutoPlayController.a();
    if (VideoAutoPlayController.a(this.jdField_a_of_type_AndroidContentContext)) {
      e(true);
    }
    for (;;)
    {
      if ((ReadInJoyHelper.h(paramQQAppInterface)) || (PlayerHelper.a.a())) {
        bool = true;
      }
      this.jdField_h_of_type_Boolean = bool;
      jdField_a_of_type_JavaUtilList.add(this);
      j();
      return;
      e(false);
    }
  }
  
  private VideoFeedsPlayManager.VideoPlayParam a(VideoFeedsPlayManager.VideoPlayParam paramVideoPlayParam)
  {
    if (paramVideoPlayParam == this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager$VideoPlayParam) {
      return paramVideoPlayParam;
    }
    return null;
  }
  
  private VideoPlayerWrapper a()
  {
    return b(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager$VideoPlayParam);
  }
  
  private VideoPlayerWrapper a(VideoFeedsPlayManager.VideoPlayParam paramVideoPlayParam)
  {
    if ((this.jdField_a_of_type_AndroidContentContext == null) || (this.jdField_b_of_type_Boolean)) {
      return null;
    }
    paramVideoPlayParam = new VideoPlayerWrapper(this.jdField_a_of_type_AndroidContentContext.getApplicationContext(), paramVideoPlayParam.jdField_a_of_type_JavaLangString);
    paramVideoPlayParam.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager$MediaPlayListenerAdapterImpl);
    return paramVideoPlayParam;
  }
  
  private VideoPlayerWrapper a(VideoPlayerWrapper paramVideoPlayerWrapper)
  {
    if (paramVideoPlayerWrapper == a()) {
      return paramVideoPlayerWrapper;
    }
    return null;
  }
  
  private void a(ReadinjoyVideoReportData paramReadinjoyVideoReportData)
  {
    ThreadManager.excute(new VideoFeedsPlayManager.8(this, paramReadinjoyVideoReportData), 16, null, true);
  }
  
  private void a(VideoPlayerWrapper paramVideoPlayerWrapper)
  {
    if (paramVideoPlayerWrapper == null) {}
    do
    {
      return;
      paramVideoPlayerWrapper.n();
    } while (paramVideoPlayerWrapper.j());
    paramVideoPlayerWrapper.j();
    ThreadManager.excute(new VideoFeedsPlayManager.7(this, paramVideoPlayerWrapper), 16, null, true);
  }
  
  private void a(boolean paramBoolean, VideoFeedsPlayManager.VideoPlayParam paramVideoPlayParam, ReportConstants.VideoEndType paramVideoEndType)
  {
    Object localObject;
    if (paramVideoPlayParam.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructReadinjoyVideoReportData != null)
    {
      localObject = a();
      paramVideoPlayParam.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructReadinjoyVideoReportData.jdField_a_of_type_Long = ((VideoPlayerWrapper)localObject).a(this.jdField_c_of_type_Boolean);
      paramVideoPlayParam.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructReadinjoyVideoReportData.jdField_g_of_type_Int = ((VideoPlayerWrapper)localObject).e();
      paramVideoPlayParam.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructReadinjoyVideoReportData.jdField_n_of_type_Long = ((VideoPlayerWrapper)localObject).c();
      paramVideoPlayParam.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructReadinjoyVideoReportData.jdField_h_of_type_Int = ((VideoPlayerWrapper)localObject).f();
      paramVideoPlayParam.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructReadinjoyVideoReportData.jdField_c_of_type_Boolean = ((VideoPlayerWrapper)localObject).jdField_b_of_type_Boolean;
      paramVideoPlayParam.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructReadinjoyVideoReportData.jdField_q_of_type_Long = ((VideoPlayerWrapper)localObject).jdField_b_of_type_Long;
      paramVideoPlayParam.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructReadinjoyVideoReportData.jdField_p_of_type_Long = ((VideoPlayerWrapper)localObject).jdField_a_of_type_Long;
      paramVideoPlayParam.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructReadinjoyVideoReportData.jdField_r_of_type_Long = ((VideoPlayerWrapper)localObject).g();
      if ((paramVideoPlayParam.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructReadinjoyVideoReportData.jdField_a_of_type_Long == 0L) && (paramVideoPlayParam.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructReadinjoyVideoReportData.jdField_d_of_type_Long == 0L))
      {
        paramVideoPlayParam.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructReadinjoyVideoReportData.jdField_d_of_type_Long = (SystemClock.uptimeMillis() - paramVideoPlayParam.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructReadinjoyVideoReportData.jdField_b_of_type_Long);
        paramVideoPlayParam.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructReadinjoyVideoReportData.jdField_f_of_type_Long = paramVideoPlayParam.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructReadinjoyVideoReportData.jdField_d_of_type_Long;
      }
      paramVideoPlayParam.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructReadinjoyVideoReportData.t = BandwidthPredictor.a().a();
      paramVideoPlayParam.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructReadinjoyVideoReportData.jdField_m_of_type_JavaLangString = VideoBufferRangeController.a().a();
      paramVideoPlayParam.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructReadinjoyVideoReportData.jdField_b_of_type_Int = this.jdField_b_of_type_Int;
      paramVideoPlayParam.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructReadinjoyVideoReportData.jdField_l_of_type_Boolean = ((VideoPlayerWrapper)localObject).p();
      ((VideoPlayerWrapper)localObject).a(paramVideoPlayParam.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructReadinjoyVideoReportData.b());
      a(paramVideoPlayParam.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructReadinjoyVideoReportData);
    }
    label323:
    AdvertisementInfo localAdvertisementInfo;
    int i5;
    int i6;
    int i1;
    label432:
    int i2;
    label443:
    int i3;
    if ((h()) && (paramBoolean) && (!paramVideoPlayParam.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructReadinjoyAdVideoReportData.jdField_d_of_type_Boolean))
    {
      if (a().e() != 0L) {
        break label555;
      }
      paramVideoPlayParam.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructReadinjoyAdVideoReportData.jdField_d_of_type_Int = paramVideoPlayParam.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructReadinjoyAdVideoReportData.e;
      paramVideoPlayParam.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructReadinjoyAdVideoReportData.e = ((int)a().c(this.jdField_c_of_type_Boolean));
      localObject = paramVideoPlayParam.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructReadinjoyAdVideoReportData;
      if (paramVideoPlayParam.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructReadinjoyAdVideoReportData.jdField_d_of_type_Int != 0) {
        break label573;
      }
      paramBoolean = true;
      ((ReadinjoyAdVideoReportData)localObject).jdField_b_of_type_Boolean = paramBoolean;
      paramVideoPlayParam.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructReadinjoyAdVideoReportData.jdField_c_of_type_Boolean = this.jdField_c_of_type_Boolean;
      paramVideoPlayParam.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructReadinjoyAdVideoReportData.jdField_h_of_type_Int = ((int)a().b());
      localObject = paramVideoPlayParam.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructReadinjoyAdVideoReportData;
      VideoReporter.a(((ReadinjoyAdVideoReportData)localObject).jdField_a_of_type_Boolean, ((ReadinjoyAdVideoReportData)localObject).jdField_d_of_type_Int, ((ReadinjoyAdVideoReportData)localObject).e, ((ReadinjoyAdVideoReportData)localObject).jdField_b_of_type_Boolean, ((ReadinjoyAdVideoReportData)localObject).jdField_c_of_type_Boolean, ((ReadinjoyAdVideoReportData)localObject).f);
      localAdvertisementInfo = NativeAdUtils.a(paramVideoPlayParam.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_ComTencentBizPubaccountVideoAdInfo);
      i5 = ((ReadinjoyAdVideoReportData)localObject).jdField_d_of_type_Int;
      i6 = ((ReadinjoyAdVideoReportData)localObject).e;
      if (!((ReadinjoyAdVideoReportData)localObject).jdField_b_of_type_Boolean) {
        break label578;
      }
      i1 = 1;
      if (!((ReadinjoyAdVideoReportData)localObject).jdField_c_of_type_Boolean) {
        break label584;
      }
      i2 = 1;
      if (!ReadInJoyAdUtils.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager$VideoPlayParam)) {
        break label590;
      }
      i3 = 20;
      label457:
      if (!((ReadinjoyAdVideoReportData)localObject).jdField_a_of_type_Boolean) {
        break label596;
      }
    }
    label555:
    label573:
    label578:
    label584:
    label590:
    label596:
    for (int i4 = 1;; i4 = 2)
    {
      paramVideoEndType = NativeAdUtils.a(i5, i6, i1, i2, i3, i4, ((ReadinjoyAdVideoReportData)localObject).jdField_h_of_type_Int, 2, 0, ((ReadinjoyAdVideoReportData)localObject).jdField_i_of_type_Int, paramVideoEndType, true);
      NativeAdUtils.a(new AdReportData().a(this.jdField_a_of_type_AndroidContentContext).a(6).b(((ReadinjoyAdVideoReportData)localObject).jdField_g_of_type_Int).a(localAdvertisementInfo).a(paramVideoPlayParam.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_ComTencentBizPubaccountVideoAdInfo).a(paramVideoEndType));
      ReadInJoyAdUtils.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager$VideoPlayParam);
      return;
      paramVideoPlayParam.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructReadinjoyAdVideoReportData.jdField_d_of_type_Int = ((int)a().e());
      break;
      paramBoolean = false;
      break label323;
      i1 = 0;
      break label432;
      i2 = 0;
      break label443;
      i3 = 0;
      break label457;
    }
  }
  
  private boolean a(int paramInt)
  {
    return (paramInt == 105) || (paramInt == 208);
  }
  
  private boolean a(VideoFeedsPlayManager.VideoPlayParam paramVideoPlayParam)
  {
    boolean bool2 = false;
    VideoPlayerWrapper localVideoPlayerWrapper = b(paramVideoPlayParam);
    int i1;
    int i2;
    label60:
    boolean bool1;
    if ((localVideoPlayerWrapper != null) && ((localVideoPlayerWrapper.d()) || (localVideoPlayerWrapper.e()) || (localVideoPlayerWrapper.g())))
    {
      i1 = 1;
      if ((localVideoPlayerWrapper != null) && (localVideoPlayerWrapper.a() != paramVideoPlayParam.jdField_a_of_type_ComTencentBizPubaccountVideoInfo)) {
        break label172;
      }
      i2 = 1;
      if ((i1 == 0) || (i2 == 0)) {
        break label177;
      }
      if (QLog.isColorLevel()) {
        QLog.d("VideoFeedsPlayManager.preplay", 2, "VideoFeedsPlayManager playVideo hasPrePlay, just go onVideoPrepared");
      }
      paramVideoPlayParam.jdField_a_of_type_Boolean = false;
      paramVideoPlayParam.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructReadinjoyVideoReportData.jdField_b_of_type_Long = SystemClock.uptimeMillis();
      paramVideoPlayParam.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructReadinjoyVideoReportData.o = 2;
      paramVideoPlayParam.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayerWrapper.k();
      paramVideoPlayParam.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayerWrapper.p();
      if (!TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) {
        paramVideoPlayParam.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructReadinjoyVideoReportData.jdField_g_of_type_JavaLangString = this.jdField_a_of_type_JavaLangString;
      }
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager$MediaPlayListenerAdapterImpl.a(paramVideoPlayParam);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager$MediaPlayListenerAdapterImpl.d(paramVideoPlayParam.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayerWrapper);
      bool1 = true;
    }
    label172:
    label177:
    do
    {
      do
      {
        return bool1;
        i1 = 0;
        break;
        i2 = 0;
        break label60;
        bool1 = bool2;
      } while (!paramVideoPlayParam.jdField_a_of_type_Boolean);
      bool1 = bool2;
    } while (i2 == 0);
    StringBuilder localStringBuilder;
    if (QLog.isColorLevel())
    {
      localStringBuilder = new StringBuilder().append("VideoFeedsPlayManager playVideo prePlaying, just do nothing ");
      if (localVideoPlayerWrapper == null) {
        break label302;
      }
    }
    label302:
    for (Integer localInteger = Integer.valueOf(localVideoPlayerWrapper.b());; localInteger = null)
    {
      QLog.d("VideoFeedsPlayManager.preplay", 2, localInteger);
      if (localVideoPlayerWrapper != null)
      {
        localVideoPlayerWrapper.k();
        localVideoPlayerWrapper.p();
      }
      paramVideoPlayParam.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructReadinjoyVideoReportData.jdField_b_of_type_Long = SystemClock.uptimeMillis();
      paramVideoPlayParam.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructReadinjoyVideoReportData.o = 1;
      this.m = true;
      this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(-3, 10000L);
      return true;
    }
  }
  
  private boolean a(VideoPlayerWrapper paramVideoPlayerWrapper)
  {
    return a(paramVideoPlayerWrapper) != null;
  }
  
  private VideoPlayerWrapper b(VideoFeedsPlayManager.VideoPlayParam paramVideoPlayParam)
  {
    if (paramVideoPlayParam != null) {
      return paramVideoPlayParam.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayerWrapper;
    }
    return null;
  }
  
  private void b(VideoFeedsPlayManager.VideoPlayParam paramVideoPlayParam, boolean paramBoolean)
  {
    VideoPlayerWrapper localVideoPlayerWrapper = b(paramVideoPlayParam);
    if (localVideoPlayerWrapper != null) {}
    for (Object localObject = localVideoPlayerWrapper.a(); (localVideoPlayerWrapper != null) && (localObject == null) && (localVideoPlayerWrapper.j()); localObject = null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("VideoFeedsPlayManager.preplay", 2, "createVideoPlayerAndPlay VideoFeedsPlayManager innerPlayVideo hit cache");
      }
      paramVideoPlayParam.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayerWrapper.a(paramVideoPlayParam.jdField_a_of_type_ComTencentBizPubaccountVideoInfo);
      d(paramVideoPlayParam, paramBoolean);
      return;
    }
    StringBuilder localStringBuilder;
    if (paramVideoPlayParam.jdField_c_of_type_Boolean)
    {
      if (QLog.isColorLevel())
      {
        localStringBuilder = new StringBuilder().append("createVideoPlayerAndPlay: isSeamlessPlay， tag ");
        if (localObject == null) {
          break label149;
        }
      }
      label149:
      for (localObject = "not null";; localObject = "null")
      {
        QLog.d("VideoFeedsPlayManager.preplay", 2, (String)localObject);
        if (localVideoPlayerWrapper != null) {
          localVideoPlayerWrapper.b(true);
        }
        paramVideoPlayParam.jdField_a_of_type_AndroidViewView = null;
        c(paramVideoPlayParam, paramBoolean);
        return;
      }
    }
    if (QLog.isColorLevel())
    {
      localStringBuilder = new StringBuilder().append("createVideoPlayerAndPlay: tag ");
      if (localObject == null) {
        break label245;
      }
    }
    label245:
    for (localObject = "not null";; localObject = "null")
    {
      QLog.d("VideoFeedsPlayManager.preplay", 2, (String)localObject + ", oldPlayer=" + localVideoPlayerWrapper);
      if (localVideoPlayerWrapper != null) {
        localVideoPlayerWrapper.b(true);
      }
      paramVideoPlayParam.jdField_a_of_type_AndroidViewView = null;
      ThreadManager.post(new VideoFeedsPlayManager.2(this, paramVideoPlayParam, paramBoolean), 5, null, true);
      return;
    }
  }
  
  private boolean b(VideoFeedsPlayManager.VideoPlayParam paramVideoPlayParam)
  {
    return a(paramVideoPlayParam) != null;
  }
  
  private void c(VideoFeedsPlayManager.VideoPlayParam paramVideoPlayParam, boolean paramBoolean)
  {
    paramVideoPlayParam.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayerWrapper = a(paramVideoPlayParam);
    if (QLog.isColorLevel()) {
      QLog.d("VideoFeedsPlayManager.preplay", 2, "VideoFeedsPlayManager innerPlayVideo miss cache");
    }
    if ((paramVideoPlayParam.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayerWrapper != null) && (this.jdField_a_of_type_AndroidOsHandler != null) && (paramVideoPlayParam.jdField_a_of_type_ComTencentBizPubaccountVideoInfo != null))
    {
      paramVideoPlayParam.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayerWrapper.a(paramVideoPlayParam.jdField_a_of_type_ComTencentBizPubaccountVideoInfo);
      this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(paramVideoPlayParam.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayerWrapper, this.jdField_a_of_type_JavaLangObject);
      this.jdField_a_of_type_AndroidOsHandler.post(new VideoFeedsPlayManager.3(this, paramVideoPlayParam, paramBoolean));
    }
    while (!QLog.isColorLevel()) {
      return;
    }
    QLog.d("Q.pubaccount.video.feeds.VideoFeedsPlayManager", 2, "createVideoPlayerAndPlay aysnc run error : playerParam.videoPlayer = " + paramVideoPlayParam.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayerWrapper + ", mUIHandler = " + this.jdField_a_of_type_AndroidOsHandler);
  }
  
  private void d(VideoFeedsPlayManager.VideoPlayParam paramVideoPlayParam)
  {
    ReadinjoyVideoReportData localReadinjoyVideoReportData;
    if (paramVideoPlayParam != null)
    {
      paramVideoPlayParam.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructReadinjoyVideoReportData = new ReadinjoyVideoReportData();
      paramVideoPlayParam.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructReadinjoyVideoReportData.jdField_a_of_type_Int = paramVideoPlayParam.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_Int;
      paramVideoPlayParam.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructReadinjoyVideoReportData.jdField_b_of_type_JavaLangString = paramVideoPlayParam.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_JavaLangString;
      paramVideoPlayParam.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructReadinjoyVideoReportData.jdField_a_of_type_JavaLangString = paramVideoPlayParam.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_g_of_type_JavaLangString;
      localReadinjoyVideoReportData = paramVideoPlayParam.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructReadinjoyVideoReportData;
      if (this.jdField_a_of_type_Int != 1) {
        break label274;
      }
    }
    label274:
    for (int i1 = 5;; i1 = 2)
    {
      localReadinjoyVideoReportData.jdField_d_of_type_Int = i1;
      paramVideoPlayParam.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructReadinjoyVideoReportData.k = paramVideoPlayParam.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_b_of_type_Int;
      paramVideoPlayParam.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructReadinjoyVideoReportData.jdField_l_of_type_Int = paramVideoPlayParam.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_c_of_type_Int;
      paramVideoPlayParam.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructReadinjoyVideoReportData.s = paramVideoPlayParam.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_d_of_type_Int;
      paramVideoPlayParam.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructReadinjoyVideoReportData.jdField_a_of_type_Boolean = true;
      paramVideoPlayParam.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructReadinjoyVideoReportData.jdField_p_of_type_Int = 0;
      paramVideoPlayParam.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructReadinjoyVideoReportData.jdField_q_of_type_Int = 0;
      paramVideoPlayParam.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructReadinjoyVideoReportData.jdField_r_of_type_Int = 0;
      paramVideoPlayParam.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructReadinjoyVideoReportData.jdField_f_of_type_Boolean = false;
      paramVideoPlayParam.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructReadinjoyVideoReportData.jdField_f_of_type_JavaLangString = "";
      paramVideoPlayParam.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructReadinjoyVideoReportData.jdField_g_of_type_Boolean = false;
      paramVideoPlayParam.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructReadinjoyVideoReportData.jdField_h_of_type_Boolean = false;
      paramVideoPlayParam.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructReadinjoyVideoReportData.jdField_i_of_type_Int = paramVideoPlayParam.jdField_a_of_type_AndroidOsBundle.getInt("jump_from_scene");
      paramVideoPlayParam.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructReadinjoyVideoReportData.j = paramVideoPlayParam.jdField_a_of_type_AndroidOsBundle.getInt("video_feeds_index");
      if ((paramVideoPlayParam != null) && (paramVideoPlayParam.jdField_a_of_type_ComTencentBizPubaccountVideoInfo != null) && (paramVideoPlayParam.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_c_of_type_Boolean))
      {
        paramVideoPlayParam.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructReadinjoyAdVideoReportData = new ReadinjoyAdVideoReportData();
        i1 = paramVideoPlayParam.jdField_a_of_type_AndroidOsBundle.getInt("ad_origin", 10);
        paramVideoPlayParam.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructReadinjoyAdVideoReportData.jdField_g_of_type_Int = i1;
      }
      return;
    }
  }
  
  private void d(VideoFeedsPlayManager.VideoPlayParam paramVideoPlayParam, boolean paramBoolean)
  {
    VideoPlayerWrapper localVideoPlayerWrapper = b(paramVideoPlayParam);
    if ((paramVideoPlayParam == null) || (localVideoPlayerWrapper == null)) {
      return;
    }
    paramVideoPlayParam.jdField_a_of_type_AndroidViewViewGroup.setKeepScreenOn(true);
    if (QLog.isColorLevel()) {
      QLog.d("Q.pubaccount.video.feeds.VideoFeedsPlayManager", 2, "innerPlayVideo: ");
    }
    if (paramVideoPlayParam.jdField_a_of_type_AndroidViewView == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("VideoFeedsPlayManager.preplay", 2, "VideoFeedsPlayManager innerPlayVideo videoView null");
      }
      paramVideoPlayParam.jdField_a_of_type_AndroidViewViewGroup.removeAllViews();
      localVideoPlayerWrapper.a(paramVideoPlayParam.jdField_a_of_type_AndroidViewViewGroup, paramVideoPlayParam.jdField_c_of_type_Boolean, false);
      if ((paramVideoPlayParam.jdField_c_of_type_Boolean) && (localVideoPlayerWrapper.a() != 0))
      {
        localVideoPlayerWrapper.g();
        paramVideoPlayParam.jdField_c_of_type_Boolean = false;
        paramVideoPlayParam.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoIVideoUIDelegate.b(paramVideoPlayParam, false);
      }
      View localView = localVideoPlayerWrapper.a();
      if (localView == null)
      {
        if (paramVideoPlayParam.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoIVideoUIDelegate != null) {
          paramVideoPlayParam.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoIVideoUIDelegate.a(paramVideoPlayParam, 999, 999, null);
        }
        paramVideoPlayParam.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayerWrapper = null;
        return;
      }
      paramVideoPlayParam.jdField_a_of_type_AndroidViewView = localView;
      localView.setId(2131376562);
      if (paramVideoPlayParam.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoIVideoUIDelegate != null) {
        paramVideoPlayParam.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoIVideoUIDelegate.b(paramVideoPlayParam);
      }
      if ((paramVideoPlayParam.jdField_a_of_type_ComTencentBizPubaccountVideoInfo != null) && (paramVideoPlayParam.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_b_of_type_Int > 0) && (paramVideoPlayParam.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_c_of_type_Int > 0) && (paramVideoPlayParam.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_c_of_type_Int < 10000) && (paramVideoPlayParam.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_b_of_type_Int < 10000)) {
        localVideoPlayerWrapper.a().a(paramVideoPlayParam.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_b_of_type_Int, paramVideoPlayParam.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_c_of_type_Int);
      }
    }
    int i1;
    if (this.jdField_a_of_type_Boolean)
    {
      i1 = 2;
      localVideoPlayerWrapper.b(i1);
      if ((!this.o) && (!this.jdField_g_of_type_Boolean)) {
        break label502;
      }
    }
    label502:
    for (boolean bool = true;; bool = false)
    {
      localVideoPlayerWrapper.d(bool);
      localVideoPlayerWrapper.a(this.jdField_h_of_type_Boolean);
      localVideoPlayerWrapper.e(paramVideoPlayParam.jdField_b_of_type_Boolean);
      localVideoPlayerWrapper.c(this.jdField_i_of_type_Boolean);
      if (QLog.isColorLevel()) {
        QLog.d("Q.pubaccount.video.feeds.VideoFeedsPlayManager", 2, "innerPlayVideo: isMuted=" + b(paramVideoPlayParam).l());
      }
      paramVideoPlayParam.jdField_a_of_type_AndroidViewView.setVisibility(0);
      if (!paramBoolean) {
        paramVideoPlayParam.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructReadinjoyVideoReportData.jdField_b_of_type_Long = SystemClock.uptimeMillis();
      }
      if (paramVideoPlayParam.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructReadinjoyVideoReportData != null)
      {
        paramVideoPlayParam.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructReadinjoyVideoReportData.jdField_p_of_type_Int = 0;
        paramVideoPlayParam.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructReadinjoyVideoReportData.jdField_q_of_type_Int = 0;
        paramVideoPlayParam.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructReadinjoyVideoReportData.jdField_r_of_type_Int = 0;
        paramVideoPlayParam.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructReadinjoyVideoReportData.jdField_g_of_type_Boolean = false;
        paramVideoPlayParam.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructReadinjoyVideoReportData.jdField_h_of_type_Boolean = false;
        paramVideoPlayParam.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructReadinjoyVideoReportData.jdField_i_of_type_Boolean = this.jdField_h_of_type_Boolean;
      }
      if (!paramVideoPlayParam.jdField_c_of_type_Boolean) {
        ThreadManager.excute(new VideoFeedsPlayManager.PlayStartVideoRunnable(this, paramVideoPlayParam, localVideoPlayerWrapper, paramBoolean), 16, null, true);
      }
      paramVideoPlayParam.jdField_c_of_type_Boolean = false;
      paramVideoPlayParam.jdField_a_of_type_JavaLangString = null;
      return;
      i1 = paramVideoPlayParam.jdField_a_of_type_Int;
      break;
    }
  }
  
  private void h()
  {
    if (Looper.myLooper() == Looper.getMainLooper()) {
      ThreadManager.getSubThreadHandler().postAtFrontOfQueue(new VideoFeedsPlayManager.4(this));
    }
    VideoPlayerWrapper localVideoPlayerWrapper;
    do
    {
      return;
      if (QLog.isColorLevel()) {
        QLog.d("VideoFeedsPlayManager.preplay", 2, "innerChangeCoverImageView: getCurVideoPlayer().start() ");
      }
      localVideoPlayerWrapper = a();
    } while (localVideoPlayerWrapper == null);
    localVideoPlayerWrapper.d();
  }
  
  private boolean h()
  {
    return (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager$VideoPlayParam != null) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager$VideoPlayParam.jdField_a_of_type_ComTencentBizPubaccountVideoInfo != null) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager$VideoPlayParam.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructReadinjoyAdVideoReportData != null) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager$VideoPlayParam.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_c_of_type_Boolean) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager$VideoPlayParam.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_ComTencentBizPubaccountVideoAdInfo != null);
  }
  
  private void i()
  {
    Object localObject;
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager$VideoPlayParam != null)
    {
      localObject = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager$VideoPlayParam;
      if ((d()) || (b())) {
        this.k = true;
      }
      b(ReportConstants.VideoEndType.EXIT_SCENE);
      ((VideoFeedsPlayManager.VideoPlayParam)localObject).jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayerWrapper = null;
      ((VideoFeedsPlayManager.VideoPlayParam)localObject).jdField_a_of_type_AndroidViewView = null;
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager$VideoPlayParam = ((VideoFeedsPlayManager.VideoPlayParam)localObject);
    }
    if (this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager$VideoPlayParam != null)
    {
      if (b(this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager$VideoPlayParam) != null) {
        b(this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager$VideoPlayParam).l();
      }
      this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager$VideoPlayParam.jdField_a_of_type_AndroidViewView = null;
      this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager$VideoPlayParam.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayerWrapper = null;
      this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager$VideoPlayParam = null;
    }
    if (this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap != null)
    {
      localObject = this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.keySet().iterator();
      while (((Iterator)localObject).hasNext())
      {
        VideoPlayerWrapper localVideoPlayerWrapper = (VideoPlayerWrapper)((Iterator)localObject).next();
        if ((localVideoPlayerWrapper != null) && (!localVideoPlayerWrapper.i())) {
          localVideoPlayerWrapper.l();
        }
      }
      this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.clear();
    }
  }
  
  private void j()
  {
    int i1 = Aladdin.getConfig(352).getIntegerFromString("play_manager_max_count", 3);
    if (QLog.isColorLevel()) {
      QLog.d("Q.pubaccount.video.feeds.VideoFeedsPlayManager", 2, "inspectPlayerMemory: size=" + jdField_a_of_type_JavaUtilList.size() + ", maxCount=" + i1);
    }
    if (jdField_a_of_type_JavaUtilList.size() > i1)
    {
      int i2 = jdField_a_of_type_JavaUtilList.size();
      ((VideoFeedsPlayManager)jdField_a_of_type_JavaUtilList.get(i2 - i1 - 1)).i();
    }
  }
  
  public int a()
  {
    if (a() != null) {
      return a().b();
    }
    return 0;
  }
  
  public long a()
  {
    if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager$VideoPlayParam != null) && (a() != null)) {
      return a().a();
    }
    return 0L;
  }
  
  public VideoInfo a()
  {
    if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager$VideoPlayParam == null) || (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager$VideoPlayParam.jdField_a_of_type_ComTencentBizPubaccountVideoInfo == null)) {
      return null;
    }
    return this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager$VideoPlayParam.jdField_a_of_type_ComTencentBizPubaccountVideoInfo;
  }
  
  public VideoFeedsPlayManager.VideoPlayParam a()
  {
    return this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager$VideoPlayParam;
  }
  
  public void a()
  {
    Object localObject;
    if (a() != null)
    {
      if (this.jdField_a_of_type_JavaUtilArrayList != null)
      {
        localObject = this.jdField_a_of_type_JavaUtilArrayList.iterator();
        while (((Iterator)localObject).hasNext()) {
          ((VideoFeedsPlayManager.VideoStatusListener)((Iterator)localObject).next()).f(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager$VideoPlayParam);
        }
      }
      h();
    }
    this.jdField_a_of_type_AndroidOsHandler.removeMessages(-2);
    this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(-2);
    this.jdField_a_of_type_AndroidOsHandler.post(new VideoFeedsPlayManager.5(this));
    if (h()) {}
    try
    {
      localObject = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager$VideoPlayParam.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_ComTencentBizPubaccountVideoAdInfo.h;
      if (!this.jdField_a_of_type_JavaUtilSet.contains(localObject))
      {
        this.jdField_a_of_type_JavaUtilSet.add(localObject);
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager$VideoPlayParam.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructReadinjoyAdVideoReportData.f = ReadinjoyAdVideoReportData.jdField_a_of_type_Int;
      }
      for (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager$VideoPlayParam.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructReadinjoyAdVideoReportData.jdField_i_of_type_Int = 0;; ((ReadinjoyAdVideoReportData)localObject).jdField_i_of_type_Int += 1)
      {
        localObject = a();
        if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager$VideoPlayParam != null) && (localObject != null))
        {
          this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager$VideoPlayParam.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructReadinjoyVideoReportData.jdField_n_of_type_Int = ((VideoPlayerWrapper)localObject).d();
          this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager$VideoPlayParam.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructReadinjoyVideoReportData.jdField_m_of_type_Int = ((VideoPlayerWrapper)localObject).c();
        }
        return;
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager$VideoPlayParam.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructReadinjoyAdVideoReportData.f = ReadinjoyAdVideoReportData.jdField_c_of_type_Int;
        localObject = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager$VideoPlayParam.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructReadinjoyAdVideoReportData;
      }
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        QLog.e("Q.pubaccount.video.feeds.VideoFeedsPlayManager", 1, localThrowable, new Object[0]);
      }
    }
  }
  
  public void a(float paramFloat)
  {
    if (a() != null) {
      a().a(paramFloat);
    }
  }
  
  public void a(int paramInt)
  {
    a(paramInt, false);
  }
  
  public void a(int paramInt, boolean paramBoolean)
  {
    if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager$VideoPlayParam != null) && (a() != null))
    {
      this.j = true;
      a().a(paramInt);
      if ((paramBoolean) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager$VideoPlayParam != null) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager$VideoPlayParam.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoIVideoUIDelegate != null))
      {
        long l1 = a().b();
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager$VideoPlayParam.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoIVideoUIDelegate.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager$VideoPlayParam, (int)(paramInt * 100.0F / (float)l1 + 0.5D), l1);
      }
      this.jdField_a_of_type_AndroidOsHandler.removeMessages(-2);
    }
  }
  
  public void a(ReportConstants.VideoEndType paramVideoEndType)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountNativeAdReportConstantReportConstants$VideoEndType = paramVideoEndType;
  }
  
  public void a(VideoFeedsPlayManager.VideoPlayParam paramVideoPlayParam)
  {
    this.jdField_c_of_type_Boolean = false;
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager$VideoPlayParam = paramVideoPlayParam;
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager$VideoPlayParam.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoIVideoUIDelegate != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager$VideoPlayParam.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoIVideoUIDelegate.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager$VideoPlayParam);
    }
  }
  
  public void a(VideoFeedsPlayManager.VideoPlayParam paramVideoPlayParam, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("VideoFeedsPlayManager.preplay", 2, "VideoFeedsPlayManager playVideo");
    }
    if (this.jdField_b_of_type_Boolean) {
      if (QLog.isColorLevel()) {
        QLog.d("Q.pubaccount.video.feeds.VideoFeedsPlayManager", 2, "playVideo: mHasDestory=" + this.jdField_b_of_type_Boolean);
      }
    }
    do
    {
      do
      {
        return;
        if ((paramVideoPlayParam != null) && (paramVideoPlayParam.jdField_a_of_type_ComTencentBizPubaccountVideoInfo != null)) {
          break;
        }
      } while (!QLog.isColorLevel());
      QLog.d("Q.pubaccount.video.feeds.VideoFeedsPlayManager", 2, "playVideo() error, playerParam or videoInfo is null");
      return;
      if (QLog.isColorLevel()) {
        QLog.d("Q.pubaccount.video.feeds.VideoFeedsPlayManager", 2, "playVideo() vid=" + paramVideoPlayParam.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_JavaLangString);
      }
      this.jdField_c_of_type_Boolean = false;
      this.jdField_b_of_type_Int = 0;
      this.jdField_d_of_type_Boolean = false;
      this.e = false;
      this.j = false;
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager$VideoPlayParam = paramVideoPlayParam;
      this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager$VideoPlayParam = null;
      if (this.jdField_a_of_type_JavaUtilArrayList != null)
      {
        Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
        while (localIterator.hasNext()) {
          ((VideoFeedsPlayManager.VideoStatusListener)localIterator.next()).e(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager$VideoPlayParam);
        }
      }
      if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager$VideoPlayParam.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoIVideoUIDelegate != null) {
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager$VideoPlayParam.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoIVideoUIDelegate.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager$VideoPlayParam, paramBoolean);
      }
      this.jdField_a_of_type_AndroidOsHandler.removeMessages(-3);
    } while (a(paramVideoPlayParam));
    d(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager$VideoPlayParam);
    paramVideoPlayParam.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructReadinjoyVideoReportData.jdField_c_of_type_Long = SystemClock.uptimeMillis();
    if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPluginInstall != null) && (!this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPluginInstall.a()))
    {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPluginInstall.a();
      return;
    }
    paramVideoPlayParam.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructReadinjoyVideoReportData.o = 0;
    b(paramVideoPlayParam, false);
  }
  
  public void a(VideoFeedsPlayManager.VideoPlayProgressListener paramVideoPlayProgressListener)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager$VideoPlayProgressListener = paramVideoPlayProgressListener;
  }
  
  public void a(VideoFeedsPlayManager.VideoStatusListener paramVideoStatusListener)
  {
    this.jdField_a_of_type_JavaUtilArrayList.add(paramVideoStatusListener);
  }
  
  public void a(VideoFeedsRecommendManager paramVideoFeedsRecommendManager)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecommendManager = paramVideoFeedsRecommendManager;
  }
  
  public void a(VideoPreDownloadMgr paramVideoPreDownloadMgr)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPreDownloadMgr = paramVideoPreDownloadMgr;
  }
  
  public void a(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager$VideoPlayParam != null) {
        a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager$VideoPlayParam, true);
      }
      return;
    }
    if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager$VideoPlayParam != null) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager$VideoPlayParam.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoIVideoUIDelegate != null)) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager$VideoPlayParam.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoIVideoUIDelegate.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager$VideoPlayParam, 999, 998, null);
    }
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager$VideoPlayParam = null;
  }
  
  public void a(boolean paramBoolean, ReportConstants.VideoEndType paramVideoEndType)
  {
    if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager$VideoPlayParam != null) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager$VideoPlayParam.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoIVideoUIDelegate != null)) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager$VideoPlayParam.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoIVideoUIDelegate.f(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager$VideoPlayParam);
    }
    if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager$VideoPlayParam != null) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecommendManager != null) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager$VideoPlayParam.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayerWrapper != null)) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecommendManager.a(1, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager$VideoPlayParam.jdField_a_of_type_ComTencentBizPubaccountVideoInfo, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager$VideoPlayParam.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayerWrapper.a(this.jdField_c_of_type_Boolean));
    }
    if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager$VideoPlayParam != null) && (a() != null))
    {
      a(paramBoolean, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager$VideoPlayParam, paramVideoEndType);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager$VideoPlayParam.jdField_a_of_type_Boolean = false;
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager$VideoPlayParam.jdField_a_of_type_JavaLangString = null;
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager$VideoPlayParam.jdField_c_of_type_Boolean = false;
      if (this.jdField_a_of_type_JavaUtilArrayList != null)
      {
        paramVideoEndType = this.jdField_a_of_type_JavaUtilArrayList.iterator();
        while (paramVideoEndType.hasNext()) {
          ((VideoFeedsPlayManager.VideoStatusListener)paramVideoEndType.next()).a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager$VideoPlayParam, this.jdField_c_of_type_Boolean);
        }
      }
      VideoResumeManager.a.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager$VideoPlayParam.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_g_of_type_JavaLangString, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager$VideoPlayParam.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_JavaLangString, a(), d());
      c(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager$VideoPlayParam);
    }
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager$VideoPlayParam != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager$VideoPlayParam = null;
    }
    this.jdField_b_of_type_Int = 0;
    this.jdField_d_of_type_Boolean = false;
    this.jdField_a_of_type_AndroidOsHandler.removeMessages(-2);
  }
  
  public boolean a()
  {
    return this.jdField_l_of_type_Boolean;
  }
  
  public long b()
  {
    if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager$VideoPlayParam != null) && (a() != null)) {
      return a().a(g());
    }
    return 0L;
  }
  
  public void b()
  {
    Object localObject = a();
    if ((localObject != null) && (!((VideoPlayerWrapper)localObject).q()) && (((VideoPlayerWrapper)localObject).f())) {}
    for (int i1 = 1; (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager$VideoPlayParam != null) && (i1 != 0); i1 = 0)
    {
      a().f();
      if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager$VideoPlayParam.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoIVideoUIDelegate != null) {
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager$VideoPlayParam.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoIVideoUIDelegate.d(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager$VideoPlayParam);
      }
      if (this.jdField_a_of_type_JavaUtilArrayList == null) {
        break;
      }
      localObject = this.jdField_a_of_type_JavaUtilArrayList.iterator();
      while (((Iterator)localObject).hasNext()) {
        ((VideoFeedsPlayManager.VideoStatusListener)((Iterator)localObject).next()).c(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager$VideoPlayParam);
      }
    }
    boolean bool;
    label219:
    ReadinjoyAdVideoReportData localReadinjoyAdVideoReportData;
    AdvertisementInfo localAdvertisementInfo;
    int i5;
    int i6;
    label340:
    int i2;
    label350:
    int i3;
    label363:
    int i4;
    label374:
    int i7;
    int i8;
    if ((h()) && (a() != null))
    {
      if (a().e() != 0L) {
        break label485;
      }
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager$VideoPlayParam.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructReadinjoyAdVideoReportData.jdField_d_of_type_Int = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager$VideoPlayParam.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructReadinjoyAdVideoReportData.e;
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager$VideoPlayParam.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructReadinjoyAdVideoReportData.e = ((int)a().c(this.jdField_c_of_type_Boolean));
      localObject = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager$VideoPlayParam.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructReadinjoyAdVideoReportData;
      if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager$VideoPlayParam.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructReadinjoyAdVideoReportData.jdField_d_of_type_Int != 0) {
        break label506;
      }
      bool = true;
      ((ReadinjoyAdVideoReportData)localObject).jdField_b_of_type_Boolean = bool;
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager$VideoPlayParam.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructReadinjoyAdVideoReportData.jdField_c_of_type_Boolean = this.jdField_c_of_type_Boolean;
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager$VideoPlayParam.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructReadinjoyAdVideoReportData.jdField_h_of_type_Int = ((int)a().b());
      localReadinjoyAdVideoReportData = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager$VideoPlayParam.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructReadinjoyAdVideoReportData;
      VideoReporter.a(localReadinjoyAdVideoReportData.jdField_a_of_type_Boolean, localReadinjoyAdVideoReportData.jdField_d_of_type_Int, localReadinjoyAdVideoReportData.e, localReadinjoyAdVideoReportData.jdField_b_of_type_Boolean, localReadinjoyAdVideoReportData.jdField_c_of_type_Boolean, localReadinjoyAdVideoReportData.f);
      localAdvertisementInfo = NativeAdUtils.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager$VideoPlayParam.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_ComTencentBizPubaccountVideoAdInfo);
      i5 = localReadinjoyAdVideoReportData.jdField_d_of_type_Int;
      i6 = localReadinjoyAdVideoReportData.e;
      if (!localReadinjoyAdVideoReportData.jdField_b_of_type_Boolean) {
        break label512;
      }
      i1 = 1;
      if (!localReadinjoyAdVideoReportData.jdField_c_of_type_Boolean) {
        break label517;
      }
      i2 = 1;
      if (!ReadInJoyAdUtils.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager$VideoPlayParam)) {
        break label522;
      }
      i3 = 20;
      if (!localReadinjoyAdVideoReportData.jdField_a_of_type_Boolean) {
        break label527;
      }
      i4 = 1;
      i7 = localReadinjoyAdVideoReportData.jdField_h_of_type_Int;
      i8 = localReadinjoyAdVideoReportData.jdField_i_of_type_Int;
      if (this.jdField_a_of_type_ComTencentBizPubaccountNativeAdReportConstantReportConstants$VideoEndType == null) {
        break label533;
      }
    }
    label512:
    label517:
    label522:
    label527:
    label533:
    for (localObject = this.jdField_a_of_type_ComTencentBizPubaccountNativeAdReportConstantReportConstants$VideoEndType;; localObject = ReportConstants.VideoEndType.CLICK_PAUSE)
    {
      localObject = NativeAdUtils.a(i5, i6, i1, i2, i3, i4, i7, 2, 0, i8, (ReportConstants.VideoEndType)localObject, true);
      NativeAdUtils.a(new AdReportData().a(this.jdField_a_of_type_AndroidContentContext).a(6).b(localReadinjoyAdVideoReportData.jdField_g_of_type_Int).a(localAdvertisementInfo).a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager$VideoPlayParam.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_ComTencentBizPubaccountVideoAdInfo).a((JSONObject)localObject));
      ReadInJoyAdUtils.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager$VideoPlayParam);
      return;
      label485:
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager$VideoPlayParam.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructReadinjoyAdVideoReportData.jdField_d_of_type_Int = ((int)a().e());
      break;
      label506:
      bool = false;
      break label219;
      i1 = 0;
      break label340;
      i2 = 0;
      break label350;
      i3 = 0;
      break label363;
      i4 = 2;
      break label374;
    }
  }
  
  public void b(ReportConstants.VideoEndType paramVideoEndType)
  {
    a(true, paramVideoEndType);
  }
  
  public void b(VideoFeedsPlayManager.VideoPlayParam paramVideoPlayParam)
  {
    if (QLog.isColorLevel()) {
      QLog.d("VideoFeedsPlayManager.preplay", 2, "VideoFeedsPlayManager prePlayVideo mPreplaying=" + this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager$VideoPlayParam + ", player=" + b(this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager$VideoPlayParam));
    }
    if ((paramVideoPlayParam == null) || (paramVideoPlayParam == this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager$VideoPlayParam)) {}
    do
    {
      VideoPlayerWrapper localVideoPlayerWrapper;
      do
      {
        return;
        localVideoPlayerWrapper = b(paramVideoPlayParam);
      } while ((localVideoPlayerWrapper != null) && (paramVideoPlayParam.jdField_a_of_type_Boolean) && (localVideoPlayerWrapper.a() == paramVideoPlayParam.jdField_a_of_type_ComTencentBizPubaccountVideoInfo));
      if (b(this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager$VideoPlayParam) != null)
      {
        if (QLog.isColorLevel()) {
          QLog.d("Q.pubaccount.video.feeds.VideoFeedsPlayManager", 2, "prePlayVideo: last preplay video not stop");
        }
        b(this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager$VideoPlayParam).b(true);
      }
      this.jdField_a_of_type_JavaLangString = null;
    } while ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPluginInstall == null) || (!this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPluginInstall.a()));
    paramVideoPlayParam.jdField_a_of_type_Boolean = true;
    this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager$VideoPlayParam = paramVideoPlayParam;
    d(this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager$VideoPlayParam);
    paramVideoPlayParam.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructReadinjoyVideoReportData.jdField_c_of_type_Long = SystemClock.uptimeMillis();
    b(paramVideoPlayParam, true);
  }
  
  public void b(boolean paramBoolean)
  {
    this.jdField_l_of_type_Boolean = paramBoolean;
  }
  
  public boolean b()
  {
    return (a() != null) && (a().e());
  }
  
  public long c()
  {
    if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager$VideoPlayParam != null) && (a() != null)) {
      return a().b(g());
    }
    return 0L;
  }
  
  public void c()
  {
    this.jdField_a_of_type_AndroidOsHandler.post(new VideoFeedsPlayManager.6(this));
  }
  
  @Deprecated
  public void c(VideoFeedsPlayManager.VideoPlayParam paramVideoPlayParam)
  {
    if (paramVideoPlayParam != null) {
      a(paramVideoPlayParam.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayerWrapper);
    }
  }
  
  public void c(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_Boolean != paramBoolean)
    {
      this.jdField_a_of_type_Boolean = paramBoolean;
      if ((a() != null) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager$VideoPlayParam != null)) {
        if (!this.jdField_a_of_type_Boolean) {
          break label45;
        }
      }
    }
    label45:
    for (int i1 = 2;; i1 = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager$VideoPlayParam.jdField_a_of_type_Int)
    {
      a().b(i1);
      return;
    }
  }
  
  public boolean c()
  {
    return (a() != null) && (a().l());
  }
  
  public long d()
  {
    if (a() != null) {
      return a().b();
    }
    return 0L;
  }
  
  public void d()
  {
    boolean bool2 = true;
    this.jdField_a_of_type_ComTencentBizPubaccountNativeAdReportConstantReportConstants$VideoEndType = null;
    this.jdField_f_of_type_Boolean = true;
    if ((this.k) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager$VideoPlayParam != null)) {
      a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager$VideoPlayParam, false);
    }
    label155:
    label158:
    for (;;)
    {
      this.k = false;
      this.jdField_l_of_type_Boolean = false;
      this.n = false;
      VideoBehaviorsReporter localVideoBehaviorsReporter = VideoBehaviorsReporter.a();
      if (!VideoAutoPlayController.a().c())
      {
        bool1 = bool2;
        label65:
        localVideoBehaviorsReporter.b(bool1);
        BandwidthPredictor.a().a(this.jdField_a_of_type_AndroidContentContext);
        return;
        if ((this.n) && (a() != null) && (a().d()))
        {
          a();
          continue;
        }
        if (!this.jdField_l_of_type_Boolean) {
          continue;
        }
        if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null) {
          break label155;
        }
      }
      for (boolean bool1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.isVideoChatting();; bool1 = false)
      {
        if (bool1) {
          break label158;
        }
        this.m = true;
        c();
        break;
        bool1 = false;
        break label65;
      }
    }
  }
  
  public void d(boolean paramBoolean)
  {
    this.jdField_i_of_type_Boolean = paramBoolean;
    if (a() != null) {
      a().c(paramBoolean);
    }
    if (b(this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager$VideoPlayParam) != null) {
      b(this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager$VideoPlayParam).c(paramBoolean);
    }
  }
  
  public boolean d()
  {
    return (a() != null) && (a().f());
  }
  
  public void e()
  {
    this.jdField_f_of_type_Boolean = false;
    if (QLog.isColorLevel()) {
      QLog.d("Q.pubaccount.video.feeds.VideoFeedsPlayManager", 2, "doOnPause() isPlaying()=" + d());
    }
    if (d())
    {
      this.jdField_l_of_type_Boolean = true;
      this.m = false;
      b();
    }
    BandwidthPredictor.a().b(this.jdField_a_of_type_AndroidContentContext);
  }
  
  public void e(boolean paramBoolean)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoAutoPlayController.b(paramBoolean);
  }
  
  public boolean e()
  {
    return a() == 5;
  }
  
  public void f()
  {
    if (QLog.isColorLevel()) {
      QLog.d("VideoFeedsPlayManager.preplay", 2, "doOnDestory: ");
    }
    jdField_a_of_type_JavaUtilList.remove(this);
    this.jdField_b_of_type_Boolean = true;
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPreDownloadMgr != null)
    {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPreDownloadMgr.a();
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPreDownloadMgr = null;
    }
    b(ReportConstants.VideoEndType.EXIT_SCENE);
    this.jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager$VideoPlayParam);
    this.jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager$VideoPlayParam);
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager$VideoPlayParam != null)
    {
      if (a() != null)
      {
        a().l();
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager$VideoPlayParam.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayerWrapper = null;
      }
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager$VideoPlayParam = null;
    }
    if (this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager$VideoPlayParam != null)
    {
      if (b(this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager$VideoPlayParam) != null)
      {
        b(this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager$VideoPlayParam).l();
        this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager$VideoPlayParam.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayerWrapper = null;
      }
      this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager$VideoPlayParam = null;
    }
    if (this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap != null)
    {
      Iterator localIterator = this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.keySet().iterator();
      while (localIterator.hasNext())
      {
        VideoPlayerWrapper localVideoPlayerWrapper = (VideoPlayerWrapper)localIterator.next();
        if ((localVideoPlayerWrapper != null) && (!localVideoPlayerWrapper.i())) {
          localVideoPlayerWrapper.l();
        }
      }
      this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.clear();
    }
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPluginInstall != null)
    {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPluginInstall.b();
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPluginInstall = null;
    }
    this.jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
    if (this.jdField_a_of_type_JavaUtilArrayList != null)
    {
      this.jdField_a_of_type_JavaUtilArrayList.clear();
      this.jdField_a_of_type_JavaUtilArrayList = null;
    }
    VideoVolumeController.a().b(this);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager$VideoPlayProgressListener = null;
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecommendManager = null;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = null;
    this.jdField_a_of_type_AndroidContentContext = null;
  }
  
  public void f(boolean paramBoolean)
  {
    this.jdField_g_of_type_Boolean = paramBoolean;
    if (a() != null) {
      a().d(paramBoolean);
    }
    if (b(this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager$VideoPlayParam) != null) {
      b(this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager$VideoPlayParam).d(paramBoolean);
    }
  }
  
  public boolean f()
  {
    return a() == 3;
  }
  
  void g()
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.pubaccount.video.feeds.VideoFeedsPlayManager", 2, "checkPlayStateAfterPhoneCall mIsActivityOnResume = " + this.jdField_f_of_type_Boolean);
    }
    if (!this.jdField_f_of_type_Boolean) {}
    while ((!b()) || (!a())) {
      return;
    }
    b(false);
    c();
  }
  
  public void g(boolean paramBoolean)
  {
    boolean bool2 = false;
    this.o = paramBoolean;
    VideoPlayerWrapper localVideoPlayerWrapper;
    if (a() != null)
    {
      localVideoPlayerWrapper = a();
      if ((!paramBoolean) && (!this.jdField_g_of_type_Boolean)) {
        break label82;
      }
    }
    label82:
    for (boolean bool1 = true;; bool1 = false)
    {
      localVideoPlayerWrapper.d(bool1);
      if (b(this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager$VideoPlayParam) != null)
      {
        localVideoPlayerWrapper = b(this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager$VideoPlayParam);
        if (!paramBoolean)
        {
          paramBoolean = bool2;
          if (!this.jdField_g_of_type_Boolean) {}
        }
        else
        {
          paramBoolean = true;
        }
        localVideoPlayerWrapper.d(paramBoolean);
      }
      return;
    }
  }
  
  public boolean g()
  {
    return a() == 7;
  }
  
  public void onHeadsetStateChanged(boolean paramBoolean)
  {
    VideoPlayerWrapper localVideoPlayerWrapper;
    if (a() != null)
    {
      localVideoPlayerWrapper = a();
      if (paramBoolean) {
        break label24;
      }
    }
    label24:
    for (paramBoolean = true;; paramBoolean = false)
    {
      localVideoPlayerWrapper.c(paramBoolean);
      return;
    }
  }
  
  public void onPhoneCome()
  {
    if (a() != null) {
      a().f();
    }
  }
  
  public void onSystemVolumeChanged(int paramInt)
  {
    VideoPlayerWrapper localVideoPlayerWrapper;
    if (a() != null)
    {
      localVideoPlayerWrapper = a();
      if (paramInt > 0) {
        break label24;
      }
    }
    label24:
    for (boolean bool = true;; bool = false)
    {
      localVideoPlayerWrapper.c(bool);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsPlayManager
 * JD-Core Version:    0.7.0.1
 */