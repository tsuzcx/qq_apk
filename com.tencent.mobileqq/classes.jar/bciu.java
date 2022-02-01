import android.view.View;
import android.view.View.OnLongClickListener;
import java.lang.ref.WeakReference;

class bciu
  implements View.OnLongClickListener
{
  bciu(bcit parambcit) {}
  
  public boolean onLongClick(View paramView)
  {
    if (this.a.a != null)
    {
      afce localafce = (afce)this.a.a.get();
      if (localafce != null) {
        return localafce.onLongClick(paramView);
      }
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bciu
 * JD-Core Version:    0.7.0.1
 */