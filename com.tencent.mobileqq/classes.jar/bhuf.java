import com.tencent.mobileqq.vas.ui.VasPagView.MyLoader.syncLoad..inlined.synchronized.lambda.1;
import com.tencent.ttpic.openapi.initializer.PagInitializer;
import com.tencent.ttpic.openapi.manager.FeatureManager.Features;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/vas/ui/VasPagView$MyLoader;", "Lcom/tencent/mobileqq/vas/ui/AbsAsyncLoadProxy$Loader;", "()V", "isLoad", "", "isLoading", "loaderListener", "Ljava/util/ArrayList;", "Lcom/tencent/mobileqq/vas/ui/AbsAsyncLoadProxy$LoaderCallback;", "Lkotlin/collections/ArrayList;", "needLoad", "doLoad", "", "block", "Lkotlin/Function0;", "doLoad$AQQLiteApp_release", "isLoaded", "notifyListener", "onDownloadFinished", "syncLoad", "callback", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
public final class bhuf
  implements bhty
{
  private final ArrayList<bhtz> jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  private boolean jdField_a_of_type_Boolean;
  private boolean b;
  private boolean c;
  
  private final void a()
  {
    if (this.jdField_a_of_type_JavaUtilArrayList.isEmpty()) {
      return;
    }
    Iterator localIterator = ((Iterable)this.jdField_a_of_type_JavaUtilArrayList).iterator();
    while (localIterator.hasNext()) {
      ((bhtz)localIterator.next()).a();
    }
    this.jdField_a_of_type_JavaUtilArrayList.clear();
  }
  
  public void a(@NotNull bhtz parambhtz)
  {
    Intrinsics.checkParameterIsNotNull(parambhtz, "callback");
    this.c = true;
    synchronized (this.jdField_a_of_type_JavaUtilArrayList)
    {
      if (this.jdField_a_of_type_Boolean)
      {
        parambhtz.a();
        a();
        return;
      }
      this.jdField_a_of_type_JavaUtilArrayList.add(parambhtz);
      if (this.b)
      {
        parambhtz = Unit.INSTANCE;
        return;
      }
      this.b = true;
      a((Function0)new VasPagView.MyLoader.syncLoad..inlined.synchronized.lambda.1(this, parambhtz));
    }
  }
  
  public final void a(@NotNull Function0<Unit> paramFunction0)
  {
    Intrinsics.checkParameterIsNotNull(paramFunction0, "block");
    try
    {
      if (!FeatureManager.Features.PAG.init())
      {
        bnku.a().a(bnkt.b, (bnkw)new bhug(this, paramFunction0), false);
        return;
      }
      paramFunction0.invoke();
      this.b = false;
      return;
    }
    catch (Exception paramFunction0) {}
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_Boolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bhuf
 * JD-Core Version:    0.7.0.1
 */