package com.tencent.mobileqq.activity.recent.bannerprocessor;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.common.util.HttpUtil;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.banner.Banner;
import com.tencent.mobileqq.banner.BannerManager;
import com.tencent.mobileqq.banner.BannerTypeCollections;
import com.tencent.mobileqq.banner.TipsBar;
import com.tencent.mobileqq.banner.processor.BaseBannerProcessor;
import com.tencent.mobileqq.banner.processor.IBannerLifecycle;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.qqfeatureswitch.IFeatureRuntimeService;
import com.tencent.mobileqq.qroute.annotation.KeepClassConstructor;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.tianshu.data.TianShuAdPosItemData;
import com.tencent.mobileqq.tianshu.data.TianShuGetAdvCallback;
import com.tencent.mobileqq.tianshu.data.TianShuReportData;
import com.tencent.mobileqq.utils.CustomHandler;
import com.tencent.mobileqq.utils.JumpAction;
import com.tencent.mobileqq.utils.JumpParser;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import cooperation.vip.pb.TianShuAccess.AdItem;
import cooperation.vip.pb.TianShuAccess.AdPlacementInfo;
import cooperation.vip.pb.TianShuAccess.GetAdsRsp;
import cooperation.vip.pb.TianShuAccess.MapEntry;
import cooperation.vip.pb.TianShuAccess.RspEntry;
import cooperation.vip.tianshu.TianShuManager;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import mqq.app.AppRuntime;
import mqq.os.MqqHandler;

@KeepClassConstructor
public class VerifyPhoneBannerProcessor
  extends BaseBannerProcessor
  implements Handler.Callback, View.OnClickListener, IBannerLifecycle, TianShuGetAdvCallback
{
  public static final int a = BannerTypeCollections.u;
  volatile String b = "";
  String c = "";
  String d = "";
  int e;
  
  public VerifyPhoneBannerProcessor(QBaseActivity paramQBaseActivity)
  {
    super(paramQBaseActivity);
    this.g = new CustomHandler(Looper.getMainLooper(), this);
  }
  
  private void g()
  {
    TianShuReportData localTianShuReportData = new TianShuReportData();
    localTianShuReportData.p = 102;
    localTianShuReportData.c = 1;
    localTianShuReportData.h = String.valueOf(this.e);
    localTianShuReportData.b = String.valueOf(NetConnInfoCenter.getServerTime());
    localTianShuReportData.o = NetConnInfoCenter.getServerTime();
    TianShuManager.getInstance().report(localTianShuReportData);
  }
  
  private void h()
  {
    if (BannerManager.a().d(a)) {
      BannerManager.a().a(a, 0, null);
    }
  }
  
  public View a(Banner paramBanner)
  {
    paramBanner = new TipsBar(this.f);
    paramBanner.setTipsText(this.b);
    paramBanner.setTipsIcon(this.f.getResources().getDrawable(2130839453));
    paramBanner.setOnClickListener(this);
    ReportController.b(null, "dc00898", "", "", "0X800BC91", "0X800BC91", 0, 0, this.d, "", this.b, this.c);
    return paramBanner;
  }
  
  public void a(AppRuntime paramAppRuntime)
  {
    this.g.removeCallbacksAndMessages(null);
  }
  
  public int b()
  {
    return a;
  }
  
  public void d() {}
  
  protected void e()
  {
    ArrayList localArrayList = new ArrayList();
    TianShuAdPosItemData localTianShuAdPosItemData = new TianShuAdPosItemData();
    localTianShuAdPosItemData.a = 768;
    localTianShuAdPosItemData.b = 1;
    localArrayList.add(localTianShuAdPosItemData);
    TianShuManager.getInstance().requestAdv(localArrayList, this);
  }
  
  protected boolean f()
  {
    return ((IFeatureRuntimeService)BaseApplicationImpl.getApplication().getRuntime().getRuntimeService(IFeatureRuntimeService.class, "all")).isFeatureSwitchEnable("Secure_VerfifyPhone_864441577");
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    if (!f())
    {
      QLog.d("VerifyPhoneBannerProcessor", 1, "feature switch state is false, return");
      return true;
    }
    if (paramMessage.what == 3000) {
      e();
    }
    return true;
  }
  
  public void onClick(View paramView)
  {
    Object localObject = JumpParser.a((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime(), this.f, this.c);
    if (localObject != null)
    {
      ((JumpAction)localObject).a();
    }
    else if (HttpUtil.isValidUrl(this.c))
    {
      localObject = new Intent(this.f, QQBrowserActivity.class);
      ((Intent)localObject).putExtra("url", this.c);
      this.f.startActivity((Intent)localObject);
    }
    else
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("jump fail, link is ");
      ((StringBuilder)localObject).append(this.c);
      QLog.d("VerifyPhoneBannerProcessor", 1, ((StringBuilder)localObject).toString());
    }
    h();
    g();
    ReportController.b(null, "dc00898", "", "", "0X800BC92", "0X800BC92", 0, 0, this.d, "", this.b, this.c);
    EventCollector.getInstance().onViewClicked(paramView);
  }
  
  public void onGetAdvs(boolean paramBoolean, TianShuAccess.GetAdsRsp paramGetAdsRsp)
  {
    if (paramGetAdsRsp.mapAds.has()) {
      paramGetAdsRsp = paramGetAdsRsp.mapAds.get();
    } else {
      paramGetAdsRsp = null;
    }
    if ((paramGetAdsRsp != null) && (!paramGetAdsRsp.isEmpty()))
    {
      paramGetAdsRsp = (TianShuAccess.RspEntry)paramGetAdsRsp.get(0);
      if (paramGetAdsRsp.value.lst.has()) {
        paramGetAdsRsp = paramGetAdsRsp.value.lst.get();
      } else {
        paramGetAdsRsp = null;
      }
      if ((paramGetAdsRsp != null) && (!paramGetAdsRsp.isEmpty()))
      {
        paramGetAdsRsp = (TianShuAccess.AdItem)paramGetAdsRsp.get(0);
        Iterator localIterator = paramGetAdsRsp.argList.get().iterator();
        while (localIterator.hasNext())
        {
          TianShuAccess.MapEntry localMapEntry = (TianShuAccess.MapEntry)localIterator.next();
          if (localMapEntry.key.get().equals("scene")) {
            this.d = localMapEntry.value.get();
          } else if (localMapEntry.key.get().equals("wording")) {
            this.b = localMapEntry.value.get();
          } else if (localMapEntry.key.get().equals("link")) {
            this.c = localMapEntry.value.get();
          }
        }
        this.e = paramGetAdsRsp.iAdId.get();
        if ((!TextUtils.isEmpty(this.b)) && (!TextUtils.isEmpty(this.c)))
        {
          BannerManager.a().a(a, 2, null);
          return;
        }
        h();
        paramGetAdsRsp = new StringBuilder();
        paramGetAdsRsp.append("onGetAdvs hide banner, mword is ");
        paramGetAdsRsp.append(this.b);
        paramGetAdsRsp.append(" mLink is ");
        paramGetAdsRsp.append(this.c);
        QLog.d("VerifyPhoneBannerProcessor", 1, paramGetAdsRsp.toString());
        return;
      }
      QLog.d("VerifyPhoneBannerProcessor", 1, "onGetAdvs failed adItemList == null || adItemList.isEmpty()");
      h();
      return;
    }
    QLog.d("VerifyPhoneBannerProcessor", 1, "onGetAdvs failed rspEntries == null || rspEntries.isEmpty()");
    h();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.recent.bannerprocessor.VerifyPhoneBannerProcessor
 * JD-Core Version:    0.7.0.1
 */