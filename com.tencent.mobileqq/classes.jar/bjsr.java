import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.qqstory.view.PressDarkImageButton;

class bjsr
  implements View.OnClickListener
{
  bjsr(bjsq parambjsq) {}
  
  public void onClick(View paramView)
  {
    if (bjsq.a(this.a))
    {
      bjsq.a(this.a, false);
      bjsq.a(this.a).setChecked(false);
      return;
    }
    bjsq.a(this.a, true);
    bjsq.a(this.a).setChecked(true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     bjsr
 * JD-Core Version:    0.7.0.1
 */