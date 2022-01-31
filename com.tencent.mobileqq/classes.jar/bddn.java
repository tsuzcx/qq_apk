import android.app.Dialog;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.app.BaseActivity;

class bddn
  implements View.OnClickListener
{
  bddn(bddb parambddb) {}
  
  public void onClick(View paramView)
  {
    if ((bddb.a(this.a) != null) && (bddb.a(this.a).isShowing())) {
      bddb.a(this.a).dismiss();
    }
    ((BaseActivity)this.a.a).finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     bddn
 * JD-Core Version:    0.7.0.1
 */