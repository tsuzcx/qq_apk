import android.graphics.drawable.Drawable;
import java.lang.ref.WeakReference;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/vas/gldrawable/DynamicDrawable$MyLoaderCallback;", "Lcom/tencent/mobileqq/vas/gldrawable/GLDrawableProxy$LoaderCallback;", "drawableRef", "Ljava/lang/ref/WeakReference;", "Lcom/tencent/mobileqq/vas/gldrawable/DynamicDrawable;", "(Ljava/lang/ref/WeakReference;)V", "getDrawableRef", "()Ljava/lang/ref/WeakReference;", "onLoadFailed", "", "onLoadSucceed", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
public final class bghy
  implements bgim
{
  @NotNull
  private final WeakReference<bghx> a;
  
  public bghy(@NotNull WeakReference<bghx> paramWeakReference)
  {
    this.a = paramWeakReference;
  }
  
  public void a()
  {
    bghx localbghx = (bghx)this.a.get();
    if (localbghx != null)
    {
      Drawable localDrawable = (Drawable)bghx.a(localbghx).invoke();
      if (localDrawable != null) {
        bghx.a(localbghx, localDrawable);
      }
      if (localbghx.a() == null) {
        bghx.a(localbghx, (Drawable)bghx.b(localbghx).invoke());
      }
    }
  }
  
  public void b()
  {
    bghx localbghx = (bghx)this.a.get();
    if ((localbghx != null) && (localbghx.a() == null)) {
      bghx.a(localbghx, (Drawable)bghx.b(localbghx).invoke());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bghy
 * JD-Core Version:    0.7.0.1
 */