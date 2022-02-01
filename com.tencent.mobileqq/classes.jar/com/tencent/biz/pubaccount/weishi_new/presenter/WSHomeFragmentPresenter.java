package com.tencent.biz.pubaccount.weishi_new.presenter;

import UserGrowth.stGetTabsRsp;
import UserGrowth.stNotificationRedDot;
import UserGrowth.stPublisherGuide;
import UserGrowth.stPublisherRsp;
import UserGrowth.stRedDotMenu;
import UserGrowth.stSchema;
import UserGrowth.stSimpleMetaPerson;
import UserGrowth.stTabInfo;
import android.content.Context;
import android.content.res.Resources;
import android.text.TextUtils;
import androidx.annotation.Nullable;
import com.tencent.biz.pubaccount.weishi_new.WSMultiImageManager;
import com.tencent.biz.pubaccount.weishi_new.WeishiActivityHelper;
import com.tencent.biz.pubaccount.weishi_new.cache.WeiShiCacheManager;
import com.tencent.biz.pubaccount.weishi_new.combo.publisher.WSPublisherFetcher;
import com.tencent.biz.pubaccount.weishi_new.config.WSGlobalConfig;
import com.tencent.biz.pubaccount.weishi_new.net.WeishiBusinessLooper;
import com.tencent.biz.pubaccount.weishi_new.net.WeishiTask;
import com.tencent.biz.pubaccount.weishi_new.presenter.view.IWSHomeView;
import com.tencent.biz.pubaccount.weishi_new.profile.WSProfileFragment;
import com.tencent.biz.pubaccount.weishi_new.report.WSPublicAccReport;
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

public class WSHomeFragmentPresenter
  extends WSBasePresenter<IWSHomeView>
  implements IGuardInterface
{
  private List<stNotificationRedDot> a;
  private List<stRedDotMenu> b;
  
  @Nullable
  private stRedDotMenu a(String paramString)
  {
    Object localObject1 = b();
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
  
  private void a(stGetTabsRsp paramstGetTabsRsp)
  {
    paramstGetTabsRsp = new WeishiTask(new GetTabsRequest(), null, new WSHomeFragmentPresenter.6(this, System.currentTimeMillis(), paramstGetTabsRsp), 4017);
    WeishiBusinessLooper.a().a(paramstGetTabsRsp);
  }
  
  private void a(@Nullable stSimpleMetaPerson paramstSimpleMetaPerson)
  {
    if (paramstSimpleMetaPerson == null) {
      return;
    }
    if (!TextUtils.isEmpty(paramstSimpleMetaPerson.id)) {
      WeishiUtils.k(paramstSimpleMetaPerson.id);
    }
    if (!TextUtils.isEmpty(paramstSimpleMetaPerson.nick)) {
      WeishiUtils.l(paramstSimpleMetaPerson.nick);
    }
  }
  
  private void a(Context paramContext, stRedDotMenu paramstRedDotMenu, String paramString, int paramInt1, int paramInt2)
  {
    if ((paramstRedDotMenu != null) && (paramstRedDotMenu.schema != null))
    {
      paramstRedDotMenu = paramstRedDotMenu.schema;
      if (paramstRedDotMenu.type == 1)
      {
        if (paramInt2 == 1) {
          WeishiUtils.m("homepage_main");
        } else if (paramInt2 == 2) {
          WeishiUtils.m("message");
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
    WeishiUtils.a(paramContext, paramString1, paramString2, paramString3, i(), new WSHomeFragmentPresenter.3(this, paramContext, paramInt));
  }
  
  private void b(stGetTabsRsp paramstGetTabsRsp)
  {
    IWSHomeView localIWSHomeView = (IWSHomeView)getView();
    if ((paramstGetTabsRsp != null) && (paramstGetTabsRsp.Tabs != null) && (paramstGetTabsRsp.Tabs.size() >= 1))
    {
      if (localIWSHomeView == null) {
        return;
      }
      if (TextUtils.isEmpty(((stTabInfo)paramstGetTabsRsp.Tabs.get(0)).displayIcon)) {
        return;
      }
      localIWSHomeView.p();
    }
  }
  
  private WeishiTask h()
  {
    return new WeishiTask(new RedDotRequest(), null, new WSHomeFragmentPresenter.1(this), 1001);
  }
  
  private int i()
  {
    return WSGlobalConfig.a().d();
  }
  
  public void a()
  {
    WeishiBusinessLooper.a().a(h());
  }
  
  public void a(Context paramContext)
  {
    WSProfileFragment.a(paramContext, WeishiUtils.n(), "my_profile");
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
      paramContext = paramContext.getResources().getDrawable(2130842687);
      new WSMultiImageManager().a(localURLImageView, paramContext, paramstPublisherRsp.guide.imageUrl, true, true);
    }
  }
  
  public void a(List<stNotificationRedDot> paramList)
  {
    this.a = paramList;
  }
  
  public List<stRedDotMenu> b()
  {
    return this.b;
  }
  
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
  
  public List<stNotificationRedDot> c()
  {
    return this.a;
  }
  
  public void d()
  {
    new WSPublisherFetcher().a(new WSHomeFragmentPresenter.4(this));
  }
  
  public void e()
  {
    WeiShiCacheManager.a().e(new WSHomeFragmentPresenter.5(this));
  }
  
  public void f()
  {
    if (GuardManager.sInstance != null) {
      GuardManager.sInstance.registerCallBack(this);
    }
  }
  
  public void g()
  {
    if (GuardManager.sInstance != null) {
      GuardManager.sInstance.unregisterCallback(this);
    }
  }
  
  public void onApplicationBackground()
  {
    WSPublicAccReport.getInstance().backgroundPublicAccReport();
  }
  
  public void onApplicationForeground()
  {
    WSPublicAccReport.getInstance().foregroundPublicAccReport();
  }
  
  public void onBackgroundTimeTick(long paramLong) {}
  
  public void onBackgroundUnguardTimeTick(long paramLong) {}
  
  public void onLiteTimeTick(long paramLong) {}
  
  public void onScreensStateChanged(boolean paramBoolean) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.presenter.WSHomeFragmentPresenter
 * JD-Core Version:    0.7.0.1
 */