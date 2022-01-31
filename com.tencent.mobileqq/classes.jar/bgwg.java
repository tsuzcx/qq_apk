import android.view.View;
import android.view.View.OnClickListener;

class bgwg
  implements View.OnClickListener
{
  bgwg(bgwe parambgwe) {}
  
  public void onClick(View paramView)
  {
    if (bgwe.a(this.a))
    {
      if (bgwe.b(this.a)) {
        this.a.dismiss();
      }
      if (bgwe.b(this.a) != null) {
        bgwe.b(this.a).onClick(paramView);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bgwg
 * JD-Core Version:    0.7.0.1
 */