import android.app.Application;
import android.arch.lifecycle.LifecycleOwner;
import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProvider;
import android.arch.lifecycle.ViewModelProvider.AndroidViewModelFactory;
import android.arch.lifecycle.ViewModelProvider.Factory;
import android.arch.lifecycle.ViewModelStoreOwner;
import com.tencent.common.app.BaseApplicationImpl;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"ofViewModelProvider", "Landroid/arch/lifecycle/ViewModelProvider;", "owner", "Landroid/arch/lifecycle/ViewModelStoreOwner;", "observe", "", "T", "Landroid/arch/lifecycle/LifecycleOwner;", "liveData", "Landroid/arch/lifecycle/LiveData;", "observer", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "t", "AQQLiteApp_release"}, k=2, mv={1, 1, 16})
public final class axbe
{
  @NotNull
  public static final ViewModelProvider a(@NotNull ViewModelStoreOwner paramViewModelStoreOwner)
  {
    Intrinsics.checkParameterIsNotNull(paramViewModelStoreOwner, "owner");
    ViewModelProvider.AndroidViewModelFactory localAndroidViewModelFactory = ViewModelProvider.AndroidViewModelFactory.getInstance((Application)BaseApplicationImpl.getApplication());
    Intrinsics.checkExpressionValueIsNotNull(localAndroidViewModelFactory, "ViewModelProvider.Androi…ionImpl.getApplication())");
    return new ViewModelProvider(paramViewModelStoreOwner.getViewModelStore(), (ViewModelProvider.Factory)localAndroidViewModelFactory);
  }
  
  public static final <T> void a(@NotNull LifecycleOwner paramLifecycleOwner, @NotNull LiveData<T> paramLiveData, @NotNull Function1<? super T, Unit> paramFunction1)
  {
    Intrinsics.checkParameterIsNotNull(paramLifecycleOwner, "$this$observe");
    Intrinsics.checkParameterIsNotNull(paramLiveData, "liveData");
    Intrinsics.checkParameterIsNotNull(paramFunction1, "observer");
    paramLiveData.observe(paramLifecycleOwner, (Observer)new axbf(paramFunction1));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     axbe
 * JD-Core Version:    0.7.0.1
 */