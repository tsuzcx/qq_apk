import android.app.Dialog;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;

class anlg
  implements View.OnClickListener
{
  anlg(anle paramanle) {}
  
  public void onClick(View paramView)
  {
    if ((anle.a(this.a) == 0) && (!TextUtils.isEmpty(anle.b(this.a)))) {
      anle.a(this.a, null);
    }
    anle.a(this.a).dismiss();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     anlg
 * JD-Core Version:    0.7.0.1
 */