import android.graphics.drawable.Drawable;
import com.tencent.mobileqq.vas.gldrawable.DynamicDrawable.build.1;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"com/tencent/mobileqq/vas/gldrawable/DynamicDrawable$build$1$1", "Lcom/tencent/mobileqq/vas/gldrawable/GLDrawableProxy$LoaderCallback;", "onFileDownloadFailed", "", "onFileDownloadStarted", "onFileDownloadSucceed", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
public final class bhbh
  implements bhbr
{
  public void a() {}
  
  public void b()
  {
    Drawable localDrawable = (Drawable)bhbg.a(this.a.this$0).invoke();
    if (localDrawable != null) {
      bhbg.a(this.a.this$0, localDrawable);
    }
    if (this.a.this$0.a() == null) {
      bhbg.a(this.a.this$0, (Drawable)bhbg.b(this.a.this$0).invoke());
    }
  }
  
  public void c()
  {
    if (this.a.this$0.a() == null) {
      bhbg.a(this.a.this$0, (Drawable)bhbg.b(this.a.this$0).invoke());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bhbh
 * JD-Core Version:    0.7.0.1
 */