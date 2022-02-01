package com.tencent.biz.pubaccount.weishi_new.recommend.presenter;

import UserGrowth.stGlobalConfig;
import UserGrowth.stJumpInfo;
import UserGrowth.stNotificationRsp;
import UserGrowth.stSimpleMetaFeed;
import android.text.TextUtils;
import com.tencent.biz.pubaccount.weishi_new.WSUserAuthDialog;
import com.tencent.biz.pubaccount.weishi_new.WeishiConstants;
import com.tencent.biz.pubaccount.weishi_new.cache.WeiShiCacheManager;
import com.tencent.biz.pubaccount.weishi_new.download.wsapp.WSFallKeyPicMonitor;
import com.tencent.biz.pubaccount.weishi_new.event.WSSimpleEventBus;
import com.tencent.biz.pubaccount.weishi_new.event.WSUserAuthEvent;
import com.tencent.biz.pubaccount.weishi_new.net.RspHeaderBean;
import com.tencent.biz.pubaccount.weishi_new.recommend.WSGridPageContract.View;
import com.tencent.biz.pubaccount.weishi_new.recommend.data.IWSNoticeRspListener;
import com.tencent.biz.pubaccount.weishi_new.recommend.data.WSNoticeDataManager;
import com.tencent.biz.pubaccount.weishi_new.recommend.utils.WSGridPageUtils;
import com.tencent.biz.pubaccount.weishi_new.report.WSReportDc00898;
import com.tencent.biz.pubaccount.weishi_new.report.WsBeaconReportPresenter;
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
  private final WSNoticeDataManager jdField_a_of_type_ComTencentBizPubaccountWeishi_newRecommendDataWSNoticeDataManager = new WSNoticeDataManager();
  private long b = 0L;
  private long c;
  private long d = -1L;
  
  public WSGridForHotPresenter(String paramString)
  {
    super(paramString);
    this.jdField_c_of_type_Long = 0L;
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
    for (;;)
    {
      WSReportDc00898.a(i, 2, paramString);
      return;
      i = 2;
    }
  }
  
  private void a(List<stSimpleMetaFeed> paramList, stGlobalConfig paramstGlobalConfig, String paramString, boolean paramBoolean)
  {
    WSGridPageContract.View localView = (WSGridPageContract.View)a();
    if ((paramstGlobalConfig == null) || (localView == null))
    {
      WSLog.d("WSGridForHotPresenterLog", "[WSGridPageFragment.java][performLinkStrategy] globalConfig is null!");
      return;
    }
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
  }
  
  private void h()
  {
    if (this.jdField_c_of_type_Long > 0L)
    {
      long l = System.currentTimeMillis() - this.jdField_c_of_type_Long;
      this.jdField_c_of_type_Long = 0L;
      WSLog.e("WSGridForHotPresenterLog", "[WSGridForHotPresenter.java][reportPageInitConst] initTime：" + l);
      WsBeaconReportPresenter.a().a(true, l);
      WsBeaconReportPresenter.a().a(true, l, "feeds", "feeds");
    }
  }
  
  private void i()
  {
    WSReportDc00898.a(6, this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPushWSRedDotPushMsg);
  }
  
  private void j()
  {
    if (!WeishiConstants.a)
    {
      this.jdField_a_of_type_Long = (System.currentTimeMillis() - this.b);
      WSLog.e("WSGridForHotPresenterLog", "[WSGridPageFragment.java][reportBeaconAnd898Exit] exitPublicAccount mStayTime:" + this.jdField_a_of_type_Long);
      this.b = 0L;
    }
    WSGridPageContract.View localView = (WSGridPageContract.View)a();
    if (localView == null) {
      return;
    }
    int i = localView.a();
    WSReportDc00898.a(117, new Object[] { Long.valueOf(this.jdField_a_of_type_Long), Integer.valueOf(i) });
    WsBeaconReportPresenter.a().a(this.jdField_a_of_type_Long, this.d, i, WeishiUtils.a, WeishiScehmeUtil.a, 1);
  }
  
  public void a()
  {
    super.a();
    this.jdField_c_of_type_Long = System.currentTimeMillis();
    a(this.jdField_a_of_type_JavaLangString);
    WSFallKeyPicMonitor.a().a(BaseApplicationImpl.getContext());
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
      localView.a();
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
    this.d = (System.currentTimeMillis() - paramLong);
    String str = WSGridPageUtils.a(false, paramInt, (stSimpleMetaFeed)paramList.get(0), this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPushWSRedDotPushMsg, this.jdField_c_of_type_JavaLangString);
    if (WSUserAuthDialog.a()) {
      WSSimpleEventBus.a().a(new WSUserAuthEvent());
    }
    a(paramList, paramstGlobalConfig, str, paramBoolean);
    a(paramInt);
  }
  
  public void b()
  {
    super.b();
    if (!WeishiConstants.a) {
      this.b = System.currentTimeMillis();
    }
    for (;;)
    {
      h();
      i();
      return;
      WeishiConstants.a = false;
    }
  }
  
  protected boolean b()
  {
    boolean bool = WeishiUtils.a(8);
    int i = WeiShiCacheManager.a().a();
    WSLog.e("WSGridForHotPresenterLog", "[WSGridForHotPresenter.java][isPreloadCacheValid] mSubTab:" + this.jdField_c_of_type_JavaLangString + ", preloadCacheValid:" + bool + ", redCacheCount:" + i);
    return (bool) && (i >= 8);
  }
  
  protected boolean c()
  {
    return false;
  }
  
  protected boolean d()
  {
    return true;
  }
  
  public void f()
  {
    super.f();
    WSFallKeyPicMonitor.a().b();
    j();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.recommend.presenter.WSGridForHotPresenter
 * JD-Core Version:    0.7.0.1
 */