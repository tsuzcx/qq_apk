import android.view.View;
import android.view.View.OnLongClickListener;
import java.lang.ref.WeakReference;

class bdqj
  implements View.OnLongClickListener
{
  bdqj(bdqi parambdqi) {}
  
  public boolean onLongClick(View paramView)
  {
    if (this.a.a != null)
    {
      agjk localagjk = (agjk)this.a.a.get();
      if (localagjk != null) {
        return localagjk.onLongClick(paramView);
      }
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bdqj
 * JD-Core Version:    0.7.0.1
 */