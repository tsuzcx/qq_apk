import android.app.Dialog;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.app.BaseActivity;

class bdhw
  implements View.OnClickListener
{
  bdhw(bdhk parambdhk) {}
  
  public void onClick(View paramView)
  {
    if ((bdhk.a(this.a) != null) && (bdhk.a(this.a).isShowing())) {
      bdhk.a(this.a).dismiss();
    }
    ((BaseActivity)this.a.a).finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     bdhw
 * JD-Core Version:    0.7.0.1
 */