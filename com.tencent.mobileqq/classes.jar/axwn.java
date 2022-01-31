import android.view.View;
import android.view.View.OnLongClickListener;
import java.lang.ref.WeakReference;

class axwn
  implements View.OnLongClickListener
{
  axwn(axwm paramaxwm) {}
  
  public boolean onLongClick(View paramView)
  {
    if (this.a.a != null)
    {
      acxj localacxj = (acxj)this.a.a.get();
      if (localacxj != null) {
        return localacxj.onLongClick(paramView);
      }
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     axwn
 * JD-Core Version:    0.7.0.1
 */