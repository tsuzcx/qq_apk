import java.lang.ref.WeakReference;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/vas/ui/AbsAsyncLoadProxy$MyLoaderCallback;", "Lcom/tencent/mobileqq/vas/ui/AbsAsyncLoadProxy$LoaderCallback;", "drawableRef", "Ljava/lang/ref/WeakReference;", "Lcom/tencent/mobileqq/vas/ui/AbsAsyncLoadProxy;", "(Ljava/lang/ref/WeakReference;)V", "getDrawableRef", "()Ljava/lang/ref/WeakReference;", "onLoadFailed", "", "onLoadSucceed", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
final class bhua
  implements bhtz
{
  @NotNull
  private final WeakReference<bhtx<?>> a;
  
  public bhua(@NotNull WeakReference<bhtx<?>> paramWeakReference)
  {
    this.a = paramWeakReference;
  }
  
  public void a()
  {
    bhtx localbhtx = (bhtx)this.a.get();
    if (localbhtx != null) {
      bhtx.a(localbhtx);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bhua
 * JD-Core Version:    0.7.0.1
 */