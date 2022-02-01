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
  private int a = 78888888;
  private int b = 78888889;
  private IVideoFeedsAdapter c;
  private List<VideoInfo> d;
  private VideoFeedsRecyclerView e;
  private Handler f;
  private int g = 0;
  private int h = 0;
  private int i = 0;
  private int j = 0;
  private FixPosArticleInterface.FixPosArticleAsyncListener k;
  private SparseBooleanArray l = new SparseBooleanArray();
  private SparseBooleanArray m = new SparseBooleanArray();
  private SparseArray<VideoInfo> n = new SparseArray();
  private SparseBooleanArray o = new SparseBooleanArray();
  private SparseBooleanArray p = new SparseBooleanArray();
  private ArrayList<Integer> q = new ArrayList();
  private boolean r;
  private boolean s;
  private int t = 1;
  private SparseArray<VideoInfo> u = new SparseArray();
  private ArrayList<VideoInfo> v = new ArrayList();
  
  public VideoAdExposureManager(IVideoFeedsAdapter paramIVideoFeedsAdapter, List<VideoInfo> paramList, VideoFeedsRecyclerView paramVideoFeedsRecyclerView, Handler paramHandler)
  {
    this.c = paramIVideoFeedsAdapter;
    this.d = paramList;
    this.e = paramVideoFeedsRecyclerView;
    this.f = paramHandler;
    ((IReadInJoyUtils)QRoute.api(IReadInJoyUtils.class)).getAppRuntime().getManager(QQManagerFactory.READINJOY_LOGIC_MANAGER);
    this.k = new VideoAdExposureManager.PosListener(this);
  }
  
  public static VideoInfo a(AdvertisementInfo paramAdvertisementInfo, boolean paramBoolean)
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.copyTypes(TypeTransformer.java:311)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.fixTypes(TypeTransformer.java:226)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:207)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
  
  private void a(int paramInt, ArrayList<VideoInfo> paramArrayList)
  {
    int i2 = g(paramInt);
    int i3 = b(paramInt, i2);
    f(i3);
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("onVideoReplayOnLoop , lastAdPos =");
      ((StringBuilder)localObject).append(i2);
      ((StringBuilder)localObject).append(" ，recordAdPos =");
      ((StringBuilder)localObject).append(i3);
      QLog.d("VideoAdExposureManager", 2, ((StringBuilder)localObject).toString());
    }
    if (i3 >= paramArrayList.size()) {
      return;
    }
    int i1 = paramInt;
    while (i1 < paramArrayList.size())
    {
      if (((VideoInfo)paramArrayList.get(i1)).aq) {
        break label126;
      }
      i1 += 1;
    }
    i1 = -1;
    label126:
    Object localObject = null;
    if (i1 == -1)
    {
      if (this.v.size() > 0)
      {
        localObject = (VideoInfo)this.v.get(0);
        this.v.remove(0);
      }
    }
    else
    {
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("onVideoReplayOnLoop , findPos =");
        ((StringBuilder)localObject).append(i1);
        ((StringBuilder)localObject).append(" ，startPos =");
        ((StringBuilder)localObject).append(paramInt);
        QLog.d("VideoAdExposureManager", 2, ((StringBuilder)localObject).toString());
      }
      localObject = (VideoInfo)paramArrayList.get(i1);
      paramArrayList.remove(i1);
    }
    if ((localObject == null) && (i2 != -1) && (i2 < paramArrayList.size()))
    {
      ((IRIJAdLogService)QRoute.api(IRIJAdLogService.class)).d("VIDEO_LINK", "fetchChangePosAd : 当前广告位置后面没有广告");
      a((VideoInfo)paramArrayList.get(i2), i3);
      return;
    }
    a((VideoInfo)localObject, paramArrayList, i3);
  }
  
  private void a(AdvertisementInfo paramAdvertisementInfo)
  {
    paramAdvertisementInfo = a(paramAdvertisementInfo, true);
    this.n.put(this.g, paramAdvertisementInfo);
    this.g = 0;
  }
  
  private void a(AdvertisementInfo paramAdvertisementInfo, int paramInt1, int paramInt2, int paramInt3)
  {
    if (paramAdvertisementInfo == null) {
      return;
    }
    if (paramInt2 == this.b)
    {
      this.i = paramInt1;
      this.j = paramAdvertisementInfo.mAdKdPos;
    }
    else
    {
      this.g = paramInt1;
      this.h = paramAdvertisementInfo.mAdKdPos;
    }
    AdRequestData localAdRequestData = new AdRequestData();
    localAdRequestData.a = paramAdvertisementInfo.mAdMaterialId;
    localAdRequestData.b = 1;
    localAdRequestData.c = paramAdvertisementInfo.mAdKdPos;
    localAdRequestData.d = paramAdvertisementInfo.mAdPosID;
    localAdRequestData.e = true;
    ((IReadInJoyLogicEngineFactory)QRoute.api(IReadInJoyLogicEngineFactory.class)).setFixPosArticleAsyncListener(paramInt2, this.k);
    ThreadManager.executeOnSubThread(new VideoAdExposureManager.1(this, paramInt3, paramInt2, localAdRequestData));
  }
  
  private void a(VideoInfo paramVideoInfo, ArrayList<VideoInfo> paramArrayList, int paramInt)
  {
    if (paramVideoInfo == null) {
      return;
    }
    paramArrayList.add(paramInt, paramVideoInfo);
    paramVideoInfo = this.c;
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
    if ((localObject1 != null) && (((VideoInfo)localObject1).aq) && (((VideoInfo)localObject1).as != null))
    {
      Object localObject2 = this.c;
      if ((localObject2 != null) && (((IVideoFeedsAdapter)localObject2).e(((VideoInfo)localObject1).as.m)))
      {
        localObject2 = (VideoInfo)this.u.get(paramInt);
        localObject1 = localObject2;
        if (localObject2 == null)
        {
          localObject1 = localObject2;
          if (this.v.size() > 0)
          {
            localObject1 = (VideoInfo)this.v.get(0);
            this.v.remove(0);
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
    return ((paramInt1 == -1) && (paramInt2 < VideoAdStrategyManager.g) && (this.t >= VideoAdStrategyManager.g)) || (this.t >= VideoAdStrategyManager.h);
  }
  
  private boolean a(VideoPlayParam paramVideoPlayParam)
  {
    if ((VideoAdStrategyManager.b()) && (VideoAdStrategyManager.d())) {
      return false;
    }
    paramVideoPlayParam = paramVideoPlayParam.c;
    if (paramVideoPlayParam != null)
    {
      if (paramVideoPlayParam.aq) {
        return false;
      }
      if ((VideoAdStrategyManager.j) && (!this.r)) {
        return true;
      }
      if (QLog.isColorLevel())
      {
        if (!VideoAdStrategyManager.j) {
          QLog.d("VideoAdExposureManager", 2, "命中 调整广告位置的开关关闭 ");
        }
        if (this.r) {
          QLog.d("VideoAdExposureManager", 2, "该位置已经 触发过判断的情况");
        }
      }
    }
    return false;
  }
  
  private int b(int paramInt1, int paramInt2)
  {
    if (paramInt2 == -1) {
      return paramInt1 + 1;
    }
    return Math.max(paramInt2 + VideoAdStrategyManager.i + 1, paramInt1 + 1);
  }
  
  private void b(AdvertisementInfo paramAdvertisementInfo)
  {
    if ((VideoAdStrategyManager.b()) && (VideoAdStrategyManager.d())) {
      return;
    }
    paramAdvertisementInfo = a(paramAdvertisementInfo, false);
    if ((this.e != null) && (this.c != null) && ((this.i < this.d.size()) || (this.i <= 0)))
    {
      VideoInfo localVideoInfo = (VideoInfo)this.d.get(this.i);
      int i1 = this.e.getCurrentAdpaterPosition();
      this.v.add(paramAdvertisementInfo);
      if ((localVideoInfo != null) && (!localVideoInfo.aq) && (this.i > i1))
      {
        this.v.remove(paramAdvertisementInfo);
        this.d.add(this.i, paramAdvertisementInfo);
        IRIJAdLogService localIRIJAdLogService = (IRIJAdLogService)QRoute.api(IRIJAdLogService.class);
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("onAsyncDataReady add at =");
        localStringBuilder.append(this.i);
        localStringBuilder.append(", currentAdpaterPosition=");
        localStringBuilder.append(i1);
        localIRIJAdLogService.d("AdVideoDataLink", localStringBuilder.toString());
        this.c.notifyItemInserted(this.i);
        this.i = 0;
      }
      if ((localVideoInfo != null) && (localVideoInfo.aq) && (localVideoInfo.as != null) && (this.c.e(localVideoInfo.as.m)))
      {
        this.v.remove(paramAdvertisementInfo);
        b(paramAdvertisementInfo, this.i);
        this.i = 0;
      }
    }
  }
  
  private void b(VideoInfo paramVideoInfo, int paramInt)
  {
    if ((VideoAdStrategyManager.b()) && (VideoAdStrategyManager.d())) {
      return;
    }
    this.p.put(paramInt, true);
    this.u.put(paramInt, paramVideoInfo);
    this.c.notifyItemChanged(paramInt);
  }
  
  private void j(int paramInt)
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
      int i1;
      if (paramInt == this.b)
      {
        i1 = this.j;
        this.j = 0;
      }
      else
      {
        i1 = this.h;
        this.h = 0;
      }
      Object localObject1 = (AdvertisementInfo)((IReadInJoyLogicEngineFactory)QRoute.api(IReadInJoyLogicEngineFactory.class)).getAdvertisementInfo(paramInt, i1);
      if (localObject1 == null)
      {
        if (QLog.isColorLevel()) {
          QLog.d("VideoAdExposureManager", 2, "getVideoInfo ,not get fetch data!!!??");
        }
        return;
      }
      ((IReadInJoyLogicEngineFactory)QRoute.api(IReadInJoyLogicEngineFactory.class)).removeAdvertisementInfo(paramInt, i1);
      if (paramInt == this.b) {
        b((AdvertisementInfo)localObject1);
      } else {
        a((AdvertisementInfo)localObject1);
      }
      return;
    }
    finally {}
  }
  
  public void a()
  {
    ((IReadInJoyLogicEngineFactory)QRoute.api(IReadInJoyLogicEngineFactory.class)).removeFixPosArticleAsyncListener(this.a);
    ((IReadInJoyLogicEngineFactory)QRoute.api(IReadInJoyLogicEngineFactory.class)).removeFixPosArticleAsyncListener(this.b);
  }
  
  public void a(int paramInt1, int paramInt2, VideoInfo paramVideoInfo)
  {
    if ((VideoAdStrategyManager.b()) && (VideoAdStrategyManager.d())) {
      return;
    }
    int i4 = this.d.size();
    int i3 = 0;
    int i1 = 0;
    int i2;
    for (;;)
    {
      i2 = i3;
      if (i1 >= this.d.size()) {
        break;
      }
      if ((((VideoInfo)this.d.get(i1)).aq) && (i1 != paramInt1))
      {
        i2 = i1;
        break;
      }
      i1 += 1;
    }
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("adapterPosition = ");
      localStringBuilder.append(paramInt1);
      localStringBuilder.append(" ,size = ");
      localStringBuilder.append(i4);
      localStringBuilder.append(" ,nextAdPosition = ");
      localStringBuilder.append(i2);
      QLog.d("VideoAdExposureManager", 2, localStringBuilder.toString());
    }
    b(paramInt2);
    e(paramInt2);
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
    if ((paramVideoPlayParam != null) && (paramVideoPlayParam.c != null))
    {
      if (!VideoAdStrategyManager.j) {
        return;
      }
      if (!paramVideoPlayParam.c.aq)
      {
        if (QLog.isColorLevel())
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("checkAndInsert , mPlayVmCount=");
          localStringBuilder.append(this.t);
          QLog.d("VideoAdExposureManager", 2, localStringBuilder.toString());
        }
        b(paramInt, paramVideoPlayParam, paramArrayList);
      }
      else
      {
        this.t = 0;
        if (QLog.isColorLevel()) {
          QLog.d("VideoAdExposureManager", 2, "checkAndInsert , mPlayVmCount= 0 ");
        }
      }
      if (QLog.isColorLevel())
      {
        paramVideoPlayParam = new StringBuilder();
        paramVideoPlayParam.append("onVideoStart , mPlayVmCount =");
        paramVideoPlayParam.append(this.t);
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
      Object localObject = (VideoInfo)this.n.get(paramInt);
      boolean bool1 = this.l.get(paramInt);
      boolean bool2 = this.o.get(paramInt);
      if ((!bool1) && (localObject == null) && (!bool2))
      {
        this.l.put(paramInt, true);
        paramVideoAdInfo = ((IRIJAdEntityConvertService)QRoute.api(IRIJAdEntityConvertService.class)).convertVideoAd2AdsInfo(paramVideoAdInfo);
        if (QLog.isColorLevel())
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("fetchAnotherAd !!! , pos=");
          ((StringBuilder)localObject).append(paramInt);
          QLog.d("VideoAdExposureManager", 2, ((StringBuilder)localObject).toString());
        }
        a(paramVideoAdInfo, paramInt, this.a, 5);
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
      if (VideoAdStrategyManager.j)
      {
        this.r = false;
        if ((paramIBaseVideoItemHolder != null) && (paramIBaseVideoItemHolder.L()))
        {
          f(paramIBaseVideoItemHolder.getPosition());
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
      if (paramVideoInfo.as == null) {
        return;
      }
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("fetchChangePosAd insert wait pos = ");
        localStringBuilder.append(paramInt);
        QLog.d("VideoAdExposureManager", 2, localStringBuilder.toString());
      }
      paramVideoInfo = paramVideoInfo.as;
      a(((IRIJAdEntityConvertService)QRoute.api(IRIJAdEntityConvertService.class)).convertVideoAd2AdsInfo(paramVideoInfo), paramInt, this.b, 6);
    }
  }
  
  public void a(boolean paramBoolean)
  {
    this.s = paramBoolean;
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
        ((StringBuilder)localObject1).append(VideoAdStrategyManager.k);
        ((StringBuilder)localObject1).append(" ,needChangeAdPos =");
        ((StringBuilder)localObject1).append(VideoAdStrategyManager.j);
        QLog.d("VideoAdExposureManager", 2, ((StringBuilder)localObject1).toString());
      }
      if (VideoAdStrategyManager.k)
      {
        boolean bool = VideoAdStrategyManager.j;
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
      i2 = paramArrayList.size();
      i1 = i2 - paramInt;
      paramInt = i1;
    }
    finally
    {
      for (;;)
      {
        Object localObject1;
        int i2;
        int i1;
        Object localObject2;
        Object localObject3;
        StringBuilder localStringBuilder;
        int i3;
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
      if ((((VideoInfo)paramArrayList.get(paramInt)).aq) && (((VideoInfo)paramArrayList.get(paramInt)).as != null))
      {
        if (paramInt == -1)
        {
          if (QLog.isColorLevel()) {
            QLog.d("VideoAdExposureManager", 2, "checkAdPos can not find Ad !!");
          }
          VideoAdStrategyManager.g();
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
        if (!VideoAdStrategyManager.k)
        {
          VideoAdStrategyManager.k = true;
          if ((!ReadInJoyAdSwitchUtil.f(((VideoInfo)localObject1).as)) || (!this.s)) {
            break label1240;
          }
          paramBoolean = true;
          VideoAdStrategyManager.j = paramBoolean;
          localObject2 = ((VideoInfo)localObject1).as.R;
          try
          {
            localObject2 = new JSONObject((String)localObject2);
            if (((JSONObject)localObject2).has("strategy"))
            {
              VideoAdStrategyManager.b = ((JSONObject)localObject2).optInt("strategy", 0);
              if (VideoAdStrategyManager.b == 3) {
                VideoAdStrategyManager.m = true;
              }
            }
            else
            {
              VideoAdStrategyManager.b = 2;
            }
            VideoAdStrategyManager.g = ((JSONObject)localObject2).optInt("ad_first_pos", 3);
            VideoAdStrategyManager.h = ((JSONObject)localObject2).optInt("ad_interval", 3);
            VideoAdStrategyManager.i = ((JSONObject)localObject2).optInt("ad_protect_interval", 2);
            VideoAdStrategyManager.c = ((JSONObject)localObject2).optInt("ad_first_time", 10);
            VideoAdStrategyManager.d = ((JSONObject)localObject2).optInt("ad_interval_time", 25);
            VideoAdStrategyManager.e = ((JSONObject)localObject2).optInt("ad_pre_req", 2);
            VideoAdStrategyManager.f = ((JSONObject)localObject2).optInt("ad_protect_gap", 2);
            VideoAdStrategyManager.l = ((JSONObject)localObject2).optInt("first_stay_time", 3);
            VideoAdStrategyManager.o = ((JSONObject)localObject2).optInt("ad_vv_interval_first", 0);
            VideoAdStrategyManager.p = ((JSONObject)localObject2).optInt("ad_vv_interval_second", 0);
            VideoAdStrategyManager.q = ((JSONObject)localObject2).optInt("ad_vv_interval_other", 0);
            if ((VideoAdStrategyManager.b == 3) && (VideoAdStrategyManager.c <= VideoAdStrategyManager.l)) {
              VideoAdStrategyManager.b = 2;
            }
          }
          catch (JSONException localJSONException)
          {
            localJSONException.printStackTrace();
            VideoAdStrategyManager.j = false;
          }
          localObject3 = (IRIJAdLogService)QRoute.api(IRIJAdLogService.class);
          localStringBuilder = new StringBuilder();
          localStringBuilder.append("setAdStrategyFromServer: strategy = ");
          localStringBuilder.append(VideoAdStrategyManager.b);
          localStringBuilder.append(" adFirstTime = ");
          localStringBuilder.append(VideoAdStrategyManager.c);
          localStringBuilder.append(" adIntervalTime = ");
          localStringBuilder.append(VideoAdStrategyManager.d);
          localStringBuilder.append(" adPreReq = ");
          localStringBuilder.append(VideoAdStrategyManager.e);
          localStringBuilder.append(" adProtectGap = ");
          localStringBuilder.append(VideoAdStrategyManager.f);
          localStringBuilder.append(" adFirstPos = ");
          localStringBuilder.append(VideoAdStrategyManager.g);
          localStringBuilder.append(" adIntervalPos = ");
          localStringBuilder.append(VideoAdStrategyManager.h);
          localStringBuilder.append(" adProtectInterval = ");
          localStringBuilder.append(VideoAdStrategyManager.i);
          localStringBuilder.append(" adVvFirst = ");
          localStringBuilder.append(VideoAdStrategyManager.o);
          localStringBuilder.append(" adSecond = ");
          localStringBuilder.append(VideoAdStrategyManager.p);
          localStringBuilder.append(" adOther = ");
          localStringBuilder.append(VideoAdStrategyManager.q);
          ((IRIJAdLogService)localObject3).d("VideoAdStrategy", localStringBuilder.toString());
          VideoAdStrategyManager.a.compareAndSet(false, true);
          if (VideoAdStrategyManager.b == 1)
          {
            localObject3 = VideoAdTimeLoadManager.a(paramArrayList);
            if (localObject3 != null) {
              paramArrayList.removeAll((Collection)localObject3);
            }
          }
          if (VideoAdStrategyManager.b == 3) {
            VideoAdTimeLoadManager.a(paramArrayList);
          }
        }
        if (QLog.isColorLevel())
        {
          localObject3 = new StringBuilder();
          ((StringBuilder)localObject3).append("checkAdPos needChangeAdPos = ");
          ((StringBuilder)localObject3).append(VideoAdStrategyManager.j);
          QLog.d("VideoAdExposureManager", 2, ((StringBuilder)localObject3).toString());
        }
        if (VideoAdStrategyManager.b())
        {
          paramBoolean = VideoAdStrategyManager.d();
          if (paramBoolean) {
            return;
          }
        }
        if (VideoAdStrategyManager.j)
        {
          if (this.q.isEmpty())
          {
            if (QLog.isColorLevel()) {
              QLog.d("VideoAdExposureManager", 2, "mInsertAdPos.isEmpty()");
            }
            return;
          }
          i3 = ((Integer)this.q.get(this.q.size() - 1)).intValue();
          if ((i2 - 1 > i3) && (i3 >= i1))
          {
            if (paramInt != i3)
            {
              if (QLog.isColorLevel())
              {
                localObject3 = new StringBuilder();
                ((StringBuilder)localObject3).append("checkAdPos change findAdIndex=");
                ((StringBuilder)localObject3).append(paramInt);
                ((StringBuilder)localObject3).append(", lastNeedInsertAdPos=");
                ((StringBuilder)localObject3).append(i3);
                QLog.d("VideoAdExposureManager", 2, ((StringBuilder)localObject3).toString());
              }
              i1 = paramArrayList.size();
              if (i3 >= i1) {
                return;
              }
              paramArrayList.set(paramInt, (VideoInfo)paramArrayList.get(i3));
              paramArrayList.set(i3, localObject1);
            }
          }
          else if (((VideoInfo)localObject1).as != null)
          {
            i1 = VideoAdStrategyManager.i + i3;
            if (i1 > paramInt)
            {
              if (QLog.isColorLevel())
              {
                localObject3 = new StringBuilder();
                ((StringBuilder)localObject3).append("checkAdPos change findAdIndex=");
                ((StringBuilder)localObject3).append(paramInt);
                ((StringBuilder)localObject3).append(", lastNeedInsertAdPos=");
                ((StringBuilder)localObject3).append(i3);
                ((StringBuilder)localObject3).append(", minAdIndex=");
                ((StringBuilder)localObject3).append(i1);
                QLog.d("VideoAdExposureManager", 2, ((StringBuilder)localObject3).toString());
              }
              i2 = paramArrayList.size();
              if (i1 >= i2) {
                return;
              }
              paramArrayList.set(paramInt, (VideoInfo)paramArrayList.get(i1));
              paramArrayList.set(i1, localObject1);
              f(i1);
            }
          }
        }
        return;
      }
    }
  }
  
  public boolean a(int paramInt)
  {
    boolean bool = this.m.get(paramInt);
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
  
  public void b(int paramInt)
  {
    this.m.put(paramInt, true);
    if (QLog.isColorLevel()) {
      QLog.d("VideoAdExposureManager", 2, "hasShowAnotherAd");
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
        this.t += 1;
        int i2 = h(paramInt);
        if (i2 != -1)
        {
          i1 = 1;
          if (QLog.isColorLevel())
          {
            paramVideoPlayParam = new StringBuilder();
            paramVideoPlayParam.append("nextAdPos =");
            paramVideoPlayParam.append(i2);
            paramVideoPlayParam.append(", insertAd , mPlayVmCount=");
            paramVideoPlayParam.append(this.t);
            QLog.d("VideoAdExposureManager", 2, paramVideoPlayParam.toString());
          }
          if (i1 == 0)
          {
            i3 = paramArrayList.size();
            int i4 = paramInt + 1;
            if (i3 > i4)
            {
              bool = ((VideoInfo)paramArrayList.get(i4)).aq;
              if (bool) {
                return;
              }
            }
          }
          int i3 = g(paramInt);
          bool = a(i3, paramInt);
          if (QLog.isColorLevel())
          {
            paramVideoPlayParam = new StringBuilder();
            paramVideoPlayParam.append("isCountEnough =");
            paramVideoPlayParam.append(bool);
            paramVideoPlayParam.append(",position =");
            paramVideoPlayParam.append(paramInt);
            paramVideoPlayParam.append(",lastAdPos1 =");
            paramVideoPlayParam.append(i3);
            QLog.d("VideoAdExposureManager", 2, paramVideoPlayParam.toString());
          }
          if (!bool) {
            return;
          }
          this.t = 0;
          this.r = true;
          if (i1 == 0) {
            a(paramInt, paramArrayList);
          } else {
            a(paramArrayList, i2);
          }
          return;
        }
      }
      finally {}
      int i1 = 0;
    }
  }
  
  public void c(int paramInt)
  {
    if ((VideoAdStrategyManager.b()) && (VideoAdStrategyManager.d())) {
      return;
    }
    if ((VideoInfo)this.n.get(paramInt) == null) {
      this.l.put(paramInt, false);
    }
  }
  
  public VideoInfo d(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("VideoAdExposureManager", 2, "getVideoInfo");
    }
    VideoInfo localVideoInfo = (VideoInfo)this.n.get(paramInt);
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
  
  public void e(int paramInt)
  {
    this.n.remove(paramInt);
    this.o.put(paramInt, true);
    if (QLog.isColorLevel()) {
      QLog.d("VideoAdExposureManager", 2, "removeCacheVideoInfo ");
    }
  }
  
  public void f(int paramInt)
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
      if (!this.q.contains(Integer.valueOf(paramInt)))
      {
        if (QLog.isColorLevel())
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("recordAdPos recordAdPos=");
          localStringBuilder.append(paramInt);
          QLog.d("VideoAdExposureManager", 2, localStringBuilder.toString());
        }
        this.q.add(Integer.valueOf(paramInt));
      }
      return;
    }
    finally {}
  }
  
  public int g(int paramInt)
  {
    int i2 = -1;
    int i1 = 0;
    while (i1 < this.q.size())
    {
      Integer localInteger = (Integer)this.q.get(i1);
      if (localInteger.intValue() >= paramInt) {
        break;
      }
      i2 = localInteger.intValue();
      i1 += 1;
    }
    return i2;
  }
  
  public int h(int paramInt)
  {
    int i1 = 0;
    while (i1 < this.q.size())
    {
      Integer localInteger = (Integer)this.q.get(i1);
      if (localInteger.intValue() > paramInt) {
        return localInteger.intValue();
      }
      i1 += 1;
    }
    return -1;
  }
  
  public VideoInfo i(int paramInt)
  {
    if ((VideoAdStrategyManager.b()) && (VideoAdStrategyManager.d())) {
      return null;
    }
    boolean bool = this.p.get(paramInt);
    VideoInfo localVideoInfo = (VideoInfo)this.u.get(paramInt);
    if ((bool) && (localVideoInfo != null))
    {
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("onAsyncDataReady replace at =");
        localStringBuilder.append(this.i);
        localStringBuilder.append(", currentAdpaterPosition=");
        localStringBuilder.append(paramInt);
        QLog.d("VideoAdExposureManager", 2, localStringBuilder.toString());
      }
      this.p.put(paramInt, false);
      this.u.remove(paramInt);
      return localVideoInfo;
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoyAd.ad.video.strategy.VideoAdExposureManager
 * JD-Core Version:    0.7.0.1
 */