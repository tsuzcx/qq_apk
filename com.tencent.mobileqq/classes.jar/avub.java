import android.view.View;
import android.view.View.OnClickListener;

class avub
  implements View.OnClickListener
{
  avub(avua paramavua) {}
  
  public void onClick(View paramView)
  {
    if ((this.a.a != null) && ((paramView.getTag() instanceof avuc)))
    {
      paramView = (avuc)paramView.getTag();
      this.a.a.a(paramView);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     avub
 * JD-Core Version:    0.7.0.1
 */