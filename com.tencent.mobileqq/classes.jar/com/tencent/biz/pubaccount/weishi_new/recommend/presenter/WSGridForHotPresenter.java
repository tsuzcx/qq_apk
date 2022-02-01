package com.tencent.biz.pubaccount.weishi_new.recommend.presenter;

import UserGrowth.stGlobalConfig;
import UserGrowth.stJumpInfo;
import UserGrowth.stNotificationRsp;
import UserGrowth.stSimpleMetaFeed;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import com.qq.taf.jce.JceStruct;
import com.tencent.biz.pubaccount.weishi_new.WSUserAuthDialog;
import com.tencent.biz.pubaccount.weishi_new.WeishiConstants;
import com.tencent.biz.pubaccount.weishi_new.cache.WeiShiCacheManager;
import com.tencent.biz.pubaccount.weishi_new.config.experiment.WSExpABTestManager;
import com.tencent.biz.pubaccount.weishi_new.download.wsapp.WSFallKeyPicMonitor;
import com.tencent.biz.pubaccount.weishi_new.drama.cache.IFetchDataListener;
import com.tencent.biz.pubaccount.weishi_new.drama.cache.WSGetFollowDramaFetcher;
import com.tencent.biz.pubaccount.weishi_new.drama.data.WSFollowDramaData;
import com.tencent.biz.pubaccount.weishi_new.event.WSSimpleEventBus;
import com.tencent.biz.pubaccount.weishi_new.event.WSUserAuthEvent;
import com.tencent.biz.pubaccount.weishi_new.net.RspHeaderBean;
import com.tencent.biz.pubaccount.weishi_new.recommend.WSGridPageContract.View;
import com.tencent.biz.pubaccount.weishi_new.recommend.data.IWSNoticeRspListener;
import com.tencent.biz.pubaccount.weishi_new.recommend.data.WSNoticeDataManager;
import com.tencent.biz.pubaccount.weishi_new.recommend.utils.WSGridPageUtils;
import com.tencent.biz.pubaccount.weishi_new.report.WSLaunchDeltaTimeCalculator;
import com.tencent.biz.pubaccount.weishi_new.report.WSReportDc00898;
import com.tencent.biz.pubaccount.weishi_new.report.WsBeaconReportPresenter;
import com.tencent.biz.pubaccount.weishi_new.util.WSInitializeHelper;
import com.tencent.biz.pubaccount.weishi_new.util.WSLog;
import com.tencent.biz.pubaccount.weishi_new.util.WeishiLinkUtil;
import com.tencent.biz.pubaccount.weishi_new.util.WeishiScehmeUtil;
import com.tencent.biz.pubaccount.weishi_new.util.WeishiUtils;
import com.tencent.biz.qqstory.utils.WeishiGuideUtils;
import com.tencent.common.app.BaseApplicationImpl;
import java.util.List;

