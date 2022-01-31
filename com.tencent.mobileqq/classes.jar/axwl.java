import android.view.View;
import android.view.View.OnLongClickListener;
import java.lang.ref.WeakReference;

class axwl
  implements View.OnLongClickListener
{
  axwl(axwk paramaxwk) {}
  
  public boolean onLongClick(View paramView)
  {
    if (this.a.a != null)
    {
      acxn localacxn = (acxn)this.a.a.get();
      if (localacxn != null) {
        return localacxn.onLongClick(paramView);
      }
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     axwl
 * JD-Core Version:    0.7.0.1
 */