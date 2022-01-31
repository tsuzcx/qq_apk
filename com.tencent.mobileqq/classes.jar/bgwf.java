import android.view.View;
import android.view.View.OnClickListener;

class bgwf
  implements View.OnClickListener
{
  bgwf(bgwe parambgwe) {}
  
  public void onClick(View paramView)
  {
    if (bgwe.a(this.a))
    {
      if (bgwe.b(this.a)) {
        this.a.dismiss();
      }
      if (bgwe.a(this.a) != null) {
        bgwe.a(this.a).onClick(paramView);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bgwf
 * JD-Core Version:    0.7.0.1
 */