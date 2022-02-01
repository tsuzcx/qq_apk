import com.tencent.mobileqq.vas.ui.AbsAsyncLoadProxy.build.1;
import com.tencent.mobileqq.vas.ui.AbsAsyncLoadProxy.failedBuilder.1;
import com.tencent.mobileqq.vas.ui.AbsAsyncLoadProxy.sucessedBuilder.1;
import java.lang.ref.WeakReference;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/vas/ui/AbsAsyncLoadProxy;", "T", "", "()V", "value", "currentObject", "getCurrentObject", "()Ljava/lang/Object;", "setCurrentObject", "(Ljava/lang/Object;)V", "Ljava/lang/Object;", "failedBuilder", "Lkotlin/Function0;", "getFailedBuilder", "()Lkotlin/jvm/functions/Function0;", "setFailedBuilder", "(Lkotlin/jvm/functions/Function0;)V", "sucessedBuilder", "getSucessedBuilder", "setSucessedBuilder", "build", "", "loader", "Lcom/tencent/mobileqq/vas/ui/AbsAsyncLoadProxy$Loader;", "doFailedBuilder", "doFailedBuilder$AQQLiteApp_release", "doSucessedBuilder", "doSucessedBuilder$AQQLiteApp_release", "loadAndRefresh", "onCurrentObjectChanged", "onLoadFailed", "onLoadSucceed", "onPostLoaderTask", "block", "Loader", "LoaderCallback", "MyLoaderCallback", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
public abstract class bhtx<T>
{
  @Nullable
  private T jdField_a_of_type_JavaLangObject;
  @NotNull
  private Function0<? extends T> jdField_a_of_type_KotlinJvmFunctionsFunction0 = (Function0)AbsAsyncLoadProxy.failedBuilder.1.INSTANCE;
  @NotNull
  private Function0<? extends T> b = (Function0)AbsAsyncLoadProxy.sucessedBuilder.1.INSTANCE;
  
  private final void a(T paramT)
  {
    if ((Intrinsics.areEqual(paramT, this.jdField_a_of_type_JavaLangObject) ^ true))
    {
      this.jdField_a_of_type_JavaLangObject = paramT;
      a();
    }
  }
  
  private final void b()
  {
    Object localObject = c();
    if (localObject != null) {
      a(localObject);
    }
    if (this.jdField_a_of_type_JavaLangObject == null) {
      a(b());
    }
  }
  
  private final void b(bhty parambhty)
  {
    bhua localbhua = new bhua(new WeakReference(this));
    if (!parambhty.a())
    {
      parambhty.a((bhtz)localbhua);
      return;
    }
    localbhua.a();
  }
  
  private final void c()
  {
    if (this.jdField_a_of_type_JavaLangObject == null) {
      a(b());
    }
  }
  
  @Nullable
  public final T a()
  {
    return this.jdField_a_of_type_JavaLangObject;
  }
  
  protected abstract void a();
  
  public final void a(@NotNull bhty parambhty)
  {
    Intrinsics.checkParameterIsNotNull(parambhty, "loader");
    if (!parambhty.a()) {
      c();
    }
    if (parambhty.a())
    {
      b(parambhty);
      return;
    }
    a((Function0)new AbsAsyncLoadProxy.build.1(this, parambhty));
  }
  
  protected abstract void a(@NotNull Function0<Unit> paramFunction0);
  
  @Nullable
  public final T b()
  {
    try
    {
      Object localObject = this.jdField_a_of_type_KotlinJvmFunctionsFunction0.invoke();
      return localObject;
    }
    catch (Throwable localThrowable) {}
    return null;
  }
  
  public final void b(@NotNull Function0<? extends T> paramFunction0)
  {
    Intrinsics.checkParameterIsNotNull(paramFunction0, "<set-?>");
    this.jdField_a_of_type_KotlinJvmFunctionsFunction0 = paramFunction0;
  }
  
  @Nullable
  public final T c()
  {
    try
    {
      Object localObject = this.b.invoke();
      return localObject;
    }
    catch (Throwable localThrowable) {}
    return null;
  }
  
  public final void c(@NotNull Function0<? extends T> paramFunction0)
  {
    Intrinsics.checkParameterIsNotNull(paramFunction0, "<set-?>");
    this.b = paramFunction0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bhtx
 * JD-Core Version:    0.7.0.1
 */