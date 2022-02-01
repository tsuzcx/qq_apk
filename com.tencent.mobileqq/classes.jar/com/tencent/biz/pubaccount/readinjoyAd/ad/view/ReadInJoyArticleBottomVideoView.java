package com.tencent.biz.pubaccount.readinjoyAd.ad.view;

import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.biz.pubaccount.NativeAd.module.AdModuleVideo;
import com.tencent.biz.pubaccount.NativeAd.report.constant.ReportAction;
import com.tencent.biz.pubaccount.NativeAd.report.constant.ReportConstants.VideoEndType;
import com.tencent.biz.pubaccount.readinjoy.struct.AdvertisementInfo;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.VafContext;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase;
import com.tencent.biz.pubaccount.readinjoyAd.ad.common_ad_action.report_action.ReadInJoyAdReportUtils;
import com.tencent.biz.pubaccount.readinjoyAd.ad.data.AdJumpParams;
import com.tencent.biz.pubaccount.readinjoyAd.ad.data.AdReportData;
import com.tencent.biz.pubaccount.readinjoyAd.ad.data.ProteusBannerVideoItemData;
import com.tencent.biz.pubaccount.readinjoyAd.ad.item.WebFastProteusViewAdBannerVideoCreator;
import com.tencent.biz.pubaccount.readinjoyAd.ad.jump.liujin.LiujinAdJump;
import com.tencent.biz.pubaccount.readinjoyAd.ad.utils.AdVideoButtonUIUtils;
import com.tencent.biz.pubaccount.readinjoyAd.ad.utils.FastWeqAdUtils;
import com.tencent.biz.pubaccount.readinjoyAd.ad.utils.ReadInJoyAdSwitchUtil;
import com.tencent.biz.pubaccount.readinjoyAd.ad.video.FastWebVideoPlayManager;
import com.tencent.biz.pubaccount.readinjoyAd.ad.video.VideoStateCallback;
import com.tencent.biz.pubaccount.util.ReadinJoyActionUtil;
import com.tencent.common.app.AppInterface;
import com.tencent.gdtad.aditem.GdtHandler.Params;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.kandian.ad.api.IRIJAdActionUtilService;
import com.tencent.mobileqq.kandian.ad.api.IRIJAdEntityConvertService;
import com.tencent.mobileqq.kandian.ad.api.IRIJAdLogService;
import com.tencent.mobileqq.kandian.ad.api.IRIJAdService;
import com.tencent.mobileqq.kandian.ad.api.IRIJAdUtilService;
import com.tencent.mobileqq.kandian.base.image.api.IPublicAccountHttpDownloader;
import com.tencent.mobileqq.kandian.biz.comment.util.api.IRIJCommentAdUtil;
import com.tencent.mobileqq.kandian.biz.video.api.IVideoFeedsHelper;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.vip.CUKingCardUtils;
import com.tencent.qphone.base.util.BaseApplication;
import cooperation.qzone.util.NetworkState;
import java.lang.ref.WeakReference;

