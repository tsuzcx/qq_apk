package com.tencent.biz.pubaccount.weishi_new.recommend.presenter;

import UserGrowth.stGlobalConfig;
import UserGrowth.stSimpleGetFeedListRsp;
import UserGrowth.stSimpleMetaFeed;
import android.text.TextUtils;
import com.qq.taf.jce.JceStruct;
import com.tencent.biz.pubaccount.readinjoy.engine.WeishiManager;
import com.tencent.biz.pubaccount.weishi_new.cache.WeiShiCacheManager;
import com.tencent.biz.pubaccount.weishi_new.config.WSGlobalConfig;
import com.tencent.biz.pubaccount.weishi_new.presenter.WSBasePresenter;
import com.tencent.biz.pubaccount.weishi_new.push.WSRedDotPushMsg;
import com.tencent.biz.pubaccount.weishi_new.recommend.WSGridBeaconReport;
import com.tencent.biz.pubaccount.weishi_new.recommend.WSGridPageContract.Presenter;
import com.tencent.biz.pubaccount.weishi_new.recommend.WSGridPageContract.View;
import com.tencent.biz.pubaccount.weishi_new.recommend.WSGridPageFragment;
import com.tencent.biz.pubaccount.weishi_new.recommend.data.IWSGridRspListener;
import com.tencent.biz.pubaccount.weishi_new.recommend.data.WSGridDataManager;
import com.tencent.biz.pubaccount.weishi_new.recommend.data.WSGridRequestParams;
import com.tencent.biz.pubaccount.weishi_new.recommend.utils.WSGridPageUtils;
import com.tencent.biz.pubaccount.weishi_new.report.WSReportDc00898;
import com.tencent.biz.pubaccount.weishi_new.util.WSFeedUtils;
import com.tencent.biz.pubaccount.weishi_new.util.WSInitializeHelper;
import com.tencent.biz.pubaccount.weishi_new.util.WSLog;
import com.tencent.biz.pubaccount.weishi_new.util.WeishiUtils;
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
  }
  
  private void a(JceStruct paramJceStruct, boolean paramBoolean1, boolean paramBoolean2)
  {
    if (!(paramJceStruct instanceof stSimpleGetFeedListRsp)) {}
    WSGridPageContract.View localView;
    do
    {
      do
      {
        do
        {
          do
          {
            return;
            paramJceStruct = ((stSimpleGetFeedListRsp)paramJceStruct).feeds;
          } while ((paramJceStruct == null) || (paramJceStruct.size() <= 0));
          this.jdField_a_of_type_Boolean = true;
          WSLog.e("AbsWSGridPagePresenterLog", "[AbsWSGridPagePresenter.java][handleOnReadCacheCompleted] mHasLoadedFromService:" + this.jdField_b_of_type_Boolean);
        } while (this.jdField_b_of_type_Boolean);
        this.jdField_c_of_type_Boolean = paramBoolean1;
        if (paramBoolean2) {
          WSGridPageUtils.a(true, -1, null, this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPushWSRedDotPushMsg, this.jdField_c_of_type_JavaLangString);
        }
        localView = (WSGridPageContract.View)a();
      } while (localView == null);
      if (paramBoolean1)
      {
        WSLog.e("AbsWSGridPagePresenterLog", "[AbsWSGridPagePresenter.java][handleOnReadCacheCompleted] mSubTabId:" + this.jdField_c_of_type_JavaLangString + ", feedsSize:" + paramJceStruct.size());
        a(false, true, true, this.jdField_a_of_type_JavaLangString, "");
        localView.a(paramJceStruct, false);
      }
      localView.f();
      localView.d();
      localView.a(paramJceStruct);
      localView.a(true, true);
      this.jdField_a_of_type_Int = paramJceStruct.size();
    } while ((paramBoolean1) || (this.jdField_b_of_type_Boolean));
    WSLog.d("AbsWSGridPagePresenterLog", "[AbsWSGridPagePresenter.java][handleOnReadCacheCompleted] mSubTabId:" + this.jdField_c_of_type_JavaLangString + ", showTopLoading");
    localView.a(true);
  }
  
  private void a(List<stSimpleMetaFeed> paramList)
  {
    WSGridPageContract.View localView = (WSGridPageContract.View)a();
    if (localView == null) {
      return;
    }
    localView.a(true, e());
    localView.a(paramList);
  }
  
  private void a(List<stSimpleMetaFeed> paramList, boolean paramBoolean)
  {
    if ((e()) || (paramBoolean))
    {
      String str = "feeds";
      if (!TextUtils.isEmpty(this.jdField_c_of_type_JavaLangString)) {
        str = "feeds_" + this.jdField_c_of_type_JavaLangString;
      }
      WeishiUtils.a(paramList, true, str);
    }
  }
  
  private void a(List<stSimpleMetaFeed> paramList, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    if ((paramBoolean2) || (paramBoolean1))
    {
      this.jdField_a_of_type_Int = paramList.size();
      WSGridPageContract.View localView = (WSGridPageContract.View)a();
      if ((!paramBoolean3) && (localView != null) && (localView.b()))
      {
        WSLog.e("AbsWSGridPagePresenterLog", "[AbsWSGridPagePresenter.java][exposeRefreshCardFromServer] mSubTabId:" + this.jdField_c_of_type_JavaLangString + ", feedsSize:" + paramList.size());
        localView.a(paramList, a(paramBoolean1));
      }
    }
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
  }
  
  private boolean f()
  {
    WSGridPageContract.View localView = (WSGridPageContract.View)a();
    if (!(localView instanceof WSGridPageFragment)) {
      return true;
    }
    return localView.a();
  }
  
  private void h()
  {
    Object localObject = (WSGridPageContract.View)a();
    if ((localObject == null) || (c()))
    {
      WSLog.d("AbsWSGridPagePresenterLog", "[AbsWSGridPagePresenter.java][handleCacheData] ignoreCacheData:true! mSubTabId:" + this.jdField_c_of_type_JavaLangString);
      return;
    }
    WSLog.e("AbsWSGridPagePresenterLog", "[AbsWSGridPagePresenter.java][handleCacheData] mSubTabId:" + this.jdField_c_of_type_JavaLangString + ", saveFeed and cache!");
    localObject = ((WSGridPageContract.View)localObject).a();
    if (((List)localObject).size() <= 0)
    {
      WSLog.e("AbsWSGridPagePresenterLog", "[AbsWSGridPagePresenter.java][handleCacheData] mSubTabId:" + this.jdField_c_of_type_JavaLangString + ", data is null, no need to cache!");
      return;
    }
    ArrayList localArrayList = new ArrayList((Collection)localObject);
    stSimpleMetaFeed localstSimpleMetaFeed = WSInitializeHelper.a().a();
    localObject = localstSimpleMetaFeed;
    if (localstSimpleMetaFeed == null) {
      localObject = WSFeedUtils.a(localArrayList);
    }
    localArrayList.remove(localObject);
    WSLog.e("AbsWSGridPagePresenterLog", "[AbsWSGridPagePresenter.java][handleCacheData] mSubTabId:" + this.jdField_c_of_type_JavaLangString + ", to cache!");
    WeiShiCacheManager.a().a(localArrayList, (stSimpleMetaFeed)localObject, this.jdField_a_of_type_Int);
  }
  
  protected String a()
  {
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
  
  public void a()
  {
    this.jdField_b_of_type_Boolean = false;
    g();
    a(this.jdField_a_of_type_JavaLangString, this.jdField_b_of_type_JavaLangString);
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
  }
  
  public void a(String paramString) {}
  
  public void a(String paramString1, String paramString2)
  {
    if ((WeishiUtils.a()) && (d())) {}
    for (boolean bool = true; b(); bool = false)
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
    a(false, false);
  }
  
  public void a(List<stSimpleMetaFeed> paramList, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, long paramLong)
  {
    int i = 1;
    boolean bool = f();
    WSLog.d("AbsWSGridPagePresenterLog", "[AbsWSGridPagePresenter.java][onLoadGridDataSuccess] mSubTabId:" + this.jdField_c_of_type_JavaLangString + ", activityFinishing:" + bool + ", feeds:" + paramList.size() + ", isFirstFromService:" + paramBoolean1 + ", isRefresh:" + paramBoolean2 + ", isRedDotCacheValid:" + paramBoolean3);
    if (bool) {
      return;
    }
    this.jdField_b_of_type_Boolean = true;
    this.jdField_c_of_type_Boolean = true;
    stGlobalConfig localstGlobalConfig = WSGlobalConfig.a().a(1);
    if (localstGlobalConfig != null) {
      i = localstGlobalConfig.link_strategy_type;
    }
    if (paramBoolean1) {
      a(paramList, paramBoolean3, localstGlobalConfig, i, paramLong);
    }
    for (;;)
    {
      a(paramList, paramBoolean1, paramBoolean2, paramBoolean3);
      a(paramList, paramBoolean3);
      return;
      if (paramBoolean2) {
        b(paramList);
      } else {
        a(paramList);
      }
    }
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
    localObject = new WSGridRequestParams(paramBoolean1, paramBoolean2, paramBoolean3).a(this.jdField_c_of_type_JavaLangString);
    if (paramBoolean2)
    {
      paramString1 = ((WSGridRequestParams)localObject).b(paramString1);
      if (!paramBoolean2) {
        break label151;
      }
      label66:
      paramString2 = paramString1.c(paramString2);
      if (!paramBoolean2) {
        break label158;
      }
    }
    label151:
    label158:
    for (paramString1 = a();; paramString1 = "")
    {
      paramString1 = paramString2.d(paramString1);
      WSLog.d("AbsWSGridPagePresenterLog", "[AbsWSGridPagePresenter.java][getFeedList] mSubTabId:" + this.jdField_c_of_type_JavaLangString + ", requestParams:" + paramString1);
      this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newRecommendDataWSGridDataManager.a(paramString1, this);
      return;
      paramString1 = "";
      break;
      paramString2 = "";
      break label66;
    }
  }
  
  public boolean a()
  {
    return this.jdField_c_of_type_Boolean;
  }
  
  protected boolean a(boolean paramBoolean)
  {
    return paramBoolean;
  }
  
  public void b() {}
  
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
  
  protected abstract boolean b();
  
  public void c(boolean paramBoolean1, boolean paramBoolean2)
  {
    boolean bool = c();
    WSLog.d("AbsWSGridPagePresenterLog", "[AbsWSGridPagePresenter.java][fetchGridDataFromCache] mSubTabId:" + this.jdField_c_of_type_JavaLangString + ", ignoreGridCacheData:" + bool + ", isRedDotCacheValid:" + paramBoolean1 + ", isFromWeiShiPush:" + paramBoolean2);
    if (bool) {
      return;
    }
    WeiShiCacheManager.a().a(new AbsWSGridPagePresenter.1(this, paramBoolean1, paramBoolean2));
  }
  
  protected abstract boolean c();
  
  protected abstract boolean d();
  
  public void e()
  {
    h();
  }
  
  public boolean e()
  {
    return !this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newRecommendDataWSGridDataManager.a();
  }
  
  public void f() {}
  
  protected void g()
  {
    if (d())
    {
      this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPushWSRedDotPushMsg = WeishiUtils.a();
      if (this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPushWSRedDotPushMsg != null) {
        break label40;
      }
    }
    label40:
    for (String str = "";; str = this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPushWSRedDotPushMsg.mMsgData)
    {
      this.jdField_a_of_type_JavaLangString = str;
      this.jdField_b_of_type_JavaLangString = WeishiUtils.b();
      WeishiUtils.a();
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.recommend.presenter.AbsWSGridPagePresenter
 * JD-Core Version:    0.7.0.1
 */