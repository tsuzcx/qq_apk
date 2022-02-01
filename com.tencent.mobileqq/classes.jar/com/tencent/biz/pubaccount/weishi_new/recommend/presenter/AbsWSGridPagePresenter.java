package com.tencent.biz.pubaccount.weishi_new.recommend.presenter;

import UserGrowth.stGlobalConfig;
import UserGrowth.stSimpleGetFeedListRsp;
import UserGrowth.stSimpleMetaFeed;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import com.qq.taf.jce.JceStruct;
import com.tencent.biz.pubaccount.weishi_new.aiolist.WSAioListHelper;
import com.tencent.biz.pubaccount.weishi_new.cache.WeiShiCacheManager;
import com.tencent.biz.pubaccount.weishi_new.config.WSGlobalConfig;
import com.tencent.biz.pubaccount.weishi_new.event.WSPreloadTabEvent;
import com.tencent.biz.pubaccount.weishi_new.event.WSSimpleEventBus;
import com.tencent.biz.pubaccount.weishi_new.image.WSPicLoader;
import com.tencent.biz.pubaccount.weishi_new.presenter.WSBasePresenter;
import com.tencent.biz.pubaccount.weishi_new.push.WSRedDotPushMsg;
import com.tencent.biz.pubaccount.weishi_new.recommend.WSGridBeaconReport;
import com.tencent.biz.pubaccount.weishi_new.recommend.WSGridPageContract.Presenter;
import com.tencent.biz.pubaccount.weishi_new.recommend.WSGridPageContract.View;
import com.tencent.biz.pubaccount.weishi_new.recommend.WSGridPageFragment;
import com.tencent.biz.pubaccount.weishi_new.recommend.data.IWSGridRspListener;
import com.tencent.biz.pubaccount.weishi_new.recommend.data.WSExposeDataManager;
import com.tencent.biz.pubaccount.weishi_new.recommend.data.WSGridDataManager;
import com.tencent.biz.pubaccount.weishi_new.recommend.data.WSGridRequestParams;
import com.tencent.biz.pubaccount.weishi_new.recommend.utils.WSGridPageUtils;
import com.tencent.biz.pubaccount.weishi_new.report.WSPublicAccReport;
import com.tencent.biz.pubaccount.weishi_new.report.WSReportDc00898;
import com.tencent.biz.pubaccount.weishi_new.util.WSFeedUtils;
import com.tencent.biz.pubaccount.weishi_new.util.WSLoadMoreReportHelper;
import com.tencent.biz.pubaccount.weishi_new.util.WSLog;
import com.tencent.biz.pubaccount.weishi_new.util.WeishiUtils;
import com.tencent.mobileqq.app.WeishiManager;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public abstract class AbsWSGridPagePresenter
  extends WSBasePresenter<WSGridPageContract.View>
  implements WSGridPageContract.Presenter, IWSGridRspListener
{
  private int jdField_a_of_type_Int;
  protected WSRedDotPushMsg a;
  protected final WSGridDataManager a;
  private WSLoadMoreReportHelper jdField_a_of_type_ComTencentBizPubaccountWeishi_newUtilWSLoadMoreReportHelper;
  protected String a;
  private boolean jdField_a_of_type_Boolean = false;
  protected String b;
  private boolean b;
  protected String c;
  private boolean c;
  
  public AbsWSGridPagePresenter(String paramString)
  {
    this.jdField_b_of_type_Boolean = false;
    this.jdField_c_of_type_Boolean = false;
    this.jdField_a_of_type_JavaLangString = "";
    this.jdField_b_of_type_JavaLangString = "";
    this.jdField_c_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newRecommendDataWSGridDataManager = new WSGridDataManager();
    this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newUtilWSLoadMoreReportHelper = new WSLoadMoreReportHelper(a(this.jdField_c_of_type_JavaLangString));
  }
  
  @NonNull
  private String a(@Nullable String paramString)
  {
    if (!TextUtils.isEmpty(paramString))
    {
      paramString = new StringBuilder();
      paramString.append("feeds_");
      paramString.append(this.jdField_c_of_type_JavaLangString);
      return paramString.toString();
    }
    return "feeds";
  }
  
  private void a(JceStruct paramJceStruct, boolean paramBoolean1, boolean paramBoolean2)
  {
    if (!(paramJceStruct instanceof stSimpleGetFeedListRsp)) {
      return;
    }
    paramJceStruct = ((stSimpleGetFeedListRsp)paramJceStruct).feeds;
    if (paramJceStruct != null)
    {
      if (paramJceStruct.size() <= 0) {
        return;
      }
      this.jdField_a_of_type_Boolean = true;
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append("[AbsWSGridPagePresenter.java][handleOnReadCacheCompleted] mHasLoadedFromService:");
      ((StringBuilder)localObject).append(this.jdField_b_of_type_Boolean);
      WSLog.e("AbsWSGridPagePresenterLog", ((StringBuilder)localObject).toString());
      if (this.jdField_b_of_type_Boolean) {
        return;
      }
      this.jdField_c_of_type_Boolean = paramBoolean1;
      if (paramBoolean2) {
        WSGridPageUtils.a(true, -1, null, this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPushWSRedDotPushMsg, this.jdField_c_of_type_JavaLangString);
      }
      localObject = (WSGridPageContract.View)a();
      if (localObject == null) {
        return;
      }
      if (paramBoolean1)
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("[AbsWSGridPagePresenter.java][handleOnReadCacheCompleted] mSubTabId:");
        localStringBuilder.append(this.jdField_c_of_type_JavaLangString);
        localStringBuilder.append(", feedsSize:");
        localStringBuilder.append(paramJceStruct.size());
        WSLog.e("AbsWSGridPagePresenterLog", localStringBuilder.toString());
        a(false, true, true, this.jdField_a_of_type_JavaLangString, "");
        ((WSGridPageContract.View)localObject).a(paramJceStruct, false);
      }
      ((WSGridPageContract.View)localObject).f();
      ((WSGridPageContract.View)localObject).d();
      ((WSGridPageContract.View)localObject).a(paramJceStruct);
      ((WSGridPageContract.View)localObject).a(true, true);
      this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newUtilWSLoadMoreReportHelper.a();
      this.jdField_a_of_type_Int = paramJceStruct.size();
      if ((!paramBoolean1) && (!this.jdField_b_of_type_Boolean))
      {
        paramJceStruct = new StringBuilder();
        paramJceStruct.append("[AbsWSGridPagePresenter.java][handleOnReadCacheCompleted] mSubTabId:");
        paramJceStruct.append(this.jdField_c_of_type_JavaLangString);
        paramJceStruct.append(", showTopLoading");
        WSLog.d("AbsWSGridPagePresenterLog", paramJceStruct.toString());
        ((WSGridPageContract.View)localObject).a(true);
      }
    }
  }
  
  private void a(List<stSimpleMetaFeed> paramList)
  {
    WSGridPageContract.View localView = (WSGridPageContract.View)a();
    if (localView == null) {
      return;
    }
    localView.a(true, a());
    localView.a(paramList);
    this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newUtilWSLoadMoreReportHelper.a();
  }
  
  private void a(List<stSimpleMetaFeed> paramList, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    if ((paramBoolean2) || (paramBoolean1))
    {
      this.jdField_a_of_type_Int = paramList.size();
      WSGridPageContract.View localView = (WSGridPageContract.View)a();
      if ((!paramBoolean3) && (localView != null) && (localView.b()))
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("[AbsWSGridPagePresenter.java][exposeRefreshCardFromServer] mSubTabId:");
        localStringBuilder.append(this.jdField_c_of_type_JavaLangString);
        localStringBuilder.append(", feedsSize:");
        localStringBuilder.append(paramList.size());
        WSLog.e("AbsWSGridPagePresenterLog", localStringBuilder.toString());
        localView.a(paramList, a(paramBoolean1));
      }
    }
  }
  
  private String b()
  {
    if (!h()) {
      return "";
    }
    String str2 = WeishiUtils.jdField_a_of_type_JavaLangString;
    WeishiManager localWeishiManager = WeishiUtils.a();
    String str1 = str2;
    if (localWeishiManager != null)
    {
      str1 = str2;
      if (TextUtils.isEmpty(str2)) {
        str1 = localWeishiManager.c();
      }
    }
    return str1;
  }
  
  private void b(List<stSimpleMetaFeed> paramList)
  {
    WSGridPageContract.View localView = (WSGridPageContract.View)a();
    if (localView == null) {
      return;
    }
    localView.e();
    localView.b(true);
    localView.a(paramList);
    if (localView.b()) {
      localView.i();
    }
  }
  
  private boolean g()
  {
    WSGridPageContract.View localView = (WSGridPageContract.View)a();
    if (!(localView instanceof WSGridPageFragment)) {
      return true;
    }
    return localView.a();
  }
  
  private boolean h()
  {
    return "from_home_page".equals(WSPublicAccReport.getInstance().getEnterPublicAccFrom());
  }
  
  private void l()
  {
    Object localObject1 = (WSGridPageContract.View)a();
    if ((localObject1 != null) && (!e()))
    {
      Object localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("[AbsWSGridPagePresenter.java][handleCacheData] mSubTabId:");
      ((StringBuilder)localObject2).append(this.jdField_c_of_type_JavaLangString);
      ((StringBuilder)localObject2).append(", saveFeed and cache!");
      WSLog.e("AbsWSGridPagePresenterLog", ((StringBuilder)localObject2).toString());
      localObject1 = ((WSGridPageContract.View)localObject1).a();
      if (((List)localObject1).size() <= 0)
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("[AbsWSGridPagePresenter.java][handleCacheData] mSubTabId:");
        ((StringBuilder)localObject1).append(this.jdField_c_of_type_JavaLangString);
        ((StringBuilder)localObject1).append(", data is null, no need to cache!");
        WSLog.e("AbsWSGridPagePresenterLog", ((StringBuilder)localObject1).toString());
        return;
      }
      ArrayList localArrayList = new ArrayList((Collection)localObject1);
      localObject2 = WSAioListHelper.a();
      localObject1 = localObject2;
      if (localObject2 == null) {
        localObject1 = WSFeedUtils.a(localArrayList);
      }
      localArrayList.remove(localObject1);
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("[AbsWSGridPagePresenter.java][handleCacheData] mSubTabId:");
      ((StringBuilder)localObject2).append(this.jdField_c_of_type_JavaLangString);
      ((StringBuilder)localObject2).append(", to cache!");
      WSLog.e("AbsWSGridPagePresenterLog", ((StringBuilder)localObject2).toString());
      WeiShiCacheManager.a().a(localArrayList, (stSimpleMetaFeed)localObject1, this.jdField_a_of_type_Int, a(this.jdField_c_of_type_JavaLangString));
      return;
    }
    localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("[AbsWSGridPagePresenter.java][handleCacheData] ignoreCacheData:true! mSubTabId:");
    ((StringBuilder)localObject1).append(this.jdField_c_of_type_JavaLangString);
    WSLog.d("AbsWSGridPagePresenterLog", ((StringBuilder)localObject1).toString());
  }
  
  private void m()
  {
    this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newUtilWSLoadMoreReportHelper.d();
  }
  
  protected String a()
  {
    if ((a() != null) && (!TextUtils.isEmpty(((WSGridPageContract.View)a()).a()))) {
      return ((WSGridPageContract.View)a()).a();
    }
    return b();
  }
  
  public void a(int paramInt, String paramString, boolean paramBoolean1, boolean paramBoolean2)
  {
    if (paramBoolean1) {
      WSReportDc00898.a(302, new Object[] { Integer.valueOf(paramInt), Long.valueOf(0L) });
    }
    WSGridBeaconReport.a(paramBoolean1, paramBoolean2, paramInt, "", "", this.jdField_c_of_type_JavaLangString);
    WSGridPageContract.View localView = (WSGridPageContract.View)a();
    if (localView == null) {
      return;
    }
    if (paramBoolean1)
    {
      if (this.jdField_a_of_type_Boolean)
      {
        localView.b(false);
        return;
      }
      localView.a(paramInt, paramString);
      return;
    }
    if (paramBoolean2)
    {
      localView.b(false);
      return;
    }
    localView.a(false, true);
    this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newUtilWSLoadMoreReportHelper.a();
  }
  
  public void a(String paramString) {}
  
  public void a(String paramString1, String paramString2)
  {
    boolean bool;
    if ((WeishiUtils.a()) && (f())) {
      bool = true;
    } else {
      bool = false;
    }
    if (d())
    {
      c(true, bool);
      return;
    }
    c(false, bool);
    a(false, true, false, paramString1, paramString2);
  }
  
  protected void a(List<stSimpleMetaFeed> paramList, boolean paramBoolean, stGlobalConfig paramstGlobalConfig, int paramInt, long paramLong)
  {
    paramstGlobalConfig = (WSGridPageContract.View)a();
    if (paramstGlobalConfig == null) {
      return;
    }
    if (paramBoolean)
    {
      paramList.remove(0);
      paramstGlobalConfig.a(paramList);
      return;
    }
    paramstGlobalConfig.f();
    paramstGlobalConfig.d();
    if (this.jdField_a_of_type_Boolean) {
      paramstGlobalConfig.b(true);
    }
    paramstGlobalConfig.a(paramList);
    if (paramstGlobalConfig.b())
    {
      paramstGlobalConfig.i();
      WSSimpleEventBus.a().a(new WSPreloadTabEvent());
      return;
    }
    paramstGlobalConfig.a(true, a());
  }
  
  protected void a(List<stSimpleMetaFeed> paramList, boolean paramBoolean1, boolean paramBoolean2)
  {
    if ((a()) || (paramBoolean1)) {
      WSPicLoader.a(paramList, true, a(this.jdField_c_of_type_JavaLangString));
    }
  }
  
  public void a(List<stSimpleMetaFeed> paramList, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, long paramLong)
  {
    boolean bool = g();
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("[AbsWSGridPagePresenter.java][onLoadGridDataSuccess] mSubTabId:");
    ((StringBuilder)localObject).append(this.jdField_c_of_type_JavaLangString);
    ((StringBuilder)localObject).append(", activityFinishing:");
    ((StringBuilder)localObject).append(bool);
    ((StringBuilder)localObject).append(", feeds:");
    ((StringBuilder)localObject).append(paramList.size());
    ((StringBuilder)localObject).append(", isFirstFromService:");
    ((StringBuilder)localObject).append(paramBoolean1);
    ((StringBuilder)localObject).append(", isRefresh:");
    ((StringBuilder)localObject).append(paramBoolean2);
    ((StringBuilder)localObject).append(", isRedDotCacheValid:");
    ((StringBuilder)localObject).append(paramBoolean3);
    WSLog.d("AbsWSGridPagePresenterLog", ((StringBuilder)localObject).toString());
    if (bool) {
      return;
    }
    this.jdField_b_of_type_Boolean = true;
    this.jdField_c_of_type_Boolean = true;
    localObject = WSGlobalConfig.a().a(1);
    int i;
    if (localObject != null) {
      i = ((stGlobalConfig)localObject).link_strategy_type;
    } else {
      i = 1;
    }
    if (paramBoolean1) {
      a(paramList, paramBoolean3, (stGlobalConfig)localObject, i, paramLong);
    } else if (paramBoolean2) {
      b(paramList);
    } else {
      a(paramList);
    }
    a(paramList, paramBoolean1, paramBoolean2, paramBoolean3);
    a(paramList, paramBoolean3, paramBoolean1);
  }
  
  public void a(boolean paramBoolean1, boolean paramBoolean2)
  {
    a(paramBoolean1, paramBoolean2, false, "", "");
  }
  
  public void a(boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, String paramString1, String paramString2)
  {
    Object localObject = (WSGridPageContract.View)a();
    if (localObject == null) {
      return;
    }
    if ((paramBoolean2) && (!paramBoolean3)) {
      ((WSGridPageContract.View)localObject).c();
    }
    ArrayList localArrayList = WSExposeDataManager.a().a();
    WSGridRequestParams localWSGridRequestParams = new WSGridRequestParams(paramBoolean1, paramBoolean2, paramBoolean3).a(this.jdField_c_of_type_JavaLangString);
    localObject = "";
    if (!paramBoolean2) {
      paramString1 = "";
    }
    paramString1 = localWSGridRequestParams.b(paramString1);
    if (!paramBoolean2) {
      paramString2 = "";
    }
    paramString2 = paramString1.c(paramString2).a(localArrayList);
    paramString1 = (String)localObject;
    if (paramBoolean2) {
      paramString1 = a();
    }
    paramString2.d(paramString1);
    paramString1 = new StringBuilder();
    paramString1.append("[AbsWSGridPagePresenter.java][getFeedList] mSubTabId:");
    paramString1.append(this.jdField_c_of_type_JavaLangString);
    paramString1.append(", requestParams:");
    paramString1.append(paramString2);
    WSLog.d("AbsWSGridPagePresenterLog", paramString1.toString());
    this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newRecommendDataWSGridDataManager.a(paramString2, this);
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newRecommendDataWSGridDataManager.a() ^ true;
  }
  
  protected boolean a(boolean paramBoolean)
  {
    return paramBoolean;
  }
  
  public void b(boolean paramBoolean1, boolean paramBoolean2)
  {
    if (!this.jdField_c_of_type_Boolean)
    {
      com.tencent.biz.pubaccount.weishi_new.report.WSReportEventConstants.jdField_a_of_type_Int = 2;
      return;
    }
    if ((!WeishiUtils.jdField_a_of_type_Boolean) && (!paramBoolean1) && (!paramBoolean2))
    {
      com.tencent.biz.pubaccount.weishi_new.report.WSReportEventConstants.jdField_a_of_type_Int = 3;
      return;
    }
    com.tencent.biz.pubaccount.weishi_new.report.WSReportEventConstants.jdField_a_of_type_Int = 1;
  }
  
  public boolean b()
  {
    return this.jdField_c_of_type_Boolean;
  }
  
  public void c()
  {
    this.jdField_b_of_type_Boolean = false;
    k();
    a(this.jdField_a_of_type_JavaLangString, this.jdField_b_of_type_JavaLangString);
  }
  
  public void c(boolean paramBoolean1, boolean paramBoolean2)
  {
    boolean bool = e();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[AbsWSGridPagePresenter.java][fetchGridDataFromCache] mSubTabId:");
    localStringBuilder.append(this.jdField_c_of_type_JavaLangString);
    localStringBuilder.append(", ignoreGridCacheData:");
    localStringBuilder.append(bool);
    localStringBuilder.append(", isRedDotCacheValid:");
    localStringBuilder.append(paramBoolean1);
    localStringBuilder.append(", isFromWeiShiPush:");
    localStringBuilder.append(paramBoolean2);
    WSLog.d("AbsWSGridPagePresenterLog", localStringBuilder.toString());
    if (bool) {
      return;
    }
    WeiShiCacheManager.a().a(h(), new AbsWSGridPagePresenter.1(this, paramBoolean1, paramBoolean2));
  }
  
  public boolean c()
  {
    return false;
  }
  
  public void d() {}
  
  protected abstract boolean d();
  
  public void e() {}
  
  protected abstract boolean e();
  
  public void f()
  {
    l();
    m();
  }
  
  protected abstract boolean f();
  
  public void g() {}
  
  public void h()
  {
    this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newUtilWSLoadMoreReportHelper.b();
  }
  
  public void i()
  {
    this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newUtilWSLoadMoreReportHelper.c();
  }
  
  public void j()
  {
    m();
  }
  
  protected void k()
  {
    if ((f()) && (h()))
    {
      this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPushWSRedDotPushMsg = WeishiUtils.a();
      Object localObject = this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPushWSRedDotPushMsg;
      if (localObject == null) {
        localObject = "";
      } else {
        localObject = ((WSRedDotPushMsg)localObject).mMsgData;
      }
      this.jdField_a_of_type_JavaLangString = ((String)localObject);
      this.jdField_b_of_type_JavaLangString = WeishiUtils.b();
      WeishiUtils.a();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.recommend.presenter.AbsWSGridPagePresenter
 * JD-Core Version:    0.7.0.1
 */