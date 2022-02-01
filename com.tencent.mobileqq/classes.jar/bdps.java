import android.view.View;
import android.view.View.OnLongClickListener;
import java.lang.ref.WeakReference;

class bdps
  implements View.OnLongClickListener
{
  bdps(bdpr parambdpr) {}
  
  public boolean onLongClick(View paramView)
  {
    if (this.a.a != null)
    {
      aftk localaftk = (aftk)this.a.a.get();
      if (localaftk != null) {
        return localaftk.onLongClick(paramView);
      }
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bdps
 * JD-Core Version:    0.7.0.1
 */