package com.tencent.biz.pubaccount.readinjoyAd.ad.video.strategy;

import android.os.Handler;
import android.text.TextUtils;
import android.util.SparseArray;
import android.util.SparseBooleanArray;
import com.tencent.biz.pubaccount.NativeAd.data.AdRequestData;
import com.tencent.biz.pubaccount.NativeAd.util.NativeAdUtils;
import com.tencent.biz.pubaccount.VideoAdInfo;
import com.tencent.biz.pubaccount.VideoInfo;
import com.tencent.biz.pubaccount.readinjoy.common.ReadInJoyUtils;
import com.tencent.biz.pubaccount.readinjoy.decoupling.uilayer.framewrok.preparse.RIJPreParseData;
import com.tencent.biz.pubaccount.readinjoy.engine.ReadInJoyLogicEngine;
import com.tencent.biz.pubaccount.readinjoy.model.AdvertisementInfoModule;
import com.tencent.biz.pubaccount.readinjoy.model.FixPosArticleInterface.FixPosArticleAsyncListener;
import com.tencent.biz.pubaccount.readinjoy.struct.AdvertisementInfo;
import com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsAdapter;
import com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsHardAdBarManager;
import com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsPlayManager.VideoPlayParam;
import com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsRecyclerView;
import com.tencent.biz.pubaccount.readinjoyAd.ad.utils.ReadInJoyAdLog;
import com.tencent.biz.pubaccount.readinjoyAd.ad.utils.ReadInJoyAdSwitchUtil;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import mqq.app.AppRuntime;
import org.json.JSONException;
import org.json.JSONObject;

public class VideoAdExposureManager
{
  private int jdField_a_of_type_Int = 78888888;
  private Handler jdField_a_of_type_AndroidOsHandler;
  private SparseArray<VideoInfo> jdField_a_of_type_AndroidUtilSparseArray = new SparseArray();
  private SparseBooleanArray jdField_a_of_type_AndroidUtilSparseBooleanArray = new SparseBooleanArray();
  private FixPosArticleInterface.FixPosArticleAsyncListener jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelFixPosArticleInterface$FixPosArticleAsyncListener;
  private VideoFeedsAdapter jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsAdapter;
  private VideoFeedsRecyclerView jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecyclerView;
  private ArrayList<Integer> jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  private List<VideoInfo> jdField_a_of_type_JavaUtilList;
  private boolean jdField_a_of_type_Boolean;
  private int jdField_b_of_type_Int = 78888889;
  private SparseArray<VideoInfo> jdField_b_of_type_AndroidUtilSparseArray = new SparseArray();
  private SparseBooleanArray jdField_b_of_type_AndroidUtilSparseBooleanArray = new SparseBooleanArray();
  private ArrayList<VideoInfo> jdField_b_of_type_JavaUtilArrayList = new ArrayList();
  private boolean jdField_b_of_type_Boolean;
  private int jdField_c_of_type_Int = 0;
  private SparseBooleanArray jdField_c_of_type_AndroidUtilSparseBooleanArray = new SparseBooleanArray();
  private int jdField_d_of_type_Int = 0;
  private SparseBooleanArray jdField_d_of_type_AndroidUtilSparseBooleanArray = new SparseBooleanArray();
  private int e = 0;
  private int f = 0;
  private int g = 1;
  
