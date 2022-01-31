import android.view.View;
import android.view.View.OnLongClickListener;
import java.lang.ref.WeakReference;

class azsh
  implements View.OnLongClickListener
{
  azsh(azsg paramazsg) {}
  
  public boolean onLongClick(View paramView)
  {
    if (this.a.a != null)
    {
      aeov localaeov = (aeov)this.a.a.get();
      if (localaeov != null) {
        return localaeov.onLongClick(paramView);
      }
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     azsh
 * JD-Core Version:    0.7.0.1
 */