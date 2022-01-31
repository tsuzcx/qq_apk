import android.view.View;
import android.view.View.OnLongClickListener;
import java.lang.ref.WeakReference;

class azwq
  implements View.OnLongClickListener
{
  azwq(azwp paramazwp) {}
  
  public boolean onLongClick(View paramView)
  {
    if (this.a.a != null)
    {
      aetk localaetk = (aetk)this.a.a.get();
      if (localaetk != null) {
        return localaetk.onLongClick(paramView);
      }
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     azwq
 * JD-Core Version:    0.7.0.1
 */