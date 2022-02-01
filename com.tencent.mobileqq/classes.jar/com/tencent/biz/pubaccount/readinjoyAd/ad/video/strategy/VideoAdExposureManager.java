package com.tencent.biz.pubaccount.readinjoyAd.ad.video.strategy;

import android.os.Handler;
import android.util.SparseArray;
import android.util.SparseBooleanArray;
import com.tencent.biz.pubaccount.NativeAd.data.AdRequestData;
import com.tencent.biz.pubaccount.readinjoy.struct.AdvertisementInfo;
import com.tencent.biz.pubaccount.readinjoyAd.ad.utils.ReadInJoyAdLog;
import com.tencent.biz.pubaccount.readinjoyAd.ad.utils.ReadInJoyAdSwitchUtil;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.kandian.ad.api.IRIJAdEntityConvertService;
import com.tencent.mobileqq.kandian.ad.api.IRIJAdLogService;
import com.tencent.mobileqq.kandian.ad.api.entity.IVideoAdExposureManager;
import com.tencent.mobileqq.kandian.biz.ad.entity.VideoAdInfo;
import com.tencent.mobileqq.kandian.biz.feeds.api.FixPosArticleInterface.FixPosArticleAsyncListener;
import com.tencent.mobileqq.kandian.biz.framework.api.IReadInJoyUtils;
import com.tencent.mobileqq.kandian.biz.video.api.IBaseVideoItemHolder;
import com.tencent.mobileqq.kandian.biz.video.playfeeds.api.IVideoFeedsAdapter;
import com.tencent.mobileqq.kandian.biz.video.playfeeds.entity.VideoInfo;
import com.tencent.mobileqq.kandian.biz.video.playfeeds.entity.VideoPlayParam;
import com.tencent.mobileqq.kandian.biz.video.playfeeds.view.VideoFeedsRecyclerView;
import com.tencent.mobileqq.kandian.glue.msf.api.IReadInJoyLogicEngineFactory;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import mqq.app.AppRuntime;
import org.json.JSONException;
import org.json.JSONObject;

