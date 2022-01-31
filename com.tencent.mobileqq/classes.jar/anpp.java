import android.app.Dialog;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;

class anpp
  implements View.OnClickListener
{
  anpp(anpn paramanpn) {}
  
  public void onClick(View paramView)
  {
    if ((anpn.a(this.a) == 0) && (!TextUtils.isEmpty(anpn.b(this.a)))) {
      anpn.a(this.a, null);
    }
    anpn.a(this.a).dismiss();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     anpp
 * JD-Core Version:    0.7.0.1
 */