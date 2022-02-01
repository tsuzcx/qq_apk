package com.tencent.biz.pubaccount.readinjoy.common;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import androidx.annotation.VisibleForTesting;
import com.tencent.biz.pubaccount.readinjoy.RIJChannelStayTimeMonitor;
import com.tencent.biz.pubaccount.readinjoy.ReadInJoyChannelViewPagerController;
import com.tencent.biz.pubaccount.readinjoy.decoupling.accesslayer.util.RIJThreadHandler;
import com.tencent.biz.pubaccount.readinjoy.decoupling.uilayer.framewrok.report.RIJKanDianTabReport;
import com.tencent.biz.pubaccount.readinjoy.decoupling.uilayer.push.RIJKanDianFolderStatus;
import com.tencent.biz.pubaccount.readinjoy.engine.KandianMergeManager;
import com.tencent.biz.pubaccount.readinjoy.engine.ReadInJoyLogicEngine;
import com.tencent.biz.pubaccount.readinjoy.engine.ReadInJoyLogicManager;
import com.tencent.biz.pubaccount.readinjoy.engine.ReadinjoySPEventReport.ForeBackGround;
import com.tencent.biz.pubaccount.readinjoy.engine.ReadinjoySPEventReport.ForeBackGroundCallback;
import com.tencent.biz.pubaccount.readinjoy.fragment.ReadInJoyBaseFragment;
import com.tencent.biz.pubaccount.readinjoy.gifvideo.utils.VideoAudioControlUtil;
import com.tencent.biz.pubaccount.readinjoy.model.RIJUGCAccountCreateModule;
import com.tencent.biz.pubaccount.readinjoy.model.RIJUGCAccountCreateModule.UGCAccountCreateCallback;
import com.tencent.biz.pubaccount.readinjoy.model.RIJUserLevelModule;
import com.tencent.biz.pubaccount.readinjoy.model.ReadInJoyUserInfoModule;
import com.tencent.biz.pubaccount.readinjoy.preload.util.FeedsPreloadHelper;
import com.tencent.biz.pubaccount.readinjoy.struct.KandianRedDotInfo.RedPntInfoForReport;
import com.tencent.biz.pubaccount.readinjoy.video.ReadInJoyWebDataManager;
import com.tencent.biz.pubaccount.readinjoy.video.VideoVolumeControl;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.loaders.StyleConfigHelper;
import com.tencent.biz.pubaccount.readinjoy.webarticle.RIJWebArticleUtil;
import com.tencent.biz.pubaccount.readinjoyAd.ad.common_ad_download.RIJAdDownloadCache;
import com.tencent.biz.pubaccount.readinjoyAd.ad.manager.ReadInjoyADExposureManager;
import com.tencent.biz.pubaccount.readinjoyAd.ad.materialdownload.AdMaterialResManager;
import com.tencent.biz.pubaccount.readinjoyAd.ad.super_mask.mgr.SuperMaskUIMgr;
import com.tencent.biz.pubaccount.readinjoyAd.ad.utils.ReadInJoyAdLog;
import com.tencent.biz.pubaccount.util.GifHelper;
import com.tencent.mobileqq.app.Frame;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.kandian.biz.publisher.api.IKanDianPublisher;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import cooperation.readinjoy.ReadInJoyHelper;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.JvmField;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import mqq.manager.Manager;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/biz/pubaccount/readinjoy/common/RIJTabFrameBase;", "Lcom/tencent/mobileqq/app/Frame;", "()V", "feedsOperation", "Lcom/tencent/biz/pubaccount/readinjoy/common/RIJTabFrameBase$FeedsOperation;", "getFeedsOperation", "()Lcom/tencent/biz/pubaccount/readinjoy/common/RIJTabFrameBase$FeedsOperation;", "foreBackgroundCallback", "Lcom/tencent/biz/pubaccount/readinjoy/engine/ReadinjoySPEventReport$ForeBackGroundCallback;", "lastEnterTime", "", "lastExitTime", "launchFrom", "", "preloadTask", "Lcom/tencent/biz/pubaccount/readinjoy/common/RIJTabFrameBase$PreloadTaskManager;", "clearCacheWhenLeave", "", "doForEnterTab", "doForLeaveTab", "doOnTabChange", "visible", "", "doReportWhenLeave", "getApp", "Lcom/tencent/mobileqq/app/QQAppInterface;", "getCurrentChannelId", "getCurrentFragement", "Lcom/tencent/biz/pubaccount/readinjoy/fragment/ReadInJoyBaseFragment;", "handleSchemaJump", "initForeBackgroundCallback", "markAccountCompleteAndShowToast", "needHideRedPoint", "kandianMergeManager", "Lcom/tencent/biz/pubaccount/readinjoy/engine/KandianMergeManager;", "notifyFragmentVisibilityChange", "onAccountChanged", "onActivityResult", "requestCode", "resultCode", "data", "Landroid/content/Intent;", "onCreate", "onDestroy", "onPostThemeChanged", "onRefreshDeliverBtn", "onResume", "tabChanged", "onStart", "onStop", "onTabChange", "isEnterTab", "onTabClickSelf", "requestAdInfo", "requestUgcAccountCreate", "resetStateWhenTabChange", "resetVideoStateWhenLeave", "setOperationFlag", "operationBitFlag", "setSuperMaskChannelId", "showTips", "delayTimeMs", "switchToChannel", "channelID", "switchToDefaultChannel", "ignoreChannelID", "Companion", "FeedsOperation", "KandianFrameStatus", "PreloadTaskManager", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
public abstract class RIJTabFrameBase
  extends Frame
{
  public static final RIJTabFrameBase.Companion a;
  private static boolean jdField_a_of_type_Boolean;
  @JvmField
  public int a;
  @JvmField
  public long a;
  @NotNull
  private final RIJTabFrameBase.FeedsOperation jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommonRIJTabFrameBase$FeedsOperation = new RIJTabFrameBase.FeedsOperation();
  private final RIJTabFrameBase.PreloadTaskManager jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommonRIJTabFrameBase$PreloadTaskManager = new RIJTabFrameBase.PreloadTaskManager();
  private ReadinjoySPEventReport.ForeBackGroundCallback jdField_a_of_type_ComTencentBizPubaccountReadinjoyEngineReadinjoySPEventReport$ForeBackGroundCallback;
  @JvmField
  public long b;
  
  static
  {
    jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommonRIJTabFrameBase$Companion = new RIJTabFrameBase.Companion(null);
  }
  
  public RIJTabFrameBase()
  {
    this.jdField_a_of_type_Int = 5;
  }
  
  private final void a(long paramLong)
  {
    RIJThreadHandler.b().postDelayed((Runnable)new RIJTabFrameBase.showTips.1(this), paramLong);
  }
  
  private final void b()
  {
    Object localObject = a();
    if (localObject != null) {}
    for (localObject = ((QBaseActivity)localObject).getIntent();; localObject = null)
    {
      if ((localObject != null) && (((Intent)localObject).hasExtra("arg_channel_cover_id")))
      {
        a(((Intent)localObject).getIntExtra("arg_channel_cover_id", 0));
        if (((Intent)localObject).getBooleanExtra("edit_video_jump_and_refresh", false))
        {
          ReadInJoyBaseFragment localReadInJoyBaseFragment = a();
          if (localReadInJoyBaseFragment != null) {
            localReadInJoyBaseFragment.f();
          }
        }
        ((Intent)localObject).removeExtra("arg_channel_cover_id");
      }
      return;
    }
  }
  
  private final void f(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommonRIJTabFrameBase$FeedsOperation.a();
      RIJThreadHandler.a(a());
    }
    Manager localManager = this.jdField_a_of_type_MqqAppAppRuntime.getManager(QQManagerFactory.KANDIAN_AD_EXPOSURE_MANAGER);
    if (localManager == null) {
      throw new TypeCastException("null cannot be cast to non-null type com.tencent.biz.pubaccount.readinjoyAd.ad.manager.ReadInjoyADExposureManager");
    }
    ((ReadInjoyADExposureManager)localManager).a((Activity)a());
  }
  
  private final void g(boolean paramBoolean)
  {
    ReadInJoyBaseFragment localReadInJoyBaseFragment = a();
    if (localReadInJoyBaseFragment != null)
    {
      if (paramBoolean)
      {
        ReadInJoyChannelViewPagerController.a(localReadInJoyBaseFragment.a(), 0);
        localReadInJoyBaseFragment.a(false, (Activity)a(), null);
      }
    }
    else {
      return;
    }
    localReadInJoyBaseFragment.g();
  }
  
  private final void m()
  {
    this.b = System.currentTimeMillis();
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommonRIJTabFrameBase$FeedsOperation.c();
    long l1 = NetConnInfoCenter.getServerTime();
    long l2 = RIJKanDianFolderStatus.a.jdField_a_of_type_Long;
    RIJKanDianTabReport.a(this.jdField_a_of_type_Int, l1 - l2, true, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommonRIJTabFrameBase$FeedsOperation.a(), a());
    GifHelper.a();
    FeedsPreloadHelper.a();
    VideoVolumeControl.a().a((Activity)a());
    ReadInJoyHelper.c(this.jdField_a_of_type_MqqAppAppRuntime);
    VideoAudioControlUtil.a.a(VideoAudioControlUtil.a.a(), "ENTER_KD_TAB");
  }
  
  private final void o()
  {
    this.jdField_a_of_type_Long = System.currentTimeMillis();
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommonRIJTabFrameBase$FeedsOperation.b();
    RIJKanDianFolderStatus.a(a());
    GifHelper.b();
    Object localObject = a();
    if (localObject != null)
    {
      localObject = ((QBaseActivity)localObject).getIntent();
      if (localObject != null) {
        ((Intent)localObject).removeExtra("launch_from");
      }
    }
    p();
    q();
    s();
  }
  
  private final void p()
  {
    VideoAudioControlUtil.a.a(VideoAudioControlUtil.a.a(), "LEAVE_KD_TAB");
    VideoVolumeControl.a().b((Activity)a());
    VideoVolumeControl.a().a(false, "readInjoy doOnPause");
  }
  
  private final void q()
  {
    ReadInJoyWebDataManager.a();
    ReadInJoyWebDataManager.a().b();
    ReadInJoyUtils.b();
    ReadInJoyDisplayUtils.a();
    Object localObject = this.jdField_a_of_type_MqqAppAppRuntime;
    if (localObject != null)
    {
      localObject = ((AppRuntime)localObject).getManager(QQManagerFactory.READINJOY_LOGIC_MANAGER);
      localObject = (ReadInJoyLogicManager)localObject;
      if (localObject != null)
      {
        localObject = ((ReadInJoyLogicManager)localObject).a();
        if (localObject != null)
        {
          localObject = ((ReadInJoyLogicEngine)localObject).a();
          if (localObject != null) {
            ((ReadInJoyUserInfoModule)localObject).b();
          }
        }
      }
      localObject = this.jdField_a_of_type_MqqAppAppRuntime;
      if (localObject == null) {
        break label100;
      }
    }
    label100:
    for (localObject = ((AppRuntime)localObject).getManager(QQManagerFactory.KANDIAN_MERGE_MANAGER);; localObject = null)
    {
      if (localObject != null) {
        break label105;
      }
      throw new TypeCastException("null cannot be cast to non-null type com.tencent.biz.pubaccount.readinjoy.engine.KandianMergeManager");
      localObject = null;
      break;
    }
    label105:
    localObject = (KandianMergeManager)localObject;
    if (localObject != null) {
      ((KandianMergeManager)localObject).p();
    }
    StyleConfigHelper.a().b();
  }
  
  private final void s()
  {
    VideoReport.traverseExposure();
    RIJKanDianTabReport.a(this.jdField_a_of_type_Int, this.b, false, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommonRIJTabFrameBase$FeedsOperation.a(), a());
    RIJKanDianTabReport.a(this.jdField_a_of_type_Long - this.b);
    ReadInJoyBaseFragment localReadInJoyBaseFragment = a();
    if (localReadInJoyBaseFragment != null) {
      localReadInJoyBaseFragment.i();
    }
  }
  
  private final void t()
  {
    if (!RIJWebArticleUtil.a.h())
    {
      QLog.i("RIJTabFrameBase", 1, "[initForeBackgroundCallback] switch is off");
      return;
    }
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyEngineReadinjoySPEventReport$ForeBackGroundCallback = ((ReadinjoySPEventReport.ForeBackGroundCallback)new RIJTabFrameBase.initForeBackgroundCallback.1(this));
    ReadinjoySPEventReport.ForeBackGround.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyEngineReadinjoySPEventReport$ForeBackGroundCallback);
  }
  
  public abstract void A_();
  
  public abstract void B_();
  
  public abstract int a();
  
  @NotNull
  public final RIJTabFrameBase.FeedsOperation a()
  {
    return this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommonRIJTabFrameBase$FeedsOperation;
  }
  
  @Nullable
  public abstract ReadInJoyBaseFragment a();
  
  @NotNull
  public final QQAppInterface a()
  {
    AppRuntime localAppRuntime = this.jdField_a_of_type_MqqAppAppRuntime;
    if (localAppRuntime == null) {
      throw new TypeCastException("null cannot be cast to non-null type com.tencent.mobileqq.app.QQAppInterface");
    }
    return (QQAppInterface)localAppRuntime;
  }
  
  public abstract void a(int paramInt);
  
  public void a(int paramInt1, int paramInt2, @Nullable Intent paramIntent)
  {
    super.a(paramInt1, paramInt2, paramIntent);
    ReadInJoyBaseFragment localReadInJoyBaseFragment = a();
    if (localReadInJoyBaseFragment != null) {
      localReadInJoyBaseFragment.onActivityResult(paramInt1, paramInt2, paramIntent);
    }
    if ((paramInt1 == 10000) && (paramInt2 == -1) && (paramIntent != null))
    {
      if (paramIntent.getBooleanExtra("key_ugc_account_create", false)) {
        i();
      }
    }
    else {
      return;
    }
    if (paramIntent.getBooleanExtra("key_ugc_account_edit", false))
    {
      j();
      return;
    }
    QLog.d("ReadInJoyTabFrame", 1, "ugc account create or edit profile canceled !");
  }
  
  public abstract void a(boolean paramBoolean);
  
  public abstract boolean a(@Nullable KandianMergeManager paramKandianMergeManager);
  
  public final void b(int paramInt)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommonRIJTabFrameBase$FeedsOperation.a(paramInt, a());
  }
  
  public void b(boolean paramBoolean)
  {
    super.b(paramBoolean);
    b();
    d(true);
  }
  
  public abstract void c();
  
  public final void c(boolean paramBoolean)
  {
    int j = 5;
    jdField_a_of_type_Boolean = paramBoolean;
    Object localObject1 = a();
    int i = j;
    if (localObject1 != null)
    {
      localObject1 = ((QBaseActivity)localObject1).getIntent();
      i = j;
      if (localObject1 != null) {
        i = ((Intent)localObject1).getIntExtra("launch_from", 5);
      }
    }
    this.jdField_a_of_type_Int = i;
    QLog.d("RIJTabFrameBase", 1, "enterTab: " + paramBoolean + ", launchFrom: " + this.jdField_a_of_type_Int);
    Object localObject2 = a();
    i = this.jdField_a_of_type_Int;
    localObject1 = a();
    if (localObject1 != null)
    {
      localObject1 = ((QBaseActivity)localObject1).getIntent();
      RIJKanDianTabReport.a((QQAppInterface)localObject2, paramBoolean, i, (Intent)localObject1);
      f(paramBoolean);
      a(paramBoolean);
      g(paramBoolean);
      localObject1 = (IKanDianPublisher)QRoute.api(IKanDianPublisher.class);
      localObject2 = BaseApplication.context;
      Intrinsics.checkExpressionValueIsNotNull(localObject2, "BaseApplication.context");
      ((IKanDianPublisher)localObject1).init((Context)localObject2);
      if (!paramBoolean) {
        break label218;
      }
      m();
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommonRIJTabFrameBase$PreloadTaskManager.a(this, a());
    }
    for (;;)
    {
      RIJUserLevelModule.a().a(10, null);
      d(paramBoolean);
      return;
      localObject1 = null;
      break;
      label218:
      o();
    }
  }
  
  protected void d(boolean paramBoolean)
  {
    if (!paramBoolean)
    {
      SuperMaskUIMgr.a.b(-1);
      ReadInJoyAdLog.a("ReadInJoySuperMaskAd", "setSuperMaskChannelId -1 : visible = " + paramBoolean);
      return;
    }
    ReadInJoyBaseFragment localReadInJoyBaseFragment = a();
    if (localReadInJoyBaseFragment != null)
    {
      SuperMaskUIMgr.a.b(localReadInJoyBaseFragment.a());
      ReadInJoyAdLog.a("ReadInJoySuperMaskAd", "setSuperMaskChannelId " + localReadInJoyBaseFragment.a() + " : visible = " + paramBoolean);
      return;
    }
    SuperMaskUIMgr.a.b(-1);
    ReadInJoyAdLog.a("ReadInJoySuperMaskAd", "setSuperMaskChannelId -1 : visible = " + paramBoolean);
  }
  
  public void e()
  {
    super.e();
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommonRIJTabFrameBase$FeedsOperation.c();
  }
  
  public void f()
  {
    super.f();
    VideoReport.addToDetectionWhitelist((Activity)a());
    VideoReport.ignorePageInOutEvent(a(), true);
    t();
    g();
  }
  
  public final void g()
  {
    try
    {
      AdMaterialResManager.a(a()).b();
      return;
    }
    catch (Throwable localThrowable)
    {
      QLog.d("RIJTabFrameBase", 1, "requestAdInfo error! e = " + localThrowable);
    }
  }
  
  public void h()
  {
    super.h();
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommonRIJTabFrameBase$FeedsOperation.b();
    VideoVolumeControl.a().a(false, "readInjoy onStop");
  }
  
  @VisibleForTesting
  public final void i()
  {
    Object localObject = ReadInJoyLogicEngine.a();
    Intrinsics.checkExpressionValueIsNotNull(localObject, "ReadInJoyLogicEngine.getInstance()");
    localObject = ((ReadInJoyLogicEngine)localObject).a();
    if (localObject != null) {
      ((RIJUGCAccountCreateModule)localObject).a(ReadInJoyUtils.a(), (RIJUGCAccountCreateModule.UGCAccountCreateCallback)new RIJTabFrameBase.requestUgcAccountCreate.1(this));
    }
  }
  
  @VisibleForTesting
  public final void j()
  {
    ReadInJoyHelper.h();
    RIJThreadHandler.b().post((Runnable)new RIJTabFrameBase.markAccountCompleteAndShowToast.1(this));
    a(2500L);
  }
  
  public void k()
  {
    super.k();
    jdField_a_of_type_Boolean = false;
    ReadinjoySPEventReport.ForeBackGroundCallback localForeBackGroundCallback = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyEngineReadinjoySPEventReport$ForeBackGroundCallback;
    if (localForeBackGroundCallback != null) {
      ReadinjoySPEventReport.ForeBackGround.b(localForeBackGroundCallback);
    }
    RIJAdDownloadCache.a.a();
  }
  
  public void l()
  {
    super.l();
    RIJChannelStayTimeMonitor.a.c();
    g();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.common.RIJTabFrameBase
 * JD-Core Version:    0.7.0.1
 */