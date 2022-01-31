import android.view.View;
import android.view.View.OnClickListener;

class aucv
  implements View.OnClickListener
{
  aucv(aucu paramaucu) {}
  
  public void onClick(View paramView)
  {
    if ((this.a.a != null) && ((paramView.getTag() instanceof aucw)))
    {
      paramView = (aucw)paramView.getTag();
      this.a.a.a(paramView);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aucv
 * JD-Core Version:    0.7.0.1
 */