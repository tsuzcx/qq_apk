package com.tencent.mobileqq.apollo.makeup;

import android.content.Context;
import com.tencent.aelight.camera.cmsshow.api.CmShowAssetsData;
import com.tencent.mobileqq.apollo.utils.task.BaseTask;
import com.tencent.mobileqq.apollo.utils.task.TaskFlowEngine;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/apollo/makeup/CmShowEALoader;", "Lcom/tencent/mobileqq/apollo/utils/task/TaskFlowEngine;", "uin", "", "(Ljava/lang/String;)V", "aEKitEssentialResDownloadTask", "Lcom/tencent/mobileqq/apollo/makeup/CmShowEALoader$AEKitEssentialResDownloadTask;", "getAEKitEssentialResDownloadTask", "()Lcom/tencent/mobileqq/apollo/makeup/CmShowEALoader$AEKitEssentialResDownloadTask;", "setAEKitEssentialResDownloadTask", "(Lcom/tencent/mobileqq/apollo/makeup/CmShowEALoader$AEKitEssentialResDownloadTask;)V", "aEKitResDownloadTask", "Lcom/tencent/mobileqq/apollo/makeup/CmShowEALoader$AEKitResDownloadTask;", "getAEKitResDownloadTask", "()Lcom/tencent/mobileqq/apollo/makeup/CmShowEALoader$AEKitResDownloadTask;", "setAEKitResDownloadTask", "(Lcom/tencent/mobileqq/apollo/makeup/CmShowEALoader$AEKitResDownloadTask;)V", "cmShowResDownloadTask", "Lcom/tencent/mobileqq/apollo/makeup/CmShowEALoader$CmShowResDownloadTask;", "getCmShowResDownloadTask", "()Lcom/tencent/mobileqq/apollo/makeup/CmShowEALoader$CmShowResDownloadTask;", "setCmShowResDownloadTask", "(Lcom/tencent/mobileqq/apollo/makeup/CmShowEALoader$CmShowResDownloadTask;)V", "initAEEngineTask", "Lcom/tencent/mobileqq/apollo/makeup/CmShowEALoader$InitAEEngineTask;", "getInitAEEngineTask", "()Lcom/tencent/mobileqq/apollo/makeup/CmShowEALoader$InitAEEngineTask;", "setInitAEEngineTask", "(Lcom/tencent/mobileqq/apollo/makeup/CmShowEALoader$InitAEEngineTask;)V", "initListener", "Lcom/tencent/mobileqq/apollo/makeup/CmShowEALoader$InitListener;", "getInitListener", "()Lcom/tencent/mobileqq/apollo/makeup/CmShowEALoader$InitListener;", "setInitListener", "(Lcom/tencent/mobileqq/apollo/makeup/CmShowEALoader$InitListener;)V", "result", "Lcom/tencent/mobileqq/apollo/makeup/CmShowEALoader$InitResult;", "getResult", "()Lcom/tencent/mobileqq/apollo/makeup/CmShowEALoader$InitResult;", "setResult", "(Lcom/tencent/mobileqq/apollo/makeup/CmShowEALoader$InitResult;)V", "initEngine", "", "context", "Landroid/content/Context;", "notifyComplete", "step", "", "errorCode", "onTaskDone", "task", "Lcom/tencent/mobileqq/apollo/utils/task/BaseTask;", "AEKitEssentialResDownloadTask", "AEKitResDownloadTask", "CmShowResDownloadTask", "Companion", "InitAEEngineTask", "InitListener", "InitResult", "cmshow_impl_release"}, k=1, mv={1, 1, 16})
public final class CmShowEALoader
  extends TaskFlowEngine
{
  public static final CmShowEALoader.Companion f = new CmShowEALoader.Companion(null);
  @NotNull
  private static final String i = "CmShowEALoader";
  @NotNull
  public CmShowEALoader.InitListener a;
  @NotNull
  public CmShowEALoader.AEKitResDownloadTask b;
  @NotNull
  public CmShowEALoader.AEKitEssentialResDownloadTask c;
  @NotNull
  public CmShowEALoader.InitAEEngineTask d;
  @NotNull
  public CmShowEALoader.CmShowResDownloadTask e;
  private final String g;
  @NotNull
  private CmShowEALoader.InitResult h = new CmShowEALoader.InitResult();
  
  public CmShowEALoader(@NotNull String paramString)
  {
    this.g = paramString;
  }
  
  @NotNull
  public final CmShowEALoader.InitListener a()
  {
    CmShowEALoader.InitListener localInitListener = this.a;
    if (localInitListener == null) {
      Intrinsics.throwUninitializedPropertyAccessException("initListener");
    }
    return localInitListener;
  }
  
  public final void a(@NotNull Context paramContext)
  {
    Intrinsics.checkParameterIsNotNull(paramContext, "context");
    this.b = new CmShowEALoader.AEKitResDownloadTask(paramContext);
    this.c = new CmShowEALoader.AEKitEssentialResDownloadTask(paramContext);
    this.d = new CmShowEALoader.InitAEEngineTask(paramContext);
    Object localObject1 = this.d;
    if (localObject1 == null) {
      Intrinsics.throwUninitializedPropertyAccessException("initAEEngineTask");
    }
    Object localObject2 = this.b;
    if (localObject2 == null) {
      Intrinsics.throwUninitializedPropertyAccessException("aEKitResDownloadTask");
    }
    ((CmShowEALoader.InitAEEngineTask)localObject1).a((BaseTask)localObject2);
    localObject1 = this.d;
    if (localObject1 == null) {
      Intrinsics.throwUninitializedPropertyAccessException("initAEEngineTask");
    }
    localObject2 = this.c;
    if (localObject2 == null) {
      Intrinsics.throwUninitializedPropertyAccessException("aEKitEssentialResDownloadTask");
    }
    ((CmShowEALoader.InitAEEngineTask)localObject1).a((BaseTask)localObject2);
    this.e = new CmShowEALoader.CmShowResDownloadTask(paramContext, this.g);
    paramContext = this.d;
    if (paramContext == null) {
      Intrinsics.throwUninitializedPropertyAccessException("initAEEngineTask");
    }
    paramContext = (BaseTask)paramContext;
    localObject1 = this.e;
    if (localObject1 == null) {
      Intrinsics.throwUninitializedPropertyAccessException("cmShowResDownloadTask");
    }
    a(new BaseTask[] { paramContext, (BaseTask)localObject1 });
    c();
  }
  
  public final void a(@NotNull CmShowEALoader.InitListener paramInitListener)
  {
    Intrinsics.checkParameterIsNotNull(paramInitListener, "<set-?>");
    this.a = paramInitListener;
  }
  
  public void a(@Nullable BaseTask paramBaseTask)
  {
    super.a(paramBaseTask);
    Object localObject;
    int j;
    if ((paramBaseTask instanceof CmShowEALoader.CmShowResDownloadTask))
    {
      localObject = (CmShowEALoader.CmShowResDownloadTask)paramBaseTask;
      if (((CmShowEALoader.CmShowResDownloadTask)localObject).h())
      {
        paramBaseTask = this.h;
        localObject = ((CmShowEALoader.CmShowResDownloadTask)localObject).b();
        if (localObject == null) {
          Intrinsics.throwNpe();
        }
        paramBaseTask.a((CmShowAssetsData)localObject);
        paramBaseTask = this.a;
        if (paramBaseTask == null) {
          Intrinsics.throwUninitializedPropertyAccessException("initListener");
        }
        paramBaseTask.a(2, 0, this.h);
        return;
      }
      j = paramBaseTask.e;
      if (a() != null) {
        a().a(2, j, null);
      }
    }
    else if ((paramBaseTask instanceof CmShowEALoader.InitAEEngineTask))
    {
      if (((CmShowEALoader.InitAEEngineTask)paramBaseTask).h())
      {
        paramBaseTask = this.h;
        if (a() != null) {
          a().a(1, 0, paramBaseTask);
        }
      }
      else
      {
        j = paramBaseTask.e;
        if (a() != null) {
          a().a(1, j, null);
        }
      }
    }
    else if ((paramBaseTask instanceof CmShowEALoader.AEKitEssentialResDownloadTask))
    {
      localObject = (CmShowEALoader.AEKitEssentialResDownloadTask)paramBaseTask;
      if (((CmShowEALoader.AEKitEssentialResDownloadTask)localObject).h())
      {
        this.h.a(((CmShowEALoader.AEKitEssentialResDownloadTask)localObject).b());
        return;
      }
      j = paramBaseTask.e;
      if (a() != null) {
        a().a(1, j, null);
      }
    }
    else if ((paramBaseTask instanceof CmShowEALoader.AEKitResDownloadTask))
    {
      if (((CmShowEALoader.AEKitResDownloadTask)paramBaseTask).h())
      {
        paramBaseTask = this.h;
        if (a() != null) {
          a().a(3, 0, paramBaseTask);
        }
      }
      else
      {
        paramBaseTask = this.h;
        if (a() != null) {
          a().a(3, -5032, paramBaseTask);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.makeup.CmShowEALoader
 * JD-Core Version:    0.7.0.1
 */