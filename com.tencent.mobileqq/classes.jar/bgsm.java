import android.view.View;
import android.view.View.OnClickListener;

class bgsm
  implements View.OnClickListener
{
  bgsm(bgsi parambgsi) {}
  
  public void onClick(View paramView)
  {
    this.a.dismiss();
    if (bgsi.a(this.a) != null) {
      bgsi.a(this.a).onDismiss();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bgsm
 * JD-Core Version:    0.7.0.1
 */