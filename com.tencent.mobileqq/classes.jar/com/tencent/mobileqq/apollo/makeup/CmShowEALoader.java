package com.tencent.mobileqq.apollo.makeup;

import android.content.Context;
import com.tencent.mobileqq.apollo.utils.task.BaseTask;
import com.tencent.mobileqq.apollo.utils.task.TaskFlowEngine;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/apollo/makeup/CmShowEALoader;", "Lcom/tencent/mobileqq/apollo/utils/task/TaskFlowEngine;", "uin", "", "(Ljava/lang/String;)V", "aEKitEssentialResDownloadTask", "Lcom/tencent/mobileqq/apollo/makeup/CmShowEALoader$AEKitEssentialResDownloadTask;", "getAEKitEssentialResDownloadTask", "()Lcom/tencent/mobileqq/apollo/makeup/CmShowEALoader$AEKitEssentialResDownloadTask;", "setAEKitEssentialResDownloadTask", "(Lcom/tencent/mobileqq/apollo/makeup/CmShowEALoader$AEKitEssentialResDownloadTask;)V", "aEKitResDownloadTask", "Lcom/tencent/mobileqq/apollo/makeup/CmShowEALoader$AEKitResDownloadTask;", "getAEKitResDownloadTask", "()Lcom/tencent/mobileqq/apollo/makeup/CmShowEALoader$AEKitResDownloadTask;", "setAEKitResDownloadTask", "(Lcom/tencent/mobileqq/apollo/makeup/CmShowEALoader$AEKitResDownloadTask;)V", "cmShowResDownloadTask", "Lcom/tencent/mobileqq/apollo/makeup/CmShowEALoader$CmShowResDownloadTask;", "getCmShowResDownloadTask", "()Lcom/tencent/mobileqq/apollo/makeup/CmShowEALoader$CmShowResDownloadTask;", "setCmShowResDownloadTask", "(Lcom/tencent/mobileqq/apollo/makeup/CmShowEALoader$CmShowResDownloadTask;)V", "initAEEngineTask", "Lcom/tencent/mobileqq/apollo/makeup/CmShowEALoader$InitAEEngineTask;", "getInitAEEngineTask", "()Lcom/tencent/mobileqq/apollo/makeup/CmShowEALoader$InitAEEngineTask;", "setInitAEEngineTask", "(Lcom/tencent/mobileqq/apollo/makeup/CmShowEALoader$InitAEEngineTask;)V", "initListener", "Lcom/tencent/mobileqq/apollo/makeup/CmShowEALoader$InitListener;", "getInitListener", "()Lcom/tencent/mobileqq/apollo/makeup/CmShowEALoader$InitListener;", "setInitListener", "(Lcom/tencent/mobileqq/apollo/makeup/CmShowEALoader$InitListener;)V", "result", "Lcom/tencent/mobileqq/apollo/makeup/CmShowEALoader$InitResult;", "getResult", "()Lcom/tencent/mobileqq/apollo/makeup/CmShowEALoader$InitResult;", "setResult", "(Lcom/tencent/mobileqq/apollo/makeup/CmShowEALoader$InitResult;)V", "initEngine", "", "context", "Landroid/content/Context;", "notifyComplete", "step", "", "errorCode", "onTaskDone", "task", "Lcom/tencent/mobileqq/apollo/utils/task/BaseTask;", "AEKitEssentialResDownloadTask", "AEKitResDownloadTask", "CmShowResDownloadTask", "Companion", "InitAEEngineTask", "InitListener", "InitResult", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
public final class CmShowEALoader
  extends TaskFlowEngine
{
  public static final CmShowEALoader.Companion a;
  @NotNull
  private static final String b = "CmShowEALoader";
  @NotNull
  public CmShowEALoader.AEKitEssentialResDownloadTask a;
  @NotNull
  public CmShowEALoader.AEKitResDownloadTask a;
  @NotNull
  public CmShowEALoader.CmShowResDownloadTask a;
  @NotNull
  public CmShowEALoader.InitAEEngineTask a;
  @NotNull
  public CmShowEALoader.InitListener a;
  @NotNull
  private CmShowEALoader.InitResult jdField_a_of_type_ComTencentMobileqqApolloMakeupCmShowEALoader$InitResult = new CmShowEALoader.InitResult();
  private final String jdField_a_of_type_JavaLangString;
  
  static
  {
    jdField_a_of_type_ComTencentMobileqqApolloMakeupCmShowEALoader$Companion = new CmShowEALoader.Companion(null);
  }
  
  public CmShowEALoader(@NotNull String paramString)
  {
    this.jdField_a_of_type_JavaLangString = paramString;
  }
  
  @NotNull
  public final CmShowEALoader.InitListener a()
  {
    CmShowEALoader.InitListener localInitListener = this.jdField_a_of_type_ComTencentMobileqqApolloMakeupCmShowEALoader$InitListener;
    if (localInitListener == null) {
      Intrinsics.throwUninitializedPropertyAccessException("initListener");
    }
    return localInitListener;
  }
  
  public final void a(@NotNull Context paramContext)
  {
    Intrinsics.checkParameterIsNotNull(paramContext, "context");
    this.jdField_a_of_type_ComTencentMobileqqApolloMakeupCmShowEALoader$AEKitResDownloadTask = new CmShowEALoader.AEKitResDownloadTask(paramContext);
    this.jdField_a_of_type_ComTencentMobileqqApolloMakeupCmShowEALoader$AEKitEssentialResDownloadTask = new CmShowEALoader.AEKitEssentialResDownloadTask(paramContext);
    this.jdField_a_of_type_ComTencentMobileqqApolloMakeupCmShowEALoader$InitAEEngineTask = new CmShowEALoader.InitAEEngineTask(paramContext);
    Object localObject1 = this.jdField_a_of_type_ComTencentMobileqqApolloMakeupCmShowEALoader$InitAEEngineTask;
    if (localObject1 == null) {
      Intrinsics.throwUninitializedPropertyAccessException("initAEEngineTask");
    }
    Object localObject2 = this.jdField_a_of_type_ComTencentMobileqqApolloMakeupCmShowEALoader$AEKitResDownloadTask;
    if (localObject2 == null) {
      Intrinsics.throwUninitializedPropertyAccessException("aEKitResDownloadTask");
    }
    ((CmShowEALoader.InitAEEngineTask)localObject1).a((BaseTask)localObject2);
    localObject1 = this.jdField_a_of_type_ComTencentMobileqqApolloMakeupCmShowEALoader$InitAEEngineTask;
    if (localObject1 == null) {
      Intrinsics.throwUninitializedPropertyAccessException("initAEEngineTask");
    }
    localObject2 = this.jdField_a_of_type_ComTencentMobileqqApolloMakeupCmShowEALoader$AEKitEssentialResDownloadTask;
    if (localObject2 == null) {
      Intrinsics.throwUninitializedPropertyAccessException("aEKitEssentialResDownloadTask");
    }
    ((CmShowEALoader.InitAEEngineTask)localObject1).a((BaseTask)localObject2);
    this.jdField_a_of_type_ComTencentMobileqqApolloMakeupCmShowEALoader$CmShowResDownloadTask = new CmShowEALoader.CmShowResDownloadTask(paramContext, this.jdField_a_of_type_JavaLangString);
    paramContext = this.jdField_a_of_type_ComTencentMobileqqApolloMakeupCmShowEALoader$InitAEEngineTask;
    if (paramContext == null) {
      Intrinsics.throwUninitializedPropertyAccessException("initAEEngineTask");
    }
    paramContext = (BaseTask)paramContext;
    localObject1 = this.jdField_a_of_type_ComTencentMobileqqApolloMakeupCmShowEALoader$CmShowResDownloadTask;
    if (localObject1 == null) {
      Intrinsics.throwUninitializedPropertyAccessException("cmShowResDownloadTask");
    }
    a(new BaseTask[] { paramContext, (BaseTask)localObject1 });
    a();
  }
  
  public final void a(@NotNull CmShowEALoader.InitListener paramInitListener)
  {
    Intrinsics.checkParameterIsNotNull(paramInitListener, "<set-?>");
    this.jdField_a_of_type_ComTencentMobileqqApolloMakeupCmShowEALoader$InitListener = paramInitListener;
  }
  
  public void a(@Nullable BaseTask paramBaseTask)
  {
    super.a(paramBaseTask);
    if ((paramBaseTask instanceof CmShowEALoader.CmShowResDownloadTask)) {
      if (((CmShowEALoader.CmShowResDownloadTask)paramBaseTask).b())
      {
        CmShowEALoader.InitResult localInitResult = this.jdField_a_of_type_ComTencentMobileqqApolloMakeupCmShowEALoader$InitResult;
        paramBaseTask = ((CmShowEALoader.CmShowResDownloadTask)paramBaseTask).a();
        if (paramBaseTask == null) {
          Intrinsics.throwNpe();
        }
        localInitResult.a(paramBaseTask);
        paramBaseTask = this.jdField_a_of_type_ComTencentMobileqqApolloMakeupCmShowEALoader$InitListener;
        if (paramBaseTask == null) {
          Intrinsics.throwUninitializedPropertyAccessException("initListener");
        }
        paramBaseTask.a(2, 0, this.jdField_a_of_type_ComTencentMobileqqApolloMakeupCmShowEALoader$InitResult);
      }
    }
    label166:
    do
    {
      do
      {
        do
        {
          return;
          i = paramBaseTask.a;
          if (a() != null) {
            a().a(2, i, null);
          }
          return;
          if (!(paramBaseTask instanceof CmShowEALoader.InitAEEngineTask)) {
            break label166;
          }
          if (!((CmShowEALoader.InitAEEngineTask)paramBaseTask).b()) {
            break;
          }
          paramBaseTask = this.jdField_a_of_type_ComTencentMobileqqApolloMakeupCmShowEALoader$InitResult;
        } while (a() == null);
        a().a(1, 0, paramBaseTask);
        return;
        int i = paramBaseTask.a;
        if (a() != null) {
          a().a(1, i, null);
        }
        return;
        if ((paramBaseTask instanceof CmShowEALoader.AEKitEssentialResDownloadTask))
        {
          if (((CmShowEALoader.AEKitEssentialResDownloadTask)paramBaseTask).b())
          {
            this.jdField_a_of_type_ComTencentMobileqqApolloMakeupCmShowEALoader$InitResult.a(((CmShowEALoader.AEKitEssentialResDownloadTask)paramBaseTask).a());
            return;
          }
          i = paramBaseTask.a;
          if (a() != null) {
            a().a(1, i, null);
          }
          return;
        }
      } while (!(paramBaseTask instanceof CmShowEALoader.AEKitResDownloadTask));
      if (!((CmShowEALoader.AEKitResDownloadTask)paramBaseTask).b()) {
        break;
      }
      paramBaseTask = this.jdField_a_of_type_ComTencentMobileqqApolloMakeupCmShowEALoader$InitResult;
    } while (a() == null);
    a().a(3, 0, paramBaseTask);
    return;
    paramBaseTask = this.jdField_a_of_type_ComTencentMobileqqApolloMakeupCmShowEALoader$InitResult;
    if (a() != null) {
      a().a(3, -5032, paramBaseTask);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.makeup.CmShowEALoader
 * JD-Core Version:    0.7.0.1
 */