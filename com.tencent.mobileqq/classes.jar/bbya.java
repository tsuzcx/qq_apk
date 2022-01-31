import android.view.View;
import com.tencent.image.URLDrawable;
import java.lang.ref.WeakReference;

public class bbya
  extends aywn
{
  private WeakReference<View> a;
  
  public bbya(View paramView)
  {
    this.a = new WeakReference(paramView);
  }
  
  public static void a(URLDrawable paramURLDrawable, View paramView)
  {
    if (paramURLDrawable.getStatus() != 1) {
      paramURLDrawable.setURLDrawableListener(new bbya(paramView));
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     bbya
 * JD-Core Version:    0.7.0.1
 */