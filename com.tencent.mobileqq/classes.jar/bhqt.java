import android.graphics.drawable.Drawable;
import java.lang.ref.WeakReference;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/vas/gldrawable/DynamicDrawable$MyLoaderCallback;", "Lcom/tencent/mobileqq/vas/gldrawable/GLDrawableProxy$LoaderCallback;", "drawableRef", "Ljava/lang/ref/WeakReference;", "Lcom/tencent/mobileqq/vas/gldrawable/DynamicDrawable;", "(Ljava/lang/ref/WeakReference;)V", "getDrawableRef", "()Ljava/lang/ref/WeakReference;", "onLoadFailed", "", "onLoadSucceed", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
public final class bhqt
  implements bhrh
{
  @NotNull
  private final WeakReference<bhqs> a;
  
  public bhqt(@NotNull WeakReference<bhqs> paramWeakReference)
  {
    this.a = paramWeakReference;
  }
  
  public void a()
  {
    bhqs localbhqs = (bhqs)this.a.get();
    if (localbhqs != null)
    {
      Drawable localDrawable = (Drawable)bhqs.a(localbhqs).invoke();
      if (localDrawable != null) {
        bhqs.a(localbhqs, localDrawable);
      }
      if (localbhqs.a() == null) {
        bhqs.a(localbhqs, (Drawable)bhqs.b(localbhqs).invoke());
      }
    }
  }
  
  public void b()
  {
    bhqs localbhqs = (bhqs)this.a.get();
    if ((localbhqs != null) && (localbhqs.a() == null)) {
      bhqs.a(localbhqs, (Drawable)bhqs.b(localbhqs).invoke());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bhqt
 * JD-Core Version:    0.7.0.1
 */