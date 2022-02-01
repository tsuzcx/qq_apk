package com.tencent.biz.pubaccount.weishi_new.recommend.presenter;

import UserGrowth.stGlobalConfig;
import UserGrowth.stJumpInfo;
import UserGrowth.stNotificationRsp;
import UserGrowth.stSimpleMetaFeed;
import android.support.annotation.Nullable;
import android.text.TextUtils;
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
  private long jdField_a_of_type_Long = 0L;
  private final IFetchDataListener<WSFollowDramaData> jdField_a_of_type_ComTencentBizPubaccountWeishi_newDramaCacheIFetchDataListener = a();
  private final WSGetFollowDramaFetcher jdField_a_of_type_ComTencentBizPubaccountWeishi_newDramaCacheWSGetFollowDramaFetcher = new WSGetFollowDramaFetcher();
  private final WSNoticeDataManager jdField_a_of_type_ComTencentBizPubaccountWeishi_newRecommendDataWSNoticeDataManager = new WSNoticeDataManager();
  private long b = 0L;
  private long c;
  private long d = -1L;
  
  public WSGridForHotPresenter(String paramString)
  {
    super(paramString);
    this.jdField_c_of_type_Long = 0L;
  }
  
  private IFetchDataListener<WSFollowDramaData> a()
  {
    return new WSGridForHotPresenter.2(this);
  }
  
  private void a(int paramInt)
  {
    WeishiLinkUtil.a();
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
    int i;
    if ((paramstGlobalConfig.jumpinfo != null) && (!TextUtils.isEmpty(paramstGlobalConfig.jumpinfo.h5url)))
    {
      i = 1;
      paramView.a(paramstGlobalConfig.jumpinfo.h5url);
    }
    else
    {
      i = 2;
    }
    WSReportDc00898.a(i, 2, paramString);
  }
  
  private void a(@Nullable WSFollowDramaData paramWSFollowDramaData, boolean paramBoolean)
  {
    if (a() == null) {
      return;
    }
    if ((paramWSFollowDramaData != null) && (paramWSFollowDramaData.a() != null) && (paramWSFollowDramaData.a().size() != 0))
    {
      ((WSGridPageContract.View)a()).a(paramWSFollowDramaData, paramBoolean);
      return;
    }
    ((WSGridPageContract.View)a()).j();
  }
  
  private void a(List<stSimpleMetaFeed> paramList, stGlobalConfig paramstGlobalConfig, String paramString, boolean paramBoolean)
  {
    WSGridPageContract.View localView = (WSGridPageContract.View)a();
    if ((paramstGlobalConfig != null) && (localView != null))
    {
      int i = paramstGlobalConfig.link_strategy_type;
      localView.a(i, (stSimpleMetaFeed)paramList.get(0));
      if (paramBoolean) {
        WSFallKeyPicMonitor.a().a();
      }
      if (i == 4)
      {
        a(paramstGlobalConfig, localView);
        return;
      }
      if (i == 7)
      {
        a(paramstGlobalConfig, paramString, localView);
        return;
      }
      localView.a(paramstGlobalConfig);
      return;
    }
    WSLog.d("WSGridForHotPresenterLog", "[WSGridPageFragment.java][performLinkStrategy] globalConfig is null!");
  }
  
  private void l()
  {
    if (this.jdField_c_of_type_Long > 0L)
    {
      long l = System.currentTimeMillis() - this.jdField_c_of_type_Long;
      this.jdField_c_of_type_Long = 0L;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("[WSGridForHotPresenter.java][reportPageInitConst] initTime：");
      localStringBuilder.append(l);
      WSLog.e("WSGridForHotPresenterLog", localStringBuilder.toString());
      WsBeaconReportPresenter.a().a(true, l);
      WsBeaconReportPresenter.a().a(true, l, "feeds", "feeds");
    }
  }
  
  private void m()
  {
    WSReportDc00898.a(6, this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPushWSRedDotPushMsg);
  }
  
  private void n()
  {
    if (!WeishiConstants.a)
    {
      this.jdField_a_of_type_Long = (System.currentTimeMillis() - this.b);
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("[WSGridPageFragment.java][reportBeaconAnd898Exit] exitPublicAccount mStayTime:");
      ((StringBuilder)localObject).append(this.jdField_a_of_type_Long);
      WSLog.e("WSGridForHotPresenterLog", ((StringBuilder)localObject).toString());
      this.b = 0L;
    }
    Object localObject = (WSGridPageContract.View)a();
    if (localObject == null) {
      return;
    }
    int i = ((WSGridPageContract.View)localObject).a();
    WSReportDc00898.a(117, new Object[] { Long.valueOf(this.jdField_a_of_type_Long), Integer.valueOf(i) });
    WsBeaconReportPresenter.a().a(this.jdField_a_of_type_Long, this.d, i, WeishiUtils.a, WeishiScehmeUtil.a, 1);
  }
  
  private void o()
  {
    WeiShiCacheManager.a().c(new WSGridForHotPresenter.1(this));
  }
  
  public void a(int paramInt, String paramString)
  {
    WSFallKeyPicMonitor.b(2);
  }
  
  public void a(stNotificationRsp paramstNotificationRsp, RspHeaderBean paramRspHeaderBean)
  {
    WSGridPageContract.View localView = (WSGridPageContract.View)a();
    if (localView != null)
    {
      localView.b();
      localView.a(paramstNotificationRsp, paramRspHeaderBean);
    }
    WSFallKeyPicMonitor.a(2);
  }
  
  public void a(String paramString)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newRecommendDataWSNoticeDataManager.a(paramString, this);
  }
  
  protected void a(List<stSimpleMetaFeed> paramList, boolean paramBoolean, stGlobalConfig paramstGlobalConfig, int paramInt, long paramLong)
  {
    super.a(paramList, paramBoolean, paramstGlobalConfig, paramInt, paramLong);
    WSInitializeHelper.a().a().d();
    this.d = (System.currentTimeMillis() - paramLong);
    String str = WSGridPageUtils.a(false, paramInt, (stSimpleMetaFeed)paramList.get(0), this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPushWSRedDotPushMsg, this.jdField_c_of_type_JavaLangString);
    if (WSUserAuthDialog.a()) {
      WSSimpleEventBus.a().a(new WSUserAuthEvent());
    }
    a(paramList, paramstGlobalConfig, str, paramBoolean);
    a(paramInt);
  }
  
  protected void a(List<stSimpleMetaFeed> paramList, boolean paramBoolean1, boolean paramBoolean2)
  {
    if (paramBoolean2) {
      WSInitializeHelper.a().a().e();
    }
    super.a(paramList, paramBoolean1, paramBoolean2);
  }
  
  public void c()
  {
    super.c();
    this.jdField_c_of_type_Long = System.currentTimeMillis();
    a(this.jdField_a_of_type_JavaLangString);
    WSFallKeyPicMonitor.a().a(BaseApplicationImpl.getContext());
    if (c()) {
      o();
    }
  }
  
  public boolean c()
  {
    return WSExpABTestManager.a().h();
  }
  
  public void d()
  {
    this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newDramaCacheWSGetFollowDramaFetcher.a(this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newDramaCacheIFetchDataListener);
  }
  
  protected boolean d()
  {
    boolean bool = WeishiUtils.a(8);
    int i = WeiShiCacheManager.a().a();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[WSGridForHotPresenter.java][isPreloadCacheValid] mSubTab:");
    localStringBuilder.append(this.jdField_c_of_type_JavaLangString);
    localStringBuilder.append(", preloadCacheValid:");
    localStringBuilder.append(bool);
    localStringBuilder.append(", redCacheCount:");
    localStringBuilder.append(i);
    WSLog.e("WSGridForHotPresenterLog", localStringBuilder.toString());
    return (bool) && (i >= 8);
  }
  
  public void e()
  {
    super.e();
    if (!WeishiConstants.a) {
      this.b = System.currentTimeMillis();
    } else {
      WeishiConstants.a = false;
    }
    l();
    m();
  }
  
  protected boolean e()
  {
    return false;
  }
  
  protected boolean f()
  {
    return true;
  }
  
  public void g()
  {
    super.g();
    WSFallKeyPicMonitor.a().b();
    n();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.recommend.presenter.WSGridForHotPresenter
 * JD-Core Version:    0.7.0.1
 */