import android.view.View;
import android.view.View.OnLongClickListener;
import com.tencent.mobileqq.multicard.MultiCardItemFragment;
import java.lang.ref.WeakReference;

class awad
  implements View.OnLongClickListener
{
  awad(awac paramawac) {}
  
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     awad
 * JD-Core Version:    0.7.0.1
 */