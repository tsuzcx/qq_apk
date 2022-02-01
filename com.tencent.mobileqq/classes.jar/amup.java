import android.content.Context;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/apollo/makeup/CmShowEALoader;", "Lcom/tencent/mobileqq/apollo/utils/task/TaskFlowEngine;", "uin", "", "(Ljava/lang/String;)V", "aEKitEssentialResDownloadTask", "Lcom/tencent/mobileqq/apollo/makeup/CmShowEALoader$AEKitEssentialResDownloadTask;", "getAEKitEssentialResDownloadTask", "()Lcom/tencent/mobileqq/apollo/makeup/CmShowEALoader$AEKitEssentialResDownloadTask;", "setAEKitEssentialResDownloadTask", "(Lcom/tencent/mobileqq/apollo/makeup/CmShowEALoader$AEKitEssentialResDownloadTask;)V", "aEKitResDownloadTask", "Lcom/tencent/mobileqq/apollo/makeup/CmShowEALoader$AEKitResDownloadTask;", "getAEKitResDownloadTask", "()Lcom/tencent/mobileqq/apollo/makeup/CmShowEALoader$AEKitResDownloadTask;", "setAEKitResDownloadTask", "(Lcom/tencent/mobileqq/apollo/makeup/CmShowEALoader$AEKitResDownloadTask;)V", "cmShowResDownloadTask", "Lcom/tencent/mobileqq/apollo/makeup/CmShowEALoader$CmShowResDownloadTask;", "getCmShowResDownloadTask", "()Lcom/tencent/mobileqq/apollo/makeup/CmShowEALoader$CmShowResDownloadTask;", "setCmShowResDownloadTask", "(Lcom/tencent/mobileqq/apollo/makeup/CmShowEALoader$CmShowResDownloadTask;)V", "initAEEngineTask", "Lcom/tencent/mobileqq/apollo/makeup/CmShowEALoader$InitAEEngineTask;", "getInitAEEngineTask", "()Lcom/tencent/mobileqq/apollo/makeup/CmShowEALoader$InitAEEngineTask;", "setInitAEEngineTask", "(Lcom/tencent/mobileqq/apollo/makeup/CmShowEALoader$InitAEEngineTask;)V", "initListener", "Lcom/tencent/mobileqq/apollo/makeup/CmShowEALoader$InitListener;", "getInitListener", "()Lcom/tencent/mobileqq/apollo/makeup/CmShowEALoader$InitListener;", "setInitListener", "(Lcom/tencent/mobileqq/apollo/makeup/CmShowEALoader$InitListener;)V", "result", "Lcom/tencent/mobileqq/apollo/makeup/CmShowEALoader$InitResult;", "getResult", "()Lcom/tencent/mobileqq/apollo/makeup/CmShowEALoader$InitResult;", "setResult", "(Lcom/tencent/mobileqq/apollo/makeup/CmShowEALoader$InitResult;)V", "initEngine", "", "context", "Landroid/content/Context;", "notifyComplete", "step", "", "errorCode", "onTaskDone", "task", "Lcom/tencent/mobileqq/apollo/utils/task/BaseTask;", "AEKitEssentialResDownloadTask", "AEKitResDownloadTask", "CmShowResDownloadTask", "Companion", "InitAEEngineTask", "InitListener", "InitResult", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
public final class amup
  extends anms
{
  public static final amuw a;
  @NotNull
  private static final String b = "CmShowEALoader";
  @NotNull
  public amuq a;
  @NotNull
  public amus a;
  @NotNull
  public amuu a;
  @NotNull
  public amux a;
  @NotNull
  public amuy a;
  @NotNull
  private amuz jdField_a_of_type_Amuz = new amuz();
  private final String jdField_a_of_type_JavaLangString;
  
  static
  {
    jdField_a_of_type_Amuw = new amuw(null);
  }
  
  public amup(@NotNull String paramString)
  {
    this.jdField_a_of_type_JavaLangString = paramString;
  }
  
  @NotNull
  public final amuy a()
  {
    amuy localamuy = this.jdField_a_of_type_Amuy;
    if (localamuy == null) {
      Intrinsics.throwUninitializedPropertyAccessException("initListener");
    }
    return localamuy;
  }
  
  public final void a(@NotNull amuy paramamuy)
  {
    Intrinsics.checkParameterIsNotNull(paramamuy, "<set-?>");
    this.jdField_a_of_type_Amuy = paramamuy;
  }
  
  public final void a(@NotNull Context paramContext)
  {
    Intrinsics.checkParameterIsNotNull(paramContext, "context");
    this.jdField_a_of_type_Amus = new amus(paramContext);
    this.jdField_a_of_type_Amuq = new amuq(paramContext);
    this.jdField_a_of_type_Amux = new amux(paramContext);
    Object localObject1 = this.jdField_a_of_type_Amux;
    if (localObject1 == null) {
      Intrinsics.throwUninitializedPropertyAccessException("initAEEngineTask");
    }
    Object localObject2 = this.jdField_a_of_type_Amus;
    if (localObject2 == null) {
      Intrinsics.throwUninitializedPropertyAccessException("aEKitResDownloadTask");
    }
    ((amux)localObject1).a((anmp)localObject2);
    localObject1 = this.jdField_a_of_type_Amux;
    if (localObject1 == null) {
      Intrinsics.throwUninitializedPropertyAccessException("initAEEngineTask");
    }
    localObject2 = this.jdField_a_of_type_Amuq;
    if (localObject2 == null) {
      Intrinsics.throwUninitializedPropertyAccessException("aEKitEssentialResDownloadTask");
    }
    ((amux)localObject1).a((anmp)localObject2);
    this.jdField_a_of_type_Amuu = new amuu(paramContext, this.jdField_a_of_type_JavaLangString);
    paramContext = this.jdField_a_of_type_Amux;
    if (paramContext == null) {
      Intrinsics.throwUninitializedPropertyAccessException("initAEEngineTask");
    }
    paramContext = (anmp)paramContext;
    localObject1 = this.jdField_a_of_type_Amuu;
    if (localObject1 == null) {
      Intrinsics.throwUninitializedPropertyAccessException("cmShowResDownloadTask");
    }
    a(new anmp[] { paramContext, (anmp)localObject1 });
    a();
  }
  
  public void a(@Nullable anmp paramanmp)
  {
    super.a(paramanmp);
    if ((paramanmp instanceof amuu)) {
      if (((amuu)paramanmp).b())
      {
        amuz localamuz = this.jdField_a_of_type_Amuz;
        paramanmp = ((amuu)paramanmp).a();
        if (paramanmp == null) {
          Intrinsics.throwNpe();
        }
        localamuz.a(paramanmp);
        paramanmp = this.jdField_a_of_type_Amuy;
        if (paramanmp == null) {
          Intrinsics.throwUninitializedPropertyAccessException("initListener");
        }
        paramanmp.a(2, 0, this.jdField_a_of_type_Amuz);
      }
    }
    label166:
    do
    {
      do
      {
        return;
        i = paramanmp.a;
        if (a() != null) {
          a().a(2, i, null);
        }
        return;
        if (!(paramanmp instanceof amux)) {
          break label166;
        }
        if (!((amux)paramanmp).b()) {
          break;
        }
        paramanmp = this.jdField_a_of_type_Amuz;
      } while (a() == null);
      a().a(1, 0, paramanmp);
      return;
      i = paramanmp.a;
      if (a() != null) {
        a().a(1, i, null);
      }
      return;
    } while (!(paramanmp instanceof amuq));
    if (((amuq)paramanmp).b())
    {
      this.jdField_a_of_type_Amuz.a(((amuq)paramanmp).a());
      return;
    }
    int i = paramanmp.a;
    if (a() != null) {
      a().a(1, i, null);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     amup
 * JD-Core Version:    0.7.0.1
 */