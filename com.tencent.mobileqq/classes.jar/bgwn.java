import android.view.View;
import android.view.View.OnClickListener;

class bgwn
  implements View.OnClickListener
{
  bgwn(bgwm parambgwm) {}
  
  public void onClick(View paramView)
  {
    if (bgwm.a(this.a).isShowing()) {
      bgwm.a(this.a).dismiss();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bgwn
 * JD-Core Version:    0.7.0.1
 */