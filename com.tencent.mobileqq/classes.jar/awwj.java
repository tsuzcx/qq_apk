import android.view.View;
import android.view.View.OnLongClickListener;
import java.lang.ref.WeakReference;

class awwj
  implements View.OnLongClickListener
{
  awwj(awwi paramawwi) {}
  
  public boolean onLongClick(View paramView)
  {
    if (this.a.a != null)
    {
      acmv localacmv = (acmv)this.a.a.get();
      if (localacmv != null) {
        return localacmv.onLongClick(paramView);
      }
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     awwj
 * JD-Core Version:    0.7.0.1
 */