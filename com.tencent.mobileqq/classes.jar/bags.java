import android.view.View;
import android.view.View.OnClickListener;

class bags
  implements View.OnClickListener
{
  bags(bagr parambagr) {}
  
  public void onClick(View paramView)
  {
    if (bagr.a(this.a).isShowing()) {
      bagr.a(this.a).dismiss();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bags
 * JD-Core Version:    0.7.0.1
 */