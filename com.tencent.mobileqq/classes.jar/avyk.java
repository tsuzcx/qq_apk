import android.view.View;
import android.view.View.OnClickListener;

class avyk
  implements View.OnClickListener
{
  avyk(avyj paramavyj) {}
  
  public void onClick(View paramView)
  {
    if ((this.a.a != null) && ((paramView.getTag() instanceof avyl)))
    {
      paramView = (avyl)paramView.getTag();
      this.a.a.a(paramView);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     avyk
 * JD-Core Version:    0.7.0.1
 */