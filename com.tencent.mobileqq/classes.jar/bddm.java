import android.app.Dialog;
import android.view.View;
import android.view.View.OnClickListener;

class bddm
  implements View.OnClickListener
{
  bddm(bddb parambddb) {}
  
  public void onClick(View paramView)
  {
    if ((bddb.a(this.a) != null) && (bddb.a(this.a).isShowing())) {
      bddb.a(this.a).dismiss();
    }
    bddb.a(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     bddm
 * JD-Core Version:    0.7.0.1
 */