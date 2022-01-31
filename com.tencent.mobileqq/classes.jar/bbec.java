import android.app.Dialog;
import android.view.View;
import android.view.View.OnClickListener;

class bbec
  implements View.OnClickListener
{
  bbec(bbds parambbds) {}
  
  public void onClick(View paramView)
  {
    if ((bbds.a(this.a) != null) && (bbds.a(this.a).isShowing())) {
      bbds.a(this.a).dismiss();
    }
    bbds.a(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     bbec
 * JD-Core Version:    0.7.0.1
 */