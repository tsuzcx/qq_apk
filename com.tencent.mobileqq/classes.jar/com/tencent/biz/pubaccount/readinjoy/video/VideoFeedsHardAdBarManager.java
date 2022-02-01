package com.tencent.biz.pubaccount.readinjoy.video;

import android.app.Activity;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.LinearLayout.LayoutParams;
import com.tencent.aladdin.config.Aladdin;
import com.tencent.aladdin.config.AladdinConfig;
import com.tencent.biz.pubaccount.NativeAd.report.constant.ActionEntity;
import com.tencent.biz.pubaccount.NativeAd.report.constant.ReportAction;
import com.tencent.biz.pubaccount.NativeAd.report.constant.ReportConstants.VideoEndType;
import com.tencent.biz.pubaccount.readinjoy.struct.AdvertisementInfo;
import com.tencent.biz.pubaccount.readinjoy.video.videofeeds.ADVideoItemHolder;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.utils.Utils;
import com.tencent.biz.pubaccount.readinjoyAd.ad.common_ad_download.util.RIJAdDownloadExKt;
import com.tencent.biz.pubaccount.readinjoyAd.ad.common_ad_download.view.RIJDownloadView;
import com.tencent.biz.pubaccount.readinjoyAd.ad.data.AdJumpParams;
import com.tencent.biz.pubaccount.readinjoyAd.ad.data.AdReportData;
import com.tencent.biz.pubaccount.readinjoyAd.ad.manager.AdExposeFreshManager;
import com.tencent.biz.pubaccount.readinjoyAd.ad.manager.AdReqFreshManager;
import com.tencent.biz.pubaccount.readinjoyAd.ad.utils.AdVideoButtonUIUtils;
import com.tencent.biz.pubaccount.readinjoyAd.ad.utils.AdVideoPendantUIUtils;
import com.tencent.biz.pubaccount.readinjoyAd.ad.utils.ReadInJoyAdLog;
import com.tencent.biz.pubaccount.readinjoyAd.ad.utils.ReadInJoyAdSwitchUtil;
import com.tencent.biz.pubaccount.readinjoyAd.ad.utils.ReadInJoyAdUtils;
import com.tencent.biz.pubaccount.readinjoyAd.ad.utils.ReadInJoyVideoFeedsAdUtils;
import com.tencent.biz.pubaccount.readinjoyAd.ad.video.ADVideoAppDownloadData;
import com.tencent.biz.pubaccount.readinjoyAd.ad.video.ADVideoFeedsGuideManager;
import com.tencent.biz.pubaccount.readinjoyAd.ad.video.strategy.VideoAdStrategyManager;
import com.tencent.biz.pubaccount.util.ReadinJoyActionUtil;
import com.tencent.biz.pubaccount.util.api.IPublicAccountConfigUtil;
import com.tencent.gdtad.aditem.GdtHandler.Params;
import com.tencent.mobileqq.kandian.ad.api.IRIJAdActionUtilService;
import com.tencent.mobileqq.kandian.ad.api.IRIJAdEntityConvertService;
import com.tencent.mobileqq.kandian.ad.api.IRIJAdLogService;
import com.tencent.mobileqq.kandian.ad.api.IRIJAdService;
import com.tencent.mobileqq.kandian.ad.api.IRIJAdUtilService;
import com.tencent.mobileqq.kandian.ad.api.entity.IADVideoAppDownloadManager;
import com.tencent.mobileqq.kandian.ad.api.entity.IVideoFeedsHardAdBarManager;
import com.tencent.mobileqq.kandian.biz.ad.entity.VideoAdInfo;
import com.tencent.mobileqq.kandian.biz.ad.entity.VideoAdStrategyReportData;
import com.tencent.mobileqq.kandian.biz.ad.report.VideoAdTimeReportData;
import com.tencent.mobileqq.kandian.biz.video.api.IVideoFeedsHelper;
import com.tencent.mobileqq.kandian.biz.video.playfeeds.api.IVideoFeedsAdapter;
import com.tencent.mobileqq.kandian.biz.video.playfeeds.api.IVideoFeedsPlayManager;
import com.tencent.mobileqq.kandian.biz.video.playfeeds.entity.VideoInfo;
import com.tencent.mobileqq.kandian.biz.video.playfeeds.entity.VideoPlayParam;
import com.tencent.mobileqq.kandian.biz.video.playfeeds.view.VideoFeedsRecyclerView;
import com.tencent.mobileqq.kandian.biz.video.playfeeds.viewholder.BaseItemHolder;
import com.tencent.mobileqq.kandian.biz.video.playfeeds.viewholder.BaseVideoItemHolder;
import com.tencent.mobileqq.kandian.biz.video.playfeeds.viewholder.VideoItemHolder;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import java.util.HashSet;
import java.util.Set;
import org.jetbrains.annotations.Nullable;
import org.json.JSONException;
import org.json.JSONObject;

