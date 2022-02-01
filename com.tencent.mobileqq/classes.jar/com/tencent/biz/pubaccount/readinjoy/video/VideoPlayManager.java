package com.tencent.biz.pubaccount.readinjoy.video;

import android.app.Activity;
import android.graphics.Bitmap;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.text.TextUtils;
import android.view.View;
import com.tencent.biz.pubaccount.NativeAd.report.VideoAdClickRecorder;
import com.tencent.biz.pubaccount.NativeAd.report.constant.ReportConstants.VideoEndType;
import com.tencent.biz.pubaccount.NativeAd.util.NativeAdUtils;
import com.tencent.biz.pubaccount.QualityReporter;
import com.tencent.biz.pubaccount.readinjoy.common.ReadInJoyUtils;
import com.tencent.biz.pubaccount.readinjoy.decoupling.accesslayer.util.RIJQQAppInterfaceUtil;
import com.tencent.biz.pubaccount.readinjoy.decoupling.uilayer.framewrok.report.RIJStatisticCollectorReport;
import com.tencent.biz.pubaccount.readinjoy.struct.AdvertisementInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.BaseArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.ReadinjoyVideoReportData;
import com.tencent.biz.pubaccount.readinjoy.video.bandwidth.BandwidthPredictor;
import com.tencent.biz.pubaccount.readinjoy.video.bandwidth.VideoBufferRangeController;
import com.tencent.biz.pubaccount.readinjoy.video.player.wrapper.IVideoView;
import com.tencent.biz.pubaccount.readinjoy.video.report.VideoDTReport;
import com.tencent.biz.pubaccount.readinjoy.video.report.VideoDTReport.Builder;
import com.tencent.biz.pubaccount.readinjoy.video.videourl.ThirdVideoManager;
import com.tencent.biz.pubaccount.readinjoy.view.VideoViewGroup;
import com.tencent.biz.pubaccount.readinjoyAd.ad.data.AdReportData;
import com.tencent.biz.pubaccount.readinjoyAd.ad.utils.ReadInJoyAdUtils;
import com.tencent.biz.pubaccount.util.api.IPublicAccountUtil;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.PublicAccountDataManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.gesturelock.GesturePWDUtils;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.Pair;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicInteger;

