package com.tencent.biz.pubaccount.readinjoyAd.ad.super_mask.mgr;

import android.app.Activity;
import android.webkit.ValueCallback;
import com.tencent.biz.pubaccount.readinjoyAd.ad.super_mask.api.SuperMaskStep;
import com.tencent.biz.pubaccount.readinjoyAd.ad.super_mask.step.AladdinCheckStep;
import com.tencent.biz.pubaccount.readinjoyAd.ad.super_mask.step.ShowIntervalCheckStep;
import com.tencent.biz.pubaccount.readinjoyAd.ad.super_mask.step.SuperMaskStepUtil;
import com.tencent.biz.pubaccount.readinjoyAd.ad.utils.ReadInJoyAdLog;
import com.tencent.biz.pubaccount.readinjoyAd.ad.utils.ReadInJoySuperMaskAdUtil;
import com.tencent.biz.pubaccount.readinjoyAd.ad.view.KandianAdPandentMask;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.kandian.repo.daily.api.IDailyModeConfigHandler;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.widget.ListView;
import java.lang.ref.SoftReference;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/biz/pubaccount/readinjoyAd/ad/super_mask/mgr/SuperMaskUIMgr;", "", "()V", "activity", "Ljava/lang/ref/SoftReference;", "Landroid/app/Activity;", "getActivity", "()Ljava/lang/ref/SoftReference;", "setActivity", "(Ljava/lang/ref/SoftReference;)V", "channelID", "", "getChannelID", "()I", "setChannelID", "(I)V", "hasVolume", "", "getHasVolume", "()Z", "setHasVolume", "(Z)V", "isShowing", "setShowing", "listView", "Lcom/tencent/widget/ListView;", "getListView", "setListView", "showStatus", "getShowStatus", "setShowStatus", "superMaskUI", "Lcom/tencent/biz/pubaccount/readinjoyAd/ad/view/KandianAdPandentMask;", "checkChannelID", "checkResValid", "", "callback", "Landroid/webkit/ValueCallback;", "close", "onPause", "onResume", "resetUIMgr", "shouldShowSuperMask", "showSuperMask", "kandian_ad_feature_impl_release"}, k=1, mv={1, 1, 16})
public final class SuperMaskUIMgr
{
  public static final SuperMaskUIMgr a = new SuperMaskUIMgr();
  private static int b;
  private static volatile boolean c = true;
  private static volatile boolean d;
  private static int e = -1;
  @Nullable
  private static SoftReference<Activity> f;
  @Nullable
  private static SoftReference<ListView> g;
  private static SoftReference<KandianAdPandentMask> h;
  
  public final int a()
  {
    return b;
  }
  
  public final void a(int paramInt)
  {
    b = paramInt;
  }
  
  public final void a(@NotNull ValueCallback<Boolean> paramValueCallback)
  {
    Intrinsics.checkParameterIsNotNull(paramValueCallback, "callback");
    ThreadManagerV2.post((Runnable)new SuperMaskUIMgr.checkResValid.1(paramValueCallback), 10, null, true);
  }
  
  public final void a(@Nullable SoftReference<Activity> paramSoftReference)
  {
    f = paramSoftReference;
  }
  
  public final void a(boolean paramBoolean)
  {
    c = paramBoolean;
  }
  
  public final void b(int paramInt)
  {
    e = paramInt;
  }
  
  public final void b(@Nullable SoftReference<ListView> paramSoftReference)
  {
    g = paramSoftReference;
  }
  
  public final void b(boolean paramBoolean)
  {
    d = paramBoolean;
  }
  
  public final boolean b()
  {
    return c;
  }
  
  public final int c()
  {
    return e;
  }
  