public class ReadInJoyArticleBottomVideoView
  extends ViewBase
  implements View.OnClickListener, IReadInJoyArticleBottomVideoView
{
  public static String a;
  public static boolean b = false;
  private ImageView c;
  private URLImageView d;
  private TextView e;
  private View f;
  private LinearLayout g;
  private RelativeLayout h;
  private ReadInJoyAdVideoGuide i;
  private ViewGroup j;
  private View k;
  private TextView l;
  private Handler m;
  private AdModuleVideo n;
  private WeakReference<Context> o = null;
  private AdvertisementInfo p;
  private AppInterface q;
  private boolean r = false;
  private boolean s = false;
  private boolean t = true;
  private ProteusBannerVideoItemData u;
  private boolean v = false;
  private View w;
  private long x = 0L;
  private VideoStateCallback y = new ReadInJoyArticleBottomVideoView.1(this);
  
  public ReadInJoyArticleBottomVideoView(VafContext paramVafContext)
  {
    super(paramVafContext);
    this.o = new WeakReference(paramVafContext.getContext());
    a(paramVafContext.getContext());
  }
  
  private void a(Context paramContext)
  {
    IRIJAdLogService localIRIJAdLogService = (IRIJAdLogService)QRoute.api(IRIJAdLogService.class);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("bottomView create:");
    localStringBuilder.append(hashCode());
    localIRIJAdLogService.d("VideoPlayerWrapper_AD", localStringBuilder.toString());
    if (paramContext == null) {
      return;
    }
    this.w = ((LayoutInflater)paramContext.getSystemService("layout_inflater")).inflate(2131626128, null);
    this.m = new Handler(Looper.getMainLooper());
    this.o = new WeakReference(paramContext.getApplicationContext());
    f();
  }
  
  private void a(View paramView, boolean paramBoolean, int paramInt)
  {
    if (this.u != null)
    {
      Object localObject1 = ((IRIJAdEntityConvertService)QRoute.api(IRIJAdEntityConvertService.class)).convertAdData2AdsInfo(this.u);
      Object localObject2 = localObject1;
      if (this.u.b)
      {
        localObject3 = this.p;
        localObject2 = localObject1;
        if (localObject3 != null) {
          localObject2 = localObject3;
        }
      }
      if (localObject2 != null) {
        localObject2.clickPos = paramInt;
      }
      localObject1 = ReadinJoyActionUtil.a(paramView.getContext(), this.u, localObject2);
      if (((Integer)localObject1).intValue() != -1) {
        return;
      }
      if (LiujinAdJump.isFromLiuJin(localObject2)) {
        localObject1 = LiujinAdJump.doJumpAction(localObject2, (Context)this.o.get(), paramBoolean);
      }
      if (((Integer)localObject1).intValue() != -1)
      {
        ReadInJoyAdReportUtils.a(ReportAction.CLICK, (Integer)localObject1, localObject2, 1, 1, 3);
        return;
      }
      boolean bool = d();
      Object localObject3 = (GdtHandler.Params)((IRIJAdActionUtilService)QRoute.api(IRIJAdActionUtilService.class)).getAdInfoParams(paramView.getContext(), localObject2, null, 2, paramBoolean, new AdJumpParams(bool));
      if (localObject3 == null) {
        return;
      }
      ((GdtHandler.Params)localObject3).l = ReadInJoyAdSwitchUtil.b(this.u);
      ((GdtHandler.Params)localObject3).k = FastWebVideoPlayManager.a.i();
      if (localObject2 != null) {
        localObject2.setClickPos(paramInt);
      }
      if ((localObject2 != null) && (localObject2.isCommentAd())) {
        ((IRIJCommentAdUtil)QRoute.api(IRIJCommentAdUtil.class)).jumpToLandingPage(paramView.getContext(), 0L, localObject2);
      } else {
        localObject1 = ((IRIJAdActionUtilService)QRoute.api(IRIJAdActionUtilService.class)).jumpToGdtAdPage(localObject3, paramView.getContext(), localObject2);
      }
      if (localObject2 != null) {
        localObject2.setClickPos(paramInt);
      }
      WebFastProteusViewAdBannerVideoCreator.f = (GdtHandler.Params)localObject3;
      long l1;
      if (WebFastProteusViewAdBannerVideoCreator.f != null) {
        l1 = SystemClock.elapsedRealtime();
      } else {
        l1 = -2147483648L;
      }
      WebFastProteusViewAdBannerVideoCreator.g = l1;
      if ((localObject2 != null) && (!localObject2.isCommentAd())) {
        ((IRIJAdService)QRoute.api(IRIJAdService.class)).report(new AdReportData().a(this.q).a(BaseApplication.getContext()).a(1).b(8).b((Integer)localObject1).a(localObject2).d(((IRIJAdUtilService)QRoute.api(IRIJAdUtilService.class)).getBusiJson(this.u)).c(paramInt));
      }
      if ((localObject2 != null) && (localObject2.isCommentAd()))
      {
        FastWebVideoPlayManager.a.k();
        return;
      }
      a(true);
    }
  }
  
  private void b(boolean paramBoolean)
  {
    try
    {
      b = paramBoolean;
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  private void f()
  {
    View localView = this.w;
    if (localView == null) {
      return;
    }
    this.c = ((ImageView)localView.findViewById(2131449442));
    this.c.setOnClickListener(this);
    this.d = ((URLImageView)this.w.findViewById(2131428505));
    this.d.setScaleType(ImageView.ScaleType.CENTER_CROP);
    this.e = ((TextView)this.w.findViewById(2131428506));
    this.e.setOnClickListener(this);
    this.f = this.w.findViewById(2131428509);
    this.f.setOnClickListener(this);
    this.g = ((LinearLayout)this.w.findViewById(2131428511));
    this.h = ((RelativeLayout)this.w.findViewById(2131449512));
    this.h.setOnClickListener(this);
    this.i = ((ReadInJoyAdVideoGuide)this.w.findViewById(2131427698));
    this.i.setAdGuideClickListener(new ReadInJoyArticleBottomVideoView.2(this));
    this.j = ((ViewGroup)this.w.findViewById(2131449443));
    this.k = this.w.findViewById(2131449656);
    this.l = ((TextView)this.w.findViewById(2131450346));
    this.j.setOnClickListener(this);
    b(false);
  }
  
  private void g()
  {
    if (this.v)
    {
      ((IRIJAdLogService)QRoute.api(IRIJAdLogService.class)).d("VideoPlayerWrapper_AD", "onVideoStartUI  with hasShowCompleteGuide");
      return;
    }
    ((IRIJAdLogService)QRoute.api(IRIJAdLogService.class)).d("VideoPlayerWrapper_AD", "onVideoStartUI");
    AdVideoButtonUIUtils.b(this.j);
    AdVideoButtonUIUtils.b(this.c);
    AdVideoButtonUIUtils.b(this.d);
    AdVideoButtonUIUtils.b(this.i);
    AdVideoButtonUIUtils.b(this.e);
    AdVideoButtonUIUtils.b(this.g);
    AdVideoButtonUIUtils.a(this.h);
  }
  
  private void h()
  {
    if (this.v)
    {
      ((IRIJAdLogService)QRoute.api(IRIJAdLogService.class)).d("VideoPlayerWrapper_AD", "onVideoPauseUI  with hasShowCompleteGuide");
      return;
    }
    ((IRIJAdLogService)QRoute.api(IRIJAdLogService.class)).d("VideoPlayerWrapper_AD", "onVideoPauseUI");
    AdVideoButtonUIUtils.a(this.h);
    if (NetworkState.isWifiConn())
    {
      AdVideoButtonUIUtils.b(this.j);
      AdVideoButtonUIUtils.a(this.c);
    }
    else
    {
      AdVideoButtonUIUtils.a(this.j);
      AdVideoButtonUIUtils.b(this.c);
    }
    if (FastWebVideoPlayManager.a.h() == 7) {
      AdVideoButtonUIUtils.a(this.d);
    } else {
      AdVideoButtonUIUtils.b(this.d);
    }
    AdVideoButtonUIUtils.b(this.i);
    AdVideoButtonUIUtils.b(this.e);
    AdVideoButtonUIUtils.b(this.g);
  }
  
  private boolean i()
  {
    AdvertisementInfo localAdvertisementInfo = this.p;
    return (localAdvertisementInfo != null) && (localAdvertisementInfo.isCommentAd());
  }
  
  private void j()
  {
    ((IRIJAdLogService)QRoute.api(IRIJAdLogService.class)).d("VideoPlayerWrapper_AD", "onVideoCompleteUI");
    this.v = true;
    ProteusBannerVideoItemData localProteusBannerVideoItemData = this.u;
    if (localProteusBannerVideoItemData != null) {
      localProteusBannerVideoItemData.a = true;
    }
    AdVideoButtonUIUtils.a(this.h);
    AdVideoButtonUIUtils.b(this.j);
    AdVideoButtonUIUtils.b(this.c);
    AdVideoButtonUIUtils.b(this.e);
    AdVideoButtonUIUtils.b(this.g);
    AdVideoButtonUIUtils.a(this.d);
    if (i())
    {
      AdVideoButtonUIUtils.b(this.i);
      q();
      return;
    }
    AdVideoButtonUIUtils.a(this.i);
  }
  
  private void k()
  {
    ((IRIJAdLogService)QRoute.api(IRIJAdLogService.class)).d("VideoPlayerWrapper_AD", "onVideoErrorUI");
    h();
    AdVideoButtonUIUtils.a(this.d);
  }
  
  private Context l()
  {
    WeakReference localWeakReference = this.o;
    if (localWeakReference != null) {
      return (Context)localWeakReference.get();
    }
    return null;
  }
  
  private void m()
  {
    ((IRIJAdLogService)QRoute.api(IRIJAdLogService.class)).d("VideoPlayerWrapper_AD", "initCoverView");
    if (this.d == null) {
      return;
    }
    try
    {
      if ((this.n != null) && (!TextUtils.isEmpty(this.n.r)))
      {
        a = this.n.r;
        Object localObject = URLDrawable.URLDrawableOptions.obtain();
        ((URLDrawable.URLDrawableOptions)localObject).mPlayGifImage = true;
        ((URLDrawable.URLDrawableOptions)localObject).mLoadingDrawable = new ColorDrawable(-16777216);
        ((URLDrawable.URLDrawableOptions)localObject).mMemoryCacheKeySuffix = "fast_web";
        localObject = URLDrawable.getDrawable(((IPublicAccountHttpDownloader)QRoute.api(IPublicAccountHttpDownloader.class)).makeURL(a, 4), (URLDrawable.URLDrawableOptions)localObject);
        if ((localObject != null) && (((URLDrawable)localObject).getStatus() == 2)) {
          ((URLDrawable)localObject).restartDownload();
        }
        this.d.setImageDrawable((Drawable)localObject);
        return;
      }
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  private void n()
  {
    ReadInJoyAdVideoGuide localReadInJoyAdVideoGuide = this.i;
    if (localReadInJoyAdVideoGuide != null)
    {
      ProteusBannerVideoItemData localProteusBannerVideoItemData = this.u;
      if (localProteusBannerVideoItemData != null) {
        localReadInJoyAdVideoGuide.setAppInfo(localProteusBannerVideoItemData.s, this.u.aa, this.u.u, this.u.t, FastWeqAdUtils.h(this.u), this.p);
      }
    }
  }
  
  private void o()
  {
    if (this.l != null)
    {
      String str = HardCodeUtil.a(2131910550);
      Object localObject;
      if (CUKingCardUtils.a() == 1)
      {
        localObject = HardCodeUtil.a(2131910304);
      }
      else
      {
        ProteusBannerVideoItemData localProteusBannerVideoItemData = this.u;
        localObject = str;
        if (localProteusBannerVideoItemData != null)
        {
          localObject = str;
          if (localProteusBannerVideoItemData.c > 0L)
          {
            localObject = new StringBuilder();
            ((StringBuilder)localObject).append(((IVideoFeedsHelper)QRoute.api(IVideoFeedsHelper.class)).fileSizeToString(this.u.c));
            ((StringBuilder)localObject).append(HardCodeUtil.a(2131910327));
            localObject = ((StringBuilder)localObject).toString();
          }
        }
      }
      this.l.setText((CharSequence)localObject);
    }
  }
  
  private int p()
  {
    AdvertisementInfo localAdvertisementInfo = this.p;
    if ((localAdvertisementInfo != null) && (localAdvertisementInfo.isCommentAd())) {
      return 38;
    }
    return 1;
  }
  
  private void q()
  {
    this.r = false;
    this.u.a = false;
    this.v = false;
    this.t = true;
    FastWebVideoPlayManager.a.a(true);
    FastWebVideoPlayManager.a.a((Context)this.o.get(), this.h, this.n, this.p, this.u);
  }
  
  public long a()
  {
    return FastWebVideoPlayManager.a.i();
  }
  
  public void a(AdModuleVideo paramAdModuleVideo, AdvertisementInfo paramAdvertisementInfo, ProteusBannerVideoItemData paramProteusBannerVideoItemData1, ProteusBannerVideoItemData paramProteusBannerVideoItemData2)
  {
    if (FastWebVideoPlayManager.a.a(paramProteusBannerVideoItemData1)) {
      return;
    }
    this.n = paramAdModuleVideo;
    this.p = paramAdvertisementInfo;
    this.u = paramProteusBannerVideoItemData1;
    m();
    n();
    o();
    paramAdvertisementInfo = (IRIJAdLogService)QRoute.api(IRIJAdLogService.class);
    paramProteusBannerVideoItemData2 = new StringBuilder();
    paramProteusBannerVideoItemData2.append("view videoContainer is ");
    paramProteusBannerVideoItemData2.append(this.h.hashCode());
    paramAdvertisementInfo.d("VideoPlayerWrapper_AD", paramProteusBannerVideoItemData2.toString());
    FastWebVideoPlayManager.a.a(paramProteusBannerVideoItemData1.G, this.y);
    FastWebVideoPlayManager.a.a(false);
    FastWebVideoPlayManager.a.a((Context)this.o.get(), this.h, paramAdModuleVideo, this.p, paramProteusBannerVideoItemData1);
  }
  
  public void a(boolean paramBoolean)
  {
    if (paramBoolean) {
      FastWebVideoPlayManager.a.a(ReportConstants.VideoEndType.AD_AREA_CLICK);
    } else {
      FastWebVideoPlayManager.a.a(ReportConstants.VideoEndType.SLIDE_LEAVE);
    }
    FastWebVideoPlayManager.a.g();
  }
  
  public void b()
  {
    if (i())
    {
      if (this.v)
      {
        q();
        return;
      }
      FastWebVideoPlayManager.a.f();
      return;
    }
    FastWebVideoPlayManager.a.f();
  }
  
  public void c() {}
  
  public boolean d()
  {
    return FastWebVideoPlayManager.a.j();
  }
  
  public void e() {}
  
  public int getComMeasuredHeight()
  {
    View localView = this.w;
    if (localView != null) {
      return localView.getMeasuredHeight();
    }
    return 0;
  }
  
  public int getComMeasuredWidth()
  {
    View localView = this.w;
    if (localView != null) {
      return localView.getMeasuredWidth();
    }
    return 0;
  }
  
  public View getNativeView()
  {
    return this.w;
  }
  
  public void onClick(View paramView)
  {
    int i1;
    if (d()) {
      i1 = 6;
    } else {
      i1 = 5;
    }
    a(paramView, false, i1);
  }
  
  public void onComLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    View localView = this.w;
    if (localView != null) {
      localView.layout(paramInt1, paramInt2, paramInt3, paramInt4);
    }
  }
  
  public void onComMeasure(int paramInt1, int paramInt2)
  {
    View localView = this.w;
    if (localView != null) {
      localView.measure(paramInt1, paramInt2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoyAd.ad.view.ReadInJoyArticleBottomVideoView
 * JD-Core Version:    0.7.0.1
 */