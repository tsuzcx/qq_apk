import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.qqstory.view.PressDarkImageButton;

class bibd
  implements View.OnClickListener
{
  bibd(bibc parambibc) {}
  
  public void onClick(View paramView)
  {
    if (bibc.a(this.a))
    {
      bibc.a(this.a, false);
      bibc.a(this.a).setChecked(false);
      return;
    }
    bibc.a(this.a, true);
    bibc.a(this.a).setChecked(true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     bibd
 * JD-Core Version:    0.7.0.1
 */