import android.view.View;
import android.view.View.OnClickListener;

class aucx
  implements View.OnClickListener
{
  aucx(aucw paramaucw) {}
  
  public void onClick(View paramView)
  {
    if ((this.a.a != null) && ((paramView.getTag() instanceof aucy)))
    {
      paramView = (aucy)paramView.getTag();
      this.a.a.a(paramView);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aucx
 * JD-Core Version:    0.7.0.1
 */