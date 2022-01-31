import android.view.View;
import android.view.View.OnClickListener;

class bgvw
  implements View.OnClickListener
{
  bgvw(bgvv parambgvv) {}
  
  public void onClick(View paramView)
  {
    if (bgvv.a(this.a).isShowing()) {
      bgvv.a(this.a).dismiss();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bgvw
 * JD-Core Version:    0.7.0.1
 */