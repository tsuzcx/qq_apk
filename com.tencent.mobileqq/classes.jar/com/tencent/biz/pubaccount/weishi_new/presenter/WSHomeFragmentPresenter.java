package com.tencent.biz.pubaccount.weishi_new.presenter;

import UserGrowth.stGetTabsRsp;
import UserGrowth.stNotificationRedDot;
import UserGrowth.stPublisherGuide;
import UserGrowth.stPublisherRsp;
import UserGrowth.stRedDotMenu;
import UserGrowth.stSchema;
import UserGrowth.stSimpleMetaFeed;
import UserGrowth.stTabInfo;
import android.content.Context;
import android.content.res.Resources;
import android.text.TextUtils;
import com.tencent.biz.pubaccount.readinjoy.engine.WeishiManager;
import com.tencent.biz.pubaccount.weishi_new.WSMultiImageManager;
import com.tencent.biz.pubaccount.weishi_new.WeishiActivityHelper;
import com.tencent.biz.pubaccount.weishi_new.cache.WSVideoPreloadManager;
import com.tencent.biz.pubaccount.weishi_new.cache.WeiShiCacheManager;
import com.tencent.biz.pubaccount.weishi_new.config.WSGlobalConfig;
import com.tencent.biz.pubaccount.weishi_new.net.WeishiBusinessLooper;
import com.tencent.biz.pubaccount.weishi_new.net.WeishiTask;
import com.tencent.biz.pubaccount.weishi_new.presenter.view.IWSHomeView;
import com.tencent.biz.pubaccount.weishi_new.report.WSPublicAccReport;
import com.tencent.biz.pubaccount.weishi_new.request.GetAIOFeedDetailRequest;
import com.tencent.biz.pubaccount.weishi_new.request.GetPublisherRequest;
import com.tencent.biz.pubaccount.weishi_new.request.GetTabsRequest;
import com.tencent.biz.pubaccount.weishi_new.request.RedDotRequest;
import com.tencent.biz.pubaccount.weishi_new.util.WSLog;
import com.tencent.biz.pubaccount.weishi_new.util.WeishiUtils;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.app.GuardManager;
import com.tencent.mobileqq.app.guardinterface.IGuardInterface;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.jetbrains.annotations.Nullable;

