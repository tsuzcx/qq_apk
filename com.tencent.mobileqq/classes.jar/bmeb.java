import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.qqstory.view.PressDarkImageButton;

class bmeb
  implements View.OnClickListener
{
  bmeb(bmea parambmea) {}
  
  public void onClick(View paramView)
  {
    if (bmea.a(this.a))
    {
      bmea.a(this.a, false);
      bmea.a(this.a).setChecked(false);
      return;
    }
    bmea.a(this.a, true);
    bmea.a(this.a).setChecked(true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bmeb
 * JD-Core Version:    0.7.0.1
 */