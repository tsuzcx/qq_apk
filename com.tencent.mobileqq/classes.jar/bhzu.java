import android.view.View;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.transfile.URLDrawableHelper.Adapter;
import java.lang.ref.WeakReference;

public class bhzu
  extends URLDrawableHelper.Adapter
{
  private WeakReference<View> a;
  
  public bhzu(View paramView)
  {
    this.a = new WeakReference(paramView);
  }
  
  public static void a(URLDrawable paramURLDrawable, View paramView)
  {
    if (paramURLDrawable.getStatus() != 1) {
      paramURLDrawable.setURLDrawableListener(new bhzu(paramView));
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bhzu
 * JD-Core Version:    0.7.0.1
 */