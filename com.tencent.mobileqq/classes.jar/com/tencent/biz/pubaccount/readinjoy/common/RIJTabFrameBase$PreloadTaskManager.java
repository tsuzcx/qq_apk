package com.tencent.biz.pubaccount.readinjoy.common;

import com.tencent.biz.pubaccount.readinjoy.decoupling.uilayer.framewrok.util.RIJAladdinUtils;
import com.tencent.biz.pubaccount.readinjoy.engine.KandianMergeManager;
import com.tencent.biz.pubaccount.readinjoy.model.RIJUserLevelModule;
import com.tencent.biz.pubaccount.readinjoy.video.ReadInJoyWebDataManager;
import com.tencent.biz.pubaccount.readinjoy.view.ReadinjoyTabFrame.InitWebProcessRunnable;
import com.tencent.biz.pubaccount.readinjoyAd.ad.materialdownload.AdMaterialResManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.internal.Intrinsics;
import mqq.manager.Manager;
import mqq.os.MqqHandler;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/biz/pubaccount/readinjoy/common/RIJTabFrameBase$PreloadTaskManager;", "", "()V", "preLoadUnreadMsgBoxTime", "", "loadWebRenderSo", "", "preDownloadAdMaskRes", "app", "Lcom/tencent/mobileqq/app/QQAppInterface;", "preLoadMsgBoxIfNecessary", "preRequestUserLevelInfo", "preStartAchilles", "preloadAll", "tabFrameBase", "Lcom/tencent/biz/pubaccount/readinjoy/common/RIJTabFrameBase;", "preloadWebviewProcess", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
public final class RIJTabFrameBase$PreloadTaskManager
{
  private long a;
  
  private final void a()
  {
    ThreadManager.executeOnSubThread((Runnable)RIJTabFrameBase.PreloadTaskManager.loadWebRenderSo.1.a);
  }
  
  private final void a(QQAppInterface paramQQAppInterface)
  {
    Manager localManager = paramQQAppInterface.getManager(QQManagerFactory.KANDIAN_MERGE_MANAGER);
    if (localManager == null) {
      throw new TypeCastException("null cannot be cast to non-null type com.tencent.biz.pubaccount.readinjoy.engine.KandianMergeManager");
    }
    if ((((KandianMergeManager)localManager).i()) && (System.currentTimeMillis() - this.a > 180000L))
    {
      ReadInJoyWebDataManager.a().a(paramQQAppInterface.getCurrentAccountUin(), 1);
      this.a = System.currentTimeMillis();
    }
  }
  
  private final void b()
  {
    ThreadManager.getFileThreadHandler().postDelayed((Runnable)RIJTabFrameBase.PreloadTaskManager.preStartAchilles.1.a, 20000L);
  }
  
  private final void b(QQAppInterface paramQQAppInterface)
  {
    AdMaterialResManager.a(paramQQAppInterface);
  }
  
  private final void c()
  {
    RIJUserLevelModule.a().a();
  }
  
  public final void a(@NotNull RIJTabFrameBase paramRIJTabFrameBase)
  {
    Intrinsics.checkParameterIsNotNull(paramRIJTabFrameBase, "tabFrameBase");
    if (!RIJAladdinUtils.i()) {
      return;
    }
    ReadinjoyTabFrame.InitWebProcessRunnable localInitWebProcessRunnable = new ReadinjoyTabFrame.InitWebProcessRunnable();
    localInitWebProcessRunnable.a(paramRIJTabFrameBase);
    ThreadManager.executeOnSubThread((Runnable)localInitWebProcessRunnable);
  }
  
  public final void a(@NotNull RIJTabFrameBase paramRIJTabFrameBase, @NotNull QQAppInterface paramQQAppInterface)
  {
    Intrinsics.checkParameterIsNotNull(paramRIJTabFrameBase, "tabFrameBase");
    Intrinsics.checkParameterIsNotNull(paramQQAppInterface, "app");
    QLog.d("RIJTabFrameBase", 1, "start preload task");
    a();
    a(paramQQAppInterface);
    b();
    a(paramRIJTabFrameBase);
    c();
    b(paramQQAppInterface);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.common.RIJTabFrameBase.PreloadTaskManager
 * JD-Core Version:    0.7.0.1
 */