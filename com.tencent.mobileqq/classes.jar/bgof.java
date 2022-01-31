import android.view.View;
import android.view.View.OnClickListener;

class bgof
  implements View.OnClickListener
{
  bgof(bgob parambgob) {}
  
  public void onClick(View paramView)
  {
    this.a.dismiss();
    if (bgob.a(this.a) != null) {
      bgob.a(this.a).onDismiss();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bgof
 * JD-Core Version:    0.7.0.1
 */