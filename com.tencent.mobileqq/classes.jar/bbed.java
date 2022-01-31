import android.app.Dialog;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.app.BaseActivity;

class bbed
  implements View.OnClickListener
{
  bbed(bbds parambbds) {}
  
  public void onClick(View paramView)
  {
    if ((bbds.a(this.a) != null) && (bbds.a(this.a).isShowing())) {
      bbds.a(this.a).dismiss();
    }
    ((BaseActivity)this.a.a).finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     bbed
 * JD-Core Version:    0.7.0.1
 */