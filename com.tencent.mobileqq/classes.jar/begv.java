import android.view.View;
import android.view.View.OnClickListener;

class begv
  implements View.OnClickListener
{
  begv(begr parambegr) {}
  
  public void onClick(View paramView)
  {
    this.a.dismiss();
    if (begr.a(this.a) != null) {
      begr.a(this.a).onDismiss();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     begv
 * JD-Core Version:    0.7.0.1
 */