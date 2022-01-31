import android.view.View;
import android.view.View.OnLongClickListener;
import com.tencent.mobileqq.multicard.MultiCardItemFragment;
import java.lang.ref.WeakReference;

class auiq
  implements View.OnLongClickListener
{
  auiq(auip paramauip) {}
  
  public boolean onLongClick(View paramView)
  {
    if (this.a.a != null)
    {
      paramView = (MultiCardItemFragment)this.a.a.get();
      if (paramView != null) {
        paramView.a(this.a);
      }
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     auiq
 * JD-Core Version:    0.7.0.1
 */