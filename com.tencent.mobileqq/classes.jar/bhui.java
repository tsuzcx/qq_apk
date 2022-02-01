import android.os.Looper;
import android.view.View;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.vas.ui.VasPagView;
import com.tencent.mobileqq.vas.ui.VasPagView.MyViewProxy.onCurrentObjectChanged.1;
import com.tencent.mobileqq.vas.ui.VasPagView.MyViewProxy.onPostLoaderTask.1;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/vas/ui/VasPagView$MyViewProxy;", "Lcom/tencent/mobileqq/vas/ui/AbsAsyncLoadProxy;", "Landroid/view/View;", "container", "Lcom/tencent/mobileqq/vas/ui/VasPagView;", "(Lcom/tencent/mobileqq/vas/ui/VasPagView;)V", "getContainer", "()Lcom/tencent/mobileqq/vas/ui/VasPagView;", "onCurrentObjectChanged", "", "onPostLoaderTask", "block", "Lkotlin/Function0;", "update", "view", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
public final class bhui
  extends bhtx<View>
{
  @NotNull
  private final VasPagView a;
  
  public bhui(@NotNull VasPagView paramVasPagView)
  {
    this.a = paramVasPagView;
  }
  
  private final void a(View paramView)
  {
    if (paramView == null)
    {
      this.a.removeAllViews();
      return;
    }
    this.a.removeAllViews();
    this.a.addView(paramView);
    this.a.a().invoke(paramView);
  }
  
  protected void a()
  {
    this.a.setCurrentView((View)a());
    if (Intrinsics.areEqual(Looper.getMainLooper(), Looper.myLooper()))
    {
      a((View)a());
      return;
    }
    this.a.post((Runnable)new VasPagView.MyViewProxy.onCurrentObjectChanged.1(this));
  }
  
  protected void a(@NotNull Function0<Unit> paramFunction0)
  {
    Intrinsics.checkParameterIsNotNull(paramFunction0, "block");
    ThreadManagerV2.executeOnSubThread((Runnable)new VasPagView.MyViewProxy.onPostLoaderTask.1(paramFunction0));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bhui
 * JD-Core Version:    0.7.0.1
 */