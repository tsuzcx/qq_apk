import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.qqstory.view.PressDarkImageButton;

class bjsa
  implements View.OnClickListener
{
  bjsa(bjrz parambjrz) {}
  
  public void onClick(View paramView)
  {
    if (bjrz.a(this.a))
    {
      bjrz.a(this.a, false);
      bjrz.a(this.a).setChecked(false);
      return;
    }
    bjrz.a(this.a, true);
    bjrz.a(this.a).setChecked(true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     bjsa
 * JD-Core Version:    0.7.0.1
 */