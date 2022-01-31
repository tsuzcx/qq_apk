import android.view.View;
import com.tencent.image.URLDrawable;
import java.lang.ref.WeakReference;

public class bdxb
  extends baum
{
  private WeakReference<View> a;
  
  public bdxb(View paramView)
  {
    this.a = new WeakReference(paramView);
  }
  
  public static void a(URLDrawable paramURLDrawable, View paramView)
  {
    if (paramURLDrawable.getStatus() != 1) {
      paramURLDrawable.setURLDrawableListener(new bdxb(paramView));
    }
  }
  
  public void onLoadSuccessed(URLDrawable paramURLDrawable)
  {
    paramURLDrawable = (View)this.a.get();
    if (paramURLDrawable != null) {
      paramURLDrawable.invalidate();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bdxb
 * JD-Core Version:    0.7.0.1
 */