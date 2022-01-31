import android.view.View;
import android.view.View.OnLongClickListener;
import com.tencent.mobileqq.multicard.MultiCardItemFragment;
import java.lang.ref.WeakReference;

class asrr
  implements View.OnLongClickListener
{
  asrr(asrq paramasrq) {}
  
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     asrr
 * JD-Core Version:    0.7.0.1
 */