  public final boolean d()
  {
    AladdinCheckStep localAladdinCheckStep = new AladdinCheckStep();
    if (SuperMaskConfigMgr.a.c() == 1) {
      return SuperMaskStepUtil.a.a("[SHOW]", new SuperMaskStep[] { (SuperMaskStep)localAladdinCheckStep });
    }
    ShowIntervalCheckStep localShowIntervalCheckStep = new ShowIntervalCheckStep(e);
    return SuperMaskStepUtil.a.a("[SHOW]", new SuperMaskStep[] { (SuperMaskStep)localAladdinCheckStep, (SuperMaskStep)localShowIntervalCheckStep });
  }
  
  public final void e()
  {
    h = new SoftReference(new KandianAdPandentMask());
    ReadInJoyAdLog.a("ReadInJoySuperMaskAd", "UI showSuperMask");
    Object localObject1 = h;
    if (localObject1 != null) {
      localObject1 = (KandianAdPandentMask)((SoftReference)localObject1).get();
    } else {
      localObject1 = null;
    }
    Object localObject2 = f;
    if (localObject2 != null) {
      localObject2 = (Activity)((SoftReference)localObject2).get();
    } else {
      localObject2 = null;
    }
    Object localObject3 = g;
    if (localObject3 != null) {
      localObject3 = (ListView)((SoftReference)localObject3).get();
    } else {
      localObject3 = null;
    }
    JSONObject localJSONObject = SuperMaskDataMgr.a.b();
    if (localObject1 == null)
    {
      SuperMaskReportMgr.a(SuperMaskReportMgr.a, "uiIsNull", null, 2, null);
      return;
    }
    if (localObject2 == null)
    {
      SuperMaskReportMgr.a(SuperMaskReportMgr.a, "actIsNull", null, 2, null);
      return;
    }
    if (localObject3 == null)
    {
      SuperMaskReportMgr.a(SuperMaskReportMgr.a, "listIsNull", null, 2, null);
      return;
    }
    if (localJSONObject == null)
    {
      SuperMaskReportMgr.a(SuperMaskReportMgr.a, "dataIsNull", null, 2, null);
      return;
    }
    ((KandianAdPandentMask)localObject1).a((Activity)localObject2, (ListView)localObject3, localJSONObject);
  }
  
  public final boolean f()
  {
    return (e == 0) || (((IDailyModeConfigHandler)QRoute.api(IDailyModeConfigHandler.class)).isDaily(e));
  }
  
  public final void g()
  {
    if (!f())
    {
      ReadInJoyAdLog.a("ReadInJoySuperMaskAd", "UI onResume  : checkChannelID fail");
      i();
    }
  }
  
  public final void h()
  {
    if ((d) && (!ReadInJoySuperMaskAdUtil.a))
    {
      String str;
      if (SuperMaskReportMgr.a.b()) {
        str = "enterBackground";
      } else {
        str = "enterBackgroundNoExpose";
      }
      SuperMaskReportMgr.a(SuperMaskReportMgr.a, str, null, 2, null);
    }
    i();
  }
  
  public final void i()
  {
    ReadInJoyAdLog.a("ReadInJoySuperMaskAd", "UI close");
    if (d)
    {
      Object localObject = h;
      if (localObject != null)
      {
        localObject = (KandianAdPandentMask)((SoftReference)localObject).get();
        if (localObject != null) {
          ((KandianAdPandentMask)localObject).b();
        }
      }
      localObject = h;
      if (localObject != null)
      {
        localObject = (KandianAdPandentMask)((SoftReference)localObject).get();
        if (localObject != null) {
          ((KandianAdPandentMask)localObject).a();
        }
      }
      ReadInJoyAdLog.a("ReadInJoySuperMaskAd", "UI close with isShowing");
    }
  }
  
  public final void j()
  {
    ReadInJoyAdLog.a("ReadInJoySuperMaskAd", "setSuperMaskChannelId -1 : resetUIMgr");
    e = -1;
    SoftReference localSoftReference = (SoftReference)null;
    f = localSoftReference;
    h = localSoftReference;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoyAd.ad.super_mask.mgr.SuperMaskUIMgr
 * JD-Core Version:    0.7.0.1
 */