public class WSHomeFragmentPresenter
  extends WSBasePresenter<IWSHomeView>
  implements IGuardInterface
{
  private List<stNotificationRedDot> a;
  private List<stRedDotMenu> b;
  
  private int a()
  {
    return WSGlobalConfig.a().a();
  }
  
  @Nullable
  private stRedDotMenu a(String paramString)
  {
    Object localObject = a();
    if (localObject == null) {
      return null;
    }
    Iterator localIterator = ((List)localObject).iterator();
    do
    {
      if (!localIterator.hasNext()) {
        break;
      }
      localObject = (stRedDotMenu)localIterator.next();
    } while (!TextUtils.equals(paramString, ((stRedDotMenu)localObject).menuKey));
    for (paramString = (String)localObject;; paramString = null) {
      return paramString;
    }
  }
  
  private WeishiTask a()
  {
    return new WeishiTask(new RedDotRequest(), null, new WSHomeFragmentPresenter.1(this), 1001);
  }
  
  private void a(stGetTabsRsp paramstGetTabsRsp)
  {
    paramstGetTabsRsp = new WeishiTask(new GetTabsRequest(), null, new WSHomeFragmentPresenter.7(this, System.currentTimeMillis(), paramstGetTabsRsp), 4017);
    WeishiBusinessLooper.a().a(paramstGetTabsRsp);
  }
  
  private void a(stSimpleMetaFeed paramstSimpleMetaFeed)
  {
    WeishiManager localWeishiManager = WeishiUtils.a();
    if (localWeishiManager == null) {
      return;
    }
    WSLog.e("WSHomeFragmentPresenter", "[handleSaveAndPreloadData] saveLastFeedInfoFromOperation");
    paramstSimpleMetaFeed.feed_desc = WeishiUtils.a(paramstSimpleMetaFeed.feed_desc);
    localWeishiManager.a(paramstSimpleMetaFeed);
    WSVideoPreloadManager.a(paramstSimpleMetaFeed);
  }
  
  private void a(Context paramContext, stRedDotMenu paramstRedDotMenu, String paramString, int paramInt1, int paramInt2)
  {
    if ((paramstRedDotMenu != null) && (paramstRedDotMenu.schema != null))
    {
      paramstRedDotMenu = paramstRedDotMenu.schema;
      if (paramstRedDotMenu.type == 1)
      {
        if (paramInt2 == 1) {
          WeishiUtils.c("homepage_main");
        }
        for (;;)
        {
          a(paramContext, paramstRedDotMenu.miniAppSchema);
          return;
          if (paramInt2 == 2) {
            WeishiUtils.c("message");
          }
        }
      }
      if (paramstRedDotMenu.type == 2)
      {
        a(paramContext, paramstRedDotMenu.schema, "", "", paramInt1);
        return;
      }
      if (paramstRedDotMenu.type == 3)
      {
        WeishiActivityHelper.a(paramContext, paramstRedDotMenu.H5Url);
        return;
      }
      WSLog.d("WSHomeFragmentPresenter", "jumOtherPlatform other type：" + paramstRedDotMenu.type);
      a(paramContext, paramString, "", "", paramInt1);
      return;
    }
    WSLog.d("WSHomeFragmentPresenter", "jumOtherPlatform messageMenu is null");
    a(paramContext, paramString, "", "", paramInt1);
  }
  
  private void a(Context paramContext, String paramString)
  {
    WeishiActivityHelper.a(paramContext, paramString, new WSHomeFragmentPresenter.2(this));
  }
  
  private void a(Context paramContext, String paramString1, String paramString2, String paramString3, int paramInt)
  {
    WeishiUtils.a(paramContext, paramString1, paramString2, paramString3, a(), new WSHomeFragmentPresenter.3(this, paramContext, paramInt));
  }
  
  private void b(stGetTabsRsp paramstGetTabsRsp)
  {
    IWSHomeView localIWSHomeView = (IWSHomeView)a();
    if ((paramstGetTabsRsp == null) || (paramstGetTabsRsp.Tabs == null) || (paramstGetTabsRsp.Tabs.size() < 1) || (localIWSHomeView == null)) {}
    while (TextUtils.isEmpty(((stTabInfo)paramstGetTabsRsp.Tabs.get(0)).displayIcon)) {
      return;
    }
    localIWSHomeView.c();
  }
  
  public List<stRedDotMenu> a()
  {
    return this.b;
  }
  
  public void a()
  {
    WSPublicAccReport.getInstance().foregroundPublicAccReport();
  }
  
  public void a(long paramLong) {}
  
  public void a(Context paramContext)
  {
    a(paramContext, a("PersonalPage"), "weishi://profile?goto=myself", 603, 1);
  }
  
  public void a(Context paramContext, int paramInt)
  {
    a(paramContext, a("Notification"), "weishi://message?page=notifiaction", paramInt, 2);
  }
  
  public void a(Context paramContext, stPublisherRsp paramstPublisherRsp)
  {
    if ((paramstPublisherRsp == null) || (paramstPublisherRsp.guide == null)) {
      return;
    }
    URLImageView localURLImageView = new URLImageView(paramContext);
    paramContext = paramContext.getResources().getDrawable(2130841881);
    new WSMultiImageManager().a(localURLImageView, paramContext, paramstPublisherRsp.guide.imageUrl, true, true);
  }
  
  public void a(List<stNotificationRedDot> paramList)
  {
    this.a = paramList;
  }
  
  public void a(boolean paramBoolean) {}
  
  public List<stNotificationRedDot> b()
  {
    return this.a;
  }
  
  public void b()
  {
    WSPublicAccReport.getInstance().backgroundPublicAccReport();
  }
  
  public void b(long paramLong) {}
  
  public void b(Context paramContext)
  {
    stRedDotMenu localstRedDotMenu = a("Feedback");
    if ((localstRedDotMenu == null) || (localstRedDotMenu.schema == null) || (TextUtils.isEmpty(localstRedDotMenu.schema.H5Url))) {
      return;
    }
    WeishiActivityHelper.a(paramContext, localstRedDotMenu.schema.H5Url);
  }
  
  public void c(long paramLong) {}
  
  public void e()
  {
    WeishiBusinessLooper.a().a(a());
  }
  
  public void f()
  {
    WeishiTask localWeishiTask = new WeishiTask(new GetPublisherRequest(), null, new WSHomeFragmentPresenter.4(this), 4008);
    WeishiBusinessLooper.a().a(localWeishiTask);
  }
  
  public void g()
  {
    long l = System.currentTimeMillis();
    WeishiTask localWeishiTask = new WeishiTask(new GetAIOFeedDetailRequest(), null, new WSHomeFragmentPresenter.5(this, l), 4015);
    WeishiBusinessLooper.a().a(localWeishiTask);
  }
  
  public void h()
  {
    WeiShiCacheManager.a().e(new WSHomeFragmentPresenter.6(this));
  }
  
  public void i()
  {
    if (GuardManager.a != null) {
      GuardManager.a.a(this);
    }
  }
  
  public void j()
  {
    if (GuardManager.a != null) {
      GuardManager.a.b(this);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.presenter.WSHomeFragmentPresenter
 * JD-Core Version:    0.7.0.1
 */