public class WSGridForHotPresenter
  extends AbsWSGridPagePresenter
  implements IWSNoticeRspListener
{
  private final WSNoticeDataManager f = new WSNoticeDataManager();
  private final WSGetFollowDramaFetcher g = new WSGetFollowDramaFetcher();
  private final IFetchDataListener<WSFollowDramaData> h = y();
  private long i = 0L;
  private long j = 0L;
  private long k = 0L;
  private long l = -1L;
  
  public WSGridForHotPresenter(String paramString)
  {
    super(paramString);
  }
  
  private void a(int paramInt)
  {
    WeishiLinkUtil.b();
    WeishiLinkUtil.a(paramInt);
  }
  
  private void a(stGlobalConfig paramstGlobalConfig, WSGridPageContract.View paramView)
  {
    if (WeishiGuideUtils.a(BaseApplicationImpl.getContext())) {
      paramView.a(paramstGlobalConfig);
    }
  }
  
  private void a(stGlobalConfig paramstGlobalConfig, String paramString, WSGridPageContract.View paramView)
  {
    int m;
    if ((paramstGlobalConfig.jumpinfo != null) && (!TextUtils.isEmpty(paramstGlobalConfig.jumpinfo.h5url)))
    {
      m = 1;
      paramView.a(paramstGlobalConfig.jumpinfo.h5url);
    }
    else
    {
      m = 2;
    }
    WSReportDc00898.a(m, 2, paramString);
  }
  
  private void a(@Nullable WSFollowDramaData paramWSFollowDramaData, boolean paramBoolean)
  {
    if (getView() == null) {
      return;
    }
    if ((paramWSFollowDramaData != null) && (paramWSFollowDramaData.a() != null) && (paramWSFollowDramaData.a().size() != 0))
    {
      ((WSGridPageContract.View)getView()).a(paramWSFollowDramaData, paramBoolean);
      return;
    }
    ((WSGridPageContract.View)getView()).l();
  }
  
  private void a(List<stSimpleMetaFeed> paramList, stGlobalConfig paramstGlobalConfig, String paramString, boolean paramBoolean)
  {
    WSGridPageContract.View localView = (WSGridPageContract.View)getView();
    if ((paramstGlobalConfig != null) && (localView != null))
    {
      int m = paramstGlobalConfig.link_strategy_type;
      localView.a(m, (stSimpleMetaFeed)paramList.get(0));
      if (paramBoolean) {
        WSFallKeyPicMonitor.a().b();
      }
      if ((m != 1) && (m != 2))
      {
        if (m != 4)
        {
          if (m != 7) {
            return;
          }
          a(paramstGlobalConfig, paramString, localView);
          return;
        }
        a(paramstGlobalConfig, localView);
        return;
      }
      localView.a(paramstGlobalConfig);
      return;
    }
    WSLog.d("WSGridForHotPresenterLog", "[WSGridForHotPresenter.java][performLinkStrategy] globalConfig is null!");
  }
  
  private void u()
  {
    if (this.k > 0L)
    {
      long l1 = System.currentTimeMillis() - this.k;
      this.k = 0L;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("[WSGridForHotPresenter.java][reportPageInitConst] initTime：");
      localStringBuilder.append(l1);
      WSLog.e("WSGridForHotPresenterLog", localStringBuilder.toString());
      WsBeaconReportPresenter.a().a(true, l1);
      WsBeaconReportPresenter.a().a(true, l1, "feeds", "feeds");
    }
  }
  
  private void v()
  {
    WSReportDc00898.a(6, this.e);
  }
  
  private void w()
  {
    if (!WeishiConstants.a)
    {
      this.i = (System.currentTimeMillis() - this.j);
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("[WSGridForHotPresenter.java][reportBeaconAnd898Exit] exitPublicAccount mStayTime:");
      ((StringBuilder)localObject).append(this.i);
      WSLog.e("WSGridForHotPresenterLog", ((StringBuilder)localObject).toString());
      this.j = 0L;
    }
    Object localObject = (WSGridPageContract.View)getView();
    if (localObject == null) {
      return;
    }
    int m = ((WSGridPageContract.View)localObject).d();
    WSReportDc00898.a(117, new Object[] { Long.valueOf(this.i), Integer.valueOf(m) });
    WsBeaconReportPresenter.a().a(this.i, this.l, m, WeishiUtils.a, WeishiScehmeUtil.b, 1);
  }
  
  private void x()
  {
    WeiShiCacheManager.a().c(new WSGridForHotPresenter.1(this));
  }
  
  private IFetchDataListener<WSFollowDramaData> y()
  {
    return new WSGridForHotPresenter.2(this);
  }
  
  public void a()
  {
    super.a();
    this.k = System.currentTimeMillis();
    a(this.a);
    WSFallKeyPicMonitor.a().a(BaseApplicationImpl.getContext());
    if (k()) {
      x();
    }
  }
  
  public void a(int paramInt, String paramString)
  {
    WSFallKeyPicMonitor.b(2);
  }
  
  public void a(stNotificationRsp paramstNotificationRsp, RspHeaderBean paramRspHeaderBean)
  {
    WSGridPageContract.View localView = (WSGridPageContract.View)getView();
    if (localView != null)
    {
      localView.b();
      localView.a(paramstNotificationRsp, paramRspHeaderBean);
    }
    WSFallKeyPicMonitor.a(2);
  }
  
  protected void a(JceStruct paramJceStruct, boolean paramBoolean1, boolean paramBoolean2)
  {
    super.a(paramJceStruct, paramBoolean1, paramBoolean2);
  }
  
  public void a(String paramString)
  {
    this.f.a(paramString, this);
  }
  
  protected void a(List<stSimpleMetaFeed> paramList, boolean paramBoolean, stGlobalConfig paramstGlobalConfig, int paramInt, long paramLong)
  {
    super.a(paramList, paramBoolean, paramstGlobalConfig, paramInt, paramLong);
    WSInitializeHelper.a().h().d();
    this.l = (System.currentTimeMillis() - paramLong);
    String str = WSGridPageUtils.a(false, paramInt, (stSimpleMetaFeed)paramList.get(0), this.e, this.c);
    if (WSUserAuthDialog.a()) {
      WSSimpleEventBus.a().a(new WSUserAuthEvent());
    }
    a(paramList, paramstGlobalConfig, str, paramBoolean);
    a(paramInt);
  }
  
  protected void a(List<stSimpleMetaFeed> paramList, boolean paramBoolean1, boolean paramBoolean2)
  {
    if (paramBoolean2) {
      WSInitializeHelper.a().h().e();
    }
    super.a(paramList, paramBoolean1, paramBoolean2);
  }
  
  public void b()
  {
    this.g.a(this.h);
  }
  
  public void c()
  {
    super.c();
    if (!WeishiConstants.a) {
      this.j = System.currentTimeMillis();
    } else {
      WeishiConstants.a = false;
    }
    u();
    v();
  }
  
  public void e()
  {
    super.e();
    WSFallKeyPicMonitor.a().c();
    w();
  }
  
  public boolean k()
  {
    return WSExpABTestManager.a().t();
  }
  
  public boolean l()
  {
    return true;
  }
  
  public boolean m()
  {
    return true;
  }
  
  protected boolean n()
  {
    boolean bool = WeishiUtils.b(8);
    int m = WeiShiCacheManager.a().b();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[WSGridForHotPresenter.java][isPreloadCacheValid] mSubTab:");
    localStringBuilder.append(this.c);
    localStringBuilder.append(", preloadCacheValid:");
    localStringBuilder.append(bool);
    localStringBuilder.append(", redCacheCount:");
    localStringBuilder.append(m);
    WSLog.e("WSGridForHotPresenterLog", localStringBuilder.toString());
    return (bool) && (m >= 8);
  }
  
  protected boolean o()
  {
    return false;
  }
  
  protected boolean p()
  {
    return false;
  }
  
  protected boolean q()
  {
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.recommend.presenter.WSGridForHotPresenter
 * JD-Core Version:    0.7.0.1
 */