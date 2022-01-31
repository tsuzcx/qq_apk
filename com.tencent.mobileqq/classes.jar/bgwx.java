import android.view.View;
import android.view.View.OnClickListener;

class bgwx
  implements View.OnClickListener
{
  bgwx(bgwv parambgwv) {}
  
  public void onClick(View paramView)
  {
    if (bgwv.a(this.a))
    {
      if (bgwv.b(this.a)) {
        this.a.dismiss();
      }
      if (bgwv.b(this.a) != null) {
        bgwv.b(this.a).onClick(paramView);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bgwx
 * JD-Core Version:    0.7.0.1
 */