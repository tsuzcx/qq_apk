import android.view.View;
import android.view.View.OnClickListener;

class atcd
  implements View.OnClickListener
{
  atcd(atcc paramatcc) {}
  
  public void onClick(View paramView)
  {
    if (((paramView.getTag() instanceof atce)) && (this.a.a != null))
    {
      atce localatce = (atce)paramView.getTag();
      this.a.a.a(this.a, paramView, localatce);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     atcd
 * JD-Core Version:    0.7.0.1
 */