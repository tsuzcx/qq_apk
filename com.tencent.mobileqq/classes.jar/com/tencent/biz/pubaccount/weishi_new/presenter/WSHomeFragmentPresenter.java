package com.tencent.biz.pubaccount.weishi_new.presenter;

import UserGrowth.stGetTabsRsp;
import UserGrowth.stNotificationRedDot;
import UserGrowth.stPublisherGuide;
import UserGrowth.stPublisherRsp;
import UserGrowth.stRedDotMenu;
import UserGrowth.stSchema;
import UserGrowth.stTabInfo;
import android.content.Context;
import android.content.res.Resources;
import android.text.TextUtils;
import com.tencent.biz.pubaccount.weishi_new.WSMultiImageManager;
import com.tencent.biz.pubaccount.weishi_new.WeishiActivityHelper;
import com.tencent.biz.pubaccount.weishi_new.cache.WeiShiCacheManager;
import com.tencent.biz.pubaccount.weishi_new.config.WSGlobalConfig;
import com.tencent.biz.pubaccount.weishi_new.net.WeishiBusinessLooper;
import com.tencent.biz.pubaccount.weishi_new.net.WeishiTask;
import com.tencent.biz.pubaccount.weishi_new.presenter.view.IWSHomeView;
import com.tencent.biz.pubaccount.weishi_new.report.WSPublicAccReport;
import com.tencent.biz.pubaccount.weishi_new.request.GetPublisherRequest;
import com.tencent.biz.pubaccount.weishi_new.request.GetTabsRequest;
import com.tencent.biz.pubaccount.weishi_new.request.RedDotRequest;
import com.tencent.biz.pubaccount.weishi_new.util.WSLog;
import com.tencent.biz.pubaccount.weishi_new.util.WeishiUtils;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.app.guard.GuardManager;
import com.tencent.mobileqq.app.guard.guardinterface.IGuardInterface;
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
    Object localObject1 = a();
    Object localObject2 = null;
    if (localObject1 == null) {
      return null;
    }
    Iterator localIterator = ((List)localObject1).iterator();
    do
    {
      localObject1 = localObject2;
      if (!localIterator.hasNext()) {
        break;
      }
      localObject1 = (stRedDotMenu)localIterator.next();
    } while (!TextUtils.equals(paramString, ((stRedDotMenu)localObject1).menuKey));
    return localObject1;
  }
  
  private WeishiTask a()
  {
    return new WeishiTask(new RedDotRequest(), null, new WSHomeFragmentPresenter.1(this), 1001);
  }
  
  private void a(stGetTabsRsp paramstGetTabsRsp)
  {
    paramstGetTabsRsp = new WeishiTask(new GetTabsRequest(), null, new WSHomeFragmentPresenter.6(this, System.currentTimeMillis(), paramstGetTabsRsp), 4017);
    WeishiBusinessLooper.a().a(paramstGetTabsRsp);
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
        } else if (paramInt2 == 2) {
          WeishiUtils.c("message");
        }
        a(paramContext, paramstRedDotMenu.miniAppSchema);
        return;
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
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("jumOtherPlatform other type：");
      localStringBuilder.append(paramstRedDotMenu.type);
      WSLog.d("WSHomeFragmentPresenter", localStringBuilder.toString());
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
    if ((paramstGetTabsRsp != null) && (paramstGetTabsRsp.Tabs != null) && (paramstGetTabsRsp.Tabs.size() >= 1))
    {
      if (localIWSHomeView == null) {
        return;
      }
      if (TextUtils.isEmpty(((stTabInfo)paramstGetTabsRsp.Tabs.get(0)).displayIcon)) {
        return;
      }
      localIWSHomeView.c();
    }
  }
  
  public void G_()
  {
    WSPublicAccReport.getInstance().foregroundPublicAccReport();
  }
  
  public void H_()
  {
    WSPublicAccReport.getInstance().backgroundPublicAccReport();
  }
  
  public List<stRedDotMenu> a()
  {
    return this.b;
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
    if (paramstPublisherRsp != null)
    {
      if (paramstPublisherRsp.guide == null) {
        return;
      }
      URLImageView localURLImageView = new URLImageView(paramContext);
      paramContext = paramContext.getResources().getDrawable(2130841770);
      new WSMultiImageManager().a(localURLImageView, paramContext, paramstPublisherRsp.guide.imageUrl, true, true);
    }
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
  
  public void b(long paramLong) {}
  
  public void b(Context paramContext)
  {
    stRedDotMenu localstRedDotMenu = a("Feedback");
    if ((localstRedDotMenu != null) && (localstRedDotMenu.schema != null))
    {
      if (TextUtils.isEmpty(localstRedDotMenu.schema.H5Url)) {
        return;
      }
      WeishiActivityHelper.a(paramContext, localstRedDotMenu.schema.H5Url);
    }
  }
  
  public void c()
  {
    WeishiBusinessLooper.a().a(a());
  }
  
  public void c(long paramLong) {}
  
  public void d()
  {
    WeishiTask localWeishiTask = new WeishiTask(new GetPublisherRequest(), null, new WSHomeFragmentPresenter.4(this), 4008);
    WeishiBusinessLooper.a().a(localWeishiTask);
  }
  
  public void e()
  {
    WeiShiCacheManager.a().e(new WSHomeFragmentPresenter.5(this));
  }
  
  public void f()
  {
    if (GuardManager.a != null) {
      GuardManager.a.a(this);
    }
  }
  
  public void g()
  {
    if (GuardManager.a != null) {
      GuardManager.a.b(this);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.presenter.WSHomeFragmentPresenter
 * JD-Core Version:    0.7.0.1
 */