public class VideoPlayManager
  implements IVideoPlayManager, VideoPluginInstall.OnVideoPluginInstallListener
{
  public static final String a;
  protected int a;
  private volatile Activity jdField_a_of_type_AndroidAppActivity;
  private Handler jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper());
  private ReportConstants.VideoEndType jdField_a_of_type_ComTencentBizPubaccountNativeAdReportConstantReportConstants$VideoEndType = ReportConstants.VideoEndType.CLICK_PAUSE;
  private VideoAutoPlayController jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoAutoPlayController;
  private VideoPlayManager.PlayListenerAdapter jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager$PlayListenerAdapter = new VideoPlayManager.PlayListenerAdapter(this);
  public VideoPlayManager.VideoPlayParam a;
  private VideoPlayerWrapper jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayerWrapper;
  private VideoPluginInstall jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPluginInstall;
  private VideoPreDownloadMgr jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPreDownloadMgr;
  private VideoRecommendManager jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoRecommendManager;
  private VideoUIManager jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoUIManager;
  private ArrayList<Pair<Integer, Bitmap>> jdField_a_of_type_JavaUtilArrayList;
  private HashMap<Integer, VideoPlayerWrapper> jdField_a_of_type_JavaUtilHashMap;
  private Map<String, WeakReference<VideoPlayerWrapper>> jdField_a_of_type_JavaUtilMap;
  private Set<VideoPlayManager.VideoStatusListener> jdField_a_of_type_JavaUtilSet = null;
  private CopyOnWriteArrayList<VideoPlayManager.OnPlayStateListener> jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList;
  private AtomicInteger jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger = new AtomicInteger(0);
  private boolean jdField_a_of_type_Boolean = false;
  private int jdField_b_of_type_Int = 1;
  private VideoPlayManager.VideoPlayParam jdField_b_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager$VideoPlayParam = null;
  private String jdField_b_of_type_JavaLangString;
  private boolean jdField_b_of_type_Boolean;
  private VideoPlayManager.VideoPlayParam jdField_c_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager$VideoPlayParam = null;
  private boolean jdField_c_of_type_Boolean = true;
  private VideoPlayManager.VideoPlayParam jdField_d_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager$VideoPlayParam = null;
  private volatile boolean jdField_d_of_type_Boolean;
  private boolean e;
  private boolean f = false;
  
  static
  {
    jdField_a_of_type_JavaLangString = "Q.readinjoy.video." + VideoPlayManager.class.getSimpleName();
  }
  
  public VideoPlayManager(Activity paramActivity)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager$VideoPlayParam = null;
    if (QLog.isColorLevel()) {
      QLog.d("Q.readinjoy.video", 2, "VideoPlayManager : create a new manager !");
    }
    this.jdField_a_of_type_AndroidAppActivity = paramActivity;
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPluginInstall = new VideoPluginInstall();
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPluginInstall.a(this);
    this.jdField_a_of_type_JavaUtilHashMap = new HashMap();
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
    this.jdField_a_of_type_JavaUtilMap = new HashMap();
    this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList = new CopyOnWriteArrayList();
    VideoVolumeControl.a().a(this);
  }
  
  private ReportConstants.VideoEndType a()
  {
    if ((this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager$VideoPlayParam != null) && ((this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager$VideoPlayParam.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo instanceof AdvertisementInfo)) && (VideoAdClickRecorder.a((AdvertisementInfo)this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager$VideoPlayParam.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo))) {
      return ReportConstants.VideoEndType.AD_AREA_CLICK;
    }
    return this.jdField_a_of_type_ComTencentBizPubaccountNativeAdReportConstantReportConstants$VideoEndType;
  }
  
  private void a(VideoPlayManager.VideoPlayParam paramVideoPlayParam)
  {
    paramVideoPlayParam.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructReadinjoyVideoReportData.jdField_t_of_type_Long = BandwidthPredictor.a().a();
    paramVideoPlayParam.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructReadinjoyVideoReportData.jdField_m_of_type_JavaLangString = VideoBufferRangeController.a().a();
  }
  
  private void a(VideoPlayManager.VideoPlayParam paramVideoPlayParam, long paramLong)
  {
    Object localObject = paramVideoPlayParam.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo;
    if ((localObject != null) && (ReadInJoyAdUtils.a((int)((BaseArticleInfo)localObject).mChannelID)) && (AdvertisementInfo.isAdvertisementInfo((BaseArticleInfo)localObject)) && (paramVideoPlayParam.jdField_b_of_type_Boolean))
    {
      int i = (int)paramLong;
      NativeAdUtils.a(new AdReportData().a(this.jdField_a_of_type_AndroidAppActivity).a(6).b(11).a((AdvertisementInfo)localObject).a(NativeAdUtils.a(((AdvertisementInfo)localObject).adbt, i, ((AdvertisementInfo)localObject).getAdbf(), 1, ((AdvertisementInfo)localObject).adpa, ((AdvertisementInfo)localObject).adpb, ((BaseArticleInfo)localObject).mVideoDuration * 1000, 1, 0, ((AdvertisementInfo)localObject).videoReplayCount, ReportConstants.VideoEndType.NORMAL_COMPLETE, ((AdvertisementInfo)localObject).isClickReplay, false)));
      ((AdvertisementInfo)localObject).isClickReplay = false;
      localObject = (AdvertisementInfo)localObject;
      ((AdvertisementInfo)localObject).videoReplayCount += 1;
    }
    paramVideoPlayParam = paramVideoPlayParam.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo;
    if ((paramVideoPlayParam != null) && (paramVideoPlayParam.mChannelID == 56L) && (AdvertisementInfo.isAdvertisementInfo(paramVideoPlayParam)))
    {
      NativeAdUtils.a(new AdReportData().a(this.jdField_a_of_type_AndroidAppActivity).a(6).b(4).a((AdvertisementInfo)paramVideoPlayParam).a(NativeAdUtils.a(((AdvertisementInfo)paramVideoPlayParam).adbt, paramVideoPlayParam.mVideoDuration * 1000, ((AdvertisementInfo)paramVideoPlayParam).getAdbf(), 1, ((AdvertisementInfo)paramVideoPlayParam).adpa, ((AdvertisementInfo)paramVideoPlayParam).adpb, paramVideoPlayParam.mVideoDuration * 1000, 9, 0, ((AdvertisementInfo)paramVideoPlayParam).videoReplayCount, ReportConstants.VideoEndType.NORMAL_COMPLETE, ((AdvertisementInfo)paramVideoPlayParam).isClickReplay, false)));
      ((AdvertisementInfo)paramVideoPlayParam).isClickReplay = false;
      paramVideoPlayParam = (AdvertisementInfo)paramVideoPlayParam;
      paramVideoPlayParam.videoReplayCount += 1;
    }
  }
  
  private void a(VideoPlayManager.VideoPlayParam paramVideoPlayParam, VideoPlayerWrapper paramVideoPlayerWrapper, int paramInt, Object paramObject)
  {
    int i;
    try
    {
      i = this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.get();
      if (paramInt != i)
      {
        if (QLog.isColorLevel()) {
          QLog.d(jdField_a_of_type_JavaLangString, 2, "changeStateAndNotify(): " + VideoPlayUtils.a(this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.get()) + " ===> " + VideoPlayUtils.a(paramInt) + ", extra = " + paramObject + ", videoPlayParam=" + paramVideoPlayParam + ", videoPlayWrapper=" + paramVideoPlayerWrapper);
        }
        this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.set(paramInt);
        if (Thread.currentThread() != Looper.getMainLooper().getThread()) {
          break label197;
        }
        if (this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList != null)
        {
          Iterator localIterator = this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.iterator();
          while (localIterator.hasNext())
          {
            VideoPlayManager.OnPlayStateListener localOnPlayStateListener = (VideoPlayManager.OnPlayStateListener)localIterator.next();
            if (localOnPlayStateListener != null) {
              localOnPlayStateListener.a(paramVideoPlayParam, paramVideoPlayerWrapper, i, paramInt, paramObject);
            }
          }
        }
        b(paramInt, false);
      }
    }
    finally {}
    for (;;)
    {
      return;
      label197:
      this.jdField_a_of_type_AndroidOsHandler.post(new VideoPlayManager.7(this, paramVideoPlayParam, paramVideoPlayerWrapper, i, paramInt, paramObject));
    }
  }
  
  private void a(VideoPlayerWrapper paramVideoPlayerWrapper)
  {
    if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayerWrapper == null) || (this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager$VideoPlayParam == null))
    {
      QLog.e("Q.readinjoy.video", 1, "onCompletion return for mVideoPlayerWrapper || mCurrenPlayVideoParam is null");
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("Q.readinjoy.video", 2, "video play completion!");
    }
    long l = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayerWrapper.a(true);
    this.jdField_d_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager$VideoPlayParam = this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager$VideoPlayParam;
    this.jdField_c_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager$VideoPlayParam = this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager$VideoPlayParam;
    VideoPlayManager.VideoPlayParam localVideoPlayParam = this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager$VideoPlayParam;
    VideoRecommendManager localVideoRecommendManager = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoRecommendManager;
    localVideoPlayParam.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructReadinjoyVideoReportData.jdField_a_of_type_Long = l;
    localVideoPlayParam.jdField_d_of_type_Long = a();
    if ((localVideoPlayParam.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructReadinjoyVideoReportData.jdField_a_of_type_Long == 0L) && (localVideoPlayParam.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructReadinjoyVideoReportData.jdField_d_of_type_Long == 0L) && (localVideoPlayParam.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructReadinjoyVideoReportData.jdField_b_of_type_Long != 0L)) {
      localVideoPlayParam.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructReadinjoyVideoReportData.jdField_d_of_type_Long = (SystemClock.uptimeMillis() - localVideoPlayParam.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructReadinjoyVideoReportData.jdField_b_of_type_Long);
    }
    localVideoPlayParam.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructReadinjoyVideoReportData.jdField_a_of_type_Float = ((float)localVideoPlayParam.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructReadinjoyVideoReportData.jdField_a_of_type_Long / localVideoPlayParam.jdField_b_of_type_Int);
    localVideoPlayParam.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructReadinjoyVideoReportData.jdField_a_of_type_Boolean = true;
    localVideoPlayParam.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructReadinjoyVideoReportData.jdField_b_of_type_Boolean = true;
    localVideoPlayParam.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructReadinjoyVideoReportData.jdField_n_of_type_Long = paramVideoPlayerWrapper.c();
    localVideoPlayParam.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructReadinjoyVideoReportData.jdField_g_of_type_Int = paramVideoPlayerWrapper.e();
    localVideoPlayParam.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructReadinjoyVideoReportData.jdField_h_of_type_Int = paramVideoPlayerWrapper.f();
    localVideoPlayParam.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructReadinjoyVideoReportData.jdField_c_of_type_Boolean = paramVideoPlayerWrapper.jdField_b_of_type_Boolean;
    localVideoPlayParam.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructReadinjoyVideoReportData.jdField_q_of_type_Long = paramVideoPlayerWrapper.jdField_b_of_type_Long;
    localVideoPlayParam.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructReadinjoyVideoReportData.jdField_p_of_type_Long = paramVideoPlayerWrapper.jdField_a_of_type_Long;
    localVideoPlayParam.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructReadinjoyVideoReportData.jdField_r_of_type_Long = paramVideoPlayerWrapper.g();
    localVideoPlayParam.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructReadinjoyVideoReportData.jdField_m_of_type_Int = c();
    localVideoPlayParam.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructReadinjoyVideoReportData.jdField_n_of_type_Int = d();
    ReadinjoyVideoReportData localReadinjoyVideoReportData;
    int i;
    int j;
    boolean bool;
    if (this.jdField_c_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager$VideoPlayParam != null)
    {
      localReadinjoyVideoReportData = localVideoPlayParam.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructReadinjoyVideoReportData;
      i = this.jdField_c_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager$VideoPlayParam.jdField_a_of_type_Int;
      j = localVideoPlayParam.jdField_a_of_type_Int;
      if (localVideoPlayParam.jdField_m_of_type_Int == 3) {
        bool = true;
      }
    }
    for (localReadinjoyVideoReportData.jdField_t_of_type_Int = ReadInJoyUtils.a(i, j, bool);; localVideoPlayParam.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructReadinjoyVideoReportData.jdField_t_of_type_Int = -1)
    {
      localVideoPlayParam.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructReadinjoyVideoReportData.jdField_d_of_type_Int = localVideoPlayParam.jdField_m_of_type_Int;
      localVideoPlayParam.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructReadinjoyVideoReportData.l = paramVideoPlayerWrapper.p();
      a(localVideoPlayParam);
      paramVideoPlayerWrapper.a(localVideoPlayParam.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructReadinjoyVideoReportData.b());
      RIJStatisticCollectorReport.a(this.jdField_a_of_type_AndroidAppActivity.getApplicationContext(), ReadInJoyUtils.a(), true, localVideoPlayParam.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructReadinjoyVideoReportData.a());
      QualityReporter.a(localVideoPlayParam.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructReadinjoyVideoReportData);
      RIJStatisticCollectorReport.a(true, localVideoPlayParam.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructReadinjoyVideoReportData.jdField_d_of_type_Boolean, localVideoPlayParam.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructReadinjoyVideoReportData.jdField_h_of_type_Int, localVideoPlayParam.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructReadinjoyVideoReportData.jdField_a_of_type_Int, localVideoPlayParam.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructReadinjoyVideoReportData.jdField_d_of_type_Long, 56, localVideoPlayParam.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructReadinjoyVideoReportData.jdField_c_of_type_JavaLangString, localVideoPlayParam.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructReadinjoyVideoReportData.jdField_a_of_type_JavaLangString);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayerWrapper.b();
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayerWrapper.a();
      if (localVideoPlayParam.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructReadinjoyVideoReportData.jdField_a_of_type_Long > 0L) {
        ThreadManager.post(new VideoPlayManager.3(this, localVideoPlayParam, localVideoRecommendManager), 5, null, true);
      }
      ReportController.b(null, "dc00899", "Pb_account_lifeservice", "", "0X800709B", "0X800709B", 0, 0, "", "", "", localVideoPlayParam.jdField_c_of_type_JavaLangString);
      a(localVideoPlayParam, l);
      a(paramVideoPlayerWrapper, localVideoPlayParam);
      this.jdField_a_of_type_AndroidOsHandler.post(new VideoPlayManager.4(this));
      return;
      bool = false;
      break;
    }
  }
  
  private void a(VideoPlayerWrapper paramVideoPlayerWrapper, VideoPlayManager.VideoPlayParam paramVideoPlayParam)
  {
    VideoDTReport.a(paramVideoPlayerWrapper);
  }
  
  private void a(VideoPlayerWrapper paramVideoPlayerWrapper, VideoPlayManager.VideoPlayParam paramVideoPlayParam, boolean paramBoolean)
  {
    int j = 2;
    if (AdvertisementInfo.isAdvertisementInfo(paramVideoPlayParam.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo))
    {
      i = 1;
      paramVideoPlayParam = VideoDTReport.Builder.a(paramVideoPlayParam).a("14").b(i).a(paramVideoPlayParam.jdField_a_of_type_Int).b(paramVideoPlayerWrapper.b()).d(paramVideoPlayerWrapper.a());
      if (!paramBoolean) {
        break label88;
      }
    }
    label88:
    for (int i = j;; i = 1)
    {
      paramVideoPlayParam = paramVideoPlayParam.c(i).d(1);
      VideoDTReport.a(this.jdField_a_of_type_AndroidAppActivity, paramVideoPlayerWrapper, paramVideoPlayParam);
      return;
      i = 2;
      break;
    }
  }
  
  private void a(VideoPlayerWrapper paramVideoPlayerWrapper, Object paramObject)
  {
    long l = 0L;
    paramObject = this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager$VideoPlayParam;
    if (QLog.isColorLevel()) {
      QLog.d("Q.readinjoy.video", 2, "onVideoPrepared() mIsOpenedVideo=" + this.jdField_a_of_type_Boolean + "   mVisable:" + this.jdField_d_of_type_Boolean);
    }
    if (!this.jdField_a_of_type_Boolean) {}
    do
    {
      return;
      this.jdField_a_of_type_Boolean = false;
      if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayerWrapper == paramVideoPlayerWrapper) && (paramObject != null))
      {
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPreDownloadMgr.a(paramObject.jdField_a_of_type_Int, true);
        if ((paramObject.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructReadinjoyVideoReportData != null) && (paramObject.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructReadinjoyVideoReportData.jdField_d_of_type_Long == 0L))
        {
          paramObject.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructReadinjoyVideoReportData.jdField_d_of_type_Long = (SystemClock.uptimeMillis() - paramObject.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructReadinjoyVideoReportData.jdField_b_of_type_Long);
          ReadinjoyVideoReportData localReadinjoyVideoReportData = paramObject.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructReadinjoyVideoReportData;
          localReadinjoyVideoReportData.f += paramObject.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructReadinjoyVideoReportData.jdField_d_of_type_Long;
          localReadinjoyVideoReportData = paramObject.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructReadinjoyVideoReportData;
          localReadinjoyVideoReportData.jdField_c_of_type_Int += 1;
          if ((paramObject.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructReadinjoyVideoReportData != null) && (QLog.isColorLevel())) {
            QLog.d("Q.readinjoy.video", 2, "video player ready. from open. prepare cost : " + paramObject.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructReadinjoyVideoReportData.jdField_d_of_type_Long);
          }
        }
        a(paramObject, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayerWrapper, 2, null);
        if ((VideoVolumeControl.a(this.jdField_a_of_type_AndroidAppActivity)) || (!GesturePWDUtils.isAppOnForeground(this.jdField_a_of_type_AndroidAppActivity)) || (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoAutoPlayController == null))
        {
          if (QLog.isColorLevel()) {
            QLog.d("Q.readinjoy.video", 2, "onVideoPrepared start,in call stop.background:" + GesturePWDUtils.isAppOnForeground(this.jdField_a_of_type_AndroidAppActivity));
          }
          this.jdField_a_of_type_AndroidOsHandler.post(new VideoPlayManager.1(this));
        }
        for (;;)
        {
          paramVideoPlayerWrapper = new StringBuilder().append(HardCodeUtil.a(2131716155)).append(paramVideoPlayerWrapper.jdField_b_of_type_Boolean).append(HardCodeUtil.a(2131716172));
          if (paramObject.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructReadinjoyVideoReportData != null) {
            l = paramObject.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructReadinjoyVideoReportData.jdField_d_of_type_Long;
          }
          paramVideoPlayerWrapper = l;
          if (!QLog.isColorLevel()) {
            break;
          }
          QLog.d("Q.readinjoy.video", 2, paramVideoPlayerWrapper);
          return;
          paramVideoPlayerWrapper.d();
          a(paramObject, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayerWrapper, 3, null);
          a(paramVideoPlayerWrapper, paramObject, false);
        }
      }
    } while (!QLog.isColorLevel());
    QLog.w("Q.readinjoy.video", 2, "video player ready,but has error!");
  }
  
  private void a(boolean paramBoolean, Activity paramActivity, VideoPlayManager.VideoPlayParam paramVideoPlayParam, int paramInt)
  {
    BaseArticleInfo localBaseArticleInfo = paramVideoPlayParam.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo;
    if ((localBaseArticleInfo != null) && (localBaseArticleInfo.mChannelID == 56L) && (AdvertisementInfo.isAdvertisementInfo(localBaseArticleInfo)))
    {
      NativeAdUtils.a(new AdReportData().a(paramActivity).a(6).b(4).a((AdvertisementInfo)localBaseArticleInfo).a(NativeAdUtils.a(((AdvertisementInfo)localBaseArticleInfo).adbt, (int)paramVideoPlayParam.jdField_d_of_type_Long, ((AdvertisementInfo)localBaseArticleInfo).getAdbf(), 0, ((AdvertisementInfo)localBaseArticleInfo).adpa, ((AdvertisementInfo)localBaseArticleInfo).adpb, localBaseArticleInfo.mVideoDuration * 1000, 9, 0, ((AdvertisementInfo)localBaseArticleInfo).videoReplayCount, a(), ((AdvertisementInfo)localBaseArticleInfo).isClickReplay, false)));
      ((AdvertisementInfo)localBaseArticleInfo).isClickReplay = false;
    }
    if ((!paramBoolean) && (localBaseArticleInfo != null) && (ReadInJoyAdUtils.a((int)localBaseArticleInfo.mChannelID)) && (AdvertisementInfo.isAdvertisementInfo(localBaseArticleInfo)) && (paramVideoPlayParam.jdField_b_of_type_Boolean))
    {
      NativeAdUtils.a(new AdReportData().a(paramActivity).a(6).b(11).a((AdvertisementInfo)localBaseArticleInfo).a(NativeAdUtils.a(((AdvertisementInfo)localBaseArticleInfo).adbt, (int)paramVideoPlayParam.jdField_d_of_type_Long, ((AdvertisementInfo)localBaseArticleInfo).getAdbf(), 0, ((AdvertisementInfo)localBaseArticleInfo).adpa, ((AdvertisementInfo)localBaseArticleInfo).adpb, localBaseArticleInfo.mVideoDuration * 1000, 1, 0, ((AdvertisementInfo)localBaseArticleInfo).videoReplayCount, a(), ((AdvertisementInfo)localBaseArticleInfo).isClickReplay, false)));
      ((AdvertisementInfo)localBaseArticleInfo).isClickReplay = false;
    }
  }
  
  private boolean a(VideoPlayerWrapper paramVideoPlayerWrapper, int paramInt1, int paramInt2, int paramInt3, String paramString, Object paramObject)
  {
    StringBuilder localStringBuilder = new StringBuilder().append("model : ").append(paramInt1).append(" what : ").append(paramInt2).append(" extra : ").append(paramInt3).append("detailInfo : ").append(paramString).append(" obj : ");
    if (paramObject != null) {}
    for (paramObject = paramObject.toString();; paramObject = "")
    {
      paramObject = paramObject;
      if (QLog.isColorLevel()) {
        QLog.d(jdField_a_of_type_JavaLangString, 2, "video play has error ! " + paramObject);
      }
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager$VideoPlayParam = this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager$VideoPlayParam;
      if (this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager$VideoPlayParam != null) {
        ((IPublicAccountUtil)QRoute.api(IPublicAccountUtil.class)).videoPlayRealtimeReport(this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager$VideoPlayParam.j, this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager$VideoPlayParam.jdField_c_of_type_JavaLangString, 1, paramInt2);
      }
      if (paramVideoPlayerWrapper == this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayerWrapper) {
        this.jdField_a_of_type_AndroidOsHandler.post(new VideoPlayManager.5(this, paramInt1, paramInt2, paramString, paramVideoPlayerWrapper));
      }
      return true;
    }
  }
  
  private boolean a(VideoPlayerWrapper paramVideoPlayerWrapper, int paramInt, Object paramObject)
  {
    if ((paramVideoPlayerWrapper != this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayerWrapper) || (a() == 5) || (this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager$VideoPlayParam == null) || (this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager$VideoPlayParam.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructReadinjoyVideoReportData == null))
    {
      if (QLog.isColorLevel()) {
        QLog.d(jdField_a_of_type_JavaLangString, 2, "onInfo(): what:" + paramInt + ",extra:" + paramObject + ", getCurPlayState == paused, just ignore.");
      }
      return false;
    }
    paramVideoPlayerWrapper = this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager$VideoPlayParam.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructReadinjoyVideoReportData;
    switch (paramInt)
    {
    default: 
      return false;
    case 105: 
      paramVideoPlayerWrapper.v = (SystemClock.uptimeMillis() - paramVideoPlayerWrapper.jdField_b_of_type_Long);
      paramVideoPlayerWrapper.w = (SystemClock.uptimeMillis() - paramVideoPlayerWrapper.jdField_c_of_type_Long);
      this.jdField_a_of_type_AndroidOsHandler.post(new VideoPlayManager.6(this));
      return false;
    case 112: 
      if (QLog.isColorLevel()) {
        QLog.d(jdField_a_of_type_JavaLangString, 2, "onInfo(): video start buffering !");
      }
      a(this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager$VideoPlayParam, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayerWrapper, 4, null);
      paramVideoPlayerWrapper.e = SystemClock.uptimeMillis();
      return false;
    case 113: 
      if (QLog.isColorLevel()) {
        QLog.d(jdField_a_of_type_JavaLangString, 2, "onInfo(): video end buffering ! isPause=" + d());
      }
      if (!d()) {
        a(this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager$VideoPlayParam, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayerWrapper, 3, null);
      }
      paramVideoPlayerWrapper.f += SystemClock.uptimeMillis() - paramVideoPlayerWrapper.e;
      paramVideoPlayerWrapper.jdField_c_of_type_Int += 1;
      return false;
    case 208: 
      CodecReuseHelper.a.a(paramObject, paramVideoPlayerWrapper);
      return false;
    }
    paramVideoPlayerWrapper.u = ((Long)paramObject).intValue();
    return false;
  }
  
  public static boolean a(String paramString)
  {
    if (!TextUtils.isEmpty(paramString))
    {
      QQAppInterface localQQAppInterface = RIJQQAppInterfaceUtil.b();
      if (localQQAppInterface != null) {
        return ((PublicAccountDataManager)localQQAppInterface.getManager(QQManagerFactory.PUBLICACCOUNTDATA_MANAGER)).a(Long.valueOf(paramString));
      }
    }
    return false;
  }
  
  private void b(int paramInt, boolean paramBoolean)
  {
    if ((paramInt == 3) && (!this.jdField_d_of_type_Boolean))
    {
      if (QLog.isColorLevel()) {
        QLog.d(jdField_a_of_type_JavaLangString, 2, "pause for not visible，isSubThread:" + paramBoolean);
      }
      a();
    }
  }
  
  private void b(VideoPlayerWrapper paramVideoPlayerWrapper, VideoPlayManager.VideoPlayParam paramVideoPlayParam)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.readinjoy.video", 2, "doOpenVideo executed On SubThread, busitype:" + paramVideoPlayParam.f + " vid:" + paramVideoPlayParam.jdField_c_of_type_JavaLangString);
    }
    if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayerWrapper == null) || (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayerWrapper != paramVideoPlayerWrapper)) {
      return;
    }
    if (TextUtils.isEmpty(paramVideoPlayParam.jdField_c_of_type_JavaLangString))
    {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager$PlayListenerAdapter.a(paramVideoPlayerWrapper, 201, 61, 0, "vid null", null);
      return;
    }
    if (paramVideoPlayParam.jdField_d_of_type_Long <= 0L) {
      paramVideoPlayParam.jdField_d_of_type_Long = VideoResumeManager.a.a(paramVideoPlayParam.j, paramVideoPlayParam.jdField_c_of_type_JavaLangString);
    }
    if ((paramVideoPlayParam.f == 2) || (paramVideoPlayParam.f == 6))
    {
      ThirdVideoManager localThirdVideoManager = ThirdVideoManager.a();
      localThirdVideoManager.a(paramVideoPlayParam.jdField_c_of_type_JavaLangString, new VideoPlayManager.9(this, paramVideoPlayerWrapper, paramVideoPlayParam, localThirdVideoManager));
    }
    for (;;)
    {
      if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPreDownloadMgr != null)
      {
        paramVideoPlayerWrapper.jdField_b_of_type_Boolean = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPreDownloadMgr.a(paramVideoPlayParam.g, paramVideoPlayParam.jdField_c_of_type_JavaLangString);
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPreDownloadMgr.a(paramVideoPlayParam.jdField_c_of_type_JavaLangString, paramVideoPlayerWrapper.jdField_b_of_type_Boolean);
      }
      ((IPublicAccountUtil)QRoute.api(IPublicAccountUtil.class)).videoPlayRealtimeReport(paramVideoPlayParam.j, paramVideoPlayParam.jdField_c_of_type_JavaLangString, 0, 0);
      return;
      if (ReadInJoyAdUtils.n(paramVideoPlayParam.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo))
      {
        ((AdvertisementInfo)paramVideoPlayParam.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo).adbt = ((int)paramVideoPlayParam.jdField_d_of_type_Long);
        if (paramVideoPlayParam.jdField_d_of_type_Long == 0L)
        {
          ((AdvertisementInfo)paramVideoPlayParam.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo).adpa = 1;
          ((AdvertisementInfo)paramVideoPlayParam.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo).adpb = 1;
        }
        paramVideoPlayerWrapper.a("", paramVideoPlayParam.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.mVideoVid, 101, paramVideoPlayParam.jdField_d_of_type_Long, paramVideoPlayParam.e, paramVideoPlayParam.jdField_b_of_type_Int);
      }
      else
      {
        paramVideoPlayerWrapper.a(paramVideoPlayParam.jdField_c_of_type_JavaLangString, 1, paramVideoPlayParam.jdField_d_of_type_Long);
      }
    }
  }
  
  public int a()
  {
    int i = 0;
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayerWrapper != null) {
      i = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayerWrapper.b();
    }
    if (i == this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.get()) {
      return i;
    }
    if (QLog.isColorLevel()) {
      QLog.w("Q.readinjoy.video", 2, "getCurPlayState, should not happen...: mVideoPlayerWrapper.getCurrentStatus() = " + VideoPlayUtils.a(i) + ",mState.get()=" + VideoPlayUtils.a(this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.get()));
    }
    return this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.get();
  }
  
  public long a()
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayerWrapper != null) {
      return this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayerWrapper.a();
    }
    return 0L;
  }
  
  public Activity a()
  {
    return this.jdField_a_of_type_AndroidAppActivity;
  }
  
  public VideoPlayManager.VideoPlayParam a()
  {
    return this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager$VideoPlayParam;
  }
  
  public VideoPlayerWrapper a(VideoPlayManager.VideoPlayParam paramVideoPlayParam)
  {
    if (this.jdField_a_of_type_AndroidAppActivity == null) {
      return null;
    }
    VideoPlayerWrapper localVideoPlayerWrapper = new VideoPlayerWrapper(this.jdField_a_of_type_AndroidAppActivity.getApplicationContext());
    localVideoPlayerWrapper.e(true);
    localVideoPlayerWrapper.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager$PlayListenerAdapter);
    if (QLog.isColorLevel()) {
      QLog.d("Q.readinjoy.video", 2, "getVideoPlayer new instant!");
    }
    this.jdField_a_of_type_JavaUtilMap.put(paramVideoPlayParam.a(), new WeakReference(localVideoPlayerWrapper));
    return localVideoPlayerWrapper;
  }
  
  public VideoPlayerWrapper a(String paramString)
  {
    paramString = (WeakReference)this.jdField_a_of_type_JavaUtilMap.get(paramString);
    if (paramString != null) {
      return (VideoPlayerWrapper)paramString.get();
    }
    return null;
  }
  
  public VideoUIManager a()
  {
    return this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoUIManager;
  }
  
  public String a()
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayerWrapper != null) {
      return this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayerWrapper.a();
    }
    return null;
  }
  
  public void a()
  {
    e(false);
  }
  
  public void a(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayerWrapper != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayerWrapper.b(paramInt);
    }
    if (QLog.isColorLevel()) {
      QLog.e("Q.readinjoy.video", 2, "setXYaxis value:" + paramInt);
    }
  }
  
  public void a(int paramInt, VideoPlayManager.VideoPlayParam paramVideoPlayParam)
  {
    a(ReportConstants.VideoEndType.CLICK_PAUSE);
    if ((this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager$VideoPlayParam != null) && ((this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager$VideoPlayParam.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo instanceof AdvertisementInfo))) {
      VideoAdClickRecorder.b((AdvertisementInfo)this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager$VideoPlayParam.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo);
    }
    this.jdField_d_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager$VideoPlayParam = null;
    if ((this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager$VideoPlayParam != null) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayerWrapper != null))
    {
      if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayerWrapper.b() == 2) {
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayerWrapper.d();
      }
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayerWrapper.a(paramInt);
      a(this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager$VideoPlayParam, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayerWrapper, 3, null);
      if (QLog.isColorLevel()) {
        QLog.d(jdField_a_of_type_JavaLangString, 2, "resume(): playVideo: mVideoPlayerWrapper.seekTo() position=" + paramInt);
      }
      a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayerWrapper, paramVideoPlayParam, false);
    }
    do
    {
      do
      {
        return;
        if (paramVideoPlayParam == null) {
          break;
        }
        this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager$VideoPlayParam = paramVideoPlayParam;
        paramVideoPlayParam = this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager$VideoPlayParam;
        b(1);
        paramVideoPlayParam.jdField_d_of_type_Long = paramInt;
        a(paramVideoPlayParam);
      } while (!QLog.isColorLevel());
      QLog.w(jdField_a_of_type_JavaLangString, 2, "resume(): mCurrenPlayVideoParam = null, playVideo: " + paramVideoPlayParam.jdField_c_of_type_JavaLangString);
      return;
    } while (!QLog.isColorLevel());
    QLog.e(jdField_a_of_type_JavaLangString, 2, "resume(): playVideo: param = null && mVideoPlayerWrapper = null");
  }
  
  public void a(int paramInt, boolean paramBoolean)
  {
    this.jdField_b_of_type_Boolean = paramBoolean;
    if ((this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager$VideoPlayParam != null) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayerWrapper != null)) {
      a(this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager$VideoPlayParam.jdField_c_of_type_Long, paramInt);
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.readinjoy.video", 2, "stop , from : " + paramInt);
      }
      return;
      if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayerWrapper != null)
      {
        a(this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager$VideoPlayParam, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayerWrapper, 0, null);
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayerWrapper.l();
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayerWrapper = null;
        this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager$VideoPlayParam = null;
      }
      else if (this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager$VideoPlayParam != null)
      {
        a(this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager$VideoPlayParam, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayerWrapper, 0, null);
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayerWrapper = null;
        this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager$VideoPlayParam = null;
      }
    }
  }
  
  public void a(long paramLong, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.readinjoy.video", 2, "player stop [async]  stopID : " + paramLong + ", from : " + paramInt);
    }
    if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayerWrapper != null) && (this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager$VideoPlayParam != null) && (this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager$VideoPlayParam.jdField_c_of_type_Long == paramLong))
    {
      this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager$VideoPlayParam.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewVideoViewGroup.setKeepScreenOn(false);
      a(this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager$VideoPlayParam, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayerWrapper, 0, null);
      this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager$VideoPlayParam.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructReadinjoyVideoReportData.jdField_a_of_type_Long = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayerWrapper.a(false);
      this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager$VideoPlayParam.jdField_d_of_type_Long = a();
      VideoResumeManager.a.a(this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager$VideoPlayParam.j, this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager$VideoPlayParam.jdField_c_of_type_JavaLangString, this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager$VideoPlayParam.jdField_d_of_type_Long, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayerWrapper.b());
      if ((this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager$VideoPlayParam.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructReadinjoyVideoReportData.jdField_a_of_type_Long == 0L) && (this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager$VideoPlayParam.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructReadinjoyVideoReportData.jdField_d_of_type_Long == 0L) && (this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager$VideoPlayParam.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructReadinjoyVideoReportData.jdField_b_of_type_Long != 0L)) {
        this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager$VideoPlayParam.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructReadinjoyVideoReportData.jdField_d_of_type_Long = (SystemClock.uptimeMillis() - this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager$VideoPlayParam.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructReadinjoyVideoReportData.jdField_b_of_type_Long);
      }
      this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager$VideoPlayParam.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructReadinjoyVideoReportData.jdField_a_of_type_Float = ((float)this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager$VideoPlayParam.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructReadinjoyVideoReportData.jdField_a_of_type_Long / this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager$VideoPlayParam.jdField_b_of_type_Int);
      this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager$VideoPlayParam.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructReadinjoyVideoReportData.jdField_a_of_type_Boolean = true;
      this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager$VideoPlayParam.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructReadinjoyVideoReportData.jdField_n_of_type_Long = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayerWrapper.c();
      this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager$VideoPlayParam.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructReadinjoyVideoReportData.jdField_g_of_type_Int = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayerWrapper.e();
      this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager$VideoPlayParam.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructReadinjoyVideoReportData.jdField_h_of_type_Int = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayerWrapper.f();
      this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager$VideoPlayParam.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructReadinjoyVideoReportData.jdField_c_of_type_Boolean = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayerWrapper.jdField_b_of_type_Boolean;
      this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager$VideoPlayParam.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructReadinjoyVideoReportData.jdField_q_of_type_Long = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayerWrapper.jdField_b_of_type_Long;
      this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager$VideoPlayParam.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructReadinjoyVideoReportData.jdField_p_of_type_Long = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayerWrapper.jdField_a_of_type_Long;
      this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager$VideoPlayParam.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructReadinjoyVideoReportData.jdField_r_of_type_Long = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayerWrapper.g();
      if ((this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager$VideoPlayParam.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructReadinjoyVideoReportData.jdField_a_of_type_Long == 0L) && (this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager$VideoPlayParam.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructReadinjoyVideoReportData.jdField_d_of_type_Long == 0L))
      {
        this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager$VideoPlayParam.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructReadinjoyVideoReportData.jdField_d_of_type_Long = (SystemClock.uptimeMillis() - this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager$VideoPlayParam.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructReadinjoyVideoReportData.jdField_b_of_type_Long);
        this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager$VideoPlayParam.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructReadinjoyVideoReportData.f = this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager$VideoPlayParam.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructReadinjoyVideoReportData.jdField_d_of_type_Long;
      }
      this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager$VideoPlayParam.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructReadinjoyVideoReportData.jdField_m_of_type_Int = c();
      this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager$VideoPlayParam.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructReadinjoyVideoReportData.jdField_n_of_type_Int = d();
      Object localObject;
      int i;
      int j;
      boolean bool;
      if (this.jdField_c_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager$VideoPlayParam != null)
      {
        localObject = this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager$VideoPlayParam.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructReadinjoyVideoReportData;
        i = this.jdField_c_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager$VideoPlayParam.jdField_a_of_type_Int;
        j = this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager$VideoPlayParam.jdField_a_of_type_Int;
        if (this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager$VideoPlayParam.jdField_m_of_type_Int == 3) {
          bool = true;
        }
      }
      for (((ReadinjoyVideoReportData)localObject).jdField_t_of_type_Int = ReadInJoyUtils.a(i, j, bool);; this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager$VideoPlayParam.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructReadinjoyVideoReportData.jdField_t_of_type_Int = -1)
      {
        this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager$VideoPlayParam.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructReadinjoyVideoReportData.jdField_d_of_type_Int = this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager$VideoPlayParam.jdField_m_of_type_Int;
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayerWrapper.b();
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayerWrapper.a();
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayerWrapper.a(this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager$VideoPlayParam.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructReadinjoyVideoReportData.b());
        localObject = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayerWrapper;
        ((VideoPlayerWrapper)localObject).l();
        a(this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager$VideoPlayParam);
        RIJStatisticCollectorReport.a(this.jdField_a_of_type_AndroidAppActivity.getApplicationContext(), ReadInJoyUtils.a(), true, this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager$VideoPlayParam.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructReadinjoyVideoReportData.a());
        QualityReporter.a(this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager$VideoPlayParam.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructReadinjoyVideoReportData);
        RIJStatisticCollectorReport.a(true, this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager$VideoPlayParam.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructReadinjoyVideoReportData.jdField_d_of_type_Boolean, this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager$VideoPlayParam.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructReadinjoyVideoReportData.jdField_h_of_type_Int, this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager$VideoPlayParam.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructReadinjoyVideoReportData.jdField_a_of_type_Int, this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager$VideoPlayParam.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructReadinjoyVideoReportData.jdField_d_of_type_Long, 56, this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager$VideoPlayParam.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructReadinjoyVideoReportData.jdField_c_of_type_JavaLangString, this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager$VideoPlayParam.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructReadinjoyVideoReportData.jdField_a_of_type_JavaLangString);
        if ((this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager$VideoPlayParam.jdField_d_of_type_Long > 0L) && (this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager$VideoPlayParam.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructReadinjoyVideoReportData.jdField_a_of_type_Long > 0L)) {
          ThreadManager.post(new VideoPlayManager.10(this, this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager$VideoPlayParam, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoRecommendManager, (VideoPlayerWrapper)localObject, this.jdField_b_of_type_Boolean, paramInt), 5, null, true);
        }
        this.e = false;
        this.jdField_c_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager$VideoPlayParam = this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager$VideoPlayParam;
        this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager$VideoPlayParam = null;
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayerWrapper = null;
        return;
        bool = false;
        break;
      }
    }
    QLog.e("Q.readinjoy.video", 1, "stop : current player is null or articleID is not equal!");
  }
  
  public void a(ReportConstants.VideoEndType paramVideoEndType)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountNativeAdReportConstantReportConstants$VideoEndType = paramVideoEndType;
  }
  
  public void a(BaseVideoPlayParam paramBaseVideoPlayParam)
  {
    if ((paramBaseVideoPlayParam == null) || (!(paramBaseVideoPlayParam instanceof VideoPlayManager.VideoPlayParam))) {}
    VideoPlayerWrapper localVideoPlayerWrapper;
    do
    {
      do
      {
        return;
        if (!VideoVolumeControl.a(this.jdField_a_of_type_AndroidAppActivity)) {
          break;
        }
      } while (!QLog.isColorLevel());
      QLog.d("Q.readinjoy.video", 2, "playVideo in call return");
      return;
      paramBaseVideoPlayParam = (VideoPlayManager.VideoPlayParam)paramBaseVideoPlayParam;
      try
      {
        this.jdField_d_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager$VideoPlayParam = null;
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager$VideoPlayParam = null;
        if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoUIManager != null) {
          this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoUIManager.b(paramBaseVideoPlayParam);
        }
        if (!this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPluginInstall.a())
        {
          if (QLog.isColorLevel()) {
            QLog.d("Q.readinjoy.video", 2, "start install tencent sdk plugin");
          }
          this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager$VideoPlayParam = paramBaseVideoPlayParam;
          a(this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager$VideoPlayParam, null, 4, null);
          this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPluginInstall.a();
          return;
        }
      }
      catch (Exception paramBaseVideoPlayParam)
      {
        paramBaseVideoPlayParam.printStackTrace();
        QLog.e("Q.readinjoy.video", 1, "playVideo error:", paramBaseVideoPlayParam);
        return;
      }
      if (QLog.isColorLevel()) {
        QLog.d(jdField_a_of_type_JavaLangString, 2, "play video start ! playParams : " + paramBaseVideoPlayParam.toString());
      }
      this.jdField_a_of_type_Boolean = true;
      localVideoPlayerWrapper = a(paramBaseVideoPlayParam);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayerWrapper = localVideoPlayerWrapper;
      this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager$VideoPlayParam = paramBaseVideoPlayParam;
    } while (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayerWrapper == null);
    a(this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager$VideoPlayParam, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayerWrapper, 1, null);
    paramBaseVideoPlayParam.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewVideoViewGroup.removeAllViews();
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayerWrapper.a(paramBaseVideoPlayParam.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewVideoViewGroup);
    IVideoView localIVideoView = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayerWrapper.a();
    if ((localIVideoView == null) || (localIVideoView.a() == null))
    {
      QLog.e(jdField_a_of_type_JavaLangString, 1, "playVideo failed, because get videoView == null!");
      a(this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager$VideoPlayParam, null, 6, "videoview null");
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayerWrapper = null;
      this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager$VideoPlayParam = null;
      return;
    }
    paramBaseVideoPlayParam.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoPlayerWrapperIVideoView = localIVideoView;
    localIVideoView.a().setId(2131376562);
    paramBaseVideoPlayParam.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewVideoViewGroup.setKeepScreenOn(true);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayerWrapper.b(this.jdField_a_of_type_Int);
    this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager$VideoPlayParam.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructReadinjoyVideoReportData.jdField_b_of_type_Long = SystemClock.uptimeMillis();
    this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager$VideoPlayParam.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructReadinjoyVideoReportData.jdField_c_of_type_Long = SystemClock.uptimeMillis();
    this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager$VideoPlayParam.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructReadinjoyVideoReportData.jdField_p_of_type_Int = 0;
    this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager$VideoPlayParam.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructReadinjoyVideoReportData.jdField_q_of_type_Int = 0;
    this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager$VideoPlayParam.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructReadinjoyVideoReportData.jdField_r_of_type_Int = 0;
    this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager$VideoPlayParam.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructReadinjoyVideoReportData.jdField_g_of_type_Boolean = false;
    this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager$VideoPlayParam.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructReadinjoyVideoReportData.jdField_h_of_type_Boolean = false;
    ThreadManager.executeOnSubThread(new VideoPlayManager.8(this, localVideoPlayerWrapper, paramBaseVideoPlayParam));
  }
  
  public void a(RecommendADVideoFeedsManager paramRecommendADVideoFeedsManager)
  {
    paramRecommendADVideoFeedsManager.a(this);
  }
  
  public void a(VideoAutoPlayController paramVideoAutoPlayController)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoAutoPlayController = paramVideoAutoPlayController;
  }
  
  public void a(VideoPlayManager.OnPlayStateListener paramOnPlayStateListener)
  {
    if ((paramOnPlayStateListener != null) && (this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList != null) && (!this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.contains(paramOnPlayStateListener))) {
      this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.add(paramOnPlayStateListener);
    }
  }
  
  public void a(VideoPlayManager.VideoStatusListener paramVideoStatusListener)
  {
    if (this.jdField_a_of_type_JavaUtilSet == null) {
      this.jdField_a_of_type_JavaUtilSet = new HashSet();
    }
    this.jdField_a_of_type_JavaUtilSet.add(paramVideoStatusListener);
  }
  
  public void a(VideoPreDownloadMgr paramVideoPreDownloadMgr)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPreDownloadMgr = paramVideoPreDownloadMgr;
  }
  
  public void a(VideoRecommendManager paramVideoRecommendManager)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoRecommendManager = paramVideoRecommendManager;
  }
  
  public void a(VideoUIManager paramVideoUIManager)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoUIManager = paramVideoUIManager;
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoUIManager.a(this);
  }
  
  public void a(String paramString)
  {
    this.jdField_b_of_type_JavaLangString = paramString;
  }
  
  public void a(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      if (QLog.isColorLevel()) {
        QLog.d(jdField_a_of_type_JavaLangString, 2, "install tencent video sdk success!");
      }
      if (this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager$VideoPlayParam != null) {
        a(this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager$VideoPlayParam);
      }
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "install tencent video sdk fail!");
    }
    a(this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager$VideoPlayParam, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayerWrapper, 6, "install failure");
    this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager$VideoPlayParam = null;
  }
  
  public boolean a()
  {
    return (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayerWrapper != null) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayerWrapper.l());
  }
  
  public int b()
  {
    return this.jdField_a_of_type_Int;
  }
  
  public long b()
  {
    if (this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager$VideoPlayParam == null) {
      return -1L;
    }
    return this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager$VideoPlayParam.jdField_c_of_type_Long;
  }
  
  public String b()
  {
    return this.jdField_b_of_type_JavaLangString;
  }
  
  public void b()
  {
    this.jdField_d_of_type_Boolean = false;
    e(false);
  }
  
  public void b(int paramInt)
  {
    a(paramInt, false);
  }
  
  public void b(VideoPlayManager.OnPlayStateListener paramOnPlayStateListener)
  {
    if ((paramOnPlayStateListener != null) && (this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList != null)) {
      this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.remove(paramOnPlayStateListener);
    }
  }
  
  public void b(boolean paramBoolean)
  {
    this.f = paramBoolean;
  }
  
  public boolean b()
  {
    return (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayerWrapper != null) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayerWrapper.f());
  }
  
  public int c()
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayerWrapper != null) {
      return this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayerWrapper.c();
    }
    return -1;
  }
  
  public long c()
  {
    if (this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager$VideoPlayParam == null) {
      return 0L;
    }
    return this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager$VideoPlayParam.jdField_b_of_type_Long;
  }
  
  public void c()
  {
    f(false);
  }
  
  public void c(int paramInt)
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayerWrapper != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayerWrapper.a(paramInt);
    }
  }
  
  public void c(boolean paramBoolean)
  {
    boolean bool = paramBoolean;
    if (this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager$VideoPlayParam != null)
    {
      bool = paramBoolean;
      if (this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager$VideoPlayParam.jdField_b_of_type_Boolean) {
        bool = true;
      }
    }
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayerWrapper != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayerWrapper.c(bool);
    }
  }
  
  public boolean c()
  {
    return this.e;
  }
  
  public int d()
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayerWrapper != null) {
      return this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayerWrapper.d();
    }
    return -1;
  }
  
  public long d()
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayerWrapper != null) {
      return this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayerWrapper.b();
    }
    return 0L;
  }
  
  public void d()
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.readinjoy.video", 2, "VideoPlayManager : destroy !");
    }
    a(ReportConstants.VideoEndType.EXIT_SCENE);
    b(7);
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayerWrapper != null)
    {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayerWrapper.l();
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayerWrapper = null;
    }
    if (this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager$VideoPlayParam != null) {
      this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager$VideoPlayParam = null;
    }
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPluginInstall.b();
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPluginInstall = null;
    try
    {
      this.jdField_a_of_type_AndroidAppActivity = null;
      VideoVolumeControl.a().b(this);
      Iterator localIterator = this.jdField_a_of_type_JavaUtilMap.values().iterator();
      while (localIterator.hasNext())
      {
        VideoPlayerWrapper localVideoPlayerWrapper = (VideoPlayerWrapper)((WeakReference)localIterator.next()).get();
        if ((localVideoPlayerWrapper != null) && (!localVideoPlayerWrapper.jdField_a_of_type_Boolean))
        {
          if (QLog.isColorLevel()) {
            QLog.d("Q.readinjoy.video", 2, "VideoPlayerWrapper : " + localVideoPlayerWrapper.toString() + " not release");
          }
          localVideoPlayerWrapper.l();
        }
      }
      this.jdField_a_of_type_JavaUtilMap.clear();
    }
    finally {}
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoUIManager != null)
    {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoUIManager.n();
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoUIManager = null;
    }
    this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.clear();
    this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList = null;
    this.e = false;
  }
  
  public void d(int paramInt)
  {
    if (!this.jdField_d_of_type_Boolean)
    {
      this.jdField_d_of_type_Boolean = true;
      if (paramInt != 0) {
        a(ReportConstants.VideoEndType.EXIT_SCENE);
      }
      if ((this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager$VideoPlayParam != null) && ((this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager$VideoPlayParam.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo instanceof AdvertisementInfo))) {
        VideoAdClickRecorder.b((AdvertisementInfo)this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager$VideoPlayParam.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo);
      }
      if (QLog.isColorLevel()) {
        QLog.d(jdField_a_of_type_JavaLangString, 2, "onVisiable() isPause()=" + d() + ", mPausedByMannul:" + this.e);
      }
      if ((this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager$VideoPlayParam != null) && (this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager$VideoPlayParam.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructReadinjoyVideoReportData != null)) {
        this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager$VideoPlayParam.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructReadinjoyVideoReportData.jdField_b_of_type_Long = SystemClock.uptimeMillis();
      }
      if ((d()) && (!this.e)) {
        c();
      }
      if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoUIManager != null)
      {
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoUIManager.a();
        if (!(this.jdField_a_of_type_AndroidAppActivity instanceof SplashActivity)) {
          break label196;
        }
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoUIManager.a(false);
      }
    }
    for (;;)
    {
      BandwidthPredictor.a().a(this.jdField_a_of_type_AndroidAppActivity);
      return;
      label196:
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoUIManager.a(true);
    }
  }
  
  public void d(boolean paramBoolean)
  {
    this.e = paramBoolean;
  }
  
  public boolean d()
  {
    if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayerWrapper == null) || (this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager$VideoPlayParam == null)) {}
    do
    {
      return false;
      if (a() == 5)
      {
        if ((!this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayerWrapper.e()) && (QLog.isColorLevel())) {
          QLog.w(jdField_a_of_type_JavaLangString, 2, "isPause(): return true. getCurPlayState is PLAY_STATE_PAUSED. But mVideoPlayerWrapper.isPause() == false;");
        }
        return true;
      }
    } while ((!this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayerWrapper.e()) || (!QLog.isColorLevel()));
    QLog.w(jdField_a_of_type_JavaLangString, 2, "isPause(): return false. getCurPlayState is " + VideoPlayUtils.a(a()) + ". But mVideoPlayerWrapper.isPause() == true;");
    return false;
  }
  
  public void e()
  {
    if (this.jdField_d_of_type_Boolean)
    {
      this.jdField_d_of_type_Boolean = false;
      if (QLog.isColorLevel()) {
        QLog.d(jdField_a_of_type_JavaLangString, 2, "onUnVisiable() isPlaying()=" + b() + ", isOpening()=" + f());
      }
      if (!b()) {
        break label105;
      }
      a();
    }
    for (;;)
    {
      if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoUIManager != null)
      {
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoUIManager.b();
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoUIManager.a(false);
      }
      BandwidthPredictor.a().b(this.jdField_a_of_type_AndroidAppActivity);
      return;
      label105:
      if (f())
      {
        a(ReportConstants.VideoEndType.EXIT_SCENE);
        b(8);
      }
    }
  }
  
  public void e(boolean paramBoolean)
  {
    if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayerWrapper != null) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayerWrapper.f()))
    {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayerWrapper.f();
      this.e = paramBoolean;
      if (!NetworkUtil.h(this.jdField_a_of_type_AndroidAppActivity.getApplicationContext())) {
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayerWrapper.j();
      }
      a(this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager$VideoPlayParam, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayerWrapper, 5, Boolean.valueOf(this.e));
      this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager$VideoPlayParam.jdField_d_of_type_Long = a();
      this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager$VideoPlayParam.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructReadinjoyVideoReportData.jdField_a_of_type_Long = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayerWrapper.a(false);
      BaseArticleInfo localBaseArticleInfo = this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager$VideoPlayParam.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo;
      if ((localBaseArticleInfo != null) && (ReadInJoyAdUtils.a((int)localBaseArticleInfo.mChannelID)) && (AdvertisementInfo.isAdvertisementInfo(localBaseArticleInfo)) && ((this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager$VideoPlayParam.jdField_b_of_type_Boolean) || (localBaseArticleInfo.mChannelID == 56L)))
      {
        int j = 1;
        int i = 11;
        if (localBaseArticleInfo.mChannelID == 56L)
        {
          j = 9;
          i = 4;
        }
        NativeAdUtils.a(new AdReportData().a(this.jdField_a_of_type_AndroidAppActivity).a(6).b(i).a((AdvertisementInfo)localBaseArticleInfo).a(NativeAdUtils.a(((AdvertisementInfo)localBaseArticleInfo).adbt, (int)this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager$VideoPlayParam.jdField_d_of_type_Long, ((AdvertisementInfo)localBaseArticleInfo).getAdbf(), 0, ((AdvertisementInfo)localBaseArticleInfo).adpa, ((AdvertisementInfo)localBaseArticleInfo).adpb, localBaseArticleInfo.mVideoDuration * 1000, j, 0, ((AdvertisementInfo)localBaseArticleInfo).videoReplayCount, a(), ((AdvertisementInfo)localBaseArticleInfo).isClickReplay, false)));
        ((AdvertisementInfo)localBaseArticleInfo).isClickReplay = false;
        ((AdvertisementInfo)localBaseArticleInfo).adbt = ((int)this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager$VideoPlayParam.jdField_d_of_type_Long);
      }
    }
  }
  
  public boolean e()
  {
    return (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayerWrapper != null) && (a() == 2);
  }
  
  void f()
  {
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "checkPlayStateAfterPhoneCall isVisible() = " + g());
    }
    if (!g()) {
      return;
    }
    c();
  }
  
  public void f(boolean paramBoolean)
  {
    if (d())
    {
      if (!VideoVolumeControl.a(this.jdField_a_of_type_AndroidAppActivity)) {
        break label33;
      }
      if (QLog.isColorLevel()) {
        QLog.d("Q.readinjoy.video", 2, "VideoPlayManager resume, in call return");
      }
    }
    return;
    label33:
    if (QLog.isColorLevel()) {
      QLog.d("Q.readinjoy.video", 2, "VideoPlayManager : resume(), mannulResume:" + paramBoolean + ", mPausedByMannul:" + this.e);
    }
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayerWrapper.e();
    this.jdField_a_of_type_Boolean = true;
    this.e = false;
    a(this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager$VideoPlayParam, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayerWrapper, 3, null);
    a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayerWrapper, this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager$VideoPlayParam, paramBoolean);
  }
  
  public boolean f()
  {
    return (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayerWrapper != null) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayerWrapper.b());
  }
  
  public boolean g()
  {
    return this.jdField_d_of_type_Boolean;
  }
  
  public boolean h()
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoUIManager != null) {
      return this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoUIManager.a();
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.video.VideoPlayManager
 * JD-Core Version:    0.7.0.1
 */