package com.tencent.biz.pubaccount.readinjoyAd.ad.super_mask.mgr;

import android.app.Activity;
import android.webkit.ValueCallback;
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
  private static int jdField_a_of_type_Int;
  public static final SuperMaskUIMgr a;
  @Nullable
  private static SoftReference<Activity> jdField_a_of_type_JavaLangRefSoftReference;
  private static volatile boolean jdField_a_of_type_Boolean = true;
  private static int jdField_b_of_type_Int = -1;
  @Nullable
  private static SoftReference<ListView> jdField_b_of_type_JavaLangRefSoftReference;
  private static volatile boolean jdField_b_of_type_Boolean;
  private static SoftReference<KandianAdPandentMask> c;
  
  static
  {
    jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdSuper_maskMgrSuperMaskUIMgr = new SuperMaskUIMgr();
  }
  
  public final int a()
  {
    return jdField_a_of_type_Int;
  }
  
  public final void a()
  {
    c = new SoftReference(new KandianAdPandentMask());
    ReadInJoyAdLog.a("ReadInJoySuperMaskAd", "UI showSuperMask");
    Object localObject1 = c;
    if (localObject1 != null) {
      localObject1 = (KandianAdPandentMask)((SoftReference)localObject1).get();
    } else {
      localObject1 = null;
    }
    Object localObject2 = jdField_a_of_type_JavaLangRefSoftReference;
    if (localObject2 != null) {
      localObject2 = (Activity)((SoftReference)localObject2).get();
    } else {
      localObject2 = null;
    }
    Object localObject3 = jdField_b_of_type_JavaLangRefSoftReference;
    if (localObject3 != null) {
      localObject3 = (ListView)((SoftReference)localObject3).get();
    } else {
      localObject3 = null;
    }
    JSONObject localJSONObject = SuperMaskDataMgr.a.a();
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
  
  public final void a(int paramInt)
  {
    jdField_a_of_type_Int = paramInt;
  }
  
  public final void a(@NotNull ValueCallback<Boolean> paramValueCallback)
  {
    Intrinsics.checkParameterIsNotNull(paramValueCallback, "callback");
    ThreadManagerV2.post((Runnable)new SuperMaskUIMgr.checkResValid.1(paramValueCallback), 10, null, true);
  }
  
  public final void a(@Nullable SoftReference<Activity> paramSoftReference)
  {
    jdField_a_of_type_JavaLangRefSoftReference = paramSoftReference;
  }
  
  public final void a(boolean paramBoolean)
  {
    jdField_a_of_type_Boolean = paramBoolean;
  }
  
  public final boolean a()
  {
    return jdField_a_of_type_Boolean;
  }
  
  public final int b()
  {
    return jdField_b_of_type_Int;
  }
  
  public final void b()
  {
    if (!b())
    {
      ReadInJoyAdLog.a("ReadInJoySuperMaskAd", "UI onResume  : checkChannelID fail");
      d();
    }
  }
  
  public final void b(int paramInt)
  {
    jdField_b_of_type_Int = paramInt;
  }
  
  public final void b(@Nullable SoftReference<ListView> paramSoftReference)
  {
    jdField_b_of_type_JavaLangRefSoftReference = paramSoftReference;
  }
  
  public final void b(boolean paramBoolean)
  {
    jdField_b_of_type_Boolean = paramBoolean;
  }
  
  public final boolean b()
  {
    return (jdField_b_of_type_Int == 0) || (((IDailyModeConfigHandler)QRoute.api(IDailyModeConfigHandler.class)).isDaily(jdField_b_of_type_Int));
  }
  
  public final void c()
  {
    if ((jdField_b_of_type_Boolean) && (!ReadInJoySuperMaskAdUtil.jdField_a_of_type_Boolean))
    {
      String str;
      if (SuperMaskReportMgr.a.a()) {
        str = "enterBackground";
      } else {
        str = "enterBackgroundNoExpose";
      }
      SuperMaskReportMgr.a(SuperMaskReportMgr.a, str, null, 2, null);
    }
    d();
  }
  
  public final void d()
  {
    ReadInJoyAdLog.a("ReadInJoySuperMaskAd", "UI close");
    if (jdField_b_of_type_Boolean)
    {
      Object localObject = c;
      if (localObject != null)
      {
        localObject = (KandianAdPandentMask)((SoftReference)localObject).get();
        if (localObject != null) {
          ((KandianAdPandentMask)localObject).b();
        }
      }
      localObject = c;
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
  
  public final void e()
  {
    ReadInJoyAdLog.a("ReadInJoySuperMaskAd", "setSuperMaskChannelId -1 : resetUIMgr");
    jdField_b_of_type_Int = -1;
    SoftReference localSoftReference = (SoftReference)null;
    jdField_a_of_type_JavaLangRefSoftReference = localSoftReference;
    c = localSoftReference;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoyAd.ad.super_mask.mgr.SuperMaskUIMgr
 * JD-Core Version:    0.7.0.1
 */