  public VideoAdExposureManager(VideoFeedsAdapter paramVideoFeedsAdapter, List<VideoInfo> paramList, VideoFeedsRecyclerView paramVideoFeedsRecyclerView, Handler paramHandler)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsAdapter = paramVideoFeedsAdapter;
    this.jdField_a_of_type_JavaUtilList = paramList;
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecyclerView = paramVideoFeedsRecyclerView;
    this.jdField_a_of_type_AndroidOsHandler = paramHandler;
    ReadInJoyUtils.a().getManager(QQManagerFactory.READINJOY_LOGIC_MANAGER);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelFixPosArticleInterface$FixPosArticleAsyncListener = new VideoAdExposureManager.PosListener(this);
  }
  
  private int a(int paramInt1, int paramInt2)
  {
    if (paramInt2 == -1) {
      return paramInt1 + 1;
    }
    return Math.max(VideoAdStrategyManager.h + paramInt2 + 1, paramInt1 + 1);
  }
  
  public static VideoInfo a(AdvertisementInfo paramAdvertisementInfo, boolean paramBoolean)
  {
    int i = 0;
    VideoInfo localVideoInfo = new VideoInfo();
    localVideoInfo.jdField_c_of_type_Boolean = true;
    localVideoInfo.jdField_a_of_type_ComTencentBizPubaccountVideoAdInfo = NativeAdUtils.a(paramAdvertisementInfo);
    localVideoInfo.jdField_a_of_type_Int = 5;
    localVideoInfo.l = paramAdvertisementInfo.mJsonVideoList;
    try
    {
      Object localObject;
      if (!TextUtils.isEmpty(paramAdvertisementInfo.mJsonVideoList))
      {
        localObject = RIJPreParseData.a(paramAdvertisementInfo.mJsonVideoList, paramAdvertisementInfo);
        if (!TextUtils.isEmpty((CharSequence)localObject))
        {
          localObject = ((String)localObject).split(";");
          paramAdvertisementInfo.mVideoVid = localObject[0];
          paramAdvertisementInfo.mVideoDuration = Integer.valueOf(localObject[1]).intValue();
          paramAdvertisementInfo.mVideoJsonWidth = Integer.valueOf(localObject[7]).intValue();
          paramAdvertisementInfo.mVideoJsonHeight = Integer.valueOf(localObject[8]).intValue();
        }
      }
      if (paramAdvertisementInfo.mVideoCoverUrl != null)
      {
        localVideoInfo.jdField_b_of_type_JavaLangString = paramAdvertisementInfo.mVideoCoverUrl.toString();
        localVideoInfo.jdField_c_of_type_JavaLangString = paramAdvertisementInfo.mTitle;
        localVideoInfo.jdField_a_of_type_JavaLangString = paramAdvertisementInfo.mVideoVid;
        localVideoInfo.r = paramAdvertisementInfo.mAdVideoUrl;
        localVideoInfo.j = paramAdvertisementInfo.mSubscribeID;
        if (!TextUtils.isEmpty(paramAdvertisementInfo.mSubscribeName)) {
          break label360;
        }
        localVideoInfo.k = paramAdvertisementInfo.mAdCorporateImageName;
        if (!TextUtils.isEmpty(paramAdvertisementInfo.thirdIcon)) {
          break label371;
        }
        localVideoInfo.p = paramAdvertisementInfo.mAdCorporateLogo;
        if (TextUtils.isEmpty(localVideoInfo.l)) {
          localVideoInfo.jdField_a_of_type_JavaLangString = localVideoInfo.r;
        }
        if (paramBoolean)
        {
          localObject = localVideoInfo.jdField_a_of_type_ComTencentBizPubaccountVideoAdInfo;
          if (paramBoolean) {
            i = 1;
          }
          ((VideoAdInfo)localObject).q = i;
        }
        if (QLog.isColorLevel()) {
          QLog.d("VideoAdExposureManager", 2, "videoinfo = " + localVideoInfo.b());
        }
        if (paramAdvertisementInfo.mVideoJsonWidth != 0) {
          break label382;
        }
        i = 540;
        localVideoInfo.jdField_b_of_type_Int = i;
        if (paramAdvertisementInfo.mVideoJsonHeight != 0) {
          break label390;
        }
        i = 960;
        localVideoInfo.jdField_c_of_type_Int = i;
        localVideoInfo.jdField_a_of_type_ComTencentBizPubaccountVideoAdInfo.d = true;
        return localVideoInfo;
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        if (QLog.isColorLevel())
        {
          QLog.e("VideoAdExposureManager", 2, localException.getMessage());
          continue;
          localVideoInfo.jdField_b_of_type_JavaLangString = paramAdvertisementInfo.mAdImg;
          continue;
          label360:
          localVideoInfo.k = paramAdvertisementInfo.mSubscribeName;
          continue;
          label371:
          localVideoInfo.p = paramAdvertisementInfo.thirdIcon;
          continue;
          label382:
          i = paramAdvertisementInfo.mVideoJsonWidth;
          continue;
          label390:
          i = paramAdvertisementInfo.mVideoJsonHeight;
        }
      }
    }
  }
  
  private void a(int paramInt, ArrayList<VideoInfo> paramArrayList)
  {
    int j = a(paramInt);
    int k = a(paramInt, j);
    d(k);
    if (QLog.isColorLevel()) {
      QLog.d("VideoAdExposureManager", 2, "onVideoReplayOnLoop , lastAdPos =" + j + " ，recordAdPos =" + k);
    }
    if (k >= paramArrayList.size()) {
      return;
    }
    int i = paramInt;
    if (i < paramArrayList.size()) {
      if (!((VideoInfo)paramArrayList.get(i)).jdField_c_of_type_Boolean) {}
    }
    for (;;)
    {
      VideoInfo localVideoInfo = null;
      if (i == -1) {
        if (this.jdField_b_of_type_JavaUtilArrayList.size() > 0)
        {
          localVideoInfo = (VideoInfo)this.jdField_b_of_type_JavaUtilArrayList.get(0);
          this.jdField_b_of_type_JavaUtilArrayList.remove(0);
        }
      }
      for (;;)
      {
        if ((localVideoInfo != null) || (j == -1) || (j >= paramArrayList.size())) {
          break label253;
        }
        ReadInJoyAdLog.a("VIDEO_LINK", "fetchChangePosAd : 当前广告位置后面没有广告");
        a((VideoInfo)paramArrayList.get(j), k);
        return;
        i += 1;
        break;
        if (QLog.isColorLevel()) {
          QLog.d("VideoAdExposureManager", 2, "onVideoReplayOnLoop , findPos =" + i + " ，startPos =" + paramInt);
        }
        localVideoInfo = (VideoInfo)paramArrayList.get(i);
        paramArrayList.remove(i);
      }
      label253:
      a(localVideoInfo, paramArrayList, k);
      return;
      i = -1;
    }
  }
  
  private void a(VideoInfo paramVideoInfo, ArrayList<VideoInfo> paramArrayList, int paramInt)
  {
    if (paramVideoInfo == null) {}
    do
    {
      return;
      paramArrayList.add(paramInt, paramVideoInfo);
      if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsAdapter != null) {
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsAdapter.a(paramVideoInfo);
      }
    } while (!QLog.isColorLevel());
    QLog.d("VideoAdExposureManager", 2, "onVideoReplayOnLoop , move!!! and notify!!! ");
  }
  
  private void a(AdvertisementInfo paramAdvertisementInfo)
  {
    paramAdvertisementInfo = a(paramAdvertisementInfo, true);
    this.jdField_a_of_type_AndroidUtilSparseArray.put(this.jdField_c_of_type_Int, paramAdvertisementInfo);
    this.jdField_c_of_type_Int = 0;
  }
  
  private void a(AdvertisementInfo paramAdvertisementInfo, int paramInt1, int paramInt2, int paramInt3)
  {
    if (paramAdvertisementInfo == null) {
      return;
    }
    if (paramInt2 == this.jdField_b_of_type_Int)
    {
      this.e = paramInt1;
      this.f = paramAdvertisementInfo.mAdKdPos;
    }
    for (;;)
    {
      AdRequestData localAdRequestData = new AdRequestData();
      localAdRequestData.jdField_a_of_type_Int = paramAdvertisementInfo.mAdMaterialId;
      localAdRequestData.jdField_b_of_type_Int = 1;
      localAdRequestData.jdField_c_of_type_Int = paramAdvertisementInfo.mAdKdPos;
      localAdRequestData.jdField_a_of_type_Long = paramAdvertisementInfo.mAdPosID;
      localAdRequestData.jdField_a_of_type_Boolean = true;
      ReadInJoyLogicEngine.a().a().a(paramInt2, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelFixPosArticleInterface$FixPosArticleAsyncListener);
      ThreadManager.executeOnSubThread(new VideoAdExposureManager.1(this, paramInt3, paramInt2, localAdRequestData));
      return;
      this.jdField_c_of_type_Int = paramInt1;
      this.jdField_d_of_type_Int = paramAdvertisementInfo.mAdKdPos;
    }
  }
  
  private void a(ArrayList<VideoInfo> paramArrayList, int paramInt)
  {
    if (paramInt >= paramArrayList.size()) {}
    do
    {
      return;
      localObject = (VideoInfo)paramArrayList.get(paramInt);
    } while ((localObject == null) || (!((VideoInfo)localObject).jdField_c_of_type_Boolean) || (((VideoInfo)localObject).jdField_a_of_type_ComTencentBizPubaccountVideoAdInfo == null) || (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsAdapter == null) || (!this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsAdapter.a.a(((VideoInfo)localObject).jdField_a_of_type_ComTencentBizPubaccountVideoAdInfo.h)));
    VideoInfo localVideoInfo = (VideoInfo)this.jdField_b_of_type_AndroidUtilSparseArray.get(paramInt);
    Object localObject = localVideoInfo;
    if (localVideoInfo == null)
    {
      localObject = localVideoInfo;
      if (this.jdField_b_of_type_JavaUtilArrayList.size() > 0)
      {
        localObject = (VideoInfo)this.jdField_b_of_type_JavaUtilArrayList.get(0);
        this.jdField_b_of_type_JavaUtilArrayList.remove(0);
      }
    }
    if (localObject != null)
    {
      b((VideoInfo)localObject, paramInt);
      return;
    }
    ReadInJoyAdLog.a("VIDEO_LINK", "fetchChangePosAd : 下一个广告存在但是已经曝光过");
    a((VideoInfo)paramArrayList.get(paramInt), paramInt);
  }
  
  private boolean a(int paramInt1, int paramInt2)
  {
    return ((paramInt1 == -1) && (paramInt2 < VideoAdStrategyManager.f) && (this.g >= VideoAdStrategyManager.f)) || (this.g >= VideoAdStrategyManager.g);
  }
  
  private boolean a(VideoFeedsPlayManager.VideoPlayParam paramVideoPlayParam)
  {
    if ((VideoAdStrategyManager.a()) && (VideoAdStrategyManager.b())) {}
    do
    {
      do
      {
        do
        {
          return false;
          paramVideoPlayParam = paramVideoPlayParam.a;
        } while ((paramVideoPlayParam == null) || (paramVideoPlayParam.jdField_c_of_type_Boolean));
        if ((VideoAdStrategyManager.jdField_a_of_type_Boolean) && (!this.jdField_a_of_type_Boolean)) {
          break;
        }
      } while (!QLog.isColorLevel());
      if (!VideoAdStrategyManager.jdField_a_of_type_Boolean) {
        QLog.d("VideoAdExposureManager", 2, "命中 调整广告位置的开关关闭 ");
      }
    } while (!this.jdField_a_of_type_Boolean);
    QLog.d("VideoAdExposureManager", 2, "该位置已经 触发过判断的情况");
    return false;
    return true;
  }
  
  private void b(VideoInfo paramVideoInfo, int paramInt)
  {
    if ((VideoAdStrategyManager.a()) && (VideoAdStrategyManager.b())) {
      return;
    }
    this.jdField_d_of_type_AndroidUtilSparseBooleanArray.put(paramInt, true);
    this.jdField_b_of_type_AndroidUtilSparseArray.put(paramInt, paramVideoInfo);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsAdapter.notifyItemChanged(paramInt);
  }
  
  private void b(AdvertisementInfo paramAdvertisementInfo)
  {
    if ((VideoAdStrategyManager.a()) && (VideoAdStrategyManager.b())) {}
    VideoInfo localVideoInfo;
    do
    {
      do
      {
        return;
        paramAdvertisementInfo = a(paramAdvertisementInfo, false);
      } while ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecyclerView == null) || (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsAdapter == null) || ((this.e >= this.jdField_a_of_type_JavaUtilList.size()) && (this.e > 0)));
      localVideoInfo = (VideoInfo)this.jdField_a_of_type_JavaUtilList.get(this.e);
      int i = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecyclerView.a();
      this.jdField_b_of_type_JavaUtilArrayList.add(paramAdvertisementInfo);
      if ((localVideoInfo != null) && (!localVideoInfo.jdField_c_of_type_Boolean) && (this.e > i))
      {
        this.jdField_b_of_type_JavaUtilArrayList.remove(paramAdvertisementInfo);
        this.jdField_a_of_type_JavaUtilList.add(this.e, paramAdvertisementInfo);
        ReadInJoyAdLog.a("AdVideoDataLink", "onAsyncDataReady add at =" + this.e + ", currentAdpaterPosition=" + i);
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsAdapter.notifyItemInserted(this.e);
        this.e = 0;
      }
    } while ((localVideoInfo == null) || (!localVideoInfo.jdField_c_of_type_Boolean) || (localVideoInfo.jdField_a_of_type_ComTencentBizPubaccountVideoAdInfo == null) || (!this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsAdapter.a.a(localVideoInfo.jdField_a_of_type_ComTencentBizPubaccountVideoAdInfo.h)));
    this.jdField_b_of_type_JavaUtilArrayList.remove(paramAdvertisementInfo);
    b(paramAdvertisementInfo, this.e);
    this.e = 0;
  }
  
  private void e(int paramInt)
  {
    for (;;)
    {
      try
      {
        if (QLog.isColorLevel()) {
          QLog.d("VideoAdExposureManager", 2, "onAsyncDataReady channelID=" + paramInt);
        }
        int i;
        if (paramInt == this.jdField_b_of_type_Int)
        {
          i = this.f;
          this.f = 0;
          AdvertisementInfo localAdvertisementInfo1 = ReadInJoyLogicEngine.a().a(paramInt, i);
          if (localAdvertisementInfo1 == null) {
            if (QLog.isColorLevel()) {
              QLog.d("VideoAdExposureManager", 2, "getVideoInfo ,not get fetch data!!!??");
            }
          }
        }
        else
        {
          i = this.jdField_d_of_type_Int;
          this.jdField_d_of_type_Int = 0;
          continue;
        }
        ReadInJoyLogicEngine.a().b(paramInt, i);
      }
      finally {}
      if (paramInt == this.jdField_b_of_type_Int) {
        b(localAdvertisementInfo2);
      } else {
        a(localAdvertisementInfo2);
      }
    }
  }
  
  public int a(int paramInt)
  {
    int j = -1;
    int i = 0;
    while (i < this.jdField_a_of_type_JavaUtilArrayList.size())
    {
      Integer localInteger = (Integer)this.jdField_a_of_type_JavaUtilArrayList.get(i);
      if (localInteger.intValue() >= paramInt) {
        break;
      }
      j = localInteger.intValue();
      i += 1;
    }
    return j;
  }
  
  public VideoInfo a(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("VideoAdExposureManager", 2, "getVideoInfo");
    }
    VideoInfo localVideoInfo2 = (VideoInfo)this.jdField_a_of_type_AndroidUtilSparseArray.get(paramInt);
    VideoInfo localVideoInfo1;
    if (localVideoInfo2 == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("VideoAdExposureManager", 2, "getVideoInfo ,not get fetch data!!!??");
      }
      localVideoInfo1 = null;
    }
    do
    {
      return localVideoInfo1;
      localVideoInfo1 = localVideoInfo2;
    } while (!QLog.isColorLevel());
    QLog.d("VideoAdExposureManager", 2, "getVideoInfo ,videoInfo");
    return localVideoInfo2;
  }
  
  public void a()
  {
    AdvertisementInfoModule localAdvertisementInfoModule = ReadInJoyLogicEngine.a().a();
    if (localAdvertisementInfoModule != null)
    {
      localAdvertisementInfoModule.a(this.jdField_a_of_type_Int);
      localAdvertisementInfoModule.a(this.jdField_b_of_type_Int);
    }
  }
  
  public void a(int paramInt)
  {
    this.jdField_b_of_type_AndroidUtilSparseBooleanArray.put(paramInt, true);
    if (QLog.isColorLevel()) {
      QLog.d("VideoAdExposureManager", 2, "hasShowAnotherAd");
    }
  }
  
  public void a(int paramInt1, int paramInt2, VideoInfo paramVideoInfo)
  {
    if ((VideoAdStrategyManager.a()) && (VideoAdStrategyManager.b())) {
      return;
    }
    int j = this.jdField_a_of_type_JavaUtilList.size();
    int i = 0;
    if (i < this.jdField_a_of_type_JavaUtilList.size()) {
      if ((!((VideoInfo)this.jdField_a_of_type_JavaUtilList.get(i)).jdField_c_of_type_Boolean) || (i == paramInt1)) {}
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("VideoAdExposureManager", 2, "adapterPosition = " + paramInt1 + " ,size = " + j + " ,nextAdPosition = " + i);
      }
      a(paramInt2);
      c(paramInt2);
      b(paramVideoInfo, paramInt1);
      return;
      i += 1;
      break;
      i = 0;
    }
  }
  
  public void a(int paramInt, VideoFeedsPlayManager.VideoPlayParam paramVideoPlayParam, ArrayList<VideoInfo> paramArrayList)
  {
    VideoAdStrategyManager.a(paramVideoPlayParam);
    if ((VideoAdStrategyManager.a()) && (VideoAdStrategyManager.b())) {}
    for (;;)
    {
      return;
      if ((paramVideoPlayParam != null) && (paramVideoPlayParam.a != null) && (VideoAdStrategyManager.jdField_a_of_type_Boolean))
      {
        if (!paramVideoPlayParam.a.jdField_c_of_type_Boolean)
        {
          if (QLog.isColorLevel()) {
            QLog.d("VideoAdExposureManager", 2, "checkAndInsert , mPlayVmCount=" + this.g);
          }
          b(paramInt, paramVideoPlayParam, paramArrayList);
        }
        while (QLog.isColorLevel())
        {
          QLog.d("VideoAdExposureManager", 2, "onVideoStart , mPlayVmCount =" + this.g);
          return;
          this.g = 0;
          if (QLog.isColorLevel()) {
            QLog.d("VideoAdExposureManager", 2, "checkAndInsert , mPlayVmCount= 0 ");
          }
        }
      }
    }
  }
  
  public void a(VideoAdInfo paramVideoAdInfo, int paramInt)
  {
    if ((VideoAdStrategyManager.a()) && (VideoAdStrategyManager.b())) {}
    VideoInfo localVideoInfo;
    boolean bool1;
    boolean bool2;
    do
    {
      do
      {
        return;
      } while (paramVideoAdInfo == null);
      localVideoInfo = (VideoInfo)this.jdField_a_of_type_AndroidUtilSparseArray.get(paramInt);
      bool1 = this.jdField_a_of_type_AndroidUtilSparseBooleanArray.get(paramInt);
      bool2 = this.jdField_c_of_type_AndroidUtilSparseBooleanArray.get(paramInt);
    } while ((bool1) || (localVideoInfo != null) || (bool2));
    this.jdField_a_of_type_AndroidUtilSparseBooleanArray.put(paramInt, true);
    paramVideoAdInfo = NativeAdUtils.a(paramVideoAdInfo);
    if (QLog.isColorLevel()) {
      QLog.d("VideoAdExposureManager", 2, "fetchAnotherAd !!! , pos=" + paramInt);
    }
    a(paramVideoAdInfo, paramInt, this.jdField_a_of_type_Int, 5);
  }
  
  public void a(VideoInfo paramVideoInfo, int paramInt)
  {
    if ((VideoAdStrategyManager.a()) && (VideoAdStrategyManager.b())) {}
    while ((paramVideoInfo == null) || (paramVideoInfo.jdField_a_of_type_ComTencentBizPubaccountVideoAdInfo == null)) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("VideoAdExposureManager", 2, "fetchChangePosAd insert wait pos = " + paramInt);
    }
    a(NativeAdUtils.a(paramVideoInfo.jdField_a_of_type_ComTencentBizPubaccountVideoAdInfo), paramInt, this.jdField_b_of_type_Int, 6);
  }
  
  /* Error */
  public void a(com.tencent.biz.pubaccount.readinjoy.video.videofeeds.BaseVideoItemHolder paramBaseVideoItemHolder)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: invokestatic 408	com/tencent/biz/pubaccount/readinjoyAd/ad/video/strategy/VideoAdStrategyManager:a	()Z
    //   5: ifeq +14 -> 19
    //   8: invokestatic 410	com/tencent/biz/pubaccount/readinjoyAd/ad/video/strategy/VideoAdStrategyManager:b	()Z
    //   11: istore_2
    //   12: iload_2
    //   13: ifeq +6 -> 19
    //   16: aload_0
    //   17: monitorexit
    //   18: return
    //   19: getstatic 416	com/tencent/biz/pubaccount/readinjoyAd/ad/video/strategy/VideoAdStrategyManager:jdField_a_of_type_Boolean	Z
    //   22: ifeq -6 -> 16
    //   25: aload_0
    //   26: iconst_0
    //   27: putfield 417	com/tencent/biz/pubaccount/readinjoyAd/ad/video/strategy/VideoAdExposureManager:jdField_a_of_type_Boolean	Z
    //   30: aload_1
    //   31: ifnull -15 -> 16
    //   34: aload_1
    //   35: getfield 514	com/tencent/biz/pubaccount/readinjoy/video/videofeeds/BaseVideoItemHolder:a	Lcom/tencent/biz/pubaccount/readinjoy/video/VideoFeedsPlayManager$VideoPlayParam;
    //   38: ifnull -22 -> 16
    //   41: aload_1
    //   42: getfield 514	com/tencent/biz/pubaccount/readinjoy/video/videofeeds/BaseVideoItemHolder:a	Lcom/tencent/biz/pubaccount/readinjoy/video/VideoFeedsPlayManager$VideoPlayParam;
    //   45: getfield 415	com/tencent/biz/pubaccount/readinjoy/video/VideoFeedsPlayManager$VideoPlayParam:a	Lcom/tencent/biz/pubaccount/VideoInfo;
    //   48: ifnull -32 -> 16
    //   51: aload_1
    //   52: getfield 514	com/tencent/biz/pubaccount/readinjoy/video/videofeeds/BaseVideoItemHolder:a	Lcom/tencent/biz/pubaccount/readinjoy/video/VideoFeedsPlayManager$VideoPlayParam;
    //   55: getfield 415	com/tencent/biz/pubaccount/readinjoy/video/VideoFeedsPlayManager$VideoPlayParam:a	Lcom/tencent/biz/pubaccount/VideoInfo;
    //   58: getfield 125	com/tencent/biz/pubaccount/VideoInfo:jdField_c_of_type_Boolean	Z
    //   61: ifeq -45 -> 16
    //   64: aload_1
    //   65: getfield 514	com/tencent/biz/pubaccount/readinjoy/video/videofeeds/BaseVideoItemHolder:a	Lcom/tencent/biz/pubaccount/readinjoy/video/VideoFeedsPlayManager$VideoPlayParam;
    //   68: getfield 415	com/tencent/biz/pubaccount/readinjoy/video/VideoFeedsPlayManager$VideoPlayParam:a	Lcom/tencent/biz/pubaccount/VideoInfo;
    //   71: getfield 133	com/tencent/biz/pubaccount/VideoInfo:jdField_a_of_type_ComTencentBizPubaccountVideoAdInfo	Lcom/tencent/biz/pubaccount/VideoAdInfo;
    //   74: ifnull -58 -> 16
    //   77: aload_0
    //   78: aload_1
    //   79: getfield 515	com/tencent/biz/pubaccount/readinjoy/video/videofeeds/BaseVideoItemHolder:jdField_b_of_type_Int	I
    //   82: invokevirtual 282	com/tencent/biz/pubaccount/readinjoyAd/ad/video/strategy/VideoAdExposureManager:d	(I)V
    //   85: invokestatic 244	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   88: ifeq -72 -> 16
    //   91: ldc 246
    //   93: iconst_2
    //   94: new 248	java/lang/StringBuilder
    //   97: dup
    //   98: invokespecial 249	java/lang/StringBuilder:<init>	()V
    //   101: ldc_w 517
    //   104: invokevirtual 255	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   107: aload_1
    //   108: getfield 515	com/tencent/biz/pubaccount/readinjoy/video/videofeeds/BaseVideoItemHolder:jdField_b_of_type_Int	I
    //   111: invokevirtual 287	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   114: invokevirtual 258	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   117: invokestatic 261	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   120: goto -104 -> 16
    //   123: astore_1
    //   124: aload_0
    //   125: monitorexit
    //   126: aload_1
    //   127: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	128	0	this	VideoAdExposureManager
    //   0	128	1	paramBaseVideoItemHolder	com.tencent.biz.pubaccount.readinjoy.video.videofeeds.BaseVideoItemHolder
    //   11	2	2	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   2	12	123	finally
    //   19	30	123	finally
    //   34	120	123	finally
  }
  
  public void a(boolean paramBoolean)
  {
    this.jdField_b_of_type_Boolean = paramBoolean;
  }
  
  public void a(boolean paramBoolean, int paramInt, ArrayList<VideoInfo> paramArrayList)
  {
    boolean bool1 = false;
    for (;;)
    {
      int j;
      int i;
      try
      {
        if (QLog.isColorLevel()) {
          QLog.d("VideoAdExposureManager", 2, "checkAdPos , hasQueryParam= " + VideoAdStrategyManager.jdField_b_of_type_Boolean + " ,needChangeAdPos =" + VideoAdStrategyManager.jdField_a_of_type_Boolean);
        }
        if (VideoAdStrategyManager.jdField_b_of_type_Boolean)
        {
          boolean bool2 = VideoAdStrategyManager.jdField_a_of_type_Boolean;
          if (!bool2) {
            return;
          }
        }
        if (QLog.isColorLevel()) {
          QLog.d("VideoAdExposureManager", 2, "checkAdPos enter, hasNewVideo= " + paramBoolean + " ,newSize =" + paramInt);
        }
        if ((!paramBoolean) || (paramInt <= 1)) {
          continue;
        }
        j = paramArrayList.size();
        i = j - paramInt;
        paramInt = i;
        if (paramInt >= paramArrayList.size()) {
          break label1039;
        }
        if ((((VideoInfo)paramArrayList.get(paramInt)).jdField_c_of_type_Boolean) && (((VideoInfo)paramArrayList.get(paramInt)).jdField_a_of_type_ComTencentBizPubaccountVideoAdInfo != null))
        {
          if (paramInt != -1) {
            break label210;
          }
          if (QLog.isColorLevel()) {
            QLog.d("VideoAdExposureManager", 2, "checkAdPos can not find Ad !!");
          }
          VideoAdStrategyManager.a();
          continue;
        }
        paramInt += 1;
      }
      finally {}
      continue;
      label210:
      if (QLog.isColorLevel()) {
        QLog.d("VideoAdExposureManager", 2, "checkAdPos findAdIndex = " + paramInt);
      }
      VideoInfo localVideoInfo = (VideoInfo)paramArrayList.get(paramInt);
      Object localObject;
      if (!VideoAdStrategyManager.jdField_b_of_type_Boolean)
      {
        VideoAdStrategyManager.jdField_b_of_type_Boolean = true;
        paramBoolean = bool1;
        if (ReadInJoyAdSwitchUtil.f(localVideoInfo.jdField_a_of_type_ComTencentBizPubaccountVideoAdInfo))
        {
          paramBoolean = bool1;
          if (this.jdField_b_of_type_Boolean) {
            paramBoolean = true;
          }
        }
        VideoAdStrategyManager.jdField_a_of_type_Boolean = paramBoolean;
        localObject = localVideoInfo.jdField_a_of_type_ComTencentBizPubaccountVideoAdInfo.v;
      }
      label796:
      int k;
      try
      {
        localObject = new JSONObject((String)localObject);
        if (((JSONObject)localObject).has("strategy"))
        {
          VideoAdStrategyManager.jdField_a_of_type_Int = ((JSONObject)localObject).optInt("strategy", 0);
          if (VideoAdStrategyManager.jdField_a_of_type_Int == 3) {
            VideoAdStrategyManager.jdField_c_of_type_Boolean = true;
          }
        }
        for (;;)
        {
          VideoAdStrategyManager.f = ((JSONObject)localObject).optInt("ad_first_pos", 3);
          VideoAdStrategyManager.g = ((JSONObject)localObject).optInt("ad_interval", 3);
          VideoAdStrategyManager.h = ((JSONObject)localObject).optInt("ad_protect_interval", 2);
          VideoAdStrategyManager.jdField_b_of_type_Int = ((JSONObject)localObject).optInt("ad_first_time", 10);
          VideoAdStrategyManager.jdField_c_of_type_Int = ((JSONObject)localObject).optInt("ad_interval_time", 25);
          VideoAdStrategyManager.jdField_d_of_type_Int = ((JSONObject)localObject).optInt("ad_pre_req", 2);
          VideoAdStrategyManager.e = ((JSONObject)localObject).optInt("ad_protect_gap", 2);
          VideoAdStrategyManager.i = ((JSONObject)localObject).optInt("first_stay_time", 3);
          VideoAdStrategyManager.j = ((JSONObject)localObject).optInt("ad_vv_interval_first", 0);
          VideoAdStrategyManager.k = ((JSONObject)localObject).optInt("ad_vv_interval_second", 0);
          VideoAdStrategyManager.l = ((JSONObject)localObject).optInt("ad_vv_interval_other", 0);
          if ((VideoAdStrategyManager.jdField_a_of_type_Int == 3) && (VideoAdStrategyManager.jdField_b_of_type_Int <= VideoAdStrategyManager.i)) {
            VideoAdStrategyManager.jdField_a_of_type_Int = 2;
          }
          ReadInJoyAdLog.a("VideoAdStrategy", "setAdStrategyFromServer: strategy = " + VideoAdStrategyManager.jdField_a_of_type_Int + " adFirstTime = " + VideoAdStrategyManager.jdField_b_of_type_Int + " adIntervalTime = " + VideoAdStrategyManager.jdField_c_of_type_Int + " adPreReq = " + VideoAdStrategyManager.jdField_d_of_type_Int + " adProtectGap = " + VideoAdStrategyManager.e + " adFirstPos = " + VideoAdStrategyManager.f + " adIntervalPos = " + VideoAdStrategyManager.g + " adProtectInterval = " + VideoAdStrategyManager.h + " adVvFirst = " + VideoAdStrategyManager.j + " adSecond = " + VideoAdStrategyManager.k + " adOther = " + VideoAdStrategyManager.l);
          VideoAdStrategyManager.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.compareAndSet(false, true);
          if (VideoAdStrategyManager.jdField_a_of_type_Int == 1)
          {
            localObject = VideoAdTimeLoadManager.a(paramArrayList);
            if (localObject != null) {
              paramArrayList.removeAll((Collection)localObject);
            }
          }
          if (VideoAdStrategyManager.jdField_a_of_type_Int == 3) {
            VideoAdTimeLoadManager.a(paramArrayList);
          }
          if (QLog.isColorLevel()) {
            QLog.d("VideoAdExposureManager", 2, "checkAdPos needChangeAdPos = " + VideoAdStrategyManager.jdField_a_of_type_Boolean);
          }
          if (((VideoAdStrategyManager.a()) && (VideoAdStrategyManager.b())) || (!VideoAdStrategyManager.jdField_a_of_type_Boolean)) {
            break;
          }
          if (!this.jdField_a_of_type_JavaUtilArrayList.isEmpty()) {
            break label796;
          }
          if (!QLog.isColorLevel()) {
            break;
          }
          QLog.d("VideoAdExposureManager", 2, "mInsertAdPos.isEmpty()");
          break;
          VideoAdStrategyManager.jdField_a_of_type_Int = 2;
        }
      }
      catch (JSONException localJSONException)
      {
        for (;;)
        {
          localJSONException.printStackTrace();
          VideoAdStrategyManager.jdField_a_of_type_Boolean = false;
        }
        k = ((Integer)this.jdField_a_of_type_JavaUtilArrayList.get(this.jdField_a_of_type_JavaUtilArrayList.size() - 1)).intValue();
        if ((j - 1 > k) && (k >= i))
        {
          if (paramInt == k) {
            continue;
          }
          if (QLog.isColorLevel()) {
            QLog.d("VideoAdExposureManager", 2, "checkAdPos change findAdIndex=" + paramInt + ", lastNeedInsertAdPos=" + k);
          }
          if (k >= paramArrayList.size()) {
            continue;
          }
          paramArrayList.set(paramInt, (VideoInfo)paramArrayList.get(k));
          paramArrayList.set(k, localVideoInfo);
        }
      }
      if (localVideoInfo.jdField_a_of_type_ComTencentBizPubaccountVideoAdInfo != null)
      {
        i = k + VideoAdStrategyManager.h;
        if (i > paramInt)
        {
          if (QLog.isColorLevel()) {
            QLog.d("VideoAdExposureManager", 2, "checkAdPos change findAdIndex=" + paramInt + ", lastNeedInsertAdPos=" + k + ", minAdIndex=" + i);
          }
          if (i < paramArrayList.size())
          {
            paramArrayList.set(paramInt, (VideoInfo)paramArrayList.get(i));
            paramArrayList.set(i, localVideoInfo);
            d(i);
            continue;
            label1039:
            paramInt = -1;
          }
        }
      }
    }
  }
  
  public boolean a(int paramInt)
  {
    boolean bool = this.jdField_b_of_type_AndroidUtilSparseBooleanArray.get(paramInt);
    if (QLog.isColorLevel()) {
      QLog.d("VideoAdExposureManager", 2, "isNeedShowAnotherAd pos=" + paramInt + ",result =" + bool);
    }
    return bool;
  }
  
  public int b(int paramInt)
  {
    int i = 0;
    while (i < this.jdField_a_of_type_JavaUtilArrayList.size())
    {
      Integer localInteger = (Integer)this.jdField_a_of_type_JavaUtilArrayList.get(i);
      if (localInteger.intValue() > paramInt) {
        return localInteger.intValue();
      }
      i += 1;
    }
    return -1;
  }
  
  public VideoInfo b(int paramInt)
  {
    if ((VideoAdStrategyManager.a()) && (VideoAdStrategyManager.b())) {
      return null;
    }
    boolean bool = this.jdField_d_of_type_AndroidUtilSparseBooleanArray.get(paramInt);
    VideoInfo localVideoInfo = (VideoInfo)this.jdField_b_of_type_AndroidUtilSparseArray.get(paramInt);
    if ((bool) && (localVideoInfo != null))
    {
      if (QLog.isColorLevel()) {
        QLog.d("VideoAdExposureManager", 2, "onAsyncDataReady replace at =" + this.e + ", currentAdpaterPosition=" + paramInt);
      }
      this.jdField_d_of_type_AndroidUtilSparseBooleanArray.put(paramInt, false);
      this.jdField_b_of_type_AndroidUtilSparseArray.remove(paramInt);
      return localVideoInfo;
    }
    return null;
  }
  
  public void b(int paramInt)
  {
    if ((VideoAdStrategyManager.a()) && (VideoAdStrategyManager.b())) {}
    while ((VideoInfo)this.jdField_a_of_type_AndroidUtilSparseArray.get(paramInt) != null) {
      return;
    }
    this.jdField_a_of_type_AndroidUtilSparseBooleanArray.put(paramInt, false);
  }
  
  public void b(int paramInt, VideoFeedsPlayManager.VideoPlayParam paramVideoPlayParam, ArrayList<VideoInfo> paramArrayList)
  {
    int i = 0;
    for (;;)
    {
      try
      {
        ReadInJoyAdLog.a("VideoAdExposureManager", "insertAd");
        VideoAdStrategyManager.a(paramVideoPlayParam);
        boolean bool = a(paramVideoPlayParam);
        if (!bool) {
          return;
        }
        this.g += 1;
        int j = b(paramInt);
        if (j != -1) {
          i = 1;
        }
        if (QLog.isColorLevel()) {
          QLog.d("VideoAdExposureManager", 2, "nextAdPos =" + j + ", insertAd , mPlayVmCount=" + this.g);
        }
        if ((i != 0) || (paramArrayList.size() <= paramInt + 1) || (!((VideoInfo)paramArrayList.get(paramInt + 1)).jdField_c_of_type_Boolean))
        {
          int k = a(paramInt);
          bool = a(k, paramInt);
          if (QLog.isColorLevel()) {
            QLog.d("VideoAdExposureManager", 2, "isCountEnough =" + bool + ",position =" + paramInt + ",lastAdPos1 =" + k);
          }
          if (bool)
          {
            this.g = 0;
            this.jdField_a_of_type_Boolean = true;
            if (i == 0) {
              a(paramInt, paramArrayList);
            } else {
              a(paramArrayList, j);
            }
          }
        }
      }
      finally {}
    }
  }
  
  public void c(int paramInt)
  {
    this.jdField_a_of_type_AndroidUtilSparseArray.remove(paramInt);
    this.jdField_c_of_type_AndroidUtilSparseBooleanArray.put(paramInt, true);
    if (QLog.isColorLevel()) {
      QLog.d("VideoAdExposureManager", 2, "removeCacheVideoInfo ");
    }
  }
  
  /* Error */
  public void d(int paramInt)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: invokestatic 408	com/tencent/biz/pubaccount/readinjoyAd/ad/video/strategy/VideoAdStrategyManager:a	()Z
    //   5: ifeq +14 -> 19
    //   8: invokestatic 410	com/tencent/biz/pubaccount/readinjoyAd/ad/video/strategy/VideoAdStrategyManager:b	()Z
    //   11: istore_2
    //   12: iload_2
    //   13: ifeq +6 -> 19
    //   16: aload_0
    //   17: monitorexit
    //   18: return
    //   19: aload_0
    //   20: getfield 65	com/tencent/biz/pubaccount/readinjoyAd/ad/video/strategy/VideoAdExposureManager:jdField_a_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   23: iload_1
    //   24: invokestatic 697	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   27: invokevirtual 700	java/util/ArrayList:contains	(Ljava/lang/Object;)Z
    //   30: ifne -14 -> 16
    //   33: invokestatic 244	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   36: ifeq +29 -> 65
    //   39: ldc 246
    //   41: iconst_2
    //   42: new 248	java/lang/StringBuilder
    //   45: dup
    //   46: invokespecial 249	java/lang/StringBuilder:<init>	()V
    //   49: ldc_w 702
    //   52: invokevirtual 255	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   55: iload_1
    //   56: invokevirtual 287	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   59: invokevirtual 258	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   62: invokestatic 261	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   65: aload_0
    //   66: getfield 65	com/tencent/biz/pubaccount/readinjoyAd/ad/video/strategy/VideoAdExposureManager:jdField_a_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   69: iload_1
    //   70: invokestatic 697	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   73: invokevirtual 438	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   76: pop
    //   77: goto -61 -> 16
    //   80: astore_3
    //   81: aload_0
    //   82: monitorexit
    //   83: aload_3
    //   84: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	85	0	this	VideoAdExposureManager
    //   0	85	1	paramInt	int
    //   11	2	2	bool	boolean
    //   80	4	3	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	12	80	finally
    //   19	65	80	finally
    //   65	77	80	finally
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoyAd.ad.video.strategy.VideoAdExposureManager
 * JD-Core Version:    0.7.0.1
 */