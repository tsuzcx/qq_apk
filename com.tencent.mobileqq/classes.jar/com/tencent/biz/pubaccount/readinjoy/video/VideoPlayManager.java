package com.tencent.biz.pubaccount.readinjoy.video;

import android.app.Activity;
import android.graphics.Bitmap;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import com.tencent.biz.pubaccount.readinjoy.common.ReadInJoyUtils;
import com.tencent.biz.pubaccount.readinjoy.struct.ReadinjoyVideoReportData;
import com.tencent.biz.pubaccount.readinjoy.view.VideoViewGroup;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.mediaplayer.api.TVK_IMediaPlayer;
import com.tencent.qqlive.mediaplayer.view.IVideoViewBase;
import com.tencent.util.Pair;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicInteger;
import meq;
import mev;
import mew;
import mey;
import org.json.JSONObject;

public class VideoPlayManager
  implements VideoPluginInstall.OnVideoPluginInstallListener
{
  public static final String a;
  protected int a;
  private Activity jdField_a_of_type_AndroidAppActivity;
  private Handler jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper());
  private VideoAutoPlayController jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoAutoPlayController;
  private VideoPlayManager.VideoPlayParam jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager$VideoPlayParam;
  private VideoPlayManager.VideoStatusListener jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager$VideoStatusListener;
  private VideoPlayerWrapper.MediaPlayListenerAdapter jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayerWrapper$MediaPlayListenerAdapter = new meq(this);
  private VideoPlayerWrapper jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayerWrapper;
  private VideoPluginInstall jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPluginInstall;
  private VideoPreDownloadMgr jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPreDownloadMgr;
  private VideoRecommendManager jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoRecommendManager;
  private VideoUIManager jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoUIManager;
  private ArrayList jdField_a_of_type_JavaUtilArrayList;
  private HashMap jdField_a_of_type_JavaUtilHashMap;
  private List jdField_a_of_type_JavaUtilList;
  private CopyOnWriteArrayList jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList;
  private AtomicInteger jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger = new AtomicInteger(0);
  private boolean jdField_a_of_type_Boolean;
  private int jdField_b_of_type_Int = 1;
  private String jdField_b_of_type_JavaLangString;
  private HashMap jdField_b_of_type_JavaUtilHashMap;
  private boolean jdField_b_of_type_Boolean = true;
  private boolean c;
  private boolean d;
  private boolean e;
  
  static
  {
    jdField_a_of_type_JavaLangString = "Q.readinjoy.video." + VideoPlayManager.class.getSimpleName();
  }
  
  public VideoPlayManager(Activity paramActivity)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.readinjoy.video", 2, "VideoPlayManager : create a new manager !");
    }
    this.jdField_a_of_type_AndroidAppActivity = paramActivity;
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPluginInstall = new VideoPluginInstall(this.jdField_a_of_type_AndroidAppActivity.getApplicationContext());
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPluginInstall.a(this);
    this.jdField_a_of_type_JavaUtilHashMap = new HashMap();
    this.jdField_b_of_type_JavaUtilHashMap = new HashMap();
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList = new CopyOnWriteArrayList();
    VideoVolumeControl.a().a(this);
  }
  
  private void a(VideoPlayManager.VideoPlayParam paramVideoPlayParam, VideoPlayerWrapper paramVideoPlayerWrapper, int paramInt, Object paramObject)
  {
    try
    {
      int i = this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.get();
      if (paramInt != i)
      {
        if (QLog.isColorLevel()) {
          QLog.d(jdField_a_of_type_JavaLangString, 2, "changeStateAndNotify(): " + VideoPlayUtils.a(this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.get()) + " ===> " + VideoPlayUtils.a(paramInt) + ", extra = " + paramObject + ", videoPlayParam=" + paramVideoPlayParam + ", videoPlayWrapper=" + paramVideoPlayerWrapper);
        }
        this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.set(paramInt);
        if (Thread.currentThread() == Looper.getMainLooper().getThread())
        {
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
        }
        else {
          this.jdField_a_of_type_AndroidOsHandler.post(new mev(this, paramVideoPlayParam, paramVideoPlayerWrapper, i, paramInt, paramObject));
        }
      }
    }
    finally {}
  }
  
  public int a()
  {
    int i = 0;
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayerWrapper != null) {
      i = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayerWrapper.c();
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
  
  public Bitmap a(int paramInt)
  {
    Object localObject = this.jdField_a_of_type_JavaUtilArrayList.iterator();
    while (((Iterator)localObject).hasNext())
    {
      Pair localPair = (Pair)((Iterator)localObject).next();
      if (paramInt == ((Integer)localPair.first).intValue())
      {
        localObject = (Bitmap)localPair.second;
        this.jdField_a_of_type_JavaUtilArrayList.remove(localPair);
        return localObject;
      }
    }
    return null;
  }
  
  public VideoPlayManager.VideoPlayParam a()
  {
    return this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager$VideoPlayParam;
  }
  
  public VideoPlayManager.VideoPlayParam a(long paramLong)
  {
    return (VideoPlayManager.VideoPlayParam)this.jdField_a_of_type_JavaUtilHashMap.get(Long.valueOf(paramLong));
  }
  
  public VideoPlayerWrapper a(VideoPlayManager.VideoPlayParam paramVideoPlayParam)
  {
    if (this.jdField_a_of_type_AndroidAppActivity == null) {
      return null;
    }
    paramVideoPlayParam = new VideoPlayerWrapper(this.jdField_a_of_type_AndroidAppActivity.getApplicationContext());
    paramVideoPlayParam.a(this.jdField_a_of_type_AndroidAppActivity);
    paramVideoPlayParam.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayerWrapper$MediaPlayListenerAdapter);
    if (QLog.isColorLevel()) {
      QLog.d("Q.readinjoy.video", 2, "getVideoPlayer new instant!");
    }
    this.jdField_a_of_type_JavaUtilList.add(new WeakReference(paramVideoPlayParam));
    return paramVideoPlayParam;
  }
  
  public VideoUIManager a()
  {
    return this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoUIManager;
  }
  
  public String a()
  {
    return this.jdField_b_of_type_JavaLangString;
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
    if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager$VideoPlayParam != null) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayerWrapper != null))
    {
      if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayerWrapper.c() == 2) {
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayerWrapper.d();
      }
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayerWrapper.a(paramInt);
      a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager$VideoPlayParam, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayerWrapper, 3, null);
      if (QLog.isColorLevel()) {
        QLog.d(jdField_a_of_type_JavaLangString, 2, "resume(): playVideo: mVideoPlayerWrapper.seekTo() position=" + paramInt);
      }
    }
    do
    {
      do
      {
        return;
        if (paramVideoPlayParam == null) {
          break;
        }
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager$VideoPlayParam = paramVideoPlayParam;
        paramVideoPlayParam = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager$VideoPlayParam;
        b(1);
        paramVideoPlayParam.jdField_b_of_type_Long = paramInt;
        a(paramVideoPlayParam);
      } while (!QLog.isColorLevel());
      QLog.w(jdField_a_of_type_JavaLangString, 2, "resume(): mCurrenPlayVideoParam = null, playVideo: " + paramVideoPlayParam.jdField_a_of_type_JavaLangString);
      return;
    } while (!QLog.isColorLevel());
    QLog.e(jdField_a_of_type_JavaLangString, 2, "resume(): playVideo: param = null && mVideoPlayerWrapper = null");
  }
  
  public void a(long paramLong, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.readinjoy.video", 2, "player stop [async]  stopID : " + paramLong + ", from : " + paramInt);
    }
    if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayerWrapper != null) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager$VideoPlayParam != null) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager$VideoPlayParam.jdField_a_of_type_Long == paramLong))
    {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager$VideoPlayParam.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewVideoViewGroup.setKeepScreenOn(false);
      a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager$VideoPlayParam, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayerWrapper, 0, null);
      b(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager$VideoPlayParam);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager$VideoPlayParam.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructReadinjoyVideoReportData.jdField_a_of_type_Long = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayerWrapper.a(false);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager$VideoPlayParam.jdField_b_of_type_Long = a();
      if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager$VideoPlayParam.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructReadinjoyVideoReportData.jdField_a_of_type_Long == 0L) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager$VideoPlayParam.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructReadinjoyVideoReportData.jdField_c_of_type_Long == 0L) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager$VideoPlayParam.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructReadinjoyVideoReportData.jdField_b_of_type_Long != 0L)) {
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager$VideoPlayParam.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructReadinjoyVideoReportData.jdField_c_of_type_Long = (SystemClock.uptimeMillis() - this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager$VideoPlayParam.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructReadinjoyVideoReportData.jdField_b_of_type_Long);
      }
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager$VideoPlayParam.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructReadinjoyVideoReportData.jdField_a_of_type_Float = ((float)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager$VideoPlayParam.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructReadinjoyVideoReportData.jdField_a_of_type_Long / this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager$VideoPlayParam.jdField_a_of_type_Int);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager$VideoPlayParam.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructReadinjoyVideoReportData.jdField_a_of_type_Boolean = true;
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager$VideoPlayParam.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructReadinjoyVideoReportData.m = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayerWrapper.c();
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager$VideoPlayParam.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructReadinjoyVideoReportData.d = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayerWrapper.a();
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager$VideoPlayParam.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructReadinjoyVideoReportData.jdField_e_of_type_Int = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayerWrapper.b();
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager$VideoPlayParam.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructReadinjoyVideoReportData.jdField_c_of_type_Boolean = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayerWrapper.jdField_b_of_type_Boolean;
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager$VideoPlayParam.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructReadinjoyVideoReportData.p = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayerWrapper.jdField_b_of_type_Long;
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager$VideoPlayParam.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructReadinjoyVideoReportData.o = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayerWrapper.jdField_a_of_type_Long;
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager$VideoPlayParam.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructReadinjoyVideoReportData.q = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayerWrapper.e();
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager$VideoPlayParam.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructReadinjoyVideoReportData.r = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayerWrapper.f();
      if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager$VideoPlayParam.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructReadinjoyVideoReportData.jdField_a_of_type_Long == 0L) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager$VideoPlayParam.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructReadinjoyVideoReportData.jdField_c_of_type_Long == 0L))
      {
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager$VideoPlayParam.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructReadinjoyVideoReportData.jdField_c_of_type_Long = (SystemClock.uptimeMillis() - this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager$VideoPlayParam.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructReadinjoyVideoReportData.jdField_b_of_type_Long);
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager$VideoPlayParam.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructReadinjoyVideoReportData.jdField_e_of_type_Long = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager$VideoPlayParam.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructReadinjoyVideoReportData.jdField_c_of_type_Long;
      }
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayerWrapper.h();
      ReadInJoyUtils.a(this.jdField_a_of_type_AndroidAppActivity.getApplicationContext(), ReadInJoyUtils.a(), true, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager$VideoPlayParam.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructReadinjoyVideoReportData.a());
      if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager$VideoPlayParam.jdField_b_of_type_Long > 0L) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager$VideoPlayParam.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructReadinjoyVideoReportData.jdField_a_of_type_Long > 0L))
      {
        localVideoPlayParam = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager$VideoPlayParam;
        localVideoRecommendManager = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoRecommendManager;
        ThreadManager.post(new mey(this, localVideoPlayParam, new JSONObject(), localVideoRecommendManager), 5, null, true);
      }
      this.d = false;
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager$VideoPlayParam = null;
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayerWrapper = null;
    }
    while (!QLog.isColorLevel())
    {
      VideoPlayManager.VideoPlayParam localVideoPlayParam;
      VideoRecommendManager localVideoRecommendManager;
      return;
    }
    QLog.w("Q.readinjoy.video", 2, "stop : current player is null or articleID is not equal!");
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
  
  public void a(VideoPlayManager.VideoPlayParam paramVideoPlayParam)
  {
    if (VideoVolumeControl.a(this.jdField_a_of_type_AndroidAppActivity)) {
      if (QLog.isColorLevel()) {
        QLog.d("Q.readinjoy.video", 2, "playVideo in call return");
      }
    }
    do
    {
      return;
      try
      {
        if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoUIManager != null) {
          this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoUIManager.a(paramVideoPlayParam);
        }
        if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPluginInstall.a()) {
          break;
        }
        if (QLog.isColorLevel()) {
          QLog.d("Q.readinjoy.video", 2, "start install tencent sdk plugin");
        }
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager$VideoPlayParam = paramVideoPlayParam;
        a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager$VideoPlayParam, null, 4, null);
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPluginInstall.a();
        return;
      }
      catch (Exception paramVideoPlayParam)
      {
        paramVideoPlayParam.printStackTrace();
      }
    } while (!QLog.isColorLevel());
    QLog.e("Q.readinjoy.video", 2, "playVideo error:", paramVideoPlayParam);
    return;
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "play video start ! playParams : " + paramVideoPlayParam.toString());
    }
    this.jdField_a_of_type_Boolean = true;
    VideoPlayerWrapper localVideoPlayerWrapper = a(paramVideoPlayParam);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayerWrapper = localVideoPlayerWrapper;
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager$VideoPlayParam = paramVideoPlayParam;
    a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager$VideoPlayParam, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayerWrapper, 1, null);
    View localView = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayerWrapper.a();
    if (localView == null)
    {
      if (QLog.isColorLevel()) {
        QLog.e(jdField_a_of_type_JavaLangString, 2, "playVideo : get videoView Fail !");
      }
      a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager$VideoPlayParam, null, 6, "videoview null");
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayerWrapper = null;
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager$VideoPlayParam = null;
      return;
    }
    paramVideoPlayParam.jdField_b_of_type_AndroidViewView = localView;
    localView.setId(2131362193);
    paramVideoPlayParam.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewVideoViewGroup.setKeepScreenOn(true);
    paramVideoPlayParam.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewVideoViewGroup.removeAllViews();
    paramVideoPlayParam.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewVideoViewGroup.addView(localView, new ViewGroup.LayoutParams(-1, -1));
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayerWrapper.b(this.jdField_a_of_type_Int);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayerWrapper.a((IVideoViewBase)localView);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager$VideoPlayParam.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructReadinjoyVideoReportData.jdField_b_of_type_Long = SystemClock.uptimeMillis();
    ThreadManager.executeOnSubThread(new mew(this, paramVideoPlayParam, localVideoPlayerWrapper));
  }
  
  public void a(VideoPlayManager.VideoStatusListener paramVideoStatusListener)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager$VideoStatusListener = paramVideoStatusListener;
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
    this.e = paramBoolean;
  }
  
  public boolean a()
  {
    return (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayerWrapper != null) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayerWrapper.a());
  }
  
  public int b()
  {
    return this.jdField_a_of_type_Int;
  }
  
  public long b()
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager$VideoPlayParam == null) {
      return -1L;
    }
    return this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager$VideoPlayParam.jdField_a_of_type_Long;
  }
  
  public void b()
  {
    f(false);
  }
  
  public void b(int paramInt)
  {
    if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager$VideoPlayParam != null) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayerWrapper != null)) {
      a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager$VideoPlayParam.jdField_a_of_type_Long, paramInt);
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.readinjoy.video", 2, "stop , from : " + paramInt);
      }
      return;
      if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayerWrapper != null)
      {
        a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager$VideoPlayParam, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayerWrapper, 0, null);
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayerWrapper.h();
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayerWrapper = null;
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager$VideoPlayParam = null;
      }
      else if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager$VideoPlayParam != null)
      {
        a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager$VideoPlayParam, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayerWrapper, 0, null);
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayerWrapper = null;
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager$VideoPlayParam = null;
      }
    }
  }
  
  public void b(VideoPlayManager.OnPlayStateListener paramOnPlayStateListener)
  {
    if ((paramOnPlayStateListener != null) && (this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList != null)) {
      this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.remove(paramOnPlayStateListener);
    }
  }
  
  public void b(VideoPlayManager.VideoPlayParam paramVideoPlayParam)
  {
    if (this.jdField_a_of_type_JavaUtilHashMap != null) {
      this.jdField_a_of_type_JavaUtilHashMap.put(Long.valueOf(paramVideoPlayParam.jdField_a_of_type_Long), paramVideoPlayParam);
    }
  }
  
  public void b(boolean paramBoolean)
  {
    if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayerWrapper != null) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayerWrapper.a() != null)) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayerWrapper.a().setOutputMute(paramBoolean);
    }
  }
  
  public boolean b()
  {
    return this.d;
  }
  
  public long c()
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager$VideoPlayParam == null) {
      return 0L;
    }
    return this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager$VideoPlayParam.jdField_e_of_type_Long;
  }
  
  public void c()
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.readinjoy.video", 2, "VideoPlayManager : destroy !");
    }
    b(7);
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayerWrapper != null)
    {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayerWrapper.h();
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayerWrapper = null;
    }
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager$VideoPlayParam != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager$VideoPlayParam = null;
    }
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPluginInstall.b();
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPluginInstall = null;
    this.jdField_a_of_type_AndroidAppActivity = null;
    VideoVolumeControl.a().b(this);
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext())
    {
      VideoPlayerWrapper localVideoPlayerWrapper = (VideoPlayerWrapper)((WeakReference)localIterator.next()).get();
      if ((localVideoPlayerWrapper != null) && (!localVideoPlayerWrapper.jdField_a_of_type_Boolean))
      {
        if (QLog.isColorLevel()) {
          QLog.d("Q.readinjoy.video", 2, "VideoPlayerWrapper : " + localVideoPlayerWrapper.toString() + " not release");
        }
        localVideoPlayerWrapper.h();
      }
    }
    this.jdField_a_of_type_JavaUtilList.clear();
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoUIManager != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoUIManager.h();
    }
    this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.clear();
    this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList = null;
    this.d = false;
  }
  
  public void c(int paramInt)
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayerWrapper != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayerWrapper.a(paramInt);
    }
  }
  
  public void c(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      if (QLog.isColorLevel()) {
        QLog.d(jdField_a_of_type_JavaLangString, 2, "install tencent video sdk success!");
      }
      if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager$VideoPlayParam != null) {
        a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager$VideoPlayParam);
      }
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "install tencent video sdk fail!");
    }
    a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager$VideoPlayParam, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayerWrapper, 6, "install failure");
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager$VideoPlayParam = null;
  }
  
  public boolean c()
  {
    if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayerWrapper == null) || (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager$VideoPlayParam == null)) {}
    do
    {
      return false;
      if (a() == 5)
      {
        if ((!this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayerWrapper.b()) && (QLog.isColorLevel())) {
          QLog.w(jdField_a_of_type_JavaLangString, 2, "isPause(): return true. getCurPlayState is PLAY_STATE_PAUSED. But mVideoPlayerWrapper.isPause() == false;");
        }
        return true;
      }
    } while ((!this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayerWrapper.b()) || (!QLog.isColorLevel()));
    QLog.w(jdField_a_of_type_JavaLangString, 2, "isPause(): return false. getCurPlayState is " + VideoPlayUtils.a(a()) + ". But mVideoPlayerWrapper.isPause() == true;");
    return false;
  }
  
  public void d()
  {
    if (this.jdField_c_of_type_Boolean)
    {
      this.jdField_c_of_type_Boolean = false;
      if (QLog.isColorLevel()) {
        QLog.d(jdField_a_of_type_JavaLangString, 2, "onUnVisiable() isPlaying()=" + a() + ", isOpening()=" + e());
      }
      if (!a()) {
        break label81;
      }
      a();
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoUIManager.a(false);
      return;
      label81:
      if (e()) {
        b(8);
      }
    }
  }
  
  public void d(boolean paramBoolean)
  {
    this.d = paramBoolean;
  }
  
  public boolean d()
  {
    return (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayerWrapper != null) && (a() == 2);
  }
  
  public void e()
  {
    if (!this.jdField_c_of_type_Boolean)
    {
      this.jdField_c_of_type_Boolean = true;
      if (QLog.isColorLevel()) {
        QLog.d(jdField_a_of_type_JavaLangString, 2, "onVisiable() isPause()=" + c() + ", mPausedByMannul:" + this.d);
      }
      if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager$VideoPlayParam != null) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager$VideoPlayParam.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructReadinjoyVideoReportData != null)) {
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager$VideoPlayParam.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructReadinjoyVideoReportData.jdField_b_of_type_Long = SystemClock.uptimeMillis();
      }
      if ((c()) && (!this.d)) {
        b();
      }
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoUIManager.a(true);
    }
  }
  
  public void e(boolean paramBoolean)
  {
    if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayerWrapper != null) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayerWrapper.a()))
    {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayerWrapper.f();
      this.d = paramBoolean;
      if (!NetworkUtil.h(this.jdField_a_of_type_AndroidAppActivity.getApplicationContext())) {
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayerWrapper.g();
      }
      a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager$VideoPlayParam, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayerWrapper, 5, Boolean.valueOf(this.d));
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager$VideoPlayParam.jdField_b_of_type_Long = a();
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager$VideoPlayParam.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructReadinjoyVideoReportData.jdField_a_of_type_Long = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayerWrapper.a(false);
    }
  }
  
  public boolean e()
  {
    return (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayerWrapper != null) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayerWrapper.c());
  }
  
  public void f(boolean paramBoolean)
  {
    if (c())
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
      QLog.d("Q.readinjoy.video", 2, "VideoPlayManager : resume(), mannulResume:" + paramBoolean + ", mPausedByMannul:" + this.d);
    }
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayerWrapper.e();
    this.jdField_a_of_type_Boolean = true;
    this.d = false;
    a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager$VideoPlayParam, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayerWrapper, 3, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.video.VideoPlayManager
 * JD-Core Version:    0.7.0.1
 */