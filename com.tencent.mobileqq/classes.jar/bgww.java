import android.view.View;
import android.view.View.OnClickListener;

class bgww
  implements View.OnClickListener
{
  bgww(bgwv parambgwv) {}
  
  public void onClick(View paramView)
  {
    if (bgwv.a(this.a))
    {
      if (bgwv.b(this.a)) {
        this.a.dismiss();
      }
      if (bgwv.a(this.a) != null) {
        bgwv.a(this.a).onClick(paramView);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bgww
 * JD-Core Version:    0.7.0.1
 */