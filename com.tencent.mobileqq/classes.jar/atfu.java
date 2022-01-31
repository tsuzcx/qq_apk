import android.view.View;
import android.view.View.OnClickListener;

class atfu
  implements View.OnClickListener
{
  atfu(atft paramatft) {}
  
  public void onClick(View paramView)
  {
    if ((this.a.a != null) && ((paramView.getTag() instanceof atfv)))
    {
      paramView = (atfv)paramView.getTag();
      this.a.a.a(paramView);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     atfu
 * JD-Core Version:    0.7.0.1
 */