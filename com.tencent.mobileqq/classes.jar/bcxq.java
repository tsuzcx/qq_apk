import android.view.View;
import android.view.View.OnLongClickListener;
import java.lang.ref.WeakReference;

class bcxq
  implements View.OnLongClickListener
{
  bcxq(bcxp parambcxp) {}
  
  public boolean onLongClick(View paramView)
  {
    if (this.a.a != null)
    {
      afzq localafzq = (afzq)this.a.a.get();
      if (localafzq != null) {
        return localafzq.onLongClick(paramView);
      }
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bcxq
 * JD-Core Version:    0.7.0.1
 */