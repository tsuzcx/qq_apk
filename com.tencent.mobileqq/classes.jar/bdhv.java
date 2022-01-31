import android.app.Dialog;
import android.view.View;
import android.view.View.OnClickListener;

class bdhv
  implements View.OnClickListener
{
  bdhv(bdhk parambdhk) {}
  
  public void onClick(View paramView)
  {
    if ((bdhk.a(this.a) != null) && (bdhk.a(this.a).isShowing())) {
      bdhk.a(this.a).dismiss();
    }
    bdhk.a(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     bdhv
 * JD-Core Version:    0.7.0.1
 */