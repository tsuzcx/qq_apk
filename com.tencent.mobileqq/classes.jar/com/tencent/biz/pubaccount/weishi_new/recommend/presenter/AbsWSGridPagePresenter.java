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
  protected String a = "";
  protected String b = "";
  protected String c;
  protected final WSGridDataManager d;
  protected WSRedDotPushMsg e;
  private boolean f = false;
  private boolean g = false;
  private boolean h = false;
  private int i;
  private WSLoadMoreReportHelper j;
  
  public AbsWSGridPagePresenter(String paramString)
  {
    this.c = paramString;
    this.d = new WSGridDataManager();
    this.j = new WSLoadMoreReportHelper(b(this.c));
  }
  
  private void a(List<stSimpleMetaFeed> paramList)
  {
    WSGridPageContract.View localView = (WSGridPageContract.View)getView();
    if (localView == null) {
      return;
    }
    localView.b(true, f());
    localView.a(paramList);
    this.j.a();
  }
  
  private void a(List<stSimpleMetaFeed> paramList, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    if ((paramBoolean2) || (paramBoolean1))
    {
      this.i = paramList.size();
      WSGridPageContract.View localView = (WSGridPageContract.View)getView();
      if ((!paramBoolean3) && (localView != null) && (localView.aS_()))
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("[AbsWSGridPagePresenter.java][exposeRefreshCardFromServer] mSubTabId:");
        localStringBuilder.append(this.c);
        localStringBuilder.append(", feedsSize:");
        localStringBuilder.append(paramList.size());
        WSLog.e("AbsWSGridPagePresenterLog", localStringBuilder.toString());
        localView.a(paramList, a(paramBoolean1));
      }
    }
  }
  
  @NonNull
  private String b(@Nullable String paramString)
  {
    if (!TextUtils.isEmpty(paramString))
    {
      paramString = new StringBuilder();
      paramString.append("feeds_");
      paramString.append(this.c);
      return paramString.toString();
    }
    return "feeds";
  }
  
  private void b(List<stSimpleMetaFeed> paramList)
  {
    WSGridPageContract.View localView = (WSGridPageContract.View)getView();
    if (localView == null) {
      return;
    }
    localView.c();
    localView.b(true);
    localView.a(paramList);
    if (localView.aS_()) {
      localView.aU_();
    }
  }
  
  private String u()
  {
    if (!t()) {
      return "";
    }
    String str2 = WeishiUtils.b;
    WeishiManager localWeishiManager = WeishiUtils.d();
    String str1 = str2;
    if (localWeishiManager != null)
    {
      str1 = str2;
      if (TextUtils.isEmpty(str2)) {
        str1 = localWeishiManager.d();
      }
    }
    return str1;
  }
  
  private boolean v()
  {
    WSGridPageContract.View localView = (WSGridPageContract.View)getView();
    if (!(localView instanceof WSGridPageFragment)) {
      return true;
    }
    return localView.aR_();
  }
  
  private int w()
  {
    if (getView() != null)
    {
      List localList = ((WSGridPageContract.View)getView()).f();
      if (localList != null) {
        return localList.size() - 1;
      }
    }
    return -1;
  }
  
  private void x()
  {
    Object localObject1 = (WSGridPageContract.View)getView();
    if ((localObject1 != null) && (!p()))
    {
      Object localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("[AbsWSGridPagePresenter.java][handleCacheData] mSubTabId:");
      ((StringBuilder)localObject2).append(this.c);
      ((StringBuilder)localObject2).append(", saveFeed and cache!");
      WSLog.e("AbsWSGridPagePresenterLog", ((StringBuilder)localObject2).toString());
      localObject1 = ((WSGridPageContract.View)localObject1).f();
      if (((List)localObject1).size() <= 0)
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("[AbsWSGridPagePresenter.java][handleCacheData] mSubTabId:");
        ((StringBuilder)localObject1).append(this.c);
        ((StringBuilder)localObject1).append(", data is null, no need to cache!");
        WSLog.e("AbsWSGridPagePresenterLog", ((StringBuilder)localObject1).toString());
        return;
      }
      ArrayList localArrayList = new ArrayList((Collection)localObject1);
      localObject2 = WSAioListHelper.b();
      localObject1 = localObject2;
      if (localObject2 == null) {
        localObject1 = WSFeedUtils.b(localArrayList);
      }
      localArrayList.remove(localObject1);
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("[AbsWSGridPagePresenter.java][handleCacheData] mSubTabId:");
      localStringBuilder.append(this.c);
      localStringBuilder.append(", feedId:");
      String str = "";
      if (localObject1 != null) {
        localObject2 = ((stSimpleMetaFeed)localObject1).id;
      } else {
        localObject2 = "";
      }
      localStringBuilder.append((String)localObject2);
      localStringBuilder.append(", feedTitle:");
      localObject2 = str;
      if (localObject1 != null) {
        localObject2 = ((stSimpleMetaFeed)localObject1).feed_desc;
      }
      localStringBuilder.append((String)localObject2);
      localStringBuilder.append(", to cache!");
      WSLog.d("AbsWSGridPagePresenterLog", localStringBuilder.toString());
      WeiShiCacheManager.a().a(localArrayList, (stSimpleMetaFeed)localObject1, this.i, b(this.c));
      return;
    }
    localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("[AbsWSGridPagePresenter.java][handleCacheData] ignoreCacheData:true! mSubTabId:");
    ((StringBuilder)localObject1).append(this.c);
    WSLog.d("AbsWSGridPagePresenterLog", ((StringBuilder)localObject1).toString());
  }
  
  private void y()
  {
    this.j.c();
  }
  
  public void a()
  {
    this.g = false;
    r();
    a(this.a, this.b);
  }
  
  public void a(int paramInt, String paramString, boolean paramBoolean1, boolean paramBoolean2)
  {
    if (paramBoolean1) {
      WSReportDc00898.a(302, new Object[] { Integer.valueOf(paramInt), Long.valueOf(0L) });
    }
    if ((!paramBoolean1) && (!paramBoolean2)) {
      WSGridBeaconReport.a(paramInt, "", "", this.c);
    } else {
      WSGridBeaconReport.a(paramBoolean1, paramBoolean2, paramInt, this.c);
    }
    WSGridPageContract.View localView = (WSGridPageContract.View)getView();
    if (localView == null) {
      return;
    }
    if (paramBoolean1)
    {
      if (this.f)
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
    localView.b(false, true);
    this.j.a();
  }
  
  protected void a(JceStruct paramJceStruct, boolean paramBoolean1, boolean paramBoolean2)
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
      this.f = true;
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append("[AbsWSGridPagePresenter.java][handleOnReadCacheCompleted] mHasLoadedFromService:");
      ((StringBuilder)localObject).append(this.g);
      WSLog.e("AbsWSGridPagePresenterLog", ((StringBuilder)localObject).toString());
      if (this.g) {
        return;
      }
      this.h = paramBoolean1;
      if (paramBoolean2) {
        WSGridPageUtils.a(true, -1, null, this.e, this.c);
      }
      localObject = (WSGridPageContract.View)getView();
      if (localObject == null) {
        return;
      }
      if (paramBoolean1)
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("[AbsWSGridPagePresenter.java][handleOnReadCacheCompleted] mSubTabId:");
        localStringBuilder.append(this.c);
        localStringBuilder.append(", feedsSize:");
        localStringBuilder.append(paramJceStruct.size());
        WSLog.e("AbsWSGridPagePresenterLog", localStringBuilder.toString());
        a(false, true, true, this.a, "");
        ((WSGridPageContract.View)localObject).a(paramJceStruct, false);
      }
      ((WSGridPageContract.View)localObject).u();
      ((WSGridPageContract.View)localObject).s();
      ((WSGridPageContract.View)localObject).a(paramJceStruct);
      ((WSGridPageContract.View)localObject).b(true, true);
      this.j.a();
      this.i = paramJceStruct.size();
      if ((!paramBoolean1) && (!this.g))
      {
        paramJceStruct = new StringBuilder();
        paramJceStruct.append("[AbsWSGridPagePresenter.java][handleOnReadCacheCompleted] mSubTabId:");
        paramJceStruct.append(this.c);
        paramJceStruct.append(", showTopLoading");
        WSLog.d("AbsWSGridPagePresenterLog", paramJceStruct.toString());
        ((WSGridPageContract.View)localObject).c_(true);
      }
    }
  }
  
  public void a(String paramString) {}
  
  public void a(String paramString1, String paramString2)
  {
    boolean bool;
    if ((WeishiUtils.f()) && (q())) {
      bool = true;
    } else {
      bool = false;
    }
    if (n())
    {
      c(true, bool);
      return;
    }
    c(false, bool);
    a(false, true, false, paramString1, paramString2);
  }
  
  protected void a(List<stSimpleMetaFeed> paramList, boolean paramBoolean, stGlobalConfig paramstGlobalConfig, int paramInt, long paramLong)
  {
    paramstGlobalConfig = (WSGridPageContract.View)getView();
    if (paramstGlobalConfig == null) {
      return;
    }
    if (paramBoolean)
    {
      paramList.remove(0);
      paramstGlobalConfig.a(paramList);
      return;
    }
    paramstGlobalConfig.u();
    paramstGlobalConfig.s();
    if (this.f) {
      paramstGlobalConfig.b(true);
    }
    paramstGlobalConfig.a(paramList);
    if (paramstGlobalConfig.aS_())
    {
      paramstGlobalConfig.aU_();
      WSSimpleEventBus.a().a(new WSPreloadTabEvent());
      return;
    }
    paramstGlobalConfig.b(true, f());
  }
  
  protected void a(List<stSimpleMetaFeed> paramList, boolean paramBoolean1, boolean paramBoolean2)
  {
    if ((f()) || (paramBoolean1)) {
      WSPicLoader.a().a(paramList, true, b(this.c));
    }
  }
  
  public void a(List<stSimpleMetaFeed> paramList, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, long paramLong)
  {
    boolean bool = v();
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("[AbsWSGridPagePresenter.java][onLoadGridDataSuccess] mSubTabId:");
    ((StringBuilder)localObject).append(this.c);
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
    this.g = true;
    this.h = true;
    localObject = WSGlobalConfig.a().a(1);
    int k;
    if (localObject != null) {
      k = ((stGlobalConfig)localObject).link_strategy_type;
    } else {
      k = 1;
    }
    if (paramBoolean1) {
      a(paramList, paramBoolean3, (stGlobalConfig)localObject, k, paramLong);
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
    Object localObject = (WSGridPageContract.View)getView();
    if (localObject == null) {
      return;
    }
    if ((paramBoolean2) && (!paramBoolean3)) {
      ((WSGridPageContract.View)localObject).r();
    }
    ArrayList localArrayList = WSExposeDataManager.a().b();
    WSGridRequestParams localWSGridRequestParams = new WSGridRequestParams(paramBoolean1, paramBoolean2, paramBoolean3).a(this.c);
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
      paramString1 = s();
    }
    paramString2.d(paramString1);
    paramString1 = new StringBuilder();
    paramString1.append("[AbsWSGridPagePresenter.java][getFeedList] mSubTabId:");
    paramString1.append(this.c);
    paramString1.append(", requestParams:");
    paramString1.append(paramString2);
    WSLog.d("AbsWSGridPagePresenterLog", paramString1.toString());
    this.d.a(paramString2, this);
  }
  
  protected boolean a(boolean paramBoolean)
  {
    return paramBoolean;
  }
  
  public void b() {}
  
  public void b(boolean paramBoolean1, boolean paramBoolean2)
  {
    if (!this.h)
    {
      com.tencent.biz.pubaccount.weishi_new.report.WSReportEventConstants.d = 2;
      return;
    }
    if ((!WeishiUtils.a) && (!paramBoolean1) && (!paramBoolean2))
    {
      com.tencent.biz.pubaccount.weishi_new.report.WSReportEventConstants.d = 3;
      return;
    }
    com.tencent.biz.pubaccount.weishi_new.report.WSReportEventConstants.d = 1;
  }
  
  public void c() {}
  
  public void c(boolean paramBoolean1, boolean paramBoolean2)
  {
    boolean bool = o();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[AbsWSGridPagePresenter.java][fetchGridDataFromCache] mSubTabId:");
    localStringBuilder.append(this.c);
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
    WeiShiCacheManager.a().a(t(), new AbsWSGridPagePresenter.1(this, paramBoolean1, paramBoolean2));
  }
  
  public void d()
  {
    x();
    y();
  }
  
  public void e() {}
  
  public boolean f()
  {
    return this.d.a() ^ true;
  }
  
  public boolean g()
  {
    return this.h;
  }
  
  public void h()
  {
    this.j.b();
  }
  
  public void i()
  {
    this.j.a(w());
  }
  
  public void j()
  {
    y();
  }
  
  public boolean k()
  {
    return false;
  }
  
  public boolean l()
  {
    return false;
  }
  
  public boolean m()
  {
    return false;
  }
  
  protected abstract boolean n();
  
  protected abstract boolean o();
  
  protected abstract boolean p();
  
  protected abstract boolean q();
  
  protected void r()
  {
    if ((q()) && (t()))
    {
      this.e = WeishiUtils.g();
      Object localObject = this.e;
      if (localObject == null) {
        localObject = "";
      } else {
        localObject = ((WSRedDotPushMsg)localObject).mMsgData;
      }
      this.a = ((String)localObject);
      this.b = WeishiUtils.j();
      WeishiUtils.e();
    }
  }
  
  protected String s()
  {
    if ((getView() != null) && (!TextUtils.isEmpty(((WSGridPageContract.View)getView()).aT_()))) {
      return ((WSGridPageContract.View)getView()).aT_();
    }
    return u();
  }
  
  protected boolean t()
  {
    return "from_home_page".equals(WSPublicAccReport.getInstance().getEnterPublicAccFrom());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.recommend.presenter.AbsWSGridPagePresenter
 * JD-Core Version:    0.7.0.1
 */