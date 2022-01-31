import android.view.View;
import android.view.View.OnClickListener;

class atyh
  implements View.OnClickListener
{
  atyh(atyg paramatyg) {}
  
  public void onClick(View paramView)
  {
    if (((paramView.getTag() instanceof atyi)) && (this.a.a != null))
    {
      atyi localatyi = (atyi)paramView.getTag();
      this.a.a.a(this.a, paramView, localatyi);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     atyh
 * JD-Core Version:    0.7.0.1
 */