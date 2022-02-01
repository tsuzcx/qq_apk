package com.tencent.mobileqq.apollo.makeup;

import android.content.Context;
import com.tencent.aelight.camera.cmsshow.api.CmShowAssetsData;
import com.tencent.mobileqq.apollo.utils.task.BaseTask;
import com.tencent.mobileqq.apollo.utils.task.TaskFlowEngine;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/apollo/makeup/CmShowCrossEngineLoader;", "Lcom/tencent/mobileqq/apollo/utils/task/TaskFlowEngine;", "uin", "", "(Ljava/lang/String;)V", "aEKitEssentialResDownloadTask", "Lcom/tencent/mobileqq/apollo/makeup/CmShowCrossEngineLoader$AEKitEssentialResDownloadTask;", "getAEKitEssentialResDownloadTask", "()Lcom/tencent/mobileqq/apollo/makeup/CmShowCrossEngineLoader$AEKitEssentialResDownloadTask;", "setAEKitEssentialResDownloadTask", "(Lcom/tencent/mobileqq/apollo/makeup/CmShowCrossEngineLoader$AEKitEssentialResDownloadTask;)V", "aEKitResDownloadTask", "Lcom/tencent/mobileqq/apollo/makeup/CmShowCrossEngineLoader$AEKitResDownloadTask;", "getAEKitResDownloadTask", "()Lcom/tencent/mobileqq/apollo/makeup/CmShowCrossEngineLoader$AEKitResDownloadTask;", "setAEKitResDownloadTask", "(Lcom/tencent/mobileqq/apollo/makeup/CmShowCrossEngineLoader$AEKitResDownloadTask;)V", "cmShowResDownloadTask", "Lcom/tencent/mobileqq/apollo/makeup/CmShowCrossEngineLoader$CmShowResDownloadTask;", "getCmShowResDownloadTask", "()Lcom/tencent/mobileqq/apollo/makeup/CmShowCrossEngineLoader$CmShowResDownloadTask;", "setCmShowResDownloadTask", "(Lcom/tencent/mobileqq/apollo/makeup/CmShowCrossEngineLoader$CmShowResDownloadTask;)V", "downloadRoleTask", "Lcom/tencent/mobileqq/apollo/makeup/CmShowCrossEngineLoader$DownloadRoleTask;", "getDownloadRoleTask", "()Lcom/tencent/mobileqq/apollo/makeup/CmShowCrossEngineLoader$DownloadRoleTask;", "setDownloadRoleTask", "(Lcom/tencent/mobileqq/apollo/makeup/CmShowCrossEngineLoader$DownloadRoleTask;)V", "initAEEngineTask", "Lcom/tencent/mobileqq/apollo/makeup/CmShowCrossEngineLoader$InitAEEngineTask;", "getInitAEEngineTask", "()Lcom/tencent/mobileqq/apollo/makeup/CmShowCrossEngineLoader$InitAEEngineTask;", "setInitAEEngineTask", "(Lcom/tencent/mobileqq/apollo/makeup/CmShowCrossEngineLoader$InitAEEngineTask;)V", "initCEEngineTask", "Lcom/tencent/mobileqq/apollo/makeup/CmShowCrossEngineLoader$InitCEEngineTask;", "getInitCEEngineTask", "()Lcom/tencent/mobileqq/apollo/makeup/CmShowCrossEngineLoader$InitCEEngineTask;", "setInitCEEngineTask", "(Lcom/tencent/mobileqq/apollo/makeup/CmShowCrossEngineLoader$InitCEEngineTask;)V", "initListener", "Lcom/tencent/mobileqq/apollo/makeup/CmShowCrossEngineLoader$CEInitListener;", "getInitListener", "()Lcom/tencent/mobileqq/apollo/makeup/CmShowCrossEngineLoader$CEInitListener;", "setInitListener", "(Lcom/tencent/mobileqq/apollo/makeup/CmShowCrossEngineLoader$CEInitListener;)V", "result", "Lcom/tencent/mobileqq/apollo/makeup/CmShowCrossEngineLoader$CEInitResult;", "getResult", "()Lcom/tencent/mobileqq/apollo/makeup/CmShowCrossEngineLoader$CEInitResult;", "setResult", "(Lcom/tencent/mobileqq/apollo/makeup/CmShowCrossEngineLoader$CEInitResult;)V", "initEngine", "", "context", "Landroid/content/Context;", "notifyComplete", "step", "", "errorCode", "onTaskDone", "task", "Lcom/tencent/mobileqq/apollo/utils/task/BaseTask;", "AEKitEssentialResDownloadTask", "AEKitResDownloadTask", "CEInitListener", "CEInitResult", "CmShowResDownloadTask", "Companion", "DownloadRoleTask", "InitAEEngineTask", "InitCEEngineTask", "cmshow_impl_release"}, k=1, mv={1, 1, 16})
public final class CmShowCrossEngineLoader
  extends TaskFlowEngine
{
  public static final CmShowCrossEngineLoader.Companion h = new CmShowCrossEngineLoader.Companion(null);
  @NotNull
  private static final String k = "CmShowCrossEngineLoader";
  @NotNull
  public CmShowCrossEngineLoader.CEInitListener a;
  @NotNull
  public CmShowCrossEngineLoader.DownloadRoleTask b;
  @NotNull
  public CmShowCrossEngineLoader.InitCEEngineTask c;
  @NotNull
  public CmShowCrossEngineLoader.CmShowResDownloadTask d;
  @NotNull
  public CmShowCrossEngineLoader.InitAEEngineTask e;
  @NotNull
  public CmShowCrossEngineLoader.AEKitResDownloadTask f;
  @NotNull
  public CmShowCrossEngineLoader.AEKitEssentialResDownloadTask g;
  private final String i;
  @NotNull
  private CmShowCrossEngineLoader.CEInitResult j = new CmShowCrossEngineLoader.CEInitResult();
  
  public CmShowCrossEngineLoader(@NotNull String paramString)
  {
    this.i = paramString;
  }
  
  @NotNull
  public final CmShowCrossEngineLoader.CEInitListener a()
  {
    CmShowCrossEngineLoader.CEInitListener localCEInitListener = this.a;
    if (localCEInitListener == null) {
      Intrinsics.throwUninitializedPropertyAccessException("initListener");
    }
    return localCEInitListener;
  }
  
  public final void a(@NotNull Context paramContext)
  {
    Intrinsics.checkParameterIsNotNull(paramContext, "context");
    this.b = new CmShowCrossEngineLoader.DownloadRoleTask(paramContext);
    this.c = new CmShowCrossEngineLoader.InitCEEngineTask(paramContext);
    this.d = new CmShowCrossEngineLoader.CmShowResDownloadTask(paramContext, this.i);
    this.f = new CmShowCrossEngineLoader.AEKitResDownloadTask(paramContext);
    this.g = new CmShowCrossEngineLoader.AEKitEssentialResDownloadTask(paramContext);
    this.e = new CmShowCrossEngineLoader.InitAEEngineTask(paramContext);
    paramContext = this.e;
    if (paramContext == null) {
      Intrinsics.throwUninitializedPropertyAccessException("initAEEngineTask");
    }
    Object localObject1 = this.f;
    if (localObject1 == null) {
      Intrinsics.throwUninitializedPropertyAccessException("aEKitResDownloadTask");
    }
    paramContext.a((BaseTask)localObject1);
    paramContext = this.e;
    if (paramContext == null) {
      Intrinsics.throwUninitializedPropertyAccessException("initAEEngineTask");
    }
    localObject1 = this.g;
    if (localObject1 == null) {
      Intrinsics.throwUninitializedPropertyAccessException("aEKitEssentialResDownloadTask");
    }
    paramContext.a((BaseTask)localObject1);
    paramContext = this.b;
    if (paramContext == null) {
      Intrinsics.throwUninitializedPropertyAccessException("downloadRoleTask");
    }
    paramContext = (BaseTask)paramContext;
    localObject1 = this.c;
    if (localObject1 == null) {
      Intrinsics.throwUninitializedPropertyAccessException("initCEEngineTask");
    }
    localObject1 = (BaseTask)localObject1;
    Object localObject2 = this.d;
    if (localObject2 == null) {
      Intrinsics.throwUninitializedPropertyAccessException("cmShowResDownloadTask");
    }
    localObject2 = (BaseTask)localObject2;
    CmShowCrossEngineLoader.InitAEEngineTask localInitAEEngineTask = this.e;
    if (localInitAEEngineTask == null) {
      Intrinsics.throwUninitializedPropertyAccessException("initAEEngineTask");
    }
    a(new BaseTask[] { paramContext, localObject1, localObject2, (BaseTask)localInitAEEngineTask });
    c();
  }
  
  public final void a(@NotNull CmShowCrossEngineLoader.CEInitListener paramCEInitListener)
  {
    Intrinsics.checkParameterIsNotNull(paramCEInitListener, "<set-?>");
    this.a = paramCEInitListener;
  }
  
  public void a(@Nullable BaseTask paramBaseTask)
  {
    super.a(paramBaseTask);
    if ((paramBaseTask instanceof CmShowCrossEngineLoader.DownloadRoleTask))
    {
      if (((CmShowCrossEngineLoader.DownloadRoleTask)paramBaseTask).h())
      {
        if (a() != null) {
          a().a(3, 0, null);
        }
      }
      else if (a() != null) {
        a().a(3, -5031, null);
      }
    }
    else
    {
      int m;
      if ((paramBaseTask instanceof CmShowCrossEngineLoader.CmShowResDownloadTask))
      {
        Object localObject = (CmShowCrossEngineLoader.CmShowResDownloadTask)paramBaseTask;
        if (((CmShowCrossEngineLoader.CmShowResDownloadTask)localObject).h())
        {
          paramBaseTask = this.j;
          localObject = ((CmShowCrossEngineLoader.CmShowResDownloadTask)localObject).b();
          if (localObject == null) {
            Intrinsics.throwNpe();
          }
          paramBaseTask.a((CmShowAssetsData)localObject);
          paramBaseTask = this.a;
          if (paramBaseTask == null) {
            Intrinsics.throwUninitializedPropertyAccessException("initListener");
          }
          paramBaseTask.a(2, 0, this.j);
          return;
        }
        m = paramBaseTask.e;
        if (a() != null) {
          a().a(2, m, null);
        }
      }
      else if ((paramBaseTask instanceof CmShowCrossEngineLoader.InitCEEngineTask))
      {
        if (((CmShowCrossEngineLoader.InitCEEngineTask)paramBaseTask).h())
        {
          paramBaseTask = this.j;
          if (a() != null) {
            a().a(1, 0, paramBaseTask);
          }
        }
        else
        {
          m = paramBaseTask.e;
          if (a() != null) {
            a().a(1, m, null);
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.makeup.CmShowCrossEngineLoader
 * JD-Core Version:    0.7.0.1
 */