public class VideoFeedsHardAdBarManager
  implements IVideoFeedsHardAdBarManager
{
  public boolean a = false;
  public boolean b = false;
  public boolean c = false;
  public boolean d = false;
  public GdtHandler.Params e;
  public long f = -2147483648L;
  public boolean g = false;
  public boolean h = false;
  public boolean i = false;
  public Handler j = new VideoFeedsHardAdBarManager.1(this, Looper.getMainLooper());
  private Context k;
  private Activity l;
  private boolean m = false;
  private ADVideoFeedsGuideManager n;
  private IADVideoAppDownloadManager o;
  private IVideoFeedsAdapter p;
  private Set<String> q = new HashSet();
  
  public VideoFeedsHardAdBarManager(Context paramContext, boolean paramBoolean, Activity paramActivity, IVideoFeedsAdapter paramIVideoFeedsAdapter)
  {
    this.k = paramContext;
    this.m = paramBoolean;
    this.l = paramActivity;
    this.p = paramIVideoFeedsAdapter;
  }
  
  private VideoAdInfo a(VideoItemHolder paramVideoItemHolder)
  {
    if (paramVideoItemHolder == null) {
      return null;
    }
    if (paramVideoItemHolder.az == null) {
      return null;
    }
    if (paramVideoItemHolder.az.c == null) {
      return null;
    }
    return paramVideoItemHolder.az.c.as;
  }
  
  private void a(View paramView, int paramInt, VideoInfo paramVideoInfo, IVideoFeedsPlayManager paramIVideoFeedsPlayManager)
  {
    if ((paramIVideoFeedsPlayManager != null) && (paramIVideoFeedsPlayManager.k())) {
      paramIVideoFeedsPlayManager.g();
    }
    this.p.a(paramView, paramInt, paramVideoInfo);
  }
  
  private void a(View paramView, VideoInfo paramVideoInfo, IVideoFeedsPlayManager paramIVideoFeedsPlayManager)
  {
    if ((paramVideoInfo.aq) && ((this.p.o() instanceof ADVideoItemHolder))) {
      a(paramView, (int)paramIVideoFeedsPlayManager.b(), paramVideoInfo, paramIVideoFeedsPlayManager);
    }
  }
  
  private void a(View paramView, BaseItemHolder paramBaseItemHolder, VideoInfo paramVideoInfo, AdvertisementInfo paramAdvertisementInfo, IVideoFeedsPlayManager paramIVideoFeedsPlayManager)
  {
    switch (paramView.getId())
    {
    default: 
      return;
    case 2131434507: 
      h(paramVideoInfo, paramAdvertisementInfo, paramIVideoFeedsPlayManager);
      return;
    case 2131434498: 
      i(paramVideoInfo, paramAdvertisementInfo, paramIVideoFeedsPlayManager);
      return;
    case 2131434495: 
      g(paramVideoInfo, paramAdvertisementInfo, paramIVideoFeedsPlayManager);
      return;
    case 2131434487: 
      paramView = this.j;
      paramView.sendMessage(paramView.obtainMessage(7, Boolean.valueOf(false)));
      this.a = true;
      return;
    case 2131434484: 
      ((IRIJAdUtilService)QRoute.api(IRIJAdUtilService.class)).setAdInfoClickPos(paramAdvertisementInfo, 37, paramIVideoFeedsPlayManager);
      a(paramBaseItemHolder, paramVideoInfo, paramAdvertisementInfo, 37);
      return;
    case 2131434482: 
      ((IRIJAdUtilService)QRoute.api(IRIJAdUtilService.class)).setAdInfoClickPos(paramAdvertisementInfo, 34, paramIVideoFeedsPlayManager);
      a(paramBaseItemHolder, paramVideoInfo, paramAdvertisementInfo, 34);
      return;
    case 2131434481: 
      a(paramBaseItemHolder, paramVideoInfo, paramAdvertisementInfo, 18);
      return;
    case 2131432128: 
      ((IRIJAdUtilService)QRoute.api(IRIJAdUtilService.class)).setAdInfoClickPos(paramAdvertisementInfo, 2003, paramIVideoFeedsPlayManager);
      a(paramBaseItemHolder, paramVideoInfo, paramAdvertisementInfo, 2003);
      return;
    case 2131432124: 
    case 2131434483: 
      ((IRIJAdUtilService)QRoute.api(IRIJAdUtilService.class)).setAdInfoClickPos(paramAdvertisementInfo, 35, paramIVideoFeedsPlayManager);
      a(paramBaseItemHolder, paramVideoInfo, paramAdvertisementInfo, 35);
      return;
    }
    ((IRIJAdUtilService)QRoute.api(IRIJAdUtilService.class)).setAdInfoClickPos(paramAdvertisementInfo, 18, paramIVideoFeedsPlayManager);
    paramView = ((IRIJAdActionUtilService)QRoute.api(IRIJAdActionUtilService.class)).JumpToGdtAdPageOrNotQqbPage(this.l, paramAdvertisementInfo, null, 3, true, null);
    paramBaseItemHolder = ((IRIJAdEntityConvertService)QRoute.api(IRIJAdEntityConvertService.class)).convertVideoAd2AdsInfo(paramVideoInfo.as);
    ((IRIJAdService)QRoute.api(IRIJAdService.class)).report(new AdReportData().a(this.k).a(1).b(21).b(paramView).a(paramBaseItemHolder).a(paramVideoInfo.as).c(1000));
  }
  
  private void a(ADVideoItemHolder paramADVideoItemHolder, VideoInfo paramVideoInfo, AdvertisementInfo paramAdvertisementInfo, int paramInt, View paramView, View... paramVarArgs)
  {
    if (paramVideoInfo.aq)
    {
      int i1;
      if (paramAdvertisementInfo != null) {
        i1 = paramAdvertisementInfo.clickPos;
      } else {
        i1 = 1000;
      }
      if ((((IRIJAdUtilService)QRoute.api(IRIJAdUtilService.class)).isAppAdvertisementInfo(paramAdvertisementInfo)) && (ReadInJoyAdSwitchUtil.d(paramVideoInfo.as)))
      {
        boolean bool = this.o.a(paramVideoInfo);
        int i2 = 0;
        if (bool)
        {
          paramADVideoItemHolder = ((IRIJAdActionUtilService)QRoute.api(IRIJAdActionUtilService.class)).JumpToGdtAdPageOrNotQqbPage(this.l, paramAdvertisementInfo, null, 3, true, null);
          if (paramInt == 21)
          {
            ((IRIJAdService)QRoute.api(IRIJAdService.class)).report(new AdReportData().a(this.k).a(1).b(21).b(paramADVideoItemHolder).a(paramAdvertisementInfo).a(paramVideoInfo.as).c(i1));
            return;
          }
          a(paramVideoInfo, i1, paramADVideoItemHolder, false);
          return;
        }
        paramView.setVisibility(0);
        paramADVideoItemHolder.g = true;
        if (paramVarArgs != null)
        {
          paramInt = i2;
          while (paramInt < paramVarArgs.length)
          {
            paramVarArgs[paramInt].setVisibility(8);
            paramInt += 1;
          }
        }
        if (paramADVideoItemHolder.V != null) {
          paramADVideoItemHolder.V.a(i1);
        }
        this.o.d();
        paramADVideoItemHolder.g = true;
        AdVideoButtonUIUtils.a(paramADVideoItemHolder);
      }
    }
  }
  
  private void a(ADVideoItemHolder paramADVideoItemHolder, VideoInfo paramVideoInfo, AdvertisementInfo paramAdvertisementInfo, int paramInt, View[] paramArrayOfView1, View[] paramArrayOfView2)
  {
    if (paramVideoInfo.aq)
    {
      ((IRIJAdLogService)QRoute.api(IRIJAdLogService.class)).d("Q.pubaccount.video.feeds.VideoFeedsHardAdBarManager", "clickDownloadBtn click");
      if (paramInt == 21)
      {
        if (paramAdvertisementInfo != null) {
          paramAdvertisementInfo.setClickPos(38);
        }
        paramADVideoItemHolder = new AdJumpParams();
        paramADVideoItemHolder.c = true;
        paramADVideoItemHolder = ((IRIJAdActionUtilService)QRoute.api(IRIJAdActionUtilService.class)).JumpToGdtAdPageOrNotQqbPage(this.l, paramAdvertisementInfo, null, 3, true, paramADVideoItemHolder);
        paramAdvertisementInfo = ((IRIJAdEntityConvertService)QRoute.api(IRIJAdEntityConvertService.class)).convertVideoAd2AdsInfo(paramVideoInfo.as);
        ((IRIJAdService)QRoute.api(IRIJAdService.class)).report(new AdReportData().a(this.k).a(1).b(21).b(paramADVideoItemHolder).a(paramAdvertisementInfo).a(paramVideoInfo.as).a(ActionEntity.VIDEO_NORMAL_AD_GUIDE_BIG).c(38));
        return;
      }
      paramInt = 8;
      if (this.d) {
        paramInt = 13;
      }
      if (paramAdvertisementInfo != null) {
        paramAdvertisementInfo.setClickPos(paramInt);
      }
      paramADVideoItemHolder = new AdJumpParams();
      paramADVideoItemHolder.c = true;
      a(paramVideoInfo, paramInt, ((IRIJAdActionUtilService)QRoute.api(IRIJAdActionUtilService.class)).JumpToGdtAdPageOrNotQqbPage(this.l, paramAdvertisementInfo, null, 3, true, paramADVideoItemHolder), false);
    }
  }
  
  private void a(VideoInfo paramVideoInfo, AdvertisementInfo paramAdvertisementInfo)
  {
    if (paramVideoInfo.aq) {
      a(paramVideoInfo, 0, ((IRIJAdActionUtilService)QRoute.api(IRIJAdActionUtilService.class)).JumpToGdtAdPageOrNotQqbPage(this.l, paramAdvertisementInfo, null, 3, true, null), false);
    }
  }
  
  private void a(VideoInfo paramVideoInfo, AdvertisementInfo paramAdvertisementInfo, IVideoFeedsPlayManager paramIVideoFeedsPlayManager)
  {
    if (paramVideoInfo.aq)
    {
      ((IRIJAdUtilService)QRoute.api(IRIJAdUtilService.class)).setAdInfoClickPos(paramAdvertisementInfo, 10, paramIVideoFeedsPlayManager);
      a(paramVideoInfo, 10, ((IRIJAdActionUtilService)QRoute.api(IRIJAdActionUtilService.class)).JumpToGdtAdPageOrNotQqbPage(this.l, paramAdvertisementInfo, null, 3, false, null), true);
    }
  }
  
  private void a(BaseItemHolder paramBaseItemHolder, VideoInfo paramVideoInfo, AdvertisementInfo paramAdvertisementInfo)
  {
    if ((paramBaseItemHolder instanceof ADVideoItemHolder))
    {
      paramBaseItemHolder = (ADVideoItemHolder)paramBaseItemHolder;
      AdVideoButtonUIUtils.c(paramBaseItemHolder.aj);
      a(paramBaseItemHolder, paramVideoInfo, paramAdvertisementInfo, -1, paramBaseItemHolder.U, new View[0]);
    }
  }
  
  private void a(BaseItemHolder paramBaseItemHolder, VideoInfo paramVideoInfo, AdvertisementInfo paramAdvertisementInfo, IVideoFeedsPlayManager paramIVideoFeedsPlayManager)
  {
    if ((paramBaseItemHolder instanceof ADVideoItemHolder))
    {
      boolean bool = ((IRIJAdUtilService)QRoute.api(IRIJAdUtilService.class)).isAmsSubscribeAd(paramVideoInfo.as);
      int i1 = 13;
      if (bool)
      {
        b(paramVideoInfo.as);
        if (!this.d) {
          i1 = 8;
        }
        if (paramAdvertisementInfo != null) {
          paramAdvertisementInfo.setClickPos(i1);
        }
        ((IRIJAdService)QRoute.api(IRIJAdService.class)).report(new AdReportData().a(this.k).a(42).b(5).b(Integer.valueOf(21)).a(paramAdvertisementInfo));
        return;
      }
      ADVideoItemHolder localADVideoItemHolder = (ADVideoItemHolder)paramBaseItemHolder;
      if (!this.d) {
        i1 = 8;
      }
      ((IRIJAdUtilService)QRoute.api(IRIJAdUtilService.class)).setAdInfoClickPos(paramAdvertisementInfo, i1, paramIVideoFeedsPlayManager);
      paramBaseItemHolder = new View[1];
      paramBaseItemHolder[0] = localADVideoItemHolder.U;
      if (b(paramVideoInfo)) {
        paramBaseItemHolder = new View[0];
      }
      AdVideoButtonUIUtils.c(localADVideoItemHolder.aj);
      a(localADVideoItemHolder, paramVideoInfo, paramAdvertisementInfo, -1, paramBaseItemHolder, new View[0]);
    }
  }
  
  private void a(VideoItemHolder paramVideoItemHolder, AdvertisementInfo paramAdvertisementInfo, int paramInt, JSONObject paramJSONObject)
  {
    ((IRIJAdService)QRoute.api(IRIJAdService.class)).report(new AdReportData().a(this.k).a(2).b(paramInt).a(paramAdvertisementInfo).a(a(paramVideoItemHolder)).e(paramJSONObject).a(Integer.valueOf(1)));
  }
  
  public static boolean a(VideoAdInfo paramVideoAdInfo)
  {
    boolean bool2 = false;
    if (paramVideoAdInfo == null) {
      return false;
    }
    paramVideoAdInfo = ((IRIJAdEntityConvertService)QRoute.api(IRIJAdEntityConvertService.class)).convertVideoAd2AdsInfo(paramVideoAdInfo);
    boolean bool1 = bool2;
    if (!TextUtils.isEmpty(paramVideoAdInfo.mPopFormH5Url))
    {
      bool1 = bool2;
      if (ReadInJoyAdSwitchUtil.h(paramVideoAdInfo)) {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  private void b(VideoAdInfo paramVideoAdInfo)
  {
    paramVideoAdInfo = ((IRIJAdEntityConvertService)QRoute.api(IRIJAdEntityConvertService.class)).convertVideoAd2AdsInfo(paramVideoAdInfo);
    if (paramVideoAdInfo != null) {
      ((IRIJAdActionUtilService)QRoute.api(IRIJAdActionUtilService.class)).showPopSheetDialog(this.l, paramVideoAdInfo.mPopFormH5Url, paramVideoAdInfo.mAdRl, paramVideoAdInfo.mAdTraceId);
    }
  }
  
  private void b(VideoInfo paramVideoInfo, AdvertisementInfo paramAdvertisementInfo, IVideoFeedsPlayManager paramIVideoFeedsPlayManager)
  {
    if (paramVideoInfo.aq)
    {
      if (this.i)
      {
        this.i = false;
        ((IRIJAdUtilService)QRoute.api(IRIJAdUtilService.class)).setAdInfoClickPos(paramAdvertisementInfo, 1, paramIVideoFeedsPlayManager);
        a(paramVideoInfo, 1, ((IRIJAdActionUtilService)QRoute.api(IRIJAdActionUtilService.class)).JumpToGdtAdPageOrNotQqbPage(this.l, paramAdvertisementInfo, null, 3, false, null), false);
        return;
      }
      ((IRIJAdUtilService)QRoute.api(IRIJAdUtilService.class)).setAdInfoClickPos(paramAdvertisementInfo, 4, paramIVideoFeedsPlayManager);
      a(paramVideoInfo, 4, ((IRIJAdActionUtilService)QRoute.api(IRIJAdActionUtilService.class)).JumpToGdtAdPageOrNotQqbPage(this.l, paramAdvertisementInfo, null, 3, false, null), false);
    }
  }
  
  private void b(BaseItemHolder paramBaseItemHolder, VideoInfo paramVideoInfo, AdvertisementInfo paramAdvertisementInfo)
  {
    if ((paramBaseItemHolder instanceof ADVideoItemHolder))
    {
      if (((IRIJAdUtilService)QRoute.api(IRIJAdUtilService.class)).isAmsSubscribeAd(paramVideoInfo.as))
      {
        b(paramVideoInfo.as);
        if (paramAdvertisementInfo != null) {
          paramAdvertisementInfo.setClickPos(38);
        }
        ((IRIJAdService)QRoute.api(IRIJAdService.class)).report(new AdReportData().a(this.k).a(42).b(5).b(Integer.valueOf(21)).a(paramAdvertisementInfo));
      }
      else
      {
        ADVideoItemHolder localADVideoItemHolder = (ADVideoItemHolder)paramBaseItemHolder;
        paramBaseItemHolder = new View[2];
        paramBaseItemHolder[0] = localADVideoItemHolder.V;
        paramBaseItemHolder[1] = localADVideoItemHolder.U;
        if (b(paramVideoInfo))
        {
          paramBaseItemHolder = new View[1];
          paramBaseItemHolder[0] = localADVideoItemHolder.V;
        }
        AdVideoButtonUIUtils.c(localADVideoItemHolder.aj);
        a(localADVideoItemHolder, paramVideoInfo, paramAdvertisementInfo, 21, paramBaseItemHolder, new View[0]);
      }
      if ((this.p.o() != null) && (this.p.o().az != null)) {
        ReadInJoyAdUtils.a(this.p.o().az, true);
      }
    }
  }
  
  private void b(BaseItemHolder paramBaseItemHolder, VideoInfo paramVideoInfo, AdvertisementInfo paramAdvertisementInfo, int paramInt)
  {
    if ((paramBaseItemHolder != null) && (paramVideoInfo != null))
    {
      if (paramAdvertisementInfo == null) {
        return;
      }
      paramAdvertisementInfo.setClickPos(paramInt);
      paramBaseItemHolder = ((IRIJAdActionUtilService)QRoute.api(IRIJAdActionUtilService.class)).JumpToGdtAdPageOrNotQqbPage(this.l, paramAdvertisementInfo, null, 3, true, null);
      paramAdvertisementInfo = ((IRIJAdEntityConvertService)QRoute.api(IRIJAdEntityConvertService.class)).convertVideoAd2AdsInfo(paramVideoInfo.as);
      ((IRIJAdService)QRoute.api(IRIJAdService.class)).report(new AdReportData().a(this.k).a(1).b(21).b(paramBaseItemHolder).a(paramAdvertisementInfo).a(paramVideoInfo.as).c(paramInt));
    }
  }
  
  private boolean b(ADVideoItemHolder paramADVideoItemHolder)
  {
    return ((paramADVideoItemHolder.X == 5) || (paramADVideoItemHolder.X == 7)) && (!this.h) && (!this.a) && (ReadInJoyAdSwitchUtil.b(paramADVideoItemHolder.az.c.as)) && (this.j != null) && ((!paramADVideoItemHolder.U.f()) || (ReadInJoyAdUtils.b(paramADVideoItemHolder.az.c))) && (paramADVideoItemHolder.az.c.as.aj);
  }
  
  private static boolean b(VideoInfo paramVideoInfo)
  {
    return ReadInJoyAdUtils.a(paramVideoInfo);
  }
  
  private void c(VideoInfo paramVideoInfo, AdvertisementInfo paramAdvertisementInfo, IVideoFeedsPlayManager paramIVideoFeedsPlayManager)
  {
    if (paramVideoInfo.aq)
    {
      ((IRIJAdUtilService)QRoute.api(IRIJAdUtilService.class)).setAdInfoClickPos(paramAdvertisementInfo, 3, paramIVideoFeedsPlayManager);
      a(paramVideoInfo, 3, ((IRIJAdActionUtilService)QRoute.api(IRIJAdActionUtilService.class)).JumpToGdtAdPageOrNotQqbPage(this.l, paramAdvertisementInfo, null, 3, false, null), false);
    }
  }
  
  private boolean c(ADVideoItemHolder paramADVideoItemHolder)
  {
    boolean bool1 = true;
    boolean bool3 = true;
    boolean bool2 = bool1;
    if (paramADVideoItemHolder != null)
    {
      bool2 = bool1;
      if (paramADVideoItemHolder.az != null)
      {
        if (paramADVideoItemHolder.az.c == null) {
          return true;
        }
        paramADVideoItemHolder = paramADVideoItemHolder.az.c;
        bool1 = bool3;
        if (paramADVideoItemHolder.aq)
        {
          paramADVideoItemHolder = ((IRIJAdEntityConvertService)QRoute.api(IRIJAdEntityConvertService.class)).convertVideoAd2AdsInfo(paramADVideoItemHolder.as);
          bool1 = bool3;
          if (paramADVideoItemHolder != null)
          {
            bool1 = bool3;
            if (!paramADVideoItemHolder.mShowAdButton) {
              bool1 = false;
            }
          }
        }
        bool2 = bool1;
        if (QLog.isColorLevel())
        {
          paramADVideoItemHolder = new StringBuilder();
          paramADVideoItemHolder.append("showButton = ");
          paramADVideoItemHolder.append(bool1);
          QLog.d("Q.pubaccount.video.feeds.VideoFeedsHardAdBarManager", 2, paramADVideoItemHolder.toString());
          bool2 = bool1;
        }
      }
    }
    return bool2;
  }
  
  private void d(ADVideoItemHolder paramADVideoItemHolder)
  {
    if ((paramADVideoItemHolder != null) && (paramADVideoItemHolder.az != null) && (paramADVideoItemHolder.az.c != null) && (paramADVideoItemHolder.az.c.as != null))
    {
      Object localObject = paramADVideoItemHolder.az.c.as;
      int i1 = ReadInJoyAdSwitchUtil.g(((IRIJAdEntityConvertService)QRoute.api(IRIJAdEntityConvertService.class)).convertVideoAd2AdsInfo((VideoAdInfo)localObject));
      if (i1 == 1)
      {
        paramADVideoItemHolder = paramADVideoItemHolder.h;
        localObject = (LinearLayout.LayoutParams)paramADVideoItemHolder.getLayoutParams();
        if (localObject != null)
        {
          ((LinearLayout.LayoutParams)localObject).weight = 2.0F;
          paramADVideoItemHolder.setLayoutParams((ViewGroup.LayoutParams)localObject);
        }
      }
      else if (i1 == 2)
      {
        localObject = paramADVideoItemHolder.i;
        LinearLayout.LayoutParams localLayoutParams = (LinearLayout.LayoutParams)((View)localObject).getLayoutParams();
        if (localLayoutParams != null)
        {
          localLayoutParams.weight = 0.0F;
          ((View)localObject).setLayoutParams(localLayoutParams);
        }
        paramADVideoItemHolder = paramADVideoItemHolder.j;
        localObject = (LinearLayout.LayoutParams)paramADVideoItemHolder.getLayoutParams();
        if (localObject != null)
        {
          ((LinearLayout.LayoutParams)localObject).weight = 0.0F;
          paramADVideoItemHolder.setLayoutParams((ViewGroup.LayoutParams)localObject);
        }
      }
    }
  }
  
  private void d(VideoInfo paramVideoInfo, AdvertisementInfo paramAdvertisementInfo, IVideoFeedsPlayManager paramIVideoFeedsPlayManager)
  {
    if (paramVideoInfo.aq)
    {
      ((IRIJAdUtilService)QRoute.api(IRIJAdUtilService.class)).setAdInfoClickPos(paramAdvertisementInfo, 2, paramIVideoFeedsPlayManager);
      a(paramVideoInfo, 2, ((IRIJAdActionUtilService)QRoute.api(IRIJAdActionUtilService.class)).JumpToGdtAdPageOrNotQqbPage(this.l, paramAdvertisementInfo, null, 3, false, null), false);
    }
  }
  
  private void e(VideoInfo paramVideoInfo, AdvertisementInfo paramAdvertisementInfo, IVideoFeedsPlayManager paramIVideoFeedsPlayManager)
  {
    if (paramVideoInfo.aq)
    {
      ((IRIJAdUtilService)QRoute.api(IRIJAdUtilService.class)).setAdInfoClickPos(paramAdvertisementInfo, 2, paramIVideoFeedsPlayManager);
      a(paramVideoInfo, 2, ((IRIJAdActionUtilService)QRoute.api(IRIJAdActionUtilService.class)).JumpToGdtAdPageOrNotQqbPage(this.l, paramAdvertisementInfo, null, 3, false, null), false);
    }
  }
  
  private void f(VideoInfo paramVideoInfo, AdvertisementInfo paramAdvertisementInfo, IVideoFeedsPlayManager paramIVideoFeedsPlayManager)
  {
    if (paramVideoInfo.aq)
    {
      ((IRIJAdUtilService)QRoute.api(IRIJAdUtilService.class)).setAdInfoClickPos(paramAdvertisementInfo, 1000, paramIVideoFeedsPlayManager);
      a(paramVideoInfo, 1000, ((IRIJAdActionUtilService)QRoute.api(IRIJAdActionUtilService.class)).JumpToGdtAdPageOrNotQqbPage(this.l, paramAdvertisementInfo, null, 3, false, null), false);
    }
  }
  
  private void g(VideoInfo paramVideoInfo, AdvertisementInfo paramAdvertisementInfo, IVideoFeedsPlayManager paramIVideoFeedsPlayManager)
  {
    ((IRIJAdUtilService)QRoute.api(IRIJAdUtilService.class)).setAdInfoClickPos(paramAdvertisementInfo, 17, paramIVideoFeedsPlayManager);
    if (((IRIJAdUtilService)QRoute.api(IRIJAdUtilService.class)).isAmsSubscribeAd(paramVideoInfo.as))
    {
      b(paramVideoInfo.as);
      if (paramAdvertisementInfo != null) {
        paramAdvertisementInfo.setClickPos(17);
      }
      ((IRIJAdService)QRoute.api(IRIJAdService.class)).report(new AdReportData().a(this.k).a(42).b(5).b(Integer.valueOf(21)).a(paramAdvertisementInfo).a(ActionEntity.VIDEO_NORMAL_AD_GUIDE_BIG));
      return;
    }
    this.n.g();
    paramIVideoFeedsPlayManager = null;
    if (paramAdvertisementInfo != null) {
      paramIVideoFeedsPlayManager = ((IRIJAdActionUtilService)QRoute.api(IRIJAdActionUtilService.class)).JumpToGdtAdPageOrNotQqbPage(this.l, paramAdvertisementInfo, null, 3, true, null);
    }
    a(paramVideoInfo, 17, paramIVideoFeedsPlayManager, true);
  }
  
  private void h(VideoInfo paramVideoInfo, AdvertisementInfo paramAdvertisementInfo, IVideoFeedsPlayManager paramIVideoFeedsPlayManager)
  {
    ((IRIJAdUtilService)QRoute.api(IRIJAdUtilService.class)).setAdInfoClickPos(paramAdvertisementInfo, 16, paramIVideoFeedsPlayManager);
    this.n.g();
    a(paramVideoInfo, 16, ((IRIJAdActionUtilService)QRoute.api(IRIJAdActionUtilService.class)).JumpToGdtAdPageOrNotQqbPage(this.l, paramAdvertisementInfo, null, 3, true, null), true);
  }
  
  private void i(VideoInfo paramVideoInfo, AdvertisementInfo paramAdvertisementInfo, IVideoFeedsPlayManager paramIVideoFeedsPlayManager)
  {
    ((IRIJAdUtilService)QRoute.api(IRIJAdUtilService.class)).setAdInfoClickPos(paramAdvertisementInfo, 15, paramIVideoFeedsPlayManager);
    this.n.g();
    a(paramVideoInfo, 15, ((IRIJAdActionUtilService)QRoute.api(IRIJAdActionUtilService.class)).JumpToGdtAdPageOrNotQqbPage(this.l, paramAdvertisementInfo, null, 3, true, null), true);
  }
  
  @Nullable
  public AdvertisementInfo a(VideoInfo paramVideoInfo, boolean paramBoolean)
  {
    if (paramVideoInfo.aq)
    {
      paramVideoInfo = ReadInJoyVideoFeedsAdUtils.a(paramVideoInfo.as);
      this.e = ((GdtHandler.Params)((IRIJAdActionUtilService)QRoute.api(IRIJAdActionUtilService.class)).getAdInfoParams(this.l, paramVideoInfo, null, 3, paramBoolean, null));
      long l1;
      if (this.e != null) {
        l1 = SystemClock.elapsedRealtime();
      } else {
        l1 = -2147483648L;
      }
      this.f = l1;
      return paramVideoInfo;
    }
    return null;
  }
  
  public AdvertisementInfo a(Object paramObject, boolean paramBoolean)
  {
    return a((VideoInfo)paramObject, paramBoolean);
  }
  
  public void a()
  {
    if (this.p.o() == null) {
      return;
    }
    if ((this.p.p() != null) && (this.p.p().k()) && ((this.p.o() instanceof ADVideoItemHolder))) {
      a(true, (ADVideoItemHolder)this.p.o());
    }
  }
  
  public void a(long paramLong)
  {
    if ((this.p.o() instanceof ADVideoItemHolder))
    {
      ADVideoItemHolder localADVideoItemHolder = (ADVideoItemHolder)this.p.o();
      int i1 = ReadInJoyAdUtils.a(localADVideoItemHolder.az.c.as.R, false);
      Object localObject;
      if (((localADVideoItemHolder.X == 5) || (localADVideoItemHolder.X == 7)) && (paramLong >= i1) && (!this.d))
      {
        localObject = this.j;
        if (localObject != null)
        {
          ((Handler)localObject).sendEmptyMessage(6);
          this.d = true;
          if (AdVideoPendantUIUtils.a(localADVideoItemHolder.az.c)) {
            this.j.sendEmptyMessage(8);
          }
        }
      }
      if (b(localADVideoItemHolder))
      {
        int i2 = ReadInJoyAdUtils.a(localADVideoItemHolder.az.c.as.R, true);
        i1 = i2;
        if (i2 < 0) {
          i1 = ((IPublicAccountConfigUtil)QRoute.api(IPublicAccountConfigUtil.class)).readInJoyADGuideCardShowTime() * 1000;
        }
        i2 = i1;
        if (b(localADVideoItemHolder.az.c))
        {
          i2 = i1;
          if (localADVideoItemHolder.az.c.as != null) {
            i2 = 3000;
          }
        }
        if ((paramLong >= i2) || (b(localADVideoItemHolder.az.c)))
        {
          if (localADVideoItemHolder.af.getVisibility() == 0) {
            localADVideoItemHolder.af.setVisibility(8);
          }
          this.j.sendEmptyMessage(7);
          if ((localADVideoItemHolder.U != null) && (localADVideoItemHolder.U.getDownloadData() != null))
          {
            localObject = (IRIJAdLogService)QRoute.api(IRIJAdLogService.class);
            StringBuilder localStringBuilder = new StringBuilder();
            localStringBuilder.append("show card with currentState = ");
            localStringBuilder.append(localADVideoItemHolder.U.getDownloadData().f);
            ((IRIJAdLogService)localObject).d("AD_DOWNLOAD_TAG", localStringBuilder.toString());
          }
          this.a = true;
        }
      }
    }
    else if ((this.p.o() instanceof BaseVideoItemHolder))
    {
      this.d = false;
    }
  }
  
  public void a(Message paramMessage)
  {
    if ((this.p.o() instanceof ADVideoItemHolder))
    {
      ADVideoItemHolder localADVideoItemHolder = (ADVideoItemHolder)this.p.o();
      Object localObject1 = localADVideoItemHolder.h;
      if (localObject1 == null) {
        return;
      }
      Object localObject2 = paramMessage.obj;
      paramMessage = localADVideoItemHolder.az.c.as;
      AdvertisementInfo localAdvertisementInfo = ((IRIJAdEntityConvertService)QRoute.api(IRIJAdEntityConvertService.class)).convertVideoAd2AdsInfo(paramMessage);
      if (localObject2 != null)
      {
        this.h = true;
        if (localADVideoItemHolder.u != null) {
          localADVideoItemHolder.u.setVisibility(8);
        }
        if (ReadInJoyAdSwitchUtil.d(paramMessage))
        {
          localObject2 = this.o;
          if (localObject2 != null) {
            ((IADVideoAppDownloadManager)localObject2).a();
          }
        }
        ((IVideoFeedsHelper)QRoute.api(IVideoFeedsHelper.class)).performViewSlideDownAnimator(localADVideoItemHolder.y, 250, 8, Utils.dp2px(200.0D));
        ((IVideoFeedsHelper)QRoute.api(IVideoFeedsHelper.class)).performViewSlideDownAnimator((View)localObject1, 250, 0, 250, ((View)localObject1).getMeasuredHeight());
        ((IRIJAdService)QRoute.api(IRIJAdService.class)).report(new AdReportData().a(this.k).a(ReportAction.CLOSE).a(1).b(21).b(Integer.valueOf(0)).a(localAdvertisementInfo).a(paramMessage).c(39));
        return;
      }
      if (this.b) {
        return;
      }
      localADVideoItemHolder = (ADVideoItemHolder)this.p.o();
      ((IVideoFeedsHelper)QRoute.api(IVideoFeedsHelper.class)).performViewSlideDownAnimator((View)localObject1, 250, 8, ((View)localObject1).getMeasuredHeight());
      if (!this.m) {
        AdVideoButtonUIUtils.b(localADVideoItemHolder.aj);
      }
      if (((ADVideoItemHolder)this.p.o()).u != null)
      {
        a((ADVideoItemHolder)this.p.o());
        ((ADVideoItemHolder)this.p.o()).u.setVisibility(0);
      }
      ((IVideoFeedsHelper)QRoute.api(IVideoFeedsHelper.class)).performViewSlideDownAnimator(((ADVideoItemHolder)this.p.o()).y, 250, 0, 250, Utils.dp2px(200.0D));
      if (ReadInJoyAdSwitchUtil.d(paramMessage))
      {
        localObject1 = ((ADVideoItemHolder)this.p.o()).V;
        if (localObject1 != null) {
          ((RIJDownloadView)localObject1).a(true);
        }
      }
      ((IRIJAdService)QRoute.api(IRIJAdService.class)).report(new AdReportData().a(this.k).a(2).b(21).a(ActionEntity.VIDEO_NORMAL_AD_GUIDE_BIG).a(localAdvertisementInfo).a(paramMessage));
    }
  }
  
  public void a(View paramView, BaseItemHolder paramBaseItemHolder, VideoInfo paramVideoInfo, IVideoFeedsPlayManager paramIVideoFeedsPlayManager)
  {
    boolean bool;
    if ((paramView.getId() != 2131427686) && (paramView.getId() != 2131427688)) {
      bool = false;
    } else {
      bool = true;
    }
    AdvertisementInfo localAdvertisementInfo = a(paramVideoInfo, bool);
    ADVideoItemHolder localADVideoItemHolder;
    switch (paramView.getId())
    {
    default: 
      break;
    case 2131434950: 
      e(paramVideoInfo, localAdvertisementInfo, paramIVideoFeedsPlayManager);
      break;
    case 2131432129: 
      ((IRIJAdUtilService)QRoute.api(IRIJAdUtilService.class)).setAdInfoClickPos(localAdvertisementInfo, 2004, paramIVideoFeedsPlayManager);
      a(paramBaseItemHolder, paramVideoInfo, localAdvertisementInfo, 2004);
      break;
    case 2131432128: 
      ((IRIJAdUtilService)QRoute.api(IRIJAdUtilService.class)).setAdInfoClickPos(localAdvertisementInfo, 2003, paramIVideoFeedsPlayManager);
      a(paramBaseItemHolder, paramVideoInfo, localAdvertisementInfo, 2003);
      break;
    case 2131432126: 
      ((IRIJAdUtilService)QRoute.api(IRIJAdUtilService.class)).setAdInfoClickPos(localAdvertisementInfo, 4002, paramIVideoFeedsPlayManager);
      b(paramBaseItemHolder, paramVideoInfo, localAdvertisementInfo, 4002);
      break;
    case 2131432125: 
      ((IRIJAdUtilService)QRoute.api(IRIJAdUtilService.class)).setAdInfoClickPos(localAdvertisementInfo, 4001, paramIVideoFeedsPlayManager);
      b(paramBaseItemHolder, paramVideoInfo, localAdvertisementInfo, 4001);
      break;
    case 2131432123: 
      ((IRIJAdUtilService)QRoute.api(IRIJAdUtilService.class)).setAdInfoClickPos(localAdvertisementInfo, 4000, paramIVideoFeedsPlayManager);
      b(paramBaseItemHolder, paramVideoInfo, localAdvertisementInfo, 4000);
      break;
    case 2131432121: 
      ((IRIJAdUtilService)QRoute.api(IRIJAdUtilService.class)).setAdInfoClickPos(localAdvertisementInfo, 4007, paramIVideoFeedsPlayManager);
      b(paramBaseItemHolder, paramVideoInfo, localAdvertisementInfo, 4007);
      break;
    case 2131427721: 
      f(paramVideoInfo, localAdvertisementInfo, paramIVideoFeedsPlayManager);
      break;
    case 2131427718: 
      b(paramVideoInfo, localAdvertisementInfo, paramIVideoFeedsPlayManager);
      break;
    case 2131427716: 
      a(paramVideoInfo, localAdvertisementInfo, paramIVideoFeedsPlayManager);
      break;
    case 2131427714: 
      c(paramVideoInfo, localAdvertisementInfo, paramIVideoFeedsPlayManager);
      break;
    case 2131427712: 
      d(paramVideoInfo, localAdvertisementInfo, paramIVideoFeedsPlayManager);
      break;
    case 2131427705: 
      a(paramView, paramVideoInfo, paramIVideoFeedsPlayManager);
      break;
    case 2131427693: 
      ((IRIJAdUtilService)QRoute.api(IRIJAdUtilService.class)).setAdInfoClickPos(localAdvertisementInfo, 13, paramIVideoFeedsPlayManager);
      a(paramBaseItemHolder, paramVideoInfo, localAdvertisementInfo);
      break;
    case 2131427690: 
      a(paramVideoInfo, localAdvertisementInfo);
      break;
    case 2131427688: 
      if ((((IRIJAdUtilService)QRoute.api(IRIJAdUtilService.class)).isAppAdvertisementInfo(localAdvertisementInfo)) && (RIJAdDownloadExKt.a(localAdvertisementInfo)))
      {
        localADVideoItemHolder = (ADVideoItemHolder)paramBaseItemHolder;
        localADVideoItemHolder.V.a(38);
        localADVideoItemHolder.g = true;
      }
      else
      {
        b(paramBaseItemHolder, paramVideoInfo, localAdvertisementInfo);
      }
      break;
    case 2131427686: 
      if ((((IRIJAdUtilService)QRoute.api(IRIJAdUtilService.class)).isAppAdvertisementInfo(localAdvertisementInfo)) && (!b(paramVideoInfo)) && (RIJAdDownloadExKt.a(localAdvertisementInfo)))
      {
        int i1 = 8;
        if (this.d) {
          i1 = 13;
        }
        localADVideoItemHolder = (ADVideoItemHolder)paramBaseItemHolder;
        localADVideoItemHolder.U.a(i1);
        localADVideoItemHolder.g = true;
      }
      else
      {
        a(paramBaseItemHolder, paramVideoInfo, localAdvertisementInfo, paramIVideoFeedsPlayManager);
      }
      break;
    case 2131427683: 
      a(paramBaseItemHolder, paramVideoInfo, localAdvertisementInfo, paramIVideoFeedsPlayManager);
    }
    a(paramView, paramBaseItemHolder, paramVideoInfo, localAdvertisementInfo, paramIVideoFeedsPlayManager);
  }
  
  public void a(View paramView, BaseItemHolder paramBaseItemHolder, Object paramObject1, Object paramObject2)
  {
    a(paramView, paramBaseItemHolder, (VideoInfo)paramObject1, (IVideoFeedsPlayManager)paramObject2);
  }
  
  public void a(ADVideoItemHolder paramADVideoItemHolder)
  {
    if ((paramADVideoItemHolder != null) && (paramADVideoItemHolder.az != null) && (paramADVideoItemHolder.az.c != null) && (paramADVideoItemHolder.az.c.as != null))
    {
      Object localObject = paramADVideoItemHolder.az.c.as;
      int i1 = ReadInJoyAdSwitchUtil.g(((IRIJAdEntityConvertService)QRoute.api(IRIJAdEntityConvertService.class)).convertVideoAd2AdsInfo((VideoAdInfo)localObject));
      if (i1 == 1)
      {
        paramADVideoItemHolder = paramADVideoItemHolder.v;
        if (paramADVideoItemHolder != null)
        {
          localObject = (LinearLayout.LayoutParams)paramADVideoItemHolder.getLayoutParams();
          if (localObject != null)
          {
            ((LinearLayout.LayoutParams)localObject).weight = 2.0F;
            paramADVideoItemHolder.setLayoutParams((ViewGroup.LayoutParams)localObject);
          }
        }
      }
      else if (i1 == 2)
      {
        localObject = paramADVideoItemHolder.w;
        if (localObject != null)
        {
          LinearLayout.LayoutParams localLayoutParams = (LinearLayout.LayoutParams)((View)localObject).getLayoutParams();
          if (localLayoutParams != null)
          {
            localLayoutParams.weight = 0.0F;
            ((View)localObject).setLayoutParams(localLayoutParams);
          }
        }
        paramADVideoItemHolder = paramADVideoItemHolder.x;
        if (paramADVideoItemHolder != null)
        {
          localObject = (LinearLayout.LayoutParams)paramADVideoItemHolder.getLayoutParams();
          if (localObject != null)
          {
            ((LinearLayout.LayoutParams)localObject).weight = 0.0F;
            paramADVideoItemHolder.setLayoutParams((ViewGroup.LayoutParams)localObject);
          }
        }
      }
    }
  }
  
  public void a(IADVideoAppDownloadManager paramIADVideoAppDownloadManager)
  {
    this.o = paramIADVideoAppDownloadManager;
  }
  
  public void a(VideoInfo paramVideoInfo)
  {
    if (paramVideoInfo != null)
    {
      if (paramVideoInfo.as == null) {
        return;
      }
      Object localObject1 = Aladdin.getConfig(447).getString("fling_right_to_left", "0");
      Object localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("fling_right_to_left = ");
      ((StringBuilder)localObject2).append((String)localObject1);
      ReadInJoyAdLog.a("Q.pubaccount.video.feeds.VideoFeedsHardAdBarManager", ((StringBuilder)localObject2).toString());
      if (!TextUtils.isEmpty((CharSequence)localObject1))
      {
        if (((String)localObject1).equals("0")) {
          return;
        }
        localObject1 = a(paramVideoInfo, false);
        ((AdvertisementInfo)localObject1).setClickPos(49);
        localObject2 = new AdJumpParams();
        ((AdJumpParams)localObject2).c = true;
        a(paramVideoInfo, 49, ReadinJoyActionUtil.b(this.l, (AdvertisementInfo)localObject1, null, 3, true, (AdJumpParams)localObject2), false);
      }
    }
  }
  
  public void a(VideoInfo paramVideoInfo, int paramInt, Integer paramInteger, boolean paramBoolean)
  {
    if (paramVideoInfo == null) {
      return;
    }
    if (this.p.p() != null) {
      this.p.p().a(ReportConstants.VideoEndType.AD_AREA_CLICK);
    }
    ActionEntity localActionEntity;
    if (paramBoolean) {
      localActionEntity = ActionEntity.VIDEO_NORMAL_AD_GUIDE_BIG;
    } else {
      localActionEntity = ActionEntity.Default;
    }
    AdvertisementInfo localAdvertisementInfo = ((IRIJAdEntityConvertService)QRoute.api(IRIJAdEntityConvertService.class)).convertVideoAd2AdsInfo(paramVideoInfo.as);
    int i1;
    if (paramVideoInfo.e(this.l)) {
      i1 = 10;
    } else {
      i1 = 5;
    }
    ((IRIJAdService)QRoute.api(IRIJAdService.class)).report(new AdReportData().a(this.k).a(1).b(i1).b(paramInteger).a(localAdvertisementInfo).a(paramVideoInfo.as).c(paramInt).a(localActionEntity));
  }
  
  public void a(BaseItemHolder paramBaseItemHolder, VideoInfo paramVideoInfo, AdvertisementInfo paramAdvertisementInfo, int paramInt)
  {
    if ((paramBaseItemHolder != null) && (paramVideoInfo != null))
    {
      if (paramAdvertisementInfo == null) {
        return;
      }
      paramAdvertisementInfo.setClickPos(paramInt);
      paramBaseItemHolder = ((IRIJAdActionUtilService)QRoute.api(IRIJAdActionUtilService.class)).JumpToGdtAdPageOrNotQqbPage(this.l, paramAdvertisementInfo, null, 3, true, null);
      paramAdvertisementInfo = ((IRIJAdEntityConvertService)QRoute.api(IRIJAdEntityConvertService.class)).convertVideoAd2AdsInfo(paramVideoInfo.as);
      ((IRIJAdService)QRoute.api(IRIJAdService.class)).report(new AdReportData().a(this.k).a(1).b(21).b(paramBaseItemHolder).a(paramAdvertisementInfo).a(paramVideoInfo.as).c(paramInt).a(ActionEntity.VIDEO_NORMAL_AD_GUIDE_BIG));
    }
  }
  
  public void a(boolean paramBoolean)
  {
    this.a = paramBoolean;
  }
  
  public void a(boolean paramBoolean, VideoItemHolder paramVideoItemHolder)
  {
    boolean bool3 = paramVideoItemHolder instanceof ADVideoItemHolder;
    if (!bool3) {
      return;
    }
    paramVideoItemHolder = (ADVideoItemHolder)paramVideoItemHolder;
    if ((paramBoolean) && (paramVideoItemHolder.U != null)) {
      paramVideoItemHolder.U.e();
    }
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (paramVideoItemHolder.az != null)
    {
      bool1 = bool2;
      if (paramVideoItemHolder.az.c != null)
      {
        bool1 = bool2;
        if (paramVideoItemHolder.az.c.as != null) {
          bool1 = ReadInJoyAdSwitchUtil.d(paramVideoItemHolder.az.c.as);
        }
      }
    }
    if ((paramVideoItemHolder.g) && (bool1))
    {
      AdVideoButtonUIUtils.b(paramVideoItemHolder.K);
      if (!this.m) {
        AdVideoButtonUIUtils.c(paramVideoItemHolder.aj);
      }
      if (b(paramVideoItemHolder.az.c))
      {
        AdVideoButtonUIUtils.a(paramVideoItemHolder.K);
        return;
      }
      AdVideoButtonUIUtils.a(paramVideoItemHolder.U);
      return;
    }
    if (paramVideoItemHolder.af.getVisibility() == 8) {
      AdVideoButtonUIUtils.a(paramVideoItemHolder.aj);
    }
    if ((paramVideoItemHolder.az != null) && (paramVideoItemHolder.az.c != null) && (paramVideoItemHolder.az.c.as != null)) {
      if (b(paramVideoItemHolder.az.c))
      {
        AdVideoButtonUIUtils.b(paramVideoItemHolder.U);
        AdVideoButtonUIUtils.a(paramVideoItemHolder.K);
      }
      else if (c(paramVideoItemHolder))
      {
        AdVideoButtonUIUtils.b(paramVideoItemHolder.K);
        AdVideoButtonUIUtils.a(paramVideoItemHolder.U);
        if (bool3) {
          AdVideoButtonUIUtils.a(this.l, paramVideoItemHolder);
        }
        AdVideoButtonUIUtils.a(paramBoolean, paramVideoItemHolder);
      }
      else
      {
        AdVideoButtonUIUtils.b(paramVideoItemHolder.K);
        AdVideoButtonUIUtils.b(paramVideoItemHolder.U);
      }
    }
    d(paramVideoItemHolder);
  }
  
  public boolean a(String paramString)
  {
    return this.q.contains(paramString);
  }
  
  public void b()
  {
    if (this.p.o() == null) {
      return;
    }
    if ((this.p.p() != null) && (this.p.p().k()) && ((this.p.o() instanceof ADVideoItemHolder))) {
      AdVideoPendantUIUtils.a(true, (ADVideoItemHolder)this.p.o(), this.m, this.p);
    }
  }
  
  public void b(boolean paramBoolean)
  {
    this.b = paramBoolean;
  }
  
  public void c()
  {
    if ((this.j != null) && (!this.g))
    {
      if (QLog.isColorLevel()) {
        QLog.d("NativeAdUtils", 2, "rePostMsgForAd");
      }
      this.g = true;
      this.j.removeMessages(4, null);
      this.j.sendEmptyMessageDelayed(4, 1000L);
    }
  }
  
  public void c(boolean paramBoolean)
  {
    this.c = paramBoolean;
  }
  
  public void d()
  {
    int i2 = 0;
    this.g = false;
    if ((this.p.o() instanceof VideoItemHolder))
    {
      VideoItemHolder localVideoItemHolder = (VideoItemHolder)this.p.o();
      if ((localVideoItemHolder.az != null) && (localVideoItemHolder.az.c != null) && (localVideoItemHolder.az.c.aq) && (localVideoItemHolder.az.c.as != null))
      {
        Object localObject = localVideoItemHolder.az.c.as.m;
        if (!this.q.contains(localObject))
        {
          this.q.add(localObject);
          localObject = ((IRIJAdEntityConvertService)QRoute.api(IRIJAdEntityConvertService.class)).convertVideoAd2AdsInfo(localVideoItemHolder.az.c.as);
          int i1 = 5;
          if (localVideoItemHolder.az.c.e(this.l)) {
            i1 = 10;
          }
          JSONObject localJSONObject1 = new JSONObject();
          JSONObject localJSONObject2 = new JSONObject();
          VideoAdTimeReportData localVideoAdTimeReportData = localVideoItemHolder.az.c.at;
          if ((VideoAdStrategyManager.b == 1) && (localVideoAdTimeReportData != null)) {
            try
            {
              localJSONObject2.put("slot", localVideoAdTimeReportData.a);
              localJSONObject2.put("stratege_time_b", localVideoAdTimeReportData.d);
            }
            catch (Exception localException1)
            {
              localException1.printStackTrace();
            }
          } else {
            try
            {
              if (this.p.q() != null) {
                i2 = this.p.q().getHeaderViewsCount();
              }
              localJSONObject2.put("slot", this.p.o().getAdapterPosition() - i2);
            }
            catch (JSONException localJSONException)
            {
              localJSONException.printStackTrace();
            }
          }
          try
          {
            VideoAdStrategyReportData localVideoAdStrategyReportData = localVideoItemHolder.az.c.au;
            localJSONObject2.put("last_ad_time", localVideoAdStrategyReportData.c);
            localJSONObject2.put("last_ad_distance", localVideoAdStrategyReportData.a);
            localJSONObject2.put("last_ad_distance_vv", localVideoAdStrategyReportData.b);
            localJSONObject1.put("exposure_info_report", localJSONObject2.toString());
          }
          catch (Exception localException2)
          {
            localException2.printStackTrace();
          }
          IRIJAdLogService localIRIJAdLogService = (IRIJAdLogService)QRoute.api(IRIJAdLogService.class);
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("exposure_info_report = ");
          localStringBuilder.append(localJSONObject2.toString());
          localIRIJAdLogService.d("Q.pubaccount.video.feeds.VideoFeedsHardAdBarManager", localStringBuilder.toString());
          a(localVideoItemHolder, (AdvertisementInfo)localObject, i1, localJSONObject1);
          AdReqFreshManager.a().a(Long.valueOf(localVideoItemHolder.az.c.as.G));
          AdExposeFreshManager.a().b("RIJAdRefreshSceneFloatVideo", localVideoItemHolder.az.c);
        }
      }
    }
  }
  
  public void d(boolean paramBoolean)
  {
    this.h = paramBoolean;
  }
  
  public void e(boolean paramBoolean)
  {
    this.i = paramBoolean;
  }
  
  public boolean e()
  {
    return this.a;
  }
  
  public boolean f()
  {
    return this.b;
  }
  
  public boolean g()
  {
    return this.h;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsHardAdBarManager
 * JD-Core Version:    0.7.0.1
 */