public class VideoAdExposureManager
  implements IVideoAdExposureManager
{
  private int jdField_a_of_type_Int = 78888888;
  private Handler jdField_a_of_type_AndroidOsHandler;
  private SparseArray<VideoInfo> jdField_a_of_type_AndroidUtilSparseArray = new SparseArray();
  private SparseBooleanArray jdField_a_of_type_AndroidUtilSparseBooleanArray = new SparseBooleanArray();
  private FixPosArticleInterface.FixPosArticleAsyncListener jdField_a_of_type_ComTencentMobileqqKandianBizFeedsApiFixPosArticleInterface$FixPosArticleAsyncListener;
  private IVideoFeedsAdapter jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsApiIVideoFeedsAdapter;
  private VideoFeedsRecyclerView jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsViewVideoFeedsRecyclerView;
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
  
  public VideoAdExposureManager(IVideoFeedsAdapter paramIVideoFeedsAdapter, List<VideoInfo> paramList, VideoFeedsRecyclerView paramVideoFeedsRecyclerView, Handler paramHandler)
  {
    this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsApiIVideoFeedsAdapter = paramIVideoFeedsAdapter;
    this.jdField_a_of_type_JavaUtilList = paramList;
    this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsViewVideoFeedsRecyclerView = paramVideoFeedsRecyclerView;
    this.jdField_a_of_type_AndroidOsHandler = paramHandler;
    ((IReadInJoyUtils)QRoute.api(IReadInJoyUtils.class)).getAppRuntime().getManager(QQManagerFactory.READINJOY_LOGIC_MANAGER);
    this.jdField_a_of_type_ComTencentMobileqqKandianBizFeedsApiFixPosArticleInterface$FixPosArticleAsyncListener = new VideoAdExposureManager.PosListener(this);
  }
  
  private int a(int paramInt1, int paramInt2)
  {
    if (paramInt2 == -1) {
      return paramInt1 + 1;
    }
    return Math.max(paramInt2 + VideoAdStrategyManager.h + 1, paramInt1 + 1);
  }
  
  public static VideoInfo a(AdvertisementInfo paramAdvertisementInfo, boolean paramBoolean)
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.copyTypes(TypeTransformer.java:311)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.fixTypes(TypeTransformer.java:226)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:207)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
  
  private void a(int paramInt, ArrayList<VideoInfo> paramArrayList)
  {
    int j = a(paramInt);
    int k = a(paramInt, j);
    d(k);
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("onVideoReplayOnLoop , lastAdPos =");
      ((StringBuilder)localObject).append(j);
      ((StringBuilder)localObject).append(" ，recordAdPos =");
      ((StringBuilder)localObject).append(k);
      QLog.d("VideoAdExposureManager", 2, ((StringBuilder)localObject).toString());
    }
    if (k >= paramArrayList.size()) {
      return;
    }
    int i = paramInt;
    while (i < paramArrayList.size())
    {
      if (((VideoInfo)paramArrayList.get(i)).r) {
        break label126;
      }
      i += 1;
    }
    i = -1;
    label126:
    Object localObject = null;
    if (i == -1)
    {
      if (this.jdField_b_of_type_JavaUtilArrayList.size() > 0)
      {
        localObject = (VideoInfo)this.jdField_b_of_type_JavaUtilArrayList.get(0);
        this.jdField_b_of_type_JavaUtilArrayList.remove(0);
      }
    }
    else
    {
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("onVideoReplayOnLoop , findPos =");
        ((StringBuilder)localObject).append(i);
        ((StringBuilder)localObject).append(" ，startPos =");
        ((StringBuilder)localObject).append(paramInt);
        QLog.d("VideoAdExposureManager", 2, ((StringBuilder)localObject).toString());
      }
      localObject = (VideoInfo)paramArrayList.get(i);
      paramArrayList.remove(i);
    }
    if ((localObject == null) && (j != -1) && (j < paramArrayList.size()))
    {
      ((IRIJAdLogService)QRoute.api(IRIJAdLogService.class)).d("VIDEO_LINK", "fetchChangePosAd : 当前广告位置后面没有广告");
      a((VideoInfo)paramArrayList.get(j), k);
      return;
    }
    a((VideoInfo)localObject, paramArrayList, k);
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
    else
    {
      this.jdField_c_of_type_Int = paramInt1;
      this.jdField_d_of_type_Int = paramAdvertisementInfo.mAdKdPos;
    }
    AdRequestData localAdRequestData = new AdRequestData();
    localAdRequestData.jdField_a_of_type_Int = paramAdvertisementInfo.mAdMaterialId;
    localAdRequestData.jdField_b_of_type_Int = 1;
    localAdRequestData.jdField_c_of_type_Int = paramAdvertisementInfo.mAdKdPos;
    localAdRequestData.jdField_a_of_type_Long = paramAdvertisementInfo.mAdPosID;
    localAdRequestData.jdField_a_of_type_Boolean = true;
    ((IReadInJoyLogicEngineFactory)QRoute.api(IReadInJoyLogicEngineFactory.class)).setFixPosArticleAsyncListener(paramInt2, this.jdField_a_of_type_ComTencentMobileqqKandianBizFeedsApiFixPosArticleInterface$FixPosArticleAsyncListener);
    ThreadManager.executeOnSubThread(new VideoAdExposureManager.1(this, paramInt3, paramInt2, localAdRequestData));
  }
  
  private void a(VideoInfo paramVideoInfo, ArrayList<VideoInfo> paramArrayList, int paramInt)
  {
    if (paramVideoInfo == null) {
      return;
    }
    paramArrayList.add(paramInt, paramVideoInfo);
    paramVideoInfo = this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsApiIVideoFeedsAdapter;
    if (QLog.isColorLevel()) {
      QLog.d("VideoAdExposureManager", 2, "onVideoReplayOnLoop , move!!! and notify!!! ");
    }
  }
  
  private void a(ArrayList<VideoInfo> paramArrayList, int paramInt)
  {
    if (paramInt >= paramArrayList.size()) {
      return;
    }
    Object localObject1 = (VideoInfo)paramArrayList.get(paramInt);
    if ((localObject1 != null) && (((VideoInfo)localObject1).r) && (((VideoInfo)localObject1).a != null))
    {
      Object localObject2 = this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsApiIVideoFeedsAdapter;
      if ((localObject2 != null) && (((IVideoFeedsAdapter)localObject2).a(((VideoInfo)localObject1).a.h)))
      {
        localObject2 = (VideoInfo)this.jdField_b_of_type_AndroidUtilSparseArray.get(paramInt);
        localObject1 = localObject2;
        if (localObject2 == null)
        {
          localObject1 = localObject2;
          if (this.jdField_b_of_type_JavaUtilArrayList.size() > 0)
          {
            localObject1 = (VideoInfo)this.jdField_b_of_type_JavaUtilArrayList.get(0);
            this.jdField_b_of_type_JavaUtilArrayList.remove(0);
          }
        }
        if (localObject1 != null)
        {
          b((VideoInfo)localObject1, paramInt);
          return;
        }
        ((IRIJAdLogService)QRoute.api(IRIJAdLogService.class)).d("VIDEO_LINK", "fetchChangePosAd : 下一个广告存在但是已经曝光过");
        a((VideoInfo)paramArrayList.get(paramInt), paramInt);
      }
    }
  }
  
  private boolean a(int paramInt1, int paramInt2)
  {
    return ((paramInt1 == -1) && (paramInt2 < VideoAdStrategyManager.f) && (this.g >= VideoAdStrategyManager.f)) || (this.g >= VideoAdStrategyManager.g);
  }
  
  private boolean a(VideoPlayParam paramVideoPlayParam)
  {
    if ((VideoAdStrategyManager.b()) && (VideoAdStrategyManager.d())) {
      return false;
    }
    paramVideoPlayParam = paramVideoPlayParam.a;
    if (paramVideoPlayParam != null)
    {
      if (paramVideoPlayParam.r) {
        return false;
      }
      if ((VideoAdStrategyManager.jdField_a_of_type_Boolean) && (!this.jdField_a_of_type_Boolean)) {
        return true;
      }
      if (QLog.isColorLevel())
      {
        if (!VideoAdStrategyManager.jdField_a_of_type_Boolean) {
          QLog.d("VideoAdExposureManager", 2, "命中 调整广告位置的开关关闭 ");
        }
        if (this.jdField_a_of_type_Boolean) {
          QLog.d("VideoAdExposureManager", 2, "该位置已经 触发过判断的情况");
        }
      }
    }
    return false;
  }
  
  private void b(AdvertisementInfo paramAdvertisementInfo)
  {
    if ((VideoAdStrategyManager.b()) && (VideoAdStrategyManager.d())) {
      return;
    }
    paramAdvertisementInfo = a(paramAdvertisementInfo, false);
    if ((this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsViewVideoFeedsRecyclerView != null) && (this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsApiIVideoFeedsAdapter != null) && ((this.e < this.jdField_a_of_type_JavaUtilList.size()) || (this.e <= 0)))
    {
      VideoInfo localVideoInfo = (VideoInfo)this.jdField_a_of_type_JavaUtilList.get(this.e);
      int i = this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsViewVideoFeedsRecyclerView.a();
      this.jdField_b_of_type_JavaUtilArrayList.add(paramAdvertisementInfo);
      if ((localVideoInfo != null) && (!localVideoInfo.r) && (this.e > i))
      {
        this.jdField_b_of_type_JavaUtilArrayList.remove(paramAdvertisementInfo);
        this.jdField_a_of_type_JavaUtilList.add(this.e, paramAdvertisementInfo);
        IRIJAdLogService localIRIJAdLogService = (IRIJAdLogService)QRoute.api(IRIJAdLogService.class);
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("onAsyncDataReady add at =");
        localStringBuilder.append(this.e);
        localStringBuilder.append(", currentAdpaterPosition=");
        localStringBuilder.append(i);
        localIRIJAdLogService.d("AdVideoDataLink", localStringBuilder.toString());
        this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsApiIVideoFeedsAdapter.notifyItemInserted(this.e);
        this.e = 0;
      }
      if ((localVideoInfo != null) && (localVideoInfo.r) && (localVideoInfo.a != null) && (this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsApiIVideoFeedsAdapter.a(localVideoInfo.a.h)))
      {
        this.jdField_b_of_type_JavaUtilArrayList.remove(paramAdvertisementInfo);
        b(paramAdvertisementInfo, this.e);
        this.e = 0;
      }
    }
  }
  
  private void b(VideoInfo paramVideoInfo, int paramInt)
  {
    if ((VideoAdStrategyManager.b()) && (VideoAdStrategyManager.d())) {
      return;
    }
    this.jdField_d_of_type_AndroidUtilSparseBooleanArray.put(paramInt, true);
    this.jdField_b_of_type_AndroidUtilSparseArray.put(paramInt, paramVideoInfo);
    this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsApiIVideoFeedsAdapter.notifyItemChanged(paramInt);
  }
  
  private void e(int paramInt)
  {
    try
    {
      if (QLog.isColorLevel())
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("onAsyncDataReady channelID=");
        ((StringBuilder)localObject1).append(paramInt);
        QLog.d("VideoAdExposureManager", 2, ((StringBuilder)localObject1).toString());
      }
      int i;
      if (paramInt == this.jdField_b_of_type_Int)
      {
        i = this.f;
        this.f = 0;
      }
      else
      {
        i = this.jdField_d_of_type_Int;
        this.jdField_d_of_type_Int = 0;
      }
      Object localObject1 = (AdvertisementInfo)((IReadInJoyLogicEngineFactory)QRoute.api(IReadInJoyLogicEngineFactory.class)).getAdvertisementInfo(paramInt, i);
      if (localObject1 == null)
      {
        if (QLog.isColorLevel()) {
          QLog.d("VideoAdExposureManager", 2, "getVideoInfo ,not get fetch data!!!??");
        }
        return;
      }
      ((IReadInJoyLogicEngineFactory)QRoute.api(IReadInJoyLogicEngineFactory.class)).removeAdvertisementInfo(paramInt, i);
      if (paramInt == this.jdField_b_of_type_Int) {
        b((AdvertisementInfo)localObject1);
      } else {
        a((AdvertisementInfo)localObject1);
      }
      return;
    }
    finally {}
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
    VideoInfo localVideoInfo = (VideoInfo)this.jdField_a_of_type_AndroidUtilSparseArray.get(paramInt);
    if (localVideoInfo == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("VideoAdExposureManager", 2, "getVideoInfo ,not get fetch data!!!??");
      }
      return null;
    }
    if (QLog.isColorLevel()) {
      QLog.d("VideoAdExposureManager", 2, "getVideoInfo ,videoInfo");
    }
    return localVideoInfo;
  }
  
  public void a()
  {
    ((IReadInJoyLogicEngineFactory)QRoute.api(IReadInJoyLogicEngineFactory.class)).removeFixPosArticleAsyncListener(this.jdField_a_of_type_Int);
    ((IReadInJoyLogicEngineFactory)QRoute.api(IReadInJoyLogicEngineFactory.class)).removeFixPosArticleAsyncListener(this.jdField_b_of_type_Int);
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
    if ((VideoAdStrategyManager.b()) && (VideoAdStrategyManager.d())) {
      return;
    }
    int m = this.jdField_a_of_type_JavaUtilList.size();
    int k = 0;
    int i = 0;
    int j;
    for (;;)
    {
      j = k;
      if (i >= this.jdField_a_of_type_JavaUtilList.size()) {
        break;
      }
      if ((((VideoInfo)this.jdField_a_of_type_JavaUtilList.get(i)).r) && (i != paramInt1))
      {
        j = i;
        break;
      }
      i += 1;
    }
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("adapterPosition = ");
      localStringBuilder.append(paramInt1);
      localStringBuilder.append(" ,size = ");
      localStringBuilder.append(m);
      localStringBuilder.append(" ,nextAdPosition = ");
      localStringBuilder.append(j);
      QLog.d("VideoAdExposureManager", 2, localStringBuilder.toString());
    }
    a(paramInt2);
    c(paramInt2);
    b(paramVideoInfo, paramInt1);
  }
  
  public void a(int paramInt, VideoPlayParam paramVideoPlayParam, Object paramObject)
  {
    a(paramInt, paramVideoPlayParam, (ArrayList)paramObject);
  }
  
  public void a(int paramInt, VideoPlayParam paramVideoPlayParam, ArrayList<VideoInfo> paramArrayList)
  {
    VideoAdStrategyManager.a(paramVideoPlayParam);
    if ((VideoAdStrategyManager.b()) && (VideoAdStrategyManager.d())) {
      return;
    }
    if ((paramVideoPlayParam != null) && (paramVideoPlayParam.a != null))
    {
      if (!VideoAdStrategyManager.jdField_a_of_type_Boolean) {
        return;
      }
      if (!paramVideoPlayParam.a.r)
      {
        if (QLog.isColorLevel())
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("checkAndInsert , mPlayVmCount=");
          localStringBuilder.append(this.g);
          QLog.d("VideoAdExposureManager", 2, localStringBuilder.toString());
        }
        b(paramInt, paramVideoPlayParam, paramArrayList);
      }
      else
      {
        this.g = 0;
        if (QLog.isColorLevel()) {
          QLog.d("VideoAdExposureManager", 2, "checkAndInsert , mPlayVmCount= 0 ");
        }
      }
      if (QLog.isColorLevel())
      {
        paramVideoPlayParam = new StringBuilder();
        paramVideoPlayParam.append("onVideoStart , mPlayVmCount =");
        paramVideoPlayParam.append(this.g);
        QLog.d("VideoAdExposureManager", 2, paramVideoPlayParam.toString());
      }
    }
  }
  
  public void a(VideoAdInfo paramVideoAdInfo, int paramInt)
  {
    if ((VideoAdStrategyManager.b()) && (VideoAdStrategyManager.d())) {
      return;
    }
    if (paramVideoAdInfo != null)
    {
      Object localObject = (VideoInfo)this.jdField_a_of_type_AndroidUtilSparseArray.get(paramInt);
      boolean bool1 = this.jdField_a_of_type_AndroidUtilSparseBooleanArray.get(paramInt);
      boolean bool2 = this.jdField_c_of_type_AndroidUtilSparseBooleanArray.get(paramInt);
      if ((!bool1) && (localObject == null) && (!bool2))
      {
        this.jdField_a_of_type_AndroidUtilSparseBooleanArray.put(paramInt, true);
        paramVideoAdInfo = ((IRIJAdEntityConvertService)QRoute.api(IRIJAdEntityConvertService.class)).convertVideoAd2AdsInfo(paramVideoAdInfo);
        if (QLog.isColorLevel())
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("fetchAnotherAd !!! , pos=");
          ((StringBuilder)localObject).append(paramInt);
          QLog.d("VideoAdExposureManager", 2, ((StringBuilder)localObject).toString());
        }
        a(paramVideoAdInfo, paramInt, this.jdField_a_of_type_Int, 5);
      }
    }
  }
  
  public void a(IBaseVideoItemHolder paramIBaseVideoItemHolder)
  {
    try
    {
      if (VideoAdStrategyManager.b())
      {
        boolean bool = VideoAdStrategyManager.d();
        if (bool) {
          return;
        }
      }
      if (VideoAdStrategyManager.jdField_a_of_type_Boolean)
      {
        this.jdField_a_of_type_Boolean = false;
        if ((paramIBaseVideoItemHolder != null) && (paramIBaseVideoItemHolder.a()))
        {
          d(paramIBaseVideoItemHolder.getPosition());
          if (QLog.isColorLevel())
          {
            StringBuilder localStringBuilder = new StringBuilder();
            localStringBuilder.append("checkAndRecord reset notCountFlag , mPlayingVideoHolder.position=");
            localStringBuilder.append(paramIBaseVideoItemHolder.getPosition());
            QLog.d("VideoAdExposureManager", 2, localStringBuilder.toString());
          }
        }
      }
      return;
    }
    finally {}
  }
  
  public void a(VideoInfo paramVideoInfo, int paramInt)
  {
    if ((VideoAdStrategyManager.b()) && (VideoAdStrategyManager.d())) {
      return;
    }
    if (paramVideoInfo != null)
    {
      if (paramVideoInfo.a == null) {
        return;
      }
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("fetchChangePosAd insert wait pos = ");
        localStringBuilder.append(paramInt);
        QLog.d("VideoAdExposureManager", 2, localStringBuilder.toString());
      }
      paramVideoInfo = paramVideoInfo.a;
      a(((IRIJAdEntityConvertService)QRoute.api(IRIJAdEntityConvertService.class)).convertVideoAd2AdsInfo(paramVideoInfo), paramInt, this.jdField_b_of_type_Int, 6);
    }
  }
  
  public void a(boolean paramBoolean)
  {
    this.jdField_b_of_type_Boolean = paramBoolean;
  }
  
  public void a(boolean paramBoolean, int paramInt, Object paramObject)
  {
    a(paramBoolean, paramInt, (ArrayList)paramObject);
  }
  
  public void a(boolean paramBoolean, int paramInt, ArrayList<VideoInfo> paramArrayList)
  {
    try
    {
      if (QLog.isColorLevel())
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("checkAdPos , hasQueryParam= ");
        ((StringBuilder)localObject1).append(VideoAdStrategyManager.jdField_b_of_type_Boolean);
        ((StringBuilder)localObject1).append(" ,needChangeAdPos =");
        ((StringBuilder)localObject1).append(VideoAdStrategyManager.jdField_a_of_type_Boolean);
        QLog.d("VideoAdExposureManager", 2, ((StringBuilder)localObject1).toString());
      }
      if (VideoAdStrategyManager.jdField_b_of_type_Boolean)
      {
        boolean bool = VideoAdStrategyManager.jdField_a_of_type_Boolean;
        if (!bool) {
          return;
        }
      }
      if (QLog.isColorLevel())
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("checkAdPos enter, hasNewVideo= ");
        ((StringBuilder)localObject1).append(paramBoolean);
        ((StringBuilder)localObject1).append(" ,newSize =");
        ((StringBuilder)localObject1).append(paramInt);
        QLog.d("VideoAdExposureManager", 2, ((StringBuilder)localObject1).toString());
      }
      if ((!paramBoolean) || (paramInt <= 1)) {
        break label1214;
      }
      j = paramArrayList.size();
      i = j - paramInt;
      paramInt = i;
    }
    finally
    {
      for (;;)
      {
        Object localObject1;
        int j;
        int i;
        Object localObject2;
        Object localObject3;
        StringBuilder localStringBuilder;
        int k;
        for (;;)
        {
          label1214:
          throw paramArrayList;
        }
        paramInt += 1;
        continue;
        paramInt = -1;
        continue;
        label1240:
        paramBoolean = false;
      }
    }
    if (paramInt < paramArrayList.size()) {
      if ((((VideoInfo)paramArrayList.get(paramInt)).r) && (((VideoInfo)paramArrayList.get(paramInt)).a != null))
      {
        if (paramInt == -1)
        {
          if (QLog.isColorLevel()) {
            QLog.d("VideoAdExposureManager", 2, "checkAdPos can not find Ad !!");
          }
          VideoAdStrategyManager.a();
          return;
        }
        if (QLog.isColorLevel())
        {
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append("checkAdPos findAdIndex = ");
          ((StringBuilder)localObject1).append(paramInt);
          QLog.d("VideoAdExposureManager", 2, ((StringBuilder)localObject1).toString());
        }
        localObject1 = (VideoInfo)paramArrayList.get(paramInt);
        if (!VideoAdStrategyManager.jdField_b_of_type_Boolean)
        {
          VideoAdStrategyManager.jdField_b_of_type_Boolean = true;
          if ((!ReadInJoyAdSwitchUtil.f(((VideoInfo)localObject1).a)) || (!this.jdField_b_of_type_Boolean)) {
            break label1240;
          }
          paramBoolean = true;
          VideoAdStrategyManager.jdField_a_of_type_Boolean = paramBoolean;
          localObject2 = ((VideoInfo)localObject1).a.v;
          try
          {
            localObject2 = new JSONObject((String)localObject2);
            if (((JSONObject)localObject2).has("strategy"))
            {
              VideoAdStrategyManager.jdField_a_of_type_Int = ((JSONObject)localObject2).optInt("strategy", 0);
              if (VideoAdStrategyManager.jdField_a_of_type_Int == 3) {
                VideoAdStrategyManager.jdField_c_of_type_Boolean = true;
              }
            }
            else
            {
              VideoAdStrategyManager.jdField_a_of_type_Int = 2;
            }
            VideoAdStrategyManager.f = ((JSONObject)localObject2).optInt("ad_first_pos", 3);
            VideoAdStrategyManager.g = ((JSONObject)localObject2).optInt("ad_interval", 3);
            VideoAdStrategyManager.h = ((JSONObject)localObject2).optInt("ad_protect_interval", 2);
            VideoAdStrategyManager.jdField_b_of_type_Int = ((JSONObject)localObject2).optInt("ad_first_time", 10);
            VideoAdStrategyManager.jdField_c_of_type_Int = ((JSONObject)localObject2).optInt("ad_interval_time", 25);
            VideoAdStrategyManager.jdField_d_of_type_Int = ((JSONObject)localObject2).optInt("ad_pre_req", 2);
            VideoAdStrategyManager.e = ((JSONObject)localObject2).optInt("ad_protect_gap", 2);
            VideoAdStrategyManager.i = ((JSONObject)localObject2).optInt("first_stay_time", 3);
            VideoAdStrategyManager.j = ((JSONObject)localObject2).optInt("ad_vv_interval_first", 0);
            VideoAdStrategyManager.k = ((JSONObject)localObject2).optInt("ad_vv_interval_second", 0);
            VideoAdStrategyManager.l = ((JSONObject)localObject2).optInt("ad_vv_interval_other", 0);
            if ((VideoAdStrategyManager.jdField_a_of_type_Int == 3) && (VideoAdStrategyManager.jdField_b_of_type_Int <= VideoAdStrategyManager.i)) {
              VideoAdStrategyManager.jdField_a_of_type_Int = 2;
            }
          }
          catch (JSONException localJSONException)
          {
            localJSONException.printStackTrace();
            VideoAdStrategyManager.jdField_a_of_type_Boolean = false;
          }
          localObject3 = (IRIJAdLogService)QRoute.api(IRIJAdLogService.class);
          localStringBuilder = new StringBuilder();
          localStringBuilder.append("setAdStrategyFromServer: strategy = ");
          localStringBuilder.append(VideoAdStrategyManager.jdField_a_of_type_Int);
          localStringBuilder.append(" adFirstTime = ");
          localStringBuilder.append(VideoAdStrategyManager.jdField_b_of_type_Int);
          localStringBuilder.append(" adIntervalTime = ");
          localStringBuilder.append(VideoAdStrategyManager.jdField_c_of_type_Int);
          localStringBuilder.append(" adPreReq = ");
          localStringBuilder.append(VideoAdStrategyManager.jdField_d_of_type_Int);
          localStringBuilder.append(" adProtectGap = ");
          localStringBuilder.append(VideoAdStrategyManager.e);
          localStringBuilder.append(" adFirstPos = ");
          localStringBuilder.append(VideoAdStrategyManager.f);
          localStringBuilder.append(" adIntervalPos = ");
          localStringBuilder.append(VideoAdStrategyManager.g);
          localStringBuilder.append(" adProtectInterval = ");
          localStringBuilder.append(VideoAdStrategyManager.h);
          localStringBuilder.append(" adVvFirst = ");
          localStringBuilder.append(VideoAdStrategyManager.j);
          localStringBuilder.append(" adSecond = ");
          localStringBuilder.append(VideoAdStrategyManager.k);
          localStringBuilder.append(" adOther = ");
          localStringBuilder.append(VideoAdStrategyManager.l);
          ((IRIJAdLogService)localObject3).d("VideoAdStrategy", localStringBuilder.toString());
          VideoAdStrategyManager.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.compareAndSet(false, true);
          if (VideoAdStrategyManager.jdField_a_of_type_Int == 1)
          {
            localObject3 = VideoAdTimeLoadManager.a(paramArrayList);
            if (localObject3 != null) {
              paramArrayList.removeAll((Collection)localObject3);
            }
          }
          if (VideoAdStrategyManager.jdField_a_of_type_Int == 3) {
            VideoAdTimeLoadManager.a(paramArrayList);
          }
        }
        if (QLog.isColorLevel())
        {
          localObject3 = new StringBuilder();
          ((StringBuilder)localObject3).append("checkAdPos needChangeAdPos = ");
          ((StringBuilder)localObject3).append(VideoAdStrategyManager.jdField_a_of_type_Boolean);
          QLog.d("VideoAdExposureManager", 2, ((StringBuilder)localObject3).toString());
        }
        if (VideoAdStrategyManager.b())
        {
          paramBoolean = VideoAdStrategyManager.d();
          if (paramBoolean) {
            return;
          }
        }
        if (VideoAdStrategyManager.jdField_a_of_type_Boolean)
        {
          if (this.jdField_a_of_type_JavaUtilArrayList.isEmpty())
          {
            if (QLog.isColorLevel()) {
              QLog.d("VideoAdExposureManager", 2, "mInsertAdPos.isEmpty()");
            }
            return;
          }
          k = ((Integer)this.jdField_a_of_type_JavaUtilArrayList.get(this.jdField_a_of_type_JavaUtilArrayList.size() - 1)).intValue();
          if ((j - 1 > k) && (k >= i))
          {
            if (paramInt != k)
            {
              if (QLog.isColorLevel())
              {
                localObject3 = new StringBuilder();
                ((StringBuilder)localObject3).append("checkAdPos change findAdIndex=");
                ((StringBuilder)localObject3).append(paramInt);
                ((StringBuilder)localObject3).append(", lastNeedInsertAdPos=");
                ((StringBuilder)localObject3).append(k);
                QLog.d("VideoAdExposureManager", 2, ((StringBuilder)localObject3).toString());
              }
              i = paramArrayList.size();
              if (k >= i) {
                return;
              }
              paramArrayList.set(paramInt, (VideoInfo)paramArrayList.get(k));
              paramArrayList.set(k, localObject1);
            }
          }
          else if (((VideoInfo)localObject1).a != null)
          {
            i = VideoAdStrategyManager.h + k;
            if (i > paramInt)
            {
              if (QLog.isColorLevel())
              {
                localObject3 = new StringBuilder();
                ((StringBuilder)localObject3).append("checkAdPos change findAdIndex=");
                ((StringBuilder)localObject3).append(paramInt);
                ((StringBuilder)localObject3).append(", lastNeedInsertAdPos=");
                ((StringBuilder)localObject3).append(k);
                ((StringBuilder)localObject3).append(", minAdIndex=");
                ((StringBuilder)localObject3).append(i);
                QLog.d("VideoAdExposureManager", 2, ((StringBuilder)localObject3).toString());
              }
              j = paramArrayList.size();
              if (i >= j) {
                return;
              }
              paramArrayList.set(paramInt, (VideoInfo)paramArrayList.get(i));
              paramArrayList.set(i, localObject1);
              d(i);
            }
          }
        }
        return;
      }
    }
  }
  
  public boolean a(int paramInt)
  {
    boolean bool = this.jdField_b_of_type_AndroidUtilSparseBooleanArray.get(paramInt);
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("isNeedShowAnotherAd pos=");
      localStringBuilder.append(paramInt);
      localStringBuilder.append(",result =");
      localStringBuilder.append(bool);
      QLog.d("VideoAdExposureManager", 2, localStringBuilder.toString());
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
    if ((VideoAdStrategyManager.b()) && (VideoAdStrategyManager.d())) {
      return null;
    }
    boolean bool = this.jdField_d_of_type_AndroidUtilSparseBooleanArray.get(paramInt);
    VideoInfo localVideoInfo = (VideoInfo)this.jdField_b_of_type_AndroidUtilSparseArray.get(paramInt);
    if ((bool) && (localVideoInfo != null))
    {
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("onAsyncDataReady replace at =");
        localStringBuilder.append(this.e);
        localStringBuilder.append(", currentAdpaterPosition=");
        localStringBuilder.append(paramInt);
        QLog.d("VideoAdExposureManager", 2, localStringBuilder.toString());
      }
      this.jdField_d_of_type_AndroidUtilSparseBooleanArray.put(paramInt, false);
      this.jdField_b_of_type_AndroidUtilSparseArray.remove(paramInt);
      return localVideoInfo;
    }
    return null;
  }
  
  public void b(int paramInt)
  {
    if ((VideoAdStrategyManager.b()) && (VideoAdStrategyManager.d())) {
      return;
    }
    if ((VideoInfo)this.jdField_a_of_type_AndroidUtilSparseArray.get(paramInt) == null) {
      this.jdField_a_of_type_AndroidUtilSparseBooleanArray.put(paramInt, false);
    }
  }
  
  public void b(int paramInt, VideoPlayParam paramVideoPlayParam, Object paramObject)
  {
    b(paramInt, paramVideoPlayParam, (ArrayList)paramObject);
  }
  
  public void b(int paramInt, VideoPlayParam paramVideoPlayParam, ArrayList<VideoInfo> paramArrayList)
  {
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
        if (j != -1)
        {
          i = 1;
          if (QLog.isColorLevel())
          {
            paramVideoPlayParam = new StringBuilder();
            paramVideoPlayParam.append("nextAdPos =");
            paramVideoPlayParam.append(j);
            paramVideoPlayParam.append(", insertAd , mPlayVmCount=");
            paramVideoPlayParam.append(this.g);
            QLog.d("VideoAdExposureManager", 2, paramVideoPlayParam.toString());
          }
          if (i == 0)
          {
            k = paramArrayList.size();
            int m = paramInt + 1;
            if (k > m)
            {
              bool = ((VideoInfo)paramArrayList.get(m)).r;
              if (bool) {
                return;
              }
            }
          }
          int k = a(paramInt);
          bool = a(k, paramInt);
          if (QLog.isColorLevel())
          {
            paramVideoPlayParam = new StringBuilder();
            paramVideoPlayParam.append("isCountEnough =");
            paramVideoPlayParam.append(bool);
            paramVideoPlayParam.append(",position =");
            paramVideoPlayParam.append(paramInt);
            paramVideoPlayParam.append(",lastAdPos1 =");
            paramVideoPlayParam.append(k);
            QLog.d("VideoAdExposureManager", 2, paramVideoPlayParam.toString());
          }
          if (!bool) {
            return;
          }
          this.g = 0;
          this.jdField_a_of_type_Boolean = true;
          if (i == 0) {
            a(paramInt, paramArrayList);
          } else {
            a(paramArrayList, j);
          }
          return;
        }
      }
      finally {}
      int i = 0;
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
  
  public void d(int paramInt)
  {
    try
    {
      if (VideoAdStrategyManager.b())
      {
        boolean bool = VideoAdStrategyManager.d();
        if (bool) {
          return;
        }
      }
      if (!this.jdField_a_of_type_JavaUtilArrayList.contains(Integer.valueOf(paramInt)))
      {
        if (QLog.isColorLevel())
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("recordAdPos recordAdPos=");
          localStringBuilder.append(paramInt);
          QLog.d("VideoAdExposureManager", 2, localStringBuilder.toString());
        }
        this.jdField_a_of_type_JavaUtilArrayList.add(Integer.valueOf(paramInt));
      }
      return;
    }
    finally {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoyAd.ad.video.strategy.VideoAdExposureManager
 * JD-Core Version:    0.7.0.1
 */